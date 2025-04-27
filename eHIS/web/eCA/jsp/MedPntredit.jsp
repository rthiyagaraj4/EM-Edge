<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
21/7/2012	  IN034119		 Nijitha	 The modified images are not appearing in the modify mode
05/05/2015	IN053298		Ramesh G	When we attach an image to the clinical note part of the image is not displayed.
24/11/2020	8188			Ramesh G	SKR-SCF-1496
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.net.*,java.sql.*,java.util.*,webbeans.eCommon.*,java.io.*,java.awt.image.BufferedImage,javax.imageio.ImageIO,org.apache.commons.codec.binary.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
Connection			con				=	null;
PreparedStatement	stmt			=	null;
ResultSet			rs				=	null;

String sec_hdg_code				= request.getParameter("sec_hdg_code") ;
String image_view_counter		= request.getParameter("image_view_counter") ;
String curr_sec_hdg_code		= request.getParameter("curr_sec_hdg_code") ==null?"":request.getParameter("curr_sec_hdg_code");
String curr_child_sec_hdg_code	= request.getParameter("curr_child_sec_hdg_code")==null?"": request.getParameter("curr_child_sec_hdg_code");
String patient_id				= request.getParameter("patient_id") ==null?"":request.getParameter("patient_id");
String encounter_id				= request.getParameter("encounter_id") ==null?"":request.getParameter("encounter_id");

String image_url				=	"";
String image_ref				=	"";
String image_ref_desc			=	"";
String default_yn				=	"";
String default_image_url		=	""; 
String section_image_content	= "";
String strKey					=	"";

strKey = patient_id + "~"+encounter_id;
strKey = strKey.trim();
sectionBean.getPatientSection(strKey);

if(curr_child_sec_hdg_code.equals(""))
	curr_child_sec_hdg_code = curr_sec_hdg_code;

section_image_content =(String) sectionBean.getSectionImageContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
String contentAvailable = "N";//IN034119
%>
<html>
<head>
<script language='javascript' src='../../eCA/js/prototype.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart3.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
 <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String default_avl = "N";
	String imageHeight = "400";  //IN053298
	String tempImageHeight = "400";	 //IN053298
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<body class="message" onload = "loadSecImage('<%=curr_sec_hdg_code%>','<%=curr_child_sec_hdg_code%>');" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name="editor" id="editor" METHOD="POST" ACTION="../servlet/SessJpgReader">
<INPUT TYPE="hidden" name="image" id="image" value="">

