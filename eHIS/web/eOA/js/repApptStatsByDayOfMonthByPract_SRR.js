function run() { 
	var fields = new Array ( f_query_add_mod.document.forms[0].mon,
						f_query_add_mod.document.forms[0].years
					    );
	var names = new Array (getLabel("eOA.StatisticsMonth.label","eOA")
,getLabel("Common.year.label","Common"));

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		f_query_add_mod.document.forms[0].P_From_Pract_Code.value = f_query_add_mod.document.forms[0].p_fm_pract_id.value;
		f_query_add_mod.document.forms[0].P_To_Pract_Code.value = f_query_add_mod.document.forms[0].p_to_pract_id.value; f_query_add_mod.document.forms[0].P_Start_Month.value = f_query_add_mod.document.forms[0].mon.value;
		f_query_add_mod.document.forms[0].P_Start_Year.value = f_query_add_mod.document.forms[0].years.value; 		
		if( f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.forms[0].P_FM_SPECIAL,f_query_add_mod.document.forms[0].P_TO_SPECIAL, messageFrame )  )
        if( f_query_add_mod.CheckString(getLabel("Common.resourceid.label","Common"), f_query_add_mod.document.forms[0].P_From_Pract_Code,f_query_add_mod.document.forms[0].P_To_Pract_Code, messageFrame )  ) 
		f_query_add_mod.document.forms[0].submit();
	}
}

function reset()
{
	f_query_add_mod.document.forms[0].reset();
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





	function validateYear(obj)
	{
		var msg;
		if (obj.value!=""){
			
		var greg_obj = convertDate(obj.value,"yy",localeName,"en");
		
		if (greg_obj < 1900 || greg_obj > 3000)
		{
			msg = getMessage("YR_CHECK","OA")+ "<br>";
			document.forms[0].years.value ="";
			obj.focus();
		}
		if (msg!=null && msg != "")
		{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg ;
		}

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
				//var p_location_type1=document.forms[0].p_location_type1.value;
				
			
			//	var facility=obj1.value;			
			
			
			if(obj.name=="speciality" || obj.name=="speciality1" || obj.name=="P_FM_SPECIAL" || obj.name=="P_TO_SPECIAL")
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

	function CheckString(str,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
