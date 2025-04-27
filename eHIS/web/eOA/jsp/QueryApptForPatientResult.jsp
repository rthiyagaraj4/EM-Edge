<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%

    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String fac_id		= (String) session.getValue( "facility_id" ) ;
	StringBuffer sql = new StringBuffer("") ;
	String appt_no1="";
	String age="";
	String appt_no2="";
	String rsource="";
	String sql4="";
	String apptfromdate_greg="";
	String appttodate_greg="";
	String fac_id2=(String) session.getValue( "facility_id" );
	String appt_ref_no ="";
	String patientid	=	request.getParameter("patientid") ;
	String patname	=	request.getParameter("patientname") ;
	String cliniccode	=	request.getParameter("cliniccode") ;
	String practcode	=	request.getParameter("practcode") ;
	String gender		=	request.getParameter("gender") ;
	String apptfromdate	=	request.getParameter("apptfromdate") ;
	String MODULE_ID	=	request.getParameter("MODULE_ID") ;
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String showInstructionsYN="N";
	String module_id	=	request.getParameter("MODULE_ID") ;
	String patientCatDesc="";
	if(module_id == null )
		module_id="";
   /*"patcat_code" Added for this CRF [RUT-CRF-0011]*/		
      String patcat_code=request.getParameter("patcat_code")==null?"":request.getParameter("patcat_code") ;		   
	/*End [RUT-CRF-0011]*/
	
	//Below variable declare for this  [Bru-HIMS-CRF-177]
	 String colour_indicator="";

	 
 // String schedule_gender=request.getParameter("schedule_gender")==null?"":request.getParameter("schedule_gender") ; // Added for this CRF [Bru-HIMS-CRF-167]
	 
/*1*/	String oth_contact_no=	request.getParameter("oth_contact_no") ;
           if(oth_contact_no == null)	oth_contact_no = "";
	String appttodate	=	request.getParameter("appttodate") ;
	String referral_priority	=	request.getParameter("referral_priority") ;
	String speciality	=	request.getParameter("speciality") ;
	String service	=	request.getParameter("service") ;
	String facility =	request.getParameter("facility")==null?fac_id:request.getParameter("facility");//modified for the SCF - ML-BRU-SCF-1045 [IN043888]
	String cancel_appt =	request.getParameter("cancel_appt") ;
	String care_locn =	request.getParameter("care_locn") ;
	String resource_type =	request.getParameter("resource_type") ;
	String orderCriteria_sensor =	request.getParameter("orderCriteria_sensor") == null?"apptno":request.getParameter("orderCriteria_sensor");
	String short_desc1 =	request.getParameter("short_desc") ;
	String patientname1		=	request.getParameter("patientname")== null?"":request.getParameter("patientname");
	String locale = (String)session.getAttribute("LOCALE");
	String incld_past_appts		=	request.getParameter("incld_past_appts")== null?"":request.getParameter("incld_past_appts");
	apptfromdate_greg=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
	appttodate_greg=DateUtils.convertDate(appttodate,"DMY",locale,"en");

	
	StringBuffer orderByClause  = new StringBuffer();

   String orderCriteria	=	(request.getParameter("orderCriteria")==null)	? "apptno" : request.getParameter("orderCriteria");
   String asc_desc	=	(request.getParameter("asc_desc")==null)	? " asc" : request.getParameter("asc_desc");

