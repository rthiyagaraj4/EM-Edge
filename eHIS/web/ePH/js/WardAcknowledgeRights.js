
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11/10/2017	  	IN064272	        prathyusha 											GHL-CRF-0466 [IN064272] 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/


 var function_id	= "PH_WARD_ACK_RIGHTS" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;

function create() {
	
	f_query_add_mod.location.href="../../ePH/jsp/WardAcknowledgementRightsFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {/*COMMENTED FOR GHL-CRF-0466
	f_query_add_mod.location.href="../../ePH/jsp/WardAcknowledgeRightsQueryCriteria.jsp?function_id="+function_id ;
*/	
}


function checkUser(objVal) {
	if (objVal == "") {
		document.FormWardAcknowlegmentRightsQueryCriteria.user_name.disabled=false;
		
	}
	else {
		searchUserNames(document.FormWardAcknowlegmentRightsQueryCriteria.user_name);
	}
}

async function searchUserNames( target ) {
	var frmObj = document.FormWardAcknowlegmentRightsQueryCriteria;
	frmObj.user_id.value = "";
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] = frmObj.SQL_PH_DISP_RIGHTS_SELECT1.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray =await CommonLookup( getLabel("Common.username.label","Common"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" )  {
	frmObj.user_id.value = arr[0];// commented  for GHL-CRF-0466
		username = arr[0];			//Modified for GHL-CRF-0466
 		target.value = arr[1] ; /* if code need to be returned */
		frmObj.user_name.disabled=true;
		frmObj.user_id.value = arr[0];
	}
	else {
		target.value = "";
		target.focus();
		
	}
	var user_id		= frmObj.user_id.value;	//added for GHL-CRF-0466
	if(user_id == ""){
		//alert("User"+getMessage("CAN_NOT_BE_BLANK","PH"));
		frmObj.user_name.focus();
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "User"+getMessage("CAN_NOT_BE_BLANK","PH");
		 return false;
	}
	var mode        =frmObj.mode.value;	//added for GHL-CRF-0466
	
	//added for GHL-CRF-0466
	parent.wardacknowledgerightssubqueryframe.document.location.href ='../../ePH/jsp/WardAckRightsNursingChk.jsp?user_id='+user_id+"&mode="+mode;
}
async function locationLookup(target) {
	var formObj = document.frames.FormWardAcknowlegmentRightsQueryCriteria;

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var retVal = "";
	if (target.name == "nursing_unit")
		argumentArray[0] = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)
				+ "'" + formObj.p_language_id.value + "'";
	
	

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	if (target.name == "nursing_unit")
		retVal =await CommonLookup(getLabel("Common.nursingUnit.label", "Common"),
				argumentArray);
	var str =unescape(retVal);
	var arr = str.split(",");

	if (retVal != null && retVal != "") {
		if (target.name == "nursing_unit")
			formObj.nursing_unit_code.value = arr[0];
		formObj.nursing_unit.disabled=true;
		target.value = arr[1];
	}
}

