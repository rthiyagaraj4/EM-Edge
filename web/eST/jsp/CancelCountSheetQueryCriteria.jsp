<!DOCTYPE html>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->	<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src="../../eST/js/CancelCountSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String bean_id = "CancelCountSheetBean";
	String bean_name = "eST.CancelCountSheetBean";
	CancelCountSheetBean bean = (CancelCountSheetBean) getBeanObject( bean_id,bean_name,request);  
	bean.clear( );	
	bean.setLanguageId(locale);
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
%>
<body  >
<form name="formCancelCountSheetQueryCriteria" id="formCancelCountSheetQueryCriteria"  >
<div >
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
<tr>
	<td colspan='9' class="label" >&nbsp;&nbsp;</td>
</tr>
<tr >
	 <td   class="label" ><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields'> 
	<select name='phy_inv_id' id='phy_inv_id' onchange="getStoreName(phy_inv_id);"><option value="" >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
	<%
					ArrayList	arraylist		=	null;
					HashMap		hmItemCode		=	null;	
					String code = "";

					arraylist		=	bean.getArrayCodeList(facility_id);
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("PHY_INV_ID");
										
					%> 	<option value="<%=code%>"  ><%=code%></option> 	
				<% 	} %>
				
	%></select>	<%=bean.getImage("M")%></td>

	<td   class="label" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;<select name='store_code' id='store_code' disabled><option value="" >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option></select></td>
		<td  class="label" ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	
	<td class=label>&nbsp;&nbsp;<input maxLength=20 size=20 name="item_code" id="item_code" value="" disabled><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(item_code);" type="button" value="?" disabled></td>
	<td   class="label" >&nbsp;</td>
	<td  >
	<td  >
	</tr>

<tr>
	<td colspan='8' align=right>
	<input class='button' type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="searchResults(document.formCancelCountSheetQueryCriteria);" class="label">&nbsp;</td>
</tr>
</table>
</div>

<input type="hidden" name="facility_id" id="facility_id"		value="<%=facility_id%>">
<input type="hidden" name="language_id" id="language_id"		value="<%=locale%>">
<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_STORE")%>">

<input type="hidden" name="SQL_ST_ITEM_LOOKUP_LANG" id="SQL_ST_ITEM_LOOKUP_LANG" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP_LANG")%>">


</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

