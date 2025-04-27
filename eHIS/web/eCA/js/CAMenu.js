/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           										created

30/01/2012	IN030566		Ramesh G											When we place another Order of the same
																				category the Pin No. is prompted again even if the Patient chart is not closed.
28/01/2013	IN036367		Dinesh T											Global level filter is changed to filter 
																				the data	
15/03/2013  IN038669		Vijayakumark										CA Chart Summary->
																				Clinical Event History->More Criteria->Search criteria fields displayed as empty Assign a quick link->The values defined for that quick link setup is displayed correctly in the search criteria fields Remove the quick link->Click on ?Clear? button->Not functioning
30/07/2013	IN042008		Chowminya G	 										Quick Links not appending the parameters 
																				when invoked. 	
26/08/2015	IN052635		Vijayakumar K	26/08/2015		Ramesh Goli			PMG2014-CRF-0020 [IN:052635]	
01/08/2015	IN057272		Vijayakumar K	01/08/2015							Practitioner Desktop/Patient Chart->
																				Click on Home Page icon->Expect first 4 icons the other icons disappear in Practitioner Desktop
09/10/2015	IN057446		Vijayakumar K										PMG2014-CRF-0020.1 [IN:057446]
29/12/2015	ICON_COUNT_ISSUE	Vijayakumar K	29/12/2015		Ramesh Goli		Icon count improper
30/12/2015	IN058755		Vijayakumar K	30/12/2015		Ramesh Goli			Regression-CRF-CA-PMG2014-CRF-0020.1/01- 
																				System does not respond when "Home" Button is pressed in CA-Desk Top. [IN:058755] 
01/11/2016	IN062286		Raja S												GDOH-SCF-0217																			
17/11/2016	IN062660		Raja S												Alpha-CIS-CA- Global quick link loaded
20/01/2017	IN061898		Raja S			23/01/2017		Ramesh G			ML-MMOH-CRF-0550
21/04/2017	IN051294		Krishna Gowtham J									MO-CRF-20087
07/02/2019	IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
08/06/2020	IN073001		Ramesh Goli		08/06/2020		Ramesh G			PMG2019-GHL-CRF-0003.2
03/02/2022	IN27710         Suji Keerthi.G	03/02/2022		Ramesh G			GHL-CRF-0658
09/02/2022	IN28627	       Suji Keerthi G 	03/02/2022		Ramesh G			CA-GHL-CRF-0658/01-Quick Link
02/01/2023  20222           SREENADH.M                      Ramesh G            CA-Common-New Clinical Event History
14/11/2023	51215			Ramesh												ML-MMOH-CRF-1930.2
---------------------------------------------------------------------------------------------------------------
*/
//IN038669 starts
var prevQLVal;
var curQLVal;
//IN038669 ends
function SelectedPatient(patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind )
{	 

   this.patient_id				=	patient_id
   this.episode_id				=   episode_id
   this.visit_id				=   visit_id
   this.episode_type			=   episode_type
   this.location_code			=   location_code
   this.location_type			=   location_type
   this.option_id				=   option_id
   this.pat_oth_dtls			=	pat_oth_dtls
   this.window_obj				=   window_obj
   this.relationship_id			=	relationship_id
   this.patient_security_level	=	patient_security_level
   this.patient_protection_ind	=	patient_protection_ind
   this.winname					=	patient_id+episode_id+visit_id;

   if (window_obj){
		window_obj.focus();   
   }
   
    
 }

function closeWindows(val)
{
	 
    var obj = top.content.CommonToolbar
      if(val != null)
        val = "N"

       if(val == null)
           obj = CommonToolbar

        for(var i=0;i<obj.pat_info.length;i++)
        {
			if(!obj.pat_info[i].window_obj.closed )
            {
               obj.pat_info[i].window_obj.close()
            }
        }
}

function refreshArray(childyn)
{ 
	var  firstwindow = top.window ;
    if( top.content != null )
        firstwindow = top.content

    firstwindow= firstwindow.CommonToolbar.firstwindow

    var ref = firstwindow.top.content.CommonToolbar;

   //common tool bar ref
    var pat_info_temp = new Array();
    var j=0 ;
	if(ref != null && ref != undefined)
	{
		if(ref.pat_info != null)
		{
			for(var i=0;i<ref.pat_info.length;i++)
			{
				if(ref.pat_info[i] != null)
				{
					if(!ref.pat_info[i].window_obj.closed  )
					{
					  pat_info_temp[j] = ref.pat_info[i]
					  j++
					}
				}
			}
		}
		ref.pat_info = pat_info_temp;
	}
}

