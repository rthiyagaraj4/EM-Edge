function run() 
{	
var fields = new Array( f_query_add_mod.document.forms[0].dat);
var names = new Array(getLabel("Common.StartDate.label","Common"));
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	f_query_add_mod.document.forms[0].P_From_Pract_Code.value = f_query_add_mod.document.forms[0].p_fm_pract_id.value;
	f_query_add_mod.document.forms[0].P_To_Pract_Code.value = f_query_add_mod.document.forms[0].p_to_pract_id.value; f_query_add_mod.document.forms[0].P_Start_Date.value=f_query_add_mod.document.forms[0].dat.value;
	// if( f_query_add_mod.CheckString(getLabel("Common.Speciality.label","Common") , f_query_add_mod.document.forms[0].P_FM_SPECIALITY,f_query_add_mod.document.forms[0].P_TO_SPECIALITY, messageFrame )  )
	if( f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.forms[0].P_FM_SPECIALITY,f_query_add_mod.document.forms[0].P_TO_SPECIALITY, messageFrame )  )
	if( f_query_add_mod.CheckString(getLabel("Common.resourceid.label","Common"), f_query_add_mod.document.forms[0].P_From_Pract_Code,f_query_add_mod.document.forms[0].P_To_Pract_Code, messageFrame )  )
	f_query_add_mod.document.forms[0].submit();
}
}
function reset() {
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.forms[0].sys1.innerText=f_query_add_mod.document.forms[0].sysday.value;

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
	opt.text=" -------"+getLabel("Common.defaultSelect.label","Common")+"------ ";
	opt.value="";
	document.forms[0].fm_pract_type.add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text=" -------"+getLabel("Common.defaultSelect.label","Common")+"------ ";
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



function getDay(){
	//   strDate = document.forms[0].dat.value;
	var d_dates = document.forms[0].dat.value;
	var greg_obj1 = convertDate(d_dates,"DMY",localeName,"en");
	var dayOfWeek = getDayOfWeek(greg_obj1,"DMY", 'en');
	var Vdate= parseInt(dayOfWeek);

	/*   strDateArray = strDate.split("/");
	   strDay		= strDateArray[0];
	   strMonth		= strDateArray[1];
	   strYear		= strDateArray[2]; 
	   Vdate		= new Date(strMonth+'/'+ strDay +'/'+ strYear)   */

	   if(Vdate != "NaN")
	   {	   
	   	switch(Vdate)
	   	{
			
			case 1:
			  Vdate=getLabel("Common.mon.label","Common");
			  break;	  
			case 2:
			  Vdate=getLabel("Common.tue.label","Common");
			  break;
			case 3:
			  Vdate=getLabel("Common.wed.label","Common");
			  break;
			case 4:
			  Vdate=getLabel("Common.thu.label","Common");
			  break;
			case 5:
			  Vdate=getLabel("Common.fri.label","Common");
			  break;
			case 6:
			  Vdate=getLabel("Common.sat.label","Common");
			  break;  
			case 7:
			  Vdate=getLabel("Common.sun.label","Common");
			  break;
	   	}
	   }
	if(Vdate != "NaN")
	   document.forms[0].sys1.innerHTML=Vdate;
	else
		document.forms[0].sys1.innerHTML="&nbsp;";
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
		else
			getDay();
	}else
	{
		document.forms[0].sys1.innerHTML="&nbsp;";
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
			var locale=document.forms[0].locale.value;
			

			
			if(obj.name=="spec" || obj.name=="P_FM_SPECIALITY" || obj.name=="P_TO_SPECIALITY")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code,short_Desc description from am_speciality_lang_vw where language_id='"+locale+"'  and upper(speciality_code) like upper(?) and upper(short_Desc) like upper(?) order by 2";
								
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
