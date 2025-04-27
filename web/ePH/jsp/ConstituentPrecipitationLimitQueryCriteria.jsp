
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eCommon.Common.*, ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/ConstituentPrecipitationLimit.js"></SCRIPT>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();

	ArrayList Constituent_Generic=new ArrayList();
	ArrayList Const_Group=new ArrayList();
	String constituent_gen_code_from_values ="";
	

	String bean_id					= "ConstituentPrecipitationLimitBean";
	String bean_name				= "ePH.ConstituentPrecipitationLimitBean";
	ConstituentPrecipitationLimitBean bean		= (ConstituentPrecipitationLimitBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Constituent_Generic=bean.getConstituentGenericName();
	String Const_gen_value = Constituent_Generic.toString();
	Const_gen_value ="'',--Select--,"+Const_gen_value.substring(1,Const_gen_value.length()-1); 
	
	Const_Group=bean.getConstituentGroupName();
	String Const_Group_value = Const_Group.toString();
	Const_Group_value ="'',--Select--,"+Const_Group_value.substring(1,Const_Group_value.length()-1); 
	try {
		ArrayList finAr = new ArrayList();

		//String Cons_Generic_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGenericCode.label","ph_labels");
	
		String constituent_group = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGroup.label","ph_labels");

		String constituent_group_values=Const_Group_value;
		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  //Type of item
		firstItem.add(constituent_group);  // label
		firstItem.add("constituent_group");   //name of field
		firstItem.add(constituent_group_values);//static values that need to be displayed as
		firstItem.add("40");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr

		String constituent_gen_code_from =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGenericNameLimitingFrom.label","ph_labels");
	
		constituent_gen_code_from_values=Const_gen_value;
		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("List");  //Type of item
		secondItem.add(constituent_gen_code_from);  // label
		secondItem.add("constituent_gen_code_from");   //name of field
		secondItem.add(constituent_gen_code_from_values);//static values that need to be displayed as
		secondItem.add("40");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		String constituent_gen_code_to =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGenericNameLimitedTo.label","ph_labels");
		String constituent_gen_code_to_values=Const_gen_value;
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(constituent_gen_code_to);  // label
		thirdItem.add("constituent_gen_code_to");   //name of field
		thirdItem.add(constituent_gen_code_to_values);//static values that need to be displayed as
		thirdItem.add("40");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr



		//=====================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		//orderByCols[0] = Non_Stand_Reg;
		orderByCols[0] = "Non-Standard Regimen";
		//orderByCols[1] = constituent_group;
		orderByCols[1] = constituent_gen_code_from;
		orderByCols[2] = constituent_gen_code_to;


		//orderByColVals[0] = "Non Standard Regimen";
		orderByColVals[0] = "constituent_gen_code_from";
		//orderByColVals[1] = "constituent_group";
		orderByColVals[1] = "constituent_gen_code_from";
		orderByColVals[2] = "constituent_gen_code_to";


		String Const_Presc_Limit = "Constituent Precipitation Limit";		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, Const_Presc_Limit , "ConstituentPrecipitationLimitQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>

