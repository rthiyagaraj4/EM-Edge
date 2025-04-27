
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=ISO-8859-1" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%

    Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String drug_code			= (String) hash.get( "drug_code" );
	ArrayList	Trade_name		=	new ArrayList();

	PhDispDrugBatchDetailsBean bean		= (PhDispDrugBatchDetailsBean)getBeanObject(bean_id,bean_name,request);
	
	out.println("clearList(); ");
				try
				{
					ArrayList ar_tradename = bean.getTradeName(bean.checkForNull(drug_code));


					if (ar_tradename!=null && ar_tradename.size()>0)
					{
						for(int i=0; i<ar_tradename.size(); i+=2) {
							out.println("addList('"+(String)ar_tradename.get(i)+"','"+(String)ar_tradename.get(i+1)+"');");
							} 



					}
					//return();
				}catch(Exception e)
				{
					e.printStackTrace();
				}

%>
