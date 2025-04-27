<!DOCTYPE html>
<%--
	FileName	: addHlthCareSettingType.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
<%
	//java.util.Date currentdate=new java.util.Date();
	//java.text.SimpleDateFormat sf=new java.text.SimpleDateFormat("dd/MM/yyyy");
	//String sysdt=sf.format(currentdate);


PreparedStatement pstmt=null;
ResultSet rset=null;
Connection conn = null;
try{
%>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function focusObj()
{
	document.forms[0].from_hcare_setting_type_code.focus();
}
</script>
<%@ page session="true" %>
</head>
<body  OnMouseDown="CodeArrest()" onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'> 
<form name="HlthCareSetgTypRestns_form" id="HlthCareSetgTypRestns_form" action="../../servlet/eAM.HlthCareSetgTypRestnsServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div >

  <table border="0" cellpadding="0" cellspacing="0" width='75%' align='center'>

  <tr class="label">
  	<td width="50%" class="label" >&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
    <td width="50%" class="label"><fmt:message key="eAM.FromHealthCareSettingType.label" bundle="${am_labels}"/></td>
    <td width="50%" class="fields">
	 <select name="from_hcare_setting_type_code" id="from_hcare_setting_type_code" style='width: 200px'>
	 <option value =''> --------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- </option>
	<%
		conn = ConnectionManager.getConnection(request);	
		pstmt = conn.prepareStatement(" select hcare_setting_type_code,short_Desc from am_hcare_setting_type  where EFF_STATUS='E' order by short_Desc ") ;
		rset = pstmt.executeQuery () ;
		if(rset != null)
		{
			while(rset.next())
			{
					out.println( "<option value=\""+rset.getString("hcare_setting_type_code")+"\" >"+rset.getString("Short_Desc")+"</option>" ) ; 
			}
		}

		if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
	%>
	</select>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
</tr>
<tr>
    <td width="50%" class="label"><fmt:message key="eAM.ToHealthCareSettingType.label" bundle="${am_labels}"/></td>
	<td width="50%" class="fields">
	   <select name="to_hcare_setting_type_code" id="to_hcare_setting_type_code" style='width: 200px'>
	   <option value =''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- </option>

	<%
		//rset.beforeFirst();

		pstmt = conn.prepareStatement(" select hcare_setting_type_code,short_Desc from am_hcare_setting_type  where EFF_STATUS='E' order by short_Desc ") ;
		rset = pstmt.executeQuery () ;
		
		if(rset != null)
		{
			while(rset.next())
			{
					out.println( "<option value=\""+rset.getString("hcare_setting_type_code")+"\" >"+rset.getString("Short_Desc")+"</option>" ) ; 
			}
		}

	%>
	</select>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
</tr>
<tr>
	<td width="50%" class="label"><fmt:message key="eAM.InpatientReferral.label" bundle="${am_labels}"/></td>
    <td width="50%" class="fields"><input type="checkbox" name="ip_referral_yn" id="ip_referral_yn" value="Y" ></td>
</tr>
<tr class="label">
   <td width="50%" class="label">&nbsp;</td>
   <td width="50%" colspan="2" class="label">&nbsp;</td>
</tr>
<tr>
	<td width="50%" class="label"><fmt:message key="eAM.OutpatientReferral.label" bundle="${am_labels}"/></td>
    <td width="50%" class="fields"><input type="checkbox" name="op_referral_yn" id="op_referral_yn" value="Y" ></td>
</tr>
<tr class="label">
	<td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
</tr>
</table>
</div>
<input type="hidden" name="function_name" id="function_name" value="insert">
</form>
</body>
<%
	  if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
  }
catch ( Exception e )
{
 e.printStackTrace();
}
finally{
  	
	ConnectionManager.returnConnection(conn,request);
}
%>
</html>

