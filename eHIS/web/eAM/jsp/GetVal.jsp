<!DOCTYPE html>
<%--
	FileName	: GetVal.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%			
			Connection con = null;
			ResultSet rset=null;
			Statement stmt=null;
			PreparedStatement pstmt = null;
try
{	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	//stmt = con.createStatement();

	String deptcode="";
	String deptdesc="";
	String sectioncode="";
	String sectiondesc="";
	String common=request.getParameter("Common_Text");
	String common1=request.getParameter("Common_Text1");			
	String chksrc=request.getParameter("Chksrc");
	
if(chksrc.trim().equals("facility")) 
{
	String sql = "select dept_code,dept_short_desc from am_facility_dept_vw where eff_status = 'E' and operating_facility_id =? order by dept_short_desc";

	//rset = stmt.executeQuery(sql);
	
	pstmt   = con.prepareStatement(sql);
	pstmt.setString	(	1,	common.trim()		);
	rset		 = pstmt.executeQuery();
	
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
			if(rset != null) 
			{
				%>							        
			<script>
				var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.f_query_add_mod.document.forms[0].department.add(opt);					
			</script>	        
											
			<%		
				
			while( rset.next() ) 
			{
				deptcode=rset.getString("dept_code");
				deptdesc=rset.getString("dept_short_desc");
						
			%>
			<script>
				var temp = "<%=deptcode%>";
				var temp1="<%=deptdesc%>";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.f_query_add_mod.document.forms[0].department.add(opt);
			</script>
		<%			   	  
				}
			}
	if(rset!=null) 	rset.close();
	if(stmt!=null) 	stmt.close();
	if(pstmt!=null) 	pstmt.close();
	out.println("</form></body></html>");	
}	
else if(chksrc.trim().equals("department")) 
{
	String sql = "select section_code,section_short_desc from am_dept_section_vw where eff_status = 'E'  and dept_code =? order by section_short_desc";
	//stmt = con.createStatement();
	//rset = stmt.executeQuery(sql);				
	
	pstmt   = con.prepareStatement(sql);
	pstmt.setString	(	1,	common1.trim()	);
	rset		 = pstmt.executeQuery();
	
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");

	if(rset != null) 
	{
		%>							        
	<script>
		var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.f_query_add_mod.document.forms[0].section.add(opt);					
	</script>	        
										        
		<%				
		while( rset.next() ) 
		{
			sectioncode=rset.getString("section_code");
			sectiondesc=rset.getString("section_short_desc");

		%>
			
	<script>
		var temp = "<%=sectioncode%>";
		var temp1="<%=sectiondesc%>";
		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text=temp1;
		opt.value=temp;
		parent.f_query_add_mod.document.getElementById('section').add(opt);
	</script>
	<%			   	  
		}
	}
	out.println("</form></body></html>");	
	if(rset!=null) 	rset.close();
	if(stmt!=null) 	stmt.close();
	if(pstmt!=null) 	pstmt.close();
 }
}
catch(Exception e)
{}
finally
{
	try
	{
	if (rset != null)   rset.close();
	if (stmt != null)   stmt.close();
	if(pstmt!=null) 	pstmt.close();
	}
	catch(Exception e)
	{}
	ConnectionManager.returnConnection(con,request);
}
%>

