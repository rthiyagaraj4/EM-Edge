/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;




import webbeans.eCommon.*;

public class HealthRiskFactorsSetupServlet extends HttpServlet 
{
    public void init(ServletConfig servletconfig) throws ServletException
    {
        super.init(servletconfig);
    }

    public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
		PrintWriter out = null;
		try
        {
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");	
            out = res.getWriter();
            String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res, out);
            if(mode.trim().equalsIgnoreCase("update"))
                modify(req, res, out);            
        }catch(Exception e){
            out.println(e.toString());            
			e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {		
		PrintWriter out = null;
		try{
			out = res.getWriter();
            doPost(req, res);
        }catch(Exception e){
            out.println("Exception in invoking doPost Method");            
			e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ArrayList<String> recordHistory=new ArrayList<String>();
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		
		int rowsCount1 = 0; 
		int rowsCount2 = 0;
		int rowsCount3 = 0;
		
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		

	    String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
		
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		//int srl_no=0;//checkstyle
		
		String riskFactorType	= "";		
		String rFDesc			= "";		
		String enabled			= "";		
		String riskFactorInd	= "";
		String riskFactorSetId 	= "";
		String riskFactorCode  	= "";
		
		
		String message1 	= "";
		String message2 	= "0";
		
		riskFactorType	= req.getParameter("risk_factor_id") == null ? "": req.getParameter("risk_factor_id") ;
		rFDesc			= req.getParameter("risk_fact_desc") == null ? "": req.getParameter("risk_fact_desc") ;		
		enabled			= req.getParameter("eff_status") == null ? "": req.getParameter("eff_status") ;		
		
		riskFactorInd	= req.getParameter("factor_type") == null ? "": req.getParameter("factor_type") ;
		
		if("AG".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type") == null ? "": req.getParameter("factor_type") ;
			riskFactorCode  = req.getParameter("ageGroup_id") == null ? "": req.getParameter("ageGroup_id") ;
		}else if("AL".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type") == null ? "": req.getParameter("factor_type") ;
			riskFactorCode  = req.getParameter("allergen_id") == null ? "": req.getParameter("allergen_id") ;
		}else if("BM".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("weight_id") == null ? "": req.getParameter("weight_id") ;
			riskFactorCode  = req.getParameter("height_id") == null ? "": req.getParameter("height_id") ;
		}else if("CC".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type") == null ? "": req.getParameter("factor_type") ;
			riskFactorCode  = req.getParameter("complaint_id") == null ? "": req.getParameter("complaint_id") ;
		}else if("CA".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type") == null ? "": req.getParameter("factor_type") ;
			riskFactorCode  = req.getParameter("discreate_id") == null ? "": req.getParameter("discreate_id") ;
		}else if("LB".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("factor_code") == null ? "": req.getParameter("factor_code") ;
		}else if("OR".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("factor_code") == null ? "": req.getParameter("factor_code") ;
		}else if("RD".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("factor_code") == null ? "": req.getParameter("factor_code") ;
		}else if("PH".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("drug_id") == null ? "": req.getParameter("drug_id") ;
		}else if("TS".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("diagnosisSet_code") == null ? "": req.getParameter("diagnosisSet_code") ;
			riskFactorCode  = req.getParameter("termSet_code") == null ? "": req.getParameter("termSet_code") ;
		}
		
		try
        {
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement("select * from CA_RISK_FACTOR_TYPE where RISK_FACTOR_TYPE=?");
			pstmt.setString(1,riskFactorType);
			rs=pstmt.executeQuery();
			if(rs.next()){
				java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"CODE_ALREADY_EXISTS","Common");                
				message1 = (java.lang.String)hashtable.get("message");					
			}else{
				pstmt1 = con.prepareStatement("INSERT INTO CA_RISK_FACTOR_TYPE (RISK_FACTOR_TYPE,RISK_FACTOR_DESC,RISK_FACTOR_MESG,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt1.setString(1,riskFactorType);
				pstmt1.setString(2,rFDesc);
				pstmt1.setString(3 ,"");
				pstmt1.setString(4,enabled);
				pstmt1.setString(5, addedById);
				pstmt1.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
				pstmt1.setString(7, facilityId);
				pstmt1.setString(8, addedAtWorkstation);
				pstmt1.setString(9, modifiedById);
				pstmt1.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
				pstmt1.setString(11, facilityId);
				pstmt1.setString(12, modifiedAtWorkstation);				
				
				rowsCount1=rowsCount1+pstmt1.executeUpdate();				
				if(rowsCount1!=0){
					pstmt2= con.prepareStatement("INSERT INTO CA_RISK_FACTOR (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
					
					pstmt2.setString(1 ,riskFactorType);
					pstmt2.setString(2 ,riskFactorInd);
					pstmt2.setString(3 ,riskFactorSetId);
					pstmt2.setString(4 ,riskFactorCode);
					pstmt2.setString(5, addedById);
					pstmt2.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
					pstmt2.setString(7, facilityId);
					pstmt2.setString(8, addedAtWorkstation);
					pstmt2.setString(9, modifiedById);
					pstmt2.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
					pstmt2.setString(11, facilityId);
					pstmt2.setString(12, modifiedAtWorkstation);
					
					rowsCount2=rowsCount2+pstmt2.executeUpdate();	
					
					if(rowsCount2!=0){
						
						recordHistory.add(addedById);
						recordHistory.add(facilityId);
						recordHistory.add(addedAtWorkstation);
						recordHistory.add(modifiedById);
						recordHistory.add(facilityId);
						recordHistory.add(modifiedAtWorkstation);
						if("AG".equals(riskFactorInd)){
							rowsCount3 = insetAgeGroupDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
						}else if("AL".equals(riskFactorInd)){
							rowsCount3 = insetAllergenDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
						}else if("CC".equals(riskFactorInd)){
							rowsCount3 = insetChiefComplaintDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
						}else if("CA".equals(riskFactorInd) || "LB".equals(riskFactorInd) || "OR".equals(riskFactorInd) || "RD".equals(riskFactorInd) || "BM".equals(riskFactorInd)){
							rowsCount3 = insetGridDtls(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
						}else if("PH".equals(riskFactorInd)){
							rowsCount3 = insetPHDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
						}else if("TS".equals(riskFactorInd) ){
							rowsCount3 = insetTermSetDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
						}
						
						if(rowsCount3!=0){
							con.commit();
							java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");                
							message1 = (java.lang.String)hashtable.get("message");
							message2 = "1";
						}else{
							try{
								con.rollback();
							}catch(Exception ee){
								ee.printStackTrace();
							}
							message1 = "Exception raise by Servlet..........So Record Not inserted.";							
						}						
					}else{
						try{
							con.rollback();
						}catch(Exception ee){
							ee.printStackTrace();
						}
						message1 = "Exception raise by Servlet...So Record Not inserted.";
					}
				}else{
					try{
						con.rollback();
					}catch(Exception ee){
						ee.printStackTrace();
					}
					message1 = "Exception raise by Servlet ...So Record Not inserted.";	
				}
			}
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
		}catch(Exception e){
			try{
				con.rollback();
				message1="Exception raise by Servlet ...So Record Not inserted  Foll: Error Received : "+ e.toString();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            e.printStackTrace();
        }finally{
			try{
				if (rs!= null) rs.close();
				if (ps!= null) ps.close();
				if (pstmt!= null) pstmt.close();
				if (pstmt1!= null) pstmt1.close();
				if (pstmt2!= null) pstmt2.close();
				if (pstmt3!= null) pstmt3.close();
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
		
	}
	private int insetAgeGroupDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		//PreparedStatement pstmt1 = null;//checkstyle
		//PreparedStatement pstmt2 = null;//checkstyle
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		int rowsCount=0;
		int srl_no=0;
		
		String patientSex	= "";
		String aGRFIID		= "";
		String aGRemarks	= "";
		int riskFactorIndScore=0;
		patientSex		= req.getParameter("patientSex") == null ? "": req.getParameter("patientSex") ;
		aGRFIID		= req.getParameter("agrfiID") == null ? "": req.getParameter("agrfiID") ;
		aGRemarks	= req.getParameter("agRemarks") == null ? "": req.getParameter("agRemarks") ;
		
		try{
			ps = con.prepareStatement("SELECT (SRL_NO+1) SRLNO FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? AND ROWNUM =1 ORDER BY SRL_NO DESC ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			rs=ps.executeQuery();
			if(rs.next()){
				srl_no=rs.getInt("SRLNO");
			}else{
				srl_no=1;
			}
			
			if(aGRFIID.equals("H")){
				riskFactorIndScore = 3;
			}else if(aGRFIID.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
			
			pstmt3= con.prepareStatement("INSERT INTO CA_RISK_FACTOR_DTL (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,RISK_FACTOR_MESG,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt3.setString(1,riskFactorType);
			pstmt3.setString(2 ,riskFactorInd);
			pstmt3.setString(3 ,riskFactorSetId);
			pstmt3.setString(4 ,riskFactorCode);
			pstmt3.setInt(5,srl_no );
			pstmt3.setString(6, patientSex);
			pstmt3.setString(7, aGRFIID);
			pstmt3.setInt(8, riskFactorIndScore);
			pstmt3.setString(9, aGRemarks);
			pstmt3.setString(10, recordHistory.get(0));
			pstmt3.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
			pstmt3.setString(12, recordHistory.get(1));
			pstmt3.setString(13, recordHistory.get(2));
			pstmt3.setString(14, recordHistory.get(3));
			pstmt3.setTimestamp(15, new Timestamp(System.currentTimeMillis()));
			pstmt3.setString(16, recordHistory.get(4));
			pstmt3.setString(17, recordHistory.get(5));
			
			rowsCount=rowsCount+pstmt3.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 15950 Fix Starts
		finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt3!= null) pstmt3.close();
				if (ps!= null) ps.close();
			
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
		// 15950 Fix Ends
		
		return rowsCount;
	}
	
	private int insetAllergenDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int rowsCount=0;
		int srl_no=0;
		
		String patientSex		= "";
		String allergenRFIId	= "";
		String allergenRemarks	= "";
		String allergenStaus	= "";
		int riskFactorIndScore = 0;
		
		patientSex		= req.getParameter("patientSex") == null ? "": req.getParameter("patientSex") ;
		allergenRFIId		= req.getParameter("allergenRFIId") == null ? "": req.getParameter("allergenRFIId") ;
		allergenRemarks	= req.getParameter("allergenRemarks") == null ? "": req.getParameter("allergenRemarks") ;
		allergenStaus	= req.getParameter("allergenStaus") == null ? "": req.getParameter("allergenStaus") ;
		
		try{
			ps = con.prepareStatement("SELECT (SRL_NO+1) SRLNO FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? AND ROWNUM =1 ORDER BY SRL_NO DESC ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			rs=ps.executeQuery();
			if(rs.next()){
				srl_no=rs.getInt("SRLNO");
			}else{
				srl_no=1;
			}
			if(allergenRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(allergenRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
			
			pstmt1= con.prepareStatement("INSERT INTO CA_RISK_FACTOR_DTL (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,RISK_FACTOR_MESG,RISK_FACTOR_OPERATOR,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt1.setString(1,riskFactorType);
			pstmt1.setString(2 ,riskFactorInd);
			pstmt1.setString(3 ,riskFactorSetId);
			pstmt1.setString(4 ,riskFactorCode);
			pstmt1.setInt(5,srl_no );
			pstmt1.setString(6, patientSex);
			pstmt1.setString(7, allergenRFIId);
			pstmt1.setInt(8, riskFactorIndScore);
			pstmt1.setString(9, allergenRemarks);
			pstmt1.setString(10, allergenStaus);
			pstmt1.setString(11, recordHistory.get(0));
			pstmt1.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(13, recordHistory.get(1));
			pstmt1.setString(14, recordHistory.get(2));
			pstmt1.setString(15, recordHistory.get(3));
			pstmt1.setTimestamp(16, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(17, recordHistory.get(4));
			pstmt1.setString(18, recordHistory.get(5));
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 15950 Fix Starts
		finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt1!= null) pstmt1.close();
				if (ps!= null) ps.close();
			
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
		// 15950 Fix Ends
		return rowsCount;
	}
	
	private int insetChiefComplaintDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int rowsCount=0;
		int srl_no=0;
		
		String patientSex		= "";
		String chiefComplaintRFIId	= "";
		String chiefComplaintRemarks	= "";
		int riskFactorIndScore = 0;
		patientSex		= req.getParameter("patientSex") == null ? "": req.getParameter("patientSex") ;
		chiefComplaintRFIId		= req.getParameter("chiefComplaintRFIId") == null ? "": req.getParameter("chiefComplaintRFIId") ;
		chiefComplaintRemarks	= req.getParameter("chiefComplaintRemarks") == null ? "": req.getParameter("chiefComplaintRemarks") ;
		
		try{
			ps = con.prepareStatement("SELECT (SRL_NO+1) SRLNO FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? AND ROWNUM =1 ORDER BY SRL_NO DESC ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			rs=ps.executeQuery();
			if(rs.next()){
				srl_no=rs.getInt("SRLNO");
			}else{
				srl_no=1;
			}
			
			if(chiefComplaintRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(chiefComplaintRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
				
			pstmt1= con.prepareStatement("INSERT INTO CA_RISK_FACTOR_DTL (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,RISK_FACTOR_MESG,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt1.setString(1,riskFactorType);
			pstmt1.setString(2 ,riskFactorInd);
			pstmt1.setString(3 ,riskFactorSetId);
			pstmt1.setString(4 ,riskFactorCode);
			pstmt1.setInt(5,srl_no );
			pstmt1.setString(6, patientSex);
			pstmt1.setString(7, chiefComplaintRFIId);
			pstmt1.setInt(8, riskFactorIndScore);
			pstmt1.setString(9, chiefComplaintRemarks);
			pstmt1.setString(10, recordHistory.get(0));
			pstmt1.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(12, recordHistory.get(1));
			pstmt1.setString(13, recordHistory.get(2));
			pstmt1.setString(14, recordHistory.get(3));
			pstmt1.setTimestamp(15, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(16, recordHistory.get(4));
			pstmt1.setString(17, recordHistory.get(5));
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 15950 Fix Starts
				finally{
					try{
						if (rs!= null) rs.close();
						if (pstmt1!= null) pstmt1.close();
						if (ps!= null) ps.close();
					
					}
					catch(Exception ee){
						ee.printStackTrace();
					}
				} 
				// 15950 Fix Ends
		return rowsCount;
	}
	private int insetPHDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int rowsCount=0;
		int srl_no=0;
		
		String patientSex		= "";
		String pharmacyRFIId	= "";
		String pharmacyRemarks	= "";
		String pharmacyOperator	= "";
		int riskFactorIndScore = 0;
		
		patientSex			= req.getParameter("patientSex") == null ? "A": req.getParameter("patientSex") ;
		pharmacyRFIId		= req.getParameter("pharmacyRFIId") == null ? "": req.getParameter("pharmacyRFIId") ;
		pharmacyRemarks		= req.getParameter("pharmacyRemarks") == null ? "": req.getParameter("pharmacyRemarks") ;
		pharmacyOperator	=  req.getParameter("pharmacyOperator") == null ? "": req.getParameter("pharmacyOperator") ;
		
		try{
			ps = con.prepareStatement("SELECT (SRL_NO+1) SRLNO FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? AND ROWNUM =1 ORDER BY SRL_NO DESC ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			rs=ps.executeQuery();
			if(rs.next()){
				srl_no=rs.getInt("SRLNO");
			}else{
				srl_no=1;
			}
			
			if(pharmacyRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(pharmacyRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
				
			pstmt1= con.prepareStatement("INSERT INTO CA_RISK_FACTOR_DTL (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,SRL_NO,PATIENT_SEX,RISK_FACTOR_OPERATOR,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,RISK_FACTOR_MESG,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt1.setString(1,riskFactorType);
			pstmt1.setString(2 ,riskFactorInd);
			pstmt1.setString(3 ,riskFactorSetId);
			pstmt1.setString(4 ,riskFactorCode);
			pstmt1.setInt(5,srl_no );
			pstmt1.setString(6, patientSex);
			pstmt1.setString(7, pharmacyOperator);
			pstmt1.setString(8, pharmacyRFIId);
			pstmt1.setInt(9, riskFactorIndScore);
			pstmt1.setString(10, pharmacyRemarks);
			pstmt1.setString(11, recordHistory.get(0));
			pstmt1.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(13, recordHistory.get(1));
			pstmt1.setString(14, recordHistory.get(2));
			pstmt1.setString(15, recordHistory.get(3));
			pstmt1.setTimestamp(16, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(17, recordHistory.get(4));
			pstmt1.setString(18, recordHistory.get(5));
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 15950 Fix Starts
				finally{
					try{
						if (rs!= null) rs.close();
						if (pstmt1!= null) pstmt1.close();
						if (ps!= null) ps.close();
					
					}
					catch(Exception ee){
						ee.printStackTrace();
					}
				} 
				// 15950 Fix Ends
		
		return rowsCount;
	} 
	private int insetTermSetDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int rowsCount=0;
		//int rowsCount1=0;//checkstyle
		int srl_no=0;
		
		String patientSex		= "";
		String termSetRFIId	= "";
		String termSetRemarks	= "";
		String termSetOperator	= "";
		int riskFactorIndScore = 0;
		
		patientSex			= req.getParameter("patientSex") == null ? "A": req.getParameter("patientSex") ;
		termSetRFIId		= req.getParameter("termSetRFIId") == null ? "": req.getParameter("termSetRFIId") ;
		termSetRemarks		= req.getParameter("termSetRemarks") == null ? "": req.getParameter("termSetRemarks") ;
		termSetOperator	=  req.getParameter("termSetOperator") == null ? "": req.getParameter("termSetOperator") ;
		
		try{
			ps = con.prepareStatement("SELECT (SRL_NO+1) SRLNO FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? AND ROWNUM =1 ORDER BY SRL_NO DESC ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			rs=ps.executeQuery();
			if(rs.next()){
				srl_no=rs.getInt("SRLNO");
			}else{
				srl_no=1;
			}
			
			if(termSetRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(termSetRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
				
			pstmt1= con.prepareStatement("INSERT INTO CA_RISK_FACTOR_DTL (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,SRL_NO,PATIENT_SEX,RISK_FACTOR_OPERATOR,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,RISK_FACTOR_MESG,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt1.setString(1,riskFactorType);
			pstmt1.setString(2 ,riskFactorInd);
			pstmt1.setString(3 ,riskFactorSetId);
			pstmt1.setString(4 ,riskFactorCode);
			pstmt1.setInt(5,srl_no );
			pstmt1.setString(6, patientSex);
			pstmt1.setString(7, termSetOperator);
			pstmt1.setString(8, termSetRFIId);
			pstmt1.setInt(9, riskFactorIndScore);
			pstmt1.setString(10, termSetRemarks);
			pstmt1.setString(11, recordHistory.get(0));
			pstmt1.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(13, recordHistory.get(1));
			pstmt1.setString(14, recordHistory.get(2));
			pstmt1.setString(15, recordHistory.get(3));
			pstmt1.setTimestamp(16, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(17, recordHistory.get(4));
			pstmt1.setString(18, recordHistory.get(5));
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		// 15950 Fix Starts
				finally{
					try{
						if (rs!= null) rs.close();
						if (pstmt1!= null) pstmt1.close();
						if (ps!= null) ps.close();
					
					}
					catch(Exception ee){
						ee.printStackTrace();
					}
				} 
				// 15950 Fix Ends
		return rowsCount;
	}	
	/*private int insetDiagnosisDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int rowsCount=0;
		int srl_no=0;
		
		String patientSex		= "";
		String termSetRFIId	= "";
		String termSetRemarks	= "";
		String termSetOperator	= "";
		
		patientSex			= req.getParameter("patientSex") == null ? "A": req.getParameter("patientSex") ;
		termSetRFIId		= req.getParameter("termSetRFIId") == null ? "": req.getParameter("termSetRFIId") ;
		termSetRemarks		= req.getParameter("termSetRemarks") == null ? "": req.getParameter("termSetRemarks") ;
		termSetOperator	=  req.getParameter("termSetOperator") == null ? "": req.getParameter("termSetOperator") ;
		
		try{
			
			pstmt1= con.prepareStatement("INSERT INTO CA_DIAG_RISK_FACTOR (RISK_FACTOR,TERM_SET_ID,TERM_SET_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt1.setString(1,riskFactorType);
			pstmt1.setString(2 ,riskFactorSetId);
			pstmt1.setString(3 ,riskFactorCode);
			pstmt1.setString(4, recordHistory.get(0));
			pstmt1.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(6, recordHistory.get(1));
			pstmt1.setString(7, recordHistory.get(2));
			pstmt1.setString(8, recordHistory.get(3));
			pstmt1.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(10, recordHistory.get(4));
			pstmt1.setString(11, recordHistory.get(5));
			
			rowsCount=rowsCount+pstmt1.executeUpdate();		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}*/
	private int insetGridDtls(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int rowsCount=0;
		int srl_no=0;		
		
		
		int rowCount				= 0;
		
		String gender				= "";
		String allAgeValue			= "";
		String startAge				= "";
		String startAgeUnit			= "";
		String endAge				= "";
		String endAgeUnit			= "";
		int StartAgeDays			= 0;
		int endAgeDays				= 0;		
		String operatorInd			= "";
		String operator				= "";
		String operatorFromValue		= "";
		String operatorFromValueUnits= "";
		String operatorToValue		= "";
		String operatorToValueUnits	= "";
		String riskFactorUOM		= "";
		String riskFactorIndValue	= "";
		int riskFactorIndScore		= 0;
		int riskFactorOccur			= 0;
		String colorInd				= "";
		String remarks				= "";
		
		
		riskFactorUOM		= req.getParameter("discreateUOM") == null ? "": req.getParameter("discreateUOM") ;
		rowCount				= req.getParameter("rowId") == null ? 0: Integer.parseInt((String)req.getParameter("rowId")) ;		
		
		try{
			
			ps = con.prepareStatement("SELECT (SRL_NO+1) SRLNO FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? AND ROWNUM =1 ORDER BY SRL_NO DESC ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			rs=ps.executeQuery();
			if(rs.next()){
				srl_no=rs.getInt("SRLNO");
			}else{
				srl_no=1;
			}
			
			pstmt1= con.prepareStatement("INSERT INTO CA_RISK_FACTOR_DTL (RISK_FACTOR_TYPE,RISK_FACTOR_IND,RISK_FACTOR_SET_ID,RISK_FACTOR_CODE,SRL_NO,PATIENT_SEX,ALL_AGE_YN,START_AGE,START_AGE_UNITS,END_AGE,END_AGE_UNITS,START_AGE_DAYS,END_AGE_DAYS,RISK_FACTOR_OPER_IND,RISK_FACTOR_OPERATOR,RISK_FACTOR_FRM_VAL,RISK_FACTOR_FRM_UNIT,RISK_FACTOR_TO_VAL,RISK_FACTOR_TO_UNIT,REF_UOM_CODE,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,COLOR_IND,RISK_FACTOR_MESG,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,RISK_FACTOR_OCCUR) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for(int i=0;i<(rowCount+1);i++){
				gender				= req.getParameter("gender"+i) == null ? "": req.getParameter("gender"+i) ;
				if(!"".equals(gender) && gender!=null){					
					allAgeValue			= req.getParameter("allAgeValue"+i) == null ? "": req.getParameter("allAgeValue"+i) ;
					if("Y".equals(allAgeValue)){
						startAge			= "1" ;
						startAgeUnit		= "D" ;
						endAge				= "150" ;
						endAgeUnit			= "Y";
					}else{
						startAge			= req.getParameter("startAge"+i) == null ? "": req.getParameter("startAge"+i) ;
						startAgeUnit		= req.getParameter("startAgeUnit"+i) == null ? "": req.getParameter("startAgeUnit"+i) ;
						endAge				= req.getParameter("endAge"+i) == null ? "": req.getParameter("endAge"+i) ;
						endAgeUnit			= req.getParameter("endAgeUnit"+i) == null ? "": req.getParameter("endAgeUnit"+i) ;
					}
					if(startAgeUnit.equals("M"))
						StartAgeDays = Integer.parseInt(startAge) * 30 + 1;
					else if(startAgeUnit.equals("Y"))
						StartAgeDays = Integer.parseInt(startAge) * 365 + 1;
					else
						StartAgeDays = Integer.parseInt(startAge);

					if(endAgeUnit.equals("M"))
						endAgeDays = Integer.parseInt(endAge) * 30 - 1;
					else if(endAgeUnit.equals("Y"))
						endAgeDays = Integer.parseInt(endAge) * 365 - 1;
					else
						endAgeDays = Integer.parseInt(endAge);
					operatorInd			= req.getParameter("operator_ind") == null ? "": req.getParameter("operator_ind") ;	
					operator			= req.getParameter("operator"+i) == null ? "": req.getParameter("operator"+i) ;
					operatorFromValue	= req.getParameter("operatorFromValue"+i) == null ? "": req.getParameter("operatorFromValue"+i) ;
					if("B".equals(operator)){
						operatorToValue 	= req.getParameter("operatorToValue"+i) == null ? "": req.getParameter("operatorToValue"+i) ;
					}
					if("PV".equals(operator)){
						operatorFromValueUnits	= req.getParameter("operatorIncreDecre"+i) == null ? "": req.getParameter("operatorIncreDecre"+i) ;
						riskFactorOccur		= req.getParameter("operatorOccur"+i) == null ? 0: Integer.parseInt((String)req.getParameter("operatorOccur"+i)) ;
					}
					riskFactorIndValue		= req.getParameter("riskFactorIndValue"+i) == null ? "": req.getParameter("riskFactorIndValue"+i) ;
					
					
					if(riskFactorIndValue.equals("H")){
						riskFactorIndScore = 3;
					}else if(riskFactorIndValue.equals("A")){
						riskFactorIndScore = 2;
					}else
						riskFactorIndScore = 1;
						
					remarks				= req.getParameter("remarks"+i) == null ? "": req.getParameter("remarks"+i) ;
					
					pstmt1.setString(1,  riskFactorType);
					pstmt1.setString(2,  riskFactorInd);
					pstmt1.setString(3,  riskFactorSetId);
					pstmt1.setString(4,  riskFactorCode);
					pstmt1.setInt	(5,  srl_no );
					pstmt1.setString(6,  gender);
					pstmt1.setString(7,  allAgeValue);
					pstmt1.setString(8,  startAge);
					pstmt1.setString(9,  startAgeUnit);
					pstmt1.setString(10,  endAge);
					pstmt1.setString(11, endAgeUnit);
					pstmt1.setInt	(12, StartAgeDays);
					pstmt1.setInt	(13, endAgeDays);
					pstmt1.setString(14, operatorInd);
					pstmt1.setString(15, operator);
					pstmt1.setString(16, operatorFromValue);
					pstmt1.setString(17, operatorFromValueUnits);
					pstmt1.setString(18, operatorToValue);
					pstmt1.setString(19, operatorToValueUnits);
					pstmt1.setString(20, riskFactorUOM);
					pstmt1.setString(21, riskFactorIndValue);
					pstmt1.setInt	(22, riskFactorIndScore);
					pstmt1.setString(23, colorInd);
					pstmt1.setString(24, remarks);
					
					pstmt1.setString(25, recordHistory.get(0));
					pstmt1.setTimestamp(26, new Timestamp(System.currentTimeMillis()));
					pstmt1.setString(27, recordHistory.get(1));
					pstmt1.setString(28, recordHistory.get(2));
					pstmt1.setString(29, recordHistory.get(0));
					pstmt1.setTimestamp(30, new Timestamp(System.currentTimeMillis()));
					pstmt1.setString(31, recordHistory.get(1));
					pstmt1.setString(32, recordHistory.get(2));
					pstmt1.setInt(33, riskFactorOccur);
					
					/*System.out.println("*****************************"+i+"--->Start**************************************");
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorType========>"+riskFactorType);
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorInd========>"+riskFactorInd);
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorSetId========>"+riskFactorSetId);
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorCode========>"+riskFactorCode);
					System.out.println("	HealthRiskFactorsSetupServlet.java========srl_no================>"+srl_no);
					System.out.println("	HealthRiskFactorsSetupServlet.java========gender================>"+gender);
					System.out.println("	HealthRiskFactorsSetupServlet.java========startAge==============>"+startAge);
					System.out.println("	HealthRiskFactorsSetupServlet.java========startAgeUnit==========>"+startAgeUnit);
					System.out.println("	HealthRiskFactorsSetupServlet.java========endAge================>"+endAge);
					System.out.println("	HealthRiskFactorsSetupServlet.java========endAgeUnit============>"+endAgeUnit);
					System.out.println("	HealthRiskFactorsSetupServlet.java========StartAgeDays==========>"+StartAgeDays);
					System.out.println("	HealthRiskFactorsSetupServlet.java========endAgeDays============>"+endAgeDays);
					System.out.println("	HealthRiskFactorsSetupServlet.java========operatorInd===========>"+operatorInd);
					System.out.println("	HealthRiskFactorsSetupServlet.java========operator==============>"+operator);
					System.out.println("	HealthRiskFactorsSetupServlet.java========opratorFromValue======>"+operatorFromValue);
					System.out.println("	HealthRiskFactorsSetupServlet.java========opratorFromValueUnits=>"+operatorFromValueUnits);
					System.out.println("	HealthRiskFactorsSetupServlet.java========opratorToValue========>"+operatorToValue);
					System.out.println("	HealthRiskFactorsSetupServlet.java========opratorToValueUnits===>"+operatorToValueUnits);
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorUOM=========>"+riskFactorUOM);
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorIndValue====>"+riskFactorIndValue);
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorIndScore====>"+riskFactorIndScore);
					System.out.println("	HealthRiskFactorsSetupServlet.java========colorInd==============>"+colorInd);
					System.out.println("	HealthRiskFactorsSetupServlet.java========remarks===============>"+remarks);
					System.out.println("	HealthRiskFactorsSetupServlet.java========ADDED_BY_ID===========>"+recordHistory.get(0));
					System.out.println("	HealthRiskFactorsSetupServlet.java========ADDED_DATE============>"+new Timestamp(System.currentTimeMillis()));
					System.out.println("	HealthRiskFactorsSetupServlet.java========ADDED_AT_WS_NO========>"+recordHistory.get(1));
					System.out.println("	HealthRiskFactorsSetupServlet.java========ADDED_FACILITY_ID=====>"+recordHistory.get(2));
					System.out.println("	HealthRiskFactorsSetupServlet.java========MODIFIED_BY_ID========>"+recordHistory.get(0));
					System.out.println("	HealthRiskFactorsSetupServlet.java========MODIFIED_DATE=========>"+ new Timestamp(System.currentTimeMillis()));
					System.out.println("	HealthRiskFactorsSetupServlet.java========MODIFIED_AT_WS_NO=====>"+recordHistory.get(1));
					System.out.println("	HealthRiskFactorsSetupServlet.java========MODIFIED_FACILITY_ID==>"+recordHistory.get(2));
					System.out.println("	HealthRiskFactorsSetupServlet.java========riskFactorOccur==>"+riskFactorOccur);
					System.out.println("*****************************"+i+"--->End**************************************");*/
					pstmt1.addBatch();
					srl_no++;
				}
			}			
			try {
				pstmt1.executeBatch();
				rowsCount=srl_no;
			} catch(BatchUpdateException e) {
				rowsCount =0;
				// handle bad record, and re-batch the remaining?
			}			
			System.out.println("	HealthRiskFactorsSetupServlet.java==CA=====rowsCount=========>"+rowsCount); 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("	HealthRiskFactorsSetupServlet.java  Error : "+e.getMessage());
		}
		// 15950 Fix Starts
				finally{
					try{
						if (rs!= null) rs.close();
						if (pstmt1!= null) pstmt1.close();
						if (ps!= null) ps.close();
					
					}
					catch(Exception ee){
						ee.printStackTrace();
					}
				} 
				// 15950 Fix Ends
		
		return rowsCount;
	}
	
	
    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement ps = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ArrayList<String> recordHistory=new ArrayList<String>();
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		
		int rowsCount1 = 0; 
		int rowsCount2 = 0;
		
		
		String modifiedById="";		
		String modifiedAtWorkstation="";
		

	    String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
		
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
			
		String riskFactorType	= "";		
		String rFDesc			= "";		
		String enabled			= "";		
		String riskFactorInd	= "";
		String riskFactorSetId 	= "";
		String riskFactorCode  	= "";
		
		
		String message1 	= "";
		String message2 	= "0";
		
		riskFactorType	= req.getParameter("risk_factor_id") == null ? "": req.getParameter("risk_factor_id") ;
		rFDesc			= req.getParameter("risk_fact_desc") == null ? "": req.getParameter("risk_fact_desc") ;		
		enabled			= req.getParameter("eff_status") == null ? "": req.getParameter("eff_status") ;		
		
		
		riskFactorInd	= req.getParameter("factor_type_") == null ? "": req.getParameter("factor_type_") ;
		
		if("AG".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type_") == null ? "": req.getParameter("factor_type_") ;
			riskFactorCode  = req.getParameter("ageGroup_id_") == null ? "": req.getParameter("ageGroup_id_") ;
		}else if("AL".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type_") == null ? "": req.getParameter("factor_type_") ;
			riskFactorCode  = req.getParameter("allergen_id_") == null ? "": req.getParameter("allergen_id_") ;
		}else if("BM".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("weight_id") == null ? "": req.getParameter("weight_id") ;
			riskFactorCode  = req.getParameter("height_id") == null ? "": req.getParameter("height_id") ;
		}else if("CC".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type_") == null ? "": req.getParameter("factor_type_") ;
			riskFactorCode  = req.getParameter("complaint_id") == null ? "": req.getParameter("complaint_id") ;
		}else if("CA".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_type_") == null ? "": req.getParameter("factor_type_") ;
			riskFactorCode  = req.getParameter("discreate_id") == null ? "": req.getParameter("discreate_id") ;
		}else if("LB".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("factor_code") == null ? "": req.getParameter("factor_code") ;
		}else if("OR".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("factor_code") == null ? "": req.getParameter("factor_code") ;
		}else if("RD".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("factor_code") == null ? "": req.getParameter("factor_code") ;
		}else if("PH".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("factor_set_id") == null ? "": req.getParameter("factor_set_id") ;
			riskFactorCode  = req.getParameter("drug_id") == null ? "": req.getParameter("drug_id") ;
		}else if("TS".equals(riskFactorInd)){
			riskFactorSetId	= req.getParameter("diagnosisSet_code_") == null ? "": req.getParameter("diagnosisSet_code_") ;
			riskFactorCode  = req.getParameter("termSet_code") == null ? "": req.getParameter("termSet_code") ;
		}
		
		try
        {
			con = ConnectionManager.getConnection(req);			
			pstmt1 = con.prepareStatement("UPDATE CA_RISK_FACTOR_TYPE SET RISK_FACTOR_DESC=?, RISK_FACTOR_MESG=?, EFF_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE RISK_FACTOR_TYPE=?");
			pstmt1.setString(1,rFDesc);
			pstmt1.setString(2 ,"");
			pstmt1.setString(3,enabled);				
			pstmt1.setString(4, modifiedById);
			pstmt1.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(6, facilityId);
			pstmt1.setString(7, modifiedAtWorkstation);
			pstmt1.setString(8,riskFactorType);				
			
			rowsCount1=rowsCount1+pstmt1.executeUpdate();				
			if(rowsCount1!=0){			
				recordHistory.add(modifiedById);
				recordHistory.add(facilityId);
				recordHistory.add(modifiedAtWorkstation);
				
				if("AG".equals(riskFactorInd)){
					rowsCount2 = updateAgeGroupDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
				}else if("AL".equals(riskFactorInd)){
					rowsCount2 = updateAllergyDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
				}else if("CC".equals(riskFactorInd)){
					rowsCount2 = updateChiefComplaintDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
				}else if("CA".equals(riskFactorInd) || "LB".equals(riskFactorInd) || "OR".equals(riskFactorInd) || "RD".equals(riskFactorInd) || "BM".equals(riskFactorInd)){
					rowsCount2 = updateGridDtls(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
				}else if("PH".equals(riskFactorInd)){
					rowsCount2 = updatepharmacyDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
				}else if("TS".equals(riskFactorInd)){
					rowsCount2 = updateTermSetDtl(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
				}
				
				if(rowsCount2!=0){
					con.commit();
					java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_MODIFIED","SM");                
					message1 = (java.lang.String)hashtable.get("message");
					message2 = "1";
				}else{
					try{
						con.rollback();
					}catch(Exception ee){
						ee.printStackTrace();
					}
					message1 = "Exception raise by Servlet ...So Record Not Modified.";							
				}						
				
			}else{
				try{
					con.rollback();
				}catch(Exception ee){
					ee.printStackTrace();
				}
				message1 = "Exception raise by Servlet ...So Record Not Modified.";	
			}
			
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
		}catch(Exception e){
			try{
				con.rollback();
				message1="Exception raise by Servlet ...So Record Not Modified  Foll: Error Received : "+ e.toString();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            e.printStackTrace();
        }finally{
			try{
				if (rs!= null) rs.close();
				if (ps!= null) ps.close();
				if (pstmt!= null) pstmt.close();
				if (pstmt1!= null) pstmt1.close();
				if (pstmt2!= null) pstmt2.close();
				if (pstmt3!= null) pstmt3.close();
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}
	private int updateAgeGroupDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		//PreparedStatement ps = null;//checkstyle
		PreparedStatement pstmt1 = null;
		//ResultSet rs = null;//checkstyle
		int rowsCount=0;		
		
		String patientSex	= "";
		String aGRFIID		= "";
		String aGRemarks	= "";
		int	riskFactorIndScore	= 0;
		patientSex		= req.getParameter("patientSex") == null ? "": req.getParameter("patientSex") ;
		aGRFIID		= req.getParameter("agrfiID") == null ? "": req.getParameter("agrfiID") ;
		aGRemarks	= req.getParameter("agRemarks") == null ? "": req.getParameter("agRemarks") ;
		
		try{	
			if(aGRFIID.equals("H")){
				riskFactorIndScore = 3;
			}else if(aGRFIID.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
			pstmt1= con.prepareStatement("UPDATE CA_RISK_FACTOR_DTL SET PATIENT_SEX=?, RISK_FACTOR_SCORE_IND=?,RISK_FACTOR_SCORE=?, RISK_FACTOR_MESG=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");
			
			pstmt1.setString(1,  patientSex);
			pstmt1.setString(2,  aGRFIID);
			pstmt1.setInt(3, riskFactorIndScore);
			pstmt1.setString(4,  aGRemarks);
			pstmt1.setString(5,  recordHistory.get(0));
			pstmt1.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(7,  recordHistory.get(1));
			pstmt1.setString(8,  recordHistory.get(2));
			pstmt1.setString(9,  riskFactorType);
			pstmt1.setString(10,  riskFactorInd);
			pstmt1.setString(11, riskFactorSetId);
			pstmt1.setString(12, riskFactorCode);
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
			if (pstmt1!= null) pstmt1.close();//15950
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}
	private int updateAllergyDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		//PreparedStatement ps = null;//checkstyle
		PreparedStatement pstmt1 = null;
		//ResultSet rs = null;//Checkstyle
		int rowsCount=0;		
		
		String patientSex		= "";
		String allergenRFIId	= "";
		String allergenRemarks	= "";
		String allergenStaus	= "";
		int riskFactorIndScore = 0;
		patientSex		= req.getParameter("patientSex") == null ? "": req.getParameter("patientSex") ;
		allergenRFIId		= req.getParameter("allergenRFIId") == null ? "": req.getParameter("allergenRFIId") ;
		allergenRemarks	= req.getParameter("allergenRemarks") == null ? "": req.getParameter("allergenRemarks") ;
		allergenStaus	= req.getParameter("allergenStaus") == null ? "": req.getParameter("allergenStaus") ;
		
		try{	
			if(allergenRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(allergenRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
				
			pstmt1= con.prepareStatement("UPDATE CA_RISK_FACTOR_DTL SET PATIENT_SEX=?, RISK_FACTOR_SCORE_IND=?, RISK_FACTOR_SCORE=?, RISK_FACTOR_MESG=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, RISK_FACTOR_OPERATOR=? WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");
			
			pstmt1.setString(1,  patientSex);
			pstmt1.setString(2,  allergenRFIId);
			pstmt1.setInt(3, riskFactorIndScore);
			pstmt1.setString(4,  allergenRemarks);
			pstmt1.setString(5,  recordHistory.get(0));
			pstmt1.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(7,  recordHistory.get(1));
			pstmt1.setString(8,  recordHistory.get(2));
			pstmt1.setString(9, allergenStaus);
			pstmt1.setString(10,  riskFactorType);
			pstmt1.setString(11,  riskFactorInd);
			pstmt1.setString(12, riskFactorSetId);
			pstmt1.setString(13, riskFactorCode);
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
			if (pstmt1!= null) pstmt1.close();//15950
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}
	
	private int updateChiefComplaintDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
	
		//PreparedStatement ps = null;//checkstyle
		PreparedStatement pstmt1 = null;
		//ResultSet rs = null;//Checkstyle
		int rowsCount=0;		
		
		String patientSex				= "";
		String chiefComplaintRFIId		= "";
		String chiefComplaintRemarks	= "";
		int riskFactorIndScore = 0;
		patientSex		= req.getParameter("patientSex") == null ? "": req.getParameter("patientSex") ;
		chiefComplaintRFIId		= req.getParameter("chiefComplaintRFIId") == null ? "": req.getParameter("chiefComplaintRFIId") ;
		chiefComplaintRemarks	= req.getParameter("chiefComplaintRemarks") == null ? "": req.getParameter("chiefComplaintRemarks") ;
		
		try{	
			if(chiefComplaintRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(chiefComplaintRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
			pstmt1= con.prepareStatement("UPDATE CA_RISK_FACTOR_DTL SET PATIENT_SEX=?, RISK_FACTOR_SCORE_IND=?, RISK_FACTOR_SCORE=?, RISK_FACTOR_MESG=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");
			
			pstmt1.setString(1,  patientSex);
			pstmt1.setString(2,  chiefComplaintRFIId);
			pstmt1.setInt(3, riskFactorIndScore);
			pstmt1.setString(4,  chiefComplaintRemarks);
			pstmt1.setString(5,  recordHistory.get(0));
			pstmt1.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(7,  recordHistory.get(1));
			pstmt1.setString(8,  recordHistory.get(2));
			pstmt1.setString(9,  riskFactorType);
			pstmt1.setString(10,  riskFactorInd);
			pstmt1.setString(11, riskFactorSetId);
			pstmt1.setString(12, riskFactorCode);
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
			if (pstmt1!= null) pstmt1.close();//15950
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}
	private int updatepharmacyDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
	
		//PreparedStatement ps = null;//Checkstyle
		PreparedStatement pstmt1 = null;
		//ResultSet rs = null;//checkstyle
		int rowsCount=0;		
		
		String patientSex		= "";
		String pharmacyRFIId	= "";
		String pharmacyRemarks	= "";
		String pharmacyOperator	= "";
		int riskFactorIndScore = 0;
		patientSex			= req.getParameter("patientSex") == null ? "A": req.getParameter("patientSex") ;
		pharmacyRFIId		= req.getParameter("pharmacyRFIId") == null ? "": req.getParameter("pharmacyRFIId") ;
		pharmacyRemarks		= req.getParameter("pharmacyRemarks") == null ? "": req.getParameter("pharmacyRemarks") ;
		pharmacyOperator	=  req.getParameter("pharmacyOperator") == null ? "": req.getParameter("pharmacyOperator") ;
		
		try{	
			if(pharmacyRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(pharmacyRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
				
			pstmt1= con.prepareStatement("UPDATE CA_RISK_FACTOR_DTL SET PATIENT_SEX=?, RISK_FACTOR_OPERATOR=?, RISK_FACTOR_SCORE_IND=?, RISK_FACTOR_SCORE=?, RISK_FACTOR_MESG=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");
			
			pstmt1.setString(1,  patientSex);
			pstmt1.setString(2,  pharmacyOperator);
			pstmt1.setString(3,  pharmacyRFIId);
			pstmt1.setInt(4, riskFactorIndScore);
			pstmt1.setString(5,  pharmacyRemarks);
			pstmt1.setString(6,  recordHistory.get(0));
			pstmt1.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(8,  recordHistory.get(1));
			pstmt1.setString(9,  recordHistory.get(2));
			pstmt1.setString(10,  riskFactorType);
			pstmt1.setString(11,  riskFactorInd);
			pstmt1.setString(12, riskFactorSetId);
			pstmt1.setString(13, riskFactorCode);
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
			if (pstmt1!= null) pstmt1.close();//15950
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}
	private int updateTermSetDtl(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
	
		//PreparedStatement ps = null;//checkstyle
		PreparedStatement pstmt1 = null;
		//ResultSet rs = null;//Checkstyle
		int rowsCount=0;		
		
		String patientSex		= "";
		String termSetRFIId	= "";
		String termSetRemarks	= "";
		String termSetOperator	= "";
		int riskFactorIndScore = 0;
		patientSex			= req.getParameter("patientSex") == null ? "A": req.getParameter("patientSex") ;
		termSetRFIId		= req.getParameter("termSetRFIId") == null ? "": req.getParameter("termSetRFIId") ;
		termSetRemarks		= req.getParameter("termSetRemarks") == null ? "": req.getParameter("termSetRemarks") ;
		termSetOperator	=  req.getParameter("termSetOperator") == null ? "": req.getParameter("termSetOperator") ;
		
		try{	
			
			if(termSetRFIId.equals("H")){
				riskFactorIndScore = 3;
			}else if(termSetRFIId.equals("A")){
				riskFactorIndScore = 2;
			}else
				riskFactorIndScore = 1;
				
			pstmt1= con.prepareStatement("UPDATE CA_RISK_FACTOR_DTL SET PATIENT_SEX=?, RISK_FACTOR_OPERATOR=?, RISK_FACTOR_SCORE_IND=?, RISK_FACTOR_SCORE=?, RISK_FACTOR_MESG=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");
			
			pstmt1.setString(1,  patientSex);
			pstmt1.setString(2,  termSetOperator);
			pstmt1.setString(3,  termSetRFIId);
			pstmt1.setInt(4, riskFactorIndScore);
			pstmt1.setString(5,  termSetRemarks);
			pstmt1.setString(6,  recordHistory.get(0));
			pstmt1.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(8,  recordHistory.get(1));
			pstmt1.setString(9,  recordHistory.get(2));
			pstmt1.setString(10,  riskFactorType);
			pstmt1.setString(11,  riskFactorInd);
			pstmt1.setString(12, riskFactorSetId);
			pstmt1.setString(13, riskFactorCode);
			
			rowsCount=rowsCount+pstmt1.executeUpdate();
			if (pstmt1!= null) pstmt1.close();//15950
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}
	private int updateGridDtls(HttpServletRequest req, HttpServletResponse res,Connection con,String riskFactorType,String riskFactorInd,String riskFactorSetId,String riskFactorCode,ArrayList<String> recordHistory){
		PreparedStatement ps = null;
		//PreparedStatement pstmt1 = null;//checkstyle
		//ResultSet rs = null;//checkstyle
		int rowsCount=0;
		//int srl_no=0;//Checkstyle
		
		
		int rowCount				= 0;
		/*//commented for checkstyle
		String gender				= "";
		String allAgeValue			= "";
		String startAge				= "";
		String startAgeUnit			= "";
		String endAge				= "";
		String endAgeUnit			= "";
		int StartAgeDays			= 0;
		int endAgeDays				= 0;		
		String operatorInd	= "";
		String operator				= "";
		String operatorFromValue		= "";
		String operatorFromValueUnits= "";
		String operatorToValue		= "";
		String operatorToValueUnits	= "";
		String riskFactorIndValue	= "";
		int riskFactorIndScore		= 0;
		String colorInd				= "";
		String remarks				= "";
		*///commented for Checkstyle

		String riskFactorUOM		= "";		
		riskFactorUOM		= req.getParameter("discreateUOM") == null ? "": req.getParameter("discreateUOM") ;
		rowCount				= req.getParameter("rowId") == null ? 0: Integer.parseInt((String)req.getParameter("rowId")) ;
		
		try{			
			ps = con.prepareStatement("DELETE FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? ");
			ps.setString(1,riskFactorType);
			ps.setString(2,riskFactorInd);
			ps.setString(3,riskFactorSetId);
			ps.setString(4,riskFactorCode);
			ps.executeUpdate();
			if(ps!=null)ps.close();	

			rowsCount = insetGridDtls(req, res,con,riskFactorType,riskFactorInd,riskFactorSetId,riskFactorCode,recordHistory);
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowsCount;
	}
	
}
