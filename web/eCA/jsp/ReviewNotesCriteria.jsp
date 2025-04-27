<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/06/2012	  IN030468		Dinesh T	 BRUHIMS CRF.
4/7/2012	  IN033738		Dinesh T	 BRUHIMS CRF Linked issue
15/04/2013    IN037756      Chowminya G  Can we default the ?Requested Facility? to the log in Facility of the user  instead of ?All" 
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.ReviewNotes.label" bundle="${ca_labels}"/></title>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/** added by kishore kumar n on 28/11/2009  */
		String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/ReviewNotes.js'></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function setValues(obj)
	{
		document.forms[0].requested_to.value = obj.value;
	}
	</script>
	
</head>
<%
	Connection con  = null;
	PreparedStatement pstmt = null,stmtLen=null;
	ResultSet rs = null,rsetLen= null;
	
	String requested_to = "";
	requested_to = request.getParameter("requested_to");
		if(requested_to==null)
			requested_to = "P";
	
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = (String) session.getAttribute("facility_id");//IN037756
	String PatIDLen ="";

	try
	{
		
		String sqlLen ="Select PATIENT_ID_LENGTH from mp_param";
		//new
		con = ConnectionManager.getConnection(request);
		stmtLen = con.prepareStatement(sqlLen);
		rsetLen	= stmtLen.executeQuery();
		while(rsetLen.next())
			{
			PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
			}
		if(rsetLen !=null) rsetLen.close();
		if(stmtLen !=null)stmtLen.close();

		
		//con = ConnectionManager.getConnection(request);

		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String code = "";
		String desc = "";
		String sql = "";
		String toDate = "";
		String frDate = "";
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
%>
<form name="ReviewNotesCriteria_form" id="ReviewNotesCriteria_form">
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
	<!--<td colspan=2></td> -->
	<td class ='label' ><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
	<td class ='fields' >
	<input type='text' name='requestedBy_Desc' id='requestedBy_Desc' value='' size='20' maxlength='20'onBlur="getPractCode(this)"><input type='hidden'  name='requested_by' id='requested_by' value=''><input type='Button' name='practCodeButton' id='practCodeButton' class='button' value='?' onClick='showPractWindow()'></td>

	<td   class='label' 	><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td  class='fields'> <input type='text' width='25%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input type='button' name='patSearch' id='patSearch' class='button' value='?' tabIndex="4" onClick="callPatientSearch()"></td>
	</tr>

	<tr>


<!--	<td class=LABEL width='20%'><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<select name="requested_by" id="requested_by"><option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<%		
					sql = "select distinct request_by_id, AM_GET_DESC.AM_PRACTITIONER(request_by_id,?,'1') request_by_name from ca_encntr_note_audit_log_view where action_type = 'RV' and action_by_id = ? ";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,clinicianid);
					rs = pstmt.executeQuery();

					while(rs != null && rs.next())
					{
						code = rs.getString("request_by_id");
						desc = rs.getString("request_by_name");
						out.println("<option value='"+code+"' >"+desc+"</option>");
					}
			%>
		</select>
	</td> -->
	<td class=label width='15%'><fmt:message key="eCA.ViewList.label" bundle="${ca_labels}"/></td>
	<td class='fields' width='20%'>
		<select name="view" id="view">
				<option value="ALL"> <fmt:message key="Common.Both.label" bundle="${common_labels}"/> </option>
				<option value="RQ"><fmt:message key="Common.Request.label" bundle="${common_labels}"/></option>
				<option value="RS"><fmt:message key="Common.Response.label" bundle="${common_labels}"/></option>			
		</select>
	</td>
	
	<td class='label' width ='25%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='textbox' id='fromDt' name='fromDt' id='fromDt' value='<%=frDate%>' size=10 maxlength=10 onblur='reviewNotescheckFromToDate("F",this,toDt,"<%=toDate%>","DMY","<%=locale%>")'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDt')">&nbsp;<input type='textbox' id='toDt' name='toDt' id='toDt' value='<%=toDate%>' size=10 maxlength=10 onblur='reviewNotescheckFromToDate("T",this,fromDt,"<%=toDate%>","DMY","<%=locale%>")'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDt')"></input><img src='../../eCommon/images/mandatory.gif'></img>	
	</td>
	</tr>
	<tr>

	<TD  class=label nowrap><fmt:message key="Common.Requested.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td>
		
		<%
				if(requested_to!=null && requested_to.equalsIgnoreCase("P"))
				{
				%>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="P" checked onclick='setValues(this)'><fmt:message key="Common.self.label" bundle="${common_labels}"/>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="S" onclick='setValues(this)'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="A" onclick='setValues(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<%
				}
				else if(requested_to !=null && requested_to.equalsIgnoreCase("S"))
				{
				%>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="P" onclick='setValues(this)'><fmt:message key="Common.self.label" bundle="${common_labels}"/>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="S" checked onclick='setValues(this)'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="A" onclick='setValues(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				
				<%
				}
				else if(requested_to!= null && requested_to.equalsIgnoreCase("A"))
				{
				%>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="P" onclick='setValues(this)'><fmt:message key="Common.self.label" bundle="${common_labels}"/>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="S" onclick='setValues(this)'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
					<input type="radio" name="request_notes" id="request_notes" class="label" value="A" checked onclick='setValues(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<%
				}
				%>
	<input type='hidden' name='requested_to' id='requested_to' value="<%=requested_to%>">
	<input type='hidden' name='ca_practitioner_id' id='ca_practitioner_id' value="<%=clinicianid%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</TD><!--IN030468 Starts-->
	<td class=label width='20%'><fmt:message key="Common.Requested.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/></td><td class=LABEL width='20%'>
		<select name="requested_facility" id="requested_facility">
		<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<%		
					//sql = "SELECT sm_get_desc.sm_facility_param (b.facility_id, ?, '1') facility_name,b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ? ";//IN033738
					sql = "SELECT sm_get_desc.sm_facility_param (b.facility_id, ?, '1') facility_name,b.facility_id facility_id FROM sm_facility_param b";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,locale);
					//pstmt.setString(2,(String)session.getValue("login_user"));//IN033738
					rs = pstmt.executeQuery();
					StringBuffer allFacilities =  new StringBuffer();
					while(rs != null && rs.next())
					{
						code = rs.getString("facility_id");
						desc = rs.getString("facility_name");
						//IN037756 - Modified Start default login facility
						if(facility_id.equals(code)) 
							out.println("<option value='"+code+"' selected>"+desc+"</option>");
						else	
							out.println("<option value='"+code+"' >"+desc+"</option>");
						//IN037756 - Modified end	
					}
			%>
		</select><!--IN030468 ends-->
	</td>
	
 <!--</tr>
<tr><td colspan=3></td> -->
	<td width='10%' align=right><input type="button" class=button name='search' id='search'
		value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="searchForDetails()"><input type="button" class=button name='clear' id='clear'
		value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="reviewNotesClear()"></td>
</tr>
</table>
<!-- added by kishore kumar n on 28/11/2009  -->
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
</body>
</form>
<%
	if(rs != null) rs.close();
    if(pstmt != null) pstmt.close();
         
}
catch (Exception e)	
{
		//out.println(e);//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
}
finally    
{
	 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}
%>
</html>

