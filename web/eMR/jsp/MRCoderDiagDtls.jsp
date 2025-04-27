<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*, eCommon.Common.*,org.json.simple.*"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<%	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/coaderstyle.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src="../../eMR/js/MRCoderDiagDtls.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script> 
	
	window.onload=function(){
		var termSetCount	= document.forms[0].termSetCount.value;	
		var diagnosisRowCount	= document.forms[0].diagnosisRowCount.value;	
		var visit_adm_date_time	= document.forms[0].visit_adm_date_time.value;
		if(termSetCount==1){
			for(id=0;id<diagnosisRowCount;id++){
				var termSetId	= eval("document.forms[0].termSetId_"+id).value;
				var chk			= eval("document.forms[0].chk_"+id).checked;
				if(termSetId!="" && chk==false){
					eval("document.forms[0].onset_date_"+id).value = visit_adm_date_time;
				}
			}
		}
	}
	

</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	Connection con				= null;
	String facilityId			= (String) session.getValue("facility_id");
	String locale				= (String) session.getValue("LOCALE");

	JSONArray diagClassicationArr = new JSONArray();
	JSONArray termSetArr = new JSONArray();
	JSONArray diagnosisListArr = new JSONArray();

	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String encounter_id			= checkForNull(request.getParameter("encounter_id"));
	String dob			= checkForNull(request.getParameter("Dob"));
	String age			= checkForNull(request.getParameter("Age"));
	String sex			= checkForNull(request.getParameter("Sex"));
	String speciality_code			= checkForNull(request.getParameter("speciality_code"));
	String visit_adm_date_time			= checkForNull(request.getParameter("visit_adm_date"));
	String modified_date			= "";
	
	int inc						= 0;
	int coderCount						= 0;
	JSONObject jsonObj	= new JSONObject();
	JSONObject jsonDiagObj	= new JSONObject();
	//int noOfRecs			= 0;

	int diagnosisRowCount		= 40;//Changed from 25 to 45 for AAKH-CRF-0153
	int termSetCount			= 0;
	String existingTermCodeDtls	= "";

	try	{
		con = ConnectionManager.getConnection(request);
		/*termSetId	= eMR.MRCoaderDiagBean.getTermsetId(con);
		if(termSetId.equals("")){
			termSetId	= "ICD10";
		}*/

		//diagClassicationArr  = eMR.MRCoaderDiagBean.getDiagClassification(con,termSetId,locale);
		termSetArr  = eMR.MRCoaderDiagBean.getTermsetList(con);
		termSetCount	= termSetArr.size();

		jsonDiagObj  =  eMR.MRCoaderDiagBean.getDiagnosisList(con,patient_id,encounter_id,facilityId,locale);
		//noOfRecs	= (Integer) jsonDiagObj.get("noOfRecs");
		coderCount	= (Integer) jsonDiagObj.get("coderCount");
		if(coderCount > 0){
			existingTermCodeDtls	= eMR.MRCoaderDiagBean.getExistingTermCodeDtls(con,encounter_id,facilityId);
		}

		diagnosisListArr 			= (JSONArray)jsonDiagObj.get("diagnosisList");
		int diagnosisListCount		= diagnosisListArr.size();

		
		%>
<center>
<form name="RecDaignosis_form" id="RecDaignosis_form" method="post" action="../../servlet/eMR.MRCoaderDiagServlet" target="messageFrame">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  
    <tr>
      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="BOLD">Details</td>
        </tr>
        <tr>
          <td>
          <table border="0" id="table" >
    <thead>

<tr>
        <th width="17%"><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></th>
        <th width="17%"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Classification.label" bundle="${common_labels}"/></th>
        <th width="23%"><fmt:message key="Common.code.label" bundle="${common_labels}"/> / <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
        <th width="9%"><fmt:message key="eMR.POAIndicator.label" bundle="${mr_labels}"/></th>
        <th width="14%"><fmt:message key="eMR.ONSET_DATE.label" bundle="${mr_labels}"/></th>
        <th width="6%"><fmt:message key="eMR.ToBeReported.label" bundle="${mr_labels}"/>
		<th width="6%"><fmt:message key="Common.Add.label" bundle="${common_labels}"/> / <fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
      </tr>
    </thead>
  </table>
<div id="dataD">
  <table border="0" id="table" >
<%
	

for(int j=0;j<diagnosisRowCount;j++){
	String disableFields	= "disabled";
	String termSetId				= "";	
	String diagClass				= "";	
	String termCode					= "";	
	String termShortDesc			= "";
	String poaIndicator				= "";
	String onSetDate				= "";
	String reportedChk				= "";
	String delChk					= "";
	String default_term_set_id		= "";
	int diagClassSize				= 0;
	if(j<diagnosisListCount){
		JSONObject diagnosisList	= (JSONObject)diagnosisListArr.get(j);
		termSetId					= (String) diagnosisList.get("term_set_id");
		diagClass					= (String) diagnosisList.get("diag_class_code");
		termCode					= (String) diagnosisList.get("term_code");
		termShortDesc				= (String) diagnosisList.get("term_short_desc");
		poaIndicator				= (String) diagnosisList.get("poa_indicator");
		onSetDate					= (String) diagnosisList.get("onset_date");
		reportedChk					= (String) diagnosisList.get("reported_yn");
		
		if(j==0){
			modified_date				= (String) diagnosisList.get("modified_date");
		}
		diagClassicationArr			= eMR.MRCoaderDiagBean.getDiagClassification(con,termSetId,locale);
		diagClassSize				= diagClassicationArr.size();			
		if(reportedChk.equals("Y")){
			reportedChk	= "checked";
		}
		disableFields	= "";
		delChk	= "checked";
	}else{
		if(termSetCount==1){
			for(inc = 0 ; inc < termSetArr.size() ; inc++) { 
				jsonObj	= (JSONObject)termSetArr.get(inc);
				default_term_set_id = (String) jsonObj.get("term_set_id");						
			}
			diagClassicationArr			= eMR.MRCoaderDiagBean.getDiagClassification(con,default_term_set_id,locale);
			diagClassSize				= diagClassicationArr.size();
			disableFields	= "";
			reportedChk	= "checked";
			delChk	= "";
		}
	}
%>
     <tr class="gridData">
	 <td  width="17%"><select name="termSetId_<%=j%>" id="termSetId_<%=j%>" onChange="enableDisableFields('<%=j%>')" style="width:145px;">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>

				<%for(inc = 0 ; inc < termSetArr.size() ; inc++) { 
					jsonObj	= (JSONObject)termSetArr.get(inc);
					String term_set_id = (String) jsonObj.get("term_set_id");						
					String term_set_desc = (String) jsonObj.get("term_set_desc");
					%>
					<option value="<%=term_set_id%>" <%if(term_set_id.equals(termSetId) || term_set_id.equals(default_term_set_id)){%> selected<%}%>><%=term_set_desc%></option>
				<%}%>
			</select> 
</td>
      <td  width="17%" >
			<select name="diag_class_<%=j%>" id="diag_class_<%=j%>" <%=disableFields%> onChange="chkPrimaryDiag('<%=j%>')">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			<%			
				for(inc = 0 ; inc < diagClassSize ; inc++) { 
					jsonObj	= (JSONObject)diagClassicationArr.get(inc);
					String diagClassCode = (String) jsonObj.get("diagClassCode");						
					String diagShortDesc = (String) jsonObj.get("diagShortDesc");
					%>
					<option value="<%=diagClassCode%>" <%if(diagClassCode.equals(diagClass)){%> selected<%}%>><%=diagShortDesc%></option>
				<%}%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center' name="img_diag_class_<%=j%>" style="display:none;"/></td>
                <td width="24%"  >
			<!-- Size changed from 22 to 72 for AAKH-CRF-0153 by Kamatchi S-->
			<input type='textbox' name='diagprob_code_<%=j%>' id='diagprob_code_<%=j%>' size='5'  value="<%=termCode%>" onBlur="getDescription(this.value,'<%=j%>');" <%=disableFields%>>&nbsp;<input type="text"  name="diagprob_desc_<%=j%>" id="diagprob_desc_<%=j%>" value="<%=termShortDesc%>" size=72 readonly onblur='' <%=disableFields%>> 
			<input type='button' name="btn_diagprob_code_<%=j%>" id="btn_diagprob_code_<%=j%>" class='button' value='?' onclick='show_window("<%=j%>");' <%=disableFields%>>
			<img src='../../eCommon/images/mandatory.gif' align='center' name="img_diagprob_code_<%=j%>" style="display:none;"/> </td>
                <td width="9%"  >
                  <select name="poa_indicator_<%=j%>" id="poa_indicator_<%=j%>" <%=disableFields%>>
					<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="Y" <%if(poaIndicator.equals("Y")){%> selected<%}%>>Y</option>
					<option value="N" <%if(poaIndicator.equals("N")){%> selected<%}%>>N</option>
					<option value="U" <%if(poaIndicator.equals("U")){%> selected<%}%>>U</option>
					<option value="W" <%if(poaIndicator.equals("W")){%> selected<%}%>>W</option>
					<option value="1" <%if(poaIndicator.equals("1")){%> selected<%}%>>1</option>
				</select>
                  <img src='../../eCommon/images/mandatory.gif' align='center' name="img_poa_indicator_<%=j%>" style="display:none;"/>
				</td>
                <td width="14%" style="padding-left:5px;" ><input type='text' name='onset_date_<%=j%>' id='onset_date_<%=j%>'  id='date_<%=j%>' size='14' maxlength='16' <%=disableFields%> value="<%=onSetDate%>" onBlur="chkDateVal(this);"> 
                <img src="../../eCommon/images/CommonCalendar.gif" onClick="eval(document.forms[0].onset_date_<%=j%>).focus();return showCalendar('date_<%=j%>',null,'hh:mm');" name="cal_img_onset_date_<%=j%>" <%=disableFields%>/><img src='../../eCommon/images/mandatory.gif' align='center' name="img_onset_date_<%=j%>" style="display:none;"/></td>
                <td width="6%" style="text-align:center"  ><input type="checkbox" name="chk_reported_<%=j%>" id="chk_reported_<%=j%>" id="chk_reported_<%=j%>" <%=disableFields%> <%=reportedChk%> value="Y"/></td>
				<td width="6%" style="text-align:center" ><input type="checkbox" name="chkRow" id="chkRow" id="chk_<%=j%>" value="<%=j%>"  <%=disableFields%> <%=delChk%>/></td>
                </tr>
				<%}%>
  </table>
</div>
</td>
 </tr>
        <tr>
        <td style="text-align:right"  class="Borderbottom"><input type="button" name="Save2" id="Save2" id="Save2" value="Save" onClick="fnSave();" /></td>
      </tr>
      </table></td>
    </tr>
</table>
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>"/> 
		<input type='hidden' name='EncounterId' id='EncounterId' value="<%=encounter_id%>"/> 
		<input type='hidden' name='dob' id='dob' value="<%=dob%>"/> 
		<input type='hidden' name='gender' id='gender' value="<%=sex%>"/> 
		<input type='hidden' name='age' id='age' value="<%=age%>"/> 
		<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>"/> 
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>"/> 
		<input type='hidden' name='locale' id='locale' value="<%=locale%>"/> 
		<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value=""/> 
		<input type='hidden' name='diagnosisRowCount' id='diagnosisRowCount' value="<%=diagnosisRowCount%>"/> 
		<input type='hidden' name='selectedRows' id='selectedRows' value=""/> 
		<input type='hidden' name='coderCount' id='coderCount' value="<%=coderCount%>"/> 
		<input type='hidden' name='patientClass' id='patientClass' value="<%=patient_class%>"/> 
		<input type='hidden' name='termSetCount' id='termSetCount' value="<%=termSetCount%>"/> 
		<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value="<%=visit_adm_date_time%>"/> 
		<input type='hidden' name='existingTermCodeDtls' id='existingTermCodeDtls' value="<%=existingTermCodeDtls%>"/> 
		<input type='hidden' name='modified_date' id='modified_date' value="<%=modified_date%>"/> 
		
	</form>
	</center>
		
<%	} catch(Exception ex){
		ex.printStackTrace() ;
	} finally {
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

