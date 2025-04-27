<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=ISO-8859-1"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	String inventory_module_scope	="";
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemBean bean = (ItemBean) getBeanObject(bean_id,bean_name,request);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	try
	{
		HashMap hmValues = bean.getMMInstallationParameter();
		if(hmValues==null) return;
		inventory_module_scope =bean.checkForNull((String)hmValues.get("INVENTORY_MODULE_SCOPE"),"");
		result	=	true;
		message	=	inventory_module_scope;
	}
	catch ( Exception e1)
	{e1.printStackTrace();
	}
	finally{
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
//putObjectInBean(bean_id,bean,request);
%>
