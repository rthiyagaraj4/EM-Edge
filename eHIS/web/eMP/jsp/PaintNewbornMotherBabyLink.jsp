<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
%>
<html>
<HEAD>
<title><fmt:message key="eMP.MotherBabyLink.label" bundle="${mp_labels}"/></title>
</HEAD>
<%
    	//String locale			= (String)session.getAttribute("LOCALE");
	    //String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	    String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";

		//Added for CA
		String patient_id				= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		//
		String motherid				= request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		if(motherid==null)motherid="";
		if (motherid.equals("") && !patient_id.equals("")) motherid = patient_id;
		String function_id			=request.getParameter("function_id")==null?"": request.getParameter("function_id");
		if(function_id==null)function_id="";
		String encounterid						= "";
		Connection con = null;
		String Facility_Id = (String) session.getValue("facility_id"); 		
		PreparedStatement pstmt	= null;
		ResultSet rset		= null;
		String ip_install_yn = request.getParameter("ipInstallYn")==null?"N": request.getParameter("ipInstallYn");
		/*	Commented for PE on 29/02/2010 by Muthu
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP'");
			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				ip_install_yn = rset.getString(1);
				if (ip_install_yn==null) ip_install_yn = "";
			}
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
		}
		*/
		try{
			con = ConnectionManager.getConnection(request);
			if (ip_install_yn.equals("Y"))
			{
				String sql1 = "Select encounter_id from IP_OPEN_ENCOUNTER where	Patient_Id = '"+motherid+"' and facility_id = '"+Facility_Id+"'";
				pstmt			= con.prepareStatement(sql1);
				rset				= pstmt.executeQuery();
				if(rset!=null && rset.next())
				{
					encounterid			= rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
				}
			}
			if (encounterid.equals(""))
			{
				encounterid = "Patient_ID="+motherid;
			}
			else
			{
				encounterid = "EncounterId="+encounterid;
			}
		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rset != null) rset.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
if(function_id.equals("") && patient_id.equals(""))
{
%>	
		<iframe src="../../eCommon/jsp/pline.jsp?<%=encounterid%>&accessRights=<%=accessRights%>" name="babylink1_frame" noresize scrolling="no" style='height:12vh;width:99vw'></iframe>
		<iframe src="../../eMP/jsp/NewbornMotherBabyLink.jsp?mother_id=<%=motherid%>&accessRights=<%=accessRights%>" name="babylink2_frame" scrolling="auto" style='height:70vh;width:99vw'></iframe>
		<iframe src="../../eMP/jsp/NewbornMotherBabyLinkTools.jsp?mother_id=<%=motherid%>&accessRights=<%=accessRights%>" name="babylink3_frame" scrolling="no" style='height:10vh;width:99vw'></iframe>
<%
}
else
{
	if (!patient_id.equals(""))
	{
%>
		<iframe src="../../eMP/jsp/NewbornMotherBabyLink.jsp?mother_id=<%=motherid%>" name="babylink2_frame" scrolling="auto" style='height:80vh;width:99vw'></iframe>
<%
	}
	else
	{%>
		<iframe src="../../eCommon/jsp/pline.jsp?<%=encounterid%>" name="babylink1_frame" noresize scrolling="no" style='height:12vh;width:99vw'></iframe>
		<iframe src="../../eMP/jsp/NewbornMotherBabyLink.jsp?mother_id=<%=motherid%>" name="babylink2_frame" scrolling="auto" style='height:70vh;width:99vw'></iframe>
		<iframe src="../../eMP/jsp/NewbornMotherBabyLinkTools.jsp?close=Y&mother_id=<%=motherid%>&accessRights=<%=accessRights%>" name="babylink3_frame" scrolling="no" style='height:10vh;width:99vw'></iframe>
<%	}
}
				%>
</html>

