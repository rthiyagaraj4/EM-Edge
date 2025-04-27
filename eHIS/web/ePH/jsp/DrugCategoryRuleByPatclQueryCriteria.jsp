 <%-- saved on 27/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%
  
        request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css"; 
        String	bean_id			= "DrugCategoryRuleByPatcl" ;
	    String	bean_name		= "ePH.DrugCategoryRuleByPatclBean";
		StringBuffer PatientClass_lst	= new StringBuffer();

		DrugCategoryRuleByPatclBean bean	= (DrugCategoryRuleByPatclBean)getBeanObject( bean_id,bean_name, request);
		bean.setLanguageId(locale);

		ArrayList arrListPatientClassRelated = (ArrayList)bean.getPatientClassInfo(); 
	 
		PatientClass_lst.append("%,----- Select -----");
	
	for (int i=0;i<arrListPatientClassRelated.size();i++){
		String[] strPatientClassRelated = (String[])arrListPatientClassRelated.get(i);
		PatientClass_lst.append(","+strPatientClassRelated[0]);
		PatientClass_lst.append(","+strPatientClassRelated[1]);
	}

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

 
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();

		String DrugCategory = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");

		firstItem.add("Text");  		 //Type of item
		firstItem.add(DrugCategory);	  // label
		firstItem.add("drug_catg_desc");	//name of field
		firstItem.add("22");
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
    	    
		String PatientClass = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");

    	secondItem.add("List");  //Type of item
		secondItem.add(PatientClass);  // label
		secondItem.add("PATIENT_CLASS");   //name of field
		secondItem.add(PatientClass_lst.toString());
//		secondItem.add("16");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();
     String MaxDurationValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MaxDurationValue.label","ph_labels");
		thirdItem.add("Text");  //Type of item
		thirdItem.add(MaxDurationValue);  // label
		thirdItem.add("max_durn_value");   //name of field
		thirdItem.add("6");	//SIZE
		thirdItem.add("6");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();
     
	   String action = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.action.label","common_labels");

      String Authorized = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
		
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		
		String Warning = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels");
		
		String Rejected = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
		String tpn_item_list_values="S,"+defaultSelect+",W,"+Warning+",R,"+Rejected+",A,"+Authorized;
 
 


		fourthItem.add("List");  //Type of item
		fourthItem.add(action);  // label  
		fourthItem.add("action_abbr");   //name of field
		fourthItem.add(tpn_item_list_values);//static values that need to be displayed as
		fourthItem.add("1");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
	
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");			//	Type of item
		sixthItem.add("function_id");		//	name of field
		sixthItem.add(function_id);		//	value of field
		finAr.add(sixthItem);				//	add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = DrugCategory;
		orderByCols[1] = PatientClass;

		orderByColVals[0] = "drug_catg_desc";
		orderByColVals[1] = "A.patient_class";



   String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
//String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String DrugCategoryRuleByPatcl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategoryRuleByPatcl.label","ph_labels");

        strbuff = qrypg.getQueryPage( null , finAr,DrugCategoryRuleByPatcl, "DrugCategoryRuleByPatclQueryResult.jsp", Sort_order,QueryCriteria, defaultSelect,orderBy, orderByCols, orderByColVals,ExecuteQuery ,true);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
 putObjectInBean(bean_id,bean,request); 
 %>
 
