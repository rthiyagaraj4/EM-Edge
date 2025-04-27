<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<!-- <script src='../../eCommon/js/common.js' language='javascript'></script> -->
<!-- <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<body onKeyDown = 'lockKey()' bgcolor="#031B47" text="#ffffff">
<TABLE width="100%" height=100% border=0 cellpadding=0 cellspacing=0>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement ptsmt = null;
ResultSet rs = null;

java.sql.Blob img_blob = null;
//BufferedOutputStream Buffout1 = null;
//InputStream ins=null;
InputStream ins1 = null;
byte [] byteArr = null;
long len=0; 
String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

String qryImgContent = "";
					try{
						con = ConnectionManager.getConnection(request);

						String logo_name=request.getParameter("param");
						qryImgContent = "select pat_photo_blob pat_photo from mp_patient_photo where patient_id='"+patient_id+"'";
						
						ptsmt = con.prepareStatement(qryImgContent);
						rs = ptsmt.executeQuery();
						if(rs !=null && rs.next())
						{
							img_blob  =  (java.sql.Blob)rs.getBlob("pat_photo");
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
									/****** create a copy in the image folder*******start****/
									/*	ins1 = img_blob.getBinaryStream();
										bytearrayoutputstream = new ByteArrayOutputStream();
										int i;
										while((i = ins1.read()) != -1) 
										bytearrayoutputstream.write(i);

										boolean fcre=false;
										fcre = file.createNewFile();
										if(fcre)
										{
											FileOutputStream fileoutput = new FileOutputStream(file);
											fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
											if (fileoutput != null)  fileoutput.close();			
										}*/

									/****** create a copy in the image folder *******end****/
									/*****get the data from database and display***start*********/
								/*	try{

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
										} */
									/*****get the data from database and display***end*********/
								}else{
									File file = null;
									try{
										file = new File(config.getServletContext().getRealPath("/")+"eCommon/images/blank40.gif");
										if(file.exists()){
											int  size1=(int)file.length();
											ins1=new FileInputStream(file);
											byte[] by1 = new byte[(int)size1];
											response.reset();
											response.setContentType("image/gif");
											while((size1=ins1.read(by1))!= -1 )
											{
											response.getOutputStream().write(by1,0,size1);
											}
											response.flushBuffer();
											ins1.close();
										}else{
										}
									}catch(Exception imageEx){
										imageEx.toString();
									}
								}

							}
						}else{
							File file = null;
							try{
								file = new File(config.getServletContext().getRealPath("/")+"eCommon/images/blank40.gif");
								if(file.exists()){
									int  size1=(int)file.length();
									ins1=new FileInputStream(file);
									byte[] by1 = new byte[(int)size1];
									response.reset();
									response.setContentType("image/gif");
									while((size1=ins1.read(by1))!= -1 )
									{
									response.getOutputStream().write(by1,0,size1);
									}
									response.flushBuffer();
									ins1.close();
								}else{
								}
							}catch(Exception imageEx){
								imageEx.toString();
							}
						}
						//if(ins !=null)
							//ins.close();
						if(ins1 !=null)
						ins1.close();
					}catch(Exception e){
						out.println("failed to display ==>"+e);
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

