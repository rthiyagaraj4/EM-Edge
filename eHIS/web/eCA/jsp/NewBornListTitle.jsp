<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@page import="java.sql.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/NewBornList.js'></script>
<script language='javascript' src='../../eCA/js/CAMenu.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='NewBornTitleForm' id='NewBornTitleForm' OnMouseDown='CodeArrest()' OnKeyDown='disableKeys()'>
<table id='PatCriteriaTbl' border='0' width='100%' cellpadding='0' cellspacing=0 >
<tr>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap >&nbsp;</td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap colspan=2>&nbsp;</td>
<!-- //22856-start-->
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap  ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></td>
 <!-- //22856-End-->
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a id='a1'   href="javascript:callOrderBy('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.NewBornID.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a id='a2'   href="javascript:callOrderBy('PN');" onclick='changeColor(this);' style='color:pink'><fmt:message key="eCA.NewBornName.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a id='a3'   href="javascript:callOrderBy('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a id='a4'   href="javascript:callOrderBy('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   rowspan=2  width='' nowrap ><a id='a5'   href="javascript:callOrderBy('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   width='' nowrap colspan=3  style='color:white'><fmt:message key="eCA.NewBornLocation.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'   rowspan=2 width='' nowrap ><a id='a6'   href="javascript:callOrderBy('MN');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.MothersName.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   rowspan=2 width='' nowrap style='color:white'><fmt:message key="eCA.MothersBed.label" bundle="${ca_labels}"/></td>
</tr>

<tr>
<td class='COLUMNHEADERCENTER'  width='' nowrap  ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap  ><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap ><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></td>
</tr>

<tr style="visibility:hidden">
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap >&nbsp;</td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap colspan=2>&nbsp;</td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a    href="javascript:callOrderBy('PID');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.NewBornID.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a    href="javascript:callOrderBy('PN');" onclick='changeColor(this);' style='color:pink'><fmt:message key="eCA.NewBornName.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a    href="javascript:callOrderBy('DOB');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  rowspan=2 width='' nowrap ><a    href="javascript:callOrderBy('AGE');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   rowspan=2  width='' nowrap ><a    href="javascript:callOrderBy('SEX');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap  ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap  ><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  width='' nowrap ><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'   rowspan=2 width='' nowrap ><a    href="javascript:callOrderBy('MN');" onclick='changeColor(this);' style='color:white'><fmt:message key="eCA.MothersName.label" bundle="${ca_labels}"/></a></td>
<td class='COLUMNHEADERCENTER'   rowspan=2 width='' nowrap style='color:white'><fmt:message key="eCA.MothersBed.label" bundle="${ca_labels}"/></td>
</tr>
</table>
</form>
</body>
</html>

