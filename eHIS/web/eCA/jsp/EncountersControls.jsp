<!-- 
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           										created
20/06/2012	  IN033489		Menaka V											Report header blank in 
																				clinical event history.										
07/01/2013	  IN035950		Nijitha												CHL Hospital suggested that the 
																				presentation of the Clinician desktop be changed and more appealing. Keeping the display of information more clear and visible.
18/07/2013		IN034514	Karthi L											In Clinical Event History, one could see
																				information about patient's visit as a summary which included Patient Admission date, date of discharge, attending practitioner, etc
10/06/2015		IN057797	Vijayakumar K										GHL-SCF-976 [IN:057797]
16/11/2015		IN057113	Karthi L							 				ML-MMOH-CRF-0335 - IN057113
17/12/2015     	IN058148    Prathyusha   Allow copy text from event history views
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/10/2016	IN047572			Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?				
23/10/2018		IN068011		Raja S			23/10/2018		Ramesh G		ML-MMOH-CRF-1204	
02/01/2019  		IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-CRF-0491
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020		39052			Ramesh											ML-BRU-CRF-0634
--------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,webbeans.eCommon.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p	= (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String login_user = (String)session.getValue("login_user");//IN071561
	String archivalYN= request.getParameter("archivalYN")==null?"N": request.getParameter("archivalYN");//52176
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/common.js" language="javascript"></script>
<STYLE>
	td.errorEvents
	{
		background-color: BROWN;
		border-style: dashed;
	}
	FONT.CRITICAL{
		background-color:#D2B48C;
	}
	FONT.ABNORMAL{
		background-color:#FFF8DC;
	}
	FONT.HIGH{
		background-color:#FFC0CB;
	}
	FONT.LOW{
		background-color:#F0FFFF;
	}
	FONT.CRITICALLOW{
		background-color:#D8BFD8;
	}
	FONT.CRITICALHIGH{
		background-color:#F4A460;
	}

	FONT.DELTAFAIL{
		background-color:#FFE4E1;
	}

</STYLE>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCA/js/Encounters.js'></script>
<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
<script src='../../eCA/js/ViewClinicalDocument.js' language='javascript'></script>

</HEAD>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmtDt = null;

	ResultSet rsDt = null;
	ResultSet rs = null;
	
	String high_str = "",low_str="",abn_str="",crit_str="",crit_high_str="",crit_low_str="",delta_fail_str="";

	String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "";
	String birth="";
	String called_from ="";
	String strFromDate  = "";
	String strToDate = "";
	String strPatientId = "";
	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";
	String strEncounterId ="";
	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String strErrorEvent ="";
	String event_date="";
	String strEncId="";
	String EHR_YN="";
	String defPrevStatus = "";
	//String lastAddedDate = "";
	String emailDisp = "style='display'";
	//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	//ML-MMOH-CRF-0335 - IN057113 - End
	StringBuffer sbQryCriteria = new StringBuffer();
	StringBuffer	strBuffDates	= new StringBuffer();
	String calling_from_2T = request.getParameter("calling_from_2T")==null?"":request.getParameter("calling_from_2T");//IN068011

	int nKey = 0;
	int nIndex =1;

	strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");

	if(strGraphOrder.equals("D"))
		strGraphOrder = "desc";
	else if(strGraphOrder.equals("A"))
		strGraphOrder = "asc";

	//strViewConfRes	= request.getParameter("viewby")==null?"":request.getParameter("viewby");
	strViewConfRes	= request.getParameter("view_by")==null?"":request.getParameter("view_by");
	strFromDate		= request.getParameter("from_date")==null?"":request.getParameter("from_date"); 
	strToDate		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
	strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
	strToDate		= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");
	event_date		= request.getParameter("event_date")==null?"":request.getParameter("event_date");
	strEventCode	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
	// strErrorEvent= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
	strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	strPatientId	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	strEventGroup	= request.getParameter("event_group")==null?"":request.getParameter("event_group");
	strEventClass	= request.getParameter("event_class")==null?"":request.getParameter("event_class");
	strHistRecType	= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	//called_from	= request.getParameter("called_from")==null?"":request.getParameter("p_called_from");
	strFacilityId	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	strEpisodeType	= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
	strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	strEncId		= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	strNormalcyInd	= request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String eventdate = request.getParameter("event_date")==null?"":request.getParameter("event_date");
	EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
	String sortOrder = request.getParameter("sortOrder")==null?"desc":request.getParameter("sortOrder");

	String show_mode = request.getParameter("show_mode")==null?"":request.getParameter("show_mode");
	String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class"); //IN034514
	String p_enc_details_tree		=	request.getParameter("p_enc_details_tree")==null?"":request.getParameter("p_enc_details_tree");//IN034514
	String encntr_yn		=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");//IN034514
	
	String p_menu_type		=	request.getParameter("p_menu_type")==null?"":request.getParameter("p_menu_type");//IN034514
	String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
	String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	String key_ref = strPatientId+strEncounterId+strFacilityId;
	String strRowId = "";
	String enctr_id = "";//IN031989
	String fac_id = "";//IN033489
	if(strEpisodeType.equals(""))
		strEpisodeType = "B";
	String resp_id = (String)session.getValue("responsibility_id"); //IN057797
	String printDisp = "style='display'"; //IN057797
	String defPrevStatusForPrint = ""; //IN057797
	String isSiteSpecificForLabPrint = request.getParameter("isSiteSpecificForLabPrint")==null?"":request.getParameter("isSiteSpecificForLabPrint");//IN066453
	eCA.ChartRecordingAddGroupBean encounterBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("encounterBean"+key_ref,"eCA.ChartRecordingAddGroupBean",session);
	boolean restrict_rd	=false;	//IN071561
	encounterBean.clearBean();
	try
	{
		con = ConnectionManager.getConnection(request);
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
	if(strEncId.equals("")) strEncId = "0";

	if(called_from.equals("OR"))
		disabled = "disabled";

	sbQryCriteria.append(" a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= a.FACILITY_ID AND F.ENCOUNTER_ID(+) = a.ENCOUNTER_ID ");  // ##ORDERTYPERESULT## added for 39052

	if(!strHistRecType.equals(""))
		sbQryCriteria.append(" and a.hist_rec_type = ? ");

	if(!strEventClass.equals(""))
		sbQryCriteria.append(" and a.event_class = ? ");

	if(!strEventGroup.equals(""))
		sbQryCriteria.append(" and a.event_group = ? ");

	if(!strEventCode.equals(""))
		sbQryCriteria.append(" and rtrim(a.event_code) = ? ");

	if(!strFromDate.equals(""))
		sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

	if(!strToDate.equals(""))
		sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287"); //adding 59 seconds more to the todate
		
	if(!eventdate.equals("") && strViewConfRes.equals("D"))
		sbQryCriteria.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy')");

	if(!strFacilityId.equals(""))
		sbQryCriteria.append(" and a.facility_id = ? ");
	//IN071561 STARTS
	 if(restrict_rd){
		   //sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");//common-icn-0180
	       sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,?)='N' ");//common-icn-0180
	 }
	//IN071561 ENDS
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class=? ");
		}
		//IN035950 End

	if(!strEncounterId.equals(""))
		sbQryCriteria.append(" and a.encounter_id = ? ");

  //If patient class is not null then this below query is append related to IN18063.
	if (!strEpisodeType.equals("B") )
		sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

	if(strAbnormal.equals("Y"))
	{
		//Modified the following condition by Archana on 9/16/2010 related to the incident IN023804.
		sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	}

	if(strViewConfRes.equals("X"))
		sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");

	if(strErrorEvent.equals("Y"))//dont'include error events
		sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
	else 
		sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 
	
	if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
		if(!speciality_code.equals("")){
			sbQryCriteria.append(" and F.SPECIALTY_CODE = ? ");
		}
	} else {
		sbQryCriteria.append(" and F.ATTEND_PRACTITIONER_ID = ? ");
	} // MMS-QH-CRF-0177 [IN047572] - End

		//IN068011 starts
	if("Y".equals(calling_from_2T))
		sbQryCriteria.append(" and a.Added_BY_ID ='DM'");
	//IN068011 Ends
	/*strBuffDates.append("Select distinct to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");
	strBuffDates.append("where  "+sbQryCriteria.toString());

	if(!strFlowSheetId.equals(""))
		strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=rtrim(a.event_code)  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
			
	strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);*/

	//strBuffDates.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,'"+locale+"','1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,'"+locale+"','1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.rowid row_id From	cr_encounter_detail a ,PR_ENCOUNTER F ");//IN033489
	//strBuffDates.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,'"+locale+"','1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,'"+locale+"','1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.rowid row_id, a.encounter_ID, a.FACILITY_ID From	cr_encounter_detail a ,PR_ENCOUNTER F ");//IN033489//common-icn-0180
	strBuffDates.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1') event_desc, a.rowid row_id, a.encounter_ID, a.FACILITY_ID From	cr_encounter_detail a ,PR_ENCOUNTER F ");//IN033489//common-icn-0180

	strBuffDates.append(" where  "+sbQryCriteria.toString());
	
	strBuffDates.append(" order by ");
	
	strBuffDates.append(" 1 ");
	strBuffDates.append(sortOrder+" ,");

	if(strViewConfRes.equals("D")) 
	{
		strBuffDates.append(" TO_CHAR(event_date,'YYYYMMDD') ");
		strBuffDates.append(sortOrder+" ,") ;
     }
	//strBuffDates.append(" 2,1,4,3,nvl(a.REQUEST_NUM_SEQ,'0'),6,5,8,7, event_date ");
	strBuffDates.append(" 3,2,5,4,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,9,8, event_date ");
	strBuffDates.append(sortOrder);
	
