/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
18/11/2015	IN057113			Karthi L							 			ML-MMOH-CRF-0335 - IN057113
08/01/2018	IN064446			Raja S			08/01/2018		Ramesh G		GHL-CRF-0469
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var isPrintPinValidationReq; //ML-MMOH-CRF-0335 - IN057113
async function printNotes(printMode) 
{ 
	var pMode = printMode;
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var encounter_id		=	document.forms[0].encounter_id.value;
	var patient_id			=	document.forms[0].patient_id.value;
	var accession_num		= 	document.forms[0].accession_num.value;	
	var conf_pin_req_yn 	= 	document.forms[0].l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		isPinValidationReq(patient_id, encounter_id, accession_num, '');
		if(isPrintPinValidationReq == 'Y') {
			retVal =  await validatePintoPrint();
			if(retVal == 'X')
				return false;
		}
	}
	//ML-MMOH-CRF-0335 - IN057113 - End
	
	var retVal		= 	new String();
	var dialogTop	=	"60"; 
	var dialogHeight=	"100vh" ;
	var dialogWidth	=	"90vw" ;
	var data		=	new Array();
	var features	=	"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=yes" ;
	var header = "";
	var header1 = "";
	var PrintMode = "";
	var footer="";
	//var accession_num	= parent.frames[0].document.forms[0].accession_num.value;	//ML-MMOH-CRF-0335 - IN057113 - commented and moved up
	var facility_id		= parent.frames[0].document.forms[0].facility_id.value;	

   	var patient_line		=	document.forms[0].patient_line.value;
   	var performed_by_name	=	document.forms[0].performed_by_name.value;
	var visit_adm_date		=	document.forms[0].visit_adm_date.value;
	var specialty_name		=	document.forms[0].specialty_name.value;
	var function_id			=	document.forms[0].function_id.value;
	var episode_type		=	document.forms[0].episode_type.value;
	var title				=	document.forms[0].note_header_desc.value;
	var lastModifiedBy		=	document.forms[0].lastModifiedBy.value;
	//var encounter_id		=	document.forms[0].encounter_id.value; //ML-MMOH-CRF-0335 - IN057113 - commented and moved up
	//var patient_id			=	document.forms[0].patient_id.value; //ML-MMOH-CRF-0335 - IN057113 - commented and moved up
	var patient_name		=	document.forms[0].patient_name.value;
	var patient_age			=	document.forms[0].patient_age.value;
	var patient_sex			=	document.forms[0].patient_sex.value;
	var locationDesc		=	document.forms[0].locationDesc.value;
	var patient_class		=	document.forms[0].patient_class.value;
	var event_date_time		=	document.forms[0].event_date_time.value;
	var dischargeDateTime	=	document.forms[0].dischargeDateTime.value;
	var printDateTime		=	document.forms[0].printDateTime.value;
	var note_type			=	document.forms[0].note_type.value;
	var attending_practitioner	=	document.forms[0].attending_practitioner.value
	var admitting_practitioner	=	document.forms[0].admitting_practitioner.value
	var med_service	=	document.forms[0].med_service.value
	var appl_task_id	=	document.forms[0].appl_task_id.value
	//alert("form..."+document.forms[0].patient_class.value);
	var episodeDesc = document.forms[0].patient_class.value;
	var ppFlag = document.forms[0].printPreviewFlag.value;

	if(episode_type == "O"  || episode_type == "I")
		episodeDesc = episode_type + "P";

/*
	if (encounter_id != "0")
	{
		var arrMain			=	patient_line.split("|");

		var arrPatient		=	arrMain[0].split(",");
		patient_id			=	arrMain[1].substring(3,arrMain[1].length);
		var arrLocnDetails	=	arrMain[2].split(",");
		//	encounter_id	=	arrMain[3].substring(10,arrMain[3].length);

		var check = arrPatient.length;
		var arrRoomBed	="";
		var accession_num	= parent.frames[0].document.forms[0].accession_num.value;	
		var facility_id		= parent.frames[0].document.forms[0].facility_id.value;	
		var arrPractLocn	=	arrLocnDetails[0].split("/");

		if(episode_type=="I" && arrLocnDetails.length == 2  )
			arrRoomBed		=	arrLocnDetails[1].split("/");

		if(specialty_name==null)	specialty_name	=	"";

		patient_name = ((arrPatient[0]==null)?"":arrPatient[0]);
		patient_sex = ((arrPatient[3]==null)?"":arrPatient[3])
		patient_age = ((arrPatient[2]==null)?"":arrPatient[2])

	}
	else
	{
		patient_id	= document.forms[0].patient_id.value;
		patient_name = document.forms[0].patient_name.value;
		patient_sex = document.forms[0].patient_sex.value;
		patient_age = document.forms[0].patient_age.value;
		check =3;

	}
*/

