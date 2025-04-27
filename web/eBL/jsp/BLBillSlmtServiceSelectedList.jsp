<!DOCTYPE html>
<%@ page import="eBL.*,oracle.sql.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script type="text/javascript">
 $(document).ready(function(){	 

	  $(".remove_record_link").click(function(){
		  
		  var index = $('#DataSetFields tr').index($(this).closest('tr'));
		  //alert("clicked" + $("#remove_record"+index).val() );
			 
		 	  $.ajax({
		          url:"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp",
		          type:'post',
	              data: {
	            	operation: "DELETE", 
	          		trans_doc_ref: $("#remove_record"+index).val() 
	              },
		          success: function(data) {
		              var obj = jQuery.parseJSON(data);
		              $("#RefreshSelectedListDiv").load(location.href );
		          }
		        });  

		 });
	  
	  
	  $(".all_service_criteria_dropdown").change(function(){
		  	  var index = $('#DataSetFields tr').index($(this).closest('tr'));
		  	  			    		  	  
			  if($("#all_service_criteria"+index).val()=="P"){ 
				  $("#settledAmt"+index).prop("disabled",false);
			  }

		 });
	  
	  $(".settled_amt_class").blur(function(){
		  
		  var index = $('#DataSetFields tr').index($(this).closest('tr'));
		 			 
		 	  $.ajax({
		          url:"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp",
		          type:'post',
	              data: {
	            	operation: "UPDATE", 
	          		trans_doc_ref: $("#trxDocRef"+index).val(),
	          		all_service_criteria: $("#all_service_criteria"+index).val(),
	          		settled_amt: $("#settledAmt"+index).val()
	              },
		          success: function(data) {
		              var obj = jQuery.parseJSON(data);
		              $("#RefreshSelectedListDiv").load(location.href );
		          }
		        });  

		 });

	      if(parent.BillSlmtEntryFrame.BillSlmtDetForm.settleByService.value===true){
			  var all_service_criteria=parent.BillSlmtEntryFrame.BillSlmtDetForm.all_service_criteria.value;
			  if(all_service_criteria=="I"){
			  	parent.BillSlmtEntryFrame.BillSlmtDetForm.billslmtamtdet.value = parent.BillSlmtEntryFrame.BillSlmtDetForm.billpayableamt.value - $("#totalIncludeOrExcludeAmount").val();
			  }else{
			  	parent.BillSlmtEntryFrame.BillSlmtDetForm.billslmtamtdet.value = $("#totalIncludeOrExcludeAmount").val();
			  }
	      }
	 
 });
</script>

<div id="RefreshSelectedListDiv">
<HTML>
<HEAD>
<TITLE>
</TITLE>
</HEAD>
</HEAD>
<BODY>
<FORM name='BillSlmtServiceSelectedListForm' id='BillSlmtServiceSelectedListForm'>
<table> 
<tr width='100%'>
	<td width="10%" class='COLUMNHEADER'><fmt:message key="eBL.IRBBillNo.label" bundle="${bl_labels}"/></td>
	<td width='10%' class='COLUMNHEADER' ><fmt:message key="eBL.IRBServiceDate.label" bundle="${bl_labels}"/></td>
	<td width='20%' class='COLUMNHEADER' ><fmt:message key="eBL.IRBDocRef.label" bundle="${bl_labels}"/></td>
	<td width='5%'  class='COLUMNHEADER' ><fmt:message key="eBL.IRBDocLineNo.label" bundle="${bl_labels}"/></td>
	<td width="4%"  class='COLUMNHEADER'><fmt:message key="eBL.IRBDocSeqNo.label" bundle="${bl_labels}"/></td>			
	<td width="10%" class='COLUMNHEADER'><fmt:message key="eBL.IRBBlngServiceCode.label" bundle="${bl_labels}"/></td>	
	<td width="10%" class='COLUMNHEADER'><fmt:message key="eBL.IRBApplicableAmount.label" bundle="${bl_labels}"/></td>	
	<td width="9%" class='COLUMNHEADER'><fmt:message key="eBL.IRBServiceAmt.label" bundle="${bl_labels}"/></td>
	<td width="5%" class='COLUMNHEADER'><fmt:message key="eBL.AMT_SETTLED.label" bundle="${bl_labels}"/></td>
	<td width="10%" class='COLUMNHEADER'><fmt:message key="eBL.IRBIncludeExclude.label" bundle="${bl_labels}"/></td>
	<td width="*" class='COLUMNHEADER'><fmt:message key="eBL.IRBDelete.label" bundle="${bl_labels}"/></td>
