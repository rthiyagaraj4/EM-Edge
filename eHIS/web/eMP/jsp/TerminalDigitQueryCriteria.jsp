<!DOCTYPE html>
 <%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%		
		request.setCharacterEncoding("UTF-8");
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
try
{
	con				= ConnectionManager.getConnection(request);
ArrayList finAr 	= new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("List");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Atthelevelof.label","mp_labels"));		//label
firstItem.add("term_digit_level");		//name of field
firstItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSection.label","common_labels"));// VALUES

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));  // label
secondItem.add("facility_id");   //name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem	 = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSectionCode.label","common_labels"));  // label
thirdItem.add("mr_section_code");//name
thirdItem.add("15");	// SIZE
thirdItem.add("15");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem	 = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSectionDesc.label","common_labels"));  // label
fourthItem.add("short_name");//name
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[] 	= new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] 	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1]		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSectionCode.label","common_labels");
orderByCols[2]		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSectionDesc.label","common_labels");

orderByColVals[0] 	 = "a.facility_id";
orderByColVals[1] 	 = "a.mr_section_code";
orderByColVals[2] 	 = "c.short_name";

strbuff 		= qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminalDigit.label","common_labels") ,"../../eMP/jsp/TerminalDigitQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}catch (Exception e)  {}
finally
	{
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
