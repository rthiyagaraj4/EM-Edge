<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
     
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>
<html>
<head>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eOA/js/BulkTransferAppointment.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css'  href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%  
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	Statement stmt = null; 
	PreparedStatement pstmt=null;
	CallableStatement statement=null;
	CallableStatement cstmt = null;
	CallableStatement statement_bru = null;
	PreparedStatement pstmt_label = null;
	ResultSet rs32 = null;
	ResultSet rsps=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String appt_type_code1="";
	String visit_type_code[]=new String[0];
	

	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String bl_operational= (String)session.getValue("bl_operational");

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	Boolean isSlotStartMidEndAppl = false;
	String p_o_ext_slot_status = "";
	String p_o_reserved_slot_dtls = "";
	String p_o_appt_slot_dtls = "";
	String p_o_block_slot_dtls = "";
	String p_o_break_slot_dtls = "";
	String max_patients_per_slab = "";
	String max_non_ext_to_slots = "";
	String ext_all_slots_yn = "";
	String arrow_clicked_yn = "";
	String p_o_xt_status = "";
	String P_O_MAX_FORCED_BOOK = "";
	String P_O_FORCED_BOOK = "";
	String P_O_MAX_GLOBAL_BOOK = "";
	String P_O_GLOBAL_BOOK = "";

