function codeCheck(Obj){	
var u=Obj ;
	//parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
      parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	var ReportName=parent.parent.frames[2].frames[1].document.forms[0].ReportName.value;		
	if(u==' ')
	{
		parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
	}
    /*else if (u=="FMBATRCD")
    {
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMInternalReportTracerCardMain.jsp?ReportName="+u;
	}*/
	else
	{
          if(ReportName=="RE"){ 
				parent.parent.frames[2].req.rows="35%,*";  
		  }else{
                parent.parent.frames[2].req.rows="45%,*";  
		  }
		  parent.searchResultFrame.location.href ="../../eFM/jsp/FMInternalReportReprintMain.jsp?ReportName="+u+"&Reportvalue="+ReportName;
	      
	     if(ReportName=="RE"){
			parent.searchResultFrame1.location.href='../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp';
	     }else{
			 parent.searchResultFrame1.location.href='../../eCommon/html/blank.html';
		 }
	   }
}


function run()
{
	
		
	if(parent.frames[2].frames[1].document.getElementById("ReportName").value != "")
	{
		parent.content.commontoolbarFrame.location.href = '../../eCommon/html/process.html';
        var to_proceed = true;
        var patid="";
		var fileno="";
		var volno="";
		var encounter_id="";
		var fields = new Array ( parent.parent.frames[2].frames[2].document.forms[0].fs_locn_code,parent.parent.frames[2].frames[2].document.forms[0].appt_date);
		var report_id = parent.parent.frames[2].frames[2].document.forms[0].p_report_id.value;
		var repreq_id=parent.parent.frames[2].frames[2].document.forms[0].p_repreq_id.value;
		var appt_date = parent.parent.frames[2].frames[2].document.forms[0].appt_date.value;
		var fs_locn_code = parent.parent.frames[2].frames[2].document.forms[0].fs_locn_code.value;
		var ReportName=parent.parent.frames[2].frames[1].document.forms[0].ReportName.value;		
	    var req_user_id="";
	   if(parent.parent.frames[2].frames[2].document.forms[0].req_name)
	    req_user_id=parent.parent.frames[2].frames[2].document.forms[0].req_name.value;
	   parent.parent.frames[2].frames[2].document.forms[0].Rep_name.value=ReportName;
		var logged_fcy=""
		var Req_to_facid="";
		var narration_code="";
	    var requesting_from="";
		var pull_list_type="";
		var fr_pract   ="";
		var to_pract ="";
		var fr_clcode ="";
		var to_clcode ="";
		var fr_nurcode ="";
		var to_nurcode ="";
		var p_reprint_yn =parent.parent.frames[2].frames[2].document.forms[0].p_reprint_yn.value;//Added @UAT-3 Starts
		if(report_id =="FMBPULST" || report_id=="FMBIPLST"){
			p_reprint_yn ="Y";
			parent.parent.frames[2].frames[2].document.forms[0].p_reprint_yn.value="Y";
		}//Added @UAT-3 Ends
		if(ReportName=="RE")
		{ 
		 logged_fcy=parent.parent.frames[2].frames[3].document.forms[0].logged_fcy.value;
		 if(logged_fcy=="E"){
		 Req_to_facid=parent.parent.frames[2].frames[3].document.forms[0].enter_fcy.value;
		parent.parent.frames[2].frames[2].document.forms[0].req_fac_id.value=Req_to_facid;
		}
		encounter_id=parent.parent.frames[2].frames[3].document.forms[0].encounter_id.value
		requesting_from =parent.parent.frames[2].frames[2].document.forms[0].requesting_code.value
		patid=parent.parent.frames[2].frames[3].document.forms[0].patientid.value;
		fileno=parent.parent.frames[2].frames[3].document.forms[0].fileno.value;
		volno=parent.parent.frames[2].frames[3].document.forms[0].volumeno.value;
		parent.parent.frames[2].frames[2].document.forms[0].pat_id.value=patid;
		parent.parent.frames[2].frames[2].document.forms[0].file_no.value=fileno;
		parent.parent.frames[2].frames[2].document.forms[0].vol_no.value=volno;
	    parent.parent.frames[2].frames[2].document.forms[0].encounter_id.value=encounter_id;
		encounter_id
		
		}
		if(ReportName=="OP" || ReportName=="IP")
		{
				
		volno=parent.parent.frames[2].frames[2].document.forms[0].volumeno.value;
		patid=parent.parent.frames[2].frames[2].document.forms[0].patientid.value;
		fileno=parent.parent.frames[2].frames[2].document.forms[0].fileno.value;
		pull_list_type=parent.parent.frames[2].frames[2].document.forms[0].print_pull_list_type.value;
		fr_pract==parent.parent.frames[2].frames[2].document.forms[0].fm_pract_id.value;
		to_pract==parent.parent.frames[2].frames[2].document.forms[0].fm_pract_id.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].fm_clinic_code)
		fr_clcode=parent.parent.frames[2].frames[2].document.forms[0].fm_clinic_code.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].to_clinic_code)
		to_clcode=parent.parent.frames[2].frames[2].document.forms[0].to_clinic_code.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].fm_nursing_unit_code)
		fr_nurcode=parent.parent.frames[2].frames[2].document.forms[0].fm_nursing_unit_code.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].to_nursing_unit_code)
		to_nurcode=parent.parent.frames[2].frames[2].document.forms[0].to_nursing_unit_code.value;
	
		}