function clearObjects()
{ 
	firstwindow = window.top
	//var beanId= firstwindow.CommonToolbar.patient_id+firstwindow.CommonToolbar.episode_id
	var pat_id = firstwindow.content.CommonToolbar.document.refForm.ref_patient_id.value;
	var epd_id = firstwindow.content.CommonToolbar.document.refForm.ref_episode_id.value;
	var beanId= pat_id.concat(epd_id);
//	alert(beanId)
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
	//alert(xmlHttp)
    xmlHttp.open("POST","../../eCommon/jsp/CommonClearObjects.jsp?from=CA&function_id="+beanId,false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText)
}
//IN073001 Start.
function updateRDExam(facility_id,request_num,request_line_num,updatedValue){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","../../eCA/jsp/InvokePatientHistoryIntermediate.jsp?request_num="+request_num+"&request_line_num="+request_line_num+"&facility_id="+facility_id+"&updatedValue="+updatedValue,true);
    xmlHttp.send(xmlDoc);  
}
//IN073001 End.
 async function viewReferral(ref)
 { 
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogTop = "100" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal =await  top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
}
        
function disableKeys()
{ 
    if(window.event.keyCode==93)
		   alert(getMessage('WELCOME','Common'));
}          

//functions for CAMainTitle.jsp-starts
	  
async function pendingConsent()
{ 
			var queryString = document.refForm.queryString.value;
			var retVal = 	new String();
			var dialogHeight= "32" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			queryString+="&modal_yn=Y";
			retVal=await window.showModalDialog("../../eOR/jsp/ConsentOrders.jsp?p_called_from_ca =Y&"+queryString,arguments,features);
}
async function reviewWindow(indicator)
{ 
	var queryString = document.refForm.queryString.value;
	var retVal = 	new String();
	var dialogHeight= "32" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	if(indicator == "Normal"){
		queryString+="&ca_normalcy_ind=N";
	}else{
		queryString+="&ca_normalcy_ind=X";
	}
	retVal= await window.open("../../eCA/jsp/ReviewResultsModalMain.jsp?"+queryString,arguments,'height=470,width=790,top=50,left=0,resizable=yes');
	return false;
}
async function invokeChat()
{
	var arguments	= "chatWindow" ;
	retVal=await window.open("../../servlet/eCA.chat.AddRemoveOnlineUsers?action=add",arguments,'height=470,width=650,top=50,left=80,resizable=no');
	return false;
}
function setTitle(obj,check){
		var spl=obj.split('||');
		var obj1='';
		for(i=0;i<(spl.length-1);i++){
				obj1+=spl[i];
				if (i<(spl.length-2)){
						obj1+='\n';
				}
		}
		if(check=='Abnormal')
			document.getElementById("href1").title = obj1;
		else if(check=='Consent')
			document.getElementById("href2").title = obj1;
		else if(check=='Collection')
			document.getElementById("href3").title = obj1;
		else if(check=='NotesReview')
			document.getElementById("href4").title = obj1;
		else if(check=='TasksDue')
			document.getElementById("href5").title = obj1;
		else if(check=='MedDue')
			document.getElementById("href6").title = obj1;
		else if(check=='MedOverDue')
			document.getElementById("href7").title = obj1;
		else if(check=='Normal')
			document.getElementById("href8").title = obj1;

}

function callBedManagement()
{
	var bed_patient_id = document.refForm.bed_patient_id.value;
	var qs = top.content.CommonToolbar.document.refForm.queryString.value;
	var url = "../../eNM/jsp/BedManagementMain.jsp?" + qs + "&bed_patient_id=";
	url += bed_patient_id;
	//alert(url);
	top.content.workAreaFrame.location.href=url;
	document.refForm.bed_patient_id.value = "";
	top.content.CommonToolbar.displayFunctionName("Bed Management");
	return false;
}
function callWaitingList()
{
	var qs = top.content.CommonToolbar.document.refForm.queryString.value;
	top.content.workAreaFrame.location.href="../../eNM/jsp/NMWaitingListMain.jsp?" + qs;
	top.content.CommonToolbar.displayFunctionName("Waiting List");
	return false;
}

