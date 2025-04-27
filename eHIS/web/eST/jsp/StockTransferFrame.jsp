<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page contentType="text/html;charset=UTF-8" import=" eST.Common.StDuoHeaderBean" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/StockTransfer.js'></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%

	eST.StockTransferBean bean = (eST.StockTransferBean)getBeanObject( "stockTransferBean","eST.StockTransferBean", request  );
	bean.setLanguageId(locale);	
	bean.initialize();
	
	
	/*eST.Common.StTransaction st_bean = (eST.Common.StTransaction)getBeanObject( "stTransaction","eST.Common.StTransaction", request  );
	st_bean.setLanguageId(locale);
	st_bean.clear();*/


	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	String mode				=	request.getParameter("mode");
	//added for barcode
	String param = request.getQueryString();

	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode(mode);

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
	try{
		bean.loadData();
	}catch(Exception e){}

		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","TFR");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
					phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_TFR"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
					out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
	}
%>
<%
	putObjectInBean("stockTransferBean",bean,request);
	String bean_id = "stDuoHeaderBean" ;
	String bean_name = "eST.Common.StDuoHeaderBean";
	String trn_type = "TFR";
	StDuoHeaderBean stDuoBean = (StDuoHeaderBean)getBeanObject( bean_id, bean_name,request);
	stDuoBean.setLanguageId(locale);
	doc_type_code=bean.getDoc_type_code() ;
	doc_no=bean.getDoc_no() ;
	String doc_date=bean.getDoc_date();
	String doc_ref=bean.getDoc_ref();
	String from_store_code=bean.getFrom_store_code();
	String to_store_code=bean.getTo_store_code() ;
	String item_class_code=bean.getItem_class_code();
	
	mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stDuoHeaderBean")) {
		stDuoBean.clear() ;
	}
	stDuoBean.setTrn_type(trn_type);
	stDuoBean.initDoc_type_code_List();
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		stDuoBean.setLocalEJB(false);
		stDuoBean.setMode(mode);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))
		stDuoBean.initialize(trn_type);
	else
		stDuoBean.initialize(trn_type, doc_type_code, doc_no, doc_date,  doc_ref,from_store_code,to_store_code,item_class_code);
	
	putObjectInBean(bean_id,stDuoBean,request);

%>
			<iframe name='frameStockTransferHeader'	id='frameStockTransferHeader'	src="../../eST/jsp/StockTransferHeader.jsp?<%=param%>" align='right' frameborder=0 scrolling='no'   noresize style="height:10vh;width:100vw"></iframe>
			<!--<frame name='frameStockTransferDetail'			src="../../eST/jsp/StockTransferDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize>
			<frame name='frameStockTransferList'			src="../../eST/jsp/StockTransferListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>-->
			
			<iframe name='frameStockTransferDetail' id='frameStockTransferDetail' src="../../eCommon/html/blank.html" frameborder=0 scrolling="auto" style="height:90vh;width:30vw" align='left'  noresize></iframe>
			<iframe name='frameStockTransferList' id='frameStockTransferList' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style="height:90vh;width:70vw" align='right' noresize></iframe>

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
