<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eIP/js/TransferPatOccupancyDtls.js" language="JavaScript"></Script> 
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eIP/js/TransferPatient.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<script>
var isShift = false;
function setShift(){
		
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
		//alert(isShift)
		}

function shift_tab(){
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
			
			button_c.focus();

	
		}
		
	}
	var isTab = false
	function setTab()
	{
		var keyCode = window.event.keyCode;
		if(keyCode == 9){
			
       //parent.frames[2].document.forms[0].nursing_unit_desc.focus();
		button_c.focus();
		}
	}
	function FirstElement()
	{
		button_c.focus();
	}
</script>

</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey();setShift();setTab();' onLoad='FirstElement()'>

<table cellpadding=0 cellspacing=0 align="right" width="100%" border=0>
 <tr>
		
		<td  align=right><input type="button" class="button" name="button_s" id="button_s" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="submit_Form();" onkeyDown='shift_tab();setTab()'>
		<input type="button" class="button" name="button_c" id="button_c" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();"  onkeyDown='shift_tab();setTab()'></td>
</tr>
</table>

</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

%>

