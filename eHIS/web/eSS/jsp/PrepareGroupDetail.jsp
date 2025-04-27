<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.PrepareGroupBean, eSS.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,java.sql.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 
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
		<script language="javascript" src="../../eSS/js/PrepareGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%

	String bean_id = "prepareGroupBean";
	String bean_name = "eSS.PrepareGroupBean";
	PrepareGroupBean bean = (PrepareGroupBean) getBeanObject( bean_id,bean_name,request );
		
		int i	=0;
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		
		String mode								=		request.getParameter("mode");
		String doc_type_code					=		request.getParameter("doc_type_code");
		String doc_no							=		bean.checkForNull(request.getParameter("doc_no"),"");
		String click_type						=		bean.checkForNull(request.getParameter("click_type"),"");
		ArrayList alGroupRecords				=		null;
		String prepare_qty						=		"";
		String bin_locn_code					=		"";
		String total_value						=		"";
		String pgroup_code						=		"";
		String pgroup_desc						=		"";
		String short_desc = "";
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode									=		mode.trim();
		HashMap hmGroupRecord = null;
		String className	=	"";
       try { 
    	    	  
    	   alGroupRecords = bean.getSelectedList(); 
   	   
	%>

	<body>
		<form name='formPrepareGroupDetail' id='formPrepareGroupDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center">
 			<tr>
 				<th><fmt:message key="eSS.Prepare.label" bundle="${ss_labels}"/> <input type="checkbox" onkeydown="return isNumberKey(event);" value="Y" name="selectAll" id="selectAll" checked  onClick="return toggleCheckforDetail(this);" ></th>
				<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.description.label" bundle="${mm_labels}"/></th>
				<th><fmt:message key="Common.Quantity.label" bundle="${mm_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${mm_labels}"/></th>
				<th><fmt:message key="eSS.TotalValue.label" bundle="${ss_labels}"/></th>
			</tr>
<%
	for(i=0;i<alGroupRecords.size();i++){
					hmGroupRecord=(HashMap)alGroupRecords.get(i);
 				try{
					pgroup_code=bean.checkForNull((String)hmGroupRecord.get("GROUP_CODE"));
					pgroup_desc=bean.checkForNull((String)hmGroupRecord.get("GROUP_DESC"));
					short_desc = bean.checkForNull((String)hmGroupRecord.get("GROUP_DESC"));
					prepare_qty=bean.checkForNull((String)hmGroupRecord.get("PREPARE_QTY"));
					bin_locn_code=bean.checkForNull((String)hmGroupRecord.get("BIN_LOCATION_CODE"));
					total_value=bean.checkForNull((String)hmGroupRecord.get("TOTAL_VALUE"));
					System.out.println("---------------------------------");
					System.out.println("short_desc before decode PrepareGroupDetail.jsp====="+short_desc);
					short_desc = java.net.URLDecoder.decode(short_desc,"UTF-8");
					System.out.println("short_desc after decode-1 PrepareGroupDetail.jsp====="+short_desc);
					short_desc = java.net.URLDecoder.decode(short_desc,"UTF-8");
					System.out.println("short_desc after decode-2 PrepareGroupDetail.jsp====="+short_desc);
					System.out.println("---------------------------------");
				}
			  catch ( Exception e ){
					e.printStackTrace() ;
				}
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
			%>
		<tr id="tr_<%=i%>">
		<td class="<%=className%>" align='center'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onkeydown="return isNumberKey(event);" onclick="updateSelection();" checked></td>
		<td  class="<%=className%>" onmouseover="changeCursor(this);"   onClick="details('<%=(String)hmGroupRecord.get("GROUP_CODE")%>','<%=short_desc%>');" >	<font class="HYPERLINK"><%=(String)hmGroupRecord.get("GROUP_CODE")%></font></td>
		<td  class="<%=className%>"  >	<%=short_desc%><font class="DATAHIGHLIGHT"></font>	</td>
		<td class="<%=className%>" nowrap ><center><input type='text'  name="prepare_qty_<%=i%>" id="prepare_qty_<%=i%>"  onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" maxLength="4" size="12" value="<%=prepare_qty%>" onFocus = "return validateGroupCode();" onBlur="calculateTotalCost('<%=i%>');"/>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></IMG></center></td>
		<td class="<%=className%>" nowrap ><center><select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" onChange="" onkeydown="return isNumberKey(event);" > <%=bean.getBinLocation(bin_locn_code)%> </select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></IMG></center></td>
	    <td class="<%=className%>"nowrap><center><input type='text'  name="total_value_<%=i%>" id="total_value_<%=i%>"size=12 maxlength=12 class="NUMBER" onkeydown="return isNumberKey(event);" onBlur="" value="<%=total_value %>" readonly/></center></td>

	</tr>
			<input type=hidden name="group<%=i%>" id="group<%=i%>"						value="<%=(String)hmGroupRecord.get("GROUP_CODE")%>"/>
			<input type=hidden name="desc<%=i%>" id="desc<%=i%>"						value="<%=short_desc%>"/>
			<input type="hidden" name="bin_locn_code<%=i%>" id="bin_locn_code<%=i%>" 			value="<%=bin_locn_code%>"/>
			<input type=hidden name="new_mode<%=i%>" id="new_mode<%=i%>"					value="<%=(String)hmGroupRecord.get("mode")%>"/>
	<%}%>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" 				value="<%=i%>"/>
			<input type="hidden" name="total_rec" id="total_rec" 						value="<%=i%>">
			
			 <input type=hidden name=bean_id 							value="<%=bean_id%>"/>
			<input type=hidden name=bean_name 							value="<%=bean_name%>"/>
			<input type='hidden' name="facility_id" id="facility_id"						value="">
			<input type='hidden' name="finalize_yn" id="finalize_yn"						value="No">
			<input type='hidden' name="autono_yn" id="autono_yn"						value="No">
			<input type='hidden' name="trn_type" id="trn_type"						value="PRE">
			<input type='hidden' name="store_code" id="store_code"						value="">
			<input type='hidden' name="doc_ref" id="doc_ref"							value="">
			<input type='hidden' name="doc_type_code" id="doc_type_code"					value="">
			<input type='hidden' name="doc_no" id="doc_no"							value="">
			<input type='hidden' name="doc_date" id="doc_date"						value="">
			<input type='hidden' name="mode" id="mode"							value="<%=mode%>">
			<input type="hidden" name="function_id" id="function_id"						value="">
			<input type="hidden" name="locale" id="locale"							value="<%=locale%>">
			<input type="hidden" name="records_to_process" id="records_to_process" 				value="">
			
	</form>
<%
			putObjectInBean("prepareGroupBean",bean,request);
%>

<%
		}
		
		catch (Exception exception) {
		//	out.println(exception);
			exception.printStackTrace();
			
		}
				
%>
<script>
	formObj = document.formPrepareGroupDetail
	
	var total_rec =formObj.total_rec.value;
	
	for(var i =0 ;i<total_rec;i++){ 
		if(eval("document.formPrepareGroupDetail.bin_locn_code"+i).value == ""){
		var bin_code = eval("document.formPrepareGroupDetail.bin_location_code_"+i);
		var selIndex = bin_code.selectedIndex;
		bin_code.selectedIndex = selIndex + 1;
		}
	}

</script>
	</body>
</html>
   

