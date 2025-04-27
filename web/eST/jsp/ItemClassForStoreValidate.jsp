<%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");
			
	
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemClassForStoreBean bean = (ItemClassForStoreBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	
	switch (functionType) {
		case 1: 
			{
					if (hash.size() > 0) {
						bean.updateSelectedItemClass(hash);
					}
			}
			break;
		default :
			out.println("alert(\'Invalid Function : "+functionType+"\');");
			return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
