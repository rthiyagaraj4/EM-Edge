<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement, java.sql.CallableStatement, webbeans.eCommon.ConnectionManager, webbeans.eCommon.*,eCommon.Common.*, java.util.Properties" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
Connection connection			= null;
PreparedStatement preStatement	= null;
ResultSet	resultSet			= null;

String file_type_appl_yn	= "N";
String sqlString			= "";
String loginUser			= "";
String facilityID			= "";
String file_no				= "";
String file_no_new			= "";
String file_type_code		= "";
String patient_id			= "";
String volume_no			= "";
String fs_locn_code			= "";
String online_mr_notfn_yn	= "";
String req_locn_id			= "";
String narration_code		= "";
//String dflt_narration		= "";
String p_code				= "";
String p_desc				= "";
String encounter_id			= "";
String file_type_code2="";
String fileno_nw="";
String volume_status="";
String curr_file_status="";
Boolean SiteSpecific_AutoFileReq = false;
// Below line added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
int count_filetype=0; 
int count_reason=0; 
	
try
{
	connection = ConnectionManager.getConnection(request);
	String locale=(String)session.getAttribute("LOCALE");

	if(connection == null)
	{
		%>
		<script>alert('Database Connection is not available');
			parent.parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
		</script>
		<%
	}

	loginUser			=	checkForNull((String) session.getValue("login_user"));
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	StringBuffer sqlBuffer		=	new StringBuffer();
	online_mr_notfn_yn	=	checkForNull(request.getParameter("online_mr_notfn_yn"));
	req_locn_id			=	checkForNull(request.getParameter("req_locn_id"));
	patient_id			=	checkForNull(request.getParameter("patient_id"));

	file_no				=	checkForNull(request.getParameter("file_no1"));
	volume_no			=	checkForNull(request.getParameter("volume_no1"));
	file_type_code		=	checkForNull(request.getParameter("file_type_code1"));
	fs_locn_code		=	checkForNull(request.getParameter("fs_locn_code"));
	narration_code			=	checkForNull(request.getParameter("narration_code1"));
	encounter_id			=	checkForNull(request.getParameter("encounter_id"));
  file_type_code2      =	checkForNull(request.getParameter("file_type_code"));
  
	SiteSpecific_AutoFileReq = CommonBean.isSiteSpecific(connection, "MP","AUTO_CREATE_PAT_FILE_AND_REQ"); //Added for MMS-QH-CRF-0148
	
  // Added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
        String sqlcount = "select count(*) reasonbrowsing from fm_narration_lang_vw where eff_status='E' and language_id='"+locale+"'";
		preStatement	=	connection.prepareStatement(sqlcount);		
		resultSet		=	preStatement.executeQuery();
		if(resultSet != null) {
			    while(resultSet.next()){  
 				   count_reason=resultSet.getInt("reasonbrowsing"); 
	            }
        }
    if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();		
//End PMG2013-MMS-CRF-0005 [IN:045278]	

		
	if(!file_no.equals(""))
	{
	preStatement	= connection.prepareStatement("SELECT volume_status,CURR_FILE_STATUS, (SELECT file_type_appl_yn FROM mp_param) file_type_appl_yn FROM fm_curr_locn where facility_id = ? and patient_id=? and file_no=? and volume_no=? ");
	preStatement.setString(1, facilityID);
	preStatement.setString(2, patient_id);
	preStatement.setString(3, file_no );
	preStatement.setString(4, volume_no);

	} else {
   preStatement	= connection.prepareStatement("SELECT file_type_appl_yn FROM mp_param ");
	}

	resultSet		= preStatement.executeQuery();
	
	
	if((resultSet != null) && (resultSet.next()))
	{
		if(!file_no.equals(""))
		{
		volume_status		= resultSet.getString("volume_status");
		curr_file_status    = resultSet.getString("CURR_FILE_STATUS");
		file_type_appl_yn	= resultSet.getString("file_type_appl_yn");
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";
		}else{
       file_type_appl_yn	= resultSet.getString("file_type_appl_yn");
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";

		}
	
	}
	
	
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	
	/*preStatement	= connection.prepareStatement("SELECT file_type_appl_yn FROM mp_param ");
	resultSet		= preStatement.executeQuery();
	if((resultSet != null) && (resultSet.next()))
	{
		file_type_appl_yn	= resultSet.getString("file_type_appl_yn");
	}
	
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";

	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();*/

	if(!volume_no.equals(""))
	{
		int filecount			=0 ;
		String client_ip_address	= "";
		
		CallableStatement callStatement = null;

		Properties p = (Properties) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		
	//	preStatement = connection.prepareStatement("select count(*) fc from fm_req_dtl a ,fm_req_hdr b where a.req_no=b.req_no and a.req_to_facility_id = ? and  b.REQ_FS_LOCN_CODE = ?  and a.FILE_NO = ? and a.cancel_yn = 'N' and a.volume_no = ? ");
		                           sqlBuffer.append("SELECT count(*) fc " );
								sqlBuffer.append("FROM" );
								sqlBuffer.append("  FM_REQ_HDR A" );
								sqlBuffer.append("  , FM_REQ_DTL B " );
								sqlBuffer.append("WHERE A.REQ_NO = B.REQ_NO " );
								sqlBuffer.append("  AND A.REQ_FS_LOCN_CODE = '"+fs_locn_code+"' " );
								sqlBuffer.append("  AND A.REQ_FACILITY_ID = '"+facilityID+"' " );
								sqlBuffer.append("  AND B.ISS_YN = 'N' " );
								sqlBuffer.append("  AND B.CANCEL_YN = 'N'" );
								sqlBuffer.append(" AND B.FILE_NO='"+file_no+"' ");
								sqlBuffer.append(" AND B.volume_no="+volume_no+" ");
								
							
														
							preStatement = connection.prepareStatement(sqlBuffer.toString());
								
								
	/*	preStatement.setString(1, facilityID );
		preStatement.setString(2, fs_locn_code );
		preStatement.setString(3, file_no );
		preStatement.setString(4, volume_no ); */
		
			resultSet = preStatement.executeQuery();
		if((resultSet != null) && resultSet.next())
		{
			filecount = resultSet.getInt(1);
		}
      	
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();

	
	if(filecount==0 && !volume_status.equals("L") && !curr_file_status.equals("A"))
		{			
						
				if(online_mr_notfn_yn.equals("Y")&& fs_locn_code!="" && file_no!="")
			{				

			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
					
			if(file_type_appl_yn.equals("Y"))
			{
				String   sqlString1 = "SELECT b.file_no file_no FROM mr_pat_file_index b WHERE b.facility_id = ? AND b.file_type_code=? AND b.patient_id = ?  ";
			
			preStatement	=	connection.prepareStatement(sqlString1);
			preStatement.setString(1, facilityID);
			preStatement.setString(2, file_type_code2);
			preStatement.setString(3, patient_id);
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{
					fileno_nw = resultSet.getString("file_no");
				}
				}
			file_no=fileno_nw;
			file_type_code=file_type_code2;
		
				 	}
				  
				
					
				
				
				StringBuffer strBuffer		=	new StringBuffer();
				strBuffer.append("{call FM_REQUEST_FILE ('");
				strBuffer.append(facilityID);
				strBuffer.append("','");
				strBuffer.append(fs_locn_code);
				strBuffer.append("','");
				strBuffer.append(loginUser);
				strBuffer.append("','");
				strBuffer.append(file_no);
				strBuffer.append("','");
				strBuffer.append(file_type_code);
				strBuffer.append("','");
				strBuffer.append(volume_no);
				strBuffer.append("','");
				strBuffer.append(req_locn_id);
				strBuffer.append("','");
				strBuffer.append(narration_code);
				strBuffer.append("','");
				strBuffer.append(client_ip_address);
				strBuffer.append("','','");
				strBuffer.append(encounter_id);
				strBuffer.append("',?,?)}");


				callStatement = connection.prepareCall( strBuffer.toString()) ;
				callStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
				callStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
				callStatement.execute() ;
				String req_no = callStatement.getString(1);						
				String perm_fs_locn = callStatement.getString(2);			
				
				
				connection.commit();
				%>
				<input type="hidden" name="req_no" id="req_no"  value="<%=req_no%>">				
				<input type="hidden" name="perm_fs_locn" id="perm_fs_locn"  value="<%=perm_fs_locn%>">				
				<%					
					out.println("<script>var retValue ='"+req_no+"'+'&'+'"+perm_fs_locn+"';</script>");					
					out.println("<script>parent.window.returnValue =retValue;</script>");
					
				   out.println("<script>parent.window.close(); </script>");
					
			}
			
		} else {			
			
			if(volume_status.equals("L") || curr_file_status.equals("A"))
			{ %>     
   
		<script>			
			
			var volume_status="<%=volume_status%>";
	       var curr_file_status="<%=curr_file_status%>";
	  if(volume_status=="L")
		alert(parent.frames[0].getMessage('FILE_IS_LOST','FM'));
		else
   alert(parent.frames[0].getMessage('FILE_IS_INACTIVE','FM'));
		</script>
    		
		
	<%
	
   		}else{
		
		//	out.println("<script>var volume_status ='"+volume_status+"'; if(volume_status=='L') {		alert(getMessage('FILE_IS_LOST','FM'));}else{parent.window.close() }; </script>");
			out.println("<script>parent.window.close() ; </script>");
			
			}
		}
		if(callStatement != null) callStatement.close();

		//out.println("<script>parent.msgFrame.location.href='../../eCommon/jsp/error.jsp'; alert(parent.msgFrame.location.href);</script>");
		out.println("<script>parent.msgFrame.location.href='../../eCommon/jsp/error.jsp'; </script>");
	}
	if(volume_no.equals(""))
	{
%>	

<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<Script>
	function EnableDisableOKButton()
	{
		
		
		if(document.forms[0].file_type_code)
		{
		
		if(document.forms[0].file_type_code.value=="" || document.forms[0].volume_no.value =="" || document.forms[0].narration_code.value=="" )
		{
			document.forms[0].ok_button.disabled = true;
		}
		else if(document.forms[0].file_type_code.value !="" && document.forms[0].volume_no.value !="" && document.forms[0].narration_code.value !=""  )
		{
			if(document.forms[0].ok_button.disabled == true)
			{
				document.forms[0].ok_button.disabled = false;
			}
		}
		}else{


if(document.forms[0].volume_no.value =="" || document.forms[0].narration_code.value=="" || document.forms[0].fs_locn_code_1.value=="" )
		{
		document.forms[0].ok_button.disabled = true;
		}
		else if(document.forms[0].volume_no.value !="" && document.forms[0].narration_code.value !=""  && document.forms[0].fs_locn_code_1.value!="")
		{
			if(document.forms[0].ok_button.disabled == true)
			{
				document.forms[0].ok_button.disabled = false;
			}
		}

		}
	}
	
	function populatevolumeno()
		{

        var file_type_code=""; 
		var count_reason="";
		var perm_fs_locn_code="";
		var flag_status="AUTO_REQ";
		if(document.forms[0].file_type_code)
		file_type_code=document.forms[0].file_type_code.value;		
		
		if(document.forms[0].count_reason)
		count_reason=document.forms[0].count_reason.value;
			
		var patient_id=document.forms[0].patient_id.value;
          var file_type_appl_yn  =document.forms[0].file_type_appl_yn.value;
			if(document.forms[0].fs_locn_code_1)
			 perm_fs_locn_code =document.forms[0].fs_locn_code_1.value;
			removeitems(document.forms[0].volume_no);
             var temp ="";
				var temp1="------" +getLabel('Common.defaultSelect.label','common')+ "-----";
				var opt=parent.document.frames[0].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
					parent.document.frames[0].document.forms[0].volume_no.add(opt);
 
 
 //   var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" );
			//xmlHttp.open("POST","../../eFM/jsp/FMCheckFileExists.jsp?flag_status=AUTO_REQ&patient_id="+patient_id+"&file_type_code="+file_type_code+"&file_type_appl_yn1="+file_type_appl_yn+"&perm_fs_locn_code="+perm_fs_locn_code,false);
		//	xmlHttp.send(null);		
		//	responseText=trimString(xmlHttp.responseText);
//alert(responseText)


 var HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMCheckFileExists.jsp' ><input name='patient_id' id='patient_id' type='hidden' value='"+patient_id+"'><input name='file_type_code' id='file_type_code' type='hidden' value='"+file_type_code+"'><input name='file_type_appl_yn1' id='file_type_appl_yn1' type='hidden' value='"+file_type_appl_yn+"'><input name='perm_fs_locn_code' id='perm_fs_locn_code' type='hidden' value='"+perm_fs_locn_code+"'><input name='flag_status' id='flag_status' type='hidden' value='"+flag_status+"'><input name='count_reason' id='count_reason' type='hidden' value='"+count_reason+"'></form></BODY></HTML>";
		parent.msgFrame.document.write(HTMLVal);
		parent.msgFrame.document.form1.submit();

		}
	
	function removeitems(obj)
{
	var len=obj.length;
	var i=0;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}
	function closeWindow()
	{ 	 if(document.forms[0].file_type_code)
		{
		 if(document.forms[0].file_type_code.value == '')
		{
			//alert('APP-000001 Volume No cannot be blank...');
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("eFM.FMFileType.label","FM"));
			alert(msg);
		} 
		else if(document.forms[0].volume_no.value == '')
		{
			//alert('APP-000001 Volume No cannot be blank...');
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("eFM.VolumeNo.label","FM"));
			alert(msg);
		}
		else if(document.forms[0].narration_code.value == '')
		{
			//alert('APP-000001 Reason for Borrowing cannot be blank...');
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("eFM.ReasonForBorrowing.label","FM"));
			alert(msg);
		}
		else
		{
			//if(document.forms[0].fs_locn_code_1!=null)
				//document.forms[0].fs_locn_code.value = document.forms[0].fs_locn_code_1.value;
			if(document.forms[0].volume_no!=null)
				document.forms[0].volume_no1.value = document.forms[0].volume_no.value;
			if(document.forms[0].file_type_code!=null)
				document.forms[0].file_type_code1.value = document.forms[0].file_type_code.value;
			if(document.forms[0].narration_code!=null)
				document.forms[0].narration_code1.value = document.forms[0].narration_code.value;			
				document.forms[0].submit();	
			
			//parent.parent.window.close();
		}
		}else{

	if(document.forms[0].fs_locn_code_1.value=='')
			{
        	var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("Common.FileStorageLocation.label","common"));
			alert(msg);

			}
	else if(document.forms[0].volume_no.value =='')
			{
			//alert('APP-000001 Volume No cannot be blank...');
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("eFM.VolumeNo.label","FM"));
			alert(msg);
		}
		else if(document.forms[0].narration_code.value == '')
		{
			//alert('APP-000001 Reason for Borrowing cannot be blank...');
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace("$",getLabel("eFM.ReasonForBorrowing.label","FM"));
			alert(msg);
		}
		else
		{
			//if(document.forms[0].fs_locn_code_1!=null)
				//document.forms[0].fs_locn_code.value = document.forms[0].fs_locn_code_1.value;
			if(document.forms[0].volume_no!=null)
				document.forms[0].volume_no1.value = document.forms[0].volume_no.value;
			if(document.forms[0].file_type_code!=null)
				document.forms[0].file_type_code1.value = document.forms[0].file_type_code.value;
				if(document.forms[0].narration_code!=null)
				document.forms[0].narration_code1.value = document.forms[0].narration_code.value;
				document.forms[0].submit();			
		//	parent.parent.window.close();
		}


		}
	}
	function CancelWindow()
	{
		const diagElement = parent.parent.document.getElementsByTagName('dialog');
		var returnValue;
		for (var i = 0; i < diagElement.length; i++) {
		    for (var j = 0; j < diagElement[i].children.length; j++) {
		        var element = diagElement[i].children[j];
		        let dialogSrc = element.src;
		        if (typeof dialogSrc !== 'undefined') {
		            if (dialogSrc.includes('FMAcceptFileTypeVolumeNoFrame.jsp')) {
		               diagElement[i].close(); 
		            }
		        }
		    }
		}
		//parent.parent.window.close();
	}
