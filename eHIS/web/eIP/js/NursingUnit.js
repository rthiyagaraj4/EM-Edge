function create() 
{
	//nur_unit_frame.rows="42,*,0,50";//included for the CRF - RUT-CRF-013
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyNursingUnit.jsp?create=Y" ;
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="82vh";
	document.getElementById("blank").style.height="1vh";
	document.getElementById("messageFrame").style.height="9vh";
}

function query() 
{
	//nur_unit_frame.rows="42,*,0,50";//included for the CRF - RUT-CRF-013 
	f_query_add_mod.location.href ="../../eIP/jsp/NursingUnitQueryCriteria.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) && (url.indexOf("reset")==-1))
        return true;
    else
        return false;
  }

function apply() 
{
	
	var messageFrame =frames[3];
if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array (f_query_add_mod.document.NursingUnit_form.nursing_unit_code);
	var names  =  new Array ( getLabel('Common.code.label','Common'));
	//var messageFrame = parent.frames[1].frames[2]; 
	 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	/* Code to print the error Error messages mandatory fields */
	/* level of care indicator mandatory field removed on 05/02/04 */

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{
		var fields=new Array();

		fields[0]= f_query_add_mod.document.NursingUnit_form.nursing_unit_code;
		fields[1]= f_query_add_mod.document.NursingUnit_form.locn_type;
		fields[2]= f_query_add_mod.document.NursingUnit_form.long_desc;
		fields[3]= f_query_add_mod.document.NursingUnit_form.short_desc;
		fields[4]= f_query_add_mod.document.NursingUnit_form.nursing_unit_type_code;
		fields[5]= f_query_add_mod.document.NursingUnit_form.dept_code;
		fields[6]= f_query_add_mod.document.NursingUnit_form.service_code;
		fields[7]= f_query_add_mod.document.NursingUnit_form.applicable_to;

		var names = new Array (	getLabel('Common.code.label','Common'),
					getLabel('Common.locationtype.label','common'),
					getLabel('Common.longdescription.label','common'),
					getLabel('Common.shortdescription.label','common'),
					getLabel('eIP.NursingUnitType.label','IP'),
					getLabel('Common.acctdept.label','common'),
					getLabel('Common.service.label','common'),
					getLabel('Common.ApplicableTo.label','common')
					);

		if(f_query_add_mod.document.NursingUnit_form.mr_section_type.value =='D' && f_query_add_mod.document.NursingUnit_form.applicable_to.value =='IP')
		{
			fields[fields.length] = f_query_add_mod.document.NursingUnit_form.mr_location_code;
			names[names.length] = getLabel('Common.FileStorageLocation.label','common');
		}

		/* End of code to check Error messages for mandatory fields */
		var result = 0;

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			if(result == 0) 
			{
				
				for(var i=0; i<f_query_add_mod.document.NursingUnit_form.length;i++)
				{
					if( f_query_add_mod.document.NursingUnit_form.elements[i].disabled ==true)
					{
						f_query_add_mod.document.NursingUnit_form.elements[i].disabled =false; 		
					}
				}
				if(f_query_add_mod.document.NursingUnit_form.ALLOW_NEW_BORN_REGN_YN.checked==true)
					f_query_add_mod.document.NursingUnit_form.all_new_bor.value='Y';
				else
					f_query_add_mod.document.NursingUnit_form.all_new_bor.value='N';
	
					f_query_add_mod.document.NursingUnit_form.submit();

				if( f_query_add_mod.document.NursingUnit_form.hdd_param_releaseBed.value == 'Y' )
					f_query_add_mod.document.NursingUnit_form.rel_bed_on_leave.disabled = false;
				else
					f_query_add_mod.document.NursingUnit_form.rel_bed_on_leave.disabled = true;

			}
			else if(result == 1)
			{
				
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';
			}
		}
	}	
}

