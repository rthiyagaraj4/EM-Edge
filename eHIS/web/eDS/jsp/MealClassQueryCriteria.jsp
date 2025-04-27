<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added Against ML-MMOH-CRF-1005-US1 -->
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/>
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<!-- Added Against ML-MMOH-CRF-1005-US1 -->
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@  page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<%
String locale = (String)session.getAttribute("LOCALE");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String mealClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealClass.Label","ot_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
//ML-MMOH-CRF-0419
String applstafforderyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ApplForStaffOrder.Label","ds_labels"); 
String editmenuappl_yn =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ApplicableEditMenu.Label","ds_labels");//ML-MMOH-CRF-0669-US1
String attdntorderappl_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ApplicableFor.Label","ds_labels") +" "+ DSCommonBeanObj.getAttendantLabel(); //ML-MMOH-CRF-1005-US1
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.yes.Label","ot_labels");
	String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.no.Label","ot_labels");
StringBuffer strbuff;

Connection con=null ;

try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");
	firstItem.add(mealClass);
	firstItem.add("mealClass");
	firstItem.add("4");
	firstItem.add("2");
	finAr.add(firstItem);

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("longDesc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortDesc);    // label
	thirdItem.add("shortDesc");  //name of field
	thirdItem.add("15");   // SIZE
	thirdItem.add("15");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr


	//ML-MMOH-CRF-0419 starts Here
	ArrayList twelethItem = new ArrayList();

	twelethItem.add("List");   //Type of item
	twelethItem.add(applstafforderyn);  // label
	twelethItem.add("applstafforder_yn");//name
	twelethItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(twelethItem);	
    	//ML-MMOH-CRF-0419 Ends Here
	
	//ML-MMOH-CRF-0669 starts Here
	ArrayList thirteenItem = new ArrayList();
    	thirteenItem.add("List");   //Type of item
	thirteenItem.add(editmenuappl_yn);  // label
	thirteenItem.add("editmenuappl_yn");//name
	thirteenItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(thirteenItem);	
	//ML-MMOH-CRF-0669 Ends Here
	
	//Added Against ML-MMOH-CRF-1005-US1 Starts Here
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");   //Type of item
	fifthItem.add(attdntorderappl_yn);  // label
	fifthItem.add("attdntorderappl_yn");//name
	fifthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(fifthItem);
	//Added Against ML-MMOH-CRF-1005-US1 Ends Here
	
	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(nature);  // label
	fourthItem.add("enabledYn");//name
	fourthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(fourthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = mealClass;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
    	orderByCols[3] = nature;

	orderByColVals[0] = "meal_class";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/MealClassQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

