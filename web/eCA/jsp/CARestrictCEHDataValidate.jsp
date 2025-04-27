
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
String bean_id			= "@CARestrictCEHDataBean";
String bean_name		= "eCA.CARestrictCEHDataBean";
CARestrictCEHDataBean bean	= (CARestrictCEHDataBean)getObjectFromBean( bean_id, bean_name , session); 

Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
hash						= (Hashtable)hash.get( "SEARCH" ) ;
Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");
try{
	HashMap<String,String> restrictData = bean.getRestrictData();
	String Mode = (String)hash.get("Mode");
	 if("SELECTALL".equals(Mode))
	{
		String restrictId=(String)hash.get("resId");
		String restrictType=(String)hash.get("resType");
		String restrictHistyType=(String)hash.get("hisType");
		String selectall=(String)hash.get("selectall");
		bean.restrictDataSelectAll(restrictId,restrictType,restrictHistyType,locale,selectall);
		
		out.print("SUCCESS");
		
	}
	else if("UPDATERESTRICTDATA".equals(Mode)){
		String ObjectKey	= (String)hash.get("ObjectKey");
		String ObjectValue	= (String)hash.get("ObjectValue");	
		if("Y".equals(ObjectValue))
			restrictData.put(ObjectKey,ObjectValue);		
		else if("N".equals(ObjectValue))
			restrictData.remove(ObjectKey);
		
		out.print("SUCCESS");
	}else if("GETRESTRICTDATA".equals(Mode)){
		out.print(restrictData);
	}
	
}catch (Exception e) {
	out.print("FAIL");
	e.printStackTrace();
}
putObjectInBean(bean_id,bean,session);

%>
