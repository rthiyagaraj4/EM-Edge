<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!-- 
Developed by    : P.Sudhakaran.
Module/Function : OP/IP Prescription Transaction calling from CA
-->
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------

20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
--------------------------------------------------------------------------------------------------------------
*/%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.RefillDetails.label" bundle="${ph_labels}"/></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8"); 
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/Prescription_1.js"></script>
		<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<!-- Added for IN:069886 start -->
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!-- Added for IN:069886 end-->
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="refill_form" id="refill_form">
<%
		String mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );

		String end_date					=	request.getParameter("end_date");
		String srl_no					=	request.getParameter("srl_no");
		String repeat_durn_type			=	request.getParameter("repeat_durn_type");
		String durn_value				=	request.getParameter("durn_value");
	//	String tmp_durn_value			=	request.getParameter("tmp_durn_value");//Added for IN:069886 //Commented for IN:069886
		String refill_no				=	request.getParameter("refill_no")==null?"0":request.getParameter("refill_no");
		String max_refills_for_pres		=	request.getParameter("max_refills");
		String max_durn_for_refill_pres	=	request.getParameter("max_durn_for_refill_pres");
		String date_range_in_muliples	=	request.getParameter("date_range_in_muliples")==null?"1":request.getParameter("date_range_in_muliples");//Added for IN:069886
		String freq_durn_type	=	request.getParameter("freq_durn_type")==null?"":request.getParameter("freq_durn_type");//Added for IN:069886
		String interval_value	=	request.getParameter("interval_value")==null?"1":request.getParameter("interval_value");//Added for IN:069886
		String bean_id					=	request.getParameter("bean_id");
		String bean_name				=	request.getParameter("bean_name");
		String presBean_id					=	request.getParameter("presBean_id")==null?"0":request.getParameter("presBean_id"); //Added for MMS-SCF-0085 [IN:042992] 
		String presBean_name				=	request.getParameter("presBean_name")==null?"0":request.getParameter("presBean_name");//Added for MMS-SCF-0085 [IN:042992] 
		String classvalue				=	"";
		if(!locale.equals("en")){
			end_date =  DateUtils.convertDate(end_date, "DMYHM",locale,"en");
		}
		PrescriptionBean presBean			= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request) ;
		//Modified for IN:069886 start
		PrescriptionBean_1 presBean1 = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
		//bean.setLanguageId(locale);
		boolean change_last_refill_end_date_appl =presBean.isSiteSpecific("PH","CHANGE_LAST_REFILL_END_DATE");//added for MO-CRF-20151
		String change_last_refill_end_date_appl_yn="N";
		if(change_last_refill_end_date_appl){
			change_last_refill_end_date_appl_yn="Y";
		}
		HashMap RefillDetail= (HashMap) presBean1.getRefillDetail(srl_no);//Modified for IN:069886
		if(RefillDetail!=null){
			if(!(((String)RefillDetail.get("end_date")!=null && ((String)RefillDetail.get("end_date")).equals(end_date)) && ((String)RefillDetail.get("durn_value")!=null &&((String)RefillDetail.get("durn_value")).equals(durn_value)) && ((String)RefillDetail.get("repeat_durn_type")!=null && ((String)RefillDetail.get("repeat_durn_type")).equals(repeat_durn_type)) && ((String)RefillDetail.get("refill_no")!=null && ((String)RefillDetail.get("refill_no")).equals(refill_no)))){
				 RefillDetail			= (HashMap) presBean.populateRefillDetail(end_date,durn_value, repeat_durn_type,refill_no);
			}
		}
		else{
		 RefillDetail			= (HashMap) presBean.populateRefillDetail(end_date,durn_value, repeat_durn_type,refill_no);
		}
		//Modified for IN:069886 end
		String refill_st_date			=	"";
		String refill_en_date			=	"";
		if(refill_no.equals(""))
			refill_no="0";
		if(RefillDetail.size()>0){
%>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<td class="label"   colspan="2"><fmt:message key="ePH.NoofRefill.label" bundle="${ph_labels}"/></td>
					<td  ><input type="text" name="no_refill" id="no_refill" size="2" onKeyPress="return(ChkNumberInput(this,event,'0'))" maxlength="2" onblur="validateNoRefill(this);" class="NUMBER" value="<%=refill_no%>"></td>
				</tr>
				<tr>
					<th width="5%">#</th>
					<th width="45%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
					<th width="50%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
				</tr>
<%
				ArrayList refill_start_date=(ArrayList) RefillDetail.get("refill_start_date");
				ArrayList refill_end_date=(ArrayList) RefillDetail.get("refill_end_date");

				if(refill_start_date != null && refill_start_date.size()>0){
					refill_st_date	=	(String) refill_start_date.get(0);
				}
				
				if(refill_end_date != null && refill_end_date.size()>0){
					refill_en_date	=	(String) refill_end_date.get(refill_end_date.size()-1);
				}
				for(int i=0;i<refill_start_date.size();i++){
					if ( i % 2 == 0 ) 
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
					//Modified for IN:069886 start
					String refill_end_date_tmp=(String) refill_end_date.get(i);
					String refill_start_date_tmp=(String) refill_start_date.get(i);
					if(i==(refill_start_date.size()-1) && change_last_refill_end_date_appl){//Modified for IN:069886
%>
					<input type="hidden" name="refill_start_date_tmp" id="refill_start_date_tmp" value="<%=refill_start_date_tmp%>">
					<tr><td class="<%=classvalue%>" ><%=i+1%></td><td class="<%=classvalue%>" ><%=(String) refill_start_date.get(i)%></td><td class="<%=classvalue%>" > <input type="text" name="refill_end_date_tmp" id="refill_end_date_tmp" size="14"  maxlength="16" value="<%=refill_end_date_tmp%>" onblur="validateRefillEndDate(this,'<%=refill_st_date%>','<%=locale%>','<%=max_durn_for_refill_pres%>');"  ><img SRC="../../eCommon/images/CommonCalendar.gif"  name='endDateImg'  onclick="showCalendar('refill_end_date_tmp',null,'hh:mm');"></td></tr>
					<%} else{ %>
					<tr><td class="<%=classvalue%>" ><%=i+1%></td><td class="<%=classvalue%>" ><%=(String) refill_start_date.get(i)%></td><td class="<%=classvalue%>"><%=(String) refill_end_date.get(i)%></td></tr>
					<%
				}}//Modified for IN:069886 end
%>
				</table>
<%
			}
			if(!locale.equals("en")){
				end_date =  DateUtils.convertDate(end_date, "DMYHM","en",locale);
			}
