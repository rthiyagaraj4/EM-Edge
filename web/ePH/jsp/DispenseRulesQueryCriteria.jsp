 <%@ page contentType="text/html;charset=UTF-8"import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	String qry_patient_class=PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT5");
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();
		
		String drug_cat = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(drug_cat);	  // label
		firstItem.add("drug_catg_code");	//name of field
		firstItem.add("22");	
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr
		String Drug_Cat_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategoryDescription.label","ph_labels");
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(Drug_Cat_Desc);	  // label
		secondItem.add("drug_catg_desc");	//name of field
		secondItem.add("22");	
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr

		String Patient_Class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(Patient_Class);  // label
		thirdItem.add("patient_class");   //name of field
		thirdItem.add(qry_patient_class);

		finAr.add(thirdItem); //add to ArrayList obj finAr

		String Disp_Group_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensingGroupCode.label","ph_labels");
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(Disp_Group_Code);	  // label
		fourthItem.add("disp_group_code");	//name of field
		fourthItem.add("22");	
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem);//add to ArrayList obj finAr

		String Disp_Group_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensingGroupDesc.label","ph_labels");
		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Text");  		 //Type of item
		fifthItem.add(Disp_Group_Desc);	  // label
		fifthItem.add("disp_group_desc");	//name of field
		fifthItem.add("22");	
		fifthItem.add("20");	//LENGTH
		finAr.add(fifthItem); 

		String Action = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.action.label","common_labels");
		String default_select = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String both = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String error = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Error.label","ph_labels");
		String warn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels");
		String disp_values="S,"+"---"+default_select+"---"+",B,"+both+",E,"+error+",W,"+warn;
		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(Action);  // label
		sixthItem.add("action_abbr");   //name of field
		sixthItem.add(disp_values);//static values that need to be displayed as 
		sixthItem.add("1");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr


		ArrayList seventhItem = new ArrayList();
		seventhItem.add("Hidden");			//	Type of item
		seventhItem.add("function_id");		//	name of field
		seventhItem.add(function_id);		//	value of field
		finAr.add(seventhItem);				//	add to ArrayList obj finAr

		
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = drug_cat;
		orderByCols[1] = Patient_Class;

		orderByColVals[0] = "drug_catg_desc";
		orderByColVals[1] = "A.patient_class";
		
		String Drug_Disp_Rules = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugDispenseRules.label","ph_labels");
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		
		strbuff = qrypg.getQueryPage( ( (java.util.Properties)session.getValue("jdbc") ) , finAr, Drug_Disp_Rules , "DispenseRulesQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery,true);

		out.println(strbuff.toString());
	}
		catch (Exception e) {
			out.println( "main " + e );
			}
%>
