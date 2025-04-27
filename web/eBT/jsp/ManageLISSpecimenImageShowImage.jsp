<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1			 V211026			 25176		GHL-SCF-1604		  Manivel Natarajan
 */ %>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.io.*,javax.servlet.*,java.util.*,com.ehis.util.*, javax.imageio.*, java.awt.image.*, java.awt.*, javax.swing.*, java.awt.geom.*, java.awt.image.BufferedImage, java.net.*" contentType=" text/html;charset=UTF-8"%>


<% 
Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;
PreparedStatement pstmt1 = null;
ResultSet res1 = null;
PreparedStatement pstmt2 = null;
ResultSet res2 = null;
BufferedImage bi;//Sanjay

BufferedOutputStream buffOut = null;
String facilityId =  request.getParameter("facility_id") == null ? "" :  request.getParameter("facility_id");
String recCnt = request.getParameter("recCount") == null ? "0" : request.getParameter("recCount");
int recCount = Integer.parseInt(recCnt);
int imagePathCheck = 0;
String specNum = request.getParameter("specNum") == null ? "" : request.getParameter("specNum");
String test = request.getParameter("test") == null ? "" : request.getParameter("test");
String sampleId = request.getParameter("sampleId") == null ? "" : request.getParameter("sampleId");
String anatomy = request.getParameter("anatomy") == null ? "" : request.getParameter("anatomy");
String interfaceFileId = request.getParameter("interfaceFileId") == null ? "" : request.getParameter("interfaceFileId");	
java.io.File uploadedFile = null;
java.io.FileInputStream fileinputstream = null; 

String sql = "";
String sqlO = "";
String sqlFilePath = "";
String filePath = "";
String secCode = "";
String docType="";

