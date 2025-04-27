<!DOCTYPE html>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ page import ="java.util.ArrayList,eOT.OTCommonBean" contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"  %>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String tab = checkForNull(request.getParameter("tab")); 
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String) session.getAttribute("facility_id");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String recovery_in_out_flag = checkForNull(request.getParameter("recovery_in_out_flag"));
	String function_id = checkForNull(request.getParameter("function_id"));
	System.err.println("17,function_id=="+function_id);
	//Added below slate_user_id_disp on 1/18/2011 by Anitha
	String slate_user_id_disp = checkForNull(request.getParameter("slate_user_id")).toUpperCase();
	if(slate_user_id_disp.equals("")){
		slate_user_id_disp=	(String)session.getValue("login_user");
	}
%>

<HTML>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='JavaScript' src='../../eOT/js/CommonOperDtlsHdr.js'></script>
<script language='JavaScript' src='../../eOT/js/Hashtable.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script > var lblPreOperDiag=getLabel("eOT.PreOperativeDiagnosis.Label","OT");</script>
<script type='text/javascript' src='../../eOT/js/CheckInOutRecoveryRoom.js'></script>
<script type='text/javascript' src='../../eOT/js/HoldingArea.js'></script>
<script type='text/javascript' src='../../eOT/js/CheckInToOR.js'></script>
</head>
<script language="javascript">
async function callOperativeNotes(){
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl = document.forms[0];
	var slate_user_id = formObjDtl.slate_user_id.value;
	var title=encodeURIComponent(getLabel("eOT.NursingNotes.Label","OT"));
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	var called_from = "OPERATIVE_NOTES";//6
	var accession_num=formObj.oper_num.value;//7
	var speciality_code=formObj.oper_speciality_code.value;//8
	var performed_by_ql=formObj.strUser.value;
	var locn_type = "99";//from OPERATIVE_NOTES Locn type=NULL;
	var update_mode="N";
	var hide_header="N";
	var tab_yn="N";
	var cntrl_mode_accession_num="";
	if(speciality_code=="all")
			cntrl_mode_accession_num = facility_id+accession_num+"*ALL"+speciality_code+locn_type;
		else
			cntrl_mode_accession_num = facility_id+accession_num+speciality_code+locn_type;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Operative_notes&accession_num="+accession_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arr_spec=retVal.split(",");
	var arr2_spec="";
	var note_type_value="";
	var note_type="";
	var note_type_desc="";
	note_type =arr_spec[0];
	note_type_desc=arr_spec[1];
	update_mode=arr_spec[3];
	accession_num=arr_spec[4];
	cntrl_mode_accession_num=arr_spec[2];
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";
	var window_close="Y";
if(note_type !="")
{
	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+title+"&note_type="+note_type+"&patient_id="+patient_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+cntrl_mode_accession_num+"&performed_by_ql="+performed_by_ql;
	var title1="";
	var dialogHeight= "100";
	var dialogWidth	= "100";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	secondwindow  = await window.showModalDialog(action_url, title1, features);
}
}	

 async function funsubmitCheckInDtls_Chkeckin_To_Or(){
	var formObj = parent.frames[4].document.forms[0];	
	var order_id = parent.frames[4].document.forms[0].order_id.value;
    	var checklists=parent.frames[4].document.forms[0].verify_checklist_codes.value;
	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;		
		//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];//Modified Against AAKH-SCF-0478
	}

	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
		booking_or_oper_flag = "ORD";
	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	var old_checklist_user_id = (formObj.old_checklist_user_id.value).toUpperCase();
	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	if(old_checklist_user_id!="" && old_checklist_user_id!="null" && old_checklist_user_id!="NULL"){
		if(slate_user_id.toUpperCase()!=old_checklist_user_id.toUpperCase()){
			disable_checklist_fields = "disabled"
			access="NNNNN";
		}
	}
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled"
		access="NNNNN";
	}
	//RUT-SCF-0298 [IN:044218]  Bharati start
	var speciality_code=document.CommonOperDtlsHdrForm.speciality_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=verifychecklist_call_post&speciality_code="+speciality_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	if(retVal=="false")
	{
		alert("APP-OT0170 Speciality does not have checklist defined");
		return; //Added Against ARYU-SCF-0087[IN:067241]
	}
	if(retVal=="true" ){ //RUT-SCF-0298 [IN:044218]  Bharati End
	var viewchecklist_legend = encodeURIComponent(getLabel("eOT.ViewCheckList.Label","OT"));
	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST";
	var db_param = db_param_1 + function_string;
	var url_desc = "VerifyCheckListMain.jsp";
        var url = url_desc+"?"+db_param+"&called_from=OT_CHECKIN_TO_OR&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&function_name="+viewchecklist_legend+"&apply_flag=Y&checklist_stage=C30&pre_or_post=P&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+formObj.no_of_verifications.value+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+formObj.booking_num.value+"&oper_num="+formObj.oper_num.value+"&disable_checklist_fields="+disable_checklist_fields+"&invoked_from=CHECKINTOOR";	
	// By Chaitanya IN:044980
	var retVal;
	var dialogHeight = "40" ;
	var dialogWidth  = "52" ;
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);

	if(retVal==null)
	{
		var CheckInName = encodeURIComponent(getLabel("eOT.CheckIntoOR.Label","OT"));	// By Chaitanya IN:044980
		parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+db_param+"&function_name="+CheckInName;
	}
	else if(retVal=="undefined" || retVal=='undefined')
	{
	}
	else if(retVal!="null" && retVal!="" && retVal!="Y")
	{
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
	}
	else if(retVal!="null" && retVal!="" && retVal=="Y")
	{
		formObj.checklist_completed_yn.value = "Y";
	}
	else
	{
		var CheckInName = encodeURIComponent(getLabel("eOT.CheckIntoOR.Label","OT"));	// By Chaitanya IN:044980
		parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+db_param+"&function_name="+CheckInName;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
  } //RUT-SCF-0298 [IN:044218]
  loadToolBar();//ML-BRU-SCF-1322 [IN:048967] 
}
//ML-BRU-SCF-1322 [IN:048967]  Bharati start
function loadToolBar(){
	var CheckInName = encodeURIComponent(getLabel("eOT.CheckIntoOR.Label","OT"));
	var qrystr="module_id=OT&function_type=F&menu_id=26&access=NYNNN&home_required_yn=N&function_id=OT_CHECKIN_TO_OR&function_name="+CheckInName+"&called_from=OT_SLATE";
   	parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?"+qrystr;
}
//ML-BRU-SCF-1322 [IN:048967]  Bharati end
async function funsubmitCheckInDtls_Chkeckout_From_Or(){
	var formObj = parent.frames[4].document.CheckOutFromORForm;	
    var checklists=formObj.verify_checklist_codes.value;
    var chk_params = formObj.params.value;
	var no_of_verifications = formObj.no_of_verifications.value;
	var checklist_stage = "";
	var post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;
	var post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;
	var post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;
	var post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;

	if(no_of_verifications > 0 && post_oper_user1_completed_yn=="N")
		checklist_stage="C50";		
	else if(no_of_verifications > 1 && post_oper_user2_completed_yn=="N")
		checklist_stage="C60";		
	else if(no_of_verifications > 2 && post_oper_user3_completed_yn=="N")
		checklist_stage="C70";		
	else if(no_of_verifications > 3 && post_oper_user4_completed_yn=="N")
		checklist_stage="C80";		

	var order_id = formObj.order_id.value;
	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;		
		//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
	}
	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
			booking_or_oper_flag = "ORD";

	var old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();
	var old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();
	var old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();
	var old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();

	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	if(checklist_stage=="C50"){
		if(old_post_oper_user1_id!=null && old_post_oper_user1_id!="" && old_post_oper_user1_id!="null" && old_post_oper_user1_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}else if(checklist_stage=="C60"){
		if(old_post_oper_user2_id!=null && old_post_oper_user2_id!="" && old_post_oper_user2_id!="null" && old_post_oper_user2_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}
	if(checklist_stage=="C70"){
		if(old_post_oper_user3_id!=null && old_post_oper_user3_id!="" && old_post_oper_user3_id!="null" && old_post_oper_user3_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}
	if(checklist_stage=="C80"){
		if(old_post_oper_user4_id!=null && old_post_oper_user4_id!="" && old_post_oper_user4_id!="null" && old_post_oper_user4_id!="null"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}

	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled"
		access="NNNNN";
	}
	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST&function_name=Verify Checklist";
	var db_param = db_param_1 + function_string;
	var oper_num=document.forms[0].oper_num.value;
	var url_desc = "VerifyCheckListMain.jsp";
	//Maheshwaran k added 'apply_flag' for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage="+checklist_stage+"&apply_flag=Y&pre_or_post=O&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+no_of_verifications+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+formObj.booking_num.value+"&oper_num="+oper_num+"&disable_checklist_fields="+disable_checklist_fields;

	var retVal;
	var dialogHeight = "94" ;
	var dialogWidth  = "445" ;
	var dialogTop    = "790";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
	if(retVal==""){
		parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKOUT_FROM_OR&function_name=Check-Out%20From%20OR&called_from=OT_SLATE";
	}
	if(retVal==null){
	}else if(retVal=="undefined" || retVal=='undefined'){
	}else if(retVal!="null" && retVal!="" && retVal!="Y"){
	}else if(retVal!="null" && retVal!="" && retVal=="Y"){
		if(no_of_verifications > 0 && checklist_stage=="C50" ){
			formObj.post_oper_user1_completed_yn.value="Y";
			formObj.old_post_oper_user1_id.value = slate_user_id;
		}else if(no_of_verifications > 1 && checklist_stage=="C60" ){
			formObj.post_oper_user2_completed_yn.value="Y";
			formObj.old_post_oper_user2_id.value = slate_user_id;
		}else if(no_of_verifications > 2 && checklist_stage=="C70" ){
			formObj.post_oper_user3_completed_yn.value="Y";
			formObj.old_post_oper_user3_id.value = slate_user_id;
		}else if(no_of_verifications > 3 && checklist_stage=="C80" ){
			formObj.post_oper_user4_completed_yn.value="Y";		
			formObj.old_post_oper_user4_id.value = slate_user_id;
		}

		if(no_of_verifications==1 && checklist_stage=="C50")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==2 && checklist_stage=="C60")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==3 && checklist_stage=="C70")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==4 && checklist_stage=="C80")
			formObj.checklist_completed_yn.value = "Y";
	}else
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

