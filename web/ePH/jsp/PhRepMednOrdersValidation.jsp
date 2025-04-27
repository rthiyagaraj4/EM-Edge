<%-- saved on 03/11/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try {

	request.setCharacterEncoding("UTF-8");//added for SKR-SCF-1006[IN048685]
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String facility_id			= (String) hash.get( "facility_id" );
	ArrayList	disp_locns		=	new ArrayList();
	String desc="";

	PhUncollDrugBean beanObj		= (PhUncollDrugBean)getBeanObject(bean_id,bean_name,request);

	disp_locns		=	beanObj.getDispLocationList(facility_id);
	
	
	out.println("clearList()");

	for(int i=0; i<disp_locns.size(); i+=2) {
		
		desc = (String)disp_locns.get(i+1);
		//desc=desc.replaceAll(" ","%20");
		//desc = java.net.URLEncoder.encode(desc);
		//desc=desc.replaceAll("%2520","%20");

	
		out.println("addList(\""+(String)disp_locns.get(i)+"\",\""+desc+"\");");
	} 
	 putObjectInBean(bean_id,beanObj,request);
	}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	}
%>
