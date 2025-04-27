<!DOCTYPE html>
<!--Created by P.Anuradha on Dec-27-2004-->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*  " contentType="text/html;charset=UTF-8"%>

<% 
//This file is saved on 18/10/2005.
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
	Connection conn=null ;
	conn = (Connection) session.getValue( "connection" );
try{
	ArrayList Dependencyvalues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String dep_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.DependencyCode.label","cp_labels");
	String dep_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.DependencyDescription.label","cp_labels");
	String dep_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DependencyLevel.label","common_labels");
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
    String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String all=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String find_dep=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindDependency.label","cp_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(dep_code);	  // label
	firstItem.add("Dependency_code");	//name of field
	firstItem.add("10"); //size
	firstItem.add("10"); //maxlength
	Dependencyvalues.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(dep_desc); //label
	secondItem.add("Dependency_Longdesc");//name
	secondItem.add("30"); //size
	secondItem.add("30");  //maxlength
	Dependencyvalues.add(secondItem); //add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(dep_level); //label
	thirdItem.add("Dependency_Level");//name
	thirdItem.add("%,"+all+",1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9");//static values that need to be displayed as option.
    Dependencyvalues.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
    fourthItem.add(Nature); //label
	fourthItem.add("eff_status_yn");//name
	fourthItem.add(Nature_List);//static values that need to be displayed as option.
	Dependencyvalues.add(fourthItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];
	orderByCols[0] = dep_code;
	orderByCols[1] = dep_desc;
	orderByColVals[0] = "dependency_code";
	orderByColVals[1] = "long_desc";

	strbuff = qrypg.getQueryPage(conn,Dependencyvalues,find_dep,"../jsp/DependencyQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols,orderByColVals,ExecuteQuery);
	out.println(strbuff.toString());

	} catch (Exception e) {
	//	out.println(e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}	finally{
		try
		{
			if(conn != null)
				ConnectionManager.returnConnection(conn,request);					
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
			}
%>


<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
