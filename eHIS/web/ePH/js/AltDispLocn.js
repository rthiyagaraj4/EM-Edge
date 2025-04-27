  var function_id = "PH_ALT_DISP_LOCN" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;
var Eff_status = "";
var SEL1= "";
var app_pat= "";
var ord_src_type="";
var dis_loc_code="";
var DB_MODE=" ";
//var res="";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/AltDispLocnFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function query() {
      
//f_query_add_mod.location.href="../../ePH/jsp/AlternateDispLocnQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;

}
function apply(){
	var frmobj;
 
if(f_query_add_mod.alt_disp_locn_header!=undefined) {
	frmobj = f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm;
	} else {
		frmobj = f_query_add_mod.document.AltDispLocnHeaderForm;
	}

	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = frmobj.facility_id;
	fields[1]   = frmobj.ORDER_SRC_TYPE ;
	fields[2]   = frmobj.ORDER_SRC_LOCN1 ;
   	fields[3]   = frmobj.CURR_DISP_LOC ;
	fields[4]   = frmobj.PERFORM_FCY ;
	fields[5]   = frmobj.day_type ;
	names[0]   = getLabel("Common.OrderingFacility.label","Common");   
	names[1]   = getLabel("ePH.OrderingSourceType.label","PH") ;
	names[2]   = getLabel("ePH.OrderingSourceLocationDesc.label","PH");
	names[3]   = getLabel("ePH.CurrentDispenceLocation.label","PH");
	names[4]   = getLabel("Common.PerformingFacility.label","Common"); 
	names[5]   = getLabel("ePH.DayType.label","PH");
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){	
          		   
	if(timeintchk()  &&  sechk()){	
				eval( formApply( frmobj,PH_CONTROLLER) ) ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
          if( result ){
			   onSuccess();
		    }
			}else{				
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			}      
}
}
 function sechk()
 {
	var formobj=f_query_add_mod.alt_disp_locn_detail.document.AltDisplocnDeatil;
	//alert(" In the sechk");
    var count=formobj.count.value;
		for(var i=1;i<count;i++){
			if(eval('formobj.select_'+i) != undefined){
				if(eval('formobj.select_'+i).checked == true){
					 var val1 = eval('formobj.frmtime_'+i).value;
					 var val2 = eval('formobj.totime_'+i).value;
					 
					 if((val1=="" )||(val2=="")){
					
					 alert(getMessage("ALT_TIMINGS_BLANK","PH"));
					
					return false;
					 }
				}
			
			}
			
		}
			
			 return true;
			
	}








 function timeintchk(){
	
	var formobj=f_query_add_mod.alt_disp_locn_detail.document.AltDisplocnDeatil;
	if(formobj==undefined)
	 {
		alert(getMessage("ATL_DISP_LOCN_SELECT","PH"));
		return false;
	 }

   var count=formobj.count.value;
	   
		var flag='U';
		for(var i=1;i<count;i++){
			if(eval('formobj.select_'+i) != undefined){
				if(eval('formobj.select_'+i).checked == true){
					
					flag='I';
				}
			}
		}
		//alert(flag);
		if(flag == 'U'){
			var msg=getMessage("PH_ATLEAST_ONE_SELECTED","PH");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}else{
			return true;
		}
 return true;
 }
function reset() {
	/* var formobj=f_query_add_mod.alt_disp_locn_header.AltDispLocnHeaderForm
	 
	 var mode=formobj.mode.value;
	 if(mode == '1'){
			formobj.reset();
			formobj.routing_code.style.visibility="visible";
			formobj.routing_code.style.display="inline";
			f_query_add_mod.alt_disp_locn_detail.location.href="../../eCommon/html/blank.html";
		 
	 }else{
		 f_query_add_mod.alt_disp_locn_detail.location.reload();
		
	 }*/
	f_query_add_mod.location.href="../../ePH/jsp/AltDispLocnFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
 }

function checkIsValidForProceed( urlName, mode ) {
	var url = f_query_add_mod.location.href;
	if (mode == "reset" && f_query_add_mod.alt_disp_locn_header)
		url = f_query_add_mod.alt_disp_locn_header.location.href;
	else if (mode == "apply" && f_query_add_mod.alt_disp_locn_detail)
		url = f_query_add_mod.alt_disp_locn_detail.location.href;

	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}
function sendbl(){
	 parent.parent.f_query_add_mod.alt_disp_locn_detail.location.href="../../eCommon/html/blank.html";
}

function assignResult( _result, _message, _flag ) {
	result	= _result ;
	message	= _message ;
	flag	= _flag ;
}

function beforePost(xmlStr) {
	//alert("1"+xmlStr);
}

