<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
String facility_id=(String) session.getAttribute("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eOT/js/StoresforOperatingRoom.js'></script>
<%@ page import ="java.util.ArrayList,webbeans.eCommon.ConnectionManager,java.sql.Connection"%>
<%
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
String operatingroom =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OperatingRoom.label","common_labels")  ;
String theatrerequestingtype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreRequestingConsumptionStore.Label","ot_labels");
String theatreissuingtype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreIssuingStore.Label","ot_labels");
String storedesc=
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","common_labels")  ;
String type=
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")  ;
String facilityname =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
String defaultstore =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DefaultStore.Label","ot_labels");
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;

String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")	;

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {
con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("List");//Type of item
firstItem.add(operatingroom);// label
firstItem.add("operating_room_code");//name of field
firstItem.add("SELECT  OPER_ROOM_CODE CODE,SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ORDER BY 2");// SIZE
finAr.add(firstItem);//add to ArrayList obj finAr
ArrayList secondItem = new ArrayList();
secondItem.add("List");          //Type of item
secondItem.add(facilityname);    // label
secondItem.add("facility_name");  //name of field
secondItem.add("SELECT 'ALL' FACILITY_ID,'ALL' FACILITY_NAME FROM DUAL UNION SELECT FACILITY_ID,FACILITY_NAME FROM   SM_FACILITY_PARAM_LANG_VW WHERE  LANGUAGE_ID  = '"+locale+"'");   // SIZE
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("List");          //Type of item
thirdItem.add(storedesc);    // label
thirdItem.add("store_desc");  //name of field
thirdItem.add("SELECT A.STORE_CODE,B.SHORT_DESC FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = '"+locale+"' AND B.EFF_STATUS ='E'");   // SIZE
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("List");          //Type of item
fourthItem.add(type);    // label
fourthItem.add("type_desc");  //name of field
fourthItem.add("%,"+select+",R,"+theatrerequestingtype+",I,"+theatreissuingtype); 
//sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);// SIZE
//fourthItem.add("Theatre Issuing Store");   // SIZE
finAr.add(fourthItem);    //add to ArrayList obj finAr*/

ArrayList fifthItem = new ArrayList();
fifthItem.add("List");          //Type of item
fifthItem.add(defaultstore);    // label
fifthItem.add("default_yn");  //name of field
fifthItem.add("%,"+both+",Y,"+yes+",N,"+no);
//sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);// SIZE
//fourthItem.add("Theatre Issuing Store");   // SIZE
finAr.add(fifthItem);    //add to ArrayList obj finAr*/


/*ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");          //Type of item
thirdItem.add(store);    // label
thirdItem.add("store_desc");  //name of field
thirdItem.add("30");   // SIZE
thirdItem.add("30");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr*/


String[] orderByCols=null;
String[] orderByColVals=null;
orderByCols = new String[4];
orderByColVals = new String[4];
orderByCols[0] = operatingroom;
orderByCols[1] = facilityname;
orderByCols[2] = storedesc;
orderByCols[3] = type;
//orderByCols[4] = defaultstore;
    
orderByColVals[0] = "D.oper_room_code";
orderByColVals[1] = "store_facility_id";
orderByColVals[2] = "short_desc";
orderByColVals[3] = "store_type";
//orderByColVals[4] = "defaultstore";
    
	
	

strbuff = qrypg.getQueryPage( con,finAr,"StoresforOperatingRoom ","../../eOT/jsp/StoresforOperatingRoomQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

