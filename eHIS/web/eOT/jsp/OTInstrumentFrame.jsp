<!DOCTYPE html>
<!-- Added by Rajesh 30-8-12 -->
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="eCommon.*,eOT.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<!-- Added by Rajesh 30-8-12 -->
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%> 
<!-- Added by Rajesh 30-8-12 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<!-- Added by Rajesh 30-8-12 -->
<html>
<head>

<!-- Added by Rajesh 30-8-12 -->
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!-- Added by Rajesh 30-8-12 -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/AdministrativeFunctionforAllCharges.js"></Script>
<!-- Added by Rajesh 30-8-12 -->
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- Added by Rajesh 30-8-12 -->
</head>
<%
 String instr_code =  checkForNull(request.getParameter("instr_code"));
 String instr_desc =  checkForNull(request.getParameter("instr_desc"));
 String item_code = "";
 String item_desc= "";
 String image_file="";
 String st_location ="";//RUT-CRF-091
 String	qryVal="";
 //Added by Rajesh 30-8-12
 Connection con=null;
 String locale = (String)session.getAttribute("LOCALE"); 
 PreparedStatement pstmt=null;
 PreparedStatement pstmt_image_ic=null;
 ResultSet rst_image_ic=null;
 //Added by Rajesh 30-8-12
 String sql_cssd_image_flag = request.getParameter("sql_cssd_image_flag"); 
// sql_cssd_image_flag = "../../eOT/images/"+sql_cssd_image_flag;
//RUT-CRF-0091 by MuthuN Starts Here
 String ic_image = request.getParameter("image"); 
 String ic_location = request.getParameter("location"); 
//RUT-CRF-0091 by MuthuN Ends Here
  
	
  
 ResultSet rst = null;	
try{
		con = ConnectionManager.getConnection(request);
 String sql_ic_image= "select image_file from OT_INSTRUMENT where instr_code=?";

// String sql_ic="SELECT A.ITEM_CODE CODE, A.ITEM_DESC DESCR, A.IMAGE_FILE IMAGE FROM OT_SS_COMPONENTS_LANG_VW A,OT_INSTRUMENT_COMPONENTS B WHERE B.INSTR_CODE=? AND A.ITEM_CODE=B.ITEM_CODE ";	

 //String sql_ic="SELECT A.ITEM_CODE CODE, A.ITEM_DESC DESCR, A.IMAGE_FILE IMAGE, B.STLOCATION LOCATION FROM OT_SS_COMPONENTS_LANG_VW A,OT_INSTRUMENT_COMPONENTS B WHERE B.INSTR_CODE=? AND LANGUAGE_ID='"+locale+"' AND A.ITEM_CODE=B.ITEM_CODE ";	
 String sql_ic="SELECT A.ITEM_CODE CODE, A.ITEM_DESC DESCR, A.IMAGE_FILE IMAGE, a.location LOCATION FROM OT_SS_COMPONENTS A,OT_INSTRUMENT_COMPONENTS B WHERE B.INSTR_CODE=? AND A.ITEM_CODE=B.ITEM_CODE ";	


		pstmt = con.prepareStatement(sql_ic);
		pstmt_image_ic = con.prepareStatement(sql_ic_image);
		pstmt.setString(1,instr_code);
		pstmt_image_ic.setString(1,instr_code);
		rst = pstmt.executeQuery();
		rst_image_ic = pstmt_image_ic.executeQuery();
		int index=0;
		String strVal="";
%>
   

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OTInstrumentFrame" id="OTInstrumentFrame">
<table  cellpadding='0' cellspacing='0'>
<tr>
		<td  width="25%"  class='label'>
			<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/>			
		</td>
		<td class="fields" width="25%">
		<input type='text' name='instr_desc' id='instr_desc'  size='30' value= "<%=instr_desc%>">
	</td>
	<%
	while(rst_image_ic.next()){
	 	image_file=checkForNull(rst_image_ic.getString(1));
	%>
	<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
<a class ='gridlink' href="javascript:openDialogWindow_image('<%=image_file%>','<%=ic_location%>')">  
	<img src='../../eOT/images/camera_1.gif'> </a>
 </td>
 <td>
<%=ic_location%>
		 </td>
</tr>
			 <%
				}
			 %>
			<br>
	<tr>
		<th class ='columnheader'> <fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
		<th class ='columnheader'> <fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
		<th class ='columnheader'> <fmt:message key="Common.ImageDescription.label" bundle="${common_labels}"/></th>
		<th class ='columnheader'> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	</tr>
<%
	while(rst.next()){				
		 qryVal=(index%2==0)?"gridData":"gridData";
		 ++index;		   
		 item_code = checkForNull(rst.getString(1));
		 item_desc = checkForNull(rst.getString(2));
		 image_file = checkForNull(rst.getString(3));
		 st_location = checkForNull(rst.getString(4));//RUT-CRF-091
%>	
		<tr>
		<td class="<%=qryVal%>"> <%=item_code%></td>
		<td class="<%=qryVal%>"> <%=item_desc%></td>
		<td class="<%=qryVal%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class ='gridlink' href="javascript:openDialogWindow_image_component('<%=image_file%>','<%=st_location%>','<%=item_code%>')">  <img src='../../eOT/images/camera_1.gif'> </a></td>
	<td class="<%=qryVal%>"> <%=st_location%></td>	<!--RUT-CRF-091 -->
		</tr>
<%
		}	
	/*System.out.println("index"+index);//lakshmi
		if(index==null || index==""){
		out.println("<script>callNoRecords();</script>");
	}	*/
	}catch(Exception e){
		e.printStackTrace();
		 System.err.println("Err Msg in OTInstrumentFrame.jsp"+e.getMessage());
	}finally{
		try{
		
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(rst_image_ic!=null)rst_image_ic.close();
			if(pstmt_image_ic!=null)pstmt_image_ic.close();
			
			if(con!=null)
			{
		
			ConnectionManager.returnConnection(con,request);
		
			}
		}catch(Exception e)
		{e.printStackTrace();}
	}
