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

function onSuccess() 
 {
	f_query_add_mod.document.location.reload();

 }

/**************************************************************************/
function reset()  
  {

f_query_add_mod.location.reload();//Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623
f_query_add_mod.document.parameter_form.reset() ;
	

var obj=f_query_add_mod.document.parameter_form.visit_backdating_allowed_yn;

if(obj.checked){
		f_query_add_mod.document.forms.readOnly = false; 
		f_query_add_mod.document.parameter_form.backdating_gif.style.visibility='visible';
	}
	else{
		obj.readOnly = true;
		f_query_add_mod.document.parameter_form.backdating_gif.style.visibility='hidden';
		}


} 

function apply()
{
	f_query_add_mod.document.parameter_form.billing_interfaced_yn.disabled = false;
	f_query_add_mod.document.parameter_form.visit_backdating_allowed_yn.disabled = false;
	f_query_add_mod.document.parameter_form.max_hours_allow_insert.disabled = false;
    f_query_add_mod.document.parameter_form.max_days_allow_update.disabled = false;
	f_query_add_mod.document.parameter_form.min_age_for_preg_dtl.disabled = false;
	f_query_add_mod.document.parameter_form.max_age_for_paed_dtl.disabled = false;
	f_query_add_mod.document.parameter_form.min_age_for_lmp.disabled = false;
	if(f_query_add_mod.document.parameter_form.chk_for_pen_orders_bfr_chk.checked==true){
		if(f_query_add_mod.document.parameter_form.chk_allow.checked==true) 
			{
				
			f_query_add_mod.document.parameter_form.checkout_allow_yn.value="Y";
		}
		if(f_query_add_mod.document.parameter_form.chk_not_allow.checked==true)	{
			
				f_query_add_mod.document.parameter_form.checkout_allow_yn.value="N";
		}
	}else{
		
		f_query_add_mod.document.parameter_form.checkout_allow_yn.value='N';
	}
	
/*below line added for this CRF MMS-QH-CRF-0146 [IN:043836]*/
if(f_query_add_mod.document.parameter_form.five_level_triage_appl && f_query_add_mod.document.parameter_form.five_level_triage_appl.checked==true)f_query_add_mod.document.parameter_form.five_level_triage_appl_yn.value="Y";
	f_query_add_mod.document.parameter_form.cutoff_hours_prv_day_visit.disabled = false;

	var observation_wrd_type	=	 f_query_add_mod.document.parameter_form.observation_ward_type;
	var nursing_unit_desc	=	 f_query_add_mod.document.parameter_form.nursing_unit_desc;
	
	if(f_query_add_mod.document.parameter_form.visit_backdating_allowed_yn.value=="Y")
    {  
		if (observation_wrd_type.value!=""&&nursing_unit_desc.value=="")
	{ 
		 var fields = new Array (f_query_add_mod.document.parameter_form.max_hours_allow_insert,
		 f_query_add_mod.document.parameter_form.max_days_allow_update,
         f_query_add_mod.document.parameter_form.min_age_for_preg_dtl,
		 f_query_add_mod.document.parameter_form.max_age_for_paed_dtl,
		 f_query_add_mod.document.parameter_form.min_age_for_lmp,
		 f_query_add_mod.document.parameter_form.cutoff_hours_prv_day_visit,
		 // below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		  f_query_add_mod.document.parameter_form.re_attendace_hour,
         //end CRF  Bru-HIMS-CRF-152 [IN030272]
		 f_query_add_mod.document.parameter_form.queue_refresh_intervel,f_query_add_mod.document.parameter_form.nursing_unit_desc,f_query_add_mod.document.parameter_form.re_attendace_within_hour);
		 
		 //Above and below line modified for this CRF ML-MMOH-CRF-0639
		 
		var names = new Array (getLabel("eAE.AllowbackdatingofVisitDateTime.label","AE"),getLabel("eAE.MaxNoofdayallowedforrevattenddetls.label","AE"),getLabel("eAE.MinAgeofcapturingpediatric.label","AE"),getLabel("eAE.MaxAgeofcapturingpediatric.label","AE"),getLabel("eAE.MinAgeofcapturingLMP.label","AE"), getLabel("eAE.Cutoffperiodforincluding.label","AE"),getLabel("eAE.PromptMsgReAttnd.label","AE"),getLabel("Common.RefreshInterval.label","Common"),getLabel("eAE.ObservationWard.label","AE"),getLabel("eAE.DisplayAEattendanceregisteredwithinHrs.label","AE"));
	} else
		{
		var fields = new Array (f_query_add_mod.document.parameter_form.max_hours_allow_insert,
		 f_query_add_mod.document.parameter_form.max_days_allow_update,
         f_query_add_mod.document.parameter_form.min_age_for_preg_dtl,
		 f_query_add_mod.document.parameter_form.max_age_for_paed_dtl,
		 f_query_add_mod.document.parameter_form.min_age_for_lmp,
		 f_query_add_mod.document.parameter_form.cutoff_hours_prv_day_visit,
		 // below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		 f_query_add_mod.document.parameter_form.re_attendace_hour,
 //end CRF  Bru-HIMS-CRF-152 [IN030272]
 f_query_add_mod.document.parameter_form.queue_refresh_intervel,f_query_add_mod.document.parameter_form.re_attendace_within_hour);
       
	   /*Above and below line modified for this CRF ML-MMOH-CRF-0639*/
 
		var names = new Array (getLabel("eAE.AllowbackdatingofVisitDateTime.label","AE"),getLabel("eAE.MaxNoofdayallowedforrevattenddetls.label","AE"),getLabel("eAE.MinAgeofcapturingpediatric.label","AE"),getLabel("eAE.MaxAgeofcapturingpediatric.label","AE"),getLabel("eAE.MinAgeofcapturingLMP.label","AE"), getLabel("eAE.Cutoffperiodforincluding.label","AE"),getLabel("eAE.PromptMsgReAttnd.label","AE"),getLabel("Common.RefreshInterval.label","Common"),getLabel("eAE.DisplayAEattendanceregisteredwithinHrs.label","AE"));
	}
	}
    else
	{ 
	if (observation_wrd_type.value!=""&&nursing_unit_desc.value=="")
	{
		
		 var fields = new Array (f_query_add_mod.document.parameter_form.max_days_allow_update,
         f_query_add_mod.document.parameter_form.min_age_for_preg_dtl,
		 f_query_add_mod.document.parameter_form.max_age_for_paed_dtl,
         f_query_add_mod.document.parameter_form.min_age_for_lmp,
		 f_query_add_mod.document.parameter_form.cutoff_hours_prv_day_visit,
		// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		f_query_add_mod.document.parameter_form.re_attendace_hour,
		 //end CRF  Bru-HIMS-CRF-152 [IN030272]
		 f_query_add_mod.document.parameter_form.queue_refresh_intervel,f_query_add_mod.document.parameter_form.nursing_unit_desc,f_query_add_mod.document.parameter_form.re_attendace_within_hour);
		 
		 /*Above and below line modified for this CRF ML-MMOH-CRF-0639*/
		 
		var names = new Array (getLabel("eAE.MaxNoofdayallowedforrevattenddetls.label","AE"),getLabel("eAE.MinAgeofcapturingpediatric.label","AE"),getLabel("eAE.MaxAgeofcapturingpediatric.label","AE"),getLabel("eAE.MinAgeofcapturingLMP.label","AE"),		getLabel("eAE.Cutoffperiodforincluding.label","AE"),getLabel("eAE.PromptMsgReAttnd.label","AE"),getLabel("Common.RefreshInterval.label","Common"),getLabel("eAE.ObservationWard.label","AE"),getLabel("eAE.DisplayAEattendanceregisteredwithinHrs.label","AE"));	
	}
	else
		{
			
		var fields = new Array (f_query_add_mod.document.parameter_form.max_days_allow_update,
         f_query_add_mod.document.parameter_form.min_age_for_preg_dtl,
		 f_query_add_mod.document.parameter_form.max_age_for_paed_dtl,
         f_query_add_mod.document.parameter_form.min_age_for_lmp,
		 f_query_add_mod.document.parameter_form.cutoff_hours_prv_day_visit,
		 // below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		 f_query_add_mod.document.parameter_form.re_attendace_hour,
//end CRF  Bru-HIMS-CRF-152 [IN030272]
		 f_query_add_mod.document.parameter_form.queue_refresh_intervel,f_query_add_mod.document.parameter_form.re_attendace_within_hour);
		 
		 /*Above and below line modified for this CRF ML-MMOH-CRF-0639*/
		 
		var names = new Array (getLabel("eAE.MaxNoofdayallowedforrevattenddetls.label","AE"),getLabel("eAE.MinAgeofcapturingpediatric.label","AE"),getLabel("eAE.MaxAgeofcapturingpediatric.label","AE"),getLabel("eAE.MinAgeofcapturingLMP.label","AE"),		getLabel("eAE.Cutoffperiodforincluding.label","AE"),getLabel("eAE.PromptMsgReAttnd.label","AE"),getLabel("Common.RefreshInterval.label","Common"),getLabel("eAE.DisplayAEattendanceregisteredwithinHrs.label","AE"));	
	  }
	}
	/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
	if(f_query_add_mod.document.forms[0].back_date_cons_yn){
		
		if(f_query_add_mod.document.forms[0].back_date_cons_yn.checked == true){
			
			if(f_query_add_mod.document.forms[0].back_date_cons_hrs.value ==""){
				
				fields[fields.length]=f_query_add_mod.document.parameter_form.back_date_cons_hrs;			
				names[names.length]=getLabel("eAE.AllowbackdatingConsDateTime.label","AE");    
			}
		}
	}/*End*/
	
	/* for KDAH-CRF-0526 */ 
	if(f_query_add_mod.document.forms[0].isAERegisterTypeAutoUpdateAppl.value == 'true' ){	
	if(f_query_add_mod.document.forms[0].mand_reg_follow_up.style.visibility == 'visible' )
	{	
if( f_query_add_mod.document.forms[0].emerFollowSel.value =="" )
{
	
fields[fields.length]=f_query_add_mod.document.parameter_form.emerFollowSel;			
				names[names.length]=getLabel("Common.emergency.label","Common")+" "+getLabel("Common.followup.label","Common")+" "+getLabel("Common.type.label","Common");	
	
}}}
	
	/* for KDAH-CRF-0526 */
	
	
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
	
		//**********************NEWLY ADDED CONDITION *********************
		var caInstall = f_query_add_mod.document.parameter_form.caInstall.value;
		var orInstall = f_query_add_mod.document.parameter_form.orInstall.value;
		if (orInstall == 'Y'){
		var spo2 = f_query_add_mod.document.parameter_form.order_catalog_code1.value;
		var ecg = f_query_add_mod.document.parameter_form.order_catalog_code2.value;
		var fbc = f_query_add_mod.document.parameter_form.order_catalog_code3.value;
		var dressing = f_query_add_mod.document.parameter_form.order_catalog_code4.value;
		var bloodSugar = f_query_add_mod.document.parameter_form.order_catalog_code5.value;
		var cbd = f_query_add_mod.document.parameter_form.order_catalog_code6.value;//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651

		var respiratory  = "empty";
		var systolicBP = "empty";
		if (caInstall == 'Y')
		{
			
			respiratory = f_query_add_mod.document.parameter_form.respiratory.value;
			systolicBP = f_query_add_mod.document.parameter_form.systolicBP.value;
			systolicBP = (systolicBP == null|| systolicBP == "")?"empty":systolicBP;
			respiratory = (respiratory == null|| respiratory == "")?"empty":respiratory;
		}
    
		spo2 = (spo2 == null || spo2 == "")?"empty":spo2;
		ecg = (ecg == null || ecg == "")?"empty":ecg;
		fbc = (fbc == null || fbc == "")?"empty":fbc;
		dressing = (dressing == null|| dressing == "")?"empty":dressing;
		bloodSugar = (bloodSugar == null|| bloodSugar == "")?"empty":bloodSugar;
		cbd = (cbd == null|| cbd == "")?"empty":cbd;//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		
		//if(spo2 == "empty")
		//	f_query_add_mod.document.parameter_form.order_catalog_code1.value="";

		if (spo2 == "empty")
			f_query_add_mod.document.parameter_form.order_cat_code1.value="";
		if (ecg == "empty")
			f_query_add_mod.document.parameter_form.order_cat_code2.value="";
		if (fbc == "empty")
			f_query_add_mod.document.parameter_form.order_cat_code3.value="";
		if (dressing == "empty")
			f_query_add_mod.document.parameter_form.order_cat_code4.value="";
		if (bloodSugar == "empty")
			f_query_add_mod.document.parameter_form.order_cat_code5.value="";
		if (respiratory == "empty")
			f_query_add_mod.document.parameter_form.respiratoryhdd.value="";
		if (systolicBP == "empty")
			f_query_add_mod.document.parameter_form.systolicBPhdd.value="";
		if (cbd == "empty") f_query_add_mod.document.parameter_form.order_cat_code6.value="";//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		
		if (spo2 != "empty" || fbc != "empty" || bloodSugar != "empty" || ecg != "empty" || dressing != "empty" || systolicBP != "empty" || respiratory!= "empty" || cbd != "empty")//Modified by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		{
			 
			 checkForValidData(spo2,fbc,bloodSugar,ecg,dressing,systolicBP,respiratory,cbd);
			 
		}else
		{
			//Added by Sethu for the EDGE issue 65480 on 30/08/2024 
			parent.frames[2].frames[0].location.href='../../eCommon/jsp/process.jsp';	
			f_query_add_mod.document.parameter_form.order_catalog_code1.value="";
			f_query_add_mod.document.parameter_form.order_catalog_code2.value="";
			f_query_add_mod.document.parameter_form.submit();
		}
	   }
	   else
	   {	//Added by Sethu for the EDGE issue 65480 on 30/08/2024 
			parent.frames[2].frames[0].location.href='../../eCommon/jsp/process.jsp';
			f_query_add_mod.document.parameter_form.submit();
	   }
	}
} 

