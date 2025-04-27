<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,eBL.BLMedRepOutStdAmtBean,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>


    <%
    BLMedRepOutStdAmtBean bLMedRepOutStdAmtBean=new BLMedRepOutStdAmtBean();
    Connection con				= null;
    PreparedStatement pstmt		= null;
    ResultSet rs				= null;	
    Double patOutStdAmt=0.0;    
    String facilityId = (String) session.getValue("facility_id");  
    String patientId = request.getParameter("patientId");    
    String authorized_yn="";    
    Double medReqAuthValidity=0.0;
    String	     auth_start_time = ""; 
    patOutStdAmt=bLMedRepOutStdAmtBean.fetchPatOutStdAmt(facilityId,patientId);
    System.err.println("BLMedRepOutStdAmt.jsp-facilityid/patientId/patOutStdAmt::"+facilityId+"/"+patientId+"/"+patOutStdAmt);
    
    if(patOutStdAmt>0){
    	 try
     	{
 	    	  Double medReqAuthValidParam=0.0;
     	con	=	ConnectionManager.getConnection(request);
     	String sqlMedReqAuthValidity= BlRepository.getBlKeyValue("MED_REP_REQ_AUTH_VALIDITY"); 
     	pstmt=con.prepareStatement(sqlMedReqAuthValidity);
     	rs = pstmt.executeQuery() ;
     	if( rs != null ){
     		if( rs.next() ){
     			medReqAuthValidity=rs.getDouble(1);
     		}
     	}
     	if (rs != null) rs.close();
     	pstmt.close();	
     	
     	System.err.println("medReqAuthValidity "+medReqAuthValidity);	
     	
     	String sqlMedRepOutStdAmtAuthYN = BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_YN_CHECK");   	
     	pstmt = con.prepareStatement(sqlMedRepOutStdAmtAuthYN);
     	pstmt.setString(1,facilityId);
     	pstmt.setString(2,patientId);
     	pstmt.setDouble(3,medReqAuthValidity);
     	rs = pstmt.executeQuery() ;

     	if( rs != null ) 
     	{		
     		if( rs.next() )
     		{  
     			System.err.println("sqlMedRepOutStdAmtAuthYN :: "+sqlMedRepOutStdAmtAuthYN);
     			out.println("Y");	
     						
     		}
     		else{
     			System.err.println("auth_start_time / medReqAuthValidity :: "+auth_start_time+"/"+medReqAuthValidity);
     			out.println("N");
     		}
     			
     		}
     	else{
     		System.err.println("authorized_yn / medReqAuthValidity :: "+authorized_yn+"/"+medReqAuthValidity);
     			out.println("N");
     		}
     		
     	}
     	  	

     	catch(Exception e)
     	{
     		System.err.println("Exception in BLMedRepOutStdAmt.jsp "+e);
     		e.printStackTrace();
     	}
     	finally
 		{
     		if (rs != null) rs.close();

         	if(pstmt != null){
				pstmt.close();	
			}
 			ConnectionManager.returnConnection(con);
 		}
 	    
 	   
    	 
    }else{
    	out.println("Y");
    }
  
    
    
    %>
