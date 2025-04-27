function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifySubserviceinFacility.jsp?source=Insert&facilityId="+facId ;
}
function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eAM/jsp/SubserviceinfacilityQueryCriteria.jsp?function=Subserviceinfacility";
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
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array ( f_query_add_mod.document.subserviceinfacility_form.facility_id,
				 f_query_add_mod.document.subserviceinfacility_form.service_code,
				 f_query_add_mod.document.subserviceinfacility_form.subservice_code,
				 f_query_add_mod.document.subserviceinfacility_form.dept_code
				);


	var names = new Array ( getLabel("Common.facility.label","Common"),
							getLabel("Common.service.label","Common"),
							getLabel("Common.subservice.label","Common"),
							getLabel("Common.acctdept.label","Common")
						   );

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
	    var fn_status = f_query_add_mod.document.subserviceinfacility_form.function_name.value ;
	
	     f_query_add_mod.document.subserviceinfacility_form.submit();
	}

}
var facId='';
function onSuccess()
{
   facId=f_query_add_mod.document.subserviceinfacility_form.facility_id.value;
   if(f_query_add_mod.document.subserviceinfacility_form.function_name.value == 'insert')
	{  
	  // 	f_query_add_mod.location.href = "../../eAM/jsp/addModifySubserviceinFacility.jsp?";
	  f_query_add_mod.document.forms[0].reset();
	}
	

}
function reset()
{
	if(f_query_add_mod.document.forms[0] == "subserviceinfacility_form")
	{
		if(f_query_add_mod.document.forms[0].function_name.value == 'insert')
		{
			//if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
			ClearList(f_query_add_mod.document.subserviceinfacility_form.subservice_code);
			ClearList(f_query_add_mod.document.subserviceinfacility_form.dept_code);
			ClearList(f_query_add_mod.document.subserviceinfacility_form.section_code);
		}
		}
		else
		{
			f_query_add_mod.location.reload();
		}
	

	
}
function PopulateList()
{
	var selected = subserviceinfacility_form.service_code;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var subservice_code=subserviceinfacility_form.subservice_code;
	while ( subservice_code.options.length > 0 )
		subservice_code.remove(subservice_code.options[0]);
	
	var section_code=subserviceinfacility_form.section_code
	while ( section_code.options.length > 0 )
		section_code.remove(section_code.options[0]);
	
	var dept_code=subserviceinfacility_form.dept_code;
	while ( dept_code.options.length > 0 )
		dept_code.remove(dept_code.options[0]);		
		
	var opfacilityid = subserviceinfacility_form.facility_id.value;
	var getservice=subserviceinfacility_form.facility_id.value;
	if (opfacilityid != null && opfacilityid != "")
	{
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='querydept' id='querydept' method='post' action='../../eAM/jsp/SubserviceinfacilityPopulate.jsp?getservice=one'><input type='hidden' name='facility_id' id='facility_id' value='"+opfacilityid+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.querydept.submit();
	}
			var opt=parent.frames[1].document.createElement("Option");
			opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value="";
			parent.frames[1].document.getElementById('service_code').add(opt);
			
			var opt1=parent.frames[1].document.createElement("Option");
			opt1.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt1.value="";
			parent.frames[1].document.getElementById('subservice_code').add(opt1);
			
			var opt2=parent.frames[1].document.createElement("Option");
			opt2.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt2.value="";
			parent.frames[1].document.getElementById("dept_code").add(opt2);
			
			var opt3=parent.frames[1].document.createElement("Option");
			opt3.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt3.value="";
			parent.frames[1].document.getElementById('section_code').add(opt3);

}



function PopulateServiceList()
{
	var selected1 = subserviceinfacility_form.subservice_code;
	var selected = subserviceinfacility_form.dept_code;
	var opfacilityid = subserviceinfacility_form.facility_id.value;

	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);

	while ( selected1.options.length > 0 )
			selected1.remove(selected1.options[0]);

var section_code = subserviceinfacility_form.section_code;
	while ( section_code.options.length > 0 )
			section_code.remove(section_code.options[0]);

	var servicecode = subserviceinfacility_form.service_code.value;
	if (servicecode != null && servicecode != "")
	{
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='querydept' id='querydept' method='post' action='../../eAM/jsp/SubserviceinfacilityPopulate.jsp?getservice=two'><input type='hidden' name='service_code' id='service_code' value='"+servicecode+"'><input type='hidden' name='facility_id' id='facility_id' value='"+opfacilityid+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.querydept.submit();
	}
				var opt1=parent.frames[1].document.createElement("Option");
				opt1.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
				opt1.value="";
				parent.frames[1].document.getElementById('subservice_code').add(opt1);
				
				var opt2=parent.frames[1].document.createElement("Option");
				opt2.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
				opt2.value="";
				parent.frames[1].document.getElementById("dept_code").add(opt2);
				
				var opt3=parent.frames[1].document.createElement("Option");
				opt3.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
				opt3.value="";
			parent.frames[1].document.getElementById('section_code').add(opt3);

}


function PopulateDeptList()
{

	var selected = subserviceinfacility_form.section_code;
	//var sectioncode = subserviceinfacility_form.section_code;
	var opfacilityid = subserviceinfacility_form.facility_id.value;



	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);


	var deptcode = subserviceinfacility_form.dept_code.value;


	if (deptcode != null && deptcode != "")
	{

		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='querydept' id='querydept' method='post' action='../../eAM/jsp/SubserviceinfacilityPopulate.jsp?getservice=three'><input type='hidden' name='dept_code' id='dept_code' value='"+deptcode+"'><input type='hidden' name='facility_id' id='facility_id' value='"+opfacilityid+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.querydept.submit();
	}

		var opt=parent.frames[1].document.createElement("Option");
		opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
		opt.value="";
		parent.frames[1].document.getElementById('section_code').add(opt);


}
function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

//	alert("length:-"+length);

var element = f_query_add_mod.document.subserviceinfacility_form.document.createElement('OPTION');
    element.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
    element.value=""; 

	
        for(i=1;i<length;i++)
            object.remove(1);   

}



