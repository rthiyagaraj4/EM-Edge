<!DOCTYPE html>
<html>

<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>

<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script type='text/javascript' src='../../eQA/js/QAIndicatorGroup.js'></script>
 <script type='text/javascript' src='../../eQA/js/QAValidate.js'></script> 
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
  <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
/*functions moved to JS...*/
	</script>
</head>

<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
       String dflt_rep_periodicity1="";
	   String dflt_bd_age_range_id1="";
	   String dflt_bd_by_gender_yn1="";
	   String qind_clind_desc="";
	   String oper_name="";

	   String qind_clind_id=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
	   String operating_facility_id=request.getParameter("operating_facility_id")==null ?"":request.getParameter("operating_facility_id");	
	   //String dflt_rep_periodicity=request.getParameter("dflt_rep_periodicity")==null ?"":request.getParameter("dflt_rep_periodicity");
	
	   //String dflt_bd_by_gender_yn=request.getParameter("dflt_bd_by_gender_yn")==null ?"":request.getParameter("dflt_bd_by_gender_yn");
		  
	   //String dflt_bd_age_range_id=(request.getParameter("dflt_bd_age_range_id")==null||request.getParameter("dflt_bd_age_range_id").equals("null")) ?"":request.getParameter("dflt_bd_age_range_id");
		   
	   String mode="U";
	
       conn = ConnectionManager.getConnection(request);

       pstmt=conn.prepareCall("select   facility_name,qind_clind_id,qind_clind_desc,dflt_rep_periodicity,dflt_bd_by_gender_yn,dflt_bd_age_range_id from qa_qind_facility_clind_vw  where qind_clind_id=? and operating_facility_id=? ");
	   pstmt.setString(1,qind_clind_id);
	   pstmt.setString(2,operating_facility_id);
	   rs=pstmt.executeQuery();
	try
	{
		while(rs.next())
		{
		oper_name=rs.getString("facility_name");
		qind_clind_id=rs.getString("QIND_CLIND_ID");
		qind_clind_desc=rs.getString("qind_clind_desc");

		dflt_rep_periodicity1=rs.getString("dflt_rep_periodicity");
		if(dflt_rep_periodicity1==null)dflt_rep_periodicity1="";

		dflt_bd_age_range_id1=rs.getString("DFLT_BD_AGE_RANGE_ID");
		if(dflt_bd_age_range_id1==null)dflt_bd_age_range_id1="";
		dflt_bd_by_gender_yn1=rs.getString("dflt_bd_by_gender_yn");
		if(dflt_bd_by_gender_yn1==null)dflt_bd_by_gender_yn1="N";
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	catch(Exception e)
	{
	out.println("Error"+e);
	}finally
	{
	    ConnectionManager.returnConnection(conn,request);
    }
%>
	<body  onKeyDown = 'lockKey()' >
	<form name='QA_fac_ind' id='QA_fac_ind' target='messageFrame' method='post' action = ''  >
	<BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>

  <tr>
  <td width='20%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  <tr>
      <td width='20%' align='right' class='label' >Facility</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
			<input type='text' name='oper_name' id='oper_name' size='30'  value='<%=oper_name%>'  maxlength='30' readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='operating_facility_id' id='operating_facility_id' size='2'  value='<%=operating_facility_id%>'>&nbsp;
	       </td>
    </tr>
  <tr>
  <td width='20%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
	<tr>
      <td width='20%' align='right' class='label'>Indicator ID</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  
			<input type='text' name='qind' id='qind' size='2'  value='<%=qind_clind_id%>'  maxlength='2' onBlur='ChangeUpperCase(this);' readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	       </td>
    </tr>
  <tr>
           <td width='20%' >&nbsp;</td>
  	     <td width='60%' colspan='2'>&nbsp;</td>
  <tr>
      <td width='20%' align='right' class='label' nowrap>&nbsp;Indicator Description</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
			<input type='text' name='qind' id='qind' size='60'  value='<%=qind_clind_desc%>'  maxlength='60'  readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;
	       </td>
    </tr>
  <tr>
           <td width='20%' >&nbsp;</td>
  	     <td width='60%' colspan='2'>&nbsp;</td>
  </tr>
  	<tr>
			<td class=label align=right>Periodicity</td>
			<td align=left>&nbsp;&nbsp;&nbsp;<select  name=period >
							<option value='X'>---------Select--------------&nbsp;&nbsp;&nbsp;
			    <%if(dflt_rep_periodicity1.equals("M"))
			{%>
				<option value='M'  selected>Monthly&nbsp;
			<%}else{%>
			    <option value='M' >Monthly&nbsp;
			   <%}%>
				     <%if(dflt_rep_periodicity1.equals("Q"))
			{%>
				<option value='Q'  selected>Quarterly&nbsp;
			<%}else{%>
			    <option value='Q' >Quarterly&nbsp;
			   <%}%>
			  <%if(dflt_rep_periodicity1.equals("B"))
			{%>
				<option value='B'  selected>Bi-Annually&nbsp;
			<%}else{%>
			    <option value='B' >Bi-Annually&nbsp;
			   <%}%>
			  <%if(dflt_rep_periodicity1.equals("A"))
			{%>
				<option value='A'  selected>Annually &nbsp;
			<%}else{%>
			    <option value='A' >Annually &nbsp;
			   <%}%>
			   </select></td>  
			   </tr>
			   <tr>
  <td width='20%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
  <tr>
      <td width='20%' align='right' class='label'>Age</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
			<input type='text' name='age' id='age' size='4'  value='<%=dflt_bd_age_range_id1%>'  maxlength='4' onBlur='ChangeUpperCase(this);'   onKeyPress='return(ChkNumberInput(this,event,0))'>&nbsp;
	       </td>
    </tr>
    <tr>
  <td width='20%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
			<tr>
			<td class=label align=right>Gender</td>
			<td align=left>&nbsp;
			 <%if(dflt_bd_by_gender_yn1.equals("Y")){%>
			   <input type='checkbox'  checked name=gender id=gender value='Y'  onclick="genYN(this)">
			   <%}else{%>
			   <input type='checkbox'  name=gender id=gender   value='N'  onclick="genYN(this)">
			   <%}%>
			   </td>
		</tr>
  <td width='20%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
	<td width='20%' >&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
  </table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
</form>
</body>
</html>

