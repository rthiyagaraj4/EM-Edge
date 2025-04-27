/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		    Edit History	Name				Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------------
23/04/2022		23925			Ramesh Goli			23/04/2022		RAMESH G    		MO-CRF-20171
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST;


import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpUtils.*;
import webbeans.eCommon.*;
import org.apache.commons.fileupload.*;
import java.net.*;
import eCommon.SingleTabHandler.*;
import org.apache.commons.io.*;

public class DocUploadServlet  extends javax.servlet.http.HttpServlet{
	HttpSession session				= null;
	java.util.Properties p			= null;

	Connection con					= null;
	PreparedStatement pstmt			= null;
	PrintWriter out					= null;
	
	String facilityId				= "";
	String client_ip_address		= "";
	String addedById				= "";
	String modifiedById				= "";
	String addedFacilityId			= "";
	String modifiedFacilityId		= "";
	String addedAtWorkstation		= "";
	String modifiedAtWorkstation	= "";
	String locale					= "";
	String imgExt					= "";
	String docName					= "";
	String docType					= "";
	
	int update_blob_result					= 0;//Updated for IN068699
	
	List items						= null;
	Iterator iter					= null;
	long	paramsize				= 0;
	long	docSize					= 0;
	int		file_limit				= 0;

	boolean isMultipart				= false;
	
	DiskFileUpload upload			= null;
	FileItem Item					= null;
	FileItem  fileItem				= null;

	public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, IOException, FileNotFoundException
    {
       out = res.getWriter();
	  // boolean		bStatus	= true;  //COMMON-ICN-0118

	   try
	   {
		   
		   req.setCharacterEncoding("UTF-8");
		   res.setContentType("text/html;charset=UTF-8");
		   //String previewMode=""; //COMMON-ICN-0118
		   session					= req.getSession(false);
		   p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		   locale					= (String) p.getProperty("LOCALE");
		   facilityId				= (String) session.getValue( "facility_id" ) ;
		   client_ip_address		= p.getProperty("client_ip_address");
		   
		   addedById				= p.getProperty( "login_user" ) ;
           modifiedById				= addedById ;
           addedFacilityId			= facilityId;
           modifiedFacilityId		= addedFacilityId ;
           addedAtWorkstation		= client_ip_address;
           
		   modifiedAtWorkstation	= addedAtWorkstation ;

		   con						= ConnectionManager.getConnection();
		   
		   try
		   {
				isMultipart			= FileUpload.isMultipartContent(req);

				if(isMultipart)
				{

					paramsize = 1024*1024* 1024;
					upload			= new DiskFileUpload();
					upload.setSizeMax(paramsize);
					items			= upload.parseRequest(req);
					
					
					
					iter			= items.iterator();					
					String name		= "", value		= "";
					String fileName0 ="", fileName1 ="", fileName2 ="", fileName3 ="", fileName4 ="", fileName5 ="", fileName6 ="", fileName7 ="", fileName8 ="", fileName9 =""; // fileName10 =""; //COMMON-ICN-0118
					String imgRef0 ="", imgRef1 ="", imgRef2 ="", imgRef3 ="", imgRef4 ="", imgRef5 ="", imgRef6 ="", imgRef7 ="", imgRef8 ="", imgRef9 =""; // imgRef10 ="";//COMMON-ICN-0118
					String fileType0 ="", fileType1 ="", fileType2 ="", fileType3 ="", fileType4 ="", fileType5 ="", fileType6 ="", fileType7 ="", fileType8 ="", fileType9 =""; // fileType10 =""; //COMMON-ICN-0118
					long fileSize0 =0, fileSize1 =0, fileSize2 =0, fileSize3 =0, fileSize4 =0, fileSize5 =0, fileSize6 =0, fileSize7 =0, fileSize8 =0, fileSize9 =0; // fileSize10 =0; //COMMON-ICN-0118
					//String fileExt0 ="", fileExt1 ="", fileExt2 ="", fileExt3 ="", fileExt4 ="", fileExt5 ="", fileExt6 ="", fileExt7 ="", fileExt8 ="", fileExt9 ="", fileExt10 ="";
					
					FileItem   fileItem0= null, fileItem1= null, fileItem2=null, fileItem3=null, fileItem4=null, fileItem5=null, fileItem6=null, fileItem7=null, fileItem8=null, fileItem9=null, fileItem10=null;
					while(iter.hasNext())
					{
						Item = (FileItem)iter.next();

						if(Item.isFormField())
						{
							name		= Item.getFieldName();
							value		= Item.getString();	
							//System.out.println("	121--->"+name+"<-------->"+value);
							if("fileRef_0".equals(name)){	
								imgRef0=value;
							}else if("fileRef_1".equals(name)){	
								imgRef1=value;
							}else if("fileRef_2".equals(name)){	
								imgRef2=value;
							}else if("fileRef_3".equals(name)){	
								imgRef3=value;
							}else if("fileRef_4".equals(name)){	
								imgRef4=value;
							}else if("fileRef_5".equals(name)){	
								imgRef5=value;
							}else if("fileRef_6".equals(name)){	
								imgRef6=value;
							}else if("fileRef_7".equals(name)){	
								imgRef7=value;
							}else if("fileRef_8".equals(name)){	
								imgRef8=value;
							}else if("fileRef_9".equals(name)){	
								imgRef9=value;
							}
						
						}else{
							//System.out.println("	------------>151");
							name		= Item.getFieldName();	
							//System.out.println("	153-------->"+name);
							if("fileupload_0".equals(name)){
								fileItem0 = Item;
								fileName0 = imgRef0+"."+FilenameUtils.getExtension(Item.getName());
								fileType0 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize0 = Item.getSize();
							}else if("fileupload_1".equals(name)){	
								fileItem1 = Item;
								fileName1 = imgRef1+"."+FilenameUtils.getExtension(Item.getName());
								fileType1 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize1 = Item.getSize();
							}else if("fileupload_2".equals(name)){	
								fileItem2 = Item;
								fileName2 = imgRef2+"."+FilenameUtils.getExtension(Item.getName());
								fileType2 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize2 = Item.getSize();
							}else if("fileupload_3".equals(name)){	
								fileItem3 = Item;
								fileName3 = imgRef3+"."+FilenameUtils.getExtension(Item.getName());
								fileType3 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize3 = Item.getSize();
							}else if("fileupload_4".equals(name)){	
								fileItem4 = Item;
								fileName4 = imgRef4+"."+FilenameUtils.getExtension(Item.getName());
								fileType4 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize4 = Item.getSize();
							}else if("fileupload_5".equals(name)){	
								fileItem5 = Item;
								fileName5 = imgRef5+"."+FilenameUtils.getExtension(Item.getName());
								fileType5 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize5 = Item.getSize();
							}else if("fileupload_6".equals(name)){	
								fileItem6 = Item;
								fileName6 = imgRef6+"."+FilenameUtils.getExtension(Item.getName());
								fileType6 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize6 = Item.getSize();
							}else if("fileupload_7".equals(name)){	
								fileItem7 = Item;
								fileName7 = imgRef7+"."+FilenameUtils.getExtension(Item.getName());
								fileType7 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize7 = Item.getSize();
							}else if("fileupload_8".equals(name)){	
								fileItem8 = Item;
								fileName8 = imgRef8+"."+FilenameUtils.getExtension(Item.getName());
								fileType8 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize8 = Item.getSize();
							}else if("fileupload_9".equals(name)){	
								fileItem9 = Item;
								fileName9 = imgRef9+"."+FilenameUtils.getExtension(Item.getName());
								fileType9 = Item.getContentType()==null?"9999":Item.getContentType();
								fileSize9 = Item.getSize();
							}
						}
					}
					String insertSql ="INSERT INTO ST_GRN_DTL_EXP_DOC_TMP (FACILITY_ID,IMAGE_REF,IMAGE_TYPE,IMAGE_NAME,IMAGE_CONTENT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					
					//System.out.println("	208--------->"+fileSize0); 
					if(fileSize0>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef0);
						pstmt.setString(3, fileType0);
						pstmt.setString(4, fileName0);
						pstmt.setBytes(5, fileItem0.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate(); 
						if( pstmt != null )
					        pstmt.close() ;
						if(fileItem0!=null)
							fileItem0=null;
						
					}
					//System.out.println("	226--------->"+fileSize1);
					if(fileSize1>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef1);
						pstmt.setString(3, fileType1);
						pstmt.setString(4, fileName1);
						pstmt.setBytes(5, fileItem1.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem1!=null)
								fileItem1=null;
						
					}
					
					if(fileSize2>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef2);
						pstmt.setString(3, fileType2);
						pstmt.setString(4, fileName2);
						pstmt.setBytes(5, fileItem2.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;	
						 if(fileItem2!=null)
								fileItem2=null;
											
					}
					
					if(fileSize3>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef3);
						pstmt.setString(3, fileType3);
						pstmt.setString(4, fileName3);
						pstmt.setBytes(5, fileItem3.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem3!=null)
								fileItem3=null;
					}
					
					if(fileSize4>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef4);
						pstmt.setString(3, fileType4);
						pstmt.setString(4, fileName4);
						pstmt.setBytes(5, fileItem4.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem4!=null)
								fileItem4=null;
					}
					
					if(fileSize5>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef5);
						pstmt.setString(3, fileType5);
						pstmt.setString(4, fileName5);
						pstmt.setBytes(5, fileItem5.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem5!=null)
								fileItem5=null;
					}
					
