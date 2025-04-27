<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,eBL.BLScreenServiceBean"  contentType="text/html;charset=UTF-8" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 


<%
 	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
 response.setHeader("Pragma","no-cache"); //HTTP 1.0    
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
 String beanId = "BLScreenServiceBean";
 String beanName = "eBL.BLScreenServiceBean";
 ArrayList modalList = null;
 String rowCountStr	="";
 int rowCount=0;
 BLScreenServiceBean bLScreenServiceBean 	=  (BLScreenServiceBean)getBeanObject(beanId, beanName, request);
 try
 {
 	modalList	= new ArrayList();
 	String locale = (String) session.getAttribute("LOCALE");
 	Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
 	hash = (Hashtable) hash.get("SEARCH");
 	System.out.println(" hash@@@@@ .... Inside BillingSaveScreeningServiceApplicableCriteria.jsp:::: "+hash);
 	rowCountStr = 	(String) hash.get("rowCount");
 	rowCount = Integer.parseInt(rowCountStr);
 	System.out.println(" rowCount .... Inside BillingSaveScreeningServiceApplicableCriteria.jsp:::: "+rowCount);   
 	for(int i = 0; i < rowCount-1; i++) 
 	{
 	String chk= (String)hash.get("chk"+i);
 	System.out.println(" chk .... Inside BillingSaveScreeningServiceApplicableCriteria.jsp:::: "+chk);  
 		if(chk!=null && chk.equalsIgnoreCase("Y"))	
 		{
 	modalList.add((String)hash.get("criteria"+i));
 		}
 	}	
 	bLScreenServiceBean.setSaveIdValueList(modalList);
 	putObjectInBean(beanId, bLScreenServiceBean, request);
 	
 	for(int i=0;i<modalList.size();i++)
 	{
 		System.out.println(" iDVALUE .... Inside BillingSaveScreeningServiceApplicableCriteria.jsp:::: "+modalList.get(i));
 	}
 }
 catch(Exception e)
 {
 	System.out.println("EXCEPTION IN BillingSaveScreeningServiceApplicableCriteria.jsp.jsp::::: "+e);     
 }
 %>

<%!private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}%>
