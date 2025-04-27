<!DOCTYPE html>
<%--
	FileName	: SpecialtyForExternalReferralSourceQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;


	try
	{
		con=ConnectionManager.getConnection(request);
	

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalReferralSource.label","am_labels"));	 // label
	firstItem.add("referral_code");	//name of field
	


	firstItem.add("6");	// SIZE
	firstItem.add("6");	// LENGTH

	

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalReferralSource.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	secondItem.add("referral_short_desc");	//name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
	thirdItem.add("specialty_code");	//name of field
	thirdItem.add("4");	// SIZE
	thirdItem.add("4");	// LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();

	forthItem.add("Text");  		 //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	forthItem.add("specialty_short_desc");	//name of field
	forthItem.add("15");	// SIZE
	forthItem.add("15");	// LENGTH

	finAr.add(forthItem);//add to ArrayList obj finAr

	
	
	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalReferralSource.label","am_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalReferralSource.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "REFERRAL_CODE";
	orderByColVals[1] = "REFERRAL_SHORT_DESC";
	orderByColVals[2] = "SPECIALTY_CODE";
	orderByColVals[3] = "SPECIALTY_SHORT_DESC";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Referal Specialty","../../eAM/jsp/SpecialtyForExternalReferralSourceQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	forthItem.clear();
	finAr.clear();

	}
		catch (Exception e) {}

	
	finally
	{
	
		ConnectionManager.returnConnection(con,request);
		
	}
%>
