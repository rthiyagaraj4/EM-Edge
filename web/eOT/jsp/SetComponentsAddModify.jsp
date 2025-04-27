<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/setcomponents.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
//RUT-CRF-0091
PreparedStatement pstmt_st=null;
ResultSet rst_st=null;
String customer_id="";
//RUT-CRF-0091
String mode=checkForNull(request.getParameter("update_mode_yn"));
String instr_code = checkForNull(request.getParameter("instr_code"));
String p_instr_code = instr_code;
String disable_flag=("modify".equals(mode))?"disabled":"";
String instr_code_disable="";
String short_desc="";
String sql="";
%>
<form name="SetComponentsHdr" id="SetComponentsHdr"  onload='FocusFirstElement()'  target="messageFrame"> 
	
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>

</tr>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/>
	<td width='25%' class="fields" colspan="2">
		<select name="instr_code" id="instr_code"  onchange='assignValues(this);' <%=disable_flag%> >
	<option value=''>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
<% 
	String select_flag = "";
	
	//Code altered by rajesh for PHASE 3
	//sql="SELECT  INSTR_CODE, SHORT_DESC FROM OT_INSTRUMENT  ORDER BY 1";
	sql="SELECT  INSTR_CODE, LONG_DESC FROM OT_INSTRUMENT_LANG_VW  WHERE LANGUAGE_ID= ? and   STATUS='E' ORDER BY 1";
	try{
	    con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		  while(rs.next()){
			  instr_code=rs.getString(1);
			  short_desc=rs.getString(2);
			  select_flag = (p_instr_code.equals(rs.getString(1)))?"selected":"";
%>	
	               <option value="<%=instr_code%>" <%=select_flag%> ><%=short_desc%></option>
				   
            <%}%>
	              
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% }catch(Exception e){e.printStackTrace();}
	  finally{
			try{
				 if(rs!=null) rs.close();
			     if(stmt!=null) stmt.close();
				 ConnectionManager.returnConnection(con);
			}catch(Exception e){e.printStackTrace();}
		}
//RUT-CRF-0091
		try
		{		
			con=ConnectionManager.getConnection(request);
			pstmt_st = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_st = pstmt_st.executeQuery();	
			if ( rst_st.next() && rst_st != null )
			{
				customer_id  =  rst_st.getString(1);
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
				//System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rst_st != null)   rst_st.close();
				if (pstmt_st != null) pstmt_st.close();	
				ConnectionManager.returnConnection(con);
				
			}
	//RUT-CRF-0091
%>
	</td>

</tr>

<tr>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
</tr>
<tr>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
	<td class=label width='25%'></td>
</tr>
</table>

<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name='customer_id' id='customer_id' value="<%=customer_id%>">
</form>
</body>
</html>