async function searchLocationName() {

formObj=document.AltDispLocnHeaderForm;
//alert(formObj);
//document.AltDispLocnHeaderForm.ORDER_SRC_LOCN.value="";
//parent.f_query_add_mod.document.AltDispLocnHeaderForm.facility_id.value=" ";

	var ord_src_type= formObj.ORDER_SRC_TYPE.value;
	if(ord_src_type !=''){

		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		
		dataNameArray[0]	= "FACILITY_ID";	
		dataValueArray[0]	= document.AltDispLocnHeaderForm.facility_id.value;
		dataTypeArray[0]	= STRING ;
		if(app_pat=="E"||app_pat=="C")
		{
			dataNameArray[1]	= "CLINIC_TYPE";	
			dataValueArray[1]	= document.AltDispLocnHeaderForm.ORDER_SRC_TYPE.value;
			dataTypeArray[1]	= STRING ;
		}
		else
		{
			dataNameArray[1]	= "APPL_PATIENT_CLASS";	
			dataValueArray[1]	= app_pat;
			dataTypeArray[1]	= STRING ;
		}
		argumentArray[0]	= SEL1;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]    = "3,4";
		argumentArray[5]	= document.AltDispLocnHeaderForm.ORDER_SRC_LOCN1.value ;
		argumentArray[6]	= DESC_LINK ;
		argumentArray[7]	= DESC_CODE ; 
		retVal = await CommonLookup( getLabel("Common.LocationName.label","Common"), argumentArray );
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		if(retVal != null && retVal != "" )  {
			document.AltDispLocnHeaderForm.ORDER_SRC_LOCN1.value=	 arr[1] ;
			document.AltDispLocnHeaderForm.ord_src_code1.value=	 arr[0] ;
			document.AltDispLocnHeaderForm.ORDER_SRC_LOCN.value=	 arr[0] ;
			document.AltDispLocnHeaderForm.ORDER_SRC_LOCN1.disabled=true ;
			
		}
	}
}

function getdetail()
{
          
		 formObj=document.AltDispLocnHeaderForm;
		
}
function CollectValues()
{ 
		var frmobj;
		var routing_level_flag=true;
		frmobj = document.AltDispLocnHeaderForm;
		var facility_id = frmobj.facility_id.value;
		
		var ord_src_type= frmobj.ORDER_SRC_TYPE.value;
		if(ord_src_type=='E')
			ord_src_type='C'
		if(ord_src_type=='D')
			ord_src_type='N'
		var performing_facility = frmobj.PERFORM_FCY.value;
		var disp_loc_code = frmobj.disp_locn_code.value;
		var ord_source_code = frmobj.ord_src_code1.value;
		var day_type = frmobj.day_type.value;
		var routing_level=frmobj.routing_level.value;
		var rout_code=frmobj.routing_code.value;
		var prio=frmobj.LOCN_BS_ORDRS.value;
		if(routing_level!="S")
		{
			
			if(routing_level=="O"||routing_level=="D"||routing_level=="L")
			{
				
				if(frmobj.routing_code.value=="")
				{
					
					routing_level_flag=false;
				}
			}
			if(routing_level=="G"||routing_level=="M")
			{

				rout_code=frmobj.drug_code.value;
				
				if(frmobj.drug_desc.value=="")
				{					
					 routing_level_flag=false;
				}	
			}
		}
		if(performing_facility==""||day_type==""||disp_loc_code==""||ord_source_code==""||ord_src_type==""||routing_level_flag==false)
		{ 
			   apply_1();
		}			
		else 
		{

		   parent.alt_disp_locn_detail.location.href="../../ePH/jsp/AltDispLocnDeatil.jsp?mode="+MODE_MODIFY +"&ORD_SRC_TYPE="+ord_src_type+"&order_fcy="+facility_id+"&perform_fcy="+performing_facility+"&disp_loc_code="+disp_loc_code+"&ord_src_code="+ord_source_code+"&day_type="+day_type+"&rout_level="+routing_level+"&rout_code="+rout_code+"&prio="+prio;

		}
		   
}



//////// here we have to use for the time check//////////////////
function clearData(obj) {
	obj = eval(obj);
	//alert(obj.length);
	var len = obj.length;
 //alert(" leng "+len);
	for (var i=0; i<=len; i++) {
		obj.remove(""); 
	}
	var opt	= document.createElement('OPTION');
	opt.value =	"";
	opt.text = "         ----"+getLabel("Common.defaultSelect.label","Common")+"----           ";
	obj.add(opt);
}



function addData(code, desc, obj) {
	obj = eval(obj);
	var ord_src_code1 = trimString(document.AltDispLocnHeaderForm.ord_src_code1.value);
	var alt_disp_code1 = document.AltDispLocnHeaderForm.disp_locn_code.value;
	
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	trimString(code);
   	opt.text = desc; 
	 	obj.add(opt);
	//alert(opt.text);
	var locnType = code.split('|');
	var alt_disp_code= locnType[0];
    if(ord_src_code1==trimString(code)){
		opt.selected="selected"; 	
	}
		
	if(alt_disp_code==alt_disp_code1){
	     opt.selected="selected";
	}
}


