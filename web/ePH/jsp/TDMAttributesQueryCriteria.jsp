 <%--This file is saved on 07/11/2005 --%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.ArrayList, ePH.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <BODY style="overflow-y:hidden"> -->
<BODY style="overflow-y:hidden" onMouseDown="" onKeyDown="lockKey()">

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff	= new StringBuffer();
	StringBuffer ageGroup	= new StringBuffer();
	String	bean_id			= "TDMAttributes" ;
	String	bean_name		= "ePH.TDMAttributesBean";
	TDMAttributesBean bean	= (TDMAttributesBean)getBeanObject( bean_id,bean_name, request);
bean.setLanguageId(locale);
	ArrayList arrListAgeGroupRelated = (ArrayList)bean.getAgeGroupRelatedInfo(); 
	ageGroup.append("%,----- Select -----");
	
	for (int i=0;i<arrListAgeGroupRelated.size();i++){
		String[] strAgeGroupRelated = (String[])arrListAgeGroupRelated.get(i);
		ageGroup.append(","+strAgeGroupRelated[0]);
		ageGroup.append(","+strAgeGroupRelated[1]);
	}

	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
String DrugCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugCode.label" ,"common_labels");


		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");							//	Type of item
		firstItem.add(DrugCode);				//	Label
		firstItem.add("DRUG_CODE");				//	Name of field
		firstItem.add("20");								//	SIZE
		firstItem.add("20");								//	LENGTH
		finAr.add(firstItem);							//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		String DrugName= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");									//	Type of item
		secondItem.add(DrugName);					    //	Label
		secondItem.add("DRUG_DESC");					    //	Name of field
		secondItem.add("50");									    //	.SIZE
		secondItem.add("50");									    //   Length
		finAr.add(secondItem);									    //	Add to ArrayList obj finAr

		//================= populating the third item in the firstitem object

		String AgeGroup= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels");

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");								       //	Type of item
		thirdItem.add(AgeGroup);		           //	Label
		thirdItem.add("AGE_GROUP_CODE");						           //	Name of field
		thirdItem.add(ageGroup.toString());          //	Dynamic age group values from database.
		finAr.add(thirdItem);											//	Add to ArrayList obj finAr
		
        //=====================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = DrugCode;
		orderByCols[1] = DrugName;
		orderByCols[2] = AgeGroup;


		orderByColVals[0] = "DRUG_CODE";
		orderByColVals[1] = "DRUG_DESC";
		orderByColVals[2] = "AGE_GROUP_CODE";



String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String TDMAttrbute=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TDMAttributes.label","ph_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String OrderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, TDMAttrbute, "TDMAttributesQueryResult.jsp",SortOrder, QueryCriteria,Select,OrderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
 putObjectInBean(bean_id,bean,request); 
 %>
 </BODY>

