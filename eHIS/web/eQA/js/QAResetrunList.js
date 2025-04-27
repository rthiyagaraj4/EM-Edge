function reset() {

	if(f_query_add_mod.document.repIndicatorGrp){
	   f_query_add_mod.document.repIndicatorGrp.reset() ;
	}
	else if(f_query_add_mod.document.repIndicator){
	   f_query_add_mod.document.repIndicator.reset() ;
	}
	else if(f_query_add_mod.document.repDiagProcInd){
	   f_query_add_mod.document.repDiagProcInd.reset() ;
	}
	else if(f_query_add_mod.document.repDiscipline){
	   f_query_add_mod.document.repDiscipline.reset() ;
	}
	else if(f_query_add_mod.document.repIndicatorsDis){
	   f_query_add_mod.document.repIndicatorsDis.reset() ;
	}
	else if(f_query_add_mod.document.repIndFacility){
	   f_query_add_mod.document.repIndFacility.reset() ;
	}
	else if(f_query_add_mod.document.repComplications){
	   f_query_add_mod.document.repComplications.reset() ;
	}
}//e.o.reset

function run() 
{

if(f_query_add_mod.document.repIndicatorGrp){
if( f_query_add_mod.CheckString('Indicator Group Code', f_query_add_mod.document.repIndicatorGrp.p_fm_ind_grp_code,f_query_add_mod.document.repIndicatorGrp.p_to_ind_grp_code, messageFrame ) ) 
f_query_add_mod.document.repIndicatorGrp.submit() ;
}
else if(f_query_add_mod.document.repIndicator){
if( f_query_add_mod.CheckString('Indicator Group Code', f_query_add_mod.document.repIndicator.p_fm_grp_id,f_query_add_mod.document.repIndicator.p_to_grp_id, messageFrame ) ) 
   if( f_query_add_mod.CheckString('Indicator ID', f_query_add_mod.document.repIndicator.p_fm_ind_id,f_query_add_mod.document.repIndicator.p_to_ind_id, messageFrame ) ) 
	  f_query_add_mod.document.repIndicator.submit() ;
}
else if(f_query_add_mod.document.repDiagProcInd){
if( f_query_add_mod.CheckString('Indicator ID', f_query_add_mod.document.repDiagProcInd.p_fm_ind_id,f_query_add_mod.document.repDiagProcInd.p_to_ind_id, messageFrame ) ) 
f_query_add_mod.document.repDiagProcInd.submit() ;
}
else if(f_query_add_mod.document.repDiscipline){
if( f_query_add_mod.CheckString('Discipline Code', f_query_add_mod.document.repDiscipline.p_fm_ind_dis_id,f_query_add_mod.document.repDiscipline.p_to_ind_dis_id, messageFrame ) ) 
f_query_add_mod.document.repDiscipline.submit() ;
}
else if(f_query_add_mod.document.repIndicatorsDis){
if( f_query_add_mod.CheckString('Discipline Code', f_query_add_mod.document.repIndicatorsDis.p_fm_dis,f_query_add_mod.document.repIndicatorsDis.p_to_dis, messageFrame ) ) 
f_query_add_mod.document.repIndicatorsDis.submit() ;
}
else if(f_query_add_mod.document.repIndFacility){
if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repIndFacility.p_fm_facility,f_query_add_mod.document.repIndFacility.p_to_facility, messageFrame ) ) 
f_query_add_mod.document.repIndFacility.submit() ;
}
else if(f_query_add_mod.document.repComplications){
if( f_query_add_mod.CheckString('Indicator ID', f_query_add_mod.document.repComplications.p_fm_ind_id,f_query_add_mod.document.repComplications.p_to_ind_id, messageFrame ) ) 
f_query_add_mod.document.repComplications.submit() ;
}

}//e.o.run

function validSplchars(obj,name)
{				
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=name;									
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

async function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	if(obj.name=="Indicator Group")
	{
		tit="Indicator Group"
		sql="select QIND_GROUP_ID, QIND_GROUP_DESC from QA_QIND_GROUP";
		search_code="QIND_GROUP_ID";
		search_desc= "QIND_GROUP_DESC"
	}
	if(obj.name=="Indicator Id")
	{
		var from_val = document.forms[0].p_fm_grp_id.value;
		var to_val = document.forms[0].p_to_grp_id.value;
		tit="Indicator Id"
		sql="select QIND_CLIND_ID, QIND_CLIND_DESC from QA_QIND_CLIND where QIND_GROUP_ID between nvl(`"+from_val+"`,QIND_GROUP_ID) and nvl(`"+to_val+"`,QIND_GROUP_ID)";
		search_code="QIND_CLIND_ID";
		search_desc= "QIND_CLIND_DESC"
	}
	if(obj.name=="Indicator Id1")
	{
		tit="Indicator Id"
		sql="select QIND_CLIND_ID, QIND_CLIND_DESC from QA_QIND_CLIND";
		search_code="QIND_CLIND_ID";
		search_desc= "QIND_CLIND_DESC "
	}
	if(obj.name=="Discipline Id")
	{
		tit="Discipline Code"
		sql="select QIND_DISCIPLINE_ID, QIND_DISCIPLINE_DESC from QA_QIND_DISCIPLINE";
		search_code="QIND_DISCIPLINE_ID";
		search_desc= "QIND_DISCIPLINE_DESC"
	}
	if(obj.name=="Discipline Code")
	{
		tit="Discipline Code"
		sql="select QIND_DISCIPLINE_ID, QIND_DISCIPLINE_DESC from QA_QIND_DISCIPLINE";
		search_code="QIND_DISCIPLINE_ID";
		search_desc= "QIND_DISCIPLINE_DESC"
	}
	if(obj.name=="Facility Id")
	{
		tit="Facility Id"
		sql="select FACILITY_ID, FACILITY_NAME from sm_facility_param";
		search_code="FACILITY_ID";
		search_desc= "FACILITY_NAME"
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}

