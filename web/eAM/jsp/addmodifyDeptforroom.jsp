<!DOCTYPE html>
<%--
	FileName	: addmodifyDeptforRoom.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>

<%
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	String facility_name=request.getParameter("facility_name");
		if(facility_name == null) facility_name="";
	String operating_facility_id=request.getParameter("operating_facility_id");
		if(operating_facility_id == null) operating_facility_id="";

	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String fnval="insert";
	String roomnum="";
	String rnum="";
	String dcode="";
	String scode="";
	String ofid="";
	String deptcode="";
	
	String shortdesc="";
	String deptdesc="";
	
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String facilityid = (String) session.getValue( "facility_id" ) ;
	String fid=p.getProperty( "login_user" ) ;
	
	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 


	rnum=request.getParameter("room_num");
	dcode=request.getParameter("dept_code");
	ofid=request.getParameter("operating_facility_id");

	try
	{
		con = ConnectionManager.getConnection(request);
	if(rnum != null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select * from am_dept_for_facility_room_vw where operating_facility_id=? and dept_code=? and room_num=?");
		pstmt.setString(1,ofid);
		pstmt.setString(2,dcode);
		pstmt.setString(3,rnum);
		rset=pstmt.executeQuery();
		rset.next();
		roomnum=rset.getString("room_num");
		shortdesc=rset.getString("room_short_desc");
		deptcode=rset.getString("dept_code");
		deptdesc=rset.getString("dept_short_desc");
		scode=rset.getString("service_code");

	}
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/Deptforroom.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	  var sStyle='<%=sStyle%>';
function PopService(nam,code){
		 if(nam=="department")
		 {
				var fnval="<%=fnval%>";
				if (fnval == "insert")
					var n=parent.f_query_add_mod.document.getElementById('service').length;
				else
					var n=1;

				for(var i=0;i<n;i++)
				{
					parent.f_query_add_mod.document.getElementById('service').remove("service");
				}

				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eAM/jsp/GetDeptRoom.jsp?Chksrc="+nam+"'><input name='Common_Text' id='Common_Text' type='hidden' value='"+document.getElementById("department").value+"'><input name='Service_code' id='Service_code' type='hidden' value='"+code +"'></form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.dum_form.submit();
		 }

}

function clear()
{
			var a=DeptRoom_form.service.length;
			for(var i=0;i<=a;i++)
			{
				DeptRoom_form.service.remove("service");
			}

			var tp ="";
			var opt=parent.f_query_add_mod.document.createElement("OPTION");
			opt.text=tp;
			opt.value="";

}
function populateDeptRoom(Obj)
{
		
		var n=parent.f_query_add_mod.document.getElementById("room").options.length;
		for(var i=0;i<n;i++)
		{
			parent.f_query_add_mod.document.getElementById("room").remove("room");
		}
		var n=parent.f_query_add_mod.document.getElementById("department").options.length;
		for(var i=0;i<n;i++)
		{
			parent.f_query_add_mod.document.getElementById("department").remove("department");
		}
	if(Obj.value !='')
	{
			var HTMLVal = new String();
			HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eAM/jsp/GetDeptRoom.jsp'> "+
					 " <input name='operating_facilityID' id='operating_facilityID' type='hidden' value='"+Obj.value+"'></form></BODY></HTML>";
			parent.dummy.document.write(HTMLVal);
			parent.dummy.document.dum_form.submit();
	}
	else
	{
		var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
		var opt=document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		document.forms[0].room.add(opt);
		
		var tp1 ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
		var opt1=document.createElement("OPTION");
		opt1.text=tp1;
		opt1.value="";
		document.forms[0].department.add(opt1);
	}
}
</script>
</head>

	<body  OnMouseDown="CodeArrest()"onLoad="FocusFirstElement();" onKeyDown = 'lockKey()'>
		<form name='DeptRoom_form' id='DeptRoom_form' action='../../servlet/eAM.DeptforroomServlet' method='post' target='messageFrame'>
			<div>
			<br><br><br><br><br><br><br><br><br><br><br>
			<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
			<tr>
				<td width='10%'>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
				</tr>
					<tr>
						<td width='10%'>&nbsp;</td>
						<td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
						<td  class='fields'>&nbsp;&nbsp;
						<%
						if(fnval.equals("modify"))
						{
						out.println("<input type='text' readOnly name='facility_name' id='facility_name' value=\""+facility_name+"\" size='50'>");
						out.println("<input type='hidden' name='facility' id='facility' value='"+operating_facility_id+"'>");
						
						} else { 
						%>
						
						<select name='facility' id='facility'  onChange='populateDeptRoom(this)'>
						 <option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
    				       <%
    				    		String ID="",dat1="",en1="";
    				    	    if(rset!=null)rset.close();
								if(stmt!=null)stmt.close();

								stmt=con.createStatement();
    				    		rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+fid+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat1=rset.getString("Operating_facility_id");
    				    			ID=rset.getString("facility_id");
    				    			if(ID.equals(facilityId))
    				    			  en1="selected";
    				    			else
    				    			    en1="";
    				    			out.println("<option value=\""+ID+ "\" "+en1+">"+dat1+"</option>");

    				    		   }
    				    		   }
    				    		   %>
    				    		   
						  </select>&nbsp;
						  <% } %> 
						  <img src='../../eCommon/images/mandatory.gif'align='center'>
					<td width='10%'>&nbsp;</td>
					</tr>

					<tr>
						<td width='10%'>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td width='10%'>&nbsp;</td>
					</tr>
				
				
				
    				<tr>
    				     <td>&nbsp;</td>
    				     <td class='label'><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
    				     <td class='fields'>&nbsp;&nbsp;
    				     <% if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' value=\""+shortdesc+"\" readonly>");
    				     	out.println("<img align='center' src='../../eCommon/images/mandatory.gif'>");
    				    	out.println("<input type='hidden' name='room' id='room' value=\""+roomnum+"\">");

    				     }
    				     else
    				     {%>
							 <select name='room' id='room'>
							 <option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				
    				    		  </select>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'>
    				    	<% 
    				    	}%>

    				   </td>
    				   <td>&nbsp;</td>
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				    <tr>
				     <td>&nbsp;</td>
    				     <td  class='label'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
    				     <td class='fields'>&nbsp;&nbsp;
    				      <%
    				      if(fnval.equals("modify"))
				          {
								out.println("<input type='text' name='p' id='p' value=\""+deptdesc+"\"  readonly>");
								out.println("<img align='center' src='../../eCommon/images/mandatory.gif'>");
								out.println("<input type='hidden' name='department' id='department' value=\""+deptcode+"\">");
				          }
    				     else
    				     {%>
    				   	<select name='department' id='department' onChange="PopService('department');clear()">
    				   	<option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				    
    				    	 </select>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'>
    				  <%}
							  %>
   				     </td>
   				     <td>&nbsp;</td>
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

	  				<tr>
	  				     <td>&nbsp;</td>
	    				     <td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	    				     <td class='fields'>&nbsp;&nbsp;
	    				     <select name='service' id='service' >
	    				     	<option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
	    				     </select>
	    				   	 </td>
	    				   	 <td>&nbsp;</td>
	    				   	 <%if(fnval.equals("modify")){%>
	    				   	 <script>
	    				   	  		PopService("department",'<%=scode%>');clear();
	    				   	 </script><%} else { %>
	    				   	 <script>populateDeptRoom(document.forms[0].facility)</script>
	    				   	 		<% } %> 
	    			</tr>
	    			<tr>
	    				<td>&nbsp;</td>
	    				<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
		</table>
		</div>

<%}
	catch(Exception e){e.printStackTrace();}

	finally
	{
		try{
	   	  if(rset!=null)	rset.close();
		  if(stmt!=null)	stmt.close();
	   	  if(pstmt!=null)	pstmt.close();
		}
		catch(Exception e)
		{}
		  ConnectionManager.returnConnection(con,request);
	}%>

		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>

	</form>
</body>
</html>

