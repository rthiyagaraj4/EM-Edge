<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,  webbeans.eCommon.*" %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../js/RecDiagnosis.js' language='javascript'></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onKeyDown='lockKey()'>

<form name='diff_group' id='diff_group' action='../../servlet/eMR.RecDiagnosisDiffGroupServlet' method='post' target='messageFrame'>
<% 

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patient_id = "";
	String  term_set_id = "";
	String strQry = "";

 	Connection con = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	PreparedStatement grp_pstmt = null;
	ResultSet grp_rs = null;
	
	String shortdesc = "";
	String classValue = "";
	String term_code = "";
	String occur_srl_no = "";
	String termVals = "";
	String term_set_code = " ";
	StringBuffer append_grpid = new StringBuffer("");
	StringBuffer temp_grpid = new StringBuffer("");

	String style_colr = "";
	String display_mode = "";
	String chk = "";

	int diff_grp_id = 0;
	int j=0;
	int k=0;
	int cnt  = 0;
	int currentdiffid=0,prevdiffid=0;
	int i=0,grpid = 0;
	int rec_cnt = 0;

	patient_id=request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	strQry=request.getQueryString();
	term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	
	display_mode=request.getParameter("display_mode")==null?"":request.getParameter("display_mode");
	term_set_code=request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	
