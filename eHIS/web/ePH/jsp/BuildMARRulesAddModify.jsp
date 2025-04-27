<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
	<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

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
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
    <script language="JavaScript" src="../../ePH/js/BuildMARRules.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
     /* Mandatory checks start */
    String mode			= request.getParameter("mode");
    String bean_id		= "BuildMARRules" ;
    String bean_name	= "ePH.BuildMARRules";

	if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    BuildMARRules bean = (BuildMARRules)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
    bean.clear() ;
    bean.setMode( mode ) ;
	HashMap intialValues = new HashMap();
	ArrayList APP_PAT_CLASSES		= new ArrayList();
	ArrayList APP_PAT_CLASSES_DESC  = new ArrayList();
	
	String facility_id  =   (String)session.getValue("facility_id");   
	
	if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
		intialValues = (HashMap) bean.loadIntialValues(facility_id);
	}

	if(intialValues != null && intialValues.size()>0){
		APP_PAT_CLASSES			= (ArrayList) intialValues.get("APP_PAT_CLASSES");
		APP_PAT_CLASSES_DESC	= (ArrayList) intialValues.get("APP_PAT_CLASSES_DESC");
	}
	%>

<form name="MAR_defaulting" >
	<%
	   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ))
	   {
			String pat_class_desc	= request.getParameter("APP_PAT_CLASSES");
			String location_code	= request.getParameter("LOCATION_CODE");
			String priority_desc	= request.getParameter("PRIORITY");
			String form_code		= request.getParameter("FORM_CODE");
			String mar_defaulting	= request.getParameter("MAR_DEFAULTING");
			String mar_defaulting_code	= request.getParameter("MAR_DEFAULTING_CODE");
			String location_desc	= request.getParameter("LOCATION_DESC");
			String form_desc		= request.getParameter("FORM_DESC");
			String pat_class		= "";
			String priority			= "";
			String sel="",ce_sel="",ue_sel="",cd_sel="",ud_sel="";
			// To load the value in modify mode.
			
			if(mar_defaulting.equals(MessageManager.getLabel(locale,"ePH.Checked.label","PH")))
				ce_sel="SELECTED";
			else if(mar_defaulting.equals(MessageManager.getLabel(locale,"ePH.UnChecked.label","PH")))
				ue_sel="SELECTED";
			else if(mar_defaulting.equals(MessageManager.getLabel(locale,"ePH.CheckedDisabled.label","PH")))
				cd_sel="SELECTED";
			else if(mar_defaulting.equals(MessageManager.getLabel(locale,"ePH.UnCheckedDisabled.label","PH")))
				ud_sel="SELECTED";
			else
				sel="SELECTED";
					
			if(pat_class_desc.trim().equals(MessageManager.getLabel(locale,"Common.inpatient.label","Common"))){
				pat_class="IP";
			}
			else if(pat_class_desc.trim().equals(MessageManager.getLabel(locale,"Common.Outpatient.label","Common"))){
				pat_class="OP";
			}
			else if(pat_class_desc.trim().equals(MessageManager.getLabel(locale,"Common.daycare.label","Common"))){
				pat_class="DC";
			}
			else if(pat_class_desc.trim().equals(MessageManager.getLabel(locale,"Common.emergency.label","Common"))){
				pat_class=	"EM";
			}
			else if(pat_class_desc.trim().equals(MessageManager.getLabel(locale,"Common.DischargeMedication.label","Common")))			{
				pat_class			=	"DM";
			}
				
			if(priority_desc.equals(MessageManager.getLabel(locale,"Common.all.label","Common")))
				priority="A";
			else if(priority_desc.equals(MessageManager.getLabel(locale,"Common.routine.label","Common")))
				priority="R";
			else if(priority_desc.equals(MessageManager.getLabel(locale,"Common.urgent.label","Common")))
				priority="U";
				
	%>

<br><br><br><br><br><br><br>

<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
		<tr>
		   <td class="label" width="35%" ><fmt:message key="Common.ApplicablePatientClass.label" bundle="${common_labels}"/></td>
		   <td>&nbsp;&nbsp;<input type="text" value="<%=pat_class_desc%>" name="APP_PAT_CLASSES" disabled size="30">
				<input type="hidden" value="<%=pat_class%>" name="APP_PAT_CLASSES_CODE" disabled size="30">
		   </td>
        </tr>
		<tr><td> <br> </td></tr>
	 	<tr>
			<td  class="label" width="35%" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" value="<%=location_desc%>" name="LOCATION" disabled size="30">
				<input type="hidden" value="<%=location_code%>" name="LOCATION_CODE" disabled size="30">
			</td>
		</tr>
		<tr><td> <br> </td></tr>
		<tr>
			<td  class="label" width="35%" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" value="<%=priority_desc%>" name="PRIORITY" disabled size="30">
				<input type="hidden" value="<%=priority%>" name="PRIORITY_CODE" disabled size="30">
			</td>
		</tr>
		<tr><td> <br> </td></tr>
		<tr>
			<td  class="label" width="35%" ><fmt:message key="Common.Form.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" value="<%=form_desc%>" name="FORM" disabled size="30">
				<input type="hidden" value="<%=form_code%>" name="FORM_CODE" disabled size="30">
			</td>
		</tr>
		<tr><td> <br> </td></tr>
		<tr>
			<td class="label" width="35%" ><fmt:message key="ePH.MARDefaulting.label" bundle="${ph_labels}"/></td>
			<td>&nbsp;
				<select name="MAR_DEFAULTING" >
		              <option <%=sel%> value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					  <option <%=ce_sel%> value="CE" ><fmt:message key="ePH.Checked.label" bundle="${ph_labels}"/></option>
					  <option <%=ue_sel%> value="UE"><fmt:message key="ePH.UnChecked.label" bundle="${ph_labels}"/></option>
					  <option <%=cd_sel%> value="CD"><fmt:message key="ePH.CheckedDisabled.label" bundle="${ph_labels}"/></option>
					  <option <%=ud_sel%> value="UD"><fmt:message key="ePH.UnCheckedDisabled.label" bundle="${ph_labels}"/></option>
		        </select>&nbsp;  <img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
			</td>
		</tr>
		
</table>
	
	<%
					   }
					if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
					   %>	
