<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
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
		String pract_Code = (String) hashObj.get("pract_Code") == null ? "": (String) hashObj.get("pract_Code");
		String locale = (String) hashObj.get("locale") == null ? "": (String) hashObj.get("locale");
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		String facility_id			=(String)session.getAttribute("facility_id");

		 if("POPUP_POSITION".equals(action)){
			 int pat_count=0;
			 String code="";
			 String description="";
			 pstmt = con.prepareStatement("SELECT DISTINCT A.POSITION_CODE CODE, A.POSITION_DESC DESCRIPTION FROM AM_POSITION_LANG_VW A,CA_ALLOW_POSI_CONSULT_TAG B,CA_PRACT_CONSULTA_TAG D,AM_PRACTITIONER AB WHERE B.PRACT_TYPE = ? AND LANGUAGE_ID = ? AND A.EFF_STATUS = 'E' AND A.POSITION_CODE = B.POSITION_CODE AND B.PRACT_TYPE = D.PRACT_TYPE AND A.POSITION_CODE = AB.POSITION_CODE AND (? IN ( SELECT SFFU.FACILITY_ID FROM SM_FACILITY_FOR_USER_VW SFFU, SM_APPL_USER SAU WHERE SFFU.APPL_USER_ID = SAU.APPL_USER_ID AND SAU.FUNC_ROLE_ID = AB.PRACTITIONER_ID) OR ALL_FACILITIES_YN = 'Y') AND ab.pract_type = ? ORDER BY 2");
				pstmt.setString(1,pract_Code);
				pstmt.setString(2,locale);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,pract_Code);
				out.println( "clearPositionList();");
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					code =  rs.getString("CODE");
					description =  rs.getString("DESCRIPTION");
					String selected = "false";							
					out.println( "addPositionList(\"" + code + "\",\"" + description + "\") ; " ) ;			
}
		 }
		 if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
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