//Created by Sethuraman for encounter Summary requirements
var summaryArray = new Array();
var summCount = 0;
var summDesc = "";
var recordCount = 0;

function setEncounterFlag(obj)
{	
	if (obj.value == '0')
	{
		document.EncSummPopUpHeadForm.CurrPrevEnc.value="0";	
		document.getElementById('search').disabled = true;		
		document.EncSummPopUpHeadForm.encounterId.value = document.EncSummPopUpHeadForm.currEncId.value;
		
	}
	else
	{		
		document.EncSummPopUpHeadForm.CurrPrevEnc.value="1";		
		document.getElementById('search').disabled = false;		
	}
	
	parent.EncSummPopupPrevEncFrame.location.href = '../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function setEncounterValue(patienId,prevEncId)
{		
	parent.EncSummPopupHeaderFrame.document.EncSummPopUpHeadForm.patientId.value = patienId;	
	parent.EncSummPopupHeaderFrame.document.EncSummPopUpHeadForm.encounterId.value = prevEncId;		
}

function SearchEncounters()
{
	var patientId = document.EncSummPopUpHeadForm.patientId.value;
	var currEncId = document.EncSummPopUpHeadForm.currEncId.value;
	
	if (patientId !="")
	{
		parent.EncSummPopupPrevEncFrame.location.href = '../../eCA/jsp/EncSummPopUpList.jsp?patientId='+patientId+'&currEncId='+currEncId;
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}
}

function checkForSummary(obj)
{		
	var patientId = ""; 
	var encounterId = "";	
	
	if (obj.type == "button")
	{	
		patientId = document.EncSummPopUpHeadForm.patientId.value;
		encounterId = document.EncSummPopUpHeadForm.encounterId.value;
	}
	else
	{
		patientId = parent.EncSummPopupHeaderFrame.document.EncSummPopUpHeadForm.patientId.value;
		encounterId = parent.EncSummPopupHeaderFrame.document.EncSummPopUpHeadForm.encounterId.value;
	}
	
	summCount = 0;
	summDesc = "";
	recordCount = 0;
	
	var errorMsg = "";
	
	var summArray = null;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();	
	
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/EncSummCheckForCode.jsp?patientId="+patientId+"&encounterId="+encounterId, false);
	xmlHttp.send(xmlDoc);

	responseText=xmlHttp.responseText;

	responseText = trimString(responseText);

	eval(responseText);		
	
	//alert(" summCount : "+summCount+" recordCount: "+recordCount);
	if (summCount == 0){
		errorMsg = getMessage("SUMMARY_NOT_CONFIGURED",'CA');
		alert(errorMsg);
		return false;
	}
	
	if (summCount == 1)
	{	
		if (recordCount == 0){
			errorMsg = getMessage("RESULTS_NOT_AVAILABLE",'CA');
			alert(errorMsg);
			return;
		}
		summArray = summDesc.split("~");
		if (obj.type == "button")
		{
			PrintSummary(patientId,encounterId,summArray[0]);
		}
		else
		{			
			viewEncounterSummary(patientId,encounterId, summArray[0]);
		}
	}
	else if (summCount > 1)
	{				
		showSelectSummaryWindow(patientId,encounterId,summDesc);
	}		
}

function showSelectSummaryWindow(patientId,encounterId,summDesc)
{	
	var dialogHeight= "300px" ;
	var dialogWidth	= "500px" ;
	var dialogTop	= "300";
	var dialogLeft	= "300";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";
	var ret = window.showModalDialog("../../eCA/jsp/EncSummSelectCode.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summDesc="+summDesc,arguments,features);
}

function PrintSummary(patientId,encounterId, summCode)
{		
	var dialogHeight= "800px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop	= "10";
	var dialogLeft	= "10";
	var arguments	= "" ;
	var modalfeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no; location:no ";
	var showFeatures	= "toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10, top=10, width=1200px, height=800px, visible=none";
	//var hideFeatures	= "toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10000, top=10000, width=10, height=10, visible=none ";

	var ret = window.showModalDialog("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments,modalfeatures);
	
	//var ret = window.open("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments,modalfeatures);
	
	//var ret = window.open("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments, showFeatures);
	/*
	$.ajax({
        url : "../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode,	
        success : function (data) {
	        var data1=data;	     
	        data1.print();	        
		}
		});
	*/
	//document.getElementById("printFrame").src = "../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=1";
}

function viewEncounterSummary(patientId,encounterId, summCode)
{		
	var dialogHeight= "800px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop	= "10";
	var dialogLeft	= "10";
	var arguments	= "" ;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";
	var showFeatures	= "toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10, top=10, width=1200px, height=800px, visible=none";
	
	var ret = window.showModalDialog("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments,features);
	//var ret = window.open("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments, showFeatures);
}
/* --------------------- Functions called from EncSummGroupCompAddCompCriteria.jsp ends here ---------------------*/

/* Functions called from EncSummGroupCompAddCompList.jsp */
function loadPrevNextRecs(varName)
{
	var start = document.addNewCompForm.from.value;
	var end = document.addNewCompForm.to.value;
	var searchGroupType = document.addNewCompForm.searchGroupType.value;
	var searchText = document.addNewCompForm.searchText.value;
	if(searchText == undefined) searchText = '';

	var mode = document.addNewCompForm.mode.value;
	var flag = document.addNewCompForm.flag.value;
	var groupFlag = document.addNewCompForm.groupFlag.value;
	var groupType = document.addNewCompForm.groupType.value;
	var groupCode = document.addNewCompForm.groupCode.value;
	var gFlag = document.addNewCompForm.gFlag.value;
	
	var totalCount = document.addNewCompForm.totalCount.value;
	var countForNext = document.addNewCompForm.countForNext.value;

	var tempRowIds = "";
	var tempString = "";
	var tempParseInt = 0;

	if(varName == 'prev')
	{
		start = parseInt(start,10) - 5;
		end = parseInt(end,10) - 5;
		tempParseInt = parseInt(countForNext,10)-1;
	}
	else if(varName == 'next')
	{
		start = parseInt(start,10) + 5;
		end = parseInt(end,10) + 5;
		tempParseInt = parseInt(countForNext,10)+1;
	}

	for(var t=parseInt(start,10);t<parseInt(end,10);t++)
	{
		tempString = parent.parent.rowIDCompForEncSumm[t];
		
		if(t < totalCount)
		{
			if(tempString.indexOf("+") != -1)
			{
				for(var x=0;x<tempString.length;x++)
				{
					tempString = tempString.replace("+","^");
				}
			}
			tempRowIds = "'"+tempString+ "'," + tempRowIds;
		}
	}	

	parent.addCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddCompList.jsp?mode="+mode+"&groupFlag="+groupFlag+"&groupType="+groupType+"&groupCode="+groupCode+"&gFlag="+gFlag+"&flag="+flag+"&start="+start+"&end="+end+"&searchText="+encodeURIComponent(searchText)+"&searchGroupType="+searchGroupType+"&tempRowIds="+tempRowIds+"&flagTemp=temp&totalCount="+totalCount+"&countForNext="+tempParseInt;
}

