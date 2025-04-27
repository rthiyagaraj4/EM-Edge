/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name					Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------
13/03/2017    IN063784     Raja S       14/03/2017      Ramesh G           Image is not displaying while clicking Preview button in Note Image List function_UT Issue
25/10/2018    IN068699     Raja S		25/10/2018		Ramesh G		   ML-MMOH-SCF-1087	
19/06/2023  46480       krishna pranay       19/06/2023         Ramesh Goli     COMMON-ICN-0131
-------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

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
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class NoteImageListServlet extends javax.servlet.http.HttpServlet
{
	HttpSession session				= null;
	java.util.Properties p			= null;

	Connection con					= null;
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
	String image_mode				= "";
	String image_url				= "";
	String flag						= "";
	String enabled					= "";
	String image_ref				= "";
	String image_ref_desc			= "";
	String image_name				= "";
	String docName					= "";
	String docType					= "";
	String image_url_add			= "";
	String image_url_1				= "";
	String mode						= "";
	String file_limit_unit			= "";
	String error					= "";
	//int insert_blob_result					= 0;//Commented for IN068699
	int update_blob_result					= 0;//Updated for IN068699
	String imgExists				="";

	List items						= null;
	Iterator iter					= null;
	
	java.io.InputStream instream	= null;

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
//	   PreparedStatement pstFileLmt		=	null;
//	   ResultSet		 rsFileLmt		=	null;

	   boolean			bStatus			= true;

	   try
	   {
		   req.setCharacterEncoding("UTF-8");
		   res.setContentType("text/html;charset=UTF-8");
		   req= new XSSRequestWrapper(req); //MOHE-SCF-0153
		   res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
		   res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		   String previewMode="";
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
/*
					String strFileLimitQry = "select NOTE_LINKED_FILE_LIMIT , NOTE_LINKED_FILE_LIMIT_UNIT from CA_NOTE_PARAM";
				
					pstFileLmt	=	con.prepareStatement(strFileLimitQry);
					rsFileLmt	=	pstFileLmt.executeQuery();

					if(rsFileLmt.next())
					{
						file_limit			= rsFileLmt.getInt("note_linked_file_limit");
						file_limit_unit		= rsFileLmt.getString("note_linked_file_limit_unit");
					}
					
					if(rsFileLmt != null) rsFileLmt.close();
					if(pstFileLmt != null) pstFileLmt.close();

					if(file_limit_unit.equalsIgnoreCase("K") || file_limit_unit.equalsIgnoreCase("KB"))
							paramsize = file_limit * 1024;

					if(file_limit_unit.equalsIgnoreCase("M") || file_limit_unit.equalsIgnoreCase("MB"))
							paramsize = file_limit *1024 *1000;

					if(file_limit_unit.equalsIgnoreCase("G") || file_limit_unit.equalsIgnoreCase("GB"))
							paramsize = file_limit *1024 *1000 * 1000;
*/
					paramsize = 200 * 1024;

					upload			= new DiskFileUpload();
					upload.setSizeMax(paramsize);


					items			= upload.parseRequest(req);
					
					iter			= items.iterator();
					
					String name		= "",		value		= "";
					
					while(iter.hasNext())
					{
						Item = (FileItem)iter.next();

						if(Item.isFormField())
						{
							name		= Item.getFieldName();
							value		= Item.getString();
							
							if(name.equals("image_mode"))  
								image_mode		= checkForNull(value);
							else if(name.equals("flag"))
								flag			= checkForNull(value);
							else if(name.equals("enabled1"))
							enabled			= checkForNull(value);
							 
							else if(name.equals("image_ref"))
								image_ref		= checkForNull(value);
							else if(name.equals("image_ref_desc"))
								image_ref_desc	= checkForNull(value);
							else if(name.equals("image_name"))
								image_name		= checkForNull(value);
							else if(name.equals("image_url_add"))
								image_url_add	= checkForNull(value);
							else if(name.equals("image_url_1") )
								image_url_1 = checkForNull(value);
							else if(name.equals("image_mode") )
								image_mode = checkForNull(value);
							else if(name.equals("mode") )
								mode = checkForNull(value);
							else if(name.equals("previewMode") )
								previewMode = checkForNull(value);
							else if(name.equals("imgExists") )
								imgExists = checkForNull(value);
							
						}
						else
						{
							fileItem	= Item;
							docName		= Item.getName();
							docType		= Item.getContentType();
							docSize		= Item.getSize();

							if(docType == null)
								docType = "999";

/*
							String strFileTypeQry =  "select 1 from ca_appl_linked_obj_type where APPLICABLE_YN = 'Y' AND OBJ_TYPE IN(?)";

							pstFileLmt	=	con.prepareStatement(strFileTypeQry);
							pstFileLmt.setString(1,docType);
							rsFileLmt	=	pstFileLmt.executeQuery();

							if(!rsFileLmt.next())
							{
								bStatus = false;
								error = getMessage(locale, "FILE_NOT_SUPPORTED","CA");
								out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error )+"'</script>");
							}

							if(rsFileLmt != null) rsFileLmt.close();
							if(pstFileLmt != null) pstFileLmt.close();
			*/
							if(bStatus)
							{

								if(docSize > paramsize ) 
								{
									bStatus = false;
									error = getMessage(locale, "FILE_SIZE_NOT_SUPPORTED","CA");
									
									out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error )+"'</script>");
								}
							}
						}
					}
					if(image_url == null)
						image_url	= image_url_add;
					if(enabled == null||enabled.equals(""))
						enabled		= "D";
				}
				else
				{
					mode			= checkForNull(req.getParameter("mode"));
					image_mode		= checkForNull(req.getParameter("image_mode"));
					flag			= checkForNull(req.getParameter("flag"));
				}
			}
			catch (FileUploadBase.SizeLimitExceededException eff)
			{
				eff.printStackTrace();
				bStatus = false;
				error = getMessage(locale, "FILE_SIZE_NOT_SUPPORTED","CA");
				out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error )+"'</script>");
			}

			catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception @ Servlet - main:1"+e.toString());//common-icn-0181
			}
			try
			{		
				if(bStatus)
				{					
					if(previewMode.equals("Y")){
						preview(req, res, out);
					}else{
					if ( mode.equals("insert") ){
						insert(req, res, out);
					}
					if ( mode.equals("modify"))
						modify(req,res, out);
				}
				}
			}
			catch(Exception e)
			{
				//out.println("From the Servlet" + e.toString());//common-icn-0181
				e.printStackTrace();
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
			//out.println("Exception @ Servlet - main:2"+e.toString());//common-icn-0181
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con, req);	
		}
    }
   
    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		
