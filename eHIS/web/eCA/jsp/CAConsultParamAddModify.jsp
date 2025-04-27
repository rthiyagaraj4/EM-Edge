<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Review			Date 		Description							
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
21/07/2016		IN052254		Ramesh G										MMS-QH-CRF-0204	
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN065070	Raja S		27/10/2017		Ramesh G			ML-MMOH-CRF-0623.1
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.Common.* "  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/CAConsultationParam.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
	<form name="ca_consultation_param_form" id="ca_consultation_param_form" action="" method="">
	
	<%
	try
     {

	   String mode="";
       String max_consultation_practitioner ="";
      String back_date_consultation ="";
       String max_consultation_speciality ="";
       String amend_consultation_list ="";
       String min_duration_recquired ="";
       String max_regular_cons ="";
       String max_referral_cons ="";
	   String mngPatQueue = "";
	   String CAPatByLocn = "";
	   String caRestUnBilled = ""; //IN052254
	   String caRestUnBilledChk = ""; //IN052254
	   String mngPatQueueChk = "";
	   String CAPatByLocnChk = "";
	   String ca_patlist_by_locn_chart_type_chk1 = "";
	   String ca_patlist_by_locn_chart_type_chk2 = "";
	   String ca_patlist_by_locn_chart_type_chk3 = "";

	   String MNG_PAT_QUEUE_chart_type_chk1="";
	   String MNG_PAT_QUEUE_chart_type_chk2="";
	   String MNG_PAT_QUEUE_chart_type_chk3="";

	   String MNG_PAT_QUEUE_chart_type ="";
	   String ca_patlist_by_locn_chart_type ="";
       
	   String mngPatQueueEnableDisable = "";
	   String CAPatByLocnEnableDisable = "";
	   //IN065070 changes starts
	   String ae_curr_emr_patient = "";
	   String ae_curr_emr_patient_chart_type = "";
	   String aePatQueueChk = "";
	   String aePatQueueEnableDisable = "";
   	   String ae_curremr_pat_chart_type_chk1 = "";
	   String ae_curremr_pat_chart_type_chk2 = "";
	   String ae_curremr_pat_chart_type_chk3 = "";
	   String aeCAPatByLocn = "";
	   String aeCAPatByLocnChk = "";
	   String ae_patlist_by_locn_chart_type_chk1 = "";
	   String ae_patlist_by_locn_chart_type_chk2 = "";
	   String ae_patlist_by_locn_chart_type_chk3 = "";
	   String aeCAPatByLocnEnableDisable = "";
	   String ae_patlist_by_locn_chart_type = "";
	   //IN065070 changes ends
	   
	   int rec_exists = 0;
	   int ip_cons = 0;

       mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");

		//IN052254 Start.
		//String SqlQuery = "SELECT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE FROM CA_CONS_PARAM";
		//String SqlQuery = "SELECT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,CA_REST_UNBILLED_PATIENT FROM CA_CONS_PARAM";//Commented for IN065070
		//IN052254 End.
		String SqlQuery = "SELECT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,CA_REST_UNBILLED_PATIENT,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE FROM CA_CONS_PARAM";//Modified for IN065070

		
	   conlCon = ConnectionManager.getConnection(request);
	   pstmt = conlCon.prepareStatement(SqlQuery);
	   rslRst = pstmt.executeQuery();
	   if(rslRst.next())
		{
				rec_exists = 1;			
				max_consultation_practitioner =  rslRst.getString("MAX_CONS_PER_PRACT") == null ? "":  rslRst.getString("MAX_CONS_PER_PRACT");
				max_consultation_speciality =  rslRst.getString("MAX_CONS_PER_SPLTY") == null ? "":rslRst.getString("MAX_CONS_PER_SPLTY");
				back_date_consultation =  rslRst.getString("CONS_BACK_DATE") == null ? "":rslRst.getString("CONS_BACK_DATE");
				amend_consultation_list =  rslRst.getString("AMD_CONS_LIST") == null ? "":rslRst.getString("AMD_CONS_LIST");
				min_duration_recquired =  rslRst.getString("MIN_CONS_DURATION") == null ? "":rslRst.getString("MIN_CONS_DURATION");				
				max_regular_cons =  rslRst.getString("MAX_REGULAR_CONS") == null ? "0":rslRst.getString("MAX_REGULAR_CONS");				
				max_referral_cons =  rslRst.getString("MAX_REFERRAL_CONS") == null ? "0":rslRst.getString("MAX_REFERRAL_CONS");				
				mngPatQueue = rslRst.getString("MNG_PAT_QUEUE") == null ? "":rslRst.getString("MNG_PAT_QUEUE");
				CAPatByLocn = rslRst.getString("CA_PATLIST_BY_LOCN") == null ? "":rslRst.getString("CA_PATLIST_BY_LOCN");
				caRestUnBilled = rslRst.getString("CA_REST_UNBILLED_PATIENT") == null ? "":rslRst.getString("CA_REST_UNBILLED_PATIENT"); //IN052254
				ca_patlist_by_locn_chart_type = rslRst.getString("CA_PATLIST_BY_LOCN_CHART_TYPE") == null ? "":rslRst.getString("CA_PATLIST_BY_LOCN_CHART_TYPE");
				MNG_PAT_QUEUE_chart_type = rslRst.getString("MNG_PAT_QUEUE_CHART_TYPE") == null ? "":rslRst.getString("MNG_PAT_QUEUE_CHART_TYPE");
				//IN065070 changes starts
				ae_curr_emr_patient = rslRst.getString("AE_CURR_EMR_PATIENT") == null ? "N":rslRst.getString("AE_CURR_EMR_PATIENT");
				if("".equals(ae_curr_emr_patient))
					ae_curr_emr_patient="N";
				ae_curr_emr_patient_chart_type = rslRst.getString("AE_CURR_EMR_PATIENT_CHART_TYPE") == null ? "":rslRst.getString("AE_CURR_EMR_PATIENT_CHART_TYPE");
				aeCAPatByLocn = rslRst.getString("AE_CA_PATLIST_BY_LOCN") == null ? "N":rslRst.getString("AE_CA_PATLIST_BY_LOCN");
				if("".equals(aeCAPatByLocn))
					aeCAPatByLocn="N";
				ae_patlist_by_locn_chart_type = rslRst.getString("AE_PATLIST_BY_LOCN_CHART_TYPE") == null ? "":rslRst.getString("AE_PATLIST_BY_LOCN_CHART_TYPE");
				
				
				if(ae_curr_emr_patient.equals("Y"))
				{
					aePatQueueChk = "checked";
					aePatQueueEnableDisable = "";
				}
				else if(ae_curr_emr_patient.equals("N"))
				{
					aePatQueueChk = "";
					aePatQueueEnableDisable = "disabled";
				}

				if(ae_patlist_by_locn_chart_type.equals("PCWE"))
				{	
					ae_patlist_by_locn_chart_type_chk1 = "checked";
					ae_patlist_by_locn_chart_type_chk2 = "";
					ae_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ae_patlist_by_locn_chart_type.equals("PCWOE"))
				{
					ae_patlist_by_locn_chart_type_chk1 = "";
					ae_patlist_by_locn_chart_type_chk2 = "checked";
					ae_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ae_patlist_by_locn_chart_type.equals("RUNTIME"))
				{
					ae_patlist_by_locn_chart_type_chk1 = "";
					ae_patlist_by_locn_chart_type_chk2 = "";
					ae_patlist_by_locn_chart_type_chk3 = "checked";
				}

				if(ae_curr_emr_patient_chart_type.equals("PCWE"))
				{	
					ae_curremr_pat_chart_type_chk1 = "checked";
					ae_curremr_pat_chart_type_chk2 = "";
					ae_curremr_pat_chart_type_chk3 = "";
				}
				else if(ae_curr_emr_patient_chart_type.equals("PCWOE"))
				{
					ae_curremr_pat_chart_type_chk1 = "";
					ae_curremr_pat_chart_type_chk2 = "checked";
					ae_curremr_pat_chart_type_chk3 = "";
				}
				else if(ae_curr_emr_patient_chart_type.equals("RUNTIME"))
				{
					ae_curremr_pat_chart_type_chk1 = "";
					ae_curremr_pat_chart_type_chk2 = "";
					ae_curremr_pat_chart_type_chk3 = "checked";
				}

				if(aeCAPatByLocn.equals("Y"))
				{
					aeCAPatByLocnChk = "checked";
					aeCAPatByLocnEnableDisable = "";
				}
				else if(aeCAPatByLocn.equals("N"))
				{
					aeCAPatByLocnChk = "";
					aeCAPatByLocnEnableDisable = "disabled";
				}
				//IN065070 changed ends

				if(mngPatQueue.equals("Y"))
				{
					mngPatQueueChk = "checked";
					mngPatQueueEnableDisable = "";
				}
				else if(mngPatQueue.equals("N"))
				{
					mngPatQueueChk = "";
					mngPatQueueEnableDisable = "disabled";
				}

				if(CAPatByLocn.equals("Y"))
				{
					CAPatByLocnChk = "checked";
					CAPatByLocnEnableDisable = "";
				}
				else if(CAPatByLocn.equals("N"))
				{
					CAPatByLocnChk = "";
					CAPatByLocnEnableDisable = "disabled";
				}
				//IN052254 Start.
				if("Y".equals(caRestUnBilled))
				{
					caRestUnBilledChk = "checked";					
				}
				else if("N".equals(caRestUnBilled))
				{
					caRestUnBilledChk = "";					
				}				
				//IN052254 End.
				if(ca_patlist_by_locn_chart_type.equals("PCWE"))
				{	
					ca_patlist_by_locn_chart_type_chk1 = "checked";
					ca_patlist_by_locn_chart_type_chk2 = "";
					ca_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ca_patlist_by_locn_chart_type.equals("PCWOE"))
				{
					ca_patlist_by_locn_chart_type_chk1 = "";
					ca_patlist_by_locn_chart_type_chk2 = "checked";
					ca_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ca_patlist_by_locn_chart_type.equals("RUNTIME"))
				{
					ca_patlist_by_locn_chart_type_chk1 = "";
					ca_patlist_by_locn_chart_type_chk2 = "";
					ca_patlist_by_locn_chart_type_chk3 = "checked";
				}


				if(MNG_PAT_QUEUE_chart_type.equals("PCWE"))
				{	
					MNG_PAT_QUEUE_chart_type_chk1 = "checked";
					MNG_PAT_QUEUE_chart_type_chk2 = "";
					MNG_PAT_QUEUE_chart_type_chk3 = "";
				}
				else if(MNG_PAT_QUEUE_chart_type.equals("PCWOE"))
				{
					MNG_PAT_QUEUE_chart_type_chk1 = "";
					MNG_PAT_QUEUE_chart_type_chk2 = "checked";
					MNG_PAT_QUEUE_chart_type_chk3 = "";
				}
				else if(MNG_PAT_QUEUE_chart_type.equals("RUNTIME"))
				{
					MNG_PAT_QUEUE_chart_type_chk1 = "";
					MNG_PAT_QUEUE_chart_type_chk2 = "";
					MNG_PAT_QUEUE_chart_type_chk3 = "checked";
				}

				if(!max_regular_cons.equals("0")&&!max_referral_cons.equals("0"))
				ip_cons=Integer.parseInt(max_regular_cons)+Integer.parseInt(max_referral_cons);
		
			mode = "modify";
		
		}
		else
		{
			mode = "insert";
		}
//IN065070 starts	   
	boolean isAEStartConsulation = false;
	isAEStartConsulation=CommonBean.isSiteSpecific(conlCon,"AE","AE_START_CONSULTATION");
//IN065070 ends
	  
   %>
   <!-- Below five fields mandatory check are added by Archana Dhal on 6/9/2010 for IN021962-->
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
		<tr align="left">
			<th class='columnheader' colspan='4'>IP Consultation</th>
		</tr>
	</table>
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
	<tr>
	<td class='label' ><fmt:message key="eCA.MaxConsultationPractitioner.label" bundle="${ca_labels}"/></td>
	<td class='label'><input type="text" name="max_consultation_practitioner" id="max_consultation_practitioner" value="<%=max_consultation_practitioner%>" size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'  onblur='checkSequence(this);CheckPositiveNumberLocal(this)' ><img src='../../eCommon/images/mandatory.gif'></td>

	<td class='label' ><fmt:message key="eCA.BackDateConsultationList.label" bundle="${ca_labels}"/></td>
	<td class='label'><input type="text" name="back_date_consultation" id="back_date_consultation" value="<%=back_date_consultation%>"  size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'   onblur='checkSequence(this);CheckPositiveNumberLocal(this)' ><fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
    </tr>

	<tr>
	<td class='label' ><fmt:message key="eCA.MaxConsultationSpeciality.label" bundle="${ca_labels}"/></td>
	<td class='label'><input type="text" name="max_consultation_speciality" id="max_consultation_speciality" value="<%=max_consultation_speciality%>" size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'     onblur='checkSequence(this);CheckPositiveNumberLocal(this)'><img src='../../eCommon/images/mandatory.gif'></td>

	<td class='label' ><fmt:message key="eCA.AmendConsultationList.label" bundle="${ca_labels}"/></td>
	<td class='label'><input type="text" name="amend_consultation_list" id="amend_consultation_list" value="<%=amend_consultation_list%>" size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'  onblur='checkSequence(this);CheckPositiveNumberLocal(this)' ><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
    </tr> 

	<tr>
	<td class='label' colspan=1><fmt:message key="eCA.MinDurationRecquired.label" bundle="${ca_labels}"/></td>
	<td class='label'colspan=3><input type="text" name="min_duration_recquired" id="min_duration_recquired" value="<%=min_duration_recquired%>" size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'    onblur='checkSequence(this);CheckPositiveNumberLocal(this)'><fmt:message key="eCA.Mins.label" bundle="${ca_labels}"/><img src='../../eCommon/images/mandatory.gif'>
	</td>
    </tr>
	<tr>
	<td class='label' ><b><fmt:message key="eCA.MaxIPConsChargable.label" bundle="${ca_labels}"/></b></td>
	<td class='label' colspan=3 ><input type="text" name="ip_consult" id="ip_consult" value="<%=ip_cons>0?ip_cons:""%>" size=2 maxlength=2  disabled  ><fmt:message key="eCA.PerDay.label" bundle="${ca_labels}"/></td>
	</tr>

	<tr>
	<td class='label' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.RegularCons.label" bundle="${ca_labels}"/></td>
	<td class='label' colspan=3><input type="text" name="reg_consult" id="reg_consult" value="<%=!max_regular_cons.equals("0")?max_regular_cons:""%>" size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'  onblur='checkSequence(this);CheckPositiveNumberLocal(this);validateLimit("R")' ><fmt:message key="eCA.PerDay.label" bundle="${ca_labels}"/></td>
	</tr>

	<tr>
	<td class='label' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.ReferralCons.label" bundle="${ca_labels}"/></td>
	<td class='label' colspan=3><input type="text" name="ref_consult" id="ref_consult" value="<%=!max_referral_cons.equals("0")?max_referral_cons:""%>" size=2 maxlength=2 onkeyPress='return allowValidNumber(this,event,2,0)'  onblur='checkSequence(this);CheckPositiveNumberLocal(this);validateLimit("F")' ><fmt:message key="eCA.PerDay.label" bundle="${ca_labels}"/></td>
	</tr>	
	</table>

	<input type=hidden name="mode" id="mode" value="<%=mode%>">
	<!--IN065070 starts -->
	<%if(isAEStartConsulation){%>
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
		<tr align="left">
			<th class='columnheader' colspan='4'><fmt:message key="eCA.AEConsultation.label" bundle="${ca_labels}"/></th>
		</tr>
	</table>
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
		<tr>
			<td class='label' width="47%" ><fmt:message key="eCA.PromptStartConsultAEPatQueue.label" bundle="${ca_labels}"/></td>
			<td class='label' width="3%"  align='left'><input type='checkbox' name='aemanagePatQueue' id='aemanagePatQueue' id='aemanagePatQueue' onclick='aeManagePatQueueClick()' value='<%=ae_curr_emr_patient%>' <%=aePatQueueChk%>/></td>
			<td class='label' width="47%" ><fmt:message key="eCA.PromptStartConsultAEPatQueueInCA.label" bundle="${ca_labels}"/></td>
			<td class='label' width="3%" align='left'><input type='checkbox' name='aeCAPatByLocn' id='aeCAPatByLocn' id='aeCAPatByLocn' onclick='aeCAPatByLocnClick()' value='<%=aeCAPatByLocn%>' <%=aeCAPatByLocnChk%>/></td>
		</tr>
		<tr>
			<td class='label' colspan='2' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='aemngType' id='aemngType' id='aemngType' value='PCWE' <%=ae_curremr_pat_chart_type_chk1%> <%=aePatQueueEnableDisable%>/><fmt:message key="eCA.OpenPatChrtwithEnc.label" bundle="${ca_labels}"/></td>
			<td class='label' colspan='2' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='aeCAType' id='aeCAType' id='aeCAType' value='PCWE'  <%=ae_patlist_by_locn_chart_type_chk1%> <%=aeCAPatByLocnEnableDisable%>/><fmt:message key="eCA.OpenPatChrtwithEnc.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
			<td class='label' colspan='2' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='aemngType' id='aemngType' id='aemngType'  value='PCWOE' <%=ae_curremr_pat_chart_type_chk2%> <%=aePatQueueEnableDisable%>/><fmt:message key="eCA.OpenPatChrtWithoutEnc.label" bundle="${ca_labels}"/></td>
			<td class='label' colspan='2' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='aeCAType' id='aeCAType' id='aeCAType' value='PCWOE'  <%=ae_patlist_by_locn_chart_type_chk2%> <%=aeCAPatByLocnEnableDisable%>/><fmt:message key="eCA.OpenPatChrtWithoutEnc.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
			<td class='label' colspan='2' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='aemngType' id='aemngType' id='aemngType' value='RUNTIME' <%=ae_curremr_pat_chart_type_chk3%> <%=aePatQueueEnableDisable%>/><fmt:message key="eCA.PromptChartTypeForPatChart.label" bundle="${ca_labels}"/></td>
			<td class='label' colspan='2' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='aeCAType' id='aeCAType' id='aeCAType' value='RUNTIME'  <%=ae_patlist_by_locn_chart_type_chk3%>  <%=aeCAPatByLocnEnableDisable%>/><fmt:message key="eCA.PromptChartTypeForPatChart.label" bundle="${ca_labels}"/></td>
		</tr>
	</table>
	<%}%>
	<!--IN065070 ends -->
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
		<tr align="left">
			<th class='columnheader'   colspan='4'>OP Consultation</th>
		</tr>
	</table>

	<table  align='left' cellpadding=3 cellspacing=0 border=0 width='50%'>
		<tr>
			<td class='label'>Prompt for Start Consultation in Manage Patient Queue</td>
			<td class='label' colspan='3' align='left'><input type='checkbox' name='managePatQueue' id='managePatQueue' id='managePatQueue' onclick='managePatQueueClick()' value='<%=mngPatQueue%>' <%=mngPatQueueChk%>/></td>
		</tr>
		<tr>
			<td class='label' colspan='3'  align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='mngType' id='mngType' id='mngType' value='PCWE' <%=MNG_PAT_QUEUE_chart_type_chk1%> <%=mngPatQueueEnableDisable%>/>Open Patient Chart with Encounter</td>
		</tr>
		<tr>
			<td class='label' colspan='3'  align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='mngType' id='mngType' id='mngType'  value='PCWOE' <%=MNG_PAT_QUEUE_chart_type_chk2%> <%=mngPatQueueEnableDisable%>/>Open Patient Chart without Encounter</td>
		</tr>
		<tr>
			<td class='label' colspan='3'  align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='mngType' id='mngType' id='mngType' value='RUNTIME' <%=MNG_PAT_QUEUE_chart_type_chk3%> <%=mngPatQueueEnableDisable%>/>Prompt for Chart type while opening patient chart</td>

		</tr>
		<tr>
			<td class='label'>Prompt for Start Consultation in Clinician Access</td>
			<td class='label' align='left'><input type='checkbox' name='CAPatByLocn' id='CAPatByLocn' id='CAPatByLocn' onclick='CAPatByLocnClick()' value='<%=CAPatByLocn%>' <%=CAPatByLocnChk%>/></td>
		</tr>
		<tr>
			<td class='label' colspan='3'  align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='CAType' id='CAType' id='CAType' value='PCWE'  <%=ca_patlist_by_locn_chart_type_chk1%> <%=CAPatByLocnEnableDisable%>/>Open Patient Chart with Encounter</td>
		</tr>
		<tr>
			<td class='label' colspan='3'  align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='CAType' id='CAType' id='CAType' value='PCWOE'  <%=ca_patlist_by_locn_chart_type_chk2%> <%=CAPatByLocnEnableDisable%>/>Open Patient Chart without Encounter</td>
		</tr>
		<tr>
			<td class='label' colspan='3'  align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='CAType' id='CAType' id='CAType' value='RUNTIME'  <%=ca_patlist_by_locn_chart_type_chk3%>  <%=CAPatByLocnEnableDisable%>/>Prompt for Chart type while opening patient chart</td>
		</tr>
		<!--IN052254 Start.-->
		<tr>
			<td class='label'><fmt:message key="eCA.RestrictUnsettledPatient.label" bundle="${ca_labels}"/></td>
			<td class='label' align='left'><input type='checkbox' name='caRestUnBilled' id='caRestUnBilled' id='caRestUnBilled' onclick='caRestUnBilledClick()' value='<%=caRestUnBilled%>' <%=caRestUnBilledChk%>/></td>
		</tr>
		<!--IN052254 End.-->
	</table>
	<input type=hidden name="isAESiteSpecific" id="isAESiteSpecific" value="<%=isAEStartConsulation%>"><!--Added for IN065070-->
	</form>
	<script>
		//alert(document.getElementById("CAPatByLocn").value+" "+document.getElementById("managePatQueue").value);
		/*if(document.getElementById("CAPatByLocn").value==''||document.getElementById("CAPatByLocn").value=='N')
			disableRadios('CAType');
		if(document.getElementById("managePatQueue").value==''||document.getElementById("managePatQueue").value=='N')
			disableRadios('mngType');*/

			if(document.getElementById("CAPatByLocn").checked)
				enableRadiosOnLoad(document.getElementsByName('CAType'));
			else
				disableRadiosOnLoad(document.getElementsByName('CAType'));
	
			if(document.getElementById("managePatQueue").checked)
				enableRadiosOnLoad(document.getElementsByName('mngType'));
			else
				disableRadiosOnLoad(document.getElementsByName('mngType'));
			//IN065070 starts 
			if(<%=isAEStartConsulation%>){

				if(document.getElementById("aeCAPatByLocn").checked )
					enableRadiosOnLoad(document.getElementsByName('aeCAType'));
				else
					disableRadiosOnLoad(document.getElementsByName('aeCAType'));
			
				if(document.getElementById("aemanagePatQueue").checked )
					enableRadiosOnLoad(document.getElementsByName('aemngType'));
				else
					disableRadiosOnLoad(document.getElementsByName('aemngType'));
			}
			//IN065070 ends
	</script>
	</body>
	</html>
<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
   }
 catch(Exception e)
 {
	//out.println("Exception in CAConsultParamAddModify.jsp : "+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
 }
finally
 {	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

 }
%>

