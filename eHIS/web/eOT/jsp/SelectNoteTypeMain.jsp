<!DOCTYPE html>

<%@ page import ="java.sql.PreparedStatement,java.sql.Connection,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% 	
	boolean notes_entered_flag	= false;
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");	
	String locale = (String)session.getAttribute("LOCALE"); 
	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	int notes_count = 0;
	String query_flag_yn	= request.getParameter("query_flag_yn");
try{
	query_flag_yn=query_flag_yn==null?"N":query_flag_yn;
	query_flag_yn=query_flag_yn.equalsIgnoreCase("null")?"N":query_flag_yn;
	query_flag_yn=query_flag_yn.equals("")?"N":query_flag_yn;
	String old_session_user_id	= (String)session.getValue("login_user");
	String called_from	= request.getParameter("called_from"); //SURGEON_NOTES, NURSING_NOTES, HOLD_NOTES, RECOVERY_NOTES, OPERATIVE_NOTES, PRE_ANES, INTRA_ANES, POST_ANES
	String oper_num	= request.getParameter("accession_num"); //oper_num
	String speciality_code	= request.getParameter("speciality_code");
	String locn_type		= request.getParameter("locn_type");
// Start of ANAESTHESIA arguments
	String anesthesia_srl_no		= request.getParameter("anesthesia_srl_no");
	String anesthesia_accession_num	= request.getParameter("anesthesia_accession_num");
// End of ANAESTHESIA arguments
	String facility_id		= request.getParameter("facility_id");
	String patient_id	= request.getParameter("patient_id");
	String episode_id	= request.getParameter("episode_id");
	String encounter_id	= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("patient_class");
	String contr_mod_accession_num = "";
	if(called_from.equalsIgnoreCase("OPERATIVE_NOTES"))
		locn_type="99";

	if(called_from.equals("PRE_ANES") || called_from.equals("INTRA_ANES") || called_from.equals("POST_ANES")){
		if(called_from.equals("PRE_ANES"))
			contr_mod_accession_num = facility_id+anesthesia_srl_no+"PRE"+anesthesia_accession_num;
		else if(called_from.equals("INTRA_ANES"))
			contr_mod_accession_num = facility_id+anesthesia_srl_no+"INTRA";
		else if(called_from.equals("POST_ANES"))
			contr_mod_accession_num = facility_id+anesthesia_srl_no+"POST";
	}else{
		if(speciality_code.equalsIgnoreCase("all"))
			contr_mod_accession_num = facility_id+oper_num+"*ALL"+speciality_code+locn_type;
		else
			contr_mod_accession_num = facility_id+oper_num+speciality_code+locn_type;
	}
	String accession_num = "";
	String url1 = response.encodeURL("../../eCA/jsp/RecClinicalNotesModal.jsp?");
	String url2 = response.encodeURL("../../eCA/jsp/PhysicanNotesDetails.jsp");
%>

<html>
<title><fmt:message key="eOT.SelectNoteType.Label" bundle="${ot_labels}"/></title>
<head>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function callclose()
{	
	parent.window.close();
}
function callRecordNotes(){
	//alert("Enters in callRecordNotes");
	var formObj =  document.SelectNoteTypeForm;
	var query_flag_yn = formObj.query_flag_yn.value;
	var old_session_user_id=formObj.old_session_user_id.value;
	called_from = formObj.called_from.value;
	var update_mode = formObj.update_mode.value; // This is being used only for Anaesthesia.
	var secondwindow;
	if(formObj.note_type.value==""){
		//alert("Select the Note Type");
		formObj.note_type.focus;
	}else{
		if(!parent.window.closed)
		{
				parent.window.close();
		}

		
		var oTAssessment    = getLabel("Common.Assessment.label","Common");
		var surgeonNotes    = getLabel("eOT.SurgeonNotes.Label","OT");
		var nursingNotes	= getLabel("eOT.NursingNotes.Label","OT");
		var operativeRecords= getLabel("eOT.OperativeRecords.Label","OT");
		var holdingAreaNotes= getLabel("eOT.HoldingAreaNotes.Label","OT");
		var recoveryNotes   = getLabel("eOT.RecoveryNotes.Label","OT");
		var preAnesthesiaDetails    =getLabel("eOT.PreAnaesthesiaDetails.Label","OT");
		var intraAnesthesiaDetails= getLabel("eOT.IntraAnaesthesiaDetails.Label","OT");
		var postAnesthesiaDetails   =getLabel("eOT.PostAnaesthesiaDetails.Label","OT");
		
		
		var tab_yn="N";
		var title= oTAssessment ;
		if(called_from=="SURGEON_NOTES")
			title = surgeonNotes  ;
		if(called_from=="NURSING_NOTES")
			title = nursingNotes ;
		if(called_from=="OPERATIVE_NOTES"){
			tab_yn="Y";
			title = operativeRecords ;
		}
		if(called_from=="HOLD_NOTES")
			title = holdingAreaNotes ;
		if(called_from=="RECOVERY_NOTES")
			title = recoveryNotes  ;
		if(called_from=="PRE_ANES"){
			tab_yn="Y";
			title = preAnesthesiaDetails ;
		}
		if(called_from=="INTRA_ANES"){
			tab_yn="Y";
			title = intraAnesthesiaDetails ;
		}
		if(called_from=="POST_ANES"){
			tab_yn="Y";
			title = postAnesthesiaDetails  ;
		}
//alert("update_mode :" +update_mode);
//alert("query_flag_yn :" +query_flag_yn);
//alert("called_from :" +called_from);

		if((update_mode=="Y") && (called_from=="PRE_ANES" || called_from=="INTRA_ANES" || called_from=="POST_ANES" || called_from=="OPERATIVE_NOTES"))
			tab_yn="N";
		tab_yn="N";
		var facility_id = formObj.facility_id.value;
		var note_type= formObj.note_type.value;
		var patient_id = formObj.patient_id.value;
		var episode_id = formObj.episode_id.value;
		var patient_class = formObj.patient_class.value;
		var encounter_id = formObj.encounter_id.value;
		var function_id="SPCL_NOTE";
		var event_class="$PHY$";
		var accession_num=formObj.accession_num.value;
		var window_close="Y";
		var ot_speciality_code=formObj.speciality_code.value;
		var hide_header="N";
		var contr_mod_accession_num = formObj.contr_mod_accession_num.value;
		//alert("contr_mod_accession_num===="+contr_mod_accession_num);
	//var contr_mod_accession_num = facility_id+formObj.oper_num.value+ot_speciality_code+formObj.locn_type.value;
	//alert("Before Url");
	var url="";
	
		if(query_flag_yn=="N"){
			//alert("1");
			 //url = '<%=url1%>'+"&title="+title+"&appl_task_id=CLINICAL_NOTES"+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+ot_speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num;
			 url = '<%=url1%>'+"&title="+title+"&appl_task_id=OT_NOTES"+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+ot_speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num;
		}else if(query_flag_yn=="Y"){
			//alert("2");
			 //url = '<%=url2%>'+"&title="+title+"&appl_task_id=CLINICAL_NOTES"+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+ot_speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num;
			 url = '<%=url2%>'+"&title="+title+"&appl_task_id=OT_NOTES"+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+ot_speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num;
		}
		//alert("URL--->138"+url);
	//	alert("enter");
		/*var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert("12");
	alert("url"+url)
		xmlHttp.open("POST","SurgeonNoteselect.jsp?title="+title+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+ot_speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);		
		var url_notes=retVal;*/
		//alert("retVal-"+retVal);
		
	var dialogHeight = window.screen.availHeight-28 ;
	var dialogWidth  = window.screen.availWidth-10 ;
	//var dialogTop    = "200";
	//var dialogLeft   = "100";
	var dialogTop    = "0";
	var dialogLeft   = "0";
	//var features     = "dialogHeight=" + dialogHeight + ", dialogWidth=" + dialogWidth+ ", dialogLeft=" + dialogLeft+ ", dialogTop=" +dialogTop+ ", status=no" ;
	var features = "Height=" + dialogHeight + ",Width=" + dialogWidth+ ", left="+dialogLeft+",top="+dialogLeft+",status=no,resizable=no";
	var arguments    = "CAwindow" ;
	//retVal  = window.showModalDialog(url, arguments, features);
	secondwindow  = window.open(url, arguments, features);

//		parent.f_set_user_attribute.location.href="../../eOT/jsp/SelectNoteTypeSetUserAttribute.jsp?old_session_user_id="+old_session_user_id;

	}
}
function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    // get the string
    outString = inString.substring(startPos, endPos + 1);

    return outString;
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SelectNoteTypeForm" id="SelectNoteTypeForm">
<%
	String update_mode			= "N";
	String note_type_count		= "";
	String speciality_code_1	= "";
	String sql					= "";
	String note_type_code		= "";
	String note_type_desc		= "";
	connection = ConnectionManager.getConnection(request);	
// exists?
//	sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE";
	
	//sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE AND H.LANGUAGE_ID='"+locale+"' ";
	sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE and Event_Status <> '9' AND H.LANGUAGE_ID='"+locale+"' ";//added by Sanjay for Surgeon Notes against IN34391

	pstmt=connection.prepareStatement(sql);
	pstmt.setString(1,contr_mod_accession_num);
	resultset=pstmt.executeQuery();
	while(resultset.next()){
		update_mode="Y";
		notes_entered_flag=true;
		accession_num  = resultset.getString("ACCESSION_NUM");
		note_type_code = resultset.getString("NOTE_TYPE");
		note_type_desc = resultset.getString("NOTE_TYPE_DESC");
	}
	if(notes_entered_flag==false){
		if(called_from.equalsIgnoreCase("OPERATIVE_NOTES")){
			notes_entered_flag=true;
	//		sql = "SELECT P.OPERATIVE_RECORDS_NOTE_TYPE OPERATIVE_RECORDS_NOTE_TYPE, 				N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM OT_PARAM P, CA_NOTE_TYPE_LANG_VW

			sql = "SELECT P.OPERATIVE_RECORDS_NOTE_TYPE OPERATIVE_RECORDS_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM OT_PARAM P, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=P.OPERATIVE_RECORDS_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			resultset=pstmt.executeQuery();
			while(resultset.next()){
				note_type_code = resultset.getString("OPERATIVE_RECORDS_NOTE_TYPE");
				note_type_desc = resultset.getString("NOTE_TYPE_DESC");
			}
		}else if(called_from.equalsIgnoreCase("PRE_ANES") || called_from.equalsIgnoreCase("INTRA_ANES") || called_from.equalsIgnoreCase("POST_ANES")){
			accession_num = "";
			notes_entered_flag=true;
			if(called_from.equalsIgnoreCase("PRE_ANES"))
				sql = "SELECT A.PRE_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.PRE_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			else if(called_from.equalsIgnoreCase("INTRA_ANES"))
				sql = "SELECT A.INTRA_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.INTRA_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			if(called_from.equalsIgnoreCase("POST_ANES"))
				sql = "SELECT A.POST_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.POST_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			resultset=pstmt.executeQuery();
			while(resultset.next()){
				note_type_code = resultset.getString("ANES_NOTE_TYPE");
				note_type_desc = resultset.getString("NOTE_TYPE_DESC");
			}
		}else{
			if(speciality_code.equalsIgnoreCase("all"))
				speciality_code_1="*ALL";
			else {
				speciality_code_1 = speciality_code;

				sql="SELECT COUNT(*) NOTE_TYPE_COUNT FROM OT_NOTE_TYPE_FOR_SPECIALTIES WHERE SPECIALTY_CODE=? AND LOCN_TYPE=?";

				if(resultset!=null) resultset.close();
				if(pstmt!=null) pstmt.close();		
				pstmt=connection.prepareStatement(sql);
				pstmt.setString(1,speciality_code_1);
				pstmt.setString(2,locn_type);
				resultset=pstmt.executeQuery();

				while(resultset.next()){
					note_type_count = resultset.getString("NOTE_TYPE_COUNT");
				}
				if(note_type_count.equals("0"))
					speciality_code_1="*ALL";
			}
			sql="SELECT S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C WHERE SPECIALTY_CODE=? AND LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID='"+locale+"'";

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,speciality_code_1);
			pstmt.setString(2,locn_type);
			resultset=pstmt.executeQuery();
		}
	}
