function reset() {
	f_query_add_mod.document.repAppointmentsForOPD.reset() ;
}

function run() 
{
  
	//f_query_add_mod.document.repAppointmentsForOPD.P_RESOURCE_CLASS.value=f_query_add_mod.document.repAppointmentsForOPD.p_resource_class1.value;
var localeName=f_query_add_mod.document.repAppointmentsForOPD.locale.value;

var fields = new Array(f_query_add_mod.document.repAppointmentsForOPD.p_fm_appointment_date, f_query_add_mod.document.repAppointmentsForOPD.p_to_appointment_date);

var names = new Array(getLabel("eOA.ApptDateFrom.label","OA"), getLabel("eOA.ApptDateTo.label","OA"));
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{  
	if( f_query_add_mod.DateCompare_apply( f_query_add_mod.document.repAppointmentsForOPD.p_fm_appointment_date, f_query_add_mod.document.repAppointmentsForOPD.p_to_appointment_date) ) 
//	if( f_query_add_mod.DateCompare_apply(convertDate(f_query_add_mod.document.repAppointmentsForOPD.p_fm_appt_date.value,"DMY",localeName,"en"), convertDate(f_query_add_mod.document.repAppointmentsForOPD.p_to_appt_date.value,"DMY",localeName,"en")) ) 
	{
		if( f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repAppointmentsForOPD.p_fm_locn_code, f_query_add_mod.document.repAppointmentsForOPD.p_to_locn_code, messageFrame ) ) 
		{
			if( f_query_add_mod.CheckString( getLabel("Common.resourceid.label","Common"),f_query_add_mod.document.repAppointmentsForOPD.p_fm_pract_id, f_query_add_mod.document.repAppointmentsForOPD.p_to_pract_id, messageFrame ) ) 
			{
			if( f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.repAppointmentsForOPD.p_fm_service_code, f_query_add_mod.document.repAppointmentsForOPD.p_to_service_code, messageFrame ) ) 
			{
			if( f_query_add_mod.CheckString( getLabel("Common.SpecialityCode.label","Common"),f_query_add_mod.document.repAppointmentsForOPD.p_fm_speciality_code, f_query_add_mod.document.repAppointmentsForOPD.p_to_speciality_code, messageFrame ) ) 
			{
				orderbycolumns	=	f_query_add_mod.document.forms[0].orderbycolumns;
                
				var order_by_columns	=	"";

				if(orderbycolumns.length>0)
				{
					for(var i=0; i<orderbycolumns.length; i++)
					{
						order_by_columns	+=	orderbycolumns[i].value;
												
						if( (i+1) < orderbycolumns.length ) order_by_columns	+=	"__";
					}
				}
				f_query_add_mod.document.repAppointmentsForOPD.p_order_by.value = order_by_columns;				
								
				f_query_add_mod.document.repAppointmentsForOPD.p_fm_appt_date.value=convertDate(f_query_add_mod.document.repAppointmentsForOPD.p_fm_appointment_date.value,"DMY",localeName,"en");
				f_query_add_mod.document.repAppointmentsForOPD.p_to_appt_date.value=convertDate(f_query_add_mod.document.repAppointmentsForOPD.p_to_appointment_date.value,"DMY",localeName,"en");				
				f_query_add_mod.document.repAppointmentsForOPD.submit() ;
			}			


			}
			}
			}
		}
	}	
}

	function groupByLocation()
	{
		 if (repAppointmentsForOPD.p_grp_by_location.checked == true )
		 {
			parent.frames[1].document.forms[0].p_report_id.value = 'OAAPOPLC' ;
			
		 }
		 else
		 {
		 	parent.frames[1].document.forms[0].p_report_id.value = 'OAAPOPPI' ;
		 	
		 }
	}
	

