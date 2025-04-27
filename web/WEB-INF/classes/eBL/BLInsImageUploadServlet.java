/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties. 
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
 */
package eBL;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.http.HttpUtils.*;
import webbeans.eCommon.*;

import org.apache.commons.fileupload.*;
import javax.servlet.ServletContext;
import java.net.*;
import com.ehis.persist.*;
import javax.servlet.http.HttpSession;

public class BLInsImageUploadServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	public	HttpSession session;

	int temp;
	String facilityId ;
	//HttpSession session;
	boolean isMultipart				= false;
	
	DiskFileUpload upload			= null;
	long	docSize1					= 0;
	String	docName1					= "";
	String	docType1					= "";
	FileItem Item					= null;
	String	bl_success_msg				= "";
	List items						= null;
	Iterator iter					= null;
	String patient_id=null;
	String payrGrpCode;
	String payrCode;
	String plcyCode;
	String plcyNo;
	String plcystartDate;
	String plcyExpryDate;
	String index="";//GHL-CRF-0550.1
	String bean_id		= "bl_blinsuranceimagebean" ;
	String bean_name	= "eBL.BLInsuranceImageBean";
	String strCancelChk;
	String strPatientId;
	String strDbLoad;
	//Added for GHL-CRF-0550 -- STARTS 
	String docType; 
	String docRemarks;
	String creditAuthDate;
	String creditAuthNo;
	String uindex;
	String mode;
	String clicked_button;
	String current_patient=null;
	int start_index1;
	int lastinc;
	int lastnum;
	String   lastFourDigits;
	String InsImage;
	boolean	siteSpecUploadDocAll=false;
	HttpServletRequest req;
	String pid;
	static String rpid;
	boolean flag=true;
	String blngGrpCode;
	String strbilling_grp_Name;	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String smtind="";
	String strModuleId="";
	//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	int episodeId;
	int visitId;
	int encounterId;
	//GHL-CRF-0550.1
	int checkrow;
	HashMap<String,String> InsuranceIndex =new HashMap<String,String>();
	String rowID="";
	String totalRecords="";
	//GHL-CRF-0550.1
	String episodeType = null;
	//Ended by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	//Added for GHL-CRF-0550 -- END
	public void init(ServletConfig config) throws ServletException
	{	
		super.init(config);
	} 

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		pid=req.getParameter(patient_id);
		java.io.PrintWriter out =  res.getWriter();
		try{			
			conn=ConnectionManager.getConnection();
			siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
			if(siteSpecUploadDocAll)
			{
				//Added for GHL-CRF-0550 PALANI NARAYANAN -- START 

				//String  val=req.getParameter("clicked_button"); //commented V210416

				String outValue="";
				uindex=(String)session.getAttribute("uindex");
				//GHL-CRF-0550.1
				rowID=(String)session.getAttribute("policy_no");
				totalRecords=(String)session.getAttribute("totalRecords");
				//GHL-CRF-0550.1
				strbilling_grp_Name=(String)session.getAttribute("strbilling_grp_Name");

				// strModuleId1 =req.getParameter("strModuleId");
				// System.out.println("strModuleId++++q"+strModuleId1);
				strModuleId=(String)session.getAttribute("strModuleId");		 

				try
				{
					if(uindex!=null)			
					lastFourDigits = uindex.substring(uindex.length() - 4);

					if(lastFourDigits.equals("1110"))
					{
						lastnum=0;
					}
					else
					{
						char lastchar=uindex.charAt(uindex.length()-1);
						lastnum =Character.getNumericValue(lastchar);
					}
				}	
				catch(Exception e)
				{
					e.printStackTrace();
				}
				outValue = uploadBean(req,res);		
			}				
			else
			{
				String outValue = uploadBean(req,res);		
				System.err.println("BLInsurance after uploadBean"+outValue);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
					if (conn != null){
						ConnectionManager.returnConnection(conn);
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}	
	//Added for GHL-CRF-0550 -- END
		
	private void loadDatabase(HttpServletRequest req, HttpServletResponse res,String patId)
	{
		BLInsuranceImageBean bean			= (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		bean.insertInsuranceDBvalues(patId);
	}

	private String uploadBean(	HttpServletRequest req, HttpServletResponse res)
	{	
		FileItem fileItem1					= null;
		isMultipart				= FileUpload.isMultipartContent(req);
		BLInsuranceImageBean bean			= (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;		
	try{
		if(isMultipart)
		{
			upload			= new DiskFileUpload();
			items			= upload.parseRequest(req);	
			
			iter			= items.iterator();			
			String name		= "";
			String value	= "";
			while(iter.hasNext()){
				Item = (FileItem)iter.next();				
				if(Item.isFormField()){
					name		= Item.getFieldName();
					value		= Item.getString();							
					if(name.equals("payrGrpCode")) payrGrpCode=value;
					if(name.equals("payrCode")) payrCode=value;				
					if(name.equals("plcyCode")) plcyCode=value;						
					if(name.equals("plcyNo")) plcyNo=value;
					if(name.equals("plcystartDate")) plcystartDate=value;
					if(name.equals("plcyExpryDate")) plcyExpryDate=value;
					if(name.equals("cancel")) strCancelChk=value;
					if(name.equals("dbload")) strDbLoad=value;
					if(name.equals("patient_id")) strPatientId=value;
					//Added for GHL-CRF-0550 -- START 						
					if(name.equals("docType")) docType=value;
					if(name.equals("docRemarks")) docRemarks=value;
					if(name.equals("creditAuthNo")) creditAuthNo=value;
					if(name.equals("creditAuthDate")) creditAuthDate=value;
					if(name.equals("index")) index=value;
					if(name.equals("mode")) mode=value;
					if(name.equals("clicked_button")) clicked_button=value;
					if(name.equals("patient_id")) patient_id=value;
					if(name.equals("blngGrpCode")) blngGrpCode=value;
					if(name.equals("InsImage")) InsImage=value;
					//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
					if(name.equals("episode_type_ins")) episodeType=value;
					if ((episodeType != null) &&(episodeType.equals("R")  )) {
						episodeId = 0;
						visitId = 0;
						encounterId = 0;
					} else if (episodeType != null) {
						episodeId = -9999;
						visitId = -9999;
						encounterId = -9999;
					} else {
						episodeId = 0;
						visitId = 0;
						encounterId = 0;
					}
					if(name.equals("facility_id")) facilityId = value; 
					//Ended by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
					//Added for GHL-CRF-0550 -- END
				}else{ 
					name		= Item.getFieldName();
					if(fileItem1 == null && name.equals("InsImage")){							
						docName1		= Item.getName();	
						if(!docName1.equals(""))	 	fileItem1	= Item;
						docType1		= Item.getContentType();
						docSize1		= Item.getSize();				
				}
			}
			}
			//Added for GHL-CRF-0550 -- START 						
			
			try {
				conn=ConnectionManager.getConnection();
				siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
				//Modified for V210416
				String sql = "select SETTLEMENT_IND from BL_BLNG_GRP where SHORT_DESC='"+blngGrpCode+"'";  
				pstmt = conn.prepareStatement(sql);
				rs=	pstmt.executeQuery();
				while(rs.next())
				{
					smtind=rs.getString(1);	
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rs!=null)  rs.close();
					if (pstmt != null){
						pstmt.close();}			
					if (conn != null){
						conn.commit();
						ConnectionManager.returnConnection(conn);
						conn.close(); //Added for V210416
						}	
					} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//conn=ConnectionManager.getConnection();
			//siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
				//commented V210416
			if(siteSpecUploadDocAll)
			{
				if(clicked_button.equals("addBut"))
				{				
				//GHL-CRF-0550.1 Start	
				/*	index="^^^1110";
					lastinc=lastnum+1;
					index+=lastinc;*/
					if(smtind.equals("X")){
					index=rowID+"_"+InsuranceIndex.get(rowID);
					System.err.println("Index===============>"+index);
				if(!index.equals("")){
					//if(rowID.equals(index.substring(0,1))){
					if(rowID.equals(index.substring(0,index.indexOf("_")))){
						System.err.println("Index Value at 0 "+index.substring(0,index.indexOf("_")));
						System.err.println("Index Value after _ "+index.substring(index.indexOf("_")+1,index.length()));
						if(index.substring(index.indexOf("_")+1,index.length()).equals("null")){
							lastnum=0;
						}else{
							lastnum=Integer.parseInt(index.substring(index.indexOf("_")+1,index.length()));
						}
						lastnum+=1;
						 index=rowID+"_"+lastnum;					
					}
				}
				else{
					index=rowID+"_1";
					System.err.println("Index Value for New row "+index);
				}	
			}
		else	//Other billing group
		{
					index="^^^1110";
					lastinc=lastnum+1;
					index+=lastinc;
		}		
				}
				//GHL-CRF-0550.1 Ends
				else if(clicked_button.equals("updateBut"))
				{
					index=uindex;
				}
				else{
					index=uindex;
					System.err.println("Index in Else servlet====>"+index);					
				}
			//Added for GHL-CRF-0550 ---PALANI NARAYANAN ENDS 						
			if (strDbLoad.equals("Y")){
				loadDatabase(req,res,strPatientId);
			}else{
				if(strCancelChk.equals("Y"))	{
					bean.cancelItem_ghl(index);
				}
				else	{
					InsuranceIndex.put(rowID,index.substring(index.indexOf("_")+1,index.length()));//GHL-CRF-0550.1
					bean.setInsuranceValidation(blngGrpCode,payrGrpCode,payrCode,plcyCode,plcyNo,plcystartDate,plcyExpryDate,fileItem1,strCancelChk,docType,docRemarks,creditAuthDate,creditAuthNo,index,clicked_button,strModuleId,episodeType,encounterId,episodeId,visitId,facilityId);  
					//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020 episodeType,encounterId,episodeId,visitId,facilityId 		
				}
			}			
		
				PersistenceHelper.putObjectInBean(bean_id, bean, req);
				return "Loaded Succesfully";
			}
			else
			{
				index = payrGrpCode+payrCode+plcyCode+plcyNo+plcystartDate+plcyExpryDate;
				String escapeKey="^^^";
				bean.deleteInsuranceImageRecord(index);
				index+=escapeKey;
				if (strDbLoad.equals("Y")){
					loadDatabase(req,res,strPatientId);
				}else{
					if(strCancelChk.equals("Y"))
					{
						bean.cancelItem(index);
					}
					else{
						bean.setInsuranceValidation(payrGrpCode,payrCode,plcyCode,plcyNo,plcystartDate,plcyExpryDate,fileItem1,strCancelChk,index);		
					}
				}			
			}
					PersistenceHelper.putObjectInBean(bean_id, bean, req);
					return "Loaded Succesfully";
			}						
		}catch(Exception e){	
			e.printStackTrace();
			System.out.println("BLInsImageUploadServlet Image upload  "+e);
		}
		return  "Failed to load";
	}//end of post
}//end of class
