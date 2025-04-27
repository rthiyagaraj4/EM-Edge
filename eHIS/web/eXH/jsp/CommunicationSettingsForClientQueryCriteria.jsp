<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>

<%						  
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {

con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Client.Label","xh_labels"));     // label
firstItem.add("client");   //name of field
firstItem.add("15"); // SIZE
firstItem.add("15"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("List");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.CommunicationType.Label","xh_labels"));  // label
secondItem.add("comm_type");//name
secondItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Inbound.Label","xh_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Outbound.Label","xh_labels")+"");//static values that need to be displayed as 
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Hidden");   //Type of item
thirdItem.add("locale");  // label
thirdItem.add(locale);//name
thirdItem.add(locale);//static values that need to be displayed as 
finAr.add(thirdItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Client.Label","xh_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.CommunicationType.Label","xh_labels");
   

	orderByColVals[0] = "2";
	orderByColVals[1] = "3";
	
	


strbuff = qrypg.getQueryPage( con,finAr,"Client_Communication","../../eXH/jsp/CommunicationSettingsForClientQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")+"");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
finAr.clear();
} catch (Exception e) {
System.out.println("Exception in CommunicationSettingsForClientQueryCriteria.jsp:"+e);
}
finally
{
 	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

</HTML>
