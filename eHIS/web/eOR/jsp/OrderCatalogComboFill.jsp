<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>


<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = "Or_OrderCatalog" ;
	String comboObjectString = "";	

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, "eOR.OrderCatalogBean",request ) ;


	
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	String type = (String)hash.get("type");
	HashMap freqRec = null ;

	try
	{
		
	  if(type.trim().equalsIgnoreCase("OrderCategory")){
	  
	  bean.clearALL();//Bean is totally Cleared here --- note
	  comboObjectString = bean.getComboBoxHtml(hash);

	  } else if(type.trim().equalsIgnoreCase("HotSpot")){
	  
	  bean.clearALL();//Bean is totally Cleared here --- note
	  comboObjectString = bean.getComboBoxHtml(hash);

	  } else if(type.trim().equalsIgnoreCase("OrderType")){
	  
	  bean.clearALL();//Bean is totally Cleared here --- note
	  comboObjectString = bean.getComboBoxHtml(hash);

		

	  }else if(type.trim().equalsIgnoreCase("freq_code")){
      
	  String freq_code = (String)hash.get("freq_code");
	  freqRec= bean.getFreqRec(freq_code)	;
	  
	  }
	  


	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in CataLogSectionFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>
	 
	
	
<%if(type.trim().equalsIgnoreCase("OrderCategory"))
{
	out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_category" + "\" ) ; ") ;
}else if(type.trim().equalsIgnoreCase("HotSpot"))
{
	out.println("addComboObject(\"" + comboObjectString + "\",\"" + "HotSpot" + "\" ) ; ") ;
}else if(type.trim().equalsIgnoreCase("OrderType"))
{
	out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_type_code" + "\" ) ; ") ;
}
else if(type.trim().equalsIgnoreCase("freq_code"))
{
	out.println("addDurnObject(\"" + (String)freqRec.get("durn_type") + "\",\"" + (String)freqRec.get("durn_value") +  "\",\"" + (String)freqRec.get("durn_desc") +"\",\"" + (String)hash.get("index")+ "\" ) ; ");
}
else if(type.trim().equalsIgnoreCase("consent_count"))
{
	String order_catalog_code = (String)hash.get("order_catalog_code");
	String obj_name = (String)hash.get("obj_name");
	String obj_value = (String)hash.get("obj_value");
	int ConsentNum = bean.getConsentNumData(order_catalog_code,obj_name,obj_value);
	if(ConsentNum!=0)
	{
		out.println("ConsentNum(\"" + String.valueOf(ConsentNum)+ "\",\"" +obj_name+  "\") ; ");
	}
}


 putObjectInBean(bean_id,bean,request);
 %>
	
