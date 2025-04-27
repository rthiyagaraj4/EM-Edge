<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
20/10/2011	  IN032130		 MenakaV	 Admission notes is not coming in clinical history.
13/12/2012	  IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										more appealing. Keeping the display of information more clear and visible.   
15/07/2013	IN034514		Karthi L	In Clinical Event History, one could see information about patient's visit as a 
										summary which included Patient Admission date, date of discharge, attending practitioner, etc	
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality										
--------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
10/10/2016	IN047572		Karthi L											[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
03/11/2016	IN054151		Ramya Maddena	22/11/2016		Karthi L		12.X-Alpha-CA- Clinical Event History - Event Grouping	
22/09/2017  IN065313		Vijayakumar K		22/09/2017		Goli Ramesh		ICN- CEH - Tree view issue [IN:065313] 
23/10/2018	IN068011		Raja S				23/10/2018		Ramesh G		ML-MMOH-CRF-1204
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
05/01/2021	6030		Sivabagyam M		05/01/2021		Ramesh G	ML-MMOH-CRF-1491
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
--------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 	<!-- <link rel="stylesheet" type="text/css" href="../../eCA/html/CAMainMenu.css"></link> -->
<!-- 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p	= (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
%> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCA/js/Encounters.js' language='javascript'></script>
	<script src='../../eCA/js/dTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>
<body class='CA_COMMON'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
	
	var obj;
	obj = new dTree('obj');
	obj.add(0,-1,'<font size=1 style=font-weight:bold style=color:#333><fmt:message key="Common.History.label" bundle="${common_labels}"/></font>');
	obj.config.useStatusText=true;
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	
	Connection con	= null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null;
	
	String abnormal = request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	String normalcy = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String episodetype		= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
	String selectedhisttype		= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String selectedeventclass	= request.getParameter("event_class")==null?"": request.getParameter("event_class");
	String selectedeventgroup	= request.getParameter("event_group")==null?"": request.getParameter("event_group");
	String selectedeventitem	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String patientid		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String fromdate			= request.getParameter("from_date")==null?"": request.getParameter("from_date");
	String todate			= request.getParameter("to_date")==null?"": request.getParameter("to_date");
	
	String fromdate1		=	com.ehis.util.DateUtils.convertDate(fromdate,"DMYHM",locale,"en");
	String todate1			=	com.ehis.util.DateUtils.convertDate(todate,"DMYHM",locale,"en");

	String viewby			= request.getParameter("view_by")==null?"E":request.getParameter("view_by");
	String episodewise		= request.getParameter("episode_wise")==null?"N":request.getParameter("episode_wise");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String errorEvent = request.getParameter("errorEvent")==null?"N":request.getParameter("errorEvent");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String enc_id		= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String show_mode			= request.getParameter("show_mode")==null?"": request.getParameter("show_mode");//IN032130
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
	if(enc_id.equals("")) enc_id = "0";
	String calling_from_2T = request.getParameter("calling_from_2T")==null?"":request.getParameter("calling_from_2T");//IN068011

	String performed_by		= request.getParameter("performed_by")==null?"":request.getParameter("performed_by");
	String sortOrder		= request.getParameter("sortOrder")==null?"desc":request.getParameter("sortOrder");
	
	String resp_id = (String)session.getValue("responsibility_id");
	String login_user = (String)session.getValue("login_user");//IN071561
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String patient_class 	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//IN034514
	String p_enc_details_tree		=	"tree_builder";//IN034514
	String encntr_yn 	=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");//IN034514
	String header_view 	=	request.getParameter("header_view")==null?"":request.getParameter("header_view");//IN034514
	String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
	String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]	 
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	boolean isClinician=false;//IN067236
	if(resp_id == null) resp_id ="";
	boolean restrict_rd	=false;	//IN071561
	
	String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	String archivalYN= request.getParameter("archivalYN")==null?"N": request.getParameter("archivalYN");//52176
	session.removeAttribute("arrayToSort"+patientid+encounter_id);	
	ArrayList sortList = new ArrayList();
	
	StringBuffer sql=new StringBuffer();
	int nodeCounter =1;
%>
<%
	try{
	con	= ConnectionManager.getConnection(request);
	out.println("<script>");	
	boolean isViewLabRes=false;//6030
	isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","ORDERBY_BASEDON_LAB_SEQ");//6030
	isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
	restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");
		if(sql.length() > 0) sql.delete(0,sql.length());
		 
		sql.append("  Select ");
		
		if(episodewise.equals("Y"))
		{
			sql.append("NVL(f.EPISODE_ID,9999999999) GROUP1,F.EPISODE_DESC,");
		}

		sql.append("NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, ");

		 sql.append("b.short_desc hist_rec_type_desc, a.hist_rec_type HIST_REC_TYPE, c.long_desc event_class_desc,a.event_class EVENT_CLASS, nvl(a.event_group,'*ALL') EVENT_GROUP, nvl(e.long_desc,d.long_desc) event_group_desc, d.long_desc  event_code_desc, rtrim(a.event_code) event_code,");
		
		if(viewby.equals("D"))
		{
			sql.append("TO_CHAR(a.EVENT_DATE,'YYYYMMDD') GROUP3,");
		}

		 sql.append(" count(*) rec_count /*,hist_data_type,a.patient_id patient_id*/,a.facility_id facility_id,F.patient_class patient_class,a.encounter_id encounter_id/*,CA_GET_VISIT_DTL(a.facility_id,a.patient_class,a.encounter_id,a.patient_id) encline*/");

		if(viewby.equals("D"))
		{
			sql.append(",to_char(a.event_date,'dd/mm/yyyy') e_date ");
		}
		//39052 Start.
		/*
		if(!isViewLabRes)
			sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F  where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) ");// ,SPECIALTY_CODE, ATTEND_PRACTITIONER_ID added for // MMS-QH-CRF-0177 [IN047572]//6030
			else
				sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE,RL_NEW_REQUEST_NUM_SEQ(a.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F  where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) ");// ,SPECIALTY_CODE, ATTEND_PRACTITIONER_ID added for // MMS-QH-CRF-0177 [IN047572]//6030
		*/
		if(!isViewLabRes)
			sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F ");
		else
			sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE,RL_NEW_REQUEST_NUM_SEQ(a.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F ");
		if("CA01".equals(order_type_3T)){	
			sql.append(" where 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4)  and b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A'))  ");
		}else{
			sql.append(" where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A'))  ");
		}
		//39052 End.
		sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' ");  //IN042552
		if(errorEvent.equals("N")){//dont'include error events
			sql.append(" and nvl(a.STATUS,'`') not in('S','E')");  
		}else if(errorEvent.equals("Y")){
			sql.append(" and nvl(a.STATUS,'`')!= 'S'  ");			
		}
		//If patient class is 'EM,'DC' and 'EX' then this below query is append accordingly related to IN18063. 
		if(!episodetype.equals("B")){
			if(episodetype.equals("I")){
				//sql.append(" and a.PATIENT_CLASS not in ('OP','EM')");
				sql.append(" and a.PATIENT_CLASS = 'IP' ");
			}else if(episodetype.equals("O")){
				//sql.append(" and a.PATIENT_CLASS in ('OP','EM')");
				sql.append(" and a.PATIENT_CLASS = 'OP' ");
			}else if(episodetype.equals("E")){
				sql.append(" and a.PATIENT_CLASS = 'EM' ");
			}else if(episodetype.equals("D")){
				sql.append(" and a.PATIENT_CLASS = 'DC' ");
			}else{
				sql.append(" and a.PATIENT_CLASS = 'XT' ");
			}
		}
		if(!selectedhisttype.equals("")){
			sql.append(" and a.hist_rec_type = ? ");
		}
		if(!selectedeventclass.equals("")){
			sql.append(" and a.EVENT_CLASS = ? ");
		}
		if(!selectedeventgroup.equals("")){
			sql.append(" and a.EVENT_GROUP = ? ");
		}
		if(!selectedeventitem.equals("")){
			sql.append(" and rtrim(a.EVENT_CODE) = ? ");
		}
		if(!encounter_id.equals("")){
				sql.append(" and a.ENCOUNTER_ID = ? ");
		}
		if(!performed_by.equals("")){
			sql.append(" and a.PERFORMED_BY_ID = ? ");
		}
		if(abnormal.equals("Y")){
			//Modified the following condition by Archana on 9/16/2010 related to the incident IN023804.
			 sql.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}
		if(!fromdate1.equals("")){
			sql.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}

		if(!todate1.equals("")){
			sql.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");//adding 59 seconds more to the todate
		}

		if(!facility_id.equals("")){
				sql.append(" and a.facility_id = ? ");
		}
		//IN071561 starts	
		if(restrict_rd)
			   sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
			   //IN071561ends
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(p_called_from) && "".equals(p_event_class))
		{
			System.out.println("EncounterDetailsTree.jsp:Line:167:");
			sql.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(p_called_from) && !"".equals(p_event_class))
		{
			System.out.println("EncounterDetailsTree.jsp:Line:172:");
			sql.append(" AND a.event_class=? ");
		}
		//IN035950 End
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				sql.append(" and F.SPECIALTY_CODE = ? ");
			}
		} else {
			sql.append(" and F.ATTEND_PRACTITIONER_ID = ? ");
		} // MMS-QH-CRF-0177 [IN047572] - End 
		//IN068011 starts
		if("Y".equals(calling_from_2T))
			sql.append(" and a.Added_BY_ID ='DM'");
		//IN068011 Ends
		 sql.append(" group by ");
		
		 if(episodewise.equals("Y")){
			 sql.append(" NVL(f.EPISODE_ID,9999999999),F.EPISODE_DESC, ");
		 }

		 sql.append(" NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') , ");
		
		if(viewby.equals("D")){
			sql.append(" TO_CHAR(a.EVENT_DATE,'YYYYMMDD'),to_char(a.event_date,'dd/mm/yyyy'),");
		}
		 
		if(!isViewLabRes)
			sql.append("TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'),b.short_desc ,a.hist_rec_type ,c.long_desc  ,CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"'),a.event_class ,nvl(a.REQUEST_NUM_SEQ,'0'),nvl(a.event_group,'*ALL') ,a.facility_id ,F.patient_class ,a.encounter_id,nvl(e.long_desc,d.long_desc) ,d.long_desc  ,rtrim(a.event_code) order by 1 ");
		else
			sql.append("TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'),b.short_desc ,a.hist_rec_type ,c.long_desc  ,CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"'),a.event_class ,nvl(a.REQUEST_NUM_SEQ,'0'),nvl(a.event_group,'*ALL') ,a.facility_id ,F.patient_class ,a.encounter_id,nvl(e.long_desc,d.long_desc) ,d.long_desc  ,rtrim(a.event_code),RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) order by 1 ");
		  sql.append(sortOrder);
		  //sql.append(" ,2,3,4,DECODE(A.HIST_REC_TYPE,'LBIN',nvl(a.request_num_seq,'0'),'0'),5,6,7,8 ");
		if(viewby.equals("D"))
		{	
			sql.append(" ,10 ");
			sql.append(sortOrder);
		}
		//IN054151 Start
	
		 //sql.append(" ,2,3,4,5,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,8,9");
			  if(!isViewLabRes)
				  sql.append(" ,2,3,4,5,6,nvl(a.REQUEST_NUM_SEQ,'0'),7,8,9");//6030
				  else
					  sql.append(" ,2,3,4,5,6,NVL (sequence_no,0),7,8,9");//6030
		//IN054151 End
		stmt=con.prepareStatement(sql.toString());

		int count1=0;
		
			stmt.setString(++count1,locale);
			stmt.setString(++count1,patientid);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,patientid);
		if(!selectedhisttype.equals("")){
			stmt.setString(++count1,selectedhisttype);
		}
		if(!selectedeventclass.equals("")){
			stmt.setString(++count1,selectedeventclass);
		}
		if(!selectedeventgroup.equals("")){
			stmt.setString(++count1,selectedeventgroup);
		}
		if(!selectedeventitem.equals("")){
			stmt.setString(++count1,selectedeventitem);
		}

		if(!encounter_id.equals("")){
			stmt.setString(++count1,encounter_id);
		}
		if(!performed_by.equals("")){
			stmt.setString(++count1,performed_by);
		}

		if(!fromdate1.equals("")){
			stmt.setString(++count1,fromdate1);			
		}
		if(!todate1.equals("")){
			stmt.setString(++count1,todate1);
		}
		if(!facility_id.equals("")){
			stmt.setString(++count1,facility_id);
		}

		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(p_called_from) && !"".equals(p_event_class))
		{
			stmt.setString(++count1,p_event_class);
		}
		//IN035950 Ends
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				stmt.setString(++count1, speciality_code);
			}
		} else {
			stmt.setString(++count1, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End 
		rs = stmt.executeQuery();
		count1 = 0;
		String group1="",group2="",group3="",hist_rec_type="",event_group="";
		String event_class="",event_code="",event_date = "", event_date_th = "";
		
		String prevGroup1="*",prevGroup2="**",prevGroup3="***",prev_hist_rec_type="****",prev_event_group="*****";
		String prev_event_class="*****",prev_event_code="******";
		String query_facility_id="",query_encounter_id="";
		String hist_rec_type_desc="",event_class_desc="",event_group_desc="",event_desc="";
		String query_patient_class="",encline="";
		StringBuffer strBuffParams = null;
		strBuffParams = new StringBuffer();
		
		int group_node_id=0,group1_node_id = 0,group2_node_id = 0,group3_node_id = 0,group4_node_id = 0;
		int group5_node_id = 0,group6_node_id = 0;
		while(rs.next()){
			strBuffParams.delete(0,strBuffParams.length());
			//strBuffParams = new StringBuffer();
			strBuffParams.append("archivalYN="); //52176
			strBuffParams.append(archivalYN);  //52176
			strBuffParams.append("&patient_id=");
			strBuffParams.append(patientid);
			
			strBuffParams.append("&from_date=");
			strBuffParams.append(fromdate);
			
			strBuffParams.append("&to_date=");
			strBuffParams.append(todate);
			
			strBuffParams.append("&patient_class=");//IN034514
			strBuffParams.append(patient_class);//IN034514

			strBuffParams.append("&p_enc_details_tree=");//IN034514
			strBuffParams.append(p_enc_details_tree);//IN034514
			
			strBuffParams.append("&encntr_yn=");//IN034514
			strBuffParams.append(encntr_yn);//IN034514

			strBuffParams.append("&abnormal=");
			strBuffParams.append(abnormal);
			strBuffParams.append("&normalcy=");
			strBuffParams.append(normalcy);
			//strBuffParams.append("&viewby=");
			strBuffParams.append("&view_by=");
			strBuffParams.append(viewby);  
			
			/*strBuffParams.append("&EHR_YN=");
			strBuffParams.append(EHR_YN); */
			strBuffParams.append("&p_event_class_widget=");//IN035950
			strBuffParams.append(p_event_class);//IN035950
			strBuffParams.append("&p_called_from_widget=");//IN035950
			strBuffParams.append(p_called_from);//IN035950
			
			strBuffParams.append("&hist_type=");//IN035950
			strBuffParams.append(selectedhisttype);//IN035950
			strBuffParams.append("&p_review_rad_yn=");//IN071561
			strBuffParams.append(p_review_rad_yn);//IN071561
			
			if(!selectedeventclass.equals("")){
				strBuffParams.append("&event_class=");
				strBuffParams.append(selectedeventclass);	
			}
			if(episodewise.equals("Y")){
				group1 = rs.getString("GROUP1")==null?"":rs.getString("GROUP1");
			}
			group2 = rs.getString("GROUP2")==null?"":rs.getString("GROUP2");
			if(viewby.equals("D")){
				group3 = rs.getString("GROUP3")==null?"":rs.getString("GROUP3");
				event_date = rs.getString("e_date")==null?"":rs.getString("e_date");	
				event_date_th = com.ehis.util.DateUtils.convertDate(event_date,"DMY","en",locale);
			}
			query_facility_id = rs.getString("facility_id")==null?"":rs.getString("facility_id");
			query_encounter_id = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
			query_patient_class = rs.getString("patient_class")==null?"":rs.getString("patient_class");
			hist_rec_type = rs.getString("HIST_REC_TYPE")==null?"":rs.getString("HIST_REC_TYPE");
			hist_rec_type_desc=rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
			hist_rec_type_desc = hist_rec_type_desc.replace('\'',' ');
			event_class = rs.getString("EVENT_CLASS")==null?"":rs.getString("EVENT_CLASS");			
			event_class_desc = rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
			event_class_desc = event_class_desc.replace('\'',' ');
			event_group = rs.getString("EVENT_GROUP")==null?"":rs.getString("EVENT_GROUP");
			event_group_desc=rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");

			event_group_desc = event_group_desc.replace('\'',' ');
			event_code = rs.getString("EVENT_CODE")==null?"":rs.getString("EVENT_CODE");	
			event_desc = rs.getString("event_code_desc")==null?"":rs.getString("event_code_desc");	
			event_desc = event_desc.replace('\'',' ');
			event_desc = event_desc.replace(System.getProperty("line.separator"), "");//[IN065313]

			if(isClinician&&event_class.equals("CLI$"))//IN067236
				event_class_desc="Therapist Notes";//IN067236
			if(!sortList.contains(hist_rec_type)) sortList.add(hist_rec_type);
			
			encline = rs.getString("ENCLINE")==null?"":rs.getString("ENCLINE");	
			encline = encline.replace('\'',' ');
			strBuffParams.append("&facility_id=");
			strBuffParams.append(query_facility_id);
			strBuffParams.append("&episode_type=");
			strBuffParams.append(query_patient_class);
			strBuffParams.append("&encounter_id=");
			strBuffParams.append(query_encounter_id);
			strBuffParams.append("&enc_id=");
			strBuffParams.append(enc_id);
			strBuffParams.append("&show_mode=");//IN032130
			strBuffParams.append(show_mode);//IN032130

			if(!prevGroup1.equals(group1)){	
				if(episodewise.equals("Y")){
					if(group1.equals("9999999999")){ //episode id is null
						group1_node_id = nodeCounter++;
						if(group2.equals("EXTERNAL")){
							
							out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

						}else{ 
							out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+encline+"','details_f2')"); 

						}
						
						strBuffParams.append("&event_date=");
						strBuffParams.append(event_date);	
						strBuffParams.append("&hist_type=");
						strBuffParams.append(hist_rec_type);							

						if(viewby.equals("D")){
							group2_node_id =  nodeCounter++;
						out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

							group3_node_id =  nodeCounter++;					
						out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");
							
										
							
						}else{
							group3_node_id =  nodeCounter++;
						out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
						}

						strBuffParams.append("&event_class=");
						strBuffParams.append(event_class);					
						group4_node_id =  nodeCounter++;
						out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
						
						strBuffParams.append("&event_group=");
						if(event_group.equals("*ALL")){
							strBuffParams.append("");		
						}else{
							strBuffParams.append(event_group);		
						}
						group5_node_id =  nodeCounter++;		
						if(!event_group.equals("*ALL")){		
						out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
						}

						strBuffParams.append("&event_item=");
						strBuffParams.append(event_code);			
						group6_node_id =  nodeCounter++;			
						if(!event_group.equals("*ALL")){					
							out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}else{
							out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}				
					}else{//valid episode id 
						group_node_id = nodeCounter++;
					out.println("obj.add('"+group_node_id+"',0,'"+group1+"','','"+group1+"','details_f2')");

						group1_node_id = nodeCounter++;

						if(group2.equals("EXTERNAL")){
						out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','External','','External','details_f2')");

						}else{
							
							
							
							
							
							
							out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')"); // IN034514
							
							
						}
						
						strBuffParams.append("&event_date=");
						strBuffParams.append(event_date);	
						strBuffParams.append("&hist_type=");
						strBuffParams.append(hist_rec_type);						

						if(viewby.equals("D")){
							
							group2_node_id =  nodeCounter++;	out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

							group3_node_id =  nodeCounter++;					
						out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
						}else{
							group3_node_id =  nodeCounter++;
						out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
						}

						strBuffParams.append("&event_class=");
						strBuffParams.append(event_class);					
						group4_node_id =  nodeCounter++;	
					out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
						
						strBuffParams.append("&event_group=");
						if(event_group.equals("*ALL")){
							strBuffParams.append("");		
						}else{
							strBuffParams.append(event_group);		
						}
						group5_node_id =  nodeCounter++;		
						if(!event_group.equals("*ALL")){		
						
						out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
						}

						strBuffParams.append("&event_item=");
						strBuffParams.append(event_code);			
						group6_node_id =  nodeCounter++;			
						if(!event_group.equals("*ALL")){					
							out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}else{
							out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}				
					}//end of else block of valid episode id
				}else{//start of else block of episodewise.equals("Y")
					group1_node_id = nodeCounter++;
					if(group2.equals("EXTERNAL")){
					out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

					}else{
						
						
						
						out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')"); // IN034514
					}
					
					strBuffParams.append("&event_date=");
					strBuffParams.append(event_date);	
					strBuffParams.append("&hist_type=");
					strBuffParams.append(hist_rec_type);

					if(viewby.equals("D")){
						group2_node_id =  nodeCounter++;	
					out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

						group3_node_id =  nodeCounter++;					
					out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
					}else{
						group3_node_id =  nodeCounter++;
					out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
					}

					strBuffParams.append("&event_class=");
					strBuffParams.append(event_class);					
					group4_node_id =  nodeCounter++;	
					out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
					
					strBuffParams.append("&event_group=");
					if(event_group.equals("*ALL")){
						strBuffParams.append("");		
					}else{
						strBuffParams.append(event_group);		
					}
					group5_node_id =  nodeCounter++;		
					if(!event_group.equals("*ALL")){		
						
					out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
					}

					strBuffParams.append("&event_item=");
					strBuffParams.append(event_code);			
					group6_node_id =  nodeCounter++;			
					if(!event_group.equals("*ALL")){					
						
						out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
					}else{
						out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
					}					
				}//end of else block of episodewise.equals("Y")
				prevGroup1 = group1;
				prevGroup2 = group2;
				prevGroup3 = group3;
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;
			}else if(!prevGroup2.equals(group2)){

				strBuffParams.append("&facility_id=");
				strBuffParams.append(query_facility_id);
				strBuffParams.append("&episode_type=");
				strBuffParams.append(query_patient_class);
				strBuffParams.append("&encounter_id=");
				strBuffParams.append(query_encounter_id);
				group1_node_id = nodeCounter++;
				if(episodewise.equals("Y")){
					if(group1.equals("9999999999")){
						if(group2.equals("EXTERNAL")){
						out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','External','','External','details_f2')");

						}else{
					
							
					
							
							out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')");// IN034514
							
						}					
					}else{
						if(group2.equals("EXTERNAL")){
							
						out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

						}else{
							
							
							
							out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')");// IN034514
							
						}					
					}
				}else{
					if(group2.equals("EXTERNAL")){
						
					out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

					}else{
					
						
						
						out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')");// IN034514
					
					}				
				}
				
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);	
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				

				if(viewby.equals("D")){
					group2_node_id =  nodeCounter++;	
				out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

					group3_node_id =  nodeCounter++;					
					
				out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}else{
					group3_node_id =  nodeCounter++;
					
				out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}

				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);					
				group4_node_id =  nodeCounter++;	
			out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
				
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}
				group5_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){		
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);			
				group6_node_id =  nodeCounter++;			
				if(!event_group.equals("*ALL")){					
				out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}
				prevGroup2 = group2;
				prevGroup3 = group3;
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;
			}else if(!prevGroup3.equals(group3) && viewby.equals("D")){
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);	
				
				group2_node_id =  nodeCounter++;			

				out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);			
				group3_node_id =  nodeCounter++;			
			out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");		
				
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);		
				group4_node_id =  nodeCounter++;		

			out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
				
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}

				group5_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){				
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);		
				
				group6_node_id =  nodeCounter++;		
	
				if(!event_group.equals("*ALL")){					
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				
				}


				prevGroup3 = group3;
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;
			}else if(!prev_hist_rec_type.equals(hist_rec_type)){

				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				group3_node_id =  nodeCounter++;	

				if(viewby.equals("D")){
					out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}else{
				out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}

				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);	
				
				group4_node_id =  nodeCounter++;	
				out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	

				strBuffParams.append("&event_group=");

				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}
				group5_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){				
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);		
				group6_node_id =  nodeCounter++;			
				if(!event_group.equals("*ALL")){				
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}

				if(viewby.equals("D")){
					prevGroup3 = group3;
				}
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;

			}else if(!event_class.equals(prev_event_class)){
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);
				//shaiju
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);
				group4_node_id =  nodeCounter++;		
			out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
				
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}		

						
				if(!event_group.equals("*ALL")){
					
				
					group5_node_id =  nodeCounter++;	
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);
				

				group6_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){							
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;

			}else if(!event_group.equals(prev_event_group)){
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);					
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}		

				group5_node_id =  nodeCounter++;
				
				//shaiju
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);

				if(!event_group.equals("*ALL")){				
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);
				
				
				
				group6_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){				
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}

				prev_event_group=event_group;
				prev_event_code = event_code;

			}else if(!event_code.equals(prev_event_code)){
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);					
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}		
				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);	
				
				group6_node_id =  nodeCounter++;			
			
				if(!event_group.equals("*ALL")){				
				 	out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}							
				prev_event_code = event_code;
			}


		}


	//out.println("<script>alert('buffer value"+strBuffParams+"')</script>");
	out.println("</script>");	

	session.setAttribute("arrayToSort"+patientid+encounter_id,sortList);
	}catch(Exception e){
		//out.println("Exception:"+e);//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}
	
	finally{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
<SCRIPT>
	document.write(obj);
	obj.openAll();
</SCRIPT>
<!-- <%=nodeCounter%> -->
<%if(nodeCounter == 1){%>
		<script>
			if(top.content != null && !top.document.getElementById('dialog-body'))
			{
				top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');
			}
			else
			{
				if(parent.parent.parent.messageFrame != null)
				{
					parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');
				}
				else if(parent.parent.messageFrame != null)
				{	
					parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');
				}
			}
			parent.details_f2.location.href = '../../eCommon/html/blank.html';
		</script>
<%}else{%>
		<script>
			if(top.content != null){
				top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}else{
				if(parent.parent.parent.messageFrame != null){												parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
				}else if(parent.parent.messageFrame != null){	
					parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
				}
			}
			parent.details_f2.location.href = '../../eCA/jsp/EncountersDetailsFrame.jsp?<%=request.getQueryString()%>'
		</script>
<%}%>
			
</BODY>
</HTML>

