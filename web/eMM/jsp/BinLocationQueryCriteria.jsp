<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<% 
		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=		(String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		=		(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ecis.utils.CommonQueryPage qrypg	= new ecis.utils.CommonQueryPage();
		StringBuffer strbuff				=	new StringBuffer();
		String bean_id						=	"BinLocationBean";
		String bean_name					=	"eMM.BinLocationBean";
		String function_id					=	request.getParameter( "function_id" );
		BinLocationBean bean				=	(BinLocationBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);

//		ArrayList	arrStore		=	null;
//		HashMap		hmStore			=	null;	
//		String code					=	"",	desc		=	"";
//		arrStore					=	bean.getStoreList();
try
{
	ArrayList components			=	new ArrayList();
	ArrayList firstItem				=	new ArrayList();
	String BinLocation				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BinLocation.label","common_labels");
	firstItem.add("Text");
	firstItem.add(BinLocation);
	firstItem.add("bin_location_code");
	firstItem.add("10");
	firstItem.add("10");
	components.add(firstItem);

	ArrayList secondItem			=	new ArrayList();
	secondItem.add("Text");

	String BinDesciption			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.BinDesciption.label","mm_labels");
	secondItem.add(BinDesciption);
	secondItem.add("long_desc");
	secondItem.add("40");
	secondItem.add("40");
	components.add(secondItem);

	ArrayList thirdItem				=	new ArrayList();
	String Store_legend				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","common_labels");
	thirdItem.add("List");
	thirdItem.add(Store_legend);
	thirdItem.add("store_code");
	//String sql="SELECT store_code,short_desc FROM mm_store_lang_vw mm_store WHERE eff_status='E' AND language_id ='"+locale+"' ORDER BY short_desc";
	String sql="SELECT store_code,short_desc FROM mm_store_lang_vw mm_store, ST_ACC_ENTITY_PARAM st_entity WHERE eff_status='E' AND language_id = '"+locale+"' AND facility_id ='"+bean.getLoginFacilityId()+"'ORDER BY short_desc";
	thirdItem.add(sql);
	components.add(thirdItem);

	ArrayList fourthItem=new ArrayList();
	String Nature			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend  =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

	String Nature_List		=	"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	fourthItem.add("List");
	fourthItem.add(Nature);
	fourthItem.add("eff_status");
	fourthItem.add(Nature_List);
	fourthItem.add("1");
	fourthItem.add("1");	
	components.add(fourthItem); 

	ArrayList fivethItem	=	new ArrayList();

	fivethItem.add("Hidden");	// label
	fivethItem.add("function_id");   //name of field
	fivethItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

	components.add(fivethItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = BinLocation;
	orderByCols[1] = "Bin Desc";
	
	orderByColVals[0] = "mb.store_code,bin_location_code";
	orderByColVals[1] = "mb.store_code,long_desc";
	
	//strbuff = qrypg.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,"Bin Location" ,"BinLocationQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	String Sort_order		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	strbuff					=	qrypg.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,BinLocation,"BinLocationQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery,true);
	out.println(strbuff.toString());
			
}

catch (java.lang.Exception exception)
{
		out.println(exception.toString());
}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