</script>

</head>
</html>
<form name="FMAcceptFileTypeForm" id="FMAcceptFileTypeForm" action="FMAcceptFileTypeVolumeNo.jsp" method="POST" target="msgFrame">
<input type='Hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value="<%=file_type_appl_yn%>">
<!-- Added for MMS-QH-CRF-0148 -->
<input type='Hidden' name='count_volumeno' id='count_volumeno' value="0">
<input type='Hidden' name='count_reason' id='count_reason' value="<%=count_reason%>">
<table width="100%" border='0' cellpadding='2' cellspacing='0' align="CENTER">
<%
if(file_type_appl_yn.equals("Y"))
	{
%>
	<tr>
		<td class='label' nowrap width="40%"><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
		<td class='fields' width="60%"><select name="file_type_code" id="file_type_code" onChange='EnableDisableOKButton();populatevolumeno();'>
			<option>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<%

			sqlString = "SELECT b.file_type_code file_type_code, a.short_desc file_type_desc, b.file_no file_no FROM mr_file_type_lang_vw a, mr_pat_file_index b WHERE a.language_id='"+locale+"' and b.facility_id = a.facility_id AND b.file_type_code = a.file_type_code AND b.facility_id = ? AND b.patient_id = ?  ";
			
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		
			preStatement	=	connection.prepareStatement(sqlString);
			preStatement.setString(1, facilityID);
			//preStatement.setString(2, file_no);
			preStatement.setString(2, patient_id);
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{  
    				count_filetype++; // Senthil Added
					
					file_no_new = resultSet.getString("file_no");
					%>
					<option value = '<%=checkForNull(resultSet.getString("file_type_code"))%>'><%=checkForNull(resultSet.getString("file_type_desc"))%></option>
					<%
				}
			}
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			%>
		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
	</tr>
	<!-- <tr><td colspan="2">&nbsp;</td></tr> -->
