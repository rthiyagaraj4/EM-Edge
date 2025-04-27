<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<html>
<head>
	<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String maintain_doc_or_file = "";
	String create_file_yn		= "";
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		rs      = stmt.executeQuery("select CREATE_FILE_YN from mp_param");

		if(rs !=null && rs.next())
		{
			create_file_yn = rs.getString("CREATE_FILE_YN");
			if(create_file_yn ==null) create_file_yn="N";
		}

		if(rs != null) rs.close();

		if(create_file_yn.equals("N"))
		{
		%>
				<script>
					alert(getMessage('PATIENT_FILE_NOT_APPL','MR'));
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
		<%
		}
		else
		{
			rs		= stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param");
			if(rs != null && rs.next())
			{
				maintain_doc_or_file = checkForNull(rs.getString("maintain_doc_or_file"));
			}

			if(maintain_doc_or_file.equals("F"))
			{
				String url ="../../eCommon/jsp/commonToolbar.jsp?" ;
				String params = request.getQueryString() ;
				String source = url + params ;

			
	
			%>
			
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/mrblank.jsp?step_1=7' frameborder=0  scrolling='auto' style='height:80vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
			<%
			}
			else
			{ 
			%>
			<script>
				alert(getMessage("FILE_NOT_APPL",'MP'));
//				history.go(-1);
				document.location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
			}
		}
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
	}	
	catch(Exception e)
	{
		//out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
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

