<!DOCTYPE html>
<%@page import="java.util.*, eCA.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	/* Mandatory checks start */
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  				//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChiefComplaint.label","common_labels"));			// label
	firstItem.add("complaint_id");			//name of field
	firstItem.add("4");						// SIZE
	firstItem.add("4");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");					//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaintSearch.label","ca_labels"));		// label
	secondItem.add("complaint_desc");			//name of field
	secondItem.add("15");					// SIZE
	secondItem.add("15");					//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels"));	// label
	thirdItem.add("speciality_code");	//name of field
	thirdItem.add("15");					//LENGTH
	thirdItem.add("15");					//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("Text");					// Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels"));	// label
	forthItem.add("speciality_desc");			// name of field
	forthItem.add("20");					// size
	forthItem.add("40");					//LENGTH
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================
	ArrayList fifthItem=new ArrayList();
	fifthItem.add("Hidden");					// Type of item
	fifthItem.add("function_id");	// label
	fifthItem.add(function_id);			// name of field
	finAr.add(fifthItem);					//add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	/*orderByCols[0]		= "Service Code";
	orderByCols[1]		= "Service Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	*/

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChiefComplaint.label","common_labels");
	orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaintSearch.label","ca_labels");
	orderByCols[2]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels");

	orderByColVals[0]	= "complaint_id";    
	orderByColVals[1]	= "complaint_desc";  
	orderByColVals[2]	= "speciality_code";   
	orderByColVals[3]	= "long_desc";      
		
	strbuff =qrypg.getQueryPage(null, finAr, "ChiefComplaint", "../../eCA/jsp/ChiefComplaintSpltyResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QueryCriteria.label","or_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExecuteQuery.label","or_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);

 

%>

