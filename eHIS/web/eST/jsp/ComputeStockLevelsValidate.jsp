
 <%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	ComputeStockLevelsBean bean = (ComputeStockLevelsBean)getBeanObject( "computeStockLevelsBean", "eST.ComputeStockLevelsBean",request ) ;  
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String validate	=	request.getParameter("validate");
	if (validate.equals("FETCH_ITEM")) {

		bean.loadData(hash);
	}
	else if (validate.equals("UPDATE_DETAILS")) {
		bean.updateData(hash);
	}

putObjectInBean("computeStockLevelsBean",bean,request);
%>
