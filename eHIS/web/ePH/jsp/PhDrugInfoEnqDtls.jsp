<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ --> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*, java.lang.*, java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.* ,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %> <!-- Modified for MOHE-CRF-0074 -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>   
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	  con				= ConnectionManager.getConnection(request);
	 	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
		String Sysdate="";
		ArrayList facilities=null;
		ArrayList Enq_Dtl=null;
		String Sysdate1="";

		//String dis="";
		String logged_fcy1="";
		//String facility_name=(String) session.getValue("facility_name");//code commented for IN:048274 
		//String facility_name1=(String) session.getValue("facility_name");//code commented for IN:048274 
		String confidential_yn="";
		String Confidential_YN="N";
		String mode	= request.getParameter("mode")==null?"":request.getParameter("mode");
		String Enq_num	= request.getParameter("Enq_num")==null?"":request.getParameter("Enq_num");
		String homepage	= request.getParameter("homepage")==null?"":request.getParameter("homepage");

		String bean_id			= "PhDrugInfoEnqBean" ;
		String bean_name		= "ePH.PhDrugInfoEnqBean";
		
		PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		String facility_id		=	(String) session.getValue("facility_id");//code added for IN:048274 
		String facility_name	=   bean.getFacilityName(facility_id);//code added for IN:048274 
		String logged_facility_name = facility_name;
		String login_user= (String) session.getValue("login_user");
		String appl_user_name= (String) session.getValue("appl_user_name");
		//code added for IN:049077 --Start
		String login_pract_id="";
		String login_pract_name="";
		HashMap pract_details=new HashMap();
		pract_details=bean.getPractDetails(login_user);
		 if(pract_details.size()>0){
			login_pract_id=(String)pract_details.get("LOGIN_PRACT_ID");
			login_pract_name=(String)pract_details.get("LOGIN_PRACT_NAME");
		  }//code added for IN:049077 --End
		if(Enq_num.equals("")){
			bean.clear() ;
		}

		bean.setMode(mode) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		String logged_fcy = bean.getLoggedInFacility();
		logged_fcy1=logged_fcy;
		facilities = bean.getFacilities();
		Sysdate		=bean.getSysdate();
		//Sysdate		=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		Sysdate1=Sysdate;
		if(!Enq_num.equals("")){
			Enq_Dtl =bean.getEnquirerDetails();
		}

		String sel1="",sel2="",sel3="",sel4="";
		String sel5="",sel6="",sel7="",sel8="",sel9="", sel20="";
		
		String SOURCE_OF_REQUEST="",ENQUIRER_ID ="", ENQUIRER_NAME ="", ENQUIRER_TYPE_CODE ="", ENQUIRER_TYPE_DESC="", ENQUIRER_OTH="", REQUEST_PRIORITY="", REQUEST_OTH="", ENQUIRY_DATE_TIME="", REQUEST_MODE="",OTHER_REQUEST_MODE="", CONTACT_ADDR1="", CONTACT_ADDR2="", CONTACT_ADDR3="", CONTACT_ADDR4="", CONTACT_TEL="", CONTACT_FAX="", CONTACT_EMAIL="", REPLY_ADDR1="", REPLY_ADDR2="", REPLY_ADDR3="", REPLY_ADDR4="", REPLY_TEL="", REPLY_FAX="", REPLY_EMAIL="",FACILITY_DESC="";
		
		String dis="";
		String replied_by	="";
		String verified_by	="";
		String chk="unchecked";
		if(Enq_Dtl!=null){
			if(Enq_Dtl.size() > 0){
				confidential_yn =(String)Enq_Dtl.get(47);
				if(confidential_yn.equals("Y")) 
					chk="checked";
				replied_by=(String)Enq_Dtl.get(39);
				if(replied_by==null) 
					replied_by="";
				verified_by=(String)Enq_Dtl.get(40);
				if(verified_by==null) 
					verified_by="";

				if(!replied_by.equals("")) dis="disabled";
					SOURCE_OF_REQUEST=(String)Enq_Dtl.get(1);
				if(!SOURCE_OF_REQUEST.equals(logged_fcy)){
					logged_fcy = SOURCE_OF_REQUEST;
				}
				REQUEST_PRIORITY=(String)Enq_Dtl.get(7)==null?"":(String)Enq_Dtl.get(7);
				if(REQUEST_PRIORITY.equals("U")) 
					sel1="Selected";
				else if(REQUEST_PRIORITY.equals("I")) 
					sel2="Selected";
				else if(REQUEST_PRIORITY.equals("H"))
					sel3="Selected";
				else if(REQUEST_PRIORITY.equals("W")) 
					sel4="Selected";
				ENQUIRY_DATE_TIME =(String)Enq_Dtl.get(9);
				if(!ENQUIRY_DATE_TIME.equals("")){
					Sysdate1=ENQUIRY_DATE_TIME;
					//Sysdate1=com.ehis.util.DateUtils.convertDate(Sysdate1,"DMYHM","en",locale);
				}
				ENQUIRER_OTH=(String)Enq_Dtl.get(6)==null?"":(String)Enq_Dtl.get(6);
				REQUEST_OTH=(String)Enq_Dtl.get(8)==null?"":(String)Enq_Dtl.get(8);
				ENQUIRER_ID=(String)Enq_Dtl.get(2)==null?"":(String)Enq_Dtl.get(2);
				ENQUIRER_NAME=(String)Enq_Dtl.get(3)==null?"":(String)Enq_Dtl.get(3);
				ENQUIRER_TYPE_DESC=(String)Enq_Dtl.get(5)==null?"":(String)Enq_Dtl.get(5);
				if(!ENQUIRER_OTH.equals("")) 
					ENQUIRER_TYPE_DESC=ENQUIRER_OTH;

				ENQUIRER_TYPE_CODE=(String)Enq_Dtl.get(4)==null?"":(String)Enq_Dtl.get(4);
				REQUEST_MODE=(String)Enq_Dtl.get(10)==null?"":(String)Enq_Dtl.get(10);

				if(REQUEST_MODE.equals("P")) 
					sel5="Selected";
				else if(REQUEST_MODE.equals("T")) 
					sel6="Selected";
				else if(REQUEST_MODE.equals("E"))
					sel7="Selected";
				else if(REQUEST_MODE.equals("F"))
					sel8="Selected";
				else if(REQUEST_MODE.equals("R"))
					sel9="Selected";
				else if(REQUEST_MODE.equals("S")) 
					sel20="Selected";

				FACILITY_DESC=(String)Enq_Dtl.get(46);
				CONTACT_ADDR1=(String)Enq_Dtl.get(11);
				CONTACT_ADDR2=(String)Enq_Dtl.get(12);
				CONTACT_ADDR3=(String)Enq_Dtl.get(13); 
				CONTACT_ADDR4=(String)Enq_Dtl.get(14); 
				CONTACT_TEL=(String)Enq_Dtl.get(15);
				CONTACT_FAX=(String)Enq_Dtl.get(16);
				CONTACT_EMAIL=(String)Enq_Dtl.get(17);
				REPLY_ADDR1=(String)Enq_Dtl.get(18);
				REPLY_ADDR2=(String)Enq_Dtl.get(19);
				REPLY_ADDR3=(String)Enq_Dtl.get(20);
				REPLY_ADDR4=(String)Enq_Dtl.get(21);
				REPLY_TEL=(String)Enq_Dtl.get(22);
				REPLY_FAX=(String)Enq_Dtl.get(23);
				REPLY_EMAIL=(String)Enq_Dtl.get(24);
				OTHER_REQUEST_MODE=(String)Enq_Dtl.get(45);
				if(SOURCE_OF_REQUEST.equals("*F")){
					facility_name=FACILITY_DESC;
				}
			}
		}
		//if ((mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) )||(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )  ) )) {
		//}
		String SQL_PH_AM_PRACTITIONER_SELECT=PhRepository.getPhKeyValue("SQL_PH_AM_PRACTITIONER_SELECT");
		String order_facility_id= "" , order_facility_name= ""; //Added for MOHE-CRF-0074
		String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
		ArrayList region_code_check = bean.getRegionCheck(login_user,region_code); //Added for MOHE-CRF-0074