try{
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;	

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

	String locale=(String)session.getAttribute("LOCALE");
	String curr_user_id=(String)session.getValue("login_user");
	String from_speciality = request.getParameter("from_speciality") ;
	if(from_speciality ==null) from_speciality="";
	String to_speciality = request.getParameter("to_speciality") ;
	if(to_speciality ==null) to_speciality="";
	String locn_type=request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";
	String from_locn=request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";
	String to_locn=request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";
	String from_resc=request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";
	String to_resc=request.getParameter("to_resc");
	if(to_resc ==null) to_resc="";
	String from_date=request.getParameter("from_date");
	if(from_date ==null) from_date="";
	String to_date=request.getParameter("to_date");
	if(to_date ==null) to_date="";
	String from_res_class=request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";
	String to_res_class=request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";
	String oper_stn=request.getParameter("oper_stn");
	if(oper_stn ==null) oper_stn="";
	String from_page=request.getParameter("from_page");// out.println("from_page==>"+from_page);
	String time_table_type=request.getParameter("time_table_type");
	if(time_table_type ==null) time_table_type="";
	String reason_code_revision=request.getParameter("reason_code_revision");
	if(reason_code_revision ==null) reason_code_revision="";
	String sel_secondary=(String) session.getValue("SEC_RES_SEL");
	if(sel_secondary==null)sel_secondary="";
	String visit_limit_rule=request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="N";
	String last_slot_status="";

String sec_resources="";
String tmp_ref_no="";
	PreparedStatement stmtps=null;
	int max_patient			=0;
	int total_booked		=0;
	boolean normal_booking_allow_flag = true;
	boolean allow_revise=true;
	ArrayList arrLst=new ArrayList();
String holdArr[]=new String[5];
String P_O_CLINIC="",P_O_PRACTITIONER="",P_O_MAX_PAT="",P_O_MAX_OVER_BOOK="",P_O_BOOKED="",P_O_OVER_BOOKED="",P_O_OVER_BOOKING="N",P_O_TIME_TAB_TYPE="",P_O_STATUS="",P_O_FROM_TIME="",P_O_TO_TIME="",P_O_APPT_REF_NO="",P_O_PATIENT_NAME="",tmp_Hld_var="",P_O_END_TIME="",P_O_VISIT_TYPE_IND="",P_O_NO_OF_SLOTS="",P_O_Max_Forced="",P_O_Total_Forced="",P_O_Max_Global="",P_O_Total_Global="",P_O_PATIENT_ID="",book_appt_yn="",book_appt_wo_pid_yn="",obook_appt_yn="",book_appt_across_catg_yn="",tfr_appt_yn="",tfr_appt_across_catg_yn="",canc_appt_yn="",FORCED_BOOK_APPT_YN="",GLOBAL_BOOK_APPT_YN="",mode_find="",sys_date="",sys_time="",no_of_slots1="";
String P_APPT_OTH_DTL       ="";
String all_group_ids		= "";

//Below variable declare for this  [Bru-HIMS-CRF-177]	
String colour_indicator="";
String blkStatus="";
String blkRemark="";
String nowarp1 ="";
String capture_fin_dtls_yn="N";
int sec_cnt=0;



%>
		 </head>
<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' onscroll="scrollheader1()">
<form name="bulktransferapptresult1" id="bulktransferapptresult1" action='../../servlet/eOA.AppointmentDetailsServlet' method='post' target='messageFrame'>

	<table border="1" width="100%" cellspacing='0'  cellpadding='0' id='results1'>


<tr>
		
			<th class='COLUMNHEADER' ><div  id='head1' class='myClass' style='height:50px'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></div></th>
			<th class='COLUMNHEADER'  ><div  id='head2' width='12%' class='myClass' style='height:50px'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></div></th>
			<th class='COLUMNHEADER' ><div  id='head3' width='12%' class='myClass' style='height:50px'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
			<th class='COLUMNHEADER'  ><div  id='head4' width='12%' class='myClass' style='height:50px'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
			<th class='COLUMNHEADER' ><div  id='head5' class='myClass' style='height:50px'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></div></th>
			<th class='COLUMNHEADER' ><div  id='head6' class='myClass' style='height:50px'><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></div></th>
<%if(!from_page.equals("true"))
	{%>
			<th class='COLUMNHEADER' width='5%' ><div  id='head7' class='myClass' style='height:50px'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></div></th>
<%}%>
</tr>


<%

	/* Added for ML-BRU-CRF-0628.1 */
	if(isSlotStartMidEndAppl){
		cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
		cstmt.setString( 1, fac_id );
		cstmt.setString( 2, to_locn );
		cstmt.setString( 3, to_resc );
		cstmt.setString( 4, to_date );
		cstmt.registerOutParameter( 5, Types.VARCHAR );
		cstmt.registerOutParameter( 6, Types.VARCHAR );
		cstmt.registerOutParameter( 7, Types.VARCHAR );
		cstmt.registerOutParameter( 8, Types.VARCHAR );
		cstmt.registerOutParameter( 9, Types.VARCHAR );

		cstmt.execute() ;

		p_o_ext_slot_status = cstmt.getString( 5 ); 
		if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
		
		p_o_reserved_slot_dtls = cstmt.getString( 6 );
		if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

		p_o_appt_slot_dtls = cstmt.getString( 7 );
		if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

		p_o_block_slot_dtls = cstmt.getString( 8 );
		if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

		p_o_break_slot_dtls = cstmt.getString( 9 );
		if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
	}

	if(isSlotStartMidEndAppl){
		
		StringBuffer sql_label = new StringBuffer();

		sql_label.append("select time_table_type, max_patients_per_slab, max_patients_per_day - (nvl(ext_start_slots,0) + nvl(ext_mid_slots,0) + nvl(ext_end_slots,0)) max_non_ext_to_slots, ext_all_slots_yn, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, to_char(end_time,'hh24:mi')end_time, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");

		if(to_resc.equals("")){
			sql_label.append("practitioner_id is null ");
		}else{
			sql_label.append("practitioner_id = ?");
		}

		pstmt_label = con.prepareStatement(sql_label.toString());

		pstmt_label.setString(1,fac_id);
		pstmt_label.setString(2,to_date);
		pstmt_label.setString(3,to_locn);
		pstmt_label.setString(4,locn_type);
		pstmt_label.setString(5,to_res_class);
		if(!to_resc.equals("")){
			pstmt_label.setString(6,to_resc);
		}

		rs32 = pstmt_label.executeQuery();
		sql_label=null;

		if( rs32 !=null && rs32.next() ){

			P_O_TIME_TAB_TYPE = rs32.getString("time_table_type" );   

			max_patients_per_slab = rs32.getString("max_patients_per_slab");
			if(max_patients_per_slab==null) max_patients_per_slab="";

			max_non_ext_to_slots = rs32.getString("max_non_ext_to_slots");
			if(max_non_ext_to_slots==null) max_non_ext_to_slots="";

			ext_all_slots_yn = rs32.getString("ext_all_slots_yn");
			if(ext_all_slots_yn==null) ext_all_slots_yn="";

			P_O_MAX_PAT = rs32.getString("max_patients_per_day");
			if(P_O_MAX_PAT==null) P_O_MAX_PAT="";

			P_O_MAX_OVER_BOOK = rs32.getString("max_over_booking" );        
			if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";

			P_O_BOOKED = rs32.getString("total_slots_booked" );   
			if(P_O_BOOKED ==null) P_O_BOOKED="";

			P_O_OVER_BOOKED = rs32.getString( "total_slots_overbooked" );    
			if(P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";

			P_O_END_TIME = rs32.getString("end_time"); 
			if( P_O_END_TIME == null) P_O_END_TIME="";	

			P_O_MAX_FORCED_BOOK = rs32.getString("MAX_FORCED_IN_BOOKING");
			if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";

			P_O_FORCED_BOOK	= rs32.getString("TOTAL_FORCED_IN_BOOKED");
			if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

			P_O_MAX_GLOBAL_BOOK = rs32.getString("MAX_GLOBAL_BOOKING");
			if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";

			P_O_GLOBAL_BOOK	= rs32.getString("TOTAL_GLOBAL_BOOKED");
			if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";
		}
	}

	if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2")){

	

		statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		statement_bru.setString( 1, fac_id);
		statement_bru.setString( 2, to_locn);
		statement_bru.setString( 3, to_resc);
		statement_bru.setString( 4, to_date);
		statement_bru.registerOutParameter( 5, Types.CLOB );
		statement_bru.registerOutParameter( 6, Types.CLOB );
		statement_bru.registerOutParameter( 7, Types.CLOB );
		statement_bru.registerOutParameter( 8, Types.CLOB );
		statement_bru.registerOutParameter( 9, Types.CLOB );
		statement_bru.registerOutParameter(10, Types.CLOB );
		statement_bru.registerOutParameter(11, Types.CLOB );
		statement_bru.registerOutParameter(12, Types.CLOB );
		statement_bru.registerOutParameter(13, Types.CLOB );
		statement_bru.registerOutParameter(14, Types.CLOB );
		statement_bru.registerOutParameter(15, Types.CLOB );
		statement_bru.registerOutParameter(16, Types.CLOB );
		statement_bru.registerOutParameter(17, Types.CLOB );
		statement_bru.registerOutParameter(18, Types.CLOB );
		statement_bru.registerOutParameter(19, Types.CLOB );
		statement_bru.registerOutParameter(20, Types.CLOB );
		statement_bru.registerOutParameter(21, Types.CLOB );
		statement_bru.registerOutParameter(22, Types.CLOB );
		statement_bru.registerOutParameter(23, Types.CLOB );
		statement_bru.registerOutParameter(24, Types.CLOB );
		statement_bru.registerOutParameter(25, Types.CLOB );
		statement_bru.registerOutParameter(26, Types.CLOB );

		statement_bru.execute() ;

		
		P_O_CLINIC = to_locn;

		P_O_PRACTITIONER = to_resc;

		P_O_Max_Forced = P_O_MAX_FORCED_BOOK;

		P_O_Total_Forced = P_O_FORCED_BOOK;

		P_O_Max_Global = P_O_MAX_GLOBAL_BOOK;
			
		P_O_Total_Global = P_O_GLOBAL_BOOK;

		P_O_STATUS = statement_bru.getString(6); 
		if( P_O_STATUS == null) P_O_STATUS="";

		P_O_APPT_REF_NO = statement_bru.getString(7); 
		if( P_O_APPT_REF_NO == null) P_O_APPT_REF_NO="";
	
		P_O_PATIENT_NAME = statement_bru.getString(8); 
		if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";
	
		tmp_Hld_var = statement_bru.getString(9); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[0]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(10); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[1]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(12); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[2]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(17); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[3]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(13); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[4]=tmp_Hld_var;

		P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
		if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";

		P_O_PATIENT_ID = statement_bru.getString(15); 
		if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

		appt_type_code1 = statement_bru.getString(11); 
		if( appt_type_code1 == null) appt_type_code1="";

		P_APPT_OTH_DTL = statement_bru.getString(22); 
		if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

		P_O_FROM_TIME = statement_bru.getString(24);     
		if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

		P_O_TO_TIME = statement_bru.getString(25);	
		if(P_O_TO_TIME == null) P_O_TO_TIME="";

		P_O_NO_OF_SLOTS = statement_bru.getString(26); 
		if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	}
	/* End ML-BRU-CRF-0628.1 */
	

	if(from_page.equals("true") || from_page.equals(""))
	{
	if(isSlotStartMidEndAppl){
	if(!P_O_TIME_TAB_TYPE.equals("2")){

	
	statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	statement.setString( 1, fac_id);
	statement.setString( 2, to_date);
	statement.setString( 3, to_locn);
	statement.setString( 4, to_resc);
	statement.setString( 5, locn_type);
	statement.setString( 6, to_res_class);
	statement.registerOutParameter(7, Types.VARCHAR );
	statement.registerOutParameter(8, Types.VARCHAR );
	statement.registerOutParameter(9, Types.INTEGER);
	statement.registerOutParameter(10, Types.INTEGER);
	statement.registerOutParameter(11, Types.INTEGER);
	statement.registerOutParameter(12, Types.INTEGER);
	statement.registerOutParameter(13, Types.VARCHAR );
	statement.registerOutParameter(14, Types.VARCHAR );
	statement.registerOutParameter(15, Types.VARCHAR );
	statement.registerOutParameter(16, Types.VARCHAR );
	statement.registerOutParameter(17, Types.VARCHAR );
	statement.registerOutParameter(18, Types.VARCHAR );
	statement.registerOutParameter(19, Types.VARCHAR );
	statement.registerOutParameter(20, Types.VARCHAR );
	statement.registerOutParameter(21, Types.VARCHAR );
	statement.registerOutParameter(22, Types.VARCHAR );
	statement.registerOutParameter(23, Types.VARCHAR );
	statement.registerOutParameter(24 ,Types.VARCHAR );
	statement.registerOutParameter(25 ,Types.VARCHAR );
	statement.registerOutParameter(26 ,Types.VARCHAR );
	statement.registerOutParameter(27 ,Types.VARCHAR );
	statement.registerOutParameter(28 ,Types.VARCHAR );
	statement.registerOutParameter(29 ,Types.VARCHAR );
	statement.registerOutParameter(30 ,Types.VARCHAR );
	statement.registerOutParameter(31 ,Types.VARCHAR );
	statement.registerOutParameter(32 ,Types.VARCHAR );
	statement.registerOutParameter(33 ,Types.VARCHAR );
	statement.setString( 34, locale);
	statement.registerOutParameter(35 ,Types.VARCHAR );
	statement.registerOutParameter(36 ,Types.VARCHAR );
	statement.registerOutParameter(37 ,Types.VARCHAR );
	statement.registerOutParameter(38 ,Types.VARCHAR );
	statement.registerOutParameter(39 ,Types.VARCHAR );
	statement.registerOutParameter(40 ,Types.VARCHAR );
	statement.registerOutParameter(41 ,Types.VARCHAR );
	
	statement.execute() ;

	
	P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
	P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
	P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
	P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
	P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
	P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
	P_O_OVER_BOOKING        =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) 
	P_O_OVER_BOOKING="";
	P_O_TIME_TAB_TYPE          =statement.getString( 14 );if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";
	P_O_STATUS                    =statement.getString(15);if(P_O_STATUS == null) P_O_STATUS="";
	P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
	P_O_TO_TIME              =statement.getString( 17 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
	P_O_APPT_REF_NO         =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
	P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
	tmp_Hld_var                       =statement.getString( 20 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[0]=tmp_Hld_var;
	tmp_Hld_var                    =statement.getString( 21 );	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[1]=tmp_Hld_var;
	tmp_Hld_var    =statement.getString( 22 );        if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[2]=tmp_Hld_var;
	tmp_Hld_var                =statement.getString( 23 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[3]=tmp_Hld_var;
	tmp_Hld_var       =statement.getString( 24 );		if(tmp_Hld_var == null) tmp_Hld_var="";
	holdArr[4]=tmp_Hld_var;
	P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
	P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
	P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
	P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";

	P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
	P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";

	P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";	
	appt_type_code1=statement.getString(35); if( appt_type_code1 == null) appt_type_code1="";  //Added for this Line CRF-177
	P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

	}
	}else
	{

	
	statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	statement.setString( 1, fac_id);
	statement.setString( 2, to_date);
	statement.setString( 3, to_locn);
	statement.setString( 4, to_resc);
	statement.setString( 5, locn_type);
	statement.setString( 6, to_res_class);

	
	statement.registerOutParameter(7, Types.VARCHAR );
	statement.registerOutParameter(8, Types.VARCHAR );
	
	/*
	statement.registerOutParameter(7, Types.CLOB );
	statement.registerOutParameter(8, Types.CLOB );
	*/
	statement.registerOutParameter(9, Types.INTEGER);
	statement.registerOutParameter(10, Types.INTEGER);
	statement.registerOutParameter(11, Types.INTEGER);
	statement.registerOutParameter(12, Types.INTEGER);
	
	statement.registerOutParameter(13, Types.VARCHAR );
	statement.registerOutParameter(14, Types.VARCHAR );
	statement.registerOutParameter(15, Types.VARCHAR );
	statement.registerOutParameter(16, Types.VARCHAR );
	statement.registerOutParameter(17, Types.VARCHAR );
	statement.registerOutParameter(18, Types.VARCHAR );
	statement.registerOutParameter(19, Types.VARCHAR );
	statement.registerOutParameter(20, Types.VARCHAR );
	statement.registerOutParameter(21, Types.VARCHAR );
	statement.registerOutParameter(22, Types.VARCHAR );
	statement.registerOutParameter(23, Types.VARCHAR );
	statement.registerOutParameter(24 ,Types.VARCHAR );
	statement.registerOutParameter(25 ,Types.VARCHAR );
	statement.registerOutParameter(26 ,Types.VARCHAR );
	statement.registerOutParameter(27 ,Types.VARCHAR );
	statement.registerOutParameter(28 ,Types.VARCHAR );
	statement.registerOutParameter(29 ,Types.VARCHAR );
	statement.registerOutParameter(30 ,Types.VARCHAR );
	statement.registerOutParameter(31 ,Types.VARCHAR );
	statement.registerOutParameter(32 ,Types.VARCHAR );
	statement.registerOutParameter(33 ,Types.VARCHAR );

	/*
	statement.registerOutParameter(13, Types.CLOB );
	statement.registerOutParameter(14, Types.CLOB );
	statement.registerOutParameter(15, Types.CLOB );
	statement.registerOutParameter(16, Types.CLOB );
	statement.registerOutParameter(17, Types.CLOB );
	statement.registerOutParameter(18, Types.CLOB );
	statement.registerOutParameter(19, Types.CLOB );
	statement.registerOutParameter(20, Types.CLOB );
	statement.registerOutParameter(21, Types.CLOB );
	statement.registerOutParameter(22, Types.CLOB );
	statement.registerOutParameter(23, Types.CLOB );
	statement.registerOutParameter(24 ,Types.CLOB );
	statement.registerOutParameter(25 ,Types.CLOB );
	statement.registerOutParameter(26 ,Types.CLOB );
	statement.registerOutParameter(27 ,Types.CLOB );
	statement.registerOutParameter(28 ,Types.INTEGER );
	statement.registerOutParameter(29 ,Types.INTEGER);
	statement.registerOutParameter(30 ,Types.INTEGER );
	statement.registerOutParameter(31 ,Types.INTEGER );
	statement.registerOutParameter(32 ,Types.CLOB );
	statement.registerOutParameter(33 ,Types.CLOB );
	*/
	statement.setString( 34, locale);

	statement.registerOutParameter(35 ,Types.VARCHAR );
	statement.registerOutParameter(36 ,Types.VARCHAR );
	statement.registerOutParameter(37 ,Types.VARCHAR );
	statement.registerOutParameter(38 ,Types.VARCHAR );
	statement.registerOutParameter(39 ,Types.VARCHAR );
	statement.registerOutParameter(40 ,Types.VARCHAR );
	statement.registerOutParameter(41 ,Types.VARCHAR );
	
	/*
	statement.registerOutParameter(35 ,Types.CLOB );
	statement.registerOutParameter(36 ,Types.CLOB );
	statement.registerOutParameter(37 ,Types.CLOB );
	statement.registerOutParameter(38 ,Types.CLOB );
	statement.registerOutParameter(39 ,Types.CLOB );
	statement.registerOutParameter(40 ,Types.CLOB );
	*/


	statement.execute() ;

	System.err.println("After execute 347 get_day_status---in Param---fac_id-->"+fac_id+"  to_locn-->"+to_locn+"  to_resc-->"+to_resc+"  to_date-->"+to_date);
	
	P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
	P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
	P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
	P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
	P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
	P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
	P_O_OVER_BOOKING        =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) 
	P_O_OVER_BOOKING="";
	P_O_TIME_TAB_TYPE          =statement.getString( 14 );if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";
	P_O_STATUS                    =statement.getString(15);if(P_O_STATUS == null) P_O_STATUS="";
	P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
	P_O_TO_TIME              =statement.getString( 17 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
	P_O_APPT_REF_NO         =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
	P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
	tmp_Hld_var                       =statement.getString( 20 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[0]=tmp_Hld_var;
	tmp_Hld_var                    =statement.getString( 21 );	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[1]=tmp_Hld_var;
	tmp_Hld_var    =statement.getString( 22 );        if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[2]=tmp_Hld_var;
	tmp_Hld_var                =statement.getString( 23 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[3]=tmp_Hld_var;
	tmp_Hld_var       =statement.getString( 24 );		if(tmp_Hld_var == null) tmp_Hld_var="";
	holdArr[4]=tmp_Hld_var;
	P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
	P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
	P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
	P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";

	P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
	P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";

	P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";	
	appt_type_code1=statement.getString(35); if( appt_type_code1 == null) appt_type_code1="";  //Added for this Line CRF-177
	P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

	}

	

	
		/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
		StringTokenizer token1 = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");	   		
			int counter=token1.countTokens();
			int track=0;
			StringTokenizer token = new StringTokenizer(appt_type_code1, "|");			
			visit_type_code=new String[counter];			
			while (token.hasMoreTokens())			{   
				visit_type_code[track]=token.nextToken();
				track++;
				
			}
		//End [Bru-HIMS-CRF-177]

	}else
	{
	
	System.err.println("Before execute oa_bulk_appt_transfer---in Param---fac_id-->"+fac_id+"  from_locn-->"+from_locn+"  from_resc-->"+from_resc+"  from_date-->"+from_date+"  to_locn-->"+to_locn+"  to_resc-->"+to_resc+"  to_date-->"+to_date);

	statement=con.prepareCall("{call oa_bulk_appt_transfer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	statement.setString( 1, fac_id);
	statement.setString( 2, from_locn);
	statement.setString( 3, from_resc);
	statement.setString( 4, from_date);
	statement.setString( 5, to_locn);
	statement.setString( 6, to_resc);
	statement.setString( 7, to_date);
	statement.setString( 8, locale);
			
	statement.registerOutParameter(9, Types.VARCHAR );
	statement.registerOutParameter(10, Types.VARCHAR);
	statement.registerOutParameter(11, Types.VARCHAR);
	statement.registerOutParameter(12, Types.VARCHAR);
	statement.registerOutParameter(13, Types.VARCHAR);
	statement.registerOutParameter(14, Types.VARCHAR );
	statement.registerOutParameter(15, Types.VARCHAR );
	statement.registerOutParameter(16, Types.VARCHAR );
	statement.registerOutParameter(17, Types.VARCHAR );
	statement.registerOutParameter(18, Types.VARCHAR );
	statement.registerOutParameter(19, Types.VARCHAR );	
	statement.registerOutParameter(20, Types.VARCHAR );	
	statement.execute() ;

	System.err.println("After execute oa_bulk_appt_transfer---in Param---fac_id-->"+fac_id+"  from_locn-->"+from_locn+"  from_resc-->"+from_resc+"  from_date-->"+from_date+"  to_locn-->"+to_locn+"  to_resc-->"+to_resc+"  to_date-->"+to_date);

	P_O_FROM_TIME            =statement.getString( 9 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
	P_O_TO_TIME              =statement.getString( 10 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
	P_O_APPT_REF_NO         =statement.getString(11 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";

	P_O_PATIENT_ID=statement.getString(12); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";	
	P_O_PATIENT_NAME        =statement.getString( 13 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";

	tmp_Hld_var                       =statement.getString( 14 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[0]=tmp_Hld_var;

	tmp_Hld_var                    =statement.getString(15 );	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[1]=tmp_Hld_var;

	tmp_Hld_var                =statement.getString( 16 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[3]=tmp_Hld_var;

	P_O_STATUS                    =statement.getString(17);if(P_O_STATUS == null) P_O_STATUS="";
	p_o_xt_status                 =statement.getString(17);if(P_O_STATUS == null) P_O_STATUS="";

	tmp_Hld_var    =statement.getString( 18 );        if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[2]=tmp_Hld_var;

	tmp_Hld_var                =statement.getString( 19 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[4]=tmp_Hld_var;

	P_O_NO_OF_SLOTS = statement.getString(20); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	arrow_clicked_yn = "Y";

	}
					
		StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
			int counter=token.countTokens();


			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_TO_TIME, "|");
			String to_time[]=new String[counter];
			while (token.hasMoreTokens())
				{
				to_time[track]=token.nextToken();
				track++;
				}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_NAME, "|");
			String patient_name[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_name[track]=token.nextToken();
				track++;
				}
			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_ID, "|");
			String patient_id[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_id[track]=token.nextToken();
				track++;
				}
			for(int ij=0;ij<holdArr.length;ij++){
				token=null;
				track=0;
				String popArr[]=new String[counter];
				token = new StringTokenizer(holdArr[ij], "|");

				while (token.hasMoreTokens()){
					popArr[track]=token.nextToken();
					track++;
				}
				 arrLst.add(popArr);				 
			}


			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
			String visit_type_ind[]=new String[counter];
			while (token.hasMoreTokens())
			{
			visit_type_ind[track]=token.nextToken();
			track++;
			}
			token=null;
			track=0;
			token = new StringTokenizer(P_O_STATUS, "|");
			String status[]=new String[counter];
			String status1[]=new String[counter];
			while (token.hasMoreTokens())
			{
			status[track]=token.nextToken();
			status1[track]=status[track];
			track++;
			}
			last_slot_status=status[track-1].substring(0,2);
			token=null;
			track=0;
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
			track++;
			}
			token=null;
			track=0;
			token = new StringTokenizer(P_O_APPT_REF_NO, "|");
			String o_appt_ref_no[]=new String[counter];
			while (token.hasMoreTokens())
			{
			o_appt_ref_no[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_APPT_OTH_DTL, "|");
			String appt_ot_dtl[]=new String[counter];
			while (token.hasMoreTokens())
			{
			appt_ot_dtl[track]=token.nextToken();
			track++;
			}
	
	//String sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN from am_os_user_locn_access_vw  where facility_id='"+fac_id+"' and locn_code='"+from_locn+"'  and oper_stn_id='"+oper_stn+"' and appl_user_id='"+curr_user_id+"' and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";
	String sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";

		//rs = stmt.executeQuery(sql_access);
		pstmt = con.prepareStatement(sql_access);
		pstmt.setString(1,fac_id);
		pstmt.setString(2,from_locn);
		pstmt.setString(3,oper_stn);
		pstmt.setString(4,curr_user_id);
		rs = pstmt.executeQuery();
			if(rs !=null){
			while ( rs.next() )
			{
						book_appt_yn= rs.getString("book_appt_yn");
						if(book_appt_yn ==null) book_appt_yn="";
						book_appt_wo_pid_yn= rs.getString("book_appt_wo_pid_yn");
						if(book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
						obook_appt_yn= rs.getString("obook_appt_yn");
						if(obook_appt_yn ==null) obook_appt_yn="";
						book_appt_across_catg_yn= rs.getString("book_appt_across_catg_yn");
						if(book_appt_across_catg_yn ==null) book_appt_across_catg_yn="";
						tfr_appt_yn= rs.getString("tfr_appt_yn");
						if(tfr_appt_yn==null) tfr_appt_yn="";
						tfr_appt_across_catg_yn= rs.getString("tfr_appt_across_catg_yn");
						if(tfr_appt_across_catg_yn ==null) tfr_appt_across_catg_yn="";
						canc_appt_yn= rs.getString("canc_appt_yn");
						if(canc_appt_yn ==null) canc_appt_yn="";
						FORCED_BOOK_APPT_YN= rs.getString("FORCED_BOOK_APPT_YN");
						if(FORCED_BOOK_APPT_YN ==null) FORCED_BOOK_APPT_YN="";
						GLOBAL_BOOK_APPT_YN = rs.getString("GLOBAL_BOOK_APPT_YN");
						if(GLOBAL_BOOK_APPT_YN ==null) GLOBAL_BOOK_APPT_YN="";
			}
			}


		if(rs !=null) rs.close();
		if(mode_find !=null && mode_find.equals("revise")){
			
				if(max_patient!=0){
				if(max_patient==total_booked){
					if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N")){
					allow_revise=false;
					%>	
						<script>alert(getMessage('APPT_CAN_NOT_TRANS_OTH_CAT','OA'));</script>
					<%
					}
					else{%>
					<script>alert(getMessage('APPT_TRANS_OTH_CAT','OA'));</script>
					<%allow_revise=true;
					}
				}
				}
				else
				{
				allow_revise=true;
				}
		}



if(bl_operational.equals("Y"))
{
	
String Bl_sql="select CAPTURE_FIN_DTLS_YN FROM oa_param where module_id='OA'";

if (rsps!=null) rsps.close();
rsps   = stmt.executeQuery(Bl_sql) ;

while (rsps !=null && rsps.next()){
capture_fin_dtls_yn=rsps.getString("CAPTURE_FIN_DTLS_YN");
}

if(rsps !=null) rsps.close();

}


		if(allow_revise){

/*Below Code Added for this CRF [Bru-HIMS-CRF-177] */   
        java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,fac_id);			
       // End [Bru-HIMS-CRF-177] 	
				

		
		

String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
String modified_date_time="";
String visit_type_short_desc="";
String appt_type_code="";
String group_id="";

if(!P_O_STATUS.equals("NT|"))
{

if(!P_O_STATUS.equals("NR"))
{


for(int init=0;init<counter;init++)
{

same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];

}

if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;
if(!from_page.equals("true") )
	{
String sql_mod_date_time="select to_char (modified_date,'dd/mm/yyyy hh24:mi') modified_date,appt_type_code,TIME_TABLE_TYPE,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'en','2') visit_type_short_desc,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm,nvl(no_of_slots,0) no_of_slots,group_id from oa_appt where  facility_id='"+fac_id+"' and appt_ref_no='"+o_appt_ref_no[init]+"'";

rsps=stmt.executeQuery(sql_mod_date_time);
		if ( rsps != null && rsps.next()){	
				modified_date_time=rsps.getString("modified_date");
				if(modified_date_time ==null) modified_date_time="";
				appt_type_code=rsps.getString("appt_type_code");
				if(appt_type_code ==null) appt_type_code="";
				
				group_id=rsps.getString("group_id");
				if(group_id ==null) group_id="";

				sys_date=rsps.getString("sysdt");
				sys_time=rsps.getString("systm");
				no_of_slots1=rsps.getString("no_of_slots");

				visit_type_short_desc=rsps.getString("visit_type_short_desc");
				if(visit_type_short_desc ==null) visit_type_short_desc="";
			
		}
	}


%>
	

<tr>



<%
String u=from_time[init];
String z=status[init];
String z1=status1[init];
String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

String patient_id1=patient_id[init];
if(patient_id1.equals("~")) patient_id1="DUMMY_PATINETID";
String reason ="";

String reason1="";
if(!z.equals("-"))
	{

reason1=z.substring(0,2);

if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;
	}
if(rsps !=null) rsps.close();

String chk_blank_row_patient=patient_name[init];
 u=u.substring(0,5);
 u1=u1.substring(0,5);
	if( ! u .equals("~")) //u represents from_time
	{
	if(z.equals("FL") || z.equals("OL") || z.equals("VL")||z.equals("VT") || z.equals("TB") || z.equals("GB")||z.equals("XB")|| z.equals("FR") || z.equals("OB") || z.equals("XT") ||z1.equals("EF"))
		{

			if(!(mode_find.equals("revise")) || mode_find.equals(""))
			{
			
				if(chk_blank_row_patient.equals("~"))
					{ 
					
						if(book_appt_yn.equalsIgnoreCase("Y"))
						{
							if(slots > 0)
							{ 
								%>
								<%if(blkStatus.equals("B")){%>
										
											<td width="11%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>

										<%}else{%>
								<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
									<%}%>
								<%slots--;
								same_appt = "Y";
							}
							else
							{
					          if (z.equals("VT"))
								{%>
								<td width="11%" <%=nowarp1%>  class="<%=classValue%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>

								<%}
							   else{
								    if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
										<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
									<%}
									else{
										if(blkStatus.equals("B")){%>
										
											<td width="11%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
										<%}else{%>
								<td width="11%" <%=nowarp1%> class="<%=classValue%>" >						<%=u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
										<%}
									}
								   
							   }
							}
						}
						else 
						{
							if(book_appt_yn!=null && book_appt_yn.equalsIgnoreCase("N"))
							{ 
								if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
								   <td width="11%" <%=nowarp1%>  class="<%=classValue%>" ><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
								<%}else{
									if(blkStatus.equals("B")){%>
										
										<td width="11%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
									<%}else{%>
										<td width="11%" <%=nowarp1%>  class="<%=classValue%>" ><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
									<%}
								}
							}
						}
					}
					else
					{
                      if (z.equals("VT"))
						{%>
	  						<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
						<%}
					  else
						{
							if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
								<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%>"<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
							<%}else{
								if(blkStatus.equals("B")){%>
									
									<td width="11%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
								<%}else{%>
									<%if(z1.equals("OL*F")|| z1.equals("FR") || z1.equals("EF")){%>
										
										<td width="11%" <%=nowarp1%> class='OAFORCED'  Title='Forced Appointment'><%=u%></a> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
									<%}else if(z1.equals("OL*")){%>
																				
										
									<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
									
										
																						
									<%}else if(z1.equals("OL*M")){%>	
										<td width='11%' <%=nowarp1%> class="<%=classValue%>" ><%=u%> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>															
									<%}else{%>
										<%if(z.equals("VL")){%>
										<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
										<%}else{%>
										<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%=u%> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
										<%}%>								
									<%}%>
								<%}
							}
						}
						pat_name = patient_name[init];
						slots--;
					}
			}
			else
			{
					if(chk_blank_row_patient.equals("~"))
					{
						if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
							<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%= u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' > </td>
						<%}else{
							if(blkStatus.equals("B")){%>
								
								<td width="11%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
							<%}else{%>
								<td width="11%" <%=nowarp1%> class="<%=classValue%>" ><%= u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
							<%}
						}
					}
					else
					{%>
						<td width="11%" <%=nowarp1%>  class="<%=classValue%>" ><%= u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
					
					<%}
		   	}
		}
		else 
		{
			if(z.equals("RN") || z.equals("BR"))
			{%>
				<td width="11%" <%=nowarp1%> class='oablock'>
			
					<%=u%>
				
				<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
			<%}	
			else
			{
				if(z.equals("BN") ||z.equals("BL") )
				{%>
					
					<td width="11%" <%=nowarp1%>  class='oared'  title ="<%=reason%>">
				
						<%=u%> 
				
					<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
				<%}	
				else
				{%>
					<td width="11%" <%=nowarp1%>  class="<%=classValue%>" ><%=u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
				<%}
			}
		}
	}
	else
	{%>
		<td width="11%" <%=nowarp1%> class="<%=classValue%>">&nbsp; <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' ></td>
	<%}
				

if( ! u1 .equals("~"))
{
	
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")||z.equals("TB")|| z.equals("GB")||z.equals("XB")|| z.equals("FR") || z.equals("OB") || z.equals("XT") || z1.equals("EF"))
	{
		

		if(blkStatus.equals("B")){%>
		
			<td width="11%" <%=nowarp1%> class="OARED" title="<%=blkRemark%>"><%=u1%></td>
		<%}else{%>
			<%if(z1.equals("OL*F")||z1.equals("FR") || z1.equals("EF")){%>
				<td width="11%" <%=nowarp1%> class="OAFORCED" Title="Forced Appointment"><%=u1%></td>
			<%}else{%>
			
					<td width="11%" <%=nowarp1%> class="<%=classValue%>"><%=u1%></td>
				

			<%}%>

		<%}%>
	<%}
	else
	if(z.equals("RN")|| z.equals("BR"))
	{%>
		<td width="11%" <%=nowarp1%> class='oablock'><%=u1%></td>
	<%}
	else
	if(z.equals("BN")||z.equals("BL"))
	{%>
		
		<td width="11%" <%=nowarp1%> class='OARED'  title ="<%=reason%>"><%=u1%></td>
	<%}else
	{ %>
	<td width="11%" <%=nowarp1%> class="<%=classValue%>"><%=u1%></td>
	<%}
}
else{
	%>
	<td width="11%" <%=nowarp1%> class="<%=classValue%>">&nbsp;</td>
<%}
String dispArr2[]=(String []) arrLst.get(1);

String u32=dispArr2[init];



String u2=patient_name[init];
String pat_id=patient_id[init];

String dec_yn="N";
String act_yn="Y";
String sus_yn="N";


if(pat_id.equals("~")){
	pat_id="";
}else{

	stmtps=con.prepareStatement("select DECEASED_YN,ACTIVE_YN,SUSPEND_YN from mp_patient where patient_id='"+pat_id+"'");
	rsps=stmtps.executeQuery();
	if ( rsps != null && rsps.next()){	
		dec_yn=rsps.getString("DECEASED_YN");
		act_yn=rsps.getString("ACTIVE_YN");
		sus_yn=rsps.getString("SUSPEND_YN");


	}

	
	if (stmtps !=null) stmtps.close();
	if (rsps !=null) rsps.close();

	pat_id=pat_id+" , ";
}


	if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT") || z.equals("TB") || z.equals("GB") ||z.equals("XB")||  z.equals("BR") || z.equals("FR") || z.equals("OB")|| z.equals("BX") || z.equals("XT") || z1.equals("EF")){%>
			<td width='22%' <%=nowarp1%> class="<%=classValue%>"><%=pat_id%>&nbsp;<%=u2%>&nbsp;,<%=u32%></td>
		<%}else	{
			if(same_appt.equals("Y")){%>
				<td width='22%' <%=nowarp1%> class="<%=classValue%>">***</td>
			<%}else{%>
				
				<td width='22%' <%=nowarp1%> class='OARED'>&nbsp;</td>
			<%}
		}
	}else{
		if(same_appt.equals("Y")){%>
			<td width='22%' <%=nowarp1%> class="<%=classValue%>"><%=pat_name%></td>
		<%}	else{
			if(z.equals("BN")||z.equals("BL")){%>
				<td width='22%' class="<%=classValue%>"><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/>:&nbsp;<b><%=reason%></b></td> 
			<%}else{%>				 
				<td width='22%' class="<%=classValue%>">&nbsp;</td>
			<%}
			
		}
	}	
for(int kkk=3;kkk<arrLst.size();kkk++){
	int kkk1=0;
	if(kkk==3){
		kkk1=3;
	}else if(kkk==4) {
		kkk1=2;
	}else{
		kkk1=kkk;
	}
	
	String dispArr[]=(String []) arrLst.get(kkk1);

	String u3=dispArr[init];

	if( ! u3 .equals("~"))	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")||z.equals("TB") || z.equals("GB") ||z.equals("XB")|| z.equals("FR") || z.equals("OB")|| z.equals("BX") || z.equals("XT") || z1.equals("EF")){
		// Below "IF" conditions Added for this CRF [Bru-HIMS-CRF-177] 
		String vist_code="";
		 if(kkk1==3){	
           if(from_page.equals("true") || from_page.equals("")){                        
		   colour_indicator =checkForNull((String)hm.get(visit_type_code[init])); 
          }else{
		 
		    vist_code=checkForNull(appt_type_code);              
		   colour_indicator =checkForNull((String)hm.get(vist_code)); 
			}	   
                	 
		%> 
		<td width='12%' <%=nowarp1%>  style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%= u3%>&nbsp;</td>
		<%}if(kkk1==2){	%>
			<td width='13%' <%=nowarp1%> class="<%=classValue%>"><%=u3%>&nbsp;</td>
		<%}
		}else{%>			
			<td width='13%' class="<%=classValue%>">&nbsp;</td>
		<%}
	}else
	{%>			
			<td width='13%' class="<%=classValue%>">&nbsp;</td>
		<%
	}
}

// end JIth
//String sql="";

tmp_ref_no=o_appt_ref_no[init];

if(! P_APPT_OTH_DTL.equals("")){
	String oth_dtls=appt_ot_dtl[init];

	if(tmp_ref_no.equals("~")) tmp_ref_no="";
	sec_cnt=0;

	if(from_page.equals("true") || from_page.equals("")){
		StringTokenizer tmp_oth_dtl = new StringTokenizer(oth_dtls, "*");
		while (tmp_oth_dtl.hasMoreTokens())	{
			sec_cnt=Integer.parseInt(tmp_oth_dtl.nextToken());
			tmp_oth_dtl.nextToken();
			tmp_oth_dtl.nextToken();		
		}
	}
}else{

	if(!tmp_ref_no.equals("")){
		 String sql="select count(appt_ref_no) count from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+fac_id+"'";
			stmtps=con.prepareStatement(sql);
			rsps=stmtps.executeQuery();
			if ( rsps != null && rsps.next()){	
				sec_cnt=rsps.getInt("count");
			}
	}	

	if (stmtps !=null) stmtps.close();
	if (rsps !=null) rsps.close();
	
}
if(sec_cnt>0){ %>
<td width='18%' class="<%=classValue%>">
<a href="javascript:show_Reference_details_results('<%=tmp_ref_no%>','<%=fac_id%>')">
			<fmt:message key="Common.details.label" bundle="${common_labels}"/>
		</a>&nbsp;</td>
<%
}else
{%>
<td width='18%' class="<%=classValue%>">&nbsp;</td>

<%}

if(z.equals("XB") || z.equals("FL") || z.equals("BR") || z.equals("BX") || z.equals("XT") || (!z.equals("FR") && no_of_slots[init].equals("~")) || z1.equals("EF")) {
}else{
	if(dec_yn.equals("Y")){
		classValue="DECEASED";
	}else if (act_yn.equals("N")){
		classValue="INACTIVE";
	}else if (sus_yn.equals("Y")){
		classValue="SUSPENDED";
	}
}

if(!from_page.equals("true") )
	{
if(!time_table_type.equals("3"))
		{
	if(z.equals("XB") || z.equals("FL") || z.equals("BR") || z.equals("BX") || z.equals("XT") || (!z.equals("FR") && no_of_slots[init].equals("~")) || z1.equals("EF")) {
		
		


%>
		<td  class="<%=classValue%>">&nbsp;
		<input type="checkbox"  name='selectall' id='selectall' disabled></input>
		</td>

<%

	}else if(sec_cnt>0){ 
	
	//String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+fac_id+"' and visit_type_code='"+appt_type_code+"' and resource_class !='"+to_res_class+"'  order by resource_class ";
	String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id=? and visit_type_code=? and resource_class !=? order by resource_class ";

	if (rs1!=null) rs1.close();
	//rs1 = stmt.executeQuery(secsql);
	pstmt = con.prepareStatement(secsql);
	pstmt.setString(1,fac_id);
	pstmt.setString(2,appt_type_code);
	pstmt.setString(3,to_res_class);
	rs1 = pstmt.executeQuery();
	while(rs1!=null && rs1.next()){
	sec_resources=sec_resources+rs1.getString("resource_class");
	sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
	}
	if(sec_resources.length()>1)
	sec_resources=sec_resources.substring(0,sec_resources.length()-1);
			if(!sec_resources.equals("")){
		%>
	<%if(classValue.equals("DECEASED" ) || classValue.equals("SUSPENDED" ) || classValue.equals("INACTIVE" )){%>

		<td  class="<%=classValue%>" title="<%=classValue%>">&nbsp;

		<input type="checkbox"  name='selectall<%=init%>' id='selectall<%=init%>'onclick="show_second(this,'<%=sec_resources%>','<%=u%>','<%=u1%>','<%=patient_id1%>','<%=appt_type_code%>','<%=visit_type_short_desc%>','<%=init%>','<%=o_appt_ref_no[init]%>')" disabled></input>
		<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
		</td>
	<%}else{%>
		<%
		if(!group_id.equals("")){
			if(all_group_ids.equals("")){
				all_group_ids	= "Group_"+group_id;
			}else{
				all_group_ids	= all_group_ids+"|@|Group_"+group_id;
			}
		}
		
		%>

		<td  class="<%=classValue%>">&nbsp;

		<input type="checkbox"  name='selectall<%=init%>' id='selectall<%=init%>' <% if(!group_id.equals("")){ %> id='Group_<%=group_id%>'<%} %>  onclick="show_second(this,'<%=sec_resources%>','<%=u%>','<%=u1%>','<%=patient_id1%>','<%=appt_type_code%>','<%=visit_type_short_desc%>','<%=init%>','<%=o_appt_ref_no[init]%>')"></input>
		<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>'  value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
		</td>


	<%}%>



<% }else
{

}
		}else
{
			%>

<%if(classValue.equals("DECEASED" ) || classValue.equals("SUSPENDED" ) || classValue.equals("INACTIVE" )){%>
	<td  class="<%=classValue%>" title="<%=classValue%>">&nbsp;

	<input type="checkbox" disabled  name='selectall<%=init%>' id='selectall<%=init%>' onclick="selectvalue_main(this,'<%=sec_resources%>','<%=init%>')"></input>
	<input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
	</td>
<%}else{%>
	<td  class="<%=classValue%>">&nbsp;
		<%
			if(!group_id.equals("")){
				if(all_group_ids.equals("")){
					all_group_ids	= "Group_"+group_id;
				}else{
					all_group_ids	= all_group_ids+"|@|"+"Group_"+group_id;
				}
			}
			
		%>

	<input type="checkbox" checked  name='selectall<%=init%>' id='selectall<%=init%>'  <% if(!group_id.equals("")){ %> id='Group_<%=group_id%>'<%} %>    onclick="selectvalue_main(this,'<%=sec_resources%>','<%=init%>')"></input>
	<input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
	</td>

<%}%>
<%}
	}else
	{
if(z.equals("XB") || z.equals("FL") || z.equals("BR") || z.equals("XT")) {
		
%>
	<td  class="<%=classValue%>">&nbsp;
		<input type="checkbox"  name='selectall' id='selectall' disabled></input>
	</td>

<%

	}else if(sec_cnt>0){ 
	
	//String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+fac_id+"' and visit_type_code='"+appt_type_code+"' and resource_class !='"+to_res_class+"'  order by resource_class ";
	String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id=? and visit_type_code=? and resource_class !=? order by resource_class ";

	if (rs1!=null) rs1.close();
	//rs1 = stmt.executeQuery(secsql);
	pstmt = con.prepareStatement(secsql);
	pstmt.setString(1,fac_id);
	pstmt.setString(2,appt_type_code);
	pstmt.setString(3,to_res_class);
	rs1 = pstmt.executeQuery();
	while(rs1!=null && rs1.next()){
	sec_resources=sec_resources+rs1.getString("resource_class");
	sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
	}
	if(sec_resources.length()>1)
	sec_resources=sec_resources.substring(0,sec_resources.length()-1);
			if(!sec_resources.equals("")){
		%>
			<%if(classValue.equals("DECEASED" ) || classValue.equals("SUSPENDED" ) || classValue.equals("INACTIVE" )){%>

				<td  class="<%=classValue%>" title="<%=classValue%>">&nbsp;

				<input type="checkbox"  name='selectall<%=init%>' id='selectall<%=init%>' disabled onclick="show_second(this,'<%=sec_resources%>','<%=u%>','<%=u1%>','<%=patient_id1%>','<%=appt_type_code%>','<%=visit_type_short_desc%>','<%=init%>','<%=o_appt_ref_no[init]%>')"></input>
				<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
				</td>
			<%}else{%>

				<td  class="<%=classValue%>">&nbsp;
				<%
					if(!group_id.equals("")){
						if(all_group_ids.equals("")){
							all_group_ids	= "Group_"+group_id;
						}else{
							all_group_ids	= all_group_ids+"|@|"+"Group_"+group_id;
						}
					}
					
				%>

				<input type="checkbox"  name='selectall<%=init%>' id='selectall<%=init%>'  <% if(!group_id.equals("")){ %> id='Group_<%=group_id%>'<%} %>  onclick="show_second(this,'<%=sec_resources%>','<%=u%>','<%=u1%>','<%=patient_id1%>','<%=appt_type_code%>','<%=visit_type_short_desc%>','<%=init%>','<%=o_appt_ref_no[init]%>')"></input>
				<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
				</td>

			<%}%>


<% }else
{

}
		}else
{ %>
		<%if(classValue.equals("DECEASED" ) || classValue.equals("SUSPENDED" ) || classValue.equals("INACTIVE" )){%>

			<td  class="<%=classValue%>" title="<%=classValue%>">&nbsp;
			<input type="checkbox" disabled  name='selectall<%=init%>' id='selectall<%=init%>' onclick="selectvalue_main(this,'<%=sec_resources%>','<%=init%>')"></input>
			<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
			</td>
		<%}else{%>
			<%
			if(!group_id.equals("")){
				if(all_group_ids.equals("")){
					all_group_ids	= "Group_"+group_id;
				}else{
					all_group_ids	= all_group_ids+"|@|"+"Group_"+group_id;
				}
			}
			
			%>

			<td  class="<%=classValue%>">&nbsp;
			<input type="checkbox" checked  name='selectall<%=init%>' id='selectall<%=init%>' <% if(!group_id.equals("")){ %> id='Group_<%=group_id%>'<%} %>  onclick="selectvalue_main(this,'<%=sec_resources%>','<%=init%>')"></input>
			<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>|<%=u%>|<%=u1%>|<%=modified_date_time%>|<%=z%>|<%=patient_id1%>' >
			</td>


		<%}%>


<%}
	}
	}

}
		sec_cnt=0;
if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();%>
</tr>
<%
}
}else
{

%><script>alert(getMessage("BULK_CANNOT_TRANS","OA"))
	parent.parent.frames[2].document.location.href='../../eCommon/html/blank.html';
parent.parent.frames[3].document.location.href='../../eCommon/html/blank.html';</script><%
}
}else
{
%><script>alert(getMessage("SLOTS_MISMATCH_TRANSFER","OA"))
	parent.parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.parent.frames[3].document.location.href='../../eCommon/html/blank.html';</script><%

}
%>
<input type='hidden' name='function1' id='function1' value='bulktransfer'>
<input type='hidden' name='counter' id='counter' value=<%=counter%>>
<input type='hidden' name='speciality' id='speciality' value=<%=to_speciality%>>
<input type='hidden' name='from_speciality' id='from_speciality' value=<%=from_speciality%>>
<input type='hidden' name='locn_type' id='locn_type' value=<%=locn_type%>>
<input type='hidden' name='from_date' id='from_date' value=<%=from_date%>>
<input type='hidden' name='to_date' id='to_date' value=<%=to_date%>>
<input type='hidden' name='to_locn' id='to_locn' value=<%=to_locn%>>
<input type='hidden' name='from_locn' id='from_locn' value=<%=from_locn%>>
<input type='hidden' name='to_res_class' id='to_res_class' value=<%=to_res_class%>>
<input type='hidden' name='to_resc' id='to_resc' value=<%=to_resc%>>
<input type='hidden' name='from_resc' id='from_resc' value=<%=from_resc%>>
<input type='hidden' name='final_value' id='final_value' value=''>
<input type='hidden' name='appt_ref_num' id='appt_ref_num' value=''>
<input type='hidden' name='time_table_type' id='time_table_type' value='<%=time_table_type%>'>
<input type='hidden' name='reason_code_revision' id='reason_code_revision' value='<%=reason_code_revision%>'>
<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
<input type='hidden' name='no_of_slots' id='no_of_slots' value='<%=no_of_slots1%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='sys_time' id='sys_time' value='<%=sys_time%>'>
<input type='hidden' name='sec_value_count' id='sec_value_count' value=''>
<input type='hidden' name='sec_sel222' id='sec_sel222' value=''>
<input type='hidden' name='sec_sel' id='sec_sel' value=''>
<input type='hidden' name='sec_sel2' id='sec_sel2' value=''>
<input type='hidden' name='sel_secondary' id='sel_secondary' value='<%=sel_secondary%>'>
<input type='hidden' name='sec_resc_selec_final' id='sec_resc_selec_final' value=''>
<input type='hidden' name='episode_type' id='episode_type' value=''>
<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
<input type='hidden' name='to_max_slots' id='to_max_slots' value='<%=P_O_MAX_PAT%>'>
<input type='hidden' name='to_total_booked' id='to_total_booked' value='<%=P_O_BOOKED%>'>
<input type='hidden' name='to_booked_over_slots' id='to_booked_over_slots' value=<%=P_O_OVER_BOOKED%>>
<input type='hidden' name='to_max_over_booking' id='to_max_over_booking' value=<%=P_O_MAX_OVER_BOOK%>>
<input type='hidden' name='last_slot_status' id='last_slot_status' value=<%=last_slot_status%>>
<input type='hidden' name='all_group_ids' id='all_group_ids' id='all_group_ids' value='<%=all_group_ids%>'>

