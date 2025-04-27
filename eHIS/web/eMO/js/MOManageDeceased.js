
//this tab is for manage deceased view
function ManageDeceasedView(tabidx)
{
	
	if(tabidx == 1)
    {
	selectTab("mndec"); parent.frames[2].document.getElementById('bprt').src='../../eMO/images/Body_Parts_Click.gif'
	 parent.frames[2].document.getElementById('mndec').src='../../eMO/images/Deceased_Patients.gif'
	 parent.frames[1].document.forms[0].queryExecute.value='deseasedqry'
	 parent.frames[1].document.forms[0].registration_no.value="";
	 parent.frames[1].document.forms[0].patient_id.value="";
	 parent.frames[1].document.forms[0].burial_permit_no.value="";
	 
		len=parent.frames[1].document.forms[0].obt_frm.length
		for (i=0;i<=len;i++ )
        {
             parent.frames[1].document.forms[0].obt_frm.remove(1);
        }
		var opt=document.createElement('OPTION');
        opt.text=getLabel("Common.notapplicable.label","Common");
		 opt.value="C"
        parent.frames[1].document.forms[0].obt_frm.add(opt)
		parent.frames[1].document.forms[0].obt_frm.options[1].selected=true;
		parent.frames[1].document.forms[0].obt_frm.disabled=true;
		parent.frames[1].document.forms[0].search.click();
		//document.getElementById("tab1").scrollIntoView();
	 
    
	}
	
	else if(tabidx == 3)
	 {  
		selectTab("bprt");
		parent.frames[1].document.forms[0].registration_no.value="";
	    parent.frames[1].document.forms[0].patient_id.value="";
	    parent.frames[1].document.forms[0].burial_permit_no.value="";
	 
		parent.frames[1].document.forms[0].queryExecute.value='bodypartqry'
		parent.frames[2].document.getElementById('bprt').src='../../eMO/images/Body_Parts.gif'
		parent.frames[2].document.getElementById('mndec').src='../../eMO/images/Deceased_Patients_Click.gif'
		if(parent.frames[1].document.forms[0].callfrommoreg.value=="callfrommoreg")
		 {	
			var msg=getMessage('BODY_PART_DTLS_CANT_VIEW','MO')
	      alert(msg);
		  return ;
		 }
		len=parent.frames[1].document.forms[0].obt_frm.length
		for (i=0;i<=len;i++)
        {
             parent.frames[1].document.forms[0].obt_frm.remove(0);
        }
		parent.frames[1].document.forms[0].obt_frm.disabled=false;
	var opt=document.createElement('OPTION');
    opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
    opt.value=""
    parent.frames[1].document.forms[0].obt_frm.add(opt)
	var opt=document.createElement('OPTION');
    opt.text=getLabel("eMO.AmputatedBodyPart.label","MO");
    opt.value="A"
    parent.frames[1].document.forms[0].obt_frm.add(opt)
		
	var opt=document.createElement('OPTION');
    opt.text=getLabel("eMO.DeadFetus.label","MO");
    opt.value="D"
    parent.frames[1].document.forms[0].obt_frm.add(opt)
	
	var opt=document.createElement('OPTION');
    opt.text=getLabel("eMO.UnidentifiedBodyPart.label","MO");
    opt.value="U"
    parent.frames[1].document.forms[0].obt_frm.add(opt)
	
	parent.frames[1].document.forms[0].search.click();
	
	
	}
	
			
}

function enableSpecGif()
{
speci_desc1=document.forms[0].speci_desc1.value;
speci_type1=document.forms[0].speci_type1.value;
anotomical_site_desc1=document.forms[0].anotomical_site_desc1.value;
collection_time1=document.forms[0].collection_time1.value;

speci_desc2=document.forms[0].speci_desc2.value;
speci_type2=document.forms[0].speci_type2.value;
anotomical_site_desc2=document.forms[0].anotomical_site_desc2.value;
collection_time2=document.forms[0].collection_time2.value;

speci_desc3=document.forms[0].speci_desc3.value;
speci_type3=document.forms[0].speci_type3.value;
anotomical_site_desc3=document.forms[0].anotomical_site_desc3.value;
collection_time3=document.forms[0].collection_time3.value;

speci_desc4=document.forms[0].speci_desc4.value;
speci_type4=document.forms[0].speci_type4.value;
anotomical_site_desc4=document.forms[0].anotomical_site_desc4.value;
collection_time4=document.forms[0].collection_time4.value;

speci_desc5=document.forms[0].speci_desc5.value;
speci_type5=document.forms[0].speci_type5.value;
anotomical_site_desc5=document.forms[0].anotomical_site_desc5.value;
collection_time5=document.forms[0].collection_time5.value;

speci_desc6=document.forms[0].speci_desc6.value;
speci_type6=document.forms[0].speci_type6.value;
anotomical_site_desc6=document.forms[0].anotomical_site_desc6.value;
collection_time6=document.forms[0].collection_time6.value;

if(speci_desc1!=""||speci_type1!=""||anotomical_site_desc1!=""||collection_time1!=""||speci_desc2!=""||speci_type2!=""||anotomical_site_desc2!=""||collection_time2!=""||speci_desc3!=""||speci_type3!=""||anotomical_site_desc3!=""||collection_time3!=""||speci_desc4!=""||speci_type4!=""||anotomical_site_desc4!=""||collection_time4!=""||speci_desc5!=""||speci_type5!=""||anotomical_site_desc5!=""||collection_time5!=""||speci_desc6!=""||speci_type6!=""||anotomical_site_desc6!=""||collection_time6!="")
{
parent.frames[2].document.getElementById('imgenable3').style.visibility='visible'
parent.frames[2].document.getElementById('imgenable4').style.visibility='visible'

parent.frames[2].document.getElementById('imgenable5').style.visibility='visible'

}else
{
parent.frames[2].document.getElementById('imgenable3').style.visibility='hidden'
parent.frames[2].document.getElementById('imgenable4').style.visibility='hidden'
parent.frames[2].document.getElementById('imgenable5').style.visibility='hidden'
}

if(speci_desc1!=""||speci_type1!=""||anotomical_site_desc1!=""||collection_time1!="")
{
document.getElementById('specimagae1').style.visibility="visible";
document.getElementById('specitypeimage1').style.visibility="visible";
document.getElementById('specanotimagae1').style.visibility="visible";
document.getElementById('specollimagae1').style.visibility="visible";


}else
{
document.getElementById('specimagae1').style.visibility="hidden";
document.getElementById('specitypeimage1').style.visibility="hidden";
document.getElementById('specanotimagae1').style.visibility="hidden";
document.getElementById('specollimagae1').style.visibility="hidden";


}

if(speci_desc2!=""||speci_type2!=""||anotomical_site_desc2!=""||collection_time2!="")
{
document.getElementById('specimagae2').style.visibility="visible";
document.getElementById('specitypeimage2').style.visibility="visible";
document.getElementById('specanotimagae2').style.visibility="visible";
document.getElementById('specollimagae2').style.visibility="visible";


}else
{
document.getElementById('specimagae2').style.visibility="hidden";
document.getElementById('specitypeimage2').style.visibility="hidden";
document.getElementById('specanotimagae2').style.visibility="hidden";
document.getElementById('specollimagae2').style.visibility="hidden";


}

if(speci_desc3!=""||speci_type3!=""||anotomical_site_desc3!=""||collection_time3!="")
{
document.getElementById('specimagae3').style.visibility="visible";
document.getElementById('specitypeimage3').style.visibility="visible";
document.getElementById('specanotimagae3').style.visibility="visible";
document.getElementById('specollimagae3').style.visibility="visible";


}else
{
document.getElementById('specimagae3').style.visibility="hidden";
document.getElementById('specitypeimage3').style.visibility="hidden";
document.getElementById('specanotimagae3').style.visibility="hidden";
document.getElementById('specollimagae3').style.visibility="hidden";


}

if(speci_desc4!=""||speci_type4!=""||anotomical_site_desc4!=""||collection_time4!="")
{
document.getElementById('specimagae4').style.visibility="visible";
document.getElementById('specitypeimage4').style.visibility="visible";
document.getElementById('specanotimagae4').style.visibility="visible";
document.getElementById('specollimagae4').style.visibility="visible";


}else
{
document.getElementById('specimagae4').style.visibility="hidden";
document.getElementById('specitypeimage4').style.visibility="hidden";
document.getElementById('specanotimagae4').style.visibility="hidden";
document.getElementById('specollimagae4').style.visibility="hidden";


}

if(speci_desc5!=""||speci_type5!=""||anotomical_site_desc5!=""||collection_time5!="")
{
document.getElementById('specimagae5').style.visibility="visible";
document.getElementById('specitypeimage5').style.visibility="visible";
document.getElementById('specanotimagae5').style.visibility="visible";
document.getElementById('specollimagae5').style.visibility="visible";


}else
{
document.getElementById('specimagae5').style.visibility="hidden";
document.getElementById('specitypeimage5').style.visibility="hidden";
document.getElementById('specanotimagae5').style.visibility="hidden";
document.getElementById('specollimagae5').style.visibility="hidden";


}

if(speci_desc6!=""||speci_type6!=""||anotomical_site_desc6!=""||collection_time6!="")
{
document.getElementById('specimagae6').style.visibility="visible";
document.getElementById('specitypeimage6').style.visibility="visible";
document.getElementById('specanotimagae6').style.visibility="visible";
document.getElementById('specollimagae6').style.visibility="visible";


}else
{
document.getElementById('specimagae6').style.visibility="hidden";
document.getElementById('specitypeimage6').style.visibility="hidden";
document.getElementById('specanotimagae6').style.visibility="hidden";
document.getElementById('specollimagae6').style.visibility="hidden";


}





}


 function clearTissueProc(obj,tisue,imgdis,tissueimg)
 {
  cnt =document.forms[0].cnt.value;
   imgcnt=0;
  for(i=0;i<cnt;i++)
 {
 if(eval("parent.frames[2].document.forms[0].org"+i+".checked"))
 {
 imgcnt++;
 }
 
 }
if(imgcnt>0)
{
 document.getElementById('imgenable6').style.visibility="visible";
 document.getElementById('imgenable7').style.visibility="visible";
}else
 {
 document.getElementById('imgenable6').style.visibility="hidden";
 document.getElementById('imgenable7').style.visibility="hidden";

 }

  if(obj.checked==false)
 {tisue.value=""
  tisue.disabled=true;  
 eval("document.all."+imgdis+".disabled=true")
	 eval("document.all."+tissueimg+".style.visibility='hidden'")
 
 }else
 {
 tisue.disabled=false;  
 eval("document.all."+imgdis+".disabled=false")
 eval("document.all."+tissueimg+".style.visibility='visible'")
 }

 
 }
 async function viewMovmentHist()
 {
 var patient_id=document.forms[0].patient_id.value;
 var registration_no=document.forms[0].registration.value;
 var dialogHeight = "70vh" ;
 var dialogWidth  = "40vw" ;
 var dialogTop    = "10";
 var dialogLeft   = "5";
 var arguments       = "" ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
// window.showModalDialog("../../eMO/jsp/MOViewMovementHistFrame.jsp?pid="+patient_id+"&rno="+registration_no,arguments,features); 
//Above line commented and below line added for this CRF Bru-HIMS-CRF-367
//window.showModalDialog("../../eMO/jsp/MOViewMovementHistFrame.jsp?pid="+patient_id,arguments,features);
 retVal= await top.window.showModalDialog("../../eMO/jsp/MOBodyMovementQuery.jsp?pid="+patient_id+"&function_id=ViewMovementHistory",arguments,features);
window.close();
 }
 
 function enablePMDtls(bodyrecdate,startdate)
 {
	 mode=document.getElementById('viewdata').value;
   if(mode=="viewdata")
  {
document.getElementById('post_perf_pract_desc1').disabled=true
document.getElementById('post_perf_role1').disabled=true
document.getElementById('pract_desc4').disabled=true
document.getElementById('pract_desc5').disabled=true
document.getElementById('desig_desc4').disabled=true
document.getElementById('desig_desc5').disabled=true
document.getElementById('post_perf_pract_but').disabled=true

document.getElementById('pract_desc14').readOnly=true
document.getElementById('PM_PURPOSE').disabled=true
document.getElementById('pract_desc1').disabled=true
document.getElementById('role1').disabled=true
document.getElementById('pract_desc2').disabled=true
document.getElementById('role2').disabled=true
document.getElementById('pract_desc3').disabled=true
document.getElementById('role3').disabled=true
document.getElementById('pract_desc4').disabled=true
document.getElementById('role4').disabled=true
document.getElementById('pract_desc5').disabled=true
document.getElementById('role5').disabled=true
document.getElementById('pract6').disabled=true
document.getElementById('desi1').disabled=true
document.getElementById('pract7').disabled=true
document.getElementById('desi2').disabled=true
document.getElementById('pm_start_date_time').disabled=true
document.getElementById('pm_end_date_time').disabled=true
document.getElementById('pract_but').disabled=true;
document.getElementById('pract_but1').disabled=true;
//document.getElementById('pract_but3').disabled=true;
//document.getElementById('pract_but4').disabled=true;
//document.getElementById('pract_but5').disabled=true;
document.getElementById('pract_but14').disabled=true;
document.getElementById('pmstart').disabled=true;
document.getElementById('pmcmpdis').disabled=true;
document.getElementById('pract_desc9').disabled=true
document.getElementById('mr_diagnosis_desc').disabled=true
document.getElementById('onset_date1').disabled=true
document.getElementById('mr_diagnosis_desc1').disabled=true
document.getElementById('onset_date2').disabled=true
document.getElementById('mr_diagnosis_desc2').disabled=true
document.getElementById('onset_date3').disabled=true
document.getElementById('mr_diagnosis_desc3').disabled=true
document.getElementById('onset_date4').disabled=true
document.getElementById('mr_diagnosis_desc4').disabled=true
document.getElementById('onset_date5').disabled=true
document.getElementById('mr_diagnosis_desc5').disabled=true
document.getElementById('onset_date6').disabled=true
document.getElementById('mr_diagnosis_desc6').disabled=true //bru-hims-crf-270
document.getElementById('onset_date7').disabled=true//bru-hims-crf-270
document.getElementById('mr_diagnosis_desc7').disabled=true //bru-hims-crf-270
document.getElementById('onset_date8').disabled=true//bru-hims-crf-270
document.getElementById('cause_remarks1').disabled=true//bru-hims-crf-270
document.getElementById('cause_remarks2').disabled=true//bru-hims-crf-270
document.getElementById('cause_remarks3').disabled=true//bru-hims-crf-270
document.getElementById('cause_remarks4').disabled=true//bru-hims-crf-270
document.getElementById('cause_remarks5').disabled=true//bru-hims-crf-270
document.getElementById('cause_remarks6').disabled=true//bru-hims-crf-270
document.getElementById('manner_of_death').disabled=true
document.getElementById('postmortem_findings').disabled=true

document.getElementById('pract_but9').disabled=true
document.getElementById('mr_diagnosis_select').disabled=true
document.getElementById('mr_diagnosis_select1').disabled=true
//document.getElementById('mr_diagnosis_select2').disabled=true
//document.getElementById('mr_diagnosis_select3').disabled=true
document.getElementById('mr_diagnosis_select4').disabled=true
document.getElementById('mr_diagnosis_select5').disabled=true
document.getElementById('mr_diagnosis_select6').disabled=true //bru-hims-crf-270
document.getElementById('mr_diagnosis_select7').disabled=true //bru-hims-crf-270
document.getElementById('onsetdt1').disabled=true
document.getElementById('onsetdt2').disabled=true
document.getElementById('onsetdt3').disabled=true
document.getElementById('onsetdt4').disabled=true
document.getElementById('onsetdt5').disabled=true
document.getElementById('onsetdt6').disabled=true
document.getElementById('onsetdt7').disabled=true //bru-hims-crf-270
document.getElementById('onsetdt8').disabled=true //bru-hims-crf-270
document.getElementById('anotomical_site_desc1').disabled=true
document.getElementById('anot1').disabled=true
document.getElementById('collection_time1').disabled=true
document.getElementById('anotomical_site_desc2').disabled=true
document.getElementById('anot2').disabled=true
document.getElementById('collection_time2').disabled=true
document.getElementById('anotomical_site_desc3').disabled=true
document.getElementById('anot3').disabled=true
document.getElementById('collection_time3').disabled=true
document.getElementById('anotomical_site_desc4').disabled=true
document.getElementById('anot4').disabled=true
document.getElementById('collection_time4').disabled=true
document.getElementById('anotomical_site_desc5').disabled=true
document.getElementById('anot5').disabled=true
document.getElementById('collection_time5').disabled=true
document.getElementById('anotomical_site_desc6').disabled=true
document.getElementById('anot6').disabled=true
document.getElementById('collection_time6').disabled=true

document.getElementById('speci_desc1').disabled=true
document.getElementById('speci_type1').disabled=true
document.getElementById('speci_desc2').disabled=true
document.getElementById('speci_type2').disabled=true
document.getElementById('speci_desc3').disabled=true
document.getElementById('speci_type3').disabled=true
document.getElementById('speci_desc4').disabled=true
document.getElementById('speci_type4').disabled=true
document.getElementById('speci_desc5').disabled=true
document.getElementById('speci_type5').disabled=true
document.getElementById('speci_desc6').disabled=true
document.getElementById('speci_type6').disabled=true

document.getElementById('pract_desc12').disabled=true
document.getElementById('pract_but12').disabled=true
document.getElementById('spec_handed_over_to').disabled=true
document.getElementById('spec_handed_over_date').disabled=true
document.getElementById('spechand').disabled=true
document.getElementById('col1').disabled=true
document.getElementById('col2').disabled=true
document.getElementById('col3').disabled=true
document.getElementById('col4').disabled=true
document.getElementById('col5').disabled=true
document.getElementById('col6').disabled=true
	
if(bodyrecdate!=null && bodyrecdate!="")
	bodyrecdate =  convertDate(bodyrecdate,"DMYHM",localeName,"en" );
if(startdate!=null && startdate!="")
	startdate =  convertDate(startdate,"DMYHM",localeName,"en" );

	CalculateDuration(bodyrecdate,startdate,'Y'); 
  if(document.getElementById('end_date').value!="")
	  {
		var bodyenddate =  convertDate(document.getElementById('end_date').value,"DMYHM",localeName,"en" );

		//CalculateDuration(startdate,document.getElementById("end_date").value,'N'); 
		CalculateDuration(startdate,bodyenddate,'N'); 
	  }
  
  }else{

	  if(parent.frames[2].document.forms[0].PM_PURPOSE!=null)
		  parent.frames[2].document.forms[0].PM_PURPOSE.focus();
  if(startdate!="")
  {
	 
	 parent.frames[2].document.forms[0].pm_start_date_time.readOnly=true
     parent.frames[2].document.forms[0].pmstart.disabled=true
	
	
	
	if(document.getElementById('isPMFindingDetailsAppl').value=="true" && document.getElementById('record_pm_find_dtls_yn').value=="N") // added by mujafar for ML-MMOH-CRF-0880
	document.getElementById('hidetab2').style.display='none';
	else
	document.getElementById('hidetab2').style.display='block';
	document.getElementById('hidetab3').style.visibility='visible';
	
	if(document.getElementById('tissuecnt').value>0)
	document.getElementById('hidetab4').style.visibility='visible';
    else
	document.getElementById('hidetab4').style.visibility='hidden';
	if(bodyrecdate!=null && bodyrecdate!="")
		bodyrecdate =  convertDate(bodyrecdate,"DMYHM",localeName,"en" );
	if(startdate!=null && startdate!="")
		startdate =  convertDate(startdate,"DMYHM",localeName,"en" );

	CalculateDuration(bodyrecdate,startdate,'Y');
	 }
 }
 }
 
 function startEndCancelPostmortem()
 {
    
 cnt=parent.frames[2].document.forms[0].cnt.value;
 var checkedCode="";
 
 if(parent.frames[2].document.forms[0].PM_PURPOSE.value.length>250)
 {
	alert(getMessage("PM_PURPOSE","MO"));
	return false;
}
 var alertdata="";
 for(i=0;i<cnt;i++)
 {
  
   if(eval("parent.frames[2].document.forms[0].org"+i+".checked"))
 {  alertdata="Y";
	  if(eval("parent.frames[2].document.forms[0].tissue"+i+".value")=="")
	 {
		alert(getMessage("ENTER_TISSUE_PROCMENT_DATE","MO"));
		return;
	 
	 }

  
 
 }

if(eval("parent.frames[2].document.forms[0].tissue"+i+".value")=="")
 {	dateval="N"
 }else
 {
dateval=eval("parent.frames[2].document.forms[0].tissue"+i+".value")
 }
checkedCode=checkedCode+eval("parent.frames[2].document.forms[0].org"+i+".value")+"|"+dateval+"|"
 
 
 }
parent.frames[2].document.forms[0].donatedorgan.value=checkedCode
if(alertdata=="Y")
 {

 if(parent.frames[2].document.forms[0].tissue_procured_by.value=="")
	 {
	 
		
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("eMO.TissueProcuredPrfmdBy.label","MO"));
		alert(msg);
		return false;
	 }

  if(parent.frames[2].document.forms[0].tissue_proc_date.value=="")
	 {
		//alert("APP-000001 Tissue procurement performed date cannot be blank")
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("eMO.TissueProcuredPrfmdDt.label","MO"));
		alert(msg);
		return false;	 
	 }

 }


