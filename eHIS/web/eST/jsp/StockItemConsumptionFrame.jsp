<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*,eST.Common.StHeaderBean"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
<%
				request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
	</link> -->
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/StockItemConsumption.js'></script>
	<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
	<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
try{
	eST.StockItemConsumptionBean bean = (eST.StockItemConsumptionBean)getBeanObject( "stockItemConsumptionBean", "eST.StockItemConsumptionBean",request );
// modified on 22/12...	
	//bean.clear();
	bean.initialize();
	bean.setLanguageId(locale);

	//bean.setReFamily(request, response);
	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	String mode				=	request.getParameter("mode");

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
		bean.loadData();
	}
putObjectInBean("stockItemConsumptionBean",bean,request);
//Added on 6/21/2005
	String bean_id = "stockItemConsumptionBean" ;
	String bean_name = "eST.StockItemConsumptionBean";
	String sql_id = "SQL_ST_STK_ITEM_CON_STORE_SELECT";
	String trn_type = "SAL";
	StHeaderBean stBean = (StHeaderBean)getBeanObject( bean_id, bean_name,request);
	stBean.setLanguageId(locale);
	doc_type_code=bean.getDoc_type_code() ;
	doc_no=bean.getDoc_no() ;
	String doc_date=bean.getDoc_date();
	String doc_ref=bean.getDoc_ref();
	String store_code=bean.getStore_code() ;
	String storeSQLID=sql_id;
	String item_class_code=bean.getItem_class_code();
	//String docNoDisabled=	"";
	
	mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}

	stBean.setTrn_type(trn_type);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		stBean.setLocalEJB(false);
	stBean.setMode(mode);
	stBean.initStore_code_List(storeSQLID);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))
		stBean.initialize(trn_type);
	else
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code,item_class_code);

	putObjectInBean(bean_id,stBean,request);

	Connection con				= null;

	con						= ConnectionManager.getConnection(request);		
	boolean is_new_con_screen = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","NEW_STOCK_ITEM_CONSUMPTION");//Adding start for TH-KW-CRF-0042
	String  new_con_screen_yn="N";
	if(is_new_con_screen)
		 new_con_screen_yn="Y";
	//Adding end for TH-KW-CRF-0042


 if(new_con_screen_yn.equals("N")){ //IF else condition added for TH-KW-CRF-0043
%>


			<iframe name='frameStockItemConsumptionHeader' id='frameStockItemConsumptionHeader'				src="../../eST/jsp/StockItemConsumptionHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:20vh;width:100vw'></iframe>
			<iframe name='frameStockItemConsumptionDetail' id='frameStockItemConsumptionDetail'			src="../../eST/jsp/StockItemConsumptionDetail.jsp?<%=request.getQueryString()%>"	frameborder=0 scrolling='auto'   noresize style='height:74vh;width:24vw'></iframe>
			<iframe name='frameStockItemConsumptionList' id='frameStockItemConsumptionList'			src="../../eST/jsp/StockItemConsumptionListFrame.jsp?<%=request.getQueryString()%>"		frameborder=0 scrolling='no' noresize style='height:74vh;width:74vw'></iframe>
<%}else{%>
       
		
			<iframe name='frameStockItemConsumptionHeader' id='frameStockItemConsumptionHeader'				src="../../eST/jsp/StockItemConsumptionHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:20vh;width:100vw'  noresize></iframe>
			<iframe name='frameStockItemConsumptionDetail' id='frameStockItemConsumptionDetail'			src="../../eST/jsp/StockItemConsumptionResult.jsp?<%=request.getQueryString()%>"	frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
		
<%}%>


</html>
<%
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
<%
	}
	  catch(Exception e) {
		e.printStackTrace();
	}
%>

