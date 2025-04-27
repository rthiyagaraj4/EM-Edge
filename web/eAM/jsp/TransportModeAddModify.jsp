<!DOCTYPE html>
<!--
	Developed by 	:	Gomathi Shankar
	Created on 		:	13/02/2002
	Module				:	AM - TransportMode
	Function			:	This function is used call from the main menu.
-->


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%><%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String operation="";
	String sql_defeciency="", modify_prop="", checked_prop="checked", mandatory_prop="";
	
	
String transport_mode="";
String long_desc="";
String short_desc="";
String eff_status="";
String by_person_yn="";
String patient_related_yn="";
String checked_patient_related_yn="";

String file_related_yn="";
String checked_file_related_yn="";

String specimen_related_yn="";
String checked_specimen_related_yn="";

String checked_by_person_yn="";
String modify_by_person="";

/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
String tfr_pat_out_yn = "";
String chkd_tfr_pat_out_yn = "";
Boolean isCnrmReqPatOutChngAppl = false;
/*End*/

//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
Boolean isMedRepModeAppl = false;
String application_mode = "";
String checked_appl_mode_yn = "";
String collection_mode = "";
String checked_collectn_mode_yn = "";
String notification_mode = "";
String checked_notif_mode_yn = "";

	request.setCharacterEncoding("UTF-8");	
	Connection con	=	null;
	con		=	ConnectionManager.getConnection(request);
	Statement stmt	=	null;
	ResultSet rs	=	null;
	try
	{
		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on th May 2017 for ML-MMOH-CRF-0617

		isMedRepModeAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHCKLST_TRANS_MODE_MED_REPORT"); //Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
		
		stmt	=	con.createStatement();		

		
		operation=request.getParameter("operation");
	
		if(operation==null || operation.equals("null")) operation="insert";
         
		transport_mode	= request.getParameter("transport_mode");
		if(transport_mode==null || transport_mode.equals("null")) transport_mode="";

	
		if(operation.equals("modify"))
		{
			
			if(transport_mode==null || transport_mode.equals("null")) 
				transport_mode="";
			if(!(transport_mode.equals("")))
			{
				sql_defeciency	=	"select long_desc, short_desc, patient_related_yn,file_related_yn,specimen_related_yn,by_person_yn,ip_tfr_pat_out_yn,application_mode,collection_mode,notification_mode,eff_status from am_transport_mode where transport_mode='"+transport_mode+"'";
				rs=stmt.executeQuery(sql_defeciency);
				if(rs !=null)
				{
					if(rs.next())
					{
						long_desc	= rs.getString("long_desc");
						short_desc	= rs.getString("short_desc");
						by_person_yn= rs.getString("by_person_yn");
						patient_related_yn=rs.getString("patient_related_yn");
						tfr_pat_out_yn = rs.getString("ip_tfr_pat_out_yn");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
					    file_related_yn=rs.getString("file_related_yn"); specimen_related_yn=rs.getString("specimen_related_yn");
						eff_status	= rs.getString("eff_status");

						//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
						application_mode = rs.getString("application_mode");
						collection_mode = rs.getString("collection_mode");
						notification_mode = rs.getString("notification_mode");
					}

					if(long_desc == null || long_desc.equals("null")) long_desc="";
					if(short_desc == null || short_desc.equals("null")) short_desc="";
					if(by_person_yn == null || by_person_yn.equals("null")) by_person_yn="";
					if(tfr_pat_out_yn == null || tfr_pat_out_yn.equals("null")) tfr_pat_out_yn="N";//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
					if(patient_related_yn == null || patient_related_yn.equals("null")) patient_related_yn="";
					if(file_related_yn == null || file_related_yn.equals("null")) file_related_yn="";
					if(specimen_related_yn == null || specimen_related_yn.equals("null")) specimen_related_yn="";
					if(eff_status == null || eff_status.equals("null")) eff_status="D";

					//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
					if(application_mode == null || application_mode.equals("null")) application_mode="N";
					if(collection_mode == null || collection_mode.equals("null")) collection_mode="N";
					if(notification_mode == null || notification_mode.equals("null")) notification_mode="N";
				}
				
				if(eff_status.equals("E"))
				{
					checked_prop="checked";
					modify_prop="";
					modify_by_person="";
					mandatory_prop="readOnly";
				}
				else if(eff_status.equals("D"))
				{
					checked_prop="";
					modify_prop="readOnly";
					modify_by_person="disabled";
					mandatory_prop="readOnly";
				}
				
				if(by_person_yn.equals("Y"))
				{
					checked_by_person_yn="checked";
					//mandatory_by_person_yn="readOnly";
				}
				else if(by_person_yn.equals("N"))
				{
					checked_by_person_yn="";
				//	mandatory_prop="readOnly";
				}
				
				/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
				if(tfr_pat_out_yn.equals("Y"))
				{
					chkd_tfr_pat_out_yn="checked";
				}
				else if(tfr_pat_out_yn.equals("N"))
				{
					chkd_tfr_pat_out_yn="";
				}
				/*End*/

				if(patient_related_yn.equals("Y"))
				{
					checked_patient_related_yn="checked";
					//mandatory_by_person_yn="readOnly";
				}
				else if(patient_related_yn.equals("N"))
				{
					checked_patient_related_yn="";
				//	mandatory_prop="readOnly";
				}
				if(file_related_yn.equals("Y"))
				{
					checked_file_related_yn="checked";
					//mandatory_by_person_yn="readOnly";
				}
				else if(file_related_yn.equals("N"))
				{
					checked_file_related_yn="";
				//	mandatory_prop="readOnly";
				}
				if(specimen_related_yn.equals("Y"))
				{
					checked_specimen_related_yn="checked";
					//mandatory_by_person_yn="readOnly";
				}
				else if(specimen_related_yn.equals("N"))
				{
					checked_specimen_related_yn="";
				//	mandatory_prop="readOnly";
				}
				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
				if(application_mode.equals("Y"))
				{
					checked_appl_mode_yn="checked";
				}
				else if(application_mode.equals("N"))
				{
					checked_appl_mode_yn="";
				}
				if(collection_mode.equals("Y"))
				{
					checked_collectn_mode_yn="checked";
				}
				else if(collection_mode.equals("N"))
				{
					checked_collectn_mode_yn="";
				}
				if(notification_mode.equals("Y"))
				{
					checked_notif_mode_yn="checked";
				}
				else if(notification_mode.equals("N"))
				{
					checked_notif_mode_yn="";
				}
				/*ML-MMOH-CRF-0708 End*/
			}
		}
				if(rs!=null)	rs.close();
				if(stmt!=null) stmt.close();
		
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		
		ConnectionManager.returnConnection(con);
	}
	%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="javascript" src="../js/TransportMode.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</head>