//	if(parseInt(check)==3)
	{
			header = "<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >";
			/*header +="<tr><td align='left' width='5%' rowspan='2'><img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'></td><td  align=center><h3>"+document.forms[0].siteName.value+"</h3></td></tr>";*/
			header +="<tr> <td class='HEADER' align='center' width='5%' id='headerImageID'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'></td><td  align=center><h3>"+document.forms[0].siteName.value+"</h3></td></tr>";
			header +="<tr><td width='5%' >&nbsp;</td><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>";
			header +="<tr><td>&nbsp;</td><td align=center><h4>"+title+"</h4></td></tr></table>";
			header +="<br>";

			header1 +="<table border='1' cellpadding='3' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>";
			header1 +="<tr><td>";
			header1 +="<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center>";
			header1 +="<tr><td nowrap><b>"+getLabel("Common.patientId.label","common")+"</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>";
			header1 +="<td nowrap><b>"+getLabel("Common.name.label","common")+"</b></td><td colspan =3><font size=2>: "+patient_name+"</font></td></tr>";
			header1 +="<tr><td nowrap><b>"+getLabel("Common.gender.label","common")+"</b></td><td nowrap><font size=2>: "+patient_sex+"</font></td><td nowrap><b>"+getLabel("Common.age.label","common")+"</b></td><td nowrap><font size=2>: "+patient_age+"</font></td></tr>";

			if(encounter_id != "0" )
			{
				header1 +="<tr><td nowrap><b>"+getLabel("Common.encounterid.label","common")+"</b></td><td nowrap><font size='2'>: "+encounter_id+"</font></td><td nowrap><b>"+getLabel("Common.encountertype.label","common")+"</b></td><td><font size='2'>: "+patient_class+"</font></td><td align='right' nowrap><b>"+getLabel("Common.encounterdate.label","common")+"</b></td><td nowrap><font size='2'>&nbsp;: "+visit_adm_date+"</font></td></tr>";
				header1 +="<tr><td nowrap><b>"+getLabel("Common.Location.label","common")+"</b></td>";
			}
			

	}
/*
	else if(parseInt(check)==4)
	{
		header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center >"+
			"<tr><td align='left' width='5%' rowspan='2' ><img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'></td><td  align=center><h3>"+document.forms[0].siteName.value+"</h3></td></tr>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>"+
			"<tr><td>&nbsp;</td><td align=center><h4>"+title+"</h4></td></tr></table>";
			header += "<br>";
		    header += "<table width='100%' border='1' cellpadding=0 cellspacing=0 align=center style='font-family:Verdana;:background-color:#ADADAD'>";
			header += "<tr><td>";
			header += "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>";
			header += "<tr><td nowrap><b>Patient ID</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>";
			header += "<td nowrap ><b>Name</b></td><td colspan ='3'><font size='2'>: "+patient_name+"</font></td></tr>";
			header += "<tr><td><font size='2'>&nbsp;"+patient_sex+"</font></td></tr>";
			header += "<tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+patient_sex+"</font></td><td nowrap><b>Age</b></td><td nowrap><font size='2'>: "+patient_age+"</font></td></tr>";
			header += "<tr><td nowrap><b>Encounter ID</b></td><td nowrap><font size='2'>: "+encounter_id+"</font></td><td nowrap><b>Encounter Type</b></td><td nowrap><font size='2'>: "+episode_type+"P"+"</font></td><td align='right' nowrap><b>Encounter Date</b></td><td nowrap><font size='2'>&nbsp;: "+visit_adm_date+"</font></td></tr>";
			header += "<tr><td nowrap><b>Location</b></td>";
	}
	*/

			if(encounter_id != "0")
			{
				if(episode_type=="O")
				{
					header1 += "<td colspan='3' nowrap><font size='2'>: "+locationDesc+"</font></td>";
				}
				else
				{
					header1 += 	"<td colspan='3' nowrap><font size='2'>: "+locationDesc+"</font></td>";
				}
				
				header1+="<td align='right' nowrap><b>"+getLabel("Common.dischargedate.label","common")+"</b></td><td><font size='2'>&nbsp;: "+document.forms[0].dischargeDateTime.value+"</font></td></tr>";
				
				header1+="<tr><td nowrap><b>"+getLabel("Common.speciality.label","common")+"</b></td><td colspan='2' nowrap><font size='2'>: "+document.forms[0].specialty_name.value+"</font></td>";
				header1+="<td colspan='2'  align='right' nowrap><b>"+getLabel("Common.AttendingPractitioner.label","common")+"</b></td><td nowrap><font size='2'>&nbsp;: "+document.forms[0].attending_practitioner.value+"</font></td></tr>";
			}
	
			header1 += "</table></td></tr></table>";		

	footer	=  "<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>";
	footer +=  "<tr><td><table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.authorizedby.label","common");
	footer +=  "</b></td><td width='45%' align='left'>:  <font size='2'>";
	footer +=  document.forms[0].authorizedBy.value;
	footer +=  "</font></td><td width='15%'><b>Signature</b></td><td width='20%' align='left'>:  </td></tr>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.LastModifiedBy.label","common");
	footer +=  "</b></td><td width='45%' align='left'>:  <font size='2'>";
	footer +=  lastModifiedBy;
	footer +=  "</font></td><td width='15%'><b>";
	footer +=  getLabel("Common.Signature.label","common");
	footer +=  "</b></td><td width='20%' align='left'>:  </td></tr>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.PrintDateTime.label","common");
	footer +=  "</b></td><td width='45%' align='left'> <font size='2'>:  ";
	footer +=  document.forms[0].printDateTime.value;
	footer +=  "</font></td><td width='15%'><b>";
	footer +=  getLabel("Common.LoggedUser.label","common");
	footer +=  "</b></td><td width='20%' align='left'><font size='2'>:  ";
	footer +=  document.forms[0].loggedUser.value;
	footer +=  "</font></td></tr></table></td></tr></table>";
