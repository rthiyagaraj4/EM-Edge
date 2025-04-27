<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,java.net.*, java.io.*,com.ehis.util.*,java.util.*,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
} %>
<%
	Connection con = null;
	//Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rscurr=null;
	request.setCharacterEncoding("UTF-8");

	String querystring=(String)request.getQueryString();

	String		strfacilityid ="";	
	String		strslmtidno = request.getParameter("slmtidno");	
	String		strslmtpayername = request.getParameter("slmtpayername");	
	String		strbilldoctypecode = request.getParameter("billdoctypecode");
	if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
	{strbilldoctypecode = "";}
	String		strbilldocnum = request.getParameter("billdocnum");	
	if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
	{strbilldocnum = "";}

	String error_flag="";
	error_flag=request.getParameter("error_flag");
	if ( error_flag == null || error_flag.equalsIgnoreCase("null")) 
	{error_flag = "";}
	String cash_counter_code = request.getParameter("cashcounter");
	if(cash_counter_code == null) cash_counter_code="";
	
	//String	str_receipt_type_code = "";	//String	str_ext_acc_facility_id = "";
	//String	str_ext_account_code	= "";	//String	str_ext_dept_ind = "";
	//String	str_ext_dept_code     = ""; 	//String	str_single_service_grp_yn = "";
	//String	str_service_grp		= ""; 	//String	str_acc_episode_type= "";
	//String	str_acc_category_code	= "";	//String	str_acc_serv_grp_used_yn	= "";
	//String	str_reln_code		= "";	//String	str_episode_type		= "";
	
	int totalRecords=0; 	int noofdecimal=2;	
	String classval="";	String remove_check="";	
	ArrayList output_records=new ArrayList();
	//ArrayList output_records1=new ArrayList();
	ArrayList a1=new ArrayList();ArrayList a2=new ArrayList(); ArrayList a3=new ArrayList();ArrayList a4=new ArrayList();ArrayList a5=new ArrayList();ArrayList a6=new ArrayList();ArrayList a7=new ArrayList();ArrayList a8=new ArrayList();ArrayList a9=new ArrayList();ArrayList a10=new ArrayList();ArrayList a11=new ArrayList();ArrayList a12=new ArrayList();ArrayList a13=new ArrayList();ArrayList a14=new ArrayList();
	ArrayList a15=new ArrayList();ArrayList a16=new ArrayList();ArrayList a17=new ArrayList();ArrayList a18=new ArrayList();ArrayList a19=new ArrayList();ArrayList a20=new ArrayList();ArrayList a21=new ArrayList();
	String function_id="";
	String locale	= (String)session.getAttribute("LOCALE");	
	
	if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) 
	{strslmtidno = "";}

	if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
	{strslmtpayername = "";}

	con	=	ConnectionManager.getConnection(request);

		String strslmttype= request.getParameter("slmttype");	
		strfacilityid	=  (String) session.getValue("facility_id");
		//unused variable, commented on 09/06/05
		//strloggeduser	=  (String) session.getValue("login_user");

		
		//String ext_acc_interface_yn = "";
		if( strslmttype == null) strslmttype="";
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";	
		String strepisode_id = replaceNull(request.getParameter("episode_id"));	
		int episode_id=0;
		if("".equals(strepisode_id)){
			episode_id=0;
		}		
		else
		{
			try
			{
				episode_id=Integer.parseInt(strepisode_id);	
			}catch(Exception e)
			{
				episode_id=0;
			}
		}//if(episode_id==null) episode_id="";		
		System.out.println("episode_id settlement type="+episode_id);
		
		String strVisit_id = replaceNull(request.getParameter("visit_id"));	
		int visit_id=0;
		if("".equals(strVisit_id)){
			visit_id=0;
		}		
		else
		{
			try
			{
				visit_id=Integer.parseInt(strVisit_id);	
			}catch(Exception e)
			{
				visit_id=0;
			}
		}
		System.out.println("visit_id="+visit_id);
		String strencounter_id = replaceNull(request.getParameter("encounter_id"));	
		int encounter_id=0;
		if("".equals(strencounter_id)){
			encounter_id=0;
		}		
		else
		{
			try
			{
				encounter_id=Integer.parseInt(strencounter_id);	
			}catch(Exception e)
			{
				encounter_id=0;
			}
		}
		System.out.println("encounter_id="+encounter_id);
	
		
%>

		
		<html>
  		<head>
		<!--
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--		<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>			
			<script language='javascript' ></script>		
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



			<style>
				thead td, thead td.locked	{
				background-color: navy;
				color: white;
				position:relative;}	
				thead td {
				top: expression(document.getElementById("tbl-container").scrollTop-2); 
				z-index: 20;}
				thead td.locked {z-index: 30;}
				td.locked,  th.locked{
				left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
				position: relative;
				z-index: 10;}
				td.locked,  th.locked{
				left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
				position: relative;
				z-index: 10;}
			</style>