async function callMedicationPatient(){
	var dialogHeight= "70" ;
	var dialogWidth	= "100" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var patient_id = document.refForm.ref_patient_id.value;
	var nursing_unit = document.refForm.nursing_unit.value;
	var retVal = await window.showModalDialog("../../ePH/jsp/MedicationAdministration.jsp?called_from=CA&patient_id="+patient_id+"&nursing_unit="+nursing_unit,'',features);
	top.content.CommonToolbar.displayFunctionName("Medication Admin");
	return false;
}
async function callMedication(){
	var dialogHeight= "70" ;
	var dialogWidth	= "100" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var retVal = await window.showModalDialog("../../ePH/jsp/MedicationAdministration.jsp?called_from=CA",'',features);
	top.content.CommonToolbar.displayFunctionName("Medication Admin");
	return false;
}
function callTaskList()
{
	var qs = top.content.CommonToolbar.document.refForm.queryString.value;
	top.content.workAreaFrame.location.href="../../eOR/jsp/ResultReporting.jsp?" + qs;
	top.content.CommonToolbar.displayFunctionName("Task List");
	return false;
}
function callCharting()
{
	var qs = top.content.CommonToolbar.document.refForm.queryString.value;
	top.content.workAreaFrame.location.href="../../eNM/jsp/ChartRecording.jsp?" + qs;
	top.content.CommonToolbar.displayFunctionName("Charting");
	return false;
}
function callOnMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'CAFIRSTSELECTHORZ';
}

function callOnMouseOut(obj)
{
	obj.className = currClass;
}

async function callPractitionerList()
{
	var qs = top.content.CommonToolbar.document.refForm.queryString.value;
	var dialogHeight= "29" ;//"29"
	var dialogWidth	= "42" ;//"42"
	var dialogTop	= "70";
	var dialogLeft	= "40";//"85"
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft=" + dialogLeft + ";scroll=no; status:no ";
	await window.showModalDialog("../../eCA/jsp/AMPractitionerList.jsp?" + qs,arguments,features);
}

function loadHomePage(patient_id,executable_name)
{	
	//alert("patient id "+patient_id);
	if(patient_id == undefined || patient_id == '')
	{
		
		changeMainFrameSetSize();	
		loadOrUnloadMenus(document.ShowMenu);
		var qs = top.content.CommonToolbar.document.refForm.queryString.value;
		//alert (qs);
		var dfltFunctionId;
		var layout_value;
		var desktod_id;
	    if (document.homePageParam.dfltFunctionId.value!=null)
	    {
			dfltFunctionId = document.homePageParam.dfltFunctionId.value;
	    }	
		 if (document.homePageParam.layout_value.value!=null)
	    {
			layout_value = document.homePageParam.layout_value.value;
	    }
		 if (document.homePageParam.desktod_id.value!=null)
	    {
			desktod_id = document.homePageParam.desktod_id.value;
	    }
		//Added By Arvind For ICN-22310  
		 if (document.homePageParam.menuId.value!=null)
	    {
			menuId = document.homePageParam.menuId.value;
	    }
		// end here 
		
		//top.content.workAreaFrame.location.href = executable_name + qs;
		//IN057272 starts
		//top.content.menuFrame.location.href = "../../eCA/jsp/CAMainMenuHome.jsp?dfltFunctionId="+dfltFunctionId+"&layoutValue="+layout_value+"&deskTopID="+desktod_id+"&menuId="+menuId;
		top.content.menuFrame.location.href = "../../eCA/jsp/CAMainMenuHome.jsp?dfltFunctionId="+dfltFunctionId+"&layoutValue="+layout_value+"&deskTopID="+desktod_id+"&menuId="+menuId+"&screensize="+screensize;
		//IN057272 ends
		
	//	top.content.menuFrame.location.href = "../../eCA/jsp/CAMainHomePageNew.jsp?" + qs;
		//top.content.workAreaFrame.location.href = "../../eCA/jsp/CAMainHomePageNew.jsp?" + qs;
		//displayFunctionName("Practitioner Home Page");
	}
	else
	{
		//top.opener.top.focus();
		//alert(top.opener.closed);
		//alert(top.opener.name);
		//if(top.opener.document.focus)
			//alert("Supported");
//			top.opener.previousSibling();
//		top.opener.document.focus();
//		alert("supported");
//ecisWindow.focus();
		//top.opener.onblur = function(){alert();top.opener.focus();}
		//window.opener.document.focus();
		//window.opener.top.content.CommonToolbar.document.getElementById("searchPatHome").click();
		if (window.opener && !window.opener.closed) {
       window.opener.document.focus();
        var commonToolbar = window.opener.top.content.CommonToolbar;
    if (commonToolbar && commonToolbar.document.getElementById("searchPatHome")) {
        commonToolbar.document.getElementById("searchPatHome").click();
    } else {
        console.error("CommonToolbar or the element with ID 'searchPatHome' is not found.");
    }
} else {
    console.error("The opener window is not available or has been closed.");
}

	}
}



