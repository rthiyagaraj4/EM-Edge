 <%-- saved on 27/10/2005 --%>
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
		String FormofDrugCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormofDrugCode.label","ph_labels");

		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(FormofDrugCode);	  // label
		firstItem.add("form_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr
		//================= 
		String FormofDrugDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormofDrugDescription.label","ph_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(FormofDrugDesc);  // label
		secondItem.add("form_desc");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr
        
		ArrayList thirdItem=new ArrayList();
		String ApplicableUOMCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ApplicableUOMCode.label","ph_labels");
		thirdItem.add("Text");  //Type of item
		thirdItem.add(ApplicableUOMCode);  // label
		thirdItem.add("uom_code");   //name of field
		thirdItem.add("4");//size
		thirdItem.add("4");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		
		ArrayList fourthItem=new ArrayList();

	String ApplicableUOMDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ApplicableUOMDescription.label","ph_labels");
		fourthItem.add("Text");  //Type of item
		fourthItem.add(ApplicableUOMDesc);  // label
		fourthItem.add("short_desc");   //name of field
		fourthItem.add("15");//size
		fourthItem.add("15");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

	
		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		
		orderByCols[0] = FormofDrugCode;
		orderByCols[1] = FormofDrugDesc;
		orderByCols[2] = ApplicableUOMCode;
		orderByCols[3] = ApplicableUOMDesc;

		orderByColVals[0] = "form_code";
		orderByColVals[1] = "form_desc";
		orderByColVals[2] = "uom_code";
		orderByColVals[3] = "short_desc";
		 
 String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
 
 String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

 String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
 
 String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
 
 String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
 
 String GenericNameForService=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GenericNameForService.label","ph_labels");

	strbuff = qrypg.getQueryPage(null, finAr, "UOM for Form" , "UomForFormQueryResult.jsp",Sort_order, QueryCriteria,defaultSelect ,orderBy , orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