if(report_id=="FMBMRPLA" || report_id=="FMBMRPLI")
		{
       pull_list_type=parent.parent.frames[2].frames[2].document.forms[0].print_pull_list_type.value;
       fr_pract==parent.parent.frames[2].frames[2].document.forms[0].fm_pract_id.value;
		to_pract==parent.parent.frames[2].frames[2].document.forms[0].fm_pract_id.value;
	if(parent.parent.frames[2].frames[2].document.forms[0].fm_clinic_code)
		fr_clcode=parent.parent.frames[2].frames[2].document.forms[0].fm_clinic_code.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].to_clinic_code)
		to_clcode=parent.parent.frames[2].frames[2].document.forms[0].to_clinic_code.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].fm_nursing_unit_code)
		fr_nurcode=parent.parent.frames[2].frames[2].document.forms[0].fm_nursing_unit_code.value;
		if(parent.parent.frames[2].frames[2].document.forms[0].to_nursing_unit_code)
		to_nurcode=parent.parent.frames[2].frames[2].document.forms[0].to_nursing_unit_code.value;
		
		
		}
		
		
		if (report_id=="FMBMRPLA" ||( report_id=="FMBPULST" && ReportName=="FMBPULST")|| report_id=="FMBATRCD" || repreq_id=="OP" )				
			var names = new Array (getLabel("Common.FileStorageLocation.label","common"), getLabel("Common.apptdate.label","common"));	
        else
			if(report_id=="FMBISSCD" )
			var names = new Array ( getLabel("Common.FileStorageLocation.label","common"), getLabel("Common.issueddate.label","common"));
		else if(repreq_id=="RE")
		{
	//	var names = new Array ( getLabel("Common.FileStorageLocation.label","common"), getLabel("Common.issueddate.label","common"),getLabel("eFM.Requesting.label","fm"));
		}
		else
			var names = new Array ( getLabel("Common.FileStorageLocation.label","common"), getLabel("Common.BookingDate.label","common"));	
		var errors = "";
		to_proceed=false;
		if (report_id=="FMBMRPLA" || ( report_id=="FMBPULST" && ReportName=="FMBPULST")  || report_id=="FMBATRCD" || repreq_id=="OP")				{
		if( parent.parent.frames[2].frames[2].CheckString('Clinic Code', parent.parent.frames[2].frames[2].document.forms[0].fm_clinic_code,parent.parent.frames[2].frames[2].document.forms[0].to_clinic_code, parent.parent.frames[2].frames[4] ) )	
					to_proceed=true;
		}else if (report_id=="FMBISSCD")
	{to_proceed=true;
	}				
	else if(repreq_id=="RE")	
		{
		//if(parent.parent.frames[2].frames[2].CheckString( getLabel('Common.NursingUnitCode.label','common'), parent.parent.frames[2].frames[2].document.forms[0].fm_nursing_unit_code,parent.parent.frames[2].frames[2].document.forms[0].to_nursing_unit_code, parent.parent.frames[2].frames[3] )  )	
		Reqfilevali();
		
		to_proceed=parent.parent.frames[2].frames[2].document.forms[0].value;
		}
		else
		{
		if( parent.parent.frames[2].frames[2].CheckString( getLabel('Common.NursingUnitCode.label','common'), parent.parent.frames[2].frames[2].document.forms[0].fm_nursing_unit_code,parent.parent.frames[2].frames[2].document.forms[0].to_nursing_unit_code, parent.parent.frames[2].frames[4] )  )	
		to_proceed=true;
								}
		if( (parent.parent.frames[2].frames[2].document.forms[0].to_pract_id))
			{
			if( parent.parent.frames[2].frames[2].CheckString('Practitioner ID', parent.parent.frames[2].frames[2].document.forms[0].fm_pract_id,parent.parent.frames[2].frames[2].document.forms[0].to_pract_id, parent.parent.frames[2].frames[4])  )	
				{
				to_proceed=true;
				}
			}

		if(repreq_id!="RE")
		{
		for( var i=0; i<fields.length; i++ ) 
		{
			if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
			}
			else
			{
			//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors = errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>" ;
				errors = errors.replace('$',names[i]);
			}
		}
		
		if ( errors.length != 0 ) 
		{
		parent.parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		}
	//appt_date=convertDate(appt_date,"DMY",localeName,"en")
		if (to_proceed==true)
		{
			if (report_id=="FMBISSCD" || report_id=="FMBATRCI"|| report_id=="FMBATRCD")
			{
			var fileno = parent.parent.frames[2].frames[2].document.forms[0].fileno.value;
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMInternalReportRecordExists.jsp'><input name='report_id' id='report_id' type='hidden' value='"+report_id+"'><input name='issue_date' id='issue_date' type='hidden' value='"+appt_date+"'><input name='file_location' id='file_location' type='hidden' value='"+fs_locn_code+"'><input name='fileno' id='fileno' type='hidden' value='"+fileno+"'><input name='repreq_id' id='repreq_id' type='hidden' value='"+ReportName+"'><input name='req_user_id' id='req_user_id' type='hidden' value='"+req_user_id+"'><input name='requesting_from' id='requesting_from' type='hidden' value='"+requesting_from+"'><input name='patid' id='patid' type='hidden' value='"+patid+"'><input name='fileno' id='fileno' type='hidden' value='"+fileno+"'><input name='encounter_id' id='encounter_id' type='hidden' value='"+encounter_id+"'><input name='volno' id='volno' type='hidden' value='"+volno+"'><input name='logged_fcy' id='logged_fcy' type='hidden' value='"+logged_fcy+"'><input name='Req_to_facid' id='Req_to_facid' type='hidden' value='"+Req_to_facid+"'><input name='p_reprint_yn' id='p_reprint_yn' type='hidden' value='"+p_reprint_yn+"'></form></BODY></HTML>"; 
			parent.parent.frames[2].frames[4].document.write(HTMLVal);
			parent.parent.frames[2].frames[4].document.form1.submit();
			}
			else
			{
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMInternalReportRecordExists.jsp'><input name='report_id' id='report_id' type='hidden' value='"+report_id+"'><input name='issue_date' id='issue_date' type='hidden' value='"+appt_date+"'><input name='file_location' id='file_location' type='hidden' value='"+fs_locn_code+"'><input name='repreq_id' id='repreq_id' type='hidden' value='"+ReportName+"'><input name='req_user_id' id='req_user_id' type='hidden' value='"+req_user_id+"'><input name='encounter_id' id='encounter_id' type='hidden' value='"+encounter_id+"'><input name='requesting_from' id='requesting_from' type='hidden' value='"+requesting_from+"'><input name='patid' id='patid' type='hidden' value='"+patid+"'><input name='fileno' id='fileno' type='hidden' value='"+fileno+"'><input name='volno' id='volno' type='hidden' value='"+volno+"'><input name='logged_fcy' id='logged_fcy' type='hidden' value='"+logged_fcy+"'><input name='Req_to_facid' id='Req_to_facid' type='hidden' value='"+Req_to_facid+"'><input name='pull_list_type' id='pull_list_type' type='hidden' value='"+pull_list_type+"'><input name='fr_pract' id='fr_pract' type='hidden' value='"+fr_pract+"'><input name='to_pract' id='to_pract' type='hidden' value='"+to_pract+"'><input name='fr_clcode' id='fr_clcode' type='hidden' value='"+fr_clcode+"'><input name='to_clcode' id='to_clcode' type='hidden' value='"+to_clcode+"'><input name='fr_nurcode' id='fr_nurcode' type='hidden' value='"+fr_nurcode+"'><input name='to_nurcode' id='to_nurcode' type='hidden' value='"+to_nurcode+"'><input name='p_reprint_yn' id='p_reprint_yn' type='hidden' value='"+p_reprint_yn+"'></form></BODY></HTML>"; 
			parent.parent.frames[2].frames[4].document.write(HTMLVal);
			parent.parent.frames[2].frames[4].document.form1.submit();
			}
			

	//		parent.parent.frames[1].frames[2].document.forms[0].submit();
		}
	}
}



