 
function CheckForSpecCharsLocal(event){
var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/';
var whichCode = (window.Event) ? event.which : event.keyCode;
key = String.fromCharCode(whichCode);  // Get key value from key code
if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
return true ;
}

function ManageDeceasedView(tabidx)
{

	if(tabidx == 1)
    {parent.frames[2].document.getElementById("bprt").src='../../eMO/images/Body_Parts_Click.gif'
	 parent.frames[2].document.getElementById("mndec").src='../../eMO/images/Deceased_Patients.gif'
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
	 
    
	}
	else if(tabidx == 3)
	 { 	parent.frames[2].document.getElementById("bprt").src='../../eMO/images/Body_Parts.gif'
		parent.frames[2].document.getElementById("mndec").src='../../eMO/images/Deceased_Patients_Click.gif'
	    parent.frames[1].document.forms[0].queryExecute.value='bodypartqry'
		parent.frames[1].document.forms[0].registration_no.value="";
		parent.frames[1].document.forms[0].patient_id.value="";
		parent.frames[1].document.forms[0].burial_permit_no.value="";
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

function reset()
		{
			frames[1].document.location.reload();
			frames[2].document.location.reload();
			frames[3].location.href = '../../eCommon/html/blank.html';
			frames[1].document.forms[0].search.disabled=false;
		}
function cancelOperation()
	{
		parent.window.returnValue = "";
		parent.window.close();
	}
function submitPage()
	{	
		//var function_id=parent.document.forms[0].function_id.value;
		document.forms[0].search.disabled=true;
		var rno = document.forms[0].registration_no.value;
		var pid = document.forms[0].patient_id.value;
		var atype = document.forms[0].Area_Type.value;
		var area = document.forms[0].area_code.value;
		var pmstatus = document.forms[0].pm_status.value;
		var rstatus = document.forms[0].rel_status.value;
		
		var frmdate = document.forms[0].ot_date_time.value;
		var gender = document.forms[0].gender.value;
		var todate = document.forms[0].ot_date_time1.value;
		var parmeters = document.forms[0].parmeters.value;
	

	
		//alert('area_code-->'+area+':registration_no-->'+rno+':patient_id-->'+pid+':pmstatus-->'+pmstatus+':rstatus-->'+rstatus+':frmdate-->'+frmdate+':todate-->'+todate+':callfrommoreg-->'+document.forms[0].callfrommoreg.value+':gender-->'+gender+':burial_permit_no-->'+document.forms[0].burial_permit_no.value+':obt_frm-->'+document.forms[0].obt_frm.value)
	    var msg=getMessage('CAN_NOT_BE_BLANK','common');

        	

	if(frmdate=="")
	{
		msg=msg.replace('$',getLabel('Common.fromdate.label','common'));
		alert(msg);
		document.forms[0].ot_date_time.focus();
		document.forms[0].search.disabled=false;
	    parent.frames[3].location.href='../../eCommon/html/blank.html';

	return false 
	}
    if(todate=="")
	{
		msg=msg.replace('$',getLabel('Common.todate.label','common'));
		alert(msg);
		document.forms[0].ot_date_time1.focus();
		document.forms[0].search.disabled=false;
		parent.frames[3].location.href='../../eCommon/html/blank.html';

		return false 
	}
	
	if(document.forms[0].callfrommoreg.value=="callfrommanage" ||  document.forms[0].callfrommoreg.value=="releaseDeceased" || document.forms[0].callfrommoreg.value=="RevertRelease")
			{
				var queue_refresh_interval= queue_refresh_interval=document.forms[0].queue_refresh_interval.value;

				if(queue_refresh_interval =="")
				{
				msg=msg.replace('$',getLabel('Common.RefreshInterval.label','common'));
				alert(msg);
				document.forms[0].queue_refresh_interval.focus();
				document.forms[0].search.disabled=false;
			    parent.frames[3].location.href='../../eCommon/html/blank.html';
           
				return false 
				}


			}
		
		frmdate=convertDate(frmdate,'DMY',localeName,'en');
		todate=convertDate(todate,'DMY',localeName,'en');
	
	//if(doDateCheckMsg(document.forms[0].ot_date_time.value,document.forms[0].ot_date_time1.value,parent.messageFrame,'DMY')==true)
	if(isBefore(frmdate,todate,"DMY","en")) 
		{	
		if(document.forms[0].callfrommoreg.value=="callfrommoreg"||document.forms[0].callfrommoreg.value=="callfrommanage" || document.forms[0].callfrommoreg.value=="releaseDeceased" || document.forms[0].callfrommoreg.value=="ExpoOfDeceased" || document.forms[0].callfrommoreg.value=="RevertRelease" )
			{
		
		parent.frames[3].location.href= "../jsp/MOManageDeceasedSearchResult.jsp?"+parmeters+"&atype="+atype+"&area_code="+area	+"&registration_no="+rno+"&patient_id="+pid+"&pmstatus="+pmstatus+"&rstatus="+rstatus+"&frmdate="+frmdate+"&todate="+todate+"&callfrommoreg="+document.forms[0].callfrommoreg.value+"&gender="+gender+"&burial_permit_no="+document.forms[0].burial_permit_no.value+"&obt_frm="+document.forms[0].obt_frm.value;
		}else if(document.forms[0].callfrommoreg.value=="callfrombdyprt")
		{
			
		parent.frames[1].location.href= "../jsp/MOManageDeceasedSearchResult.jsp?"+parmeters+"&atype="+atype+"&area_code="+area	+"&registration_no="+rno+"&patient_id="+pid+"&pmstatus="+pmstatus+"&rstatus="+rstatus+"&frmdate="+frmdate+"&todate="+todate+"&callfrommoreg="+document.forms[0].callfrommoreg.value+"&gender="+gender+"&burial_permit_no="+document.forms[0].burial_permit_no.value+"&obt_frm="+document.forms[0].obt_frm.value;
		
		}else{
			
		parent.result.location.href= "../jsp/MORegnDtlsQueryResult.jsp?function_id=MO_REGN_DTLS_QUERY&atype="+atype+"&area="+area+"&rno="+rno+"&pid="+pid+"&pmstatus="+pmstatus+"&rstatus="+rstatus+"&frmdate="+frmdate+"&todate="+todate+"&gender="+gender+"&burial_permit_no="+document.forms[0].burial_permit_no.value+"&obt_frm="+document.forms[0].obt_frm.value;
		}
		}
		else
		{
			var msg=getMessage('FROM_DATE_LESS_EQ_TO_DATE','MO');
			alert(msg);
			document.forms[0].ot_date_time.focus();
			document.forms[0].search.disabled=false;
			return false;
		}
		
		
	
	}
function CheckForNumber3(val) {
 
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
           
            alert(getMessage("NUM_ALLOWED","SM"));
			val.focus();
            return false;
        }
}
  
function CheckDate(obj) {

    if (ChkDate(obj) == false) {
    //alert("APP-SM0011 - Invalid Date Format");
	alert(getMessage('INVALID_DATE_FMT','SM'));
	obj.select();
    obj.focus();
     return false;
    }
    else {
        return true;
    }
}

 function selarea(obj)
	{  
	    var areaval = document.forms[0].Area_Type.value;
		mode=document.forms[0].callfrommoreg.value;
		if(mode=='callfrombdyprt')
		{
		parent.parent.frames[0].document.forms[0].apply.disabled=true;
		HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form2' id='dum_form2' method='post' action='../../eMO/jsp/MOPopAreaAvail.jsp'><input type='hidden' name='areaval' id='areaval' value='"+areaval+"'><input type='hidden' name='status' id='status' value='R'><input type=hidden name=framsel value='fram1'><input type=hidden name=mode value='"+mode+"'></form></body></html>"; 
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		if(parent.frames[0].document.dum_form2)
			{
		parent.frames[0].document.dum_form2.submit();
			}
		}else
		{
		
		HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form3' id='dum_form3' method='post' action='../../eMO/jsp/MOPopAreaAvail.jsp'><input type='hidden' name='areaval' id='areaval' value='"+areaval+"'><input type='hidden' name='status' id='status' value='R'><input type=hidden name=mode value='"+mode+"'></form></body></html>";
		parent.messageFrame.document.write(HTMLVal);

		if(parent.frames[4].document.dum_form3)
			{
		parent.frames[4].document.dum_form3.submit();
			}
		
		}
		
	}

async function callPatient(target)
	{       var dialogHeight   = "28" ;
			var dialogWidth	   = "43" ;
			var status		   = "no";
			var arguments	   = "" ;
			var sql			   ="";
			var search_code	   ="";
			var search_desc    ="";
			var retVal         =    new String();
			var argumentArray  =new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit			   ="";				
			var facilityId	   = "";
			facilityId		   = document.forms[0].facility_id.value;
			callfrom=document.forms[0].callfrommoreg.value;
			
		
		    var fieldLegend = new Array() ;
		    fieldLegend["CODE_LEGEND"] = getLabel("Common.patientId.label","Common");
		    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
		  	if(callfrom=='releaseDeceased')
		    {
			if(document.forms[0].queryExecute.value=="deseasedqry")
			  {
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(NVL(patient_name,'*')) like upper(?) and area_type='R' and release_body_date is null and BURIAL_PERMIT_NO is not null and BODY_PART_OBTAINED_FROM is  null order by 2";
			}else
			{
			sql="select distinct patient_id code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(NVL(patient_name,'*')) like upper(?) and area_type='R' and release_body_date is null and BURIAL_PERMIT_NO is not null and BODY_PART_OBTAINED_FROM is not null order by 2";
			
			}
			}else if(callfrom=='ExpoOfDeceased')
		    {
			if(document.forms[0].queryExecute.value=="deseasedqry")
			  {
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(NVL(patient_name,'*')) like upper(?)   AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y' and BODY_PART_OBTAINED_FROM is  null order by 2";
			}else
			{
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(NVL(patient_name,'*')) like upper(?)   AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y'  and BODY_PART_OBTAINED_FROM is not null order by 2";
			
			}
			}
			else if(callfrom=='callfrombdyprt') 
		    {
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is not null order by 2";
			}else if(callfrom=='callfrommoreg')
		    {
			
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  null order by 2";
			
			}
		  else if(callfrom=='callfrommanage')
		  {if(document.forms[0].queryExecute.value=="deseasedqry")
			  {
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  null  order by 2";
			  }else
			  {
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is not null  order by 2";
			
			  }
		 
		 }else
		{
		   if(document.forms[0].queryExecute.value=="deseasedqry")
			  {

			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) and BODY_PART_OBTAINED_FROM is  null  order by 2";
			  }else
			{
			
			sql="select distinct patient_id code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) and BODY_PART_OBTAINED_FROM is not null   order by 2";
			
			}
		}
			tit=getLabel("eMO.RegistrationDtls.label","MO");
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				argumentArray[8] = fieldLegend;
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr	=ret1.split(",");
			
				document.forms[0].patient_id.value= arr[0];
				
		}
		else
		{	
			document.forms[0].patient_id.value= "";
		}


		
		
				
	}

	
	