if(orderCriteria.equals("")) orderCriteria="apptno" ;
appt_ref_no	=	(request.getParameter("appt_ref_no")==null)	? "" : request.getParameter("appt_ref_no"); 
age	=	(request.getParameter("age")==null)	? "" : request.getParameter("age"); 




	//if(appt_ref_no == null || appt_ref_no.equals("null"))	appt_ref_no = "";
	if(cancel_appt == null || cancel_appt.equals("null"))	cancel_appt = "";
	if(patientid == null || patientid.equals("null"))	patientid = "";
	if(patname == null || patname.equals("null"))	patname = "";
	if(cliniccode == null || cliniccode.equals("null"))	cliniccode = "";
	if(practcode == null || practcode.equals("null"))	practcode = "";
	if(gender == null || gender.equals("null"))	gender = "";
	if(apptfromdate == null || apptfromdate.equals("null"))	apptfromdate = "";
	if(appttodate == null || appttodate.equals("null"))	appttodate = "";
	if(referral_priority == null || referral_priority.equals("null"))	referral_priority = "";
	if(service == null || service.equals("null"))	service = "";
	if(speciality == null || speciality.equals("null"))	speciality = "";
	if(resource_type == null || resource_type.equals("null"))	resource_type = "";
	if(care_locn == null || care_locn.equals("null"))	care_locn = "";
	if(short_desc1 == null || short_desc1.equals("null"))	short_desc1 = "";




	String patientname = patname;
	String referralId	="";
	String order_catalog_code="";
	
	String classValue	 = "";
	String patient_id_one="";
	String p_name="";
	
	String practitioner_full_name="";
	String DECEASED_YN="";
	String translator_override_reason="";

	if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
		
	}
	if (!patientname1.equals(""))
	{
	patientname1   =   patientname1 +"%";
	}
	if (!oth_contact_no.equals(""))
	{
		oth_contact_no		= 	oth_contact_no + "%" ;
	
	}


	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		/*******order by creation logic********************/

	if(orderCriteria.equals("appt"))
		{
			orderByClause.append(" ORDER BY appt_ref_no");
		}

 if(orderCriteria.equals("apptno"))
		{
			orderByClause.append(" ORDER BY ");
			orderByClause.append(" appt_ref_no"+asc_desc+" ");
		}
	else if(orderCriteria.equals("patientId"))
		{
			orderByClause.append(" ORDER BY ");
			orderByClause.append("patient_id ");
			orderByClause.append(""+asc_desc+" ");
		}
	else if(orderCriteria.equals("PatientName"))
		{	
			orderByClause.append(" ORDER BY ");
			orderByClause.append("patient_name"+asc_desc+" ");

		}
else if(orderCriteria.equals("gender"))
		{
				orderByClause.append(" ORDER BY ");
			orderByClause.append("GENDER"+asc_desc+" ");
		}
else if(orderCriteria.equals("age"))
		{
			orderByClause.append(" ORDER BY ");
			orderByClause.append("AGE"+asc_desc+" ");
		}

else if(orderCriteria.equals("MobileNo"))
		{
				orderByClause.append(" ORDER BY ");
			orderByClause.append("oth_contact_no"+asc_desc+" ");
		}
else if(orderCriteria.equals("apptdate"))
		{
				orderByClause.append(" ORDER BY ");
			orderByClause.append(" appt_date"+asc_desc+" ");
		}
