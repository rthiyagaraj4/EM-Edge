<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*,eST.Common.*,java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<html>
	<head>
<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/StHeader.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
<body>

<%
		String bean_id					=		"ChangeBinLocationBean" ;
		String bean_name				=		"eST.ChangeBinLocationBean";
		eST.ChangeBinLocationBean bean  =		(eST.ChangeBinLocationBean) getBeanObject(bean_id,bean_name,request);
		String mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		String trn_type					=		"CBL"; 
		String sql_id					=		"SQL_ST_CHANGE_BIN_STORE_SELECT" ;
		String item_class_based			=		bean.getADJItemClassBased(trn_type);
		String param = request.getQueryString(); //11/05/12

		
%>
<form name="formChangeBinLocationHeader" id="formChangeBinLocationHeader">

	<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param		name="mode"			value="<%=mode%>" />
	<jsp:param		name="trn_type"		value="<%=trn_type%>" />
    <jsp:param		name="default_doc"	value="BIN" />
	<jsp:param		name="storeSQLID"   value="<%=sql_id%>" />
</jsp:include>
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	    <input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
    	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
    	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
    	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
    	<input type="hidden"    name="chargeable_yn" id="chargeable_yn"				value="" ><!--dummy-->
		<input type="hidden"    name="trn_type" id="trn_type"				      value="<%=trn_type%>">
<script language="JavaScript">
   parent.frameChangeBinLocationList.location.href="../../eST/jsp/ChangeBinLocationList.jsp?function_id=ST_CHANGE_BIN_LOCATION";
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</form>
<script>
 if(document.formChangeBinLocationHeader.trn_type.value == "CBL" )  
callBarCodeApplicable('PRT','formChangeBinLocationHeader','ChangeBinLocationBean','eST.ChangeBinLocationBean');
parent.frameChangeBinLocationList.document.location.href="../../eST/jsp/ChangeBinLocationList.jsp?<%=param%>";	  
</script>
</body>
</html>

