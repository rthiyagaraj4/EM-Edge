<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String function_id = request.getParameter("function_id");

	Connection con=null ;
	try {

		con = ConnectionManager.getConnection(request);

		String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(locationtype);	  // label
		firstItem.add("locn_type");	//name of field
		firstItem.add("20"); //size
		firstItem.add("20"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");
		
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");   //Type of item
		secondItem.add(WorkplaceCode); //label
		secondItem.add("workplace_code");//name
		secondItem.add("20"); //size
		secondItem.add("20");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

		
		String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");
		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");   //Type of item
		thirdItem.add(WorkplaceDescription);  // label
		thirdItem.add("workplace_desc");//name
		thirdItem.add("40");//size
		thirdItem.add("40");//maxlength
		finAr.add(thirdItem); //add to ArrayList obj finAr

		
		
		
		
		
		String display= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.display.label","common_labels");
		//String requirement= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.requirement.label","rs_labels");
		String AllRequirement_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.AllRequirement.label","rs_labels");
		String FeatureRequirement_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FeatureRequirement.label","rs_labels");
		String ADR_list_values="A,"+AllRequirement_legend+",F,"+FeatureRequirement_legend;
		

		//String Practitioner_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	//String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");



		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");   //Type of item
		fourthItem.add(display);// label
		fourthItem.add("requirement");//name
		fourthItem.add(ADR_list_values);//static values that need to be displayed as option.
		
		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Hidden");  //Type of item
		fifthItem.add("function_id");  // name of field
		fifthItem.add(function_id);   //value of field
		finAr.add(fifthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = WorkplaceCode;
		orderByCols[1] = locationtype;
		orderByCols[2] = WorkplaceDescription;

		orderByColVals[0] = "workplace_code";
		orderByColVals[1] = "locn_type";
		orderByColVals[2] = "workplace_desc";

	String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String FindRequirement=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindRequirement.label","rs_labels");



		strbuff = qrypg.getQueryPage(con,finAr,FindRequirement,"../jsp/WorkPlaceRequirementFrameset_QueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());
	} catch (Exception e) {
		out.println(e.toString());
	}	finally{
		ConnectionManager.returnConnection(con,request);
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
