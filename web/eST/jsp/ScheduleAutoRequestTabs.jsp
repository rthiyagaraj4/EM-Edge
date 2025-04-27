<%@ page import ="eST.ScheduleAutoRequestBean" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<html>
<head>


<%
    request.setCharacterEncoding("UTF-8");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eST/js/ScheduleAutoRequest.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
String mode=request.getParameter("mode")==null?"":request.getParameter("mode");



%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name='schduleAutoRequestTabsForm' id='schduleAutoRequestTabsForm' >

<table border="0" width="40%" cellspacing="0" cellpadding="0">
	<tr>
		<td class='clicked'  width="44%" height="20" id="select_col">
		<a href="javascript:parent.callSelect()" id="select" style="color:white;"><b>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b> </a>
		</td>
		<td class="normal" width="44%" height="20" id="association_col">
		<a href="javascript:parent.callAssociation()" id="association" style='color:white;'><b>
		<fmt:message key="Common.Association.label" bundle="${common_labels}"/></b></a>
		</td>
	</tr>
</table>
<table border="0" width="40%" cellspacing="0" cellpadding="0"  id="table_hide">
	<tr>
	<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td >&nbsp;&nbsp;<input maxLength=20 size=20 name="item_code" id="item_code" value="" class="UPPER"></td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td class='label' nowrap>    
	 <fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </td><td width='*' >&nbsp;&nbsp;<input type='text' name='item_desc' id='item_desc' value=""  size='40' maxlength='100' >
	 <td>&nbsp;&nbsp;&nbsp;<SELECT name="searchby_type" id="searchby_type"  >
	 <OPTION value="S" >   <fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></OPTION>
	 <OPTION value="C" ><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
	 <OPTION value="E" ><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
	</SELECT>   
	</td>
	</tr>
	<tr>
	<td class=label ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
	<td >&nbsp;&nbsp;<input type=text name=alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
	<td width='*' align = "right" ><input type="button" name="Search" id="Search" class= 'button' value= '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails();' ></input></td>
	</tr>
</table>
<input type='hidden'	name="mode" id="mode"					value="<%=mode%>">

</form>
</body>
</html>

