/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/01/2012	  INO30714		MenakaV	 	THAI screen>View Clinical Event History>View>In the Recorded
										 Clinical Note the name is not displayed in THAI
05/04/2012	  IN031989		MenakaV	 	When a patient is selected by using patient without encounter search function and when clinical
										event history is accessed the note header is incomplete for all the existing notes for that patient
20/06/2012	  IN033489		Menaka V	Report header blank in clinical event history.										
07/01/2013	  IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										more appealing. Keeping the display of information more clear and visible.
18/07/2013	IN034514		Karthi L	In Clinical Event History, one could see information about patient's visit as a 
										summary which included Patient Admission date, date of discharge, attending practitioner, etc										
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
18/11/2015	IN057113			Karthi L							 			ML-MMOH-CRF-0335 - IN057113
17/12/2015  IN058148        Prathyusha                          			Allow copy text from event history views
12/17/2015  IN058156		Prathyusha					        			Once encounter is closed, there is no way for the user to check if the clinical notes in
07/10/2016	IN047572		Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?										
16/01/2019	IN068560		Raja S			16/01/2019		Ramesh G		ML-MMOH-SCF-1078
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var dtArr = new Array();
var arrObjects = new Array();
var isPrintPinValidationReq; //ML-MMOH-CRF-0335 - IN057113
function getMessageFrame()
{
	if(top.content!=null){
		return top.content.messageFrame;
	}else{
		return top.messageFrame;
	}
}
function getWorkAreaCriteriaFrame()
{
	if(top.content!=null && top.content.workAreaFrame && typeof top.content.workAreaFrame.criteria_f1 !== 'undefined'){
		return top.content.workAreaFrame.criteria_f1;
	}else{
		//return parent.parent.parent.criteria_f1;
		if(parent.criteria_f1 != null && typeof parent.criteria_f1 !== 'undefined')
			return parent.criteria_f1;
		else if(parent.parent.criteria_f1 != null && typeof parent.parent.criteria_f1 !== 'undefined')
			return parent.parent.criteria_f1;
		else if(parent.parent.parent.criteria_f1 != null && typeof parent.parent.parent.criteria_f1 !== 'undefined')
			return parent.parent.parent.criteria_f1;
	}
}

var messageFrameReference = getMessageFrame();
var workAreaFrameReference = getWorkAreaCriteriaFrame();

function refreshTree()
{
	var episodetype = parent.criteria_f1.document.forms[0].episode_type.value;
	var histtype = parent.criteria_f1.document.forms[0].history_type.value;
	var eventclass = parent.criteria_f1.document.forms[0].event_class.value;
	var eventgroup = parent.criteria_f1.document.forms[0].event_group.value;
	var eventitem = parent.criteria_f1.document.forms[0].event_item.value;
	var fromdate = parent.criteria_f1.document.forms[0].from_date.value;
	var todate = parent.criteria_f1.document.forms[0].to_date.value;
	var patientid = parent.criteria_f1.document.forms[0].patient_id.value;
	var episodewise = parent.criteria_f1.document.forms[0].episode_wise.checked == true?"Y":"N";
	var errorEvent = parent.criteria_f1.document.forms[0].chkErrorEvent.checked == true?"Y":"N";
	var viewby = "E";

	if(parent.criteria_f1.document.forms[0].view_by[0].checked){
		viewby = parent.criteria_f1.document.forms[0].view_by[0].value;
	}else if(parent.criteria_f1.document.forms[0].view_by[1].checked){
		viewby = parent.criteria_f1.document.forms[0].view_by[1].value;
	}
	
/*
	if ( parent.criteria_f1.document.forms[0].elements(10).checked) 
	viewby = "E";
	else
	viewby = "D";
*/
	var facilityId = parent.criteria_f1.document.forms[0].facility_id.value; 
	
	/**********/
	var encounter_id = parent.criteria_f1.document.forms[0].encounter_id.value;
	var performed_by = parent.criteria_f1.document.forms[0].performed_by.value;
	/**********/

	if(!doDateCheckFrom(parent.criteria_f1.document.forms[0].to_date,parent.criteria_f1.document.forms[0].from_date))
		return ;


	var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+histtype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+viewby+'&episode_wise='+episodewise+'&facility_id='+facilityId+'&encounter_id='+encounter_id+'&performed_by='+performed_by+'&errorEvent='+errorEvent;

	if(top.frames[4].button_f1==null)
	{
		top.frames[4].frames[1].button_f1.document.forms[0].print.disabled = true;
	}
	else
	{
		top.frames[4].button_f1.document.forms[0].print.disabled = true;
	}
	parent.details_f1.location.href = '../../eCA/jsp/EncountersDetailsTree.jsp'+params
	parent.details_f2.location.href = '../../eCommon/html/blank.html';
}

function clearForm()
{
	parent.parent.parent.criteria_f1.document.forms[0].reset();
	parent.parent.details_f2.location.href = '../../eCommon/html/blank.html';
}

function showDetails(vals,paramFacilityId,paramEncounterId)
{
	//alert('New Param facility id='+paramFacilityId);
	//alert('New Param encounter id='+paramEncounterId);
	var arr = vals.split("~");
	var patientid		= parent.criteria_f1.document.forms[0].patient_id.value;
	var viewby		= parent.details_f1.document.forms[0].view_by.value;
	var episodetype = parent.details_f1.document.forms[0].episode_type.value;
	var histtype1 = parent.details_f1.document.forms[0].history_type.value;
	var eventclass1 = parent.details_f1.document.forms[0].event_class.value;
	var eventgroup1 = parent.details_f1.document.forms[0].event_group.value;
	var eventitem1 = parent.details_f1.document.forms[0].event_item.value;
	var fromdate = parent.details_f1.document.forms[0].from_date.value;
	var todate = parent.details_f1.document.forms[0].to_date.value;
	var facilityId = parent.details_f1.document.forms[0].facility_id.value; 
	var errorEvent = parent.details_f1.document.forms[0].errorEvent.value; 
	var p_review_rad_yn = parent.details_f1.document.forms[0].p_review_rad_yn.value;//IN071561
	var eventdate	= arr[1]==null?"":arr[1];
	var datatype = arr[0]==null?"":arr[0];
	histtype		= arr[2]==null?"":arr[2];
	eventclass	= arr[3]==null?"":arr[3];
	eventgroup= arr[4]==null?"":arr[4];
	eventitem	= arr[5]==null?"":arr[5];
	if(paramEncounterId==null) {
		paramEncounterId ="";
	}
/*
	if(histtype == '') histtype = histtype1;
	if(eventclass == '') eventclass = eventclass1;
	if(eventgroup == '') eventgroup = eventgroup1;
	if(eventitem == '') eventitem = eventitem1;
*/
	//var params = '?patient_id='+patientid+'&hist_type='+histtype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&view_by='+viewby+'&event_date='+eventdate+'&from_date='+fromdate+'&to_date='+todate+'&facility_id='+paramFacilityId+'&errorEvent='+errorEvent+"&encounter_id="+paramEncounterId;//IN071561
	var params = '?patient_id='+patientid+'&hist_type='+histtype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&view_by='+viewby+'&event_date='+eventdate+'&from_date='+fromdate+'&to_date='+todate+'&facility_id='+paramFacilityId+'&errorEvent='+errorEvent+"&encounter_id="+paramEncounterId+"&p_review_rad_yn="+p_review_rad_yn;//IN071561

	//enablePrint(datatype);
	parent.button_f1.document.forms[0].print.disabled = true;
	parent.details_f2.location.href = '../../eCA/jsp/EncountersDetailsFrame.jsp'+params

}

