<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.lang.*,java.text.*,java.util.*,eCommon.Common.*,webbeans.eCommon.*" %>
 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="javascript" src="../../eCommon/js/common.js"> 		</script>
	<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eOA/js/OAParameter.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>


<SCRIPT>
 function tab_click(objName)
	{
	//	alert("objName---->"+objName);
		   if(objName=="general")
			{
				//document.getElementById("general1").scrollIntoView();
		        //document.forms[0].override_no_of_slots_yn.focus();
				//document.forms[0].gen_rep_div.style.visibility='visible';
				document.getElementById("general_div").style.visibility='visible';
				document.getElementById("general_div").style.display='';
				document.getElementById("report_div").style.visibility='hidden';
				document.getElementById("report_div").style.display='none';
			}
		   if(objName=="report")
			{
				//document.getElementById("report1").scrollIntoView();
		        //document.forms[0].DATE_LABEL.focus();
               // document.forms[0].gen_rep_div.style.visibility='visible'; 
				document.getElementById("report_div").style.visibility='visible';
				document.getElementById("report_div").style.display='';
				document.getElementById("general_div").style.visibility='hidden';
				document.getElementById("general_div").style.display='none';

			}
	}

	function check(){
                 //setTimeout("tab_click('general')",65);
	             document.forms[0].override_no_of_slots_yn.focus();						
	}
	function check1(){
				 document.forms[0].DATE_LABEL.focus();		
	}
	function checkbox_value(obj)
	{
		if (obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
	}
    function tabout(obj)
	{ 
		document.getElementById("second_tab").scrollIntoView();
	}
	function tabout2(obj)
	{ 
		document.getElementById("third_tab").scrollIntoView();
	}

    function tabout3(obj)
	{ 
	 //alert(parent.frames[1].name);
		document.getElementById("fourth_tab").scrollIntoView();
	}
	function tabout4(obj)
	{ 
	 //alert(parent.frames[1].name);
		document.getElementById("fifth_tab").scrollIntoView();
	}
	function tab_click1(objName)
    {
		selectTab(objName);
        tab_click(objName);
		

    }
	
function makeValidStringOA(txtObj)
{
    var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+''+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
   /* txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
	*/
}	
</SCRIPT>

</head>


<%
String operation="insert";
request.setCharacterEncoding("UTF-8");

%>

<%
String alcn_basis="",alcn_criteria="",slot_appt_ctrl="",slot_appt_ctrl_desc="",visit_limit_rule="",visit_limit_rule_desc="",override_no_of_slots_yn="",appt_slip_remarks1="",appt_slip_remarks2="",appt_slip_remarks3="",appt_slip_remarks4="",appt_slip_remarks5="",max_recurr_days="",ELAPSED_GRACE_PERIOD="",FORCECLOSE_PERIOD="",DATE_LABEL ="",REF_NO_LABEL ="",NAME_LABEL   ="",ADDRESS_LABEL ="",NAT_ID_LABEL ="",SALUTATION_LABEL ="",MEDICAL_OFFICER_LABEL ="",CLINIC_LABEL ="",NO_SHOW_TITLE ="",NO_SHOW_TEXT1 ="",NO_SHOW_TEXT2 ="",NO_SHOW_TEXT3 ="",NO_SHOW_TEXT4 ="",NO_SHOW_TEXT5 ="",TFR_SCH_TITLE    ="",TFR_SCH_TEXT1 ="",TFR_SCH_TEXT2  ="",TFR_SCH_TEXT3   ="",TFR_SCH_TEXT4  ="",TFR_SCH_TEXT5   ="",BLK_CANC_TITLE  ="",BLK_CANC_TEXT1   ="",BLK_CANC_TEXT2   ="", BLK_CANC_TEXT3    ="",BLK_CANC_TEXT4  ="",BLK_CANC_TEXT5="",min_ela_per_resc_noshow_in_day="",noshow_ctrl_by_splty_or_clinic="",
TKS_LABEL="",capture_fin_dtls_yn="",contact_num_reqd_yn="",no_of_noshow_appts_for_alert="", per_chk_for_no_show_alert="",send_reminder_for_appt_before="",email_appl_yn="",email_appl_yn1="";
//String email_appl_yn_for_appt_wo_pid="";
String emailappli="";
//String chkAttribute="";
//String chkAttribute1="";
//String emailapplidisable="";

//String sendreminder="";
//String allocation_role="";
//String allocation_role_desc="";
String alcn_code="",alcn_desc="";
//String alcn_appl_yn="";
//String eff_status="";
String alcn_applicable_yn="N";
String temp_alcn_code="";
String temp_alcn_desc="";
//By Sudhakar RUT-CRF-0005 Starts
String rule_appl_yn="",rule_enable_disable,rule_appl_Checked="",mob_num_req_yn="",mob_num_req_Checked="",lang_req_yn="",lang_req_Checked="";
String rd_oa_integration_yn = "";
String ris_oa_ing_chk="";
String group_appt_yn_chk="";
String risOaIngenable="";
String no_of_resch_appts_for_alert="";
String per_chk_fut_resch_appts="";
String no_of_cancld_appts_for_alert="";
String per_chk_cancld_fut_appts="";
String per_chk_past_resch_appts="";
String per_chk_cancld_past_appts="";
String rule_check_attribute="";
String no_of_fut_appts_for_alert="";
String per_chk_for_fut_appts_alert="";
boolean oa_remarks_ctrl=false;
int remark_size=80;
int remark_maxlength=80;
//By Sudhakar RUT-CRF-0005  Ends
String group_appt_yn = "";


String bl_operational	= (String)session.getValue("bl_operational"); 
String customer_id		= (String)session.getValue("CUSTOMER_ID");

String rule_sch_appl_cust_YN="N";// This data has to come from new table.
String ris_oa_integrate="N";// This data has to come from sm_function_control table.
String group_appt_integrate="N";

//Bru-HIMS-CRF 169 changes - start
String reason_pat_cancel_appt="";
String max_cancelled_appt="";
String locale=(String)session.getAttribute("LOCALE"); 
//Bru-HIMS-CRF 169 changes - end

String blk_schdl_with_appt_yn="N";//JD-CRF-0168 changes
String blk_schdl_with_appt_checked="";//JD-CRF-0168 changes
String blk_schdl_with_appt_disabled="";//JD-CRF-0168 changes
String upt_contact_dtls_mp_yn="N";//added changes for HSA-CRF-0226 [IN:050599] 
String upt_contact_dtls_checked="";//added changes for HSA-CRF-0226 [IN:050599]

String UNINVITED_PERIOD="",waitlist_category_appl_yn="",waitlist_category_reqd_yn="",invitation_list_appl_yn="",restrict_wl_cat_agst_splty_yn="";
String action_on_holiday_schedule="";//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
Connection con=null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
Statement stmt2=null;
ResultSet rset1=null;
ResultSet rset2=null;
//ResultSet pstmtrs=null;
//PreparedStatement pstmt=null;

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
Boolean isScheduleExtendAppl = false;
String schedule_extend_yn = "N";
String schedule_extend_yn_chk = "";

try{
	/*String currentDate=com.ehis.util.DateUtils.getCurrentDate("DMYHM","th");
	*/
	con=ConnectionManager.getConnection(request);

	isScheduleExtendAppl = CommonBean.isSiteSpecific(con,"OA","SCHEDULE_EXTEND");//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

	stmt=con.createStatement();
	//String testSql="select distinct patient_id from oa_appt where patient_id in(?,'HC00001115','HC00001116')";
	//String testSql="select distinct patient_id from oa_appt where patient_id in(?,','||patient_id||',')";
	/*String testSql="select distinct patient_id from oa_appt where patient_id in(?,','||patient_id||',')";
	pstmt=con.prepareStatement(testSql) ;
	pstmt.setString(1,"'HC00001115','HC00001116'");
	//pstmt.setString(1,"HC00001115");
	pstmtrs=pstmt.executeQuery();
	while(pstmtrs!=null && pstmtrs.next()){
		out.println("patient_id ==>"+pstmtrs.getString("patient_id"));
	}*/

	String sql="select alcn_basis,alcn_criteria,slot_appt_ctrl,decode(slot_appt_ctrl,'P','Patients','S','Slots') slot_appt_ctrl_desc, visit_limit_rule,decode(visit_limit_rule,'M','Max No of Visits','E','Exact No of Visits','N','None') visit_limit_rule_desc,override_no_of_slots_yn,appt_slip_remarks1,appt_slip_remarks2,appt_slip_remarks3, appt_slip_remarks4, appt_slip_remarks5,max_recurr_days,ELAPSED_GRACE_PERIOD,FORCECLOSE_PERIOD,UNINVITED_PERIOD,WAITLIST_CATEGORY_APPL_YN,WAITLIST_CATEGORY_REQD_YN,INVITATION_LIST_APPL_YN,RESTRICT_WL_CAT_AGST_SPLTY_YN,DATE_LABEL ,  REF_NO_LABEL ,   NAME_LABEL   ,   ADDRESS_LABEL ,   NAT_ID_LABEL ,   SALUTATION_LABEL ,  MEDICAL_OFFICER_LABEL ,   CLINIC_LABEL ,     NO_SHOW_TITLE ,    NO_SHOW_TEXT1 ,  NO_SHOW_TEXT2 , NO_SHOW_TEXT3 ,  NO_SHOW_TEXT4 ,  NO_SHOW_TEXT5  ,  TFR_SCH_TITLE    ,     TFR_SCH_TEXT1 , TFR_SCH_TEXT2  , TFR_SCH_TEXT3   ,TFR_SCH_TEXT4    , TFR_SCH_TEXT5 ,    BLK_CANC_TITLE  ,   BLK_CANC_TEXT1   ,BLK_CANC_TEXT2  , BLK_CANC_TEXT3   , BLK_CANC_TEXT4   , BLK_CANC_TEXT5   , TKS_LABEL ,CAPTURE_FIN_DTLS_YN,min_ela_per_resc_noshow_in_day, noshow_ctrl_by_splty_or_clinic,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT, PER_CHK_FOR_NO_SHOW_ALERT,SEND_REMINDER_FOR_APPT_BEFORE,EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,RULE_APPL_YN,NO_OF_RESCH_APPTS_FOR_ALERT,PER_CHK_FUT_RESCH_APPTS,NO_OF_CANCLD_APPTS_FOR_ALERT,PER_CHK_CANCLD_FUT_APPTS,PER_CHK_PAST_RESCH_APPTS,PER_CHK_CANCLD_PAST_APPTS,mob_num_req_yn,LANGUAGE_REQ_YN,NO_OF_FUT_APPTS_FOR_ALERT,PER_CHK_FOR_FUT_APPTS_ALERT,rd_oa_integration_yn,group_appt_yn,MAX_CANCEL_APPT,PAT_CANCEL_REASON,BLK_SCHDL_WITH_APPT_YN,upt_contact_dtls_mp_yn,action_on_holiday_schedule, schedule_extend_yn from oa_param where module_id='OA'";//query modified for the Bru-HIMS-CRF 169 //Query is modified By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 

	rset=stmt.executeQuery(sql);

	if(rset!=null){		
		if(rset.next()){
			operation="modify";
			alcn_basis=rset.getString("alcn_basis");
			alcn_criteria=rset.getString("alcn_criteria");
			slot_appt_ctrl=rset.getString("slot_appt_ctrl");
			slot_appt_ctrl_desc=rset.getString("slot_appt_ctrl_desc");
			visit_limit_rule=rset.getString("visit_limit_rule");
			visit_limit_rule_desc=rset.getString("visit_limit_rule_desc");
			override_no_of_slots_yn=rset.getString("override_no_of_slots_yn");
			appt_slip_remarks1=rset.getString("appt_slip_remarks1");
			appt_slip_remarks2=rset.getString("appt_slip_remarks2");
			appt_slip_remarks3=rset.getString("appt_slip_remarks3");
			appt_slip_remarks4=rset.getString("appt_slip_remarks4");
			appt_slip_remarks5=rset.getString("appt_slip_remarks5");
			max_recurr_days=rset.getString("max_recurr_days");	no_of_noshow_appts_for_alert=rset.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
			if(no_of_noshow_appts_for_alert == null) no_of_noshow_appts_for_alert="";
			per_chk_for_no_show_alert=rset.getString("PER_CHK_FOR_NO_SHOW_ALERT");
			if(per_chk_for_no_show_alert == null) per_chk_for_no_show_alert="";
			ELAPSED_GRACE_PERIOD=rset.getString("ELAPSED_GRACE_PERIOD");
			if(ELAPSED_GRACE_PERIOD == null) ELAPSED_GRACE_PERIOD="";
			FORCECLOSE_PERIOD=	rset.getString("FORCECLOSE_PERIOD");
			if(FORCECLOSE_PERIOD ==null) FORCECLOSE_PERIOD="";
			UNINVITED_PERIOD=	rset.getString("UNINVITED_PERIOD");
			if(UNINVITED_PERIOD ==null) UNINVITED_PERIOD="";
			waitlist_category_appl_yn=rset.getString("WAITLIST_CATEGORY_APPL_YN")==null?"":rset.getString("WAITLIST_CATEGORY_APPL_YN");
			waitlist_category_reqd_yn=rset.getString("WAITLIST_CATEGORY_REQD_YN")==null?"":rset.getString("WAITLIST_CATEGORY_REQD_YN");
			invitation_list_appl_yn=rset.getString("INVITATION_LIST_APPL_YN")==null?"":rset.getString("INVITATION_LIST_APPL_YN");
			min_ela_per_resc_noshow_in_day=rset.getString("min_ela_per_resc_noshow_in_day")==null?"":rset.getString("min_ela_per_resc_noshow_in_day");
			noshow_ctrl_by_splty_or_clinic=rset.getString("noshow_ctrl_by_splty_or_clinic")==null?"":rset.getString("noshow_ctrl_by_splty_or_clinic");
			restrict_wl_cat_agst_splty_yn=rset.getString("RESTRICT_WL_CAT_AGST_SPLTY_YN")==null?"":rset.getString("RESTRICT_WL_CAT_AGST_SPLTY_YN");


		DATE_LABEL                                   =rset.getString("DATE_LABEL")==null?"":rset.getString("DATE_LABEL")  ;
		     
			 
			                            
			REF_NO_LABEL                                        =rset.getString("REF_NO_LABEL")==null?"":rset.getString("REF_NO_LABEL")     ;                                       
		                           
		NAME_LABEL                                              =rset.getString("NAME_LABEL")==null?"":rset.getString("NAME_LABEL")      ;                                          
	                              
		ADDRESS_LABEL				                      =rset.getString("ADDRESS_LABEL")==null?"":rset.getString("ADDRESS_LABEL")     ;                                            
		                        
		NAT_ID_LABEL                                            =rset.getString("NAT_ID_LABEL")==null?"":rset.getString("NAT_ID_LABEL")     ;                                                 
		                               
		SALUTATION_LABEL                                   =rset.getString("SALUTATION_LABEL")==null?"":rset.getString("SALUTATION_LABEL")  ;                                 
		                     
		MEDICAL_OFFICER_LABEL                        =rset.getString("MEDICAL_OFFICER_LABEL")==null?"":rset.getString("MEDICAL_OFFICER_LABEL")  ;                           
		           
		CLINIC_LABEL                                               =rset.getString("CLINIC_LABEL")==null?"":rset.getString("CLINIC_LABEL")  ;                                     
	                            
		NO_SHOW_TITLE                                       =rset.getString("NO_SHOW_TITLE")==null?"":rset.getString("NO_SHOW_TITLE") ;                                  
		            
		NO_SHOW_TEXT1                                      =rset.getString("NO_SHOW_TEXT1")==null?"":rset.getString("NO_SHOW_TEXT1") ;                                    
		NO_SHOW_TEXT2                                       =rset.getString("NO_SHOW_TEXT2")==null?"":rset.getString("NO_SHOW_TEXT2");                                     
		NO_SHOW_TEXT3                                       =rset.getString("NO_SHOW_TEXT3")==null?"":rset.getString("NO_SHOW_TEXT3") ;                                    
		NO_SHOW_TEXT4                                        =rset.getString("NO_SHOW_TEXT4")==null?"":rset.getString("NO_SHOW_TEXT4") ;                                    
		NO_SHOW_TEXT5                                        =rset.getString("NO_SHOW_TEXT5")==null?"":rset.getString("NO_SHOW_TEXT5")  ;                                    
		           
		TFR_SCH_TITLE                                          =rset.getString("TFR_SCH_TITLE")==null?"":rset.getString("TFR_SCH_TITLE")  ;                                 
	              
		TFR_SCH_TEXT1                                        =rset.getString("TFR_SCH_TEXT1")==null?"":rset.getString("TFR_SCH_TEXT1");                                     
		TFR_SCH_TEXT2                                        =rset.getString("TFR_SCH_TEXT2")==null?"":rset.getString("TFR_SCH_TEXT2") ;                                   
		TFR_SCH_TEXT3                                        =rset.getString("TFR_SCH_TEXT3")==null?"":rset.getString("TFR_SCH_TEXT3")  ;                                 
		TFR_SCH_TEXT4                                       =rset.getString("TFR_SCH_TEXT4")==null?"":rset.getString("TFR_SCH_TEXT4")    ;                              
		TFR_SCH_TEXT5                                       =rset.getString("TFR_SCH_TEXT5")==null?"":rset.getString("TFR_SCH_TEXT5")     ;                            
		        
		BLK_CANC_TITLE                                      =rset.getString("BLK_CANC_TITLE")==null?"":rset.getString("BLK_CANC_TITLE") ;                                   
	           
		BLK_CANC_TEXT1                                   =rset.getString("BLK_CANC_TEXT1")==null?"":rset.getString("BLK_CANC_TEXT1")    ; 
		BLK_CANC_TEXT2                                   =rset.getString("BLK_CANC_TEXT2")==null?"":rset.getString("BLK_CANC_TEXT2"); 
		BLK_CANC_TEXT3                                   =rset.getString("BLK_CANC_TEXT3")==null?"":rset.getString("BLK_CANC_TEXT3") ;
		BLK_CANC_TEXT4                                    =rset.getString("BLK_CANC_TEXT4")==null?"":rset.getString("BLK_CANC_TEXT4") ;
		BLK_CANC_TEXT5                                    =rset.getString("BLK_CANC_TEXT5")==null?"":rset.getString("BLK_CANC_TEXT5") ;
		  
		TKS_LABEL                                                  =rset.getString("TKS_LABEL")==null?"":rset.getString("TKS_LABEL"); 
		capture_fin_dtls_yn=rset.getString("CAPTURE_FIN_DTLS_YN")==null?"N":rset.getString("CAPTURE_FIN_DTLS_YN"); 
		contact_num_reqd_yn=rset.getString("CONTACT_NUM_REQD_YN")==null?"N":rset.getString("CONTACT_NUM_REQD_YN");
		
        //send_reminder_for_appt_before=rset.getString("SEND_REMINDER_FOR_APPT_BEFORE");
		send_reminder_for_appt_before=rset.getString("send_reminder_for_appt_before")==null?"":rset.getString("send_reminder_for_appt_before");
		
		
		email_appl_yn=rset.getString("EMAIL_APPL_YN")==null?"N":rset.getString("EMAIL_APPL_YN");
		email_appl_yn1=rset.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN")==null?"N":rset.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN");
		rule_appl_yn=rset.getString("RULE_APPL_YN")==null?"":rset.getString("RULE_APPL_YN");
		rd_oa_integration_yn=rset.getString("rd_oa_integration_yn")==null?"":rset.getString("rd_oa_integration_yn");
		group_appt_yn=rset.getString("group_appt_yn")==null?"":rset.getString("group_appt_yn");
		no_of_resch_appts_for_alert=rset.getString("NO_OF_RESCH_APPTS_FOR_ALERT")==null?"":rset.getString("NO_OF_RESCH_APPTS_FOR_ALERT");
		per_chk_fut_resch_appts=rset.getString("PER_CHK_FUT_RESCH_APPTS")==null?"":rset.getString("PER_CHK_FUT_RESCH_APPTS");
		no_of_cancld_appts_for_alert=rset.getString("NO_OF_CANCLD_APPTS_FOR_ALERT")==null?"":rset.getString("NO_OF_CANCLD_APPTS_FOR_ALERT");
		per_chk_cancld_fut_appts=rset.getString("PER_CHK_CANCLD_FUT_APPTS")==null?"":rset.getString("PER_CHK_CANCLD_FUT_APPTS");
		per_chk_past_resch_appts=rset.getString("PER_CHK_PAST_RESCH_APPTS")==null?"":rset.getString("PER_CHK_PAST_RESCH_APPTS");
		per_chk_cancld_past_appts=rset.getString("PER_CHK_CANCLD_PAST_APPTS")==null?"":rset.getString("PER_CHK_CANCLD_PAST_APPTS");
		mob_num_req_yn=rset.getString("mob_num_req_yn")==null?"N":rset.getString("mob_num_req_yn");
		lang_req_yn=rset.getString("LANGUAGE_REQ_YN")==null?"N":rset.getString("LANGUAGE_REQ_YN");
		no_of_fut_appts_for_alert=rset.getString("NO_OF_FUT_APPTS_FOR_ALERT")==null?"":rset.getString("NO_OF_FUT_APPTS_FOR_ALERT");
		per_chk_for_fut_appts_alert=rset.getString("PER_CHK_FOR_FUT_APPTS_ALERT")==null?"":rset.getString("PER_CHK_FOR_FUT_APPTS_ALERT");
		//Bru-HIMS-CRF 169 changes start
		reason_pat_cancel_appt=rset.getString("PAT_CANCEL_REASON")==null?"":rset.getString("PAT_CANCEL_REASON");
		max_cancelled_appt=rset.getString("MAX_CANCEL_APPT")==null?"":rset.getString("MAX_CANCEL_APPT");
		//Bru-HIMS-CRF 169 changes End

		//JD-CRF-0168 - changes start
		blk_schdl_with_appt_yn=rset.getString("blk_schdl_with_appt_yn")==null?"N":rset.getString("blk_schdl_with_appt_yn");
		if(blk_schdl_with_appt_yn.equals("Y"))
			blk_schdl_with_appt_checked="checked";
		blk_schdl_with_appt_disabled="disabled";
		//JD-CRF-0168 changes end
		//added  changes   for HSA-CRF-0226 [IN:050599] 
       upt_contact_dtls_mp_yn=rset.getString("upt_contact_dtls_mp_yn")==null?"N":rset.getString("upt_contact_dtls_mp_yn");
		if(upt_contact_dtls_mp_yn.equals("Y"))
			upt_contact_dtls_checked="checked";
		
		//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
		schedule_extend_yn = rset.getString("schedule_extend_yn")==null?"N":rset.getString("schedule_extend_yn");
		if(schedule_extend_yn.equals("Y"))
			schedule_extend_yn_chk = "checked";

		//End of HSA-CRF-0226 [IN:050599] 
		action_on_holiday_schedule=rset.getString("action_on_holiday_schedule")==null?"W":rset.getString("action_on_holiday_schedule");//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 

		if(rule_appl_yn.equals("Y")){
			rule_appl_Checked="checked";
		}
		
		if(rd_oa_integration_yn.equals("Y")){
			ris_oa_ing_chk="checked";
		}
		
		if(group_appt_yn.equals("Y")){
			group_appt_yn_chk="checked";
		}
		
		if(rd_oa_integration_yn.equals("")){
			risOaIngenable="";
		}else{
			risOaIngenable="disabled";
		}

		if(mob_num_req_yn.equals("Y")){
			mob_num_req_Checked = "checked";
		}
		if(lang_req_yn.equals("Y")){
			lang_req_Checked="checked";
		}
		
		//email_appl_yn_for_appt_wo_pid=rset.getString("EMAIL_APPL_YN_FOR_APPT_WO_PID  ")==null?"N":rset.getString("EMAIL_APPL_YN_FOR_APPT_WO_PID  ");
			
			if(max_recurr_days==null) max_recurr_days="";

			if(slot_appt_ctrl==null)		   slot_appt_ctrl = "";
			if(visit_limit_rule==null)	   visit_limit_rule = "";
			if(override_no_of_slots_yn==null)		   override_no_of_slots_yn = "";
			if(appt_slip_remarks1==null)	       appt_slip_remarks1 = "";
			if(appt_slip_remarks2==null)	       appt_slip_remarks2 = "";
			if(appt_slip_remarks3==null)	       appt_slip_remarks3 = "";
			if(appt_slip_remarks4==null)	       appt_slip_remarks4 = "";
			if(appt_slip_remarks5==null)	       appt_slip_remarks5 = "";
		
			if(alcn_basis==null) alcn_basis="";
			if(alcn_criteria==null) alcn_criteria="";
		}

	}
	if(rule_appl_yn.equals("")){
		rule_enable_disable="";
	}else{
		rule_enable_disable="disabled";
	}
	String visibilityCheck="";
	if(rule_appl_yn.equals("Y")){
		rule_check_attribute="";
	}else{
		rule_check_attribute="disabled";
		visibilityCheck="display:none";
	}
		
	if(alcn_criteria==null)
		alcn_criteria = "";
	stmt1=con.createStatement();
	String sql1="SELECT EMAIL_APPL_YN,NVL((select 'Y' from sm_function_control where site_id='"+customer_id+"' and module_id='OA' and FUNCTIONALITY_ID ='RULES_APPT_SCH'),'N')rule_sch_appl_cust_YN,(select 'Y' from sm_function_control where functionality_id = 'RD_OA_INTEGRATE') ris_oa_integrate, NVL((select 'Y' from sm_function_control where site_id='"+customer_id+"' and module_id='OA' and FUNCTIONALITY_ID ='GROUP_APPT'),'N') group_appt_integrate  FROM sm_installation";
	
	rset1=stmt1.executeQuery(sql1);
	if(rset1!=null){		
		if(rset1.next()){
			ris_oa_integrate=rset1.getString("ris_oa_integrate")==null?"N":rset1.getString("ris_oa_integrate");
			emailappli=rset1.getString("EMAIL_APPL_YN")==null?"N":rset1.getString("EMAIL_APPL_YN");
			rule_sch_appl_cust_YN = rset1.getString("rule_sch_appl_cust_YN");	
			group_appt_integrate = rset1.getString("group_appt_integrate");			
		}
	}


		stmt2=con.createStatement();
	String sql2="select alcn_code,alcn_desc,alcn_appl_yn,eff_status from oa_alcn_criteria";
	rset2=stmt2.executeQuery(sql2);


//out.println("emailappli="+emailappli);
/*if (emailappli.equals("N")){
	chkAttribute = "unchecked";
	emailapplidisable="disabled";
	chkAttribute1 = "unchecked";
	sendreminder="disabled";


}
else{
	chkAttribute="CHECKED";
	chkAttribute1 = "CHECKED";
	emailapplidisable = "enabled";
	sendreminder="enabled";
}*/



//out.println("chkAttribute="+chkAttribute);
//out.println("chkAttribute1="+chkAttribute1);



	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
    if (rset1 != null) rset1.close();
	if (stmt1 != null) stmt1.close();
	
	oa_remarks_ctrl=CommonBean.isSiteSpecific(con, "OA","OA_PARAM_REMARKS");//Mahesh
	if(oa_remarks_ctrl)
		{
		remark_size=90;
		remark_maxlength=90;
		}
%>
    <body  onLoad = 'resetvalue();' onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='oaparameter' id='oaparameter' action='../../servlet/eOA.OAParameterServlet' method='post' target='messageFrame' >
	<!-- <a name="general1"  ></a>  -->
	<div id="gen_rep_div">
	<table cellspacing='1' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" style="padding-left:0px">
			<li class="tablistitem" title='<fmt:message key="Common.general.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('general')" class="tabClicked" id="general" >
					<span class="tabSpanclicked" id="generalspan"><fmt:message key="Common.general.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="Common.report.label" bundle="${common_labels}"/> & <fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('report')" class="tabA" id="report" >
					<span class="tabAspan" id="reportspan"><fmt:message key="Common.report.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			</ul>
			</td></tr>
			</table>
			</div>

<div id="general_div" style='visibility:visible;'>
<table width='100%' cellpadding='1' cellspacing='0' border='0' align='center'>

	<tr>
	<td colspan='4' class='COLUMNHEADER' style='color: white;'><fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
	</tr>
     <tr>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>

	<tr>
			<td class = 'Label' ><fmt:message key="eOA.ControlBy.label" bundle="${oa_labels}"/></td>
			<td class = 'fields' >
		<%if(operation.equals("modify")){%>
			<input type = hidden name = "slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
			<input type = text size = 10 disabled maxlength = 10 name = "slot_appt_ctrl1"  value="<%=slot_appt_ctrl_desc%>">
		<%}else{%><select name ="slot_appt_ctrl" >
			<option value = 'P' ><fmt:message key="Common.patient.label" bundle="${common_labels}"/>
			<option value = 'S' ><fmt:message key="Common.Slot.label" bundle="${common_labels}"/>
			</select>
		<%}%>

			<td class = 'Label'  NOWRAP  ><fmt:message key="eOA.OverridingNoofSlots.label" bundle="${oa_labels}"/></td>
			<td class='fields' ><input type = checkbox name ="override_no_of_slots_yn" onClick='checkbox_value(this)'  value = "Y" checked></td>
	</tr>


	<tr>
			<td class = Label  nowrap><fmt:message key="eOA.VisitLimitRule.label" bundle="${oa_labels}"/></td>
		
			<td class ='fields'>
			<%if(operation.equals("modify")){%>
					<input type = hidden name = "visit_limit_rule"  value="<%=visit_limit_rule%>">
					<input type = text size = 20 disabled maxlength = 20 name = "visit_limit_rule1"  value="<%=visit_limit_rule_desc%>"></td>
			<%}else{%>
					<select name ="visit_limit_rule">
					<option value = 'M' ><fmt:message key="eOA.MaxNoofVisits.label" bundle="${oa_labels}"/>
					<option value = 'E' ><fmt:message key="eOA.ExactNoofVisits.label" bundle="${oa_labels}"/>
					<option value = 'N' ><fmt:message key="Common.none.label" bundle="${common_labels}"/>

					</td>

			<%}%>

			<td class = Label  nowrap><fmt:message key="eOA.MaxRecurringDays.label" bundle="${oa_labels}"/>
		
			<td class = 'fields'>
				<%if(operation.equals("modify")){%>
					<input type = text size = 5  maxlength = 3 name = "max_recurr_days" value="<%=max_recurr_days%>" onKeyPress="return allowValidNumber(this,event,3,0);return CheckForSpecChars(event)" onBlur='CheckNum(this)' disabled></td>
				<%}else{%>
					<input type = text size = 5 maxlength = 3 name = "max_recurr_days"  onKeyPress="return CheckForSpecChars(event)" onKeyPress='return allowValidNumber(this,event,3,0)' onBlur='CheckNum(this)'></td>
				<%}%>

	</tr>
	<tr>
	
			<td class = Label  nowrap><fmt:message key="eOA.Minperiodforschnoshowappt.label" bundle="${oa_labels}"/>
		
			<td class = 'fields'>
				<%if(operation.equals("modify")){%>
					<input type = text size = 5  maxlength = 3 name = "limit_no_show_days"  value="<%=min_ela_per_resc_noshow_in_day%>" onKeyPress="return allowValidNumber(this,event,3,0);return CheckForSpecChars(event)" onBlur='CheckNum(this);enab_disa_spec_locn(this)' >&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				<%}else{%>
					<input type = text size = 5 maxlength = 3 name = "limit_no_show_days"  value="" onKeyPress="return CheckForSpecChars(event)" onKeyPress='return allowValidNumber(this,event,3,0)' onBlur='enab_disa_spec_locn(this);CheckNum(this);'>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				<%}%>
			
			<td class = Label COLSPAN='2' nowrap><fmt:message key="eOA.BySpecialty.label" bundle="${oa_labels}"/>
			
			<input type=radio name='spec' id='spec'  value='S' onClick="clear_spec(this)">
			
			<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
			<input type=radio name='locn' id='locn'  value='L' onClick="clear_locn(this)">
			</td>

	</tr>

	<tr>	
			<td class=Label nowrap ><fmt:message key="eOA.captfinancedetailsgapptbooking.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox  name ="billing_allow" onClick='allow_billing(this)' value=""></td>



	<%
	int count=0;
	boolean alcnFlag=false;
	
			while(rset2!=null && rset2.next()){
				

					alcn_code=rset2.getString("ALCN_CODE")==null?"":rset2.getString("ALCN_CODE");
					alcn_desc=rset2.getString("alcn_desc")==null?"":rset2.getString("alcn_desc");
					if(alcn_criteria.equals(alcn_code)){
						temp_alcn_code=alcn_code;
						temp_alcn_desc=alcn_desc;
					}
				if(count==0){%>
				<td class = Label  nowrap><fmt:message key="eOA.AlocationCriteria.label" bundle="${common_labels}"/></td>
				<%}
				if(operation.equals("modify")){%>
					 <td class ='fields'>
					<input type = text size = 20 disabled maxlength = 20 name = "allocation_role1" value="<%=temp_alcn_desc%>"> <img src="../../eCommon/images/mandatory.gif" ></img></td>
				<%}else{
					alcnFlag=true;
					if(count==0){%>
					<td class ='fields'>
					<select name ="alcn_criteria">
					<option value = '' >----<fmt:message key="Common.defaultSelect.label" bundle="${oa_labels}"/>----</option>
					<%}%>
					<option value = '<%=alcn_code%>'  ><%=alcn_desc%></option>
				<%}
	count++;
	}
	if(count!=0){
		alcn_applicable_yn="Y";
	}
	if(alcnFlag){%>
	</select><img src="../../eCommon/images/mandatory.gif" ></img>
	</td>
	<%}%>				
<%if(operation.equals("modify")){%>
	<input type ='hidden' name = "alcn_criteria" value="<%=temp_alcn_code%>">
<%}%>
</tr>
	<tr>	
			<td class=Label nowrap><fmt:message key="eOA.captcontactdetailsgapptbooking.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="res_contact_mand"  onClick='res_contact_enable(this)' value=""></td>

<%if(ris_oa_integrate.equals("Y")){%>
<td class=Label nowrap><fmt:message key="eOA.IntegrateRadApptAppl.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="rd_oa_integration_yn"  onClick='assignValue(this)' value="<%=rd_oa_integration_yn%>" <%=ris_oa_ing_chk%> <%=risOaIngenable%>></td>
<%}%>
			
  
	</tr>


	<tr>
		
		<td class = 'Label' ><fmt:message key="eOA.Numofnoshowappointments.label" bundle="${oa_labels}"/></td>
		<td class = 'fields' ><input name="number_appoinment" id="number_appoinment"  size = 2 maxlength = 2 onblur='CheckNum(this)' value="<%=no_of_noshow_appts_for_alert%>"></td>

		<td class = 'Label' ><fmt:message key="eOA.Periodchklast.label" bundle="${oa_labels}"/>
		<!-- both size and maxlength is changed for RUT-CRF-0005.1 by Sudhakar-->
		<td class = 'fields' ><input type="text" name="period_chkList" id="period_chkList"   size = 3 onblur='CheckNum(this)'value="<%=per_chk_for_no_show_alert%>" maxlength = 3>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
	</tr>
	<!-- Bru-HIMS-CRF-169 changes start-->
	<tr>
		
		<td class='Label'><fmt:message key="eOA.MaxCancelledApptForPrompt.label" bundle="${oa_labels}"/></td>
		<td class='fields'><input type="text" name="max_Cancelled_Appt" id="max_Cancelled_Appt"   size = 3 onblur='CheckNum(this);checkMandatoryReason(this);'value="<%=max_cancelled_appt%>" maxlength = 3></td>
		<td class='Label'><fmt:message key="eOA.ReasonForPatCancelledAppt.label" bundle="${oa_labels}"/></td>
		<td class='fields'><Select name='pat_cancel_reason' id='pat_cancel_reason'>
			
			<%try{
				
				%><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp; <%
				String cancel_sql="Select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where CANCEL_APPOINTMENT_YN = 'Y' and Eff_Status = 'E' order by 1 ";
				stmt1=con.createStatement();
				rset1=stmt1.executeQuery(cancel_sql);
				while(rset1 != null && rset1.next()){
					if(reason_pat_cancel_appt.equals(rset1.getString(2))){%>
						<option selected value="<%=rset1.getString(2)%>"><%=rset1.getString(1)%></option>
					<%}else{%>
						<option value="<%=rset1.getString(2)%>"><%=rset1.getString(1)%></option>
					<%}
				}
			}catch(Exception ex){
				//System.out.println("Exception in adding Reason codes");
				ex.printStackTrace();
			}finally{
				if(rset1 != null) rset1.close();
				if(stmt1 != null) stmt1.close();
			}%>
			
		</select><img id="patCnclMan" src="../../eCommon/images/mandatory.gif" style="visibility:hidden"></img></td>
	</tr>
	<!-- Bru-HIMS-CRF-169 changes End-->
	<!-- JD-CRF-0168 changes Start-->
	<tr>	
			<td class=Label nowrap><fmt:message key="eOA.blkschdlwithapptyn.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="blk_schdl_with_appt_yn_chk"  onClick='assignValueForSchdlWithAppt(this)' value="<%=blk_schdl_with_appt_yn%>" <%=blk_schdl_with_appt_disabled%> <%=blk_schdl_with_appt_checked%> ></td>
			<input type='hidden'  name ="blk_schdl_with_appt_yn" value="<%=blk_schdl_with_appt_yn%>"/>
			<!--added changes for HSA-CRF-0226 [IN:050599] -->
			<td class=Label nowrap><fmt:message key="eOA.SynContactDtlsMP.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="upt_contact_dtls"  onClick='UptContactDtls(this)'  value="<%=upt_contact_dtls_mp_yn%>" <%=upt_contact_dtls_checked%> ></td>
			<input type='hidden'  name ="upt_contact_dtls_mp_yn" value="<%=upt_contact_dtls_mp_yn%>"/>
			<!--End changes for HSA-CRF-0226 [IN:050599] -->
			</tr>
	<!-- JD-CRF-0168 changes End-->
	<%if(group_appt_integrate.equals("Y")){%>
		<tr>
			<td class=Label nowrap><fmt:message key="eOA.GroupAppointmentallowed.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name =group_appt_yn  onClick='group_app_allowed_value(this)' value="<%=group_appt_yn%>" <%=group_appt_yn_chk%> ></td>
		</tr>
	<%} %>
<!--Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543]-->
<!-- Start -->
<tr>

