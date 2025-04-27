<!DOCTYPE html>

<%
/*
Sr No        Version              TFS               SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
2            V220329            29768      PMG2021-COMN-CRF-0089.3-TF-US001            Mohanapriya K
3			 V220720						GHL-SCF-1669-TF								 Mohanapriya K
*/
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eAE.resources.*,eCA.resources.*,eCA.*,eRD.* ,eRD.Common.*,webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Properties properties = (Properties)session.getValue("jdbc");
String locale	= (String) properties.getProperty("LOCALE");
String User	= (String) properties.getProperty("login_user");

String bean_id					= "RadiologyExamBean" ;
String bean_name				= "eRD.RadiologyExamBean";
RadiologyExamBean bean	= (RadiologyExamBean)getBeanObject( bean_id, bean_name , request) ;
bean.setLanguageId(locale);

String facilityId = (String)session.getValue("facility_id");
String responsibility_id =(String)session.getAttribute("responsibility_id");

System.err.println("radid-"+request.getParameter("assigned_rad_id"));
int sNo=0;

String ordering_facility_id = request.getParameter("ordering_facility_id") == null ? "" : request.getParameter("ordering_facility_id") ;
System.err.println("ordering_facility_id "+ordering_facility_id);
String Reg_no = request.getParameter("Reg_no") == null ? "" : request.getParameter("Reg_no") ;
String performing_facility_id = request.getParameter("performing_facility_id") == null ? "" : request.getParameter("performing_facility_id") ;
String performed_by = request.getParameter("performed_by") == null ? "" : request.getParameter("performed_by") ;
String order_type_code = request.getParameter("order_type_code") == null ? "" : request.getParameter("order_type_code") ;
String order_catalog_code = request.getParameter("order_catalog_code") == null ? "" : request.getParameter("order_catalog_code") ;
String reporting_facility_id_cre = request.getParameter("reporting_facility_id_cre") == null ? "" : request.getParameter("reporting_facility_id_cre") ;
String examStatus = request.getParameter("examStatus") == null ? "A" : request.getParameter("examStatus") ;
String toDate = request.getParameter("to_date") == null ? "" : request.getParameter("to_date") ;
String fromDate = request.getParameter("from_date") == null ? "" : request.getParameter("from_date") ;
String patientId=request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id") ;
String assigned_rad_id=request.getParameter("assigned_rad_id") == null ? "" : request.getParameter("assigned_rad_id") ;
String urgency_ind=request.getParameter("urgency_ind") == null ? "" : request.getParameter("urgency_ind") ;

System.err.println("Reg_no "+Reg_no);
System.err.println("performing_facility_id "+performing_facility_id);
System.err.println("performed_by "+performed_by);
System.err.println("order_type_code "+order_type_code);

System.err.println("order_catalog_code "+order_catalog_code);
System.err.println("reporting_facility_id_cre "+reporting_facility_id_cre);
System.err.println("examStatus "+examStatus);
System.err.println("assigned_rad_id "+assigned_rad_id);
fromDate=fromDate+" 00:00";
toDate=toDate+" 23:59";
String contails_key=request.getParameter("contails_key") == null ? "" : request.getParameter("contails_key") ;


if(contails_key.equals("S")){
	order_catalog_code=order_catalog_code+"%";
}
if(contails_key.equals("C")){
	order_catalog_code="%"+order_catalog_code+"%";
}
 if(contails_key.equals("E")){
	order_catalog_code="%"+order_catalog_code;
}

ArrayList RadiologyRecords = (ArrayList)bean.getRadiologyExamList(ordering_facility_id, Reg_no, performing_facility_id, performed_by, order_type_code, order_catalog_code, reporting_facility_id_cre,assigned_rad_id,examStatus, fromDate,toDate,patientId,urgency_ind);

System.err.println("radiology rec size-"+RadiologyRecords.size());
String Priority="";
%>
<html>
<head>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../js/RadiologyExam.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<STYLE TYPE="text/css">
div.table_container_left {
	width: 100%;		/* table width will be 99% of this*/
	height: 460px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}
</STYLE>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="disableSearch('enable')">	
   
   <form name ="RadiologyExamResultForm" action="" method="post" target="messageFrame" >
	
