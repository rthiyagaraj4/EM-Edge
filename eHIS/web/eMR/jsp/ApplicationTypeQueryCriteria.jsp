<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con=ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicationType.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
firstItem.add("APPL_TYPE_CODE");	//name of field
firstItem.add("6");	// SIZE
firstItem.add("6");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicationType.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("nature");   //name of field
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicationType.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicationType.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "APPL_TYPE_CODE";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HighRisk.label","labelmon_labels"),"../jsp/ApplicationTypeQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( finAr != null )  finAr.clear();

} catch (Exception e) {
	//out.println("Exception @ ApplicationTypeQueryCriteria.jsp "+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

%>
