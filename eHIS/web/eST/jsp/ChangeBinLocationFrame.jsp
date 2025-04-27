
 <%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*, java.lang.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String facility_id			= (String)session.getAttribute("facility_id");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--<script language='javascript' src='../../eST/js/Trans.js'></script> -->
<!--		<script language='javascript' src='../../eST/js/StCommon.js'></script> -->
		<script language='javascript' src='../../eST/js/ChangeBinLocation.js'></script>
	<!-- 	<script language='javascript' src='../../eCommon/js/messages.js'></script>
		<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	eST.ChangeBinLocationBean bean=(eST.ChangeBinLocationBean)getBeanObject("ChangeBinLocationBean", "eST.ChangeBinLocationBean",request);
    bean.initialize();
bean.setLanguageId(locale); 	 
putObjectInBean("ChangeBinLocationBean",bean,request);
%>
<%

	String bean_id = "ChangeBinLocationBean" ;
	String bean_name = "eST.ChangeBinLocationBean";
	String trn_type = "ADJ";
	//String sql_id = "SQL_ST_CHANGE_BIN_STORE_SELECT";


	eST.ChangeBinLocationBean  bean1 = (eST.ChangeBinLocationBean)getBeanObject( bean_id, bean_name,request);
	StHeaderBean stBean  = (StHeaderBean) bean1.getStHeaderBean();
	stBean.setLanguageId(locale); 
	stBean.setLoginFacilityId(facility_id); 
	String doc_type_code=bean.checkForNull(stBean.getDoc_type_code()) ;
	String doc_no=bean.checkForNull(stBean.getDoc_no() );
	String doc_date=bean.checkForNull(stBean.getDoc_date());
	//out.println("=====" +doc_date);

	String doc_ref=bean.checkForNull(stBean.getDoc_ref());
	String store_code=bean.checkForNull(stBean.getStore_code()) ;
		//out.println("=====" +store_code);
		//out.println("=====" +doc_type_code);
	//String storeSQLID=sql_id;
	String item_class_code=bean.checkForNull(stBean.getItem_class_code());

	//String docNoDisabled=	"";
	
	String mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}
	stBean.setTrn_type(trn_type);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	stBean.setLocalEJB(false);
	stBean.setMode(mode);
//	stBean.initStore_code_List(storeSQLID);
	try{
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))

		stBean.initialize(trn_type);
	else
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code , item_class_code);
	}catch(Exception e)
	{
		System.err.println("Detail page loaded first");
	}
	bean1.setStHeaderBean(stBean);
	putObjectInBean(bean_id,bean1,request);
	%>
	<iframe name='frameChangeBinLocationHeader' id='frameChangeBinLocationHeader'				src="../../eST/jsp/ChangeBinLocationHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='frameChangeBinLocationDetail' id='frameChangeBinLocationDetail'			src="../../eST/jsp/ChangeBinLocationDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:75vh;width:100vw'></iframe>
		<iframe name='frameChangeBinLocationList' id='frameChangeBinLocationList'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>	
</html>