//************** CHECK FOR VALID DATA *********************
function checkForValidData(spo2,fbc,bloodSugar,ecg,dressing,systolicBP,respiratory,cbd)
{
	var spo2 = spo2;
	var fbc = fbc;
	var bloodSugar = bloodSugar;
	var ecg = ecg;
	var dressing = dressing;
	var systolicBP = systolicBP;
	var respiratory = respiratory;
	
	if (spo2 != "empty" || fbc != "empty" || bloodSugar != "empty" || ecg != "empty" || dressing != "empty" || systolicBP != "empty" || respiratory!= "empty" || cbd != "empty")//Modified by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
	{
	
	var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEParamValidations.jsp' method='post' ><input type='hidden' name='spo2' id='spo2' value='"+spo2+"'><input type='hidden' name='fbc' id='fbc' value='"+fbc+"'><input type='hidden' name='bloodSugar' id='bloodSugar' value='"+bloodSugar+"'><input type='hidden' name='ecg' id='ecg' value='"+ecg+"'><input type='hidden' name='dressing' id='dressing' value='"+dressing+"'><input type='hidden' name='systolicBP' id='systolicBP' value='"+systolicBP+"'><input type='hidden' name='respiratory' id='respiratory' value='"+respiratory+"'><input type='hidden' name='cbd' id='cbd' value='"+cbd+"'></form></body></html>";//Modified by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
	parent.frames[2].frames[0].location.href='../../eCommon/jsp/process.jsp';
	window.frames[2].document.write(HTMLValue);
	window.frames[2].dummy_form.submit();
	f_query_add_mod.document.parameter_form.submit();

	}
	else
	{
		parent.frames[2].frames[0].location.href='../../eCommon/jsp/process.jsp';
			f_query_add_mod.document.parameter_form.order_catalog_code1.value="";
			f_query_add_mod.document.parameter_form.order_catalog_code2.value="";
			f_query_add_mod.document.parameter_form.submit();

	}
}

