<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
   	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
   	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
   	<script src='../../eCommon/js/common.js' language='javascript'></script>
   	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
   	<script src='../../eSM/js/Responsibility.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>

<%

		request.setCharacterEncoding("UTF-8");	
		String locale	  = (String)session.getAttribute("LOCALE");
    	String Log_user   = (String) session.getAttribute("login_user"); 
		String Role_id ="";
		int Medadmin=0;
		String responsibility_id= (String) session.getAttribute("responsibility_id");
		String qmenuid= request.getParameter("menuid");
		if(qmenuid == null) qmenuid="";
		String desktopcode1= request.getParameter("desktop_code1");
		if(desktopcode1 == null) desktopcode1 ="";
		if(desktopcode1.equals(" ")) desktopcode1="";
			//desktopcode1=desktopcode1.trim();

		String qmenuname= request.getParameter("menuname");
		if(qmenuname == null) qmenuname ="";
		String sys_defined_yn= request.getParameter("sys_defined_yn");
		if(sys_defined_yn == null) sys_defined_yn="Y";
	
	
		 String  responsibilityID="";
		 String responsibilityName="";
 		 String menuid="";
		 String menuName="";
		 String menuname1="";
		 String remark="";
		 String effdatefrom="";
		 String effdateto="";
   
		 String old_eff_date_from="";
		 String old_eff_date_to="";
		 String eff_date_from="";
		 String eff_date_to="";
		 String diffdate = "0";
		 String redOnly = "";
		 String disableFld="";
		 String effstatus	="";
		 String resp_group_id	="";
		 String ora_role_id	="";

		 String id	="";
		 String dat	="";
		 String ListDisable	="";

		 StringBuffer str1=new StringBuffer();
		 String sql="";

		 String disable_resp="";
		 String chkBoxEffStatusAttribute="";

		 String eventFunctionForCase="";
		 String textAttribute="";
		 String disabledAttribute="";
		 String disableOnEnableFalse="";
		 String disable_others="";
		 String disable_others1="";
		 String desk_code="";
		 String desk_name="";
		 String d_code="";
		 String root_menu="";
		 String dev_tool="";
		 String userde="";

		
	
		Connection conn=null;
		Statement stmt=null;
		Statement stmt1=null;
		try{
			conn = ConnectionManager.getConnection(request);
			ResultSet rset=null;
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
			boolean newResponsibility=false;
	%>

  </head>

	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  onLoad="FocusFirstElement();"> 
	<form name='responsibility_form' id='responsibility_form' method='post' target='messageFrame' >

			
	<%
		stmt=conn.createStatement();
	/*	String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
		ResultSet rs=stmt.executeQuery(sqlRole);
		if (rs !=null){
			while (rs.next()){
						Role_id=rs.getString(1);
				}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}	

  	if(Role_id.equals("MEDADMIN"))	
			{
				
			}*/
		responsibilityID=request.getParameter("resp_id");
		if(responsibilityID==null){
		try{
			responsibilityID="";
			responsibilityName="";

			String sql1 = "select menu_id,menu_name from sm_menu_hdr where adhoc_menu_yn='N' and ROOT_MENU_YN='Y' order by menu_name";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql1);
			if(str1.length() > 0) str1.delete(0,str1.length());
			str1.append("<select name='menu_id' id='menu_id'>");
			 str1.append("<option value=''>----------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------------------</option>"); 
			while(rset.next()){

					menuid=rset.getString("menu_id");
					menuName=rset.getString("menu_name");
					str1.append("<option value='"+menuid+"'>"+menuName);

				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				str1.append("</select>");
				str1.setLength(0);

				remark="";
				effdatefrom="";
				effdateto="";
				effstatus="E";
				chkBoxEffStatusAttribute="checked";

			}catch(Exception e){
				
			}
			
			newResponsibility=true;
			
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
			textAttribute="";
			disabledAttribute="";
		}else{
				newResponsibility=false;
				textAttribute="READONLY";

                   
			 try{

				 sql = "select resp_id,resp_name,menu_id,resp_group_id ,ora_role_id, desktop_code  ,remarks,eff_date_from,trunc(sysdate)-trunc(eff_date_from) diffdate,eff_date_to,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1,eff_status from sm_resp  where resp_id='"+responsibilityID+"'" ;

				 stmt = conn.createStatement();
				 rset = stmt.executeQuery(sql);
				 rset.next();
				 responsibilityID=rset.getString("resp_id");

				 responsibilityName=rset.getString("resp_name");

				 qmenuid=rset.getString("menu_id");
				 if (qmenuid==null) qmenuid="";
				 d_code=rset.getString("desktop_code");
				 if (d_code==null) d_code="";

				 resp_group_id=rset.getString("resp_group_id");
				 if (resp_group_id==null) resp_group_id="";
				 ora_role_id=rset.getString("ora_role_id");
				 if (ora_role_id==null) ora_role_id="";

				 remark=rset.getString("remarks");

				 if(remark==null){

					remark="";
				 }

				 if(rset.getDate("eff_date_from") != null ){
						 java.util.Date date = rset.getDate("eff_date_from");
						 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
						 effdatefrom = formatter.format(date);
						 effdatefrom=DateUtils.convertDate(effdatefrom,"DMY","en",locale);
						 date = null;
						 formatter = null;
						 
					}else {
						effdatefrom="";
					}

				if ( rset.getDate("eff_date_to") != null){
						 java.util.Date date1 = rset.getDate("eff_date_to");
						 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
						 effdateto = formatter.format(date1);
					     effdateto=DateUtils.convertDate(effdateto,"DMY","en",locale);	 
						 date1 = null;
						 formatter = null;
					}else {
						effdateto="";
					}

							eff_date_from=rset.getString("eff_date_from1");
							if( eff_date_from==null ) 
							{
								eff_date_from="";
								old_eff_date_from="";
							}
							old_eff_date_from=eff_date_from;

							
							eff_date_to=rset.getString("eff_date_to1");
							if( eff_date_to==null ) 
							{
								eff_date_to="";
								old_eff_date_to="";
							}
							old_eff_date_to=eff_date_to;
							
							diffdate = rset.getString("diffdate");
							
							if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";
							

				effstatus=rset.getString("eff_status");

					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				if(effstatus.equals("D")){


					chkBoxEffStatusAttribute="";
					disabledAttribute="READONLY";
					disableOnEnableFalse="disabled";
					ListDisable="disabled";
					
				}else{

					chkBoxEffStatusAttribute="checked";

				}
				
               if(sys_defined_yn.equals("Y"))
                  ListDisable="disabled";
               
		   	
				if(!qmenuid.equals("")){

				sql="Select menu_id,menu_name,root_menu_yn, dev_tool from sm_menu_hdr where  root_menu_yn='Y' and menu_id ='"+qmenuid+"'";
					stmt = conn.createStatement();
					rset = stmt.executeQuery(sql);
					while(rset.next()){
						
						menuname1=rset.getString("menu_name");
						root_menu=rset.getString("root_menu_yn");
						dev_tool=rset.getString("dev_tool");
						}

					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
		}else{
					menuname1="";
				}


			if(!dev_tool.equals("J"))
			{
				userde="disabled";
			}
			else{
			}


	    //sql="select desktop_code , desktop_name  from sm_desktop_setup where desktop_code='"+d_code+"' ";

				if(!d_code.equals("")){

                    sql="select DESKTOP_SUMMARY_ID desktop_code, DESKTOP_SUMMARY_NAME desktop_name from SM_DESKTOP_SUM_HDR where DESKTOP_SUMMARY_ID='"+d_code+"' ";

					

					stmt = conn.createStatement();
					rset = stmt.executeQuery(sql);
					
					while(rset.next()){
						
						//desk_code=rset.getString("desktop_code");
						desktopcode1=rset.getString("desktop_code");
						desk_name=rset.getString("desktop_name");


						}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}else{
					desktopcode1="";
					desk_name="";
				}


			}catch(Exception e){
				out.println(e.toString());
			}

		

	
				if(responsibilityID!="")
				{

				//if(Role_id.equals("MEDADMIN"))
				//	{
						if(resp_group_id!="")
						{
							disable_resp="disabled";
						}
					//}
				}

		}


		
	/*	String sql_m="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and trunc (sysdate) >= nvl (trunc (eff_date_from), sysdate - 1) and trunc (sysdate) <= nvl (trunc (eff_date_to), sysdate + 1) ";
		stmt1=conn.createStatement();
		rset=stmt1.executeQuery(sql_m);
		if (rset !=null){
			while (rset.next()){
						Medadmin=Integer.parseInt(rset.getString(1));
				}
		if(rset!=null) rset.close();
		if(stmt1!=null) stmt1.close();
		}*/
		
	//if(!Role_id.equals("MEDADMIN"))
	//{
	/*	if(Medadmin==0 )
		{ 
		if(responsibilityID.equals(""))
			{
		
		%>
					  <script>
					 
					   alert(getMessage("MENUADMIN_CANNOT_CREATE_RESP","SM"));
					   parent.frames[1].location.href='../../eCommon/html/blank.html';
					   parent.frames[0].document.forms[0].create.disabled=true;
					  </script>
				  <%
			}
	else 
			{
				disable_others="readonly";
				disable_others1="disabled";
			}
		}*/
	//	}
   

	try{
	%>

			
			<br>
			<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
			
				<tr>
					<td width='25%'></td>
					<td class='label' width='25%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
					<td colspan='2' class='fields' width='25%'>
					<input type='text' name='resp_id' id='resp_id' value="<%=responsibilityID%>" size='20' onBlur="makeValidString(this);this.value=this.value.toUpperCase()" maxlength='20' onKeyPress="return CheckForSpecChars(event)"  <%=textAttribute%>  <%=disabledAttribute%> <%=eventFunctionForCase%> <%=disable_others%>>
					<img src='../../eCommon/images/mandatory.gif'></img></td>
					<td width='25%'></td>
			</tr>
				
				<tr>
				<td width='25%'></td>
				<td class='label' width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td colspan='2' class='fields' width='25%'>
					<input type='text' name='resp_name' id='resp_name' value="<%=responsibilityName%>"  onBlur="makeValidString(this)" size='30' maxlength='60' <%=disabledAttribute%> <%=disable_others%>>
					<img src='../../eCommon/images/mandatory.gif'></img></td>
					<td width='25%'></td>
				</tr>
				
			 <tr>
						<td width='25%'></td>
							 <td class='label' width='25%'><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/></td>
							<td class='fields' width='25%'>
							<select name='resp_group_id' id='resp_group_id'  onChange="clearMenu()" <%=ListDisable%> <%=disable_resp%> <%=disable_others1%>> 
								<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								 <% 
								 String sqlresp="select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E'  order by resp_group_name ";
								 stmt = conn.createStatement();
								 ResultSet rsresp = stmt.executeQuery(sqlresp);
								  while(rsresp.next()){
								id=rsresp.getString("resp_group_id");
								dat=rsresp.getString("resp_group_name");

								if(id.equals(resp_group_id))
									  {%>
									<option value='<%=id%>' selected><%=dat%>
									<%}
								else{%>

									<option value='<%=id%>'><%=dat%>

								 <%}
								 }
									if(rsresp!=null) rsresp.close();
									if(stmt!=null) stmt.close();
								  %>
								 </select>
							 </td>
							 <td width='25%'></td>
							 <td width='25%'></td>
					   </tr>
		  <tr>
		  <td>&nbsp;</td>
				 <td class=label><fmt:message key="Common.menu.label" bundle="${common_labels}"/></td>

				 <td  class='fields'>
				 <input type='text' name='menu_id_desc' id='menu_id_desc' value="<%=menuname1%>"   size='30' maxlength='30'
				 <%if(!(menuname1.equals("")) && (sys_defined_yn.equals("Y")))%>readonly <%=ListDisable%> onBlur='hideUserdesktop(this,menu_id);populateMenuBlur(this,menu_id_desc,menu_id)'><input type='hidden' name='menu_id' id='menu_id' value="<%=qmenuid%>"><input type='button' class='button' value='?'  onClick='populateMenu(this,menu_id_desc,menu_id)'<%=ListDisable%>>
				 &nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
	
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
				  </tr>
	  <tr class="label">
      </tr>	 
        <tr>
		<td>&nbsp;</td>
        <td class=label><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/></td>

				 <td  class='fields'>
				 <input type='text' name='dektop_id_desc' id='dektop_id_desc' value="<%=desk_name%>"   size='30' maxlength='30'   onblur='populateDesktopBlur(this,dektop_id_desc,desktop_code);desktop_code_valid();' <%=ListDisable%> <%=userde%> ><input type='hidden' name='desktop_code' id='desktop_code' value="<%=desktopcode1%>" <%=ListDisable%> ><input type='button' name='dektop_id_desc1' id='dektop_id_desc1' value="?"   size='30' maxlength='30'   onClick='populateDesktop(this,dektop_id_desc,desktop_code);desktop_code_valid()'<%=ListDisable%> <%=userde%> >

				 &nbsp;</td>
				  </tr>
     <tr class="label">
  </tr>
				<tr>
						<td width='25%'></td>
							 <td class='label' width='25%'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>
							 <td class='fields' width='25%'>
							 <select name='ora_role_id' id='ora_role_id'  <%=ListDisable%> <%=disable_others1%>>
								<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								 <% 
								 String sql1="select  ORA_ROLE_ID,  ORA_ROLE_ID ora_role from sm_ora_role where  ora_role_id not in ('MEDSTARTUP','MEDADMIN') order by  ORA_ROLE_ID";
								 stmt = conn.createStatement();
								 ResultSet rsrole = stmt.executeQuery(sql1);
								while(rsrole.next()){
								id=rsrole.getString("ORA_ROLE_ID");
								dat=rsrole.getString("ora_role");

								if(id.equals(ora_role_id))
									{%>
									<option value='<%=id%>' selected><%=dat%>
								<%}else{%>

									<option value='<%=id%>'><%=dat%>

								  <%}
								  }
									if(rsrole!=null) rsrole.close();
									if(stmt!=null) stmt.close();
								  %>
								 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
							 </td>
							 <td width='25%'></td>
							 <td width='25%'></td>
					   </tr>
				
				<td width='25%'></td>
					<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<textarea name='remarks' id='remarks' rows='4' onBlur="makeValidString(this)" cols='45' <%=disabledAttribute%> <%=disable_others%> onkeypress='checkMaxLimit(this,200)'><%=remark%></textarea>&nbsp;&nbsp;</td>
				<td width='25%'>&nbsp;&nbsp;</td>	
			</tr>		
			
				<tr >
					<td width='25%'></td>
				<td class="label" width='25%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
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
					<td class='fields' width='25%'>
					<input type='text' id='eff_date_from1' name='eff_date_from1' <%=redOnly%>  value="<%=effdatefrom%>" size='10' maxlength='10' <%=disabledAttribute%> <%=disable_others%> onblur='if (!this.readOnly) {validate_from_date(this);}'><img  src="../../eCommon/images/CommonCalendar.gif" name="fromDate1"<%=disableOnEnableFalse%> src="../../eCommon/images/CommonCalendar.gif" <%=disableFld%>  onClick="document.getElementById('eff_date_from1').focus();return showCalendar('eff_date_from1',null,null,true);" style="cursor='hand'">
					<input type='text'  name='eff_date_to1' id='eff_date_to1'  size='10' maxlength='10' value="<%=effdateto%>"  <%=disabledAttribute%> <%=disable_others%> onblur='validate_to_date(this);'><img  src="../../eCommon/images/CommonCalendar.gif" name="ToDate1" src="../../eCommon/images/CommonCalendar.gif" <%=disableOnEnableFalse%> onClick="document.getElementById('eff_date_to1').focus();return showCalendar('eff_date_to1',null,null,true);"></td>
					<td width='25%'></td>
					<td width='25%'></td>
				</tr>
			    		
			<tr>
				<td width='25%'></td>	
					<td class='label' width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td colspan='2' class='fields' width='25%'>
					<input type='checkbox' name='eff_status' id='eff_status' size='1' maxlength='1' value="<%=effstatus%>" <%=chkBoxEffStatusAttribute%> <%=disable_others1%> onClick="change()"></td>
					<td width='25%'></td>
				</tr>
			</table>
			
		<%  if(newResponsibility){%>

			<input type='hidden' name='function' id='function' value='insert'>
			<input type='hidden' name='function_name' id='function_name' value='insert'>
			<input type='hidden' name='Medadmin' id='Medadmin' value='<%=Medadmin%>'>

		  <%}else{ %>
			
			<input type='hidden' name='function' id='function' value='modify'>
			<input type='hidden' name='function_name' id='function_name' value='modify'>
		 <%}%>

			<input type='hidden' name='eff_date_from' id='eff_date_from' >
			<input type='hidden' name='menuid' id='menuid' value='<%=menuid%>'>
			<!--input type='hidden' name='desk_code1' value='<%=desk_code%>'-->
			<input type='hidden' name='desk_code1' id='desk_code1' value='<%=desktopcode1%>'>
				
			<input type='hidden' name='menuid_t' id='menuid_t' >
			<input type='hidden' name='resp_group_id1' id='resp_group_id1' >
			<input type='hidden' name='ora_role_id1' id='ora_role_id1' >
			<input type='hidden' name='Role_id' id='Role_id' value="<%=Role_id%>" >
			
			<input type='hidden' name='eff_date_to' id='eff_date_to' >
			<input type='hidden' name='cur_date' id='cur_date' value='<%=dateFormat.format( new java.util.Date() ) %>' >

			<input type='hidden' name='old_eff_date_from' id='old_eff_date_from' value='<%=old_eff_date_from%>'>
			<input type='hidden' name='old_eff_date_to' id='old_eff_date_to' value='<%=old_eff_date_to%>'>
			<input type='hidden' name='flagg' id='flagg' value=''>
			<input type='hidden' name='desktop_summary_type' id='desktop_summary_type' value='N'>

			</form>
			</body>
			</html>
<%
			
				}catch(Exception e){out.println("Error "+e);}
				
				}catch(Exception e){out.println(e);}
			finally {
				ConnectionManager.returnConnection(conn,request);
}
%>