/*function onSuccess() 
{ 
	if(f_query_add_mod.document.NursingUnit_form.function_name.value =="insert")
		{
			f_query_add_mod.document.NursingUnit_form.reset();
			f_query_add_mod.document.forms[0].nursing_unit_code.focus();
			f_query_add_mod.document.NursingUnit_form.check_same_sex.disabled=false;
			f_query_add_mod.document.NursingUnit_form.check_same_sex.checked=false;
			f_query_add_mod.document.NursingUnit_form.rel_bed_on_leave.disabled = true;
			f_query_add_mod.document.NursingUnit_form.applicable_to.disabled = true;
			f_query_add_mod.document.NursingUnit_form.allow_pseudo_bed_srl_yn.disabled=true;
			
		}
		else if(f_query_add_mod.document.NursingUnit_form.function_name.value =="modify")
		{
			//f_query_add_mod.document.NursingUnit_form.reset();
			f_query_add_mod.document.NursingUnit_form.check_same_sex.disabled=false;
			f_query_add_mod.document.NursingUnit_form.check_same_sex.checked=false;
			f_query_add_mod.document.NursingUnit_form.rel_bed_on_leave.disabled = true;
			f_query_add_mod.document.NursingUnit_form.applicable_to.disabled = true;
			f_query_add_mod.document.NursingUnit_form.allow_pseudo_bed_srl_yn.disabled=true;
		}
		else
		{	
			f_query_add_mod.document.location.reload(); 
		}
}*/
function onSuccess()
{	
	if(f_query_add_mod.document.NursingUnit_form.function_name.value =="insert"){
		//nur_unit_frame.rows="42,*,0,50";
		f_query_add_mod.document.forms[0].reset() ;
		f_query_add_mod.document.location.reload() ;
	}

	else{
		//nur_unit_frame.rows="42,*,0,50";
		f_query_add_mod.document.location.reload() ;
	}
	
}

function reset() 
{
	//nur_unit_frame.rows="42,*,0,50";
	var service_code;
	if(f_query_add_mod.document.forms[0].hidden_service_code)
		service_code= f_query_add_mod.document.forms[0].hidden_service_code.value;
			f_query_add_mod.document.forms[0].reset() ;

if(f_query_add_mod.document.NursingUnit_form)
{
	if (f_query_add_mod.document.NursingUnit_form.function_name.value =="insert"){
			f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload();
	}else{
	f_query_add_mod.document.forms[0].reset() ;
	f_query_add_mod.document.location.reload();
	}
}
						
if(f_query_add_mod.document.forms[0].name == "query_form")
	f_query_add_mod.document.forms[0].reset();	
		
if(f_query_add_mod.document.forms[0].name =="NursingUnit_form")
{
	if(f_query_add_mod.document.NursingUnit_form.function_name.value =="insert")
	{
		f_query_add_mod.document.NursingUnit_form.check_same_sex.disabled=false;
		f_query_add_mod.document.NursingUnit_form.check_same_sex.checked=false;
		f_query_add_mod.document.getElementById("popUp").style.visibility="hidden";
		//modified on 24-06-2008
		if(f_query_add_mod.document.forms[0].create_file_yn.value=='Y')
			f_query_add_mod.document.forms[0].online_mr_notfn_yn.disabled=false;
		else
			f_query_add_mod.document.forms[0].online_mr_notfn_yn.disabled=true;
		f_query_add_mod.document.forms[0].auto_file_transfer_yn.disabled=false;

		ClearList(f_query_add_mod.document.NursingUnit_form.service_code);
	}
	else
	{
		var n = f_query_add_mod.document.forms[0].age_group_code.selectedIndex;
		if (f_query_add_mod.gender_ind[n]=="M" || f_query_add_mod.gender_ind[n]=="F")
		{
			f_query_add_mod.document.NursingUnit_form.check_same_sex.checked=true;
			f_query_add_mod.document.NursingUnit_form.check_same_sex.disabled=true;
		}
		else
		{
			if (f_query_add_mod.document.NursingUnit_form.check_same_sex_in_room_yn.value=="Y")
				f_query_add_mod.document.NursingUnit_form.check_same_sex.checked=true;
			else
				f_query_add_mod.document.NursingUnit_form.check_same_sex.checked=false;
			f_query_add_mod.document.NursingUnit_form.check_same_sex.disabled=false;
		}
		f_query_add_mod.document.forms[0].service_code.value=service_code;

		f_query_add_mod.document.forms[0].nursing_unit_code.focus();
	}
	}
			f_query_add_mod.document.forms[0].nursing_unit_code.focus();
}


