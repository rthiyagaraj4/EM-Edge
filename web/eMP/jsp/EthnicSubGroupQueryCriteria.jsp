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

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EthnicityCode.label","mp_labels"));	  // label
firstItem.add("ETHNIC_GROUP_CODE");	//name of field
firstItem.add("10");	// SIZE
firstItem.add("10");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eMP.EthnicityDesc.label","mp_labels"));  // label
secondItem.add("LONG_DESC");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr  


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RaceCode.label","mp_labels"));	  // label
thirdItem.add("RACE_CODE");	//name of field
thirdItem.add("10");	// SIZE
thirdItem.add("10");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RaceDesc.label","mp_labels"));  // label
fourthItem.add("RACE_LONG_DESC");   //name of field
fourthItem.add("30");	// SIZE
fourthItem.add("30");	//LENGTH

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

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EthnicityCode.label","mp_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EthnicityDesc.label","mp_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RaceCode.label","mp_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RaceDesc.label","mp_labels");

orderByColVals[0] = "ETHNIC_GROUP_CODE";
orderByColVals[1] = "LONG_DESC";
orderByColVals[2] = "RACE_CODE";
orderByColVals[3] = "RACE_LONG_DESC";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EthnicSubGroup.label","mp_labels"),"../jsp/EthnicSubGroupQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) { 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174061309 on 05-09-2023
	}
finally{
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
