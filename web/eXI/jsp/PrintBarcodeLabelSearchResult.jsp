<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<%@ page import="java.sql.*,java.util.*,eXI.*,eXI.XIDBAdapter,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link href="../../eCA/Kendo/styles/kendo.common.min.css" rel='stylesheet' />
<link href="../../eCA/Kendo/styles/kendo.blueopal.min.css" rel='stylesheet' />
<link href="../../eCA/Kendo/styles/kendo.default.min.css" rel='stylesheet' />
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src="../../eCA/Kendo/js/jquery.min.js"  type="text/javascript"></script>
<script src="../../eCA/Kendo/js/kendo.all.min.js"  type="text/javascript"></script>	
<script src="../../eCA/js/ES_Kendo.js"  type="text/javascript"></script>


<script Language="Javascript">


/**** progress bar code ends ****/


var obj1;
function setObject(object1)
{
  obj1=object1;
  var current_row_id=obj1.getAttribute('current_row_id');
  document.forms[0].current_row_id.value=current_row_id;
}
function funAction(typ)
{  
	parent.frames[2].ORGWSITEMSTATUS_RESULTS.action_type.value = typ;
	funSubmit();
}
function funSubmit()
{
	parent.frames[2].ORGWSITEMSTATUS_RESULTS.action = '../../eXI/jsp/PrintBarcodeLabelSearchResult.jsp';
	parent.frames[2].ORGWSITEMSTATUS_RESULTS.target="f_query_add_mod_detail";
	parent.frames[2].ORGWSITEMSTATUS_RESULTS.submit();
}
function printQRcode(){
	if(obj1==null)
	{
      alert("Select any record to print.");
	  $("#print").removeClass("k-state-disabled");        
	  return false;
	}
     var hideFeatures	= "toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10000, top=10000, width=4, height=4, visible=none ";
	 var arguments	= "" ;
     var pb = $("#progressBar").data("kendoProgressBar");
     pb.value(0);
     clearInterval(100);



    var current_row_id=obj1.getAttribute('current_row_id');
	var barcode_qty_eval = eval("document.forms[0].barcode_qty"+current_row_id);
	var barcode_qty_value = "0";
	if(barcode_qty_eval!=undefined)
	{
      barcode_qty_value = barcode_qty_eval.value;
	}
	//alert("barcode_qty_value....."+barcode_qty_value);
	var item_name = obj1.getAttribute('item_desc');
	var batch_id = obj1.getAttribute('batch_id');
	var expiry_date = obj1.getAttribute('expiry_date');
	var barcode_id = obj1.getAttribute('barcode_id');
	var item_code = obj1.getAttribute('item_code');
	var dataElements = "itemname="+item_name+"&batchid="+batch_id+"&expdate="+expiry_date+"&barcode_qty="+barcode_qty_value+"&barcode_id="+barcode_id+"&printQty="+barcode_qty_value+"&item_code="+item_code;
	var dialogHeight = "4";			    
	var dialogWidth  = "4";
	var dialogTop    = "300";
	var dialogLeft   = "500";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	var url = "../../eXH/jsp/XHBarcodePrinting.jsp?" + dataElements;
	//parent.frames[3].document.location.href='../../eXH/jsp/XHBarcodePrinting.jsp?'+ dataElements;
    var ret = window.open(url,arguments, hideFeatures);
    for(var i=0;i<barcode_qty_value;i++)
	{
		if (pb.value() < barcode_qty_value) {
			pb.value(pb.value() + 1);	              
		} 
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="ORGWSITEMSTATUS_RESULTS" id="ORGWSITEMSTATUS_RESULTS" method="POST" action=''  >

	<%										 
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "PRINTITEMBARCODE";

			String item_code = "";
            String grn_num = "";

            String status = "";
			String searchCriteria = "GRN";
			Connection conn = null;
			String whereClause = "";
			String orderByColumns="";

			String sap_num = "";
			String facility_id = "";
			String grn_from_date = "";
            String grn_to_date = "";
			String grn_sort_by = "";
			String grn_sort_order = "";

			try
			{
				grn_num=XIDBAdapter.checkNull(request.getParameter("grn_num"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_num : "+grn_num);
				item_code=XIDBAdapter.checkNull(request.getParameter("item_code"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: item_code : "+item_code);
				searchCriteria=XIDBAdapter.checkNull(request.getParameter("searchCriteria"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: searchCriteria : "+searchCriteria);

				sap_num=XIDBAdapter.checkNull(request.getParameter("sap_num"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: sap_num : "+sap_num);

				facility_id=XIDBAdapter.checkNull(request.getParameter("facility_id"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: facility_id : "+facility_id);
				
				grn_from_date=XIDBAdapter.checkNull(request.getParameter("grn_from_date"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_from_date : "+grn_from_date);

				grn_to_date=XIDBAdapter.checkNull(request.getParameter("grn_to_date"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_to_date : "+grn_to_date);
						
				grn_sort_by=XIDBAdapter.checkNull(request.getParameter("grn_sort_by"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_sort_by : "+grn_sort_by);

				grn_sort_order=XIDBAdapter.checkNull(request.getParameter("grn_sort_order"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_sort_order : "+grn_sort_order);
				
				if(searchCriteria!=null && searchCriteria.equals("ITEMCODE"))
				{
                    qry_id = "PRINTBARCODEITEMBASED";
				}
				else
				{
                    qry_id = "PRINTITEMBARCODE";
				}
                 
				/* whereClause = " where a.ITEM_CODE = b.ITEM_CODE and a.ITEM_CODE = c.ITEM_CODE and a.BATCH_ID = c.BATCH_ID and a.store_code = c.store_code and a.bin_location_code = c.bin_location_code and to_date(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') = to_date(A.EXPIRY_DATE,'DD/MM/YYYY') and c.QTY_ON_HAND > 0"; */

				whereClause = " WHERE a.ITEM_CODE=b.ITEM_CODE  ";
				
				
				/* and c.QTY_ON_HAND > 0 Condition has been removed for the SCF GHL-SCF-1288 by Sethu on 01/02/2018. */ 

				/* Facility ID Condition has been added for the SCF GHL-SCF-1288.1 by Sethu on 04/05/2018. */

				if(facility_id!="" && facility_id!=null) 
				{
				   whereClause=whereClause+" AND a.FACILITY_ID='"+facility_id+"'";
				}


				if(sap_num!="" && sap_num!=null)
				{
				   whereClause=whereClause+" AND a.DOC_REF=NVL('"+sap_num+"',a.DOC_REF)";
				}


				if(grn_num!="" && grn_num!=null)
				{
				   whereClause=whereClause+" AND a.IBA_DOC_NUM=NVL('"+grn_num+"',a.IBA_DOC_NUM)";
				   
				}
				
				if(item_code!="" && item_code!=null)
				{
				   whereClause=whereClause+" AND a.ITEM_CODE=NVL('"+item_code+"',a.ITEM_CODE)";
				   
				}

				if((grn_from_date!="" && grn_from_date!=null) && (grn_to_date!="" && grn_to_date!=null))
				{
				   whereClause=whereClause+" AND a.DOC_DATE BETWEEN TO_DATE('"+grn_from_date+"','DD/MM/YYYY') AND TO_DATE('"+grn_to_date+"','DD/MM/YYYY')";
				  
				}

				if(grn_sort_by!="" && grn_sort_order!=null)
				{
					orderByColumns = " ORDER BY a."+grn_sort_by;
				}
				
				if(grn_sort_order!="" && grn_sort_order!=null)
				{
					if(grn_sort_order.equals("A")){
						//orderByColumns=orderByColumns.substring(0,orderByColumns.length()-1);
						orderByColumns=orderByColumns+" ASC";
					}
					else{
						//orderByColumns=orderByColumns.substring(0,orderByColumns.length()-1);
						orderByColumns=orderByColumns+" DESC";
					}

				}

                System.out.println("PrintBarcodeLabelSearchResult.jsp:::: whereClause : "+whereClause);
				System.out.println("PrintBarcodeLabelSearchResult.jsp:::: orderByColumns : "+orderByColumns);
				request.setAttribute(XIQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XIQueryRender.col,"12");
				request.setAttribute(XHQueryRender.maxRec,"8");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				request.setAttribute(XHQueryRender.orderByColumns,orderByColumns);
				conn = ConnectionManager.getConnection(request);				
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
					strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				}
				else
				{
					strNext  = " ";
				}
		%>
	<input type='hidden' name='action_type' id='action_type' value=''>

    <input type='hidden' name='facility_id' id='facility_id' value=''>
	<input type='hidden' name='doc_type_code' id='doc_type_code' value=''>
	<input type='hidden' name='his_grn_no' id='his_grn_no' value='<%=grn_num %>'>
	<input type='hidden' name='sap_grn_no' id='sap_grn_no' value=''>
	<input type='hidden' name='doc_date' id='doc_date' value=''>
	<input type='hidden' name='item_code' id='item_code' value='<%=item_code %>'>
	<input type='hidden' name='item_desc value=' id='item_desc value=''>
	<input type='hidden' name='batch_id' id='batch_id' value=''>
	<input type='hidden' name='item_qty' id='item_qty' value=''>
	<input type='hidden' name='grn_item_qty' id='grn_item_qty' value=''>
	<input type='hidden' name='expiry_date' id='expiry_date' value=''>
	<input type='hidden' name='current_row_id' id='current_row_id' value=''>
	<input type='hidden' name='barcode_id' id='barcode_id' value=''>
	<input type='hidden' name='searchCriteria' id='searchCriteria' value="<%=searchCriteria%>">

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>

<%
if(arrRow.size()==0)
{
%>

<script>
//alert("APP-XI0021 Query caused no records to be retrived");
alert(getMessage('XH1021','XH'));
parent.frames[2].document.location.href='../../eCommon/html/blank.html';

</script>

<% } else { %>
	<tr>
	<td colspan="10" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='8%'><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='10%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  width='10%'>HIS GRN No</td> 
	<td class='COLUMNHEADER'  width='10%'>SAP GRN No</td>
	<td class='COLUMNHEADER'  width='10%'>GRN DATE</td>
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Expiry.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'>GRN QTY</td>
	<td class='COLUMNHEADER'  width='25%'>BARCODE QTY</td>	
</tr>

	<%
		System.out.println("arrRow.size()......"+arrRow.size());
	int i=1;
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
	%>

	<tr>
	<td <%=strTDClass%> align="left"> 
	<input id=item_sr_no type=radio name=item_sr_no id=item_sr_no value="<%=j %>" onClick='setObject(this)' current_row_id='<%=i %>' facility_id='<%=arrCol.get(0)+""%>' doc_type_code='<%=arrCol.get(1)+""%>' doc_date='<%=arrCol.get(3)+""%>' sap_grn_no='<%=arrCol.get(4)+""%>' his_grn_no='<%=arrCol.get(5)+""%>'  item_code='<%=arrCol.get(6)+""%>' item_desc='<%=arrCol.get(7)+""%>' batch_id='<%=arrCol.get(8)+""%>' grn_item_qty='<%=arrCol.get(9)+""%>' expiry_date='<%=arrCol.get(10)+""%>' barcode_id='<%=arrCol.get(11)+""%>'>
		<%=j+1 %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(6) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(7) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(5) %> 
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(4) %>
	</td>
	<td
	<%=strTDClass%> align="left"> 
	<%=""+arrCol.get(3) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(8) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(10) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(9) %> 
	</td>
	<td <%=strTDClass%> align="left"> 
	<input name="barcode_qty<%=i%>" id="barcode_qty<%=i%>" type='text' value="<%=arrCol.get(9)%>">
	</td>
	
	</tr>
	<%
		i++;
	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		e1.printStackTrace();
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>

	</table>
	<table width='100%'>
		<tr align='right'>
          <td align='right'> <img src="../../eCommon/images/Rprint.gif"
						alt="Print" onClick="createProgressBar()" name='print' id='print'
			 			onMouseOver="src='../../eCommon/images/RRprint.gif'"
			 			onMouseOut="src='../../eCommon/images/Rprint.gif'" style="align:right"> </td>
		</tr>
	</table>

	<div class="demo-section" id="demo">
	        <div id="progressBar"></div>        
	    </div>

</form>

<script>

/**** progress bar code ****/

$("#print").click(function () {
	        if (!$(this).hasClass("k-state-disabled")) {
	            $(this).addClass("k-state-disabled");
	            printQRcode();            
	        }
	    });
	 	
	 	function createProgressBar() {
			var current_row_id=document.forms[0].current_row_id.value;
		     if(current_row_id==null || current_row_id=="")
			{
                return false;
			}	
			var barcode_qty_eval = eval("document.forms[0].barcode_qty"+current_row_id);
			var barcode_qty_value = "0";
			if(barcode_qty_eval!=undefined)
			{
			  barcode_qty_value = barcode_qty_eval.value;
			}
	 		var pb = $("#progressBar").data("kendoProgressBar");

	 		if (pb != null ){				
				$("#progressBar").data("kendoProgressBar").destroy();
				$("#demo").empty().append("<div id='progressBar'></div>");				
			}
			$("#progressBar").kendoProgressBar({
	            min: 0,
	            max: barcode_qty_value,
	            type: "percent",
	            change: onChange,
	            complete: onComplete,
	            enable: false

	        });
			
		}	

	    function onChange(e) {
	        
	    }

	    function onComplete(e) {
			alert("Process Completed");
	        $("#print").removeClass("k-state-disabled");        
	    }

</script>

<style scoped>
        #progressBar {
        	margin-top: 10px;
            width: 440px;
            margin-bottom: 10px;
        }  
        .demo-section {
            width: 100%;
            text-align: center;
        }
              
</style> 


</body>

</html>