function logOff(patient_id)
{
	if(patient_id == undefined || patient_id == '')
		parent.close();	
	else
		top.opener.close();
}

function RecentlyAccessed(patient_id)
{
	if(patient_id == undefined || patient_id == '')
	{
		var queryString = document.refForm.queryString.value;
		parent.CommonToolbar.displayFunctionName("Recently Accessed");
		parent.workAreaFrame.location.href="../../eCA/jsp/RecentPatList.jsp?" + queryString;
	}
	else
	{
		top.opener.top.focus();
		top.opener.top.content.CommonToolbar.document.getElementById("RecentlyAccessed").click();
	}
}
function callFunction(option_id,long_desc,executable_name)
{
	if(executable_name != "")
	{
		
		changeMainFrameSetSize();
		loadOrUnloadMenus(parent.CommonToolbar.HideMenu);
		parent.CommonToolbar.displayFunctionName(long_desc);
		parent.workAreaFrame.location.href = executable_name;

		//if((option_id == 'FLOW_SHEET')  )
		// IN051294 starts
		//if((option_id == 'FLOW_SHEET') || (option_id == 'CLINICAL_NOTES') || (option_id == 'MEDICAL_CERTFICATE') || (option_id == 'DISCHARGE_SUMMARY') || (option_id == 'REFERRAL_LETTER')|| (option_id == 'BY_LOCATION'))
			//if((option_id == 'FLOW_SHEET') || (option_id == 'CLINICAL_NOTES') || (option_id == 'MEDICAL_CERTFICATE') || (option_id == 'DISCHARGE_SUMMARY') || (option_id == 'REFERRAL_LETTER')|| (option_id == 'BY_LOCATION') || (option_id == 'PHYSICIAN_NOTES'))//IN069654
		if((option_id == 'FLOW_SHEET') || (option_id == 'CLINICAL_NOTES') || (option_id == 'MEDICAL_CERTFICATE') || (option_id == 'DISCHARGE_SUMMARY') || (option_id == 'REFERRAL_LETTER')|| (option_id == 'BY_LOCATION') || (option_id == 'PHYSICIAN_NOTES') || (option_id == 'FLOW_SHEET_NEW') || (option_id == 'FLOW_SHEET_NEW1'))//IN069654 // 20222 
			
		// IN051294 Ends
		{
			parent.CommonToolbar.filter_by.style='display';
			var optlength = parent.CommonToolbar.filter.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.filter.options.remove("filter");
			}
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id="+option_id, false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);

			/*var HTMLVal="<html><body><form name='CAMainFunctionFilterForm' id='CAMainFunctionFilterForm' method='post' action='../../eCA/jsp/CAMainFunctionFilterCriteria.jsp'>"+
			"<input type='hidden' name='function_id' id='function_id' value='FLOW_SHEET'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.CAMainFunctionFilterForm.submit(); */
		}
		else
			parent.CommonToolbar.filter_by.style.display = 'none';
	}
	else
	{
		 alert(getMessage("FUNC_NOT_APPLICABLE","CA"))
		 top.window.close();
	}
}
function loadFunction(obj)
{
	//IN038669 starts
	curQLVal = obj.value;
	
	if(curQLVal != ''){
	if(curQLVal != prevQLVal){
	prevQLVal = curQLVal;
	}
	}else{
	curQLVal = prevQLVal;
	}
	
	//if(obj.value != '')
	if(curQLVal != '')
	{
		var arr = new Array();
		//arr = obj.value.split("|");
		
		arr = curQLVal.split("|");
		
		if(obj.value == ''){
		if(arr[1] == 'QF')
		arr[4] = '';
		}
		//IN038669	 ends
		
		//IN051294 Start
		//if((arr[0] != 'FLOW_SHEET')&&(arr[0] !='CLINICAL_NOTES')&&(arr[0] !='MEDICAL_CERTFICATE')&&(arr[0] !='DISCHARGE_SUMMARY')&&(arr[0] !='REFERRAL_LETTER')&&(arr[0] !='BY_LOCATION'))
		//if((arr[0] != 'FLOW_SHEET')&&(arr[0] !='CLINICAL_NOTES')&&(arr[0] !='MEDICAL_CERTFICATE')&&(arr[0] !='DISCHARGE_SUMMARY')&&(arr[0] !='REFERRAL_LETTER')&&(arr[0] !='BY_LOCATION')&&(arr[0] !='PHYSICIAN_NOTES'))//IN069654
		if((arr[0] != 'FLOW_SHEET')&&(arr[0] !='CLINICAL_NOTES')&&(arr[0] !='MEDICAL_CERTFICATE')&&(arr[0] !='DISCHARGE_SUMMARY')&&(arr[0] !='REFERRAL_LETTER')&&(arr[0] !='BY_LOCATION')&&(arr[0] !='PHYSICIAN_NOTES')&&(arr[0] != 'FLOW_SHEET_NEW') || (arr[0] == 'FLOW_SHEET_NEW1'))//IN069654 // 20222 
		//IN051294 Ends
		{
		
			/*if(parent.CommonToolbar.filter_by != null)
			parent.CommonToolbar.filter_by.style.display = 'none'; */
			//parent.mainFrameSet.rows="6.75%,*,5%,0%";commented By Channaveer B for issue:21268
			parent.mainFrameSet.rows="8%,90%,5%,0%"; // Added By Channaveer B for issue:21268
		}
		else
		{
			//parent.mainFrameSet.rows="7.75%,*,5%,0%"; commented By Channaveer B for issue:21268
			parent.mainFrameSet.rows="8%,90%,5%,0%";   // Added By Channaveer B for issue:21268
			parent.CommonToolbar.filter_by.style='display';
			var optlength = parent.CommonToolbar.filter.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.filter.options.remove("filter");
			}

			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id="+arr[0], false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);
			//alert(responseText);
			/*var HTMLVal="<html><body><form name='CAMainFunctionFilterForm' id='CAMainFunctionFilterForm' method='post' action='../../eCA/jsp/CAMainFunctionFilterCriteria.jsp'>"+
			"<input type='hidden' name='function_id' id='function_id' value='"+arr[0]+"'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.CAMainFunctionFilterForm.submit(); */
		}
		if(arr[1] == 'EX')
		{
			// Added for IN062660 starts
			if(obj.value!="")
			{
			// Added for IN062660 Ends
			var arr_param = new Array();//IN042008
			//parent.CommonToolbar.filter_by.style.display = 'inline';
			if(arr[3].indexOf("http://") == -1){
				if(arr[3].indexOf("https://") == -1) //Added for IN062286
				arr[3] = "http://"+arr[3];
			}
			//IN042008 - Start
			if(arr[4].indexOf("?") != -1)
				{
					arr_param = arr[4].split("?");
					if(arr[3].indexOf("?") == -1)
						arr[3] = arr[3]+"?"+arr_param[1];
					else if(arr[3].indexOf("&") == -1)
						arr[3] = arr[3]+"&"+arr_param[1];
					else
						arr[3] = arr[3]+""+arr_param[1];
				}
			//IN042008 - End
			//IN27710 - Start
			//window.open(arr[3],null,"height=570,width=1020,top=0,left=0,resizable=yes,status=yes,toolbar=yes,menubar=yes,location=yes,scrollbars=yes"); 
			arr[3]  = arr[3].replace(/ /g,''); //IN28627
			var browserCheck = "";
			var quick_link = new Array();
			var quick_link1 = new Array();
			quick_link = obj.value.split("|");
			quick_link1 = arr[4].split("?");
			var quicklink_type = quick_link[1];
			var quicklink_ref = quick_link1[0];
			           
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH quicklink_type=\""+quicklink_type+"\" quicklink_ref=\""+quicklink_ref+"\" action='getBrowserType' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eCA/jsp/CACheckBrowserIntermediate.jsp",false)  
			xmlHttp.send(xmlDoc)
				
			responseText = xmlHttp.responseText
			responseText = trimString(responseText)
			browserCheck = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
			
			// the following logic is commented by MARWAN because its not supported in EDGE
			// instead its replaced by the window.open(url) which do the same job
			//var oShell = new ActiveXObject("WScript.Shell");
			  try{
				  var url = arr[3];
				  window.open(url, '_blank');
//					if(browserCheck=='G'){
//						oShell.Run('chrome.exe ' + arr[3] , 1);		
//					}
//					if(browserCheck=='I')
//					{
//					oShell.Run('iexplore.exe ' + arr[3] , 1);
//					}
//					if(browserCheck=='M')
//					{
//					oShell.Run('firefox.exe ' + arr[3] , 1);
//					}
//					//51215 Start
//					if(browserCheck=='E')
//					{
//					oShell.Run('msedge.exe ' + arr[3] , 1);
//					}
					//51215 End.
			// MARWAN change ends
				  
			  }catch(exception){
				  alert(getMessage("URL_NOT_INST_IN_USER_MACHINE","CA"));			
			 }
			//IN27710 - End
			}//Added closing bracket for IN062660
		}
		else
		{
			top.content.CommonToolbar.displayFunctionName(arr[2]);
			var qs = document.refForm.queryString.value;
			
			//alert('arr[3]....'+arr[3]+'....option_id..'+arr[0]+'...qs...'+qs+'.....');
			if(arr[3].indexOf("?") != -1)
				//top.content.workAreaFrame.location.href=arr[3]+'&option_id='+arr[0]+'&'+qs;//IN036367
				top.content.workAreaFrame.location.href=arr[3]+'&option_id='+arr[0]+'&'+qs+"&ql_ref="+arr[4];//IN036367
				//top.content.workAreaFrame.location.href=arr[3]+'&option_id='+arr[0]+'&'+qs+'&default_yn=Y';
			else
				//top.content.workAreaFrame.location.href=arr[3]+'?option_id='+arr[0]+'&'+qs;//IN036367
				top.content.workAreaFrame.location.href=arr[3]+'?option_id='+arr[0]+'&'+qs+"&ql_ref="+arr[4];//IN036367
				//top.content.workAreaFrame.location.href=arr[3]+'?option_id='+arr[0]+'&'+qs+'&default_yn=Y';

		}
		//obj.value = '';
	}
}

