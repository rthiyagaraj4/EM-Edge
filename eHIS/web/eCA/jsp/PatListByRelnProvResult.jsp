<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
20/08/2012		IN029180		Chowminya G		 The system is not running by sequence number of newborn.	
13/03/2014		IN044157		Chowminya		 [AAKH CRF 0010.1]Five level Triage system  AE requirement
15/04/2023		37866			Ramesh G		 								MMS-DM-CRF-0226 
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778				
10/30/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210			
05/12/2023   54073     srinivasa N T              ramesh Goli          	
---------------------------------------------------------------------------------------------------------------

 -->
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locn_type =	request.getParameter("locn_type");
	String legendstyle="padding-left:0px;padding-right:0px";
%>
<html>
<!-- <link rel='stylesheet' type='text/css' href='../../eCA/html/IeStyle.css'>
<link rel="stylesheet" type="text/css" href="../../eCA/html/CAStyle.css"></link>
 -->
  <%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 <script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCA/js/PatListByRelnProvResult.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eCA/js/CACommon.js'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
<head>
</head>
<body onload="storeValues('<%=locn_type%>')"  onscroll='moveFrame()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<%

Connection con =null;

PreparedStatement stmtMotherLink = null;
ResultSet rsMotherLink = null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facility_id=(String)session.getValue("facility_id");
//String resp_id = (String)session.getValue("responsibility_id");
//String user_id = (String)session.getValue("login_user");
if(facility_id == null) facility_id="";
String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
String decesedColor="";
String	 encounterType    ="";
String	 relationshipCode ="";
String	 relnreqyn		   ="";
String	  fromDate   	   ="";
String	  toDate   		   ="";
String	  groupByReln	   ="";
String	  groupByEpisode   ="";
String patientId = "";
String queueId = ""; //alt id1
String queueStatus = "";
String sortOrder = "";
String Episode_Type_Desc="";
String Relationship_Type="";
String strGender="";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
String strVisitAdmDate	=	"";
String strBeginDate		=	"";
String strEndDate		=	"";
String strBirthDate		=	"";

//32902 start
String restPatientYN	=	"";
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	int accessRightsViewPatient=0;
//32902 end

String prev =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
String next =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

String pat_id1 ="";
String checkedOut ="";
String discharged ="";
String nonencspec ="";
int maxNoRecords = 0;
String attend_practId = "";
String speciality = "";
String dateofbirth1 = "";

