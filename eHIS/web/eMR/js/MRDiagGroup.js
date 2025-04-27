function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyMRDiagGroup.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/MRDiagGroupQueryCriteria.jsp";
}

function apply() {

	var fields = new Array (f_query_add_mod.document.mr_diag_grp.group_type,f_query_add_mod.document.mr_diag_grp.diag_group_code,
							f_query_add_mod.document.mr_diag_grp.long_desc
							);

	var names = new Array ( getLabel("Common.GroupType.label","Common"),getLabel("Common.code.label","Common"),
				getLabel("Common.description.label","Common")
				);

	var field = new Array (f_query_add_mod.document.mr_diag_grp.diag_group_code	);

	var name = new Array ( getLabel("Common.code.label","Common"));

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.mr_diag_grp.submit();
			}
		}

}

function onSuccess() {
if(f_query_add_mod.document.forms[0].function_name.value == "delete")
{
	f_query_add_mod.location.href='../../eCommon/html/blank.html'
}
else
{
	f_query_add_mod.location.reload();
}

}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	{
	   f_query_add_mod.document.forms[0].reset();
	}
}  


function deleterecord()
{
if(f_query_add_mod.document.forms[0].function_name.value!="insert")
	{
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
		{
		f_query_add_mod.document.forms[0].function_name.value="delete";

		f_query_add_mod.document.mr_diag_grp.submit();
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
		}
}
	else
	{
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
}



 function group_type_chng(obj)
		{
		  if (obj.value=="")
			{
			document.getElementById('diag_code_scheme_id').innerHTML = "&nbsp;";
			document.forms[0].diag_code_scheme.value = "";
			}
          else
			{
			  if (obj.value =="D")
				{
				document.forms[0].all.diag_code_scheme_id.innerHTML = "&nbsp;&nbsp;&nbsp;"+document.forms[0].diag_code_scheme1.value;
				document.forms[0].diag_code_scheme.value = document.forms[0].diag_code_scheme_val.value;
				}
			  else if (obj.value="P")
				{
				document.forms[0].all.diag_code_scheme_id.innerHTML = "&nbsp;&nbsp;&nbsp;"+document.forms[0].proc_code_scheme1.value;
				document.forms[0].diag_code_scheme.value = document.forms[0].proc_code_scheme_val.value;
				}
			}
           document.forms[0].diag_group_code.value = "";
           document.forms[0].long_desc.value = "";
           document.forms[0].speciality_code.value = "";
           document.forms[0].facility_id.value = "";
           document.forms[0].practitioner_name.value = "";
           document.forms[0].practitioner_id.value = "";
			  
		}


function populatePractDemo(target,target_id)
		{
				var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	dataNameArray[0] = "eff_status" ;
//	dataValueArray[0] = "E";
//	dataTypeArray[0] = STRING ;

			
			if(document.forms[0].speciality_code.value !=''  && document.forms[0].facility_id.value =='')
			{
			var speciality_code=document.forms[0].speciality_code.value;
			
			sql="select practitioner_id code,practitioner_name description  from am_practitioner where primary_speciality_code ='"+document.forms[0].speciality_code.value+"' "+
			      " and eff_status='E' "+
			      "  and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) union "+
			      " select b.practitioner_id,b.practitioner_name from am_pract_specialities a,am_practitioner b where speciality_code ='"+document.forms[0].speciality_code.value+"' "+
			      " and a.practitioner_id=b.practitioner_id and b.eff_status ='E'   order by 2";
			}
			else
			if(document.forms[0].speciality_code.value !=''  && document.forms[0].facility_id.value !='')
			{
			sql= " select practitioner_id code,practitioner_name description from am_practitioner where primary_speciality_code ='"+document.forms[0].speciality_code.value+"' "+
				" and eff_status='E' "+
				"  and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) union "+
				" select b.practitioner_id,b.practitioner_name from am_pract_specialities a,am_practitioner b where speciality_code ='"+document.forms[0].speciality_code.value+"' and facility_id= '"+document.forms[0].facility_id.value+"' "+
			      " and a.practitioner_id=b.practitioner_id and b.eff_status ='E'   order by 2";
			
			}
			else
			if(document.forms[0].speciality_code.value ==''  && document.forms[0].facility_id.value !='')
			{
			sql=" select b.practitioner_id code,b.practitioner_name description from am_pract_for_facility a,am_practitioner b where a.facility_id = '"+document.forms[0].facility_id.value+"' "+
			      " and a.practitioner_id=b.practitioner_id and b.eff_status='E'  and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
			}
			else
			{
			sql=" select practitioner_id code,practitioner_name description from am_practitioner where eff_status='E' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
			}
		
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE  ;

	var retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

	if(retVal != null && retVal != "" )  {
 		target_id.value = retVal[0] ; /* if code need to be returned */
 		target.value = retVal[1] ; /* if desc need to be returned */
	
			}

			else
			{
				target.value="";
				target_id.value="";
			}
			
			
		}

		function changeCase(Obj)
		{
		Obj.value= Obj.value.toUpperCase();
		}
	function PractLookupRetVal(retVal,objName) //Part of callPractSearch function.
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");				
			document.forms[0].temp_desc.value=arr[1];
			document.forms[0].temp_physician_id.value=arr[0];					
		}	
	}

	function callPractSearch(obj,target){ //Function for practitioner search.
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var sqlSec="";
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].temp_physician_id.name;	

	 getPractitioner(obj, target,"","Q1");
//do not forget to give aliases as mentioned below
/*

sql = " SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) or a.job_title is null)  ";

sqlSec= " SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) or a.job_title is null)  ";*/

/*
* if you are passing User Defined SQL and in that if you want to pass any of the folowing in where criteria  :-
*	1.  practioner type
*   2. Speciality /Clinic code
*   3. Job Title
*   4. Gender
*
* then you must pass them in the query string below with folowing names
*	1.  practioner type               ----->practitioner_type
*   2. Speciality /Clinic code    ----->specialty_code
*   3. Job Title							----->job_title
*   4. Gender							----->gender
*
*
*/
/*
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + practName_FName + "\"";
				xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
				xmlStr += " sql=\"" +escape(sql)+ "\"";
				xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
				xmlStr += " practitioner_type=\"" + "" + "\"";
				xmlStr += " specialty_code=\"" + ""+ "\"";
				xmlStr += " job_title=\"" + "" + "\"";
				xmlStr += " gender=\"" + "" + "\"";

				//escape(sql)
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);		
				
				*/


}

function fixvaluespractitioner() //used to set the practitioner information obtained from callpractsearch function.
{
	document.forms[0].practitioner_name.value=document.forms[0].temp_desc.value;
	document.forms[0].practitioner_id.value=document.forms[0].temp_physician_id.value;
	document.forms[0].temp_desc.value="";	
}

function getattndpract () // function to call callpractsearch if the text field is empty.
{	
	if (document.forms[0].practitioner_name.value=="")
	{ 
		document.forms[0].practitioner_id.value = "";
	}
	else
	{	
		callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practitioner_name); 			
		fixvaluespractitioner();
	}
}



