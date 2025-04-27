<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<html>
	<head>
		
<%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale	=	(String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<%
		SplitBatchBean bean				=		(SplitBatchBean) getBeanObject( "SplitBatchBean","eST.SplitBatchBean",request );
		bean.setLanguageId(locale);
		String mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		String trn_type					=		"SPB";
		String sql_id					=		"SQL_ST_SPLIT_BATCH_SELECT";
		String item_class_based			=		bean.getADJItemClassBased(trn_type);
		String param = request.getQueryString(); //11/05/12
%>
<form name="SplitBatchHeader" id="SplitBatchHeader">
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"			value="<%=mode%>" />
	<jsp:param name="trn_type"		value="<%=trn_type%>" />
	<jsp:param name="default_doc"	value="SPL" />
	<jsp:param name="storeSQLID"	value="<%=sql_id%>" />
</jsp:include>
		<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
		<input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
    	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
    	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
    	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
    	<input type="hidden"    name="chargeable_yn" id="chargeable_yn"				value="" ><!--dummy-->
		<input type="hidden"    name="trn_type" id="trn_type"				        value="<%=trn_type%>">
</form>
<script>
 if(document.SplitBatchHeader.trn_type.value == "SPB" )  
callBarCodeApplicable('SPB','SplitBatchHeader','SplitBatchBean','eST.SplitBatchBean');
parent.frameOpeningStockDetail.document.location.href="../../eST/jsp/SplitBatchListResult.jsp?<%=param%>";
parent.frameOpeningStockList.document.location.href="../../eST/jsp/SplitBatchListFrame.jsp?<%=param%>";	
</script>
</body>
</html>

