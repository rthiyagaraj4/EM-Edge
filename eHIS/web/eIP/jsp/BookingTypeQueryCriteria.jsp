<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String function_id = request.getParameter("function_id");


StringBuffer strbuff;
Connection con					= null ;

ArrayList finAr					= new ArrayList();

ArrayList firstItem				= new ArrayList();
firstItem.add("Text");
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookingType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	
firstItem.add("booking_type_code");	
firstItem.add("3");	
firstItem.add("3");	
finAr.add(firstItem);

ArrayList secondItem			= new ArrayList();
secondItem.add("Text");  
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookingType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  
secondItem.add("booking_type_desc");  
secondItem.add("50");	
secondItem.add("50");	
finAr.add(secondItem);

ArrayList third_item			= new ArrayList();
third_item.add("List");  
third_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels"));  
third_item.add("indicator");   
third_item.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.IntraHospitalBooking.label","ip_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExternalHospitalBooking.label","ip_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels")+"");
finAr.add(third_item);

ArrayList forth_item			= new ArrayList();
forth_item.add("List");  
forth_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); 
forth_item.add("eff_status");  
forth_item.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
finAr.add(forth_item);

String orderByCols[]			= new String[2];
String orderByColVals[]			= new String[2];

orderByCols[0]					= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookingType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookingType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0]				= "booking_type_code";
orderByColVals[1]				= "long_desc";

strbuff							= qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookingType.label","ip_labels"),"../jsp/BookingTypeQueryResult.jsp?&function_id="+function_id+"",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
if ( finAr != null) finAr.clear();
if ( firstItem != null) firstItem.clear();
if ( secondItem != null) secondItem.clear();
if ( third_item != null) third_item.clear();
if ( forth_item != null) forth_item.clear();
%>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