function getaltdisploc(){
	var  frmobj=f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm;
	
	if(frmobj.facility_name !=  null && frmobj.ORDER_SRC_TYPE!= null && frmobj.ORDER_SRC_LOCN !=  null){
	var order_fcy =  frmobj.facility_id.value;
	var ord_src_type =  frmobj.ORDER_SRC_TYPE.value;
	var order_src_locn =  frmobj.ORDER_SRC_LOCN.value;
	  var order_src_code =  frmobj.ord_src_code1.value;
	if (order_fcy!=' '  && ord_src_type != ' ' && order_src_locn!=' ') {
		
		var bean_id		= frmobj.bean_id.value ;
		var bean_name	= frmobj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr;
		xmlStr ="<root><SEARCH " ;
		
		xmlStr+= "order_fcy =\"" + order_fcy + "\" " ;
		xmlStr+= "ord_src_type =\"" + ord_src_type + "\" " ;
		xmlStr+= "order_src_locn =\"" + order_src_code + "\" " ;
   xmlStr+= "order_src_code =\"" + order_src_code + "\" " ;
		xmlStr +=" /></root>" ;

		//alert(">>>>>>>>>"+xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
      
		xmlHttp.open( "POST", "AltDispLocnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ALT_DISP_LOC" + "&order_fcy=" + order_fcy+ "&ord_src_type=" + ord_src_type+ "&order_src_locn=" + order_src_code+"&ORDER_SRC_CODE=" +order_src_code, false ) ;
		
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval( responseText ) ;
	}
	}
	
}
function getdisploc(){
	  var  frmobj=document.AltDispLocnHeaderForm;
	if(frmobj.ORDER_FCY !=  null && frmobj.ORDER_SRC_TYPE!= null && frmobj.ORDER_SRC_LOCN1 !=  null){
	var order_fcy =  frmobj.facility_id.value;
	var ord_src_type =  frmobj.ORDER_SRC_TYPE.value;
	if(ord_src_type=='E')
			ord_src_type='C'
		if(ord_src_type=='D')
			ord_src_type='N'
	var order_src_locn =  frmobj.ORDER_SRC_LOCN.value;
	if (order_fcy!=""  && ord_src_type !="" && order_src_locn!="") {
		var bean_id		= frmobj.bean_id.value ;
		var bean_name	= frmobj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr;
		xmlStr ="<root><SEARCH " ;
		xmlStr+= "order_fcy =\"" + order_fcy + "\" " ;
		xmlStr+= "ord_src_type =\"" + ord_src_type + "\" " ;
		xmlStr+= "order_src_locn =\"" + order_src_locn + "\" " ;
		xmlStr +=" /></root>" ;
        //alert("-----"+xmlStr); 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
      
		xmlHttp.open( "POST", "AltDispLocnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CUR_DISP_LOC" + "&order_fcy=" + order_fcy+ "&ord_src_type=" + ord_src_type+ "&order_src_locn=" + order_src_locn, false ) ;
		
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert("------"+responseText);
		eval( responseText ) ;
	}
	}
	
}

function addData1(code, obj){
	var  frmobj=f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm;
	obj = eval(obj);
	if(code=='')
	 frmobj.alt_disp_locn_code.value=code;
	
}
function checkTime(obj)
{
	if(obj.readOnly)	return;
	if(obj.value=="")
		return;
	
	if(!chkTime(obj.value))
	{
		alert(getMessage("ALT_TIMING_INVALID","PH"));
		return false;
	}
}



function onSuccess(){
   var frmobj;
	frmobj = f_query_add_mod.location;
	frmobj.reload();
			
}

function assignValue(obj,objno){
var frmtime=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.frmtime_"+objno).value;
	var totime=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno).value;	
  //alert("inthe assign"+frmtime+totime)
  if(obj.checked)
	{
    //res="3";
	if((frmtime=="")|| (totime==""))
	 alert(getMessage("ALT_TIMINGS_BLANK","PH"));
	eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.enable_"+objno+".value='E'");
	}



}

function altdisplocnselect(obj,objno)
{           
	var frmobj=parent.parent.f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm;
	var frmobj1=parent.alt_disp_locn_detail.AltDisplocnDeatil;	
	var flag="I";
	var alt_disp_code=eval(" parent.alt_disp_locn_detail.AltDisplocnDeatil.code_"+objno).value;
	var frmtime=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.frmtime_"+objno).value;
	var totime=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno).value;
	var eff_sta=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.enable_"+objno).value;
	var select_flag=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.flag_"+objno).value;
	var arrValue=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.arrVal_"+objno).value;
	var repeat=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.repeat_"+objno).value;
	Eff_status=eff_sta;
	/*if(obj.checked)
	{
		obj.value="Y";
	 eff_sta="E";	
	}
	else
	{
		if(totime!="")
		{
			obj.value="N";
			 eff_sta="D";
		}
		else
		{
			obj.value="Y";
			eff_sta="E";
		}
	}
*/
	if(eff_sta=="E")
	{
		obj.value="Y"
	}
	else
	{
		obj.value="N"
	}

