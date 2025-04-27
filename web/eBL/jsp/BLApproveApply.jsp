<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,eBL.BLMedRepOutStdAmtBean,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String noOfDecimals = request.getParameter("noOfDecimal1");
	request.setCharacterEncoding("UTF-8");
	String	called_frm  = request.getParameter("called_frm");
    BLMedRepOutStdAmtBean bLMedRepOutStdAmtBean=new BLMedRepOutStdAmtBean();
    Connection con				= null;
    Connection con1				= null;
    PreparedStatement pstmt		= null;
    Statement pstmt1		= null;
    ResultSet rs				= null;	
    ResultSet rs1				= null;
    Double patOutStdAmt=0.0;    
    String facilityId =  (String)request.getParameter("facilityId");  
    String patientId = (String)request.getParameter("patient_id");
    String authorized_yn = (String)request.getParameter("authorized_yn");   
    HttpSession httpSession = request.getSession(false);
    Properties p = (Properties)httpSession.getValue("jdbc");
	String strclientip=p.getProperty("client_ip_address");
	if (strclientip==null) strclientip = "";
	String strLoggedUser = p.getProperty("login_user"); 
	if(strLoggedUser == null) strLoggedUser="";
    System.out.println("strclientip/strLoggedUser"+strclientip+"/"+strLoggedUser);
    System.err.println("BLMedRepOutStdAmt.jsp......facilityid/patientId "+facilityId+"/"+patientId+"-called_frm="+called_frm);		   
    patOutStdAmt=bLMedRepOutStdAmtBean.fetchPatOutStdAmt(facilityId,patientId);
if (called_frm.equals("apply")) {
	    	try{
	    		
	    	con1	=	ConnectionManager.getConnection(request);	
		
				System.err.println("BLMedRepOutStdAmt.jsp......authorized_yn= "+authorized_yn);	
				pstmt1 = con1.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
				String sqlMedRepOutStdAmtAuthYN1 = "SELECT authorized_yn FROM bl_mr_authorized_patient WHERE  operating_facility_id='"+facilityId+"' and patient_id='"+patientId+"'";
			
		    
		    	rs1 = pstmt1.executeQuery(sqlMedRepOutStdAmtAuthYN1) ;	    		    	
		    	if(rs1.next()){
		    		 String f = rs1.getString("authorized_yn");
		             rs1.updateString( "authorized_yn",authorized_yn);
		             rs1.updateRow();
		    	}else{
		    		String sqlMedRepOutStdAmtAuthYNinsert="INSERT INTO bl_mr_authorized_patient(operating_facility_id, patient_id,authorized_yn,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES('"+facilityId+"','"+patientId+"','"+authorized_yn+"','"+strLoggedUser+"',sysdate,'"+strclientip+"','"+facilityId+"','"+strLoggedUser+"',sysdate,'"+strclientip+"','"+facilityId+"')";
		    		System.out.println("sqlMedRepOutStdAmtAuthYNinsert"+sqlMedRepOutStdAmtAuthYNinsert);
		    		rs1 = pstmt1.executeQuery(sqlMedRepOutStdAmtAuthYNinsert) ;	
		    	}
		    	con1.commit();	    
	    	
	    	}catch(Exception e)
		    	{
		    		System.err.println("Exception in BLMedRepOutStdAmt AJAX CALL"+e);
		    	}
		    	finally
				{
		    		if (rs1 != null) rs1.close();
		        	pstmt1.close();	
					ConnectionManager.returnConnection(con1);
				}	 
	    	}
	    	
	    	 %>
