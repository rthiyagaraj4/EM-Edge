<!DOCTYPE html>
<html>

<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>

<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script type='text/javascript' src='../../eQA/js/QAComplicationsForIndicator.js'></script>
	<script type='text/javascript' src='../../eQA/js/QAValidate.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript'  src='../../eCommon/js/MstCodeCommon.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String indicator_code="";
	String mode="";
	String complication_code = "";
	String complication_desc = "";

    
	try
	{
		indicator_code=request.getParameter("indicator_code")==null ?"":request.getParameter("indicator_code");	
		conn = ConnectionManager.getConnection(request);
		if(!indicator_code.equals(""))
		{  
			pstmt=conn.prepareCall("select QIND_CLIND_ID indicator_code,COMPL_CODE complication_code,COMPL_DESCRIPTION complication_desc From QA_QIND_CLIND_COMPL where QIND_CLIND_ID=?");
			pstmt.setString(1,indicator_code);
			rs=pstmt.executeQuery();
			if(rs.next()==true)			
				{
					 mode="U";
					 indicator_code=rs.getString("indicator_code");
					 complication_code=rs.getString("complication_code");
					 complication_desc=rs.getString("complication_desc");
				} 
				if(pstmt!=null) pstmt.close();
	            if(rs!=null) rs.close();
				if((indicator_code==null) || (indicator_code.equals("null")))
					indicator_code="";
				if((complication_code==null) || (complication_code.equals("null")))
					complication_code="";
                if((complication_desc==null) || (complication_desc.equals("null")))
					complication_desc="";

					
		}
		else
	 	 mode="I";
   

%>
<body onload='populateDesc()'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name='QA_Complications_Indicator' id='QA_Complications_Indicator' target='messageFrame' method='post' action = '../../servlet/eQA.QAComplicationForIndicatorServlet'  >
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
<tr>
	<td width='20%' >&nbsp;</td>
	<td width='80%' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td width='20%' >&nbsp;</td>
	<td width='80%' colspan='2'>&nbsp;</td>
</tr>
<tr>
  <td width='20%' align='right' class='label'>Indicator ID&nbsp;&nbsp;</td>
  <td width='80%' align='left' colspan='2' class='label'>
  <%if(mode.equals("U")){%>
 <INPUT TYPE="text" name="indicator_code" id="indicator_code" value=<%=indicator_code%> readonly> 
  
  <%}else{%>
  <select name='indicator_code' id='indicator_code' onchange='populateDesc()'>
  
  <option value=''>--------Select----------</option>
  <%
	 
	  pstmt = conn.prepareStatement("select qind_clind_id,qind_clind_desc from qa_qind_clind WHERE EFF_STATUS='E' order by	to_number(qind_clind_id)");
	  rs = pstmt.executeQuery();
	  if(rs!=null)
	  {
		  while(rs.next())
		  {
			  if(indicator_code.equals(rs.getString(1)))
			  {
			  %>
				<option value='<%=rs.getString(1)%>' selected><%=rs.getString(1)%></option>
			  <%}else{%>
    			  <option value='<%=rs.getString(1)%>'><%=rs.getString(1)%></option>
			  <%}
		  }
	  }     if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
  }
  %>
 </select>
 &nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
 </td>
 </tr>
 <tr>
	<td width='20%' >&nbsp;</td>
	<td width='80%' colspan='2'>&nbsp;</td>
 </tr>
 <tr>
	<td width='20%' >&nbsp;</td>
	<td width='80%' colspan='2' class=label>
	<label name='indicator' id='indicator'></label></td>
 </tr>
 <tr>
	<td width='20%' >&nbsp;</td>
	<td width='80%' colspan='2'>&nbsp;&nbsp;</td>
 </tr>
 <tr>
      <td width='20%' align='right' class='label'>Complication Code&nbsp;&nbsp;</td>
      <td width='80%' align='left' colspan='2'>
      
	  <%if(mode.equalsIgnoreCase("U")){%>
			<input type='text' name='complication_code' id='complication_code' size='10'  value="<%=complication_code%>"  maxlength='4' onBlur='ChangeUpperCase(this);' readonly onKeyPress='return CheckForSpecChars(event)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	  <%} else {%>
		  <input type='text' name='complication_code' id='complication_code' size='10'    value=''  maxlength='4' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	  <%}%>
      </td>
</tr>
<tr>
	<td width='20%' >&nbsp;</td>
	<td width='80%' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td width='20%' align='right' class='label'>Description&nbsp;&nbsp;</td>
	<td width='80%' align='left' >
	<input type='text' name='complication_desc' id='complication_desc' size='70'  value="<%=complication_desc%>" maxlength='60' >&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td width='30%' >&nbsp;</td>
	<td width='70%' colspan='2'>&nbsp;</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value="<%=mode%>">
<input type='hidden' name='indicator_desc' id='indicator_desc' value=''>
</form>
<%           if(rs!=null)rs.close();
			 if(pstmt!=null)pstmt.close();
	   }
	  catch(Exception e)
	  {
		   out.println("Exception in addModifyQAComplicationsForIndicator"+e.toString());
	  }
finally
{ 
    ConnectionManager.returnConnection(conn, request);
	
}
%>

</body>
</html>