finalcompare(eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.frmtime_"+objno),eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno));
	
	var bean_id		= frmobj.bean_id.value ;
	var bean_name	= frmobj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "alt_disp_code =\"" + alt_disp_code + "\" " ;
	xmlStr+= "frmtime =\"" + frmtime + "\" " ;
	xmlStr+= "totime =\"" + totime + "\" " ;
	xmlStr+= "eff_status =\"" + eff_sta + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open( "POST", "AltDispLocnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=alt_disp_locn_select" + "&alt_disp_code=" + alt_disp_code+"&frmtime="+frmtime+"&totime="+totime+"&flag="+flag+"&eff_status="+eff_sta+"&repeat="+repeat, false) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;	
	eval( responseText ) ;
}

function showtimings(){
	var  frmobj=document.AltDispLocnHeaderForm;
	
	var order_fcy =  frmobj.ORDER_FCY.value;
	var short_desc= frmobj.CURR_DISP_LOC.value;
	frmobj.disp_locn_code.value=short_desc;
	//alert("------short_desc-----"+short_desc+"---order_fcy----"+order_fcy);

	var bean_id		= frmobj.bean_id.value ;
	var bean_name	= frmobj.bean_name.value ;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "order_fcy =\"" + order_fcy + "\" " ;
	xmlStr+= "short_desc =\"" + short_desc + "\" " ;
	xmlStr +=" /></root>" ;
			//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "AltDispLocnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=for_timings" + "&order_fcy=" + order_fcy+"&short_desc="+short_desc, false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		 //alert(responceText);
		 eval( responseText ) ;
}
function addtimings(working_hours_from,working_hours_to)
{   
	 //alert();
	document.AltDispLocnHeaderForm.Time_from.value=working_hours_from;
document.AltDispLocnHeaderForm.Time_to.value=working_hours_to;
	
}



function comparetimes(obj,objno)
{
	
   	frmobj=parent.parent.f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm;
	frmobj1=parent.alt_disp_locn_detail.AltDisplocnDeatil;
	var frm_time=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.frmtime_"+objno);
	var frmtime=frm_time.value;
	var to_time=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno);
	var totime=to_time.value;
	if(frmtime==""&&totime!=""){
		alert(getMessage("PH_FROM_TIME_NOT_BLANK","PH"));
		frm_time.focus();
		return false;
	}
    
	
	if(frmtime!=""&&totime!=""){// this is to chk from date is not greater than to date ...
		if(!comparetime1(frmtime,totime)){
			to_time.value ="";
			to_time.focus();
			return false;
		}
	}
	

}

function allowPositiveNumber() { //alert()
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}	
function  appedzero(obj){
	if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr; }else if(strHr.length==0){strHr = "00"; }else if(strHr.length>2){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi; }else if(strMi.length==0){strMi = "00"; }else if(strMi.length>2){strMi = "00"; }
			obj.value=strHr+":"+strMi;
		}else{
			if(from_val.length == 1){
				obj.value= "0"+from_val+":"+"00";
			}else if (from_val.length == 2){
				obj.value= from_val+":"+"00";
			}
		}
	}
	if(!chkTime(obj.value)){
	//	obj.value="";
	//	alert(getMessage("INVALID_TIME_FMT"));
		return false;

	}
}

function searchBasedOnCriteria(obj)	{
	document.AltDispLocnHeaderForm.ORDER_SRC_LOCN1.disabled=false ;
	document.AltDispLocnHeaderForm.ORDER_SRC_LOCN1.value="" ;
	var phtrn		= document.AltDispLocnHeaderForm.ORDER_SRC_TYPE.value ;
	str				=	phtrn.substr(0,1);
	ord_src_type		=	"";
	var routingLevelObj =document.AltDispLocnHeaderForm.routing_level ;
	if(obj.value=='N'){
		var element = document.createElement('OPTION') ;
		element.value =  "H" ;
		element.text =  getLabel("ePH.HomeLeave.label","PH") ;
		routingLevelObj.add(element);
	}
	else{
		var len = routingLevelObj.options.length
		for(var i=0;i<len;i++) {
			if(routingLevelObj.options[i].value == "H"){
				routingLevelObj.remove(i) ;
				break;
			}
		}
	}
	if(str=="N"||str=="D"){
		SEL1= document.AltDispLocnHeaderForm.sql2.value+"'"+document.AltDispLocnHeaderForm.language_id.value+"'";
		if(str=="N")
			app_pat="IP";
		else
			app_pat="DC";
	}
	else if(str=="C"||str=="E"){
		app_pat=str;
		SEL1=  document.AltDispLocnHeaderForm.sql3.value+"'"+document.AltDispLocnHeaderForm.language_id.value+"'";
	}
	document.AltDispLocnHeaderForm.ORDER_SRC_LOCN.value	=	ord_src_type;
	// alert("in the search"+ord_src_type);
	if(phtrn==''){
		var mess=getMessage("PH_ST_DOCUMENT_TYPE","PH");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+mess;
		return false;
	}
}  


