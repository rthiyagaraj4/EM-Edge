<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 



<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try {
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
String resp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");
firstItem.add("Text");  		 //Type of item
firstItem.add(resp_id);	  // label
firstItem.add("resp_id");	//name of field
firstItem.add("20");	// SIZE
firstItem.add("20");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

String resp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
secondItem.add("Text");  		 //Type of item
secondItem.add(resp_name);	  // label
secondItem.add("resp_name");	//name of field
secondItem.add("60");	// SIZE
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


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = resp_id;
orderByCols[1] = resp_name;
orderByCols[2] = fac_id;
 orderByCols[3] = fac_name;


orderByColVals[0] = "sm_resp.resp_id ";
orderByColVals[1] = "sm_resp.resp_name";
orderByColVals[2] = "sm_facility_for_resp.facility_id";
orderByColVals[3] = "sm_facility_param.facility_name";


strbuff = qrypg.getQueryPage(con,finAr,"Find Responsibility ","../jsp/queryResponsibilityForFacility.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
       strbuff.setLength(0);
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
} catch (Exception e) {}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
