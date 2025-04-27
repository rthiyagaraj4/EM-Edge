<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper " %>
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
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	con = ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList first = new ArrayList();

	first.add("Text");  		 //Type of item
	first.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels"));	  // label
	first.add("freq_code");	//name of field
	first.add("4");
	first.add("4");

	finAr.add(first);

	ArrayList second=new ArrayList();

	second.add("Text");  		 //Type of item
	second.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyDescription.label","common_labels"));	  // label
	second.add("freq_desc");	//name of field
	second.add("60");
	second.add("60");

	finAr.add(second);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Frequency.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("freq_nature");//name
	
	//Modified by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2 
	thirdItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Interval.label","am_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Frequency.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Frequency.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PRN.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OneTime.label","am_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continuous.label","common_labels")+"");

	//thirdItem.add("'',&nbsp;--- Select ---&nbsp;,I,Interval,F,Frequency,P,PRN,O,One-Time,C,Continuous");

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Scheduled.label","am_labels"));  // label
	fourthItem.add("scheduled_yn");//name


	fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Scheduled.label","am_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Unscheduled.label","am_labels")+"");


	//fourthItem.add("B,Both,Y,Scheduled,N,Unscheduled");//static values that need to be displayed as option.Send //it along with the value that is inserted.

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	sixthItem.add("eff_status");//name
	sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");

	finAr.add(sixthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels");
	orderByCols[1] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyDescription.label","common_labels");

	orderByColVals[0] = "freq_code";
	orderByColVals[1] = "freq_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/FrequencyQueryResult.jsp?function_id=Frequency",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	first.clear();
	second.clear();
	thirdItem.clear();
	fourthItem.clear();
	sixthItem.clear();
	finAr.clear();

} 
catch (Exception e) 
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