try
{
	 con  = ConnectionManager.getConnection(request);
	 StringBuffer sql = new StringBuffer();

	 if(sql.length() > 0) sql.delete(0,sql.length());
	 sql.append("select a.term_set_id,a.term_code,a.TERM_CODE_SHORT_DESC SHORT_DESC,C.LONG_DESC, ");
	 sql.append("a.occur_srl_no,nvl(b.diff_group_id,'0') diff_group_id from pr_diagnosis a, ");
	 sql.append("pr_differential_diagnosis b, MR_TERM_CODE C where a.patient_id = ? "); 
	 sql.append("and a.term_set_id = ? and a.curr_accuracy_ind ='U' and CURR_STATUS ='A' ");
	 sql.append("and b.term_set_id(+)=a.term_set_id and ");
	 sql.append("b.term_code(+)=a.term_code  AND b.occur_srl_no(+) = a.occur_srl_no and "); 
	 sql.append("C.TERM_SET_ID=a.term_set_id AND C.TERM_CODE=a.term_code AND b.patient_id(+) = a.patient_id ORDER BY "); 
	 sql.append("b.diff_group_id, a.term_code");
	 pstmt=con.prepareStatement(sql.toString());
	 pstmt.setString(1,patient_id);
	 pstmt.setString(2,term_set_id);
	 rs=pstmt.executeQuery();

	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append("select distinct diff_group_id from ");
	sql.append("pr_differential_diagnosis where patient_id = ? and TERM_SET_ID=? and FINALIZED_YN='N' order by diff_group_id ");
	 
	 grp_pstmt = con.prepareStatement(sql.toString());
	 grp_pstmt.setString(1,patient_id);
	 grp_pstmt.setString(2,term_set_id);
	 grp_rs = grp_pstmt.executeQuery();	

		while(grp_rs.next())
		{
			diff_grp_id = grp_rs.getInt(1);
			//if(diff_grp_id>0)
			{
				cnt++;
				append_grpid.append(diff_grp_id);
				temp_grpid.append(cnt);
				if(cnt > 0){
					append_grpid.append("|");
					temp_grpid.append("|");
				}
			}
		}
		
		if(grp_rs!=null)
				grp_rs.close();
		if(grp_pstmt!=null)
				grp_pstmt.close();

		if ( (append_grpid.toString()).equals(""))
		{	
			if ( append_grpid != null ) append_grpid.delete(0,append_grpid.length());
			append_grpid.append("0");
		}
%>
	<!-- <div align='center'> -->
	<table border=0  width='100%' cellpadding='0' cellspacing='0'  align=center style='border-bottom:#ffffff'>
	
<%	while(rs.next())
	{
		rec_cnt++;
		shortdesc			= rs.getString("SHORT_DESC");
		currentdiffid		= rs.getInt("diff_group_id");
		term_code	    = rs.getString("term_code");
		occur_srl_no	    = rs.getString("occur_srl_no");
		
		termVals        = term_set_id+"|"+term_code+"|"+occur_srl_no+"|"+currentdiffid;
		termVals		=java.net.URLEncoder.encode(termVals);

		if(term_set_code.equals(term_code) && display_mode.equals("result_page")){
			style_colr = "RED";
			chk = "checked";
		}
		else{
			style_colr = "";
			chk = "";
		}

		if(currentdiffid!=0)
		{	
			if(j==0)
			{
				out.println("<Td class='COLUMNHEADER' colspan='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DifferentialDiagnosis.label","mr_labels")+"</Td></table>"); 
			}
			classValue= ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
			out.println("<table border= 1  cellpadding='0' cellspacing='0'  width='100%' align='center' style='border-bottom:#ffffff'>");
			if(prevdiffid!=currentdiffid)
			{
				grpid++;
				out.println("<tr><td align='left' class='CAGROUPHEADING' colspan='2'><font color='black' size='1'>Group"+(grpid)+"</td></tr></table>");
			}
			out.println("<table border= 1 cellpadding='0' cellspacing='0' width='100%' align='center' style='border-bottom:#ffffff';");
			out.println("<tr><td class='"+classValue+"'  width='5%'><input type='checkbox' name ='termvals' id='"+(grpid)+ "' value='"+termVals+"' " +chk+" Onclick=\"return CheckMultiSelect('"+grpid+"')\"></td><td class='"+classValue+"' align = 'left'  valign='top' style='border-left: #B2B6D7;' >");
			out.println("<a href='javascript:' onClick=displayToolTip('"+termVals+"','"+append_grpid.toString()+"','"+currentdiffid+"','"+grpid+"','"+temp_grpid.toString()+"','U') onMouseOver='hideToolTip()'><font color='"+style_colr+"'> "+shortdesc+"</font></td>");
			out.println("</tr>");
			prevdiffid=currentdiffid;
			j++;
		}
			
	   if(currentdiffid==0)
	   {
		   if(k==0)
			 {
			out.println("<table border= 1 width='100%' cellpadding='0' cellspacing='0' align='center' style='border-bottom:#ffffff'>");
			out.println("<Td class='COLUMNHEADER' colspan='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.UngroupDiagnosis.label","mr_labels")+"</Td></table>"); 
			 }
			classValue= ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
			out.println("<table border= 1 cellpadding='0' cellspacing='0' width='100%' align='center' style='border-bottom:#ffffff'>");
			out.println("<tr>");
			out.println("<td class='"+classValue+"' width='5%'><input type='checkbox' name ='termvals' " +chk+" value='"+termVals+"'></td>");
			out.println("<td class='"+classValue+"' align = 'left  valign='top' style='border-left:#B2B6D7;'><a href='javascript:' onClick=displayToolTip('"+termVals+"','"+append_grpid.toString()+"','"+currentdiffid+"','"+grpid+"','"+temp_grpid.toString()+"','N') onMouseOver='hideToolTip()'><font color='"+style_colr+"'>"+shortdesc+"</font></td>");
		  	out.println("</tr>");
			k++;
		}
	   i++;
	}
	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

		if(i==0)
		out.println("<script>var error=getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');alert(error); parent.parent.document.getElementById('dialog_tag').close(); </script>");
		out.println("<input type='hidden' name='countTermVal' id='countTermVal' value='"+k+"'>");
	%>
	</table>
	
	<% 
} 
	catch(Exception e)
	{
		//out.println("Exception in try@:"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
	<br><br>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' >
	<tr><td width='100%' id='t'></td></tr>
	</table>
	</div>	
	
	<input type='hidden' name='Patient_Id' id='Patient_Id' value='<%=patient_id%>'>
	<input type='hidden' name='mode' id='mode' value=''>
	<input type='hidden' name='qryStr' id='qryStr' value='<%=strQry%>'>
	<input type='hidden' name='grp_mode' id='grp_mode' value=''>
	<input type='hidden' name='curr_grp_id' id='curr_grp_id' value=''>
	<input type='hidden' name='diff_mode' id='diff_mode' value='N'>
	<input type='hidden' name='record_count' id='record_count' value='<%=rec_cnt%>'>
	<input type='hidden' name='group_count' id='group_count' value='<%=cnt%>'>
	<input type='hidden' name='termValues' id='termValues' value=''>
</form>
</body>
</html>

