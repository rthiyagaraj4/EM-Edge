<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page  import="eBL.*,eBL.Common.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" 			contentType="text/html;charset=UTF-8" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@page import="eBL.billreceipt.model.BLBillGenInterfaceInBean"%>
<%@page import="eBL.billreceipt.model.BLBillGenInterfaceBean"%>

<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.Common.BlRepository"%>

    <!--  By Vijay  -->
<html>
<head>
<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}





private String qtyDecimal(String input)
{
		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
}

%>
<% 

try
{
Connection con=null;
 ResultSet rs=null;
 
 String classval="label";
PreparedStatement pstmt=null;
try{
	
	HttpSession httpSession = request.getSession(false);				
	con	=	ConnectionManager.getConnection(request);		
	 
}catch(Exception e)
{
	System.out.println("Exception in e"+e);
	e.printStackTrace();
	
}
%>

<%
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
int constCount = 50;
String nextYn = "N";
String prevYn = "N";
String traversal = "N";
String fromRcrd = "";
String toRcrd = "";
int startIndex = 0;
int startRcrd = 0;
int endRcrd = 0;
int totalRecord=0;
int total=0;
//int rowIndx=1;
SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	System.out.println("in jsp 1");
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	System.out.println("in jsp 2"+fromRcrd);
	System.out.println("in jsp 3"+toRcrd);
	if(fromRcrd == null || "".equals(fromRcrd)){
		System.out.println("in jsp 111111111"+fromRcrd);
		startRcrd = 1;
	}
	else{
		System.out.println("in jsp 211111111"+fromRcrd);
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	System.out.println("in jsp 2"+fromRcrd);
	System.out.println("in jsp 3"+toRcrd);
		

%>

<%
String facilityId=(String) session.getValue("facility_id");
String locale	= (String)session.getAttribute("LOCALE");	
String episodeId=request.getParameter("episode_id");
String visitId=request.getParameter("visit_id");
String records=request.getParameter("records");
String modules=request.getParameter("modules");
String prModule=request.getParameter("prmodule");
String pRModule=request.getParameter("pr_module");
String prKeyMain=request.getParameter("prkeymain");
String episodeType=request.getParameter("episode_type");
String patient=request.getParameter("patient");
String patientNo=request.getParameter("patient_no");
String encounter=request.getParameter("encounter");
String serviceLocationCode=request.getParameter("service_location_code");
String serviceLocationDesc=request.getParameter("service_location_desc");
String encounterFromDate=request.getParameter("encounter_from_date");
String encounterToDate=request.getParameter("encounter_to_date");
String moduleId=request.getParameter("module_id");
String siteId=request.getParameter("site_id");
String futureYn = request.getParameter("futureYn");
	
 // total = Integer.parseInt(total);
//System.out.println(" totalRecords"+ total);


if(startRcrd>1){
	System.out.println("sguu"+startRcrd);
	prevYn = "Y";
	traversal = "Y";
}

if((startRcrd+constCount) < totalRecord){
	System.out.println("suguuuuu"+startRcrd+constCount);
	nextYn = "Y";
	traversal = "Y";
}	


try{







}catch(Exception e)
{
	System.err.println("Exception in BLBillGenInterfaceInBean "+ e);
	e.printStackTrace();
}


%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eBL/js/BLBillGenInterfaceJs.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language='javascript' src='../js/BLDepositReceipt.js'></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<style>
div.tableContainer {
	width: 100%;		/* table width will be 99% of this*/
	height: 160px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}	
		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.LABEL1
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  /*TEXT-ALIGN: LEFT;*/
  TEXT-ALIGN: RIGHT;
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
		PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
		
		.ordered{
		width: 12.5px;
		height: 03px;
		background: #5A0000;
	}
	.registered{
		width: 12.5px;
		height: 03px;	
		background: #000080;
	}
	.completed{
		width: 12.5px;
		height: 03px;
		background: #FFFF00;
	}
	.resulted{
		width: 12.5px;
		height: 03px;
		background: #00FF00;
	}
		
	
	</style>
<script>

$(document).ready(function(){
		
		parent.dummy_frame.location.href=  '../../eCommon/html/blank.html';
		
	var site_id=$('#site_id').val();
	
/*	if(site_id=='ALMO')
		{
		$('#hdr').text('Not Charged');		
		}
	else
		{
		$('#hdr').text('Future Order');
		}
*/

	
		var indx=$('#bilgeninterface tr:last ' ).attr('data-id');
		//alert(indx);
	/*	if(indx==0 || indx==undefined)
			{
			//alert('1');
			$('#detailshdr').hide();
			$('#colorstatus').hide();
			}
		
		
		*/
	
	
	
		$('td[id^=row_billInterface]').each(function(){
			$(this).hide();
		});

		if($('#traverse').val() == 'Y'){
			$('#trProgress').show();
		}else{
			$('#trProgress').hide();
		}
		
		if($('#hdnNextSpan').val() == 'Y'){
			
			$('#nextSpan').show();
		}else{
			
			$('#nextSpan').hide();
		}
		
		if($('#prevSpan').val() == 'Y'){
			$('#previousSpan').show();
		}else{
			$('#previousSpan').hide();
		} 
		
		$('#nextSpan').click(function(){
			var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
			var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
			document.location.href = "BLBillGenInterfaceSearchResult.jsp?facility_name="+$('#hdnfacility_name').val()+
			"&records="+$('#hdnrecords').val()+
			"&modules="+$('#hdnmodules').val()+
			"&prmodule="+$('#hdnprmodule').val()+
			"&service_location_code="+$('#hdnserviceLocationCode').val()+
			"&service_location_desc="+$('#hdnserviceLocationdesc').val()+
			"&patient="+$('#hdnpatient').val()+
			"&patient_no="+$('#hdnpatient_no').val()+
			"&encounter_from_date="+$('#hdnencounter_from_date').val()+
			"&encounter_to_date="+$('#hdnencounter_to_date').val()+
			"&episode_type="+$('#hdnepisode_type').val()+										
			"&encounter="+$('#hdnencounter').val()+
			"&episode_id="+$('#hdnepisode_id').val()+
			"&fromRcrd="+startFrom+
			"&toRcrd="+endWith+
			"&total="+$('#total').val();
		});
	
		$('#previousSpan').click(function(){
			
			var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
		
			var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
		
			document.location.href = "BLBillGenInterfaceSearchResult.jsp?facility_name="+$('#hdnfacility_name').val()+
			"&records="+$('#hdnrecords').val()+
			"&modules="+$('#hdnmodules').val()+
			"&prmodule="+$('#hdnprmodule').val()+
			"&service_location_code="+$('#hdnserviceLocationCode').val()+
			"&service_location_desc="+$('#hdnserviceLocationdesc').val()+
			"&patient="+$('#hdnpatient').val()+
			"&patient_no="+$('#hdnpatient_no').val()+
			"&encounter_from_date="+$('#hdnencounter_from_date').val()+
			"&encounter_to_date="+$('#hdnencounter_to_date').val()+
			"&episode_type="+$('#hdnepisode_type').val()+										
			"&encounter="+$('#hdnencounter').val()+
			"&episode_id="+$('#hdnepisode_id').val()+
			"&fromRcrd="+startFrom+
			"&toRcrd="+endWith+
			"&total="+$('#total').val();
		});
		
			
});




	function selected(i)
		{				
			var selected_row=eval("document.forms[0].selected_row"+i);		
			if(selected_row.checked==false)
			{	
			selected_row.checked=false;
			document.blinterfacesearchresult.checked_row.value="";				
			}
			else
			{					
				var total_records=document.forms[0].total_records.value;					
				for(var j=0;j<total_records;j++)
				{ 
					var temp=eval("document.blinterfacesearchresult.selected_row"+j);					
					temp.checked=false;
		        }
			selected_row.checked=true;				
			document.forms[0].checked_row.value=i;
			}
			if(selected_row.checked)
			{
			  selected_row.value="1";	
			}
			else
			{
				selected_row.value="1";	
			}
		}	
		


</script>



</head>
<body onLoad='populate_btm_frame(1);'> 
<fieldset>
<Form name='blinterfacesearchresult' id='blinterfacesearchresult'  id='blinterfacesearchresult'>
  
	<div id="tableContainer">
	
	
			<% 
				%>
			<table id='bilgeninterface' border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>
			<thead>	
					
<tr style="background-color: white; border: none;" id='trProgress'>
	
			<td colspan='12' nowrap="nowrap">
				&nbsp;
			</td>
					<td colspan='1' nowrap="nowrap">
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;">
							<span id='previousSpan'>Previous</span>
						</span>
					</td>
					<td colspan='1' nowrap="nowrap">
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;">
							<span id='nextSpan'>Next</span>
						</span>
					</td>				
			</tr>
			 
			
			
		<tr>
		  <td  class='COLUMNHEADER' width='10%' align="center">Process All<input type='checkbox' id='select_all' name='select_all' id='select_all' onclick="fnSelectAll()"></td>
				  <td class='COLUMNHEADER'  width='05%' id='colorstatus' align="center">Current Stage</td>	
				
				<td class='COLUMNHEADER' width='10%' align="center"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='11%' align="center"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>					
				<td class='COLUMNHEADER' width='10%' align="center"><fmt:message key="eBL.PhysicianId.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='07%' align="center"><fmt:message key="eBL.BLNG_SERV_CODE.label" bundle="${bl_labels}"/></td>					
				<td class='COLUMNHEADER' width='06%' align="center"><fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='06%' id='row_billInterfaceH1' align="center"><fmt:message key="eBL.PrimaryKey.label" bundle="${bl_labels}"/></td>		
				<td class='COLUMNHEADER' width='06%' id='row_billInterfaceH2' align="center"><fmt:message key="Common.Line.label" bundle="${common_labels}"/></td>	
				<td class='COLUMNHEADER' width='10%' id='row_billInterfaceH7'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%' id='row_billInterfaceH3' align="center" ><fmt:message key="eBL.SecondaryKey.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='05%' id='row_billInterfaceH4' align="center"><fmt:message key="Common.Line.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%' align="center"><fmt:message key="eBL.ServiceItemcode.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%' align="center"><fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%' align="center"><fmt:message key="eBL.InterfacedDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%' id='row_billInterfaceH5' align="center"><fmt:message key="eBL.Charged.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%' align="center"><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%' align="center"><fmt:message key="eBL.Discount.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%' align="center"><fmt:message key="eBL.NET_CHARGE.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'  id='row_billInterfaceH6' name='detailshdr' align="center"> </td>
				<td class='COLUMNHEADER'  width='05%' id='colorstatus' align="center">Charging Stage</td>	
				
							
				</tr>
				
</thead>
	            
	            <tbody>
	                  <% 
	                  BLBillGenInterfaceInBean inBean=new BLBillGenInterfaceInBean();

	                  inBean.setFacilityId(facilityId);
	                  inBean.setLanguageId(locale);
	                  inBean.setFromDate(encounterFromDate);
	                  inBean.setToDate(encounterToDate);
	                  inBean.setEpisodeType(episodeType);
	                  inBean.setPatientId(patientNo);
	                  inBean.setEpisodeId(episodeId);
	                  inBean.setVisitId(visitId);
	                  inBean.setEncounter(encounter);
	                  inBean.setModules(modules);
	                  inBean.setServiceLocation(serviceLocationDesc);
	                  inBean.setPrMain(prKeyMain);
	                  inBean.setModuleId(moduleId);
	                  inBean.setServiceLocationCode(serviceLocationCode);
	                  inBean.setFutureYn(futureYn); 
	              //   inBean.setTotalRecordCount(total);
	                   
	               	    System.out.println(" facility id bean get "+ inBean.getFacilityId());
		                System.out.println("language id "+inBean.getLanguageId()); 
		                System.out.println("from date "+inBean.getFromDate()); 
		                System.out.println("todate "+inBean.getToDate()); 
		                System.out.println("epi type "+inBean.getEpisodeType()); 
		                System.out.println("pat id "+inBean.getPatientId()); 
		                System.out.println("epi id "+inBean.getEpisodeId()); 
		                System.out.println("visit id "+inBean.getVisitId()); 
		                System.out.println("encounter "+inBean.getEncounter()); 
		                System.out.println(" modules "+inBean.getModules()); 
		                System.out.println("serv location "+inBean.getServiceLocation()); 
		                System.out.println("pr main "+inBean.getPrMain()); 
		                System.out.println("module id "+inBean.getModuleId()); 
		                System.out.println("serv location code "+inBean.getServiceLocationCode());  
		               System.out.println("serv location code==============================="+  inBean.getTotalRecordCount());  
		               
		            	inBean.setStartFrom(startRcrd);
		            	inBean.setEndWith(endRcrd);
		                
		            
	                  BillReceiptBC receiptBC = new BillReceiptBC();
	             
	                  List<BLBillGenInterfaceBean> ipList=receiptBC.getBillGenInterfaceRecords(inBean);
	                  int rowIndx=1;
	                  int size=ipList.size();
	                  String spanClass="";
	                  String pKeyLength="";
	                  String sKeyLength="";
	                  String currentStage="";
	                   System.out.println("size =" +size);
	                  for(Iterator iterator= ipList.iterator(); iterator.hasNext();)
	                  {
						  
	                	BLBillGenInterfaceBean bean =(BLBillGenInterfaceBean) iterator.next();
						spanClass=bean.getColor();
						pKeyLength=bean.getPrimaryKeyModuleId();
						sKeyLength=bean.getSecondaryKeyModuleId();
						currentStage=bean.getChargingState();
						
						System.out.println("span Class before if = "+ currentStage);
						//System.out.println("episode id/ visit id / patient id "+bean.getEpisodeId() +"/" + bean.getVisitId() +"/" +bean.getPatientId());
						
						if("".equals(spanClass) || spanClass==null || spanClass=="null" )
						{
							//System.out.println("if "+spanClass);
							spanClass="";
						}
						
						else if(spanClass.equals("ORD"))
	           			{
							//System.out.println("ord");
	           				spanClass="ordered";
	           			}
						else if(spanClass.equals("PAT"))
	           			{
							System.out.println("PAT");
	           				spanClass="";
	           			}
	           			else if(spanClass.equals("REG"))
	           			{
	           				//System.out.println("reg");
	           				spanClass="registered";
	           			}
	           			else if(spanClass.equals("CMP"))
	           			{
	           				//System.out.println("reg");
	           				spanClass="completed";
	           			}
	           			else 
	           			{
	           				//System.out.println("res");
	           				spanClass="resulted";
	           			}
						
						
						if("".equals(currentStage) || currentStage==null || currentStage=="null" )
						{
							//System.out.println("if "+spanClass);
							currentStage="";
						}
						
						else if(currentStage.equals("ORD"))
	           			{
							//System.out.println("ord");
	           				currentStage="On Order";
	           			}
						else if(currentStage.equals("RES"))
	           			{
							System.out.println("RES");
							currentStage="On Result";
	           			}
	           			else if(currentStage.equals("REG"))
	           			{
	           				//System.out.println("reg");
	           				currentStage="On Registration";
	           			}
	           			else if(currentStage.equals("CMP"))
	           			{
	           				//System.out.println("reg");
	           				currentStage="On Completion";
	           			}
	           			else 
	           			{
	           				//System.out.println("res");
	           				currentStage="";
	           			}
						
						
						
						
						
	           				
						
	           %>
	           
	           
	           
	          	<tr id='row_<%=rowIndx %>' data-id='<%=rowIndx%>'  >
	           
	     	           
	           
			
				
				<td nowrap id='row_<%=rowIndx %>_col19' class=<%=classval%> width="10%" >  
				<span ><input type='checkbox' id='selectindividual_<%=rowIndx %>' name='selectindividual_<%=rowIndx%>' onclick='fnSelectindividual()' > </span>
				
				
				</td>
				  <td nowrap id='row_<%=rowIndx %>_col1' class=<%=classval%> width="05%" >
				<span class='<%=spanClass %>' id='spanColor<%=rowIndx%>'  name='spanColor<%=rowIndx %>'  > </span>
				
				</td>
				<td nowrap id='row_<%=rowIndx %>_col1' class=<%=classval%> width="10%" >  
				<a href class="LABEL" id='module_<%=rowIndx %>' name='module_<%=rowIndx %>' style='cursor:pointer' onClick='populate_btm_frame("<%=rowIndx %>"),highlightRow(<%=rowIndx%>,"<%=classval%>")' ><%=bean.getPrimaryKeyModuleId() %></a>
				</td>
		
	    		<td nowrap id='row_<%=rowIndx %>_col2' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='clinic_<%=rowIndx %>' name='clinic_<%=rowIndx %>'><%= bean.getClinic()%> </span>
				</td>
		        
	            <td nowrap id='row_<%=rowIndx %>_col3' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='physicianid_<%=rowIndx %>' name='physicianid_<%=rowIndx %>'><%=bean.getPhysicianId()%> </span>
				</td>
		        
		        <td nowrap id='row_<%=rowIndx %>_col4' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='blngservcode_<%=rowIndx %>' name='blngservcode_<%=rowIndx %>'> <%=bean.getBlngServCode()%></span>
				</td>
		        
		        <td nowrap id='row_<%=rowIndx %>_col5' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='description_<%=rowIndx %>' name='description_<%=rowIndx %>'><%=bean.getBlngServiceDesciption()%> </span>
				</td>
		        
		        <td nowrap    id='row_billInterfaceC1<%=rowIndx%>' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='primarykey_<%=rowIndx %>' name='primarykey_<%=rowIndx %>'> <%= bean.getPrimaryKeyMain()%></span>
				</td>
		        
		        <td nowrap  id='row_billInterfaceC2<%=rowIndx%>' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='line_<%=rowIndx %>' name='line_<%=rowIndx %>'> <%= bean.getPrimaryKeyLine()%></span>
				</td>
				
				<td nowrap id='row_billInterfaceC7<%=rowIndx%> '  class=<%=classval%> width="10%" >  
				<span class="LABEL" id='mod_<%=rowIndx %>' name='mod_<%=rowIndx %>'><%=bean.getSecondaryKeyModuleId()%> </span>
				</td>
				
				
		        <td nowrap  id='row_billInterfaceC3<%=rowIndx%>' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='secondarykey_<%=rowIndx %>' name='secondarykey_<%=rowIndx %>'><%= bean.getSecondaryKeyMain()%> </span>
				</td>
				
				<td nowrap  id='row_billInterfaceC4<%=rowIndx%>'  class=<%=classval%> width="10%" >  
				<span class="LABEL" id='lin_<%=rowIndx %>' name='lin_<%=rowIndx %>'><%= bean.getSecondaryKeyLine()%> </span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col11' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='servitemcode_<%=rowIndx %>' name='servitemcode_<%=rowIndx %>'> <%= bean.getServiceItemCode()%></span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col12' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='desc_<%=rowIndx %>' name='desc_<%=rowIndx %>'> <%= bean.getServiceItemDescription()%></span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col13' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='interfaceddate_<%=rowIndx %>' name='interfaceddate_<%=rowIndx %>'><%=date.format(bean.getInterfacedDate())%> 
				</span>
				</td>
				
				<td nowrap   id='row_billInterfaceC5<%=rowIndx%>' class=<%=classval%> width="10%" >  
				<span ><input type='checkbox' id='charged_<%=rowIndx%>' name='charged<%=rowIndx%>'> </span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col15' class=<%=classval%> width="10%" style='text-align:right' >  
				<span class="LABEL1"  style='text-align:right' id='grossamt_<%=rowIndx %>' name='grossamt_<%=rowIndx %>' ><%= qtyDecimal(bean.getGrossAmt())%> </span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col16' class=<%=classval%> width="10%" style='text-align:right'  >  
				<span class="LABEL1"  style='text-align:right' id='discount_<%=rowIndx %>' name='discount_<%=rowIndx %>' > <%= qtyDecimal(bean.getDiscount())%></span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col17' class=<%=classval%> width="10%"  style='text-align:right'>  
				<span class="LABEL1" style='text-align:right' id='netamt_<%=rowIndx %>' name='netamt_<%=rowIndx %>' > <%= qtyDecimal(bean.getNetAmt())%></span>
				</td>
				
				<td nowrap   id='row_billInterfaceC6<%=rowIndx%>' class=<%=classval%> width="10%" >  
				<span ><input type='submit' id='details_<%=rowIndx %>' name='details_<%=rowIndx %>' value='Details' size='3' > </span>
				</td>
				
				<td nowrap id='row_<%=rowIndx %>_col12' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='chargingStage_<%=rowIndx %>' name='chargingStage_<%=rowIndx %>'> <%=currentStage%>
		<%	System.out.println("stage"+bean.getChargingState());%></span>
				</td>
				
				
	<input type='hidden' name='futureYn' id='futureYn' id='futureYn' value='<%=futureYn%>'>			
	<input type='hidden' name='hdnfacility_name' id='hdnfacility_name' id='hdnfacility_name' value='<%=facilityId%>'>
	<input type='hidden' name='hdnrecords' id='hdnrecords' id='hdnrecords' value='<%=records %>'>
	<input type='hidden' name='hdnmodules' id='hdnmodules' id='hdnmodules' value='<%=modules %>'>
	<input type='hidden' name='hdnprmodule' id='hdnprmodule' id='hdnprmodule' value='<%=prModule%>'>
	<input type='hidden' name='hdnserviceLocationCode' id='hdnserviceLocationCode' id='hdnserviceLocationCode' value='<%=serviceLocationCode %>'>
	<input type='hidden' name='hdnserviceLocationDesc' id='hdnserviceLocationDesc' id='hdnserviceLocationDesc' value='<%=serviceLocationDesc %>'>
	<input type='hidden' name='hdnpatient' id='hdnpatient' id='hdnpatient' value='<%=patient%>'>
	<input type='hidden' name='hdnpatient_no' id='hdnpatient_no' id='hdnpatient_no' value='<%=patientNo %>'>
	<input type='hidden' name='hdnencounter_from_date' id='hdnencounter_from_date' id='hdnencounter_from_date' value='<%=encounterFromDate %>'>
	<input type='hidden' name='hdnencounter_to_date' id='hdnencounter_to_date' id='hdnencounter_to_date' value='<%=encounterToDate%>'>
	<input type='hidden' name='hdnepisode_type' id='hdnepisode_type' id='hdnepisode_type' value='<%=episodeType %>'>
	<input type='hidden' name='hdnencounter' id='hdnencounter' id='hdnencounter' value='<%=encounter %>'>
	<input type="hidden" name="hdnepisode_id" id="hdnepisode_id" id="hdnepisode_id" value="<%=episodeId%>">
	<input type='hidden' name='spanColor' id='spanColor' value = ''>
	<input type='hidden' name='selectindividual' id='selectindividual' value = ''>
	<input type='hidden' name='module' id='module' value = ''>
	<input type='hidden' name='clinic' id='clinic' value = ''>
	<input type='hidden' name='physicianid' id='physicianid' value = ''>
	<input type='hidden' name='blngservcode' id='blngservcode' value = ''>
	<input type='hidden' name='description' id='description' value = ''>
	<input type='hidden' name='primarykey' id='primarykey' value = ''>
	<input type='hidden' name='line' id='line' value = ''>
	<input type='hidden' name='mod' id='mod' value = ''>
	<input type='hidden' name='secondarykey' id='secondarykey' value = ''>
	<input type='hidden' name='lin' id='lin' value = ''>	
	<input type='hidden' name='servitemcode' id='servitemcode' value = ''>
	<input type='hidden' name='desc' id='desc' value = ''>
	<input type='hidden' name='interfaceddate' id='interfaceddate' value = ''>
	<input type='hidden' name='charged' id='charged' value = ''>
	<input type='hidden' name='grossamt' id='grossamt' value = ''>
	<input type='hidden' name='discount' id='discount' value = ''>
	<input type='hidden' name='netamt' id='netamt' value = ''>
	<input type='hidden' name='details' id='details' value = ''>			
		<input type='hidden' name='fromRcrd' id='fromRcrd' id='fromRcrd' value='<%=startRcrd %>'>
		<input type='hidden' name='toRcrd' id='toRcrd' id='toRcrd' value='<%=endRcrd %>'>
		<input type='hidden' name='constCount' id='constCount' id='constCount' value='<%=constCount %>'>
	<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' value=''>
	<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' id='hdnNextSpan' value='<%=nextYn %>'>
		<input type='hidden' name='prevSpan' id='prevSpan' id='prevSpan' value='<%=prevYn %>'>
		<input type='hidden' name='traverse' id='traverse' id='traverse' value='<%=traversal%>'>
	<input type='hidden' name='epiId_<%=rowIndx %>' id='epiId_<%=rowIndx %>' value='<%=bean.getEpisodeId() %>'>
	<input type='hidden' name='visId_<%=rowIndx %>' id='visId_<%=rowIndx %>' value='<%=bean.getVisitId() %>'>
	<input type='hidden' name='patId_<%=rowIndx %>' id='patId_<%=rowIndx %>' value='<%=bean.getPatientId() %>'>
	<input type='hidden' name='patName_<%=rowIndx %>' id='patName_<%=rowIndx %>' value='<%=bean.getPatientName() %>'>
	<input type='hidden' name='chargestate_<%=rowIndx %>' id='chargestate_<%=rowIndx %>' value='<%=bean.getChargingState() %>'>
	<input type='hidden' name='total' id='total' id='total' value='<%=bean.getTotalRecordCount() %>'>
	<%System.out.println("total"+bean.getTotalRecordCount());%>
	<input type='hidden' name='rowClicked' id='rowClicked' id='rowClicked' value=''>
	<input type='hidden' name='count' id='count' id='count' value='<%=rowIndx%>'>
	            </tr>
	            <%
	            rowIndx++;

	            System.out.println(" rowIndx  value after increament "+rowIndx);
	                  }
	            
	                  
	                  
}catch(Exception ex)
{
	System.err.println("Exception in main "+ex);
	ex.printStackTrace();
}
	            %>
	           
	            
	            
	            
	            </tbody>
	            </table>
	            </div>
	            </Form>
	            </fieldset>
	            </body>
	            </html>

		

