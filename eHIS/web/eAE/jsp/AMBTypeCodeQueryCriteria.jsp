<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
String longdes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String shortdes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");

Connection con=null ;

try
	{

		con  =  ConnectionManager.getConnection(request);


		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");           //Type of item
		firstItem.add(code);     // label
		firstItem.add("amb_service_type");   //name of field
		firstItem.add("10"); // SIZE
		firstItem.add("10"); //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(longdes);    // label
		secondItem.add("long_desc");  //name of field
		secondItem.add("30");   // SIZE
		secondItem.add("30");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList  thirdItem = new ArrayList();

		 thirdItem.add("Text");          //Type of item
		 thirdItem.add(shortdes);    // label
		 thirdItem.add("short_desc");  //name of field
		 thirdItem.add("30");   // SIZE
		 thirdItem.add("30");   //LENGTH
		finAr.add( thirdItem);    //add to ArrayList obj finAr
		
		ArrayList forthtem = new ArrayList();

		forthtem.add("List");   //Type of item
		forthtem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		forthtem.add("eff_status");//name
		forthtem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
		
		finAr.add(forthtem); //add to ArrayList obj finAr


			String[] orderByCols = null;
			String[] orderByColVals = null;


			orderByCols = new String[3];
			orderByColVals = new String[3];


			orderByCols[0] = code;
			orderByCols[1] =longdes;
			orderByCols[2] =shortdes;

			orderByColVals[0] = "amb_service_type";
			orderByColVals[1] = "long_desc";
			orderByColVals[2] = "short_desc";

			strbuff = qrypg.getQueryPage(con,finAr,"ServiceType","../../eAE/jsp/AMBTypeCodeQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order By",orderByCols, orderByColVals,"Execute Query");
          out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		forthtem.clear();
	
} 

catch (Exception e) 
{
System.out.println("@@ Exception in AMBTypeCodeQueryCriteria.jsp="+e.toString());
e.printStackTrace();
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<SCRIPT LANGUAGE="JavaScript">
//parent.commontoolbarFrame.document.getElementById("apply").disabled = true;
</SCRIPT>