function loadFilterFunction(obj)
{	
	if(obj.value != '')
	{
		var arr = new Array();
		arr = obj.value.split("|");
		var ql_ref = arr[0];
		var qs = document.refForm.queryString.value+"&ql_ref="+ql_ref;
		//top.content.workAreaFrame.location.href=arr[1]+'?'+qs;
		//top.content.workAreaFrame.location.href=arr[1]+'&'+qs;

		if(arr[1].indexOf("?") != -1)
		{
			top.content.workAreaFrame.location.href=arr[1]+'&'+qs;	
		}
		else
		{
			top.content.workAreaFrame.location.href=arr[1]+'?'+qs;
		}
			

	}
	else
	{
		var executable_path = parent.CommonToolbar.executable_path.value;
		
		var qs = document.refForm.queryString.value;
		//top.content.workAreaFrame.location.href = executable_path+'?default_yn=N&'+qs;
		//top.content.workAreaFrame.location.href = executable_path+'&default_yn=N&'+qs;
		
		if(executable_path.indexOf("?") != -1)
		{
			top.content.workAreaFrame.location.href = executable_path+'&default_yn=N&'+qs;
			
		}
		else
		{
			top.content.workAreaFrame.location.href = executable_path+'?default_yn=N&'+qs;
		}


	}
}
  
 async  function loadDrugDetail()
  {
		var dialogHeight= "29" ;//"29"
		var dialogWidth	= "42" ;//"42"
		var dialogTop	= "70";
		var dialogLeft	= "40";//"85"
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";
		await window.showModalDialog("../../ePH/jsp/QueryDispDrug.jsp?called_from=CA",arguments,features);
  }

  async function callHighRisk(patient_id)
  {
		var dialogHeight= "9" ;
		var dialogWidth	= "25" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no"
		var arguments   = '';
		var title = getLabel("Common.view.label",'common')+getLabel("Common.HighRisk.label",'common');
		var url ='../../eCA/jsp/AuthorizeMRAccess.jsp?Patient_Id='+patient_id+'&modal_yn=Y&constr=V/HR/D';
		var retVal=await 	window.showModalDialog(url,arguments,features);
		dialogHeight    = '9';
		dialogWidth = '25';
		features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
		if(retVal =="T"){
			var retVal=await 	window.showModalDialog('../../eCA/jsp/PatHighRiskQueryResult.jsp?Patient_Id='+patient_id+'&title='+encodeURIComponent(title,"UTF-8")+'&modal_yn=Y',arguments,features);
		}
  }

 async function callAllery(patient_id)
  {
		var dialogHeight= "15" ;
		var dialogWidth	= "40" ;
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';

		var retVal=	await window.showModalDialog('../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id='+patient_id+'&modal_yn=Y',arguments,features);

  }

 function display(from)
  {
	cellref = document.getElementById("tab1").rows(0).cells
	for(i=0; i<cellref.length; i++)
	{
		cellref[i].className = 'CAFIRSTNOSELECT'
	}
	from.className = "CAFIRSTSELECTHORZ"
	currClass ="CAFIRSTSELECTHORZ";
	}

  function display1(from)
 {
	cellref = document.getElementById("tabChart").rows(0).cells
	for(i=0; i<cellref.length; i++)
	{
		cellref[i].className = 'CAFIRSTNOSELECT'
	}
	from.className = "CAFIRSTSELECTHORZ"
	currClass ="CAFIRSTSELECTHORZ";
 }



  

		function displayAlerts()
		{
			var htmlValue = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmAlerts' id='frmAlerts' action='../../eCA/jsp/CAMainHomePageAlertEvents.jsp'></form></body></html>";
			top.content.alertFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			top.content.alertFrame.document.frmAlerts.submit();
		}

