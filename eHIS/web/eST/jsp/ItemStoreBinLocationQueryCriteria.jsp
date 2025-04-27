<!DOCTYPE html>
<%@ page import ="java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ page import ="webbeans.eCommon.*, java.sql.*, java.util.Properties, eST.Common.StRepository, eCommon.Common.OptionValues,eST.Common.*, eST.* " %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	try {
			request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
				
		
		ItemStoreBinLocationBean bean = (ItemStoreBinLocationBean)getBeanObject( "itemStoreBinLocationBean","eST.ItemStoreBinLocationBean",request ); 
		bean.setLanguageId(locale);
%>
<html><head><title><fmt:message key="eMM.ItemforStore.label" bundle="${mm_labels}"/></title>
<!-- 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->	<%
			
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
 	<script src='../../eCommon/js/messages.js' language='JavaScript'></script>
	<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
    <Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
	 <script language="javascript" src="../../eST/js/StMessages.js"></script>
		<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
	<script language="javascript" src="../../eST/js/ItemStoreBinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='focusObject()'>
<form name='query_form' id='query_form' method='post' action='ItemStoreBinLocationQueryResult.jsp' onsubmit='SelectAll()'>
<%
//String listitem = bean.getStore_code_List();
		ArrayList alParameters=new ArrayList();
		alParameters.add(bean.getLoginFacilityId());
		//alParameters.add(trn_type);
		alParameters.add(bean.getLanguageId());
ArrayList listitemArray = bean.getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST_WT_LANG"), alParameters);
listitemArray.remove(0);
%>
<table width='98%' align='center' cellspacing='0' cellpadding='0'>
<tr>
<th align='left' width='20%'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
<tr>
<td width='60%' >
<p title='Query Criteria'>
<table width='100%'>
<tr><td  width='40%' class='label'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>

<td width='60%'  >&nbsp;&nbsp;
<select name='store_code' id='store_code'><%=bean.getListOptionTag(listitemArray)%></select>&nbsp;</td></tr>

<tr><td  width='40%' class='label' ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
<td   width='60%' class=fields>&nbsp;&nbsp;<input type=text name = 'item_code' size='20' maxlength='20' onBlur='makeValidQueryCriteria(this);'></td></tr>

<tr><td  width='40%' class='label' ><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td><td  class=fields width='60%'>&nbsp;&nbsp;<input type=text name = 'item_desc' size='60' maxlength='60' onBlur='makeValidQueryCriteria(this);'></td></tr>

<tr><td  width='40%' class='label' ><fmt:message key="eMM.BinLocationCode.label" bundle="${mm_labels}"/></td><td  class=fields width='60%'>&nbsp;&nbsp;<input type=text name = 'bin_location_code' size='10' maxlength='10' onBlur='makeValidQueryCriteria(this);'></td></tr>

<tr><td  width='40%' class='label' ><fmt:message key="eMM.BinDesciption.label" bundle="${mm_labels}"/></td><td   class=fields width='60%'>&nbsp;&nbsp;<input type=text name = 'bin_location_desc' size='40' maxlength='40' onBlur='makeValidQueryCriteria(this);'></td></tr>

<input type='hidden' name='function_id' id='function_id' value='ST_ITEM_STORE_BIN' ></table></td></tr></table></p>
<table width='98%' ><th width='20%' ><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
<tr><td width='60%' > <p  title='Sort Order'><table width='100%'><td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><td>&nbsp;</td><td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
	
<tr>
<td width='45%' align=center ><select name='orderbycols' id='orderbycols' size='5' >
	<option value='item_desc'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
	<option value='store_code'><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></option>
	<option value='store_desc'><fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></option>
	<option value='bin_location_code'><fmt:message key="eMM.BinLocationCode.label" bundle="${mm_labels}"/></option>
	<option value='bin_location_desc'><fmt:message key="eMM.BinDesciption.label" bundle="${mm_labels}"/></option></select></td>

<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'>
<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>
<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>
<option value='item_code'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option></select></td></tr>
</table>
	</p>
	</td>
</tr>
	</table>
	<br><table border='0' width='100%' align='center'><tr><td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>'></td>
		</tr>
	</table>
	</form>
	<%
putObjectInBean("itemStoreBinLocationBean",bean,request);
%>
	</body>
	</html>

<%}catch(Exception e){
	e.printStackTrace();
}%>

