<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>
<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
Connection con=null ;
StringBuffer strbuff;
String age_grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroupcode.label","common_labels");
String age_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroupdesc.label","common_labels");
String interv_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionCode.label","cp_labels");
String interv_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionDescription.label","cp_labels");
String find_service=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindService.label","cp_labels");

try 
{
 con = ConnectionManager.getConnection(request);
 
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(age_grp_code);	// label
firstItem.add("age_group_code");	//name of field
firstItem.add("2");			// SIZE
firstItem.add("2");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(age_grp_desc);	 // label
secondItem.add("long_desc");	 //name of field
secondItem.add("30");			 // SIZE
secondItem.add("30");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(interv_code);        // label
thirdItem.add("Intervention_code");   	 	 //name
thirdItem.add("10");			 // SIZE
thirdItem.add("10");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(interv_desc);  	 //label
fourthItem.add("short_desc");  	 //name
fourthItem.add("60");		         //SIZE 
fourthItem.add("60");  			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr

String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = age_grp_code;
orderByCols[1] = age_grp_desc;
orderByCols[2] = interv_code;
orderByCols[3] = interv_desc;

orderByColVals[0] = "age_group_code";
orderByColVals[1] = "long_desc";
orderByColVals[2] = "Intervention_code";
orderByColVals[3] = "short_desc";
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
strbuff = qrypg.getQueryPage(con,finAr,find_service,"../jsp/AgeGroupForInterventionQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

out.println(strbuff.toString());
} catch ( Exception e )	{
		e.printStackTrace() ;
		//out.print(e);//common-icn-0181
		throw e ;
	} finally {
				ConnectionManager.returnConnection(con,request);

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
