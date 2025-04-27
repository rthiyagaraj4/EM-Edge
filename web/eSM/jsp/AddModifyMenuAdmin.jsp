<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
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
		<script language='javascript' src='../../eSM/js/Menuadmin.js'></script>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>

		function validate_from_date(obj)
		{
			if(document.forms[0].function_name.value=="insert")
			{
				if(obj.value.length>0)
				if(validDateObj(obj,"DMY",localeName))
					DateValidation(obj);
				if(document.forms[0].eff_date_from.value!="" && document.forms[0].eff_date_to.value!="")
				{
					
					
					if(!(isBefore(document.forms[0].eff_date_from.value,document.forms[0].eff_date_to.value,"DMY",localeName)))
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
						document.forms[0].eff_date_to.value="";
						document.forms[0].eff_date_to.select();
						
					}
					

			}
			}
			else if(document.forms[0].function_name.value=="modify")
			{
				if(document.forms[0].eff_date_from.value=="")
				{
				
					if(obj.value.length>0)
					{
						if(validDateObj(obj,"DMY",localeName))
							DateValidation(obj);
					}
				}
				else
				{
					 
					if(obj.value.length<=0)
					{ 
						
						alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
						obj.select();
						obj.focus();
					}
					else
					{
						if(validDateObj(obj,"DMY",localeName))
						DateValidation(obj);
					}
				}
			}
		}
		function validate_to_date(obj)
		{
			if(document.forms[0].function_name.value=="insert")
			{
	
				if(document.forms[0].eff_date_from.value!="" && document.forms[0].eff_date_to.value!="")
				{
		
					if(validDateObj(obj,"DMY",localeName))
					{
					
						if(DateValidation(obj)){
					if(!(isBefore(document.forms[0].eff_date_from.value,document.forms[0].eff_date_to.value,"DMY",localeName)))
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
						obj.value="";
						obj.select();
						obj.focus();
					}
						}
					}
				}
				else
				{
					if(obj.value.length>0)
					{
						if(validDateObj(obj,"DMY",localeName))
							DateValidation(obj)


					}
				}
			}
			else if(document.forms[0].function_name.value=="modify")
			{
				
				if(document.forms[0].eff_date_from.value=="")
				{
					if(obj.value.length>0)
					{
						if(validDateObj(obj,"DMY",localeName))
						DateValidation(obj);
					}
				}
				else
				{
					if(validDateObj(obj,"DMY",localeName))
						if(DateValidation(obj)){					if(!(isBefore(document.forms[0].eff_date_from.value,document.forms[0].eff_date_to.value,"DMY",localeName)))
					{
						alert( getMessage('TO_DT_GR_EQ_FM_DT','SM') );
						obj.value="";
						obj.select();
						obj.focus();
					}
				}
				}
			}
		}

		function func1(obj)
		{
			var val=obj.value;
			var arr=val.split("~");
			var id1 = arr[0];
			var id2 = arr[1];
			var id3 = arr[2];
			document.forms[0].datefrom.value=id2;
			document.forms[0].dateto.value=id3;
		}
		function DateValidation(obj){
				curdate = document.Menuadmin_Form.cur_date;
				var msg="";
				if(obj.name=="eff_date_from")
				 msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
				if(obj.name=="eff_date_to")
				msg = getMessage("TO_DATE_LESS_SYSDATE","SM");
				
				if(!(isAfter(obj.value,curdate.value,"DMY",localeName))) {
					obj.value="";
					obj.focus();
					obj.select();
					
					alert(msg);
					return false;
				}else {
					return true;
				}
		}


		function doDateCheck1(from,to,messageFrame,val) 
		{
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				{
				if(val=="1")  
				{
					to.select();
				to.focus();
				}
				else if(val=="2") 
				{
					from.select();
					from.focus();
				}
				else if(val=="3")
				{
					
					to.select();
					to.focus();
				}
				else if(val=="4")
				{
					to.select();
					to.focus();
				}
				
				return false;
			}
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}
async function populateName(obj,target,target_id)
{
	var sql="";
	
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

		var tit				= getLabel("Common.name.label","common");
		sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E' and upper(appl_user_id) like upper(?) and upper(appl_user_name)  like upper(?) "



	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;


	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		target_id.value=arr[0];
		
	}
	else
	{
		target.value="";
		target_id.value="";
	}
}
				
	</script>
		<%
	        request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con=null;
			Statement stmt = null;
			Statement stmt_resp = null;
			try{
			con = ConnectionManager.getConnection(request);

			
			ResultSet rs =null;
			String menu_admin_id="";
			String menu_admin_name="";
			String resp_group_id="";
			String diffdate = "0";
			String redOnly = "";
			String disableFld="";
			String old_eff_date_from="";
			String old_eff_date_to="";
			String eff_date_from="";
			String eff_date_to="";
			
			String eff_status="";

			String chk_val="checked";
			
			String disabled="";
			String disableCalender="";
			String other_read_only="";
			String fn_val="insert";
			String to_date = "";

			

			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;

			String sql_date="Select to_char( sysdate,'dd/mm/yyyy') to_date from dual";
			stmt	=	con.createStatement();
			rs		=	stmt.executeQuery(sql_date);
			if(rs!=null)
			{
				if(rs.next())
				{
					to_date = rs.getString("to_date");
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			
			menu_admin_id=request.getParameter("menu_admin_id");
			menu_admin_name= request.getParameter("menu_admin_name");
			if(menu_admin_name ==null) menu_admin_name="";
			

			if(menu_admin_id!=null)
			{
				
				disabled="disabled";
				fn_val="modify";
				String sql="select resp_group_id,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1,trunc(sysdate)-trunc(eff_date_from) diffdate,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1, eff_status  from sm_menu_admin where menu_admin_id='"+menu_admin_id+"'";
				stmt	=	con.createStatement();
				rs		=	stmt.executeQuery(sql);
				if(rs!=null)
				{
					if(rs.next())
					{
						resp_group_id=rs.getString("resp_group_id");
						
						eff_date_from=rs.getString("eff_date_from1");
						if( eff_date_from==null ) 
						{
							eff_date_from="";
							old_eff_date_from="";
						}else
							eff_date_from = DateUtils.convertDate(eff_date_from,"DMY","en",localeName);
						old_eff_date_from=eff_date_from;

						
						eff_date_to=rs.getString("eff_date_to1");
						if( eff_date_to==null ) 
						{
							eff_date_to="";
							old_eff_date_to="";
						}else
							eff_date_to = DateUtils.convertDate(eff_date_to,"DMY","en",localeName);
						old_eff_date_to=eff_date_to;
						diffdate = rs.getString("diffdate");
						
						if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";
						
						
						eff_status=rs.getString("eff_status");
						
						if(eff_status.equals("D"))
						{
							other_read_only="readonly";
							chk_val="";
							disableCalender = "disabled";
						}
					}
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			else
			{
				menu_admin_id="";
			}

		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  onload='FocusFirstElement()'>
	<form name='Menuadmin_Form' id='Menuadmin_Form' method='post' action='../../servlet/eSM.MenuadminServlet' target='messageFrame' >
		<br><br><br><br><br><br><BR><BR><BR>
		<table border=0 cellspacing=0 cellpadding=0 width='80%' align=center>
			<tr>
				<td colspan=4 width+"25%">&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td class=label width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' colspan=3 nowrap>
				<% if(menu_admin_name.equals("")) { %>
					<input type='text' name='menu_admin_id_desc' id='menu_admin_id_desc' value="<%=menu_admin_name%>"  size='70' maxlength='30' onblur='if(this.value!="") populateName(this,menu_admin_id_desc,menu_admin_id)'><input type='hidden' name='menu_admin_id' id='menu_admin_id' value="<%=menu_admin_id%>"><input type='button' class='button' value='?' onClick='populateName(this,menu_admin_id_desc,menu_admin_id)' >
				<% }  else { %>
					<input type='text' name='menu_admin_id_desc' id='menu_admin_id_desc' value="<%=menu_admin_name%>"  size='70' maxlength='30' readOnly><input type='hidden' name='menu_admin_id' id='menu_admin_id' value="<%=menu_admin_id%>">
				<% } %>
					
						
					 <img src='../../eCommon/images/mandatory.gif'></img></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td colspan=4 width="25%">&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td class=label width='25%' nowrap><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/></td>
				<td class='fields' width='25%' colspan=3>
					<select name='resp_group_id' id='resp_group_id' <%=other_read_only%> <%=disabled%>>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%
						try{
							String sql_resp="Select resp_group_id, resp_group_name  from sm_resp_grp where eff_status='E' order by 2";
							String id = "";
							String dat = "";
							String sel = "";
							stmt_resp=con.createStatement();
							ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									if(id.equals(resp_group_id))
										sel="selected";
									%>
									<option value='<%=id%>'<%=sel%>><%=dat%></option>
									<%
									sel = "";
								}
							}
							if(rs_resp!=null)rs_resp.close();
							if(stmt_resp!=null)stmt_resp.close();
						}
						catch( Exception e){out.println(e);}
						%>
					</select><img src='../../eCommon/images/mandatory.gif'></img></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td colspan=4 width="25%">&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td class=label width='25%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
				<%
				if (Integer.parseInt(diffdate)>0 )
				{
				redOnly = "readonly";
				disableFld = "disabled";
				}
			else
				{
				redOnly = "";
				disableFld = "";
				}
               if(eff_status.equals("D"))
						{
				          redOnly = "readonly";
						}
				%>
				<td class='fields' width='25%'><input type=text id='eff_date_from' <%=redOnly%> name='eff_date_from' value='<%=eff_date_from%>' size=10 maxlength=10 onblur='if (!this.readOnly) {validate_from_date(this);}' <%=other_read_only%> ><img  src="../../eCommon/images/CommonCalendar.gif" <%=disableCalender%> onClick="document.getElementById('eff_date_from').focus();return showCalendar('eff_date_from');" style="cursor='hand'"></td>


				<td class=label width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type=text id='eff_date_to' name='eff_date_to' value='<%=eff_date_to%>' size=10 maxlength=10  onblur='validate_to_date(this)' <%=other_read_only%>  ><img  src="../../eCommon/images/CommonCalendar.gif" <%=disableCalender%> onClick="document.getElementById('eff_date_to').focus();return showCalendar('eff_date_to');" style="cursor='hand'"></td>


			</tr>
			<tr>
				<td colspan=4 width="25%">&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td class=label width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' colspan=3><input type=checkbox name='eff_status' id='eff_status' value='E' <%=chk_val%>   >&nbsp;</td>
			</tr>
			<tr>
				<td colspan=4 width="25%">&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
		</table>
		<input type='hidden' name='function_name' id='function_name' value='<%=fn_val%>'>
		<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'>
		<input type='hidden' name='to_date11' id='to_date11' value='<%=to_date%>'>
		<input type='hidden' name='datefrom' id='datefrom' value=''>
		<input type='hidden' name='dateto' id='dateto' value=''>
		<input type='hidden' name='menu_admin_id1' id='menu_admin_id1' value='<%=menu_admin_id%>'>
		<input type='hidden' name='resp_group_id1' id='resp_group_id1' value='<%=resp_group_id%>'>
		<input type='hidden' name='old_eff_date_from' id='old_eff_date_from' value='<%=old_eff_date_from%>'>
		<input type='hidden' name='old_eff_date_to' id='old_eff_date_to' value='<%=old_eff_date_to%>'>
		<input type='hidden' name='cur_date' id='cur_date' value='<%=dateFormat.format( new java.util.Date() ) %>' >
		</form>
	</body>
</html>
<%
}catch(Exception e){out.println(e);}
			finally {
				
						ConnectionManager.returnConnection(con,request);
					}							
%>