//Check for individual field validation on onBlur()
function checkForValidData2(obj,target_name)
{
	var name = obj.name;
	var value = obj.value;
    
	value = (value == null || value == "")?"empty":value;
	
    if(value != "empty") {
		var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEParamValidations.jsp' method='post'><input type='hidden' name='dataName' id='dataName' value='"+name+"'><input type='hidden' name='dataValue' id='dataValue' value='"+value+"'></form></body></html>";
		parent.frames[2].frames[0].location.href='../../eCommon/jsp/process.jsp';
		parent.messageFrame.document.write(HTMLValue);
		parent.messageFrame.document.dummy_form.submit();
	}
	
}

	function checkRefreshRange(obj){
		if(obj.value!=''){
		var queue_refresh_intervel = document.forms[0].queue_refresh_intervel.value;
		if( obj.value == null || obj.value=="" ||eval(obj.value) < 5 || eval(obj.value) > 9999)  {		
				alert(getMessage('REFRESH_INTVL_CHK','AE'));
	 			obj.value=''
		  		obj.focus();
			}
		}
	}
function checkRangeMaxHours(obj)
{ 
   if(obj.value!='')
	{
	  if (obj.value==0)
	  {
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.select();
	  }
	  else if(obj.value < 1 || obj.value > 23)
	  {		
		    alert(getMessage("NO_OF_HRS_1_T0_23",'AE'));
	 	    obj.value=''
		  	obj.focus();
	  }
    }
}
// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
function checkRangeMaxHours1(obj)
{  
   if(obj.value!='')
	{
	  if (obj.value==0)
	  {
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.select();
	  }
	  
    }
   
	}