pract_desc1=parent.frames[2].document.forms[0].pract_desc1.value;
role1=parent.frames[2].document.forms[0].role1.value;
 
 witness1=parent.frames[2].document.forms[0].pract6.value;
 witness2=parent.frames[2].document.forms[0].pract7.value; 	
 if(witness1!=""||witness2!="")
 {
 if(witness1==witness2)
 {

alert(getMessage("SAME_WITNESS","MO"))
	return false;
 }
 }
 
 
 if(parent.frames[2].document.forms[0].post_perf_pract_desc1.value!=''&&parent.frames[2].document.forms[0].post_perf_role1.value=="")
 {
	 var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	 msg = msg.replace("$",getLabel("Common.Role.label","Common"));
  alert(msg);	 
  return false
 }else if(parent.frames[2].document.forms[0].post_perf_pract_desc1.value==''&&parent.frames[2].document.forms[0].post_perf_role1.value!="")
 {
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace("$",getLabel("Common.practitioner.label","Common"));
	alert(msg);	 
	 //alert("APP-000001 Practioner cannot be blank");	 
  return false
}
 
 for (i=1;i<=5 ;i++)
 {
 if(eval("parent.frames[2].document.forms[0].pract_desc"+i).value!=''&& eval("parent.frames[2].document.forms[0].role"+i).value=='')
 {
  //alert("APP-000001 Role cannot be blank");	 
	 var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	 msg = msg.replace("$",getLabel("Common.Role.label","Common"));
	 alert(msg);	
	return false
 }else if(eval("parent.frames[2].document.forms[0].pract_desc"+i).value==''&&eval("parent.frames[2].document.forms[0].role"+i).value!="")
	 {
	 //alert("APP-000001 Practioner cannot be blank");	 
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("Common.practitioner.label","Common"));
		alert(msg);	
		return false
	 }
  }
 

 for (i=1;i<=7;i++)
 {
 if(eval("parent.frames[2].document.forms[0].mr_diagnosis_desc"+i).value!=''&& eval("parent.frames[2].document.forms[0].onset_date"+(i+1)).value=='')
 {
  //alert("APP-000001 Onset Date cannot be blank");	 
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace("$",getLabel("Common.onsetdate.label","Common"));
	alert(msg);	
	return false
 }else if(eval("parent.frames[2].document.forms[0].mr_diagnosis_desc"+i).value==''&&eval("parent.frames[2].document.forms[0].onset_date"+(i+1)).value!="")
	 {
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("Common.DiagnosisCode.label","Common"));
		alert(msg);	
	 //alert("APP-000001 Diag Code cannot be blank");	 
		return false
	 }
  }

if(parent.frames[2].document.forms[0].mr_diagnosis_code.value!=''&& parent.frames[2].document.forms[0].onset_date1.value=='')
{
	//alert("APP-000001 Onset Date cannot be blank");
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace("$",getLabel("Common.onsetdate.label","Common"));
	alert(msg);	
    return false

}else if(parent.frames[2].document.forms[0].mr_diagnosis_code.value==''&& parent.frames[2].document.forms[0].onset_date1.value!='')
{ 
	//alert("APP-000001 Diag Code cannot be blank");	
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace("$",getLabel("Common.DiagnosisCode.label","Common"));
	alert(msg);	
	return false
}
	
 for (i=1;i<=5 ;i++)
 {fld1=eval("parent.frames[2].document.forms[0].speci_type"+i).value
  fld2=eval("parent.frames[2].document.forms[0].anotomical_site_desc"+i).value
  for (j=i+1;j<=5 ;j++)
 {
    fldcmp1=eval("parent.frames[2].document.forms[0].speci_type"+j).value
	fldcmp2=eval("parent.frames[2].document.forms[0].anotomical_site_desc"+j).value
    
   if(fld1!=""||fld2!="")
	 { 
	if(fld1==fldcmp1&&fld2==fldcmp2)	
	 {
	 alert(getMessage("SPECI_ANOTOM_UNIQUE","MO"))
	 return false;
	 }
	 }
 
 }
 
 
 }


  for (i=1;i<=5 ;i++)
 {
	fld1=eval("parent.frames[2].document.forms[0].speci_desc"+i).value
	fld2=eval("parent.frames[2].document.forms[0].speci_type"+i).value
	fld3=eval("parent.frames[2].document.forms[0].anotomical_site_desc"+i).value
	fld4=eval("parent.frames[2].document.forms[0].collection_time"+i).value
	

	
		
 if(fld1==""&&fld2==""&&fld3==""&&fld4=="")
 {
 }else if(fld1!=""&&fld2!=""&&fld3!==""&&fld4!="")
 {
   if(parent.frames[2].document.forms[0].pract_desc12.value=="")
	 {

	   
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("Common.CollectedBy.label","Common"));
		alert(msg);	
		//alert("APP-000001 Specimen Collected by cannot be blank")
		return false;
	 }else if(parent.frames[2].document.forms[0]. spec_handed_over_to.value=="")
	 {
		//alert("APP-000001 Specimen Handed Over to cannot be blank")
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("eMO.SpecimenHandedOverTo.label","MO"));
		alert(msg);	
		return false;
	 }else if(parent.frames[2].document.forms[0].spec_handed_over_date.value=="")
	 {
		//alert("APP-000001 Specimen Handed Over Date cannot be blank")
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("eMO.SpecimenHandedOverDate.label","MO"));
		alert(msg);	
		return false;
	 }
	  
 
 }else
 {


 //alert("APP-000001 All the specimen details must be captured")
	alert(getMessage("CAPTURE_SPECIMEN_DTLS","MO"));
	return false;
 }

  }

