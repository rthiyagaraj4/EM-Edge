<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Locn_Data		= new ArrayList() ;

	String[] record				= null;
	//String sql_locn="Select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="Select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	try {

		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
 String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
 String al1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");

		ArrayList finAr = new ArrayList();

		ArrayList ZeroItem = new ArrayList();

		ZeroItem.add("List");  		 //Type of item
		ZeroItem.add(locationtype);	  // label
		ZeroItem.add("locn_type");	//name of field
		String strList = " "+","+"----"+al1+"----"+",";
		for(int k=0;k<Locn_Data.size();k++)	{
			record=(String[])Locn_Data.get(k);
			strList = strList + (String)record[0] + ","+(String)record[1]+",";
		} 
		

		ZeroItem.add(strList);
		ZeroItem.add("5");
		finAr.add(ZeroItem); //add to ArrayList obj finAr
String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(WorkplaceCode);	  // label
		firstItem.add("WORKPLACE_CODE");	//name of field
		firstItem.add("10"); //size
		firstItem.add("10"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");   //Type of item
		secondItem.add(WorkplaceDescription); //label
		secondItem.add("workplace_desc");//name
		secondItem.add("20"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

String Role= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");

String practitioner= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
String OtherStaff= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaff.label","common_labels");
String all= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");



		ArrayList thirdItem = new ArrayList();

		thirdItem.add("List");   //Type of item
		thirdItem.add(Role);  // label
		thirdItem.add("role_type");//name
		//String strList1 = "%"+","+"----all----"+",";
		String strList1 = "%"+","+all+",";
		strList1 = strList1+"P"+","+practitioner+",";
		strList1 = strList1+"O"+","+OtherStaff+",";
		thirdItem.add(strList1);
		finAr.add(thirdItem); //add to ArrayList obj finAr

String StaffId= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.StaffId.label","rs_labels");

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");   //Type of item
		fourthItem.add(StaffId);  // label
		fourthItem.add("staff_id");//name
		fourthItem.add("15"); //size
		fourthItem.add("15");  //maxlength
		finAr.add(fourthItem); //add to ArrayList obj finAr
String StaffName= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.StaffName.label","rs_labels");


		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");   //Type of item
		fifthItem.add(StaffName);  // label
		fifthItem.add("staff_name");//name
		fifthItem.add("30"); //size
		fifthItem.add("30");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[6];
		String orderByColVals[] = new String[6];

		orderByCols[0] = locationtype;
		orderByCols[1] = WorkplaceCode;
		orderByCols[2] = WorkplaceDescription;
		orderByCols[3] = Role;
		orderByCols[4] = StaffId;
		orderByCols[5] = StaffName;

		orderByColVals[0] = "locn_desc";
		orderByColVals[1] = "workplace_code";
		orderByColVals[2] = "workplace_desc";
		orderByColVals[3] = "role";
		orderByColVals[4] = "staff_id";
		orderByColVals[5] = "staff_name";


		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String FindSkillForPosition=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindSkillForPosition.label","RS_labels");





		
		strbuff = qrypg.getQueryPage(con,finAr,FindSkillForPosition,"../jsp/StaffForWorkplaceQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());

	} catch (Exception e) {
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
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
