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
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrivilegeGroupID.label","or_labels"));  // label
firstItem.add("Priv_group_id");//name
firstItem.add("15");
firstItem.add("15");
finAr.add(firstItem); //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrivilegeGroupDescription.label","or_labels"));  // label
secondItem.add("priv_group_desc");//name
secondItem.add("15");
secondItem.add("30");
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); //label
thirdItem.add("eff_status");//name
thirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");// Values to be passed
finAr.add(thirdItem); 

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrivilegeGroupID.label","or_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrivilegeGroupDescription.label","or_labels");


//orderByCols[4] = "Order Category";

orderByColVals[0] = "PRIV_GRP_ID";
orderByColVals[1] = "PRIV_GRP_DESC";
//orderByColVals[4] = "c.order_category";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/PrivilegeGroupQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
} catch (Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
	}

  finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }catch(Exception e){
		 System.err.println("exception"+e);
		 }
	}


%>
