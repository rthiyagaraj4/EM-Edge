/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
12/11/2020		IN073728	Nijithas		12/11/2020		Ramesh G		MO-CRF-20101.16
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10
22/07/2022		32036			Ramesh G		22/07/2022		Ramesh G 			PMG2022-Common-CRF-0001
---------------------------------------------------------------------------------------------------------------
*/ 
function scrollFrame(){
	parent.eventNamesFrame.document.body.scrollTop=
	parent.eventDataFrame.document.body.scrollTop;
	setTimeout("scrollTitle()",50);
}

function scrollTitle(){
	var x = parent.eventDataFrame.document.body.scrollTop;
	var y = parent.eventNamesFrame.document.body.scrollTop;	
	if(y == 0){
		parent.eventDataFrame.document.getElementById("divDataTitle").style.position = 'static';
		parent.eventDataFrame.document.getElementById("dataTitleTable").style.position = 'static';
		parent.eventDataFrame.document.getElementById("divDataTitle").style.posTop  = 0;
		parent.eventNamesFrame.document.getElementById("divUnitTitle").style.position = 'static';
		parent.eventNamesFrame.document.getElementById("unitTitleTable").style.position = 'static';
		parent.eventNamesFrame.document.getElementById("unitTitleTable").style.posTop  = y;
	}else{
		parent.eventNamesFrame.document.getElementById("divUnitTitle").style.position = 'relative';
		parent.eventNamesFrame.document.getElementById("unitTitleTable").style.position = 'relative';
		parent.eventNamesFrame.document.getElementById("unitTitleTable").style.posTop  = y;
		parent.eventDataFrame.document.getElementById("divDataTitle").style.position = 'relative';
		parent.eventDataFrame.document.getElementById("dataTitleTable").style.position = 'relative';
		parent.eventDataFrame.document.getElementById("divDataTitle").style.posTop  = y;
	}
}
function datesScrollFrame(){
	var y = parent.eventDateFrame.document.body.scrollTop;
	if(y == 0){
		parent.eventDateFrame.document.getElementById("divDateTitle").style.position = 'static';
		parent.eventDateFrame.document.getElementById("dateTitleTable").style.position = 'static';
		parent.eventDateFrame.document.getElementById("divDateTitle").style.posTop  = 0;		
	}else{		
		parent.eventDateFrame.document.getElementById("divDateTitle").style.position = 'relative';
		parent.eventDateFrame.document.getElementById("dateTitleTable").style.position = 'relative';
		parent.eventDateFrame.document.getElementById("divDateTitle").style.posTop  = y;
	}
}
function moveScroll( position,histType,eventGrp,pos_value){
	if(histType=='LBIN'){
		var positionVal = ((position-1)*150);
		parent.eventDataFrame.window.scrollTo(positionVal, 0);	
	}else if(histType=='CLNT'||histType=='RDIN'||histType=='SUNT'||histType=="MERP"){//6450
		expendedNotes(position,"EXPDATE");		
	}else if(histType=='MEDN'){//Adding start for //IN072762
		if(eventGrp =="D"){
		var elmnt = parent.eventDataFrame.f_query_result.document.getElementById('table_container_right').document.getElementById(pos_value);
		    parent.eventDataFrame.f_query_result.document.getElementById('table_container_right').scrollTop = (elmnt.offsetTop)-40;
		}else{
			var elmnt = parent.eventDataFrame.f_query_result.document.getElementById(pos_value);
			
		    parent.eventDataFrame.f_query_result.document.getElementById('patinsID').scrollTop = (elmnt.offsetTop)-40;
		}//Adding end for //IN072762

	}
}
function alignDivs(){
	var x = document.body.clientHeight;
	var y = document.body.clientWidth;
}
function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	eval(document.getElementById(str).focus());
	return flg;
}
function chkDateTime(toDate,format,locale)
{
	if(toDate.value != '') 
	{		
		var from_date = document.getElementById("from_date");
		var to_date = document.getElementById("to_date")
		if(validDateObj(toDate,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				chkToDate(from_date,to_date,format,locale);
			}
		}
	}
}
function chkToDate(fromDate,toDate,format,locale)
{	
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			fromDate.select();
			fromDate.focus();
			fromDate.value="";
			return false;
				
		}else
		{ 
		  if( toDate.value != "")
			{
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						toDate.select();
						toDate.focus();
						toDate.value="";
						return false;
					}
				}
				else
				  {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					toDate.select();
					toDate.focus();
					toDate.value="";
					return false;
				  }
			}
		}
	}else
	{		
		if((toDate.value!=""))
		{
		  if(!isBeforeNow(toDate.value, format, locale))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				toDate.select();
				toDate.focus();
				toDate.value="";
				return false;
			}
		}
	}
}
function populateValues(hist,called_from){//IN073728

	var from_date		= document.forms[0].from_date.value; 
	var todate			= document.forms[0].to_date.value; 
	var encounter_id	= document.forms[0].encounter_id.value;
	var facility_id		= document.forms[0].fac_id_sel.value;
	var patient_id		= document.forms[0].patient_id.value;
	var enc_id		= document.forms[0].enc_id.value;
  	var relationship_id		= document.forms[0].relationship_id.value;
    //IN069654 starts
	var ql_ref	= document.forms[0].ql_ref.value;
	var personal_view	= "";
	var fromDate		= "";
	var encounterid		= "";
	var normalcy_ind	= "";
	var toDate			= "";
	var abnormal		= "";
	var view_by			= "";
	var facility		= "";
	var patient_class	= "";
	var event_group     = "";
	var event_groupDesc = "";
	var event_Item      = "";
	var event_ItemDesc  = "";
	var event_class		= "";
	var def_facility    = "";
	var date_Ordr 		= "";
	var ql_facility_id ="";
	var grphistory_type="";//IN071596
	if(ql_ref!="")
	{//IN073728 Starts
		grphistory_type = document.forms[0].grphistory_type.value;
		var selHistType="";
		if(null!=  document.getElementById("histSelectedCriteria") &&   undefined!=document.getElementById("histSelectedCriteria"))
		{
			selHistType =  document.getElementById("histSelectedCriteria").value;
			
		}
		if(selHistType==""){
			selHistType = "LBIN";
		}
		if("*ALL" == grphistory_type)
		{
			
			if((undefined == hist || ""==hist) && "ONLOAD" == called_from)
				grphistory_type = "LBIN";
			else if(""!=selHistType){
				grphistory_type = selHistType;
			}
			else
				grphistory_type = hist;
			personal_view	=document.getElementById("default_personalView"+grphistory_type).value;
				
			normalcy_ind	= document.getElementById("default_normalcyInd"+grphistory_type).value;			
			abnormal		= document.getElementById("default_abnormal"+grphistory_type).value;
			view_by			=document.getElementById("default_viewBy"+grphistory_type).value; 
			patient_class	= document.getElementById("default_patientClass"+grphistory_type).value; 
			event_group     =  document.getElementById("default_eventGroup"+grphistory_type).value;
			event_groupDesc = document.getElementById("default_eventGroupDesc"+grphistory_type).value;
			event_Item      = document.getElementById("default_eventItem"+grphistory_type).value;
			event_ItemDesc  =document.getElementById("default_eventItemDesc"+grphistory_type).value; 
			event_class		= document.getElementById("default_eventClass"+grphistory_type).value;
			
			date_Ordr		= document.getElementById("default_date"+grphistory_type).value; 
		
			if("ONCLICK"!=called_from)
			{
			
				encounterid		= document.getElementById("default_encounterid"+grphistory_type).value;
				ql_facility_id	= document.getElementById("def_facility"+grphistory_type).value;
				fromDate		= document.getElementById("default_fromDate"+grphistory_type).value;
				toDate			= document.getElementById("default_toDate"+grphistory_type).value;
				
				document.getElementById("encounter_id").value = encounterid; 
				document.getElementById("fac_id_sel").value = ql_facility_id; 
				document.getElementById("from_date").value = fromDate;
				document.getElementById("to_date").value = toDate;
			}
			
		}
		else//IN073728
		{
		personal_view	= document.forms[0].default_personalView.value;
		fromDate		= document.forms[0].default_fromDate.value;
		encounterid		= document.forms[0].default_encounterid.value;
		normalcy_ind	= document.forms[0].default_normalcyInd.value;
		toDate			= document.forms[0].default_toDate.value;
		abnormal		= document.forms[0].default_abnormal.value;
		view_by			= document.forms[0].default_viewBy.value;
		//facility		= document.forms[0].default_facility.value;
		patient_class	= document.forms[0].default_patientClass.value;
		event_group     = document.forms[0].default_eventGroup.value;
		event_groupDesc = document.forms[0].default_eventGroupDesc.value;
		event_Item      = document.forms[0].default_eventItem.value;
		event_ItemDesc  = document.forms[0].default_eventItemDesc.value;
		event_class		= document.forms[0].default_eventClass.value;
		 ql_facility_id	= document.forms[0].def_facility.value
		date_Ordr		= document.forms[0].default_date.value;
		//grphistory_type = document.forms[0].grphistory_type.value;//IN073728
		}
	}
	if(ql_ref!=""){
  			//parent.ClinicialEventHistoryDetailsFrame.location.href = "../../eCA/jsp/ClinicalEventHistoryDetails.jsp?from_date="+from_date+"&to_date="+todate+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&patient_id="+patient_id+"&relationship_id="+relationship_id+"&event_groupDesc="+event_groupDesc+"&event_Item="+event_Item+"&event_ItemDesc="+event_ItemDesc+"&event_class="+event_class+"&abnormal="+abnormal+"&view_by="+view_by+"&patient_class="+patient_class+"&event_group="+event_group+"&normalcy_ind="+normalcy_ind+"&toDate="+toDate+"&personal_view="+personal_view+"&fromDate="+fromDate+"&encounterid="+encounterid+"&ql_ref="+ql_ref+"&date_Ordr="+date_Ordr+"&def_facility="+ql_facility_id //IN069654//IN071596
			parent.ClinicialEventHistoryDetailsFrame.location.href = "../../eCA/jsp/ClinicalEventHistoryDetails.jsp?from_date="+from_date+"&to_date="+todate+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&patient_id="+patient_id+"&relationship_id="+relationship_id+"&event_groupDesc="+event_groupDesc+"&event_Item="+event_Item+"&event_ItemDesc="+event_ItemDesc+"&event_class="+event_class+"&abnormal="+abnormal+"&view_by="+view_by+"&patient_class="+patient_class+"&event_group="+event_group+"&normalcy_ind="+normalcy_ind+"&toDate="+toDate+"&personal_view="+personal_view+"&fromDate="+fromDate+"&encounterid="+encounterid+"&ql_ref="+ql_ref+"&date_Ordr="+date_Ordr+"&def_facility="+ql_facility_id+"&grphistory_type="+grphistory_type //IN069654////IN071596
      }
		else //IN069654 ends
			parent.ClinicialEventHistoryDetailsFrame.location.href = "../../eCA/jsp/ClinicalEventHistoryDetails.jsp?from_date="+from_date+"&to_date="+todate+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&patient_id="+patient_id+"&relationship_id="+relationship_id;
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
	
	
	var retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?qsForComments="+qsForComments+"&quickTextCodes="+tempValues+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&fac_id="+fac_id+"&enctr_id="+enctr_id,'',features);//IN033489
	
	
	if(retVal != null && retVal != undefined && retVal != "")
	{
		//self.location.reload();
		parent.dataFrame.location = parent.dataFrame.location;
	}
	return false;		
}
function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extimageapplid)
{
	
	/*if(messageFrameReference == null) //added for the condition, called_from = "OR" in FlowSheetEvents.jsp
	{
		messageFrameReference = 	top.content.messageFrame;
	}*/
	var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head> <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAOpenExternalApplication.jsp'><input type=hidden name=Histrectype value='"+Histrectype+"'><input type=hidden name=Contrsysid value='"+Contrsysid+"'><input type=hidden name=Accessionnum value='"+escape(Accessionnum)+"'><input type=hidden name=Contrsyseventcode value='"+Contrsyseventcode+"'><input type=hidden name=extimageapplid value='"+extimageapplid+"'></form></body></html>"

	top.content.messageFrame.document.write(htmlVal);
	top.content.messageFrame.document.tempForm.submit();
 
}
async function viewUploadedImg(showImageLocn)
{
	var dialogHeight	= "32vh" ;
	var dialogWidth		= "42vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	var arguments		="";
	await top.window.showModalDialog(showImageLocn,"",arguments,features);
}
function getExtLink(patient_id, encounter_id, accession_no, order_id, facility_id, locale, login_user, resp_id, login_at_ws_no, order_type_code, op_episode_visit_num, attend_practitioner_id, assign_care_locn_type, assign_care_locn_code, visit_adm_date,  patient_class, locn_desc,ext_image_appli_id, ext_image_obj_id, ext_image_source, ext_srce_doc_ref_no, ext_srce_doc_ref_line_no) {

	var Ext_Application_ID = ext_image_appli_id; 
	var Ext_Function = 'VIEW'; 
	var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+escape(accession_no)+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class+'&P_Ext_Application_ID='+Ext_Application_ID+'&P_Ext_Function='+Ext_Function+'&P_DOC_ID='+ext_image_obj_id; //modified for IN048253 
	dispExtApp(qry_string);	  //dispExtApp function avalible on ExternalApplication.js of eXH Module. 
}
//IN070032 starts
function run(accession_num,eventCode,facilty,performing_facilty){ //32036 performing_facilty
	var login_user=document.getElementById("login_user").value;
	//32036 Start.
	//var operating_facility_id=document.getElementById("performing_facility_id").value;
	var operating_facility_id=performing_facilty;
	//32036 End.
	var facility_id=document.getElementById("facilityid").value;
	var req_date=document.getElementById("REQ_DATE").value;
	var session_id=document.getElementById("session_id").value;
	var locale=document.getElementById("locale").value;
	var patient_id=document.getElementById("patient_id").value;
	var machine_name=document.getElementById("machine_name").value;
	var reqdate=document.getElementById("reqdate").value;
	var  report_id='RLRRSENQ';
	var  p_module_id='RL';
	var report=document.getElementById("report").value;
	var server=document.getElementById("server").value;
	var copies=document.getElementById("copies").value;
	var queue_name=document.getElementById("queue_name").value;
	var  message=document.getElementById("message").value;
	var app_server_ip=document.getElementById("app_server_ip").value;
	var rep_server_key=document.getElementById("rep_server_key").value;
	var report_Server=document.getElementById("report_Server").value;
	var desformat=document.getElementById("desformat").value;
	var report_option=document.getElementById("report_option").value;
	var self_submit=document.getElementById("self_submit").value;
	var destype=document.getElementById("destype").value;
	var userid=document.getElementById("userid").value;
	
	var urlVal = "../../eCA/jsp/NewCEHIntermediate.jsp?accession_num="+accession_num+"&facilty="+facilty+"&req_date="+req_date+"&login_user="+login_user+"&operating_facility_id="+operating_facility_id+"&facility_id="+facility_id+"&login_user="+login_user+"&report_id="+report_id+"&p_module_id="+p_module_id+"&eventCode="+eventCode+"&session_id="+session_id+"&patient_id="+patient_id+"&machine_name="+machine_name+"&reqdate="+reqdate+"&p_language_id="+locale+"&Mode=ViewResult";
	$.ajax({		type: "Post",
		url	:	urlVal,
		data	: "",
		dataType:"text",
		async:false,
		success: function(data){
		},
		error: function(data){
		}
	});
	window.open(report_Server+"?"+"server="+server+"+"+"report="+report+"+"+"desformat="+desformat+"+"+"destype="+destype+"+"+"recursive_load=no"+"+"+"userid="+userid+"+"+"SELF_SUBMIT="+self_submit+"+"+"REPORT_OPTION="+report_option+"+"+"P_SPECIMEN_NO="+accession_num+"+"+"USER_ID="+login_user+"+"+"OPERATING_FACILITY_ID="+operating_facility_id+"+"+"FACILITY_ID="+facilty+"+"+"REQ_DATE="+req_date+"+"+"SESSION_ID="+session_id+"+"+"P_LANGUAGE_ID="+locale+"+"+"P_REPORT_ID="+report_id+"+"+"P_MODULE_ID=" +p_module_id+ "+" + "P_LANGUAGE_ID="+locale)
	/*var HTMLVal="<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()'> <form name=tempForm action='../../eCommon/jsp/report_options.jsp'><input type=hidden name='p_specimen_no' id='p_specimen_no' value='"+accession_num+"'><input type=hidden name='user_id' id='user_id' value='"+login_user+"'><input type=hidden name='operating_facility_id' id='operating_facility_id' value='"+operating_facility_id+"'><input type=hidden name='facility_id' id='facility_id' value='"+facility_id+"'><input type=hidden name='req_date' id='req_date' value='"+req_date+"'><input type=hidden name='session_id' id='session_id' value='"+session_id+"'><input type=hidden name='p_language_id' id='p_language_id' value='"+locale+"'><input type=hidden name='p_report_id' id='p_report_id' value='"+report_id+"'><input type=hidden name='p_module_id' id='p_module_id' value='"+p_module_id+"'></form></body></html>";
		top.frames[1].frames[1].document.write(HTMLVal);
		top.frames[1].frames[1].document.tempForm.submit();*/
}
//IN070032 ends
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
	 toolTip1 = toolTip1=toolTip1.replace(/#96/g,"`");
	 toolTip1 = toolTip1=toolTip1.replace(/#39/g,"'");
	 toolTip1 = toolTip1=toolTip1.replace(/#34/g,'"');
 	 toolTip1 = toolTip1=toolTip1.replace(/~ /g,"<BR>");
	 toolTip1 = toolTip1=toolTip1.replace(/#126/g,"~");

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
function alignHeight()
{
	/*var totalTitleRows = parent.eventDataFrame.document.getElementById("dataTitleTable").rows.length;
	for(var i=0;i<totalTitleRows;i++){
		var thgt = parent.eventDataFrame.document.getElementById("dataTitleTable").rows(i).offsetHeight;
		var thgt1 =parent.eventNamesFrame.document.getElementById("unitTitleTable").rows(i).offsetHeight;				
		if(thgt > thgt1){
			parent.eventNamesFrame.document.getElementById("unitTitleTable").rows(i).height = thgt;
		}else if(thgt < thgt1){
			parent.eventDataFrame.document.getElementById("dataTitleTable").rows(i).height = thgt1;				
		}
		
	}
	*/
	var totalRows =  parent.eventDataFrame.document.getElementById("dataTable").rows.length;
	var totalRows =  parent.eventNamesFrame.document.getElementById("unitTable").rows.length;
	var counter = eval(totalRows);
	for(var i=0;i<counter-1;i++){
		var hgt=parent.eventDataFrame.document.getElementById("dataTable").rows(i).offsetHeight;
		var hgt1=parent.eventNamesFrame.document.getElementById("unitTable").rows(i).offsetHeight;	

		if(hgt > hgt1){
			parent.eventNamesFrame.document.getElementById("unitTable").rows(i).height = hgt;
		}else if(hgt < hgt1){
			parent.eventDataFrame.document.getElementById("dataTable").rows(i).height = hgt1;				
		}
	}
}
function constructValsForGraph(rowNumber)
{

	var obj = eval(document.getElementById('chkGraphID'+rowNumber));

	if(parent.eventNamesFrame.document.forms[0] != null)
	{
		var noOfChkdBoxes =  parseInt(parent.eventNamesFrame.document.forms[0].noOfChkdBoxes.value);

		if(obj.checked == true)
		{
			if(noOfChkdBoxes > 9)
			{
				alert(getMessage('NO_OF_EVENTS_MORE_THAN_10','CA'));
				obj.checked = false;
				return false;
			}
			else
				parent.eventNamesFrame.document.forms[0].noOfChkdBoxes.value = noOfChkdBoxes+1;
		}
		else if(obj.checked == false)
			parent.eventNamesFrame.document.forms[0].noOfChkdBoxes.value = noOfChkdBoxes-1;

		var patient_id = parent.eventNamesFrame.document.eventForm.patient_id.value;
		var encounter_id = parent.eventNamesFrame.document.eventForm.encounter_id.value;
		var enc_id = parent.eventDataFrame.document.eventDataForm.enc_id.value;

		if((encounter_id=="")||(encounter_id==null)||(encounter_id=="null"))
			encounter_id =0;

		if((enc_id=="")||(enc_id==null)||(enc_id=="null"))
			enc_id =0; 

		var colCount = parseInt(parent.eventDataFrame.document.eventDataForm.finalTotCols.value,10);
		var tdObj;
		var tdObjValue;
		var concTdObjValues = "";
		
		var code = eval(document.getElementById('chkGraphID'+rowNumber)).value;
		var desc = eval(document.getElementById('desc'+rowNumber)).value;
		var UOM = eval(document.getElementById('UOM'+rowNumber)).value;

		for(var j=0;j<colCount;j++)
		{
			tdObj = eval(parent.eventDataFrame.document.getElementById('hidden'+parseInt(rowNumber,10)+"Values"+j));
			if(tdObj != null)
			{
				tdObjValue = tdObj.value;
				concTdObjValues = concTdObjValues + tdObjValue +">";

			}
		}
		parent.parent.addToGroupsFrame.document.write("<html><form name='chartRecAddToGrpFrom' id='chartRecAddToGrpFrom' action='../../eCA/jsp/ChartRecordingAddToGrpIntermediate.jsp'><input type='hidden' name='ChkdBoxes' id='ChkdBoxes' value = '"+obj.checked+"'><input type='hidden' name='desc' id='desc' value = '"+encodeURIComponent(desc,"UTF-8")+"'><input type='hidden' name='code' id='code' value = '"+code+"'><input type='hidden' name='concTdObjValues' id='concTdObjValues' value = '"+concTdObjValues+"'><input type='hidden' name='uom' id='uom' value = '"+UOM+"'><input type='hidden' name='patient_id' id='patient_id' value = '"+patient_id+"'><input type='hidden' name='encounter_id' id='encounter_id' value = '"+enc_id+"'><input type='hidden' name='flowsheetGraph' id='flowsheetGraph' value = 'Y'></form></html>");
		parent.parent.addToGroupsFrame.document.chartRecAddToGrpFrom.submit();
	}

}
async function openGraph1()
{
	/*
	if(top.content != null)
		top.content.workAreaFrame.details.eventDataFrame.document.forms[0].graphValuesOnChk.value = "";
	else
		parent.parent.details.eventDataFrame.document.forms[0].graphValuesOnChk.value = "";
	*/
	var Obj=parent.parent.ClinicialEventHistoryDetailsFrame.eventNamesFrame
	var Obj1=parent.parent.ClinicialEventHistoryDetailsFrame.eventDataFrame
	if(Obj.document.getElementById("chkGraph")){
		var check=0;
		var eventKeys = "";
		var resultNum = "";
		var resultUOM = "";
		var eventDesc = "";
		var eventDate = "";
		var tempeventKeys = "";
		var totCols = "";
		totCols = Obj1.document.getElementById("finalTotCols").value;

		if(Obj.document.forms[0].noOfChkdBoxes.value == 0)
		{
			alert(getMessage("NO_EVENTS_SELECTED","CA"));
			return;
		}

		for(var r=0;r<resultUOM.length;r++)
		{
			resultUOM = resultUOM.replace(" ","#");
		}

		for(var t=0;t<eventDesc.length;t++)
		{
			eventDesc = eventDesc.replace(" ","?");
		}

		var tempRowValues = " ";
		var totCols = "";		
		var totRows = "";
		totCols = Obj1.document.forms[0].finalTotCols.value;
		totRows = Obj.document.forms[0].rowsForGraph.value;
	


		var testVar = "";
		var chkTest = "";

		for(var y=0;y<parseInt(totRows,10);y++)
		{	
			tempRowValues = "";
			chkTest = eval("document.forms[0].chkGraphID"+y);
			if(chkTest != undefined && chkTest != null && (chkTest.checked)) 
			{
				for(var t=0;t<parseInt(totCols,10);t++)
				{

					testVar = eval(Obj1+".document.forms[0].hidden"+y+"Values"+t);
					
					tempRowValues += ">"+testVar.value;
				}
				Obj1.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
			}
		}
			var tempGrafValues = ""; 
			
			tempGrafValues = Obj1.document.forms[0].graphValuesOnChk.value;


			var totalRows = Obj.document.forms[0].totRows.value;
			var totalCols = Obj1.document.forms[0].finalTotCols.value;
			var visID = "";
		/*	var hiddenColumns = "";
			for(var i=0;i<totalCols;i++)
			{
				visID = eval("parent.eventDataFrame.document.getElementById("visID")"+i);
				hiddenColumns += "!!" + visID.innerText;
			}
			parent.eventDataFrame.document.dataForm.hiddenColumns.value = hiddenColumns;			
*/
		var numOfchkedBoxes =  parseInt(Obj.document.forms[0].noOfChkdBoxes.value);

		var noOfGroups = Obj1.document.forms[0].noOfGroups.value;
		var allDatesForGraph = Obj1.document.forms[0].allDatesForGraph.value;
		var patient_id =Obj.document.forms[0].patient_id.value;

		var encounter_id = Obj1.document.forms[0].enc_id.value;
		if(encounter_id==null||encounter_id=="null"||encounter_id=="")
			 encounter_id =0;
	
		var dialogTop		=	"90" ;
		var dialogHeight= "100" ;
		var dialogWidth = "80" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;	
		var action_url		=	'../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?noOfGroups='+noOfGroups+'&numOfchkedBoxes='+numOfchkedBoxes+'&flowsheetGraph=Y&allDatesForGraph='+allDatesForGraph+'&patient_id='+patient_id+'&encounter_id='+encounter_id;
		var retVal=await window.showModalDialog(action_url,arguments,features);		
		if(retVal != undefined)
		{
			Obj1.document.dataForm.noOfGroups.value = retVal;
		}
	}
	else
	{		
			alert(getMessage("NO_EVENTS_SELECTED","CA"));
			return;
		
	}
}

function clearLayer()
{
	hidePopUp();
}
function tab_clickAdd(id) 
	{	
		var selHistType = document.forms[0].histSelected.value;//ADding start for IN073751
	    
		if(selHistType =="MEDN" && id =="")
		     	id =document.forms[0].tab_click.value;//ADding end for IN073751
		document.forms[0].tabSelected.value=id;
		if(id=="self_tab"){
			document.getElementById("self_tab").value='Y';
			document.getElementById("self_tab").className='tabClicked'
			document.getElementById("self_tabspan").className='tabSpanclicked';
			document.getElementById("ql_tab").value='S'; 
		}
		else{
			document.getElementById("self_tab").value='N';
			document.getElementById("self_tab").className='tabA'
			document.getElementById("self_tabspan").className='tabAspan';
		}
		
		if(id=="my_tab"){
			document.getElementById("my_tab").value='Y';
			document.getElementById("my_tab").className='tabClicked'
			document.getElementById("my_tabspan").className='tabSpanclicked';
			document.getElementById("ql_tab").value='M'; 
		}
		else{
			document.getElementById("my_tab").value='N';
			document.getElementById("my_tab").className='tabA'
			document.getElementById("my_tabspan").className='tabAspan';
		}
		if(id=="all_tab"){
			document.getElementById("all_tab").value='Y';
			document.getElementById("all_tab").className='tabClicked'
			document.getElementById("all_tabspan").className='tabSpanclicked';
			document.getElementById("ql_tab").value='A'; 
		}
		else{
			document.getElementById("all_tab").value='N';
			document.getElementById("all_tab").className='tabA'
			document.getElementById("all_tabspan").className='tabAspan';
		}
		populateDates(); //Ramesh
	}


	function selHistType(hist,histSeq)
	{ 
		var totalHistTypesCount=document.forms[0].totalHistTypes.value;
		for(var i=0;i<totalHistTypesCount;i++){
			if(i==histSeq){
				document.getElementById("histTab"+i).className='tabClicked'
				document.getElementById("histTabSpan"+i).className='tabSpanclicked';
			}else{
				document.getElementById("histTab"+i).className='tabA'
				document.getElementById("histTabSpan"+i).className='tabAspan';
			}
		}
		document.forms[0].histSelected.value=hist;
		parent.parent.frames[0].document.getElementById("histSelectedCriteria").value=document.forms[0].histSelected.value; //IN073728
		if(hist=="LBIN"){
			document.getElementById("ViewByLabID").style.display="inline";
			document.getElementById("ViewByCLNTID").style.display="none";
			document.getElementById("ViewByOtherID").style.display="none";
			document.getElementById("ViewByMEDNID").style.display="none";//Added for MO-CRF-20101.11
		}else if(hist=="CLNT"||hist=="RDIN"||hist=="SUNT"||hist=="MERP"){//6450
			document.getElementById("ViewByLabID").style.display="none";
			document.getElementById("ViewByCLNTID").style.display="inline";
			document.getElementById("ViewByOtherID").style.display="none";
			document.getElementById("ViewByMEDNID").style.display="none";//Added for MO-CRF-20101.11
		}else if(hist=="MEDN"){//Adding start for MO-CRF-20101.11
			document.getElementById("ViewByLabID").style.display="none";
			document.getElementById("ViewByCLNTID").style.display="none";
			document.getElementById("ViewByOtherID").style.display="none";
			document.getElementById("ViewByMEDNID").style.display="inline";
		}else{//Adding end for MO-CRF-20101.11
			document.getElementById("ViewByLabID").style.display="none";
			document.getElementById("ViewByCLNTID").style.display="none";
			document.getElementById("ViewByOtherID").style.display="inline";
			document.getElementById("ViewByMEDNID").style.display="none";
		}
		
		populateDates('selHistType');//IN073728
	}


	function populateDates(calledFrom)//IN073728
	{
		var grphistory_type			=parent.parent.frames[0].document.getElementById("grphistory_type").value; //IN073728
	
		var selHistType = document.forms[0].histSelected.value
		var selTab      = document.forms[0].tabSelected.value
		
		//IN069654 starts
	
		//IN073728 Starts
		var queryStr;
		if("*ALL" == grphistory_type )
		{
				
			var patient_id		= parent.parent.frames[0].document.getElementById("patient_id").value;
		  	var relationship_id		= parent.parent.frames[0].document.getElementById("relationship_id").value;
			
			var ql_ref      = document.forms[0].ql_ref.value;
			var ql_tab      = parent.parent.frames[0].document.getElementById("default_personalView"+selHistType).value; 
			var abnormal      = parent.parent.frames[0].document.getElementById("default_abnormal"+selHistType).value;
			var ql_nlcyInd      = parent.parent.frames[0].document.getElementById("default_normalcyInd"+selHistType).value;
			var ql_viewBy      = parent.parent.frames[0].document.getElementById("default_viewBy"+selHistType).value; 
			var ql_patClass      = parent.parent.frames[0].document.getElementById("default_patientClass"+selHistType).value; 
			var eventGrp      =parent.parent.frames[0].document.getElementById("default_eventGroup"+selHistType).value;
			var ql_evntGrpDsc      = parent.parent.frames[0].document.getElementById("default_eventGroupDesc"+selHistType).value;
			var eventItem      =parent.parent.frames[0].document.getElementById("default_eventItem"+selHistType).value;
			var ql_evntItmDsc      = parent.parent.frames[0].document.getElementById("default_eventItemDesc"+selHistType).value; 
			var eventCls      =  parent.parent.frames[0].document.getElementById("default_eventClass"+selHistType).value;
			var def_facility	= parent.parent.frames[0].document.getElementById("def_facility"+selHistType).value;
			var date_Ordr		= parent.parent.frames[0].document.getElementById("default_date"+selHistType).value;
			var encounter_id   = parent.parent.frames[0].document.getElementById("default_encounterid"+selHistType).value;
			var from_date      =parent.parent.frames[0].document.getElementById("default_fromDate"+selHistType).value; 
			var to_date        = parent.parent.frames[0].document.getElementById("default_toDate"+selHistType).value;
			var status          = document.forms[0].status.value; //IN072762
			var generic_id      =document.forms[0].generic_id.value;//IN072762
			var drug_id           = document.forms[0].ql_evntItm.value//IN072762
			var item_type      = parent.parent.frames[0].document.getElementById("default_eventGroup"+selHistType).value;
			var order_type     =  parent.parent.frames[0].document.getElementById("default_eventClass"+selHistType).value;
		
		
			if(ql_ref!=""){
				selTab      = document.forms[0].ql_tab.value;
			}
			if(document.forms[0].drug_name.value=="")//IN072762
	               drug_id="";
			if(document.forms[0].generic_name.value=="")//IN072762
	               generic_id="";
		
			if( "selHistType"==calledFrom)
			{
					
					
				parent.parent.frames[0].document.getElementById("from_date").value = from_date; 
				parent.parent.frames[0].document.getElementById("to_date").value = to_date;
				parent.parent.frames[0].document.getElementById("fac_id_sel").value = def_facility; 
				parent.parent.frames[0].document.getElementById("encounter_id").value = encounter_id; 
				
				if(ql_tab=="S"){
					document.getElementById("self_tab").value='Y';
					document.getElementById("self_tab").className='tabClicked'
					document.getElementById("self_tabspan").className='tabSpanclicked';
					document.getElementById("ql_tab").value='S'; 
				}
				else{
					document.getElementById("self_tab").value='N';
					document.getElementById("self_tab").className='tabA'
					document.getElementById("self_tabspan").className='tabAspan';
				}
				
				if(ql_tab=="M"){
					document.getElementById("my_tab").value='Y';
					document.getElementById("my_tab").className='tabClicked'
					document.getElementById("my_tabspan").className='tabSpanclicked';
					document.getElementById("ql_tab").value='M'; 
				}
				else{
					document.getElementById("my_tab").value='N';
					document.getElementById("my_tab").className='tabA'
					document.getElementById("my_tabspan").className='tabAspan';
				}
				if(ql_tab=="A"){
					document.getElementById("all_tab").value='Y';
					document.getElementById("all_tab").className='tabClicked'
					document.getElementById("all_tabspan").className='tabSpanclicked';
					document.getElementById("ql_tab").value='A'; 
				}
				else{
					document.getElementById("all_tab").value='N';
					document.getElementById("all_tab").className='tabA'
					document.getElementById("all_tabspan").className='tabAspan';
				}
				selTab      = document.forms[0].ql_tab.value;
			}
			else if( "medTab"==calledFrom)
			{
				from_date = 	parent.parent.frames[0].document.getElementById("from_date").value;
				to_date =	parent.parent.frames[0].document.getElementById("to_date").value;
				def_facility = parent.parent.frames[0].document.getElementById("fac_id_sel").value; 
				encounter_id = parent.parent.frames[0].document.getElementById("encounter_id").value;			
				item_type      =  parent.eventDataFrame.f_tabs_frame.document.getElementById("item_type").value;
				
			}
			else{
				
				from_date = 	parent.parent.frames[0].document.getElementById("from_date").value;
				to_date =	parent.parent.frames[0].document.getElementById("to_date").value;
				def_facility = parent.parent.frames[0].document.getElementById("fac_id_sel").value; 
				encounter_id = parent.parent.frames[0].document.getElementById("encounter_id").value;
			}
			
			queryStr = "from_date="+from_date+"&to_date="+to_date+"&encounter_id="+encounter_id+"&facility_id="+def_facility+"&patient_id="+patient_id+"&relationship_id="+relationship_id+"&grphistory_type="+selHistType;
			
		}
		else{//IN073728 Ends
		var ql_ref      = document.forms[0].ql_ref.value
		var ql_tab      = document.forms[0].ql_tab.value
		var abnormal      = document.forms[0].ql_abnrml.value
		var ql_nlcyInd      = document.forms[0].ql_nlcyInd.value
		var ql_viewBy      = document.forms[0].ql_viewBy.value
		var ql_patClass      = document.forms[0].ql_patClass.value
		var eventGrp      = document.forms[0].ql_evntGrp.value
		var ql_evntGrpDsc      = document.forms[0].ql_evntGrpDsc.value
		var eventItem          = document.forms[0].ql_evntItm.value
		var drug_id            = document.forms[0].ql_evntItm.value//IN072762
		var ql_evntItmDsc      = document.forms[0].ql_evntItmDsc.value
		var eventCls      = document.forms[0].evntClss.value
		var def_facility      = document.forms[0].facility_id.value
		date_Ordr			= document.forms[0].date_Ordr.value;
		var status          = document.forms[0].status.value; //IN072762
		var generic_id      =document.forms[0].generic_id.value;//IN072762
		var item_type      = document.forms[0].ql_evntGrp.value;//IN072762
		var order_type     = document.forms[0].evntClss.value;//IN072762
		var patient_id     = document.forms[0].patient_id.value;//IN073751
		var encounter_id   = document.forms[0].encounter_id.value;//IN073751
		var patient_class  = document.forms[0].patient_class.value;//IN073751
		var from_date      = document.forms[0].from_date.value;//IN073751
		var to_date        = document.forms[0].to_date.value;//IN073751
		var pract_id       = document.forms[0].pract_id.value;//IN073751
		var def_fec_id     = document.forms[0].def_facility.value;//IN073816
		if(ql_ref!=""){
			selTab      = document.forms[0].ql_tab.value
		
		}
		if(document.forms[0].drug_name.value=="")//IN072762
               drug_id="";
		if(document.forms[0].generic_name.value=="")//IN072762
               generic_id="";
		 //IN069654 ends
		 queryStr    = document.forms[0].queryString.value
		}//IN073728
		if(document.forms[0].group_panel[0].checked)			
			 orderCatalogNature=document.forms[0].group_panel[0].value;	
		else if(document.forms[0].group_panel[1].checked)			
			orderCatalogNature=document.forms[0].group_panel[1].value;
	
		//var queryStr    = document.forms[0].queryString.value//IN073728
		parent.eventDataFrame.location.href="../../eCommon/html/blank.html"; //IN071596
		parent.eventNamesFrame.location.href="../../eCommon/html/blank.html"; //IN071596

		if(selHistType =="MEDN"){//Adding start for IN073884
                 if(selTab == "S")
					tab_click="self_tab";
			else if(selTab == "M")
					tab_click="my_tab";
			else
					tab_click="all_tab";
			document.forms[0].tab_click.value =tab_click;
		}
		//IN073728 Starts
		 if( "medTab"==calledFrom)
		 {
			 item_type      =  parent.eventDateFrame.document.getElementById("item_type").value;
		 }
		//IN073728 Ends
		parent.eventDateFrame.location.href="../../eCA/jsp/ClinicalEventHistoryResultDates.jsp?"+queryStr+"&selHistType="+selHistType+"&selTab="+selTab+"&orderCatalogNature="+orderCatalogNature+"&ql_viewBy="+ql_viewBy+"&ql_nlcyInd="+ql_nlcyInd+"&abnormal="+abnormal+"&ql_ref="+ql_ref+"&eventItem="+eventItem+"&ql_evntGrpDsc="+ql_evntGrpDsc+"&eventGrp="+eventGrp+"&ql_patClass="+ql_patClass+"&eventCls="+eventCls+"&ql_evntItmDsc="+ql_evntItmDsc+"&date_Ordr="+date_Ordr+"&def_facility="+def_facility+"&status="+status+"&generic_id="+generic_id+"&drug_id="+drug_id+"&item_type="+item_type+"&order_type="+order_type;//IN069654

	}
	function loadPanel(obj)
	{
		obj.checked=true;
		var selHistType = document.forms[0].histSelected.value
  		var selTab      = document.forms[0].tabSelected.value
	
  		var queryStr="";
  		var grphistory_type			=parent.parent.frames[0].document.getElementById("grphistory_type").value; //IN073728
		
  		if("*ALL" == grphistory_type){
			var patient_id		= parent.parent.frames[0].document.getElementById("patient_id").value;
		  	var relationship_id		= parent.parent.frames[0].document.getElementById("relationship_id").value;
  			var ql_ref      = document.forms[0].ql_ref.value;
	  		var ql_tab      = parent.parent.frames[0].document.getElementById("default_personalView"+selHistType).value; 
	  		var abnormal      = parent.parent.frames[0].document.getElementById("default_abnormal"+selHistType).value;
	  		var ql_nlcyInd      = parent.parent.frames[0].document.getElementById("default_normalcyInd"+selHistType).value;
	  		var ql_viewBy      = parent.parent.frames[0].document.getElementById("default_viewBy"+selHistType).value; 
	  		var ql_patClass      = parent.parent.frames[0].document.getElementById("default_patientClass"+selHistType).value; 
	  		var eventGrp      = parent.parent.frames[0].document.getElementById("default_eventGroup"+selHistType).value;
	  		var ql_evntGrpDsc      = parent.parent.frames[0].document.getElementById("default_eventGroupDesc"+selHistType).value;
	  		var eventItem      = parent.parent.frames[0].document.getElementById("default_eventItem"+selHistType).value;
	  		var ql_evntItmDsc      = parent.parent.frames[0].document.getElementById("default_eventItemDesc"+selHistType).value; 
	  		var eventCls      =parent.parent.frames[0].document.getElementById("default_eventClass"+selHistType).value;
	  		var date_Ordr			=parent.parent.frames[0].document.getElementById("default_date"+selHistType).value;
	  		var from_date = 	parent.parent.frames[0].document.getElementById("from_date").value;
			var to_date =	parent.parent.frames[0].document.getElementById("to_date").value;
			var def_facility = parent.parent.frames[0].document.getElementById("fac_id_sel").value; 
			var encounter_id = parent.parent.frames[0].document.getElementById("encounter_id").value;
        		queryStr = "from_date="+from_date+"&to_date="+to_date+"&encounter_id="+encounter_id+"&facility_id="+def_facility+"&patient_id="+patient_id+"&relationship_id="+relationship_id+"&grphistory_type="+selHistType;
        
  		}
  		else
  		{	//IN069654 starts
	  		var ql_ref      = document.forms[0].ql_ref.value
	  		var ql_tab      = document.forms[0].ql_tab.value
	  		var abnormal      = document.forms[0].ql_abnrml.value
	  		var ql_nlcyInd      = document.forms[0].ql_nlcyInd.value
	  		var ql_viewBy      = document.forms[0].ql_viewBy.value
	  		var ql_patClass      = document.forms[0].ql_patClass.value
	  		var eventGrp      = document.forms[0].ql_evntGrp.value
	  		var ql_evntGrpDsc      = document.forms[0].ql_evntGrpDsc.value
	  		var eventItem      = document.forms[0].ql_evntItm.value
	  		var ql_evntItmDsc      = document.forms[0].ql_evntItmDsc.value
	  		var eventCls      = document.forms[0].evntClss.value
	  		date_Ordr			= document.forms[0].date_Ordr.value
	  		var def_facility      = document.forms[0].facility_id.value
	  		 queryStr    = document.forms[0].queryString.value
  		
  		}
  		
  		
  		if(ql_ref!=""){
  			var selTab      = document.forms[0].ql_tab.value
  			
  		}
			//IN069654 ends	
		if(document.forms[0].group_panel[0].checked)			
				 orderCatalogNature=document.forms[0].group_panel[0].value;	
		else if(document.forms[0].group_panel[1].checked)			
				orderCatalogNature=document.forms[0].group_panel[1].value;
		
		//var queryStr    = document.forms[0].queryString.value
		//parent.eventDateFrame.location.href="../../eCA/jsp/ClinicalEventHistoryResultDates.jsp?"+queryStr+"&selHistType="+selHistType+"&selTab="+selTab+"&orderCatalogNature="+orderCatalogNature;//IN069654
		parent.eventDateFrame.location.href="../../eCA/jsp/ClinicalEventHistoryResultDates.jsp?"+queryStr+"&selHistType="+selHistType+"&selTab="+selTab+"&orderCatalogNature="+orderCatalogNature+"&queryStr="+queryStr+"&ql_viewBy="+ql_viewBy+"&ql_nlcyInd="+ql_nlcyInd+"&abnormal="+abnormal+"&ql_ref="+ql_ref+"&eventItem="+eventItem+"&ql_evntGrpDsc="+ql_evntGrpDsc+"&eventGrp="+eventGrp+"&ql_patClass="+ql_patClass+"&eventCls="+eventCls+"&ql_evntItmDsc="+ql_evntItmDsc+"&date_Ordr="+date_Ordr+"&def_facility="+def_facility;//IN069654

	}
//IN071596 STARTS
function collapseExpandNew(obj,index)
{
	
	var encounterId=document.getElementById("encounterId"+index).value
	var login_user_id=document.getElementById("login_user_id").value
	var contr_sys_event_code=document.getElementById("contr_sys_event_code"+index).value
	var hist_data_type=document.getElementById("hist_data_type"+index).value
	var accessionNum=document.getElementById("accessionNum"+index).value
	var event_date_time=document.getElementById("event_date_time"+index).value
	var url=document.getElementById("url").value
	var clinician_id=document.getElementById("clinician_id").value
	var facility_id=document.getElementById("facility_id"+index).value
	var patient_id=document.getElementById("patient_id").value
	var strNormalcyInd=document.getElementById("strNormalcyInd").value
	var selHistType=document.getElementById("selHistType").value
	var tdObj = eval(document.getElementById("tableId"+index));
	if(obj.value == ' - ')
	{
		tdObj.style.display = 'none';
		obj.value = ' + ';
	}
	else if(obj.value == ' + ')
	{	
		tdObj.style.display = 'inline';
		obj.value = ' - ';
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;	
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(document.getElementById("tableTDId"+index).innerHTML=='&nbsp;' || document.getElementById("tableTDId"+index).innerHTML==''){
		xmlHttp.open( "POST", "../../eCA/jsp/ClinicalEventHistoryIntermediate.jsp?index="+index+"&patient_id="+patient_id+"&facility_id="+facility_id+"&clinician_id="+clinician_id+"&url="+url+"&event_date_time="+event_date_time+"&accessionNum="+accessionNum+"&hist_data_type="+hist_data_type+"&contr_sys_event_code="+contr_sys_event_code+"&login_user_id="+login_user_id+"&encounterId="+encounterId+"&strNormalcyInd="+strNormalcyInd+"&selHistType="+selHistType, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=trimString(xmlHttp.responseText);
		document.getElementById("tableTDId"+index).innerHTML="<tr> <td>" +responseText+ "</td> </tr>";
		}
	}
	document.getElementById("currentSelectRecorde").value=index;
}
function collpesedAllNotes(){
	var totalRecords = parent.eventDataFrame.document.getElementById("totalRecords").value;
	for(var i=1;i<totalRecords;i++){ 
		parent.eventDataFrame.document.getElementById("tableId"+i).style.display = 'none';
		parent.eventDataFrame.document.getElementById("collapseButton"+i).value = ' + ';
	}
	parent.eventDataFrame.document.getElementById("currentSelectRecorde").value='';
}
function expendedSetOfNotes(){
	//var totalRecords = parent.eventDataFrame.document.getElementById("currentSelectRecorde").value;//IN073728 Starts
	var totalRecords='';
	if(null!=parent.eventDataFrame.document.getElementById("currentSelectRecorde") && undefined!=parent.eventDataFrame.document.getElementById("currentSelectRecorde"))
		totalRecords = parent.eventDataFrame.document.getElementById("currentSelectRecorde").value;//IN073728 Ends
	if(totalRecords=='')
		totalRecords='0';
	for(var i=1;i<6;i++){
		var index = (parseInt(totalRecords)+i);
		expendedNotes(index,"");
	}
}
function expendedNotes(index,str){
		var encounterId			= parent.eventDataFrame.document.getElementById("encounterId"+index).value;
		var login_user_id		= parent.eventDataFrame.document.getElementById("login_user_id").value;
		var contr_sys_event_code= parent.eventDataFrame.document.getElementById("contr_sys_event_code"+index).value;
		var hist_data_type		= parent.eventDataFrame.document.getElementById("hist_data_type"+index).value;
		var accessionNum		= parent.eventDataFrame.document.getElementById("accessionNum"+index).value;
		var event_date_time		= parent.eventDataFrame.document.getElementById("event_date_time"+index).value;
		var url					= parent.eventDataFrame.document.getElementById("url").value;
		var clinician_id		= parent.eventDataFrame.document.getElementById("clinician_id").value;
		var facility_id			= parent.eventDataFrame.document.getElementById("facility_id"+index).value;
		var patient_id			= parent.eventDataFrame.document.getElementById("patient_id").value;
		var tdObj 				= parent.eventDataFrame.document.getElementById("tableTDId"+index);
		var selHistType			= parent.eventDataFrame.document.getElementById("selHistType").value;
		var strNormalcyInd		=parent.eventDataFrame.document.getElementById("strNormalcyInd").value;
	
		//parent.eventDataFrame.document.getElementById("tableId"+index).style.display = 'inline';
		parent.eventDataFrame.document.getElementById("tableId"+index).style = "display";
		parent.eventDataFrame.document.getElementById("collapseButton"+index).value = ' - ';
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;	
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(tdObj.innerHTML=='&nbsp;' || tdObj.innerHTML==''){
			xmlHttp.open( "POST", "../../eCA/jsp/ClinicalEventHistoryIntermediate.jsp?index="+index+"&patient_id="+patient_id+"&facility_id="+facility_id+"&clinician_id="+clinician_id+"&url="+url+"&event_date_time="+event_date_time+"&accessionNum="+accessionNum+"&hist_data_type="+hist_data_type+"&contr_sys_event_code="+contr_sys_event_code+"&login_user_id="+login_user_id+"&encounterId="+encounterId+"&selHistType="+selHistType+"&strNormalcyInd="+strNormalcyInd, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=trimString(xmlHttp.responseText);
			tdObj.innerHTML="<tr> <td>" +responseText+ "</td> </tr>";	
		}else{
			//parent.eventDataFrame.document.getElementById("tableTDId"+index).style.display = 'inline';
			parent.eventDataFrame.document.getElementById("tableTDId"+index).style="display";
		}
		parent.eventDataFrame.document.getElementById("currentSelectRecorde").value=index;
		if(str=="EXPDATE"){
			parent.eventDataFrame.window.scrollTo(0,0);
			var obj =parent.eventDataFrame.document.getElementById('tableTRId'+index);
			var rect = obj.getBoundingClientRect();
			parent.eventDataFrame.window.scrollTo(0, rect.top);
		}
}
//IN071596 ENDS

