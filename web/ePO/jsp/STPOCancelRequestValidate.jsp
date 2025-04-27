  <%@page import="java.util.*,ePO.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");
	String request_by_store		=	request.getParameter("request_by_store");
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));

	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	boolean result			=		false;
	String message			=		"";
	String flag				=		"";
	
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	STPOCancelRequestBean bean		=	(STPOCancelRequestBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	

	switch (functionType) {
	case 1:
		{
			bean.updateRemarks(hash);
		}
		break;
	case 2:
		{
			bean.updateSelectedValues(hash);
		}
		break;
	case 3:
		{	
			String key_code = request.getParameter("key");
			bean.setRemarks(key_code);
		}
		break;	
	case 4:
		{	
			if(bean.getCheckItems().size() > 0)
				result = true;
			else
				result = false;
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;	
		}
		break;	
	default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
