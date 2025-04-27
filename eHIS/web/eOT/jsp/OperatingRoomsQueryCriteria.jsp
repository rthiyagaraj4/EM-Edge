<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String operatingRoom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OperatingRoom.label","common_labels");
String theatreType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreType.Label","ot_labels");
String longdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String shortdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
String theatreSequenceNo =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreSequenceNo.Label","ot_labels");
String service =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
String restrictBySpecialityYN =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RestrictBySpecialityYN.Label","ot_labels");
String overBookingAllowedYN =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OverBookingAllowedYN.Label","ot_labels");


StringBuffer strbuff;

Connection con=null ;
try {

con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("List");           //Type of item
firstItem.add(theatreType);     // label
firstItem.add("theatre_type");   //name of field
firstItem.add("SELECT LOCN_TYPE code, SHORT_DESC description FROM AM_CARE_LOCN_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND CARE_LOCN_TYPE_IND = 'O'ORDER BY 1"); // SIZE

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(operatingRoom);    // label
secondItem.add("oper_room_code");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(longdescription);    // label
thirdItem.add("long_desc");  //name of field
thirdItem.add("15");   // SIZE
thirdItem.add("15");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(shortdescription);    // label
fourthItem.add("short_desc");  //name of field
fourthItem.add("15");   // SIZE
fourthItem.add("15");   //LENGTH
finAr.add(fourthItem);    //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");          //Type of item
fifthItem.add(theatreSequenceNo);    // label
fifthItem.add("oper_room_seq");  //name of field
fifthItem.add("3");   // SIZE
fifthItem.add("3");   //LENGTH
finAr.add(fifthItem);    //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   //Type of item
sixthItem.add(restrictBySpecialityYN);  // label
sixthItem.add("restrict_by_splty_yn");//name
sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(sixthItem);

ArrayList seventhItem = new ArrayList();

seventhItem.add("List");   //Type of item
seventhItem.add(overBookingAllowedYN);  // label
seventhItem.add("over_booking_allowed_yn");//name
seventhItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(seventhItem);

ArrayList eightthItem = new ArrayList();

eightthItem.add("List");           //Type of item
eightthItem.add(service);     // label
eightthItem.add("service_code");   //name of field
eightthItem.add("SELECT SERVICE_CODE code, LONG_DESC description FROM AM_SERVICE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(ANCILLARY_YN, 'N') = 'Y'AND NVL(EFF_STATUS, 'D') =  'E' ORDER BY 1"); // SIZE

finAr.add(eightthItem);//add to ArrayList obj finAr

/*ArrayList eightItem = new ArrayList();

eightItem.add("List");           //Type of item
eightItem.add("Service");     // label
eightItem.add("service_code");   //name of field
eightItem.add("SELECT SERVICE_CODE code, LONG_DESC description FROM AM_SERVICE WHERE NVL(ANCILLARY_YN, 'N') = 'Y' AND NVL(EFF_STATUS, 'D') =  'E' ORDER BY 1"); // SIZE

finAr.add(eightItem);//add to ArrayList obj finAr

ArrayList ninthItem = new ArrayList();

ninthItem.add("List");           //Type of item
ninthItem.add("Service");     // label
ninthItem.add("service_code");   //name of field
ninthItem.add("SELECT SERVICE_CODE code, LONG_DESC description FROM AM_SERVICE WHERE NVL(ANCILLARY_YN, 'N') = 'Y' AND NVL(EFF_STATUS, 'D') =  'E' ORDER BY 1"); // SIZE

finAr.add(seventhItem);//add to ArrayList obj finAr*/


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = theatreType;
	orderByCols[1] =longdescription;
	orderByCols[2] =shortdescription;
   

	orderByColVals[0] = "theatre_type";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	


strbuff = qrypg.getQueryPage( con,finAr,operatingRoom,"../../eOT/jsp/OperatingRoomsQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

