<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;

	ArrayList finAr = new ArrayList();
	
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	// label
	firstItem.add("clinic_code");	//name of field
	firstItem.add("4");			// SIZE
	firstItem.add("4");			//LENGTH
	finAr.add(firstItem);			//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));	 // label
	secondItem.add("clinic_desc");	 //name of field
	secondItem.add("15");			 // SIZE
	secondItem.add("15");			 //LENGTH
	finAr.add(secondItem);			 //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DepartmentCode.label","common_labels"));        // label
	thirdItem.add("dept_code");   	 	 //name
	thirdItem.add("10");			 // SIZE
	thirdItem.add("10");			 //LENGTH
	finAr.add(thirdItem); 			 //add to ArrayList obj finAr


	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.DepartmentDescription.label","op_labels"));  	 //label
	fourthItem.add("dept_short_desc");  	 //name
	fourthItem.add("15");		         //SIZE 
	fourthItem.add("15");  			 //LENGTH
	finAr.add(fourthItem);			 //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("Text");   		 //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));        // label
	fifthItem.add("service_code");   	 	 //name
	fifthItem.add("4");			 // SIZE
	fifthItem.add("4");			 //LENGTH
	finAr.add(fifthItem); 			 //add to ArrayList obj finAr


	ArrayList sixthItem = new ArrayList();

	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));  	 //label
	sixthItem.add("service_short_desc");  	 //name
	sixthItem.add("15");		         //SIZE 
	sixthItem.add("15");  			 //LENGTH
	finAr.add(sixthItem);			 //add to ArrayList obj finAr

	String orderByCols[] 	= new String[6];
	String orderByColVals[] = new String[6];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DepartmentCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.DepartmentDescription.label","op_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");

	orderByColVals[0] = "clinic_code";
	orderByColVals[1] = "clinic_short_desc";
	orderByColVals[2] = "dept_code";
	orderByColVals[3] = "dept_short_desc";
	orderByColVals[4] = "service_code";
	orderByColVals[5] = "service_short_desc";


	strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/ClinicServiceQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	finAr.clear();
	orderByCols = null;
	orderByColVals = null;
   
%>