//functions for CAMainTitle.jsp-ends
	function close_window(child_winow,windowName)
	 {
		 
		 /*if(child_winow =="Y")
		 {
					var  firstwindow = top.window ;
					var ref = firstwindow.top.content.CommonToolbar;
					var pat_info_backup = new Array();
					
					var pat_info_len;

					if(ref != null && ref != undefined)
					{
	
					if(ref.pat_info != null)
						pat_info_len = ref.pat_info.length;

					var pat_info_temp = new Array();
					var j=0 ;
					
					if(ref.pat_info != null)
					{
						for(var i=0;i<pat_info_len;i++)
						{
							if(!ref.pat_info[i].window_obj.closed)
							{
								pat_info_temp[j] = ref.pat_info[i];
								j++;
							}
						}
					}

					pat_info_len = pat_info_temp.length;
					ref.pat_info.length = 0;
				
				if(pat_info_temp!=null)
				{	
					for(var i=0;i<pat_info_len;i++)
					{
						ref.pat_info[i] = pat_info_temp[i];
					}
				}					

				if(top.content.lookupMenuFrame.windowObjectsArray!=null)
				{
					var objMenuFrame = top.content.lookupMenuFrame;
					var counter = 0;
					for(var i=0;i<objMenuFrame.windowObjectsArray.length;i++){
						if(!objMenuFrame.windowObjectsArray[i].closed)
						{
							counter++;
						}
					}
					if(counter ==0)
						top.opener.focus();
				}
			}
		 }*/
         
	    var obj1= self.top.content.CommonToolbar;

	    var currentWindowName = obj1.document.pat_info.lookup_window_name.value;

		//alert('CAMenu.js 597  windName = '+windowName+ ' , child_winow  = '+child_winow+ ' ,currentWindowName = '+currentWindowName);

		parent.blankFrameForCharts.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../../eCA/jsp/OpenChartWrapperIntermediate.jsp'><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='unLoad'><input type='hidden' name='child_window' id='child_window' value='"+child_winow+"'><input type='hidden' name='windName' id='windName' value='"+windowName+"'><input type='hidden' name='currentWindowName' id='currentWindowName' value='"+currentWindowName+"'></form></body></html>");

		parent.blankFrameForCharts.openChartWrapperIntermediateForm.submit();		
	}
	//[IN030566] Starts
	function close_window_new(child_winow,windowName,patId)
	{		 
		var xmlHttp 	= new XMLHttpRequest();
		var	xmlStr			= "<root><SEARCH " ;
		xmlStr 			+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+patId, false ) ;
		xmlHttp.send( xmlDoc ) ;
		if(trimString(xmlHttp.responseText)=="true")
		{		
	    var obj1= self.top.content.CommonToolbar;
		if(obj1!=undefined){//exception when calling from OP manage patient queue when user not valid
	    var currentWindowName = obj1.document.pat_info.lookup_window_name.value;
		parent.blankFrameForCharts.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../../eCA/jsp/OpenChartWrapperIntermediate.jsp'><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='unLoad'><input type='hidden' name='child_window' id='child_window' value='"+child_winow+"'><input type='hidden' name='windName' id='windName' value='"+windowName+"'><input type='hidden' name='currentWindowName' id='currentWindowName' value='"+currentWindowName+"'></form></body></html>");

		parent.blankFrameForCharts.openChartWrapperIntermediateForm.submit();	
		}
		}
	}
	//[IN030566] Ends
	function loadBeanValues(queryString,windowName)
	{
		/*parent.blankFrameForCharts.document.write("<html><body><form name='WrapperPatCriteriaFrm' id='WrapperPatCriteriaFrm' method='post' action='../../eCA/jsp/OpenChartWrapper.jsp?'"+queryString+"&windName='"+windowName+"'></form></body></html>");
		parent.blankFrameForCharts.WrapperPatCriteriaFrm.submit();*/

	}

