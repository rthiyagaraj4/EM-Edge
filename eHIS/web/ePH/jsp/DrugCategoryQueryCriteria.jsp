 <%-- saved on 27/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
        request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	    String locale			= (String)session.getAttribute("LOCALE");
	 
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		 String DrugCategoryCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategoryCode.label","ph_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(DrugCategoryCode);	  // label
		firstItem.add("drug_catg_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		String DrugCategoryDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategoryDescription.label","ph_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(DrugCategoryDescription);  // label
		secondItem.add("long_desc");   //name of field
		secondItem.add("42");	// SIZE
		secondItem.add("40");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();
	//String AuthenticationforMARRequired = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AuthenticationforMARRequired.label","ph_labels");

		  String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",Y,"+enabled_legend+",N,"+Disabled_legend;
		String tpn_item_list_values_nature="B,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;
		thirdItem.add("List");  //Type of item
		thirdItem.add("AuthenticationforMARRequired");  // label
		thirdItem.add("pin_auth_reqd_yn");   //name of field
		thirdItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("7");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();

	 String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

		fourthItem.add("List");  //Type of item
		fourthItem.add(Nature);  // label
		fourthItem.add("eff_status");   //name of field
		fourthItem.add(tpn_item_list_values_nature);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Hidden");			//	Type of item
		fifthItem.add("function_id");		//	name of field
		fifthItem.add(function_id);		//	value of field
		finAr.add(fifthItem);				//	add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = DrugCategoryCode;
		orderByCols[1] = DrugCategoryDescription;

		orderByColVals[0] = "drug_catg_code";
		orderByColVals[1] = "long_desc";

  String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String DrugCategory=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");
    







		
		strbuff = qrypg.getQueryPage(null, finAr,DrugCategory , "DrugCategoryQueryResult.jsp", Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols,orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
