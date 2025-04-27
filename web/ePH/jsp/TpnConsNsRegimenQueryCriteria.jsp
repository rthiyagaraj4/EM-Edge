 <%-- saved on 26/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try {
		ArrayList finAr = new ArrayList();

		String Cons_Generic_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGenericCode.label","ph_labels");
		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Cons_Generic_Code);	  // label
		firstItem.add("const_generic_code");	//name of field
		firstItem.add("8");	// SIZE
		firstItem.add("8");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		String Item_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Item_code);  // label
		secondItem.add("item_code");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		String short_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortname.label","common_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(short_name);  // label
		thirdItem.add("const_short_name");   //name of field
		thirdItem.add("15");	// SIZE
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String long_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longname.label","common_labels");
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(long_name);  // label
		fourthItem.add("const_long_name");   //name of field
		fourthItem.add("30");	// SIZE
		fourthItem.add("30");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		String Physical_Form = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PhysicalForm.label","ph_labels");
		String both = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String liquid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Liquid.label","ph_labels");
		String solid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Solid.label","ph_labels");
		String tpn_ConsNs_list_values="B,"+both+",L,"+liquid+",S,"+solid;
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");  //Type of item
		fifthItem.add(Physical_Form);  // label
		fifthItem.add("physical_form");   //name of field
		fifthItem.add(tpn_ConsNs_list_values);//static values that need to be displayed as
		fifthItem.add("40");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem=new ArrayList();

		String nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Enabled = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_ConsNS_list_values="B,"+both+",E,"+Enabled+",D,"+disabled;
		sixthItem.add("List");  //Type of item
		sixthItem.add(nature);  // label
		sixthItem.add("eff_status");   //name of field
		sixthItem.add(tpn_ConsNS_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr
	
		ArrayList seventhItem = new ArrayList();
		seventhItem.add("Hidden");			//	Type of item
		seventhItem.add("function_id");		//	name of field
		seventhItem.add(function_id);		//	value of field
		finAr.add(seventhItem);				//	add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = Cons_Generic_Code;
		orderByCols[1] = Item_code;
		orderByCols[2] = short_name;
		orderByCols[3] = long_name;

		orderByColVals[0] = "const_generic_code";
		orderByColVals[1] = "item_code";
		orderByColVals[2] = "const_short_name";
		orderByColVals[3] = "const_long_name";

		String TPNConst_Non_Std_Reg = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNConstituentNonStandardRegimen.label","ph_labels");		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, TPNConst_Non_Std_Reg , "TpnConsNsRegimenQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
