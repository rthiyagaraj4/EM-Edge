<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>

<%

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String bean_id = "indexordercareset" ;
	String bean_name = "eOR.IndexOrderCareSetBean";
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexOrderCareSetBean bean = (IndexOrderCareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
/*
	String comboBox = bean.getComboOptionsOrdCategory();
	//out.println("comboBox :"+comboBox);
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  			//Type of item
	firstItem.add("Order Category");	// label
	firstItem.add("order_category");	//name of field
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;---Select---,");	// SIZE
	finAr.add(firstItem);				//add to ArrayList obj finAr
*/
	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetCode.label","or_labels"));	// label
	secondItem.add("order_set_code");	//name of field
	secondItem.add("10");				// SIZE
	secondItem.add("10");				//LENGTH
	finAr.add(secondItem);				//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");				//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetDesc.label","or_labels"));  // label
	thirdItem.add("order_set_desc");   //name of field
	thirdItem.add("30");				//SIZE
	thirdItem.add("30");				//LENGTH
	finAr.add(thirdItem);				//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("List");				// Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IndexType.label","common_labels"));

	forthItem.add("index_type");
	forthItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BySource.label","or_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+"");
	//forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.IndexType.label","or_labels"));
	//forthItem.add("index_type");		// name of field
	//forthItem.add(" ,&nbsp;&nbsp;&nbsp;---Select---,F,By Source,P,Practitioner,S,Service,D,Diagnosis");// LENGTH

	//,A,Patient/Diagnosis

	finAr.add(forthItem);				//add to ArrayList obj finAr


	//================= populating the 5th item in the firstitem object

	ArrayList fivethItem=new ArrayList();
	fivethItem.add("List");				// Type of item
	fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SourceType.label","common_labels"));

	fivethItem.add("source_type");
	fivethItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"");
	//fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceType.label","or_labels"));
	//fivethItem.add("source_type");		// name of field
	//fivethItem.add(" ,&nbsp;&nbsp;&nbsp;---Select---,A,All,C,Clinic,N,Nursing Unit");// LENGTH
	finAr.add(fivethItem);				//add to ArrayList obj finAr

	//================= populating the 6th item in the firstitem object

	ArrayList sixthItem=new ArrayList();
	sixthItem.add("Text");				// Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels"));		// label
	sixthItem.add("source_code");		// name of field
	sixthItem.add("6");					// size
	sixthItem.add("6");					//LENGTH
	finAr.add(sixthItem);				//add to ArrayList obj finAr

	//================= populating the 7th item in the firstitem object

	ArrayList seventhItem=new ArrayList();
	seventhItem.add("Text");			// Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceDesc.label","or_labels"));		// label
	seventhItem.add("short_desc");		// name of field
	seventhItem.add("30");				// size
	seventhItem.add("30");				//LENGTH
	finAr.add(seventhItem);				//add to ArrayList obj finAr

	//================= populating the 15th item in the firstitem object

	ArrayList fifteenthItem=new ArrayList();
	fifteenthItem.add("Text");				// Type of item
	fifteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));   // label
	fifteenthItem.add("facility_id");   // name of field
	fifteenthItem.add("15");				// size
	fifteenthItem.add("15");				//LENGTH
	finAr.add(fifteenthItem);				//add to ArrayList obj finAr

	//================= populating the 16th item in the firstitem object

	ArrayList sixteenthItem=new ArrayList();
	sixteenthItem.add("Text");				// Type of item
	sixteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","st_labels")); // label
	sixteenthItem.add("facility_name"); // name of field
	sixteenthItem.add("30");				// size
	sixteenthItem.add("30");				//LENGTH
	finAr.add(sixteenthItem);				//add to ArrayList obj finAr

	//================= populating the 8th item in the firstitem object

	ArrayList eightItem=new ArrayList();
	eightItem.add("Text");				// Type of item
	eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));   // label
	eightItem.add("practitioner_id");   // name of field
	eightItem.add("15");				// size
	eightItem.add("15");				//LENGTH
	finAr.add(eightItem);				//add to ArrayList obj finAr

	//================= populating the 9th item in the firstitem object

	ArrayList ninthItem=new ArrayList();
	ninthItem.add("Text");				// Type of item
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels")); // label
	ninthItem.add("practitioner_name"); // name of field
	ninthItem.add("30");				// size
	ninthItem.add("30");				//LENGTH
	finAr.add(ninthItem);				//add to ArrayList obj finAr

	//================= populating the 10th item in the firstitem object

	ArrayList tenthItem=new ArrayList();
	tenthItem.add("Text");				// Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));		// label
	tenthItem.add("service_code");		// name of field
	tenthItem.add("4");					// size
	tenthItem.add("4");					//LENGTH
	finAr.add(tenthItem);				//add to ArrayList obj finAr

	//================= populating the 11th item in the firstitem object

	ArrayList eleventhItem=new ArrayList();
	eleventhItem.add("Text");			 // Type of item
	eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ServiceDesc.label","or_labels"));    // label
	eleventhItem.add("service_name");    // name of field
	eleventhItem.add("30");				 // size
	eleventhItem.add("30");				 //LENGTH
	finAr.add(eleventhItem);			 //add to ArrayList obj finAr

	//================= populating the 13th item in the firstitem object

	ArrayList thirteenth=new ArrayList();
	thirteenth.add("Text");				// Type of item
	thirteenth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisCode.label","common_labels"));		// label
	thirteenth.add("diagnosis_code");		// name of field
	thirteenth.add("4");					// size
	thirteenth.add("4");					//LENGTH
	finAr.add(thirteenth);				//add to ArrayList obj finAr

	//================= populating the 14th item in the firstitem object

	ArrayList fourteenthItem=new ArrayList();
	fourteenthItem.add("Text");			 // Type of item
	fourteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiagnosisDesc.label","or_labels"));    // label
	fourteenthItem.add("diagnosis_desc");    // name of field
	fourteenthItem.add("30");				 // size
	fourteenthItem.add("30");				 //LENGTH
	finAr.add(fourteenthItem);			 //add to ArrayList obj finAr

	//======================

	ArrayList twelthItem=new ArrayList();
	twelthItem.add("Hidden");			 // Type of item
	twelthItem.add("function_id");    // label
	twelthItem.add(function_id);    // name of field
	finAr.add(twelthItem);			 //add to ArrayList obj finAr



	String orderByCols[] = new String[12];
	String orderByColVals[] = new String[12];

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetCode.label","or_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetDesc.label","or_labels");
	orderByCols[2]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceDesc.label","or_labels");
	orderByCols[4]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
	orderByCols[5]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","st_labels");
	orderByCols[6]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
	orderByCols[7]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
	orderByCols[8]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[9]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ServiceDesc.label","or_labels");
	orderByCols[10]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisCode.label","common_labels");
	orderByCols[11]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiagnosisDesc.label","or_labels");

	orderByColVals[0]	= "order_set_code";
	orderByColVals[1]	= "order_catalog_desc";
	orderByColVals[2]	= "source_code";
	orderByColVals[3]	= "location_desc";
	orderByColVals[4]	= "facility_id";
	orderByColVals[5]	= "facility_name";
	orderByColVals[6]	= "practitioner_id";
	orderByColVals[7]	= "practitioner_name";
	orderByColVals[8]	= "service_code";
	orderByColVals[9]	= "service_desc";
	orderByColVals[10]	= "diagnosis_code";
	orderByColVals[11]	= "diag_desc";

	strbuff =qrypg.getMultiColumnQueryPage(null,finAr,"indexordercareset", "../../eOR/jsp/IndexOrderCareSetQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


	//strbuff =qrypg.getQueryPage(null, finAr, "indexticksheet", "../../eOR/jsp/IndexTickSheetQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

	out.println(strbuff.toString());
strbuff.setLength(0);
 putObjectInBean(bean_id,bean,request);
%>

