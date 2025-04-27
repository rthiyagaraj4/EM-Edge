function create() 
{
	f_query_add_mod.location.href = "../../eOP/jsp/InsertPClinic.jsp?call_func=Resource_unit" ;
}
function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eOP/jsp/queryResourceForProcedureUnitPage.jsp?function=Resource_unit" ;
}
function onBlurgetLoc(fac_id,unittype,target)
{

		
		if(target.value == "")
		{
			target.value="";
			document.forms[0].res_unit.value="";

			return;
		}

 getLocn(fac_id,unittype,target);

}

async function getLocn(fac_id,unittype,target)
{
	if(parent.f_query_add_mod.document.getElementById('res_class').disabled==true)
		parent.f_query_add_mod.document.getElementById('res_class').disabled=false;
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	   
  
   tit=getLabel('Common.Location.label','Common');

			if(unittype=="C")
			{
				sql="select clinic_code code, long_desc description from op_clinic where care_locn_type_ind='C' and facility_id='"+fac_id+"' and eff_status='E' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc";	
				
			}
			else if(unittype=="E")
			{
				sql="select clinic_code code, long_desc description from op_clinic where care_locn_type_ind='E' and facility_id='"+fac_id+"' and eff_status='E' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc";

			}
			else if(unittype=="Y")
			{
				sql="select clinic_code code, long_desc description from op_clinic where care_locn_type_ind='D' and facility_id='"+fac_id+"' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
			}		
			else {

				sql="select clinic_code code, long_desc description from op_clinic where care_locn_type_ind='' and facility_id='"+fac_id+"' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
			}
   
			// sql ="Select clinic_code code, long_desc description from op_clinic where (care_locn_type_ind='"+care_ind+"') and facility_id='"+fac_id+"' and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+objval+"') and eff_status='E' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";	
   
			
  				
				argumentArray[0] =sql;
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
				document.forms[0].res_unit.value=arr[0];
                GetValues(target);

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
	
			
	window.frames[1].document.forms[0].unit_type.disabled=false;
    window.frames[1].document.forms[0].res_unit1.disabled=false;
	window.frames[1].document.forms[0].res_type.disabled=false;
	window.frames[1].document.forms[0].res_class.disabled=false;
	window.frames[1].document.forms[0].res_name.disabled=false;
	//f_query_add_mod.document.clinic_form.res_type.disabled=false;

		var fields = new Array(f_query_add_mod.document.forms[0].unit_type,f_query_add_mod.document.forms[0].res_unit,f_query_add_mod.document.forms[0].res_class,f_query_add_mod.document.forms[0].res_id);

		var names= new Array(getLabel("Common.locationtype.label","Common"),getLabel("eOP.Location.label","Op"),getLabel("Common.resourceclass.label","Common"),getLabel("Common.resourcename.label","Common"));

	

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		f_query_add_mod.document.clinic_form.submit();
		var fn_status = f_query_add_mod.document.clinic_form.function_name.value ;
	}

}

