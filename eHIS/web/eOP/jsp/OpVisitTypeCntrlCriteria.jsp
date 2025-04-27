<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
    con = ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels"));    // label
	firstItem.add("clinic_code"); //name of field
	firstItem.add("15 "); // SIZE
	firstItem.add("6"); //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicDescription.label","common_labels"));     // label
	secondItem.add("clinic_desc");    //name of field
	secondItem.add("15");   // SIZE
	secondItem.add("30");   //LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));   // label
	thirdItem.add("service_code");  //name of field
	thirdItem.add("15"); // SIZE
	thirdItem.add("6"); //LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");          //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));      // label
	fourthItem.add("service_desc");   //name of field
	fourthItem.add("15");   // SIZE
	fourthItem.add("30");   //LENGTH

	finAr.add(fourthItem);//add to ArrayList obj finAr
	

	
	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicDescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");

	orderByColVals[0] = "clinic_code";
	orderByColVals[1] = "clinic_desc";
	orderByColVals[2] = "service_code";
	orderByColVals[3] = "service_desc";

	
	
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find op Parameter For Facility","../../eOP/jsp/OpVisitTypeCntrlResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();

	} catch (Exception e) {}
	finally
	{
	  ConnectionManager.returnConnection(con,request); 
	}
%>
