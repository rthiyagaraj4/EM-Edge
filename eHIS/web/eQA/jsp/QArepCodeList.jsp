<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%
	Connection con          = null;
	PreparedStatement pstmt = null;
	ResultSet rs            = null;
	String strd             = "";
	String locale=(String)session.getAttribute("LOCALE");
%>
<html>
<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/QACodeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code')"  onKeyDown = 'lockKey()' >
<form name="menu_form" id="menu_form" >
<BR>
<div align="left">
  <table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>
  <tr >
		<td width="20%" align="right" class="label"> </td>
		<td width="20%"></td>
		<td width="50%" align="left" class="label">
		<%=strd%>
		</td>
   </tr>
   <tr>
		 <td width="30%" align="right" class="label">Code &nbsp;</td>
	     <td width="20%" align="left" colspan="2"><select name="code" id="code"  onChange="codeCheck(this.value)" >
		<option value=' ' selected>&nbsp;------- Select -------&nbsp;
		<%
		try 
		{
			con = ConnectionManager.getConnection(request);
			if(con==null)out.println("one");
	        String sql = "select MASTER_CODE,TABLE_ID,MASTER_CODE_DESC  from sm_master_code_lang_vw where language_id = '"+locale+"' and module_id='MR' and table_id like 'QA%' order by MASTER_CODE";
			pstmt = con.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			if( rs != null )
			{
	          while( rs.next())
	          {
	        	String classname  = rs.getString("table_id") ;
	        	String classname1 = rs.getString("master_code_desc");
			%>
			<option value='<%= classname %>'><%= classname1 %>
			<%
	          }
	      }
if (rs    != null)  rs.close();
if (pstmt != null)  pstmt.close();
} 
catch(Exception e) {  out.println("in else "+e);}
finally {
 ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>
    </tr>
    <tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
   </table>
</form>
<script>document.forms[0].code.focus();</script>
</div>
</body>
</html>


