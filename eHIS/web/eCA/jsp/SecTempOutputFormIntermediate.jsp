<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eOR.Common.*, eOR.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String sql="";

try
{
String section="";
String contentType="";

con =	ConnectionManager.getConnection(request);
Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;
eCA.SecTempOutputFormBean CA_SecTempOutputFormBean = (eCA.SecTempOutputFormBean)getObjectFromBean("CA_SecTempOutputFormBean","eCA.SecTempOutputFormBean",session);

if(hash.containsKey("section")){
	section = (String)hash.get("section");
	sql="select content_type from ca_section_hdg where sec_hdg_code =?";

	pstmt= con.prepareStatement(sql);
	pstmt.setString(1,section);
	rs = pstmt.executeQuery(); 
		if(rs.next())
		{
			contentType =rs.getString(1);
		}
		if (rs!= null) rs.close();
		if (pstmt!= null) pstmt.close();
		if(contentType == null) contentType="";
		out.println("document.forms[0].contentType.value='"+contentType+"'");
		
	if(contentType.equals("T")){	
		//out.println("parent.listFrameset.cols='60%,*' ");
		out.println("parent.document.getElementById('SecTempOutputFormPrevEdtrFrame').style.width = '60vw';");
		out.println("parent.document.getElementById('SecTempOutputFormListFrame').style.width = '40vw';");
		
		
	}else{
		 // out.println("parent.listFrameset.cols='100%,0%' ");	
		out.println("parent.document.getElementById('SecTempOutputFormPrevEdtrFrame').style.width = '100vw';");
		out.println("parent.document.getElementById('SecTempOutputFormListFrame').style.width = '0vw';");

	}
}else if(hash.containsKey("html_format")){
	
	String html_format 	= (String)hash.get("html_format") ;
	if(html_format == null) html_format="";

	CA_SecTempOutputFormBean.setEditorContent(html_format);
	
}
putObjectInBean("CA_SecTempOutputFormBean",CA_SecTempOutputFormBean,session);	
}
catch(Exception e)
{
	e.printStackTrace() ;
}
finally
	{
		if (con!= null)
		ConnectionManager.returnConnection(con,request);
	} 

%>

