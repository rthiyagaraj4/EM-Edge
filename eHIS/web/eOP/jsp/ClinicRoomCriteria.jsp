<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" contentType="text/html;charset=UTF-8" %>
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

try {
	con = ConnectionManager.getConnection(request);;
    

ArrayList finAr = new ArrayList();

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  	     //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels"));	// label
thirdItem.add("clinic_code");  //name of field
thirdItem.add("4");			  // SIZE
thirdItem.add("4");			 //LENGTH
finAr.add(thirdItem);	    //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicDescription.label","common_labels"));	 // label
fourthItem.add("clinic_desc");	 //name of field
fourthItem.add("15");			 // SIZE
fourthItem.add("15");			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();

firstItem.add("Text");   		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels"));     // label
firstItem.add("room");   	 //name
firstItem.add("4");			// SIZE
firstItem.add("4");			//LENGTH
finAr.add(firstItem); 			 //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");   		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RoomDescription.label","op_labels"));     // label
secondItem.add("room_desc");   	 //name
secondItem.add("15");			// SIZE
secondItem.add("15");			//LENGTH
finAr.add(secondItem); 			 //add to ArrayList obj finAr




ArrayList fifthItem = new ArrayList();

fifthItem.add("List");  		       //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  		       // label
fifthItem.add("eff_status");		       //name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));  //static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); 			       //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicDescription.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RoomDescription.label","op_labels");



orderByColVals[0] = "clinic_code";
orderByColVals[1] = "clinic_short_desc";
orderByColVals[2] = "room_no";
orderByColVals[3] = "room_short_desc";




strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/ClinicRoomQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

finAr.clear();
thirdItem.clear();
fourthItem.clear();
firstItem.clear();
secondItem.clear();
fifthItem.clear();

}catch (Exception e) {}
finally{		
		if(con != null)
		ConnectionManager.returnConnection(con,request);
	}
%>