function sendtimings(obj,objno){
		
	frmobj=parent.parent.f_query_add_mod.alt_disp_locn_header.document.formAlternateDispLocn;
	frmobj1=parent.alt_disp_locn_detail.AltDisplocnDisplay;

	var frm_time=eval("parent.alt_disp_locn_detail.AltDisplocnDisplay.frmtime_"+objno);
	var frmtime=frm_time.value;

	var to_time=eval("parent.alt_disp_locn_detail.AltDisplocnDisplay.totime_"+objno);
	var totime=to_time.value;
	var bean_id		= frmobj.bean_id.value ;
	var bean_name	= frmobj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "frmtime =\"" + frmtime + "\" " ;
	xmlStr+= "totime =\"" + totime + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AlternateDispLocnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=store_timings" + "&frmtime="+frmtime+"&totime="+totime+"&flag="+flag+"&eff_status="+Eff_status	, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function finalcompare(frmtime,to_time){
	var fromtime=frmtime.value;
	var totime=to_time.value;
	
	var strHr1;
	var strMi1;
	
	var strHr2;
	var strMi2;

	var strHr3;
	var strMi3;

	var strHr4;
	var strMi4; 

   	var timefield1 = fromtime;
	var strTimeArray1 = new Array();

	var timefield2 = totime;
	var strTimeArray2 = new Array();

	//var timefield3 = tar_from;
	//var strTimeArray3= new Array();

	//var timefield4 = tar_to;
	//var strTimeArray4= new Array();

	if(	timefield1 != null  && timefield1 != ""){
	strTimeArray1 = timefield1.split(":");
		strHr1 = strTimeArray1[0];
		strMi1 = strTimeArray1[1];
	}
    if(	timefield2 != null && timefield2 != ""){
    strTimeArray2 = timefield2.split(":");
		strHr2 = strTimeArray2[0]; 
		strMi2 = strTimeArray2[1];
	}
	
	if(strHr1 <= strHr3){
		 if(strHr2 > strHr4){
			alert( getMessage("TO_TIME_LESS_CUR_DISP_FR_TIME","PH"));
			to_time.select();
             to_time.focus();
		 }
	}
}
function validtime(obj,obj1)
{
	var strHr;
	var strMi;
	var timefield = obj.value;
	var strTimeArray = new Array();
		
    
	strTimeArray = timefield.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];

    
	if(strHr>=24|| strMi>=60){
        alert(getMessage("ALT_TIMING_INVALID","PH"));
	        clearData1(obj);
		 		return false;

	}else if((obj.value!=""&&obj1.value!="")&&(obj.value==obj1.value)){
        alert(getMessage("FROM_TIME_TO_TIME_NOT_SAME","PH"));
	        clearData1(obj);
		 		return false;
	}else{
		return true;
	}
}


function clearData1(obj) {
	obj = eval(obj);
	//alert(obj.value);
	var len = obj.length;
 		obj.value="";
		obj.focus();
		 
}
function apply_1()
{
var frmobj;
	
		frmobj = document.AltDispLocnHeaderForm;
	

	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = frmobj.facility_id;
	fields[1]   = frmobj.ORDER_SRC_TYPE ;
	fields[2]   = frmobj.ORDER_SRC_LOCN1 ;
	fields[3]   = frmobj.CURR_DISP_LOC ;
	fields[4]   = frmobj.PERFORM_FCY ;
	fields[5]   = frmobj.day_type ;
	
	names[0]   = getLabel("Common.OrderingFacility.label","Common");   
	names[1]   = getLabel("ePH.OrderingSourceType.label","PH") ;
	names[2]   = getLabel("ePH.OrderingSourceLocationDesc.label","PH");
	names[3]   = getLabel("ePH.CurrentDispenceLocation.label","PH");
	names[4]   = getLabel("Common.PerformingFacility.label","Common"); 
	names[5]   = getLabel("ePH.DayType.label","PH");
	if(frmobj.routing_level.value=="O"||frmobj.routing_level.value=="D"||frmobj.routing_level.value=="L")
	{
		fields[6]   = frmobj.routing_code;
		names[6]   =getLabel("ePH.RoutingLevel.label","PH");
	}	
	else if(frmobj.routing_level.value=="G"||frmobj.routing_level.value=="M")
	{
		fields[6]   = frmobj.drug_desc
		names[6]   =getLabel("ePH.RoutingLevel.label","PH");
	}
	else
	{}
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)){	
	  	  eval( formApply( frmobj,PH_CONTROLLER) ) ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		if( result ){
			   onSuccess();
		    }else{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;}
		}
	
 }