function onSuccess()
{
	f_query_add_mod.location.reload();
	
}
function reset()
{
	
	  if(f_query_add_mod.location.href.indexOf("queryResourceForProcedureUnit.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;

}
function clearpract(obj)
{
	parent.frames[1].document.forms[0].res_name.value="";
	parent.frames[1].document.forms[0].res_id.value="";

}

function GetValues(obj)
{
	//if(obj.value!="D")
	       ClearList(obj);
	var funcid=parent.frames[1].document.forms[0].function_name.value ;
	var carelocntype="";
	
	if(parent.frames[1].document.forms[0].res_class.disabled==true)
		parent.frames[1].document.forms[0].res_class.disabled=false;
	
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popall' id='popall' method='post' action='../../eOP/jsp/PractitionerForClinicMain.jsp'>";
		if(obj.name == "unit_type")
		{
				
			if(obj.value=="Y")
			{
				/*var length=parent.frames[1].document.forms[0].res_unit.length;
			  for(i=0;i<length;i++)
				  parent.frames[1].document.forms[0].res_unit.remove(1);*/
              
              
              var length=parent.frames[1].document.forms[0].res_class.length;
			/*  for(i=0;i<length;i++)
				  parent.frames[1].document.forms[0].res_class.remove(1);*/

			 
			  var opt=parent.frames[1].document.createElement("OPTION");
			  var opt1=parent.frames[1].document.createElement("OPTION");
			  var opt2=parent.frames[1].document.createElement("OPTION");
			//  var opt1=parent.frames[1].document.createElement("OPTION");
			  opt.text=getLabel("Common.room.label","Common");
			  opt.value="R";
			  opt1.text=getLabel("Common.equipment.label","Common");
			  opt1.value="E";
			  opt2.text=getLabel("Common.other.label","Common");
			  opt2.value="O";
			  parent.frames[1].document.forms[0].res_class.add(opt);
			  parent.frames[1].document.forms[0].res_class.add(opt1);
			  parent.frames[1].document.forms[0].res_class.add(opt2);
			 /* opt1.text="Room";
			  opt1.value="R";
			  opt1.selected=true;
			  parent.frames[1].document.forms[0].res_type.add(opt1);*/

			  carelocntype="D";
			}else
			{
				
				var length=parent.frames[1].document.forms[0].res_class.length;
			  for(i=0;i<length;i++)
				  parent.frames[1].document.forms[0].res_class.remove(1);

				var opt=parent.frames[1].document.createElement("OPTION");
			  var opt1=parent.frames[1].document.createElement("OPTION");
			  var opt2=parent.frames[1].document.createElement("OPTION");
			  var opt3=parent.frames[1].document.createElement("OPTION");
			  opt.text=getLabel("Common.practitioner.label","Common");
			  opt.value="P";
			  opt1.text=getLabel("Common.room.label","Common");
			  opt1.value="R";
			  opt2.text=getLabel("Common.equipment.label","Common");
			  opt2.value="E";
			  opt3.text=getLabel("Common.other.label","Common");
			  opt3.value="O";
			  parent.frames[1].document.forms[0].res_class.add(opt);
			  parent.frames[1].document.forms[0].res_class.add(opt1);
			  parent.frames[1].document.forms[0].res_class.add(opt2);
			  parent.frames[1].document.forms[0].res_class.add(opt3);

			  if(obj.value == "C")
				{
				  carelocntype="C";
				}
				else
				{
					carelocntype="E";
				}
				
			}
             
			parent.frames[1].document.forms[0].reslookup_butt.disabled=true;
			parent.frames[1].document.forms[0].res_name.readOnly=true;
			


			HTMLVal+= "<input name='unittype' id='unittype' type='hidden' value='"+obj.value + "'><input name='carelocntype' id='carelocntype' type='hidden' value='"+carelocntype+"'><input name='step' id='step' type='hidden' value='1'>";
		}		
		else if(obj.name == "res_class")
		{
			parent.frames[1].document.forms[0].res_name.value="";
			parent.frames[1].document.forms[0].res_id.value="";
			var unit=parent.frames[1].document.forms[0].unit_type.value;
			if(unit == "C")
			{
				carelocntype="C";
			}
			else if(unit == "E")
			{
				carelocntype="E";
			}
			else
			{
				carelocntype="D";
			}
			var resunit=parent.frames[1].document.forms[0].res_unit.value;
			
			if(obj.value != "" && unit!="" && resunit!="")
			{
				parent.frames[1].document.forms[0].reslookup_butt.disabled = false;
				parent.frames[1].document.forms[0].res_name.disabled = false;

			}
			else
			{
				parent.frames[1].document.forms[0].reslookup_butt.disabled = true;
				parent.frames[1].document.forms[0].res_name.disabled = true;
			}
			HTMLVal+= "<input name='resourceclass' id='resourceclass' type='hidden' value='"+obj.value + "'><input name='step' id='step' type='hidden' value='2'><input name='res_unit' id='res_unit' type='hidden' value='"+parent.frames[1].document.forms[0].res_unit.value+"' ><input name='carelocntype' id='carelocntype' type='hidden' value='"+carelocntype+"'>";

		
		}
		else if(obj.name =="res_unit1")
		{
			if(parent.frames[1].document.forms[0].unit_type.value=="Y")
			{
			parent.frames[1].document.forms[0].reslookup_butt.disabled=false;
			parent.frames[1].document.forms[0].res_name.readOnly=false;
			carelocntype="D";

			}else
				{
			parent.frames[1].document.forms[0].reslookup_butt.disabled=true;
			parent.frames[1].document.forms[0].res_name.readOnly=true;
				if(parent.frames[1].document.forms[0].unit_type.value == "C")
				{
					carelocntype="C";
				}
				else
				{
					carelocntype="E";
				}
			}

			var value=document.forms[0].res_unit.value;			
		
			HTMLVal+= "<input name='resourceunit' id='resourceunit' type='hidden' value='"+value + "'><input name='unittype' id='unittype' type='hidden' value='"+parent.frames[1].document.forms[0].unit_type.value+ "'><input name='callfunc' id='callfunc' type='hidden' value='"+parent.frames[1].document.forms[0].call_function.value+ "'><input name='step' id='step' type='hidden' value='3'> <input type='hidden' name='fun_name' id='fun_name' value='"+funcid+"'><input name='carelocntype' id='carelocntype' type='hidden' value='"+carelocntype+"'>";
			
		}

		
		HTMLVal+= "</form></body></html>";

		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.popall.submit();



}

function ClearList(obj)
{

//alert(obj.name);
	var unitval=parent.frames[1].document.forms[0].unit_type.value;
    
    if(obj.name == "unit_type")
	{
	
		
		if(obj.value=="Y")
			{
              var length=parent.frames[1].document.forms[0].res_class.length;
			  for(i=0;i<length;i++)
				  parent.frames[1].document.forms[0].res_class.remove(1);
			
			}
		
		
		var length  =parent.frames[1].document.forms[0].res_type.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].res_type.remove(1);
		 
		}		
		/*var length  =parent.frames[1].document.forms[0].res_unit.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].res_unit.remove(1);
		}*/
		
		parent.frames[1].document.forms[0].res_unit.value="";
		parent.frames[1].document.forms[0].res_unit1.value="";
		 

		parent.frames[1].document.forms[0].res_name.value="";
		parent.frames[1].document.forms[0].res_class.options[0].selected=true;
		for(i=1;i<=5;i++)
		{
			
			for(j=1;j<=7;j++)
			{
				parent.frames[1].document.getElementById("pract_week_appl_day_"+j).value="W";				
				parent.frames[1].document.getElementById("pract_working_week_"+i+"_day_"+j).value="N";
				parent.frames[1].document.getElementById("pract_working_week_"+i+"_day_"+j).checked=false;
				parent.frames[1].document.getElementById("pract_working_week_"+i+"_day_"+j).disabled=true;
				
				parent.frames[1].document.forms[0].follow.checked=true;
				parent.frames[1].document.forms[0].follow.disabled=false;
				parent.frames[1].document.forms[0].routine.checked=true;
				parent.frames[1].document.forms[0].routine.disabled=false;
				parent.frames[1].document.forms[0].series.checked=true;
				parent.frames[1].document.forms[0].series.disabled=false;
				parent.frames[1].document.forms[0].consult.checked=true;
				parent.frames[1].document.forms[0].consult.disabled=false;
				parent.frames[1].document.forms[0].emergency.checked=false;
                parent.frames[1].document.getElementById("working_week_"+i+"_day_"+j).checked=false;
                document.getElementById("week_appl_day_"+j).innerHTML="Specific";

			}
			

		}
	}
	else if(obj.name =="res_class")
	{
		var length  =parent.frames[1].document.forms[0].res_type.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].res_type.remove(1);
		}

	}
	else if(obj.name =="res_unit1" && unitval!="Y")
	{
		parent.frames[1].document.forms[0].res_name.value ="";
		parent.frames[1].document.forms[0].res_id.value ="";
		var length  =parent.frames[1].document.forms[0].res_class.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].res_class.remove(1);
		}
		var length  =parent.frames[1].document.forms[0].res_type.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].res_type.remove(1);
		}
		for(i=1;i<=5;i++)
		{
			for(j=1;j<=7;j++)
			{
				
				parent.frames[1].document.getElementById("pract_week_appl_day_"+j).value="W";				
				parent.frames[1].document.getElementById("pract_working_week_"+i+"_day_"+j).value="N";
				parent.frames[1].document.getElementById("pract_working_week_"+i+"_day_"+j).checked=false;
				parent.frames[1].document.getElementById("pract_working_week_"+i+"_day_"+j).disabled=true;
				parent.frames[1].document.forms[0].follow.checked=true;
				parent.frames[1].document.forms[0].follow.disabled=false;
				parent.frames[1].document.forms[0].routine.checked=true;
				parent.frames[1].document.forms[0].routine.disabled=false;
				parent.frames[1].document.forms[0].series.checked=true;
				parent.frames[1].document.forms[0].series.disabled=false;
				parent.frames[1].document.forms[0].consult.checked=true;
				parent.frames[1].document.forms[0].consult.disabled=false;
				parent.frames[1].document.forms[0].emergency.checked=false;
                parent.frames[1].document.getElementById("working_week_"+i+"_day_"+j).checked=false;
                document.getElementById("week_appl_day_"+j).innerHTML="Specific";
           }
		}
	}
}

