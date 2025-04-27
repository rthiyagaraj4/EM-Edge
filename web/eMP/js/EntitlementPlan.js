function create()
{
	f_query_add_mod.location.href='../../eMP/jsp/AddModifyEntitlementPlan.jsp' ;
}

function chkForLocn(obj)
{	
	 if (obj.value != '2')
	 {
		 document.entitlement_plan_form.facility.value = "";
		 document.entitlement_plan_form.location_type.value = '';
		 document.entitlement_plan_form.facility.disabled = true;
		 document.entitlement_plan_form.location_type.disabled = true;
		 document.getElementById('facility_img').style.visibility = "hidden";
 		 document.getElementById('location_type_img').style.visibility = "hidden";
	 }
	 else
	{
		 document.entitlement_plan_form.facility.value = document.entitlement_plan_form.login_facility.value;
		 document.entitlement_plan_form.facility.disabled = false;
		 document.entitlement_plan_form.location_type.disabled = false;
		 document.getElementById('facility_img').style.visibility = "visible";
		 document.getElementById('location_type_img').style.visibility = "visible";
	}
}

function searchPatCat()
{

	var patient_category = document.entitlement_plan_form.patient_category.value;
	var entitlement_by	 = document.entitlement_plan_form.entitlement_by.value;
	var facility				 = document.entitlement_plan_form.facility.value;
	var location_type		 = document.entitlement_plan_form.location_type.value;
	var patient_class		 = document.entitlement_plan_form.pat_class_val.value;
	var ip_install_yn		 = document.entitlement_plan_form.ip_install_yn.value;
	var op_install_yn		 = document.entitlement_plan_form.op_install_yn.value;
	var resultString = "../../eMP/jsp/EntitlementPlanResult.jsp?patient_category="+patient_category+"&entitlement_by="+entitlement_by+"&facility="+facility+"&location_type="+location_type+"&patient_class="+patient_class+"&ip_install_yn="+ip_install_yn+"&op_install_yn"+op_install_yn;
	var msgFrame=parent.parent.messageFrame;

	if  ( entitlement_by=='2' )
	{
		 var fields = new Array (document.entitlement_plan_form.patient_category,document.entitlement_plan_form.facility,document.entitlement_plan_form.location_type);			    
		 var names = new Array (getLabel("Common.category.label","Common"), getLabel("Common.facility.label","Common"), getLabel('Common.locationtype.label','common'));	
		 if (parent.frames[0].checkFieldsofMst( fields, names, msgFrame))
		 {
			parent.frames[1].location.href=resultString;
			msgFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ;
		 }
		 else
			parent.frames[1].location.href='../../eCommon/html/blank.html';
	}
	else
	if  ( entitlement_by=='1' )
	{
		 var fields = new Array (document.entitlement_plan_form.patient_category,document.entitlement_plan_form.entitlement_by,document.entitlement_plan_form.pat_class_val);			    
		  var names = new Array (getLabel("Common.category.label","Common") , getLabel('eMP.EntitlementBy.label','MP'), getLabel('Common.patientclass.label','common'));
		 if (parent.frames[0].checkFieldsofMst( fields, names, msgFrame))
		 {
			  parent.frames[1].location.href=resultString;
			  msgFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ;
		  }
		  else
			  parent.frames[1].location.href='../../eCommon/html/blank.html';
	}
	else
	{
		  var fields = new Array (document.entitlement_plan_form.patient_category,document.entitlement_plan_form.entitlement_by);			    
		  var names = new Array (getLabel("Common.category.label","Common") , getLabel('eMP.EntitlementBy.label','MP'));	
		  if (parent.frames[0].checkFieldsofMst( fields, names, msgFrame))
		  {
			  parent.frames[1].location.href=resultString;
			  msgFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ;
		  }
		  else
			  parent.frames[1].location.href='../../eCommon/html/blank.html';
	}
}

function chkInclude(obj)
{
	if (obj.checked==true)
		obj.value='Y';
	else
		obj.value='N' ;
}

function reset()
{
	var url = parent.frames[1].frames[1].location.href;
	if  (url.indexOf('EntitlementPlanQueryResult.jsp')!=-1)
	{
		parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
	}
	else
	{
		f_query_add_mod.location.reload();
		//parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp' ;
	}
}

function apply()
{
	var url = f_query_add_mod.location.href;
	if  ( (url.indexOf('EntitlementPlanQueryResult.jsp')!=-1) || (url.indexOf('EntitlementPlanQueryCriteria.jsp')!=-1) || (url.indexOf('blank.html')!=-1))
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
	}
	else
	{	
		
		if(frames[1].document.EntiltlementQueryReult)
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
		}
		else if (frames[1].frames[1].document.entitlement_plan_result_form)
		{
		   var fields = new Array (frames[1].frames[1].document.entitlement_plan_result_form.appl_to_all);	 
		   var names = new Array (getLabel('Common.ApplicableTo.label','common'));
		   if (frames[1].frames[1].checkFieldsofMst( fields, names, messageFrame))
		   {	frames[1].frames[1].document.entitlement_plan_result_form.submit();
			}
		}
		else 
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
	}
}

function onSuccess()
{
	self.frames[1].frames[0].location	.reload();
	self.frames[1].frames[1].location	.href='../../eCommon/html/blank.html';
}

