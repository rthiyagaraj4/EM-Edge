<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
		<%
		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<head><title><fmt:message key="eCA.TranscribeNotes.label" bundle="${ca_labels}"/></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
		<script src="../../eCommon/js/common.js" language='javascript'></script> 
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function onApply()
{
	if(document.forms[0].remarks.value.length > 400)
	{
		var msg = getMessage('RMRKS_MAX_LENGTH_CNT','CA');
		msg = msg.replace('$','400');
		alert(msg);
		return false;
	}
	else
	{
		var fields = new Array ( document.forms[0].transcriber );
			
		var names  = new Array ( getLabel("eCA.Transcriber.label","CA"));

		if(checkFieldsofMst( fields, names, parent.messageFrame)) 
		{
		var patient_id=document.forms[0].patient_id.value;
		var encounter_id=document.forms[0].encounter_id.value;
		var bean_key=document.forms[0].bean_key.value;
		var transcriber=document.forms[0].transcriber.value;
		var note_type=document.forms[0].note_type.value;

		
		//hash_key = patient_id+"~"+encounter_id;
		//hash_value = patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=addNoteToBean&patient_id="+patient_id+"&bean_key="+bean_key+"&encounter_id="+encounter_id+"&transcriber="+transcriber+"&note_type="+note_type, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		
		parent.TransReqFrame.TranscriptionReqPopUpForm.submit();
		}
	}
}

function getTranscriber_notes(obj)
 {
	
	if(obj.value!='')
	{
		getTranscriber_notes1(obj);
	}
	else
	{
		document.forms[0].transcriber.value = "";
		document.forms[0].transcriber_desc.value = "";
	}

	

 }
 async function getTranscriber_notes1(obj)
 {


		
		var target			= document.forms[0].transcriber_desc;
		//var target			= document.forms[0].practitioner;
		
        var val				= document.forms[0].facilityid.value;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= "";
				
		title				=  getLabel("eCA.Transcriber.label","CA");
	
		var locale			= document.forms[0].locale.value;
		var sql="";
       
		
			sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";

		
		 
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );	
		
		if(retArray != null && retArray !="")
		{
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}

		   document.forms[0].transcriber_desc.value = arr[1];
		   document.forms[0].transcriber.value = arr[0];
					
				
		}
		else
		{
			document.forms[0].transcriber_desc.value = "";
			document.forms[0].transcriber.value = "";
			
		}
 }



</script>



	<%
		 java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		 String locale = (String) p1.getProperty("LOCALE");
		 String userId =((String) session.getValue("ca_practitioner_id")).trim();
		 String facility_id		=	(String) session.getValue("facility_id");

		 eCA.PatientBannerGroupLine multiTransBean = null;

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		String dft_transc_qry ="select CA_GET_DEFAULT_TRANSCRIBER(?,?,?) dft_transcriber,AM_GET_DESC.AM_PRACTITIONER(CA_GET_DEFAULT_TRANSCRIBER(?,?,?),?,'1') DEFAULT_TRANSCRIBER_DESC from dual ";

		String transcriber_qry = "select PRACTITIONER_ID, PRACTITIONER_NAME from AM_PRACTITIONER_LANG_VW where PRACT_TYPE = 'TR' and LANGUAGE_ID = ? order by 2 ";

		String practitioner_id ="";
		String practitioner_name ="";
		String bean_key				 =	"";
		String CurrentDate			 =	"";
		String CurrentTime			 =	"";
		String patient_id			 =	"";
		String encounter_id			 =	"";
		String note_type			 =	"";
		String patient_class		 =	"";
		String speciality_code		 =	"";
		String performed_by_id		 =	"";
		String dft_transcriber		 =	"";
		String dft_transcriber_desc		 =	"";
		String trans_sel			 =	"";
		

		patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
		encounter_id			=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
		note_type			=	(request.getParameter("note_type")==null)	?	""	:	request.getParameter("note_type");
		patient_class			=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
		speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
		performed_by_id			=	(request.getParameter("performed_by_id")==null)	?	""	:	request.getParameter("performed_by_id");

		CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		CurrentTime	= com.ehis.util.DateUtils.getCurrentDate("HM",locale);

		bean_key = userId+CurrentDate+CurrentTime;

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);



	%>



	</head>
	<body onKeyDown="lockKey()">
		<form name='TranscriptionReqPopUpForm' id='TranscriptionReqPopUpForm' method='post' target='messageFrame' action='../../servlet/eCA.MultiTransRequestServlet' >
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center" >
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td class='label' width='25%'><fmt:message key="eCA.Transcriber.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='50%'>
				
				
			<!--	<select name="transcriber" id="transcriber" onChange="">
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> -->
		<%
		
			try
			{
			
			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(dft_transc_qry);
			
			stmt.setString(1,performed_by_id);
			stmt.setString(2,speciality_code);
			stmt.setString(3,patient_class);
			stmt.setString(4,performed_by_id);
			stmt.setString(5,speciality_code);
			stmt.setString(6,patient_class);
			stmt.setString(7,locale);

			rs = stmt.executeQuery();

			while(rs.next())
				{
					
					dft_transcriber = rs.getString("dft_transcriber")==null?"":rs.getString("dft_transcriber");
					dft_transcriber_desc = rs.getString("DEFAULT_TRANSCRIBER_DESC")==null?"":rs.getString("DEFAULT_TRANSCRIBER_DESC");
				


				}
				
				if (rs!=null)	rs.close();
				if (stmt!=null) stmt.close();

			
			stmt = con.prepareStatement(transcriber_qry);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();

				while(rs.next())
				{
					
					practitioner_id = rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID");

					practitioner_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
					if(dft_transcriber.equals(practitioner_id))
						{
							trans_sel="selected";
						}
						else
						{
							trans_sel="";
						}

					
					
					%>
				<!--	<option value="<%=practitioner_id%>" <%=trans_sel%>><%=practitioner_name%></option> -->
					
					<%					


				}
				if (rs!=null)	rs.close();
				if (stmt!=null) stmt.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			finally 
			{
				ConnectionManager.returnConnection(con,request);
			}
		
		
		%>
			<input type='hidden' name='transcriber' id='transcriber' value="<%=dft_transcriber%>">
				<input type='text' name='transcriber_desc' id='transcriber_desc' size=30 maxlength='30' value='<%=dft_transcriber_desc%>' onBlur ="getTranscriber_notes(this);" ><input type='button' class='button' value='?' id='src_butn'  name='search_pract' id='search_pract' onClick="getTranscriber_notes1(this);" ><img src='../../eCommon/images/mandatory.gif'>
					
			<!--	</select> -->
			
			</td>
			<td class='label' width='25%'></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields' width='75%'>
				<textarea name="remarks" rows='13' maxlength=400   onKeyPress=''   onBlur="" cols='70' ></textarea>
			
			</td>

		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		
		<tr>
			<td class='label' width='25%' ></td><td width='25%' align='right'><input type='button' class='button' value='Apply'  name='apply' id='apply' onClick="onApply();">
			<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' id='cancel_btn'  name='cancel_btn' onClick="window.close();"></td>
		</tr>

		</table>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
		<input type="hidden" name="practitionerId" id="practitionerId" value="<%=userId%>">
		<input type="hidden" name="bean_key" id="bean_key" value="<%=bean_key%>">
		<input type="hidden" name="modal_yn" id="modal_yn" value="Y">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="facilityid" id="facilityid" value="<%=facility_id%>">
		</form>
  </body>
</html>

