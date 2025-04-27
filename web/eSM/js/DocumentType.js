
function create() {
	//document.getElementById("mainFrame").rows="8%,*%,50%,10%"
	document.getElementById("commontoolbarFrame").style.height="8vh";
		document.getElementById("f_query_add_mod").style.height="32vh";
		document.getElementById("f_query_add_modcr").style.height="50vh";
		document.getElementById("messageFrame").style.height="10vh";
	f_query_add_mod.location.href = "../../eSM/jsp/addModifyDocumentType.jsp?operation=insert" ;
	f_query_add_modcr.location.href = "../../eSM/jsp/addModifyDocTypeModule.jsp?operation=insert" ;
	

	
}
function query() {
	//document.getElementById("mainFrame").rows="8%,*%,0%,10%"
	document.getElementById("commontoolbarFrame").style.height="8vh";
		document.getElementById("f_query_add_mod").style.height="82vh";
		document.getElementById("f_query_add_modcr").style.height="0vh";
		document.getElementById("messageFrame").style.height="10vh";
	f_query_add_mod.location.href="../../eSM/jsp/DocumentTypeQueryCriteria.jsp";
	f_query_add_modcr.location.href="../../eCommon/html/blank.html";
	
}

function clickVal(obj)
{
	
	if(obj.checked==true)
	{
		obj.value='Y';

		if(obj.name == 'eff_status1')
		{
			document.forms[0].startdocnum.disabled=false;
			document.forms[0].nextdoctype.disabled=false;	
			document.getElementById("giffrom").style.visibility="visible";
			document.getElementById("gifto").style.visibility="visible";
		}
	}
	else
	{
		obj.value='N';

		if(obj.name == 'eff_status1')
		{
			document.forms[0].startdocnum.disabled=true;
			document.forms[0].nextdoctype.disabled=true;
			document.forms[0].startdocnum.value="";
			document.forms[0].nextdoctype.value="";
			document.getElementById("giffrom").style.visibility="hidden";
			document.getElementById("gifto").style.visibility="hidden";
		}
	}
}


