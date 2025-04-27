<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ page import ="java.net.URLDecoder,java.lang.StringBuffer,java.text.ParseException,java.sql.Connection,java.sql.Timestamp,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<% 
request.setCharacterEncoding("UTF-8");	
java.util.Properties prop = null;
String client_ip_address="";
String login_user=""; 

prop = (java.util.Properties) session.getValue( "jdbc" ) ;
client_ip_address = prop.getProperty( "client_ip_address" );
login_user = prop.getProperty( "login_user" );
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;		
String sql="";
String recorded_remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RecordedRemarks.Label","OH");
String recorded_dateTime = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RecordedDateTime.Label","OH");
String recorded_by = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RecordedBy.Label","OH");
%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script lanaguage='javascript'>
	function windowClosing()
	{
		 	window.close();	
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<% 
		String title=checkForNull(request.getParameter("heading"));
		String patient_id = request.getParameter("patient_id"); 
		String chart_code = request.getParameter("chart_code"); 
		String chart_num = request.getParameter("chart_num"); 
	 %>

<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<body topmargin='0' leftmargin='0' class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form>
<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:340;width:689;border: 1px outset #9999FF" align="center">
<table align='center' cellpadding='4' cellspacing='' border='1' width='100%' >
<tr >
			<th nowrap align="left" width="25%" ><%=recorded_dateTime%></th>
			<th nowrap align="left" width="20%" ><%=recorded_by%></th>
			<th nowrap align="left" ><%=recorded_remarks%></th>
</tr>
 <%
 try{
	   String added_date_time="";	
	   String remarks="";	
	   String added_by_id="";
	   String style="";
	   con = ConnectionManager.getConnection(request);	
  //The below code gets the REM_SEQ_NUM from OH_PERIODONTAL_CHART_REMARKS table
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		sql="SELECT REM_SEQ_NUM,TO_CHAR(ADDED_DATE_TIME,'DD/MM/YYYY HH24:MI') ADDED_DATE_TIME,ADDED_BY_ID,REMARKS FROM OH_PERIODONTAL_CHART_REMARKS WHERE PATIENT_ID=? AND CHART_NUM = ?  AND CHART_CODE= ? ORDER BY REM_SEQ_NUM DESC";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_code);
		rs=pstmt.executeQuery();
		Integer rowCount=0;
		while(rs.next()){
			added_date_time = checkForNull(rs.getString("ADDED_DATE_TIME"));
			added_by_id = checkForNull(rs.getString("ADDED_BY_ID"));
			remarks = checkForNull(rs.getString("REMARKS"));
			//URLDecoder dcDecoder=null;
		/*	 str= dcDecoder.decode(remarks);
			 if(remarks.equals("undefined") ){remarks = "";}
			  int size=0;
			 char ch='\n';
			 StringBuffer sb=new StringBuffer();
			 sb.append(remarks);
			 while(size<=remarks.length())
			 {
				 size=size+35;
				 if(size<remarks.length())
				 sb.insert(size,ch);
			 }
			 remarks=sb.toString();
			 rowCount++; */
			 style =(rowCount.intValue()%2==0)?"QRYEVEN":"QRYODD";
			%>
			
			<tr><!-- <td align="right" class="<%=style %>"><%=recorded_remarks%></td> -->
			<td class="<%=style %>" width="25%"><%=added_date_time%></td>
			<td class="<%=style %>" width="20%"><%=added_by_id%></td>
			<td class="<%=style %>"><%=remarks%></td>
			</tr>
			<tr><td></td><td></td></tr>
			<%
			}
			%>
</table>
</div>
<table width="100%">
<tr>
	<td class='MESSAGE' align='right'>
		
	<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()">
		
</td>
</tr></table>
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

</form>
</body>
</HTML>

