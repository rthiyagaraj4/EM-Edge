function reset(){	
	if(f_query_select.document.forms[0]){
		f_query_select.document.forms[0].reset();
	}
}
/*****************************************************************************/
function viewPosition(call_mode, target){
	var frmObj=parent.f_query_select.document.form_SearchStaff;
	var role_type=frmObj.p_role_type.value;	
	if(role_type == 'P')
		var staff_type=frmObj.p_pract_type.value;	
	if(role_type == 'O')
		var staff_type=frmObj.p_other_staff_type.value;	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var posit_text=target.value;
	var posit_code=frmObj.position_code.value;
	var locale=frmObj.locale.value;
	if(	(call_mode=="T")&&(posit_text=='')){
		frmObj.position_code.value='';
		return false;
	}
	
	if(posit_code !=''){
		frmObj.position_code.value='';
		frmObj.p_position_code.value='';
	}
		dataNameArray[0]="role_type";

		dataValueArray[0]=role_type;

		dataTypeArray[0]=STRING;

		//argumentArray[0] ="select position_code code,position_desc description from am_position where eff_status='E' and ('"+staff_type+"' is null or staff_type='"+staff_type+"' ) and upper(role_type) like upper(?) and upper(position_code) like upper(?) and  upper(position_desc) like upper(?) order by position_desc";
		argumentArray[0] ="select position_code code,position_desc description from am_position_lang_vw where eff_status='E' and ('"+staff_type+"' is null or staff_type='"+staff_type+"' ) and upper(role_type) like upper(?) and upper(position_code) like upper(?) and  upper(position_desc) like upper(?) and language_id = '"+locale+"' order by position_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		//retVal =CommonLookup("Positions", argumentArray );
		retVal =CommonLookup(getLabel("eRS.Positions.label","RS"), argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.position_code.value = retVal[0];
		}
}
/*****************************************************************************/
function viewSkill(call_mode, target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=parent.f_query_select.document.form_SearchStaff;
	var role_type=frmObj.p_role_type.value;
	var locale=frmObj.locale.value;
				
	var skill_text=target.value;
	var skill_code=frmObj.skill_code.value;
	var locale=frmObj.locale.value;
	if(	(call_mode=="T")&&(skill_text=='')){
		frmObj.skill_code.value='';
		return false;
	}
	
	if(skill_code !=''){
		frmObj.skill_code.value='';
		frmObj.p_skill_code.value='';
	}

	//argumentArray[0] = "select skill_code code, skill_desc description  from rs_skill where eff_status = 'E' and upper(skill_code) like upper(?) and upper(skill_desc) like upper(?)order by skill_desc ";
	argumentArray[0] = "select skill_code code, skill_desc description  from rs_skill_lang_vw where eff_status = 'E' and upper(skill_code) like upper(?) and upper(skill_desc) like upper(?) and language_id = '"+locale+"' order by skill_desc ";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("eRS.Skill.label","RS"), argumentArray );
	if(retVal != null && retVal != "" )  {
	target.value = retVal[1] ;
	frmObj.skill_code.value = retVal[0];
	}
}                                                                             
/*****************************************************************************/
function allowPositiveNumber() {

	var key = window.event.keyCode;// allows only numbers to be entered
	if((key<48 )||(key>58)){
			return false;
		}
}
/*****************************************************************************/
function viewStaff(){
		
		var frmObj=parent.f_query_select.document.form_SearchStaff;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var p_mode=frmObj.p_mode.value;
		var p_role_type=frmObj.p_role_type.value;
		var p_pract_type=frmObj.p_pract_type.value;
		var p_primary_speciality_code=frmObj.p_primary_speciality_code.value;
		var p_other_staff_type=frmObj.p_other_staff_type.value;
		var p_staff_id=frmObj.p_staff_id.value;
		var p_staff_name=frmObj.p_staff_name.value;
		var p_gender=frmObj.p_gender.value;
		var p_age=frmObj.p_age.value;
		var p_empl_status=frmObj.p_empl_status.value;
		var p_facility_id=frmObj.p_facility_id.value;
		var p_ex1=frmObj.p_ex1.value;
		var p_ex2=frmObj.p_ex2.value;
		var p_position_code=frmObj.position_code.value;
		var p_skill_code=frmObj.skill_code.value;
		var p_license_code=frmObj.p_license_code.value;
		var p_training_code=frmObj.p_training_code.value;
	
		if(p_role_type==""){
				message=getMessage("ROLE_TYPE_BLANK","RS");
			if(p_mode =='call'){
				alert(message);
				return false;
			}else{
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
				return false;
			}
		}
		else 	{
			if(p_role_type=="P")			
			 parent.f_query_details.location.href="../../eRS/jsp/SearchStaffPractitionerResult.jsp?p_mode="+p_mode+"&p_role_type="+p_role_type+"&p_pract_type="+p_pract_type+"&p_primary_speciality_code="+p_primary_speciality_code+"&p_other_staff_type="+p_other_staff_type+"&p_staff_id="+p_staff_id+"&p_staff_name="+p_staff_name+"&p_gender="+p_gender+"&p_age="+p_age+"&p_empl_status="+p_empl_status+"&p_facility_id="+p_facility_id+"&p_ex1="+p_ex1+"&p_ex2="+p_ex2+"&p_position_code="+p_position_code+"&p_skill_code="+p_skill_code+"&p_license_code="+p_license_code+"&p_training_code="+p_training_code;
			
		   else						
			parent.f_query_details.location.href="../../eRS/jsp/SearchStaffOtherStaffResult.jsp?p_mode="+p_mode+"&p_role_type="+p_role_type+"&p_other_staff_type="+p_other_staff_type+"&p_staff_id="+p_staff_id+"&p_staff_name="+p_staff_name+"&p_gender="+p_gender+"&p_age="+p_age+"&p_empl_status="+p_empl_status+"&p_facility_id="+p_facility_id+"&p_ex1="+p_ex1+"&p_ex2="+p_ex2+"&p_position_code="+p_position_code+"&p_skill_code="+p_skill_code+"&p_license_code="+p_license_code+"&p_training_code="+p_training_code;
	
     	 }
	}
