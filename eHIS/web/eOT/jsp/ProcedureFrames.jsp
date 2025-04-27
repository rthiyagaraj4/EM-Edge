<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="eCommon.XSSRequestWrapper,eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>

<% 
   String params = CommonBean.checkForNull(request.getQueryString()); 
   String tab = CommonBean.checkForNull(request.getParameter("tab"));
 %>

<% if(tab.equals("record_surgeon")){ %>
<iframe name="euip_tab" id="euip_tab"  scrolling="no" noresize src="../../eOT/jsp/OperationEquipmentsTab.jsp?<%=params%>" style="height:8vh;width:100vw;border:0"></iframe>
	<iframe name='ChildBaseFrame' id='ChildBaseFrame' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no' style='height:50vh;width:100vw;border:0'></iframe>
	<iframe name='ResultsFrame' id='ResultsFrame' scrolling="yes" SRC='../../eCommon/html/blank.html'    noresize='no' style='height:42vh;width:100vw;border:0'></iframe>
 
<%} else if(tab.equals("record_nursing")){ %>
<iframe name="euip_tab" id="euip_tab" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/OperationEquipmentsTab.jsp?<%=params%>" style="height:8vh;width:100vw;border:0"></iframe>
	<iframe name='ChildBaseFrame' id='ChildBaseFrame' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no' style='height:50vh;width:100vw;border:0'></iframe>
	<iframe name='ResultsFrame' id='ResultsFrame' scrolling="no" SRC='../../eCommon/html/blank.html'    noresize='no' style='height:42vh;width:100vw;border:0'></iframe>

<% } %>

