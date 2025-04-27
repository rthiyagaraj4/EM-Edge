<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
Properties p		= (java.util.Properties) session.getValue("jdbc");
Connection con	= null;
HashMap hashMap					= new HashMap();
ArrayList array_list			= new ArrayList();
String function_id			= checkForNull(request.getParameter("function_id"));
String dis_all_mother_dtls			= checkForNull(request.getParameter("dis_all_mother_dtls"));
String mand_antenatal_newbornipValue			= checkForNull(request.getParameter("mand_antenatal_newbornipValue"));
String facilityId			= checkForNull(request.getParameter("facilityId"));
String motherid			= checkForNull(request.getParameter("motherid"));
String captureAntenatalDtlsYN			= checkForNull(request.getParameter("captureAntenatalDtlsYN"));
String antenatal_care_yn			= checkForNull(request.getParameter("antenatal_care_yn"));
String call_function_id			= checkForNull(request.getParameter("call_function_id"));
String calling_module_id			= checkForNull(request.getParameter("calling_module_id"));
String width = "24%";
if(function_id.equals("REGISTER_NEWBORN") || function_id.equals("MAINTAIN_BIRTH") || calling_module_id.equals("MP")) { width = "25%"; }
if(calling_module_id.equals("AE")) { width = "23.5%"; }
String ant_care_gvn_at = "" , ant_care_locn_code = "" , ant_care_locn_type = "" ;
try{
con = ConnectionManager.getConnection(request);	
Boolean isMPMandatoryFieldsNewborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_MANDATORY_FIELDS_NEWBORN");
hashMap	= eMP.NewbornDetails.getNewbornData(motherid, con, p);
%>
<%if(isMPMandatoryFieldsNewborn){%>
<table width="100%" cellpadding='1' cellspacing='0' border='0'>
					<tr>
					<input type = 'hidden' name = 'ant_born_locn_type' value = ''>
					<input type = 'hidden' name = 'ant_born_locn_code' value = ''>
					<td class='label' width=<%=width%>><fmt:message key="eMP.AnteNatalCare.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="eMP.given.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='fields' width='100%'><select name="ate_born_where" id="ate_born_where" id = "ate_born_where1" onchange="onchange_antenatal1(this,'');" <%=dis_all_mother_dtls%> >
					<option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
					<option value='I' ><fmt:message key="eMP.inhospital.label" bundle="${mp_labels}"/></option>
					<option value='A'><fmt:message key="eMP.ExtGovClin.label" bundle="${mp_labels}"/></option>
					<option value='B'><fmt:message key="eMP.ExtGovHosp.label" bundle="${mp_labels}"/></option>
					<option value='C'><fmt:message key="eMP.ExtPvtClin.label" bundle="${mp_labels}"/></option>
					<option value='D'><fmt:message key="eMP.ExtPvtHosp.label" bundle="${mp_labels}"/></option>
					<option value='E'><fmt:message key="eMP.NoAntenatal.label" bundle="${mp_labels}"/></option>
					<option value='F'><fmt:message key="eMP.NoInfo.label" bundle="${mp_labels}"/></option>
					</select><img id='locngif1' align=center src='../../eCommon/images/mandatory.gif' style='<%=mand_antenatal_newbornipValue%>' name='locngif1'></img> / <select name="ate_born_at_locn_type" id="ate_born_at_locn_type" id ="ate_born_at_locn_type1" style="width:141" onchange="populate_bornat(this,'<%=request.getContextPath()%>');" <%=dis_all_mother_dtls%>>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value='D'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
					<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<select name="ate_born_at_locn_code" id="ate_born_at_locn_code" id = "ate_born_at_locn_code1"<%=dis_all_mother_dtls%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%	if(!function_id.equals("REGISTER_NEWBORN")){	 																			ant_care_gvn_at=checkForNull((String)hashMap.get("ant_care_gvn_at"));
							ant_care_locn_code=checkForNull((String)hashMap.get("ant_care_locn_code"));
							ant_care_locn_type=checkForNull((String)hashMap.get("ant_care_locn_type"));
						if(!ant_care_locn_type.equals("")) {
							array_list.clear();
							array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,ant_care_locn_type,con,p);
							for(int i=0;i<array_list.size();i+=2) {
								if(checkForNull(ant_care_locn_code).equals((String) array_list.get(i)))
								{
									out.println("<option value=\""+(String)array_list.get(i)+"\"  selected>"+(String)array_list.get(i+1)+"</option>");
								} else {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+ (String)array_list.get(i+1)+"</option>");
								}
							} 
						 }
					}%>						             
					</select>
					</td>
					</tr>
					 </table>
					 <script>
								document.forms[0].ate_born_where1.value="<%=ant_care_gvn_at%>"; 					
								document.forms[0].ate_born_at_locn_type1.value="<%=ant_care_locn_type%>";
								document.forms[0].ant_born_locn_code.value="<%=ant_care_locn_code%>";			
								document.forms[0].ant_born_locn_type.value="<%=ant_care_locn_type%>";
					</script>
