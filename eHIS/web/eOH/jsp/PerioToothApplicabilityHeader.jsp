<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql = "";
    String params = request.getQueryString() ;
	
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//
	
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eOH/js/PerioToothApplicability.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
try{
	con=ConnectionManager.getConnection(request);

	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	//Based on the Chart Level the paramters need to be taken.
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

	pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
	}
%>
<body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="PerioToothApplicabilityHeader" id="PerioToothApplicabilityHeader"> 

<table width="65%"  cellpadding =10 cellspacing=0  align="center">
   <tr>
   <td class=label width="25%" nowrap><fmt:message key="Common.ChartID.label" bundle="${common_labels}"/></td>
	    <td class="fields" width="25%"  align="left">
               <select name='chart' id='chart' onChange='showRecords()'> 
			     <option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				  <%          
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT CHART_CODE, CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE EFF_STATUS = 'E' ORDER BY CHART_DESC";
								pstmt=con.prepareStatement(sql);
							    rs=pstmt.executeQuery();
								while(rs.next()){
									
				 %>
					
				<option value='<%=rs.getString("CHART_CODE")%>'><%=rs.getString("CHART_DESC")%></option>
				<%} %>
			   </select>
        </td>
   </tr>
 </table>
 <input type="hidden" name="params" id="params" value="<%=params%>">
 <input type="hidden" name="locale" id="locale" value="<%=locale%>">
 <!-- Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->
 <input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
 

</form>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

