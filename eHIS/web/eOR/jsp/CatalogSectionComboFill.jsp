
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"   %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");

	String bean_id = request.getParameter("bean_id") ;
	String comboObjectString = "";	

	CatalogsBySection CatalogBean = (CatalogsBySection)getBeanObject( bean_id.trim(),"eOR.CatalogsBySection",request) ;

	CatalogBean.clearAll();
	
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	try
	{
		
	  comboObjectString = CatalogBean.getComboBoxHtml(hash);
	  System.out.println("comboObjectString"+comboObjectString);
	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in CataLogSectionFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>
	 
	
	
<%String  type = (String)hash.get("type") ;%>	 

<%if(type.trim().equalsIgnoreCase("OrderCategory")){
out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_category" + "\" ) ; ") ;}%>
	

<%
	if(type.trim().equalsIgnoreCase("tickSheet"))
	{
//out.println("addComboObject(\"" + comboObjectString + "\",\"" + "tick_sheet" + "\" ) ; ");
		ArrayList SectionData = CatalogBean.getSectionDetails(hash);
		String ts_fpp_yn = CatalogBean.getFPPYNTickSheet(hash);//IN072524
		for( int i=0 ; i< SectionData.size() ; i++ ) 
		{
			String[] record = (String[])SectionData.get(i);		
%>

		var element = f_query_add_mod.f_query_add_mod_header.document.createElement('OPTION');
		element.value="<%=record[0]%>";
		element.text = "<%=record[1]%>";
		f_query_add_mod.f_query_add_mod_header.document.forms[0].section.add(element);
		//IN072524 Starts 
		<%if("Y".equals(ts_fpp_yn)){ %>
		
		f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn.value="<%=ts_fpp_yn %>";
		f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn.checked = "checked";
		f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn.disabled = "true";
		<%}else {%>
		if(null!=f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn && undefined!=f_query_add_modf_query_add_mod_header.document.forms[0].fpp_yn){
		f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn.value="<%=ts_fpp_yn %>";
		f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn.checked = "";
		f_query_add_mod.f_query_add_mod_header.document.forms[0].fpp_yn.disabled = "true";
		}
		

		<% }%>
		//IN072524 Ends
	<%
	}
}
	

putObjectInBean(bean_id.trim(),CatalogBean,request);
 
%>
