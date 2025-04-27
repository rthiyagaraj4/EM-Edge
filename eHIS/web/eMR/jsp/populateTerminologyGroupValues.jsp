<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='Javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body CLASS="MESSAGE" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%

	StringBuffer selectsql	= new StringBuffer();
	Connection con	= null;
	PreparedStatement pstmt =null;
	ResultSet rs	= null;
	RecordSet PractitionerSpeciality = null;//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
	try
	{	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);	

		String term_grp_id		= checkForNull(request.getParameter("term_grp_id"));
		String function_type	= checkForNull(request.getParameter("clearAll"));
		String index_type	= checkForNull(request.getParameter("index_type"));
		//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
		String searchval	= checkForNull(request.getParameter("searchval"));
		String indexdesc	= checkForNull(request.getParameter("indexdesc"));
		
		
		if(function_type!=null && function_type.equals("clearAll"))
		{
			 PractitionerSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractitionerSpeciality");
			PractitionerSpeciality.clearAll();
		}
		else if(function_type!=null && function_type.equals("notCleared"))
		{
			 PractitionerSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractitionerSpeciality");
			PractitionerSpeciality.clearAll();
			if(index_type!=null && index_type.equals("P"))
			{
				selectsql.append("select PRACTITIONER_ID,PRACTITIONER_NAME from AM_PRACTITIONER ");
				if(searchval!=null && searchval.equals("S"))
					selectsql.append(" where Upper(PRACTITIONER_NAME) like Upper('"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("C"))
					selectsql.append("where Upper(PRACTITIONER_NAME) like Upper('%"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("E"))
					selectsql.append("where Upper(PRACTITIONER_NAME) like Upper('%"+indexdesc+"')");
				selectsql.append(" order by PRACTITIONER_NAME ");
			}	
			else if(index_type!=null && index_type.equals("S"))
			{
				selectsql.append("select SPECIALITY_CODE,SHORT_DESC from AM_SPECIALITY");
				if(searchval!=null && searchval.equals("S"))
					selectsql.append(" where Upper(SHORT_DESC) like Upper('"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("C"))
					selectsql.append(" where Upper(SHORT_DESC) like Upper('%"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("E"))
					selectsql.append(" where Upper(SHORT_DESC) like Upper('%"+indexdesc+"')");
				selectsql.append(" order by SHORT_DESC ");
			}
			
			pstmt = con.prepareStatement(selectsql.toString());
			rs = pstmt.executeQuery();

			while(rs!=null && rs.next())
			{
				PractitionerSpeciality.putObject(rs.getString(1));
			}

			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();

		}
		else
		{	
			selectsql.append("  select term_set_id from mr_term_group_hdr  WHERE   eff_status='E'  AND   term_group_id=?");
			pstmt = con.prepareStatement(selectsql.toString());
			pstmt.setString(1,term_grp_id);
			rs = pstmt.executeQuery();
			%>
				<script>
						var obj = parent.f_query_add_mod.document.addModifyCustomListTerminologyGroupAddModify.term_set;
						var length  = obj.length;
						for(i=0;i<length;i++)
							obj.remove(0); 
						var term_set_opt = parent.f_query_add_mod.document.createElement('OPTION');
							term_set_opt.text = '--- '+getLabel('Common.defaultSelect.label','Common')+' ---';
							term_set_opt.value = "";
							parent.f_query_add_mod.document.addModifyCustomListTerminologyGroupAddModify.term_set.add(term_set_opt);
				</script>
			<%
					String innertext ="";
					while( rs!=null && rs.next() ) 
					{
						innertext = rs.getString( "term_set_id" ) ;
						out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+
						"element.text = \""+innertext+"\";"+ 
						"element.value= \""+innertext+"\";"+
						"element.selected=true;"+
						"parent.f_query_add_mod.document.addModifyCustomListTerminologyGroupAddModify.term_set.add(element);</script>");
					}
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
		}

		%>
		<form name=Dynamic_form>
			<input type='hidden' name='isSelect' id='isSelect' value='<%=function_type%>'>
		</form>
</body>
		<%
	}
	catch(Exception e)
	{
		/* out.println("<script>alert('exception is coming here');</script>");
		out.println("Exception in populateTerminologyGroupValues jsp page : "+ e.toString()); */
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
		//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
		session.setAttribute("PractitionerSpeciality", PractitionerSpeciality);
	}
	%>	
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>
	

