/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;


public class DisplayImagesDetailsServlet extends HttpServlet {
	
	public DisplayImagesDetailsServlet() {
	    super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection con = null;
		PreparedStatement ptsmt = null;
		ResultSet rs = null;
		java.sql.Blob hist_blob = null;
		BufferedOutputStream Buffout = null;
		String accessionnum = request.getParameter("accessionnum")==null?"":request.getParameter("accessionnum");
		String contr_sys_event_code = request.getParameter("contr_sys_event_code")==null?"":request.getParameter("contr_sys_event_code");
		String file_seq_no = request.getParameter("file_seq_no")==null?"0":request.getParameter("file_seq_no");
		String qryHistData = "";
		try{
		    con = ConnectionManager.getConnection(request);
		    qryHistData = "select OBJTYPE, HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and  FILE_SEQ_NO = ?";		
			ptsmt = con.prepareStatement(qryHistData);
			ptsmt.setString(1,accessionnum);
			ptsmt.setString(2,contr_sys_event_code);
			ptsmt.setString(3,file_seq_no);
			rs = ptsmt.executeQuery();
			if(rs.next()) {
				String[] objArray =((String)rs.getString("OBJTYPE")).split("\\/"); //IN049722
				if("image".equals(objArray[0])){ //IN049722
					hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");        	 
					long len = hist_blob.length();  
					byte[] by = new byte[(int)len];  
					InputStream readImg = hist_blob.getBinaryStream();  
					int index = readImg.read(by, 0, (int)len);  

					response.reset();  
					response.setContentType(rs.getString("OBJTYPE"));  
					response.getOutputStream().write(by, 0, (int)len);  
					response.getOutputStream().flush();  
				//IN049722 Start.
				}else{
					response.setContentType(rs.getString("OBJTYPE"));
					hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");
					InputStream in = hist_blob.getBinaryStream();

					long len = hist_blob.length();
					Buffout = new BufferedOutputStream( response.getOutputStream() );
					byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
					int index = in.read(by , 0 , (int)len);

					while ( index != -1) {
					Buffout.write(by , 0, index);
					index = in.read ( by , 0 , (int)len );
					}
					Buffout.flush();
				}
				//IN049722 End.
			}
	    }catch(Exception ex){
	        ex.printStackTrace();
	    }finally{
			try{
				if(rs!=null)rs.close();
				if(ptsmt!=null)ptsmt.close();
				if(con!=null)con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
