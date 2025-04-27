<!DOCTYPE html>
<%@	page import="java.sql.ResultSet" %>
<%@	page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<% request.setCharacterEncoding("UTF-8"); %>
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
	String mealType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealType.Label","ot_labels") ;
	String order =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Order.Label","ot_labels") ;
	String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
	String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
	String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String OPMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OPMealOrder.Label","ot_labels");
	String EMMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.EMMealOrder.Label","ds_labels");
	String SupplDietOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.SupplementaryDietOrder.Label","ds_labels");//MMS-QH-CRF-0079
	//String STMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.PlaceStaffMealOrder.Label","ds_labels");//ML-MMOH-CRF-0820 and (Commented Against ML-MOH-CRF-1006)
	String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.yes.Label","ot_labels");
	String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.no.Label","ot_labels");
	StringBuffer strbuff;
	String IPMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.IPMealOrder.Label","ds_labels"); //Added Against ML-MOH-CRF-1006
	Connection con=null ;

try {

		con  =  ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");
		firstItem.add(mealType);
		firstItem.add("meal_Type");
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
		fourthItem.add("Text");
		fourthItem.add(order);
		fourthItem.add("order_np");
		fourthItem.add("2");
		fourthItem.add("2");
		finAr.add(fourthItem);

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(nature);  // label
		fifthItem.add("enabled_Yn");//name
		fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
		finAr.add(fifthItem);
		
		//Added Against Start ML-MOH-CRF-1006
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("List");   //Type of item
		sixthItem.add(IPMealOrder);  // label
		sixthItem.add("IPMealOrderYn");//name
		sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(sixthItem);
		//Added Against End ML-MOH-CRF-1006
		
		ArrayList seventhItem = new ArrayList();
		seventhItem.add("List");   //Type of item
		seventhItem.add(OPMealOrder);  // label
		seventhItem.add("OPMealOrder_Yn");//name
		seventhItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(seventhItem);

		ArrayList eightItem = new ArrayList();
		eightItem.add("List");   //Type of item
		eightItem.add(EMMealOrder);  // label
		eightItem.add("EM_Meal_Order_Yn");//name
		eightItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(eightItem);

		//MMS-QH-CRF-0079 Starts
		ArrayList ninthItem = new ArrayList();
		ninthItem.add("List");   //Type of item
		ninthItem.add(SupplDietOrder);  // label
		ninthItem.add("supldietorder_yn");//name
		ninthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(ninthItem);
		//MMS-QH-CRF-0079 Starts

		//ML-MMOH-CRF-0820 Starts
		/* Commented Against ML-MOH-CRF-1006 
		ArrayList tenthItem = new ArrayList();
		tenthItem.add("List");   //Type of item
		tenthItem.add(STMealOrder);  // label
		tenthItem.add("stmealorder_yn");//name
		tenthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(tenthItem); 
		*/ 
		//ML-MMOH-CRF-0820 Starts

		String[] orderByCols=null;
		String[] orderByColVals=null;

		orderByCols = new String[5];
		orderByColVals = new String[5];

		orderByCols[0] = mealType;
		orderByCols[1] = longDesc;
		orderByCols[2] = shortDesc;
		orderByCols[3] = order;
		orderByCols[4] = nature;

		orderByColVals[0] = "meal_type";
		orderByColVals[1] = "long_desc";
		orderByColVals[2] = "short_desc";
		orderByColVals[3] = "meal_order";
		orderByColVals[4] = "eff_status";

		strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/MealTypeQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
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

