<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");

String accession_num 	=	"";
String note_type		=	"";
String added_date		=	"";
String modified_date	=	"";
String note_modified_yn =	"N";
Connection con=null;
PreparedStatement pst = null;
ResultSet rs = null;
String sql ="";
String result ="";
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
try{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		accession_num	= (String)hash.get("accession_num");
		note_type		= (String)hash.get("note_type");
		con	= ConnectionManager.getConnection(request);		
		sql = "select b.note_modified_yn,to_char(a.added_date,'DD/MM/YYYY HH24:MI') note_added_dt,to_char(b.note_modified_date,'DD/MM/YYYY HH24:MI') note_modified_date from ca_encntr_note a, CA_NOTE_TYPE b where a.note_type=b.note_type and a.accession_num = ?";
		pst = con.prepareStatement(sql);		
		pst.setString(1,accession_num);
		rs = pst.executeQuery();			
		
		if(rs.next()){				
			note_modified_yn = rs.getString("note_modified_yn")==null ? "" :(String)rs.getString("note_modified_yn");
			added_date = rs.getString("note_added_dt")==null ? "" :(String)rs.getString("note_added_dt");
			modified_date = rs.getString("note_modified_date")==null ? "" :(String)rs.getString("note_modified_date");
		}	
		
		if("Y".equals(note_modified_yn) && !"".equals(modified_date)){
			java.util.Date note_add_date = formatter.parse(added_date);
			java.util.Date note_modified_date = formatter.parse(modified_date);
			if(note_add_date.before(note_modified_date)){
				result = "NOTE_FORMAT_CHANGED";
			}
		}
		out.print(result);		
	}catch(Exception e){		
		e.printStackTrace();
		System.out.print("53. RecPreviousNotesIntermediate.jsp, Exception@ ===>" + e);
	}finally{
		if(pst!=null) pst.close();
		if(rs!=null) rs.close();
		if(con!=null) con.close();
	}
%>
