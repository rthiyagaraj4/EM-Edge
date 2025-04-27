<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page import ="eST.POGenerateRequestBean, eST.Common.*,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/POGenerateRequest.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
        function_id						=		"<%= request.getParameter("function_id") %>"
		menu_id							=		"<%= request.getParameter("menu_id") %>"
		module_id						=		"<%= request.getParameter("module_id") %>"
	</script>
</head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale						=		 (String)session.getAttribute("LOCALE");
	String mode							=		request.getParameter("mode");
	mode								=		mode.trim();
	String default_value				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	


	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT")))
		return;
		

	HashMap defaultParameter			 =		 null;
	String bean_id						 =		"pogenerateRequestBean";
	String bean_name					 =		"eST.POGenerateRequestBean";
	String disabled						 =		"";
	POGenerateRequestBean bean			 =		(POGenerateRequestBean) getBeanObject( bean_id, bean_name,request);  
	defaultParameter					 =		bean.getDefaultStParameter();
	String default_store_code			 =		(String)defaultParameter.get("DEF_STORE_CODE_FOR_REC");
	bean.initialize();
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
	bean.setDefaultStoreCode(default_store_code);
%>
<body onload='defaultFirstElement();'>
	<form name="formPOGenerateRequest" id="formPOGenerateRequest" onReset="FocusFirstElement();" >
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="validateDocNo(this);" onFocus = "checkCanAuthorize(requisition_by_store);"><%=bean.getDocTypes()%></select>&nbsp;
		<img  src="../../eCommon/images/mandatory.gif" ></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" name="doc_no" id="doc_no" value="<%=bean.getDoc_no()%>" onBlur="return checkIntegerFormat(this);"  onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" disabled>&nbsp;<span id='doc_no_gif' style="visibility:hidden"><%=bean.getImage("M")%></td>
		<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;	<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" onBlur="checksysdate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img> <%=bean.getImage("M")%></td>
	  </tr>
	  <tr>
		<td class=label >
			<fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/>
		</td>
		<td  class='fields'>
			&nbsp;&nbsp;
			<select name="requisition_by_store" id="requisition_by_store" onBlur="checkCanAuthorize(this);"><!--  onfocus="checksysdate(doc_date,'<%=locale%>');"removed for Leap year issue, by Badmavathi for SRR20056-SCF-9540--> 						<%=bean.getStores()%>
			</select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" >
		</td>
		<td class=label >
			<fmt:message key="eST.ToDepartment.label" bundle="${st_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="to_department" id="to_department" >
				<%=default_value%>
			</select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" >
		</td>
		<td  class="label"><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<input type="text" name="doc_ref" id="doc_ref" size="16" maxlength="20"></td>
	  </tr>
	  <tr>
		<td class=label ><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/></td>
		<td class='fields' >&nbsp;&nbsp;
		<input type="text" maxLength=10 size=10 name="effective_date" id="effective_date" value= "<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" onBlur="checkSysdate(this,sysdate,'<%=locale%>');">&nbsp;&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('effective_date');"></img><!-- locale added for Leap year issue by Badmavathi for SRR20056-SCF-9540 -->
		</td>

		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td  >&nbsp;&nbsp;<select name="item_class_code" id="item_class_code" <%=disabled%> ><%=default_value%></select></td>
		<td  class="label"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<select name="consignment" id="consignment" >
		<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></option>
				<option value="N"><fmt:message key="eST.NonConsignment.label" bundle="${st_labels}"/></option>
		</select>
		
	  </tr>
	<tr>
		<td class='label'  ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;1&nbsp;</td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;<select name='item_analysis_1' id='item_analysis_1'  accesskey='1' > <%=bean.getItemAnalysis()%></select></td>
		<td class='label'  ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;2</td>
		<td>&nbsp;&nbsp;<select name='item_analysis_2' id='item_analysis_2'  accesskey='2' > <%=bean.getItemAnalysis()%></select></td>
		<td class='label'  ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;3</td>
		<td class='fields'>&nbsp;&nbsp;<select name='item_analysis_3' id='item_analysis_3'  accesskey='3' > <%=bean.getItemAnalysis()%></select></td>

	</tr>
	  </table>
	  <table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td width='15%' >&nbsp;</td>
		<td width='25%' class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td width='5%'>&nbsp;</td>
		<td width='15%' class="label" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width='1%'>&nbsp;</td>
		<td width='5%'>&nbsp;</td>
		<td width='12%' class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Selection.label" bundle="${common_labels}"/></td>
		<td  class='fields' >&nbsp;&nbsp;&nbsp;	<select name="viewitems" id="viewitems" >
		<option value="R"><fmt:message key="eST.ReorderableItems.label" bundle="${st_labels}"/></option>
		<option value="A"><fmt:message key="eST.AllItems.label" bundle="${st_labels}"/></option>
		<option value="S"><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></option>
		<option value="N"><fmt:message key="eST.NonStockItem.label" bundle="${st_labels}"/></option>
		</select></td>
	  </tr>

	  <tr>
		<td class=label ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
		<td  class=fields>&nbsp;<input type="text" maxLength=20 size=20 name="item_from_code" id="item_from_code" value= "" >
		<input type=hidden name="item_from_desc" id="item_from_desc" value=""><input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_from_code,item_from_desc);' name="item_search_1" id="item_search_1"></td>
		<td class=label ></td>
		<td  class=fields>&nbsp;&nbsp;<input type="text" maxLength=20 size=20 name="item_to_code" id="item_to_code" value= "" ><input type=hidden name="item_to_desc" id="item_to_desc" value="">&nbsp;<input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_to_code,item_to_desc);' name="item_search_2" id="item_search_2"></td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td colspan="2" >&nbsp;</td>
	  </tr>
	  <tr>
		<td class=label ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
		<td  class=fields>&nbsp;&nbsp;<input type="text" maxLength=10 size=15 name="alpha_from_code" id="alpha_from_code" value= "" ></td>
		<td class=label ></td>
		<td   class=label>&nbsp;<input type="text" maxLength=10 size=15 name="alpha_to_code" id="alpha_to_code" value= "" >&nbsp;</td>
		<td >&nbsp;&nbsp;&nbsp;</td><td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="getItemRecord();"></td>
		<td >&nbsp;</td><!--checksysdate(doc_date,'<%=locale%>'); removed by B.Badmavathi for SRR20056-SCF-9540 on 22/7/2015-->
	  </tr>
	</table>
		<input type='hidden'	name="authorize_yn" id="authorize_yn"			value="No">
		<input type='hidden'	name="finalize_yn" id="finalize_yn"			value="No">
		<input type='hidden'	name="autono_yn" id="autono_yn"			value="No">
		<input type='hidden'	name="trn_type" id="trn_type"				value="PRQ">
		<input type='hidden'	name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"			value="<%= bean_name %>">
		<input type="hidden"	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
		<input type="hidden"	name="sysdate" id="sysdate"				value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>">
		<input type="hidden"	name="locale" id="locale"				value="<%=locale%>">
		
	</form>
	<%putObjectInBean(bean_id,bean,request);%>
	</body>
</html>

