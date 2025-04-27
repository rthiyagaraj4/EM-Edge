<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper " %>
<html> 
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eOA/js/TransferClinicSch.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
//	HashMap hash = new HashMap();

	String facilityId = (String) session.getValue( "facility_id" ) ;
	String efffrom =request.getParameter("eff_from");
	String effto =request.getParameter("eff_to");
	String fromday =request.getParameter("from_day");
	String today =request.getParameter("to_day");
	String dateday = request.getParameter("date_day");
	String practid = request.getParameter("pract_id");
	String ref_val=request.getParameter("ref_val");
	String primary_yn = "";
   String locale=(String)session.getAttribute("LOCALE");

   efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
	effto=DateUtils.convertDate(effto,"DMY",locale,"en");

	if(practid == null || practid =="")
		practid="";

	String locncode = request.getParameter("locn_code");
	String reason = request.getParameter("reason");
	String locnType=request.getParameter("locnType")==null?"":request.getParameter("locnType");
	String resType= request.getParameter("resType")==null?"":request.getParameter("resType");
	String transdate = "",transday = "",currdate = "",currday = "",noofappts = "",sql = "",sql1 = "",tday = "",curdayno="",transdayno = "",sql_1="",transday1="";
	int k=0;
	String classValue="",practname="",pract="",pract1="",care_locn_type_ind="",resource_class="",resource_class_desc="",sel_res_pos="",cntval="";
	String flag="F";
	String flag1="Y";
	String chk= "F";
	String chk1= "F";
	String currdate_disp="";
	String transdate_disp="";
	int dateval = 0;
	
	

	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String other_remarks = request.getParameter("other_remarks")==null?"":request.getParameter("other_remarks");
	
%>
<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' onload='clrval();' >
<form name='TCSchDetail_form' id='TCSchDetail_form' action='../../servlet/eOA.TransferClinicSchServlet' method='post' target='messageFrame'>

<%
Connection con=null;
PreparedStatement pstmt=null;
Statement stmt = null,stmt1 = null,stmt4 = null,stmt2 = null,stmt3 = null;
ResultSet rset = null,rset1 = null,rset2 = null,rset4 = null,rset5= null,rset6= null;


