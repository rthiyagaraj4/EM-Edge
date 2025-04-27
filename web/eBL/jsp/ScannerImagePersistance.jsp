<!DOCTYPE html>
<%@ page import="java.io.*,java.sql.*,webbeans.eCommon.*,java.util.*,java.text.*,eMP.*,eBL.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.commons.io.FileUtils" %> 
<%@page import="org.json.simple.JSONObject"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%!private String checkNull(String inputString) {
		if (inputString == null || inputString.equals("")
				|| inputString.equalsIgnoreCase("null"))
			inputString = "";
		return inputString;
	}%>


<%
	String operation = request.getParameter("operation");
	JSONObject obj = new JSONObject();

   if (operation.equals("LOAD_SCANNED_IMAGE")) {		
	 out.clear();
	 Connection con	= null;	
	 PreparedStatement pstmt = null;
	 ResultSet rs =null;
	 String documentId=request.getParameter("docId");
	 String payrGrpCode=request.getParameter("payrGrpCode");
	 String payrCode=request.getParameter("payrCode");
	 String plcyCode=request.getParameter("plcyCode");
	 String plcyNo=request.getParameter("plcyNo");
	 String plcystartDate=request.getParameter("plcystartDate");
	 String plcyExpryDate=request.getParameter("plcyExpryDate");
	 
	 String bean_id		= "bl_blinsuranceimagebean" ;
	 String bean_name	= "eBL.BLInsuranceImageBean";
	 BLInsuranceImageBean bean			= (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	 bean.getInsuranceImageValues();
	 HashMap blInsuranceImageList	= 	(HashMap)bean.getInsuranceImageValues(); 
	 BLInsuranceImage bimg=null;
	 		
    /* Added by Karthik - Escape Key is added so 
	 * that these records will be retained when Unnecessary Records are flushed */
	String index = payrGrpCode+payrCode+plcyCode+plcyNo+plcystartDate+plcyExpryDate;
	String escapeKey="^^^";

	 
	 con=ConnectionManager.getConnection(request);
	 pstmt = con.prepareStatement("select DOC_DB_FLAG,DOC_FILE,DOC_FILE_PATH from EM_SCAN_DOCUMENT_TEMP where doc_id=?");
	 pstmt.setString(1, documentId);
	 rs = pstmt.executeQuery();
	 
	 if(rs!=null && rs.next())	{
		 
		 String docDbFlag = rs.getString(1);
		 
		 if(docDbFlag==null||"".equals(docDbFlag)){
			 obj.put("Flag", "FAILED");
		 }
		 else if(docDbFlag.equalsIgnoreCase("0")){
			 
			bean.deleteInsuranceImageRecord(index);
			index+=escapeKey;
			bean.deleteInsuranceImageRecord(index);	
		 
			Blob insImgBLOB = rs.getBlob(2);
			InputStream in = insImgBLOB.getBinaryStream();
			long len = insImgBLOB.length();
			byte[] imageByte = new byte[(int)len];	
			in.read(imageByte , 0 , (int)len);
		
 			bimg = new BLInsuranceImage();
			bimg.setPayerGroupCode(checkNull(payrGrpCode));
			bimg.setPayerCode(checkNull(payrCode));
			bimg.setPolicyCode(checkNull(plcyCode));
			bimg.setPolicyNo(checkNull(plcyNo));
			bimg.setStartDate(checkNull(plcystartDate));
			bimg.setEndDate(checkNull(plcyExpryDate));
			bimg.setImage(imageByte);
			bimg.setDbMod(false);
			blInsuranceImageList.put(index, bimg); 
			obj.put("Flag", "SUCCESS");
				
		 }else if(docDbFlag.equalsIgnoreCase("1")){
			 //Vijays Code Here 
			 
			bean.deleteInsuranceImageRecord(index);
			index+=escapeKey;
			bean.deleteInsuranceImageRecord(index);	
			 
			String imageFilePath = rs.getString(3);
			 
		 	if(imageFilePath!="" && imageFilePath!=null)
				{
				File pdfFile = new File(imageFilePath);
				byte[] pdfByteArray = FileUtils.readFileToByteArray(pdfFile);
				
				bimg = new BLInsuranceImage();
				bimg.setPayerGroupCode(checkNull(payrGrpCode));
				bimg.setPayerCode(checkNull(payrCode));
				bimg.setPolicyCode(checkNull(plcyCode));
				bimg.setPolicyNo(checkNull(plcyNo));
				bimg.setStartDate(checkNull(plcystartDate));
				bimg.setEndDate(checkNull(plcyExpryDate));
				bimg.setImage(pdfByteArray);
				bimg.setImageFilePath(imageFilePath);
				bimg.setDbSharePathFlag(1); // Flag '1' Represents Image is stored in share Path null or '0' represents DB		
				
				blInsuranceImageList.put(index, bimg); 
				obj.put("Flag", "SUCCESS");
				}
		 }			
		 

	 }else{
		 obj.put("Flag", "FAILED");
	 }
	 
	 out.print(obj);
	 out.flush();
	 System.out.println("obj:::" + obj);		
	}
%>
