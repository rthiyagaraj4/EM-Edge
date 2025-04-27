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
15/04/2021	15950			Nijitha S		Common-ICN-0030 
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

public class CAGenogramBean implements java.io.Serializable
{
	private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
	
	public CAGenogramBean() {}
	
	public void insertPatDtls(HttpServletRequest request) throws Exception
    { System.out.println("I am insertPatDtls method in CAGenogramBean.java...");
		int recCount 				= 0;
		int rowsCount				= 0;
		String query="";
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		System.out.println("patient_id=============================>"+patient_id);
		Properties p;
		HttpSession session;
        session = request.getSession(false);
		try{
			con = ConnectionManager.getConnection(request);
			query="SELECT COUNT(*) COUNT FROM CA_GENOGRAM_ATTRIBUTE WHERE PATIENT_ID=?";
			pstmt			=	con.prepareStatement(query); 
			pstmt.setString(1,patient_id); 
			rs=pstmt.executeQuery();
			System.out.println("Before==============recCount===============>"+recCount);
			if(rs.next()){
				recCount = Integer.parseInt((String)rs.getString("COUNT"));
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			
			System.out.println("After===============recCount==============>"+recCount);
			if(recCount==0){
				p 					= (java.util.Properties) session.getValue( "jdbc" ) ;
				//String locale 					= (String) p.getProperty("LOCALE");//15950
				
				String addedById			= "";
				String modifiedById			= "";
				String addedAtWorkstation	= "";
				String modifiedAtWorkstation= "";
				

				String facilityId = (String)session.getValue("facility_id");
				String client_ip_address = p.getProperty("client_ip_address");
				
				addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
				addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
				modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
				modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
				
				String genoId 			= "";
				String srlNo 			= "";
				String recPatientName	= "";
				String gender			= "";
				String dateOfBirth		= "";
				String deceasedYN		= "";
				String deceasedDate		= "";
				String deceasedRremarks = "";
				
				pstmt = con.prepareStatement("SELECT GENO_ID.NEXTVAL GENOID FROM DUAL");
				rs=pstmt.executeQuery();
				if(rs.next()){
					genoId = rs.getString("GENOID");
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				
				pstmt = con.prepareStatement("SELECT NVL(MAX(SRL_NO)+1,1) SRL_NO FROM  CA_GENOGRAM_ATTRIBUTE WHERE GENO_ID=?");
				pstmt.setString(1,genoId);
				rs=pstmt.executeQuery();
				if(rs.next()){
					srlNo = rs.getString("SRL_NO");
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				
				pstmt			=	con.prepareStatement("SELECT PATIENT_NAME,SEX,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,DECEASED_YN,DECEASED_DATE,DEATH_STATUS_REMARKS FROM MP_PAT_DTLS_VW WHERE PATIENT_ID=?");
				pstmt.setString(1,patient_id);
				rs=pstmt.executeQuery();
				if(rs.next()){
					recPatientName	=	rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME");
					gender			=	rs.getString("SEX")==null?"":(String)rs.getString("SEX");
					dateOfBirth		=	rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH");
					deceasedYN		=	rs.getString("DECEASED_YN")==null?"":(String)rs.getString("DECEASED_YN");
					deceasedDate	=	rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE");
					deceasedRremarks=	rs.getString("DEATH_STATUS_REMARKS")==null?"":(String)rs.getString("DEATH_STATUS_REMARKS");
				}
				System.out.println("CAGenogramBean.java-----------genoId--------->"+genoId);
				System.out.println("CAGenogramBean.java-----------srlNo--------->"+srlNo);
				System.out.println("CAGenogramBean.java-----------recPatientName--------->"+recPatientName);
				System.out.println("CAGenogramBean.java-----------gender--------->"+gender);
				System.out.println("CAGenogramBean.java-----------dateOfBirth--------->"+dateOfBirth);
				System.out.println("CAGenogramBean.java-----------deceasedYN--------->"+deceasedYN);
				System.out.println("CAGenogramBean.java-----------deceasedDate--------->"+deceasedDate);
				System.out.println("CAGenogramBean.java-----------deceasedRremarks--------->"+deceasedRremarks);
				if(rs!=null)rs.close();//15950
				if(pstmt!=null)pstmt.close();//15950
				
				pstmt = con.prepareStatement("INSERT INTO CA_GENOGRAM_ATTRIBUTE (GENO_ID,SRL_NO,PATIENT_ID,NON_PATIENT_ID,NAME,SEX,DATE_OF_BIRTH,DECEASED_YN,DECEASED_DATE,DECEASED_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1,genoId);
				pstmt.setString(2,srlNo);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,genoId+srlNo);
				pstmt.setString(5,recPatientName);
				pstmt.setString(6,gender);
				DateFormat df	= new SimpleDateFormat( "yyyy-MM-dd" );
				DateFormat df1	= new SimpleDateFormat( "dd/MM/yyyy" );
				System.out.println("CAGenogramBean.java------------->1");
				pstmt.setDate(7,java.sql.Date.valueOf(df.format(df1.parse(dateOfBirth))));
				System.out.println("CAGenogramBean.java------------->2");
				pstmt.setString(8,deceasedYN);
				System.out.println("CAGenogramBean.java------------->2");
				if("Y".equals(deceasedYN)){
					System.out.println("CAGenogramBean.java------------->3");
					pstmt.setDate(9,java.sql.Date.valueOf(df.format(df1.parse(deceasedDate))));
				}else{
					System.out.println("CAGenogramBean.java------------->5");
					pstmt.setString(9,deceasedDate);
				}
				System.out.println("CAGenogramBean.java------------->6");
				pstmt.setString(10,deceasedRremarks);
				pstmt.setString(11, addedById);
				pstmt.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(13, addedAtWorkstation);
				pstmt.setString(14, facilityId);
				pstmt.setString(15, modifiedById);
				pstmt.setTimestamp(16, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(17, modifiedAtWorkstation);
				pstmt.setString(18, facilityId);
				System.out.println("CAGenogramBean.java==============Before===========rowsCount============>"+rowsCount);
				rowsCount = pstmt.executeUpdate();
				System.out.println("CAGenogramBean.java==============After===========rowsCount============>"+rowsCount);
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				if(rowsCount>0){
					con.commit();
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}											

	}

	private String checkForNull(String strParam){
			String str ="";
			if(strParam!=null && strParam.length() >0)
			str = strParam;
			return str;
	}
}
