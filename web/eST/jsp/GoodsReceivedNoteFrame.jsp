<!DOCTYPE html>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page contentType="text/html;charset=UTF-8" import=" eST.Common.StHeaderBean,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale					=	 (String)session.getAttribute("LOCALE");
 %>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/GoodsReceivedNote.js"></script>

</head>
<%
	eST.GoodsReceivedNoteBean bean	=		(eST.GoodsReceivedNoteBean)getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean",request );
	bean.initialize();
	bean.setLanguageId(locale);
//	bean.setReFamily(request, response);

	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_no					=		request.getParameter("doc_no");
	String mode						=		request.getParameter("mode");

	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	ServletContext context			=		getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
		bean.loadData();
		java.util.HashMap hmParameter	=	new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",bean.getDoc_type_code());
		hmParameter.put("doc_no",bean.getDoc_no());
		hmParameter.put("trn_type","GRN");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_GRN"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
	}


%>
<%
putObjectInBean( "goodsReceivedNoteBean",bean,request);
//Added on 6/21/2005
	String bean_id			=		"goodsReceivedNoteBean" ;
	String bean_name		=		"eST.GoodsReceivedNoteBean";
	String sql_id			=		"SQL_ST_GRN_STORE_SELECT";
	String trn_type			=		"GRN";
	StHeaderBean stBean		=		(StHeaderBean)getBeanObject( bean_id, bean_name,request);
	doc_type_code			=		bean.getDoc_type_code() ;
	doc_no					=		bean.getDoc_no() ;
	String doc_date			=		bean.getDoc_date();
	String doc_ref			=		bean.getDoc_ref();
	String store_code		=		bean.getStore_code() ;
	String storeSQLID		=		sql_id;
	String item_class_code	=		bean.getItem_class_code();
	
	//String docNoDisabled	=		"";
	
	mode					=		request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}

	stBean.setTrn_type(trn_type);
	stBean.setLanguageId(locale);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		stBean.setLocalEJB(false);
	stBean.setMode(mode);
	stBean.initStore_code_List(storeSQLID);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))
		stBean.initialize(trn_type);
	else{
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code, item_class_code);
	//	stBean.setItem_class_code (item_class_code);
		
	}

	putObjectInBean(bean_id,stBean,request);

	%>
	<!--<frameset rows='85,*'>-->
		<iframe name='frameGoodsReceivedNoteHeader'	 id='frameGoodsReceivedNoteHeader'	src="../../eST/jsp/GoodsReceivedNoteHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'  noresize style='height:20vh;width:99vw'></iframe>
		<!--<frameset cols="30%,*" 58 >-->
			<iframe name='frameGoodsReceivedNoteDetail' id='frameGoodsReceivedNoteDetail'	src="../../eST/jsp/GoodsReceivedNoteDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:74vh;width:24vw'></iframe>
			<iframe name='frameGoodsReceivedNoteList' id='frameGoodsReceivedNoteList'	src="../../eST/jsp/GoodsReceivedNoteListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no' noresize style='height:74vh;width:74vw'></iframe>
		<!--</frameset>
	</frameset>-->
	 <!--
		* @Name - Priya
		* @Date - 21/12/2009
		* @Inc# - IN017084
		* @Desc - To avoid the duplication records display in Modify mode
		 -->
	<script>
		clearMessageFrame();
	</script>
</html>
 
