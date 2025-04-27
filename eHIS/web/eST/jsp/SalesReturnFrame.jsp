<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import=" eST.Common.StHeaderBean"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <script language='javascript' src='../../eST/js/StCommon.js'></script> -->
	<script language='javascript' src='../../eST/js/SalesReturn.js'></script>
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
	java.util.Properties prop	=		(java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		=		prop.getProperty( "client_ip_address" );
	String bean_id				=		"salesReturnBean"+login_at_ws_no;
	String bean_name			=		"eST.SalesReturnBean";

	eST.SalesReturnBean bean = (eST.SalesReturnBean) getBeanObject(bean_id,bean_name, request);
	bean.setLanguageId(locale);
	bean.initialize();

	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	String patient_id		=	request.getParameter("patient_id");
	String encounter_id		=	request.getParameter("encounter_id");
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
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
		bean.setPatient_id(patient_id);
		bean.setEncounter_id(encounter_id);
		System.out.println("store......3...."+bean.getStore_code());
		System.out.println("doc_type_code......3...."+doc_type_code);
		System.out.println("doc_no......3...."+doc_no);
		bean.loadData();
		System.out.println("store......4...."+bean.getStore_code());

		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","SRT");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_RET"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
}
%>
<%
putObjectInBean(bean_id,bean,request);
//Added on 6/21/2005

	String sql_id = "SQL_ST_SALES_RET_STORE_SELECT";
	String trn_type = "SRT";
	StHeaderBean stBean = (StHeaderBean)getBeanObject( bean_id, bean_name,request);
	stBean.setLanguageId(locale);
	doc_type_code=bean.getDoc_type_code() ;
	doc_no=bean.getDoc_no() ;
	String doc_date=bean.getDoc_date();
	String doc_ref=bean.getDoc_ref();
	String store_code=bean.getStore_code() ;
	String storeSQLID=sql_id;
	String item_class_code=bean.getItem_class_code();
	
	mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}

	stBean.setTrn_type(trn_type);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();
	
	/* Commented for PE as it is already performed at the top
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))){ 
		stBean.setLocalEJB(false);
	}*/
	stBean.setMode(mode);
	stBean.initStore_code_List(storeSQLID);
	
	System.out.println("store_code...."+store_code+"...doc_date..."+doc_date);
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
		stBean.initialize(trn_type);
	}
	else{
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code,item_class_code);
	}

	putObjectInBean(bean_id,stBean,request);
%>
	<iframe name='frameSalesReturnHeader' src="../../eST/jsp/SalesReturnHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:22vh;width:100vw'></iframe>
    <iframe name='frameSalesReturnDetail' src="../../eST/jsp/SalesReturnDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:78vh'></iframe>
	<iframe name='frameSalesReturnList'	src="../../eST/jsp/SalesReturnListFrame.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:78vh;width:65vw'></iframe>
		

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
