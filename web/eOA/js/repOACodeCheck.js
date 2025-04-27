function codeCheck(Obj){
var u=Obj;
if(u==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
if(u=="OA_CLINIC_TIME_TABLE"){

parent.f_query_add_mod.location.href ="../../eOA/jsp/repTimeTableList.jsp";
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
	
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText);
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
	document.forms[0].p_fm_clinic_code.value='';
	document.forms[0].p_to_clinic_code.value='';
		}

function PractLookupRetVal(retVal,objName)
{
	var arr;
if (!(retVal == null))
			{
			arr=retVal.split("~");
			if(objName=="p_fm_pract_id")
				{
				document.forms[0].p_fm_pract_id.value=arr[0];
			}
			else
				{
				document.forms[0].p_to_pract_id.value=arr[0];
				}
			}
			else
				{
				if(objName=="p_fm_pract_id")
					{
				document.forms[0].p_fm_pract_id.focus();
				document.forms[0].p_fm_pract_id.value="";
					}
					else
					{
						
				  	document.forms[0].p_to_pract_id.focus();
						document.forms[0].p_to_pract_id.value="";
					}
			
				}

				
}

/*function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var facilityid = document.forms[0].p_facility_id.value;
			var tit="";
			var from_pract_type = repTimeTableList.fm_pract_type.value;
			var to_pract_type = repTimeTableList.to_pract_type.value;
			var p_location_type1=document.forms[0].p_location_type1.value;
			var locale=document.forms[0].locale.value;

			if(obj.name=="clinic")
		
			{
				tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+locale+"` and CARE_LOCN_TYPE_IND=nvl(`"+p_location_type1+"`,CARE_LOCN_TYPE_IND)";
				search_code="clinic_code";
				search_desc= "long_desc";
				
			}

		
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}*/


		async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

			var from_pract_type = repTimeTableList.fm_pract_type.value;
			var to_pract_type = repTimeTableList.to_pract_type.value;
			var p_location_type1=document.forms[0].p_location_type1.value;
			var facilityid = document.forms[0].p_facility_id.value;
			

			if(obj.name=="clinic" || obj.name=="p_fm_clinic_code" || obj.name=="p_to_clinic_code")
			{
				tit=getLabel("Common.clinic.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+locale+"' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
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


function reset() {
	f_query_add_mod.document.repAppointmentsForOPD.reset() ;
}
