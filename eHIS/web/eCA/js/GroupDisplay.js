/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------		
16/10/2018  IN068145		Raja S			16/10/2018   		Ramesh G		ML-MMOH-CRF-1212
06/01/2020	IN071374		Ramesh Goli		06/01/2020			Ramesh G		ML-MMOH-SCF-1367	
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function loadYearMonth(event_class,grp_code,grpyear,grpmonth){

	var tempobj= document.getElementById("panelview"+grp_code);
	var tempobj1 = document.getElementById("year"+grp_code+grpyear)
	var tempobj2 = document.getElementById("month"+grp_code+grpyear)
	var tempobj4 = document.getElementById("monthsub"+grp_code+grpyear+grpmonth)

	tempobj.style.display="inline";
	tempobj.value="Y";
	tempobj1.style.display="inline";
	tempobj1.value="Y";
	tempobj2.style.display="inline";
	tempobj2.value="Y";
	loadvalues(event_class,grp_code,grpyear,grpmonth,tempobj4)
	document.grpdispdetail.lastopenmonth.value="monthsub"+grp_code+grpyear+grpmonth
	document.grpdispdetail.lastopengroup.value="details"+grp_code
}
function hidemonth(grp_code,grpyear){
	var tempobj1 = document.getElementById("year"+grp_code+grpyear)
	var tempobj2 = document.getElementById("month"+grp_code+grpyear)
	if(tempobj2.value=="Y"){
		tempobj2.style.display="none";
		tempobj1.className="Acctxtimg";
		tempobj2.value="N";
	}
	else{
		tempobj2.style.display="inline";
		tempobj1.className="AcctxtimgSelect AcctxtimgSub"
		tempobj2.value="Y";
	}
}
function hidepanel(grp_code){
	var panelobj= document.getElementById("panelview"+grp_code);
	var groupobj= document.getElementById("group"+grp_code);
	if(panelobj.value=="Y") {
		panelobj.style.display="none";
		if(groupobj.value=="Y"){
			groupobj.className="Acctxtimg";
			groupobj.value="N"
		}
		panelobj.value="N";
	}else{
		panelobj.style.display="inline";
		if(groupobj.value=="N"){
			groupobj.className="AcctxtimgSelect AcctxtimgSub";
			groupobj.value="Y"
		}
		panelobj.value="Y";
	}
}

function loadvalues(event_class,grp_code,grpyear,grpmonth,monthobj){
	
	if(document.grpdispdetail.lastopenmonth.value!="")
	{
		var hidelastmonth =document.getElementById(document.grpdispdetail.lastopenmonth.value)
		var hidelastdetails =document.getElementById(document.grpdispdetail.lastopengroup.value)
		if(hidelastmonth.value=="Y")
		{
			hidelastmonth.className="Acctxtimg"
			hidelastmonth.value="N"
			hidelastdetails.innerHTML="";
		}
	}
	document.grpdispdetail.lastopenmonth.value="monthsub"+grp_code+grpyear+grpmonth
	document.grpdispdetail.lastopengroup.value="details"+grp_code
	
	//document.grpdispdetail.lastopenmonth.value=grpmonth
	if(monthobj.value=="Y"){
		monthobj.className="Acctxtimg";
		monthobj.value="N";
		document.getElementById("details"+grp_code).innerHTML=""
	}else{
		monthobj.className="AcctxtimgSelect AcctxtimgSub";
		monthobj.value="Y";
		populatedetails(event_class,grp_code,grpyear,grpmonth)
	}
}

