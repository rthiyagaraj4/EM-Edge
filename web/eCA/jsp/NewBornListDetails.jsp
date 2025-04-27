<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History			Name			Description
--------------------------------------------------------------------------------------------------------------
?				100						?           created
18/04/2012		IN030318				Ramesh G		This age of the newborn is displayed in the newborn list in location list as well as in the patient banner in patient?s chart.	
24/04/2012		IN032435,IN032437		Ramesh G		The age of new born is displayed as Null.							
13/07/2012    	IN032364       			Nijitha S     Alignment is not proper in New Born List.					
20/08/2012		IN029180		        Chowminya G		 The system is not running by sequence number of newborn.
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1	
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
11/08/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
---------------------------------------------------------------------------------------------------------------

*/ %> 
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
   <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

   <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- ****  Modified by kishor kumar n on 02/12/2008 for crf0387 applied new css grid. **** -->
		
		
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language='javascript' src='../../eCA/js/NewBornList.js'></script>
   <script language='javascript' src='../../eCA/js/CAMenu.js'></script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>
   <script language='javascript' src='../../eCA/js/CACommon.js'></script> <!-- 32902 -->
   <style>
   thead
		{
			position: sticky;
			top: 0px; 
			z-index: 1;
		}
   </style>
   </head>
<body   onMouseDown="CodeArrest()" onScroll='moveFrame()' onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con =null;
PreparedStatement pstmt = null;
ResultSet rsPatList=null;
PreparedStatement pstmt1 = null;//Added for IN072994
ResultSet resultSet=null;//Added for IN072994


Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");

