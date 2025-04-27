<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
	<%
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

try {
   con  =  ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");           //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TaskID.label","ca_labels"));     // label
firstItem.add("appl_task_id");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TaskDesc.label","ca_labels"));    // label
secondItem.add("appl_task_desc");  //name of field
secondItem.add("60");   // SIZE
secondItem.add("60");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipID.label","ca_labels"));  //name of field
thirdItem.add("resp_id");  //name of field
thirdItem.add("20");   // SIZE
thirdItem.add("20");   //LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipName.label","ca_labels"));  //name of field
fourthItem.add("resp_name");  //name of field
fourthItem.add("60");   // SIZE
fourthItem.add("60");   //LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TaskID.label","ca_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TaskDesc.label","ca_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipID.label","ca_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipName.label","ca_labels");

orderByColVals[0] = "a.appl_task_id";
orderByColVals[1] = "b.appl_task_desc";
orderByColVals[2] = "a.resp_id";
orderByColVals[3] = "c.resp_name";

strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/QueryResultTaskForResp.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

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

