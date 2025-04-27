/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FilenameUtils;

import webbeans.eCommon.MessageManager;
import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

@SuppressWarnings("deprecation")
public class EncSummGroupServlet extends javax.servlet.http.HttpServlet
{	
	private static final long serialVersionUID = 1L;
	
	String docName = "";
	String docType = "";
	int insert_blob_result = 0;
	String imgExists ="";
	String locale = "";
	String error = "";
	
	int es_group_flag = 0;	
	String es_group_type="";
	String es_group_code="";
	String es_group_desc="";
	String es_group_remarks="";
	String es_group_image_url="";
	String es_group_status="";
	
	int es_group_flag1 = 0;	
	String es_group_type1="";
	String es_group_code1="";
	String es_group_desc1="";
	String es_group_remarks1="";
	String es_group_image_url1="";
	String es_group_status1="";
	String es_image_name="";
	
	String facilityId="" ;
	String client_ip_address="";
	String addedById = "";
	String modifiedById = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";
	
	String mode = "";

	List items = null;
	Iterator iter = null;
	
	java.io.InputStream instream = null;

	long paramsize = 0;
	long docSize = 0;
	int file_limit = 0;

	boolean isMultipart = false;
	
	DiskFileUpload upload = null;
	FileItem Item = null;
	FileItem  fileItem = null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		PrintWriter out = null;
		
		boolean bStatus = true;
		
		String name	= "", value = "";
		
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8 ");
			out = res.getWriter();
			
			/*
			 * Image File upload
			 */
				
			isMultipart = FileUpload.isMultipartContent(req);
			
