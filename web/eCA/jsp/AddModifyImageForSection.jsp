<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------------------------------
26/10/2018		IN068699		Raja S				26/10/2018		Ramesh G		ML-MMOH-SCF-1087
--------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con=null;
StringBuffer sql = new StringBuffer();
String mode="";

String checked = "";
String add_display = "";
String default_yn	=	"";
String sec_hdg_code = request.getParameter("sec_hdg_code");
String sec_hdg_desc = request.getParameter("sec_hdg_desc");
String image_ref = request.getParameter("image_ref");
String image_ref_desc = request.getParameter("image_ref_desc");
String read_only = "";
if(sec_hdg_desc==null) sec_hdg_desc="";
if(image_ref==null) image_ref="";
if(image_ref_desc==null) image_ref_desc="";
if(sec_hdg_code==null) 
{
	sec_hdg_code ="";
	mode="insert";
}
else
	mode="modify";

	if(image_ref.equals("")){
		add_display = "display:none";

	}else if(!(image_ref.equals("")) || mode.equals("modify") ){
		add_display = "display";
	}
try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
	if(!mode.equals("insert"))
	{
		sql = new StringBuffer();
		sql.append(" Select  sec_hdg_code, image_ref, default_yn from ca_section_image_link");            
		sql.append(" where sec_hdg_code = ? and image_ref = ? ");

		stmt=con.prepareStatement(sql.toString());
		stmt.setString(1,sec_hdg_code);
		stmt.setString(2,image_ref);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				sec_hdg_code = rs.getString("sec_hdg_code");
				image_ref = rs.getString("image_ref");
				default_yn = rs.getString("default_yn");
				if(default_yn.equals("Y"))
					checked = "checked";
				else
					checked = "";
			}
		}
			//added new
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		read_only = "disabled";
	}
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>

<script language='javascript' src='../../eCA/js/ImageForSection.js'></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
/*function showImage(obj)
{
	var image_url = "../MediPainter/images/" + obj.options(obj.selectedIndex).id;
	
	document.forms[0].image_previewer.src = image_url;
}*/

//-->

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name = "ImageForSectionFrm" action="../../servlet/eCA.ImageForSectionServlet" method="post" target="messageFrame">
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='75%' align=center>
<tr>
	<td class='label' ><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<input type='text'  name='sec_hdg_desc' id='sec_hdg_desc'  <%=read_only%> onBlur='showSectionWindow(this)'  value="<%=sec_hdg_desc%>" size=30 maxlength=30 ><input type='hidden'  name='sec_hdg_code' id='sec_hdg_code' value='<%=sec_hdg_code%>'><input type='button' name='section_button' id='section_button' class='button' value='?' <%=read_only%> onClick='showSectionWindow(this)'><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eCA.ImageReference.label" bundle="${ca_labels}"/></td>
	<td class='fields'>
		<input type='text'  name='image_ref_desc' id='image_ref_desc'   <%=read_only%> onBlur='showImageWindow(this)' value="<%=image_ref_desc%>"  size=30 maxlength=30 ><input type='hidden'  name='image_ref' id='image_ref' value='<%=image_ref%>'><input type='button' name='image_button' id='image_button' class='button' value='?' <%=read_only%> onClick='showImageWindow(this)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="checkbox" name="default_yn" id="default_yn" <%if(mode.equals("modify")){%>onClick='checkstatus(this)'<%}%> value='<%=default_yn%>' <%=checked%>></td>
</tr>
<tr>
<%	
		String image_url_st="";	
		sql = new StringBuffer();

		StringBuffer image_url = new StringBuffer();
		
		sql.append("select image_url from ca_note_image_list where image_ref=?");

		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,image_ref);	
		
		rs = stmt.executeQuery();
		image_url.append("../MediPainter/images/");
		
		if(rs.next())
		{
			image_url_st = rs.getString("image_url");
			image_url.append(image_url_st);
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		//IN068699 starts
		File file = null;
			//InputStream in=null;
			
			StringBuffer note_image_rep_folder	= new StringBuffer();
			String path	="";
			String strFileSep="";
			java.util.Properties pFileSep	= null;
			path					= config.getServletContext().getRealPath("/");
			note_image_rep_folder.append(path);
			pFileSep	= System.getProperties();
			strFileSep	= (String) pFileSep.getProperty("file.separator");
			note_image_rep_folder.append(strFileSep); //IN063784
			note_image_rep_folder.append("eCA");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("MediPainter");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("images");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append(image_url_st);
			String filename			=	note_image_rep_folder.toString();
		try{
			file = new File(filename.toString());
			if(file.exists()){
				//Load from the file path
			}else{
					String qryImgContent = "";
					PreparedStatement ptsmt = null;
					ResultSet rs1 = null;
					java.sql.Blob img_blob = null;
					InputStream ins1 = null;
					ByteArrayOutputStream bytearrayoutputstream = null;
					qryImgContent = "select objtype, IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF = ? ";
					ptsmt = con.prepareStatement(qryImgContent);
					ptsmt.setString(1,image_ref);
					rs1 = ptsmt.executeQuery();
					while(rs1 !=null && rs1.next())
					{
						
						img_blob  =  (java.sql.Blob)rs1.getBlob("IMAGE_CONTENT");
						long len = img_blob.length();
					/****** create a copy in the image folder*******start****/
						ins1 = img_blob.getBinaryStream();
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
						}
					}
					if(rs1!=null)
						rs1.close();
					if(ptsmt!=null)
						ptsmt.close();
					if(ins1 !=null)
					ins1.close();
				}		
		}catch(Exception m){
			m.printStackTrace();
		}
		//IN068699 ends
%>
	<td id= "refimage" colspan="2" align="center" style='<%=add_display%>'><img name="image_previewer" src="<%=image_url.toString()%>" height="325" width = "600"></img></td>
</tr>

</table>
<input type=hidden name="mode" value="<%=mode%>">
<input type=hidden name="sec_hdg_code1" id="sec_hdg_code1" value="<%=sec_hdg_code%>">
<input type=hidden name="image_ref_desc1" id="image_ref_desc1" value="<%=image_ref%>">


</form>
</body>
</html>
<%
	
}
catch(Exception e)
{
	//out.println("From AddModifyImageForSection.jsp" + e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
if(mode.equals("modify"))
{%>
<SCRIPT LANGUAGE="JavaScript">
//showImage(document.forms[0].image_url)

function checkstatus(obj)
{
	
	if(obj.checked)
	{
	document.forms[0].default_yn.value='Y';
	}
	else
	{
	document.forms[0].default_yn.value='N';
	}
}

</SCRIPT>
<%}
%>