<!-- Added for ML-BRU-CRF-0628.1 -->
<input type="hidden" name="p_o_ext_slot_status" id="p_o_ext_slot_status" value="<%=p_o_ext_slot_status%>">
<input type="hidden" name="p_o_reserved_slot_dtls" id="p_o_reserved_slot_dtls" value="<%=p_o_reserved_slot_dtls%>">
<input type="hidden" name="p_o_appt_slot_dtls" id="p_o_appt_slot_dtls" value="<%=p_o_appt_slot_dtls%>">
<input type="hidden" name="p_o_block_slot_dtls" id="p_o_block_slot_dtls" value="<%=p_o_block_slot_dtls%>">
<input type="hidden" name="p_o_break_slot_dtls" id="p_o_break_slot_dtls" value="<%=p_o_break_slot_dtls%>">
<input type="hidden" name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
<input type="hidden" name="max_non_ext_to_slots" id="max_non_ext_to_slots" value="<%=max_non_ext_to_slots%>">
<input type="hidden" name="ext_all_slots_yn" id="ext_all_slots_yn" value="<%=ext_all_slots_yn%>">
<input type="hidden" name="arrow_clicked_yn" id="arrow_clicked_yn" value="<%=arrow_clicked_yn%>">
<input type="hidden" name="p_o_xt_status" id="p_o_xt_status" value="<%=p_o_xt_status%>">
<!-- End ML-BRU-CRF-0628.1 -->

