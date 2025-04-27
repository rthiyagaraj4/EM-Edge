<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
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
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ; 
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String day =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels") ;
String sunday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels") ;
String monday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels") ;
String tuesday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels") ;
String wednesday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels") ;
String thursday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels") ;
String friday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels") ;
String saturday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels") ;
String holiday_date =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HolidayDate.label","common_labels") ;
String reason_for_holiday =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonForHoliday.label","common_labels") ;

StringBuffer strbuff;

Connection con=null ;
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
ArrayList secondItem = new ArrayList();
ArrayList thirdItem = new ArrayList();

try {

   con  =  ConnectionManager.getConnection(request);

		
firstItem.add("Text");           //Type of item
firstItem.add(holiday_date);     // label
firstItem.add("holiday_date");   //name of field
firstItem.add("10"); // SIZE
firstItem.add("10"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr



secondItem.add("List");          //Type of item
secondItem.add(day);    // label
secondItem.add("week_day");  //name of field

//Modified by DhanasekarV against INO25643  on 23/12/2010

//secondItem.add("sel,----"+select+"--,SUN,"+sunday+",MON,"+monday+",TUE,"+tuesday+",WED,"+wednesday+",THU,"+thursday+",FRI,"+friday+",SAT,"+saturday);   // SIZE

secondItem.add("0,----"+select+"--,1,"+sunday+",2,"+monday+",3,"+tuesday+",4,"+wednesday+",5,"+thursday+",6,"+friday+",7,"+saturday);   // SIZE
  //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr



thirdItem.add("Text");   //Type of item
thirdItem.add(reason_for_holiday);  // label
thirdItem.add("reason_for_holiday");   //name of field
thirdItem.add("30");//name
thirdItem.add("30");//static values that need to be displayed as 
finAr.add(thirdItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = holiday_date;
	orderByCols[1] = day;
	orderByCols[2] = reason_for_holiday;

	
	orderByColVals[0] = "holiday_date";
	orderByColVals[1] = "week_day";
	orderByColVals[2] = "reason_for_holiday";


strbuff = qrypg.getQueryPage( con,finAr,"Holidays ","../../eOT/jsp/HolidaysQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
	finAr.clear();
	thirdItem.clear();
	secondItem.clear();
	firstItem.clear();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