<%}%>
<% if(captureAntenatalDtlsYN.equals("Y") && !isMPMandatoryFieldsNewborn) { 
						antenatal_care_yn=checkForNull((String)hashMap.get("antenatal_care_yn"));
						String antechecked="", antecarevalue="N";
						if(antenatal_care_yn.equals("Y")){
							antechecked="checked";
							antecarevalue="Y";
						}
					%>
					<table width="100%" cellpadding='1' cellspacing='0' border='0'>
					<tr>
					<input type = 'hidden' name = 'ant_born_locn_type' value = ''>
					<input type = 'hidden' name = 'ant_born_locn_code' value = ''><!--Below line modified for this CRF HSA-CRF-0182 -->
					<td class='label' width='20%'><fmt:message key="eMP.AnteNatalCare.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="eMP.given.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='6%'><input type="checkbox" <%=antechecked%> name="antenatal_care" value="<%=antecarevalue%>" onClick="callcareValidate('<%=captureAntenatalDtlsYN%>','onClickEvent')" <%=dis_all_mother_dtls%>></td>
					<td class='label' width='18%'><fmt:message key="eMP.AnteNatalCare.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="eMP.given.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='fields' width='50%'><select name="ate_born_where" id="ate_born_where" onchange="onchange_antenatal(this,'<%=call_function_id%>','<%=captureAntenatalDtlsYN%>');" style="width:135" <%=dis_all_mother_dtls%> >
					<option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
					<option value='I' ><fmt:message key="eMP.inhospital.label" bundle="${mp_labels}"/></option>
					<option value='E'><fmt:message key="eMP.externalhospital.label" bundle="${mp_labels}"/></option>
					</select><img id='locngif' align=center src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='locngif'></img> / <select name="ate_born_at_locn_type" id="ate_born_at_locn_type" style="width:141" onchange="populate_bornat(this,'<%=request.getContextPath()%>');" <%=dis_all_mother_dtls%>>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value='D'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
					<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<select name="ate_born_at_locn_code" id="ate_born_at_locn_code" <%=dis_all_mother_dtls%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%	if(!function_id.equals("REGISTER_NEWBORN")){	 												ant_care_gvn_at=checkForNull((String)hashMap.get("ant_care_gvn_at"));
							ant_care_locn_code=checkForNull((String)hashMap.get("ant_care_locn_code"));
							ant_care_locn_type=checkForNull((String)hashMap.get("ant_care_locn_type"));
						if(!ant_care_locn_type.equals("")) {
							array_list.clear();
							array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,ant_care_locn_type,con,p);						
							for(int i=0;i<array_list.size();i+=2) {
								if(checkForNull(ant_care_locn_code).equals((String) array_list.get(i)))
								{
									out.println("<option value=\""+(String)array_list.get(i)+"\"  selected>"+(String)array_list.get(i+1)+"</option>");
								} else {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+ (String)array_list.get(i+1)+"</option>");
								}
							} 
						 }
					}%>						             
					</select> <!--Above line modified for this CRF HSA-CRF-0182 -->
					</td>
					</tr>
					</table>
					<% 	}else{%>
						<tr><td colspan=4></td></tr>
						<%}%>
				<%if(captureAntenatalDtlsYN.equals("Y") && !isMPMandatoryFieldsNewborn)  {
					if(!function_id.equals("REGISTER_NEWBORN")){%>													 
				<script>
							if('<%=antenatal_care_yn%>' == 'Y') {
								document.getElementById('locngif').style.visibility='visible';
								document.forms[0].antenatal_care.value = 'Y';
								document.forms[0].ate_born_where.value="<%=ant_care_gvn_at%>"; 					
								document.forms[0].ate_born_at_locn_type.value="<%=ant_care_locn_type%>";
								document.forms[0].ant_born_locn_code.value="<%=ant_care_locn_code%>";			
								document.forms[0].ant_born_locn_type.value="<%=ant_care_locn_type%>";
							} else {
								document.getElementById('locngif').style.visibility='hidden';
								document.forms[0].ate_born_where.disabled=true;
								document.forms[0].ate_born_where.value='';
								document.forms[0].ate_born_at_locn_type.disabled=true;
								document.forms[0].ate_born_at_locn_code.disabled=true;
								document.forms[0].ate_born_at_locn_type.value=''; 
								document.forms[0].antenatal_care.value = 'N';
							}
							if('<%=ant_care_gvn_at%>' == 'E') {								
								document.forms[0].ate_born_at_locn_type.disabled = true;
								document.forms[0].ate_born_at_locn_code.disabled = true;
							} 
					</script>
                  <%}else{%>
						<script>
							document.forms[0].ate_born_at_locn_type.disabled=true;
							document.forms[0].ate_born_at_locn_code.disabled=true;
							document.forms[0].ate_born_where.disabled=true;
					</script>
				  <%}
					}%>	

<%}catch(Exception e){e.printStackTrace();
}finally{if(con!=null) ConnectionManager.returnConnection(con,request);} %>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