<!--Onload and Onclick Modified By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
<body ONLoad='javascript:document.forms[0].transport_mode.focus(); <%if(isMedRepModeAppl){%> disableMedRepCheckbox(); disableCheckbox(); <%}%>' onKeyDown = 'lockKey()' OnMouseDown="CodeArrest();">
<form name="TransportModeForm" id="TransportModeForm" action="../../servlet/eAM.TransportModeServlet" method="post" target="messageFrame">
<BR><BR><BR>
<table border="0" cellpadding="0" cellspacing="0" align='center' width='80%'>
<center>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;<input type='text' name='transport_mode' id='transport_mode' size='10' maxlength='10'  value='<%=transport_mode%>' <%=mandatory_prop%> onKeyPress='return CheckForSpecChars(event);' onBlur='ChangeUpperCase(this);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' <%=modify_prop%> onBlur="makeValidString(this);" value="<%=long_desc%>">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' <%=modify_prop%> onBlur="makeValidString(this);" value="<%=short_desc%>">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="eAM.PatientRelated.label" bundle="${am_labels}"/></td><td class='fields'>&nbsp;<input type='checkbox' name='patient_related_yn' id='patient_related_yn' onclick = "disableCheckbox();" value='Y'  <%=checked_patient_related_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="eAM.FileRelated.label" bundle="${am_labels}"/></td><td class='fields'>&nbsp;<input type='checkbox' name='file_related_yn' id='file_related_yn' onclick = "disableCheckbox();" value='Y'  <%=checked_file_related_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td class='label'><fmt:message key="eAM.SpecimenRelated.label" bundle="${am_labels}"/></td><td class='fields'>&nbsp;<input type='checkbox' name='specimen_related_yn' id='specimen_related_yn' onclick = "disableCheckbox();" value='Y'  <%=checked_specimen_related_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="eAM.ByPerson.label" bundle="${am_labels}"/></td><td class='fields'>&nbsp;<input type='checkbox' name='by_person_yn' id='by_person_yn' onclick = "disableCheckbox();" value='Y'  <%=checked_by_person_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<!--Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start-->
<% if(isCnrmReqPatOutChngAppl){ %>
<tr>
	<td  class='label'><fmt:message key="eAM.TfrPatientOut.label" bundle="${am_labels}"/></td><td class='fields'>&nbsp;<input type='checkbox' name='tfr_pat_out_yn' id='tfr_pat_out_yn' onclick = "disableCheckbox();" value='Y'  <%=chkd_tfr_pat_out_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<% } %>
<!--End-->

<!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
<%if(isMedRepModeAppl){%>
<th><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></th>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="Common.ApplicationMode.label" bundle="${common_labels}"/> </td><td class='fields'>&nbsp;<input type='checkbox' name='application_mode' id='application_mode' onclick = "disableMedRepCheckbox();" value='Y'  <%=checked_appl_mode_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="Common.CollectionMode.label" bundle="${common_labels}"/> </td><td class='fields'>&nbsp;<input type='checkbox' name='collection_mode' id='collection_mode' onclick = "disableMedRepCheckbox();" value='Y'  <%=checked_collectn_mode_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td  class='label'><fmt:message key="Common.NotificationMode.label" bundle="${common_labels}"/> </td><td class='fields'>&nbsp;<input type='checkbox' name='notification_mode' id='notification_mode' onclick = "disableMedRepCheckbox();" value='Y'  <%=checked_notif_mode_yn%> <%=modify_by_person%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<%}%>

<tr>
	<td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td class='fields'>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E' <%=checked_prop%> ></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>

</center>
</table>
<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
<input type='hidden' name='isCnrmReqPatOutChngAppl' id='isCnrmReqPatOutChngAppl' value='<%=isCnrmReqPatOutChngAppl%>'><!--Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617-->

<input type='hidden' name='isMedRepModeAppl' id='isMedRepModeAppl' value='<%=isMedRepModeAppl%>'><!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->

</form>
</body>
</html>