//end CRF  Bru-HIMS-CRF-152 [IN030272]

function checkRangeMaxRevise(obj)
{
	if(obj.value!='')
	{
	  if(obj.value < 1)
	  {
	    	alert(getMessage("MAX_DAYS_FOR_REV_VISIT","AE"));
		    obj.value='';
			obj.focus();
      }
    }
}

function checkRangeMaxCutoff(obj)
{
	if(obj.value!='')
	{
	  if (obj.value==0)
	  {
		  alert(getMessage('AE_NUMBER_ZERO','AE'));
		  obj.select();
	  }
    }
}

function checkRangeMinPreg(obj)
{
   if(obj.value!='')
	{
	  if(obj.value < 13	 )
	  {
			alert(getMessage("GYNAE_AGE_LIMIT",'AE'));
	 	    obj.value='';
  		    obj.focus();
	  }
    }
}

function checkRangeMaxPreg(obj)
{
   if(obj.value!='')
	{
	   if (obj.value==0)
	  {
		    
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.select();
	  }
	  else if(obj.value < 1 || obj.value > 15)
	  {
		  if(obj.name=="max_age_for_paed_dtl")
		  {
		    alert(getMessage("PAEDIATRIC_MAX_AGE",'AE'));
	     	obj.value='';
 	 	    obj.focus();
		  }
		  
	  }
	  else if(obj.name=="min_age_for_lmp")
		{
		   if(obj.value<=7)
			{
			   alert("Minimum age for capturing Lmp details should be greater than 7")
               obj.value='';
 	 	       obj.focus();
			}
        }
    }
}