function onblurres()
{
	if(parent.frames[1].document.forms[0].res_name.value != "" && parent.frames[1].document.forms[0].res_class.value != "")
	{
		resourcenamelookup();
	}else
	{
	parent.frames[1].document.forms[0].res_name.value="";
    parent.frames[1].document.forms[0].res_id.value="";
	}
}

async function resourcenamelookup()
{
	var facilityid=parent.frames[1].document.forms[0].fac_id.value;
	var unittype=parent.frames[1].document.forms[0].unit_type.value;
	var restype=parent.frames[1].document.forms[0].res_type.value;
	var resunit=parent.frames[1].document.forms[0].res_unit.value;
	var resclass=parent.frames[1].document.forms[0].res_class.value;
	var sql="";
	
			var tit				= getLabel("Common.resourcename.label","Common");
			var retVal			= new String();
			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;


			if(resclass=="P")
			{
				getPract(parent.frames[1].document.forms[0].reslookup_butt,parent.frames[1].document.forms[0].res_name);
			}
			else
			{
					if(resclass=="R")
					{	
						if(unittype=="Y")
						sql="select a.room_num code,a.short_desc description from am_facility_room a where a.operating_facility_id='"+facilityid+"' and a.resident_stay_yn = 'D' and a.room_type=nvl('"+restype+"',a.room_type) and a.eff_Status='E' and upper(a.room_num) like upper(?) and upper(a.short_desc)  like upper(?) ";
						else
						sql="select a.room_num code,a.short_desc description from am_facility_room a where a.operating_facility_id='"+facilityid+"' and a.resident_stay_yn = 'N' and a.room_type=nvl('"+restype+"',a.room_type) and a.eff_Status='E' and upper(a.room_num) like upper(?) and upper(a.short_desc)  like upper(?) ";
					
					}
					else if(resclass=="E" || resclass=="O")
					{
						if(parent.frames[1].document.forms[0].rd_appl_yn.value=="Y" && resclass=="E" ){
							sql="select a.resource_id code,a.short_desc description from am_resource a  where a.resource_class='"+resclass+"' and a.resource_type= nvl('"+restype+"',a.resource_type) and  a.facility_id='"+facilityid+"' and rd_appl_yn = 'Y' and a.eff_Status='E' and upper( a.resource_id) like upper(?) and upper(a.short_desc)  like upper(?) "
						}else{
						sql="select a.resource_id code,a.short_desc description from am_resource a  where a.resource_class='"+resclass+"' and a.resource_type= nvl('"+restype+"',a.resource_type) and  a.facility_id='"+facilityid+"' and a.eff_Status='E' and upper( a.resource_id) like upper(?) and upper(a.short_desc)  like upper(?) "
						}
					}
					

					
					argumentArray[0]	= sql;
					argumentArray[1]	= dataNameArray ;
					argumentArray[2]	= dataValueArray ;
					argumentArray[3]	= dataTypeArray ;
					argumentArray[4]	= "1,2";
					argumentArray[5]	= parent.frames[1].document.forms[0].res_name.value;
					argumentArray[6]	= DESC_LINK;
					argumentArray[7]	= DESC_CODE;

					

					retVal = await CommonLookup( tit, argumentArray );

					if(retVal != null && retVal != "" )
					{
						var ret1=unescape(retVal);
						
						arr=ret1.split(",");
						parent.frames[1].document.forms[0].res_name.value=arr[1];
						parent.frames[1].document.forms[0].res_id.value=arr[0];
						
					}
					else
					{
						parent.frames[1].document.forms[0].res_name.value="";
						parent.frames[1].document.forms[0].res_id.value="";
					}
			}
}


