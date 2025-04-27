<!DOCTYPE html>
	 <%@ page contentType="text/html;charset=UTF-8" 
import=" java.text.*,java.lang.*,java.util.*,eST.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<%
		request.setCharacterEncoding("UTF-8");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> 82-->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean)getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean" ,request );

String index=request.getParameter("index");
%>

	<!--<frameset rows='140,*' 100>-->
		<iframe name='frameGoodsReceivedNoteListHeader' id='frameGoodsReceivedNoteListHeader'	src="../../eST/jsp/GoodsReceivedNoteListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:47vh;width:99vw'></iframe>

		<%if (index==null){
		%>
		<iframe name='frameGoodsReceivedNoteListDetail' id='frameGoodsReceivedNoteListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:53vh;width:100vw'></iframe>
		<%
		}
		else{
		String item_code	=	(String)bean.getDtlRecord(Integer.parseInt(index)).get("item_code");

		
		%>
		<iframe name='frameGoodsReceivedNoteListDetail' id='frameGoodsReceivedNoteListDetail' src="../../eST/jsp/GoodsReceivedNoteListDetail.jsp?<%=request.getQueryString()%>&item_code=<%=item_code%>" frameborder=0 scrolling='auto'   noresize style='height:53vh;width:100vw'></iframe>
		<%
		}
		%>
	<!--</frameset>-->
	<%
putObjectInBean("goodsReceivedNoteBean",bean,request);
%>


</html>