<!--Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112-->
<%if(isScheduleExtendAppl){%>
	<td class=Label nowrap><fmt:message key="eOA.ScheduleExtend.label" bundle="${oa_labels}"/></td>
	<td class='fields'><input type=checkbox name="schedule_extend_yn" id="schedule_extend_yn" onClick='ScheduleExtendYN(this);allowUncheckValidate(this);' value="<%=schedule_extend_yn%>" <%=schedule_extend_yn_chk%>></td>
<%}else{%>
	<td></td><td></td>
<%}%>

<td class=Label nowrap><fmt:message key="eOA.ActionOnHolidayForOpenSchedule.label" bundle="${oa_labels}"/></td><% String str3="",str4="";  if(action_on_holiday_schedule.equals("W")) str3="selected"; else str4="selected";%>
<td class='fields'><Select name='action_on_holiday_schedule' id='action_on_holiday_schedule'><option <%=str3%> value="W"><fmt:message key="Common.Warning.label" bundle="${common_labels}"/></option>
											<option <%=str4%> value="R"><fmt:message key="eOA.restrict.label" bundle="${oa_labels}"/></option>
										
											</td>




</tr>
<!--End-->
		<tr><td colspan='4' class='COLUMNHEADER' ><fmt:message key="Common.WaitList.label" bundle="${common_labels}"/></td></tr>
	<tr>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
	<tr>	
			<td class=Label ><fmt:message key="eOA.WaitlistCategoryApplicable.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="wait_lst_appl"  onClick='wait_lst_appl_value(this)' value = "Y" checked>
			
			
			<td class=Label ><fmt:message key="eOA.WaitlistCategoryRequired.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox  name ="wait_lst_reqd"  onClick='wait_lst_reqd_value(this)' value = "Y" checked></td>
	</tr>

	<tr>
			<td class=Label ><fmt:message key="eOA.InvitationApplicable.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="invite_appl" onClick='invite_appl_value(this)' value = "Y" checked></td>

			<td class = Label ><fmt:message key="eOA.GraceperiodtoConfirmElapsedWaitlist.label" bundle="${oa_labels}"/>
			<td class='fields'>
			<%if(operation.equals("modify")){%>
			<input name='grace_per_con_elap_wtlt' id='grace_per_con_elap_wtlt' maxlength='3'  size='3'  onKeyPress='return allowValidNumber(this,event,3,0)' onblur='CheckNum(this)'  value="<%=ELAPSED_GRACE_PERIOD%>">
			<%}else {%>
			<input name='grace_per_con_elap_wtlt' id='grace_per_con_elap_wtlt' maxlength='3'  size='3'  onKeyPress='return allowValidNumber(this,event,3,0)' onblur='CheckNum(this)'  value="<%=ELAPSED_GRACE_PERIOD%>">
			<%}%><fmt:message key="Common.days.label" bundle="${common_labels}"/>
			<img src="../../eCommon/images/mandatory.gif" ></img></td>
	</tr>

	<tr>
			<td class = Label nowrap><fmt:message key="eOA.CutoffperiodforClosingElapsedWaitlist.label" bundle="${oa_labels}"/>
			<td class='fields'>
			<%if(operation.equals("modify")){%>
			<input name='cutoff_elps_wtlt' id='cutoff_elps_wtlt' maxlength='3'  size='3'  onKeyPress='return allowValidNumber(this,event,3,0)' onblur='CheckNum(this)'  value="<%=FORCECLOSE_PERIOD%>">
			<%}else {%>
			<input name='cutoff_elps_wtlt' id='cutoff_elps_wtlt' maxlength='3'  size='3'  onKeyPress='return allowValidNumber(this,event,3,0)' onblur='CheckNum(this)'  value="<%=FORCECLOSE_PERIOD%>">
			<%}%><fmt:message key="Common.days.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif"></img></td>

			<td class = Label ><fmt:message key="eOA.Highlightpatientsifnotinvitedwithin.label" bundle="${oa_labels}"/>
			<td class='fields'><input name='high_not_invalid_wtlt' id='high_not_invalid_wtlt' maxlength='3' size='3'  onKeyPress='return allowValidNumber(this,event,3,0);' onblur='OACheckNum(this);zerochk(this);' value="<%=UNINVITED_PERIOD%>">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
	</tr>
	
	<tr>
			<td  class=Label  ><fmt:message key="eOA.RestrictonlyoneWaitlistforaPatientagainstCategoryandSpecialty.label" bundle="${oa_labels}"/></td>
			<td class = 'fields' colspan=2><input type = checkbox name ="restrict_wtlst_cat_spec"  onClick='restrict_wtlst_cat_spec_value(this)' value = "Y" checked></td>
			<td>&nbsp;</td>
	</tr>

	<tr>
			<td colspan='4' class='COLUMNHEADER' ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
				
	<tr>
			<td  class=Label  ><fmt:message key="eOA.EmailApplicable.label" bundle="${oa_labels}"/></td>
			<td class='fields' ><input type = checkbox  name ="email_applicable" onClick='email_appli(this);validate(this)' value = "Y" ></td>
			<td  colspan='2'>&nbsp;</td>
	 </tr>

	<tr>
			<td  class=Label  ><fmt:message key="eOA.EmailAppliForAppointmentwithoutPatientid.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox  name ="email_applicable1" onClick='email_appli1(this)' value = "Y" ></td>
			<td  colspan='2'>&nbsp;</td>
	</tr>

	<tr>
			<td  class=Label  ><fmt:message key="eOA.SendRemiForAppointment.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type=text name="sendremin_appoint" id="sendremin_appoint" onKeyPress='return(CheckForSpecChars2(event));'
		    value="<%=send_reminder_for_appt_before%>"  maxlength='2' size='5'>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
			<td colspan='2'>&nbsp;</td>
	</tr>
	<%if(rule_sch_appl_cust_YN.equals("Y")){%>
		<tr><td  colspan='4' class='COLUMNHEADER' ><fmt:message key="eOA.RuleBasedScheduling.label" bundle="${oa_labels}"/></td></tr>
		<tr>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
	   </tr>
	   <tr>
	   		<td class=Label nowrap><fmt:message key="eOA.scheduleruleapplicable.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="rule_appl_yn" onClick='sch_rule_enable(this)' value="<%=rule_appl_yn%>" <%=rule_appl_Checked%> <%=rule_enable_disable%>></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
	   </tr>
		<tr id='mobNoLangRow' style="<%=visibilityCheck%>" >
			<td class=Label nowrap><fmt:message key="eOA.MobNumReqDuringAppt.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="mob_num_req_yn" <%=mob_num_req_Checked%> onClick='sch_rule_enable(this)' value="<%=mob_num_req_yn%>" <%=rule_check_attribute%>></td>
			<td class=Label nowrap><fmt:message key="eOA.PatLangReqDuringAppt.label" bundle="${oa_labels}"/></td>
			<td class='fields'><input type = checkbox name ="lang_req_yn" <%=lang_req_Checked%> onClick='sch_rule_enable(this)' value="<%=lang_req_yn%>" <%=rule_check_attribute%>></td>


	   </tr>
		<tr id='reschApptRow' style="<%=visibilityCheck%>">
			
			<td class = 'Label' ><fmt:message key="eOA.NumberofRescheduledAppointmentforalert.label" bundle="${oa_labels}"/></td>
			<td class = 'fields' ><input name="no_of_resch_appts_for_alert" id="no_of_resch_appts_for_alert"  size = 2 maxlength = 2 onblur='CheckNum(this)' value="<%=no_of_resch_appts_for_alert%>" <%=rule_check_attribute%>></td>

			<td class = 'Label' ><fmt:message key="eOA.PeriodCheckforReschApptsAlert.label" bundle="${oa_labels}"/>(<fmt:message key="Common.Past.label" bundle="${common_labels}"/>/<fmt:message key="Common.Future.label" bundle="${common_labels}"/>)</td>
			<td class = 'fields' ><input type="text" name="per_chk_past_resch_appts" id="per_chk_past_resch_appts" size = 2 maxlength = 3 onblur='CheckNum(this)'value="<%=per_chk_past_resch_appts%>" <%=rule_check_attribute%>>/<input type="text" name="per_chk_fut_resch_appts" id="per_chk_fut_resch_appts" size = 2 maxlength = 3 onblur='CheckNum(this)'value="<%=per_chk_fut_resch_appts%>" <%=rule_check_attribute%>>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		</tr>

		<tr id='cancApptRow' style="<%=visibilityCheck%>">
			
			<td class = 'Label' ><fmt:message key="eOA.NumofCancelledApptsforalert.label" bundle="${oa_labels}"/></td>
			<td class = 'fields' ><input name="no_of_cancld_appts_for_alert" id="no_of_cancld_appts_for_alert"  size = 2 maxlength = 2 onblur='CheckNum(this)' value="<%=no_of_cancld_appts_for_alert%>" <%=rule_check_attribute%>></td>

			<td class = 'Label' ><fmt:message key="eOA.PeriodCheckforCancelledApptsAlert.label" bundle="${oa_labels}"/>(<fmt:message key="Common.Past.label" bundle="${common_labels}"/>/<fmt:message key="Common.Future.label" bundle="${common_labels}"/>)</td>
			<td class = 'fields' ><input type="text" name="per_chk_cancld_past_appts" id="per_chk_cancld_past_appts" size = 2 maxlength = 3 onblur='CheckNum(this)'value="<%=per_chk_cancld_past_appts%>" <%=rule_check_attribute%>>/<input type="text" name="per_chk_cancld_fut_appts" id="per_chk_cancld_fut_appts" size = 2 maxlength = 3 onblur='CheckNum(this)'value="<%=per_chk_cancld_fut_appts%>"  <%=rule_check_attribute%>>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		</tr>
		<tr id='futApptRow' style="<%=visibilityCheck%>">
			
			<td class = 'Label' ><fmt:message key="eOA.NumOfFutApptsForAlert.label" bundle="${oa_labels}"/></td>
			<td class = 'fields' ><input name="no_of_fut_appts_for_alert" id="no_of_fut_appts_for_alert"  size = 2 maxlength = 2 onblur='CheckNum(this)' value="<%=no_of_fut_appts_for_alert%>" <%=rule_check_attribute%>></td>

			<td class = 'Label' ><fmt:message key="eOA.PerChkForFutApptsForAlert.label" bundle="${oa_labels}"/></td>
			<td class = 'fields' ><input type="text" name="per_chk_for_fut_appts_alert" id="per_chk_for_fut_appts_alert" size = 2 maxlength = 3 onblur='CheckNum(this)'value="<%=per_chk_for_fut_appts_alert%>" <%=rule_check_attribute%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		</tr>
	<%}%>
