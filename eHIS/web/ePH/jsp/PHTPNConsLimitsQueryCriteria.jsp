<%-- saved on 26/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.* " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%-- Mandatory declarations end --%>
<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//String qry=PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_SELECT1" );
	 String qry = "SELECT AGE_GROUP_CODE,SHORT_DESC, DECODE(GENDER,'M','male','F','female','Both') GENDER,MIN_AGE, MAX_AGE, AGE_UNIT FROM AM_AGE_GROUP_LANG_VW AM_AGE_GROUP WHERE EFF_STATUS='E' AND LANGUAGE_ID =";
     String s1 = qry+"'"+locale+"'"; 

	
	
	//String qry2=PhRepository.getPhKeyValue( "SQL_PH_TPN_REGIMEN_MAST_SELECT13" );
	String qry2="SELECT TPN_REGIMEN_CODE,LONG_NAME FROM PH_TPN_REGIMEN WHERE STANDARD_REGIMEN_YN = 'N' ORDER BY 1 ";
	

	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
String non_standard_regimen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Non-StandardRegimen.label","ph_labels");

		firstItem.add("List");  //Type of item
		firstItem.add(non_standard_regimen);  // label
		firstItem.add("TPN_REGIMEN_CODE");   //name of field
		firstItem.add(qry2);
		finAr.add(firstItem); //add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

String age_group=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels");

		secondItem.add("List");  //Type of item
		secondItem.add(age_group);  // label
		secondItem.add("AGE_GROUP_CODE");   //name of field
		secondItem.add(s1);
		finAr.add(secondItem); //add to ArrayList obj finAr
	
		ArrayList thirdItem = new ArrayList();
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String constituent_group=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGroup.label","ph_labels");
String fluid=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Fluid.label","ph_labels");
String electrolytes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Electrolytes.label","ph_labels");
String trace_elements=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TraceElements.label","ph_labels");
String vitamins=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Vitamins.label","ph_labels");
String other_components=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OtherComponents.label","ph_labels");
String macro_nutrient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MacroNutrient.label","ph_labels");


		thirdItem.add("List");  //Type of item
		thirdItem.add(constituent_group);  // label
		thirdItem.add("B.CONST_GROUP_CODE");   //name of field
		thirdItem.add("  ,"+defaultSelect+",FL,"+fluid+",MN,"+macro_nutrient+",EL,"+electrolytes+",TR,"+trace_elements+",VT,"+vitamins+",OT,"+other_components);
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		//=====================================================================
		
		//ArrayList thirdItem = new ArrayList();

		//thirdItem.add("List");  //Type of item
		//thirdItem.add("Infusion Line");  // label
		//thirdItem.add("INFUSION_LINE");   //name of field
		//thirdItem.add("  ,----Select----,C,Central,P,Peripheral");
		//thirdItem.add("30");	//LENGTH
		//finAr.add(thirdItem); //add to ArrayList obj finAr
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");		
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String TPN_constituent_limits=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNConstituentLimits.label","ph_labels");
String _sjsp="PHTPNConsLimitsQueryResult.jsp" ;

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];
		orderByCols[0] = non_standard_regimen;
		orderByCols[1] = age_group;
		orderByCols[2] = constituent_group;
		orderByColVals[0] = "TPN_REGIMEN_CODE";
		orderByColVals[1] = "AGE_GROUP_CODE";
		orderByColVals[2] = "B.CONST_GROUP_CODE";
		strbuff = qrypg.getQueryPage( null , finAr, TPN_constituent_limits ,_sjsp,Sort_order,QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals,ExecuteQuery,true);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		e.printStackTrace();
		out.println( "main " + e );
	}
%>
