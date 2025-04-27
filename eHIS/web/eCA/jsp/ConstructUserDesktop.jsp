<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script> 
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCA/js/ConstructCAMenu_temp.js" language="javascript"></script>
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
	String menu_id="";
	String menu_name="";

	String code="";
	String name="";
	String eff_status="";
	String module_id="";
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


try
{
		con	= ConnectionManager.getConnection();
%>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
	<form name="Construct_ca_menu_form" id="Construct_ca_menu_form" action="../../servlet/eCA.CreateUserDesktopServlet" method="post" target="messageFrame">

	<table border="0" cellspacing="0" cellpadding="3" width="90%" align='center' >
			
				
			<tr>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.MenuOptions.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.MenuStructure.label" bundle="${ca_labels}"/></td>
			<td class='columnHeader' colspan=1></td>
			</tr>

			<tr>
	<td width="50%" class="label" >&nbsp;&nbsp;</td><td width="50%" class="fields">Default from &nbsp;&nbsp; <select name="Menu" id="Menu"  Onchange="loadTree()">
	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
	<%
	 try
		 {
			
		 stmt2=con.prepareStatement("select DESKTOP_SUMMARY_ID,DESKTOP_SUMMARY_NAME from SM_DESKTOP_SUM_HDR where SYS_USER_DEF_IND ='S'");
			rs2=stmt2.executeQuery();
		 while(rs2.next())
			{		 
				menu_id=rs2.getString("DESKTOP_SUMMARY_ID");
			    menu_name=rs2.getString("DESKTOP_SUMMARY_NAME");
			   
			%>			
			<option value='<%=menu_id%>'><%=menu_name%></option>;				
			<% 
			}
			if(stmt2 != null) stmt2.close();
			if(rs2 != null) rs2.close();
			//if(conn != null) conn.close();
			
			 }		 
		catch(Exception e) {
		e.printStackTrace() ;
			} 
			//}
		
			 %>



	
	</select></td>
  </tr>
		
			<tr>
				<td class='fields' ><Select name="Menuopts" id="Menuopts" rowspan="5" size="5" style="HEIGHT: 140px; WIDTH: 275px" Onclick="Menufun()">
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
	%>	
		</Select>
	
	<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
		<td class='COLUMNHEADERCENTERr'><fmt:message key="eCA.FunctionOptions.label" bundle="${ca_labels}"/></td>
		<tr>
			<td class='fields' >
			<Select name="funcopt" id="funcopt" rowspan="5"  valign="top" size="5" style="HEIGHT: 140px; WIDTH: 275px" Onclick="clearfun()" ><!-- 197px   275px -->
			</select></td>
		</tr>
	</table></td>

	<td class='fields'>
			<Select name="MainMenus" id="MainMenus" size="15" style="HEIGHT: 290px; WIDTH: 337px" Onclick="putVal()" scrolling="auto"></td> <!-- 390px   337px -->

		<td class='fields' width="4%" valign="center">
			<input type='button' name='Up' id='Up'		class="Button" value=" ^ " Onclick="MoveIndex(1)">
			<input type='button' name='Down' id='Down'		class="Button" value=" v " Onclick="MoveIndex(2)">
			<input type='button' name='Remove' id='Remove'	class="Button" value=" X " Onclick="remove()">
			<input type='button' name='Right' id='Right'	class="Button" value=" > " Onclick="MoveIndex(3)">
			<input type='button' name='Left' id='Left'		class="Button" value=" < " Onclick="MoveIndex(4)"></input>
		</td>
 	  </tr>
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
	//out.println("Exception in ConstructCAMenu :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}	

%>
<script>
if('<%=operation%>'=='modify')
{
	GetvaluesOnLoad('<%=module_id%>');
	//setTimeOut('',500);
	setTimeout("loadTreeonLoad()",1500);
	//loadTreeonLoad();
}

</script>

