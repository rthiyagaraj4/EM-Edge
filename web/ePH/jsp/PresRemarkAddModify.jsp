<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
        request.setCharacterEncoding("UTF-8");

		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PresRemark.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<SCRIPT>
			function_id = "<%= request.getParameter( "function_id" ) %>"
		</SCRIPT>
	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" STYLE="overflow-y:hidden">
<%
	try{
		/* Mandatory checks start */
		String mode			= request.getParameter( "mode" ) ;
		String bean_id		= "PresRemarkBean" ;
		String bean_name	= "ePH.PresRemarkBean" ;
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_PRES_REMARK";
		String pkey_value		="";
		String readOnly		= "" ;
		int	totalRecords	= 0 ;
		String checked = "";

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
			return ;
		/* Mandatory checks end */

		/* Initialize Function specific start */
		PresRemarkBean bean = (PresRemarkBean)getBeanObject( bean_id, bean_name,request ) ;
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setLanguageId(locale) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue( "MULTIPLE_INSERT_PAGE_SIZE" ));
		/* Initialize Function specific end */
		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
%>
		<FORM name="formPresRemark" id="formPresRemark">

<%
			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) {
				ArrayList formOfDrug	= bean.getFormOfDrug() ;

				if (formOfDrug.size() != 0) {
%>
					<BR><BR><BR><BR><BR>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
					<TR>
						<TH WIDTH="8%"><fmt:message key="ePH.RemarkCode.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="27%"><fmt:message key="ePH.RemarkDescription.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="27%"><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="27%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></TH>
						<TH WIDTH="7%"><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/></TH>
					</TR>

<%
					String bgcolor = "";
					for ( int cnt = 0; cnt < totalRecords; cnt++ ) {
						if (cnt % 2 == 0)
							bgcolor = "QRYEVEN" ;
						else
							bgcolor = "QRYODD" ;
%>
						<TR>
							<TD WIDTH="8%" CLASS="<%= bgcolor%>">&nbsp;<INPUT TYPE="text" name="REMARK_CODE_<%= cnt %>" id="REMARK_CODE_<%= cnt %>" CLASS="UPPER" VALUE="" SIZE="4" MAXLENGTH="4" onBlur="this.value=this.value.toUpperCase();resetColorCode(this);remarksCodeCheck(this)" onKeyPress="return CheckForSpecChars(event);"></TD>
							<TD WIDTH="27%" CLASS="<%= bgcolor%>">&nbsp;<INPUT TYPE="text" name="REMARK_DESC_<%= cnt %>" id="REMARK_DESC_<%= cnt %>" VALUE="" SIZE="28" MAXLENGTH="40" onBlur="resetColorCode(this);enableFormList(this.value, '<%= cnt %>');makeValidString(this);"></TD><!-- MakevalidString(this)interchanged at the end of onblur method SKR-SCF-1053 [IN:051947] -->
							<TD WIDTH="27%" CLASS="<%= bgcolor%>">
								&nbsp;<SELECT DISABLED name="FORM_CODE_<%= cnt %>" id="FORM_CODE_<%= cnt %>" onChange="getRouteOfDrug(this, 2)">
								<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
								for (int datacnt = 0; datacnt < formOfDrug.size(); datacnt++) {
%>
									<OPTION VALUE="<%= formOfDrug.get(datacnt++) %>"><%= formOfDrug.get(datacnt) %></OPTION>
<%
								}
%>
								</SELECT>
							</TD>
							<TD WIDTH="27%" CLASS="<%= bgcolor %>" >
								&nbsp;<SELECT DISABLED name="ROUTE_CODE_<%= cnt %>" id="ROUTE_CODE_<%= cnt %>">
								<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
								</SELECT>
							</TD>
							<TD WIDTH="6%" CLASS="<%= bgcolor%>">&nbsp;<INPUT TYPE="checkbox" name="APPL_SLIDING_SCALE_YN_<%= cnt %>" id="APPL_SLIDING_SCALE_YN_<%= cnt %>" CLASS="UPPER" VALUE="Y" SIZE="4"  DISABLED></TD>
						</TR>
<%
						}
					}
					else {
%>
						<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>
<%
					}
%>
				</TABLE>
<%
			}
			if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) ) {
				String remark_code		=	request.getParameter( "REMARK_CODE" ).trim() ;
				String remark_desc		=	request.getParameter( "REMARK_DESC" ).trim() ;
				String form_code		=	request.getParameter( "FORM_CODE" ).trim() ;
				String form_desc		=	request.getParameter( "FORM_DESC" )==null ?"":request.getParameter( "FORM_DESC" ).trim();
				String route_code		=	request.getParameter( "ROUTE_CODE" ).trim() ;
				String route_desc		=	request.getParameter( "ROUTE_DESC" )== null ?"":request.getParameter( "ROUTE_DESC" ).trim();
				String appl_sliding_scale_yn		=	bean.checkSliding(remark_code);

				bean.setRemarkCode( remark_code ) ;
				bean.setRemarkDesc( remark_desc ) ;
				bean.setFormCode( form_code ) ;
				//bean.setFormDesc( form_desc ) ;
				bean.setRouteCode( route_code ) ;
				//bean.setRouteDesc( route_desc ) ;
				bean.setApplSlidingScaleYN( appl_sliding_scale_yn ) ;
				readOnly = "readonly" ;
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(remark_code);      
				
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
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="0">
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD WIDTH="25%" CLASS="label"><fmt:message key="ePH.RemarkCode.label" bundle="${ph_labels}"/></TD>
						<TD WIDTH="75%" >&nbsp;<INPUT TYPE="text" name="REMARK_CODE" id="REMARK_CODE" VALUE="<%= bean.getRemarkCode() %>" SIZE="4" MAXLENGTH="4" <%= readOnly %> onKeyPress="return CheckForSpecChars(event);" ></TD>
						<td> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
					</TR>
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD WIDTH="25%" CLASS="label"><fmt:message key="ePH.RemarkDescription.label" bundle="${ph_labels}"/></TD>
						<TD WIDTH="75%" COLSPAN="2">&nbsp;<INPUT TYPE="text" name="REMARK_DESC" id="REMARK_DESC" VALUE="<%= bean.getRemarkDesc() %>" SIZE="45" MAXLENGTH="40" onblur="makeValidString(this);" ></TD>
					</TR>
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD WIDTH="25%"  CLASS="label"><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></TD>
						<TD WIDTH="75%" COLSPAN="2">&nbsp;
							<SELECT name="FORM_CODEANDDESC" id="FORM_CODEANDDESC" onChange="getRouteOfDrug(this, 2)">
								<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-- Select --&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
<%
								String avl_form_code	= bean.getFormCode();
								String select_def_form	= "", curr_form_code="";
								ArrayList formOfDrug	= bean.getFormOfDrug() ;
								if (formOfDrug.size() != 0) {
									for (int datacnt = 0; datacnt < formOfDrug.size(); datacnt+=2) {
										curr_form_code = formOfDrug.get(datacnt).toString();
										if (curr_form_code.equals(avl_form_code))
											select_def_form = "SELECTED";
										else
											select_def_form = "";
%>
										<OPTION <%= select_def_form %> VALUE="<%= curr_form_code %>"><%= formOfDrug.get(datacnt+1) %></OPTION>
<%
									}
								}
%>
							</SELECT>
						</TD>
					</TR>
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD WIDTH="25%"  CLASS="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></TD>
						<TD WIDTH="75%"  COLSPAN="2">&nbsp;
						<SELECT name="ROUTE_CODEANDDESC" id="ROUTE_CODEANDDESC">
							<OPTION VALUE="">&nbsp;&nbsp;-- Select --&nbsp;&nbsp;</OPTION>
<%
							String avl_route_code	= bean.getRouteCode();
							String select_def_route	= "", curr_route_code="";
							String route_color="", fntColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
							String backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
							ArrayList routeOfDrug = new ArrayList();
							routeOfDrug = bean.getRouteOfDrug( form_code );
							if (routeOfDrug.size() != 0) {
								for (int datacnt = 0; datacnt < routeOfDrug.size(); datacnt+=3) {
									curr_route_code = routeOfDrug.get(datacnt).toString();
									// added for CRF RUT-CRF-0034.1[IN:037389]-start
									route_color= (String)routeOfDrug.get(datacnt+2);
									fntColor= "";
									backgrndColor= "";
									if(route_color!= null && !route_color.equals("")){
										if(route_color.length()==12){
											fntColor= route_color.substring(0, 6);
											backgrndColor= route_color.substring(6, 12);
										}
									}
									// added for CRF RUT-CRF-0034.1[IN:037389]-end
									if (curr_route_code.equals(avl_route_code))
										select_def_route = "SELECTED";
									else
										select_def_route = "";
%>
									<OPTION <%= select_def_route %> VALUE="<%= curr_route_code %>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'><%= routeOfDrug.get(datacnt+1) %></OPTION>
<%
								}
							}
%>
							</SELECT>
						</TD>
						<INPUT TYPE="hidden" name="AVL_ROUTE_CODE" id="AVL_ROUTE_CODE" VALUE="<%= avl_route_code %>">
					</TR>
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
					<TR>
<%
						if (bean.getApplSlidingScaleYN().equals("Y"))
							checked	 = "CHECKED";
						else
							checked	 = "";
%>
						<TD WIDTH="25%"  CLASS="label"><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/></TD>
						<TD WIDTH="75%"  COLSPAN="2">&nbsp;<INPUT TYPE="checkbox" name="APPL_SLIDING_SCALE_YN" id="APPL_SLIDING_SCALE_YN" VALUE="Y"   <%= checked %>></TD>
					</TR>
					<TR>
						<TD COLSPAN="3">&nbsp;</TD>
					</TR>
<%
				}
%>
			</TABLE>
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" VALUE="<%= totalRecords %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
		</FORM>
<%
		if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) ) {
%>
			<SCRIPT>document.formPresRemark.REMARK_DESC.focus();</SCRIPT>
<%
		}
		if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) {
%>
			<SCRIPT>document.formPresRemark.REMARK_CODE_0.focus();</SCRIPT>
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

