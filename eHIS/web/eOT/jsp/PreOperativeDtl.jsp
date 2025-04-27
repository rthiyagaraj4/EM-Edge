<!DOCTYPE html>
<%//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*" %>
<%//@ contentType="text/html;charset=" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.util.ArrayList,java.util.HashMap,java.util.Properties,eOT.Common.OTRepository*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.util.HashMap,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script> 
<script src='../../eOT/js/PreOperative.js' language='javascript'></script>
<!--<script src='../../eOA/js/oamessages.js' language='javascript'></script>-->
<script language='javascript'>
 function changeType(obj)
 {

	if(obj.db_type=='S')	  obj.db_type='D';
	else if(obj.db_type=='D') obj.db_type='S';
	else if(obj.db_type=='N') obj.db_type='I';
	else if(obj.db_type=='I') obj.db_type='N';
 }
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='PreoperativeDtlForm' id='PreoperativeDtlForm' action='' method = 'post'>

<table  border='1' width='100%' cellpadding="3" cellspacing=0>
<tr>
		<th class='columnHeader' nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>		
		<th class='columnHeader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String facilityid=(String)session.getValue("facility_id");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	String strOrderAt="";
//	String strPriority="";
	String strOrderType="";
	String strOrderCatalog="";
	String strOrderBy="";
	String strOrderId="";
	String strOrderLineNo="";
	String strOrderTypeCode="";
	String strCombineData="";
	String strStatus="";
	String strQuery="";
	int fetchCount=0;
	String strOrderCategry="";

	String strPatientId="";
	String strBookingNum="";
	HashMap hashOrder=new HashMap();
	
	conn = ConnectionManager.getConnection(request);


try{

strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));
strBookingNum=CommonBean.checkForNull(request.getParameter("booking_no"));

sql="SELECT ORDER_ID ORDER_ID1, ORDER_LINE_NUM ORDER_LINE_NUM1 FROM OT_BOOKING_LINKED_ORDERS WHERE FACILITY_ID = ? AND 	 PATIENT_ID		=  ? AND	 APPT_REF_NUM	= ?";




pstmt=conn.prepareCall(sql);


	pstmt.setString(1,facilityid);
	pstmt.setString(2,strPatientId);
	pstmt.setString(3,strBookingNum);
	rs=pstmt.executeQuery();


	while(rs.next())
	{
		fetchCount++;
		strOrderId=rs.getString("ORDER_ID1");
		strOrderLineNo=rs.getString("ORDER_LINE_NUM1");
        hashOrder.put(strOrderId,strOrderLineNo);		 
		strCombineData=strOrderId+","+strOrderLineNo;
		hashOrder.put(""+fetchCount,strCombineData);
	}


	fetchCount=0;
	rs.close();
	pstmt.close();

 sql=request.getParameter("sql");
// System.err.println("PreOperativeDtl.jsp SQL in Line no 93 is ------------> "+sql);
 pstmt=conn.prepareCall(sql);
//eOT.LogFile.log("OTDebugger","sql value"+sql,this);
rs=pstmt.executeQuery();

while(rs.next())
{
fetchCount++;
strOrderAt=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORD_DATE_TIME1"),"DMYHM","en",locale));
strOrderCategry=CommonBean.checkForNull(rs.getString("ORDER_CATEGORY1"));
//strPriority=CommonBean.checkForNull(rs.getString("PRIORITY_DESC1"));
strOrderLineNo=CommonBean.checkForNull(rs.getString("ORDER_LINE_NUM1"));
strOrderType=CommonBean.checkForNull(rs.getString("ORDER_TYPE_DESC1"));
strOrderTypeCode=CommonBean.checkForNull(rs.getString("ORDER_TYPE_CODE1"));
strOrderCatalog=CommonBean.checkForNull(rs.getString("ORDER_CATALOG_DESC1"));
strOrderBy=CommonBean.checkForNull(rs.getString("ORDERED_BY1"));	
strStatus=CommonBean.checkForNull(rs.getString("ORDER_STATUS_DESC1"));
strOrderId=CommonBean.checkForNull(rs.getString("ORDER_ID1"));


//eOT.LogFile.log("OTDebugger","OrderId"+strOrderId,this);


if(fetchCount%2==0)		strQuery="class='gridData'";
else		strQuery="class='gridData'";

out.println("<tr>");


out.println("<td "+strQuery+" class='"+strQuery+"'>"+strOrderCategry+"</td>");
out.println("<td "+strQuery+" class='"+strQuery+"'>"+strOrderAt+"&nbsp;</td>");
out.println("<td "+strQuery+" class='"+strQuery+"'>"+strOrderType+"</td>");
out.println("<td "+strQuery+" class='"+strQuery+"'>"+strOrderCatalog+"</td>");
out.println("<td "+strQuery+" class='"+strQuery+"'>"+strOrderBy+"</td>");
out.println("<td "+strQuery+" class='"+strQuery+"'>"+strStatus+"</td>");
out.println("<td "+strQuery+" class='"+strQuery+"'>");
if(hashOrder.containsValue(strOrderId+","+strOrderLineNo)==true)	
	{
out.println("<input type='checkbox' name='chk"+fetchCount+"' id='chk"+fetchCount+"' db_type=\"S\"  OnClick=\"changeType(this,'"+fetchCount+"');\" checked></td>");
	}
else
	{
	out.println("<input type='checkbox' name='chk"+fetchCount+"' id='chk"+fetchCount+"' db_type=\"N\" OnClick='changeType(this);' ></td>");
	}

out.println("<input type='hidden' name='orderid"+fetchCount+"' id='orderid"+fetchCount+"'value='"+strOrderId+"'>");
out.println("<input type='hidden' name='lineno"+fetchCount+"' id='lineno"+fetchCount+"' value='"+strOrderLineNo+"'>");
out.println("<input type='hidden' name='order_code"+fetchCount+"' id='order_code"+fetchCount+"' value='"+strOrderTypeCode+"'>");



out.println("</tr>");
	}

if(fetchCount==0)	 out.println("<script>callNoRecord();</script>");

}catch(Exception ee) 
{
	ee.printStackTrace();
//eOT.LogFile.log("OTDebugger","Exception "+ee,this);
}
finally{
	hashOrder=null;
	rs.close();
	pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}
////eOT.LogFile.log("OTDebugger","Finish process",this);	 
%>
 </table>
 <input type='hidden' name='patient_id' id='patient_id' value="<%=strPatientId%>">
 <input type='hidden' name='booking_no' id='booking_no' value="<%=strBookingNum%>">
 <input type='hidden' name='maxno' id='maxno' value="<%=fetchCount%>">
 <input type='hidden' name='param1' id='param1' value="<%=request.getQueryString()%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
 </form>
 </body>
 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
	</div>
</html>