async function funsubmitCheckInDtls_Checkout_Reco(){
	var formObj = parent.frames[4].document.CheckInToRecoveryRoomForm;	
	var checklists=formObj.verify_checklist_codes.value;
	var chk_params = formObj.params.value;
	var no_of_verifications = formObj.no_of_verifications.value;
  
	var checklist_stage = "";
	var post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;
	var post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;
	var post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;
	var post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;

	if(no_of_verifications > 0 && post_oper_user1_completed_yn=="N")
		checklist_stage="C50";		
	else if(no_of_verifications > 1 && post_oper_user2_completed_yn=="N")
		checklist_stage="C60";		
	else if(no_of_verifications > 2 && post_oper_user3_completed_yn=="N")
		checklist_stage="C70";		
	else if(no_of_verifications > 3 && post_oper_user4_completed_yn=="N")
		checklist_stage="C80";		

	var order_id = formObj.order_id.value;
	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;		
		//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
	}
	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
			booking_or_oper_flag = "ORD";

	var old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();
	var old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();
	var old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();
	var old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();

	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	if(checklist_stage=="C50"){
		if(old_post_oper_user1_id!=null && old_post_oper_user1_id!="" && old_post_oper_user1_id!="null" && old_post_oper_user1_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}else if(checklist_stage=="C60"){
		if(old_post_oper_user2_id!=null && old_post_oper_user2_id!="" && old_post_oper_user2_id!="null" && old_post_oper_user2_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}
	if(checklist_stage=="C70"){
		if(old_post_oper_user3_id!=null && old_post_oper_user3_id!="" && old_post_oper_user3_id!="null" && old_post_oper_user3_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}
	if(checklist_stage=="C80"){
		if(old_post_oper_user4_id!=null && old_post_oper_user4_id!="" && old_post_oper_user4_id!="null" && old_post_oper_user4_id!="null"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNN";
			}
		}
	}

	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled"
		access="NNNNN";
	}
	var speciality_code=document.CommonOperDtlsHdrForm.speciality_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=verifychecklist_call_post&speciality_code="+speciality_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	//Added by Daniel against RUT-SCF-0262 [IN:039404]
	if(retVal=="false" )
	{
		alert("APP-OT0170 Speciality does not have checklist defined");
	}	
	//Added by Daniel against RUT-SCF-0262 [IN:039404]
	if(retVal=="true" ){
	var viewchecklist_legend = encodeURIComponent(getLabel("eOT.ViewCheckList.Label","OT"));	
	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST&function_name="+viewchecklist_legend;
	var db_param = db_param_1 + function_string;
	var oper_num=document.forms[0].oper_num.value;
	var url_desc = "VerifyCheckListMain.jsp";
	//Maheshwaran k added 'apply_flag' for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage="+checklist_stage+"&apply_flag=Y&pre_or_post=O&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+no_of_verifications+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+formObj.booking_num.value+"&oper_num="+oper_num+"&disable_checklist_fields="+disable_checklist_fields;

	var retVal;
	var dialogHeight = "94" ;
	var dialogWidth  = "445" ;
	var dialogTop    = "790";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
	
	if(retVal==null || retVal=="" ){
	}else if(retVal=="undefined" || retVal=='undefined'){
	}else if(retVal!="null" && retVal!="" && retVal!="Y"){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
		parent.parent.document.frames.commontoolbarFrame.location.href = "../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKOUT_FROM_OR&function_name=Check-Out%20From%20OR&called_from=OT_SLATE";
	}else if(retVal!="null" && retVal!="" && retVal=="Y"){
		if(no_of_verifications > 0 && checklist_stage=="C50" ){
			formObj.post_oper_user1_completed_yn.value="Y";
			formObj.old_post_oper_user1_id.value = slate_user_id;
		}else if(no_of_verifications > 1 && checklist_stage=="C60" ){
			formObj.post_oper_user2_completed_yn.value="Y";
			formObj.old_post_oper_user2_id.value = slate_user_id;
		}else if(no_of_verifications > 2 && checklist_stage=="C70" ){
			formObj.post_oper_user3_completed_yn.value="Y";
			formObj.old_post_oper_user3_id.value = slate_user_id;
		}else if(no_of_verifications > 3 && checklist_stage=="C80" ){
			formObj.post_oper_user4_completed_yn.value="Y";		
			formObj.old_post_oper_user4_id.value = slate_user_id;
		}

		if(no_of_verifications==1 && checklist_stage=="C50")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==2 && checklist_stage=="C60")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==3 && checklist_stage=="C70")
			formObj.checklist_completed_yn.value = "Y";
		else if(no_of_verifications==4 && checklist_stage=="C80")
			formObj.checklist_completed_yn.value = "Y";
	}else
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
	String empty = "".intern();
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean common_bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	String params = request.getQueryString();
	String trfr_to_ot_flag = checkForNull(request.getParameter("trfr_to_ot_flag"));
	String bill_flag = checkForNull(request.getParameter("bill_flag"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String document_level_yn = checkForNull(request.getParameter("document_level_yn"));
	String oper_num =  checkForNull(request.getParameter("oper_num"));
	String order_id =  checkForNull(request.getParameter("order_id"));
	String storeCode =  checkForNull(request.getParameter("storeCode"));
	String st_interface_flag =  checkForNull(request.getParameter("st_interface_flag"));
	String consumable_entry_cmp_yn =  checkForNull(request.getParameter("consumable_entry_cmp_yn"));
	String rec_packs_in_nurs_notes_yn =  checkForNull(request.getParameter("rec_packs_in_nurs_notes_yn"));
	String operation_sub_services_yn =  checkForNull(request.getParameter("operation_sub_services_yn"));

	String bill_interface_flag_yn = checkForNull(request.getParameter("bill_interface_flag_yn"));//newly added by rajesh on 12/08/08
	String bill_sub_services_yn = checkForNull(request.getParameter("bill_sub_services_yn"));//newly added by rajesh on 12/08/08
	if(bill_flag.equals("false"))
	{
		bill_interface_flag_yn="N";
		bill_sub_services_yn="N";
	}

	ArrayList patient_codes = new ArrayList();
	ArrayList nursing_unit = new ArrayList();
	String booking_start_time="",encounter_id="",oper_speciality_code="",care_locn_type="",care_locn_code="",speciality_desc="",order_catalog="",str_order_catalog_code="",surgeon_desc="",surgeon_code="",practitioner_type="",diag_code_scheme="",anesthetist_code="",anesthetist_desc="",theatre_desc="",patient_name="",booking_num="",patient_id="",episode_id="",date_of_birth="",sex="",ward_code="",oper_room_code="",nursing_unit_desc="",doc_level="",patient_class="",episode_type="",discr_msr_id ="",disable_flag="",source_type="",source_code="",post_oper_diag="",pre_oper_diag="",anesthesia_code="",anesthesia_desc="",contr_mod_accession_num = "",rec_start_time="",rec_end_time="",transfer_to = "",transfer_ward_code="",transfer_status="",oper_date="",visit_id="",recovery_room_code="",p_ord_practitioner_id="";
	String strUser = "";

	patient_codes = common_bean.getPatientDtlCodes(oper_num);
	if(patient_codes!=null && patient_codes.size()>0){
		patient_id = (String) patient_codes.get(0); //0 patient_id
		patient_id = checkForNull(patient_id);
		episode_id = (String) patient_codes.get(1); //1 episode_id
		episode_id = checkForNull(episode_id);
		encounter_id =	(String) patient_codes.get(2); //2  encounter_id
		encounter_id = checkForNull(encounter_id);
		ward_code =	(String) patient_codes.get(3); //3  ward_code
		ward_code = checkForNull(ward_code);
		oper_room_code = (String) patient_codes.get(4); //4  oper_room_code
		oper_room_code = checkForNull(oper_room_code);
		booking_num = (String) patient_codes.get(5); //5  booking_num
		booking_num = checkForNull(booking_num);
		booking_start_time = common_bean.getBookingStartTime(booking_num);
		booking_start_time = checkForNull(booking_start_time);
		surgeon_code = (String) patient_codes.get(6); //6  surgeon_code
		surgeon_code = checkForNull(surgeon_code);
		anesthetist_code = (String) patient_codes.get(7); //7 anesthetist_code
		anesthetist_code = checkForNull(anesthetist_code);
		doc_level = (String) patient_codes.get(8);//documentation_level
		doc_level = checkForNull(doc_level);
		patient_class = (String) patient_codes.get(9); //patient_class
		patient_class = checkForNull(patient_class);
		episode_type = (String) patient_codes.get(10); // episode_type
		episode_type = checkForNull(episode_type);
		source_type = (String) patient_codes.get(11);
		source_type = checkForNull(source_type);  
		source_code = (String) patient_codes.get(12);
		source_code = checkForNull(source_code);
		post_oper_diag = (String) patient_codes.get(13);
		post_oper_diag= checkForNull(post_oper_diag);
		anesthesia_code= (String) patient_codes.get(14);
		anesthesia_code= checkForNull(anesthesia_code);
		oper_speciality_code = (String) patient_codes.get(15);
		oper_speciality_code= checkForNull(oper_speciality_code);
		common_bean.setSpecialityCodeForNotes(oper_speciality_code);
		pre_oper_diag = (String) patient_codes.get(16);
		pre_oper_diag= checkForNull(pre_oper_diag);
		rec_start_time = checkForNull((String) patient_codes.get(17));
		rec_end_time = checkForNull((String) patient_codes.get(18));
		transfer_to = checkForNull((String) patient_codes.get(19));
		transfer_ward_code = checkForNull((String) patient_codes.get(20));
		transfer_status = checkForNull((String) patient_codes.get(21));
		oper_date = checkForNull((String) patient_codes.get(22));
		visit_id = checkForNull((String) patient_codes.get(23));
		recovery_room_code = checkForNull((String) patient_codes.get(24));
	}

	surgeon_desc = common_bean.getSurgeonDesc(surgeon_code);
	anesthetist_desc = common_bean.getAnaesthetistDesc(anesthetist_code);
	anesthetist_desc=checkForNull(anesthetist_desc);
	anesthesia_desc = common_bean.getAnaesthesiaDesc(anesthesia_code);
	theatre_desc = common_bean.getTheatreDesc(oper_room_code);
	speciality_desc = common_bean.getSpecialityDesc(oper_speciality_code);
	nursing_unit = common_bean.getNursingUnitCode(patient_id,encounter_id);
	if(nursing_unit!=null && nursing_unit.size()>0){
		  care_locn_type= (String) nursing_unit.get(0); //assign_care_locn_type
		  care_locn_code = (String) nursing_unit.get(1); //assign_care_locn_code
		  nursing_unit_desc =  common_bean.getNursingUnitDesc(care_locn_code);
	}
	discr_msr_id = common_bean.getDISCR_MSR_ID(oper_speciality_code);
	if( surgeon_doc_comp_yn.equals("Y") || nursing_doc_comp_yn.equals("Y") )
		disable_flag="disabled";
	else 
		disable_flag=empty;

	//contr_mod_accession_num=facility_id+oper_num+oper_speciality_code+"30";
	if(doc_level.equalsIgnoreCase("AS"))
		contr_mod_accession_num = facility_id+oper_num+"*ALL"+"30";
	else
		contr_mod_accession_num = facility_id+oper_num+oper_speciality_code+"30";
%>

<%
	if( document_level_yn.equals("Y") &&(tab.equals("record_surgeon")||tab.equals("record_nursing")) ){ 
%>
<body onLoad="setInitialValue('<%=tab%>');assignDiagnosistxt();docDisableEnable();" >
<%
	}else if(tab.equals("record_surgeon")){
%>
	<body onLoad="setInitialValue('<%=tab%>');assignDiagnosistxt(); callBillingProcedure();" >
<%
	}else if(recovery_in_out_flag.equals("CHECK_IN_RECO")){
%>
	<body onLoad="setInitialValue('<%=tab%>');funRecoveryNotes();" >
<%
	}else if(("OT_HOLDING_AREA").equals(function_id)) {
%>
	<body onLoad="setInitialValue('<%=tab%>');callRecordNotes();" >
<%
	}else{
%>
	<body onLoad="setInitialValue('<%=tab%>');" >
<%
	}
%>

<form name="CommonOperDtlsHdrForm" id="CommonOperDtlsHdrForm">
<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
<%	
	Connection con=null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rset_one=null;
	try
	{
		con=ConnectionManager.getConnection(request);
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
					
		String sql_phy_id="SELECT ORD_PRACT_ID from or_order where order_id='"+order_id+"'";
		pstmt1=con.prepareStatement(sql_phy_id);
		rset_one=pstmt1.executeQuery();
		if(rset_one !=null && rset_one.next())
		{
			p_ord_practitioner_id =rset_one.getString("ORD_PRACT_ID");
			if(p_ord_practitioner_id ==null) p_ord_practitioner_id="";
		}

		stmt=con.prepareStatement("SELECT (SELECT DIAG_CODE_SCHEME FROM OT_PARAM) DIAG_CODE_SCHEME, PRACT_TYPE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
		stmt.setString(1,surgeon_code);
		rs=stmt.executeQuery();
		while(rs.next()){
			diag_code_scheme=(rs.getString("DIAG_CODE_SCHEME"));
			practitioner_type=(rs.getString("PRACT_TYPE"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		stmt=con.prepareStatement("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		stmt.setString(1,slate_user_id_disp);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs.next()){
			strUser=checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		stmt=con.prepareStatement("SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM =? AND NVL(OPER_LINE_STATUS,'X') !='99')");
		stmt.setString(1,facility_id);
		stmt.setString(2,oper_num);
		rs=stmt.executeQuery();
		while(rs.next()){
			order_catalog=(rs.getString("ORDER_CATALOG_CODE"));
			str_order_catalog_code=str_order_catalog_code+order_catalog+"|";
		}
	}catch(Exception e){
		System.err.println("Error In CommonOperDtlsHdr.jsp   "+e);
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<tr>
<!-- Added for PMG2017-SS-CRF-0001-US001 Starts -->
<%
	boolean isRecordAnes = false;
	try{
			con = ConnectionManager.getConnection(request);
			isRecordAnes = CommonBean.isSiteSpecific(con,"OT","OT_RECORD_ANESTHESIA");	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}	
%>
	<td class="label" width='25%' >
		<fmt:message key="eOT.AnaesthesiaType.Label" bundle="${ot_labels}"/> </td>
<%
	if((!isRecordAnes) && (!function_id.equals("07"))){
%>
	<td class="fields" width='25%'>
		<input type='hidden' name='anaesthesia_code' id='anaesthesia_code' value='<%=anesthesia_code%>' >
		<input type='text' class="fields" name='anaesthesia_desc' id='anaesthesia_desc' size='15' value='<%=anesthesia_desc%>'  disabled>
	</td>
<%
	}else if( function_id.equals("07") && isRecordAnes==true ){ 
%>	
	<td>
		<input type="hidden"  name="anaesthesia_code" id="anaesthesia_code" id="anaesthesia_code"  size='14' value="<%=anesthesia_code%>" >
		<input type="text"  name="anaesthesia_desc" id="anaesthesia_desc" size='28' onblur='if(this.value!="")callAnaesthesia1(this); else clearDesc(this);' value="<%=anesthesia_desc%>" <%=disable_flag%> >
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callAnaesthesia1(anaesthesia_desc);" <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%
	}else{
%>
	<td class="fields" width='25%'>
		<input type='hidden' name='anaesthesia_code' id='anaesthesia_code' value='<%=anesthesia_code%>' >
		<input type='text' class="fields" name='anaesthesia_desc' id='anaesthesia_desc' size='15' value='<%=anesthesia_desc%>'  disabled>
	</td>
<%
}
%>
<!-- Added for PMG2017-SS-CRF-0001-US001 Ends -->
	<td class="label" width='25%'>
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width='25%'>
		<input type='hidden' name='anesthestist_code' id='anesthestist_code'  value="<%=anesthetist_code%>" >
		<input type='text' name='anesthestist_desc' id='anesthestist_desc' size='15'  value='<%=anesthetist_desc%>' disabled>
	</td>
</tr>

<tr>
<% 
	if( tab.equals("record_surgeon") || tab.equals("record_nursing") )  { 
%>
	<td class="label" width='25%'>
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </td>
	<td class="fields"  width='25%'>
		<input type='hidden' name='theatre_code' id='theatre_code' value='<%=oper_room_code%>' >
		<input type='text' class="fields" name='theatre_desc' id='theatre_desc' size='15'  value='<%=theatre_desc%>' disabled>
	</td>
<%
	} else{	
%>
	<td class="label" width='25%'>
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> 
	</td>
	<td class="fields" width='25%'>
		<input type='hidden' name='theatre_code' id='theatre_code' value='<%=oper_room_code%>'>
		<input type='text' name='theatre_desc' id='theatre_desc' size='15'  value='<%=theatre_desc%>' disabled>
	</td>
<%
	} 
%>

<% 
	if(document_level_yn.equals("Y")){ 
%>
	<td class="label" width='25%'>
		<fmt:message key="eOT.DocumentationLevel.Label" bundle="${ot_labels}"/> </td>
	<td class="fields" width='25%'>
		<select name='doc_level' id='doc_level' onChange='changeSpeciality();' >
			<option value='IS'>
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>			
			<option value='AS'>
			<fmt:message key="eOT.AcrossSpecialities.Label" bundle="${ot_labels}"/>
			</option>
		</select>
	</td>
</tr>
<% 
	} 
	if(tab.equals("record_surgeon") || tab.equals("record_nursing")){	
	 if( tab.equals("record_surgeon") && surgeon_doc_comp_yn.equals("Y") && ("true").equals(bill_flag)){ 
%>

<tr>
	<td width='35%'></td><!--changed  by Yadav for 13827 -->	
	<td class="fields" align="right" colspan='4'> <!--changed  by Yadav for 13827 -->	
		<a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');">
		<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>	&nbsp;	&nbsp;

		<a class="gridLink" href="javascript:callPostOPDiagnosis();"><fmt:message key="eOT.PostOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>	&nbsp;	&nbsp;
		<a class="gridLink" href="javascript:callpatientHistory();"><fmt:message key="Common.PatientHistory.label" bundle="${common_labels}"/></a>&nbsp;	&nbsp;

 <%
	if(("Y").equals(operation_sub_services_yn)){
%>
	<a class="gridLink" href="javascript:funSurgeryAddlChargesView('<%=patient_id%>','<%=episode_type%>','<%=episode_id%>','<%=visit_id%>','<%=encounter_id%>','<%=surgeon_code%>','<%=source_code%>','<%=oper_num%>','<%=order_id%>','<%=str_order_catalog_code%>','role_pract_id');">
		<fmt:message key="eOT.ViewAdditionalCharges.Label" bundle="${ot_labels}"/></a>	
<%
	}
%>
    </td>			
<%
	}else if( tab.equals("record_nursing") && nursing_doc_comp_yn.equals("Y") ){
%>
 <tr>

 <td width='30%'></td> 
	<td align='right' COLSPAN='3'>
	    <a class="gridLink" id="operative_records" href="javascript:callOperativeNotes();">
		<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/></a> 
		<a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');">
		<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/>

<%
	if( (rec_packs_in_nurs_notes_yn.equals("Y")) && (("N").equals(consumable_entry_cmp_yn))){
%>	
	&nbsp;&nbsp;&nbsp;<a class="gridLink" id='sl_intfc_vw' style='visibility:hidden' href="javascript:callOTSalesWindowview();">
	<fmt:message key="eOT.ViewConsumablesUsed.Label" bundle="${ot_labels}"/></a>
<%
	}
%>
<%
	if((rec_packs_in_nurs_notes_yn.equals("Y")) && ("Y").equals(consumable_entry_cmp_yn)) {
%>
	&nbsp;&nbsp;&nbsp;<a class="gridLink" id='sl_intfc_vw' style='visibility:hidden' href="javascript:callOTSalesWindowview();">
		<fmt:message key="eOT.ViewConsumablesUsed.Label" bundle="${ot_labels}"/></a>
		</a>
<%
	}else if((rec_packs_in_nurs_notes_yn.equals("N")) ) {
%>
		<a class="gridLink" id='sl_intfc_vw'>
<%
	}
%>


		</a>
	</td>
</tr>
<%
	}else{
%>
<tr>
<%
	if( tab.equals("record_surgeon" )){
%>
		<td width='25%'>
		</td>
		<td width='25%'>
		</td>

		<td class="label" width='50%' colspan='3' >
			<!-- <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag);"> -->
		<a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');">
		<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
	    &nbsp; &nbsp;
	<!-- Added by MuthuN against CRF - 011 on 2/7/2013 -->
		<a class='gridLink' href="javascript:callPreOPDiagnosis();">
		<fmt:message key="eOT.PreOperativeDiagnosisNew.Label" bundle="${ot_labels}"/></a>&nbsp; &nbsp;
	<!-- Added by MuthuN against CRF - 011 on 2/7/2013 -->
			
		<a class="gridLink" href="javascript:callPostOPDiagnosis();"><fmt:message key="eOT.PostOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
		 &nbsp; &nbsp;

		<a class="gridLink" href="javascript:callpatientHistory();"><fmt:message key="Common.PatientHistory.label" bundle="${common_labels}"/></a>
	</td>	
</tr>
<%
	}else{
%>
<tr>	
	<td align="right" colspan='3'>
		<a class="gridLink" id="operative_records" href="javascript:callOperativeNotes();">
		<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/></a>&nbsp;&nbsp;
		<a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');">
		<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>	
		&nbsp;&nbsp;
		<%if( (rec_packs_in_nurs_notes_yn.equals("Y")) && (("N").equals(consumable_entry_cmp_yn))){%>
		 <a class="gridLink" id='sl_intfc' style='visibility:hidden' href="javascript:callOTSalesWindow();">
		<fmt:message key="eOT.ConsumablesUsed.Label" bundle="${ot_labels}"/></a>&nbsp;&nbsp;
		<a class="gridLink" id='sl_intfc_vw' style='visibility:hidden' href="javascript:callOTSalesWindowview();">
		<fmt:message key="eOT.ViewConsumablesUsed.Label" bundle="${ot_labels}"/></a>
		<%}%>
		<%if((rec_packs_in_nurs_notes_yn.equals("Y")) && ("Y").equals(consumable_entry_cmp_yn)) {%>
		 <a class="gridLink" id='sl_intfc' >&nbsp;&nbsp;
		<a class="gridLink" id='sl_intfc_vw' style='visibility:hidden' href="javascript:callOTSalesWindowview();">
		<fmt:message key="eOT.ViewConsumablesUsed.Label" bundle="${ot_labels}"/></a>
		</a>
		<%}else if((rec_packs_in_nurs_notes_yn.equals("N")) ) {%>
			<a class="gridLink" id='sl_intfc' ></a>
		<a class="gridLink" id='sl_intfc_vw'></a>
		<%}%>
		</td>
	</tr>
	<%}%>
<%}}%>
<% 
	if( (!tab.equals("record_surgeon")) && (!tab.equals("record_nursing"))&& (!recovery_in_out_flag.equals("CHECK_IN_RECO")) && (!recovery_in_out_flag.equals("CHECK_OUT_RECO")) &&  (!function_id.equals("OT_HOLDING_AREA")) && (!function_id.equals("OT_CHECKIN_TO_OR"))&&(!function_id.equals("OT_CHECKOUT_FROM_OR"))){
	System.err.println("856,CommonOperDtls.jsp==function_id===>"+function_id);
%>
	<td class="label" width='25%' colspan='3'>
	<!-- <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag);">  -->
	 <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');"> 
	 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
	</td>

</tr>
<%}%>
<% 
	if( recovery_in_out_flag.equals("CHECK_IN_RECO") ){
	System.err.println("872,CommonOperDtls.jsp==function_id===>"+function_id);
%>

	<td class="label" width='25%' colspan='3'>
	<a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');"> 
	 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
	 &nbsp;&nbsp
	 <a class="gridLink" href="javascript:callRecordVitals();" id="record_vitals1" 
	style='visible:inline;' > <!-- Modified by Muthukumar against SRR20056-SCF-7683 on 21-06-2011 -->
	 &nbsp;&nbsp
	 <fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a>
	</td>	
	<td>
	</td>
<%}%>
<% 
	if( recovery_in_out_flag.equals("CHECK_OUT_RECO") ){
	System.err.println("887,CommonOperDtls.jsp==function_id===>"+function_id);
%>
  <td class="label" width='25%' colspan='2'>
     <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');"> 
	 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
	 &nbsp;&nbsp
	 <a class="gridLink" href="javascript:funsubmitCheckInDtls_Checkout_Reco();"> 
	<fmt:message key="eOT.VerifyCheckOutChecklist.Label"  bundle="${ot_labels}"/></a>
 </td>

<%}%>
<% 
	if( ("OT_HOLDING_AREA").equals(function_id)){
	System.err.println("896,CommonOperDtls.jsp==function_id===>"+function_id);
%>
    
	<td class="label" width='25%' colspan='3'>
	 <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');"> 
	 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
	&nbsp;&nbsp	
	<a class="gridLink" href="javascript:callRecordVitals_holidingarea();" id="record_vitals" style='visible:inline;'> 
	 <fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a>
	</td>
<%}%>

<% 
	if( ("OT_CHECKIN_TO_OR").equals(function_id)){
	System.err.println("908,CommonOperDtls.jsp==function_id===>"+function_id);
%>
  <td class="label" width='25%' colspan='2'>
   <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');"> 
	 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
    &nbsp;&nbsp;
	<a class="gridLink" href="javascript:funsubmitCheckInDtls_Chkeckin_To_Or();" > 
	 <fmt:message key="eOT.VerifyCheckList.Label" bundle="${ot_labels}"/></a>
  </td>
<%}%>

<% 
	if( ("OT_CHECKOUT_FROM_OR").equals(function_id)){
	System.err.println("921,CommonOperDtls.jsp==function_id===>"+function_id);
%>
  <td class="label" width='25%' colspan='2'>
   <a class="gridLink" href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].pre_oper_diag,'500');"> 
	 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
    &nbsp;&nbsp;
	<a class="gridLink" href="javascript:funsubmitCheckInDtls_Chkeckout_From_Or();" > 
	 <fmt:message key="eOT.VerifyCheckOutChecklist.Label" bundle="${ot_labels}"/></a>
  </td>
<%}%>

<% 
	if( recovery_in_out_flag.equals("CHECK_IN_RECO") ){
	System.err.println("932,CommonOperDtls.jsp==function_id===>"+function_id);
%>
	<tr>
	<td class="label" width='25%'>
	<fmt:message key="eOT.RecoveryNotes.Label" bundle="${ot_labels}"/></td>
	<td class="fields">
			<select name="note_type_val" id="note_type_val"  onchange="onselectnotetype(this)">
			<option value="" selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			</select>
	</td>
	</tr>
<%
	}else if(("OT_HOLDING_AREA").equals(function_id)) {
	System.err.println("946,CommonOperDtls.jsp==function_id===>"+function_id);
%>
	<tr>
	<td class="label" width='25%' >
	<fmt:message key="eOT.HoldingAreaNotes.Label" bundle="${ot_labels}"/></td>

	<td class="fields">		
			<select name="note_type_val" id="note_type_val"  onchange="onselectnotetypeholding(this)">
			<option value="" selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			</select>
	</td>
	</tr>
<%}%>

</table>
<input type='hidden' name='patient_id' id='patient_id' size='22'   value='<%=patient_id%>' disabled>
<input type='hidden' name='patient_name' id='patient_name' size='25'    value='<%=java.net.URLEncoder.encode(patient_name)%>' disabled>
<input type='hidden' name='sex' id='sex' size='10' value='<%=sex%>' disabled>
<input type='hidden' name='date_of_birth' id='date_of_birth' size='10' value='<%=date_of_birth%>' disabled> 
<input type='hidden' name='encounter_id' id='encounter_id' size='15' value='<%=encounter_id%>' disabled>
<input type='hidden' name='nursing_unit_desc' id='nursing_unit_desc' size='12' value='<%=nursing_unit_desc%>' disabled>
<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
<input type='hidden' name='surgeon_desc' id='surgeon_desc' size='15' value='<%=surgeon_desc%>' disabled>
<input type='hidden' name='params' id='params' value='<%=params%>' >
<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>' >
<input type='hidden' name='discr_msr_id' id='discr_msr_id' value='<%=discr_msr_id%>' >
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='document_level' id='document_level' value='<%=doc_level%>' >
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>' >
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>' >
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=oper_speciality_code%>' >
<input type='hidden' name='oper_speciality_code' id='oper_speciality_code' value='<%=oper_speciality_code%>' >
<input type='hidden' name='surgeon_doc_comp_yn' id='surgeon_doc_comp_yn' value='<%=surgeon_doc_comp_yn%>' >
<input type='hidden' name='nursing_doc_comp_yn' id='nursing_doc_comp_yn' value='<%=nursing_doc_comp_yn%>' >
<input type='hidden' name='source_type' id='source_type' value='<%=source_type%>'>
<input type='hidden' name='source_code' id='source_code' value='<%=source_code%>'>
<input type='hidden' name="diagnosis" id="diagnosis" value="<%=post_oper_diag%>">
<input type='hidden' name="pre_oper_diag" id="pre_oper_diag" value="<%=pre_oper_diag%>">
<input type='hidden' name='booking_num' id='booking_num' value='<%=booking_num%>' >
<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>' >
<input type='hidden' name='contr_mod_accession_num' id='contr_mod_accession_num' value='<%=contr_mod_accession_num%>'>
<input type='hidden' name='recovery_room_code' id='recovery_room_code' value='<%=recovery_room_code%>' >
<input type='hidden' name='rec_start_time' id='rec_start_time' value='<%=rec_start_time%>' >
<input type='hidden' name='rec_end_time' id='rec_end_time' value='<%=rec_end_time%>' >
<input type='hidden' name='transfer_to' id='transfer_to' value='<%=transfer_to%>' >
<input type='hidden' name='transfer_ward_code' id='transfer_ward_code' value='<%=transfer_ward_code%>' >
<input type='hidden' name='transfer_status' id='transfer_status' value='<%=transfer_status%>' >
<input type='hidden' name='oper_date' id='oper_date' value='<%=oper_date%>' >
<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>' >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='storeCode' id='storeCode' value="<%=storeCode%>">
<input type='hidden' name='practitioner_type' id='practitioner_type' value="<%=practitioner_type%>">
<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value="<%=diag_code_scheme%>">
<input type='hidden' name='bill_interface_flag_yn' id='bill_interface_flag_yn' value="<%=bill_interface_flag_yn%>">
<input type='hidden' name='bill_sub_services_yn' id='bill_sub_services_yn' value="<%=bill_sub_services_yn%>">
<input type='hidden' name='order_catalog_code' id='order_catalog_code' value="<%=str_order_catalog_code%>">
<input type='hidden' name='trfr_to_ot_flag' id='trfr_to_ot_flag' value="<%=trfr_to_ot_flag%>">
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=request.getParameter("slate_user_id")%>'>
<input type='hidden' name='st_interface_flag' id='st_interface_flag' value='<%=st_interface_flag%>'>
<input type='hidden' name='p_ord_practitioner_id' id='p_ord_practitioner_id' value='<%=p_ord_practitioner_id%>'>
<input type='hidden' name='chk_val' id='chk_val' value=''>
<input type='hidden' name='row_length' id='row_length' value=''>
<input type='hidden' name='note_type' id='note_type' value=''>
<input type='hidden' name='update_mode' id='update_mode' value=''>
<input type='hidden' name='accession_num' id='accession_num' value=''>
<input type='hidden' name='strUser' id='strUser' value='<%=strUser%>'>
<input type='hidden' name='isRecordAnes' id='isRecordAnes' value='<%=isRecordAnes%>'>
</form>
</body>
</html>

<%
	if(recovery_in_out_flag.equals("CHECK_IN_RECO")){
%>
	<SCRIPT>loadToFrame()</SCRIPT>
<% } %>
<% 

	if(function_id.equals("OT_HOLDING_AREA")) {
%>
		<SCRIPT>loadToSecondFrame()</SCRIPT>
<%	} %>

