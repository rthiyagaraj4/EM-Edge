<!DOCTYPE html>
<%--
/**
  *
  * @filename TownQueryPage.jsp
  * @version 3.0 updated on 2/19/2005
  */
 --%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {
	con = ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TownCode.label","common_labels"));	  // label
	firstItem.add("res_town_code");	//name of field
	firstItem.add("6");	// SIZE
	firstItem.add("6");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.TownDesc.label","mp_labels"));  // label
	secondItem.add("a.long_desc");   //name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AreaCode.label","common_labels"));  // label
	thirdItem.add("a.res_area_code");   //name of field
	thirdItem.add("6");	// SIZE
	thirdItem.add("6");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem=new ArrayList();

	fourthItem.add("Text");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AreaDesc.label","mp_labels"));  // label
	fourthItem.add("area_long_desc");   //name of field
	fourthItem.add("15");	// SIZE
	fourthItem.add("15");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();

	fifthItem.add("List");  //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifthItem.add("nature");   //name of field
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	fifthItem.add("4");	//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TownCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.TownDesc.label","mp_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AreaCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AreaDesc.label","mp_labels");

	orderByColVals[0] = "res_town_code";
	orderByColVals[1] = "a.long_desc";
	orderByColVals[2] = "a.res_area_code";
	orderByColVals[3] = "area_short_desc";//modified for the incident 40320

	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ResidenceTown.label","mp_labels"),"../jsp/queryTown.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

}catch (Exception e) { 
	// out.println(e.toString());
	e.printStackTrace();
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
