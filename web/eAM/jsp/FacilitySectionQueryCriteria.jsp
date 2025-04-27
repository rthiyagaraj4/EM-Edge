<!DOCTYPE html>
<%--
	FileName	: FacilitySectionQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%! ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
	ArrayList forthItem;
	ArrayList fifthItem ;
	ArrayList sixthItem;
	ArrayList sevenItem;

	%>
<%

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;

	try 
	{
request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	
	finAr = new ArrayList();
 
    firstItem = new ArrayList();
 		firstItem.add("Text");  		 // Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	 // label
		firstItem.add("operating_facility_id");	//name of field
		firstItem.add("2");	// SIZE
		firstItem.add("2");	// LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

	secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels") );	  // label
		secondItem.add("facility_name");	//name of field
		secondItem.add("70");	// SIZE
		secondItem.add("35");	// LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr

	 thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
		thirdItem.add("dept_code");	//name of field
		thirdItem.add("10");	// SIZE
		thirdItem.add("10");	// LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

	forthItem = new ArrayList();
		forthItem.add("Text");  		 //Type of item
		forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
		forthItem.add("dept_short_desc");	//name of field
		forthItem.add("15");	// SIZE
		forthItem.add("15");	// LENGTH
		finAr.add(forthItem);//add to ArrayList obj finAr

	fifthItem = new ArrayList();
		fifthItem.add("Text");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));  // label
		fifthItem.add("section_code");//name
		fifthItem.add("6");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		fifthItem.add("6");	
		finAr.add(fifthItem); //add to ArrayList obj finAr

	sixthItem = new ArrayList();
		sixthItem.add("Text");  		 //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels"));	  // label
		sixthItem.add("section_short_desc");	//name of field
		sixthItem.add("15");	// SIZE
		sixthItem.add("15");	// LENGTH
		finAr.add(sixthItem);//add to ArrayList obj finAr
	
	sevenItem=new ArrayList();
		sevenItem.add("List");  //Type of item
		sevenItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		sevenItem.add("nature");   //name of field
		sevenItem.add("B, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		sevenItem.add("4");	//LENGTH
		finAr.add(sevenItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels");	
	
	orderByColVals[0] = "operating_facility_id";
	orderByColVals[1] = "facility_name";
	orderByColVals[2] = "dept_code";
	orderByColVals[3] = "dept_short_desc";
	orderByColVals[4] = "section_code";
	orderByColVals[5] = "section_short_desc";	

	strbuff = qrypg.getQueryPage(con,finAr,"Find Section","../../eAM/jsp/FacilitySectionQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());
} 
catch (Exception e)
{}
finally
{	
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	forthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	sevenItem.clear();

	ConnectionManager.returnConnection(con,request);
}

%>
