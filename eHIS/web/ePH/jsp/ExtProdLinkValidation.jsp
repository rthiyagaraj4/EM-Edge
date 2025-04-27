  <%-- created on 10/12/2009 --%>
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
			 ExtProdLinkBean bean	= (ExtProdLinkBean)getBeanObject(bean_id,bean_name ,request) ;
			bean.setLanguageId(locale);
			if(func_mode != null && func_mode.equals("asso_ext_drug_code" ) )
				{
					String drug_code = (String) hash.get("drug_code");
					String product_id = (String) hash.get("product_id");
					String ext_prod_drug_code = bean.getExtDrugCode(drug_code, product_id);
					  if(!(ext_prod_drug_code.equals("")))
						 {
							 out.println("showAlert('"+ext_prod_drug_code+"','"+product_id+"');") ;
						  }
				}

			putObjectInBean(bean_id,bean,request);
		}
		catch (Exception e){
			e.printStackTrace();
		}
%>
