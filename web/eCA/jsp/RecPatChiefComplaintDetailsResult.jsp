<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<%

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
    PreparedStatement pstmt =null;
	ResultSet rs =null ;
	Connection con          = null; 
	String complaint_desc = "";
	String remarks = "";
	
	//String complaint_text	= request.getParameter("complaint_text")==null?"":request.getParameter("complaint_text");
	String complaint_id =  request.getParameter("complaint_id")==null?"":request.getParameter("complaint_id");
	String encounter_id =  request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String facility_id =  request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	//String remarks			= request.getParameter("remarks")==null?"":request.getParameter("remarks");
    //String complaint_desc	= request.getParameter("complaint_desc")==null?"":request.getParameter("complaint_desc");

	//complaint_text = java.net.URLDecoder.decode(complaint_text,"UTF-8");

	try
	{
		con = ConnectionManager.getConnection(request);
		String comp_desc = "select complaint_desc,remarks from ca_encntr_chief_complaint  where FACILITY_ID =? and ENCOUNTER_ID =? and  complaint_id=? ";
			
		pstmt= con.prepareStatement(comp_desc);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,encounter_id);
		pstmt.setString(3,complaint_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
		    complaint_desc =rs.getString("complaint_desc")==null?"":rs.getString("complaint_desc");
			remarks =rs.getString("remarks")==null?"":rs.getString("remarks");		
				
			}
		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();


%>

</head>
<body onKeyDown='lockKey()'>
<form>
<table cellspacing = 0 cellpadding='3' width='100%' align='center' border=0>

<td class='COLUMNHEADER' colspan=2><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
<tr><td colspan=2>&nbsp;</td></tr>
<tr><td class='label' colspan=2><b><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></b></td></tr>
<tr align='left'>
	<td width='10%'>&nbsp;</td><td class ='fields' width='100%'><textarea name='comp_dtls' rows=7 cols='60' readOnly><%=complaint_desc%></textarea></td>
</tr>

<tr><td class='label'  colspan=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></b></td></tr>
<tr align='left'>
	<td>&nbsp;</td><td width='100%' class ='fields'><textarea name='remarks' rows=9 cols='60' readOnly><%=remarks%></textarea></td>
</tr>
<tr><td colspan=2>&nbsp;</td></tr>
<tr><td colspan=2>&nbsp;</td></tr>

</table>
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		//out.println("Exception @ RecPatChiefComplaintDetailsResult.jsp "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>

