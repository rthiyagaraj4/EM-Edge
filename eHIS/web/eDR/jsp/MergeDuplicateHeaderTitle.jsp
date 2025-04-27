<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<html>
<head>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='group_header_title' id='group_header_title'>
<%
	Connection con				= null;
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;	
	ResultSet rs  				= null;
	
	
	String facilityid	= (String) session.getValue("facility_id");

	String fromPage		= request.getParameter("fromPage");
	String facility		= request.getParameter("facility1");
	String p_patient_id	= request.getParameter("patient_id");

	if(fromPage == null) fromPage = "";
	if(facility == null) facility = "";
	if(p_patient_id == null) p_patient_id = "";

	String grp_no	= "0";
	String sql1		= "";

	try
	{	
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(fromPage.equals("2"))
		{
			sql1 = "SELECT count(1) AS total FROM dr_dup_group_vw2 WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N' AND added_facility_id = nvl('"+facility+"', added_facility_id) AND patient_id = nvl('"+p_patient_id+"', patient_id)";
		}
		else
		{
			sql1="SELECT count(1) AS total FROM dr_dup_group_vw2 WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N' AND added_facility_id = nvl('"+facilityid+"', added_facility_id) AND patient_id = nvl('"+p_patient_id+"',patient_id) ";
		}
		rs    = stmt.executeQuery(sql1);
		while(rs.next())
		{
			grp_no = rs.getString("total");	
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();
	%>
	
		<table border='0' width='100%' cellspacing='0' id='tb1'>
			<tr>
				<td class='label' width='80%'></td>
				<td class='label' width='5%'></td>
				<td class='label' width='10%'></td>
			</tr>
		
			<tr><th class='columnheader' colspan='2'> <fmt:message key="eDR.DuplicateGroups.label" bundle="${dr_labels}"/></th></tr>

			<tr><td colspan='2' class ='QUERYDATA'><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/> =<%=grp_no%></td></tr>	
			
			<tr>
				<th class='columnheader'><fmt:message key="eDR.MainPatientID.label" bundle="${dr_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.count.label" bundle="${common_labels}"/></th>
			</tr>
		
		</table>
		 <input type='hidden' name='CheckBoxes' id='CheckBoxes' value="">
		 <input type='hidden' name="selAll" id="selAll" value="">
		 <input type='hidden' name="dup_group_id" id="dup_group_id" value=''>
		 
	  </form>
	<%
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