function populatedetails(event_class,grp_code,grpyear,grpmonth){

	
	
	var formObj = document.grpdispdetail
	var bean_id = formObj.bean_id.value ;
	var bean_name = formObj.bean_name.value ;
	var locale = formObj.locale.value ;
	var patient_id = formObj.patient_id.value ;
	var encounter_id = formObj.encounter_id.value ;
	var from_date = formObj.from_date.value ;
	var to_date = formObj.to_date.value ;
	var grphistory_type = formObj.grphistory_type.value ;
	var orderCatalogNature = formObj.orderCatalogNature.value ;
	var clinician_id = formObj.clinician_id.value ;
	var resp_id = formObj.resp_id.value ;
	var normalcy = formObj.normalcy.value ;
	
	
	var param ="&event_class="+event_class+"&grp_code="+grp_code+"&grpyear="+grpyear+"&grpmonth="+grpmonth+"&grphistory_type="+grphistory_type+"&orderCatalogNature="+orderCatalogNature+"&resp_id="+resp_id+"&clinician_id="+clinician_id+"&normalcy="+normalcy

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "GroupEventIntermediate.jsp?Mode=GroupDetails&bean_id="+bean_id+"&bean_name="+bean_name+"&locale="+locale+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&from_date="+from_date+"&to_date="+to_date+param, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText;
	responseText=trimString(responseText)
	document.getElementById("details"+grp_code).innerHTML=responseText
	//eval(responseText);
  /*  
	if(eval("formObj.order_type"+index).value == "*ALL"){
		eval("formObj.order_catalog"+index).value = "*ALL";
		eval("formObj.order_catalog_val"+index).value = "All";
		eval("document.form_wait_time_pending.order_catalog_butn"+index).style.visibility ="hidden";
	
	}
	
*/
}
function loadgroup(event_class){
	var formObj = document.grpdispdetail
	var bean_id = formObj.bean_id.value ;
	var bean_name = formObj.bean_name.value ;
	var locale = formObj.locale.value ;
	var patient_id = formObj.patient_id.value ;
	var encounter_id = formObj.encounter_id.value ;
	var from_date = formObj.from_date.value ;
	var to_date = formObj.to_date.value ;
	var grphistory_type = formObj.grphistory_type.value ;
	var orderCatalogNature = formObj.orderCatalogNature.value ;
	var normalcy = formObj.normalcy.value ;
	
	params="bean_id="+bean_id+"&bean_name="+bean_name+"&locale="+locale+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&from_date="+from_date+"&to_date="+to_date+"&loadDefaultclass="+event_class+"&grphistory_type="+grphistory_type+"&orderCatalogNature="+orderCatalogNature+"&normalcy="+normalcy
	parent.DetailsFrame.location.href="../../eCA/jsp/GroupDisplayDetails.jsp?"+params
}
var arrObjects = new Array();
var arrValues = new Array();
var arrClassValues = new Array();
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{
	document.forms[0].txtFlagQuickText.value = 'Y';
	var win_height		= "28";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){

		win_height		= "23";
		win_width		= "37";
		win_scroll_yn	= "no";
	}
	var retVal = new String();
	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);
	retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			var temp1 = arrClassValues[i];
			arrObjects[i].className = temp1;
		}
	}
	arrObjects = new Array();
	arrValues = new Array();
	arrClassValues = new Array();
	return false;
}
async function enterQuickText(eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,singleMultiFlag)
{
	var qsForComments = document.forms[0].queryStringForComments.value;
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_id = document.forms[0].encounter_id.value;
	var fac_id = document.forms[0].fac_id.value;//IN033489
	var enctr_id = document.forms[0].encounter_id.value;//IN033489
	//var viewConfRes = document.forms[0].viewConfRes.value;
	//var graphorder = document.forms[0].graphorder.value;
	//var flowsheetCompId = document.forms[0].flowsheetCompId.value;
	//var errorEvent = document.forms[0].errorEvent.value;
	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;


	if(encounter_id == "" || encounter_id == null) encounter_id = "0";
	encounter_id = encounter_id;

	if(singleMultiFlag == null)
	{
		singleMultiFlag='M';
     }

	document.forms[0].txtFlagQuickText.value = 'Y';
	var tempValues = "";
	var count=0;
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			//alert(arrObjects[i]);
			count++;
		}
	}