async function commonSearch(from)
{
	var his_type = document.forms[0].history_type.value;
	var whereClause = "";
	var locale  = document.forms[0].locale.value;

//	if(his_type != "")
//	{
		whereClause = "where hist_rec_type=`"+his_type+"`";
//	}

	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;

	if(from == 'E')
	{
		//var sql=" select EVENT_CODE,long_desc SHORT_DESC from cr_clin_event_mast "+whereClause;
		var sql="select EVENT_CODE,long_desc SHORT_DESC from CR_CLN_EVT_MST_LANG_VW "+whereClause+"and LANGUAGE_ID = `"+locale+"` ";

		var search_code="EVENT_CODE";
		var search_desc="LONG_DESC";
		var tit="Event Item";

		var target = self.document.forms[0].event_item;
		var target1 = self.document.forms[0].event_item1;
	}
	else if (from == 'G')
	{
		//var sql=" select event_group, long_desc short_desc from cr_clin_event_group "+whereClause;
		var sql="select EVENT_GROUP,long_desc SHORT_DESC from CR_CLN_EVT_GRP_LANG_VW"+whereClause+"and LANGUAGE_ID = `"+locale+"` ";
		var search_code="event_group";
		var search_desc="LONG_DESC";
		var tit="Event Group";
		var target = self.document.forms[0].event_group;
		var target1=self.document.forms[0].event_group1;
	}
	else if (from == 'H')
	{
		//var sql=" select practitioner_id, practitioner_name from am_practitioner "
		var sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where LANGUAGE_ID = `"+locale+"` ";
		var search_code="practitioner_id";
		var search_desc="practitioner_name";
		var tit=getLabel("Common.Performed.label","COMMON")+ " " +  getLabel("Common.by.label","common");
		var target = self.document.forms[0].performed_by;
		var target1=self.document.forms[0].performed_by1;
	}

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);

	if (!(retVal == null))
	{
		var retVal=unescape(retVal);
	   	arr=retVal.split("::");
		target.value=arr[1];
		target1.value=arr[0];
	}
	else
	{
		target.value="";
		target1.value="";
		target1.focus();
	}
}

