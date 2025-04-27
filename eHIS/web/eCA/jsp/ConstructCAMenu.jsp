<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%

request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script> 
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCA/js/ConstructCAMenu.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	Connection con			= null;
	ResultSet rs2			= null;
	PreparedStatement stmt2 = null; 
	StringBuffer menuoptsql	= new StringBuffer();

	String menu_id_opt		=	"";
	String short_desc_opt	=	"";
	
	String disl				= "disabled";
	String str1				= "";
try
{
		con	= ConnectionManager.getConnection();
%>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
	<form name="Construct_ca_menu_form" id="Construct_ca_menu_form" action="../../servlet/eCA.ConstructCAMenuServlet" method="post" target="messageFrame">
	<table width="100%" border="0" cellpadding="3" cellspacing="0" align='center'>
	<tr>
		<td class="BORDER" width="100%">

			<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
						
			  <tr>
				  <td class='fields'width=25%><input type="radio" name="desktop_patient" id="desktop_patient" value="D"  onClick="Menu_Select(this)"><fmt:message key="eCA.Desktop.label" bundle="${ca_labels}"/><input type="hidden" name=desktop_hdn value=""></td>	
				<td class='fields'width=25%><input type="radio" name="desktop_patient" id="desktop_patient" value="P" onClick="Menu_Select(this)"><fmt:message key="Common.patientchart.label" bundle="${common_labels}"/><input type="hidden" name=patient_hdn value=""></td>
				
								
				<td  class='label'width=25%><fmt:message key="Common.MenuID.label" bundle="${common_labels}"/></td>
				<td class='fields'width=25%>
				<Select name="Menu" id="Menu" Onchange="loadTree()"><Option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---------</option>
											
				</select><img src="../../eCommon/images/mandatory.gif" align=middle></img></td>
				</tr>
					<tr>
					<td colspan ='4' width ='100%' align ='right'>
					<input type="button" name="default_menu" id="default_menu" class="Button" value='<fmt:message key="eCA.DefaultMenu.label" bundle="${ca_labels}"/>' <%=disl%> onClick="Call_default()">
					<input type='button' name="Preview" id="Preview" class="Button" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' Onclick="callpriview()"></input></td>
			</tr>

		</table>
    </tr>
<tr>
		<!--<td class="BORDER" width="100%">-->
		<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center' >
			<tr>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.MenuOptions.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.MenuStructure.label" bundle="${ca_labels}"/></td>
			<td class='columnHeader' colspan=1></td>
			</tr>
		
			<tr>
				<td class='fields' ><Select name="Menuopts" id="Menuopts" rowspan="5" size="5" style="HEIGHT: 187px; WIDTH: 275px" Onclick="Menufun()">
				<%
				if(menuoptsql.length() > 0) menuoptsql.delete(0,menuoptsql.length());
				menuoptsql.append("select menu_id, short_desc from ");
				menuoptsql.append("ca_menu_header where ");
				menuoptsql.append("root_menu_yn='N' and ");
				menuoptsql.append("eff_status='E' union all ");
				menuoptsql.append("select option_id,");
				menuoptsql.append("nvl(user_def_short_desc,short_desc)"); menuoptsql.append(" short_desc from ca_option where ");
				menuoptsql.append("option_type='M' order by 2");;
				stmt2= con.prepareStatement(menuoptsql.toString());
				rs2=stmt2.executeQuery();
			

				str1="#1#M";  
				
				while(rs2.next())
				{ 
					menu_id_opt		=	rs2.getString("menu_id");
					short_desc_opt	=	rs2.getString("short_desc");

					if(menu_id_opt == null)		menu_id_opt="";
					if(short_desc_opt == null)	short_desc_opt="";

					out.println("<option value='"+menu_id_opt+str1+"'>"+short_desc_opt+"</option>");
				}
	%>	
		</Select>
	
	<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
		<td class='COLUMNHEADERCENTERr'><fmt:message key="eCA.FunctionOptions.label" bundle="${ca_labels}"/></td>
		<tr>
			<td class='fields' >
			<Select name="funcopt" id="funcopt" rowspan="5"  valign="top" size="5" style="HEIGHT: 197px; WIDTH: 275px" Onclick="clearfun()" >
			</select></td>
		</tr>
	</table></td>

	<td class='fields'>
			<Select name="MainMenus" id="MainMenus" size="15" style="HEIGHT: 390px; WIDTH: 337px" Onclick="putVal()" scrolling="auto"></td>

		<td class='fields' width="6%" valign="center">
			<input type='button' name='Up' id='Up'		class="Button" value=" ^ " Onclick="MoveIndex(1)">
			<input type='button' name='Down' id='Down'		class="Button" value=" v " Onclick="MoveIndex(2)">
			<input type='button' name='Remove' id='Remove'	class="Button" value=" X " Onclick="remove()">
			<input type='button' name='Right' id='Right'	class="Button" value=" > " Onclick="MoveIndex(3)">
			<input type='button' name='Left' id='Left'		class="Button" value=" < " Onclick="MoveIndex(4)">
		</td>
 	  </tr>
	</table>
  </td>
</tr>
</table>

	<input type="hidden" name='mode' id='mode' value = 'INSERT'>
	<input type="hidden" name='desktop_chart' id='desktop_chart' value =''>

   </form>
 </body>
</html>
<%
	if(rs2!=null) rs2.close();
	if(stmt2!=null) stmt2.close();
}
catch(Exception e)
{
	out.println("Exception in ConstructCAMenu :"+e.toString());
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}	

%>

