
 <%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
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

		String template_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TemplateID.label","common_labels");
		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of template code
		firstItem.add(template_id);	  // label
		firstItem.add("template_id");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("10");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		String templateDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of template description
		secondItem.add(templateDesc);  // label
		secondItem.add("templateDesc");   //name of field
		secondItem.add("60");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		String rangeUOM_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RangeUOM.label","ph_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of  Range code
		thirdItem.add(rangeUOM_code);  // label
		thirdItem.add("rangeUOM_code");   //name of field
		thirdItem.add("10");	// SIZE
		thirdItem.add("10");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String adminUnitUOM_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AdminUnitsUOM.label","ph_labels");
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of admin code
		fourthItem.add(adminUnitUOM_code);  // label
		fourthItem.add("adminUnitUOM_code");   //name of field
		fourthItem.add("10");	// SIZE
		fourthItem.add("10");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();

		String nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String eff_statusTemp_list_values="B,"+Both+",E,"+Enabled+",D,"+disabled;
		fifthItem.add("List");  //Type of Status
		fifthItem.add(nature);  // label
		fifthItem.add("eff_statusTemp");   //name of field
		fifthItem.add(eff_statusTemp_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("1");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
	
		ArrayList seventhItem = new ArrayList();
		seventhItem.add("Hidden");			//	Type of item
		seventhItem.add("function_id");		//	name of field
		seventhItem.add(function_id);		//	value of field
		finAr.add(seventhItem);				//	add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = template_id;
		orderByCols[1] = templateDesc;
		orderByCols[2] = rangeUOM_code;
		orderByCols[3] = adminUnitUOM_code;
		
		orderByColVals[0] = "template_id";
		orderByColVals[1] = "template_desc";
		orderByColVals[2] = "range_uom_code";
		orderByColVals[3] = "admin_units_uom_code";

		String SlidingScaleTemplate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleTemplate.label","ph_labels");		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, SlidingScaleTemplate , "SlidingScaleTmplQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
