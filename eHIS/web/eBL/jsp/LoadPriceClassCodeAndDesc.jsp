<!DOCTYPE html>
<%@ page    import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eBL.resources.*,  eCommon.Common.*,eBL.BillingPrevilageCardPatientBean,eBL.BillingPrevilageCardMemberBean ,eBL.BillingPrevilageCardVisiiUtilizationBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
String bean_id																				=	"";
String bean_name																			=	"";
String Str																					=	"!";
String hiddenCardTypeCode																	=	"";
ArrayList<String[]> priceClassCodeAndDescList												= 	null;
String locale																				=	"";
try
{
	priceClassCodeAndDescList																=	new ArrayList();
	locale 																					= 	(String)session.getAttribute("LOCALE");
	hiddenCardTypeCode																		=	checkForNull(request.getParameter("cardTypeCode")); 
	System.out.println("hiddenCardTypeCode in LoadPriceClassCodeAndDesc.jsp::: "+hiddenCardTypeCode);
	bean_id																					= 	"BillingPrevilageCardPatientBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardPatientBean";
	BillingPrevilageCardPatientBean billingPrevilageCardPatientBean							= 	(BillingPrevilageCardPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	priceClassCodeAndDescList = billingPrevilageCardPatientBean.LoadPriceClassCodeAndDesc(hiddenCardTypeCode, locale);
	for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
	{
		Str=Str+priceClassCodeAndDescList.get(priceListIndex)[0]+" - "+priceClassCodeAndDescList.get(priceListIndex)[1]+"~";
	}
	
 	out.println(Str);
 	System.out.println("RESPONSE in LoadPriceClassCodeAndDesc.jsp::: "+Str);
	putObjectInBean(bean_id, billingPrevilageCardPatientBean, request);
}
catch(Exception e)
{
	System.out.println("EXCEPTION IN LoadPriceClassCodeAndDesc.jsp::::: "+e);
}

%>

<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
