<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
Connection connection			= null;
PreparedStatement preStatement	= null;
ResultSet	resultSet			= null;

int patient_id_max_length =	0;

String file_type_appl_yn	= "N";
String facilityID			= "";

String patientid_name          = "";
String frame_name              = "";
String frame_name1             = "";
String form_name                = "";
String messageframe_name   = "";
String fileno_name               = "";
String filetype_name             = "";
String volumeno_name          = "";
String volume_no_appl_yn      = "";
String table_width	               = "";
String table_align	               = "";
String patient_id_function       = "";
String file_no_function		   = "";
String file_type_function	       = "";
String volume_no_function	       = "";
String patline_yn			    = "N";
String patline_ID			    = "";
String volume_mandatory_yn	    = "";
String patientid_mandatory_yn	= "";
String file_mandatory_yn	    = "";
String external_facility	    = "";

String fileNoTypeMantatoryYN	= "Y";

// For Document Feature Starts - 28/8/2004 .
String maintain_doc_or_file		= "F";
String document_folder_id_name	= "";
String document_folder_desc_name= "";
String document_folder_function	= "";
String document_type_name		= "";
String document_type_function	= "";
String document_or_file_req		= "";
String doctype_appl_yn          = "";
String locn_code				= "";
String file_mov_flag			= "";
// For Document Feature End.

// Function Name
String function_name = "";
String fs_location="";

