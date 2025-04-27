<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"  import=" java.text.*, java.util.*,eST.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
		<title> </title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!--  		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
	GoodsReturnToVendorBean bean = (GoodsReturnToVendorBean) getBeanObject( "goodsReturnToVendorBean","eST.GoodsReturnToVendorBean", request );
			bean.setLanguageId(locale);

String index=request.getParameter("index");
%>
<%
//putObjectInBean("goodsReturnToVendorBean",bean,request);
%>
	<!--<frameset rows='160,*'>-->
		<iframe name='frameGoodsReturnToVendorListHeader' id='frameGoodsReturnToVendorListHeader'	src="../../eST/jsp/GoodsReturnToVendorListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:55vh;width:100vw'></iframe>

		<%if (index==null){
		%>
			<iframe name='frameGoodsReturnToVendorListDetail' id='frameGoodsReturnToVendorListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:45vh;width:100vw'></iframe>
		<%
		}
		else{
			
			String item_code	=	(String)bean.getDtlRecord(Integer.parseInt(index)).get("item_code");
			
		%>
			<iframe name='frameGoodsReturnToVendorListDetail' id='frameGoodsReturnToVendorListDetail' src="../../eST/jsp/GoodsReturnToVendorListDetail.jsp?<%=request.getQueryString()%>&item_code=<%=item_code%>" frameborder=0 scrolling='auto'   noresize style='height:45vh;width:100vw'></iframe>
		<%
		}
		%>
	<!--</frameset>-->


</html>

