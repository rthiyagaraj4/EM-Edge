<!DOCTYPE html>
<%  
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

12/4/2022				TFS-28650				Shazana													SKR-SCF-1663
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,java.lang.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ReprintDocument.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"RePrintDocReportBean";
		String bean_name			=		"eST.RePrintDocReportBean";


	//	String p_report_id			=		null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		RePrintDocReportBean bean	=		(RePrintDocReportBean) getBeanObject( bean_id,  bean_name, request);  
		bean.setLanguageId(locale);
        String display_flag         =        "";
        String to_date =  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
        String from_date = ""; //Added for SKR-SCF-1663 start
        boolean reprintDoc_oneday_appl =false;
		Connection con				= null; 
	    try{
			con						= ConnectionManager.getConnection(request);
			reprintDoc_oneday_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","REPRINT_DOCUMENT_TRANSACTIONS");    
	    }
	    finally{
	    	if(con != null)
	    		ConnectionManager.returnConnection(con,request); 
	    }
		if(reprintDoc_oneday_appl){
			 from_date =  com.ehis.util.DateUtils.minusDate(to_date,"DMY",locale,1,"D").toString();
		}else{
			 from_date =  com.ehis.util.DateUtils.minusDate(to_date,"DMY",locale,1,"M").toString();
		}//SKR-SCF-1663 END  
		

		//String trn_type_sql = "SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL','CON')  AND language_id=?  ORDER BY 2";
		//commented to remove Purchase Request AAKH-SCF-0010 [IN:037432]
		String trn_type_sql = "SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL','CON','PRQ')  AND language_id=?  ORDER BY 2";
		String site_id      = bean.getCustomerID();

		if(site_id.equals("KDAH")){
			//trn_type_sql = "SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL')  AND language_id=?  ORDER BY 2";
			//commented to remove Purchase Request AAKH-SCF-0010 [IN:037432]
			trn_type_sql = "SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL','PRQ')  AND language_id=?  ORDER BY 2";
		}

		if(site_id.equals("SHALM")){//Added by Krishna Gowtham for ML-MMOH-SCF-0313,IN058460 on 24/11/2015 
			//trn_type_sql = "SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL','CON','PRQ','CEB')  AND language_id=?  ORDER BY 2";Commented by B.Badmavathi for ML-MMOH-SCF-0319
			trn_type_sql = "SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('OBS','SPB','CBL','CON','PRQ','CEB')  AND language_id=?  ORDER BY 2";
		}
				
	%>
	<body onLoad="FocusFirstElement();">
		<form name="ReprintDocumentCriteria" id="ReprintDocumentCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<td width='100%' align='center' class="WHITE"  height='100%'>
				<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0"  height='100%'>
				<th colspan=5 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr><td  class="label" colspan='5'>&nbsp;&nbsp;</td> </tr>		
				<tr>	
					<td class="label" ><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_trn_type" id="p_trn_type" onChange="populateDocTypeCode(this.value);SequenceVisiblity(this.value);IncludeAckVisiblity(this.value);">
						<%=bean.getListOptionTag(bean.getListOptionArrayList(trn_type_sql,locale))%> <option value="REQPIC" ><fmt:message key="eST.PickSlip.label" bundle="${st_labels}"/></option></select><%=bean.getImage("M")%> </td>
						<%
						//String select_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
						String select_option="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
						
						//bean.getStRepositoryValue("DEFAULT_LIST_OPTION")
						%> 
					<td  class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td colspan="2">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" >
						
						<%=select_option%>
						</select> </td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=45 size=45 name="store_desc" id="store_desc"><input class="button" onClick="return searchCodeStore(store_code,store_desc);" type="button" value="?"><input type="hidden" name="store_code" id="store_code" value = "" ></td>
					<td class="label" ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td colspan="2">&nbsp;&nbsp;<input class="NUMBER" type="text" size="8" maxlength="8"  onKeyPress="return isValidInteger();" name="doc_no" id="doc_no"  onBlur="return checkIntegerFormat(this);" ></td>
					 
					
                    
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.PeriodFromDate.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name='p_fr_doc_date' id='p_fr_doc_date' size=10 maxlength=10 class="DATE" value="<%=from_date%>"  onBlur="ChekDate(this,'<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_doc_date');"></img><%=bean.getImage("M")%></td>
					<td class="label" align=left><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td colspan="2">&nbsp;&nbsp;<input type=text name='p_to_doc_date' id='p_to_doc_date' size=10 maxlength=10 class="DATE" value="<%=to_date%>"  onBlur="ChekDate(this,'<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');"></img><%=bean.getImage("M")%></td>
				</tr>    
				<tr>
				<td  class=label align=left><fmt:message key="eST.ConsiderReprintasOriginal.label" bundle="${st_labels}"/> </td>
					<td>&nbsp;&nbsp;<input type="checkbox"  value="" name="reprint_orig" id="reprint_orig"  ></td>
                <td>&nbsp;</td>
				 <td  class="label" ><label id="seq_chk_label" style="visibility:hidden" ><fmt:message key="eST.IssuebySeqPrint.label"   bundle="${st_labels}"/> </label>
				 &nbsp;&nbsp; <input type="checkbox"  value="N" name="seq_chk" id="seq_chk" id="seq_chk" style="visibility:hidden" title="To Print By Sequence" onclick="SequenceChk();callResultPage();" /></td>
				
				 <td align='right' colspan=4><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="frmdate();"></td>  
		        </tr> 
					<!--//Added By Sakti Sankar on 11/02/2013 against SCF#ML-BRU-SCF-0640 inc#36859-->
				<tr>
				<!--<td  class="label" ><label id="include_ack_label" style="visibility:hidden" ><fmt:message key="eST.IncludeAcknowledgement.label"   bundle="${st_labels}"/> </label></td> -->
				<!-- Added by Rabbani #Inc no: 41448(ML-BRU-SCF-0924) on 06-SEP-13 --> 
				<td  class="label" ><label id="include_ack_label" style="visibility:hidden" ><fmt:message key="eST.PendingAcknowledgement.label"   bundle="${st_labels}"/> </label></td>
				 
				<td colspan="4">&nbsp; <input type="checkbox"  value="N" name="include_ack" id="include_ack" id="include_ack" style="visibility:hidden" title="To Display Including Ack. Records" onclick="IncludeAckChk();" /></td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id"				value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"				value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id">
			<input type="hidden" name="p_doc_no" id="p_doc_no">
			<input type="hidden" name="p_doc_type_code" id="p_doc_type_code">
			<input type="hidden" name="p_seq_no" id="p_seq_no">
			<input type="hidden" name="p_reprint_orig" id="p_reprint_orig">
			<input type="hidden" name="dest_locn_type" id="dest_locn_type"			value="S">
			<input type="hidden" name="dest_locn_code" id="dest_locn_code"			value="PARAMETER_WILL_BE_PASSED">
			<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
			

		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" 		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>	


