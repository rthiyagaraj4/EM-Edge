<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 

<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try {


	String userid= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(userid);	 // label
	firstItem.add("appl_user_id");	//name of field
	firstItem.add("30");				//Size
	firstItem.add("30");				//Length	
	finAr.add(firstItem);			//add to ArrayList obj finAr

	String username= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");        //Type of item
	secondItem.add(username);  //label
	secondItem.add("appl_user_name");  //name appl_user_name
	secondItem.add("60");		  //size	
	secondItem.add("60");         //length
	finAr.add(secondItem); //add to ArrayList obj finAr



	String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");        //Type of item
	thirdItem.add(WorkplaceCode);  //label
	thirdItem.add("workplace_code");  //name
	thirdItem.add("10");		  //size	
	thirdItem.add("10");         //length
	finAr.add(thirdItem);		//add to ArrayList obj finAr

	String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");        //Type of item
	fourthItem.add(WorkplaceDescription);  //label
	fourthItem.add("workplace_desc");  //name
	fourthItem.add("30");		  //size	
	fourthItem.add("30");         //length
	finAr.add(fourthItem);		//add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];
	orderByCols[0] = userid;
	orderByCols[1] = username;
	orderByCols[2] = WorkplaceCode;
	orderByCols[3] = WorkplaceDescription;


	orderByColVals[0] = "appl_user_id";
	orderByColVals[1] = "appl_user_name";
	orderByColVals[2] = "workplace_code";
	orderByColVals[3] = "workplace_desc";



	String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		

	strbuff = qrypg.getQueryPage(con,finAr,"AccessRights","../jsp/AccessRightsQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
} catch (Exception e) {
		out.println(e.toString());
}
finally
{
	try
	{
	ConnectionManager.returnConnection(con,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
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
