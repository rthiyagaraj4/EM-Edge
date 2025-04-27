<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"
	import="webbeans.eCommon.*,java.sql.*,java.util.*,eMM.*,eMM.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%
	//@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	//	
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>

<html>
<head>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>

<%
	try {
		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

		String function_id = request.getParameter("function_id");
		StringBuffer strbuff = new StringBuffer();
		ArrayList finAr = new ArrayList();

		ArrayList secondItem = new ArrayList();
		ArrayList thirdItem = new ArrayList();
		ArrayList fourthItem = new ArrayList();
		ArrayList fifthItem = new ArrayList();
		String RemarkCode = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext, "ePH.RemarkCode.label",
						"ph_labels");

		String RemarkDescription = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"ePH.RemarkDescription.label", "ph_labels");
		secondItem.add("Text"); //Type of item
		secondItem.add(RemarkDescription); // label
		//secondItem.add("remarks_desc"); //name of field
		secondItem.add(java.net.URLEncoder.encode("remarks_desc","UTF-8")); //name of field
		
		secondItem.add("20"); // SIZE
		secondItem.add("20"); //LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		String DrugCode = com.ehis.util.BundleMessage.getBundleMessage(
				pageContext, "Common.DrugCode.label", "common_labels");

		thirdItem.add("Text"); //Type of item
		thirdItem.add(DrugCode); // label
		thirdItem.add("drug_code"); //name of field
		thirdItem.add("20"); // SIZE
		thirdItem.add("20");
		finAr.add(thirdItem);

		String DrugDescription = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"ePH.DrugDescription.label", "ph_labels");
		fourthItem.add("Text"); //Type of item
		fourthItem.add(DrugDescription); // label
		fourthItem.add("drug_desc"); //name of field
		
		fourthItem.add("20"); // SIZE
		fourthItem.add("20"); //LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		String Form = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Form.label","ph_labels");
		fifthItem.add("Text"); //Type of item
		fifthItem.add(Form); // label
		fifthItem.add("form_desc"); //name of field
		fifthItem.add("20"); // SIZE
		fifthItem.add("20"); //LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList items = new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		finAr.add(items);

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = Form;
		orderByCols[1] = DrugDescription;
		orderByCols[2] = RemarkDescription;
		orderByCols[3] = DrugCode;

		orderByColVals[0] = "form_desc";
		orderByColVals[1] = "DRUG_DESC";
		orderByColVals[2] = "REMARK_DESC";
		orderByColVals[3] = "DRUG_CODE";

		

		String Sort_order = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.SortOrder.label", "common_labels");

		String defaultSelect = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.defaultSelect.label", "common_labels");

		String orderBy = com.ehis.util.BundleMessage.getBundleMessage(
				pageContext, "Common.orderBy.label", "common_labels");

		String QueryCriteria = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.QueryCriteria.label", "common_labels");

		String ExecuteQuery = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.ExecuteQuery.label", "common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, Form,
				"PresRemarkForDrugQueryResult.jsp", Sort_order,
				QueryCriteria, defaultSelect, orderBy, orderByCols,
				orderByColVals, ExecuteQuery, true);

		out.println(strbuff.toString());
	} catch (java.lang.Exception exception) {
		out.println(exception.toString());
	}
%>
