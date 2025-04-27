<!DOCTYPE html>
<%--
	FileName	: AddModifyStatisticsGroup.jsp
	Version	    : 3	
	Modified On	: 23-2-2005 , 7-3-2008
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
      	<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language="javascript" src="../../eAM/js/StatisticsGroup.js"></script>



</head>

<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>

<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
   String stat_id="";
   String stat_desc="";
   String stat_cat="";
	String codeTextAttribute="";
  
   String otherTextAttribute="";
 

   String eventFunctionForCase="";
 
   String sql="";

   Connection conn = null;
   Statement stmt=null;
   PreparedStatement pstmt = null;
   ResultSet rset=null;
   
   String operation = request.getParameter( "operation" );


%>
<%   try{
    conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	stat_id=request.getParameter("stat_grp_id");
	if(stat_id==null)
	{
		stat_id="";
		stat_desc="";
		stat_cat="";
		codeTextAttribute="";
		otherTextAttribute="";
	
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		
	}
	else{
	    
		sql = "	select stat_grp_id,stat_grp_desc,stat_grp_cat from AM_STAT_GROUP where stat_grp_id=?";
		//rset = stmt.executeQuery(sql);
		 
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	stat_id		);
		rset		 = pstmt.executeQuery();
		
		rset.next();
		stat_id=rset.getString("stat_grp_id");
		stat_desc=rset.getString("stat_grp_desc");
		stat_cat=rset.getString("stat_grp_cat");
		if(rset!=null)	rset.close();
		if(stmt!=null)	stmt.close();	
		if(pstmt!=null)	pstmt.close();	
		
		if(stat_cat == null) stat_cat="";
		
		
	     
		codeTextAttribute="READONLY";
		
		eventFunctionForCase="";
	}
	}catch(Exception e){
			e.toString();
	     }
	     finally{
			
			ConnectionManager.returnConnection(conn,request);
	     }

%>

      	<form name="StatisticsGroup_form" id="StatisticsGroup_form" action="../../servlet/eAM.StatisticsGroupServlet" method="post" target="messageFrame">
      	<div align="left">
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
      	<table border="0" cellpadding="0" cellspacing="0" align='center' width='auto'>

      	<!-- <tr>
      		<td width='20%'>&nbsp;</td>
      		<td>&nbsp;</td>
      		<td>&nbsp;</td>
      		<td width='20%'>&nbsp;</td>
      	</tr> -->

      	<tr>
		      	<!-- <td>&nbsp;</td> -->
      		    <td  class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>&nbsp;
      		    <input type="text" name="stat_grp_id" id="stat_grp_id" value="<%=stat_id%>" onKeyPress="return CheckForSpecChars(event)"  size="10" maxlength="10" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
				<!-- <td>&nbsp;</td> -->
      		</tr>

      	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

		<tr>
		    <!-- <td>&nbsp;</td> -->
		    <td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		    <td class='fields'>&nbsp;
		    <input type="text" name="stat_grp_desc" id="stat_grp_desc"  onBlur='makeValidString(this)' value="<%=stat_desc%>" size="20" maxlength="20" <%= otherTextAttribute%> >
		    <img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			<!-- <td>&nbsp;</td> -->
		</tr>

      	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

		<tr>
			<!-- <td>&nbsp;</td> -->
		    <td   class="label"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
		    <td class='fields'>&nbsp;
		    <select name='stat_grp_cat' id='stat_grp_cat'>
			<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
			<%if(stat_cat.equals("N")){%>
		    <option value='N' selected><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			

			<%}else if(stat_cat.equals("S")){%>
			
			<option value='N'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></option>
			<option value='S' selected><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			

			<%}else if(stat_cat.equals("P")){%>
			<option value='N'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
			<option value='P' selected><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			
			<%}else{%>
			<option value='N'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			
			<%}%>
			</select>
		    <img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			<!-- <td>&nbsp;</td> -->
		</tr>

      	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

      	</table>
      	</div>


      	<input type='hidden' name='function' id='function' value='<%=operation%>'>
      	<input type='hidden' name='function_name' id='function_name' value='<%=operation%>'>
		<input type='hidden' name='stat_id' id='stat_id' value='<%=stat_id%>'>
		<input type='hidden' name='stat_desc' id='stat_desc' value='<%=stat_desc%>'>
		<input type='hidden' name='stat_cat' id='stat_cat' value='<%=stat_cat%>'>

</form>
</body>
</html>