function onSuccess()
{
	var errors=getMessage("REPORT_SUBMIT_SERVER","common");
	parent.frames[2].frames[1].document.location.href='../../eFM/jsp/FMInternalReportReprintSearch.jsp';
	parent.frames[2].frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[3].document.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
}

function Reqfilevali()
{
  	     var errors = "";
	   var to_proceed = true;
	   var fields = new Array (parent.parent.frames[2].frames[2].document.forms[0].appt_date,parent.parent.frames[2].frames[3].document.forms[0].patientid);
	var names = new Array(getLabel("Common.RequestDate.label","common"),getLabel("Common.patientId.label","common"));
		
	var errors = "";
	
	for( var i=0; i<fields.length; i++ )
	{
		
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{
		errors = errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>" ;
		errors = errors.replace('$',names[i]);
		//errors=errors+"<br>";
		}//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	}
	if ( errors.length != 0 )
	{
		parent.parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}

parent.parent.frames[2].frames[2].document.forms[0].value=to_proceed;
}
 
 function reset()
 {
	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href = '../../eCommon/html/blank.html'; 
    searchResultFrame1.document.location.href = '../../eCommon/html/blank.html'; 
 }

function assignvalue(obj){
        if (obj.checked==true)
			obj.value='Y';
		else
		obj.value='N';
}

function EnableDisableBox_print_tel(obj)
{
			if (obj.checked==true)
				obj.value='Y';
			else
			    obj.value='N';

                    
}
function chngclinic(obj)
{
 if (obj.name=="fm_clinic_code")
	document.forms[0].to_clinic_code.value=obj.value;
 if (obj.name=="fm_pract_id")
   document.forms[0].to_pract_id.value=obj.value;
 if (obj.name=="fm_nursing_unit_code")
   document.forms[0].to_nursing_unit_code.value=obj.value;
}

function EnableDisableBox(obj,getVal)
{
		if (obj.checked==true)
		{
			obj.value='Y';
			document.forms[0].print_pull_list_type.value="S";
		}
		else
		{
			obj.value='N';
			document.forms[0].print_pull_list_type.value="M";
		}
}
function changeUpperCase(obj)
{
		obj.value = obj.value.toUpperCase();
}

async function searchCode1(target,facilityid)
{
			var retVal = 	new String();
			var dialogHeight= "85vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			

			if (target.name=="fm_clinic_code" ||target.name=="to_clinic_code"){				
				tit=getLabel("Common.clinic.label","common");
				sql="select CLINIC_CODE, long_desc from OP_CLINIC_LANG_VW where facility_id=`"+facilityid+"` and language_id=`"+localeName+"`";
				search_code="CLINIC_CODE";
				search_desc= "long_desc";
		}
		else{				
				tit=getLabel("Common.nursingUnit.label","common");
				sql="select nursing_unit_code, long_desc from IP_NURSING_UNIT_LANG_VW where facility_id=`"+facilityid+"`  and language_id=`"+localeName+"`";
				search_code="nursing_unit_code";
				search_desc= "long_desc";
		}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			//	if (target.name=="fm_clinic_code")
			//	document.forms[0].to_clinic_code.value=retVal;
			}
			else
				target.focus();
}
async function searchCode2(target,facilityid)
{
			var retVal = 	new String();
			var dialogHeight= "85vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			
			
				tit=getLabel("Common.user.label","common");
				sql="select PRACTITIONER_ID, PRACTITIONER_NAME from AM_PRACTITIONER_lang_vw where language_id=`"+localeName+"` ";
				search_code="PRACTITIONER_ID";
				search_desc= "PRACTITIONER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
		       // if (target.name=="fm_pract_id")
			//	document.forms[0].to_pract_id.value=retVal;

			}
			else
				target.focus();
}

