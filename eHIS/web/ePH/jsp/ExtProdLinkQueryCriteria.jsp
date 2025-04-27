<!DOCTYPE html>
<!-- Created on 07 Dec 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<% 
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
	<HTML>
		<HEAD>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		</HEAD>
	</HTML>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	ArrayList secondItem=new ArrayList();
	ArrayList thirdItem=new ArrayList();
	ArrayList fourthItem=new ArrayList();
	ArrayList fifthItem=new ArrayList();

//	String function_id = request.getParameter( "function_id" );
	try {
		String Drug_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugCode.label","common_labels");

	

		//=============== populating the first item in the firstitem object
		
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Drug_Code);	  // label
		firstItem.add("drug_code");	//name of field
		firstItem.add("20");	// SIZE
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the seconditem object
		String Drug_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugDescription.label","ph_labels");

		
		secondItem.add("Text");  //Type of item
		secondItem.add(Drug_Desc);  // label
		secondItem.add("drug_desc");   //name of field
		secondItem.add("60");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the third item in the thirditem object
		String product_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ProductID.label","ph_labels");
		

		String Select_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Select.label","common_labels");
		String fdb_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FirstDataBank.label","ph_labels");
		String cims_legend = "CIMS";
		String Form_db_item_list_values="%,"+Select_legend+",FDB,"+fdb_legend+",CIMS,"+cims_legend;

		thirdItem.add("List");  //Type of item
		thirdItem.add(product_id);  // label
		thirdItem.add("product_id");   //name of field
		thirdItem.add(Form_db_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		//================= populating the fourth item in the fourthitem object
		String ext_drug_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalDrugCode.label","ph_labels");
		
		fourthItem.add("Text");  //Type of item
		fourthItem.add(ext_drug_code);  // label
		fourthItem.add("ext_prod_drug_code");   //name of field
		fourthItem.add("40");	// SIZE
		fourthItem.add("40");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//================= populating the fifth item in the fifthitem object

	   String Both_legend =     com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Form_item_list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;

		 String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

		
   		fifthItem.add("List");  //Type of item
		fifthItem.add(Nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(Form_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = Drug_Code;
		orderByCols[1] = Drug_Desc;
		orderByCols[2] = product_id;
		orderByCols[3] = ext_drug_code;

		orderByColVals[0] = "drug_code";
		orderByColVals[1] = "drug_desc";
		orderByColVals[2] = "product_id";
		orderByColVals[3] = "ext_prod_drug_code";

    String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	//out.println("ExecuteQuery--->"+ExecuteQuery);
	String ExternalProductLink=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalProductLink.label","ph_labels");

	strbuff = qrypg.getQueryPage(null, finAr,ExternalProductLink,"ExtProdLinkQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect, orderBy, orderByCols,orderByColVals,ExecuteQuery,true);

	out.println(strbuff.toString());

	}
		catch (java.lang.Exception exception)
			{
				out.println(exception.toString());
			}
%>