async function showDocDetails(datatype,histtype,accessionnum,eventdesc,contr_sys_id,contr_sys_event_code)
{
	enablePrint(datatype);
	accessionnum	=	escape(accessionnum);
	var retVal = 	new String();
	var dialogHeight= "37.5" ;
	var dialogWidth	= "50" ;
	var dialogTop	= "120" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal =await window.showModalDialog("../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&event_desc="+eventdesc+"&from=&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code,arguments,features);
	//parent.DisplayResult.location.href = "../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&event_desc="+eventdesc+"&from=A&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code;
}

async function showinModal()
{
	var p = parent.DisplayResult.document.detail_form.qs.value;
	var retVal = 	new String();
	var dialogHeight= "37.5" ;
	var dialogWidth	= "50" ;
	var dialogTop	= "120" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/EncountersDocDisplay.jsp?"+p,arguments,features);
}

function enablePrint(dt)
{	
	
	if(top.content!=null)
	{
		top.content.workAreaFrame.details.details_f2.encountercontrol.document.forms[0].print.disabled = false;
		top.content.workAreaFrame.details.details_f2.encountercontrol.document.forms[0].data_type.value = dt;
	}
	else if(parent.parent.details!=null)
	{
		parent.parent.details.details_f2.encountercontrol.document.forms[0].print.disabled = false;
		parent.parent.details.details_f2.encountercontrol.document.forms[0].data_type.value = dt;
	}
	else
	{
		
		parent.parent.parent.parent.details.details_f2.encountercontrol.document.forms[0].print.disabled = false;
		parent.parent.parent.parent.details.details_f2.encountercontrol.document.forms[0].data_type.value = dt;
	}

	/*if(top.frames[4].button_f1==null)
	{
		top.frames[4].frames[1].button_f1.document.forms[0].print.disabled = false;
		top.frames[4].frames[1].button_f1.document.forms[0].data_type.value = dt;
	}
	else
	{
		top.frames[4].button_f1.document.forms[0].print.disabled = false;
		top.frames[4].button_f1.document.forms[0].data_type.value = dt;
	}*/
	
}

function showEncounterDetails(patient_id,facilityid,encounter_id,patient_class)
{
	//var e = obj.innerText;
	//var episodetype = e.substring(e.indexOf(":")+2,e.indexOf(": ")+4);
	//var patientid		= parent.criteria_f1.document.forms[0].patient_id.value;
	//var episodeid		= e.substring(e.indexOf(":")+5,e.indexOf(": ")+17);
	parent.details_f2.location.href = '../../eCA/jsp/EncountersDetails.jsp?patient_id='+patient_id+'&facilityid='+facilityid+'&episode_type='+patient_class+'&episodeid='+encounter_id
}

async function modalForPrint()
{
	var from		= document.forms[0].from;
	var episodetype = parent.parent.criteria_f1.document.forms[0].episode_type.value;
	var called_from = "";

	if(from!=null)
		called_from = from.value;
	
	var retVal		= new String();
	var dialogTop	= "60";
	var dialogHeight= "34" ;
	var dialogWidth	= "50" ;
	var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var data		= new Array();
	var header		= "";
	var footer		= "";
	var headDatas	= "";
	if(parent.details_f2.DisplayResult.DisplayCriteria)
	{
		if(parent.details_f2.DisplayResult.DisplayResult.document.detail_form)
		{
			 
			headDatas = parent.details_f2.DisplayResult.DisplayCriteria.document.forms[0].pline.value;
			var headerDetails = headDatas.split(',');
			if (headerDetails.length > 6)
			{
				headerDetails.length = 6;
			}
				
			var check = headerDetails.length;
			var nationality_id = "";
			var nationality_legend = "";

			if(parent.details_f2.DisplayResult.DisplayResult.document.detail_form)
				nationality_id = parent.details_f2.DisplayResult.DisplayResult.document.detail_form.nationality_id.value;
			if(parent.details_f2.DisplayResult.DisplayResult.document.detail_form)
				nationality_legend = parent.details_f2.DisplayResult.DisplayResult.document.detail_form.nationality_legend.value;	

			var patientId = "";
			if(parseInt(check) == 6)
			{
				patientId = headerDetails[5].substring(3,headerDetails[5].length);
			}
			else if(parseInt(check) == 5)
			{
				patientId = headerDetails[4].substring(3,headerDetails[4].length);
			}
			else if(parseInt(check) == 4)
			{
				patientId = headerDetails[3].substring(3,headerDetails[3].length);
			}
			if(called_from != "DISCHARGE_SUMMARY")
			{
				if(parseInt(check) == 6)
				{
					header = "<table width='100%' border=1 cellpadding=3 cellspacing=0>"+
						"<tr><td  align=center><h3>"+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.facility_disp_name.value+"</h3></td></tr>"+
						"<tr><td  align=center><h4>"+parent.details_f2.DisplayResult.DisplayCriteria.document.forms[0].title_of_document.value+"</h4></td></tr></table>"+
						"<br><table width='100%' border='1' cellpadding=3 cellspacing=0><tr><td>"+
						"<table width='100%' border=0 cellpadding=0 cellspacing=0>"+
						"<tr><td nowrap><b>"+getLabel('Common.patientId.label','Common')+"</b></td><td>: "+patientId+"</td>"+
						"<td nowrap><b>"+getLabel("Common.name.label",'Common')+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=3 cellspacing=0><tr><td>: "+headerDetails[0]+"&nbsp;"+headerDetails[1]+"&nbsp;"+headerDetails[2]+"</td></tr></table></td></tr>";

					if(parseInt(nationality_id.length) > 0)
					{
						if(parseInt(nationality_legend.length) > 12)
						{
							header+="<tr><td nowrap colspan='2'><b>"+nationality_legend+"</b></td><td nowrap colspan='2'><font size='2'>: "+nationality_id+"</font></td></tr>";
						}
						else
						{
							header+="<tr><td nowrap><b>"+nationality_legend+"</b></td><td nowrap colspan='3'><font size='2'>: "+nationality_id+"</font></td></tr>";			
						}
					}

					header+="<tr><td nowrap><b>"+getLabel("Common.gender.label",'Common')+"</b></td><td nowrap>: "+headerDetails[4]+"</td><td nowrap><b>"+getLabel("Common.age.label",'Common')+"</b></td><td nowrap>: "+headerDetails[3]+"</td></tr>"+
						"<tr><td nowrap><b>"+getLabel("Common.encounterid.label",'Common')+"</b></td><td nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.encounter_id.value+"</td><td nowrap><b>"+getLabel("Common.encountertype.label",'Common')+"</b></td><td nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.episode_type.value+"P"+"</td><td nowrap align='right'><b>"+getLabel("Common.encounterdate.label",'Common')+"</b></td><td nowrap>&nbsp;: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.visit_adm_date.value+"</td></tr>"+
						"<tr><td nowrap><b>"+getLabel("Common.Location.label",'Common')+"</b></td>";
				}
				else if(parseInt(check) == 5)
				{
					header = "<table width='100%' border=1 cellpadding=3 cellspacing=0>"+
						"<tr><td  align=center><h3>"+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.facility_disp_name.value+"</h3></td></tr>"+
						"<tr><td  align=center><h4>"+parent.details_f2.DisplayResult.DisplayCriteria.document.forms[0].title_of_document.value+"</h4></td></tr></table>"+
						"<br><table width='100%' border='1' cellpadding=3 cellspacing=0><tr><td>"+
						"<table width='100%' border=0 cellpadding=0 cellspacing=0>"+
						"<tr><td nowrap><b>"+getLabel('Common.patientId.label','Common')+"</b></td><td>: "+patientId+"</td>"+
						"<td nowrap><b>"+getLabel("Common.name.label",'Common')+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=3 cellspacing=0><tr><td>: "+headerDetails[0]+"&nbsp;"+headerDetails[1]+"</td></tr></table></td></tr>";

					if(parseInt(nationality_id.length) > 0)
					{
						if(parseInt(nationality_legend.length) > 12)
						{
							header+="<tr><td nowrap colspan='2'><b>"+nationality_legend+"</b></td><td nowrap colspan='2'><font size='2'>: "+nationality_id+"</font></td></tr>";
						}
						else
						{
							header+="<tr><td nowrap><b>"+nationality_legend+"</b></td><td nowrap colspan='3'><font size='2'>: "+nationality_id+"</font></td></tr>";			
						}
					}

					header+="<tr><td nowrap><b>"+getLabel("Common.gender.label",'Common')+"</b></td><td nowrap>: "+headerDetails[3]+"</td><td nowrap><b>"+getLabel("Common.age.label",'Common')+"</b></td><td nowrap>: "+headerDetails[2]+"</td></tr>"+
						"<tr><td nowrap><b>"+getLabel("Common.encounterid.label",'Common')+"</b></td><td nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.encounter_id.value+"</td><td nowrap><b>"+getLabel("Common.encountertype.label",'Common')+"</b></td><td nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.episode_type.value+"P"+"</td><td nowrap align='right'><b>"+getLabel("Common.encounterdate.label",'Common')+"</b></td><td nowrap>&nbsp;: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.visit_adm_date.value+"</td></tr>"+
						"<tr><td nowrap><b>"+getLabel("Common.Location.label",'Common')+"</b></td>";
				}
				else if(parseInt(check) == 4)
				{
					header = "<table width='100%' border=1 cellpadding=3 cellspacing=0>"+
						"<tr><td  align=center><h3>"+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.facility_disp_name.value+"</h3></td></tr>"+
						"<tr><td  align=center><h4>"+parent.details_f2.DisplayResult.DisplayCriteria.document.forms[0].title_of_document.value+"</h4></td></tr></table>"+
						"<br><table width='100%' border='1' cellpadding=3 cellspacing=0><tr><td>"+
						"<table width='100%' border=0 cellpadding=3 cellspacing=0>"+
						"<tr><td nowrap><b>"+getLabel("Common.patientId.label",'Common')+"</b></td><td nowrap>: "+patientId+"</td>"+
						"<td nowrap><b>"+getLabel("Common.name.label",'Common')+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=3 cellspacing=0><tr><td>: "+headerDetails[0]+"</td></tr><tr><td>"+""+"</td></tr></table></td></tr>";

					if(parseInt(nationality_id.length) > 0)
					{
						if(parseInt(nationality_legend.length) > 12)
						{
							header+="<tr><td nowrap colspan='2'><b>"+nationality_legend+"</b></td><td nowrap colspan='2'><font size='2'>: "+nationality_id+"</font></td></tr>";
						}
						else
						{
							header+="<tr><td nowrap><b>"+nationality_legend+"</b></td><td nowrap colspan='3'><font size='2'>: "+nationality_id+"</font></td></tr>";			
						}
					}
			
					header+="<tr><td nowrap><b>"+getLabel("Common.gender.label",'Common')+"</b></td><td nowrap>: "+headerDetails[2]+"</td><td nowrap><b>"+getLabel("Common.age.label",'Common')+"</b></td><td nowrap>: "+headerDetails[1]+"</td></tr>"+
						"<tr><td nowrap><b>"+getLabel("Common.encounterid.label",'Common')+"</b></td><td nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.encounter_id.value+"</td><td nowrap><b>"+getLabel("Common.encountertype.label",'Common')+"</b></td><td nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.episode_type.value+"P"+"</td><td align='right' nowrap><b>"+getLabel("Common.encounterdate.label",'Common')+"</b></td><td nowrap>&nbsp;: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.visit_adm_date.value+"</td></tr>"+
						"<tr><td nowrap><b>"+getLabel("Common.Location.label",'Common')+"</b></td>";
			
				}

				header += "<td colspan='3' nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.location.value+"</td>";

				header+="<td  align='right' nowrap><b>"+getLabel("Common.dischargedate.label",'Common')+"</b></td><td nowrap>&nbsp;: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.dischargeDateTime.value+"</td></tr>";		
				header+="<tr><td nowrap><b>"+getLabel("Common.speciality.label",'Common')+"</b></td><td colspan='2' nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.specialty_name.value+"</td>";
				header+="<td colspan='2'  align='right' nowrap><b>"+getLabel("Common.AttendingPractitioner.label",'Common')+"</b></td><td nowrap>&nbsp;: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.attending_practitioner.value+"</td></tr></table></td></tr></table>";		
		
				footer="<table width='100%' border=1 cellpadding=3 cellspacing=0><tr><td><table width='100%' border=0 cellpadding=3 cellspacing=0>"+
				"<tr><td colspan='4' nowrap>&nbsp;</td></tr><tr><td width='20%'><b>"+getLabel("Common.authorizedby.label",'Common')+"</b></td><td width='45%' align='left' nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.authorizedBy.value+"</td><td nowrap><b>"+getLabel("Common.Signature.label",'COMMON')+" </b></td><td>: &nbsp;</td></tr>"+
				"<tr><td width='20%' nowrap><b>"+getLabel("Common.print.label",'Common')+"&nbsp;"+getLabel("Common.datetime.label",'Common')+"</b></td><td width='45%' align='left' nowrap>: "+parent.details_f2.DisplayResult.DisplayResult.document.detail_form.printDateTime.value+"</td><td  width='15%' nowrap><b>"+getLabel("Common.LoggedUser.label",'COMMON')+"</b></td><td width='20%' align='left' nowrap>: "+parent.details_f2.DisplayResult.DisplayCriteria.document.forms[0].loggedUser.value+"</td></tr></table></td></tr></table>";
			}
			else
			{
				header = getHeader();
			}
			data[0] = header;
			if(called_from != "DISCHARGE_SUMMARY")
			{
				if(parent.details_f2.DisplayResult.frames[1].document.forms[0] != null)
					data[1] = parent.details_f2.DisplayResult.frames[1].document.getElementById("data").innerHTML;
				else
					data[1] = parent.details_f2.DisplayResult.frames[0].document.getElementById("data").innerHTML;
			}
			else
			{
				data[1] = document.getElementById("data").innerHTML;
			}
			data[2] = footer;
			var arguments =	data ;

			retVal =await window.showModalDialog("../../eCA/jsp/EncountersPrint.jsp",arguments,features);
		}
	}
}

function getHeader()
{
	var patient_line	=	document.forms[0].patient_line.value;
	var visit_adm_date	=	document.forms[0].visit_adm_date.value;
	var specialty_name	=	document.forms[0].specialty_name.value;
	var arrMain			=	patient_line.split("|");

	var arrPatient		=	arrMain[0].split(",");
	var patient_id		=	arrMain[1].substring(3,arrMain[1].length);
	var arrLocnDetails	=	arrMain[2].split(",");
	var encounter_id	=	arrMain[3].substring(10,arrMain[3].length);

	var arrPractLocn	=	arrLocnDetails[0].split("/");
	var arrRoomBed		=	arrLocnDetails[1].split("/");

	var header = "<table width='100%' border=1 cellpadding=3 cellspacing=0>"+
				"<tr><td  align=center><h3>"+document.forms[0].site_name.value+"</h3></td></tr>"+
				"<tr><td  align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>"+
				"<tr><td  align=center><h4>"+getLabel("Common.print.label",'Common')+"DISCHARGE SUMMARY REPORT</h4></td></tr></table>"+
				"<br><table width='100%' border='1' cellpadding=3 cellspacing=0><tr><td>"+
				"<table width='100%' border='0' cellpadding=3 cellspacing=0>"+
				"<tr><td><b>"+getLabel("Common.patientId.label",'Common')+"</b></td><td>: "+patient_id+"</td>"+
				"<td><b>"+getLabel("Common.age.label",'Common')+"</b></td><td>: "+arrPatient[1]+"</td>"+
				"<td><b>"+getLabel("Common.gender.labell",'Common')+"</b></td><td>: "+arrPatient[2]+"</td></tr>"+
				"<tr><td><b>"+getLabel("Common.PatientName.label",'Common')+"</b></td><td colspan='5'>: "+arrPatient[0]+"</td></tr>"+
				"<tr><td><b>"+getLabel("Common.encounterid.label",'Common')+"</b></td><td>: "+encounter_id+"</td>"+
				"<td><b>"+getLabel("Common.AdmissionDateTime.label",'Common')+"</b></td><td colspan='3'>: "+visit_adm_date+"</td></tr>"+
				"<tr><td><b>"+getLabel("Common.nursingUnit.label",'Common')+"</b></td><td>: "+arrPractLocn[1]+"</td>"+
				"<td><b>"+getLabel("Common.Bed.label",'Common')+"</b></td><td>: "+arrRoomBed[1]+"</td>"+
				"<td><b>"+getLabel("Common.room.label",'Common')+"</b></td><td>: "+arrRoomBed[0]+"</td></tr>"+
				"<tr><td><b>"+getLabel("eCA.SpecialityDesc.label",'CA')+"</b></td><td>: "+specialty_name+"</td>"+
				"<td><b>"+getLabel("Common.practitioner.label",'Common')+"</b></td><td colspan='3'>: "+arrPractLocn[0]+"</td></tr>"+
				"</table></td></tr></table>";
	return header;
}
function showPopUp(obj,encdtls,range)
{
	
	if (encdtls==undefined){
			return false;
	}
	var temp="<DIV STYLE='BACKGROUND-COLOR:yellow'>";
	temp+=encdtls;
	temp +="</DIV>";
	
	if(top.content!=null && top.document.getElementById('dialog-body') == null)
	messageFrameReference.document.body.innerHTML = temp;
	else if (top.document.getElementById('dialog-body').contentWindow.messageFrame!=null)
	{   
		top.document.getElementById('dialog-body').contentWindow.messageFrame.document.body.innerHTML = temp;
		
	}

	/*var data = ''
	var criteriaObj;


	if(top.content!=null)
	{
		criteriaObj=top.content.workAreaFrame.criteria_f1.document.forms[0].episode_wise;
	}
	else
	{
		//alert(parent.parent.parent.frames[0].name);
		criteriaObj=parent.parent.parent.criteria_f1.document.forms[0].episode_wise;
	}

	if(criteriaObj.checked == false)
	{
		/*for(var i=0;i<encdtls.length;i++)
				encdtls=encdtls.replace('$','</br>');*/
		//data = encdtls+"<br>"+range;
/*		data = range;
	}
	else
		data = range;

	if(document.getElementById("encDetailsLayer") != null){
		var tabdata ="<table width='100%' cellpadding=0 cellspacing=0 border=0 align=center ><tr><td class=OAYELLOW>";
		tabdata+=data;				
		tabdata += "</td></tr></table>";
		//top.content.messageFrame.document.body.innerHTML = tabdata;
		document.getElementById("encDetailsLayer").innerHTML = tabdata; 
		document.getElementById("encDetailsLayer").style.top  = obj.offsetTop;
		document.getElementById("encDetailsLayer").style.left  =obj.offsetLeft+50 ;
		document.getElementById("encDetailsLayer").style.visibility='visible' ;
	}else{
		  hidePopUp();
	}*/
}

function hidePopUp()
{
	if(top.content!=null)
	messageFrameReference.document.body.innerHTML = "";
	else if(top.messageFrame!=null)
	{  

		top.messageFrame.document.body.innerHTML = "";
	}

	/*if(document.getElementById("encDetailsLayer") != null)
		document.getElementById("encDetailsLayer").style.visibility='hidden' ;*/
}
/*function changeColor(sortEventDateTime,classValue,obj,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,rowNum)
 {
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_id = document.forms[0].enc_id.value;
	
	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	rowNum = parseInt(rowNum,10);

	 var addRemove = "Add";
     var comImg = eval("document.getElementById("commImage")"+rowNum);

	 if(obj.className == 'gridDataSelect')
	 {
		addRemove = "Remove";
		obj.className = 'gridDataChart';
	 }
	 else
	 {
		 addRemove = "Add";
		 obj.className = 'gridDataSelect';
	 }

	var valsToRemove = Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	var valsToSort = Histrectype+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	parent.parent.parent.manageEmailFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?addRemove='+addRemove+'&valsToRemove='+escape(valsToRemove)+'&sortEventDateTime='+sortEventDateTime+'&valsToSort='+escape(valsToSort)+'&patient_id='+patient_id+'&encounter_id='+encounter_id;
}*/

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
function displayTooltip(tdObj,toolTip)
{
	
	if(toolTip != '')
	{
		if(tdObj.className != 'gridDataSelect')
			tdObj.className = 'gridDataHover';
	
		document.getElementById("t").innerHTML = toolTip;

		var wdth 	  = tdObj.offsetWidth;
		var hght1 	  = tdObj.offsetHeight;

		var wdth1 = getPos(tdObj).x ;
		var hght = getPos(tdObj).y + hght1;

		var bodwidth  = document.body.offsetWidth;
		var bodheight = document.body.offsetHeight;

		var x 	  = event.x;
		var y 	  = event.y;

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);

		x = wdth1;	
		y = hght;
		document.getElementById("tooltiplayer").style.left = x+'px';
		document.getElementById("tooltiplayer").style.top = y+'px';
		document.getElementById("tooltiplayer").style.visibility = 'visible';
	}
}

