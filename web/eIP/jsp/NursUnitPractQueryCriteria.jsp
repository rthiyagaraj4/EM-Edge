<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" %>
<%
	request.setCharacterEncoding("UTF-8");
	//String url    = "../../eCommon/jsp/MstCodeToolbar.jsp?"; 
	//String params = request.getQueryString() ;
	//String source = url + params ;
	//String function_id = request.getParameter("function_id");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8"); 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String locale			= (String)session.getAttribute("LOCALE");
StringBuffer strbuff;
Connection con=null ;
Statement stmt=null; 
try 
{

		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement();

	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels"));	// label
	firstItem.add("nursing_unit_code");	//name of field
	firstItem.add("4");			// SIZE
	firstItem.add("4");			//LENGTH
	finAr.add(firstItem);			//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels"));	 // label
	secondItem.add("nursing_unit_desc");	 //name of field
	secondItem.add("15");			 // SIZE
	secondItem.add("15");			 //LENGTH
	finAr.add(secondItem);			 //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));        // label
	thirdItem.add("practitioner_id");    	 //name
	thirdItem.add("15");			 // SIZE
	thirdItem.add("15");			 //LENGTH
	finAr.add(thirdItem); 			 //add to ArrayList obj finAr

	ArrayList twelvethItem = new ArrayList();
	twelvethItem.add("List");  		 //Type of item
	twelvethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));	  // label
	twelvethItem.add("pract_type");	//name of field
	twelvethItem.add("select pract_type,DESC_SYSDEF from am_pract_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by 2");	
	finAr.add(twelvethItem);

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  	 //label
	fourthItem.add("Practitioner_short_name");  	 //name
	fourthItem.add("30");		         //SIZE 
	fourthItem.add("30");  			 //LENGTH
	finAr.add(fourthItem);			 //add to ArrayList obj finAr


	String orderByCols[] 	= new String[5];
	String orderByColVals[] = new String[5];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");

	orderByColVals[0] = "nursing_unit_code";
	orderByColVals[1] = "nursing_unit_short_desc";
	orderByColVals[2] = "practitioner_id";
	orderByColVals[3] = "pract_type";
	orderByColVals[4] = "practitioner_name";

	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels"),"../jsp/NursUnitPractQueryResult.jsp?function_id=PRACTITIONER_FOR_NURSING_UNIT ",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	// Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003
	if(stmt!=null)stmt.close();
}catch(Exception e ){out.println("Exception in tryCatch : "+ e.toString());}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request); 
}
%>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
