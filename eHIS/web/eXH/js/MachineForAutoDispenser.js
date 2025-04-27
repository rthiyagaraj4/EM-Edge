function create()
{
	
	window.f_query_add_mod.location.href="../../eXH/jsp/MachineForAutoDispenserMaster.jsp?mode=I";
    window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function query()
{
	window.f_query_add_mod.location.href="../../eXH/jsp/MachineForDispenserQueryCriteria.jsp";
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function apply()
{
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

	if(window.f_query_add_mod.document.Master_machine_for_auto_dispenser)	{

	var formObj1 = parent.content.f_query_add_mod.document.forms[0];
	var mode = formObj1.document.getElementById("mode").value;
	//alert("mode in apply() ::: "+mode);

	var totrecords = formObj1.document.getElementById("machineForAutoDispenserMasterTable").rows.length-1;
	//alert("Total records ::: "+totrecords);

	var rowCount = 0;
	var flag = true;
	if(mode == 'I'){
		for (index = 0; index < totrecords; index++ )
		{
			var machineCode = formObj1.document.getElementById("Machine_Code"+index).value;
			var longDesc = formObj1.document.getElementById("Long_Desc"+index).value;
			var shortDesc = formObj1.document.getElementById("Short_Desc"+index).value;
			if(machineCode.length != 0){
				flag = checkForNull(longDesc, shortDesc);
				//rowCount++;
		    }
			
			if(machineCode == false && index == totrecords - 1) break;
			//rowCount++;

		}
		//alert("rowCount ::: "+rowCount);
		if(flag == true){
		formObj1.method='post';
		formObj1.action="../../servlet/eXH.MachineForDispenserServlet?&mode="+mode+"&rowCount="+totrecords;
		formObj1.target ="messageFrame";
		formObj1.submit();
		window.f_query_add_mod.document.forms[0].reset();
		}
		
	}else if(mode == 'U'){
		var machineCode = formObj1.document.getElementById("Machine_Code").value;
		var longDesc = formObj1.document.getElementById("Long_Desc").value;
		var shortDesc = formObj1.document.getElementById("Short_Desc").value;
		var effStatus = formObj1.document.getElementById("EFF_Status").value;

		formObj1.method='post';
		formObj1.action="../../servlet/eXH.MachineForDispenserServlet?&mode="+mode+"&machineCode="+machineCode+"&longDesc="+longDesc+"&shortDesc="+shortDesc+"&effStatus="+effStatus;
		formObj1.target ="messageFrame";
		formObj1.submit();
		window.f_query_add_mod.document.forms[0].reset();
	}
	}

	window.commontoolbarFrame.document.location.reload();	
	   	
}

function reset()
{
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
	else{
		create();
	}

}

function validatecheckbox(obj) {
	if(obj.checked==true) 	obj.value="Y";
	else  obj.value="N";

}
function addRow()
{
	var class_val ="";

	var totalRows = document.getElementById("machineForAutoDispenserMasterTable").rows.length - 1;
		
	//alert("totalRows.."+totalRows);
	var formObj = parent.frames[0];	
	var machineCode = "";
	var longDesc = "";
	var shortDesc = "";

	var effStatus = "";
	//var newRow = document.all("machineForAutoDispenserMasterTable").insertRow();
	var newRow = document.getElementById("machineForAutoDispenserMasterTable").insertRow();
	var cell1=newRow.insertCell(0);

	var cell2=newRow.insertCell(1);
		
	var cell3=newRow.insertCell(2);
		
	var cell4=newRow.insertCell(3);
	var cell5=newRow.insertCell(4);
	cell1.innerHTML="<td width='25%' nowrap class='label' style='text-align: center;'>&nbsp;&nbsp;<input type='text' nowrap name='"+"Machine_Code"+totalRows+"' id='"+"Machine_Code"+totalRows+"' id='"+"Machine_Code"+totalRows+"'  size='15'  maxlength='2'  onBlur='ChangeUpperCase(this);checkNumber(this);' /><input type='hidden' name='"+"Machine_Code"+totalRows+"' id='"+"Machine_Code"+totalRows+"' /></td>";
	cell2.innerHTML="<td width='25%' nowrap class='label' style='text-align: center;'>&nbsp;<input type='text' nowrap name='"+"Long_Desc"+totalRows+"' id='"+"Long_Desc"+totalRows+"' id='"+"Long_Desc"+totalRows+"' size='50' maxlength='60' onBlur='ChangeUpperCase(this);'/><input type='hidden' name='"+"Long_Desc"+totalRows+"' id='"+"Long_Desc"+totalRows+"' />&nbsp;</td>";
	cell3.innerHTML="<td width='25%' nowrap class='label' style='text-align: center;'>&nbsp;<input type='text' nowrap name='"+"Short_Desc"+totalRows+"' id='"+"Short_Desc"+totalRows+"' id='"+"Short_Desc"+totalRows+"' size='50' maxlength='30' onBlur='ChangeUpperCase(this);'/><input type='hidden' name='"+"Short_Desc"+totalRows+"' id='"+"Short_Desc"+totalRows+"' />&nbsp;</td>";
	cell4.innerHTML="<td width='12%' class='fields'  style='text-align: center;' >&nbsp;&nbsp;&nbsp;<input type=checkbox name ='"+"EFF_Status"+totalRows+"'  onClick='validatecheckbox(this);'></td>";
	cell5.innerHTML="<td width='12%' >&nbsp;</td>";
}


function checkForNull(longDesc, shortDesc){
	var flag;
 	
	var error="";
	
	
	
	var longDesc_label = getLabel("eXH.LongDesc.label","Common");
	
	var shortDesc_label = getLabel("eXH.ShortDesc.label","Common");
	
	if(longDesc=="") {
 		
		flag=false;
 		
		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",longDesc_label)+"<br>";

 	}

   if(shortDesc=="") {
 		
		flag=false;
 		
		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",shortDesc_label)+"<br>";

 	}

	window.messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;

	if(flag==false) return false; else return true;
	
}

