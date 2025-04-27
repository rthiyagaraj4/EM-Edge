<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.ArrayList, eMM.StoreGroupBean" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff = new StringBuffer();
	String bean_id				=	"storeGroupBean" ;
	String bean_name			=	"eMM.StoreGroupBean";
	StoreGroupBean bean = (StoreGroupBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);

	String function_id = request.getParameter( "function_id" );

	ArrayList components = new ArrayList();
	ArrayList items = new ArrayList();
		
	String Store_Group_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.StoreGroupCode.label","mm_labels");

	items.add("Text");  		    //Type of item
	items.add(Store_Group_Code);	   // Label
	items.add("store_group_code");	  //Name of field
	items.add("6");				 // SIZE
	items.add("4");				//LENGTH

	components.add(items);			
	
	items = new ArrayList();

	String Store_Group_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.StoreGroupDescription.label","mm_labels");

	items.add("Text");			    
	items.add(Store_Group_Desc);      
	items.add("store_group_desc");     
	items.add("30");			
	items.add("30");			

	components.add(items); 

	

	items = new ArrayList();
	
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

	items.add("List"); 
	items.add(Nature);
	items.add("store_group_nature"); 
	items.add(Nature_List);
	items.add("1");
	items.add("1");

	components.add(items);

	items = new ArrayList();

	items.add("Hidden");	
	items.add("function_id");  
	items.add(function_id);

	components.add(items); 

		String[] orderByCols = new String[2];
		orderByCols[0] = Store_Group_Code;
		orderByCols[1] = Store_Group_Desc;

		String[] orderByColVals = new String[2];
		orderByColVals[0] = "store_group_code";
		orderByColVals[1] = "short_desc";

	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	strbuff = qrypg.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,Store_Group_Code,"StoreGroupQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery,true);

	out.println(strbuff.toString());
%>

<%
putObjectInBean(bean_id,bean,request);
%>
