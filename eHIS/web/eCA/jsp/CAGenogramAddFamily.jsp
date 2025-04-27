<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCA.*,eOR.*,eOR.Common.*,java.sql.*, java.util.*, java.text.*,eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String	sys_date_time					=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String mode	= request.getParameter("mode")==null?"":request.getParameter("mode");
	
	String bean_id="@cagenogrambean"+patient_id;
	String bean_name="eCA.CAGenogramBean";
	
	CAGenogramBean bean			= new CAGenogramBean() ;
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCA/js/CAPatientGenogram.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js" />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		.relationWith
		{
			
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #3300CC;
			font-weight:bold;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			
		}
		
	</style>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='genogramAddFamilyMemberFrm' id='genogramAddFamilyMemberFrm'  action='../../servlet/eCA.CAGenogramServlet' method='post' target='messageFrame' >
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
			<tr><td class='columnHeadercenter'><fmt:message key="eCA.FamilyMemberDetails.label" bundle="${ca_labels}"/></td></tr> 
			
			<tr id="familyRelation">
				<td>
					<fieldset width="100%">
						<legend><fmt:message key="eCA.FamilyRelationship.label" bundle="${ca_labels}"/></legend>
						<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
							<tr>
								<td class='label' width='20%'><fmt:message key="eCA.RelationshipType.label" bundle="${ca_labels}"/></td>
								<td width='25%'>
									<SELECT name="relationShipTypeValue" id="relationShipTypeValue" id="relationShipTypeValue" onchange = "getRelationComboValues(this,'FAMILY');" > 
										<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
										<%
											Connection			con			=	null;
											PreparedStatement	pstmt		=	null;
											ResultSet			rs			=	null;
											String 				query		=	null;
											try{
												
												con		=	ConnectionManager.getConnection(request);
												query	=	" SELECT RELTN_ID,RELTN_DESC FROM CA_GENO_RELTN_MAST WHERE RELTN_TYPE_ID='FM' AND EFF_STATUS='E' ORDER BY RELTN_DESC";

												pstmt	=	con.prepareStatement(query);											
												rs		=	pstmt.executeQuery();
																							
												while(rs.next()){												
												%>	
													<OPTION value="<%=rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID") %>"><%=rs.getString("RELTN_DESC")==null?"":(String)rs.getString("RELTN_DESC") %></OPTION>
													
												<%
												}											
													
											}catch(Exception e){
													//out.println("Exception@1: "+e);//COMMON-ICN-0181
                                                                                                          e.printStackTrace();//COMMON-ICN-0181
											}finally{
												if(rs!=null) rs.close();
												if(pstmt!=null) pstmt.close();
												if(con!=null) ConnectionManager.returnConnection(con,request);
											}
										%>								
									</SELECT> 
									<img id="relst" src='../../eCommon/images/mandatory.gif' style="display;"></img>														
									
								</td>
								<td id="relationWith" class="relationWith" width='20%'>&nbsp; 
								</td>
								<td>&nbsp;
									<SELECT name="selectNonPatID1" id="selectNonPatID1" id="selectNonPatID1" style="width:200px;display:none;" onchange = '' >								
									</SELECT>
									<img id="selectNonPatID1_" src='../../eCommon/images/mandatory.gif' style="display:none;"></img>
								</td>
							</tr>
							<tr id="noOfChildsId" style="display:none;">
								<td class='label' width='20%'><fmt:message key="eCA.NoOfChildren.label" bundle="${ca_labels}"/></td>
								<td class="fields" colspan="3">
									<SELECT name="noOfChilds" id="noOfChilds" onchange="addChildrens(this);" >
										<OPTION value="1">1</OPTION>
										<OPTION value="2">2</OPTION>
										<OPTION value="3">3</OPTION>
										<OPTION value="4">4</OPTION>
										<OPTION value="5">5</OPTION>
									</SELECT>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
			<tr id="coupleDetails" style="display;">
				<td>
					<fieldset width="100%">
						<legend><fmt:message key="eCA.FamilyDemographics.label" bundle="${ca_labels}"/></legend>
						<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
							<tr>
								<td class='label' width='30%'><fmt:message key="eCA.Relation.label" bundle="${ca_labels}"/></td>
								<td width='30%'>
									<SELECT name="relationValue" id="relationValue" id="relationValue" style="width:200px;" onchange = '' >								
									</SELECT>
									<img id="rel" src='../../eCommon/images/mandatory.gif' style="display;"></img>
									
								</td>
								<td width='40%' id="HLink">&nbsp;</td>
							</tr>
							<tr>
								<td  class=label width = '30%'><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/></td>			
								<td  colspan="2" width = '70%'>
									<input type='text' name='rec_patient_id' id='rec_patient_id' size='30' maxlength='30'   OnBlur ="getPatientDtls(this,'COUPLE','','OnBlur');" onKeyPress='return CheckForSpecChars(event)' value="" ></input>							
									<input type='button' name='patientSrch' id='patientSrch' value='?'  OnClick="getPatientDtls(document.forms[0].rec_patient_id,'COUPLE','','OnClick');" class='button' />
								</td>	
							</tr>
							<tr id="relationSD">
								<td class="LABEL" width='25%' ><fmt:message key="eCA.RelationStartDate.label" bundle="${ca_labels}"/></td>
								<td class="fields" width='25%'>
									<input type='text' name='relationStartDate' id='relationStartDate' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Relation Start Date")'>
									<input type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].relationStartDate.select();return showCalendar('relationStartDate','','','');">							
									&nbsp;
									<img src='../../eCommon/images/mandatory.gif'>
								</td>
							</tr>
							<tr>
								<td class='label' width='30%'><fmt:message key="eCA.Name.label" bundle="${ca_labels}"/></td>
								<td colspan="2" width='70%'>	
									<input type="text"  id="rec_patient_name" name="rec_patient_name" id="rec_patient_name" value="" style="width:150px;"  onblur = '' >
									&nbsp;
									<img src='../../eCommon/images/mandatory.gif'>
								</td>
							</tr>
							<tr>						
								<td class="label"  width='30%'><fmt:message key="eCA.DateofBirth.label" bundle="${ca_labels}"/></td>
								<td colspan="2" width='70%'>							
									<input type='text' id="date_of_birth" name='date_of_birth' id='date_of_birth' value="" size='14' maxLength='16'   onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Date of Birth")'>
									<input type='image' id="dofimg" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].date_of_birth.select();return showCalendar('date_of_birth','','','');">																			
									&nbsp;
									<img src='../../eCommon/images/mandatory.gif'>
								</td>
							</tr>
							<tr>
								<td class='label' width='30%'><fmt:message key="eCA.Gender.label" bundle="${ca_labels}"/></td>
								<td colspan="2" width='70%'>
									<SELECT name="gender" id="gender" onchange="setGenderHidden(this,'gender_hidden');" >
										<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
										<OPTION value="M">Male</OPTION>
										<OPTION value="F">Female</OPTION>
										<OPTION value="U">Unknown</OPTION> 
									</SELECT>
									&nbsp;
									<img src='../../eCommon/images/mandatory.gif'>	
									<input type="hidden" id="genhidd" name="gender_hidden" id="gender_hidden" value=""/>														
								</td>
							</tr>
							<tr>
								<td class="LABEL" width='25%'><fmt:message key="eCA.DeceasedDateTime.label" bundle="${ca_labels}"/></td>
								<td class="fields" width='25%'>
									<input type='text'  id="deceasedDate" name='deceasedDate' id='deceasedDate' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Deceased Date/Time")'>
									<input type='image' id="ddimg" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].deceasedDate.select();return showCalendar('deceasedDate','','','');">							
								</td>
							</tr>
							<tr>
								<td class="LABEL" width='25%'><fmt:message key="eCA.DeceasedRemarks.label" bundle="${ca_labels}"/></td> 
								<td class="fields" width='25%'>
									<input type="text"  name="deceased_remarks" id="deceased_remarks" value="" style="width:150px;"  onkeypress="if (this.value.length > 249) { return false; }"  onblur = "controlLength(this);" >
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
			<!--- parents Details---->			
			<tr id="parentDetails" style="display:none;"> 
				<td>
					<fieldset width="100%">
						<legend><fmt:message key="eCA.FamilyDemographics.label" bundle="${ca_labels}"/></legend>
						<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
							<tr>
								<td width="49%">
									<fieldset width="100%">
										<legend><fmt:message key="eCA.FatherDetails.label" bundle="${ca_labels}"/></legend>
										<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>												
											<tr>
												<td  class=label width = '40%'><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/></td> 			
												<td  width = '60%'> 
													<input type='text' name='rec_patient_idFa' id='rec_patient_idFa' size='30' maxlength='30'   OnBlur ="getPatientDtls(this,'FA','','OnBlur');"  onKeyPress='return CheckForSpecChars(event)' value="" ></input>							
													<input type='button' name='patientSrch' id='patientSrch' value='?'  OnClick="getPatientDtls(document.forms[0].rec_patient_idFa,'FA','','OnClick');" class='button' />
												</td>	
											</tr>											
											<tr>
												<td class='label' width='40%'><fmt:message key="eCA.Name.label" bundle="${ca_labels}"/></td> 
												<td  width='60%'>	
													<input type="text"  id="rec_patient_nameFa" name="rec_patient_nameFa" id="rec_patient_nameFa" value="" style="width:150px;"  onblur = '' >
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
											<tr>						
												<td class="label"  width='40%'><fmt:message key="eCA.DateofBirth.label" bundle="${ca_labels}"/></td>
												<td  width='60%'>							
													<input type='text' id="date_of_birthFa" name='date_of_birthFa' id='date_of_birthFa' value="" size='14' maxLength='16'   onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Date of Birth")'>
													<input type='image' id="dofimgFa" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].date_of_birthFa.select();return showCalendar('date_of_birthFa','','','');">																			
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
											<tr>
												<td class='label' width='40%'><fmt:message key="eCA.Gender.label" bundle="${ca_labels}"/></td>
												<td  width='60%'>
													<input type='text' name='genderFaDescFa' id='genderFaDescFa' value="Male" size='14' maxLength='16' readOnly>
													<input type='hidden' name='genderFa' id='genderFa' value="M">																		
												</td>
											</tr>
											<tr>
												<td class="LABEL" width='40%' ><fmt:message key="eCA.DeceasedDateTime.label" bundle="${ca_labels}"/></td>
												<td class="fields" width='60%'>
													<input type='text' name='deceasedDateFa' id='deceasedDateFa' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Deceased Date/Time")'>
													<input type='image' id="ddimgFa" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].deceasedDateFa.select();return showCalendar('deceasedDateFa','','','');">							
												</td>
											</tr>
											<tr>
												<td class="LABEL" width='40%'><fmt:message key="eCA.DeceasedRemarks.label" bundle="${ca_labels}"/></td>
												<td class="fields" width='60%'>
													<input type="text"  name="deceased_remarksFa" id="deceased_remarksFa" value="" style="width:150px;"  onkeypress="if (this.value.length > 249) { return false; }"  onblur = "controlLength(this);" >
												</td>
											</tr>
										</table>
										<input type='hidden' name='relationValueFa' id='relationValueFa' value="FA">
									</fieldset>
								</td>
								<td width="2%">&nbsp;</td>
								<td width="49%">
									<fieldset width="100%">
										<legend><fmt:message key="eCA.MotherDetails.label" bundle="${ca_labels}"/></legend>
										<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>												
											<tr>
												<td  class=label width = '40%'><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/></td>			
												<td  width = '60%'>
													<input type='text' name='rec_patient_idMo' id='rec_patient_idMo' size='30' maxlength='30'   OnBlur ="getPatientDtls(this,'MO','','OnBlur');" onKeyPress='return CheckForSpecChars(event)' value="" ></input>							
													<input type='button' name='patientSrch' id='patientSrch' value='?'  OnClick="getPatientDtls(document.forms[0].rec_patient_idMo,'MO','','OnClick');" class='button' />
												</td>	
											</tr>											
											<tr>
												<td class='label' width='40%'><fmt:message key="eCA.Name.label" bundle="${ca_labels}"/></td>
												<td  width='60%'>	
													<input type="text"  id="rec_patient_nameMo" name="rec_patient_nameMo" id="rec_patient_nameMo" value="" style="width:150px;"  onblur = '' >
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
											<tr>						
												<td class="label"  width='40%'><fmt:message key="eCA.DateofBirth.label" bundle="${ca_labels}"/></td>
												<td  width='60%'>							
													<input type='text' id="date_of_birthMo" name='date_of_birthMo' id='date_of_birthMo' value="" size='14' maxLength='16'   onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Date of Birth")'>
													<input type='image' id="dofimgMo" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].date_of_birthMo.select();return showCalendar('date_of_birthMo','','','');">																			
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
											<tr>
												<td class='label' width='40%'><fmt:message key="eCA.Gender.label" bundle="${ca_labels}"/></td>
												<td  width='60%'>
													<input type='text' name='genderMoDescMo' id='genderMoDescMo' value="Female" size='14' maxLength='16' readOnly>
													<input type='hidden' name='genderMo' id='genderMo' value="F">																		
												</td>
											</tr>
											<tr>
												<td class="LABEL" width='40%'><fmt:message key="eCA.DeceasedDateTime.label" bundle="${ca_labels}"/></td>
												<td class="fields" width='60%'>
													<input type='text' name='deceasedDateMo' id='deceasedDateMo' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Deceased Date/Time")'>
													<input type='image' id="ddimgMo" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].deceasedDateMo.select();return showCalendar('deceasedDateMo','','','');">							
												</td>
											</tr>
											<tr>
												<td class="LABEL" width='40%'><fmt:message key="eCA.DeceasedRemarks.label" bundle="${ca_labels}"/></td>
												<td class="fields" width='60%'>
													<input type="text"  name="deceased_remarksMo" id="deceased_remarksMo" value="" style="width:150px;"  onkeypress="if (this.value.length > 249) { return false; }"  onblur = "controlLength(this);" >
												</td>
											</tr>
										</table>
										<input type='hidden' name='relationValueMo' id='relationValueMo' value="MO">
									</fieldset>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<fieldset width="100%">
										<legend><fmt:message key="eCA.RelationbetweenFatherAndMother.label" bundle="${ca_labels}"/></legend>
										<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
											<tr>
												<td class='label' width='20%'><fmt:message key="eCA.Relation.label" bundle="${ca_labels}"/></td>
												<td width='30%'>
													<SELECT name="relationValueFaMo" id="relationValueFaMo"  style="width:200px;" onchange = '' >								
													</SELECT>
													<img id="rel" src='../../eCommon/images/mandatory.gif' style="display;"></img>
													
												</td>
												<td class="LABEL" width='20%' ><fmt:message key="eCA.RelationStartDate.label" bundle="${ca_labels}"/></td>
												<td class="fields" width='30%'>
													<input type='text' name='relationStartDateFaMo' id='relationStartDateFaMo' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Relation Start Date")'>
													<input type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].relationStartDateFaMo.select();return showCalendar('relationStartDateFaMo','','','');">							
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
			<!--    -->								
		<!---   Child Details Start  ---->
			<tr id="childDetails" style="display:none;">
				<td>
					<fieldset width="100%">
						<legend><fmt:message key="eCA.FamilyDemographics.label" bundle="${ca_labels}"/></legend>
						<table cellpadding=3 cellspacing=0 border=0 width="100%" id="childDtlsTable" align=center>
							<tr>
								<td width="100%" id="rowID0">
									<fieldset width="100%">
										<legend>Child Details - 1</legend>
										<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>												
											<tr>
												<td class='label' style="width:350px;"><fmt:message key="eCA.Relation.label" bundle="${ca_labels}"/></td> 
												<td>
													<SELECT name="relationValueCh0" id="relationValueCh0"  style="width:200px;" onchange = '' >								
													</SELECT>
													<img id="rel" src='../../eCommon/images/mandatory.gif' style="display;"></img>																		
												</td>
											</tr>
											<tr>
												<td class='label' style="width:350px;"><fmt:message key="eCA.SiblingPosition.label" bundle="${ca_labels}"/></td> 
												<td>
													<input type='text' name='rec_sibling_positionCh0' id='rec_sibling_positionCh0' size='30' maxlength='30'   OnBlur ="" value="1" ></input>							
													<img  src='../../eCommon/images/mandatory.gif' style="display;"></img>																		
												</td>
											</tr>
											<tr>
												<td  class=label style="width:350px;"><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/></td>			
												<td>
													<input type='text' name='rec_patient_idCh0' id='rec_patient_idCh0' size='30' maxlength='30'   OnBlur ="getPatientDtls(this,'CHILD','0','OnBlur');" onKeyPress='return CheckForSpecChars(event)' value="" ></input>							
													<input type='button' name='patientSrch' id='patientSrch' value='?'  OnClick="getPatientDtls(document.forms[0].rec_patient_idCh0,'CHILD','0','OnClick');" class='button' />
												</td>	
											</tr>																
											<tr>
												<td class='label' style="width:350px;"><fmt:message key="eCA.Name.label" bundle="${ca_labels}"/></td>
												<td>	
													<input type="text"  id="rec_patient_nameCh0" name="rec_patient_nameCh0" id="rec_patient_nameCh0" value="" style="width:150px;"  onblur = '' >
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
											<tr>						
												<td class="label" style="width:350px;"><fmt:message key="eCA.DateofBirth.label" bundle="${ca_labels}"/></td>
												<td>							
													<input type='text' id="date_of_birthCh0" name='date_of_birthCh0' id='date_of_birthCh0' value="" size='14' maxLength='16'   onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Date of Birth")'>
													<input type='image' id="dofimgCh0" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].date_of_birthCh0.select();return showCalendar('date_of_birthCh0','','','');">																			
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
												</td>
											</tr>
											<tr>
												<td class='label' style="width:350px;"><fmt:message key="eCA.Gender.label" bundle="${ca_labels}"/></td>
												<td>
													<SELECT name="genderCh0" id="genderCh0" onchange="setGenderHidden(this,'gender_hiddenCh0');" >
														<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
														<OPTION value="M">Male</OPTION>
														<OPTION value="F">Female</OPTION>
														<OPTION value="U">Unknown</OPTION>
													</SELECT>
													&nbsp;
													<img src='../../eCommon/images/mandatory.gif'>
													<input type="hidden" id="genhiddCh0" name="gender_hiddenCh0" id="gender_hiddenCh0" value=""/>																		
												</td>
											</tr>
											<tr>
												<td class="LABEL" style="width:350px;" ><fmt:message key="eCA.DeceasedDateTime.label" bundle="${ca_labels}"/></td>
												<td class="fields">
													<input type='text' name='deceasedDateCh0' id='deceasedDateCh0' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Deceased Date/Time")'>
													<input type='image' id="ddimgCh0" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].deceasedDateCh0.select();return showCalendar('deceasedDateCh0','','','');">							
												</td>
											</tr>
											<tr>
												<td class="LABEL" style="width:350px;" ><fmt:message key="eCA.DeceasedRemarks.label" bundle="${ca_labels}"/></td>
												<td class="fields">
													<input type="text" id="deceased_remarksCh0" name="deceased_remarksCh0" id="deceased_remarksCh0" value="" style="width:150px;"  onkeypress="if (this.value.length > 249) { return false; }"  onblur = "controlLength(this);" >
												</td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>									
						</table>
					</fieldset>
				</td>
			</tr>
				<tr id="modifiedDetails" style="display:none;">
					<td>
						<fieldset width="100%">
							<legend><fmt:message key="eCA.FamilyDemographics.label" bundle="${ca_labels}"/></legend>
							<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>								
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/></td>			
									<td  colspan="2" width = '70%'>
										<input type='text' name='rec_patient_idModify' id='rec_patient_idModify' size='30' maxlength='30'   OnBlur ="getPatientDtls(this,'MODIFYDTLS','','OnBlur');" onKeyPress='return CheckForSpecChars(event)' value="" ></input>							
										<input type='button' name='patientSrch' id='patientSrch' value='?'  OnClick="getPatientDtls(document.forms[0].rec_patient_idModify,'MODIFYDTLS','','OnClick');" class='button' />
									</td>	
								</tr>								
								<tr>
									<td class='label' width='30%'><fmt:message key="eCA.Name.label" bundle="${ca_labels}"/></td>
									<td colspan="2" width='70%'>	
										<input type="text"  id="rec_patient_nameModify" name="rec_patient_nameModify" id="rec_patient_nameModify" value="" style="width:150px;"  onblur = '' >
										&nbsp;
										<img src='../../eCommon/images/mandatory.gif'>
									</td>
								</tr>
								<tr>						
									<td class="label"  width='30%'><fmt:message key="eCA.DateofBirth.label" bundle="${ca_labels}"/></td>
									<td colspan="2" width='70%'>							
										<input type='text' id="date_of_birthModify" name='date_of_birthModify' id='date_of_birthModify' value="" size='14' maxLength='16'   onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Date of Birth")'>
										<input type='image' id="dofimgModify" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].date_of_birthModify.select();return showCalendar('date_of_birthModify','','','');">																			
										&nbsp;
										<img src='../../eCommon/images/mandatory.gif'>
									</td>
								</tr>
								<tr>
									<td class='label' width='30%'><fmt:message key="eCA.Gender.label" bundle="${ca_labels}"/></td>
									<td colspan="2" width='70%'>
										<SELECT name="genderModify" id="genderModify" onchange="setGenderHidden(this,'gender_hiddenModify');" >
											<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
											<OPTION value="M">Male</OPTION>
											<OPTION value="F">Female</OPTION>
											<OPTION value="U">Unknown</OPTION> 
										</SELECT>
										&nbsp;
										<img src='../../eCommon/images/mandatory.gif'>	
										<input type="hidden" id="genhiddModify" name="gender_hiddenModify" id="gender_hiddenModify" value=""/>														
									</td>
								</tr>
								<tr>
									<td class="LABEL" width='25%'><fmt:message key="eCA.DeceasedDateTime.label" bundle="${ca_labels}"/></td>
									<td class="fields" width='25%'>
										<input type='text'  id="deceasedDateModify" name='deceasedDateModify' id='deceasedDateModify' value="" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,"DMY","<%=locale%>","Deceased Date/Time")'>
										<input type='image' id="ddimgModify" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].deceasedDateModify.select();return showCalendar('deceasedDateModify','','','');">							
									</td>
								</tr>
								<tr>
									<td class="LABEL" width='25%'><fmt:message key="eCA.DeceasedRemarks.label" bundle="${ca_labels}"/></td>
									<td class="fields" width='25%'>
										<input type="text"  name="deceased_remarksModify" id="deceased_remarksModify" value="" style="width:150px;"  onkeypress="if (this.value.length > 249) { return false; }"  onblur = "controlLength(this);" >
									</td>
								</tr>
							</table>
						</fieldset>
						<fieldset width="100%" id="modifyRelationFieldSet" style="display:none;" >
							<legend>Family Member Relation Type : COUPLE</legend>
							<DIV style="width:100%;height:120;border:1px solid red;overflow:auto">
								<table cellpadding=3 cellspacing=0 border=0 id="modifyRelationTable" width="100%" align=center>								
									<tr>
										<th class='columnHeadercenter' width = '25%' ><fmt:message key="eCA.RelationID.label" bundle="${ca_labels}"/></th>	
										<th class='columnHeadercenter' width = '25%'><fmt:message key="eCA.RelationStartDate.label" bundle="${ca_labels}"/></th>
										<th class='columnHeadercenter' width = '50%'><fmt:message key="eCA.FamilyMember.label" bundle="${ca_labels}"/></th>
									</tr>								
								</table>								
							</DIV>
						</fieldset>
					</td>
				</tr>
			
			
			</table>
			<input type="hidden" name="noOfChilds_" id="noOfChilds_" value="1"/>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="relationShipTypeValuetemp" id="relationShipTypeValuetemp" value="">
			<input type="hidden" name="stroeFirstIndexPat" id="stroeFirstIndexPat" value="">
			<input type="hidden" name="lineSrlNo" id="lineSrlNo" value="">
			<input type="hidden" name="selectNonPatID" id="selectNonPatID" value=""/>
			<input type="hidden" name="selectSrlNo" id="selectSrlNo" value=""/> 
			<input type="hidden" name="selectNonPatSex" id="selectNonPatSex" value=""/>
			<input type="hidden" name="genoId" id="genoId" value=""> 
			<input type="hidden" id="relModifyCount" name="relModifyCount" id="relModifyCount" value="0"/>
</form>
<script>
function assignRelationWith(){
	if('INSERT' == '<%=mode%>'){
		if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
			document.getElementById('relationWith').innerHTML = "Of  "+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value;
		}
		if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.totalRecords.value)==1){
			document.getElementById("relationShipTypeValue").disabled = true;
			document.getElementById("relationValue").disabled = true;
			document.getElementById('relst').style.display='none';
			document.getElementById('rel').style.display='none';
			document.getElementById('relationSD').style.display='none';
		}
	}
}
//call after page loaded
window.onload=assignRelationWith ;
</script>
</body>
</html>

