<!DOCTYPE html>
<%@page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		request.setCharacterEncoding("UTF-8");

		String sStyle						 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ecis.utils.CommonQueryPage qrypg	 =		 new ecis.utils.CommonQueryPage();
		StringBuffer strbuff;
		String function_id					 =		request.getParameter( "function_id" );
		ArrayList finAr						 =		new ArrayList();
		ArrayList firstItem					 =		new ArrayList(); 
		ArrayList secondItem				 =		new ArrayList();
		ArrayList thirdItem					 =		new ArrayList();
		ArrayList fourthItem				 =		new ArrayList();

		String User_ID						 =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");

		firstItem.add("Text");  		 // Type of item
		firstItem.add(User_ID);	  // label
		firstItem.add("user_id");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("30");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		
		String User_Name					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		
		secondItem.add("Text");  //Type of item
		secondItem.add(User_Name);  // label
		secondItem.add("user_name");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH

		finAr.add(secondItem); //add to ArrayList obj finAr

	
		String View_Cost_Details = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ViewCostDetails.label","st_labels");
		
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String yes = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String no = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Nature_List="%,"+Both_legend+",Y,"+yes+",N,"+no;
		
		thirdItem.add("List");  //Type of item
		thirdItem.add(View_Cost_Details);  // label
		thirdItem.add("view_cost_details");   //name of field
		thirdItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("4");	//LENGTH

		finAr.add(thirdItem); //add to ArrayList obj finAr

		

		//Type of item
		fourthItem.add("Hidden");  // label
		fourthItem.add("function_id");   //name of field
		fourthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

			//LENGTH

		finAr.add(fourthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];


		orderByCols[0] = User_ID;
		orderByCols[1] = User_Name;
		orderByCols[2] = View_Cost_Details;

		orderByColVals[0] = "a.appl_user_id";
		orderByColVals[1] = "b.appl_user_name";
		orderByColVals[2] = "a.view_cost_yn";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getQueryPage(null,finAr,User_ID,"../jsp/ViewCostDetailsforUserQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
%>
