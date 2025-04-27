<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
<%
request.setCharacterEncoding("UTF-8");
//out.println(request.getQueryString());
String gridID = request.getParameter("gridID")==null?"":request.getParameter("gridID");
String grid_desc = request.getParameter("grid_desc")==null?"":request.getParameter("grid_desc");
String gridComponentDefinition = request.getParameter("gridComponentDefinition")==null?"":request.getParameter("gridComponentDefinition");
String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
String grid_max_columns_allowed = request.getParameter("grid_max_columns_allowed")==null?"":request.getParameter("grid_max_columns_allowed"); 
String member_comp_desc = ""		,	member_comp_type = "";
String componentColPos = ""		,	componentColSpan = "";
String textRows = "";
String member_comp_id = "";
String srlno = "";
String dis = "";
String prompt_id = "";
//String prompt_desc = "";
//String prompt_dis = "disabled";
if(mode.equals("Update"))
{
	srlno = request.getParameter("srlno")==null?"":request.getParameter("srlno");
	member_comp_id = request.getParameter("member_comp_id")==null?"":request.getParameter("member_comp_id");
	member_comp_desc = request.getParameter("member_comp_desc")==null?"":java.net.URLDecoder.decode(request.getParameter("member_comp_desc"));
	member_comp_type = request.getParameter("member_comp_type")==null?"":request.getParameter("member_comp_type");
	componentColPos = request.getParameter("componentColPos")==null?"":request.getParameter("componentColPos");
	componentColSpan = request.getParameter("componentColSpan")==null?"":request.getParameter("componentColSpan");
	textRows = request.getParameter("textRows")==null?"":request.getParameter("textRows");
	dis = "disabled";	
}
if(componentColSpan.equals(""))
{
	componentColSpan = "1";
}