async	function searchCode1(obj,target)
	{
			var dialogHeight   = "28" ;
			var dialogWidth	   = "43" ;
			var status		   = "no";
			var arguments	   = "" ;
			var sql			   ="";
			var search_code	   ="";
			var search_desc    ="";
			var retVal         =    new String();
			var argumentArray  =new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit			   ="";				
			var facilityId	   = "";
			facilityId		   = document.forms[0].facility_id.value;
			callfrom=document.forms[0].callfrommoreg.value;
			var fieldLegend = new Array() ;
		    fieldLegend["CODE_LEGEND"] = getLabel("eMO.BurialPermitNumber.label","MO"); 
		    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");

			
			if(callfrom=='releaseDeceased')
		    {
			if(document.forms[0].queryExecute.value=="deseasedqry")
			  {
			tit=getLabel("eMO.BurialPermitNo.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(NVL(patient_name,'*')) like upper(?) and area_type='R' and release_body_date is null and BURIAL_PERMIT_NO is not null and BODY_PART_OBTAINED_FROM is  null order by 2";
			}else
			{
			tit=getLabel("eMO.BurialPermitNo.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(NVL(patient_name,'*')) like upper(?) and area_type='R' and release_body_date is null and BURIAL_PERMIT_NO is not null and BODY_PART_OBTAINED_FROM is not null order by 2";
			
			}
			}else if(callfrom=='ExpoOfDeceased')
		    {
			if(document.forms[0].queryExecute.value=="deseasedqry")
			  {
			tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(NVL(patient_name,'*')) like upper(?)   AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y' and BODY_PART_OBTAINED_FROM is  null order by 2";
			 }else
			{
			tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(NVL(patient_name,'*')) like upper(?)   AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y'  and BODY_PART_OBTAINED_FROM is not null order by 2";
			
			}
			}
			else if(callfrom=='callfrombdyprt')
		    {
			tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is not null order by 2";
			}else if(callfrom=='callfrommoreg')
		    {
			tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  null order by 2";
			}else if(callfrom=='callfrommanage')
		  {if(document.forms[0].queryExecute.value=="deseasedqry")
			  {
		    tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select  BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  null   order by 2";
			  }else
			  {
			 tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select  BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  not null   order by 2";
			  }
		 }			
			else
		   {
		   if(document.forms[0].queryExecute.value=="deseasedqry")
			  {

			tit=getLabel("eMO.RegistrationDtls.label","MO");
			sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) and BODY_PART_OBTAINED_FROM is   null  order by 2";
			 }else
			 {
			 tit=getLabel("eMO.RegistrationDtls.label","MO");
			 sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) and BODY_PART_OBTAINED_FROM is  not null  order by 2";
			
			  }
		 }
	
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				argumentArray[8] = fieldLegend;
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr	=ret1.split(",");
			
			if(target.name == 'burial_permit_no')
			{
			document.forms[0].burial_permit_no.value= arr[0];
			}
				
		}
		else
		{	
			document.forms[0].registration_no.value= "";
		}
	}
	
	
