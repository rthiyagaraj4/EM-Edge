<!DOCTYPE html>
<%@ page import=" eST.StockTransferBean,eCommon.Common.*,java.util.ArrayList,java.util.HashMap,java.lang.*,java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body>
<form name="formStockTransferHeader" id="formStockTransferHeader">
<%
	String mode							=		request.getParameter("mode");
	//String	item_class_desc				=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
	String	item_class_code				=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );
	String trn_type						=		"TFR";
	String bean_id						=		"stockTransferBean";
	String bean_name					=		"eST.StockTranferBean";
	String sql_from_store				=		"SQL_ST_STOCK_TFR_FROM_STORE";
	String sql_to_store					=		"SQL_ST_STOCK_TO_STORE";
//	String item_class_code				=		"SQL_ST_ITEM_CLASS_SELECT_LIST";
	String Modal_Window_Open			=		"Yes";

	String param = request.getQueryString();
	
	eST.StockTransferBean bean			=		(eST.StockTransferBean) getBeanObject( bean_id ,  bean_name , request);
	bean.setLanguageId(locale); 
	boolean site_alna = bean.getStockTransferSite();  //Added for NMC-JD-CRF-0174 
	
	/*eST.Common.StTransaction st_bean = (eST.Common.StTransaction)getBeanObject( "stTransaction","eST.Common.StTransaction", request  );
	st_bean.setLanguageId(locale);
	st_bean.clear();
	st_bean.initialize();*/


	//System.out.println("BARCODE_YN==t=>=="+ st_bean.getDtlRecordsforBarCode());
	//System.out.println("BARCODE_YN==t=>=="+ st_bean.getExpRecordsforBarCode());



	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		Modal_Window_Open				=		"No";
		 bean.setItem_class_code(item_class_code);
		 
	}
	
	String tfr_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  tfr_delete_yn  from  ST_USER_ACCESS_FOR_STORE where user_id=? and store_code=? ",new String[]{(String)session.getValue( "login_user"),bean.checkForNull(bean.getFrom_store_code())}).get("TFR_DELETE_YN"),"N");

%>
<jsp:include page="../../eST/jsp/StDuoHeader.jsp" > 

		<jsp:param	name="mode"					value="<%=mode%>" />
		<jsp:param	name="doc_type_code"		value="<%=bean.checkForNull(bean.getDoc_type_code())%>" />
		<jsp:param	name="doc_no"				value="<%=bean.checkForNull(bean.getDoc_no())%>" />
		<jsp:param	name="doc_date"				value="<%=bean.checkForNull(bean.getDoc_date())%>" />
		<jsp:param	name="doc_ref"				value="<%=bean.checkForNull(bean.getDoc_ref())%>" />
		<jsp:param	name="from_store_code"		value="<%=bean.checkForNull(bean.getFrom_store_code())%>" />
		<jsp:param	name="to_store_code"		value="<%=bean.checkForNull(bean.getTo_store_code())%>" />
		<jsp:param	name="item_class_code"		value="<%=bean.checkForNull(bean.getItem_class_code())%>" />
		<jsp:param name="trn_type"				value="<%=trn_type%>" />
		<jsp:param name="sql_from_store"		value="<%=sql_from_store%>" />
		<jsp:param name="sql_to_store"			value="<%=sql_to_store%>" />
		<jsp:param name="Modal_Window_Open"		value="<%=Modal_Window_Open%>" />
        <jsp:param name="site_alna"				value="<%=site_alna%>" />   
</jsp:include>
	<%--param name="item_class_code" value="item_class_code" --%>
	<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden"	name="bean_name" id="bean_name"			value="<%=bean_name%>">
	<input type="hidden"	name="mode" id="mode"					value="<%=mode%>" >
	<input type="hidden"	name="records_to_delete" id="records_to_delete"	value="" >
	<input type="hidden"	name="finalize_allowed_yn" id="finalize_allowed_yn"	value="N">
	<input type="hidden"	name="item_class_code1" id="item_class_code1"		value="<%=item_class_code%>">
	<input type="hidden"	name="trn_type" id="trn_type"				value="<%=trn_type%>">
	<input type="hidden"	name="tfr_delete_yn" id="tfr_delete_yn"				value="<%=tfr_delete_yn%>">


	<input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
	<input type="hidden"    name="chargeable_yn" id="chargeable_yn"				value="" ><!--dummy-->
</form>


<script>
callBarCodeApplicable('TFR','formStockTransferHeader','stockTransferBean','eST.StockTranferBean');
parent.frameStockTransferDetail.document.location.href="../../eST/jsp/StockTransferDetail.jsp?<%=param%>";
parent.frameStockTransferList.document.location.href="../../eST/jsp/StockTransferListFrame.jsp?<%=param%>";	
</script>
</body>
<%  putObjectInBean(bean_id,bean,request);
%>

</html>