function changeVal(obj)
{
	if(obj.checked==true){

		document.parameter_form.max_hours_allow_insert.readOnly = false;
		document.getElementById('backdating_gif').style.visibility='visible';
	}
	else
	{
		document.parameter_form.max_hours_allow_insert.readOnly = true;
		document.parameter_form.max_hours_allow_insert.value = '';
		document.getElementById('backdating_gif').style.visibility='hidden';
	}
}

function loadVisit(obj)
{
	if(obj.value=='Y'){
		document.forms.readOnly = false;
		document.getElementById('backdating_gif').style.visibility='visible';
	}
	else{
		obj.readOnly = true;
	document.getElementById('backdating_gif').style.visibility='hidden';
		}

}
async function callSearch(obj,target)
{
            var dialogHeight	= "55vh";
			var dialogWidth		= "65vw";
			var dialogTop		=	"55";
			var status			=	"no";
			var arguments		=	"" ;
			var order_category  =   "";
            if(obj.name=="ordercatalogcode1" || target.name=="order_catalog_code1")
	             {
                   order_category = "LB";
				   search_Text = target.value;
				 } 
            if(obj.name=="ordercatalogcode2" || target.name=="order_catalog_code2")
	             {
				 order_category = "RD";
				 search_Text = target.value;
				 }
			 if(obj.name=="ordercatalogcode3" || target.name=="order_catalog_code3")
	             {
				 order_category = "LB";
				 search_Text = target.value;
				 }
			 if(obj.name=="ordercatalogcode4" || target.name=="order_catalog_code4")
	             {
				 order_category = "NC";
				 search_Text = target.value;
				 }
			if(obj.name=="ordercatalogcode5" || target.name=="order_catalog_code5")
	             {
				 order_category = "LB";
				 search_Text = target.value;
				 }
			/*Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651 Start*/
			if(obj.name=="ordercatalogcode6" || target.name=="order_catalog_code6"){
               order_category = "TR";
			   search_Text = target.value;
			}/*End*/ 
			var action_url		=	"../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+encodeURIComponent(search_Text)+"&called_from=AM&order_category="
		    var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		
			retVal	=	await window.showModalDialog(action_url,arguments,features);
			if(retVal != null && retVal != "" )
                {
				var retVal=unescape(retVal);
				arr=retVal.split("&");
				target.value=arr[1];

				if(obj.name=="ordercatalogcode1" || target.name=="order_catalog_code1")
	             {
				  document.forms[0].order_cat_code1.value=arr[0];
				 }
				  if(obj.name=="ordercatalogcode2" || target.name=="order_catalog_code2")
	             {
				 document.forms[0].order_cat_code2.value=arr[0];
				 }
				 if(obj.name=="ordercatalogcode3" || target.name=="order_catalog_code3")
	             {
				 document.forms[0].order_cat_code3.value=arr[0];
				 }
				 if(obj.name=="ordercatalogcode4" || target.name=="order_catalog_code4")
	             {
				 document.forms[0].order_cat_code4.value=arr[0];
				 }
				 if(obj.name=="ordercatalogcode5" || target.name=="order_catalog_code5")
	             {
				 document.forms[0].order_cat_code5.value=arr[0];
				 }
				 /*Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				 if(obj.name=="ordercatalogcode6" || target.name=="order_catalog_code6"){
					 document.forms[0].order_cat_code6.value=arr[0];
				 }/*End*/
			}
			else 
	        {
				target.value="";
	             if(obj.name=="ordercatalogcode1" || target.name=="order_catalog_code1")
	             {
				  document.forms[0].order_cat_code1.value="";
				 }
				  if(obj.name=="ordercatalogcode2" || target.name=="order_catalog_code2")
	             {
				 document.forms[0].order_cat_code2.value="";
				 }
				 if(obj.name=="ordercatalogcode3" || target.name=="order_catalog_code3")
	             {
				 document.forms[0].order_cat_code3.value="";
				 }
				 if(obj.name=="ordercatalogcode4" || target.name=="order_catalog_code4")
	             {
				 document.forms[0].order_cat_code4.value="";
				 }
				 if(obj.name=="ordercatalogcode5" || target.name=="order_catalog_code5")
	             {
				 document.forms[0].order_cat_code5.value="";
				 }		
				 /*Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				 if(obj.name=="ordercatalogcode6" || target.name=="order_catalog_code6"){
					 document.forms[0].order_cat_code6.value="";
				 }/*End*/
	        }
        }
