<!DOCTYPE html>
<html>

<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>

<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript'  src='../../eCommon/js/ValidateControl.js' ></script>
	<script type='text/javascript' src='../../eQA/js/QAIndicatorGroup.js'></script>
	<script type='text/javascript' src='../../eQA/js/QAValidate.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript'  src='../../eCommon/js/MstCodeCommon.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
	

<%
		Connection conn			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
        String qind_clind_desc  = "";
	    String disp_name        = "";
        String qind_slno        = "";
		try
		{
		String qind_clind_id=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
		String qind_discipline_id=request.getParameter("qind_discipline_id")==null ?"":request.getParameter("qind_discipline_id");	
		String mode="U";
	
        conn = ConnectionManager.getConnection(request);

        pstmt=conn.prepareCall("select qind_discipline_desc,qind_clind_id,qind_clind_desc ,qind_slno from qa_qind_discipline_clind_vw  where qind_clind_id=? and qind_discipline_id=?");
		pstmt.setString(1,qind_clind_id);
		pstmt.setString(2,qind_discipline_id);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		
		disp_name      =  checkForNull(rs.getString("qind_discipline_desc"));
		qind_clind_id  =  checkForNull(rs.getString("QIND_CLIND_ID"));
		qind_clind_desc=  checkForNull(rs.getString("qind_clind_desc"));
        qind_slno      =  checkForNull(rs.getString("qind_slno"));

  	}   if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		

%>


	<body  onKeyDown = 'lockKey()' >
	<form name='QA_fac_ind' id='QA_fac_ind' target='messageFrame' method='post' action = ''  >
	<BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>

  <tr>
  <td width='40%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  <tr>
      <td width='40%' align='right' class='label' >Discipline</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  
			<input type='text' name='oper_name' id='oper_name' size='30'  value='<%=disp_name%>'  maxlength='30' readonly >&nbsp;
			<input type='hidden' name='qind_discipline_id' id='qind_discipline_id' size='2'  value='<%=qind_discipline_id%>'>&nbsp;
	       </td>
    </tr>
	
  <tr>
  <td width='40%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
	<tr>
      <td width='40%' align='right' class='label'>Indicator ID</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  
			<input type='text' name='qind' id='qind' size='2'  value='<%=qind_clind_id%>'  maxlength='2' onBlur='ChangeUpperCase(this)' readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;
	       </td>
    </tr>
  
  <tr>
           <td width='40%' >&nbsp;</td>
  	     <td width='60%' colspan='2'>&nbsp;</td>
  
  <tr>
      <td width='40%' align='right' class='label' nowrap>&nbsp;Indicator Description</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  
			<input type='text' name='qinddesc' id='qinddesc' size='60'  value='<%=qind_clind_desc%>'  maxlength='60'  readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;
	       </td>
    </tr>
  <tr>
           <td width='40%' >&nbsp;</td>
  	     <td width='60%' colspan='2'>&nbsp;</td>
  </tr>
  <tr>
      <td width='40%' align='right' class='label'>Serial No</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  
			<input type='text' name='serlno' id='serlno' size='3'  value='<%=qind_slno%>'  maxlength='60'  readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;
	       </td>
    </tr>
  </tr>
	<td width='40%' >&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>


  </table>

<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<%}
		catch(Exception e)
		{
		out.println("Exception in File QAModifyIndicatorsForDiscipline"+e.toString());
		}
		finally
		{
		
	    ConnectionManager.returnConnection(conn,request);
		
		}
		%>

</form>

</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

