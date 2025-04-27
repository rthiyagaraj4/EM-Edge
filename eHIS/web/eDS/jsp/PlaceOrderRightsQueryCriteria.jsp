<!DOCTYPE html>
<!-- New file PlaceOrderRightsQueryCriteria.jsp created against ML-MMOH-CRF-0677  -->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
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
	String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
	String userid =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
	String edit_meals =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.EditMeals.Label","ds_labels");
	String nutrient_supplement =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.NutrientSupplement.Label","ds_labels");
	String food_dislike =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.FoodDislike.Label","ds_labels");
	String special_food_order =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.SpecialFoodOrder.Label","ds_labels");
	String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String  yes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
	String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
	StringBuffer strbuff;
	Connection con=null ;
	try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");    //Type of item
	firstItem.add(name);     // label
	firstItem.add("appl_user_name");   //name of field
	firstItem.add("30"); // SIZE
	firstItem.add("30");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");          //Type of item
	secondItem.add(userid);    // label
	secondItem.add("appl_user_id");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");          //Type of item
	thirdItem.add(edit_meals);    // label
	thirdItem.add("edit_meals_yn");  //name of field
	thirdItem.add("B,"+both+",Y,"+yes+",N,"+no);   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");          //Type of item
	fourthItem.add(nutrient_supplement);    // label
	fourthItem.add("nutrient_supplement_yn");  //name of field
	fourthItem.add("B,"+both+",Y,"+yes+",N,"+no);   //LENGTH
	finAr.add(fourthItem);    //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");          //Type of item
	fifthItem.add(food_dislike);    // label
	fifthItem.add("food_dislike_yn");  //name of field
	fifthItem.add("B,"+both+",Y,"+yes+",N,"+no);   //LENGTH
	finAr.add(fifthItem);    //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();
	sixthItem.add("List");   //Type of item
	sixthItem.add(special_food_order);  // label
	sixthItem.add("special_food_order_yn");//name
	sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
	finAr.add(sixthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = name;
	orderByCols[1] = userid;

	orderByColVals[0] = "appl_user_name";
	orderByColVals[1] = "appl_user_id";

	strbuff = qrypg.getQueryPage( con,finAr,"PlaceOrderRights ","../../eDS/jsp/PlaceOrderRightsQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
	out.println(strbuff.toString());
}catch(Exception e)
	{
	e.printStackTrace();
	}	
finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