if(parent.frames[2].document.forms[0].postmortem_findings.value.length>500)
{
alert(getMessage("POSTMORTEM_FINDINGS","MO"));
return false;
}


if(parent.frames[2].document.forms[0].pm_end_date_time.value!="")
{


var field1=parent.frames[2].document.forms[0].postmortem_findings;
var field2=parent.frames[2].document.forms[0].post_perf_pract_desc1;
var field3=parent.frames[2].document.forms[0].PM_PURPOSE;
var field4=parent.frames[2].document.forms[0].pract_desc9;
var field5=parent.frames[2].document.forms[0].pract_desc14;
var field6=parent.frames[2].document.forms[0].manner_of_death;

//Added by Ashwini on 03-May-2018 for ML-MMOH-CRF-0880
if(parent.frames[2].document.forms[0].isPMFindingDetailsAppl.value=="true" && parent.frames[2].document.forms[0].record_pm_find_dtls_yn.value=="N")
{
	if(parent.frames[2].document.forms[0].body_part_obtained_from_disable.value!="")
	{
	fields = new Array (field2,field3,field5)
	names = new Array (getLabel("eMO.PostmortemPrfmdBy.label","MO"),getLabel("eMO.PurposeForPrfmgPostMrtm.label","MO"),getLabel("eMO.PMRequestedBy.label","MO"));
	}else
	{
	fields = new Array (field2,field3,field5,field6)
	 names = new Array (getLabel("eMO.PostmortemPrfmdBy.label","MO"),getLabel("eMO.PurposeForPrfmgPostMrtm.label","MO"),getLabel("eMO.PMRequestedBy.label","MO"),getLabel("eMO.MannerofDeath.label","MO"));
	}
}else
{
	 if(parent.frames[2].document.forms[0].body_part_obtained_from_disable.value!="")
	{
	fields = new Array (field1,field2,field3,field4,field5)
	names = new Array (getLabel("eMO.SmryOfFdgs.label","MO"),getLabel("eMO.PostmortemPrfmdBy.label","MO"),getLabel("eMO.PurposeForPrfmgPostMrtm.label","MO"),getLabel("eMO.PostmortemCertifiedBy.label","MO"),getLabel("eMO.PMRequestedBy.label","MO"));
	}else
	{
	fields = new Array (field1,field2,field3,field4,field5,field6)
	 names = new Array (getLabel("eMO.SmryOfFdgs.label","MO"),getLabel("eMO.PostmortemPrfmdBy.label","MO"),getLabel("eMO.PurposeForPrfmgPostMrtm.label","MO"),getLabel("eMO.PostmortemCertifiedBy.label","MO"),getLabel("eMO.PMRequestedBy.label","MO"),getLabel("eMO.MannerofDeath.label","MO"));
	}
}
 if(parent.frames[2].checkFields(fields, names, parent.messageFrame))
 {
 
	
	parent.frames[2].document.forms[0].submit();
 }
 



}else

{
var field1=parent.frames[2].document.forms[0].pm_start_date_time;
var field2=parent.frames[2].document.forms[0].post_perf_pract_desc1;
var field3=parent.frames[2].document.forms[0].PM_PURPOSE;
var field4=parent.frames[2].document.forms[0].pract_desc14;
fields = new Array (field1,field2,field3,field4)
names = new Array (getLabel("eMO.PostMortemStartAt.label","MO"),getLabel("eMO.PostmortemPrfmdBy.label","MO"),getLabel("eMO.PurposeForPrfmgPostMrtm.label","MO"),getLabel("eMO.PMRequestedBy.label","MO"));
 if(parent.frames[2].checkFields(fields, names,parent.messageFrame))
 {
    parent.frames[2].document.forms[0].submit();
 }
 
}
}
 
async function getAnotimicalDetail(obj,target,target1)
	{
			targ=eval("parent.frames[2].document.forms[0]."+target).value
			var locale=document.forms[0].locale.value;
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var retVal =    new String();
			var argumentArray=new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";				
			var facilityId = "";
			sql="select ANATOMICAL_SITE_CODE code,SHORT_DESC Description from am_anatomical_site_lang_vw where language_id='"+locale+"' and upper(ANATOMICAL_SITE_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2";
			argumentArray[0] =sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = targ
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;
			retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			
	   		eval("parent.frames[2].document.forms[0]."+target1).value= arr[0];
		    eval("parent.frames[2].document.forms[0]."+target).value= arr[1];		
		}
		else
		{	
			eval("parent.frames[2].document.forms[0]."+target1).value= "";
		    eval("parent.frames[2].document.forms[0]."+target).value= "";		
		}
	}



function validateDate2(obj)
{  

	//assignDtime=document.forms[0].assignDtime.value;

	
	/*var msg=getMessage('INVALID_DATE_FMT','SM');
	if(obj.value!="")
		{
			val1=obj.value.length	

			if(val1<16)
					{
				alert(msg);
				obj.value="";
				return false;
					}
				if(doDateTimeChk(obj)==false)
				{
				alert(msg);
				obj.value="";
				return false;
		}*/

	
	if(validDateObj(obj,"DMYHM", localeName))
	{
		var greg_Dtime = convertDate(obj.value,"DMYHM",localeName,"en" );

		if(document.forms[0].assignDtime.value!="")
		{
			var greg_assignDtime = convertDate(document.forms[0].assignDtime.value,"DMYHM",localeName,"en" );
			if(isBefore(greg_Dtime,greg_assignDtime,"DMYHM","en")) 
			{
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$ date",getLabel("Common.datetime.label","Common"));
				msg = msg.replace("# date",getLabel("eMO.AssignedDate.label","MO"));
				//alert(getMessage('DATE_CANT_BE_LT_ASSIGN','MO'));
				alert(msg);
				obj.value="";
				obj.focus();
				return false;
			}
			/*if(ValidateDateTime(document.forms[0].assignDtime,obj)==false) 
			{
				alert(getMessage('DATE_CANT_BE_LT_ASSIGN','MO'));
				obj.value="";
				obj.focus();
				return false;
			}*/
		}
		else
		{
			if(isBefore(greg_Dtime,document.forms[0].body_received_date.value,"DMYHM","en")) 
			{
				//alert(getMessage('DATE_CANT_BE_LT_ASSIGN','MO'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$ date",getLabel("Common.datetime.label","Common"));
				msg = msg.replace("# date",getLabel("eMO.BodyReceipt.label","MO"));
				//alert(getMessage('DATE_CANT_BE_LT_ASSIGN','MO'));
				alert(msg);
		
				obj.value="";
				obj.focus();
				return false;
			}
			/*if(ValidateDateTime(document.forms[0].body_received_date,obj)==false) 
			{
				alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'));
				obj.value="";
				obj.focus();
				return false;
			}*/
		}

	//parent.messageFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(obj.value);
		parent.messageFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(greg_Dtime);
//sysdate=document.forms[0].sys_date_time.value

/*if(sysdate!=""||sysdate!=null)
{
	alert(ValidateDateTime(obj,document.forms[0].sys_date_time ));
if(ValidateDateTime(obj,document.forms[0].sys_date_time )==false) 
{
alert(getMessage('START_DATE_GREATER_SYSDATE'));
obj.focus();
return false;
}
}*/
	}
}



function validateDate1(obj)
{  
	
	//pm_start_date_time=document.forms[0].pm_start_date_time .value;
	if(document.forms[0].pm_end_date_time .value=="")
	{
		 
	
		parent.frames[2].document.getElementById('imgenable1').style.visibility="hidden"
		parent.frames[2].document.getElementById('imgenable2').style.visibility="hidden"
		//parent.frames[2].document.getElementById('imgenable3').style.visibility="hidden"
		/*parent.frames[2].document.getElementById('imgenable4').style.visibility="hidden"
		parent.frames[2].document.getElementById('imgenable5').style.visibility="hidden"
		parent.frames[2].document.getElementById('imgenable6').style.visibility="hidden"
		parent.frames[2].document.getElementById('imgenable7').style.visibility="hidden"*/
		parent.frames[2].document.getElementById('imgenable8').style.visibility="hidden"
		//if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
		//{
			
			//parent.frames[2].document.getElementById("tab1").scrollIntoView();
			
			//parent.frames[2].document.getElementById("PM_PURPOSE").focus();  
			
		//}
			
	}
	if(obj.value!="" && document.forms[0].pm_start_date_time.value!="")
	{
		//val1=obj.value.length	

		if(!validDateObj(obj,"DMYHM",localeName))
		{
			if(obj.name=='tissue_proc_date')
			{
				if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
			//alert("APP-SM0004 Invalid Date Format");
			//alert(getMessage('INVALID_DATE_FMT','SM'));
					//obj.value="";
					obj.value="";
					return false;
			}
			else if(obj.name=='spec_handed_over_date')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
				//alert("APP-SM0004 Invalid Date Format");
				//alert(getMessage('INVALID_DATE_FMT','SM'));
					//obj.value="";
					obj.value="";
					return false;
			}
			else
			{
				if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
						//alert("APP-SM0004 Invalid Date Format");
						//alert(getMessage('INVALID_DATE_FMT','SM'));
					//obj.value="";
					obj.value="";
					return false;
			}

		}

		/*if(val1<16)
		{
			if(obj.name=='tissue_proc_date')
			{
			if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
			//alert("APP-SM0004 Invalid Date Format");
			alert(getMessage('INVALID_DATE_FMT','SM'));
			obj.value="";
			obj.focus();
			return false;
			}else
				if(obj.name=='spec_handed_over_date')
				{
				parent.frames[2].document.getElementById("tab2").scrollIntoView();
				//alert("APP-SM0004 Invalid Date Format");
				alert(getMessage('INVALID_DATE_FMT','SM'));
				obj.value="";
				obj.focus();
				return false;
				}else{
						if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
						//alert("APP-SM0004 Invalid Date Format");
						alert(getMessage('INVALID_DATE_FMT','SM'));
						obj.value="";
						obj.focus();
						return false;
					}
		}*/
	/*if(doDateTimeChk(obj)==false)
	{

		if(obj.name=='tissue_proc_date')
	{
		if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")

		parent.frames[2].document.getElementById("tab4").scrollIntoView();
		//alert("APP-SM0004 Invalid Date Format");
		alert(getMessage('INVALID_DATE_FMT','SM'));
		obj.value="";
		obj.focus();

	}
	else
	if(obj.name=='spec_handed_over_date')
	{
	parent.frames[2].document.getElementById("tab2").scrollIntoView();
	//alert("APP-SM0004 Invalid Date Format");
	alert(getMessage('INVALID_DATE_FMT','SM'));
	obj.value="";
	obj.focus();

	}else{
		if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
		if(obj.name=="pm_end_date_time")
		parent.frames[2].document.getElementById("tab1").scrollIntoView();

		//alert("APP-SM0004 Invalid Date Format");
		alert(getMessage('INVALID_DATE_FMT','SM'));
		obj.value="";
		obj.focus();


		}
		return false;
}*/

//parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"'&bodypart=recpm";

// var HTMLVal = " <html><body><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/ValidateSysdate.jsp'>"+
  //     " <input type='hidden' name='objname' id='objname' value=\""+obj.name+"\"></form></body></html>";
		
 //parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
 //parent.frames[5].document.dum_form.submit();

//if(ValidateDateTime(document.forms[0].pm_start_date_time,obj)==false)
		var greg_Date = convertDate(obj.value,"DMYHM",localeName,"en" );
		var greg_pm_start_date_time= convertDate(document.forms[0].pm_start_date_time.value,"DMYHM",localeName,"en" );
		if(isBefore(greg_Date,greg_pm_start_date_time,"DMYHM","en"))
		{

			if(obj.name=='tissue_proc_date')
			{
				if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
					parent.frames[2].document.getElementById("tab4").scrollIntoView();
				//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.PerformedDate.label","Common"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='spec_handed_over_date')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.SpecimenHandedDateTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='collection_time1')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.CollectionTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='collection_time2')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.CollectionTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='collection_time3')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.CollectionTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='collection_time4')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.CollectionTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='collection_time5')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.CollectionTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='collection_time6')
			{
				parent.frames[2].document.getElementById('tab2').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.CollectionTime.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date1')
			{
				
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
				
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date2')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date3')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date4')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date5')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date6')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			//bru-hims-crf-270
			else if(obj.name=='onset_date7')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}
			else if(obj.name=='onset_date8')
			{
				parent.frames[2].document.getElementById('tab3').scrollIntoView();
					//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("Common.onsetdate.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			} // bru-hims-crf-270-end here
			else
			{
				if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
					if(obj.name=="pm_end_date_time")
					{
						parent.frames[2].document.getElementById('tab1').scrollIntoView();
						parent.frames[2].document.getElementById('PM_PURPOSE').focus();  
					}
					
				//parent.frames[2].document.getElementById("tab1").scrollIntoView();
				//alert(getMessage('DATE_CANT_BE_LT_PM_START'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				//msg = msg.replace("$",getLabel("eMO.PMCompletedAt.label","MO"));
				msg = msg.replace("$",getLabel("eMO.PMCompletedAt.label","MO"));
				//msg = msg.replace("#",getLabel("eMO.PostMortemStartAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PMStartedAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.value="";
			}

		return false;
		}

/*if(ValidateDateTime(obj,document.forms[0].system_date )==false) 
{
if(obj.name=='tissue_proc_date')
{
if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
parent.frames[2].document.getElementById("tab4").scrollIntoView();
alert(getMessage('START_DATE_GREATER_SYSDATE'));
obj.value="";
obj.focus();

}else
if(obj.name=='spec_handed_over_date')
{
parent.frames[2].document.getElementById("tab2").scrollIntoView();
alert(getMessage('START_DATE_GREATER_SYSDATE'));
obj.focus();
}else{
if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
alert(getMessage('START_DATE_GREATER_SYSDATE'));
obj.focus();
}

return false;
}*/

			parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=recpm"+"&objValue="+escape(greg_Date);
			if(obj.name=='pm_end_date_time')
			{
				//CalculateDuration(pm_start_date_time,obj.value,'N');
				CalculateDuration(greg_pm_start_date_time,greg_Date,'N');
			}
	}
	else
	{
			if(obj.name=='pm_end_date_time')
			{
				
				parent.frames[2].document.getElementById('endhrmindiff').innerHTML="";
				//parent.frames[2].document.getElementById('tab1').scrollIntoView();
				//parent.frames[2].document.getElementById('PM_PURPOSE').focus();
			
				if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
				{
					parent.frames[2].document.getElementById('tab1').scrollIntoView();
					parent.frames[2].document.getElementById('PM_PURPOSE').focus();
					//parent.frames[2].document.getElementById('pract_desc14').focus();
				}
			}
	}

	if(obj.name=='tissue_proc_date')
	{
		if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
			parent.frames[2].document.getElementById('tab4').scrollIntoView();
		parent.frames[2].document.forms[0].org0.focus()
	}
	if(obj.name=='spec_handed_over_date')
	{
		parent.frames[2].document.getElementById('tab2').scrollIntoView();
		parent.frames[2].document.forms[0].speci_desc1.focus();
	}

}

