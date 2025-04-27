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
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
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
firstItem.add("Event Type");     // label
firstItem.add("event_type");   //name of field
firstItem.add("15"); // SIZE
firstItem.add("3"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");          //Type of item
//secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));    // label
secondItem.add("Sent File ID");    // label
secondItem.add("sent_file_id");  //name of field
secondItem.add("15");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
		
thirdItem.add("Date");   //Type of item
//thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Standard.label","common_labels"));  // label
thirdItem.add("Sent Date (dd/mm/yyyy)");  // label
thirdItem.add("sent_date");//name
thirdItem.add("15");//static values that need to be displayed as 
thirdItem.add("10");
finAr.add(thirdItem);

ArrayList facilityIDField = new ArrayList();
		
facilityIDField.add("Text");   //Type of item
facilityIDField.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));  // label
facilityIDField.add("facilityID");//name
facilityIDField.add("15");//static values that need to be displayed as 
facilityIDField.add("2");
finAr.add(facilityIDField);

ArrayList referrenceNoField = new ArrayList();
		
referrenceNoField.add("Text");   //Type of item
referrenceNoField.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.DOC_REF_NO.Label","xh_labels"));  // label
referrenceNoField.add("referrenceNo");//name
referrenceNoField.add("15");//static values that need to be displayed as 
referrenceNoField.add("30");
finAr.add(referrenceNoField);

ArrayList replyFileIDField = new ArrayList();
		
replyFileIDField.add("Text");   //Type of item
replyFileIDField.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.REPLY_FILE_ID.Label","xh_labels"));  // label
replyFileIDField.add("replyFileID");//name
replyFileIDField.add("15");//static values that need to be displayed as 
replyFileIDField.add("30");
finAr.add(replyFileIDField);

ArrayList replyDateField = new ArrayList();
		
replyDateField.add("Date");   //Type of item
replyDateField.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.REPLY_DATE.Label","xh_labels") + " (dd/mm/yyyy)");  // label
replyDateField.add("replyDate");//name
replyDateField.add("15");//static values that need to be displayed as 
replyDateField.add("10");
finAr.add(replyDateField);

String[] orderByCols=null;
String[] orderByColVals=null;

orderByCols = new String[7];
orderByColVals = new String[7];

orderByCols[0] = "Event Type";
orderByCols[1] = "Sent File ID";
orderByCols[2] = "Sent Date";
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.DOC_REF_NO.Label","xh_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.REPLY_FILE_ID.Label","xh_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.REPLY_DATE.Label","xh_labels");

orderByColVals[0] = "1";
orderByColVals[1] = "2";
orderByColVals[2] = "3";
orderByColVals[3] = "4";
orderByColVals[4] = "5";
orderByColVals[5] = "6";
orderByColVals[6] = "7";

strbuff = qrypg.getQueryPage(con,finAr,"AdminExportFiles","../../eXB/jsp/XBExportFilesQueryResult.jsp",
								"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels") + "",
								"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels") + "",
								"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels") + "",
								"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels") + "",
								orderByCols, 
								orderByColVals,
								"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels") + "");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
facilityIDField.clear();
referrenceNoField.clear();
replyFileIDField.clear();
replyDateField.clear();
finAr.clear();
} 
catch (Exception e) 
{
   System.out.println("(XBExportFilesQueryCriteria.jsp:Exception) : "+e);
   e.printStackTrace(System.err);
}

finally
{
   if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
