
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="webbeans.eCommon.*,java.util.*,java.sql.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String orderCatValues = "";
request.setCharacterEncoding("UTF-8");	//changed
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String function_id = request.getParameter("function_id");
Connection con=null ;

try 
{
	con = ConnectionManager.getConnection(request);

    HttpSession ss = request.getSession(false);
	eOR.OrderEntryFormatItem beanObjs = new eOR.OrderEntryFormatItem();
	beanObjs.setLanguageId(localeName);
	beanObjs.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;
	try
	{
		orderCatValues = (String)beanObjs.listOrderCategory ();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
//orderCatValues = " ,---Select---,*A,Non Specific," + orderCatValues;
	orderCatValues = " ,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,AL,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AllCategories.label","or_labels")+"," + orderCatValues;
	


	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	/*
	firstItem.add("List");  		 //Type of item
	firstItem.add("Field Mnemonic");	  // label
	firstItem.add("field_mnemonic");	//name of field
	firstItem.add("%,   Both   ,H,Header,L,Line");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(firstItem);//add to ArrayList obj finAr
	*/

	firstItem.add("Text");   //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FieldMnemonic.label","or_labels"));  // label
	firstItem.add("field_mnemonic");//name
	firstItem.add("10");
	firstItem.add("20");
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FieldMnemonicDesc.label","or_labels"));  // label
	secondItem.add("field_mnemonic_desc");//name
	secondItem.add("10");
	secondItem.add("20");
	finAr.add(secondItem); //add to ArrayList obj finAr


	ArrayList thirdItem=new ArrayList();

	thirdItem.add("List");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FieldType.label","or_labels"));	  // label
	thirdItem.add("field_type");	//name of field
	thirdItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Alphanumeric.label","or_labels")+",V,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalEvent.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DecimalNumeric.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IntegerNumeric.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.List.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RadioGroup.label","or_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.YesNo.label","common_labels")+" ");//static values that need to be displayed as option.Send it along with the value that is inserted.

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
	fourthItem.add("order_category");//name
	fourthItem.add(orderCatValues);
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Presentation.label","common_labels")); // label
	fifthItem.add("presentation_type");//name
	fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Multi.label","or_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Selection.label","common_labels"));  // label
	sixthItem.add("single_multi");//name
	sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Multi.label","or_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");   //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DefinitionType.label","common_labels"));  // label
	seventhItem.add("meaning");//name
	seventhItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(seventhItem); //add to ArrayList obj finAr


	ArrayList eighthItem = new ArrayList();

	eighthItem.add("List");   //Type of item
	eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	eighthItem.add("eff_status");//name
	eighthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(eighthItem); //add to ArrayList obj finAr

	ArrayList ninthItem = new ArrayList();

	ninthItem.add("Hidden");  //Type of item
	ninthItem.add("function_id");  // name of field
	ninthItem.add(function_id);   //value of field
	finAr.add(ninthItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FieldMnemonic.label","or_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FieldType.label","or_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");

	orderByColVals[0] = "field_mnemonic";
	orderByColVals[1] = "field_type";
	orderByColVals[2] = "order_category";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/OrderEntryForamtItemQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
} 
catch (Exception e) 
{
	e.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

