 <%--This file is saved on 07/11/2005 --%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 

	request.setCharacterEncoding("UTF-8");	
			
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	

	StringBuffer strbuff = new StringBuffer();
	try 
	{
		ArrayList finAr = new ArrayList();

			
	//=============== populating the first item in the firstitem object

		String ADRTypeCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ADRTypeCode.label","ph_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(ADRTypeCode);	  // label	
		firstItem.add("adr_code");	//name of field
		firstItem.add("4");	//LENGTH
		firstItem.add("2");
		finAr.add(firstItem);//add to ArrayList obj finAr
 
	//================= populating the second item in the firstitem object
	
	String ADRTypeDesc= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ADRTypeDescription.label","ph_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(ADRTypeDesc);  // label	
		secondItem.add("adr_desc");   //name of field
		secondItem.add("30");	//LENGTH
		secondItem.add("30");	//SIZE
		finAr.add(secondItem); //add to ArrayList obj finAr


		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enable.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

		String ADR_list_values="B,"+Both_legend+",E,"+Enable_legend+",D,"+Disable_legend;


		ArrayList ThirdItem=new ArrayList();
		ThirdItem.add("List");  //Type of item
		ThirdItem.add(Nature);  // label
		ThirdItem.add("eff_status");   //name of field
		ThirdItem.add(ADR_list_values);//static values that need to be displayed as
		ThirdItem.add("7");	//LENGTH
		finAr.add(ThirdItem); //add to ArrayList obj finAr
	
		
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = ADRTypeCode;
		orderByCols[1] = ADRTypeDesc;

		orderByColVals[0] = "ADR_CODE";
		orderByColVals[1] = "adr_desc";



String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

//String ADRTypeDescription=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ADRTypeDescription.label","ph_labels");


        strbuff = qrypg.getQueryPage(null, finAr,ADRTypeCode, "ADRTypeQueryResult.jsp", SortOrder, QueryCriteria, Select,orderBy, orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
