<!DOCTYPE html>
<%@ page import="eBL.Common.*,eBL.*,oracle.sql.*,webbeans.op.CurrencyFormat,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<%!

private String formattedAmt(String amt){
	if(amt==null || amt.equals("")) {
		return "0.00";
	}
CurrencyFormat cf = new CurrencyFormat();		
amt = cf.formatCurrency(amt,2); 
return amt;
}

%>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 
		String noofdecimal=request.getParameter("noofdecimal");
		System.out.println("gayathriii========"+noofdecimal);
		System.out.println("DepositPage QryString" + params);
		String submitBtn = request.getParameter("submitBtn");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script>
function putDecimal_Text(Obj,maxvalue,deci)
{
	var temp1=$.trim(Obj.text());
	var temp4=temp1.length;
	var count=parseInt(maxvalue) -parseInt(deci);
	if (parseInt(deci) > 0)
	{
		if(temp1.indexOf('.') <0)
		{
			if (temp4 <= parseInt(maxvalue))
			{
				if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp2=temp1.substring(0,count);
					var temp3=temp2+"."+temp1.substring(count,temp1.length)
					if(temp3.length-1 < parseInt(maxvalue))
					{
						for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
						{
							temp3+="0";
						}
					}
					Obj.text(temp3);
				}
				else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
				
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
	 
				}
   
 
			}

		}else{
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
			Obj.text(temp7+"."+temp6+localTemp);
	
		}
	}
}
function putdeci(object)
{		
	
	if(object.value!='')
	{
	putDecimal(object,17,2);
	}
	
	
}
</script>
<script type="text/javascript">
 $(document).ready(function(){
	 
	 if($('#submitBtn').val() != 'Y'){
		 $('.depositCheckClass').each(function(){
			$(this).prop('disabled',true); 
		 });
		 $('#selectedDepositList').prop('disabled',true);
	 }
	 
	  $("#selectedDepositList").click(function(){

		  $.ajax({
                    url:"../../eBL/jsp/BLBillSlmtServiceDepositStorage.jsp",
                    type:'post',
                    data: $("#BillSlmtDepositForm").serialize() + "&total_records="+$('#docTypeTable tr').length + "&checked_records="+$("[type='checkbox']:checked").length,
                    success: function(data) {
                        var obj = jQuery.parseJSON(data);
                        //alert(obj.flag);
                        if(obj.flag=="SUCCESS"){
                        	var adjustedAmt = 0;
                        	$('[id^=adjustedAmt]').each(function(){
                        		adjustedAmt = parseFloat(adjustedAmt) + parseFloat($(this).val());
                        	});

                        	//window.returnValue=$("#payableAmount").val()+":::"+adjustedAmt;
                        	parent.document.querySelectorAll("#dialog-body")[parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = $("#payableAmount").val()+":::"+adjustedAmt;

                        	//window.close();
                        	parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
                        }
                    }
		          }); 
   
		});
	  
	  $("#cancelDepositList").click(function(){
		  //window.close();
		  parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
	  });
	  
	  
	 
	 $(".depositCheckClass").click(function(){
		
		 var index=$('#docTypeTable tr').index($(this).closest('tr'));	
		 var noofdecimal=<%=noofdecimal%>;
		 if($(this).prop('checked')==true){	

			 var settlement=$("#afterAdjustment").val();
	
			 if(settlement>0){ // settlement should be Valid a positive number
				 
			 var deposit= $("#deposit"+(index)).val();
			 var adjustedAmt=0;
	
			 if(parseFloat(deposit)>parseFloat(settlement)){
				 $("#adjusted"+index).text(settlement);
				 putDecimal_Text($("#adjusted"+index),17,noofdecimal);
				 $("#adjustedAmt"+index).val(settlement);
				 $("#afterAdjustment").val(0);
			 }else{
				 $("#adjusted"+index).text(deposit);
				 putDecimal_Text($("#adjusted"+index),17,noofdecimal);
				 $("#adjustedAmt"+index).val(deposit);
				 adjustedAmt=parseFloat(settlement)-parseFloat(deposit);
				 $("#afterAdjustment").val(adjustedAmt);
				 putDecimal_field($("#afterAdjustment").get(0),17,noofdecimal);				 
			 }
			 $("#payableAmount").val(adjustedAmt);
			 putDecimal_field($("#payableAmount").get(0),17,noofdecimal);
			 
		 
			 }else{
				 alert("Settlement Amount is already adjusted from existing deposits");
				 $(this).prop('checked', false);
			 }
		 }else{
			 var deposit= $("#deposit"+ (index) ).val();
			 var settlement= $("#afterAdjustment").val();	
			 var adjustedAmt=parseFloat(settlement)+parseFloat($("#adjustedAmt"+index).val());
			 $("#adjusted"+index).text(0);
			 putDecimal_Text($("#adjusted"+index),17,noofdecimal);
			 $("#adjustedAmt"+index).val(0);
			 $("#afterAdjustment").val(adjustedAmt);
			 $("#payableAmount").val(adjustedAmt);
			 putDecimal_field($("#payableAmount").get(0),17,noofdecimal);		
		 }
	  });
	 
 });
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


<HTML>
<HEAD>
<TITLE>Adjust from Deposit</TITLE>
</HEAD>
</HEAD>
<BODY>
<FORM name='BillSlmtDepositForm' id='BillSlmtDepositForm' id='BillSlmtDepositForm'>
<table  width='100%'> 
<tr>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.IRBSelect.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.IRBDocumentType.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.IRBDocumentNumber.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.Remarks.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.IRBDocumentSrNo.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.IRBSettlementType.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.IRBAmount.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.IRBAdjustedAmount.label" bundle="${bl_labels}"/></td>
</tr>
</table>
<div id="ageGroupTableDiv" STYLE="width:100%; height:100; overflow: auto;">
<table id='docTypeTable' width='100%'> 
<%


String patientid=request.getParameter("patientid");
String strfacilityid	=  (String) session.getValue("facility_id");
int count=0;

String beanId = "BillDetailsBean";
String beanName = "eBL.BLBillDetailsBean";
BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
System.out.println(billDtlMap);
ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");

StringBuilder docNumList=new StringBuilder();
for(BLBillDetailsBean beanObj:billDetailList ){
	docNumList.append("'");
	docNumList.append(beanObj.getDocNum());
	docNumList.append("'");
	docNumList.append(",");
}
docNumList.deleteCharAt(docNumList.length()-1);

System.out.println(docNumList);
System.out.println(billDetailList);


ARRAY slmt_by_svc_parameter_array = (ARRAY) session.getAttribute("deposit_parameter_array_session");
Object[] recievedArray=null;
if(slmt_by_svc_parameter_array!=null){
recievedArray = (Object[])(slmt_by_svc_parameter_array.getArray());
}

boolean depositAlreadyAdjustedFlag=false;


Connection con	=	ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs = null; 
String sql=BlRepository.getBlKeyValue("MULTI_BILL_SLMT_DEPOSIT_LIST");


System.out.println(sql);

try
{				
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,patientid);
	pstmt.setString(2,strfacilityid);
	pstmt.setString(3,patientid);
	pstmt.setString(4,strfacilityid);
	pstmt.setString(5,patientid);
	rs = pstmt.executeQuery();	

	while ( rs.next() && rs != null ) 
	{
	
		String docType=rs.getString(1);
		String docNumber=rs.getString(2);
		String docSrlNo=rs.getString(3);
		String slmtType=rs.getString(4);
		String deposit=rs.getString(5);
		String adjustedAmount="0";
		String checked="";
       		
		String remarks=BLHelper.getDescriptionViaSQL(con,BlRepository.getBlKeyValue("MULTI_BILL_SLMT_DEPOSIT_REMARK"),patientid,docType,docNumber);
		if(remarks==null) remarks="";
		
		if(recievedArray!=null){
		for(Object tmp : recievedArray) {
			if(tmp!=null){
			Struct row = (Struct) tmp;
			Object[] attribute = row.getAttributes();
			if(attribute[1]!=null && docNumber!=null ){
				if(docNumber.equals(attribute[1].toString()) && docSrlNo.equals(attribute[2].toString())){
					 docType=attribute[0].toString();
					 docNumber=attribute[1].toString();
					 docSrlNo=attribute[2].toString();
					 slmtType=attribute[3].toString();
					 deposit=attribute[4].toString();
					 adjustedAmount=attribute[5].toString();
					 remarks=attribute[6].toString();
					 checked="checked";
					 depositAlreadyAdjustedFlag=true;
				}
			 }
			}
		  }
		}
		
		%>
		<tr >
		<td class="fields"  width='10%'><input class='depositCheckClass' type="checkbox" value="true" <%=checked%>  name="adjustChk<%=count%>" id="adjustChk<%=count%>"> </td>
		<td class="fields"  width='15%'><%=docType%></td><input type='hidden' name="docType<%=count%>" id="docType<%=count%>"  id="docType<%=count%>" value='<%=docType%>'>
		<td class="fields"  width='15%'><%=docNumber%></td><input type='hidden' name="docNumber<%=count%>" id="docNumber<%=count%>"  id="docNumber<%=count%>" value='<%=docNumber%>'>
		<td class="fields"  width='20%'><input type="text" name="remarks<%=count%>" id="remarks<%=count%>"  id="remarks<%=count%>"  value='<%=remarks%>' maxlength='100' ></input></td><input type='hidden' name="remarks<%=count%>" id="remarks<%=count%>"  id="remarks<%=count%>" value='<%=remarks%>'>
		<td class="fields"  width='10%'><%=docSrlNo%></td><input type='hidden' name="docSrlNo<%=count%>" id="docSrlNo<%=count%>"  id="docSrlNo<%=count%>" value='<%=docSrlNo%>'>
		<td class="fields"  width='10%'><%=slmtType%></td><input type='hidden' name="slmtType<%=count%>" id="slmtType<%=count%>"  id="slmtType<%=count%>" value='<%=slmtType%>'>			
		<td class="fields"  width='10%'><%=formattedAmt(deposit)%></td><input type='hidden' name="deposit<%=count%>" id="deposit<%=count%>"  id="deposit<%=count%>" value='<%=formattedAmt(deposit)%>'>
		<td class="fields"  width='10%'><div id="adjusted<%=count%>"><%=formattedAmt(adjustedAmount)%></div></td>	<input type='hidden' name="adjustedAmt<%=count%>" id="adjustedAmt<%=count%>"  id="adjustedAmt<%=count%>" value='<%=formattedAmt(adjustedAmount)%>'>	
		</tr>
		<%
		count++;
	}	

}catch(Exception e) 
{   e.printStackTrace();
	System.out.println("Exception in bl_parameters query:"+e);
}finally{
	rs.close();
	pstmt.close();
}

