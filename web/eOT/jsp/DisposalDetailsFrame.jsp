<!DOCTYPE html>


<%@page  import ="eCommon.Common.CommonBean,eOT.*,eOT.Common.*" contentType=" text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>

<% 
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String params="oper_num="+oper_num+"&slate_user_id="+slate_user_id;
//session.putValue("queryString",params);
%>


<HTML>
<HEAD></HEAD>
<FRAMESET ROWS='12%,*' border='0'>
<FRAME NAME='title_frame' SRC="../../eOT/jsp/DisposalUntowardTitle.jsp?title=Disposal Details" noresize  scrolling='no' noresize='no'></FRAME>
<FRAMESET COLS='47%,*' border='0'>
<FRAME NAME='disposal_record_frame' SRC='../../eOT/jsp/DisposalRecord.jsp?oper_num=<%=params%>' noresize  scrolling='yes' noresize='no'></FRAME>
<FRAME NAME='disposal_detail_frame' SRC='../../eOT/jsp/DisposalDtls.jsp' scrolling='auto' noresize='no'></FRAME>
</FRAMESET>
</FRAMESET>
</HTML>