function getPract(target_id,target_name)
{

	
		var callfunc=parent.frames[1].document.forms[0].call_function.value;
		if(parent.frames[1].document.forms[0].res_name.readOnly==true)
			return;
					
		var facilityid = parent.frames[1].document.forms[0].fac_id.value;
		var clinic_code = parent.frames[1].document.forms[0].res_unit.value;
		var res_type=parent.frames[1].document.forms[0].res_type.value;

		var speciality_code = "";
		if(parent.frames[1].document.forms[0].speciality_code)
			speciality_code = parent.frames[1].document.forms[0].speciality_code.value;
					 
		if(!target_name)
			target_name=parent.frames[1].document.forms[0].res_name;
		if(!target_name.value)
			target_name.value="";

		/*target_name.value=trimString(target_name.value);
		
		var practitionerName=target_name.name;
		var practitionerValue=target_name.value;*/

		 //and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id )) and nvl(c.pract_type, b.pract_type) = b.pract_type

		getPractitioner(target_id,target_name,facilityid,speciality_code,'',clinic_code,'',callfunc,res_type,'',"Q7");
					  
		/*var sql = "Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'";
		if(callfunc == "Resource_unit")
		{
			sql+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		}
		sql+=" and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ";	
		
		var sqlSecond="Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'";
		if(callfunc == "Resource_unit")
		{
			sqlSecond+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		}
		sqlSecond+="and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ";	
			
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practitionerName + "\""	;
		xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);*/

}

