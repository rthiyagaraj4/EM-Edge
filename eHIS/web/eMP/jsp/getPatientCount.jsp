<%@ page import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection con = null;
	ResultSet rset=null;	
	PreparedStatement pstmt=null;
	String natid = "";	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		natid = request.getParameter("NatID");	
		String smart_data =request.getParameter("smart_data"); 
		if(session.getAttribute("smart_data")!= null)
			{
			session.removeAttribute("smart_data");
			}
		session.setAttribute("smart_data",smart_data);	
		
		//Start by santhosh for TH-KW-CRF-0019.1
		if(session.getAttribute("smart_card_data")!= null)
		{
			session.removeAttribute("smart_card_data");
		}
		if(request.getParameter("smart_card_data") != null){
			String smart_card_data =request.getParameter("smart_card_data"); 
			session.setAttribute("smart_card_data",smart_card_data);
		}
		//End by santhosh for TH-KW-CRF-0019.1
		
		int pat_cnt = 0;
		String pat_id = "";
		pstmt   = con.prepareStatement("select count(1) as patcount,patient_id from mp_patient where national_id_no='"+natid+"' group by patient_id ");
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next())
			{   
			pat_cnt = rset.getInt("patcount");
			pat_id = rset.getString("patient_id");							
			} 
	out.print("<patcnt>"+pat_cnt+"</patcnt> <patid>"+pat_id+"</patid>");		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if (rset != null)   rset.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con, request);
	}
	%>
