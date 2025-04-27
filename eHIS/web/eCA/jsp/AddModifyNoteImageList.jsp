<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%try{%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0038
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<title>Preview</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/NoteImageList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function getConfirmation(){
		var update=confirm(getMessage("UNSYNCHORINIZED_IMAGE_EXISTS","CA"));
		if(update){	parent.parent.frames[1].frames[1].location.href='../../eCA/jsp/QueryCriteriaNoteImageList.jsp';}
}
</script>
<%
String mode="";
String eff_status="E";
String image_ref_desc		=	"";
String image_url	=	"";
String disabled="";
String readOnly="";
String image_ref = request.getParameter("image_ref");
String checked=" ";
String add_display = "";
String upload_display = "";
String mode_display = "";
String prewFlag = "";

if(image_ref==null) 
{
	image_ref ="";
	mode="insert";
	prewFlag="disabled";
}
else
mode="modify";
int count=0;//The number of records in the table "ca_note_image_list" with "image_content"=null	
//String cntFlag="false";
String imgExists = request.getParameter("imgExists");;//specifies whether image exists in the image folder\database
if((imgExists==null)|| (imgExists.equals("No"))) imgExists="";
/**********check for records with image_content=null****start********/
if(mode.equals("insert")){
count=getCount();
/*if(count>0){
	out.println("<script>getConfirmation();</script>");
}*/
/**********check for records with image_content=null****end********/
}
if(!mode.equals("insert"))
{		
	image_ref = request.getParameter("image_ref");
	image_ref_desc =  request.getParameter("image_ref_desc");
	image_url =  request.getParameter("image_url");
	if(imgExists.equals("") )
		image_url="";
	eff_status =   request.getParameter("eff_status");
	readOnly = "readOnly";

	if(eff_status.equals("E")){
		checked="CHECKED";
	}else{
		disabled= "readOnly";				
	}
	if(image_url !=null && !image_url.equals(""))
		prewFlag="";
	else
		prewFlag="disabled";
	if(imgExists.equals("")){
		add_display = "display:none";
		upload_display = "display";
		mode_display = "display:none";

	}else{
		add_display = "display";
		upload_display = "display:none";
		mode_display = "display:none";
	}
	

}
else
{
	add_display = "display:none";
	upload_display = "display";
	//mode_display = "display";
	mode_display = "display:none";
	checked="CHECKED";
	disabled = "";
}

%>
	</HEAD>
	<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">

	<form name="ImageListForm" id="ImageListForm" action="../../servlet/eCA.NoteImageListServlet" method="post"  enctype='multipart/form-data' target="messageFrame" >
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<table border=0 cellspacing=0 cellpadding=3 width='75%' align=center>
	<tr>
		<td class=label ><fmt:message key="eCA.ImageReferenceID.label" bundle="${ca_labels}"/></td>	
		<td class='fields'><input type="text" name="image_ref" id="image_ref" value="<%=image_ref%>" size=4 maxlength=4 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" <%=readOnly%>><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>

	<tr>
		<td class=label><fmt:message key="Common.ImageDescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="image_ref_desc" id="image_ref_desc" value="<%=image_ref_desc%>"  size=20 maxlength=20 onBlur = "return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif' ></td>
	</tr>

	<tr style='<%=mode_display%>' id='img_mode'>
		<td class=label><fmt:message key="Common.mode.label" bundle="${common_labels}"/></td> 
		<td class='fields'>
		<input type='radio' name='add_mode' id='add_mode' value='U' checked onclick='Change_mode(this)' ><fmt:message key="eCA.Upload.label" bundle="${ca_labels}"/>
		<input type='radio' name='add_mode' id='add_mode' value='A' onclick='Change_mode(this)' ><fmt:message key="Common.Add.label" bundle="${common_labels}"/>
		</td>
	</tr>

	<tr id= 'img_upload' style='<%=upload_display%>'>
		<td class=label><fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/></td>
		<td class='fields' align="left"><input type="file" name="image_url" id="image_url" value=""  size=40 maxlength=40 onChange="chkPreviewFlag(this)"><img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="image_url_1" id="image_url_1" value="<%=image_url%>"  size=20 maxlength=20 onBlur = "return makeValidString(this);"  <%=disabled%>></td>
	</tr> 

	<tr style='<%=add_display%>' id= 'img_add' >
		<td class=label><fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/></td>
		<td class='fields' style='display:hidden' ><input type="text" name="image_url_add" id="image_url_add" value="<%=image_url%>"  size=40 maxlength=40 <%=readOnly%>><img src='../../eCommon/images/mandatory.gif' ></td>
	</tr> 
	<tr>
		<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="enabled" id="enabled" value='E' <%=checked%> OnClick ='Change_status(this)'></td>
	</tr>
	<tr>
		<td class='fields' colspan='2'><input type="button" class='button' name="preview" id="preview" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Preview.label","common_labels")%>' <%=prewFlag%> OnClick ='previewFile()'> </td>
	</tr>
	</table>
	<input type="hidden" name=mode value="<%=mode%>">
	<input type=hidden name="image_ref1" id="image_ref1" value="<%=image_ref%>">
	<input type=hidden name="image_ref_desc1" id="image_ref_desc1" value="<%=image_ref_desc%>">
	<input type=hidden name="image_url1" id="image_url1" value="<%=image_url%>">
	<input type=hidden name="image_mode" id="image_mode" value="upload">
	<input type=hidden name="enabled1" id="enabled1" value='<%=eff_status%>'> 
	<input type="hidden" name="image_name" id="image_name" value='<%=image_url%>'>
	<input type="hidden" name="flag" id="flag" value=''>
	<input type="hidden" name="record" id="record" value=''>
	<input type=hidden name="docType" id="docType" value="">
	<input type=hidden name="previewMode" id="previewMode" value="">
	<input type=hidden name="imgExists" id="imgExists" value="<%=imgExists%>">
	</form>
	</body>
	</html>
<%//}
}catch(Exception e){	
	e.printStackTrace();
}%>

<%!
	public int getCount() throws Exception{
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	int cnt=0;
	try{	
		con=ConnectionManager.getConnection();
		con.setAutoCommit(false);
		pstmt=con.prepareStatement("select count(*) cnt from CA_NOTE_IMAGE_LIST where objtype is null");
		rs=pstmt.executeQuery();
		while((rs!=null) && (rs.next())){
			cnt=rs.getInt("cnt");
		}
	}catch(Exception e){		
		e.printStackTrace();
	}finally{
		if(rs!=null) rs.close();	
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	} 
	return cnt;
 }

%>

