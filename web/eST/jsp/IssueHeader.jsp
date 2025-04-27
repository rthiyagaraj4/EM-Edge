<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eST.IssueBean, java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/Issue.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
        function_id						=		"<%= request.getParameter("function_id") %>"
		
	</script>
	</head>
<body>
<form name="formIssueHeader" id="formIssueHeader">
<%
	try {	
		String mode						=		request.getParameter("mode");
		String	item_class_desc			=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );

		String trn_type					=		"URG";
		String bean_id					=		"issueBean";
		String bean_name				=		"eST.IssueBean";
		String sql_from_store			=		"SQL_ST_ISSUE_REQ_URG_FROM_STORE";
		String sql_to_store				=		"SQL_ST_ISSUE_REQ_URG_TO_STORE";
		String Modal_Window_Open		=		"Yes";
		String closeDisabled			=		"";
		String preview_disabled			=		"disabled";
		String visibility				=		"visibility:hidden";

		eST.IssueBean bean				=		(eST.IssueBean) getBeanObject( bean_id ,  bean_name ,request );
		eST.Common.StDuoHeaderBean stduobean		=		(eST.Common.StDuoHeaderBean) getBeanObject( bean_id,bean_name,request);
		//Added for GHL-CRF-0413 starts
				Connection con				= null;
				con						= ConnectionManager.getConnection(request);
				boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
				System.out.println("System.out.println(site_main)===="+site_main);
				boolean site_alna = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_REQ_URG_TO_STORE"); //Added for NMC-JD-CRF-0174 
				bean.setSite_spec_yn(site_main);
				String  trn_type_barcode  = bean.checkForNull(bean.getTrn_type(), "URG");//Added against GHL-CRF-0413.2-US002
		//Added for GHL-CRF-0413 ends
		bean.setLanguageId(locale);
		bean.setItem_class_desc(item_class_desc);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		stduobean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		
		if(((String)bean.getClose_yn()).equals("Y")){
			visibility				=		"visibility:visible";
		}
		if(trn_type.equals("URG")) {
			closeDisabled				=		"disabled";
		} 
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				 Modal_Window_Open		 =		"Yes";
		}
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			if(bean.getTrn_type () != null) 
			trn_type					=		bean.getTrn_type ();								
			Modal_Window_Open			=		"No";
			preview_disabled			=		"";
		}

		String urg_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  urg_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.getFrom_store_code(),(String) session.getValue( "login_user" )}).get("URG_DELETE_YN"),"N");
		
		String iss_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  iss_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getFrom_store_code()),(String) session.getValue( "login_user" )}).get("ISS_DELETE_YN"),"N");

		String param = request.getQueryString();
		
		   //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
			String hdr_remarks_reqd = bean.checkForNull((String)bean.fetchRecord("SELECT HDR_REMARKS_REQD FROM ST_TRN_TYPE_FOR_REMARKS WHERE TRN_TYPE =?" ,trn_type).get("HDR_REMARKS_REQD"),"N");
			if(hdr_remarks_reqd.equals("Y"))
			visibility				=		"visibility:visible";
			//ends
			
			//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			String records_exist_seq_no = "N";
			if(bean.getPendingIssueSeq())
			records_exist_seq_no = "Y";
%>
<%
putObjectInBean(bean_id,bean,request);
%>
		    <jsp:include	page="../../eST/jsp/StDuoHeader.jsp" > 
			<jsp:param		name="mode"					value="<%=mode%>" />
			<jsp:param		name="doc_type_code"		value="<%=bean.checkForNull(bean.getDoc_type_code())%>" />
			<jsp:param		name="doc_no"				value="<%=bean.checkForNull(bean.getDoc_no())%>" />
			<jsp:param		name="doc_date"				value="<%=bean.checkForNull(bean.getDoc_date())%>" />
			<jsp:param		name="doc_ref"				value="<%=bean.checkForNull(bean.getDoc_ref())%>" />
			<jsp:param		name="from_store_code"		value="<%=bean.checkForNull(bean.getFrom_store_code())%>" />
			<jsp:param		name="to_store_code"		value="<%=bean.checkForNull(bean.getTo_store_code())%>" />
			<jsp:param		name="item_class_code"		value="<%=bean.checkForNull(bean.getItem_class_code())%>" />
			<jsp:param		name="item_class_desc"		value="<%=item_class_desc%>" />
			<jsp:param		name="trn_type"				value="<%=trn_type%>" />
			<jsp:param		name="sql_from_store"		value="<%=sql_from_store%>" />
			<jsp:param		name="sql_to_store"			value="<%=sql_to_store%>" />
			<jsp:param		name="Modal_Window_Open"	value="<%=Modal_Window_Open%>" />
			<jsp:param		name="issue_flag"			value="true" />
			<jsp:param		name="site_alna"			value="<%=site_alna%>" />      
		</jsp:include>
