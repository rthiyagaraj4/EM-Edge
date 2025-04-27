function chkValue(obj)
{
	if(obj.checked==true)
	{
		obj.checked=true;
		obj.value='Y';
	}
	else
	{
		obj.checked=false;
		obj.value='N';		 
	}
}


function chkBurValue(obj)
{
 
	if(obj.checked==true){
		obj.checked=true;
		obj.value='Y';
	 
	}else{
		obj.checked=false;
		obj.value='N';	 
		 
	}
}


function onSuccess() 
{
	f_query_add_mod.document.location.reload();
}

function reset() 
{
	f_query_add_mod.document.parameter_form.reset() ;
}

function apply()
{  
 	 var n2=f_query_add_mod.document.parameter_form.days_to_pres_unknown_body;

	 if (f_query_add_mod.document.parameter_form.or_install_yn.value=='Y')
	 {
		 //var fields = new Array (f_query_add_mod.document.parameter_form.days_to_pres_unknown_body,f_query_add_mod.document.parameter_form.department_code,f_query_add_mod.document.parameter_form.cut_off_prd_more_then_hrs,f_query_add_mod.document.parameter_form.cut_off_prd_less_then_hrs,f_query_add_mod.document.parameter_form.order_catalog_cl,f_query_add_mod.document.parameter_form.order_catalog_ml,f_query_add_mod.document.parameter_form.next_burial_permit_no1,f_query_add_mod.document.parameter_form.queue_refresh_interval);
	    
		 // var names = new Array (getLabel("eMO.NoOfDaysToPrsrvUnkwnBody.label","MO"),getLabel("Common.department.label","COMMON"),getLabel("eMO.Morethan.label","MO"),getLabel("Common.LessThan.label","COMMON"),getLabel("eMO.ClinicalPostmortem.label","MO"),getLabel("eMO.MedicolegalPostmortem.label","MO"),getLabel("eMO.NextBurialPermitNo.label","MO"),getLabel("Common.RefreshInterval.label","COMMON"));
		if(f_query_add_mod.document.parameter_form.datetimeOfClaimingAppl.value == "true" && f_query_add_mod.document.parameter_form.maxSizeBurialPermitAppl.value == "true"){
			
			//Added by Santhosh for ML-MMOH-CRF-1947
			var maxsizeburialpermitno	= f_query_add_mod.document.parameter_form.max_size_burial_permit_no.value;
			if(maxsizeburialpermitno == null || maxsizeburialpermitno =="0"){
				f_query_add_mod.document.parameter_form.max_size_burial_permit_no.value = "";
			}
			
			var fields = new Array (f_query_add_mod.document.parameter_form.days_to_pres_unknown_body,f_query_add_mod.document.parameter_form.department_code,f_query_add_mod.document.parameter_form.cut_off_prd_more_then_hrs,f_query_add_mod.document.parameter_form.cut_off_prd_less_then_hrs,f_query_add_mod.document.parameter_form.next_burial_permit_no1,f_query_add_mod.document.parameter_form.queue_refresh_interval,f_query_add_mod.document.parameter_form.max_size_burial_permit_no,f_query_add_mod.document.parameter_form.datetime_claim_mand);
		
			var names = new Array (getLabel("eMO.NoOfDaysToPrsrvUnkwnBody.label","MO"),getLabel("Common.department.label","COMMON"),getLabel("eMO.Morethan.label","MO"),getLabel("Common.LessThan.label","COMMON"),getLabel("eMO.NextBurialPermitNo.label","MO"),getLabel("Common.RefreshInterval.label","COMMON"),getLabel("eMO.MaxNumAndCharAllowedInBurialPermitNumber.label","MO"),getLabel("eMO.DateTimeOfClaimingMandatory.label","MO"));
		} else {
			var fields = new Array (f_query_add_mod.document.parameter_form.days_to_pres_unknown_body,f_query_add_mod.document.parameter_form.department_code,f_query_add_mod.document.parameter_form.cut_off_prd_more_then_hrs,f_query_add_mod.document.parameter_form.cut_off_prd_less_then_hrs,f_query_add_mod.document.parameter_form.next_burial_permit_no1,f_query_add_mod.document.parameter_form.queue_refresh_interval);
		
			var names = new Array (getLabel("eMO.NoOfDaysToPrsrvUnkwnBody.label","MO"),getLabel("Common.department.label","COMMON"),getLabel("eMO.Morethan.label","MO"),getLabel("Common.LessThan.label","COMMON"),getLabel("eMO.NextBurialPermitNo.label","MO"),getLabel("Common.RefreshInterval.label","COMMON"));
		}
				  
	 }
	 else
	 {
		 if(f_query_add_mod.document.parameter_form.datetimeOfClaimingAppl.value == true && f_query_add_mod.document.parameter_form.maxSizeBurialPermitAppl.value == true){
			 
			 //Added by Santhosh for ML-MMOH-CRF-1947
			var maxsizeburialpermitno	= f_query_add_mod.document.parameter_form.max_size_burial_permit_no.value;
			if(maxsizeburialpermitno == null || maxsizeburialpermitno =="0"){
				f_query_add_mod.document.parameter_form.max_size_burial_permit_no.value = "";
			}
			
			 var fields = new Array (f_query_add_mod.document.parameter_form.days_to_pres_unknown_body,f_query_add_mod.document.parameter_form.department_code,f_query_add_mod.document.parameter_form.cut_off_prd_more_then_hrs,f_query_add_mod.document.parameter_form.cut_off_prd_less_then_hrs,f_query_add_mod.document.parameter_form.next_burial_permit_no1,f_query_add_mod.document.parameter_form.queue_refresh_interval,f_query_add_mod.document.parameter_form.max_size_burial_permit_no,f_query_add_mod.document.parameter_form.datetime_claim_mand);

			var names = new Array (getLabel("eMO.NoOfDaysToPrsrvUnkwnBody.label","MO"),getLabel("Common.department.label","COMMON"),getLabel("eMO.Morethan.label","MO"),getLabel("Common.LessThan.label","COMMON"),getLabel("eMO.NextBurialPermitNo.label","MO"),getLabel("Common.RefreshInterval.label","COMMON"),getLabel("eMO.MaxNumCharAllowedInBurialPermitNumber.label","MO"),getLabel("eMO.DateTimeOfClaimingMandatory.label","MO"));
		 } else {
			 var fields = new Array (f_query_add_mod.document.parameter_form.days_to_pres_unknown_body,f_query_add_mod.document.parameter_form.department_code,f_query_add_mod.document.parameter_form.cut_off_prd_more_then_hrs,f_query_add_mod.document.parameter_form.cut_off_prd_less_then_hrs,f_query_add_mod.document.parameter_form.next_burial_permit_no1,f_query_add_mod.document.parameter_form.queue_refresh_interval);

			var names = new Array (getLabel("eMO.NoOfDaysToPrsrvUnkwnBody.label","MO"),getLabel("Common.department.label","COMMON"),getLabel("eMO.Morethan.label","MO"),getLabel("Common.LessThan.label","COMMON"),getLabel("eMO.NextBurialPermitNo.label","MO"),getLabel("Common.RefreshInterval.label","COMMON"));
		 }
	           
     }
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	 {
       if(eval(f_query_add_mod.document.parameter_form.cut_off_prd_more_then_hrs.value)<=eval(f_query_add_mod.document.parameter_form.cut_off_prd_less_then_hrs.value))
	   {
		    
		   if(f_query_add_mod.document.parameter_form.burial_permit_reqd_yn.checked == true)
			    f_query_add_mod.document.parameter_form.burial_permit_reqd_yn.value = "Y";
		   else 
			  f_query_add_mod.document.parameter_form.burial_permit_reqd_yn.value = "N";
	       f_query_add_mod.document.parameter_form.submit();
	   }else
	   {
	    alert(getMessage('CUTOFF_PERIOD_CHECK','MO'));
        messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num=' ;
	   }
	 }	
}

