<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>
<%
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eFM/js/HolidayForMrd.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head><body onMouseDown = "CodeArrest();" onKeyDown = 'lockKey();'></body></html>


<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String operation=request.getParameter("operation")==null?"multipledelete":request.getParameter("operation") ;
StringBuffer strbuff;
	String locale			= (String)session.getAttribute("LOCALE");

Connection con=null ;
try {
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem=new ArrayList();

firstItem.add("Text");  //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.MrdCode.label","common_labels"));  // label
firstItem.add("fs_locn_code");   //name of field
firstItem.add("8");	// SIZE
firstItem.add("8");	//LENGTH

finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.MrdDescription.label","fm_labels"));  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr




ArrayList thirdItem=new ArrayList();

thirdItem.add("Date");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HolidayDate.label","fm_labels"));  // label10
thirdItem.add("holiday_date");   //name of field
thirdItem.add("10");
thirdItem.add("10");

finAr.add(thirdItem); //add to ArrayList obj finAr




String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HolidayDate.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.MrdCode.label","fm_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.MrdDescription.label","fm_labels");



orderByColVals[0] = "a.holiday_date";
orderByColVals[1] = "a.fs_locn_code";
orderByColVals[2] = "b.long_desc";



strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"FMHolidy Finding","../../eFM/jsp/HolidayForMrdQueryResult.jsp?operation="+operation,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
finAr.clear();
//fifthItem.clear();
thirdItem.clear();
secondItem.clear();
firstItem.clear();


} catch (Exception e) {
   e.printStackTrace();
}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
<script>

</script>

