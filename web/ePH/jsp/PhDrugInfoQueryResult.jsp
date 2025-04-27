<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* ,java.net.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
		<TITLE></TITLE>
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
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>   
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</HEAD>
<%
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	
	String enq_date_from		= request.getParameter( "enq_date_from" ) ;
	String enq_date_to			= request.getParameter( "enq_date_to" ) ;
	String respond_date_from	= request.getParameter( "respond_date_from" ) ;
	String respond_date_to		= request.getParameter( "respond_date_to" ) ;
	String source				= request.getParameter( "source" ) ;
	String designation			= request.getParameter( "designation" ) ;
	String priority				= request.getParameter( "priority" ) ;
	String request_mode			= request.getParameter( "request_mode" ) ;
	String response_status		= request.getParameter( "response");
	String verify_yn			= request.getParameter( "verify_yn" ) ;
	String Enq_num				= request.getParameter( "Enq_num" ) ;
	String req_catg				= request.getParameter( "req_catg" ) ;

	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	try {
		enq_date_from			= CommonBean.checkForNull( enq_date_from );
		enq_date_to				= CommonBean.checkForNull( enq_date_to );
		respond_date_from		= CommonBean.checkForNull( respond_date_from );
		respond_date_to			= CommonBean.checkForNull( respond_date_to );
		source					= CommonBean.checkForNull( source );
		designation				= CommonBean.checkForNull( designation );
		priority			    = CommonBean.checkForNull( priority );
		request_mode     		= CommonBean.checkForNull( request_mode );
		response_status			= CommonBean.checkForNull( response_status );
		verify_yn				= CommonBean.checkForNull( verify_yn );
		Enq_num     			= CommonBean.checkForNull( Enq_num );
		req_catg     			= CommonBean.checkForNull( req_catg );
		ArrayList records = bean.getEnquiryDetails(enq_date_from,enq_date_to,respond_date_from,respond_date_to,source,designation,priority,request_mode,response_status,verify_yn,Enq_num,req_catg);

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 13 ;
		else
			end = Integer.parseInt( to ) ;
		int maxRecord = records.size()/10;
		if(maxRecord==0){
%>
			<script>
				var error=getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
				alert(error);
				//history.go(-1);
			</script>
<%
		}
		//if(maxRecord >end){
%>
		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
			<form name="formDrugInfoQueryResult" id="formDrugInfoQueryResult">
				<table>
					<tr>
						<td class="label">
<%
						if ( !(start <= 1) ){
%>
							<label style="cursor:pointer;color:blue" onClick="javascript:callNext('<%=start-13%>','<%=end-13%>','<%=enq_date_from%>','<%=enq_date_to%>','<%=respond_date_from%>','<%=respond_date_to%>','<%=source%>','<%=designation%>','<%=priority%>','<%=request_mode%>','<%=response_status%>','<%=verify_yn%>','<%=Enq_num%>','<%=req_catg%>');"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></label>
<%
						}
						if ( !( (start+14) > maxRecord ) ){
%>
							<label style="cursor:pointer;color:blue" onClick="javascript:callNext('<%=start+13%>','<%=end+13%>','<%=enq_date_from%>','<%=enq_date_to%>','<%=respond_date_from%>','<%=respond_date_to%>','<%=source%>','<%=designation%>','<%=priority%>','<%=request_mode%>','<%=response_status%>','<%=verify_yn%>','<%=Enq_num%>','<%=req_catg%>');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></label>
<%
						}
%>
						</td>
					</tr>
				</table>
<%
				//}
				if(records.size() > 0){
%>
					<table cellpadding="0" cellspacing="0"  border="1" width="100%" align="center">
						<tr>
							<td class="COLUMNHEADERCENTER" nowrap >&nbsp;<fmt:message key="ePH.EnquiryNo.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADERCENTER" nowrap>&nbsp;<fmt:message key="ePH.EnquiryDate.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADERCENTER" nowrap>&nbsp;<fmt:message key="ePH.ResponseStatus.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADERCENTER" nowrap>&nbsp;<fmt:message key="Common.VerificationStatus.label"  bundle="${common_labels}"/></td>
							<td class="COLUMNHEADERCENTER" nowrap>&nbsp;<fmt:message key="ePH.SourceOfRequest.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADERCENTER" nowrap>&nbsp;<fmt:message key="ePH.PriorityOfRequest.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADERCENTER" nowrap>&nbsp;<fmt:message key="ePH.EnquirerDesignation.label" bundle="${ph_labels}"/></td>
						</tr>
<%	
						String enquiry_no="";
						String enquiry_date="";
						String respond_date="";

						String source_of_req_desc="";
						String priority_desc="";
						String enquirer_type_desc="";
						String verified_by ="";
						String classValue	=""; 

						int	j	=0;
						int g=0;
						int h=0;
						if ( start != 1 ){
							for( int k=1; k<start; g++,k++,h+=10 ){
							}
						}
						i=h;
						for(int u=g; u<end && i<records.size(); u++)	{	 
							if(j%2==0)
								classValue	=	"QRYEVEN";
							else
								classValue	=	"QRYODD";
							enquiry_no				=	(String)records.get(i);
							enquiry_date			=	DateUtils.convertDate((String)records.get(i+1),"DMYHM","en",locale);
							respond_date			=   (String)records.get(i+2);
							verified_by				=	(String)records.get(i+3);
							source_of_req_desc		=	(String)records.get(i+5);
							priority_desc			=   (String)records.get(i+7);
							//enquirer_type			=   (String)records.get(i+8);
							enquirer_type_desc		=   (String)records.get(i+9);
							//enquiry_date = com.ehis.util.DateUtils.convertDate(enquiry_date,"DMYHMA","en",locale);
							//respond_date = com.ehis.util.DateUtils.convertDate(respond_date,"DMYHMA","en",locale);
%>
							<tr>
								<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="showEnqDtl('<%=enquiry_no%>');" nowrap>&nbsp;<%=enquiry_no%>&nbsp;</label></td>
								<td class="<%=classValue%>" nowrap><%=enquiry_date%>&nbsp;</td>
<%
								if(respond_date.equals("")){ 
%>
									<td class="<%=classValue%>" nowrap><fmt:message key="Common.Pending.label" bundle="${common_labels}"/>&nbsp;</td>
<%
								}
								else{
%>
									<td class="<%=classValue%>" nowrap><fmt:message key="ePH.Responded.label" bundle="${ph_labels}"/>&nbsp;</td>
<%
								}
								if(verified_by.equals("")){
%>
									<td class="<%=classValue%>" nowrap><fmt:message key="ePH.Un-Verified.label" bundle="${ph_labels}"/>&nbsp;</td>
<%
								}
								else{
%>
									<td class="<%=classValue%>" nowrap><fmt:message key="ePH.Verified.label" bundle="${ph_labels}"/>&nbsp;</td>
<%
								}
%>
								<td class="<%=classValue%>" nowrap><%=source_of_req_desc%>&nbsp;</td>
								<td class="<%=classValue%>" nowrap><%=priority_desc%>&nbsp;</td>
								<td class="<%=classValue%>"><%=enquirer_type_desc%>&nbsp;</td>
							</tr>
<%
							j++;
							i+=10;
						}	
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
%>
			</table>
		</form>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