//	    String err_num				= "";
		String tabname				= "";
		StringBuffer note_image_rep_folder	= new StringBuffer();
		String path						= "";
		String strFileSep	=	"";
		String qryImgContent="";
		int updt_blob_result = 0;
			
		PreparedStatement pstmt=null;
		PreparedStatement pstImgDtl=null;
	   //PreparedStatement pstUpdtImgContent=null;//46480   
		ResultSet rs=null;
		//ResultSet rsUpdtImgContent=null;//46480   
			
		java.util.Properties pFileSep	= null;	
		File filecreate ;
		FileOutputStream fileoutput=null;
		ByteArrayOutputStream bytearrayoutputstream =null;
		InputStream ins1 = null;
						       
		try
        {
			/***************************/
						
			path					= getServletContext().getRealPath("/");
			note_image_rep_folder.append(path);
			pFileSep	= System.getProperties();
			strFileSep	= (String) pFileSep.getProperty("file.separator");
			note_image_rep_folder.append(strFileSep); //IN063784
			note_image_rep_folder.append("eCA");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("MediPainter");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("images");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append(image_name);
			String filename			=	note_image_rep_folder.toString();
			filecreate				= new File(filename);
			boolean fcre			= false;
			boolean updt			=false;
			error	=	"";
			int size				= (int)docSize;
			if(filecreate.exists() && imgExists.equals(""))
			{

				error = getMessage(locale,"IMAGE_FILE_EXISTS","CA");

				out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error )+"'</script>");
				
			}else if(imgExists.equals("")){
			
				fcre = filecreate.createNewFile();
				
				if(fcre)
				{
					if(image_mode.equals("upload") && flag.equals("false") )
					{
						fileoutput = new FileOutputStream(filecreate);
						fileoutput.write(fileItem.get(),0,size);

						if (fileoutput != null)  fileoutput.close();
					}  
					updt = true;
				}
				
			}else if((!filecreate.exists()) && (!imgExists.equals(""))){
			/*********get from database and create the file in the imagae folder*************/
				

				qryImgContent = "select objtype, IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF = ? ";
				pstmt = con.prepareStatement(qryImgContent);
				pstmt.setString(1,image_ref);
				rs = pstmt.executeQuery();

				while(rs !=null && rs.next())
				{
					res.setContentType(rs.getString("objtype"));
					java.sql.Blob  img_blob1  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
					long len = img_blob1.length();
					ins1 = img_blob1.getBinaryStream();
					bytearrayoutputstream = new ByteArrayOutputStream();
					int i;
					while((i = ins1.read()) != -1) 
					bytearrayoutputstream.write(i);
					fcre = filecreate.createNewFile();
					if(fcre)
					{
						fileoutput = new FileOutputStream(filecreate);
						fileoutput.write((bytearrayoutputstream.toByteArray()),0,(int)len);
						if (fileoutput != null)  fileoutput.close();			
					}		
				}
				/****** create a copy in the image folder*******end****/
					
					if(rs!=null)
						rs.close();
					if(pstmt!=null)
						pstmt.close();
					if(ins1 !=null)
					ins1.close();
					
			}else if(filecreate.exists()){
					
				String exst="";
				pstmt=con.prepareStatement("select 'Y' exst from CA_NOTE_IMAGE_LIST where image_Ref=? and objtype is not null");
				pstmt.setString(1,image_ref);
				rs=pstmt.executeQuery();
				while((rs!=null) && (rs.next())){
					exst=(String)rs.getString("exst");
				}
				if(exst.equals("Y") ){
					
					updt =false;
				}else {
					
					docType= (String)(getMimeType(filecreate));
					updt=true;
				}
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}else{
				updt=true;
			}
			
			HashMap tabdata			= new HashMap();
			HashMap condflds		= new HashMap();
			java.util.HashMap results=new HashMap();
			String error_value = "0" ;
			boolean inserted=false;
			if(updt){
			
				tabdata.put("image_ref_desc",image_ref_desc);
				tabdata.put("eff_status",enabled);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("objtype",docType );
				tabdata.put("image_url",image_name);
				
				condflds.put("image_ref",image_ref);
				boolean local_ejbs		= false;
				tabname					= "ca_note_image_list";

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = tabname;
					
				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = tabname.getClass();
					
				results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				tabdata.clear();
				condflds.clear();
					
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error = (String) results.get("error") ;

				if ( inserted ){
					updt_blob_result=0;
					try{
					//	int docs	 =	 (int)docSize;	//46480   
						//String insert_img_dtl = "update CA_NOTE_IMAGE_LIST set IMAGE_CONTENT=empty_blob() where IMAGE_REF=? and image_url=? ";//Commented for IN068699
						String insert_img_dtl = "update CA_NOTE_IMAGE_LIST set IMAGE_CONTENT=? where IMAGE_REF=? and image_url=? ";//Modified for IN068699
						pstImgDtl = con.prepareStatement(insert_img_dtl);
						//pstImgDtl.setString(1,docType);
						FileInputStream   fis = new FileInputStream(filecreate);//IN068699
						pstImgDtl.setBinaryStream(1, fis, (int) filecreate.length());//IN068699
						pstImgDtl.setString(2,image_ref);		
						pstImgDtl.setString(3,image_name);
							
						updt_blob_result = pstImgDtl.executeUpdate();

						if(updt_blob_result > 0)
						{
							/*	
							java.sql.Blob img_blob = null;
							java.io.OutputStream blobOutputStream = null;

							String update_image_content = "select IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF=? and image_url=?  for update";

							pstUpdtImgContent = con.prepareStatement(update_image_content);
							pstUpdtImgContent.setString(1,image_ref);
							pstUpdtImgContent.setString(2,image_name);
							rsUpdtImgContent = pstUpdtImgContent.executeQuery();
							while(rsUpdtImgContent!=null && rsUpdtImgContent.next())
							{
								img_blob	=	(java.sql.Blob)rsUpdtImgContent.getBlob(1);
								blobOutputStream = img_blob.setBinaryStream(0);
								size = fileItem.get().length;
								blobOutputStream.write(fileItem.get(),0,docs);
								blobOutputStream.close();
								inserted = true;
							}
							if(rsUpdtImgContent!=null)
							rsUpdtImgContent.close();
							if(pstUpdtImgContent!=null)
								pstUpdtImgContent.close();
						--commented for IN068699*/
								inserted = true;//IN068699
						}else
							inserted = false;
						}
						catch(Exception e)
						{
							inserted=false;
							e.printStackTrace();
							inserted = false;
							
						}
						finally
						{
							if(pstImgDtl!=null)
							pstImgDtl.close();
						}
					}

				}else{
					tabdata.put("image_ref_desc",image_ref_desc);
					tabdata.put("eff_status",enabled);
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
					condflds.put("image_ref",image_ref);
					boolean local_ejbs		= false;
						
					tabname					= "ca_note_image_list";

					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
						
					Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = condflds;
					argArray[3] = tabname;
					
					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = condflds.getClass();
					paramArray[3] = tabname.getClass();
						
					results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					tabdata.clear();
					condflds.clear();
						
					inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					error = (String) results.get("error") ;

			}