function hideTooltip(obj)
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
	if(obj.className != 'gridDataSelect')
		obj.className = 'gridDataChart';
}

function  callPACS(ext_image_obj_id,server_name,virtual_directory,executable_name)
{
	messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
	HTMLVal = " <html>";
	HTMLVal += " <head><script src='../../eCommon/js/ValidateControl.js' language='JavaScript'>"  ;
	HTMLVal += "	function execute() {"  ;
	HTMLVal += "		var e = document.testForm.executableName.value ;"  ;
	HTMLVal += "		document.testForm.runtest.setExecutable( e ) ;"  ;
	HTMLVal += "		document.testForm.runtest.runExecutable() ;"  ;
	HTMLVal += " 	} </script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head>";
	HTMLVal += " <body onKeyDown='lockKey()' class='MESSAGE'>"  ;
	HTMLVal += " <form name='testForm' id='testForm'>"  ;
	HTMLVal += " <object id='runtest' classid=clsid:E2F834AE-D926-4EEE-991C-D15F82E92A58></object>"  ;
	HTMLVal += " <input type='hidden' name='executableName' id='executableName' value='"+executable_name+" "+server_name+" "+virtual_directory+" sa="+ext_image_obj_id+"&ia=y&is=y'> ";
	HTMLVal += " <script>execute();</script></form></body></html>"  ;
	  
	var messageframes =top.messageframe.document
	messageframes.write(HTMLVal);
	parent.frames[0].reload();
}	


