 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* , eCommon.Common.*"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name= request.getParameter( "bean_name" ) ;
	StorageLocationForDispLocnBean bean = (StorageLocationForDispLocnBean)getBeanObject(bean_id,bean_name,request) ;
	bean.clear();
	ArrayList wsno = new ArrayList();
	for (int i=0;i<wsno.size();i++){
		out.println("loadIntoWS('"+(String)wsno.get(i)+"','"+(String)wsno.get(++i)+"')");
	}
	putObjectInBean(bean_id,bean,request);
%>
