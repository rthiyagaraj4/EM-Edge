function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyMedicalServiceGrp.jsp" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eIP/jsp/MedicalServiceGrpQueryCriteria.jsp" ;
}

function apply() 
{
	var dlyVal  = f_query_add_mod.document.forms[0].max_no_of_dly_booking.value;
	var mtlyVal = f_query_add_mod.document.forms[0].max_no_of_mthly_booking.value;
	
	var fields = new Array();
	fields[0]=f_query_add_mod.document.MedicalServiceGrp_form.med_ser_grp_code;
	
	var names  =  new Array ( getLabel('Common.code.label','common') );
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	//f_query_add_mod.document.MedicalServiceGrp_form.applicable_to.disabled=false;
	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
		var MSG_result = 0;		
	if(f_query_add_mod.document.MedicalServiceGrp_form.generate_num_yn.checked == true)
	{
			var fields=new Array();
			fields[0]= f_query_add_mod.document.MedicalServiceGrp_form.med_ser_grp_code;
			fields[1]= f_query_add_mod.document.MedicalServiceGrp_form.long_desc;
			fields[2]= f_query_add_mod.document.MedicalServiceGrp_form.short_desc;
			fields[3]= f_query_add_mod.document.MedicalServiceGrp_form.next_seq_no;
			fields[4]= f_query_add_mod.document.MedicalServiceGrp_form.max_seq_no;

			var names = new Array (	getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common'),
						getLabel('eIP.NextNo.label','IP'),
						getLabel('eIP.MaxNo.label','IP')
					      );
	}
	else
	{
			var fields=new Array();

			fields[0]= f_query_add_mod.document.MedicalServiceGrp_form.med_ser_grp_code;
			fields[1]= f_query_add_mod.document.MedicalServiceGrp_form.long_desc;
			fields[2]= f_query_add_mod.document.MedicalServiceGrp_form.short_desc;
			//fields[3]= f_query_add_mod.document.MedicalServiceGrp_form.applicable_to;

			var names = new Array (	getLabel('Common.code.label','common'),
									getLabel('Common.longdescription.label','common'),
									getLabel('Common.shortdescription.label','common')									
								   );
	}
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		if(f_query_add_mod.document.MedicalServiceGrp_form.generate_num_yn.checked == true)
		{
			var max = eval(f_query_add_mod.document.MedicalServiceGrp_form.max_seq_no.value) ;
			var next = eval(f_query_add_mod.document.MedicalServiceGrp_form.next_seq_no.value) ;
			if(parseInt(next) > parseInt(max))
			{
					var msg= parent.parent.frames[0].getMessage("NEXT_NUM_GR_MAX_NUM","common");
					MSG_result = 1;
			}
		}
			var dlyVal  = f_query_add_mod.document.forms[0].max_no_of_dly_booking.value;
			var mtlyVal = f_query_add_mod.document.forms[0].max_no_of_mthly_booking.value;
			if(parseInt(dlyVal) > parseInt(mtlyVal))	
			{										
					var msg= getMessage("DLY_BKG_GR_MTLY_BKG","IP");
					MSG_result = 1;
			}
		if(MSG_result == 0) {
				f_query_add_mod.document.MedicalServiceGrp_form.generate_num_yn.disabled = false;
				f_query_add_mod.document.MedicalServiceGrp_form.prefix_required_yn.disabled = false;
				f_query_add_mod.document.MedicalServiceGrp_form.submit();
		}
		else  if(MSG_result == 1)
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
     }
   
}

function onSuccess() 
{
	if(f_query_add_mod.document.MedicalServiceGrp_form.function_name.value =="insert")
	{
		f_query_add_mod.document.MedicalServiceGrp_form.reset();
		f_query_add_mod.document.MedicalServiceGrp_form.med_ser_grp_code.focus();

	}
	else
		//parent.frames[1].frames[1].location.reload();
	f_query_add_mod.location.reload() ;
}

