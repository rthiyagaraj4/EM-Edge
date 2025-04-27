<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
    con  =  ConnectionManager.getConnection(request);
	String pfunctionID=request.getParameter("procID");
    if(pfunctionID==null)pfunctionID="";

ArrayList finAr = new ArrayList();
ArrayList seventhItem=new ArrayList();
if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
seventhItem.add("List");
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));
seventhItem.add("proc_type");
seventhItem.add("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2");
finAr.add(seventhItem);
    }

ArrayList firstItem = new ArrayList();

firstItem.add("Text");//Type of item
if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));
	firstItem.add("proc_code");
	}
 else{
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels"));    // label
firstItem.add("clinic_code");   //name of field
 }
firstItem.add("4"); // SIZE
firstItem.add("4"); //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
	
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));
	secondItem.add("proc_name");
	}else{
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicDescription.label","common_labels"));   // label
secondItem.add("clinic_name");  //name of field
	}
secondItem.add("20");   // SIZE
secondItem.add("20");   //LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr
ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");           //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels"));    // label
thirdItem.add("visit_type_code");   //name of field
thirdItem.add("2"); // SIZE
thirdItem.add("2"); //LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels"));   // label
fourthItem.add("visit_type_desc");  //name of field
fourthItem.add("20");   // SIZE
fourthItem.add("20");   //LENGTH

finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("nature");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();
sixthItem.add("Hidden");   //Type of item
sixthItem.add("pid");// Name


if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
   	sixthItem.add("visit_type_for_proc_unit");//Value
	}
else
    sixthItem.add("clinic");

finAr.add(sixthItem);


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
    orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	}else{
orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicDescription.label","common_labels");
	}
orderByColVals[0] = "clinic_code";
orderByColVals[1] = "clinic_short_desc";
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels");
orderByColVals[2] = "visit_type_code";
orderByColVals[3] = "visit_type_short_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Visit Type For Clinic","../../eOP/jsp/queryVisitTypeForClinic.jsp?pid="+pfunctionID,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventhItem.clear();
finAr.clear();
} catch (Exception e) {
	e.printStackTrace();
	}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

