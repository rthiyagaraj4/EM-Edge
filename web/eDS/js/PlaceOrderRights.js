// New file PlaceOrderRights.js created against ML-MMOH-CRF-0677
function create()
{
	f_query_add_mod.location.href='../../eDS/jsp/PlaceOrderRightsAddModify.jsp?mode=insert';
}

function apply()
{	
	var frm=f_query_add_mod.document.forms[0];
	if(frm.name=='query_form' || frm.name=='QueryResult')
{
	commontoolbarFrame.location.reload();
}
else
	{
	var fields = new Array (f_query_add_mod.document.forms[0].appl_user_id);
	var names = new Array ( "Name");
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eDS/jsp/PlaceOrderRightsAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PlaceOrderRightsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("PlaceDietOrderRights.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PlaceOrderRightsQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eDS/jsp/PlaceOrderRightsQueryCriteria.jsp';
	
}



function editMealsYN()
{
	if(document.forms[0].edit_meals_yn.checked==true)
		document.forms[0].edit_meals_yn.value="Y";
	else
		document.forms[0].edit_meals_yn.value="N";
}
function nutrientSupplementYN()
{
	if(document.forms[0].nutrient_supplement_yn.checked==true)
		document.forms[0].nutrient_supplement_yn.value="Y";
	else
		document.forms[0].nutrient_supplement_yn.value="N";
}

function foodDislikeYN()
{
	if(document.forms[0].food_dislike_yn.checked==true)
		document.forms[0].food_dislike_yn.value="Y";
	else
		document.forms[0].food_dislike_yn.value="N";
}


function specialFoodOrderYN()
{
	if(document.forms[0].special_food_order_yn.checked==true)
		document.forms[0].special_food_order_yn.value="Y";
	else
		document.forms[0].special_food_order_yn.value="N";
}


function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

async function callLoginUser(){
	var formobj=document.forms[0];
	var facility_id=formobj.facility_id.value;
	var obj=formobj.appl_user_id;
	var target=formobj.appl_user_name;
	var tit=getLabel("Common.userid.label","common");
	var sql="SELECT A.USER_ID CODE, A.USERNAME DESCRIPTION FROM SY_USER A WHERE FACILITY_ID = '"+facility_id+"' AND UPPER(A.USERNAME) LIKE UPPER(?) AND UPPER(A.USER_ID) LIKE UPPER(?) ORDER BY 2";
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1"; 
	argumentArray[5] = trimString(obj.value);
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray);
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',') ;
		}
		target.value=returnedValues[0];
		obj.value=returnedValues[1];
	}else{
	target.value='';
	obj.value='';
	}
}

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}
