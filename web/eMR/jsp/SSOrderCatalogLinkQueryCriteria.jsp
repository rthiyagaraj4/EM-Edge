<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey()'>

<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem1=new ArrayList();

firstItem1.add("List");  //Type of item
firstItem1.add("Report");  // label
firstItem1.add("Report");   //name of field
firstItem1.add("select report_id,report_desc from sm_report where report_id in ('MRBRADEX','MRBLABWL','MRBLABRG') order by report_desc");
//firstItem1.add("MRBRADEX,PER SS-RA 201");//static values that need to be 

finAr.add(firstItem1);

ArrayList secondItem=new ArrayList();

secondItem.add("List");  //Type of item
secondItem.add("Master");  // label
secondItem.add("Master");
secondItem.add("OC,Order Catalog");
//name of field
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add("Main Group");  // label
fourthItem.add("main_group");   //name of field
fourthItem.add("20");	// SIZE
fourthItem.add("20");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();

fifthItem.add("Text");  //Type of item
fifthItem.add("Sub Group");  // label
fifthItem.add("sub_group");   //name of field
fifthItem.add("20");	// SIZE
fifthItem.add("20");	//LENGTH

finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();

sixthItem.add("Text");  //Type of item
sixthItem.add("Catalog Dsc");  // label
sixthItem.add("catalog_desc");   //name of field
sixthItem.add("20");	// SIZE
sixthItem.add("20");	//LENGTH

finAr.add(sixthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = "Report";
orderByCols[1] = "Master";
orderByCols[2] = "Main Group";
orderByCols[3] = "Sub Group";
orderByCols[4] = "Catalog Dsc";

orderByColVals[0] = "REPORT_DESC";
orderByColVals[1] = "MAST_TABLE_NAME_REFERENCE";
orderByColVals[2] = "GROUP_DESC";
orderByColVals[3] = "SUB_GROUP_DESC";
orderByColVals[4] = "MAST_DESC";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllergyType.label","common_labels"),"../../eMR/jsp/SSOrderCatalogLinkQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
}
catch (Exception e) { /* out.println(e); */ e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>
