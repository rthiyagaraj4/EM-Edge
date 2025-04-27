<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html><head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script language=javascript src='../../eCA/js/RecClinicalNotesLinkHist.js'></script>
<script language='javascript'>



<%
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;

	String	note_group	="";
	String	note_type	="";
	String	note_type_desc	="";
	

	try	{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);
		note_group		=	(request.getParameter("note_group")==null)	? "" : request.getParameter("note_group");
	
		
				//String sblQry = "SELECT NOTE_TYPE,NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE  EFF_STATUS='E' AND NOTE_GROUP_ID=? ORDER BY  NOTE_TYPE_DESC ";
				String sblQry = "SELECT	NOTE_TYPE,NOTE_TYPE_DESC FROM CA_NOTE_TYPE_lang_Vw WHERE EFF_STATUS='E' AND NOTE_GROUP_ID=? and language_id = ?	ORDER BY NOTE_TYPE_DESC";
				pstmt = conlCon.prepareStatement( sblQry);
				pstmt.setString(1,note_group);
				pstmt.setString(2,locale);
				rslRst = pstmt.executeQuery();

				while(rslRst.next()) {
					note_type	=	rslRst.getString("NOTE_TYPE");
					note_type_desc	=	rslRst.getString("NOTE_TYPE_DESC");
 
			%>
   				var opt		=	parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.createElement('OPTION'); 
 				opt.text	=	"<%=note_type_desc%>";
				opt.value	=	"<%=note_type%>";
				parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.forms[0].note_type.add(opt); 
 		 	<%
			} // end of while

				
		if(rslRst!=null) rslRst.close();
		if(pstmt!=null) pstmt.close();
		 // end of if(pop_mode.equals("section"))
		
	}catch(Exception e){
		//out.println("Exception@1: "+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{
%>
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</head><body class='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'></body></html>
<%		
		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	}

%>
</head>
</html>