async function searchCode(obj,target)
	{
			var dialogHeight   = "28" ;
			var dialogWidth	   = "43" ;
			var status		   = "no";
			var arguments	   = "" ;
			var sql			   ="";
			var search_code	   ="";
			var search_desc    ="";
			var retVal         =    new String();
			var argumentArray  =new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit			   ="";				
			var facilityId	   = "";
			facilityId		   = document.forms[0].facility_id.value;
			callfrom=document.forms[0].callfrommoreg.value;
			var fieldLegend = new Array() ;
		    fieldLegend["CODE_LEGEND"] = getLabel("Common.registrationno.label","Common");
		    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");

			
			if(callfrom=='releaseDeceased')
		    {
			if(document.forms[0].queryExecute.value=="deseasedqry")
			 {
	
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(NVL(patient_name,'*')) like upper(?) and area_type='R' and release_body_date is null and BURIAL_PERMIT_NO is not null and BODY_PART_OBTAINED_FROM is  null order by 2";
			 }else
			{
		
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(NVL(patient_name,'*')) like upper(?) and area_type='R' and release_body_date is null and BURIAL_PERMIT_NO is not null and BODY_PART_OBTAINED_FROM is not null order by 2";
			}
			}else if(callfrom=='ExpoOfDeceased')
		    {if(document.forms[0].queryExecute.value=="deseasedqry")
			 {
		
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(NVL(patient_name,'*')) like upper(?)   AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y' and BODY_PART_OBTAINED_FROM is  null order by 2";
			 }else
			{
			
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(NVL(patient_name,'*')) like upper(?)   AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y' and BODY_PART_OBTAINED_FROM is not null order by 2";
				
			}
			}
			else if(callfrom=='callfrombdyprt')
		    {
			
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is not null order by 2";
			}else if(callfrom=='callfrommoreg')
		    {
			
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  null order by 2";
			}else if(callfrom=='callfrommanage')
		  {
		    if(document.forms[0].queryExecute.value=="deseasedqry")
			 {
		
			sql="select  registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null and BODY_PART_OBTAINED_FROM is  null order by 2";
			 }else
			 {
			
			sql="select  registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) and release_body_date is null  and BODY_PART_OBTAINED_FROM is  not null order by 2";
			
			 }
		 }			
			else
		   {
		   if(document.forms[0].queryExecute.value=="deseasedqry")
			  {

			
			
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?)   and BODY_PART_OBTAINED_FROM is   null order by 2";
			  }else
			   {
			
			sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?)   and BODY_PART_OBTAINED_FROM is  not null  order by 2";
			
			   }
		 }
	
	tit=getLabel("eMO.RegistrationDtls.label","MO");
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				argumentArray[8] = fieldLegend;
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr	=ret1.split(",");
			if(target.name == 'registration_no')
				document.forms[0].registration_no.value= arr[0];
				
		}
		else
		{	
			document.forms[0].registration_no.value= "";
		}
	}
	function clearAll()
	{ 
	if(parent.frames[1].document.forms[0].search!=null)
		{
		parent.frames[1].document.forms[0].search.disabled=false;
	  parent.frames[3].location.href='../../eCommon/html/blank.html';
		}else
		{
		parent.frames[0].document.forms[0].search.disabled=false;
		parent.frames[0].document.location.reload();
	    parent.frames[1].location.href='../../eCommon/html/blank.html';
		}
	}
 
	function enableVal(obj)
	{
		if (obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}

	function ChangeToUpper(obj)
	{
		obj.value = obj.value.toUpperCase();
	}


async function showAllowedOperations1(obj,obj1,obj2,bdtprtyn)
{
	
var functionid=parent.document.forms[0].function_id.value;

	var retVal = "";
	var retVal0 = "";
	var retVal1 = "";
	var sucfai = "";
	retVal = obj1;
	retVal0 = obj;
	retVal1 = obj2;
			var dialogHeight	=	"1000px"; 
			var dialogWidth		=	"1200px"; 
			var dialogTop		=	"110";
			var status			=	"no";
			var arguments		=	"" ;
			

 if(bdtprtyn=='Y')
	{
	//Below line modified for this CRF ML-MMOH-CRF-0695
   parameter="menu_id=MO_MENU&module_id=MO&functionid="+functionid+"&function_id=MO_BODY_PART_REGN&function_name=Body%20Part%20Registration&function_type=F&access=YYYNN&function_id1=Reg_Details" 
   var action_url		=	"../../eMO/jsp/MORegisterBodyPart.jsp?functionid="+functionid+"&registration_no="+retVal1+"&mode=viewdata&patientID="+obj1;  
  var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:yes; dialogTop:"+dialogTop+";";
  sucfai	=	await top.window.showModalDialog(action_url,arguments,features);
 
  }
	else{
  //Below line modified for this CRF ML-MMOH-CRF-0695
  parameter="menu_id=MO_MENU&module_id=MO&functionid="+functionid+"&function_id=MO_Reg_Details&function_name=Registration Details&function_type=F&access=NNNNN&function_id1=Reg_Details" 

  var action_url		=	"../../eMO/jsp/MORegisterDeceased.jsp?functionid="+functionid+"&patientID="+retVal+"&mode=viewdata" ;  
  var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:yes; dialogTop:"+dialogTop+";";
  sucfai	=	await top.window.showModalDialog(action_url,arguments,features);
  if(sucfai!=null)
  {
	if(sucfai=="Success")
	{
		parent.MOAreaAvailabilityQueryResult_form.location.reload();
	}
}
	}
}

	function callSamepage()
        {              	
		
		   parent.frames[1].document.forms[0].search.disabled=true;
		var rno = parent.frames[1].document.forms[0].registration_no.value;
		var pid = parent.frames[1].document.forms[0].patient_id.value;
		var atype = parent.frames[1].document.forms[0].Area_Type.value;
		var area = parent.frames[1].document.forms[0].area_code.value;

		var pmstatus = parent.frames[1].document.forms[0].pm_status.value;

		var rstatus = parent.frames[1].document.forms[0].rel_status.value;
		
		var frmdate = parent.frames[1].document.forms[0].ot_date_time.value;
		var gender = parent.frames[1].document.forms[0].gender.value;
		var todate = parent.frames[1].document.forms[0].ot_date_time1.value;
		var parmeters = parent.frames[1].document.forms[0].parmeters.value;

		 var msg=getMessage('CAN_NOT_BE_BLANK','common');

        	

	if(frmdate=="")
	{
		msg=msg.replace('$',getLabel('Common.fromdate.label','common'));
		alert(msg);
		parent.frames[1].document.forms[0].ot_date_time.focus();
		parent.frames[1].document.forms[0].search.disabled=false;
	    parent.frames[3].location.href='../../eCommon/html/blank.html';

	return false 
	}
    if(todate=="")
	{
		msg=msg.replace('$',getLabel('Common.todate.label','common'));
		alert(msg);
		parent.frames[1].document.forms[0].ot_date_time1.focus();
		parent.frames[1].document.forms[0].search.disabled=false;
		parent.frames[3].location.href='../../eCommon/html/blank.html';

		return false 
	}
		

		
		frmdate=convertDate(frmdate,'DMY',localeName,'en');
		todate=convertDate(todate,'DMY',localeName,'en');
		
			parent.frames[3].location.href= "../../eMO/jsp/MOManageDeceasedSearchResult.jsp?"+parmeters+"&atype="+atype+"&area_code="+area	+"&registration_no="+rno+"&patient_id="+pid+"&pmstatus="+pmstatus+"&rstatus="+rstatus+"&frmdate="+frmdate+"&todate="+todate+"&callfrommoreg="+parent.frames[1].document.forms[0].callfrommoreg.value+"&gender="+gender+"&burial_permit_no="+parent.frames[1].document.forms[0].burial_permit_no.value+"&obt_frm="+parent.frames[1].document.forms[0].obt_frm.value; 
			
  }
  function chkNumval(obj){
	  var queue_refresh_interval = parent.frames[1].document.forms[0].queue_refresh_interval1.value;

	  if(obj.value!= ""){
		  if(Number(obj.value) > Number(queue_refresh_interval)){
			   alert(getMessage("USER_CANT_EXCEEDS_PARAM", "MO"));
			  
   				obj.value= "";
				 obj.focus();
			   return false;
		  }
		  }
  }

  function ChkPosNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
            obj.select();
            obj.focus();
			return false;
        }
    }
}

