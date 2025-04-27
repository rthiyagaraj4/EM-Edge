<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% 
	/*String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String params="oper_num="+oper_num+"&slate_user_id="+slate_user_id;*/
	
	String params = request.getQueryString();

    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>

<HTML>
<HEAD></HEAD>
<FRAMESET ROWS='5%,*' border='0'>
<FRAME NAME='untowards_evt_record_frame' SRC="../../eOT/jsp/DisposalUntowardTitle.jsp?" noresize  scrolling='no' noresize='no'></FRAME>
<FRAMESET ROWS='45%,*' border='0'>
<FRAME NAME='untowards_evt_record_frame' SRC='../../eOT/jsp/UntowardEvtsRecord.jsp?<%=params%>' noresize  scrolling='no' noresize='no'></FRAME>
<FRAME NAME='untowards_evt_detail_frame' SRC='../../eCommon/html/blank.html' scrolling='auto' noresize='no'></FRAME>
</FRAMESET>
</FRAMESET>
</HTML>

