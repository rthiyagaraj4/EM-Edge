<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
   request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eAM/js/MSpecialityLink.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function enable_txt(obj)
	{
		if(obj.value!='00')
		        
		  document.forms[0].search_txt.disabled=false;
		 		
		else
		{
          document.forms[0].search_txt.disabled=true;
		   document.forms[0].search_txt.value="";
		}
	}


</script>

</head>
<body onKeyDown = 'lockKey()'>
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String DB_module_id="";
String DB_module_name = "";
String sql = "";
%>
<form name="MSpecialityLinkMain_form" id="MSpecialityLinkMain_form"  onload='FocusFirstElement()'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='80%'  align='center'>
<tr>
	<td class=label><fmt:message key="eAM.SpecialityModule.Label" bundle="${am_labels}"/></td>
	<td><select name="speciality_module" id="speciality_module" onchange='clearDtl_Frame();'> 
	<option value='' selected>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
   
<% try
      {
        con=ConnectionManager.getConnection(request);		
		sql="SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE WHERE MODULE_GROUP_ID = 'SS' ORDER BY 2 ";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        DB_module_id=rs.getString(1);
					DB_module_name=rs.getString(2);
                    %>	
	               <option value="<%=DB_module_id%>"><%=DB_module_name%>
            <%  }
	  }%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% }catch(Exception e){out.println("exp"+e);}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
		out.println("exp"+e);
		}
}
%>

</td>
<td>&nbsp;</td>
</tr>

<tr>
	
	<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
	<td  colspan=2 class='fields' >
		<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
		<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<option value="01"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></option>
		<option value="02"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" disabled size=30 maxlength=30></td>
	
</tr>

<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
    <td align="right" class="button">
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDetailForm();"  ></td>
		<!--  <td align="right" class="button">&nbsp;</td> -->
</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


