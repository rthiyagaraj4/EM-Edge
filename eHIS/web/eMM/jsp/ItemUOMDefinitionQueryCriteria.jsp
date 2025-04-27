<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>

<%
	String bean_id						=		"ItemUOMDefinition" ;
	String bean_name					=		"eMM.ItemUOMDefinition";
	ItemUOMDefinition bean				=		(ItemUOMDefinition)getBeanObject( bean_id, bean_name, request );
try{
	ecis.utils.CommonQueryPage qrypg	=		new ecis.utils.CommonQueryPage();

	bean.setLanguageId(locale);
	
	String function_id					=		request.getParameter( "function_id" );
	StringBuffer strbuff;
	
	ArrayList finAr						=		new ArrayList();
	ArrayList firstItem					=		new ArrayList();
	ArrayList secondItem				=		new ArrayList();
	ArrayList thirdItem					=		new ArrayList();
	ArrayList fourItem					=		new ArrayList();
	ArrayList fifthItem					=		new ArrayList();
	ArrayList sixthItem					=		new ArrayList();
	ArrayList items						=		new ArrayList();

	String ItemCode						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
	firstItem.add("Text");  	//Type of item
	firstItem.add(ItemCode);		// label
	firstItem.add("item_code"); //name of field
	firstItem.add("20");		// SIZE
	firstItem.add("20");	
	finAr.add(firstItem);	
	
	
	String ItemDescription				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");
	secondItem.add("Text");  	//Type of item
	secondItem.add(ItemDescription);		// label
	secondItem.add("item_desc"); //name of field
	secondItem.add("40");		// SIZE
	secondItem.add("40");	
	finAr.add(secondItem);	

	String Uom_code						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UOMCode.label","common_labels");
	thirdItem.add("Text");  		//Type of item
	thirdItem.add(Uom_code);	
	// label
	thirdItem.add("uom_code");	//name of field
	thirdItem.add("4");			// SIZE
	thirdItem.add("4");			//LENGTH
	finAr.add(thirdItem);		//add to ArrayList obj finAr

	String Uom_desc						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.UOMDescription.label","mm_labels");
	
	fourItem.add("Text");  	 //Type of item
	fourItem.add(Uom_desc);	 // label
	fourItem.add("uom_desc");	 //name of field
	fourItem.add("21");		 // SIZE
	fourItem.add("20");		 //LENGTH
	finAr.add(fourItem);		 //add to ArrayList obj finAr

	String Equom_code					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.EquivalentUOMCode.label","mm_labels");
	
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(Equom_code);	 // label
	fifthItem.add("equom_code");	 //name of field
	fifthItem.add("4");				// SIZE
	fifthItem.add("4");				 //LENGTH
	finAr.add(fifthItem);			 //add to ArrayList obj finAr

	String Equom_desc					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.EquivalentUOMDescription.label","mm_labels");

	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(Equom_desc);	 // label
	sixthItem.add("equom_desc");		 //name of field
	sixthItem.add("21");			 // SIZE
	sixthItem.add("20");			 //LENGTH
	finAr.add(sixthItem);			 //add to ArrayList obj finAr

	
	String Nature						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

	String Nature_List					=		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	items.add("List");
	items.add(Nature);
	items.add("eff_status");
	items.add(Nature_List);
	items.add("1");	
	finAr.add(items);

	items=new ArrayList();
	items.add("Hidden");
	items.add("function_id");
	items.add(function_id); 
	finAr.add(items); 
	
	String orderByCols[]				=		new String[7];
	String orderByColVals[]				=		new String[7];

	orderByCols[0]						=		ItemCode;
	orderByCols[1]						=		ItemDescription;
	orderByCols[2]						=		Uom_code;
	orderByCols[3]						=		Uom_desc;
	orderByCols[4]						=		Equom_code;
	orderByCols[5]						=		Equom_desc;
	orderByCols[6]						=		Nature;

	
	
	orderByColVals[0]					=		"item_code";
	orderByColVals[1]					=		"item_desc";
	orderByColVals[2]					=		"uom_code";
	orderByColVals[3]					=		"uom_desc";
	orderByColVals[4]					=		"eqvl_uom_code";
	orderByColVals[5]					=		"eqvl_uom_desc";
	orderByColVals[6]					=		"eff_status";

	String Sort_order					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	strbuff								=		qrypg.getQueryPage(null,finAr,ItemCode,"ItemUOMDefinitionQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols,orderByColVals,ExecuteQuery,true);
	
	out.println(strbuff.toString());
}
catch (java.lang.Exception e)
{
		//out.println(exception.toString());
		e.printStackTrace(); // COMMON-ICN-0184
}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
