<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
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
<script language='javascript' src='../../eOT/js/StoresforOperatingRoom.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
String facility_id_check = request.getParameter("facility_id1")==null?"":request.getParameter( "facility_id1" );
String str_code_check = request.getParameter("store_room_code")==null?"":request.getParameter( "store_room_code" );
String default_select="";
String short_desc="";
String sql="";
String sql_store="";
String facility_id=(String) session.getAttribute("facility_id");
String val="";

String facility_name="";
String facility_id1="";
String str_code="";
String str_desc="";
try{
con=ConnectionManager.getConnection(request);
%>
<form name="StoresforOperatingRoom" id="StoresforOperatingRoom"    action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=3 width='60%'  align='center'>
<tr>
	<td class="label">
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		
		<input type='text' class="fields" name='theatre_desc' id='theatre_desc' size='15' onBlur="if(this.value!='')searchTheatre(oper_room_code,theatre_desc);else loadDtlForm();" ><input type="hidden" name="oper_room_code" id="oper_room_code" value="<%=oper_room_code%>">
		<input type='button' class='button' name='TheatreLookUp' id='TheatreLookUp' size='15' value="?" OnClick="searchTheatre(oper_room_code,theatre_desc);"> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
</tr>
<tr>
<td class="label">
		<fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	
		<select name="facility_name1" id="facility_name1"  onChange="changeOfFacility()">
		<!-- <option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> -->
		
	<%
		sql="select FACILITY_NAME,FACILITY_ID from (SELECT 'ALL' FACILITY_NAME,'ALL' FACILITY_ID,1 seq FROM DUAL UNION SELECT FACILITY_NAME,FACILITY_ID, 2 seq FROM SM_FACILITY_PARAM_LANG_VW WHERE  LANGUAGE_ID  = ?)order by seq,FACILITY_NAME";// Query given by Dilip on 06-06-2009 for CRF-224
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			 facility_name=rs.getString(1);
			 facility_id1=rs.getString(2);
			 if(facility_id_check.equals(facility_name) ){
				default_select = "selected";
			}else {
				default_select = "";
			}

    %>	  
             <option value="<%=facility_id1%>" <%=default_select%>><%=facility_name%></option>
    <%  }
    %>
		</select>	
	 <% 
}catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Error in StoresforOperatingRoom .jsp : "+ee);
	}finally{
		try{
			if(rs!=null)		rs.close();
			if(stmt !=null)  stmt.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
    }%>

	
</tr>

<tr>
<td class="label">
		<fmt:message key="Common.Store.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<select name="store_code" id="store_code" onchange='onChangeStoreCode()'>
		<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
	try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT B.STORE_CODE,SHORT_DESC FROM MM_STORE A , ST_STORE B WHERE A.STORE_CODE = B.STORE_CODE AND A.EFF_STATUS ='E'ORDER BY 1";// Query given by Dilip on 06-06-2009 for CRF-224
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			 str_code=rs.getString(1);
			 str_desc=rs.getString(2);
			 if(str_code_check.equals(str_desc) ){
				default_select = "selected";
			}else {
				default_select = "";
			}

    %>	
	 <option value="<%=str_code%>" <%=default_select%>><%=str_desc%></option>
		
	  <%  }
    %>
		</select>	
 <% 
}catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Error in StoresforOperatingRoom .jsp : "+ee);
	}finally{
		try{
			if(rs!=null)		rs.close();
			if(stmt !=null)  stmt.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
    }%>
	
</tr>
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</table>
</body>

