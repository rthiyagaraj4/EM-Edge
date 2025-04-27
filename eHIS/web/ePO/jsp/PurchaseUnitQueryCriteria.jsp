<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePO.*, ePO.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		=		(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ecis.utils.CommonQueryPage qrypg	= new ecis.utils.CommonQueryPage();
		StringBuffer strbuff				=	new StringBuffer();
		String bean_id						=	"purchaseUnitBean";
		String bean_name					=	"ePO.PurchaseUnitBean";
		String function_id					=	request.getParameter( "function_id" );
		PurchaseUnitBean bean				=	(PurchaseUnitBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);

try
{
	ArrayList components			=	new ArrayList();
	ArrayList firstItem				=	new ArrayList();
	String PurchaseUnitCode				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PurchaseUnitCode.label","st_labels");
	firstItem.add("Text");
	firstItem.add(PurchaseUnitCode);
	firstItem.add("PUR_UNIT_CODE");
	firstItem.add("6");
	firstItem.add("6");
	components.add(firstItem);

	ArrayList secondItem			=	new ArrayList();
	secondItem.add("Text");

	String PurchaseUnitDesc			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PurchaseUnitDesc.label","st_labels");
	secondItem.add(PurchaseUnitDesc);
	secondItem.add("long_desc");
	secondItem.add("40");
	secondItem.add("40");
	components.add(secondItem);
	
	ArrayList thirdItem=new ArrayList();
	String Global_Unit			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.GlobalUnit.label","po_labels");
	String Both_legend		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Yes_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
	String No_legend  =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

	String Global_Unit_List		=	"%,"+Both_legend+",Y,"+Yes_legend+",N,"+No_legend;
	thirdItem.add("List");
	thirdItem.add(Global_Unit);
	thirdItem.add("global_unit");
	thirdItem.add(Global_Unit_List);
	thirdItem.add("1");
	thirdItem.add("1");	
	components.add(thirdItem); 

	ArrayList fourthItem=new ArrayList();
	String Nature			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legends		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend  =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

	String Nature_List		=	"%,"+Both_legends+",E,"+Enabled_legend+",D,"+Disabled_legend;
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

	orderByCols[0] = PurchaseUnitCode;
	orderByCols[1] = "Purchase Unit Desc";
	
	orderByColVals[0] = "PUR_UNIT_CODE";
	orderByColVals[1] = "long_desc";
	
	String Sort_order		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	strbuff					=	qrypg.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,PurchaseUnitCode,"PurchaseUnitQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery,true);
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
