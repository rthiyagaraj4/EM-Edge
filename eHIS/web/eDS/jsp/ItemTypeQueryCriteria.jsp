<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@  page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<%
String locale = (String)session.getAttribute("LOCALE");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String itemType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemType.Label","ot_labels") ;
String dietCategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApplDietCategory.Label","ot_labels") ;
String comFormula =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CommercialFormula.Label","ot_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
StringBuffer strbuff;
StringBuffer strBuff = new StringBuffer();
Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");
	firstItem.add(itemType);
	firstItem.add("item_Type");
	firstItem.add("4");
	firstItem.add("4");
	finAr.add(firstItem);

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("long_Desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortDesc);    // label
	thirdItem.add("short_Desc");  //name of field
	thirdItem.add("15");   // SIZE
	thirdItem.add("15");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(dietCategory);  // label
	fourthItem.add("diet_Category");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_CATEGORY);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("description"));
	}
	String str4 = "";
	str4 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str4);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);
	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(comFormula);  // label
	fifthItem.add("com_Formula");//name
	fifthItem.add("B,"+both+",Y,"+"Yes"+",N,"+"No");//static values that need to be displayed as
	finAr.add(fifthItem);


	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(nature);  // label
	sixthItem.add("enabled_Yn");//name
	sixthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(sixthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[6];
	orderByColVals = new String[6];

	orderByCols[0] = itemType;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
    orderByCols[3] = dietCategory;
    orderByCols[4] = comFormula;
    orderByCols[5] = nature;

	orderByColVals[0] = "item_type";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "appl_diet_category";
	orderByColVals[4] = "comm_formula_yn";
	orderByColVals[5] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/ItemTypeQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{
//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