function clearVal()
{
	parent.frames[1].location	.href='../../eCommon/html/blank.html';
}

function query()
{
    f_query_add_mod.location.href="../../eMP/jsp/EntitlementPlanQueryCriteria.jsp";
}

function chgdOption(obj)
{
	 if (obj.name=='patient_category')
	 {
		 	 document.entitlement_plan_form.entitlement_by.value = '';
			 document.entitlement_plan_form.facility.value = "";
			 document.entitlement_plan_form.location_type.value = '';
			 document.entitlement_plan_form.facility.disabled = true;
			 document.entitlement_plan_form.location_type.disabled = true;
			 document.getElementById('facility_img').style.visibility = "hidden";
			 document.getElementById('location_type_img').style.visibility = "hidden";
			 document.entitlement_plan_form.location_type.value = ''; 
			 document.entitlement_plan_form.pat_class_val.value = ''; 
	 }
	 else
	 if (obj.name=='entitlement_by')
	 {
		  	 document.entitlement_plan_form.facility.value = "";
			 document.entitlement_plan_form.location_type.value = '';
			 document.entitlement_plan_form.pat_class_val.value = '';
			 document.entitlement_plan_form.facility.disabled = true;
			 document.entitlement_plan_form.location_type.disabled = true;
			 document.getElementById('facility_img').style.visibility = "hidden";
			 document.getElementById('location_type_img').style.visibility = "hidden";
			 if (document.entitlement_plan_form.entitlement_by.value=='1')
			 {
				 document.getElementById('pat_class_leg').style.visibility = "visible";
				 document.getElementById('pat_class_list').style.visibility = "visible";
			 }
			 else
			{	  				 
				 document.getElementById('pat_class_val').value = "";
				 document.getElementById('pat_class_leg').style.visibility = "hidden";
				 document.getElementById('pat_class_list').style.visibility = "hidden";
			}
  		     document.entitlement_plan_form.location_type.value = '';
	 }
	 else
	 if (obj.name=='facility')
	 {
			 document.entitlement_plan_form.location_type.value = '';
	 }
	 
	 parent.frames[1].location	.href='../../eCommon/html/blank.html';

}

function chkAll(obj)
{
	if (obj.value=='N')
	{
		parent.frames[1].document.body.scroll="auto";
		parent.frames[1].document.getElementById('result_tab1').style.visibility='visible';
	}
	else
	{
		parent.frames[1].document.body.scroll="no";
		parent.frames[1].document.getElementById('result_tab1').style.visibility='hidden';
	}
}

function Scrollheader()
{
	  var x = document.body.scrollTop;
	  if(x == 0)
	  {
		   document.getElementById('first_table').style.position='static';
		   document.getElementById('first_table').style.posTop  = 0;
		   document.getElementById('head1').style.position='static';
		   document.getElementById('head1').style.posTop  = 0;				
		   document.getElementById('head2').style.position='static';
		   document.getElementById('head2').style.posTop  = 0;		
	  }else
	  {
			document.getElementById('first_table').style.position = 'relative';
			document.getElementById('first_table').style.posTop  = x-2;
			document.getElementById('head1').style.position = 'relative';
			document.getElementById('head1').style.posTop  = x-5;		
			document.getElementById('head2').style.position = 'relative';
			document.getElementById('head2').style.posTop  = x-5;		
	  }
}

function selectAllFunc(obj)
{
	var entitlement_criteria = document.getElementById('entitlement_criteria').value;
	var count = parseInt(document.getElementById('totalCount').value);
	var item = "";
	 if (entitlement_criteria=='1')
	 {
		 item = "Incl_sp_";
	 }
	 else
	 if (entitlement_criteria=='2')
	 {
		 item = "Incl_lc_";
	 }
	 else
	 if (entitlement_criteria=='3')
	 {
		 item = "Incl_bclass_";
	 }
	if (obj.checked==true)
	{
		for (var i=0;i<count;++i )
		{
		   eval("document.forms[0]."+item+i+".checked=true");
   	   	   eval("document.forms[0]."+item+i+".value='Y'");
		} 
	}
	else
	{
		for (var i=0;i<count;++i )
		{
		   eval("document.forms[0]."+item+i+".checked=false");
   	   	   eval("document.forms[0]."+item+i+".value='N'");
		} 
	}
}

/*Function to check all the values in page if all are selected "Select All" will be selected*/
function chkDBForAll()
{
	var entitlement_criteria = document.getElementById('entitlement_criteria').value;
	var count = parseInt(document.getElementById('totalCount').value);
	var item = "";
	var bool = true;
	 if (entitlement_criteria=='1')
	 {
		 item = "Incl_sp_";
	 }
	 else
	 if (entitlement_criteria=='2')
	 {
		 item = "Incl_lc_";
	 }
	 else
	 if (entitlement_criteria=='3')
	 {
		 item = "Incl_bclass_";
	 }
	 for (var i=0;i<count;++i )
	 {
	   if(eval("document.forms[0]."+item+i)!=null)
		{
			if (!eval("document.forms[0]."+item+i+".checked"))
			{
				bool=false;
				break;
			}
		}
	}
	if (bool == true)
	{
	   document.getElementById('selectAll').checked=true;
	   document.getElementById('selectAll').value='Y';
	}
	else
	{
	   document.getElementById('selectAll').checked=false;
	   document.getElementById('selectAll').value='N';
	}
}