/*********************************/

			if ( inserted )
			{  error_value = "1" ;
				con.commit();//IN068699
			}

			results.clear();
			if(	filecreate != null)
				filecreate = null;
          
		    out.println("<script>");
            if(enabled.equals("E"))
            {
                out.println("parent.f_query_add_mod.document.ImageListForm.enabled.checked=true");
                out.println("parent.f_query_add_mod.document.ImageListForm.image_ref.readOnly=false");
                out.println("parent.f_query_add_mod.document.ImageListForm.image_url.readOnly=false");
                out.println("parent.f_query_add_mod.document.ImageListForm.image_ref_desc.readOnly=false");
            }
            else
            {
                out.println("parent.f_query_add_mod.document.ImageListForm.enabled.checked=false");
                out.println("parent.f_query_add_mod.document.ImageListForm.image_ref.readOnly=true");
                out.println("parent.f_query_add_mod.document.ImageListForm.image_url.readOnly=true");
                out.println("parent.f_query_add_mod.document.ImageListForm.image_ref_desc.readOnly=true");
            }
			 
			 out.println("parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error)+"'");

             out.println("</script>");
        }
        catch ( Exception e )
        {
           // out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received in modify: "+e.toString());//common-icn-0181
            e.printStackTrace();
            out.println( "Values sent are : <br>" ) ;
            out.println( image_ref+" "+image_ref_desc+" "+image_url );
        }
		
	
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)throws FileUploadException, java.io.IOException
    {
		StringBuffer note_image_rep_folder	= new StringBuffer();
		String path						= "";
		String error_value = "0" ;
		String strFileSep	=	"";

		java.util.Properties pFileSep	= null;

		File filecreate ;
		PreparedStatement pstImgDtl=null;
	//	PreparedStatement pstUpdtImgContent=null;//46480   
	//	ResultSet rsUpdtImgContent=null;//46480   
        try
        {	
				path					= getServletContext().getRealPath("/");

				note_image_rep_folder.append(path);

				pFileSep	= System.getProperties();
				strFileSep	= (String) pFileSep.getProperty("file.separator");
				note_image_rep_folder.append(strFileSep); //IN063784
				note_image_rep_folder.append("eCA");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append("MediPainter");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append("images");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append(image_name);

//				String server			= "\\\\"+req.getServerName();
//				int index				= path.indexOf(":");
//				String substr			= server+path.substring(index+1);
//				note_image_rep_folder	= substr+"eCA/MediPainter/images";
//				String filename			= note_image_rep_folder+"\\"+image_name;
				
				String filename			=	note_image_rep_folder.toString();
                int size				= (int)docSize;
           		filecreate				= new File(filename);

				boolean fcre			= false;

				error	=	"";
				
				if(filecreate.exists())
				{
				//	error = getMessage(locale, "IMAGE_FILE_EXISTS","CA");

//					out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error )+"'</script>");
					//filecreate.delete();
					//fcre = filecreate.createNewFile();
				}
				else
					fcre = filecreate.createNewFile();
				if(fcre )
				{

					if(image_mode.equals("upload") && flag.equals("false") )
					{
			            FileOutputStream fileoutput = new FileOutputStream(filecreate);
				        fileoutput.write(fileItem.get(),0,size);

						if (fileoutput != null)  fileoutput.close();
					}   
				}
			        HashMap tabdata=new HashMap();

					tabdata.put("image_ref",image_ref);
					tabdata.put("image_ref_desc",image_ref_desc);
					tabdata.put("image_url",image_name);
					tabdata.put("eff_status",enabled);
					tabdata.put("added_by_id",addedById);
					tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("added_facility_id", facilityId);
					tabdata.put("added_at_ws_no",addedAtWorkstation);
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
					tabdata.put("objtype",docType );

					String dupflds[]={"image_ref"};
					boolean local_ejbs = false;
					String tabname="ca_note_image_list";
		            if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = tabname;
					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = tabname.getClass();
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					tabdata.clear();
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					error = (String) results.get("error") ;
/*********************************/
if ( inserted ){
	update_blob_result=0;//IN068699
	try{
	//	int docs	 =	 (int)docSize;//46480   
		 FileInputStream   fis = new FileInputStream(filecreate);//IN068699
		//String insert_img_dtl = "update CA_NOTE_IMAGE_LIST set IMAGE_CONTENT=empty_blob() where IMAGE_REF=? and image_url=? ";//commented IN068699
		String insert_img_dtl = "update CA_NOTE_IMAGE_LIST set IMAGE_CONTENT=? where IMAGE_REF=? and image_url=? ";//IN068699
		
		pstImgDtl = con.prepareStatement(insert_img_dtl);
		pstImgDtl.setBinaryStream(1,fis, (int) filecreate.length());//IN068699
		//pstImgDtl.setString(1,docType);
		pstImgDtl.setString(2,image_ref);		
		pstImgDtl.setString(3,image_name);
	
		update_blob_result = pstImgDtl.executeUpdate();
		if(update_blob_result > 0)
		{
			/* IN068699 starts
			java.sql.Blob img_blob = null;
			java.io.OutputStream blobOutputStream = null;

			String update_image_content = "select IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF=? and image_url=?  for update";

			pstUpdtImgContent = con.prepareStatement(update_image_content);
			pstUpdtImgContent.setString(1,image_ref);
			pstUpdtImgContent.setString(2,image_name);
			rsUpdtImgContent = pstUpdtImgContent.executeQuery();
			while(rsUpdtImgContent.next())
			{
				//img_blob	=	(oracle.sql.BLOB)rsUpdtImgContent.getBlob(1);
				img_blob	=	(java.sql.Blob)rsUpdtImgContent.getBlob(1);
				//blobOutputStream = ((oracle.sql.BLOB)img_blob).getBinaryOutputStream();
				blobOutputStream = img_blob.setBinaryStream(0);
				size = fileItem.get().length;
				blobOutputStream.write(fileItem.get(),0,docs);
				blobOutputStream.close();
				inserted = true;
			}
			if(rsUpdtImgContent!=null)
			rsUpdtImgContent.close();
			if(pstUpdtImgContent!=null)
			pstUpdtImgContent.close();
			--Commented for IN068699 */
			inserted = true;
		}else
			inserted = false;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	inserted = false;
	
	}
	finally
	{
		if(pstImgDtl!=null)
		pstImgDtl.close();
	}
}
/*********************************/
					if ( inserted ){
						error_value = "1" ;
						con.commit();//IN068699
					}
	           
					results.clear();
				//}

				filecreate = null;
			

	            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
        }
        catch ( Exception e )
        {
          //out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
            e.printStackTrace();
           // out.println( "Values sent are : <br>" ) ;//common-icn-0181
            out.println( image_ref+" "+image_ref_desc+" "+image_url );
        }
    }

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	private void preview(HttpServletRequest req, HttpServletResponse res, PrintWriter out)throws FileUploadException, java.io.IOException
    {
		StringBuffer note_image_rep_folder	= new StringBuffer();
		StringBuffer note_image_rep	= new StringBuffer();
		String path						= "";
		String error_value = "0" ;
		String strFileSep	=	"";
		java.util.Properties pFileSep	= null;

		File tempFilecreate ;
		try{
				path					= getServletContext().getRealPath("/");
				note_image_rep_folder.append(path);
				pFileSep	= System.getProperties();
				strFileSep	= (String) pFileSep.getProperty("file.separator");
				note_image_rep_folder.append(strFileSep);//IN063784
				note_image_rep_folder.append("eCA");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append("MediPainter");
				note_image_rep_folder.append(strFileSep);
				note_image_rep_folder.append("images");
				note_image_rep_folder.append(strFileSep);
				/********name of the temp file*********/
				//Calendar cal = Calendar.getInstance();
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmssSSS");
				//image_name=""+(sdf.format(cal.getTime()))+image_name;
				/*****************/
				//note_image_rep_folder.append("temp_"+image_name);
				note_image_rep_folder.append(image_name);

				String filename			=	note_image_rep_folder.toString();
				int size				= (int)docSize;
				tempFilecreate				= new File(filename);
				boolean fcre			= false;
				error	=	"";				
				boolean flag = false;
				if(tempFilecreate.exists())
				{
					//flag=true;
					//error = getMessage(locale, "IMAGE_FILE_EXISTS","CA");
					
				}
				else{
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmssSSS");
					note_image_rep.append(path);
					note_image_rep.append(strFileSep); //IN063784
					note_image_rep.append("eCA");
					note_image_rep.append(strFileSep);
					note_image_rep.append("MediPainter");
					note_image_rep.append(strFileSep);
					note_image_rep.append("images");
					note_image_rep.append(strFileSep);
					image_name=""+(sdf.format(cal.getTime()))+image_name;
					note_image_rep.append(image_name);
					String filename_new=	note_image_rep.toString();
					tempFilecreate	= new File(filename_new);
					fcre = tempFilecreate.createNewFile();
				}
				if(fcre || flag )
				{					
					FileOutputStream fileoutput = new FileOutputStream(tempFilecreate);
					fileoutput.write(fileItem.get(),0,size);
					if (fileoutput != null)  fileoutput.close();
				}
					error_value="1";	
					out.println("<script>");				
					out.println("parent.f_query_add_mod.document.ImageListForm.docType.value='"+docType+"'");				
					out.println("parent.f_query_add_mod.document.ImageListForm.previewMode.value='';");					
					out.println("var imageName='"+image_name+"'");
					out.println("var filename='../eCA/jsp/NoteImageListPreview.jsp?image_ref='+parent.f_query_add_mod.document.ImageListForm.image_ref.value+'&mode='+parent.f_query_add_mod.document.ImageListForm.mode.value+'&docType='+parent.f_query_add_mod.document.ImageListForm.docType.value+'&image_name='+escape(imageName)+'&imgExists='+parent.f_query_add_mod.document.ImageListForm.imgExists.value");			
					out.println("var obj=window.open(filename,'Document','height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes');");
					out.println(" obj.addEventListener('load', function(){obj.document.body.style.backgroundColor = 'white';}); ");
					out.println("parent.messageFrame.location.href='../eCommon/jsp/error.jsp';");
					out.println("</script>");			
 
				//}
				if(tempFilecreate !=null)
					tempFilecreate=null;
				
		}catch ( Exception e )
        {
			e.printStackTrace();
        }

}
	public static String getMimeType(File file)  throws java.io.IOException, MalformedURLException 
  {
		String type = null;
	try{
    
    URL u = file.toURL();
    URLConnection uc = null;
    uc = u.openConnection();
    type = uc.getContentType();
  
	}catch(Exception e){
		
		e.printStackTrace();
	}
	  return type;
  }

}
