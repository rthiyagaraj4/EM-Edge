
 <%@page  import=" eST.*,eST.Common.*,java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");

	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<form name='formAdjustStockHeader' id='formAdjustStockHeader'>
<%
	AdjustStockBean bean			=		(AdjustStockBean) getBeanObject( "adjustStockBean","eST.AdjustStockBean",request );
	bean.setLanguageId(locale);

	String mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	String trn_type					=		"ADJ";
	String sql_id					=		"SQL_ST_ADJ_STORE_SELECT";
	String item_class_based			=		bean.getAdjustStockItemClassBased(trn_type);

	String doc_type_code			=		bean.checkForNull(request.getParameter( "doc_type_code" ));
	String doc_no					=		bean.checkForNull(request.getParameter( "doc_no" ));
	String doc_date					=		bean.checkForNull(request.getParameter( "doc_date" ));
	String doc_ref					=		bean.checkForNull(request.getParameter( "doc_ref" ));
	String store_code				=		bean.checkForNull(request.getParameter( "store_code" ));
	String item_class_code			=		bean.checkForNull(request.getParameter( "item_class_code" ));

	if(request.getParameter( "doc_type_code" ) != null) {
		mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");	
	} 

	String adj_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  adj_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(store_code),(String) session.getValue( "login_user" )}).get("ADJ_DELETE_YN"),"N");
	 
	// Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013
	if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
	 String disposable_yn = bean.checkForNull((String)bean.getDisposable_yn());
	if(disposable_yn.equals("Y")){
	String next_batch_id = bean.checkForNull((String)bean.fetchRecord("SELECT NEXT_BATCH_ID FROM	ST_STORE_DISPOSE_BATCH WHERE STORE_CODE =? and eff_status = 'E' and  AUTO_GEN_BATCH_YN = 'Y' ",store_code).get("NEXT_BATCH_ID"));
	      int dflt_btch_id    =  Integer.parseInt(next_batch_id);
				   dflt_btch_id           =   dflt_btch_id-1;
				   next_batch_id           =   ""+dflt_btch_id;
			       bean.setDflt_batch_id(next_batch_id);  
	 }
	}

%>
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=doc_type_code%>" />
	<jsp:param name="doc_no"			value="<%=doc_no%>" />
	<jsp:param name="doc_date"			value="<%=doc_date%>" />
	<jsp:param name="doc_ref"			value="<%=doc_ref%>" />
	<jsp:param name="store_code"		value="<%=store_code%>" />
	<jsp:param name="item_class_code"	value="<%=item_class_code%>" />
	<jsp:param name="bean_id"			value="adjustStockBean" />
	<jsp:param name="bean_name"			value="eST.AdjustStockBean" />
</jsp:include>

	<input type="hidden" name="item_class_check" id="item_class_check" value="<%=item_class_based%>">
	<input type="hidden" name="trn_type" id="trn_type"		 value="<%=trn_type%>">
<!-- 	<input type="hidden" name="doc_type_code" id="doc_type_code"	 value="<%=doc_type_code%>" > 
 -->	<input type="hidden" name="doc_no" id="doc_no"			 value="<%=doc_no%>" >        
 	<input type="hidden" name="adj_delete_yn" id="adj_delete_yn"			 value="<%=adj_delete_yn%>" >
      <!-- Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 -->
	<input type="hidden" name="default_Expdate_condmn" id="default_Expdate_condmn"	value="<%=bean.checkForNull((String)bean.getDisp_Expdate())%>">	
</form>
<%
//putObjectInBean("adjustStockBean",bean,request);
%>
</body>
</html>

