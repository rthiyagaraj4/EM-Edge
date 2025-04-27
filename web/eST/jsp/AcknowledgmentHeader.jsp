
<%@ page import="eST.AcknowledgmentBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//Added by Sakti against BRU-HIMS-CRF-073.1
	String store_code 		= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String trn_name 		= request.getParameter( "trn_name" )==null?"":request.getParameter( "trn_name" );
	String cnf_select = "";
	if(trn_name.equals("ST_ACK_RQC") || trn_name.equals("ST_ACK_URC") || trn_name.equals("ST_ACK_RTC") || trn_name.equals("ST_ACK_TFC")){ 
		cnf_select = "selected";	
	} 
	//Added ends
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eST/js/Acknowledgment.js'></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onload="setTrnType();setStore('<%=store_code%>');">
		<form name='formAcknowledgeHeader' id='formAcknowledgeHeader'>
		<%
			AcknowledgmentBean bean	=	(AcknowledgmentBean) getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
			bean.setLanguageId(locale);
			bean.clear();
			String mode = request.getParameter("mode");
			//Added by Rabbani #Inc no:30909 on 12/03/12 Starts
	  
	  HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
	 //ends
		%>
			<table border="0" cellspacing="0" width="100%" align=center>
				<tr>
					<td class="label"><fmt:message key="Common.TRNType.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<select name="trn_type" id="trn_type" onchange="setTrnType(this);"><%=bean.getTrn_type_List(trn_name)%></select><%=bean.getImage("M")%></td>
					<td class="label"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"> <%=bean.getDoc_type_code_List()%></select><%=bean.getImage("M")%></td>
					<td class="label"><fmt:message key="eST.ActionType.label" bundle="${st_labels}"/></td>
					<td class="fields">
						<select name="action_type" id="action_type" onchange="setActionType(this)">
							<option value="A"><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></option>
							<option value="C" <%=cnf_select%>><fmt:message key="Common.confirm.label" bundle="${common_labels}"/></option><!-- Modified for IN:074037  -->
						</select>
					</td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td class='fields'>&nbsp;&nbsp;<select name="store_code" id="store_code"><%=bean.getStore_code_List()%></select><%=bean.getImage("M")%></td>
					<td  class="label"><fmt:message key="eST.FromDocDate.label" bundle="${st_labels}"/></td>
					<td class='fields'>
						&nbsp;
					<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');">
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>
					</td>
					<td  class="label"><fmt:message key="eST.ToDocDate.label" bundle="${st_labels}"/></td>
					<td class='fields'>
						<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');">
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
					<td colspan=3>&nbsp;</td>
					<td class='fields'>&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'   onClick="checkDocDate(document.forms[0]);"></td>
				</tr>
			</table>
			<input type="hidden" name="mode" id="mode"		value=<%=mode%>>
			<input type="hidden" name="bean_id" id="bean_id"		value="acknowledgmentBean">
			<input type="hidden" name="bean_name" id="bean_name"	value="eST.AcknowledgmentBean">
			<input type="hidden" name="record_saved" id="record_saved"value="N">
		</form>
	</body>
</html>