function reset() 
{
	if(f_query_add_mod.document.forms[0].name == "MedicalServiceGrp_form")
	{
			f_query_add_mod.document.MedicalServiceGrp_form.reset();
			f_query_add_mod.document.MedicalServiceGrp_form.next_seq_no.readOnly=true;
			f_query_add_mod.document.MedicalServiceGrp_form.max_seq_no.readOnly=true;
			f_query_add_mod.document.MedicalServiceGrp_form.med_ser_grp_code.focus();
	}		
	if(f_query_add_mod.document.forms[0].name == "query_form")
			f_query_add_mod.document.query_form.reset() ;
}

function enableDisable(obj)
{
	if(obj.name == 'generate_num_yn')
	{
		if(self.MedicalServiceGrp_form.generate_num_yn.checked == true)
		{
			self.MedicalServiceGrp_form.prefix_required_yn.disabled = false;
			self.MedicalServiceGrp_form.prefix_required_yn.checked = false;
			self.MedicalServiceGrp_form.next_seq_no.value = '';
			self.MedicalServiceGrp_form.max_seq_no.value = '';
			self.MedicalServiceGrp_form.next_seq_no.readOnly = false;
			self.MedicalServiceGrp_form.max_seq_no.readOnly = false;	
			self.MedicalServiceGrp_form.nextno.style.visibility = "visible";	
			self.MedicalServiceGrp_form.maxno.style.visibility = "visible";	
		}
		else
		{
			self.MedicalServiceGrp_form.prefix_required_yn.disabled = true;
			self.MedicalServiceGrp_form.prefix_required_yn.checked = false;
			self.MedicalServiceGrp_form.next_seq_no.value = '';
			self.MedicalServiceGrp_form.max_seq_no.value = '';
			self.MedicalServiceGrp_form.next_seq_no.readOnly = true;
			self.MedicalServiceGrp_form.max_seq_no.readOnly = true;	
			self.MedicalServiceGrp_form.nextno.style.visibility = "hidden";	
			self.MedicalServiceGrp_form.maxno.style.visibility = "hidden";	
		}
	}

}

function checkNum(obj,val) 
{
	if(obj.value != '')
	{
		if(!(obj.value == 0))
			self.CheckNum(obj);
		else
		{
			if(val == 'N')
				alert(parent.parent.parent.frames[0].getMessage("INVALID_NEXT_NUMBER","common"));
			else if(val == 'M')
				alert(parent.parent.parent.frames[0].getMessage("INVALID_MAX_NUMBER","common"));
			obj.focus();
			obj.select();
		}
	}
}


function chkMaxVal(Obj)
{
	var val = Obj.value ;	
	var dlyVal  = parent.frames[1].document.forms[0].max_no_of_dly_booking.value;
	var mtlyVal = parent.frames[1].document.forms[0].max_no_of_mthly_booking.value;	
	
	if(mtlyVal !=0 )
	{
		if(Obj.name == "max_no_of_dly_booking")
		{
			if(dlyVal > mtlyVal)
			{
				Obj.select();
				Obj.focus();
				
			}
		}
		else if(Obj.name == "max_no_of_mthly_booking")
		{
			if(dlyVal > mtlyVal)
			{
				Obj.select();
				Obj.focus();
			}
		}
	}	
}

//functions moved from addModifyMedicalServiceGrp.js

/// Added by Sridhar on 12 June 2004
/// It will fetch the count of medical service code from IP_MED_SER_GRP_NURS_UT_TYPE to the code entered in Medical service Group...
/// If Count is greater than zero.. the medical service grp cannat be disabled only in MODIFY/UPDATE MODE ...
function chkMedStatus()
{
	var mode = document.forms[0].hddfnval.value;
	var count = document.forms[0].hddcount.value
	if(mode == 'modify' && count > 0)
	{
		alert(getMessage("MED_SER_GRP_ATT_TO_NU_TYPE","IP"));
		document.forms[0].eff_status.checked = true;
		document.forms[0].eff_status.value = 'E';
	}
}

function focusTxt()
{
	document.forms[0].med_ser_grp_code.focus();
}

function ChkNumberInput1(event){
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
