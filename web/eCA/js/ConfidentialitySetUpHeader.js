/* 
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
21/12/2013	  IN45870		Karthi L	 Unable to uncheck the selected records. There is no option to Uncheck the records selected wrongly.
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

var radioval = 'D';
function reset()
{
		document.location.reload();
}
function storeVal(currad) {
    radioval=currad.value
}
function apply()
{
	var formObj = CAConfidentialitySetUpHeaderFrame;
	var event_type_visibility = formObj.document.getElementById("event_type_data").style.visibility;
	var filter_base_visibility = formObj.document.getElementById("filter_based_data").style.visibility;
	fields = new Array (formObj.hist_rec_type); 
	names = new Array( getLabel("Common.HistoryType.label",'Common')); 
	if(event_type_visibility == "visible") {
		fields = new Array (formObj.hist_rec_type, formObj.eventType); 
		names = new Array( getLabel("Common.HistoryType.label",'Common'),getLabel("Common.EventType.label",'Common')); 
		if(filter_base_visibility == "visible") {
			fields = new Array (formObj.hist_rec_type, formObj.eventType, formObj.filter_based_on); 
			names = new Array( getLabel("Common.HistoryType.label",'Common'),getLabel("Common.EventType.label",'Common'),getLabel("eCA.filterbasedon.label",'CA')); 
		}
	}
	if(checkFieldsofMst(fields,names,messageFrame))
	{
		var fields1;
		var names1;
		var filterBasedOn = formObj.filter_based_on.value;
		var filter_when_button_click =  formObj.filter_when_click.value;
		
		if(filterBasedOn == 'E'){
			fields1 = new Array (formObj.event_codes);
			names1 = new Array( getLabel("Common.Event.label",'Common'));
		}
		else {
			fields1 = new Array (formObj.priv_resp_code);
			if(filterBasedOn == 'P'){
				names1 = new Array( getLabel("Common.practitioner.label",'Common'));
			} else if(filterBasedOn == 'S') {
				names1 = new Array( getLabel("Common.Specialty.label",'Common'));
			} else if(filterBasedOn == 'R') {
				names1 = new Array( getLabel("Common.responsibility.label",'Common'));
			}
		}
		
		
		if(checkFieldsofMst(fields1,names1,messageFrame)) {
			var selectedRecord = CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.selectedDataCount.value;
			var filter_based_indicator = formObj.filter_based_indicator.value;
			
			if(	selectedRecord == 0 || selectedRecord == '') {
				var msg = getMessage("CA_ONE_ORDERABLE","CA");
				if(filter_based_indicator != '') {
					if(filter_based_indicator == 'P') {
						msg = msg +  " " + getLabel("Common.practitioner.label",'Common');
					} else if(filter_based_indicator == 'S') {
						msg = msg + " " + getLabel("Common.Specialty.label",'Common');
					} else if(filter_based_indicator == 'R') {
						msg = msg +  " " + getLabel("Common.responsibility.label",'Common');
					}
					formObj.filter_based_indicator.value = '';
				}	
				else 
				{
					msg = msg + " " +  getLabel("Common.Event.label",'Common');
					formObj.filter_based_indicator.value = '';
				}	
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
				return false;
			}	
			else
			{
				formObj.confidentiality_setup_header.action="../../servlet/eCA.CAConfidentialitySetUpServlet";
				formObj.confidentiality_setup_header.target="messageFrame";
				formObj.confidentiality_setup_header.method="post";
				formObj.confidentiality_setup_header.submit();
			}
		}
	}
	
}

function onSuccess()
{	
	top.content.CAConfidentialitySetUpHeaderFrame.location.href='../../eCA/jsp/CAConfidentialitySetupHeader.jsp';
	var passurl = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
	var passurl1 = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	//document.location.reload();	     	
}

function contrsystempop2()
{	 
	var passurl = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
	var passurl1 = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	
	var passMessageFrameurl = '../../eCommon/jsp/MstCodeError.jsp';
	top.content.messageFrame.location.href = passMessageFrameurl ;
	
	
	//var tp = getLabel("Common.defaultSelect.label","Common"); 
	//var element = "------------"+tp+"------------" ;
	//parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.selected = element;
	document.getElementById("filter_based_on").selectedIndex  = 0;
	
		
	var length =parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.length;	
			
	for(i=1;i<length;i++)
	{
	  parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.remove(1);
	}
	var obj= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	
	/*
   	if (obj=='CLNT')
	{
		var Option = document.createElement("OPTION");
			Option.text="CA";
			Option.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "CA";
	}
   	else if(obj == 'BLTF') {
		
		var Option = document.createElement("OPTION");
			Option.text="BT";
			Option.value="BT_BLOOD_PRODUCT";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "BT";
   	}
	else if(obj == 'FDOC') {
			
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
	}else if(obj == 'PTCR') {
			
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
	}else if(obj == 'TRET') {
			
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
		
	}else if(obj == 'LBIN') {
			
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
		var Option2 = document.createElement("OPTION");
			Option2.text="LB";
			Option2.value="RL_TEST_CODE";
			document.forms[0].eventType.add(Option2);
			document.forms[0].event_type_code.value = "LB";
			
	}else if(obj == 'BLTF') {
		var Option = document.createElement("OPTION");
			Option.text="BT";
			Option.value="BT_BLOOD_PRODUCT";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "BT";
	}else if(obj == 'RDIN') {
			
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
		var Option2 = document.createElement("OPTION");
			Option2.text="RD";
			Option2.value="RD_EXAMINATION";
			document.forms[0].eventType.add(Option2);
			document.forms[0].event_type_code.value = "RD";
	}
	else if(obj == 'SUNT') {
			
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
		var Option2 = document.createElement("OPTION");
			Option2.text="OT";
			Option2.value="OT_OPER_MAST";
			document.forms[0].eventType.add(Option2);
			document.forms[0].event_type_code.value = "OT";
	}
	else if(obj == 'RXIN') {
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
	}
	else if(obj == 'NCIN') {
		var Option = document.createElement("OPTION");
			Option.text="OR";
			Option.value="AM_DISCR_MSR";
			document.forms[0].eventType.add(Option);
			document.forms[0].event_type_code.value = "OR";
		var Option1 = document.createElement("OPTION");
			Option1.text="CA";
			Option1.value="CA_NOTE_TYPE";
			document.forms[0].eventType.add(Option1);
			document.forms[0].event_type_code.value = "CA";
	} */
	var hist_type = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Ca_confidentialitySetUpBean\" ";
	xmlStr += " bean_name=\"eCA.CAConfidentialitySetUpBean\" ";
	xmlStr += " p_action=\"LOAD_CONT_SYS_CODE\"";
	xmlStr += " p_hist_type=\""+hist_type+ "\" ";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "CAConfidentialitySetUpIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
   	
}
function addContSysCodes(code, value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text =  code;	
	eval("document.forms.confidentiality_setup_header.eventType.add(element)");	
}
function clearContSysCodes(){
	eval("document.forms.confidentiality_setup_header.eventType.length=0");
	var tp = getLabel("Common.defaultSelect.label","Common");
	var element = document.createElement('OPTION') ;
	element.value = "" ;
	element.text = "----------"+tp+"----------" ;	
	eval("document.forms.confidentiality_setup_header.eventType.add(element)");	
}
function enableFilterBasedOn(){
	var obj= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;
	if(  obj == null || obj.length == 0){
		disableWhenHTChange();
		contrsystempop2();
		document.getElementById("filter_based_label").style.visibility = 'hidden';
		document.getElementById("filter_based_data").style.visibility = 'hidden';
	} else if( obj != null || obj != "" ){
		document.getElementById("filter_based_label").style.visibility = 'visible';
		document.getElementById("filter_based_data").style.visibility = 'visible';
		
		
		var length =parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.length;	
			
		for(i=1;i<length;i++)
		{
			parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.remove(1);
		}
		var Option = document.createElement("OPTION");
			Option.text=getLabel("Common.Event.label","Common");
			Option.value="E" ;
			document.forms[0].filter_based_on.add(Option);
			document.forms[0].filter_based_on.value = "E";	
		var Option3 = document.createElement("OPTION");
			Option3.text=getLabel("Common.practitioner.label","Common");
			Option3.value="P" ;
			document.forms[0].filter_based_on.add(Option3);
			document.forms[0].filter_based_on.value = "P";
			
		var Option1 = document.createElement("OPTION");
			Option1.text=getLabel("Common.responsibility.label","Common");
			Option1.value="R" ;
			document.forms[0].filter_based_on.add(Option1);
			document.forms[0].filter_based_on.value = "R";	
		var Option2 = document.createElement("OPTION");
			Option2.text=getLabel("Common.Specialty.label","Common");
			Option2.value="S" ;
			document.forms[0].filter_based_on.add(Option2);
			document.forms[0].filter_based_on.value = "S";		
		
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.selectedIndex = 0;
		
		document.getElementById("event_data").style.display = 'none';
		document.getElementById("privilege_buttons").style.display = 'none';
		document.getElementById("viewlistlabel").style.display = 'none'; 
		document.getElementById("view_list_code").style.display = 'none';
		document.getElementById("privilege_responsibility").style.display = 'none';
		document.getElementById("priv_text_box").style.display = 'none'; 
		document.getElementById("title_type").style.display = 'none';
		
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.selectedIndex = 0;
		
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
		
		//getDisplayMode();
	}
	
}
// Reset all fields when change History type field
function disableWhenHTChange() { 
	var obj= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	if( obj == null || obj == "" ){
		document.getElementById("event_type_label").style.visibility = 'hidden';
		document.getElementById("event_type_data").style.visibility = 'hidden';
		document.getElementById("filter_based_label").style.visibility = 'hidden';
		document.getElementById("filter_based_data").style.visibility = 'hidden';
	}
	else if( obj != null || obj != "" ){
		document.getElementById("event_type_label").style.visibility = 'visible';
		document.getElementById("event_type_data").style.visibility = 'visible';
		document.getElementById("filter_based_label").style.visibility = 'hidden';
		document.getElementById("filter_based_data").style.visibility = 'hidden';
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.selected = 0;
	}
	document.getElementById("event_data").style.display = 'none';
	document.getElementById("privilege_buttons").style.display = 'none';
	document.getElementById("viewlistlabel").style.display = 'none'; 
	document.getElementById("view_list_code").style.display = 'none';
	document.getElementById("privilege_responsibility").style.display = 'none';
	document.getElementById("priv_text_box").style.display = 'none'; 
	document.getElementById("title_type").style.display = 'none';
	
	document.getElementById("basedonlabel").style.display = 'none'; 
	document.getElementById("based_on_code").style.display = 'none';
	document.getElementById("viewbylabel").style.display = 'none'; 
	document.getElementById("view_by_code").style.display = 'none';

	//parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.length = 0;
	//parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.length = 0;
	//parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.length = 0;
	parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.event_codes.value = '';
	/*var tp = getLabel("Common.defaultSelect.label","Common");
	var element = document.createElement('OPTION') ;
	element.value = "" ;
	element.text = "----------"+tp+"----------" ;	
	//eval("document.forms.confidentiality_setup_header.event_codes.add(element)");	 */
}
function getDisplayMode(){
	var filter_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.value;
	document.forms[0].priv_resp_desc.value = '';
	document.forms[0].priv_resp_code.value = '';
	document.forms[0].event_desc.value = '';
	document.forms[0].event_codes.value = '';
	if(filter_code == "E"){
		document.getElementById("event_data").style='display';
		//document.getElementById("privilege_buttons").style.display = 'inline';
		document.getElementById("privilege_responsibility").style.display = 'none';
		//getEventCodes();
		//var passurl = '../../eCA/jsp/blank.jsp';
		//top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		//var passurl1 = '../../eCA/jsp/blank.jsp';
		//top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}
	else if(filter_code == "P"){
		document.getElementById("event_data").style.display = 'none';
		document.getElementById("privilege_buttons").style.display = 'none';
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		document.getElementById("privilege_responsibility").style='display';
		document.getElementById("priv_text_box").style='display'; 
		document.getElementById("title_type").style='display';
		document.getElementById("title_type").innerHTML = "";
		document.getElementById("title_type").innerHTML = getLabel("Common.practitioner.label","common_labels");
		document.getElementById("viewlistlabel").style='display'; 
		document.getElementById("view_list_code").style='display';
		enablePrivilegeLookup('E');
		//searchClick('E');
	}
	else if(filter_code == "S"){
		document.getElementById("event_data").style.display = 'none';
		document.getElementById("privilege_buttons").style.display = 'none';
		document.getElementById("viewlistlabel").style.display = 'none'; 
		document.getElementById("view_list_code").style.display = 'none';
		document.getElementById("privilege_responsibility").style='display';
		document.getElementById("priv_text_box").style='display'; 
		document.getElementById("title_type").style='display';
		document.getElementById("title_type").innerHTML = "";
		document.getElementById("title_type").innerHTML = getLabel("Common.Specialty.label","common_labels");
		document.getElementById("basedonlabel").style='display'; 
		document.getElementById("based_on_code").style='display';
		document.getElementById("viewbylabel").style='display'; 
		document.getElementById("view_by_code").style='display';
		enablePrivilegeLookup('E');
		//searchClick('E');
	}
	else if(filter_code == "R"){
		document.getElementById("event_data").style.display = 'none';
		document.getElementById("privilege_buttons").style.display = 'none';
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		document.getElementById("privilege_responsibility").style='display';
		document.getElementById("priv_text_box").style='display'; 
		document.getElementById("title_type").style='display';
		document.getElementById("title_type").innerHTML = "";
		document.getElementById("title_type").innerHTML = getLabel("Common.responsibility.label","common_labels");
		document.getElementById("viewlistlabel").style='display'; 
		document.getElementById("view_list_code").style='display';
		enablePrivilegeLookup('E');
		//searchClick('E');
	}
	else if(filter_code == "") {
		//disableWhenHTChange();
		
		document.getElementById("event_data").style.display = 'none';
		document.getElementById("privilege_buttons").style.display = 'none';
		document.getElementById("viewlistlabel").style.display = 'none'; 
		document.getElementById("view_list_code").style.display = 'none';
		document.getElementById("privilege_responsibility").style.display = 'none';
		document.getElementById("priv_text_box").style.display = 'none'; 
		document.getElementById("title_type").style.display = 'none';
		
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}
	parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.selectedIndex = 0;
	parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.selectedIndex = 0;
	parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.selectedIndex = 0;
	emptyEventMapData();
}
function dispPrivButtons() {
	var l_event_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.event_codes.value;
	
	if(l_event_code.length!=0) {
		document.getElementById("privilege_buttons").style='display';
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}	
	else if(l_event_code.length ==0) {	
		document.getElementById("privilege_buttons").style.display = 'none';
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}

}

function populateValueOnBlur(target,code)
{
	if(target.value !='')
	{
		populateValue(target,code)
	}
	else if(target.value =='')
	{
		document.forms[0].priv_resp_code.value = '';
		document.getElementById("viewlistlabel").style.display = 'none'; 
		document.getElementById("view_list_code").style.display = 'none';
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.selectedIndex = 0;
		emptyEventMapData();
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}
}
async function populateValue(target,code)
{	
	var filter_based_on  = document.forms[0].filter_based_on.value;
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= "";
	var sql = "";
	
	if(filter_based_on == "R")
	{
		 sql="Select resp_id code, resp_name description from sm_resp where eff_status='E' and upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by resp_name";
		 title =getLabel("Common.responsibility.label","Common");
	}
	else if (filter_based_on == "P")
	{
		
		 sql="Select PRACTITIONER_ID code, PRACTITIONER_NAME description from AM_PRACTITIONER where eff_status='E' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) order by 2";
		
 		 title =getLabel("Common.practitioner.label","Common");
	}
	else if (filter_based_on == "S")
	{
		
		 sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
 		 title =getLabel("Common.speciality.label","Common");
	}
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = await CommonLookup( title, argArray );
	var str =unescape(retArray);
	var arr = str.split(",");

	if(retArray != null && retArray !="")
	{
		document.forms[0].priv_resp_desc.value = arr[1]; 
		document.forms[0].priv_resp_code.value = arr[0];
		enablePrivilegeLookup('E');
	}
	else
	{
		document.forms[0].priv_resp_desc.value = '';
		document.forms[0].priv_resp_code.value = '';
		enablePrivilegeLookup('E');
		//searchClick(filter_based_on);
	}
	emptyEventMapData();
}
function reLoadSearchResultFrame(code) {
	var filter_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.value; 
	if(filter_code == 'E') {
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_when_click.value = code;
		CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.event_codes.value;
	} else {
		CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.priv_resp_code.value;
	}
	
	emptyEventMapData();
	var passurl = '../jsp/CAConfidentialitySearchCriteria.jsp?searchCode='+code;
	top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
	var passurl1 = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
}
function enablePrivilegeLookup(code){
	var l_priv_resp_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.priv_resp_code.value;
	
	if(l_priv_resp_code.length!=0) {
		var filter_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.value; 
		
		var CONFDNT_ID = "";
		
		if(filter_code == "P" || filter_code == "R"){
		
			document.getElementById("basedonlabel").style.display = 'none'; 
			document.getElementById("based_on_code").style.display = 'none';
			document.getElementById("viewbylabel").style.display = 'none'; 
			document.getElementById("view_by_code").style.display = 'none';
			document.getElementById("viewlistlabel").style='display'; 
			document.getElementById("view_list_code").style='display';
		}
		else if(filter_code == "S"){
			document.getElementById("viewlistlabel").style.display = 'none'; 
			document.getElementById("view_list_code").style.display = 'none';
			document.getElementById("basedonlabel").style='display'; 
			document.getElementById("based_on_code").style='display';
			document.getElementById("viewbylabel").style='display'; 
			document.getElementById("view_by_code").style='display';
		}
	
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.selectedIndex = 0;
		
		
		if(filter_code == 'E') {
			parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_when_click.value = code;
			CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.event_codes.value;
		} else {
			CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.priv_resp_code.value;
		}
		var histRecType = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
		var	eventType   = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;
		
		var passurl = '../jsp/CAConfidentialitySearchCriteria.jsp?searchCode='+code;
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}
	else if(l_priv_resp_code.length ==0) {
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		document.getElementById("viewlistlabel").style.display = 'none'; 
		document.getElementById("view_list_code").style.display = 'none';
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.selectedIndex = 0;
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}
		
}
function searchClick(code) {
	var filter_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.value; 
	parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_indicator.value = code;
	var CONFDNT_ID = "";
	if(filter_code == 'E') {
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_when_click.value = code;
		CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.event_codes.value;
	} else {
		CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.priv_resp_code.value;
	}
	var histRecType = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	var	eventType   = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;
	emptyEventMapData();
	var passurl = '../jsp/CAConfidentialitySearchCriteria.jsp?searchCode='+code;
	top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
	var passurl1 = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	
}
function populateEventCodeOnBlur(target, code) {
	if(target.value !='')
	{
		populateEventCodeValue(target,code)
	}
	else if(target.value =='')
	{
		document.forms[0].priv_resp_code.value = '';
		document.getElementById("viewlistlabel").style.display = 'none'; 
		document.getElementById("view_list_code").style.display = 'none';
		document.getElementById("basedonlabel").style.display = 'none'; 
		document.getElementById("based_on_code").style.display = 'none';
		document.getElementById("viewbylabel").style.display = 'none'; 
		document.getElementById("view_by_code").style.display = 'none';
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.selectedIndex = 0;
		parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.selectedIndex = 0;
		emptyEventMapData();
		var passurl = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
		var passurl1 = '../../eCA/jsp/blank.jsp';
		top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
	}

}
async function populateEventCodeValue(target, code) {
	
	//var filter_based_on  = document.forms[0].filter_based_on.value;
	
	var histRecType 					= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	var locale 							= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.locale.value;
	var l_event_type					= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;
	
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= ""; 
	title =getLabel("Common.Event.label","Common");
	var sql = "SELECT DISTINCT EVENT_CODE code, SHORT_DESC description FROM CA_EVENT_CONFDNT_HIST_REC_VW WHERE HIST_REC_TYPE = '"+histRecType+"'  AND EVENT_CODE_TYPE ='"+l_event_type+"' AND LANGUAGE_ID = '"+locale+"' AND UPPER(EVENT_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 2";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = await CommonLookup( title, argArray );
	var str =unescape(retArray);
	var arr = str.split(",");

	if(retArray != null && retArray !="")
	{
		document.forms[0].event_desc.value = arr[1]; 
		document.forms[0].event_codes.value = arr[0];
		//enablePrivilegeLookup('E');
	}
	else
	{
		document.forms[0].event_desc.value = '';
		document.forms[0].event_codes.value = '';
		//enablePrivilegeLookup('E');
		//searchClick(filter_based_on);
	}
	dispPrivButtons();
	emptyEventMapData();
	
}
function callRespLookup(target,code) {
	var search_code = "";
	var search_desc	= "";
	var title			= "";
	var sql = "";
	var histRecType 					= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	var locale 							= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.locale.value;
	var l_search_by 					= parent.CAConfidentialitySearchQueryFrame.CriteriaForm.search_criteria.value;
	var l_search_txt 					= parent.CAConfidentialitySearchQueryFrame.CriteriaForm.search_text.value;
	var l_filter 						= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.value;
	var l_event_type					= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;
	
	//var searchby = parent.CAConfidentialitySearchQueryFrame.CriteriaForm.search_by.value.value;
	locale = "'" +locale +"'";
	/* if(radioval = "D")
	{
		if(target.value != "") {
			search_desc = target.value;
		}
		else {
			search_desc = "(%)";
		}
		 
	}
	if(radioval = "C")
	{
		if(target.value != "") {
			search_code = target.value;
		}
		else {
			search_code = "(%)";
		}
		 
	}
	*/
	if(code == "R")
	{
		 sql="Select resp_id code, resp_name description from sm_resp where eff_status='E' and upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by resp_name";
		 title =getLabel("Common.responsibility.label","Common");
	}
	else if (code == "P")
	{
		sql="Select PRACTITIONER_ID code, PRACTITIONER_NAME description from AM_PRACTITIONER where eff_status='E' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) order by 2";
		title =getLabel("Common.practitioner.label","Common");
	}
	else if (code == "S")
	{
		
		 sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
 		 title =getLabel("Common.speciality.label","Common");
	}
	else
	{
		sql = " SELECT DISTINCT EVENT_CODE code, SHORT_DESC description FROM CA_EVENT_CONFDNT_HIST_REC_VW WHERE HIST_REC_TYPE = '"+histRecType+"'  AND EVENT_CODE_TYPE ='"+l_event_type+"' AND LANGUAGE_ID = "+locale+" AND UPPER(EVENT_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 2 ";
		/*if(histRecType == "PTCR"){
			sql = "SELECT  distinct b.discr_msr_id code, b.short_desc description FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D' AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'PC' AND order_catalog_nature = 'A' AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') and language_id ="  +locale+ "and upper(b.discr_msr_id) like upper(?) and upper(b.short_desc) like upper(?) order by 2 ";
		}
		else if(histRecType == "TRET"){
			sql = "SELECT distinct b.discr_msr_id code, b.short_desc description  FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D' AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'TR' AND order_catalog_nature = 'A' AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND language_id =" +locale+ "and upper(b.discr_msr_id) like upper(?) and upper(b.short_desc) like upper(?) order by 2 ";
		}
		else if(histRecType == "RDIN"){
			sql = "SELECT a.contr_msr_panel_id code, a.short_desc description FROM or_order_catalog_lang_vw a WHERE order_category = 'RD' AND order_catalog_nature = 'A' AND contr_msr_panel_id IS NOT NULL AND language_id = " +locale+ "and upper(a.contr_msr_panel_id) like upper(?) and upper(a.short_desc) like upper(?) order by 2";
		}
		else if(histRecType == "LBIN"){
			sql = "SELECT distinct b.discr_msr_id code, b.short_desc description  FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D' AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'LB' AND order_catalog_nature = 'A' AND contr_msr_panel_id IS NULL AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND language_id = "+locale+ " and upper(b.discr_msr_id) like upper(?) and upper(b.short_desc) like upper(?) UNION SELECT a.contr_msr_panel_id code , a.short_desc description FROM or_order_catalog_lang_vw a WHERE order_category = 'LB' AND order_catalog_nature = 'A' AND contr_msr_panel_id IS NOT NULL AND contr_mod_id = 'RL' AND language_id = "+locale+ "and upper(a.contr_msr_panel_id) like upper(?) and upper(a.short_desc) like upper(?) order by 2";
		}
		else if(histRecType == "BLTF"){
			sql = "SELECT distinct a.contr_msr_panel_id code, a.short_desc description FROM or_order_catalog_lang_vw a WHERE order_category = 'LB' AND order_catalog_nature = 'A' AND contr_msr_panel_id IS NOT NULL AND contr_mod_id = 'BT' AND language_id = "+locale+" and upper(a.contr_msr_panel_id) like upper(?) and upper(a.short_desc) like upper(?) order by 2";
		}
		else if(histRecType == "CLNT"){
			sql = "SELECT A.NOTE_TYPE code,a. NOTE_TYPE_DESC description from CA_NOTE_TYPE A WHERE A.NOTE_GROUP_ID IN ( SELECT B.NOTE_GROUP FROM CA_NOTE_GROUP B WHERE B.APPL_TASK_ID='CLINICAL_NOTES') AND A.EFF_STATUS='E' AND  upper(a.NOTE_TYPE) like upper(?) and upper(a.NOTE_TYPE_DESC) like upper(?) order by 2";
		}
		else if(histRecType == "NCIN"){
			sql = "SELECT  distinct b.discr_msr_id code, b.short_desc description FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D'      AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'NC' AND order_catalog_nature IN ('A', 'P') AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID="+locale+ " and upper(b.discr_msr_id) like upper(?) and upper(b.short_desc) like upper(?) order by 2";
		}
		else if(histRecType == "RXIN"){
			sql = "SELECT distinct b.discr_msr_id code, b.short_desc description FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D' AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'RX' AND order_catalog_nature IN ('A', 'P') AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID= "+locale+ " and upper(b.discr_msr_id) like upper(?) and upper(b.short_desc) like upper(?) order by 2" ;
		}
		else if(histRecType == "SUNT"){
			sql = "SELECT a.contr_msr_panel_id code, a.short_desc description FROM or_order_catalog_lang_vw a WHERE order_category = 'OT' AND order_catalog_nature = 'A'  AND contr_msr_panel_id IS NOT NULL AND contr_mod_id = 'OT' AND LANGUAGE_ID="+locale+" and upper(a.contr_msr_panel_id) like upper(?) and upper(a.short_desc) like upper(?) order by 2";
		}
		*/
	}
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	loadExistingPrivilegeCodes(code);
	//var passurl = '../jsp/CAConfidentialitySearchResult.jsp?p_search_value='+target.value+'&search_code='+code+'&radioval='+radioval+'&p_hist_rec_type='+histRecType+'&p_search_by='+l_search_by;
	var passurl = '../jsp/CAConfidentialitySearchResult.jsp?'+formQueryString(argArray,0)+'&search_code='+code+'&radioval='+radioval+'&p_hist_rec_type='+histRecType+'&p_search_by='+l_search_by+'&p_search_txt='+l_search_txt+'&p_filter_='+l_filter;
	//var passurl = '../jsp/CAConfidentialitySearchResult.jsp?'+formQueryString(argArray,0)+'&search_code='+code+'&radioval='+radioval;
	top.content.CAConfidentialitySearchResultFrame.location.href = passurl ;
}
/*
 *  Load existing transaction table data 
 * 
 */
function loadExistingPrivilegeCodes(code){
	
	var search_code = code;
	var filter_code = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.filter_based_on.value; 
	var CONFDNT_ID = "";
	if(filter_code == 'E') {
		CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.event_codes.value;
	} else {
		CONFDNT_ID = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.priv_resp_code.value;
	}
	var hist_type = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	var	event_type   = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;  
	
	var l_filter_based_on_header_code 	= filter_code;
	var l_view_by_header_code 			= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_by_code.value
	var l_view_list_header_code 		= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.view_list_code.value
	var l_based_on_code 				= parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.based_on_code.value
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Ca_confidentialitySetUpBean\" ";
	xmlStr += " bean_name=\"eCA.CAConfidentialitySetUpBean\" ";
	xmlStr += " p_action=\"LOAD_EXIST_PRIVILEGE_DATA\"";
	xmlStr += " p_hist_type=\""+hist_type+ "\" ";
	xmlStr += " p_event_type=\""+event_type+ "\" ";
	xmlStr += " p_confdnt_id=\""+CONFDNT_ID+ "\" ";
	xmlStr += " p_search_code=\""+search_code+ "\" ";
	xmlStr += " p_header_filter_based_on=\""+l_filter_based_on_header_code+ "\" ";
	xmlStr += " p_view_by_data=\""+l_view_by_header_code+ "\" ";
	xmlStr += " p_view_list_data=\""+l_view_list_header_code+ "\" ";
	xmlStr += " p_based_on_data=\""+l_based_on_code+ "\" ";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "CAConfidentialitySetUpIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
/* 
function getEventCodes(){
	var hist_type = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.hist_rec_type.value;
	var event_type = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.eventType.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Ca_confidentialitySetUpBean\" ";
	xmlStr += " bean_name=\"eCA.CAConfidentialitySetUpBean\" ";
	xmlStr += " p_action=\"LOAD_EVENT_DATA\"";
	xmlStr += " p_hist_type=\""+hist_type+ "\" ";
	xmlStr += " p_event_type=\""+event_type+ "\" ";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "CAConfidentialitySetUpIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function addEventCodes(code, value){
	var element = document.createElement('OPTION') ;
	element.value =  value ;
	element.text = code ;	
	//eval("document.forms.confidentiality_setup_header.event_codes.add(element)");	
}
function clearEventCodes(){
	eval("document.forms.confidentiality_setup_header.event_codes.length=0");
	var tp = getLabel("Common.defaultSelect.label","Common");
	var element = document.createElement('OPTION') ;
	element.value = "" ;
	element.text = "----------"+tp+"----------" ;	
	//eval("document.forms.confidentiality_setup_header.event_codes.add(element)");	
}
*/
function emptyEventMapData() {
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Ca_confidentialitySetUpBean\" ";
	xmlStr += " bean_name=\"eCA.CAConfidentialitySetUpBean\" ";
	xmlStr += " p_action=\"EMPTY_MAP_DATA\"";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "CAConfidentialitySetUpIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function chk_spl_char()
{
	var text_val=document.forms[0].search_text.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
	  document.forms[0].search_text.value="";
	      parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
	}
}
function changeSelectedData(obj,rowCount){
	ctrlChkBox(obj,rowCount);
}
function resetQueryForm(code){
	emptyEventMapData();
	var passurl = '../jsp/CAConfidentialitySearchCriteria.jsp?searchCode='+code;
	top.content.CAConfidentialitySearchQueryFrame.location.href = passurl ;
	var passurl1 = '../../eCA/jsp/blank.jsp';
	top.content.CAConfidentialitySearchResultFrame.location.href = passurl1 ;
}
function ctrlChkBox(obj,rowCount){
	
	var result_data_code = eval("parent.CAConfidentialitySearchResultFrame.confidentiality_search_result.result_data_code_"+rowCount).value;
	var view_by_data = '';
	var based_on_data = '';
	var view_list_data = '';
	
	//var ctnChkBox = eval("parent.CAConfidentialitySearchResultFrame.confidentiality_search_result.ctrlChkBox"+rowCount) ;
	
	//var result_data_code =document.getElementById("result_data_code_"+rowCount).value; 
	var confidnt_type = parent.CAConfidentialitySearchResultFrame.confidentiality_search_result.confidnt_type.value;
	var ctnChkBox =   document.getElementById("ctrlChkBox"+rowCount).checked; 
	
	if(ctnChkBox == true){
		ctnChkBox = 'Y';
	}
	else {
		ctnChkBox = 'N';
	}
	if(confidnt_type == 'P' || confidnt_type == 'R' ){
		var e = document.getElementById("view_list_data_"+rowCount);
		view_list_data = e.options[e.selectedIndex].value;
	}
	else if(confidnt_type == 'S') {
		var e = document.getElementById("view_by_data_"+rowCount);
		view_by_data = e.options[e.selectedIndex].value;
		
		var e = document.getElementById("based_on_data_"+rowCount);
		based_on_data = e.options[e.selectedIndex].value;
	}
	if(confidnt_type == undefined){
		confidnt_type = 'E';
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Ca_confidentialitySetUpBean\" ";
	xmlStr += " bean_name=\"eCA.CAConfidentialitySetUpBean\" ";
	xmlStr += " p_action=\"SET_EVENT_DATA\"";
	xmlStr += " p_ctnChkBox = \""+ctnChkBox+ "\" ";
	xmlStr += " p_confidnt_type = \""+confidnt_type+ "\" ";    
	xmlStr += " p_result_data_code=\""+result_data_code+ "\" ";
	if(confidnt_type == 'P' || confidnt_type == 'R') {
		xmlStr += " p_view_list_data = \""+view_list_data+ "\" ";
	}
	if(confidnt_type == 'S') {
		xmlStr += " p_view_by_data = \""+view_by_data+ "\" ";
		xmlStr += " p_based_on_data = \""+based_on_data+ "\" ";
	}
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "CAConfidentialitySetUpIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);	
	var selectedRecord = parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.selectedDataCount.value;
}
function selectedRecordCounts(count){
	parent.CAConfidentialitySetUpHeaderFrame.confidentiality_setup_header.selectedDataCount.value = count;
}
function SubmitLink(from, to) {
	parent.CAConfidentialitySearchResultFrame.confidentiality_search_result.from.value = from;
	parent.CAConfidentialitySearchResultFrame.confidentiality_search_result.to.value = to;
	parent.CAConfidentialitySearchResultFrame.confidentiality_search_result.submit() ;
}

/*
*  
*
*/