try{
	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
	stmt2=con.createStatement();
	stmt3=con.createStatement();

if(dateday.equals("A"))
{
	flag1="Y";
}else
{
flag1="N";
}
	
	

	if(dateday.equals("A") && ref_val.equals(""))
	{

		/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
		//sql1 = " SELECT to_char(CLINIC_DATE,'dd/mm/yyyy') CURRENT_DATE, initcap(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, care_locn_type_ind, resource_class, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, to_char(to_date('"+effto+"','dd/mm/yyyy'),'Day') d FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+efffrom+"','dd/mm/yyyy') and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and  nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+effto+"','dd/mm/yyyy')) ";
		
		/*Below query modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
	//	sql1 = " SELECT to_char(CLINIC_DATE,'dd/mm/yyyy') CURRENT_DATE, initcap(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, care_locn_type_ind, resource_class, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, to_char(to_date('"+effto+"','dd/mm/yyyy'),'Day') d FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+efffrom+"','dd/mm/yyyy') and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and  nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+effto+"','dd/mm/yyyy')) AND (eff_status != 'D' OR eff_status IS NULL)";
		sql1 = " SELECT to_char(CLINIC_DATE,'dd/mm/yyyy') CURRENT_DATE, initcap(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, care_locn_type_ind, resource_class, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, to_char(to_date(?,'dd/mm/yyyy'),'Day') d FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = ? and CLINIC_CODE = ? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X')) and CLINIC_DATE = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and resource_class=? AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ? and CLINIC_CODE = ? and care_locn_type_ind=? and resource_class=? and  nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X')) and CLINIC_DATE = to_date(?,'dd/mm/yyyy')) AND (eff_status != 'D' OR eff_status IS NULL)";
		
		//sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date('"+efffrom+"','dd/mm/yyyy')  " ;
		sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ? and CLINIC_CODE = ? and care_locn_type_ind=? and resource_class=? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date(?,'dd/mm/yyyy')  " ;
		
		//sql_1 = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date('"+effto+"','dd/mm/yyyy')  " ;
		sql_1 = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ?  and CLINIC_CODE = ? and care_locn_type_ind= ? and resource_class=? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date(?,'dd/mm/yyyy')  " ;

		//rset=stmt.executeQuery(sql1);
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,effto);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,locncode);
		pstmt.setString(8,practid);
		pstmt.setString(9,efffrom);
		pstmt.setString(10,locnType);
		pstmt.setString(11,resType);
		pstmt.setString(12,facilityId);
		pstmt.setString(13,locncode);
		pstmt.setString(14,locnType);
		pstmt.setString(15,resType);
		pstmt.setString(16,practid);
		pstmt.setString(17,effto);
		rset = pstmt.executeQuery();
		if(rset.next())
		{
			flag = "T";
		}else
		{
			flag = "F";


			//rset5=stmt.executeQuery(sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locnType);
			pstmt.setString(4,resType);
			pstmt.setString(5,practid);
			pstmt.setString(6,efffrom);
			rset5 = pstmt.executeQuery(); 
			if(rset5.next())
			{
				chk1= "T";
			}
			if(rset5 !=null) rset5.close();

			//rset6=stmt.executeQuery(sql_1);
			pstmt = con.prepareStatement(sql_1);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locnType);
			pstmt.setString(4,resType);
			pstmt.setString(5,practid);
			pstmt.setString(6,effto);
			rset6 = pstmt.executeQuery(); 
			
			

			if(chk1=="T" && rset6.next())
			{
				chk= "T";
			}
			if(rset6 !=null) rset6.close();

		}

		if(rset !=null) rset.close();

	}else if(flag1.equals("N") && ref_val.equals("false")){
       
	    /* Below query was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		
		//sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and UPPER(RTRIM(TO_CHAR( CLINIC_DATE,'Day')))= RTRIM('"+fromday+"')  and CLINIC_DATE  between to_date('"+efffrom+"','dd/mm/yyyy')  and to_date('"+effto+"','dd/mm/yyyy') " ;
		sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ?  and CLINIC_CODE = ? and care_locn_type_ind=? and resource_class=? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X'))   and UPPER(RTRIM(TO_CHAR( CLINIC_DATE,'Day')))= RTRIM(?)  and CLINIC_DATE  between to_date(?,'dd/mm/yyyy')  and to_date(?,'dd/mm/yyyy') " ;


		//rset=stmt.executeQuery(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locnType);
			pstmt.setString(4,resType);
			pstmt.setString(5,practid);
			pstmt.setString(6,fromday);
			pstmt.setString(7,efffrom);
			pstmt.setString(8,effto);
			rset = pstmt.executeQuery(); 
		if(rset.next()){

		
			/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
			//sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DAY')) TRANSFER_DAY,  NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND TO_DATE('"+effto+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+effto+"','DD/MM/YYYY'),'"+today+"')) ORDER BY CLINIC_DATE ";
		

			/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
		sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DAY')) TRANSFER_DAY,  NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND TO_DATE('"+effto+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+effto+"','DD/MM/YYYY'),'"+today+"'))  AND (eff_status != 'D' OR eff_status IS NULL) ORDER BY CLINIC_DATE ";

		

			flag="T";
		}else{
			flag = "F";
		}


	}else if(flag1.equals("N") && ref_val.equals("true"))
	{

          /* Below query was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		  
		sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and RTRIM(TO_CHAR( CLINIC_DATE,'Day'))= RTRIM('"+fromday+"')  and CLINIC_DATE  between to_date('"+effto+"','dd/mm/yyyy')  and to_date('"+efffrom+"','dd/mm/yyyy') " ;
		

		rset=stmt.executeQuery(sql);

		if(rset.next()){
		
		
        /*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
		//sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DAY')) TRANSFER_DAY, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND TO_DATE('"+efffrom+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+efffrom+"','DD/MM/YYYY'),'"+today+"')) ORDER BY CLINIC_DATE";
		
		/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
		sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DAY')) TRANSFER_DAY, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND TO_DATE('"+efffrom+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+efffrom+"','DD/MM/YYYY'),'"+today+"')) AND (a.eff_status != 'D' OR a.eff_status IS NULL) ORDER BY CLINIC_DATE";

		flag="T";
		}else{
			flag = "F";
		}
	}
	if(rset !=null) rset.close();


	if(flag.equals("T")){
		stmt1=con.createStatement();
		stmt4=con.createStatement();
		rset1=stmt1.executeQuery(sql1);

		if(rset1.next() ){%>
		
     		
		   <table border='1' cellpadding='0' cellspacing='0' align='center' width='95%'>
		   <td class='COLUMNHEADER'><fmt:message key="Common.CurrentDate.label" bundle="${common_labels}"/></td>
		   <td class='COLUMNHEADER'><fmt:message key="eOA.CurrentDay.label" bundle="${oa_labels}"/></td>
		   <td class='COLUMNHEADER'><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/></td>
		   <td class='COLUMNHEADER'><fmt:message key="eOA.TransferDay.label" bundle="${oa_labels}"/></td>
		   <td class='COLUMNHEADER'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		   <td class='COLUMNHEADER'><fmt:message key="eOA.NoOfAppts.label" bundle="${oa_labels}"/></td>
		   <td class='COLUMNHEADER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<%do{
			    tday = rset1.getString("d");
				currdate=rset1.getString("CURRENT_DATE");
				currdate_disp=DateUtils.convertDate(currdate,"DMY","en",locale);

				currday = rset1.getString("CURRENT_DAY");

				
				currday=currday.trim();
				if(currday.equalsIgnoreCase("Monday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(currday.equalsIgnoreCase("Tuesday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(currday.equalsIgnoreCase("Wednesday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(currday.equalsIgnoreCase("Thursday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(currday.equalsIgnoreCase("Friday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(currday.equalsIgnoreCase("Saturday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(currday.equalsIgnoreCase("Sunday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

				curdayno = rset1.getString("CLINIC_DAY_NO");
				practname = rset1.getString("PRACTITIONER_FULL_NAME");
				pract = rset1.getString("PRACTITIONER_ID");
				care_locn_type_ind= rset1.getString("care_locn_type_ind");
				resource_class= rset1.getString("resource_class");
				if(resource_class.equals("P")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(resource_class.equals("R")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(resource_class.equals("O")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}else if(resource_class.equals("E")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}
				sel_res_pos = rset1.getString("PRIMARY_RESOURCE_YN");
				if(sel_res_pos==null || sel_res_pos.equals("null"))  sel_res_pos="";

				if(pract== null || pract.equals("null")) pract ="~";
				if(practname == null || practname.equals("null"))
				practname ="&nbsp;";
				noofappts = rset1.getString("total_slots_booked");
				if(noofappts==null) noofappts="0";
				primary_yn = rset1.getString("primary_resource_yn");

				if(dateday.equals("A")){
					transdate = effto;
					transday = tday;
				}else{
					transdate = rset1.getString("TRANSFER_DATE");
					transday = rset1.getString("TRANSFER_DAY");
				}

				transdate_disp=DateUtils.convertDate(transdate,"DMY","en",locale);

				transday=transday.trim();
		
			if(transday.equalsIgnoreCase("Monday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(transday.equalsIgnoreCase("Tuesday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(transday.equalsIgnoreCase("Wednesday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(transday.equalsIgnoreCase("Thursday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(transday.equalsIgnoreCase("Friday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(transday.equalsIgnoreCase("Saturday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(transday.equalsIgnoreCase("Sunday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


				String t_prct="";
				if (pract==null)  {
					pract1="";	
					t_prct="";
				}else{
					pract1 = pract;
					t_prct=pract1;
					if(pract1.equals("~"))
						t_prct="";
				}

				if(k==0){ // to exec only one on the loop
					//rset2=stmt2.executeQuery("select day_no from sm_day_of_week where rtrim(Initcap(day_of_week)) = rtrim('"+transday+"')");

//Add for PE on june 17'th june 2010
					String chkval1="select day_no,(select TO_DATE ('"+transdate+"', 'dd/mm/yyyy') - trunc(sysdate)  from dual)chkdate from sm_day_of_week where rtrim(Initcap(day_of_week)) = rtrim('"+transday+"')";

					

					rset2=stmt2.executeQuery(chkval1);
					//int dateval = 0;
					if(rset2.next()){
						
						transdayno = rset2.getString("day_no");
						
						dateval =rset2.getInt("chkdate");
						
					}
				}

				if(rset2 !=null)rset2.close();
				cntval="0";
				
				if ( k % 2==0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;

					//String chkval = " select TO_DATE ('"+transdate+"', 'dd/mm/yyyy') - trunc(sysdate) chkdate from dual";
					
							/*rset2 = stmt2.executeQuery(chkval1);
							int dateval = 0;
							if(rset2 !=null && rset2.next())
						   {
								dateval =rset2.getInt("chkdate");
								
							}
							
						if(rset2 !=null)rset2.close();	*/
						
				if(!(noofappts.equals("0")) && dateval >=0){%>
					<tr><td class='<%=classValue%>'><%=currdate_disp%></td><td class='<%=classValue%>'><%=currday%></td><td class='<%=classValue%>'><%=transdate_disp%></td><td class='<%=classValue%>'><%=transday1%></td><td class='<%=classValue%>'><%=resource_class_desc%> / <%=practname%></td><td class='<%=classValue%>' align=middle>
					<%if(primary_yn.equals("Y")){%>	
					<a href=javascript:show_modwin('<%=locncode%>','<%=t_prct%>','<%=currday.trim()%>','<%=currdate%>','<%=care_locn_type_ind%>','<%=resource_class%>') alt='Appointment Details' ><%=noofappts%></a></td>
					<%}else{%><%=noofappts%></td>
					<%}%>
					
				<%}else if((noofappts.equals("0")) && dateval >=0){%>
					<tr><td class='<%=classValue%>'><%=currdate_disp%></td><td class='<%=classValue%>'><%=currday%></td><td class='<%=classValue%>'><%=transdate_disp%></td><td class='<%=classValue%>'><%=transday1%></td><td class='<%=classValue%>'><%=resource_class_desc%> / <%=practname%></td><td class='<%=classValue%>' align=middle><%=noofappts%></td>
				<%}%>

				<%	

				if(!(noofappts.equals("0")) && primary_yn.equals("Y") && dateval >=0){
						
					
					}
					
			
				if(rset4 !=null)rset4.close();

				%> 
	<%if(primary_yn.equals("N") && !(noofappts.equals("0")) && dateval >=0){%>	
		<td align='center' class='<%=classValue%>'><input type='checkbox' name='sel_<%=k%>' id='sel_<%=k%>' value='' checked >
			<input type='hidden' name='vals_<%=k%>' id='vals_<%=k%>'value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=noofappts%>|<%=primary_yn%>' > <input type='hidden' name='vals1_<%=k%>' id='vals1_<%=k%>' value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=primary_yn%>|<%=noofappts%>' >
		</td></tr>

	<% }else if(primary_yn.equals("N") && (noofappts.equals("0")) && dateval >=0){%>
						
		<td align='center' class='<%=classValue%>'><input type='checkbox' name='sel_<%=k%>' id='sel_<%=k%>' value='' checked ></td></tr>
		<input type='hidden' name='vals_<%=k%>' id='vals_<%=k%>' value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=noofappts%>|<%=primary_yn%>' >
		<input type='hidden' name='vals1_<%=k%>' id='vals1_<%=k%>' value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=primary_yn%>|<%=noofappts%>' >

	<%} else if(primary_yn.equals("Y") && !(noofappts.equals("0")) && dateval >=0 ) {
		
		%>
		
			<td align='center' class='<%=classValue%>'>
			<input type='checkbox' name='sel_<%=k%>' id='sel_<%=k%>' value='' checked > <input type='hidden' name='vals_<%=k%>' id='vals_<%=k%>'value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=noofappts%>|<%=primary_yn%>' > <input type='hidden' name='vals1_<%=k%>' id='vals1_<%=k%>' value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=primary_yn%>|<%=noofappts%>' >
			</td></tr>
		<%

	} else if(primary_yn.equals("Y") && (noofappts.equals("0")) && dateval >=0) {%>
						
		<td align='center' class='<%=classValue%>'><input type='checkbox' name='sel_<%=k%>' id='sel_<%=k%>' value='' checked ></td></tr>
		<input type='hidden' name='vals_<%=k%>' id='vals_<%=k%>' value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=noofappts%>|<%=primary_yn%>' >
		<input type='hidden' name='vals1_<%=k%>' id='vals1_<%=k%>' value='<%=locncode%>|<%=pract%>|<%=currdate%>|<%=transdate%>|<%=primary_yn%>|<%=noofappts%>' >
	<%}%>
				
	<%k++;
	
	}while(rset1.next());
						
			
%>
			
	<script>parent.frames[1].document.forms[0].generaterep.disabled = false;</script>

	<%}else{%>	
			<script>parent.frames[1].document.forms[0].generaterep.disabled = true;sch_exits();</script>
		<%}	    
	}else{
		
		if(chk=="F"){%>
		<script>parent.frames[1].document.forms[0].generaterep.disabled = true;no_sch();</script>
		<%
	}
		else{%>
			<script>parent.frames[1].document.forms[0].generaterep.disabled = true;sch_exits1();</script>
			<% }
	}

	if(rset != null)rset.close();
	if(rset1 != null)rset1.close();
	if(rset2 != null)rset2.close();
	if(rset4 != null)rset4.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
	if(stmt2 != null) stmt2.close();
	if(stmt3 != null) stmt3.close();
	if(stmt4 != null) stmt4.close();

}catch(Exception e){
	//out.print("her :" +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='no_of_rec' id='no_of_rec'  value= '<%=k%>' >
<input type='hidden' name='final_vals' id='final_vals'  value= '' >
<input type='hidden' name='final_vals1' id='final_vals1'  value= '' >
<input type='hidden' name='sel_rec' id='sel_rec'  value= '' >
<input type='hidden' name='eff_from' id='eff_from'  value= '<%=efffrom%>' >
<input type='hidden' name='eff_to' id='eff_to'  value= '<%=effto%>' >
<input type='hidden' name='reason' id='reason'  value= '<%=reason%>' >
<input type='hidden' name='date_day' id='date_day'  value= '<%=dateday%>' >
<input type='hidden' name='cur_day_no' id='cur_day_no'  value= '<%=curdayno%>' >
<input type='hidden' name='trans_day_no' id='trans_day_no'  value= '<%=transdayno%>' >
<input type='hidden' name='locncode' id='locncode'  value= '<%=locncode%>' >
<input type='hidden' name='practid' id='practid'  value= '<%=practid%>' >
<input type='hidden' name='fromday' id='fromday'  value= '<%=fromday%>' >		
<input type='hidden' name='P_To_Day_No' id='P_To_Day_No' value='<%=today%>'></input>
<input type='hidden' name='genrep' id='genrep'  value= '' >
<input type='hidden' name='primary_yn' id='primary_yn' value='<%=primary_yn%>'>
<input type='hidden' name='noofappts' id='noofappts' value='<%=noofappts%>'>
<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
<input type="hidden" name="p_report_id" id="p_report_id"   value="OAAFAPLST"></input>
<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facilityId%>'></input>
<input type="hidden" name="noofappts" id="noofappts" value='<%=noofappts%>'></input>
<input type="hidden" name="locnType" id="locnType" value='<%=locnType%>'>
<input type="hidden" name="resType" id="resType" value='<%=resType%>'>

<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
<input type='hidden' name='other_remarks' id='other_remarks' value='<%=other_remarks%>'>
		
</form>
</body>
</html>

