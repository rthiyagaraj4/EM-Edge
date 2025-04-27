<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

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
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DrugAbuse.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<body onMouseDown="" onKeyDown="lockKey()">

<%
    /* Mandatory checks start */
    String mode				= request.getParameter( "mode" ) ;
    String bean_id			= "DrugAbuseBean" ;
    String bean_name		= "ePH.DrugAbuseBean";
    String readOnly			= "" ;
	String disabled			= "";

    String checked			= "checked";

    if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    DrugAbuseBean bean = (DrugAbuseBean)getBeanObject( bean_id,bean_name,request) ;
    bean.clear() ;
    bean.setMode( mode ) ;

	bean.setLanguageId(locale);
 
	String patient_id				= bean.checkForNull(request.getParameter("p_patient_id"));
	String restriction_type			= bean.checkForNull(request.getParameter("p_restriction_type"));
	String drug_class_or_drug_code	= bean.checkForNull(request.getParameter("p_drug_class_or_drug_code"));

System.err.println("p_patient_id"+patient_id+"==p_restriction_type"+restriction_type+"===p_drug_class_or_drug_code"+drug_class_or_drug_code);

	String p_name					= "";

 %>

<form name="formDrugAbuse" id="formDrugAbuse" onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
<%
	if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) {
		readOnly				= "";
		disabled				= "";
		patient_id				= "";
		p_name					= "";
		restriction_type		= "DC"; // Default in the insert mode with Drug Class
		drug_class_or_drug_code = "";
		bean.setActionType("B"); // to default as Block for Action type

	} else if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {

		bean.loadData(patient_id, restriction_type, drug_class_or_drug_code);

		readOnly ="readOnly";
		disabled ="DISABLED";
		if(patient_id!=null && !patient_id.equalsIgnoreCase("")) {
			ArrayList patientdetails	= bean.getPatientDetails(patient_id);
			if(patientdetails.size()!=0){
					p_name=(String)patientdetails.get(0);
					//p_name=p_name.replaceAll(" ","%20");
					//p_name = java.net.URLEncoder.encode(p_name,"UTF-8");
				//	p_name=p_name.replaceAll("%2520","%20");
			}
		}
	}
%>

<BR><BR><BR><BR><BR>

<table cellpadding=0 cellspacing=0 border=1 width='90%'  align='center'>

	<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TR>
			<td class="label" width="20%" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width="20%"><input type="text" name="p_patient_id" id="p_patient_id" size="20" value="<%=patient_id%>" maxlength="<%=bean.getPatientIDLength()%>"  onChange="getPatientDetails(document.formDrugAbuse);" <%=readOnly%> > 
			<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch(document.formDrugAbuse)" <%=disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
			<td class="label" colspan='3'>Patient Name&nbsp;&nbsp;<input type="text" name="p_patient_name" id="p_patient_name" size="60" value="<%=p_name%>" maxlength="60"  id="patient_detail" readOnly></td>
		</tr>
		<TR>
			<TD COLSPAN="5">&nbsp;</TD>
		</TR>
 
		<TR>
			<td class="label" width="20%"><fmt:message key="ePH.RestrictionType.label" bundle="${ph_labels}"/></td>
			<td ALIGN="left" width="20%" >
				<select name="p_restriction_type" id="p_restriction_type" onChange="restrictionType(this);"  <%=disabled%>>
					<%if(restriction_type.equalsIgnoreCase("DC")) { %>
						<option value="DC" selected><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
						<option value="DN" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
					<%} else if(restriction_type.equalsIgnoreCase("DN")) { %> 
						<option value="DC" ><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
						<option value="DN" selected><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
					<%} %>
				</select>
			</td>
				<TD COLSPAN="3">&nbsp;</TD>
		</tr>			
		<TR>
			<TD COLSPAN="5">&nbsp;</TD>
		</TR>
		<TH COLSPAN="5" ALIGN="left"><fmt:message key="ePH.RestrictionDetails.label" bundle="${ph_labels}"/></TH>	
		<TR>
			<TD COLSPAN="5">&nbsp;</TD>
		</TR>