function selectEventClass(obj)
{
	var hist_type = obj.value;
	var optlength = document.forms[0].event_class.options.length;

	for (var i=0; i<optlength; i++)
	{
		document.forms[0].event_class.options.remove("event_class");
	}

	if((hist_type=="") ||(hist_type=="select")) 
	{
		var event_class	= '';

		var short_desc	= '         ---- Select ----         ';
		var opt=document.createElement('OPTION'); 
		opt.text	=	short_desc; 
		opt.value	=	event_class; 
		document.forms[0].event_class.add(opt); 
		document.forms[0].event_class.selectedIndex = 0;
		return false;
	}
	
	var HTMLVal="";
	
	parent.parent.frames[5].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.parent.frames[5].document.EventClassPop.submit();

	return true;
}


function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
//**********added to show comments in saparate dialog box-----for showing the short Text
async function ShowComments(resultStr)
	{
		var comments;
		var retVal;
		//Commented by Jyothi on 09/03/2010 to fix 19609
		//var dialogHeight ='20' ;
		var dialogHeight ='22' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			= await window.showModalDialog('../../eCA/jsp/ResComments.jsp?resultStr='+escape(resultStr),arguments,features);//Added escape for IN068560
	}
//***********************************************
//for showing the long text in case of NUM
//function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)//IN031989
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enctr_id,fac_id)//IN031989//IN033489
{
	var patient_id = document.forms[0].patient_id.value;//INO30714
	var enc_id = document.forms[0].enc_id.value;//INO30714
	var win_height		= "90vh";
	var win_width		= "90vw";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "90vh";
		win_width		= "90vw";
		//win_top			= "200";
		//win_scroll_yn	= "no";
}

var retVal = new String();
//var dialogHeight = "28" ;
//var dialogWidth = "50" ;

var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogTop = "10";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
//var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id;//INO30714
var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enctr_id+"&fac_id="+fac_id;//IN031989//IN033489
//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);//INO30714
retVal = await top.window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?"+finalString,arguments,features);//INO30714
}


//Functions for the file name EncountersButtons.jsp-start

async function modalForBirth(patient_id)
	{
		var dialogHeight= "32" ;
		var dialogWidth	= "44" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;		
		retVal=await window.showModalDialog("../../eMP/jsp/ViewBirthRegMain.jsp?Patient_ID="+patient_id,arguments,features);
		
	}

