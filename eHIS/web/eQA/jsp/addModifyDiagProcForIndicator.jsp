<!DOCTYPE html>
<html>

<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>

<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script type='text/javascript' src='../../eQA/js/QADiagProcForIndicator.js'></script>
<!-- <script type='text/javascript' src='../../eQA/js/QAValidate.js'></script> -->
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
		Connection conn=null;
		String mode="";
        String schemetypedisable=""; 
		String diagreadonly=""; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        String diag_proc_ind1="";
		String qind_clind_id=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
		String diag_proc_ind=request.getParameter("diag_proc_ind_code")==null ?"":request.getParameter("diag_proc_ind_code");	
		String scheme_type_code=request.getParameter("scheme_type_code")==null ?"":request.getParameter("scheme_type_code");	
		String diag_proc_code=request.getParameter("diag_proc_code")==null ?"":request.getParameter("diag_proc_code");	
	   mode=request.getParameter("mode")==null ?"":request.getParameter("mode");	

       conn = ConnectionManager.getConnection(request);
try
{
	
	if(!qind_clind_id.equals(""))
	{  
		
		pstmt=conn.prepareStatement("select QIND_CLIND_ID,DIAG_PROC_IND,SCHEME_TYPE,DIAG_PROC_CODE From QA_QIND_CLIND_DIAG_PROC  where QIND_CLIND_ID=? and DIAG_PROC_IND=? and SCHEME_TYPE=? and DIAG_PROC_CODE=?");
		pstmt.setString(1,qind_clind_id);
		pstmt.setString(2,diag_proc_ind);
		pstmt.setString(3,scheme_type_code);
		pstmt.setString(4,diag_proc_code);
		rs=pstmt.executeQuery();
		if(rs.next())			
		{
		 mode="U";
		 qind_clind_id=rs.getString("QIND_CLIND_ID");
System.err.println(rs.getString("DIAG_PROC_IND"));
		 diag_proc_ind=rs.getString("DIAG_PROC_IND");
		 scheme_type_code=rs.getString("SCHEME_TYPE");
		 diag_proc_code=rs.getString("DIAG_PROC_CODE");
		 
		schemetypedisable="disabled"; 
		diagreadonly="readonly"; 
	   }
	 }
	else
	 	 mode="I";

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
    }
catch(Exception ee)
{
	out.println("Error"+ee);
}
%>
	<body OnMouseDown='CodeArrest()'; onLoad='populateValues()' onKeyDown = 'lockKey()'>
	<form name='QA_QIND_CLIND_DIAG_PROC' id='QA_QIND_CLIND_DIAG_PROC' target='messageFrame' method='post' action = '../../servlet/eQA.QADiagProcForIndicator' >
	<BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>

  <tr>
  <td width='40%' >&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  <tr>
      <td width='40%' align='right' class='label'>Indicator ID</td>
      <td width='60%' align='left' colspan='2'>
      &nbsp;&nbsp;
	  <%if(mode.equalsIgnoreCase("U")){%>
		
    <Input type=text value='<%=qind_clind_id%>' name=qind_indicator ' readonly>
	  
	  
	  <%} else {	
		try
		  {
		  pstmt=conn.prepareStatement("select QIND_CLIND_ID,QIND_CLIND_DESC QADES,CLIND_CLASS From QA_QIND_CLIND where eff_status='E' and NVL(CLIND_CLASS,'*') NOT IN ('*','R','I') ORDER BY TO_NUMBER(QIND_CLIND_ID)");
		rs=pstmt.executeQuery();
	%>
		
	  <select name=qind_indicator id=qind_indicator onChange='populateValues();' onblur=' popScheme()'>
	 <option value=''>-----Select------</option>
	   <%while(rs.next())
		  {%>
		   
	  <option value='<%=rs.getString("qind_clind_id")%>'><%=rs.getString("qind_clind_id")%>
	  </option>
	    <%}	
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
			}catch(Exception e)
	  {
	  out.println(e);
	  }finally
		  {
			ConnectionManager.returnConnection(conn,request);
		  }
	  }
	  %>
	 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>	  
     </td>
	  </tr>
	  <tr><B><td colspan=4 class=label id='indicator' align=center></td></B></tr>
	  <tr><td colspan=4>&nbsp;</td></tr>
	  <tr>
	  <td width='40%' align='right' class='label' >&nbsp;Diag/Procedure</td>
      <td width='60%' align='left' >&nbsp;&nbsp;
	 <%if(mode.equals("U"))
	 {
	 if(diag_proc_ind.equals("D"))
		 {
	  diag_proc_ind1="Diagnosis";
		 }
		 else if(diag_proc_ind.equals("P"))
		 {
			 diag_proc_ind1="Procedure";
		 }else if(diag_proc_ind.equals("O"))
		 {
			 diag_proc_ind1="Orderable";
		 }%>
           
	 <Input type=text value='<%=diag_proc_ind1%>' id='diagdesc' name=diagdesc readonly>  
		   <Input type=hidden value='<%=diag_proc_ind%>' name='diag_proc_ind' id='diag_proc_ind'>
	 <%}else{%>
	   
	 <select name='diag_proc_ind'  id='diag_proc_ind' onChange=' popScheme()' >
   	 <option value=''>-----Select------</option>
	 	<!-- <option value='D' >Diagnosis</option>
		<option value='P' >Procedure</option>
		<option value='O' >Orderable</option>
 -->
	
	 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif' id='mandatorydiag'></img>	  
	 <%}%> 
	 </td>
