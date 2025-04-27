<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
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
String locale = (String)session.getAttribute("LOCALE");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ; 
String instrument_code =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.InstrumentCode.Label","ot_labels") ;
String cross_ref_ssgroup =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CrossRefSSGroup.Label","ot_labels") ;
String longdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String shortdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("Text");           //Type of item
	firstItem.add(instrument_code);     // label
	firstItem.add("instr_code");   //name of field
	firstItem.add("25"); // SIZE
	firstItem.add("20"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longdescription);    // label
	secondItem.add("long_desc");  //name of field
	secondItem.add("65");   // SIZE
	secondItem.add("50");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortdescription);    // label
	thirdItem.add("short_desc");  //name of field
	thirdItem.add("40");   // SIZE
	thirdItem.add("30");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr
/*if(ph_module_yn.equals("Y")){
	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(cross_ref_ssgroup);  // label
	fourthItem.add("ss_group_code");//name
	fourthItem.add("15");
	fourthItem.add("15");
	finAr.add(fourthItem); //add to ArrayList obj finAr
}*/
	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(nature);  // label
	fifthItem.add("status");//name
	fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
	finAr.add(fifthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = instrument_code;
	orderByCols[1] = longdescription;
	orderByCols[2] = shortdescription;
    orderByCols[3] = cross_ref_ssgroup;

	orderByColVals[0] = "instr_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "ss_group_code";


	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eOT/jsp/InstrumentQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

