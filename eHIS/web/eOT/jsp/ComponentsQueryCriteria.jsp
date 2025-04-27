<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

String code =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels") ;

String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String description =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels") ;
String consumable=
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Consumable.label","common_labels") ;
String yes= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels") ;
String no= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels") ;
String all= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels") ; 
String item_code= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels") ; 
String item_desc= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels") ; 
StringBuffer strbuff;
String ph_module_yn = request.getParameter("ph_module_yn");
Connection con=null ;
try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("Text");           //Type of item
	firstItem.add(code);     // label
	firstItem.add("item_code");   //name of field
	firstItem.add("20"); // SIZE
	firstItem.add("20"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(description);    // label
	secondItem.add("item_desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr



	ArrayList thirdItem= new ArrayList();

	thirdItem.add("List");   //Type of item
	thirdItem.add(consumable);  // label
	thirdItem.add("consumable_yn");//name
	thirdItem.add("A,"+all+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
	finAr.add(thirdItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = item_code;
	orderByCols[1] = item_desc;
	

	orderByColVals[0] = "item_code";
	orderByColVals[1] = "item_desc";
	

	strbuff = qrypg.getQueryPage( con,finAr,"BookingPriority ","../../eOT/jsp/ComponentsQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder ,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
	out.println(strbuff.toString());
}catch (Exception e) {
	e.printStackTrace();
}finally{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">
</body>
</html>

