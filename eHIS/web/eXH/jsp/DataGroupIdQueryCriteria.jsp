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

firstItem.add("Text");          //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));     // label
firstItem.add("dg_code");   //name of field
firstItem.add("10"); // SIZE
firstItem.add("10"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr
ArrayList secondItem = new ArrayList();
secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));    // label
secondItem.add("dg_desc");  //name of field
secondItem.add("50");   // SIZE
secondItem.add("50");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
		
thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Standard.label","common_labels"));  // label
thirdItem.add("stnd_code");//name
thirdItem.add("50");//static values that need to be displayed as 
thirdItem.add("30");
finAr.add(thirdItem);

ArrayList fourthItem = new ArrayList();
		
fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","xh_labels"));  // label
fourthItem.add("appl_id");//name
fourthItem.add("50");//static values that need to be displayed as 
fourthItem.add("50");//static values that need to be displayed as 
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

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Standard.label","common_labels");
	orderByCols[3] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels"); 
			
	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";
	orderByColVals[3] = "4";
	
	
strbuff = qrypg.getQueryPage( con,finAr,"InterfaceAPI","../../eXH/jsp/DataGroupIdQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels")+"");
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
