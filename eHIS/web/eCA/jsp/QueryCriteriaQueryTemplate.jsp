<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QueryID.label","ca_labels"));     // label
	firstItem.add("query_id");   //name of field
	firstItem.add("10"); // SIZE
	firstItem.add("10"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QueryDesc.label","ca_labels"));    // label
	secondItem.add("query_desc");  //name of field
	secondItem.add("20");   // SIZE
	secondItem.add("20");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels"));    // label
	thirdItem.add("note_type");  //name of field
	thirdItem.add("20");   // SIZE
	thirdItem.add("20");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifthItem.add("eff_status");//name
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fifthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QueryID.label","ca_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QueryDesc.label","ca_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","ca_labels");

	orderByColVals[0] = "QUERY_REF";
	orderByColVals[1] = "QUERY_DESC";
	orderByColVals[2] = "NOTE_TYPE";


	strbuff = qrypg.getQueryPage( con,finAr,"Find Query Template ","../../eCA/jsp/QueryResultQueryTemplate.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fifthItem.clear();


	}	
	catch (Exception e) 
	{
		//out.println("Exception "+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

