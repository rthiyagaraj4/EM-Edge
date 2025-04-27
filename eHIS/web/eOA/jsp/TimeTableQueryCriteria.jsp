<!DOCTYPE html>
 
<!--
	Developed by 	:	R.Nanda Kumar
	Created on 	:	26/02/2001
	Module		:	OA
	Function	:
-->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>

<%
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
			String fmode = request.getParameter("mode") ;
			StringBuffer strbuff;
			Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();
	ArrayList veryFirstItem =new ArrayList();
	veryFirstItem.add("List");
	veryFirstItem.add("Location");
	veryFirstItem.add("care_locn_type_ind");
	veryFirstItem.add("Select care_locn_type_ind, Short_Desc from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2");
	finAr.add(veryFirstItem);


	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add("Location Code");	  // label
	firstItem.add("clinic_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add("Location Description");  // label
	secondItem.add("clinic_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList enhancedItem = new ArrayList();
	enhancedItem.add("List");
	enhancedItem.add("Resource Class");
	enhancedItem.add("resource_class");
	enhancedItem.add("0,  ---Select---  ,P,Practitioner,E,Equipment,R,Room,O,Other");
	finAr.add(enhancedItem);

	ArrayList thirdItem=new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add("Resource Id");  // label
	thirdItem.add("practitioner_id");   //name of field
	thirdItem.add("15");	// SIZE
	thirdItem.add("15");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem=new ArrayList();

	fourthItem.add("Text");  //Type of item
	fourthItem.add("Resource");  // label
	fourthItem.add("practitioner_name");   //name of field
	fourthItem.add("30");	// SIZE
	fourthItem.add("30");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();

	fifthItem.add("List");  //Type of item
	fifthItem.add("Day Code");  // label
	fifthItem.add("day_code");   //name of field
	fifthItem.add("select day_no,day_of_week from sm_day_of_week order by 1");



	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem=new ArrayList();

	sixthItem.add("List");  //Type of item
	sixthItem.add("Time Table Type");  // label
	sixthItem.add("time_table_type");   //name of field
	sixthItem.add("0, --- Select --- ,1,Slot,2,Slab,3,Free Format");

	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem=new ArrayList();

	seventhItem.add("List");  //Type of item
	seventhItem.add("Roster Required");  // label
	seventhItem.add("phys_roster_reqd_yn");   //name of field
	seventhItem.add("0, --- Select --- ,Y,Yes,N,No");

	finAr.add(seventhItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[8];
	String orderByColVals[] = new String[8];
	orderByCols[0] = "Location";
	orderByCols[1] = "Resource Class";
	orderByCols[2] = "Location Code";
	orderByCols[3] = "Location Desc";
	orderByCols[4] = "ResourceId";
	orderByCols[5] = "ResourceName";
	orderByCols[6] = "Day Code";
	orderByCols[7] = "Time Table Type";
	orderByColVals[0] = "care_locn_type_ind";
	orderByColVals[1] = "resource_class";
	orderByColVals[2] = "clinic_code";
	orderByColVals[3] = "clinic_name";
	orderByColVals[4] = "practitioner_id";
	orderByColVals[5] = "practitioner_name";
	orderByColVals[6] = "day_no";
	orderByColVals[7] = "time_table_type";
	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"eCIS Testing","../../eOA/jsp/TimeTableQueryResult.jsp?mode="+fmode,"Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	strbuff.setLength(0);
	finAr.clear();
	veryFirstItem.clear();
	firstItem.clear();
	secondItem.clear();
	enhancedItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();

} catch (Exception e) {
	//out.println(e);
	 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>