if(count==0){%>
<script>
			alert("Patient Deposit Not Found");
			parent.window.returnValue="N";
			window.close();
</script>
		  <%}%>
</table>
<br>
</div>

<table  width='100%' >
<tr>
<td class="fields"  width='25%'></td>
<td class="fields"  width='25%'></td>
<td class="label" width='30%' ><fmt:message key="eBL.IRBAmountPayable.label" bundle="${bl_labels}"/></td>
<%
String payableAmount=request.getParameter("billslmtamtdet");
/*if(depositAlreadyAdjustedFlag==true){
payableAmount=formattedAmt((String)session.getAttribute("deposit_adjusted_payable_amount"));
}*/
%>
<td class="fields"  width='*'><input type="text" size=10 readonly name="payableAmount" id="payableAmount" id="payableAmount" value="<%=formattedAmt(payableAmount)%>"></td>
</tr>
</table>


<table  width='100%' >
<tr>
<td class="fields"  width='25%'></td>
<td class="fields"  width='25%'></td>
<td class="fields"   width='30%' ></td>
<td class="fields"  width='*'><input class='button' type="button" name='cancelDepositList' id='cancelDepositList' id='cancelDepositList' value='Cancel'></td>
<td class="fields"  width='*'><input class='button' type="button" name='selectedDepositList' id='selectedDepositList' id='selectedDepositList' value='Submit'></td>
</tr>
</table>

</BODY>
<input type="hidden" id="billslmtamtdet" value="<%=formattedAmt(request.getParameter("billslmtamtdet"))%>" >
<input type="hidden" id="afterAdjustment" value="<%=formattedAmt(request.getParameter("billslmtamtdet"))%>" >
<input type="hidden" id="submitBtn" name="submitBtn" id="submitBtn" value="<%=submitBtn %>">
</FORM>

</HTML>

