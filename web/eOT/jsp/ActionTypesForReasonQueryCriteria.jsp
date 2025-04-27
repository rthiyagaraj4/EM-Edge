<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String sortorder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ; 
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String reason =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels");
String action_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActionType.label","common_labels");
String active =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String cancel_appointment =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAppointment.label","common_labels");
String cancel_waitlist =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelWaitList.label","common_labels");
//String cancel_waitlist =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelWaitList.label","common_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("List");           //Type of item
firstItem.add(reason);     // label
firstItem.add("reason_code");   //name of field
//firstItem.add("SELECT REASON_CODE, REASON_DESC FROM OT_REASONS ORDER BY REASON_DESC"); // SIZE
firstItem.add("SELECT REASON_CODE, SUBSTR(REASON_DESC,1,50) REASON_DESC FROM OT_REASONS_LANG_VW WHERE  LANGUAGE_ID='"+locale+"'  ORDER BY REASON_DESC"); // SIZE //
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("List");          //Type of item
secondItem.add(action_type);    // label
secondItem.add("action_type");  //name of field
secondItem.add("all,ALL,CA,Cancel Appointment,CW,Cancel Waitlist,SC,Booking Sequence Change,TA,Transfer/Reschedule Appt,CN,Cancel Check-In Case,TT,Transfer back to OT");   // SIZE // eOT.CancelCheckedInCases.Label,
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");          //Type of item
thirdItem.add(active);    // label
thirdItem.add("active_yn");  //name of field
thirdItem.add("B,"+both+",Y,"+yes+",N,"+no);   // SIZE
finAr.add(thirdItem);    //add to ArrayList obj finAr

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = reason;
	orderByCols[1] = action_type;
   
	orderByColVals[0] = "B.REASON_DESC";
	orderByColVals[1] = "ACTION_TYPE";
	
strbuff = qrypg.getQueryPage( con,finAr,"ActionTypesForReason ","../../eOT/jsp/ActionTypesForReasonQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

