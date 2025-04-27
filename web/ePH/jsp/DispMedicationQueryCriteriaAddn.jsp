<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	System.out.println("==============in==========>DispMedicationQueryCriteriaAddn.jsp");
	 request.setCharacterEncoding("UTF-8");
	 String locale			= (String)session.getAttribute("LOCALE");
		
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

   <script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmDispMedicationQueryCriteriaAdditional" id="frmDispMedicationQueryCriteriaAdditional" >
<%
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		String facility_id=(String) session.getValue( "facility_id" );
	String disp_locn_catg = bean.getDispLocnCatg();
	String add_criteria_practitioner_name= CommonBean.checkForNull(bean.getAddCriteriaPractitionerName());
	String add_criteria_practitioner_id  =  CommonBean.checkForNull(bean.getAddCriteriaPractitionerID());
//	String add_criteria_encounter_id	 =  CommonBean.checkForNull(bean.getAddCriteriaEncounterID());  
	String gender						 =	CommonBean.checkForNull(bean.getGender());
	String add_criteria_nat_code		 =  CommonBean.checkForNull(bean.getAddCriteriaNatCode());
//changed during PE by naveen	
	//ArrayList nationalities				 =	bean.getAllNationalities();
	String add_criteria_nat_desc		 =  CommonBean.checkForNull(bean.getAddCriteriaNatDesc());

%>
	<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<td class="COLUMNHEADER" colspan="6"><fmt:message key="Common.AdditionalCriteria.label" bundle="${common_labels}"/>
		</td>
		<tr>

			<td align="left" class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td  >&nbsp;&nbsp;
				<input type="text" name="practitioner_name" id="practitioner_name" value="<%=add_criteria_practitioner_name%>"><input type="button" class="button" value="?" name="btnPractitioner" id="btnPractitioner" onClick="searchCode(practitioner_name,'<%=disp_locn_catg%>','P')" ><input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=add_criteria_practitioner_id%>">
			</td>
			<td align="left" class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
			<td  >&nbsp;&nbsp;<input type="text" name="nationality_name" id="nationality_name" value="<%=add_criteria_nat_desc%>"><input type="button" class="button" value="?" name="btnnationality" id="btnnationality" onClick="NationalitySeach(nationality_name)" ><input type="hidden" name="nationality" id="nationality" value="<%=add_criteria_nat_code%>">
			
			</td>
			<td align="left" class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td  >&nbsp;&nbsp;<select name="gender" id="gender">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
			<% if(gender.equals("M")) { %>
			<option value="M" selected><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<% } else if(gender.equals("F")) { %>
			<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F" selected><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<% } else if(gender.equals("U")) { %>
			<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value="U" selected><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<% } else { %>
			<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<% } %>
			</select>
			</td>	
		</tr>
		<tr>
		<tr>
		<!-- 	<td align="right" class="label">Gender</td>
			<td  >&nbsp;&nbsp;
				<select name="gender" id="gender">
					<option value="B">Both</option>
					<option value="M">Male</option>
					<option value="F">Female</option>
				</select> 
			</td>
			<td align="right" class="label">DOB</td>
			<td  >&nbsp;&nbsp;
				<input type="text" name="dt_of_birth" id="dt_of_birth" maxlength="10" size="10" onBlur="CheckDate(this)">
			</td>	-->
		</tr>
<!-- 		<tr>
			<td align="right" class="label" nowrap>First Name</td>
			<td  >&nbsp;&nbsp;
				<input type="text" name="first_name" id="first_name" >
			</td>
			<td align="right" class="label">Second Name</td>
			<td  >&nbsp;&nbsp;
				<input type="text" name="second_name" id="second_name" >
			</td>
			<td align="right" class="label">Family Name</td>
			<td  >&nbsp;&nbsp;
				<input type="text" name="family_name" id="family_name" >
			</td>	
		</tr>
 -->		<tr>
			<td align="right" colspan="6">
				<input type="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="storeAdditionalCriteria()">
				<input type="button" name="btnCancel" id="btnCancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="cancelAdditionalCriteria()">
			</td>
		</tr>
	</table>
	<!-- <input type="hidden" name="SQL_PH_DISP_MEDICATION_SELECT10" id="SQL_PH_DISP_MEDICATION_SELECT10" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT10")%>"> -->
	<input type="hidden" name="SQL_PH_DISP_MEDICATION_SELECT11" id="SQL_PH_DISP_MEDICATION_SELECT11" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT11")%>">

	<input type="hidden" name="SQL_PH_DISP_MEDICATION_NAT_SEARCH" id="SQL_PH_DISP_MEDICATION_NAT_SEARCH" value="SELECT COUNTRY_CODE CODE,LONG_NAME  DESCRIPTION FROM MP_COUNTRY_LANG_VW WHERE  UPPER(COUNTRY_CODE) LIKE UPPER(?)  AND UPPER(LONG_NAME) LIKE UPPER(?) and EFF_STATUS='E' AND  LANGUAGE_ID = ">

	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">

</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

