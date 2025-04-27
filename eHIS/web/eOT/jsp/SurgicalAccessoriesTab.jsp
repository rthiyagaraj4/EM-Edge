<!DOCTYPE html>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@page  import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String source=request.getParameter("source");
String function_id = request.getParameter("function_id") ;
String surgeon_code=checkForNull(request.getParameter("surgeon_code"));
%>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script language="javascript" src="../../eOT/js/SurgicalAccessories.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function changeTab(objStr)
{	
	selectTab(objStr);
	var formObj=document.forms[0];
	var param = formObj.param.value;
	var function_id=parent.frames[2].document.forms[0].function_id.value;
	if(objStr=="CONSU"){
	    window.parent.frames[3].location.href='../../eOT/jsp/SurgicalAccessoriesConsumablePacksRecord.jsp?update_mode_yn='+formObj.update_mode_yn.value+'&applicability='+formObj.applicability.value+'&speciality_code='+formObj.speciality_code.value+'&oper_cat_code='+formObj.oper_cat_code.value+'&oper_sub_cat_code='+formObj.oper_sub_cat_code.value+'&oper_code='+formObj.oper_code.value+'&function_id='+function_id+'&surgeon_code='+formObj.surgeon_code.value;
	
	}else if(objStr=="EQUIP"){
	      window.parent.frames[3].location.href='../../eOT/jsp/SurgicalAccessoriesEquipmentsRecord.jsp?update_mode_yn='+formObj.update_mode_yn.value+'&applicability='+formObj.applicability.value+'&speciality_code='+formObj.speciality_code.value+'&oper_cat_code='+formObj.oper_cat_code.value+'&oper_sub_cat_code='+formObj.oper_sub_cat_code.value+'&oper_code='+formObj.oper_code.value+'&function_id='+function_id+'&surgeon_code='+formObj.surgeon_code.value;
	
	}else if(objStr=="INSTR"){

		window.parent.frames[3].location.href='../../eOT/jsp/SurgicalAccessoriesInstrumentsRecord.jsp?update_mode_yn='+formObj.update_mode_yn.value+'&applicability='+formObj.applicability.value+'&speciality_code='+formObj.speciality_code.value+'&oper_cat_code='+formObj.oper_cat_code.value+'&oper_sub_cat_code='+formObj.oper_sub_cat_code.value+'&oper_code='+formObj.oper_code.value+'&function_id='+function_id+'&surgeon_code='+formObj.surgeon_code.value;
	}else if(objStr=="PROST"){
	      window.parent.frames[3].location.href='../../eOT/jsp/SurgicalAccessoriesProsthesisRecord.jsp?update_mode_yn='+formObj.update_mode_yn.value+'&applicability='+formObj.applicability.value+'&speciality_code='+formObj.speciality_code.value+'&oper_cat_code='+formObj.oper_cat_code.value+'&oper_sub_cat_code='+formObj.oper_sub_cat_code.value+'&oper_code='+formObj.oper_code.value+'&function_id='+function_id+'&surgeon_code='+formObj.surgeon_code.value;
	
	}else if(objStr=="PERSO"){
		
	    window.parent.frames[3].location.href='../../eOT/jsp/SurgicalAccessoriesPersonnelRequiredRecord.jsp?update_mode_yn='+formObj.update_mode_yn.value+'&applicability='+formObj.applicability.value+'&speciality_code='+formObj.speciality_code.value+'&oper_cat_code='+formObj.oper_cat_code.value+'&oper_sub_cat_code='+formObj.oper_sub_cat_code.value+'&oper_code='+formObj.oper_code.value+'&function_id='+function_id+'&surgeon_code='+formObj.surgeon_code.value;
	
	}
	 window.parent.frames[4].location.href='../../eCommon/html/blank.html';
}
</script>

</head>
<body class="HEADER" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='SurgicalAccessoriesForm' id='SurgicalAccessoriesForm'>
<input type='hidden' name='update_mode_yn' id='update_mode_yn' value='<%=request.getParameter("update_mode_yn")%>'>
<input type='hidden' name='applicability' id='applicability' value='<%=request.getParameter("applicability")%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=request.getParameter("speciality_code")%>'>
<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=request.getParameter("surgeon_code")%>'>
<input type='hidden' name='oper_cat_code' id='oper_cat_code' value='<%=request.getParameter("oper_cat_code")%>'>
<input type='hidden' name='oper_sub_cat_code' id='oper_sub_cat_code' value='<%=request.getParameter("oper_sub_cat_code")%>'>
<input type='hidden' name='oper_code' id='oper_code' value='<%=request.getParameter("oper_code")%>'>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='source' id='source' value='<%=source%>'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class='tablistitem' title='<fmt:message key="eOT.Consumables.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('CONSU')" class="tabclicked" id="CONSU">
					<span class="tabSpanclicked" id="CONSUspan">
						<fmt:message key="eOT.Consumables.Label" bundle="${ot_labels}"/></span></a>
			</li>

			<li class="tablistitem" title='<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('EQUIP')" class="tabA" id="EQUIP">
					<span class="tabAspan" id="EQUIPspan">
						<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('INSTR')" class="tabA" id="INSTR">
					<span class="tabAspan" id="INSTRspan">
						<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.Prosthesis.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('PROST')" class="tabA" id="PROST">
					<span class="tabAspan" id="PROSTspan">
						<fmt:message key="eOT.Prosthesis.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.PersonnelRequired.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('PERSO')" class="tabA" id="PERSO">
					<span class="tabAspan" id="PERSOspan">
						<fmt:message key="eOT.PersonnelRequired.Label" bundle="${ot_labels}"/></span></a>
			</li>
		</ul>
	</td>	
	</tr>
</table>

<!-- The below line is required to change the select state of Initial tab selected -->
<script>prevTabObj='CONSU'</script>
<script>changeTab('CONSU')</script> 	

</form>
</body>
</html>