</table>



	<table width='100%' cellpadding='1' cellspacing='0' border='0' align='center'>
	<tr><td  colspan='4' class='COLUMNHEADER' ><fmt:message key="eOA.AppointmentSlipRemarks.label" bundle="${oa_labels}"/></td></tr>
    <tr>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
	
	<tr>
		 <td class = 'fields'> &nbsp;<input name="appt_slip_remarks1" id="appt_slip_remarks1" onBlur = "makeValidStringOA(this);" size = '<%=remark_size%>' maxlength = '<%=remark_maxlength%>' value = "<%=appt_slip_remarks1%>">
			&nbsp;<input name="appt_slip_remarks2" id="appt_slip_remarks2"  onBlur = "makeValidStringOA(this);" size = '<%=remark_size%>' maxlength = '<%=remark_maxlength%>' value="<%=appt_slip_remarks2%>">
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>

	</tr>
	<tr>
		
			<td class = 'fields'>&nbsp;<input name="appt_slip_remarks3" id="appt_slip_remarks3" onBlur = "makeValidStringOA(this);" size = '<%=remark_size%>' maxlength = '<%=remark_maxlength%>' value="<%=appt_slip_remarks3%>">
			&nbsp;<input name="appt_slip_remarks4" id="appt_slip_remarks4"  onBlur = "makeValidStringOA(this);" size = '<%=remark_size%>' maxlength = '<%=remark_maxlength%>' value="<%=appt_slip_remarks4%>">
			<td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
	</tr>
	<tr>
	
			<td class = 'fields'>&nbsp;<input name="appt_slip_remarks5" id="appt_slip_remarks5" onBlur = "makeValidStringOA(this); check(); "  size = '<%=remark_size%>'  maxlength = '<%=remark_maxlength%>' value="<%=appt_slip_remarks5%>">
			<td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
	</tr>
	<tr>
	
			<td class = 'fields'></td>
	</tr>
	</table>
	</div>
 <!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 


