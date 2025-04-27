function reset()
   {
	   //alert("inside reset");
	     parent.frames[2].frames[1].document.forms[0].reset();
		 parent.frames[2].frames[1].document.forms[0].process_id.focus();
   }

function apply()
 {
	 
	var fields = new Array(parent.frames[2].frames[1].document.forms[0].process_id,
				  parent.frames[2].frames[1].document.forms[0].from_date,
				  parent.frames[2].frames[1].document.forms[0].to_date
				  );
				  
	 var names  = new Array (getLabel("Common.Process.label","Common"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	  
	 if(f_query_add_mod.checkFields( fields, names, parent.frames[2].frames[2])) 
		{
			parent.frames[2].frames[1].document.forms[0].action="../../servlet/eSM.PurgeBGProcessErrMsgServlet";
			parent.frames[2].frames[1].document.forms[0].target="messageFrame";
			
			parent.frames[2].frames[1].document.forms[0].submit();
		}
		
		parent.frames[2].frames[1].document.forms[0].process_id.focus();
		
 }

function onSuccess() 
{
	
 parent.frames[2].frames[1].document.location.href="../../eSM/jsp/PurgeBGProcessErrMsgDetail.jsp" ;
 
	// messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= "
}
/** Added for Date Validation **/



function DateValidation(obj)
{//   alert("check date :"+obj);
	var msg="";

	if(obj.name=="from_date")
		//alert("check date1 :"+obj.name);
	   msg = getMessage("FROM_DT_NGE_CURR_DATE","SM");
	if(obj.name=="to_date")
	   msg = getMessage("TO_DT_NGE_CURR_DATE","SM");
	
	if(!(isBeforeNow(obj.value,"DMY",localeName)))
	{
		if(obj.value!=''){
		obj.focus();
		obj.select();
		obj.value='';
		alert(msg);
		}
	}
}

function ValidateDateTimesp (from,obj)
{
  if(obj.value.length>0)
	   if(validDateObj(obj,"DMY",localeName)){
			DateValidation(obj);
			DateValidation(from);
			if(document.forms[0].from_date.value!="" && document.forms[0].to_date.value!="")
			{
			  if(!(isBefore(document.forms[0].from_date.value,document.forms[0].to_date.value,"DMY",localeName)))
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
						document.forms[0].to_date.select();
						
					}
			}
		}
}
