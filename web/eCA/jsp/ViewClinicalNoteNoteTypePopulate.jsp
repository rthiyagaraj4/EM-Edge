<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html><head>
 <%
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script Language="JavaScript" src='../../eCA/js/ViewClinicalNote.js'></script>
 



<%
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String	note_group	="";
	String	note_type	="";
	String	note_type_desc	="";



	//out.println("<script>alert('in jsp');</script>");

	note_group=(request.getParameter("note_group")==null)?"": request.getParameter("note_group");
	//out.println("<script>alert('note_group"+note_group+"');</script>");
	

	try	{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);
		
		
	
		
				String sblQry = "SELECT NOTE_TYPE,CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,'1') NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE  EFF_STATUS='E' AND NOTE_GROUP_ID=? ORDER BY  NOTE_TYPE_DESC ";
				pstmt = conlCon.prepareStatement( sblQry);
				pstmt.setString(1,locale); 
				pstmt.setString(2,note_group);
				rslRst = pstmt.executeQuery();

				while(rslRst.next()) {
					note_type	=	rslRst.getString("NOTE_TYPE");
					note_type_desc	=	rslRst.getString("NOTE_TYPE_DESC");

                 
			%>
<script Language="JavaScript">
				
   				var opt		=	document.createElement('OPTION'); 
 				opt.text	=	"<%=note_type_desc%>";
				opt.value	=	"<%=note_type%>";
				top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.note_type.add(opt); 
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



 		 	<%
			} // end of while

				
		if(rslRst!=null) rslRst.close();
		if(pstmt!=null) pstmt.close();
		 // end of if(pop_mode.equals("section"))
		
	}catch(Exception e){
	//	out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181

	}finally{
%>
		</head><body class='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'></body></html>
<%		
		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	}

%>
</head>
</html>

