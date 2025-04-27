
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
			
		function showSubfunctions(resp_id,module_id,menu_id,option_sequence_no,function_id,option_descriptor,num)
		{
			 var retVal =    new String();
			 var dialogHeight= "15" ;
			 var dialogWidth = "40" ;
			 var center = "1" ;
			 var dialogTop = "150";
			 var dialogLeft = "155";
			 var status="no";
			 var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; dialogLeft :" + dialogLeft;
			 var arguments   = "" ;
			 retVal = window.showModalDialog("../jsp/AddMenuRstrnForSubFunc.jsp?Step=Remove&ModuleID="+module_id+"&MenuID="+menu_id+"&OptionSequenceNo="+option_sequence_no+"&FunctionID="+function_id+"&FunctionVal="+option_descriptor+"&Resp_id="+resp_id,arguments,features);	
		}
		</script>

		<%
			Connection con=null;
			java.sql.Statement stmt = null;
			ResultSet rs =null;
			PreparedStatement pstmt = null;
			ResultSet prs =null;

			try{
			con = ConnectionManager.getConnection(request);
			stmt	=	con.createStatement();
			String resp_id=request.getParameter("resp_id");
			String menu_id=request.getParameter("menu_id");
			if (menu_id==null) menu_id="";
			
			String option_type_desc ="";

			String option_descriptor="";
			String option_sequence_no="";
			String option_type="";
			String excl_restrict_ind="";
			String module_id="";
			String function_id="";
			String submenu_id="";
			String insert_access_yn="";
			String update_access_yn="";
			String delete_access_yn="";
			String print_access_yn="";
			String query_only_access_yn="";
			String insert_checked="";
			String update_checked="";
			String delete_checked="";
			String print_checked="";
			String query_only_checked="";
			String insert_enabled="disabled";
			String update_enabled="disabled";
			String delete_enabled="disabled";
			String print_enabled="disabled";
			String query_enabled="disabled";

			String exclude_checked="";
			String rights_checked="";

			int num=0;
			int i=0;
			int j=1;
			String classValue = "" ;
%>
</head>
	<body  class='CONTENT'  onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()'>
	<form name='form2' id='form2'>
	</head>
	<body  class='CONTENT'  onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()'>
	<form name='form2' id='form2'>
		<b><fmt:message key="eSM.RestrictedSubmenuFunctionDetls.label" bundle="${sm_labels}"/></b>
		<table border=1 cellspacing=0 cellpadding=0 align=center width='100%'>
		<tr>
		<th rowspan=2 width='1%'><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></th>
		<th rowspan=2 width='1%'><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/></th>
		<th rowspan=2 width='5%' align=left><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
		<th rowspan=2 width='20%' align=left><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
		
          <th width='2%' align=left><fmt:message key="eSM.AccessLevel.label" bundle="${sm_labels}"/></th>
		<th rowspan=2 width='10%' align=left><fmt:message key="Common.Remove.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
	<th>&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;U&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;P&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q&nbsp;</th>
		</tr>
	<%	
			String sql_menu="Select menu_id,menu_name from sm_resp_vw where resp_id='"+resp_id+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_menu);
			if(rs!=null)
			{
				while(rs.next())
				{
					menu_id=rs.getString("menu_id");
					
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			StringBuffer sql_count=new StringBuffer();
			sql_count.append(" Select count(*) ");
			sql_count.append(" from SM_MENU_RSTRN_RESP_VW ");
			sql_count.append(" where RESP_ID='"+resp_id+"' ");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_count.toString());
			if(rs!=null)
				{
				while(rs.next()){
						i=rs.getInt(1);
					}
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			num=1;
			StringBuffer sql=new StringBuffer();
			sql.append(" Select OPTION_TYPE, OPTION_SEQUENCE_NO, ");
			sql.append(" EXCL_RESTRICT_IND, MODULE_ID, FUNCTION_ID, ");
			sql.append(" SUBMENU_ID, INSERT_ACCESS_YN, ");
			sql.append(" UPDATE_ACCESS_YN, DELETE_ACCESS_YN, ");
			sql.append(" PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, OPTION_DESCRIPTOR , MENU_ID ");
			sql.append(" from SM_MENU_RSTRN_RESP_VW ");
			sql.append(" where RESP_ID='"+resp_id+"' ");
			sql.append(" ORDER BY OPTION_TYPE, OPTION_DESCRIPTOR");
		
			String menu_id1="";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());
			if(rs!=null)
			{
				while(rs.next() &&  j<=i )
				{
					if ( j % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					option_type=rs.getString(1);
					if(option_type.equals("M")) option_type_desc="Menu";
					else if(option_type.equals("F")) option_type_desc="Function";

					option_sequence_no=rs.getString(2);

					excl_restrict_ind=rs.getString(3);
					if( excl_restrict_ind.equals("E") ) 
					{
						exclude_checked="checked";
						rights_checked="";
					}
					else if(excl_restrict_ind.equals("R"))
					{
						exclude_checked="";
						rights_checked="checked";
					}

					module_id=rs.getString(4);
					function_id=rs.getString(5);
					submenu_id=rs.getString(6);

					insert_access_yn=rs.getString(7);
					if(insert_access_yn!=null)
					if(insert_access_yn.equals("Y"))
					{
						insert_checked="checked";
						insert_enabled="";
					}
					else{
					insert_checked="";
					insert_enabled="disabled";
										
					}
					
					update_access_yn=rs.getString(8);
					if( update_access_yn!=null)
					if( update_access_yn.equals("Y"))
					{
					update_checked="checked";
					update_enabled="";
					}
					else{
					update_checked="";
					update_enabled="disabled";
					}

					delete_access_yn=rs.getString(9);
					if(delete_access_yn!=null)
					if( delete_access_yn.equals("Y"))
					{
					delete_checked="checked";
					delete_enabled="";
					}
					else{
					delete_checked="";
					delete_enabled="disabled";
					
					}

					print_access_yn=rs.getString(10);
					if(print_access_yn!=null)
					if( print_access_yn.equals("Y"))
					{
					print_checked="checked";
					print_enabled="";
					}
					else{
					print_checked="";
					print_enabled="disabled";
					}

					query_only_access_yn=rs.getString(11);
					if(query_only_access_yn!=null)
					if( query_only_access_yn.equals("Y")){
					query_only_checked="checked";
					query_enabled="";
					}
					else{
					query_only_checked="";
					query_enabled="disabled";

					}

					option_descriptor=rs.getString(12);
					if(option_descriptor==null) option_descriptor="";

					menu_id1=rs.getString(13);
					if(menu_id1==null)menu_id1="";

					pstmt = con.prepareStatement("Select count(*) from SM_SFUNC_RSTRN_RESP Where RESP_ID = '"+resp_id+"'  and MENU_ID  = '"+menu_id1+"'  and OPTION_SEQUENCE_NO  = '"+option_sequence_no+"'  and MODULE_ID  = '"+module_id+"'  and FUNCTION_ID = '"+function_id+"' ");
					prs = pstmt.executeQuery();

					int rec_count = 0;
					if(prs.next())
					{
						rec_count = prs.getInt(1);
					}if(prs != null)  prs.close();
					if(pstmt != null)  pstmt.close();

					%>

					<tr>
						<td align=center class='<%=classValue%>'><input type=checkbox name='RE<%=num%>' id='RE<%=num%>' value='E<%=exclude_checked%>' disabled></td>
					
					<td align=center class='<%=classValue%>'><input type=checkbox name='RA<%=num%>' id='RA<%=num%>' value='Y<%=rights_checked%>' disabled></td>

					
					<td align=center class='<%=classValue%>'><%=option_type_desc%></td>
		

					<%if(rec_count > 0){%>
						<td align=left class='<%=classValue%>'><a href="javascript:showSubfunctions('<%=resp_id%>','<%=module_id%>','<%=menu_id1%>','<%=option_sequence_no%>','<%=function_id%>','<%=option_descriptor%>','<%=num%>')"><%=option_descriptor%></a></td>
					<%}else%>
						<td align=left class='<%=classValue%>'><%=option_descriptor%></td>

					<td align=center class='<%=classValue%>'>&nbsp;&nbsp;<input type=checkbox name='RI' id='RI'<%=num%> value='Y' <%=insert_checked%> <%=insert_enabled%> disabled>&nbsp;&nbsp;
					<input type=checkbox name='RU<%=num%>' id='RU<%=num%>' value='Y' <%=update_checked%>  <%=update_enabled%> disabled>&nbsp;&nbsp;
					<input type=checkbox name='RD<%=num%>' id='RD<%=num%>' value='Y' <%=delete_checked%> <%=delete_enabled%> disabled>&nbsp;&nbsp;
					<input type=checkbox name='RP<%=num%>' id='RP<%=num%>' value='Y' <%=print_checked%>  <%=print_enabled%> disabled>&nbsp;&nbsp;
					<input type=checkbox name='RQ<%=num%>' id='RQ<%=num%>' value='Y' <%=query_only_checked%> <%=query_enabled%> disabled>&nbsp;&nbsp

					<td align=center class='<%=classValue%>'>
					<input type=checkbox name='RC<%=num%>' id='RC<%=num%>' value='Y'>
					<input type=hidden name='RO<%=num%>' id='RO<%=num%>' value='<%=option_sequence_no%>'>
					<input type=hidden name='RM<%=num%>' id='RM<%=num%>' value='<%=menu_id1%>'>
					<input type=hidden name='RS<%=num%>' id='RS<%=num%>' value='<%=submenu_id%>'>
					</tr>
			<%
					
					num++;
					j++;
				}
			}
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
	%>
		<input id='menu_id'  type=hidden name='menu_id' value='<%=menu_id%>'>
		</table>
		</form>
	</body>
<%
	if(rs != null)  rs.close();
	
	if(stmt != null)  stmt.close();
	

}catch(Exception e){out.println(e);}
finally 
{ 
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

