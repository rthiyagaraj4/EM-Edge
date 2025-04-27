<!DOCTYPE html>
<%@page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%

		ecis.utils.CommonQueryPage qrypg	=		new ecis.utils.CommonQueryPage();
		StringBuffer strbuff;
		String function_id					=		request.getParameter( "function_id" );

		ArrayList finAr						=		new ArrayList();
		ArrayList firstItem					=		new ArrayList(); 

		String Item_Analysis_Code			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemAnalysisCode.label","mm_labels");
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Item_Analysis_Code);	  // label
		firstItem.add("item_anal_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem				=		new ArrayList();
		String Item_Analysis_Desc			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemAnalysisDesc.label","mm_labels");

		secondItem.add("Text");  //Type of item
		secondItem.add(Item_Analysis_Desc);  // label
		secondItem.add("short_desc");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH

		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem				  =		new ArrayList();
		String Nature					  =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend				  =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend			  =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend			  =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List				  =		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;


		thirdItem.add("List");  //Type of item
		thirdItem.add(Nature);  // label
		thirdItem.add("nature");   //name of field
		thirdItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("4");	//LENGTH

		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();

//Type of item
		fourthItem.add("Hidden");  // label
		fourthItem.add("function_id");   //name of field
		fourthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

	//LENGTH

		finAr.add(fourthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];


orderByCols[0] = Item_Analysis_Code;
orderByCols[1] = Item_Analysis_Desc;

orderByColVals[0] = "item_anal_code";
orderByColVals[1] = "short_desc";

String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
strbuff = qrypg.getQueryPage(null,finAr,Item_Analysis_Code,"ItemAnalysisQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

out.println(strbuff.toString());
%>
