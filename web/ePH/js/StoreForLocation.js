
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var global_adr_code = "";

function create(){
		//parent.frames[2].StoreForLocationFrameset.rows="42,128,*,30";
		parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.frames[2].document.getElementById("f_query_add_mod").style.height="23vh";
		parent.frames[2].document.getElementById("f_add_mod_detail").style.height="60vh";
		parent.frames[2].document.getElementById("messageFrame").style.height="9vh";
		f_query_add_mod.location.href="../../ePH/jsp/StoreForLocationHeader.jsp?mode="+MODE_INSERT;
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function query(){
	//parent.frames[2].StoreForLocationFrameset.rows="42,*,0,55";
	parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.frames[2].document.getElementById("f_query_add_mod").style.height="83vh";
		parent.frames[2].document.getElementById("f_add_mod_detail").style.height="0vh";
		parent.frames[2].document.getElementById("messageFrame").style.height="9vh";
	f_query_add_mod.location.href="../../ePH/jsp/StoreForLocationQueryCriteria.jsp" ;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function apply(){
	
	var url=f_add_mod_detail.location.href;
	if(url.indexOf('Detail') == -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
		f_add_mod_detail.document.storeForlocationdetailform.mode.value=MODE_INSERT;
		var formarray  =new Array(f_add_mod_detail.document.storeForlocationdetailform);
		eval(formApply(formarray,PH_CONTROLLER ));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
		if( result ) {
			onSuccess();		
		}
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function reset() {
	//f_query_add_mod.location.reload();
	url = f_query_add_mod.location.href;

	if(url.indexOf('blank') != -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
	
		f_query_add_mod.document.forms[0].reset();
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
		if(url.indexOf('Header')!= -1){

			f_query_add_mod.document.storeforlocationheaderform.dispense_location.disabled = false;
			f_query_add_mod.document.storeforlocationheaderform.dispense_location_search.disabled = false;
			f_query_add_mod.document.storeforlocationheaderform.location_type.disabled = false;
			f_query_add_mod.document.storeforlocationheaderform.search.disabled = false;
	
		}
		if(url.indexOf('Criteria')!= -1){
			f_query_add_mod.document.query_form.dispense_location.disabled = false;
			f_query_add_mod.document.query_form.dispense_location_search.disabled = false;
			f_query_add_mod.document.query_form.location_s.disabled = false;
			//f_query_add_mod.document.query_form.drug_type_search.disabled = false;
		}
	}
}

function onSuccess() {
	f_query_add_mod.location.href="../../ePH/jsp/StoreForLocationHeader.jsp?mode="+MODE_INSERT;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}
async function dispenseLocationSearch(dispense_location){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

var FACILITY_ID=document.storeforlocationheaderform.facility_id.value;
var LANGUAGE_ID=document.storeforlocationheaderform.locale.value;
var sql	="SELECT a.facility_id, a.disp_locn_code code, a.long_desc description , a.store_code, b.long_desc store_desc FROM ph_disp_locn_lang_vw a, mm_store_lang_vw b WHERE a.store_code = b.store_code and a.disp_locn_code LIKE UPPER(?) AND Upper(a.long_desc) like upper(?) AND a.disp_locn_type IN ('N','C') and a.facility_id=";	
 
	argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and a.language_id="+"'"+LANGUAGE_ID+"'"+"and b.language_id="+"'"+LANGUAGE_ID+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = dispense_location.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = await CommonLookup(getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "") {
		document.storeforlocationheaderform.dispense_location.value = arr[0];
		document.storeforlocationheaderform.disp_loc_code.value=arr[0];
		}

StoreSearch(dispense_location)	

}

function StoreSearch(dispense_location)	{
disp_loc_code			= document.storeforlocationheaderform.dispense_location.value;
bean_id		= document.storeforlocationheaderform.bean_id.value ;
bean_name	    = document.storeforlocationheaderform.bean_name.value ;
//alert("code  "+disp_loc_code+" bean_id  "+bean_id  +" bean_name   "+bean_name);   

//var xmlDoc		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//var xmlHttp		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "StoreForLocationValidate.jsp?&validate=STORECODE" + "&disp_loc_code=" + disp_loc_code, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText) ;
}

function assignStoreCode(store_desc)

{
	document.getElementById("store_detail").innerText = store_desc;
		
}


async function queryDispenseSearch(dispense_location){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
var FACILITY_ID=document.query_form.facility_id.value;
var LANGUAGE_ID=document.query_form.locale.value;
var sql	="SELECT a.facility_id, a.disp_locn_code code, a.long_desc description , a.store_code, b.long_desc store_desc FROM ph_disp_locn_lang_vw a, mm_store_lang_vw b WHERE a.store_code = b.store_code and a.disp_locn_code LIKE UPPER(?) AND Upper(a.long_desc) like upper(?) AND a.disp_locn_type IN ('N','C') and a.facility_id=";	
 
	argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and a.language_id="+"'"+LANGUAGE_ID+"'"+"and b.language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = dispense_location.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
retVal = await CommonLookup(getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "") {
		document.query_form.dispense_location.value = arr[0];
		document.query_form.dispense_location_code.value = arr[0];
		
	}
}


function locationsearch(locationobj)
{

var location_value=locationobj.value;
if(query_form.location_type.value=="C")
	{
	var sql="SELECT CLINIC_CODE CODE, SHORT_DESC description FROM OP_CLINIC_LANG_VW WHERE CLINIC_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?)and FACILITY_ID =";
	}else{
var sql="SELECT NURSING_UNIT_CODE  CODE, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW  WHERE NURSING_UNIT_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?)and FACILITY_ID =";
	}

var argumentArray  = new Array() ;
var dataNameArray  = new Array() ; 
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;
var FACILITY_ID=document.query_form.facility_id.value;
var LANGUAGE_ID=document.query_form.locale.value;
	argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = locationobj.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
retVal = CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
		if(retVal != null && retVal != "") {
		document.query_form.location_s.value = retVal[1];
		document.query_form.location_code.value=retVal[0];
	}
}

function popstoreforlocation()
{

var formObj=document.storeforlocationheaderform;	

var fields = new Array ( formObj.dispense_location);
var names = new Array (getLabel("ePH.DispenseLocation.label","PH"));
var messageFrame	=	parent.messageFrame;

if(parent.f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
 {
disableMainForm();
disp_loc_code			= document.storeforlocationheaderform.dispense_location.value;
var location_type=document.storeforlocationheaderform.location_type.value;
parent.f_add_mod_detail.location.href="../../ePH/jsp/StoreForLocationDetail.jsp?disp_loc_code=" + disp_loc_code+"&location_type="+location_type+"&search=new&from=0&to=19";
	return true;
 }
	else
		return false;

}
function disableMainForm()	
	{
	var arrObj =document.storeforlocationheaderform.elements;
    for(var i=0;i<arrObj.length;i++)
           arrObj[i].disabled=true;
    }
function setlocation_s(){

document.query_form.location_type.value=document.query_form.location_type.value;

}

function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
}
function dispTypeCheck(obj, disp_type_code){
	//alert("checkvalue-first->"+obj.value)
	//	alert("disp-->"+disp_type_code);
	if(obj.checked == true)
   obj.value="Y";
	else
		obj.value="N";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","StoreForLocationValidate.jsp?disp_type_code="+disp_type_code+"&validate=X"+"&selected="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
} 

function selectAll(obj, from, to){

	if(obj.checked == true)
		obj.value='Y';
	else
		obj.value='N';

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","StoreForLocationValidate.jsp?from="+from+"&validate=X"+"&to="+to+"&selected="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	for(i=from; i<=to; i++){
		eval("document.storeForlocationdetailform.check"+i).value = obj.value;
		eval("document.storeForlocationdetailform.check"+i).checked = obj.checked;
	}
}
  
    
  
  
 
