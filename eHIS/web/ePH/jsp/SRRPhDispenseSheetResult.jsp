<!DOCTYPE html>
 
 <!--This file is saved on 07/11/2005-->
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
	<script language="javascript" src="../../ePH/js/SRRPhDispenseSheet.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRPhMednListResultForm" id="SRRPhMednListResultForm">

<%
   try{

	String bean_id				= "SRROnlineReportSet1Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet1Bean";
	SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	int count = 0;

	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
   // String locale = request.getParameter("locale");
    String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
    String p_fr_pre = CommonBean.checkForNull(request.getParameter("p_pres_id"));
    String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));

    String p_tokto = CommonBean.checkForNull(request.getParameter("p_tokto"));
    String p_tokfr = CommonBean.checkForNull(request.getParameter("p_tokfr"));

    String locn_type = CommonBean.checkForNull(request.getParameter("p_locn_type"));
    String p_disp_locn_code = CommonBean.checkForNull(request.getParameter("p_disp_locn_code"));

    String fr_dispdate = CommonBean.checkForNull(request.getParameter("fr_dispdate"));
    String to_dispdate = CommonBean.checkForNull(request.getParameter("to_dispdate"));

    String p_locn_code = CommonBean.checkForNull(request.getParameter("p_locn_code"));
    String p_fill_id = CommonBean.checkForNull(request.getParameter("p_fill_id"));

	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));



	  int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		int i = 0;
		int k=0;

         if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt(from) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt(to) ;
			int maxRecord	= 0;

			ArrayList result =null; 

	//DispenseSheetList
			result=bean.DispenseSheetList(patient_id,fr_dispdate,to_dispdate,p_encounter,p_fr_pre,p_tokfr,p_tokto,p_disp_locn_code,locn_type,p_locn_code,p_fill_id,p_facility_id,locale);

	
		 maxRecord = result.size();	

if( (result != null && result.size()>0)){ %>

	<table width='100%'>
		<tr>
		<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
			 <a href='javascript:SubmitLink("<%=(start-query_result_size)%>","<%=(end-query_result_size)%>","<%=(patient_id)%>","<%=(p_fr_pre)%>","<%=(fr_dispdate)%>","<%=to_dispdate%>","<%=(p_encounter)%>","<%=(p_disp_locn_code)%>","<%=(p_tokfr)%>","<%=(p_tokto)%>","<%=locn_type%>","<%=p_locn_code%>","<%=p_fill_id%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>	
	<%
	    }
	    if ( !((start+14) > result.size() )){
	%>
	    <a href='javascript:SubmitLink("<%=(start+query_result_size)%>","<%=(end+query_result_size)%>","<%=(patient_id)%>","<%=(p_fr_pre)%>","<%=(fr_dispdate)%>","<%=to_dispdate%>","<%=(p_encounter)%>","<%=(p_disp_locn_code)%>","<%=(p_tokfr)%>","<%=(p_tokto)%>","<%=locn_type%>","<%=p_locn_code%>","<%=p_fill_id%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    }
	%>
		</td>
		</tr>
		<table>

		
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1" id="reprint_rep">
				<tr>
			<th  nowrap><fmt:message key="ePH.DispensedDate.label" bundle="${st_labels}"/></th>
		<!-- 	<th  nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th> -->
			<th  nowrap><fmt:message key="ePH.TokenNo./DailySeqNo.label" bundle="${ph_labels}"/></th>  
			<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th        ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th  >
			<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/><input type="checkbox" name="selectall_yn" id="selectall_yn" value="N" onClick="return chkall(SRRPhMednListResultForm);" ></th>
				</tr>
				  
 <%


		String []record=new String[10];
		if ( start != 1)
       for( int j=1; j<start; i++,j++ ) {   }
		while(i<end && i<result.size())	{
			record= (String[])result.get(i);
		
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
		record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale);
		
		

		//if(record[1].equals("null")) record[1]="";
		if(record[1]==null || record[1].equals("null")) record[1]	= "&nbsp";
		

		String	prescription_id="";
		String	pre_id="";
		String	index="";

		            prescription_id=record[5];
	                String[] strArr1 = prescription_id.split("#");
					pre_id =strArr1[0];
				    index=strArr1[1];
	
	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9" nowrap><%=record[0]%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap><%=record[1]%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[3]%></td>
			<!-- Added IF -Else Condition for  record[4](patient-name) regarding incident num:25081 on 30/11/2010==By Sandhya-->
			<%if(!(record[4]==null || record[4].trim().equals("")))
			{
			
			%>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[4]%></td>
<%}
			else
			{
				%>
				<td class="<%=classvalue%>" style="font-size=9" nowrap >&nbsp;</td>
				<%
			}
					%>
			<td class="<%=classvalue%>" style="font-size=9"        ><%=pre_id%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[6]%></td>			
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[7]%></td>	
			<td  class="<%=classvalue%>"nowrap>  <input type="checkbox" name="p_print_yn<%=i%>" id="p_print_yn<%=i%>" value="<%=record[9]%>" onClick="assignValue(this);calvalidation(this,'<%=p_facility_id%>','<%=i%>','<%=pre_id%>');" <%if(record[9].equals("Y")){count++;%>checked<%}%>></td>
				<input type="hidden" name="prescription_<%=i%>" id="prescription_<%=i%>" value="<%=pre_id%>">

		</tr>
	<%
				  i++;
		k++;
		}
	}else{
	%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	    parent.f_query_add_mod.document.forms[0].print.disabled=true;
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
				</script>
	<%
	}%>
		</table>


	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=maxRecord%>">



	<input type="hidden" name="from" id="from" value="<%=start%>">
	<input type="hidden" name="to" id="to" value="<%=end%>">

	<input type="hidden" name="patient_id" id="patient_id" value="">

	<input type="hidden" name="p_fr_pre" id="p_fr_pre" value="">

	<input type="hidden" name="fr_dispdate" id="fr_dispdate" value="">
	<input type="hidden" name="to_dispdate" id="to_dispdate" value="">

	<input type="hidden" name="p_encounter" id="p_encounter" value="">

	<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">

	<input type="hidden" name="locn_type" id="locn_type" value="">
	<input type="hidden" name="p_locn_code" id="p_locn_code" value="">

	<input type="hidden" name="p_tokfr" id="p_tokfr" value="">
	<input type="hidden" name="p_tokto" id="p_tokto" value="">
	<input type="hidden" name="p_fill_id" id="p_fill_id" value="">

  </table> 


	


	<% putObjectInBean(bean_id,bean,request); 
		if(count == k)
			out.println("<script>document.getElementById('selectall_yn').checked=true;</script>");
	
	%>

	

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

