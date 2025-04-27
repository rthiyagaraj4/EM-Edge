<%-- JSP Page specific attributes start --%>
<%@page import="eCommon.Common.*,java.util.*" %> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<jsp:useBean id="CommonBean"  scope="page"  class="eCommon.Common.CommonBean" />
<%-- Mandatory declarations end --%>
<%
    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
%>

