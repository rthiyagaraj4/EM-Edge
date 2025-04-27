<!DOCTYPE html>
<!--Created by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con = null;

try 
{
	con = (Connection)session.getValue( "connection" );
} 
catch (Exception e) {}

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");	//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ClaimantType.label","mo_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	// label
firstItem.add("claimant_type_mstr_code");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH
finAr.add(firstItem);	//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");	//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ClaimantType.label","mo_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("60");	// SIZE
secondItem.add("60");	//LENGTH
finAr.add(secondItem);	//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("List");	//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("eff_status");	//name
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
finAr.add(thirdItem);	//add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ClaimantType.label","mo_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ClaimantType.label","mo_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "claimant_type_mstr_code";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/ClaimantTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

strbuff.setLength(0);
firstItem.clear();
secondItem.clear();
thirdItem.clear();
finAr.clear();

%>
