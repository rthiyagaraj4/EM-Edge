<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=  (String)session.getAttribute("LOCALE");
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>  -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
		<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/ItemStoreBinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode;
	String bean_id;
	String bean_name;

	mode								=		request.getParameter( "mode" ) ;
	bean_id								=		"ItemStoreBinLocationBean" ;
	bean_name							=		"eST.ItemStoreBinLocationBean";
	
	if ((mode == null) || (mode.equals(""))) 
		return ;

	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	eST.ItemStoreBinLocationBean bean	=			(eST.ItemStoreBinLocationBean)getBeanObject(bean_id,bean_name,request) ;  
	bean.setLanguageId(locale);
	ServletContext context				=			getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);

	bean.setMode(mode);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	int i=0;
	eST.Common.StTransaction st_bean = (eST.Common.StTransaction)getBeanObject( "StTransaction",  "eST.Common.StTransaction",request  );
	String item_2d_barcode_yn =st_bean.barcode2DApplicable();//Added for MOHE-CRF-0167
%>
<body onLoad="FocusFirstElement();">
	<form name="formItemStoreBinLocationHeader" id="formItemStoreBinLocationHeader" onReset="FocusFirstElement();">
	<table border=0  width='100%' height='30%' cellpadding=0 cellspacing=0 align=center>
		<tr>
			<td class="LABEL" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
			<td  class='fields' colspan='4'>&nbsp;<select name="store_code" id="store_code">
			<%=bean.getStore_code_List()%>
			</select><%=bean.getImage("M")%></td>
		</tr>
		  <% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align=left class='label' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
		<tr>
			<td class="LABEL" ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan='4'  class='fields'>&nbsp;<input type='text' name="item_desc" id="item_desc" maxLength="60" size="70"><input name="item_search" id="item_search" class="button" onClick="return callItemSearchScreen();" type="button" value="?"  ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code"></td>
		</tr>
		<tr>
			<td class="LABEL" ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
			<td nowrap  class='fields'>&nbsp;<input type='text' name="bin_location_search_string" id="bin_location_search_string" maxLength="20" size="20">
			<td class='label' ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
			<td  class='fields'>&nbsp;<select name="bin_location_criteria" id="bin_location_criteria">
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td  class='fields'><input type="button" name="search" id="search" class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='displayDetail();'></td>
		</tr>
	</table>
	<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="total_count_flag" id="total_count_flag"	value="<%=i%>">
	<input type="hidden" name="item_2d_barcode_yn" id="item_2d_barcode_yn"	value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 -->
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