try
{
	connection = ConnectionManager.getConnection(request);
	if(connection == null)
	{
		%>
		<script>alert('Database Connection is not available');
			parent.parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
		</script>
		<%
	}

	facilityID 			= checkForNull((String) session.getValue("facility_id"));
	frame_name			= checkForNull(request.getParameter("frame_name"), "parent.frames[3]");
	locn_code = checkForNull(request.getParameter("locn_code"));	
	frame_name1			= checkForNull(request.getParameter("frame_name1"),"parent");//To get the frame for two level of reference. This will be null if called with one frame level. "parent" is a constant assigned to invoke the references where frame_name1 is passed as null from the calling file. 	
	form_name			= checkForNull(request.getParameter("form_name"), "forms[0]");
	messageframe_name	= checkForNull(request.getParameter("messageframe_name"), "parent.messageFrame");
	patientid_name		= checkForNull(request.getParameter("patientid_name"), "patient_id");
	fileno_name			= checkForNull(request.getParameter("fileno_name"), "file_no");
	
	filetype_name		= checkForNull(request.getParameter("filetype_name"), "file_type_code");
	volumeno_name		= checkForNull(request.getParameter("volumeno_name"), "volume_no");
	volume_no_appl_yn	= checkForNull(request.getParameter("volume_no_appl_yn"), "Y");
	table_width			= checkForNull(request.getParameter("table_width"), "100");
	table_align			= checkForNull(request.getParameter("table_align"), "CENTER");
	patient_id_function	= checkForNull(request.getParameter("patient_id_function"));
	
	//patient_id_function="FM_REQUEST_FILES";
	file_no_function	= checkForNull(request.getParameter("file_no_function"));
	file_type_function	= checkForNull(request.getParameter("file_type_function"));
	volume_no_function	= checkForNull(request.getParameter("volume_no_function"));
	patline_yn			= checkForNull(request.getParameter("patline_yn"), "N");
	patline_ID			= checkForNull(request.getParameter("patline_ID"), "patLineID");
	volume_mandatory_yn	= checkForNull(request.getParameter("volume_mandatory_yn"), "N");
	file_mandatory_yn	= checkForNull(request.getParameter("file_mandatory_yn"), "Y");
	external_facility	= checkForNull(request.getParameter("external_facility"));
	patientid_mandatory_yn	= checkForNull(request.getParameter("patientid_mandatory_yn"), "Y");
	
	/*Added by Dharma on 22nd Jan 2018 against ML-MMOH-CRF-0997 [IN:066013] Start*/
	fileNoTypeMantatoryYN	= checkForNull(request.getParameter("fileNoTypeMantatoryYN"), "Y");
	if(("N").equals(fileNoTypeMantatoryYN)){
		file_mandatory_yn = "N";
	}
	/*Added by Dharma on 22nd Jan 2018 against ML-MMOH-CRF-0997 [IN:066013]End*/


	fs_location	= checkForNull(request.getParameter("cuurfslocn"));
	file_mov_flag = checkForNull(request.getParameter("file_mov_flag"));	

	
	//  For Document Feature - 28/8/2004 starts.

	document_folder_desc_name	= checkForNull(request.getParameter("document_folder_desc_name"), "doc_folder_desc");			
	document_folder_id_name		= checkForNull(request.getParameter("document_folder_id_name"), "doc_folder_id");			
	document_folder_function	= checkForNull(request.getParameter("document_folder_function"));		
	document_type_name			= checkForNull(request.getParameter("document_type_name"), "doc_type_id");			
	document_type_function		= checkForNull(request.getParameter("document_type_function"));		
	document_or_file_req		= checkForNull(request.getParameter("document_or_file_req"));	
	doctype_appl_yn				= checkForNull(request.getParameter("doctype_appl_yn"), "Y");

	//	For Document Feature - 28/8/2004  ends. 	
	
	// Function Name
	function_name	= checkForNull(request.getParameter("function_name"));


	// This External Facility will be used when the External Facility File is requested.
	if(!external_facility.equals("")) facilityID = external_facility;

	preStatement	=	connection.prepareStatement("SELECT patient_id_length, file_type_appl_yn, maintain_doc_or_file FROM mp_param ");
	resultSet		=	preStatement.executeQuery();
	if((resultSet != null) && (resultSet.next()))
	{
		patient_id_max_length	=	resultSet.getInt("patient_id_length");
		file_type_appl_yn		=	checkForNull(resultSet.getString("file_type_appl_yn"), "N");
		maintain_doc_or_file	=	checkForNull(resultSet.getString("maintain_doc_or_file"), "F");
	}
	if(!document_or_file_req.equals("")) maintain_doc_or_file = document_or_file_req;
	if(maintain_doc_or_file.equals("D"))  volume_no_appl_yn = "N";

	if(preStatement != null) preStatement = null;
	if(resultSet != null) resultSet = null;
%>	
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eFM/js/FMFileSearchComponents.js" language="JavaScript"></Script>
	<!--<script language='javascript' src='../../eFM/js/FMChFileRetDate.js'></script>-->
	<SCRIPT>
		function getBarcodeValue(event, val, from)
		{ 		
		  
			if(event.keyCode == 13)
			{   
				if(from == 'file')
				{
				
					populateDynamicValues(val);
					document.forms[0].chk_flag.value = "Y";
					document.forms[0].chk_flag1.value = "Y";
				}
				else if(from == 'doc')
				{	
					getPatientIDFileDetails();
				}
			}
		
		}
		<!-- Newly added  by Name :Selvin M  Date :12 july 2011 INCIDENT NO: 27494 Changes:newly added Starts -->
		function moveOnMax(field)
		{  
			if(field.value.length>=field.maxLength)
			{  	if(document.getElementById("fileNo"))
				document.getElementById("fileNo").focus();
				if(document.getElementById('FileType'))
				document.getElementById('FileType').focus();
			}
		}
		<!--Ends-->
		async function patientSearch()
		{	
			var patient_id	= await	PatientSearch('','','','','','','Y','','','OTHER');
			
			if(patient_id != null)
			{
				document.forms[0].<%=patientid_name%>.value=patient_id;
				document.forms[0].<%=patientid_name%>.focus();
				getPatientIDFileDetails();
					}
		}
		 function getPatientIDFileDetails()
		{  
			//var document_folder_id	=	eval(document.forms[0].<%=document_folder_id_name%>).value;	
			/*if("<%=doctype_appl_yn%>" == "Y")
			{
				var document_type_id	=	eval(document.forms[0].<%=document_type_name%>).value;
			}
			else
			{
				var document_type_id	= '';
			}*/
			var param_patient_id = eval(document.forms[0].<%=patientid_name%>).value;		
			var HTMLValue = "<html><body onKeyDown = 'lockKey() '  ><form name='Dummy_Form' id='Dummy_Form'   action='../../eFM/jsp/FMFileSearchComponent.jsp' method='POST'><input type='Hidden' name='function_type' id='function_type' value = 'FileDetails'><input type='Hidden' name='patientid_name' id='patientid_name' value = '"+"<%=patientid_name%>"+"'><input type='Hidden' name='fileno_name' id='fileno_name' value = '"+"<%=fileno_name%>"+"'><input type='Hidden' name='filetype_name' id='filetype_name' value = '"+"<%=filetype_name%>"+"'><input type='Hidden' name='document_type_name' id='document_type_name' value = '"+"<%=document_type_name%>"+"' ><input type='Hidden' name='frame_name' id='frame_name' value = '"+"<%=frame_name%>"+"'><input type='Hidden' name='form_name' id='form_name' value = '"+"<%=form_name%>"+"'><input type='Hidden' name='messageframe_name' id='messageframe_name' value = '"+"<%=messageframe_name%>"+"'><input type='Hidden' name='volumeno_name' id='volumeno_name' value = '"+"<%=volumeno_name%>"+"'><input type='Hidden' name='volume_no_appl_yn' id='volume_no_appl_yn' value='"+"<%=volume_no_appl_yn%>"+"'><input type='Hidden' name='document_type_function' id='document_type_function' value='"+"<%=document_type_function%>"+"'><input type='Hidden' name='document_folder_function' id='document_folder_function' value='"+"<%=document_folder_function%>"+"'><input type='Hidden' name='patline_yn' id='patline_yn' value = '"+"<%=patline_yn%>"+"' ><input type='Hidden' name='patline_ID' id='patline_ID' value = '"+"<%=patline_ID%>"+"' ><input type='Hidden' name='facilityID' id='facilityID' value = '"+"<%=facilityID%>"+"' ><input type='Hidden' name='doctype_appl_yn' id='doctype_appl_yn' value = '"+"<%=doctype_appl_yn%>"+"' ><input type='Hidden' name='param_patient_id' id='param_patient_id' value = '"+param_patient_id+"' ><input type='Hidden' name='fs_location' id='fs_location' value ='"+"<%=fs_location%>"+"' ><input type='Hidden' name='function_name' id='function_name' value ='"+"<%=function_name%>"+"' ><input type='Hidden' name='file_mov_flag' id='file_mov_flag' value = '"+"<%=file_mov_flag%>"+"' ></form></body></html>";
			eval(<%=messageframe_name%>.document).write(HTMLValue);
			eval(<%=messageframe_name%>.document.Dummy_Form).submit();
		}

		function getDocTypeVolumeNo()
		{
			var document_folder_id	= eval(document.forms[0].<%=document_folder_id_name%>).value;
			var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/FMFileSearchComponent.jsp' method='POST'><input type='Hidden' name='function_type' id='function_type' value = 'DocumentOnly'><input type='Hidden' name='patientid_name' id='patientid_name' value = '"+"<%=patientid_name%>"+"'><input type='Hidden' name='fileno_name' id='fileno_name' value = '"+"<%=fileno_name%>"+"'><input type='Hidden' name='filetype_name' id='filetype_name' value = '"+"<%=filetype_name%>"+"'><input type='Hidden' name='document_folder_id' id='document_folder_id' value = '"+document_folder_id+"'><input type='Hidden' name='document_type_name' id='document_type_name' value = '"+"<%=document_type_name%>"+"' ><input type='Hidden' name='frame_name' id='frame_name' value = '"+"<%=frame_name%>"+"'><input type='Hidden' name='form_name' id='form_name' value = '"+"<%=form_name%>"+"'><input type='Hidden' name='messageframe_name' id='messageframe_name' value = '"+"<%=messageframe_name%>"+"'><input type='Hidden' name='volumeno_name' id='volumeno_name' value = '"+"<%=volumeno_name%>"+"'><input type='Hidden' name='volume_no_appl_yn' id='volume_no_appl_yn' value='"+"<%=volume_no_appl_yn%>"+"'><input type='Hidden' name='document_type_function' id='document_type_function' value='"+"<%=document_type_function%>"+"'><input type='Hidden' name='document_folder_function' id='document_folder_function' value='"+"<%=document_folder_function%>"+"'><input type='Hidden' name='patline_yn' id='patline_yn' value = '"+"<%=patline_yn%>"+"' ><input type='Hidden' name='patline_ID' id='patline_ID' value = '"+"<%=patline_ID%>"+"' ><input type='Hidden' name='facilityID' id='facilityID' value = '"+"<%=facilityID%>"+"' ><input type='Hidden' name='fs_location' id='fs_location' value ='"+"<%=fs_location%>"+"' ><input type='Hidden' name='function_name' id='function_name' value ='"+"<%=function_name%>"+"' ><input type='Hidden' name='file_mov_flag' id='file_mov_flag' value = '"+"<%=file_mov_flag%>"+"' ></form></body></html>";
			eval(<%=messageframe_name%>.document).write(HTMLValue);
			eval(<%=messageframe_name%>.document.Dummy_Form).submit();
		}

		async function docFolderSearch(facility_id)
		{
			document.forms[0].<%=patientid_name%>.value = '';

			var target			= eval(document.forms[0].<%=document_folder_desc_name%>);		
			var retVal			= new String();
			var argumentArray	= new Array();
			var dataNameArray	= new Array();
			var dataValueArray	= new Array();
			var dataTypeArray	= new Array();			
			var locn_in = document.forms[0].<%=locn_code%>.value;			

			if(locn_in == "")
			{
			sql = "SELECT  distinct a.doc_folder_id code, a.doc_folder_name description FROM fm_doc_folder a, fm_folder_in_fs_locn b WHERE upper(a.facility_id) like upper(?) and a.eff_status = 'E' AND upper(a.doc_folder_id) like upper(?) AND upper(a.doc_folder_name) like upper(?) AND a.facility_id=b.facility_id AND a.doc_folder_id=b.doc_folder_id "
			}else
			{
			sql = "SELECT  distinct a.doc_folder_id code, a.doc_folder_name description FROM fm_doc_folder a, fm_folder_in_fs_locn b WHERE upper(a.facility_id) like upper(?) and a.eff_status = 'E' AND upper(a.doc_folder_id) like upper(?) AND upper(a.doc_folder_name) like upper(?) AND a.facility_id=b.facility_id AND a.doc_folder_id=b.doc_folder_id AND b.FS_LOCN_CODE = '"+locn_in+"' "
			}			

			var title="Document Folder";
			dataNameArray[0]	= "facility_id";
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
			argumentArray[4] = "2, 3";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;
			
			retVal = await CommonLookup(title, argumentArray);
			
			if(retVal != null && retVal != "" )
			{
				var ret1	=	unescape(retVal);
				arr=ret1.split(",");
				eval(document.forms[0].<%=document_folder_id_name%>).value		=	arr[0];
				eval(document.forms[0].<%=document_folder_desc_name%>).value	=	arr[1];
				if("<%=doctype_appl_yn%>" == "Y")
				{
					getDocTypeVolumeNo();
				}
				else
				{
					getPatientIDFileDetails();
				}

			}
			else
			{
				eval(document.forms[0].<%=document_folder_id_name%>).value		=	"";
				eval(document.forms[0].<%=document_folder_desc_name%>).value	=	"";
				if("<%=doctype_appl_yn%>" == "Y")
				{
					var selectBox   =
					eval(<%=frame_name%>.document.<%=form_name%>.<%=document_type_name%>);
					var seletLen	=	Math.abs(selectBox.length);
					for (i=0; i<seletLen; i++)
						selectBox.remove(0);
					var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");		
					selectOption.value	=	"";
					selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
					selectBox.add(selectOption);
				}
			} 
		}
		function getPatIDVolume(objectValue)
		{
			if (objectValue != "")
			{
				var file_type_appl_yn = eval(document.<%=form_name%>.file_type_appl_yn).value;
				var  patient_id = eval(document.<%=form_name%>.<%=patientid_name%>).value;
			
					var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/FMFileSearchComponent.jsp' method='POST'><input type='Hidden' name='fileNo' id='fileNo' value = '"+objectValue+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value = '"+file_type_appl_yn+"'><input type='Hidden' name='operation' id='operation' value = 'FILE_VOLUME'><input type='Hidden' name='frame_name' id='frame_name' value = '"+"<%=frame_name%>"+"'><input type='Hidden' name='form_name' id='form_name' value = '"+"<%=form_name%>"+"'><input type='Hidden' name='messageframe_name' id='messageframe_name' value = '"+"<%=messageframe_name%>"+"'><input type='Hidden' name='patientid_name' id='patientid_name' value = '"+"<%=patientid_name%>"+"'><input type='Hidden' name='fileno_name' id='fileno_name' value = '"+"<%=fileno_name%>"+"'><input type='Hidden' name='filetype_name' id='filetype_name' value = '"+"<%=filetype_name%>"+"'><input type='Hidden' name='volumeno_name' id='volumeno_name' value = '"+"<%=volumeno_name%>"+"'><input type='Hidden' name='volume_no_appl_yn' id='volume_no_appl_yn' value='"+"<%=volume_no_appl_yn%>"+"'><input type='Hidden' name='file_no_function' id='file_no_function' value='"+"<%=file_no_function%>"+"'><input type='Hidden' name='file_type_function' id='file_type_function' value='"+"<%=file_type_function%>"+"'><input type='Hidden' name='patline_yn' id='patline_yn' value = '"+"<%=patline_yn%>"+"' ><input type='Hidden' name='patline_ID' id='patline_ID' value = '"+"<%=patline_ID%>"+"' ><input type='Hidden' name='facilityID' id='facilityID' value = '"+"<%=facilityID%>"+"' ><input type='Hidden' name='patientID' id='patientID' value ='"+patient_id+"'><input type='Hidden' name='file_mov_flag' id='file_mov_flag' value = '"+"<%=file_mov_flag%>"+"' ></form></body></html>";
				eval(<%=messageframe_name%>.document).write(HTMLValue);
				if(eval(<%=messageframe_name%>.document.Dummy_Form))
				eval(<%=messageframe_name%>.document.Dummy_Form).submit();
				
			}
		}

		function populateDocumentType(obj)
		{
			document.forms[0].<%=patientid_name%>.value = '';
			var facility = "<%=facilityID%>";
			if(obj.value!='')
			{
				docFolderSearch(facility);
			}
			else
			{
				if("<%=doctype_appl_yn%>" ==  "Y")
				{
					var frame_name1 = "<%=frame_name1%>";		
					if(frame_name1=='parent')
					{   
						//This is for call having one layer of frame
						var selectBox   =
						eval(<%=frame_name%>.document.<%=form_name%>.<%=document_type_name%>);
						var seletLen	=	Math.abs(selectBox.length);
						for (i=0; i<seletLen; i++)
							selectBox.remove(0);
						var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");		
						selectOption.value	=	"";
						selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						selectBox.add(selectOption);
					}
					else
					{   
						//This portion is for calls with two level of frames 
						var selectBox   =
						eval(<%=frame_name1%>.document.<%=form_name%>.<%=document_type_name%>);
						var seletLen	=	Math.abs(selectBox.length);
						for (i=0; i<seletLen; i++)
							selectBox.remove(0);
						var selectOption	=  eval(<%=frame_name1%>).document.createElement("OPTION");		
						selectOption.value	=	"";
						selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						selectBox.add(selectOption);
					}
				}
			}
		}

		async function callSearchScreen()
		{
			var retVal = await PatientSearch('','','','','','','Y','','','VIEW');
			if(retVal !=null)
				document.getElementById("patient_id").value = retVal ;
			document.getElementById("patient_id").focus();
		}
	</SCRIPT>
</head>

<% if(maintain_doc_or_file.equals("F")) { 
	
	%>

<table width="<%=table_width%>%" border='0' cellpadding='2' cellspacing='0' align="<%=table_align%>">
<tr>
	<td  class='label' width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td  class='fields' width="25%"><input type='text' id='<%=patientid_name%>' name='<%=patientid_name%>'value='' onKeyPress="getBarcodeValue(event,this.value, 'file');return CheckForSpecChars(event)" maxlength="<%=patient_id_max_length%>" size="<%=patient_id_max_length+2%>"  onBlur='ChangeUpperCase(this);clearval(this);<%=patient_id_function%>'  onchange='Clearencou(this);' onkeyup="moveOnMax(this);"  /> <!--Newly added  by Name :Selvin M  Date :12 july 2011 INCIDENT NO: 27494  Changes:newly added onkeyup function -->
		<input type='button' class='button' name='pat_search' id='pat_search' value='?' align=center onClick='patientSearch();'>
<% if(patientid_mandatory_yn.equals("Y") && !form_name.equals("FMChngStrLocnCriteriaForm") ) { %>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	<% } %>
		</td>

<% if(file_type_appl_yn.equals("N")) { %>

		<td class='label' nowrap width="25%"><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></td>
		<td class='fields' id='FileNo' width="25%"><input type="text" id="FileNum"  name="<%=fileno_name%>" id="<%=fileno_name%>"  onKeyPress='return CheckForSpecChars(event)' onBlur="ChangeUpperCase(this);getPatIDVolume(this.value);<%=file_no_function%>" maxlength="20" size="20" /> <!--Newly added  by Name :Selvin M  Date :12 july 2011 INCIDENT NO: 27494  Changes:newly added id --> 
		<% if(file_mandatory_yn.equals("Y") && !form_name.equals("FMChngStrLocnCriteriaForm")) { %>
		<img id="ingflag"  src='../../eCommon/images/mandatory.gif' align='center'></img>
		<% } %>	
		</td>

<% } else if(file_type_appl_yn.equals("Y")) { %>

		<td class='label' nowrap width="25%"><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
		<td class='fields' id='FileType' name='FileType' width="25%"><input type="text"  name="<%=filetype_name%>" id="<%=filetype_name%>" onBlur='<%=file_type_function%>' readonly>
		<% if(file_mandatory_yn.equals("Y") && !form_name.equals("FMChngStrLocnCriteriaForm")) { %>
		<img  id="ingflag1"  src='../../eCommon/images/mandatory.gif' align='center'></img>
		<% } %>	
		</td>
</tr>

<% } if(volume_no_appl_yn.equals("Y")) { %>
<tr>
	<td class='label'  ><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
	<td class='fields' id='volno' name='volno'><select name="<%=volumeno_name%>" id="<%=volumeno_name%>" onchange="<%=volume_no_function%>">
		<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
	</select>

<% if(volume_mandatory_yn.equals("Y")) { %>

		<img src='../../eCommon/images/mandatory.gif' align='center'></img>

<% } %>

	</td>
	<td class='label' colspan='2'>&nbsp;</td>
</tr>
<% } %>

</table>

<% 
	}
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close();
	
	ConnectionManager.returnConnection(connection,request);
}