%>
		<form name='PhDrugInfoEnqForm' id='PhDrugInfoEnqForm' >
			<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
				<TR>
					<TD class="COLUMNHEADERCENTER" colspan='8' height='18'><b><fmt:message key="ePH.EnquirerDetails.label" bundle="${ph_labels}"/></b></TD>
				 </TR>
				<TR>
					<TD colspan="4">&nbsp;</TD>
				</TR>
				<TR>
					<TD class="label" width="20%" nowrap><fmt:message key="ePH.SourceOfRequest.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
					<TD class="label" width="35%"><SELECT name="Source" id="Source"  onchange="showFacility(this);" <%=dis%>>
							<OPTION value='LoggedF'><fmt:message key="ePH.WithinFacility.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
							<OPTION value='OtherF'><fmt:message key="ePH.OtherEnterpriseFacility.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
							<OPTION value='WithinF'><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
							<OPTION value='Public'><fmt:message key="ePH.Public.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>&nbsp;
						</select>
						<IMG  src="../../eCommon/images/mandatory.gif" align="center"></IMG>
						<input type='hidden' name='src' id='src' value='<%=SOURCE_OF_REQUEST%>'>
					</TD>
					<TD width="15%" class='label'><font id='ff'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font></td>
					<TD width="35%" class='label'><font id='id4'><input type='text' name='facility_name' id='facility_name' maxlength='30' value='<%=facility_name%>' disabled size='30'></font>
					<IMG id='mando' src="../../eCommon/images/mandatory.gif" align="center" style='display:none'><font id='fc' style="display:none" ></IMG>
					<SELECT name="other_source" id="other_source" ><OPTION value="">&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;</OPTION>
