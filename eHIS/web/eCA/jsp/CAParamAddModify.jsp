<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/11/2015	IN057113			Karthi L							 			ML-MMOH-CRF-0335 - IN057113 
28/07/2016	IN052053			Krishna Gowtham									AAKH-CRF-0062
13/07/2017	IN061885			Krishna Gowtham	13/07/2017		Ramesh G		ML-MMOH-CRF-0537
01/11/2018  	IN063285           		prathyusha                                      ML-MMOH-CRF-0757
22/01/2018  	IN062606            		Sharanraj       01/02/2018              Ramesh G        	ML-MMOH-CRF-0726
15/03/2018	IN066119			Raja S			15/03/2018		Ramesh G		ML-MMOH-CRF-1024
08/05/2018	IN066237	  		Prakash C  			08/05/2018		Ramesh G		MMS-DM-CRF-0123
10/05/2018 IN065341             Sivabagyam M        10/05/2018  	Ramesh G        MMS-DM-CRF-0115
11/03/2019	IN069852			Raja S				11/03/2019  Ramesh G			JD-CRF-0206
9/03/2019		IN069244		SIVABAGYAM M			29/03/2019  Ramesh G		MMS-KH-CRF-0005.1
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
29/01/2020  IN069384	SIVABAGYAM	M	29/01/2020		RAMESH G		AAKH-CRF-0097.1
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
02/06/2022	31884			Ramesh Goli			02/06/2022	Ramesh G 	MMS=DM-CRF-0208
28/10/2022  37743       SREENADH M      31/10/2022      Ramesh G        ML-MMOH-CRF-1654
26/05/2023  37743       RANJITH P R      29/05/2023      RAMESH G       AAKH-CRF-0164
19/10/2023              Srinivasa N T              19/10/2023      RAMESH G       AAKH-CRF-0165
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page import ="java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
		<title><fmt:message key="eCA.caparam.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src='../js/CAParam.js'						language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--69244-->
