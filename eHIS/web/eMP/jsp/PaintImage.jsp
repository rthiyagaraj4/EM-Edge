<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% 
request.setCharacterEncoding("UTF-8");
//int no_of_days = 0;//checkstyle changes 35886
//int pat_photo_rnwl_dys = 0;  
Connection con = null;
try {
	con = ConnectionManager.getConnection(request);
	Statement st = null;
	ResultSet res = null;
	byte [] byteArr = null;
	/*Added By Dharma against MO-CRF-20154 [IN:070025] Start*/
	int PHOTO_DB_FLAG = 0;
	String PHOTO_IMAGE_PATH = "";
	/*Added By Dharma against MO-CRF-20154 [IN:070025] End*/
	String patient_id = request.getParameter("patient_id");
	String pat_photo_in_db_yn = request.getParameter("pat_photo_in_db_yn");
	String pat_photo_http_path = request.getParameter("pat_photo_http_path");
	pat_photo_http_path=pat_photo_http_path.replace("|","\\");
	st = con.createStatement();	
	/*
	res = st.executeQuery("select pat_photo_renewal_alert_days from mp_param");
	if(res!=null && res.next()) {
	pat_photo_rnwl_dys = res.getInt("pat_photo_renewal_alert_days");
	}  
	if(res != null) res.close(); 
	*/
	/*PHOTO_DB_FLAG,PHOTO_IMAGE_PATH Added By Dharma against MO-CRF-20154 [IN:070025]*/
	if(pat_photo_in_db_yn.equals("Y")){
		res = st.executeQuery("Select PAT_PHOTO_BLOB,PHOTO_DB_FLAG,PHOTO_IMAGE_PATH from MP_PATIENT_PHOTO where PATIENT_ID = '"+patient_id+"' ");
		if(res!=null && res.next()) {
			Blob pat_photo_blob = res.getBlob("PAT_PHOTO_BLOB");				
			byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());	
			PHOTO_DB_FLAG	= res.getInt("PHOTO_DB_FLAG");
			PHOTO_IMAGE_PATH = res.getString("PHOTO_IMAGE_PATH")==null?"":res.getString("PHOTO_IMAGE_PATH");

			
		} 	

		if(PHOTO_DB_FLAG==0){
			response.reset();
			response.setContentType("image/gif");
			OutputStream o = response.getOutputStream();
			o.write(byteArr); 
			o.flush();
			o.close(); 
		}else if(PHOTO_DB_FLAG==1 && !PHOTO_IMAGE_PATH.equals("")){
			File f1 = new File(PHOTO_IMAGE_PATH);
			System.err.println("PHOTO_IMAGE_PATH==>"+PHOTO_IMAGE_PATH);
			if(f1.exists()){
				System.err.println("Image Exists");
				FileInputStream fis1 = new FileInputStream(f1);
				byteArr = new byte[(int)f1.length()];
				fis1.read(byteArr,0,byteArr.length);
				fis1.close(); 
				response.reset();
				response.setContentType("image/gif");
				OutputStream o1 = response.getOutputStream();
				o1.write(byteArr);      
				o1.flush();
				o1.close(); 
			}
		}

		if(res != null) res.close();
		if(st != null) st.close();
	}else if(pat_photo_in_db_yn.equals("N")){
		/*res = st.executeQuery("Select pat_photo_os_path, pat_photo_http_path from sm_db_info");
		while(res.next()){
			pat_photo_http_path = res.getString("pat_photo_http_path");
		}
		if(res != null) res.close();
		if(st != null) st.close();*/
		String path = pat_photo_http_path+patient_id+".jpg";
		File f = new File(path);	
		if(f.exists()){
			FileInputStream fis = new FileInputStream(f);
			byteArr = new byte[(int)f.length()];
			fis.read(byteArr,0,byteArr.length);
			fis.close(); 
			response.reset();
			response.setContentType("image/gif");
			OutputStream o = response.getOutputStream();
			o.write(byteArr);      
			o.flush();
			o.close(); 
		}
	}
} catch (Exception e) {
	e.printStackTrace(); 
	System.out.println("Exception in PaintImage.jsp...");
} finally {
	if(con!=null)
	con.close();
}
%>
