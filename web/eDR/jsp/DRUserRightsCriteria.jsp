<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
	Connection con = null;

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	
	try
	{
		con = ConnectionManager.getConnection(request); ;
	
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));	   //label
		firstItem.add("appl_user_id");	//name of field
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");  		// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));	   //label
		secondItem.add("appl_user_name");	//name of field
		secondItem.add("30");	 //SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList empItem = new ArrayList();

		empItem.add("Text");  		// Type of item
		empItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmployeeNo.label","common_labels"));	   //label
		empItem.add("employee_no");	//name of field
		empItem.add("6");	 //SIZE
		empItem.add("6");	//LENGTH

		finAr.add(empItem);//add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels"));  // label
		thirdItem.add("search_privilege_level");   //name of field
		thirdItem.add("S,"+"---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LoggedinFacility.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllFacilities.label","common_labels"));	 

		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("List");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDR.IdentifyMainDuplicates.label","dr_labels")); //  label
		fourthItem.add("identify_privilege_level");  // name of field
		fourthItem.add("S,"+"---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LoggedinFacility.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllFacilities.label","common_labels"));
		thirdItem.add("6");//	LENGTH

		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();

		fifthItem.add("List");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDR.Merge.label","dr_labels"));   //label
		fifthItem.add("merge_privilege_level"); //  name of field
		fifthItem.add("S,"+"---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LoggedinFacility.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllFacilities.label","common_labels"));

		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();

		sixthItem.add("List"); // Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Administer.label","common_labels"));  // label
		sixthItem.add("administer_privilege_level");   //name of field
		sixthItem.add("S,"+"---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LoggedinFacility.label","dr_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllFacilities.label","common_labels"));
		finAr.add(sixthItem); //add to ArrayList obj finAr

		ArrayList seventhItem = new ArrayList();

		seventhItem.add("List");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  /// label
		seventhItem.add("eff_status");  // name of field
		seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as 

		finAr.add(seventhItem); //add to ArrayList obj finAr

		String orderByCols[]	= new String[7];
		String orderByColVals[]	= new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmployeeNo.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDR.IdentifyMainDuplicates.label","dr_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDR.Merge.label","dr_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Administer.label","common_labels");

		orderByColVals[0] = "appl_user_id";
		orderByColVals[1] = "appl_user_name";
		orderByColVals[2] = "employee_no";
		orderByColVals[3] = "search_privilege_level";
		orderByColVals[4] = "identify_privilege_level";
		orderByColVals[5] = "merge_privilege_level";
		orderByColVals[6] = "administer_privilege_level";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Department","../../eDR/jsp/DRUserRightsResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		empItem.clear();
		finAr.clear();
	}
	catch(Exception e) 
	{
		out.println("Exception e:"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

