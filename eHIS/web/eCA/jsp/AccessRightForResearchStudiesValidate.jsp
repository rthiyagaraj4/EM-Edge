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
		String p_research_category = (String)hash.get("p_research_category");		
		String sql ="select crcf.research_categ_fact_id,crcf.research_categ_fact_desc from ca_research_category_fact crcf,ca_research_category_fact_dtl crcft where crcf.research_categ_fact_id=crcft.research_categ_fact_id and crcft.research_categ_id=?";
		con		=	ConnectionManager.getConnection(request);
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1,p_research_category);
		out.println( "clearResearchFactorsList();");
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				String code_=rs.getString("research_categ_fact_id");
				String desc_=rs.getString("research_categ_fact_desc");
				out.println( "addResearchFactorsList(\"" + code_ + "\",\"" + desc_ + "\" ) ; " ) ;				
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
