<!DOCTYPE html>
<%--Author  Arvind Singh Pal Created on 4/9/2009 --%>

<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try 
{
  con  =  ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");           // Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryCode.label","ca_labels")); 			 // label
firstItem.add("alert_categ_code");		 // name of field
firstItem.add("6");			 // SIZE
firstItem.add("6");             // LENGTH
finAr.add(firstItem);            // add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");           // Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryDescription.label","ca_labels"));			  // label
secondItem.add("alert_categ_desc");	  // name of field
secondItem.add("50");			  // SIZE
secondItem.add("50");             // LENGTH
finAr.add(secondItem);            // add to ArrayList obj finAr


String[] orderByCols = null;
String[] orderByColVals = null;


	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryCode.label","ca_labels");

	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryDescription.label","ca_labels");	
		
	orderByColVals[0] = "alert_categ_code";
	orderByColVals[1] = "alert_categ_desc";
	

strbuff = qrypg.getQueryPage(con,finAr,"Alert categ","../../eCA/jsp/AlertCategoryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

finAr.clear();
firstItem.clear();
secondItem.clear();





}//end of try

		catch (Exception e) 
		{
			//out.println("Exception: "+e);//COMMON-ICN-0181
                         e.printStackTrace();//COMMON-ICN-0181
		}

		finally	
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>


