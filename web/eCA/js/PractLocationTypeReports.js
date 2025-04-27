function run(){
		alert(f_query_rep.getMessage('GEN_REP','CA'));
	if(f_query_rep.document.practLocationTypeReports)
	{
		if( f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value==''|| f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value==null){
			f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value='';
		}
		if( f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value==''|| f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value==null){
			f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value='';
		}
		f_query_rep.document.practLocationTypeReports.submit();
	}
}

function reset(){
	f_query_rep.document.practLocationTypeReports.reset();
}
function search_Code(obj,target, facility_id)
{
	if(obj.name=='p_fr_practitioner_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target,facility_id);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='fmpractLoctypeRep'><input type=hidden name='PageName' id='PageName' value='ReportPractLocationType'></form></body></html>";
			parent.f_query_practLocn_intermediate.document.write(HTMLVal);				
			if(parent.f_query_practLocn_intermediate.document.tempform1)
				parent.f_query_practLocn_intermediate.document.tempform1.submit();
		}
	}
	else if(obj.name=='p_to_practitioner_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target,facility_id);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='topractLoctypeRep'><input type=hidden name='PageName' id='PageName' value='ReportPractLocationType'></form></body></html>";
			parent.f_query_practLocn_intermediate.document.write(HTMLVal);				
			if(parent.f_query_practLocn_intermediate.document.tempform1)
				parent.f_query_practLocn_intermediate.document.tempform1.submit();
		}
	}
	else if(obj.name=='p_fr_practitioner_id_src' || obj.name=='p_to_practitioner_id_src')
	{		
		searchCode(obj,target,facility_id);
	}	
}
async function searchCode(obj, target, facility_id ) {
	
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var SQL_SELECT		= "";
	var win_title		= "";
	var fld_name		= target.name;

	if(fld_name =="p_fr_practitioner_id1" || fld_name=="p_to_practitioner_id1"){
		//SQL_SELECT =  document.forms[0].SQL_SELECT_PRACT.value;
		SQL_SELECT ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)";
		win_title  = getLabel('Common.practitioner.label','COMMON');	
	}

	argumentArray[0] = SQL_SELECT;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray =await CommonLookup( win_title, argumentArray );

	if(retArray != null && retArray != "" )  {
		var str =unescape(retArray);
	 	var arr = str.split(",");
 		if(obj.name=="p_fr_practitioner_id_src"||obj.name=="p_fr_practitioner_id1")
		{							
			document.practLocationTypeReports.p_fr_practitioner_id1.value= arr[1];						
			document.practLocationTypeReports.p_fr_practitioner_id.value= arr[0];						
		}
		else if(obj.name=="p_to_practitioner_id_src"||obj.name=="p_to_practitioner_id1")
		{
			document.practLocationTypeReports.p_to_practitioner_id1.value= arr[1];
			document.practLocationTypeReports.p_to_practitioner_id.value= arr[0];
		}
	}
	else
	{
		if(obj.name=="p_fr_practitioner_id_src"||obj.name=="p_fr_practitioner_id1")
		{							
			document.practLocationTypeReports.p_fr_practitioner_id1.value="";						
			document.practLocationTypeReports.p_fr_practitioner_id.value="";						
		}
		else if(obj.name=="p_to_practitioner_id_src"||obj.name=="p_to_practitioner_id1")
		{
			document.practLocationTypeReports.p_to_practitioner_id1.value="";
			document.practLocationTypeReports.p_to_practitioner_id.value="";
		}
	}
}
//........Intermediatepage
function callFunction(sql,title,target)
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
	retArray = CommonLookup(title, argArray );
	return retArray;
 }
//ML-MMOH-CRF-1180 ---5563 STARTS
async function getSpecialty(target,code)
{
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= "";
	var sql = "";
		 sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
 		 title =getLabel("Common.speciality.label","Common");
	
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

	retArray =await CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		var str =unescape(retArray);
	 	var arr = str.split(",");
		document.forms[0].grp_by_name.value = arr[1];
		document.forms[0].p_specialty_code.value = arr[0];
	}
	else
	{
		document.forms[0].grp_by_name.value = '';
		document.forms[0].p_specialty_code.value = '';
	}
}
//ML-MMOH-CRF-1180 --5563 ENDS

