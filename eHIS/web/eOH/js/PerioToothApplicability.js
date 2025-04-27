
function create()
{ // alert("create")
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var params=document.forms[0].params.value;
	f_query_add_mod.location.href='../../eOH/jsp/PerioToothApplicabilityFrame.jsp?'+params;
}

function query()
{		//alert("query")

	var cmf=commontoolbarFrame.document.forms[0];
	var params=document.forms[0].params.value;
    if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    }
	f_query_add_mod.location.href='../../eOH/jsp/PerioToothApplQueryCriteria.jsp?params='+params;
}

function reset(){
		//alert("reset")

	if(f_query_add_mod.document.location.href.indexOf("PerioToothApplicabilityFrame.jsp") != -1){
		var params=document.forms[0].params.value;
		var chart_code=parent.content.f_query_add_mod.PerioToothApplicabilityHeader.document.forms[0].chart.value; 
		parent.content.f_query_add_mod.PerioToothApplicabilityHeader.location.href='../../eOH/jsp/PerioToothApplicabilityHeader.jsp?params='+params;
		parent.content.f_query_add_mod.PerioToothApplicabilityDetails.location.href='../../eCommon/html/blank.html?params='+params;
		parent.content.f_query_add_mod.PerioToothApplicabilityFooter.location.href='../../eCommon/html/blank.html?params='+params;

	}
}

function apply(){
	var frm=f_query_add_mod.document.forms[0];
	commontoolbarFrame.location.reload();
}

function clearvalues(){
	//alert("clearvalues")
	document.forms[0].reset();
	var messageFrame=parent.parent.messageFrame;
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function clear_list(obj){
  while(obj.options.length > 0){
   obj.remove(obj.options[0]);
 }
}

function  showRecords(){
	//alert("showRecords")
	var params=document.forms[0].params.value;
	var chart_code=parent.PerioToothApplicabilityHeader.document.forms[0].chart.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	parent.PerioToothApplicabilityDetails.location.href='../../eOH/jsp/PerioToothApplicabilityDetails.jsp?params='+params+"&chart_code="+chart_code+"&oh_chart_level="+oh_chart_level;
	parent.PerioToothApplicabilityFooter.location.href='../../eOH/jsp/PerioToothApplicabilityFooter.jsp?params='+params+"&chart_code="+chart_code+"&oh_chart_level="+oh_chart_level;
	var messageFrame=parent.parent.messageFrame;
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function insertRecords(){  
	//alert("insertRecords")
	var formObj=parent.PerioToothApplicabilityFooter.document.forms[0]; //PerioToothApplicabilityFooter
	var frmObj =parent.PerioToothApplicabilityHeader.document.forms[0]; //PerioToothApplicabilityHeader
	var tooth_numbering_system=parent.PerioToothApplicabilityDetails.document.forms[0].tooth_numbering_system.value; 
	var params=parent.PerioToothApplicabilityHeader.document.forms[0].params.value; //PerioToothApplicabilityHeader
	var messageFrame=parent.parent.messageFrame;
	var component_code=document.forms[0].component_code.value;
	var tooth_no=document.forms[0].tooth_no.value;
	var chart_code=frmObj.chart.value;
	var required_yn=formObj.required_yn.value;

	formObj.chart_code.value = chart_code;

	var component_title=getLabel("Common.Component.label","Common");
	var ToothApplicable_title= getLabel("eOH.ToothApplicable.Label","OH");
	var chartcode_title= getLabel("Common.ChartID.label","Common");
	var fields = new Array (formObj.component_code,formObj.tooth_no,frmObj.chart);
	var names = new Array ( component_title,ToothApplicable_title ,chartcode_title);
	var flag=document.forms[0].flag.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	if(checkField( fields, names,messageFrame)){

		var chk_quad=checkRecorded();//added by parul on 06/01/2010 for 17712

		  if (chk_quad==false){
			formObj.chk_recorded.value="N";
		}else{
			formObj.chk_recorded.value="Y";
		}
		if(flag=="1"){
			
		  //FOR UPDATE THE RECORDS
		  document.forms[0].submit();
		}
		else{ 
			//FOR INSERTING THE RECORDS
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params1="component_code="+component_code+"&tooth_no="+tooth_no+"&chart_code="+chart_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","MCommonValidation.jsp?func_mode=countRecords&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);

			if(retVal >= 1){
				var msg = getMessage("RECORD_ALREADY_EXISTS","Common");
				alert(msg);
			}			
			else{
				if(tooth_no == "*A"){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params1="component_code="+component_code+"&chart_code="+chart_code;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","MCommonValidation.jsp?func_mode=checkCompRecorded&"+params1,false);
					xmlHttp.send(xmlDoc);
					var retVal_comp = trimString(xmlHttp.responseText);
					var retVal_comp_int = parseInt(localTrimString(retVal_comp));

					if(retVal_comp_int >= 1){
						//alert("117");
						var msg = getMessage("APP-OH000148","OH");
						alert(msg);
						//alert("Tooth Applicability is recorded for individual tooth Cannot proceed!");
						return;
					}
					else{
						document.forms[0].submit();
					}
				}
				else{
					document.forms[0].submit();
				}
			}
		}
	}
}

function setCheckValue(){
	//	alert("setCheckValue")

    if(document.forms[0].required_yn.checked==true)
		document.forms[0].required_yn.value="Y";	
	else if(document.forms[0].required_yn.checked==false)
	{
		document.forms[0].required_yn.value="N";	
	}
}

function previous(){
	formObj= document.forms[0];
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)-10;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)-10;
	end = formObj.end.value;
	var chart_code=formObj.chart_code.value;
	
	var oh_chart_level = document.forms[0].oh_chart_level.value;	
	var oh_chart_level = document.forms[0].oh_chart_level.value;	document.location.href="../../eOH/jsp/PerioToothApplicabilityDetails.jsp?from="+start+"&to="+end+"&chart_code="+chart_code+"&oh_chart_level="+oh_chart_level;
}

 function next(){
	formObj= document.forms[0];
	var component_desc_user_def=formObj.component_desc_user_def.value;
	var ns_tooth_no=formObj.ns_tooth_no.value;
	var required_yn=formObj.required_yn.value;
	var chart_code=formObj.chart_code.value;
   
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+10;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+10;
	end = formObj.end.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	document.location.href="../../eOH/jsp/PerioToothApplicabilityDetails.jsp?from="+start+"&to="+end+"&chart_code="+chart_code+"&oh_chart_level="+oh_chart_level;
 }