</tr>
</table>
<div id="ageGroupTableDiv" STYLE="width:100%; height:100; overflow: auto;">
<table id="DataSetFields" border=0> 
<%
TreeSet<BLBillSlmtServiceBean> slmt_by_svc_parameter_array = (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
double totalNetAmount=0;
if(slmt_by_svc_parameter_array!=null){
int count=0;
String all_service_criteria=(String) session.getAttribute("all_services_included_excluded_slmt");
Iterator it= slmt_by_svc_parameter_array.iterator();
while(it.hasNext()){
	BLBillSlmtServiceBean obj=(BLBillSlmtServiceBean)it.next(); 

%>
	<tr width='100%'>
	<td class="fields"  width='10%'><%=obj.getBillDocType()%>/<%=obj.getBillNumber()%></td> <!-- 	BillNumber -->
	<td class="fields"  width='10%'><%=obj.getServiceDate()%></td> <!-- 	service_date -->
	<td class="fields"  width='20%'><%=obj.getTrxDocRef()%><input type="hidden" id="trxDocRef<%=count%>" name="trxDocRef<%=count%>" value="<%=obj.getTrxDocRef()%>"></td>	<!-- 	trx_doc_ref	 -->
	<td class="fields"  width='5%'><%=obj.getTrxDocRefLineNum()%></td>	<!-- 	trx_doc_ref_line_num	 -->	
	<td class="fields"  width='3%'><%=obj.getTrxDocRefSeqNum()%></td>	<!-- 	trx_doc_ref_seq_num	 -->
	<td class="fields"  width='10%'><%=obj.getBillingService()%></td><!-- 	blng_serv_code	 -->			
	<td class="fields"  width='10%'><%=obj.getUpdNetChargeAmt()%></td><!-- 	adj_rounding_amt	 -->
	<td class="fields"  width='10%'><%=obj.getSettledAmt()%></td><!-- 	serv_amt	 -->
	<td class="fields"  width='5%'><input type="textbox" class='settled_amt_class'  size="5" id="settledAmt<%=count%>" name="settledAmt<%=count%>" value="<%=obj.getSettledAmt()%>" <% if(obj.getInclusionExclusionCriteria().equals("P")==false){%>disabled<%} %> ></td><!-- 	sett_amt	 -->	
	<td class="fields"  width='10%'>	
	<select class='all_service_criteria_dropdown' name="all_service_criteria<%=count%>" id="all_service_criteria<%=count%>" id="all_service_criteria<%=count%>">
	 <% if (all_service_criteria.equals("E")==false){ %>
	  <option <%if(obj.getInclusionExclusionCriteria().equals("E")){%>selected<%}%> value="E">Exclude</option>
	  <%}else { %>
	  <option <%if(obj.getInclusionExclusionCriteria().equals("I")){%>selected<%}%> value="I">Include</option>
	  <%} %>
	  <option <%if(obj.getInclusionExclusionCriteria().equals("P")){%>selected<%}%> value="P">Partial</option>
	</select>
	</td>	<!-- 	inclusion Exclusion	 -->
	<td class="fields"  width='5%'><a href="#" class="remove_record_link" id="remove_record<%=count%>" value="<%=obj.getTrxDocRef()%>" >Remove</a></td><!-- 	inclusion Exclusion	 -->
	</tr>
<%
totalNetAmount+=Double.parseDouble(obj.getUpdNetChargeAmt());
count++;
}

}//null check
%>
</div>
</table>
<input type="hidden" name="totalIncludeOrExcludeAmount" id="totalIncludeOrExcludeAmount" id="totalIncludeOrExcludeAmount"  value="<%=totalNetAmount%>">
</FORM>
</BODY>
</HTML>
</div>