<br><br><br><br><br><br><br>

<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
    <tr>
		<td class="label" colspan="2">&nbsp;</td>
	</tr>
    <tr>
		<td class="label" width="35%"><fmt:message key="Common.ApplicablePatientClass.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;
				<select name="APP_PAT_CLASSES" onChange="loadLocation(this)" >
		              <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
							for(int i=0;APP_PAT_CLASSES.size()>i;i++)
							{
						%>
							<option value="<%=APP_PAT_CLASSES.get(i)%>"> <%=APP_PAT_CLASSES_DESC.get(i)%></option>
						<%
							}
													
						%>
		        </select>&nbsp;  <img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				
		</td>
		
    </tr>
	<tr><td> <br> </td></tr>
	<tr>
		<td class="label" width="35%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;
				<select name="LOCATION" onChange="loadForm(this)" >
	              <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		        </select>&nbsp;  <img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				
		</td>
    </tr>
	<tr><td> <br> </td></tr>
	<tr>
		<td class="label" width="35%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;
				<select name="PRIORITY" >
					  <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		              <option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					  <option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
					  <option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
				</select>&nbsp;  <img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				
		</td>
    </tr>
	<tr><td> <br> </td></tr>
	<tr>
		<td class="label" width="35%" ><fmt:message key="Common.Form.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;
				<select name="FORM" >
		              <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		        </select>&nbsp;  <img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				
		</td>
    </tr>
	<tr><td> <br> </td></tr>
	<tr>
		<td class="label" width="35%" ><fmt:message key="ePH.MARDefaulting.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;
				<select name="MAR_DEFAULTING" >
		              <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					  <option value="CE"><fmt:message key="ePH.Checked.label" bundle="${ph_labels}"/></option>
					  <option value="UE"><fmt:message key="ePH.UnChecked.label" bundle="${ph_labels}"/></option>
					  <option value="CD"><fmt:message key="ePH.CheckedDisabled.label" bundle="${ph_labels}"/></option>
					  <option value="UD"><fmt:message key="ePH.UnCheckedDisabled.label" bundle="${ph_labels}"/></option>
		        </select>&nbsp;  <img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
		</td>
    </tr>
	
   <tr><td class="label" colspan="2">&nbsp;</td></tr>
   </table>
	<%
	    }
	%>

	<input type="hidden" name="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="mode" value="<%=mode%>">
	<input type="hidden" name="FACILITY_ID" value="<%=facility_id%>">

</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>
