<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/BlockSlotsBySpeciality.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript">

function assignValues(obj){
	var formObj=document.forms[0];
	var rows=window.parent.frames[1].rows;
	if(rows!=null){
		if(rows.length!=0)
			rows.length=0;
	}
	var RecordFrame=window.parent.frames[3];
	var RecordFrame_formObj=RecordFrame.document.forms[0];
	var update_mode_yn=RecordFrame_formObj.mode.value;
	var val=obj.value;
	var arr=val.split("::");
    var oper_room_code=arr[0];
	var wd_start_time=arr[1];
	var wd_end_time=arr[2];
	var hd_start_time=arr[3];
	var hd_end_time=arr[4];
	//alert(oper_room_code+" "+wd_start_time+" "+wd_end_time+" "+hd_start_time+" "+hd_end_time);
		
    window.parent.frames[4].location.href='../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?';	
	window.parent.frames[3].location.href="../../eOT/jsp/BlockSlotsBySpecialityRecord.jsp?oper_room_code="+oper_room_code+"&wd_start_time="+wd_start_time+"&wd_end_time="+wd_end_time+"&hd_start_time="+hd_start_time+"&hd_end_time="+hd_end_time+"&update_mode_yn="+update_mode_yn;

	//alert(oper_room_code+" "+wd_start_time+" "+wd_end_time+" "+hd_start_time+" "+hd_end_time+" "+update_mode_yn);
	
   //window.parent.frames[4].location.href='../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?';  
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("update_mode_yn");
//String chk_checked="checked";
//String chk_value="E";
String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
if(oper_room_code.equals("null") || oper_room_code=="null"){
	oper_room_code="&nbsp;";
}
String short_desc="";
String sql="";
String facility_id=(String) session.getAttribute("facility_id");
String val="";
String curr_date="";
	try{	
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement("select '01'||to_char(sysdate,'/mm/yyyy') from dual");
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			curr_date=rs.getString(1);
		}
		if(rs!=null)rs.close();	
		if(stmt!=null) stmt.close();
%>
<form name="BlockSlotsBySpecialityHdr" id="BlockSlotsBySpecialityHdr"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->

<tr>
	<td class="label">
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
		<%
	if (mode.equals("insert")){
	%>
	<td class="fields">
		<select name="oper_room_code" id="oper_room_code" onchange='assignValues(this);'>
		<option value=''>
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
	<%
		//sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? ORDER BY 1 ";
		sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID= ? AND NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? ORDER BY 1 ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			 oper_room_code=rs.getString(1);
			 short_desc=rs.getString(2);
			 val=rs.getString(1)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+"::"+rs.getString(6);
    %>	
             <option value="<%=val%>"><%=short_desc%></option>
    <%  }
    %>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'>	
	 <% 
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();	  
}else if(mode .equals("modify")){
%>
	<td class='label'><select name="oper_room_code" id="oper_room_code"  disabled>
<%
		//sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? AND OPER_ROOM_CODE=? ORDER BY 1 ";
		sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID= ? AND NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? AND OPER_ROOM_CODE=? ORDER BY 1 ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		stmt.setString(3,oper_room_code);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
             short_desc=rs.getString(2);			         
      %>	
           <option value="<%=oper_room_code%>" selected><%=short_desc%></option>			   
		   <option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
      <%}
	  %>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% 
}
	}catch(Exception e){
		e.printStackTrace();
		/* System.err.println("Exception in Block Slots by Speciality Main jsp:"+e);
		out.println("m==:"+m);
		out.println("Exception in Block Slots by Speciality Main jsp:"+e); */
	}finally{
		try{		
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
	
</tr>

<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='oper_room_code1' id='oper_room_code1' value="<%=oper_room_code%>">
<input type="hidden" name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type="hidden" name='curr_date' id='curr_date' value="<%=curr_date%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
</form>
</body>
</html>


