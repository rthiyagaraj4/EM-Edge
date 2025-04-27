<% 
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
	?			100				?				?			?			?
22/01/2014		IN044246		Chowminya 	22/01/2014	Self		Research Study rename to Patient Classification in all labels,added &nbsp; for alignment	
13/03/2014		IN044157		Chowminya		 					[AAKH-CRF-0010.1]Five level Triage system - AE requirement
06/04/2015		IN048704		Nijitha S							HSA-CRF-0175
06/04/2015		IN052595		Karthi L							Referral Patient List
22/01/2016		IN057193		Karthi L							Flag For Discharge Summary Not Done
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
23/10/2017		IN064342		Krishna Gowtham		23/10/2017		Ramesh G	GHL-CRF-0468.1
26/03/2018		IN067111		Ramesh G			26/03/2018					ML-MMOH-SCF-0957
18/10/2019		IN071570		Nijitha S			18/10/2019		Ramesh G	ML-BRU-SCF-1989
08/07/2020     IN072184         Chandrashekar raju  08/07/2020      Ramesh G    Modified for MMS-DM-CRF-0157.2
15/04/2023		37866			Ramesh G		 								MMS-DM-CRF-0226
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
05/12/2023   54073     srinivasa N T              ramesh Goli   
-------------------------------------------------------------------------------------------------------------------------------
*/   
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.text.*, eCA.* ,eOR.Common.*, eOR.*, java.util.*,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String legendstyle		= "padding-left:0px;padding-right:0px";
	String locn_type		= request.getParameter("locn_type");
	String RP_locn_type		= request.getParameter("RP_locn_type")==null?"":request.getParameter("RP_locn_type");
	String pre_dis_advc_prep_site_YN 	=	request.getParameter("pre_dis_advc_prep_site_YN")==null?"":request.getParameter("pre_dis_advc_prep_site_YN"); //IN064342
	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
	
	if(RP_locn_type.equals("RP"))locn_type="RP";
	if(locn_type==null || locn_type.equals("null") || locn_type=="")locn_type="";
	String bar_code_scaned_YN="";//IN072184
	String bar_code_site_yn="";//Added for IN072184


	
	String queueValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QPr.label","ca_labels");	
	if(locn_type.equals("OP"))
		queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QNo.label","ca_labels");
	else if(locn_type.equals("EM"))
		queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels");
	else
		queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QPr.label","ca_labels");
%>
<html>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<script src='../../eCA/js/CAMenu.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCA/js/PatientListByLocationResult.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/CACommon.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <head>
    </head>	
	<style>
		.gridDataSelectNew
		{
			background-color: #CDE5FF;
			font-family: Verdana;
			font-size: 8pt;
			color: #000000;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;	
			border-bottom:0px;
			border-top:0px;
			border-left:0px;
			border-right:0px;
		}
		thead
		{
			position: sticky;
			top: 0px; 
			z-index: 1;
		}
	</style>
	<body class='CONTENT' onscroll='moveFrame()' onload="storeValues('<%=locn_type%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey();" >	
