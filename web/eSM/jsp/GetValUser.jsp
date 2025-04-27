<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<SCRIPT LANGUAGE="JavaScript">
<!--
//-->
</SCRIPT>
<%
    request.setCharacterEncoding("UTF-8");
	String roletype		= request.getParameter("role_type");
	String practtype = request.getParameter("pract_type");
	String practname = request.getParameter("pract_name");
	int count_am_practitioner_type=0;
	int count_am_practitioner=0;
	//String practitioner_type = request.getParameter("type_practitioner");
	
//	Connection con 	 = (Connection) session.getValue("connection");
	Connection con 	 = null;
	try{
	con = ConnectionManager.getConnection(request);


	Statement stmt=null;
	ResultSet rs = null;
	StringBuffer sql=new StringBuffer();
	String dat="";
	String id="";
	String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
	%>
	<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>
	<%

	try{
	
	if (!(roletype.equals("") || roletype == null))
		{			
			if (roletype.equals("P"))
            {
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select count(1) from all_tables where table_name='AM_PRACT_TYPE' ");
			}
			else if (roletype.equals("O"))
			{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select count(1) from am_other_staff_type");
			}
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql.toString()) ;

			if (rs != null)
			{
				while(rs.next())
				{
					count_am_practitioner_type=rs.getInt(1);
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			if(count_am_practitioner_type>0){			
	//END		
			if (practtype.equals("") || practtype==null)
			{
            if (roletype.equals("P"))
            {
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select PRACT_TYPE, DESC_USERDEF from am_pract_type where eff_status = 'E' and sysdate >= nvl(eff_date_from,sysdate) and sysdate <=  nvl(eff_date_to,sysdate) ORDER BY 2");
			if (( practtype!=null) && (!practtype.equals("")) )
			sql.append("   and PRACT_TYPE='"+practtype+"'");
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql.toString()) ;

			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("DESC_USERDEF");
					id=rs.getString("PRACT_TYPE");
		%>
					<script>
							var p = "<%=practtype%>";
							var d = "<%=id%>";
							var element = parent.frames[1].document.createElement('OPTION');
							element.text = "<%=dat%>";
							element.value= "<%=id%>";
							if (d ==p)
								element.selected=true;
							parent.frames[1].document.forms[0].pract_type.add(element);

					</script>

<%
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
		  }//end of role type pract
		  else if (roletype.equals("O"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select OTHER_STAFF_TYPE, SHORT_DESC from am_other_staff_type where eff_status = 'E' ORDER BY 2");
					if (( practtype!=null) && (!practtype.equals("")) )
					sql.append("   and OTHER_STAFF_TYPE='"+practtype+"'");
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql.toString()) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("SHORT_DESC");
							id=rs.getString("OTHER_STAFF_TYPE");
				%>
							<script>
									var p = "<%=practtype%>";
									var d = "<%=id%>";
									var element = parent.frames[1].document.createElement('OPTION');
									element.text = "<%=dat%>";
									element.value= "<%=id%>";
									if (d ==p)
										element.selected=true;
									parent.frames[1].document.forms[0].pract_type.add(element);

							</script>
		<%
						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
					}
				}//end of role type otherstaff
		}//end of pract type
	}//new
}
if (!(practname.equals("") || practname == null)){
if (!(practtype.equals("") || practtype == null))
		{
		
           if (roletype.equals("P"))
            {
			   if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select count(1) from all_tables where table_name='AM_PRACTITIONER'");
			}
			else if (roletype.equals("O"))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select count(1) from AM_OTHER_STAFF");
			}
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql.toString()) ;
			if (rs != null)
			{
				while(rs.next())
				{
					count_am_practitioner=rs.getInt(1);
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			
			if(count_am_practitioner>0){	
            if (roletype.equals("P"))
            { 
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select practitioner_id, SHORT_NAME from am_practitioner where PRACT_TYPE ='"+practtype+"'  and eff_status = 'E' and sysdate >= nvl(eff_date_from,sysdate) and sysdate <=  nvl(eff_date_to,sysdate) ");
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql.toString()) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("SHORT_NAME");
							id=rs.getString("practitioner_id");

				%>
							<script>
									var p = "<%=practname%>";
									var d = "<%=dat%>";
									var element = parent.frames[1].document.createElement('OPTION');
									element.text = "<%=dat%>";
									element.value= "<%=id%>";
									if (p ==d)
										element.selected=true;
									parent.frames[1].document.forms[0].pract_name.add(element);

							</script>

		<%
						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
					  }
			}//end of role type pract
			else if (roletype.equals("O"))
			{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select OTHER_STAFF_ID, OTHER_STAFF_NAME from AM_OTHER_STAFF where  OTHER_STAFF_TYPE='='"+practtype+"'' and eff_status='E'");
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql.toString()) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("OTHER_STAFF_NAME");
							id=rs.getString("OTHER_STAFF_ID");

				%>
							<script>
									var p = "<%=practname%>";
									var d = "<%=dat%>";
									var element = parent.frames[1].document.createElement('OPTION');
									element.text = "<%=dat%>";
									element.value= "<%=id%>";
									if (p ==d)
										element.selected=true;
									parent.frames[1].document.forms[0].pract_name.add(element);

							</script>

		<%
						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
						}
			}//end of role type other staff
}//NEW ADDED BY P.SUDHAKARAN end count
}//end
}
	if(rs != null) rs.close();
	if(stmt != null)stmt.close();	
}
catch(Exception e)
{
	out.print(e);
}
sql.setLength(0) ;
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</form>
</body>
</html>

