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
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = "Or_CareSet" ;
	String comboObjectString = "";	
	String comboObjectString2 = "";	
	String iv_prep_ynVal = "";

	CareSetBean bean = (CareSetBean)getBeanObject(bean_id, "eOR.CareSetBean",request ) ;
	bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	
    hash = (Hashtable)hash.get( "SEARCH" );

	String type = (String)hash.get("type");
	String order_category = (String)hash.get("order_category");	
	iv_prep_ynVal = (String)hash.get("iv_prep_ynVal");
	String l_calledForm = (String)hash.get("calledForm");//IN062992

	if( iv_prep_ynVal==null || iv_prep_ynVal.equals("null"))
	{
	iv_prep_ynVal = "";
	}    
	
	HashMap freqRec = null ;
   	try
	{
	  if(type.trim().equalsIgnoreCase("OrderCategory") || type.trim().equalsIgnoreCase("OrderType") || type.trim().equalsIgnoreCase("iv_prep_yn") ){	  
	  bean.clearALL();//Bean is totally Cleared here --- note
	  comboObjectString = bean.getComboBoxHtml(hash);

	  comboObjectString2 = bean.getComboOptions(type,iv_prep_ynVal,order_category.trim());

	  } else if(type.trim().equalsIgnoreCase("freq_code")){
      
	  String freq_code = (String)hash.get("freq_code");
	  freqRec= bean.getFreqRec(freq_code)	;	
	  
	  }


	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in CareSetSectionFill.jsp" + "<%=e.getMessage()%>"+tempChk);</script>
	<%}%>
	 
	
	
<%if(type.trim().equalsIgnoreCase("OrderCategory")){
out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_category" + "\" ) ; ") ;}
else if(type.trim().equalsIgnoreCase("OrderType")){
out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_type_code" + "\" ) ; ") ;}
else if(type.trim().equalsIgnoreCase("iv_prep_yn")){
out.println("addComboObject(\"" + comboObjectString2 + "\",\"" + "iv_prep_yn" + "\" ) ; ") ;
}
if(type.trim().equalsIgnoreCase("freq_code")){
//out.println("addDurnObject(\"" + (String)freqRec.get("durn_type") + "\",\"" + (String)freqRec.get("durn_value") +  "\",\"" + (String)freqRec.get("durn_desc") +"\",\"" + (String)hash.get("index")+ "\" ) ; ");}//IN062992
out.println("addDurnObject(\"" + (String)freqRec.get("durn_type") + "\",\"" + (String)freqRec.get("durn_value") +  "\",\"" + (String)freqRec.get("durn_desc") +"\",\"" + (String)hash.get("index")+ "\", \"" + l_calledForm + "\") ; ");}//IN062992
 putObjectInBean(bean_id,bean,request);
%>
