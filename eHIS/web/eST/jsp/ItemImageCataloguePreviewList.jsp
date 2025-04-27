<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eST.ItemSearchBean,java.util.*, eST.*, eST.Common.*, eCommon.Common.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eST/js/ItemSearch.js"></script>
  
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		
		String imageURL	= request.getParameter("imageURL")==null?"":request.getParameter("imageURL");
		String item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
		String img_path = request.getParameter("img_path")==null?"":request.getParameter("img_path");

	
		if(img_path.equals(""))
		{%>
			<script language="JavaScript">
				alert(getMessage("IMG_PATH_NOT_SET","ST"));
				parent.window.close();
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%}

		String f_name = "";
		int i =0;
		String classvalue="";

		ArrayList alRecords	= new ArrayList();
		HashMap	  hmResult =  new HashMap();
				

		String bean_id = "ItemSearchBean";
		String bean_name = "eST.ItemSearchBean";
		ItemSearchBean bean = (ItemSearchBean)getBeanObject( bean_id, bean_name, request ) ;
		
		String f_name_path = "";
		String filename =	"";
		String extension = "";

	try{
		
		 ArrayList alParameters = new ArrayList();
		 alParameters.add(item_code);
		 alParameters.add(bean.getLoginFacilityId());		 
		 alRecords = (ArrayList)bean.fetchRecords(bean.getStRepositoryValue("SQL_IMAGE_FILE_NAME_SELECT"),alParameters);
		
		 int size = alRecords.size();
		 if(size==0)
			 size = 1;
		 System.out.println("alRecords"+alRecords);
		 System.out.println("alParameters"+alParameters);

		%>	  
		<form name="ViewImage" id="ViewImage">			
				
				<!--<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
					<tr><th align='center' ><fmt:message key="eST.ItemImageCatalogue.label" bundle="${st_labels}"/>List</th></tr>
				</table>-->
			<table cellspacing='0' cellpadding='0' width='100%' border='0'>
				<tr><th align='center' colspan='<%=size%>'><fmt:message key="eST.ItemImageCatalogue.label" bundle="${st_labels}"/>List</th></tr>
				<tr>	
					<%
					for( i=0; i<alRecords.size();i++){
						%>
					<td class="QRYEVEN" width="70" height="60" id="td_<%=i%>"> 
						<%	
						hmResult = (HashMap) alRecords.get(i);
						f_name = (String)hmResult.get("FILE_NAME");
						f_name_path = img_path+f_name;
						
						filename = f_name;
						int dotPosition = filename.lastIndexOf(".");
						
						if (dotPosition != -1) {
						extension = filename.substring(dotPosition);
						}
						if(extension.equals(".gif") || extension.equals(".JPG") || extension.equals(".jpg") || extension.equals(".jpeg")|| extension.equals(".JPEG") || extension.equals(".png") || extension.equals(".bmp") || extension.equals(".tiff") || extension.equals(".JFFIF") || extension.equals(".Exif") || extension.equals(".RAW") || extension.equals(".ppm") || extension.equals(".pgm") || extension.equals(".pbm") || extension.equals(".pnm") || extension.equals(".webp") || extension.equals(".tga") || extension.equals(".ilbm") || extension.equals(".img") || extension.equals(".pcx") || extension.equals(".ecw") || extension.equals(".sid") || extension.equals(".fits") || extension.equals(".pgf") || extension.equals(".xcf")) {%>
							<a href="javascript:callimagepreview('<%=f_name%>','<%=i%>');"> <img src="<%=f_name_path%>" onmouseover="callimagepreview('<%=f_name%>','<%=i%>');" width="70" height="60"  vspace="2" hspace="2" style="border:1px solid black;" >	</a>  <span class=label ><%=f_name%> </span>
						<%}else{%>
							<a href='<%=f_name_path%>' onmouseover="changeColumnColor('<%=i%>');"  target="_blank" border=0 align='center'><%=f_name%></a> 
						<%}%>
					</td>

						<%}%>
						
				</tr>
					<%}catch(Exception e){
						e.printStackTrace();
					}%>
		</table>
		<input type="hidden" name="img_path" id="img_path" value="<%=img_path%>">
		<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
		<input type="hidden" name="bean_id" id="bean_id"	value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
			
		</form>
	</body>
</html>