function validateDate(obj)
{  
	//val1=obj.value.length	
	if(obj.value!="")
	{
		if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			document.getElementById('hidetab2').style.display='none';
			document.getElementById('hidetab3').style.visibility='hidden';
			document.getElementById('hidetab4').style.visibility='hidden';
			return false;
		}
		/*if(val1<16)
		{
			
			alert(getMessage('INVALID_DATE_FMT','SM'));
			obj.value="";
			document.getElementById("hidetab2").style.visibility='hidden';
			document.getElementById("hidetab3").style.visibility='hidden';
			document.getElementById("hidetab4").style.visibility='hidden';
			return false;
		}
		if(doDateTimeChk(obj)==false)
		{
		
			alert(getMessage('INVALID_DATE_FMT','SM'));
			obj.value="";
			document.getElementById("hidetab2").style.visibility='hidden';
			document.getElementById("hidetab3").style.visibility='hidden';
			document.getElementById("hidetab4").style.visibility='hidden';
			return false;
		
		}*/

	}

	if(obj.value!="")
	{
	
		var greg_date = convertDate(obj.value,"DMYHM",localeName,"en" );
		//parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=recpm"+"&objValue="+escape(obj.value);

		parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=recpm"+"&objValue="+escape(greg_date);
			
		body_rec_date_time=document.forms[0].body_rec_date_time.value;
		pm_start_date_time=document.forms[0].pm_start_date_time.value;
		if(body_rec_date_time!=""&&pm_start_date_time!="")
		{
			var greg_body_rec_date_time = convertDate(body_rec_date_time,"DMYHM",localeName,"en" );
			var greg_pm_start_date_time = convertDate(pm_start_date_time,"DMYHM",localeName,"en" );

			if(isBefore(greg_pm_start_date_time,greg_body_rec_date_time,"DMYHM","en")) 
			{
				//alert(getMessage('DATE_CANT_BE_LT_CHECKED_IN'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				msg = msg.replace("$",getLabel("eMO.PMStartedAt.label","MO"));
				msg = msg.replace("#",getLabel("eMO.PatientCheckedInAt.label","MO"));
				alert(msg);
				//obj.focus();
				obj.select()
				return false;
				//Date cannot be less than Checked In Date
			}
	
			/*if(ValidateDateTime(document.forms[0].body_rec_date_time,document.forms[0].pm_start_date_time)==false) 
			{
				//alert(getMessage('DATE_CANT_BE_LT_CHECKED_IN'));
				var msg = getMessage("DATE_CANT_BE_LESS","MO");
				//msg = msg.replace("$",getLabel());
				msg = msg.replace("#",getLabel("eMO.PatientCheckedInAt.label","MO"));
				alert(msg);
				obj.focus();
				return false;
			}*/

/*if(ValidateDateTime(document.forms[0].pm_start_date_time,document.forms[0].system_date )==false) 
{
alert(getMessage('START_DATE_GREATER_SYSDATE'));
if(parent.frames[2].document.getElementById("viewdata").value!="viewdata")
obj.focus();
//obj.value = "";
return false;
}*/
			if(obj.value!="")
				{
					CalculateDuration(greg_body_rec_date_time,greg_date,'Y');
					//CalculateDuration(body_rec_date_time,obj.value,'Y');
				}
		}
		else
		{
			
			document.getElementById('hidetab2').style.display='none';
			document.getElementById('hidetab3').style.visibility='hidden';
			document.getElementById('hidetab4').style.visibility='hidden';
			parent.frames[2].document.getElementById('pm_end_date_time').readOnly=true;
			parent.frames[2].document.getElementById('pmcmpdis').disabled=true;
			parent.frames[2].document.getElementById('hrmindiff').innerHTML=""
			if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
				parent.frames[2].document.getElementById('PM_PURPOSE').focus();
				//parent.frames[2].document.getElementById('pract_desc14').focus();
		}
	}
	else
	{
		
		document.getElementById('hidetab2').style.display='none';
		document.getElementById('hidetab3').style.visibility='hidden';
		document.getElementById('hidetab4').style.visibility='hidden';
		parent.frames[2].document.getElementById('pm_end_date_time').readOnly=true;
		parent.frames[2].document.getElementById('pmcmpdis').disabled=true;
		parent.frames[2].document.getElementById('hrmindiff').innerHTML=""
		if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
			parent.frames[2].document.getElementById('PM_PURPOSE').focus();
			//parent.frames[2].document.getElementById('pract_desc14').focus();
	}
}

function CalculateDuration(pm_start_date_time,enddate,st){

var start_date	=	pm_start_date_time
var target_date	=	enddate
var fromarray,toarray,fromtime,totime;
var fromDt,fromDt1;

var fromarray,toarray,fromtime,totime;
var fromDt,fromDt1;

if(start_date.length > 0 && target_date.length > 0 )
{
	fromDt = start_date.split(" ");
	fromarray = fromDt[0].split("/");
	fromtime = fromDt[1].split(":");
	
	fromDt1= target_date.split(" ");		
	toarray = fromDt1[0].split("/");
	totime = fromDt1[1].split(":"); 
	
	start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
	target_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
}

st_date = new Date();
tr_date = new Date();
dt_diff  = new Date();

// Validates first date 
st_datetemp = new Date(start_date);
st_date.setTime(st_datetemp.getTime());

// Validates second date 
tr_datetemp = new Date(target_date);
tr_date.setTime(tr_datetemp.getTime());

// sets difference date to difference of first date and second date

dt_diff.setTime(Math.abs(st_date.getTime() - tr_date.getTime()));

timediff = dt_diff.getTime();

weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
//timediff -= weeks * (1000 * 60 * 60 * 24 * 7);

days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
//timediff -= days * (1000 * 60 * 60 * 24);

hours = Math.floor(timediff / (1000 * 60 * 60)); 
timediff -= hours * (1000 * 60 * 60);

mins = Math.floor(timediff / (1000 * 60)); 
//timediff -= mins * (1000 * 60);

secs = Math.floor(timediff / 1000); 
//timediff -= secs * 1000;

//var difference = weeks + " weeks, " + days + " days, " + hours + " hours, " + mins + " minutes, and " + secs + " seconds";
if(st=='Y')
{
var difference = hours + " Hrs" +"&nbsp;"+ mins + " Min";
parent.frames[2].document.getElementById('hrmindiff').innerHTML="<b>"+difference+"</b>"
parent.frames[2].document.getElementById('pm_end_date_time').readOnly=false;
if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
parent.frames[2].document.getElementById('pmcmpdis').disabled=false;

}else
{
var difference = hours + " Hrs" +"&nbsp;"+ mins + " Min";
parent.frames[2].document.getElementById('endhrmindiff').innerHTML="<b>"+difference+"</b>"
parent.frames[2].document.getElementById('imgenable1').style.visibility="visible"
parent.frames[2].document.getElementById('imgenable2').style.visibility="visible"
//parent.frames[2].document.getElementById('imgenable3').style.visibility="visible"
/*parent.frames[2].document.getElementById('imgenable4').style.visibility="visible"
parent.frames[2].document.getElementById('imgenable5').style.visibility="visible"
parent.frames[2].document.getElementById('imgenable6').style.visibility="visible"
parent.frames[2].document.getElementById('imgenable7').style.visibility="visible"*/


if(parent.frames[2].document.getElementById('body_part_obtained_from_disable').value=="")
parent.frames[2].document.getElementById('imgenable8').style.visibility="visible"
if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
	{
		parent.frames[2].document.getElementById('tab1').scrollIntoView();
		parent.frames[2].document.getElementById('PM_PURPOSE').focus();
	}
	
	//parent.frames[2].document.getElementById("pract_desc14").focus();
}
	
	
	if(document.getElementById('isPMFindingDetailsAppl').value=="true" && document.getElementById('record_pm_find_dtls_yn').value=="N") // added by mujafar for ML-MMOH-CRF-0880
	document.getElementById('hidetab2').style.display='none';
	else
	document.getElementById('hidetab2').style.display='block';

	document.getElementById('hidetab3').style.visibility='visible';
	if(document.getElementById('tissuecnt').value>0)
	document.getElementById('hidetab4').style.visibility='visible';
    else
		document.getElementById('hidetab4').style.visibility='hidden';
//var difference = days;

}



function getDiagnosisDesc(obj2,obj3)
{
	
	//document.forms[0].mr_diagnosis_desc.value="";
	var val1 = obj2.value
	
	var name = document.forms[0].diag_code.value;
 
    var objName = obj3;
    
        
        var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/QueryPopulateDiagDesc.jsp'>"+
       " <input type='hidden' name='scheme' id='scheme' value=\""+name+"\">"+
        " <input type='hidden' name='code' id='code' value=\""+val1+"\">"+"<input type='hidden' name='objName' id='objName' value=\""+objName+"\">"+         
       " </form></body></html>";
		
		parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[5].document.dum_form.submit();

    

}
function callDiagnosis1(object,obj,obj1)
{// bru-hims-crf-270
if(object.name=="mr_diagnosis_desc")
{
if(object.value=="")
{
obj.value="";
parent.frames[2].document.forms[0].cause_remarks1.disabled=true;
parent.frames[2].document.forms[0].cause_remarks1.value="";
return false;
}else{
		if(object.value!="")object.value="";
		}
//else
//parent.frames[2].document.forms[0].cause_remarks1.disabled=false;
}

if(object.name=="mr_diagnosis_desc1")
{
if(object.value=="")
{
obj.value="";
parent.frames[2].document.forms[0].cause_remarks2.disabled=true;
parent.frames[2].document.forms[0].cause_remarks2.value="";
return false;
}else{
		if(object.value!="")object.value="";
		}
//else
//parent.frames[2].document.forms[0].cause_remarks2.disabled=false;
}
if(object.name=="mr_diagnosis_desc4")
{
if(object.value==""){
obj.value="";
parent.frames[2].document.forms[0].cause_remarks3.disabled=true;
parent.frames[2].document.forms[0].cause_remarks3.value="";
return false;
}else{
		if(object.value!="")object.value="";
		}
//else
//parent.frames[2].document.forms[0].cause_remarks3.disabled=false;
}
if(object.name=="mr_diagnosis_desc5")
{
if(object.value==""){
obj.value="";
parent.frames[2].document.forms[0].cause_remarks4.disabled=true;
parent.frames[2].document.forms[0].cause_remarks4.value="";
return false;
}else{
		if(object.value!="")object.value="";
		}
//else
//parent.frames[2].document.forms[0].cause_remarks4.disabled=false;
}
if(object.name=="mr_diagnosis_desc6")
{
if(object.value==""){
obj.value="";
parent.frames[2].document.forms[0].cause_remarks5.disabled=true;
parent.frames[2].document.forms[0].cause_remarks5.value="";
return false;
}else{
		if(object.value!="")object.value="";
		}
//else
//parent.frames[2].document.forms[0].cause_remarks5.disabled=false;
}
else if(object.name=="mr_diagnosis_desc7")
{
if(object.value==""){
obj.value="";
parent.frames[2].document.forms[0].cause_remarks6.disabled=true;
parent.frames[2].document.forms[0].cause_remarks6.value="";
return false;
}else{
		if(object.value!="")object.value="";
		}
//else
//parent.frames[2].document.forms[0].cause_remarks6.disabled=false;
} // bru-hims-crf-270
 callDiagnosis(object,obj,obj1)
}