</tr>
	   
	 <tr><td colspan=4>&nbsp;</td></tr>
	  <tr>
      <td width='40%' align='right' class='label'>&nbsp;Scheme Type</td>
      <td width='60%' align='left' colspan='2'>&nbsp;&nbsp;
			<select name='schema_type' id='schema_type' <%=schemetypedisable%>>
			<option value=''>------Select-------</option>
			<%if(diag_proc_ind.equals("D"))
		 {%>
			<%if(scheme_type_code.equals("1")){%>
			<option value='1' selected>ICD10</option>
			<%}else{%>
			<option value='1'>ICD10</option>
			<%} if(scheme_type_code.equals("2")){%>
			<option value='2' selected>ICD9-CM</option>
			<%}else{%>
			<option value='2'>ICD9-CM</option>
			<%}
		 }
			else if(diag_proc_ind.equals("P"))
			 {
			
			if(scheme_type_code.equals("3")){%>
			<option value='3' selected>CPT4</option>
			<%}else{%>
			<option value='3'>CPT4</option>
			<%} if(scheme_type_code.equals("4")){%>
			<option value='4' selected>ICD9-CM</option>
			<%}else{%>
			<option value='4'>ICD9-CM</option>
			<%} if(scheme_type_code.equals("6")){%>
			<option value='6' selected>ICD10-PCS</option>
			<%}else{%>
			<option value='6'>ICD10-PCS</option>
             <%}}%>
<!-- added by Shashi against SCR 3067 -->
			</select> <% if (mode.equalsIgnoreCase("I")){ %> &nbsp;<img src='../../eCommon/images/mandatory.gif' id='Schemetype'></img> <% } %>
	  </td>
</tr>

	 <tr><td colspan=4>&nbsp;</td></tr>
	  <tr>
      <td width='40%' align='right' class='label' nowrap id='diag'>&nbsp;Diag/Procedure Code</td>
      <td width='60%' align='left' colspan='2'>&nbsp;&nbsp;
	 
	 <Input type=text name='diagproccode' id='diagproccode'value='<%=diag_proc_code%>'size=10 maxlength=10 <%=diagreadonly%>></input>
    <img src='../../eCommon/images/mandatory.gif' ></img>
	  </td>
</tr>
	<tr><td colspan=4>&nbsp;</td></tr>  
	
      </td>
    </tr>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<!-- CLIND_CLASS hidden field is required used in intermediate jsp  -->
<input type=hidden name='CLIND_CLASS' id='CLIND_CLASS' value=''>
  </table>
</form>

</body>
</html>

