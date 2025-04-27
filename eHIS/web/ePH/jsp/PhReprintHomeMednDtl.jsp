<!DOCTYPE html>
 <!--  Author 	:	Arun M (157457)
Module name 	:	ePH
Function 	:	RePrint for Home Medication Summary-->
 
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhReprintHomeMdn.js"></script>
</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	String bean_id 			=	"PhReprintHomeMednBean";
	String bean_name 		=	"ePH.PhReprintHomeMednBean";
	String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id").toString();
	String disp_date_frm	=	request.getParameter("disp_date_frm")==null?"":request.getParameter("disp_date_frm").toString();
	String disp_date_to		=	request.getParameter("disp_date_to")==null?"":request.getParameter("disp_date_to").toString();
	String pres_id			=	request.getParameter("pres_id")==null?"":request.getParameter("pres_id").toString();
	String token_no			=	request.getParameter("token_no")==null?"":request.getParameter("token_no").toString();
	String disp_locn_code	=	request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code").toString();
	String drug_ord_type	=	request.getParameter("drug_ord_type")==null?"":request.getParameter("drug_ord_type").toString();
	String med_type_ind		=	request.getParameter("med_type_ind")==null?"":request.getParameter("med_type_ind").toString();
	String encounter_id		=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id").toString();
	String locn_type		=	request.getParameter("locn_type")==null?"":request.getParameter("locn_type").toString();
	String locn_code		=	request.getParameter("locn_code")==null?"":request.getParameter("locn_code").toString();
	String orientation		=	request.getParameter("Orientation")==null?"":request.getParameter("Orientation").toString();
	String language_id		=	request.getParameter("language_id")==null?"":request.getParameter("language_id").toString();
	String mode				=	request.getParameter("mode")==null?"":request.getParameter("mode").toString();	
	String from 			=	CommonBean.checkForNull(request.getParameter("from"));
	String to 				=	CommonBean.checkForNull(request.getParameter("to"));
	String classvalue		=	"";
	String temp_pat_id		=	"";// Added for RUT-SCF-0384[IN46988]
	try{	//Added for [IN45914]
	PhReprintHomeMednBean bean = (PhReprintHomeMednBean)getBeanObject( bean_id, bean_name , request) ;
	
	if(mode.equals("search"))
		bean.clear();
	
	bean.setLanguageId(locale);
	ArrayList dtlMap=bean.getHomeMednDtlData(patient_id,disp_date_frm,disp_date_to,pres_id,token_no,encounter_id,disp_locn_code,drug_ord_type,med_type_ind,locn_type,locn_code,orientation,language_id,"1","5");
	ArrayList presidList=bean.getPresidList();
	int start = 0 ;
	int end = 0 ;
	int i = 0;
	int m=0;
	int maxRecord	= 0;
	 int query_result_size		= 5;
		
         if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt(from) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt(to) ;
			
			
			maxRecord = dtlMap.size();	
%>

<form name="PhReprintHomeMednDtlform" id="PhReprintHomeMednDtlform" >

	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="MednDetailTable">
					<tr><td></td><td></td><td></td><td></td><td></td><td></td>
					<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    				if ( !(start <= 1)) {
	%>
			 				<a href='javascript:SubmitLink("<%=(start-query_result_size)%>","<%=(end-query_result_size)%>","<%=(patient_id)%>","<%=(disp_date_frm)%>","<%=(disp_date_to)%>","<%=(pres_id)%>","<%=(encounter_id)%>","<%=(disp_locn_code)%>","<%=(drug_ord_type)%>","<%=(med_type_ind)%>","<%=(locn_type)%>","<%=(locn_code)%>","<%=(orientation)%>","<%=(language_id)%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>	
	<%
	    				}
	    				if ( !((start+5) > dtlMap.size() )){
	%>
	    					<a href='javascript:SubmitLink("<%=(start+query_result_size)%>","<%=(end+query_result_size)%>","<%=(patient_id)%>","<%=(disp_date_frm)%>","<%=(disp_date_to)%>","<%=(pres_id)%>","<%=(encounter_id)%>","<%=(disp_locn_code)%>","<%=(drug_ord_type)%>","<%=(med_type_ind)%>","<%=(locn_type)%>","<%=(locn_code)%>","<%=(orientation)%>","<%=(language_id)%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    				}
	%>
					</td>
					</tr>
		<tr> 
			<th class="border" width="13%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class="border" width="25%"><fmt:message key="Common.PatientName_fs.label" bundle="${common_labels}"/> </th>
			<th class="border" width="10%"><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></th>
			<th width="15%" class="border"><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th>
			<th width="15%" class="border"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
			<th width="15%" class="border"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<th class="border" width="10%"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
		</tr>
		<%
		if(dtlMap.size()==0){
			if(mode.equals("search")){
			%>
			<script language="javascript">
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
			</script>
		<%
			}
		}else{
			%>
			<script language="javascript">
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%	
		if ( start != 1)
				for( int j=1; j<start; i++,j++ ) {   }
			
			
				if ( i % 2 == 0 )
				classvalue = "QRYODD" ;
				else
				classvalue = "QRYEVEN" ;
				while(i<end && i<dtlMap.size())	{
						String data_filter=dtlMap.get(i).toString();
						data_filter=data_filter.replace("[","");
						data_filter=data_filter.replace("/]","");
						data_filter=data_filter.replace("null","");
						String[] data=data_filter.split("/,");//Added for RUT-SCF-0383[IN46980]
				//if(i!=0){//Removed for [IN45914]
				 if(m==0)
				     m++;
		%>
		<tr>
		<% 
		String select="";
		String pres_order_id="";//Added for RUT-SCF-0383[IN46980]				
		for(int j=0;j<data.length;j++){ 
			if(j==0 && !data[j].equals(" ")){//Added for RUT-SCF-0384[IN46988]
				temp_pat_id=data[j].toString();
			}			
		  if(j==3){
		      data[j]=data[j].replace(" ","").toString();
		      for(int k=0;k<presidList.size();k++){
			  	if(presidList.get(k).equals(temp_pat_id+"/"+data[j].toString()+"/"+data[6].toString().trim())){//Modified for RUT-SCF-0383[IN46980]//Added 'temp_pat_id' for RUT-SCF-0384[IN46988]
			  		select="checked";
			  		break;
		      	}else{
			  		select="";
		      	}
			  }
		      pres_order_id=temp_pat_id+"/"+data[j].toString()+"/"+data[6].toString().trim();//Added for RUT-SCF-0383[IN46980]//Added 'temp_pat_id' for RUT-SCF-0384[IN46988]
		  %>
			    <td class="label" align="center" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:OnclickPresIdDtlRec('<%=pres_order_id%>','<%=i%>')"><%=data[j]%></td>
			    <input type="hidden" name="pres_id_<%=m%>" id="pres_id_<%=m%>" value='<%=data[j]%>'>
			    <input type="hidden" name="pres_order_id_<%=m%>" id="pres_order_id_<%=m%>" value='<%=pres_order_id%>'><!-- //Added for RUT-SCF-0383[IN46980] -->
		<%	}else{
			if(j!=6){//Added for RUT-SCF-0383[IN46980]%>
			    <td class="label" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=data[j]%></td>
			    <%} } } %>
			<td align="center"><input type="checkbox" name="selected_<%=m%>" id="selected_<%=m%>" value="E" onclick="fetchPresIdDtlRec('<%=m%>')" <%=select%>></td>
		</tr>
		<input type="hidden" name="patient_id_<%=m%>" id="patient_id_<%=m%>" value='<%=temp_pat_id%>'><!--Added for RUT-SCF-0384[IN46988]-->
		<% m++; i++;} //Changed for [IN45914]%>
	</table>
	<input type="hidden" name="number_of_rows" id="number_of_rows" value="">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=maxRecord%>">
	<input type="hidden" name="from" id="from" value="<%=start%>">
	<input type="hidden" name="to" id="to" value="<%=end%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="disp_date_frm" id="disp_date_frm" value="<%=disp_date_frm%>">
	<input type="hidden" name="disp_date_to" id="disp_date_to" value="<%=disp_date_to%>">
	<input type="hidden" name="pres_id" id="pres_id" value="<%=pres_id%>">
	<input type="hidden" name="token_no" id="token_no" value="<%=token_no%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
	<input type="hidden" name="drug_ord_type" id="drug_ord_type" value="<%=drug_ord_type%>">
	<input type="hidden" name="med_type_ind" id="med_type_ind" value="<%=med_type_ind%>">
	<input type="hidden" name="locn_type" id="locn_type" value="<%=locn_type%>">
	<input type="hidden" name="locn_code" id="locn_code" value="<%=locn_code%>">
	<input type="hidden" name="orientation" id="orientation" value="<%=orientation%>">
	<input type="hidden" name="language_id" id="language_id" value="<%=language_id%>">
	<input type="hidden" name="pres_count" id="pres_count" value="<%=i%>">
	
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
}
}//Added for [IN45914] - Start
catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}//Added for [IN45914] - End
%>