function apply()
  {
  	if(f_query_add_mod.document.documenttype_form!=null){

		if(f_query_add_mod.document.documenttype_form.startdocnum!=null){
       SpeIntCheck1(f_query_add_mod.document.documenttype_form.startdocnum)
		}

	var fields = new Array(f_query_add_mod.document.forms[0].basedon,f_query_add_mod.document.forms[0].doctype,f_query_add_mod.document.forms[0].longdescription,f_query_add_mod.document.forms[0].shortdescription);

	var names = new Array (getLabel("Common.Basedon.label","Common"),
		getLabel("Common.DocType.label","Common"),
				getLabel("Common.longdescription.label","Common"),
		getLabel("Common.shortdescription.label","Common"))

	var fields1 = new Array(f_query_add_mod.document.forms[0].basedon,f_query_add_mod.document.forms[0].doctype,f_query_add_mod.document.forms[0].longdescription,f_query_add_mod.document.forms[0].shortdescription,f_query_add_mod.document.forms[0].startdocnum,f_query_add_mod.document.forms[0].nextdoctype);
	var names1 = new Array (getLabel("Common.Basedon.label","Common"),getLabel("Common.DocType.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("eSM.StartDocNo.label","SM"),getLabel("eSM.NextDocNo.label","SM"))

	if(f_query_add_mod.documenttype_form.eff_status1.value == 'N')
	{
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
			f_query_add_modcr.documenttype_form1.basedon.value = f_query_add_mod.documenttype_form.basedon.value;
			f_query_add_modcr.documenttype_form1.doctype.value = f_query_add_mod.documenttype_form.doctype.value;
			f_query_add_modcr.documenttype_form1.longdescription.value = f_query_add_mod.documenttype_form.longdescription.value;
			f_query_add_modcr.documenttype_form1.shortdescription.value = f_query_add_mod.documenttype_form.shortdescription.value;
			f_query_add_modcr.documenttype_form1.eff_status1.value = f_query_add_mod.documenttype_form.eff_status1.value;
			f_query_add_modcr.documenttype_form1.startdocnum.value = f_query_add_mod.documenttype_form.startdocnum.value;
			f_query_add_modcr.documenttype_form1.nextdoctype.value = f_query_add_mod.documenttype_form.nextdoctype.value;
			f_query_add_modcr.documenttype_form1.autoprint.value =
			f_query_add_mod.documenttype_form.autoprint.value;
			f_query_add_modcr.documenttype_form1.entitymode.value =
			f_query_add_mod.documenttype_form.entitymode.value;
			f_query_add_modcr.documenttype_form1.operation.value = f_query_add_mod.documenttype_form.operation.value;
			
			f_query_add_modcr.document.documenttype_form1.submit();
			//f_query_add_modcr.document.documenttype_form1.doctype.value="";
			
		}
	}
	else
	{
		if(f_query_add_mod.checkFieldsofMst( fields1, names1, messageFrame))
		{
			f_query_add_modcr.documenttype_form1.basedon.value = f_query_add_mod.documenttype_form.basedon.value;
			f_query_add_modcr.documenttype_form1.doctype.value = f_query_add_mod.documenttype_form.doctype.value;
			f_query_add_modcr.documenttype_form1.longdescription.value = f_query_add_mod.documenttype_form.longdescription.value;
			f_query_add_modcr.documenttype_form1.shortdescription.value = f_query_add_mod.documenttype_form.shortdescription.value;
			f_query_add_modcr.documenttype_form1.eff_status1.value = f_query_add_mod.documenttype_form.eff_status1.value;
			f_query_add_modcr.documenttype_form1.startdocnum.value = f_query_add_mod.documenttype_form.startdocnum.value;
			f_query_add_modcr.documenttype_form1.nextdoctype.value = f_query_add_mod.documenttype_form.nextdoctype.value;
			f_query_add_modcr.documenttype_form1.autoprint.value =
			f_query_add_mod.documenttype_form.autoprint.value;
			f_query_add_modcr.documenttype_form1.entitymode.value =
			f_query_add_mod.documenttype_form.entitymode.value;
			f_query_add_modcr.documenttype_form1.operation.value = f_query_add_mod.documenttype_form.operation.value;

			f_query_add_modcr.document.documenttype_form1.submit();
		}

	}
  }
  else
	  {

	  frames[0].location.reload();
	  return false;
	  }
  }

  function onSuccess()
  {
	 // document.documenttype_form1.doctype.value="";
	  f_query_add_mod.location.reload();
	  f_query_add_modcr.location.reload();
  }

  function ChkNumberInput(fld, event, decimal)
	{
	if (parseInt(decimal)>0)
		var strCheck = '0123456789 /:';
	else
		var strCheck = '0123456789 /:';

	var whichCode = (window.Event) ? event.which : event.keyCode;
	if (whichCode == 13) return true;  // Enter
    var fldvalue=fld.value;

	for(var i=0;i<fldvalue.length;i++)
    {
		if(i == 0)
		{
			if(fldvalue.charAt(i)=='0')
				return false;
		}
		else
		{
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
		}

	}
}

function loaddetail()
{
	DOC_TYPE_CODE=document.getElementById("DOC_TYPE_CODE").value;
	//f_query_add_mod.location.href = "../../eSM/jsp/addModifyDocumentType.jsp?DOC_TYPE_CODE="+DOC_TYPE_CODE;
	if(parent.f_query_add_modcr)
	{

	f_query_add_modcr.location.href = "../../eSM/jsp/addModifyDocTypeModule.jsp?DOC_TYPE_CODE="+DOC_TYPE_CODE;
	}
}



function chkStDocNum(obj)
{
	if(obj.value == "")
	{
		var obj1=getMessage('CAN_NOT_BE_BLANK','Common')
		obj1=obj1.replace("$",getLabel("eSM.StartDocNo.label","SM"))
		alert(obj1);
		document.forms[0].eff_status1.focus();
	}
	else if(obj.value == 0)
	{
		var obj1=getMessage('START_DOC_NUMBER','SM')
		alert(obj1);
		document.forms[0].startdocnum.value="";
		document.forms[0].nextdoctype.value="";
		document.forms[0].startdocnum.focus();

	}
	else
		document.forms[0].nextdoctype.value=obj.value;

	
	
}

function reset()
{
	 frames[1].location.reload();
	 frames[2].location.reload();
}

function chkNxtNo(nxtno,stno)
{
	if (nxtno.value < stno.value)
	{
		alert(getMessage("START_NO_GR_END_NO","SM"));
		nxtno.value="";	
		nxtno.focus();
	}
	
}


function CheckFac(Obj)
{
	var facilityId=document.forms[0].facilityId.value;
	var basedon=document.forms[0].basedon.value;
 	var str=Obj.value;
	
	var str1 =str.substring(0,2);

	if(basedon=='F')
    { 
		if(str1!=facilityId)
		{
			alert(getMessage("DOC_TYPE_VALIDATION","SM"));
			document.forms[0].doctype.value=facilityId;
			document.forms[0].doctype.focus();
			
		}
		if(str=='')
		{
			document.forms[0].doctype.value=facilityId;
			document.forms[0].doctype.focus();
		}			

	}
}
function checkdeco(Obj)
{
	var facilityId=document.forms[0].facilityId.value;
	if(Obj.value=='F')
	{
	document.forms[0].doctype.value=facilityId;
	}
	else
	{
		document.forms[0].doctype.value="";

	}
	
}



function SpeIntCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^0-9\s]/i.test(fldval)) { // only integer and space allowed
alert ("You have entered invalid integer - try again!");
which.value = "";
which.focus();
return false;
}
}
function SpeIntCheck1(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^0-9\s]/i.test(fldval)) { // only integer and space allowed
alert ("You have entered invalid StartDocNo - try again!");
which.value = "";
which.focus();
return false;
}
}

function CheckForSpecCharsone(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function SpeCharCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^-_a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
alert ("You have entered one or more invalid characters - try again!");
which.value = "";
which.focus();
return false;
}
}
