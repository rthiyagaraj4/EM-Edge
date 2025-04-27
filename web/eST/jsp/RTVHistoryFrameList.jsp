<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String grn_doc_no = request.getParameter("grn_doc_no")==null?"":request.getParameter( "grn_doc_no" ) ;
String grn_doc_type_code = request.getParameter("grn_doc_type_code")==null?"":request.getParameter( "grn_doc_type_code" ) ;
String doc_no = request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
String doc_type_code = request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
String grnDet_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.GRNDetailsfor.label","st_labels");

//System.err.println("Enter in t oth e RTVHIstory Frame List grnDet_legend-->"+grnDet_legend);
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/GRNHistoy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><%=grnDet_legend%> <%=doc_type_code%>/<%=doc_no%></title>
</head>
<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0"  style="height:10vh;width:99vw"></iframe><iframe name="detailsFrame" id="detailsFrame"  
	noresize src='../../eST/jsp/RTVHistoyGRNList.jsp?grn_doc_no=<%=grn_doc_no%>&grn_doc_type_code=<%=grn_doc_type_code%>&item_code=<%=item_code%>' frameborder="0" scrolling="auto" style='height:88vh;width:99vw'></iframe>
</html>

