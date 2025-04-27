
<!DOCTYPE html>
<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eOA.Overlap.label" bundle="${oa_labels}"/></title>
	
<head>
<%
	  request.setCharacterEncoding("UTF-8");    
	   String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 =null;
		int i=1;
		String classval = "label";

%>

 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script>
function doClose(){
   window.close();
}
</script>

</head>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();">
<form name='generateDetail' id='generateDetail' id='web_result' method='post'>
<div>
<table width='100%' align="center" border = "1" style = "border-collapse: collapse;" cellspacing="0">
 <thead>
  <tr>
    <th class='columnheadercenter'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></th>
    <th class='columnheadercenter'><fmt:message key="eOA.ActiveSlots.label" bundle="${oa_labels}"/></th>
	<th class='columnheadercenter'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
    <th class='columnheadercenter'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></th>
  </tr>
  </thead>
  <tbody>	
<% 
try
{
	con =  ConnectionManager.getConnection(request);
	String practitioner_id = "";
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	String schedule_date = "";
	String facility_id = "";
	String clinic_code = "";
	String query_interface = "";
	String sql1 = "";
	String sql2 = "";
	String sql3 = "";
	String practitionerEmt = "";
	practitionerEmt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels");
	String transactionId=checkForNull(request.getParameter( "transactionId" ));
	query_interface = "select PRACTITIONER_ID,SCHEDULE_DATE,FACILITY_ID,CLINIC_CODE from OA_SCHEDULE_OVERLAP WHERE TRANS_ID =?";
	pstmt = con.prepareStatement(query_interface);	
	pstmt.setString(1,transactionId);
	rs = pstmt.executeQuery();		
	if(rs != null)
	{
		while(rs.next()){
			practitioner_id = checkForNull(rs.getString("practitioner_id"),practitionerEmt);
			/*if(practitioner_id.equals("null") || practitioner_id.equals(null)){
			practitioner_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels");}*/
			schedule_date = dateFormat.format(rs.getDate("schedule_date"));
			facility_id = rs.getString("facility_id");
			clinic_code = rs.getString("clinic_code");
			sql1 = "select LONG_DESC from op_clinic where clinic_code = ? ";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1,clinic_code);
			rs1 = pstmt1.executeQuery();
			if(rs1 != null)
			{
				while(rs1.next()){
			clinic_code = rs1.getString("LONG_DESC");
			} }
			sql2 = "SELECT PRACTITIONER_NAME FROM am_practitioner WHERE practitioner_id = ? UNION ALL SELECT short_desc PRACTITIONER_NAME FROM am_facility_room WHERE room_num = ? UNION ALL SELECT short_desc PRACTITIONER_NAME FROM am_resource WHERE RESOURCE_ID = ? ";
			pstmt1 = con.prepareStatement(sql2);
			pstmt1.setString(1,practitioner_id);
			pstmt1.setString(2,practitioner_id);
			pstmt1.setString(3,practitioner_id);
			rs1 = pstmt1.executeQuery();
			if(rs1 != null)
			{
			while(rs1.next()){
			practitioner_id = rs1.getString("PRACTITIONER_NAME");
			} }
			sql3 = "select FACILITY_NAME from sm_facility_param where facility_id = ?";
			pstmt1 = con.prepareStatement(sql3);	
			pstmt1.setString(1,facility_id);
			rs1 = pstmt1.executeQuery();
			if(rs1 != null )
			{
				while(rs1.next()){
			facility_id = rs1.getString("FACILITY_NAME");
			}}
			//if(practitioner_id.equals("null") || practitioner_id.equals(null)) practitioner_id = "Not Identified";
%>
			
	<tr id=row<%=i%>>
				<td id='row<%=i%>_col0' class=<%=classval%> width="10%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='practitioner_id<%=i%>' id='practitioner_id<%=i%>' value = '<%=practitioner_id%>' ><%=practitioner_id%></span>
				</td>
				<td id='row<%=i%>_col1' class=<%=classval%> width="10%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='schedule_date<%=i%>' id='schedule_date<%=i%>' value = '<%=schedule_date%>' ><%=schedule_date%></span>
				</td>
				<td id='row<%=i%>_col2' class=<%=classval%> width="10%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='facility_id<%=i%>' id='facility_id<%=i%>' value = '<%=facility_id%>' ><%=facility_id%></span>
				</td>
				<td id='row<%=i%>_col3' class=<%=classval%> width="10%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='clinic_code<%=i%>' id='clinic_code<%=i%>' value = '<%=clinic_code%>' ><%=clinic_code%></span>
				</td>
			</tr>
 <%
		i++;
		}
	}
	if(i == 1)
		{%>
		<script>
		alert("Query caused no records to be retrieved");
		</script>
		<%}
	
%>
	</tbody>
<%				
		
}catch(Exception eX)
		{				
			eX.printStackTrace();
		}
		finally
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
			if (rs1 != null)   rs1.close();
			if (pstmt1 != null) pstmt1.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>	
</table>
</div>
<table width='100%'>
<tr>
	<td  class='label' colspan='3'>&nbsp;</td>
	<td class='button'><input type='button' name='Ok' id='Ok'  onclick="doClose()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class = 'button'></td>
</tr>
</table>
</body> 
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

