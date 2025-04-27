var function_id;
var message;

/********************************************************/
function reset(){
	f_query_view.frames[0].document.forms[0].reset() ;	
	f_query_view.frames[1].location.href='../../eCommon/html/blank.html';
}
/********************************************************/
function showdetails(){
	//alert("");
	var formObj=parent.frames[0].document.forms[0];
	var staff_id=formObj.staff_id.value;
	var role_type=formObj.role_type[formObj.role_type.selectedIndex].value;
	var mode=formObj.mode.value;
	var function_id=formObj.function_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	var fields = new Array (formObj.role_type, formObj.staff_id);
	var names = new Array (getLabel("Common.RoleType.label","Common"),getLabel("eRS.StaffId.label","RS"));
	//alert("abc");
	if(parent.parent.f_query_view.checkFields( fields, names, parent.parent.messageFrame)) {	
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc.loadXML(xmlStr ) ;
		xmlHttp.open( "POST","../../eRS/jsp/StaffDetails.jsp?mode="+mode+"&function_id="+function_id+"&role_type="+role_type+"&staff_id="+staff_id, false ) ;
		//alert("123");
		xmlHttp.send(xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert("Response--------->"+responseText);
		eval(responseText);
		
	}
}
/********************************************************/
function showstaffprofile(role_type,staff_id){
	if(role_type=="P")
		var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+staff_id+"&fcall=call";
	else if(role_type=="O")
		var url     = "../../eAM/jsp/OtherStaffDtlsView.jsp?other_staff_id="+staff_id+"&fcall=call";
    var dialogHeight    = "28" ;
    var dialogWidth = "50" ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = window.showModalDialog( url, arguments, features ) ;
}
/******************************************************************/
function showprofile(){
	var formObj=parent.frames[0].document.forms[0];
	var staff_id=formObj.staff_id.value;
	var role_type=formObj.role_type[formObj.role_type.selectedIndex].value;
	var mode=formObj.mode.value;
	var function_id=formObj.function_id.value;
	var fields = new Array (formObj.role_type, formObj.staff_id);
	var names = new Array (getLabel("Common.RoleType.label","Common"),getLabel("eRS.StaffId.label","RS"));	
	if(parent.parent.f_query_view.checkFields( fields, names, parent.parent.messageFrame)) {	
		parent.f_query_details.location.href="../../eRS/jsp/StaffOtherDetails.jsp?staff_id="+staff_id+"&role_type="+role_type+"&mode="+mode+"&function_id="+function_id;
	}
}
/************************************************************/
function listStaffType(name){
	clearStaffType( ) ;
	clearIdName(name);
	var frmObj=document.forms[0];
	var role_type=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eRS/jsp/SkillForPositionValidate.jsp?role_type="+role_type, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
/************************************************************************/
function addStaffType(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frames[0].document.forms[0].staff_type.add(element);
}
/***************************************************************/
function clearStaffType( ) {	
	var len = eval("document.forms[0].staff_type.options.length") ;	
	for(var i=0;i<len;i++)	{
		eval("document.forms[0].staff_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].staff_type.add(opt)") ;
}
/***************************************************************/
function clearIdName(name){
	var frmObj=parent.frames[0].document.forms[0];
	frmObj.staff_id.value="";
	name.innerText="";
}
/****************************************************************/
function viewstaff(target, name){
	var frmObj		=parent.frames[0].document.forms[0];

	var p_role_type=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	var p_staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	var url='../../eRS/jsp/SearchStaff.jsp?p_role_type='+p_role_type+'&p_staff_type='+p_staff_type+'&mode=call';

	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog(url,arguments,features);
	if(retVals !=null){
		if(p_role_type != retVals[2]){
			frmObj.role_type.selectedIndex=0;
			var len=frmObj.role_type.length;
			for(i=0;i<len;i++){
				if(frmObj.role_type.options[i].value==retVals[2]){
					frmObj.role_type.selectedIndex=i;
					break;
				}
			}
			listStaffType(name);
		}
		if(p_staff_type != retVals[3]){
			var len=frmObj.staff_type.length;
			frmObj.staff_type.selectedIndex=0;
			for(i=0;i<len;i++){
				if(frmObj.staff_type.options[i].value==retVals[3]){
					frmObj.staff_type.selectedIndex=i;
					break;
				}
			}
			clearIdName(name);
		}
		target.value=retVals[0];
		name.innerText="  "+retVals[1];
	}
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}
/***************************************/
function showremarks(role_type,staff_id, code, type){
	var dialogHeight ='20' ;
	var dialogWidth = '38' ;
	var dialogTop	= '200';
	var dialogLeft = '10' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	if(type == "L"){
		var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileRemarks.jsp?role_type="+role_type+"&staff_id="+staff_id+"&lic_code="+code+"&title=Licensure",arguments,features);
	}else if(type == "T"){
		var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileRemarks.jsp?role_type="+role_type+"&staff_id="+staff_id+"&trng_code="+code+"&title=Training",arguments,features);
	}else if(type == "E"){
		var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileRemarks.jsp?role_type="+role_type+"&staff_id="+staff_id+"&expr_no="+code+"&title=Exprience",arguments,features);
	}
	return;
}
/***************************************/
function close_remark(){
	window.close();
}
/****************************************/
