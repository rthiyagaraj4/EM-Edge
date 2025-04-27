/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
31/10/2013      IN040377		Chowminya 	   New Immunization report required Patient wise. [Created]
04/12/2013      IN045389		Chowminya	   Link1-System allowing to generate Immunization report by without giving Patient ID	
06/12/2013		IN045391		Chowminya	   Link2-Printer / Print Routing is not defined. Contact System Administrator? error message				
04/09/2014  	IN050829		Nijitha S	   ML-BRU-SCF-1421		
---------------------------------------------------------------------------------------------------------------
*/
function reset() 
{
	if(f_query_add_mod.document.repPatImmunization)
	{
		f_query_add_mod.document.repPatImmunization.reset() ;
	}
}//e.o.reset

function run()
{
	//IN045389 - Start Added condition
	var fields = new Array(f_query_add_mod.document.repPatImmunization.p_patient_id);
    var names = new Array(getLabel('Common.patientId.label','common'));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{	
		alert(f_query_add_mod.getMessage('GEN_REP','CA'));//IN050829

		if(f_query_add_mod.document.repPatImmunization)
		{
			if( f_query_add_mod.document.repPatImmunization.p_vaccine1.value==''|| f_query_add_mod.document.repPatImmunization.p_vaccine1.value==null)
			{
				f_query_add_mod.document.repPatImmunization.P_VACCIN_ID.value='';
			}
			if( f_query_add_mod.document.repPatImmunization.p_vaccine_category1.value==''|| f_query_add_mod.document.repPatImmunization.p_vaccine_category1.value==null)
			{
				f_query_add_mod.document.repPatImmunization.P_VACCIN_CAT_ID.value='';
			}
			//IN045391 - Modified value passed - start
			if(f_query_add_mod.document.repPatImmunization.p_status1.value == "")
				f_query_add_mod.document.repPatImmunization.p_status.value = "A";
			else
				f_query_add_mod.document.repPatImmunization.p_status.value = f_query_add_mod.document.repPatImmunization.p_status1.value;
			//IN045391 - Modified value passed - end	
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repPatImmunization.submit()
		}
	}
	//IN045389 - End
}
//GeneralSearch changed to commonlookup
function call_CommonLookup(obj,check)
{
	var p_facility_id=document.repPatImmunization.p_facility_id.value;
 if(obj.name=='btnVaccName')
	{		
		callCommonLookup("VN");
	}	
	else if(obj.name=='btnVaccCategory')
	{
		callCommonLookup("VC");
	}
}

async function callCommonLookup(check)
{			
			var p_facility_id=document.repPatImmunization.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
				
			if(check=="VN")
			{
				title="Vaccine";					
				sql=" Select VACCINE_ID code, SHORT_DESC description from CA_IM_VACCINE  where eff_status='E' and upper(VACCINE_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2 ";	
				search_code="VACCINE_ID";
				search_desc= "SHORT_DESC";
				target=document.repPatImmunization.p_vaccine1;					
			}
			else if(check=="VC")
			{
				title="Vaccine Category";
				sql="Select VACC_CATEG_ID code, SHORT_DESC description from CA_IM_VAC_CATEG a where eff_status='E' and upper(VACC_CATEG_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) AND NOT EXISTS (SELECT 1 FROM ca_im_param WHERE vacc_categ_id = a.vacc_categ_id) order by 2";
				search_code="VACC_CATEG_ID";
				search_desc= "SHORT_DESC";
				target=document.repPatImmunization.p_vaccine_category1;
			}
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var datatypesArray = new Array();
			
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "1,2";
			argArray[5] = target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = CODE_DESC;
			retArray =await CommonLookup( title,argArray );
			if(retArray != null && retArray !="")	
			{
				var str =unescape(retArray);
			 	var arr = str.split(",");
				if(check=="VN")
				{	
					document.repPatImmunization.p_vaccine1.value= arr[1];						
					document.repPatImmunization.P_VACCIN_ID.value= arr[0];
				}
				else if(check=="VC")
				{
					document.repPatImmunization.p_vaccine_category1.value= arr[1];
					document.repPatImmunization.P_VACCIN_CAT_ID.value= arr[0];
				}
			}
			else
			{
				if(check=="VN")
				{							
					document.repPatImmunization.p_vaccine1.value="";						
					document.repPatImmunization.P_VACCIN_ID.value="";						
				}
				else if(check=="VC")
				{
					document.repPatImmunization.p_vaccine_category1.value="";
					document.repPatImmunization.P_VACCIN_CAT_ID.value="";
				}	
			}
}

async function callFunction(sql,title,target)
{
	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray =await CommonLookup(title, argArray );
	return retArray;
}

async function callPatientSearch()
		{
			var pat_id =await  PatientSearch();

			if(pat_id != null)
			document.forms[0].p_patient_id.value = pat_id;							
		}

function checkingDate(obj,format,locale)
{
	var from =document.forms[0].p_fm_Date;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!doDateCheckAlert(from,obj))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.select();
			obj.focus();
		}
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		/*else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}*/
	}
	
	}

}

function Check_Date(obj,format,locale)
{
	var to = document.forms[0].p_to_Date;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(!doDateCheckAlert(obj,to))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.select();
			obj.focus();
		}
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		/*else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}*/
	}	
	}
}

function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}