<%
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) {
%>
		<TR id='drug_class' style="display:inline" >
			<td class="label" ALIGN="right" nowrap><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>
			</td>
			<td ALIGN="left" ><select name="p_drug_class" id="p_drug_class" id='drug_class_dtl' style='display:inline' >
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G" ><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			&nbsp;<img src="../../eCommon/images/mandatory.gif" id='drug_class_id' style="display:inline" align=center></img>
			</td>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>


		<TR id='drug_name_id' style="visibility:hidden">
			<td class="label" ALIGN="right"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/> </td>
		 	<td ALIGN="left" ><input type='text'  name='drug_name' id='drug_name' size="40" maxlength="60" onBlur="searchDrug1(document.formDrugAbuse.drug_name)" value=""  >
		 	</td> 	
			<td><input valign='top' type='button' name='drug_search' id='drug_search' id='drug_search_id' value='?' class='button' 
			 onClick="searchDrug1(document.formDrugAbuse.drug_name)"  style="visibility:hidden">
			<img src="../../eCommon/images/mandatory.gif" id='drug_image_id' style="visibility:hidden"></td>
 		 <input type="hidden" name="drug_code" id="drug_code" value="">
 			
 		</TR>
 		
 		

<%		} else { %>
			<TR>
				<td class="label" ALIGN="right" nowrap>
			<% if(restriction_type.equalsIgnoreCase("DC")) { %>
					<fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>
			<% } else if(restriction_type.equalsIgnoreCase("DN")) { %>
					<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
			<% }   %>
				</td>
				<td ALIGN="left" >
					<input type="text"  name="drug_class_name" id="drug_class_name" size="40" maxlength="60" value="<%=bean.getDrugClassDesc()%>" <%=readOnly%>  >
					<input type="hidden" name="p_drug_class_drug_code" id="p_drug_class_drug_code" value ="<%=drug_class_or_drug_code%>">

				</td>
				<TD COLSPAN="3">&nbsp;</TD>
			</TR>
<% }  %>
		<TR>
			<TD COLSPAN="5">&nbsp;</TD>
		</TR>
		<TR>
			<td class="label" width="20%"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			<td width="20%" align='left'><select name="p_action_type" id="p_action_type" onchange="changeActionType()">
			<% if(bean.getActionType().equalsIgnoreCase("B")) { %>
					<option value="B" selected><fmt:message key="Common.block.label" bundle="${common_labels}"/></option>
					<option value="U"><fmt:message key="ePH.Unblock.label" bundle="${ph_labels}"/></option>
			<% } else { %>
					<option value="B" ><fmt:message key="Common.block.label" bundle="${common_labels}"/></option>
					<option value="U" selected><fmt:message key="ePH.Unblock.label" bundle="${ph_labels}"/></option>
			<% } %>
				</select>
			</td>
			<td>&nbsp;</td>
			<td class="label" width="20%" ALIGN="right">&nbsp;<fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/></td>		
			<% if(bean.getActionType().equalsIgnoreCase("B")) {
				%>
			<td width="10%" align='left'><input type="checkbox" value="N" name="p_restrict_transaction_yn" id="p_restrict_transaction_yn" <%=bean.getChecked(bean.getRestrictTransactionYn())%> onClick="enableAutoRequest(this)" ></td>
		<%}else{ %>
		<td width="10%" align='left'><input type="checkbox" value="N" name="p_restrict_transaction_yn" id="p_restrict_transaction_yn" <%=bean.getChecked(bean.getRestrictTransactionYn())%> onClick="enableAutoRequest(this)" disabled> </td>
		<%} %>
		</TR>
		<TR>
			<TD COLSPAN="5">&nbsp;</TD>
		</TR>
		<TR>
			<td class="label" width="20%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td align='left' colspan='4'><textarea rows="2" cols="75" maxLength="100"  size="100"   name="p_remarks" onKeyPress="return AllowFormat(); return checkMaxLimit(this,100);"  onblur="checkMaxLength(this);" ><%=bean.getRemarks()%></textarea>
		</tr>

	</TABLE>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=session.getValue( "facility_id" )%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	 
	<input type="hidden" name="p_drug_code" id="p_drug_code" value="<%=drug_class_or_drug_code%>">

 
  </table>
<%
//}
 
%>




    <INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
    <INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
    <INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
 </form>

 <% putObjectInBean(bean_id,bean,request); %>
</body>

</html>

