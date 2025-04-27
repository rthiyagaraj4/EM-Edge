<!DOCTYPE html>
<%@ page import="eBL.*,oracle.sql.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language="javascript"     src="../../eCommon/js/ValidateControl.js"></script> 
<script>

$(document).ready(function(){   

	$(".rectypebuttonclass").click(async function(){
		
		var index = $('#BillSlmtReceiptListTable tr').index($(this).closest('tr'));
		var locale = $("#locale").val();
		var facilityId=$("#facilityId").val();
		var episodeType=$("#episodeType"+index).val();
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var sql 		   = '';
		var title 		   = 'Receipt Type';
 		sql =
		 " Select description, code from ( "+
		 " (SELECT long_desc description,receipt_type_code code "+
    	 " FROM bl_receipt_type_lang_vw "+
    	 " WHERE UPPER (language_id) = UPPER ('"+locale+"') "+
    	 " AND acc_entity_code IN (SELECT acc_entity_code "+
    	                        "     FROM sy_acc_entity "+
    	                        "    WHERE acc_entity_id = '"+facilityId+"') "+
    	             "  AND NVL (status, 'X') <> 'S' "+
    	             "  AND recpt_nature_code = 'BI'  ) "+
    	             "  )where upper(description) like upper(?) and upper(code) like upper(?) order by 2";	  

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = "";
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		var retval = await CommonLookup(title, argumentArray );
		if((retval != null) && (retval != "") )  {
			var ret1 = unescape(retval);
			arr = ret1.split(",");	
			$("#recType"+index).val(arr[0]);
		}
	});	  
	
	$("#cancelReceiptTypes").click(function(){
		//window.close();
		parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
	});

	
	$("#saveReceiptTypes").click(function(){
				  $.ajax({
                    url:"../../eBL/jsp/BLBillSlmtReceiptTypeStorage.jsp",
                    type: 'post',
                    data: $("#BillSlmtReceiptListForm").serialize(), 
                    success: function(data) {
                        var obj = jQuery.parseJSON(data);  
                        if(obj.flag=="SUCCESS"){
                        //	window.close();
                        parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
                        }
                    }
		          }); 
	});
	
});


</script>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 
		String locale	= (String)session.getAttribute("LOCALE");
		String facility_id	= (String)session.getAttribute("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<HTML>
<HEAD>
<TITLE>Modify Receipt Details</TITLE>
</HEAD>
</HEAD>
<BODY>
<FORM name='BillSlmtReceiptListForm' id='BillSlmtReceiptListForm' id='BillSlmtReceiptListForm'>
<table align='center' width='100%'> 
<tr>
	<td width="25%" class='COLUMNHEADER'><fmt:message key="eBL.IRBBillNo.label" bundle="${bl_labels}"/></td>
	<td width="25%" class='COLUMNHEADER'><fmt:message key="eBL.RECEIPT_TYPE.label" bundle="${bl_labels}"/></td>
<%-- 	<td width="25%" class='COLUMNHEADER'><fmt:message key="eBL.ACCOUNT_CODE.label" bundle="${bl_labels}"/></td> --%>
<%-- 	<td width="25%" class='COLUMNHEADER'><fmt:message key="Common.department.label" bundle="${common_labels}"/></td> --%>
</tr>
</table>
<div id="BillSlmtReceiptListTableDiv" STYLE="width:100%; height:200; overflow: auto;">
<table id='BillSlmtReceiptListTable'   width='100%'> 
<% 
Connection con	=	ConnectionManager.getConnection(request);
String beanId = "BillDetailsBean";
String beanName = "eBL.BLBillDetailsBean";
BLBillDetailsBean beanObj=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=beanObj.getBillDtlMap();
ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
int count=0;
for(BLBillDetailsBean bean :billDetailList){
%>
<tr>
<td class="fields"  width='25%'><input type='hidden' name="docNum<%=count%>" id="docNum<%=count%>" id="docNum<%=count%>" value="<%=bean.getDocNum()%>"><%=bean.getDocTypeCode()%>/<%=bean.getDocNum()%></td>
<td class="fields"  width='25%'><input type='hidden' name="episodeType<%=count%>" id="episodeType<%=count%>" id="episodeType<%=count%>"  value="<%=bean.getEpisodeType()%>"> 
<input type='text' name="recType<%=count%>" id="recType<%=count%>" readonly id="recType<%=count%>"  value="<%=bean.getReceiptTypeCode()%>"><input type='button' class="rectypebuttonclass" name="recTypeBut" id="recTypeBut" value='?'></td>
<%-- <td class="fields"  width='25%'><input type='text' name="extAccCode<%=count%>" id="extAccCode<%=count%>" readonly id="extAccCode<%=count%>"  value="<%=bean.getExtAccCode()%>"><input type='button' class="accCodeButtonclass" name="accCodeBut" id="accCodeBut" value='?'></td> --%>
<%-- <td class="fields"  width='25%'><input type='text' name="extAccDept<%=count%>" id="extAccDept<%=count%>" readonly id="extAccDept<%=count%>"  value="<%=bean.getExtAccDept()%>"><input type='button' class="accDeptButtonclass" name="accDeptBut" id="accDeptBut" value='?'></td> --%>
</tr>
<%
count++;
} %>
</table>
</div>
<table  width='100%'> 
<tr>
	<td width="80%"/>
	<td width="10%"><input class='button' type="button"  id='cancelReceiptTypes' value='Cancel'></td>
	<td width="10%"><input class='button' type="button" id='saveReceiptTypes' value='Save'></td>
</tr>
</table>

<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="facilityId" id="facilityId" id="facilityId" value="<%=facility_id%>">
</FORM>
</BODY>
</HTML>
</div>

