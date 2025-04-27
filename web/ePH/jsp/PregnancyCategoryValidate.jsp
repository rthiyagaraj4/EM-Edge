
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.*,java.io.*,ePH.Common.*,ePH.*,eCommon.XSSRequestWrapper"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale = (String) session.getAttribute("LOCALE");

	Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
	hash = (Hashtable) hash.get("SEARCH");

	String bean_id = (String) hash.get("bean_id");
	String bean_name = (String) hash.get("bean_name");
	String func_mode = request.getParameter("func_mode");
	PregnancyCategoryBean bean = (PregnancyCategoryBean) getBeanObject(bean_id, bean_name, request);

	
  
   if (func_mode != null && func_mode.equals("checkCGCode")) {
		String cgCode = request.getParameter("cgCode") == null ? "": request.getParameter("cgCode");
        int  count = bean.serachForCGCode(cgCode);
		if (count > 0 ){
			 out.println("showMessage('"+cgCode+"')");
		}
	}
	
%>