<%

	try{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}		
			rscurr.close();
			pstmt.close();
		}catch(Exception e) {System.out.println("3="+e.toString());}
		try
		{		
			remove_check=request.getParameter("remove_check");
			if(remove_check==null) remove_check="";			
			String checked_row="";
			String record_count="";
			int total_records=0;
			int selected_index=0;		
			if(checked_row==null) checked_row="";
			if(remove_check.equals("remove"))
			{
				if(!(error_flag.equals(""))){ //CRF-13
				error_flag="";}                 
				record_count=request.getParameter("total_records");
				if(record_count==null) record_count="";
				total_records=Integer.parseInt(record_count);			
				checked_row=request.getParameter("checked_row");
				if(checked_row==null) checked_row="";
				selected_index=Integer.parseInt(checked_row);	
				
					for(int i=0;i<total_records;i++)
					{	
						if(!(i==selected_index))
						{
							
						try{
						String temp1=request.getParameter("billslmtamt"+i);						
						a1.add(temp1);							
						temp1=request.getParameter("shortdesc"+i);						
						a2.add(temp1);	
						temp1=request.getParameter("slmttype"+i);						
						a3.add(temp1);	
						temp1=request.getParameter("cash_given"+i);						
						a4.add(temp1);	
						temp1=request.getParameter("cash_return"+i);						
						a5.add(temp1);							
						temp1=request.getParameter("instref"+i);						
						a6.add(temp1);				
						temp1=request.getParameter("instdate"+i);										
						a7.add(temp1);	
						temp1=request.getParameter("creditcardco"+i);						
						a8.add(temp1);	
						temp1=request.getParameter("instbankname"+i);						
						a9.add(temp1);	
						temp1=request.getParameter("instbranch"+i);						
						a10.add(temp1);	
						temp1=request.getParameter("instremarkcode"+i);						
						a11.add(temp1);	
						temp1=request.getParameter("batchno"+i);						
						a12.add(temp1);	
						temp1=request.getParameter("apprrefno"+i);						
						a13.add(temp1);	
						temp1=request.getParameter("saledraftno"+i);						
						a14.add(temp1);	
						temp1=request.getParameter("payername"+i);						
						a15.add(temp1);	
						temp1=request.getParameter("recrefidno"+i);								
						a16.add(temp1);	
//						System.out.println("checked_row remove :16");
						temp1=request.getParameter("onlineapproval"+i);						
						a17.add(temp1);	
						temp1=request.getParameter("ext_acc_interface_yn"+i);						
						a18.add(temp1);	
						temp1=request.getParameter("ext_acc_fac_id"+i);						
						a19.add(temp1);	
						temp1=request.getParameter("credit_card_machine_int_yn"+i);						
						a20.add(temp1);	
						temp1=request.getParameter("outstanding_amount"+i);	
						a21.add(temp1);	
						}catch(Exception e){System.out.println("Exception in :"+e);}
					//j++;
					}	
					
			
			/*a1.remove(selected_index);
			a2.remove(selected_index);
			a3.remove(selected_index);
			a4.remove(selected_index);
			a5.remove(selected_index);
			a6.remove(selected_index);
			a7.remove(selected_index);
			a8.remove(selected_index);
			a9.remove(selected_index);
			a10.remove(selected_index);
			a11.remove(selected_index);
			a12.remove(selected_index);
			a13.remove(selected_index);
			a14.remove(selected_index);
			a15.remove(selected_index);
			a16.remove(selected_index);
			a17.remove(selected_index);
			a18.remove(selected_index);
			a19.remove(selected_index);*/
			
			}
			}
		
	}catch(Exception eX)
	{	
		out.println("Error1= "+eX);
		System.out.println("Error in remove" +eX);
	}
%>
<script>

	function selected(i)
	{
			var selected_row=eval("document.forms[0].selected_row"+i);
			
			if(selected_row.checked==false)
			{
				selected_row.checked=false;
				document.forms[0].checked_row.value="";
			}
			else
			{
				var total_records=document.forms[0].total_records.value;
				for(var j=0;j<total_records;j++)
			{
				var temp=eval("document.forms[0].selected_row"+j);
				temp.checked=false;
				//temp.value="false";
			}
				selected_row.checked=true;
				//selected_row.value="true";
				document.forms[0].checked_row.value=i;
			}
			
	}

function tot_setld_amt()
{
	var total_settled=0.0;	
	var tot_setl="";
	var a1=new Array();
	var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;
	var	totalRecords =eval(formObj.total_records.value);	
	for(var i=0;i<totalRecords;i++)
	{
	  tot_setl=eval("parent.frames[1].document.forms[0].billslmtamt"+i);
	  a1[i]=tot_setl.value;
	  if(a1[i]==""){a1[i]="0.0";}
	  total_settled=parseFloat(total_settled) + parseFloat(a1[i]);	  
	}	
	document.forms[0].total_settled_amt.value=total_settled;
	var temp_total_settled=eval("document.forms[0].total_settled_amt");
	putdeci(temp_total_settled);
	var v_set_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;
	if(parseFloat(temp_total_settled.value)==parseFloat(v_set_amt))
	{
		parent.frames[0].document.forms[0].billslmtamtdet.readOnly=true;
	}
}


function putdeci(object)
	{	
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
	}

function chkForDfltSlmtType()
{
	document.forms[0].add_bill_stlmt_button.click();
}

function check_box(i)
	{
		var onlineapproval=eval("document.forms[0].onlineapproval"+i);

		if(onlineapproval.value=="checked")
		{
			onlineapproval.checked=true;
		}
		else
		{
			onlineapproval.checked=false;
		}
	}

</script>
		
  	</head>
	<!--<body onLoad="" onKeyDown= "lockKey();" onMouseDown=" "    onSelect="codeArrestThruSelect();"> -->
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='BillSlmtTypeForm' id='BillSlmtTypeForm' method='post' action=''  scrolling=yes >	
<%
	
