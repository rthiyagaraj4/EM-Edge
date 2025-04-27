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
        <script src="../../eSM/js/CreatUserDesktop.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
</head>
<%
	Connection con			= null;
	ResultSet rs2			= null;
	PreparedStatement stmt2 = null; 
	StringBuffer menuoptsql	= new StringBuffer(); 

	String menu_id_opt		=	"";
	String short_desc_opt	=	"";
	
	//String disl				= "disabled";
	//String dis="";
	String str1				= "";
	//String menu_id="";
	//String menu_name="";

	String deft_menu_id				= "";
	String deft_menu_name				= "";

	String code="";
	String name="";
	String eff_status="";
	String module_id="";
	String other_read_only="";
	String disableval="";



	//String desktop_summary_type="";
	String operation 				= request.getParameter( "operation" ) ;
	if ( operation == null ) operation="insert";
	

		code=request.getParameter("Desktop_code");
		if ( code == null ) code="";
		name=request.getParameter("Desktop_name");
		if ( name == null ) name="";
		eff_status =request.getParameter("eff_status");
		if ( eff_status == null )
			 eff_status="E";
			
	module_id = request.getParameter("module_id");
	if ( module_id == null ) module_id="";


	if(eff_status.equals("D")){
       other_read_only="readonly";
		disableval = "disabled";
	}

