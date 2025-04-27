<%
/*  
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<%
Connection con=null;
con=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
		String discrid = (String) hashObj.get("discrid") == null ? "": (String) hashObj.get("discrid");
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		 if("NOTE_TEMP_CHAR_ALLOWED".equals(action)){
			 int note_templ_char_allowed=0;
			 pstmt = con.prepareStatement( "SELECT note_templ_char_allowed FROM AM_DISCR_MSR WHERE DISCR_MSR_ID=?" ) ;
				pstmt.setString(1,discrid);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					note_templ_char_allowed =  rs.getInt("note_templ_char_allowed");
				    out.print(note_templ_char_allowed);
				}
    		} 
		 else if("CHK_RESULT_LINK_HTML_YN".equals(action)){
			 String display_res_link_html_yn="N";
			 pstmt = con.prepareStatement( "select DISP_RES_LINK_HTML_YN from ca_note_param" ) ;
				rs = pstmt.executeQuery() ;
				while (rs != null && rs.next()){
					display_res_link_html_yn =  rs.getString("DISP_RES_LINK_HTML_YN");
				    out.print(display_res_link_html_yn);
				}
    		} 
		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
finally
{
    if(rs != null)
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(pstmt != null)
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(con != null) 
		try {
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
}
%>