%>
			<input type="hidden" name="max_refills_for_pres" id="max_refills_for_pres" value="<%=max_refills_for_pres%>">
			<input type="hidden" name="durn_value" id="durn_value" value="<%=durn_value%>">
			<input type="hidden" name="max_durn_for_refill_pres" id="max_durn_for_refill_pres" value="<%=max_durn_for_refill_pres%>">
			<input type="hidden" name="end_date" id="end_date" value="<%=end_date%>">
			<input type="hidden" name="repeat_durn_type" id="repeat_durn_type" value="<%=repeat_durn_type%>">
			<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">		
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">		
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">	
			<input type="hidden" name="presBean_id" id="presBean_id" value="<%=presBean_id%>">		<!-- added for MMS-SCF-0085 [IN:042992] -->
			<input type="hidden" name="presBean_name" id="presBean_name" value="<%=presBean_name%>">	<!-- added for MMS-SCF-0085 [IN:042992] -->
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="refill_start_date" id="refill_start_date" value="<%=refill_st_date%>">
			<input type="hidden" name="refill_end_date" id="refill_end_date" value="<%=refill_en_date%>">
			<!-- Added for IN:069886 start -->

			<input type="hidden" name="date_range_in_muliples" id="date_range_in_muliples" value="<%=date_range_in_muliples%>">
			<input type="hidden" name="last_refill_durn_value" id="last_refill_durn_value" value="">
			<input type="hidden" name="last_refill_freq_chnage_durn_value" id="last_refill_freq_chnage_durn_value" value="">
			<input type="hidden" name="interval_value" id="interval_value" value="<%=interval_value%>">
			<input type="hidden" name="freq_durn_type" id="freq_durn_type" value="<%=freq_durn_type%>">
			<input type="hidden" name="change_last_refill_end_date_appl_yn" id="change_last_refill_end_date_appl_yn" value="<%=change_last_refill_end_date_appl_yn%>">
			<!-- Added for IN:069886 end-->
		</form>
	</body>
<% 
	putObjectInBean(presBean_id,presBean,request); // bean_id replaced with presBean_id for MMS-SCF-0085 [IN:042992] 
	putObjectInBean(bean_id,presBean1,request);//Added for IN:069886
%>
</html>

