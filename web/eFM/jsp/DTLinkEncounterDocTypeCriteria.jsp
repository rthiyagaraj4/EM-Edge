<!DOCTYPE html>
<%@ page import="java.sql.Connection, webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection connection			=	null;	

try
{
	String facilityID 	=	(String) session.getAttribute("facility_id");
	if (facilityID==null) facilityID=	"";	
	
	connection		=	ConnectionManager.getConnection(request);	

%>	

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function getResults()
{
	var doc_folder_id			= document.forms[0].doc_folder_id.value;	
	var patient_id				= document.forms[0].patient_id.value;	
	var patient_period_specific	= document.forms[0].patient_period_specific.value;	
	var from_period				=  "";
	var to_period				=  "";
	if (patient_period_specific=="D")
	{
		from_period				= document.forms[0].from_period.value;	
		to_period				= document.forms[0].to_period.value;	
	}
	if (doc_folder_id == "")
	{
		//alert("APP-000001 Document Folder cannot be blank...");
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace("$",getLabel("eFM.DocumentFolder.label","FM"));
		alert(msg);
		document.forms[0].doc_folder_desc.focus();
		return;
	}
	else if (patient_period_specific=="D")
	{
		if (document.forms[0].from_period.value == "")
		{
			//alert("APP-000001 Period From cannot be blank...");
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("Common.periodfrom.label","common"));
			alert(msg);
			document.forms[0].from_period.focus();
			return;
		}
		else if (document.forms[0].to_period.value == "")
		{
			//alert("APP-000001 Period To cannot be blank...");
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("Common.periodto.label","common"));
			alert(msg);
			document.forms[0].to_period.focus();
			return;
		}
	}
	parent.result_frame.document.location.href="../../eFM/jsp/DTLinkEncounterVolumeDocTypeResult.jsp?doc_folder_id="+doc_folder_id+"&action_code=L&maintain_doc_or_file=D&patient_id="+patient_id+"&patient_period_specific="+patient_period_specific+"&from_period="+from_period+"&to_period="+to_period;
	document.forms[0].search.disabled = true;
}
</script>
</head>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='FMLinkEncounterQueryForm' id='FMLinkEncounterQueryForm' action='' method=''>
<table cellpadding='0' cellspacing='0' border='0' width='100%' >
<tr>
	<td class="LABEL" width="20%"><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/></td>
	<td class='fields' width="20%"><input type='text' name='doc_folder_desc' id='doc_folder_desc' value='' maxlength="30" size="20" onBlur='' onChange='docFolderSearch("<%=facilityID%>");'><input type="Hidden" name="doc_folder_id" id="doc_folder_id" value=""><input type='button' class='button' name='doc_fold_search' id='doc_fold_search' value='?' align=center onClick='docFolderSearch("<%=facilityID%>");'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	<td class="LABEL"  width="15%" id="patient" >&nbsp;</td>
	<td class="LABEL"  width="10%" id="patient_detail" >&nbsp;</td>
	<td class="LABEL"  width="10%" id="period"  >&nbsp;</td>
	<td class="LABEL"  width="20%" id="period_detail" >&nbsp;</td>
	<td  class='button' width="5%"><input type='button' class='button' name='search' id='search' value='Search' onClick='getResults();' style='width:60'>&nbsp;<input type='button' class='button' name='clear_page' id='clear_page' value='Clear' onClick='clearAllPage()' style='width:60'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='hidden' name='user_id' id='user_id' value=''></td>
</tr>
</table>
<%
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}
%>
<input type="Hidden" name="patient_period_specific" id="patient_period_specific" value="">
<input type="Hidden" name="patient_id" id="patient_id" value="">
<input type="Hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="D">
</form>
</body>
</html>