<table border="0" width="100%">
<tr>
	<td >
		<table border="0" width="100%">
		<tr>
			<td width="4%"><object code="Standard.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="48" height="20" align="top" codebase = "http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0" > </object>
			</td>
			<td width="66%"><object code="Formatting.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="295" height="20" align="top" codebase = "http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0"> </object>
			</td>
			<td width = "30%" align = "right">
				<fmt:message key="Common.AvailableImages.label" bundle="${common_labels}"/>:
				<select onchange="changeImage(this,'')" name="avlImg" id="avlImg">
					<option value = "">&nbsp;&nbsp;&nbsp;&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<%					
					
					try
					{
						String default_yn_sel	=	"";
						//String sql = " select A.image_url, A.image_ref_desc,B.DEFAULT_YN from ca_note_image_list a,ca_section_image_link b where a.image_ref=b.image_ref and b.sec_hdg_code=?";
						String sql = "select A.image_ref,A.image_url, A.image_ref_desc,B.DEFAULT_YN from CA_NOTE_IMAGE_LIST_LANG_VW a,ca_section_image_link b where a.image_ref=b.image_ref  and language_id = ? and b.sec_hdg_code=?";
						con				=	ConnectionManager.getConnection(request);
						
						stmt = con.prepareStatement(sql);
						stmt.setString(1,locale);

						if(sec_hdg_code.equals(curr_child_sec_hdg_code))
							stmt.setString(2,sec_hdg_code);
						else
							stmt.setString(2,curr_child_sec_hdg_code);

						rs = stmt.executeQuery();
						
						while(rs.next())
						{
							String patImageHeight = "400";  //IN053298
							image_url = rs.getString("image_url");
							image_ref_desc = rs.getString("image_ref_desc");
							default_yn	=	rs.getString("default_yn");
							image_ref	=	rs.getString("image_ref");

							if(default_yn.equals("Y"))
							{
								
								default_yn_sel = "selected";
								default_avl ="Y";
								default_image_url = image_url;
								
							}
							else
								default_yn_sel	=	"";
							
							out.println("<option id='"+image_ref+"' value='" + image_url + "' " + default_yn_sel + " >" + image_ref_desc + "</option>");
							//IN053298 Start.
							//8188 Start.
							//File file = new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + image_url);
							File file = new File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + image_url);
							//8188 End.
							if(file.exists()){								
								BufferedImage bimg = ImageIO.read(file);
								patImageHeight     = String.valueOf(bimg.getHeight());
							}else{
								byte[] byteArray=a_db(file,image_ref);
								if(byteArray.length>0){	
									BufferedImage bimg = ImageIO.read(file);
									patImageHeight     = String.valueOf(bimg.getHeight());
								}else{
									//8188 Start.
									//BufferedImage bimg = ImageIO.read( new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/blank.gif" ));
									BufferedImage bimg = ImageIO.read( new File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/blank.gif" ));
									//8188 End.
									patImageHeight     = String.valueOf(bimg.getHeight());
								}
							}
			
							if(file !=null)
								file=null;
							
							if((Integer.parseInt(patImageHeight))>(Integer.parseInt(tempImageHeight)))
								tempImageHeight = patImageHeight;
							//IN053298 End.
						}
					
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						//out.println("Exception@MedPntrEdit: "+e.toString());//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}
					finally
					{
						if(con!=null)	ConnectionManager.returnConnection(con,request);
					}
					//IN053298 Start.
					if(section_image_content.equals("") ){
						if(image_view_counter.equals("")){						
							if(!default_image_url.equals("")){
								try{
								//8188 Start.
								//BufferedImage bimg = ImageIO.read(new File(request.getSession().getServletContext().getRealPath("/")+"eCA/MediPainter/images/"+default_image_url));	
								BufferedImage bimg = ImageIO.read(new File(request.getSession().getServletContext().getRealPath("/")+"/eCA/MediPainter/images/"+default_image_url));															
								//8188 End.
								imageHeight         = String.valueOf(bimg.getHeight());
								}catch(Exception ex)
								{
									//out.println("Exception@MedPntrEdit1: "+ex.toString());//COMMON-ICN-0181
                                                                           ex.printStackTrace();//COMMON-ICN-0181
								}
							}
						}
					}else{
						imageHeight = (String)sectionBean.getSectionImageHeight(curr_sec_hdg_code,curr_child_sec_hdg_code);						
					}
					
					
					if((Integer.parseInt(tempImageHeight))>(Integer.parseInt(imageHeight)))
								imageHeight = tempImageHeight;
					//IN053298 End.
					%>
				</select>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td >
		<table border="0" width="100%">
		<tr>
			<td width="35%" align="centre">
				<!-- Tool Panel -->	
				<object code="ToolBox.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="275" height="20" codebase = "http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0"> </object>
			</td>
			<td width="65%" align="left">
				<!-- Pen Panel -->
				<object code="Pens.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="160" height="20" codebase = "http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0"> </object>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td>
		<table border="2" cellpadding="1" width = "100%">
	    <tr>
			<td valign="top">
				<!-- Color Pallet -->
				<object code="Pallet.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="75" height="200" codebase = "http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0"> </object>
			</td>
			<td bgcolor="#000000"><object name="drawing" code="Drawing.class" codebase="../MediPainter/"
									archive="medipainterapplet.jar" width="845" height="<%=imageHeight%>" align="baseline" codebase = "http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0">
								
						<%
									if(section_image_content.equals("") )
									{ 
										%>
										<param name="loadImage" height ="350" value="<%=(image_view_counter.equals("")?(default_image_url.equals("")?"":"../MediPainter/images/"+default_image_url):"")%>">	
										<%
									}
									else
									{
										contentAvailable = "Y";//IN034119
										%>
										<param name ="Image" value = "<%=section_image_content%>">
										<%
									}

						%>
									<param name="canDraw" value="1">	
						</object>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<input type ="hidden" name ="default_yn"  value = "<%=default_avl%>">
</FORM>
</body>
<SCRIPT LANGUAGE="JavaScript">
//if(document.editor.avlImg.value !="" || document.editor.avlImg.value!='')//IN034119
if("<%=contentAvailable%>" == 'N')//IN034119
changeImage(document.editor.avlImg,'defaultval');
//Show Image button
var button1 = parent.parent.EditorTitleFrame.document.RecClinicalNotesEditorTitleForm.button1;
//Show Both button
var button2 = parent.parent.EditorTitleFrame.document.RecClinicalNotesEditorTitleForm.button2;

if(button1 != null && button2 != null)
{
	button1.disabled = false;
	button2.disabled = false;
}
else
	alert(getMessage("IMG_TOOL_LD_FATAL_ERROR","CA"));
	
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>
<%!	
	//IN053298 Start.
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
					if(img_blob!=null){
						long len = img_blob.length();					
						if(len > 0){
							ins = img_blob.getBinaryStream();				
							int i;
							while((i = ins.read()) != -1) 
								bytearrayoutputstream.write(i);
							if (ins != null) ins.close();
								
							boolean fcre=false;
							fcre = file.createNewFile();
							if(fcre)
							{
								FileOutputStream fileoutput = new FileOutputStream(file);
								fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
								if (fileoutput != null)  fileoutput.close();			
							}
						}else{
							System.out.println("---------------------->len 0");
						}
					}else{
						System.out.println("-------------------------->img_blob null");
					}
				}
			}
			if(bytearrayoutputstream.size()>0){
				by=new byte[bytearrayoutputstream.size()];
				by=bytearrayoutputstream.toByteArray();
			}else{
				by=new byte[0];
			}

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
	//IN053298 End.
%>

