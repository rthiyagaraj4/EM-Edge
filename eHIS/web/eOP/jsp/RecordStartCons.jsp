<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head >
        <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eOP/js/StartCons.js' language='javascript'></script>
		<Script src="../../eCommon/js/CommonCalendar.js" language="javascript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%      /*Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start*/
		Connection con				= null;
		JSONObject aeParamJson		= new JSONObject();
		String allowBackdateConsYn	= ""; 
		String allowBackdateConsHrs	= "";
		String aeParamAllowedDate	= "";
		String facilityId			= (String)session.getValue("facility_id");
		String sysDateTime			= "";
		String moduleId			= request.getParameter("moduleId")==null?"":request.getParameter("moduleId");
		/*End*/
		String encounterid=request.getParameter("encounterid");
		String status=request.getParameter("p_status");
		String consdate=request.getParameter("dtime");
		String sysdate=request.getParameter("sdate");
		
		String consdate_display=DateUtils.convertDate(consdate,"DMYHM","en",localeName);
		String sysdate_display=DateUtils.convertDate(sysdate,"DMYHM","en",localeName);
		/*Below line added for this CRF Bru-HIMS-CRF-133*/
		String queue_date=request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");		
	    String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
	    String p_patient_id=request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
		String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		//End Bru-HIMS-CRF-133

/*Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start*/
try
{
	con						= ConnectionManager.getConnection(request);
	aeParamJson				= eAE.AECommonBean.getAEParam(con, facilityId);
	allowBackdateConsYn		= (String)aeParamJson.get("allowBackdateConsYn");
	allowBackdateConsHrs	= (String)aeParamJson.get("allowBackdateConsHrs");
	aeParamAllowedDate		= (String)aeParamJson.get("aeParamAllowedDate");

	sysDateTime				= eCommon.Common.CommonBean.getSystemDateTime(con);
	sysDateTime				= DateUtils.convertDate(sysDateTime,"DMYHM","en",localeName);
/*End*/%>
    </head> 
    <body onKeyDown = 'lockKey();'>
    <form name ="RecordStartCons_form" action='../../servlet/eOP.RecordStartConsSupportServlet' method='post'> 
           <table cellspacing='0' border=0 cellpadding='0'  width='80%'align=center>
 			<tr><td colspan=4></td></tr>
            <tr>
                <td class='label' width='40%'><fmt:message key="eOP.CurrentStatus.label" bundle="${op_labels}"/></td>
                <td  class='querydata' ><b><%=status%></b></td> 
                <td  align='left' width='10%' class='querydata'>/</td>                
                <td  class='querydata'  nowrap><b><%=consdate_display%></b></td>
            </tr>
  		<tr><td colspan=4>&nbsp;</td></tr>
			<!--Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start-->
			<% if(moduleId.equals("AE") && allowBackdateConsYn.equals("Y")){ %>
				<tr>
					<td class='label' width='40%'><fmt:message key="Common.BackDateConsultation.label" bundle="${common_labels}"/></td>
					<td  class='querydata' ><input type='checkbox' name='chkBackDatedCons' id='chkBackDatedCons' onclick='enableDisableConsDate(this)'></td> 
				</tr>
				<tr><td colspan=4>&nbsp;</td></tr>
				<tr>
					<td class='label'><fmt:message key="eOP.StartofConsultation.label" bundle="${op_labels}"/></td>
					<td class='querydata' colspan=3><INPUT TYPE="text"  onBlur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);}" name="start_cons_date_time" id="start_cons_date_time"  value='<%=sysDateTime%>' disabled size=14 maxlength=16 ><img src="../../eCommon/images/CommonCalendar.gif"  id='startConsMandImg' onClick="document.forms[0].start_cons_date_time.select();return showCalendar('start_cons_date_time', null, 'hh:mm');" style="cursor='hand'">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
				</tr>
			<% }else{ %><!--End-->
				<tr>
					<td  class='label'><fmt:message key="eOP.StartofConsultation.label" bundle="${op_labels}"/></td>
					<td  class='querydata' colspan=3><b><%=sysdate_display%></b>&nbsp;</td>
				</tr>
			<% } %>
 		<tr><td colspan=4>&nbsp;</td></tr>
          </table>
	<input type='hidden' value='<%=encounterid%>' name ='encounterid'>
	<input type='hidden' value='update' name ='function'>    
 <!--Below line added for this CRF Bru-HIMS-CRF-133 -->
 <input type='hidden' name='queue_date' id='queue_date' value ='<%=queue_date%>'>  
 <input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value ='<%=isPatientEncMovement%>'>  
 <input type='hidden' name='patientid' id='patientid' value ='<%=p_patient_id%>'>  
 <input type='hidden' name='Sydate' id='Sydate' value ="<%=Sydate%>">
 <!--End Bru-HIMS-CRF-133 -->
<!--Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start-->
<input type='hidden' name='allowBackdateConsYn' id='allowBackdateConsYn' value ="<%=allowBackdateConsYn%>">
<input type='hidden' name='moduleId' id='moduleId' value ="<%=moduleId%>">
<input type='hidden' name='allowBackdateConsHrs' id='allowBackdateConsHrs' value ="<%=allowBackdateConsHrs%>">
<input type='hidden' name='aeParamAllowedDate' id='aeParamAllowedDate' value ="<%=aeParamAllowedDate%>">
<input type='hidden' name='insertBackDatedConsY' id='insertBackDatedConsY' value ="N">
<input type='hidden' name='assignTrmtAreaDateTime' id='assignTrmtAreaDateTime' value ="<%=consdate%>">
<!--End-->
</form>
</body>
<%
}catch(Exception e){ e.printStackTrace();}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>

