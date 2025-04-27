<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;
try 
{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));     // label
	firstItem.add("sec_hdg_code");   //name of field
	firstItem.add("4"); // SIZE
	firstItem.add("4"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");           //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels"));     // label
	secondItem.add("sec_hdg_desc");   //name of field
	secondItem.add("60"); // SIZE
	secondItem.add("60"); //LENGTH
	finAr.add(secondItem);//add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");          //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ImageReference.label","ca_labels"));    // label
	thirdItem.add("image_ref");  //name of field
	thirdItem.add("4");   // SIZE
	thirdItem.add("4");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	/*ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add("Default");  // label
	thirdItem.add("default_yn");//name
	thirdItem.add("B,Both,Y,Yes,N,No");
	finAr.add(thirdItem);    //add to ArrayList obj finAr*/


	String[] orderByCols=null;
	String[] orderByColVals=null;
	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ImageReference.label","ca_labels");
	//orderByCols[2] = "Default ";

	orderByColVals[0] = "sec_hdg_code";
	orderByColVals[1] = "image_ref";
	//orderByColVals[2] = "default_yn";

	strbuff = qrypg.getQueryPage( con,finAr,"Find Clinic","../../eCA/jsp/QueryResultImageForSection.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());

finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
}
catch (Exception e) {
	//out.println("Exception "+e.toString());
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

