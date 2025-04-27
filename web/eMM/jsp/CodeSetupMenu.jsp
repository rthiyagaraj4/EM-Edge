<!DOCTYPE html>
<%@ page import=" eMM.*, eMM.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
		request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	eMM.CodeSetupBean bean	=	(eMM.CodeSetupBean)getBeanObject( "mm_codeSetupBean","eMM.CodeSetupBean",request );  
	String module_id	=	request.getParameter("module_id");
/*	String function_id	=	request.getParameter("function_id");
	String menu_id		=	request.getParameter("menu_id");
	String resp_id		=	(String)session.getAttribute("responsibility_id");
	String function_name=	request.getParameter("function_name");
 */
    String  IV    = "";
    String  PO	= ""; 
   // String  SS	= ""; 

	ArrayList	arrSSIV				=	null;
	HashMap		hmSSIV				=	null;
%>

<html>
<head>
		<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<SCRIPT LANGUAGE="JavaScript" src='../../eMM/js/CodeSetup.js'></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body style="background-color:dimgray;" >
<form name="formCodeSetup" id="formCodeSetup">
<table cellspacing=1 cellpadding=1 width='100%' border=0 id='t' align=center>
<% 
			  arrSSIV     =	bean.isSSIVModuleInstalled();
              hmSSIV		=	(HashMap) arrSSIV.get(0);
			  IV =	(String)hmSSIV.get("IV");
			  PO =	(String)hmSSIV.get("PO");
%>

<% 
if (module_id.equals("MM"))
{
	if (IV.equals("I") || PO.equals("I") ) 
	{%>
		<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('MaterialGroup')" ><fmt:message key="eMM.MaterialGroup.label" bundle="${mm_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('UserAccessForMaterialGroup')" ><fmt:message key="eMM.UserAccessForMaterialGroup.label" bundle="${mm_labels}"/></td>
		</tr>
<%}%>
	<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ItemAnalysis')" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/></td>
		</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ItemClass')" ><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('MMItem')" ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('MMStore')" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('BinLocation')" ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('TradeNameforItem')" ><fmt:message key="eMM.TradeNameforItem.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('Supplier')" ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('TransactionRemarks')" ><fmt:message key="Common.TransactionRemarks.label" bundle="${common_labels}"/></td>
	</tr>
	 <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ItemUOMDefinition')" ><fmt:message key="eMM.ItemUOMDefinition.label" bundle="${mm_labels}"/></td>
	</tr> 

	<% }
	else if (module_id.equals("ST")) 
	{
		if (IV.equals("I") || PO.equals("I") ) 
		{%>
		<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('Machine')" ><fmt:message key="eMM.Machine.label" bundle="${mm_labels}"/></td>
		</tr>
	<%}%>
	<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('STItem')" ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('STStore')" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ItemClassforStore')" ><fmt:message key="eMM.ItemClassforStore.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ParentStoreForStore')" ><fmt:message key="eMM.ParentStoreforStore.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ItemforStore')" ><fmt:message key="eMM.ItemforStore.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('AssemblyDetails_MFG Formulary')" ><fmt:message key="eMM.AssemblyDetails/MFGFormulary.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('PrepareLocation')" ><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ItemStoreBinLocation')" ><fmt:message key="eMM.ItemStoreBinLocation.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('RepackingGroup')" ><fmt:message key="Common.RepackingGroup.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('AssemblyInstruction')" ><fmt:message key="eMM.AssemblyInstructions.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('DirectSalesPatient')" ><fmt:message key="eMM.DirectSalesPatient.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('KitTemplate')" ><fmt:message key="eMM.KitTemplate.label" bundle="${mm_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('STTransactionRemarks')" ><fmt:message key="Common.TransactionRemarks.label" bundle="${common_labels}"/></td>
	</tr>
		<%}%>
	<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' onClick="javascript:parent.window.document.location.href='../../eCommon/jsp/CommonClearObjects.jsp'">
			<b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></td>
	</tr>
</table>
</form>
	<%
putObjectInBean("mm_codeSetupBean",bean,request);
%>
</body>
</html>

