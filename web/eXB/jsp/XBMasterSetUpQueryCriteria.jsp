<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
<% 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {
con  =  ConnectionManager.getConnection(request);			    
ArrayList finAr = new ArrayList();
											   
ArrayList firstItem = new ArrayList();
 
firstItem.add("Text");          //Type of item
//firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));     // label
firstItem.add("Module Type");     // label
firstItem.add("module_type");   //name of field
firstItem.add("10"); // SIZE
firstItem.add("10"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");          //Type of item
//secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));    // label
secondItem.add("Payer Group");    // label
secondItem.add("payer_group_desc");  //name of field
secondItem.add("20");   // SIZE
secondItem.add("20");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
		
thirdItem.add("Text");   //Type of item
//thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Standard.label","common_labels"));  // label
thirdItem.add("Payer Code");  // label
thirdItem.add("payer_desc");//name
thirdItem.add("20");//static values that need to be displayed as 
thirdItem.add("20");
finAr.add(thirdItem);

ArrayList fourthItem = new ArrayList();
		
fourthItem.add("Text");   //Type of item
//fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","xh_labels"));  // label
fourthItem.add("Policy Code");  // label
fourthItem.add("policy_desc");//name
fourthItem.add("20");//static values that need to be displayed as 
fourthItem.add("20");//static values that need to be displayed as 
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();
		
fifthItem.add("List");   //Type of item
//fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","xh_labels"));  // label
fifthItem.add("Episode Type");  // label
fifthItem.add("episode_type");//name
fifthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels")+"");//static values that need to be displayed as 
fifthItem.add(",");//static values that need to be displayed as 
finAr.add(fifthItem);

ArrayList sixthItem = new ArrayList();
		
sixthItem.add("List");   //Type of item
//sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","xh_labels"));  // label
sixthItem.add("Enabled");  // label
sixthItem.add("enabled_yn");//name
sixthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as 
sixthItem.add(",");//static values that need to be displayed as 
finAr.add(sixthItem);

ArrayList seventhItem = new ArrayList();

seventhItem.add("Hidden");   //Type of item
seventhItem.add("locale");  // label
seventhItem.add(locale);//name
seventhItem.add(locale);//static values that need to be displayed as 
finAr.add(seventhItem);


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[6];
	orderByColVals = new String[6];

/*	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Standard.label","common_labels");
	orderByCols[3] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels"); 
	orderByCols[4] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");  */

	orderByCols[0] = "Module Type";
	orderByCols[1] = "Payer Group";
	orderByCols[2] = "Payer";
	orderByCols[3] = "Policy";
	orderByCols[4] = "Episode Type";
	orderByCols[5] = "Enabled";
			
	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";
	orderByColVals[3] = "4";
	orderByColVals[4] = "5";
	orderByColVals[5] = "6";
	
	
strbuff = qrypg.getQueryPage( con,finAr,"MasterSetUp","../../eXB/jsp/XBMasterSetUpQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels")+"");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventhItem.clear();
finAr.clear();

} catch (Exception e) {
   System.out.println("XBMasterSetUpQueryCriteria.jsp Exception : "+e);}

finally
{
   if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
