<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.Properties, java.util.ArrayList,java.util.Hashtable,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
		<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
			 request.setCharacterEncoding("UTF-8");
			 String locale				=		(String)session.getAttribute("LOCALE");
			
			 String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/ItemSearch.js"></script>
		<script language="Javascript" src="../../eST/js/Item.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
//	java.util.HashMap defaultParameter			=		 null;
	String bean_id								=		"ItemSearchBean";
	String bean_name							=		"eST.ItemSearchBean";

	ItemSearchBean bean							=		(ItemSearchBean) getBeanObject( bean_id,bean_name,request);  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
	//String facility_id						=		(String) session.getValue("facility_id");

%>
<body onload='FocusFirstElement();'>
<form name="qryResultMoreDetails_Form" id="qryResultMoreDetails_Form" action="../../eST/jsp/ItemSearchQueryResult.jsp" method="post" target="qryResult" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
				<form name="searchform" id="searchform" onSubmit= 'return submitPage();' >
       				<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
			 <tr>
				 <td class='label' ><fmt:message key="eST.ManufacturingItem.label" bundle="${st_labels}"/>&nbsp;</td>
					<td class='fields'><select name='mfg_item' id='mfg_item'><%=bean.getMFGList()%>				
						  </select>
					</td>
					<td class='label' ><fmt:message key="Common.Expiry.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'><select name='expiry' id='expiry'><%=bean.getExpiryList()%></select>
					</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'><select name='item_class' id='item_class'><%=bean.getItemClass()%></select>
					</td>
					<td class='label' ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'><select name='item_analysis_1' id='item_analysis_1'><%=bean.getItemAnalysis()%>
				  </select>
					</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'><select name='item_analysis_2' id='item_analysis_2'><%=bean.getItemAnalysis()%>
				    </select>
					</td>
					<td class='label' ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'><select name='item_analysis_3' id='item_analysis_3'><%=bean.getItemAnalysis()%>
				    </select>
					</td>
				</tr>
	<tr>
			</tr>
	</table>
</center>
</table>
				<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="1">
</form>
<%putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

