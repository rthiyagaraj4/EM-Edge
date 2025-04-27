/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		 Nijitha										SKR-CRF-0036
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
function hideData(contentID){
	document.getElementById("jsp"+contentID).style.display='none';
}

function showEncounterSpecificData(req_encounter_id,encounter_id_spc,called_from,index,patient_class){
	var totalVisits= document.getElementById("totalVisits").value;
	var location_code_spc = document.getElementById("location_code_spc").value;
	
	var widgetHeaderShade="";
	for(var j=1;j<=totalVisits;j++){    	
    	if(j==index){			
			document.getElementById("encounterTab"+j).style.color="#0000FF";			
		}else{
			if(null!=document.getElementById("encounterTab"+j)){
				document.getElementById("encounterTab"+j).style.color="#666";	
			}	
		}
    }	
	if(called_from=='ONLOAD')
	{
		encounter_id_spc = req_encounter_id;
	}
	var query_string = document.encounterSpecificTABform.query_string.value;
	document.encounterSpecificTABform.encounter_id_spc.value = encounter_id_spc;
	if(null!=document.getElementById("encounterTabBgColor"+index))
	widgetHeaderShade			 = document.getElementById("encounterTabBgColor"+index).value;
	parent.singlepageconsultationworkflow.location.href		="../../eCA/jsp/SinglePageConsultation.jsp?"+query_string+"&req_encounter_id="+req_encounter_id+"&encounter_id_spc="+encounter_id_spc+"&widgetHeaderShade="+escape(widgetHeaderShade)+"&patient_class_spc="+patient_class+"&location_code_spc="+location_code_spc;
	
	
}

function highlightOnSelection(index,color){
	
	var totalVisits= document.getElementById("totalVisits").value;
	var bgColor="";
		
		var percent=50;
		var r = parseInt(color.substr(1, 2), 16), g = parseInt(color.substr(3, 2), 16), b = parseInt(color.substr(5, 2), 16); 
	    var brightcolor =   ((0|(1<<8) + r + (256 - r) * percent / 100).toString(16)).substr(1) + ((0|(1<<8) + g + (256 - g) * percent / 100).toString(16)).substr(1) +        ((0|(1<<8) + b + (256 - b) * percent / 100).toString(16)).substr(1);
	    
	    for(var j=1;j<=totalVisits;j++)
	    {
	    	
	    	if(j==index){
				document.getElementById("encounterTab"+j).style.backgroundColor=brightcolor;
			}else{
				if(null!=document.getElementById("encounterTabBgColor"+j))
					bgColor = document.getElementById("encounterTabBgColor"+j).value;
				
				if(null!=document.getElementById("encounterTab"+j))
					document.getElementById("encounterTab"+j).style.backgroundColor=bgColor;
			}
	    }	    	
}

function showNextPreviousData(obj){
	var query_string = document.encounterSpecificTABform.query_string.value;
	url = "../../eCA/jsp/SinglePageConsultationEncounterTab.jsp?";
	pars ='query_string='+query_string;
	document.forms[0].disp_mode.value = obj;
	document.encounterSpecificTABform.action= url+pars;
	document.encounterSpecificTABform.submit();
}

