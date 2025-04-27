package eCA;
import java.io.*;
import java.awt.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.ArrayList;

import java.util.zip.*;
import java.awt.image.BufferedImage;

import java.sql.*;

import webbeans.eCommon.*;

import javax.imageio.ImageIO;

import eCA.PatientDocument.PatientDocumentComponent;

/**
 * Simple demonstration for an Applet <-> Servlet communication.
 */
public class ImageLoadServlet  extends javax.servlet.http.HttpServlet {
	/**
	 * Get a String-object from the applet and send it back.
	 */
	private static final long serialVersionUID = -5302010108271068350L;
	//ArrayList<Image> imageArray = new ArrayList<Image>();

	//ArrayList<PatientImageComponent> imageComponentList = new ArrayList<PatientImageComponent>();

	int width;
    int height;

	String facility_id = "", encounter_id = "", patient_id = "";
	int data[][];

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

			session			=   request.getSession(true) ;

			p = (java.util.Properties) session.getValue( "jdbc" ) ;

			System.out.println(" - - - p - - - "+p);
			
			String locale = (String) p.getProperty("LOCALE");
			addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
			clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

			System.out.println(" :::  addedFacilityId :: "+addedFacilityId+" ::: clientIpAddress :: "+clientIpAddress+" ::: addedById :: "+addedById);

			//response.setContentType("application/x-java-serialized-object");
			response.setContentType("application/octet-stream");
			

			// read a String-object from applet
			// instead of a String-object, you can transmit any object, which
			// is known to the servlet and to the applet

			System.out.println(" - - - inside PatientDocumentServlet - - - ");

			Object obj = null;
			PatientDocumentComponent documentComponent = null;
			
			String lStr = "";
			InputStream in = request.getInputStream();
			System.out.println(" - - - in - - - "+in);
			ObjectInputStream inputFromApplet = new ObjectInputStream(in);
			//imageComponentList = (ArrayList)inputFromApplet.readObject();
			obj = inputFromApplet.readObject();
			System.out.println(" - - - obj - - - "+obj);
		
			documentComponent = (PatientDocumentComponent)obj;

			facility_id = documentComponent.getFacilityId();				
			encounter_id = documentComponent.getEncounterId();
			patient_id = documentComponent.getPatientId();
			data = documentComponent.getImageData();
			System.out.println(" - - - facility_id - - - "+facility_id+ " - - - encounter_id - - - "+encounter_id+ " - - - patient_id - - - "+patient_id);		

			/*
			for(PatientImageComponent imageComponent : imageComponentList){
				facility_id = imageComponent.getFacilityId();				
				encounter_id = imageComponent.getEncounterId();
				patient_id = imageComponent.getPatientId();
				data = imageComponent.getImageData();
				System.out.println(" - - - facility_id - - - "+facility_id+ " - - - encounter_id - - - "+encounter_id+ " - - - patient_id - - - "+patient_id);
			}
			*/		
			

			inputFromApplet.close();

			//ObjectInputStream ois = new ObjectInputStream(new GZIPInputStream(in,512*1024));
            //int data[][] = (int[][])ois.readObject();
            //ois.close();
			
			width = data.length;
			height = data[0].length;

			System.out.println(" - - - Width - - - "+width+ " - - - Height - - - "+height);

			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			for (int w=0; w<width; w++)
	            for (int h=0; h<height; h++)
		            bi.setRGB(w,h,data[w][h]);

			//imageArray = (ArrayList<Image>) inputFromApplet.readObject();	
			//lStr = (String) inputFromApplet.readObject();	
			
			System.out.println(" - - -  Image Width - - - "+bi.getWidth()+" - - -  Image Height - - - "+bi.getHeight());
			
			String status = "";

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( bi, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();

			baos.close();

			InputStream is = new ByteArrayInputStream(imageInByte);
			con = ConnectionManager.getConnection(p);
			
			/*
			System.out.println(" - - -  con - - - "+con);
			
			String sql = "Select APPL_USER_NAME from SM_APPL_USER WHERE APPL_USER_ID = 'SYSADMIN' ";

			pstmt    = con.prepareStatement(sql);

			rs  = pstmt.executeQuery();

			if(rs.next())
					status = rs.getString("APPL_USER_NAME")==null?"":rs.getString("APPL_USER_NAME");


			*/
			
			long encounterid = Long.parseLong(encounter_id);

			String sql = "insert into EM_IMAGE_DATA (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, IMAGE_TYPE, IMAGE_DATA, " +  
							" ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, " +
							" MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?, ?,SYSDATE,?,?, ?,SYSDATE,?,?)";

			System.out.println(" - - -  sql - - - "+sql);			

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, facility_id );
			pstmt.setLong(2, encounterid);
			pstmt.setString(3, patient_id );
			pstmt.setInt(4,1);
			pstmt.setBinaryStream(5, is, imageInByte.length);
			pstmt.setString(6, addedById );
			pstmt.setString(7, clientIpAddress );
			pstmt.setString(8, addedFacilityId );
			pstmt.setString(9, addedById );
			pstmt.setString(10, clientIpAddress );
			pstmt.setString(11, addedFacilityId );

			int s = pstmt.executeUpdate();			

			System.out.println(" - - - s  - - - "+s);
			
			if(s>0) {				
				status = "Uploaded successfully !";
			}
			else {				
				status = "unsucessfull to upload image.";
			}

			pstmt.close();

			con.commit();

			con.close();

			is.close();

			
			// echo it to the applet
			OutputStream outstr = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outstr);
			oos.writeObject(status);
			oos.flush();
			oos.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