async function callSearchVital(obj,target)
{
                var retVal =    new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";	
				var sql1="";
                if(obj.name=="systolicBPbutt" || target.name=="systolicBP")
	             {
				
				 tit=getLabel("eAE.SystolicBP.label","AE");
				 sql1="select DISCR_MSR_ID code,SHORT_DESC  description from am_discr_msr   where eff_status='E' and upper(DISCR_MSR_ID) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2 ";
				}
				 if(obj.name=="respiratorybutt" || target.name=="respiratory")
	             {
			    tit=getLabel("eAE.Respiratory.label","AE");
			    sql1="select DISCR_MSR_ID code,SHORT_DESC  description from am_discr_msr    where eff_status='E' and upper(DISCR_MSR_ID) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2 ";
			
				 }
	        	argumentArray[0] =sql1;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK ;
				argumentArray[7] = DESC_CODE;
				retVal = await CommonLookup( tit,argumentArray);
				if(retVal != null && retVal != "" )
                {
					var retVal=unescape(retVal);
					arr=retVal.split(",");
					target.value=arr[1];

								
					 if(obj.name=="systolicBPbutt" || target.name=="systolicBP")
					 {
							document.forms[0].systolicBPhdd.value=arr[0];
					
			   
					 }
					 if(obj.name=="respiratorybutt" || target.name=="respiratory")
					 {
					
					 document.forms[0].respiratoryhdd.value=arr[0];
			
					 }
			}
			else
	      {
				  if(obj.name=="systolicBPbutt" || target.name=="systolicBP")
					 {
					document.forms[0].systolicBPhdd.value="";
			   
					 }
					 if(obj.name=="respiratorybutt" || target.name=="respiratory")
					 {
					
					 document.forms[0].respiratoryhdd.value="";
			
					 }
	               target.value="";
	       }

		  

}

function beforeCallSearch(obj,target_name)
{
	target_name.value = trimString(target_name.value);
		 if(target_name.value == "")
			{
			  document.forms[0].target_name.value="";
			 return;
			}

			callSearch(obj,target_name);
}

function beforeCallSearchVital(obj,target_name)
{
		target_name.value = trimString(target_name.value);
		 if(target_name.value == "")
			{
			 document.forms[0].target_name.value="";
			 return;
			}

			callSearchVital(obj,target_name);
}


function populateVisitType(obj)
{
         
		ClearList(document.forms[0].visit_type);
		//ClearList(document.forms[0].service_code);
		var location_code = obj.value;
		//Change done here.
		if (location_code == null || location_code ==  " " || location_code == "")
		{
			location_code = "null";
		}
		if(location_code == "null"){
        	parent.frames[1].document.forms[0].service_code.selectedIndex=0;
            parent.frames[1].document.forms[0].visit_type.selectedIndex=0;
		}else{
         
		 /*
		HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/DisasterRegistrationPopulate.jsp'><input type='hidden' name='process_id' id='process_id' value='"+obj.name+"'><input name='location_code' id='location_code' type='hidden' value='"+location_code+ "'></form></BODY></HTML>";
		
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();
		*/

		// below function impleted for incident no: 17933 date:Wednesday, January 06, 2010

					clear_list(document.forms[0].visit_type); 
					optSel	= document.createElement("OPTION");
					optSel.text = "---"+getLabel("Common.defaultSelect.label","common_labels")+"---";
					optSel.value= ''; 
					parent.frames[1].document.forms[0].visit_type.add(optSel);
					

					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var param="callfunc="+obj.name+"&location_code="+location_code
					var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var retVal=trimString(xmlHttp.responseText);
					

					if(retVal.length>1){

								var retVal_arr = retVal.split("~");
								for(var i=0;i<retVal_arr.length-1;i++){

								var code_desc_arr = retVal_arr[i].split("##");
								var element 	= parent.frames[1].document.createElement("OPTION");
								element.value 	= code_desc_arr[0];
								element.text 	= code_desc_arr[1] ;
								parent.frames[1].document.forms[0].visit_type.add(element);
							}
					}

		
		}

			
}
// below function impleted for incident no: 17933 date:Wednesday, January 06, 2010
function populateService(obj){

	ClearList(document.forms[0].service_code);
	var location_code = obj.value;
	if (location_code == null || location_code ==  " " || location_code == "")
		{
			location_code = "null";
		}
		if(location_code == "null"){
        	parent.frames[1].document.forms[0].service_code.selectedIndex=0;
            parent.frames[1].document.forms[0].visit_type.selectedIndex=0;
		}else{

			clear_list(document.forms[0].service_code); 

			optSel	= document.createElement("OPTION");
					optSel.text = "---"+getLabel("Common.defaultSelect.label","common_labels")+"---";
					optSel.value= ''; 
					parent.frames[1].document.forms[0].service_code.add(optSel);
					

					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var param="callfunc=serviceCode&location_code="+location_code
					var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var retVal=trimString(xmlHttp.responseText);
					

					if(retVal.length>1){

								var retVal_arr = retVal.split("~");
								for(var i=0;i<retVal_arr.length-1;i++){

								var code_desc_arr = retVal_arr[i].split("##");
								var element 	= parent.frames[1].document.createElement("OPTION");
								element.value 	= code_desc_arr[0];
								element.text 	= code_desc_arr[1] ;
								parent.frames[1].document.forms[0].service_code.add(element);
							}
					}


		}

}