/*****************************************************************************/
function ProfileDetails(i){

	var formObj=parent.f_query_details.document.form_SearchStaffPractitioner;
	var role_type=parent.f_query_select.document.form_SearchStaff.p_role_type.value;
	
	var staff_id=eval("formObj.d_staff_id"+i).value;
	
	if(role_type=="P"){
		var url="../../eRS/jsp/SearchStaffViewPractProfileDetails.jsp?staff_id="+staff_id+"&role_type="+role_type+"&fcall=call";
	}
	else{
		var url="../../eRS/jsp/SearchStaffViewOtherStaffProfileDetails.jsp?staff_id="+staff_id+"&role_type="+role_type+"&fcall=call";
	}
	var dialogHeight  = "33" ;
    var dialogWidth = "50" ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;

	var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = window.showModalDialog( url, arguments, features ) ;
}
/*****************************************************************************/
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}
/*****************************************************************************/
function Modify(obj,i){
	var frmObj=parent.f_query_details.document.form_SearchStaffPractitioner;
	var name=obj.innerText;
    var id=eval("frmObj.d_staff_id"+i+".value");
	//var role_type=parent.f_query_select.document.form_SearchStaff.p_role_type.value;
	var role_type=eval("frmObj.p_role_type"+i+".value");
	var staff_type=eval("frmObj.p_staff_type"+i+".value");
	var position_code	=	eval("frmObj.p_position_code"+i+".value");
	var retVal = new Array();
	retVal[0]=id;
	retVal[1]=name;
	retVal[2]=role_type;
	retVal[3]=staff_type;
	retVal[4]=position_code;
    top.window.returnValue = retVal ;
    top.close()
}
/*****************************************************************************/
