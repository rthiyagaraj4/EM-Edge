<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff = new StringBuffer();

Connection con=null ;

try {
   con  =  ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");           //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels"));
    // label
firstItem.add("resp_id");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels"));    // label
secondItem.add("resp_name");  //name of field
secondItem.add("60");   // SIZE
secondItem.add("60");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipID.label","ca_labels"));  //name of field
thirdItem.add("pract_reln_id");  //name of field
thirdItem.add("20");   // SIZE
thirdItem.add("20");   //LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipName.label","ca_labels"));  //name of field
fourthItem.add("pract_reln_name");  //name of field
fourthItem.add("60");   // SIZE
fourthItem.add("60");   //LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");

orderByCols[1] = 
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");

orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipID.label","ca_labels");

orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipName.label","ca_labels");


orderByColVals[0] = "a.resp_id";
orderByColVals[1] = "b.resp_name";
orderByColVals[2] = "a.pract_reln_id";
orderByColVals[3] = "c.pract_reln_name";

strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/QueryResultRelnForResp.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();

} catch (Exception e) {
	//out.println("Exception "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

