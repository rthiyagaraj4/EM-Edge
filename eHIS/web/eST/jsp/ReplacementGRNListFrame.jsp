<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" java.text.*, java.util.*,eST.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<!-- <link rel="stylesheet" type ="text/css"
		href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
	ReplacementGRNBean bean = (ReplacementGRNBean) getBeanObject( "replacementGRNBean", "eST.ReplacementGRNBean" ,request);
bean.setLanguageId(locale); 	  
String index=request.getParameter("index");

%>
<%
//putObjectInBean("replacementGRNBean",bean,request);
%>
	<frameset rows='140,*'>
		<frame name='frameGoodsReceivedNoteListHeader' id='frameGoodsReceivedNoteListHeader'	src="../../eST/jsp/ReplacementGRNListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>

		<%if (index==null){
		%>
		<frame name='frameGoodsReceivedNoteListDetail' id='frameGoodsReceivedNoteListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<%
		}
		else{
		String item_code	=	(String)bean.getDtlRecord(Integer.parseInt(index)).get("item_code");

		
		%>
		<frame name='frameGoodsReceivedNoteListDetail' id='frameGoodsReceivedNoteListDetail' src="../../eST/jsp/ReplacementGRNListDetail.jsp?<%=request.getQueryString()%>&item_code=<%=item_code%>" frameborder=0 scrolling='no'   noresize>
		<%
		}
		%>
	</frameset>


</html>


