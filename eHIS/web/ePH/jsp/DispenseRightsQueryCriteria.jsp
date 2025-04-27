 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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

	String bean_id		= "DispenseRightsBean" ;
	String bean_name	= "ePH.DispenseRightsBean";
	DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	Hashtable param_legends = bean.getLegendsFromParam();

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

		//populate the third item
		String Disp_Locn_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationCode.label","ph_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");						//	Type of item
		thirdItem.add(Disp_Locn_Code);	//	Label
		thirdItem.add("DISP_LOCN_CODE");			//	Name of field
		thirdItem.add("6");							//	Size
		thirdItem.add("6");							//	length
		finAr.add(thirdItem);						//	Add to ArrayList obj finAr

		//populate the fourth item
		String Dispense_Location_Description = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationDescription.label","ph_labels");
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");								//	Type of item
		fourthItem.add(Dispense_Location_Description);	//	Label
		fourthItem.add("SHORT_DESC");						//	Name of field
		fourthItem.add("15");								//	Size
		fourthItem.add("15");								//	Length
		finAr.add(fourthItem);								//	Add to ArrayList obj finAr

		//populate the fifth item
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String no_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Both_Yes_No="%,"+Both_legend+",Y,"+yes_legend+",N,"+no_legend;
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");						//	Type of item
		fifthItem.add(param_legends.get("R"));				//	Label
		fifthItem.add("ACK_YN");					//	Name of field
		fifthItem.add(Both_Yes_No);			//	Static values for list box.
		fifthItem.add("7");							//	Length
		finAr.add(fifthItem);						//	Add to ArrayList obj finAr

		//populate the sixth item
		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");						//	Type of item
		sixthItem.add(param_legends.get("V"));					//	Label
		sixthItem.add("VERIFY_YN");					//	Name of field
		sixthItem.add(Both_Yes_No);			//	Static values for list box.
		sixthItem.add("7");							//	Length
		finAr.add(sixthItem);						//	Add to ArrayList obj finAr

		//populate the seventh item
		ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");					//	Type of item
		seventhItem.add(param_legends.get("F"));					//	Label
		seventhItem.add("FILL_YN");					//	Name of field
		seventhItem.add(Both_Yes_No);		//	Static values for list box.
		seventhItem.add("7");						//	Length
		finAr.add(seventhItem);						//	Add to ArrayList obj finAr

		//populate the eighth item
		ArrayList eighthItem=new ArrayList();
		eighthItem.add("List");						//	Type of item
		eighthItem.add(param_legends.get("D"));					//	Label
		eighthItem.add("DELIVER_YN");				//	Name of field
		eighthItem.add(Both_Yes_No);		//	Static values for list box.
		eighthItem.add("7");						//	Length
		finAr.add(eighthItem);						//	Add to ArrayList obj finAr

		//populate the nineth item
		String Medication_Return = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationReturn.label","ph_labels");
		ArrayList ninthItem=new ArrayList();
		ninthItem.add("List");						//	Type of item
		ninthItem.add(Medication_Return);			//	Label
		ninthItem.add("ACCEPT_MEDN_RTN_YN");		//	Name of field
		ninthItem.add(Both_Yes_No);			//	Static values for list box.
		ninthItem.add("7");							//	Length
		finAr.add(ninthItem);						//	Add to ArrayList obj finAr

		/*//populate the tenth item
		ArrayList tenthItem=new ArrayList();
		tenthItem.add("List");						//	Type of item
		tenthItem.add(param_legends.get("B"));			//	Label
		tenthItem.add("BILL_RECEIPT_YN");			//	Name of field
		tenthItem.add(Both_Yes_No);			//	Static values that need to be displayed as	option.Send it along with the value that is inserted.
		tenthItem.add("7");							//	Length
		finAr.add(tenthItem);						//	Add to ArrayList obj finAr*/

		//populate the eleventh item
		ArrayList eleventhItem=new ArrayList();
		eleventhItem.add("List");					//	Type of item
		eleventhItem.add(param_legends.get("A"));				//	Label
		eleventhItem.add("ALLOCATE_YN");			//	Name of field
		eleventhItem.add(Both_Yes_No);		//	Static values for list box.
		eleventhItem.add("7");						//	Length
		finAr.add(eleventhItem);					//	Add to ArrayList obj finAr

		//populate the twelveth item
		ArrayList twelvethItem = new ArrayList();
		twelvethItem.add("Hidden");					//	Type of item
		twelvethItem.add("function_id");			//	Name of field
		twelvethItem.add(function_id);				//	Value of field
		finAr.add(twelvethItem);					//	Add to ArrayList obj finAr

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

		strbuff = qrypg.getMultiColumnQueryPage(null, finAr, Drug_Category , "DispenseRightsQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString().replace("nowrap", ""));
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
