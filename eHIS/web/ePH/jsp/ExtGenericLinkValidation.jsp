  <%-- created on 23/12/2009  Shyampriya --%>
 <%@page  import=" java.util.*, ePH.Common.*, ePH.*, java.text.*" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try{

			request.setCharacterEncoding("UTF-8");	
			String locale			= (String)session.getAttribute("LOCALE");
			String bean_id			= request.getParameter( "bean_id" ) ;
			String bean_name	= request.getParameter( "bean_name" ) ;
			String func_mode		= request.getParameter( "func_mode" );
			
			
			Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
			 hash					= (Hashtable)hash.get( "SEARCH" ) ;
			 ExtGenericLinkBean bean	= (ExtGenericLinkBean)getBeanObject(bean_id,bean_name ,request) ;
			bean.setLanguageId(locale);
			if(func_mode != null && func_mode.equals("asso_ext_generic_id" ) ){
				String generic_id = (String) hash.get("generic_id");
				String product_id = (String) hash.get("product_id");
				String ext_generic_id = bean.getExtGenericID(generic_id, product_id);
				if(!(ext_generic_id.equals(""))){
					 out.println("showAlert('"+ext_generic_id+"','"+product_id+"');") ;
				}
			}
			putObjectInBean(bean_id,bean,request);
		}
		catch (Exception e){
			e.printStackTrace();
			out.println("alert('"+e.toString()+"');");
		}
%>
