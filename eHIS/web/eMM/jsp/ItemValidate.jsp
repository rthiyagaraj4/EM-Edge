<%@page import="java.util.*, eMM.Common.*, eMM.* ,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	//locale ="en";
//	String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
//	String validate					= request.getParameter("validate");
//	String message					= "";
//	String flag						= "";
//	boolean	result					= false;
//	boolean value					= false;
	if ((bean_id == null) || (bean_id.equals(""))) 
		return;
	ItemMasterBean bean = (ItemMasterBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);

    hash = (Hashtable) hash.get ("SEARCH");
	String remark = (String) hash.get("remark");
	try {
		bean.setSpecification( remark );	
		//		result	=	true;
//		message	=	"Done";
//		return;
	}
	catch ( Exception e1) {
//				result	=	false;
//				flag	=	"INVALID_ITEM_CODE";
				//message	=	exception.getMessage();
				System.err.println(e1);
				e1.printStackTrace();
			}
	finally{
	
	//	out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
