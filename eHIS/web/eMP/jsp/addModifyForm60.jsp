<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<Script language='javascript' src='../../eMP/js/Form60.js'></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
</link>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	Connection con=null;
	try {
	String reqPatientId				= checkForNull(request.getParameter("patientId"));
	String reqEncounterId			= checkForNull(request.getParameter("encounterId"));
	String reqStatus				= checkForNull(request.getParameter("status"));
	String facilityId				= checkForNull(request.getParameter("facilityId"));
	String episodeId				= checkForNull(request.getParameter("episodeId"));
	String episodeType				= checkForNull(request.getParameter("episodeType"));
	String opEpisodeVisitNum		= checkForNull(request.getParameter("opEpisodeVisitNum"));
	String locale					= (String) session.getValue( "LOCALE" ) ;
	
	
			con =  ConnectionManager.getConnection(request);
		
			JSONObject form60DtlsJsonObj				= new JSONObject();
			form60DtlsJsonObj							= eMP.MPForm60Bean.getForm60Details(con,reqPatientId,reqEncounterId,reqStatus,locale);
			JSONArray form60DtlsArray 					= (JSONArray)form60DtlsJsonObj.get("form60Details");
			JSONObject form60DtlsList					= (JSONObject)form60DtlsArray.get(0);

			String firstName							= (String) form60DtlsList.get("firstName");                                          
			String middleName							= (String) form60DtlsList.get("middleName");                                              
			String surname								= (String) form60DtlsList.get("surname");                                          
			String dobInsOfDec							= (String) form60DtlsList.get("dobInsOfDec");                                               
			String fatherFirstName						= (String) form60DtlsList.get("fatherFirstName");                                                
			String fatherMiddleName						= (String) form60DtlsList.get("fatherMiddleName");                                                   
			String fatherSurname						= (String) form60DtlsList.get("fatherSurname");                                                
			String flatRoomNo							= (String) form60DtlsList.get("flatRoomNo");                                            
			String floorNo								= (String) form60DtlsList.get("floorNo");                                          
			String nameOfPremises						= (String) form60DtlsList.get("nameOfPremises");               
			String blockNameNo							= (String) form60DtlsList.get("blockNameNo");               
			String roadStreetLane						= (String) form60DtlsList.get("roadStreetLane");             
			String areaLocality							= (String) form60DtlsList.get("areaLocality");                
			String townCity								= (String) form60DtlsList.get("townCity");                      
			String district								= (String) form60DtlsList.get("district");                                      
			String state								= (String) form60DtlsList.get("state");                                   
			String country								= (String) form60DtlsList.get("country");                                     
			String pinCode								= (String) form60DtlsList.get("pinCode");                                     
			String telephoneNo							= (String) form60DtlsList.get("telephoneNo");                                        
			String mobileNo								= (String) form60DtlsList.get("mobileNo");                                      
			//String amountOfTransaction					= (String) form60DtlsList.get("amountOfTransaction");                                                 
			//String dateOfTransaction					= (String) form60DtlsList.get("dateOfTransaction");                                                 
			String noOfPersonsInvolved					= (String) form60DtlsList.get("noOfPersonsInvolved");                                                  
			String trans_mode_cash_yn					= (String) form60DtlsList.get("trans_mode_cash_yn");                                                     
			String trans_mode_cheque_yn					= (String) form60DtlsList.get("trans_mode_cheque_yn");                                                     
			String trans_mode_card_yn					= (String) form60DtlsList.get("trans_mode_card_yn");                                                     
			String trans_mode_dbs_yn					= (String) form60DtlsList.get("trans_mode_dbs_yn");                                                     
			String trans_mode_online_transfer_yn		= (String) form60DtlsList.get("trans_mode_online_transfer_yn");                                                        
			String trans_mode_other_yn					= (String) form60DtlsList.get("trans_mode_other_yn");                                                       
			String AdharNoIssuedByUIDAI					= (String) form60DtlsList.get("AdharNoIssuedByUIDAI");                                                    
			String isAppliedForPan						= (String) form60DtlsList.get("isAppliedForPan"); 
			if( (isAppliedForPan.equals("")) || (isAppliedForPan.equals("null")) || (isAppliedForPan==null))
				isAppliedForPan = "N";

			String PANAcknowledgement					= (String) form60DtlsList.get("PANAcknowledgement");                                                 
			String PANDateOfApplication					= (String) form60DtlsList.get("PANDateOfApplication");                                                    
			String estAgriIncome						= (String) form60DtlsList.get("estAgriIncome");                                           
			String estNonAgriIncome						= (String) form60DtlsList.get("estNonAgriIncome");                                                 
			String idProofDocCode						= (String) form60DtlsList.get("idProofDocCode");                                              
			String idProofDocIdNo						= (String) form60DtlsList.get("idProofDocIdNo");                                              
			String idProofNameAddOfAuthority			= (String) form60DtlsList.get("idProofNameAddOfAuthority");                                                         
			String addProofDocCode						= (String) form60DtlsList.get("addProofDocCode");                                               
			String addProofDocIdNo						= (String) form60DtlsList.get("addProofDocIdNo");                                               
			String addProofNameAddOfAuthority			= (String) form60DtlsList.get("addProofNameAddOfAuthority");  
			
			String acknowledg_no_form60					= (String) form60DtlsList.get("ACKNOWLEDG_NO_FORM60");

			JSONObject idProofDocCodeJsonObj			= new JSONObject();
			idProofDocCodeJsonObj						= eMP.MPForm60Bean.getIdAddressProofDtls(con,"I");
			JSONArray idProofDocCodeArray 				= (JSONArray)idProofDocCodeJsonObj.get("results");

			JSONObject addProofDocCodeJsonObj			= new JSONObject();
			addProofDocCodeJsonObj						= eMP.MPForm60Bean.getIdAddressProofDtls(con,"A");
			JSONArray addProofDocCodeArray 				= (JSONArray)addProofDocCodeJsonObj.get("results");
		
			JSONObject blTransDtlsJsonObj				= new JSONObject();
			blTransDtlsJsonObj							= eMP.MPForm60Bean.getBlTransDtls(con,facilityId,reqPatientId,episodeId,episodeType,opEpisodeVisitNum);
			JSONArray blTransDtlsArray 					= (JSONArray)blTransDtlsJsonObj.get("blTransDtls");
			JSONObject blTransDtlsList					= (JSONObject)blTransDtlsArray.get(0);
			String dateOfTransaction					= (String) blTransDtlsList.get("transaction_date");                                          
			String amountOfTransaction					= (String) blTransDtlsList.get("transaction_amount");                                              
			String transaction_mode						= (String) blTransDtlsList.get("transaction_mode");


	
	 %>

<script type="text/javascript">
	window.onload = function () { 
		fnSetValue("<%=isAppliedForPan%>")
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='form60AddModify' id='form60AddModify'  method="post" target='messageFrame' >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
      <td class="columnheadercenter"><fmt:message key="eMP.DeclarantDetails.label" bundle="${mp_labels}"/></td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellspacing="4" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="16%" align="left" valign="top" class=label><fmt:message key="Common.FirstName.label" bundle="${common_labels}"/></td>
                  <td width="16%" align="left" valign="top" class=fields><input type='text' name='firstName' id='firstName'   size='25' maxlength="30" value="<%=firstName%>" onKeyPress='return CheckForPipeChars(event)' onblur="makeValidString(this);" ><img src='../../eCommon/images/mandatory.gif'></img></td>
                  <td width="16%" align="left" valign="top" class=label><fmt:message key="eMP.MiddleName.label" bundle="${mp_labels}"/></td>
                  <td width="16%" align="left" valign="top" class=fields><input type='text' name='middleName' id='middleName'   size='25' maxlength='30' value="<%=middleName%>" onKeyPress='return CheckForPipeChars(event)' onblur="makeValidString(this);ChangeInitCase(this);" ><img src='../../eCommon/images/mandatory.gif'></img></td>
                  <td width="16%" align="left" valign="top" class=label><fmt:message key="eMP.Surname.label" bundle="${mp_labels}"/></td>
                  <td width="20%" align="left" valign="top" class=fields><input type='text' name='surname' id='surname'   size='25' maxlength='30' value="<%=surname%>" onKeyPress='return CheckForPipeChars(event)' onblur="makeValidString(this);ChangeInitCase(this);" ><img src='../../eCommon/images/mandatory.gif'></img></td>
                </tr>
                <tr>
                  <td align="left" valign="top" class=label><fmt:message key="eMP.DobInsOfDec.label" bundle="${mp_labels}"/></td>
                  <td colspan="5" align="left" valign="top" class=fields><input type="text" id="dobInsOfDec" name="dobInsOfDec" id="dobInsOfDec" size="10" maxlength="10" onBlur="validDateObjform60(this,'DMY',localeName);"  value="<%=dobInsOfDec%>">
                    <input type="image" onClick="return showCalendar('dobInsOfDec');" src='../../eCommon/images/CommonCalendar.gif' align="middle" ><img src='../../eCommon/images/mandatory.gif'></img></td>
                </tr>
                <tr>
                  <td width="16%" class=label><fmt:message key="eMP.Father.label" bundle="${mp_labels}"/>
                    <fmt:message key="Common.FirstName.label" bundle="${common_labels}"/></td>
                  <td width="16%" class=fields><input type='text' name='fatherFirstName' id='fatherFirstName'   size='25' maxlength="30" value="<%=fatherFirstName%>" onKeyPress='return CheckForPipeChars(event)' onblur="makeValidString(this);ChangeInitCase(this);" ><img src='../../eCommon/images/mandatory.gif'></img></td>
                  <td width="16%" class=label><fmt:message key="eMP.Father.label" bundle="${mp_labels}"/>
                    <fmt:message key="eMP.MiddleName.label" bundle="${mp_labels}"/></td>
                  <td width="16%" class=fields><input type='text' name='fatherMiddleName' id='fatherMiddleName'   size='25' maxlength='30' value="<%=fatherMiddleName%>" onKeyPress='return CheckForPipeChars(event)' onblur="makeValidString(this);ChangeInitCase(this);" ><img src='../../eCommon/images/mandatory.gif'></img></td>
                  <td width="16%" class=label><fmt:message key="eMP.Father.label" bundle="${mp_labels}"/>
                    <fmt:message key="eMP.Surname.label" bundle="${mp_labels}"/></td>
                  <td width="20%" class=fields><input type='text' name='fatherSurname' id='fatherSurname'   size='25' maxlength="30"  value="<%=fatherSurname%>" onKeyPress='return CheckForPipeChars(event)' onblur="makeValidString(this);ChangeInitCase(this);"><img src='../../eCommon/images/mandatory.gif'></img></td>
                </tr>
              </table></td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td class="columnheadercenter"><fmt:message key="eMP.DeclarantAddDetails.label" bundle="${mp_labels}"/></td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellspacing="4" cellpadding="0">
          <tr>
            <td width="16%" align="left" valign="top" class=label><fmt:message key="eMP.FlatRoomNo.label" bundle="${mp_labels}"/></td>
            <td width="16%" align="left" valign="top"  class=fields><input type='text' name='flatRoomNo' id='flatRoomNo'   size='25' maxlength="30" value="<%=flatRoomNo%>"   ></td>
            <td width="17%" align="left" valign="top"  class=label><fmt:message key="eMP.FloorNo.label" bundle="${mp_labels}"/></td>
            <td width="16%" align="left" valign="top"  class=fields><input type='text' name='floorNo' id='floorNo'   size='25' maxlength='30' value="<%=floorNo%>" ></td>
            <td width="16%" align="left" valign="top"  class=label><fmt:message key="eMP.NameOfPremises.label" bundle="${mp_labels}"/></td>
            <td width="35%" align="left" valign="top"  class=fields><input type='text' name='nameOfPremises' id='nameOfPremises'   size='25' maxlength="30"  value="<%=nameOfPremises%>" ></td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label><fmt:message key="eMP.BlockNameNo.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type='text' name='blockNameNo' id='blockNameNo'   size='25' maxlength='30'  value="<%=blockNameNo%>" ></td>
            <td align="left" valign="top" class=label><fmt:message key="eMP.RoadStreetLane.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type='text' name='roadStreetLane' id='roadStreetLane'   size='25' maxlength="30"  value="<%=roadStreetLane%>" ></td>
            <td align="left" valign="top" class=label><fmt:message key="eMP.AreaLocality.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type='text' name='areaLocality' id='areaLocality'   size='25' maxlength='30'  value="<%=areaLocality%>"></td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label><fmt:message key="eMP.TownCity.label" bundle="${mp_labels}"/></td>
            <td colspan="2" align="left" valign="top" class=fields><input type='text' name='townCity' id='townCity'   size='54' maxlength="60" value="<%=townCity%>"  ><img src='../../eCommon/images/mandatory.gif'></img></td>
            <td align="left" valign="top" class=fields><fmt:message key="eMP.District.label" bundle="${mp_labels}"/></td>
            <td colspan="2" align="left" valign="top" class=label><input type='text' name='district' id='district'   size='54' maxlength='60' value="<%=district%>" ><img src='../../eCommon/images/mandatory.gif'></img></td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label><fmt:message key="Common.State.label" bundle="${common_labels}"/></td>
            <td colspan="2" align="left" valign="top" class=fields><input type='text' name='state' id='state'   size='54' maxlength="60" value="<%=state%>"  ><img src='../../eCommon/images/mandatory.gif'></img></td>
            <td align="left" valign="top" class=fields><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
            <td colspan="2" align="left" valign="top" class=label><input type='text' name='country' id='country'   size='54' maxlength='60' value="<%=country%>"><img src='../../eCommon/images/mandatory.gif'></img></td>
          </tr>
          <tr>
            <td width="16%" align="left" valign="top" class=label><fmt:message key="eMP.Pincode.label" bundle="${mp_labels}"/></td>
            <td width="16%" align="left" valign="top" class=fields><input type='text' name='pinCode' id='pinCode'   size='25' maxlength="30" value="<%=pinCode%>"  ><img src='../../eCommon/images/mandatory.gif'></img></td>
            <td width="17%" align="left" valign="top" class=label><fmt:message key="eAM.TelephoneNumber.label" bundle="${am_labels}"/></td>
            <td width="16%" align="left" valign="top" class=fields><input type='text' name='telephoneNo' id='telephoneNo'   size='25' maxlength='20' value="<%=telephoneNo%>" ><img src='../../eCommon/images/mandatory.gif'></img></td>
            <td width="16%" align="left" valign="top" class=label><fmt:message key="eMP.MobileNo.label" bundle="${mp_labels}"/></td>
            <td width="35%" align="left" valign="top" class=fields><input type='text' name='mobileNo' id='mobileNo'   size='25' maxlength='20' value="<%=mobileNo%>" > <img src='../../eCommon/images/mandatory.gif'></img></td>
          </tr>
          <tr>
            <td colspan="6"="left" valign="top" class="columnheadercenter" ><fmt:message key="eMP.DeclarantTrasactionDetails.label" bundle="${mp_labels}"/></td>
           
          </tr>
          
          <tr>
            <td align="left" valign="top" class=label><fmt:message key="eMP.AmountOfTransaction.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type='text' name='amountOfTransaction' id='amountOfTransaction'   size='25' maxlength="8"  value="<%=amountOfTransaction%>" onBlur="ChecksplCharsAlphabet(this);ZeroCheck(this);" onKeyPress="return NumberCheck(event);" disabled></td>
            <td align="left" valign="top" class=label><fmt:message key="eMP.DateOfTransaction.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type="text" id="dateOfTransaction" name="dateOfTransaction" id="dateOfTransaction" size="10" maxlength="10" onBlur="validDateObjform60(this,'DMY',localeName);"  value="<%=dateOfTransaction%>" disabled>
             <!-- <input type="image" onClick="return showCalendar('dateOfTransaction');" src='../../eCommon/images/CommonCalendar.gif' align="middle" >--></td>
            <td align="left" valign="top" class=label><fmt:message key="eMP.NumberOfPersonInvolved.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type='text' name='noOfPersonsInvolved' id='noOfPersonsInvolved'   size='25' maxlength="2" value="<%=noOfPersonsInvolved%>"   onBlur="ChecksplCharsAlphabet(this);ZeroCheck(this);" onKeyPress="return NumberCheck(event);" ></td>
          </tr>
          
		 <tr>
		 <td align="left" valign="top" class=label><fmt:message key="eMP.ModeOfTransaction.label" bundle="${mp_labels}"/></td>
		<td colspan="5" align="left" valign="top" class=fields>
			  <input type="checkbox" value="Y" name='trans_mode_cash_yn' id='trans_mode_cash_yn' <%if(!transaction_mode.equals("")){ if(transaction_mode.contains("Y")){%>checked<%}}%> disabled>
              <fmt:message key="Common.Cash.label" bundle="${common_labels}"/>
              <input type="checkbox" value="Y" name='trans_mode_cheque_yn' id='trans_mode_cheque_yn'  <%if(!transaction_mode.equals("")){ if(transaction_mode.contains("B")){%>checked<%}}%>  disabled>
              <fmt:message key="eMP.Cheque.label" bundle="${mp_labels}"/>
              <input type="checkbox" value="Y" name='trans_mode_card_yn' id='trans_mode_card_yn'  <%if(!transaction_mode.equals("")){ if(transaction_mode.contains("A")){%>checked<%}}%>  disabled> <fmt:message key="eMP.Card.label" bundle="${mp_labels}"/>                			
              <input type="checkbox" value="Y" name='trans_mode_dbs_yn' id='trans_mode_dbs_yn'  disabled>
              <fmt:message key="eMP.DraftORBankersCheque.label" bundle="${mp_labels}"/>
              <input type="checkbox" value="Y" name='trans_mode_online_transfer_yn' id='trans_mode_online_transfer_yn' disabled>
              <fmt:message key="eMP.OnlineTransfer.label" bundle="${mp_labels}"/>
              <input type="checkbox" value="Y" name='trans_mode_other_yn' id='trans_mode_other_yn' <%if(!transaction_mode.equals("")){ if(transaction_mode.contains("D")){%>checked<%}}%>  disabled>
              <fmt:message key="Common.other.label" bundle="${common_labels}"/></td>
		 </tr>

          <tr>
            <td align="left" valign="top" class=label colspan="2" ><fmt:message key="eMP.AdharNoIssuedByUIDAI.label" bundle="${mp_labels}"/></td>
            <td align="left" valign="top" class=fields><input type='text' name='AdharNoIssuedByUIDAI' id='AdharNoIssuedByUIDAI'  value="<%=AdharNoIssuedByUIDAI%>" size='25' maxlength="12" onBlur="ChecksplCharsAlphabet(this);ZeroCheck(this);checkDigitCount(this)" onKeyPress="return NumberCheck(event);"></td>
            <td align="left" valign="top" class=label colspan="2"><fmt:message key="eMP.AppliedForPAN.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=label><input type="Radio" value="Y" name='isAppliedForPanYN' id='isAppliedForPanYN' onClick="fnSetValue('Y');" <%if(isAppliedForPan.equals("Y")){%> checked<%}%>>
              <fmt:message key="Common.yes.label" bundle="${common_labels}"  />
              <input type="Radio" name="isAppliedForPanYN" id="isAppliedForPanYN" value	= "N" onClick="fnSetValue('N');" <%if(isAppliedForPan.equals("N")){%> checked<%}%>>
              <fmt:message key="Common.no.label" bundle="${common_labels}"/>
              <input type="hidden" name="isAppliedForPan" id="isAppliedForPan" value	= "<%=isAppliedForPan%>" ></td>
          </tr>
		  
          <tr>
            <td  align="left" valign="top" class=label colspan="2"><fmt:message key="eMP.PANAcknowledgement.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields><input type='text' name='PANAcknowledgement' id='PANAcknowledgement' id='PANAcknowledgement'  size='25' maxlength="16" value="<%=PANAcknowledgement%>" onBlur="validSplchars(this);ZeroCheck(this);checkDigitCount(this)" onKeyPress="return SplCharCheck(event);" ><img id="mndt_panACK" src='../../eCommon/images/mandatory.gif'></td>
            <td  align="left" valign="top" class=label colspan="2" ><fmt:message key="eMP.PANDateOfApplication.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields><input type="text" id="PANDateOfApplication" name="PANDateOfApplication" id="PANDateOfApplication" size="10" maxlength="10" value="<%=PANDateOfApplication%>" onBlur="validDateObjform60(this,'DMY',localeName);">
              <input id="DatePick" type="image" onClick="return showCalendar('PANDateOfApplication');" src='../../eCommon/images/CommonCalendar.gif' align="middle"><img id="mndt_panDate" src='../../eCommon/images/mandatory.gif'></td>
          </tr>

          <tr>
            <td align="left" valign="top" class=label colspan=2><fmt:message key="eMP.EstimatedAgriculturalIncome.label" bundle="${mp_labels}"/></td>
            <td   align="left" valign="top" class=fields><input type='text' name='estAgriIncome' id='estAgriIncome'  id='estAgriIncome' size='25' maxlength="15" value="<%=estAgriIncome%>" onBlur="ChecksplCharsAlphabet(this)" onKeyPress="return NumberCheck(event);"><img id="mndt_agri" src='../../eCommon/images/mandatory.gif'></td>
            <td  align="left" valign="top" class=label colspan=2><fmt:message key="eMP.EstimatedNonAgriculturalIncome.label" bundle="${mp_labels}"/></td>
            <td   align="left" valign="top" class=fields><input type='text' name='estNonAgriIncome' id='estNonAgriIncome' id='estNonAgriIncome'  size='25' maxlength='15' value="<%=estNonAgriIncome%>" onBlur="ChecksplCharsAlphabet(this)" onKeyPress="return NumberCheck(event);"><img id="mndt_nonagri" src='../../eCommon/images/mandatory.gif'></td>
          </tr>
          <tr> 
            <td  align="left" valign="top" class=label colspan=2><fmt:message key="eMP.SupportIdentifyProof.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields colspan=4>
			<select name="idProofDocCode" id="idProofDocCode" >
                <option  value="">
				 <fmt:message key="Common.Select.label" bundle="${common_labels}"/>
                </option>
                <%
					for(int i = 0 ; i < idProofDocCodeArray.size() ; i++) {
							JSONObject idProofDocCodeListObj	= (JSONObject)idProofDocCodeArray.get(i);
							String docType				= (String) idProofDocCodeListObj.get("docType");
							String shortDesc				= (String) idProofDocCodeListObj.get("shortDesc");		
					%>
                <option value="<%=docType%>" <%if(idProofDocCode.equals(docType)){ %> selected <%}%>><%=shortDesc%></option>
                <%
						}
					%>
              </select><img id="IdProof" src='../../eCommon/images/mandatory.gif'></td>
			  </tr>
			<tr>
            <td align="left" valign="top" class=label colspan=2><fmt:message key="eMP.DocumentIdentificationNumber.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields><input type='text' name='idProofDocIdNo' id='idProofDocIdNo'   size='25' maxlength="30" value="<%=idProofDocIdNo%>"   ><img id="IdNumb" src='../../eCommon/images/mandatory.gif'></td>
            <td  align="left" valign="top" class=label colspan=2><fmt:message key="eMP.NameAndAddressOfAuthority.label" bundle="${mp_labels}"/></td></td>
            <td  align="left" valign="top" class=fields><textarea name="idProofNameAddOfAuthority"  onKeyPress="checkMaxLimit(this,100);" onblur="callCheckMaxLen(this,100)" style="resize:none;"  rows='3' cols='25'><%=idProofNameAddOfAuthority%></textarea><img id="IdName" src='../../eCommon/images/mandatory.gif'> </td>
          </tr>
          <tr>
            <td  align="left" valign="top" class=label colspan=2><fmt:message key="eMP.SupportOfAddress.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields colspan=4><select name="addProofDocCode" id="addProofDocCode" >
                <option value="">
				 <fmt:message key="Common.Select.label" bundle="${common_labels}"/>
                </option>
                <%
									for(int i = 0 ; i < addProofDocCodeArray.size() ; i++) {
											JSONObject addProofDocCodeListObj	= (JSONObject)addProofDocCodeArray.get(i);
											String docType						= (String) addProofDocCodeListObj.get("docType");
											String shortDesc					= (String) addProofDocCodeListObj.get("shortDesc");		
									%>
                <option value="<%=docType%>" <%if(addProofDocCode.equals(docType)){ %> selected <%}%>><%=shortDesc%></option>
                <%
										}
								%>
              </select><img id="AddProof" src='../../eCommon/images/mandatory.gif'></td>
			</tr>
			<tr>
            <td align="left" valign="top" class=label colspan=2><fmt:message key="eMP.DocumentIdentificationNumber.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields><input type='text' name='addProofDocIdNo' id='addProofDocIdNo'   size='30' maxlength="30" value="<%=addProofDocIdNo%>"  ><img id="AddNumb" src='../../eCommon/images/mandatory.gif'></td>
            <td align="left" valign="top" class=label colspan=2><fmt:message key="eMP.NameAndAddressOfAuthority.label" bundle="${mp_labels}"/></td>
            <td  align="left" valign="top" class=fields><textarea name="addProofNameAddOfAuthority"   onKeyPress="checkMaxLimit(this,100);" onblur="callCheckMaxLen(this,100)"  style="resize:none;" rows='3' cols='25'><%=addProofNameAddOfAuthority%></textarea><img id="AddName" src='../../eCommon/images/mandatory.gif'> </td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label></td>
            <td colspan="5" align="left" valign="top" class=fields></td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label></td>
            <td colspan="3" align="left" valign="top" class=fields>
              
            <td colspan="2" align="left" valign="top" class=label></td>
          </tr>
         
          <tr>
            <td align="left" valign="top" class=label></td>
            <td colspan="5" align="left" valign="top" class=fields></td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label></td>
            <td colspan="3" align="left" valign="top" class=fields>
              </td>
            <td colspan="2" align="left" valign="top" class=label></td>
          </tr>
          <tr>
            <td align="left" valign="top" class=label>&nbsp;</td>
            <td colspan="2" align="left" valign="top" class=fields>&nbsp;</td>
            <td align="left" valign="top" class=fields>&nbsp;</td>
            <td colspan="2" align="left" valign="top" class=label>&nbsp;</td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="4%" align="right" valign="middle">&nbsp;</td>
            <td width="96%" align="right" valign="middle"><input type="button" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%> "  onclick='fnSave()' class='BUTTON' />
              <INPUT TYPE="button" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Finalize.label","mp_labels")%> "  onClick='fnFinalize()' class='BUTTON'></td>
          </tr>
        </table></td>
    </tr>
  </table>
  <input type='hidden' name='operation' id='operation' value="" />
  <input type='hidden' name='patientId' id='patientId' value="<%=reqPatientId%>" />
  <input type='hidden' name='encounterId' id='encounterId' value="<%=reqEncounterId%>" />
  <input type='hidden' name='status' id='status' value="<%=reqStatus%>" />
  <input type='hidden' name='form60Status' id='form60Status' value="" />
  <input type='hidden' name='ACKNOWLEDG_NO_FORM60' id='ACKNOWLEDG_NO_FORM60' value="<%=acknowledg_no_form60%>" />
</form>
</body>
<%
	} catch(Exception e){
		e.printStackTrace();
	}
   finally
    {
  		
		ConnectionManager.returnConnection(con,request);
    }
	%>
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

