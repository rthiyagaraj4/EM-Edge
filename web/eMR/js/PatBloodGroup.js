function query() {
	f_query_add_mod.location.href ="../../eMR/jsp/mrblank.jsp?step_1=5";
}

function clearform()
{
 //Added by Manish Anand on 15-07-2002
 //f_query_add_mod.document.forms[0].reset();
 
 if(f_query_add_mod.document.PatBloodGroup_form.blood_group.disabled==false)
	 f_query_add_mod.document.PatBloodGroup_form.blood_group.value = "";

 if(f_query_add_mod.document.PatBloodGroup_form.rf_code.disabled==false)
	f_query_add_mod.document.PatBloodGroup_form.rf_code.value = "";

 f_query_add_mod.document.PatBloodGroup_form.g6pd_marker.value = "";
 f_query_add_mod.document.PatBloodGroup_form.sicc_marker.value = "";
  
  
/*f_query_add_mod.document.PatBloodGroup_form.blood_group.options.selectedIndex=0;
 f_query_add_mod.document.PatBloodGroup_form.rf_code.options.selectedIndex=0;
 f_query_add_mod.document.PatBloodGroup_form.g6pd.options.selectedIndex=0;
 if( f_query_add_mod.document.PatBloodGroup_form.siccn.checked)
  f_query_add_mod.document.PatBloodGroup_form.siccn.checked=false;
 f_query_add_mod.document.PatBloodGroup_form.siccp.checked=true;*/
} 

function reset()
{
 //Added by Manish Anand on 15-07-2002
f_query_add_mod.document.forms[0].reset();
 f_query_add_mod.document.PatBloodGroup_form.blood_group.value = "";
  f_query_add_mod.document.PatBloodGroup_form.rf_code.value = "";
 f_query_add_mod.document.PatBloodGroup_form.g6pd_marker.value = "";
  f_query_add_mod.document.PatBloodGroup_form.sicc_marker.value = "";
// clearform();
} 

function blank()
{
 f_query_add_mod.document.location.href='../../eMR/jsp/mrblank.jsp?step_1=5';
} 

function apply() {

	if(f_query_add_mod.document.PatBloodGroup_form.blood_group)
		f_query_add_mod.document.PatBloodGroup_form.blood_group.disabled = false;

	if(f_query_add_mod.document.PatBloodGroup_form.rf_code)
		f_query_add_mod.document.PatBloodGroup_form.rf_code.disabled = false;
   
   var values = new Array(f_query_add_mod.document.PatBloodGroup_form.blood_group,
                          f_query_add_mod.document.PatBloodGroup_form.rf_code,
                          f_query_add_mod.document.PatBloodGroup_form.patientid);

   var fields = new Array(getLabel("Common.bloodgroup.label","Common"),
                          getLabel("eMR.RHDFactor.label","MR"),
                          getLabel("Common.patientId.label","Common"));
//alert(f_query_add_mod.document.PatBloodGroup_form.g6pd_marker.value);
//alert(f_query_add_mod.document.PatBloodGroup_form.sicc_marker.value);
	
   if (f_query_add_mod.checkFields(values,fields,messageFrame) ) {
       f_query_add_mod.document.PatBloodGroup_form.submit();
       var fn_status = f_query_add_mod.document.PatBloodGroup_form.function_name.value;
   }


}

function onSuccess() {
	commontoolbarFrame.document.location.href= "../../eCommon/jsp/commonToolbar.jsp?menu_id=MR&module_id=MR&function_id=PAT_BLOOD_GROUP&function_name="+encodeURIComponent(getLabel("eMR.RecordPatientBloodGroup.label","MR"))+"&function_type=F&access=NNYNN"
	blank();
}