/*[IN032210] Start
	data[0] = header;
	//data[1] = header1;
	data[1] = "shsh";
	//data[2] = footer;
	data[2] = "shsh";
*/
	data[0] = document.forms[0].siteName.value;
	data[1] = document.forms[0].facility_name.value;
	data[2] = title;
//[IN032210] End
	var dischargeSummary = document.forms[0].discharge_summary_text.value;
    var disclaimer ="";

	if(dischargeSummary !="")
	{
		disclaimer ="<br><table width='100%' border=0 cellpadding=0 cellspacing=0 align=center><tr><td>"+dischargeSummary+"</td><tr></table>"
		data[3] = disclaimer;
	}

	var arguments = data;
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+specialty_name+"&location_code="+locationDesc+"&performed_by_pract="+performed_by_name+"&performing_phy_name="+performed_by_name+"&event_title_desc="+title+"&Sex="+patient_sex+"&age="+patient_age+"&patient_class="+patient_class+"&note_type_desc="+title+"&event_date_time="+event_date_time+"&med_service="+med_service+"&attending_practitioner="+attending_practitioner+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+note_type+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime,arguments,features);
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+'&admitting_practitioner='+admitting_practitioner+"&bed_number="+bed_number,arguments,features);
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+'&admitting_practitioner='+admitting_practitioner,arguments,features); //Commented for IN064446
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+'&admitting_practitioner='+admitting_practitioner+"&printnotes=Y",arguments,features);
	//modified for IN064446 starts
	if(ppFlag=="Y")
	{
	window.open("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+'&admitting_practitioner='+admitting_practitioner+'&data[0]='+encodeURIComponent(data[0],"UTF-8")+'&data[1]='+encodeURIComponent(data[1],"UTF-8")+'&data[2]='+encodeURIComponent(data[2],"UTF-8")+'&ppFlag='+ppFlag,'PrintNote',features );  
	}else{
	 window.open("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+'&admitting_practitioner='+admitting_practitioner+'&data[0]='+encodeURIComponent(data[0],"UTF-8")+'&data[1]='+encodeURIComponent(data[1],"UTF-8")+'&data[2]='+encodeURIComponent(data[2],"UTF-8")+'&ppFlag=N',arguments,features ); //Modified for IN064446 
	}
	//modified for IN064446 ends
	
}

function changeImage(obj,defaultVal)
{
	var prevIndex = 0;
	var flag=true;
	if(obj.value != "")
	{
		if(defaultVal!='defaultval'){
			//var flag = confirm(getMessage("","CA"));
			flag=false;
			flag = confirm(getMessage("IMAGE_WIPE",'CA'));
		}
		if(flag)
		{
			parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.avl_image_selected.value ='true';
			
			var HTMLContent = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'>";
			HTMLContent += "<form name = 'ImageLoaderFrm' action = '../../eCA/jsp/RecClinicalNotesImageFileReader.jsp' ";
			HTMLContent += " method = 'post'>";		
			HTMLContent += " <input type = 'hidden' name = 'image' value = '" + obj.value + "'>";
			HTMLContent += "<input type='hidden' name='image_ref' id='image_ref' value='"+obj.options[obj.selectedIndex].id+"'>";
			HTMLContent += "</form>";
			HTMLContent += "</body></html>";
			top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLContent);
			top.content.messageFrame.document.ImageLoaderFrm.submit();
			prevIndex = obj.selectedIndex;
//			parent.parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.image_edited_yn.value ='true';

		}
		else
			obj.selectedIndex = prevIndex;
	}
}

