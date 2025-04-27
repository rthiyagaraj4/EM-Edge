<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script language='javascript' src='../../eOT/js/BlockSlotsBySpeciality.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script Language="JavaScript">
function assignValues(obj){

	var formObj=document.forms[0];
//	var rows=window.parent.parent.frames[1].frames[1].rows;
//	alert("rows  "+rows);
//	if(rows.length!=0 || rows.length!=null)
//	rows.length=0;
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
	//window.parent.frames[4].location.href='../../eOT/jsp/BlockSlotsByAgeGroupDetailForm.jsp?';
	//window.parent.frames[3].location.href="../../eOT/jsp/BlockSlotsByAgeGroupRecord.jsp?oper_room_code="+oper_room_code+"&wd_start_time="+wd_start_time+"&wd_end_time="+wd_end_time+"&hd_start_time="+hd_start_time+"&hd_end_time="+hd_end_time+"&update_mode_yn="+update_mode_yn;
	window.parent.frames[3].location.href="../../eOT/jsp/BlockSlotsByAgeGroupRecord.jsp?oper_room_code="+oper_room_code;
	//alert(oper_room_code+" "+wd_start_time+" "+wd_end_time+" "+hd_start_time+" "+hd_end_time+" "+update_mode_yn);
	//window.parent.frames[4].location.href='../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?';  
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="BlockSlotsByGroupMain" id="BlockSlotsByGroupMain"  onload='FocusFirstElement()'> 
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td class="label">
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<select name="oper_room_code" id="oper_room_code" onchange='assignValues(this);'>
	<option value=''>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String) session.getAttribute("facility_id");
	String oper_room_code="";
	String oper_room_desc="";

	String sql="SELECT  OPER_ROOM_CODE,SHORT_DESC FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID=? AND NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? ORDER BY 1 ";
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
        con=ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		rs=pstmt.executeQuery();
		while(rs.next()){
		  oper_room_code=rs.getString(1);
		  out.println("<option value='"+rs.getString(1)+"' >"+rs.getString(2)+"</option>");
		}
	}catch(Exception e){
		  out.println("exp"+e);
  }finally{
	try{
	  if(rs!=null) rs.close();
      if(pstmt!=null) pstmt.close();
	  ConnectionManager.returnConnection(con);
    }catch(Exception e){}
 } 
%>
</select><img src='../../eCommon/images/mandatory.gif' align='center'>
</tr>
</table>
<input type="hidden" name='oper_room_code1' id='oper_room_code1' value="<%=oper_room_code%>">
<input type="hidden" name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