<%
	Connection  con =null;

	PreparedStatement stmtMotherLink = null;
	PreparedStatement pstmtForAEPat = null;
	ResultSet rsMotherLink = null;	
	ResultSet rsPatList = null;

	String facility_id=(String)session.getValue("facility_id");
	if(facility_id == null) facility_id="";
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();    
	patdata.setFacility_id(facility_id);
	//32902 start
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	 int accessRightsViewPatient=0;
	 //32902 end
	PatListByLocationResult bean ;
	String bean_id = "CA_ca_patListbylocationresult" ;
	String bean_name = "eCA.PatListByLocationResult";
	String allow_muti_bedside_review_yn="";	
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	HashMap qryStringHash = new HashMap();
	
	boolean flag = true;
	boolean isQMSapplicable	=	false;
	StringBuffer layer = new StringBuffer();
	
	boolean pre_dis_advc_prep_siteYN = CommonBean.isSiteSpecific(con, "CA", "PRE_DIS_ADVC_PRE");//IN064342	
	boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
	
	boolean header = false;
	boolean outpHeader=false;
	boolean inpHeader=false;
	
	String c4cStatuDisplay=""; //51215
	out.println("<form name='PatCriteriaFrm' id='PatCriteriaFrm'  action='../../eCA/jsp/OpenChartWrapper.jsp' method = 'post' target='messageFrame' >");
	%>
	<table cellpadding='0' id="prevnexttab" cellspacing='0' border='0' width='100%' align='center' style="	position: FIXED;top: 0;background-color: #f1f1f1;z-index: 1;">
		<tr >
		<td class='white' width='92.5%'></td> 
		<td nowrap  width='5%' align='right' id='previous' ></td>
		<td nowrap  width='5%' align='right' id='next' ></td>
		</tr>
	</table>

	<%
    out.println("<table id='PatCriteriaTbl' border=1 width='100%' class='grid' style='margin-top: 15px;'>");
	%>
	
	<%
	String clinicianId, decesedColor, encounterID, queueDesc,patientClass;
	clinicianId = decesedColor = encounterID = queueDesc = patientClass="";
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	clinicianId =(String)session.getValue("ca_practitioner_id");
	if(clinicianId == null) clinicianId="";
	
	
	String Sdate = dateFormat.format( dt ) ;
	String apgar_score="	";
	String mode = (request.getParameter("mode")==null)? "" :(String)request.getParameter("mode");
	
	String locationType, locationCode, viewList, adm_fromdate, adm_todate, groupByLocn, groupByEpisode, checkedout, past, discharged;
	locationType = locationCode = viewList = adm_fromdate = adm_todate = groupByLocn = groupByEpisode = checkedout = past = discharged = "";
	
	String unscheduledyn, fromvisitdate, tovisitdate, fromdischargedate, todischargedate, relnreqyn, patientId, nationID;
	unscheduledyn = fromvisitdate = tovisitdate = fromdischargedate = todischargedate = relnreqyn = patientId = nationID = "";
		
	String queueId, queueStatus, queueNumber, sortOrder, episode_type_desc, sex, queue_status, visit_episode_status, strTempDisp; 
	queueId = queueStatus = queueNumber = sortOrder = episode_type_desc = sex = queue_status = visit_episode_status = strTempDisp = "";
	
	String mo_install_yn, visitStyle, attend_practId, speciality, visitType, bedNo, q_num, pi_clinical_stud_gif, site_id, patName, bedside_ref_review_status;
	mo_install_yn = visitStyle = attend_practId = speciality = visitType= bedNo = q_num = pi_clinical_stud_gif = site_id = patName = bedside_ref_review_status = "";
	String restPatientYN="";//32902
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String leftScrolling	= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	String anchorID	= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	String virtualConsultation_yn = request.getParameter("virtualConsultation_yn")==null?"N":request.getParameter("virtualConsultation_yn"); //51215
	String prev =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String next =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	String assign_confirm_referral_yn = "";
	int res_pat_rec_count = 0;
	String qms_interfaced_yn =	"N";
	 
	String qms_call_counter = "0"; 
	 	
	visitType = request.getParameter("visitType")==null?"":request.getParameter("visitType");
	String link_allowed_yn="Y"; 

	if(reOrder.equals("1"))
		visitStyle = "color:pink" ;
	else
		visitStyle = "color:yellow" ;
	
	assign_confirm_referral_yn = request.getParameter("assign_confirm_referral_yn")==null?"":request.getParameter("assign_confirm_referral_yn");//IN048704
	
	con = ConnectionManager.getConnection(request);
	isQMSapplicable=eOP.QMSInterface.isSiteSpecific(con,"OP","EXT_QUEUE_NO");//IN071570
	int maxNoRecords = 0;
	
	String refRegSiteYN = "";
	Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
	//boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION");  //37866
	boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");	//51215
	if(referralRegister)
		refRegSiteYN = "Y";	
	else
		refRegSiteYN = "N";
	
	if(mode.equals("search") || mode.equals("")) //when request for search for first time
	{
		locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType");		
		locationCode=request.getParameter("locationCode")==null?"":request.getParameter("locationCode");		
		viewList=request.getParameter("viewList")==null?"":request.getParameter("viewList");
		adm_fromdate	=	request.getParameter("adm_fromdate")==null?"":request.getParameter("adm_fromdate");
		adm_todate		=	request.getParameter("adm_todate")==null?"":request.getParameter("adm_todate");
		
		groupByLocn=request.getParameter("groupByLocn");
		if(groupByLocn==null || groupByLocn.equals("null") || groupByLocn=="")
			groupByLocn="";

		groupByEpisode=request.getParameter("groupByEpisode");
		if(groupByEpisode==null || groupByEpisode.equals("null") || groupByEpisode=="")
			groupByEpisode="";

		checkedout=request.getParameter("checked_out")==null?"N":request.getParameter("checked_out");
		past=request.getParameter("past")==null?"N":request.getParameter("past");
		discharged=request.getParameter("discharged")==null?"N":request.getParameter("discharged");

		unscheduledyn=request.getParameter("unscheduled_yn")==null?"N":request.getParameter("unscheduled_yn");

		fromvisitdate = request.getParameter("from_visit_date")==null?"":request.getParameter("from_visit_date");
		tovisitdate = request.getParameter("to_visit_date")==null?"":request.getParameter("to_visit_date");
		fromdischargedate = request.getParameter("from_discharge_date")==null?"":request.getParameter("from_discharge_date");
		todischargedate	= request.getParameter("to_discharge_date")==null?"":request.getParameter("to_discharge_date");
		relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
		patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		nationID	=	request.getParameter("nationID"); 
		if(nationID==null || nationID.equals("null") || nationID=="")
			nationID	=	"";
		queueId = request.getParameter("queueId")==null?"":request.getParameter("queueId");
		sortOrder = request.getParameter("sortOrder")==null?"v":request.getParameter("sortOrder");
		queueStatus = request.getParameter("queueStatus")==null?"":request.getParameter("queueStatus");
		if (queueStatus.equals("~~"))
			queueStatus = "";
		queueStatus	=	queueStatus.replace('~','\'');
		attend_practId = request.getParameter("attend_practId")==null?"":request.getParameter("attend_practId");
		speciality = request.getParameter("speciality")==null?"":request.getParameter("speciality");
		bedNo = request.getParameter("bedNo").equals("")||request.getParameter("bedNo")==null?"%":request.getParameter("bedNo");//IN29412	
		 bar_code_scaned_YN =request.getParameter("bar_code_scaned_YN")==null?"N":request.getParameter("bar_code_scaned_YN");//Added for IN072184
		 bar_code_site_yn =request.getParameter("bar_code_site_yn")==null?"N":request.getParameter("bar_code_site_yn");//Added for IN072184
			//System.err.println("bar_code_scaned_YN if @@@ Resultpage"+bar_code_scaned_YN+"bar_code_site_yn@@2==="+bar_code_site_yn+"patientId=="+patientId);
		
	}
	else
	{
		//Called when navigating
		locationType=request.getParameter("locationType1");
		if(locationType==null || locationType.equals("null") || locationType=="")
			locationType="";
		locationCode=request.getParameter("locationCode1");
		if(locationCode==null || locationCode.equals("null") || locationCode=="")
			locationCode="";
		
		viewList=request.getParameter("viewList1");
		if(viewList==null || viewList.equals("null") || viewList=="")
			viewList="";
		adm_fromdate = request.getParameter("adm_fromdate1")==null?"":request.getParameter("adm_fromdate1");
		adm_todate=request.getParameter("adm_todate1")==null?"":request.getParameter("adm_todate1");
		if(adm_fromdate==null || adm_fromdate.equals("null") || adm_fromdate=="")
			adm_fromdate="";
		if(adm_todate==null || adm_todate.equals("null") || adm_todate=="")
			adm_todate="";
		groupByLocn=request.getParameter("groupByLocn1");

		if(groupByLocn==null || groupByLocn.equals("null") || groupByLocn=="")
			groupByLocn="";

		groupByEpisode=request.getParameter("groupByEpisode1");
		if(groupByEpisode==null || groupByEpisode.equals("null") || groupByEpisode=="")
			groupByEpisode="";
		checkedout=request.getParameter("checked_out1")==null?"N":request.getParameter("checked_out1");
		past=request.getParameter("past1")==null?"N":request.getParameter("past1");
		discharged=request.getParameter("discharged1")==null?"N":request.getParameter("discharged1");

		unscheduledyn=request.getParameter("unscheduled_yn1")==null?"N":request.getParameter("unscheduled_yn1");
		fromvisitdate = request.getParameter("from_visit_date1")==null?"":request.getParameter("from_visit_date1");
		tovisitdate=request.getParameter("to_visit_date1")==null?"":request.getParameter("to_visit_date1");
		fromdischargedate = request.getParameter("from_discharge_date1")==null?"":request.getParameter("from_discharge_date1");
		todischargedate = request.getParameter("to_discharge_date1")==null?"":request.getParameter("to_discharge_date1");
		relnreqyn = request.getParameter("reln_req_yn1")==null?"Y":request.getParameter("reln_req_yn1");
		patientId = request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		nationID=request.getParameter("nationID1");
		if(nationID==null || nationID.equals("null") || nationID=="")
			nationID="";
		
		queueId = request.getParameter("queueId1")==null?"":request.getParameter("queueId1");
		sortOrder = request.getParameter("sortOrder1")==null?"v":request.getParameter("sortOrder1");
		queueStatus = request.getParameter("queueStatus1")==null?"":request.getParameter("queueStatus1");
		if (queueStatus.equals("00")) 
			queueStatus="";
		attend_practId = request.getParameter("attend_practId1")==null?"":request.getParameter("attend_practId1");
		speciality = request.getParameter("speciality1")==null?"":request.getParameter("speciality1");
		bedNo = request.getParameter("bedNo")==null||request.getParameter("bedNo").equals("")?"%":request.getParameter("bedNo");//IN29412
		 bar_code_scaned_YN =request.getParameter("bar_code_scaned_YN")==null?"N":request.getParameter("bar_code_scaned_YN");//Added for IN072184
			bar_code_site_yn =request.getParameter("bar_code_site_yn")==null?"N":request.getParameter("bar_code_site_yn");//Added for IN072184
	//		System.err.println("bar_code_scaned_YN if @@@ Resultpage"+bar_code_scaned_YN+"bar_code_site_yn@@2==="+bar_code_site_yn+"patientId=="+patientId);
	}
	adm_fromdate	=	com.ehis.util.DateUtils.convertDate(adm_fromdate,"DMY",locale,"en");
	adm_todate		=	com.ehis.util.DateUtils.convertDate(adm_todate,"DMY",locale,"en");
	fromdischargedate	=	com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY",locale,"en");
	todischargedate		=	com.ehis.util.DateUtils.convertDate(todischargedate,"DMY",locale,"en");
	fromvisitdate	=	com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY",locale,"en");
	tovisitdate		=	com.ehis.util.DateUtils.convertDate(tovisitdate,"DMY",locale,"en");

	boolean isScroll	= true;
	boolean floatTitle  = false;
	boolean isIP = false;
	boolean isOP = false;
	locn_type =	request.getParameter("locn_type");
	if(locn_type==null)
		locn_type="";
	String locn_code =	request.getParameter("locn_code");
	if(locn_code==null)
		locn_code="";
	
	qms_interfaced_yn = eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,con); // added for CRF 192 - IN030532
	RP_locn_type=request.getParameter("RP_locn_type")==null?"":request.getParameter("RP_locn_type");

	if(RP_locn_type.equals("RP"))
		locn_type="RP";
	
	if(groupByEpisode.equals("Y") && groupByLocn.equals("Y")){
		floatTitle = true;
		isScroll = false;
		if(!locn_type.equals("")){
			if(locn_type.equals("OP")){
				isOP = true;
				locationType = "OP";
			}else if(locn_type.equals("IP")){
				isIP = true;
				locationType = "IP";
			}else if(locn_type.equals("EM")){
				isOP = true;
				locationType = "EM";
			}else if(locn_type.equals("DC")){
				isIP = true;
				locationType = "DC";
			}else if(locn_type.equals("RP")){
				isScroll = true;
			}
		}
		if(!locn_code.equals(""))
			locationCode = locn_code;
	}else if(groupByEpisode.equals("Y") && groupByLocn.equals("N") ){
		if(!locn_type.equals("")){
			if(locn_type.equals("OP")){
				isOP = true;
				locationType = "OP";
			}else if(locn_type.equals("IP")){
				isIP = true;
				locationType = "IP";
			}else if(locn_type.equals("EM")){
				isOP = true;
				locationType = "EM";
			}else if(locn_type.equals("DC")){
				isIP = true;
				locationType = "DC";
			}
		}		
	}
	//krishna ends
	// added for CRF 192 
	qryStringHash.put("Relnreqyn", relnreqyn); 
	qryStringHash.put("LocationType", locationType); 
	qryStringHash.put("PatientId", patientId);
	qryStringHash.put("NationID", nationID);
	qryStringHash.put("QueueId", queueId);
	qryStringHash.put("QueueStatus", queueStatus);
	qryStringHash.put("GroupByEpisode", groupByEpisode);
	qryStringHash.put("Unscheduledyn", unscheduledyn);
	qryStringHash.put("Checkedout", checkedout);
	qryStringHash.put("Past", past);
	qryStringHash.put("Fromvisitdate", fromvisitdate);
	qryStringHash.put("Tovisitdate", tovisitdate);
	qryStringHash.put("ViewList", viewList);
	qryStringHash.put("LocationCode", locationCode);
	
	qryStringHash.put("Attend_practId", attend_practId);
	qryStringHash.put("Speciality", speciality);
	qryStringHash.put("VisitType", visitType);
	qryStringHash.put("Discharged", discharged);
	qryStringHash.put("Fromdischargedate", fromdischargedate);
	qryStringHash.put("Todischargedate", todischargedate);
	qryStringHash.put("Adm_fromdate", adm_fromdate);
	qryStringHash.put("Adm_todate", adm_todate);
	qryStringHash.put("Locn_type", locn_type);
	qryStringHash.put("ReOrder", reOrder);
	qryStringHash.put("OrderBy", orderBy);
	qryStringHash.put("GroupByLocn", groupByLocn);
	qryStringHash.put("SortOrder", sortOrder);
	qryStringHash.put("ClinicianId", clinicianId);
	qryStringHash.put("Locale", locale);
	qryStringHash.put("Facility_id", facility_id);
	qryStringHash.put("BedNo", bedNo);
	qryStringHash.put("assign_confirm_referral_yn", assign_confirm_referral_yn);//IN048704
	qryStringHash.put("virtualConsultation_yn",virtualConsultation_yn); //51215
	%>
	<!------------------------ Changes for Prevoius Next Functionality----------->
	<input type="hidden" name="locationType1" id="locationType1" value="<%=locationType%>">
	<input type="hidden" name="locationCode1" id="locationCode1" value="<%=locationCode%>">
	<input type="hidden" name="viewList1" id="viewList1" value="<%=viewList%>">
 	<input type="hidden" name="adm_fromdate1" id="adm_fromdate1" value="<%=adm_fromdate%>">
    <input type="hidden" name="adm_todate1" id="adm_todate1" value="<%=adm_todate%>">
	<input type="hidden" name="groupByLocn1" id="groupByLocn1" value="<%=groupByLocn%>">
	<input type="hidden" name="locationType1" id="locationType1" value="<%=locationType%>">
	<input type="hidden" name="groupByEpisode1" id="groupByEpisode1" value="<%=groupByEpisode%>">
	<input type="hidden" name="checked_out1" id="checked_out1" value="<%=checkedout%>">
	<input type="hidden" name="past1" id="past1" value="<%=past%>">
	<input type="hidden" name="discharged1" id="discharged1" value="<%=discharged%>">
	<input type="hidden" name="unscheduled_yn1" id="unscheduled_yn1" value="<%=unscheduledyn%>">
	<input type="hidden" name="from_visit_date1" id="from_visit_date1" value="<%=fromvisitdate%>">
	<input type="hidden" name="to_visit_date1" id="to_visit_date1" value="<%=tovisitdate%>">
	<input type="hidden" name="from_discharge_date1" id="from_discharge_date1" value="<%=fromdischargedate%>">
	<input type="hidden" name="to_discharge_date1" id="to_discharge_date1" value="<%=todischargedate%>">
	<input type="hidden" name="patientId1" id="patientId1" value="<%=patientId%>">
	<input type="hidden" name="nationID1" id="nationID1" value="<%=nationID%>">
	<input type="hidden" name="queueId1" id="queueId1" value="<%=queueId%>">
	<input type="hidden" name="sortOrder1" id="sortOrder1" value="<%=sortOrder%>">
	<input type="hidden" name="queueStatus1" id="queueStatus1" value="<%=queueStatus%>">
	<input type="hidden" name="reln_req_yn1" id="reln_req_yn1" value="<%=relnreqyn%>">
	<input type="hidden" name="attend_practId1" id="attend_practId1" value="<%=attend_practId%>">
	<input type="hidden" name="speciality1" id="speciality1" value="<%=speciality%>">
	<input type="hidden" name="mode" id="mode" value="navigate">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="form" id="form" value="Location">
	<input type="hidden" name="RP_locn_type" id="RP_locn_type" value="<%=locn_type%>">
	<input type="hidden" name="P_locn_code" id="P_locn_code" value="<%=locn_code%>"> <!-- added for CRF 192 -->
	<input type="hidden" name="assign_confirm_referral_yn" id="assign_confirm_referral_yn" value="<%=assign_confirm_referral_yn%>"><!-- IN048704 -->
    <input type="hidden" name="bar_code_scaned_YN" id="bar_code_scaned_YN" value="<%=bar_code_scaned_YN%>"><!-- Added for IN072184 -->
    <input type="hidden" name="bar_code_site_yn" id="bar_code_site_yn" value="<%=bar_code_site_yn%>"><!-- Added for IN072184  -->
	
	<!------------------------ end of change---------------------------------->
	<%	
	/*----------------Code at for next Previous------*/
	int start   = 0 ;
	int end     = 0 ;
	int iterate =1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ; 

	if ( to == null )
		end = 11 ;
	else
		end = Integer.parseInt(to) ;
	int counts=start;//54073
	/*--------------------------------------------------*/
	
	String sqlMotherLink = "select a.patient_id pat_id, replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) ,'''','')  short_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH, a.WEIGHT, a.WEIGHT_UNIT, a.LENGTH ||' cms'  LENGTH_OF_BABY,a.CIRCUMFERENCE ||' cms'  CIRCUMFERENCE_OF_HEAD,a.APGAR_SCORE, b.sex from mp_birth_register a,mp_patient b where  b.patient_id=a.patient_id and a.mother_patient_id= ? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc  ";//Modified --[IN029180]
	 
	PreparedStatement stmtPatList = null ;
	try
	{	
		bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
		allow_muti_bedside_review_yn  = bean.getMultiBedSideReviewYN(facility_id); // added for IN048463
		mo_install_yn 	= bean.getMOInstallYN(con);
		site_id 		= bean.getSiteId(con);
		qryStringHash.put("Mo_install_yn", mo_install_yn);
		stmtMotherLink = con.prepareStatement(sqlMotherLink);
		int k=0;
		int i=0;
		String rowclass = "gridData";
		
		if((groupByEpisode.equals("N") || groupByLocn.equals("N"))||((groupByEpisode.equals("Y") || groupByLocn.equals("Y"))&&locn_type.equals("RP"))){
			rsPatList = bean.patListByLocationResult(con,qryStringHash); // modified for CRF 192	
			while(rsPatList.next())
				maxNoRecords += 1;
		}
			
		if(rsPatList!=null)rsPatList.close();	
		%>
		<%if(isScroll){%>
			<Script>			
				document.getElementById('previous').innerHTML="";	
			</script>
			<%if (!(start <= 1)){%>
				<script>				
				if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById('previous'))
					top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById('previous').innerHTML = "<INPUT TYPE='button' class='button' name='prev' id='prev' onClick=navigate('<%=(start-11)%>','<%=(end-11)%>') title='Previous' value='  \<  ' >";
				else
					document.getElementById('previous').innerHTML = "<a class='gridLink' href=`javascript:onClick=navigate('<%=(start-11)%>','<%=(end-11)%>')`title='Previous' value=' Previous  ' ><%=prev%></a>";
				</script>
			<%}if ( !( (start+11) > maxNoRecords ) ){%>
				<script>
				if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.next)
					top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.next.innerHTML = "<INPUT TYPE='button' class='button' name='nex' id='nex'  onClick=navigate('<%=(start+11)%>','<%=(end+11)%>') title='Next' value='  \>  ' >";
				else 
					document.getElementById('next').innerHTML = "<a class='gridLink' href=`javascript:onClick=navigate('<%=(start+11)%>','<%=(end+11)%>')`title='Next' value=' next  ' ><%=next%></a>";
				</script>
			<%}
		}else{%>
			<script>
				document.getElementById('previous').innerHTML="";			
			</script>
		<%
		}
		rsPatList = bean.patListByLocationResult(con,qryStringHash); // modified for CRF 192
		if(isScroll){
			if ( start != 1 ){
				for( int j=1; j<start;j++ ){
					rsPatList.next() ;
					iterate++;
				}
			}
		}//end of isScroll%>
		<input type="hidden" name="maxNoRecords" id="maxNoRecords"value="<%=maxNoRecords%>">
		<%
		if(groupByEpisode.equals("N") && groupByLocn.equals("N")){
			try{
				String status = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;
				String tempDischargeDate = "";
				String disp_cls_cons_date = null;
				StringTokenizer st = null;
				String n = null;           
				//boolean header=false;
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]
				String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added forIN072994

				while(rsPatList.next() && iterate <=end ){
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025 - IN030466
					if(res_pat_rec_count > 0) //added for CRF-025 - IN030466
					{
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";	
					}else{
						pi_clinical_stud_gif = "";
					} 
					
					flag = false; //shaiju
					iterate++ ;
					
					if (k % 2 == 0 )
					   rowclass = "gridData";
					else
						rowclass = "gridData";

					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";
						
						flag = false;					
						if(header == false){
						%>			    
							<jsp:include page="../../eCA/jsp/PatListByLocationResultHeader01.jsp" flush="true" /> 
						<%		
							header = true;
							i++;
						}
						rowclass = "gridData";					
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";

						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");

						episode_type_desc = bean.getLabel(pageContext,episode_type_desc);
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

						

						
						if("U".equals(sex))
							sex = "Unknown";
						
						sex  = bean.getLabel(pageContext,sex);
						
						status  = bean.getLabel(pageContext,status);
						
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
							else if(bedside_ref_review_status.equals("C"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
							else if(bedside_ref_review_status.equals("N")) // IN052595 
							status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
							else if(bedside_ref_review_status.equals("X"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
							else if(bedside_ref_review_status.equals("S"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
						}
						
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";
							
						st = new StringTokenizer(patient_status,"|");
		
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED";
							rowclass = "DECEASED1";
							decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor = "";
						}
						else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();
							
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en")){
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									}
								   else{
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
								   }
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}
							
						}
						out.println("<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") ){
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13) patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"',,'"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"',,'"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");//IN032928
						}else{
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						}
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); // modified above out.println for CRF-025 IN030466
					
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			%>
								<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
			<%
								out.println("</a></font></td>");
							}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							/*else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
							else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - Start
						else {  
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
							{
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704	
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			%>  <fmt:message key="Common.confirm.label" bundle="${common_labels}"/><%
								out.println("</a></font></td>");
							}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}						
							else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - End
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for MIN072994
						out.println("</script>");
	%>
						<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rsPatList.getString("patient_id")%>'>
						<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rsPatList.getString("referral_id")%>'>
						<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rsPatList.getString("ASSIGN_CARE_LOCN_CODE")%>'>
						<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rsPatList.getString("ATTEND_PRACTITIONER_ID")%>'>
						<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rsPatList.getString("sex")%>'>
						<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rsPatList.getString("unAssigned_yn")%>'>
		<%
						i++;
						k++;
					}else{
						if(header==false){
							out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>'}</script>");
							%>
							<thead style="top: 15px;">
							<tr><th class='columnheader' width='16px'>&nbsp;</th>
							<th class='columnheader' width='16px'>&nbsp;</th>
							<th class='columnheader' nowrap><a class='gridLink'  onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></a></th><!--54073-->
							<th class='columnheader' nowrap><a class='gridLink' id='a01'   href="javascript:callForOrderByLoc('PC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a02'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
							<%
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType)){%>
								<th class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></th>
							<%}
							//37866 End.
							%>							
							<th class='columnheader' nowrap><a class='gridLink' id='a07'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>							
							<th class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
							<!--Added -  Changes suggested by sunil-->
							<th class='columnheader' nowrap><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a10'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th> 
							<th class='columnheader' nowrap><a class='gridLink' id='a12'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a  class='gridLink' id='a13'   href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><style='color:white'><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></td> <!-- IN044246 -->
							<th class='columnheader' nowrap><a class='gridLink' id='a09' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a14'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a15'   href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a16'   href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style='color:white'><%=queueValue%></a></th>
							<th class='columnheader' nowrap><a class='gridLink' id='a17'   href="javascript:callForOrderByLoc('QS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>							
							<th class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
						<%
							//IN064342 start
							if("Y".equals(pre_dis_advc_prep_site_YN)){
						%>
								<th class='columnheader' nowrap><a class='gridLink' id='a18'   href="javascript:callForOrderByLoc('PDA');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.PreDischargeAdvice.label" bundle="${ca_labels}"/></a></td>
						<%
							}
							//IN064342 ends
						%>
							</thead>
							</tr>
							<%
							header=true;
							i++;
						}				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";				
						disp_cls_cons_date ="&nbsp;";
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");

						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						//Adding startIN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
					
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						
						if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
							pendDisSummColor = "'color:red;'";
							pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
						}else { 
							pendDisSummColor = "'color:black;'";
							pendDisSummtTip = "";
						} //ML-MMOH-CRF-0356 [IN057193]
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";
		
						st = new StringTokenizer(status,"|");
		
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(deceasedYn.equals("D")){
							className="CADECEASED";
							rowclass = "DECEASED1";
							decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor="";
						}else{
							decesedColor="";
						}
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(!deceasedYn.equals("D")){
							if(!tempDischargeDate.equals("")){
								className = "DISCHARGED";
							}else if(noofchildren > 0){						
								className = "NEWBORN";
							}
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
					    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(rsPatList.getString("episode_type").equals("I")){
							layer = new StringBuffer();
							disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
							if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
								disp_cls_cons_date="&nbsp;";

							if(!disp_cls_cons_date.equals("&nbsp;")){
								disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);}
							else{
								disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
							}

							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=gridData>" +rsMotherLink.getString("pat_id") +"</td><td class=gridData>" + rsMotherLink.getString("short_name") + "</td><td class=gridData>" +rsMotherLink.getString("sex") + "</td><td class=gridData>" + com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale) + "</td><td class=gridData>" +rsMotherLink.getString("TIME_OF_BIRTH") + "</td><td class=gridData>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</td><td class=gridData>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</td><td class=gridData>" +rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</td><td class=gridData>"+apgar_score+"</td></tr>");}
													
							}
						}				
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+rsPatList.getString("PATIENT_NAME")+"\";</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						//IN044157 - Start		
						out.println("<tr>");
						if(!emergencyYn.equals(""))
							out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
						else
							out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
						//IN044157 - End
						out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td id='rta"+i+"' class=gridData nowrap>"+episode_type_desc+"</td><td id='rtb"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtc"+i+"' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap>");//54073
						if(link_allowed_yn.equals("Y")){
							out.println("<a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928					
						}
						else{
						out.println("<font color="+decesedColor+">"+patName);
						}
						//37866 Start.
						if(isVirtualConsSiteSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
							out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
						}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
							out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
						}
						//37866 End.
						out.println("</font></td><td id='rtd"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rte"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+sex+"</td><td id='rtk"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("BED_NUM")+"</a></td>");
						out.println("<td id='rtl"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("ROOM_NUM")+"</a></td>");
						out.println("<td id='rtg"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME")) +"</a></td>");
						out.println("<td id='rth"+i+"' class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td id='rti"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtj"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td>");
						out.println("<td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td><td id='rto"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtp"+i+"' class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td  id='rtq"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td>"); // modified for CRF-025 - IN030466//Added - Changes suggested by sunil
						//IN064342 start
						if(rsPatList.getString("referral_id")!= null){
							if("N".equals(pre_dis_advc_prep_site_YN)){
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}
						}else{
							if("N".equals(pre_dis_advc_prep_site_YN)){
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}
						}
						if("Y".equals(pre_dis_advc_prep_site_YN)){
							if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
								out.println("<td class=gridData nowrap>");
								%>
									<fmt:message key="eCA.Prepared.label" bundle="${ca_labels}"/>	
								<%
								out.println("</td></tr>");
							}else{
								out.println("<td class=gridData nowrap>");
								%>
									<fmt:message key="eCA.NotPrepared.label" bundle="${ca_labels}"/>
								<%
								out.println("</td></tr>");
							}
						}
						//IN064342 ends
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
						%>
					    <!--32902 start-->
							<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
							<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
						<!--32902 end--->
						<%
						i++;
						k++;
						link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();	
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(groupByEpisode.equals("Y") && groupByLocn.equals("N"))
		{
			try{
				boolean outpHeader=false;
				boolean inpHeader=false;
				String currcompstring = "";
				String prevcompstring = "`";
				String status =		null;
				String currpract = null;
				String currvisitdate = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;                   
				String disp_cls_cons_date =null;                  
				StringTokenizer st = null;
				String n =null;
				String datedisplay = null;
				String practScheduled= null;
				String tempDischargeDate = "";
				//boolean header = false;
				String p_queue_status = null; // added for CRF 192 - IN030532
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]			
			    String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
			    int count= 1;//   22856 - ML-MMOH-CRF-1778
				while(rsPatList.next() && iterate <=end ) 
				{
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025	- IN030466
					if(res_pat_rec_count > 0)
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					else
						pi_clinical_stud_gif = "";
					encounterID = rsPatList.getString("EPISODE_ID"); // added for CRF 192 - IN030532				
					p_queue_status = rsPatList.getString("queue_status");  // added for CRF 192 - IN030532
					
					//IN042191 starts
					q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");							
				
					if(q_num.equals("0")) queueNumber = "&nbsp;";
					//IN042191 ends
							else queueNumber = rsPatList.getString("QUEUE_NUM");
					
					String p_patient_id = rsPatList.getString("patient_id");// CRF 192 - IN030532
					
					iterate++ ;
					
					flag=false;

					if (k % 2 == 0 )
						rowclass = "gridData";
					else
						rowclass = "gridData";
						// color coding

					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";
						
						flag = false;			
						if(header == false)
						{
						%>
						<jsp:include page="../../eCA/jsp/PatListByLocationResultHeader01.jsp" flush="true" /> 
						<%
							header = true;
							i++;
						}
						rowclass = "gridData";				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";

						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
					    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding endIN072994

						//IN064836 start
						if("U".equals(sex))
							sex = "Unknown";
						//IN064836 ends
						sex  = bean.getLabel(pageContext,sex);
						
						status  = bean.getLabel(pageContext,status);
						// added for IN048463 - Start
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
							else if(bedside_ref_review_status.equals("C"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
							else if(bedside_ref_review_status.equals("N")) // IN052595 
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
							//IN064836 start
							else if(bedside_ref_review_status.equals("X"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
							else if(bedside_ref_review_status.equals("S"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
							//IN064836 ends
							
						}
						// added for IN048463 - End
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";						
						st = new StringTokenizer(patient_status,"|");
			
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED";
							rowclass = "DECEASED1";
							decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor = "";
						}else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();
							
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en"))
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									else
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
								 
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}
							
						}
						out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("")) 
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");						
						else
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); //modifid above for CRF-025 IN030466									
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			%>
								<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
			<%
								out.println("</a></font></td>");
								}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						}	// added for IN048463 - Start
						else {  
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals(""))){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
				%>
									<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
				<%
									out.println("</a></font></td>");
									}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}						
							else if(!referralRegister|| "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - End
							out.println("<script language='javascript'>");
							out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
							out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
							out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added forIN072994
						    out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added forIN072994
						    out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added forIN072994
							out.println("</script>");
		%>
						<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rsPatList.getString("patient_id")%>'>
						<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rsPatList.getString("referral_id")%>'>
						<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rsPatList.getString("ASSIGN_CARE_LOCN_CODE")%>'>
						<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rsPatList.getString("ATTEND_PRACTITIONER_ID")%>'>
						<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rsPatList.getString("sex")%>'>
						<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rsPatList.getString("unAssigned_yn")%>'>
						<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
					<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
		<%
						i++;
						k++;
					}else{
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");
						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");

						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994


						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";
						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date ="&nbsp;";
						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}				
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(deceasedYn.equals("D")){
							className="CADECEASED"; rowclass = "DECEASED1"; decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";  decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D")){	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date = "&nbsp;";

						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}

						if(rsPatList.getString("episode_type").equals("O")){
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+ rsPatList.getString("QRYTIME")+"</b>'}</script>");
								%>
								<thead>
								<tr >
								<th class='columnheader' width='16px'>&nbsp;</td><td class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' nowrap><a class='gridLink'  onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></a></th><!--54073-->
								<th class='columnheader' nowrap><a class='gridLink' id='a01'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a02'   href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style='color:white'><%=queueValue%></a></th>
								<% 							
								if(isQMSapplicable && locn_type.equals("OP")){ 
								%>
									<th class='columnheader' width="" nowrap><fmt:message key="eOP.CallTicket.label" bundle="${op_labels}"/></th>
								<%}%>
								<th class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
								<%
								//37866 Start.
								if(isVirtualConsSiteSpec && "OP".equals(locationType)){%>
								<th class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></th>
								<%}
								//37866 End.
								%>
								<th class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a  class='gridLink' id='a07'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a12'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a13'   href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></a></th>
								<% if(locationType.equals("OP")){%>
								<th class='columnheader' nowrap><a class='gridLink' id='a15'   href="javascript:callForOrderByLoc('VT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></a></th>
								<%}%>
								<th class='columnheader' nowrap><a  class='gridLink' id='a09'   href="javascript:callForOrderByLoc('VD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap colspan=2><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('QS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>							
								<th class='columnheader' nowrap> <fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!-- IN044246 -->
								<th class='columnheader' nowrap><a class='gridLink' id='a10' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a14'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
								</thead>
								</tr>
								<%
								i++; i++;  outpHeader=true;
							}						
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else
									practScheduled = "Assigned";
								currcompstring = practScheduled;						
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = currvisitdate;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else 
									practScheduled = "Assigned";
								currcompstring = practScheduled+currvisitdate;
							}
							if(!currcompstring.equals("")){
								if(!currcompstring.equals(prevcompstring)){
									i++;
								}
							}
							//IN044157 - Start		
						    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							//51215 Start.
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							//51215 End.
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+ count++ +"&nbsp;"+c4cStatuDisplay+"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtc"+i+"' class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td>");						
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT"); // added for  // added for CRF 192 - IN030532 - Start
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1)
							{
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM"))){
									out.println("<td id='rtp"+i+"' class=gridData nowrap><img style='cursor:pointer;' src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> "); //IN000000
								}else{
									out.println(" <td id='rtp"+i+"' class = gridData nowrap>&nbsp;</td> ");//IN000000
								}
							} // END added for CRF 192 - IN030532					
							if(link_allowed_yn.equals("Y")){
								out.println("<td id='rtd"+i+"' class=gridData nowrap><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN000000							
							}else{
								out.println("<td id='rtd"+i+"' class=gridData nowrap><font color="+decesedColor+">"+patName);//IN000000
							}
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
							}
							//37866 End.
							%>
							    <!--32902 start-->
									<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
									<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
								<!--32902 end--->
								<%
							out.println("</font></td><td id='rte"+i+"' class=gridData nowrap>"+rsPatList.getString("patient_id")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class=gridData nowrap>"+sex+"</td><td id='rth"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td><td id='rti"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("SPLTY_NAME")+"</a></td>");//Added - Changes suggested by sunil
							if(locationType.equals("OP")){
							out.println("<td id='rtq"+i+"' class=gridData nowrap>"+rsPatList.getString("visit_type")+"</td>");
							}
							out.println("<td id='rtj"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtk"+i+"' class=gridData nowrap colspan='2'>"+queue_status+"</td><td id='rtl"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}
						}
						else if(rsPatList.getString("episode_type").equals("I"))
						{
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else { 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append( "<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}							
							}
							
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								%>
								<thead style="top: 15px;">
								<tr>
								<th class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' nowrap><a class='gridLink'  onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></a></th><!--54073-->
								<th class='columnheader' nowrap><a class='gridLink' id='a01'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap colspan='3'><a class='gridLink' id='a02'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a10'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a12'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a13'   href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a07'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></th><!--Changes suggested by sunil-->
								<th class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('IQS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap> <fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!-- IN044246 -->							
								<th class='columnheader' nowrap><a class='gridLink' id='a09' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a14'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
							<%
								//IN064342 start
								if("Y".equals(pre_dis_advc_prep_site_YN)){
							%>
								<th class='columnheader' nowrap><a class='gridLink' id='a18'   href="javascript:callForOrderByLoc('PDA');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.PreDischargeAdvice.label" bundle="${ca_labels}"/></a></th>
							<%
								}
								//IN064342 Ends
							%>
								</tr>
								</thead>
									<%
								i++;
								i++;
								inpHeader=true;
							}
							 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+counts++ +"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap colspan='3'>");//54073
							
							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink'  href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928													
							}
							else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							out.println("</font></td><td id='rtc"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rtd"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rte"+i+"' class=gridData nowrap>"+sex+"</td>");
							out.println("<td id='rtk"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("BED_NUM")+"</a></td>");
							out.println("<td id='rtl"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("ROOM_NUM")+"</a></td>");
							out.println("<td id='rtf"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rtg"+i+"' class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td id='rth"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rti"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td>");
							out.println("<td id='rtj"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>"); // added for CRF-025 - IN030466//Changes suggested bu sunil
							//IN064342 start
							if(rsPatList.getString("referral_id")!= null){
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}
								else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}else{
								if("N".equals(pre_dis_advc_prep_site_YN)){	
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}
							if("Y".equals(pre_dis_advc_prep_site_YN)){
								if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
									out.println("<td class=gridData nowrap>");
								%>
									<fmt:message key="eCA.Prepared.label" bundle="${ca_labels}"/>	
								<%
								out.println("</td></tr>");
								}else{
									out.println("<td class=gridData nowrap>");
								%>
									<fmt:message key="eCA.NotPrepared.label" bundle="${ca_labels}"/>
								<%
									out.println("</td></tr>");
								}
							}
							//IN064342 ends
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");					
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
					   %>
						<!--32902 start-->
						<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
						<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
						<!--32902 end--->
						<%
						i++; k++;
						prevcompstring = currcompstring; link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();	
			
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}else if(groupByEpisode.equals("N") && groupByLocn.equals("Y")){
			try{
				//boolean outpHeader=false; 
				//boolean inpHeader=false;
				String currLocn="";
				String currcompstring = "";
				String prevcompstring = "`";
				String displaytext = "";
				String status = null;
				String currpract = null;
				String currvisitdate = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;					  
				String disp_cls_cons_date =null;						  
				StringTokenizer st = null;
				String n = null;
				String datedisplay = null;
				String practScheduled= null;
				String tempDischargeDate = "";
				//boolean header = false;
				String p_patient_id = "";// added for CRF 192 - IN030532 
				String p_queue_status = null; //added for CRF 192 - IN030532
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]
				String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
				qms_interfaced_yn = eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,con); // added for CRF 192 - IN030532
				int count= 1;//22856- ML-MMOH-CRF-1778
				while(rsPatList.next() && iterate <=end ){
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF - 025 - IN030466	
					if(res_pat_rec_count > 0){
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					}else{
						pi_clinical_stud_gif = "";
					}
					p_patient_id = rsPatList.getString("patient_id"); //added for CRF 192 - IN030532 
					
					//IN042191 starts
					q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");							
					
					if(q_num.equals("0")) queueNumber = "&nbsp;";				
					else queueNumber = rsPatList.getString("QUEUE_NUM");
					p_queue_status = rsPatList.getString("queue_status"); // End
					
					iterate++ ;
						
					flag=false;
					if (k % 2 == 0 )
						rowclass = "gridData";
					else
						rowclass = "gridData";

					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";					
						flag = false;
						if(header == false){				
							header = true;
							i++;
						}
						rowclass = "gridData";				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";

						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

						//IN064836 start
						if("U".equals(sex))
							sex = "Unknown";
						//IN064836 ends
						sex  = bean.getLabel(pageContext,sex);
						status  = bean.getLabel(pageContext,status);
						// added for IN048463 - Start
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
							else if(bedside_ref_review_status.equals("C"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
							else if(bedside_ref_review_status.equals("N")) // IN052595 
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
							//IN064836 start
							else if(bedside_ref_review_status.equals("X"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
							else if(bedside_ref_review_status.equals("S"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
							//IN064836 ends
						}
						// added for IN048463 - End
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";						
						st = new StringTokenizer(patient_status,"|");	
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}

						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED"; rowclass = "DECEASED1"; decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY"; decesedColor = "";
						}else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();						
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en"))								
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									else
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
								  
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td>");
									layer.append("<td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td>");
									layer.append("<td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}
							
						}
						out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='gridLink' ><a href=\"javascript:showEncounterDeatils()\" >&nbsp;+&nbsp;</a></td><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") ){
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");
						}else{
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						}
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); // modified above out.println for CRF-025 IN030466
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			%>
									<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
				<%
									out.println("</a></font></td>");
								}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						}  // added for IN048463 - Start
						else { 
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
							{
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			%>
								<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
			<%
								out.println("</a></font></td>");
								}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			%>
								<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
			<%
								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - End
						
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
		%>
						<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rsPatList.getString("patient_id")%>'>
						<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rsPatList.getString("referral_id")%>'>
						<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rsPatList.getString("ASSIGN_CARE_LOCN_CODE")%>'>
						<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rsPatList.getString("ATTEND_PRACTITIONER_ID")%>'>
						<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rsPatList.getString("sex")%>'>
						<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rsPatList.getString("unAssigned_yn")%>'>
		<%
						i++;
						k++;
					}else{
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");
						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994


						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");	
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="F";

						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = ""; deceasedYn = ""; 
						int noofchildren = 0;
						relationYn = ""; className = rowclass; className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;"; disp_cls_cons_date ="&nbsp;";
						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
					
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(deceasedYn.equals("D")){
							className="CADECEASED";
							rowclass = "DECEASED1";
							decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D"))
						{	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date="&nbsp;";

						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						if(rsPatList.getString("episode_type").equals("O")){
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								%>
								<thead>
								<tr>
								<th class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' nowrap><a class='gridLink' id='a01'   href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a  class='gridLink' id='a02'   href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style='color:white'><%=queueValue%></a></th>
								
								<% if(isQMSapplicable && locn_type.equals("OP")){ %>
									<th class='columnheader' width="" nowrap><fmt:message key="eOP.CallTicket.label" bundle="${op_labels}"/></th>
								<%}%>							
								<th class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
								<%
								//37866 Start.
								if(isVirtualConsSiteSpec && "OP".equals(locationType)){%>
								<th class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></th>
								<%}
								//37866 End.
								%>
								<th class='columnheader' nowrap><a  class='gridLink' id='a07'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a  class='gridLink' id='a05'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a  class='gridLink' id='a12'   href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap colspan=2><a class='gridLink' id='a10'   href="javascript:callForOrderByLoc('QS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>							
								<th class='columnheader' nowrap style='color:white'> <fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!-- IN044246 -->
								<th class='columnheader' nowrap><a class='gridLink' id='a09'   href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink'  id='a13'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
								</tr>
								<thead>
									<%
								i++;
								outpHeader=true;
							}
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								if(currpract.equals("")){
									practScheduled = "Unassigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								}else {
									practScheduled = "Assigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels");
								}
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled;
								displaytext= rsPatList.getString("LOCN_NAME")+", "+strTempDisp;
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = rsPatList.getString("LOCN_NAME")+currvisitdate;
								displaytext= rsPatList.getString("LOCN_NAME")+", "+datedisplay;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								if(currpract.equals("")){
									practScheduled = "Unassigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								}else{
									practScheduled = "Assigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels");
								}
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled+currvisitdate;
								displaytext= rsPatList.getString("LOCN_NAME")+", "+strTempDisp+", "+datedisplay;
							}else{
								currcompstring = rsPatList.getString("LOCN_NAME");
								displaytext= rsPatList.getString("LOCN_NAME");
							}
							if(!currcompstring.equals(prevcompstring)){
								out.println("<tr><td class='CAGROUP'  colspan='16'><font size=1><b>"+displaytext+"</b></font></td></tr>");
								i++;
							}
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							//51215 Start.
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							//51215 End.
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+count++ +"&nbsp;"+c4cStatuDisplay+"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap>");
							
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT"); // added for CRF 192 - IN030532 - Start
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1)
							{
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}	
							
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM")))
								{
									out.println("<td class=gridData nowrap><img style='cursor:pointer;' src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> ");//IN000000
								}else{
									out.println(" <td class = gridData nowrap>&nbsp;</td>");//IN000000
								}
							} 	// 	CRF 192 - IN030532 - End
							
							if(link_allowed_yn.equals("Y")){
								out.println("<td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN000000
							}else{
								out.println("<td class=gridData nowrap><font color="+decesedColor+">"+patName);
							}
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
							}
							//37866 End.
							out.println("</font></td><td class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</td>");
							out.println("<td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap colspan='2'>"+queue_status+"</td>");
							out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>"); // modified for CRF-025
							
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
							out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}
						}
						else if(rsPatList.getString("episode_type").equals("I"))
						{
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else{ 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
							}
							if(rsMotherLink!=null)rsMotherLink.close();
							if(stmtMotherLink!=null) stmtMotherLink.close();
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								%>
								<thead>
								<tr>
								<th class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' width='16px'>&nbsp;</th>
								<th class='columnheader' nowrap colspan='3'><a class='gridLink' id='a01' href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a05'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a03'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a04'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a10'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a11'   href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a06'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a09'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a08'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap> <fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!-- IN044246 -->
								<th class='columnheader' nowrap><a class='gridLink' id='a07' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a12'   href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th>
								<th class='columnheader' nowrap><a class='gridLink' id='a02'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
								</tr>
								</thead>
									<%
								i++;
								inpHeader=true;
							}
							if(!currLocn.equals(rsPatList.getString("LOCN_NAME"))){
								out.println("<tr><td colspan='16' class='CAGROUP' ><font size='1'><B>"+rsPatList.getString("LOCN_NAME")+"/Ward"+"</td></tr></font>");
								i++;
								currLocn=rsPatList.getString("LOCN_NAME");
							}
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap colspan='3'>");
							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928
							}else{
								out.println("<font color="+decesedColor+">"+patName);
							}

								out.println("</font></td><td class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td>");
								out.println("<td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td><td class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td>");
								out.println("<td class=gridData nowrap>"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap>"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
								//IN064342 start
								if(rsPatList.getString("referral_id")!= null)
								{
									if("N".equals(pre_dis_advc_prep_site_YN)){
										out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
									}else{
										out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
									}
								}else{	
									if("N".equals(pre_dis_advc_prep_site_YN)){
										out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
									}else{
										out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
									}
								}
								if("Y".equals(pre_dis_advc_prep_site_YN)){
									if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
										out.println("<td class=gridData nowrap>");
										%>
											<fmt:message key="eCA.Prepared.label" bundle="${ca_labels}"/>	
										<%
										out.println("</td></tr>");
									}else{
										out.println("<td class=gridData nowrap>");
										%>
											<fmt:message key="eCA.NotPrepared.label" bundle="${ca_labels}"/>
										<%
										out.println("</td></tr>");
									}
								}
								//IN064342 ends
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
						i++;
						k++;
						prevcompstring = currcompstring;
						link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
			
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}else if(groupByEpisode.equals("Y") && groupByLocn.equals("Y")){
			try{
				boolean outpHeader=false;
				boolean inpHeader=false;
				String currLocn="";
				String currcompstring = "";
				String prevcompstring = "`";		
				String status = null;
				String currpract = null;
				String currvisitdate = null;
				String emergencyYn = null;   
				String deceasedYn = null;   
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;											   
				String disp_cls_cons_date =null;										   
				StringTokenizer st = null;
				String n = null;
				String datedisplay = null;
				String practScheduled= null;
				String tempDischargeDate = "";
				//boolean header = false;
				String p_queue_status = null; //added for CRF 192 - IN030532
				qms_interfaced_yn = eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,con); // added for CRF 192 - IN030532
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193] 
				String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
				int count= 1;//22856- ML-MMOH-CRF-1778
				while(rsPatList.next()){
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025	- IN030466
					if(res_pat_rec_count > 0){
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					}else{
						pi_clinical_stud_gif = "";
					}
					
					p_queue_status = rsPatList.getString("queue_status");
					
					flag=false;
					if (k % 2 == 0 )
					   rowclass = "gridData";
					else
					   rowclass = "gridData";
					 
					if(locn_type.equals("RP")){
						if( iterate <=end){
							iterate++ ;
							String patient_status="";
							String title ="";
							String dateofbirth1  ="";						
							flag = false;				
							if(header == false)
							{
							%>			    
								<jsp:include page="../../eCA/jsp/PatListByLocationResultHeader01.jsp" flush="true" /> 
							<%
								header = true;
								i++;
							}
							rowclass = "gridData";				
							emergencyYn = "";
							deceasedYn = "";
							int noofchildren = 0;
							relationYn = "";
							className = rowclass;
							className1 = rowclass;
							text = "&nbsp;&nbsp;&nbsp;";
							disp_cls_cons_date = "&nbsp;";

							patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
							episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
							sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
							status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
							bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
							patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
							
							episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
							//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

							//IN064836 start
							if("U".equals(sex))
								sex = "Unknown";
							//IN064836 ends					
							sex  = bean.getLabel(pageContext,sex);
							
							status  = bean.getLabel(pageContext,status);
							// added for IN048463 - Start
							if(allow_muti_bedside_review_yn.equals("Y")){
								if(bedside_ref_review_status.equals("P"))
									status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
								else if(bedside_ref_review_status.equals("C"))
									status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
								else if(bedside_ref_review_status.equals("N")) // IN052595 
									status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
								//IN064836 start
								else if(bedside_ref_review_status.equals("X"))
									status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
								else if(bedside_ref_review_status.equals("S"))
									status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
								//IN064836 ends
							}
							// added for IN048463 - End
							if(rsPatList.getString("unAssigned_yn").equals("N"))
								title = "Speciality Specific Patient (Unassigned)";
							else
								title = "";
								
							st = new StringTokenizer(patient_status,"|");
			
							while (st.hasMoreTokens()){
								emergencyYn = st.nextToken();
								deceasedYn = st.nextToken();
								n = st.nextToken();
								if(!(n == null || n.equals("")))
									noofchildren = Integer.parseInt(n);
								relationYn = st.nextToken();
							}

							if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
								if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
									className = "DISCHARGED";
							if(deceasedYn.equals("D")){
								className = "CADECEASED";
								rowclass = "DECEASED1";
								decesedColor = "";
							}else if(deceasedYn.equals("S")){
								rowclass = "GRAY";
								decesedColor = "";
							}else{
								decesedColor = "";
							}
							if(noofchildren > 0) 
								className = "NEWBORN";
							emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
							//IN044157 - Start
							if(!emergencyYn.equals(""))
								className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
							//IN044157 - End
							if(relnreqyn.equals("Y")){
								if(relationYn.equals("N"))
									text = "<font size=2><b>*</b></font>";
							}
							if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
								layer = new StringBuffer();
								
								if(noofchildren > 0){
									stmtMotherLink.setString(1,locale);
									stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
									stmtMotherLink.setString(3,facility_id);
									stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
									rsMotherLink = stmtMotherLink.executeQuery();
									while(rsMotherLink.next()){
										if(locale.equals("en")){
										  dateofbirth1=rsMotherLink.getString("date_of_birth");
										}else{
										  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
									   }
										apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
										layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td>");
										layer.append("<td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td>");
										layer.append("<td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
									}
									if(rsMotherLink!=null) rsMotherLink.close();
								}
							}
							out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
							
							 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							String  practitioner_id = rsPatList.getString("TO_PRACT_ID");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							
							if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") ){
								out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");//IN032928
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
							}
							out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td>");
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td>");
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>");// modifid above for CRF-025 IN030466
							if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
					%>
										<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
					<%
										out.println("</a></font></td>");
									}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else if(!referralRegister || "Unassigned".equals(status)){
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else{
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
				%>
									<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
				<%
									out.println("</a></font></td>");
								}
								//IN064836 ends
							} // added for IN048463 - Start
							else{ 
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals(""))){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
					%>
										<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
					<%
										out.println("</a></font></td>");
									}
									//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else{
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
				%>
									<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
				<%
									out.println("</a></font></td>");
								}
								//IN064836 ends
							} // added for IN048463 - End
							out.println("<script language='javascript'>");
							out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
							out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
							out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added forIN072994
						    out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						    out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added forIN072994
							out.println("</script>");
			%>
							<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rsPatList.getString("patient_id")%>'>
							<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rsPatList.getString("referral_id")%>'>
							<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rsPatList.getString("ASSIGN_CARE_LOCN_CODE")%>'>
							<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rsPatList.getString("ATTEND_PRACTITIONER_ID")%>'>
							<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rsPatList.getString("sex")%>'>
							<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rsPatList.getString("unAssigned_yn")%>'>
							<!--32902 start-->
						<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!--32902-->
						<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!--32902-->
						<!--32902 end--->
													
			<%
							i++;
							k++;
						}
					}else{					
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");

						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994


						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						rsPatList.getString("patient_id");
					
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){

								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";

						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date ="&nbsp;";

						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(deceasedYn.equals("D")){
							className="CADECEASED";
							rowclass = "DECEASED1";
							decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D")){	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						// color coding ends
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date="&nbsp;";

						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						
						if(rsPatList.getString("episode_type").equals("O")){ 
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								i++;
								i++;
							}
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								if(currpract.equals("")){
									practScheduled = "Unassigned";
								}else {
									practScheduled = "Assigned";
								}
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled;						
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = rsPatList.getString("LOCN_NAME")+currvisitdate;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else
									practScheduled = "Assigned";
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled+currvisitdate;
							}else{
								currcompstring = rsPatList.getString("LOCN_NAME");
							}
							if(!currcompstring.equals(prevcompstring)){
								i++;
							}

							encounterID = rsPatList.getString("EPISODE_ID");
							patientClass = rsPatList.getString("patient_class");
							queueDesc="&nbsp;";
							if(patientClass.equals("EM")){
								
									queueNumber = bean.getQueueDesc(con,facility_id,encounterID);
								
							}else{
							//IN042191 starts
									q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");
							
								if(q_num.equals("0")) queueNumber = "&nbsp;";						
								else queueNumber = rsPatList.getString("QUEUE_NUM");
							}					
							//[IN030291] Start
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							//51215 Start.
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							//51215 End.
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+count++ +"&nbsp;"+c4cStatuDisplay+"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+queueNumber+"</td>");//22856 -ML-MMOH-CRF-1778
							//out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+queueNumber+"</td>");
							String  p_patient_id=rsPatList.getString("patient_id"); // modified for CRF 192 - IN030532 -Start
							// added for CRF 192
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT");
							
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1){
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}				 
						
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM"))){	
									out.println("<td id='rtp"+i+"' class=gridData nowrap><img style='cursor:pointer; 'src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> ");
								}else{
									out.println(" <td id='rtp"+i+"' class = gridData nowrap>&nbsp;</td> ");
								}
							}	// END CRF 192 - IN030532
							String isInpatient = patdata.CheckInPatient(con,p_patient_id,facility_id);
							if(isInpatient.equals("CURRENTLY_IN_PATIENT")) {
								out.println("<td id='rtc"+i+"' class=gridData nowrap><img align='center'  src='../../eCommon/images/inpatient.gif' alt=''></img></td>");
							}else{
								out.println("<td id='rtc"+i+"' class=gridData nowrap>&nbsp;</td>");
							}
							out.println("<td id='rtd"+i+"' class=gridData nowrap>");
							//[IN030291] End
						  restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902


							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928
							}else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData'width=100 nowrap>&nbsp;</td>");
							}
							//37866 End.
							out.println("</font></td><td id='rte"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class=gridData nowrap>"+sex+"</td><td id='rth"+i+"' class=gridData nowrap style='width=150px;color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rti"+i+"'  class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp;"+rsPatList.getString("SPLTY_NAME")+"</a></td>");//Changes suggested by sunil
							if(locationType.equals("OP")){
							out.println("<td id='rtq"+i+"' class=gridData nowrap>&nbsp;&nbsp"+rsPatList.getString("visit_type")+"</td>");
							}
							out.println("<td id='rtj"+i+"' class=gridData nowrap>&nbsp;&nbsp;"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtk"+i+"' class=gridData nowrap colspan='2'>&nbsp;&nbsp;"+queue_status+"</td><td id='rtl"+i+"' class=gridData nowrap style='width=100px;color:white'><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td id='rtm"+i+"' class=gridData nowrap>&nbsp;&nbsp;"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>&nbsp;&nbsp;"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
							if(rsPatList.getString("referral_id")!= null){
								out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">&nbsp;&nbsp;&nbsp"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
								out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">&nbsp;&nbsp;"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}
							//32902 start
							%>
						<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'>
						<input type="hidden" id="practitioner_id<%=i%>"  name="practitioner_id<%=i%>" value='<%=rsPatList.getString("physician_id")%>'>
						<input type="hidden" id="facility_id"  name="facility_id" id="facility_id" value='<%=facility_id%>'>
						<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'>
			                  	<%
						//32902 end

						}else if(rsPatList.getString("episode_type").equals("I")){ 
							
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else{ 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" + com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+ "</font></td>");
									layer.append("<td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								
							}					
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								i++;
								i++;
							}
							if(!currLocn.equals(rsPatList.getString("LOCN_NAME"))) {
								i++;
								currLocn=rsPatList.getString("LOCN_NAME");
							}
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ count++ +"</td><td id='rta"+i+"' class=gridData nowrap colspan='3' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")'>");//CRF-1778
							//out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td id='rta"+i+"' class=gridData nowrap colspan='3' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")'>");
							
							restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							String  practitioner_id = rsPatList.getString("physician_id");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902


							if(link_allowed_yn.equals("Y")){
								out.println("<a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">&nbsp;&nbsp"+patName+"</a>");//IN032928
							}else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							out.println("</font></td><td id='rtb"+i+"' class=gridData nowrap>&nbsp;&nbsp"+ rsPatList.getString("patient_id")+"</td><td id='rtc"+i+"' class=gridData nowrap>&nbsp;&nbsp"+rsPatList.getString("AGE")+"</td><td id='rtd"+i+"' class=gridData nowrap>&nbsp;&nbsp"+sex+"</td><td id='rte"+i+"' class=gridData nowrap>&nbsp;&nbsp"+rsPatList.getString("BED_NUM")+"</td>");
							out.println("<td id='rtf"+i+"' class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp"+rsPatList.getString("ROOM_NUM")+"</a></td>");
							out.println("<td id='rtg"+i+"' class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rth"+i+"' class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp"+rsPatList.getString("SPLTY_NAME")+"</a></td><td id='rti"+i+"' class=gridData nowrap>&nbsp;&nbsp"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td>");
							out.println("<td id='rtj"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">&nbsp;&nbsp"+queue_status+"</td><td id='rtk"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td id='rtl"+i+"' class=gridData nowrap>&nbsp;&nbsp"+disp_cls_cons_date+"</td>");
							out.println("<td id='rtm"+i+"' class=gridData nowrap>&nbsp;&nbsp"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
							//IN064342 start
						     // 32902 start
							%>
							<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'>
							<input type="hidden" id="practitioner_id<%=i%>"  name="practitioner_id<%=i%>" value='<%=rsPatList.getString("physician_id")%>'>
							<input type="hidden" id="facility_id"  name="facility_id" id="facility_id" value='<%=facility_id%>'>
							<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'>
			                <%
						     // 32902 end

							if(rsPatList.getString("referral_id")!= null){
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td id='rtn"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}else{
									out.println("<td id='rtn"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}else{
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td  id='rtn"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}
								else{
									out.println("<td  id='rtn"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}
							if("Y".equals(pre_dis_advc_prep_site_YN)){
								if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
									out.println("<td class=gridData nowrap>");
									%>
										<fmt:message key="eCA.Prepared.label" bundle="${ca_labels}"/>	
									<%
									out.println("</td></tr>");
								}else{
									out.println("<td class=gridData width='1px' nowrap>");
									%>
										<fmt:message key="eCA.NotPrepared.label" bundle="${ca_labels}"/>
									<%
									out.println("</td></tr>");
								}
							}
							//IN064342 ends
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
						
						i++;
						k++;
						prevcompstring = currcompstring;
						link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();			
				if(locn_type.equals("RP")){
	%>
<script>
					/* <tr id='titleHdrRP' style='visibility:hidden' >
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th nowrap>	<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></th>
					<th nowrap>	<fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
					<th nowrap>			<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></th>
					<th nowrap>							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th nowrap>	<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></th>
					<th nowrap>							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></th>
					<th nowrap>	<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></th>
					<th nowrap>		<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
					<th nowrap>		<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!-- IN044246 -->
					<th nowrap>		<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
					</tr> */
					// Define the HTML content to be added
				const newHeaderRow = `<tr id='titleHdrRP' >
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th nowrap  valign="top"><a id='a01'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a02'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a03'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a04'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a05'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a06'  href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a07'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'>
							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a08' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a09'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a10'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
				<!-- added new header for CRF-025 -->
				<!--<th nowrap><fmt:message key="eCA.researchStudy.label" bundle="${ca_labels}"/></th>-->
				<th nowrap  valign="top"><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!--IN044246-->
				<th nowrap  valign="top"><a id='a11'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
				</tr>`;

