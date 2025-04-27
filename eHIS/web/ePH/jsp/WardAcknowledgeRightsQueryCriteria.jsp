 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%

	String bean_id		= "WardAcknowledgeRightsBean" ;
	String bean_name	= "ePH.WardAcknowledgeRightsBean";
	WardAcknowledgeRightsBean bean = (WardAcknowledgeRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
//	Hashtable param_legends = bean.getLegendsFromParam();

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();

		//populate the first item
		String user_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");						//	Type of item
		firstItem.add(user_id);					//	Label
		firstItem.add("APPL_USER_ID");				//	Name of field
		firstItem.add("15");						//	Size
		firstItem.add("30");						//	Length
		finAr.add(firstItem);						//	Add to ArrayList obj finAr

		//populate the second item
		String user_name= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");						//	Type of item
		secondItem.add(user_name);				//	Label
		secondItem.add("APPL_USER_NAME");			//	Name of field
		secondItem.add("20");						//	Size
		secondItem.add("60");						//	Length
		finAr.add(secondItem);						//	Add to ArrayList obj finAr
		
		String nursing_unit_name= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");						//	Type of item
		thirdItem.add(nursing_unit_name);	//	Label
		thirdItem.add("NURSING_UNIT_NAME");			//	Name of field
		thirdItem.add("6");							//	Size
		thirdItem.add("6");							//	length
		finAr.add(thirdItem);						//	Add to ArrayList obj finAr
		

		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = user_id;
		orderByCols[1] = user_name;
		orderByColVals[0] = "APPL_USER_ID";
		orderByColVals[1] = "APPL_USER_NAME";

		String Drug_Category = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
        String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
        String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
        String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
        String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getMultiColumnQueryPage(null, finAr, Drug_Category , "WardAckRightsQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
