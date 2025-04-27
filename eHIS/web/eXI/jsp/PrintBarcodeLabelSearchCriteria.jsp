<!DOCTYPE html>
<%@page
	import="java.util.*,eST.*,eST.Common.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
<HTML>
<script language="javascript">

</script>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%											 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//	System.out.println("p_facility_id : "+p_facility_id);
String selected = "";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXI/js/Validate.js" ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eXI/js/ViewGRNS.js'></script>
<script language="JavaScript">

function searchGRN(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("eST.GRN.label","ST");			
            var target=this.document.forms[0].grn_num;
            var sap_num=this.document.forms[0].sap_num;
			var supp_name=this.document.forms[0].supplier;
			var grn_num_1=this.document.forms[0].grn_num_1; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018 Added.

			var facility_id=this.document.forms[0].facility_id.value; // Added by Sethu for GHL-SCF-1288.1 on 08/05/2018
			
		    sql="SELECT DISTINCT IBA_DOC_NUM code,DOC_REF description FROM xi_trn_grn WHERE  FACILITY_ID = '"+facility_id+"' and UPPER(IBA_DOC_NUM) LIKE UPPER(?) AND UPPER(DOC_REF) LIKE UPPER(?) ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;

            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                sap_num.value=arr[1];
				grn_num_1.value=arr[0]; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018
                target.value=arr[1];// arr[0] Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018
				var sup=getSupplierName(arr[0]); // target.value Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018
				if(sup!=undefined && sup!=null)
				{
					supp_name.value=sup;
				}
				else
				{
                   supp_name.value="";
				}
				
            }
            else{
                target.value=tcode; // tdesc Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018
				grn_num_1.value=tdesc; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018
                sap_num.value=tcode;
				supp_name.value="";
            }
			
}// End of searchGRN


function searchItemCode(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.ItemCode.label","Common");			
            var target=this.document.forms[0].item_code_desc;
            var item_code=this.document.forms[0].item_code;
			
		    sql="SELECT ITEM_CODE code,SHORT_DESC description FROM mm_item WHERE  UPPER(ITEM_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";
			
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;

            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                item_code.value=arr[0];
                target.value=arr[1];
            }
            else{
                target.value=tdesc;
                item_code.value=tcode;
            }
}// End of searchItemCode

function getSupplierName(hisGrnNum) {
	var responseText="";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " iba_doc_num=\""+hisGrnNum+"\"";   		  
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","XIUtil.jsp?func_mode=getSupplierName",false);		   
		xmlHttp.send(xmlDoc);		
		responseText = trimString(xmlHttp.responseText);
		//alert(responseText);
		return responseText;
}
function checkDate() {
   var selectedText = document.getElementById('datepicker').value;
   var selectedDate = new Date(selectedText);
   var now = new Date();
   if (selectedDate < now) {
    alert("Date must be in the future");
   }
 }
function compare(date1,date2) 
{
		var fromarray;
 		var toarray;
 		var frmdat = date1;
		var todat=date2;
		var d =  new Date(); 
		fromarray =frmdat.split("/");
		toarray=todat.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
     
	
		 if((frmdat.length > 0) &&(todat.length>0))
		 {
			if(Date.parse(todt) < Date.parse(fromdt))
			{
				alert(getMessage("XH1009","XH"));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		 }	
		 else return true;
		      
			
}
function getResults()
{
	var grn_num=document.forms[0].grn_num_1.value; //grn_num Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018
	var item_code=document.forms[0].item_code.value; 
	var facility_id=document.forms[0].facility_id.value; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018
	var sap_num=document.forms[0].sap_num.value; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018
	var grn_from_date=document.forms[0].grn_from_date.value; // Added by Apoorva for GHL-SCF-1288.1 on 11/02/2020
	var grn_to_date=document.forms[0].grn_to_date.value; // Added by Apoorva for GHL-CRF-610 on 11/02/2020
	var grn_sort_by=document.forms[0].grn_sort_by.value; // Added by Apoorva for GHL-CRF-610 on 11/02/2020
	var grn_sort_order=document.forms[0].grn_sort_order.value; // Added by Apoorva for GHL-CRF-610 on 11/02/2020
	var grn_from = new Date(grn_from_date);
	var grn_to = new Date(grn_to_date);

	parent.frames[2].document.location.href='../../eCommon/html/blank.html';

	var checkdate = true;
	if(grn_from_date != 0 && grn_to_date != 0){
		checkdate = false;
		checkdate = compare(grn_from_date,grn_to_date);
	}
	else if(grn_from_date != 0 && grn_to_date == 0){
		checkdate = false;
		alert("Please Enter GRN To Date");

	}
	else if(grn_to_date != 0 && grn_from_date == 0){
		checkdate = false;
		alert("Please Enter GRN From Date");
	}
	
	if (checkdate)
	{
		parent.frames[2].document.location.href='../../eXI/jsp/PrintBarcodeLabelSearchResult.jsp?grn_num='+grn_num+'&item_code='+item_code+'&facility_id='+facility_id+'&sap_num='+sap_num+'&grn_from_date='+grn_from_date+'&grn_to_date='+grn_to_date+'&grn_sort_by='+grn_sort_by+'&grn_sort_order='+grn_sort_order;
	}
}

function clear22()
{
	parent.f_query_add_mod.location.reload();
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';
}


</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<%

String mode			= "";
String item_code	= "";
String item_desc	= "";
String status			= "";
String strStDate = "", strEndDate = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try 
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') STDATE,TO_CHAR(SYSDATE,'DD/MM/YYYY') EDDATE FROM DUAL");
	rs = pstmt.executeQuery();
	if (rs != null && rs.next()) 
	{
		strStDate = rs.getString(1);
		strEndDate = rs.getString(2);
	}
} 
catch (Exception e1) 
{
	e1.printStackTrace(System.err);
	System.out.println(" Error in Criteria Page " + e1.getMessage());
} 
finally 
{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (con != null) ConnectionManager.returnConnection(con, request);
}
%>
	