function checkField( fields, names,messageFrame) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
	 if(fields[i].value) {
	   fields[i].value = trimString(fields[i].value);
	 }
	 else { 
	 errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
	 }
	}
	if ( errors.length != 0 )
	{
	messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
	 return false ;
	}
	return true;
}

//called from servlet to refresh the DTL frame after Recording Tooth Applicability.
function refreshDtlFrame(chart_code,tooth_numbering_system,oh_chart_level,flag){
		//	alert("refreshDtlFrame")

	var flag= "";
	top.content.f_query_add_mod.PerioToothApplicabilityDetails.location.href="../eOH/jsp/PerioToothApplicabilityDetails.jsp?chart_code="+chart_code+"&flag="+flag+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level;
	top.content.f_query_add_mod.PerioToothApplicabilityFooter.location.href="../eOH/jsp/PerioToothApplicabilityFooter.jsp?chart_code="+chart_code+"&flag="+flag+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level;
}

function deleteSelectedCompValues(){ //Added By Sridevi Joshi on 12/28/2009 for IN017625 to delete the component values selected.
//alert("deleteSelectedCompValues")
	var formObj = document.forms[0];
	var chart_code = formObj.chart_code.value;
	var comp_code = formObj.component_code_hid.value;
	var tooth_no = formObj.tooth_no_hid.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "chart_code="+chart_code+"&comp_code="+comp_code+"&tooth_no="+tooth_no;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=deleteSelectedCompValues&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retVal_int  = parseInt(localTrimString(retVal));

	var flag= "";
	parent.PerioToothApplicabilityDetails.document.location.href="../../eOH/jsp/PerioToothApplicabilityDetails.jsp?chart_code="+chart_code+"&flag="+flag+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level;
	document.location.href="../../eOH/jsp/PerioToothApplicabilityFooter.jsp?chart_code="+chart_code+"&flag="+flag+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level;

	if(retVal_int != 0){
		var messageFrame=parent.parent.messageFrame;
		var msg = getMessage("RECORD_INSERTED",'SM');
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function clearMessageFrame(){
	var messageFrame=parent.parent.messageFrame;
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function checkRecorded(){////added by parul on 07/01/2010 for 17712

	var formObj =document.forms[0];
	var required_yn=formObj.required_yn.value;
	var required_yn_hid=formObj.required_yn_hid.value;
	if (formObj.required_yn.value!=formObj.required_yn_hid.value){
		 return  true;
	}else{
		return  false;
	}

}