// added by Abdul for Enhancement on 19/08/2008
function loadRoutingLevelRelatedElements(obj){
	var formObj = document.AltDispLocnHeaderForm;
	clearRoutingCode();
	formObj.drug_desc.value = "";
	formObj.drug_code.value = "";
	//added by Surendra 
	if(obj.value=="A"){
		formObj.routing_code.style.display="none";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
	} //end Surendra
	else if (obj.value=="D")
	{
		formObj.routing_code.style.display="inline";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		try{
		formObj.imgRoutingCode.style.visibility="visible";
		}
		catch(e){}
		loadDrugClass("routing_code");
		return false;
	}
	else if(obj.value=="O")
	{
		var ordering_source_type=formObj.ORDER_SRC_TYPE.value;
		formObj.routing_code.style.display="inline";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		try{
		formObj.imgRoutingCode.style.visibility="visible";
		}
		catch(e){}
		var bean_id		= "OrderRoutingBean" ;
		var bean_name	= "ePH.OrderRoutingBean" ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_level="+formObj.routing_level.value+"&facility_id="+formObj.facility_id.value+"&disp_locn_type="+ordering_source_type, false ) ;
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText)
		eval(xmlHttp.responseText);
		return false;
	}
	else if(obj.value=="G")
	{
		formObj.routing_code.style.display="none";
		formObj.drug_desc.style.display="inline";
		formObj.drug_desc.style.visibility="visible";
		formObj.drug_desc.disabled = false;
		formObj.btnDrug.style.display="inline";
		formObj.btnDrug.style.visibility="visible";
		formObj.btnDrug.disabled = false;
		try{
		formObj.imgRoutingCode.style.visibility="visible";
		}
		catch(e){}
		return false;
	}
	else if(obj.value=="M")
	{
		formObj.routing_code.style.display="none";
		formObj.drug_desc.style.display="inline";
		formObj.drug_desc.style.visibility="visible";
		formObj.drug_desc.disabled = false;
		formObj.btnDrug.style.display="inline";
		formObj.btnDrug.style.visibility="visible";
		formObj.btnDrug.disabled = false;
		try{
		formObj.imgRoutingCode.style.visibility="visible";
		}
		catch(e){}
		return false;
	}
	else if(obj.value=="S")
	{
		formObj.RoutingCode.style.display = "none";
		formObj.RoutingCode.style.visibility = "hidden";
		formObj.drug_desc.style.display = "none";
		formObj.btnDrug.style.display="none";
		formObj.drug_desc.value="";
		formObj.drug_code.value="";
		try{
		formObj.imgRoutingCode.style.visibility="hidden";
		}
		catch(e){}
		return false;
	}
	else if(obj.value=="L")
	{
		
		formObj.routing_code.style.display="inline";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		try{
		formObj.imgRoutingCode.style.visibility="visible";
		}
		catch(e){}
		clearRoutingCode();
		loadSpecialOrders("routing_code");
		return false;
	}else if (obj.value=="H"){//added for Bru-HIMS-CRF-093[29960] 
		formObj.RoutingCode.style.display = "none";
		formObj.RoutingCode.style.visibility = "hidden";
		formObj.drug_desc.style.display = "none";
		formObj.btnDrug.style.display="none";
		formObj.drug_code.value="";
		formObj.drug_desc.value="";
		try{
			formObj.imgRoutingCode.style.visibility="hidden";
		}catch(e){}
		return false;
	}

}
async function searchForDrug(target){
	var formObj = document.AltDispLocnHeaderForm;
	if(formObj.routing_level.value=="M"){
//alert(formObj.routing_level.value);
var LANGUAGE_ID=formObj.language_id.value;
var sql="SELECT a.item_code code, a.short_desc description FROM mm_item_lang_vw a, ST_ITEM b WHERE a.item_code = b.item_code  AND b.MEDICAL_ITEM_YN = 'Y'  AND b.DRUG_ITEM_YN = 'N'  AND a.item_code LIKE UPPER(?)  AND Upper(a.short_desc) like upper(?) AND A.LANGUAGE_ID =";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   =sql+ "'"+LANGUAGE_ID+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal =await CommonLookup(getLabel("Common.MedicalItem.label","Common"), argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
		if(retVal != null && retVal != "") {
		formObj.drug_desc.value = arr[1];
		formObj.drug_code.value=arr[0];
		formObj.drug_desc.disabled = true;
		formObj.btnDrug.disabled = true;
		}

	}else{
		var dataArray = await DrugSearch("D",target);
		var data1=unescape(dataArray);
	 	datarr=data1.split(",");
	if (dataArray != "" && dataArray != undefined){
		formObj.drug_code.value = datarr[0];
		formObj.drug_desc.value = datarr[1];
		formObj.drug_desc.disabled = true;
		formObj.btnDrug.disabled = true;
	}	
}
}
function loadSpecialOrders(obj){
	var formObj = document.AltDispLocnHeaderForm;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  "ALLD" ;
	element1.text		=  getLabel("ePH.AllDirectOrders.label","PH");

	var element2 = document.createElement('OPTION') ;
	element2.value		=  "ALLA" ;
	element2.text		=  getLabel("ePH.AllAdmixtures.label","PH");

	var element3 = document.createElement('OPTION') ;
	element3.value		=  "CMPA" ;
	element3.text		=  getLabel("ePH.CompoundingOrder.label","PH");

	var element4 = document.createElement('OPTION') ;
	element4.value		=  "IVOD" ;
	element4.text		=  getLabel("ePH.IVOrderDirect.label","PH");

	var element5 = document.createElement('OPTION') ;
	element5.value		=  "IVOA" ;
	element5.text		=  getLabel("ePH.IVOrderAdmixture.label","PH");

	var element6 = document.createElement('OPTION') ;
	element6.value		=  "ONCD" ;
	element6.text		=  getLabel("ePH.OncologyOrderDirect.label","PH");

	var element7 = document.createElement('OPTION') ;
	element7.value		=  "ONCA" ;
	element7.text		=  getLabel("ePH.OncologyOrderAdmixture.label","PH");

	var element8 = document.createElement('OPTION') ;
	element8.value		=  "TPND" ;
	element8.text		=  getLabel("ePH.TPNStandardRegimen.label","PH");

	var element9 = document.createElement('OPTION') ;
	element9.value		=  "TPNA" ;
	element9.text		=  getLabel("ePH.TPNNONStandardRegimen.label","PH");

	if (obj=="routing_code"){
		formObj.routing_code.add(element1);
		formObj.routing_code.add(element2);
		formObj.routing_code.add(element3);
		formObj.routing_code.add(element4);
		formObj.routing_code.add(element5);
		formObj.routing_code.add(element6);
		formObj.routing_code.add(element7);
		formObj.routing_code.add(element8);
		formObj.routing_code.add(element9);
	}
}
function addDataToRoutingCode(val1,val2,val3){

	var formObj = document.AltDispLocnHeaderForm;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  val1+":"+val2 ;
	element1.text		=  val3 ;
	formObj.routing_code.add(element1);
}
function loadDrugClass(obj){
	var formObj = document.AltDispLocnHeaderForm;
	//if(formObj == undefined)
		//formObj = document.query_form;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  "G" ;
	element1.text		=  getLabel("Common.general.label","Common");

	var element2 = document.createElement('OPTION') ;
	element2.value		=  "N" ;
	element2.text		=  getLabel("ePH.Narcotics.label","PH");

	var element3 = document.createElement('OPTION') ;
	element3.value		=  "C" ;
	element3.text		=  getLabel("ePH.Controlled.label","PH");
	
	if (obj=="routing_code"){
		formObj.routing_code.add(element1);
		formObj.routing_code.add(element2);
		formObj.routing_code.add(element3);
		}
}
function clearRoutingCode(){
	var formObj = document.AltDispLocnHeaderForm;
	//alert(formObj.name);
	var len=formObj.routing_code.length;
	for(var i=0;i<len;i++) {
		formObj.routing_code.remove("routing_code") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.routing_code.add(opt1);
}
function toggleCheckBox(obj,num,stat){
  try{
  if(checkTime(obj,num)){
    var ob=eval("document.AltDisplocnDeatil.select_"+num)
	ob.checked=true;
	ob.value='E';
	if(stat){
      var addrw=eval("document.AltDisplocnDeatil.addRow_"+num)
	  addrw.style.visibility="visible";
	}
  }else{
	 var ob=eval("document.AltDisplocnDeatil.select_"+num)
	 ob.checked=false;
	 ob.value='D';
  	 if(stat){
       var addrw=eval("document.AltDisplocnDeatil.addRow_"+num)
	   addrw.style.visibility="hidden";
	 }
  }
  }catch(e){}
}
function checkTime(obj,num){
    var frmtime=eval("document.AltDisplocnDeatil.frmtime_"+num).value;
	var timefield = obj.value;
	var strHr;
	var strMi;

    if(frmtime==''||timefield=='') return false;

	var strTimeArray = new Array();
  
	strTimeArray = timefield.split(":");
	strHr = strTimeArray[0];
	strMi = strTimeArray[1];

	if(strHr>=24|| strMi>=60) return false
	else if ((frmtime > timefield)) return false
	else return true;
 }

 function generateRow(obj,num,desc,code) {
  var tbl = document.getElementById('AltDspLoc');
  var cnt1=document.AltDisplocnDeatil.count.value;
  var cnt=cnt1;
  for(cal=1;cal<cnt;cal++)
  {
	if(eval("document.AltDisplocnDeatil.select_"+cal)==null)
	 {
		cnt=cal;
	 }
  }
//  alert("cnt"+cnt);
  //  var lastRow = tbl.rows.length;
  // creates a new row
  //alert(checkForNewRow(num));
  var rwid=getSelectedRowId(obj)+1;
  var row = tbl.insertRow(rwid);
  var oCell = row.insertCell(0);
  var classvalue;		  
   
  if (Number(cnt)%2 == 0)
	 classvalue = "QRYEVEN" ;
  else
	 classvalue = "QRYODD" ;

//var d=document.getElementById('div'+num+'1');
//oCell.innerHTML+="<TR>"
oCell.className=classvalue;
oCell.innerHTML="<td width='15%' align='left'>"+desc+"</td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

//d=document.getElementById('div'+num+'2');
//d.innerHTML+="<TR>"
oCell = row.insertCell(1);
oCell.align="center"
oCell.className=classvalue;
oCell.innerHTML="<td  align='center' width='10%'><input type='text'   name=frmtime_"+cnt+"  maxlength='5' size='5' onkeypress='return allowPositiveNumber()' onblur='appedzero(this);validtime(this,totime_"+cnt+");altdisplocnselect(select_"+cnt+","+cnt+")'></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(2);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td align='center' class='"+classvalue+"' width='10%'><input type='text' name=totime_"+cnt+"  id='totime' maxlength='5' size='5' onkeypress='return allowPositiveNumber()' onblur='toggleCheckBox(this,"+cnt+",false);appedzero(this);timecheck(this,"+cnt+");validtime(this,frmtime_"+cnt+");altdisplocnselect(select_"+cnt+","+cnt+");' > </td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(3);
oCell.align="center"
oCell.className=classvalue;
oCell.innerHTML="<td align='center' class='"+classvalue+"' width='2%' ><input type='button' class='button' name=rem_"+cnt+"    onClick='setflag("+cnt+");altdisplocnselect(select_"+cnt+","+cnt+");removeRow(this);' value=' X ' > </td>"
//<input type='button' name='rem' id='rem'    onClick='removeRow("+rwid+")' value='---' >

l_repeat = getMaxCodeRepeat(code); 

oCell = row.insertCell(4);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'4');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td align='center' class='"+classvalue+"' width='6%'><input type='checkbox' name='select_"+cnt+"' id='select_"+cnt+"' onClick='assignValue(this,"+cnt+");clearValue(this,"+cnt+");altdisplocnselect(this,"+cnt+");'> <input type=hidden name='code_"+cnt+"' id='code_"+cnt+"' value='"+code+"' > <input type=hidden name='flag_"+cnt+"' id='flag_"+cnt+"' value='N'> <input type=hidden name='number_"+cnt+"' id='number_"+cnt+"' value=''><input type=hidden name='enable_"+cnt+"' id='enable_"+cnt+"' value='E'> <input type=hidden name='arrVal_"+cnt+"' id='arrVal_"+cnt+"' value='N'>  <input type=hidden name='dbVal_"+cnt+"' id='dbVal_"+cnt+"' value=''><input type=hidden name='repeat_"+cnt+"' id='repeat_"+cnt+"' value='"+(parseInt(l_repeat)+1)+"'></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"
//frmObj=document.AltDisplocnDeatil;
//alert(parseInt(l_repeat)+1);
UpdateCount();

} 
function getMaxCodeRepeat(code)
{
	var maxValue = -1;
	var deleted="0";
	for (i=1;i<document.AltDisplocnDeatil.count.value ;i++ )
	{
		
		if(!(eval("document.AltDisplocnDeatil.repeat_"+i)=="undefined"||eval("document.AltDisplocnDeatil.repeat_"+i)==null))
		{
			
			if ( eval("document.AltDisplocnDeatil.code_"+i+".value") == code && parseInt(eval("document.AltDisplocnDeatil.repeat_"+i+".value"))> parseInt(maxValue))
			{											
						maxValue = eval("document.AltDisplocnDeatil.repeat_"+i+".value");			
			}
			
		}
		else
		{
			deleted="1";
		}
		if(deleted=="1")
			break;
	}
	return maxValue;
}
function UpdateCount(num,opr)
{
	if(opr=="M")
	{
	   document.AltDisplocnDeatil.count.value=Number(document.AltDisplocnDeatil.count.value)-1;
	}
	else
	{
		document.AltDisplocnDeatil.count.value=Number(document.AltDisplocnDeatil.count.value)+1;
	}
   
}
function getSelectedRowId(row)
{
  return  row.parentNode.parentNode.rowIndex
}
function setflag(num)
{
	var fl=eval("document.AltDisplocnDeatil.flag_"+num);
	var ft=eval("document.AltDisplocnDeatil.frmtime_"+num);
	var tt=eval("document.AltDisplocnDeatil.totime_"+num);
	eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.enable_"+num+".value='D'");
	ft.value="";
	tt.value="";
	fl.value="R";

}
function removeRow(obj)
{
   // grab the element again!
    var tbl = document.getElementById('AltDspLoc');
    var n=getSelectedRowId(obj);
	tbl.deleteRow(n);
	UpdateCount(n,'M');
}
function timecheck(obj,objno){
var frmtime=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.frmtime_"+objno).value;
var totime=eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno).value;

if ((frmtime > totime) )
   {
	alert(getMessage("FROM_TIME_GREATER_THAN_TO_TIME","PH"));
	eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno).focus();
	
   }
 }
 function clearValue(obj,objno){

if(obj.checked==false)
	{
eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.frmtime_"+objno+".value=''");
eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.totime_"+objno+".value=''");
eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.enable_"+objno+".value='D'");

try{
eval("parent.alt_disp_locn_detail.AltDisplocnDeatil.addRow_"+objno+".style.visibility='hidden'");
}catch(e){}
	}
}