</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<form name="ca_param_form" id="ca_param_form" action='../../servlet/eCA.CAParamServlet' method="post" target="messageFrame">
<%		  
try
{
	    conlCon = ConnectionManager.getConnection(request);
		String pinValidReqYN = ""; 
		String paramQuery = "";
		String pin_req_checked = "";
		String sumMenuAutoRef = "10";//IN052053
		String pendDisSumGracPrd = "";//IN061885
		String selfNoteAutoRef = "";//IN066237
		String centrdefdays="";//IN065341
		int rec_exists = 0;
		int TimeDuration=0; //IN062606
		String finacial_details_req_checked="";//added for IN063285
		String finacialDetailsReqYN="";//added  for IN063285
	     String clinicalEventHstryYN="";//ADDED FOR IN066119
	     String clinical_Event_Hstry_chk1="";//ADDED FOR IN066119
	     String clinical_Event_Hstry_chk2="";//ADDED FOR IN066119
		String ackVitalsYN = "";//IN069852
		String ackVitalsChk = "";//IN069852
		String chartDesc    = "";//IN069244
		String chart_id		= "";//IN069244
		String specimen="";//IN070032
		String specimen_ind="";//IN070032
	    String specimen_wise="";//IN070032
		boolean finacialDtl_Site_flag = eCommon.Common.CommonBean.isSiteSpecific(conlCon, "CA","FINACIAL_DTL_REQ_YN");//added for IN063285
		boolean Self_Notes_flag = eCommon.Common.CommonBean.isSiteSpecific(conlCon, "CA","SELF_NOTE_REFRESH");//added for IN066237
		boolean  central_default_flag=eCommon.Common.CommonBean.isSiteSpecific(conlCon, "CA","CENTRALSED_DEFAULT_DAYS");//added for IN065341
		boolean  ackVitals_SiteFlag =eCommon.Common.CommonBean.isSiteSpecific(conlCon, "CA","THIRDPARTY_VITALS_ACK");//added for IN069852
		boolean siteUom =eCommon.Common.CommonBean.isSiteSpecific(conlCon, "CA","UOM_DETAILS");//AAKH-CRF-0165
				//System.out.println("@@@@@------siteUom79@@@---"+siteUom);
		String thirdPartyDataView="";//IN069384
		String thirdPartyDataView_G="",thirdPartyDataView_T="",thirdPartyDataView_D="";//IN069384,IN0165
		String checktrue="",hideBedNo="";//6451
		String suspInacPatYN="N",suspInacPaCheck=""; //31884
		String chiefComplaintMandYN="N", chiefComplaintMandCheck=""; //37743
		String chiefRemarksYN="N",chiefRemarksYNCheck=""; //37743
		String ackthirdpartyvitalsDC_YN="N",ackthirdpartyvitalsDC_YNCheck=""; //32411
		String ackthirdpartyvitalsEM_YN="N",ackthirdpartyvitalsEM_YNCheck=""; //32411
		String ackthirdpartyvitalsIP_YN="N",ackthirdpartyvitalsIP_YNCheck=""; //32411
		String ackthirdpartyvitalsOP_YN="N",ackthirdpartyvitalsOP_YNCheck=""; //32411
		
		//IN061885 starts
		//IN052053 Start
		//paramQuery = " SELECT CONF_PIN_REQ_YN FROM CA_PARAM";
		//paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF FROM CA_PARAM";
	//	paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,TIME_DURATION_MY_REF,FINACIAL_DTL_REQ_YN FROM CA_PARAM";
//		paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF FROM CA_PARAM";//CLN_HIST_DEFAULT_MODE ADDED FOR IN066119
		//paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF FROM CA_PARAM";//SELF_NOTES_AUTO_REF added for IN066237
		//paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF,CENTRALSED_DEFAULT_DAYS FROM CA_PARAM";//CENTRALSED_DEFAULT_DAYS added for IN065341
		//IN052053 End
		//IN061885 ends
		//paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF,CENTRALSED_DEFAULT_DAYS,ACK_THIRDPARTY_VITALS_YN FROM CA_PARAM";//Modified for IN069852
		//paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF,CENTRALSED_DEFAULT_DAYS,ACK_THIRDPARTY_VITALS_YN,THIRDPARTY_VITALS_CHART_ID,(select nvl(short_desc,'') from ca_chart where chart_id=thirdparty_vitals_chart_id) thirdparty_chart_desc FROM CA_PARAM";//Modified for IN069244
		//paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF,CENTRALSED_DEFAULT_DAYS,ACK_THIRDPARTY_VITALS_YN,THIRDPARTY_VITALS_CHART_ID,(select nvl(short_desc,'') from ca_chart where chart_id=thirdparty_vitals_chart_id) thirdparty_chart_desc,SPECIMEN_WISE,THIRDPARTY_VITALS_VIEW FROM CA_PARAM";//IN070032//IN069384  //6451
		//31884 Start
	//	paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF,CENTRALSED_DEFAULT_DAYS,ACK_THIRDPARTY_VITALS_YN,THIRDPARTY_VITALS_CHART_ID,(select nvl(short_desc,'') from ca_chart where chart_id=thirdparty_vitals_chart_id) thirdparty_chart_desc,SPECIMEN_WISE,THIRDPARTY_VITALS_VIEW,HIDE_BED_NO_LISTBYLOCA_YN,CHIEF_COMPLAINT_MAND_YN,CHIEF_REMARKS_MAND_YN,ACK_THIRDPARTY_VITALS_DC_YN,ACK_THIRDPARTY_VITALS_EM_YN,ACK_THIRDPARTY_VITALS_IP_YN,ACK_THIRDPARTY_VITALS_OP_YN FROM CA_PARAM";//IN070032//IN069384//6451 //37743 //32411
 		paramQuery = " SELECT CONF_PIN_REQ_YN, SUM_MENU_AUTO_REF, PEND_DISCHRG_SUMM_DAYS,FINACIAL_DTL_REQ_YN,CLN_HIST_DEFAULT_MODE,TIME_DURATION_MY_REF,SELF_NOTES_AUTO_REF,CENTRALSED_DEFAULT_DAYS,ACK_THIRDPARTY_VITALS_YN,THIRDPARTY_VITALS_CHART_ID,(select nvl(short_desc,'') from ca_chart where chart_id=thirdparty_vitals_chart_id) thirdparty_chart_desc,SPECIMEN_WISE,THIRDPARTY_VITALS_VIEW,HIDE_BED_NO_LISTBYLOCA_YN,SUSP_INACT_PAT_YN,CHIEF_COMPLAINT_MAND_YN,CHIEF_REMARKS_MAND_YN,ACK_THIRDPARTY_VITALS_DC_YN,ACK_THIRDPARTY_VITALS_EM_YN,ACK_THIRDPARTY_VITALS_IP_YN,ACK_THIRDPARTY_VITALS_OP_YN FROM CA_PARAM";//32411
		//31884  End. //37743
		pstmt = conlCon.prepareStatement( paramQuery);
		rslRst = pstmt.executeQuery();
		if(rslRst.next())
		{
			rec_exists = 1;
			do
			{
				pinValidReqYN 		=  	rslRst.getString("CONF_PIN_REQ_YN");	
				sumMenuAutoRef		=	rslRst.getString("SUM_MENU_AUTO_REF");//IN052053
				pendDisSumGracPrd	=	rslRst.getString("PEND_DISCHRG_SUMM_DAYS");//IN061885
				finacialDetailsReqYN =  	rslRst.getString("FINACIAL_DTL_REQ_YN");	//added for IN063285
				TimeDuration      =rslRst.getInt("TIME_DURATION_MY_REF");//IN062606
                    		clinicalEventHstryYN=rslRst.getString("CLN_HIST_DEFAULT_MODE");//ADDED FOR IN066119
				selfNoteAutoRef		= rslRst.getString("SELF_NOTES_AUTO_REF")==null?"":rslRst.getString("SELF_NOTES_AUTO_REF");//IN066237
				centrdefdays	=	rslRst.getString("CENTRALSED_DEFAULT_DAYS")==null?"30":rslRst.getString("CENTRALSED_DEFAULT_DAYS");//IN065341
				ackVitalsYN		= rslRst.getString("ACK_THIRDPARTY_VITALS_YN")==null?"N":rslRst.getString("ACK_THIRDPARTY_VITALS_YN");//IN069852
				chart_id=rslRst.getString("THIRDPARTY_VITALS_CHART_ID")==null?"":rslRst.getString("THIRDPARTY_VITALS_CHART_ID");//IN069244
				chartDesc	= rslRst.getString("THIRDPARTY_CHART_DESC")==null?"":rslRst.getString("THIRDPARTY_CHART_DESC");//IN069244
				specimen	= rslRst.getString("SPECIMEN_WISE")==null?"S":rslRst.getString("SPECIMEN_WISE");//IN070032
				thirdPartyDataView	= rslRst.getString("THIRDPARTY_VITALS_VIEW")==null?"S":rslRst.getString("THIRDPARTY_VITALS_VIEW");//IN069384
				hideBedNo=rslRst.getString("HIDE_BED_NO_LISTBYLOCA_YN")==null?"N":rslRst.getString("HIDE_BED_NO_LISTBYLOCA_YN");//GHL-CRF-0623 6451
				suspInacPatYN			= 	rslRst.getString("SUSP_INACT_PAT_YN")==null?"T":rslRst.getString("SUSP_INACT_PAT_YN");//31884
				chiefComplaintMandYN	= rslRst.getString("CHIEF_COMPLAINT_MAND_YN")==null?"N":rslRst.getString("CHIEF_COMPLAINT_MAND_YN"); //37743
				chiefRemarksYN			= rslRst.getString("CHIEF_REMARKS_MAND_YN")==null?"N":rslRst.getString("CHIEF_REMARKS_MAND_YN");    //37743
				ackthirdpartyvitalsDC_YN			= rslRst.getString("ACK_THIRDPARTY_VITALS_DC_YN")==null?"N":rslRst.getString("ACK_THIRDPARTY_VITALS_DC_YN");//32411
				ackthirdpartyvitalsEM_YN			= rslRst.getString("ACK_THIRDPARTY_VITALS_EM_YN")==null?"N":rslRst.getString("ACK_THIRDPARTY_VITALS_EM_YN");//32411
				ackthirdpartyvitalsIP_YN			= rslRst.getString("ACK_THIRDPARTY_VITALS_IP_YN")==null?"N":rslRst.getString("ACK_THIRDPARTY_VITALS_IP_YN");//32411
				ackthirdpartyvitalsOP_YN			= rslRst.getString("ACK_THIRDPARTY_VITALS_OP_YN")==null?"N":rslRst.getString("ACK_THIRDPARTY_VITALS_OP_YN");//32411
			}
			while(rslRst.next());
			out.println("<input type='hidden' name='mode' id='mode' value='update'>");
		}
		else
		{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
		}
		if(pinValidReqYN.equals("Y"))
		{
			pin_req_checked = "checked";
		}
		else
		{
			pin_req_checked = "";
		}
		//added for IN063285 start
		if(finacialDetailsReqYN.equals("Y"))
		{
			finacial_details_req_checked = "checked";
		}
		else
		{
			finacial_details_req_checked = "";
		}
		//added for IN063285 end
		//ADDED FOR IN066218 START
		if(clinicalEventHstryYN.equals("F")){
			clinical_Event_Hstry_chk1="checked";
			clinical_Event_Hstry_chk2="";
		}
		else if(clinicalEventHstryYN.equals("T")){
			clinical_Event_Hstry_chk1="";
			clinical_Event_Hstry_chk2="checked";
		}
		if(specimen.equals("S")){
			specimen_wise="checked";
			specimen_ind="";
		}
		//IN070032 STARTS
		else if(specimen.equals("I")){
			specimen_wise="";
			specimen_ind="checked";
		}
		//IN070032 ENDS
		//ADDED FOR IN066218 END
		//IN069852 starts
		
		if(ackVitalsYN.equals("Y")){
			ackVitalsChk="checked";
		}
		
		//IN069852 ends
		//IN069384 STARTS
		//AAKH-CRF-0165--STARTS
		if(thirdPartyDataView.equals("T")){
			thirdPartyDataView_T="checked";
		thirdPartyDataView_G="";
		thirdPartyDataView_D="";
	}
	else if(thirdPartyDataView.equals("G"))
	{
		thirdPartyDataView_G="checked";
		thirdPartyDataView_T="";
		thirdPartyDataView_D="";
	}
	else if(thirdPartyDataView.equals("D"))
	{
		thirdPartyDataView_D="checked";
		thirdPartyDataView_T="";
		thirdPartyDataView_G="";
	}
	//6451
		if(hideBedNo.equals("Y"))
			checktrue="checked";
		else 
			checktrue="";
	//6451
		//IN069384 ENDS	
               //AAKH-CRF-0165--END
	
	if(suspInacPatYN.equals("Y"))
		suspInacPaCheck="checked";
	else 
		suspInacPaCheck="";
	
	//37743 -STARTS
	if(chiefComplaintMandYN.equals("Y"))
		chiefComplaintMandCheck="checked";
	else 
		chiefComplaintMandCheck="";
		
	if(chiefRemarksYN.equals("Y"))
		chiefRemarksYNCheck="checked";
	else 
		chiefRemarksYNCheck="";
	//37743 -ENDS
	
	//32411 starts
	if(ackthirdpartyvitalsDC_YN.equals("Y"))
		ackthirdpartyvitalsDC_YNCheck="checked";
	else 
		ackthirdpartyvitalsDC_YNCheck="";
	if(ackthirdpartyvitalsEM_YN.equals("Y"))
		ackthirdpartyvitalsEM_YNCheck="checked";
	else 
		ackthirdpartyvitalsEM_YNCheck="";
	if(ackthirdpartyvitalsIP_YN.equals("Y"))
		ackthirdpartyvitalsIP_YNCheck="checked";
	else 
		ackthirdpartyvitalsIP_YNCheck="";
	if(ackthirdpartyvitalsOP_YN.equals("Y"))
		ackthirdpartyvitalsOP_YNCheck="checked";
	else 
		ackthirdpartyvitalsOP_YNCheck="";
	//32411 ends
	
	//37743 -ENDS
%>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
	<table cellpadding='3' cellspacing='0' border='0' width='60%' align='center'>
	
	<tr>
		  <td width="40%" class="label"><fmt:message key="eCA.pinvalidreq.label" bundle="${ca_labels}"/></td> 
		  <td width="60%" class='fields'><input type="checkbox" name="conf_pin_req_yn" id="conf_pin_req_yn" value="<%=pinValidReqYN%>" onclick='assignVal(this);'<%=pin_req_checked%>>
		  </td>
	</tr>
	<!-- IN052053 Start -->
	<tr>
		  <td width="40%" class="label"><fmt:message key="eCA.AutoRefTime.label" bundle="${ca_labels}"/></td>
		  <td width="60%" class='fields'><input type="text" name="sum_menu_auto_ref" id="sum_menu_auto_ref" id="sum_menu_auto_ref_id" size="2" maxlength="2" value='<%=sumMenuAutoRef%>' onblur="validateMinMaxTime()" onKeyPress="return CheckForNums(event)"/>&nbsp;&nbsp;<fmt:message key="eCA.Mins.label" bundle="${ca_labels}"/><img src='../../eCommon/images/mandatory.gif'> 
		  </td>
	</tr>
	<!-- IN052053 End -->
	<!-- IN061885 Start -->
	<tr>
		  <td width="40%" class="label"><fmt:message key="eCA.PendDischSummGracePeriod.label" bundle="${ca_labels}"/></td>
		  <td width="60%" class='fields'><input type="text" name="pend_dis_summ_grace_period" id="pend_dis_summ_grace_period" id="pend_dis_summ_grace_period_id" size="2" maxlength="1" value='<%=pendDisSumGracPrd%>' onblur="validateMinMaxDays()" onKeyPress="return CheckForNumsDays(event)"/>&nbsp;&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'> 
		  </td>
	</tr>
	<!-- IN061885 End -->	
	<!-- IN062606 Start -->
	<tr>
		  <td width="50%" class="label"><fmt:message key="eCA.TimeFrameDurtn.label" bundle="${ca_labels}"/></td>
		  <td width="60%" class='fields'><input type="text" name="Time_frm_durn" id="Time_frm_durn" id="Time_frm_durn" size="2" maxlength="2" value='<%=TimeDuration%>' onblur="validateMinMaxHours()" onKeyPress="return CheckForNumsHours(event)"/>&nbsp;&nbsp;<fmt:message key="eCA.Hr24Formt.label" bundle="${ca_labels}"/><img src='../../eCommon/images/mandatory.gif'> 
		  </td>
	</tr>
	<!-- IN062606 End -->
	<!--added for IN063285 start -->
	<%if(finacialDtl_Site_flag){%>
	<tr>
		  <td width="40%" class="label"><fmt:message key="eCA.FinacialDetailsPopup.label" bundle="${ca_labels}"/></td> 
		  <td width="60%" class='fields'><input type="checkbox" name="finacial_dtl_req_yn" id="finacial_dtl_req_yn" value="<%=finacialDetailsReqYN%>" onclick='assignValForFinacialChk(this);'<%=finacial_details_req_checked%>>
		  </td>
		  <!--added for IN063285 end -->
	</tr>
	<%} %>
	<!-- ADDED FOR IN066218 START -->
	<tr>
	<td width="40%" class="label"><fmt:message key="eCA.ClinicalEventHistory.label" bundle="${ca_labels}"/> <fmt:message key="eCA.DefaultView.label" bundle="${ca_labels}"/></td>
	<td class="label" id="radio_event" >
	<input type="radio" name="clinical_event" id="clinical_event" onclick="clinicalEventHistory(this)"  value="F" <%=clinical_Event_Hstry_chk1%>><fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/> 
	<input type="radio" name="clinical_event" id="clinical_event" onclick="clinicalEventHistory(this)"  value="T" <%=clinical_Event_Hstry_chk2%>><fmt:message key="eCA.tree.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<fmt:message key="eCA.View.label" bundle="${ca_labels}"/>
	</td>
	</tr>						
	
	<!--ADDED FOR IN066218 START -->
	<!-- IN066237 Start -->
	<%if(Self_Notes_flag){%>
	<tr>
		  <td width="40%" class="label"><fmt:message key="eCA.SelfNoteRefTime.label" bundle="${ca_labels}"/></td>
		  <td width="60%" class='fields'><input type="text" name="self_note_auto_ref" id="self_note_auto_ref" id="self_note_auto_ref" size="2" maxlength="2" value='<%=selfNoteAutoRef%>' onblur="validateMinMaxTime()" onKeyPress="return CheckForNums(event)"/>&nbsp;&nbsp;<fmt:message key="eCA.Mins.label" bundle="${ca_labels}"/>
		  </td>
	</tr>
	<%}%>
	<!-- IN066237 End -->
	<!-- IN065341 Start -->
	<%if(central_default_flag){%>
	<tr>
		  <td width="60%" class="label"><fmt:message key="eCA.centralsed_default_days.label" bundle="${ca_labels}"/></td>
		  <td width="60%" class='fields'><input type="text" name="central_default_days" id="central_default_days" id="central_default_days_id" size="3" maxlength="3" value='<%=centrdefdays%>' onblur="validateMinMaxDays()"onKeyPress="return CheckForNums(event)"/>&nbsp;&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'>
		  </td>
	</tr>
	<%}%>
	<!-- IN065341 End -->
	<!-- IN069852 starts -->
	<%if(ackVitals_SiteFlag){%>
		<tr>
			  <td width="40%" class="label"><fmt:message key="eCA.ThirdPartyVitalsAck.label" bundle="${ca_labels}"/></td> 
			  <td width="60%" class='fields'><input type="checkbox" id="ackThirdPartyVitals" name="ackThirdPartyVitals" id="ackThirdPartyVitals" value="<%=ackVitalsYN%>" <%=ackVitalsChk%> onclick='checkVitals(this);PatientsTable(this);' /></td>  <!-- 32411-->
		</tr>
			 <!-- 32411-start-->
		<tr>
			<td width="40%" class="label"></td>
			<td width="60%" class='fields'>
				<table  width='100%' class='grid' id='titleTable' <%if(ackVitalsYN.equals("N")){%> disabled="disabled"<% } %> >	   		 
					<tr border='0' id='divTitleTable1'> 
						<th class='columnHeadercenter'   border='0'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
						<th class='columnheadercenter'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>
				         <input type="checkbox" id="selectAll"  onClick="checkAll();" >
						</th>
							</tr>
					<tr>
						<td class="label"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td> 
						<td class='fields'><input type="checkbox" name="thirdpartyvitalsDC" id="thirdpartyvitalsDC"  id="thirdpartyvitalsDC" value="<%=ackthirdpartyvitalsDC_YN%>" <%=ackthirdpartyvitalsDC_YNCheck%> onclick="ackthirdpartyvitalsDC_YNClick(this);" ></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td> 
						<td class='fields'><input type="checkbox" name="thirdpartyvitalsEM" id="thirdpartyvitalsEM" id="thirdpartyvitalsEM" value="<%=ackthirdpartyvitalsEM_YN%>" <%=ackthirdpartyvitalsEM_YNCheck%> onclick="ackthirdpartyvitalsEM_YNClick(this);" ></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td> 
						<td class='fields'><input type="checkbox" name="thirdpartyvitalsIP" id="thirdpartyvitalsIP" id="thirdpartyvitalsIP" value="<%=ackthirdpartyvitalsIP_YN%>" <%=ackthirdpartyvitalsIP_YNCheck%> onclick="ackthirdpartyvitalsIP_YNClick(this);" ></td>
					</tr> 
					<tr>
						<td class="label"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></td> 
						<td class='fields'><input type="checkbox" name="thirdpartyvitalsOP" id="thirdpartyvitalsOP" id="thirdpartyvitalsOP" value="<%=ackthirdpartyvitalsOP_YN%>" <%=ackthirdpartyvitalsOP_YNCheck%> onclick="ackthirdpartyvitalsOP_YNClick(this);" ></td>
					</tr>													
				
				</table>
		
			</td>
		</tr>
	     <!-- 32411-End-->
		<!--  //IN069384 starts -->
		<tr id='thirdpartdata' style="display:none;">
	<TD class='label'> <fmt:message key="eCA.ThirdPartyVitalsDataRep.label" bundle="${ca_labels}"/> </TD>
	    <td class="label" id="radio_event" >
		<input type="radio"  id="thirdpartydataT" name="thirdpartydataView" id="thirdpartydataView" value="T" <%=thirdPartyDataView_T%> onclick="thirdPartyData(this)" ><fmt:message key="eCA.TableView.label" bundle="${ca_labels}"/> 
		<input type="radio"  id="thirdpartydataG" name="thirdpartydataView" id="thirdpartydataView" value="G"  <%=thirdPartyDataView_G%> onclick="thirdPartyData(this)" ><fmt:message key="eCA.GraphView.label" bundle="${ca_labels}"/>
	       
	    <% if(siteUom){ %>
		<input type="radio"  id="thirdpartydataD" name="thirdpartydataView" id="thirdpartydataView" value="D"  <%=thirdPartyDataView_D%> onclick="thirdPartyData(this)" ><fmt:message key="eCA.DateTimewiseview.label" bundle="${ca_labels}"/>
		<%} %>
		
		</td>
	 </tr>
	 <!--  //IN069384 ends -->
	<!--IN069244starts-->
	<tr>
		  <td class='label'  ><fmt:message key="eCA.mappingExistingChartId.label" bundle="${ca_labels}"/>
			<td  class='fields' width='25%'><input type='text'  disabled id='THIRDPARTY_VITALS_CHART_ID_DESC' name='THIRDPARTY_VITALS_CHART_ID_DESC' id='THIRDPARTY_VITALS_CHART_ID_DESC' value='<%=chartDesc%>'  size='15' maxlength='15' align="center" ><input type='hidden'  id='THIRDPARTY_VITALS_CHART_ID' name='THIRDPARTY_VITALS_CHART_ID' id='THIRDPARTY_VITALS_CHART_ID' value="<%=chart_id%>" size='15' maxlength='15' align="center" ><input type='button' name='CHART' id='CHART'  value='?' class='button' onclick='callFunctionChart(THIRDPARTY_VITALS_CHART_ID,THIRDPARTY_VITALS_CHART_ID_DESC)'></td> </tr>
		  </td>
	</tr>
	<!--IN069244 ends-->
	<%}%>
	<!-- IN069852 ends -->
	<!--IN070032starts -->
	<tr>
		<td width="40%" class="label"><fmt:message key="eCA.ControlToViewAndPrint.label" bundle="${ca_labels}"/></td>
		<td class="label" id="radio_event" >
		<input type="radio" name="specimen_print" id="specimen_print" onclick="specimenWise(this)"  value="S" <%=specimen_wise%>><fmt:message key="eCA.SpecimenWise.label" bundle="${ca_labels}"/> 
		<input type="radio" name="specimen_print" id="specimen_print" onclick="specimenWise(this)"  value="I" <%=specimen_ind%>><fmt:message key="eCA.SpecimenIndividualPanelWise.label" bundle="${ca_labels}"/>
		</td>					
	</tr>
	<!--IN070032ends -->
	<!--6451-->
	<tr>
	<td  width="40%" class="label"><fmt:message key="eCA.HideBed.label" bundle="${ca_labels}"/></td> 
	<td  class="label" >
	<input type="checkbox" id="hide_check" value="<%=hideBedNo%>" <%=checktrue%> onclick="hiding(this);"></td>
	</tr>
	<!--6451-->
	<!-- 31884 Start-->
	<tr style='display:none'> <!-- 32902 -->
		<td  width="40%" class="label"><fmt:message key="eCA.SuspendedInactivepatient.label" bundle="${ca_labels}"/></td> 
		<td width="60%" class='fields'>
			<input type="checkbox" id="hide_check" value="<%=suspInacPatYN%>" <%=suspInacPaCheck%> onclick="supInacPayClick(this);"></td>
		</td>  
	</tr>
	<!-- 31884 -->
	<!-- 37743 STARTS -->
	<tr>
		<td  width="40%" class="label"><fmt:message key="eCA.ChiefComplaintMandatory.label" bundle="${ca_labels}"/></td> 
		<td width="60%" class='fields'>
			&nbsp;<input type="checkbox" id="chiefComplaint_MandYN" value="<%=chiefComplaintMandYN%>" <%=chiefComplaintMandCheck%> onclick="chComplntDetlsClick(this);"><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/><BR>
			&nbsp;<input type="checkbox" id="chief_RemarksYN"  value="<%=chiefRemarksYN%>" <%=chiefRemarksYNCheck%> onclick="chComplntRemarksClick(this);"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/>
		</td>  
	</tr>
	<!-- 37743 ENDS -->
</table>
<input type='hidden' name="chartDesc" id="chartDesc"  value="<%=chartDesc%>"><!--IN069244-->
<input type='hidden' name="chart_id" id="chart_id"  value="<%=chart_id%>"><!--IN069244-->
<input type ="hidden" name="site" id="site"  value="<%=finacialDtl_Site_flag%>" />
<input type="hidden" name="cln_hist_default_mode" id="cln_hist_default_mode" value="<%=clinicalEventHstryYN%>"><!-- ADDED FOR IN066119  -->
<input type ="hidden" id="self_note_auto_ref"name="self_note_auto_ref"  value="<%=selfNoteAutoRef%>" /><!--IN066237-->
<input type ="hidden" id="central_default_days"name="central_default_days"  value="<%=centrdefdays%>" /><!--IN065341-->
<input type="hidden" name="specimen_wise" id="specimen_wise" value="<%=specimen%>"><!-- IN070032  -->
<input type ="hidden" id="flag" name="flag" id="flag"  value="true" /><!--IN069244-->
<input type="hidden" id="third_party_vitals_view" name="third_party_vitals_view" id="third_party_vitals_view" value="<%=thirdPartyDataView%>"><!-- IN069384 -->
<input type="hidden" name="ackVitals_SiteFlag" id="ackVitals_SiteFlag" id="ackVitals_SiteFlag" value="<%=ackVitals_SiteFlag%>"><!-- IN069384 -->
<input type="hidden" name="bed_hide" id="bed_hide" id="bed_hide" value="<%=hideBedNo%>"><!-- IN069384 -->
<input type="hidden" name="suspInacPatYN" id="suspInacPatYN" id="suspInacPatYN" value="<%=suspInacPatYN%>"><!-- 31884 -->
<input type="hidden" name="chiefComplaintMandYN" id="chiefComplaintMandYN" id="chiefComplaintMandYN" value="<%=chiefComplaintMandYN%>"> <!--37743 -->
<input type="hidden" name="chiefRemarksYN" id="chiefRemarksYN" id="chiefRemarksYN" value="<%=chiefRemarksYN%>"> <!--37743 -->
<input type="hidden" name="ackthirdpartyvitalsDC_YN" id="ackthirdpartyvitalsDC_YN" id="ackthirdpartyvitalsDC_YN" value="<%=ackthirdpartyvitalsDC_YN%>">  <!--32411 -->
<input type="hidden" name="ackthirdpartyvitalsEM_YN" id="ackthirdpartyvitalsEM_YN" id="ackthirdpartyvitalsEM_YN" value="<%=ackthirdpartyvitalsEM_YN%>"> <!--32411 -->
<input type="hidden" name="ackthirdpartyvitalsIP_YN" id="ackthirdpartyvitalsIP_YN" id="ackthirdpartyvitalsIP_YN" value="<%=ackthirdpartyvitalsIP_YN%>"> <!--32411 -->
<input type="hidden" name="ackthirdpartyvitalsOP_YN" id="ackthirdpartyvitalsOP_YN" id="ackthirdpartyvitalsOP_YN" value="<%=ackthirdpartyvitalsOP_YN%>"> <!--32411 -->
</form>
</body>
<!--  //IN069384 starts -->
<script>
if(<%=ackVitals_SiteFlag%>){
	checkAllVal();//32411

	if("Y"=='<%=ackVitalsYN%>')
		document.getElementById("thirdpartdata").style='display';
	else
			document.getElementById("thirdpartdata").style.display='none';
}
</script>
<!--  //IN069384 ends -->
</html>
<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in CAParamAddModify.jsp : "+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

}
%>

