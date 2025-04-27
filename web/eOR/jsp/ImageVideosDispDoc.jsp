<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
28/03/2019	IN068778		Selvin M		28/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*,javax.servlet.*,eOR.Common.*,eOR.*,eOR.ImageVideosMultiFileUploadBean.FileDoc" contentType="text/html;charset=UTF-8"%> 

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");

	String fileName = request.getParameter("fileName")==null?"":request.getParameter("fileName");
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String file_seq_no = request.getParameter("file_seq_no")==null?"":request.getParameter("file_seq_no");
	ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);
	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;
	InputStream in = fbean.getFileInputStream(fileName);
	long len = fbean.getFileSize(fileName);
	String contentType = fbean.getFileType(fileName);
	String orderId = fbean.getOrderId();
	String orderLineNum = fbean.getOrderLineNum();	
	String fileChoosePath = fbean.getSharedPath();
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	try {
		con = ConnectionManager.getConnection(request);		
		fileChoosePath = fileChoosePath + fileName;
		

		String strTemp = "select file_name from OR_MULTI_FILE_UPLOAD_TEMP where order_id = ? and order_line_num = ? and file_name = ? ";
		String fileCheck = "";
		pst = con.prepareStatement(strTemp);
		pst.setString(1, orderId);
		pst.setString(2, orderLineNum);
		pst.setString(3, fileName);
		rs = pst.executeQuery();
		while (rs.next()) {
			fileCheck = rs.getString(1);			
		}
		if (fileName != null && len != -1 && contentType != null && (fileCheck != "" && fileCheck.length() > 0)) {
			if (("image/pjpeg".equals(contentType)) || ("image/gif".equals(contentType)) || ("application/pdf".equals(contentType))) { // image display

				byte[] by = new byte[(int) len]; // file content logic
				int index = in.read(by, 0, (int) len);
				response.reset();
				response.setContentType(contentType);
				response.getOutputStream().write(by, 0, (int) len);
				response.getOutputStream().flush();				
			} else {
			%>
			<script>
				parent.window.close();
			</script>
				<%
					}
						} else {							
							File file = null;
							InputStream inpStrem = null;
							file = new File(fileChoosePath);
										
							if (file.exists()) {								
								int fileSize = (int) file.length();
								inpStrem = new FileInputStream(file);
								byte[] byArray = new byte[(int) fileSize];
								response.reset();
								while ((fileSize = inpStrem.read(byArray)) != -1) {
									response.getOutputStream().write(byArray, 0, fileSize);
								}
								response.flushBuffer();
								inpStrem.close();

							} else {								
								String qry = "select HIST_DATA,OBJTYPE,file_name from OR_MULTI_FILE_UPLOAD_OBJ where order_id = ? and order_line_num = ? and file_name = ? ";

								pst = con.prepareStatement(qry);								
								pst.setString(1, orderId);
								pst.setString(2, orderLineNum);
								pst.setString(3, fileName);

								rs = pst.executeQuery();
								while (rs.next()) {
									String[] objArray = ((String) rs.getString("OBJTYPE")).split("\\/");
									System.err.println("123,objArray[0]=="+ objArray[0]);
									if ("image".equals(objArray[0])  || "gif".equals(objArray[0]) || "application".equals(objArray[0])) 
									{										 
										hist_blob = (java.sql.Blob) rs.getBlob("HIST_DATA");
										long len1 = hist_blob.length();
										byte[] by = new byte[(int) len1];
										InputStream readImg = hist_blob.getBinaryStream();
										int index = readImg.read(by, 0, (int) len1);
										response.reset();
										response.setContentType(rs.getString("OBJTYPE"));
										response.getOutputStream().write(by, 0,(int) len1);
										response.getOutputStream().flush();
									}
								}
							}
						}
						putObjectInBean("MULTIPLEFILEUPLOADBEAN", fbean, session);
					} catch (Exception e) {						
						e.printStackTrace();
					} finally {
						if (rs != null)
							rs.close();
						if (pst != null)
							pst.close();
						ConnectionManager.returnConnection(con, request);
					}
				%>
