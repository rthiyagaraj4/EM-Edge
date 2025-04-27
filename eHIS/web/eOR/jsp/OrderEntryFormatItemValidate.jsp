<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%
try{
	request.setCharacterEncoding("UTF-8");
	
	String bean_id		=	"Or_OrderEntryFormatItems" ;
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	boolean flag			=   false ;
	boolean setFlag			=   false ;

	
	OrderEntryFormatItem bean = (OrderEntryFormatItem)getBeanObject(bean_id.trim(),"eOR.OrderEntryFormatItem",request) ;
	bean.setLanguageId((String)session.getAttribute("LOCALE")) ;
	String validate = bean.checkForNull(request.getParameter("validate"),"") ;


	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;

    hash = (Hashtable)hash.get( "SEARCH" );	
   if(validate.equals("SET_REF_CONTENT"))
	{
	     	bean.format_values.clear();
	}
	else if(validate.equals("Formatvalues"))
	{
				String key = bean.checkForNull(request.getParameter("key"),"") ;
				String value = bean.checkForNull(request.getParameter("value"),"") ;
						
				bean.setFormatListValues(key,value);
	}
	else if(validate.equals("TotalFormatvalues"))
	{
			try
			{
				int total_rows=Integer.parseInt(bean.checkForNull(bean.getFormatListValues("total_rows"),"0"));
				if(total_rows>0)
				{
					setFlag=true;
				}
			}catch(Exception e){%>
	<script>alert("Exception thrown at  ...Chk in OrderEntryFormatItemValidate.jsp"+"<%=e.getMessage()%>");</script>
<% e.printStackTrace();//COMMON-ICN-0181
	}
	out.println("syncFormatStatus(" + setFlag + ")");
	}
	else if(validate.equals("getFormatdesc"))
	{
		String key = bean.checkForNull(request.getParameter("key"),"") ;
		out.println("displayFormatdesc(\""+bean.getFormatListValues(key)+"\");");
	}
	else
	{
	try
	{
		flag			      = bean.formatListValues(hash);
	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in OrderEntryFormatItemValidate.jsp"+"<%=e.getMessage()%>");</script>

	<%}
		out.println("syncStatus(" + flag + ")");
	}
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	e.printStackTrace();
}

%>