function OrderLookUp(obj,target)
{
	var dialogTop	= "56";
	var dialogHeight= "33" ;
	var dialogWidth = "50" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;			
	var searchtext = target.value;
	var retVal=window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+escape(searchtext)+"&called_from=MO",arguments,features);

	if(retVal != null && retVal != "" )
	{
		var valarr=retVal.split("&");
		if(target.name == "order_catalog_txt1"){
		document.forms[0].order_catalog_txt1.value=valarr[1];
		document.forms[0].order_catalog_cl.value=valarr[0];
		}else if(target.name == "order_catalog_txt2")
		{
		document.forms[0].order_catalog_txt2.value=valarr[1];
		document.forms[0].order_catalog_ml.value=valarr[0];
		}
	}
	else
	{
		if(target.name == "order_catalog_txt1"){
		document.forms[0].order_catalog_txt1.value="";
		document.forms[0].order_catalog_cl.value="";
		}else
		{
		document.forms[0].order_catalog_txt2.value="";
		document.forms[0].order_catalog_ml.value="";
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
function callsearch(obj,target)
{
		
	if(target.value == "")
	{
		if(target.name == "order_catalog_txt1")
		{
			document.forms[0].order_catalog_txt1.value="";
			document.forms[0].order_catalog_cl.value="";
			return;
		}else
		{
			document.forms[0].order_catalog_txt2.value="";
			document.forms[0].order_catalog_ml.value="";
			return;
		}
	}
	OrderLookUp(obj,target);
}

function checkRangeMax(obj)
{
	if (obj.name == "queue_refresh_interval") {
		var queue_refresh_interval = document.forms[0].queue_refresh_interval.value;
		if(obj.value == null || obj.value == "" || eval(obj.value) < 1 || eval(obj.value) > 9999)  {		
				alert(getMessage('REFRESH_INTERVAL_CHK','MO'));
	 			obj.value=''
		  		obj.focus();
			}
	}else{
		var next_burial_permit_no = document.forms[0].next_burial_permit_no.value;
		if(obj.value!='') {
			if(eval(obj.value) < 1 || eval(obj.value) < next_burial_permit_no)  {		
				alert(getMessage('BURIAL_PERMIT_NO_GT_ZERO','MO'));
	 			obj.value=''
		  		obj.focus();
			}
		}
	}

}
