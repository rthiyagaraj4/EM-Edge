<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<html>
<title></title>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src="../js/repUserPractStaffFacilityList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "SM" ;
	String p_report_id		= "SMUPRSFL" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
 %>

<body OnMouseDown='CodeArrest()' ; onKeyDown = 'lockKey()'; onLoad="checkVal();">
<center>
	<form name="repUserPractStaffFacilityList" id="repUserPractStaffFacilityList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	           
			   <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
				
				<table width='80%' align='center' valign='top'>
				
				<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>
		<td width="100%" class="Border" align='center'>
				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				    <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

				<tr>
			 <td align='center' width="20%" class='label'  nowrap ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td> 
			        
			        <td align='left' width="40%"><select name='p_search_by' id='p_search_by' onchange="checkVal();">
					<option value='U'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></option>
					<option value="P"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.StaffID.label" bundle="${common_labels}"/></option>
			        </select>
					</td>
				</tr>
				<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="40%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
            	<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
				
                
				<tr>
				<td width='30%' class="label"><fmt:message key="Common.userid.label" bundle="${sm_labels}"/>&nbsp;&nbsp;</td>
				<td width='20%'><input type="text" name="p_from_appl_user_id" id="p_from_appl_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(from_user_id,this);'><input type='button'name='from_user_id' value='?' class='button' onclick='searchCode(this,p_from_appl_user_id)'>&nbsp;&nbsp;</td>
				
				<td width='40%'>&nbsp;&nbsp;<input type="text" name="p_to_appl_user_id" id="p_to_appl_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(to_user_id,this);'><input type='button' name='to_user_id' id='to_user_id' value='?' class='button' onclick='searchCode(this,p_to_appl_user_id)'>&nbsp;&nbsp;</td>
				<td width='10%' >&nbsp;</td>
			    </tr>
				
				<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
				
  
				<tr>
				    <td align='right' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_practitioner_id' id='p_fm_practitioner_id' size="30" maxlength="30" align="center" onblur='ChangeUpperCase(this);if(this.value !="") searchCode(fm_practitioner,this);'><input type='button' name='fm_practitioner' id='fm_practitioner' value='?' class='button' onclick='searchCode(this,p_fm_practitioner_id)'>
					</td>
						<td width='40%'>&nbsp;&nbsp;<input type=text  name='p_to_practitioner_id' id='p_to_practitioner_id' size="30" maxlength="30" align="center" onblur='ChangeUpperCase(this);if(this.value !="") searchCode(to_practitioner,this);'><input type='button' name='to_practitioner' id='to_practitioner' value='?' class='button' onclick='searchCode(this,p_to_practitioner_id)'>
					</td>					
				</tr>

				
				<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
				
				       
				       <tr>

                        <td align='right' width='30%' class="label"><fmt:message key="Common.StaffID.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type="text"  name='p_fm_staff_id' id='p_fm_staff_id' size="30" maxlength="30" align="center" onblur='ChangeUpperCase(this);if(this.value !="") searchCode(from_staff_id,this);'><input type='button' name='from_staff_id' id='from_staff_id' value='?' class='button' onclick='searchCode(this,p_fm_staff_id)'>&nbsp;&nbsp;
						</td>
                        
						<td width='40%'>&nbsp;&nbsp;<input type="text"  name='p_to_staff_id' id='p_to_staff_id' size="30" maxlength="30" align="center" onblur='ChangeUpperCase(this);if(this.value !="") searchCode(to_staff_id,this);'><input type='button' name='to_staff_id' id='to_staff_id' value='?' class='button' onclick='searchCode(this,p_to_staff_id)'>
						</td>
						</tr>
                 
				        
				<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

				
				


				<tr>
			 <td class='label' nowrap ><fmt:message key="eSM.UserIDDifferedWithPractStaffID.label" bundle="${sm_labels}"/></td>
			  <td><input type='checkbox' name='pract_staff_id_yn' id='pract_staff_id_yn' onclick='ChangeState(this)'></td>
			        
			
				</tr>

                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

				

				<tr>
			 <td class='label'  nowrap ><fmt:message key="eSM.UserCreationMasterAccess.label" bundle="${sm_labels}"/> </td>
			 <td class='fields'>    
			        <select name='p_user_master' id='p_user_master'>
					<option value='S'>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="Y"> <fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
					<option value="N"> <fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			        </select>
					</td>
				</tr>
				<tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

				

				<tr>
				<td class="label" nowrap>
					<fmt:message key="eSM.UserMoreThan1Facility.label" bundle="${sm_labels}"/>
				</td>
                   <td class='fields'>
					
					<select name="p_user_facility" id="p_user_facility">
					<option value='S'>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="Y"> <fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
					<option value="N"> <fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select>
				</td>
				<td>&nbsp;</td>

			<td colspan='2'>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			    <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
				

			    <tr>
				<td class="label" nowrap>
					<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
				</td>

				<td class='fields'>
					
					<select name="p_order_by" id="p_order_by">
					<option value="1"> <fmt:message key="Common.userid.label" bundle="${common_labels}"/></option>
					<option value="2"> <fmt:message key="Common.username.label" bundle="${common_labels}"/></option>
				</select>
				</td>
				<td>&nbsp;</td>

			<td colspan='2'>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
			</td>
			</tr>
			</table>
			<br>
			   
	    <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_pract_staff_id_yn" id="p_pract_staff_id_yn"	value="N">
		     
             
		
			</form>
			</center>
			</body>
			</html>



