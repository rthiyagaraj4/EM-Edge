var errors = "" ;


function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addMRecordsSection.jsp" ;
}

function query() {
      f_query_add_mod.location.href ="../../eMP/jsp/MRecordsSectionQueryCriteria.jsp" ;
}

function apply()
{
		 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	 
	 
	 if( f_query_add_mod.document.mr_section_form.prefix_req1.checked == true ) 	f_query_add_mod.document.mr_section_form.prefix_req.value="Y";
	 if( f_query_add_mod.document.mr_section_form.old_mrn1.checked == true )		f_query_add_mod.document.mr_section_form.old_mrn.value="Y";
	 if( f_query_add_mod.document.mr_section_form.eff_status1.checked == true ) 	f_query_add_mod.document.mr_section_form.eff_status.value="E";
	 f_query_add_mod.document.mr_section_form.section_type.value = f_query_add_mod.document.mr_section_form.section_type1.value;
			
	
		var fields = new Array (
				f_query_add_mod.document.mr_section_form.facility,
				f_query_add_mod.document.mr_section_form.section_code,
				f_query_add_mod.document.mr_section_form.long_name,
				f_query_add_mod.document.mr_section_form.short_name,
				f_query_add_mod.document.mr_section_form.section_type1,
				f_query_add_mod.document.mr_section_form.next_srl,
				f_query_add_mod.document.mr_section_form.max_srl
			);
				       
		var names  = new Array (
			    getLabel("Common.facility.label","Common"),
				getLabel('Common.code.label','common'),
		        getLabel('Common.longname.label','common'),
				getLabel('Common.shortname.label','common'),
				getLabel('eMP.SectionType.label','MP'),
				getLabel('Common.nextsrlno.label','common'),
				getLabel('Common.maxserialno.label','common')
			);	

		 var specialCharfields = new Array (f_query_add_mod.document.mr_section_form.section_code);
		 var specialChars = new Array ( getLabel('Common.code.label','common'));


		
			if(f_query_add_mod.SpecialCharCheck(specialCharfields,specialChars,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
			{
				if( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame) ) 
				{

					
					obj=f_query_add_mod.document.mr_section_form.next_srl;
					obj1=f_query_add_mod.document.mr_section_form.max_srl;
		
					if(obj.value.indexOf('.') !=-1)
					{
						var errors1=f_query_add_mod.getMessage("INVALID_INTEGER","SM");
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
						return;
					}
					if(obj1.value.indexOf('.') !=-1)
					{
						var errors1=f_query_add_mod.getMessage("INVALID_INTEGER","SM");
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
						return;
					}
					var val=parseInt(obj.value,10);
					var val1=parseInt(obj1.value,10);	
					
					if(val >= val1)
					{
						var errors1=f_query_add_mod.getMessage("MAX_SRL_GR_NEXT_SRL","SM");
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
						return;
					}
					
			
			f_query_add_mod.document.forms[0].submit();

			}
		}
		
}



function reset() {
	  f_query_add_mod.document.forms[0].reset(); 
	
}

function onSuccess() {
	
	//f_query_add_mod.document.forms[0].section_code.focus();
	//f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();
}
function CodeLen(Obj)
{
	if(Obj.value.length<2 && Obj.value!="")
	{
		alert(getMessage("CODE_2_CH","MP"));
		Obj.select();
		Obj.focus();
	}
}
function CheckIdLen(Obj)
{
	if(Obj.value!="")
	{
		if(parseInt(Obj.value) <= 0)
		{
			alert(getMessage("VALUE_GREAT_ZERO","MP"));
			Obj.focus();
			Obj.select();
			return;
		}
	}
	if (CheckNum(Obj)==true)
	{
		if(Obj.value!="")
		{
			if(parseInt(Obj.value) > parseInt(mr_section_form.patient_id_length.value))
			{				
				alert(getMessage("PATID_GREATER","MP"));
				Obj.focus();
				Obj.select();
			}
		}
	}
}
function setMaxLength(maxLength) 
{
	if(mr_section_form.prefix_req1.checked == true) 
	{
		mr_section_form.next_srl.value  = "";
		mr_section_form.max_srl.value   = "";
		mr_section_form.next_srl.maxLength = maxLength-2;
		mr_section_form.max_srl.maxLength  = maxLength-2;
	}
	else if(mr_section_form.prefix_req1.checked == false)
	{
		mr_section_form.next_srl.maxLength = maxLength;
		mr_section_form.max_srl.maxLength  = maxLength;
	}
}

function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