//39052 Start.
	String  sqlQuery = strBuffDates.toString();
	if("CA01".equals(order_type_3T)){
		sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");
	}else{
		sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##","");
	}
	//39052 End.	
		pstmtDt = con.prepareStatement(sqlQuery);
		//common-icn-0180 starts
				pstmtDt.setString(nIndex++, locale);
				pstmtDt.setString(nIndex++, locale);
				pstmtDt.setString(nIndex++, locale);
				pstmtDt.setString(nIndex++, locale);
		//common-icn-0180 ends

		pstmtDt.setString(nIndex++,strPatientId);

		if(!strHistRecType.equals(""))
			pstmtDt.setString(nIndex++,strHistRecType);

		if(!strEventClass.equals(""))
			pstmtDt.setString(nIndex++,strEventClass);

		if(!strEventGroup.equals(""))
			pstmtDt.setString(nIndex++,strEventGroup);

		if(!strEventCode.equals(""))
			pstmtDt.setString(nIndex++,strEventCode);
		
		{
			if(!strFromDate.equals(""))
				pstmtDt.setString(nIndex++,strFromDate);

			if(!strToDate.equals(""))
				pstmtDt.setString(nIndex++,strToDate);
		}
		//else
		/*{
			if(!strFromDate.equals(""))
				pstmtDt.setString(nIndex++,strToDate);

			if(!strToDate.equals(""))
				pstmtDt.setString(nIndex++,strFromDate);
		}
		*/

		if(!eventdate.equals("") && strViewConfRes.equals("D"))
			pstmtDt.setString(nIndex++,eventdate);

		if(!strFacilityId.equals(""))
			pstmtDt.setString(nIndex++,strFacilityId);
		//common-icn-0180 starts
		 if(restrict_rd)
			 pstmtDt.setString(nIndex++,login_user);
		//common-icn-0180 ends
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			pstmtDt.setString(nIndex++,eventClasswidget);
		}
		//IN035950 Ends
		if(!strEncounterId.equals(""))
			pstmtDt.setString(nIndex++,strEncounterId);

	    //If patient class is not null then this below query is append related to IN18063.
		/*modified by Archana on 2/4/2010 at 3:07 PM for IN018685*/
		/*
			strEpisodeType was coming from the tree page as IP instaed of I, so added the || condition
		*/
		if(!strEpisodeType.equals("B") )
		{
			if(strEpisodeType.equals("I") || strEpisodeType.equals("IP"))
				pstmtDt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O") || strEpisodeType.equals("OP"))
				pstmtDt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D") || strEpisodeType.equals("DC"))
				pstmtDt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E") || strEpisodeType.equals("EM"))
				pstmtDt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X") || strEpisodeType.equals("XT"))
				pstmtDt.setString(nIndex++,"XT");
		}
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				pstmtDt.setString(nIndex++, speciality_code);
			}
		} else {
			pstmtDt.setString(nIndex++, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		//if(!strFlowSheetId.equals(""))
			//pstmtDt.setString(nIndex++,strFlowSheetId);

		int nCtr = 0;

		try
		{
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			//String strLastDt = "";
			//Commented by Jyothi on 12/03/2010 to fix 18685
			/*while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);
				if(!show_mode.equals("E"))
				{
					if (nCtr == 0 || nCtr == 10)
					{
						lastAddedDate = strDateRecd;*/
		%>
						<!--<script>
						dtArr[<%=nKey%>] = "<%=strDateRecd%>";
						</script> -->
		<%
						/*nKey++;
						nCtr =0;
					}
				}
				else
				{
					if (nCtr == 0 || nCtr == 3)
					{
						lastAddedDate = strDateRecd;*/
		%>
						<!-- <script>
						dtArr[<%=nKey%>] = "<%=strDateRecd%>";
						</script> -->
		<%
						/*nKey++;
						nCtr =0;
					}
				}
				nCtr++;
			}
			if (!strDateRecd.equals(lastAddedDate))
			{ */%>
			<!--	<script>						
						dtArr[<%=nKey%>] = "<%=strDateRecd%>";					
						
					</script> -->

	<%	
			/*nKey++;
		}
			if(nCtr >= 1)
			{*/
				
				%>
				<!-- <script>dtArr[<%=nKey%>] = "<%=strDateRecd%>";
				
				</script> -->
				<%
			//}
			//Added by Jyothi on 12/03/2010 to fix 18685
			int k = 0;
			while (rsDt.next())
			{
				k++;
				fac_id = rsDt.getString("FACILITY_ID") == null ? "" : rsDt.getString("FACILITY_ID");//IN033489
				enctr_id = rsDt.getString("encounter_ID") == null ? "" : rsDt.getString("encounter_ID");//IN033489
				strRowId = rsDt.getString("row_id") == null ? "" : rsDt.getString("row_id");
				Integer in = new Integer(k);
				encounterBean.addRecords(in.toString(),strRowId);

				if(!show_mode.equals("E"))
				{
					if (nCtr == 0 || nCtr == 15)
					{
						nKey++;
						nCtr = 0;
					}
				}
				else
				{
					if (nCtr == 0 || nCtr == 5)
					{
						nKey++;
						nCtr = 0;
					}
				}
				nCtr++;
			}
		
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
				out.println("clearForm('FS');</script>");
			}


		}
		catch (Exception ee1)
		{
			ee1.printStackTrace();
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}
		
		pstmt = con.prepareStatement("SELECT HIGH_STR,LOW_STR, ABN_STR,CRIT_STR, CRIT_HIGH_STR, CRIT_LOW_STR, DELTA_FAIL_STR, nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmt.setString(1,strPatientId);

		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			high_str		= rs.getString("HIGH_STR");
			low_str			= rs.getString("LOW_STR");
			abn_str			= rs.getString("ABN_STR");
			crit_str		= rs.getString("CRIT_STR");
			crit_high_str	= rs.getString("CRIT_HIGH_STR");
			crit_low_str	= rs.getString("CRIT_LOW_STR");
			delta_fail_str	= rs.getString("DELTA_FAIL_STR");
			birth			= rs.getString("birth");
		}
		
		if(delta_fail_str == null) delta_fail_str="";
	
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'EMAIL_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatus = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";
		
		//IN057797 starts
		pstmt = con.prepareStatement("select GET_TASK_APPLICABILITY('PRINT_CLIN_DATA',NULL,?,NULL) DFLT_PRIVILEGE_STATUS from dual");
		pstmt.setString(1,resp_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatusForPrint = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";
		//IN057797 ends
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

	putObjectInBean("encounterBean"+key_ref,encounterBean,session);

%>

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<BODY  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='encounterform' id='encounterform' >
<input type = hidden  name = idx_value		value = <%=nKey%> >
<input type = hidden  name = cur_idx_value	value = "0">
<input type = hidden  name = called_from	value =<%=called_from%> >
<input type = hidden  name = from_date	value =<%=strFromDate%> >
<input type = hidden  name = to_date		value =<%=strToDate%> >
<input type = hidden  name = patient_id		value =<%=strPatientId%> >
<input type = hidden  name = history_type		value =<%=strHistRecType%> >
<input type = hidden  name = event_class	value =<%=strEventClass%> >
<input type = hidden  name = event_group	value =<%=strEventGroup%> >
<input type = hidden  name = event_item		value =<%=strEventCode%> >
<input type = hidden  name = facility_id	value =<%=strFacilityId%> >
<input type = hidden  name = encounter_id value =<%=strEncounterId%> >
<input type = hidden  name = enc_id value =<%=strEncId%> >
<input type = hidden  name = episode_type	value =<%=strEpisodeType%> >
<input type = hidden  name = normalcy		value =<%=strNormalcyInd%> >
<input type = hidden  name = abnormal		value =<%=strAbnormal%> >
<input type = hidden  name = strFlowSheetId value =<%=strFlowSheetId%> >
<input type = hidden  name = viewConfRes			value =<%=strViewConfRes%> >
<input type = hidden  name = strGraphOrder	value =<%=strGraphOrder%> >
<input type = hidden  name = strErrorEvent	value =<%=strErrorEvent%> >
<input type = hidden  name = event_date	value =<%=event_date%> >
<input type = hidden  name = 'EHR_YN'	value =<%=EHR_YN%> >
<input type = hidden  name = 'page_no'	value = "1" >
<input type="hidden" value="" name="data_type" id="data_type">
<input type = hidden  name = fac_id value =<%=fac_id%> ><!-- IN033489-->
<input type = hidden  name = enctr_id value =<%=enctr_id%> ><!-- IN033489-->
<input type = hidden  name = patient_class value =<%=patient_class%>><!-- IN034514 -->
<input type = hidden  name = p_enc_details_tree value =<%=p_enc_details_tree%>><!-- IN034514 -->
<input type = hidden  name = encntr_yn value =<%=encntr_yn%>><!-- IN034514 -->
<input type = hidden  name = p_menu_type value =<%=p_menu_type%>><!-- IN034514 -->
<input type="hidden" name="l_conf_pin_req_yn" id="l_conf_pin_req_yn" value="<%= conf_pin_req_yn %>"> <!-- ML-MMOH-CRF-0335 - IN057113 -->
<input type="hidden" name="speciality_code" id="speciality_code" value = "<%= speciality_code%>"> <!--  MMS-QH-CRF-0177 [IN047572]  -->
<input type="hidden" name="attend_pract_code" id="attend_pract_code" value = "<%= attend_pract_code%>"> <!-- MMS-QH-CRF-0177 [IN047572]  -->
<input type="hidden" name="p_review_rad_yn" id="p_review_rad_yn" value = "<%= p_review_rad_yn%>"><!--IN071561-->
<input type="hidden" name="order_type_3T" id="order_type_3T" value="<%=order_type_3T%>">  <!-- 39052 -->
<table border=1 cellpadding=0 cellspacing=0 height='100%' width="100%" align='center' id='tablePrevNext' >
<tr><td>
	
		<table border=0 cellpadding=0 cellspacing=0 width="100%">
			<tr>
			<% 
			if(!"Y".equals(archivalYN)){%>
				<td  class='label'>&nbsp;<fmt:message key="eCA.ClickOnValueCell.label" bundle="${ca_labels}"/></td>
				<!-- IN058148 start -->
				<td width='5%' id = 'copy_text_id' style='display:none'>
				<INPUT TYPE="button" value='<fmt:message key="eCA.CopyText.label" bundle="${ca_labels}"/>'  name='copy_text' class='BUTTON' onClick='copyText()' title='Copy Text' alt='Copy Text'/>&nbsp;</td>
				<!-- IN058148 end -->
				<td width='5%'>
				<!--IN066453 disabled condition added for manage,comments & print button-->
						<INPUT TYPE="button" name="manage" id="manage" <%if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){%>disabled<%}%> value='<fmt:message key="eCA.Manage.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='manageText()' title='Click to manage the events'>&nbsp;
				</td>
				<td width='5%'>
						<INPUT TYPE="button" name="comments" id="comments" <%if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){%>disabled<%}%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")%>' class='BUTTON' onClick='showEnterQuickText();' title='Click to enter comments'>&nbsp;
				</td>
				<td  width='3%'>
						<!-- IN057797 starts -->
						<!--<input type="button"  name="print" id="print"  class="button" value='<% //=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="valsForPrint()" title='Click to print the events' >&nbsp;-->
						<input type="button"  name="print" id="print"  <%if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){%>disabled<%}%> class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="valsForPrint()" title='Click to print the events' <%=printDisp%> >&nbsp;
						<!-- IN057797 ends -->
				</td>
				<td width='5%'>
						<INPUT TYPE="button" value='<fmt:message key="eCA.Email.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='emailText()' title='Click to email the events' name='emailBtn' <%=emailDisp%>>&nbsp;
				</td>	

				<!-- Modifeied By 	: Arvind Singh Pal,	Purpose :  For GHL-CRF-0043 on 12 November 2009   -->

				<td width='5%'>
						<INPUT TYPE="button" value='<fmt:message key="eCA.View.label" bundle="${ca_labels}"/>' class='BUTTON' title='Click to view' name='viewBtn' onclick='loadViewPage()'>
				</td>
				<%}%>
				<!-- End Here -->

				<!-- <td align='left' width='5%'><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext1(this)' align='right'></td>
				<td  align ='center' class = 'QRYEVEN'>
						<input type ='label' class="LABEL" name = 'label_cap'> 
				</td>
				<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext1(this)' ></td> -->

				<td align=right style="width: 25%;">
				<table border=0 cellpadding=0 cellspacing=0 width="80%" id='tablePrevNext' style='border-color:#CFCFCD;'>
					<tr>
						<td width='2%' nowrap><img src='../../eCommon/images/iGridSPreviousNOR16.gif' id='first' onclick='loadPrevNext1(this)' <%=disablePrev%> /><img src='../../eCommon/images/iGridPreviousNOR16.gif' id='prev' onclick='loadPrevNext1(this)' <%=disablePrev%> /></td>
						<td id='label_cap' class='Pagination'>&nbsp;</td>
						<td width='2%' nowrap><img src='../../eCommon/images/iGridNextNOR16.gif' id='next' onclick='loadPrevNext1(this)' <%=disableNext%> /><img src='../../eCommon/images/iGridSNextNOR16.gif' id='last' onclick='loadPrevNext1(this)' <%=disableNext%> /></td>

					</tr>
				</table>&nbsp;
				</td>
			</tr>
		</table>
	
	</td></tr>
