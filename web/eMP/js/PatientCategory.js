function show() {
   //	parent.parent.window.document.title = "Setup Patient Category" ;
}

function create() {
	//f_query_add_mod.location.href = "../../eMP/html/addPatientCategory.html" ;
	f_query_add_mod.location.href = "../../eMP/jsp/AddPatientCategory.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/PatientCategoryQueryPage.jsp?function=patientcategory" ;
}

/*function query() {
	f_query_add_mod.location.href ="../jsp/qPatientCategory.jsp?function=patientcategory" ;
}
*/

function apply() {

	var url = f_query_add_mod.location.href;
	if ( (url.indexOf("PatientCategoryQueryPage") !=-1 ) || (url.indexOf("queryPatientCategory") !=-1 ) )
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var job_type = f_query_add_mod.document.patient_cat_form.job_type1.value ;

	if ( job_type == "G" || job_type == "Government")
		f_query_add_mod.document.patient_cat_form.job_type.value = "G" ;
	if ( job_type == "P" || job_type == "Private")
		f_query_add_mod.document.patient_cat_form.job_type.value = "P" ;
	if ( job_type == "K" || job_type == "Others")
		f_query_add_mod.document.patient_cat_form.job_type.value = "K" ;
	if ( job_type == "U" || job_type == "Un-Employed")
		f_query_add_mod.document.patient_cat_form.job_type.value = "U" ;
	if ( job_type == "S" || job_type == "Semi-Government")
		f_query_add_mod.document.patient_cat_form.job_type.value = "S" ;

	if ( job_type == "D" || job_type == "Designated Royalties")
		f_query_add_mod.document.patient_cat_form.job_type.value = "D" ;
	if ( job_type == "W" || job_type == "Estate Workers")
		f_query_add_mod.document.patient_cat_form.job_type.value = "W" ;
	if ( job_type == "F" || job_type == "Foreigner")
		f_query_add_mod.document.patient_cat_form.job_type.value = "F" ;
	if ( job_type == "R" || job_type == "Pensioner")
		f_query_add_mod.document.patient_cat_form.job_type.value = "R" ;
	if ( job_type == "C" || job_type == "Person Under Police Custody")
		f_query_add_mod.document.patient_cat_form.job_type.value = "C" ;

	if ( job_type == "I" || job_type == "Prisoners")
		f_query_add_mod.document.patient_cat_form.job_type.value = "I" ;
	if ( job_type == "B" || job_type == "Registered Disabled")
		f_query_add_mod.document.patient_cat_form.job_type.value = "B" ;
	if ( job_type == "E" || job_type == "Self-Employed")
		f_query_add_mod.document.patient_cat_form.job_type.value = "E" ;
	if ( job_type == "T" || job_type == "Student")
		f_query_add_mod.document.patient_cat_form.job_type.value = "T" ;
	if ( job_type == "V" || job_type == "VIP")
		f_query_add_mod.document.patient_cat_form.job_type.value = "V" ;

	var UnknownCount = f_query_add_mod.document.patient_cat_form.UnknownCategory.value;
	var DBType=f_query_add_mod.document.patient_cat_form.DBType.value;

	//if( job_type == "K" || job_type == "Unknown")
		//if((UnknownCount != "0") || (UnknownCount > 0))
			


    if(f_query_add_mod.document.patient_cat_form.expiry_appl.value=='Y'){
	var fields = new Array ( f_query_add_mod.document.patient_cat_form.patient_cat_code,
				 f_query_add_mod.document.patient_cat_form.long_desc,
				 f_query_add_mod.document.patient_cat_form.short_desc,
				 f_query_add_mod.document.patient_cat_form.job_type,
		         f_query_add_mod.document.patient_cat_form.expiry_period 
			       );

	var names  = new Array ( f_query_add_mod.getLabel('Common.code.label','common'),
	                         f_query_add_mod.getLabel('Common.longdescription.label','common'),
				 f_query_add_mod.getLabel('Common.shortdescription.label','common'),
				 f_query_add_mod.getLabel('Common.type.label','common') ,f_query_add_mod.getLabel('Common.ExpiryPeriod.label','common')+ " "+ f_query_add_mod.getLabel('Common.days.label','common')
			       );
	}
	else{
		var fields = new Array ( f_query_add_mod.document.patient_cat_form.patient_cat_code,
				 f_query_add_mod.document.patient_cat_form.long_desc,
				 f_query_add_mod.document.patient_cat_form.short_desc,
				 f_query_add_mod.document.patient_cat_form.job_type
                 
			       );

	var names  = new Array ( f_query_add_mod.getLabel('Common.code.label','common'),
	                         f_query_add_mod.getLabel('Common.longdescription.label','common'),
				 f_query_add_mod.getLabel('Common.shortdescription.label','common'),
				 f_query_add_mod.getLabel('Common.type.label','common')
			       );

	}
	var transform = new Array ( f_query_add_mod.document.patient_cat_form,
				    f_query_add_mod.document.patient_cat_form.eff_date_from,
				    f_query_add_mod.document.patient_cat_form.eff_date_from1,
				    f_query_add_mod.document.patient_cat_form.eff_date_to,
				    f_query_add_mod.document.patient_cat_form.eff_date_to1
				  );

	var splField = new Array (f_query_add_mod.document.patient_cat_form.patient_cat_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{
			f_query_add_mod.document.patient_cat_form.expiry_appl.disabled=false;
			f_query_add_mod.document.patient_cat_form.expiry_period.disabled=false;
			var val=eval("f_query_add_mod.document.patient_cat_form.expiry_appl").value;

			if (val=='Y')
			{  
				var period=eval("f_query_add_mod.document.patient_cat_form.expiry_period").value;
				if (period=="")
				{
					//alert("APP-MP0022 Expiry Period Cannot be blank...");
					var errmsg =getMessage('CAN_NOT_BE_BLANK','Common');
					errmsg= errmsg.replace('$',f_query_add_mod.getLabel('Common.ExpiryPeriod.label','common'));
					alert(errmsg);
					f_query_add_mod.document.patient_cat_form.expiry_period.focus();
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
				 return false;
				}
							 
			}
			            
			var catCode=f_query_add_mod.document.patient_cat_form.patient_cat_code.value;

			f_query_add_mod.document.patient_cat_form.submit();
			
			/* The following block has been commented on 15th oct 2005 By Sen as the check for more than one unknown/others is not required*/
			/*
 			if(((catCode != UnknownCount)&& (job_type != DBType) && ((job_type !="K") ||(job_type !="Unknown"))) ||
				((catCode == UnknownCount) && ((job_type =="K") || (job_type =="Unknown") || (job_type != DBType))))
			
			{
					if(f_query_add_mod.DateTransform(transform,messageFrame)) 
					{
					var fn_status = f_query_add_mod.document.patient_cat_form.function_name.value ;
						//		  if(fn_status == "insert") {
						//		f_query_add_mod.document.patient_cat_form.reset();
						// }
					}
			 }
			else
			{
				  
 				  var errorMsg =getMessage("ONLY_ONE_UNKNOWN_CAT","MP");
				  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0";
			}*/
			/*Commented code of 15/10/2005 ends */ 
		}
	}
}