//32902 start
String restPatientYN	=	"";
String ca_bean_id 						= "@CACommonGetPatientDtlBean";
String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
int accessRightsViewPatient=0;
//32902 end
try
{
con = ConnectionManager.getConnection(request);
/* criteria parameters */
String admit=request.getParameter("admit")==null?"":request.getParameter("admit");
String health=request.getParameter("health")==null?"":request.getParameter("health");
String decease=request.getParameter("decease")==null?"":request.getParameter("decease");
String newbornid=request.getParameter("newbornid")==null?"":request.getParameter("newbornid");
String motherid=request.getParameter("motherid")==null?"":request.getParameter("motherid");
String newbornenc=request.getParameter("newbornenc")==null?"":request.getParameter("newbornenc");
String locationCode=request.getParameter("locationCode")==null?"":request.getParameter("locationCode");
String clinicianId =(String)session.getValue("ca_practitioner_id");
String facility_id=(String)session.getValue("facility_id");
accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902

if(facility_id == null) facility_id="";

String orderBy = request.getParameter("ID")==null?"":request.getParameter("ID");
String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
String relnreqyn= request.getParameter("reln_req_yn")==null?"":request.getParameter("reln_req_yn");
StringBuffer QueryString=new StringBuffer();
String sex="";
String bar_code_scan_site_YN =request.getParameter("bar_code_scan_site_YN")==null?"":request.getParameter("bar_code_scan_site_YN");//Added for IN072994

int i=1;

//QueryString.append(" select A.PATIENT_ID,C.PATIENT_NAME,TO_CHAR(A.TIME_OF_BIRTH,'DD/MM/YYYY HH24:MI') DOB,decode(C.SEX,'M','Male','F','Female','Unknown') sex ,	(select D.SHORT_DESC from ip_nursing_unit d where D.FACILITY_ID =B.FACILITY_ID AND D.NURSING_UNIT_CODE=B.PAT_CURR_LOCN_CODE) LOCATION_DESC,BABY_ENC.BED_NUM BASINET_NO,(SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID=A.MOTHER_PATIENT_ID) MOTHER_NAME,baby_enc.encounter_id, baby_enc.patient_class,(SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=B.FACILITY_ID AND NURSING_UNIT_CODE=BABY_ENC.NURSING_UNIT_CODE) BABY_LOCN,BABY_ENC.ROOM_NUM BABY_ROOM_NUM,CASE WHEN baby_enc.encounter_id IS NOT NULL THEN BABY_ENC.BED_NUM  ELSE (SELECT BED_NO FROM IP_NURSING_UNIT_BED WHERE /*FACILITY_ID=b.facility_id AND NURSING_UNIT_CODE=B.NURSING_UNIT_CODE AND MAIN_BED_NO=B.BED_NUM AND*/ OCCUPYING_PATIENT_ID = A.patient_id AND ROWNUM=1) END BABY_BED_NUM ,(SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=B.FACILITY_ID AND NURSING_UNIT_CODE=B.NURSING_UNIT_CODE) MOTHER_LOCN,B.ROOM_NUM MOTHER_ROOM_NUM,B.BED_NUM MOTHER_BED_NUM,GET_AGE(A.TIME_OF_BIRTH) AGE,CA_GET_PATIENT_CURR_STATUS(a.ENCOUNTER_FACILITY_ID,a.patient_id,baby_enc.encounter_id,NVL2(baby_enc.encounter_id,'IP','XT'),?) status, b.patient_id mother_patient_id, to_char(b.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') mother_adm_date,(select get_age(date_of_birth) from mp_patient where patient_id=b.patient_id) mother_age from ip_open_encounter b ,MP_BIRTH_REGISTER A ,MP_PATIENT C ,(select patient_id,encounter_id,patient_class,NURSING_UNIT_CODE,ROOM_NUM,BED_NUM from ip_open_encounter where adt_status in ('01','08','09')) baby_enc where  b.facility_id = a.ENCOUNTER_FACILITY_ID and b.encounter_id = a.MOTHER_ENCOUNTER_ID and c.patient_id = a.patient_id   and baby_enc.patient_id(+)=a.patient_id  and a.ENCOUNTER_FACILITY_ID=? ");

//QueryString.append(" select A.PATIENT_ID,replace(decode(?,'en',C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME,TO_CHAR(A.TIME_OF_BIRTH,'DD/MM/YYYY HH24:MI')DOB,sex,IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,b.pat_curr_locn_code,?,'1') LOCATION_DESC,BABY_ENC.BED_NUM BASINET_NO,(SELECT replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') FROM MP_PATIENT WHERE PATIENT_ID=A.MOTHER_PATIENT_ID) MOTHER_NAME,baby_enc.encounter_id,baby_enc.patient_class,IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,BABY_ENC.NURSING_UNIT_CODE,?,'1') BABY_LOCN,BABY_ENC.ROOM_NUM BABY_ROOM_NUM,CASE WHEN baby_enc.encounter_id IS NOT NULL THEN BABY_ENC.BED_NUM ELSE(SELECT BED_NO FROM IP_NURSING_UNIT_BED WHERE OCCUPYING_PATIENT_ID = A.patient_id AND ROWNUM=1) END BABY_BED_NUM ,IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,B.NURSING_UNIT_CODE,?,'1')MOTHER_LOCN,B.ROOM_NUM MOTHER_ROOM_NUM,B.BED_NUM MOTHER_BED_NUM,GET_AGE(A.TIME_OF_BIRTH) AGE,CA_GET_PATIENT_CURR_STATUS(a.ENCOUNTER_FACILITY_ID,a.patient_id,baby_enc.encounter_id,NVL2(baby_enc.encounter_id,'IP','XT'),?) status, b.patient_id mother_patient_id, to_char(b.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') mother_adm_date,(select get_age(date_of_birth) from mp_patient where patient_id=b.patient_id) mother_age from ip_open_encounter b ,MP_BIRTH_REGISTER A ,MP_PATIENT C ,(select patient_id,encounter_id,patient_class,NURSING_UNIT_CODE,ROOM_NUM,BED_NUM from ip_open_encounter where adt_status in ('01','08','09')) baby_enc where  /* a.OUTCOME='L' and*/  b.facility_id = a.ENCOUNTER_FACILITY_ID and b.encounter_id = a.MOTHER_ENCOUNTER_ID and c.patient_id = a.patient_id   and baby_enc.patient_id(+)=a.patient_id  and a.ENCOUNTER_FACILITY_ID=? ");

//[IN030318] QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, get_age (bpi.DATE_OF_BIRTH,nvl(bpi.DECEASED_DATE,sysdate)) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");
// [IN032435] QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, MP_GET_AGE_YMDH(bpi.date_of_birth,bpi.DECEASED_DATE) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");
// [IN032437] QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, nvl(MP_GET_AGE_YMDH(bpi.date_of_birth,bpi.DECEASED_DATE),get_age (bpi.DATE_OF_BIRTH,nvl(bpi.DECEASED_DATE,sysdate))) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");

//QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, CA_GET_AGE_IN_HRS (bpi.date_of_birth,bpi.DECEASED_DATE) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");
QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, CA_GET_AGE_IN_HRS (bpi.date_of_birth,bpi.DECEASED_DATE) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN,bpi.restrict_reinstate_yn  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");

if (!locationCode.equals("*ALL"))
	QueryString.append(" and ( exists ( select 1 from ip_open_encounter where PATIENT_ID=a.patient_id and PAT_CURR_LOCN_CODE=? ) or mei.PAT_CURR_LOCN_CODE=? )") ;

if((admit.equals("N") || health.equals("N") ))
{
    if (admit.equals("Y"))
	{
		if (decease.equals("N"))
			QueryString.append(" and exists (select 1 from ip_open_encounter where patient_id=a.patient_id and adt_status in ('01','08','09') ) and exists (select 1 from ip_open_encounter where patient_id=a.mother_patient_id )");
		else
			QueryString.append(" and (exists (select 1 from ip_open_encounter where patient_id=a.patient_id and adt_status in ('01','08','09') ) and exists (select 1 from ip_open_encounter where patient_id=a.mother_patient_id ) or  bpi.DECEASED_YN ='Y' ) ");
	}
	else
	{
		if(decease.equals("N"))
			QueryString.append(" and not exists (select 1 from ip_open_encounter where patient_id=a.patient_id) ");
		else
			QueryString.append(" and ( not exists (select 1 from ip_open_encounter where patient_id=a.patient_id) or  bpi.DECEASED_YN ='Y' ) ");
	}
}
if(decease.equals("N"))
{
	QueryString.append("and bpi.DECEASED_YN ='N'");
}
else if((admit.equals("N") && health.equals("N") ))
{
	QueryString.append("and  bpi.DECEASED_YN ='Y'");
}

if (!newbornid.equals(""))
	QueryString.append(" and a.patient_id=? ");

if (!motherid.equals(""))
	QueryString.append(" and a.MOTHER_PATIENT_ID=? ");

if (!newbornenc.equals(""))
	QueryString.append("  and bei.encounter_id  =? ");

QueryString.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,bpi.patient_id,mei.facility_id) "); //32902  

