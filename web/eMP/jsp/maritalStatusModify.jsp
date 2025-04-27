<!DOCTYPE html>
<%--
/**
  *
  * @filename maritalStatusModify.jsp
  * @version 3.0 updated on 2/17/2005
  */
--%>

<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%!
	public boolean datecompare(java.util.Date dt) {
		java.util.Date systemdate=new java.util.Date();
		if(dt.before(systemdate)) return true;
		else return false;
	}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%
	String marital_status_code = request.getParameter("marital_status_code");
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	Connection conn = null;
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy");
	//java.util.Date currentdate=new java.util.Date();
	String dateString="",eff_status="",mod_prop="";
	//String sysdt=formatter.format(currentdate);

	try{
		//Connection conn = (Connection) session.getValue( "connection" );
		conn = ConnectionManager.getConnection(request);
		StringBuffer sbQuery = new StringBuffer("select mar_status_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_marital_status where mar_status_code=?");
		//sbQuery.append(marital_status_code);
		//sbQuery.append("'");
		//String sql = "select mar_status_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_marital_status where mar_status_code='"+marital_status_code+"'";
		pstmt = conn.prepareStatement(sbQuery.toString());
		pstmt.setString(1, marital_status_code); // Added by lakshmanan for security issue ID 174301683 on 04-09-2023
		rset = pstmt.executeQuery();
		rset.next();
		eff_status=rset.getString("eff_status");
		//out.println("<script>alert('"+eff_status+"');</script>");
		if(eff_status.equals("D")){
			mod_prop="readonly";
		}
		//out.println("<script>alert('"+mod_prop+"');</script>");
%>
		<form name='marital_status_form' id='marital_status_form' action='../../servlet/eMP.MaritalStatusServlet' method='post' target='messageFrame'>
			<BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<div align='left'>
				<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
					<tr>
						<td width='40%'>&nbsp;</td>
						<td width='60%' colspan='2'>&nbsp;</td>
					</tr>
					<tr>
						<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class='fields' width='60%' colspan='2'>&nbsp;&nbsp;

			<input type='text' name='mar_status_code' id='mar_status_code' value="<%=rset.getString("mar_status_code")%>" size='1' readonly>
			<img src='../images/mandatory.gif'></img>
<%	//if ( rset.getString("eff_status").equals("E") )
		//{

			out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'>&nbsp;&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size='30'  maxlength='30' onBlur='makeValidString(this)' value=\""+rset.getString("long_desc")+"\" "+mod_prop+">");
			
			out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+" </td><td  class='fields' width='60%' colspan='2'>&nbsp;&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"");
			out.println(rset.getString("short_desc"));
			out.println("\" "+mod_prop+"> <img src='../images/mandatory.gif'></img></td></tr>");
			/*out.println("<tr><td width='40%'  class='label'>Effective From </td><td width='13%' >&nbsp;&nbsp;&nbsp;*/
			out.print("<input type='hidden' name='eff_date_from' id='eff_date_from' size='10' maxlength ='10' value='");
			if ( rset.getDate("eff_date_from") != null ){
				java.util.Date date = rset.getDate("eff_date_from");
				dateString = formatter.format(date);
				//if(datecompare(date)) out.println(dateString + "' ");
				//else out.println(dateString + "' onblur=CheckDate(this,'<','" + sysdt +"','chksysdt') ");
				out.print(dateString + "' >");
				//out.print(dateString + "' onblur=CheckDate(this,'<','" + sysdt +"','chksysdt')  >");
				out.print("<input type='hidden' name='eff_date_from1' id='eff_date_from1' value='"+dateString+"'>");
				date = null;
			}else{
				out.print("'  >");
				//out.print("' onblur=CheckDate(this,'<','" + sysdt +"','chksysdt') >");
				out.print("<input type='hidden' name='eff_date_from1' id='eff_date_from1'>");	
			}	
			/*out.println("</td> <td width='47%'  class='label'>&nbsp;&nbsp;To &nbsp;&nbsp;");*/
			out.print("<input type='hidden' name='eff_date_to' id='eff_date_to' size='10' maxlength ='10' value='");
			if ( rset.getDate("eff_date_to") != null){
				 java.util.Date date1 = rset.getDate("eff_date_to");
				 dateString = formatter.format(date1);
				//if(datecompare(date1)) out.println(dateString + "'");
				//else out.println(dateString + "' onblur=CheckDate(this,'<','" + sysdt +"','chksysdt') ");
				//out.print(dateString + "' onblur=CheckDate(this,'<','" + sysdt +"','chksysdt') >");
				out.print(dateString + "'  >");
				out.print("<input type='hidden' name='eff_date_to1' id='eff_date_to1' value='"+dateString+"' >");
				date1 = null;
			}else{
				//out.print("' onblur=CheckDate(this,'<','" + sysdt +"','chksysdt') >");
				out.print("'  >");
				out.print("<input type='hidden' name='eff_date_to1' id='eff_date_to1'>");
			}
			/*out.println("</td></tr>");
			out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/
			out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E'");
			//String eff_status = rset.getString("eff_status");
			if  ( eff_status.equals("E") )
				out.println("checked >");
			else
				out.println(">");
			out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
		//}
		if ( rset != null ) rset.close() ;
		if ( pstmt != null ) pstmt.close() ;
	}catch ( Exception e ){
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
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

