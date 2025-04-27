 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.io.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");


try
{
	String bean_id="";
	String validate ="";
		 bean_id = request.getParameter( "bean_id" ) ;
	 validate = request.getParameter( "validate" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	 DrugInformationSourceBean bean = (DrugInformationSourceBean)getBeanObject( bean_id, "ePH.DrugInformationSourceBean", request ) ;
	 bean.setLanguageId(locale);
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	if ( validate.equals( "code" ) ) {
				 if(hash.containsKey("code")){
				String info_cat_code	= (String)hash.get("code") ;
				String seq_no			= (String)hash.get("seq_no") ;
				String[] record = null;
				
				record = bean.checkForDuplicate(info_cat_code, seq_no)  ;
				out.println("code_val='"+record[0]+"'");
				out.println("seq_val='"+record[1]+"'");
		
		}
}
	putObjectInBean(bean_id,bean,request);

}catch(Exception e ) { out.println(e.toString()) ; }
	

%>