</form>
<script>
	
/* Added for ML-BRU-CRF-0628.1 */
if (document.forms[0].isSlotStartMidEndAppl.value=='true'){

	var ext_slt=document.forms[0].p_o_ext_slot_status.value;
	var res_slt=document.forms[0].p_o_reserved_slot_dtls.value;
	var appt_slt=document.forms[0].p_o_appt_slot_dtls.value;
	var blk_slt=document.forms[0].p_o_block_slot_dtls.value;
	var brk_slt=document.forms[0].p_o_break_slot_dtls.value;
	var xt_status=document.forms[0].p_o_xt_status.value;
	var arrow_clicked_yn=document.forms[0].arrow_clicked_yn.value;


	var ext_slot_arr=ext_slt.split("|");
	var res_slot_arr=res_slt.split("|");
	var appt_slot_arr=appt_slt.split("|");
	var blk_slot_arr=blk_slt.split("|");
	var brk_slot_arr=brk_slt.split("|");
	var xt_status_arr=xt_status.split("|");


	for(var i=0;i<=ext_slot_arr.length;i++){
		
		if(arrow_clicked_yn !='Y')
		{
			if(ext_slot_arr[i]=='Y') {

				if(blk_slot_arr[i]=='N' && brk_slot_arr[i]=='N') {
					if(res_slot_arr[i] !='N'){
					
						document.getElementById("results1").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(1).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(0).style.Color = "Black";
						document.getElementById("results1").rows(i+1).cells(1).style.Color = "Black";
						document.getElementById("results1").rows(i+1).cells(2).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(2).innerText = "BRU Health Reservation : "+res_slot_arr[i];

					}else {
						document.getElementById("results1").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(1).style.backgroundColor = "Bisque";
					}
				}
			}
		}else
		{
			if(xt_status_arr[i]=='XT') {

				if(blk_slot_arr[i]=='N' && brk_slot_arr[i]=='N') {
					if(res_slot_arr[i] !='N'){
					
						document.getElementById("results1").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(1).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(0).style.Color = "Black";
						document.getElementById("results1").rows(i+1).cells(1).style.Color = "Black";
						document.getElementById("results1").rows(i+1).cells(2).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(2).innerText = "BRU Health Reservation : "+res_slot_arr[i];

					}else {
						document.getElementById("results1").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results1").rows(i+1).cells(1).style.backgroundColor = "Bisque";
					}
				}
			}
		}
	}
}
/* End ML-BRU-CRF-0628.1 */
</script>

<%

	if(stmt !=null) stmt.close();
	if (statement != null) statement.close();
	if (cstmt != null) cstmt.close();
	if (pstmt_label != null) pstmt_label.close();
	if (rs32 != null) rs32.close();
	if (statement_bru != null) statement_bru.close();

}catch(Exception es){
	//System.out.println("Exception in querycriteria"+ es.toString());
	es.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(con,request);
}		
%>
</body>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}


%>

