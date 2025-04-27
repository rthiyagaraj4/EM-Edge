<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>


<%
	//==========================yet to explore==============================//
		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//======================================================================//
	String function_id = request.getParameter("function_id");

Connection con=null ;
try{
	con = ConnectionManager.getConnection(request);


	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  				//Type of item
	firstItem.add("Order Type Code");		// label
	firstItem.add("order_type_code");		//name of field
	firstItem.add("4");						// SIZE
	firstItem.add("4");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");					//Type of item
	secondItem.add("Order Type Desc");		// label
	secondItem.add("order_desc");			//name of field
	secondItem.add("15");					// SIZE
	secondItem.add("15");					//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					//Type of item
	thirdItem.add("Order Catalog Code");	// label
	thirdItem.add("order_catalog_code");	//name of field
	thirdItem.add("10");					//LENGTH
	thirdItem.add("10");					//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("Text");					// Type of item
	forthItem.add("Order Catalog Desc");	// label
	forthItem.add("catalog_desc");			// name of field
	forthItem.add("20");					// size
	forthItem.add("40");					//LENGTH
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//=================
	ArrayList fifthItem=new ArrayList();
	fifthItem.add("Hidden");					// Type of item
	fifthItem.add("function_id");			// label
	fifthItem.add(function_id);				// name of field
	finAr.add(fifthItem);					//add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0]		= "Order Type Code";
	orderByCols[1]		= "Order Type Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	

	orderByColVals[0]	= "order_type_code";    
	orderByColVals[1]	= "order_desc";  
	orderByColVals[2]	= "order_catalog_code";   
	orderByColVals[3]	= "catalog_desc";      
		
	strbuff =qrypg.getQueryPage(con, finAr, "OrderTypesForOrderableBean", "../../eOR/jsp/OrderTypesForOrderableQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

	out.println(strbuff.toString());
} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>
