package eCommon;
import java.io.*;
import java.awt.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.ArrayList;

import java.util.zip.*;
import java.awt.image.BufferedImage;

import java.sql.*;

import webbeans.eCommon.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import eCommon.PatientDocument.PatientDocumentComponent;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle; 
import com.itextpdf.text.pdf.PdfContentByte; 
import com.itextpdf.text.Element; 

/**
 * Simple demonstration for an Applet <-> Servlet communication.
 */
public class PatientDocumentServlet  extends javax.servlet.http.HttpServlet {
	/**
	 * Get a String-object from the applet and send it back.
	 */
	//private static final long serialVersionUID = -5302010108271068350L; //Commented for checkstyle
	//ArrayList<Image> imageArray = new ArrayList<Image>();

	//ArrayList<PatientImageComponent> imageComponentList = new ArrayList<PatientImageComponent>();

	int width;
    int height;	

	String facility_id = "", encounter_id = "", patient_id = "";

	String document_Id = "", docMainType = "", docType = "";

	int docSaveAs = 0, docFolderOption = 0; String docSharedPath = "";
	
	BufferedImage image =  null;

	ArrayList<byte[]> scannedImagesList = new ArrayList<byte[]>();

	byte compressedData[];

	File theNewDir = null;

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
			//ResultSet rs            = null ; //Commented for checkstyle
			ResultSet rsCheckDocId = null;
			String checkDocIdSql= null;

			String addedById = "";
			String addedFacilityId = "";
			String clientIpAddress = "";

			String status = "";

			session			=   request.getSession(true) ;

			p = (java.util.Properties) session.getValue( "jdbc" ) ;

			System.out.println(" - - - p - - - "+p);
			
			//String locale = (String) p.getProperty("LOCALE"); //Commented for checkstyle
			addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
			clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

			//response.setContentType("application/x-java-serialized-object");
			response.setContentType("application/octet-stream");			

			// read a String-object from applet
			// instead of a String-object, you can transmit any object, which
			// is known to the servlet and to the applet

			System.out.println(" - - - inside PatientDocumentServlet - - - ");
			
			assignValuesFromRequest(request);		

			String newPDFFolder = "", newFileName = "";
			//String timeStampStr = "", //Commented for checkstyle

			if (docFolderOption > 0) // to save to the shared path
			{
				newPDFFolder = getSharedPath(docSharedPath, document_Id);

				theNewDir = createSharedDir(newPDFFolder);

				newFileName = getFileName(theNewDir);
			}
			
			int imageCount = 0;
			//int data[][] = null; //Commented for checkstyle
			byte[] imageInByte = null;
			
			FileOutputStream stream = null;

			InputStream is = null;

