 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* "%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	
	String bean_id			= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String ph_trn_type		= request.getParameter( "ph_trn_type" );
	ArrayList arrListResult	= new ArrayList();
	Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash					= (Hashtable)hash.get( "SEARCH" ) ;
	DocumentTypeBean bean	= (DocumentTypeBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.setph_trn_type(ph_trn_type);
	arrListResult=(ArrayList)bean.getStockTransactionType(ph_trn_type);
	for(int i=0; i<arrListResult.size() ; i++)
		out.println("addToGlobalDrugRelated('"+arrListResult.get(i)+"','"+arrListResult.get(++i)+"')");

	putObjectInBean(bean_id,bean,request);
%>
