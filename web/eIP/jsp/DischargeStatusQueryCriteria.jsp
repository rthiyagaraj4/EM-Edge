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

StringBuffer strbuff;
Connection con=null ;

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	
firstItem.add("discharge_status_code");	
firstItem.add("2");	
firstItem.add("2");	
finAr.add(firstItem);

ArrayList secondItem=new ArrayList();
secondItem.add("Text");  
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  
secondItem.add("discharge_status_desc");  
secondItem.add("30");	
secondItem.add("30");	
finAr.add(secondItem);

ArrayList third_item=new ArrayList();
third_item.add("List");  
third_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels"));  
third_item.add("indicator");   
third_item.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CompleteRecovery.label","ip_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PartialRecovery.label","ip_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.StatusQuo.label","ip_labels")+",W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConditionWorse.label","ip_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels")+"");
finAr.add(third_item);

ArrayList forth_item=new ArrayList();
forth_item.add("List");  
forth_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); 
forth_item.add("eff_status");  
forth_item.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
finAr.add(forth_item);

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "discharge_status_code";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels"),"../jsp/DischargeStatusQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
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

