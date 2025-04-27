/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function create() {

}

function reset() {
	f_query_add_mod.document.formVariance.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}




function run()
{
	formObj= f_query_add_mod.document.formVariance;

	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();

	fields[0]		=	formObj.p_phy_inv_id;
	fieldNames[0]	=	getLabel("eSS.PhysicalInvId.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, messageFrame);

	if(blankObject==null) {
		if(formObj.p_report_type.value=="D")
			formObj.p_report_id.value="SSBPHVRD";
		else
			formObj.p_report_id.value="SSBPHVRS";

		formObj.submit();
	}
}

