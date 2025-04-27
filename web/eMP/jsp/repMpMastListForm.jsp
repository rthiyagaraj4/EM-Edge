<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<%
	//String cliniccode="";
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	String strd="";

%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/codeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code')" onKeyDown = 'lockKey()'>
<form name="menu_form" id="menu_form" >
<BR>
<div align="left">

  <table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>

     <tr >
      <td width="20%" class="label"> </td>
      <td width="20%"></td>

    <td width="50%" class="label">
    <%=strd%>
    </td>

     </tr>


     <tr>
     <!--td width='10%'>&nbsp;</td-->
      <td width="30%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
<!--       <td width="20%" align="left" colspan="2"><select name="code" id="code" onClick="codeCheck(this.value)" onChange="codeCheck(this.value)" > -->
	        <td width="20%" class='fields' colspan="2"><select name="code" id="code"  onChange="codeCheck(this.value)" >
	<option value=' ' selected>---------------------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------------------------
<%
try {
		//con = (Connection) session.getValue( "connection" );
		con = ConnectionManager.getConnection(request);
	      if(con==null)out.println("one");
	      
	      String sql = "Select  table_id,master_code_desc from sm_master_code_lang_vw where module_id='MP' and language_id='"+localeName+"' order by master_code_desc";
		  pstmt = con.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      if( rs != null )
	      {
			  String classname="";
			  String classname1="";
	          while( rs.next())
	          {
	        	 classname = rs.getString("table_id") ;
	        	 classname1=rs.getString("master_code_desc");
	        	//cliniccode=classname1;
%>
			<option value='<%= classname %>'><%= classname1 %>
<%
	          }
	      }

} catch(Exception e) {  out.println("in else "+e);}
finally {
  if (rs != null)   rs.close();
  if (pstmt != null) pstmt.close();
  if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>
    </tr>
   </table>
</div>
</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

