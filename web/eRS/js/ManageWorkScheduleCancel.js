function on_apply()
{ 
  var formObj=document.ManageWorkScheduleCancel_Form;
  var total_records=parseInt(formObj.total_Records.value);
  var flag=parseInt(0);
  var select="";
  var select1="";
  var message="";
 // alert("message====>" +message);

  if(formObj.Reason.value=="")
  { 
   message=getMessage("REASON_BLANK","RS");
   alert(message);
   return false;
  }

 for(i=1;i<=total_records;i++)
 {
   select1=eval("formObj.select"+i);
   if(select1.checked==true)
   {
    select1.value="Y";
    flag++;
    }
    else
    {
     select1.value="N";
    }
 }

  if(flag<=0)
  {
    alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
    return false;
  }
  else if(flag>0)
  {
  formObj.submit();
  }
}
//*****************************************************************************
function on_close()
{
  window.close();
}
//*****************************************************************************
function checkForMax(obj)
{
  var value=obj.value;
  if(value.length>2000)
  {
    alert(getMessage("REMARKS_XCEED_2000_CHARS","RS"));
   obj.select();
   obj.focus();
   return false;
  }
  else
  {
   return true;
  }
}
