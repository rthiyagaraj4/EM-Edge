<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8"); 
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<object style="height:0px" id="locale" classid="clsid:C0276E18-D808-4F12-829E-BC186831D396" CODEBASE="../../eCommon/js/Locale.CAB#version=1,0,0,0"></object>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/locale.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/RouteForForm.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	try{
		String mode	= request.getParameter( "mode" ) ;
		String bean_id = "RouteForFormBean" ;
		String bean_name = "ePH.RouteForFormBean";
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_ROUTE_FOR_FORM";
		String pkey_value		="";
		int	   totalRecords	=	0;	
		String route_code="", route_desc="", route_color="",  fntColor="",backgrndColor=""; // added color variables for CRF RUT-CRF-0034.1[IN:037389]

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
	
		RouteForFormBean bean = (RouteForFormBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setLanguageId(locale);

		totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
%>
		<FORM name="formRouteForForm" id="formRouteForForm" action='RouteForFormTemp.jsp' method='post' target='messageFrame'>
<%
			/*this is to be changed when the ph_PARAM Table is complete
			Y or N is to be got from the table and accordingly the 4th field has to be displayed
			later on remove flag and use PARAM_YN all over
			YNforLocLang("N") will also set PARAM_YN in the bean*/
			bean.YNforLocLang();
			String PARAM_YN=(String)bean.getPARAM_YN();
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
				<BR><BR><BR><BR>
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="98%" ALIGN="center" BORDER="1">
					<TR>
						<TH WIDTH="35%"><fmt:message key="ePH.FormCode.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="35%"><fmt:message key="ePH.RouteCode.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="25%"><fmt:message key="ePH.ActionTextLabelinEnglish.label" bundle="${ph_labels}"/></TH>
<%
						if(PARAM_YN.equals("Y")){ 
%>
							<TH WIDTH="25%"><fmt:message key="ePH.ActionTextLabelInLocalLanguage.label" bundle="${ph_labels}"/></TH>
<%
						}
%>
					</TR>
<%
					String bgcolor = "", form_descx="", route_descx="", action_text_labelx="", action_text_label_loc_langx="";
					ArrayList form_desc_arr = bean.getForm_Desc_X("form",locale);
					ArrayList route_desc_arr = bean.getForm_Desc_X("route",locale);
					for ( int cnt = 0; cnt < totalRecords; cnt++ ){
						if (cnt % 2 == 0)
							bgcolor = "QRYODD" ;
						else
							bgcolor = "QRYEVEN" ;
						form_descx					= "form_desc" + cnt ;
						route_descx					= "route_desc" + cnt ;
						action_text_labelx			= "action_text_label" + cnt ;
						action_text_label_loc_langx	= "action_text_label_loc_lang" + cnt ;
%>
						<TR>
							<TD WIDTH="35%" CLASS="<%= bgcolor%>">
								<SELECT name="<%= form_descx %>" id="<%= form_descx %>"  >
									<OPTION VALUE="">&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</OPTION>

<%
									if (form_desc_arr.size() != 0){
										for (int datacnt = 0; datacnt < form_desc_arr.size(); datacnt++){
%>			
											<OPTION VALUE="<%= form_desc_arr.get(datacnt++)%>" > <%=form_desc_arr.get(datacnt)%> </OPTION>
<%
										}//internal for end
									}//if end
%>
								</SELECT>
							</TD>
							
							<TD WIDTH="35%" CLASS="<%= bgcolor %>" >
								<SELECT name="<%= route_descx %>" id="<%= route_descx %>"  >
									<OPTION VALUE="" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</OPTION>
<%
									if (route_desc_arr.size() != 0){
										for (int datacnt = 0; datacnt < route_desc_arr.size(); datacnt+=3){
											route_code =(String)route_desc_arr.get(datacnt);// added for CRF RUT-CRF-0034.1[IN:037389]-start
											route_desc=(String)route_desc_arr.get(datacnt+1);
											fntColor= "";
											backgrndColor= "";
											route_color =(String)route_desc_arr.get(datacnt+2);
											if(route_color!= null && !route_color.equals("")){
												if(route_color.length()==12){
													fntColor= route_color.substring(0, 6);
													backgrndColor= route_color.substring(6, 12);
												}
											}// added for CRF RUT-CRF-0034.1[IN:037389]-end
%>			
											<OPTION VALUE="<%= route_code%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' > <%=route_desc%> </OPTION>
<%
											}//internal for end
										}//if end
%>
									</SELECT>
								</TD>

								<TD WIDTH="25%" CLASS="<%= bgcolor%>" >
									<INPUT TYPE="text" name="<%= action_text_labelx %>" id="<%= action_text_labelx %>" VALUE="" SIZE="30" MAXLENGTH="30" onBlur="resetColorCode(this);" >
								</TD>
<%
								if(PARAM_YN.equals("Y")){ 
%>
									<TD WIDTH="25%" CLASS="<%= bgcolor%>">
										<INPUT TYPE="text" name="<%= action_text_label_loc_langx %>" id="<%= action_text_label_loc_langx %>" VALUE="" SIZE="30" MAXLENGTH="30" style='text-align:right' onFocus='loadArabic()'  class='OTHLANGTEXT' >
									</TD>
<% 
							}
%>
						</TR>
<%
					}//for insert
%>
				</table>
<%
			}//if mode=insert
			if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
				String form_code= (request.getParameter("form_code" )).trim() ;
				route_code= (request.getParameter("route_code" )).trim() ;
				route_color= request.getParameter("route_color" ) ;
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}// added for CRF RUT-CRF-0034.1[IN:037389]-end
				bean.setForm_Code( form_code );
				bean.setRoute_Code(route_code );
				bean.loadData();
				//primary_key_1  ------>FORM_CODE
				//primary_key_2  ------>ROUTE_CODE
				//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(form_code);      
				Pk_values.add(route_code);      
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value   ="";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}
				else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();
				}
