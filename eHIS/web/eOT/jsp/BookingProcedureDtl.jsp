<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean,eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</link>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name=existing_order_hdg>
<table class='grid' border='1' cellpadding=3 cellspacing='0'  width='100%' >
	<tr>
		<th class='columnHeaderCenter' nowrap><fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/></th>		
		<th class='columnHeaderCenter' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>		
		<th class='columnHeaderCenter' nowrap><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/></th>		 
		<th class='columnHeaderCenter' nowrap><fmt:message key="Common.duration.label" bundle="${common_labels}"/></th>
		<!--<td class='columnHeaderCenter' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>-->

		<!-- Modified by DhanasekarV against incident 29473 -->
		<th class='columnHeaderCenter' nowrap><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/></th>
		
	</tr>

<%
	String strOperationCode="",strOperationDesc="",strRightLeftFlag="",strDuration="",strRemarks="",sql="",strFacilityId="",strBookingNo="",strQuery="",strMultipleOperYN="",strFinalDuration="",start_time="",end_time="",tot_hr1="",tot_hr2="",tot_min1="",tot_min2="",tot_time="";
	int tot_hr=0;
	int tot_min=0;
	int fetchCount=0;

	strFacilityId=CommonBean.checkForNull(request.getParameter("facility_id"));
	strBookingNo=CommonBean.checkForNull(request.getParameter("booking_no"));
	start_time=CommonBean.checkForNull(request.getParameter("start_time"));
	end_time=CommonBean.checkForNull(request.getParameter("end_time"));
	String startTime = CommonBean.checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String endTime = CommonBean.checkForNull(request.getParameter("endTime"));
	String function_id=request.getParameter("function_id");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	int hour=0,min=0;

	String strHour,strMin;
	sql=OTRepository.getOTKeyValue("SQL_OT_BOOKING_DTL_SELECT1");
	try
	{
	if(rs!=null)	rs.close();
	if(pstmt!=null)   pstmt.close();
	conn = ConnectionManager.getConnection(request);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,strFacilityId);
	pstmt.setString(3,strBookingNo);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
	hour=Integer.parseInt(rs.getString("HOUR1"));
	min=Integer.parseInt(rs.getString("MIN1"));
	}
	if(rs!=null)	rs.close();
	if(pstmt!=null)   pstmt.close();
	hour+=min/60;
	min%=60;
	strHour="";
	strMin="";

	if(hour<10)	  strHour="0"+hour;
	else	 strHour+=hour;
	if(min <10) strMin="0"+min;
	else
		 strMin=""+min;

	strFinalDuration=strHour+":"+strMin;
	sql=OTRepository.getOTKeyValue("SQL_OT_PROCEDUREDTLS_SELECT1");
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,strFacilityId);
	pstmt.setString(3,strBookingNo);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
	fetchCount++;
	strOperationCode=CommonBean.checkForNull(rs.getString("OPER_CODE1"));
	strOperationDesc=CommonBean.checkForNull(rs.getString("OPER_DESC"));//MMS-QH-CRF-0199
	strRightLeftFlag=CommonBean.checkForNull(rs.getString("APPL_RIGHT_LEFT_FLAG1"));
	strDuration=CommonBean.checkForNull(rs.getString("OPER_DURN1"));
	strRemarks=CommonBean.checkForNull(rs.getString("OPER_REMARKS1"));

	%><tr><%
	if((fetchCount%2)==0)	 strQuery="gridData";
	else	 strQuery="gridData";

	%><td  class='<%=strQuery%>' nowrap><%=strOperationCode%>&nbsp;</td>
	<td  class='<%=strQuery%>' nowrap><%=strOperationDesc%>&nbsp;</td>
	<td  class='<%=strQuery%>' nowrap><%=strRightLeftFlag%>&nbsp;</td>
	<td  class='<%=strQuery%>' nowrap><%=strDuration%>&nbsp;</td><%
	/*out.println("<td  class='"+strQuery+"' nowrap><input type='hidden' name='REMARKS"+fetchCount+"' id='REMARKS"+fetchCount+"' value=\""+strRemarks+"\"><a  href=\"javascript:showRemarks(document.forms[0].REMARKS"+fetchCount+",'0')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</a></td>");*/
	//Modified by DhanasekarV against comments 29473
	out.println("<td  class='"+strQuery+"' nowrap><input type='hidden' name='REMARKS"+fetchCount+"' id='REMARKS"+fetchCount+"' value=\""+strRemarks+"\"><a  href=\"javascript:showRemarks(document.forms[0].REMARKS"+fetchCount+",'0')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreOperativeComments.Label","common_labels")+"</a></td>");

	%></tr><%
	if(strDuration.length()>0){
	String arr[]=strDuration.split(":"); 
	tot_hr1=arr[0];
	tot_min1=arr[1];
	}
	else
	{
	tot_hr1="0";
	tot_min1="0";
	}
	tot_min+=Integer.parseInt(tot_min1);
	tot_hr+=Integer.parseInt(tot_hr1)+(tot_min/60);
	tot_min%=60;
	}
	if(tot_hr<=9) 
		tot_hr2="0"+tot_hr;
	else 
		tot_hr2=""+tot_hr;

	if(tot_min<=9) 
		tot_min2="0"+tot_min;
	else	
		tot_min2=""+tot_min;
	 tot_time=tot_hr2+":"+tot_min2;

	}catch(Exception ee)
		{
		}
		finally{
			if(rs!=null) rs.close();
			pstmt.close();
			ConnectionManager.returnConnection(conn, request);	
		}

		if(fetchCount > 1)	   strMultipleOperYN="Y";
		   else	   strMultipleOperYN="N";

	%>	
</table>
<input type='hidden' name='oper_code' id='oper_code' value="<%=strOperationCode%>">
<input type='hidden' name='oper_multiple' id='oper_multiple' value="<%=strMultipleOperYN%>">
<input type='hidden' name='duration' id='duration' value="<%=strDuration%>">
<input type='hidden' name='start_time' id='start_time' value="<%=start_time%>">
<input type='hidden' name='end_time' id='end_time' value="<%=end_time%>">
<input type='hidden' name='startTime' id='startTime' value='<%=startTime%>'>
<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
<input type='hidden' name='tot_time' id='tot_time' value="<%=tot_time%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
</form>
</body>
</html>

