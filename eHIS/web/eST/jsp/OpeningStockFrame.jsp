	<!DOCTYPE html>
 <%@ page  import=" java.text.*, java.util.*,eST.Common.*,eST.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 


<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
 String facilityid=(String)session.getValue("facility_id");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eST/js/OpeningStock.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	
	eST.OpeningStockBean bean = (eST.OpeningStockBean) getBeanObject( "openingStockBean",  "eST.OpeningStockBean" ,request);
	bean.setLanguageId(locale);
//	bean.clear();
	bean.initialize();
%>
<%
putObjectInBean("openingStockBean",bean,request);
%>
<%
	

	String bean_id = "openingStockBean" ;
	String bean_name = "eST.OpeningStockBean";
	String trn_type = "OBS";
	//String sql_id = "SQL_ST_OBS_STORE_SELECT";


	eST.OpeningStockBean  bean1 = (eST.OpeningStockBean)getBeanObject( bean_id, bean_name,request);
	bean1.setLanguageId(locale);
	bean1.setLoginFacilityId(facilityid);

	StHeaderBean stBean  = (StHeaderBean) bean1.getStHeaderBean();
	stBean.setLanguageId(locale);
	stBean.setLoginFacilityId(facilityid);
	String doc_type_code=bean.checkForNull(stBean.getDoc_type_code()) ;
	String doc_no=bean.checkForNull(stBean.getDoc_no() );
	String doc_date=bean.checkForNull(stBean.getDoc_date());
	String doc_ref=bean.checkForNull(stBean.getDoc_ref());
	String store_code=bean.checkForNull(stBean.getStore_code()) ;
	//String storeSQLID=sql_id;
	String item_class_code=bean.checkForNull(stBean.getItem_class_code());

	//String docNoDisabled=	"";
	
	//String mode		= request.getParameter( "mode" ) ;
	String mode		= bean.checkForNull(request.getParameter( "mode" ));
	
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
		e.printStackTrace();
	}
	bean1.setStHeaderBean(stBean);
	putObjectInBean(bean_id,bean1,request);
	%>
	<%-- <frameset rows='20,*'>
		<iframe name='frameOpeningStockHeader'src="../../eST/jsp/OpeningStockHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize >
		<frameset cols="30%,*" >
			<iframe name='frameOpeningStockDetail' src="../../eST/jsp/OpeningStockDetail.jsp?<%=request.getQueryString()%>"frameborder=0 scrolling='auto'   noresize >
			<iframe name='frameOpeningStockList'	src="../../eST/jsp/OpeningStockListFrame.jsp?<%=request.getQueryString()%>"	frameborder=0 scrolling='no' noresize >
			</frameset>'
		</frameset>
	</frameset> --%>
	  <iframe name="frameOpeningStockHeader" src="../../eST/jsp/OpeningStockHeader.jsp?<%=request.getQueryString()%>" style="height:5vh; width:100vw; border:none;" scrolling="no"></iframe>
 		<div style="height: 100vh; display: flex;">
			<iframe name="frameOpeningStockDetail" src="../../eST/jsp/OpeningStockDetail.jsp?<%=request.getQueryString()%>" style="height:100%; width:20vw; border:none;" scrolling="auto"></iframe>
			<iframe name="frameOpeningStockList" src="../../eST/jsp/OpeningStockListFrame.jsp?<%=request.getQueryString()%>" style="height:100%; width:80vw; border:none;" scrolling="no"></iframe>
	    </div>

 
</html>
