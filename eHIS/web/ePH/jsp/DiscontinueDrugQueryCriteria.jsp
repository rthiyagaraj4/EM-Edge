 <!--
Fine Tuning
-->
<%@ page contentType="text/html;charset=UTF-8"  import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
   request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");



String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();
  String drug_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugCode.label" ,"common_labels");

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(drug_code);	  // label
		firstItem.add("drug_code");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("10");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
        String drug_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label" ,"common_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(drug_name);  // label
		secondItem.add("drug_desc");   //name of field
		secondItem.add("62");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr
        String generic_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(generic_name);  // label
		thirdItem.add("generic_name");   //name of field
		thirdItem.add("42");	// SIZE
		thirdItem.add("40");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
        String form_of_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormofDrug.label","ph_labels");
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(form_of_drug);  // label
		fourthItem.add("form_desc");   //name of field
		fourthItem.add("22");	// SIZE
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
	    String compound = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Compound.label","ph_labels");
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");  //Type of item
		fifthItem.add(compound);  // label
		fifthItem.add("compound_drug_yn");   //name of field
		fifthItem.add("B,Both,Y,Yes,N,No");//static values is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
		
		

		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = "Drug Code";
		orderByCols[1] = "Drug Name";
		orderByCols[2] = "Generic Name";
		orderByCols[3] = "Form Of Drug";
		

		orderByColVals[0] = "drug_code";
		orderByColVals[1] = "drug_desc";
		orderByColVals[2] = "generic_name";
		orderByColVals[3] = "form_desc";
	
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String DrugCategory=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");

		strbuff = qrypg.getQueryPage(null, finAr, DrugCategory , "DiscontinueDrugQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
