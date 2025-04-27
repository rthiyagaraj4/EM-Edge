<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<!--
Developed by    :Karabi Sarma
Module/Function : Drug Information Enquiry ( Transctions)
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList, ePH.CytoInciReportingBean, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html> 
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
	
	<script language="JavaScript" src="../../ePH/js/CytoInciReporting.js"></script>   
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<style>
textarea {
  resize: none;
}
</style>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
	<%
	String Sysdate="";
	ArrayList IncidentDtls=null;
	String location="";
	String Sysdate1="";
	String mode=(String)CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String Seq_No	= request.getParameter("Seq_no") ;
	String user_id = (String)session.getValue( "login_user" );
	String readonly1="";
	String disabled="";
	String dis="disabled";
	if(Seq_No==null) Seq_No="";

	String bean_id			= "CytoInciReportingBean" ;
	String bean_name		= "ePH.CytoInciReportingBean";
	
	CytoInciReportingBean bean = (CytoInciReportingBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	if(Seq_No.equals("")){
		bean.clear() ;
	}
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String logged_fcy = bean.getLoggedInFacility();
	String user_name = bean.getUserName(user_id);

	Sysdate		=bean.getSysdate();
	Sysdate1=Sysdate;

	if(!Seq_No.equals("")){
	mode=(String)CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
		IncidentDtls	=	bean.getIncidentDtls(Seq_No);
	}
	bean.setMode(mode) ;
	
	String sel1="",sel2="",sel3="",sel4="";
	String sel5="",sel6="",sel7="",sel8="",sel9="",sel10="",sel11="",selph="";
	String sel12="",sel13="",sel14="",sel15="";
	String INCIDENT_SEQ_NO="", DRUG_CODE="", DATE_OF_INCIDENT="", LOCN_TYPE="", LOCN_CODE="", INCIDENT_REMARKS="", CAUSE_OF_SPILAGE="", OTHER_REMARKS="", WITNESS_ID="", DOSAGE_FORM="", VOLUME="", WEIGHT="", WEIGHT_UOM="", DATE_RET_PHARMACY="", DATE_REPLACED="", REPORTED_BY_ID="", REPORTED_REMARKS="", CHECKED_BY_ID="", DATE_OF_CHECK_REPO="",DRUG_DESC="",WITNESSNAME="",CHECKEDBYNAME="",REPORTERNAME="";

	REPORTED_BY_ID = user_id;
	REPORTERNAME = user_name;

	if(IncidentDtls!=null){
		
		if(IncidentDtls.size() > 0){
	
			INCIDENT_SEQ_NO=(String)IncidentDtls.get(0);
			DRUG_CODE=(String)IncidentDtls.get(1);
			DATE_OF_INCIDENT=(String)IncidentDtls.get(2);
			if(!DATE_OF_INCIDENT.equals(""))Sysdate1=DATE_OF_INCIDENT;
			LOCN_TYPE=(String)IncidentDtls.get(3);
			LOCN_CODE=(String)IncidentDtls.get(4);
			INCIDENT_REMARKS=(String)IncidentDtls.get(5);
			CAUSE_OF_SPILAGE=(String)IncidentDtls.get(6);
			OTHER_REMARKS=(String)IncidentDtls.get(7);
			WITNESS_ID=(String)IncidentDtls.get(8);
			DOSAGE_FORM=(String)IncidentDtls.get(9);
			VOLUME=(String)IncidentDtls.get(18);
			WEIGHT=(String)IncidentDtls.get(10);
			WEIGHT_UOM=(String)IncidentDtls.get(11);
			DATE_RET_PHARMACY=(String)IncidentDtls.get(12);
			DATE_REPLACED=(String)IncidentDtls.get(13);
			REPORTED_BY_ID=(String)IncidentDtls.get(14);
			REPORTED_REMARKS=(String)IncidentDtls.get(15);
			CHECKED_BY_ID=(String)IncidentDtls.get(16);
			DATE_OF_CHECK_REPO=(String)IncidentDtls.get(17);

			DRUG_DESC=(String)IncidentDtls.get(19);
			WITNESSNAME=(String)IncidentDtls.get(20);
			REPORTERNAME=(String)IncidentDtls.get(21);
			CHECKEDBYNAME=(String)IncidentDtls.get(22);
		
			if(DRUG_DESC==null) DRUG_DESC="";
			if(WITNESSNAME==null) WITNESSNAME="";
			if(REPORTERNAME==null) REPORTERNAME="";
			if(CHECKEDBYNAME==null) CHECKEDBYNAME="";
			
			if(INCIDENT_SEQ_NO==null) INCIDENT_SEQ_NO="";
			if(DRUG_CODE==null) DRUG_CODE="";
			if(DATE_OF_INCIDENT==null) DATE_OF_INCIDENT="";
			if(LOCN_TYPE==null) LOCN_TYPE="";
			if(LOCN_CODE==null) LOCN_CODE="";
			if(INCIDENT_REMARKS==null) INCIDENT_REMARKS="";
			if(CAUSE_OF_SPILAGE==null) CAUSE_OF_SPILAGE="";
			if(OTHER_REMARKS==null) OTHER_REMARKS="";
			if(WITNESS_ID==null) WITNESS_ID="";
			if(DOSAGE_FORM==null) DOSAGE_FORM="";
			if(VOLUME==null) VOLUME="";
			if(WEIGHT==null) WEIGHT="";
			if(WEIGHT_UOM==null) WEIGHT_UOM="";
			if(DATE_RET_PHARMACY==null) DATE_RET_PHARMACY="";
			if(DATE_REPLACED==null) DATE_REPLACED="";
			if(REPORTED_BY_ID==null) REPORTED_BY_ID="";
			if(REPORTED_REMARKS==null) REPORTED_REMARKS="";
			if(DATE_OF_CHECK_REPO==null) DATE_OF_CHECK_REPO="";
		    




			if(CHECKED_BY_ID==null) 
				CHECKED_BY_ID="";
			else if(CHECKED_BY_ID!=""){
				readonly1 ="READONLY";
				disabled = "DISABLED";
			}
			
					
		
			if(DOSAGE_FORM.equals("P")) sel1="Selected";
			if(DOSAGE_FORM.equals("S")) sel2="Selected";
			if(DOSAGE_FORM.equals("D")) sel3="Selected";
			if(DOSAGE_FORM.equals("L")) sel4="Selected";
			
			if(CAUSE_OF_SPILAGE.equals("L")) sel5="Selected";
			if(CAUSE_OF_SPILAGE.equals("P")) sel6="Selected";
			if(CAUSE_OF_SPILAGE.equals("D")) sel7="Selected";
			if(CAUSE_OF_SPILAGE.equals("F")) sel8="Selected";
			if(CAUSE_OF_SPILAGE.equals("O")) sel9="Selected";

			if(LOCN_TYPE.equals("N")) sel10="Selected";
			if(LOCN_TYPE.equals("C")) sel11="Selected";
			if(LOCN_TYPE.equals("P")) selph="Selected";

			if(WEIGHT_UOM.equals("Gm")) sel12="Selected";
			if(WEIGHT_UOM.equals("Mg")) sel13="Selected";
			if(WEIGHT_UOM.equals("Mcg")) sel14="Selected";
			if(WEIGHT_UOM.equals("Ncg")) sel15="Selected";
			if(!LOCN_TYPE.equals("")){
				location=bean.getLocationDesc(LOCN_CODE,LOCN_TYPE);
				dis="";
			}
			}

	}
	

%>

<form name='PhCytoInciReportingForm' id='PhCytoInciReportingForm' >
<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<TR >
				<TD class="label" width="18%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<TD colspan="3" width="82%"><input type="text" name="drug_name" id="drug_name" maxlength="40" size="41" value="<%=DRUG_DESC%>" readonly><input type="button" class="button" value="?" name="drug_desc" id="drug_desc" <%=disabled%> onClick="callDrugSearch(document.PhCytoInciReportingForm.drug_name)" > <input type="hidden" name="drug_code" id="drug_code" value="<%=DRUG_CODE%>"><IMG id='id1' src="../../eCommon/images/mandatory.gif" align="center"></IMG>&nbsp;&nbsp;</td>
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<TR>
				<TD colspan="1" width="18%" class='label'><font id='pn'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</font>
				<TD colspan="1" width="35%"><SELECT name="locn_type" id="locn_type"  <%=disabled%> onchange='LocationDisabled(locn_type)'>
				<OPTION value="">&nbsp;&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;&nbsp;</OPTION> 
				<OPTION value="C" <%=sel11%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>&nbsp;&nbsp;</OPTION>
				<OPTION value="N" <%=sel10%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
				<OPTION value="P" <%=selph%>><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></OPTION>
				</select>&nbsp;&nbsp;
				<input type="text" name="location" id="location" maxlength="25" size="25" onblur="lookUpLocation(locn_type)" value="<%=location%>" <%=dis%> ><input type="button" class="button" value="?" name="location_desc" id="location_desc" onClick="lookUpLocation(locn_type)" <%=dis%>  ><IMG id='id1' src="../../eCommon/images/mandatory.gif" align="center"></IMG>
			
				 <INPUT TYPE="hidden" name="location1" id="location1" VALUE="<%=LOCN_CODE%>">
				</td>
				<TD class="label" width="32%" nowrap colspan='2'><fmt:message key="ePH.DateofIncident.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<input type="text" maxlength="16" size="16"  <%=readonly1%> value="<%=com.ehis.util.DateUtils.convertDate(Sysdate1,"DMYHM","en",locale)%>"  name="inc_date" OnBlur="validateIncidentDate(this,'<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" <%=disabled%> id=Calendar onclick="return showCalendar('inc_date',null,'hh:mm');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">&nbsp;&nbsp;&nbsp;</TD>
		</TR>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<TR >
				<TD class="label" width="18%" nowrap><fmt:message key="ePH.IncidentRemarks.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
				<TD width="82%" colspan='3'>
				<textArea name="incident_desc"   <%=readonly1%> rows='2' cols='86'  onkeypress= "ChkMaxLen('Incident Details',this,255,'mode');"><%=INCIDENT_REMARKS%></textarea><IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG></TD>
		</TR>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<TR>
				<TD colspan="1" width="18%" class='label'><font id='pn'><fmt:message key="ePH.CauseofSpill.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</font>
				<TD colspan="1" width="35%"><SELECT name="spill" id="spill"  onchange='callSpill(this)' <%=disabled%> >
				<OPTION value="">&nbsp;&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;&nbsp;</OPTION> 
				<OPTION value="L" <%=sel5%>><fmt:message key="ePH.ContainerLeakage.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
				<OPTION value="P" <%=sel6%>><fmt:message key="ePH.ContainerPierced.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
				<OPTION value="D" <%=sel7%>><fmt:message key="ePH.ContainerDropped.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</OPTION>
				<OPTION value="F" <%=sel8%>><fmt:message key="ePH.ContainerDefective.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</OPTION>
				<OPTION value="O" <%=sel9%>><fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;&nbsp;</OPTION></select>
				&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG>
				</td><TD colspan='2' class='label'>&nbsp;&nbsp;&nbsp;</TD>
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr id='rmks' style='display:none'>
				<TD class="label" width="18%" nowrap><fmt:message key="ePH.SpillageRemarks.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
				<TD class="label" width="82%" colspan='3'><textArea name="other_remarks"   rows='2' cols='86'  onkeypress= "ChkMaxLen('Remarks',this,255,'mode');"><%=OTHER_REMARKS%></textarea><IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG></td>
		</TR>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD class="label" width="18%"><fmt:message key="ePH.Witnessedby.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
				<TD colspan="3" width="82%"><input type="text" name="witness_id" id="witness_id" maxlength="30" size="32" value="<%=WITNESS_ID%>" readonly><input type='button' name='witness_id_button' id='witness_id_button' class='button'   value='?' <%=disabled %> onClick="show_uesr_id_window(witness_id,witness_name,'Witnessed By')">&nbsp;&nbsp;<input type="text" name="witness_name" id="witness_name" maxlength="60" size="60" value="<%=WITNESSNAME%>" readonly></td>
		
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD  colspan="1" width="18%" class='label'><font id='pn'><fmt:message key="ePH.DosageformofDrug.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</font></td>
				<TD colspan="3" width="82%" nowrap class='label'><SELECT name="dosage_drug" id="dosage_drug" <%=disabled%>  onchange='callDosage(this)'>
				<OPTION value="">&nbsp;&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;&nbsp;</OPTION> 
				<OPTION value="P" <%=sel1%>><fmt:message key="ePH.PlasticBag.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
				<OPTION value="S" <%=sel2%>><fmt:message key="ePH.Syringe.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</OPTION>
				<OPTION value="D" <%=sel3%>><fmt:message key="ePH.DryPowder.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</OPTION>
				<OPTION value="L" <%=sel4%>><fmt:message key="ePH.LiquidinVial/Ampoule.label" bundle="${ph_labels}"/>&nbsp;</OPTION></select>
				&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG><font id='pn'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><fmt:message key="ePH.StrengthSupplied.label" bundle="${ph_labels}"/></b>&nbsp;&nbsp;</font> <fmt:message key="Common.volume.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="volume" id="volume" <%=readonly1%> maxlength="11" size="6" value="<%=VOLUME%>" onKeyPress="return allowValidNumber(this,event,8,2);" onBlur="CheckNum(this);checkForZero(this);">&nbsp;<label ><fmt:message key="Common.ml.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<IMG id='id1' src="../../eCommon/images/mandatory.gif" align="center"></IMG> <fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="weight" id="weight" <%=readonly1%> maxlength="11" size="6" value="<%=WEIGHT%>" onKeyPress="return allowValidNumber(this,event,8,2);"  onBlur="CheckNum(this);checkForZero(this);"><select name='weight_uom' id='weight_uom' <%=disabled%>><option VALUE="Gm" <%=sel12%> ><fmt:message key="ePH.Gm.label" bundle="${ph_labels}"/></option><option VALUE="Mg" <%=sel13%>><fmt:message key="ePH.Mg.label" bundle="${ph_labels}"/></option><option VALUE="Mcg" <%=sel14%>><fmt:message key="ePH.Mcg.label" bundle="${ph_labels}"/></option><option VALUE="Ncg" <%=sel15%>><fmt:message key="ePH.Ncg.label" bundle="${ph_labels}"/></option></select>&nbsp;&nbsp;<IMG id='id1' src="../../eCommon/images/mandatory.gif" align="center"></IMG></td>
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD class="label" width="18%" nowrap><fmt:message key="ePH.SpillKitReturnedDate.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
				<TD width="35%" colspan='1' nowrap><input type="text" <%=readonly1%> maxlength="16" size="16"  value="<%=DATE_RET_PHARMACY%>"  name="return_dt" id="return_dt" OnBlur="validateReturnDate(this,'<%=locale%>');"><IMG <%=disabled%> SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('return_dt',null,'hh:mm');" ></td><TD class="label" width="32%" nowrap colspan='2'><fmt:message key="ePH.SpillKitReplacedDate.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<input type="text" maxlength="16" size="16"  value="<%=DATE_REPLACED%>" <%=readonly1%> name="replace_dt" id="replace_dt" OnBlur='callFirst("Replaced");//validateReplaceDate(this,sysdate);'><IMG <%=disabled%> SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('replace_dt',null,'hh:mm');" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD class="label" width="18%" nowrap>
				<fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<TD colspan="3" width="82%"><input type="text" name="rep_person_id" id="rep_person_id" maxlength="30" size="32" value="<%=REPORTED_BY_ID%>" readonly><input type='button' name='user_id_button' id='user_id_button' class='button'   value='?' <%=disabled%> onClick="show_uesr_id_window(rep_person_id,rep_person_name,'Reported By')">&nbsp;&nbsp;<input type="text" name="rep_person_name" id="rep_person_name" maxlength="60" size="60" value="<%=REPORTERNAME%>" readonly><IMG id='id1' src="../../eCommon/images/mandatory.gif" align="center"></IMG></td>
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD class="label" width="18%" nowrap><fmt:message key="ePH.CommentonIncident.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
				<TD width="82%" colspan='3'><textArea name="comment"   rows='2' cols='86' <%=readonly1%> onkeypress= "ChkMaxLen('Remarks',this,255,'mode');"><%=REPORTED_REMARKS%></textarea><!-- <IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG> --></td>
		</TR>
				<TR height='8' id='tr1'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD class="label" width="18%" nowrap><fmt:message key="Common.CheckedBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td> 
				<TD colspan="3" width="82%"><input type="text" name="check_person_id" id="check_person_id" maxlength="30" size="32" value="<%=CHECKED_BY_ID%>" readonly><input type='button' name='check_id_button' id='check_id_button' class='button'   value='?' <%=disabled%> onClick="show_uesr_id_window(check_person_id,check_person_name,'Checked By')">&nbsp;&nbsp;<input type="text" name="check_person_name" id="check_person_name" maxlength="60" size="60" value="<%=CHECKEDBYNAME%>" readonly></td> 
		</tr>
		<TR height='8'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<tr>
				<TD class="label" width="18%" nowrap><fmt:message key="ePH.CheckedDate.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
				<TD width="82%" colspan='3' nowrap><input type="text" maxlength="16" size="16" <%=readonly1%> value="<%=DATE_OF_CHECK_REPO%>"  name="check_dt" id="check_dt" OnBlur='callFirst("Checked");//validateCheckDate(this);'><IMG <%=disabled%> SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('check_dt',null,'hh:mm');" >
		</tr>
		<TR height='8' id='tr2'>
				<TD colspan="4" height='8'></TD>
		</TR>
		<TR height='8' id='tr2'>
				<TD colspan="4" height='8'></TD>
		</TR>
	
</TABLE>

	<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<!-- <input type="hidden" name="user_id_sql" id="user_id_sql" value="<//%=PhRepository.getPhKeyValue("SQL_PH_PIN_AUTH_RIGHTS_SELECT1")%>"> -->
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%=logged_fcy%>"> 
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="EFF_STATUS" id="EFF_STATUS" VALUE="E">
	<INPUT TYPE="hidden" name="Seq_No" id="Seq_No" VALUE="<%=INCIDENT_SEQ_NO%>">
	<INPUT TYPE="hidden" name="locn_code" id="locn_code" VALUE="<%=LOCN_CODE%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	

</form>
<script>
	if(document.forms[0].Seq_No.value!="" && document.forms[0].Seq_No.value!=null){
		if(document.forms[0].spill.value=='O'){
		document.getElementById("rmks").style.display='';
		}
	}

</script>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

