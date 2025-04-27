  var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function closewindow(){
	return false;
}

function reset(){
	var from_source=f_query_add_mod_criteria.document.drugitemlink_criteria.from_source.value;	
	f_query_add_mod_criteria.location.href="../../ePH/jsp/DrugItemLinkAddModifyCriteria.jsp?from_source="+from_source;
	f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	f_query_add_mod_legend.location.href="../../eCommon/html/blank.html";
}

function ClearItemCode(){
	var from_source=parent.f_query_add_mod_criteria.document.drugitemlink_criteria.from_source.value;
	parent.f_query_add_mod_criteria.location.href="../../ePH/jsp/DrugItemLinkAddModifyCriteria.jsp?from_source="+from_source;
	parent.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod_legend.location.href="../../eCommon/html/blank.html";
}
function callMatchingRecords(source){ 
	
	parent.parent.drugitemlink.rows="19,80,*,35";

	document.drugitem_tab.missing_record.src='../../ePH/images/Missing Records_click.gif';
	document.drugitem_tab.matching_record.src='../../ePH/images/Matching Records.gif';
	parent.f_query_add_mod_criteria.location.href="../../ePH/jsp/DrugItemLinkAddModifyCriteria.jsp?from_source="+source;
	parent.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod_legend.location.href="../../ePH/jsp/DrugItemLinkLegend.jsp?source=close";
	}
function callMissingRecords(source){ 

	parent.parent.drugitemlink.rows="19,30,*,35";

	document.drugitem_tab.missing_record.src='../../ePH/images/Missing Records.gif';
	document.drugitem_tab.matching_record.src='../../ePH/images/Matching Records_click.gif';
	parent.f_query_add_mod_criteria.location.href="../../ePH/jsp/DrugItemLinkAddModifyCriteria.jsp?from_source="+source;
	parent.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod_legend.location.href="../../ePH/jsp/DrugItemLinkLegend.jsp?source=close";
	
	}

function SearchItemCodeResult(){
	var from_code=document.drugitemlink_criteria.item_code_from_code.value;
	var to_code=document.drugitemlink_criteria.item_code_to_code.value;
	var criteria=document.drugitemlink_criteria.criteria.value;
	var max_rec=document.drugitemlink_criteria.max_rec.value;
	
	
		parent.f_query_add_mod_result.location.href="../../ePH/jsp/DrugItemLinkAddModifyResult.jsp?from_code="+from_code+"&to_code="+to_code+"&criteria="+criteria+"&max_rec="+max_rec;
	parent.f_query_add_mod_legend.location.href="../../ePH/jsp/DrugItemLinkLegend.jsp?source=matchingRecord";
}
function SearchItemCodeResultMR(criteria){
	//var criteria=document.drugitemlink_criteria.criteria.value;
	//alert(criteria);	
	//parent.f_query_add_mod_criteria.document.getElementById("rows")='7%,*,40%';	
	parent.f_query_add_mod_result.location.href="../../ePH/jsp/DrugItemLinkAddModifyResultMR.jsp?criteria="+criteria;
	if(criteria=='BT'){	parent.f_query_add_mod_legend.location.href="../../ePH/jsp/DrugItemLinkLegend.jsp?source=missingRecord";
	}else{
	parent.f_query_add_mod_legend.location.href="../../ePH/jsp/DrugItemLinkLegend.jsp?source=close";
	}
}
function loadPageItem(drug_code){
	alert(getMessage("UNDER_CONSTR_CALL_STOCK_FUNC","PH"));
}
async function loadDrugItemLinkPage(){

var dialogHeight= "34vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "59" ;
	var center = "1" ;
	var status="no";
	var scroll="yes";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DrugItemLinkFrame.jsp",arguments,features);
}
function activeLink(){
	document.drugitemlink_result.next.style.visibility="visible";	
}
function chkLink(){
	var count=parseInt(document.drugitemlink_result.count.value);
	var maxRec=parseInt(document.drugitemlink_result.maxRec.value);
	var displaysize=parseInt(document.drugitemlink_result.displaysize.value);
	
	if(count<maxRec){
		document.drugitemlink_result.next.style.visibility="visible";
	}
	else{
		document.drugitemlink_result.next.style.visibility="hidden";
	}
	//alert(count);

	if(displaysize<count){
		document.drugitemlink_result.prev.style.visibility="visible";
	}else{
		document.drugitemlink_result.prev.style.visibility="hidden";
	}

}

