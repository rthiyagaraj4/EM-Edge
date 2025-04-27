<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCA/js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()"   onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name='CASectionTemplateDetailCheckForm' id='CASectionTemplateDetailCheckForm'>

 <%
	

	String sectionCode="",comp_id="", srl_no="",includeyn="";
    
    sectionCode = request.getParameter("section")==null?"":request.getParameter("section");
	comp_id = request.getParameter("component")==null?"":request.getParameter("component");
	srl_no = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	includeyn = request.getParameter("includeyn")==null?"":request.getParameter("includeyn");
    


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;

	try
	{
		con=ConnectionManager.getConnection(request);
        


		StringBuffer sqlinc=new StringBuffer();
		sqlinc.append("select comp_id from ca_section_template where SEC_HDG_CODE=? and COMP_ID=? and INCLUDE_FOR_ANAL_YN='Y' ");
      
			 if(!srl_no.equals(""))
             sqlinc.append(" and srl_no <> ?");
     
			pstmt = con.prepareStatement(sqlinc.toString());

			pstmt.setString(1,sectionCode);
			pstmt.setString(2,comp_id);
//            pstmt.setString(3,includeyn);     
			

			
			if(!srl_no.equals(""))
            pstmt.setString(3,srl_no);     
			
			rs = pstmt.executeQuery();

           
		if(rs!=null && rs.next())
		{
          
		  out.println("<script>alert(getMessage('DUP_COMP_WITH_ANAL','CA'));</script>");
		  
         out.println("<script>top.content.master_pages.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'</script>");	
		}
        else
		{
             
       out.println("<script>top.content.master_pages.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.submit();</script>");

	   	
		}
		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	}
	catch(Exception e){
		e.printStackTrace();
		out.println("Exception "+e);

	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>

