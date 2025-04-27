
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html><head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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

	
	String	note_type	="";
	String	sec_hdg_code	="";
	String	sec_hdg_desc	="";
	//String	child_sec_hdg_code	="";
	//String	child_sec_hdg_desc	="";
	

	try	{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);
		note_type		=	(request.getParameter("note_type")==null)	? "" : request.getParameter("note_type");
	
		
				String sblQry = "select SEC_HDG_CODE,SEC_HDG_DESC,CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from ca_note_section_view where NOTE_TYPE=? order by NOTE_SEC_SEQ_NUM,CHILD_SEQ_NUM";
				//String sblQry = "SELECT A.NOTE_TYPE ,A.SEC_HDG_CODE ,C.SEC_HDG_DESC ,A.NOTE_SEC_SEQ_NUM ,D.CHILD_SEC_HDG_CODE ,D.CHILD_SEQ_NUM ,E.SEC_HDG_DESC CHILD_SEC_HDG_DESC ,E.CONTENT_TYPE CHILD_SEC_CONTENT_TYPE FROM CA_NOTE_SECTION A,CA_NOTE_TYPE B,CA_SECTION_HDG_LANG_VW C,CA_SUBSECTION_LINK D ,CA_SECTION_HDG_LANG_vW E WHERE B.NOTE_TYPE=A.NOTE_TYPE AND C.SEC_HDG_CODE=A.SEC_HDG_CODE AND D.HEADER_SEC_HDG_CODE(+)=C.SEC_HDG_CODE  AND E.SEC_HDG_CODE(+)=D.CHILD_SEC_HDG_CODE  and C.LANGUAGE_ID = ? AND E.LANGUAGE_ID = ?";
				pstmt = conlCon.prepareStatement( sblQry);
				
				pstmt.setString(1,note_type);
				rslRst = pstmt.executeQuery();

				while(rslRst.next()) {
					
				sec_hdg_code		=	rslRst.getString("SEC_HDG_CODE");
				sec_hdg_desc		=	rslRst.getString("SEC_HDG_DESC");
				//child_sec_hdg_code	=	rslRst.getString("CHILD_SEC_HDG_CODE");
				//child_sec_hdg_desc	=	rslRst.getString("CHILD_SEC_HDG_DESC");
					
 
			%>
   				
			var opt		=	parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.createElement('OPTION'); 
 				opt.text	=	"<%=sec_hdg_desc%>";
				opt.value	=	"<%=sec_hdg_code%>";
				parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.forms[0].section.add(opt); 
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
	//out.println("<script>alert('note_type"+note_type+"')</script>");
	//out.println("<script>alert('sec_hdg_desc"+sec_hdg_desc+"')</script>");
	}

%>
</head>
</html>