function practValidate(Obj)
		{
	document.forms[0].P_RESOURCE_CLASS.value=Obj.value;
	document.forms[0].p_fm_pract_id.value='';
		document.forms[0].p_to_pract_id.value='';
		if(Obj.value=='')
		{

			document.forms[0].p_fm_pract_id.value='';
			document.forms[0].p_to_pract_id.value='';
			document.forms[0].p_fm_pract_id.disabled=true;
			document.forms[0].pract_id.disabled=true;
			document.forms[0].pract_id1.disabled=true;
			document.forms[0].p_to_pract_id.disabled=true;
		}
		else
			{
		document.forms[0].p_fm_pract_id.disabled=false;
			document.forms[0].p_to_pract_id.disabled=false;
		document.forms[0].pract_id.disabled=false;
		document.forms[0].pract_id1.disabled=false;
			}
		}
function getResource(Obj)
{
	var carelocn="";
	var resource1 = document.forms[0].p_resource_class1.value;
		var n=document.forms[0].fm_pract_type.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].fm_pract_type.remove("clinic");
		document.forms[0].to_pract_type.remove("clinic");
		
	}
	
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].fm_pract_type.add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.forms[0].to_pract_type.add(opt1);	
	
if(!(resource1 == null || resource1 == ""))
{
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}
}

	

function enablepr(obj)
{
	document.forms[0].p_fm_pract_id.value='';
		
	
}
function enablepr1(obj)
{
	document.forms[0].p_to_pract_id.value='';
	
		
}
function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
	document.forms[0].p_fm_locn_code.value='';
	document.forms[0].p_to_locn_code.value='';
}







	function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

				var facilityid = document.forms[0].p_facility_id.value;
				var p_location_type1=document.forms[0].p_location_type1.value;
				var locale=document.forms[0].locale.value;
			
			//	var facility=obj1.value;

			if(obj.name=="locn" || obj.name=="p_fm_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				if(p_location_type1!=''){
				
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"'  and language_id='"+locale+"' and level_of_care_ind = 'A' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				}
				else{
					sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"'  and language_id='"+locale+"' and level_of_care_ind = 'A' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";

				}
			}
			
			if(obj.name=="locn1" || obj.name=="p_to_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				if(p_location_type1!=''){
				
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"'  and language_id='"+locale+"' and level_of_care_ind = 'A' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				}
				else{
					sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"'  and language_id='"+locale+"'  and level_of_care_ind = 'A' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2"
				}
			}
			
			if(obj.name=="service"||obj.name=="service1" || obj.name=="p_fm_service_code" || obj.name=="p_to_service_code")
			{
				tit=getLabel("Common.service.label","Common");
				sql="select service_code code,short_desc description from am_service_lang_vw where language_id='"+locale+"' and upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			}
			
			if(obj.name=="speciality" || obj.name=="speciality1" || obj.name=="p_fm_speciality_code" || obj.name=="p_to_speciality_code")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code,short_desc description from am_speciality_lang_vw where language_id='"+locale+"' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			}
					
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}



	function ValidateDate(obj)
	{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
	}



	function DateCompare_apply(from,to)
	{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				to.value="";
				to.select();					
				return false;
			}
			else
				return true;
		}

	}

	function addOrderByCol(obj)	
		{ 		
		    var from = document.forms[0].orderbycols;
			if(from.selectedIndex !=-1)
			{
		    if ( from.options.length > 0 ) 
			{
				var to = document.forms[0].orderbycolumns; 
				var element = document.createElement('OPTION'); 
				element.text = from.options[from.selectedIndex].text; 
				element.value= from.options[from.selectedIndex].value; 
				to.add(element); 			
				from.remove(from.selectedIndex); 
			} 
			}
		}                                                                                             

		function removeOrderByCol()
		    { 
				var from = document.forms[0].orderbycolumns;
                if(from.selectedIndex !=-1)
			    {
				if ( from.options.length > 0 )
				{ 
					var to = document.forms[0].orderbycols; 
					var element = document.createElement('OPTION'); 
					element.text = from.options[from.selectedIndex].text; 
					element.value = from.options[from.selectedIndex].value; 
					to.add(element);	
					from.remove(from.selectedIndex); 
				} 
				}
		    }
