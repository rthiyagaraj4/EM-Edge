<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(	String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/DairyScheduleForSuregon.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="var apply=parent.parent.commontoolbarFrame.document.forms[0].apply;if(apply) apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
String mode=request.getParameter("update_mode_yn");

String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

//String chk_checked="checked";
//String chk_value="E";
String short_desc="";
String sql="";

if(oper_room_code.equals("null") || oper_room_code=="null"){
	oper_room_code="";
}
String facility_id=(String) session.getAttribute("facility_id");
//String val="";
String oper_room_code_db = "";
String disable_option = "";
if(mode!=null && mode.equals("modify"))
	disable_option="disabled";
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
	<td class="fields">
	
	<select name="oper_room_code" id="oper_room_code" onchange='assignValues();spltyEnaDis()' <%=disable_option%>>
	<option value=''>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
	<%
	try{
        con=ConnectionManager.getConnection(request);
		//sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? ORDER BY 1 ";
		
		sql="SELECT  OPER_ROOM_CODE||'@@'||RESTRICT_BY_SPLTY_YN,GET_DESC('en','OT_OPER_ROOM_LANG_VW','SHORT_DESC','OPER_ROOM_CODE',OPER_ROOM_CODE) SHORT_DESC FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID=? AND NVL(STATUS,'E') = 'E' AND OPERATING_FACILITY_ID=? ORDER BY 1";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		rs=stmt.executeQuery();
		while(rs.next()){
			oper_room_code_db=rs.getString(1);
			short_desc=rs.getString(2);
			if(oper_room_code.equals(oper_room_code_db))
			out.println("<option selected value='"+ oper_room_code_db+"' >"+short_desc+"</option>");    
			else
				out.println("<option value='"+oper_room_code_db+"' >"+short_desc+"</option>");

			
		}
	  }catch(Exception e){
		  e.printStackTrace();
		  //System.err.println("Error Mesg in DairyScheduleForSurgeonMain.jsp : "+e);
		  //out.println("exp"+e);

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
 </select><img src='../../eCommon/images/mandatory.gif' align='center'>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='oper_room_code1' id='oper_room_code1' value="<%=oper_room_code%>">
<input type="hidden" name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type="hidden" name='curr_date' id='curr_date' value="">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


