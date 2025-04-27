/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/StockPosbyLocn.jsp?function_id="+function_id;
}

function reset() {
    //Added by Rabbani #INC no:32068 on 06/12/2012
    query();
   //Commented by Rabbani #INC no:32068 on 06/12/2012
	//parent.content.f_query_add_mod.qryCriteriaStockPosbyLocn.document.forms[0].reset();
	//parent.content.f_query_add_mod.qryResultStockPosbyLocn.location.href="../../eCommon/html/blank.html";
}


async function searchGroupCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= escape(document.StockPosbyLocnQuery.group_type.value);
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.StockPosbyLocnQuery.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.StockPosbyLocnQuery.locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	if (objDesc.readOnly) 
		argumentArray[5] = "";//objDesc.value;
	else
		argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly=true;
	} 

	
}

function clearGroupDetail()
{
	document.StockPosbyLocnQuery.description.value="";
}

function showTrayDtl()
{
	parent.qryResultStockPosbyLocn.location.href="../../eSS/jsp/StockPosbyLocnQueryResult.jsp?function_id="+function_id;

}
