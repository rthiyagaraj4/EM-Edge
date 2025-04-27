<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	
/// Added by SRIDHAR R on 16 OCT 2004
/// To fetch Tabulation List No for the Tabulation List Type selected ...
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	ResultSet rs			= null;
	PreparedStatement stmt			= null;
String age_spec="";
try
{
	con = ConnectionManager.getConnection(request);

	String TabListNo	= request.getParameter("TabListNo");
	if(TabListNo == null) TabListNo = "";

	String criteria	=	request.getParameter("criteria");
	if(criteria == null) criteria = "";

	//String tab_list_type		= "";
	//String tab_list_type_desc	= "";
	String dia_code_schme		= "";
	String dia_code_schme_desc	= "";

	age_spec=request.getParameter("age_spec");
    if(age_spec == null) age_spec = "";
	
	if(age_spec.equals("D"))
    {
		String term_id="";
		String term_set_desc="";

		try{

		//String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE DIAG_SPEC_YN = 'Y' ";
		String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE EFF_STATUS = 'E' AND DIAG_SPEC_YN = 'Y' ORDER BY TERM_SET_DESC";
        stmt= con.prepareStatement(sql);
        rs	= stmt.executeQuery();
		if(rs!=null){
			 while(rs.next()){
				 term_id=rs.getString("TERM_SET_ID");
				 term_set_desc=rs.getString("TERM_SET_DESC");
				 %>
				 <script>
						 temp = "<%=term_id%>";
						 temp1="<%=term_set_desc%>";
						
						var opt= parent.frames[1].frames[0].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[1].frames[0].document.forms[0].term_set_id.add(opt);
									 	
				 </script>
              <%
			 }
		    }
				 if(rs!=null)	rs.close();
	             if(stmt!=null)	stmt.close();
             out.println("<script>parent.frames[1].frames[0].document.forms[0].call_result.value='1';</script>");
             out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
		}catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
		finally
	   {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	   }
		
	}

	if(age_spec.equals("P"))
    {
		String term_id="";
		String term_set_desc="";

		try{

		//String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN = 'Y' ";
         String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE EFF_STATUS = 'E' AND PROC_SPEC_YN = 'Y' ORDER BY TERM_SET_DESC";
        stmt= con.prepareStatement(sql);
        rs	= stmt.executeQuery();
		if(rs!=null){
			 while(rs.next()){
				 term_id=rs.getString("TERM_SET_ID");
				 term_set_desc=rs.getString("TERM_SET_DESC");
				 %>
				 <script>
						 temp = "<%=term_id%>";
						 temp1="<%=term_set_desc%>";
						var opt= parent.frames[1].frames[0].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[1].frames[0].document.forms[0].term_set_id.add(opt);

			 	
				 </script>
              <%
			 }
		    }
				 if(rs!=null)	rs.close();
	             if(stmt!=null)	stmt.close();
				
	         out.println("<script>parent.frames[1].frames[0].document.forms[0].call_result.value='1';</script>");
             out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
		}catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
		finally
	   {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	   }
		
	}

	if(criteria.equals("populateTabType"))
	{
		String Sql = " select DIAG_CODE_SCHEME from MR_TAB_LIST where eff_status='E' and TAB_LIST_NO = ?"; 

		stmt= con.prepareStatement(Sql);
		stmt.setString(1,TabListNo);
		rs	= stmt.executeQuery();
		if(rs != null && rs.next())
		{
			dia_code_schme	= rs.getString("DIAG_CODE_SCHEME");
			if(dia_code_schme == null) dia_code_schme = "";
			if(dia_code_schme.equals("1")) dia_code_schme_desc="ICD10";
			else dia_code_schme_desc="ICD9-CM";
		}

		out.println("<script>parent.frames[0].document.forms[0].all.diag_code_disp.innerText='"+dia_code_schme_desc+"';parent.frames[0].document.forms[0].diag_code_scheme.value='"+dia_code_schme+"';parent.frames[0].document.forms[0].all.call_result.value='1';</script>");
	}

	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
	//out.println("Exception @ try "+e.toString());
	e.printStackTrace();
}
finally 
{ 
	ConnectionManager.returnConnection(con,request);		
}
/// End of addition...by Sridhar R
%>

<head>

<title>

	<fmt:message key="Common.details.label" bundle="${common_labels}"/>
</title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<script>
	function closeWindow()
	{
		//parent.window.returnValue=document.getElementById("remarks").value;
		//parent.window.close();
		let dialogBody = parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = document.getElementById("remarks").value;
	    
	    const dialogTag = parent.document.getElementById('dialog_tag');    
	    dialogTag.close(); 
	}
	function populateRemarks()
	{
		var text=window.dialogArguments;
		if(text == null || text =='null') text='';
		document.getElementById("remarks").value=unescape(text);
	}
	function chkMaxLength(Obj)
	{
		if(Obj.value.length >200)
			{
			alert(getMessage('REMARKS_NOT_EXCEED_200_CH','SM'));
			Obj.focus();
			}
	}
</script>
<%if(age_spec.equals("")){%>
<body onLoad='populateRemarks()' onUnload='closeWindow()' onKeyDown = 'lockKey()';>
	<form>
	<table border='0' cellpadding='0' cellspacing='0' align='center'  width='90%'
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<textarea  name='remarks' id='remarks' cols='50'  readOnly  rows='4'></textarea>
		</td>
	</tr>
	<tr>
		<td align='right' class='button'>
			<input type='button' class='button' value='  <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>  ' onClick='closeWindow()' >
		</td>
	</tr>
	</table>
	</form>
</body>
<%}%>
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

