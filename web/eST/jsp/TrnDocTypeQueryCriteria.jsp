<!DOCTYPE html>
<%@ page import ="java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");

		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );

String doc_type_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DocTypeCode.label","common_labels");
		items.add("Text");
		items.add(doc_type_code);
		items.add("doc_type_code");
		items.add("6");
		items.add("6");
		components.add(items);

		items=new ArrayList();
		String DocTypeDescription=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DocTypeDescription.label","common_labels");
		items.add("Text");
		items.add(DocTypeDescription);
		items.add("doc_type_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items = new ArrayList();
		String trn_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.transactiontype.label","common_labels");
		items.add("Text");
		items.add(trn_type);
		items.add("trn_type");
		items.add("3");
		items.add("3");
		components.add(items);

		items=new ArrayList();
			String trntypeDescription=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TRNTypeDescription.label","common_labels");
		items.add("Text");
		items.add(trntypeDescription);
		items.add("trn_type_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = doc_type_code;
		headers[1] = DocTypeDescription;
		headers[2] = trn_type;
		headers[3] = trntypeDescription;

		String[] values = new String[4];
		values[0]="doc_type_code";
		values[1]="doc_type_desc";
		values[2]="trn_type";
		values[3]="trn_type_desc";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
//		String Store_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","mm_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag = queryPage.getQueryPage(null,components,"Surgery Type" ,"../../eST/jsp/TrnDocTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();
		items.clear();
	}
%>