function UnloadSecImage()
{
	//alert("drawing");
}
function loadSecImage(sec_hdg_code,child_sec_hdg_code)
{
		var image_hidden_name = "img_"+sec_hdg_code+"_"+child_sec_hdg_code;
		//IN038493 Start.
		//var image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		var image_hidden_obj = "";
		var objFrame= eval("top.content.workAreaFrame.RecClinicalNotesFrame");
		if(objFrame!=undefined){
			image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		}else{
			image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		}		
		//IN038493 End.
		if(image_hidden_obj.value != "")					
		{
			parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(image_hidden_obj.value);
		}
		
}

function closeWindow()
{
	function_id	=	document.forms[0].function_id.value;
	if( function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM" || function_id=="SPCL_NOTE")
	{
		top.close();
	}
	if( function_id=="REFERRAL_LETTER" )
	{
		if(top.content != null && !top.document.getElementById('dialog-body'))
		{
			if(top.content.CommonToolbar != null)//parent.parent.frames[0].name=='Options2')//when called from main window
			{
				top.content.workAreaFrame.location.href = "../../eCommon/html/blank.html";
			}
			else
			{
				//when present in the model window
				window.close();
			}
		}
		else
			window.close();
	}
	else
	{
		parent.window.close();
	}
}

function callShowSubSection(qryString, sectionName, section_hdg_code)
{
	var display_code = 'FullSection';
	parent.RecClinicalNotesLinkDocsSubSectionFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkDocsSubSection.jsp?" + qryString + "&section_name=" + sectionName + "&section_hdg_code=" + section_hdg_code;
	parent.RecClinicalNotesLinkDocsDisplayFrame.location.href = "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp?" + qryString + "&section_hdg_code=" + section_hdg_code + "&display_code=" + display_code;
	parent.RecClinicalNotesLinkDocsDisplaySelectFrame.RecClinicalNotesLinkForm.select.disabled = false;
}

function showPreview(qryString, section_hdg_code)
{
	parent.RecClinicalNotesLinkDocsDisplayFrame.location.href = "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp?" + qryString + "&section_hdg_code=" + section_hdg_code;
	parent.RecClinicalNotesLinkDocsSubSectionFrame.location.href = "../../eCommon/html/blank.html";
	parent.RecClinicalNotesLinkDocsDisplaySelectFrame.RecClinicalNotesLinkForm.select.disabled=false;
}

function showDetails(vals,check,event_desc)
{
	var arr = vals.split("~");
	var patientid				=	document.forms[0].patient_id.value;
	var accessionnum			=	escape(arr[0])==null?"":escape(arr[0]);
	var datatype				=	arr[1]==null?"":arr[1];
	var histtype				=	arr[2]==null?"":arr[2];
	var contr_sys_id			=	arr[3]==null?"":arr[3];
	var contr_sys_event_code	=	arr[4]==null?"":arr[4];
	var eventdatetime			=	arr[5]==null?"":arr[5];
	var eventclass				=	arr[6]==null?"":arr[6];
	var eventgroup				=	arr[7]==null?"":arr[7];
	var eventitem				=	arr[8]==null?"":arr[8];
	document.forms[0].data_type.value=datatype;
	var params = '?patient_id='+patientid+'&hist_type='+histtype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&event_date='+eventdatetime+'&data_type='+datatype+'&contr_sys_id='+contr_sys_id+'&contr_sys_event_code='+contr_sys_event_code;

	if(check != 'Heading')
		params+='&accession_num='+accessionnum;

	if(datatype == "TXT" && check!="Heading")
		parent.RecClinicalNotesLinkDocsDisplayFrame.location.href = "../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&from=B&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code;
	else
		parent.RecClinicalNotesLinkDocsDisplayFrame.location.href = '../../eCA/jsp/RecClinicalNotesDisplay.jsp'+params

	var params_for_section_frame = "accession_num=" + accessionnum + "&event_desc=" + event_desc;
	parent.RecClinicalNotesLinkDocsSectionFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkDocsSection.jsp?" + params_for_section_frame;
	parent.RecClinicalNotesLinkDocsSubSectionFrame.location.href = "../../eCommon/html/blank.html";
	parent.RecClinicalNotesLinkDocsDisplaySelectFrame.RecClinicalNotesLinkForm.select.disabled = false;
}

function getDigitalNote()
{
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesDigitalNoteIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
//ML-MMOH-CRF-0335 - IN057113
async function validatePintoPrint() {
	var retVal = 	new String();
	var dialogHeight= "9" ;
	var dialogWidth	= "25" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eCA/jsp/AuthorizePinAccess.jsp?"+"",arguments,features);
	if(retVal == undefined || retVal == 'undefined') retVal = "X";
	return retVal;
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

