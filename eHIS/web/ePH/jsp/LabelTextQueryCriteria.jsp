  <%--This file is saved on 07/11/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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

	try {


		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String LabelTextID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LabelTextID.label","ph_labels");

		firstItem.add("Text");  		 //Type of item
		firstItem.add(LabelTextID);// label
		firstItem.add("label_text_id");//name of field
		firstItem.add("1");	// SIZE
		firstItem.add("2");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();

String LabelText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LabelTextTYPE.label","ph_labels");

      String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");

String Cautions = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Caution.label","ph_labels");
		
String SpecialInstructions = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SpecialInstructions.label","ph_labels");	String DescriptionEnglish = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		
		
		
		

		String tpn_item_list_values="B,"+Both_legend+",C,"+Cautions+",S,"+SpecialInstructions;

		secondItem.add("List");  //Type of item
		secondItem.add(LabelText);  // label
		secondItem.add("label_text_type");   //name of field
		secondItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		secondItem.add("7");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//==============================================
		//================= populating the second item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(DescriptionEnglish);  // label
		thirdItem.add("label_text_1");   //name of field
		thirdItem.add("41");	// SIZE
		thirdItem.add("40");	//LENGTH

		finAr.add(thirdItem); //add to ArrayList obj finAr

//=============================================================================
		ArrayList fourthItem=new ArrayList();

   String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

   String Both_legend1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values1="B,"+Both_legend1+",E,"+enabled_legend+",D,"+Disabled_legend;
  

		fourthItem.add("List");  //Type of item
		fourthItem.add(Nature);  // label
		fourthItem.add("eff_status");   //name of field
		fourthItem.add(tpn_item_list_values1);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
//=============================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = LabelTextID;
		orderByCols[1] = DescriptionEnglish;
		orderByCols[2] = "";

		orderByColVals[0] = "label_text_id";
		orderByColVals[1] = "label_text_1";
		orderByColVals[2] = "label_text_2";

     String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

//String LabelTextID=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LabelTextID.label","ph_labels");



		strbuff = qrypg.getQueryPage(null, finAr,LabelTextID , "LabelTextQueryResult.jsp",Sort_order, QueryCriteria,defaultSelect,orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