else if(orderCriteria.equals("fromtime"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_slab_from_time ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("totime"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_slab_to_time ");
			orderByClause.append(""+asc_desc+" ");
		}


		else if(orderCriteria.equals("duration"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_duration ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("visittype"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("visit_type_short_desc ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("Location"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("clinic_short_desc  ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("resource"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("practitioner_full_name ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("speciality"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("speciality_desc ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("ordercatalog"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("order_catalog_code ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("referralid"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("referral_id ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("ApptGivenBy"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("added_by ");
			orderByClause.append(""+asc_desc+" ");
		}
		
		else if(orderCriteria.equals("ApptGivenOn"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("added_date ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("status"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_status ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("LastModifiedBy"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("modified_by ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("Lastmodifiedon"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("modified_date ");
			orderByClause.append(""+asc_desc+" ");
		} 
		
		else if(orderCriteria.equals("Category"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("patient_cat_code ");
			orderByClause.append(""+asc_desc+" ");
		} 
/*Checking "Category", Above else if condition Added for this CRF [RUT-CRF-0011]*/
/*******order by creation logic********************/


	Statement stmt				= null;
	ResultSet rs				= null;
	PreparedStatement pstmt=null;
	Statement stmt1				= null;
	ResultSet rs1				= null;
	ResultSet rs2				= null;
	Connection conn=null;
	
try {
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	stmt1	 = conn.createStatement();
	//out.println("<script>alert('MODULE_ID--->'+"MODULE_ID"')</script>");
	%>
	<HTML>
	<head>
	<%if(MODULE_ID!=null && MODULE_ID.equals("PH")){%>
	<title><fmt:message key="eMP.ViewPatientDetails.label" bundle="${mp_labels}"/></title>
	<%}%>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryApptForPatient.js"></script>


	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src="../../eCommon/js/common.js"></script>
	
	<script>

	</script>
	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	<form name='QueryApptForPatient' id='QueryApptForPatient'>

	<%





	if (appt_ref_no ==null) appt_ref_no="";

		sql.append(" where ");
		if(!patientid.equals("")){
			sql.append(" patient_id='"+patientid+"' and ") ;
		}
		if(!cliniccode.equals("")){
			sql.append(" clinic_code = '"+cliniccode+"' and ");
		}
		if(!practcode.equals("")){
			sql.append(" practitioner_id = '"+practcode+"' and ") ;
		}
		if(!care_locn.equals("")){
			sql.append(" CARE_LOCN_TYPE_IND = '"+care_locn+"' and ") ;
		}
		if(!resource_type.equals("")){
			sql.append(" RESOURCE_CLASS =  '"+resource_type+"' and ") ;
		}
		if(!speciality.equals("")){
			sql.append(" speciality_code =  '"+speciality+"' and ") ;
		}
		if(!appt_ref_no.equals("")){
			sql.append(" appt_ref_no =  '"+appt_ref_no+"' and ") ;
		}
		//Saanthaakumar  Below Condition Added Bru-HIMS-CRF-302 [IN:035020] 
		if(!facility.equals("")){
			sql.append(" FACILITY_ID =  '"+facility+"' and ") ;
		}
		// Condition End Bru-HIMS-CRF-302 [IN:035020] 
		
	 /*Below Condition Added for this CRF [RUT-CRF-0011]*/
		if(!patcat_code.equals("")){
			sql.append(" patient_cat_code =  '"+patcat_code+"' and ") ;
		}
     /*End [RUT-CRF-0011]*/	

    /*Below Condition Added for this CRF [Bru-HIMS-CRF-167]*/	
	//if(!schedule_gender.equals("")){
	//		sql.append("pract_gender = '"+schedule_gender+"' and ") ;
	//	}	
	//End [Bru-HIMS-CRF-167]
				

	sql.append("appt_date between to_date(nvl('"+apptfromdate_greg+"','01/01/1400'),'dd/mm/yyyy') and ");
	sql.append(" to_date(nvl('"+appttodate_greg+"','31/12/5000'),'dd/mm/yyyy') ");
    
	
	
if (patientid.equals("")) 
	{

	sql.append(" and UPPER(PATIENT_NAME) like upper('%"+patientname1+"%')"); 

	
	}

	 if (!(incld_past_appts.equals("")|| incld_past_appts.equals(null)))
	 {
		if (incld_past_appts.equals("N"))
		{
			sql.append("AND appt_date>=trunc(sysdate)");
		}
	 }
		 if (!oth_contact_no.equals(""))
{

	sql.append(" and UPPER(oth_contact_no) like upper('%"+oth_contact_no+"%')"); 
	}
if(!orderCriteria.equals(""))
	{
sql.append(orderByClause);
	}

/*	if (patientid.equals("")) 
	{
	sql.append(" order by 1,appt_date,appt_slab_from_time1") ;
	}else
	{
sql.append(" order by appt_date,appt_slab_from_time1") ;
	} */
	int maxRecord = 0;


		%>
		<%
		StringBuffer sqlStr = new StringBuffer("");
		//sqlStr.append(" Select patient_id,AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_appt_patient_vw.facility_id and CLINIC_CODE=oa_appt_patient_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC , RESOURCE_CLASS ,CLINIC_CODE,CARE_LOCN_TYPE_IND,appt_ref_no, to_char(appt_date,'dd/mm/rrrr') appt_date1,appt_date,referral_id, nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time, appt_slab_from_time appt_slab_from_time1, nvl(to_char(appt_slab_to_time,'hh24:mi'),' ')appt_slab_to_time,nvl(to_char(appt_duration,'hh24:mi'),' ')appt_duration,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc , OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC ,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name ,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by,sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, FACILITY_ID,  to_char(modified_date,'dd/mm/yyyy hh24:mi') modified_date ,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC , SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME ,appt_status,ORDER_CATALOG_CODE,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,GENDER ,oth_contact_no,get_age(DATE_OF_BIRTH) age,(select DECEASED_YN from mp_patient where patient_id=oa_appt_patient_vw.patient_id) DECEASED_YN  from  ");
		
		sqlStr.append(" Select patient_id,MP_GET_DESC.MP_PAT_CATEGORY(patient_cat_code,'en','1') patientCatDesc,AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_appt_patient_vw.facility_id and CLINIC_CODE=oa_appt_patient_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC , RESOURCE_CLASS ,CLINIC_CODE,CARE_LOCN_TYPE_IND,appt_ref_no, to_char(appt_date,'dd/mm/rrrr') appt_date1,appt_date,referral_id, nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time, appt_slab_from_time appt_slab_from_time1, nvl(to_char(appt_slab_to_time,'hh24:mi'),' ')appt_slab_to_time,nvl(to_char(appt_duration,'hh24:mi'),' ')appt_duration,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc , OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC ,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name ,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by,sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, FACILITY_ID,  to_char(modified_date,'dd/mm/yyyy hh24:mi') modified_date ,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC , SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME ,appt_status,ORDER_CATALOG_CODE,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,GENDER ,oth_contact_no,get_age(DATE_OF_BIRTH) age,(select DECEASED_YN from mp_patient where patient_id=oa_appt_patient_vw.patient_id) DECEASED_YN,(select COLOR_INDICATOR from op_visit_type where facility_id=oa_appt_patient_vw.facility_id and VISIT_TYPE_CODE=oa_appt_patient_vw.APPT_TYPE_CODE) COLOR_INDICATOR,(select contact_reason from am_contact_reason_lang_vw where contact_reason_code=oa_appt_patient_vw.TRANS_EXCEED_REASON_CODE and nvl(trans_exceed_reason_yn,'N') = 'Y' and  language_id='"+localeName+"')translator_override_reason,(select rule_appl_yn from oa_param)rule_appl_yn   from  ");
		 //Above Query Modified for this CRF [Bru-HIMS-CRF-177] 
 
		sqlStr.append("oa_appt_patient_vw ");		
 
		sqlStr.append(sql.toString()) ; 

      
			if (rs!=null) rs.close();

             
			rs = stmt.executeQuery(sqlStr.toString());
			sqlStr.setLength(0);

		
		 if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
		}
		if ( rs != null ){	

			while ( i<=end && rs.next() ){
				String rule_appl_yn=rs.getString("rule_appl_yn")==null?"N":rs.getString("rule_appl_yn");			
				if(maxRecord==0)
				{
	


			%>
				<P>
			<table align='right' >
			<tr>
			<%
			if ( !(start <= 1) ) { %>
				<td align ='right' id='prev'><A HREF='../../eOA/jsp/QueryApptForPatientResult.jsp?appt_ref_no=<%=appt_ref_no%>&patientid=<%=patientid%>&patcat_code=<%=patcat_code%>&function_id=<%=function_id%>&cliniccode=<%=cliniccode%>&care_locn=<%=care_locn%>&resource_type=<%=resource_type%>&practcode=<%=practcode%>&order=<%=asc_desc%>&orderCriteria=<%=orderCriteria%>&apptfromdate=<%=apptfromdate%>&appttodate=<%=appttodate%>&facility=<%=facility%>&from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>&speciality=<%=speciality%>&MODULE_ID=<%=MODULE_ID%>'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>
				<% }
		//	if ( !( (start+14) > maxRecord ) )
				{ %>
				<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/QueryApptForPatientResult.jsp?appt_ref_no=<%=appt_ref_no%>&patientid=<%=patientid%>&patcat_code=<%=patcat_code%>&function_id=<%=function_id%>&patname=<%=patientname%>&cliniccode=<%=cliniccode%>&care_locn=<%=care_locn%>&resource_type=<%=resource_type%>&practcode=<%=practcode%>&order=<%=asc_desc%>&orderCriteria=<%=orderCriteria%>&apptfromdate=<%=apptfromdate%>&appttodate=<%=appttodate%>&facility=<%=facility%>&from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>&speciality=<%=speciality%>&MODULE_ID=<%=MODULE_ID%>'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
				<% } %>





			<%sql.setLength(0);%>
			</tr>
			</table><br>
					</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>

		<td class='COLUMNHEADER' nowrap onclick ="sort('apptno','<%=appt_ref_no%>');" style='cursor:pointer' width='7%' ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='apptnoGif' style='visibility:hidden'></td>
		<%if (patientid.equals("")) {%>
				<td class='COLUMNHEADER' nowrap onclick ="sort('patientId','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='patientGif' style='visibility:hidden'></td>
				<td class='COLUMNHEADER' nowrap onclick ="sort('PatientName','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='patnameGif' style='visibility:hidden'></td>
				<td class='COLUMNHEADER' nowrap onclick ="sort('gender','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='genderGif' style='visibility:hidden'></td>
				<td class='COLUMNHEADER' nowrap onclick ="sort('age','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.age.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='ageGif' style='visibility:hidden'></td>
		<%}else{%>
				<%}%>
			
			<td class='COLUMNHEADER' nowrap onclick ="sort('MobileNo','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='mobileGif' style='visibility:hidden'></td>
			
			<td class='COLUMNHEADER' nowrap  onclick ="sort('Category','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.category.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='catGip' style='visibility:hidden'></td>	
			
		<td class='COLUMNHEADER' nowrap onclick ="sort('apptdate','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='apptdateGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('fromtime','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='fromdateGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('totime','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.totime.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='todateGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('duration','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.duration.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='durationGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('visittype','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='visittypeGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('Location','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='locationGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('resource','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.resource.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='resourceGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('speciality','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='specialityGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('ordercatalog','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='ordercatalogGif' style='visibility:hidden'> </td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('referralid','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='referralidGif' style='visibility:hidden'></td>

		<td class='COLUMNHEADER' nowrap onclick ="sort('patinstructions','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='apptgnGif1' style='visibility:hidden'></td>
		
		<%if(rule_appl_yn.equals("Y")){%>
		<td class='COLUMNHEADER' nowrap style='cursor:pointer' width='7%'>Translator Override Reason<img src='../../eAE/images/Ascending.gif'  border=none  align=right name='apptgnGif1' style='visibility:hidden'></td>
		<%}%>


		<td class='COLUMNHEADER' nowrap onclick ="sort('ApptGivenBy','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="eOA.ApptGivenBy.label" bundle="${oa_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='apptgnGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('ApptGivenOn','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="eOA.ApptGivenOn.label" bundle="${oa_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='apptgoGif' style='visibility:hidden'></td>
		<td class='COLUMNHEADER' nowrap onclick ="sort('status','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.status.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='statusGif' style='visibility:hidden'></td>

		<td class='COLUMNHEADER' nowrap onclick ="sort('LastModifiedBy','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="Common.LastModifiedBy.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='lastmbGif' style='visibility:hidden'></td>

		<td class='COLUMNHEADER' nowrap onclick ="sort('Lastmodifiedon','<%=appt_ref_no%>');" style='cursor:pointer' width='7%'><fmt:message key="eOA.Lastmodifiedon.label" bundle="${oa_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='lastmoGif' style='visibility:hidden'></td>
		<% }
		
				DECEASED_YN=rs.getString("DECEASED_YN");
				if(DECEASED_YN==null) DECEASED_YN = "";

				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
			if(DECEASED_YN.equals("Y"))	classValue = "DECEASEDPATLINE";
					
				referralId =rs.getString("referral_id");
				if(referralId==null) referralId = "&nbsp;";
				
				patient_id_one=rs.getString("PATIENT_ID");
				/*Below Line Added for this CRF [RUT-CRF-0011]*/
						
				patientCatDesc=checkForNull(rs.getString("patientCatDesc"));

                /*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
				colour_indicator=checkForNull(rs.getString("COLOR_INDICATOR"));	
				
				
				if(patient_id_one ==null) patient_id_one="&nbsp;";
              oth_contact_no=rs.getString("oth_contact_no");
				if(oth_contact_no ==null) oth_contact_no="&nbsp;";

				appt_no1 =rs.getString("appt_ref_no");

				sql4="select count(appt_ref_no) cnt from oa_resource_for_appt where appt_ref_no = '"+appt_no1+"' and FACILITY_ID='"+fac_id+"'";

			
				appt_no2="";
				rs1 = stmt1.executeQuery(sql4);
				if ( rs1 != null ){
					while(rs1.next()){	
						appt_no2=rs1.getString("cnt");
						
					}
				}

				if(rs1 !=null)rs1.close();
				showInstructionsYN="N";
				sql4="select *  from oa_appt_pat_instructions where facility_id='"+fac_id+"' and appt_ref_no='"+appt_no1+"'";
				rs1 = stmt1.executeQuery(sql4);
				if ( rs1 != null ){
					if(rs1!=null && rs1.next()){	
						showInstructionsYN="Y";					
					}
				}
				if(rs1 !=null)rs1.close();
				if(showInstructionsYN.equals("N")){
					sql4="select *  from oa_appt_proc_instructions where facility_id='"+fac_id+"' and appt_ref_no='"+appt_no1+"'";
					rs1 = stmt1.executeQuery(sql4);
					if ( rs1 != null ){
						if(rs1!=null && rs1.next()){	
							showInstructionsYN="Y";					
						}
					}
				}
				if(appt_no2==null) appt_no2 = "";
				rsource= rs.getString("RESOURCE_CLASS");
				if(rsource==null) rsource = "";
				String rsource_name="";

				if(rsource.equals("P"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(rsource.equals("R"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(rsource.equals("E"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(rsource.equals("O"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}


				practitioner_full_name =rs.getString("practitioner_full_name");
				if(practitioner_full_name==null) practitioner_full_name = "&nbsp;";
				
				String appt_status=rs.getString("appt_status")	;
				String appt_status_desc="";

				if(appt_status.equals("1"))
				{
				appt_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}else if(appt_status.equals("A"))
				{
				appt_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.VisitRegistered.label","oa_labels");
				}

				String gender_code=rs.getString("GENDER");
				String genderdesc="";

				 if(gender_code.equals("M")) 
				{
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender_code.equals("F")) {
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender_code.equals("U")) {
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}

				String appt_date=rs.getString("appt_date1");
				String appt_date_disp=DateUtils.convertDate(appt_date,"DMY","en",locale);

				String added_date=rs.getString("added_date");
				String added_date_disp=DateUtils.convertDate(added_date,"DMYHM","en",locale);

				String modified_date=rs.getString("modified_date");
				String modified_date_disp=DateUtils.convertDate(modified_date,"DMYHM","en",locale);

				
				p_name= rs.getString("PATIENT_NAME");
				
				
				order_catalog_code=rs.getString("ORDER_CATALOG_CODE");
				translator_override_reason=rs.getString("translator_override_reason")==null?"":rs.getString("translator_override_reason");
				String or_cat_desc="";
				String install_yn_val="";	
if(order_catalog_code ==null) order_catalog_code="";
					if ( !order_catalog_code.equals("") )
					{
				//String sql_OR="select Operational_yn from sm_modules_facility where facility_id = '"+facility+"' and module_id = 'OR' "; //Bru-HIMS-CRF-302 [IN:035020] 
				String sql_OR="select Operational_yn from sm_modules_facility where facility_id = ? and module_id = 'OR' "; //Bru-HIMS-CRF-302 [IN:035020] 
				//rs2=stmt1.executeQuery(sql_OR);
				pstmt = conn.prepareStatement(sql_OR);
				pstmt.setString(1,facility);
				rs2 = pstmt.executeQuery();
					if(rs2 !=null )
					{
						while (rs2.next())
						{
						install_yn_val=rs2.getString("Operational_yn");
						}

					}
					

			if(rs2 !=null)rs2.close();
				if(rs1 !=null)rs1.close();

					if(order_catalog_code ==null) order_catalog_code="";
					if(install_yn_val.equals("Y"))
				{
					String order_cat_or="select short_desc from OR_ORDER_CATALOG_lang_vw where 	 ORDER_CATALOG_CODE='"+order_catalog_code+"' and language_id='"+locale+"'";
					rs1 = stmt1.executeQuery(order_cat_or);
					if ( rs1 != null ){
						while(rs1.next()){	
							or_cat_desc=rs1.getString("short_desc");
							
						}
					}
				
				if (rs1 !=null)	 rs1.close();
				}
				}
				%>
				<tr>
				<% if(!appt_no2.equals("0") ){ %>
					<td nowrap class='<%=classValue%>' style="color:blue;cursor:pointer;" onclick="show_Reference_details('<%=appt_no1%>','<%=facility%>')"><%=appt_no1%></td><!-- Bru-HIMS-CRF-302 [IN:035020] -->
					<%
					appt_no2="";
				}else
				{	 %>
				<td nowrap class='<%=classValue%>'><%=rs.getString("appt_ref_no")%></td>
				<% } %>
					<%if (patientid.equals("")) {%>
					<td nowrap class='<%=classValue%>'><%=patient_id_one%></td>
					<td nowrap class='<%=classValue%>'><%=p_name%></td>
					<td nowrap class='<%=classValue%>'><%=genderdesc%></td>
					<td nowrap class='<%=classValue%>'><%=rs.getString("age")%></td>
					<%}else {%>
					<%}%>
					
				
				
				<td nowrap class='<%=classValue%>'><%=oth_contact_no%></td> 
				<td nowrap class='<%=classValue%>'>&nbsp<%=patientCatDesc%></td> 
				<td nowrap class='<%=classValue%>'><%=appt_date_disp%></td>
				<td nowrap class='<%=classValue%>'><%=rs.getString("appt_slab_from_time")%></td>
				<td nowrap class='<%=classValue%>'><%=rs.getString("appt_slab_to_time")%></td>
				<td nowrap class='<%=classValue%>'><%=rs.getString("appt_duration")%></td>
				<td nowrap style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%=rs.getString("visit_type_short_desc")%></td> <%/*modified for this CRF [Bru-HIMS-CRF-177]*/%>
				<td nowrap class='<%=classValue%>'><%=rs.getString("CARE_LOCN_TYPE_DESC")%>&nbsp;/&nbsp;<%=rs.getString("clinic_short_desc")%></td>
				<td nowrap class='<%=classValue%>'><%=rsource_name%>&nbsp;/&nbsp;<%=practitioner_full_name%></td>
				<td nowrap class='<%=classValue%>'><%=rs.getString("speciality_desc")%></td>
				<td nowrap class='<%=classValue%>'><%=or_cat_desc%>&nbsp;</td>	

				<td align='left' nowrap class='<%=classValue%>'>
				<%
				out.println(referralId);
				%>
				</td>	
				<%if(showInstructionsYN.equals("Y")){%>
				<td nowrap class='<%=classValue%>' style="color:blue;cursor:pointer;"  onclick="show_patinstructions('<%=appt_no1%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
				<%}else{%>
					<td nowrap class='<%=classValue%>'>&nbsp;</td>
				<%}%>
				<%if(rule_appl_yn.equals("Y")){%>
					<td nowrap class='<%=classValue%>'><%=translator_override_reason%></td>
				<%}%>
				<td nowrap class='<%=classValue%>'><%=rs.getString("added_by")%></td>
				<td nowrap class='<%=classValue%>'><%=added_date_disp%></td>
				<td nowrap class='<%=classValue%>'><%=appt_status_desc%></td>
				<td nowrap class='<%=classValue%>'><%=rs.getString("modified_by")%></td>
				<td nowrap class='<%=classValue%>'><%=modified_date_disp%></td>
				</tr>
					<%
				i++;
				maxRecord++;
			}// while

			%>
			<input type = 'hidden' name = 'patientid' value = '<%=patientid%>'>
			<input type = 'hidden' name = 'apptfromdate' value = '<%=apptfromdate%>'>
			<input type = 'hidden' name = 'appttodate' value = '<%=appttodate%>'>
			<input type = 'hidden' name = 'MODULE_ID' value = '<%=MODULE_ID%>'>
			<input type = 'hidden' name = 'orderCriteria_sensor' value = '<%=orderCriteria_sensor%>'>
			<input type = 'hidden' name = 'orderCriteria' value = 'apptno'>			
			<input type = 'hidden' name = 'asc_desc' value = '<%=asc_desc%>'>			
			<%
		}

		if(maxRecord == 0)
		{%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[2].location.href ='../../eCommon/html/blank.html' ;
		</script>
		<%}

		if ( maxRecord < 14 || (!rs.next()) ) {
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
				} else {%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}

	%>
	</table>
	<br><center>
	<%
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	  if((orderByClause != null) && (orderByClause.length() > 0))
		{
			orderByClause.delete(0,orderByClause.length());
		}
	
}catch ( Exception e ){
	//out.println("Exception QueryApptForPatientResult.jsp " + e);
	e.printStackTrace();
}
finally{

	ConnectionManager.returnConnection(conn,request);
}
%>
</center>

<%if(!module_id.equals("PH")){%>

	<script>
		parent.frames[1].document.forms[0].select.disabled=false;
	</script>
<%}%>
<script>
toggleGifs('<%=orderCriteria%>','<%=asc_desc%>')
</script>
</form>
</body>
</html>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
%>

