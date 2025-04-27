<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRPhFillListbyNursingUnit.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRPhFillListbyNursingUnitResult" id="SRRPhFillListbyNursingUnitResult">

<%
   try{
    String bean_id				= "SRROnlineReportSet2Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet2Bean";
	SRROnlineReportSet2Bean bean		= (SRROnlineReportSet2Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
    String p_disp_facility_id = CommonBean.checkForNull(request.getParameter("p_disp_facility_id"));
    String p_fill_proc_ty = CommonBean.checkForNull(request.getParameter("p_fill_proc_ty"));
    String p_fill_proc_fr_dt = CommonBean.checkForNull(request.getParameter("p_fill_proc_fr_dt"));
    String p_fill_proc_to_dt = CommonBean.checkForNull(request.getParameter("p_fill_proc_to_dt"));
    String p_select = CommonBean.checkForNull(request.getParameter("p_select"));
    String p_fr_nurs_unit = CommonBean.checkForNull(request.getParameter("p_fr_nurs_unit"));
    String p_to_nurs_unit = CommonBean.checkForNull(request.getParameter("p_to_nurs_unit"));
    String p_build = CommonBean.checkForNull(request.getParameter("p_build"));
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	
	ArrayList result =new ArrayList();
	
	
	result=bean.getFillListByNursingList( p_disp_facility_id,p_fill_proc_ty,p_fill_proc_fr_dt,p_fill_proc_to_dt,p_select, p_fr_nurs_unit,p_to_nurs_unit,p_facility_id,p_build,from,to);
		
		int count =0;

		

	if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){ %>

		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;

		<%
		// For display the previous/next link
		out.println(result.get(0));
	%>
		</td></tr>
		</table>
		<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1" id="reprint_rep">
				<tr>
			<th  nowrap><fmt:message key="ePH.FillProcessDate.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.FillID.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.ProcessType.label" bundle="${common_labels}"/></th>
			</tr>
<%
		
		for (int i=0;i<result.size()-5;i=i+5){					
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
		
					
	%>
		<tr>
		<!-- Date Conversion done for the incident num:25069 on 1/Dec/2010==By Sandhya -->
			<td class="<%=classvalue%>" style="font-size=9"><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+4),"DMYHM","en",locale)%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=result.get(i+1)%>','<%=result.get(i+2)%>','<%=result.get(i+4)%>','<%=result.get(i+3)%>','<%=locale%>')"><%=result.get(i+2)%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=result.get(i+1)%>','<%=result.get(i+2)%>','<%=result.get(i+4)%>','<%=result.get(i+3)%>','<%=locale%>')"><%=result.get(i+5)%></td>
		<%	if(result.get(i+3).equals("R")){
		%>             <td class="<%=classvalue%>" style="font-size=9"><fmt:message key="ePH.ROUTINE.label" bundle="${ph_labels}"/></td>
                         
		<%			}else{
		%>			
		                <td class="<%=classvalue%>" style="font-size=9"><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></td>
						
		<%	}%>
			
			
		</tr>
		
	<%
			count =count+1;
		}
	}else{
	%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[2].location.href = "../../eCommon/html/blank.html";
				</script>
	<%
	}%>
		</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="p_disp_facility_id" id="p_disp_facility_id" value="">
	<input type="hidden" name="p_select" id="p_select" value="">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="">
	<input type="hidden" name="p_fr_nurs_unit" id="p_fr_nurs_unit" value="">
	<input type="hidden" name="p_to_nurs_unit" id="p_to_nurs_unit" value="">
	<input type="hidden" name="p_fill_proc_fr_dt" id="p_fill_proc_fr_dt" value="">
	<input type="hidden" name="p_fill_proc_to_dt" id="p_fill_proc_to_dt" value="">
	<input type="hidden" name="p_build" id="p_build" value="">
	<input type="hidden" name="p_fill_proc_ty" id="p_fill_proc_ty" value="">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	
	<% putObjectInBean(bean_id,bean,request); %>


<%
	
		
 }catch (Exception exception) {
		
		exception.printStackTrace();
	}
	finally{
	}
%>
</form>
</body>
</html>

