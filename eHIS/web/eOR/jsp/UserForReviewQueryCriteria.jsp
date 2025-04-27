<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.*, java.sql.*,webbeans.eCommon.*,eOR.Common.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels"));  // label
firstItem.add("resp_id");//name
firstItem.add("15");
firstItem.add("15");
finAr.add(firstItem); //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels"));  // label
secondItem.add("resp_name");//name
secondItem.add("15");
secondItem.add("30");
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels")); // label
thirdItem.add("pract_id");//name
thirdItem.add("15");
thirdItem.add("15");
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels")); // label
fourthItem.add("practitioner_name");//name
fourthItem.add("15");
fourthItem.add("30");
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
fifthItem.add("order_category");//name
String temp=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_ANOTHER");
temp=temp.replace("?","'"+localeName+"'");

fifthItem.add(temp);

finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AuthorizationRequired.label","or_labels"));  // label
sixthItem.add("auth_yn");//name
sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(sixthItem); //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();

seventhItem.add("List");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CosignRequired.label","or_labels"));  // label
seventhItem.add("cosign_yn");//name
seventhItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(seventhItem); //add to ArrayList obj finAr

ArrayList eighthItem = new ArrayList();

eighthItem.add("List");   //Type of item
eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialApprovalRequired.label","common_labels"));  // label
eighthItem.add("spl_appr_yn");//name
eighthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(eighthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
//orderByCols[4] = "Order Category";

orderByColVals[0] = "c.practitioner_id";
orderByColVals[1] = "c.resp_id";
orderByColVals[2] = "a.resp_name";
orderByColVals[3] = "b.practitioner_name";
//orderByColVals[4] = "c.order_category";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/UserForReviewQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
} catch (Exception e) {
	//out.println(e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}

  finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }catch(Exception e){System.out.println("exception"+e);
		 
		 }
	}


%>