%>
		<input type='hidden' name='instr_code' id='instr_code' value ="<%=instr_code%>">
		<input type='hidden' name='instr_desc' id='instr_desc' value ="<%=instr_desc%>">
		<input type='hidden' name='item_code' id='item_code' value ="<%=item_code%>">
		<input type='hidden' name='item_desc' id='item_desc' value ="<%=item_desc%>">
		<input type='hidden' name='image_file' id='image_file' value ="<%=image_file%>">
		<input type='hidden' name='ic_location' id='ic_location' value ="<%=ic_location%>">
		<input type='hidden' name='sql_cssd_image_flag' id='sql_cssd_image_flag' value ="<%=sql_cssd_image_flag%>">
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
	</table>
	</body>	
	</form>
<script>
	function openDialogWindow_image(image_file,st_location){
		//Modified by Rajesh for CRF-0057 to restrict image display
		if(!image_file == ""){
			var dialogHeight 		= "20";
			var dialogWidth  		= "30";
			var dialogTop   		= "50";
			var dialogLeft   		= "50";
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
			var arguments			= "";
			var	param="sql_image_flag="+image_file;	
			param=param+"&st_location="+st_location;
			retVal=window.showModalDialog("../../eOT/jsp/AdminInstrumentImageFrame.jsp?"+param,arguments,features);		
		}
		else{
			alert(getMessage("NO_RECORD_FOUND","Common"));
		}
		//Modified by Rajesh for CRF-0057 to restrict image display
	}

//Added newly by MuthuN against CRF-091
	function openDialogWindow_image_component(image_file,st_location,item_code){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +="/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_Image_flag_Admin_component&item_code="+item_code,false);
	xmlHttp.send(xmlDoc);
	var obj = trimString(xmlHttp.responseText);
	var cp_location_array=obj.split("~BR~");
	loc_cp=encodeURIComponent(cp_location_array[0]);
	image_cp=cp_location_array[1];
		if(!image_file == ""){
			var dialogHeight 		= "20";
			var dialogWidth  		= "30";
			var dialogTop   		= "50";
			var dialogLeft   		= "50";
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
			var arguments			= "";
			var	param="sql_image_flag="+image_file;	
			param=param+"&st_location="+loc_cp;
			retVal=window.showModalDialog("../../eOT/jsp/AdminInstrumentImageFrame.jsp?"+param,arguments,features);	
		}
		else{
			alert(getMessage("NO_RECORD_FOUND","Common"));
		}
	}
</script>
</html>

