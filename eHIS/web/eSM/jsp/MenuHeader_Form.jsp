<!DOCTYPE html>
<html>  
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src="../../eSM/js/MenuHeader.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 			<style>
textarea {
  resize: none;
}
</style>
<%

	Connection con = null;
	try{
		request.setCharacterEncoding("UTF-8");		
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale	  = (String)session.getAttribute("LOCALE");
		con = ConnectionManager.getConnection(request);
		String Log_user= (String) session.getValue("login_user");
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		Statement stmt=null;
		ResultSet rset=null ;
		ResultSet rs=null ;
		ResultSet rs1=null ;
		String dat="";
		String menuid="";
		String menuname="";
		String resp_group_id="";
		String id="";
		String remarks="";
		String rtmenu="";
		String fnval="insert";
		String dflt_resp="";
		String stat="";
		String chk="";
		String root_menu_disable = "";
		
		menuid = request.getParameter("menu_id");
		if(menuid == null || menuid.equals(""))
			root_menu_disable = "";
		else
			root_menu_disable = "disabled";
		String tool_used="";
		String syDate = "";
		String submenu_id="N";
		String diffdate = "0";
		String diffdate1 = "0";
		String redOnly = "";
		String disableFld="";
		String fromdate = "";
		String todate = "";
		String adhoc_menu = "";
		String adhoc_menu_disable = "Disabled";
		String disableTool = "";
		stmt=con.createStatement();
		pstmt1 = con.prepareStatement("Select to_char(sysdate,'DD/MM/YYYY') from dual");
			rs1 = pstmt1.executeQuery();
			if(rs1.next())
				syDate = rs1.getString(1);
			if(rs1!=null)rs1.close();
			if(menuid != null ){
					fnval="modify";
					disableTool = "Disabled";
					pstmt=con.prepareStatement("Select menu_id, menu_name, root_menu_yn, resp_group_id, adhoc_menu_yn, trunc(sysdate)-trunc(adhoc_menu_eff_from) diffdate,to_char(adhoc_menu_eff_from,'dd/mm/yyyy') adhoc_menu_eff_from, to_char(adhoc_menu_eff_to,'dd/mm/yyyy') adhoc_menu_eff_to, remarks, dev_tool from sm_menu_hdr where menu_id = ? ");
					pstmt.setString(1,menuid);
					rset=pstmt.executeQuery();
					rset.next();
					menuid=rset.getString("menu_id");
					menuname=rset.getString("menu_name");	
					remarks=rset.getString("remarks");
					resp_group_id=rset.getString("resp_group_id");
					
					if(resp_group_id==null) resp_group_id="";
						adhoc_menu = rset.getString("adhoc_menu_yn");	
					if(adhoc_menu.equals("Y"))
						{
						adhoc_menu = "Checked";
						adhoc_menu_disable = "";
						}
					else
					{
						adhoc_menu = "";
						adhoc_menu_disable = "Disabled";
					}
				rtmenu=rset.getString("root_menu_yn");
				if(rtmenu.equals("N"))	
					{
						chk="";
					}
					else
					{
					chk="Checked";
					adhoc_menu_disable = "";
					}
				if(remarks==null) remarks="";
					tool_used = rset.getString("dev_tool");
				if(tool_used == null)tool_used="";
				fromdate = rset.getString("adhoc_menu_eff_from");	
				if(fromdate == null)	fromdate = "";
				if(!fromdate.equals(""))
				 {	
					fromdate=DateUtils.convertDate(fromdate,"DMY","en",locale);	 
				 }
				todate = rset.getString("adhoc_menu_eff_to");		
				if(todate == null)		todate = "";
				if(!todate.equals(""))
				 {	
				   todate=DateUtils.convertDate(todate,"DMY","en",locale);	
				 }
				diffdate = rset.getString("diffdate");
			
				if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";
				diffdate1 = diffdate;
			
				
				if(rset	!=	null)	rset.close();
				String sql_sub=" select SUBMENU_ID from sm_menu_dtl where submenu_id='"+menuid+"' ";
				if(stmt!=null) stmt.close();
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql_sub);
				if(rs!=null)
				{
					while(rs.next())
					{
						submenu_id=rs.getString("submenu_id");
						if(submenu_id==null) submenu_id="N";
						else submenu_id="Y";
					}
					if(rs !=	null)	rs.close();
				}

		
			}
		else
		{
			fnval="insert";
		}
		// if Menu admin has logged in....
			String sql="select resp_group_id from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1)  ";
			rset=stmt.executeQuery(sql);
			if (rset !=null)
			{
				while (rset.next())
				{
					resp_group_id=rset.getString(1);
				}
			}
					if(!resp_group_id.equals("")) dflt_resp="disabled";
					else dflt_resp="";
					
		
			if(menuid==null)	menuid="";
	%>		
		</head>

		<body onLoad="gifpop('<%=adhoc_menu%>');FocusFirstElement()" OnMouseDown="CodeArrest()"; onKeyDown = 'lockKey()';>
			<form name='menu_form' id='menu_form' action='../../servlet/eSM.MenuHeaderServlet' method='post' target='messageFrame'>
				<div>
				<br><br><br><br>
				<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
					<tr>
						<td width='25%'>&nbsp;</td>
						<td width='25%'>&nbsp;</td>
						<td width='25%'>&nbsp;</td>
						<td width='25%'>&nbsp;</td>
					</tr>

					<tr>
						 <td class='label' width='25%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
						 <td class='fields' width='25%'>
						 <%if(fnval.equals("modify"))
						 { 
							 stat="readonly";   
						}
						 %>
						<input type='text' name='menuid' id='menuid' SIZE='30' maxlength='30' value="<%=menuid%>" <%=stat%> onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></td>
						<td width='25%'></td><td width='25%'></td>
					</tr>
					<tr>
						<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					</tr>

					<tr>
						 <td class='label' width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
						 <td class='fields' width='25%'>
						 <input type='text' name='menuname' id='menuname' SIZE='30' maxlength='60' onBlur="makeValidString(this)"  value="<%=menuname%>">&nbsp<img src='../../eCommon/images/mandatory.gif' align='center'>
						 </td>
						 <td width='25%'></td><td width='25%'></td>
					   </tr>
					   <tr>
							<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					   </tr>

					 <tr>
							 <td class='label' width='25%'><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/></td>
							 <td class='fields' width='25%'>
							 <select name='resp_group_id' id='resp_group_id' <%=dflt_resp%> onchange='assign_resp(this)'>
								<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
								 <% 
								 String sql1="select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E'  order by 2 ";
								 rs = stmt.executeQuery(sql1);
								  while(rs.next()){
								id=rs.getString("resp_group_id");
								dat=rs.getString("resp_group_name");
								if(id.equals(resp_group_id))
								out.println("<option value=\"" + id + "\" selected>" + dat) ;
								else
								out.println("<option value=\"" + id + "\">" + dat );
								  }%>
								 </select>
							 </td>
							  <td width='25%'></td><td width='25%'></td>
					   </tr>
					   <tr>
							<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					   </tr> 
										
						<tr>
						<td class='label' width='25%'><fmt:message key="Common.RootMenu.label" bundle="${common_labels}"/></td>
						<td class='fields' width='25%'>
						<input type='checkbox' name='rootmenu' id='rootmenu' value='N'  onclick='CheckSubMenu()' <%out.print(chk);%> <%=root_menu_disable%>></td>
						<td  class='label'><fmt:message key="eSM.AdhocMenu.label" bundle="${sm_labels}"/></td>
						<td class='fields'>
							<input type='checkbox' name='adhocmenu' id='adhocmenu' value='N' onClick='CheckAdhocMenu()' <%=adhoc_menu%> <%=adhoc_menu_disable%>></td>
							<td width='25%'></td><td width='25%'></td>
						</tr>

						<tr>
							<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					   </tr> 
						<tr>
							<td width='25%' class="label"><b><fmt:message key="eSM.AdhocMenuEffectiveDate.label" bundle="${sm_labels}"/></b></td>
							<td width='25%'></td><td width='25%'></td><td width='25%'></td>
					   </tr> 

						<tr>
						<td class='label' width='25%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class='fields' width='25%'>
						<%
				if (Integer.parseInt(diffdate)>0)
					{
					redOnly = "readonly";
					disableFld = "disabled";
					}
				else
					{
					redOnly = "";
					disableFld = "";
					}
					%>
						<!-- CheckDate(this);-->
		<input type='text'  name='from_date' id='from_date' size='10' maxlength='10' value='<%=fromdate%>' <%=redOnly%> onBlur="if (!this.readOnly) {ChkDates1(this);}" readonly><input type='image' name="from_cal" id="from_cal" src="../../eCommon/images/CommonCalendar.gif" disabled <%=disableFld%> onClick="document.getElementById('from_date').focus();return showCalendar('from_date');">&nbsp;<img id = "giffrom" src='../../eCommon/images/mandatory.gif' align='center'></td>

		<td class='label' width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<input type='text'  name='to_date' id='to_date' size='10' maxlength='10' value="<%=todate%>" onBlur="if (!this.readOnly) {ChkDates(this);}"  readonly ><input type='image' name="to_cal" id="to_cal" disabled src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('to_date').focus();return showCalendar('to_date');">&nbsp;<img id = "gifto" src='../../eCommon/images/mandatory.gif'align='center'></td>
						</tr>
					   <tr>
							<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					   </tr> 
						
						<tr>
						<td class='label' width='25%'><fmt:message key="eSM.ToolUsed.label" bundle="${sm_labels}"/></td>
						<td class='fields' width='25%'>
						<select name='tool_used' id='tool_used' <%=disableTool%>>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
						<% if(tool_used.equals("")) { %>
							<option value='F' ><fmt:message key="eSM.Forms.label" bundle="${sm_labels}"/></option>
							<option value='J' ><fmt:message key="eSM.Java.label" bundle="${sm_labels}"/></option>
						<%	} else if(tool_used.equals("F")) { %>
							<option value='F' Selected><fmt:message key="eSM.Forms.label" bundle="${sm_labels}"/></option>
							<option value='J' ><fmt:message key="eSM.Java.label" bundle="${sm_labels}"/></option>
						<%  } else if(tool_used.equals("J")) { %>
							<option value='F' ><fmt:message key="eSM.Forms.label" bundle="${sm_labels}"/></option>
							<option value='J' Selected><fmt:message key="eSM.Java.label" bundle="${sm_labels}"/></option>
						<% } %>
						</select><img src='../../eCommon/images/mandatory.gif' align='center'></td>
						<td width='25%'></td><td width='25%'></td>
						</tr>
						<tr>
							<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					</tr>
						
					<tr>
							 <td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
							 <td class='fields' width='25%'>
							 <textarea name='remarks' rows="4" cols="30"  onBlur="makeValidString(this)" onkeypress='checkMaxLimit(this,200)'><%out.print(remarks);%></textarea>
							 </td>
							 <td width='25%'></td><td width='25%'></td>
					 </tr> 
							 
							 </td>
						</tr>
						<tr>
							<td width='25%' colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					</tr>

			</table>
			</div>
			<input type='hidden' name='function' id='function' value='<%=fnval%>'>
			<input type='hidden' name='diffdate1' id='diffdate1' value='<%=diffdate1%>'>
			<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
			<input type='hidden' name='resp_group_id1' id='resp_group_id1' value='<%=resp_group_id%>'>
			<input type='hidden' name='submenu_id' id='submenu_id' value='<%=submenu_id%>'>
		
		</form>
	</body>
	<%
	
		  if(rs		!=	null)	rs.close();
		  if(rs1	!=	null)	rs1.close();
		  if(rset	!=	null)	rset.close();
		  if(stmt	!=	null)	stmt.close();
		  if(pstmt	!=	null)	pstmt.close();
		  if(pstmt1	!=	null)	pstmt1.close();
			}catch(Exception e){out.println(e);}
			finally { 
			ConnectionManager.returnConnection(con,request);
		}			
%>
</html>

