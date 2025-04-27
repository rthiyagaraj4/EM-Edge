<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<% 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
String package_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
String long_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String short_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");




try 
{ 
	con				= ConnectionManager.getConnection(request);
	ArrayList finAr 	= new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		//Type of item
	firstItem.add(package_code);		//label
	firstItem.add("package_code");		//name of field
	firstItem.add("10");				// SIZE
	firstItem.add("10");			    //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem	= new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(long_desc);  // label
	secondItem.add("long_desc");   //name of field
	secondItem.add("100");	// SIZE
	secondItem.add("100");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem	= new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add(short_desc);  // label
	thirdItem.add("short_desc");   //name of field
	thirdItem.add("40");	// SIZE
	thirdItem.add("40");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr
	
   
	String orderByCols[] 	= new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] 		 = package_code;
	orderByCols[1]		 = long_desc;
	orderByCols[2] 		 = short_desc;

	orderByColVals[0] 	 = "package_code";
	orderByColVals[1] 	 = "long_desc";
	orderByColVals[2] 	 = "short_desc";

	

	strbuff = qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eBL/jsp/PkgDefQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
//	if(forthItem!=null)forthItem.clear();
//	if(fifthItem!=null)fifthItem.clear();
//	if(sixthItem!=null)sixthItem.clear();
	//if(seventhItem!=null)seventhItem.clear();
	//if(eighthItem!=null)eighthItem.clear();
	//if(ninthItem!=null)ninthItem.clear();
///	if(tenthItem!=null)tenthItem.clear();
//	if(eleventhItem!=null)eleventhItem.clear();
	
}catch (Exception e)  {
	//out.println("Error  :"+e.toString());
	e.printStackTrace();
}
finally
	{
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
	}
%>
