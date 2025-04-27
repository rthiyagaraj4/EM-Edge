/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function reset() {
	f_query_add_mod.document.formRep_MonthlyServiceStatistics.reset();
}


function run()
{
	var formObj	=	parent.f_query_add_mod.document.formRep_MonthlyServiceStatistics;
	var messageFrame	=	parent.messageFrame;	
    			if (isValidFromToField(formObj.p_fm_doc_date1, formObj.p_to_doc_date1, DATE, "Document Date", messageFrame)) {
					formObj.p_fm_doc_date.value=convertDate(formObj.p_fm_doc_date1.value,'DMY',formObj.locale.value,"en");
					formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");
						
					formObj.submit();
				}
		
}

