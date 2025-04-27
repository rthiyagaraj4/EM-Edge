<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
//	con = (Connection) session.getValue( "connection" );
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
String user_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
firstItem.add("Text");  		 //Type of item
firstItem.add(user_id);	  // label
firstItem.add("user_id");	//name of field
firstItem.add("30");	// SIZE
firstItem.add("30");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
String user_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
secondItem.add("Text");  		 //Type of item
secondItem.add(user_name);	  // label
secondItem.add("username");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("60");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
String fac_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
thirdItem.add("Text");  		 //Type of item
thirdItem.add(fac_id);	  // label
thirdItem.add("facilityid");	//name of field
thirdItem.add("2");	// SIZE
thirdItem.add("2");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();
String fac_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
fourthItem.add("Text");  		 //Type of item
fourthItem.add(fac_name);	  // label
fourthItem.add("facilityname");	//name of field
fourthItem.add("70");	// SIZE
fourthItem.add("35");	//LENGTH

finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
String emp_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmployeeNo.label","common_labels");
fifthItem.add("Text");  		 //Type of item
fifthItem.add(emp_no);	  // label
fifthItem.add("emp_no");	//name of field
fifthItem.add("10");	// SIZE
fifthItem.add("10");	//LENGTH

finAr.add(fifthItem);//add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = user_id;
orderByCols[1] = user_name;
orderByCols[2] = fac_id;
orderByCols[3] = fac_name;

orderByColVals[0] = "sm_facility_for_user.appl_user_id";
orderByColVals[1] = "sm_appl_user.appl_user_name";
orderByColVals[2] = "sm_facility_for_user.facility_id";
orderByColVals[3] = "sm_facility_param.facility_name";


strbuff = qrypg.getQueryPage(con,finAr,"Find Facility ","../jsp/queryFacilityForUser.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

strbuff.setLength(0);
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();

} catch (Exception e) {}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
