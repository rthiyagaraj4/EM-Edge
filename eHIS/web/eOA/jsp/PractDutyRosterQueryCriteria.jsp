<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>

<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
String locale=(String)session.getAttribute("LOCALE");


try {
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList veryFirstItem =new ArrayList();
	veryFirstItem.add("List");
	veryFirstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
	veryFirstItem.add("care_locn_type_ind");
	veryFirstItem.add("select care_locn_type_ind,short_desc from am_care_locn_type_lang_vw where language_id ='"+locale+"' and SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y')  order by short_desc");
	finAr.add(veryFirstItem);

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	  // label
	firstItem.add("clinic_code1");	//name of field
	firstItem.add("15");	// SIZE
	firstItem.add("15");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));  // label
	secondItem.add("clinic_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList enhancedItem = new ArrayList();
	enhancedItem.add("List");
	enhancedItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels"));
	enhancedItem.add("resource_class");
	enhancedItem.add("0,  ---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---  ,P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels")+" ");
	finAr.add(enhancedItem);


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels"));
	thirdItem.add("practitioner_Id");
	thirdItem.add("15"); 
	thirdItem.add("15");
	finAr.add(thirdItem);

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels"));  // label
	fourthItem.add("practitioner_name");   //name of field
	fourthItem.add("15");	// SIZE
	fourthItem.add("15");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dayofweek.label","common_labels"));  // label
	fifthItem.add("day_of_week");//name
	fifthItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----,1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels")+",3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels")+",4,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels")+",5,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels")+",6,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels")+",7,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dayofweek.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels");

	orderByColVals[0] = "CARE_LOCN_TYPE_IND";
	orderByColVals[1] = "CLINIC_CODE";
	orderByColVals[2] = "CLINIC_NAME";
	orderByColVals[3] = "ON_DUTY_DATE";
	orderByColVals[4] = "PRACTITIONER_ID";
	orderByColVals[5] = "RESOURCE_CLASS";

	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"PractDutyRoster","../../eOA/jsp/PractDutyRosterQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString().replace("nowrap",""));
	strbuff.setLength(0);
	finAr.clear();
veryFirstItem.clear();
firstItem.clear();
secondItem.clear();
enhancedItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
} catch (Exception e){
	//out.println(e);
	e.printStackTrace();
}
finally { 
	if(con!=null) ConnectionManager.returnConnection(con,request);
}	

%>
