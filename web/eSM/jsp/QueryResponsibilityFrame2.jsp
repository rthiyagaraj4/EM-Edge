<!DOCTYPE html>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		function populate_menu()
		{
			
			n=parent.frames[1].document.forms[0].Menu.options.length;
			
			
			for(i=0;i<n;i++)
				parent.frames[1].document.forms[0].Menu.remove("Menu");

			HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> </HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='GetQueryValues.jsp?Chksrc=seven'><input name='Common_Text' id='Common_Text' type='hidden' value='"+document.getElementById("menu_id").value+ "'><input name='User' id='User' type='hidden' value='"+document.getElementById("User").value+"'></form></BODY></HTML>";
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.form1.submit();

		}
		async function displayaccess()
		{
		 var menu_val=parent.frames[1].document.forms[0].Menu.options.value;
		 var resp_val=parent.frames[1].document.forms[0].Menu.options.value;
		 var resp_val=parent.frames[0].document.forms[0].resp_id.options.value;
		 var menu_arr = new Array();
		 menu_arr = menu_val.split('#');
         var menu_id = menu_arr[0];
         var function_id = menu_arr[2];
         var func_type = menu_arr[4];
         var access = menu_arr[5];
         var function_name = menu_arr[6];
		 var dialogHeight= "11" ;
		 var dialogWidth = "27" ;                    
		 var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
         var arguments   = "" ;
		 if (func_type=="F")
			  var retVal = await window.showModalDialog("../../eSM/jsp/QueryUsersAccess.jsp?function_name="+escape(function_name)+"&access="+access+"&resp_id="+resp_val+"&menu_id="+menu_id+"&function_id="+function_id,arguments,features);

		}
		</script>
		<%
			Connection con=null;
			try{
				request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
			con = ConnectionManager.getConnection(request);

			String resp_id=request.getParameter("resp_id");
			String menu_id="";
			try{
					
					String	sql_menu="Select   menu_id from SM_RESP where resp_id='"+resp_id+"' ";

					Statement stmt_menu=con.createStatement();
					ResultSet rs_menu=stmt_menu.executeQuery(sql_menu);
					if(rs_menu!=null)
					{
						while(rs_menu.next())
						{
							menu_id=rs_menu.getString(1);
						}
					}
					if(rs_menu!=null) rs_menu.close();
					if(stmt_menu!=null) stmt_menu.close();
					
				}
				catch( Exception e){//out.println(e);
					e.printStackTrace();
				}
				finally
				{
				}
				


			%>
		</head>
		<body OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()'; >
		<form name='frame2_form' id='frame2_form'>
		<table border=0 cellspacing=0 cellpadding=0 align=center width='102%'>
		<tr>
		<th align=left width='35%'>&nbsp;<fmt:message key="eSM.AssociatedUsers.label" bundle="${sm_labels}"/>	</th>
		<th align=left width='65%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSM.AssociatedMenuFunctions.label" bundle="${sm_labels}"/></th>
		</tr>
		<tr>
		<tr>
				<td width="35%" class='fields'>&nbsp;<Select name="User" id="User" size="5" style="HEIGHT: 160px; WIDTH: 267px">
				
				<%
					try{
							
							String id = "";
							String dat = "";
							
							//String	sql_resp="Select   a.appl_user_id, a.appl_user_name from sm_appl_user a, SM_RESP_FOR_USER b where a.appl_user_id=b.appl_user_id and b.resp_id='"+resp_id+"' order by 2 ";
							//out.println(sql_resp);
							//Statement stmt_resp=con.createStatement();
							//ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							
							String	sql_resp="Select   a.appl_user_id, a.appl_user_name from sm_appl_user a, SM_RESP_FOR_USER b where a.appl_user_id=b.appl_user_id and b.resp_id=? order by 2 ";
							PreparedStatement pstmt = con.prepareStatement(sql_resp);
							pstmt.setString	(	1,	resp_id		);
							ResultSet rs_resp = pstmt.executeQuery();
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									%>
									<option value='<%=id%>'><%=dat%></option>
								<%}
							}
							
							if(rs_resp!=null) rs_resp.close();
							//if(stmt_resp!=null) stmt_resp.close();
							if(pstmt!=null) pstmt.close();
						}
						catch( Exception e){//out.println(e);
							e.printStackTrace();
						}
							
				%>
				
				</Select></td>
				<td class='fields' width="65%" rowspan="5" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;<Select name="Menu" id="Menu" size="15" onClick = return displayaccess()' style="HEIGHT: 360px; WIDTH: 280px" >
				
				</Select></td>
		</tr>
		<tr>
				<th width="35%" align=left>&nbsp;<fmt:message key="eSM.AssociatedFacilities.label" bundle="${sm_labels}"/></th>
		</tr>
		<tr>
				<td width="35%" class='fields' valign="bottom">&nbsp;<Select name="Facility" id="Facility" size="5" style="HEIGHT: 160px; WIDTH: 267px" >
				<%
				try{
							String id = "";
							String dat = "";
							//String sql_fac="Select A.Facility_Id, B.Facility_Name from SM_facility_for_resp A, Sm_Facility_Param B where A.Facility_Id = B.Facility_ID and upper(A.resp_id) = upper('"+resp_id+"') order by 2";
							//Statement stmt_fac=con.createStatement();
							//ResultSet rs_fac=stmt_fac.executeQuery(sql_fac);
							
							String sql_fac="Select A.Facility_Id, B.Facility_Name from SM_facility_for_resp A, Sm_Facility_Param B where A.Facility_Id = B.Facility_ID and upper(A.resp_id) = upper(?) order by 2";
							PreparedStatement pstmt_fac = con.prepareStatement(sql_fac);
							pstmt_fac.setString	(	1,	resp_id		);
							ResultSet rs_fac = pstmt_fac.executeQuery();
							if(rs_fac!=null)
							{
								while(rs_fac.next() )
								{
									id=rs_fac.getString(1);
									dat=rs_fac.getString(2);
									%>
									<option value='<%=id%>'><%=dat%></option>
								<%
								}
							}
							
							if(rs_fac!=null) rs_fac.close();
							//if(stmt_fac!=null) stmt_fac.close();
							if(pstmt_fac!=null) pstmt_fac.close();
						}
						catch( Exception e){//out.println(e);
							e.printStackTrace();
						}	
						
				%>	
				</Select></td>
		</tr>

		</table>
		<input type="hidden" name="root_menu" id="root_menu" value ='' >
		<input type="hidden" name="Responsibility" id="Responsibility" value=<%=resp_id%>> 
		<input type="hidden" name="menu_id" id="menu_id" value=<%=menu_id%>> 
		<script>
		populate_menu();
		</script>
		</form>
		
	</body>
<%
}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
			finally { 
	ConnectionManager.returnConnection(con,request);
}			
%>
</html>

