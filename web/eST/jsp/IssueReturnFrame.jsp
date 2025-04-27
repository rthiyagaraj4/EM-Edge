<!DOCTYPE html>
 <%@ page  contentType="text/html;charset=UTF-8"  import=" eST.IssueReturnBean,eST.Common.StDuoHeaderBean,java.util.HashMap,java.lang.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
	<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id") %>"
		module_id	= "<%= request.getParameter( "module_id") %>"
    </script>
</head>
<%	
	eST.IssueReturnBean bean = (eST.IssueReturnBean) getBeanObject( "issueReturnBean", "eST.IssueReturnBean",request );
	bean.setLanguageId(locale);
	bean.initialize();
//	bean.setReFamily(request, response);
	String doc_type_code = request.getParameter("doc_type_code");
	String doc_no = request.getParameter("doc_no");
	String mode = request.getParameter("mode");
	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode(mode);
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
	
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
		bean.loadData();
		HashMap hmParameter = new HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","RET");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_ISS_RET"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
	}
%>
<%
putObjectInBean("issueReturnBean",bean,request);
//Added on 6/21/2005
	String bean_id = "stDuoHeaderBean" ;
	String bean_name = "eST.Common.StDuoHeaderBean";
//	String sql_id = "SQL_ST_GRN_STORE_SELECT";
	String trn_type = "URG";
	//String sql_from_store = "SQL_ST_ISSUE_REQ_URG_FROM_STORE";
	//String sql_to_store = "SQL_ST_ISSUE_REQ_URG_TO_STORE";
	//String Modal_Window_Open = "Yes";
	StDuoHeaderBean stDuoBean = (StDuoHeaderBean)getBeanObject( bean_id, bean_name,request);
	stDuoBean.setLanguageId(locale);
	doc_type_code=bean.getDoc_type_code() ;
	doc_no=bean.getDoc_no() ;
	String doc_date=bean.getDoc_date();
	String doc_ref=bean.getDoc_ref();
	String from_store_code=bean.getFrom_store_code();
	String to_store_code=bean.getTo_store_code() ;
	//String storeSQLID=sql_id;
	String item_class_code=bean.getItem_class_code();
	//String docNoDisabled=	"";
	
	mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stDuoHeaderBean")) {
		stDuoBean.clear() ;
	}

	stDuoBean.setTrn_type(trn_type);
//	stDuoBean.setDefault_doc(stDuoBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stDuoBean.initDoc_type_code_List();
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		stDuoBean.setLocalEJB(false);
	stDuoBean.setMode(mode);
//	stDuoBean.initStore_code_List(storeSQLID);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))
		stDuoBean.initialize(trn_type);
	else
		stDuoBean.initialize(trn_type, doc_type_code, doc_no, doc_date,  doc_ref,from_store_code,to_store_code,item_class_code);
	
	putObjectInBean(bean_id,stDuoBean,request);

%>

		<iframe name='frameIssueReturnHeader' id='frameIssueReturnHeader' src="../../eST/jsp/IssueReturnHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:13vh;width:100vw'></iframe>
			<iframe name='frameIssueReturnDetail' id='frameIssueReturnDetail' src="../../eST/jsp/IssueReturnDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:74vh;width:24vw'></iframe>
			<iframe name='frameIssueReturnList' id='frameIssueReturnList' src="../../eST/jsp/IssueReturnListFrame.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:74vh;width:74vw'></iframe>
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

