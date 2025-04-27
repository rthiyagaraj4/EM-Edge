<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con = null;

try
{
ArrayList finAr = new ArrayList();

con = ConnectionManager.getConnection(request);

ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels"));	  // label
firstItem.add("nursing_unit_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels"));  // label
secondItem.add("nursing_unit_desc");   //name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels"));  // label
thirdItem.add("report_id");   //name of field
thirdItem.add("15");	// SIZE
thirdItem.add("30");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels"));  // label
fourthItem.add("report_desc");   //name of field
fourthItem.add("25");	// SIZE
fourthItem.add("60");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();
fifthItem.add("List");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels"));  // label
fifthItem.add("print_on_booking_yn");   //name of field
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
fifthItem.add("5");	//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr

/*

ArrayList sixthItem=new ArrayList();
sixthItem.add("List");  //Type of item
sixthItem.add("Transfer Request");  // label
sixthItem.add("print_on_transfer_request_yn");   //name of field
sixthItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as option.Send it along with the value that is inserted.
sixthItem.add("5");	//LENGTH
finAr.add(sixthItem); //add to ArrayList obj finAr


ArrayList tenthItem=new ArrayList();
tenthItem.add("List");  //Type of item
tenthItem.add("Discharge");  // label
tenthItem.add("print_on_discharge_yn");   //name of field
tenthItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as option.Send it along with the value that is inserted.
tenthItem.add("5");	//LENGTH
finAr.add(tenthItem); //add to ArrayList obj finAr



*/

ArrayList sixthItem=new ArrayList();
sixthItem.add("List");  //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AssignBed.label","common_labels"));  // label
sixthItem.add("print_on_admission_yn");   //name of field
sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
sixthItem.add("5");	//LENGTH
finAr.add(sixthItem); //add to ArrayList obj finAr


ArrayList seventhItem=new ArrayList();
seventhItem.add("List");  //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferConfirmation.label","ip_labels"));  // label
seventhItem.add("print_on_conform_transfer_yn");   //name of field
seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
seventhItem.add("5");	//LENGTH
finAr.add(seventhItem); //add to ArrayList obj finAr


ArrayList eighthItem=new ArrayList();
eighthItem.add("List");  //Type of item
eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmissionWithBed.label","ip_labels"));  // label
eighthItem.add("print_on_bed_assigned_yn");   //name of field
eighthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
eighthItem.add("5");	//LENGTH
finAr.add(eighthItem); //add to ArrayList obj finAr


ArrayList ninthItem=new ArrayList();
ninthItem.add("List");  //Type of item
ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DischargeAdvice.label","common_labels"));  // label
ninthItem.add("print_on_disch_adv_yn");   //name of field
ninthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
//static values that need to be displayed as option.Send it along with the value that is inserted.
ninthItem.add("5");	//LENGTH
finAr.add(ninthItem); //add to ArrayList obj finAr


ArrayList tenthItem=new ArrayList();
tenthItem.add("List");  //Type of item
tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels"));  // label
tenthItem.add("print_on_discharge_yn");   //name of field
tenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
tenthItem.add("5");	//LENGTH
finAr.add(tenthItem); //add to ArrayList obj finAr





ArrayList elevenItem=new ArrayList();
elevenItem.add("List");  //Type of item
elevenItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferRequest.label","ip_labels"));  // label
elevenItem.add("print_on_transfer_request_yn");   //name of field
elevenItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
elevenItem.add("5");	//LENGTH
finAr.add(elevenItem); //add to ArrayList obj finAr





String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels");

orderByColVals[0] = "nursing_unit_code";
orderByColVals[1] = "nursing_unit_short_desc";
orderByColVals[2] = "report_id";
orderByColVals[3] = "report_desc";

strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"IP Online Report","../../eIP/jsp/IPOnlineReportQueryResult.jsp?function_id=IP_ONLINE_REPORT",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));
}
catch(Exception e)
{
	out.println(e.toString());
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