			if(isMultipart)
			{
				paramsize = 200 * 1024;
				upload = new DiskFileUpload();
				upload.setSizeMax(paramsize);
				items = upload.parseRequest(req);				
				iter = items.iterator();				
				
				while(iter.hasNext())
				{
					Item = (FileItem)iter.next();
					
					if(Item.isFormField())
					{
						name		= Item.getFieldName();
						value		= Item.getString();						
						
						if(name.equals("mode"))  
							mode = checkForNull(value);	
						else if(name.equals("es_group_flag1"))
							es_group_flag	= Integer.parseInt(checkForNull(value));	
						else if(name.equals("es_group_type1"))
							es_group_type	= checkForNull(value);						 
						else if(name.equals("es_group_code1"))
							es_group_code	= checkForNull(value);
						else if(name.equals("es_group_desc1"))
							es_group_desc	= checkForNull(value);
						else if(name.equals("es_group_remarks1"))
							es_group_remarks = checkForNull(value);
						else if(name.equals("es_group_image_url1"))
							es_group_image_url	= checkForNull(value);
						else if(name.equals("es_group_status1") )
							es_group_status = checkForNull(value);
						else if(name.equals("es_image_name") )
							es_image_name = checkForNull(value);						
					}
					else					
					{
						fileItem	= Item;
						docName		= Item.getName();						
						docType		= Item.getContentType();
						docSize		= Item.getSize();			
						
						if(docType == null)
							docType = "999";
						
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
			}
			/*
			 * Code ends here 
			 */		
			
			if(bStatus)
			{				
				if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
				if (mode.trim().equalsIgnoreCase("update"))   modify(req, res, out);
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
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
	
	

 /********************************* Populates the hash table with the values *******************/

	public HashMap<String, Object> populateHashMap(HttpServletRequest req, PrintWriter out)
	{
			
		java.util.Properties p;				

		HashMap<String, Object> tabdata	= null;
		//String mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");			

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;        
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
		
		tabdata=new HashMap<String, Object>();
		
		if (es_image_name.length()>0){
			es_group_image_url = es_image_name;
		}
		else
		{
			es_group_image_url = "";
		}
		
		tabdata.put("ES_GROUP_FLAG", es_group_flag);
		tabdata.put("ES_GROUP_TYPE",es_group_type);
		tabdata.put("ES_GROUP_CODE",es_group_code);
		tabdata.put("ES_GROUP_DESC",es_group_desc);			
		tabdata.put("ES_GROUP_REMARKS",	es_group_remarks);
		tabdata.put("ES_GROUP_IMAGE_URL",es_group_image_url);
		tabdata.put("ES_GROUP_STATUS",	es_group_status);			
			
		if (mode.equalsIgnoreCase("insert"))
		{
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);									
		}
		
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID",facilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		
		return tabdata;
	
	}

/***************************************insert**********************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String error_value = "0" ;

		HashMap tabdata			= null;

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		tabdata=new HashMap();	
		
		/**
		 * 
		 */		
		File filecreate ;		
		String filename	= "";
		boolean fcre = false;
		
		if (es_image_name.length()>0)
		{
			filename = getImagePath(es_image_name, out);
		}
		
        int size = (int)docSize;
		/**
		 * 
		 */
		try
		{			
			error =	"";	
			
			if (filename.length()>0)
			{
				filecreate = new File(filename);		
				
				if(filecreate.exists())
				{
					fcre = filecreate.delete();
					if (fcre)
					{
						fcre = filecreate.createNewFile();
					}
				}
				else
					fcre = filecreate.createNewFile();
				
				if(fcre)
				{				
					FileOutputStream fileoutput = new FileOutputStream(filecreate);
			        fileoutput.write(fileItem.get(),0,size);		     
					if (fileoutput != null)  fileoutput.close();				   
				}
			}
			
			
			tabdata = populateHashMap(req, out); //FILL THE HASHMAP
			
			String dupflds[]={"ES_GROUP_FLAG","ES_GROUP_TYPE","ES_GROUP_CODE"};

			boolean local_ejbs = false;
			String tabname="CR_ES_GROUP_HEADER";
		
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

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			
			if ( inserted )
				error_value = "1" ;
				filecreate = null;

			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}


	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String error_value = "0" ;

		HashMap<String, Object> tabdata = null;	
		
		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;			
		
		tabdata=new HashMap<String, Object>();		
		
		File filecreate ;		
		String filename	= "";
		boolean fcre = false;
		
		if (es_image_name.length()>0)
		{
			filename = getImagePath(es_image_name, out);
		}
		
        int size = (int)docSize;
        
		try
		{			
			error =	"";
			
			if (filename.length()>0)
			{
				filecreate = new File(filename);			
				if(filecreate.exists())
				{
					fcre = filecreate.delete();
					if (fcre)
					{
						fcre = filecreate.createNewFile();
					}
				}
				else
					fcre = filecreate.createNewFile();
				
				if(fcre)
				{				
					FileOutputStream fileoutput = new FileOutputStream(filecreate);
			        fileoutput.write(fileItem.get(),0,size);		     
					if (fileoutput != null)  fileoutput.close();				   
				}
			}			
						
			tabdata = populateHashMap(req, out); //FILL THE HASHMap
			
			HashMap<String, Object> condflds=new HashMap<String, Object>();
			condflds.put("ES_GROUP_FLAG",es_group_flag);
			condflds.put("ES_GROUP_TYPE",es_group_type);
			condflds.put("ES_GROUP_CODE",es_group_code);
			
			boolean local_ejbs = false;
			String tabname="CR_ES_GROUP_HEADER";
		
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

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;	
			
			if (modified)
				error_value = "1";
				filecreate = null;

			results.clear();   			
   			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
	
	public String checkNull(String str,HttpServletRequest req) //flag is true for null feilds
	{
		String tempHolder =  req.getParameter(str)	 ;
		return (tempHolder==null)?"":tempHolder ;
	}
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}	

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	
	private String getImagePath(String image_name, PrintWriter out)
	{		
		StringBuffer image_folder = new StringBuffer();
		String path	= "";		
		String strFileSep =	"";

		java.util.Properties pFileSep	= null;
		
		try
		{		
			path = getServletContext().getRealPath("/");

			image_folder.append(path);

			pFileSep	= System.getProperties();
			strFileSep	= (String) pFileSep.getProperty("file.separator");
			image_folder.append("eCA");
			image_folder.append(strFileSep);
			image_folder.append("images");
			image_folder.append(strFileSep);			
			image_folder.append(image_name);			
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		return image_folder.toString();
	}
	
}