<form name="printbarcodelabel_form" id="printbarcodelabel_form" target='f_query_add_mod_detail' method='post' >


<fieldset style=" border-color:grey;">
<table width="100%">
	<tr >
		<td class="LABEL" nowrap align='left' width='10%'>
			<fmt:message key="eST.GRN.label" bundle="${st_labels}" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='text' name='grn_num' id='grn_num' value='' size='20' onBlur="searchGRN()">
			<input type='hidden' name='sap_num' id='sap_num' value='' >
			<input type='hidden' name='grn_num_1' id='grn_num_1' value='' >
			<input class="BUTTON" type="button"  name=grn_search value='?'  onClick="searchGRN()" >
		</td>		
		<td class="LABEL" nowrap align='left' width='10%'>
			<fmt:message key="Common.Supplier.label" bundle="${common_labels}" />&nbsp;
			<input type='text' name='supplier' id='supplier' value='' size='20' readonly disabled>
		</td>
	
		<td class="LABEL" nowrap align='left'  width='10%'>
			<fmt:message key="Common.ItemCode.label" bundle="${common_labels}" />
			<input type='text' name='item_code_desc' id='item_code_desc' value='' size='20' onBlur="searchItemCode()">
			<input type='hidden' name='item_code' id='item_code' value=''>
			<input class="BUTTON" type="button"  name=itemCode_search value='?' onClick="searchItemCode()" >
		</td>
		
	</tr>
	
	<tr>
		<td class="LABEL" nowrap align='left' width='10%'>
			<fmt:message key="Common.GRNFromDate.label" bundle="${common_labels}" />
			&nbsp;
			<input type='text' name='grn_from_date' id='grn_from_date' value='13/02/2020' size='10' maxLength='10' onKeyPress="return AllowDateFormat()" onBlur="CheckValidDate(this);checkWithSysDate(this);checkDateRange(this,to_date_time);">
			<input type='image' id="frcal" name="frcal" id="frcal" src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('grn_from_date');">
			&nbsp;
			<fmt:message key="Common.GRNToDate.label" bundle="${common_labels}" />	
			&nbsp;
			<input type='text' name='grn_to_date' id='grn_to_date' " value='13/02/2020' size='10' maxLength='10' onKeyPress="return AllowDateFormat()" onBlur="CheckValidDate(this);checkWithSysDate(this);checkDateRange(from_date_time,this);">
			<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('grn_to_date');">
		</td>
		<td class="LABEL" nowrap align='left' width='10%'>
			<fmt:message key="ePH.Sortby.label" bundle="${ph_labels}"/>
			&nbsp; 
			<select name='grn_sort_by' id='grn_sort_by'>
				<option value="DOC_DATE">GRN Date</option>
				<option value="IBA_DOC_NUM">GRN</option>
				<option value="ITEM_CODE">Item Code</option>
			</select>
			&nbsp; 
			<fmt:message key="Common.SortOrder.label" bundle="${common_labels}" />
			&nbsp;
			<select name='grn_sort_order' id='grn_sort_order'>
				<option value="A">Ascending</option>
				<option value="D">Descending</option>
			</select>
		</td>
		<td  width='10%'>&nbsp;&nbsp;&nbsp;&nbsp; </td>
	</tr>
	<tr>	
		<td  width='10%'>&nbsp;&nbsp;&nbsp;&nbsp; </td>
		<td  width='10%'>&nbsp;&nbsp;&nbsp;&nbsp; </td>
		<td  width='10%' align="right"> 
				<input class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="getResults()" type="button" >
				<input class="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clear22()" type="button" >
		</td>	
	</tr>
	
</table>
</fieldset>

<input type='hidden' name='facility_id' id='facility_id' value='<%=p_facility_id%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=strEndDate%>'>
<input type='hidden' name='st_date' id='st_date' value='<%=strStDate%>'>
</form>
</BODY>
</HTML> 

