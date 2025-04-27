package eMP;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;

import java.sql.*;

import webbeans.eCommon.*; 

import javax.imageio.ImageIO;

import eMP.PatientPhoto.PatientPhotoComponent;

import eCommon.DocumentFileStorage;
import java.util.*;


import eMP.DocumentConfigOption;
import org.apache.commons.io.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import eXH.XHUtil;


/**
 * Simple demonstration for an Applet <-> Servlet communication.
 */
public class PatientPhotoServlet  extends javax.servlet.http.HttpServlet {
	/**
	 * Get a String-object from the applet and send it back.
	 */
	//private static final long serialVersionUID = -5302010108271068350L; //Commented for checkstyle

	int width;
    int height;

	String facility_id = "", encounter_id = "", patient_id = "", module_id = "";
	int data[][];
	String table_name = "", PK_column_name = "", photo_column_name = "" , photo_image_path = ""  ;
	String photo_DB_flag ="";

	//Added by bhuvana for MO-CRF-20154 on 23/05/2019.
	int docSaveas =0 , docSaveAs = 0, docFolderOption = 0;
	String docSharedPath = "" , docMainType = "", docType = "";
	String newFileFolder = "" , sFileSeparator = "" , photodocument_Id = "";
	DocumentFileStorage dFileStorage = null;
	BufferedImage image =  null;
	File theNewDir = null;
    boolean isDebugYN =false;
	//Ended for MO-CRF-20154 on 23/05/2019.


	//isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			java.util.Properties p			=	null;
			HttpSession   session			=   null;
			java.io.PrintWriter    out		=   null;
			
			Connection con			= null;
			PreparedStatement pstmt  = null ;
			ResultSet rs            = null ;
			
			String addedById = "";
			String addedFacilityId = "";
			String clientIpAddress = "";

			String facility_id = "";
			String user_id = "";
			String ws_no = "";
			String locale = "";

			//boolean photoFlag = false; //Commented for checkstyle
			
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			session			=   request.getSession(true) ;

			p = (java.util.Properties) session.getValue( "jdbc" ) ;

			if(isDebugYN) System.out.println(" - - - p - - - "+p);
			
			session = request.getSession(false);
			
			
			
			//response.setContentType("application/x-java-serialized-object");			
			response.setContentType("application/octet-stream");

			// read a String-object from applet
			// instead of a String-object, you can transmit any object, which
			// is known to the servlet and to the applet

			if(isDebugYN) System.out.println(" - - - inside PatientPhotoServlet sethu - - - ");

			//Object obj = null; //Commented for checkstyle
			PatientPhotoComponent photoComponent = null;
			
			InputStream in = request.getInputStream();
			if(isDebugYN) System.out.println(" - - - in - - - "+in);
			ObjectInputStream inputFromApplet = new ObjectInputStream(in);
			
			//obj = inputFromApplet.readObject();
			//System.out.println(" - - - obj - - - "+obj+" :::: GetClass:: "+obj.getClass());
			
			photoComponent = (PatientPhotoComponent)inputFromApplet.readObject();
			patient_id = photoComponent.getPatientId();
			data = photoComponent.getImageData();
			module_id = photoComponent.getModuleId();
			facility_id = photoComponent.getFacilityId();
			user_id = photoComponent.getUserId();
			ws_no = photoComponent.getWsnoId();
			locale = photoComponent.getlocale();

			//System.out.printn("facility_id" + facility_id + "user_id" + user_id + "ws_no" + ws_no +"locale" + locale);
			System.out.println("facilityid"+ facility_id + "UserId" + user_id +"WsNo"+ ws_no +"Locale"+locale);

			addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");

			if (addedFacilityId.length() > 0)
			{
				addedFacilityId = addedFacilityId;
			}
			else
				addedFacilityId = facility_id;

			if (p != null)
		    {
				clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
				addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

			}
			else
			{
				clientIpAddress = ws_no;
				addedById = user_id;
			}

			if(isDebugYN) System.out.println(" :::  addedFacilityId :: "+addedFacilityId+" ::: clientIpAddress :: "+clientIpAddress+" ::: addedById :: "+addedById);