function PopulateData(objval){	
	
		
	if(objval != '') {
		
		
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMInternalReportLocnPopup.jsp?locn_code="+objval+"'></form></body></html>" ;
		parent.messageFrame.document.write(HTMLVal) ;
		parent.messageFrame.document.GetLocIdentity.submit() ;
			
		}
		else {
			var len = OnlineReportReprintForm.fs_locn_code.length;

			for (var i=0; i<=len; i++) {
				OnlineReportReprintForm.fs_locn_code.remove("fs_locn_code");
			}
			var opt	= OnlineReportReprintForm.document.createElement('OPTION');
			opt.value =	"";
			opt.text = "----- "+getLabel("Common.defaultSelect.label","Common")+" -----";
			OnlineReportReprintForm.fs_locn_code.add(opt);
		}

}//End of Function

async function callPatientSearch()
{
	var ReportName=parent.parent.frames[2].frames[1].document.forms[0].ReportName.value;	
	var patient_id	=await	PatientSearch('','','','','','','Y','','','OTHER');	
	if((patient_id != null))
	{
		if(ReportName=="RE")
		{
		parent.frames[3].document.forms[0].patientid.value =patient_id;
		parent.frames[3].document.forms[0].patientid.focus();
		}else{
           parent.frames[2].document.forms[0].patientid.value =patient_id;
		    parent.frames[2].document.forms[0].patientid.focus();
		}
	if(ReportName=="RE")
		{  
	  parent.parent.frames[2].frames[3].document.forms[0].encounter_id.disabled=false;
	 parent.parent.frames[2].frames[3].document.forms[0].encounter_id_search.disabled=false;
		}
	   }
} 
function CheckPatientExists(ObjVal)
{	
var Rename=parent.frames[1].document.forms[0].ReportName.value;
var logged_fcy="";
var req_facility="";
if(ObjVal != "")
	{
	   var facility = parent.frames[2].document.forms[0].p_facility_id.value;
		var file_type_yn = parent.frames[2].document.forms[0].file_type_yn.value;
	   var patientid="";
		if(Rename=="RE")
		{
		 patientid=  parent.parent.frames[2].frames[3].document.forms[0].patientid.value
		if(parent.parent.frames[2].frames[3].document.forms[0].logged_fcy)
		 logged_fcy=parent.parent.frames[2].frames[3].document.forms[0].logged_fcy.value;
		  if(logged_fcy=="E"){
		 req_facility=parent.parent.frames[2].frames[3].document.forms[0].enter_fcy.value;
		  }
		 }else{
		 patientid=  parent.parent.frames[2].frames[2].document.forms[0].patientid.value
		}
	   if(Rename=="RE")
		{
	   if(patientid!="")
		{
	   parent.parent.frames[2].frames[3].document.forms[0].encounter_id.disabled=false;
	  parent.parent.frames[2].frames[3].document.forms[0].encounter_id_search.disabled=false;
		}else{
      parent.parent.frames[2].frames[3].document.forms[0].encounter_id.disabled=true;
	 parent.parent.frames[2].frames[3].document.forms[0].encounter_id_search.disabled=true;
		}
		}
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckPatientExists.jsp?func=tracer&Patient="+ObjVal+"&Facility="+facility+"&Rename="+Rename+"&logged_fcy="+logged_fcy+"&req_facility="+req_facility+"&file_type_yn="+file_type_yn+" \"> </form></body></html>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.forms[0].submit();
	}	
else{
   	
	  if(Rename=="OP" || Rename=="IP" )
	{
	if(parent.parent.frames[2].frames[2].document.forms[0].patientid.value=="")
		{  
	  removeitems(parent.parent.frames[2].frames[2].document.forms[0].fileno);
	  removeitems(parent.parent.frames[2].frames[2].document.forms[0].volumeno)
	  
	  }
	  if(parent.parent.frames[2].frames[2].document.forms[0].fileno=="")
		{
           removeitems(parent.parent.frames[2].frames[2].document.forms[0].volumeno)

		}
	  
	  }
	 
	 if(Rename=="RE")
		{
	   if(parent.parent.frames[2].frames[3].document.forms[0].patientid.value=="")
		{  
		removeitems(parent.parent.frames[2].frames[3].document.forms[0].fileno);
	    removeitems(parent.parent.frames[2].frames[3].document.forms[0].volumeno)
		}
		parent.parent.frames[2].frames[3].document.forms[0].encounter_id.disabled=true;
	 parent.parent.frames[2].frames[3].document.forms[0].encounter_id_search.disabled=true;
		}
}
}

