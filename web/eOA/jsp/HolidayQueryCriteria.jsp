<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head></html>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String fmode = request.getParameter("mode") ;
StringBuffer strbuff;
	String locale			= (String)session.getAttribute("LOCALE");

Connection con=null ;
try {
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
 
firstItem.add("List");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));	  // label
firstItem.add("locn_type");	//name of field
firstItem.add("Select care_locn_type_ind, Short_Desc from am_care_locn_type_lang_vw where language_id = '"+locale+"' and sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2");

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));  // label
secondItem.add("clinic_code");   //name of field
secondItem.add("4");	// SIZE
secondItem.add("4");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList verysecondItem=new ArrayList();

verysecondItem.add("Text");  //Type of item
verysecondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));  // label
verysecondItem.add("clinic_desc");   //name of field
verysecondItem.add("15");	// SIZE
verysecondItem.add("15");	//LENGTH

finAr.add(verysecondItem); //add to ArrayList obj finAr




ArrayList fifthItem=new ArrayList();

fifthItem.add("Date");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HolidayDate.label","common_labels"));  // label10
fifthItem.add("holiday_date");   //name of field
fifthItem.add("10");
fifthItem.add("10");

finAr.add(fifthItem); //add to ArrayList obj finAr




String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");

orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HolidayDate.label","common_labels");


orderByColVals[0] = "a.care_locn_type_ind";
orderByColVals[1] = "locn_code";
orderByColVals[2] = "b.long_desc";
orderByColVals[3] = "holiday_date";


strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"eCIS Testing","../../eOA/jsp/HolidayQueryResult.jsp?mode="+fmode,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));
strbuff.setLength(0);
finAr.clear();
fifthItem.clear();
verysecondItem.clear();
secondItem.clear();
firstItem.clear();


} catch (Exception e) {}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
<script>

</script>

