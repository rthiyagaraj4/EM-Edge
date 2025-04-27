var ordercolmns="1";
var count=1;
var radioval="IC";

function CloseWindow()
{																					
	//parent.window.close();
	parent.document.getElementById("dialog_tag").close();
	
}
function storeVal(currad)
{
	radioval=currad
}

function reset() {
	f_query_add_mod.location.reload();
}

function searchVals(){
	objform=parent.qryCriteria.ItemMasterCriteria_Form;
	search_string=objform.search_string.value;
	var			item_code		="" ;
	var 		short_desc		="";
	var 		alpha_code		="";
	var 		item_remarks	="";
	var 		trade_name		="";
	var 		trade_id		="";
	var 		flag			=objform.flag.value;
	//alert("flag in searchvals="+flag);
	
	
	var re=/%/g;
	search_string=search_string.replace(re," ");
	if (search_string!='' || search_string != null ) {
		search = true;}
	else
		{
		search = false;
		}	
		
	if (search_string!="" && search_string!=null)
	{

			
			if (objform.search_criteria.value=="S") {
				search_string=search_string+"%"
			}
			else if (objform.search_criteria.value=="C") {
				search_string="%"+search_string+"%";
			}
			else{
				search_string="%"+search_string;
			}

			search_string=encodeURIComponent(search_string);
		//	alert(search_string);

			if(radioval=="IC" )
				item_code=search_string;
			else if(radioval=="IN")
				short_desc=search_string;
			else if(radioval=="AC")
				alpha_code=search_string;
			else if(radioval=="IR")
				item_remarks=search_string;
			else if(radioval=="TC")
				trade_id=search_string;
			else if(radioval=="TN")
				trade_name=search_string;
		//	alert(radioval);
	}
	else{
				item_code	="" ;
				short_desc  ="";
				alpha_code	="";
				item_remarks	="";
				trade_id	="";
				trade_name  =""; 
				pur_uom_code  =""; 
				//return;
	}

	
	item_class=objform.item_class.value;
	item_analysis_1=objform.item_analysis_1.value;
	item_analysis_2=objform.item_analysis_2.value;
	item_analysis_3=objform.item_analysis_3.value;
	//alert(search);
	var temp_jsp="../../eMM/jsp/ItemMasterValidate.jsp?function_type=1&category="+objform.category.value+"&searchby="+radioval+"&sole_source="+objform.sole_source.value+"&item_code="+item_code+"&short_desc="+short_desc+"&item_class="+objform.item_class.value+"&alpha_code="+alpha_code+"&item_remarks="+item_remarks+"&trade_id="+trade_id+"&trade_name="+trade_name+"&trade_name="+trade_name+"&search="+search+"&ps_item="+objform.ps_item.value+"&eff_status="+objform.enabled_Yn.value+"&spl_item="+objform.spl_item.value+"&item_analysis_1="+objform.item_analysis_1.value+"&manufacturer="+objform.manufacturer.value+"&item_analysis_2="+objform.item_analysis_2.value+"&search_criteria="+objform.search_criteria.value+"&item_analysis_3="+objform.item_analysis_3.value+"&search_string="+objform.search_string.value;

	var xmlStr ="<root><SEARCH /></root>";
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
//	alert(responseText);
	//alert("before");
	parent.qryResult.document.location.href="../../eMM/jsp/ItemMasterQueryResult.jsp?radioval="+radioval+"&flag="+flag;
}

	function changeRadVal(){
		if(radioval="IC" ){
			radioval="IN" ;
			searchVals(); 
		}
		else{
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.location.href="../../eCommon/html/blank.html";
		}
	}


function activeLink() {

	if(parent.qryResult.ItemMasterCriteriaForm!=null) {
	formObjCriteria=parent.qryCriteria.ItemMasterCriteria_Form;
	formObjResult=parent.qryResult.ItemMasterCriteriaForm;
	if(formObjResult.start.value != 0 )
			parent.qryCriteria.ItemMasterCriteria_Form.previous.disabled=false;
			
	else
			parent.qryCriteria.ItemMasterCriteria_Form.previous.disabled=true;
	

	if(  !((parseInt(formObjResult.start.value) +parseInt(formObjResult.displaySize.value))>= formObjResult.totalRecords.value ))
		parent.qryCriteria.ItemMasterCriteria_Form.next.disabled=false;
	else
		parent.qryCriteria.ItemMasterCriteria_Form.next.disabled=true;
	}
}

function goNext() {
	formObj=parent.qryResult.ItemMasterCriteriaForm;

	start = parseInt( formObj.start.value) +parseInt( formObj.displaySize.value ) ;
	end = parseInt( formObj.end.value )+ parseInt(formObj.displaySize.value ) ;
	flag = formObj.flag.value;

	parent.qryResult.location.href="../../eMM/jsp/ItemMasterQueryResult.jsp?from="+start+"&to="+end+"&flag="+flag;
}	

function goPrev() {
	formObj=parent.qryResult.ItemMasterCriteriaForm;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;
	
	flag = formObj.flag.value;

	parent.qryResult.location.href="../../eMM/jsp/ItemMasterQueryResult.jsp?from="+start+"&to="+end+"&flag="+flag;
}	

function returnVals( item_code,short_desc)
	{
//	 alert(item_code+"+"+short_desc);
	var  returnvals=item_code+"@"+short_desc;
	window.parent.parent.returnValue=returnvals.split("@");
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnvals;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
	
	//parent.window.close();
}
