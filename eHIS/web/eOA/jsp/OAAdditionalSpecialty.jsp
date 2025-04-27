<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* ,eCommon.XSSRequestWrapper "  %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
%>

<title><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></title>
<iframe name='criteria_frame' id='criteria_frame' src='../../eOA/jsp/OAAdditionalSpecialtyCriteria.jsp?addtl_splty=<%=addtl_splty%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10vh;width:100vw'></iframe>
<iframe name='result_frame' id='result_frame'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:75vh;width:100vw'></iframe>
<iframe name='button_frame' id='button_frame'    src='../../eOA/jsp/OAAdditionalSpecialtyButton.jsp'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:15vh;width:100vw'></iframe>
</html>