function checkRangeMax(obj)
{
	if (obj.name == "queue_refresh_interval") {
		var queue_refresh_interval = parent.frames[1].document.forms[0].queue_refresh_interval.value;
		if(obj.value == null || obj.value == "" || eval(obj.value) < 1 || eval(obj.value) > 9999)  {		
				alert(getMessage('REFRESH_INTERVAL_CHK','MO'));
	 			obj.value=''
		  		obj.focus();
			}
	}

}


async function RevertRelease(reg_no){	

    //Below line added for this ML-MMOH-CRF-0860.2
	var increasedLength="";
    if(document.forms[0].increasedaddressLength){ 
	increasedaddressLength=document.forms[0].increasedaddressLength.value;	
	}
	//End ML-MMOH-CRF-0860.2
 
	var retVal			= "";
	//Modified by Thamizh selvi on 25th Sep 2017 against incident [65326] 
	//var dialogHeight	= "36"; 
	//var dialogWidth		= "53"; 
	var dialogHeight	= "90vh"; 
	var dialogWidth		= "80vw";
	
	//Below line added for this ML-MMOH-CRF-0860.2
	if(increasedaddressLength=="true"){
	    dialogHeight	= "90vh"; 
		dialogWidth		= "80vw";
	}
	//End ML-MMOH-CRF-0860.2
	
	
	var dialogTop		= "50";
	var status			= "no";
	var arguments		= "";
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status + ";";
	var function_id = "";
	var action_url	=	"../../eMO/jsp/MORevertReleasedSearchFrameset.jsp?function_id="+function_id+"&param="+reg_no+"&first=N";

	retVal	= await window.showModalDialog(action_url,arguments,features);
	if(retVal==""){
	  parent.frames[3].location.reload();
	}
	
}



