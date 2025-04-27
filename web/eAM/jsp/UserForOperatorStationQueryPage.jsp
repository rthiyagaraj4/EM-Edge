<!DOCTYPE html>
<%--
	FileName	: UserForOperatorStationQuerypage.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {

con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList sixthItem = new ArrayList();
sixthItem.add("Text");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));  // label
sixthItem.add("facility_id");//name
sixthItem.add("2");
sixthItem.add("2");
finAr.add(sixthItem); //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();
seventhItem.add("Text");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  // label
seventhItem.add("facility_name");//name
seventhItem.add("70");
seventhItem.add("35");
finAr.add(seventhItem); //add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
firstItem.add("stn_id");	//name of field
firstItem.add("30");	// SIZE
firstItem.add("30");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("stn_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));  // label
thirdItem.add("user_id");   //name of field
thirdItem.add("30");	// SIZE
thirdItem.add("30");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("Text");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));  // label
fifthItem.add("user_name");//name
fifthItem.add("30");
fifthItem.add("30");
finAr.add(fifthItem); //add to ArrayList obj finAr





String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");

orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");

orderByColVals[0] = "facility_id";
orderByColVals[1] = "facility_name";
orderByColVals[2] = "oper_stn_id";
orderByColVals[3] = "short_desc";
orderByColVals[4] = "appl_user_id";
orderByColVals[5] = "appl_user_name";




strbuff = qrypg.getQueryPage(con,finAr,"Find User for Operator Station","../../eAM/jsp/queryUserForOperatorStation.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

finAr.clear();
	firstItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fifthItem.clear();

} catch (Exception e) {}

finally{
	ConnectionManager.returnConnection(con,request);
}
%>
