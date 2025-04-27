/*New file to control the Patient Instructions for each Nursing Unit*/
async function getInstructionDesc(target) // This function gets the instructions (id and desc) from the patient Instructions included in  AM
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
             var instructions = "";		
			if(arr.length >2){  
				for(var i=1;i<arr.length;i++){					 
					 if(i>1)instructions = instructions + ",";
					 instructions = instructions + arr[i];
				 }
				 if(instructions != "")
				   arr[1]= instructions;
			}					 
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
{	//This function performs the validation and adds the instructions to the associateDiagBean.
	var serial_no= document.forms[0].serial_no.value;
	var instruction_id=document.forms[0].instruction_id.value;
	var instruction_desc=document.forms[0].instruction_desc.value;	
	var mode_flag=document.forms[0].mode_flag.value;

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
	{	
		/*parent.nur_unit_frame.rows="42,30%,*,5%";*/ 
		document.forms[0].ins_flag.value="true";		
		parent.frames[2].location.href="../../eIP/jsp/IPPatInstructionsResult.jsp?serial_no="+serial_no+"&instruction_id="+instruction_id+"&instruction_desc="+encodeURIComponent(instruction_desc)+"&mode=add";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="30vh";
		parent.document.getElementById("blank").style.height="57vh";
		parent.document.getElementById("messageFrame").style.height="5vh"; 
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
//This function clears all the fields related to the patient Instructions in the Nursing unit modification page.
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
	//This function is to delete a record from the list of instructions included to the Nursing Unit.
	var sno=document.forms[0].serial_no.value;	
    parent.frames[2].location.href="../../eIP/jsp/IPPatInstructionsResult.jsp?serial_no="+sno+"&mode=delete";
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
	
/*	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../eIP/jsp/IPPatInstructionsAddModify.jsp'><input type='hidden' name='default_yn' id='default_yn' value='"+deafult_yn+"'><input type='hidden' name='position' id='position' value='"+position+"'></form></BODY></HTML>";
    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.messageFrame.form1.submit();
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';*/
	//Added for 39926
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='twelve'  default_yn=\""+deafult_yn+"\" position=\""+position+"\"  /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText= trimString(responseText)
	  
}

function CheckForZero()
{
	var a;
	a=document.forms[0].serial_no.value;	
	document.forms[0].serial_no.value=parseInt(a,'10');
	
}

