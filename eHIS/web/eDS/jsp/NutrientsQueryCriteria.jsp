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
String nutrients =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.NutrientCode.Label","ot_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
String uom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Uom.Label","ot_labels") ;
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
	firstItem.add(nutrients);
	firstItem.add("nutrients");
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
	fourthItem.add(uom);  // label
	fourthItem.add("uom");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("uom_code")+","+rst.getString("short_desc"));
	}
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str1);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);
	pstmt = null;
	rst = null;

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(nature);  // label
	fifthItem.add("enabled_Yn");//name
	fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(fifthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0] = nutrients;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
	orderByCols[3] = uom;
    orderByCols[4] = nature;

	orderByColVals[0] = "nutrients_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "uom_code";
	orderByColVals[4] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/NutrientsQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{   //Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