if(orderBy.equals("PID"))
{QueryString.append(" order by PATIENT_ID ");}
else if(orderBy.equals("PN"))
{QueryString.append(" order by PATIENT_NAME ");}
else if(orderBy.equals("DOB")||orderBy.equals("AGE"))
{QueryString.append(" order by TIME_OF_BIRTH ");}
else if(orderBy.equals("SEX"))
{QueryString.append(" order by SEX ");}
else if(orderBy.equals("MN"))
{QueryString.append(" order by 7 ");}
else
{QueryString.append(" order by PATIENT_ID ");}//Modified --[IN029180]

if(reOrder.equals("2"))
	QueryString.append(" desc");

out.println("<form name='NewBornForm' id='NewBornForm' action='OpenChartWrapper.jsp' method = 'post' target=messageFrame  OnMouseDown='CodeArrest()' OnKeyDown='disableKeys()'>"); 
%>
<%

int k=0, rowindex =1,r=1; 

String rowclass = "gridData";


pstmt = con.prepareStatement(QueryString.toString());

pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,clinicianId);
pstmt.setString(rowindex++,facility_id);
//pstmt.setString(rowindex++,clinicianId);
//pstmt.setString(rowindex++,facility_id);
if (!locationCode.equals("*ALL"))
{
 pstmt.setString(rowindex++,locationCode);
 pstmt.setString(rowindex++,locationCode);
}
if (!newbornid.equals(""))
	pstmt.setString(rowindex++,newbornid);