//Functions for the file name EncountersButtons.jsp-End
/*
	Modified by Sridhar Reddy on 22/12/2009 to fix GHL-CRF-0043 CRF Incident.
	Added the plusDate function to fromdate.
*/
function loadPrevNext1(obj)
{
	
	var first		= parent.encountercontrol.document.forms[0].first;
	var last		= parent.encountercontrol.document.forms[0].last;
	var NxtBtn		= parent.encountercontrol.document.forms[0].next;
	var PrvBtn		= parent.encountercontrol.document.forms[0].prev;

	var called_from=parent.encountercontrol.document.forms[0].called_from;
	
	var curidxval	= eval(parent.encountercontrol.document.forms[0].cur_idx_value.value);
	
	var totalidx	= eval(parent.encountercontrol.document.forms[0].idx_value.value);

	if (totalidx > 1)
	{
		totalidx = totalidx;
	}
	
	
	var uptoidxval = 0;

	if(obj.id == 'next')
	{
		
		if(curidxval < totalidx - 1)
		{
			curidxval++;
			uptoidxval = curidxval+1;
			PrvBtn.disabled = false;
			first.disabled = false;
		
			 if (curidxval >= totalidx - 1)
		        {
		            uptoidxval = curidxval + 1;
		            NxtBtn.disabled = true;
		            last.disabled = true;
		        }
		}		
	}
	else if(obj.id == 'prev')
	{
		if(curidxval > 0)
		{
			curidxval--;
			uptoidxval = eval(curidxval)+1;
			NxtBtn.disabled = false;
			last.disabled = false;
			
			if(curidxval <= 0)
			{
				uptoidxval = eval(curidxval)+1;
				PrvBtn.disabled = true;
				first.disabled = true;
			}
		}
	}
	else if(obj.id == 'first')
	{
		curidxval = 0;
		uptoidxval = eval(curidxval)+1;
		PrvBtn.disabled = true;
		first.disabled = true;
		NxtBtn.disabled = false;
		last.disabled = false;
	}
	else if(obj.id == 'last')
	{
		curidxval = totalidx - 1;
		uptoidxval = totalidx;
		NxtBtn.disabled = true;
		last.disabled = true;
		PrvBtn.disabled = false;
		first.disabled = false;
	}

	var displstart	= eval(curidxval) + 1;
	var displend	= eval(totalidx); 

	parent.encountercontrol.document.getElementById("label_cap").innerText = "Page "+ displstart + " of " + displend;
	parent.encountercontrol.document.forms[0].cur_idx_value.value = curidxval;
	parent.encountercontrol.document.forms[0].page_no.value = displstart;

	/*
	if (uptoidxval == totalidx )
		NxtBtn.disabled = true;
	else
		NxtBtn.disabled = false;
	
	if (curidxval == 0)
		PrvBtn.disabled = true;
	else
		PrvBtn.disabled = false;
		
	*/
	var firstDateTime;
	var lastDateTime;

	
		//firstDateTime	= dtArr[curidxval]
		//lastDateTime	= dtArr[uptoidxval]
		firstDateTime	= workAreaFrameReference.document.forms[0].from_date.value;
		lastDateTime	= workAreaFrameReference.document.forms[0].to_date.value;
		
		if (obj.id != 'first' && displstart != 1)
		{
			firstDateTime = plusDate(firstDateTime, 'DMYHM', 'en', 1, 'm');
		}		
	
		if(called_from.value=="OR")
			populateControlOR(firstDateTime,lastDateTime)
		else
			populateControl1(firstDateTime,lastDateTime);
}

function populateControl1(fmDt,toDt)
{
	workAreaFrameReference = getWorkAreaCriteriaFrame();

	var event_date		=	document.forms[0].event_date.value;
	var patientid		= document.forms[0].patient_id.value;
	var episodetype		= document.forms[0].episode_type.value;
	
	var eventclass		= document.forms[0].event_class.value;
	
	var eventgroup		= document.forms[0].event_group.value;
	
	var eventitem		= document.forms[0].event_item.value;

	//var called_from= document.forms[0].called_from.value;
	

	//var stdParams		= document.forms[0].queryStrForCmnts.value;
	var viewConfRes		= document.forms[0].viewConfRes.value;
	var historytype		= document.forms[0].history_type.value;
	
	var facility_id		= document.forms[0].facility_id.value;
	//var EHR_YN			= document.forms[0].EHR_YN.value;
	
	var graphorder		= workAreaFrameReference.document.forms[0].graphorder.value;
	
	
	var encounter_id	= document.forms[0].encounter_id.value;
	var enc_id	= document.forms[0].enc_id.value;
	if(enc_id == "" || enc_id == null) enc_id = "0";

	//var fromdate		= workAreaFrameReference.document.forms[0].from_date.value;
	//var todate			= workAreaFrameReference.document.forms[0].to_date.value;

	var fromdate		= workAreaFrameReference.document.forms[0].from_date.value;
	var todate			= workAreaFrameReference.document.forms[0].to_date.value;
	var relationship_id			= workAreaFrameReference.document.forms[0].relationship_id.value;
	var p_called_from		= workAreaFrameReference.document.forms[0].p_called_from_widget.value;//IN035950
	var p_event_class			= workAreaFrameReference.document.forms[0].p_event_class_widget.value;//IN035950
	var patient_class	=	 document.encounterform.patient_class.value;//IN034514
	var p_enc_details_tree	=	 document.encounterform.p_enc_details_tree.value;//IN034514
	var encntr_yn =	 document.encounterform.encntr_yn.value;//IN034514
	var p_menu_type =	 document.encounterform.p_menu_type.value;//IN034514
	var speciality_code =	 document.encounterform.speciality_code.value; //MMS-QH-CRF-0177 [IN047572] 
	var attend_pract_code =	 document.encounterform.attend_pract_code.value; //MMS-QH-CRF-0177 [IN047572] 
	if(fmDt == undefined)
		fmDt = '';
	if(toDt == undefined)
		toDt = '';
	
	var abnormal = "";
	var errorEvent ="N";

	if(workAreaFrameReference.document.forms[0].chkAbnormal.checked)
		abnormal = "Y";
	else
		abnormal = "N";
	var normalcy = workAreaFrameReference.document.forms[0].cboNormalcyInd.value;
	var episode_wise = "N";
	var view_by="";
	
	var order_type_3T		= workAreaFrameReference.document.forms[0].order_type_3T.value;  //39052

	if(workAreaFrameReference.document.forms[0].view_by[0].checked)
				view_by = workAreaFrameReference.document.forms[0].view_by[0].value;
	else if(workAreaFrameReference.document.forms[0].view_by[1].checked)
				view_by = workAreaFrameReference.document.forms[0].view_by[1].value;
	
	if(workAreaFrameReference.document.forms[0].show_mode[0].checked)
				show_mode = workAreaFrameReference.document.forms[0].show_mode[0].value;
	else if(workAreaFrameReference.document.forms[0].show_mode[1].checked)
				show_mode = workAreaFrameReference.document.forms[0].show_mode[1].value;

	var page_no		= parent.encountercontrol.document.forms[0].page_no.value;

	//var params = 'patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&event_date='+event_date+'&abnormal='+abnormal+'&normalcy='+normalcy+'&viewConfRes='+viewConfRes+'&performed_by=&errorEvent='+errorEvent+'&episode_wise='+episode_wise+'&view_by='+view_by+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&graphorder='+graphorder+'&enc_id='+enc_id+'&EHR_YN='+EHR_YN;
	//var params = 'patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&event_date='+event_date+'&abnormal='+abnormal+'&normalcy='+normalcy+'&viewConfRes='+viewConfRes+'&performed_by=&errorEvent='+errorEvent+'&episode_wise='+episode_wise+'&view_by='+view_by+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&graphorder='+graphorder+'&enc_id='+enc_id+'&show_mode='+show_mode+'&page_no='+page_no+"&relationship_id="+relationship_id;//IN035950
	//var params = 'patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&event_date='+event_date+'&abnormal='+abnormal+'&normalcy='+normalcy+'&viewConfRes='+viewConfRes+'&performed_by=&errorEvent='+errorEvent+'&episode_wise='+episode_wise+'&view_by='+view_by+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&graphorder='+graphorder+'&enc_id='+enc_id+'&show_mode='+show_mode+'&page_no='+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from;//IN035950 //commented for IN034514
	//var params = 'patient_id='+patientid+'&episode_type='+episodetype+'&patient_class='+patient_class+'&p_enc_details_tree='+p_enc_details_tree+'&encntr_yn='+encntr_yn+'&p_menu_type='+p_menu_type+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&event_date='+event_date+'&abnormal='+abnormal+'&normalcy='+normalcy+'&viewConfRes='+viewConfRes+'&performed_by=&errorEvent='+errorEvent+'&episode_wise='+episode_wise+'&view_by='+view_by+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&graphorder='+graphorder+'&enc_id='+enc_id+'&show_mode='+show_mode+'&page_no='+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from;//IN034514 -- commented for  MMS-QH-CRF-0177 [IN047572] -- MMS-QH-CRF-0177 [IN047572]
	var params = 'patient_id='+patientid+'&episode_type='+episodetype+'&patient_class='+patient_class+'&p_enc_details_tree='+p_enc_details_tree+'&encntr_yn='+encntr_yn+'&p_menu_type='+p_menu_type+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&event_date='+event_date+'&abnormal='+abnormal+'&normalcy='+normalcy+'&viewConfRes='+viewConfRes+'&performed_by=&errorEvent='+errorEvent+'&episode_wise='+episode_wise+'&view_by='+view_by+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&graphorder='+graphorder+'&enc_id='+enc_id+'&show_mode='+show_mode+'&page_no='+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code;//MMS-QH-CRF-0177 [IN047572]
	params = params+"&order_type_3T="+order_type_3T;  //39052
	parent.DisplayResult.location.href="../../eCA/jsp/EncountersDetailsMain.jsp?"+params;
}

