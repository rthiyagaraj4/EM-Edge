<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>


<%
String params = request.getQueryString();
%>

			<iframe name="SpecialtiesForKitchenList" id="SpecialtiesForKitchenList" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/SpecialtiesForKitchenList.jsp?<%=params%>" style="height:20vh;width:99vw;border:0"></iframe>
			<iframe name='SpecialtiesForKitchenModify' id='SpecialtiesForKitchenModify' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no' style='height:76vh;width:99vw;border:0'></iframe>
 			

