<%@page  import="java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
	String validate = request.getParameter("validate");
	Hashtable hshtable	= (Hashtable)xmlObj.parseXMLString( request ) ;
	hshtable			= (Hashtable)hshtable.get( "SEARCH" ) ;
	String bean_id		= (String) hshtable.get( "bean_id" );
	String bean_name	= (String) hshtable.get( "bean_name" );
	PrescribingUomDecimalBean bean = (PrescribingUomDecimalBean) getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	try {		
		if(validate.equals("SETLONGDESC"))
		{
			String frmObj = (String)hshtable.get("frmObj");
			String code = ((String)hshtable.get("UOM_CODE"));
			String index = ((String)hshtable.get("index"));
			String langid = ((String)hshtable.get("LANG_ID"));
			String strLongdesc = bean.getLongDesc_UOMCode(code,langid);
			strLongdesc=strLongdesc.replaceAll(" ","%20");
			strLongdesc= java.net.URLEncoder.encode(strLongdesc,"UTF-8" );
			strLongdesc=strLongdesc.replaceAll("%2520","%20");
			out.println("document."+frmObj+".LongDesc_"+index+".value=decodeURIComponent('"+strLongdesc+"');");
		}
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
	putObjectInBean(bean_id,bean,request);
%>
