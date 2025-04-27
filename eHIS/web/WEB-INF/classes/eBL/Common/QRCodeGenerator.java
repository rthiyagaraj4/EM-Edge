/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
 1           V210407                        AMS-CRF-0238,AMRI-CRF-0473,    
											GHL-CRF-0635				      Ram kumar S
*/

package eBL.Common;

import com.google.zxing.BarcodeFormat;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.awt.Graphics2D;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.io.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import webbeans.eCommon.ConnectionManager;

public class QRCodeGenerator {
 
    public static void generateQRCodeImage(String text,String strEpisodeType,String patient_id,String visit_num,String episodeno,String facility_id,String added_by_id,String added_ws_no, int width, int height)
            throws WriterException, IOException {
    //	String path=getServletConfig().getServletContext().getRealPath("eBL/images");
    	 CodeSource codeSource = QRCodeGenerator.class.getProtectionDomain().getCodeSource();
    	 File rootPath = null;
    	 String filepath="";
    	 String path="";
    	 try{
    	 rootPath = new File(codeSource.getLocation().toURI().getPath());
    	 filepath=rootPath.toString();
    	 
    	 
    	 } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } 
    	 
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        ByteMatrix byteMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		
        path=filepath+text;
        File file = new File(path+".png");
        MatrixToImageWriter.writeToFile(byteMatrix, "PNG", file);
       
     
         File input = new File(path+".png");
        
            BufferedImage image = ImageIO.read(input);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(result, "jpeg", baos);

			baos.flush();
			byte[] imageInByte = baos.toByteArray();
		
			baos.close();

			InputStream is = new ByteArrayInputStream(imageInByte);
			Connection con = null;
			PreparedStatement pstmt = null;
        
			input.delete();
       
