<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>


<%
//Checkstyle Violation commented by Munisekhar
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params = request.getQueryString();
%>

<iframe name="WardsForKitchenList" id="WardsForKitchenList" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/WardsForKitchenList.jsp?<%=params%>" style="height:15vh;width:97vw;border:0"></iframe>
<iframe name='WardsForKitchenModify' id='WardsForKitchenModify' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no' style='height:80vh;width:97vw;border:0'></iframe>
 			

