<!DOCTYPE html>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String function_id = request.getParameter( "function_id" );
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList(); 

String Item_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");

firstItem.add("Text");  		 //Type of item
firstItem.add(Item_Code);	  // label
firstItem.add("item_code");	//name of field
firstItem.add("20");	// SIZE
firstItem.add("20");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
	
String Short_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");

secondItem.add("Text");  //Type of item
secondItem.add(Short_desc);  // label
secondItem.add("short_desc");   //name of field
secondItem.add("20");	// SIZE
secondItem.add("60");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
	
String File_Name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ImageCatalogueFileName.label","mm_labels");

thirdItem.add("Text");  //Type of item
thirdItem.add(File_Name);  // label
thirdItem.add("file_name");   //name of field
thirdItem.add("20");	// SIZE
thirdItem.add("200");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr



ArrayList fourthItem = new ArrayList();

fourthItem.add("Hidden");  //Type of item
fourthItem.add("function_id");  // name of field
fourthItem.add(function_id);   //value of field

finAr.add(fourthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = Item_Code;
orderByCols[1] = Short_desc;
orderByCols[2] = File_Name;


orderByColVals[0] = "item_code";
orderByColVals[1] = "short_desc";
orderByColVals[2] = "file_name";

String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


strbuff = qrypg.getQueryPage(null,finAr,Item_Code,"../jsp/ItemImageCatalogueQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

out.println(strbuff.toString());
%>