try{
%>	
  <div>
	<table border='1' cellpadding='3' cellspacing='0' align='center' width='100%'>	
	<tr><td class='columnHeader' colspan='16'><fmt:message key="Common.PaymentDetails.label" bundle="${common_labels}"/></td></tr>
	</table></div>
	<%
		if(function_id.equals("rcpt_rfnd") || function_id.equals("PKG_BILLING"))
		{
	%>
 		<div id="tbl-container" STYLE="overflow: auto; width='100%' ; height: 280px;   padding:3px; margin: 0px"> 
	<%
		}else {
	%>
 	 <div id="tbl-container" STYLE="overflow: auto; width='100%'; height: 195px;   padding:3px; margin: 0px">  
<%			}
%>
		<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='bill_slmt_data' width='100%'>	
		
		<thead><tr>
		<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.AMT_COLL.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="5%"><fmt:message key="eBL.CASH_GIVEN.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width="5%"><fmt:message key="eBL.OutstandingAmount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width="5%"><fmt:message key="eBL.CASH_RETURNED.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.CHQ_CARD_BANK_NO.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.CREDIT_CARD_CO.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.BANK_NAME.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.BRANCH_NAME.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='4%'><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.APPROVAL_CODE.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.SALE_DRAFT_NO.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.PAYER_DEP_REF_NO.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.ONLINE_APPROVAL.label" bundle="${bl_labels}"/></td>
		</tr></thead>
<%
		int  record_select=0;
		if(error_flag.equals("true"))
		{

			int i=0;
			String[] output1=new String[20];
			output_records=(ArrayList)session.getAttribute("existing_records_array");

			for(int k=0;k<output_records.size();k++)
				{
				output1=(String[])output_records.get(k);
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}	
%>
<tbody>
	<tr id=row<%=i%>>
	<tr>
	<td class=<%=classval%> width='5%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>	 

	<td class=<%=classval%> width="5%"><INPUT TYPE="TEXT" name='billslmtamt<%=i%>' id='billslmtamt<%=i%>' SIZE="10" MAXLENGTH="20" 	VALUE='<%=output1[0]%>'  style='text-align:right' readonly> </td>	
	
	<td class=<%=classval%> width="5%" ><input type='text' name='shortdesc<%=i%>' id='shortdesc<%=i%>' size='10' maxlength='20'value='<%=output1[19]%>'>
	<input type='hidden' name='Case' id='Case' value='1'><input type='hidden' name='slmttype<%=i%>' id='slmttype<%=i%>' value='<%=output1[1]%>' readonly>
	</td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_given<%=i%>' id='cash_given<%=i%>' size='10' maxlength='30' value='<%=output1[2]%>' readonly> </td>
	 <td class=<%=classval%> width="5%" class="fields"><input type='text' name='outstanding_amount<%=i%>' id='outstanding_amount<%=i%>' size='10' maxlength='30' value='<%=output1[18]%>' readonly> </td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_return<%=i%>' id='cash_return<%=i%>' size='10' maxlength='30' value='<%=output1[3]%>' readonly> </td>

	<td class=<%=classval%> width="6%" ><input type='text' name='instref<%=i%>' id='instref<%=i%>' size='10' maxlength='20' value='<%=output1[4]%>' readonly>
	<td class=<%=classval%> width="6%"><input type='text' name='instdate<%=i%>' id='instdate<%=i%>' size='10' maxlength='10' value='<%=output1[5]%>' readonly></td>	
	<td class=<%=classval%> width="10%"><input type='text' readonly name='creditcardco<%=i%>' id='creditcardco<%=i%>' maxlength='30' size='10'  tabindex='0' value='<%=output1[6]%>' readonly></td>
	<td class=<%=classval%> width="10%"><input type='text' readonly name='instbankname<%=i%>' id='instbankname<%=i%>' maxlength='60' size='10' value='<%=output1[7]%>' readonly></td>  

	<td class=<%=classval%> width="6%"><input type='text' readonly name='instbranch<%=i%>' id='instbranch<%=i%>' maxlength='60' size='10' value='<%=output1[8]%>' ></td>  
	<input type= hidden name="instremarkcode<%=i%>" id="instremarkcode<%=i%>"  value='<%=output1[18]%>'>	        
	
	 <td class=<%=classval%>width="4%"><input type='text' name='batchno<%=i%>' id='batchno<%=i%>' size='10' maxlength='10' value='<%=output1[10]%>' readonly></td>	
	 <td class=<%=classval%>width="5%" ><input type='text' name='apprrefno<%=i%>' id='apprrefno<%=i%>' size='20' maxlength='30' 
	 value='<%=output1[11]%>' readonly></td>
	 <td class=<%=classval%>width="5%" ><input type='text' name='saledraftno<%=i%>' id='saledraftno<%=i%>' size='20' maxlength='20' value='<%=output1[12]%>' readonly></td>
	 <td class=<%=classval%>width="6%" ><input type='text' name='payername<%=i%>' id='payername<%=i%>' size='20' maxlength='20' value='<%=output1[13]%>' readonly></td>
	 <td class=<%=classval%> width="6%"><input type='text' name='recrefidno<%=i%>' id='recrefidno<%=i%>' size='20' maxlength='20' value='<%=output1[14]%>' readonly></td>
	<INPUT TYPE="HIDDEN" name='ext_acc_interface_yn<%=i%>' id='ext_acc_interface_yn<%=i%>' MAXLENGTH="10" VALUE='<%=output1[15]%>'>
	<INPUT TYPE="HIDDEN" name='ext_acc_fac_id<%=i%>' id='ext_acc_fac_id<%=i%>' MAXLENGTH="10" VALUE='<%=output1[16]%>'>
	<INPUT TYPE="HIDDEN" name='credit_card_machine_int_yn<%=i%>' id='credit_card_machine_int_yn<%=i%>' VALUE=''>
	<td class=<%=classval%> width="6%"><input type='checkbox' name='onlineapproval<%=i%>' id='onlineapproval<%=i%>' <%=output1[17]%> readonly  onclick='check_box(<%=i%>)'></td>		

	 </tr>
<%
				i++;
				 totalRecords=i;		
				}	
				error_flag = "";
	}
		else if(remove_check.equals("remove"))
			{		
			totalRecords=a1.size();
			record_select=1;
			for(int i=0;i<totalRecords;i++)
			{	
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			
%>

	<tr id=row<%=i%>>
	<tr>
	<td class=<%=classval%> width='5%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>	 

	<td class=<%=classval%> width="5%"><INPUT TYPE="TEXT" name='billslmtamt<%=i%>' id='billslmtamt<%=i%>' SIZE="10" MAXLENGTH="20" 	VALUE='<%=a1.get(i)%>'  style='text-align:right' onBlur=''> </td>	
	
	<td class=<%=classval%> width="5%" ><input type='text' name='shortdesc<%=i%>' id='shortdesc<%=i%>' size='20' maxlength='40' value='<%=a2.get(i)%>'>
	<input type='hidden' name='Case' id='Case' value='1'><input type='hidden' name='slmttype<%=i%>' id='slmttype<%=i%>' value='<%=a3.get(i)%>'>

	</td>

	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_given<%=i%>' id='cash_given<%=i%>' size='10' maxlength='30' style='text-align:right' value='<%=a4.get(i)%>'> </td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='outstanding_amount<%=i%>' id='outstanding_amount<%=i%>' size='10' maxlength='30' value='<%=a21.get(i)%>' readonly> </td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_return<%=i%>' id='cash_return<%=i%>' size='10' maxlength='30' style='text-align:right' value='<%=a5.get(i)%>'> </td>

	<td class=<%=classval%> width="6%" ><input type='text' name='instref<%=i%>' id='instref<%=i%>' size='10' maxlength='20'value='<%=a6.get(i)%>'>
	<td width="6%" class=<%=classval%>><input type='text' name='instdate<%=i%>' id='instdate<%=i%>' size='10' maxlength='10'value='<%=a7.get(i)%>'></td>	
	<td width="10%" class=<%=classval%>><input type='text' readonly name='creditcardco<%=i%>' id='creditcardco<%=i%>' maxlength='30' size='10'  tabindex='0' value='<%=a8.get(i)%>'></td>
	<td class=<%=classval%> width="10%"><input type='text' readonly name='instbankname<%=i%>' id='instbankname<%=i%>' maxlength='60' size='10' value='<%=a9.get(i)%>' ></td>  	

	<td class=<%=classval%> width="6%"><input type='text' readonly name='instbranch<%=i%>' id='instbranch<%=i%>' maxlength='60' size='10' value='<%=a10.get(i)%>' ></td>  
	<input type= hidden name="instremarkcode<%=i%>" id="instremarkcode<%=i%>"  value='<%=a11.get(i)%>'>	        
	
	 <td class=<%=classval%>width="4%"><input type='text' name='batchno<%=i%>' id='batchno<%=i%>' size='10' maxlength='10' value='<%=a12.get(i)%>'></td>	
	 <td class=<%=classval%>width="5%" ><input type='text' name='apprrefno<%=i%>' id='apprrefno<%=i%>' size='20' maxlength='30' value='<%=a13.get(i)%>'></td>
	 <td class=<%=classval%>width="5%" ><input type='text' name='saledraftno<%=i%>' id='saledraftno<%=i%>' size='20' maxlength='20' value='<%=a14.get(i)%>'></td>
	 <td class=<%=classval%>width="6%" ><input type='text' name='payername<%=i%>' id='payername<%=i%>' size='20' maxlength='20' value='<%=a15.get(i)%>'></td>
	 <td width="5%" class=<%=classval%>><input type='text' name='recrefidno<%=i%>' id='recrefidno<%=i%>' size='20' maxlength='20' value='<%=a16.get(i)%>'></td>
	 <INPUT TYPE="HIDDEN" name='ext_acc_interface_yn<%=i%>' id='ext_acc_interface_yn<%=i%>' MAXLENGTH="10" VALUE='<%=a18.get(i)%>'>
	<INPUT TYPE="HIDDEN" name='ext_acc_fac_id<%=i%>' id='ext_acc_fac_id<%=i%>' MAXLENGTH="10" VALUE='<%=a19.get(i)%>'>
	<INPUT TYPE="HIDDEN" name='credit_card_machine_int_yn<%=i%>' id='credit_card_machine_int_yn<%=i%>' VALUE='<%=a20.get(i)%>'>
	<td width="6%" class=<%=classval%> ><input type='checkbox' name='onlineapproval<%=i%>' id='onlineapproval<%=i%>' value='<%=a17.get(i)%>' <%=a17.get(i)%> readonly    onclick='check_box(<%=i%>)'></td>			
	</tr>


<%
		record_select++;
			}//for loop
		}//if remove_check
		else if(function_id.equals("PKG_BILLING")){
			//System.out.println("function_id inside"+function_id);
			String bean_id3		= "PkgEnterReceptRefundBean" ;
			String bean_name3= "eBL.PkgEnterReceptRefundBean";
			PkgEnterReceptRefundBean bean3			= (PkgEnterReceptRefundBean)getBeanObject( bean_id3, bean_name3, request ) ;	
			HashMap  support_data = bean3.getSupportData();		
			HashMap  mult_slmt_vals = new HashMap();
			if(support_data!=null && support_data.size()>0)
			{
			
			String str_tot_rec = (String)support_data.get("str_tot_rec");
			if(str_tot_rec==null) str_tot_rec="0";			
			int tot_rec=Integer.parseInt(str_tot_rec);			

			String str_doc_amt="",str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";
			str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = (String)support_data.get("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd==null) str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";						
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equalsIgnoreCase("Y"))
			{
				 mult_slmt_vals = bean3.getMultSlmtVals();	
			}else{
				 mult_slmt_vals = bean3.getSlmtVals();					
			}			
		try{
		
			String str_slmt_type="",str_slmt_doc_ref_desc="",str_slmt_doc_ref_date="",str_slmt_doc_remarks="",str_app_ref_no="",str_cash_slmt_flag="",str_cc_batch_no="",str_cc_sale_draft_no="",str_cc_swipped_yn="",str_bank_code="",str_cash_amt_given="",str_cash_amt_return="",str_payer_name="",str_rcpt_rfnd_id_no="",str_nominee_name="",str_doc_sr_no="",str_bank_branch="",str_slmt_short_desc="",str_bank_name="",str_online_app="",str_outstanding_amount="";
			ArrayList rtn_str_slmt_doc_amt=new ArrayList();
			ArrayList rtn_str_slmt_type_code=new ArrayList();
			ArrayList rtn_str_slmt_doc_ref_desc=new ArrayList();
			ArrayList rtn_str_slmt_doc_ref_date=new ArrayList();
			ArrayList rtn_str_slmt_doc_remarks=new ArrayList();
			ArrayList rtn_str_app_ref_no=new ArrayList();
			ArrayList rtn_str_cash_slmt_flag=new ArrayList();
			ArrayList rtn_str_cc_batch_no=new ArrayList();
			ArrayList rtn_str_cc_sale_draft_no=new ArrayList();
			ArrayList rtn_str_cc_swipped_yn=new ArrayList();
			ArrayList rtn_str_bank_code=new ArrayList();
			ArrayList rtn_str_bank_branch=new ArrayList();
			ArrayList rtn_str_cash_amt_given=new ArrayList();
			ArrayList rtn_str_outstanding_amount=new ArrayList();
			ArrayList rtn_str_cash_amt_return=new ArrayList();
			ArrayList rtn_str_payer_name=new ArrayList();
			ArrayList rtn_str_rcpt_rfnd_id_no=new ArrayList();
			ArrayList rtn_str_nominee_name=new ArrayList();
			ArrayList rtn_str_doc_sr_no=new ArrayList();
			ArrayList rtn_str_online_app=new ArrayList();

			ArrayList rtn_str_slmt_short_desc=new ArrayList();
			ArrayList rtn_str_bank_name=new ArrayList();

			rtn_str_slmt_doc_amt = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
			rtn_str_slmt_type_code = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_type_code");
			rtn_str_slmt_doc_ref_date = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
			rtn_str_slmt_doc_ref_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
			rtn_str_slmt_doc_remarks = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
			rtn_str_app_ref_no = (ArrayList)mult_slmt_vals.get("rtn_str_app_ref_no");
			rtn_str_cash_slmt_flag = (ArrayList)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
			rtn_str_cc_batch_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_batch_no");
			rtn_str_cc_sale_draft_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");			
			rtn_str_cc_swipped_yn = (ArrayList)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
			rtn_str_bank_code = (ArrayList)mult_slmt_vals.get("rtn_str_bank_code");
			rtn_str_bank_branch = (ArrayList)mult_slmt_vals.get("rtn_str_bank_branch");
			rtn_str_cash_amt_given = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_given");
			rtn_str_outstanding_amount = (ArrayList)mult_slmt_vals.get("rtn_str_outstanding_amount");
			rtn_str_cash_amt_return = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_return");
			rtn_str_payer_name = (ArrayList)mult_slmt_vals.get("rtn_str_payer_name");
			rtn_str_rcpt_rfnd_id_no = (ArrayList)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
			rtn_str_nominee_name = (ArrayList)mult_slmt_vals.get("rtn_str_nominee_name");
			rtn_str_doc_sr_no = (ArrayList)mult_slmt_vals.get("rtn_str_doc_sr_no");		

			rtn_str_slmt_short_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_short_desc");		
			rtn_str_bank_name = (ArrayList)mult_slmt_vals.get("rtn_str_bank_name");		
			rtn_str_online_app = (ArrayList)mult_slmt_vals.get("rtn_str_online_app");		
			
			for(int i=0;i<tot_rec;i++)
			{
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}				 
				 str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
		    	 str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);				 
				 str_slmt_type=(String)rtn_str_slmt_type_code.get(i);
		    	 str_slmt_type=str_slmt_type.substring(0,str_slmt_type.length()-1);
				 str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
		    	 str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);
				 str_slmt_doc_ref_desc=(String)rtn_str_slmt_doc_ref_desc.get(i);
		    	 str_slmt_doc_ref_desc=str_slmt_doc_ref_desc.substring(0,str_slmt_doc_ref_desc.length()-1);
				 str_slmt_doc_ref_date=(String)rtn_str_slmt_doc_ref_date.get(i);
		    	 str_slmt_doc_ref_date=str_slmt_doc_ref_date.substring(0,str_slmt_doc_ref_date.length()-1);
				 str_slmt_doc_remarks=(String)rtn_str_slmt_doc_remarks.get(i);
		    	 str_slmt_doc_remarks=str_slmt_doc_remarks.substring(0,str_slmt_doc_remarks.length()-1);
				 str_app_ref_no=(String)rtn_str_app_ref_no.get(i);
		    	 str_app_ref_no=str_app_ref_no.substring(0,str_app_ref_no.length()-1);
				 str_cash_slmt_flag=(String)rtn_str_cash_slmt_flag.get(i);
		    	 str_cash_slmt_flag=str_cash_slmt_flag.substring(0,str_cash_slmt_flag.length()-1);	
				 str_cc_batch_no=(String)rtn_str_cc_batch_no.get(i);
		    	 str_cc_batch_no=str_cc_batch_no.substring(0,str_cc_batch_no.length()-1);				 
				 str_cc_sale_draft_no=(String)rtn_str_cc_sale_draft_no.get(i);
		    	 str_cc_sale_draft_no=str_cc_sale_draft_no.substring(0,str_cc_sale_draft_no.length()-1);				 
				 str_cc_swipped_yn=(String)rtn_str_cc_swipped_yn.get(i);
		    	 str_cc_swipped_yn=str_cc_swipped_yn.substring(0,str_cc_swipped_yn.length()-1);				 
				 str_bank_code=(String)rtn_str_bank_code.get(i);
		    	 str_bank_code=str_bank_code.substring(0,str_bank_code.length()-1);				 
				 str_cash_amt_given=(String)rtn_str_cash_amt_given.get(i);
		    	 str_cash_amt_given=str_cash_amt_given.substring(0,str_cash_amt_given.length()-1);	
		    	 str_outstanding_amount=(String)rtn_str_outstanding_amount.get(i);
		    	 str_outstanding_amount=str_outstanding_amount.substring(0,str_outstanding_amount.length()-1);
				 str_cash_amt_return=(String)rtn_str_cash_amt_return.get(i);
		    	 str_cash_amt_return=str_cash_amt_return.substring(0,str_cash_amt_return.length()-1);				 
				 str_payer_name=(String)rtn_str_payer_name.get(i);
		    	 str_payer_name=str_payer_name.substring(0,str_payer_name.length()-1);				 
				 str_rcpt_rfnd_id_no=(String)rtn_str_rcpt_rfnd_id_no.get(i);
		    	 str_rcpt_rfnd_id_no=str_rcpt_rfnd_id_no.substring(0,str_rcpt_rfnd_id_no.length()-1);				 
				 str_nominee_name=(String)rtn_str_nominee_name.get(i);
		    	 str_nominee_name=str_nominee_name.substring(0,str_nominee_name.length()-1);				 
				 str_doc_sr_no=(String)rtn_str_doc_sr_no.get(i);
		    	 str_doc_sr_no=str_doc_sr_no.substring(0,str_doc_sr_no.length()-1);				 
				  str_bank_branch=(String)rtn_str_bank_branch.get(i);
		    	 str_bank_branch=str_bank_branch.substring(0,str_bank_branch.length()-1);				 
				 String slmt_code_flag=str_slmt_type+str_cash_slmt_flag;
				 str_slmt_short_desc=(String)rtn_str_slmt_short_desc.get(i);				  
		    	 str_slmt_short_desc=str_slmt_short_desc.substring(0,str_slmt_short_desc.length()-1);
				 str_bank_name=(String)rtn_str_bank_name.get(i);				
				 str_bank_name=str_bank_name.substring(0,str_bank_name.length()-1);			
				 str_online_app=(String)rtn_str_online_app.get(i);				
				 str_online_app=str_online_app.substring(0,str_online_app.length()-1);	
				 
%>
				<tr id=row<%=i%>>
				<tr>
				<td class=<%=classval%> width='5%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>	
				<td class=<%=classval%> width="5%"><INPUT TYPE="TEXT" name='billslmtamt<%=i%>' id='billslmtamt<%=i%>' SIZE="10" MAXLENGTH="20" 	VALUE='<%=str_doc_amt%>'  style='text-align:right' readonly> </td>					
				<td class=<%=classval%> width="5%" ><input type='text' name='shortdesc<%=i%>' id='shortdesc<%=i%>' size='20' maxlength='40' value='<%=str_slmt_short_desc%>'>
				<input type='hidden' name='Case' id='Case' value='1'><input type='hidden' name='slmttype<%=i%>' id='slmttype<%=i%>' value="<%=slmt_code_flag%>" readonly>
				</td>
				<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_given<%=i%>' id='cash_given<%=i%>' size='10' maxlength='30' value='<%=str_cash_amt_given%>' readonly> </td>
				<td class=<%=classval%> width="5%" class="fields"><input type='text' name='outstanding_amount<%=i%>' id='outstanding_amount<%=i%>' size='10' maxlength='30' value='<%=str_outstanding_amount%>' readonly> </td>
				<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_return<%=i%>' id='cash_return<%=i%>' size='10' maxlength='30' value='<%=str_cash_amt_return%>' readonly> </td>

				<td class=<%=classval%> width="6%" ><input type='text' name='instref<%=i%>' id='instref<%=i%>' size='10' maxlength='20' value='<%=str_slmt_doc_ref_desc%>' readonly>
				<td width="6%" class=<%=classval%>><input type='text' name='instdate<%=i%>' id='instdate<%=i%>' size='10' maxlength='10' value='<%=str_slmt_doc_ref_date%>' readonly></td>	
				<td width="10%" class=<%=classval%>><input type='text' readonly name='creditcardco<%=i%>' id='creditcardco<%=i%>' maxlength='30' size='10'  tabindex='0' value='' value='' readonly></td>
				<td class=<%=classval%> width="10%"><input type='text' readonly name='instbankname<%=i%>' id='instbankname<%=i%>' maxlength='60' size='15' value='<%=str_bank_name%>' readonly></td>  
				

				<td class=<%=classval%> width="6%"><input type='text' readonly name='instbranch<%=i%>' id='instbranch<%=i%>' maxlength='60' size='15' value='<%=str_bank_branch%>' ></td>  
				<input type= hidden name="instremarkcode<%=i%>" id="instremarkcode<%=i%>"  value='<%=str_bank_code%>'>	        
				
				 <td class=<%=classval%>width="4%"><input type='text' name='batchno<%=i%>' id='batchno<%=i%>' size='10' maxlength='10' value='<%=str_cc_batch_no%>' readonly></td>	
				 <td class=<%=classval%>width="5%" ><input type='text' name='apprrefno<%=i%>' id='apprrefno<%=i%>' size='10' maxlength='10' value='<%=str_app_ref_no%>' readonly></td>
				 <td class=<%=classval%>width="5%" ><input type='text' name='saledraftno<%=i%>' id='saledraftno<%=i%>' size='10' maxlength='10' value='<%=str_cc_sale_draft_no%>' readonly></td>
				 <td class=<%=classval%>width="6%" ><input type='text' name='payername<%=i%>' id='payername<%=i%>' size='20' maxlength='20' value='<%=str_payer_name%>' readonly></td>
				 <td width="5%" class=<%=classval%>><input type='text' name='recrefidno<%=i%>' id='recrefidno<%=i%>' size='20' maxlength='20' value='<%=str_rcpt_rfnd_id_no%>' readonly></td>
				<INPUT TYPE="HIDDEN" name='ext_acc_interface_yn<%=i%>' id='ext_acc_interface_yn<%=i%>' MAXLENGTH="10" VALUE=''>
				<INPUT TYPE="HIDDEN" name='ext_acc_fac_id<%=i%>' id='ext_acc_fac_id<%=i%>' MAXLENGTH="10" VALUE=''>
				<INPUT TYPE="HIDDEN" name='credit_card_machine_int_yn<%=i%>' id='credit_card_machine_int_yn<%=i%>' VALUE=''>
				<td width="6%" class=<%=classval%> ><input type='checkbox' name='onlineapproval<%=i%>' id='onlineapproval<%=i%>' value='<%=str_online_app%>' <%=str_online_app%> readonly  onclick='check_box(<%=i%>)'></td>					
				</tr>
<%				 //totalRecords=i;		


			}
			totalRecords=tot_rec;
			}catch(Exception ss)
				{
				System.out.println("Error in PkgEnterReceptRefundBean call :"+ss);
				ss.printStackTrace();
				}

		}	
		}
		else
		{
			for(int i=0;i<totalRecords;i++)
			{	
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}

%>
	<tr id=row<%=i%>>
	<tr>
	<td class=<%=classval%> width='5%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>	 
	<td class=<%=classval%> width="5%"><INPUT TYPE="TEXT" name='billslmtamt<%=i%>' id='billslmtamt<%=i%>' SIZE="10" MAXLENGTH="20" 	VALUE=''  style='text-align:right' readonly> </td>	
	<td class=<%=classval%> width="6%" ><input type='text' name='shortdesc<%=i%>' id='shortdesc<%=i%>' size='20' maxlength='40'>
	<input type='hidden' name='Case' id='Case' value='1'><input type='hidden' name='slmttype<%=i%>' id='slmttype<%=i%>' value='' readonly>

	</td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_given<%=i%>' id='cash_given<%=i%>' size='10' maxlength='20' value='' readonly> </td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='outstanding_amount<%=i%>' id='outstanding_amount<%=i%>' size='10' maxlength='20' value='' readonly> </td>
	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='cash_return<%=i%>' id='cash_return<%=i%>' size='10' maxlength='20' value='' readonly> </td>

	<td class=<%=classval%> width="6%" ><input type='text' name='instref<%=i%>' id='instref<%=i%>' size='10' maxlength='20' readonly></td> 
	<td width="6%" class=<%=classval%>><input type='text' name='instdate<%=i%>' id='instdate<%=i%>' size='10' maxlength='10' readonly></td>	
	<td width="10%" class=<%=classval%>><input type='text' readonly name='creditcardco<%=i%>' id='creditcardco<%=i%>' maxlength='30' size='10'  tabindex='0' value='' readonly></td>
	<td class=<%=classval%> width="10%"><input type='text' readonly name='instbankname<%=i%>' id='instbankname<%=i%>' maxlength='60' size='15' value='' readonly></td>  
	

	<td class=<%=classval%> width="6%"><input type='text' readonly name='instbranch<%=i%>' id='instbranch<%=i%>' maxlength='60' size='15' value='' ></td>  
	<input type= hidden name="instremarkcode<%=i%>" id="instremarkcode<%=i%>"  value=''>	        
	
	 <td class=<%=classval%>width="4%"><input type='text' name='batchno<%=i%>' id='batchno<%=i%>' size='10' maxlength='10' readonly></td>	
	 <td class=<%=classval%>width="5%" ><input type='text' name='apprrefno<%=i%>' id='apprrefno<%=i%>' size='10' maxlength='10' readonly></td>
	 <td class=<%=classval%>width="5%" ><input type='text' name='saledraftno<%=i%>' id='saledraftno<%=i%>' size='10' maxlength='10' value='' readonly></td>
	 <td class=<%=classval%>width="6%" ><input type='text' name='payername<%=i%>' id='payername<%=i%>' size='20' maxlength='20' value='' readonly></td>
	 <td width="5%" class=<%=classval%>><input type='text' name='recrefidno<%=i%>' id='recrefidno<%=i%>' size='20' maxlength='20' value='' readonly></td>
	<INPUT TYPE="HIDDEN" name='ext_acc_interface_yn<%=i%>' id='ext_acc_interface_yn<%=i%>' MAXLENGTH="10" VALUE=''>
	<INPUT TYPE="HIDDEN" name='ext_acc_fac_id<%=i%>' id='ext_acc_fac_id<%=i%>' MAXLENGTH="10" VALUE=''>
	<INPUT TYPE="HIDDEN" name='credit_card_machine_int_yn<%=i%>' id='credit_card_machine_int_yn<%=i%>' VALUE=''>
	<td width="6%" class=<%=classval%> ><input type='checkbox' name='onlineapproval<%=i%>' id='onlineapproval<%=i%>' value='' CHECKED readonly  onclick='check_box(<%=i%>)'></td>	
	
 </tr>
<%
		
//	 i++;
			 totalRecords=i;		
			}
		}
	}finally
	{
		session.removeAttribute("existing_records_array");

		if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
	}

