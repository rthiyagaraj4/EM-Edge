function create() 
{
	f_query_add_mod.location.href = "../../eOP/jsp/addModifyVTForClinic.jsp" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eOP/jsp/queryVisitTypeForClinicPage.jsp?function=VisitTypeforClinic" ;
}

function clearList()
{

parent.f_query_add_mod.document.forms[0].clinic.value="";    
parent.f_query_add_mod.document.forms[0].clinic1.value="";   
//spec_code=parent.frame1.manage_patient.Qspeciality.value;    

}

async function onBlurgetLoc(fac_id,objval,target)
{ 

		if(target.value == "")
		{   
			target.value="";
			document.forms[0].clinic.value="";
			return;
		}

await getLocn(fac_id,objval,target);

}

async function getLocn(fac_id,objval,target)
{
	//alert("2");
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	

   if(objval!="")	
   {
	 
   var index=parent.f_query_add_mod.document.forms[0].location.selectedIndex;
	
   var loctypeval=parent.frames[1].document.forms[0].location.options[index].value;
   var care_ind;
				
   if(index != 0)
	   care_ind=careArray[index];
   else
         care_ind="";
   }	
  
   tit=getLabel('Common.Location.label','Common');

   sql ="Select clinic_code code, long_desc description from op_clinic where (care_locn_type_ind='"+care_ind+"') and facility_id='"+fac_id+"' and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+objval+"') and eff_status='E' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";	
   

  				
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );			
				
				
				if(retVal != null && retVal != "" )
                {

	             var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];					
				document.forms[0].clinic.value=arr[0];
				fetchVals(document.forms[0],target);

          }
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

	var names = new Array (getLabel('Common.clinic.label','Common'),getLabel('Common.visittype.label','Common') );

		if(f_query_add_mod.document.facility_form.function_name.value=="insert")
		{
				fields[2]=f_query_add_mod.document.facility_form.indicator
				names[2]=getLabel("eOP.ApplicableVisitTypeIndicator.label","Op");
		}
		
		if(f_query_add_mod.s( fields, names, messageFrame))
		{
			f_query_add_mod.document.facility_form.submit();
		}

}

function onSuccess()
{
	if(f_query_add_mod.document.facility_form.function_name.value=="insert")
		{
	 		f_query_add_mod.location.href = "../../eOP/jsp/addModifyVTForClinic.jsp" ;
	    }
	else
		f_query_add_mod.location.reload() ;
	}

