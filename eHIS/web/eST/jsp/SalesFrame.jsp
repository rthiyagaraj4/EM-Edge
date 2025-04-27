<!DOCTYPE html>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="eST.Common.StHeaderBean"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/Sales.js'></script>
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
	eST.SalesBean bean = (eST.SalesBean) getBeanObject( "salesBean", "eST.SalesBean",request );
	bean.setLanguageId(locale);
	//Added by Rabbani inc no:26404 on 03/02/12
    bean.setModuleId(bean.checkForNull((String)request.getParameter("module_id"),"ST"));
	bean.initialize();

	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	String mode				=	request.getParameter("mode");

	if ((mode == null) || (mode.equals(""))){ 
		return;
	}
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT")))){
		return;
	}
ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))){ 
		bean.setLocalEJB(false);
	}
	bean.setMode(mode);

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		System.out.println("Inside MODE");
		try{//Added by suresh.r on 17-12-2014 against Inc 53074
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
		bean.loadData();
		}catch(Exception e){}
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","SAL");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_SAL"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				//out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");//Commented by suresh.r on 19-12-2014 against Inc 53074
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);history.go(-1);clearMessageFrame();</script>");//Added by suresh.r on 19-12-2014 against Inc 53074
		}	
	}


%>
<%
putObjectInBean( "salesBean",bean,request);
//Added on 6/21/2005
	String bean_id = "salesBean" ;
	String bean_name = "eST.SalesBean";
	String sql_id = "SQL_ST_SAL_STORE_SELECT";
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
	//added for barcode
	String param = request.getQueryString();
	//String docNoDisabled=	"";
	
	mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}

	stBean.setTrn_type(trn_type);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))){ 
		stBean.setLocalEJB(false);
	}
	stBean.setMode(mode);
	stBean.initStore_code_List(storeSQLID);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
		stBean.initialize(trn_type);
	}else{
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code,item_class_code);
	}

	putObjectInBean(bean_id,stBean,request);
int frame_size = 125;
if((bean.getModuleId()).equals("OT")){
	frame_size = 65;
}
%>

		<iframe name='frameSalesHeader' src="../../eST/jsp/SalesHeader.jsp?<%=param%>" frameborder=0 scrolling='no' style="height:25vh;width:100vw"></iframe>
			<iframe name='frameSalesDetail' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style="height:75vh;"></iframe>
			<iframe name='frameSalesList' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style="height:75vh;width:65vw"></iframe>

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
