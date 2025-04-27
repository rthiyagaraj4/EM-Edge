
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%@ page contentType="text/html;charset=UTF-8"import ="java.sql.*,java.net.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
	<%! int TotNum=0;%>
	<%

	request.setCharacterEncoding("UTF-8");	

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String ca_patient_id=request.getParameter("patient_id");
	if(ca_patient_id==null) ca_patient_id="";
	String locale=(String)session.getAttribute("LOCALE");

	String clinic_code=request.getParameter("location_code");
	String splty_code=request.getParameter("spl_code");

	if (clinic_code==null)
	clinic_code=request.getParameter("i_clinic_code");

	if (clinic_code==null) clinic_code="";


	String practitioner_id="";
	String callingMode="N";
	callingMode=request.getParameter("callingMode");
	session.putValue("callingMode_new",callingMode);
	String ref_md=request.getParameter("ref");
	if(ref_md==null) ref_md="F";
	if(callingMode==null || callingMode.equals("") || callingMode.equals("null")){
		callingMode="N";
	}
	if(callingMode.equals("OP"))
	{
		practitioner_id=request.getParameter("i_practitioner_id");
	}else{
		practitioner_id=(String)session.getValue("ca_practitioner_id");
	}
	
	boolean no_sch_flag=false;


	String i_Clinic_code_sel=clinic_code;
	if(i_Clinic_code_sel==null || i_Clinic_code_sel.equals("") || i_Clinic_code_sel.equals("null")){
		i_Clinic_code_sel="N";
	}
	int ij=0;
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("resource_class");
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	
	String care_locn_ind_desc="";
	if(clinic_type.equals("C")){
		care_locn_ind_desc="Clinic";
	}else if(clinic_type.equals("E")){
		care_locn_ind_desc="Procedure Unit";
	}else if(clinic_type.equals("D")){
		care_locn_ind_desc="Day Care Unit";
	}
	String res_class_desc="";
	if(res_type.equals("P")){
		res_class_desc="Practitioner";
	}else if(res_type.equals("E")){
		res_class_desc="Equipment";
	}else if(res_type.equals("R")){
		res_class_desc="Room";
	}else if(res_type.equals("O")){
		res_class_desc="Others";
	}else if(res_type.equals("B")){
		res_class_desc="Bed";
	} 
	int cnter=0;
	String apptrefno=request.getParameter("i_appt_ref_no");
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	String old_alcn_catg_code="";
	String clinic_name="";
	String practitioner_name="";
	String clinic_id="";
	String INV_VISIT_MPQ_FROM_CA_YN="";
	String overbookedyn=request.getParameter("over_booked");
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	boolean referesh_flag=true;
	Properties p=(Properties)session.getValue("jdbc");
	String globaluser = (String)p.getProperty("login_user");
	String slot_appt_ctrl="";
	String visit_limit_rule="";			
	//String alcn_criteria="";			
	String override_no_of_slots_yn ="";			
	String capture_fin_dtls_yn ="";
	String min_ela_per_resc_noshow_in_day ="";
	String noshow_ctrl_by_splty_or_clinic ="";
	String contact_num_reqd_yn ="";
	String no_of_noshow_appts_for_alert ="";
	String per_chk_for_no_show_alert ="";
	

	%>

	<%!
			public String getCalendarString(Connection con,String arg)
			{
				
				Statement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				try
				{
					stmt=con.createStatement();
		   			sql="select get_calendar_string('"+arg+"') calen_val from dual";
					rs=stmt.executeQuery(sql);
					if(rs.next())
					RetString=rs.getString("calen_val");
					if(rs !=null) rs.close();
					if(stmt !=null)stmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:"+sql;
					e.printStackTrace();
				}
				return RetString;
			}
	%>

	<%!
			public String getCalanderStatusColor(String Facility_Id,String Clinic_Code, String Pract_Id, Connection con,String arg)
			{
				Statement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				
				try
				{
		   			stmt=con.createStatement();

					sql="SELECT GET_CALENDAR_STATUS_COLOR ('"+Facility_Id+"', '"+Clinic_Code+"', '"+Pract_Id+"','"+arg+"') sta_color FROM DUAL";

					rs=stmt.executeQuery(sql);
					if(rs.next())
						RetString=rs.getString("sta_color");
						if(rs !=null) rs.close();
						if(stmt !=null)stmt.close();

				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:"+sql;
					e.printStackTrace();
				}
				return RetString;
			}
	%>

	<%!

		public String getYearMonth(String state, int TotNum)
		{
			Calendar cal=Calendar.getInstance();
			int current=cal.get(Calendar.MONTH);

			String arg="";
			String mont="";
			if(state.equals("previous"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);

				if(cal.get(Calendar.MONTH)>=current)
					state="current";
			}

			if(state.equals("current"))
			{
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(state.equals("next"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(mont.length()==1)
					mont=0+mont;
				arg=arg+mont;

				return arg;
		}
	%>


	<SCRIPT>
		function populate(obj){
			var pract_id=document.forms[0].practitioner_id.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH clinic_type=\""+obj.value+"\" pract_id=\""+pract_id+"\" steps='CA' /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText) 
		}


		function callDisplayOAResultsblock(date)
		{
         alert(getMessage("SCHEDULE_BLOCK","OA")+" " +date);
		}
		function nextMonth(Totnum)
		{
				var obj=document.forms[0].new_pract;
				var  objvals=obj.value.split('&')
				var  cln_code=objvals[0];
				parent.frames[1].location.href='../../eCommon/html/blank.html'
				Totnum=Totnum+1
				var clinic_type= document.forms[0].locn_typee.value;
				var param="../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=<%=practitioner_id%>&i_clinic_code="+cln_code+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&patient_id=<%=ca_patient_id%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&clinic_type="+clinic_type+"&res_type=<%=res_type%>&status=P1&TotNum="+Totnum+"&callingMode=<%=callingMode%>&ref=T&change_sch=1";
				if(document.forms[0].new_pract.value==''){
					alert(getMessage("NO_LOCN_SPECIFIED","OA"))
				}else{
					self.location.href=param
				}


		}

		function previousMonth(Totnum)
		{
			
			if(Totnum>0)
			{
				parent.frames[1].location.href='../../eCommon/html/blank.html'
				Totnum=Totnum-1;
				var clinic_type= document.forms[0].locn_typee.value;
				var obj=document.forms[0].new_pract;
				var  objvals=obj.value.split('&')
				var  cln_code=objvals[0];

				var param="../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=<%=practitioner_id%>&i_clinic_code="+cln_code+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&patient_id=<%=ca_patient_id%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&clinic_type="+clinic_type+"&res_type=<%=res_type%>&status=M1&TotNum="+Totnum+"&callingMode=<%=callingMode%>&ref=T&change_sch=1";

				if(document.forms[0].new_pract.value==''){
					alert(getMessage("NO_LOCN_SPECIFIED","OA"))
				}else{
					self.location.href=param
				}


			}
		}

		function rfresh(obj)
		{
				
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				var clinic_type= document.forms[0].locn_typee.value;

				var param="../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=<%=practitioner_id%>&patient_id=<%=ca_patient_id%>&clinic_type="+clinic_type+"&res_type=<%=res_type%>&i_clinic_code="+obj.value+"&callingMode=<%=callingMode%>&ref=T";

				self.location.href=param
		}

		function change_schedule(){
		var obj=document.forms[0].new_pract;
		var clinic_type= document.forms[0].locn_typee.value;
		var  objvals=obj.value.split('&')
		var  cln_code=objvals[0];
		var spl_code=objvals[1];
		document.forms[0].speciality_code.value=spl_code;
		
		//this line added for this CRF PMG2013-CRF-0016 [IN:044523]
		var chck_flag=""; 
		if(obj.value=="")chck_flag="select";	
		var param="../../eOA/jsp/CAOAApptDairy.jsp?spl_code="+spl_code+"&i_practitioner_id=<%=practitioner_id%>&i_clinic_code="+cln_code+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&patient_id=<%=ca_patient_id%>&over_booked=<%=overbookedyn%>&clinic_type="+clinic_type+"&res_type=<%=res_type%>&alcn_criteria="+document.forms[0].alcn_criteria.value+"&callingMode=<%=callingMode%>&ref=T&change_sch=1&chck_flag="+chck_flag+"&flag_cln_code="+cln_code+"";
      /*Above line modified for this PMG2013-CRF-0016 [IN:044523]*/		
		self.location.href=param
		parent.frames[1].location.href='../../eCommon/html/blank.html'
		}


		function callDisplayOAResultsForOp(clinic, mon, yr,dt)
		{
			if(mon.length==1)
					mon="0"+mon
			if(dt.length==1)
					dt="0"+dt
			var dt=dt+"/"+mon+"/"+yr;
			var i_appt_ref_no=document.forms[0].apptrefno.value;
			var i_clinic_code=document.forms[0].clinic_code.value;
			var i_practitioner_id=document.forms[0].practitioner_id.value;
			var i_appt_date=document.forms[0].old_date.value;
			var new_appt_date=dt;
			var old_alcn_catg_code=document.forms[0].old_alcn_catg_code.value;			
			var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
			var over_booked=document.forms[0].over_booked.value;
			var ca_mode='ca_mode';
			var from_page='ca_appt_dairy';
			var ca_patient_id=document.forms[0].ca_patient_id.value;
			var callingMode=document.forms[0].callingMode.value;
			var res_type=document.forms[0].res_type.value;
			var clinic_type=document.forms[0].clinic_type.value;
			var oper_stn_id=document.forms[0].oper_stn_id.value;
			var slot_appt_ctrl = document.forms[0].slot_appt_ctrl.value;
			var visit_limit_rule= document.forms[0].visit_limit_rule.value;
			var alcn_criteria=document.forms[0].alcn_criteria.value;
			var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
			var capture_fin_dtls_yn=document.forms[0].capture_fin_dtls_yn.value;
			var min_ela_per_resc_noshow_in_day=document.forms[0].min_ela_per_resc_noshow_in_day.value;
			var noshow_ctrl_by_splty_or_clinic=document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
			var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
			var no_of_noshow_appts_for_alert= document.forms[0].no_of_noshow_appts_for_alert.value;
			var per_chk_for_no_show_alert= document.forms[0].no_of_noshow_appts_for_alert.value;
			
			var param="../../eOA/jsp/SinglePractVw.jsp?tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&old_alcn_catg_code="+old_alcn_catg_code+"&alcn_criteria="+alcn_criteria+"&i_appt_ref_no="+i_appt_ref_no+"&clinic_code="+i_clinic_code+"&practitioner_id="+i_practitioner_id+"&over_booked="+over_booked+"&callingMode="+callingMode+"&old_date="+i_appt_date+"&Date="+new_appt_date+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&clinic_type="+clinic_type+"&res_type="+res_type+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&from_page="+from_page+"&inv_visit_mpq_from_ca_yn="+document.forms[0].inv_visit_mpq_from_ca_yn.value+"&contact_num_reqd_yn="+contact_num_reqd_yn;

			parent.frames[1].location.href=param;



		}

		function onBlurCallPractitionerSearchQuery(obj,target){
				if(target.value==""){
					return
				}else{
					callPractSearchQuery(obj,target)
				}
		}
		function callPractSearchQuery(obj,target){
			var locale			  =document.forms[0].locale.value
			var facility_id		  =document.forms[0].facilityId.value
			var clinic_code		  =document.forms[0].new_pract.value
			var firstSql		  = "";
			var secondSql		  = "";
			var opne_all_pract_yn="Y";
			var practitionerName="";
			var practitionerValue="";
				
			target.value=trimString(target.value);
			practitionerName=target.name;
			practitionerValue=target.value;
			var practitioner_type = "";	


			if(opne_all_pract_yn=="Y"){
			firstSql=" SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, f.short_desc primary_specialty, a.gender gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d, am_practitioner_lang_vw a, OP_CLINIC e, am_speciality_lang_vw f WHERE a.language_id='"+locale+"' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE  UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND d.facility_id='"+facility_id+"' AND d.clinic_code= '"+clinic_code+"' AND e.speciality_code = f.speciality_code and f.language_id = '"+locale+"'";

			secondSql=" SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC  practitioner_type, f.short_desc primary_specialty, a.gender gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d, am_practitioner_lang_vw a, OP_CLINIC e, am_speciality_lang_vw f WHERE a.language_id='"+locale+"' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.practitioner_name) LIKE  UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND d.facility_id='"+facility_id+"' AND d.clinic_code= '"+clinic_code+"' AND e.speciality_code = f.speciality_code and f.language_id = '"+locale+"'";
			}else{
			firstSql= " SELECT b.practitioner_id practitioner_id , b.practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, b.gender gender , b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_speciality_lang_vw d WHERE b.language_id='"+locale+"' AND b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND UPPER(NVL(b.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code and c.facility_id = a.facility_id AND b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,'R','','E','','O','',c.pract_type),b.pract_type) AND c.speciality_code = d.speciality_code and d.language_id = '"+locale+"'  AND a.clinic_code='"+clinic_code+"' AND  a.facility_id='"+facility_id+"' AND a.eff_status = 'E' and exists ( select 1 from am_pract_for_facility where practitioner_id = b.practitioner_id and facility_id = '"+facility_id+"' and eff_status = 'E' ) ";

			secondSql= " SELECT b.practitioner_id practitioner_id , b.practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, b.gender gender , b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_speciality_lang_vw d WHERE b.language_id='"+locale+"' AND b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND UPPER(NVL(b.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code and c.facility_id = a.facility_id AND b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,'R','','E','','O','',c.pract_type),b.pract_type) AND c.speciality_code = d.speciality_code and d.language_id = '"+locale+"' AND a.clinic_code='"+clinic_code+"' AND  a.facility_id='"+facility_id+"' AND a.eff_status = 'E' and exists ( select 1 from am_pract_for_facility where practitioner_id = b.practitioner_id and facility_id = '"+facility_id+"' and eff_status = 'E' ) ";		
			}

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();

			xmlStr	="<root><SEARCH " ;
			xmlStr += " practName_FName=\"" + practitionerName + "\"";
			xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue) + "\"";
			xmlStr += " sql=\"" +escape(firstSql)+"\"";
			xmlStr += " sqlSec=\"" +escape(secondSql)+"\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + "" + "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			//eval(responseText);	
			//return;
			eval(practSearch(practitionerName,encodeURIComponent(practitionerValue),responseText));
		}
		
		async function practSearch(practName_FName,practName_FValue,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	<%-- var objName="<%=practName_FName%>"; --%>
	var objName=practName_FName;
    arguments='';
	
	<%-- retVal = window.showModalDipractName_FNamealog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	 --%>
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+"\""+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

		function PractLookupRetVal(retVal,objName)
		{
			var arr;
			if (retVal != null)
			{
				arr=retVal.split("~");
				document.forms[0].attend_practitioner_id.value=arr[0];
				document.forms[0].attend_practitioner_name.value=arr[1];
			}
			else
			{
				document.forms[0].attend_practitioner_id.value="";
				document.forms[0].attend_practitioner_name.value="";
			}
		}

		function callOPPage(){	
			var spl_code=document.forms[0].speciality_code.value
		
			if(parent.parent.frames[1].name=='myTasks'){	
				parent.parent.frames[5].location.href="../../eOP/jsp/ManageSPatQueue.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA&speciality_code="+spl_code+"&inv_visit_mpq_from_ca_yn="+document.forms[0].inv_visit_mpq_from_ca_yn.value;
			}else{
				//sep-10-2005 validation for 5028 patch
				if(parent.parent.frames[1].name=='menuFrame')					parent.frames.location.href="../../eOP/jsp/ManageSPatQueue.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA&speciality_code="+spl_code+"&inv_visit_mpq_from_ca_yn="+document.forms[0].inv_visit_mpq_from_ca_yn.value;
				else
				parent.parent.frames[1].location.href="../../eOP/jsp/ManageSPatQueue.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA&speciality_code="+spl_code+"&inv_visit_mpq_from_ca_yn="+document.forms[0].inv_visit_mpq_from_ca_yn.value;
			}
			
		}

	</SCRIPT>
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<%
			
			Connection con = null;
			Statement stmt=null;
			Statement stmt1=null;
			/*Below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
			Statement stmt3=null;
			ResultSet rs3=null;
			String loc_ind_flag="",loc_code="";	
			boolean schedule_chk_flag=false;
			String change_sch=request.getParameter("change_sch")==null?"":request.getParameter("change_sch");
			String chck_flag=request.getParameter("chck_flag")==null?"":request.getParameter("chck_flag");
			String flag_cln_code=request.getParameter("flag_cln_code")==null?"":request.getParameter("flag_cln_code");
			
			
			//End PMG2013-CRF-0016 [IN:044523]	
			
 			ResultSet rs=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			int coi=0;
			String week[]=new String[7];
			String day_type1[]=new String[7];
			String day_type2[]=new String[7];
			String day_type3[]=new String[7];
			String day_type4[]=new String[7];
			String day_type5[]=new String[7];
			String oper_stn_id="";
			boolean cur_day_flag=false; //PMG2013-CRF-0016 [IN:044523] 
			boolean cur_day_blocked_flag=false;//PMG2013-CRF-0016 [IN:044523] 
			String curr_date_flag="";
			try{

			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			stmt1 =con.createStatement();
			String sql2_oper_stn_id="SELECT a.oper_stn_id,a.book_appt_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+fid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			rs1 =stmt1.executeQuery(sql2_oper_stn_id);
			if(rs1 !=null && rs1.next())
			{
				oper_stn_id=rs1.getString("oper_stn_id");
			}
			if(rs1 !=null) rs1.close();
			String sql_alcn_slot_visit="SELECT SLOT_APPT_CTRL,VISIT_LIMIT_RULE,ALCN_CRITERIA,OVERRIDE_NO_OF_SLOTS_YN,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT FROM OA_PARAM WHERE MODULE_ID='OA'";
				rs2=stmt1.executeQuery(sql_alcn_slot_visit);
			if(rs2 !=null && rs2.next()){
				slot_appt_ctrl =rs2.getString("SLOT_APPT_CTRL");
				visit_limit_rule =rs2.getString("VISIT_LIMIT_RULE");
				alcn_criteria =rs2.getString("ALCN_CRITERIA");
				override_no_of_slots_yn =rs2.getString("OVERRIDE_NO_OF_SLOTS_YN");
				capture_fin_dtls_yn =rs2.getString("CAPTURE_FIN_DTLS_YN");
				min_ela_per_resc_noshow_in_day =rs2.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY");
				noshow_ctrl_by_splty_or_clinic =rs2.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC");
				contact_num_reqd_yn =rs2.getString("CONTACT_NUM_REQD_YN")==null?"N":rs2.getString("CONTACT_NUM_REQD_YN");
				no_of_noshow_appts_for_alert =rs2.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT")==null?"":rs2.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
				per_chk_for_no_show_alert =rs2.getString("PER_CHK_FOR_NO_SHOW_ALERT")==null?"":rs2.getString("PER_CHK_FOR_NO_SHOW_ALERT");
			}

			if(rs2 !=null) rs2.close();
			String sql_week="select substr(DAY_OF_WEEK,1,3) day_of_week,DAY_TYPE,DAY_NO,DAY_TYPE_WEEK_1,DAY_TYPE_WEEK_2,DAY_TYPE_WEEK_3,DAY_TYPE_WEEK_4,DAY_TYPE_WEEK_5 from sm_day_of_week order by DAY_NO";
				rs=stmt.executeQuery(sql_week);
					if(rs!=null){
					 while(rs.next()){
					  week[coi]=rs.getString("day_of_week");
					  day_type1[coi]=rs.getString("DAY_TYPE_WEEK_1");
					  day_type2[coi]=rs.getString("DAY_TYPE_WEEK_2");
					  day_type3[coi]=rs.getString("DAY_TYPE_WEEK_3");
					  day_type4[coi]=rs.getString("DAY_TYPE_WEEK_4");
					  day_type5[coi]=rs.getString("DAY_TYPE_WEEK_5");
					  coi++;
					}
					}

				if(rs !=null) rs.close();

			String inv_visit_frm_ca="SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fid+"'";
			rs=stmt.executeQuery(inv_visit_frm_ca);
			if(rs!=null && rs.next()){
				INV_VISIT_MPQ_FROM_CA_YN=rs.getString("INV_VISITREGN_MPQ_FROM_CA_YN");
			}
			if(rs !=null) rs.close();

			}
			catch(Exception es){
				out.println("Exec@4" +es);
				es.printStackTrace();
			}
			/*
			String Color_Code[]={"S","Y","G","R","B","H"};
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARed","OAHOLIDAY"};*/
			/*Modified By Dharma on Dec 4th against ML-BRU-SCF-1504 [IN:052807]*/
			String Color_Code[]={"S","Y","G","R","B","H","L","D"};
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARed","OAHOLIDAY","OALIGHTGREEN","OADARKGREEN"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

			String cliniccode=request.getParameter("location_code");
			if (cliniccode==null)
			cliniccode=request.getParameter("i_clinic_code");

			String colorclass="";
			String status=request.getParameter("status");
			String recall_date=request.getParameter("recall_date");
			String state="current";
			String cur_date="";
			String cur_dat="";
			
			/*Above line Added for this CRF PMG2013-CRF-0016 [IN:044523]*/
			
			if(status!=null)
			{
				if(status.equals("P1"))
					state="next";
				if(status.equals("M1"))
					state="previous";
			}
			
			try
			{
				if(rs !=null) rs.close();
				if(request.getParameter("TotNum")!=null){
				TotNum=Integer.parseInt(request.getParameter("TotNum"));
				}
				else{	
				int curr_month=0;
				String sql_date="select to_char(sysdate,'mm')curr_month,to_char(sysdate,'dd/mm/yyyy') old_date from dual";
				rs=stmt.executeQuery(sql_date);
					if(rs.next()){
					curr_month=rs.getInt("curr_month");
					old_date=rs.getString("old_date");
					if(old_date ==null) old_date="";
					}

					if(rs !=null) rs.close();

					if(recall_date ==null) recall_date=old_date;
				String mon_date="";	
				StringTokenizer stoken = new StringTokenizer(recall_date,"/");
				int count=0;
				while(stoken.hasMoreTokens())
				{
					String mon		= stoken.nextToken();
						if(count==1){
						mon_date=mon;}
						count++;
						

				}
				int month_of_year=Integer.parseInt(mon_date);
				TotNum=month_of_year-curr_month;	
				}

				if(TotNum==0)
				{
				state="current";
				}
				else
				{
					if(TotNum > 0)
					{
					   state="next";
					}
				}

				
				
			}
			catch(Exception e){
				out.println("Exec@1"+e);
				e.printStackTrace();
			}
			
			
			String arg=getYearMonth(state,TotNum);

			String CalString=(String)getCalendarString(con,arg);

			String ColorString=getCalanderStatusColor(fid,cliniccode,practitioner_id,con,arg);

			String yr=arg.substring(0,4);
			String yr_display=DateUtils.convertDate(yr,"YY","en",locale);
			int mon=Integer.parseInt(arg.substring(4,arg.length()));
			String month=months[mon-1];
				String month_display="";
			if(month.equals("January"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.January.label","common_labels");
				}else if(month.equals("February"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.February.label","common_labels");
				}else if(month.equals("March"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.March.label","common_labels");
				}else if(month.equals("April"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.April.label","common_labels");
				}else if(month.equals("May"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.May.label","common_labels");
				}else if(month.equals("June"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.June.label","common_labels");
				}else if(month.equals("July"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.July.label","common_labels");
				}else if(month.equals("August"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.August.label","common_labels");
				}else if(month.equals("September"))
				{
				month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.September.label","common_labels");
				}else if(month.equals("October"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.October.label","common_labels");
				}else if(month.equals("November"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.November.label","common_labels");
				}else if(month.equals("December"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.December.label","common_labels");
				}
			StringTokenizer splitdays=new StringTokenizer(CalString,"|");
			String[] NumOfDays=new String[splitdays.countTokens()];

			StringTokenizer ColVals=new StringTokenizer(ColorString,"|");
			String colors[]=new String[ColVals.countTokens()];

			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]=splitdays.nextToken();
			for(int i=0;i<colors.length;i++)
				colors[i]=ColVals.nextToken();

				int ro=NumOfDays.length/7;
				
				int rodup=1;
				int ccols=7;
				String dat="";
				int act=0;
			%>

		<form name="ca_oaappt" id="ca_oaappt"> <!-- this line modified for this CRF PMG2013-CRF-0016 [IN:044523] -->
		
		<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>' > <!--this line moved here for this CRF PMG2013-CRF-0016 [IN:044523]   -->
			<table border=0 cellspacing=0 cellpadding=0 width='100%'>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='label' colspan='3'>&nbsp;</td></tr>
			<tr><td class='label' colspan='3'></td></tr><tr><td class='label' colspan='3'></td></tr>
			<tr><td class='label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>			
			<%
			if(!callingMode.equals("CA") && !callingMode.equals("CA_WIDGET")){%>
				<td class='fields' width='40%'>
				<%=care_locn_ind_desc%></td>
			<%}else {			   
				/*Below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/				
				if(chck_flag.equals("")){
				String loc_type_ind="SELECT DISTINCT (care_locn_type_ind) care_locn_type_ind,DECODE (care_locn_type_ind,'E', 'Procedure Unit','C', 'Clinic','D', 'Day Care Unit') descrip,TO_CHAR (start_time,'hh24:mi') strdate, TO_CHAR (end_time,'hh24:mi') enddate FROM oa_clinic_schedule WHERE facility_id ='"+fid+"'   AND practitioner_id = '"+practitioner_id+"'    AND  primary_resource_yn = 'Y' AND resource_class = 'P' and trunc(clinic_date,'dd') = trunc(sysdate,'dd') and to_char(sysdate ,'hh24:mi') between to_char(start_time,'hh24:mi') and to_char(end_time,'hh24:mi') order by strdate,enddate, descrip";
				
				
				stmt3 =con.createStatement();
				rs3 = stmt3.executeQuery(loc_type_ind);
				if(rs3!=null && rs3.next()){						
						loc_ind_flag=rs3.getString("care_locn_type_ind")==null?"":rs3.getString("care_locn_type_ind");
					
				}
				if(rs3!=null) rs3.close();
				if(stmt3!=null) stmt3.close();
				
				
				if(loc_ind_flag.equals("")){
				String loc_type_ind_chkdate="SELECT DISTINCT (care_locn_type_ind) care_locn_type_ind,DECODE (care_locn_type_ind,'E', 'Procedure Unit','C', 'Clinic','D', 'Day Care Unit') descrip FROM oa_clinic_schedule WHERE facility_id ='"+fid+"'   AND practitioner_id = '"+practitioner_id+"' and clinic_date >= trunc(sysdate)   AND  primary_resource_yn = 'Y' AND resource_class = 'P'  order by descrip";
				
				stmt3 =con.createStatement();
				rs3 = stmt3.executeQuery(loc_type_ind_chkdate);
				if(rs3!=null && rs3.next()){						
						loc_ind_flag=rs3.getString("care_locn_type_ind")==null?"":rs3.getString("care_locn_type_ind");
					
				}				
				if(rs3!=null) rs3.close();
				if(stmt3!=null) stmt3.close();
				}	
				}
				//End this CRF PMG2013-CRF-0016 [IN:044523]
				
				
			%>
				<td class='fields' width='40%'>

				<%String locn_typ_str="select distinct(CARE_LOCN_TYPE_IND) CARE_LOCN_TYPE_IND,decode(CARE_LOCN_TYPE_IND,'E', 'Procedure Unit','C','Clinic','D','Day Care Unit') descrip   from  oa_clinic_schedule where facility_id ='"+fid+"' and practitioner_id ='"+practitioner_id+"' and trunc(clinic_date) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y'";
				rs=null;
				rs = stmt.executeQuery(locn_typ_str);
				%>
				<select name="locn_typee" id="locn_typee" onchange="populate(this);change_schedule();">
					<%if(ref_md.equals("T")){%>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%}
				
				if(rs !=null){
					while ( rs.next() )	{
						cnter=cnter+1;
						
						String car_loc_int=rs.getString("CARE_LOCN_TYPE_IND")==null?"":rs.getString("CARE_LOCN_TYPE_IND");
						String car_loc_desc=rs.getString("descrip")==null?"":rs.getString("descrip");

						 
						
						if(ref_md.equals("F")){ 
							//Below line Added this CRF PMG2013-CRF-0016 [IN:044523] 							
							 if(!loc_ind_flag.equals("") && car_loc_int.equals(loc_ind_flag)){ schedule_chk_flag=true;%>
								 <option value='<%=car_loc_int%>' selected><%=car_loc_desc%></option> 	
							         
							 <%}else{ %>
							    <option value='<%=car_loc_int%>'><%=car_loc_desc%></option> 	
						    <%} //End this CRF PMG2013-CRF-0016 [IN:044523]
						
							 }else{
								if(car_loc_int.equals(clinic_type)){%>
								<option value='<%=car_loc_int%>' selected><%=car_loc_desc%></option> 
							<%}else{%>
								<option value='<%=car_loc_int%>'><%=car_loc_desc%></option> 
							<%}
						}
					}
				}
				
				%>
				</select>
				<%if(cnter>=1){ //this line modified for this CRF  PMG2013-CRF-0016 %>
					<script>
					
					obj=document.forms[0].locn_typee
					var len=obj.options.length;
					var i=0;
					opt=document.createElement('OPTION');
					</script>
				<%}else{
					//if(ref_md.equals("F")){
					/*Above line commented and below line added for this CRF PMG-CRF-16*/	
					  if(ref_md.equals("F") && loc_ind_flag.equals("")){%>
						<script>
						obj=document.forms[0].locn_typee
						var len=obj.options.length;
						var i=0;
						opt=document.createElement('OPTION');

						opt.value='';
						opt.text='  ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---  ';
						obj.add(opt);
						document.forms[0].locn_typee.value='';
						</script>
					<%}
				}%>
				</td>
			<%}%>
			</tr>
			<tr>
			<tr><td class='label' width='18%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' width='40%'>			
			<%String clinic_code1= request.getParameter("i_clinic_code");%>

			<%String clinic_str="";
			if(callingMode.equals("OP")){
				clinic_str="select a.clinic_code, a.long_desc,a.speciality_code from op_clinic_lang_vw a where a.clinic_code ='"+clinic_code1+"' and	a.facility_id ='"+fid+"' and a.language_id = '"+locale+"'";
			}else{
				clinic_str="select a.clinic_code, a.long_desc,a.speciality_code from op_clinic_lang_vw a where a.facility_id ='"+fid+"' and a.language_id = '"+locale+"' and exists (select clinic_code from oa_clinic_schedule where facility_id ='"+fid+"' and practitioner_id ='"+practitioner_id+"' and trunc(clinic_date) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y' and facility_id = a.facility_id and clinic_code = a.clinic_code) order by long_desc";
				
			}
			rs=null;
			
			if(callingMode.equals("OP")){
				rs = stmt.executeQuery(clinic_str);

				if(rs !=null){
					while ( rs.next() )	{
						clinic_name= rs.getString("long_desc");
						clinic_id= rs.getString("clinic_code");							
						splty_code= rs.getString("speciality_code");							
						referesh_flag =false;							
					}					
				}
				%>
				<b><%=clinic_name%></b>
				<input type="hidden" name="new_pract" id="new_pract" value="<%=clinic_id%>">
			<%}else{%>
				<select name='new_pract' id='new_pract' onchange='change_schedule()'>
					<%
					if(ref_md.equals("F")){%>
					<%if (!ca_patient_id.equals("")){%>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%}%>
						<% //if (cnter==1){
                 		/*Above line commented and below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
						if (cnter>=1){
							rs = stmt.executeQuery(clinic_str);

							if(rs !=null){
							while ( rs.next() )	{
								ij++;
								clinic_name= rs.getString("long_desc");
								clinic_id= rs.getString("clinic_code");
								splty_code= rs.getString("speciality_code");
								if(! i_Clinic_code_sel.equals("N")){
									if(i_Clinic_code_sel.equals(clinic_id)){
										out.println("<option value='"+clinic_id+"&"+splty_code+"' selected>"+clinic_name);
										referesh_flag =false;
									}else{
										out.println("<option value='"+clinic_id+"&"+splty_code+"' >"+clinic_name);

									}
								}else{
									out.println("<option value='"+clinic_id+"&"+splty_code+"' >"+clinic_name);
								}
							}
							if(ij==0){
								no_sch_flag=true;
							}else{
								if(!i_Clinic_code_sel.equals("N")){
									referesh_flag =false;								
								}
							}
						}else{

							no_sch_flag=true;
						}
					}else{
						referesh_flag =false;
					}
				}else{%>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%
					clinic_str  ="select a.clinic_code, a.long_desc,a.speciality_code from op_clinic_lang_vw a where a.facility_id ='"+fid+"' and a.language_id ='"+locale+"' and exists (select clinic_code from oa_clinic_schedule where facility_id ='"+fid+"' and practitioner_id ='"+practitioner_id+"' and trunc(clinic_date) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y' and care_locn_type_ind='"+clinic_type+"' and facility_id = a.facility_id and clinic_code = a.clinic_code) order by long_desc " ;
					rs = stmt.executeQuery(clinic_str);

					 while(rs!=null && rs.next() ){
						if(clinic_code.equals(rs.getString("clinic_code"))){
							out.println("<option value='"+rs.getString("clinic_code")+"&"+rs.getString("speciality_code")+"' selected>"+rs.getString("long_desc"));
						}else{
							out.println("<option value='"+rs.getString("clinic_code")+"&"+rs.getString("speciality_code")+"' >"+rs.getString("long_desc"));
						}
					}
					referesh_flag =false;
				}%>
				</select>
			<%}%></td></tr>
			<!--Below line Added for this CRF PMG2013-CRF-0016 [IN:044523]  -->
				<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
                <input type="hidden" name="speciality_code" id="speciality_code" value="<%=splty_code%>">				
			    <input type="hidden" name="location_ind_flag" id="location_ind_flag" value="<%=loc_ind_flag%>"> 
			    <input type="hidden" name="change_schedule_flag" id="change_schedule_flag" value="<%=change_sch%>"> 
			   <script> 
			   //if('<%=loc_ind_flag%>'!="" && '<%=clinic_code%>'=="" || '<%=loc_ind_flag%>'!="" &&'<%=clinic_code%>'!=""){populate(document.ca_oaappt.locn_typee);}			  
			   if('<%=change_sch%>'=="" &&'<%=clinic_code%>'=="" || '<%=change_sch%>'=="" &&'<%=clinic_code%>'!=""){populate(document.ca_oaappt.locn_typee);}
			   if((document.ca_oaappt.new_pract && document.ca_oaappt.new_pract.value!="") && (document.ca_oaappt.change_schedule_flag && document.ca_oaappt.change_schedule_flag.value=="")){change_schedule();}</script>		
	          <!-- End PMG2013-CRF-0016 [IN:044523] -->	
				
			<%
 			try
 			{
				if(rs !=null) rs.close();
			
				String pract_str="";
				
				/*Below line modified for this CRF PMG-CRF-16*/ 
				if(res_type.equals("P")){
					pract_str="select practitioner_name,to_char(sysdate,'dd/mm/yyyy') cur_date from am_practitioner_lang_vw where  practitioner_id='"+practitioner_id+"' and language_id = '"+locale+"'";
				}else if(res_type.equals("R")){
					pract_str="select room_num Practitioner_id, long_desc practitioner_name,to_char(sysdate,'dd/mm/yyyy') cur_date from am_facility_room_lang_vw where Facility_id ='"+fid+"' and room_num='"+practitioner_id+"' and language_id = '"+locale+"' order by long_desc";

					//select Practitioner_id , practitioner_short_name practitioner_name description from op_pract_for_clinic_vw where clinic_code='"+clinic_code+"' and Facility_id ='"+fid+"' and resource_class='R' and Practitioner_id='"+practitioner_id+"' order by  practitioner_short_name
				}else{
				pract_str="select short_desc practitioner_name,to_char(sysdate,'dd/mm/yyyy') cur_date from am_resource_lang_vw where Facility_id='"+fid+"' and resource_id = '"+practitioner_id+"' and and language_id = '"+locale+"' order by a.short_desc";


				//	pract_str="select a.short_desc practitioner_name from am_resource a,op_pract_for_clinic b where a.resource_id =b.practitioner_id and a.resource_class= '"+res_type+"' and b.clinic_code='"+clinic_code+"' and a.Facility_id=b.facility_id and a.Facility_id='"+fid+"' and b.practitioner_id='"+practitioner_id+"' order by a.short_desc";
				}
				
				rs = stmt.executeQuery(pract_str);
				if(rs !=null){
					while ( rs.next() )
						{
							practitioner_name= rs.getString("practitioner_name");
							cur_date= rs.getString("cur_date");
						}
				}
							
					if(rs !=null) rs.close();

				if(practitioner_name==null) practitioner_name="";			
			
			if(rs !=null) rs.close();
		%>
			<tr>
			<td class='label' width='20%'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td class='fields' width='40%' colspan='3'>&nbsp;<b><%=res_class_desc%>/
			</td>				
			</tr>			
			<tr><td></td><td class='fields' width='40%' colspan='3'>&nbsp;<b><%=practitioner_name%></td></tr>
			<tr><td class='label' colspan='3'></td></tr><tr><td class='label' colspan='3'></td></tr><tr><td class='label' colspan='3'></td></tr><tr><td class='label' colspan='3'></td></tr>
			<tr><td class='white'>&nbsp;</td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			</table>
			<%
				String my=month_display+","+yr_display;				
			%>
			<table  align='center' border=0 cellspacing=0 cellpadding=0 width='98%'>
			<tr >
				<td  width='98%' class='white' >
				<table cellspacing=0 cellpadding=0  width='98%' style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt' border='0'>
					
					<tr>
						<td align='center' width='10%'><input type='button' class='button' value="<---" name='prev' id='prev'  onclick=previousMonth(<%=TotNum%>)></td>
						<td align='center' class="DISPDATE" width='140%'><font size=3><b><%=my%></b></font></td>
						<td align='center' width='10%'><input type='button' class='button' value="--->" name='next' onclick=nextMonth(<%=TotNum%>)></td>
					</tr>
				</table>
				</td>
			</tr>
			<input type='hidden' name='callingMode' id='callingMode' value='<%=callingMode%>' >
			<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>' >
			
			<input type='hidden' name='apptrefno' id='apptrefno' value='<%=apptrefno%>' >
			<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>' >
			<input type='hidden' name='old_alcn_catg_code' id='old_alcn_catg_code' value='<%=old_alcn_catg_code%>' >
			<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
			<input type='hidden' name='over_booked' id='over_booked' value='<%=overbookedyn%>' >
			<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>' >
			<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
			<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
			<input type="hidden" name="slot_appt_ctrl" id="slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
			<input type="hidden" name="visit_limit_rule" id="visit_limit_rule" value="<%=visit_limit_rule%>">
			
			<input type="hidden" name="override_no_of_slots_yn" id="override_no_of_slots_yn" value="<%=override_no_of_slots_yn%>">
			<input type="hidden" name="capture_fin_dtls_yn" id="capture_fin_dtls_yn" value="<%=capture_fin_dtls_yn%>">
			<input type="hidden" name="min_ela_per_resc_noshow_in_day" id="min_ela_per_resc_noshow_in_day" value="<%=min_ela_per_resc_noshow_in_day%>">
			<input type="hidden" name="noshow_ctrl_by_splty_or_clinic" id="noshow_ctrl_by_splty_or_clinic" value="<%=noshow_ctrl_by_splty_or_clinic%>">
			<input type="hidden" name="contact_num_reqd_yn" id="contact_num_reqd_yn" value="<%=contact_num_reqd_yn%>">
			<input type="hidden" name="no_of_noshow_appts_for_alert" id="no_of_noshow_appts_for_alert" value="<%=no_of_noshow_appts_for_alert%>">
			<input type="hidden" name="per_chk_for_no_show_alert" id="per_chk_for_no_show_alert" value="<%=per_chk_for_no_show_alert%>">
			<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
			<input type="hidden" name="facilityId" id="facilityId" value="<%=fid%>">			
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
						
			<input type="hidden" name="inv_visit_mpq_from_ca_yn" id="inv_visit_mpq_from_ca_yn" value="<%=INV_VISIT_MPQ_FROM_CA_YN%>">
			
				
		
			</form>
		<tr>
		<table width='96%'  align='center' cellpadding=0  style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt '>
		<tr>
			<%for( int j=0;j<week.length;j++){
					String week1[]=new String[7];
						if(week[j].equals("SUN"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");
		}else if(week[j].equals("MON"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
		}else if(week[j].equals("TUE"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
		}else if(week[j].equals("WED"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
		}else if(week[j].equals("THU"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
		}else if(week[j].equals("FRI"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");
		}else if(week[j].equals("SAT"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
		}
				%>
				<th width='3%' align='center' ><font size=1><%=week1[j]%></th>	<%}%>
		</tr>
		<%for( int j=0;j<ro;j++)
			{
			
			%>
				  <tr>
				  	<%

				  	for(int k=0;k<ccols;k++)
				  	{
						
						if(k==1)
							{
						if(day_type1[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
						}

						if(k==2)
						{
						if(day_type2[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==3)
							{
						if(day_type3[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==4)
							{
						if(day_type4[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==5)
							{
						if(day_type5[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

						if(act<NumOfDays.length)
				  		{
				  			if(!NumOfDays[act].equals("0"))
				  			{
				  				dat=NumOfDays[act];
				  				for(int i=0;i<Color_Code.length;i++)
				  				{
				  					if(Color_Code[i].equals(colors[act]))
				  						colorclass=Color_Val[i];
				  				}
				  			}
				  			else
				  			{
				  				if(rodup==(NumOfDays.length/7) && 	NumOfDays[act].equals("0"))
				  				{
				  					dat="&nbsp";
				  					break;
				  				}
				  				else{
				  					dat="&nbsp";
									
								}

				  			}
				  		}
				  		else{
				  			dat="&nbsp";
						}
						
				  			String anch=" ";
							//Below line added for this CRF PMG2013-CRF-0016 [IN:044523] 
				  			if(dat.length()<2)
				  				dat="0"+dat;
							
							/*Below line added for the incident [47524]*/
							String monofyesr=Integer.toString(mon);	
							if(monofyesr.length()<2)monofyesr="0"+monofyesr;							
							String title=dat+"/"+monofyesr+"/"+yr;
							//End 47524
							
				  			act++;
				  			if(!(colorclass==null || colorclass.equals("") || colorclass.equals("OABrown")) ){
							if (colorclass.equals("OARed")){
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";
                            if(title.equals(cur_date)){ //Added for this CRF PMG2013-CRF-0016 [IN:044523] 
									cur_day_blocked_flag=true;
									curr_date_flag=title;
								}	
 							
							}else{
								anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"') title='"+title+"'  >";
								if(title.equals(cur_date)){ //Added for this CRF PMG2013-CRF-0016 [IN:044523] 
									cur_day_flag=true;
									cur_dat=dat;
								}
							}
							}
				  
					if(allow_click){
						if(colorclass.equals("OAHOLIDAY"))
						{
						%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font 	size=2><%=dat%></a></td>
					  	<%
						}
					else
						{
						%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=anch%><%=dat%></a></td>
					  	<%
						}
					}
					else{
					if(!(colorclass == null || colorclass.equals("")))
						{
                         if(colorclass.equals("OAHOLIDAY"))
							{
							%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=dat%></a></td>
				  			<%
							}
							else							
							{
							%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=anch%><%=dat%></a></td>
				  				<%
						}
						}
						else
						{
							%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=dat%></a></td>
				  			<%
				  		}
					}
					colorclass="";	  	
						
					
					}

				  	%>
				  </tr>
		<%rodup++;
			}%>
		</tr>		
		</table>
		<%if(INV_VISIT_MPQ_FROM_CA_YN.equals("Y") && ca_patient_id.equals("")){%>
		<table align='right' width="25%">
		<tr><td><input type='button' class='button' name='search' id='search' value='<fmt:message key="Common.ManageQueue.label" bundle="${common_labels}"/>' onclick='callOPPage()'></td></tr>
		</table>
		<%}
		if(no_sch_flag){%>
			<script>alert(getMessage("SCH_NOT_AVAILABLE","OA"));
			location.href="../../eCommon/html/blank.html";
			</script>
		<%}else{
			if (referesh_flag){%>

			<script>change_schedule()</script>
			<%
			}else{
				if(ref_md.equals("F")){%>
					<script>
					//alert(document.forms[0].new_pract.options.length)
					/*obj=document.forms[0].new_pract
					var len=obj.options.length;
					var i=0;
					opt=document.createElement('OPTION');

					opt.value='';
					opt.text='  ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---  ';
					obj.add(opt);*/
					//alert(document.forms[0].new_pract.options.length)
					//document.forms[0].new_pract.value='';
					</script>
			<%}	
			}
		}
		/*Below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
		if(cur_day_flag){%>
		<script>
		callDisplayOAResultsForOp('<%=cliniccode%>','<%=mon %>','<%=yr%>','<%=cur_dat%>');</script><%}
if(cur_day_blocked_flag && curr_date_flag!=""){%>
		<script>
		setTimeout("callDisplayOAResultsblock('<%=curr_date_flag%>')",300)</script><%}		
		//End this CRF PMG2013-CRF-0016 [IN:044523]
			if(rs !=null)		rs.close();
			if(rs1 !=null)      rs1.close();
			if(rs2 !=null)      rs2.close();
			if(rs !=null)		rs.close();
			if(stmt !=null)		stmt.close();
			if(stmt !=null)		stmt.close();
			if(stmt1 !=null)    stmt1.close();
			if(stmt !=null)		stmt.close();
				
}catch(Exception e)
{
	out.println("ERROR@2" +e);
	e.printStackTrace();
}finally
{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
			%>
	</body>
</html>

