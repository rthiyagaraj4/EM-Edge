<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<%
			Connection	con		= null;
			Statement	stmt	=null;
			ResultSet	rs		=null;
			try
			{
				String locale		= (String)session.getAttribute("LOCALE");
				con			= ConnectionManager.getConnection(request);			
				String fid			= request.getParameter("Facility_Id");			
				if(fid == null)
					fid = (String) session.getValue("facility_id") ;
				String patid		= request.getParameter("Patient_ID");
				String encounterid	= checkForNull(request.getParameter("EncounterId"));
		%>
	</head>
	
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<%
			StringBuffer sqlQuery=new StringBuffer();
			if(patid!=null &&  (encounterid ==null || encounterid.equals("")))
				sqlQuery.append("select get_patient.get_line_detail('"+patid+"','"+locale+"') Pline FROM dual");
			else
				sqlQuery.append("select get_patient.get_line_detail('"+fid+"','"+encounterid+"','"+locale+"') Pline FROM dual");
			String name="";
			String en="";
			String id="";
			String pr="";

				stmt=con.createStatement();
			 	rs=stmt.executeQuery(sqlQuery.toString());
			 	if(rs!=null)
			 	{
			 		if(rs.next())
			 		{
			 			String s=rs.getString("Pline");
			 			StringTokenizer token=new StringTokenizer(s,"|");
			 			while(token.hasMoreTokens())
			 			{
			 				name=token.nextToken();
			 				id=token.nextToken();
			 				
			 				if(encounterid!=null &&  !encounterid.equals("") )
			 				{
			 					en=token.nextToken();
			 					pr=token.nextToken();
			 				}
			 			}
			 		}
			 	}
			
		%>
		<script>
			var eidar='<%=pr%>'.split(":");
			var pidar='<%=id%>'.split(":");
			var elab=""
			var evalu=""
			var plab=""
			var pvalu=""
			if(eidar!=null)
				{elab=eidar[0];evalu=eidar[1];}
			plab=pidar[0];pvalu=":"+pidar[1];

			if(elab==null || evalu=="")
				elab=" "
				
			if(evalu!=null || evalu!="")
			{
				evalu=":"+evalu				
			}

		</script>
		<table  width='100%' style="" border=0 valign='top' CELLSPACING=0 CELLPADDING=0>
			<tr>
				<td width='100%' class='IPCAHIGHERLEVELCOLOR'><FONT  size='2' ><b><%=name%></td>
				<td class='IPCAHIGHERLEVELCOLOR' align=right ID ='plab'><font size='-1' ><script>document.write(plab)</script></td>
				<td class='IPCAHIGHERLEVELCOLOR'><font size='-1' ><script>document.write(pvalu)</script></td>
			</tr>
			<tr>
				<td  width='100%' class='IPCAHIGHERLEVELCOLOR'><font size='-1' ><%=en%></td>
				<%if(encounterid!=null && !encounterid.equals("")){%>
				<td class='IPCAHIGHERLEVELCOLOR'><font size='-1' ><script>document.write(elab)</script></td>
				<td class='IPCAHIGHERLEVELCOLOR'><font size='-1' ><script>document.write(evalu)</script></td>
				<%}%>
			</tr>
		</table>
	</body>

<%
			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
	}catch(Exception e){out.println(e);}
	finally
	{
		ConnectionManager.returnConnection(con,request);			
	}
%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

