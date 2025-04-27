<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function action1(obj)
		{
			
			var position="";
			if (obj.checked==true) 
			{
				position=obj.name.substring(2,4);

				
				comp_name=eval("document.forms[0].AA"+position);

				
				comp_name.disabled=true;
				comp_name.checked=false;
				comp_name=eval("document.forms[0].AC"+position);
				comp_name.checked=true;

				comp_name1=eval("document.forms[0].AX"+position);
				comp_name1.value=comp_name.value;
				comp_name.disabled=true;
			}
			else
			{
				position=obj.name.substring(2,4);
				comp_name=eval("document.forms[0].AC"+position);
				comp_name.checked=false;
				if(document.forms[0].option_type.value=="F")
				{
					comp_name=eval("document.forms[0].AA"+position);
					comp_name.disabled=false;
				}
			
			}
		}

		function action2(obj)
		{
			var position="";
			if (obj.checked==true) 
			{
				position=obj.name.substring(2,4);
				comp_name=eval("document.forms[0].AE"+position);
				comp_name.disabled=true;
				comp_name.checked=false;

				comp_name=eval("document.forms[0].AI"+position);
				if(comp_name.checked==true)
				comp_name.disabled=false;

				comp_name=eval("document.forms[0].AU"+position);
				if(comp_name.checked==true)
				comp_name.disabled=false;

				comp_name=eval("document.forms[0].AD"+position);
				if(comp_name.checked==true)
				comp_name.disabled=false;

				comp_name=eval("document.forms[0].AP"+position);
				if(comp_name.checked==true)
				comp_name.disabled=false;

				comp_name=eval("document.forms[0].AQ"+position);
				if(comp_name.checked==true)
				comp_name.disabled=false;

				comp_name=eval("document.forms[0].AC"+position);
				comp_name.checked=true;
				comp_name.disabled=true;
			}
			else
			{
				position=obj.name.substring(2,4);
				comp_name=eval("document.forms[0].AE"+position);
				comp_name.disabled=false;
				comp_name.checked=false;
				comp_name=eval("document.forms[0].AC"+position);
				comp_name.checked=false;
				comp_name.disabled=true;
				
				comp_name=eval("document.forms[0].AI"+position);
				if(comp_name.checked==true)
				comp_name.disabled=true;
				comp_name=eval("document.forms[0].AU"+position);
				if(comp_name.checked==true)
				comp_name.disabled=true;
				comp_name=eval("document.forms[0].AD"+position);
				if(comp_name.checked==true)
				comp_name.disabled=true;
				comp_name=eval("document.forms[0].AP"+position);
				if(comp_name.checked==true)
				comp_name.disabled=true;
				comp_name=eval("document.forms[0].AQ"+position);
				if(comp_name.checked==true)
				comp_name.disabled=true;
			}
		}

		function showSubfunctions(module_id,menu_id,option_sequence_no,function_id,function_name,number)
		{
	
			if(eval("document.forms[0].AE"+number+".checked") == false)
			{ 
			 var subfuncval = eval("document.forms[0].SF"+number+".value");

			 var retVal =    new String();
			 var dialogHeight= "15" ;
			 var dialogWidth = "40" ;
			 var center = "1" ;
			 var dialogTop = "355";
			 var dialogLeft = "155";
			 var status="no";
			 var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; dialogLeft :" + dialogLeft;
			 var arguments   = "" ;
			 retVal = window.showModalDialog("../jsp/AddMenuRstrnForSubFunc.jsp?Step=Add&ModuleID="+module_id+"&MenuID="+menu_id+"&OptionSequenceNo="+option_sequence_no+"&FunctionID="+function_id+"&FunctionVal="+function_name+"&SubFunctionValues="+subfuncval,arguments,features);	

			if(retVal != null)	
				eval("document.forms[0].SF"+number).value = retVal;
			else
				eval("document.forms[0].SF"+number).value = "";
			}
			else
			{
				alert(getMessage("FUNCTION_EXCLUDED",'SM'));
			}
		}

		</script>
		<%
			Connection con=null;
			Statement stmt = null;
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt = null;
			try{
	        request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			ResultSet rs =null;
			ResultSet prs =null;
			String name=request.getParameter("name");
			if(name==null) name="";
			
			String option_type=request.getParameter("option_type");
			String option_type_desc="";
			String access_disabled="";
	

			if(option_type.equals("M")) 
			{
				option_type_desc="Menu";
				access_disabled="disabled";
			}
			else if(option_type.equals("F")) 
			{
				option_type_desc="Function";
				access_disabled="";
			}


			String resp_id=request.getParameter("resp_id");
			String menu_id=request.getParameter("menu_id");
			String submenu_id=request.getParameter("submenu_id");
			if (submenu_id==null) submenu_id="";
			if(submenu_id.equals("")) submenu_id=menu_id;
			
			String menuid="";
			String function_id="";
			String module_id="";
			String option_sequence_no="";
			String option_descriptor="";

			String insert_access_yn="";
			String update_access_yn="";
			String delete_access_yn="";
			String print_access_yn="";
			String query_only_access_yn="";

			String insert_enabled="disabled";
			String update_enabled="disabled";
			String delete_enabled="disabled";
			String print_enabled="disabled";
			String query_enabled="disabled";

			String insert_checked="";
			String update_checked="";
			String delete_checked="";
			String print_checked="";
			String query_checked="";
			int num=0;
			int i=0;
			int j=1;
			String classValue = "" ;
			%>
	</head>
	<body OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()'>
	<form name='form4' id='form4'>
		<table border=1 cellspacing=0 cellpadding=0 align=center width='102%'>
		<tr>
		<th rowspan=2 width='1%' ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></th>
		<th rowspan=2 width='1%'><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/></th>
		<th rowspan=2 width='5%' align=left><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
		<th rowspan=2 width='20%' align=left><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
		<th width='5%'align=left><fmt:message key="eSM.AccessLevel.label" bundle="${sm_labels}"/></th>
		<th rowspan=2 width='5%' align=left><fmt:message key="Common.Add.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
		<th>&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;U&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;P&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q&nbsp;</th>
		</tr>
		<%
		
		if(!name.equals(""))
		{
			
			if(option_type.equals("M"))
			{
					
				num=1;
				String p_menu_id="";
				//String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b where a.menu_id = '"+menu_id+"' or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"' )  and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and a.subMENU_ID not in (Select subMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and OPTION_TYPE='M' )";				
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b where a.menu_id = ? or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ? )  and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper(?) and a.subMENU_ID not in (Select subMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and OPTION_TYPE='M' )";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	menu_id		);
				pstmt1.setString	(	2,	menu_id		);
				pstmt1.setString	(	3,	name+"%"		);
				pstmt1.setString	(	4,	resp_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				String sql="";
				//sql="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN,a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b where (a.menu_id = '"+menu_id+"' or a.menu_id in (Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"' ) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and  a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper('"+name+"%"+"')  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID='"+resp_id+"' and OPTION_TYPE='M') order by b.menu_name";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				sql="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN,a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b where (a.menu_id = ? or a.menu_id in (Select submenu_id  from sm_menu_dtl  where menu_id = ? ) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and  a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper(?)  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID=? and OPTION_TYPE='M') order by b.menu_name";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	menu_id		);
				pstmt1.setString	(	2,	menu_id		);
				pstmt1.setString	(	3,	name+"%"		);
				pstmt1.setString	(	4,	resp_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						p_menu_id=rs.getString("menu_id");
						if( p_menu_id==null )p_menu_id="";

						submenu_id=rs.getString("submenu_id");
						if( submenu_id==null )submenu_id="";

						module_id=rs.getString("module_id");
						if( module_id==null )module_id="";

						option_sequence_no=rs.getString("option_sequence_no");

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}
						%>
						
						<tr>
						<td align=center class='<%=classValue%>'>
						<input type=checkbox name='AE<%=num%>' id='AE<%=num%>' value='E' onclick='action1(this)'>
						</td>
						<td align=center class='<%=classValue%>'>
						<input type=checkbox name='AA<%=num%>' id='AA<%=num%>' value='Y' onclick='action2(this)'<%=access_disabled%>></td>
						<td align=center class='<%=classValue%>'><%=option_type_desc%></td>
						<td align=left class='<%=classValue%>'><%=option_descriptor%></td>
						<td align=center class='<%=classValue%>'>
						<input type=checkbox name='AI<%=num%>' id='AI<%=num%>' value='Y' <%=insert_enabled%>  <%=insert_checked%> disabled>&nbsp;&nbsp;
						<input type=checkbox name='AU<%=num%>' id='AU<%=num%>' <%=update_enabled%>  value='Y' <%=update_checked%> disabled>&nbsp;&nbsp;
						<input type=checkbox name='AD<%=num%>' id='AD<%=num%>' <%=delete_enabled%> value='Y' <%=delete_checked%> disabled>&nbsp;&nbsp;
						<input type=checkbox name='AP<%=num%>' id='AP<%=num%>' <%=print_enabled%> <%=print_checked%>  value='Y' disabled>&nbsp;&nbsp;
						<input type=checkbox name='AQ<%=num%>' id='AQ<%=num%>'  <%=query_enabled%> <%=query_checked%> value='Y' disabled>
						<td align=center class='<%=classValue%>'>&nbsp;&nbsp;
						<input type=checkbox disabled name='AC<%=num%>' id='AC<%=num%>' value='Y'>&nbsp;&nbsp;
						<input type=hidden name='AO<%=num%>' id='AO<%=num%>' value='<%=option_sequence_no%>'>
						<input type=hidden name='AM<%=num%>' id='AM<%=num%>' value='<%=module_id%>'>
						<input type=hidden name='AS<%=num%>' id='AS<%=num%>' value='<%=submenu_id%>'>
						<input type=hidden name='AN<%=num%>' id='AN<%=num%>' value='<%=p_menu_id%>'>
						<input type=hidden name='AX<%=num%>' id='AX<%=num%>' value=''>
						</tr>
						<%
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
					out.println("<input type=hidden name=submenu_id value='"+menu_id+"'>");
				}
			}	// second if
			else if(option_type.equals("F"))
			{
					System.err.println("************************");
				String p_menu_id="";
				num=1;
				//String  sql_count="Select count(*) from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='F' ";
				//System.err.println("sql_count================"+sql_count);
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String  sql_count="Select count(*) from SM_MENU_DTL where MENU_ID=? and upper(OPTION_DESCRIPTOR) like upper(?) and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and MENU_ID=? ) and OPTION_TYPE='F' ";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	resp_id		);
				pstmt1.setString	(	4,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}

				//String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='F'"; 
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID=? and upper(OPTION_DESCRIPTOR) like upper(?) and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID=? ) and OPTION_TYPE='F'"; 
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();

				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						menuid = rs.getString("menu_id");
						
						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						option_sequence_no=rs.getString("option_sequence_no");

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);

						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();
						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";
				%>
						<tr>
						<td align=center class='<%=classValue%>'>
							<input type=checkbox name='AE<%=num%>' id='AE<%=num%>' value='E' onclick='action1(this)'>
						</td>
						<td align=center class='<%=classValue%>'>
						<input type=checkbox name='AA<%=num%>' id='AA<%=num%>' value='Y' onclick='action2(this)' <%=access_disabled%> ></td>
							<td align=center class='<%=classValue%>'><%=option_type_desc%>
						</tds>	

					<%
					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");

						out.println("<td class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+" value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			
			  
			}
			//Added by Mallikarjuna Reddy on 19/06/2003 for List item Report
			else
				{
				String p_menu_id="";
				
				num=1;
				//String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and MENU_ID='"+submenu_id+"') and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID=? and upper(OPTION_DESCRIPTOR) like upper(?) and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and MENU_ID=?) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	resp_id		);
				pstmt1.setString	(	4,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				//String	sql =" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and  upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID='"+submenu_id+"'  ) and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql =" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID=? and  upper(OPTION_DESCRIPTOR) like upper(?) and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID=?  ) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						menuid = rs.getString("menu_id");
						
						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						option_sequence_no=rs.getString("option_sequence_no");

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);
						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();

						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");

						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+" value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			//End of Addition by Mallikarjuna Reddy on 19/06/2003 for List item Report
		}	// first if
		else 
		{
			
		
			if(option_type.equals("M"))
			{
				num=1;
				
	
			//String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = '"+menu_id+"' or  a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"') ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M'  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID='"+resp_id+"' and  OPTION_TYPE='M' )";
			//stmt=con.createStatement();
			//rs=stmt.executeQuery(sql_count);
			
			String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = ? or  a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ?) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M'  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID=? and  OPTION_TYPE='M' )";
			pstmt1   = con.prepareStatement(sql_count);
			pstmt1.setString	(	1,	menu_id		);
			pstmt1.setString	(	2,	menu_id		);
			pstmt1.setString	(	3,	resp_id		);
			rs		 = pstmt1.executeQuery();
			
				if(rs!=null){
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}

				String p_menu_id="";
				//String	sql ="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN, a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = '"+menu_id+"' or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"') ) and a.submenu_id = b.menu_id  and a.submenu_id is not null   and a.option_type='M' and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and  OPTION_TYPE='M' ) order by b.menu_name  ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql ="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN, a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = ? or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ?) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null   and a.option_type='M' and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and  OPTION_TYPE='M' ) order by b.menu_name  ";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	menu_id		);
				pstmt1.setString	(	2,	menu_id		);
				pstmt1.setString	(	3,	resp_id		);
				rs		 = pstmt1.executeQuery();
				
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						p_menu_id=rs.getString("menu_id");
						if( p_menu_id==null )p_menu_id="";

						submenu_id=rs.getString("submenu_id");
						if(submenu_id==null) submenu_id="";
                       
						module_id=rs.getString("module_id");
						option_sequence_no=rs.getString("option_sequence_no");
                        
						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+"  value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AS"+num+" value='"+submenu_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
             out.println("<input type=hidden name=submenu_id value='"+menu_id+"'>");
			}	// second if
			else if(option_type.equals("F"))
			{
				num=1;
				String p_menu_id="";
				StringBuffer sql_count=new StringBuffer();
				//sql_count.append(" Select count(*) from SM_MENU_DTL ");
				//sql_count.append(" where MENU_ID='"+submenu_id+"' and ");
				//sql_count.append("    ");
				//sql_count.append(" FUNCTION_ID not in ( ");
				//sql_count.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				//sql_count.append(" where RESP_ID='"+resp_id+"' and ");
				//sql_count.append(" MENU_ID='"+submenu_id+"'   ");
				//sql_count.append("  )");
				//sql_count.append("  and OPTION_TYPE='F' ");
				
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count.toString());
				System.err.println("sql_count.toString()============"+sql_count.toString());
				
				sql_count.append(" Select count(*) from SM_MENU_DTL ");
				sql_count.append(" where MENU_ID=? and ");
				sql_count.append("    ");
				sql_count.append(" FUNCTION_ID not in ( ");
				sql_count.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql_count.append(" where RESP_ID=? and ");
				sql_count.append(" MENU_ID=?   ");
				sql_count.append("  )");
				sql_count.append("  and OPTION_TYPE='F' ");
				
				pstmt1   = con.prepareStatement(sql_count.toString());
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				StringBuffer	sql =new StringBuffer();
				//sql.append(" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, ");
				//sql.append(" INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, ");
				//sql.append(" PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, ");
				//sql.append(" OPTION_DESCRIPTOR from SM_MENU_DTL ");
				//sql.append(" where MENU_ID='"+submenu_id+"' and ");
				//sql.append(" FUNCTION_ID not in ( ");
				//sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				//sql.append(" where RESP_ID='"+resp_id+"' and ");
				//sql.append(" MENU_ID='"+submenu_id+"'   ");
				//sql.append("  )");
				//sql.append("  and OPTION_TYPE='F' ");
					
