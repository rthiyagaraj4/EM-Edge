<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String currentdate = "";
   PreparedStatement pstmt = null;
   Statement stmt = null;
   ResultSet rset=null;
try {

    con=ConnectionManager.getConnection(request);
	String getDate = "select to_char(sysdate,'dd/mm/rrrr') sdate from dual" ;
	stmt = con.createStatement();
	rset	  = stmt.executeQuery(getDate);
	if (rset.next())
	{
		currentdate	=  rset.getString("sdate");
	}
	if ( stmt != null ) stmt.close();
	if ( rset != null ) rset.close();

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();mychangerepOPAntePost()"  onKeyDown = 'lockKey()'>
<form name="MROPANPO" id="MROPANPO" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<input type="hidden" name="current_date" id="current_date" value="<%=currentdate%>">

<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
	<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='20%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'  >
			 <SELECT name="report_type" id="report_type" onchange='mychangerepOPAntePost()'>
			 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
			 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
			 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
			 </SELECT>
		</td>
	<td >&nbsp; </td>
	</tr>

	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>

	<tr>
			<td align='right' class="label"> &nbsp; </td>
			<td align='left' style="padding-left: 0px;" class="label"><b> <fmt:message key="Common.from.label" bundle="${common_labels}"/> </b></td> <!--Added by Ashwin K for ML-MMOH-SCF-1838 on 22.02.2022-->
			<td align='left' class="label"> <b><fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></td> <!--Added by Ashwin K for ML-MMOH-SCF-1838 on 22.02.2022-->
	</tr>

	<tr>
			<td align='right' id='MY1' class="label"> &nbsp; </td>
			<td align='left'  style="padding-left: 0px;" id='MY' class="label"> &nbsp; </td><!--Added by Ashwin K for ML-MMOH-SCF-1838 on 22.02.2022-->
			<td align='left' id='MY3' class="label"> &nbsp; </td>
	</tr>


	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
 		<tr>
		            <td align='right' width='35%' class="label"><fmt:message key="eMR.AntenatalService.label" bundle="${mr_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_antinental" id="p_antinental" >
		               <option value=''%>----------Select--------</option>				 
	     <%
		 String antiservice="select member_id,(select short_desc from am_service where service_code=member_id) member_desc from AM_STAT_GRP_DETAIL where stat_grp_id='ANTENATAL' order by 2 ";
	                      pstmt=con.prepareStatement(antiservice);
                          rset=pstmt.executeQuery();
					     
						 while(rset.next())
	                    { 
						 %> 
						 <option value=<%=rset.getString(1)%>><%=rset.getString(2)%></option>
						<%}%>
						 </SELECT>
					</td>
					<td >&nbsp; </td>				 
				</tr>
<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
<tr>
		            <td align='right' width='35%' class="label"><fmt:message key="eMR.PostnatalService.label" bundle="${mr_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_postnatal" id="p_postnatal" >
				          <option value=''%>----------Select--------</option>	 		 
				 <%
		 String Postnatal="select member_id, (select short_desc from am_service where service_code=member_id) member_desc from AM_STAT_GRP_DETAIL where stat_grp_id='POSTNATAL' order by 2 ";
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		 pstmt=con.prepareStatement(Postnatal);
		 rset=pstmt.executeQuery();
		 while(rset.next())
		{ 
		 %> 
		 <option value=<%=rset.getString(1)%>><%=rset.getString(2)%></option>
		<%}
		 
 		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		 %>
		 </SELECT>
	</td>
			 <td >&nbsp; </td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'>
		<SELECT name="p_type" id="p_type" >
		<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
		<option value="M"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
		<td >&nbsp; </td>
	</tr>

	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	</table>
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MROPANPO">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */e.printStackTrace();}
finally
{
	try
	{
	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();
	}
	catch(Exception e) { }
	ConnectionManager.returnConnection(con,request);
}
%>
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

