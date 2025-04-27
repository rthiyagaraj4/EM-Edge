<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../js/MOBodyPart.js" language="javascript"></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");
   String code="";
   String short_desc="";
   String long_desc="";
   String effstatus="";
   String codeTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String enblothrs="";
   boolean newcomplaint=false;
   StringBuffer sql=new  StringBuffer();
	code=request.getParameter("body_part_code");
	if(code==null){
	code="";
	long_desc="";
	short_desc="";
	effstatus="E";
	codeTextAttribute="";
	checkBoxAttribute="CHECKED";
	newcomplaint=true;
	eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rset=null;
     try{
	sql.setLength(0);
	sql.append("select BODY_PART_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from MO_BODY_PART where BODY_PART_CODE=?");
	pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1,code);
	rset = pstmt.executeQuery();
	rset.next();
	code=rset.getString("BODY_PART_CODE");
	long_desc=rset.getString("LONG_DESC");
	short_desc=rset.getString("SHORT_DESC");
	effstatus=rset.getString("EFF_STATUS");
	if(effstatus.equals("D")){
	checkBoxAttribute="";
	enblothrs ="READONLY";
	}else{
	checkBoxAttribute="CHECKED";
	}
   sql.setLength(0);
   }catch(Exception e){
		e.toString();
   }
    finally{
	if(rset!=null) 	rset.close();
   	if(pstmt!=null) pstmt.close();
   	ConnectionManager.returnConnection(conn,request);
 }
	codeTextAttribute="READONLY";
	newcomplaint=false;
	eventFunctionForCase="";
}
%>
<form name="MOBodyPart_form" id="MOBodyPart_form"  action='../../servlet/eMO.MOBodyPartServlet' method='post' target='messageFrame'>
<br><br><br><br><br><br><br><br><br><br>

	<table cellspacing=0 cellpadding=5 align="center" width="80%" border="0">
	<tr>
		<td class="label" width="40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="body_part_code" id="body_part_code" size="4" maxlength="4" value="<%=code%>"   onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="long_desc" id="long_desc" size="40" maxlength="40" value="<%=long_desc%>" <%=enblothrs%> onBlur="">
				<img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=short_desc%>" <%=enblothrs%> onBlur="">
				<img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
    <tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		 <td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
	</tr>
	</table>

 <%  if(newcomplaint){%>
      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>

 </form>
 </body>
 </html>