function apply(){
	if ( !checkIsValidForProceed( "wardacknowledgementrightsqueryform", "apply" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var frmobj			= f_query_add_mod.wardacknowledgerightsqueryframe.document.FormWardAcknowlegmentRightsQueryCriteria;
	var frmobj1 = f_query_add_mod.wardacknowledgerightssubqueryframe.document.FormWardAckRightsNursingChk;//added for GHL-CRF-0466
	var mode =frmobj.mode.value;
	
	if(mode=="1"){
	var user=frmobj.user_name.value;
    //	var nursingUnit=frmobj.nursing_unit.value; COMMENTED FOR GHL-CRF-0466
	if(user == ""){
		alert("User "+getMessage("CAN_NOT_BE_BLANK","PH"));
		frmobj.user_name.focus();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "User  "+getMessage("CAN_NOT_BE_BLANK","PH");
		 return false;
	}
	//COMMENTED FOR GHL-CRF-0466 START
//	if(nursingUnit == ""){
//		alert("nursingUnit Cannot be blank");
//		frmobj.nursing_unit.focus();
//		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "Nursing Unit"+getMessage("CAN_NOT_BE_BLANK","PH");
//		 return false;
//	}
		
			//eval( formApply( frmobj1,PH_CONTROLLER ) ) ;	
			//COMMENTED FOR GHL-CRF-0466 END
	var check=frmobj1.count.value;
	 count=0;
	for (var i=0;i<=check ;i++ ){
      
		if	(eval("frmobj1.general_yn_"+i).value =="Y" ){
				count++;break;
			}
		if	(eval("frmobj1.narcotic_yn_"+i).value =="Y"  ){
			count++;break;
		}
		if	(eval("frmobj1.controlled_yn_"+i).value =="Y"){
			count++;break;
		}
		
		  
		}
	if(count == 0){
		//alert("select atlest one nursing unit");
		alert(getMessage("PH_SELECT_NURSING_UNIT","PH"));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
		var formarray  =new Array(frmobj,frmobj1);//ADDED FOR GHL-CRF-0466
		eval(formApply( formarray,PH_CONTROLLER)) ;//ADDED FOR GHL-CRF-0466
				
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			create();
		
	
	
	}
/* COMMENTD FOR GHL-CRF-0466 START	else if( mode == "2" ){
		
			eval( formApply( frmobj,PH_CONTROLLER ) ) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			//create();
		
			
	
	}//modify if  COMMENTD FOR GHL-CRF-0466 START*/
}
function assignResult( _result, _message, _flag ) {

	result	= _result ;
	message	= _message ;
    flag	= _flag ;
}

function reset() {
/* COMMENTED FOR GHL-CRF-0466 START	if ( checkIsValidForProceed( "wardacknowledgerightsquerycriteria", "reset" ) ) {
		f_query_add_mod.document.query_form.reset();
	} 
	else if ( checkIsValidForProceed( "wardacknowledgementrightsqueryform", "reset" ) ) { COMMENTED FOR GHL-CRF-0466 END */
		
	if(f_query_add_mod.wardacknowledgerightsqueryframe  == undefined || f_query_add_mod.wardacknowledgerightsqueryframe  == "undefined" ){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;	
	}
	else{
	var frmObj = f_query_add_mod.wardacknowledgerightsqueryframe.document.FormWardAcknowlegmentRightsQueryCriteria
		var user_id		= frmObj.user_id.value;	//ADDED FOR GHL-CRF-0466
	if(user_id == ""){
		alert("User  "+getMessage("CAN_NOT_BE_BLANK","PH"));
		frmObj.user_name.focus();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "User "+getMessage("CAN_NOT_BE_BLANK","PH");
		 return false;
	} 
	    var mode        =frmObj.mode.value;	//ADDED FOR GHL-CRF-0466
		if(frmObj.mode.value == MODE_INSERT) {
		//	create(); COMMENTED FOR GHL-CRF-0466
			f_query_add_mod.wardacknowledgerightssubqueryframe.document.location.href ='../../ePH/jsp/WardAckRightsNursingChk.jsp?user_id='+user_id+"&mode="+mode;//ADDED  FOR GHL-CRF-0466
			
		}
	}
	/* COMMENTED FOR GHL-CRF-0466 START	else {
			f_query_add_mod.wardacknowledgerightsqueryframe.location.reload();		
		}
	} COMMENTED FOR GHL-CRF-0466 END */
}
function checkIsValidForProceed( urlName, mode ) {
	var url = f_query_add_mod.location.href;
	if (mode == "apply" && f_query_add_mod.wardacknowledgerightsqueryframe)
		url = f_query_add_mod.wardacknowledgerightsqueryframe.location.href;
	else if (mode == "reset" && f_query_add_mod.wardacknowledgerightsqueryframe)
		url = f_query_add_mod.wardacknowledgerightsqueryframe.location.href;

	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}


function deleterecord() {
		
	if(f_query_add_mod.wardacknowledgerightsqueryframe  == undefined || f_query_add_mod.wardacknowledgerightsqueryframe  == "undefined" ){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;	
	}
	else{
	var frmobj			= f_query_add_mod.wardacknowledgerightsqueryframe.document.FormWardAcknowlegmentRightsQueryCriteria;
	/* COMMENTED FOR GHL-CRF-0466 START	if (frmobj.mode.value!='2'){
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}  
		else{
			var frmobj			= f_query_add_mod.wardacknowledgerightsqueryframe.document.FormWardAcknowlegmentRightsQueryCriteria;
			frmobj.mode.value=MODE_DELETE;
			
			eval( formApply( frmobj,PH_CONTROLLER ) ) ;		
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			create();	
	}	COMMENTED FOR GHL-CRF-0466 END */	
		//ADDED FOR GHL-CRF-0466 START 
	var user_id=frmobj.user_id.value;
	if(user_id == ""){
		alert("User "+getMessage("CAN_NOT_BE_BLANK","PH"));
		frmobj.user_name.focus();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "User  "+getMessage("CAN_NOT_BE_BLANK","PH");
		 return false;
	} 	
	var frmobj1 = f_query_add_mod.wardacknowledgerightssubqueryframe.document.FormWardAckRightsNursingChk;//added for GHL-CRF-0466
		var check=frmobj1.count.value;
		var count=0;
		for (var i=0;i<=check ;i++ ){
			if	(eval("frmobj1.general_yn_"+i).value =="Y" ){
				count++;break;
			}
		if	(eval("frmobj1.narcotic_yn_"+i).value =="Y"  ){
			count++;break;
		}
		if	(eval("frmobj1.controlled_yn_"+i).value =="Y"){
			count++;break;
		}
		
		  
			}
		if(count == 0){
			alert("select atlest one nursing unit");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
		else{
		var get_val=confirm(getMessage("DELETE_RECORD","Common"));
		if(get_val==true){
			frmobj.mode.value=MODE_DELETE;
			
			eval( formApply( frmobj,PH_CONTROLLER ) ) ;		
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			create();	
		}
	
		else{
			frmobj.mode.value=1;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
			
		}
		}
		
}
		//ADDED FOR GHL-CRF-0466 END
}

function modify(obj) {/*COMMENTED FOR GHL-CRF-0466  START
	var userid = trimString(obj.cells[0].innerText);
	var username = trimString(obj.cells[1].innerText);
	var locncode = trimString(obj.cells[2].innerText);
	var locndesc = trimString(obj.cells[3].innerText);
	parent.f_query_add_mod.location.href="../../ePH/jsp/WardAcknowledgementRightsFrames.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&userid="+userid+"&username="+encodeURIComponent(username)+"&locncode="+locncode+"&locndesc="+encodeURIComponent(locndesc);
COMMENTED FOR GHL-CRF-0466 END*/
	}

function AssignValue(obj,cnt){
	
	/* COMMENTED FOR GHL-CRF-0466 START
	  if(obj.checked==true){
		obj.value = "Y";
		
	}
	else{
		obj.value = "N";	
	}   COMMENTED FOR GHL-CRF-0466 END*/
	
//addded for FOR GHL-CRF-0466 start
	var all_count=0;
	var all_gen_count=0;
	var all_nrc_count=0;
	var all_control_count=0;

	formObj=document.FormWardAckRightsNursingChk;
	if(obj.checked==true){
		obj.value = "Y";
	}
	else{
		obj.value = "N";
		document.getElementById("select_yn_"+cnt).checked=false;
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		
		if(obj.name===("general_yn_"+cnt)){
			
			document.getElementById("general_all_yn").checked=false;
			document.getElementById("general_all_yn").value="N";
		}
		if(obj.name===("narcotic_yn_"+cnt)){
			
			document.getElementById("narcotic_all_yn").checked=false;
			document.getElementById("narcotic_all_yn").value="N";
		}
		if(obj.name===("controlled_yn_"+cnt)){
			
			document.getElementById("controlled_all_yn").checked=false;
			document.getElementById("controlled_all_yn").value="N";
		}
		
	}
	if(document.getElementById("general_yn_"+cnt).checked == true){
		if(document.getElementById("narcotic_yn_"+cnt).checked == true){
			if(document.getElementById("controlled_yn_"+cnt).checked == true){
				
				document.getElementById("select_yn_"+cnt).checked=true;
				document.getElementById("select_yn_"+cnt).value="Y";
				
			}
		}
	}
	
	check=formObj.count.value;
	
	
	for (var i=0;i<check ;i++ ){
		if(document.getElementById("select_yn_"+i).checked == true){
			
			all_count++;
		}
	}
		for (var i=0;i<check ;i++ ){
		if(document.getElementById("general_yn_"+i).checked == true){
			
    	   all_gen_count++;
		}
	}
       for (var i=0;i<check ;i++ ){
       if(document.getElementById("narcotic_yn_"+i).checked == true){
			
    	   all_nrc_count++;
		}
	}
       for (var i=0;i<check ;i++ ){
       if(document.getElementById("controlled_yn_"+i).checked == true){
			
    	   all_control_count++;
		}
	}
       //alert(all_count+"all_count"+check);
	if(all_count == check ){
		document.getElementById("select_all_yn").checked=true;
		document.getElementById("select_all_yn").value="Y";
		
	}
//	alert(all_gen_count+"all_gen_count"+check);
	if(all_gen_count == check ){
		document.getElementById("general_all_yn").checked=true;
		document.getElementById("general_all_yn").value="Y";
	}
//	alert(all_nrc_count+"all_nrc_count"+check);
	if(all_nrc_count == check ){
		document.getElementById("narcotic_all_yn").checked=true;
		document.getElementById("narcotic_all_yn").value="Y";
	}
//	alert(all_control_count+"all_nrc_count"+all_control_count);
	if(all_control_count == check ){
		document.getElementById("controlled_all_yn").checked=true;
		document.getElementById("controlled_all_yn").value="Y";
	}
	//FOR GHL-CRF-0466  added for FOR GHL-CRF-0466 end
}
//added for GHL-CRF-0466  START
function  selectAll(obj){

	formObj=document.FormWardAckRightsNursingChk;
	check=formObj.count.value;
	
	if(obj.checked== true){
		
		document.getElementById("select_all_yn").checked=true;
		document.getElementById("select_all_yn").value="Y";
		document.getElementById("general_all_yn").checked=true;
		document.getElementById("general_all_yn").value="Y";
		document.getElementById("narcotic_all_yn").checked=true;
		document.getElementById("narcotic_all_yn").value="Y";
		document.getElementById("controlled_all_yn").checked=true;
		document.getElementById("controlled_all_yn").value="Y";
	for (var i=0;i<=check ;i++ ){
		  document.getElementById("select_yn_"+i).checked=true;
		   document.getElementById("general_yn_"+i).checked=true;
		   document.getElementById("narcotic_yn_"+i).checked=true;
		   document.getElementById("controlled_yn_"+i).checked=true;
		   document.getElementById("select_yn_"+i).checked=true;
		   document.getElementById("general_yn_"+i).value="Y";
		   document.getElementById("narcotic_yn_"+i).value="Y";
		   document.getElementById("controlled_yn_"+i).value="Y";
		}
	}
	else{
		
		  
		document.getElementById("general_all_yn").checked=false;
		document.getElementById("general_all_yn").value="N";
		document.getElementById("narcotic_all_yn").checked=false;
		document.getElementById("narcotic_all_yn").value="N";
		document.getElementById("controlled_all_yn").checked=false;
		document.getElementById("controlled_all_yn").value="N";
	
		for (var i=0;i<=check ;i++ ){

		   document.getElementById("general_yn_"+i).checked=false;
		   document.getElementById("narcotic_yn_"+i).checked=false;
		   document.getElementById("controlled_yn_"+i).checked=false;
		   document.getElementById("select_yn_"+i).checked=false;
		   
		   document.getElementById("general_yn_"+i).value="N";
		   document.getElementById("narcotic_yn_"+i).value="N";
		   document.getElementById("controlled_yn_"+i).value="N";
		  
		}
	}
	
}
function  enableProceed(obj,count){
	
	if(obj.checked==true){
		
		document.getElementById("general_yn_"+count).checked=true;
		document.getElementById("general_yn_"+count).value="Y";
		document.getElementById("narcotic_yn_"+count).checked=true;
		document.getElementById("narcotic_yn_"+count).value="Y";
		document.getElementById("controlled_yn_"+count).checked=true;
		document.getElementById("controlled_yn_"+count).value="Y";
		var all_count=0;
		var all_gen_count=0;
		var all_nrc_count=0;
		var all_control_count=0;
		formObj=document.FormWardAckRightsNursingChk;
		check=formObj.count.value;
		for (var i=0;i<check ;i++ ){
			if(document.getElementById("select_yn_"+i).checked == true){
				
				all_count++;
			}
		}
	
			for (var i=0;i<check ;i++ ){
			if(document.getElementById("general_yn_"+i).checked == true){
				
	    	   all_gen_count++;
			}
		}
	       for (var i=0;i<check ;i++ ){
	       if(document.getElementById("narcotic_yn_"+i).checked == true){
				
	    	   all_nrc_count++;
			}
		}
	       for (var i=0;i<check ;i++ ){
	       if(document.getElementById("controlled_yn_"+i).checked == true){
				
	    	   all_control_count++;
			}
		}
	       //alert(all_count+"all_count"+check);
		if(all_count == check ){
			document.getElementById("select_all_yn").checked=true;
			document.getElementById("select_all_yn").value="Y";
			
		}
//		alert(all_gen_count+"all_gen_count"+check);
		if(all_gen_count == check ){
			document.getElementById("general_all_yn").checked=true;
			document.getElementById("general_all_yn").value="Y";
		}
//		alert(all_nrc_count+"all_nrc_count"+check);
		if(all_nrc_count == check ){
			document.getElementById("narcotic_all_yn").checked=true;
			document.getElementById("narcotic_all_yn").value="Y";
		}
//		alert(all_control_count+"all_nrc_count"+all_control_count);
		if(all_control_count == check ){
			document.getElementById("controlled_all_yn").checked=true;
			document.getElementById("controlled_all_yn").value="Y";
	}
		
	}
	else{
		document.getElementById("general_yn_"+count).checked=false;
		document.getElementById("general_yn_"+count).value="N";
		document.getElementById("narcotic_yn_"+count).checked=false;
		document.getElementById("narcotic_yn_"+count).value="N";
		document.getElementById("controlled_yn_"+count).checked=false;
		document.getElementById("controlled_yn_"+count).value="N";
		document.getElementById("general_all_yn").checked=false;
		document.getElementById("general_all_yn").value="N";
		document.getElementById("narcotic_all_yn").checked=false;
		document.getElementById("narcotic_all_yn").value="N";
		document.getElementById("controlled_all_yn").checked=false;
		document.getElementById("controlled_all_yn").value="N";
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		
	}

}
function gen_Sel(obj,count){
	//alert(count);
	var formObj=document.FormWardAckRightsNursingChk;
	var count=formObj.count.value;
	if(obj.checked==true){
	for(var i=0;i<=count;i++){
		
		document.getElementById("general_yn_"+i).checked=true;
		document.getElementById("general_yn_"+i).value="Y";
	}
	
	if(document.getElementById("general_all_yn").checked == true){
		if(document.getElementById("narcotic_all_yn").checked == true){
			if(document.getElementById("controlled_all_yn").checked == true){
				
				document.getElementById("select_all_yn").checked=true;
				document.getElementById("select_all_yn").value="Y";
				
				for(var i=0;i<=count;i++){
					 document.getElementById("select_yn_"+i).checked=true;
				}
				
			}
			
		}
	}
	else{
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		for (var i=0;i<=count ;i++ ){
			  document.getElementById("select_yn_"+i).checked=false;
		}
	}
	}
	else{
		for(var i=0;i<=count;i++){
		document.getElementById("general_yn_"+i).checked=false;
		document.getElementById("general_yn_"+i).value="N";	
		}
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		for (var i=0;i<=count ;i++ ){
			  document.getElementById("select_yn_"+i).checked=false;
		}
	}
}
function nar_Sel(obj,count){
	//alert(count);
	var formObj=document.FormWardAckRightsNursingChk;
	var count=formObj.count.value;
	if(obj.checked==true){
	for(var i=0;i<=count;i++){
		document.getElementById("narcotic_yn_"+i).checked=true;
		document.getElementById("narcotic_yn_"+i).value="Y";
	}
	
	if(document.getElementById("general_all_yn").checked == true){
		if(document.getElementById("narcotic_all_yn").checked == true){
			if(document.getElementById("controlled_all_yn").checked == true){
				
				document.getElementById("select_all_yn").checked=true;
				document.getElementById("select_all_yn").value="Y";
				
			
				for (var i=0;i<=count ;i++ ){
					  document.getElementById("select_yn_"+i).checked=true;
				}
			}
			
		}
	}
	else{
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		for (var i=0;i<=count ;i++ ){
			  document.getElementById("select_yn_"+i).checked=false;
		}
	}
	
	}
	else{
		for(var i=0;i<=count;i++){
		document.getElementById("narcotic_yn_"+i).checked=false;
		document.getElementById("narcotic_yn_"+i).value="N";	
		}
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		for (var i=0;i<=count ;i++ ){
			  document.getElementById("select_yn_"+i).checked=false;
		}
	}
}
function con_Sel(obj,count){
	//alert(count);
	var formObj=document.FormWardAckRightsNursingChk;
	var count=formObj.count.value;
	if(obj.checked==true){
	for(var i=0;i<=count;i++){
	document.getElementById("controlled_yn_"+i).checked=true;
	document.getElementById("controlled_yn_"+i).value="Y";
}
	if(document.getElementById("general_all_yn").checked == true){
		if(document.getElementById("narcotic_all_yn").checked == true){
			if(document.getElementById("controlled_all_yn").checked == true){
				
				document.getElementById("select_all_yn").checked=true;
				document.getElementById("select_all_yn").value="Y";
				
				for (var i=0;i<=count ;i++ ){
					  document.getElementById("select_yn_"+i).checked=true;
				}
			}
			
		}
		
	}
	else{
		document.getElementById("select_all_yn").checked=false;
		document.getElementById("select_all_yn").value="N";
		for (var i=0;i<=count ;i++ ){
			  document.getElementById("select_yn_"+i).checked=false;
		}
	}
	
	}
	else{
		for(var i=0;i<=count;i++){
		document.getElementById("controlled_yn_"+i).checked=false;
		document.getElementById("controlled_yn_"+i).value="N";	
	}
		
			document.getElementById("select_all_yn").checked=false;
			document.getElementById("select_all_yn").value="N";
			for (var i=0;i<=count ;i++ ){
				  document.getElementById("select_yn_"+i).checked=false;
			}
		
	}
}
//added for GHL-CRF-0466 END