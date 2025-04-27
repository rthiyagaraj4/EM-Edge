<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
06/12/2012   	IN030466     Karthi L		CRF-025 Based on the access rights, practitioner can Record and update the Clinical Studies content in CA Patient Chart Menu	
---------------------------------------------------------------------------------------------------------------
*/ %>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;	
	try
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String p_research_category 		= (String)hash.get("p_research_category");	
		String p_research_categ_factor	= (String)hash.get("p_research_categ_factor");	
		String p_practitioner			= (String)hash.get("p_practitioner");	
		String sql ="SELECT RES_RECORD, RES_UPDATE from CA_RES_STUDY_RIGHTS where RESEARCH_CATEG_ID = ? and RESEARCH_CATEG_FACT_ID = ? and PRACTITIONER_ID = ?";

		con		=	ConnectionManager.getConnection(request);
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1,p_research_category);
		pstmt.setString(2,p_research_categ_factor);
		pstmt.setString(3,p_practitioner);
		
		System.out.println( " 24. SQL " + p_research_category + "    " + p_research_categ_factor + "   " +  p_practitioner);
		//out.println( "clearResearchFactorsList();");
		rs=pstmt.executeQuery();
		
		if(rs!=null){
			while(rs.next()){				
				String r_record = rs.getString("res_record");
				String r_update = rs.getString("res_update");				
				out.println( "addAccessRights(\"" + r_record + "\",\"" + r_update +"\" ) ; " ) ;			
				
			}
		}else{
			out.println("");
		}
	}catch(Exception ex){
		ex.printStackTrace();
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