					if(fileSize6>0){
						
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef6);
						pstmt.setString(3, fileType6);
						pstmt.setString(4, fileName6);
						pstmt.setBytes(5, fileItem6.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem6!=null)
								fileItem6=null;
					}
					
					if(fileSize7>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef7);
						pstmt.setString(3, fileType7);
						pstmt.setString(4, fileName7);
						pstmt.setBytes(5, fileItem7.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem7!=null)
								fileItem7=null;
						
					}
					
					if(fileSize8>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef8);
						pstmt.setString(3, fileType8);
						pstmt.setString(4, fileName8);
						pstmt.setBytes(5, fileItem8.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem8!=null)
								fileItem8=null;
						
					}
					
					if(fileSize9>0){
						pstmt=con.prepareStatement(insertSql);
						pstmt.setString(1, facilityId);
						pstmt.setString(2, imgRef9);
						pstmt.setString(3, fileType9);
						pstmt.setString(4, fileName9);
						pstmt.setBytes(5, fileItem9.get());
						pstmt.setString(6, addedById);
						pstmt.setString(7, addedAtWorkstation);
						pstmt.setString(8, addedFacilityId);
						pstmt.setString(9, modifiedById);
						pstmt.setString(10, modifiedAtWorkstation);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.executeUpdate();
						 if( pstmt != null )
					            pstmt.close() ;
						 if(fileItem9!=null)
								fileItem9=null;
						
					}
					con.commit();
				}
			}
			catch (FileUploadBase.SizeLimitExceededException eff)
			{
				eff.printStackTrace();	
			}

			catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception @ Servlet - main:1"+e.toString());
			}
			
			
			upload	= null;
			items	= null;
			iter	= null;
			
			if(fileItem != null)
				fileItem.delete();

			fileItem = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception @ Servlet - main:2"+e.toString());
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con, req);	
		}
    }
    private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
}
