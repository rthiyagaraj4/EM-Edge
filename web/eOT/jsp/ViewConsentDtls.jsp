<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConsentDetails.label","common_labels");%>
<TITLE><%=title%></TITLE>

<iframe name='message_search_frame' id='message_search_frame'	 src='../../eOT/jsp/ViewConsentHdr.jsp?<%=request.getQueryString()%>'  scrolling='no'  style='height:15vh;width:100vw'></iframe>
<iframe name='detailframe' id='detailframe' 		src="../../eOT/jsp/ViewConsentFrame.jsp?<%=request.getQueryString()%>"  scrolling='yes' nowrap style='height:85vh;width:100vw'></iframe>

