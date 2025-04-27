<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " %>

<% 
//This file is saved on 18/10/2005.
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
	Connection con=null ;
	try
	{
	con = (Connection) session.getValue( "connection" );

	ArrayList finAr = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String interv_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InterventionType.label","common_labels");
	String interv_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionTypeDescription.label","cp_labels");
	String fnd_interv_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindInterventionType.label","cp_labels");
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
    String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	String def_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DefinitionType.label","common_labels");
	String sys_defined=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels");
	String user_defined=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");

	String def_type_list="%,"+Both_legend+",Y,"+sys_defined+",N,"+user_defined;

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(interv_type);	  // label
	firstItem.add("intervention_type");	//name of field
	firstItem.add("4"); //size
	firstItem.add("4"); //maxlength
	finAr.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(interv_type_desc); //label
	secondItem.add("long_desc");//name
	secondItem.add("60"); //size
	secondItem.add("60");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr
	
	

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(def_type);// label
	thirdItem.add("system_defined_yn");//name
	thirdItem.add(def_type_list);//static values that need to be displayed as option.
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(Nature);// label
	fourthItem.add("eff_status");//name
	fourthItem.add(Nature_List);//static values that need to be displayed as option.
	finAr.add(fourthItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];
	orderByCols[0] = interv_type;
	orderByCols[1] = interv_type_desc;
	orderByColVals[0] = "intervention_type";
	orderByColVals[1] = "long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,fnd_interv_type,"../jsp/InterventionTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
	out.println(strbuff.toString());

	} 
	catch (Exception e) 
	{
		out.println(e.toString());
	}	
	finally
	{
		try
		{
			if(con != null)
				ConnectionManager.returnConnection(con,request);					
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
