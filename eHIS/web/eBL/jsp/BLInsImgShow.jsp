<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.*,java.awt.image.BufferedImage,java.io.*"  contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD> 
<TITLE>Insurance Image</TITLE>
</HEAD>

<%
	HashMap 	blInsuranceImageList							=	null;
	eBL.BLInsuranceImageBean blInsuranceImageBean 			= 	null;
	eBL.BLInsuranceImage	blInsuranceImage = null;	

	String bean_id						=	"";
	String bean_name					=	"";

	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean";
	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues();
	
	//Image image = null;//Sanjay

	BufferedOutputStream buffOut = null;	
	
    	String index = request.getParameter("index") == null ? "" : request.getParameter("index");
	System.out.println("index for Show image"+index);
	//String filePathPropFile = getServletConfig().getServletContext().getRealPath("/dataSource.properties");
	java.io.File uploadedFile = null;
	java.io.FileInputStream fileinputstream = null; 
	//String connStr = "";
	//String userId = "";
	//String password = "";
	//GHL-CRF-0550
	blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+index);
	String contentType=blInsuranceImage.getContentType();
	//GHL-CRF-0550
	try
	{		
		//blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+index);//GHL-CRF-0550
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

		//buffOut = new BufferedOutputStream(response.getOutputStream());		
		//byte[] buffer = blInsuranceImage.getImage();       
        	//buffOut.write(buffer, 0, buffer.length);
		//buffOut.flush();
		//buffOut.close();
		
		//GHL-CRF-0550
		byte[]  byteArr  = blInsuranceImage.getImage();
		
		response.reset();
		
		OutputStream outputStream = response.getOutputStream();
		//outputStream.write(byteArr); 
		int len=byteArr.length;
		outputStream.write(byteArr);
		outputStream.flush();
		outputStream.close();	
		//GHL-CRF-0550
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of ManageLISSpecimenImageShowImage.jsp--"+e.toString());
			//out.println("Exception in try of ManageLISSpecimenImageShowImage.jsp--"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{		
				
		}
%>
</HTML>