function reset() {

  if(f_query_add_mod.location.href.indexOf("queryVisitTypeForClinic.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;
}

// JS functions in AddModifyVTForClinic.jsp

	function chkMaxApptDuration(obj)
		{
			chkForDecimal(obj);
			chkForNumber(obj);
			chkForMaxValue(obj);
		}
	function chkForNumber(obj)
		{
		var val=obj.value;
		if(isNaN(val))
			{
				var msg=getMessage('NUM_ALLOWED','SM');
				parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
				obj.select();
				obj.focus();
				return false;
			}
			else
				return true;
		}
	function chkForMaxValue(obj)
	{
		if(obj.value > 1440 )
		{
			var msg=getMessage('MAX_VALUE_1440','OP');
			alert(msg);
			obj.value = '';
			obj.focus();
			return ;
		}
	}
function getdfltvalue(obj)
		{
			var arr =new Array();
			if (obj.value!="")
			{
			arr=obj.value.split('$');
           
			if (arr[0]!=0) 
               parent.frames[1].document.forms[0].max_appt_duration.value = arr[0];
			else
				parent.frames[1].document.forms[0].max_appt_duration.value ="";
			if (arr[1]!=0) 
		        parent.frames[1].document.forms[0].max_appt_slots.value = arr[1];
			else
				parent.frames[1].document.forms[0].max_appt_slots.value = "";
			}
			else
			{
				parent.frames[1].document.forms[0].max_appt_duration.value ="";
				parent.frames[1].document.forms[0].max_appt_slots.value = "";
			}
		}
		function chkForDecimal(obj)
		{
			
				var dec = "+.-";
				var j;
				var ch1;
				var objlen = (obj.value).length;
				var i;
				var ch;
				for (j=0; j<dec.length; j++)
				{
					ch1 = dec.charAt(j);
					for( i=0; i < objlen; i++)
					{
						ch = (obj.value).charAt(i);
						if(ch == ch1)
						{
							var msg=getMessage('NUM_ALLOWED','SM');
							parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
							obj.select();
							obj.focus();
							return false;
						}								
					}
				}
		}
function fetchVals(form,current)
		{ 
		    
	       	var fucn=parent.f_query_add_mod.document.forms[0].function_name.value;
			var procid=parent.f_query_add_mod.document.forms[0].pfunction.value;
			var name=current.name;
			var value=facility_form.clinic.value;
			var applind="";	
			var isAERegisterTypeAutoUpdateAppl=""; // added by mujafar for KDAH-CRF-0526
			
			if(procid=="visit_type_for_proc_unit")
			         {
				  var index=parent.f_query_add_mod.document.forms[0].location.selectedIndex;
			      var loctypeval=parent.f_query_add_mod.document.forms[0].location.options[index].value;
				  var care_ind;
					
					if(index != 0)
					   care_ind=careArray[index];
					else
						care_ind="";
			 
					 }	
					if(procid=="visit_type_for_proc_unit")
			         {
					  if(name=='clinic1'){						  
					    if(value=="")removeitems(form.vitalsignsb);
					  }
					 }
					if(fucn=="insert")
			            {
						//if(name=='location')
						//	removeitems(form.clinic);
						if(name=='clinic1')
				        {    
							 removeitems(form.indicator);
							 removeitems(form.visittype);
						if(procid!="") removeitems(form.vitalsignsb);
			  			   parent.f_query_add_mod.document.forms[0].max_appt_duration.value ="";
							parent.f_query_add_mod.document.forms[0].max_appt_slots.value = "";
						}
						
				if(name=="indicator")
					{
						
						applind= form.indicator.value;						
						removeitems(form.visittype);
						parent.f_query_add_mod.document.forms[0].max_appt_duration.value ="";
						parent.f_query_add_mod.document.forms[0].max_appt_slots.value = "";

					}
			}
                    var fid=parent.f_query_add_mod.document.forms[0].facilityId.value;
					radApplYn = parent.f_query_add_mod.document.forms[0].radApplYn.value;
					isAERegisterTypeAutoUpdateAppl = parent.f_query_add_mod.document.forms[0].isAERegisterTypeAutoUpdateAppl.value; // added by mujafar for KDAH-CRF-0526
					var ccode=form.clinic.value;				
					var install=form.or_install_yn.value;
					var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey();'>";
					HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eOP/jsp/FetchVal.jsp'>";
					HTMLVal = HTMLVal +"<input name='name' id='name' type='hidden' value= '"+name + " '><input name='value' id='value' type='hidden' value='"+value + "'>";
					HTMLVal = HTMLVal +"<input name='fid' id='fid' type='hidden' value='"+fid + "'>";
					HTMLVal = HTMLVal +"<input name='ccode' id='ccode' type='hidden' value='"+ccode+ "'>";
					HTMLVal = HTMLVal +"<input name='function' id='function' type='hidden' value='"+fucn+"'>";	
					HTMLVal = HTMLVal +"<input name='applind' id='applind'  type='hidden'  value='"+applind+"'>";
					HTMLVal = HTMLVal +"<input name='install' id='install'  type='hidden'  value='"+install+"'>";
					HTMLVal = HTMLVal +"<input name='care_ind' id='care_ind'  type='hidden'  value='"+care_ind+"'>";
                    HTMLVal = HTMLVal +"<input name='proid' id='proid'  type='hidden'  value='"+procid+"'>";
					HTMLVal=HTMLVal+"<input name='loctypeval' id='loctypeval'  type='hidden' value='"+loctypeval+"'>";
					HTMLVal=HTMLVal+"<input name='radApplYn' id='radApplYn'  type='hidden' value='"+radApplYn+"'>";
					HTMLVal=HTMLVal+"<input name='isAERegisterTypeAutoUpdateAppl' id='isAERegisterTypeAutoUpdateAppl'  type='hidden' value='"+isAERegisterTypeAutoUpdateAppl+"'>";
					HTMLVal = HTMLVal +"</form></BODY></HTML>";

					parent.messageFrame.document.write(HTMLVal);					
					//parent.messageFrame.document.form1.submit();
					if(parent.messageFrame.document.form1){
						parent.messageFrame.document.form1.submit();
					}else{
						fetchVals(form,current);
					}
					
       	}
function removeitems(obj)
		{
			var len=obj.length;
			var i=1;
			while(i<len)
			{
				len=obj.length
				obj.remove(i)
			}

		}		