//					out.println(sql);		
//System.err.println("sql====="+sql);	
	//			stmt=con.createStatement();
		//		rs=stmt.executeQuery(sql.toString());
				
				sql.append(" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, ");
				sql.append(" INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, ");
				sql.append(" PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, ");
				sql.append(" OPTION_DESCRIPTOR from SM_MENU_DTL ");
				sql.append(" where MENU_ID=? and ");
				sql.append(" FUNCTION_ID not in ( ");
				sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql.append(" where RESP_ID=? and ");
				sql.append(" MENU_ID=?   ");
				sql.append("  )");
				sql.append("  and OPTION_TYPE='F' ");
				
				pstmt1   = con.prepareStatement(sql.toString());
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						option_sequence_no=rs.getString("option_sequence_no");
						menuid=rs.getString("menu_id");

						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);
						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();

						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");
						
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+"  value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			}else
				{
				num=1;
				String p_menu_id="";
				//String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and   FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID='"+resp_id+"' and MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID=? and   FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID=? and MENU_ID=? ) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}

				//String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and  FUNCTION_ID not in ( Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and  MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID=? and  FUNCTION_ID not in ( Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and  MENU_ID=? ) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						option_sequence_no=rs.getString("option_sequence_no");
						menuid=rs.getString("menu_id");

						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);
						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();

						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");
						
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+"  value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			}
				
		}	
		out.println("<input type=hidden name=option_type value='"+option_type+"'>");

%>
		

		</table>
		</form>
	</body>
<%
	if(stmt != null) stmt.close();
	if(pstmt != null) pstmt.close();

}catch(Exception e){out.println(e);}

finally {
		ConnectionManager.returnConnection(con,request);
}			
%>
</html>

