<!DOCTYPE html>

<%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<meta name="Author" content="Geetha CR">
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/AdjustStock.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	</head>
<%

	AdjustStockBean			bean			=		(AdjustStockBean) getBeanObject( "adjustStockBean","eST.AdjustStockBean",request );
	AdjustStockDetailBean	beandtl			=		(AdjustStockDetailBean) getBeanObject( "AdjustStockDetailBean","eST.AdjustStockDetailBean",request );
	bean.setLanguageId(locale);
	StHeaderBean beanHdr					=		(StHeaderBean) getBeanObject( "stHeaderBean","eST.Common.StHeaderBean",request );
	beanHdr.setLanguageId(locale);
	beandtl.setLanguageId(locale);
    bean.initialize();
//	bean.setReFamily(request, response);
//	bean.clear();
	beanHdr.initialize();


	//To set values in AdjustStockBean

	bean.setAdjustStockHeaderBean(beanHdr);

	String doc_type_code					=		request.getParameter("doc_type_code");
	String doc_no							=		request.getParameter("doc_no");
	String mode								=		request.getParameter("mode");
	if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
		bean.loadAllItemData(doc_type_code, doc_no);
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","ADJ");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id					=		(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_ADJ"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
	}

putObjectInBean("adjustStockBean",bean,request);

%>
<%

	String bean_id							=		"adjustStockBean" ;
	String bean_name						=		"eST.AdjustStockBean";
	String trn_type							=		"ADJ";
	String sql_id							=		"SQL_ST_ADJ_STORE_SELECT";


	AdjustStockBean  adjStkBean				=		(AdjustStockBean)getBeanObject( bean_id, bean_name,request);
	adjStkBean.setLanguageId(locale);

	StHeaderBean stBean						=		(StHeaderBean) adjStkBean.getStHeaderBean();
	stBean.setLanguageId(locale);
	doc_type_code							=		stBean.getDoc_type_code() ;
	doc_no									=		stBean.getDoc_no() ;
	String doc_date							=		stBean.getDoc_date();
	String doc_ref							=		stBean.getDoc_ref();
	String store_code						=		stBean.getStore_code() ;
	String storeSQLID						=		sql_id;
	String item_class_code					=		stBean.getItem_class_code();
//	String docNoDisabled					=		"";
	mode									=		request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}
	stBean.setTrn_type(trn_type);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();

	ServletContext context					=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	stBean.setLocalEJB(false);
	stBean.setMode(mode);
	stBean.initStore_code_List(storeSQLID);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))
		stBean.initialize(trn_type);
	else
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code , item_class_code);
	adjStkBean.setStHeaderBean(stBean);
	putObjectInBean(bean_id,adjStkBean,request);
	
	%>
	<%-- <frameset rows='20,*'>
		<frame name='frameAdjustStockHeader'				src="../../eST/jsp/AdjustStockHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="30%,*" >
			<frame name='frameAdjustStockDetail'			src="../../eST/jsp/AdjustStockDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize>
			<frame name='frameAdjustStockList'			src="../../eST/jsp/AdjustStockListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no' noresize>
			</frameset>
		</frameset>
	</frameset> --%>
	
		<iframe name='frameAdjustStockHeader'				src="../../eST/jsp/AdjustStockHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:4vh;width:100vw'></iframe>
		<iframe name='frameAdjustStockDetail'			src="../../eST/jsp/AdjustStockDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' align ="left"  noresize style='height:20vh;width:20vw'></iframe>
		<iframe name='frameAdjustStockList'			src="../../eST/jsp/AdjustStockListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'  style='height:90vh;width:80vw'></iframe>
	
	<!--
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	 -->
		<script>
		clearMessageFrame();
		</script>
	<%
//putObjectInBean("stHeaderBean",beanHdr,request);
%>
</html>
