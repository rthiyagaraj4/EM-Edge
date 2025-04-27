<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.VendorLoanRequestBean, eSS.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,java.sql.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script> 
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/VendorLoanRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head> 
	<%

	String bean_id = "VendorLoanRequestBean";
	String bean_name = "eSS.VendorLoanRequestBean";
	VendorLoanRequestBean bean = (VendorLoanRequestBean) getBeanObject( bean_id,bean_name,request );
		
		int i	=0;
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		
		String mode								=		request.getParameter("mode");
		String doc_type_code					=		request.getParameter("doc_type_code");
		String doc_no							=		bean.checkForNull(request.getParameter("doc_no"),"");
		String click_type						=		bean.checkForNull(request.getParameter("click_type"),"");
		String surgery_type						=		"";
		String surgery_name						=		"";
		String req_on_vendor_code				=		bean.checkForNull(request.getParameter("req_on_vendor_code"),"&nbsp;");
		String req_by_store_code				=		bean.checkForNull(request.getParameter("req_by_store_code"),"&nbsp;");
		String req_by_store_desc				=		bean.checkForNull(request.getParameter("req_by_store_desc"),"");
		//req_by_store_desc						=		" "+"in : "+req_by_store_desc;
		if(req_by_store_desc.equals("")){
			req_by_store_desc					=		"";
		}else{
			req_by_store_desc					=		" "+"in : "+req_by_store_desc;
		}
		ArrayList alGroupRecords				=		null;
		String	group_type						=		"";
		String req_qty							=		"";
		String total_qty					=		"";
		String pgroup_code						=		"";
		String pgroup_desc						=		"";
		HashMap hmGroupRecord 					= 		null;
		String className						=		"";
		String stSterilizedQty					=		"";
		String new_mode 						= 		"";
		
				
		if ((mode == null) || (mode.equals("")))  
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode									=		mode.trim();
		
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			req_by_store_code = bean.getReq_by_store_code();
			req_on_vendor_code = bean.getReq_on_vendor_code();
		}
		
       try { 

    	   alGroupRecords = bean.getSelectedList();
    	   String surg_nature_link_to_OT_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
	%>

	<body onMouseDown="CodeArrest();" >
		<form name='formVendorLoanRequestList' id='formVendorLoanRequestList'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center">
 			<tr>
 			<th ><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/> <input type="checkbox" value="Y" onkeydown="return isNumberKey(event);" name="selectAll" id="selectAll"   onClick="return toggleCheckforDetail(this);" ></th>
			<th width='100'><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></th>
			<%if(surg_nature_link_to_OT_yn.equals("Y")){ %>
			<th ><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/></th>
			<%} %>
			<th width='180'><fmt:message key="eSS.TotalAvailableQty.label" bundle="${ss_labels}"/> <%=java.net.URLDecoder.decode(req_by_store_desc,"UTF-8")%></th>
			<th width='120'><fmt:message key="eSS.Requestquantity.label" bundle="${ss_labels}"/></th>
			
			</tr>
			<%
				for(i=0;i<alGroupRecords.size();i++){
					hmGroupRecord=(HashMap)alGroupRecords.get(i);
					

		try{
				pgroup_code		=bean.checkForNull((String)hmGroupRecord.get("GROUP_CODE"));
				pgroup_desc		=bean.checkForNull((String)hmGroupRecord.get("GROUP_DESC"));
				group_type		=bean.checkForNull((String)hmGroupRecord.get("GROUP_TYPE"));
				surgery_type	=bean.checkForNull((String)hmGroupRecord.get("SURGERY_TYPE"),"&nbsp;");
				surgery_name	=bean.checkForNull((String)hmGroupRecord.get("SURGERY_NAME"),"&nbsp;");
				req_qty			=bean.checkForNull((String)hmGroupRecord.get("QTY"));
				total_qty	=bean.checkForNull((String)hmGroupRecord.get("TOTAL_QTY"),"&nbsp;");
				new_mode 		= (String)hmGroupRecord.get("mode");
				
				pgroup_desc = java.net.URLEncoder.encode(pgroup_desc,"UTF-8");
				
				
		}catch ( Exception e ){
			e.printStackTrace() ;
		}
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
		%>
		<tr id="tr_<%=i%>">
		<td class="<%=className%>" align='center'><input type='checkbox' onkeydown="return isNumberKey(event);" name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="updateSelection();" ></td>
		<td  class="<%=className%>"  >	<%=(String)hmGroupRecord.get("GROUP_TYPE")%><font class="DATAHIGHLIGHT"></font>	</td>
		<td  class="<%=className%>" onmouseover="changeCursor(this);"   onClick="details('<%=(String)hmGroupRecord.get("GROUP_CODE")%>','<%=pgroup_desc%>');" >	<font class="HYPERLINK"><%=java.net.URLDecoder.decode(pgroup_desc,"UTF-8")%></font></td>
		<td  class="<%=className%>" id="id_surg_desc_<%=i%>" >	<%=surgery_type%><font class="DATAHIGHLIGHT"></font>	</td>
		<%if(surg_nature_link_to_OT_yn.equals("Y")){ %>
		<td  class="<%=className%>"  id="id_ot_surg_desc_<%=i%>">	<%=surgery_name%><font class="DATAHIGHLIGHT"></font>	</td>
		<%} %>
		
		<td  class="<%=className%>"  style="TEXT-ALIGN:right" id="id_av_st_qty_<%=i%>">	<%=total_qty%><font class="DATAHIGHLIGHT"></font>	</td>
		<!-- maxLength changed fro m 2 to 4 for ML-MMOH-CRF-1828 -->
		<td class="<%=className%>" nowrap ><center><input type='text'  name="req_qty_<%=i%>" id="req_qty_<%=i%>"  onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this);" class="NUMBER" maxLength="4" size="12" value="<%=req_qty%>" onFocus = "" onBlur=""/>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></IMG></center></td>
		

		
	</tr>
			
			<input type=hidden name="group<%=i%>" id="group<%=i%>"					value="<%=(String)hmGroupRecord.get("GROUP_CODE")%>"/>
			<input type=hidden name="desc<%=i%>" id="desc<%=i%>"					value="<%=java.net.URLDecoder.decode(pgroup_desc,"UTF-8")%>"/>
			<input type=hidden name="group_type<%=i%>" id="group_type<%=i%>"				value="<%=group_type%>"/>
			<input type="hidden" name="total_qty<%=i%>" id="total_qty<%=i%>" 			value="<%=total_qty%>"/>
			<input type=hidden name="surgery_type<%=i%>" id="surgery_type<%=i%>"			value="<%=surgery_type%>"/>
			<input type=hidden name="new_mode<%=i%>" id="new_mode<%=i%>"				value="<%=new_mode%>"/>
			<input type=hidden name="surgery_name<%=i%>" id="surgery_name<%=i%>"			value="<%=surgery_name%>"/>
			
	<%}%>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" 			value="<%=i%>"/>
			<input type="hidden" name="total_rec" id="total_rec" 					value="<%=i%>">
			<input type=hidden name=bean_id 						value="<%=bean_id%>"/>
			<input type=hidden name=bean_name 						value="<%=bean_name%>"/>
			<input type='hidden' name="mode" id="mode"						value="<%=mode%>"/>
			<input type="hidden" name="locale" id="locale"						value="<%=locale%>"/>
			<input type="hidden" name="records_to_delete" id="records_to_delete"			value=""/>
			<input type="hidden" name="authorized" id="authorized"					value="N"/>
			<input type='hidden' name="doc_ref" id="doc_ref"						value=""/>
			<input type="hidden" name="trn_type" id="trn_type"					value="REQ"/>
			<input type="hidden" name="req_by_store_code" id="req_by_store_code"			value=""/>
			<input type="hidden" name="req_on_vendor_code" id="req_on_vendor_code"			value=""/>
			<input type="hidden" name="entry_completed_yn" id="entry_completed_yn"			value=""/>
			<input type="hidden" name="doc_date" id="doc_date"					value=""/>
			<input type='hidden' name="doc_type_code" id="doc_type_code"				value=""/>
			<input type='hidden' name="doc_no" id="doc_no"						value=""/>
			<input type="hidden" name="module_id" id="module_id"					value=""/>
			<input type="hidden" name="function_id" id="function_id"					value="<%= bean.getFunctionId() %>"/>
			<input type="hidden" name="request_type" id="request_type"				value=""/>
			
	</form>
			<%
putObjectInBean(bean_id,bean,request);


%>

<%
		}
		
		catch (Exception exception) {
		//	out.println(exception);
			exception.printStackTrace();
			
		}
				
%>
<script>
	formObj = document.formVendorLoanRequestList
	
	var total_rec =formObj.total_rec.value;
	
</script>
	</body>
</html>
  