function assignValue(obj){
	document.drugitemlink_result.form_modify.value="changed";
	if(obj.checked)
			obj.value="Y";
		else{
			obj.value="N";
			if(document.drugitemlink_result.head_link.checked==true){
			document.drugitemlink_result.head_link.checked=false;
			chkAllReset(document.drugitemlink_result.head_link);
			}
		}
}
function chkAllReset(obj){
		var start=parseInt(document.drugitemlink_result.start.value);
		var end=parseInt(document.drugitemlink_result.end.value);
		var count=parseInt(document.drugitemlink_result.count.value);
		
		if(count==end){
	
		}else{
		end=count;
		} 
		for(var i=start;i<end;i++){
		var cell_head_link =eval("document.drugitemlink_result.head_link"+i);
	//	alert(cell_head_link.name);
		cell_head_link.value="N";
	//	alert(cell_head_link.value);
		}
}
function chkAll(obj){
	document.drugitemlink_result.form_modify.value="changed";
	if(obj.checked){
		var start=parseInt(document.drugitemlink_result.start.value);
		var end=parseInt(document.drugitemlink_result.end.value);
		var count=parseInt(document.drugitemlink_result.count.value);
		obj.value="Y";
		if(count==end){
	
		}else{
		end=count;
		} 
		for(var i=start;i<end;i++){
		var cell_link =eval("document.drugitemlink_result.link_yn"+i);
		var cell_head_link =eval("document.drugitemlink_result.head_link"+i);
			if(cell_link.disabled==false){
				cell_link.value="Y";
				cell_head_link.value="Y";
				cell_link.checked=true;
			}
		}
	}else{
		var start=parseInt(document.drugitemlink_result.start.value);
		var end=parseInt(document.drugitemlink_result.end.value);
		var count=parseInt(document.drugitemlink_result.count.value);
		obj.value="N";		
		if(count==end){
	
		}else{
		end=count;
		} 
		for(var i=start;i<end;i++){
		var cell_link =eval("document.drugitemlink_result.link_yn"+i);
		var cell_head_link =eval("document.drugitemlink_result.head_link"+i);
			if(cell_link.disabled==false){
				cell_link.value="N";
				cell_head_link.value="N";
				cell_link.checked=false;
			}
			
			}
	
	}
}

