<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0419 -->

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
	String dietLocationCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.LocationCode.Label","ds_labels") ;
	String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
	String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
	String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String defaultlocation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.DefaultDietRequestLocation.Label","ds_labels") ;
	String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.yes.Label","ot_labels");
	String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.no.Label","ot_labels");
	StringBuffer strbuff;

	Connection con=null ;

try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
   //Location Code for Staff
	firstItem.add("Text");  //Type of item
	firstItem.add(dietLocationCode);  // label
	firstItem.add("dietLocationCode");  //name of field
	firstItem.add("4"); // SIZE
	firstItem.add("4"); //LENGTH
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
    //Long Description for Staff
	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("longDesc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
    //Short Description for Staff
	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortDesc);    // label
	thirdItem.add("shortDesc");  //name of field
	thirdItem.add("15");   // SIZE
	thirdItem.add("15");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr
	
	ArrayList fourthItem = new ArrayList();
    //defaultlocation for Staff
	fourthItem.add("List");   //Type of item
	fourthItem.add(defaultlocation);  // label
	fourthItem.add("defaultlocation");//name
	fourthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(fourthItem);


	ArrayList fifthItem = new ArrayList();
    //Nature for Staff
	fifthItem.add("List");   //Type of item
	fifthItem.add(nature);  // label
	fifthItem.add("enabledYn");//name
	fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(fifthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = dietLocationCode;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
    orderByCols[3] = nature;

	orderByColVals[0] = "location_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/DietRequestLocationQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
	e.printStackTrace();	
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">