try
{
	con = ConnectionManager.getConnection(request);
	//HttpSession thisSession = request.getSession(false);
	String clinicianId=(String) session.getValue("ca_practitioner_id");
	boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION");  //37866
	//added by ankur
	//values comming from title frame
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	//to give scrolling effect which clicked on title for sorting
	String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	//ends here
	String visitType = request.getParameter("visitType")==null?"":request.getParameter("visitType");
	
	if(mode.equals("search") || mode.equals(""))//when request for search for first time
	{

		relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
		encounterType = request.getParameter("locationType");
		relationshipCode = request.getParameter("relationshipCode");
		if(relationshipCode==null || relationshipCode.equals("null") || relationshipCode=="")
			relationshipCode = "";
		fromDate = request.getParameter("fromDate");
		if(fromDate==null || fromDate.equals("null") || fromDate.equals("") )
			fromDate="";
		toDate = request.getParameter("toDate");
		if(toDate==null || toDate.equals("null") || toDate.equals(""))
			toDate="";

		//out.println("fromDate"+fromDate);
		//out.println("toDate"+toDate);
		groupByReln = request.getParameter("groupByReln");
		groupByEpisode = request.getParameter("groupByEpisode");
		patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		queueId = request.getParameter("queueId")==null?"":request.getParameter("queueId");
		sortOrder = request.getParameter("sortOrder")==null?"v":request.getParameter("sortOrder");
		queueStatus = request.getParameter("queueStatus")==null?"":request.getParameter("queueStatus");
		if (queueStatus.equals("00")) 
			queueStatus = "";

		checkedOut = request.getParameter("checkedOut")==null?"":request.getParameter("checkedOut");
		discharged = request.getParameter("discharged")==null?"":request.getParameter("discharged");
		nonencspec = request.getParameter("nonencspec")==null?"":request.getParameter("nonencspec");
		attend_practId = request.getParameter("attend_practId")==null?"":request.getParameter("attend_practId");
		speciality = request.getParameter("speciality")==null?"":request.getParameter("speciality");
	}
	else
	{
		relnreqyn = request.getParameter("reln_req_yn1")==null?"Y":request.getParameter("reln_req_yn1");
		encounterType = request.getParameter("locationType1");
		relationshipCode = request.getParameter("relationshipCode1");
		if(relationshipCode==null || relationshipCode.equals("null") || relationshipCode=="")
			relationshipCode="";
		fromDate = request.getParameter("fromDate1");
		if(fromDate==null || fromDate.equals("null") || fromDate=="")
			fromDate="";
		toDate = request.getParameter("toDate1");
		if(toDate==null || toDate.equals("null") || toDate=="")
			toDate="";
		groupByReln= request.getParameter("groupByReln1");
		groupByEpisode= request.getParameter("groupByEpisode1");
		patientId = request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		queueId = request.getParameter("queueId1")==null?"":request.getParameter("queueId1");
		sortOrder = request.getParameter("sortOrder1")==null?"":request.getParameter("sortOrder1");
		queueStatus = request.getParameter("queueStatus1")==null?"":request.getParameter("queueStatus1");
		if (queueStatus.equals("00")) 
			queueStatus = "";
		attend_practId = request.getParameter("attend_practId1")==null?"":request.getParameter("attend_practId1");
		speciality = request.getParameter("speciality1")==null?"":request.getParameter("speciality1");
	}
	
	fromDate	= com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	toDate		= com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");

	boolean isScroll = true;
	boolean isIP = false;
	boolean isOP = false;
	boolean floatTitle  = false;
	if(locn_type==null)locn_type="";
	String locn_code =	request.getParameter("locn_code");
	
	if(locn_code==null)
		locn_code="";
	if(groupByEpisode.equals("Y") && groupByReln.equals("Y"))
	{
		
		floatTitle = true;
		isScroll = false;
		if(!locn_type.equals(""))
		{
			if(locn_type.equals("OP"))
			{
				isOP = true;
				encounterType = "OP";
			}
			else if(locn_type.equals("IP"))
			{
				isIP = true;
				encounterType = "IP";
			}
			else if(locn_type.equals("EM"))
			{
				isOP = true;
				encounterType = "EM";
			}
			else if(locn_type.equals("DC"))
			{  
				isIP = true;
				encounterType = "DC";
			}
			else if(locn_type.equals("XT"))
			{  
				isOP = true;
				encounterType = "XT";
			}
		}
		if(!locn_code.equals(""))
		{
			relationshipCode = locn_code;
		}
			
	}
	else if(groupByEpisode.equals("Y") && groupByReln.equals("N"))
	{
				
		if(!locn_type.equals(""))
		{
			if(locn_type.equals("OP"))
			{
				isOP = true;
				encounterType = "OP";
			}
			else if(locn_type.equals("IP"))
			{
				isIP = true;
				encounterType = "IP";
			}
			else if(locn_type.equals("DC"))
			{
				isIP = true;
				encounterType = "DC";
			}
			else if(locn_type.equals("EM"))
			{
				isOP = true;
				encounterType = "EM";
			}
			else if(locn_type.equals("XT"))
			{
				isOP = true;
				encounterType = "XT";
			}
			
		}
			
					
			if(locn_code.equals("RALL"))
			{
				relationshipCode = "";
			}
			else
			{
			relationshipCode = locn_code;
			}
		
			
	}
	else if(groupByEpisode.equals("N") && groupByReln.equals("N"))
	{
		if(encounterType.equals("Z"))
		encounterType = "";
		if(relationshipCode.equals("ALL"))
			relationshipCode="";

	}

    StringBuffer QueryString = new StringBuffer();
	StringBuffer WhereClause= new StringBuffer();
	if(QueryString.length() > 0) QueryString.delete(0,QueryString.length());
	
	 //QueryString.append("Select A.PRACTITIONER_ID PHYS_PROV_ID , A.PATIENT_ID , A.PATIENT_CLASS EPISODE_TYPE_DESC , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE , A.ENCOUNTER_ID EPISODE_ID , TO_NUMBER('') VISIT_ID, C.SEX , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') END LOCAN_NAME  , A.PRACT_RELN_ID PHYS_PROV_RELN_ID , to_char(A.BEGIN_DATE_TIME,'dd/mm/yyyy hh24:mi') BEGIN_DATE_TIME_STR , nvl(to_char(A.END_DATE_TIME,'dd/mm/yyyy hh24:mi'),'') END_DATE_TIME_STR , CA_GET_DESC.CA_PRACT_RELN(A.PRACT_RELN_ID,?,'1') PHYS_PROV_RELN_NAME   , AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PHY_PROV_NAME   , replace(decode(?,?,C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME, to_char(C.DATE_OF_BIRTH,'dd/mm/yyyy') DOB   ,   C.DATE_OF_BIRTH, GET_AGE(C.DATE_OF_BIRTH) AGE , to_char(B.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE  , to_char(B.DISCHARGE_DATE_TIME, 'dd/mm/yyyy') DISCHARGE_DATE  , B.ASSIGN_ROOM_NUM ROOM_NO, B.ASSIGN_BED_NUM BED_NO  , CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.ENCOUNTER_ID,a.PATIENT_CLASS,?,C.DECEASED_YN) STATUS , A.PATIENT_CLASS , B.VISIT_ADM_DATE_TIME orderbydate  , B.REFERRAL_ID REFERRAL_ID,b.PRIORITY_ZONE, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,(select LIFETIME_OR_ENCNTR from  ca_pract_reln where PRACT_RELN_ID=A.PRACT_RELN_ID ) RELATIONSHIP_TYPE,OP_GET_DESC.OP_VISIT_TYPE(?,VISIT_ADM_TYPE,?,1) visit_type FROM CA_ENCNTR_PRACT_RELN A, PR_ENCOUNTER B,MP_PATIENT C WHERE B.FACILITY_ID=A.FACILITY_ID AND B.ENCOUNTER_ID= A.ENCOUNTER_ID  AND nvl(C.suspend_yn,'*') != 'Y' AND C.PATIENT_ID=A.PATIENT_ID AND A.facility_id = ? AND A.practitioner_id = ? AND A.status='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7*/  ");
	//QueryString.append("Select A.PRACTITIONER_ID PHYS_PROV_ID , A.PATIENT_ID , A.PATIENT_CLASS EPISODE_TYPE_DESC , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE , A.ENCOUNTER_ID EPISODE_ID , TO_NUMBER('') VISIT_ID, C.SEX , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') END LOCAN_NAME  , A.PRACT_RELN_ID PHYS_PROV_RELN_ID , to_char(A.BEGIN_DATE_TIME,'dd/mm/yyyy hh24:mi') BEGIN_DATE_TIME_STR , nvl(to_char(A.END_DATE_TIME,'dd/mm/yyyy hh24:mi'),'') END_DATE_TIME_STR , CA_GET_DESC.CA_PRACT_RELN(A.PRACT_RELN_ID,?,'1') PHYS_PROV_RELN_NAME   , AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PHY_PROV_NAME   , replace(decode(?,?,C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME, to_char(C.DATE_OF_BIRTH,'dd/mm/yyyy') DOB   ,   C.DATE_OF_BIRTH, GET_AGE(C.DATE_OF_BIRTH) AGE , to_char(B.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE  , to_char(B.DISCHARGE_DATE_TIME, 'dd/mm/yyyy') DISCHARGE_DATE  , B.ASSIGN_ROOM_NUM ROOM_NO, B.ASSIGN_BED_NUM BED_NO  , CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.ENCOUNTER_ID,a.PATIENT_CLASS,?,C.DECEASED_YN) STATUS , A.PATIENT_CLASS , B.VISIT_ADM_DATE_TIME orderbydate  , B.REFERRAL_ID REFERRAL_ID,b.PRIORITY_ZONE, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,(select LIFETIME_OR_ENCNTR from  ca_pract_reln where PRACT_RELN_ID=A.PRACT_RELN_ID ) RELATIONSHIP_TYPE,OP_GET_DESC.OP_VISIT_TYPE(?,VISIT_ADM_TYPE,?,1) visit_type,ca_ae_get_priority_zone_color(b.PRIORITY_ZONE,'en') ae_zone_color,oa_appt_virtual_status(B.facility_id,B.patient_id,B.ENCOUNTER_ID,B.patient_class) virtualApptYN  FROM CA_ENCNTR_PRACT_RELN A, PR_ENCOUNTER B,MP_PATIENT C WHERE B.FACILITY_ID=A.FACILITY_ID AND B.ENCOUNTER_ID= A.ENCOUNTER_ID  AND nvl(C.suspend_yn,'*') != 'Y' AND C.PATIENT_ID=A.PATIENT_ID AND A.facility_id = ? AND A.practitioner_id = ? AND A.status='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7*/  "); //IN044157 //32902
	 QueryString.append("Select A.PRACTITIONER_ID PHYS_PROV_ID , A.PATIENT_ID , A.PATIENT_CLASS EPISODE_TYPE_DESC , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE , A.ENCOUNTER_ID EPISODE_ID , TO_NUMBER('') VISIT_ID, C.SEX , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') END LOCAN_NAME  , A.PRACT_RELN_ID PHYS_PROV_RELN_ID , to_char(A.BEGIN_DATE_TIME,'dd/mm/yyyy hh24:mi') BEGIN_DATE_TIME_STR , nvl(to_char(A.END_DATE_TIME,'dd/mm/yyyy hh24:mi'),'') END_DATE_TIME_STR , CA_GET_DESC.CA_PRACT_RELN(A.PRACT_RELN_ID,?,'1') PHYS_PROV_RELN_NAME   , AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PHY_PROV_NAME   , replace(decode(?,?,C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME, to_char(C.DATE_OF_BIRTH,'dd/mm/yyyy') DOB   ,   C.DATE_OF_BIRTH, GET_AGE(C.DATE_OF_BIRTH) AGE , to_char(B.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE  , to_char(B.DISCHARGE_DATE_TIME, 'dd/mm/yyyy') DISCHARGE_DATE  , B.ASSIGN_ROOM_NUM ROOM_NO, B.ASSIGN_BED_NUM BED_NO  , CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.ENCOUNTER_ID,a.PATIENT_CLASS,?,C.DECEASED_YN) STATUS , A.PATIENT_CLASS , B.VISIT_ADM_DATE_TIME orderbydate  , B.REFERRAL_ID REFERRAL_ID,b.PRIORITY_ZONE, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,(select LIFETIME_OR_ENCNTR from  ca_pract_reln where PRACT_RELN_ID=A.PRACT_RELN_ID ) RELATIONSHIP_TYPE,OP_GET_DESC.OP_VISIT_TYPE(?,VISIT_ADM_TYPE,?,1) visit_type,ca_ae_get_priority_zone_color(b.PRIORITY_ZONE,'en') ae_zone_color,oa_appt_virtual_status(B.facility_id,B.patient_id,B.ENCOUNTER_ID,B.patient_class) virtualApptYN, C.restrict_reinstate_yn  FROM CA_ENCNTR_PRACT_RELN A, PR_ENCOUNTER B,MP_PATIENT C WHERE B.FACILITY_ID=A.FACILITY_ID AND B.ENCOUNTER_ID= A.ENCOUNTER_ID  AND nvl(C.suspend_yn,'*') != 'Y' AND C.PATIENT_ID=A.PATIENT_ID AND A.facility_id = ? AND A.practitioner_id = ? AND A.status='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7*/  "); //32902

	 if (!relationshipCode.equals(""))	 
		QueryString.append(" AND A.pract_reln_id = ? ");
     if (!encounterType.equals(""))
		QueryString.append(" AND A.patient_class = ? ");
	 if (!patientId.equals(""))
		 QueryString.append(" AND A.PATIENT_ID =? ");
	
	if(!encounterType.equals(""))
	{
	
		if(encounterType.equals("XT"))
		{
			
			if(nonencspec.equals("N"))
			{
				QueryString.append("and a.ENCOUNTER_ID is not null ");
			}
		}
		else if (encounterType.equals("OP")||encounterType.equals("EM"))
		{
			if(checkedOut.equals("N"))
			{
				QueryString.append("and b.visit_status between '00' and '06' ");
			}
			else

			{
				//QueryString.append("and b.visit_status between '00' and '07'");
				/***MODIFIED BY Deepa on 1/27/2010 at 11:44 AM for MF performance issue****/
				QueryString.append("and b.visit_status between '00' and '09'");
				/***MODIFIED BY Deepa on 1/27/2010 at 11:44 AM for MF performance issue****/
			}
			if (encounterType.equals("OP"))
			{
				if(!visitType.equals(""))
				{
					QueryString.append(" and VISIT_ADM_TYPE = ? "); // visitType
				}
			}

		}
		else if (encounterType.equals("IP")||encounterType.equals("DC"))
		{
			//out.println("encounterType&&&"+encounterType);
			//out.println("discharged&&&"+discharged);
			if(discharged.equals("N"))
			{
				QueryString.append("and b.adt_status between '01' and '02'  ");
			}
			else
			{
				QueryString.append(" and b.adt_status between '01' and '08'   ");
			}
		}
	}
	if(!attend_practId.equals(""))
	{
		QueryString.append(" and  B.ATTEND_PRACTITIONER_ID = ? ");
	}
	if(!speciality.equals(""))
	{
		QueryString.append(" and B.SPECIALTY_CODE = ? ");
	}
	 if(!fromDate.equals("")&&(!toDate.equals("")))
	{
		QueryString.append( "and ((TO_DATE(?,'DD/MM/YYYY') between trunc(A.BEGIN_DATE_TIME) and nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))) or (TO_DATE(?,'DD/MM/YYYY') between trunc(A.BEGIN_DATE_TIME) and nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))) or (trunc(A.BEGIN_DATE_TIME) between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY')))");

	}
	/*Below null condition check for from and to date is commented by Archana on 6/4/2010  for IN021572 as now it is made mandatory in criteria page*/
	/*else if(!fromDate.equals("") && (toDate.equals("")))
	{
		QueryString.append(" and ( A.BEGIN_DATE_TIME >= to_date( ?, 'DD/MM/YYYY' ) or TO_DATE(?,'DD/MM/YYYY') between trunc(A.BEGIN_DATE_TIME) and nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))  )");
	}
	else if(fromDate.equals("") && !toDate.equals(""))
	{
		QueryString.append(" and ( nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))<= to_date( ?,'DD/MM/YYYY' ) OR to_date( ?,'DD/MM/YYYY' ) BETWEEN TRUNC(A.BEGIN_DATE_TIME)  AND nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy')))  ");
	}*/

	//new qry ends..

	WhereClause.append(" PHYS_PROV_ID = ? and status IS NULL  AND sysdate between BEGIN_DATE_TIME AND nvl(END_DATE_TIME,sysdate) ");
	/*if(WhereClause.length() > 0) WhereClause.delete(0,WhereClause.length());*/
	if( encounterType.equals("OP") || encounterType.equals("IP") || encounterType.equals("DC") || encounterType.equals("EM")) 
	{
		WhereClause.append(" and patient_class= ?  ");
	}
	if(!(relationshipCode.equals("ALL") ))
	{
		WhereClause.append("and PHYS_PROV_RELN_ID=?  ");
	}	
	WhereClause.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");
	
	QueryString.append("AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(a.practitioner_id,a.patient_id,a.facility_id)");  //32902

	//QueryString.append(WhereClause.toString());
	String desc="";
	if(reOrder.equals("2"))
	{
		desc=" desc";
	}
	if(orderBy.equals("PC"))
	{
		QueryString.append(" Order By episode_type_desc"+desc);
	}
	else if(orderBy.equals("LOC"))
	{
		QueryString.append(" Order By LOCAN_NAME "+desc);
	}
	else if(orderBy.equals("PN"))
	{
		QueryString.append(" Order By PATIENT_NAME"+desc);
	}
	else if(orderBy.equals("SAP"))
	{
		QueryString.append(" Order By splty_name"+desc);
	}
	else if(orderBy.equals("DOB"))
	{
		QueryString.append(" Order By DATE_OF_BIRTH "+desc);
		//to_date(dob,'dd/mm/yyyy')"+desc;
	}
	else if(orderBy.equals("AGE"))
	{
		if(reOrder.equals("1"))
		{
			QueryString.append(" Order By DATE_OF_BIRTH");
		}
		else
			QueryString.append(" Order By DATE_OF_BIRTH desc");
	}
	else if(orderBy.equals("SEX"))
	{
		QueryString.append(" Order By SEX"+desc);
	}
	else if(orderBy.equals("PID"))
	{
		QueryString.append(" Order By patient_id"+desc);
	}
	else if(orderBy.equals("REL"))
	{
		QueryString.append(" Order By PHYS_PROV_RELN_NAME"+desc);
	}
	else if(orderBy.equals("RELT"))
	{
		QueryString.append(" Order By RELATIONSHIP_TYPE"+desc);
	}
	else if(orderBy.equals("RID"))
	{
		QueryString.append(" Order By referral_id"+desc);
	}
	else if(orderBy.equals("AP"))
	{
		QueryString.append(" Order By ACTUAL_PHYSICIAN_ID"+desc);
	}
	else if(orderBy.equals("MS"))
	{
		QueryString.append(" Order By splty_name"+desc);
	}
	else if(orderBy.equals("AT"))
	{
		QueryString.append(" Order By appt_time"+desc);
	}
	else if(orderBy.equals("VT"))
	{
		QueryString.append(" Order By visit_type"+desc);
	}
	else if(orderBy.equals("QN"))
	{
		QueryString.append(" Order By lpad(queue_num,6,0)"+desc);
	}
	else if(orderBy.equals("AD"))
	{
		QueryString.append(" Order By VISIT_ADM_DATE_TIME "+desc);
	}
	else if(orderBy.equals("SD"))
	{
		QueryString.append(" Order By BEGIN_DATE_TIME"+desc);
	}
	else if(orderBy.equals("ED"))
	{
		QueryString.append(" Order By END_DATE_TIME"+desc);
	}
	else if(orderBy.equals("PR"))
	{
		QueryString.append(" Order By PHY_PROV_NAME"+desc);
	}
	else if(orderBy.equals("DD"))
	{
		QueryString.append(" Order By DISCHARGE_DATE_TIME"+desc);
	}
	else if(orderBy.equals("IQS"))
	{
		//QueryString.append(" Order By queue_status "+desc);
	}
	else if(groupByEpisode.equals("N") && groupByReln.equals("N"))
	{
		if (sortOrder.equals("v"))
			QueryString.append(" Order By orderbydate");
		else if(sortOrder.equals("p"))
			QueryString.append(" Order By Patient_Name");
	}
	else
	{
		if (sortOrder.equals("v"))
			QueryString.append(" Order By Episode_Type desc , phys_prov_reln_name,orderbydate,patient_name");
		else if(sortOrder.equals("p"))
			QueryString.append(" Order By Episode_Type desc , phys_prov_reln_name,Patient_Name");
	}
	//end of query construction
	out.println("<form name='PatCriteriaFrm' id='PatCriteriaFrm' action='OpenChartWrapper.jsp' method = 'post' target='messageFrame'>");
	%>
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
		<td class='white' width='90%'></td> 
		<td nowrap  width='5%' align='right' id='previous' ></td>
		<td nowrap  width='5%' align='right' id='next' ></td>
		</tr>
	</table>
	<%
	out.println("<table id='PatCriteriaTbl' width='100%'class='grid'>");
%>

<!------------------------ Changes for Prevoius Next Functionality----------->
	<input type="hidden" name="locationType1" id="locationType1" value="<%=encounterType%>">
	<input type="hidden" name="relationshipCode1" id="relationshipCode1" value="<%=relationshipCode%>">
	<input type="hidden" name="reln_req_yn1" id="reln_req_yn1" value="<%=relnreqyn%>">
	<input type="hidden" name="fromDate1" id="fromDate1" value="<%=fromDate%>">
	<input type="hidden" name="toDate1" id="toDate1" value="<%=toDate%>">
	<input type="hidden" name="groupByReln1" id="groupByReln1" value="<%=groupByReln%>">
	<input type="hidden" name="groupByEpisode1" id="groupByEpisode1" value="<%=groupByEpisode%>">

	<input type="hidden" name="mode" id="mode" value="navigate">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="form" id="form" value="Relation">

    <input type="hidden" name="patientId1" id="patientId1" value="<%=patientId%>">
	<input type="hidden" name="queueId1" id="queueId1" value="<%=queueId%>">
	<input type="hidden" name="sortOrder1" id="sortOrder1" value="<%=sortOrder%>">
	<input type="hidden" name="queueStatus1" id="queueStatus1" value="<%=queueStatus%>">
	<input type="hidden" name="attend_practId1" id="attend_practId1" value="<%=attend_practId%>">
	<input type="hidden" name="speciality1" id="speciality1" value="<%=speciality%>">

<!------------------------ end of change---------------------------------->

<%
	/*----------------Code at for next Previous------*/
	int start   = 0 ;
    int end     = 0 ;
    int iterate = 1;
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
	//IN044157 - Start
	String AEZone5 = "N";
	PreparedStatement stmtAE = con.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
	ResultSet rsAE = null;
	stmtAE.setString(1,facility_id);
	rsAE = stmtAE.executeQuery();
	while(rsAE.next()){
		AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
	}
	if(stmtAE!=null)stmtAE.close();
	if(rsAE!=null)rsAE.close();
	//IN044157 - End
    PreparedStatement stmtPatList = con.prepareStatement(QueryString.toString());
	ResultSet rsPatList = null;
	
	StringBuffer layer = new StringBuffer();
	//String sqlMotherLink = "select a.patient_id pat_id , replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)),'''','') short_name  , to_char(b.date_of_birth, 'dd/mm/yyyy') date_of_birth  , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id and a.MOTHER_PATIENT_ID = ?  and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by TIME_OF_BIRTH ";
	String sqlMotherLink = "select a.patient_id pat_id , replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)),'''','') short_name  , to_char(b.date_of_birth, 'dd/mm/yyyy') date_of_birth  , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id and a.MOTHER_PATIENT_ID = ?  and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc ";//Modified --[IN029180]
	stmtMotherLink = con.prepareStatement(sqlMotherLink);
	try 
	{
		int k=0;
		int i=0;
		String rowclass = "QRYEVEN";
		int count=0, countvar=1;//CRF--1778

		/*stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,clinicianId);
		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,patientId);
		stmtPatList.setString(++count,queueId);
		stmtPatList.setString(++count,clinicianId);
		if( encounterType.equals("OP") || encounterType.equals("IP") || encounterType.equals("DC") || encounterType.equals("EM") ) 
			stmtPatList.setString(++count,encounterType);
		if(!(relationshipCode.equals("ALL") ))
			stmtPatList.setString(++count,relationshipCode);
		stmtPatList.setString(++count,fromDate);
		stmtPatList.setString(++count,toDate);
		stmtPatList.setString(++count,fromDate);
		stmtPatList.setString(++count,toDate); */

		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,clinicianId);
		//new shaiju
		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,locale);
			// new shaiju

		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,clinicianId);
	   if (!relationshipCode.equals(""))	 
			stmtPatList.setString(++count,relationshipCode);
	   if (!encounterType.equals(""))
			stmtPatList.setString(++count,encounterType);
	   if (!patientId.equals(""))
		    stmtPatList.setString(++count,patientId);
	     
       if (encounterType.equals("OP"))
		{
			if(!visitType.equals(""))
			{
				stmtPatList.setString(++count,visitType);
			}

		}

		if(!attend_practId.equals(""))
		{
			stmtPatList.setString(++count,attend_practId);
		}
		if(!speciality.equals(""))
		{
			stmtPatList.setString(++count,speciality);
		}
		if(!fromDate.equals("")&&(!toDate.equals("")))
	    {
			stmtPatList.setString(++count,fromDate);
			stmtPatList.setString(++count,toDate);
			stmtPatList.setString(++count,fromDate);
			stmtPatList.setString(++count,toDate);
	   }
	   /*Below null condition check for from and to date is commented by Archana on 6/4/2010  for IN021572 as now it is made mandatory in criteria page*/
	   /*else if(!fromDate.equals("") && (toDate.equals("")))
	   {
			stmtPatList.setString(++count,fromDate);
			stmtPatList.setString(++count,fromDate);
	   }
       else if(fromDate.equals("") && !toDate.equals(""))
	   {
		   stmtPatList.setString(++count,toDate);
		   stmtPatList.setString(++count,toDate);
		}*/

		rsPatList = stmtPatList.executeQuery();
		
		while(rsPatList.next())
			maxNoRecords += 1;
		if(maxNoRecords == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.RelnResultTitle.location.href='../../eCommon/html/blank.html'</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCommon/html/blank.html'</script>");
		}

		if(rsPatList!=null)rsPatList.close();
		if(isScroll)
		{%>
			<Script>
				top.content.workAreaFrame.colorRefframe.document.getElementById('previous').innerHTML = "";
				top.content.workAreaFrame.colorRefframe.document.getElementById('next').innerHTML = ""
			</Script>
			<%if ( !(start <= 1) )
			{%>
				<Script>
				if(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById('previous')){
					top.content.workAreaFrame.colorRefframe.document.getElementById('previous').innerHTML ="<INPUT TYPE='button' class='button' name='prev' id='prev' onClick=navigate('<%=(start-11)%>','<%=(end-11)%>') title='Previous' value='  \<  ' >";}
				else
					{
					document.getElementById('previous').innerHTML = "<a class='gridLink' href=`javascript:onClick=navigate('<%=(start-11)%>','<%=(end-11)%>')`title='Previous' value=' Previous  ' ><%=prev%></a>";
					}
				</Script>
			<%} 
			if ( !( (start+11) > maxNoRecords ) )
			{%>
				<Script>
				if(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.next)
					{
					top.content.workAreaFrame.colorRefframe.document.getElementById('next').innerHTML = "<INPUT TYPE='button' class='button' name='nex' id='nex'  onClick=navigate('<%=(start+11)%>','<%=(end+11)%>') title='Next' value='  \>  ' >";
					}
				else{
					document.getElementById('next').innerHTML = "<a class='gridLink' href=`javascript:onClick=navigate('<%=(start+11)%>','<%=(end+11)%>')`title='Next' value=' next  ' ><%=next%></a>";
					}
				</Script>
			<%}
		}
		else
		{%>
			<script>
				//if(top.content.workAreaFrame.colorRefframe.document.getElementById('next'))
					top.content.workAreaFrame.colorRefframe.document.getElementById('next').innerHTML="&nbsp;";
				//if(top.content.workAreaFrame.colorRefframe.document.getElementById('previous'))
					top.content.workAreaFrame.colorRefframe.document.getElementById('previous').innerHTML="&nbsp;";					
			</script>
		<%}
		rsPatList = stmtPatList.executeQuery();
		
		if(isScroll)
		{
			if ( start != 1 )
			{
				for( int j=1; j<start;j++ )
				{
					rsPatList.next() ;
					iterate++;
				}
			}
		}//end of isScroll%>
		<input type="hidden" name="maxNoRecords" id="maxNoRecords"value="<%=maxNoRecords%>">
		<%
		if(groupByEpisode.equals("N") && groupByReln.equals("N"))
		{
			boolean header=false;

			while(rsPatList.next() && iterate <=end ) 
			{
				iterate++ ;
				if(header==false) 
				{
					%>
					<tr><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheader' nowrap><a style='color:white'><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a  id='a01'   href="javascript:callForOrderBy('PC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a1'   href="javascript:callForOrderBy('REL');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a2'   href="javascript:callForOrderBy('RELT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.RelationshipType.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a3'   href="javascript:callForOrderBy('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td><!--54073-->
					<%
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)){%>
						<td class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></td>
					<%}
					//37866 End.
					%>	
					<td class='columnheadercenter' nowrap><a id='a5'   href="javascript:callForOrderBy('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a6'   href="javascript:callForOrderBy('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a7'   href="javascript:callForOrderBy('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a8'   href="javascript:callForOrderBy('AD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a81'   href="javascript:callForOrderBy('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.VisitAdmCloseDate.label" bundle="${ca_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a9'   href="javascript:callForOrderBy('PR');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a10'   href="javascript:callForOrderBy('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a11'   href="javascript:callForOrderBy('SD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a12'   href="javascript:callForOrderBy('ED');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a4'   href="javascript:callForOrderBy('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a13'   href="javascript:callForOrderBy('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td></tr>
					<%
					out.println("<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
					header=true;
					i++;
				}
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";

				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				
				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");


				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/
				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}

				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{	
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";
				}	
				//IN044157 - end	
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				//disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");

				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date.equals(""))
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);
				// color coding ends
				if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						//String sqlMotherLink_query1 = sqlMotherLink + "  ";
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						String strMotBirthDate = "";
						while(rsMotherLink.next())
						{
							strMotBirthDate = rsMotherLink.getString("date_of_birth");

							if(strMotBirthDate == null || strMotBirthDate.equals("") )
								strMotBirthDate = "&nbsp;";

							if(!strMotBirthDate.equals("&nbsp;") )
								strMotBirthDate = com.ehis.util.DateUtils.convertDate(strMotBirthDate,"DMY","en",locale);

							layer.append( "<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+strMotBirthDate+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
						}
						if (rsMotherLink != null) rsMotherLink.close();
						//if(stmtMotherLink != null ) stmtMotherLink.close();		
					}
				}
			
				Episode_Type_Desc=rsPatList.getString("EPISODE_TYPE_DESC");
				
				if(Episode_Type_Desc.equals("OP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("IP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("EM"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("DC"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("XT"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
				}
				else
				{
					Episode_Type_Desc=" ";
				}

				strGender=rsPatList.getString("SEX");
				
				if(strGender.equals("M"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					strGender="M";
				}
				else if(strGender.equals("F"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					strGender="F";
				}
				else
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					strGender="U";
				}

				Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");

				if(Relationship_Type.equals("E"))
				{
					Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
				}
				if(Relationship_Type.equals("L"))
				{
					Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
				}

				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate			=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
				   {
					 if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				   }

				  //out.println("strEndDate"+strEndDate);
				  // out.println("fromDate1"+fromDate);
				  
			
				out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
				//IN044157 - Start
				out.println("<tr>");
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+ counts++ +"</td><td class='"+rowclass+"' nowrap><font size=1>"+Episode_Type_Desc+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("PHYS_PROV_RELN_NAME")==null?"":rsPatList.getString("PHYS_PROV_RELN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+Relationship_Type+"</font></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td>");//54073
				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(locn_type) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
					out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
				}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
					out.println("<td class='"+rowclass+"'  nowrap>&nbsp;</td>");
				}
				//37866 End.
				out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>"); 
				if(rsPatList.getString("referral_id")!=null){
				out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></font></td></tr>");
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' ><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></font></td></tr>");

				}
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");				
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");				
				out.println("</script>");
				
				 // start.32902  
				%>
				<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'>
				<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'>
				<%
				  // end. 32902  

				i++;
				k++;
			}
		}
		else if(groupByEpisode.equals("Y") && groupByReln.equals("N"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			boolean header = false;

			while(rsPatList.next() && iterate <=end ) 
			{
				iterate++ ;
				rowclass = "gridData";
				//records_yn=true;
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");


				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End	
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				// color coding ends
//				disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);

				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						if(header==false) 
						{
							%>
								<tr><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheader' nowrap><a style='color:white'><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a01'   href="javascript:callForOrderBy('REL');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a1'   href="javascript:callForOrderBy('RELT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.RelationshipType.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a2'   href="javascript:callForOrderBy('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td><!--54073-->
								<%
								//37866 Start.
								if(isVirtualConsSiteSpec && "OP".equals(locn_type)){%>
									<td class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></td>
								<%}
								//37866 End.
								%>
								<td class='columnheadercenter' nowrap><a id='a4'   href="javascript:callForOrderBy('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a5'   href="javascript:callForOrderBy('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a6'   href="javascript:callForOrderBy('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a7'   href="javascript:callForOrderBy('AD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></td>
								<% if(encounterType.equals("OP")){%>
								<td class='columnheadercenter' nowrap><a id='a73'   href="javascript:callForOrderBy('VT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></a></td>
								<%}%>
								<td class='columnheadercenter' nowrap><a id='a71' href="javascript:callForOrderBy('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a8'   href="javascript:callForOrderBy('PR');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a9'   href="javascript:callForOrderBy('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a10'   href="javascript:callForOrderBy('SD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a11'   href="javascript:callForOrderBy('ED');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a3'   href="javascript:callForOrderBy('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a12'   href="javascript:callForOrderBy('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td></tr>
								<%
							out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
							header=true;
						}
						i++;
						i++;
						outpHeader=true;
					}
					
					Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");
					
					if(Relationship_Type.equals("E"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					}
					if(Relationship_Type.equals("L"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
					}

					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}


				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902					
	            accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902

				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("PHYS_PROV_RELN_NAME")==null?"":rsPatList.getString("PHYS_PROV_RELN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+Relationship_Type+"</font></td><td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></font></td>");//54073
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
						out.println("<td class='"+rowclass+"'  nowrap>&nbsp;</td>");
					}
					//37866 End.
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate +"</font></td>");
					
					if(encounterType.equals("OP")){
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("visit_type") +"</font></td>");
					}
						
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font>&nbsp;&nbsp;&nbsp;</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font  color="+decesedColor+"><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{
						out.println("<td class='"+rowclass+"' nowrap><font  color="+decesedColor+"><a  class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						String strMotBirthDate = "";
						while(rsMotherLink.next())
						{
							strMotBirthDate = rsMotherLink.getString("date_of_birth");

							if(strMotBirthDate == null || strMotBirthDate.equals("") )
								strMotBirthDate = "&nbsp;";

							if(!strMotBirthDate.equals("&nbsp;") )
								strMotBirthDate = com.ehis.util.DateUtils.convertDate(strMotBirthDate,"DMY","en",locale);

							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+strMotBirthDate+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
						}
					
							if (rsMotherLink != null) rsMotherLink.close();
							//if(stmtMotherLink != null ) stmtMotherLink.close();
					}
					if(inpHeader==false)
					{
						if(header==false) 
						{
							%>
							<tr><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheader' nowrap><a style='color:white'><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a01'   href="javascript:callForOrderBy('REL');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a1'   href="javascript:callForOrderBy('RELT');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.RelationshipType.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a2'   href="javascript:callForOrderBy('PN');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a4'   href="javascript:callForOrderBy('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a5'   href="javascript:callForOrderBy('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a6'   href="javascript:callForOrderBy('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a7'   href="javascript:callForOrderBy('AD');" onclick='changeColor(this);' style='color:pink'><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a72' href="javascript:callForOrderBy('IQS');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a71' href="javascript:callForOrderBy('DD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a8'   href="javascript:callForOrderBy('PR');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a9'   href="javascript:callForOrderBy('LOC');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a10'   href="javascript:callForOrderBy('SD');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a11'   href="javascript:callForOrderBy('ED');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a3'   href="javascript:callForOrderBy('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td><td class='columnheadercenter' nowrap><a id='a12'   href="javascript:callForOrderBy('RID');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td></tr><!--54073-->
							<%
							out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
							header=true;
						}
						i++;
						i++;
						inpHeader=true;
					}
				
					Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");

					if(Relationship_Type.equals("E"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					}
					if(Relationship_Type.equals("L"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
					}
					
					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}
				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902					
	            accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }
					out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("PHYS_PROV_RELN_NAME")==null?"":rsPatList.getString("PHYS_PROV_RELN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+Relationship_Type+"</font></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink'  href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td> ");//54073
					
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{	
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");

					}
				}
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");
				out.println("</script>");
				 // start.32902  
				%>
				<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'>
				<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'>
				<%
				  // end. 32902  
				i++;
				k++;
			}
		}  
		else if(groupByEpisode.equals("N") && groupByReln.equals("Y"))
		{
			boolean header = false;
			String currLocn="";
			while(rsPatList.next() && iterate <=end ) 
			{
				iterate++ ;
				//records_yn=true;\
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");


				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					//rowclass = "DECEASED1";
					rowclass = "gridData";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					//rowclass = "GRAY";
					rowclass = "gridData";
					decesedColor="";
				}else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				// color coding ends
				//disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);

				layer = new StringBuffer();
				if(noofchildren > 0)
				{
					stmtMotherLink.setString(1,locale);
					stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
					stmtMotherLink.setString(3,facility_id);
					stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
					rsMotherLink = stmtMotherLink.executeQuery(sqlMotherLink);
					while(rsMotherLink.next())
					{
						if(locale.equals("en"))
	                    {
		                 dateofbirth1=rsMotherLink.getString("date_of_birth");
	                    }
	                   else
	                  {
		               dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                  }
						layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+dateofbirth1+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
					}
				
						if (rsMotherLink != null) rsMotherLink.close();
						//if(stmtMotherLink != null ) stmtMotherLink.close();
				}
				if(header==false) 
				{
					%>
					
					<tr><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheadercenter' width='16px'>&nbsp;</td><td class='columnheadercenter' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<%
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)){%>
						<td class='columnheader'   nowrap><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></td>
					<%}
					//37866 End.
					%>
					<td class='columnheadercenter' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td><td class='columnheadercenter' nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td></tr>
						<%
					out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
					header=true;
					i++;
				}
				if(!currLocn.equals(rsPatList.getString("PHYS_PROV_RELN_NAME"))) 
				{
					Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");

					if(Relationship_Type.equals("E"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					}
					if(Relationship_Type.equals("L"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
					}
					
					out.println("<tr><td colspan='14' class='CAGROUP' ><font size='1'><B>"+rsPatList.getString("PHYS_PROV_RELN_NAME")+"/"+Relationship_Type+"</td></tr></font>");
					i++;
					currLocn = rsPatList.getString("PHYS_PROV_RELN_NAME");
				}
			
				Episode_Type_Desc=rsPatList.getString("EPISODE_TYPE_DESC");

				if(Episode_Type_Desc.equals("OP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("IP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("EM"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("DC"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				else
				{
					Episode_Type_Desc=" ";
				}
				
				strGender=rsPatList.getString("SEX");
				
				if(strGender.equals("M"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					strGender="M";
				}
				else if(strGender.equals("F"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					strGender="F";
				}
				else
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					strGender="U";
				}
				
				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");

				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
				{
					  if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				}
				out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
				//IN044157 - Start
				out.println("<tr>");
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class='"+rowclass+"' nowrap><font size=1>"+Episode_Type_Desc+"</font></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td>");
				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(locn_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
					out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
				}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
					out.println("<td class='"+rowclass+"'  nowrap>&nbsp;</td>");
				}
				//37866 End.
				out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");
				if(rsPatList.getString("REFERRAL_ID")!= null){
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'> <font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' > <font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
				}

				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");
				out.println("</script>");
				i++;
				k++;
			}
		}
		else if(groupByEpisode.equals("Y") && groupByReln.equals("Y"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			//boolean header = false;
			String currLocn="";
			while(rsPatList.next())
			{
				iterate++ ;
				//records_yn=true;
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
				String practitioner_id=""; //32902
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					//rowclass = "DECEASED1";
					rowclass = "gridData";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					//rowclass = "GRAY";
					rowclass = "gridData";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R"))  
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				// color coding ends
				//disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);
				
				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						i++;
                        i++;
					}
					if(!currLocn.equals(rsPatList.getString("PHYS_PROV_RELN_NAME"))) 
					{
						i++;
						currLocn=rsPatList.getString("PHYS_PROV_RELN_NAME");
					}

					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}

				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902				
                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902				 
				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }

				pat_id1= rsPatList.getString("PATIENT_ID");
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ countvar++ +"</td><td class='"+rowclass+"' nowrap><font size=1><a class='gridLink'  href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td>");
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
						out.println("<td class='"+rowclass+"' width=85 nowrap></td>");
					}
					//37866 End.
					out.println("<td class='"+rowclass+"'&nbsp;&nbsp;nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' &nbsp;nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td>");
					if(encounterType.equals("OP")){
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("visit_type")+"</font></td>");
					}
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font>&nbsp;&nbsp;&nbsp;</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td> ");
					
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' ><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					
					  // start.32902  
					%>
					<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'>
					<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'>
					<%
					  // end. 32902  
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						String strMotBirthDate	=	"";
						while(rsMotherLink.next())
						{
							strMotBirthDate = rsMotherLink.getString("date_of_birth");

							if(strMotBirthDate == null || strMotBirthDate.equals("") )
								strMotBirthDate = "&nbsp;";

							if(!strMotBirthDate.equals("&nbsp;") )
								strMotBirthDate = com.ehis.util.DateUtils.convertDate(strMotBirthDate,"DMY","en",locale);

							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+strMotBirthDate+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
						}
					}
					if(inpHeader==false)
					{
						out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById(\"asOn\").innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						i++;
						i++;
					}
					if(!currLocn.equals(rsPatList.getString("PHYS_PROV_RELN_NAME"))) 
					{
						i++;
						currLocn = rsPatList.getString("PHYS_PROV_RELN_NAME");
					}

					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}
				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902

				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }
					out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td> <td class=gridData nowrap>&nbsp;"+ countvar++ +"</td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+rsPatList.getString("LOCAN_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+strBirthDate+"</font></td>");//CRF 1778
					//out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td> <td class=gridData nowrap>&nbsp;"+ countvar++ +"</td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("LOCAN_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");//CRF 1778
					//out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("LOCAN_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{
						out.println("<td class='"+rowclass+"'  width=90 nowrap><font size=1><a class='gridLink' ><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null?"&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
				}
				
				//32902 start
%>
<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'>
<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'>
<%
			//32902 end
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");
				out.println("</script>");
				i++;
				k++;
			}
			if(isIP)
			{
				%>
				
				<tr id='titleHdrIP' style='visibility:hidden'><td class='columnheader' nowrap width='16px'>&nbsp;</td><td class='columnheader' nowrap width='16px'>&nbsp;</td><td class='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td></tr>
				<%
				inpHeader=true;
			}
			if(isOP)
			{
				%>
				<tr id='titleHdrIP' style='visibility:hidden'><td class='columnheader' nowrap width='16px'>&nbsp;</td><td class='columnheader' nowrap width='16px'>&nbsp;</td><td class='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<%
				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(locn_type)){%>
					<td class='columnheader'   nowrap ><a style='color:white'   ><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></td>
				<%}
				//37866 End.
				%>
				<td class='columnheader' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td><td class='columnheader' nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td></tr>
					<%
				outpHeader=true;
			}
			//pat_id1= rsPatList.getString("PATIENT_ID");
		}
		if(rsPatList != null) rsPatList.close();
		if(stmtPatList!=null) stmtPatList.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception "+e.toString());//COMMON-ICN-0181
		e.printStackTrace(System.err);
		System.out.println(e.toString());
	}
	%>
        </table>
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="episode_visit_id" id="episode_visit_id" value="">
		<input type="hidden" name="episode_id" id="episode_id" value="">
		<input type="hidden" name="location_code" id="location_code" value="">
		<input type="hidden" name="location_type" id="location_type" value="">
		<input type="hidden" name="bed_num" id="bed_num" value="">
		<input type="hidden" name="room_num" id="room_num" value="">
		<input type="hidden" name="episode_type" id="episode_type" value="">
		<input type="hidden" name="discharge_date" id="discharge_date" value="">
		<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="">
		<input type="hidden" name="episode_Status" id="episode_Status" value="">
		<input type="hidden" name="sex" id="sex" value="">
		<input type="hidden" name="dob" id="dob" value="">
		<input type="hidden" name="age" id="age" value="">
		<input type="hidden" name="pline" id="pline" value="">
		<input type="hidden" name="reln_req_yn" id="reln_req_yn" value="<%=relnreqyn%>">
		<input type="hidden" name="insert_op" id="insert_op" value="N">
		<input type="hidden" name="patient_class" id="patient_class" value="">
        <input type="hidden" name="medical_team" id="medical_team" value="">
        <input type="hidden" name="encounter_id" id="encounter_id" value="">

        </form>

		<div id='motherLink' style='position:absolute; visibility:hidden;overflow:overflow'></div>
		<%if(floatTitle){%>
			<script>
			if('<%=leftScrolling%>'!='')
			{
				document.body.scrollLeft='<%=leftScrolling%>';
			}
			if(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById("TitleTab") != null){
				//top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById("TitleTab").width =	document.getElementById("PatCriteriaTbl").offsetWidth;
				if(document.getElementById("PatCriteriaTbl").rows[0] != null){
					for (j=0; j < document.getElementById("PatCriteriaTbl").rows[0].cells.length; j++) {
						var wid=document.getElementById("PatCriteriaTbl").rows[0].cells[j].offsetWidth+"px";
						//alert(wid);
						if(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById("TitleTab").rows[0].cells[j] != null){
							top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById("TitleTab").rows[0].cells[j].style.width=wid;
						}
					}
				}
				//document.getElementById("PatCriteriaTbl").deleteRow(0);
			}
		</script>
			<%}else if(!anchorID.equals("")){%>

		<script>
			if('<%=leftScrolling%>'!='')
			{
				document.body.scrollLeft='<%=leftScrolling%>';
			}
			if('<%=anchorID%>'!='')
			{
				//*** added to make all anchors white before making the selcted one pink
				for(i=0;i<document.anchors.length;i++)
				{
					document.anchors(i).style.color='white';

				}
				//***
				if('<%=reOrder%>'=='1')
				{
					document.getElementById('PatCriteriaTbl').all.<%=anchorID%>.style.color='pink';
				}
				else if('<%=reOrder%>'=='2')
					document.getElementById('PatCriteriaTbl').all.<%=anchorID%>.style.color='yellow';
			}
		</script>
			<%}%>
			<script>
				parent.parent.PatCriteriaFr.document.getElementById('searchID').disabled = false;
			</script>
    </body>
</html>


	<%}
	catch ( Exception e) 
	{
		
		System.out.println(e);
		e.printStackTrace();
		
	}
	finally 
	{		
		//if (rsMotherLink != null) rsMotherLink.close();
		if(stmtMotherLink != null ) stmtMotherLink.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}%>

