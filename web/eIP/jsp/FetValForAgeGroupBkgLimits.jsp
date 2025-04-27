<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<%
			request.setCharacterEncoding("UTF-8"); 
			Connection con = null;
			Statement stmt = null;
			ResultSet rs =null;
			String gend="";
			String age_group = request.getParameter("age_grp_code");
		%>
	</head>

	<body class='message' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<%
		try{
			con = ConnectionManager.getConnection(request);;
			String sql = "select gender from am_age_group where age_group_code='"+age_group+"'";
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null)
			{
				if(rs.next())
				{
					 gend=rs.getString(1);
					%>
						<script>
							var obj= parent.frames[1].document.forms[0]
							if('<%=gend%>' == "M")
							{
								if(obj.function_name.value!="modify")
								{
									obj.max_male.value="";
									obj.max_female.value="";
									obj.max_total.value="";
									obj.max_unknown.value="";
								}

								obj.max_male.readOnly=false;
								obj.max_female.readOnly=true;
								obj.max_total.readOnly = true;
								obj.max_unknown.readOnly=true;
							}
							else if('<%=gend%>' =="F")
								{
									if(obj.function_name.value!="modify")
									{
										obj.max_male.value="";
										obj.max_female.value="";
										obj.max_total.value="";
										obj.max_unknown.value="";
									}
									
									obj.max_female.readOnly=false;
									obj.max_male.readOnly=true;
									obj.max_total.readOnly = true;	
									obj.max_unknown.readOnly=true;
								}
							else if('<%=gend%>' =="U")
								{
									if(obj.function_name.value!="modify")
									{
										obj.max_male.value="";
										obj.max_female.value="";
										obj.max_total.value="";
										obj.max_unknown.value="";
									}
									
									obj.max_female.readOnly=true;
									obj.max_male.readOnly=true;
									obj.max_total.readOnly = true;	
									obj.max_unknown.readOnly=false;
								}
								else 
								{
									if(obj.function_name.value!="modify")
									{
										obj.max_male.value="";
										obj.max_female.value="";
										obj.max_total.value="";
										obj.max_unknown.value="";
									}

									obj.max_female.readOnly=false;
									obj.max_male.readOnly=false;
									obj.max_total.readOnly = true;	
									obj.max_unknown.readOnly=false;
								}
						</script>
					<%
				}
				else
				{
					%>
					<script>
						var obj= parent.frames[1].document.forms[0]
						if(obj.function_name.value!="modify")
						{
							obj.max_male.value="";
							obj.max_female.value="";
							obj.max_total.value="";
							obj.max_unknown="";
						}

						obj.max_male.readOnly=true;
						obj.max_female.readOnly=true;
						obj.max_unknown.readOnly=true;
						obj.max_total.readOnly = false;
					</script>
					<%
				}
			}

			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();				

		}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}				
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}	
		%>
	</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

