  //saved on 29/10/2005
function query()	{
	f_query_add_mod.location.href="../../ePH/jsp/QueryGenericNameFrames.jsp";
	//f_query_add_mod.location.href="../../ePH/jsp/QueryDrugProfileFrames.jsp";

}

function reset()	{
	if(f_query_add_mod.f_query_criteria)	{
	f_query_add_mod.f_query_criteria.document.queryGenericNameCriteria.reset();
	f_query_add_mod.f_query_criteria.document.getElementById('generic_id').value="";
	f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.f_query_criteria.document.queryGenericNameCriteria.generic_search.disabled=false;
	f_query_add_mod.f_query_criteria.document.getElementById("no_of_recs").style.visibility="visible";
	f_query_add_mod.f_query_criteria.document.getElementById("tot_recs").style.visibility="visible";
	}

}

async function searchGenericName(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var id= f_query_criteria.document.queryGenericNameCriteria.locale.value
//	argumentArray[0]   = f_query_criteria.document.queryGenericNameCriteria.sql_ph_drug_select14.value;
	argumentArray[0]   = "SELECT A.GENERIC_ID code,A.GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW A WHERE upper(A.GENERIC_ID) like upper(?) AND upper(A.GENERIC_NAME) like upper(?) AND A.EFF_STATUS='E' AND A.LANGUAGE_ID = '"+id+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = f_query_criteria.document.queryGenericNameCriteria.generic_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup( "Generic Name", argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		f_query_criteria.document.queryGenericNameCriteria.generic_name.value = arr[1] ;
		f_query_criteria.document.queryGenericNameCriteria.generic_id.value = arr[0];
		obj.disabled	=	true;
		f_query_criteria.document.getElementById("no_of_recs").style.visibility="hidden";
		f_query_criteria.document.getElementById("tot_recs").style.visibility ="hidden";
		}

}

function callResultPage()	{

	var generic_id			=	f_query_criteria.document.queryGenericNameCriteria.generic_id.value;
	var generic_name		=	f_query_criteria.document.queryGenericNameCriteria.generic_name.value;
	var drug_class			=	f_query_criteria.document.queryGenericNameCriteria.drug_class.value;
	var tot_recs			=	f_query_criteria.document.queryGenericNameCriteria.tot_recs.value;
	f_query_result.location.href="../../ePH/jsp/QueryGenericNameResult.jsp?generic_id="+generic_id+"&generic_name="+generic_name+"&drug_class="+drug_class+"&tot_recs="+tot_recs;
}

async function populate_generic_details(generic_id){
    var dialogHeight= "80vh" ;
    var dialogWidth = "90vw" ;
    var dialogTop = "10" ;
    var center = "1" ;
    var status="no";
    var scrolling="auto";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
    var arguments   = "" ;
    retVal = await window.showModalDialog("../../ePH/jsp/GenericNameForServiceViewFrames.jsp?generic_id="+generic_id,arguments,features);
}
