<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*"%>
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
	ArrayList first1Item = new ArrayList();

	String KitTemplateCode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.KitTemplateCode.label","st_labels");//+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	//String KitTemplateCode="Kit Template Code";
	first1Item.add("Text");  	//Type of item
	first1Item.add(KitTemplateCode);		// label
	first1Item.add("kit_template_code"); //name of field
	first1Item.add("20");		// SIZE
	first1Item.add("20");	
	finAr.add(first1Item);	
	
	String KitTemplateDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.KitTemplateDescription.label","common_labels");//+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	//String KitTemplateDesc="Kit Template Description";
	firstItem.add("Text");  		//Type of item
	firstItem.add(KitTemplateDesc);	
	// label
	firstItem.add("kit_template_desc");	//name of field
	firstItem.add("20");			// SIZE
	firstItem.add("20");			//LENGTH
	finAr.add(firstItem);		//add to ArrayList obj finAr
	

	ArrayList items=new ArrayList();
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
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
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[3];

	orderByCols[0] = KitTemplateCode;
	orderByCols[1] = KitTemplateDesc;
	

	
	
	orderByColVals[0] ="kit_template_code";
	orderByColVals[1] = "kit_template_desc";
	orderByColVals[2] = "eff_status";
	


	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


	strbuff = qrypg.getQueryPage(null,finAr,KitTemplateCode,"KitTemplateQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols,orderByColVals,ExecuteQuery,true);
	
	out.println(strbuff.toString());
}
catch (java.lang.Exception exception)
{
		out.println(exception.toString());
}
%>
