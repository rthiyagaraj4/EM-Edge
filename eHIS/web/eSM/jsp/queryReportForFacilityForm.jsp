<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null;
		try{
        request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String module = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
		String reportId = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels");
		String reportDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels");
		String facilityId = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
		String facilityName = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
		String reportGroupID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ReportGroupID.label","sm_labels");
		String reportGroupDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ReportGroupDesc.label","sm_labels");
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  		 //Type of item
		firstItem.add(module);	  // label
		firstItem.add("Module_Id");	//name of field
		firstItem.add("Select distinct a.Module_Id module_id,a.module_name module_name from Sm_Module a,sm_report b where Install_Yn='Y' and facility_based_yn='Y' and b.module_id=a.module_id order by module_name ");	// SIZE


		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");  		 //Type of item
		secondItem.add(reportId);	  // label
		secondItem.add("Report_ID");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(reportDesc);	  // label
		thirdItem.add("Report_Desc");	//name of field
		thirdItem.add("60");	// SIZE
		thirdItem.add("60");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(facilityId);	  // label
		fourthItem.add("Facility_ID");	//name of field
		fourthItem.add("2");	// SIZE
		fourthItem.add("2");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");  		 //Type of item
		fifthItem.add(facilityName);	  // label
		fifthItem.add("Facility_Name");	//name of field
		fifthItem.add("70");	// SIZE
		fifthItem.add("35");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();

		sixthItem.add("Text");  		 //Type of item
		sixthItem.add(reportGroupID);	  // label
		sixthItem.add("Report_Group_ID");	//name of field
		sixthItem.add("8");	// SIZE
		sixthItem.add("8");	//LENGTH

		finAr.add(sixthItem);//add to ArrayList obj finAr

		ArrayList seventhItem = new ArrayList();

		seventhItem.add("Text");  		 //Type of item
		seventhItem.add(reportGroupDesc);	  // label
		seventhItem.add("Report_Group_Desc");	//name of field
		seventhItem.add("15");	// SIZE
		seventhItem.add("15");	//LENGTH

		finAr.add(seventhItem);//add to ArrayList obj finAr

		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];


		orderByCols[0] = module;
		orderByCols[1] = reportId;
		orderByCols[2] = reportDesc;
		orderByCols[3] = facilityId;
		orderByCols[4] = facilityName;
		orderByCols[5] = reportGroupID;
		orderByCols[6] = reportGroupDesc;


		orderByColVals[0] = "Module_name";
		orderByColVals[1] = "Report_Id";
		orderByColVals[2] = "Report_desc";
		orderByColVals[3] = "Facility_id";
		orderByColVals[4] = "Facility_Name";
		orderByColVals[5] = "report_group_id";
		orderByColVals[6] = "REPORT_GROUP_NAME";


		strbuff = qrypg.getQueryPage(con,finAr,"Find Facility Based Report Parameters ","../jsp/queryReportForFacilityTable.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());

		strbuff.setLength(0);
		finAr.clear();
        firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();

		}catch(Exception e){out.println(e);}

finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
