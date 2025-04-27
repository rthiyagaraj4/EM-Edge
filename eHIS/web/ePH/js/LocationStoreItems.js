
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var global_adr_code = "";

function create(){    
	//alert("qqqqq");
	//console.log(parent.frames[2].LocationStoreItemsHeader);
		//parent.frames[2].LocationStoreItemsHeader.rows="42,130,'*',30";
		f_query_add_mod.location.href="../../ePH/jsp/LocationStoreItemsHeader.jsp?mode="+MODE_INSERT;
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function query(){
	//parent.frames[2].LocationStoreItemsHeader.rows="42,*,0,55";
	parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.frames[2].document.getElementById("f_query_add_mod").style.height="80vh";
	parent.frames[2].document.getElementById("f_add_mod_detail").style.height="0vh";
	parent.frames[2].document.getElementById("messageFrame").style.height="10vh";
	f_query_add_mod.location.href="../../ePH/jsp/LocationStoreItemsQueryCriteria.jsp" ;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function apply(){
	
	
	var url=f_add_mod_detail.location.href;
	if(url.indexOf('Detail') == -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
		
		f_add_mod_detail.document.locationfordetailform.mode.value=MODE_INSERT;
		var formarray  =new Array(f_add_mod_detail.document.locationfordetailform);
	
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
//	f_query_add_mod.location.reload();
	url = f_query_add_mod.location.href;

	if(url.indexOf('blank') != -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
	
		f_query_add_mod.document.forms[0].reset();
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
		if(url.indexOf('Header')!= -1){

			f_query_add_mod.document.locationforstoreheaderform.dispense_location.disabled = false;
			f_query_add_mod.document.locationforstoreheaderform.dispense_location_search.disabled = false;
			f_query_add_mod.document.locationforstoreheaderform.item_type.disabled = false;
			f_query_add_mod.document.locationforstoreheaderform.search.disabled = false;
			f_query_add_mod.document.locationforstoreheaderform.item_search_string.disabled = false;
			f_query_add_mod.document.locationforstoreheaderform.item_search.disabled = false;
		}
		if(url.indexOf('Criteria')!= -1){
			f_query_add_mod.document.query_form.dispense_location.disabled = false;
			f_query_add_mod.document.query_form.dispense_location_search.disabled = false;
			f_query_add_mod.document.query_form.item_type.disabled = false;
			f_query_add_mod.document.query_form.item_search.disabled = false;
			f_query_add_mod.document.query_form.item_lookup.disabled = false;
		}
	}
}

function onSuccess() {
	f_query_add_mod.location.href="../../ePH/jsp/LocationStoreItemsHeader.jsp?mode="+MODE_INSERT;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}
async function dispenseLocationSearch(dispense_location){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

var FACILITY_ID=document.locationforstoreheaderform.facility_id.value;
var LANGUAGE_ID=document.locationforstoreheaderform.locale.value;
var sql	="SELECT a.facility_id, a.disp_locn_code code, a.long_desc description , a.store_code, b.long_desc store_desc FROM ph_disp_locn_lang_vw a, mm_store_lang_vw b WHERE a.store_code = b.store_code and a.disp_locn_code LIKE UPPER(?) AND Upper(a.long_desc) like upper(?) AND a.disp_locn_type IN ('N','C') and a.facility_id=";	
 
	argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and a.language_id="+"'"+LANGUAGE_ID+"'"+"and b.language_id="+"'"+LANGUAGE_ID+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = dispense_location.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal =await CommonLookup(getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
		if(retVal != null && retVal != "") {
		document.locationforstoreheaderform.dispense_location.value = arr[0];
	//	document.locationforstoreheaderform.disp_loc_code.value=retVal[0];
		document.locationforstoreheaderform.store_code.value=arr[0];
		}

StoreSearch(dispense_location)	

}

function StoreSearch(dispense_location)	{
disp_loc_code			= document.locationforstoreheaderform.dispense_location.value;
bean_id		= document.locationforstoreheaderform.bean_id.value ;
bean_name	    = document.locationforstoreheaderform.bean_name.value ;
//alert("code  "+disp_loc_code+" bean_id  "+bean_id  +" bean_name   "+bean_name);   

//var xmlDoc		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//var xmlHttp		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "LocationStoreItemsValidate.jsp?&validate=STORECODE" + "&disp_loc_code=" + disp_loc_code, false ) ;
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
		retVal =await CommonLookup(getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
		document.query_form.dispense_location.value = arr[0];
		document.query_form.dispense_location_code.value = arr[0];
		document.query_form.store_code.value=arr[0];
	}
}
function poplocationforstoreitems()
{


var formObj=document.locationforstoreheaderform;	

var fields = new Array ( formObj.dispense_location,formObj.item_search);
var names = new Array (getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.ItemSearchString.label","PH"));
var messageFrame	=	parent.messageFrame;

if(parent.f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
 {
disableMainForm();
var disp_loc_code			= document.locationforstoreheaderform.dispense_location.value;
var item_search_code=document.locationforstoreheaderform.item_search_code.value;
var item_search=document.locationforstoreheaderform.item_search.value;
var item_type=document.locationforstoreheaderform.item_type.value;
parent.f_add_mod_detail.location.href="../../ePH/jsp/LocationStoreItemsDetail.jsp?disp_loc_code="+ disp_loc_code+"&item_type="+item_type+"&item_search_code="+item_search_code+"&item_search="+encodeURIComponent(item_search)+"&search=new&from=0&to=19";
	return true;
 }
	else
	return false;

}
function disableMainForm()	
	{
	var arrObj =document.locationforstoreheaderform.elements;
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
	xmlHttp.open("POST","LocationStoreItemsValidate.jsp?disp_type_code="+disp_type_code+"&validate=X"+"&selected="+ obj.value,false);
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
	xmlHttp.open("POST","LocationStoreItemsValidate.jsp?from="+from+"&validate=X"+"&to="+to+"&selected="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	for(i=from; i<=to; i++){
		eval("document.locationfordetailform.check"+i).value = obj.value;
		eval("document.locationfordetailform.check"+i).checked = obj.checked;
	}
}

async function  itemLocationSearch()
 {
var item_type=document.locationforstoreheaderform.item_type.value;
var store_code=document.locationforstoreheaderform.store_code.value;
var sql="";
var LANGUAGE_ID=document.locationforstoreheaderform.locale.value;

//alert("item_type-->"+item_type+"store_code===>"+store_code+"LANGUAGE_ID--->"+LANGUAGE_ID);
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ; 
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

if(item_type=="M")
 {
sql="SELECT a.item_code code, c.short_desc description FROM st_item_store a, st_item b, mm_item_lang_vw c  WHERE  b.item_code = a.item_code AND c.item_code = a.item_code AND b.medical_item_yn = 'Y' AND b.DRUG_ITEM_YN = 'N' AND a.item_code LIKE UPPER(?) AND Upper(c.short_desc) like upper(?) and a.store_code =";
argumentArray[0]   =sql+"'"+store_code+"'"+" and c.language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";
 }else{
sql="SELECT a.item_code code, b.drug_desc description FROM st_item_store a, ph_drug_lang_vw b WHERE b.item_code = a.item_code and a.item_code LIKE UPPER(?) AND Upper(b.drug_desc) like upper(?) AND a.store_code =";
argumentArray[0]   =sql+"'"+store_code+"'"+" and b.language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";

	 }

	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] =document.locationforstoreheaderform.item_search.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal =await CommonLookup(getLabel("ePH.ItemSearchString.label","PH"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
		document.locationforstoreheaderform.item_search.value = arr[1];
		document.locationforstoreheaderform.item_search_code.value=arr[0];
	}

 }
    
async function quitemsearch ()
{

var item_type=document.query_form.item_type.value;
var store_code=document.query_form.store_code.value;
var sql="";
var LANGUAGE_ID=document.query_form.locale.value;

//alert("item_type-->"+item_type+"store_code===>"+store_code+"LANGUAGE_ID--->"+LANGUAGE_ID);
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ; 
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

if(item_type=="M")
 {
sql="SELECT a.item_code code, a.short_desc description FROM mm_item_lang_vw a, ST_ITEM b WHERE a.item_code = b.item_code  AND b.MEDICAL_ITEM_YN = 'Y'  AND b.DRUG_ITEM_YN = 'N'  AND a.item_code LIKE UPPER(?)  AND Upper(a.short_desc) like upper(?) AND A.LANGUAGE_ID =";

//sql="SELECT a.item_code code, c.short_desc description FROM st_item_store a, st_item b, mm_item_lang_vw c  WHERE  b.item_code = a.item_code AND c.item_code = a.item_code AND b.medical_item_yn = 'Y' AND b.DRUG_ITEM_YN = 'N' AND a.item_code LIKE UPPER(?) AND Upper(c.short_desc) like upper(?) and a.store_code =";
argumentArray[0]   =sql+"'"+LANGUAGE_ID+"'"+"order by 2";
 }else{
sql="SELECT a.item_code code, a.drug_desc description FROM ph_drug_lang_vw A WHERE a.item_code LIKE UPPER(?) AND UPPER(a.drug_desc) LIKE UPPER(?)and a.language_id ="; 
//sql="SELECT a.item_code code, b.drug_desc description FROM st_item_store a, ph_drug_lang_vw b WHERE b.item_code = a.item_code and a.item_code LIKE UPPER(?) AND Upper(b.drug_desc) like upper(?) AND a.store_code =";
argumentArray[0]   =sql+"'"+LANGUAGE_ID+"'"+"order by 2";

	 }

	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] =document.query_form.item_search.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
//retVal = CommonLookup("Item Search String", argumentArray );
	retVal =await CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
		if(retVal != null && retVal != "") {
		document.query_form.item_search.value = arr[1];
		document.query_form.item_search_code.value=arr[0];
	}




}
function qchange(){
document.query_form.item_type.value = document.query_form.item_type.value;
}
 
