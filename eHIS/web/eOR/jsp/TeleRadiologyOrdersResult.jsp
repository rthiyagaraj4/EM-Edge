<!DOCTYPE html>

<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		Ramesh G       GHL-CRF-0487 [IN:065642]
14/02/2018      IN066695        Prathyusha p     14/02/2018        Ramesh G        GHL-CRF-0487_US001 [IN:065642]

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Properties properties = (Properties)session.getValue("jdbc");
String locale	= (String) properties.getProperty("LOCALE");
String bean_id					= "TeleRadiologyOrdersBean" ;
String bean_name				= "eOR.TeleRadiologyOrdersBean";
TeleRadiologyOrdersBean bean	= (TeleRadiologyOrdersBean)getBeanObject( bean_id, bean_name , request) ;
bean.setLanguageId(locale);

String facilityId = (String)session.getValue("facility_id");

int sNo=0;

String ordering_facility_id = request.getParameter("ordering_facility_id") == null ? "" : request.getParameter("ordering_facility_id") ;
String ordered_by = request.getParameter("ordered_by") == null ? "" : request.getParameter("ordered_by") ;
String order_id = request.getParameter("order_id") == null ? "" : request.getParameter("order_id") ;
String performing_facility_id = request.getParameter("performing_facility_id") == null ? "" : request.getParameter("performing_facility_id") ;
String performed_by = request.getParameter("performed_by") == null ? "" : request.getParameter("performed_by") ;
String order_type_code = request.getParameter("order_type_code") == null ? "" : request.getParameter("order_type_code") ;
String order_catalog_code = request.getParameter("order_catalog_code") == null ? "" : request.getParameter("order_catalog_code") ;
String reporting_facility_id_cre = request.getParameter("reporting_facility_id_cre") == null ? "" : request.getParameter("reporting_facility_id_cre") ;
String ORDERED_PRACT = request.getParameter("ORDERED_PRACT") == null ? "" : request.getParameter("ORDERED_PRACT") ;
String examStatus = request.getParameter("examStatus") == null ? "A" : request.getParameter("examStatus") ;
String toDate = request.getParameter("to_date") == null ? "" : request.getParameter("to_date") ;
String fromDate = request.getParameter("from_date") == null ? "" : request.getParameter("from_date") ;
String patientId=request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id") ;
String assigned_rad_id=request.getParameter("assigned_rad_id") == null ? "" : request.getParameter("assigned_rad_id") ;
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

ArrayList RadiologyRecords = (ArrayList)bean.getReadoligyOrdersList(ordering_facility_id, ordered_by, order_id, performing_facility_id, performed_by, order_type_code, order_catalog_code, reporting_facility_id_cre, ORDERED_PRACT,assigned_rad_id,examStatus, fromDate,toDate,patientId);

%>
<html>
<head>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../js/TeleRadiologyOrderDetails.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
   
   <form name ="TeleRadiologyOrdersResultForm" action="../../servlet/eOR.TeleRadiologyResultServlet" method=post target="messageFrame" >

