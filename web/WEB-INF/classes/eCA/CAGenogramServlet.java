/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
23/09/2013	IN043631		Ramesh G		If we remove added Medical History we get exception error
23/09/2013	IN043653		Ramesh G		Enter 'Deceased Remarks'--Apply-- We get 'Operation Failed' Message
10/03/2022   29024          K.Pranay         unsed local variable[Common-ICN-0092]
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.net.URLEncoder;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class CAGenogramServlet extends HttpServlet
{
		private static DateFormat df	= new SimpleDateFormat( "yyyy-MM-dd" );
		private static	DateFormat df1	= new SimpleDateFormat( "dd/MM/yyyy" );
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = null;
		try{
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");	
            out = res.getWriter();            
			String mode					= checkForNull(req.getParameter("mode"));
			if("INSERT".equals(mode)){
				addFamilyMember(req, res, out);
			}else if("MODIFY".equals(mode)){
				modifyFamilyMember(req, res, out);
			}else if("AddEmotionalRelation".equals(mode)){
				addEmotionalRelation(req, res, out);
			}else if("RemoveEmotionalRelation".equals(mode)){
				removeEmotionalRelation(req, res, out);
			}else if("AddMedHistory".equals(mode)){
				addMedHistory(req, res, out);
			}else if("RemoveMedHistory".equals(mode)){
				removeMedHistory(req, res, out);
			}
        }catch(Exception e){
            out.println(e.toString());            
			e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = null;
		try{
			out = res.getWriter();
            doPost(req, res);
        }catch(Exception e){
            out.println("Exception in invoking doPost Method");            
			e.printStackTrace();
        }
    }
	private void addFamilyMember(HttpServletRequest req, HttpServletResponse res, PrintWriter out){
		String relationShipTypeValue		= checkForNull(req.getParameter("relationShipTypeValue"));
		
		if("COUPLE".equals(relationShipTypeValue) || "".equals(relationShipTypeValue)){
			addCoupleMember(req, res, out);
		}else if("CHILD".equals(relationShipTypeValue)){
			addChilds(req, res, out);
		}else if("PAR".equals(relationShipTypeValue)){
			addParents(req, res, out);
		} 
	}	
	private void addCoupleMember(HttpServletRequest req, HttpServletResponse res, PrintWriter out){
			
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		boolean flag = false;
	//	int rowsCount1				= 0;//Common-ICN-0092  
		String message1 			= "";
		String message2 			= "0";
			
		try{		
			
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			
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
		

			String selectNonPatID		= checkForNull(req.getParameter("selectNonPatID"));			 
			String stroeFirstIndexPat	= checkForNull(req.getParameter("stroeFirstIndexPat")); 
			String selectSrlNo			= checkForNull(req.getParameter("selectSrlNo"));
			
			String relationShipTypeValue= checkForNull(req.getParameter("relationShipTypeValue"));
			String relationValue		= checkForNull(req.getParameter("relationValue"));
			String relationStartDate	= checkForNull(req.getParameter("relationStartDate"));
			
			String recPatientId			= checkForNull(req.getParameter("rec_patient_id"));			
			String recPatientName		= checkForNull(req.getParameter("rec_patient_name"));
			String dateOfBirth			= checkForNull(req.getParameter("date_of_birth"));
			String gender				= checkForNull(req.getParameter("gender_hidden"));
			String deceasedDate			= checkForNull(req.getParameter("deceasedDate"));
			String deceasedRremarks		= checkForNull(req.getParameter("deceased_remarks"));
			
			String rec_sibling_position	= "";
			String deceasedYN			= "N";
			if(!"".equals(deceasedDate)) deceasedYN="Y";
	//		String mode					= checkForNull(req.getParameter("mode"));//Common-ICN-0092  
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNo				= "";
			con = ConnectionManager.getConnection(req);
			if("Y".equals(stroeFirstIndexPat)){				
				pstmt = con.prepareStatement("SELECT CA_GENO_ID_SEQ.NEXTVAL GENOID FROM DUAL");
				rs=pstmt.executeQuery();
				if(rs.next()){
					genoId = rs.getString("GENOID");
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
			}			
			
			pstmt = con.prepareStatement("SELECT NVL(MAX(SRL_NO)+1,1) SRL_NO FROM  CA_GENOGRAM_ATTRIBUTE WHERE GENO_ID=?");
			pstmt.setString(1,genoId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				srlNo = rs.getString("SRL_NO");
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();			
			
			HashMap hash = new HashMap();
			hash.put("genoId",genoId);
			hash.put("srlNo",srlNo);
			hash.put("recPatientId",recPatientId);
			hash.put("recPatientName",recPatientName);
			hash.put("gender",gender);
			hash.put("dateOfBirth",dateOfBirth);
			hash.put("deceasedYN",deceasedYN);
			hash.put("deceasedDate",deceasedDate);
			hash.put("deceasedRremarks",deceasedRremarks);
			hash.put("addedById",addedById);
			hash.put("addedAtWorkstation",addedAtWorkstation);
			hash.put("facilityId",facilityId);
			hash.put("modifiedById",modifiedById);
			hash.put("modifiedAtWorkstation",modifiedAtWorkstation);
			hash.put("relationStartDate",relationStartDate);
			hash.put("relationShipTypeValue",relationShipTypeValue);
			hash.put("relationValue",relationValue);
			hash.put("rec_sibling_position",rec_sibling_position);
			hash.put("selectNonPatID",selectNonPatID);
			hash.put("rel_rev_flag","N");
			flag = addAttributeTable(con,hash);
			if(flag){
				if(!"Y".equals(stroeFirstIndexPat)){	
					flag = addRelationTable(con,hash); 
					if(flag){
						hash.put("rel_rev_flag","Y");
						hash.put("selectNonPatID",(((String)hash.get("genoId"))+((String)hash.get("srlNo"))));
						hash.put("srlNo",selectSrlNo);
						flag = addRelationTable(con,hash);
					}
				}
			}
			if(flag){
				con.commit();
				message1 = getMessage(locale, "RECORD_INSERTED","CA");
				message2 = "1";					
				res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}else{
				con.rollback();				
				message1=getMessage(locale, "FAILED_OPERATION","CA");				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	private void addChilds(HttpServletRequest req, HttpServletResponse res, PrintWriter out){
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		boolean flag = false;
	//	int rowsCount1				= 0;//Common-ICN-0092  
		String message1 			= "";
		String message2 			= "0";
			
		try{		
			
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			
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

						 
		//	String stroeFirstIndexPat		= checkForNull(req.getParameter("stroeFirstIndexPat")); //Common-ICN-0092  
			String selectNonPatID			= checkForNull(req.getParameter("selectNonPatID"));			
			String selectSrlNo				= checkForNull(req.getParameter("selectSrlNo"));
			String selectNonPatSex			= checkForNull(req.getParameter("selectNonPatSex"));			
			String relationShipTypeValue	= checkForNull(req.getParameter("relationShipTypeValue"));	
			int noOfChilds					= Integer.parseInt((String)req.getParameter("noOfChilds_"));
			String selectNonPatID1			= checkForNull(req.getParameter("selectNonPatID1"));
			String[] selectNonPatID1_Arr 	= selectNonPatID1.split("\\|");
			String selectNonPatID1_			= selectNonPatID1_Arr[0];			
			String selectSrlNo1_			= selectNonPatID1_Arr[2];
			String selectNonPatSex1_		= selectNonPatID1_Arr[1];
		//	String rec_sibling_position	= "";//Common-ICN-0092 
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNo				= "";
			
			con = ConnectionManager.getConnection(req);
			
			HashMap hash = new HashMap();
			
			hash.put("genoId",genoId);
			
			hash.put("addedById",addedById);
			hash.put("addedAtWorkstation",addedAtWorkstation);
			hash.put("facilityId",facilityId);
			hash.put("modifiedById",modifiedById);
			hash.put("modifiedAtWorkstation",modifiedAtWorkstation);			
			for(int i=0;i<noOfChilds;i++){
				hash.put("rel_rev_flag","N");
				hash.put("relationShipTypeValue",relationShipTypeValue);
				hash.put("selectNonPatID",selectNonPatID);				
				pstmt = con.prepareStatement("SELECT NVL(MAX(SRL_NO)+1,1) SRL_NO FROM  CA_GENOGRAM_ATTRIBUTE WHERE GENO_ID=?");
				pstmt.setString(1,genoId);
				rs=pstmt.executeQuery();
				if(rs.next()){
					srlNo = rs.getString("SRL_NO");
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				hash.put("srlNo",srlNo);
				
				hash.put("recPatientId",checkForNull(req.getParameter("rec_patient_idCh"+i)));
				hash.put("recPatientName",checkForNull(req.getParameter("rec_patient_nameCh"+i)));
				hash.put("gender",checkForNull(req.getParameter("gender_hiddenCh"+i)));
				hash.put("dateOfBirth",checkForNull(req.getParameter("date_of_birthCh"+i)));
				hash.put("rec_sibling_position",checkForNull(req.getParameter("rec_sibling_positionCh"+i)));
				String deceasedYN			= "N";
				if(!"".equals(checkForNull(req.getParameter("deceasedDateCh"+i)))) deceasedYN="Y";
				hash.put("deceasedYN",deceasedYN);
				hash.put("deceasedDate",checkForNull(req.getParameter("deceasedDateCh"+i)));				
				hash.put("deceasedRremarks",checkForNull(req.getParameter("deceased_remarksCh"+i)));
				hash.put("relationStartDate","");
				hash.put("relationValue",checkForNull(req.getParameter("relationValueCh"+i)));
				
				flag = addAttributeTable(con,hash);
				if(flag){					
					flag = addRelationTable(con,hash); 
					if(flag){
						hash.put("rel_rev_flag","Y");
						hash.put("selectNonPatID",selectNonPatID1_);
						flag = addRelationTable(con,hash);
					}					
					if(flag){
						hash.put("srlNo",selectSrlNo);
						hash.put("rel_rev_flag","Y");
						hash.put("relationShipTypeValue","PAR");
						if("M".equals(selectNonPatSex)){
							hash.put("relationValue","FA");						
						}else if("F".equals(selectNonPatSex)){
							hash.put("relationValue","MO");
						}
						hash.put("selectNonPatID",genoId+srlNo);
						flag = addRelationTable(con,hash);
					}
					if(flag){
						hash.put("srlNo",selectSrlNo1_);
						hash.put("rel_rev_flag","Y");
						hash.put("relationShipTypeValue","PAR");
						if("M".equals(selectNonPatSex1_)){
							hash.put("relationValue","FA");						
						}else if("F".equals(selectNonPatSex1_)){
							hash.put("relationValue","MO");
						}						
						hash.put("selectNonPatID",genoId+srlNo);
						flag = addRelationTable(con,hash);
					}
					
				}
			}
			if(flag){
				con.commit();
				message1 = getMessage(locale, "RECORD_INSERTED","CA");
				message2 = "1";					
				res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}else{
				con.rollback();				
				message1=getMessage(locale, "FAILED_OPERATION","CA");				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	private void addParents(HttpServletRequest req, HttpServletResponse res, PrintWriter out){
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		boolean flag = false;
	//	int rowsCount1				= 0;//Common-ICN-0092  
		String message1 			= "";
		String message2 			= "0";
			
		try{		
			
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			
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
		

			String selectNonPatID		= checkForNull(req.getParameter("selectNonPatID"));			 
		//	String stroeFirstIndexPat	= checkForNull(req.getParameter("stroeFirstIndexPat"));//Common-ICN-0092  
			String selectSrlNo				= checkForNull(req.getParameter("selectSrlNo"));
			String selectNonPatSex			= checkForNull(req.getParameter("selectNonPatSex"));			
			String rec_sibling_position	= "";
			
			String relationShipTypeValue= checkForNull(req.getParameter("relationShipTypeValue"));
			//Father Details
						
				String relationValueFa		= checkForNull(req.getParameter("relationValueFa"));
				String relationStartDateFa	= "";
				String rec_patient_idFa			= checkForNull(req.getParameter("rec_patient_idFa"));			
				String rec_patient_nameFa		= checkForNull(req.getParameter("rec_patient_nameFa"));
				String date_of_birthFa			= checkForNull(req.getParameter("date_of_birthFa"));
				String genderFa				= checkForNull(req.getParameter("genderFa"));
				String deceasedDateFa			= checkForNull(req.getParameter("deceasedDateFa"));
				String deceasedYNFa			= "N";
				if(!"".equals(deceasedDateFa)) deceasedYNFa="Y";
				String decease_remarksFa		= checkForNull(req.getParameter("deceased_remarksFa"));
			//Mother Details
				String relationValueMo		= checkForNull(req.getParameter("relationValueMo"));
			//	String relationStartDateMo	= "";//Common-ICN-0092  
				String rec_patient_idMo			= checkForNull(req.getParameter("rec_patient_idMo"));			
				String rec_patient_nameMo		= checkForNull(req.getParameter("rec_patient_nameMo"));
				String date_of_birthMo			= checkForNull(req.getParameter("date_of_birthMo"));
				String genderMo					= checkForNull(req.getParameter("genderMo"));
				String deceasedDateMo			= checkForNull(req.getParameter("deceasedDateMo"));
				String deceasedYNMo			= "N";
				if(!"".equals(deceasedDateMo)) deceasedYNMo="Y";
				String decease_remarksMo		= checkForNull(req.getParameter("deceased_remarksMo"));
			
			//Father and Mother Relation
				String relationValueFaMo		= checkForNull(req.getParameter("relationValueFaMo"));
				String relationStartDateFaMo	= checkForNull(req.getParameter("relationStartDateFaMo"));
	//		String mode					= checkForNull(req.getParameter("mode"));//Common-ICN-0092  
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNoFa				= "";
			String srlNoMo				= "";
			
			con = ConnectionManager.getConnection(req);
			
			pstmt = con.prepareStatement("SELECT NVL(MAX(SRL_NO)+1,1) SRL_NO FROM  CA_GENOGRAM_ATTRIBUTE WHERE GENO_ID=?");
			pstmt.setString(1,genoId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				srlNoFa = rs.getString("SRL_NO");
			}
			srlNoMo = (String.valueOf(Integer.parseInt(srlNoFa)+1));
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
			
			
			HashMap hash = new HashMap();
			//Add Father Details
				hash.put("genoId",genoId);
				hash.put("srlNo",srlNoFa);
				hash.put("recPatientId",rec_patient_idFa);
				hash.put("recPatientName",rec_patient_nameFa);
				hash.put("gender",genderFa);
				hash.put("dateOfBirth",date_of_birthFa);
				hash.put("deceasedYN",deceasedYNFa);
				hash.put("deceasedDate",deceasedDateFa);
				hash.put("deceasedRremarks",decease_remarksFa);
				hash.put("addedById",addedById);
				hash.put("addedAtWorkstation",addedAtWorkstation);
				hash.put("facilityId",facilityId);
				hash.put("modifiedById",modifiedById);
				hash.put("modifiedAtWorkstation",modifiedAtWorkstation);
				hash.put("relationStartDate",relationStartDateFa);
				hash.put("relationShipTypeValue",relationShipTypeValue);
				hash.put("relationValue",relationValueFa);
				hash.put("rec_sibling_position",rec_sibling_position);
				hash.put("selectNonPatID",selectNonPatID);
				hash.put("rel_rev_flag","N");
				
				flag = addAttributeTable(con,hash);
				if(flag){						
					flag = addRelationTable(con,hash);	
					if(flag){
						hash.put("srlNo",selectSrlNo);
						hash.put("relationShipTypeValue","CHILD");
						if("M".equals(selectNonPatSex)){
							hash.put("relationValue","SO");						
						}else if("F".equals(selectNonPatSex)){
							hash.put("relationValue","DA");
						}
						hash.put("selectNonPatID",genoId+srlNoFa);
						hash.put("rel_rev_flag","Y");
						flag = addRelationTable(con,hash);	
					}
					
				}
			//Add Mother Details
				if(flag){
					hash.put("srlNo",srlNoMo);
					hash.put("recPatientId",rec_patient_idMo);
					hash.put("recPatientName",rec_patient_nameMo);
					hash.put("gender",genderMo);
					hash.put("dateOfBirth",date_of_birthMo);
					hash.put("deceasedYN",deceasedYNMo);
					hash.put("deceasedDate",deceasedDateMo);
					hash.put("deceasedRremarks",decease_remarksMo);
					hash.put("relationValue",relationValueMo);					
					hash.put("relationShipTypeValue",relationShipTypeValue);
					hash.put("selectNonPatID",selectNonPatID);
					hash.put("rel_rev_flag","N");
					flag = addAttributeTable(con,hash);
					if(flag){							
						flag = addRelationTable(con,hash);	
						if(flag){
							hash.put("srlNo",selectSrlNo);
							hash.put("relationShipTypeValue","CHILD");
							if("M".equals(selectNonPatSex)){
								hash.put("relationValue","SO");						
							}else if("F".equals(selectNonPatSex)){
								hash.put("relationValue","DA");
							}
							hash.put("selectNonPatID",genoId+srlNoMo);
							hash.put("rel_rev_flag","Y");
							flag = addRelationTable(con,hash);	
						}
					}			
				}
			//Add Father and Mother Relations
				if(flag){
					hash.put("srlNo",srlNoMo);
					hash.put("relationShipTypeValue","COUPLE");
					hash.put("relationValue",relationValueFaMo);
					hash.put("relationStartDate",relationStartDateFaMo);
					hash.put("selectNonPatID",genoId+srlNoFa);
					flag = addRelationTable(con,hash);
					if(flag){
						hash.put("srlNo",srlNoFa);
						hash.put("relationShipTypeValue","COUPLE");
						hash.put("relationValue",relationValueFaMo);
						hash.put("relationStartDate",relationStartDateFaMo);
						hash.put("selectNonPatID",genoId+srlNoMo);
						flag = addRelationTable(con,hash);
					}
				}			
			if(flag){
				con.commit();
				message1 = getMessage(locale, "RECORD_INSERTED","CA");
				message2 = "1";					
				res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}else{
				con.rollback();				
				message1=getMessage(locale, "FAILED_OPERATION","CA");				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	private boolean addAttributeTable(Connection con,HashMap hash){
		boolean flag =false;
		int rowsCount =0;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		try{
			pstmt = con.prepareStatement("INSERT INTO CA_GENOGRAM_ATTRIBUTE (GENO_ID,SRL_NO,PATIENT_ID,NON_PATIENT_ID,NAME,SEX,DATE_OF_BIRTH,DECEASED_YN,DECEASED_DATE,DECEASED_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,(String)hash.get("genoId"));
			pstmt.setString(2,(String)hash.get("srlNo"));
			pstmt.setString(3,(String)hash.get("recPatientId"));
			pstmt.setString(4,(String)hash.get("genoId")+(String)hash.get("srlNo"));
			pstmt.setString(5,(String)hash.get("recPatientName"));
			pstmt.setString(6,(String)hash.get("gender"));
			
			pstmt.setDate(7,java.sql.Date.valueOf(df.format(df1.parse((String)hash.get("dateOfBirth")))));
			pstmt.setString(8,(String)hash.get("deceasedYN"));
			if("Y".equals((String)hash.get("deceasedYN"))){
				pstmt.setDate(9,java.sql.Date.valueOf(df.format(df1.parse((String)hash.get("deceasedDate")))));
			}else{
				pstmt.setString(9,(String)hash.get("deceasedDate"));
			}
			pstmt.setString(10,(String)hash.get("deceasedRremarks"));
			pstmt.setString(11, (String)hash.get("addedById"));
			pstmt.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(13, (String)hash.get("addedAtWorkstation"));
			pstmt.setString(14, (String)hash.get("facilityId"));
			pstmt.setString(15, (String)hash.get("modifiedById"));
			pstmt.setTimestamp(16, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(17, (String)hash.get("modifiedAtWorkstation"));
			pstmt.setString(18, (String)hash.get("facilityId"));
			rowsCount=pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			
			if(rowsCount>0)
				flag = true;
		}catch(Exception eat){
			eat.printStackTrace();
		}
		return flag;
	}
	private boolean addRelationTable(Connection con,HashMap hash){
		boolean flag =false;
		int rowsCount =0;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		String lineSrlNo				= "";
		try{
			pstmt = con.prepareStatement("SELECT NVL(MAX(LINE_SRL_NO)+1,1) LINE_SRL_NO FROM  CA_GENOGRAM_RELATION WHERE GENO_ID=? AND SRL_NO=?");
					pstmt.setString(1,(String)hash.get("genoId"));
					pstmt.setString(2,(String)hash.get("srlNo"));
					rs=pstmt.executeQuery();
					if(rs.next()){
						lineSrlNo = rs.getString("LINE_SRL_NO");
					}
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
					
					pstmt = con.prepareStatement("INSERT INTO CA_GENOGRAM_RELATION (GENO_ID,SRL_NO,LINE_SRL_NO,RELATION_TYPE_ID,RELATION_ID,FROM_GENOID,TO_GENOID,REL_START_DATE,SIBLNG_POS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,REL_REV_FLAG) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1,(String)hash.get("genoId"));
					pstmt.setString(2,(String)hash.get("srlNo"));
					pstmt.setString(3,lineSrlNo);
					pstmt.setString(4,(String)hash.get("relationShipTypeValue"));
					pstmt.setString(5,(String)hash.get("relationValue"));
					pstmt.setString(6,(String)hash.get("selectNonPatID"));
					pstmt.setString(7,(String)hash.get("genoId")+(String)hash.get("srlNo"));
					if(!"".equals((String)hash.get("relationStartDate"))){
						pstmt.setDate(8,java.sql.Date.valueOf(df.format(df1.parse((String)hash.get("relationStartDate")))));
					}else{
						pstmt.setString(8,(String)hash.get("relationStartDate"));
					}
					pstmt.setString(9, (String)hash.get("rec_sibling_position"));
					pstmt.setString(10, (String)hash.get("addedById"));
					pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
					pstmt.setString(12, (String)hash.get("addedAtWorkstation"));
					pstmt.setString(13, (String)hash.get("facilityId"));
					pstmt.setString(14, (String)hash.get("modifiedById"));
					pstmt.setTimestamp(15, new Timestamp(System.currentTimeMillis()));
					pstmt.setString(16, (String)hash.get("modifiedAtWorkstation"));
					pstmt.setString(17, (String)hash.get("facilityId"));
					pstmt.setString(18, (String)hash.get("rel_rev_flag"));
					rowsCount=pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();	
			
			if(rowsCount>0)
				flag = true;
		}catch(Exception eat){
			eat.printStackTrace();
		}
		return flag;
	}
	
	private void modifyFamilyMember(HttpServletRequest req, HttpServletResponse res, PrintWriter out){			
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		int rowsCount				= 0;
		boolean flag				= false;
		String message1 			= "";
		String message2 			= "0";
			
		try{		
			
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
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
		
			
			String selectNonPatID		= checkForNull(req.getParameter("selectNonPatID")); 
			String selectSrlNo			= checkForNull(req.getParameter("selectSrlNo"));
			String genoId				= checkForNull(req.getParameter("genoId"));
			
			String recPatientId			= checkForNull(req.getParameter("rec_patient_idModify"));
			String recPatientName		= checkForNull(req.getParameter("rec_patient_nameModify"));
			String dateOfBirth			= checkForNull(req.getParameter("date_of_birthModify"));
			String gender				= checkForNull(req.getParameter("gender_hiddenModify"));
			String deceasedDate			= checkForNull(req.getParameter("deceasedDateModify"));
			
			int relModifyCount		= Integer.parseInt(req.getParameter("relModifyCount")==null?"0":(String)req.getParameter("relModifyCount"));
			
			
			String deceasedYN			= "N";
			if(!"".equals(deceasedDate)) deceasedYN="Y";
			String deceasedRremarks		= checkForNull(req.getParameter("deceased_remarksModify"));			
			
			con = ConnectionManager.getConnection(req);
			
			
			pstmt = con.prepareStatement("UPDATE CA_GENOGRAM_ATTRIBUTE SET PATIENT_ID=?, NAME=?, SEX=?, DATE_OF_BIRTH=?, DECEASED_YN=?, DECEASED_DATE=?, DECEASED_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE GENO_ID=? AND SRL_NO=?  AND NON_PATIENT_ID=?");
			
			pstmt.setString(1,recPatientId);
			pstmt.setString(2,recPatientName);
			pstmt.setString(3,gender);
			DateFormat df	= new SimpleDateFormat( "yyyy-MM-dd" );
			DateFormat df1	= new SimpleDateFormat( "dd/MM/yyyy" );
			pstmt.setDate(4,java.sql.Date.valueOf(df.format(df1.parse(dateOfBirth))));
			pstmt.setString(5,deceasedYN);
			if("Y".equals(deceasedYN)){
				pstmt.setDate(6,java.sql.Date.valueOf(df.format(df1.parse(deceasedDate))));
			}else{
				pstmt.setString(6,deceasedDate);
			}
			pstmt.setString(7,deceasedRremarks);
			
			pstmt.setString(8, modifiedById);
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(10, modifiedAtWorkstation);
			pstmt.setString(11, facilityId);
			pstmt.setString(12,genoId);
			pstmt.setString(13,selectSrlNo);			
			pstmt.setString(14,selectNonPatID);
			rowsCount=pstmt.executeUpdate();
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
			
			HashMap hash = new HashMap();
			//Add Father Details
				hash.put("genoId",genoId);
				hash.put("relationShipTypeValue","COUPLE");
				hash.put("rec_sibling_position","");
				hash.put("addedById",addedById);
				hash.put("addedAtWorkstation",addedAtWorkstation);
				hash.put("facilityId",facilityId);
				hash.put("modifiedById",modifiedById);
				hash.put("modifiedAtWorkstation",modifiedAtWorkstation);
				
			if(rowsCount>0){
				if(relModifyCount>0){   //IN043653
					for(int i=0;i<relModifyCount;i++){
						
						String relationValueModify 	= checkForNull(req.getParameter("relationValueModify"+(i+1)));
						String rel_toGenoIdModify  	= checkForNull(req.getParameter("rel_toGenoIdModify"+(i+1)));
						String rel_srlNoModify 		= checkForNull(req.getParameter("rel_srlNoModify"+(i+1)));
						String rel_dateModify		= checkForNull(req.getParameter("rel_dateModify"+(i+1)));
						pstmt = con.prepareStatement("DELETE FROM CA_GENOGRAM_RELATION WHERE FROM_GENOID=? AND TO_GENOID=?");
						pstmt.setString(1,selectNonPatID);
						pstmt.setString(2,rel_toGenoIdModify);
						rowsCount = pstmt.executeUpdate();
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						
				
						hash.put("srlNo",rel_srlNoModify);					
						hash.put("relationValue",relationValueModify);					
						hash.put("selectNonPatID",selectNonPatID);
						hash.put("relationStartDate",rel_dateModify);
						hash.put("rel_rev_flag","N");
						
						flag = addRelationTable(con,hash);
						if(rowsCount>0 && flag){
							pstmt = con.prepareStatement("DELETE FROM CA_GENOGRAM_RELATION WHERE FROM_GENOID=? AND TO_GENOID=?");					
							pstmt.setString(1,rel_toGenoIdModify);
							pstmt.setString(2,selectNonPatID);
							rowsCount= pstmt.executeUpdate();
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
						
					
							hash.put("srlNo",selectSrlNo);					
							hash.put("relationValue",relationValueModify);					
							hash.put("selectNonPatID",rel_toGenoIdModify);
							hash.put("rel_rev_flag","Y");
							
							flag = addRelationTable(con,hash);
						}
						
					
					}
				//IN043653
				}else{
					flag=true;
				}
				// End.
			}
			
			if(rowsCount>0 && flag){
				con.commit();
				message1 = getMessage(locale, "RECORD_INSERTED","CA");
				message2 = "1";					
				res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}else{
				con.rollback();				
				message1=getMessage(locale, "FAILED_OPERATION","CA");				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	private void addEmotionalRelation(HttpServletRequest req, HttpServletResponse res, PrintWriter out){			
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		int rowsCount				= 0;
		String message1 			= "";
		String message2 			= "0";
			
		try{		
			
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			
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
			
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNo				= checkForNull(req.getParameter("srlNo"));	
			String lineSrlNo			= "";
			String fromPatNonID			= checkForNull(req.getParameter("fromRelationId"));
			String toPatNonID			= checkForNull(req.getParameter("toRelationId"));
			String relationTypeId 		= checkForNull(req.getParameter("emoRelationTypeId"));
			String relationId			= checkForNull(req.getParameter("emoRelationId"));
			String relationRemarks		= checkForNull(req.getParameter("relationRemarks"));  
		//	String mode					= checkForNull(req.getParameter("mode"));	//Common-ICN-0092  
			
			con = ConnectionManager.getConnection(req);
			
			pstmt = con.prepareStatement("SELECT * FROM  CA_GENOGRAM_RELATION WHERE FROM_GENOID=? AND TO_GENOID=? AND RELATION_TYPE_ID=? AND RELATION_ID=?");
			pstmt.setString(1,fromPatNonID);
			pstmt.setString(2,toPatNonID);
			pstmt.setString(3,relationTypeId);
			pstmt.setString(4,relationId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				message1="Relationship already exist. ";				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}else{
				pstmt = con.prepareStatement("SELECT NVL(MAX(LINE_SRL_NO)+1,1) LINE_SRL_NO FROM  CA_GENOGRAM_RELATION WHERE GENO_ID=? AND SRL_NO=?");
				pstmt.setString(1,genoId);
				pstmt.setString(2,srlNo);
				rs=pstmt.executeQuery();
				if(rs.next()){
					lineSrlNo = rs.getString("LINE_SRL_NO");
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				
				pstmt = con.prepareStatement("INSERT INTO CA_GENOGRAM_RELATION (GENO_ID,SRL_NO,LINE_SRL_NO,RELATION_TYPE_ID,RELATION_ID,FROM_GENOID,TO_GENOID,RELATION_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1,genoId);
				pstmt.setString(2,srlNo);
				pstmt.setString(3,lineSrlNo);
				pstmt.setString(4,relationTypeId);
				pstmt.setString(5,relationId);
				pstmt.setString(6,fromPatNonID);
				pstmt.setString(7,toPatNonID);
				pstmt.setString(8,relationRemarks);
				pstmt.setString(9, addedById);
				pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(11, addedAtWorkstation);
				pstmt.setString(12, facilityId);
				pstmt.setString(13, modifiedById);
				pstmt.setTimestamp(14, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(15, modifiedAtWorkstation);
				pstmt.setString(16, facilityId);
				rowsCount=pstmt.executeUpdate();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				
				if(rowsCount>0){
					con.commit();
					message1 = getMessage(locale, "RECORD_INSERTED","CA");
					message2 = "1";					
					res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2 + "&direction_loc=EMOTIONAL&direction_value=" + genoId+"|"+srlNo+"|"+fromPatNonID+"|"+toPatNonID);
				}else{
					con.rollback();				
					message1=getMessage(locale, "FAILED_OPERATION","CA");				
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	private void removeEmotionalRelation(HttpServletRequest req, HttpServletResponse res, PrintWriter out){			
		Connection con				= null;
		PreparedStatement pstmt		= null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
	//	int rowsCount				= 0;//Common-ICN-0092  
		String message1 			= "";
		String message2 			= "0";
			
		try{
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNo				= checkForNull(req.getParameter("srlNo"));	
			
			String fromPatNonID			= checkForNull(req.getParameter("fromRelationId"));
			String toPatNonID			= checkForNull(req.getParameter("toRelationId"));			
			String removeRelations			= checkForNull(req.getParameter("removeRelations"));
			
	//		String mode					= checkForNull(req.getParameter("mode"));	//Common-ICN-0092  		
			
			con = ConnectionManager.getConnection(req);
						
			String[] relationId = removeRelations.split("\\|");
			int sussRecCount=0;
			for(int i=0;i<relationId.length;i++){
				pstmt = con.prepareStatement("DELETE  FROM CA_GENOGRAM_RELATION WHERE FROM_GENOID=? AND TO_GENOID=? AND RELATION_ID=? AND SRL_NO=?");
				pstmt.setString(1,fromPatNonID);
				pstmt.setString(2,toPatNonID);
				pstmt.setString(3,relationId[i]);
				pstmt.setString(4,srlNo);
				pstmt.executeUpdate();
				
				if(pstmt!=null)pstmt.close();
				sussRecCount++;
			}
			if((relationId.length)==sussRecCount){
				con.commit();
				message1 = getMessage(locale, "RECORD_INSERTED","CA");
				message2 = "1";					
				res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2 + "&direction_loc=EMOTIONAL&direction_value=" + genoId+"|"+srlNo+"|"+fromPatNonID+"|"+toPatNonID);
			}else{
				con.rollback();				
				message1=getMessage(locale, "FAILED_OPERATION","CA");				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}
			
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{				
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	private void addMedHistory(HttpServletRequest req,HttpServletResponse res, PrintWriter out) {
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		ResultSet rs = null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
		int rowsCount				= 0;
		String message1 			= "";
		String message2 			= "0";
			
		try{		
			
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			
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
			
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNo				= checkForNull(req.getParameter("srlNo"));	
			String lineSrlNo			= "";
			String fromPatNonID			= checkForNull(req.getParameter("fromRelationId"));
			String relationId 		= checkForNull(req.getParameter("emoRelationTypeId"));
			String relationTypeId			= checkForNull(req.getParameter("mhRelationId"));
			String relationRemarks		= checkForNull(req.getParameter("relationRemarks"));  
		//    String mode					= checkForNull(req.getParameter("mode"));//Common-ICN-0092  
			
			con = ConnectionManager.getConnection(req);
						
			
			pstmt = con.prepareStatement("SELECT * FROM  CA_GENOGRAM_RELATION WHERE FROM_GENOID=? AND RELATION_TYPE_ID=? AND RELATION_ID=?");
			pstmt.setString(1,fromPatNonID);
			pstmt.setString(2,relationTypeId);
			pstmt.setString(3,relationId);
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				message1="Relationship already exist. ";				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}else{
				pstmt = con.prepareStatement("SELECT NVL(MAX(LINE_SRL_NO)+1,1) LINE_SRL_NO FROM  CA_GENOGRAM_RELATION WHERE GENO_ID=? AND SRL_NO=?");
				pstmt.setString(1,genoId);
				pstmt.setString(2,srlNo);
				rs=pstmt.executeQuery();
				if(rs.next()){
					lineSrlNo = rs.getString("LINE_SRL_NO");
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				
			
				pstmt = con.prepareStatement("INSERT INTO CA_GENOGRAM_RELATION (GENO_ID,SRL_NO,LINE_SRL_NO,RELATION_ID,RELATION_TYPE_ID,FROM_GENOID,RELATION_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1,genoId);
				pstmt.setString(2,srlNo);
				pstmt.setString(3,lineSrlNo);
				pstmt.setString(4,relationId);
				pstmt.setString(5,relationTypeId);		
				pstmt.setString(6,fromPatNonID);
				pstmt.setString(7,relationRemarks);
				pstmt.setString(8, addedById);
				pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(10, addedAtWorkstation);
				pstmt.setString(11, facilityId);
				pstmt.setString(12, modifiedById);
				pstmt.setTimestamp(13, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(14, modifiedAtWorkstation);
				pstmt.setString(15, facilityId);
				
				rowsCount=pstmt.executeUpdate();
				
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				
				if(rowsCount>0){
					con.commit();
					message1 = getMessage(locale, "RECORD_INSERTED","CA");
					message2 = "1";					
					res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2 + "&direction_loc=MEDHISTORY&direction_value=" + genoId+"|"+srlNo+"|"+fromPatNonID);
				}else{
					con.rollback();				
					message1=getMessage(locale, "FAILED_OPERATION","CA");				
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	
		
	}
	private void removeMedHistory(HttpServletRequest req,HttpServletResponse res, PrintWriter out) {
		System.out.println(" I am In removeMedHistory method in CAGenogramServlet");
			
		Connection con				= null;
		PreparedStatement pstmt		= null;
		
		Properties p;
		HttpSession session;
        session = req.getSession(false);
	//	int rowsCount				= 0;//Common-ICN-0092  
		String message1 			= "";
		String message2 			= "0";
			
		try{
			p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale 					= (String) p.getProperty("LOCALE");
			
			String genoId				= checkForNull(req.getParameter("genoId"));
			String srlNo				= checkForNull(req.getParameter("srlNo"));	
			
			String fromPatNonID			= checkForNull(req.getParameter("fromRelationId"));
			String removeRelations			= checkForNull(req.getParameter("removeRelations"));
			
		//	String mode					= checkForNull(req.getParameter("mode"));//Common-ICN-0092  
			
			
			con = ConnectionManager.getConnection(req);
						
			String[] relationId = removeRelations.split("\\|");
			int sussRecCount=0;
			for(int i=0;i<relationId.length;i++){
				pstmt = con.prepareStatement("DELETE  FROM CA_GENOGRAM_RELATION WHERE FROM_GENOID=? AND RELATION_ID=? AND SRL_NO=?");
				pstmt.setString(1,fromPatNonID);
				pstmt.setString(2,relationId[i]);
				pstmt.setString(3,srlNo);
				pstmt.executeUpdate();  //IN043631
				
				if(pstmt!=null)pstmt.close();
				sussRecCount++;
			}
			if((relationId.length)==sussRecCount){
				con.commit();
				message1 = getMessage(locale, "RECORD_INSERTED","CA");
				message2 = "1";					
				res.sendRedirect("../eCA/jsp/CAGenogramError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2 + "&direction_loc=MEDHISTORY&direction_value=" + genoId+"|"+srlNo+"|"+fromPatNonID);
			}else{
				con.rollback();				
				message1=getMessage(locale, "FAILED_OPERATION","CA");				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}
			
		}catch(Exception e){
			System.err.println("CAGenogramServlet Error :"+e.getMessage());
			try{
				con.rollback();
				message1="Error Received : "+ e.toString();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            
		}finally{
			try{				
				if (pstmt!= null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