function clear_list(obj){
  while(obj.options.length > 0){
   obj.remove(obj.options[0]);
 }
}  

function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

var element = parent.f_query_add_mod.document.createElement('OPTION');
	element.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
    element.value="";
   
        for(i=1;i<length;i++)
            object.remove(1);
 }


function call_observation_ward(obj){ 
  if(obj.value=='C' || obj.value=='N' || obj.value=='T')
	{
	   document.forms[0].nursing_unit_desc.value='';
	   document.forms[0].nursing_unit.value='';
		document.forms[0].nursing_unit_desc.disabled=false;
		document.forms[0].nursing_unit_lookup.disabled=false;
    	document.forms[0].mand_nursing.style.visibility="visible";

	}


	if (obj.value=='')
	{
		document.forms[0].nursing_unit.value='';
		document.forms[0].nursing_unit_desc.value='';
		document.forms[0].nursing_unit_desc.disabled=true;
		document.forms[0].nursing_unit_lookup.disabled=true;
		document.forms[0].mand_nursing.style.visibility="hidden";
	}
}



async function Lookup(target_id,target)
{ 
	var observation_ward_type=document.forms[0].observation_ward_type.value;
	var facility_id = document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    if((observation_ward_type =='C') || (observation_ward_type =='N'))
	{
	var title="";
    var argumentArray=new Array(8);
    if (observation_ward_type =='C')
	{
	  title="Clinic";			
	  argumentArray[0]= "select CLINIC_CODE code,SHORT_DESC description   from OP_CLINIC  where facility_id = '"+facility_id+"'  and LEVEL_OF_CARE_IND = 'E' and upper(CLINIC_CODE) like upper(nvl(?,CLINIC_CODE))  and upper(SHORT_DESC)  like upper(nvl(?,SHORT_DESC)) order by 2 ";
	 }
	else if(observation_ward_type =='N')
	{
			
		title="Nursing Unit";
		argumentArray[0]="select NURSING_UNIT_CODE code, NURSING_UNIT_SHORT_DESC description FROM IP_NURSING_UNIT_VW   WHERE  EFF_STATUS = 'E' AND FACILITY_ID = '"+facility_id+"' AND PATIENT_CLASS = 'IP'  and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(NURSING_UNIT_SHORT_DESC) like upper(nvl(?,NURSING_UNIT_SHORT_DESC)) order by 1";
	 }
	argumentArray[1]=new Array();
	argumentArray[2]=new Array();
	argumentArray[3]=new Array();
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
				
	var retVal=CommonLookup(title,argumentArray);
    if(retVal ==null || retVal=="" || !retVal)
	{
		target.value="";
		target_id.value="";
	}
	else
	{
		target_id.value=retVal[0];
		target.value=retVal[1];	
	}
    }else
	{
         if(observation_ward_type =='T'){
			var nursing_clinic_code=document.forms[0].nursing_clinic_code;
			var retVal;
			var dialogHeight= "40vh" ;
			var dialogWidth	= "50vw" ;
			var dialogTop = "143" ;
			var dialogLeft = "180" ;
			var center = "1" ;														   
			var status="no";
			var title="Treatment Area";
			var features	= "dialogLeft: "+ dialogLeft + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";dialogTitle :"+title;
			var arguments	= "" ;
			var url = "../../eAE/jsp/AETreatmentAreaMain.jsp?nursing_unit_desc="+document.forms[0].nursing_unit_desc.value+"&nursing_unit="+document.forms[0].nursing_unit.value;
 			retVal =await window.showModalDialog(url,arguments,features);
 			if(retVal!=null){
				var a = retVal.split("^");
			     target_id.value=a[0];
				 target.value=a[1];
				 nursing_clinic_code.value=a[2];
			
			
			}else{
				document.forms[0].nursing_unit_desc.value="";
				document.forms[0].nursing_unit.value="";
				document.forms[0].nursing_clinic_code.value="";
			}
 		   }
		   }
           }

   function beforeLookup(obj){

	  if(obj.value==null || obj.value==''){ 
       }else{
		Lookup(document.forms[0].nursing_unit,document.forms[0].nursing_unit_desc)
	}
    }