<% 
	} 
	else if(file_type_appl_yn.equals("N"))
	{
			%>
	<tr>
		<td class='label' nowrap width="40%"><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>
		<td class='fields' width="60%"><select name="fs_locn_code_1" id="fs_locn_code_1" onChange='EnableDisableOKButton();populatevolumeno();'>
			<option>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<%			

			sqlString = "SELECT b.FS_LOCN_CODE FS_LOCN_CODE, a.short_desc fs_locn_desc,b.file_no file_no FROM FM_STORAGE_LOCN_LANG_VW a, mr_pat_file_index b WHERE a.language_id='"+locale+"' and b.facility_id = a.facility_id AND b.FS_LOCN_CODE = a.FS_LOCN_CODE AND b.facility_id = ? AND b.patient_id=? ";
			
			preStatement	=	connection.prepareStatement(sqlString);
			preStatement.setString(1, facilityID);			
			preStatement.setString(2, patient_id);
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{
				    count_filetype++; //  Added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
				   
					file_no_new = resultSet.getString("file_no");
					%>
					<option value = '<%=checkForNull(resultSet.getString("FS_LOCN_CODE"))%>'><%=checkForNull(resultSet.getString("fs_locn_desc"))%></option>
					<%
						
				}
			}
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			%>
		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
	</tr>
	<!-- <tr><td colspan="2">&nbsp;</td></tr> -->