function enableDisable(obj)
	{
	}

function checkNum(obj,val) {
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

function ClearList(object)
{
	if (object)
		var length  =object.length;

	var element = f_query_add_mod.document.createElement('OPTION');
		element.text= "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		element.value=""; 
		
	for(i=1;i<length;i++)
		object.remove(1);   
}

//Moved from addModifyNursingUnit.js

// To Populate File Type If the Applicable To is Day Care and FM is not installed .
function populateFileType()
{
	var fm_install		=	document.forms[0].fm_install.value;
	var mr_location_code	=	document.forms[0].mr_location_code.value;
	var applicable_to	=	document.forms[0].applicable_to.value;

	if(applicable_to=='DC')
	{
		empty_fields();
		document.forms[0].mr_section_type.value		= "";
		document.forms[0].mr_section_type.disabled	= true;

		document.forms[0].mr_section.value			= "";
		document.forms[0].mr_section.disabled		= true;

		document.forms[0].mr_location_code.value	= "";
		document.forms[0].mr_location_code.disabled	= true;

		document.forms[0].dflt_file_type.value		= "";
		document.forms[0].dflt_file_type.disabled	= true;

		document.forms[0].online_mr_notfn_yn.checked	= false;
		document.forms[0].online_mr_notfn_yn.disabled	= true;
		document.forms[0].auto_file_transfer_yn.checked	= false;
		document.forms[0].auto_file_transfer_yn.disabled= true;
	}
	else
	{
		
		if(document.forms[0].maintain_doc_or_file.value == "D")
		{
			document.forms[0].mr_section_type.value		= "";
			document.forms[0].mr_section_type.disabled	= true;
			document.forms[0].mr_section.value			= "";
			document.forms[0].mr_section.disabled		= true;
			document.forms[0].dflt_file_type.value		= "";
			document.forms[0].dflt_file_type.disabled	= true;
			document.forms[0].online_mr_notfn_yn.checked	= false;
			//modified on 24-06-2008
			document.forms[0].online_mr_notfn_yn.disabled	= true;
			document.forms[0].auto_file_transfer_yn.checked	= false;
			document.forms[0].auto_file_transfer_yn.disabled= true;

			document.forms[0].mr_location_code.value	= "";
			document.forms[0].mr_location_code.disabled	= false;
		}
		else
		{
			document.forms[0].mr_section_type.disabled          = false;
			document.forms[0].mr_section.disabled				= false;
			document.forms[0].mr_location_code.disabled			= false;
			document.forms[0].dflt_file_type.disabled			= false;
			//modified on 24-06-2008
			if(parent.f_query_add_mod.document.forms[0].create_file_yn.value=='Y')
				document.forms[0].online_mr_notfn_yn.disabled	= false;
			else
				document.forms[0].online_mr_notfn_yn.disabled   = true;
			document.forms[0].auto_file_transfer_yn.disabled	= false;
		}
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetService.jsp?criteria=populateFSLocation'><input type='hidden' name='mr_location_code' id='mr_location_code' value='"+mr_location_code+"'><input type='hidden' name='applicable_to' id='applicable_to' value='"+applicable_to+"'><input type='hidden' name='fm_install' id='fm_install' value='"+fm_install+"'><input type='hidden' name='centralValue' id='centralValue' value='N'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();
	}
}

function populatefslocation()
{
	var fm_install		=	document.forms[0].fm_install.value;
	var mrSectionType	=	document.forms[0].mr_section_type.value;
	var applicable_to	=	document.forms[0].applicable_to.value;

	if((fm_install == 'Y')&&(mrSectionType == 'D')&&(applicable_to == 'IP'))
	{
	HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetService.jsp?criteria=populateFSLocation?'><input type='hidden' name='fm_install' id='fm_install' value='"+fm_install+"'></form></body></html>";
	}
	else
	if((fm_install == 'Y')&&((mrSectionType != 'D')||(applicable_to != 'IP')))
	{
	HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetService.jsp?criteria=repopulateFSLocn?'><input type='hidden' name='fm_install' id='fm_install' value='"+fm_install+"'></form></body></html>";
	parent.messageFrame.document.write(HTMLVal);
	parent.messageFrame.document.dum_form.submit();
	}

}


function empty_fields()
{
	//removing the contents of MR Section...
	var n = parent.frames[1].document.NursingUnit_form.mr_section.length;
	for(var i=0;i<n;i++)
		parent.frames[1].document.NursingUnit_form.mr_section.remove("SHORT_NAME");	
	
	var temp = "";
	var temp1="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt=parent.frames[1].document.createElement('OPTION');
	opt.text=temp1;
	opt.value=temp;
	parent.frames[1].document.NursingUnit_form.mr_section.add(opt);	
	parent.frames[1].document.NursingUnit_form.mr_section.options[0].selected = true;

	//removing the contents of File Storage Location...
	n = parent.frames[1].document.NursingUnit_form.mr_location_code.length;
	for(i=0;i<n;i++)
		parent.frames[1].document.NursingUnit_form.mr_location_code.remove("SHORT_NAME");	
	
	temp = "";
	temp1="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt=parent.frames[1].document.createElement('OPTION');
	opt.text=temp1;
	opt.value=temp;
	parent.frames[1].document.NursingUnit_form.mr_location_code.add(opt);	
	parent.frames[1].document.NursingUnit_form.mr_location_code.options[0].selected = true;
}


/// Added by Sridhar R on 18 JUNE 2004
/// Function populateMRSecType will populate the values of MR SECTION TYPE based on 
/// MR SECTION Value...
function populateMRSecType(obj)
{
	var mrSectionType   =   obj.value ;
	var fm_install		=	document.forms[0].fm_install.value;
	var mr_location_code	=	document.forms[0].mr_location_code.value;
	var applicable_to	=	document.forms[0].applicable_to.value;

	if(mrSectionType == 'D')
	{
/*
		if((applicable_to == 'IP')&&(fm_install == 'Y'))
			document.getElementById("mandatory_gif").style.visibility = "visible";
*/
	}
/*
	else
		document.getElementById("mandatory_gif").style.visibility = "hidden";
*/	
	if (obj.value == '')
	{
		
		//removing the contents of mr section code.
		var n = parent.frames[1].document.NursingUnit_form.mr_section.length;
				for(var i=0;i<n;i++)
	parent.frames[1].document.NursingUnit_form.mr_section.remove("SHORT_NAME");	
				var temp = "";
				var temp1="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
				var opt=parent.frames[1].document.createElement('OPTION');
				opt.text=temp1;
				opt.value=temp;
	parent.frames[1].document.NursingUnit_form.mr_section.add(opt);	
	parent.frames[1].document.NursingUnit_form.mr_section.options[0].selected = true;

		//removing the contents of File Storage Location.

		   n = parent.frames[1].document.NursingUnit_form.mr_location_code.length;
				for(i=0;i<n;i++)
	parent.frames[1].document.NursingUnit_form.mr_location_code.remove("SHORT_NAME");	
				 temp = "";
				 temp1="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
				 opt=parent.frames[1].document.createElement('OPTION');
				opt.text=temp1;
				opt.value=temp;
	parent.frames[1].document.NursingUnit_form.mr_location_code.add(opt);	
	parent.frames[1].document.NursingUnit_form.mr_location_code.options[0].selected = true;

	}
	else
	if (obj.value != '')
	{
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetService.jsp?criteria=populateMRType'><input type='hidden' name='mr_section_type' id='mr_section_type' value='"+mrSectionType+"'><input type='hidden' name='fm_install' id='fm_install' value='"+fm_install+"'><input type='hidden' name='applicable_to' id='applicable_to' value='"+applicable_to+"'></form></body></html>";

		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();
	}
}

function assignValues(obj)
{
   if (obj.checked == true)		
	  document.forms[0].check_same_sex_in_room_yn.value = "Y";
   else
	  document.forms[0].check_same_sex_in_room_yn.value = "N";
}

function disableall()
{
	empty_fields();
	document.forms[0].mr_section_type.value			=  "";
	document.forms[0].mr_section.value			=  "";
	document.forms[0].mr_location_code.value			=  "";
	document.forms[0].dflt_file_type.value			=  "";
//	document.forms[0].img3.style.visibility = 'hidden';
}

function checkvalue(obj)
{
	if (obj.checked == true) 
		obj.value="Y";
	else if(obj.checked == false ) 
		obj.value="N";
}

function getService(val)
{

	var dept		 = document.NursingUnit_form.dept_code.value;
	var servicecode ;
	var mrSectionCode;	  
	var mrSectionType;

	if(val == 'M' )
	{
		servicecode		= document.NursingUnit_form.hidden_service_code.value;
		sectioncode		= document.NursingUnit_form.hidden_section_code.value;
		mrSectionCode	= document.NursingUnit_form.mr_section.value;
	}
	else if(val == 'I')
	{
		servicecode		= '';
		sectioncode		= '';
	} 

/* Initializes the form element value & removes elements from the select option */
/****************************** SERVICE *************************/
		service = document.NursingUnit_form.service_code;
		while( service.options.length > 0 )
				service.remove(service.options[0]);
		var opt = document.getElementById('service_code').appendChild(document.createElement("OPTION"));
		opt.text ="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value= '';
		parent.frames[1].document.forms[0].service_code.add(opt);

/****************************** SECTION *************************/
		section = document.NursingUnit_form.section;
		while( section.options.length > 0 )
				section.remove(section.options[0]);
		var opt_section = document.getElementById('service_code').appendChild(document.createElement("OPTION"));
		opt_section.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---"
		opt_section.value= '';
		parent.frames[1].document.forms[0].section.add(opt_section);

/****************************** MR SECTION *************************/

		/* On evaluation of condition, passes the value to GetService.jsp on action where values are retreived from database using JDBC concept. */

		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetService.jsp?'><input type='hidden' name='dept_code' id='dept_code' value='"+dept+"'><input type='hidden' name='service_code' id='service_code' value='"+servicecode+"'><input type='hidden' name='section_code' id='section_code' value='"+sectioncode+"'></form></body></html>";
		
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.forms[0].submit();

}
/* End of addition by Sridhar */

function focusTxt()
{
	document.NursingUnit_form.nursing_unit_code.focus();
}	
function disen()
{
	if(document.getElementById("mr_section_type").value =='D')
	{
//		document.getElementById("img3").style.visibility	=	"visible";
	}
	else
	{	
//		document.getElementById("img3").style.visibility	=	"hidden";
	}
}

function ldmrs()
{
	obj = document.getElementById("mr_section_type");
	if(obj != '')
	{
		populateMRSecType(obj);
	}
}

function disfilreq(obj)
{
	var chk = obj;
	if(chk=='D')
	{
		document.forms[0].mr_section_type.disabled=true;
		document.forms[0].dflt_file_type.disabled=true;
		//modified on 24-06-2008
		document.forms[0].online_mr_notfn_yn.disabled=true;
		document.forms[0].auto_file_transfer_yn.disabled=true;

	}
}
function chkAutoFilReq(obj)
{
	var mode			= document.NursingUnit_form.function_name.value;
	var mr_section_type = document.NursingUnit_form.mr_section_type.value;
	var reportcnt       = document.NursingUnit_form.reportcnt.value;
	
	if(mode == "modify" && mr_section_type != "D" && obj.checked == false)
	{
		if(reportcnt > 0)
		{
			alert(getMessage("FM_ONLINE_REP_RULE_NOT_DEFINED","FM"));
			obj.checked = true;
			obj.value   = "Y";
		}
		
	}
}