async function manageText()
{
	var patient_id = document.encounterform.patient_id.value;
	var encounter_id = document.encounterform.encounter_id.value;
	var enc_id = document.encounterform.enc_id.value;
	
	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;
	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	var dialogHeight= "70vh" ;
	var dialogWidth	= "40vw" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no;  status:no";		
	retVal=await top.window.showModalDialog("../../eCA/jsp/EncountersManageTxtMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
	if(retVal == null)
	{
		//parent.parent.details_f2.location.reload();
		parent.DisplayResult.location = parent.DisplayResult.location;
	}
}

async function enterQuickText(eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,singleMultiFlag)
{
	var patient_id = parent.frames[1].document.getElementById('patient_id').value;
	var encounter_id =parent.frames[1].document.getElementById('encounter_id').value;
	var enc_id = parent.frames[1].document.getElementById('enc_id').value;
	

	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	if(singleMultiFlag == null){
		singleMultiFlag='M';
	}
	parent.frames[1].document.getElementById('txtFlagQuickText').value = 'Y';
	var tempValues = "";
	var count=0;
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			count++;
		}
	}

	count =0;

	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
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
	var dialogHeight= "75vh" ;//37.5
	var dialogWidth	= "75vw" ;//50
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;	
	
	var retVal = await top.window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&fromFunction=CLINICAL_EVENTS&quickTextCodes="+escape(tempValues)+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count,'',features);
	if(retVal != null && retVal != undefined && retVal != "")
	{
		//self.location.reload();
		//parent.parent.details_f2.location = parent.parent.details_f2.location;
	}
	return false;
}

async function emailText()
{
	var patient_id = document.encounterform.patient_id.value;
	var encounter_id = document.encounterform.encounter_id.value;
	var enc_id = document.encounterform.enc_id.value;
	var called_from = document.encounterform.called_from.value;
	
//	if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;

	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	//var messageFrameName = getMessageFrame();
	//document.forms[0].method = 'post';
	//document.forms[0].action = '../../eCA/jsp/EncountersEmailDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id;
	//document.forms[0].target = messageFrameName.name;
	//document.forms[0].submit();
	var action_url = '../../eCA/jsp/EncountersEmailDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id;

	//var action_url='E:/Requirments/19-11-2008/modaltarget.html';
	//Updated by Arvind 

		var dialogHeight ='90vh' ;
		var dialogWidth = '55vw' ;
		var dialogTop	= '0px'; //'189'
		var dialogLeft = '95' ;//'167'


		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments="";

	if (called_from!="OR")
	{		
		//var win = window.open(action_url,'emailWin','height=570,width=760,top=70,left=120,resizable=yes,scrollbars=yes')
		//<added by Arvind>
		var win = await top.window.showModalDialog(action_url,arguments,features);
		
	}
	else
		
	{	
 		var retVals = await top.window.showModalDialog(action_url,arguments,features);
	}
}	

function closeWindow(obj)
{
	window.close();
	/*const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();*/
}

async function showDocDetailsInModal(histDataType,histRecType,accNum,eventDesc,contrSysId,contrSysEventCode)
{
	accNum	=	escape(accNum);
	var dialogHeight= "30" ;
	var dialogWidth	= "50" ;
	var dialogTop	= "120" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+histDataType+"&hist_type="+histRecType+"&accession_num="+accNum+"&event_desc="+eventDesc+"&contr_sys_id="+contrSysId+"&contr_sys_event_code="+contrSysEventCode,arguments,features);
}

function removeFromBean(obj,rowNum,listKeyValueStr,sortListValueStr)
{	
	var patient_id = "";
	var encounter_id = "";

	if(document.forms[0].patient_id != null)
	{
		patient_id = document.forms[0].patient_id.value;
		encounter_id = 	document.forms[0].encounter_id.value;
	}
	else
	{
		patient_id = document.forms[0].strPatientId.value;              
		encounter_id = document.forms[0].strEncounterId.value;
	}


	if(obj.checked == false)
	{
		parent.interFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&rowNum='+rowNum+'&delete=Yes&valsToRemove='+escape(listKeyValueStr)+'&valsToSort='+escape(sortListValueStr);
	}
	else
	{
		parent.interFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&rowNum='+rowNum+'&delete=No&valsToRemove='+escape(listKeyValueStr)+'&valsToSort='+escape(sortListValueStr);
	}
}

function showEnterQuickText()
{
	if(parent.parent.details_f2.DisplayResult != null)
	{
		if(parent.parent.details_f2.DisplayResult.DisplayCriteria==null)
		{
			if(!(parent.parent.details_f2.DisplayResult)){			
				alert(getMessage("NO_EVENTS_SELECTED",'CA'));
				
		   }
		}
		else
		{
			parent.parent.details_f2.DisplayResult.DisplayCriteria.enterQuickText();
			parent.DisplayResult.location = parent.DisplayResult.location;
		}
	}
	else
	{
		alert(getMessage("NO_EVENTS_SELECTED",'CA'));
		
	}
	//top.content.frames[3].frames[1].frames[2].frames[1].frames[0].enterQuickText();
		//parent.details_f2.DisplayCriteria.enterQuickText();
	
}
async function valsForPrint()
{	
	var patient_id = document.encounterform.patient_id.value;
	var encounter_id = document.encounterform.encounter_id.value;
	var enc_id = document.encounterform.enc_id.value;
	var called_from = document.encounterform.called_from.value;
	
//	if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;

	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var conf_pin_req_yn = document.forms[0].l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		var print_cal_req = 'CEH_MULTI_PRINT'; 
		await isPinValidationReq(patient_id, encounter_id, '', print_cal_req);
		if(isPrintPinValidationReq == 'Y') {
			retVal = await validatePintoPrint();
			if(retVal == 'X')
				return false;
		}
	}	
	//ML-MMOH-CRF-0335 - IN057113 - End
	var dialogTop	= "60";
	var dialogHeight= "33" ;
	var dialogWidth	= "44" ;
	var arguments = "";
	var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	/**
		modified by Deepa on 06/28/2010 at 12:19 PM for IN021079
		changed window.showmodaldialog to window.open, since the print button would not respond in IE8
	**/
	var retVal = await window.open("../../eCA/jsp/EncountersPrint.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from="+called_from,arguments,features);	
}

