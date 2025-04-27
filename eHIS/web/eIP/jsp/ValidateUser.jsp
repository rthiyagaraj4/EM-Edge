<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String user_name		= request.getParameter("user_name");
	Connection con 		= null;
	Statement stmt=null;
	ResultSet rs	= null;
	String sql		= "";
	String appl_userid="";
	out.println("<html><HEAD><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='testform' id='testform'>");

	try{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			sql =" SELECT Appl_user_id, Appl_user_name FROM SM_APPL_USER WHERE eff_status = 'E' and Appl_user_name='"+user_name+"' ";                                
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				appl_userid = rs.getString("Appl_user_id");
			}
								
			
			if(appl_userid==null || (appl_userid.equals("")) || (appl_userid.equals("null")) ){
			%>
				<script>
				alert(getMessage("INVALID_USER_ID",'common'));
				parent.frames[1].document.Criteria_Form.user_name.value='';
				parent.frames[1].document.Criteria_Form.user.value='';

				parent.frames[1].document.Criteria_Form.user_name.focus();
				</script>
			<%
					}else{
							
					%>
					<script>
					parent.frames[1].document.Criteria_Form.user.value="<%=appl_userid%>";				

							</script>
			<%		
							}

		if(stmt != null)	stmt.close();
		if(rs != null)			rs.close();
	}catch(Exception e){
		out.print(e);
	}
	finally{
		 ConnectionManager.returnConnection(con,request);

	}

%>
</form>
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

