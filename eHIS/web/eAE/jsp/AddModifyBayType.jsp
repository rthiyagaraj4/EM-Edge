<!DOCTYPE html>
<%@ page  import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eAE/js/BayType.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
   request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
   
   String code="";
   String short_desc="";
   String long_desc="";
   String effstatus="";
   String codeTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String enblothrs="";
   boolean newcomplaint=false;
   String sql="";
%>
<%
	code=request.getParameter("bay_type_code");//from BayTypeQueryResult.jsp
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
		   Connection conn        = null;
	       PreparedStatement stmt = null;
	       ResultSet rset         = null;
     try{
         conn = ConnectionManager.getConnection(request);
		
// query for displaying values in query mode based on value coming from result page(BayTypeQueryResult.jsp)
		sql = "select BAY_TYPE_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from AE_BAY_TYPE where BAY_TYPE_CODE= ?";
		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,code) ;
		rset = stmt.executeQuery();
		rset.next();
		code=rset.getString("BAY_TYPE_CODE");
		long_desc=rset.getString("LONG_DESC");
		short_desc=rset.getString("SHORT_DESC");
		effstatus=rset.getString("EFF_STATUS");
		if(effstatus.equals("D")){
			checkBoxAttribute="";
			enblothrs ="READONLY";
		}else{

			checkBoxAttribute="CHECKED";
			
		}
	     
		 if(rset!=null) 	rset.close();
	     if(stmt!=null) 	stmt.close();

		 }catch(Exception e){
			e.toString();
	     }
	     finally{
		    if(conn != null)    	
	     	ConnectionManager.returnConnection(conn,request);
		 }
		codeTextAttribute="READONLY";
		newcomplaint=false;
		eventFunctionForCase="";
	}

%>
<form name="bay_type_form" id="bay_type_form"  action='../../servlet/eAE.BayTypeServlet' method='post' target='messageFrame'>
<br><br><br>

	<table cellspacing=0 cellpadding=3 align="center" width="70%" border="0">
	
	<tr>
		<td colspan=2 height='5'></td>
	</tr>
	<tr>
		<td class="label"  width="25%"> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="field" width='25%'><input type="text" name="bay_type_code" id="bay_type_code" size="2" maxlength="2" value="<%=code%>"  onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%> onBlur="changeCase(this);">
			<img  src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan=2></td>
	</tr>

	<tr>
		<td class="label" width='25%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class="field" width='25%'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" value="<%=long_desc%>" <%=enblothrs%> onBlur="makeValidString(this);">
				<img  src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan=2></td>
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class="field" width='25%'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=short_desc%>" <%=enblothrs%> onBlur="makeValidString(this);">
				<img  src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan=2></td>
	</tr>

	<tr>
		<td class="label" width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		 <td class="field" width='25%'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick='changeStatus()'></td>
	</tr>
	<tr>
		<td colspan=2 height='5'></td>
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

