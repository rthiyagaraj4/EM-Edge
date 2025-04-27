<%-- saved on 02/05/2018 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString(request);
	hash				= (Hashtable)hash.get("SEARCH");
	String bean_id   = "TPNConsGenericBean" ;
    String bean_name = "ePH.TPNConsGenericBean";
	String func_mode	= request.getParameter("func_mode");
    
	TPNConsGenericBean bean = (TPNConsGenericBean)getBeanObject( bean_id,bean_name,request) ;

    if(func_mode!=null && func_mode.equals("get_srl_no")) {
		
    	String constGrpCode = (hash.get("constGrpCode")==null)?"":(String)hash.get("constGrpCode");
		String uomLevel     = (hash.get("uomLevel")==null)?"":(String)hash.get("uomLevel");
		String srlNo        = bean.getSrlNo(constGrpCode, uomLevel);
	
		out.println("displaySrlNo("+srlNo+")");
	}
    
	putObjectInBean(bean_id,bean,request);
%>