/*	if(count == 0 && singleMultiFlag == "M"){
		alert(getMessage("EVENTS_FOR_QUICKTEXT","CA"));
		return false;
	}*/
	count =0;

	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			//alert(arrValues[i]);
			tempValues+= "~"+arrValues[i];
			count++;
		}
	}

	if(count == 0){
		tempValues+= "~"+eventDate+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
		count =1;
	}


	if(tempValues != ""){
		tempValues = tempValues.substring(1);
	}

	var dialogHeight= "37.5" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;	
	
	
	var retVal =await window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?qsForComments="+qsForComments+"&quickTextCodes="+tempValues+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&fac_id="+fac_id+"&enctr_id="+enctr_id,'',features);//IN033489
	
	
	if(retVal != null && retVal != undefined && retVal != "")
	{
		//self.location.reload();
		parent.dataFrame.location = parent.dataFrame.location;
	}
	return false;		
}
function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extimageapplid)
{
	
	if(messageFrameReference == null) //added for the condition, called_from = "OR" in FlowSheetEvents.jsp
	{
		messageFrameReference = 	parent.parent.parent.messageFrame;
	}
	var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head> <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAOpenExternalApplication.jsp'><input type=hidden name=Histrectype value='"+Histrectype+"'><input type=hidden name=Contrsysid value='"+Contrsysid+"'><input type=hidden name=Accessionnum value='"+Accessionnum+"'><input type=hidden name=Contrsyseventcode value='"+Contrsyseventcode+"'><input type=hidden name=extimageapplid value='"+extimageapplid+"'></form></body></html>"

	messageFrameReference.document.write(htmlVal);
	messageFrameReference.document.tempForm.submit();
 
}
function viewUploadedImg(showImageLocn)
{
	var dialogHeight	= "32" ;
	var dialogWidth		= "42" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	var arguments		="";
	window.showModalDialog(showImageLocn,"",arguments,features);
}
function getExtLink(patient_id, encounter_id, accession_no, order_id, facility_id, locale, login_user, resp_id, login_at_ws_no, order_type_code, op_episode_visit_num, attend_practitioner_id, assign_care_locn_type, assign_care_locn_code, visit_adm_date,  patient_class, locn_desc,ext_image_appli_id, ext_image_obj_id, ext_image_source, ext_srce_doc_ref_no, ext_srce_doc_ref_line_no) {

	var Ext_Application_ID = ext_image_appli_id; 
	var Ext_Function = 'VIEW'; 
	var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+escape(accession_no)+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class+'&P_Ext_Application_ID='+Ext_Application_ID+'&P_Ext_Function='+Ext_Function+'&P_DOC_ID='+ext_image_obj_id; //modified for IN048253 
	dispExtApp(qry_string);	  //dispExtApp function avalible on ExternalApplication.js of eXH Module. 
}
async function ShowComments(resultStr)
	{	

		var comments;
		var retVal;
		var dialogHeight ='18.75' ;
		var dialogWidth = '25' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		//var arguments = resultStr;
		var arguments = escape(resultStr).replace(/\+/g,' '); //ML-BRU-SCF-1642 - IN057138
		retVal 			=await window.showModalDialog('../../eCA/jsp/QuickText.jsp',arguments,features); //ML-BRU-SCF-1642 - IN057138
}

