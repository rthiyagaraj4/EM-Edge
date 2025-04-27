<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 
%>

<script type="text/javascript">


$(document).ready(function(){
	
	  function serviceLookUp(){
			var locale = "en";
			var argumentArray  = new Array();
			var dataNameArray  = new Array();
			var dataValueArray = new Array();
			var dataTypeArray  = new Array();
			var sql 		   = '';
			var title 		   = '';
		    sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";

			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
			argumentArray[4] = "2,1";
			argumentArray[5] = $("#service_text").val();
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;

			var retval = CommonLookup(title, argumentArray );
			if((retval != null) && (retval != "") )  {
				var ret1 = unescape(retval);
				arr = ret1.split(",");
				$("#service_text").val(arr[0]);
				$("#ServiceListDiv").load("../../eBL/jsp/BLBillSlmtServiceList.jsp?<%=params%>"+"&service_selected="+ $("#service_text").val());
			}
	  }
	
 	  $("#ServiceListDiv").load("../../eBL/jsp/BLBillSlmtServiceList.jsp?<%=params%>"+"&all_service_criteria="+$("#all_service_criteria").val());
	    
	  $("#service_text").blur(function(){
		  if($("#service_text").val()!=''){
		  	serviceLookUp();
		  }
	  }); 
	  
	  $("#service_text_lookup").click(function(){
		  serviceLookUp();
	  }); 
	  
	  $("#search_text_lookup").click(function(){
		  $("#ServiceListDiv").load("../../eBL/jsp/BLBillSlmtServiceList.jsp?<%=params%>");
	  }); 
	  
	  $("#close_text_lookup").click(function(){
		  window.close();
	  }); 
	  
	  
	  $("#service_selected").change(function(){
		  $("#ServiceListDiv").load("../../eBL/jsp/BLBillSlmtServiceList.jsp?<%=params%>"+"&service_selected="+ $("#service_selected").val());
		  }); 
	  
});


</script>

<HTML>
<HEAD>
<TITLE>
</TITLE>
</HEAD>
</HEAD>
<%
String strbilldoctypecode = request.getParameter("bill_doc_type_selected");	
if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";		
String strbilldocnum = request.getParameter("bill_doc_no_selected");	
if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";

%>
<BODY>
<FORM name='BillSlmtServiceSelectedListFrameForm' id='BillSlmtServiceSelectedListFrameForm' id='BillSlmtServiceSelectedListFrameForm'>
<table widht="100%">
<tr>
<td width="25%" class="label">Billing Service</td>
<td width="25%">
	<input type="text" name="service_text" id="service_text" id="service_text">
	<input type=button	class=button id='service_text_lookup' name='service_text_lookup' id='service_text_lookup' value='?'>
</td>
<td width="25%">
<input type=button	class=button id='search_text_lookup' value='Search'>
</td>
<td width="25%">
<input type=button	class=button id='close_text_lookup'  value='Close'>
</td>
</tr>
</table>
<!-- 	STYLE="width:100%; height:600; overflow: auto;" -->
<div id="ServiceListDiv"></div>
</FORM>
</BODY>

</HTML>

