<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCA/html/CAStyle.css"></link>


	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

<script language='JavaScript'>
function close_function()
{
	
	if(parent.frames[0].document.forms[0].flag.value==0 && parent.frames[1].document.forms[0].flag.value==0)
	{
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		window.close();
	}
}

function  subwindow(obj,nature)
{
	var factors = "";
	var cnt = 0;
	var cnt1 = 0;
	if(nature!="W" && nature!="")
	{
		var ilCount = parent.frames[0].document.forms[0].ilCount.value
		for(var index  = 0; index< parseInt(ilCount);index++)
		{
			var objCheck = eval("parent.frames[0].document.forms[0].evidence"+index)
			if(objCheck.checked==true)
			{
				if(factors=="")
				factors = objCheck.value
				else
				factors = factors + "~" +  objCheck.value
				cnt++;
			}
		 }
	}
	  var ilRow = parent.frames[1].document.forms[0].ilRow.value;
	  var defn_chars = ""
	  for(var index  = 0; index < parseInt(ilRow);index++)
	  {
		var objCheck = eval("parent.frames[1].document.forms[0].evidence"+index)
		if(objCheck.checked==true)
			{
				if(defn_chars=="")
				defn_chars = objCheck.value
				else
				defn_chars = defn_chars + "~" +  objCheck.value
				cnt++;
			}
	  }

		/*if((cnt == 0 && ( nature!="W" && nature!="")) && cnt1 == 0 )
		{
		alert(getMessage('MR_SELECT_ONE_FTR_CODE','MR'));
			obj.disabled = true;
			return false;
		}
		else if( cnt1 == 0 && ( nature=="W" || nature==""))
		{
		alert(getMessage('MR_SELECT_ONE_FTR_CODE','MR'));
			obj.disabled = true;
			return false;
		}*/
		if(cnt == 0)
		{
			
			alert(getMessage('MR_SELECT_ONE_FTR_CODE','MR'));
			obj.disabled = true;
			return false;
		}
		else
		{
			 var p_factor_type ="";
			 if(nature!="W" && nature!="")
			{
				  p_factor_type= parent.frames[0].document.forms[0].Eve_factor_type.value;
			}
			 var d_factor_type = parent.frames[1].document.forms[0].define_factor_type.value;
			window.returnValue = factors + "||" + defn_chars+"#"+p_factor_type + "^" + d_factor_type;
			 window.close();
		}
}

function closew()
{	
	window.returnValue=''
	window.parent.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String nature= request.getParameter("nature")==null?"":request.getParameter("nature");
%>
<body onKeyDown='lockKey()'>
<form name="RecDiagnosisEvidenceDtlToolbarForm" id="RecDiagnosisEvidenceDtlToolbarForm">

	<input type="hidden" name = "as_evidenced_by_fact" value="">
	<input type="hidden" name = "as_evidenced_by_defn" value="">	
	<input type="hidden" name = "p_factor_type" value=''>
	<input type="hidden" name = "d_factor_type" value=''>	

<div align='right'>
<table  cellpadding='0' cellspacing='0' width='100%' height='100%' >
			<tr align="center">
				<td colspan='4'>&nbsp;</td>
				<td class='button' align="right">
				<input type='button' name='OK' id='OK' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick="subwindow(this,'<%=nature%>')" class='button'>
				<input type='button' name='Cancel' id='Cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='window.close();' class='button'>
				</td>
			</tr>
</form>
</table>	
</div>
<script>
	setTimeout('close_function()',1000)
</script>
</body>
</html>