async function callDiagnosis(object,obj,obj1)
{ 
    var diag_code1=parent.frames[2].document.forms[0].mr_diagnosis_code.value;
    var diag_code2=parent.frames[2].document.forms[0].mr_diagnosis_code1.value;
	var diag_code3=parent.frames[2].document.forms[0].mr_diagnosis_desc2.value;
	var diag_code4=parent.frames[2].document.forms[0].mr_diagnosis_desc3.value;
	var diag_code5=parent.frames[2].document.forms[0].mr_diagnosis_code4.value;
	var diag_code6=parent.frames[2].document.forms[0].mr_diagnosis_code5.value;
	var diag_code7=parent.frames[2].document.forms[0].mr_diagnosis_code6.value;	// bru-hims-crf-270
	var diag_code8=parent.frames[2].document.forms[0].mr_diagnosis_code7.value; // bru-hims-crf-270
	
	if(object.name=="mr_diagnosis_desc2")
	{
	 if(diag_code1==object.value||diag_code2==object.value||diag_code5==object.value||diag_code6==object.value||diag_code7==object.value||diag_code8==object.value||diag_code4==object.value)// bru-hims-crf-270
		{
		 alert(getMessage('CNT_ASIGN_SAME_DIAG_CODE','MO'))
		 object.value="";
		 return false;
		}else
		{return true;
		}
	}
	if(object.name=="mr_diagnosis_desc3")
	{
	if(diag_code1==object.value||diag_code2==object.value||diag_code5==object.value||diag_code6==object.value||diag_code7==object.value||diag_code8==object.value||diag_code3==object.value)//bru-hims-crf-270
		{
		 alert(getMessage('CNT_ASIGN_SAME_DIAG_CODE','MO'))
		 object.value="";

		 return false;
		}else{
		return true;
		}
	}
	obj.value="";
	var dialogTop	  = "50";
	var dialogHeight  = "35" ;
	var dialogWidth   = "50" ;
	var features    ="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;
	var encounter_id	= '';
// diag_code replaced from 1 as ICD10 for IN032171 by Kamakshi N on 09.05.2012	
	if(diag_code!=null && diag_code=='ICD10')
		term_set_id	=	'ICD10';
	/*var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=";   
	*/

	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=&term_set_id="+term_set_id;     
	
	
	var retVal = await window.showModalDialog(params,arguments,features);

	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;	
	 
		 if(diag_code1==retdata[0]||diag_code2==retdata[0]||diag_code3==retdata[0]||diag_code4==retdata[0]||diag_code5==retdata[0]||diag_code6==retdata[0]||diag_code7==retdata[0]||diag_code8==retdata[0]) //bru-hims-crf-270
		{
		alert(getMessage('CNT_ASIGN_SAME_DIAG_CODE','MO'))
		return false;
		}else
		{
			
		 	 
		 obj.value=retdata[0];	
         
		}
		 
		 getDiagnosisDesc(obj,obj1)	      
		 
    
	// bru-hims-crf-270
	if((object.name=="mr_diagnosis_select")&& (!(diag_code1==null)))
	{
	  parent.frames[2].document.forms[0].cause_remarks1.disabled=false;
	}
	if ((object.name=="mr_diagnosis_select1")&& (!(diag_code2==null)))
	{
	  parent.frames[2].document.forms[0].cause_remarks2.disabled=false;
	}
	if ((object.name=="mr_diagnosis_select4")&& (!(diag_code5==null)))
	{
	  parent.frames[2].document.forms[0].cause_remarks3.disabled=false;
	}
	if ((object.name=="mr_diagnosis_select5")&& (!(diag_code6==null)))
	{
	  parent.frames[2].document.forms[0].cause_remarks4.disabled=false;
	}
	if ((object.name=="mr_diagnosis_select6")&& (!(diag_code7==null)))
	{
	  parent.frames[2].document.forms[0].cause_remarks5.disabled=false;
	}
	if ((object.name=="mr_diagnosis_select7")&& (!(diag_code8==null)))
	{
	  parent.frames[2].document.forms[0].cause_remarks6.disabled=false;
	}
//	document.forms[0].mr_diagnosis_code.focus();
  }
}


function beforeAnotomicalSiteClick(obj,target_name)
{
	
		if(obj.value == "")
		{
		
		 return;
		}
	
	eval("document.forms[0]."+target_name).click();	
	
}

function beforeGetPractitioner(obj,target_name,target)
{
	
	if(obj.value=='' && obj.name=='pract_desc1')
		document.forms[0].desig_desc1.value ='';
	if(obj.value=='' && obj.name=='post_perf_pract_desc1')
		document.forms[0].post_perf_desig_desc1.value ='';
	if(obj.value=='' && obj.name=='pract_desc2')
		document.forms[0].desig_desc2.value ='';
		if(obj.value == "")
		{
			obj.value="";	
			target.value="";
			return;
		}
	
		eval("document.forms[0]."+target_name).click();	
		
}


function getValues(obj,target,targetId)
		{
			var tit="";
			var facilityid =document.forms[0].facility_id.value;
			var argumentArray=new Array(8);
			var sql="";
			var sqlSecond="";
			target.value=trimString(target.value);
		    targetId.value="";  
			

				//sql=" select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(a.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) job_title, decode(a.gender,'M','Male','F','Female','U','Unknown') gender, b.primary_speciality_desc primary_specialty from am_practitioner a, am_pract_for_facility_vw b where b.operating_facility_id = '"+facilityid+"' and b.eff_status='E' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123')))";

				sql=" select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.pract_type_desc practitioner_type, a.position_code job_title, a.gender gender, a.primary_speciality_desc primary_specialty from am_practitioner_lang_vw a, am_pract_for_facility_vw b where b.operating_facility_id = '"+facilityid+"' and b.eff_status='E' and a.language_id = '"+localeName+"'and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123')))";

				//sqlSecond=" select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(a.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) job_title, decode(a.gender,'M','Male','F','Female','U','Unknown') gender, b.primary_speciality_desc primary_specialty from am_practitioner a, am_pract_for_facility_vw b where b.operating_facility_id = '"+facilityid+"' and b.eff_status='E' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123')))";

				sqlSecond=" select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.pract_type_desc practitioner_type, a.position_code job_title, a.gender gender, a.primary_speciality_desc primary_specialty from am_practitioner_lang_vw a, am_pract_for_facility_vw b where b.operating_facility_id = '"+facilityid+"' and b.eff_status='E' and a.language_id = '"+localeName+"' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123')))";

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + target.name + "\"";
				xmlStr += " practName_FValue=\"" + target.value + "\"";
				xmlStr += " sql=\"" +escape(sql)+"\"";
				xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
				xmlStr += " practitioner_type=\"" + "" + "\"";
				xmlStr += " specialty_code=\"" + "" + "\"";
				xmlStr += " job_title=\"" + "" + "\"";
				xmlStr += " gender=\"" + "" + "\"";

				xmlStr +=" /></root>" ;
				
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);

				
				eval(responseText);

	         return	
			
			/*var retVal=CommonLookup(tit,argumentArray);
			alert(retVal)
			if(retVal ==null || retVal=="" || !retVal)
			{
				target.value="";
				targetId.value="";
			}
			else
			{
				targetId.value=retVal[0];
				target.value=retVal[1];
			}*/
		}
	

function PractLookupRetVal(retVal,objName)
		{
			var arr;
			
			pract1=parent.frames[2].document.forms[0].pract1.value;
			pract2=parent.frames[2].document.forms[0].pract2.value;
			pract3=parent.frames[2].document.forms[0].pract_desc3.value;
			pract4=parent.frames[2].document.forms[0].pract_desc4.value;
			pract5=parent.frames[2].document.forms[0].pract_desc5.value;
			pract6=parent.frames[2].document.forms[0].pract6.value;
			pract7=parent.frames[2].document.forms[0].pract7.value;
			post_perf_pract1=parent.frames[2].document.forms[0].post_perf_pract1.value;
				
			
			if (retVal != null && trimString(retVal) != "")
			{
			arr=retVal.split("~");
		    
			
			if(objName=="pract_desc3")
			{
		
			if((pract1==arr[0])||(pract2==arr[0])||(pract4==arr[0])||(post_perf_pract1==arr[0])||(pract5==arr[0]))
			{
			alert(getMessage("SAME_PRACT_ID_NOT_ALLOWED",'MO'))
			eval("parent.frames[2].document.forms[0]."+objName).value=""
			return false;
			 }else
			{
				return true;
			}
			
			}

		    
			if(objName=="pract_desc4")
			{
		
			if((pract1==arr[0])||(pract2==arr[0])||(pract3==arr[0])||(post_perf_pract1==arr[0])||(pract5==arr[0]))
			{
			alert(getMessage("SAME_PRACT_ID_NOT_ALLOWED",'MO'))
			eval("parent.frames[2].document.forms[0]."+objName).value=""
			return false;
			 }else
			{
				return true;
			}
			
			}
			
			if(objName=="pract_desc5")
			{
		
		if((pract1==arr[0])||(pract2==arr[0])||(pract3==arr[0])||(post_perf_pract1==arr[0])||(pract4==arr[0]))
			{
			alert(getMessage("SAME_PRACT_ID_NOT_ALLOWED",'MO'))
			eval("parent.frames[2].document.forms[0]."+objName).value=""
			return false;
			 }else
			{
				return true;
			}
			
			}

			if(objName=="post_perf_pract_desc1")
			{
		
			if((pract1==arr[0])||(pract2==arr[0])||(pract3==arr[0])||(pract4==arr[0])||(pract5==arr[0]))
			{
			alert(getMessage("SAME_PRACT_ID_NOT_ALLOWED",'MO'))
			eval("parent.frames[2].document.forms[0]."+objName).value=""
			return false;
			
           	}
			eval("parent.frames[2].document.forms[0]."+objName).value=arr[1];		
			parent.frames[2].document.forms[0].post_perf_pract1.value=arr[0];
			parent.dummyframe.location.href = "../../eMO/jsp/MOPopulatePractDesi.jsp?practcode="+arr[0]+"&objval="+objName
			return;
			}
			
			if(objName=="pract_desc14")
			{
			eval("parent.frames[2].document.forms[0]."+objName).value=arr[1];		
			parent.frames[2].document.forms[0].pract14.value=arr[0];
			return;
			}

			if(objName=="pract_desc12")
			{
			eval("parent.frames[2].document.forms[0]."+objName).value=arr[1];		
			parent.frames[2].document.forms[0].pract12.value=arr[0];
			return;
			}
			if(objName=="pract_desc9")
			{
			eval("parent.frames[2].document.forms[0]."+objName).value=arr[1];		
			parent.frames[2].document.forms[0].pract9.value=arr[0];
			return;
			}
			 if(objName=="tissue_procured_by")
			{
			eval("parent.frames[2].document.forms[0]."+objName).value=arr[1];		
			parent.frames[2].document.forms[0].pract13.value=arr[0];
			return;
			}
			
			
			
			if(objName=="pract_desc6"||objName=="pract_desc7")
			{
			  if(pract6==arr[0]||pract7==arr[0])
			    {
			       alert(getMessage("SAME_PRACT_ID_NOT_ALLOWED",'MO'))
			       eval("parent.frames[2].document.forms[0]."+objName).value=""
			        return false;
			       		
			     }else
			     {
			     if(objName=="pract_desc6")
			      {
			         parent.frames[2].document.forms[0].pract6.value=arr[0];
				  }else if(objName=="pract_desc7"){
			        parent.frames[2].document.forms[0].pract7.value=arr[0];
			       }
			  }
			}else
			{
			if((pract1==arr[0])||(pract2==arr[0])||(pract3==arr[0])||(pract4==arr[0])||(pract5==arr[0])||post_perf_pract1==arr[0])
			{
			alert(getMessage("SAME_PRACT_ID_NOT_ALLOWED",'MO'))
			eval("parent.frames[2].document.forms[0]."+objName).value=""
			return false;
			
           	}else
            {
			if(objName=="pract_desc1")
			{
			parent.frames[2].document.forms[0].pract1.value=arr[0];
			}else	if(objName=="pract_desc2")
			{
			parent.frames[2].document.forms[0].pract2.value=arr[0];
			}else if(objName=="pract_desc3")
			{
			parent.frames[2].document.forms[0].pract3.value=arr[0];
			}else	if(objName=="pract_desc4")
			{
			parent.frames[2].document.forms[0].pract4.value=arr[0];
			}else if(objName=="pract_desc5")
			{
			parent.frames[2].document.forms[0].pract5.value=arr[0];
			}


			}
			
			
				
				
			
			}
			

			
			
			
			
			
				//document.forms[0].ppract.value=arr[0];
			eval("parent.frames[2].document.forms[0]."+objName).value=arr[1];		
			parent.dummyframe.location.href = "../../eMO/jsp/MOPopulatePractDesi.jsp?practcode="+arr[0]+"&objval="+objName
			}
			else
			{
			//	document.forms[0].oppract.value="";	
				eval("parent.frames[2].document.forms[0]."+objName).value="";
				if(eval("parent.frames[2].document.forms[0]."+objName).value=='' && eval("parent.frames[2].document.forms[0]."+objName).name=='pract_desc1')
					document.forms[0].desig_desc1.value ='';
				if(eval("parent.frames[2].document.forms[0]."+objName).value=='' && eval("parent.frames[2].document.forms[0]."+objName).name=='post_perf_pract_desc1')
					document.forms[0].post_perf_desig_desc1.value ='';
				if(eval("parent.frames[2].document.forms[0]."+objName).value=='' && eval("parent.frames[2].document.forms[0]."+objName).name=='pract_desc2')
					document.forms[0].desig_desc2.value ='';


			}
		}


