<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<html>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script type='text/javascript' src='../../eQA/js/QAIndicatorGroup.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn         = null;
	PreparedStatement pstmt = null;
	ResultSet rs            = null;
	String qind_group_id=request.getParameter("qind_group_id")==null ?"":request.getParameter("qind_group_id");	
	String mode             = "";
	String qind_group_desc  = "";
	String eff_status       = "";
	String status           = "";
	String disabledfield      ="";
	try
	{
		conn = ConnectionManager.getConnection(request);
		if(!qind_group_id.equals(""))
		{  
			pstmt=conn.prepareStatement("select QIND_GROUP_ID,QIND_GROUP_DESC QADES,EFF_STATUS ES From QA_QIND_GROUP where QIND_GROUP_ID=?");
			pstmt.setString(1,qind_group_id);
			rs=pstmt.executeQuery();
			if(rs.next()==true)			
			{
				 mode="U";
				 qind_group_desc=rs.getString("QADES");
				 eff_status=rs.getString("ES");
				 if(eff_status.equals("E"))
				 status="checked";
				 else
                 disabledfield="disabled";
			 }
	    }
	    else
	 		 mode="I";
   
   if(rs!=null)rs.close();
   if(pstmt!=null)pstmt.close();	
   }
   catch(Exception ee)
   {
		out.println("Error"+ee);
   }
   finally
   { 
	 ConnectionManager.returnConnection(conn, request);
   }
%>
<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='QA_QIND_GROUP' id='QA_QIND_GROUP' target='messageFrame' method='post' action = '../../servlet/eQA.QAIndicatorGroupServlet'  >
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
<tr>
	<td width='40%' >&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td width='40%' align='right' class='label'>Group Code</td>
	<td width='60%' align='left' colspan='2'> &nbsp;
	<%if(mode.equalsIgnoreCase("U")){%>
		<input type='text' name='QIND_GROUP_ID' id='QIND_GROUP_ID' size='4'  value='<%=qind_group_id%>' maxlength='4' onBlur='ChangeUpperCase(this);' readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	<%} else {%>
	  <input type='text' name='QIND_GROUP_ID' id='QIND_GROUP_ID' size='4'   value='<%=qind_group_id%>'  maxlength='4' 
			 onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	<%}%>
	</td>
</tr>
<tr>
	<td width='40%' >&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td width='40%' align='right' class='label'>Description</td>
	<td width='60%' align='left' colspan='2'>&nbsp;
	<input type='text' name='QIND_GROUP_DESC' id='QIND_GROUP_DESC' size='30' value="<%=qind_group_desc%>" <%=disabledfield%>  maxlength='40' >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td width='40%' >&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td width='40%' align='right' class='label'>Enabled</td>
    <td width='60%' align='left' colspan='2'>&nbsp;
	<% if(mode.equalsIgnoreCase("U")) {%>
	<input type='checkbox' name='EFF_STATUS' id='EFF_STATUS'  value='<%=eff_status%>'  onClick='funCheckBox(); '  <%=status%>>
	<%}else { %>
	<input type='checkbox' name='EFF_STATUS' id='EFF_STATUS'   value='E' onClick='funCheckBox(); ' checked >	  
	<%}%>
    &nbsp;</td>
</tr>
<tr>
	<td width='40%' >&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
</form>
</body>
</html>