function checkdefaultRangeg(obj)
{
	var max_age =document.forms[0].max_age_for_paed_dtl.value;
   if(obj.value!='')
	{
	   if (obj.value==0)
	  {
		    
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.select();
	  }
	  else if(eval(obj.value)<=eval(max_age))
	  {
		    alert(getMessage("AE_PARAM_DEFAULT_AGE_VAL",'AE'));
	     	obj.value='';
 	 	    obj.focus();
		  	  
	  }
    }
}

/*Below line added for this CRF ML-MMOH-CRF-0639*/
function checkRangeMiniHours(obj)
{  
    
	 if(obj.name == 'ae_reg_update_val')
	 { 
		if(obj.value!='')
			{
				if (parseInt(obj.value)<=00)
			  {
					alert(getMessage('REG_FOLLOWUP_WITH_IN_HRS','AE'));
					obj.focus();
					obj.select();
			  } 
			  else
			  { 
				document.forms[0].emerFollowSel.disabled=false;  
				document.forms[0].mand_reg_follow_up.style.visibility='visible';  
				  
			  }
			}
			else
			{
				
				document.forms[0].mand_reg_follow_up.style.visibility='hidden';
			document.forms[0].emerFollowSel.options[0].selected=true;
				document.forms[0].emerFollowSel.disabled=true;
				
				
				
			}
		 
	 }
	 else
	 {
		if(obj.value!='')
		{
			  if (parseInt(obj.value)<24)
			  {
					alert(getMessage('RE_ATT_WITH_IN_HRS','AE'));
					obj.focus();
					obj.select();
			  }
		 }
	 
	  
    }
   
	}

//End ML-MMOH-CRF-0639

/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
function onCheckEnableDisableHrs(obj)
{
	if(obj.checked){
		obj.value="Y";				
		document.forms[0].back_date_cons_hrs.disabled = false;
		document.getElementById('cons_bkdatng_img').style.visibility='visible';
	}else{
		obj.value="N";
		document.forms[0].back_date_cons_hrs.value = "";
		document.forms[0].back_date_cons_hrs.disabled = true;
		document.getElementById('cons_bkdatng_img').style.visibility='hidden';
	}
}/*End*/

/*Added by Thamizh selvi against ML-MMOH-CRF-0651*/
function CheckForSpecChar(event){ 
    var strCheck = ' 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1) return false; 
	return true ;
}/*End*/


function fnChkPendingOrders() {
	if(document.forms[0].chk_for_pen_orders_bfr_chk.checked==true) { 
		document.forms[0].chk_not_allow.disabled=false;
		document.forms[0].chk_allow.disabled=false
		if (document.forms[0].chk_not_allow.checked==true){
			document.forms[0].chk_allow.checked=false;
		}
	}
	if(document.forms[0].chk_for_pen_orders_bfr_chk.checked==false) { 
		document.forms[0].chk_not_allow.disabled=true;
		document.forms[0].chk_allow.disabled=true;
		document.forms[0].chk_not_allow.checked=false;
		document.forms[0].chk_allow.checked=false;
	}
}	

function allowNotAllowChk(obj){
	if(obj.name=="chk_not_allow"){
		document.forms[0].chk_allow.checked=false;
	}
	if(obj.name=="chk_allow"){
		document.forms[0].chk_not_allow.checked=false;
	}
}

function enableValueChange()
{
	var enable_admission_tab=document.getElementById("enable_admission_tab").checked;
	if(enable_admission_tab)
	{
		document.getElementById("enable_admission_tab").value="Y"
	}	
	else
	{
		document.getElementById("enable_admission_tab").value="N";
	}
}

