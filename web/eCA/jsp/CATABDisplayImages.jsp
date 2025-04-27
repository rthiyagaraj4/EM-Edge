<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<body onKeyDown = 'lockKey()' bgcolor="#031B47" text="#ffffff">
<TABLE width="100%" height=100% border=0 cellpadding=0 cellspacing=0>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement ptsmt = null;
	ResultSet rs = null;

	java.sql.Blob img_blob = null;
	BufferedOutputStream Buffout1 = null;
	InputStream ins=null;
	byte [] byteArr = null;
	long len=0;

	String qryImgContent = "";
	try{
		con = ConnectionManager.getConnection(request);
		String patient_id	= request.getParameter("patient_id")==null?"":(String)request.getParameter("patient_id");	
		String encounterid	= request.getParameter("encounterid")==null?"":(String)request.getParameter("encounterid");
		String facility_id	= request.getParameter("facility_id")==null?"":(String)request.getParameter("facility_id");	
		String patient_class= request.getParameter("patient_class")==null?"":(String)request.getParameter("patient_class");
		String Param = request.getParameter("Param")==null?"":(String)request.getParameter("Param");
		String attend_practitioner_id =request.getParameter("attend_practitioner_id")==null?"":(String)request.getParameter("attend_practitioner_id");
		
		if("PAT_PHOTO".equals(Param)){
			//qryImgContent = "SELECT b.ins_image IMAGE_CONTENT FROM bl_encounter_payer_priority a, bl_pat_ins_documents b WHERE a.operating_facility_id = ? AND a.patient_id = b.patient_id AND a.cust_group_code = b.cust_group_code AND a.cust_code = b.cust_code  AND a.policy_number = b.policy_number AND a.patient_id = ? AND a.episode_type = DECODE (?, 'OP', 'O', 'IP', 'I', 'EM', 'E', 'DC', 'D', 'RF', 'R' )  AND (  ( ? IN ('OP', 'EM') AND a.episode_id || LPAD (TO_CHAR (a.visit_id), 4, '0') = ? )  OR (? IN ('IP', 'DC') AND a.episode_id = ?) ) AND a.priority = 1 AND a.cust_code IS NOT NULL";
			qryImgContent = "SELECT b.ins_image IMAGE_CONTENT FROM bl_encounter_payer_priority a, bl_pat_ins_documents b WHERE a.operating_facility_id = ? AND a.patient_id = b.patient_id AND a.cust_group_code = b.cust_group_code AND a.cust_code = b.cust_code AND a.policy_number = b.policy_number AND a.policy_type_code = b.policy_type_code AND a.patient_id = ? AND a.episode_type =DECODE (?,'OP', 'O','IP', 'I','EM', 'E','DC', 'D','RF', 'R')AND (  ( ? IN ('OP', 'EM') AND a.episode_id || LPAD (TO_CHAR (a.visit_id), 4, '0') = ? )  OR (? IN ('IP', 'DC') AND a.episode_id = ?))AND a.priority = 1 AND a.cust_code IS NOT NULL";
		}else if("PRACTITIONER_SIGN".equals(Param)){
			qryImgContent = "SELECT PRACTITIONER_SIGN IMAGE_CONTENT  FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
		}
		ptsmt = con.prepareStatement(qryImgContent);
		if("PAT_PHOTO".equals(Param)){
			ptsmt.setString(1, facility_id);
			ptsmt.setString(2, patient_id);
			ptsmt.setString(3, patient_class);
			ptsmt.setString(4, patient_class);
			ptsmt.setString(5, encounterid);
			ptsmt.setString(6, patient_class);
			ptsmt.setString(7, encounterid);
		}else if("PRACTITIONER_SIGN".equals(Param)){
			ptsmt.setString(1, attend_practitioner_id);
		}
		rs = ptsmt.executeQuery();
		while(rs !=null && rs.next()){			
			img_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
			if(img_blob!=null){
				byteArr = img_blob.getBytes(1,(int)img_blob.length());
				len = img_blob.length();
				if(len > 0){					
					response.reset();
					response.setContentType("image/gif");
					OutputStream outputStream = response.getOutputStream();
					outputStream.write(byteArr);      
					outputStream.flush();
					outputStream.close(); 					
				}
			}
		}
		if(ins !=null)
			ins.close();
		
	}catch(Exception e){
		//out.println("failed to display ==>"+e);//COMMON-ICN-0181
		e.printStackTrace();
	}finally{
		try{
			ConnectionManager.returnConnection(con);
			if(ptsmt!=null)
				ptsmt.close();
			if(rs!=null)
				rs.close();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
%>
</table>
</body>
</html>
