<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.util.*,  eOR.* ,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>


<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//

//	String readOnly = "" ;
	
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SpecimenLblGeneration" ;
	String bean_name = "eOR.SpecimenLblGenerationBean";
//	String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	SpecimenLblGenerationBean bean = (SpecimenLblGenerationBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.setLanguageId(localeName);
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;

	try {
	
		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		
		
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
		firstItem.add("ordering_facility_id");	//name of field
		firstItem.add("2");	// SIZE
		firstItem.add("2");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  // label
		secondItem.add("facility_name");   //name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SourceType.label","common_labels"));  // label
		thirdItem.add("source_type");   //name of field
		thirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+"");//static values that need to be
		/*
			4/5/2003 changed by kaushal to remove the department feilds from the source type list under the instruction of sunil
		*/
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels"));  // label
		fourthItem.add("source_code");   //name of field
		fourthItem.add("4");
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//=====================================================================

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecimenType.label","common_labels"));  // label
		fifthItem.add("specimen_type");   //name of field
		fifthItem.add("15");
		fifthItem.add("15");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels"));  // label
		sixthItem.add("urgency_indicator");   //name of field
		sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")+"");//static values that need to be
		sixthItem.add("30");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr



		//==================== populating the 7th item in the firstitem object

		ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NurseCollect.label","or_labels"));  // label
		seventhItem.add("nurse_collect_yn");   //name of field
		seventhItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be
		seventhItem.add("30");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr


		//==================== populating the 8th item in the firstitem object

		function_id = request.getParameter( "function_id" );

		ArrayList eightItem = new ArrayList();
		eightItem.add("Hidden");  //Type of item
		eightItem.add("function_id");  // name of field
		eightItem.add(function_id);   //value of field
		finAr.add(eightItem); //add to ArrayList obj finAr


		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SourceType.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Urgency.label","or_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecimenType.label","common_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NurseCollect.label","or_labels");

	
		orderByColVals[0] = "ORDERING_FACILITY_ID";
		orderByColVals[1] = "facility_name";
		orderByColVals[2] = "source_type";
		orderByColVals[3] = "source_code";
		orderByColVals[4] = "urgency_indicator";
		orderByColVals[5] = "specimen_type";
		orderByColVals[6] = "nurse_collect_yn";

	

		//===============yet to explore================================//

		strbuff = qrypg.getQueryPage(con, finAr, "EORTickSheet", "../../eOR/jsp/SpecimenLblGenerationQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//=========================================================================//

		out.println(strbuff.toString());
		 putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		//out.println("main"+e);//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con, request);
		 }catch(Exception e){
		 
		 }
	}
%>


