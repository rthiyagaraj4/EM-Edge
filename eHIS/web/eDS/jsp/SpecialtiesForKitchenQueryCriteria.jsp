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
String facility_id	= (String)session.getAttribute("facility_id");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage(); 	
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String kitchenCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Kitchen.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String specialityCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels") ;
StringBuffer strbuff;
Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("List");
	firstItem.add(kitchenCode);
	firstItem.add("kitchen_Code");
	pstmt = con.prepareStatement(DlQuery.DL_WARDS_KITCHEN_CODE);
	pstmt.setString(1, locale);
	pstmt.setString(2, facility_id);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("kitchen_code")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str2);
	finAr.add(firstItem);
	strBuff.setLength(0);
	ArrayList secondItem = new ArrayList();
	secondItem.add("List");
	secondItem.add(specialityCode);
	secondItem.add("speciality_Code");
	pstmt = con.prepareStatement(DlQuery.DS_SPECIALITIES);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("speciality_code")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str3);
	finAr.add(secondItem);
	strBuff.setLength(0);
	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = kitchenCode;
	orderByCols[1] = specialityCode;

	orderByColVals[0] = "kitchen_code";
	orderByColVals[1] = "speciality_code";
	
	strbuff = qrypg.getQueryPage( con,finAr,"Menu Time Table ","../../eDS/jsp/SpecialtiesForKitchenQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
}catch (Exception e){
	System.err.println("Exception in SpecForKitchen ->"+e);
	e.printStackTrace();
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