        try {
	        con = ConnectionManager.getConnection();
	        String insertQrCodeSql = "insert into bl_qrcode_print (OPERATING_FACILITY_ID,PATIENT_ID,EPISODE_TYPE,VISIT_ID,EPISODE_ID,QR_CODE,ADDED_AT_WS_NO,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?)";
	        pstmt=con.prepareStatement(insertQrCodeSql);
	        pstmt.setString(1, facility_id);
	        pstmt.setString(2, patient_id);
	        pstmt.setString(3, strEpisodeType);
	        pstmt.setString(4, visit_num);
			pstmt.setString(5, episodeno);
	        pstmt.setBinaryStream(6, is, imageInByte.length);
			pstmt.setString(7, added_ws_no);
			pstmt.setString(8, added_by_id);
			pstmt.setString(9, facility_id);
			pstmt.setString(10, added_ws_no);
			pstmt.setString(11, added_by_id);
			pstmt.setString(12, facility_id);
			
	        pstmt.executeUpdate();
	        con.commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		//added against checkstyle
		finally{
			try{
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e){
				System.err.println("Exception in generateQRCodeImage:"+e);
			}						
    }
			}
    //V210407 Starts
    public static void generateQRCodeImage(int width, int height,HashMap<String,String> valuesGen)
            throws WriterException, IOException {
    	Connection conCount =null;
        PreparedStatement pstmtCount =null;
        System.err.println("Inside generateQRCodeImage");
        try {
        String facility_id=(String) valuesGen.get("facility_id");
        String episode_id=(String) valuesGen.get("episode_id");
        String visitId=(String) valuesGen.get("visitId");
        String patId=(String) valuesGen.get("patId");
        String logInId=(String) valuesGen.get("logInId");
        String episodeType=(String) valuesGen.get("episodeType");
        String WsNo=(String) valuesGen.get("WsNo");
        String docNum=(String) valuesGen.get("docNum");
        String docTypeCode=(String) valuesGen.get("docTypeCode");
        String text=(String) valuesGen.get("qrCode");
        System.err.println("facility_id  "+facility_id);
        System.err.println("episode_id  "+episode_id);
        System.err.println("visitId  "+visitId);
        System.err.println("patId  "+patId);
        System.err.println("logInId  "+logInId);
        System.err.println("episodeType  "+episodeType);
        System.err.println("WsNo  "+WsNo);
        System.err.println("text  "+text);
        int visit_Id=0;
        int episodeId=0;
        System.err.println("visit_Id  "+ visit_Id+"   episodeId  "+ episodeId);
        try{
        if(visitId!=null && !visitId.equals("")){
        	visit_Id=Integer.parseInt(visitId);
        }
        if(episode_id!=null && !episode_id.equals("")){
        	episodeId=Integer.parseInt(episode_id);
        }
        System.err.println("visit_Id  "+ visit_Id+"   episodeId  "+ episodeId);
        }catch(Exception f){
        	System.err.println("Exception in QrCode NUmber FOrmat  "+f.toString());
        	 f.printStackTrace();
        }
        
        File rootPath = null;
        String filepath = "";
        String path = "";
        try {
			System.err.println("Line 159 ");
        	final CodeSource codeSource = QRCodeGenerator.class.getProtectionDomain().getCodeSource();
			System.err.println("Line 161 ");
        	rootPath = new File(codeSource.getLocation().toURI().getPath());
			System.err.println("Line 163 ");
       	 filepath=rootPath.toString();
		 System.err.println("Line 165 ");
       	 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		System.err.println("Line 171 ");
        final QRCodeWriter qrCodeWriter = new QRCodeWriter();
		System.err.println("Line 173 ");
        ByteMatrix byteMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		System.err.println("Line 175 ");
        path = filepath + docNum;
        System.err.println("path  "+path);
        final File file = new File(path + ".png");
        MatrixToImageWriter.writeToFile(byteMatrix, "PNG", file);
        final File input = new File(path + ".png");
        final BufferedImage image = ImageIO.read(input);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), 1);
        result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
        ImageIO.write(result, "jpeg", baos);
        baos.flush();
        final byte[] imageInByte = baos.toByteArray();
        baos.close();
        final InputStream is = new ByteArrayInputStream(imageInByte);
        input.delete();

        

        System.err.println("Before Insert  ");
				 conCount = ConnectionManager.getConnection();
				String insertQrCodeSql = "INSERT INTO bl_qrcode_print (OPERATING_FACILITY_ID,PATIENT_ID,EPISODE_ID,VISIT_ID,EPISODE_TYPE,QR_CODE,ADDED_BY_ID,"+
				 "ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,doc_type_code,doc_num) "+
				 "values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";
		        System.err.println(" Insert  insertQrCodeSql "+insertQrCodeSql);
		        pstmtCount = conCount.prepareStatement(insertQrCodeSql);
		        pstmtCount.setString(1, facility_id);
		        pstmtCount.setString(2, patId);
		        pstmtCount.setInt(3, episodeId);
		        pstmtCount.setInt(4, visit_Id);
		        pstmtCount.setString(5, episodeType);
		        pstmtCount.setBinaryStream(6,is, imageInByte.length);
		        pstmtCount.setString(7, logInId);
		        pstmtCount.setString(8, WsNo);
		        pstmtCount.setString(9, facility_id);
		        pstmtCount.setString(10, logInId);
		        pstmtCount.setString(11, WsNo);
		        pstmtCount.setString(12, facility_id);	
		        pstmtCount.setString(13, docTypeCode);	
		        pstmtCount.setString(14, docNum);		        
		        pstmtCount.executeUpdate();
		        conCount.commit();
				pstmtCount.close();
				conCount.close();
        } catch (Exception ex) {
	        System.err.println("Exception in countSQL  "+ex.toString());
        	ex.printStackTrace();
        }finally {
    	    if (pstmtCount != null) {
    	        try {
    	        	pstmtCount.close();
    	        } catch (SQLException eP) { eP.printStackTrace();}
    	    }
    	    if (conCount != null) {
    	        try {
    	        	conCount.close();
    	        } catch (SQLException eC) { eC.printStackTrace();}
    	    }
    	}
        
    }
   //V210407 Ends

}