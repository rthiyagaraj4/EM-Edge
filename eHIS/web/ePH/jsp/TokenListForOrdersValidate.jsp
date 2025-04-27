 <%--saved on 27th Oct 2005 --%>
<%@page  import="java.sql.*,java.text.DecimalFormat, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*, com.ehis.util.*  " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String validate			= request.getParameter("validate")==null?"":request.getParameter("validate");
	Hashtable hash			= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash					= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id = "TokenListForOrdersBean" ;
		String bean_name = "ePH.TokenListForOrdersBean";
		TokenListForOrdersBean bean = (TokenListForOrdersBean)getBeanObject( bean_id, bean_name, request ) ;

	if ( validate.equals("onLinePrinting")){
		bean.printTokenList(request,response);
	}
	putObjectInBean(bean_id,bean,request);
%>
