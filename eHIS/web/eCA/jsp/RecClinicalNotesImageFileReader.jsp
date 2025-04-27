<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?       		created
15/03/2013		IN038493	NijithaS			CRF-CA- CHL-CRF-0011/04- Social History Widget->While Modifying a image Linked Section we get script error		 
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
06/04/2017	IN063939		Raja S				06/04/2016		Ramesh G		ML-MMOH-SCF-0700
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.net.*,java.sql.*,webbeans.eCommon.*,javax.servlet.*,java.io.*,org.apache.commons.codec.binary.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% //, com.medicom.tool.Base64
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<html>
<body onLoad="clearImg();Paint()" class = "MESSAGE" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
		String image = request.getParameter("image");
		String image_ref = request.getParameter("image_ref");
		String patimage = null ;
		String patBlankImage = null ;
//		URLConnection urlconnection = null;
		try
		{

			/*			URL url1 = new 	URL("file:///"+config.getServletContext().getRealPath("/")+"eCA\\MediPainter\\images\\blank.gif");
			patBlankImage = Base64.encode(a(url1.openConnection().getInputStream()));
			*/
			//FileInputStream fisBlkImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/blank.gif" );//commented for IN063939
			FileInputStream fisBlkImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/blank.gif" );//Modified for IN063939
			System.out.println("fisBlkImgFile"+fisBlkImgFile);

			//patBlankImage = Base64.encode(a(fisBlkImgFile));
			patBlankImage = new String((new Base64()).encode(a(fisBlkImgFile)));
		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
		}
		try
		{
			//URL url = new URL("file:///"+config.getServletContext().getRealPath("/")+"eCA\\MediPainter\\images\\" + image);	

//			urlconnection = url.openConnection();
			
//			File flImageFile = new File(config.getServletContext().getRealPath("/")+"eCA\\MediPainter\\images\\" + image);

			//File file = new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + image);//commented for IN063939
			File file = new File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + image);//Modified for IN063939
			
			//**FileInputStream fisImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + image);
			if(file.exists()){
				FileInputStream fisImgFile = new FileInputStream(file);
				//patimage = Base64.encode(a(fisImgFile));
				patimage = new String((new Base64()).encode(a(fisImgFile)));
			}else{
				byte[] byteArray=a_db(file,image_ref);
				if(byteArray.length>0){
					//patimage = Base64.encode(byteArray);
					patimage = new String((new Base64()).encode(byteArray));
				}else{
					out.println("<script>alert(getMessage('IMAGE_NOT_FOUND_INLIB','CA'));</script>");
					//FileInputStream fisImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/blank.gif" );//Commented for IN063939
					FileInputStream fisImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/blank.gif" );//Modified for IN063939
					//patimage = Base64.encode(a(fisImgFile));
					patimage = new String((new Base64()).encode(a(fisImgFile)));
				}
			}
			
//			patimage = Base64.encode(a(urlconnection.getInputStream()));
			if(file !=null)
				file=null;
		}
		catch(FileNotFoundException e)
		{
			out.println("CA-9901 The selected image is not available in Application Library. Please Contact Application Admin.");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			out.println("CA-9902 A fatal error has occured while loading the image into the editor. <BR>Please contact the Administrator..");
			e.printStackTrace();
		}		
%>
<form name = "imageValueFrm"  id = "imageValueFrm">

<textarea name = "imageValue"  id = "imageValue"  style='visibility:hidden'><%=patimage%></textarea>
<textarea name = "blankimageValue" style='visibility:hidden'><%=patBlankImage%></textarea>
</form>
<script>
	function clearImg()
	{
		if(document.imageValueFrm.imageValue.value != 'null')
		{
			//IN038493 Start.

			//parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
			if(null!=parent.workAreaFrame.RecClinicalNotesFrame && null!=parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame)
			{
				parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
			}
			else
			{			
				//parent.workAreaFrame.RecClinicalNotesFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
				if(null!=parent.workAreaFrame.RecClinicalNotesSecDetailsFrame)
					parent.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
				else if(null!=parent.workAreaFrame.document.applets["drawing"])
					parent.workAreaFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
				//IN038493 End.
			}
		}
		
	}
	function Paint() 
	{
		if(document.imageValueFrm.imageValue.value != 'null')
		{
			//IN038493 Strat	

			if(null!=parent.workAreaFrame.RecClinicalNotesFrame){
				parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.imageValue.value);
			
			}else{
				if(null!=parent.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame)
					parent.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.imageValue.value);				
				else
					parent.workAreaFrame.document.applets["drawing"].SetImage(document.imageValueFrm.imageValue.value);				
			}
			//IN038493 End.
		}
		else
		{
				//IN038493 Strat	

			if(null!=parent.workAreaFrame.RecClinicalNotesFrame){
				parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);	
			}else{
				if(null!=parent.workAreaFrame.RecClinicalNotesMediPainterFrame)
					parent.workAreaFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
				else
					parent.workAreaFrame.document.applets["drawing"].SetImage(document.imageValueFrm.blankimageValue.value);
			}
			//IN038493 End.
		}
	}
</script>
</body></html>
<%!
	public static byte[] a(FileInputStream inputstream)	throws IOException
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		int i;
		while((i = inputstream.read()) != -1) 
			bytearrayoutputstream.write(i);
		inputstream.close();
		return bytearrayoutputstream.toByteArray();
	}

	public static byte[] a(InputStream inputstream)	throws IOException
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		int i;
		while((i = inputstream.read()) != -1) 
			bytearrayoutputstream.write(i);
		inputstream.close();
		return bytearrayoutputstream.toByteArray();
	}
	/***a_db() is called when the file does not exit in the image folder. Here we get the blob data from the database and display. We also create a copy in the image folder****/
	public static byte[] a_db(File file,String image_ref) throws Exception
	{
		Connection con = null;
		PreparedStatement ptsmt = null;
		ResultSet rs = null;
		InputStream ins=null;
		ByteArrayOutputStream bytearrayoutputstream =null;
		String qryImgContent="";
		java.sql.Blob img_blob = null;
		byte[] by = null;
		try{
			/****** read from database and display *******start****/
		
			bytearrayoutputstream = new ByteArrayOutputStream();
			con = ConnectionManager.getConnection();
			qryImgContent = "select OBJTYPE, IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF = ? ";
			ptsmt = con.prepareStatement(qryImgContent);
			ptsmt.setString(1,image_ref);
			rs = ptsmt.executeQuery();
			while(rs !=null  && rs.next())
			{		
				if(rs.getString("OBJTYPE")!=null){
					img_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
					long len = img_blob.length();
					ins = img_blob.getBinaryStream();				
					int i;
					while((i = ins.read()) != -1) 
						bytearrayoutputstream.write(i);
					if (ins != null) ins.close();
							
				
				/****** read from database and display*******end****/
				/****** create a copy in the image folder*******start****/
				boolean fcre=false;
				fcre = file.createNewFile();
				if(fcre)
				{
					FileOutputStream fileoutput = new FileOutputStream(file);
					fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
					if (fileoutput != null)  fileoutput.close();			
				}
			}
			}
			if(bytearrayoutputstream.size()>0){
				by=new byte[bytearrayoutputstream.size()];
				by=bytearrayoutputstream.toByteArray();
			}else{
				by=new byte[0];
			}


			/****** create a copy in the image folder*******end****/
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			if(con!=null) con.close();
			if(rs!=null)
				rs.close();
			if(ptsmt!=null)
				ptsmt.close();
		}

		return by;
	
	}
%>

