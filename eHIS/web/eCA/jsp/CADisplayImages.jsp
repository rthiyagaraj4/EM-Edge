<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*" contentType="text/html;charset=UTF-8"%>
<html> 
<head>
<body onKeyDown = 'lockKey()' bgcolor="#031B47" text="#ffffff">
<TABLE width="100%" height=100% border=0 cellpadding=0 cellspacing=0>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ptsmt = null;
	ResultSet rs = null;
	byte [] byteArr = null;//IN066005 
	java.sql.Blob img_blob = null;
	BufferedOutputStream Buffout1 = null;
	InputStream ins=null;
	
	long len=0;

	String qryImgContent = "";
	try{
		con = ConnectionManager.getConnection(request);
		String logo_name=request.getParameter("param");		
		qryImgContent = "SELECT IMAGE_CONTENT LOGO FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'";
					
		ptsmt = con.prepareStatement(qryImgContent);
		rs = ptsmt.executeQuery();
		while(rs !=null && rs.next()){
			System.out.println("------------------------------------>1");
			img_blob  =  (java.sql.Blob)rs.getBlob("LOGO");
			if(img_blob!=null){
				byteArr = img_blob.getBytes(1,(int)img_blob.length());//IN066005 
				len = img_blob.length();
				if(len > 0){					
				//IN066005 Start
					response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArr);      
							outputStream.flush();
							outputStream.close();
							//IN066005 end 
					/*****get the data from database and display***start*********/
					/*try{
							ins = img_blob.getBinaryStream();						
							Buffout1 = new BufferedOutputStream( response.getOutputStream() );
							byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
							int index = ins.read(by , 0 , (int)len);
							while ( index != -1) {
								Buffout1.write(by , 0, index);
								index = ins.read ( by , 0 , (int)len );
							}
							Buffout1.flush();
						}catch(Exception e){
							out.println("@@ exp while creating copy="+e);
							e.printStackTrace();
						}*/ // comitted for IN066005 
					/*****get the data from database and display***end*********/
				}else{
					System.out.println("---------------------->len 0");
				}

			}else{
				System.out.println("-------------------------->img_blob null");
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
