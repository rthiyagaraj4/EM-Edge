<!DOCTYPE html>
<HTML>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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

firstItem.add("Text");          //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","xh_labels"));    // label
firstItem.add("api_code");  //name of field
firstItem.add("30");   // SIZE
firstItem.add("30");   //LENGTH
finAr.add(firstItem);    //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","xh_labels"));    // label
secondItem.add("api_desc");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
		
thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.APIType.Label","xh_labels"));  // label
thirdItem.add("api_type");//name
thirdItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"--,D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.CommDataIOAPI.Label","xh_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.CommStatisticsAPI.Label","xh_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.FileNamingAPI.Label","xh_labels")+"");//static values that need to be displayed as 
thirdItem.add(",");//static values that need to be displayed as 
finAr.add(thirdItem);


ArrayList fourthItem = new ArrayList();
		
fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ExecNature.Label","xh_labels"));  // label
fourthItem.add("exec_nature");//name
fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"--,A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.APIBased.Label","xh_labels")+",Q,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.QueryBased.Label","xh_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.TableBased.Label","xh_labels")+"");//static values that need to be displayed as 
fourthItem.add(",");//static values that need to be displayed as 
finAr.add(fourthItem);

ArrayList fiftthItem = new ArrayList();

fiftthItem.add("Hidden");   //Type of item
fiftthItem.add("locale");  // label
fiftthItem.add(locale);//name
fiftthItem.add(locale);//static values that need to be displayed as 
finAr.add(fiftthItem);


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","xh_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","xh_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.APIType.Label","xh_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ExecNature.Label","xh_labels");
			
	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";
	orderByColVals[3] = "4";
	
strbuff = qrypg.getQueryPage( con,finAr,"InterfaceAPI","../../eXH/jsp/InterfaceAPIQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels")+"");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fiftthItem.clear();
finAr.clear();
} catch (Exception e) {}

finally
{
   if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
