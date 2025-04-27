<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, eST.*, eST.Common.*,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");
//	String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>

<%

try{
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	
	String function_id = request.getParameter( "function_id" );
	StringBuffer strbuff;
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	ArrayList secondItem = new ArrayList();
	ArrayList thirdItem = new ArrayList();
	ArrayList fourthItem = new ArrayList();

	String StoreCode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");
	
	firstItem.add("Text");  	//Type of item
	firstItem.add(StoreCode);		// label
	firstItem.add("store_code"); //name of field
	firstItem.add("20");		// SIZE
	firstItem.add("20");	
	finAr.add(firstItem);	
	
	String StoreDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");
	
	secondItem.add("Text");  		//Type of item
	secondItem.add(StoreDesc);	
	// label
	secondItem.add("store_desc");	//name of field
	secondItem.add("20");			// SIZE
	secondItem.add("20");			//LENGTH
	finAr.add(secondItem);		//add to ArrayList obj finAr
	

	//String ParentStoreCode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ParentStoreCode.label.label","st_labels");
	String ParentStoreCode="Parent Store Code";
	thirdItem.add("Text");  	//Type of item
	thirdItem.add(ParentStoreCode);		// label
	thirdItem.add("parent_store_code"); //name of field
	thirdItem.add("20");		// SIZE
	thirdItem.add("20");	
	finAr.add(thirdItem);	
	
	//String ParentStoreDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ParentStoreDescription.label","ph_labels");
	String ParentStoreDesc="Parent Store Description";
	fourthItem.add("Text");  		//Type of item
	fourthItem.add(ParentStoreDesc);	
	// label
	fourthItem.add("parent_store_desc");	//name of field
	fourthItem.add("20");			// SIZE
	fourthItem.add("20");			//LENGTH
	finAr.add(fourthItem);		//add to ArrayList obj finAr
	

	ArrayList items=new ArrayList();
	items.add("Hidden");
	items.add("function_id");
	items.add(function_id); 
	finAr.add(items); 
	
	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = StoreCode;
	orderByCols[1] = StoreDesc;
	orderByCols[2] = ParentStoreCode;
	orderByCols[3] = ParentStoreDesc;
	

	
	
	orderByColVals[0] ="store_code";
	orderByColVals[1] = "store_desc";
	orderByColVals[2] = "parent_store_code";
	orderByColVals[3] = "parent_store_desc";
	


	String Sort_order	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy		 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


	strbuff = qrypg.getQueryPage(null,finAr,StoreCode,"ParentStoreForStoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols,orderByColVals,ExecuteQuery,true);
	
	out.println(strbuff.toString());
}
catch (java.lang.Exception exception)
{
		out.println(exception.toString());
}
%>
