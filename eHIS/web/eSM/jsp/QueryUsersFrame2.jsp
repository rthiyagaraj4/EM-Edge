<!DOCTYPE html>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		var sStyle="<%=sStyle%>";
		function populate_menu(obj)
		{
			
			n=parent.frames[1].document.forms[0].Menu.options.length;
			var Obj  = obj.value;
		    var arr =new Array();
			arr=Obj.split('#');
			common_Text = arr[1];
			for(i=0;i<n;i++) parent.frames[1].document.forms[0].Menu.remove("Menu");
			HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/GetQueryValues.jsp'><input name='Common_Text' id='Common_Text' type='hidden' value=' "+common_Text+ "'><input name='Chksrc' id='Chksrc' type='hidden' value='seven'></form></BODY></HTML>";
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.form1.submit();

		}
			
		async function displayaccess()
		{
		 var menu_val=parent.frames[1].document.forms[0].Menu.options.value;
		 var resp_id  = parent.frames[1].document.forms[0].Responsibility.options.value;
		 var arr =new Array();
		 arr=resp_id.split('#');
		 resp_id = arr[0];
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
			  var retVal = await window.showModalDialog("../../eSM/jsp/QueryUsersAccess.jsp?function_name="+escape(function_name)+"&access="+access+"&resp_id="+resp_id+"&menu_id="+menu_id+"&function_id="+function_id,arguments,features);

		}
		</script>
		<%
		request.setCharacterEncoding("UTF-8");
		Connection con=null;
		try{
			con = ConnectionManager.getConnection(request);
			String user_id=request.getParameter("user_id");
		%>
		</head>
		<body OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()';>
		<form name='frame2_form' id='frame2_form'>
		<table border=0 cellspacing=0 cellpadding=0 align=center width='102%'>
		<tr>
		<th align=left width='35%'>&nbsp;<fmt:message key="eSM.AssociatedResponsibilities.label" bundle="${sm_labels}"/>	</th>
		<th align=left width='65%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSM.AssociatedMenuFunctions.label" bundle="${sm_labels}"/></th>
		</tr>
		<tr>
		<tr>
				<td class='fields' width="35%">&nbsp;<Select name="Responsibility" id="Responsibility" size="5" style="HEIGHT: 160px; WIDTH: 267px" onclick='populate_menu(this)'>
				<%
					try{
							String id = "";
							String dat = "";
							String dat1 = "";
							String	sql_resp="Select A.Resp_Id, B.Resp_Name, B.Menu_Id from SM_RESP_FOR_USER A, SM_RESP B Where A.Appl_User_Id= '"+user_id+"' and A.Resp_Id = B.Resp_Id order by 2";
							out.println(sql_resp);
							Statement stmt_resp=con.createStatement();
							ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									dat1=rs_resp.getString(3);
									out.println("<option value='"+id+"#"+dat1+"'>"+dat+"</option>");
								}
							}
							if(stmt_resp!=null) stmt_resp.close();
							if(rs_resp!=null) rs_resp.close();
						}
						catch( Exception e){out.println(e);}
						
				%>
				
				</Select></td>
				<td class='fields' width="65%" rowspan="5" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;<Select name="Menu" id="Menu" size="15" onClick = 'return displayaccess()' style="HEIGHT: 360px; WIDTH: 280px" >
				
				</Select></td>
				</tr>
		<tr>
				<th align="left" width="35%" >&nbsp;&nbsp;<fmt:message key="eSM.AssociatedFacilities.label" bundle="${sm_labels}"/></th>
		</tr>
		<tr>
				<td width="35%" class="label" valign="bottom">&nbsp;<Select name="Facility" id="Facility" size="5" style="HEIGHT: 160px; WIDTH: 267px" >
				<%
				try{
							
							String id = "";
							String dat = "";
							String sql_fac="Select A.Facility_Id, B.Facility_Name from Sm_Facility_for_User A, Sm_Facility_Param B where A.Facility_Id = B.Facility_ID and A.Appl_User_Id = '"+user_id+"' order by 2";
							Statement stmt_fac=con.createStatement();
							ResultSet rs_fac=stmt_fac.executeQuery(sql_fac);
							if(rs_fac!=null)
							{
								while(rs_fac.next() )
								{
									id=rs_fac.getString(1);
									dat=rs_fac.getString(2);
									out.println("<option value='"+id+"'>"+dat+"</option>");
								}
							}
							if(stmt_fac!=null) stmt_fac.close();
							if(rs_fac!=null) rs_fac.close();
						}
						catch( Exception e){out.println(e);}	
						
				%>	
				</Select></td>
		</tr>

		</table>
		<input type="hidden" name="root_menu" id="root_menu" value ='' >
		<input type="hidden" name="User" id="User" value =<%=user_id%> >
		
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'><table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'><tr><td width='100%' id='t'></td></tr></table>
		
		</div>
		</form>
	</body>
<%
}catch(Exception e){out.println(e);}
finally { 
			ConnectionManager.returnConnection(con,request);
}			
%>
</html>

