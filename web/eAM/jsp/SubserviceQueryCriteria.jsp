<!DOCTYPE html>
<%--
	FileName	: SubserviceQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%! ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
	ArrayList fourthItem;
	ArrayList fifthItem;
	StringBuffer strbuff;
	%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;

try
{
	 con=   ConnectionManager.getConnection(request);

	finAr = new ArrayList();

	firstItem = new ArrayList();
	firstItem.add("Text");  		 		//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  		// label
	firstItem.add("service_code");			//name of field
	firstItem.add("4");						// SIZE
	firstItem.add("4");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

    secondItem=new ArrayList();
	secondItem.add("Text");  				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  		// label
	secondItem.add("service_long_desc");    //name of field
	secondItem.add("15");					// SIZE
	secondItem.add("15");					//LENGTH
	finAr.add(secondItem); 					//add to ArrayList obj finAr


	thirdItem = new ArrayList();
	thirdItem.add("Text");   				//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  	// label
	thirdItem.add("subservice_code");		//name
	thirdItem.add("4");						// SIZE
	thirdItem.add("4");						//LENGTH
	finAr.add(thirdItem); 					//add to ArrayList obj finAr

	fourthItem = new ArrayList();
	fourthItem.add("Text");   				//Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  	// label
	fourthItem.add("subservice_long_desc");	//name
	fourthItem.add("30");					// SIZE
	fourthItem.add("30");					//LENGTH
	finAr.add(fourthItem); 					//add to ArrayList obj finAr

	fifthItem=new ArrayList();
	fifthItem.add("List");  				//Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  				// label
	fifthItem.add("eff_status");   			//name of field
	fifthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	fifthItem.add("1");						//LENGTH
	finAr.add(fifthItem); 					//add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "service_code";
	orderByColVals[1] = "service_short_desc";
	orderByColVals[2] = "subservice_code";
	orderByColVals[3] = "subservice_short_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Speciality For Practitioner","../../eAM/jsp/SubserviceQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

	out.println(strbuff.toString());
} 
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	//StringBuffer values are nullified.
	strbuff.setLength(0);

	//ArrayList is cleared. 
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();

	//Connection is returned
	ConnectionManager.returnConnection(con,request);	
}
%>
