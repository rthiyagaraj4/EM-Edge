
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>

<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String bean_id = "indexticksheet" ;
	String bean_name = "eOR.IndexTickSheet";
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexTickSheet bean = (IndexTickSheet)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String comboBox = bean.getOrCatString();
	//out.println("comboBox :"+comboBox);
	//ArrayList firstItem = new ArrayList();
	//firstItem.add("List"); 
	//firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
	//firstItem.add("order_category");	//name of field
	//firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+comboString);//Type of item
		// SIZE
	//firstItem.add("6");					//LENGTH
	//finAr.add(firstItem);				//add to ArrayList obj finAr


	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  			//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));// label
	firstItem.add("order_category");	//name of field
	firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+comboBox);
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;,"+comboBox);	// SIZE
	firstItem.add("6");					//LENGTH
	finAr.add(firstItem);

	//======================
	ArrayList twelthItem=new ArrayList();
	twelthItem.add("Hidden");			 // Type of item
	twelthItem.add("function_id");    // label
	twelthItem.add(function_id);    // name of field
	finAr.add(twelthItem);			 //add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels"));	// label
	secondItem.add("tick_sheet_id");	//name of field
	secondItem.add("6");				// SIZE
	secondItem.add("6");				//LENGTH
	finAr.add(secondItem);				//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");				//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels"));  // label
	thirdItem.add("tick_sheet_desc");   //name of field
	thirdItem.add("30");				//LENGTH
	thirdItem.add("30");				//LENGTH
	finAr.add(thirdItem);				//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object
	ArrayList forthItem=new ArrayList();
	forthItem.add("List");				// Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IndexType.label","common_labels"));

	forthItem.add("index_type");
	forthItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BySource.label","or_labels")+"");
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





















	/*ArrayList forthItem=new ArrayList();
	forthItem.add("List");
	forthItem.add("Index Type");
	//forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.IndexType.label","or_labels"));

	forthItem.add("index_type");
	//forthItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BySource.label","or_labels")+"");
	forthItem.add(" , &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;,N,Nursing Unit,C,Clinic,A,All");

// Type of item
	forthItem.add("30");				//LENGTH
	finAr.add(forthItem);				//add to ArrayList obj finAr


	//================= populating the 5th item in the firstitem object
	
	ArrayList fivethItem=new ArrayList();
	fivethItem.add("List");	
	fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceType.label","or_labels"));

	fivethItem.add("source_type");
	fivethItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"");

	// Type of item
	//fivethItem.add("Source Type");		// label
	//fivethItem.add("source_type");		// name of field
	//fivethItem.add(" , &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;,N,Nursing Unit,C,Clinic,A,All");// LENGTH
	fivethItem.add("30");				//LENGTH
	finAr.add(fivethItem);		*/		//add to ArrayList obj finAr

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


	

	String orderByCols[] = new String[9];
	String orderByColVals[] = new String[9];

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels");
	orderByCols[2]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels");
	orderByCols[4]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceDesc.label","or_labels");
	orderByCols[5]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
	orderByCols[6]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
	orderByCols[7]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[8]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ServiceDesc.label","or_labels");
	

	orderByColVals[0]	= "tick_sheet_id";    
	orderByColVals[1]	= "tick_sheet_desc";  
	orderByColVals[2]	= "order_category";   
	orderByColVals[3]	= "source_code";      
	orderByColVals[4]	= "short_desc";       
	orderByColVals[5]	= "practitioner_id";  
	orderByColVals[6]	= "practitioner_name";
	orderByColVals[7]	= "service_code";     
	orderByColVals[8]	= "service_name";     
	
	
	
	strbuff =qrypg.getMultiColumnQueryPage(null, finAr, "indexticksheet", "../../eOR/jsp/IndexTickSheetQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


	//strbuff =qrypg.getQueryPage(null, finAr, "indexticksheet", "../../eOR/jsp/IndexTickSheetQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

	out.println(strbuff.toString());
	strbuff.setLength(0);

	 putObjectInBean(bean_id,bean,request);


%>

