 <%@ page contentType="text/html;charset=UTF-8"import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.* " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();

		String disp_locn_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationCode.label","ph_labels");
		
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(disp_locn_code);	  // label
		firstItem.add("DISP_LOCN_CODE");	//name of field
		firstItem.add("22");
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		String disp_locn_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationDescription.label","ph_labels");
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(disp_locn_desc);	  // label
		secondItem.add("DISP_LOCN_DESC");	//name of field
		secondItem.add("22");
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr

		String ws_No = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.WorkstationNo.label","ph_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(ws_No);  // label
		thirdItem.add("WS_NO");   //name of field
		thirdItem.add("20");
		thirdItem.add("16");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr



		//=====================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = disp_locn_code;
		orderByCols[1] = disp_locn_desc;
		orderByCols[2] = ws_No;

		orderByColVals[0] = "code";
		orderByColVals[1] = "short";
		orderByColVals[2] = "wsno";

//		strbuff = qrypg.getQueryPage(CommonBean.getConnection(), finAr, "Drug Category Rule By Patcl" , "WsDispLocnQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

		String drug_cate_rule_by_patcl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategoryRuleByPatcl.label","ph_labels");
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, drug_cate_rule_by_patcl , "WsDispLocnQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>