%>

<input type="hidden" name="patientid_name" id="patientid_name" value="<%=patientid_name%>">
<input type="hidden" name="patient_id_function" id="patient_id_function" value="<%=patient_id_function%>">
<input type="hidden" name="patline_ID" id="patline_ID" value="<%=patline_ID%>">
<input type="hidden" name="patient_id_max_length" id="patient_id_max_length" value="<%=patient_id_max_length%>">
<input type="hidden" name="patline_yn" id="patline_yn" value="<%=patline_yn%>">

<input type="hidden" name="fileno_name" id="fileno_name" value="<%=fileno_name%>"> 
<input type="hidden" name="file_no_function" id="file_no_function" value="<%=file_no_function%>">

<input type="hidden" name="filetype_name" id="filetype_name" value="<%=filetype_name%>">
<input type="hidden" name="file_type_function" id="file_type_function" value="<%=file_type_function%>">
<input type="hidden" name="file_type_appl_yn" id="file_type_appl_yn" value="<%=file_type_appl_yn%>">
<input type="hidden" name="patient_file_type" id="patient_file_type" value="">
<input type="hidden" name="patient_file_type_desc" id="patient_file_type_desc" value="">

<input type="hidden" name="frame_name" id="frame_name" value="<%=frame_name%>">
<input type="hidden" name="frame_name1" id="frame_name1" value="<%=frame_name1%>">
<input type="hidden" name="messageframe_name" id="messageframe_name" value="<%=messageframe_name%>">

