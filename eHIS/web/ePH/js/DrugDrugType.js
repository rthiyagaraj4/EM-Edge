  //saved on 07/11/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var global_adr_code = "";

function create(){
	//parent.frames[2].DrugDrugTypeFrameset.rows="42,55,*,55";
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="8vh";
	document.getElementById("f_add_mod_detail").style.height="75vh";
	document.getElementById("messageFrame").style.height="9vh";
	f_query_add_mod.location.href="../../ePH/jsp/DrugDrugTypeHeader.jsp?mode="+MODE_INSERT;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function query(){
	//parent.frames[2].DrugDrugTypeFrameset.rows="42,*,0,55";
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="82vh";
	document.getElementById("f_add_mod_detail").style.height="0vh";
	document.getElementById("messageFrame").style.height="9vh";
	f_query_add_mod.location.href="../../ePH/jsp/DrugDrugTypeQueryCriteria.jsp" ;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function apply(){
	var url=f_add_mod_detail.location.href;
	if(url.indexOf('Detail') == -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
		f_add_mod_detail.document.drugbydrugtypedetailform.mode.value=MODE_INSERT;
		var formarray  =new Array(f_add_mod_detail.document.drugbydrugtypedetailform);
		eval(formApply(formarray,PH_CONTROLLER ));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
		if(result) {
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
	url = f_query_add_mod.location.href;

	if(url.indexOf('blank') != -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
		f_query_add_mod.document.forms[0].reset();
		var form = f_query_add_mod.document.forms[0];
        var elements = form.elements;
        for (var i = 0; i < elements.length; i++) {
            if (elements[i].type === "hidden") {
                elements[i].value = "";
            }
        }
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
		if(url.indexOf('Header')!= -1){
			f_query_add_mod.document.drugbydrugtypeheaderform.drug_desc.disabled = false;
			f_query_add_mod.document.drugbydrugtypeheaderform.drug_search.disabled = false;
		}
		if(url.indexOf('Criteria')!= -1){
			f_query_add_mod.document.query_form.drug_desc.disabled = false;
			f_query_add_mod.document.query_form.drug_search.disabled = false;
			f_query_add_mod.document.query_form.drug_type_desc.disabled = false;
			f_query_add_mod.document.query_form.drug_type_search.disabled = false;
		}
	}
}

function onSuccess() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugDrugTypeHeader.jsp?mode="+MODE_INSERT;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}


async function drugSearch(drugDescObj, drugCodeObj, buttObj)
{
		//alert("drugSearch  1")
		//alert(drugCodeObj.value)

	if(drugCodeObj.value == ""){
		//alert("drugSearch  1.1")
		var retVal= await DrugSearch("D",drugDescObj);	
		
		if(retVal != null && retVal != "" )  {
			var drug_code = retVal[0] ;
			var drug_desc = retVal[1] ;
			//var drug_desc = retVal[3] ;
			//alert("drug_desc--->"+drug_desc)
			drugCodeObj.value = drug_code;
			drugDescObj.value=drug_desc;
			drugDescObj.disabled= true;
			buttObj.disabled=true;
			parent.f_add_mod_detail.location.href='../../ePH/jsp/DrugDrugTypeDetail.jsp?drug_code='+drug_code+"&search=new&from=0&to=19";
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		}
	}
}

async function queryDrugSearch(drugDescObj, drugCodeObj, buttObj){
	//alert("drugSearch  2")
	if(drugCodeObj.value == ""){
		var retVal=await DrugSearch("D",drugDescObj);
		if(retVal != null && retVal != "" )  {
			var drug_code = retVal[0] ;
			var drug_desc = retVal[1] ;
			drugCodeObj.value = drug_code;
			drugDescObj.value=drug_desc;
			drugDescObj.disabled= true;
			buttObj.disabled=true;
			//parent.f_add_mod_detail.location.href='../../ePH/jsp/DrugDrugTypeDetail.jsp?drug_code='+drug_code+"&search=new&from=0&to=19";
			//parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		}
	}
}

async function drugTypeSearch(drugTypeDescObj, drugTupeCodeObj, buttObj){
	//alert("hello")

	var drug_code = document.query_form.drug_code.value;
	//alert(drug_code)
	var sql	=	 document.query_form.sql_select_drug_type.value;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var durg_type = drugTypeDescObj.value;
	if(drugTupeCodeObj.value == ""){
      
	  //alert("drug")

		//argumentArray[0] ="select b.drug_type code, a.drug_type_desc description from ph_drug_type a, ph_drug_drug_type b WHERE b.drug_code LIKE upper(?) AND a.drug_type like Upper(?) and  Upper(a.drug_type_desc) like Upper(?) AND a.drug_type = b.drug_type  ORDER BY description";
		dataNameArray[0]="drug_code";
		dataValueArray[0]=drug_code;
		dataTypeArray[0]=STRING;
       var id  = document.forms[0].locale.value;
	   
		//argumentArray[0]   ="select distinct b.drug_type code, a.drug_type_desc description from ph_drug_type_lang_vw a, ph_drug_drug_type b WHERE  b.drug_code='"+drug_code+"' and a.drug_type like Upper(?) and  Upper(a.drug_type_desc) like Upper(?) AND a.drug_type = b.drug_type AND a.language_id ='"+id+"' ORDER BY description";
		argumentArray[0]   =document.query_form.sql_select_drug_type.value+"'"+id+"' ORDER BY 2";
        argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = drugTypeDescObj.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("ePH.DrugType.label","PH"), argumentArray );
		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
			drugTypeDescObj.value = arr[1] ;
			drugTupeCodeObj.value = arr[0];
			drugTypeDescObj.disabled= true;
			buttObj.disabled=true;
		}
	}
}

function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
}

function drugTypeCheck(obj, drug_type_code){
//	alert("checkvalue-first->"+obj.value)
//	alert(drug_type_code)
	
	if(obj.checked == true)
   obj.value="Y";

	else
		obj.value="N";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugDrugTypeValidate.jsp?drug_type_code="+drug_type_code+"&selected="+ obj.value,false);
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
	xmlHttp.open("POST","DrugDrugTypeValidate.jsp?from="+from+"&to="+to+"&selected="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	for(i=from; i<=to; i++){
		eval("document.drugbydrugtypedetailform.check"+i).value = obj.value;
		eval("document.drugbydrugtypedetailform.check"+i).checked = obj.checked;
	}
}
