//This file is saved on 25/10/2005.
var function_id	= "PH_HME_MEDN_SHEET" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;
var maxRec = 0  ;
var displaySize = 0 ;
var currClass="";
var error_str="";// Added to avoid script error on QueryMode Apply event

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/HomeMedicationSheetTypeFrames.jsp?mode=MODE_INSERT";
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/HomeMedicationSheetTypeQueryCriteria.jsp?mode=MODE_QUERY";//Added for RUT-CRF-0061[IN46714]
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function reset() {//Modified for RUT-SCF-0358[IN46714]
	if(f_query_add_mod.queryResultForm!=undefined || f_query_add_mod.med_query_form!=undefined)
		query();
	else if(f_query_add_mod.f_dtl_criteria !=undefined)
		create();
}


/* This apply function is called from the top frame button */
function apply() {
	if(f_query_add_mod.med_query_form==undefined){//Added for RUT-CRF-0061[IN46714]
	var select_option	=	f_query_add_mod.f_select_criteria.document.HomeMednSheetTypeForm.home_medn_sheet_type.value;
	var table = f_query_add_mod.f_dtl_criteria.document.HomeMednSheetDtlForm.hmemednsheetdtl;
	var uncheck_data  = new Array() ;
	var selected_data  = new Array() ;
	var i=0;
	var j=0;
	if(f_query_add_mod.f_dtl_criteria.document.HomeMednSheetDtlForm.p_mode.value=="insert"){
		for (var r = 1, n = table.rows.length; r < n; r++) {
			for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
				if(table.rows[r].cells[2].innerHTML.indexOf("CHECKED")!=-1){
					selected_data[i]=table.rows[r].cells[0].innerHTML;
					i++;
					break;
				}
			}
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"HomeMednSheetBean\" " ; 
		xmlStr+= " bean_name=\"ePH.HomeMednSheetBean\" " ;
		xmlStr += " select_option=\""+select_option+"\"";
		xmlStr += " selected_Array=\""+selected_data+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HomeMedicationSheetTypeValidate.jsp?identity=InsertMode",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		var response=eval(responseText);
		if(response=="Success"){
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_INSERTED","PH");
			f_query_add_mod.location.href="../../ePH/jsp/HomeMedicationSheetTypeFrames.jsp?mode=MODE_INSERT";
		}else
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+response;
		response="";
	}
	else if(f_query_add_mod.f_dtl_criteria.document.HomeMednSheetDtlForm.p_mode.value=="modify"){
		for (var r = 1, n = table.rows.length; r < n; r++) {
			for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
				if(table.rows[r].cells[2].innerHTML.indexOf("CHECKED")==-1){
					uncheck_data[i]=table.rows[r].cells[0].innerHTML;
					i++;
					break;
				}else{
					selected_data[j]=table.rows[r].cells[0].innerHTML;
					j++;
					break;
				}
			}
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"HomeMednSheetBean\" " ; 
		xmlStr+= " bean_name=\"ePH.HomeMednSheetBean\" " ;
		xmlStr += " select_option=\""+select_option+"\"";
		xmlStr += " uncheck_data=\""+uncheck_data+"\"";
		xmlStr += " selected_Array=\""+selected_data+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HomeMedicationSheetTypeValidate.jsp?identity=ModifyMode",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		var response=eval(responseText);
		if(response=="Success"){
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_MODIFIED","PH");
			f_query_add_mod.location.href="../../ePH/jsp/HomeMedicationSheetTypeFrames.jsp?mode=MODE_INSERT";
		}else
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+response;
		
		response="";
	}else{//Added for RUT-CRF-0061[IN46200]
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
  }else{//Added for RUT-CRF-0061[IN46714]	
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}


function showResult(){}
//Modified for RUT-SCF-0358[IN46714] - Start
function Onchangehmemedntype(obj){
	var option = obj.value;
	if(option=="I" || option=="S" || option=="O"){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"HomeMednSheetBean\" " ; 
		xmlStr+= " bean_name=\"ePH.HomeMednSheetBean\" " ;
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HomeMedicationSheetTypeValidate.jsp?identity=Onchange_tab",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		document.getElementById("tblTab").style.display="inline";
		document.getElementById("select_col").className="clicked";
		document.getElementById("association_col").className="normal";
		parent.parent.f_query_add_mod.f_dtl_criteria.location.href="../../ePH/jsp/HomeMedicationSheetTypeDtl.jsp?tabValue=S&medn_type="+option;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
	else{
		document.getElementById("tblTab").style.display="none";
		parent.parent.f_query_add_mod.f_dtl_criteria.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}
	
function tabData(obj,tabValue){
	var select_option	=	document.HomeMednSheetTypeForm.home_medn_sheet_type.value;
	if(select_option!="" && tabValue=="S"){
		document.getElementById("select").className="HIGHER_LEVEL_LINK";
		document.getElementById("select_col").className="clicked";
		document.getElementById("association").className="SUB_LEVEL_LINK";
		document.getElementById("association_col").className="normal";
		parent.parent.f_query_add_mod.f_dtl_criteria.location.href="../../ePH/jsp/HomeMedicationSheetTypeDtl.jsp?tabValue="+tabValue+"&medn_type="+select_option+"&tabEvent=S";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
	else if(select_option!="" && tabValue=="A"){
		document.getElementById("select").className="SUB_LEVEL_LINK";
		document.getElementById("select_col").className="normal";
		document.getElementById("association").className="HIGHER_LEVEL_LINK";
		document.getElementById("association_col").className="clicked";
		parent.parent.f_query_add_mod.f_dtl_criteria.location.href="../../ePH/jsp/HomeMedicationSheetTypeDtl.jsp?tabValue="+tabValue+"&medn_type="+select_option+"&tabEvent=A";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}

function errorData(medn_type){
	if(medn_type!=undefined && medn_type!="")
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH");
}
	
function SubmitLink(from,to){
	var obj				=	document.HomeMednSheetDtlForm;
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.submit();
}

function fetchHmeMedTypeRecord(){//Added for RUT-CRF-0061 [IN:45785]
	var table = document.HomeMednSheetDtlForm.hmemednsheetdtl;
	var uncheck_data  = new Array() ;
	var selected_data  = new Array() ;
	var check_associate_data  = new Array() ;
	var uncheck_associate_data  = new Array() ;
	var i=0;
	var j=0;
	if(document.HomeMednSheetDtlForm.p_mode.value=="insert"){
		for (var r = 1, n = table.rows.length; r < n; r++) {
			for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
				if(table.rows[r].cells[2].innerHTML.indexOf("CHECKED")!=-1){
					selected_data[i]=table.rows[r].cells[0].innerHTML;
					check_associate_data[i]=table.rows[r].cells[0].innerHTML+"/"+table.rows[r].cells[1].innerHTML+"/E";
					i++;
					break;
				}else if(table.rows[r].cells[2].innerHTML.indexOf("CHECKED")==-1){
					uncheck_data[j]=table.rows[r].cells[0].innerHTML;
					uncheck_associate_data[j]=table.rows[r].cells[0].innerHTML+"/"+table.rows[r].cells[1].innerHTML+"/E";
					j++;
					break;
				}
			}
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"HomeMednSheetBean\" " ; 
		xmlStr+= " bean_name=\"ePH.HomeMednSheetBean\" " ;
		xmlStr += " selected_Array=\""+selected_data+"\"";
		xmlStr += " uncheck_data=\""+uncheck_data+"\"";
		xmlStr += " check_associate_data=\""+check_associate_data+"\"";
		xmlStr += " uncheck_associate_data=\""+uncheck_associate_data+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HomeMedicationSheetTypeValidate.jsp?identity=Store_select",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
	}
	else if(document.HomeMednSheetDtlForm.p_mode.value=="modify"){
		for (var r = 1, n = table.rows.length; r < n; r++) {
			for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
				if(table.rows[r].cells[2].innerHTML.indexOf("CHECKED")==-1){
					uncheck_data[i]=table.rows[r].cells[0].innerHTML;
					i++;
					break;
				}else{
					selected_data[j]=table.rows[r].cells[0].innerHTML;
					j++;
					break;
				}
			}
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"HomeMednSheetBean\" " ; 
		xmlStr+= " bean_name=\"ePH.HomeMednSheetBean\" " ;
		xmlStr += " uncheck_data=\""+uncheck_data+"\"";
		xmlStr += " selected_Array=\""+selected_data+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HomeMedicationSheetTypeValidate.jsp?identity=Store_associate",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
	}
}
function execQuery(){
	if(document.getElementById("orderbycolumns").options.length >0 ){
		SelectAll(); 
		document.med_query_form.submit();
	}
	else{
		alert(getMessage('ORDERBY_NOT_BLANK',"Common"))
	}
}

function SelectAll(){
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex=0; 
	while ( i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected=true;
		i++; 
	}
}

function removeOrderByCol(){
	var j=0;
	var from = document.getElementById("item")('orderbycolumns');
	if ( from.options.length > 0 ){ 
		var to = document.getElementById("item")('orderbycols');
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value = from.options[from.selectedIndex].value;
			to.add(element);    from.remove(from.selectedIndex);
			if(from.options[j]) 
				from.options[j].selected=true; 
			j++;
		}
	}
}  
function addOrderByCol(){  
	var i=0;
	var from = document.getElementById("item")('orderbycols'); 
	if ( from.options.length > 0 ) {
		var to = document.getElementById("item")('orderbycolumns'); 
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value= from.options[from.selectedIndex].value; 
			to.add(element);      
			from.remove(from.selectedIndex);
			if(from.options[i])
				from.options[i].selected=true ;
			i++;
		}
	} 
}//Modified for RUT-SCF-0358[IN46714] - End
