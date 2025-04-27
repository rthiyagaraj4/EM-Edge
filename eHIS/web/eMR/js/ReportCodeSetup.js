function create() { 
f_query_add_mod.location.href = "../../eMR/jsp/ReportCodeSetupQueryMain.jsp?facilityId="+facId ;
}

 function checkVal(obj)
 {
var temp_val= obj.value;
 //var val=parseInt(obj.value)
	// alert('8 value'+val);
 if(temp_val=='0')
 {
	alert(getMessage('INVALID_SERIAL_NO','MR'));
	//parent.frames[1].document.location.reload();
	obj.focus();
	return false;
 }
 if(temp_val=='01')
 {
	 obj.value=1;
	 return false;
 }
if(temp_val=='02')
 {
	 obj.value=2;
	return false;
 }
 if(temp_val=='03')
 {
	 obj.value=3;
	 return false;
 }
 if(temp_val=='04')
 {
	 obj.value=4;
	 return false;
 }
 if(temp_val=='05')
 {
	obj.value=5;
    return false;
 }
 if(temp_val=='06')
 {
	 obj.value=6;
     return false;
 }
 if(temp_val=='07')
 {
	 obj.value=7;
     return false;
 }
 if(temp_val=='08')
 {
	 obj.value=8;
     return false;
 }
 if(temp_val=='09')
  {
  obj.value=9;
  return false;
 }
 /*if(parseInt(obj.value)==parseInt(slno))
 {
	 
 }
 else
 {
obj.value=""
obj.focus();
 alert("Order Serial no that must be entered is "+slno);
 parent.frames[1].document.location.reload();
 return false;
 }*/

 }
function apply()
{
   // alert("coming");
	parent.frames[1].document.frames[1].document.frames[1].document.forms[0].action="../../servlet/eMR.ReportCodeSetup";
	parent.frames[1].document.frames[1].document.frames[1].document.forms[0].target="messageFrame";
    parent.frames[1].document.frames[1].document.frames[1].document.forms[0].submit();
}

var facId='';
function onSuccess()
{
	create();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.FocusFirstElement();
	}
	else
	{
		f_query_add_mod.frames[0].document.forms[0].reset();
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
}
function query()
{
  f_query_add_mod.location.href = "../../eMR/jsp/ReportGroupQueryCriteria.jsp"
}
function chkDescription(obj){

  var str=obj.name;
  var name=str.substring(3,str.length)
  
  if(obj.checked==true){
	  obj.value="Y";
	 var obj2=eval("document.forms[0].report_desc"+name)
	 obj2.disabled=false;
	 var obj4=eval("document.forms[0].group_name"+name)
	 obj4.disabled=false;
	 var obj3=eval("document.forms[0].serial_no"+name)
	 obj3.disabled=false;
	 var obj3=eval("document.forms[0].sub_group"+name)
	 obj3.disabled=false;
 }else{
	 obj.value="N";
	 var obj2=eval("document.forms[0].report_desc"+name)
	 obj2.value="";
	 obj2.disabled=true;
	 var obj4=eval("document.forms[0].group_name"+name)
	 //obj4.options[0].selected=true;
	 obj4.disabled=true;
	 var obj3=eval("document.forms[0].serial_no"+name)
	 obj3.value="";
	 obj3.disabled=true;
	 var obj3=eval("document.forms[0].sub_group"+name)
	 obj3.disabled=true;

 }
	
 }

 //////////////////////////////////////////////



 //////////////////////////////////////////