function reset() {
	
		var url=f_query_add_mod.location.href
		if(url.indexOf("queryPatientCategory.jsp")==-1)
	f_query_add_mod.location.reload() ;
/*		if(f_query_add_mod.document.forms[0].name == "patient_cat_form")
		   f_query_add_mod.document.patient_cat_form.reset() ;
		else
//		   f_query_add_mod.document.query_form.reset() ;
		   f_query_add_mod.location.href ="../../eMP/jsp/PatientCategoryQueryPage.jsp?function=patientcategory" ;*/
}

function onSuccess() {
	f_query_add_mod.location.reload() ;
}

function mandate(obj)
{
	

	if((obj.checked)==true)
		eval("document.patient_cat_form.expiry_appl").value='Y';
	else
		eval("document.patient_cat_form.expiry_appl").value='N';

	if(document.patient_cat_form.expiry_appl.value=='Y')
	{
        document.patient_cat_form.expiry_period.disabled=false;
        document.patient_cat_form.expiry.style.visibility="visible";
	}
	else
	{
		document.patient_cat_form.expiry_period.disabled=true;
	    document.patient_cat_form.expiry.style.visibility="hidden";
		document.patient_cat_form.expiry_period.value="";
	}


}
function hide()
{
	
//document.patient_cat_form.expiry.style.visibility="hidden";
}
function allowPositiveNumber() 
	{
		var key = window.event.keyCode;
		
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
	}

	function chkdays(obj)
	{
		
        if(MPCheckNumber(obj)){
		if(eval(obj.value)<=0){
			//alert("APP-MP0023 Expiry Period (Days) should be Greater than Zero");
			alert(getMessage("EXP_DT_SHD_GR_ZR","MP"));
			obj.focus();
			obj.select();
				return false
		}
			else 
				return true
		}
	}
function MPCheckNumber(obj) {
   var sequence = "1234567890";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){

			//alert("APP-MP0023 Expiry Period (Days) should be Greater than Zero");
			alert(getMessage("EXP_DT_SHD_GR_ZR","MP"));
			obj.focus();
			obj.select();
			return false;
		}
   }

   return true ;
}
