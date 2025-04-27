<!DOCTYPE html>
<%--
	FileName	:addModifyReaction.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eAM/js/Reaction.js"  language='javascript'></script>
<script>
function change() { 
      	 if (Reaction_form.eff_status.checked == true)
      	 	Reaction_form.eff_status.value="E";
      	 else
      		Reaction_form.eff_status.value="D";
      	}
function change1() { 
      	 if (Reaction_form.adverse_reaction_yn.checked == true)
      	 	Reaction_form.adverse_reaction_yn.value="Y";
      	 else
      		Reaction_form.adverse_reaction_yn.value="N";
      	}
</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="document.Reaction_form.reaction_code.focus()">

<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn = ConnectionManager.getConnection(request);
	String mode = request.getParameter( "operation" );
	String reaction_code 	= request.getParameter("reaction_code");


	//SimpleDateFormat formatter;

	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String sql = "";

	String reactionCode		 = "";
	String reactShortDesc = "";
	String reactLongDesc	 = "";
	String reactEffStatus = "E";
	String adverseReactStatus = "Y";
	String chkEffStatus  = "checked";
	String chkadverseStatus  = "checked";
	String make_readonly = "";
	String code_readonly = "";
	String checkenable ="enabled";

	try
	{
		if(reaction_code==null){
		 reactionCode		 = "";
		reactShortDesc = "";
		reactLongDesc	 = "";
		reactEffStatus = "E";
		adverseReactStatus = "Y";
		chkEffStatus  = "checked";
		chkadverseStatus  = "";
		mode = "insert";
		}else		
		
		{
			reactionCode = request.getParameter("reaction_code");

			sql = "Select * From AM_REACTION where REACTION_CODE =? ";
						
			pstmt   = conn.prepareStatement(sql);
			pstmt.setString	(	1,	reactionCode		);
			rs		 = pstmt.executeQuery();

			if(rs.next())
			{
				reactShortDesc	= rs.getString("SHORT_DESC");	
				reactLongDesc	= rs.getString("LONG_DESC");
				adverseReactStatus	= rs.getString("ADVERSE_REACTION_YN");
				reactEffStatus	= rs.getString("EFF_STATUS");
				
			}			
			if(reactionCode == null || reactionCode.equals("null"))
				reactionCode = "";
			if(reactShortDesc == null || reactShortDesc.equals("null"))
				reactShortDesc = "";
			if(reactLongDesc == null || reactLongDesc.equals("null"))
				reactLongDesc = "";
			if(adverseReactStatus == null || adverseReactStatus.equals("null"))
				adverseReactStatus = "";
			if(reactEffStatus == null || reactEffStatus.equals("null"))
				reactEffStatus = "";
			if (adverseReactStatus.equals("Y"))
				chkadverseStatus = "checked";
			else if (adverseReactStatus.equals("N"))
			{
				chkadverseStatus = "unchecked";				 
			}

			if (reactEffStatus.equals("E"))
				chkEffStatus = "checked";
			else if (reactEffStatus.equals("D"))
			{
				chkEffStatus = "unchecked";
				make_readonly = "readonly"; 
				checkenable = "disabled";
			}
			code_readonly = "readonly";
			mode = "modify";
		}
		if (mode.equals("modify"))
		{
			checkenable = "disabled";
		}

			
%>
	<form name='Reaction_form' id='Reaction_form' action='../../servlet/eAM.ReactionServlet' method='post' target='messageFrame'>
	<div>
	<br><br><br><br>	<br><br><br><br>	
	<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
		<tr><td colspan='2'>&nbsp;</td></tr>	
		<tr>
		
			<td  class='label' width='30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class='fields' width='70%'>&nbsp;
			<input type='text' name='reaction_code' id='reaction_code' size='4' maxlength='4' value='<%=reactionCode%>' <%=code_readonly%> onBlur="ChangeUpperCase(this);" onKeyPress='return CheckForSpecChars(event);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
        </tr>
		<tr><td colspan='2'>&nbsp;</td></tr>	
		<tr>
			<td  class='label' width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='fields' width='70%'>&nbsp;
			<input type='text' name='long_desc' id='long_desc' size='50' maxlength='40' onBlur="makeValidString(this);" onkeypress="return CheckForSpecCharsDesc(event);" value="<%=reactLongDesc%>" <%=make_readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
        </tr>
		<tr><td colspan='2'>&nbsp;</td></tr>	
		<tr>
			<td  class='label' width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields' width='70%'>&nbsp;
			<input type='text' name='short_desc' id='short_desc' size='20' maxlength='20' value="<%=reactShortDesc%>" <%=make_readonly%> onBlur="makeValidString(this);" onkeypress="return CheckForSpecCharsDesc(event);">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>
				<tr><td colspan='2'>&nbsp;</td></tr>	
		<tr>
			<td  class='label' width='30%'><fmt:message key="Common.AdverseReaction.label" bundle="${common_labels}"/></td>
			<td class='fields' width='70%'>&nbsp;
			<input type='checkbox' name='adverse_reaction_yn' id='adverse_reaction_yn' value='<%=adverseReactStatus%>' <%=chkadverseStatus%> <%=checkenable%> onClick="change1()"></td>
       </tr>
		<tr><td colspan='2'>&nbsp;</td></tr>	
		<tr>
			<td  class='label' width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields' width='70%'>&nbsp;
			<input type='checkbox' name='eff_status' id='eff_status' value='<%=reactEffStatus%>' <%=chkEffStatus%> onClick="change()"></td>
       </tr>
		<tr><td colspan='2'>&nbsp;</td></tr>	
	</table>
<%
					if(rs!=null)	rs.close();
					if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	
		ConnectionManager.returnConnection(conn,request);
	}
%>
<input type='hidden' name='function' id='function' value='<%=mode%>'>
</form>
</body>
</html>

