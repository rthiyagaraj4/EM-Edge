	<%
/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
05/11/2024      70709     Gunasekar R  	 06/11/2024   Ashwini Ragupathi       ML-MMOH-CRF-1759      
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request); 
    response.addHeader("X-XSS-Protection", "1; mode=block"); 
    response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	
	String bean_id = "@CAMenstrualHistDtlTransBean" ;
	String bean_name = "eCA.CAMenstrualHistDtlTransBean";

	CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean) getBeanObject( bean_id, bean_name ,  request) ;
	
	    String locale			= (String)session.getAttribute("LOCALE");
		String facilityId = (String) session.getValue("facility_id");
		String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
		String pract_name = ((String)session.getValue("practitioner_name") == null) ? "" : (String)session.getValue("practitioner_name") ;
		int restricted_Position=0;

		restricted_Position = bean.getRestrictedPosition(ca_practitioner_id,facilityId);
		
		String toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");

	%>

	<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../js/MenstrualHistPatList.js'></script> 
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>	
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	</head>
	<body class='CONTENT' onLoad=''  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="pract_name()">  
		<form name='MenstPatCriteriaFrm' id='MenstPatCriteriaFrm' onload="callmakeless()">
			<table id='PatCriteriaTbl' width='100%' border='0' cellpadding='0' cellspacing=0>
				<tr><td class ='columnheader' colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td></tr>
				<tr>
					<td class='LABEL' colspan=1 width='25%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td width='25%'  class='fields'>
						<select name='locationType' id='locationType' onchange='locnTypeChange(this.value)' > 
						<option value='Z' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			        
							<%
							ArrayList patClass = new ArrayList();
							patClass = bean.getPatientClass(locale);
							for(int i = 0 ; i<patClass.size(); i++)
							{
								String[] record = (String[])patClass.get(i);
							    out.println("<option value="+record[0]+">"+record[1]+"</option>");
							}	

							 %>
						</select>
					</td>
					<td class='LABEL'   id='locLed' width='25%'></td>
					<td  width='25%'  class='fields'>
						<input type='text' name="locationDesc" id="locationDesc" disabled id='locVal' value=""  size='20' maxlength='20' 
						 onkeypress="" onBlur="getClinicCode1(this)" style="visibility:hidden;" ><input type='button' class='button' value='?' id='src_butn' style="visibility:hidden;"  name='search_ref' id='search_ref' onClick="getClinicCode()">
						<input type="hidden" name="locationCode" id="locationCode" value=''>
					</td>
					</tr><tr>
					<td id=viewList class='LABEL' colspan=1 width ='25%'><fmt:message key="eCA.ViewList.label" bundle="${ca_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'  ><select name='viewList' id='viewList' onchange='enablePract(this)'>
								<option value='Z'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
								<option value='S' selected><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td class='label'  width='25%' colspan=1 ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' width ='25%' colspan=1> <input type='text'  name='patientId' id='patientId' value=''
					onKeyPress='return CheckForSpecChars(event)'><input type=button name=search id=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
					</tr>

					<tr>
					<td class='LABEL' colspan='1' width ='25%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'><input type='text'  name='pract' id='pract' value="<%=pract_name%>" disabled onKeyPress='' onBlur='populatePract1(this)' size='20' maxlength='20'><input type='button' name='practSearch' id='practSearch' value='?' class='button' tabIndex="4" onClick="populatePract()"><input type="hidden" name="attendPract" id="attendPract" value=''>
					</td>
					<td class='label' width='25%' colspan='1'><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
					<td class='fields' width ='25%' colspan='1'><input type='text'  name='specialty' id='specialty' value=''  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' tabIndex="4" onClick="getSpecialty()"><input type="hidden" name="specialty_code" id="specialty_code" value=''></td>
					</tr>
					
					<tr>
					<td class='label'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
					<td class='fields' nowrap>
						<input type=textbox size=11 maxlength=10 name='p_fm_Date' id='p_fm_Date' value="<%=frDate%>" onblur='return Check_Date(this,"DMY","<%=locale%>");' OnKeyPress='return CheckForNumsAndColon(event)' ><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_fm_Date');" style='cursor:pointer'>
						<input type=textbox size=11 maxlength=10 value="<%=toDate%>" name='p_to_Date' onblur='return checkingDate(this,"DMY","<%=locale%>")' OnKeyPress='return CheckForNumsAndColon(event)'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_to_Date');" style='cursor:pointer'>
					</td>
					<td  class='LABEL' colspan=1 width ='25%'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'  ><select name='encounterSt' id='encounterSt'>
								<option value='Z'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>		
								<option value='A'><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>	
								<option value='I'><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></option>		
					</select>
					</td>
				</tr><tr></tr><tr></tr>
				<tr>
					<td class='LABEL' colspan=1 width ='25%'><fmt:message key="eCA.MenstrualHistoryEvent.label" bundle="${ca_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'  ><select name='menstHisEvent' id='menstHisEvent'>
							    <option value='Z'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>		
								<option value='A'><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>	
								<option value='C'><fmt:message key="Common.closed.label" bundle="${common_labels}"/></option>		
						</select>
					</td>
				</tr>
                <tr></tr>
					<tr><td colspan='2'>&nbsp;</td>
					<td align='right' colspan='2'>
						<input type='button' class='button' name='search' id='search' id = 'searchID' onclick="searchClick()" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'></input> <!--ADDED CHECKFIELDS FUNCTION-->
						<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick()" style='margin-right: 60px' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input>
					</td>
				</tr>		
			</table>
		
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
            <input type='hidden' value='<%=locale%>' name='locale' ></input>
            <input type='hidden' value='<%=facilityId%>' name='facilityid' ></input>
            <input type=hidden value="<%=ca_practitioner_id%>" name="ca_practitioner_id"></input>
            <input type=hidden value="<%=pract_name%>" name="pract_name"></input>
            <input type=hidden value="<%=restricted_Position%>" name="practRestriPositionYN1"></input>
            <input type="hidden" name="order_by" id="order_by" value="">
	    <input type="hidden" name="re_order" id="re_order" value="">
	    <input type="hidden" name="anchor_id" id="anchor_id" value="">
            <input type="hidden" name="patient_id" id="patient_id" value="">
	    <input type="hidden" name="patient_class" id="patient_class" value="">
	    <input type="hidden" name="encounter_id" id="encounter_id" value="">
		</form>
	</body>
</html><%
%>



