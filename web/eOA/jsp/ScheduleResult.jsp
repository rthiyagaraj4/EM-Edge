<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%	 
    // Modified for CRF - SRR -0425 -- Order Catalog.
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	session.putValue("Pat_id","N");
	String callingMode = request.getParameter("callingMode");//calling mode will be "OR" if called from pending order schedule
	if (callingMode==null) callingMode = "";
	String Date=(String)request.getParameter("Date");
	String end_date=(String)request.getParameter("end_date");
	int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	HashMap hm_month = new HashMap();
	hm_month.put("JAN","FEB");
	hm_month.put("FEB","MAR");
	hm_month.put("MAR","APR");
	hm_month.put("APR","MAY");
	hm_month.put("MAY","JUN");
	hm_month.put("JUN","JUL");
	hm_month.put("JUL","AUG");
	hm_month.put("AUG","SEP");
	hm_month.put("SEP","OCT");
	hm_month.put("OCT","NOV");
	hm_month.put("NOV","DEC");
	hm_month.put("DEC","JAN");
	//String dayValue[]={"","Su","Mo","Tu","We","Th","Fr","Sa"};
	int date=0;
	//int cou=0,count=0,date=0,dayStart=0,dat=0,flag=0,holidayCount=0,date11=0,month11=0,year11=0;
	String classValue="";
	//String dateStr="";
	String dateValue="";
	String tmpDate="";
	//String wk_day[] = {"S", "S", "M", "T", "W", "T", "F"};
	String wk_day[] = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	dateValue = request.getParameter("Date");
	String from_facility_id= request.getParameter("from_facility_id");
	if(from_facility_id ==null) from_facility_id="";
	String from_encounter_id= request.getParameter("from_encounter_id");
	if(from_encounter_id ==null) from_encounter_id="";
	String disp_ear_sch=(String)request.getParameter("disp_ear_sch");
	String start_sch_date = request.getParameter("start_sch_date");
	if(start_sch_date ==null) start_sch_date="";
	if (disp_ear_sch==null) disp_ear_sch="N";
	ArrayList arrLst=new ArrayList();
	String locale=(String)session.getAttribute("LOCALE");
	String facilityid=(String)session.getValue("facility_id");
	String ca_mode=(String)request.getParameter("ca_mode");
	String ca_patient_id=(String)request.getParameter("ca_patient_id");
	String pref_start_date=(String)request.getParameter("pref_start_date");
	if(pref_start_date == null || pref_start_date.equals(" ") || pref_start_date.equals("null")) pref_start_date="";
	String pref_end_date=(String)request.getParameter("pref_end_date");
	if(pref_end_date == null || pref_end_date.equals(" ") || pref_end_date.equals("null")) pref_end_date="";
	String visit_flag_OP=request.getParameter("visit_flag_OP");
		if(visit_flag_OP==null) visit_flag_OP="N";	
	String call_date_yn=(String)request.getParameter("call_date_yn");
	if(call_date_yn == null || call_date_yn.equals(" ") || call_date_yn.equals("null")) call_date_yn="";
	String oper_stn_id=(String)request.getParameter("oper_stn_id");
	if(oper_stn_id == null || oper_stn_id.equals(" ") || oper_stn_id.equals("null") ) oper_stn_id="";
	String clinic=(String)request.getParameter("clinic");
	if(clinic == null || clinic.equals(" ") || clinic.equals("null")) clinic="";
	String practitioner=(String)request.getParameter("practitioner");
	if(practitioner == null || practitioner.equals("null")) practitioner="";
	String practitioner_type =  request.getParameter("practitioner_type");
	practitioner_type = (practitioner_type==null)?"":practitioner_type;
	String speciality=(String)request.getParameter("speciality");
	if(speciality == null || speciality.equals("null")) speciality="";
	String visittype=(String)request.getParameter("visittype");
	if(visittype == null || visittype.equals("null")) visittype ="";
	String difference=(String)request.getParameter("Difference");
	int diff_in_no=Integer.parseInt(difference);
	String curr_user_id=(String)session.getValue("login_user");
	String hddSpeclty=(String)request.getParameter("hddSpeclty");
	String order_catalog_code=request.getParameter("order_catalog_code");//from pending order schedule
	if(order_catalog_code ==null) order_catalog_code="";
	String order_id=request.getParameter("order_id");
	if(order_id ==null) order_id="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null) order_line_num="";	
	String specialty_codema1=request.getParameter("specialty_codema1");
	if(specialty_codema1 ==null) specialty_codema1="";
	String calledFrom=request.getParameter("calledFrom");  //Added by Sathish.S for IN020026 on Monday, March 22, 2010 
	if(calledFrom ==null) calledFrom="";	
	String p_position="";
	String care_locn_ind=request.getParameter("care_locn_ind");
	String res_class=request.getParameter("res_class");
	String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");//from selecting order catalog in schedule appointment
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	String schedule_gender=request.getParameter("schedule_gender")==null?"":request.getParameter("schedule_gender"); //Added for this Line [Bru-HIMS-CRF-167]
	String from_OR=request.getParameter("from_OR");//from peding order  from_OR will be "Y"
	if(from_OR ==null) from_OR="N";
	String create_wait_list_yn=request.getParameter("create_wait_list_yn");
	if(create_wait_list_yn ==null) create_wait_list_yn="";
	if(care_locn_ind==null) care_locn_ind="";
	if(res_class==null) res_class="";
	String req_id=request.getParameter("req_id");
	if(req_id ==null) req_id="";
	String alcn_slot_visit="";
	String slot_appt_ctrl="";
	String visit_limit_rule="";
	String alcn_criteria="";
	String override_no_of_slots_yn="";
	String min_ela_per_resc_noshow_in_day="";
	String noshow_ctrl_by_splty_or_clinic="";
	String no_of_noshow_appts_for_alert ="";  
	String per_chk_for_no_show_alert =""; 	
	String from_page=request.getParameter("from_page");
	if(from_page ==null) from_page="";
	//these are for out put paramrters
	String  O_Clinic_Code    	 ="";
	String  O_Clinc_Name         ="";
	String  O_Clinc_long_Name         ="";
	String  O_Practitioner_I		="";
	String  O_Practitioner_N		="";
	String  O_Practitioner_full_N		="";
	String  O_Care_locn_ind		="";
	String  O_res_class		="";
	String strcode[]=null;
	String cr_locn_ind[]=null;
	String res_cls[]=null;
	String pos_clxn[]=null;
	String res_class_desc="";
	String care_locn_ind_desc="";
	String install_yn_val=request.getParameter("install_yn_val");
	if(install_yn_val ==null) install_yn_val="N";
	String capture_fin_dtls_yn="N";
	String contact_num_reqd_yn="N";
	//String practiioner_type1="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null) no_dwm="";
	String dwm_desc=request.getParameter("dwm_desc");
	if(dwm_desc ==null) dwm_desc="";	
	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
 	String patient_id_temp			= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix				= checkForNull(request.getParameter("name_prefix")); 
	String first_name				= checkForNull(request.getParameter("first_name")); 
	String second_name				= checkForNull(request.getParameter("second_name"));
	String third_name				= checkForNull(request.getParameter("third_name")); 
	String family_name				= checkForNull(request.getParameter("family_name"));
	String name_suffix				= checkForNull(request.getParameter("name_suffix")); 	
	String name_prefix_oth_lang				= checkForNull(request.getParameter("name_prefix_oth_lang")); 
	String first_name_oth_lang				= checkForNull(request.getParameter("first_name_oth_lang")); 
	String second_name_oth_lang				= checkForNull(request.getParameter("second_name_oth_lang"));
	String third_name_oth_lang				= checkForNull(request.getParameter("third_name_oth_lang")); 
	String family_name_oth_lang				= checkForNull(request.getParameter("family_name_oth_lang"));
	String name_suffix_oth_lang				= checkForNull(request.getParameter("name_suffix_oth_lang")); 
	String gender					= checkForNull(request.getParameter("gender")); 
	String contact_no				= checkForNull(request.getParameter("contact_no"));
	String language_code_temp		= checkForNull(request.getParameter("language_code_temp")); 
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String linking_code				= checkForNull(request.getParameter("linking_code"));
	String thai_date;
	thai_date = com.ehis.util.DateUtils.convertDate(request.getParameter("Date"),"DMY","en",locale);
	int month=0,year=0;
	StringTokenizer strToken=new StringTokenizer(dateValue,"/");
	String tmp_mon="";
	String tmp_mon1="";
	String add_lgc="";
	String tmp_yr="";
	int lapse_days=0;
	String check_flg="N";
	String out3 = "";
	String out4 = "";
	if(strToken.hasMoreTokens()){
		date=Integer.parseInt(strToken.nextToken());
		month=Integer.parseInt(strToken.nextToken());
		year=Integer.parseInt(strToken.nextToken());
	}
	if(month==2){
		if(year%100==0&&year%400==0){
			arr[month]=arr[month]+1;
			//eOT.LogFile.log("OTDebugger","Workinghere",this);
		}else if((year%100)!=0&&(year%4)==0){
			arr[month]=arr[month]+1;
			//eOT.LogFile.log("OTDebugger","Workinghere1",this);
		}
	}
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eOA/js/Validate1.js" language="JavaScript"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><!--@UAT-3-->
		<script>
			function assign(){
				if(parent.frames[1].document.getElementById('calender3')){
					var result1frame = parent.document.getElementById("result1").contentDocument;
					
					var tab1= document.getElementById("divTitleTable1");
					var tab2=document.getElementById("divTitleTable");
					var tab3=document.getElementById("divTitleTable23");
					var topValue=4;
					var widthValue=400;
					if (typeof(tab1) != 'undefined' && tab1 != null)
					{
						tab1.style.top=topValue+"px";
						tab1.style.left="0px";
						tab1.style.width=widthValue+"px";
						tab1.style.visibility='visible';
					}
					if (typeof(tab2) != 'undefined' && tab2 != null)
					{
						tab2.style.top="0px"; //4px
						tab2.style.left=widthValue+"px";
						tab2.style.width="713px";
						tab2.style.visibility='visible';
					}
					if (typeof(tab3) != 'undefined' && tab3 != null)
					{
						tab3.style.top="65px";
						tab3.style.left="0px";
						tab3.style.width=widthValue+"px";
						tab3.style.visibility='visible';
						tab3.style.position='absolute';
					}					
				}
				if (parent.frames[1].document.getElementById('calender3') != null){
					parent.parent.frames[1].document.forms[0].prefenddate.value=parent.parent.frames[1].document.schedule_appointment.p_to.value;
				}
				if (parent.frames[1].document.getElementById('calender3') != null){
					parent.parent.frames[1].document.forms[0].prefdate.value=parent.parent.frames[1].document.schedule_appointment.p_from.value;
				}
			}
			function scrollTitle(){
				var tab1=document.getElementById("divTitleTable1");
				var tab2=document.getElementById("divTitleTable");
				var tab3=document.getElementById("divTitleTable23");
				var widthValue=400;
				var x = document.body.scrollLeft;
				var y = document.body.scrollTop;
				if(x>0){
					tab1.style.left=(x-4)+"px";
					tab3.style.left=(x-4)+"px";
				}else{
					tab1.style.left="0px";
					tab3.style.left="0px";
					x=0;
				}if(y>0){		
					tab1.style.top=(y-5)+"px";
					tab2.style.top=(y-5)+"px";
				}else{
					tab1.style.top="0px"; //4px
					tab2.style.top="0px"; //4px
					y=4;
				}
			}
		</script>
	</head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<body onLoad='assign();' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onscroll="scrollTitle()">
	<%
		Connection con = null;
		CallableStatement statement =null;
		CallableStatement statement2 = null;
		Statement stmt =null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{			
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			//String sql_date="select to_char(to_date('"+dateValue+"','dd/mm/yyyy'),'D') from dual";
			//rs=stmt.executeQuery(sql_date);
			//if(rs !=null && rs.next()){
				//dayStart=Integer.parseInt(rs.getString(1));
			//}
			//below lines modified by Kamatchi S for security issue against COMMON-ICN-0165
			//alcn_slot_visit="select slot_appt_ctrl,visit_limit_rule,ALCN_CRITERIA,override_no_of_slots_yn,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT,	(select last_day(to_date('"+pref_start_date+"','dd/mm/yyyy'))-to_date('"+pref_start_date+"','dd/mm/yyyy') laspse_days from dual) lapse_days from oa_param where module_id='OA'";
			//rs=stmt.executeQuery(alcn_slot_visit);
			alcn_slot_visit="select slot_appt_ctrl,visit_limit_rule,ALCN_CRITERIA,override_no_of_slots_yn,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT,	(select last_day(to_date(?,'dd/mm/yyyy'))-to_date(?,'dd/mm/yyyy') laspse_days from dual) lapse_days from oa_param where module_id='OA'";
			 pstmt=con.prepareStatement(alcn_slot_visit);
			 pstmt.setString(1, pref_start_date);
		     pstmt.setString(2, pref_start_date);
			 rs = pstmt.executeQuery();
			if(rs !=null && rs.next()){
				//dayStart=Integer.parseInt(rs.getString("sysdt"));
				slot_appt_ctrl   = rs.getString("slot_appt_ctrl");
				visit_limit_rule = rs.getString("visit_limit_rule");
				alcn_criteria= rs.getString("ALCN_CRITERIA")==null?"":rs.getString("ALCN_CRITERIA");
				override_no_of_slots_yn=rs.getString("override_no_of_slots_yn");
				if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";
				capture_fin_dtls_yn=rs.getString("CAPTURE_FIN_DTLS_YN");
				min_ela_per_resc_noshow_in_day=rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY");
				if(min_ela_per_resc_noshow_in_day==null) min_ela_per_resc_noshow_in_day="";
				noshow_ctrl_by_splty_or_clinic=rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC");
				if(noshow_ctrl_by_splty_or_clinic==null) noshow_ctrl_by_splty_or_clinic="";
				contact_num_reqd_yn=rs.getString("CONTACT_NUM_REQD_YN");
				no_of_noshow_appts_for_alert=rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
				if(no_of_noshow_appts_for_alert==null)   no_of_noshow_appts_for_alert=""; 
				per_chk_for_no_show_alert=rs.getString("PER_CHK_FOR_NO_SHOW_ALERT");
				if(per_chk_for_no_show_alert==null)   per_chk_for_no_show_alert="";	
				lapse_days=rs.getInt("lapse_days");
			}		
			if(rs !=null) rs.close();
			//statement2=con.prepareCall("{call get_schedule_status_hdr( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			if( position.equals("") &&  addtl_splty.equals("")){
				statement2=con.prepareCall("{call oa_schedules.get_status_hdr( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}else{
				statement2=con.prepareCall("{call oa_schedules.get_status_hdr_SRR( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			System.out.println(" ********************** Inside Schedule Result 319 \n "
					+" \n Date : "+Date
					+" \n end_date : "+end_date
					+" \n diff_in_no : "+diff_in_no
					+" \n pref_start_date : "+pref_start_date
					+" \n pref_end_date : "+pref_end_date
					+" \n call_date_yn : "+call_date_yn
					+" \n disp_ear_sch : "+disp_ear_sch
					+" \n facilityid : "+facilityid					
					+" \n speciality : "+speciality
					+" \n practitioner : "+practitioner
					+" \n clinic : "+clinic
					+"  ********************** ");
			statement2.setString( 1,	Date ) ;
			statement2.setString( 2,	end_date ) ;
			statement2.setInt(3,	diff_in_no );
			statement2.setString( 4,	pref_start_date ) ;
			statement2.setString( 5,	pref_end_date ) ;
			statement2.setString(6,	call_date_yn );
			statement2.setString(7,	disp_ear_sch );
			statement2.setString(8,	facilityid );			
			statement2.setString(9,	speciality );
			//statement2.setString(9,			"04,13" );
			statement2.setString(10,	practitioner );
			statement2.setString(11,	clinic );
			statement2.registerOutParameter(12,	Types.VARCHAR ) ;
			statement2.registerOutParameter(13,	Types.VARCHAR ) ;
			statement2.registerOutParameter(14,	Types.VARCHAR ) ;
			statement2.registerOutParameter(15,	Types.VARCHAR ) ;
			statement2.registerOutParameter(16,	Types.VARCHAR ) ;
			statement2.registerOutParameter(17,	Types.VARCHAR ) ;
			if(! position.equals("") || !addtl_splty.equals("")){			
				statement2.setString(18,	position );
				statement2.setString(19,	addtl_splty );
				statement2.setString(20,	term_set_id );
				statement2.setString(21,	linking_code );		
				statement2.setString(22,	schedule_gender);
				statement2.setString(23,	rd_appt_yn);
			}else{
				statement2.setString(18,	term_set_id );
				statement2.setString(19,	linking_code );	
				statement2.setString(20,	schedule_gender);	
				statement2.setString(21,	rd_appt_yn);	
			}
			statement2.execute() ;
			String out1= statement2.getString( 14 );
			String out2=statement2.getString( 15 );
			String day1=statement2.getString( 16 );
			out3=statement2.getString( 12 );
			out4=statement2.getString( 13 );
			String monthname=statement2.getString( 17 );
			if (out1==null) out1="";
			if (out2==null) out2="";
			if (out3==null) out3="";
			if (out4==null) out4="";
			if (day1==null) day1="";
			String tempStr=null;
			if (!((monthname==null)||monthname.equals("null")|| monthname.equals(""))){
				StringTokenizer d_token = new StringTokenizer(out1, "|");
				int d_counter=d_token.countTokens();
				String d_code[]=new String[d_counter];
				int d_track=0;
				while (d_token.hasMoreTokens()){
					d_code[d_track]=d_token.nextToken();
					d_track++;
				}			
				d_token=null;
				d_track=0;
				d_token = new StringTokenizer(day1, "|");
				String d_day[]=new String[d_token.countTokens()];
				while (d_token.hasMoreTokens()){				
					d_day[d_track]=d_token.nextToken();
					d_track++;
				}
				d_token=null;
				d_track=0;
				d_token = new StringTokenizer(monthname, "|");
				String d_mon[]=new String[d_token.countTokens()];
				while (d_token.hasMoreTokens()){
					d_mon[d_track]=d_token.nextToken();
					d_track++;
				}

				d_token=null;
				d_token = new StringTokenizer(out2, "|");			
				String d_code2[]=new String[d_token.countTokens()];
				int d_track2=0;
				while (d_token.hasMoreTokens()){
					tempStr=d_token.nextToken();	
					//if(tempStr!=null && !tempStr.equals("~")){
						d_code2[d_track2]=tempStr;
					//}
					if(d_track2==1){
						tmp_mon=d_code2[d_track2].substring(0,3);	
						tmp_yr=d_code2[d_track2].substring(4,8);
					}
					if(d_track2==3 && !d_code2[d_track2].equals("~")){					
						tmp_mon1=(String) hm_month.get(tmp_mon);
						tmp_mon=d_code2[d_track2].substring(0,3);
						if(!tmp_mon1.equals(tmp_mon)){
							add_lgc="Y";
							d_code2[d_track2]=tmp_mon1+" "+tmp_yr;
						}
					}else if(diff_in_no == -1 || diff_in_no == 1){					
						if(d_track2==1){
							tmp_mon=d_code2[d_track2].substring(0,3);						
						}	
						if(d_track2==3){
							tmp_mon1=(String) hm_month.get(tmp_mon);
							add_lgc="Y";
							//d_code2[d_track2]=tmp_mon1+" "+tmp_yr;
						}

					}else if(diff_in_no == 0 && d_code2[d_track2].equals("~")){
						check_flg="Y";
						if(d_track2==1){
							tmp_mon=d_code2[d_track2].substring(0,3);							
						}
						if(d_track2==3){
							tmp_mon1=(String) hm_month.get(tmp_mon);
							add_lgc="Y";
							//d_code2[d_track2]=tmp_mon1+" "+tmp_yr;
						}

					}
					d_track2++;
				}
				String cc3=d_code2[2];
				if(cc3.equals("~")) cc3="0";
				//int d_diff=Integer.parseInt(d_code2[0]);
				int d_diff=0;
				//int d_diff=Integer.parseInt(d_code2[0]);
				int d_diff1=0;
				if (difference.equals("0")) start_sch_date = d_code[0];
				try{
					//statement=con.prepareCall("{call get_schedule_status(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
					if(position.equals("") && addtl_splty.equals("")){
						statement=con.prepareCall("{call oa_schedules.get_status(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
					}else{
						statement=con.prepareCall("{call oa_schedules.get_status_SRR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
					}
					
					System.out.println(" ********************** Inside Schedule Result 458 \n "
							+" \n facilityid : "+facilityid
							+" \n oper_stn_id : "+oper_stn_id
							+" \n curr_user_id : "+curr_user_id
							+" \n care_locn_ind : "+care_locn_ind
							+" \n speciality : "+speciality
							+" \n clinic : "+clinic
							+" \n visittype : "+visittype
							+" \n res_class : "+res_class					
							+" \n practitioner : "+practitioner
							+" \n d_code[0] : "+d_code[0]
							+" \n d_code[d_counter-1] : "+d_code[d_counter-1]
							+" \n care_locn_ind : "+care_locn_ind
							+" \n res_class : "+res_class
							+" \n order_catalog_code : "+order_catalog_code					
							+" \n locale : "+locale
							+"  ********************** ");
					
					
					statement.setString( 1,	facilityid ) ;
					statement.setString( 2,	oper_stn_id ) ;
					statement.setString( 3,	curr_user_id);
					if(care_locn_ind.equals("Y"))care_locn_ind="D";			
					if(callingMode.equals("OP") || callingMode.equals("IP")){
						if(clinic.length()==0)
						{
							speciality=hddSpeclty;
						}
						
					}
					if(callingMode.equals("OR") )
					{
					if(clinic.length()==0)
						{
							speciality=specialty_codema1;
						}
					}
					statement.setString( 4,	speciality);
					//statement.setString( 4,	"04,13");
					statement.setString( 5,	clinic);
					statement.setString( 6,	visittype);
					statement.setString( 7,	res_class);
					statement.setString( 8,	practitioner);
					statement.setString( 9,	d_code[0]);
					statement.setString( 10,d_code[d_counter-1]);
					statement.setString( 11,care_locn_ind);
					//statement.setString( 11,"C");
					statement.setString( 12,res_class);
					if(callingMode.equals("OR"))
					{
					statement.setString( 13,order_catalog_code);
					}else
					{
					statement.setString( 13,or_catalogue_code);
					}
					statement.setString( 14,	locale);			
					statement.registerOutParameter(15,	Types.VARCHAR ) ;
					statement.registerOutParameter(16,	Types.VARCHAR ) ;
					statement.registerOutParameter(17,	Types.VARCHAR ) ;
					statement.registerOutParameter(18,	Types.VARCHAR ) ;
					statement.registerOutParameter(19,	Types.VARCHAR ) ;
					statement.registerOutParameter(20,	Types.VARCHAR ) ;
					statement.registerOutParameter(21,	Types.VARCHAR ) ;
					statement.registerOutParameter(22,	Types.VARCHAR ) ;
					statement.registerOutParameter(23,	Types.VARCHAR ) ;
					statement.registerOutParameter(24,	Types.VARCHAR ) ;
					statement.registerOutParameter(25,	Types.VARCHAR ) ;
					statement.registerOutParameter(26,	Types.VARCHAR ) ;
					statement.registerOutParameter(27,	Types.VARCHAR ) ;
					statement.registerOutParameter(28,	Types.VARCHAR ) ;
					statement.registerOutParameter(29,	Types.VARCHAR ) ;
					statement.registerOutParameter(30,	Types.VARCHAR ) ;
					statement.registerOutParameter(31,	Types.VARCHAR ) ;
					statement.registerOutParameter(32,	Types.VARCHAR ) ;
					statement.registerOutParameter(33,	Types.VARCHAR ) ;
					statement.registerOutParameter(34,	Types.VARCHAR ) ;
					statement.registerOutParameter(35,	Types.VARCHAR ) ;
					statement.registerOutParameter(36,	Types.VARCHAR ) ;
					statement.registerOutParameter(37,	Types.VARCHAR ) ;
					statement.registerOutParameter(38,	Types.VARCHAR ) ;
					statement.registerOutParameter(39,	Types.VARCHAR ) ;
					statement.registerOutParameter(40,	Types.VARCHAR ) ;
					statement.registerOutParameter(41,	Types.VARCHAR ) ;
					statement.registerOutParameter(42,	Types.VARCHAR ) ;
					statement.registerOutParameter(43,	Types.VARCHAR ) ;
					statement.registerOutParameter(44,	Types.VARCHAR ) ;
					statement.registerOutParameter(45,	Types.VARCHAR ) ;
					statement.registerOutParameter(46,	Types.VARCHAR ) ;
					statement.registerOutParameter(47,	Types.VARCHAR ) ;
					statement.registerOutParameter(48,	Types.VARCHAR ) ;
					statement.registerOutParameter(49,	Types.VARCHAR ) ;
					statement.registerOutParameter(50,	Types.VARCHAR ) ;
					statement.registerOutParameter(51,	Types.VARCHAR ) ;
					statement.registerOutParameter(52,	Types.VARCHAR ) ;
					statement.registerOutParameter(53,	Types.VARCHAR ) ;
					if(! position.equals("") || !addtl_splty.equals("")){
						statement.setString( 54,	position);
						statement.setString( 55,	addtl_splty);
						statement.setString(56,	term_set_id );
						statement.setString(57,	linking_code );	
						statement.setString(58,	schedule_gender);
						statement.setString(59,	rd_appt_yn);
					}else{
						statement.setString(54,	term_set_id );
						statement.setString(55,	linking_code );	
						statement.setString(56,	schedule_gender);	  //Added for this line [Bru-HIMS-CRF-167]				
						statement.setString(57,	rd_appt_yn);	 			
					}
					/*
					statement.registerOutParameter(15,	Types.CLOB ) ;
					statement.registerOutParameter(16,	Types.CLOB ) ;
					statement.registerOutParameter(17,	Types.CLOB ) ;
					statement.registerOutParameter(18,	Types.CLOB ) ;
					statement.registerOutParameter(19,	Types.CLOB ) ;
					statement.registerOutParameter(20,	Types.CLOB ) ;
					statement.registerOutParameter(21,	Types.CLOB ) ;
					statement.registerOutParameter(22,	Types.CLOB ) ;
					statement.registerOutParameter(23,	Types.CLOB ) ;
					statement.registerOutParameter(24,	Types.CLOB ) ;
					statement.registerOutParameter(25,	Types.CLOB ) ;
					statement.registerOutParameter(26,	Types.CLOB ) ;
					statement.registerOutParameter(27,	Types.CLOB ) ;
					statement.registerOutParameter(28,	Types.CLOB ) ;
					statement.registerOutParameter(29,	Types.CLOB ) ;
					statement.registerOutParameter(30,	Types.CLOB ) ;
					statement.registerOutParameter(31,	Types.CLOB ) ;
					statement.registerOutParameter(32,	Types.CLOB ) ;
					statement.registerOutParameter(33,	Types.CLOB ) ;
					statement.registerOutParameter(34,	Types.CLOB ) ;
					statement.registerOutParameter(35,	Types.CLOB ) ;
					statement.registerOutParameter(36,	Types.CLOB ) ;
					statement.registerOutParameter(37,	Types.CLOB ) ;
					statement.registerOutParameter(38,	Types.CLOB ) ;
					statement.registerOutParameter(39,	Types.CLOB ) ;
					statement.registerOutParameter(40,	Types.CLOB ) ;
					statement.registerOutParameter(41,	Types.CLOB ) ;
					statement.registerOutParameter(42,	Types.CLOB ) ;
					statement.registerOutParameter(43,	Types.CLOB ) ;
					statement.registerOutParameter(44,	Types.CLOB ) ;
					statement.registerOutParameter(45,	Types.CLOB ) ;
					statement.registerOutParameter(46,	Types.CLOB ) ;
					statement.registerOutParameter(47,	Types.CLOB ) ;
					statement.registerOutParameter(48,	Types.CLOB ) ;
					statement.registerOutParameter(49,	Types.CLOB ) ;
					statement.registerOutParameter(50,	Types.CLOB ) ;
					statement.registerOutParameter(51,	Types.CLOB ) ;
					statement.registerOutParameter(52,	Types.CLOB ) ;
					statement.registerOutParameter(53,	Types.CLOB ) ;
					*/
					statement.execute() ;
					O_Clinic_Code=statement.getString( 15 );
					O_Clinc_Name =statement.getString( 16 );
					O_Clinc_long_Name =statement.getString( 50 );
					O_Practitioner_I=statement.getString( 17);
					O_Practitioner_N=statement.getString( 18);
					O_Practitioner_full_N=statement.getString( 49);
					O_Care_locn_ind=statement.getString( 51);
					O_res_class=statement.getString( 52);
					p_position=statement.getString( 53);
				}catch(Exception e){
					e.printStackTrace();
					//out.println("exception in schedule result line559" + e.toString());
				}	
				if(O_Clinic_Code!=null && (!(O_Clinic_Code.equals("null")) || !(O_Clinic_Code.equals("")))){
					String  O_Date_Status [] = new String [32];
					int count1=0;
					for(int i=19; i < 49;i++){
						if (statement.getString(i) != null )
						{
							O_Date_Status[count1] = statement.getString(i);
						}else{
							O_Date_Status[count1]="";
						}
						count1++;
					}
					//THIS IS FOR CLINIC_NAME			
					d_token=null;
					d_token = new StringTokenizer(O_Clinc_Name, "|");
					int counter=d_token.countTokens();
					String code[]=new String[counter];
					int track=0;
					while (d_token.hasMoreTokens()){
						code[track]=d_token.nextToken();
						track++;
					}
					//THIS IS FOR CLINIC_long_NAME
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Clinc_long_Name, "|");
					String code_long[]=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						code_long[track]=d_token.nextToken();
						track++;
					}			
					//THIS IS FOR care_locn_ind
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Care_locn_ind, "|");
					cr_locn_ind=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						cr_locn_ind[track]=d_token.nextToken();
						track++;
					}
					//THIS IS FOR resource_class
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_res_class, "|");
					res_cls=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						res_cls[track]=d_token.nextToken();
						track++;
					}				
					//THIS IS FOR resource_class
					d_token=null;
					track=0;
					d_token = new StringTokenizer(p_position, "|");
					pos_clxn=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						pos_clxn[track]=d_token.nextToken();
						track++;
					}
					//THIS IS FOR CLINIC_CODE	
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Clinic_Code, "|");
					strcode=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						strcode[track]=d_token.nextToken();
						track++;
					}	
					// THIS IS FOR PRACTITIONER_NAME
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Practitioner_N, "|");
					String code1[]=new String[counter];
					if(d_token.countTokens() > 0)
					{
						while (d_token.hasMoreTokens())
						{
							code1[track]=d_token.nextToken();
							if(code1[track].equals("~")) code1[track]="";
							track++;
						}
					}
					// THIS IS FOR PRACTITIONER_FULL_NAME
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Practitioner_full_N, "|");
					String code1_full[]=new String[counter];
					if(d_token.countTokens() > 0)
					{
						while (d_token.hasMoreTokens())
						{
							code1_full[track]=d_token.nextToken();
							if(code1_full[track].equals("~")) code1_full[track]="";
							track++;

						}
					}
					String practiioner_type[]=new String[counter];
					// THIS IS FOR PRACTITIONER_ID
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Practitioner_I, "|");
					String strcode1[]=new String[counter];
					if(d_token.countTokens() > 0)
					{
						while (d_token.hasMoreTokens())
						{
							strcode1[track]=d_token.nextToken();
							if(strcode1[track].equals("~")) strcode1[track]="";				
							track++;
						}
					}
					//code Optimisation done on 05-dec-03 by Jit
					for(int cntr=0;cntr<=29;cntr++){						
						d_token=null;
						track=0;
						String arrPop[]=new String[counter];
						d_token = new StringTokenizer(O_Date_Status[cntr], "|");
						
						while (d_token.hasMoreTokens())
						{
							arrPop[track]=d_token.nextToken();
							track++;
						}
						arrLst.add(arrPop);						
					}		
					//End Jit
