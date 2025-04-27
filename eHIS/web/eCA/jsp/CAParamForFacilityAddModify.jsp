 <%
/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
14/10/2019	IN071513			Ramesh G		14/10/2019		Ramesh G		ML-BRU-CRF-0585.1
06/04/2020	IN072674			Durga Natarajan	07/04/2020		Ramesh G		MMS-KH-CRF-0032
14/07/2022  33870               Twinkle Shah    21/07/2022		Ramesh G        ML-MMOH-CRF-1763
10/03/2022  36285                Hariharan k       		                        MMs-DM-CRF-0221.v1.0(003)
16/10/2023  32902              Ranjith P R      17/10/2023		Ramesh G        MMS-DM-CRF-0210
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%  
Connection  conlCon		= null;//IN072674
%> 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="eCA.caparam.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src='../js/CAParamForFacility.js'			language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--69244-->
	</head>
	<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
	<%
	//IN072674 starts
	try 
	{
		conlCon = ConnectionManager.getConnection(request);
		//IN072674 ends
		int recordExists =0;
		String facility_name			= "";
		String logoClinicalNotes		= "S";
		String log_clinical_notes_chk1 	= "";
		String log_clinical_notes_chk2 	= "";
		String ThirdParty_Vitals_Time_Dur  = "";//IN072674
		String pract_loc_default_yn="N"; //33870 added
		String pract_loc_default_checked = ""; // 33870 added
		String en_pri_sec_proc_yn="N"; // 36285	added
	    String en_pri_sec_proc_checked = ""; //36285 added
	    String hide_pat_unauth_pract_yn="N"; // 32902	added
	    String hide_pat_unauth_pract_checked = ""; //32902 added
		String mode	                    = request.getParameter( "mode" ) ;
		String facility_id              = request.getParameter( "facility_id" ) ;		
		String bean_id                  = "Ca_parameter_by_facility" ;
		String bean_name                = "eCA.CAParamForFacilityBean";
		//33870 Start. 
		//String[] allValues = new String[3];//IN072674
	//	String[] allValues = new String[4];//33870
		//33870 End.
		//String[] allValues = new String[5];//36285 
		String[] allValues = new String[6];//32902 
	
		boolean  ackVitals_SiteFlag =eCommon.Common.CommonBean.isSiteSpecific(conlCon, "CA","THIRDPARTY_VITALS_ACK");//IN072674
		if(facility_id == null){
			facility_id = (String)session.getValue("facility_id") ;
		}
		CAParamForFacilityBean bean = (CAParamForFacilityBean)getBeanObject( bean_id, bean_name, request ) ;
		
		recordExists = bean.checkForMode(facility_id);
		facility_name = bean.getFacilityName(facility_id);
		if(recordExists == 0){
			mode = "insert";
		}
		
		if(mode.equals("update")){
			allValues  = bean.getValues(facility_id);
			logoClinicalNotes = bean.checkForNull(allValues[1]);
			ThirdParty_Vitals_Time_Dur=bean.checkForNull(allValues[2]);//IN072674
			pract_loc_default_yn = bean.checkForNull(allValues[3]); //33870 added
			en_pri_sec_proc_yn = bean.checkForNull(allValues[4]);//36285  added
			hide_pat_unauth_pract_yn = bean.checkForNull(allValues[5]);//rpr  added
		}
		if(logoClinicalNotes.equals("S")){
			log_clinical_notes_chk1="checked";
			log_clinical_notes_chk2="";
		}
		else if(logoClinicalNotes.equals("F")){
			log_clinical_notes_chk1="";
			log_clinical_notes_chk2="checked";
		}
		
		//33870 start.
		
		if("Y".equals(pract_loc_default_yn))
		{
		  pract_loc_default_checked="checked";
		}
		else
		{
		 pract_loc_default_checked = "unchecked";
		}
		
		//33870 end.
		
		//36285 
		
		if("Y".equals(en_pri_sec_proc_yn))
		{
			en_pri_sec_proc_checked="checked";
		}
		else
		{
			en_pri_sec_proc_checked = "unchecked";
		}
		
		//36285 
		//32902 
		
		if("Y".equals(hide_pat_unauth_pract_yn))
		{
			hide_pat_unauth_pract_checked="checked";
		}
		else
		{
			hide_pat_unauth_pract_checked = "unchecked";
		}
		
		//32902 
		
		
	%>
		<form name="caParamForFacilityForm" id="caParamForFacilityForm" action='../../servlet/eCA.CAParamForFacilityServlet' method="post" target="messageFrame">
			<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<table cellpadding='3' cellspacing='0' border='0' width='80%' align='center'>
				<tr>
					<td  class="label"  width='40%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td  class='fields'>
						<input type=text name="facility_disp" id="facility_disp" value="<%=facility_name%>" readonly>						
					</td>
				</tr>
				<tr>
					<td class="label"	width="40%" ><fmt:message key="eCA.LogoforClinicalNotes.label" bundle="${ca_labels}"/></td>
					<td class="label" id="radio_event" >
						<input type="radio" name="clinical_notes" id="clinical_notes" onclick="logoClinicalNotes('S')"  value="S" <%=log_clinical_notes_chk1%>><fmt:message key="eCA.Site.label" bundle="${ca_labels}"/> 
						<input type="radio" name="clinical_notes" id="clinical_notes" onclick="logoClinicalNotes('F')"  value="F" <%=log_clinical_notes_chk2%>><fmt:message key="eCA.LoginFacility.label" bundle="${ca_labels}"/>
					</td>					
				</tr>
				<!-- IN072674 starts -->
				<%if(ackVitals_SiteFlag){%>
				<tr id='DifferenceofTimePeriod'>
					<td class="label"	width="40%" ><fmt:message key="eCA.DifferenceofTimePeriod.label" bundle="${ca_labels}"/></td>
					<td  class='fields'>
						<input type=text name="ThirdParty_Vitals_Time_Dur" id="ThirdParty_Vitals_Time_Dur" id='Differenceof_TimePeriod'value="<%=ThirdParty_Vitals_Time_Dur%>" size="3" maxlength="3" onKeyPress="return isValidInteger(this);return allowValidNumber(this, event,3,0); " onBlur="checkForMandatory(this);copyPasteChk(this);zerocheck()" >&nbsp;<fmt:message key="eCA.minutes.label" bundle="${ca_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>					
					</td>				
				</tr>
				<%}%>
		
	<!-- 33870 start-->
	<tr>
	  <td class="label" align='left'><fmt:message key="eCA.Defaultloggedinlistbylocation.label" bundle="${ca_labels}"/></td>
	  <td><input type="checkbox" name="DefaultLoggedinListByLocation" id="DefaultLoggedinListByLocation" value = '<%=pract_loc_default_yn%>' <%=pract_loc_default_checked%> 
	  onclick ="defaultLoggedPractitionerByLocation(this)"></td>
	</tr>
	<!-- 33870 end -->
	
	<!-- 36285 start -->
	<tr>
	   <td class="label" align='left'><fmt:message key="eCA.Enableprimaryandsecondaryprocedure.label" bundle="${ca_labels}"/></td>
	   <td><input type="checkbox" name="EnablePrimaryAndSecondaryProcedure" id="EnablePrimaryAndSecondaryProcedure" value = '<%=en_pri_sec_proc_yn%>' <%=en_pri_sec_proc_checked%> 
	   onclick ="enablePrimaryAndSecondaryProcedure(this)"></td> 
	</tr>
	<!-- 32902 starts -->
		<tr>
	   <td class="label" align='left'><fmt:message key="eCA.HidePatientsForUnauthorizedPractitioners.label" bundle="${ca_labels}"/></td>
	   <td><input type="checkbox" name="HidePatientsForUnauthorizedPractitioners" id="HidePatientsForUnauthorizedPractitioners" value ='<%=hide_pat_unauth_pract_yn%>' <%=hide_pat_unauth_pract_checked%> 
	   onclick ="hidePatientsForUnauthorizedPractitioners(this)" ></td> 
	  
	</tr>
	<!-- 32902 ends -->
	<!-- 36285 end -->
					
			</table>
			<input type="hidden" name="logo_site_facility" id="logo_site_facility" value="<%=logoClinicalNotes%>"/>
			<input type=hidden name="facility" id="facility" value="<%=facility_id%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>
			<input type=hidden name="ThirdParty_Vitals_Time_Dur" id="ThirdParty_Vitals_Time_Dur" value="<%=ThirdParty_Vitals_Time_Dur%>"><!-- IN072674 -->
			<input type="hidden" name="ackVitals_SiteFlag" id="ackVitals_SiteFlag" id="ackVitals_SiteFlag" value="<%=ackVitals_SiteFlag%>"><!-- IN072674 -->
            <input type="hidden" name="pract_loc_default_yn" id="pract_loc_default_yn" value="<%=pract_loc_default_yn%>"/><!--33870 added-->
            <input type="hidden" name="en_pri_sec_proc_yn" id="en_pri_sec_proc_yn" value="<%=en_pri_sec_proc_yn%>"/><!--0221 added-->
            <input type="hidden" name="hide_pat_unauth_pract_yn" id="hide_pat_unauth_pract_yn" value="<%=hide_pat_unauth_pract_yn%>"/><!--32902 added-->
		</form>
	</body>
</html>
<!-- IN072674 starts -->
<% 
}
catch(Exception e)
{
	//out.println("Exception in CAParamForFacilityAddModify.jsp : "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

}
%>
<!-- IN072674 ends -->

