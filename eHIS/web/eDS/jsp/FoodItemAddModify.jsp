<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>


<%
//Checkstyle Violation commented by Munisekhar
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params = request.getQueryString();
%>

			<iframe name="FoodItemTab" id="FoodItemTab" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/FoodItemTab.jsp?<%=params%>" style="height:6vh;width:100vw;border:0"></iframe>
				<iframe name='FoodItemAdd' id='FoodItemAdd' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no' style='height:94vh;width:100vw;border:0'></iframe>
 			


