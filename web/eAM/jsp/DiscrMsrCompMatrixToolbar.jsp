<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
<HEAD>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
		  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		  <script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
<SCRIPT LANGUAGE="JavaScript">
function checkMatrix()
{
	var matrix_colSpans = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_colSpans.value;
	var matrix_starting_pos = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_starting_pos.value;
	var matrix_cols = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_cols.value;
	var matrix_rows = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_rows.value;
	var componentDetails = "";
	var emptyRowFlag = 0;
	var colHeaders = "", rowHeaders = "";
	var colHeadersId = "",rowHeadersId = "";
	for(var i=0;i<matrix_rows;i++)
	{
		emptyRowFlag = 0;
		for(var j=0;j<matrix_cols;j++)
		{
			var componentIdObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compID" + i + j);		
			if(componentIdObj != null)
			{
				if(componentIdObj.value == "")
					emptyRowFlag++;
			}
		}
		if(emptyRowFlag == matrix_cols)
		{
			alert('APP-AM10092 Row No...' + (i+1) + ' does not have all the components defined...' );
			return "";
		}
	}
	var emptyColumnFlag = 0;
	for(var i=0;i<matrix_cols;i++)
	{
		emptyColumnFlag = 0;
		for(var j=0;j<matrix_rows;j++)
		{
			var componentIdObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compID" + j + i);			
			if(componentIdObj != null)
			{
				if(componentIdObj.value == "")
					emptyColumnFlag++;
			}
		}
		if(emptyColumnFlag == matrix_rows)
		{
			alert('APP-AM10092 Column No...' + (i+1) + ' does not have all the components defined...' );
			return "";
		}
	}
	for(var i=0;i<matrix_rows;i++)
	{	
		if(componentDetails != "")
			componentDetails += "||";
		for(var j=0;j<matrix_cols;j++)
		{
			var member_compIDObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compID" + i + j);
			var member_compDescObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compDesc" + i + j);
			var member_compTypeObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compType" + i + j);
			if(member_compIDObj != null)
			{
				var temp = (member_compIDObj.value + "~" + escape(member_compDescObj.value) + "~" + escape(member_compTypeObj.value));
				temp = (temp=="~~"?"9999999999~9999999999~9999999999":temp);
				if(j == 0)
					componentDetails += temp;
				else
					componentDetails += ("|" + temp);
			}
		}
	}	
	for(var i =0;i<matrix_cols;i++)
	{
		var colHeaderObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixColHeader_" + i);
		var colHeadersIdObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixColHeaderId_C_" + i);
		if(colHeaderObj != null )
		{
			if(colHeaderObj.value == "" )
			{
				alert('APP-AM10092 Header for Column ' + (i+1) + ' has not been defined...' );
				return "";
			}			
			if(colHeaders == 0)
			{
				colHeaders += escape(colHeaderObj.value);
				colHeadersId += escape(colHeadersIdObj.value);
			}
			else
			{
				colHeaders += "~" + escape(colHeaderObj.value);
				colHeadersId += "~" + escape(colHeadersIdObj.value);
			}
		}
	}
	for(var i =0;i<matrix_rows;i++)
	{
		var rowHeaderObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixRowHeader_" + i);
		var rowHeadersIdObj = eval("parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixRowHeaderId_R_" + i);
		if(rowHeaderObj != null)
		{
			if(rowHeaderObj.value == "" )
			{
				alert('APP-AM10092 Header for Row ' + (i+1) + ' has not been defined...' );
				return "";
			}		
			if(rowHeaders == 0)
			{
				rowHeaders += escape(rowHeaderObj.value);
				rowHeadersId += escape(rowHeadersIdObj.value);
			}
			else
			{
				rowHeaders += "~" + escape(rowHeaderObj.value);
				rowHeadersId += "~"+escape(rowHeadersIdObj.value);
			}
		}
	}
	var retVal = matrix_cols + "$$$" + matrix_rows + "$$$" + matrix_starting_pos + "$$$" + matrix_colSpans + "$$$" + componentDetails + "$$$" + colHeaders + "$$$" + rowHeaders+ "$$$"+ colHeadersId + "$$$" + rowHeadersId;
	return retVal;
}
function closeAndReturn()
{
	var matrix_cols = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_cols.value;
	var matrix_rows = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_rows.value;
	
	if(matrix_cols == "" || matrix_rows == "")
	{
		//error = ('APP-CA1050 Please enter all the mandatory fields.... ');
		error = getMessage("AM0169","AM");

		//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		return false;
	}else{
		//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
		parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}

	if(matrix_cols == 0)
	{
		
		error = getMessage("AM0170","AM");
		error = error.replace("$",'Matrix Columns');
		//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		return false;
	}else{
		//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
		parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
	if(matrix_rows == 0)
	{
		
		error = getMessage("AM0170","AM");
		error = error.replace("$",'Matrix Rows');
		//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		return false;
	}
    else{
		//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
    	parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}

	if (parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm){
	var retVal = checkMatrix();
	if(retVal != "")
	{
		//window.returnValue = retVal;
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retVal;
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	}
}
}
function onCancel()
{
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue =  null;
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown = 'lockKey()'>
<form name="templateComponentMatrixToolbarForm" id="templateComponentMatrixToolbarForm">
	<table width="99%">
		<tr>
			<td align='right'>
				<input type="button" name="OK" id="OK" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="closeAndReturn()">
				<input type="button" name="Cancel" id="Cancel" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="onCancel()">
			</td>
		</tr>
	</table>
</form>
</BODY>
</HTML>