<input type="hidden" name="volumeno_name" id="volumeno_name" value="<%=volumeno_name%>">
<input type="hidden" name="volume_no_appl_yn" id="volume_no_appl_yn" value="<%=volume_no_appl_yn%>">

<input type="hidden" name="form_name" id="form_name" value="<%=form_name%>">
<input type="hidden" name="facilityID" id="facilityID" value="<%=facilityID%>">
<input type="hidden" name="function_name" id="function_name" value="<%=function_name%>">
<input type="hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%=maintain_doc_or_file%>">
<input type="hidden" name="chk_flag" id="chk_flag" value="Y">
<input type="hidden" name="chk_flag1" id="chk_flag1" value="N">
<input type="hidden" name="locn_code" id="locn_code" value="<%=locn_code%>">
<input type="hidden" name="fs_location" id="fs_location" value="<%=fs_location%>">
<input type="hidden" name="file_volume" id="file_volume" value="FILE_VOLUME">
<input type="hidden" name="file_mov_flag" id="file_mov_flag" value="<%=file_mov_flag%>">
<input type="hidden" name="file_mandatory_yn" id="file_mandatory_yn" value="<%=file_mandatory_yn%>">


<%
	if((file_type_appl_yn.equals("Y"))|| (maintain_doc_or_file.equals("D")))
	{
%>
	<input type="Hidden" name="<%=fileno_name%>" id="<%=fileno_name%>" value="">
<%
	}
%>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

