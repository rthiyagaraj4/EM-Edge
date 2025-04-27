<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language=javascript src='../../eCA/js/CAPersonalizedHomePage.js'></script>
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

	firstItem.add("List");           // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));		 // label
	firstItem.add("pract_type");		 // name of field
	firstItem.add("select PRACT_TYPE, nvl(DESC_USERDEF, DESC_SYSDEF) pract_type_desc from am_pract_type where  EFF_STATUS ='E' order by 2");
	finAr.add(firstItem);            // add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");           // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));		  // label
	secondItem.add("practitioner_id");	  // name of field
	secondItem.add("20");			  // SIZE
	secondItem.add("20");             // LENGTH
	finAr.add(secondItem);			//	add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           // Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Desktop.label","common_labels"));		  // label
	thirdItem.add("DESKTOP_SUMMARY_ID");	  // name of field
	thirdItem.add("20");			  // SIZE
	thirdItem.add("20");             // LENGTH
	finAr.add(thirdItem);			//	add to ArrayList obj finAr

	String[] orderByCols = null;
	String[] orderByColVals = null;


	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Desktop.label","ca_labels");
	

	
	orderByColVals[0] = "pract_type";
	orderByColVals[1] = "practitioner_id";
	orderByColVals[2] = "DESKTOP_SUMMARY_ID";
	

	strbuff = qrypg.getQueryPage(con,finAr,"eCA.DefinePersonalizedHomePage.label","../../eCA/jsp/CAPersonalizedResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

	finAr.clear();
			firstItem.clear();
			secondItem.clear();
			thirdItem.clear();
}//end of try

		catch (Exception e) 
		{
			//out.println("Exception in try of AssignCAMenuCriteria.jsp: "+e.toString());//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}

		finally	
		{
			
			
			
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>

