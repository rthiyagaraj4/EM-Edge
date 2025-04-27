<!DOCTYPE html>
<!--Created by Thamizh selvi on 2nd Feb 2017 against ML-MMOH-CRF-0634-->
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.parser.JSONParser,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AETOTVSR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale			= (String)session.getAttribute("LOCALE");
    Connection con			= null;
	PreparedStatement	pstmt		=	null;
	ResultSet		rs		=	null;
try
{
	con = ConnectionManager.getConnection(request);	
	String currentdate =  eAE.AECommonBean.getSysDate(con);	
	//Added By Shanmukh for MMS-DM-CRF-0147
	Boolean isPriorityZoneAppl	= false;
	isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");
	String sql              ="";
%>

<HTML>
<HEAD>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eAE/js/AERepTotalVisitReg.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onLoad='datechange();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="repTotalVisitReg" id="repTotalVisitReg" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='90%' align='center' valign='top' border='0'>

	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
	</th>

	<tr>
		<td width="90%" class="Border" align='center' >
		<table width='90%' cellPadding="2" cellSpacing="0" align='center' border=0>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%' class="fields"  >
						 <SELECT name="report_type" id="report_type" onchange='datechange()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td width="25%"></td>
					<td class="querydata" width="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width="25%"></td>
				</tr>
				<tr>
					<td align='right' id='MY1'class="label"> &nbsp; </td>
					<td align='left' id='MY'> &nbsp; </td> 
					<td id='MY3'> &nbsp; </td> 
			    </tr>
				<tr>
					<td  class="label" width="25%"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
					<td width="25%"><input type="text" name="P_FM_TREAT_CODE" id="P_FM_TREAT_CODE" size='10' maxlength="2" onBlur='if(this.value != "") nursCode(fromlocn1,this)' onKeyPress="return splCharChk(this,event);"><input type='button' name='fromlocn1' id='fromlocn1' value='?' class='button' onclick='nursCode(this, P_FM_TREAT_CODE)'></td> 
					<td width="25%"><input type="text" name="P_TO_TREAT_CODE" id="P_TO_TREAT_CODE" size='10' maxlength="2" onBlur='if(this.value != "") nursCode(fromlocn1,this)' onKeyPress="return splCharChk(this,event);"><input type='button' name='tolocn1' id='tolocn1' value='?' class='button' onclick='nursCode(this, P_TO_TREAT_CODE)'>
					</td>
					<td  width="25%"></td>
				</tr>
				<tr>
					<td  class='label' width="25%">
					<fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/>
					</td>
					<td width="25%">
						<select name='P_PRIORITY_ZONE' id='P_PRIORITY_ZONE' >
							<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<%
				if(isPriorityZoneAppl){//Added By Shanmukh for MMS-DM-CRF-0147
				sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ?  order by PRIORITY_ZONE_ORDER asc ";
			
				
			    pstmt   = con.prepareStatement(sql.toString());
				
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
				out.println("<option value='"+rs.getString(1)+"'>");	     
			   out.println(rs.getString(2));
			   out.println("</option>"); 
				}
		        if(rs!=null)rs.close();
				if(pstmt!=null)	pstmt.close();
				}else{			
							
								JSONArray priorZoneJsonArr	= new JSONArray();
								priorZoneJsonArr  = eAE.AECommonBean.getPriorityZoneList(con,locale,p_facility_id);	
									
								for(int i = 0 ; i < priorZoneJsonArr.size() ; i++) 
								{
									JSONObject json	= (JSONObject)priorZoneJsonArr.get(i);
									String PRIORITY_ZONE  = (String) json.get("PRIORITY_ZONE");
									String PRIORITY_ZONE_DESC  = (String) json.get("PRIORITY_ZONE_DESC");
											
									out.println("<option value='"+PRIORITY_ZONE+ "'>"+PRIORITY_ZONE_DESC+"</option>");
											
								}
					
				}		
							%>
						</select>
					</td>
					<td width="25%"></td>
					<td width="25%"></td>
				</tr>
				<tr> 
					<td class=label><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name="P_TERM_SET_ID" id="P_TERM_SET_ID" onchange = "resetOnChangeTermSet();enable_code()"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				
						<%
								JSONArray termSetJsonArr	= new JSONArray();
								termSetJsonArr  = eAE.AECommonBean.getTermSetList(con);	
									
								for(int i = 0 ; i < termSetJsonArr.size() ; i++) 
								{
									JSONObject json	= (JSONObject)termSetJsonArr.get(i);
									String termSetID  = (String) json.get("term_set_id");
									String termSetDesc  = (String) json.get("term_set_desc");
											
									out.println("<option value='"+termSetID+ "'>"+termSetDesc+"</option>");
											
								}
									
									
						%>
					</select>
					</td> 
			
				</tr> 
				<tr> 
					<td class='label' ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
					<td class='fields'nowrap><input type='text' name='P_FM_TERM_CODE' id='P_FM_TERM_CODE' value="" size='10' maxlength='15' onKeyPress="return splCharChk(this,event);" disabled><input type='button' class='button' value='?' name='diag_frmbutton' id='diag_frmbutton' onClick="searchgrpCode(this,P_FM_TERM_CODE);" disabled></td> 
					<td width="25%"><input type='text' name='P_TO_TERM_CODE' id='P_TO_TERM_CODE' value="" size='10' maxlength='15' onKeyPress="return splCharChk(this,event);" disabled><input type='button' class='button' value='?' name='diag_tobutton' id='diag_tobutton' onClick="searchgrpCode(this,P_TO_TERM_CODE);" disabled>
					</td>
				
				</tr>
				
		</table>
		</td>
	</tr>
	<tr>
		<td width="90%" class="Border" align='center' >
			<table width='90%' cellPadding="2" cellSpacing="0" align='center' border=0>
				<tr>
						<td class='label'><fmt:message key="eMR.FreeText.label" bundle="${mr_labels}"/></td>
						<td align='right' width='19%' class="label">  &nbsp;</td>
						<td class='fields'><select name='start_ends_contains' id='start_ends_contains' disabled><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select><input type='text' name='P_Free_Text' id='P_Free_Text'  value="" size='62' maxlength="100" onKeyPress="return splCharChk(this,event);" disabled></td>
				</tr>
			</table>
		</td>
		<tr>
			<td align='right' width='30%' class="label">  &nbsp;</td>
		</tr>
	</tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="current_date" id="current_date"		value="<%= currentdate%>">
<input type="hidden" name="locale" id="locale"			    value="<%= locale%>">
</form>
</body>
</html>
<%
	} catch(Exception e) {e.printStackTrace();}
	finally {
	  if(con!=null) 
	  ConnectionManager.returnConnection(con,request);
	}
%>

