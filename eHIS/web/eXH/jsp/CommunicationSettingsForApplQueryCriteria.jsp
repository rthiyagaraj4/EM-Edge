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
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Application.Label","xh_labels"));     // label
firstItem.add("appl");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("50"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Facility.Label","xh_labels"));    // label
secondItem.add("facility");  //name of field
secondItem.add("20");   // SIZE
secondItem.add("50");   //LENGTH
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

	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Application.Label","xh_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Facility.Label","xh_labels");
   

	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	
	


strbuff = qrypg.getQueryPage( con,finAr,"Application_Communication","../../eXH/jsp/CommunicationSettingsForApplicationQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.QueryCriteria.Label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Select.Label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ExecuteQuery.Label","xh_labels")+"");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
finAr.clear();
} catch (Exception e) {}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
