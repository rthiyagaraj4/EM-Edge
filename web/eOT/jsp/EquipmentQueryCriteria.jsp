<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.util.ArrayList,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();


String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
//String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
//String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LongDesc.label","or_labels");
//String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ShortDesc.label","or_labels");
String longdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String shortdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
String longDesc =longdescription;
String shortDesc =shortdescription;
String equipmentCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.EquipmentCode.Label","ot_labels");
String equipments =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Equipments.Label","ot_labels");


StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(equipmentCode);     // label
firstItem.add("equipment_code");   //name of field
firstItem.add("25"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(longdescription);    // label
secondItem.add("long_desc");  //name of field
secondItem.add("40");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(shortdescription);    // label
thirdItem.add("short_desc");  //name of field
thirdItem.add("20");   // SIZE
thirdItem.add("15");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr



ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(nature);  // label
fourthItem.add("status");//name
fourthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
finAr.add(fourthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = equipmentCode;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
   

	orderByColVals[0] = "equipment_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	


strbuff = qrypg.getQueryPage( con,finAr,equipments,"../../eOT/jsp/EquipmentQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