%>
	</tbody>
	</table>
	</div>	
	<input type='hidden' name='total_records' id='total_records' value='<%=totalRecords%>'>
	<input type='hidden' name='checked_row' id='checked_row' value='' >	
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	<input type= hidden name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>
	<input type= hidden name="rtnCurrSlmt" id="rtnCurrSlmt"  value=''>

	<input type= hidden name="rtnCurrSlmtBAL" id="rtnCurrSlmtBAL"  value=''>

	<input type= hidden name="rtnPendSlmt" id="rtnPendSlmt"  value=''>
	<input type= hidden name="services_tot_records" id="services_tot_records"  value=''>
	<input type= hidden name="rtnArrayDt" id="rtnArrayDt"  value=''>
	<input type= hidden name="rtnArrayDocref" id="rtnArrayDocref"  value=''>
	<input type= hidden name="rtnArrayDocrefLine" id="rtnArrayDocrefLine"  value=''>
	<input type= hidden name="rtnArrayDocrefSeq" id="rtnArrayDocrefSeq"  value=''>

	<input type= hidden name="rtnBlngServCode" id="rtnBlngServCode"  value=''>

	<input type= hidden name="roundingamt" id="roundingamt"  value=''>
	<input type= hidden name="rtnTrxDate" id="rtnTrxDate"  value=''>
	<input type= hidden name="rtnPrtGrpHdrCode" id="rtnPrtGrpHdrCode"  value=''>
	<input type= hidden name="rtnPrtGrpLineCode" id="rtnPrtGrpLineCode"  value=''>
	<input type= hidden name="rtnUpdGrossChrgAmt" id="rtnUpdGrossChrgAmt"  value=''>
	<input type= hidden name="rtnUpdNetChrgAmt" id="rtnUpdNetChrgAmt"  value=''>

	<input type= hidden name="tot_rec_for_serv_insert" id="tot_rec_for_serv_insert"  value=''>


		<input type= hidden name="refnumber" id="refnumber"  value=''>
	
	<input type= hidden name="rec_refund_amt" id="rec_refund_amt"  value=''>
	<input type= hidden name="function_id" id="function_id"  value='<%=function_id%>'>
	<input type= hidden name="querystring" id="querystring"  value='<%=querystring%>'>

	<input type= hidden name="rcpt_rfnd_ind" id="rcpt_rfnd_ind"  value=''>
	<input type= hidden name="rcpt_nature_code" id="rcpt_nature_code"  value=''>
	<input type= hidden name="rcpt_type_code" id="rcpt_type_code"  value=''>
	<input type= hidden name="patient_id" id="patient_id"  value=" ">
	<input type= hidden name="episode_type" id="episode_type"  value=''>
	<input type= hidden name="episode_id" id="episode_id"  value=''>
	<input type= hidden name="visit_id" id="visit_id"  value="<%=visit_id%>">
	<input type= hidden name="encounter_id" id="encounter_id"  value=''>
	<input type= hidden name="cash_counter_code" id="cash_counter_code"  value='<%=cash_counter_code%>'>
	<input type= hidden name="shift_id" id="shift_id"  value=''>
	<input type= hidden name="doc_amt" id="doc_amt"  value=''>
	<input type= hidden name="narration" id="narration"  value=''>
	<input type= hidden name="ip_adm_trf_dep_ind" id="ip_adm_trf_dep_ind"  value=''>
	<input type= hidden name="rec_ref_format_ind" id="rec_ref_format_ind"  value=''>
	<input type= hidden name="rfnd_dep_in_use_yn" id="rfnd_dep_in_use_yn"  value=''>
	<input type= hidden name="pmnt_thru_mail" id="pmnt_thru_mail"  value=''>
	<input type= hidden name="ext_acc_facility_id" id="ext_acc_facility_id"  value=''>
	<input type= hidden name="ext_acc_code" id="ext_acc_code"  value=''>
	<input type= hidden name="ext_acc_dept_code" id="ext_acc_dept_code"  value=''>
	<input type= hidden name="mult_slmt_yn" id="mult_slmt_yn"  value=''>
 	<input type= hidden name="request_id" id="request_id"  value=''>
	<input type= hidden name="downtime_entry_yn" id="downtime_entry_yn"  value=''>
	<input type= hidden name="downtime_doc_type_code" id="downtime_doc_type_code"  value=''>
	<input type= hidden name="downtime_doc_num" id="downtime_doc_num"  value=''>
	<input type= hidden name="downtime_doc_date" id="downtime_doc_date"  value=''>
	<input type='hidden' name="downtime_reason_code" id="downtime_reason_code" value=''  onBlur="">
	<input type= hidden name="cc_machine_id" id="cc_machine_id"  value=''>
	<input type= hidden name="payers_add1" id="payers_add1"  value=''>
	<input type= hidden name="payers_add2" id="payers_add2"  value=''>
	<input type= hidden name="payers_add3" id="payers_add3"  value=''>
	<input type= hidden name="payers_tel_num" id="payers_tel_num"  value=''>
	<input type= hidden name="consolidated_receipt_yn" id="consolidated_receipt_yn"  value=''>
	<input type= hidden name="currdate" id="currdate"  value=''>
	<input type= hidden name="str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd" id="str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd"  value=''>
	<input type= hidden name="hand_without_counter_chk_out" id="hand_without_counter_chk_out"  value=''>
	<input type= hidden name="customercode" id="customercode"  value=''>
	<input type= hidden name="remark" id="remark"  value=''>
	<input type= hidden name="origdocnumber" id="origdocnumber"  value=''>
	<input type= hidden name="ref" id="ref"  value=''>
	<input type= hidden name="totalbill" id="totalbill"  value=''>
	<input type= hidden name="billpaid" id="billpaid"  value=''>
	<input type= hidden name="pkgSeqNo" id="pkgSeqNo"  value=''>		
	<input type= hidden name="total_settled_amt" id="total_settled_amt"  value=''>
			
	<!-- Added for MMS SCF 501.1 -->
	<input type= 'hidden' name="pkgSequenceNumber" id="pkgSequenceNumber"  value=''>
	<input type='hidden' name='pkgSequenceAmount' id='pkgSequenceAmount' value=''>
	<input type='hidden' name='splAgnDpstYN' id='splAgnDpstYN' value=''>
	<input type= 'hidden' name="splAgnDepEffFrom" id="splAgnDepEffFrom"  value=''>
	<input type='hidden' name='splAgnDepEffTo' id='splAgnDepEffTo' value=''>


</form>	 

<script>
		if(document.forms[0].function_id.value=='rcpt_rfnd' || document.forms[0].function_id.value=='PKG_BILLING')
		{			
			var rec_refund_amt=document.forms[0].rec_refund_amt.value;
			var querystring=document.forms[0].querystring.value;
			parent.frames[3].location.href="../../eBL/jsp/BLDepositBillSlmtTypeBtn.jsp?rec_refund_amt="+rec_refund_amt+"&"+querystring;	

		}
		else{
	//var query_string=document.forms[0].query_string.value;	
	parent.frames[3].location.href="../../eBL/jsp/BLDepositBillSlmtTypeBtn.jsp?<%=querystring%>";	
		}
</script>

</body>
</html>