if (!motherid.equals(""))
	pstmt.setString(rowindex++,motherid);

if (!newbornenc.equals(""))
	pstmt.setString(rowindex++,newbornenc);
pstmt.setString(rowindex++,clinicianId); //32902

rsPatList = pstmt.executeQuery();


String patientid= "";
String encounterid= "";
String patientclass= "";
String status="";
String relationYn="";
String newbornclass="";
String text="&nbsp;";
String style="";
String deceasedYn = "";
String localeDate = "";
int count=1;//22856

%>
<div id='divDataTitle' style='position:relative'>
<table id='PatCriteriaTb'  width='100%' class='grid'><!--IN032364-->
<%

while(rsPatList.next()) 
{
	if (k % 2 == 0 )
		rowclass = "gridData";
	else
		rowclass = "gridData";

	StringBuffer motherlink=new StringBuffer();	
	String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
	restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902


	patientid = rsPatList.getString("PATIENT_ID")==null?"":rsPatList.getString("PATIENT_ID");
	encounterid = rsPatList.getString("encounter_id")==null?"":rsPatList.getString("encounter_id");
	patientclass = rsPatList.getString("patient_class")==null?"":rsPatList.getString("patient_class");
	status = rsPatList.getString("status")==null?"":rsPatList.getString("status");
	sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
	deceasedYn = rsPatList.getString("DECEASED_YN")==null?"N":rsPatList.getString("DECEASED_YN");
	if(sex.equals("M"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else
		if(sex.equals("F"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

	StringTokenizer st = new StringTokenizer(status,"|");
		
	while (st.hasMoreTokens())
	{
		 st.nextToken(); //emergencyYn =
		 st.nextToken(); //deceasedYn = 
		 st.nextToken(); //n=
		 relationYn = st.nextToken();
	}
	//Adding start for IN072994
	if(bar_code_scan_site_YN.equals("Y") && (!newbornid.equals("") || !motherid.equals(""))){

       pstmt1 = con.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = 'NEW_BORN_LIST' AND PATIENT_CLASS =? ") ;
			pstmt1.setString(1, patientclass.trim());

			resultSet = pstmt1.executeQuery() ;

			if(resultSet.next())
			{ 
				scan_count_required_yn = resultSet.getString("SCAN_REQUIRED_YN")==null?"N":resultSet.getString("SCAN_REQUIRED_YN");
				alert_required_yn      = resultSet.getString("ALERT_REQUIRED_YN")==null?"N":resultSet.getString("ALERT_REQUIRED_YN");
				remarks_required_yn    = resultSet.getString("REMARKS_REQUIRED_YN")==null?"N":resultSet.getString("REMARKS_REQUIRED_YN");
			}
	}
//Adding end for IN072994
	if(relnreqyn.equals("Y"))
	{
		if(relationYn.equals("N"))
			text = "<font size=2><b>*</b></font>";
		else
			text="&nbsp;";
	}

	if(deceasedYn.equals("Y"))
	{
		{newbornclass="CADECEASED"; style="";}
	}
	else
	{
		if(encounterid.equals(""))
			{newbornclass="NEWBORN"; style="style=background:#00FF00";}
		else 
			{newbornclass="DISCHARGED";style="style=background:#0099FF";} 
	}

	if(locale.equals("en"))
		localeDate = rsPatList.getString("DOB") == null ? "" : rsPatList.getString("DOB");
	else
		localeDate = com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMYHM","en",locale);


	%>
		<tr>
			<td width='' nowrap class=<%=rowclass%>>&nbsp;</td>
			<td width='' nowrap <%=style%> class=<%=newbornclass%>><%=text%></td>
			<td width='' nowrap class='gridData'><%=count++ %></td><!-- ML-MMOH-CRF-1778 -->
			<td width='' nowrap class='gridData'><%=patientid%></td>
			<td width='' nowrap class='gridData' onMouseOut="clearLayer()"  onMouseOver="showMotherDetail('<%=r%>',this)">
				
				<a class='gridLink' href="javascript:patOpenChart('<%=patientid%>','<%=encounterid%>','<%=patientclass%>','<%=relationYn%>','<%=relnreqyn%>','<%=r%>')">
				<font size=1><%=(rsPatList.getString("PATIENT_NAME")==null?"&nbsp;":rsPatList.getString("PATIENT_NAME"))%>
				</a>
				<!-- '<%=r%>' added above for IN072994 -->
			</td>
			<td width='' nowrap class=<%=rowclass%> width= >&emsp;
				<font size=1> <%=localeDate%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%> >&emsp;
				<font size=1> <%=rsPatList.getString("AGE")%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%>>&emsp;
				<font size=1> <%=sex%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%> >&emsp;
				<font size=1> <%=(rsPatList.getString("BABY_LOCN")==null?"&nbsp;":rsPatList.getString("BABY_LOCN"))%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%> >&emsp;
				<font size=1> <%=(rsPatList.getString("BABY_ROOM_NUM")==null ?"&nbsp;":rsPatList.getString("BABY_ROOM_NUM"))%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%> >&emsp;
				<font size=1> <font  size=1><%=(rsPatList.getString("BABY_BED_NUM")==null?"&nbsp;":rsPatList.getString("BABY_BED_NUM"))%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%> >&emsp;&emsp;&emsp;
			    <font size=1> <%=rsPatList.getString("MOTHER_NAME")%>
				
			</td>
			<td width='' nowrap class=<%=rowclass%> >&emsp;&emsp;&emsp;
			      <font size=1> <%=(rsPatList.getString("MOTHER_BED_NUM")==null ?"&nbsp;":rsPatList.getString("MOTHER_BED_NUM"))%>
				
					<!-- '&emsp'  above for 22856 -->
			</td>
			</tr>
    	    
			<!-- <tr> 
			<td width='2%' class='<%=rowclass%>'>&nbsp;</td>
			<td width='2%' <%=style%> class='<%=newbornclass%>' ><%=text%></td>
			<td width='10%' class='<%=rowclass%>' >
					<font size=1><%=patientid%>
					</font>
			</td>
			<td width='25%' class='<%=rowclass%>' onMouseOut='clearLayer()' onMouseOver= "showMotherDetail('<%=r%>',this)">
					<font size=1><a href="javascript:patOpenChart('<%=patientid%>','<%=encounterid%>','<%=patientclass%>')"><%=(rsPatList.getString("PATIENT_NAME")==null?"&nbsp;":rsPatList.getString("PATIENT_NAME"))%></a>
					</font>
			</td>
			<td width='10%' class='<%=rowclass%>' >
					<font size=1><%=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMYHM","en",locale)%>
					</font>
			</td>
			<td width='3%' class='<%=rowclass%>'>
					<font size=1><%=rsPatList.getString("AGE")%>
					</font>
			</td>
			<td width='5%' class='<%=rowclass%>' >
					<font size=1><%=sex%>
					</font>
			</td>
			<td width='10%'  class='<%=rowclass%>' >
					<font size=1><%=(rsPatList.getString("BABY_LOCN")==null?"&nbsp;":rsPatList.getString("BABY_LOCN"))%>
					</font>
			</td>
			<td width='8%' class='<%=rowclass%>' >
					<font size=1><%=(rsPatList.getString("BABY_ROOM_NUM")==null ?"&nbsp;":rsPatList.getString("BABY_ROOM_NUM"))%>
					</font>
			</td>
			<td width='6%' class='<%=rowclass%>'>
					<font  size=1><%=(rsPatList.getString("BABY_BED_NUM")==null?"&nbsp;":rsPatList.getString("BABY_BED_NUM"))%>
					</font>
			</td>
			<td width='15%' class='<%=rowclass%>' >
					<font size=1><%=rsPatList.getString("MOTHER_NAME")%>
					</font>
			</td>
			<td width='5%'  class='<%=rowclass%>' >
				<font size=1><%=(rsPatList.getString("MOTHER_BED_NUM")==null ?"&nbsp;":rsPatList.getString("MOTHER_BED_NUM"))%>
				</font>
			</td>
			</tr>-->
<%

/*Mother tooltip construction */

String strMotherAdmDate = rsPatList.getString("mother_adm_date");

if(strMotherAdmDate == null)
	strMotherAdmDate = "&nbsp;";

if(!strMotherAdmDate.equals("&nbsp;"))
	strMotherAdmDate = com.ehis.util.DateUtils.convertDate(strMotherAdmDate,"DMYHM","en",locale);

motherlink.append("<tr><td class=ORPANEL nowrap><font size=1>"+rsPatList.getString("MOTHER_NAME")+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+rsPatList.getString("mother_age")+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+rsPatList.getString("mother_patient_id")+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+(rsPatList.getString("MOTHER_LOCN")==null?"&nbsp;":rsPatList.getString("MOTHER_LOCN"))+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+(rsPatList.getString("MOTHER_ROOM_NUM")==null?"&nbsp;":rsPatList.getString("MOTHER_ROOM_NUM"))+"</font></td>"+"<td class=ORPANEL><font size=1>"+(rsPatList.getString("MOTHER_BED_NUM")==null?"&nbsp;":rsPatList.getString("MOTHER_BED_NUM"))+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+strMotherAdmDate+"</font></td>"+"</tr>");
String PatName = rsPatList.getString("PATIENT_NAME");
%>
<script>
	MotherDetails[<%=r%>]="<%=motherlink.toString()%>";MotherName[<%=r%>]="<%=PatName%>";
scan_count_required_yn[<%=r%>]="<%=scan_count_required_yn%>";alert_required_yn[<%=r%>]="<%=alert_required_yn%>";remarks_required_yn[<%=r%>]="<%=remarks_required_yn%>";//Added for IN072994
</script>
<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!-- 32902  --> 
<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!-- 32902  --> 
<%
i++;
k++;
r++;
}
	if(i==1)
	{

out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
out.println("<script>top.content.workAreaFrame.NewBornTitleFrame.location.href='../../eCommon/html/blank.html';top.content.workAreaFrame.NewBornResultFrame.location.href='../../eCommon/html/blank.html';</script>");
	}

%>
</table>

<input type="hidden" name="patient_id" id="patient_id" value="">
<input type="hidden" name="encounter_id" id="encounter_id" value="">
<input type="hidden" name="reln_ReqYn" id="reln_ReqYn" value="">
<input type="hidden" name="reln_Yn" id="reln_Yn" value="">
<input type="hidden" name="insert_op" id="insert_op" value="N">
<input type="hidden" name="patient_class" id="patient_class" value="">
<input type="hidden" name="reOrder" id="reOrder" value="<%=reOrder%>">
<input type="hidden" name="anchorID" id="anchorID" value="<%=anchorID%>">
<input type="hidden" name="scrol" id="scrol" value="<%=leftScrolling%>">
<input type='hidden' name='called_function_id' id='called_function_id' value= 'NEW_BORN'> 
<input type='hidden' name="relnreqyn" id="relnreqyn" value="<%=relnreqyn%>"/>
<input type='hidden' name="decease" id="decease" value="<%=decease%>"/>
</form>
<div id='motherLink' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<%if(!anchorID.equals("")){%>
		<script>
			if('<%=leftScrolling%>'!='')
			{
				document.body.scrollLeft='<%=leftScrolling%>';
			}
			if('<%=anchorID%>'!='')
			{
				if('<%=reOrder%>'=='1')
				{
					//top.content.workAreaFrame.NewBornTitleFrame.document.NewBornTitleForm.document.getElementById("PatCriteriaTbl").all.<%=anchorID%>.style.color='pink';
					top.content.workAreaFrame.NewBornTitleFrame.document.getElementById('<%=anchorID%>').style.color='pink';
				}
				else if('<%=reOrder%>'=='2')
					//top.content.workAreaFrame.NewBornTitleFrame.document.NewBornTitleForm.document.getElementById("PatCriteriaTbl").all.<%=anchorID%>.style.color='yellow';
					top.content.workAreaFrame.NewBornTitleFrame.document.getElementById('<%=anchorID%>').style.color='yellow';
			}
		</script>
		<%}%>
		

<script>


const newHeaderRow = `<tr>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap >&nbsp;</td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap >&nbsp;</td>
<!-- //22856-start-->
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap align="left"><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></td>
 <!-- //22856-End-->
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap align="left"><a id='a1'   href="javascript:callOrderBy('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.NewBornID.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap align="left"><a id='a2'   href="javascript:callOrderBy('PN');" onclick='changeColor(this);' style='color:pink'><fmt:message key="eCA.NewBornName.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap align="left"><a id='a3'   href="javascript:callOrderBy('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap align="left"><a id='a4'   href="javascript:callOrderBy('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   rowspan=2  width='' nowrap align="left"><a id='a5'   href="javascript:callOrderBy('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   width='' nowrap colspan=3  style='color:white' align="left"><fmt:message key="eCA.NewBornLocation.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'   rowspan=2 width='' nowrap align="left"><a id='a6'   href="javascript:callOrderBy('MN');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.MothersName.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   rowspan=2 width='' nowrap style='color:white' align="left"><fmt:message key="eCA.MothersBed.label" bundle="${ca_labels}"/></td>
</tr>

<tr>
<td class='COLUMNHEADERCENTER'  width='' nowrap align="left" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap align="left" ><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap align="left"><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></td>
</tr>`;


// Get the table by its ID
const table = document.getElementById('PatCriteriaTb');

//Check if the table exists
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
console.error("Table with ID 'PatCriteriaTb' not found.");
}
document.getElementById('PatCriteriaTb').style.marginTop="0px";
parent.document.getElementById('NewBornTitleFrame').style.display="none";
</script>

		
<script>
		
		if(parent.NewBornTitleFrame.document.getElementById("PatCriteriaTbl")==null)
		{
			
			setTimeout("alignHeading();",300);
		}
		else 
			alignHeading();
</script>
<%
if(!anchorID.equals("")){
	%>
	<script>
		if('<%=leftScrolling%>'!='')
		{
			document.body.scrollLeft='<%=leftScrolling%>';
		}
		if('<%=anchorID%>'!='')
		{   //*** added to make all anchors white before making the selcted one pink
			// Get all anchor tags in the document
			const anchors = document.querySelectorAll('a');

			// Filter anchor tags where the id contains 'a'
			const filteredAnchors = Array.from(anchors).filter(anchor => anchor.id.includes('a'));

			for(i=0;i<filteredAnchors.length;i++)
			{
				filteredAnchors[i].style.color='white';

			}
			//***
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
<%}
}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if(pstmt!=null)pstmt.close();
	if(rsPatList!=null)rsPatList.close();
	if(pstmt1!=null)pstmt1.close();//Added for IN072994
	if(resultSet!=null)resultSet.close();//Added for IN072994
	if(con!=null)ConnectionManager.returnConnection(con,request);
}%>	

</body>
</form>
</html>

