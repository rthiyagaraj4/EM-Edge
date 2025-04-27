<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html><head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script language=javascript src='../../eCA/js/RecClinicalNotesLinkAlrg.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
 <script language='javascript'>



<%
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;

	
	String	allergy_type	="";
	String	short_desc	="";
	String	allergy_type_code	="";
	
	

	try	{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);
		allergy_type		=	(request.getParameter("allergy_type")==null)	? "" : request.getParameter("allergy_type");
	
		
				//String sblQry = "SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				String sblQry = "SELECT short_desc, allergy_type_code from 	MR_ALLERGY_TYPE_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ?	order by short_desc";
				pstmt = conlCon.prepareStatement( sblQry);
				
				pstmt.setString(1,allergy_type);
				pstmt.setString(2,allergy_type);
				pstmt.setString(3,locale);
				rslRst = pstmt.executeQuery();

				while(rslRst.next()) {
					
				short_desc		=	rslRst.getString("short_desc");
				allergy_type_code	=	rslRst.getString("allergy_type_code");
				
					
 
			%>
   				
			var opt		=	parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.createElement('OPTION'); 
 				opt.text	=	"<%=short_desc%>";
				opt.value	=	"<%=allergy_type_code%>";
				parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].allergy_item.add(opt); 
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