<% 
	}
%>

	<tr>
	<td  class='label' nowrap width="40%"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
	<td  class='fields' width="60%" nowrap><select name="volume_no" id="volume_no" onChange='EnableDisableOKButton();'>
		<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			
	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	</tr>
<!--Below line added for this CRF PMG2013-MMS-CRF-0005 [IN:045278] -->
<script>
if('<%=file_type_appl_yn%>'=="Y"){
if('<%=count_filetype%>'==1){
document.forms[0].file_type_code.selectedIndex = 1;
populatevolumeno();
}else{
document.forms[0].file_type_code.selectedIndex = 0;
}
}
if('<%=file_type_appl_yn%>'=="N"){
if('<%=count_filetype%>'==1){
document.forms[0].fs_locn_code_1.selectedIndex = 1;
populatevolumeno();
}else{
document.forms[0].fs_locn_code_1.selectedIndex = 0;
}
}

</script>
<!--End PMG2013-MMS-CRF-0005 [IN:045278] -->
	
	<tr>
	<td  class='label' nowrap width="40%"><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></td>
	<td  class='fields' width="60%" nowrap><select name="narration_code" id="narration_code"  onChange='EnableDisableOKButton();' >
		<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<%
			sqlString = "select narration_code,short_desc from fm_narration_lang_vw where eff_status='E' and language_id='"+locale+"'order by 2";
			
			preStatement	=	connection.prepareStatement(sqlString);		
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{  
 				   					
					p_code = resultSet.getString("narration_code");
					p_desc = resultSet.getString("short_desc");				
				
				%>
					<option value = '<%=p_code%>' ><%=p_desc%></option>				
				<%		

				}
			}

			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
	%>
	</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	</tr>

	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td colspan="2" align="CENTER"><input type="button" class="BUTTON" value="OK" id="ok_button" name="ok_button" id="ok_button" style="width:50" onClick="closeWindow();" disabled>&nbsp;<input type="button" class="BUTTON" value="Cancel" name="CancelButton" id="CancelButton" onClick="CancelWindow();"></td>
	</tr>
	
	<input type='Hidden' name='online_mr_notfn_yn' id='online_mr_notfn_yn' value="<%=online_mr_notfn_yn%>">
	<input type='Hidden' name='req_locn_id' id='req_locn_id' value="<%=req_locn_id%>">
	<input type='Hidden' name='file_no1' id='file_no1' value="">
	<input type='Hidden' name='fs_locn_code' id='fs_locn_code' value="<%=fs_locn_code%>">
	<input type='Hidden' name='volume_no1' id='volume_no1' value="">	
	<input type='Hidden' name='file_type_code1' id='file_type_code1' value="">
	<input type='Hidden' name='narration_code1' id='narration_code1' value="">
	<input type='Hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
	<!-- Added for MMS-QH-CRF-0148 -->
	<input type='Hidden' name='count_filetype' id='count_filetype' value="<%=count_filetype%>">
	<input type='Hidden' name='sitespecific_autofilereq' id='sitespecific_autofilereq' value=<%=SiteSpecific_AutoFileReq%>>
	</table>
</form>
</html>
<%
	}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();

}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}
%>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
%>

