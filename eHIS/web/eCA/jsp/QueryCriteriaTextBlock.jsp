<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TextBlockID.label","ca_labels"));     // label
firstItem.add("text_blk_id");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));    // label
secondItem.add("service_code");  //name of field
secondItem.add("4");   // SIZE
secondItem.add("4");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ServiceName.label","ca_labels"));  // label
thirdItem.add("service_desc");//name
thirdItem.add("15");
thirdItem.add("15");
finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TextBlockID.label","ca_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ServiceName.label","ca_labels");


orderByColVals[0] = "text_blk_id";
orderByColVals[1] = "service_code";
orderByColVals[2] = "service_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/QueryResultTextBlock.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();

} 
catch (Exception e) {
//out.println("Exception @ QueryCriteriaTextBlock.jsp"+e.toString());//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