			/*docSaveas = photoComponent.getDocSaveas();//Added by bhuvana
			docSharedPath = photoComponent.getDocSharedPath();//Added by bhuvana.*/

						
			/*
			PatientPhotoComponent photoComponent = (PatientPhotoComponent)inputFromApplet.readObject();
			System.out.println(" - - - photoComponent - - - "+photoComponent);
			PatientPhotoComponent patientPhoto =  photoComponent;			
			
			patient_id = patientPhoto.getPatientId();
			data = patientPhoto.getImageData();
			*/
			if(isDebugYN) System.out.println(" ::: patient_id ::: "+patient_id+" ::: Module Id ::: "+module_id);		

			inputFromApplet.close();

			width = data.length;
			height = data[0].length;

			if(isDebugYN) System.out.println(" - - - Width - - - "+width+ " - - - Height - - - "+height);

			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			for (int w=0; w<width; w++)
	            for (int h=0; h<height; h++)
		            bi.setRGB(w,h,data[w][h]);

			if(isDebugYN) System.out.println(" - - -  Image Width - - - "+bi.getWidth()+" - - -  Image Height - - - "+bi.getHeight());
			
			String status = "";

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			ImageIO.write( bi, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
		
			baos.close();

			InputStream is = new ByteArrayInputStream(imageInByte);
			con = ConnectionManager.getConnection();
			
			int recCount = 0;
			String sql = "";

			//Added by bhuvana for MO-CRF-20154.
			String sFacilityId = "", iPhotoSharedpath = "", sWebServiceUrl = "" , sDocType ="" , fileCategory = "" , newPDFFolder ="" ,newFileName="";
			int iphotoFolderOption = 0 ,  nDocConfigListsize = 0;

			DocumentConfigOption docConfigOption = new DocumentConfigOption(); 
			List<DocumentConfigBean> oDocConfigList = null;
			DocumentConfigBean oDocumentConfigBean = null;	
			oDocConfigList = new ArrayList<DocumentConfigBean>();
			oDocConfigList = docConfigOption.getDocumentConfigDetails(addedFacilityId,module_id,"P");
			
			nDocConfigListsize = oDocConfigList.size();
			if(isDebugYN) System.out.println("PHO nDocConfigListsize:::::::"+nDocConfigListsize);

			if (nDocConfigListsize>0)
			{	
				if(isDebugYN) System.out.println("list is not null");
				oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
				sFacilityId 	= oDocumentConfigBean.getsFacilityId();
				iphotoFolderOption = oDocumentConfigBean.getsPhotoDocOption();
				iPhotoSharedpath = oDocumentConfigBean.getsDocSharedPath();
				sWebServiceUrl = oDocumentConfigBean.getsDocWebserviceUrl();
				sDocType=oDocumentConfigBean.getsDocType();
				fileCategory=oDocumentConfigBean.getsFileCategory();
				 
				if(isDebugYN) System.out.println("PHO iPhotoSharedpath:::::::"+iPhotoSharedpath);
				if(isDebugYN) System.out.println("PHO iphotoFolderOption:::::::"+iphotoFolderOption);
				if(isDebugYN) System.out.println("PHO sDocType:::::::"+sDocType);
				if(isDebugYN) System.out.println("PHO fileCategory:::::::"+fileCategory);

			}     
			else{
				if(isDebugYN) System.out.println("List size is null...document section was not configured..documents will be stored in db"); 						
			}
			//Ended for MO-CRF-20154.


			/**
			 * Checking whether the PhotoFolderOption is enabled or not.If it is enabled means 1 otherwise 0.If zero means photo stored in DB otherwise it stored to respesctive Sharedpath.
			 */
			
			if(iphotoFolderOption == 0) //Added by bhuvana for MO-CRF-20154.
			{

				if (module_id.equals("MP") || module_id.equals("PP"))
				{
					table_name = "MP_PATIENT_PHOTO";
					PK_column_name = "PATIENT_ID";
					photo_column_name = "PAT_PHOTO_BLOB";
					
				}
				else if (module_id.equals("BD"))
				{
					table_name = "MP_EXT_PERSON_PHOTO";
					PK_column_name = "PERSON_ID";
					photo_column_name = "PERSON_PHOTO_BLOB";
				}

				if(isDebugYN) System.out.println(" - - -  con - - - "+con);

				sql = "select count(*) recordCount from "+ table_name +" where "+ PK_column_name +" = '"+patient_id+"'";
				System.out.println(" - - -  sql - - - "+sql);
				pstmt    = con.prepareStatement(sql);
				rs  = pstmt.executeQuery();				

				if(rs.next())
					recCount = rs.getInt("recordCount");

				if(isDebugYN) System.out.println(" :::  sql :: "+sql+" ::: RecordCount :: "+recCount);	

				sql = "";

                if(pstmt != null) pstmt.close() ; //Added for Checkstyle
				if (recCount>0){
					sql = "Delete from "+ table_name +" where "+ PK_column_name +"  = '"+patient_id+"'";
					pstmt    = con.prepareStatement(sql);
					int deleteCount  = pstmt.executeUpdate();	
					if(deleteCount>0) {				
						if(isDebugYN) System.out.println(" :::  sql :: "+sql+" ::: DeleteCount :: "+deleteCount);	
					}
				}

				//Below Added for Checkstyle
               if(pstmt != null) pstmt.close() ;
               if(rs != null) rs.close() ;

				sql = "insert into "+ table_name +" ("+ PK_column_name +", "+ photo_column_name +", ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, " +
						"ADDED_FACILITY_ID, MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,sysdate,?,?,?,sysdate,?,?)";

				if(isDebugYN) System.out.println(" - - -  sql - - - "+sql);			

				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, patient_id );
				pstmt.setBinaryStream(2, is, imageInByte.length);
				pstmt.setString(3, addedById );
				pstmt.setString(4, clientIpAddress );
				pstmt.setString(5, addedFacilityId );
				pstmt.setString(6, addedById );
				pstmt.setString(7, clientIpAddress );
				pstmt.setString(8, addedFacilityId );

				int s = pstmt.executeUpdate();			

				if(isDebugYN) System.out.println(" - - - s  - - - "+s);

				if(s>0) {				
					status = "Uploaded successfully !";
				}
				else {				
					status = "Sorry, Image could not be uploaded.";
				}

				pstmt.close();

				con.commit();

				//con.close();
				if (con!=null)
				ConnectionManager.returnConnection(con, request);

				is.close();

				// echo it to the applet
				OutputStream outstr = response.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(outstr);
				oos.writeObject(status);
				oos.flush();
				oos.close();

			}  
			//Added by bhuvana for MO-CRF-20154.
			else if(iphotoFolderOption == 1)
			{
				dFileStorage = new DocumentFileStorage();
				if(isDebugYN) System.out.println("iPhotoSharedpath ::: "+iPhotoSharedpath+ " sDocType :::"+sDocType+" fileCategory :::"+fileCategory);

				newFileFolder = dFileStorage.getFilePath(iPhotoSharedpath ,sDocType, fileCategory) ;
				if(isDebugYN) System.out.println("newFileFolder is ::: "+newFileFolder);
				photodocument_Id = dFileStorage.getFileName(patient_id , sDocType , fileCategory);
				if(isDebugYN) System.out.println("document_Id is ::: "+photodocument_Id);

				newPDFFolder = getSharedPath(newFileFolder);
				if(isDebugYN) System.out.println("newPDFFolder is ::: "+newPDFFolder);

				theNewDir = createSharedDir(newPDFFolder);
				if(isDebugYN) System.out.println("theNewDir is ::: "+theNewDir);

				newFileName = getFileName(theNewDir, photodocument_Id);
				if(isDebugYN) System.out.println("newFileName is ::: "+newFileName);
					
				
				FileOutputStream stream = null;
				stream = new FileOutputStream(newFileName);

				if (module_id.equals("MP") || module_id.equals("PP"))
				{
					table_name = "MP_PATIENT_PHOTO";
					PK_column_name = "PATIENT_ID";
					photo_column_name = "PAT_PHOTO_BLOB";
					photo_DB_flag = "PHOTO_DB_FLAG";
					photo_image_path = "PHOTO_IMAGE_PATH";
				}
				else if (module_id.equals("BD"))
				{
					table_name = "MP_EXT_PERSON_PHOTO";
					PK_column_name = "PERSON_ID";
					photo_column_name = "PERSON_PHOTO_BLOB";
					photo_DB_flag = "PHOTO_DB_FLAG";
					photo_image_path = "PHOTO_IMAGE_PATH";
				}

				try {	
						image = bi;		
						ImageIO.write(image, "jpg", stream);
						stream.close();

						status = "Uploaded successfully to the network shared path !";


						if(isDebugYN) System.out.println(" - - -  con - - - "+con);

						sql = "select count(*) recordCount from "+ table_name +" where "+ PK_column_name +" = '"+patient_id+"'";
						System.out.println(" - - -  sql - - - "+sql);
						pstmt    = con.prepareStatement(sql);
						rs  = pstmt.executeQuery();				

						if(rs.next())
							recCount = rs.getInt("recordCount");

						if(isDebugYN) System.out.println(" :::  sql :: "+sql+" ::: RecordCount :: "+recCount);	

						sql = "";

                         if(pstmt != null) pstmt.close() ; //Added for Checkstyle
						if (recCount>0){
							sql = "Delete from "+ table_name +" where "+ PK_column_name +"  = '"+patient_id+"'";
							pstmt    = con.prepareStatement(sql);
							int deleteCount  = pstmt.executeUpdate();	
							if(deleteCount>0) {				
								if(isDebugYN) System.out.println(" :::  sql :: "+sql+" ::: DeleteCount :: "+deleteCount);	
							}
							
							
						}

                        //Below Added for Checkstyle
                         if(pstmt != null) pstmt.close() ;
                         if(rs != null) rs.close() ;
					   sql = "insert into "+ table_name +" ("+ PK_column_name +", "+ photo_column_name +", ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, "+ " MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, "+photo_DB_flag+", "+photo_image_path+") values(?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";

						System.out.println(" - - -  sql - - - "+sql);			

						pstmt = con.prepareStatement(sql);

						pstmt.setString(1, patient_id );
						pstmt.setBinaryStream(2, is, imageInByte.length);
						pstmt.setString(3, addedById );
						pstmt.setString(4, clientIpAddress );
						pstmt.setString(5, addedFacilityId );
						pstmt.setString(6, addedById );
						pstmt.setString(7, clientIpAddress );
						pstmt.setString(8, addedFacilityId );
						pstmt.setInt(9, iphotoFolderOption);
						pstmt.setString(10, newFileName);

						int s = pstmt.executeUpdate();	
							
					}
					catch (Exception e) {
						e.printStackTrace();

						status = "Sorry, Unable to upload the image to the network shared path. "+e.getMessage();
					}
				
					con.commit();

				    if(pstmt!=null)
					pstmt.close();

                    if(con!=null)
					//con.close();
					ConnectionManager.returnConnection(con, request);

					if (is != null)
					{
						is.close();
					}

				OutputStream outstr = response.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(outstr);
				oos.writeObject(status);
				oos.flush();
				oos.close();

			}
			//Ended by bhuvana for MO-CRF-20154.
		
		}
		catch(Exception e)
			{
				e.printStackTrace();
				
			}
		
	}
	
	//Added by bhuvana for for MO-CRF-20154.
	public String getSharedPath(String docSharedPath){
		
		if(isDebugYN) System.out.println("docSharedPath"+docSharedPath);
		String newPDFFolder = "";
        String sFileSeparator = "";
		
		sFileSeparator = System.getProperty("file.separator");
		sFileSeparator = sFileSeparator ;
		newPDFFolder = 	docSharedPath +sFileSeparator;
		if(isDebugYN) System.out.println("newPDFFolder"+newPDFFolder);
		
		return newPDFFolder;
	}

	public File createSharedDir(String newPDFFolder) throws Exception{	
		try{
			theNewDir = new File(newPDFFolder);
			if (!theNewDir.exists())
			{
				theNewDir.mkdirs();
			}
			return theNewDir;
		  }
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Exception - while creating directory "+e.getMessage());
		}
	}
	
	public String getFileName(File theNewDir, String photodocument_Id){

		String timeStampStr = "";
		String newDirfolder = "";
        String sFileSeparator = "";
		timeStampStr = fileName();
        sFileSeparator=System.getProperty("file.separator");
		sFileSeparator = sFileSeparator  ;
		
		newDirfolder = theNewDir+sFileSeparator+photodocument_Id +".jpg";
		if(isDebugYN) System.out.println("newDirfolder"+newDirfolder);
		
		return newDirfolder;
	}
	
	public String fileName(){

		String formattedDate = "";
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyykkmmss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		formattedDate = df.format(new Date());

		return formattedDate;
	}
	//Ended by bhuvana for for MO-CRF-20154.
		
}


