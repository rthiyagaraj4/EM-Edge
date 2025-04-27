<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Return File to MRD
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eFM/js/FMParam.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Properties p		= (Properties) session.getValue("jdbc" ) ;
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid	= (String) session.getValue("facility_id");
	
try
{
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;

	String sql 							= "";
	String sql1 						= "";
	String p_user_security_yn			= "";
	String dflt_narr_code_for_note_rtn	= "";
	String dflt_archive_fs_locn_code	= "";
	String doc_or_file					= "";
	String accessAll					= "";
	String accept_out_intransit_yn      = "";
	
	stmt = con.createStatement();
	
	rs = stmt.executeQuery("Select MAINTAIN_DOC_OR_FILE from MP_PARAM ");
	if(rs != null && rs.next()) 
	{
		 doc_or_file = rs.getString("MAINTAIN_DOC_OR_FILE");			
	}
	if(rs != null) rs.close();
	
	sql = "select user_security_yn,dflt_narr_code_for_note_rtn,dflt_archive_fs_locn_code,accept_out_intransit_yn from fm_parameter where facility_id = '"+facilityid+"' ";
	rs  = stmt.executeQuery(sql);
	while(rs != null && rs.next())
	{
		p_user_security_yn			= rs.getString("user_security_yn");
		dflt_narr_code_for_note_rtn	= rs.getString("dflt_narr_code_for_note_rtn");
		dflt_archive_fs_locn_code	= rs.getString("dflt_archive_fs_locn_code");
		accept_out_intransit_yn 	= rs.getString("accept_out_intransit_yn");
	} if(rs != null) rs.close();

	if (p_user_security_yn.equals("Y"))
	{

		sql1 = "select 1 accessAll, fs_locn_code from fm_user_access_rights where facility_id = ? and appl_user_id = ?  and receive_file_yn = 'Y' ";
		
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,addedById);
		
		rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			accessAll = rs.getString("fs_locn_code");
		}
		else
		{
			%>
			<script>
				var errortext = getMessage('FM_NO_USER_RIGHTS','FM');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
	}

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
<iframe name='default_val_frame' id='default_val_frame' src='../../eFM/jsp/FMReceiveFileMRDDefault.jsp?doc_or_file=<%=doc_or_file%>&user_security_yn=<%=p_user_security_yn%>&dflt_narr_code_for_note_rtn=<%=dflt_narr_code_for_note_rtn%>&accessAll=<%=accessAll%>&dflt_archive_fs_locn_code=<%=dflt_archive_fs_locn_code%>' frameborder="0" scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
<iframe name='search_criteria_frame' id='search_criteria_frame' src='../../eFM/jsp/FMReceiveFileMRDSearch.jsp?doc_or_file=<%=doc_or_file%>&accept_out_intransit_yn=<%=accept_out_intransit_yn%>'  frameborder=0 scrolling='no' noresize style='height:33vh;width:100vw'></iframe>
<iframe name='select_files' id='select_files' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:28vh;width:100vw'></iframe>
<iframe name='color_frame' id='color_frame' src='../../eFM/jsp/FMColorFile.jsp?&p_param=RECEIVE&doc_or_file=<%=doc_or_file%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder=0 noresize style='height:12vh;width:100vw'></iframe>
	 
	<%
if(rs!=null)	rs.close();
if(stmt!=null) stmt.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println(e);}
finally
{			
	ConnectionManager.returnConnection(con,request);	
}
%>
<form name=LoadReqFiles> </form>
</html>

