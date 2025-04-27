function create() 
{
	
	f_query_add_mod.location.href = "../../eOP/jsp/addModifyVTForClinic.jsp?procID=visit_type_for_proc_unit" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eOP/jsp/queryVisitTypeForClinicPage.jsp?function=VisitTypeforClinic&procID=visit_type_for_proc_unit" ;
}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}

function apply() 
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }

	var visit_type = f_query_add_mod.document.facility_form.visittype.value;
	if (visit_type!="")
	{
		var arr =new Array();
		arr=visit_type.split('$');
		f_query_add_mod.document.facility_form.visittype1.value = arr[2];
	}

	var fields = new Array (f_query_add_mod.document.facility_form.clinic,
					f_query_add_mod.document.facility_form.visittype)

	var names = new Array ( getLabel('Common.Location.label','Common'),getLabel('Common.visittype.label','Common') );

		if(f_query_add_mod.document.facility_form.function_name.value=="insert")
		{
				fields[2]=f_query_add_mod.document.facility_form.indicator
				names[2]=getLabel("eOP.ApplicableVisitTypeIndicator.label","Op");

				/*if(f_query_add_mod.document.facility_form.setup_bl_dtls_in_op_yn.value == "Y")
				{
					fields[3]=f_query_add_mod.document.facility_form.visit_charge
					names[3]="Visit Charge Billing Service"
					fields[4]=f_query_add_mod.document.facility_form.prescription_fee
					names[4]="Med Pres Fee for Billing Service"
				}*/
		}
		else
		{
			/*	if(f_query_add_mod.document.facility_form.setup_bl_dtls_in_op_yn.value == "Y")
				{
					f_query_add_mod.document.facility_form.visit_charge.disabled = false;
					f_query_add_mod.document.facility_form.prescription_fee.disabled = false;
					//f_query_add_mod.document.facility_form.deposit_reqd_yn.disabled = false;
					//f_query_add_mod.document.facility_form.prepay_reqd_yn.disabled = false;
					//f_query_add_mod.document.facility_form.amount_fixed_yn.disabled = false;

					fields[2]=f_query_add_mod.document.facility_form.visit_charge
					names[2]="Visit Charge Billing Service"
					fields[3]=f_query_add_mod.document.facility_form.prescription_fee
					names[3]="Med Pres Fee for Billing Service"
				}*/
		}

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			f_query_add_mod.document.facility_form.submit();
		}

}

function onSuccess()
{
	if(f_query_add_mod.document.facility_form.function_name.value=="insert")
		{
	 		f_query_add_mod.location.href = "../../eOP/jsp/addModifyVTForClinic.jsp?procID=visit_type_for_proc_unit" ;
	    }
	else
		f_query_add_mod.location.reload() ;
	}

function reset() {

/*
if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	if(f_query_add_mod.document.forms[0].name == "facility_form")
		{

		f_query_add_mod.document.facility_form.reset() ;

		
if(f_query_add_mod.document.forms[0].function_name.value=='insert'){



ClearList(f_query_add_mod.document.forms[0].indicator);
ClearList(f_query_add_mod.document.forms[0].visittype);
ClearList(f_query_add_mod.document.forms[0].sservice);
}else{

var subservice=f_query_add_mod.document.forms[0].sservice_hidden.value;
if(subservice!="")
f_query_add_mod.document.forms[0].sservice.value=subservice;
}


//performing_facility_desc= formObjBottom.performing_facility_id.options(formObjBottom.performing_facility_id.selectedIndex).text;

		}
	else
		{ 
		
		f_query_add_mod.document.query_form.reset() ;
		
		
		}

*/

 if(f_query_add_mod.location.href.indexOf("queryVisitTypeForClinic.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;
}

/********** added on 11/26/2003******************/
function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;



var element = f_query_add_mod.document.facility_form.document.createElement('OPTION');
    element.text= "------"+getLabel('Common.defaultSelect.label','Common')+"------";
    element.value="";
   

	
        for(i=1;i<length;i++)
            object.remove(1);
   

}
/**********************************************************/
