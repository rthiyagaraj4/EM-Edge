 <%--This file is saved on 07/11/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>


<% 
       request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	
	StringBuffer strbuff = new StringBuffer();
	try 
	{
		ArrayList finAr = new ArrayList();
String DrugType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugType.label","ph_labels");
			
	//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(DrugType);	  // label
		firstItem.add("drug_type");	//name of field
		firstItem.add("4");	//LENGTH
		firstItem.add("4");
		finAr.add(firstItem);//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		
 String DrugTypeDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugTypeDescription.label","ph_labels");

		secondItem.add("Text");  //Type of item
		secondItem.add(DrugTypeDescription);  // label
		secondItem.add("drug_type_desc");   //name of field
		secondItem.add("80");	//LENGTH
		secondItem.add("100");	//SIZE
		finAr.add(secondItem); //add to ArrayList obj finAr
String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;
 
  String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		ArrayList ThirdItem=new ArrayList();
		ThirdItem.add("List");  //Type of item
		ThirdItem.add(Nature);  // label
		ThirdItem.add("eff_status");   //name of field
		ThirdItem.add(tpn_item_list_values);//static values that need to be displayed as
		ThirdItem.add("7");	//LENGTH
		finAr.add(ThirdItem); //add to ArrayList obj finAr
	
				
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = DrugType;
		orderByCols[1] = DrugTypeDescription;

		orderByColVals[0] = "drug_type";
		orderByColVals[1] = "drug_type_desc";
 
 String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String GenericNameForService=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GenericNameForService.label","ph_labels");
        strbuff = qrypg.getQueryPage(null, finAr, "Drug Type Description" , "DrugTypeQueryResult.jsp", Sort_order,QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
