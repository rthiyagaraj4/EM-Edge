<!DOCTYPE html>
<%@ page import ="java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );
 
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();
		String termsAndCond_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.TermsAndCondCode.label","po_labels");
		items.add("Text");
		items.add(termsAndCond_code);
		items.add("termsAndCond_code");
		items.add("6");
		items.add("6");
		components.add(items);

		items=new ArrayList();
		String termsAndCond_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.TermsAndCondDesc.label","po_labels");
		items.add("Text");
		items.add(termsAndCond_desc);
		items.add("termsAndCond_desc");
		items.add("15");
		items.add("15");
		components.add(items);

		items=new ArrayList();
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		items.add("List");
		items.add(Nature);
		items.add("status");
		items.add(Nature_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[2];
		headers[0] = termsAndCond_code;
		headers[1] = termsAndCond_desc;
		
		String[] values = new String[2];
		values[0]="TERM_CONS_CODE";
		values[1]="SHORT_DESC";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag = queryPage.getQueryPage((( java.util.Properties ) session.getValue("jdbc")),components,termsAndCond_code ,"../../ePO/jsp/TermsAndConditionsQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery,true);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}
%>
