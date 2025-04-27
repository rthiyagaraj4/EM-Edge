<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<HTML>
	<head>
	<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eOT/js/ActionTypesForReason.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="StatusDetailForm" id="StatusDetailForm">
<%
  //OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String reason_code=checkForNull(request.getParameter("reason_code"));
   String action_code="";
   String action_desc="";
   String active_yn="";
   String active_value="";
   String active_checked="";
   String update_flag="";
   
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rst=null;
    String strsql=
	"SELECT B.ACTION_CODE, B.ACTION_DESC, nvl(A.ACTIVE_YN,'N') ACTIVE_YN, DECODE(A.ACTIVE_YN,'Y','U','N','U') UPDATE_FLAG FROM OT_REASON_ACTION_TYPE A,(SELECT 'CA' ACTION_CODE, 'Cancel Appointment' ACTION_DESC FROM  DUAL UNION SELECT 'CW' ACTION_CODE, 'Cancel Waitlist' ACTION_DESC FROM  DUAL UNION SELECT 'SC' ACTION_CODE, 'Booking Sequence Change' ACTION_DESC FROM  DUAL UNION SELECT 'TA' ACTION_CODE, 'Transfer / Reschedule Appt.' ACTION_DESC FROM  DUAL UNION SELECT 'CN' ACTION_CODE, 'Cancel Check-In Case' ACTION_DESC FROM  DUAL UNION SELECT 'TT' ACTION_CODE, 'Transfer back to OT'  ACTION_DESC FROM  DUAL) B WHERE A.ACTION_TYPE(+) = B.ACTION_CODE AND A.REASON_CODE(+)  = ? ORDER BY 1";
	

  /* String strsql1="SELECT decode(ACTION_TYPE,'CA','Cancel Appointment','CW','Cancel Waitlist','SC','Booking Sequence Change','TA','Transfer/Reschedule Appt','CN','Cancel Check-In Case','TT','Transfer Back To OT') action_type,active_yn FROM OT_REASON_ACTION_TYPE WHERE REASON_CODE = '"+reason_code+"' ORDER BY 1";*/


   int maxRecord = 0;
   int i=1;
   try{
   
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,reason_code);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			//return;
			
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,reason_code);
		rst = pstmt.executeQuery();
				
	
%>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>Prev</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table border="0" width="100%" cellspacing='3' cellpadding=3 align='center'>
	<th class='columnHeader'>
		<fmt:message key="Common.ActionType.label" bundle="${common_labels}"/>
	</th>

<th class='columnHeader'>
	<fmt:message key="Common.active.label" bundle="${common_labels}"/>
</th>
	<% 
	 if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rst.next() ;
String classValue= " ";
      while ( rst.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;
                else
            classValue = "gridData" ;
   action_code=rst.getString(1);
   action_desc=rst.getString(2);
   active_yn=rst.getString(3);
   update_flag=rst.getString(4);
   
   if(active_yn.equals("Y")){
         active_checked="checked";
		 active_value="Y";
   }else{			  
		 active_checked="";
		 active_value="N";
   }
	
 out.println("<tr><td align=='left' class='" + classValue + "'>"+action_desc+"</td>");
 out.println("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+active_value+" "+active_checked+" action_code='"+action_code+"' db_change='N' select_yn='"+active_value+"' update_f='"+update_flag+"'  onclick='validateCheckBox(this);'></td>");
  	i++;
} %>
</tr>
</table>
</center>
<br><center>
<% 

 }catch(Exception e){
		e.printStackTrace();
		//out.println("ActionTypesForReasonDetailForm : "+e);
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="reason_code" id="reason_code" value="<%=reason_code%>" >
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