%>
				<BR><BR><BR><BR><BR><BR><BR><BR>
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="70%" ALIGN="center" BORDER="0">
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
					
					
					<INPUT TYPE="hidden" name="form_code" id="form_code" VALUE="<%=form_code%>">
					<INPUT TYPE="hidden" name="route_code" id="route_code" VALUE="<%=route_code%>">
						<TR>
							<TD CLASS="label"><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></TD>
							<TD>&nbsp;<INPUT TYPE="text" name="form_desc" id="form_desc" VALUE="<%=bean.getForm_Desc()%>" SIZE="22" MAXLENGTH="20" readOnly >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img></TD>
							<td> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
						</TR>
						<TR>
							<TD COLSPAN="3">&nbsp;</TD>
						</TR>
						<TR>
							<TD  CLASS="label"><fmt:message key="ePH.RouteDescription.label" bundle="${ph_labels}"/></TD>
							<TD COLSPAN="2">&nbsp;<INPUT TYPE="text" name="route_desc" id="route_desc" VALUE="<%=bean.getRoute_Desc()%>" SIZE="22" MAXLENGTH="20"  readOnly style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img></TD>
						</TR>
						<TR>
							<TD COLSPAN="3">&nbsp;</TD>
						</TR>
						<TR>
							<TD class="label" align="right"><fmt:message key="ePH.ActionTextLabel.label" bundle="${ph_labels}"/></TD>
							<TD COLSPAN="2">&nbsp;<INPUT TYPE="text" name="action_text_label" id="action_text_label" VALUE="<%=bean.getAction_Text_Label()%>" SIZE="30" MAXLENGTH="30"  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img></TD>
						</TR>
						<TR>
							<TD COLSPAN="3">&nbsp;</TD>
						</TR>
	
<%
						if(	(PARAM_YN.equals("Y"))  ){
%>
							<TR>
								<TD class="label" ><fmt:message key="ePH.ActionTextLabelInLocalLanguage.label" bundle="${ph_labels}"/></TD>
								<TD COLSPAN="2">&nbsp;<INPUT TYPE="text" name="action_text_label_loc_lang" id="action_text_label_loc_lang" VALUE="<%=bean.getAction_Text_Label_Loc_Lang1()%>" SIZE="30" MAXLENGTH="30" style='text-align:right' onFocus='loadArabic()'  class='OTHLANGTEXT' ></TD>
							
							</TR>

							<TR>
								<TD COLSPAN="3">&nbsp;</TD>
<%
						}// if end
%>
					</TR>
<%
				}// if mode=modify
%>
			</TABLE>
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="PARAM_YN" id="PARAM_YN" VALUE="<%=PARAM_YN%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
		</FORM>
<% 
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){
%>
			<script>
				document.formRouteForForm.form_desc0.focus() ;
			</script>
<%
		}
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
%>
			<script>
				document.formRouteForForm.action_text_label.focus() ;
			</script>
<%
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</BODY>
</HTML>

