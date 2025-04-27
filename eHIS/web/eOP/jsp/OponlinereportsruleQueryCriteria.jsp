<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;

	Connection con=null ;

	try
	{
		con = ConnectionManager.getConnection(request);

		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");       //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));  // label
		firstItem.add("clinic_code");    //name of field
		firstItem.add("4");          // SIZE
		firstItem.add("4");         //LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));    // label
		secondItem.add("clinic_desc");  //name of field
		secondItem.add("15");       // SIZE
		secondItem.add("15");       //LENGTH
		finAr.add(secondItem);      //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();

		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels"));  // label
		thirdItem.add("Visit_Type_Code");   //name of field
		thirdItem.add("2"); // SIZE
		thirdItem.add("2"); //LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels"));  // label
		fourthItem.add("Visit_Type_short_desc");   //name of field
		fourthItem.add("15");   // SIZE
		fourthItem.add("15");   //LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();

		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels"));  // label
		fifthItem.add("report_id");   //name of field
		fifthItem.add("30");    // SIZE
		fifthItem.add("30");    //LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem=new ArrayList();

		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels"));  // label
		sixthItem.add("report_desc");   //name of field
		sixthItem.add("60");    // SIZE
		sixthItem.add("60");    //LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr

		ArrayList seventhItem = new ArrayList();
		seventhItem.add("List");   //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintApplicability.label","common_labels"));  // label
		seventhItem.add("print_at_ci_yn");//name
		seventhItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(seventhItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[6];
		String orderByColVals[] = new String[6];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels");

		orderByColVals[0] = "clinic_code";
		orderByColVals[1] = "CLINIC_DESC";
		orderByColVals[2] = "Visit_Type_Code";
		orderByColVals[3] = "VISIT_TYPE_SHORT_DESC";
		orderByColVals[4] = "report_id";
		orderByColVals[5] = "report_desc";


		strbuff = qrypg.getQueryPage(con,finAr,"Find Patient Type","../../eOP/jsp/OponlinereportsruleQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());

		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		

	}catch (Exception e) {}
	finally
	{
		if(con!=null)
		  ConnectionManager.returnConnection(con,request); 
	}
%>