function loadOAOrOT(obj)
	{
		var queryString = document.OAOTOptionsForm.qryString.value;

		if(obj.value == 'OA' )
		{
			queryString =  queryString + "&no_opt=Y";
			parent.parent.frames[3].appt_page.rows = "4%,95%,0%,*";
			parent.parent.frames[3].frames[1].location.href = '../../eCA/jsp/CAOAApptDiaryNew.jsp?'+queryString;
		}
		else if(obj.value == 'OT')
		{
			parent.parent.frames[3].appt_page.rows = "4%,80%,0%,*";
			parent.parent.frames[3].frames[1].location.href = '../../eOT/jsp/CalendarModalFrame.jsp?'+queryString+'&called_from=CA';
		}
		else if(obj.value == '*ALL' )
		{
			parent.parent.frames[3].appt_page.rows = "4%,90%,0%,*";
			parent.parent.frames[3].frames[1].location.href = '../../eCA/jsp/CAOAAppointmentNew.jsp?'+queryString;
		}

	}
//IN0052635 starts
//IN057446 starts
/*function callMenuIcons(obj)
{

	var total_icon_records = parent.CommonToolbar.total_icon_records.value;
	var no_icons_displayed = parent.CommonToolbar.no_icons_displayed.value;

	var total_icons = total_icon_records - no_icons_displayed;
	var dialg_height = Math.ceil(total_icons/10)* 28;
	if(dialg_height<112)
	dialg_height = 112;
	var dialogHeight= dialg_height+"px" ;
	var dialogWidth	= "305px" ;
	var dialogTop	= "105";
	var dialogLeft	= "350";
	var arguments	= "" ;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no;";
	
	var ret = window.showModalDialog("../../eCA/jsp/CAMenuPopup.jsp?"+obj+"&total_icon_records="+total_icon_records+"&no_icons_displayed="+no_icons_displayed,arguments,features);
	
	
	
	if(ret != undefined)
	callFunction(ret.option_id,ret.long_desc,ret.executable_name);

}*/
function callMenuIcons(obj,from,to,total_no_of_icon)
{
	var totMenuDisplay	=	parent.CommonToolbar.totMenuDisplay.value;
	var toolbarQueryString = parent.CommonToolbar.toolbarQueryString.value;
	//IN058755 starts
	//var menu_id = parent.CommonToolbar.menuId.value; //ICON_COUNT_ISSUE
	var menu_id = parent.CommonToolbar.homePageParam.menuId.value; 
	//IN058755 ends
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//ICON_COUNT_ISSUE starts
	//params = toolbarQueryString+"&total_icon_records="+total_no_of_icon+"&totMenuDisplay="+totMenuDisplay+"&key=NON_MAIN&from="+from+"&to="+to;
	params = toolbarQueryString+"&total_icon_records="+total_no_of_icon+"&totMenuDisplay="+totMenuDisplay+"&key=NON_MAIN&from="+from+"&to="+to+"&menuId="+menu_id;
	//ICON_COUNT_ISSUE ends
	//params = "&total_icon_records="+total_no_of_icon+"&totMenuDisplay="+totMenuDisplay+"&key=NON_MAIN&from="+from+"&to="+to;
	xmlHttp.open( "POST", "CAMenuPopup.jsp?"+params , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	parent.CommonToolbar.displayIcons(responseText ) ;
}
//IN057446 ends
//IN0052635 ends

