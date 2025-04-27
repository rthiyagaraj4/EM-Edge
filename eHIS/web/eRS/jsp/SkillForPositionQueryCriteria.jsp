<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<% 
request.setCharacterEncoding("UTF-8");
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
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	Connection con=null ;

	try {
		con = ConnectionManager.getConnection(request);
		String PositionCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.PositionCode.label","rs_labels");
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(PositionCode);	  // label
		firstItem.add("position_code");	//name of field
		firstItem.add("10"); //size
		firstItem.add("10"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

		String PositionDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.PositionDescription.label","rs_labels");
		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");   //Type of item
		secondItem.add(PositionDescription); //label
		secondItem.add("position_desc");//name
		secondItem.add("20"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr



		String RoleType= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Practitioner_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		String OtherStaff_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffType.label","common_labels");
		String list_values="%,"+Both_legend+",P,"+Practitioner_legend+",O,"+OtherStaff_legend;
		ArrayList thirdItem = new ArrayList();

		thirdItem.add("List");   //Type of item
		thirdItem.add(RoleType);  // label
		thirdItem.add("role_type");//name
		thirdItem.add(list_values);
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String SkillCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.SkillCode.label","rs_labels");
		
		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");   //Type of item
		fourthItem.add(SkillCode);  // label
		fourthItem.add("skill_code");//name
		fourthItem.add("5"); //size
		fourthItem.add("4");  //maxlength
		finAr.add(fourthItem); //add to ArrayList obj finAr
		
		String SkillDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.SkillDescription.label","rs_labels");
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");   //Type of item
		fifthItem.add(SkillDescription);  // label
		fifthItem.add("skill_desc");//name
		fifthItem.add("20"); //size
		fifthItem.add("30");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = PositionCode;
		orderByCols[1] = PositionDescription;
		orderByCols[2] = RoleType;
		orderByCols[3] = SkillCode;
		orderByCols[4] = SkillDescription;

		orderByColVals[0] = "position_code";
		orderByColVals[1] = "position_desc";
		orderByColVals[2] = "role_type_desc";
		orderByColVals[3] = "skill_code";
		orderByColVals[4] = "skill_desc";


		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

		strbuff = qrypg.getQueryPage(con,finAr,"Find Skill For Position","../jsp/SkillForPositionQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect,orderBy,orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	} catch (Exception e) {out.println(e.toString());}
	finally{
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