function CheckFileExists(ObjVal)
{

	var Rename=parent.frames[1].document.forms[0].ReportName.value;
	if(ObjVal != "")
	{
		var facility = parent.frames[2].document.forms[0].p_facility_id.value;
		var req_facility="";
		var logged_fcy="";
		if(Rename=="RE")
		{
		var patient_id = parent.frames[3].document.forms[0].patientid.value; 
	   if(parent.parent.frames[2].frames[3].document.forms[0].logged_fcy)
		 logged_fcy=parent.parent.frames[2].frames[3].document.forms[0].logged_fcy.value;
		  if(logged_fcy=="E"){
		 req_facility=parent.parent.frames[2].frames[3].document.forms[0].enter_fcy.value;
		  }
		
		
		}else{
		var patient_id = parent.frames[2].document.forms[0].patientid.value; 
		}
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckFileExists.jsp?func=tracer&FileNo="+ObjVal+"&patient_id="+patient_id+"&Rename="+Rename+"&logged_fcy="+logged_fcy+"&req_facility="+req_facility+"&Facility="+facility+" \"> </form></body></html>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.forms[0].submit();
	}	else
	{
		 if(Rename=="FMBATRCD"  || (Rename=="FMBATRCI") || (Rename=="FMBISSCD"))
			removeitems(parent.parent.frames[2].frames[2].document.forms[0].volumeno)	
       
	  if(Rename=="OP" || Rename=="IP" )
	{
	if(parent.parent.frames[2].frames[2].document.forms[0].patientid.value=="")
		{  
	  removeitems(parent.parent.frames[2].frames[2].document.forms[0].fileno);
	  removeitems(parent.parent.frames[2].frames[2].document.forms[0].volumeno)
	  
	  }
	  if(parent.parent.frames[2].frames[2].document.forms[0].fileno.value=="")
		{
            removeitems(parent.parent.frames[2].frames[2].document.forms[0].volumeno)

		}
	  
	  }
	 
		  
		  if(Rename=="RE")
		{
		  
		 if(parent.frames[3].document.forms[0].patientid.value=="")
			{  
		    removeitems(parent.frames[3].document.forms[0].fileno)
		    removeitems(parent.frames[3].document.forms[0].volumeno)
			}
			
		 if(parent.frames[3].document.forms[0].fileno.value=="")
			{
     	   removeitems(parent.frames[3].document.forms[0].volumeno)
			}
		 //   var Opt    = parent.frames[3].document.createElement("OPTION");
		  //   Opt.text   = "---"+getLabel('Common.defaultSelect.label','common')+"---";
		//	parent.frames[3].document.forms[0].volumeno.add(Opt);
		}
	
	}
}
function chksearch_id() //Call search_id function if the description field is not empty
	{
		if(document.forms[0].requesting.value=="") {}
		else { 			
			if(document.forms[0].FS_LOCN_ID.value=="T")			{callPractSearch(document.forms[0].requesting_btn,document.forms[0].requesting);}
			else if((document.forms[0].FS_LOCN_ID.value=="C")||(document.forms[0].FS_LOCN_ID.value=="N")){
			search_id(document.forms[0].requesting_btn,document.forms[0].requesting); 
			}
			}
	}


	async function search_id(obj,target)//common lookup function
	{
				var retVal =    new String();               
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var facility_id = document.forms[0].p_facility_id.value;
				var sql = "";
                var tit="";	
				var code = document.forms[0].FS_LOCN_ID.value;
				var req_location = document.forms[0].fs_locn_code.value;
				if(code=="C")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.clinic.label","common");
				else if(code=="N")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.nursingUnit.label","common");
				else if(code=="Y")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+  getLabel("Common.DaycareUnit.label","common");
				else if(code=="E")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.ProcedureUnit.label","common");
				
				if (code=="T")
					callPractSearch(obj, target);
				else if(code=='C')
                sql="Select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and mr_location_code = '"+req_location+"' and eff_status='E' and CARE_LOCN_TYPE_IND='C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";				
				else if (code=='N')
				sql="Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where facility_id = '"+facility_id+"' and language_id='"+localeName+"' and fs_locn_code = '"+req_location+"' and eff_status='E' and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
				else if(code=='E')
                sql="Select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and mr_location_code = '"+req_location+"' and eff_status='E' and CARE_LOCN_TYPE_IND='E' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ";
				else if(code=='Y')
                sql="Select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and mr_location_code = '"+req_location+"' and  eff_status='E' and CARE_LOCN_TYPE_IND='D' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ";
				if (code!="T")
				{
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] =DESC_LINK  ;
				argumentArray[7] =DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );				
				if(retVal != null && retVal != "" )
                {					
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					document.forms[0].requesting.value=arr[1];					
					document.forms[0].requesting_code.value=arr[0];
				}
				else{
					document.forms[0].requesting.value="";					
					document.forms[0].requesting_code.value="";
				}
			}
	}
