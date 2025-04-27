<!DOCTYPE html>
<html>

<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>

<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript'  src='../../eCommon/js/ValidateControl.js' ></script>
<script type='text/javascript' src='../../eQA/js/QADiscipline.js'></script>
<!-- <script type='text/javascript' src='../../eQA/js/QAValidate.js'></script>  -->
<script language='javascript'  src='../../eCommon/js/FieldFormatMethods.js' ></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<!--  <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>  -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	

<%
		Connection conn					= null;
		PreparedStatement pstmt			= null;
		ResultSet rs					= null;
       
		
		String mode						= "";
		String qind_discipline_desc     = "";
		String eff_status				= "";
		String status					= "";
		String readonly                 = "";

       
try
{
	 String qind_discipline_id=request.getParameter("qind_discipline_id")==null ?"":request.getParameter("qind_discipline_id");	
	 conn = ConnectionManager.getConnection(request);
	if(!qind_discipline_id.equals(""))
	{  
		pstmt=conn.prepareStatement("select QIND_DISCIPLINE_ID,QIND_DISCIPLINE_DESC QADES,EFF_STATUS ES From QA_QIND_DISCIPLINE where QIND_DISCIPLINE_ID=?");
		pstmt.setString(1,qind_discipline_id);
		rs=pstmt.executeQuery();
		if(rs.next()==true)			
		{
		  mode="U";
		  qind_discipline_id     = rs.getString("QIND_DISCIPLINE_ID");
		  qind_discipline_desc   = rs.getString("QADES");
		  eff_status             = rs.getString("ES");
		  if(eff_status.equals("E"))
			{
			 status="checked";
			}
		  else
			{
			  readonly="disabled";
			}
	   }    
	   if(rs!=null)rs.close();
	   if(pstmt!=null)pstmt.close();
	   if((qind_discipline_id==null) ||(qind_discipline_id.equals("null")))
				qind_discipline_id="";
	   if((qind_discipline_desc==null) ||(qind_discipline_desc.equals("null")))
				qind_discipline_desc="";

	 }
	else
 	 mode="I";

%>


	<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	<form name='QA_QIND_DISCIPLINE' id='QA_QIND_DISCIPLINE' target='messageFrame' method='post' action = '../../servlet/eQA.QADisciplineServlet'  >
	<BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>

  <tr>
  <td width='40%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  <tr>
      <td width='40%' align='right' class='label'>Discipline Code</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  <%if(mode.equalsIgnoreCase("U")){%>
			<input type='text' name='QIND_DISCIPLINE_ID' id='QIND_DISCIPLINE_ID' size='4'  value="<%=qind_discipline_id%>"  maxlength='4' onBlur='ChangeUpperCase(this);' readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	  <%} else {%>
		  <input type='text' name='QIND_DISCIPLINE_ID' id='QIND_DISCIPLINE_ID' size='4' onBlur='ChangeUpperCase(this)'  text='Quality Indicator Id' value="<%=qind_discipline_id%>"  maxlength='4' 
                 onKeyPress='return CheckForSpecChars(event)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	  <%}%>
      </td>
    </tr>
  <tr>
  <td width='40%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
	 <tr>
      <td width='40%' align='right' class='label'>Description</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;&nbsp;<input type='text' name="QIND_DISCIPLINE_DESC" id="QIND_DISCIPLINE_DESC" size='30'  value="<%=qind_discipline_desc%>" maxlength='40' <%=readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

   <tr>
    <td width='40%' >&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

<tr>
	<td width='40%' align='right' class='label'>Enabled</td>
    <td width='60%' align='left' colspan='2'>&nbsp;<U></U>

	<% if(mode.equalsIgnoreCase("U")) {%>
	<input type='checkbox' name='EFF_STATUS' id='EFF_STATUS'  value='<%=eff_status%>'  onClick='funCheckBox(); '  <%=status%>>
	<%}else { %>
	<input type='checkbox' name='EFF_STATUS' id='EFF_STATUS'   value='E' onClick='funCheckBox(); ' checked >	  
	<%}%>
    &nbsp;</td></tr>
   <tr>
    <td width='40%' >&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  </table>

<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

</form>
 <%}
catch(Exception ee)
{
	out.println("Exception in addModifyQADiscipline"+ee.toString());
	
}
finally
{ 
		
	ConnectionManager.returnConnection(conn, request);
} %>
</body>
</html>

