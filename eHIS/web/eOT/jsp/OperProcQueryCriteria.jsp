<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection,eCommon.Common.*, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");;%>
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
String longDesc =longdescription;//com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LongDesc.label","or_labels");
String shortDesc =shortdescription;//com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ShortDesc.label","or_labels");
//String equipmentCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.EquipmentCode.Label","ot_labels");
//String equipments =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Equipments.Label","ot_labels");
String operationsProcedures =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
String catalogCrossReference =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CatalogCrossReference.label","common_labels");
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String operationCode =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationCode.Label","ot_labels");
String operationType =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationType.Label","ot_labels");
String status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");

StringBuffer strbuff;

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
ArrayList secondItem = new ArrayList();
ArrayList thirdItem = new ArrayList();
ArrayList fourthtem = new ArrayList();
ArrayList fifthitem = new ArrayList();
ArrayList sixthitem = new ArrayList();
ArrayList ninthItem = new ArrayList();



Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
		
firstItem.add("Text");           //Type of item
firstItem.add(operationCode);     // label
firstItem.add("oper_code");   //name of field
firstItem.add("10"); // SIZE
firstItem.add("10"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr



secondItem.add("Text");          //Type of item
secondItem.add(longdescription);    // label
secondItem.add("long_desc");  //name of field
secondItem.add("60");   // SIZE
secondItem.add("60");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr



thirdItem.add("Text");          //Type of item
thirdItem.add(shortdescription);    // label
thirdItem.add("short_desc");  //name of field
thirdItem.add("40");   // SIZE Modified Against ML-MMOH-CRF-0432
thirdItem.add("40");   //LENGTH Modified Against ML-MMOH-CRF-0432
finAr.add(thirdItem);    //add to ArrayList obj finAr



fourthtem.add("Text");          //Type of item
fourthtem.add(operationType);    // label
fourthtem.add("oper_type_code");  //name of field
fourthtem.add("4");   // SIZE
fourthtem.add("4");   //LENGTH
finAr.add(fourthtem);    //add to ArrayList obj finAr




fifthitem.add("Text");          //Type of item
fifthitem.add(catalogCrossReference);    // label
fifthitem.add("order_catalog_code");  //name of field
fifthitem.add("20");   // SIZE
fifthitem.add("20");   //LENGTH
finAr.add(fifthitem);    //add to ArrayList obj finAr



sixthitem.add("Text");          //Type of item
sixthitem.add(speciality);    // label
sixthitem.add("speciality_code");  //name of field
sixthitem.add("4");   // SIZE
sixthitem.add("4");   //LENGTH
finAr.add(sixthitem);    //add to ArrayList obj finAr

				


ninthItem.add("List");   //Type of item
ninthItem.add(nature);  // label
ninthItem.add("status");//name
ninthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
finAr.add(ninthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = operationCode;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
	orderByCols[3] = status;

	orderByColVals[0] = "oper_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "status";


strbuff = qrypg.getQueryPage( con,finAr,operationsProcedures,"../../eOT/jsp/OperProcQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthtem.clear();
	fifthitem.clear();
	sixthitem.clear();
	ninthItem.clear();

    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