%>
<table border='0' cellpadding=3  cellspacing='0' align='center'  width='100%' >
<%
// from query string
%>
<tr>
	<td class="labels" width="25%">
		<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>
	</td>
	<%
	if(notes_entered_flag==false){
	%>
		<td class="fields" width="25%" colspan="3">
			<select name="note_type" id="note_type">
			<option value="" selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<%
					while(resultset.next()){
						notes_count++;
						note_type_code = resultset.getString("NOTE_TYPE");
						note_type_desc = resultset.getString("NOTE_TYPE_DESC");
				%>
						<option value="<%=note_type_code%>"> 
							<%=note_type_desc%>	
						</option>
				<%
					}
				%>
			</select>
		</td>
	<%
		}else{
	%>
		<td width="25%" class="fields" >
		<select name="note_type" id="note_type" disabled>
		<option value="<%=note_type_code%>" selected><%=note_type_desc%>
		</option>
		</select>
		</td>
	<%
		}
	%>
</tr>
<tr>
	<td align="right" class="button" colspan="2">
		<input type="button" class="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="callRecordNotes();callclose();">
		<input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.returnValue='';callclose();">
	</td>

</tr>
</table>
	<input type='hidden' name='update_mode' id='update_mode' value="<%=update_mode%>" >
	<input type='hidden' name='old_session_user_id' id='old_session_user_id' value="<%=old_session_user_id%>" >
	<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>" >
	<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>" >
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
	<input type='hidden' name='accession_num' id='accession_num' value="<%=accession_num%>" >
	<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>" >

	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
	<input type='hidden' name='episode_id' id='episode_id' value="<%=episode_id%>" >
	<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>" >
	<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>" >
	<input type='hidden' name='locn_type' id='locn_type' value="<%=locn_type%>" >
	<input type='hidden' name="patient_class" id="patient_class" value="<%=patient_class%>" >		
	<input type='hidden' name="contr_mod_accession_num" id="contr_mod_accession_num" value="<%=contr_mod_accession_num%>" >		
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name="notes_entered_flag" id="notes_entered_flag" value="<%=notes_entered_flag%>" >				
	<input type='hidden' name="notes_count" id="notes_count" value="<%=notes_count%>" >				
	<input type='hidden' name='query_flag_yn' id='query_flag_yn' value="<%=query_flag_yn%>" >

</form>
</body>
</html>
<script>
	var formObj =  document.SelectNoteTypeForm;
	var notes_entered_flag = formObj.notes_entered_flag.value;
	var notes_count = formObj.notes_count.value;
	if(notes_count==1)
		formObj.note_type.options[1].selected=true;
	if(notes_entered_flag=="true" || notes_count==1)
		callRecordNotes();
</script>
<%	
	}catch(Exception e){
		System.err.println("208: Caught Exception in Select Note Type Form"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		ConnectionManager.returnConnection(connection,request);
	}
%>