			if (docFolderOption > 0) // to save to the shared path
			{
				stream = new FileOutputStream(newFileName);

				try {

					imageCount = scannedImagesList.size();

					if (docSaveAs>0) // to save image as JPG
					{
						for (int i=0;i<imageCount;i++ )
						{
							compressedData = scannedImagesList.get(i);	
							image = getImage(compressedData);			
							ImageIO.write(image, "jpg", stream);
						}
						stream.close();
					}	
					else // to save image as PDF
					{
						Document document = null;
						PdfWriter pdfWriter = null;

						try
						{
							document = new Document();
							pdfWriter = PdfWriter.getInstance(document, stream);	
							
							addImagesToPdf(scannedImagesList, document, pdfWriter);

							document.close();

						}
						catch (Exception e) {
							System.out.println(e.getMessage());
							throw new Exception("general");
						}
						finally{
							if(pdfWriter != null) { 
								pdfWriter.flush(); 
								try {  
									pdfWriter.close();  
								} catch(Exception e) {
									System.out.println(e.getMessage());
								} 
							} 
							try { 
								if(stream != null) { 
									stream.flush(); 
									stream.close(); 
								}
							} catch(Exception e) {} 
						}

					}

				}catch(IllegalArgumentException ile)
				{
					ile.printStackTrace();
					throw new IllegalArgumentException("illegal");
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
					throw new IOException("ioexception");
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw new Exception("general");
				}
				finally 
				{
					if (stream != null)
					{
						stream.close();
					}					
				}
				System.out.println(" * * * newFileName: "+newFileName);
			}
			else // to save the image in DB
			{
				imageCount = scannedImagesList.size();

				if (docSaveAs>0) // to save image as JPG
				{
					ByteArrayOutputStream baos = null;

					baos = new ByteArrayOutputStream();

					System.out.println(" ::: Input stream check for Image ::: ");

					for (int i=0;i<imageCount;i++ )
					{
						System.out.println(" ::: Input stream check for Image ::: "+i);

						compressedData = scannedImagesList.get(i);	
						image = getImage(compressedData);			
						status = "";

						if (image != null)
						{
							System.out.println(" ::: Image is not null ::: ");
						}
						
						ImageIO.write( image, "jpg", baos );
						imageInByte = baos.toByteArray();

						if (imageInByte != null)
						{
							System.out.println(" ::: imageInByte is not null ::: ");
						}
						
						baos.flush();
						baos.close();

						is = new ByteArrayInputStream(imageInByte);

						if (is != null)
						{
							System.out.println(" ::: Input stream is not null ::: ");
						}
					}					
				}	
				else // to save image as PDF
				{
					ByteArrayOutputStream baos = null;
					
					Document document = null;
					PdfWriter pdfWriter = null;

					try
					{
						baos = new ByteArrayOutputStream();
						document = new Document();
						pdfWriter = PdfWriter.getInstance(document, baos);		
						
						addImagesToPdf(scannedImagesList, document, pdfWriter);

						document.close();

						baos.flush();
						imageInByte = baos.toByteArray();

						baos.close();

						is = new ByteArrayInputStream(imageInByte);

					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					finally{
						if(pdfWriter != null) { 
							pdfWriter.flush(); 
							try {  
								pdfWriter.close();  
							} catch(Exception e) {
								System.out.println(e.getMessage());
							} 
						} 
						try { 
							if(stream != null) { 
								stream.flush(); 
								stream.close(); 
							}
						} catch(Exception e) {} 
					}
				}
			
			}						
			
			con = ConnectionManager.getConnection(p);
           
			checkDocIdSql="select * from EM_SCAN_DOCUMENT_TEMP where doc_id = ?";

			pstmt = con.prepareStatement(checkDocIdSql);
			pstmt.setString(1, document_Id);

			rsCheckDocId=pstmt.executeQuery();

			if(rsCheckDocId!=null && rsCheckDocId.next())
				{
				     if(pstmt!=null)
				     pstmt.close();

					 con.commit();

                     if(con!=null)
					 con.close();

					 status="Document has already been saved with this Document Id "+document_Id+" !   Close and Reopen the Scanner Window!! ";
					 System.out.println(" - - -  status - - - "+status);
					 OutputStream outstr = response.getOutputStream();
					 ObjectOutputStream oos = new ObjectOutputStream(outstr);
					 oos.writeObject(status);
					 oos.flush();
					 oos.close();
                     if(rsCheckDocId!=null) rsCheckDocId.close(); //Added for checkstyle
				}
			else
				{
					String sql = "insert into EM_SCAN_DOCUMENT_TEMP (DOC_ID, DOC_MAIN_TYPE, DOC_TYPE, DOC_DB_FLAG, DOC_FILE, DOC_FILE_PATH, DOC_FILE_TYPE, DOC_SAVE_STATUS) values(?,?,?,?,?, ?,?,?)";

					System.out.println(" - - -  sql - - - "+sql);			

					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, document_Id );
					pstmt.setString(2, docMainType);
					pstmt.setString(3, docType );
					pstmt.setInt(4,docFolderOption);
					if (docFolderOption == 0) // to save the image to the database
					{
						pstmt.setBinaryStream(5, is, imageInByte.length);
						pstmt.setString(6, null );
					}
					else
					{
						pstmt.setNull(5, java.sql.Types.BLOB);
						pstmt.setString(6, newFileName );
					}

					if (docSaveAs>0)
					{
						pstmt.setString(7, "JPG" );
					}
					else
					{
						pstmt.setString(7, "PDF" );
					}
					
					pstmt.setInt(8, 0 );
					int s = pstmt.executeUpdate();			

					System.out.println(" - - - s  - - - "+s);
					
					if(s>0) {				
						status = "Uploaded successfully !";
					}
					else {				
						status = "Unable to upload the image to the DB.";
					}

					con.commit();

				    if(pstmt!=null)
					pstmt.close();

                    if(con!=null)
					con.close();

					if (is != null)
					{
						is.close();
					}
						

					/*
					PDFImageWriter writer = new PDFImageWriter(new FileOutputStream(newPDF));

					writer.open();

					int imageCount = scannedImagesList.size();
					for (int i=0;i<imageCount;i++ )
					{
						compressedData = scannedImagesList.get(i);
						image = getImage();

						writer.addImage(image);
					}
					writer.close();

					*/								
					
					status = "Uploaded successfully !";

					// echo it to the applet
					OutputStream outstr = response.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(outstr);
					oos.writeObject(status);
					oos.flush();
					oos.close();		
			}
	
		}catch(IOException ioe)
		{
			String status=null;
			
			ioe.printStackTrace(System.err);
			status=ioe.getMessage();
			OutputStream outstr = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outstr);
			oos.writeObject(status);
			oos.flush();
			oos.close();
		}
		catch(SQLException sqlexcp)
		{
			String status=null;
			sqlexcp.printStackTrace(System.err);
			status=sqlexcp.getMessage();
			OutputStream outstr = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outstr);
			oos.writeObject(status);
			oos.flush();
			oos.close();					       
		}
		catch(Exception e)
		{
			String status=null;
			e.printStackTrace(System.err);	
			status=e.getMessage();
			OutputStream outstr = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outstr);
			oos.writeObject(status);
			oos.flush();
			oos.close();			
		}
	}
	
	protected int[][] getUncompressedData(byte[] imageData){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
            ObjectInputStream ois = new ObjectInputStream(new GZIPInputStream(bais,512*1024));
            int data[][] = (int[][])ois.readObject();
            ois.close();

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 

    public BufferedImage getImage(byte[] imageData){
        
        int data[][] = getUncompressedData(imageData);
        BufferedImage bi=null;
        if(data != null)
        {
			width = data.length;
			height = data[0].length;
	
			bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	
	        for (int w=0; w<width; w++)
	            for (int h=0; h<height; h++)
	                bi.setRGB(w,h,data[w][h]);
        }

        return bi;
    }

	public String fileName(){
		String formattedDate = "";

		//Date now = new Date(); //Commented for checkstyle

		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyykkmmss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		formattedDate = df.format(new Date());

		return formattedDate;
	}

	public static void saveImageAsJPEG(BufferedImage image, OutputStream stream)
	  throws IOException {
		ImageIO.write(image, "jpg", stream);
	}

	public void assignValuesFromRequest(HttpServletRequest request) throws Exception{
		Object obj = null;
		PatientDocumentComponent documentComponent = null;

		try{
		
			//String lStr = ""; //Commented for checkstyle
			InputStream in = request.getInputStream();
			ObjectInputStream inputFromApplet = new ObjectInputStream(in);
			obj = inputFromApplet.readObject();
		
			documentComponent = (PatientDocumentComponent)obj;

			facility_id = documentComponent.getFacilityId();				
			encounter_id = documentComponent.getEncounterId();
			patient_id = documentComponent.getPatientId();		

			document_Id = documentComponent.getDocumentId();
			docMainType = documentComponent.getDocMainType();
			docType = documentComponent.getDocType();			

			docSaveAs = documentComponent.getDocSaveAs();		 
			docFolderOption = documentComponent.getDocFolderOption();
			docSharedPath = documentComponent.getDocSharedPath();	
			
			scannedImagesList = documentComponent.getImageData();

			inputFromApplet.close();
		} catch (Exception e) {
			System.out.println(" Exception - while Assigning Values ::: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("General Exception");
		}
	}	

	public String getSharedPath(String docSharedPath, String document_Id){

		String newPDFFolder = "";
        String sFileSeparator = "";
		if (docFolderOption > 0) // to save to the shared path
		{
			//Added by prithivi on 06/04/2016
			sFileSeparator = System.getProperty("file.separator");
			sFileSeparator = sFileSeparator + sFileSeparator;
			//newPDFFolder = 	docSharedPath +"\\"+document_Id;
			newPDFFolder = 	docSharedPath +sFileSeparator+document_Id;
		}
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
	
	public String getFileName(File theNewDir){

		String timeStampStr = "";
		String newPDF = "";
        String sFileSeparator = "";
		timeStampStr = fileName();
        sFileSeparator=System.getProperty("file.separator");
		sFileSeparator = sFileSeparator + sFileSeparator;
		if (docSaveAs>0)
		{
			//newPDF = theNewDir+"\\" +document_Id + "_"+timeStampStr+".jpg";
			newPDF = theNewDir+sFileSeparator+document_Id +".jpg";
		}
		else
		{
			//newPDF = theNewDir+"\\" +document_Id + "_"+timeStampStr+".pdf";
			newPDF = theNewDir+sFileSeparator+document_Id +".pdf";
		}	
		return newPDF;
	}

	public void  addImagesToPdf(ArrayList<byte[]> scannedImagesList, Document document, PdfWriter pdfWriter) throws Exception
	{
		byte imageData[];
		int imageCount = 0;
		boolean documentOpen = false; 

		try
		{			
			imageData = null;
			imageCount = scannedImagesList.size();
			image = null;

			for (int i=0;i<imageCount;i++ )
			{
				imageData = scannedImagesList.get(i);	
				image = getImage(imageData);
				float pageWidth = ((float)image.getWidth()); 
				float pageHeight = ((float)image.getHeight()); 
				System.out.println( " ::: "+i+" ::: "+pageWidth+ " ::: "+pageHeight);
				//document.setPageSize(new Rectangle(pageWidth, pageHeight));
				
				if(!documentOpen) { 
					documentOpen = true; 
					document.open(); 
				} 

				document.newPage(); 				 								 

				PdfContentByte cb = pdfWriter.getDirectContent(); 
				com.itextpdf.text.Image pdfImage = com.itextpdf.text.Image.getInstance(cb, image, 1); 
				//pdfImage.scaleToFit(pageWidth/2,pageHeight/2);
				pdfImage.setAlignment(Element.ALIGN_CENTER); 
				pdfImage.setAbsolutePosition(150f, 600f); 

				cb.addImage(pdfImage); 

				image = null;

			}
			pdfWriter.flush();			

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Exception - General exception when adding images to the pdf "+e.getMessage());
		}
		finally{
			if(pdfWriter != null) { 
				pdfWriter.flush(); 				
			} 
			
		}

	}

}
