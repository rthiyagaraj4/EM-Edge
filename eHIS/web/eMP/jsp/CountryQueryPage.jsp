<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
//	con = (Connection) session.getValue( "connection" );
	con = ConnectionManager.getConnection(request);
	
	Boolean isTelephone_code  = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 -->



ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CountryCode.label","mp_labels"));	  // label
firstItem.add("country_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CountryName.label","mp_labels"));  // label
secondItem.add("long_name");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Citizenship.label","common_labels"));  // label
thirdItem.add("long_desc");//name
thirdItem.add("30");	// SIZE
thirdItem.add("30");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem=new ArrayList();

fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("nature");   //name of field
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
fourthItem.add("4");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr


if(isTelephone_code)
{
ArrayList fifthItem=new ArrayList();
fifthItem.add("Text");
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.telephonecode.label","common_labels")); 
fifthItem.add("telephone_country_code");
fifthItem.add("10");
fifthItem.add("10");	
finAr.add(fifthItem); 
}

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CountryCode.label","mp_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CountryName.label","mp_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Citizenship.label","common_labels");

orderByColVals[0] = "country_code";
orderByColVals[1] = "long_name";
orderByColVals[2] = "long_desc";


strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.country.label","common_labels"),"../jsp/queryCountry.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) { 
	//out.println(e.toString());
	e.printStackTrace();
}
finally { 
	ConnectionManager.returnConnection(con,request);
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
