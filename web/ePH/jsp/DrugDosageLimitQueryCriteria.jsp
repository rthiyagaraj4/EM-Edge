 <!--
Fine Tuning
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	
	//String mode	= request.getParameter( "mode" ) ;
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	Connection con=null ;
	try {
		con = ConnectionManager.getConnection(request);

		ArrayList finAr = new ArrayList();
		String drug_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugCode.label" ,"common_labels");
		String DrugDosageLimitDetails=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugDosageLimitDetails.label","ph_labels");
		String drug_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label" ,"common_labels");
		String GenericName=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		String FormofDrug=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormofDrug.label","ph_labels");
		String agegroupdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroupdesc.label","common_labels");

		//=============== populating the first item in the firstitem object

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(drug_code);	  // label
		firstItem.add("drug_code");	//name of field
		firstItem.add("20");	// SIZE
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(drug_name);  // label
		secondItem.add("drug_desc");   //name of field
		secondItem.add("60");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();

		thirdItem.add("Text");  //Type of item
		thirdItem.add(GenericName);  // label
		thirdItem.add("generic_name");   //name of field
		thirdItem.add("40");
		thirdItem.add("40");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		
		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");  //Type of item
		fourthItem.add(FormofDrug);  // label
		fourthItem.add("form_desc");   //name of field
		fourthItem.add("20");
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(agegroupdesc);  // label
		fifthItem.add("age_group_desc");   //name of field
		fifthItem.add("15");	
		fifthItem.add("15");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
	
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");			//	Type of item
		sixthItem.add("function_id");		//	name of field
		sixthItem.add(function_id);		//	value of field
		finAr.add(sixthItem);				//	add to ArrayList obj finAr

		
		//=====================================================================
		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] =drug_code;
		orderByCols[1] = drug_name;
		orderByCols[2] = GenericName;
		orderByCols[3] = FormofDrug;
		orderByCols[4] = agegroupdesc;

		orderByColVals[0] = "drug_code";
		orderByColVals[1] = "drug_desc";
		orderByColVals[2] = "generic_name";
		orderByColVals[3] = "form_desc";
		orderByColVals[4] = "age_group_desc";
		
		//strbuff = qrypg.getQueryPage(CommonBean.getConnection(), finAr, "Drug Dosage Limit" , "DrugDosageLimitQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ItemClassforStore=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemClassforStore.label","mm_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


		strbuff = qrypg.getQueryPage(con, finAr, DrugDosageLimitDetails , "DrugDosageLimitQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
