function create()
{
	//var formObj = document.forms[0];
	//var params = formObj.params.value;
	f_query_add_mod.location.href="../../eBL/jsp/BLInsAgeLimitAddModify.jsp?&mode=insert";
}

function apply()
{	
	//alert("apply");
	var frm=f_query_add_mod.document.forms[0];

	//alert(frm.name);

if(frm.name=='query_form' || frm.name=='QueryResult'){
	commontoolbarFrame.location.reload();
}
else{
	var fields = new Array (f_query_add_mod.document.forms[0].code,f_query_add_mod.document.forms[0].short_desc,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].toYear);
	var category_value=getLabel("Common.code.label","Common");
	var short_desc_value=getLabel("Common.short_desc.label","Common");
	var description_value=getLabel("Common.description.label","Common");
	var toyear_value = getLabel("eBL.AGELIMITTO.label","BL")
	var names = new Array (category_value,short_desc_value,description_value,toyear_value);

//	alert("before validate");
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
		//	alert("before submit");
			f_query_add_mod.document.forms[0].submit();
		}
	}

	//f_query_add_mod.location.reload();
}

function onSuccess()
{

//	f_query_add_mod.location.reload();
	if(f_query_add_mod.document.forms[0].mode.value=="insert") 		f_query_add_mod.location.href='../../eBL/jsp/BLInsAgeLimitAddModify.jsp?mode=insert';
	else          f_query_add_mod.location.reload();

}
/*
function reset()
{
	f_query_add_mod.document.forms[0].reset();
}
*/

function ChkNumberInput(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}


function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BLInsAgeLimitAddModify.jsp") != -1){


				 if(f_query_add_mod.document.location.href.indexOf("BLInsAgeLimit.jsp") != -1)
					  return false;
				 else
					 	 f_query_add_mod.document.forms[0].reset();
//					 f_query_add_mod.document.location.reload();
	}
	else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BLInsAgeLimitQueryCriteria.jsp") != -1)
	{
		 f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eBL/jsp/BLInsAgeLimitQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)			document.forms[0].status.value="E";
	else			document.forms[0].status.value="D";
}

function numberCheck(obj,type,mode)
{
	if(obj.value != "")
	{
		if(CheckNum(obj))
		{
			if(type=="M")
				check_months(obj);
			else  if(type=="D")
				check_days(obj)
			else  if(type=="V")
				chkValidDays(obj,mode);
			
		}
	}
}

function check_months(obj)
{
	if(obj.value!="")
	{
		if(obj.value < 0|| obj.value>11)
		{
			alert (getMessage("MONTHS_CHECK",'Common'));
			obj.value="";
			obj.focus();
		}
	}

}

function check_days(obj)
{
	if(obj.value!="")
	{
		if(obj.value < 0|| obj.value>30)
		{
			alert (getMessage("BL8645",'BL'));			
			obj.value="";
			obj.focus();
		}
	}
}