function displayToolTip(toolTip,toolTip1,obj)
{
	tdObj= obj;
		if(toolTip1 != '')
		{
			document.getElementById("t").innerHTML = toolTip1;
			
			var wdth 	  = tdObj.offsetWidth;
			var hght 	  = tdObj.offsetHeight;

			var wdth1 = getPos(tdObj).x ;
			var hght1 = getPos(tdObj).y + hght;

				x = wdth1;	
				y = hght1;

			document.getElementById("tooltiplayer").style.posLeft = x;
			document.getElementById("tooltiplayer").style.posTop = y;
			document.getElementById("tooltiplayer").style.visibility = 'visible';
				/*if(tdObj.className != 'gridDataSelect')
					tdObj.className = 'gridDataHover';*/
			}

			var temp="<DIV STYLE='BACKGROUND-COLOR:yellow'>";
			
			temp += toolTip;
			temp += "</DIV>";
			/*if(top.content != null)
			{
				messageFrameReference.document.body.innerHTML = temp;
			}
			else if(parent.parent.mesasgeFrame!=null)
			{
				parent.parent.messageFrame.document.body.innerHTML = temp;
			}
			else
			{
				if(parent.parent.parent.messageFrame!=null)
				{
					parent.parent.parent.messageFrame.document.body.innerHTML = temp;
				}
			}*/
}

function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'
	
}

function changeColor(obj,encounter_id,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,histDataType,eventDesc,resultNum,textCount,classValue,sortEventDateTime,rowNum,colNum,event_code){
/*
	var patient_id = document.dataForm.patient_id.value;
	//var encounter_id = document.dataForm.encounter_id.value;
	var enc_id = document.dataForm.enc_id.value;
	
	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;
	if(enc_id == "" || enc_id == null) enc_id = "0";
	//encounter_id = enc_id;
	if(encounter_id == "" || encounter_id == null) encounter_id = "0";

	rowNum = parseInt(rowNum,10);
	colNum = parseInt(colNum,10);

	var uom = eval("parent.unitFrame.document.flowSheetEventsForm.UOM"+rowNum);
	if(uom != null && uom != undefined) uom = uom.value;
	if(uom == undefined || uom == null || uom == "") uom = "";
	Accessionnum = unescape(Accessionnum);
	eventDesc = unescape(eventDesc);
*/
/*	 var addRemove = "Add";
	 var x = 0;
	 var tdObj = eval("document.getElementById("visibility")"+event_code+rowNum+"ID");

	 if(tdObj.className == 'gridDataSelect')
	 {
		addRemove = "Remove";
		tdObj.className = 'gridDataChart';
	 }
	 else
	 {
		 addRemove = "Add";
		 tdObj.className = 'gridDataSelect';
	 }
/*
	 var hist_data_type = histDataType;
	 var event_desc = eventDesc;
	 var result_num = resultNum;
	// var result_str = resultStr;
	 var txt_count = textCount;
 	if(result_num == "") result_num = "&nbsp;";
	//if(result_str == "") result_str = "&nbsp;";

	if(uom == " ") uom = "";


	var valsToRemove = encounter_id+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	var valsToSort = encounter_id+"`"+Histrectype+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	parent.manageEmailFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?addRemove='+addRemove+'&valsToRemove='+escape(valsToRemove)+'&valsToSort='+escape(valsToSort)+'&patient_id='+patient_id+'&encounter_id='+enc_id;
*/
}
function showToolTip(obj,objcount,text)
{	
	if(text.length>15)
	{
		var tab_dat  = "<table class='grid' id='tooltiptable1'  width='' height='100%' align='center'>"
		tab_dat   =  tab_dat+"<tr bgcolor='lightyellow' >" ;
		tab_dat    = tab_dat+ "<td class = 'contextMenuItem' style='padding-left:10px;padding-right:10px' >"+text+"</td>" ;
		tab_dat     =tab_dat+ "</tr>" ;		
		tab_dat     =tab_dat+ "</table> ";	
		document.getElementById("descLink").innerHTML = tab_dat;
		document.getElementById("descLink").style.top  = obj.offsetTop+27;
		if(objcount=="5")
		{
			document.getElementById("descLink").style.left  = obj.offsetLeft+30;
		}
		else
		{
		document.getElementById("descLink").style.left  = obj.offsetLeft+90;}
		document.getElementById("descLink").style.visibility='visible' ;
	}
	else
	{
		hidePopUp();
	}
}

function hidePopUp()
{
	if(document.getElementById("descLink"))
	document.getElementById("descLink").style.visibility='hidden' ;
}