try
{
	/*
		java.io.FileInputStream ioStream  = new java.io.FileInputStream(filePathPropFile);
		java.util.Properties p = new java.util.Properties();
		p.load(ioStream);
		connStr = (String) p.getProperty("jdbc.url") == null ? "" : (String) p.getProperty("jdbc.url");			
		userId = (String) p.getProperty("jdbc.username") == null ? "" : (String) p.getProperty("jdbc.username");
		password = (String) p.getProperty("jdbc.password") == null ? "" : (String) p.getProperty("jdbc.password");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(connStr,userId,password);
    */
	con = ConnectionManager.getConnection();
	// V211026 Added by Manivel N as part of GHL-SCF-1604 on 26/10/2021 
	System.out.println("facilityId value::"+facilityId);
	pstmt1 = con.prepareStatement("select NVL (count(*), 0) from SM_FUNCTION_CONTROL a ,sm_site_param b where a.site_id=b.customer_id and a.FUNCTIONALITY_ID='RL_SLASH_WITH_IMG_FILE_NAME'");
	res1 = pstmt1.executeQuery();
	while(res1.next())
	{
		imagePathCheck = res1.getInt(1);
	}
	System.out.println(""+ imagePathCheck);
	if(res1 != null) res1.close();
	if(pstmt1 != null) pstmt1.close();
	// V211026 Changes by Manivel Ends here

	sql = "select INTERFACE_FILE_ID from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID = ? and ANATOMY_SITE_CODE = ? ";

	sqlO = "select INTERFACE_FILE_ID from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID is null and ANATOMY_SITE_CODE is null";		
	
	//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
	secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");

	//Commented by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
	// Query to get Section Code STARTS here
	/*
		pstmt1 = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
		pstmt1.setString(1,test);
		res1 = pstmt1.executeQuery();
		while(res1.next())
		{
			secCode = res1.getString(1) == null ? "" : res1.getString(1);
		}
		if(res1 != null) res1.close();
		if(pstmt1 != null) pstmt1.close();
		*/
	// Query to get Section Code ENDS here

	// Query to get file path for copying uploaded Image STARTS here
	sqlFilePath = "select IMAGE_FILE_HOME_IDR from RL_SECTION_CTL where OPERATING_FACILITY_ID = ? and SECTION_CODE = ?";
	pstmt2 = con.prepareStatement(sqlFilePath);
	pstmt2.setString(1,facilityId);
	pstmt2.setString(2,secCode);
	//System.out.println("sqlFilePath value::"+sqlFilePath);
	//System.out.println("facilityId value::"+facilityId);
	//System.out.println("secCode value::"+secCode);
	
	res2 = pstmt2.executeQuery();
	while(res2.next())
	{
		filePath = res2.getString(1) == null ? "" : res2.getString(1);
	}
	if(res2 != null) res2.close();
	if(pstmt2 != null) pstmt2.close();

	// Query to get file path for copying uploaded Image ENDS here

	//System.out.println("recCount val at 83::"+recCount);
	//System.out.println("filePath val at 83::"+filePath);
	if(recCount == 1)
	{
		if (sampleId.length() > 0 && anatomy.length() > 0)
		{   //System.out.println("sql val::"+sql);	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,specNum);
			pstmt.setString(3,test);
			//out.println("sampleId: " + sampleId);//sanjay
			//out.println("anatomy: " + anatomy);//sanjay
			pstmt.setString(4,sampleId);
			pstmt.setString(5,anatomy);	
		}
		else
		{ //System.out.println("sqlO val::"+sqlO);
			pstmt = con.prepareStatement(sqlO);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,specNum);
			pstmt.setString(3,test);			
		}
		res = pstmt.executeQuery();
		while(res.next())
		{
			interfaceFileId = res.getString("INTERFACE_FILE_ID") == null ? "" : res.getString("INTERFACE_FILE_ID");			
			//out.println("interfaceFileId: " + interfaceFileId);//sanjay
		}
	}
	//out.println("Inside ManageLISSpecimenImageShowImage.jsp : filePath: " + filePath);//sanjay

	// testing STARTS here
	//out.println("filePath :" + filePath);
	//filePath = "\\\\cscappche608\\LMP_Backup\\images\\"+interfaceFileId;//Sanjay comment after testing
	
	// V211026 If loop added by Manivel N as part of GHL-SCF-1604 on 26/10/2021 
	if(imagePathCheck > 0){
		filePath = filePath + "\\" + interfaceFileId;
	} else {
		//filePath = filePath + "\\" + interfaceFileId; // Commented by Sethu for ML-MMOH-SCF-1539 on 25/05/2020
		filePath = filePath + System.getProperty("file.separator") + interfaceFileId; // Added by Sethu for ML-MMOH-SCF-1539 on 25/05/2020 
	}
	//System.out.println("interfaceFileId val::"+interfaceFileId);
	System.out.println("final filePath  val::"+filePath);
	
	uploadedFile = new File(filePath);
	// testing ENDS here

	//uploadedFile = new File(filePath+"/"+interfaceFileId);//Sanjay Uncomment after Testing
	
	
	long len = uploadedFile.length();
	//System.out.println(" file length val::"+len);
	
	docType= (String)(getMimeType(uploadedFile)); //Ravi Shankar, 15/03/2017, IN-63394
	
	fileinputstream = new FileInputStream(uploadedFile);
	
	//System.out.println("Inside ManageLISSpecimenImageShowImage.jsp : 4"+docType);//sanjay		
	
	//buffOut = new BufferedOutputStream(response.getOutputStream());
	
	
	//System.out.println("Inside ManageLISSpecimenImageShowImage.jsp : 5");//sanjay
	//out.println("<script>alert('5'); </script>");
	
	byte[] buffer = new byte[(int)len];

	//Ravi Shankar, 15/03/2017, IN-63394
	/*int length;
	while ((length = fileinputstream.read(buffer, 0, (int)len)) > 0) {
		buffOut.write(buffer, 0, length);
	}*/
	int index = fileinputstream.read(buffer, 0, (int)len);  
	response.reset();  
	response.setContentType(docType);  
	response.getOutputStream().write(buffer, 0, (int)len);  
	response.getOutputStream().flush(); 
	//buffOut.flush();
	//buffOut.close();
	////////////////////////////////////

	//below line added by Sanjay against RL-Bru-HIMS-CRF-052.1-02. Image not getting deleted physically from path when its Viewed atleast once. Fix is to close the File Input Stream
	fileinputstream.close();
}//end of try
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageShowImage.jsp--"+e.toString());
	//out.println("Exception in try of ManageLISSpecimenImageShowImage.jsp--"+e.toString());
	e.printStackTrace(System.err);

}
finally
{
	try
	{
		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		if(res1 != null) res1.close();
		if(pstmt1 != null) pstmt1.close();
		if(res2 != null) res2.close();
		if(pstmt2 != null) pstmt2.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception ee)
	{
	}
}
%>

<%!
public static String getMimeType(File file)  throws java.io.IOException, MalformedURLException 
  {
		String type = null;
	try{
    
    URL u = file.toURL();
    URLConnection uc = null;
    uc = u.openConnection();
    type = uc.getContentType();
  
	}catch(Exception e){
		
		e.printStackTrace();
	}
	  return type;
  }
%>
