<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript" src="../../eOT/js/Hashtable.js"></script>
<script language="javascript" src="../../eOT/js/ReleaseTheatre.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var record=new Array();
var jobQueue=new Array();
</script>
</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ReleaseTheatreForm" id="ReleaseTheatreForm" method="post" >
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<!-- header-->
<th class='columnheadercenter' nowrap><!-- changed by yadav -->
	<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.Theatre.label"	bundle="${common_labels}"/>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>

<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.block.label" bundle="${common_labels}"/>
	<fmt:message key="Common.date.label" bundle="${common_labels}"/>
</th>

<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.fromtime.label" bundle="${common_labels}"/>
</th>
 
<th class='columnheadercenter' nowrap><!-- changed by yadav -->
	<fmt:message key="Common.totime.label" bundle="${common_labels}"/>
</th>

<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.Release.label" bundle="${common_labels}"/>
</th>



<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id =(String) session.getAttribute("facility_id"); 
	String locale = (String)session.getAttribute("LOCALE");
	StringBuffer sbr = new StringBuffer();
	String sql="SELECT A.OPER_ROOM_CODE, B.SHORT_DESC,TO_CHAR(A.BLOCK_DATE,'DD/MM/YYYY')  BLOCK_DATE, TO_CHAR(A.FR_SLOT_TIME,'HH24:MI') FR_SLOT_TIME, TO_CHAR(A.TO_SLOT_TIME,'HH24:MI') TO_SLOT_TIME, A.BLOCK_REASON FROM OT_BLOCK_OPER_ROOM A, OT_OPER_ROOM_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.OPER_ROOM_CODE = B.OPER_ROOM_CODE  AND B.LANGUAGE_ID = ? ORDER BY A.OPER_ROOM_CODE ";
	String classValue="";
	String args="";

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	try{
		con=ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locale);
		rst=pstmt.executeQuery();
		int i=0;
		while(rst.next()){
			i++;
			classValue = ( i % 2 == 0 )?"gridData":"gridData";   // changed by yadav
			sbr.append("<tr>");
			sbr.append("<td class='"+classValue+"'>"+rst.getString(1)+"</td>");//Theatre Code
			sbr.append("<td class='"+classValue+"'>"+rst.getString(2)+"</td>");//description
			//sbr.append("<td class='"+classValue+"'>"+rst.getString(3)+"</td>");//Block Date
			sbr.append("<td class='"+classValue+"'>"+com.ehis.util.DateUtils.convertDate(rst.getString(3),"DMY","en",locale)+"</td>");//Block Date
			sbr.append("<td class='"+classValue+"'>"+rst.getString(4)+"</td>");//From Time
			sbr.append("<td class='"+classValue+"'>"+rst.getString(5)+"</td>");//To Time
			sbr.append("<td class='"+classValue+"'><input type='checkbox' name='chk_release"+i+"' id='chk_release"+i+"' onclick='registerInRecordQueue("+i+");'></td>");//Release
			//sbr.append("<td class='"+classValue+"'><a href=javascript:openReason('"+i+"')>Reason</a></td>");//Reason for Release
			//sbr.append("<input type='hidden' name='reason"+i+"' id='reason"+i+"' value=''>");
			sbr.append("</tr>");
			args = rst.getString(1)+"@@"+rst.getString(2)+"@@"+rst.getString(3)+"@@"+rst.getString(4)+"@@"+rst.getString(5);
			out.println("<script>loadDBDtls('"+args+"');</script>");
		}
		if(sbr.length()>0) out.println(sbr.toString());	
		/*if(i == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
	*/
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Exception is "+e);
	}finally{
		try{if(pstmt!=null) pstmt.close();
			if(rst!=null)rst.close();
			sbr.setLength(0);
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}


%> 
</table>
</center>
<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'> 
<input type='hidden' name='locale' id='locale' value="<%=locale%>"> 

</form> 
</body>
</html>

