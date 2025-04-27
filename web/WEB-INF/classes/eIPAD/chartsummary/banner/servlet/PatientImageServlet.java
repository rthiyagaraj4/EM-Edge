/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.banner.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import webbeans.eCommon.ConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.InputStream;

import eIPAD.chartsummary.banner.response.BannerConstants;

/**
 * Servlet implementation class PatientImageServlet 
 */
public class PatientImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientImageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String patientId = request.getParameter("PatientId")==null?"":request.getParameter("PatientId");
		String respId = (String)session.getAttribute("responsibility_id")==null?"":(String)session.getAttribute("responsibility_id");
		
		if(!respId.equals("")&&!patientId.equals("")){
			
			String sqlPhotoAccessYN = "select view_pat_photo_yn from mp_access_rights where resp_id ='"+respId+"'";
			String photoAccessYN = "N";
			String sqlPhotoInDB = "select pat_photo_in_db_yn from mp_all_patients_vw where patient_id='"+patientId+"'";
			String photoInDBYN = "N";
			byte [] byteArr = null;
			OutputStream out = response.getOutputStream();
			
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;



			try{
				conn = ConnectionManager.getConnection(request);
				stmt = conn.createStatement();	
				rs = stmt.executeQuery(sqlPhotoAccessYN);
				if(rs != null){
					while(rs.next()){
						photoAccessYN = rs.getString(1);
					}
				}
				rs.close();
				stmt.close();
				//if photo is accessible for the practitioner based on his responsibility ID
				if(photoAccessYN.equals("Y")){
					stmt = conn.createStatement();	
					rs = stmt.executeQuery(sqlPhotoInDB);
					if(rs != null){
						while(rs.next()){
							photoInDBYN = rs.getString(1);
						}
					}
					rs.close();
					stmt.close();
					
					//if photo is available as a blob in db
					if(photoInDBYN.equalsIgnoreCase("Y")){
						stmt = conn.createStatement();
						rs = stmt.executeQuery("Select PAT_PHOTO_BLOB from MP_PATIENT_PHOTO where PATIENT_ID = '"+patientId+"' ");
						if(rs!=null && rs.next()) {
							Blob pat_photo_blob = rs.getBlob("PAT_PHOTO_BLOB");				
							byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());		
						} 	
						response.reset();
						response.setContentType("image/gif");
						
						out.write(byteArr);      
						out.flush();
						out.close(); 
					}
					//photo is not in db, try file path photo
					else{
						String patPhotoHttpPath = "";
						stmt = conn.createStatement();
						rs = stmt.executeQuery("Select pat_photo_os_path, pat_photo_http_path from sm_db_info");
						while(rs.next()){
							patPhotoHttpPath = rs.getString("pat_photo_http_path");
						}
						String path = patPhotoHttpPath+patientId+".jpg";
						File f = new File(path);	
						//if the file  exist in the path
						if(f.exists()){
							
							FileInputStream fis = new FileInputStream(f);
							byteArr = new byte[(int)f.length()];
							fis.read(byteArr,0,byteArr.length);
							fis.close(); 
							response.reset();
							response.setContentType("image/gif");
							OutputStream o = response.getOutputStream();
							out.write(byteArr);      
							out.flush();
							out.close(); 
						}
						//photo file does not exists in the path
						else{
							displayDefaultImage(response);
						}
					}
				}
				//photo is not accessible for the give responsibility ID
				else{
					displayDefaultImage(response);
				}
				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}finally{
				try{
					if(rs != null)
						rs.close();	
					if(stmt != null)
						stmt.close();
				}catch(Exception ex){
					// cannot do any thing
				}
				ConnectionManager.returnConnection(conn, request);
			}
			
		}
		else{
			displayDefaultImage(response);
		}
		
	}
	
	private void displayDefaultImage(HttpServletResponse response) throws IOException{
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream(BannerConstants.DEFAULT_PATIENT_IMAGE);
		int read=0;
		byte[] bytes = new byte[1024];
		response.reset();
		response.setContentType("image/gif");
		OutputStream os = response.getOutputStream();
		while((read = is.read(bytes))!= -1){
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
