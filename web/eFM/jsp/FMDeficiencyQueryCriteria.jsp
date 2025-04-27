<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	eFM - Deficiency
	Function		:	This function is used to load query criteria screen for the function
-->

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try 
	{
		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  				// Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DeficiencyCode.label","fm_labels"));		// label
		firstItem.add("deficiency_code");		// name of field
		firstItem.add("8");						// SIZE
		firstItem.add("8");						// LENGTH
		finAr.add(firstItem);					// add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");					// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DeficiencyDescription.label","fm_labels"));		// label
		secondItem.add("long_desc");			// name of field
		secondItem.add("30");					// SIZE
		secondItem.add("30");					// LENGTH
		finAr.add(secondItem);					// add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");					// Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));				// label
		thirdItem.add("eff_status");			// name
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DeficiencyCode.label","fm_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DeficiencyDescription.label","fm_labels");

		orderByColVals[0] = "deficiency_code";
		orderByColVals[1] = "long_desc";
		orderByColVals[2] = "eff_status";

		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BuildingCode.label","common_labels"),"../jsp/FMDeficiencyQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		} 
		catch (Exception e)
		{
			out.println("Exxception e :"+e);
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>
