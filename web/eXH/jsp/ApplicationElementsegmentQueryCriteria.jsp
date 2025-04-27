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

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ConfigType.Label","xh_labels"));    // label
firstItem.add("config_type");//name
firstItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"--,S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Segment.Label","xh_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Field.label","common_labels")+"");//static values that need to be displayed as 
firstItem.add(",");//static values that need to be displayed as 
finAr.add(firstItem);

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ConfigName.Label","xh_labels"));    // label
secondItem.add("config_name");  //name of field
secondItem.add("20");   // SIZE
secondItem.add("50");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.SysDefStr.Label","xh_labels"));    // label
thirdItem.add("sysdef_str");  //name of field
thirdItem.add("20");   // SIZE
thirdItem.add("50");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Hidden");   //Type of item
fourthItem.add("locale");  // label
fourthItem.add(locale);//name
fourthItem.add(locale);//static values that need to be displayed as 
finAr.add(fourthItem);


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ConfigType.Label","xh_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ConfigName.Label","xh_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.SysDefStr.Label","xh_labels");

	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";


strbuff = qrypg.getQueryPage( con,finAr,"Application_Communication","../../eXH/jsp/ApplicationElementQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels")+"");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();

finAr.clear();
} catch (Exception e) {}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
