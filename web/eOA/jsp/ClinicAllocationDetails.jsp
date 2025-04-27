<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,java.io.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<title>Allocation Details</title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script>
<script src='../../eOA/js/ChangeDate.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection conn	=null; 
Statement  stmt	=null;
ResultSet  rSet	=null;
PreparedStatement pstmt=null;
String alcn_code="";
String max_pat="";
String tot_book_pat="";
String tot_block_slot="";
String alcn_grp_desc="";
int balance=0;
String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
String clinic_code=(String)(request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code"));
String clinic_date=(String)(request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date"));
String practitioner_id=(String)(request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id"));
String group_sql="select ALCN_CATG_CODE,MAX_PATIENTS,TOTAL_BOOKED_PATIENTS,TOTAL_BLOCKED_SLOTS from oa_clinic_schedule_dtl where clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
try{
	conn=ConnectionManager.getConnection(request);
%>
<body  OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
<table border=1 cellpadding=0 cellspacing=0 width='100%' align='center'>
<tr>
<br>
<th align='middle' ><div class='myClass' nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></div></th>
<th align='middle' ><div class='myClass' nowrap><fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Patients.label" bundle="${common_labels}"/></div></th>
<th align='middle' ><div class='myClass' nowrap ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.booked.label" bundle="${common_labels}"/></div></th>
<th align='middle' ><div class='myClass' nowrap ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.blocked.label" bundle="${common_labels}"/></div></th>
<th align='middle' ><div class='myClass' nowrap ><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></div></th>
</tr>
<%
   // stmt=conn.createStatement();
	//rSet=stmt.executeQuery(group_sql);
	pstmt = conn.prepareStatement(group_sql);
	pstmt.setString(1,clinic_date);
	pstmt.setString(2,facilityid);
	pstmt.setString(3,clinic_code);
	pstmt.setString(4,practitioner_id);
	rSet = pstmt.executeQuery();
	while(rSet!=null && rSet.next()){
		 alcn_code=rSet.getString("ALCN_CATG_CODE");
		 max_pat=rSet.getString("MAX_PATIENTS");
		 tot_book_pat=rSet.getString("TOTAL_BOOKED_PATIENTS");
		 tot_block_slot=rSet.getString("TOTAL_BLOCKED_SLOTS");
		 balance=Integer.parseInt(max_pat)-(Integer.parseInt(tot_book_pat)+Integer.parseInt(tot_block_slot));
		 if(alcn_code.equals("*O")){
			 alcn_grp_desc="Others";
		 }else{
			 alcn_grp_desc=alcn_code;
		 }
 %>
        <tr>
		<td class='label' align='left'><%=alcn_grp_desc%></td>
		<td class='label' align='middle'><%=max_pat%></td>
		<td class='label' align='middle'><%=tot_book_pat%></td>
		<td class='label' align='middle'><%=tot_block_slot%></td>
		<td class='label' align='middle'><%= balance%></td>
		</tr>
	<%}%>
	</table>
<br><br><br><br><br><br>
<table border=0 cellpadding=0 cellspacing=0 width='100%' align='center'>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td class='button'><input type='button' name='close' id='close' value='Close' class="BUTTON" onclick='window.close()'></td>
</tr>
</table>
</body>
<%
	 if(rSet!=null) rSet.close();
if(stmt!=null) stmt.close();
}catch(Exception exception){
	exception.printStackTrace();
}finally{
	ConnectionManager.returnConnection(conn,request);
}
%>
</html>

