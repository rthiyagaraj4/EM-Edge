/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply()
{	
	
		var AnaesthesiaNextNo=getLabel("eOT.AnaesthesiaNumbering.Label","OT");
		var PreOperativeAssessmentNum=getLabel("eOT.PreOperativeAssessmentNum.Label","OT");

//		var fields = new Array (f_query_add_mod.document.forms[0].next_anaesthesia_serial_num,f_query_add_mod.document.forms[0].next_preop_asses_num);
//		var names = new Array ( "Anaesthesia Next No.", "Pre Operative Assessment Next No.");
		var fields = new Array (f_query_add_mod.document.forms[0].next_anaesthesia_serial_num,f_query_add_mod.document.forms[0].next_preop_asses_num);
		var names = new Array ( AnaesthesiaNextNo, PreOperativeAssessmentNum);

		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/AnaesthSetUpParamFltyAddModify.jsp?mode=modify';
	else
         f_query_add_mod.location.reload();

}



function reset()
{
	f_query_add_mod.document.forms[0].reset();
}


