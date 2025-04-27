
 <%@page import="java.util.*, ePH.Common.*, ePH.*,eST.*,java.text.DecimalFormat " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String identity		  = request.getParameter( "identity" );
	String bean_id		  = request.getParameter( "bean_id" ) ;
	String bean_name	  = request.getParameter( "bean_name" ) ; 
	String store_code	  = "";
	boolean	result		  =	false;
	String message		  =	"";
	String flag			  =	"";


	Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				  = (Hashtable)hash.get( "SEARCH" ) ;

	PharmacistHomeBean bean = (PharmacistHomeBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(locale);
	try {
		if (identity.equals("setStore")){
			store_code = (String) hash.get("store_code");
			bean.setStore_code(store_code);	
			result = true;
			}	
	}
	catch(Exception e){
		result		=	false;
		e.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	putObjectInBean(bean_id,bean,request);
%>
