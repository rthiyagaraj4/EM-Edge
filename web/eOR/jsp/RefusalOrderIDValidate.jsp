<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName=request.getParameter("localeName");

int i;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,"eOR.RefusalOrdersBean" ,request ) ;
		beanObj.setLanguageId(localeName);

	if ( validate == null || validate.equals( "" ) )
		return ;
	if ( validate.equals( "ord_id_res" ) ) {
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if(hash.size()>0)
		{
		String orderid[]=new String[hash.size()];
		for(i=0;i<hash.size();i++)
				{
				    orderid[i] = (String)hash.get("s_"+i) ;
				}
				beanObj.setRefusalOrderID(orderid);
		}
	}
	else if(validate.equals("ord_id_clear"))
	{
		//RefusalOrdersBean beanObj = (RefusalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.RefusalOrdersBean") ;
				beanObj.clearBean();
	}
	putObjectInBean(bean_id,beanObj,request);
%>