</table>
<script> 
<!-- IN058148 start -->
<% if(called_from_widget.equals("")){
if(show_mode.equals("E")) {%>
	document.getElementById("copy_text_id").style.display = ''; 
<%
}
}
%><!-- IN058148 end -->
function defaultPage()
{
	var idx_value	= document.forms[0].idx_value.value;

	//var called_from = parent.encountercontrol.document.forms[0].called_from.value;
	var graphorder = parent.encountercontrol.document.forms[0].strGraphOrder.value;
	
	var cur_idx_value = document.forms[0].cur_idx_value.value;

	var fromDateTime ="";
	var toDateTime ="";
	var displend = "";
	var displstart = 1;

	if(idx_value > 0)
	{
		fromDateTime	= document.forms[0].from_date.value;
		toDateTime		= document.forms[0].to_date.value;
		
		if (idx_value >= 1)
		{
			//toDateTime = dtArr[1];
			if (idx_value > 1)
				displend = eval(idx_value) ;
			else
				displend = 1;
		}
		else
			displend = 1;

		parent.encountercontrol.document.forms[0].cur_idx_value.value = 0;
		parent.encountercontrol.document.getElementById('label_cap').innerText = "Page "+ displstart + " of " + displend;
		
		if(displend == 1)
		{
			parent.encountercontrol.document.forms[0].next.disabled = true;
			parent.encountercontrol.document.forms[0].prev.disabled = true;
			parent.encountercontrol.document.forms[0].first.disabled = true;
			parent.encountercontrol.document.forms[0].last.disabled = true;
		}

		populateControl1(fromDateTime,toDateTime);
		//else
		//	populateControlOR(fromDateTime,toDateTime);
	}
}

defaultPage();

</script>
</form>
</BODY>
</HTML>

