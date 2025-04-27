<!DOCTYPE html>
<%--
	FileName	: AM_Service_Setup.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<%request.setCharacterEncoding("UTF-8");%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eAM/js/Service.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;"  onKeyDown = 'lockKey()'>
		<form name="MPMasterMenu_form" id="MPMasterMenu_form">
			<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Service')" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SubService')"><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR'  onClick="javascript:callJSPs('Department')"><fmt:message key="eAM.AccountingDepartmentCostCenter.label" bundle="${am_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR'  onClick="javascript:callJSPs('Section')"> <fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="BLANK_ROW">&nbsp;</td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DepartmentinFacility');"><fmt:message key="eAM.FacilityforAcctDept.label" bundle="${am_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SectioninFacility');"><fmt:message key="eAM.SectioninFacility.label" bundle="${am_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ServiceinFacility');"><fmt:message key="eAM.ServiceinFacility.label" bundle="${am_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Sub-ServiceinFacility');"><fmt:message key="eAM.SubServiceinFacility.label" bundle="${am_labels}"/></td>
				</tr>


				 <tr >
					<td class='ECMENUHIGHERLEVELCOLOR'><a href="javascript:goHomePage();" style='color:#FFFFFF'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
				</tr> 
			</table>
		</form>
	</body>
 </html>