<%
	String chk="";

	if(request.getParameter("checkYN")!=null && request.getParameter("checkYN").equals("Y")){
		chk="checked";
	}else{
		chk="";
	}
	%>
		<table cellspacing="0" cellpadding="0" width="100%" border ="0" align=center>
			<tr>
				<td class="label" ><fmt:message key="eST.CloseUponIssue.label" bundle="${st_labels}"/>
				<input type="checkbox" name="close_yn" id="close_yn" value="<%=bean.checkForNull(bean.getClose_yn(),"N")%>"  onclick="setCloseYN();" <%=chk%>></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="label" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks();"><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label><img id="remarks_jif" src="../../eCommon/images/mandatory.gif" align=center style="<%=visibility%>"></td>
				<td class='fields'>
					<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%>   onclick="previewDetails();" >&nbsp;&nbsp;&nbsp;
				</td> 
			</tr>
		</table>

		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>" >
		<input type="hidden" name="records_to_delete" id="records_to_delete"		value="" >
		<input type="hidden" name="remarks" id="remarks"					value="<%=bean.checkForNull(bean.getHdrRemarks(),"")%> " >
		<input type="hidden" name="finalize_allowed_yn" id="finalize_allowed_yn"		value="N">
		<input type="hidden" name="trn_type" id="trn_type"				value="<%=trn_type%>">
		<input type="hidden" name="item_class_desc1" id="item_class_desc1"		value="<%=item_class_desc%>">
		<input type="hidden" name="urg_delete_yn" id="urg_delete_yn"			value="<%=urg_delete_yn%>">
		<input type="hidden" name="iss_delete_yn" id="iss_delete_yn"			value="<%=iss_delete_yn%>">


	<input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
	<input type="hidden"    name="chargeable_yn" id="chargeable_yn"				value="" ><!--dummy-->
	<!--Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 -->
    <input type="hidden"	    name="hdr_remarks_reqd" id="hdr_remarks_reqd"				value="<%=hdr_remarks_reqd%>">
	 <!-- //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 12-Feb-2014 -->
     <input type="hidden"       name = "records_to_hold"		value="" >
     <input type="hidden"       name = "hold_yn"		        value="N" >
     <input type="hidden"	    name = "records_exist_seq_no"	value="<%=records_exist_seq_no%>">
     <input type="hidden"    name="site" id="site"	 value="<%=site_main%>"><!--Added against GHL-CRF-0413 -->
     <input type="hidden"    name="trn_type_barcode" id="trn_type_barcode"	 value="<%=trn_type_barcode%>"><!--Added against GHL-CRF-0413.2-US002-->
	</form>

<script>
if(document.formIssueHeader.trn_type_barcode.value == "URG" )//Modified trn_type to trn_type_barcode against GHL-CRF-0413.2-US002
callBarCodeApplicable('URG','formIssueHeader','issueBean','eST.IssueBean');
//Added against GHL-CRF-0413.2-US002 starts
if(document.formIssueHeader.trn_type_barcode.value == "ISS" )
	callBarCodeApplicable('ISS','formIssueHeader','issueBean','eST.IssueBean');
//Added against GHL-CRF-0413.2-US002 ends
parent.frameIssueDetail.document.location.href="../../eST/jsp/IssueDetail.jsp?<%=param%>";
parent.frameIssueList.document.location.href="../../eST/jsp/IssueListFrame.jsp?<%=param%>";	
</script>

<%
//Added for GHL-CRF-0413 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413 ends
%>
</body>
</html>
<%
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
%>

