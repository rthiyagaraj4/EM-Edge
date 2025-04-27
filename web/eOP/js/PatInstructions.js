
async function getInstructionDesc(target)
{		
		var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
	    var tit=getLabel("eAM.InstructionDescript.label","AM");
		var retVal				=  new String();
		var locale=document.forms[0].locale.value;		
		if(target.value=="" && window.event.target == target){
			document.forms[0].instruction_id.value="";
			return;
		}

        var sql = "select instruction_id code, instruction_desc description from am_pat_instructions_lang_vw where eff_status = 'E' and LANGUAGE_ID='"+locale+"' and upper(instruction_id) like upper(?) and upper(instruction_desc) like upper(?) order by 2";

        
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK  ;
		argumentArray[7] = CODE_DESC ;
	
		retVal = await CommonLookup( tit, argumentArray );
		
		var arr=new Array();

		if(retVal != null && retVal != "" )
		{
			 var retVal=unescape(retVal);		
		   	 arr=retVal.split(",");	             
            /*Added below line by Senthil on 21-Oct-2011*/
             var instructions = "";		
			if(arr.length >2){  
				for(var i=1;i<arr.length;i++){					 
					 if(i>1)instructions = instructions + ",";
					 instructions = instructions + arr[i];
				 }
				 if(instructions != "")
				   arr[1]= instructions;
			}
			 /*End*/			 
			 document.forms[0].instruction_id.value=arr[0];			 
			 document.forms[0].instruction_desc.value=arr[1];
             			 
		}
		else
		{
			document.forms[0].instruction_desc.value="";
			document.forms[0].instruction_id.value="";			
		}     
}

function addRecord()
{	
	var serial_no= document.forms[0].serial_no.value;
	var instruction_id=document.forms[0].instruction_id.value;
	var instruction_desc=document.forms[0].instruction_desc.value;	
	var mode_flag=document.forms[0].mode_flag.value;
	var function_id=document.forms[0].function_id.value;


	var maxSize=10;	
	if(mode_flag !="true"){
		
	if(serial_no==null || serial_no=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK",'Common');
		error=error.replace("$",getLabel("Common.SerialNo.label","Common"));
		alert(error);
		document.forms[0].serial_no.focus();
		return false;
	}
	else if(instruction_desc==null || instruction_desc=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK",'Common');
		error=error.replace("$",getLabel("eAM.InstructionDescript.label","AM"));
		alert(error);
        document.forms[0].instruction_desc.focus();
		return false;
	}	
    else if(serial_no > maxSize || serial_no=='0' || serial_no=='00')
	{
		alert(getMessage("INS_BET_1_AND_10","AM"));
        document.forms[0].serial_no.value="";
        document.forms[0].serial_no.focus();
		return false;
	}
	else
	{	/*Added encodeURIComponent() in desc by Senthil on 21-Oct-2011*/
	   //parent.parent.frames[1].pat_frame.rows="18%,10%,*";
	   //Above line Commented and Below line Added for this incident [IN:038056]
	   
	   //parent.parent.frames[1].pat_frame.rows="21%,10%,*";
        parent.document.getElementById("clinic_main").style.height="110px";
		parent.document.getElementById("clinic_sub").style.height="52px";
		parent.document.getElementById("dummyframe").style.height="358px";   
	   parent.frames[2].location.href="../../eOP/jsp/PatInstructionsResult.jsp?serial_no="+serial_no+"&instruction_id="+instruction_id+"&function_id="+function_id+"&instruction_desc="+encodeURIComponent(instruction_desc)+"&mode=add";
	}
	clearFields();
	}else{
	   clearFields();
	   parent.frames[1].document.forms[0].add.value=getLabel("Common.Add.label","Common");
	   document.forms[0].mode_flag.value="false";
	}
}

function clearFields()
{
	document.forms[0].serial_no.value="";
	document.forms[0].instruction_id.value="";
	document.forms[0].instruction_desc.value="";
	document.forms[0].add.disabled=false;
	document.forms[0].del.disabled=true;	
}

function CheckForSpecChar(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;	
    key = String.fromCharCode(whichCode);  // Get key value from key code	
    if (strCheck.indexOf(key) == -1) return false;	// Not a valid key	
	
	return true ;
 }

function deleteRecord()
{
	var sno=document.forms[0].serial_no.value;	
    parent.frames[2].location.href="../../eOP/jsp/PatInstructionsResult.jsp?serial_no="+sno+"&mode=delete";
	clearFields();	
    parent.frames[1].document.forms[0].add.value=getLabel("Common.Add.label","Common");
	document.forms[0].mode_flag.value="false";
}

function putvalues(j)
{	
	parent.frames[1].document.forms[0].serial_no.value=eval("parent.frames[2].document.forms[0].serialno"+j).value;
	parent.frames[1].document.forms[0].instruction_desc.value=eval("parent.frames[2].document.forms[0].desc"+j).value;
	parent.frames[1].document.forms[0].instruction_id.value=eval("parent.frames[2].document.forms[0].id"+j).value;
	parent.frames[1].document.forms[0].del.disabled=false;	
	parent.frames[1].document.forms[0].mode_flag.value="true";
	parent.frames[1].document.forms[0].add.value=getLabel("Common.clear.label","Common");
}

function deafult_check(obj,pos)
{	
	var deafult_yn;
	var position;
	if(obj.checked==true)
		deafult_yn="Y";
	else
		deafult_yn="N";
	position=pos;
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../eOP/jsp/PatInstructionsAddModify.jsp'><input type='hidden' name='deafult_yn' id='deafult_yn' value='"+deafult_yn+"'><input type='hidden' name='position' id='position' value='"+position+"'></form></BODY></HTML>";
    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.form1.submit();
	  
}

function CheckForZero()
{
	var a;
	a=document.forms[0].serial_no.value;	
	document.forms[0].serial_no.value=parseInt(a,'10');
	
}