// Get the table by its ID
const table = document.getElementById('PatCriteriaTbl');

// Check if the table exists
if (table) {
    // Get or create the <thead> element
    let thead = table.querySelector('thead');
    if (!thead) {
        thead = document.createElement('thead');
        table.prepend(thead);
    }
    
    // Add the new header row to the <thead>
    thead.innerHTML += newHeaderRow;
} else {
    console.error("Table with ID 'PatCriteriaTbl' not found.");
}
document.getElementById('PatCriteriaTbl').style.marginTop="0px";
document.getElementById('prevnexttab').style.display="none";
parent.document.getElementById('LocnResultTitle').style.display="none";
parent.document.getElementById('LocnResult').style.height="83vh";

	</script>				
	<%
				}			
				if(isIP){
					%>
					
					<script>
					const newHeaderRow = `
					<tr id='titleHdrIP' >
					<th class='columnheader' width="16px" nowrap  valign="top">&nbsp;</th>
                        <th class='columnheader' width="16px" nowrap  valign="top">&nbsp;</th>
                        <!-- //22856-start-->
                        <th class='columnheader' width="" nowrap rowspan=3 valign="top" ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></th>
                        <!-- //22856-End-->
                        <th class='columnheader' width="" nowrap colspan=3  valign="top"><a id='a01'  name=1 href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
                        <th class='columnheader' width="" nowrap  valign="top"><a id='a02' name=1 href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
                        <th class='columnheader' width="" nowrap  valign="top"><a id='a03' name=1 href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
                        <th class='columnheader' width="" nowrap  valign="top"><a id='a04' name=1 href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
						<!-- Changes Suggested By Sunil To rearrange bedNo and Room No Column-->
						<th class='columnheader' width="" nowrap valign="top"><a id='a05' name=1 href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
						
						<th class='columnheader' width="" nowrap  valign="top"><a id='a06' name=1 href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
						<th class='columnheader' width="" nowrap  valign="top"><a id='a07' name=1 href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th>
						<th class='columnheader' width="" nowrap  valign="top"><a id='a08' name=1 href="javascript:callForOrderByLoc('AD');"  onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></th>
						<th class='columnheader' width="" nowrap  valign="top"><a id='a09' name=1 href="javascript:callForOrderByLoc('IQS');"  onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>
						<!-- added new header for CRF-025 -->
						<!--<td class='columnheader' width="" nowrap><style="color:white"/><fmt:message key="eCA.researchStudy.label" bundle="${ca_labels}"/></td>-->
						<th class='columnheader' width="" nowrap  valign="top"><style="color:white"/><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th> <!--IN044246-->
						<!-- Changes Suggested By Sunil To rearrange bedNo and Room No Column-->
						<!--<td class='columnheader' width="" nowrap><a id='a10' name=1 href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></td>--><th class='columnheader' width="" nowrap valign="top"><a name=1 href="javascript:callForOrderByLoc('DD');"  onclick='changeColor(this);' style="color:white"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
                        
					<%
						//IN064342 start
						if("Y".equals(pre_dis_advc_prep_site_YN))
						{
					%>
							<th class='columnheader' width=""  valign="top"><a id='a11' name=1 href="javascript:callForOrderByLoc('PDA');" onclick='changeColor(this);' style="color:white"><fmt:message key="eCA.PreDischargeAdvice.label" bundle="${ca_labels}"/></a></th>
					<%
						}
						//IN064342 end
					%>
					<th class='columnheader' width=""  valign="top">&nbsp;&nbsp;&nbsp;</th>
					<tr>`;
					
					// Get the table by its ID
const table = document.getElementById('PatCriteriaTbl');

// Check if the table exists
if (table) {
    // Get or create the <thead> element
    let thead = table.querySelector('thead');
    if (!thead) {
        thead = document.createElement('thead');
        table.prepend(thead);
    }
    
    // Add the new header row to the <thead>
    thead.innerHTML += newHeaderRow;
} else {
    console.error("Table with ID 'PatCriteriaTbl' not found.");
}
document.getElementById('PatCriteriaTbl').style.marginTop="0px";
document.getElementById('prevnexttab').style.display="none";
parent.document.getElementById('LocnResultTitle').style.display="none";
parent.document.getElementById('LocnResult').style.height="83vh";
	</script>
						<%
					inpHeader=true;
				}
				if(isOP)
				{
					%>
					<script>
					 const newHeaderRow = `<tr id='titleHdrOP'>
							<th class='columnheader' width="16px" nowrap valign="top">&nbsp;</th>
                            <th class='columnheader' width="16px" nowrap valign="top">&nbsp;</th>
                           <!-- //22856-start-->
                            <th class='columnheader' width="" nowrap rowspan=2 valign="top" ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></th>
                           <!-- //22856-End-->
                            <!-- <td class='columnheader' width="" nowrap><a id='a01' name=1 href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style="color:white"><%=queueValue%></a></td><td class='columnheader' width="" nowrap colspan=3><a name=1 href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></td> [IN030291]-->
							<th class='columnheader' width="" nowrap  valign="top"><a id='a02' name=1 href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a03' name=1 href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style="color:white"><%=queueValue%></a></th>
							<% if((isQMSapplicable) && locn_type.equals("OP")) // added for [IN030532]
							{ 
							%>
								<th class='columnheader' width="" nowrap  valign="top"><fmt:message key="eOP.CallTicket.label" bundle="${op_labels}"/></th>
							<%
							}
							%>
							<th class='columnheader' width="" nowrap colspan=3  valign="top"><a id='a04' name=1 href="#" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.isinpatient.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap colspan=3  valign="top"><a id='a05' name=1 href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
							<%
							//37866 Start.
							if(isVirtualConsSiteSpec  &&  "OP".equals(locationType)){%>
								<th class='columnheader'   nowrap ><a id='a06' style='color:white'   ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")%></a></th>
							<%}
							//37866 End.
							%>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a07' name=1 href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a08' name=1 href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a09' name=1 href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a10' name=1 href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="width=150px;color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a11' name=1 href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th>  <!--  [IN030291] -->
							
							
							
							<%if( "OP".equals(locationType)){%>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a12' name=1 href="javascript:callForOrderByLoc('VT');" onclick='changeColor(this);' style="color:white"><nobr><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></nobr></a></th>
							<%}%>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a13' name=1 href="javascript:callForOrderByLoc('VD');" onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap colspan=2 valign="top"><a id='a14' name=1 href="javascript:callForOrderByLoc('QS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>
								<!-- added new header for CRF-025 -->
							<!--<td class='columnheader' style="width=100px;color:white" nowrap>	<fmt:message key="eCA.researchStudy.label" bundle="${ca_labels}"/>		</td>	-->
							<th class='columnheader' width="" nowrap  valign="top"><style="color:white"/><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th> <!--IN044246-->
							<th class='columnheader' width="" nowrap  valign="top"><nobr><a id='a15' name=1 href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style="color:white"><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></nobr></th>
							<th class='columnheader' width="" nowrap  valign="top"><a id='a16' name=1 href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><nobr><a id='a17' name=1 href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></nobr></th>
                            <th class='columnheader' width=""  valign="top">&nbsp;&nbsp;&nbsp;</th>
							</tr>`;
					
					// Get the table by its ID
const table = document.getElementById('PatCriteriaTbl');

// Check if the table exists
if (table) {
    // Get or create the <thead> element
    let thead = table.querySelector('thead');
    if (!thead) {
        thead = document.createElement('thead');
        table.prepend(thead);
    }
    
    // Add the new header row to the <thead>
    thead.innerHTML += newHeaderRow;
} else {
    console.error("Table with ID 'PatCriteriaTbl' not found.");
}
document.getElementById('PatCriteriaTbl').style.marginTop="0px";
document.getElementById('prevnexttab').style.display="none";
parent.document.getElementById('LocnResultTitle').style.display="none";
parent.document.getElementById('LocnResult').style.height="83vh";
	</script>
					
						<%
					outpHeader=true;
				}
			
			}catch(Exception e4){
				e4.printStackTrace();
			}
		}
		if(rsMotherLink!=null) rsMotherLink.close();
		if(stmtMotherLink != null ) stmtMotherLink.close();
		if(rsPatList!=null) rsPatList.close();
		if(stmtPatList!=null) stmtPatList.close();

		if(flag){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href='../../eCommon/html/blank.html'</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCommon/html/blank.html'</script>");
		}
		putObjectInBean(bean_id,bean,session);		
	}
	catch(Exception e){
		e.printStackTrace();	
	}
	finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}%>
		</table>
		<input type="hidden" name="patient_class" id="patient_class" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="function_id" id="function_id" value='<%=request.getParameter("function_id")%>'>
		<input type="hidden" name="pre_dis_advc_prep_site_YN" id="pre_dis_advc_prep_site_YN" value='<%=pre_dis_advc_prep_site_YN%>'><!--IN064342-->
	</form>
    <div id='motherLink' name='motherLink' style='position:absolute; visibility:hidden;overflow:overflow'></div>
	<%
		if(floatTitle){%>
		<script>
			if('<%=leftScrolling%>'!=''){
				document.body.scrollLeft='<%=leftScrolling%>';
			}			
			if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById('TitleTab') == null){
				setTimeout("alignHeading();",300);
			}else 
				alignHeading();
		</script>
	<%
	}
	if(!anchorID.equals("")){
		%>
		<script>
			if('<%=leftScrolling%>'!='')
			{
				document.body.scrollLeft='<%=leftScrolling%>';
			}
			if('<%=anchorID%>'!='')
			{   //*** added to make all anchors white before making the selcted one pink
				for(i=0;i<document.anchors.length;i++){
					document.anchors[i].style.color='white';
				}//***
				if('<%=reOrder%>'=='1')
				{
					//document.getElementById("PatCriteriaTbl").<%=anchorID%>.style.color='pink';
					document.getElementById('<%=anchorID%>').style.color='pink';
				}
				else if('<%=reOrder%>'=='2')
				{
					//document.getElementById("PatCriteriaTbl").<%=anchorID%>.style.color='yellow';
					document.getElementById('<%=anchorID%>').style.color='yellow';
				}
			}
		</script>
	<%}%>		
	<script>		
		parent.parent.PatCriteriaFr.document.getElementById('searchID').disabled = false;
	</script>
    </body>	
</html>