<%if(RadiologyRecords.size()==0){
	 %>
	 <script>errorCall()</script>
<%	
}	
	else{%>
	<div id='table_container_left' style='overflow:auto;width:100%;height:395px;' >  
	<table  width="100%"  class='grid' id='titleTable' >
         <tr  style='height:60px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2);'>
            <th width="40%" class='COLUMNHEADER' ><input type="checkbox" name="selectAll" id="selectAll"  value="Y" onclick="selectCheckBoxes(this);" /><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="eOR.sNo.label" bundle="${or_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="eOR.ExamStatus.label" bundle="${or_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.PatientName_fs.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.age.label" bundle="${common_labels}"/> / <fmt:message key="Common.Sex.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/> </th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/> </th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.Performed.label" bundle="${common_labels}"/>  <fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/> </th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.Assigned.label" bundle="${common_labels}"/>  <fmt:message key="eOR.radiologist.label" bundle="${or_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/> / <fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.Ordering.label" bundle="${common_labels}"/>  <fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
            <th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
        </tr>
        
    <%for(int i=0;i<RadiologyRecords.size();i=i+28){%>	
		<tr  id='divTitleTable1'  height='0%'>
	  
          <%  if((RadiologyRecords.get(i+16)).equals("70") || (RadiologyRecords.get(i+16)).equals("85") ){ %>
			<td class='gridDataChart' nowrap><input type="checkbox" name="select<%=sNo%>" id="select<%=sNo%>" disabled value="" onclick="selectedRecord(this)" /></td>
           <%}else{ %>
            <td class='gridDataChart' nowrap><input type="checkbox" name="select<%=sNo%>" id="select<%=sNo%>" value="" onclick="selectedRecord(this)" /></td>
        <% } %>
            <td class='gridDataChart' nowrap><%=sNo+1%></td>
            
         <%  int count=Integer.parseInt((String)RadiologyRecords.get(i+19));
         if(count>0 && !(RadiologyRecords.get(i+16)).equals("50")){          
         %>
			<td class='gridDataChart' nowrap><a href="#" onclick="callAuditTrail('<%=sNo%>')" ><%=RadiologyRecords.get(i) %></a></td>
            
        <%}else{ %>
        	<td class='gridDataChart' nowrap> <%=RadiologyRecords.get(i) %></td>
        <% } %>
        
			<td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+1) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+2) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+3) %></td>
			<td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+4) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+5) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+6) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+7) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+8) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+9) %></td>
       <% 
          if(RadiologyRecords.get(i+10).equals("")){%>
			<td class='gridDataChart' nowrap></td>
		<%  }else {
			String encodeRemarks =java.net.URLEncoder.encode((String)RadiologyRecords.get(i+10), "UTF-8");
          %>
		  <td    class="gridDataChart"  nowrap onMouseOver = "showToolTipsForChnFldRmks(this,'<%=encodeRemarks%>')" style="color:blue;"><fmt:message key="eOR.ViewRemarks.label" bundle="${or_labels}"/></td>
           <%} %>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+11) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+12) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+13) %></td>
            <td class='gridDataChart' nowrap><%=RadiologyRecords.get(i+14) %></td>           
			<input type="hidden" value="<%=RadiologyRecords.get(i+20)%>" name="operating_facility<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+17)%>" name="request_num<%=sNo%>"/> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+18)%>" name="request_line_num<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i+27)%>" name="ordered<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+7)%>" name="performed<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+25)%>" name="order_catalog_code<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+26)%>" name="ordering_facility_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+14)%>" name="order_id<%=sNo%>" /> 
			<input type="hidden" value="<%=RadiologyRecords.get(i+5)%>" name="catalog_desc<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i)%>" name="exam_status<%=sNo%>" /> 
            <input type="hidden" value="<%=RadiologyRecords.get(i+6)%>" name="operating_facility_desc<%=sNo%>" /> 
		</tr>
	<%
	sNo++;
	}
%>
    </table>
    </div>
    <table border="0" cellpadding="3" cellspacing="0" id='tbId' width="100%" valign='bottom'>
	<tr>
		<td class=label  width="15%"><fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%" >
			<input type='text' name="reporting_facility_id_name" id="reporting_facility_id_name" value=""    onBlur='getTelRadiologyReporteingFacility1(this)' size='30' />
			
			<input type='button' name='search' id='search'  value='?' class='button' onClick="getTelRadiologyReporteingFacility()" />
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			<input type='hidden' name='reporting_facility_id' id='reporting_facility_id' value='' />
		</td>
		<td class=label  width="10%"  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
		<td  rowSpan="2" width="30%" >
			<input type="hidden" value="" name="Remarks" id="Remarks">
			<textarea rows="3" id="Remarks_assign" name="remarks_name" cols="90" maxLength="5" onKeyPress="return ( this.value.length < 250);" onblur="return checkCharRange(this,'250') "  ></textarea>
		</td>	
	</tr>
	<tr>
		<td class=label width="10%"  ><fmt:message key="eOR.assigndiag.label" bundle="${or_labels}"/> <fmt:message key="eOR.radiologist.label" bundle="${or_labels}"/></td>
		<td class='fields' width="25%"  >
			<input type='text'  name="assigned_pract_desc" id="assigned_pract_desc" value="" onBlur='getAssignPractitioner1(this)' size='30' />
			<input type='button' name='search' id='search' value='?'  class='button' onClick="getAssignPractitioner()"/>
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			<input type="hidden" name="assigned_pract_code" id="assigned_pract_code" value=''/>
		</td>	   
		<td class=label width="10%" >&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" class=label >&nbsp;</td>
		<td width='50%' align="right">
			<input type='button' name='Assign' id='Assign' value='Assign' class="button" onclick="insertRecords()"/>
			<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class=button onclick="resetCriteria();" />
		</td>
	</tr>
	</table> 
 <%}%>
    <input type="hidden" value="<%=sNo-1%>" name="count" />
    <input type='hidden' name='locale' id='locale' value ='<%=locale%>'>   
</form>

</body>

</html>

