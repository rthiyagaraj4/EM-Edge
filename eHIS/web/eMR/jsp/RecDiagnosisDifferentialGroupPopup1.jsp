<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../js/RecDiagnosis.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()'>

<form name='new_diff_group' id='new_diff_group' action='../../servlet/eMR.RecDiagnosisDiffGroupServlet' method='post' target='messageFrame'>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	PreparedStatement pstmt_extgrp = null;
	ResultSet rs_extgrp = null;
	
	String patient_id = "";
	String term_set_id = "";
	String strQry = "";
	String term_set_code = "";
	String diff_group_id	= "";
	String diag_Description	= "";
	String shortdesc	= "";
	String occur_srl_no	= "";
	String mode	= "";
	String flag	= "";

	int currentdiffid=0;
	int prevdiffid=0;
	int i=0,grpid = 0;
	int grp_id_temp=0;
	
	String classValue = "";
	String Differ_flag = "";
	
	patient_id=request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	strQry=request.getQueryString();
	term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	occur_srl_no=request.getParameter("occur_srl_no")==null?"":request.getParameter("occur_srl_no");
	diag_Description = request.getParameter("diag_Description")==null?"":request.getParameter("diag_Description");
	diag_Description=java.net.URLDecoder.decode(diag_Description);
	mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	flag = request.getParameter("flag")==null?"":request.getParameter("flag");
	if(mode.equals("") || mode.equals("R"))
		mode = "insert";
		//out.println("<script>alert(\""+diag_Description+"\");</script>");

