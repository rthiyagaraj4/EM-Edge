<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
String reasonCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels")  ;
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")  ;
String  nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")  ;
String  both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String  enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label"
,"common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label"
,"common_labels");
String reasons =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Reasons.label","ae_labels");
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(reasonCode);     // label
firstItem.add("reason_code");   //name of field
firstItem.add("6"); // SIZE
firstItem.add("6"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");
secondItem.add(description);
secondItem.add("reason_desc");
secondItem.add("10");
secondItem.add("10");
finAr.add(secondItem);

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(nature);  // label
thirdItem.add("status");//name
thirdItem.add("B,"+both+",E,"+enabled+",D,"+disabled+"");//static values that need to be displayed as 
finAr.add(thirdItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] =reasonCode;
	orderByCols[1] =description;
	

	orderByColVals[0] = "reason_code";
	orderByColVals[1] = "reason_desc";
	


strbuff = qrypg.getQueryPage( con,finAr,reasons,"../../eOT/jsp/ReasonsQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