function PopulateIdentity(obj)
{
	document.forms[0].requesting.value			= "";
	document.forms[0].requesting_code.value	= "";
	if (obj.value.length>0)
	{
		var fs_locn_code =document.forms[0].FS_LOCN_ID.value;		
		//parent.frames[3].document.forms[0].logged_fcy.disabled=false;
		var storage_location =obj.value;
		var p_access_all =parent.frames[3].document.forms[0].p_access_all.value;			
		var p_access_all="*ALL";
		var flag="Report";
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMRequestFileLocnIdentity.jsp?storage_location="+storage_location+"&fs_locn_code="+fs_locn_code+"&Re_Flag="+flag+"&p_access_all="+p_access_all+"'></form></body></html>" ;
		parent.frames[4].document.write(HTMLVal) ;
		parent.frames[4].document.GetLocIdentity.submit() ;
	}
	else
	{
		parent.frames[3].document.forms[0].logged_fcy.disabled=true;
		   parent.frames[2].document.forms[0].requesting_btn.disabled=true;
	   parent.frames[2].document.forms[0].requesting.value="";
	//parent.frames[1].document.getElementById("location_identity").innerText='';
	}
}


async function searchCode(target,facilityid) {
		var retVal = 	new String();
		var dialogHeight= "85vh" ;
		var dialogWidth	= "65vw" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		
		tit=getLabel("Common.user.label","common");
		sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
		search_code="APPL_USER_ID";
		search_desc= "APPL_USER_NAME";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr=new Array();

		if (!(retVal == null)) {
			var retVal=unescape(retVal);
		    arr=retVal.split("::");

		    document.forms[0].req_name1.value=arr[0];
			document.forms[0].req_name.value=arr[1];
		}
		else
		{
			document.forms[0].req_name1.value="";
			document.forms[0].req_name.value="";
		}
	}

	function getExternalFiles(facility)
	{
		//doc_or_file = document.forms[0].doc_or_file.value;		
	//	var doc_or_file="F";
		//parent.searchResultFrame1.location.href="../../eFM/jsp/FMRequestFileSearch.jsp?external_facility="+facility+"&doc_or_file="+doc_or_file;
	}

	function log_ent_fcy(getVal)
	{
		var p_chosen_fcy = document.forms[0].logged_fcy.value;

		if (document.forms[0].logged_fcy.value =='L')
		{
			parent.frames[3].document.location.href='../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=N&selected_fcy='+getVal+'&p_chosen_fcy='+p_chosen_fcy;	
		}
		else if (document.forms[0].logged_fcy.value =='E')
		{			parent.frames[3].document.location.href='../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=Y&selected_fcy='+getVal+'&p_chosen_fcy='+p_chosen_fcy;
	
		}
	}

	function checkEncounter(obj){

	var HTMLVal = new String();		
	var enc_id=obj.value;
	var flag="Report_encdetails";
	if(enc_id=='')
	{
	//	var msg=getMessage("CAN_NOT_BE_BLANK","common");
		//msg=msg.replace('$',getLabel("Common.encounterid.label","common"));		
	//	alert(msg);
			
	}else
	{
		
	var patient_id=parent.parent.frames[2].frames[3].document.forms[0].patientid.value;
	
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMTransFileFromPopFSLocn.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='enc_id' id='enc_id' value='"+enc_id+"'><input type='hidden' name='flag' id='flag' value='"+flag+"'></form></BODY></HTML>";

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
		
	}
	

}