try
{
		con	= ConnectionManager.getConnection();
%>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' >
	<form name="Construct_ca_menu_form" id="Construct_ca_menu_form" action="../../servlet/eSM.CreateUserDesktopServlet" method="post" target="messageFrame">

	<table border="0" cellpadding="3" cellspacing="0" width='85%' align='center'>
	 <tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td class="COLUMNHEADER" colspan=4><b><fmt:message key="eSM.Summary.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.menu.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Customisation.label" bundle="${sm_labels}"/></b></td>
	</tr>

</table>
	
	
	<table border="0" cellspacing="0" cellpadding="3" width="85%" align='center' >
			
				
			<!--<tr>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.MenuOptions.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.MenuStructure.label" bundle="${ca_labels}"/></td>
			<td class='columnHeader' colspan=1></td>
			</tr>-->

			<tr>
	<td width="50%" class="label" >&nbsp;&nbsp;</td><td width="50%" class="fields"><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp; <select name="Menu" id="Menu"  Onchange="loadTree()" <%=disableval%> >
	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

	<%
		stmt2=con.prepareStatement("select DESKTOP_SUMMARY_ID,DESKTOP_SUMMARY_NAME from SM_DESKTOP_SUM_HDR where SYS_USER_DEF_IND ='S' AND DESKTOP_SUMMARY_TYPE='C' ");
			
		rs2=stmt2.executeQuery();
		 while(rs2.next())	
			{		 
				deft_menu_id=rs2.getString("DESKTOP_SUMMARY_ID");
			    deft_menu_name=rs2.getString("DESKTOP_SUMMARY_NAME");
			   
			
			out.println("<option value='"+deft_menu_id+"'>"+deft_menu_name+"</option>");
		

			}
			if (stmt2 != null) stmt2.close();
			if (rs2 != null) rs2.close();

	%>	
	</select></td>
  </tr>
		<!--<tr><td class='label' width='25%'><b>Summary Header</b></td><td class='label'></td></tr>-->
			<tr>
				<td class='fields' ><b><fmt:message key="eSM.Summary.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.Header.label" bundle="${common_labels}"/></b><br><Select name="Menuopts" id="Menuopts"   <%=disableval%> rowspan="5" size="50" style="HEIGHT: 140px; WIDTH: 275px" Onclick="Menufun()">
				<% // 187px   275px
				if(menuoptsql.length() > 0) menuoptsql.delete(0,menuoptsql.length());
				/*menuoptsql.append("select menu_id, short_desc from ");
				menuoptsql.append("ca_menu_header where ");
				menuoptsql.append("root_menu_yn='N' and ");
				menuoptsql.append("eff_status='E' union all ");
				menuoptsql.append("select option_id,");
				menuoptsql.append("nvl(user_def_short_desc,short_desc)"); menuoptsql.append(" short_desc from ca_option where ");
				menuoptsql.append("option_type='M' order by 2");*/
				/*menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='T' AND APPLICABLE_MODULE_ID='CA'");

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
				}*/

			menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='T' AND APPLICABLITY_SCOPE='C' ");
		
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
					
					%>	
								
			<%	

				}
				if (stmt2 != null) stmt2.close();
				if (rs2 != null) rs2.close();
				
				menuoptsql.delete(0,menuoptsql.length());




	%>	
		</Select>
	
	<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
		<!-- <td class='COLUMNHEADERCENTERr'><b>Summary Links</b></td>-->
		<tr>
			<td class='fields' ><b><fmt:message key="eSM.Summary.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="eSM.Links.label" bundle="${sm_labels}"/></b><br>
			<Select name="funcopt" id="funcopt"  <%=disableval%> rowspan="5"  valign="top" size="5" style="HEIGHT: 140px; WIDTH: 275px" Onclick="clearfun()" ><!-- 197px   275px -->
			
			<%
			menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='S' and APPLICABLITY_SCOPE='C' ");
		
		stmt2= con.prepareStatement(menuoptsql.toString());
		rs2=stmt2.executeQuery();
			
				str1="#2#F";  
				
				while(rs2.next())
				{ 
					menu_id_opt		=	rs2.getString("menu_id");
					short_desc_opt	=	rs2.getString("short_desc");

					if(menu_id_opt == null)		menu_id_opt="";
					if(short_desc_opt == null)	short_desc_opt="";
					
				out.println("<option value='"+menu_id_opt+str1+"'>"+short_desc_opt+"</option>");
				

				}
				if (stmt2 != null) stmt2.close();
				if (rs2 != null) rs2.close();

			
			
			%>
			
			</select></td>
		</tr>
	</table></td>
	
	<td class='fields'><b><fmt:message key="eSM.Selected.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.Items.label" bundle="${common_labels}"/></b>
			<Select name="MainMenus" id="MainMenus"   <%=disableval%> size="15" style="HEIGHT: 290px; WIDTH: 337px" Onclick="putVal()" scrolling="auto"></td> <!-- 390px   337px -->

		<td class='label' >&nbsp;</td>
		<!--<td class='fields' width="4%" valign="center">
			<input type='button' name='Up' id='Up'		class="Button" value=" ^ " Onclick="MoveIndex(1)">
			<input type='button' name='Down' id='Down'		class="Button" value=" v " Onclick="MoveIndex(2)">
			<input type='button' name='Remove' id='Remove'	class="Button" value=" X " Onclick="remove()">
			<input type='button' name='Right' id='Right'	class="Button" value=" > " Onclick="MoveIndex(3)">
			<input type='button' name='Left' id='Left'		class="Button" value=" < " Onclick="MoveIndex(4)"></input>
		</td>-->
 	  </tr>
	  <tr><td>&nbsp;</td><td><input type='button' name='Up' id='Up'		class="Button" value=" ^ " Onclick="MoveIndex(1)">
			<input type='button' name='Down' id='Down'		class="Button" value=" v " Onclick="MoveIndex(2)">
			<input type='button' name='Right' id='Right'	class="Button" value=" > " Onclick="MoveIndex(3)">
			<input type='button' name='Left' id='Left'		class="Button" value=" < " Onclick="MoveIndex(4)"></input>
			<input type='button' name='Remove' id='Remove'	class="Button" value=" X " Onclick="remove()">
			</td></tr>
	</table>
  </td>
</tr>
</table>

	<input type="hidden" name='mode' id='mode' value = '<%=operation%>'>
	<input type="hidden" name='desktop_chart' id='desktop_chart' value =''>
	<input type="hidden" name='desktop_code' id='desktop_code' value ='<%=code%>'>
	<!--<input type="hidden" name='Menu' id='Menu' value =''>-->

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
	e.printStackTrace();
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}	

%>
<script>
if('<%=operation%>'=='modify')
{
	loadTreeonLoad();
}
</script>

