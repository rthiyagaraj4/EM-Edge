 <%@page import="java.sql.*,webbeans.eCommon.*,java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;	
	String validate = "N";
	try
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String facilityId = (String)hash.get("facilityId");		
		String practitionerId = (String)hash.get("practitionerId");
		String validateQuery="select 'Y' ACCESS_RIGHTS from CA_RES_STUDY_ALLOWED where FACILITY_ID=?  AND PRACTITIONER_ID=? AND TO_DATE (NVL(RES_FROM_DATE,SYSDATE), 'dd/mm/yyyy') <= TO_DATE (SYSDATE, 'dd/mm/yyyy') AND TO_DATE (NVL(RES_TO_DATE,SYSDATE), 'dd/mm/yyyy') >= TO_DATE (SYSDATE, 'dd/mm/yyyy')";
		con =  ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(validateQuery);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,practitionerId);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
		  validate = rs.getString("ACCESS_RIGHTS");
		}
		
		out.print("accessValid='"+validate+"'");
				
	}catch(Exception ex){
		ex.printStackTrace();
		out.println("accessValid='"+validate+"'");
	}finally{
		try{
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			if(con!=null)con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
%>
