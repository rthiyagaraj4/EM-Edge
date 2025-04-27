<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	
	String wrkplace_code		= request.getParameter( "work_code" ) ;
	String facility_id		=  request.getParameter( "facility_id" );
	String frm_dt		=request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt		=request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	int count=0;
	String countSql				="";
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	try{
		Con=ConnectionManager.getConnection(request);
			
		if(frm_dt.equals("") || to_dt.equals("")){

			countSql="select count(*) count  from rs_workplace_requirement  where facility_id=? and workplace_code = ? and requirement_date_fm is null and requirement_date_to is null";
			pstmt=Con.prepareStatement(countSql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,wrkplace_code);

		}
		else{

			countSql="select count(*) count from rs_workplace_requirement where facility_id=? and workplace_code = ? and requirement_date_fm is not null  and requirement_date_to is not null and (to_date(?,'dd/mm/yyyy')  between requirement_date_fm and requirement_date_to or to_date(?,'dd/mm/yyyy')  between requirement_date_fm and requirement_date_to or requirement_date_fm between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') or requirement_date_to between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy'))";
			pstmt=Con.prepareStatement(countSql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,wrkplace_code);
			pstmt.setString(3,frm_dt);
			pstmt.setString(4,frm_dt);
			pstmt.setString(5,frm_dt);
			pstmt.setString(6,frm_dt);
			pstmt.setString(7,frm_dt);
			pstmt.setString(8,frm_dt);
		}

		rslRst = pstmt.executeQuery();
		while(rslRst.next()){
			count=rslRst.getInt("count");
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst !=null)
			rslRst.close();
		out.println("addConstCount('" +count+ "') ; " ) ;
		
	}catch(Exception e){
		out.println("Exception in try of WrkPlaceReqdSrch.jsp : "+e);
	}finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}
%>