async function callSearchScreen(val){


	if(val=='E') {
		var retVal =    new String();
		var dialogHeight = "75vh" ;
		var dialogWidth  = "65vw" ;
		var dialogTop    = "190";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
		var arguments   = "" ;
	    var called_from="Report_encdetails";
	    var   patient_id =parent.parent.frames[2].frames[3].document.forms[0].patientid.value;
	    var   file_no =parent.parent.frames[2].frames[3].document.forms[0].fileno.value;
	    var   volume_no=parent.parent.frames[2].frames[3].document.forms[0].volumeno.value;	
		var file_type_yn=parent.parent.frames[2].frames[2].document.forms[0].file_type_yn.value;	
		retVal =await window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?called_from="+called_from+"&patient_id="+patient_id+"&file_no="+file_no+"&file_type_appl_yn="+file_type_yn+"&volume_no="+volume_no,arguments,features);

		
		if(retVal != null) {
			retVal = retVal.split("|");
			parent.parent.frames[2].frames[3].document.forms[0].encounter_id.value = retVal[0];
			parent.parent.frames[2].frames[2].document.forms[0].encounter_id.value=parent.parent.frames[2].frames[3].document.forms[0].encounter_id.value;
			parent.parent.frames[2].frames[3].document.forms[0].encounter_id.focus();
            
			
		}
	}
}

function validSplchars1(obj) {	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=getLabel("Common.encounterid.label","common");
	if(SpecialCharCheck( fields, names,'',"A",'')) {
		return true;
	} else {
		obj.select();
		obj.focus();
		return false;
	}
}

function CheckNumber(obj) {
    var strCheck = '0123456789';
  		if ( obj.value.length > 0 ) {
			for(var i=0;i<=obj.value.length;i++) {
				if (strCheck.indexOf(obj.value.charAt(i)) == -1){
					alert(getMessage("NUM_ALLOWED","SM"));
					obj.value="";
					obj.focus();
					return false;
					break;
				}
			}
  		}

}

function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}

