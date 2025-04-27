<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037679	   		Karthi	 								SRR20056-SCF-9534
06/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US009 - Barcode search
07/08/2020      IN073577            B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.CondemnExpiredBatchesHeaderBean,java.util.ArrayList,java.util.HashMap,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%	
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javaScript" src="../../eST/js/CondemnExpiredBatches.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	eST.CondemnExpiredBatchesHeaderBean bean = (eST.CondemnExpiredBatchesHeaderBean)getBeanObject( "condemnExpiredBatchesHeaderBean", "eST.CondemnExpiredBatchesHeaderBean", request); 
	bean.setLanguageId(locale);
	HashMap defaultParameter = bean.getDefaultStParameter();
	String default_doc_type_code = (String)defaultParameter.get("DEF_ADJ_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
    String mode = bean.checkForNull(request.getParameter ("mode"),"1");	
    //Added for GHL-CRF-0413.7 starts
    	Connection con	= null;
	con		= ConnectionManager.getConnection(request);
	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	bean.setSite_spec_yn(site);
	//Added for GHL-CRF-0413.7 ends
%>																								
<body onLoad="FocusFirstElement();">
	<form name="formCondemnExpiredBatchesCriteria" id="formCondemnExpiredBatchesCriteria" onReset="FocusFirstElement();">
		<table border=0 cellpadding=2 cellspacing=0  width='100%'> 
			<tr>
				<th  colspan='6'>
					<fmt:message key="eST.SelectCriteria.label" bundle="${st_labels}"/>
				</th>	
			</tr>
			
				<!--//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 -->
				<tr>
				<td class=label>Condemn Type</td>
				<td class=fields >&nbsp;&nbsp;<select name="condemn_type" id="condemn_type"  onChange= "loadLegend(this);"> <option  value='Y'>
				<fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></option>
				<option  value='N'><fmt:message key="eST.NonExpiryItems.label" bundle="${st_labels}"/></option>
				</select></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				</tr>
				<tr>
				<td class='fields'>
					&nbsp;
				</td>
				<td class="label" >
					&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				</td>
				<td  class="label">
					&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
				<td >
					&nbsp;
				</td>
				<td >
					&nbsp;
				</td>
				<td >
					&nbsp;
				</td>
				
			</tr>

			<tr>
				<td  class="label" id = 'cutoffdate'>
					<!--<fmt:message key="Common.CutOffDate.label" bundle="${common_labels}"/> -->
					Cut-off Date for Expiry
				</td>
				<td class=fields>&nbsp;&nbsp;
					<input size=10 maxlength=10 name="p_fm_cut_off_date" id="p_fm_cut_off_date" value="" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_cut_off_date');"></img>
				</td>
				<td  class=fields>&nbsp;&nbsp;
					<input size=10 maxlength=10 name="p_to_cut_off_date" id="p_to_cut_off_date" value='<%=com.ehis.util.DateUtils.convertDate((String)bean.getSystemDate(),"DMY","en",locale)%>' onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_cut_off_date');"></img>
				</td>
				<!-- CheckDate(this) to CheckDateLeap() for SRR20056-SCF-9534 -->
				<td class="label">
					&nbsp;
				</td>
				<td class="label">
					&nbsp;
				</td>		
				<td class="label">
					&nbsp;
				</td>			
				
			</tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/>
				</td>
				<td class=fields>
					&nbsp;&nbsp;
					<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" >
					<input type=button name="store_search_from" id="store_search_from" class="button" onclick="searchFromStoreCode();" value='?'>
				</td>
				<td  class=fields>
					&nbsp;&nbsp;
					<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" value="" >
					<input type=button name="store_search_to" id="store_search_to" class="button" onclick="searchToStoreCode();" value='?'>
				</td>
				<td class="label">
					&nbsp;
				</td>
				<td class="label">
					&nbsp;
				</td>			
				<td class="label">
					&nbsp;
				</td>							
				
			</tr>

			<tr>
				<td  class="label">
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
				</td>
				<td class=fields>
					&nbsp;&nbsp;
					<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" >

					<input type=button name="item_search_from" id="item_search_from" class="button" onClick="callItemSearchScreenFrom();"  value='?'>
				</td>
				<td  class=fields>
					&nbsp;&nbsp;
					<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" >
					<input type=button name="item_search_to" id="item_search_to" class="button" onClick="callItemSearchScreenTo();"  value='?'>
				</td>
				<td class="label">
					&nbsp;
				</td>		
	   		        <td>
	   		        	&nbsp;
	   		        </td>				
				<td class="label">
					&nbsp;
				</td>												
			</tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
				</td>
				<td class=fields>
					&nbsp;&nbsp;
					<input maxLength=10 size=10 name="p_batch_id" id="p_batch_id" value="" onKeyPress="return  CheckForSpecialChars(event);">
				</td>
				<td align="left" class="fields">
					&nbsp;&nbsp;
					<input  type=button name="batch_search" id="batch_search" class="button" onclick="loadData();" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'>
				</td>				
			        <td>
			        	&nbsp;
			        </td>				
			        <td>
			        	&nbsp;
			        </td>				
				<td class="label">
					&nbsp;
				</td>				
			        
			</tr>
			<%if(site){ //Added for GHL-CRF-0413.7 starts%>
			<tr>
				<td  class="label">
					<fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/><!-- Modified for TFS id:6938 -->
				</td>
				<td class=fields>
					&nbsp;&nbsp;
					<input  name='barcode' id='barcode' size=80 maxlength=100 value = "" onkeypress="searchBarcode(event,barcode)" disabled ><!--Modified for IN:073577 increased size from 70 to 80 -->
				</td>
				<td class="fields">
					&nbsp;&nbsp;
					<label id="selected_records" name ="selected_records"  value= ""></label>&nbsp;
				</td>	
				  <td>
			        	&nbsp;
			        </td>				
			        <td>
			        	&nbsp;
			        </td>				
				<td class="label">
					&nbsp;
				</td>			
			</tr>	
			<%}//Added for GHL-CRF-0413.7 ends %>
		</table>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP_FOR_CONDEMN" id="SQL_ST_STORE_LOOKUP_FOR_CONDEMN" value="<%= bean.getStRepositoryValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">		
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">		
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">		
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">		
		<input type="hidden" name="user_id" id="user_id" value="<%=(String)session.getAttribute("login_user")%>">		
		<input type="hidden" name="site" id="site" value="<%=site%>">	<!-- Added for GHL-CRF-0413.7 -->			
	</form>	
	<%
putObjectInBean("condemnExpiredBatchesHeaderBean",bean,request);
%>
<%
//Added for GHL-CRF-0413.7 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413.7 ends
%>
</body>		
</html>	

