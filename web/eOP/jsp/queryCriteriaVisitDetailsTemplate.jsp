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
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));    // label
	firstItem.add("code"); //name of field
	firstItem.add("4 "); // SIZE
	firstItem.add("4"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr
	ArrayList secondItem = new ArrayList();
    secondItem.add("Text");          //Type of item
   secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));     // label
	secondItem.add("code_desc");    //name of field
	secondItem.add("40");   // SIZE
	secondItem.add("40");   //LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr
		
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	

	orderByColVals[0] = "template_code";
	orderByColVals[1] = "description";
	

	
	
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find op Parameter For Facility","../../eOP/jsp/queryResultVisitDetailsTemplate.jsp ",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		//thirdItem.clear();
	//	fourthItem.clear();

	} catch (Exception e) {}
	finally
	{
	  ConnectionManager.returnConnection(con,request); 
	}
%>