%>
					<style type="text/css">
						.menu {text-align:left;position:fixed;width:400px;}
						.menu1 {text-align:left;position:fixed;width:860px;}
						TD.USH {
						  FONT-FACE: verdana ;
						  FONT-SIZE: 8pt ;
						  BACKGROUND-COLOR: WHITE;
						  COLOR:blue;
						}
					</style>
					<div id="divTitleTable" class='menu' style="z-index:100;">
					<table border=0 width='860px' bgColor=white align="center" >
					<tr>
<%
					try{
						String local_month_range=null;
						StringTokenizer local_mn_token=null;
						//String lcl_mn_arr[]=null;
						int i=0;
						//int disp=0;
						int tval=0;
						String locarr[]=null;
						if(locale.equals("ar")){
							local_month_range=calculate_date_range(out3,out4,pageContext);
							//out.println("<script>alert('"+local_month_range+"')</script>");
							local_mn_token=new StringTokenizer(local_month_range,"|");
							//out.println("<script>alert('"+local_mn_token.countTokens()+"')</script>");
							tval=local_mn_token.countTokens();
							locarr=new String[tval];
							while(local_mn_token.hasMoreElements()){
							//out.println("<script>alert('"+local_mn_token.nextToken()+"')</script>");
							locarr[i]=local_mn_token.nextToken();
							i++;
							}
						}
						String entered="N";
						i=0;
						boolean from_mon_disp = false;
						boolean to_mon_disp = false;
						/*for(int p=1;p<28;p++){
							if(locale.equals("ar")){
								if(p==1){
									StringTokenizer tk1=new StringTokenizer(locarr[0],",");
									String mn_name1=tk1.nextToken();
									String mn1=tk1.nextToken();
									i++;
								%>
									<td width='35%' class=USH  align='center'><%=mn_name1%> <%=mn1%></td>
								<%}else if(p==10 && i < tval){
									StringTokenizer tk2=new StringTokenizer(locarr[1],",");
									String mn_name2=tk2.nextToken();
									String mn2=tk2.nextToken();
								%>
									<td width='35%' class=USH  align='center'><%=mn_name2%> <%=mn2%></td>
								<%}else{%>
									<td  width='2%'class=OASCH>&nbsp;&nbsp;</td>
								<%}
							}else{
								if(!from_mon_disp){
									String from_date=d_code2[1];
									String from_month=from_date.substring(0,4);
									from_date=from_date.substring(4,from_date.length());
									String from_date_display=DateUtils.convertDate(from_date,"YY","en",locale);
									if(Integer.parseInt(d_code2[0])>0){
										%>
										<td width='35%' class=USH ><%=from_month%> <%=from_date_display%></td>
										<%
									}
									from_mon_disp = true;
								}else if((from_mon_disp && !to_mon_disp) && (p >Integer.parseInt(d_code2[0]))){
									if(Integer.parseInt(d_code2[2])>0){
										entered="Y";
										String to_date=d_code2[3];
										String to_month=to_date.substring(0,4);
										to_date=to_date.substring(4,to_date.length());
										String to_date_display=DateUtils.convertDate(to_date,"YY","en",locale);
										%>	
											<td  width='35%' class=USH align='left'><%=to_month%> <%=to_date_display%></td>
										<%
										to_mon_disp = true;
									}			
								}else{%>						
									<td  width='2%'class=OASCH>&nbsp;&nbsp;</td>		
								<%}
							}
						}*/
						if(!from_mon_disp){
							if(locale.equals("ar")){
								StringTokenizer tk1=new StringTokenizer(locarr[0],",");
								String mn_name1=tk1.nextToken();
								String mn1=tk1.nextToken();
								if(Integer.parseInt(d_code2[0])>0){
								%>
									<td width='35%' class=USH  align='center'><%=mn_name1%> <%=mn1%></td>
								<%
								}
							}else{
								String from_date=d_code2[1];
								String from_month=from_date.substring(0,4);
								from_date=from_date.substring(4,from_date.length());
								String from_date_display=DateUtils.convertDate(from_date,"YY","en",locale);
								if(Integer.parseInt(d_code2[0])>0){%>
									<td width='35%' class=USH align='left'><%=from_month%> <%=from_date_display%></td>
								<%}
							}
						}
						if(!to_mon_disp){
							if(locale.equals("ar")){
								StringTokenizer tk2=new StringTokenizer(locarr[1],",");
								String mn_name2=tk2.nextToken();
								String mn2=tk2.nextToken();
								if(Integer.parseInt(d_code2[2])>0){
								%>
									<td width='35%' class=USH  align='center'><%=mn_name2%> <%=mn2%></td>
								<%
								}
							}else{
								if(Integer.parseInt(d_code2[2])>0){
									entered="Y";
									String to_date=d_code2[3];
									String to_month=to_date.substring(0,4);
									to_date=to_date.substring(4,to_date.length());
									String to_date_display=DateUtils.convertDate(to_date,"YY","en",locale);
									%>
										<td  width='35%' class=USH align='right'><%=to_month%> <%=to_date_display%></td>
									<%
								}
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
%>
					</tr>	
					</table>
					<table border=1 width='860px' bgColor=white  id='colors' align="center">
					<tr>
<%
					try{
						for(int d_init=0;d_init<d_track;d_init++){
							String tm_date_str=d_code[d_init];
							StringTokenizer strToken1=new StringTokenizer(tm_date_str,"/");
							int dt=0;
							int mn=0;
							int yr=0;
							if(strToken1.hasMoreTokens()){
								dt=Integer.parseInt(strToken1.nextToken());
								mn=Integer.parseInt(strToken1.nextToken());
								yr=Integer.parseInt(strToken1.nextToken());
							}
							double day_value=calcGregorian(yr,mn,dt);
							int int_val=(int)day_value;
							if(locale.equals("ar")){%>
								<td class=OALABEL width='21px' >
								<%=wk_day[int_val]%>
							
							<%}else{%>
								<td class=OALABEL width='21px' >
								<%=d_day[d_init].substring(0,2)%>
								</td>
							<%}
						}
						for(int u=0;u<(30-d_track);u++){%>
							<td class=OALABEL width='21px'>&nbsp;&nbsp;
							</td>
						<%}
					}catch(Exception e){
						e.printStackTrace();
					}%>
					</tr>
					<tr>	
<%
					try {
						String work_hol="";
						int pos1=0;
						for(int d_init=0;d_init<d_track;d_init++){
							work_hol=d_mon[d_init];
							pos1=work_hol.indexOf("*");
							work_hol=work_hol.substring(pos1 +1);
							if((d_code[d_init].substring(0,2)).equals("")){
								work_hol="OALABEL";
							}else{
								if(work_hol.equals("H")){
									work_hol="OAHOLIDAY";
								}else{
									work_hol="OALABEL";
								}
							}
							%>
							<td class='<%=work_hol%> ' width='21px' title="<%=d_day[d_init]%>">
							<%
							tmpDate=DateUtils.convertDate(d_code[d_init],"DMY","en",locale);%>
							<%=tmpDate.substring(0,2)%>	
							<input type='hidden' name=day<%=d_init%>  value='<%=d_code[d_init].substring(0,10)%>' >
							</td>
						<%}
						for(int u=0;u<(30-d_track);u++){
							work_hol="OALABEL";
						%>
							<td class='<%=work_hol%>' width='21px'>&nbsp;&nbsp;
							</td>
						<%}
					}catch(Exception e){
						e.printStackTrace();
					}
%>	
					</tr>
					</table>
					</div>
					<div id='divTitleTable1' name="divTitleTable1"  class='menu1' style="z-index:200;">
					<table border=1 width='400px' bgColor=white align="center">
					<form name='calender1' id='calender1'>
					<tr>
					<td class='OALABEL' width='59%' height='10'>&nbsp;</td>
					<td class='OALABEL' >&nbsp;</td>
					<td class='OALABEL'>&nbsp;</td>
					</tr>
					<tr>
					<td class='OALABEL' >&nbsp;</td>
					<td class='OALABEL' >&nbsp;</td>
					<td class='OALABEL' >&nbsp;</td>
					</tr>
					<tr>
					<td class='OALABEL'> 
					<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='OALABEL'> 
					<fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
					<td class='OALABEL'>S</td>
					</tr>
					</table>
					</form>
					</div>
					<div id="divTitleTable23"  style="z-index:100;">
					<table border=1 width='400px' bgColor=white align="center" height='20px'>
					<form name='calender' id='calender'>
<%
					for(int init=0;init<counter;init++){
						care_locn_ind_desc=cr_locn_ind[init];
						String care_locn_ind_desc1="";
						if(care_locn_ind_desc.equals("C")){
						care_locn_ind_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
						}else if(care_locn_ind_desc.equals("E")){
							care_locn_ind_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
						}else if(care_locn_ind_desc.equals("D")){
							care_locn_ind_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
						}
%>
						<tr onClick='aaa1(this)' height='27px'>
						<td class='OALABEL' width='193px' NOWRAP title='<%=care_locn_ind_desc1%>/<%=code_long[init]%>'>
						<%if(code[init].length() >7){%>
							<%=code[init]%><input type='hidden' name='location<%=init%>' id='location<%=init%>' value='<%=strcode[init]%>||<%=care_locn_ind_desc%>'>
						<%}else{%>
							<%=code[init]%><input type='hidden' name='location<%=init%>' id='location<%=init%>' value='<%=strcode[init]%>||<%=care_locn_ind_desc%>'>
						<%}if(code[init].length() == 5){%>
							</td>
						<%}else	if(code[init].length() == 6){%>
							</td>
						<%}else if(code[init].length() == 7){%>
							</td>
						<%}else{%>
							</td>
						<%}					
						res_class_desc=res_cls[init];
						String pos_value=pos_clxn[init];
						if(pos_value.equals("~")){
							pos_value="";
						}				
						String res_class_desc1="";
						if(res_class_desc.equals("P"))
						{		   res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(res_class_desc.equals("E"))
						{
						res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(res_class_desc.equals("R"))
						{
						res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(res_class_desc.equals("O"))
						{
						res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
						}
						if(res_class_desc.equals("P")){
							if(!strcode1[init].equals("")){
							//String sql3="select POSITION_DESC from am_practitioner_lang_vw where practitioner_id='"+strcode1[init]+"' and language_id='"+locale+"'";
							//rs=stmt.executeQuery(sql3);
									//if(rs!=null){
										//if(rs.next()){
											 //practiioner_type1=rs.getString("POSITION_DESC");
											 //practiioner_type1=pos_value;
											 if(pos_value.equals("")){
												 pos_value="";
												 practiioner_type[init]=pos_value;
											}else{
												practiioner_type[init]="/"+pos_value;
											}
										//}	
									//}
									//if(rs !=null) rs.close();
							}else{
								practiioner_type[init]="";
							}
						}else{
							practiioner_type[init]="";
						}
%> 
						<td class='OALABEL'  width='115px' nowrap title='<%=res_class_desc1%>/<%=code1_full[init]%><%=practiioner_type[init]%>'>
						<%if(code1[init].length() == 6){	%><%=code1[init]%>
						<input type='hidden' name='practitioner<%=init%>' id='practitioner<%=init%>' 					value='<%=strcode1[init]%>||<%=res_class_desc%>'>
						<%}else{%>
						<%=code1[init]%><input type='hidden' name='practitioner<%=init%>' id='practitioner<%=init%>' value='<%=strcode1[init]%>||<%=res_class_desc%>'><%}%></td>
						<td   width='5px' class="<%=classValue%>"><input type=checkbox name='check<%=init%>' id='check<%=init%>' onClick=anyCheck(calender)></td>
						</tr>
<%
					}
%>
					<input type='hidden' name='counter' id='counter' value="<%=counter%>" >
					</form>
					</table>
					</div>
					<!--END DIV TBALE3-->
					<!-- Detail FORM-->
					<table border=1 width='1260px' align="left" height='20px'>
					<TR height='62px'><td class='ush'  NOWRAP height='26'>&nbsp;</td></TR>
<%	
					String borderc = "";
					try {
						for(int init1=0;init1<counter;init1++){
							if (disp_ear_sch.equals("Y")){
								if (start_sch_date.equals(d_code[0]))
									borderc = "BORDERCOLOR='#FF0000'";
							}
							if ( init1 % 2 == 0 )
								classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;
%>		
							<tr height='27px'>
							<td class='ush' width='366px' NOWRAP height='24'>&nbsp;
<%	
							for(int kkk=0;kkk<arrLst.size();kkk++){
								String arrDisp[]=(String []) arrLst.get(kkk);					
								if(arrDisp[init1] !=null){
									String ss=arrDisp[init1];
									String Slot_det="";
									String time_val="";
								
									int ret_val=ss.indexOf('#');						
									if(ret_val!=-1){
										StringTokenizer time_fr_to = new StringTokenizer(ss,"#");
										while (time_fr_to.hasMoreTokens()){
											Slot_det=time_fr_to.nextToken();
											time_val=time_fr_to.nextToken();
										}
									}
									String date_display=d_code[kkk];
									String x=ss.substring(0,1);
									String y="";
									String holiday_title="";
									if(x.equals("B")){
										if( ss.length() > 1){
											y=ss.substring(11,ss.length());
										}else{
											y="&nbsp;&nbsp;";	
										}
										if( y.length() == 1){
											y="0"+y;
										}
									}else if(x.equals("H")){
										holiday_title=ss.substring(11,ss.length());			
									}else{							
										if( Slot_det.length() > 2){
											y=ss.substring(11,Slot_det.length());
										}else{
											y="&nbsp;";	
										}							
										if( y.length() == 1){
											y="0"+y;
										}
									}
									if(time_val.equals("$")){
										time_val=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FreeFormat.label","common_labels");
									}						
									if(x.equals("G")) {
									%>
										<td class='OAGREEN' width='21px' <%=borderc%> height='22' title='<%=time_val%>' onClick='bbb1(this)'>
										<a href="javascript:moveNext('<%=date_display%>','<%=strcode[init1]%>','<%=strcode1[init1]%>','<%=cr_locn_ind[init1]%>','<%=res_cls[init1]%>')"><%=y%></a>
									<%
										borderc = "";
									}else if(x.equals("L")) { // Modified against JD-CRF-0177 
									%>
										<td class='OALIGHTGREEN'  width='21px' <%=borderc%> height='22' title='<%=time_val%>' onClick='bbb1(this)'>
										<a href="javascript:moveNext('<%=date_display%>','<%=strcode[init1]%>','<%=strcode1[init1]%>','<%=cr_locn_ind[init1]%>','<%=res_cls[init1]%>')"><%=y%></a>
									<%
										borderc = "";
									}else if(x.equals("D")) { // Modified against JD-CRF-0177 
									%>
										<td class='OADARKGREEN' width='21px' <%=borderc%> height='22' title='<%=time_val%>' onClick='bbb1(this)'>
										<a href="javascript:moveNext('<%=date_display%>','<%=strcode[init1]%>','<%=strcode1[init1]%>','<%=cr_locn_ind[init1]%>','<%=res_cls[init1]%>')"><%=y%></a>
									<%
										borderc = "";
									}else if(x.equals("R")) {
									%>
										<td class='OAFULL' 		 width='21px'  height='22' onClick='bbb1(this)'>
										<%y=""; %>
										<a 	href="javascript:moveNext('<%=date_display%>','<%=strcode[init1]%>','<%=strcode1[init1]%>','<%=cr_locn_ind[init1]%>','<%=res_cls[init1]%>')">&nbsp;&nbsp;</a>
									<%
									}else if(x.equals("Y")) {
									%>
										<!--Modified by Ashwini on 06-Jun-2019 for ML-MMOH-SCF-1212-->
										<td class='OAYELLOW' <%=borderc%> width='21px'onClick='bbb1(this)' height='22'>
										<a href="javascript:moveNext('<%=date_display%>','<%=strcode[init1]%>','<%=strcode1[init1]%>','<%=cr_locn_ind[init1]%>','<%=res_cls[init1]%>')">&nbsp;&nbsp;&nbsp;&nbsp;<%=y%></a>
									<%
										borderc = "";
									}else if(x.equals("F")){
									%>
										<td class='OAFORCED' <%=borderc%> width='21px'onClick='bbb1(this)' height='22'>
										<a href="javascript:moveNext('<%=date_display%>','<%=strcode[init1]%>','<%=strcode1[init1]%>','<%=cr_locn_ind[init1]%>','<%=res_cls[init1]%>')"><%=y%></a>
									<%
										borderc = "";
									}else if(x.equals("B")) {%>
										<td class='OARED' title ="<%=y%>" width='21px' height='22'>
									<%
										y="";
									}else if(x.equals("H")) {%>
										<!-- The below line is changed for Incident NO:33301 by Srinivas.Y-->
										<td class='OAHOLIDAY' title ="<%=holiday_title%>" height='22' align = 'center' width='21px'>H
									<%
										y="";
									}else{
									%>
										<td class="<%=classValue%>" width='21px' height='22'>
										<%=y%>
									<%
									}
								}else{%>
								<td class="<%=classValue%>" width='21px'  height='22'>
									&nbsp;&nbsp;
								<%
								}
								%>
								</td>			
							<%
							}
							%>
						</tr>
						<%
						}
					}catch(Exception e){
						e.printStackTrace();
					}
%>
					</table>
					<form name='calender3' id='calender3'>
					<input type='hidden' name='p_from' id='p_from'  value="<%=out3%>" >
					<input type='hidden' name='pref_start_date' id='pref_start_date'  value="<%=pref_start_date%>" >
					<input type='hidden' name='pref_end_date' id='pref_end_date'  value="<%=pref_end_date%>" >
					<input type='hidden' name='call_date_yn' id='call_date_yn'  value="<%=call_date_yn%>" >
					<input type='hidden' name='p_to' id='p_to'  value="<%=out4%>" >
					<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
					<input type='hidden' name='clinic' id='clinic' value="<%=clinic%>" >
					<input type='hidden' name='practitioner' id='practitioner' value="<%=practitioner%>" >
					<input type='hidden' name='practitioner_type' id='practitioner_type' value="<%=res_class%>" >
					<input type='hidden' name='speciality' id='speciality' value="<%=speciality%>"  >
					<input type='hidden' name='visittype' id='visittype' value="<%=visittype%>" >
					<input type='hidden' name='ca_mode' id='ca_mode' value="<%=ca_mode %>" >
					<input type='hidden' name='ca_patient_id' id='ca_patient_id' value="<%=ca_patient_id %>" >
					<input type='hidden' name='start_sch_date' id='start_sch_date' value="<%=start_sch_date%>" >
					<input type='hidden' name='callingMode' id='callingMode' value="<%=callingMode%>">
					<input type='hidden' name='calledFrom' id='calledFrom' value="<%=calledFrom%>">
					<input type='hidden' name='or_catalogue_code' id='or_catalogue_code' value="<%=or_catalogue_code%>">
					<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
					<input type='hidden' name='order_line_num' id='order_line_num' value="<%=order_line_num%>">
					<input type='hidden' name='order_catalog_code' id='order_catalog_code' value="<%=order_catalog_code%>">
					<input type="hidden" name="slot_appt_ctrl" id="slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
					<input type="hidden" name="visit_limit_rule" id="visit_limit_rule" value="<%=visit_limit_rule%>">
					<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
					<input type="hidden" name="override_no_of_slots_yn" id="override_no_of_slots_yn" value="<%=override_no_of_slots_yn%>">
					<input type='hidden' name='req_id' id='req_id' value='<%=req_id%>'>
					<input type="hidden" name="install_yn_val" id="install_yn_val" value="<%=install_yn_val%>">
					<input type="hidden" name="from_OR" id="from_OR" value="<%=from_OR%>">
					<input type="hidden" name="create_wait_list_yn" id="create_wait_list_yn" value="<%=create_wait_list_yn%>">
					<input type="hidden" name='visit_flag_OP' id='visit_flag_OP' value='<%=visit_flag_OP%>'>
					<input type="hidden" name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
					<input type="hidden" name='contact_num_reqd_yn' id='contact_num_reqd_yn' value='<%=contact_num_reqd_yn%>'>
					<input type="hidden" name='care_locn_ind' id='care_locn_ind' value='<%=care_locn_ind%>'>
					<input type="hidden" name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>'>
					<input type="hidden" name='no_dwm' id='no_dwm' value='<%=no_dwm%>'>
					<input type="hidden" name='dwm_desc' id='dwm_desc' value='<%=dwm_desc%>'>
					<input type="hidden" name='from_page' id='from_page' value='<%=from_page%>'>
					<input type="hidden" name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value='<%=min_ela_per_resc_noshow_in_day%>'>
					<input type="hidden" name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value='<%=noshow_ctrl_by_splty_or_clinic%>'>
					<input type="hidden" name='from_facility_id' id='from_facility_id' value='<%=from_facility_id%>'>
					<input type="hidden" name='from_encounter_id' id='from_encounter_id' value='<%=from_encounter_id%>'>
					<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value='<%=no_of_noshow_appts_for_alert%>'>
					<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value='<%=per_chk_for_no_show_alert%>'>
					<input type="hidden" name='position' id='position' value='<%=position%>'>
					<input type="hidden" name='addtl_splty' id='addtl_splty' value='<%=addtl_splty%>'>		
					<script>
					setTimeout("LoadAppt_Dummy()",500);
					function LoadAppt_Dummy(){ 
					parent.parent.frames[1].document.forms[0].p_from.value = parent.frames[1].document.forms[2].p_from.value;
					parent.parent.frames[1].document.forms[0].p_to.value = parent.frames[1].document.forms[2].p_to.value;
					parent.parent.frames[1].document.forms[0].oper_stn_id.value = parent.frames[1].document.forms[2].oper_stn_id.value;
					parent.parent.frames[1].document.forms[0].clinic1.value = parent.frames[1].document.forms[2].clinic.value;
					parent.parent.frames[1].document.forms[0].practitioner1.value = parent.frames[1].document.forms[2].practitioner.value;
					parent.parent.frames[1].document.forms[0].speciality1.value = parent.frames[1].document.forms[2].speciality.value;
					parent.parent.frames[1].document.forms[0].visittype1.value = parent.frames[1].document.forms[2].visittype.value;
					parent.parent.frames[1].document.forms[0].start_sch_date.value = parent.frames[1].document.forms[2].start_sch_date.value;
					}
					//parent.arrows.document.forms[0].forward.disabled=false;
					var call_date_yn =parent.frames[1].document.forms[2].call_date_yn.value;
					if (call_date_yn=="N"){
						var fromarray;
						var toarray;
						var fromdate = parent.frames[1].document.forms[2].p_from.value ;
						var todate   = parent.frames[1].document.forms[2].pref_start_date.value ;
						if(fromdate.length > 0 && todate.length > 0 ){
							fromarray = fromdate.split("/");
							toarray = todate.split("/");
							var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
							var todt = new Date(toarray[2],toarray[1],toarray[0]);
							if(Date.parse(todt) == Date.parse(fromdt)) {				
								parent.arrows.document.forms[0].back.disabled=true;
							}
							else
								parent.arrows.document.forms[0].back.disabled=false;
						}
						var fromdate1 = parent.frames[1].document.forms[2].p_to.value ;			
						var todate1   = parent.frames[1].document.forms[2].pref_end_date.value ;			
						if(fromdate1.length > 0 && todate1.length > 0 ){
							fromarray1 = fromdate1.split("/");
							toarray1 = todate1.split("/");
							var fromdt1 = new Date(fromarray1[2],fromarray1[1],fromarray1[0]);
							var todt1 = new Date(toarray1[2],toarray1[1],toarray1[0]);
							if(Date.parse(todt1) == Date.parse(fromdt1))
							{					
							  parent.arrows.document.forms[0].forward.disabled=true;
							}
							else
							 parent.arrows.document.forms[0].forward.disabled=false;
						}
					}
					</script>

				<%
				}/*if loop checking for clinic code*/else{
				%>
					<form name='calender3' id='calender3'>
					<input type=hidden name='p_from' id='p_from'  value="<%=out3%>" >
					<input type=hidden name='p_to' id='p_to'  value="<%=out4%>" >
					<input type=hidden name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
					<input type=hidden name='clinic' id='clinic' value="<%=clinic%>" >
					<input type=hidden name='practitioner' id='practitioner' value="<%=practitioner%>" >
					<input type=hidden name='practitioner_type' id='practitioner_type' value="<%=practitioner_type%>" >
					<input type=hidden name='speciality' id='speciality' value="<%=speciality%>"  >
					<input type=hidden name='visittype' id='visittype' value="<%=visittype%>" >
					<input type='hidden' name='ca_mode' id='ca_mode' value="<%=ca_mode %>" >
					<input type='hidden' name='ca_patient_id' id='ca_patient_id' value="<%=ca_patient_id %>" >
					<input type='hidden' name='pref_start_date' id='pref_start_date'  value="<%=pref_start_date%>" >
					<input type='hidden' name='pref_end_date' id='pref_end_date'  value="<%=pref_end_date%>" >
					<input type='hidden' name='call_date_yn' id='call_date_yn'  value="<%=call_date_yn%>" >
					<script>
					setTimeout("LoadAppt_Dummy1()",500);
					function LoadAppt_Dummy1(){						
					parent.parent.frames[1].document.getElementById('p_from').value = parent.frames[1].document.getElementById('p_from').value;
					parent.parent.frames[1].document.getElementById('p_to').value = parent.frames[1].document.getElementById('p_to').value;
					parent.parent.frames[1].document.getElementById('oper_stn_id').value = parent.frames[1].document.getElementById('oper_stn_id').value;
					parent.parent.frames[1].document.getElementById('clinic1').value = parent.frames[1].document.getElementById('clinic').value;
					parent.parent.frames[1].document.getElementById('practitioner1').value = parent.frames[1].document.getElementById('practitioner').value;
					parent.parent.frames[1].document.getElementById('speciality1').value = parent.frames[1].document.getElementById('speciality').value;
					parent.parent.frames[1].document.getElementById('visittype1').value = parent.frames[1].document.getElementById('visittype').value;
					}
					parent.arrows.document.getElementById('forward').disabled=true;
					parent.arrows.document.getElementById('back').disabled=true;
					parent.parent.frames[2].location.href='../../eCommon/html/blank.html';
					</script>
					<%		 
					if (callingMode.equals("")){
					%>
						<script>		
						var error = getMessage('SCH_NOT_AVAILABLE','OA');// Normal schedule search
						parent.parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;		
						parent.arrows.document.getElementById('forward').disabled=true;
						parent.arrows.document.getElementById('back').disabled=false;			//changed
						//parent.frames[0].location.href='../../eCommon/html/blank.html';
						</script>
					<%
					}else{
					%>
						<script>
						var error = getMessage('SCH_NOT_AVAILABLE','OA');//when searching for schedules from Pending order Schedule
						alert(error);
						parent.arrows.document.getElementById('forward').disabled=true;
						parent.arrows.document.getElementById('back').disabled=false;//changed
						//parent.frames[0].location.href='../../eCommon/html/blank.html'; 
						</script>
					<%
					}
					%>
					<script>
					parent.checkbox.location.href='../../eCommon/html/blank.html';
					var call_date_yn ="<%=call_date_yn%>";
					if (call_date_yn=="N"){
						var fromarray;
						var toarray;
						var fromdate = "<%=out3%>" ;
						var todate   = "<%=pref_start_date%>";
						if(fromdate.length > 0 && todate.length > 0 ){
							fromarray = fromdate.split("/");
							toarray = todate.split("/");
							var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
							var todt = new Date(toarray[2],toarray[1],toarray[0]);
							if(Date.parse(todt) == Date.parse(fromdt)) {				
								parent.arrows.document.getElementById('back').disabled=true;
							}
							else
								parent.arrows.document.getElementById('back').disabled=false;
						}
						var fromdate1 = "<%=out4%>";			
						var todate1   = "<%=pref_end_date%>";			
						if(fromdate1.length > 0 && todate1.length > 0 ){
							fromarray1 = fromdate1.split("/");
							toarray1 = todate1.split("/");
							var fromdt1 = new Date(fromarray1[2],fromarray1[1],fromarray1[0]);
							var todt1 = new Date(toarray1[2],toarray1[1],toarray1[0]);
							if(Date.parse(todt1) == Date.parse(fromdt1))
							{					
							  parent.arrows.document.getElementById('forward').disabled=true;
							}
							else
							 parent.arrows.document.getElementById('forward').disabled=false;
						}
					}
					</script>
				<%}

			}else{
			%>
				<form name='calender3' id='calender3'>
				<input type='hidden' name='p_from' id='p_from'  value="<%=out3%>" >
				<input type='hidden' name='p_to' id='p_to'  value="<%=out4%>" >
				<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
				<input type='hidden' name='clinic' id='clinic' value="<%=clinic%>" >
				<input type='hidden' name='practitioner' id='practitioner' value="<%=practitioner%>" >
				<input type='hidden' name='practitioner_type' id='practitioner_type' value="<%=practitioner_type%>" >
				<input type='hidden' name='speciality' id='speciality' value="<%=speciality%>"  >
				<input type='hidden' name='visittype' id='visittype' value="<%=visittype%>" >
				<input type='hidden' name='ca_mode' id='ca_mode' value="<%=ca_mode %>" >
				<input type='hidden' name='ca_patient_id' id='ca_patient_id' value="<%=ca_patient_id %>" >
				<script>
				setTimeout("LoadAppt_Dummy2()",500);
					function LoadAppt_Dummy2(){ 
				parent.parent.frames[1].document.forms[0].p_from.value = parent.frames[1].document.forms[0].p_from.value;
				parent.parent.frames[1].document.forms[0].p_to.value = parent.frames[1].document.forms[0].p_to.value;
				parent.parent.frames[1].document.forms[0].oper_stn_id.value = parent.frames[1].document.forms[0].oper_stn_id.value;
				parent.parent.frames[1].document.forms[0].clinic1.value = parent.frames[1].document.forms[0].clinic.value;
				parent.parent.frames[1].document.forms[0].practitioner1.value = parent.frames[1].document.forms[0].practitioner.value;
				parent.parent.frames[1].document.forms[0].speciality1.value = parent.frames[1].document.forms[0].speciality.value;
				parent.parent.frames[1].document.forms[0].visittype1.value = parent.frames[1].document.forms[0].visittype.value;
				}
				parent.arrows.document.forms[0].forward.disabled=true;
				parent.arrows.document.forms[0].back.disabled=true;
				parent.parent.frames[2].location.href='../../eCommon/html/blank.html';
				</script>
				<%
				if (callingMode.equals("")){
				%>
					<script>
					parent.arrows.document.forms[0].forward.disabled=true;
					parent.arrows.document.forms[0].back.disabled=true;
					var error = getMessage('SCH_NOT_AVAILABLE','OA');
					parent.parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;
					parent.frames[0].location.href='../../eCommon/html/blank.html';
					</script>
				<%
				}else{
				%>
					<script>	
					var error = getMessage('SCH_NOT_AVAILABLE','OA');
					alert(error);		
					parent.arrows.document.forms[0].forward.disabled=true;
					parent.arrows.document.forms[0].back.disabled=true;
					parent.frames[0].location.href='../../eCommon/html/blank.html';
					</script>
				<%
				}
				%>
	<script>parent.checkbox.location.href='../../eCommon/html/blank.html'</script>
<%} // end of else 
	if(rs !=null) rs.close();
	if(statement !=null) statement.close();
	if(statement2 !=null) statement2.close();
	if(stmt !=null) stmt.close();
	if(pstmt !=null) pstmt.close();
	arrLst.clear();
}catch(Exception e)
	{
		e.printStackTrace();
		%>
	<script>
	parent.parent.frames[2].location.href='../../eCommon/html/blank.html';
	</script>
	<%if (callingMode.equals("")){%>
		<script>
		var error = getMessage('SCH_NOT_AVAILABLE','OA');	
	parent.parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;	
	parent.arrows.document.forms[0].forward.disabled=true;
			parent.arrows.document.forms[0].back.disabled=true;	
			parent.frames[0].location.href='../../eCommon/html/blank.html';
			</script>
	<%}else{%>
		<script>
var error = getMessage('SCH_NOT_AVAILABLE','OA');
		alert(error);
		parent.arrows.document.forms[0].forward.disabled=true;
			parent.arrows.document.forms[0].back.disabled=true;
			parent.frames[0].location.href='../../eCommon/html/blank.html';
			</script>
	<%}%>
	<script>parent.checkbox.location.href='../../eCommon/html/blank.html';</script>	
	<%}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
	}
%>
<input type='hidden' name='patient_id_temp' id='patient_id_temp' value="<%=patient_id_temp %>" >
<input type='hidden' name='name_prefix' id='name_prefix' value="<%=name_prefix %>" >
<input type='hidden' name='first_name' id='first_name' value="<%=first_name %>" >
<input type='hidden' name='second_name' id='second_name' value="<%=second_name %>" >
<input type='hidden' name='third_name' id='third_name' value="<%=third_name %>" >
<input type='hidden' name='family_name' id='family_name' value="<%=family_name %>" >
<input type='hidden' name='name_suffix' id='name_suffix' value="<%=name_suffix %>" >
<input type='hidden' name='name_prefix_oth_lang' id='name_prefix_oth_lang' value="<%=name_prefix_oth_lang%>" >
<input type='hidden' name='first_name_oth_lang' id='first_name_oth_lang' value="<%=first_name_oth_lang%>" >
<input type='hidden' name='second_name_oth_lang' id='second_name_oth_lang' value="<%=second_name_oth_lang%>" >
<input type='hidden' name='third_name_oth_lang' id='third_name_oth_lang' value="<%=third_name_oth_lang%>" >
<input type='hidden' name='family_name_oth_lang' id='family_name_oth_lang' value="<%=family_name_oth_lang%>" >
<input type='hidden' name='name_suffix_oth_lang' id='name_suffix_oth_lang' value="<%=name_suffix_oth_lang%>" >
<input type='hidden' name='gender' id='gender' value="<%=gender %>" >
<input type='hidden' name='contact_no' id='contact_no' value="<%=contact_no %>" >
<input type='hidden' name='language_code_temp' id='language_code_temp' value="<%=language_code_temp %>" >
<input type='hidden' name='nationality_code_temp' id='nationality_code_temp' value="<%=nationality_code_temp %>" >
<input type='hidden' name='term_set_id' id='term_set_id' value="<%=term_set_id %>" >
<input type='hidden' name='linking_code' id='linking_code' value="<%=linking_code %>" >

</form>
<script>
if(parent.parent.frames[1].document.forms[0].search)
parent.parent.frames[1].document.forms[0].search.disabled=false;
if(parent && parent.arrows){
	var frm_dt=convertDate('<%=out3%>','DMY','en',localeName);
	var to_dt=convertDate('<%=out4%>','DMY','en',localeName);
	parent.arrows.document.getElementById("date_period").innerHTML="From:"+frm_dt+" - To:"+to_dt;
}
</script>
</body>
</html>

<%!
	public double calcGregorian(int year,int month,int day)
	{
	    month--;

	   double j, weekday;

	   j = gregorian_to_jd(year, month + 1, day) +
	           (Math.floor(0 + 60 * (0 + 60 * 0) + 0.5) / 86400.0);
	   jd_to_islamic(j);
	   weekday = jwday(j);


	    return weekday;
	}

		public double gregorian_to_jd(int year, int month,int day)
	{
		double GREGORIAN_EPOCH = 1721425.5;
			
	    return (GREGORIAN_EPOCH - 1) +
	           (365 * (year - 1)) +
	           Math.floor((year - 1) / 4) +
	           (-Math.floor((year - 1) / 100)) +
	           Math.floor((year - 1) / 400) +
	           Math.floor((((367 * month) - 362) / 12) +
	           ((month <= 2) ? 0 :
	                               (leap_gregorian(year) ? -1 : -2)
	           ) +
	           day);
	}

		public boolean leap_gregorian(int year)
	{
	    return ((year % 4) == 0) &&
	            (!(((year % 100) == 0) && ((year % 400) != 0)));
	}

	public void jd_to_islamic(double jd)
	{
		double ISLAMIC_EPOCH = 1948439.5;
	    double year,month, day;
	
	    jd = Math.floor(jd) + 0.5;
	    year = Math.floor(((30 * (jd - ISLAMIC_EPOCH)) + 10646) / 10631);
	    month = Math.min(12,Math.ceil((jd - (29 + islamic_to_jd(year, 1, 1))) / 29.5) + 1);
	    day = (jd - islamic_to_jd(year, month, 1)) + 1;	    
	}

	public double islamic_to_jd(double year, double month, double day)
	{
		double ISLAMIC_EPOCH = 1948439.5;
		/*double tt=(1 +
        Math.ceil(29.5 * (1 - 1)) +
        (year - 1) * 354 +
        Math.floor((3 + (11 * year)) / 30) +
        ISLAMIC_EPOCH) - 1;*/
	    return (day +
	            Math.ceil(29.5 * (month - 1)) +
	            (year - 1) * 354 +
	            Math.floor((3 + (11 * year)) / 30) +
	            ISLAMIC_EPOCH) - 1;
	}
	
	public double jwday(double j)
	{
		return mod(Math.floor((j + 1.5)), 7);
				
	}
	
	public double mod(double a,double b)
	{
		return a - (b * Math.floor(a / b));
		
	}


private String calculate_date_range(String fromdate, String todate, PageContext pageContext) {
		DateUtils du = new DateUtils();
		fromdate = du.convertDate(fromdate, "DMY", "en", "ar");
		todate = du.convertDate(todate, "DMY", "en", "ar");

		int daysInMonth[] = { 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29 };

		//String Month[] = { "MuHarram", "Safar","Rabi`al-Awwal", "Rabi`ath-Thani", "Jumadal-Ula","Jumada t-Tania", "Rajab", "Sha`ban", "Ramadan", "Shawwal",				"Dhul-Qa`da", "Dhu l-Hijja" };
		String Month[] = { com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.January.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.February.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.March.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.April.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.May.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.June.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.July.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.August.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.September.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.October.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.November.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.December.label","oa_labels") };
		String month_year_str = "";
		String[] from;
		String[] to;
		from = fromdate.split("/");
		to = todate.split("/");
		int from_month = Integer.parseInt(from[1]);
		int to_month = Integer.parseInt(to[1]);
		int from_year = Integer.parseInt(from[2]);
		int to_year = Integer.parseInt(to[2]);
		int from_day = Integer.parseInt(from[0]);
		//int to_day = Integer.parseInt(to[0]);

		int no_of_days = daysInMonth[from_month - 1];

		int rem_days = no_of_days - from_day;

		int to_count = 0;
       
	    /*Below line commented for the incident  KAUH-SCF-0129.2 [IN:049853]*/
		/*if (rem_days <= 5) {
			from_month = from_month + 1;
		}*/
		/*End  KAUH-SCF-0129.2 [IN:049853]*/
		
		//if ((to_month >= 1) && (to_month < from_month)) { //commented  KAUH-SCF-0129.2 [IN:049853]
			to_count = 12;
			for (int i = from_month; i <= to_count; i++) {
				month_year_str = month_year_str + Month[i - 1] + ","
					+ from_year + "|";
			}

			for (int i = 1; i <= to_month; i++) {
				month_year_str = month_year_str + Month[i - 1] + "," + to_year
						+ "|";
			}

         /*Below line commented or the incident KAUH-SCF-0129.2 [IN:049853]*/
		/*} else {
			for (int i = from_month; i <= to_month; i++) {
				month_year_str = month_year_str + Month[i - 1] + ","
						+ from_year + "|";
			}
		}*/
		/*End  KAUH-SCF-0129.2 [IN:049853]*/
		return month_year_str;

	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