<%if(RadiologyRecords.size()==0){
	 %>
	 <script>
	 errorCalled()
	 </script>
<%	
}else{
	%>
	<div id='table_container_left'  >
	<table  width="100%"  class='grid' id='titleTable' >	
	<thead>
		<tr  style='height:73px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2);'>
            <th width="10%" class='COLUMNHEADER' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
            <th width="10%" class='COLUMNHEADER' ><fmt:message key="eAE.P.label" bundle="${ae_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.PatientName_fs.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.Exam.label" bundle="${rd_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.ResultInd.label" bundle="${rd_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.Regno.label" bundle="${rd_labels}"/></th>	
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.RegnDate/Time.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.ComplDateTime.label" bundle="${rd_labels}"/></th> 
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.AwaitTimeMin.label" bundle="${rd_labels}"/></th> 
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eCA.Laterality.label" bundle="${ca_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.ContrastType.label" bundle="${rd_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.source.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.PrelimRadiologist.label" bundle="${rd_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.Radiologist.label" bundle="${rd_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eCA.Section.label" bundle="${ca_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.Wing.label" bundle="${rd_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.OrderingFacilityName.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.Doctor.label" bundle="${rd_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eRD.StudyLocation.label" bundle="${rd_labels}"/></th>
			</tr>
        </thead>
		<tbody>
    <%for(int i=0;i<RadiologyRecords.size();i=i+42){
		System.err.println("ind -"+RadiologyRecords.get(i+19));
		String ind="";
		if("P".equals(RadiologyRecords.get(i+5))){
			ind="Prelim";
		}else if("M".equals(RadiologyRecords.get(i+5))){
			ind="Modify";
		}else if("R".equals(RadiologyRecords.get(i+5))){
			ind="Result Entry";
		}else if("H".equals(RadiologyRecords.get(i+5))){
			ind="On Hold";
		}
		%>	
		<tr  id='divTitleTable1'  height='0%'>
			<td class='fields' width="15%" >
				<input type="radio" name="select" id="select" align='centre' onClick="selected_serv(this)" id="select<%=sNo%>" value="" onmouseover="hideToolTip();"/>
			</td>
			<td class='gridDataChart' style="background-color: <%=RadiologyRecords.get(i+20) %>" nowrap></td>
			<td id='patid<%=sNo%>' class='label' width="11%" class="fields" style='cursor:pointer; white-space: nowrap' onclick="if(select_serv(<%=sNo%>)){tooltip(this,<%=sNo %>);}">
				<span class="fields" name='patientid<%=sNo%>' id='patientid<%=sNo%>' value="<%=RadiologyRecords.get(i+1)%>"><%=RadiologyRecords.get(i+1)%></span>&nbsp;<img src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=sNo%>'>
			</td>
			<td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+2) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+3) %></td>
			<td class='gridDataChart' name='status<%=sNo%>' id='status<%=sNo%>' value="<%=RadiologyRecords.get(i+4) %>" nowrap><%=RadiologyRecords.get(i+4) %></td>
            <td class='gridDataChart' style='text-align:center' nowrap><div title='<%=ind%>'><a href="#" onclick="if(select_serv(<%=sNo%>)){showNote(<%=sNo%>);}" name="indicator<%=sNo%>" id="indicator<%=sNo%>" value="<%=RadiologyRecords.get(i+5)%>" onmouseover="hideToolTip();"><U><%=RadiologyRecords.get(i+5)%></U></a> </div>
			</td>
			
			
            <td class='gridDataChart' nowrap name='req_no<%=sNo%>' id='req_no<%=sNo%>' value="<%=RadiologyRecords.get(i+6) %>"><%=RadiologyRecords.get(i+6) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+7) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+8) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+9) %></td>
			
			<td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+10) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+11) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+12) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+13) %></td>
			<td class='gridDataChart' name='radiologist<%=sNo%>' id='radiologist<%=sNo%>' value="<%=RadiologyRecords.get(i+14) %>" nowrap><%=RadiologyRecords.get(i+14) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+15) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+16) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+17) %></td>
			<td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+18) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+19) %></td>
			<td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+41) %></td>
           
			<input type="hidden" value="<%=RadiologyRecords.get(i+21)%>" name="physician_id<%=sNo%>" id="physician_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+22)%>" name="orderid<%=sNo%>" id="orderid<%=sNo%>"/> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+23)%>" name="order_line_num<%=sNo%>" id="order_line_num<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i+24)%>" name="ordertypecode<%=sNo%>" id="ordertypecode<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+25)%>" name="operating_facility<%=sNo%>" id="operating_facility<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+26)%>" name="operating_facility_id<%=sNo%>" id="operating_facility_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+27)%>" name="REQUEST_LINE_NUM<%=sNo%>" id="REQUEST_LINE_NUM<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+28)%>" name="examroom<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i+29)%>" name="exam_code<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i+30)%>" name="source_code<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+31)%>" name="performed_by<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+32)%>" name="performed_by_id<%=sNo%>"/> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+40)%>" name="note_type<%=sNo%>" id="note_type<%=sNo%>" /> 
			
			<input type="hidden" value="<%=RadiologyRecords.get(i+33)%>" name="reporting_fac<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i+34)%>" name="reporting_facility_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+35)%>" name="reporting_rad_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+36)%>" name="rad_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+37)%>" name="prelim_rad_id<%=sNo%>" /> 
			   
		 <input type="hidden" value="<%=RadiologyRecords.get(i+38)%>" name="enc_id<%=sNo%>" id="enc_id<%=sNo%>" /> 
		 <input type="hidden" value="<%=RadiologyRecords.get(i+39)%>" name="ext_appl_accession<%=sNo%>" id="ext_appl_accession<%=sNo%>" /> 
			
		</tr>	
	<%
	sNo++;
	}
%>	</tbody>
    </table>
   </div>
   
 <%}%>
    <input type="hidden" value="<%=sNo%>" name="count" id="count" />
    <input type="hidden" value="N" name="selType" id="selType" id="selType" />
    <input type='hidden' name='locale' id='locale' id='locale' value ='<%=locale%>'>    
	 <input type='hidden' name='idx' id='idx' id='idx' value =''>    
	<input type='hidden' name='User' id='User' id='User' value ='<%=User%>'> 
	<input type='hidden' name='CA_Validation' id='CA_Validation' id='CA_Validation' value ="N"> 
	<input type='hidden' name='checkUpdate' id='checkUpdate' id='checkUpdate' value ="N"> 
	<input type='hidden' name='submitDone' id='submitDone' id='submitDone' value ="N"> 
	<input type='hidden' name='responsibility_id' id='responsibility_id' id='responsibility_id' value ='<%=responsibility_id%>'> 
</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
			</tr>
		</table>
	</div>
</body>

</html>