function staticTitleForManage()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("titleId").style.position = 'relative';
		document.getElementById("titleId").style.posTop  = 0;
	}
	else
	{
		document.getElementById("titleId").style.position = 'relative';
		document.getElementById("titleId").style.posTop  = x-2;
	}
}

function staticTitleForCommentDetails()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("commentTitleId").style.position = 'relative';
		document.getElementById("commentTitleId").style.posTop  = 0;
		document.getElementById("commentTitleId1").style.position = 'relative';
		document.getElementById("commentTitleId1").style.posTop  = 0;
	}
	else
	{
		document.getElementById("commentTitleId").style.position = 'relative';
		document.getElementById("commentTitleId").style.posTop  = x-15;
		document.getElementById("commentTitleId1").style.position = 'relative';
		document.getElementById("commentTitleId1").style.posTop  = x-15;		
	}
}

function selectAllToManage(obj)
{
	var cnt = document.forms[0].numEvents.value;
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	cnt = parseInt(cnt,10);
	var chkbox;

	if(obj.checked == true)
	{
		for(var i=0;i<cnt;i++)
		{
			chkbox = document.getElementById('chkBox'+i);
			chkbox.checked = true;
		}
	}
	else if(obj.checked == false)
	{
		for(var i=0;i<cnt;i++)
		{
			chkbox = document.getElementById('chkBox'+i);
			chkbox.checked = false;
		}
		parent.interFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?clearBean=Yes&encounter_id='+encounter_id+'&patient_id='+patient_id;
	}
}

function collapseExpand(obj,index)
{
	var tdObj = document.getElementById('tableId'+index);
	if(obj.value == ' - ')
	{
		tdObj.style.display = 'none';
		obj.value = ' + ';
	}
	else if(obj.value == ' + ')
	{
		tdObj.style='display';
		obj.value = ' - ';
	}
}

function clearLayer()
{
	hidePopUp();
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
		document.getElementById("descLink").style.top  = obj.offsetTop-2;
		if(objcount=="5")
		{
			document.getElementById("descLink").style.left  = obj.offsetLeft+25;
		}
		else
		{
		document.getElementById("descLink").style.left  = obj.offsetLeft+100;}
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


//for displaying the text from manage button where modal wiondow is reduced
async function getTextInModal(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{
	var win_height		= "30";
	var win_width		= "40";
	var win_left        = "250" ;
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "30";
		win_width		= "40";
		win_left        = "250" ;
		//win_top			= "200";
		//win_scroll_yn	= "no";
}

var retVal = new String();
//var dialogHeight = "28" ;
//var dialogWidth = "50" ;

var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogLeft = win_left ;
var dialogTop = "200";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + ";dialogLeft:"+dialogLeft+"; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
}
//ML-MMOH-CRF-0335 - IN057113
async function validatePintoPrint() {
	var retVal = 	new String();
	var dialogHeight= "20vh" ;
	var dialogWidth	= "20vw" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../eCA/jsp/AuthorizePinAccess.jsp?"+"",arguments,features);
	if(retVal == undefined || retVal == 'undefined') retVal = "X";
	return retVal;
	//alert(' 941. ViewOrder.js ' + retVal);
}
function disallowEnterKey()
{
	var keyVal = parseInt(event.keyCode);
	if(keyVal == 13)
		return false;
}
function chkpasswd() {
	var appl_pwd = document.Authorize_form.appl_user_passwd.value;
	var screen_pwd = document.Authorize_form.screen_passwd.value;
	if (appl_pwd != screen_pwd){
		alert(getMessage("PWD_MISMATCH","CA"));
		top.window.returnValue = "X" ;
		top.window.close();
	}else{
		top.window.returnValue = "T" ;
		top.window.close();
	}

}
function closeAuthorization(){
	top.window.returnValue = "X";
	top.window.close();
}

function isPinValidationReq(patient_id, encounter_id, accession_num, print_cal_req){
	//var patient_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.patient_id.value;
	//var encounter_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.encounter_id.value;
	//var localeName = '';//parent.ViewOrderDtl.document.view_order.localeName.value;
	//var accession_num = parent.FlowsheetToolbarFrame.document.flowsheet_text_toolbar.accession_num.value;
	//alert('accession_num' + accession_num);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/PrintConfidentPinValidate.jsp?p_patient_id=" + patient_id +"&p_encounter_id="+encounter_id+"&p_accession_num="+accession_num+"&p_validate=CONF_PIN_VALIDATE"+"&p_print_req_from="+print_cal_req, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}
function isPinForPrintRequired(pinRequired) {
	isPrintPinValidationReq = pinRequired;
}
//ML-MMOH-CRF-0335 - IN057113
//IN058148 Start
/*function copyText(){
	
	CopiedTxt =parent.DisplayResult.DisplayCriteria.document.selection.createRange();
	CopiedTxt.execCommand("Copy");
}*/
function copyText() {
    const text = parent.DisplayResult.DisplayCriteria.document.getSelection().toString();
    console.log(text);
    if (text) {
        navigator.clipboard.writeText(text);
    }
}

//IN058148 End
//IN058156 Start.
async function showNotesAuditFlow(accession_num)
{			
	var retArray		=	new Array();
	var dialogHeight	=	"60vh" ;
	var dialogWidth		=	"40vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesSearchMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url			+=	"?accession_num="+accession_num+"&operation_mode=ViewNoteStatus";
	retArray			=	await top.window.showModalDialog(action_url,arguments,features);
}
//IN058156 End.

//IN070610, starts
function uploadedDocuments(accession_num, discr_msr_panel_id) {	
	window_id = window.open("../../eOR/jsp/ImageVideosFileUploadMain.jsp?p_called_from=View&p_acc_no="+accession_num+"&p_discr_msr_panel_id="+discr_msr_panel_id,'',"height=700,width=700,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no");
}
//IN070610, ends

//31792 starts
async function NeonatalMotherSpecimenDetails(order_id,accessionnum,histrectype,patient_id)
{   
	var dialogHeight ='10' ;
    var dialogWidth = '38' ;
    var dialogTop	= '129';
    var dialogLeft = '30' ;
	var title = ''
	//if(patientId!=undefined)
	//var patient_id=document.forms[0].patient_id.value;	
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	await window.showModalDialog("../../eOR/jsp/NeoNatalMotherSpecimenDetails.jsp?order_id="+order_id+"&accession_num="+encodeURIComponent(accessionnum)+"&history_type="+histrectype+"&patient_id="+patient_id,arguments,features);
	
}

//31792 ends
function closeManageWin(){
var diagElement = parent.parent.document.getElementsByTagName("dialog");
								var i = 0; var j = 0;
	    						for (i = 0; i < diagElement.length; i++) {
	    							for (j = 0; j < diagElement[i].children.length; j++) {
	    								var element = diagElement[i].children[j];
	    								let dialogSrc = element.src;
	    								if (typeof dialogSrc !== "undefined")
	    								{ 
											if (dialogSrc.includes("EncountersManageTxtMain.jsp")||dialogSrc.includes("EncountersControls.jsp")) 
											{
		        								var dialogTag = diagElement[i];    
												dialogTag.close(); 
											}
	    								}    		
	    							} 
								}
}