<%
					//MOHE-CRF-0074-Start 
					if(region_check){
					for (int i=0;i<region_code_check.size();i+=2){						
						order_facility_id=(String)region_code_check.get(i);
						order_facility_name=(String)region_code_check.get(i+1);
						if (!order_facility_id.equals(logged_fcy1)){
%>
					<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
				  }
					}
				}else{  //MOHE-CRF-0074-End
					String selOrderFcy = "", ord_fac_code="";
					for (int i=0; i<facilities.size(); i += 2) {
						ord_fac_code = (String)facilities.get(i);
						if (!ord_fac_code.equals(logged_fcy1)){
%>
							<OPTION <%= selOrderFcy %> VALUE="<%= ord_fac_code %>" ><%= facilities.get(i+1) %></OPTION>
<%
						}
					}	
				} //Added for MOHE-CRF-0074
%>
					&nbsp;</select><IMG id='mand' src="../../eCommon/images/mandatory.gif" align="center">&nbsp;</IMG></font></TD>
				</TR>
				<TR >
					<TD class="label" width="20%" ><fmt:message key="ePH.ModeofRequest.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
					<TD class="label" width="35%">
						<SELECT name="request_mode" id="request_mode" <%=dis%> onchange='callMode(this)'>
							<OPTION value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</OPTION>
							<OPTION value="P" <%=sel5%>><fmt:message key="Common.InPerson.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="T" <%=sel6%>><fmt:message key="Common.telephone.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="E" <%=sel7%>><fmt:message key="ePH.E-Mail/Letter.label" bundle="${ph_labels}"/></OPTION>
							<OPTION value="F" <%=sel8%>><fmt:message key="ePH.Facsimile.label" bundle="${ph_labels}"/></OPTION>
							<OPTION value="R" <%=sel9%>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="S" <%=sel20%>><fmt:message key="Common.self.label" bundle="${common_labels}"/></OPTION>
						</select>&nbsp;<IMG id='main_mode' style='display:none' src="../../eCommon/images/mandatory.gif" align="center"></IMG></TD>
					<TD width="15%" class='label'><font id='id3'><fmt:message key="Common.others.label" bundle="${common_labels}"/></font></td>
					<TD width="35%" class='label'><font id='id7'><INPUT type="text" name="other_mode" id="other_mode"  value="<%=OTHER_REQUEST_MODE%>" maxlength="40" <%=dis%> size="40" >&nbsp;<IMG id='oth_mode'  src="../../eCommon/images/mandatory.gif" align="center"></IMG></font></TD>
				</TR>							
				<TR >
					<TD class="label" width="20%"><fmt:message key="ePH.NameofthePerson.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<TD class="label" width="35%"><INPUT type="text" name="Pract_name" id="Pract_name"  maxlength="60" size="30" readonly value="<%=ENQUIRER_NAME%>"><INPUT type="button" class="button" value="?" name="Pract_name_btn" id="Pract_name_btn" onclick="searchPractitionerName();" <%=dis%>>&nbsp;<IMG id='id1' src="../../eCommon/images/mandatory.gif" align="center"></IMG>
					<TD width="15%" class='label'><font id='pn' style='display:none'>&nbsp;&nbsp;<fmt:message key="Common.others.label" bundle="${common_labels}"/>&nbsp;&nbsp;</font>
					<TD width="35%" class='label'><font id='id5' style='display:none'><INPUT type="text" name="other_pract" id="other_pract"  value="<%=ENQUIRER_NAME%>" <%=dis%> maxlength="60" size="40" onblur="disableDesignation(this);">&nbsp;<IMG id='mand1' style='' src="../../eCommon/images/mandatory.gif" align="center"></IMG></font><INPUT type="hidden" name="Pract_id" id="Pract_id" value="<%=ENQUIRER_ID%>"> </TD>
				</TR>
				<TR >
					<TD class="label" width="20%" ><fmt:message key="Common.designation.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
					<TD class="label" width="35%"><INPUT type="text" name="Designation" id="Designation"  maxlength="10" size="30" disabled value="<%=ENQUIRER_TYPE_DESC%>" <%=dis%>>&nbsp;<INPUT type="hidden" name="pract_type" id="pract_type" value="<%=ENQUIRER_TYPE_CODE%>">
					</TD>
					<TD width="15%" class='label'></td>
					<TD width="35%" class='label'></font></TD>
				</TR>
				<TR >
					<TD class="label" width="20%" nowrap><fmt:message key="ePH.PriorityoftheRequest.label" bundle="${ph_labels}"/></TD>
					<TD class="label" width="35%"><SELECT name="priority" id="priority" <%=dis%> onchange='callPriority(this)'>
					<OPTION value="">&nbsp;&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;&nbsp;</OPTION> 
					<OPTION value="U" <%=sel1%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="I" <%=sel2%>><fmt:message key="ePH.Immediatewithin1to2hours.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="H" <%=sel3%>><fmt:message key="ePH.Within24Hours.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="W" <%=sel4%>><fmt:message key="ePH.Inaweekstime.label" bundle="${ph_labels}"/></OPTION>
					</select>&nbsp;<IMG id='main_prio' style='display:none' src="../../eCommon/images/mandatory.gif" align="center"></IMG></TD>
					<TD width="15%" class='label'><font id='id2'>&nbsp;&nbsp;<fmt:message key="Common.others.label" bundle="${common_labels}"/>&nbsp;&nbsp;</font></td>
					<TD width="35%" class='label'><font id='id6'><INPUT type="text" name="other_priority" id="other_priority"  value="<%=REQUEST_OTH%>" maxlength="40" size="40" <%=dis%>>&nbsp;<IMG  id='oth_prio'  src="../../eCommon/images/mandatory.gif" align="center"></IMG></font></TD>
				</TR> 
				<TR >
					<TD class="label" width="20%" ><fmt:message key="ePH.EnquiryDate/Time.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="16" size="16"  value="<%=com.ehis.util.DateUtils.convertDate(Sysdate1,"DMYHM","en",locale) %>" <%=dis%> name="enc_dt" id="enc_dt" OnBlur='validateEnquiryDate(this,sysdate);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('enc_dt',null,'hh:mm');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></TD>
					<TD  width="15%">&nbsp;</TD>
					<TD  class='label' width="35%">&nbsp;</td>
				</TR>
				<TR>
					<td class="label" width="20%"><fmt:message key="Common.Confidential.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<TD class="label" width="20%">
						<input type="checkbox"  name="confidential_yn" id="confidential_yn"  <%=dis%> <%=chk%>  value ="<%=confidential_yn%>"      onchange='chk();' >
					</TD>
					<TD colspan='8' class='label'>&nbsp;&nbsp;&nbsp;</TD>
				</TR>
				<TR>
					<TH colspan='6' height='15'><b><fmt:message key="ePH.EnquirerContactDetails.label" bundle="${ph_labels}"/></b></TH>
				</TR>
				<TR>
					<TD class="label" width="20%" nowrap>&nbsp;</TD>
					<TD class="label" width="35%" nowrap>&nbsp;</TD>
					<TD class="label" width="20%" nowrap >&nbsp;</TD>
					<TD class="label" width="35%" nowrap ><label style="cursor:pointer;color:blue;font-size:9" onclick='doSwap()'> <fmt:message key="Common.Copy.label" bundle="${common_labels}"/></label></TD> 
				</TR>
				<TR>
					<TD class="label" width="20%" ><fmt:message key="ePH.ContactAddress.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_ADDR1%>" name="line1" <%=dis%> ></TD>
					<TD class="label" width="15%"  nowrap >&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.ReplyAddress.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD  class="label" width="35%" align='center'><input type="text" maxlength="40" size="40"  value="<%=REPLY_ADDR1%>" <%=dis%>  name="rep_line1" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" >&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_ADDR2%>"  <%=dis%> name="line2" ></TD>
					<TD class="label" width="15%" > &nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=REPLY_ADDR2%>" <%=dis%> name="rep_line2" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" >&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_ADDR3%>" <%=dis%> name="line3" ></TD>
					<TD class="label" width="15%" align='center'>&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=REPLY_ADDR3%>" <%=dis%> name="rep_line3" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" >&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_ADDR4%>" <%=dis%> name="line4" ></TD>
					<TD class="label" width="15%" align='center'>&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=REPLY_ADDR4%>" <%=dis%> name="rep_line4" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" ><fmt:message key="ePH.Telnumber.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%"  ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_TEL%>" <%=dis%> name="tel_num" ></TD>
					<TD class="label" width="15%" ><fmt:message key="ePH.Telnumber.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%" ><input type="text" maxlength="40" size="40"  value="<%=REPLY_TEL%>" <%=dis%> name="rep_tel_num" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" ><fmt:message key="ePH.Facsimile.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%"  ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_FAX%>" <%=dis%> name="fac_num" ></TD>
					<TD class="label" width="15%"  ><fmt:message key="ePH.Facsimile.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%"  ><input type="text" maxlength="40" size="40"  value="<%=REPLY_FAX%>" <%=dis%> name="rep_fac_num" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" ><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%"  ><input type="text" maxlength="40" size="40"  value="<%=CONTACT_EMAIL%>" <%=dis%> name="email" ></TD>
					<TD class="label" width="15%"  ><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;</TD>
					<TD class="label" width="35%"  ><input type="text" maxlength="40" size="40"  value="<%=REPLY_EMAIL%>" <%=dis%> name="rep_email" ></TD>
				</TR>
				<TR>
					<TD class="label" width="20%" >&nbsp;</TD>
					<TD class="label" width="35%" ></TD>
					<TD class="label" width="15%" >&nbsp;</TD>
					<TD class="label" width="35%" ></TD>
				</TR>
				<TR>
					<TD colspan='4' class='label'>&nbsp;</TD>
				</TR>
			</TABLE>
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%=mode%>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
			<INPUT TYPE="hidden" name="sql1" id="sql1" VALUE="<%=SQL_PH_AM_PRACTITIONER_SELECT%>">
			<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%=logged_fcy%>">
			<INPUT TYPE="hidden" name="logged_fc_name" id="logged_fc_name" VALUE="<%=facility_name%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="display1" id="display1" VALUE="Y">
			<INPUT TYPE="hidden" name="Enquiry_Num" id="Enquiry_Num" VALUE="<%=Enq_num%>">
			<INPUT TYPE="hidden" name="Verified_by" id="Verified_by" VALUE="<%=verified_by%>">
			<INPUT TYPE="hidden" name="Confidential_YN" id="Confidential_YN" VALUE="<%=Confidential_YN%>">
			<INPUT TYPE="hidden" name="Logged_in_fc" id="Logged_in_fc" VALUE="<%=logged_fcy1%>">
			<INPUT TYPE="hidden" name="LoggedF" id="LoggedF" VALUE="<%=logged_facility_name%>"><!-- code 'facility_name1' replaced by facility_name for IN:048274 -->
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="login_user" id="login_user" VALUE="<%=login_user%>"><!---->
			<INPUT TYPE="hidden" name="appl_user_name" id="appl_user_name" VALUE="<%=appl_user_name%>">
			<INPUT TYPE="hidden" name="login_pract_id" id="login_pract_id" VALUE="<%=login_pract_id%>"><!--code added for IN:049077-->
			<INPUT TYPE="hidden" name="login_pract_name" id="login_pract_name" VALUE="<%=login_pract_name%>"><!--code added for IN:049077-->
			<INPUT TYPE="hidden" name="homepage" id="homepage" VALUE="<%=homepage%>">
		</form>
		<script>
			if(document.forms[0].Enquiry_Num.value !="" && document.forms[0].Enquiry_Num.value !=null){
				if(document.forms[0].Pract_id.value !="")
					document.getElementById("id5").style.display='inline';
				if(document.forms[0].Logged_in_fc.value==document.forms[0].src.value){
					document.forms[0].Source.selectedIndex=0
					document.getElementById("id5").style.display='none';
					document.forms[0].other_pract.value='';
				}
				else if(document.forms[0].src.value=='*P'){
					document.forms[0].Source.selectedIndex=3;
					//document.forms[0].Pract_name.value=''; commented for HSA-CRF-0158 [IN:048491]
					document.getElementById("fc").style.display='none';
					document.getElementById("id4").style.display='none';
					document.getElementById("ff").style.display='none';
					document.getElementById("id1").style.display='none';
					//document.getElementById("pn").style.display='inline';commented for HSA-CRF-0158 [IN:048491]
					document.forms[0].Pract_name_btn.disabled=true;
					if(document.forms[0].request_mode.value!='S'){ //Added for HSA-CRF-0158 [IN:048491] -start
						document.forms[0].Pract_name.value='';
						document.getElementById("id5").style.display='inline';
						document.getElementById("pn").style.display='inline';
					}
					else
						document.getElementById("id5").style.display='none'; //Added for HSA-CRF-0158 [IN:048491] -end
					//document.getElementById("id5").style.display='inline'; commented for HSA-CRF-0158 [IN:048491]
					document.forms[0].Designation.disabled=false;
				}
				else if(document.forms[0].src.value=='*F'){
					document.forms[0].Source.selectedIndex=1;
					if(document.forms[0].request_mode.value!='S'){ //Added for HSA-CRF-0158 [IN:048491] -start
						document.forms[0].Pract_name.value='';
						document.getElementById("id5").style.display='inline';
					}
					else
						document.getElementById("id5").style.display='none'; //Added for HSA-CRF-0158 [IN:048491] -end
					//document.getElementById("id5").style.display='inline'; commented for HSA-CRF-0158 [IN:048491]
					document.getElementById("id1").style.display='none';
					document.getElementById("facility_name").disabled=false;
					document.forms[0].Pract_name_btn.disabled=true;
					document.forms[0].Designation.disabled=false;
					document.getElementById("mando").style.display="inline";
				}
				else{
					document.forms[0].Source.selectedIndex=2
					document.getElementById("id4").style.display='none';
					document.getElementById("id5").style.display='none';
					document.getElementById("fc").style.display='inline';
					var ee =document.forms[0].other_source.options.length;
					var tt=document.forms[0].other_source;
					for(var i=0;i<ee;i++){
						if(tt.options(i).value==document.forms[0].src.value){
							document.forms[0].other_source.selectedIndex=i;
						}
					}
				}
				if(document.forms[0].priority.value!=''){
					document.getElementById("id6").style.display='none';
					document.getElementById("id2").style.display='none';
				}
				if(document.forms[0].request_mode.value!=''){
					document.getElementById("id7").style.display='none';
					document.getElementById("id3").style.display='none';
				}
			}
		</script>
	</body>
	<% putObjectInBean(bean_id,bean,request); 
} // Added for MOHE-CRF-0074 - start
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>  <!--  Added for MOHE-CRF-0074 - End -->
</html>