function funPrint1(){	
	/*var no_of_widgets = parent.singlepageconsultationworkflow.document.singlepageconsultationform.no_of_widgets.value;
	var reloadWidgetCount = parent.singlepageconsultationworkflow.document.singlepageconsultationform.reloadWidgetCount.value;
	var authorize_diagnosis = parent.singlepageconsultationworkflow.document.singlepageconsultationform.authorize_diagnosis.value;*/
	
	var no_of_widgets = document.forms[0].no_of_widgets.value;
	var reloadWidgetCount = document.forms[0].reloadWidgetCount.value;
	var authorize_diagnosis = document.forms[0].authorize_diagnosis.value;
	var option_id = document.forms[0].option_id.value;
	var printWidgetQs="";
	var print_yn="";
	var print_yn_index=0;
	for(var j=1;j<=no_of_widgets;j++)
	{
		 print_yn = parent.singlepageconsultationworkflow.document.getElementById("print_yn"+j).value;
		 printWidgetQs = printWidgetQs+"&print_yn"+j+"="+print_yn;
		 if("Y"==print_yn)
		 {
			print_yn_index++;
		 }
	}
	if(print_yn_index==0){
		alert("Please select atleast one widget for printing...");
		return false;
	}
	var patient_id = parent.encounterSpecificTAB.document.encounterSpecificTABform.patient_id.value;
	var encounter_id = parent.encounterSpecificTAB.document.encounterSpecificTABform.encounter_id_spc.value;
	var index = parent.encounterSpecificTAB.document.encounterSpecificTABform.encounterIndex.value;
	var widgetHeaderShadeprint="";
	if(null!=parent.encounterSpecificTAB.document.getElementById("encounterTabBgColor"+index))
	widgetHeaderShadeprint = parent.encounterSpecificTAB.document.getElementById("encounterTabBgColor"+index).value;
	
	var dialogHeight	= "39" ;
	var dialogWidth		= "60" ;
	var status			= "no";
	var scroll			= "no";
	var dialogTop		= "100";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	window.showModalDialog("../../eCA/jsp/SinglePageConsultationPrint.jsp?encounter_id_spc="+encounter_id+"&patient_id="+patient_id+"&called_from=PRINT"+"&widgetHeaderShade="+escape(widgetHeaderShadeprint)+printWidgetQs+"&no_of_widgets="+no_of_widgets+"&reloadWidgetCount="+reloadWidgetCount+"&authorize="+authorize_diagnosis+"&p_called_from=CA_SPC"+"&encounter_id="+encounter_id+"&option_id="+option_id,features);
}

function fun()
{
	var encounter_id = parent.encounterSpecificTAB.document.encounterSpecificTABform.encounter_id_spc.value;
	var query_string = parent.encounterSpecificTAB.document.encounterSpecificTABform.query_string.value;
	var index = parent.encounterSpecificTAB.document.encounterSpecificTABform.encounterIndex.value;
	var no_of_widgets = document.forms[0].no_of_widgets.value;
	var option_id = document.forms[0].option_id.value;
	var printWidgetQs="";
	var print_yn="";
	var print_yn_index=0;
	for(var j=1;j<=no_of_widgets;j++)
	{
		 print_yn = parent.singlepageconsultationworkflow.document.getElementById("print_yn"+j).value;
		 printWidgetQs = printWidgetQs+"&print_yn"+j+"="+print_yn;
		 if("Y"==print_yn)
		 {
			print_yn_index++;
		 }
	}
	if(print_yn_index==0){
		alert("Please select atleast one widget for printing...");
		return false;
	}
	var widgetHeaderShadeprint="";
	if(null!=parent.encounterSpecificTAB.document.getElementById("encounterTabBgColor"+index))
		widgetHeaderShadeprint = parent.encounterSpecificTAB.document.getElementById("encounterTabBgColor"+index).value;
		var dialogHeight	= "50" ;
		var dialogWidth		= "60" ;
		var status			= "no";
		var scroll			= "yes";
		var dialogTop		= "100";
		var arguments	= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	//window.open('../../eCA/jsp/SinglePageConsultationPrintPreview.jsp?query_string'+query_string+'&encounter_id_spc='+encounter_id+'&called_from=PRINTPREVIEW'+"&widgetHeaderShade="+escape(widgetHeaderShadeprint)+printWidgetQs+"&no_of_widgets="+no_of_widgets+"&p_called_from=CA_SPC&option_id="+option_id,"",features);

	window.showModalDialog('../../eCA/jsp/SinglePageConsultationPrintPreview.jsp?query_string'+query_string+'&encounter_id_spc='+encounter_id+'&called_from=PRINTPREVIEW'+"&widgetHeaderShade="+escape(widgetHeaderShadeprint)+printWidgetQs+"&no_of_widgets="+no_of_widgets+"&p_called_from=CA_SPC&option_id="+option_id,arguments,features);

}
function removehighlightOnSelection(){	
	var totalVisits= document.getElementById("totalVisits").value;
	var bgColor="";	
	    for(var j=1;j<=totalVisits;j++)
	    {	    	
			if(null!=document.getElementById("encounterTabBgColor"+j))
				bgColor = document.getElementById("encounterTabBgColor"+j).value;
			
			if(null!=document.getElementById("encounterTab"+j))
				document.getElementById("encounterTab"+j).style.backgroundColor=bgColor;
	    }	
}

function printWidget(obj)
{
	var print_yn = obj.name;
	if(obj.checked)
	{
		document.getElementById(print_yn).value="Y";
	}
	else
	{
		document.getElementById(print_yn).value="N";
	}
}
	
