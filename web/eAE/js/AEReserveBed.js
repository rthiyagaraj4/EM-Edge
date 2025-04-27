/****
	Created on 		: 22/02/2005 By Metilda. For Reserve Bed Function .
****/
	function reset()
	{
		//f_query_add_mod.document.reserve_bed_form.reset();
			//f_query_add_mod.location.reload();
			f_query_add_mod.reserve_bed_form.reset();
	} 

	function apply()
	{
		var names = new Array();
		var fields = new Array();
		names[0]	= getLabel("Common.Location.label","Common");
		names[1]	= getLabel("Common.PriorityZone.label","Common");
		names[2]	= getLabel("Common.treatmentarea.label","Common");
		names[3]	= getLabel("eAE.BedBayNo.label","AE");
		fields[0]	= f_query_add_mod.document.reserve_bed_form.clinic;
		fields[1]	= f_query_add_mod.document.reserve_bed_form.priority_value;
		fields[2]	= f_query_add_mod.document.reserve_bed_form.treatment_area;
		fields[3]	= f_query_add_mod.document.reserve_bed_form.bed_no;
		if (trimCheck(f_query_add_mod.document.reserve_bed_form.reserve_until.value)==false)
			{
				names[names.length]	= getLabel("eAE.ReserveUntil.label","AE");
				fields[fields.length] = f_query_add_mod.document.reserve_bed_form.reserve_until;
			}
		if (f_query_add_mod.document.reserve_bed_form.reasons.value=='')
			{
				names[names.length]	= getLabel("eAE.Reasons.label","AE");
				fields[fields.length] = f_query_add_mod.document.reserve_bed_form.reasons;
			} 
		if (f_query_add_mod.checkFields( fields, names, messageFrame)){
							if(f_query_add_mod.document.reserve_bed_form.clinic.disabled)
					f_query_add_mod.document.reserve_bed_form.clinic.disabled=false;

		if(f_query_add_mod.document.reserve_bed_form.treatment_area.disabled)
					f_query_add_mod.document.reserve_bed_form.treatment_area.disabled=false;
		if(f_query_add_mod.document.reserve_bed_form.bed_no.disabled)
					f_query_add_mod.document.reserve_bed_form.bed_no.disabled=false;
		f_query_add_mod.document.forms[0].action="../../servlet/eAE.ReserveBedServlet";
		f_query_add_mod.document.forms[0].target="messageFrame";	
			f_query_add_mod.document.reserve_bed_form.submit();

			if(f_query_add_mod.document.reserve_bed_form.asModal.value='Y'){
				parent.window.returnValue="Success";
				setTimeout("window.close();",1000);
			}
		}
	}

	function onSuccess()
	{
		 f_query_add_mod.location.reload();
		//f_query_add_mod.location.href = "../../eAE/jsp/AEReserveBedDtl.jsp" ;   Monday, May 31, 2010 PE_EXE
	}

	function CheckNumberInput(fld, e, deci)
	{
		if (	parseInt(deci)>0)
		   var strCheck = '.0123456789 /:';
		else
		   var strCheck = '0123456789 /:';
		
	    var whichCode = (window.Event) ? e.which : e.keyCode;
		if (whichCode == 13) return true;  // Enter
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	}


   function dateVal(from,to)
	{
		var todate = to.value;
		if (todate != "")
		{
			if(validDate(to.value,"DMYHM",localeName))
			{
				if(isBeforeNow(to.value,"DMYHM",localeName))
				 {
					alert(getMessage("RES_UNTIL_LESS_SYSDATE",'AE'));
					to.value="";
					to.focus();
					return 
				 }
			}
			else
		    {
				alert(getMessage("INVALID_DATE_TIME",'SM'));					
				to.value="";
				to.focus();
				return
		    }
        }
	}


	function checkForMaxLimit(obj,max)
	{
		 var errors='';
		 var lab = obj.name;
	     if(obj.value.length > max) {
			 errors = errors + getMessage("REMARKS_CANNOT_EXCEED","Common"); 
			 errors = errors.replace('$',getLabel("Common.reason.label","Common"));
			 errors = errors.replace('#',max);
			 errors = errors + "\n" ;
			 alert(errors) ;
			 // Thursday, March 18, 2010  20118 AE-Reserve-Bed-Bay-Remarks Venkat S.
			  obj.focus();
			  obj.value ='';

			 return false;
		
	     } else return true;
	}

	function clearval()
	{	
				
		var select = parent.frames[1].document.reserve_bed_form.treatment_area;
		var length = select.length;
		for(i=0;i<length;i++)
			select.remove(0);
		var option		=  parent.frames[1].document.createElement("OPTION");
		option.text		=  '----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
		option.value	=  ""	;
		option.selected	=  true;
		select.add(option);
		
		parent.frames[1].document.reserve_bed_form.priority_value.value="";
        parent.frames[1].document.reserve_bed_form.bed_no.value="";

			
	}

	function callTreatment() {
		var select = parent.frames[1].document.reserve_bed_form.treatment_area;
		var priority_zone_value=parent.frames[1].document.reserve_bed_form.priority_value.value;
		var bed_no=parent.frames[1].document.reserve_bed_form.bed_no;
		var length = select.length;
		for(i=0;i<length;i++)
			select.remove(0);
		var option		=  parent.frames[1].document.createElement("OPTION");
		option.text		=  '----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
		option.value	=  ""	;
		option.selected	=  true;
		select.add(option);
		bed_no.value="";
		if(priority_zone_value!="") getTreatmentArea('');
	}

	function getTreatmentArea(val)
	{	
			
			var clinic		= document.reserve_bed_form.clinic.value;
			var priority_zone= document.reserve_bed_form.priority_value.value;
			

			var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEReserveBedPopulateValue.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ReserveBed'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='TreatmentArea'><input type='Hidden' name='field1' id='field1' value='"+clinic+"'><input type='hidden' name='field2' id='field2' value='"+priority_zone+"' ><input type='hidden' name='treatment_val' id='treatment_val' value='"+val+"'></form></body></html>"
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLValue);
			parent.frames[2].document.dummy_form.submit();
		
	}

	function checkForValidBed(bed)
	{
		var clinic				= document.reserve_bed_form.clinic.value;
		var treatment_area		= document.reserve_bed_form.treatment_area.value;
		var facility_id			= document.reserve_bed_form.facility_id.value;
		var zone				= document.reserve_bed_form.priority_value.value;
		
				if (bed != "" && clinic != "" && treatment_area != "")
		{
			
			var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEReserveBedPopulateValue.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='ReserveBed'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic+"'><input type='Hidden' name='field5' id='field5' value='"+zone+"'></form></body></html>"
			parent.frames[2].document.write(HTMLValue);
			parent.frames[2].document.dummy_form.submit();
		}
	}

	async function searchBed()
	{
		var retVal = 	new String();
		var dialogHeight= "75vh" ;
		var dialogWidth	= "75vw" ;
		var dialogTop	= "66" ;	
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var treatment_area_code = document.forms[0].treatment_area.value;
		var clinic_code = document.forms[0].clinic.value;
		var priority_value=document.forms[0].priority_value.value;
		var oper_stn=document.forms[0].oper_stn_id.value;
		var url   = "../../eAE/jsp/AEBedAvailabilityChart.jsp?clinic_code="+clinic_code+"&treatment_area="+treatment_area_code+"&call_function=ReserveBed&select_check=X&bed_classification=N&bed_status=V&priority_zone="+priority_value+"&oper_stn_id="+oper_stn;
		retVal = await top.window.showModalDialog( url,arguments,features);
		
		if(retVal!=null)
		{
			Val = retVal.split("^");
			document.forms[0].bed_no.value = Val[0];
			document.forms[0].clinic.value = Val[1];
			if( treatment_area_code=='' && clinic_code=='' && priority_value=='' ) // Thursday, May 27, 2010 PE_EXE
			{
				getTreatmentArea(Val[3]);
			}
			
			document.forms[0].bed_no.focus();
		}
	}

    function clearBed(obj)
	{
		var bed_no=parent.frames[1].document.reserve_bed_form.bed_no;
		bed_no.value="";
		if(obj.value=="")
		{
		  document.forms[0].bed_no.innerText='';
		document.forms[0].bed_no.value='';
		}
    }



