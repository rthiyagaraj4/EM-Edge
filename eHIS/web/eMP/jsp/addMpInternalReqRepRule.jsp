<!DOCTYPE html>
<!-- Latest Modified Date Time : 9/30/2005 10:54 AM -->
<%@ page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet,java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	Connection conn			= null;
	java.sql.Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;

	String  reportdesc			= "";
	String  reportid			= "";
	String focus				= "";
	String pshortdesc			= "";
	String pseriescode			= "";
	String maintain_doc_or_file = "";
	
	StringBuffer str1 = null;
	StringBuffer str2 = null;

	str1 = new StringBuffer();
	str2 = new StringBuffer();

	boolean newReqType = false;

	reportid	= request.getParameter("report_id");
	reportdesc	= request.getParameter("report_desc");
	pseriescode	= request.getParameter("pat_ser_grp_code");
	pshortdesc	= request.getParameter("short_desc");

	conn = ConnectionManager.getConnection(request);
	
	stmt = conn.createStatement();
	rset = stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param");
	if(rset.next())
	{
		maintain_doc_or_file = rset.getString(1);
		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 
			maintain_doc_or_file = "F";
	}
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
	if(reportid == null && reportdesc == null && pseriescode == null && pshortdesc == null)
	{
		try
		{
			if(maintain_doc_or_file.equals("D"))
			{
				if(pstmt!=null) pstmt.close();
				pstmt = conn.prepareStatement("SELECT report_id, report_desc FROM sm_report WHERE module_id = 'MP' AND internal_request_yn = 'Y' AND report_id != 'MPBFLLBL' ORDER BY report_desc");
			}
			else
			{
				if(pstmt!=null) pstmt.close();
				pstmt = conn.prepareStatement("select REPORT_ID,REPORT_DESC from sm_report where module_id='MP' and INTERNAL_REQUEST_YN='Y' order by report_desc");
			}
			rset = pstmt.executeQuery();
			focus ="Focusing('report_id')";
			str1.append(" <select name='report_id' id='report_id'><option value='' selected>------------------------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------------</option> ");
			while(rset.next())
			{
				reportid=rset.getString("REPORT_ID");
				reportdesc=rset.getString("REPORT_DESC");
				str1.append(" <option value=\""+reportid+"\">"+reportdesc+"</option> ");
			}
			str1.append(" </select> ");
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt = conn.prepareStatement( "select pat_ser_grp_code,short_desc from mp_pat_ser_grp order by short_desc");
			rset = pstmt.executeQuery();
			str2.append(" <select name='pat_ser_grp_code' id='pat_ser_grp_code'><option value='' selected>------------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------</option> ");
			while(rset.next())
			{
				pseriescode=rset.getString("pat_ser_grp_code");
				pshortdesc=rset.getString("short_desc");
				str2.append(" <option value=\""+pseriescode+"\">"+pshortdesc+"</append> ");
			}
			str2.append(" </select> ");
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();
			
				
		}catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174072332 on 28-08-2023
			}
		finally
		{
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}

		newReqType=true;
	}
	else
	{
		newReqType=false;
		
		try
		{
			pstmt = conn.prepareStatement("select report_id,report_desc,pat_ser_grp_code,short_desc from mp_online_reports_vw where report_id=? and pat_ser_grp_code=? ");
			pstmt.setString(1, reportid);
			pstmt.setString(2,pseriescode);
			rset = pstmt.executeQuery();
			rset.next();
			reportid	= rset.getString("report_id");
			reportdesc	= rset.getString("report_desc");
			pseriescode	= rset.getString("pat_ser_grp_code");
			pshortdesc	= rset.getString("short_desc");

			str1.append(" <input type='text' name='report_desc' id='report_desc' value=\""+reportdesc+"\" size='30' maxlength='30' READONLY> ");

			str2.append(" <input type='text' name='short_desc' id='short_desc' value=\""+pshortdesc+"\" size='15' maxlength='15' READONLY> ");

			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();
		}catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174072333 on 28-08-2023
			}
		finally
		{
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}
	}//end else
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
      <head>
      	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	  </head>

      <body OnMouseDown='CodeArrest()' onKeyDown='lockKey();' onLoad="<%=focus%>">
      	<form name='MpInternalReqRepRule_Form' id='MpInternalReqRepRule_Form' action='../../servlet/eMP.MpInternalReqRepRuleServlet' method='post' target='messageFrame'>
      	<div align='left'><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
      	<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			<TR><td class=label colspan='3'>&nbsp;</td></TR>
      		<tr>
      		    <td  width='40%' class='label'><fmt:message key="eMP.InternalRequestReport.label" bundle="${mp_labels}"/></td>
      		    <td width='60%' colspan='2' class="fields"><%=str1.toString()%><img src='../images/mandatory.gif'></img></td>
      		</tr>
     		<tr>
      		    <td  width='40%' class=label><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
      		    <td width='60%' colspan='2' class="fields"><%=str2.toString()%>
      		    <img src='../images/mandatory.gif'></img></td>
      		</tr>
      		<TR><td class=label colspan='3'>&nbsp;</td></TR>
      	</table>
      	</div>
		<%
		if(newReqType)
		{
			%>
      		<input type='hidden' name='function' id='function' value='insert'>
	      	<input type='hidden' name='function_name' id='function_name' value='insert'>
		  	<input type='hidden' name='print_req_yn' id='print_req_yn' value='Y'>
		    <%
		}
		else
		{
			%>
     	 	<input type='hidden' name='function' id='function'>
      		<input type='hidden' name='function_name' id='function_name'>
      		<input type='hidden' name='report_id' id='report_id' value="<%=reportid%>">
      		<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value="<%=pseriescode%>">
		    <%
		}

		if(str1 != null && str1.length() > 0)
		{
			str1.delete(0, str1.length());
		}
		if(str2 != null && str2.length() > 0)
		{
			str2.delete(0, str2.length());
		}
		%>
      	</form>
  	</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