function AEScrollIntoView(tabidx)
{
	var  p_enc_type;
	

	if(tabidx == 1)
    {
		//document.getElementById('place_of_death').focus();
		document.getElementById('tab1').scrollIntoView();
	    if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
			document.getElementById('PM_PURPOSE').focus();  
		 //document.getElementById('pract_desc14').focus();  
		
		if(parent.frames[2].document.getElementById('viewdata').value!="viewdata"){//Added by Thamizh selvi on 20th Sep 2017 against [IN:065280]
			if(parent.frames[3].document.forms[0].placeOrder)			
				parent.frames[3].document.forms[0].placeOrder.style.visibility = "hidden";
		}
    }
	else if(tabidx == 2)
	{
		if(document.getElementById('pm_start_date_time').value=="")
		{
		
		return ;
		}  if(document.getElementById('tissuecnt').value>0)
		  document.getElementById('hidetis6').style.visibility="visible" 
		 else
		  document.getElementById('hidetis6').style.visibility="hidden"
		  document.getElementById('tab3').scrollIntoView();
        
		 if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
			 document.getElementById('onset_date1').focus();  
			//document.getElementById('pract_desc9').focus();  
		if(parent.frames[2].document.getElementById('viewdata').value!="viewdata"){//Added by Thamizh selvi on 20th Sep 2017 against [IN:065280]
			if(parent.frames[3].document.forms[0].placeOrder)			
				parent.frames[3].document.forms[0].placeOrder.style.visibility = "hidden";
		}
	}
	else if(tabidx == 3)
	{
		
		if(document.getElementById('pm_start_date_time').value=="")
		return ;
        
		if(document.getElementById('tissuecnt').value>0)
		document.getElementById('hidetis5').style.visibility="visible" 
		 else
	    document.getElementById('hidetis5').style.visibility="hidden"
		
		document.getElementById('tab2').scrollIntoView();
		if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
			document.getElementById('speci_desc1').focus();
		
	if(document.getElementById('isPMFindingDetailsAppl').value=="true" && document.getElementById('record_pm_find_dtls_yn').value=="N") // added by mujafar for ML-MMOH-CRF-0880
	{ 
		
	document.getElementById('hidetab8').style.display='none';}
	else{
	document.getElementById('hidetab8').style.display='block';
	}
	
		
		if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
		{//Added by Thamizh selvi on 20th Sep 2017 against [IN:065280]
			if(parent.frames[3].document.forms[0].placeOrder)			
				parent.frames[3].document.forms[0].placeOrder.style.visibility = "visible";
		}
	 
	
	}
	else if(tabidx == 4)
	{
	if(document.getElementById('pm_start_date_time').value=="" ||document.getElementById('tissuecnt').value<1)
		return ;
	document.getElementById('tab4').scrollIntoView(); 
	if(parent.frames[2].document.getElementById('viewdata').value!="viewdata")
		document.getElementById('org0').focus();

	
	if(document.getElementById('tissuecnt').value>0)
	 document.getElementById('hidetis7').style.visibility="visible" 
	else
	 document.getElementById('hidetis7').style.visibility="hidden"
 
 
 
	if(document.getElementById('isPMFindingDetailsAppl').value=="true" && document.getElementById('record_pm_find_dtls_yn').value=="N") //added by mujafar for ML-MMOH-CRF-0880
	{ 
		
	document.getElementById('hidetab9').style.display='none';}
	else{ 
	document.getElementById('hidetab9').style.display='block';
	}
	
	if(parent.frames[2].document.getElementById('viewdata').value!="viewdata"){//Added by Thamizh selvi on 20th Sep 2017 against [IN:065280]
		if(parent.frames[3].document.forms[0].placeOrder)			
		  parent.frames[3].document.forms[0].placeOrder.style.visibility = "hidden";
	}
	}
	else if(tabidx == 5)
	{
				
		
		document.getElementById('tab5').scrollIntoView();

	}
	else 
	{
		
	}
			
}




	function enableVal(obj)
	{
		if (obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}




	
	function onSuccess()
	{
	  
	  parent.document.location.reload();
	}
/*	function searchCode(obj,target)
	{
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var retVal =    new String();
			var argumentArray=new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";				
			var facilityId = "";
			facilityId = document.forms[0].facility_id.value;
			
			if(obj.name=="registration_no")
			{
				tit="Manage Deceased "
				sql="select registration_no code, patient_name Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null order by 2";
				
			}
			else
			{
				tit="Manage Deceased "
				sql="select registration_no code, patient_name Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null order by 2";
			
			}
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(target.name == 'registration_no')
				document.forms[0].registration_no.value= arr[0];
				parent.AEMPSearchCriteriaFrame.location.href = '../../eMO/jsp/MOManageDeceasedSearchCriteria.jsp?param='+arr[0];
				
		}
		else
		{	
			document.forms[0].patient_id.value= "";
		}
	}*/
	function clearAll()
	{
	  parent.AEMPSearchCriteriaFrame.location.href = '../../eMO/jsp/MOManageDeceasedSearchCriteria.jsp';
	  parent.AEMPSearchResultFrame.location.href='../../eCommon/html/blank.html';
	}
	function ChangeToUpper(obj)
	{
		obj.value = obj.value.toUpperCase();
	}
		
async function postmortemRequest(or_installyn,order_catalog_code,encounterId,fac_id)
	{
		if(or_installyn=="Y")
		{
		var select_registration=document.forms[0].registration.value;		
		
		var patient_id=document.forms[0].patient_id.value;
		
		var dialogHeight	=	"34"; 
		var dialogWidth		=	"60"; 
		var dialogTop		=	"59";
		var status			=	"no";
		var arguments		=	"" ;
		var registrationNo="";
		var patient_class="";
		var deceased_yn="";
		var postmortem_type="";
		var postmortem_status="";
		var body_part_yn="";
		var patient_age="";
		var patient_dob="";
		var visit_adm_date="";
		registrationNo=document.forms[0].registration.value;
		patient_class=document.forms[0].patient_class.value;
		deceased_yn=document.forms[0].deceased_yn.value;
		postmortem_type=document.forms[0].postmortem_type.value;
		postmortem_status=document.forms[0].postmortem_status.value;
		body_part_yn=document.forms[0].body_part_yn.value;
		if(body_part_yn!='N'){
			body_part_yn='Y';
		}
		patient_age=document.forms[0].patient_age.value;
		patient_dob=document.forms[0].date_of_birth.value;
		visit_adm_date=document.forms[0].body_received_date.value;
		//var action_url		=	'../../eOR/jsp/EnterOrder.jsp?p_task_code='+select_registration+'&patient_id='+patient_id+'&function_from=MO&p_start_date_time=&p_order_catalog_code='+order_catalog_code+'&episode_id='+encounterId+'&encounter_id='+encounterId+'&facility_id='+fac_id+'&accession_type=MO';
		//var action_url="../../eOR/jsp/ExistingOrderResultsFrameset.jsp?patientId="+patient_id+"&function_from=MO&ord_status=Z&order_by=D&view=C&view_by=L&search_criteria=S&patient_class="+patient_class+"&facility_id="+fac_id+"&encntr_id="+encounterId+"&requestedModule=MO&deceased_yn="+deceased_yn+"&medico_legal_yn="+postmortem_type+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+registrationNo+"&age="+patient_age+"&dob="+patient_dob+"&visit_adm_date="+visit_adm_date+"&callingFrom=R";
		
		/*Added by Dharma for OR issue Start*/
		var actionUrlParam	= "";
		if(encounterId==""){
			actionUrlParam	= "&location_type=R";
		}
		/*Added by Dharma for OR issue End*/

		var action_url="../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&function_from=MO&ord_status=Z&order_by=D&view=C&view_by=L&search_criteria=S&patient_class="+patient_class+"&facility_id="+fac_id+"&encounter_id="+encounterId+"&episode_id="+encounterId+"&requestedModule=MO&deceased_yn="+deceased_yn+"&medico_legal_yn="+postmortem_type+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+registrationNo+"&age="+patient_age+"&dob="+patient_dob+"&visit_adm_date="+visit_adm_date+"&callingFrom=R"+actionUrlParam;
		var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		retVal				=	await window.showModalDialog(action_url,arguments,features);
		parent.window.close();
	
	
		}else
		{document.forms[0].method	= 'post';
		document.forms[0].action	= '../../servlet/eMO.MOManageDeceasedAssignAreaServlet';
		document.forms[0].target	= 'messageFrame';
		document.forms[0].cancelPM.value = "NO";
		document.forms[0].pmstatus.value = "R";
		document.forms[0].submit();
		
		
		
		}


	
	}
async function callexecuteStart() 
	{
		var select_registration=document.forms[0].registration.value;
		var patient_id=document.forms[0].patient_id.value;
		var or_installyn=document.forms[0].or_installyn.value;
		var dialogHeight	=	"100"; 		// BRU-HIMS-CRF-270			
		var dialogWidth		=	"60"; 
		var dialogTop		=	"200";
		var status			=	"no";
		var arguments		=	"" ;
		retVal				=	"startpm";
		var action_url		=	"../../eMO/jsp/MOPostmortemMangementFrameset.jsp?patient_id="+patient_id+"&select_registration="+select_registration+"&or_installyn="+or_installyn;
		var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		retVal				= await	window.showModalDialog(action_url,arguments,features);
		parent.window.close();
		//callexecuteStartServlet();------->inside  startPostmortem.jsp
	}

async	function callexecuteEnd()
	{
		var select_registration=document.forms[0].registration.value;
		var dialogHeight	=	"15"; 
		var dialogWidth		=	"30"; 
		var dialogTop		=	"150";
		var status			=	"no";
		var arguments		=	"" ;
		retVal				=	"startpm";
		var action_url		=	"../../eMO/jsp/EndPostmortem.jsp?selection_mode="+retVal+"&select_registration="+select_registration;
		var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		retVal				= await	window.showModalDialog(action_url,arguments,features);
		parent.window.close();
	//callexecuteStartServlet();------->inside  endPostmortem.jsp
	}

	function callexecuteCancel()
	{
		document.forms[0].method	= 'post';
		document.forms[0].action	= '../../servlet/eMO.MOManageDeceasedAssignAreaServlet';
		document.forms[0].target	= 'messageFrame';
		document.forms[0].cancelPM.value = "C";
		document.forms[0].pmstatus.value = "S";
		document.forms[0].submit();
	}

async function searchBed(obj,target)
{
	var retVal =    new String();
	var area_code   =document.forms[0].area_code.value;
	var patient_id   =document.forms[0].patient_id.value; 
	var retVal = "";
	var dialogHeight= "60vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    var retVal= await window.showModalDialog("../../eMO/jsp/MOBayAvailabilityChart.jsp?area_code="+area_code+"&patient_id="+patient_id+"&bed_status=V&disable=yes",arguments,features);
	if(retVal != null && retVal != "" )
    {
	   document.forms[0].bed_no.value=retVal;
	}
}

function assignArea()
{	
	
	var treat_area_cd = document.forms[0].area_code.value; 
	if(treat_area_cd == null || treat_area_cd == "")
	{
		var error=getMessage("CAN_NOT_BE_BLANK","Common");
		error=error.replace("$",getLabel("Common.area.label","Common"));
		alert(error);
		document.forms[0].area_code.focus();
		return false;
	}
	var assign_date_time = document.forms[0].assign_tmt_area_time.value;
	if(assign_date_time == null || assign_date_time == "")
	{
		var error=getMessage("CAN_NOT_BE_BLANK","Common");
		error=error.replace("$",getLabel("Common.datetime.label","Common"));
		alert(error);
		document.forms[0].assign_tmt_area_time.focus();
		return false;
	}
	/*if (document.forms[0].printcommand.checked==true)
	{*/
		//callreport();
select_pmstatus=document.forms[0].select_pmstatus.value
	
area_type=document.forms[0].area_type.value;
	if(select_pmstatus=="R" && area_type=="P")
	{
		var error=getMessage("CNT_REASSIGN","MO");
		alert(error)
		return false;		
	
	}else
	{
		
		document.MOMDAssgnTmtAreaForm.submit();
		return true;
	
	}
	/*}
	else
	{
		document.MOMDAssgnTmtAreaForm.submit();
		return true;
	}*/
}

function showQueryResult(called_from_ca)
{
	var area_code = "";
	var registration_no = "";
	var patient_id = "";
	var gender = "";
	
	if(called_from_ca=="N")
	{
		area_code			= 	parent.frames[1].document.forms[0].area_code.value ;
		registration_no		= 	parent.frames[1].document.forms[0].registration_no.value ;
		gender				=	parent.frames[1].document.forms[0].gender.value ;
		called_from_ca		=	parent.frames[1].document.forms[0].called_from_ca.value;
		patient_id			=	parent.frames[1].document.forms[0].patient_id.value;
	}
	else
	{
		area_code		=	document.forms[0].area_code.value;
		registration_no	=	document.forms[0].registration_no.value ;
		gender			=	document.forms[0].gender.value ;
		called_from_ca	=	document.forms[0].called_from_ca.value;
		patient_id		=	document.forms[0].patient_id.value;
	}
	parent.AEMPSearchResultFrame.location.href = '../../eMO/jsp/MOManageDeceasedSearchResult.jsp?area_code='+area_code+"&patient_id="+patient_id+"&gender="+gender+"&registration_no="+registration_no+"&called_from_ca="+called_from_ca;
}

//Date validation
/*function doDateTimeChk(obj)
{	
	if(obj.value!='')
	{
		if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
		{
			retval= false
			alert(getMessage("INVALID_DATE_TIME"))
			obj.focus()
		}
		else
		{
			var comp=obj
			obj=obj.value
			var dttime = obj.split(" ");
			var dt
			var time
			var retval=true
			if(dttime.length>1)
			{
				dt=dttime[0]
				time=dttime[1]
				if(!checkDt(dt) )
				{
					retval= false
					alert(getMessage("INVALID_DATE_TIME"))
					comp.focus()
				}
				else
				{
					if(time==null || time=="")
					{
						alert(getMessage("INVALID_DATE_TIME"))
						retval= false;
						comp.focus()
					}
					else
					{
						if(!chkTime(time))
						{
							retval= false
							alert(getMessage("INVALID_DATE_TIME"))
							comp.focus()
						 }
					}
				}
		}
		else
		{
			retval= false
			alert(getMessage("INVALID_DATE_TIME"))
			comp.focus()
		}
		if(retval)
		{
			TimeChk();
		}
	}
  }
  return retval
}*/
function TimeChk()
{
	from	= document.forms[0].system_date.value;
	to		= document.forms[0].assign_tmt_area_time.value;

	var a	  =  from.split(" ")
	splitdate =	 a[0];
	splittime =	 a[1]

	var splitdate1 = splitdate.split("/")
	var splittime1 = splittime.split(":")
	var from_date  = new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a          = to.split(" ")
	splitdate  = a[0];
	splittime  = a[1]
	splitdate1 = splitdate.split("/")
	splittime1 = splittime.split(":")

	 var to_date  = new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 if(Date.parse(to_date) > Date.parse(from_date))
	 {
		alert(getMessage('START_DATE_GREATER_SYSDATE','Common'))
		document.forms[0].assign_tmt_area_time.focus();
		return false
	 }
	 else
	 {
	 	chkforDeceased();
		return true;
	 }
}

function chkforDeceased() 
{
	from  = document.forms[0].body_received_date.value;
	to    = document.forms[0].assign_tmt_area_time.value;
	var a =  from.split(" ")
	splitdate = a[0];
	splittime = a[1]

	var splitdate1 =splitdate.split("/")
	var splittime1= splittime.split(":")
    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    a   =  to.split(" ")
	splitdate = a[0];
	splittime = a[1]
	splitdate1 =splitdate.split("/")
    splittime1= splittime.split(":")
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'))
		document.forms[0].assign_tmt_area_time.focus();
		return false
	}
	else
		return true;
}

