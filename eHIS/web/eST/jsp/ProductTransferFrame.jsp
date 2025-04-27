<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*,webbeans.eCommon.*, eST.Common.* ,java.sql.*, eCommon.Common.*, java.text.*, java.util.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		Connection con				= null;
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language='javascript' src='../../eST/js/StTransaction.js'></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!--  		<script language='javascript' src='../../eCommon/js/messages.js'></script>
 -->		<!-- <script language='javascript' src='../../eST/js/StMessages.js'></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<style type="text/css">
		input{
/*			font-family:  verdana;*/
			font-size: 10px;

		}
		select{
/*			font-family:  verdana;*/
			font-size: 10px;
		}
	</style>


<%  /*
	eST.ChangeBinLocationBean bean=(eST.ChangeBinLocationBean)mh.getBeanObject("changeBinLocationBean",request,"eST.ChangeBinLocationBean");
	bean.clear(); */
%>
<%
con						= ConnectionManager.getConnection(request);
	String bean_id = "ProductTransferBean" ;
	String bean_name = "eST.ProductTransferBean";
	String trn_type = "PRT";
	//String sql_id = "SQL_ST_PRODUCT_TRANSFER_STORE_SELECT";
	ProductTransferBean bean = (ProductTransferBean) getBeanObject(bean_id, bean_name, request);
	//Added for ML-MMOH-CRF-0448 US003 by B.Badmavathi starts 
	bean.setLanguageId(locale);
	StHeaderBean beanHdr = (StHeaderBean) getBeanObject("stHeaderBean","eST.Common.StHeaderBean", request);
	beanHdr.setLanguageId(locale);
	String mode;
	//boolean site= eCommon.Common.CommonBean.isSiteSpecific();
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_PRODUCT_TRANSFER");
//	System.out.println("site======product transfer start jsp= in frame====");
	//System.out.println(site);
	bean.setSite_spec_yn(site_main);
	boolean site=bean.isSite_spec_yn();
	System.out.println("site======product transfer start jsp= in frame====");
	System.out.println(site);
	//bean.getSiteSpec();
	//boolean site = bean.isSite_spec_yn();
	bean.initialize();
	beanHdr.initialize();
	if (site) {
		mode = eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		if (request.getParameter("doc_type_code") != null) {
			mode = eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");

		}
	}
	else {
		mode = bean.checkForNull(request.getParameter("mode"));
	}
	// Added for ML-MMOH-CRF-0448 US003 by B.Badmavathi ends 

	bean.setLanguageId(locale);
	StHeaderBean stBean  = (StHeaderBean) bean.getStHeaderBean();
		stBean.setLanguageId(locale);
	String doc_type_code=bean.checkForNull(stBean.getDoc_type_code()) ;
	String doc_no=bean.checkForNull(stBean.getDoc_no() );
	String doc_date=bean.checkForNull(stBean.getDoc_date());
	String doc_ref=bean.checkForNull(stBean.getDoc_ref());
	String store_code=bean.checkForNull(stBean.getStore_code()) ;
//	String storeSQLID=sql_id;
	String item_class_code=bean.checkForNull(stBean.getItem_class_code());

	//String docNoDisabled=	"";
	
	//String mode		= request.getParameter( "mode" ) ;
	//String mode		= bean.checkForNull(request.getParameter( "mode" ))  ;commented  for ML-MMOH-CRF-0448 by B.Badmavathi

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
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	
	}
	bean.setStHeaderBean(stBean);
	putObjectInBean(bean_id,bean,request);
	%>
	<iframe name='frameProductTransferHeader' id='frameProductTransferHeader' src="../../eST/jsp/ProductTransferHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:10VH;width:100vw'></iframe>
	   <iframe name='frameProductTransferAddModify' id='frameProductTransferAddModify'  src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:90vh;width:100vw'></iframe>
   

</html>

