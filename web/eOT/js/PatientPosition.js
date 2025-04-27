/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/PatientPositionAddModify.jsp?mode=insert';
}

function apply()
{
	var frm=f_query_add_mod.document.forms[0];
	//alert(frm.name);

	if(frm.mode.value=="modify"){
		//frm.submit();
		var fields = new Array (f_query_add_mod.document.forms[0].position_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		var positioncode=getLabel("Common.PositionCode.label","Common");
		var longdescription=getLabel("Common.longdescription.label","Common");
		var shortdescription=getLabel("Common.shortdescription.label","Common");
		var names = new Array (positioncode,longdescription,shortdescription);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
	}else{
		var fields = new Array (f_query_add_mod.document.forms[0].position_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		var positioncode=getLabel("Common.PositionCode.label","Common");
		var longdescription=getLabel("Common.longdescription.label","Common");
		var shortdescription=getLabel("Common.shortdescription.label","Common");
		var names = new Array (positioncode,longdescription,shortdescription);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
	 }
	
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/PatientPositionAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
/*if(f_query_add_mod.document.forms[0].name=="equipment_form"){

	 if(f_query_add_mod.document.location.href.indexOf("PatientPositions.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}*/
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PatientPositionAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("PatientPositions.jsp") != -1)
		  return false;
	 else
		f_query_add_mod.document.forms[0].reset();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PatientPositionQueryCriteria.jsp") != -1)
	{
		 f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/PatientPositionQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