function showChart(encounter_id,patient_class,patient_id)
{
   

	
	var called_from_ca = document.getElementById('called_from_ca').value;
	
	if(called_from_ca == "Y")
	{

		//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
		xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" logged_user='' action='isPractRestricted' /></root>"
		 var temp_jsp="../../eMP/jsp/MPIntermediate.jsp";
		 var xmlDoc = "" ;
		 var xmlHttp = new XMLHttpRequest() ;
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		 xmlHttp.open("POST",temp_jsp,false);
		 xmlHttp.send(xmlDoc);
		 var responseText = xmlHttp.responseText;
		 var response = trimString(xmlHttp.responseText);
		 //End of MMS-DM-CRF-0210.1
		 if(response == "N"){
		
		
		var HTMLVal  = "<html>";
		HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
		HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
		HTMLVal  += "<input type='hidden' name='patient_class' id='patient_class' value='" + patient_class + "'>";
		HTMLVal  += "<input type='hidden' name='patient_id' id='patient_id' value='" + patient_id + "'>";
		//HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='MO'>";
		HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='N'>";
		HTMLVal  += "</form>";
		HTMLVal  += "</html>";

	 //  parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);			
//	parent.messageFrame.document.OpenChartWrapperForm.submit();	

		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);			
		top.content.messageFrame.document.OpenChartWrapperForm.submit();	
	}else{
		alert(getMessage('ACCESS_RESTRICTED_AUTH_PERSONAL','COMMON'));
	}
	}
}
//Below Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
async function showOperations(encounterID,patientID,registration_no,burial_no,obtfrm,pmyn,causereg,external,CLAIMANT_TYPE,RELEASE_TO_FACILITY)
{
var function_id=document.forms[0].function_id.value;
 
	if(document.forms[0].callfrommoreg.value == 'releaseDeceased')
	{
	FnChkEmbalmCompleted(patientID);
	
	
	
	if(document.forms[0].embalm_completed.value == 1){
		alert(getMessage("EMBALM_NOT_COMPLETED","MO"));
		return ;
	}
		
	if(external=="Y"){
		causereg="Y";
		obtfrm="";
	}
	
	 if(CLAIMANT_TYPE!="F" && causereg!="Y" && obtfrm=="")
	 {
	 //alert("APP-MO0042 Cause of Death not Recorded. Cannot Proceed.");
	 alert(getMessage("CAUSE_OF_DEATH_NOT_REC","MO"));
	 return ;
	 }
	 	
	if((obtfrm=='A'||obtfrm=='D')&&pmyn!='Y')
	{ 
    var retVal			= "";
	var dialogHeight	= "36"; 
	var dialogWidth		= "53"; 
	var dialogTop		= "50";
	var status			= "no";
	var arguments		= "";
	
	 //Below line Added ML-MMOH-CRF-0860.2	
	
	if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value=="true"){
	  dialogWidth		= "75"; 
	}
	//End ML-MMOH-CRF-0860.2
	
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
	var action_url	=	"../../eMO/jsp/MOReleaseDeceasedSearchFrameset.jsp?function_id="+function_id+"&param="+registration_no+"&first=N&external="+external;

	retVal	= await window.showModalDialog(action_url,arguments,features);

	if(retVal=="")
	{
	parent.frames[3].location.reload();
	}

	}
	
	
    else if((pmyn!='Y')&&(document.forms[0].burial_permit_reqd_yn.value=="Y" && burial_no==""))
	{
	//alert("APP-MO0039 Burial Permit is not yet generated.Cannot Proceed....")
	 
		alert(getMessage("BUR_NT_GEN","MO"));
	}
	else
		{
		var retVal			= "";
		var dialogHeight	= "36"; 
		var dialogWidth		= "53"; 
		var dialogTop		= "50";
		var status			= "no";
		var arguments		= "";
		
	//Below line Added ML-MMOH-CRF-0860.2	
	if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value=="true"){
	      dialogWidth = "75"; 
	}
	//End ML-MMOH-CRF-0860.2
		
		
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
		var action_url	=	"../../eMO/jsp/MOReleaseDeceasedSearchFrameset.jsp?function_id="+function_id+"&param="+registration_no+"&first=N&external="+external;
		
		retVal	= await window.showModalDialog(action_url,arguments,features);
		//retVal	= window.open(action_url,arguments,features);
		if(retVal=="")
			{
		parent.frames[3].location.reload();
			}

		}
		//}
	}else if(document.forms[0].callfrommoreg.value == 'ExpoOfDeceased')
	{
		var retVal			= "";
		var dialogHeight	= "32"; 
		var dialogWidth		= "62"; 
		var dialogTop		= "90";
		var status			= "no";
		var arguments		= "";
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status=" + status + ";";
		var action_url = "../../eMO/jsp/MOExportDeceasedSearchFrameset.jsp?function_id="+function_id+"&param="+registration_no+"&first=N&external="+external;
		
		retVal	= await  window.showModalDialog(action_url,arguments,features);
		if(retVal=="")
		parent.frames[3].location.reload();
		
	}else if(document.forms[0].callfrommoreg.value == 'callfrombdyprt')
	{
		parent.document.getElementById('b').rows='*' 
		parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_BODY_PART_REGN&function_name=Body%20Part%20Registration&function_type=F&access=YYYNN" 

		top.content.location.href = "../../eMO/jsp/MORegisterBodyPart.jsp?"+parameter+"&patientID="+patientID+"&registration_no="+registration_no+"&mode=modify&external="+external ;  
	}
	else
	{   
		parent.document.getElementById("patientFrame").style.height="30vh";
		//parent.document.getElementById('b').rows='*' 
		
		parameter="menu_id=MO_MENU&module_id=MO&function_id="+function_id+"&function_name=Change Deceased Details&function_type=F&access=NYYNN&register_no="+registration_no; //Added for Bru-HIMS-CRF-407 [IN:045167]

		top.content.location.href = "../../eMO/jsp/MORegisterDeceased.jsp?function_id="+function_id+"&"+parameter+"&patientID="+patientID+"&mode=modify&external="+external ; 
		//alert(top.content.location.href);
	}
}
//Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]
async function showAllowedOperations(obj,obj1,obj2,obj3,obj4,pm_yn,obj6, assign_area_code,area_type,bed_no,patient_id,or_install_yn,order_catalog_code,encounterId,CLAIMANT_TYPE,RELEASE_TO_FACILITY)
{
var function_id=document.forms[0].function_id.value;

	var retVal  = "";
	var retVal1 = "";
	retVal  = obj;
	retVal1 = obj1;
	retVal2 = obj2;
	retVal3 = obj3;
	retVal4 = obj4;
	retVal5 = pm_yn;
	retVal6 = obj6;
	var area_type = area_type
	
	select_area_desc=retVal1;	
    select_area_desc = encodeURIComponent(select_area_desc);		
	select_registration=retVal2;
	select_name=retVal3;
	select_sex=retVal4;
	select_pmyn=retVal5;
	select_pmstatus=retVal6;
	
	var dialogHeight	=	"15vh";
	//dialogHeight		=	"5" ;
	var dialogWidth		=	"20vw" ;
	var dialogTop		=	"200";
	var status			=	"no";
	var arguments		=	"" ;
	if (retVal != null && retVal =="a")
	{	// Param Value Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type+"&bed_no="+bed_no+"&patient_id="+patient_id+"&or_installyn="+or_install_yn+"&order_catalog_code="+order_catalog_code+"&encounterId="+encounterId+"&CLAIMANT_TYPE="+CLAIMANT_TYPE+"&RELEASE_TO_FACILITY="+RELEASE_TO_FACILITY;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
		retVal				=	await window.showModalDialog(action_url,arguments,features);
		//Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]
		if( retVal=="AssignArea" || retVal=="AssignReassignPractitioner" || retVal=="ReassignArea" || retVal=="startpm"|| retVal=="endpm" || retVal=="cancelpm")
		{
			selection_mode		=	retVal;
			var dialogHeight	=	"50vh"; 
			var dialogWidth		=	"45vw"; 
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			//Param Value Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type+"&bed_no="+bed_no+"&patient_id="+patient_id+"&CLAIMANT_TYPE="+CLAIMANT_TYPE+"&RELEASE_TO_FACILITY="+RELEASE_TO_FACILITY;
			var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
			retVal	=	await window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
			{
				if(retVal=="Success")
				{
					parent.AEMPSearchResultFrame.location.reload();
				}
			}
		}
		else if(retVal=="startpm")
		{	
			var dialogHeight	=	"50vh"; 
			var dialogWidth		=	"45vw"; 
			var dialogTop		=	"150";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="startpm";
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
			retVal	= await	top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
				if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
		else if(retVal=="endpm")
		{
			var dialogHeight	=	"50vh"; 
			var dialogWidth		=	"45vw"; 
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="endpm";
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; overflow: hidden; dialogTop:"+dialogTop+";";
			retVal	=	await top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
				if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
		else if(retVal=="cancelpm")
		{
			var dialogHeight	=	"50vh"; 
			var dialogWidth		=	"45vw"; 
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="endpm";
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; overflow: hidden; dialogTop:"+dialogTop+";";
			retVal	=await top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
				if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
	
}
//--------------1st  block finish
//Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]	
else if ((retVal != null) && (retVal =="b")) // for others ("b") 
{		    selection_mode		=	retVal;
			var dialogHeight	=	"15vh";
			var dialogWidth		=	"vw";
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			// Param Value Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
			var action_url		=	
			"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type+"&bed_no="+bed_no+"&patient_id="+patient_id+"&or_installyn="+or_install_yn+"&order_catalog_code="+order_catalog_code+"&encounterId="+encounterId+"&CLAIMANT_TYPE="+CLAIMANT_TYPE+"&RELEASE_TO_FACILITY="+RELEASE_TO_FACILITY;
			
		    var features	   =	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; overflow: hidden; dialogTop:"+dialogTop+";";
			retVal	           =await	top.window.showModalDialog(action_url,arguments,features);
//Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]			
	if(retVal=="AssignArea" ||retVal=="ReassignArea")
	{	
			selection_mode		=	retVal;
			var dialogHeight	=	"45vh";
			var dialogWidth		=	"40vw";
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			// Param Value Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type+"&bed_no="+bed_no+"&patient_id="+patient_id+"&CLAIMANT_TYPE="+CLAIMANT_TYPE+"&RELEASE_TO_FACILITY="+RELEASE_TO_FACILITY;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; overflow: hidden; dialogTop:"+dialogTop+";";
			retVal	= await	top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
			{
				if(retVal=="Success")
				{
					parent.AEMPSearchResultFrame.location.reload();
				}
			}
		} 
		
		else if(retVal=="startpm")
		{
			var dialogHeight	=	"45vh";
			var dialogWidth		=	"40vw";
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="startpm";
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; overflow: hidden; dialogTop:"+dialogTop+";";
			retVal	= await	top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
		if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}else if(retVal=="RegisterDeceased")
		{  
			var dialogHeight	=	"45vh";
			var dialogWidth		=	"40vw";
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="endpm";
			var action_url		=	"../../eMO/jsp/MORegisterDeceased.jsp?function_id="+function_id+"&menu_id=MO_MENU&module_id=MO&function_id=MO_CHANGE_DECEASED&function_name=Manage Patient Details&function_type=F&access=NYNNN&patientID="+patient_id+'&menudis=Y';
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; overflow: hidden; dialogTop:"+dialogTop+";";
			retVal	= await top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
				if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
		else if(retVal=="endpm")
		{
			var dialogHeight	=	"45vh";
			var dialogWidth		=	"40vw";
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="endpm";
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
			retVal	= await	top.window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
				if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
		else if(retVal=="cancelpm")
		{
			var dialogHeight	=	"45vh";
			var dialogWidth		=	"40vw";
			var dialogTop		=	"200";
			var status			=	"no";
			var arguments		=	"" ;
			retVal="endpm";
			var action_url		=	"../../eMO/jsp/MOManageDeceasedAllowedOperationMain.jsp?function_id="+function_id+"&selection_mode="+retVal+"&select_registration="+select_registration+"&select_name="+select_name+"&select_sex="+select_sex+"&select_area_desc="+select_area_desc+"&select_pmyn="+select_pmyn+"&assign_area_code="+assign_area_code+"&select_pmstatus="+select_pmstatus+"&area_type="+area_type;
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
			retVal	= await window.showModalDialog(action_url,arguments,features);
			if(retVal!=null)
				if(retVal=="Success")
					parent.AEMPSearchResultFrame.location.reload();
		}
  }
  window.location.reload();
}

function callOperation(operation)
{
	parent.window.returnValue = operation;
	//parent.window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();
}

function cancelOperation()
{
	parent.window.returnValue = "";
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();
	//parent.window.close();
}

function startConsultation()
{
	document.forms[0].target = parent.frames[2].name;
	document.forms[0].method = "POST";
	document.forms[0].ok.disabled=true;
	document.forms[0].submit();
}
function callPatientSearch()
{
	var patientid = PatientSearch('','','','','','','Y','','Y','MO');
	if(patientid!=null)
	{
	 document.getElementById("patient_id").value = patientid;
	 document.getElementById("patient_id").focus();
	}
	else
	{
		document.getElementById("patient_id").value = "";
	}
}
      
function reset()
{	
	frames[1].document.location.reload();
	frames[2].document.location.reload();
	frames[3].document.location.href='../../eCommon/html/blank.html';
	//messageFrame.document.location.href='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp'
	//AEMPSearchCriteriaFrame.location.href = '../../eMO/jsp/MOManageDeceasedSearchCriteria.jsp';
	//AEMPSearchResultFrame.location.href='../../eCommon/html/blank.html';
}

function query()
{
	var	queue_refresh_interval	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].queue_refresh_interval.value;
	var	checkout_yn	=	f_query_add_mod.AEMPSearchCriteriaFrame.document.forms[0].checkout_yn.value;
	f_query_add_mod.location.href = "../../eAE/jsp/AEManagePatientMain.jsp?queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn;
}

function callreport()
{
	var registration_no = document.forms[0].registration_no.value;
	var  facility_id = document.forms[0].facility_id.value;
	var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH facility_id=\""+facility_id+"\" registration_no=\""+registration_no+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ReportBodyTag.jsp",false);
	xmlHttp.send(xmlDoc)
}

/*function CapacityCheck()
{
  var registration_no = document.forms[0].registration_no.value;
  var area_code = document.forms[0].area_code.value;
  document.forms[0].bed_no.value='';
  if(area_code!="")
  {
		var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH registration_no=\""+registration_no+"\" area_code=\""+area_code+"\"/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","MOCapacityCheck.jsp",false);
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		
		if(responseText=="checked")
		{
			alert(getMessage("AREA_EXCEEDS_CAPACITY"))
			document.forms[0].area_code.value = '';
		    return false;
		document.forms[0].bed_no.disabled=true;
	document.forms[0].bed_button.disabled=true;
		}
   document.forms[0].bed_no.disabled=false;
   document.forms[0].bed_button.disabled=false;
   
  }else
	{
	  document.forms[0].bed_no.disabled=true;
	document.forms[0].bed_button.disabled=true;
	}
}*/
function clearBed()
{	  
    if(document.forms[0].area_code.value != "")
	{
	  document.forms[0].bed_no.value="";
	  document.forms[0].bed_no.disabled=false;
	  document.forms[0].bed_button.disabled=false;	 
	}else{
	    document.forms[0].bed_no.value="";
	    document.forms[0].bed_no.disabled=true;
		document.forms[0].bed_button.disabled=true;
		
	}	
}

function clearBed1()
{	  
    if(document.forms[0].area_code.value != "")
	{
	 // document.forms[0].bed_no.value="";
	  document.forms[0].bed_no.disabled=false;
	  document.forms[0].bed_button.disabled=false;	 
	}else{
	    document.forms[0].bed_no.value="";
	    document.forms[0].bed_no.disabled=true;
		document.forms[0].bed_button.disabled=true;
		
	}	
}

function BedCheck()
{
  var area_code = document.forms[0].area_code.value;
  var curr_area_code = document.forms[0].assign_area_code.value;
  var bed_no =document.forms[0].bed_no.value;
  var old_bed_no =document.forms[0].old_bed_no.value;  
  var patient_id =document.forms[0].patient_id.value;
  var bedVaild='Y';
  if(area_code!="" && bed_no != "" && (bed_no!=old_bed_no || area_code!=curr_area_code) )
  {

		var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\" area_code=\""+area_code+"\" patient_id=\""+patient_id+"\"  bedVaild=\""+bedVaild+"\"/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","MOCapacityCheck.jsp",false);		
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)		
		if(responseText=="Invalid")
		{
			//alert(getMessage("INVALID_BAY"))
			var msg = getMessage("INVALID_VALUE","Common");
			msg = msg.replace("#",getLabel("Common.Location.label","Common"));
			alert(msg);
			
			document.forms[0].bed_no.value = '';
			document.forms[0].bed_no.select();
		}
  }

 /*if(document.forms[0].area_code.value != "")
	{
	 document.forms[0].bed_no.value="";
	 document.forms[0].bed_no.disabled=false;
	document.forms[0].bed_button.disabled=false;
	}
	else{
		document.forms[0].bed_no.value="";
	   document.forms[0].bed_no.disabled=true;
	document.forms[0].bed_button.disabled=true;
	}*/
}

function blurRFID(obj){
	if(obj.value !="" && obj.value != document.forms[0].old_rfidtag.value ){
		searchRFID(obj,document.forms[0].RFID_Tag);
	}
}

async function searchRFID(obj,target){
	var retVal =    new String(); 
	var area_code = "";
	var retVal = "";
	var dialogHeight= "60vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";	 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    var retVal= await window.showModalDialog("../../eMO/jsp/RFIDTagFrameset.jsp?RFID_No="+document.forms[0].RFID_Tag.value+"&patient_id="+document.forms[0].patient_id.value,arguments,features);
    if(retVal != null && retVal != "" ){
	  document.forms[0].RFID_Tag.value=retVal;
	 }else{
		 document.forms[0].RFID_Tag.value="";
	 }
}


function placeOrderSpecimen(){

	patient_id = parent.frames[2].document.forms[0].patient_id.value;
	patient_class = parent.frames[2].document.forms[0].patient_class.value;
	facility_id = parent.frames[2].document.forms[0].facility_id.value;
	encounter_id = parent.frames[2].document.forms[0].encounter_id.value;
	var postmortem_type=parent.frames[2].document.forms[0].postmortem_type.value;
	var postmortem_status=parent.frames[2].document.forms[0].postmortem_status.value;
	var regstrn_no=parent.frames[0].document.getElementById('regstrn_no').innerText;
	var body_part_yn="";
	var patient_age=parent.frames[2].document.forms[0].age.value;
	var patient_dob=parent.frames[2].document.forms[0].date_of_birth.value;
	var visit_adm_date=parent.frames[2].document.forms[0].body_rec_date_time.value;
	var body_part_yn=parent.frames[2].document.forms[0].body_part_obtained_from.value;
	var deceased_yn=parent.frames[2].document.forms[0].deceased_yn.value;
/*	Commented for IN046181 Starts
	if(postmortem_type=='M'){
		postmortem_type='Y';// medico leagal death
	}else{
		postmortem_type='N';// clinical death
	}
*/ //Commented for IN046181 Ends
	var retVal =    new String(); 
	var area_code = "";
	var retVal = "";
	var dialogHeight= "40" ;
	var dialogWidth	= "70" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";	 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
	
	//alert("../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&requestedModule=MO&invoke_function_id=ORDER_ENTRY")
    //var retVal=	window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&requestedModule=MO&invoke_function_id=ORDER_ENTRY",arguments,features);
	//var url="../../eOR/jsp/ExistingOrderFrameSetMO.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&invoke_function_id=ORDER_ENTRY&invokin_module=MO&deceased_yn=Y&before_postmortem_yn=Y&medico_legal_yn="+postmortem_type+"&function_id=ORDER_ENTRY";
	var url="../../eOR/jsp/ExistingOrderResultsFrameset.jsp?patientId="+patient_id+"&function_from=MO&ord_status=Z&order_by=D&view=C&view_by=L&search_criteria=S&patient_class="+patient_class+"&facility_id="+facility_id+"&encntr_id="+encounter_id+"&requestedModule=MO&deceased_yn="+deceased_yn+"&medico_legal_yn="+postmortem_type+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+regstrn_no+"&age="+patient_age+"&dob="+patient_dob+"&visit_adm_date="+visit_adm_date+"&callingFrom=Q";
	window.showModalDialog(url,arguments,features);

  /* if(retVal != null && retVal != "" ){
	  document.forms[0].RFID_Tag.value=retVal;
	 }else{
	 document.forms[0].RFID_Tag.value="";
	 }*/
	 
}
// BRU-HIMS-CRF-270
function checkLength(Obj,SizeVal)   {

   if ( Obj.value.length > SizeVal )
    {
	    var msg = getMessage("OBJ_CANNOT_EXCEED",'Common');
		msg = msg.replace('$', SizeVal);
		alert(msg);	
        Obj.select();
		return false;
    } else {
		if(Obj.name == 'cause_remarks1') {
			if(document.forms[0].doc_id1_desc)
				document.forms[0].doc_id1_desc.focus();
		}
		else if(Obj.name == 'cause_remarks2') {
			if(document.forms[0].doc_id1_desc)
				document.forms[0].doc_id1_desc.focus();
		}
		else if(Obj.name == 'cause_remarks3') {
			if(document.forms[0].doc_id1_desc)
				document.forms[0].doc_id1_desc.focus();
		}
		else if(Obj.name == 'cause_remarks4') {
			if(document.forms[0].doc_id1_desc)
				document.forms[0].doc_id1_desc.focus();
		}
		else if(Obj.name == 'cause_remarks5') {
			if(document.forms[0].doc_id1_desc)
				document.forms[0].doc_id1_desc.focus();
		}
		else
		if(document.forms[0].doc_id1_desc){
				document.forms[0].doc_id1_desc.focus();}
		
	    return true;
	}
}

function makeValidStringRemark(txtObj)
{  

	
	var text_value  =   txtObj.value;
	
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
		
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}


function FnChkEmbalmCompleted(patient_id){

	$.ajax({  
	     url:'../../eMO/jsp/getdetailsMO.jsp',  
	     type:'post',  
	     data:{'action':'get_embalm_completed_status','patient_id':patient_id},
	     dataType: 'json',
	     async:false,// preventing other events on the page from firing
	     success: function(data) {
		
	    	 if(data.rowcnt > 0){
	    		 $("#embalm_completed").val(1);
	    	 }else{
				 $("#embalm_completed").val(0);
			 }
	     },
	     error: function(jqXHR, textStatus, errorThrown) {
	         alert("incoming Text " + jqXHR.responseText);
			  $("#embalm_completed").val(0);
	     }
	 });
	
}

