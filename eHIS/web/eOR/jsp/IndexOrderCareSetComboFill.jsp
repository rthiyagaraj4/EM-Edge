<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,eOR.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<%
	
	String bean_id = "indexordercareset" ;
	String comboObjectString = "";	

	IndexOrderCareSetBean beanObj = (IndexOrderCareSetBean)getBeanObject( bean_id.trim(),"eOR.IndexOrderCareSetBean",request);
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	String validate 		= request.getParameter("validate" ) ;
	String term_code 		= request.getParameter("term_code") ;

	try
	{
	  comboObjectString = beanObj.getComboBoxHtml();
	}catch(Exception e){%>
	<script>alert("Exception thrown ...in IndexOrderCareSetComboFill.jsp" + "<%=e.getMessage()%>");</script>
	<%
	e.printStackTrace();//COMMON-ICN-0181
	}
	
	if(validate.equalsIgnoreCase("TERMDESC"))
	{
		String termdesc="";
		termdesc=beanObj.getTermDesc(term_code);
		out.println( "termdesc(\"" + termdesc+ "\") ; " ) ;
	}else
	{
		String  type = (String)hash.get("type") ;	 
		if(type.trim().equalsIgnoreCase("OrderCategory"))
		{
			out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_category" + "\" ) ; ") ;
		}
	}

	
	putObjectInBean(bean_id,beanObj,request);
	
	%>