<a name='report1'></a>
<table cellspacing='0' cellpadding='1' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title='<fmt:message key="Common.general.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('general')" class="tabA" id="general" >
					<span class="tabAspan" id="generalspan"><fmt:message key="Common.general.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="Common.report.label" bundle="${common_labels}"/> & <fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('report')" class="tabClicked" id="report" >
					<span class="tabSpanclicked" id="reportspan"><fmt:message key="Common.report.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			</ul>
			</td></tr>
			</table> -->
<div id="report_div" style="visibility:hidden;display:none">
<table width='100%' cellpadding='1' cellspacing='0' border='0' align='center'>
	<tr><td colspan='4' class='COLUMNHEADER' ><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.details.label" bundle="${common_labels}"/></td></tr>				
<tr>
				<td class='Label' width='20%' nowrap> <fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields' nowrap> &nbsp;<input type="text" name='DATE_LABEL' id='DATE_LABEL' value='<%=DATE_LABEL%>' maxlength='10' size='10'></td>

				<td class='Label' nowrap><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></td>
				<td class='fields' nowrap><input type="text" name='REF_NO_LABEL' id='REF_NO_LABEL'  value='<%=REF_NO_LABEL%>'maxlength='15' size='15'></td>
					

		</tr>
	
		<tr>
				 <td class='Label' nowrap> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
				 <td class='fields' nowrap> &nbsp;<input type="text" name='NAME_LABEL' id='NAME_LABEL' value='<%=NAME_LABEL%>' maxlength='10' size='10'></td>

				 <td class='Label' nowrap> <fmt:message key="Common.Address.label" bundle="${common_labels}"/></td><td class='fields' nowrap><input type="text" name='ADDRESS_LABEL' id='ADDRESS_LABEL' maxlength='10' value='<%=ADDRESS_LABEL%>'size='10'></td>
	
		</tr>
			
 
		<tr>
				

				<td class='Label' nowrap> <fmt:message key="eMP.NationalID.label" bundle="${mp_labels}"/></td>
				<td class='fields' nowrap> &nbsp;<input type="text" name='NAT_ID_LABEL' id='NAT_ID_LABEL'  maxlength=10 value='<%=NAT_ID_LABEL%>'></td>

				<td class='Label' nowrap><fmt:message key="eOA.Salutation.label" bundle="${oa_labels}"/></td>
				<td class='fields' nowrap><input type="text" name='SALUTATION_LABEL' id='SALUTATION_LABEL'  value='<%=SALUTATION_LABEL%>' maxlength='15' size='15'></td>
			
		</tr>

					
		<tr>	
				

				<td class='Label' ><fmt:message key="eOA.SpecialistMedicalOfficer.label" bundle="${oa_labels}"/></td>
				<td class='fields' nowrap> &nbsp;<input type="text" name='MEDICAL_OFFICER_LABEL' id='MEDICAL_OFFICER_LABEL'  value='<%=MEDICAL_OFFICER_LABEL%>' maxlength='30' size='30'></td>

				  <td  class='Label' > <fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td><td class='fields' ><input type="text" name='CLINIC_LABEL' id='CLINIC_LABEL'  maxlength='10' size='10' value='<%=CLINIC_LABEL%>'></td>
				
       </tr>

		<tr>
				  
					<td class='Label' nowrap> <fmt:message key="eOA.Thanks.label" bundle="${oa_labels}"/></td>
					<td class='fields' nowrap> &nbsp;<input type="text" name='TKS_LABEL' id='TKS_LABEL'  maxlength='15' value='<%=TKS_LABEL%>' size='15'>
					</td>
					<td colspan='2'>&nbsp;</td>
				
		</tr>	

	</table>

         <table cellspacing='0' cellpadding='1' border=0>

          <table width='100%' cellpadding='1' cellspacing='0' border='0' align='center'>
			
			<tr><td class='COLUMNHEADER' >&nbsp;</td>
			<td class='COLUMNHEADER' align=center ><fmt:message key="Common.noshow.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' align=center ><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' align=center ><fmt:message key="Common.Cancellation.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<td class='Label' ><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
			<td class='Label'nowrap><input type="text" name='NO_SHOW_TITLE' id='NO_SHOW_TITLE' value='<%=NO_SHOW_TITLE%>' maxlength='60' size='40'  ></td>
			<td class='Label' nowrap><input type="text" name='TFR_SCH_TITLE' id='TFR_SCH_TITLE' value='<%=TFR_SCH_TITLE%>' maxlength='60' size='40' ></td>
			<td class='Label' ><input type="text" name='BLK_CANC_TITLE' id='BLK_CANC_TITLE' value='<%=BLK_CANC_TITLE%>' maxlength='60' size='40' ></td>
			</tr>

			<tr>
			<td class='Label' ><fmt:message key="eOA.ReportBody.label" bundle="${oa_labels}"/></td>
			<td class='Label' nowrap><input type="text" name='NO_SHOW_TEXT1' id='NO_SHOW_TEXT1' value='<%=NO_SHOW_TEXT1%>' maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='TFR_SCH_TEXT1' id='TFR_SCH_TEXT1' value='<%=TFR_SCH_TEXT1%>'  maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='BLK_CANC_TEXT1' id='BLK_CANC_TEXT1'  value='<%=BLK_CANC_TEXT1%>'maxlength='60' size='40'></td>
            </tr>
		
			<tr>
			<td class='Label' >&nbsp;</td>
			<td class='Label' nowrap><input type="text" name='NO_SHOW_TEXT2' id='NO_SHOW_TEXT2'  value='<%=NO_SHOW_TEXT2%>'  maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='TFR_SCH_TEXT2' id='TFR_SCH_TEXT2'  value='<%=TFR_SCH_TEXT2%>'maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='BLK_CANC_TEXT2' id='BLK_CANC_TEXT2'  value='<%=BLK_CANC_TEXT2%>' maxlength='60' size='40'></td>
			</tr>

			<tr>
			<td class='Label' >&nbsp;</td>
			<td class='Label' nowrap><input type="text" name='NO_SHOW_TEXT3' id='NO_SHOW_TEXT3'   value='<%=NO_SHOW_TEXT3%>'maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='TFR_SCH_TEXT3' id='TFR_SCH_TEXT3' value='<%=TFR_SCH_TEXT3%>'  maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='BLK_CANC_TEXT3' id='BLK_CANC_TEXT3' value='<%=BLK_CANC_TEXT3%>' maxlength='60' size='40'></td>
			</tr>

			<tr>
			<td class='Label' >&nbsp;</td>
			<td class='Label' nowrap><input type="text" name='NO_SHOW_TEXT4' id='NO_SHOW_TEXT4' value='<%=NO_SHOW_TEXT4%>' maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='TFR_SCH_TEXT4' id='TFR_SCH_TEXT4'  value='<%=TFR_SCH_TEXT4%>'maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='BLK_CANC_TEXT4' id='BLK_CANC_TEXT4' value='<%=BLK_CANC_TEXT4%>' maxlength='60' size='40'></td>
			</tr>

			<tr>
			<td class='Label' >&nbsp;</td>
			<td class='Label' nowrap><input type="text" name='NO_SHOW_TEXT5' id='NO_SHOW_TEXT5' value='<%=NO_SHOW_TEXT5%>' maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='TFR_SCH_TEXT5' id='TFR_SCH_TEXT5'   value='<%=TFR_SCH_TEXT5%>' maxlength='60' size='40'></td>
			<td class='Label' nowrap><input type="text" name='BLK_CANC_TEXT5' id='BLK_CANC_TEXT5' onblur='check1()' value='<%=BLK_CANC_TEXT5%>' maxlength='60' size='40'></td>
			</tr>
	</table>
	<script>prevTabObj='general'</script>
	</table>
	</div>
	<%
		if (rset2 != null) rset2.close();
		if (stmt2 != null) stmt2.close();
	}catch(Exception e){
		e.printStackTrace();
	//out.println(e);
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
	%> 
<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->
<input type='hidden' value="<%=operation%>" name='operation'>
<input type='hidden' value='N' name='alcn_basis' id='alcn_basis'>
<input type='hidden' name='override_no_of_slots_yn1' id='override_no_of_slots_yn1' value='<%=override_no_of_slots_yn%>'>
<input type='hidden' name='waitlist_category_appl_yn' id='waitlist_category_appl_yn' value='<%=waitlist_category_appl_yn%>'>
<input type='hidden' name='waitlist_category_reqd_yn' id='waitlist_category_reqd_yn' value='<%=waitlist_category_reqd_yn%>'>
<input type='hidden' name='invitation_list_appl_yn' id='invitation_list_appl_yn' value='<%=invitation_list_appl_yn%>'>
<input type='hidden' name='restrict_wl_cat_agst_splty_yn' id='restrict_wl_cat_agst_splty_yn' value='<%=restrict_wl_cat_agst_splty_yn%>'>
<input type='hidden' name='uninvited_period' id='uninvited_period' VALUE='<%=UNINVITED_PERIOD%>'>
<input type='hidden' name='bl_operational' id='bl_operational' VALUE='<%=bl_operational%>'>
<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' VALUE='<%=capture_fin_dtls_yn%>'>
<input type='hidden' name='capture_con_dtls_yn' id='capture_con_dtls_yn' VALUE='<%=contact_num_reqd_yn%>'>
<input type='hidden' name='spec_locn' id='spec_locn' VALUE=''>
<input type='hidden' name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' VALUE='<%=noshow_ctrl_by_splty_or_clinic%>'>

<input type='hidden' name='email_appl_yn' id='email_appl_yn' VALUE='<%=email_appl_yn%>'>
<input type='hidden' name='email_appl_yn1' id='email_appl_yn1' VALUE='<%=email_appl_yn1%>'>
<input type='hidden' name='emailappli' id='emailappli' VALUE='<%=emailappli%>'>
<input type='hidden' name='alcn_applicable_yn' id='alcn_applicable_yn' VALUE='<%=alcn_applicable_yn%>'>
</form>
</body>
</html>