/*
  This function is used to retrieve the practitioner name.
  This function called in an intermediate jsp --callGeneralPractitionerSearch.jsp
*/
function PractLookupRetVal(retVal,objName)
{
	var arr;
	var callfunc=parent.frames[1].document.forms[0].call_function.value;
	if (retVal != null)
		{
			arr=retVal.split("~");
		
				parent.frames[1].document.forms[0].res_id.value=arr[0];
				parent.frames[1].document.forms[0].res_name.value=arr[1];
							
		}
		else
		{
			
				parent.frames[1].document.forms[0].res_id.value="";
				parent.frames[1].document.forms[0].res_name.value="";
							
		}
}	

function assigndays(obj)
{
	
	
	if (obj.checked==true)
	{
		obj.value='W';
		parent.frames[1].document.getElementById(obj.name+"1").value="W";	
	
	}
	else
	{
		obj.value = 'N';
		parent.frames[1].document.getElementById(obj.name+"1").value="N";	
	}
}
function assignval(obj)
{
	if(obj.name != "active")
	{
		if (obj.checked==true)
		{
			obj.value='Y';
			parent.f_query_add_mod.document.getElementById(obj.name+"1").value="Y";	
		}
		else
		{
			obj.value='N';
			parent.f_query_add_mod.document.getElementById(obj.name+"1").value="N";	
		}

	}
	else
	{
		if (obj.checked==true)
		{
			obj.value='E';			
		}
		else
		{
			obj.value='D';			
		}
	}
}

function unittypemodify(unitval)
{
	parent.frames[1].document.forms[0].unit_type.value=unitval;
	parent.frames[1].document.forms[0].unit_type.disabled=true;
}


function resclassmod(resclass)
{
	parent.frames[1].document.forms[0].res_class.value=resclass;
	parent.frames[1].document.forms[0].res_class.disabled=true;
}

function chekUnchek(obj,ival)
{
    var sname=obj.name;
	if(obj.value=="A")
	{
		for(j=1;j<=5;j++)
		{
		if(document.getElementById('pract_working_week_'+j+'_day_'+ival).disabled==false)
			{
				document.getElementById('pract_working_week_'+j+'_day_'+ival).checked=true;
				document.getElementById('pract_working_week_'+j+'_day_'+ival).value='W';
				document.getElementById('pract_working_week_'+j+'_day_'+ival+'1').value='W';
			}
		}
	}
	else if(obj.value=="W")
	{	

		for(j=1;j<=5;j++)
		{
			if(document.getElementById("pract_working_week_"+j+"_day_"+ival).disabled==false)
			{
				document.getElementById('pract_working_week_'+j+'_day_'+ival).checked=false;	
				document.getElementById('pract_working_week_'+j+'_day_'+ival).value='N';	
				document.getElementById('pract_working_week_'+j+'_day_'+ival+'1').value='N';	
			}
		}
	}

}

function assignweekappl(val,val1,i)
{
	
	if(val == val1)
	{
		eval(document.getElementById('pract_week_appl_day_'+i)).value=val1;
	}
	else
	{
		eval(document.getElementById('pract_week_appl_day_'+i)).value=val;
	}
}
function ValidateResName(obj)
{
	if(obj.name == 'res_unit1')
	{
		document.getElementById('reslookup_butt').disabled = true;
		document.getElementById('res_name').value = ''; 
		document.getElementById('res_name').readOnly = true; 
	}
	else
	{  
		document.getElementById('reslookup_butt').disabled = false;
		document.getElementById('res_name').value = ''; 
		document.getElementById('res_name').readOnly = false; 
	}
	
}