%>
<HEAD>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<SCRIPT LANGUAGE="JavaScript">
/*
function callDialogPrompt()
{
		

	var comp_id = document.forms[0].member_compDesc.value;
	var action_url='../../eCA/jsp/CASectionTemplateMessageFrame.jsp';
	var retVal	=	"";
	var dialogHeight= "20" ;
	var dialogWidth	= "40" ;
	var arguments	= "Message" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal = window.showModalDialog("../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=P&comp_id="+comp_id,arguments,features);	

	if(retVal!=null)
	{
		document.templateGridComponentDefinitionForm.prompt_id.value=retVal[0];
		document.templateGridComponentDefinitionForm.prompt_desc.value=retVal[1];
		
	}

}
*/
function checkForUniqueID(srlno)
{
	var no_of_rows = parent.templateGridListFrame.document.getElementById('list_of_components').rows.length - 1;
	//alert(no_of_rows);
	var i=0;
	for(i=0;i<no_of_rows;i++)
	{
		var obj = eval(parent.templateGridListFrame.document.getElementById('list_item_id_'+ (i+1)));
		if(srlno == obj.innerText)
			return false;
	}
	return true;
}
function addToGrid()
{
	var error = "";

	var mode					= document.templateGridComponentDefinitionForm.mode.value;	
	var srlno					= document.templateGridComponentDefinitionForm.srlno.value;	
	var member_comp_id			= document.templateGridComponentDefinitionForm.member_compId.value;
	var member_comp_type		= document.templateGridComponentDefinitionForm.member_comp_type.value;
	var member_comp_desc		= document.templateGridComponentDefinitionForm.member_compDesc.value;
	var componentColPos			= document.templateGridComponentDefinitionForm.componentColPos.value;	
	var componentColSpan		= document.templateGridComponentDefinitionForm.componentColSpan.value;
	var textRows				= document.templateGridComponentDefinitionForm.textRows.value;


	var gridComponentDefinition = document.templateGridComponentDefinitionForm.gridComponentDefinition.value;

	if(mode != "Update")
	{
		if(gridComponentDefinition == "")
		{			
			componentColPos = srlno;
		}
		else
		{			
			var x = gridComponentDefinition.split("|");
			var cur_col_pos = x[x.length-1].split("~")[4];
			var cur_col_span = x[x.length-1].split("~")[5];
			componentColPos = parseInt(cur_col_pos) + parseInt(cur_col_span);
		}																					
	}


	var gridComponentDefinition1 = gridComponentDefinition;	
	var new_def = (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + (member_comp_type != "Short Text"?"NA":(textRows == ""?"1":textRows)));

	if(!checkValue(document.getElementById("textRows"), 2, "Text Rows"))
	{
		return false;
	}
	if(mode == "Update")
	{
		gridComponentDefinition = constructValues(gridComponentDefinition, new_def);
	}
	else
	{
		if(gridComponentDefinition != "")
			gridComponentDefinition += ("|"+ new_def);
		else
			gridComponentDefinition = new_def;	
	}
	var no_of_components = gridComponentDefinition.split("|").length;
	
	if(no_of_components > <%=grid_max_columns_allowed%> )
	{
		//error = ('APP-CA1050 Only <%=grid_max_columns_allowed%> components can be a part of the grid.... ');
		error = getMessage("AM0139","AM");
		error=error.replace("$",grid_max_columns_allowed);
		
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}
	//alert("srlno=" + srlno + " member_comp_id=" + member_comp_id + " componentColPos=" + componentColPos + " componentColSpan=" + componentColSpan );
	if(srlno == "" || member_comp_id == "" || componentColPos == "" || componentColSpan == "")
	{
		//error = ('APP-CA1051 All the fields other than Text-Rows are mandatory...');
		error = getMessage("AM0138","AM");
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}	
	if(mode != "Update")
	{
		if(!checkForUniqueID(srlno))
		{
			//error = ('APP-CA1052 Please enter a unique ID...');
			error = getMessage("AM0141","AM");
			parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false;
		}		
	}
	if(!validateNewComponent(gridComponentDefinition1, componentColPos, componentColSpan, mode, srlno))
	{
		return false;
	}
	document.templateGridComponentDefinitionForm.gridComponentDefinition.value = gridComponentDefinition;	
	parent.templateGridListFrame.document.location.href = "../../eAM/jsp/DiscrMsrCompGridList.jsp?gridID=<%=gridID%>&gridComponentDefinition=" + escape(gridComponentDefinition) + "&grid_max_columns_allowed=<%=grid_max_columns_allowed%>";
	clearFields();
	parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;	
	showGridPreview();
	populatesrlNo();
	document.templateGridComponentDefinitionForm.componentColSpan.value = "1";
}
function validateNewComponent(gridComponentDefinition, componentColPos, componentColSpan, mode, srlno)
{
	var grid_max_columns_allowed = document.templateGridComponentDefinitionForm.grid_max_columns_allowed.value;		
	var currComponentOccupiedCols = new Array();
	var allowedcols = new Array();
	var temp = gridComponentDefinition.split("|");
	var error = "";
	var i = 0;	
	for(i=0;i<componentColSpan;i++)
		currComponentOccupiedCols[currComponentOccupiedCols.length] =  (parseInt(componentColPos) + i);
	//alert(currComponentOccupiedCols);
	var totalcolspan = 0;	
	for(i=0;i<temp.length;i++)
	{
		if(!(mode == "Update" && parseInt(temp[i].split("~")[0]) == srlno))
			totalcolspan += parseInt(temp[i].split("~")[5]);
		for(k=0;k<parseInt(temp[i].split("~")[5]);k++)
		{
			if(!(mode == "Update" && parseInt(temp[i].split("~")[0]) == srlno))
				allowedcols[allowedcols.length] = (parseInt(temp[i].split("~")[4]) + k);
		}
	}	
	/*for(i=0;i<allowedcols.length;i++)
	{
		if(componentColPos == allowedcols[i] && mode != "Update")
		{
			error = ('APP-CA1053 Overlaps existing component....');
			parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false;
		}
		else if(mode == "Update")
		{
			for(j=0;j<currComponentOccupiedCols.length;j++)
			{				
				if(allowedcols[i] == currComponentOccupiedCols[j])
				{
					error = ('APP-CA1054 Overlaps existing component....');
					parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
					return false;
				}
			}
		}
	}*/
	/*for(i=0;i<temp.length;i++)
	{
		if(componentColPos < parseInt(temp[i].split("~")[4]) && mode != "Update")
		{
			error = ('APP-CA1055 Invalid Entry!<br>Please enter components in ascending order of column position....');
			parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false;
		}
	}*/
	//alert("totalcolspan=" + totalcolspan + " componentColSpan=" + componentColSpan + " total=" + (parseInt(totalcolspan) + parseInt(componentColSpan)) );
	if(parseInt(totalcolspan) == <%=grid_max_columns_allowed%>)
	{
		//error = ('APP-CA1056 There is no room for anymore components in this Grid....');
		error = getMessage("AM0140","AM");
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}

	if(((parseInt(totalcolspan) + parseInt(componentColSpan)) > grid_max_columns_allowed) || ((parseInt(componentColPos) + parseInt(componentColSpan)) > (grid_max_columns_allowed + 1))) 
	{
		//error = ('APP-CA1057 This component, with others, occupy more than six columns.<br> Please alter the colspan if this component is required....');
		error = getMessage("AM0142","AM");
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}
	for(i=0;i<temp.length;i++)
	{
		colpos = parseInt(temp[i].split("~")[4]);
		if(!(mode == "Update" && parseInt(temp[i].split("~")[0]) == srlno))
		{
			//alert(temp[i] + " ->colpos=" + colpos + " componentColPos=" + componentColPos);
			if(componentColPos == colpos)
			{
				//error = ('APP-CA1058 Overlaps existing component....');
				error = getMessage("AM0143","AM");
				parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
				return false;
			}
		}
	}
	return true;
}
function constructValues(gridComponentDefinition, new_def)
{	
	var returnValue = "";
	var temp = gridComponentDefinition.split("|");
	var new_srlno = new_def.split("~")[0];
	var i = 0;
	for(i=0;i<temp.length;i++)
	{
		var comp_details = temp[i];
		var srlno = comp_details.split("~")[0];		
		if(srlno == new_srlno)
		{
			if(returnValue == "")
				returnValue += new_def;
			else
				returnValue += ("|" + new_def);
		}
		else
		{
			if(returnValue == "")
				returnValue += comp_details;
			else
				returnValue += ("|" + comp_details);
		}
	}

	temp = returnValue.split("|");
	returnValue = "";
	var prevColPos = 0;

	for(i=0;i<temp.length;i++)
	{
		var srlno = temp[i].split("~")[0];
		var member_comp_id = temp[i].split("~")[1];
		var member_comp_desc = temp[i].split("~")[2];
		var member_comp_type = temp[i].split("~")[3];
		var componentColPos = (prevColPos+1);			
		var componentColSpan = temp[i].split("~")[5];
		var textRows = temp[i].split("~")[6];
//		var prompt_id = temp[i].split("~")[7];
//		var prompt_desc = temp[i].split("~")[8];
		if(i > 0)
		{
			if(temp[i-1].split("~")[5] > 1)
			{			
				componentColPos = prevColPos + parseInt(temp[i-1].split("~")[5]);				
			}
		}
		if(returnValue == "")
		{
			returnValue += (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + textRows);		
		}
		else
			returnValue += ("|" + (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + textRows));		
		prevColPos = componentColPos;
	}
	return returnValue;

}
async function callComponentLookUp()
{	
	var retVal	=	"";
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal = await window.showModalDialog("../../eAM/jsp/DiscrMsrCompLookupMain.jsp?calledFrom=GD",arguments,features);
	if(retVal != null)
	{
		document.templateGridComponentDefinitionForm.member_compId.value = retVal[0];
		document.templateGridComponentDefinitionForm.member_compDesc.value = retVal[1];
		document.templateGridComponentDefinitionForm.member_comp_type.value = retVal[2];
		if(retVal[2] == 'Short Text')
		{
			document.templateGridComponentDefinitionForm.textRows.disabled = false;
			document.templateGridComponentDefinitionForm.textRows.value = "1";
		}
		else
		{
			document.templateGridComponentDefinitionForm.textRows.disabled = true;
			document.templateGridComponentDefinitionForm.textRows.value = "";
		}
	}	

}
function onCancel()
{	
	//window.returnValue = document.templateGridComponentDefinitionForm.gridComponentDefinition_temp.value;
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue =  document.templateGridComponentDefinitionForm.gridComponentDefinition_temp.value;
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
function closeWin()
{
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue =  document.templateGridComponentDefinitionForm.gridComponentDefinition.value;
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
function clearFields()
{
	document.templateGridComponentDefinitionForm.member_compId.value = "";
	document.templateGridComponentDefinitionForm.member_compDesc.value = "";
	document.templateGridComponentDefinitionForm.componentColPos.value = "";
	document.templateGridComponentDefinitionForm.componentColSpan.value = "";
	document.templateGridComponentDefinitionForm.textRows.value = "";
	document.templateGridComponentDefinitionForm.srlno.value = "";
	document.templateGridComponentDefinitionForm.srlno.disabled = false;
	document.templateGridComponentDefinitionForm.delete_button.disabled = true;
	document.templateGridComponentDefinitionForm.addButton.value = "Add To Grid";
	//document.templateGridComponentDefinitionForm.addButton.value = getLabel("Common.Add.label",'Common')+""+getLabel("Common.to.label",'Common')+""+getLabel("Common.all.label",'Common');
	document.templateGridComponentDefinitionForm.mode.value = "";
	populatesrlNo();
}
function checkValue(obj, val, prompt)
{
	if(obj.value > val)
	{
		//error = ('APP-CA1059 ' + prompt + ' cannot be more than ' + val + '...');
		error = getMessage("AM0168","AM");
		error = error.replace("$",prompt);
		error = error.replace("#",val);
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0";	
		obj.select();
		obj.focus();
		return false;
	}	
	else 
		return true;
}
function showGridPreview()
{	
//	alert("397");
	document.templateGridComponentDefinitionForm.target = "templateGridPreviewFrame";
	document.templateGridComponentDefinitionForm.action = '../../eAM/jsp/DiscrMsrCompGridPreview.jsp';
	document.templateGridComponentDefinitionForm.submit();
//	alert("401");
}
function deleteComponent(obj)
{
	var gridComponentDefinition = document.templateGridComponentDefinitionForm.gridComponentDefinition.value;
	var srlno = document.templateGridComponentDefinitionForm.srlno.value;
	
	
	var temp_string = "";
	var grid_temp = gridComponentDefinition.split("|");
	

	for(var i=0;i<grid_temp.length;i++)
	{
		var srlNo_temp = grid_temp[i].split("~")[0];		
		if(!(parseInt(srlNo_temp) == parseInt(srlno)))
		{
			if(temp_string == "")
				temp_string += grid_temp[i];
			else
				temp_string += ("|" + grid_temp[i]);
		}
	}


	var temp = temp_string.split("|");
	temp_string = "";
	returnValue = "";
	var prevColPos = 0;

	for(i=0;i<temp.length;i++)
	{

                   
		var srlno = (i+1);
		var member_comp_id = temp[i].split("~")[1];
		var member_comp_desc = temp[i].split("~")[2];
		var member_comp_type = temp[i].split("~")[3];
		var componentColPos = (prevColPos+1);			
		var componentColSpan = temp[i].split("~")[5];
		var textRows = temp[i].split("~")[6];

		
		if(i > 0)
		{
			if(temp[i-1].split("~")[5] > 1)
			{			
				componentColPos = prevColPos + parseInt(temp[i-1].split("~")[5]);				
			}
		}
		if(temp_string == "")
		{
			
			temp_string += (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + textRows);
		}
		else
			temp_string += ("|" + (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + textRows));		
		prevColPos = componentColPos;

		
	}

 

    if(grid_temp.length == 1)
    {
		temp_string = "";
	}

	document.templateGridComponentDefinitionForm.gridComponentDefinition.value = temp_string;
	parent.templateGridListFrame.document.location.href = "../../eAM/jsp/DiscrMsrCompGridList.jsp?gridID=<%=gridID%>&gridComponentDefinition=" + escape(temp_string) + "&grid_max_columns_allowed=<%=grid_max_columns_allowed%>";
	clearFields();
	parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;	
	showGridPreview();
	//alert("temp_string=" + temp_string);
	obj.disabled = true;
}
function populatesrlNo()
{
	var gridComponentDefinition = document.templateGridComponentDefinitionForm.gridComponentDefinition.value;
	var grid_temp = gridComponentDefinition.split("|");
	var srlNo = 0;
	for(var i=0;i<grid_temp.length;i++)
		srlNo = (isNaN(parseInt(grid_temp[i].split("~")[0]))?0:parseInt(grid_temp[i].split("~")[0]));	
	document.templateGridComponentDefinitionForm.srlno.value = (srlNo+1);
}
function promptcall(obj)
{
	//alert(obj.value);
	if(obj.value == null)
		document.templateGridComponentDefinitionForm.prompt_desc.disabled == true;
	else
		document.templateGridComponentDefinitionForm.prompt_desc.disabled == false;
}
//-->
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY onKeyDown = 'lockKey()'>
<form name="templateGridComponentDefinitionForm" id="templateGridComponentDefinitionForm">
<table align="center" width="100%"  border='0' cellpadding='1' cellspacing='0' id="gridComponentDefinitionTable">
	<tr>
		<th colspan="6">
			<fmt:message key="Common.ComponentDefinition.label" bundle="${common_labels}"/>
		</th>
	</tr>	
	<tr>			
		<td class='labels' width='25%'>
			<fmt:message key="Common.Component.label" bundle="${common_labels}"/>&nbsp;
		</td>
		<td  class='fields' width='25%'>
			<input type="text" name="member_compDesc" id="member_compDesc" readonly value="<%=member_comp_desc%>" >			
			<input type="button" value="?" class="button" onclick="callComponentLookUp();">
			<img src="../../eCommon/images/mandatory.gif">
			<input type="hidden" name="member_comp_type" id="member_comp_type" value="<%=member_comp_type%>">
			<input type="hidden" name="member_compId" id="member_compId" value="<%=member_comp_id%>" >
		</td>
		
<!--				
		<td class='labels' width='25%'><fmt:message key="eCA.Prompt.label" bundle="${ca_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input type='text' name='prompt_desc' id='prompt_desc' value="">
			<input type='button' value='?' name='prompt_btn' id='prompt_btn'  disabled class='button' onclick="callDialogPrompt()">
			
		</td>
		-->

		<td class='labels' width='10%'>
			<fmt:message key="Common.TextRows.label" bundle="${common_labels}"/>&nbsp;		
		</td>

		<td  class='fields' width='20%'>
			<input type="text" name="textRows" id="textRows" value="<%=(textRows.equals("NA")?"":textRows)%>" size="2" maxlength="2" <%=((mode.equals("Update") && !textRows.equals("NA"))?"":"disabled")%> onKeyPress='return(ChkNumberInput(this,event,0))' onblur = "return checkValue(this, 2, 'Text Rows')"> 
		</td>
	</tr>
	<tr>
		<td class='Labels' width='10%' colspan="1">
			<fmt:message key="Common.ColumnSpan.label" bundle="${common_labels}"/>&nbsp;			
		</td>
		<td  class='fields' width='20%' colspan="3">
			<input type="text" name="componentColSpan" id="componentColSpan" value="<%=componentColSpan%>" size="2" maxlength="2" onKeyPress='return(ChkNumberInput(this,event,0))' onblur = "checkValue(this, <%=grid_max_columns_allowed%>, 'Column Span')"> <img src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
</table>
<table width="100%"  border='0' cellpadding='15' cellspacing='0' align="center" id="gridToolbarTable">
	<tr>
		<td  class='fields'>
			<!-- <input type="button" value="Show Preview" class="button" onclick="showGridPreview()" >  -->
			<input type="button" name="addButton" id="addButton" value="<%=(mode.equals("Update")?"Modify":"Add To Grid")%>" class="button" onclick="return addToGrid()">
			<input type="button" value="Delete from Grid" name="delete_button" id="delete_button" class="button" onclick="deleteComponent(this)" <%=mode.equals("Update")?"":"disabled"%>>&nbsp;&nbsp;
		</td>
		<td align="right" width='45%'>&nbsp;&nbsp;	
			<input type="button" value="Save" class="button" onclick="closeWin()">
			<input type="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button" onclick="clearFields()">
			<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="onCancel()">
		</td>
	</tr>
</table>



<table width="100%"  border='0' cellpadding='12' cellspacing='0' align="center" id="temporary_label"  style="display:none;">
	<tr>
		<td class="label" style="font-size:9pt;" align='center'>
		<fmt:message key="eAM.CurrentlySelectedComponentismarkforrepositioning.label" bundle="${am_labels}"/>
<!-- 		</td>
	</tr>
	<tr>
		<td class="label" style="color:red;font-size:9pt;" align ='center'> -->
		<br><br><i style="color:red;font-size:9pt;"><fmt:message key="eAM.ClickonanyotherColumnnumbertoreposition.label" bundle="${am_labels}"/></i>
		</td>
	</tr>

</table>


<input type="hidden" name="srlno" id="srlno" value="<%=srlno%>" size="2" maxlength="2" <%=dis%>>	
<input type="hidden" name="componentColPos" id="componentColPos" value="<%=componentColPos%>">
<input type="hidden" name="gridComponentDefinition" id="gridComponentDefinition" value="<%=gridComponentDefinition%>">
<input type="hidden" name="gridComponentDefinition_temp" id="gridComponentDefinition_temp" value="<%=gridComponentDefinition%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="gridID" id="gridID" value="<%=gridID%>">
<input type="hidden" name="grid_desc" id="grid_desc" value="<%=grid_desc%>">
<input type="hidden" name="grid_max_columns_allowed" id="grid_max_columns_allowed" value="<%=grid_max_columns_allowed%>">
<!--input type='hidden' name='prompt_id'  value='<%=prompt_id%>'> -->
</form>
</BODY>
</HTML>
<%if(mode.equals("")){%>
	<script>
		showGridPreview();
		populatesrlNo();
	</script>
<%}%>

