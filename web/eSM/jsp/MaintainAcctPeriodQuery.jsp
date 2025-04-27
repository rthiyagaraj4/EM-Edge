<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html><%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
request.setCharacterEncoding("UTF-8");
ArrayList finAr = new ArrayList();
String acc_per_year1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodYear.label","sm_labels");
	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(acc_per_year1);
		firstItem.add("acc_per_year");	//name of field
		firstItem.add("5");	// SIZE
		firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
	String acc_per_month1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodMonth.label","sm_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(acc_per_month1); 
		secondItem.add("acc_per_month");   //name of field
		secondItem.add("5");	// SIZE
		secondItem.add("2");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList third_item=new ArrayList();
String acc_per_start_date1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodSdate.label","sm_labels");
		third_item.add("Date");  //Type of item
		third_item.add(acc_per_start_date1); 
		third_item.add("acc_per_start_date");   //name of field
		third_item.add("10");	// SIZE
		third_item.add("10");	//LENGTH
	finAr.add(third_item); //add to ArrayList obj finAr

	ArrayList fourth_item=new ArrayList();
String acc_per_end_date1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodEdate.label","sm_labels");
		fourth_item.add("Date");  //Type of item
		fourth_item.add(acc_per_end_date1);
		fourth_item.add("acc_per_end_date");   //name of field
		fourth_item.add("10");	// SIZE
		fourth_item.add("10");	//LENGTH
	finAr.add(fourth_item); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();
String acc_cal_year1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.CalenderYear.label","sm_labels");
		fifthItem.add("Text");  //Type of item
		fifthItem.add(acc_cal_year1); 
		fifthItem.add("acc_cal_year");   //name of field
		//fifthItem.add("CAL_PER_YEAR");
		fifthItem.add("6");	// SIZE
		fifthItem.add("4");	//LENGTH
	finAr.add(fifthItem); //add to ArrayList obj //finAr


ArrayList sixItem=new ArrayList();
String acc_cal_month1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.CalenderMonth.label","sm_labels");
		sixItem.add("Text");  //Type of item
		sixItem.add(acc_cal_month1); 
		sixItem.add("acc_cal_month");   //name of field
		//sixItem.add("CAL_PER_MONTH");
		sixItem.add("4");	// SIZE
		sixItem.add("2");	//LENGTH
	finAr.add(sixItem); //add to ArrayList obj finAr



String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] =acc_per_year1;
orderByCols[1] =acc_per_month1;
orderByCols[2] =acc_per_start_date1;
orderByCols[3] =acc_per_end_date1;
orderByCols[4] =acc_cal_year1;
orderByCols[5] =acc_cal_month1;

orderByColVals[0] = "acc_per_year";
orderByColVals[1] = "acc_per_month";
orderByColVals[2] = "acc_per_start_date";
orderByColVals[3] = "acc_per_end_date";
orderByColVals[4] = "acc_cal_year";
orderByColVals[5] = "acc_cal_month";
//orderByColVals[4] = "cal_per_year";
//orderByColVals[5] = "cal_per_month";



strbuff = qrypg.getQueryPage(con,finAr,"Menu Admin","../../eSM/jsp/MaintainAcctPeriodResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());

        strbuff.setLength(0);
		finAr.clear();
		secondItem.clear();
		firstItem.clear();
		third_item.clear();
		fourth_item.clear();
		fifthItem.clear();
		sixItem.clear();
%>