function formXMLString(source){
	
	if(source=="apply"){
	var curr_form=parent.f_query_add_mod_result.document.drugitemlink_result.all;
	var count=parseInt(parent.f_query_add_mod_result.document.drugitemlink_result.count.value);
	}else{
		var curr_form=document.drugitemlink_result.all;
		var count=parseInt(document.drugitemlink_result.count.value);
	}

	var start=parseInt(curr_form.start.value);
	var end=parseInt(curr_form.end.value);
	var mode=curr_form.mode.value;
	var bean_id=curr_form.bean_id.value;
	var bean_name=curr_form.bean_name.value;
	var head_link=curr_form.head_link.value;
	
	if(count==end){
	
	}else{
		end=count;
	} 

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "mode=\"" + mode + "\" " ;
	xmlStr+= "bean_id=\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr += "START=\""+ start + "\" ";
	xmlStr += " END=\""+ end + "\" ";
	//alert(start);
	//alert(end);
	

	for(var i=start;i<end;i++){
		if(source=="apply"){
		var cell_link =eval("parent.f_query_add_mod_result.document.drugitemlink_result.link_yn"+i);
		var cell_headlink =eval("parent.f_query_add_mod_result.document.drugitemlink_result.head_link"+i);
		var cell_itemcode=eval("parent.f_query_add_mod_result.document.drugitemlink_result.item_code"+i);
		var cell_itemdesc=eval("parent.f_query_add_mod_result.document.drugitemlink_result.item_desc"+i);
		}else{
		var cell_headlink =eval("document.drugitemlink_result.head_link"+i);
		var cell_link =eval("document.drugitemlink_result.link_yn"+i);
		var cell_itemcode=eval("document.drugitemlink_result.item_code"+i);
		var cell_itemdesc=eval("document.drugitemlink_result.item_desc"+i);
		}
		//if(cell_link.checked==true){
		xmlStr += " LINK_YN"+i+"=\""+ cell_link.value + "\" ";
		xmlStr += " ITEM_CODE"+i+"=\""+ checkSplChar(cell_itemcode.value) + "\" ";
		xmlStr += " HEAD_LINK_YN"+i+"=\""+ cell_headlink.value + "\" ";
		//}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugItemLinkValidation.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
//	alert(responseText);
	return true;

}
function Apply() {
if(parent.f_query_add_mod_result.document.drugitemlink_result.form_modify.value=="changed"){
		var XMLString=formXMLString("apply");	
	var formarray = new Array(parent.f_query_add_mod_result.document.drugitemlink_result);
	//alert(formarray);
	eval(formApply( formarray,PH_CONTROLLER) ) ;
	alert(message);
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

function goNext(){
	if(document.drugitemlink_result.form_modify.value=="changed"){
	var XMLString=formXMLString("next");	
	}
	
	var displaysize=parseInt(document.drugitemlink_result.displaysize.value);
	var start=parseInt(document.drugitemlink_result.start.value);
	var end=parseInt(document.drugitemlink_result.end.value);
	var criteria=document.drugitemlink_result.criteria.value;	parent.f_query_add_mod_result.location.href="../../ePH/jsp/DrugItemLinkAddModifyResult.jsp?dispMode=prev&from="+(start+displaysize)+"&to="+(end+displaysize)+"&criteria="+criteria;
	
}
function goPrev(){
	if(document.drugitemlink_result.form_modify.value=="changed"){
	var XMLString=formXMLString("prev");	
	}
	var displaysize=parseInt(document.drugitemlink_result.displaysize.value);
	var start=parseInt(document.drugitemlink_result.start.value);
	var end=parseInt(document.drugitemlink_result.end.value);
	var criteria=document.drugitemlink_result.criteria.value;
	parent.f_query_add_mod_result.location.href="../../ePH/jsp/DrugItemLinkAddModifyResult.jsp?dispMode=prev&from="+(start-displaysize)+"&to="+(end-displaysize)+"&criteria="+criteria;;
}
function goNextMR(){
	var displaysize=parseInt(document.drugitemlink_result.displaysize.value);
	var start=parseInt(document.drugitemlink_result.start.value);
	var end=parseInt(document.drugitemlink_result.end.value);
	var criteria=document.drugitemlink_result.criteria.value;
	parent.f_query_add_mod_result.location.href="../../ePH/jsp/DrugItemLinkAddModifyResultMR.jsp?criteria="+criteria+"&dispMode=prev&from="+(start+displaysize)+"&to="+(end+displaysize);
	
}

function goPrevMR(){
	var displaysize=parseInt(document.drugitemlink_result.displaysize.value);
	var start=parseInt(document.drugitemlink_result.start.value);
	var end=parseInt(document.drugitemlink_result.end.value);
	var criteria=document.drugitemlink_result.criteria.value;
	parent.f_query_add_mod_result.location.href="../../ePH/jsp/DrugItemLinkAddModifyResultMR.jsp?criteria="+criteria+"&dispMode=prev&from="+(start-displaysize)+"&to="+(end-displaysize);
}


function searchItemCodeTo(){


}

function searchItemCode(source){
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var sql_1="SELECT   st.item_code code, 	 mm.short_desc description    FROM   mm_item_lang_vw  mm,    st_item  st 	WHERE    st.item_code = mm.item_code  and 	mm.eff_status =	'E'	     AND  st.drug_item_yn='Y'  AND    mm.language_id LIKE  ?      AND	    st .item_code   LIKE   UPPER(?)    AND upper(mm.short_desc)	 LIKE   upper(?)   order by 2";
	
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.forms[0].SQL_PH_DRUG_ITEM_LINK_SELECT1.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	if(source=="from")
	argumentArray[5] = document.drugitemlink_criteria.item_code_from_code.value;
	else
	argumentArray[5]   = document.drugitemlink_criteria.item_code_to_code.value ;

	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	
	/*var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0]="language_id"
	dataValueArray[0]="en"
	dataTypeArray[0]=STRING;
	var sql_1="SELECT A.ITEM_CODE code,B.SHORT_DESC description FROM ST_ITEM A,  MM_ITEM_LANG_VW B WHERE A.ITEM_CODE=B.ITEM_CODE AND B.LANGUAGE_ID = ? AND UPPER(A.ITEM_CODE) LIKE UPPER(?) AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND A.DRUG_ITEM_YN='Y'";
	dataNameArray[0]="language_id"
	dataValueArray[0]=document.drugitemlink_criteria.language_id.value;
	dataTypeArray[0]=STRING;
	
	argumentArray[0]   = sql_1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	if(source=="from")
	argumentArray[5]   = document.drugitemlink_criteria.item_code_from_code.value ;
	else
	argumentArray[5]   = document.drugitemlink_criteria.item_code_to_code.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ; 
	retVal = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );*/

	if(retVal != null && retVal != "" )  {
		if(source=="from"){
		document.drugitemlink_criteria.item_code_from_desc.value=retVal[1];
		document.drugitemlink_criteria.item_code_from_code.value=retVal[0];
		document.drugitemlink_criteria.item_code_from_desc.disabled=true;
		document.drugitemlink_criteria.search_from.disabled=true;
		document.drugitemlink_criteria.search_matching.style.visibility="visible";
		}
		else{
		document.drugitemlink_criteria.item_code_to_desc.value=retVal[1];
		document.drugitemlink_criteria.item_code_to_code.value=retVal[0];
		document.drugitemlink_criteria.item_code_to_desc.disabled=true;
		document.drugitemlink_criteria.search_to.disabled=true;
		}
	}else{
		if(source=="from"){
		document.drugitemlink_criteria.item_code_from_desc.disabled=true;
		document.drugitemlink_criteria.search_from.disabled=true;
		}else{
		document.drugitemlink_criteria.item_code_to_desc.disabled=true;
		document.drugitemlink_criteria.search_to.disabled=true;
		}
	
	
	}

}

function onSuccess(){
	var from_source=parent.f_query_add_mod_criteria.document.drugitemlink_criteria.from_source.value;
	parent.f_query_add_mod_criteria.location.href="../../ePH/jsp/DrugItemLinkAddModifyCriteria.jsp?from_source="+from_source;
	parent.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod_legend.location.href="../../ePH/jsp/DrugItemLinkLegend.jsp?source=close";
	//if(from_source=="matching_record") callMatchingRecords(from_source);
	//if(from_source=="missing_record") callMissingRecords(from_source);
	
	}
