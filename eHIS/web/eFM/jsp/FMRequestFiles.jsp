<!DOCTYPE html>
<!--
	Created On	: 6/11/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: FM Request for Files
-->
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eFM/js/FMParam.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection con = null;
	Properties p	= (Properties) session.getValue("jdbc" ) ;
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid 	= (String) session.getValue("facility_id");

	java.sql.Statement stmt		= null;
	PreparedStatement pstmt = null;
	ResultSet rs		= null;

try
{
	String doc_or_file = "";
	con = ConnectionManager.getConnection(request);	
	
	stmt = con.createStatement();
	if(rs!=null)rs.close();
	rs = stmt.executeQuery("Select MAINTAIN_DOC_OR_FILE from MP_PARAM where module_id='MP' ");
	if(rs.next()) {
		doc_or_file = rs.getString("MAINTAIN_DOC_OR_FILE");			
	}
	if(rs!=null)rs.close();			
	if(stmt!=null)stmt.close();
	
	stmt = con.createStatement();
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String sql 		= "";
	String sql1 		= "";
	String p_user_security_yn	= "";
	String p_access_all = "";
    String auto_check_patient_file_request="";
	/*Below Query Modified for this CRF[SKR-CRF-0012]*/
	sql = "select user_security_yn,auto_check_pat_file_request from fm_parameter where facility_id='"+facilityid+"' ";
	rs  = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_user_security_yn	= rs.getString("user_security_yn");
		auto_check_patient_file_request=rs.getString("auto_check_pat_file_request");
	}
	if(rs!=null)	rs.close();

	if (p_user_security_yn.equals("Y"))
	{
	sql1 = "select 1 rec_cnt , fs_locn_code from fm_user_access_rights where facility_id= ? and  appl_user_id= ?  and (req_yn='Y' or req_across_facilities_yn='Y') ";

		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,addedById);		
		rs   = pstmt.executeQuery();

	if (!rs.next())
	{
%>
	<script>
		var errortext = getMessage('FM_NO_USER_RIGHTS','FM');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>

<%	}else
	{
		p_access_all = rs.getString("fs_locn_code");
	}
if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}else{
	p_access_all ="*ALL" ;
}
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='requester_details' id='requester_details' src='../../eFM/jsp/FMRequestFileDetails.jsp?doc_or_file=<%=doc_or_file%>&p_user_security_yn=<%=p_user_security_yn%>&p_access_all=<%=p_access_all%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
		<iframe name='requestee_details' id='requestee_details' src='../../eFM/jsp/FMRequesteeFileDetails.jsp?doc_or_file=<%=doc_or_file%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='search_criteria' id='search_criteria' src='../../eFM/jsp/FMRequestFileSearch.jsp?doc_or_file=<%=doc_or_file%>&auto_check_patient_file_request=<%=auto_check_patient_file_request%>' frameborder=0 scrolling='auto' noresize style='height:25vh;width:100vw'></iframe>
		<iframe name='select_files' id='select_files' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:28vh;width:100vw'></iframe>
		<iframe name='color_frame' id='color_frame' src='../../eFM/jsp/FMColorFile.jsp?p_param=REQ&doc_or_file=<%=doc_or_file%>' frameborder=0 scrolling='no' noresize style='height:3vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>
		
<%
if(stmt!=null) stmt.close();				
}
catch(Exception e)
{
	out.println(e);
}
finally
{		
	ConnectionManager.returnConnection(con,request);
}
if(session.getAttribute("p_appl_user_name")!=null)
session.removeAttribute("p_appl_user_name");

%>
<form name=LoadReqFiles> </form>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