try
	{
		con = ConnectionManager.getConnection(request);
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 1 FROM PR_DIFFERENTIAL_DIAGNOSIS ");
		sql.append("  WHERE PATIENT_ID=? AND FINALIZED_YN='N' and term_set_id=? ");

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,patient_id);
		pstmt.setString(2,term_set_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			Differ_flag = rs.getString(1);
		}
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
			
		if(Differ_flag.equals("1"))
		{
		 sql = new StringBuffer();
		 sql.append("select a.term_set_id,a.term_code,a.TERM_CODE_SHORT_DESC SHORT_DESC,C.LONG_DESC, ");
		 sql.append("a.occur_srl_no,nvl(b.diff_group_id,'0') diff_group_id from pr_diagnosis a, ");
		 sql.append("pr_differential_diagnosis b, MR_TERM_CODE C where a.patient_id = ? "); 
		 sql.append("and a.term_set_id = ? and a.curr_accuracy_ind ='U' ");
		 sql.append("and a.curr_status='A' and b.term_set_id(+)=a.term_set_id and ");
		 sql.append("b.term_code(+)=a.term_code  AND b.occur_srl_no(+) = a.occur_srl_no and "); 
		 sql.append("C.TERM_SET_ID=a.term_set_id AND C.TERM_CODE=a.term_code  AND b.patient_id(+) = a.patient_id ORDER BY "); 
		 sql.append("diff_group_id , a.term_code");

		 pstmt_extgrp=con.prepareStatement(sql.toString());
		 pstmt_extgrp.setString(1,patient_id);
		 pstmt_extgrp.setString(2,term_set_id);
		 rs_extgrp=pstmt_extgrp.executeQuery();
%>
	<table border=0  width='100%' cellpadding='0' cellspacing='0'  align=center style='border-bottom:#ffffff'>	

<%
		while(rs_extgrp.next())
		{
			shortdesc		=	 rs_extgrp.getString("SHORT_DESC")==null?"":rs_extgrp.getString("SHORT_DESC");
			currentdiffid	=	 rs_extgrp.getInt("diff_group_id");
			
			if(currentdiffid!=0)
			{
				if(i==0)
				{
					out.println("<Td class='COLUMNHEADER' colspan='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExistingDifferentialDiagnosis.label","mr_labels")+"</Td></table>"); 
				}
				classValue= ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
				out.println("<table border= 0  cellpadding='0' cellspacing='0'  width='100%' align='center' style='border-bottom:#ffffff'>");
				if(prevdiffid!=currentdiffid )
				{
					
					grpid++;
					out.println("<tr><td align='left' class='CAGROUPHEADING' colspan='2'><font color='black' size='1'>Group"+(grpid)+"</td></tr></table>");
				}
				
				out.println("<table border= 1 cellpadding='0' cellspacing='0' width='100%' align='center' style='border-bottom:#ffffff'>");
				
				out.println("<tr><td class='"+classValue+"' align = 'left'  valign='top' style='border-left: #B2B6D7' >&nbsp;&nbsp; "+shortdesc+"</td>");
				 
				
				out.println("</tr>");
				prevdiffid=currentdiffid;
				i++;
			}
		}
		
		out.println("</table>");
		
		if(rs_extgrp!=null)
			rs_extgrp.close();
		if(pstmt_extgrp!=null)
			pstmt_extgrp.close();

		%>
		<p>
		<!-- <table border=0 cellpadding=0 cellspacing=0 width='100%'>
			<th align='left' colspan='0'>Current Diagnosis</th>
			<tr><td class='label'><B><%=term_set_code%><B></td></tr>
			<tr><td class='label'>&nbsp;&nbsp;<%=diag_Description%></td></tr>
			<tr><td colspan='2'></td></tr>
		</table> -->
		<p>
		<%

		String sql_diffgrp = "select distinct diff_group_id from pr_differential_diagnosis where patient_id = ? and TERM_SET_ID=? and FINALIZED_YN='N'";
		pstmt = con.prepareStatement(sql_diffgrp);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,term_set_id);
		
		rs = pstmt.executeQuery();
	
		out.println("<table border= 0  cellpadding='0' cellspacing='0'  width='100%' align='center' style='border-bottom:#ffffff'>");
		
		out.println("<tr><Td class='COLUMNHEADER' colspan=10><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PleaseSelectGroupforthenewDiagnois.label","mr_labels")+" </b>"+diag_Description+" ?</Td></tr>");
		
		
		int j = 0;
		out.println("<tr>");
		
		while(rs.next())
		{
			diff_group_id = rs.getString("diff_group_id");
			grp_id_temp++;
			
			
			out.println("<td align='right' width='10%'><input type='radio' name='grp_id' id='grp_id'  value='"+diff_group_id+"' onClick=RecordUnassignedGrp(this,'N') ></input></td><td class='label'>Group "+grp_id_temp+"</td>");

			
			
		
			j++;
		}
		
		out.println("<td align='right' width='10%'>&nbsp;&nbsp;<input type='radio' name='grp_id' id='grp_id'  value='Create New Group' onClick=RecordUnassignedGrp(this,'N')></input></td><td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NewGroup.label","mr_labels")+"</td>");
		
		out.println("</tr>");
		out.println("</table>");

	}
	else
		out.println("<script>var error=getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');alert(error);parent.parent.document.getElementById('dialog_tag').close(); </script>");
	}
	catch(Exception e)
	{
		//out.println("Exception at try"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con != null)ConnectionManager.returnConnection(con,request);

		}
		catch(Exception e){
			//out.println("Exception in finally block"+e.toString());
			e.printStackTrace();
		}
	}
	
		 
%>
<br><br>
	<input type='hidden' name='Patient_Id' id='Patient_Id' value='<%=patient_id%>'>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='qryStr' id='qryStr' value='<%=strQry%>'>
	<input type='hidden' name='grp_mode' id='grp_mode' value=''>
	<input type='hidden' name='curr_grp_id' id='curr_grp_id' value=''>
	<input type='hidden' name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
	<input type='hidden' name='term_set_code' id='term_set_code' value='<%=term_set_code%>'>
	<input type='hidden' name='occur_srl_no' id='occur_srl_no' value='<%=occur_srl_no%>'>
	<input type='hidden' name='termValues' id='termValues' value=''>
	<input type='hidden' name='diff_mode' id='diff_mode' value='Y'>
	<input type='hidden' name='flag' id='flag' value='<%=flag%>'>

</form>	
</body>
</html>


