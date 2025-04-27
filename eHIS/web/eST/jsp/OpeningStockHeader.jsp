<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
 <%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name='OpeningStockHeader' id='OpeningStockHeader'>
<%
				String trn_type				=		"OBS";
				String sql_id				=		"SQL_ST_OBS_STORE_SELECT";
				OpeningStockBean bean		=		(OpeningStockBean)getBeanObject( "openingStockBean",  "eST.OpeningStockBean" ,request);
				String mode					=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
				String item_class_based		=		bean.getOBSItemClassBased(trn_type);
				
%>
		<jsp:include page="../../eST/jsp/StHeader.jsp" > 
				<jsp:param name="mode"			value="<%=mode%>" />
				<jsp:param name="trn_type"		value="<%=trn_type%>" />
				<jsp:param name="storeSQLID"	value="<%=sql_id%>" />
		</jsp:include>

			<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
</form>
</body>
</html>