function getPos(inputElement)
		{
			var coords =  new Object();
			coords.x = 0;
			coords.y = 0;
			try
			{
				targetElement = inputElement;
				if(targetElement.x && targetElement.y)
				{
					coords.x = targetElement.x;
					coords.y = targetElement.y;
				}
				else
				{
					if(targetElement.offsetParent)
					{
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
						while(targetElement = targetElement.offsetParent)
						{
							coords.x += targetElement.offsetLeft;
							coords.y += targetElement.offsetTop;
						}
					}
				}
				return coords;
			}
			catch(error)
			{
				return coords;
			}
		}
//IN068145 starts
function loadgroupdtl(event_class){
	var formObj = document.grpdispdetail
	var bean_id = formObj.bean_id.value ;
	var bean_name = formObj.bean_name.value ;
	var locale = formObj.locale.value ;
	var patient_id = formObj.patient_id.value ;
	var encounter_id = formObj.encounter_id.value ;
	var from_date = formObj.from_date.value ;
	var to_date = formObj.to_date.value ;
	var grphistory_type = formObj.grphistory_type.value ;
	var orderCatalogNature = formObj.orderCatalogNature.value ;
	var normalcy = formObj.normalcy.value ;
	
	params="bean_id="+bean_id+"&bean_name="+bean_name+"&locale="+locale+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&from_date="+from_date+"&to_date="+to_date+"&loadDefaultclass="+event_class+"&grphistory_type="+grphistory_type+"&orderCatalogNature="+orderCatalogNature+"&normalcy="+normalcy
	parent.DetailsFrame.location.href="../../eCA/jsp/DisplayGroupExpanded.jsp?"+params
}
//IN068145 ENDS
//IN071374 Start.
function getFile_SH(Accessionnum)
{
	var url = "../../eCA/jsp/CAExternalDisplayNotes.jsp?accession_num="+Accessionnum
	window.open(url,'ExternalNotes','toolbar=yes,menubar=yes,scrollbars=yes,height='+screen.height+',width='+screen.width+',top=0,left=0,location=no,fullscreen=no');
}
//IN071374 End.

async function callResults(tempEventDate1,tempEventDate2,eventDesc,histRecType,tempEventClass,tempEventGroup,tempEventCode)
{
	
   
	var patientid	    = document.forms[0].patient_id.value ;	
	var encounter_id	= document.forms[0].encounter_id.value ;
	var facility_id	    = document.forms[0].fac_id.value;
	var title=getLabel("eCA.RecordingForDateTime.label","CA");
	title = title.replace("$$",eventDesc);
	title = title.replace("$$",tempEventDate2);//'tempEventDate2' is passed instead of 'tempEventDate1' modified by Archana Dhal on 11/9/2010 related to IN024920.
	
	var dialogHeight	= "32" ;
	var dialogWidth		= "42" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;

	retVal 			= await window.showModalDialog('../../eCA/jsp/FlowSheetMoreResultsMain.jsp?patientid='+patientid+'&hist_rec_type='+histRecType+'&event_class='+tempEventClass+'&event_group='+tempEventGroup+'&event_code='+tempEventCode+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&tempEventDate1='+tempEventDate1+'&title='+encodeURIComponent(title,"UTF-8"),arguments,features);
}
//31792 starts 
async function NeonatalMotherSpecimenDetails(order_id,accession_num,histDataType,patient_id)
{
	var dialogHeight ='10' ;
    var dialogWidth = '38' ;
    var dialogTop	= '129';
    var dialogLeft = '30' ;
	var title = ''
	//var patient_id=document.forms[0].patient_id.value;	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	var retVals = await window.showModalDialog("../../eOR/jsp/NeoNatalMotherSpecimenDetails.jsp?p_order_id="+order_id+"&accession_num="+encodeURIComponent(accession_num)+"&history_type="+histDataType+"&patient_id="+patient_id,arguments,features);
	
}
//31792 ends 

