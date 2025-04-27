<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		Developer Name
-----------------------------------------------------------------------------------------------
1            V210211           13526         MOHE-CRF-0060 	              Shikha Seth
 -->
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con				= null;
	String params="",str_billed_YN="N";
//	String str_trx_doc_ref="",str_trx_doc_ref_line_num="";
//	Statement stmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	try
	{	
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);

		System.err.println("Query String in BLCallDiscOrSlmtPage.jsp:"+request.getQueryString());
		//V210211 START
		String str_ordering_facility_id = request.getParameter("ordering_facility_id");
		if (str_ordering_facility_id == null) str_ordering_facility_id = (String) session.getValue("facility_id");
		//V210211 END		
		String str_module_id=request.getParameter("module_id");
		if(str_module_id == null) str_module_id="";

		String str_patient_id=request.getParameter("patient_id");
		if(str_patient_id == null) str_patient_id="";

		String str_episode_id=request.getParameter("episode_id");
		if(str_episode_id == null) str_episode_id="";

		String str_visit_id=request.getParameter("visit_id");
		if(str_visit_id == null) str_visit_id="";

		String bl_items_sl_no = request.getParameter("bl_items_sl_no");
		if(bl_items_sl_no==null) bl_items_sl_no="";
		
		String str_encounter_id=request.getParameter("encounter_id");
		if(str_encounter_id == null) str_encounter_id="";

		String str_episode_type=request.getParameter("episode_type");
		if(str_episode_type == null) str_episode_type="";

		String str_clinic_code=request.getParameter("clinic_code");
		if(str_clinic_code == null) str_clinic_code="";

		if(str_clinic_code.equals(""))
		{
			str_clinic_code=request.getParameter("locn_code");
			if(str_clinic_code == null) str_clinic_code="";
		}

		String str_visit_type_code=request.getParameter("visit_type_code");
		if(str_visit_type_code == null) str_visit_type_code="";

		String str_physician_id=request.getParameter("physician_id");
		if(str_physician_id == null) str_physician_id="";

		String str_bill_group_code=request.getParameter("blng_grp");
		if(str_bill_group_code == null) str_bill_group_code="";

		if(str_bill_group_code.equals(""))
		{
			str_bill_group_code=request.getParameter("blnggrp");
			if(str_bill_group_code == null) str_bill_group_code="";
		}
		
		String str_bill_doc_type_code=request.getParameter("bill_doc_type_code");
		if(str_bill_doc_type_code == null) str_bill_doc_type_code="";

		String str_bill_doc_num=request.getParameter("bill_doc_num");
		if(str_bill_doc_num == null) str_bill_doc_num="";

		String str_slmt_reqd_yn=request.getParameter("slmt_reqd_yn");
		if(str_slmt_reqd_yn == null) str_slmt_reqd_yn="";

		String str_doc_no =request.getParameter("doc_no");
		if(str_doc_no == null) str_doc_no="";

		String str_store_code =request.getParameter("store_code");
		if(str_store_code == null) str_store_code="";

		String str_call_disc_function_YN=request.getParameter("call_disc_function_yn");
		if(str_call_disc_function_YN == null) str_call_disc_function_YN="N";

		String allow_chkout_with_bill_stmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");
		if(allow_chkout_with_bill_stmt_yn == null) allow_chkout_with_bill_stmt_yn="N";

		String str_function_id = request.getParameter("function_id");
		if(str_function_id == null) str_function_id="";
		
		String  calledFrom_UHID=request.getParameter("called_frmUHID");
		if(calledFrom_UHID == "" || calledFrom_UHID== null) calledFrom_UHID="N";

		if(str_module_id.equals("MP"))
			str_episode_type = "R";
		
		/*Added by Rajesh for ML-MMOH-CRF-0753*/
		String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
		if(billAlreadyPrinted == null || "null".equals(billAlreadyPrinted)){
			billAlreadyPrinted = "N";
		}
		
		// start  Corrected by Dhanasekar for  PH ST partial settlment
		
		StringBuffer strbuf = new StringBuffer();

	//	bl_items_sl_no = "QFSTSI-659,1";
		StringTokenizer str1 = new StringTokenizer(bl_items_sl_no ,";");
		StringTokenizer str = null;
		String strbufquery="";
		String tempValue=null;

		StringBuffer stbuf = new StringBuffer();
		int flag = 0;
		int flagMain = 0;
		
		
		  while (str1.hasMoreElements())
		 {
		 
		   tempValue = 	str1.nextToken();
		    
		   if(tempValue.length()>0)
			{
			str = new StringTokenizer(tempValue,",");	
			if(str.hasMoreElements())
			 {
				if(flagMain == 1) strbuf.append(" OR ");
					strbuf.append("(SEC_KEY_MAIN = '"+str.nextToken()+"'  AND (");
					flagMain = 1;
		  	        flag = 0;	 		  
			while(str.hasMoreElements())
			 {
		 
			if(flag ==1)   strbuf.append(" OR ");       
			  strbuf.append("SEC_KEY_LINE_NO LIKE ('"+str.nextToken()+"%')");
			 flag = 1;
			 }	
			strbuf.append("))");
		 }
			}
		}
		 

		 if(bl_items_sl_no.length()==0)
			  strbufquery="SEC_KEY_MAIN='"+str_doc_no+"'";
		 else 
			 strbufquery=strbuf.toString();
		
		
		// End  Corrected by Dhanasekar for  PH ST partial settlment
		
		
		
		
		
		
		
		

		if(str_call_disc_function_YN.equals("Y"))
		{
			try
			{
/*
				String sql1= " select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM from bl_patient_charges_interface where patient_id='"+str_patient_id+"' and episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and episode_type='"+str_episode_type+"' and PRIMARY_KEY_MAIN='"+str_doc_no+"' and PRIMARY_KEY_MODULE_ID='"+str_module_id+"'";
				System.err.println("strsql sql1 "+sql1);
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql1);	

				while(rs.next())
				{
					str_trx_doc_ref = rs.getString(1);
					str_trx_doc_ref_line_num = rs.getString(2);
				}	
				rs.close();
				stmt.close();
			   if(str_billed_YN == null) str_billed_YN="N";
			   System.err.println("str_billed_YN from query :"+str_billed_YN);

				sql1= " select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from bl_patient_charges_folio where patient_id='"+str_patient_id+"' and episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and episode_type='"+str_episode_type+"' and TRX_DOC_REF='"+str_trx_doc_ref+"' and TRX_DOC_REF_LINE_NUM='"+str_trx_doc_ref_line_num+"'";
*/	
				String sql1="";
/*				if(str_module_id.equals("AE"))
				{
					sql1 = "select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from  BL_PATIENT_CHARGES_FOLIO where TRX_DOC_REF in (select TRX_DOC_REF from bl_patient_charges_interface where SEC_KEY_MAIN='"+str_doc_no+"' and confirmed_yn='Y') and BILL_DOC_TYPE_CODE is not null and BILL_DOC_NUM is not null and patient_id='"+str_patient_id+"' and episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and episode_type='"+str_episode_type+"' and rownum=1 and ";
				}
				else
				{*/
					if(str_module_id.equals("PH") || (str_module_id.equals("ST")))
					{
						sql1 = "select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from  BL_PATIENT_CHARGES_FOLIO where (TRX_DOC_REF,TRX_DOC_REF_LINE_NUM) in (select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM from bl_patient_charges_interface where  "+strbufquery+"   and confirmed_yn='Y') and BILL_DOC_TYPE_CODE is not null and BILL_DOC_NUM is not null and patient_id=? and episode_id=? and visit_id=? and episode_type=? and  SETTLEMENT_IND ='C' and rownum=1";
					}
					else
					{
						sql1 = "select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from  BL_PATIENT_CHARGES_FOLIO where TRX_DOC_REF in (select TRX_DOC_REF from bl_patient_charges_interface where  "+strbufquery+"   and confirmed_yn='Y') and BILL_DOC_TYPE_CODE is not null and BILL_DOC_NUM is not null and patient_id=? and episode_id=? and visit_id=? and episode_type=? and  SETTLEMENT_IND ='C' and rownum=1";
					}
//				}

//				System.err.println("strsql sql1 "+sql1);

				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,str_patient_id);
				pstmt.setString(2,str_episode_id);
				pstmt.setString(3,str_visit_id);
				pstmt.setString(4,str_episode_type);
				rs = pstmt.executeQuery();	

				while(rs.next())
				{
				   str_billed_YN  =  rs.getString(1);
				   str_bill_doc_type_code  =  rs.getString(2);	
				   str_bill_doc_num  =  rs.getString(3);	
				}	
				rs.close();
				pstmt.close();
			   if(str_billed_YN == null) str_billed_YN="N";
			   if(str_bill_doc_num == null) str_bill_doc_num="";
			   if(str_bill_doc_type_code == null) str_bill_doc_type_code="";
//			   System.err.println("str_billed_YN from query :"+str_billed_YN);
			}
			catch(Exception e)
			{
				System.err.println("Error while calling BLCOMMON.BL_VALIDATE_UPD_FIN_DTLS :"+e);
			}
		}
		
		
		Boolean UHIDAMRISite=false;
		String UHIDAMRISiteSpec ="";
		try
		{
			
			UHIDAMRISite = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(UHIDAMRISite){
			UHIDAMRISiteSpec="Y";
		}
		else{
			UHIDAMRISiteSpec="N";
		}
		
		
		
		
		
		
		
%>

<html>
<head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script language='javascript'>
/*
	function callAdhocDiscFun()
	{
		var patient_id = document.forms[0].patient_id.value;
		var episode_type = document.forms[0].episode_type.value;
		var episode_id = document.forms[0].episode_id.value;
		var visit_id = document.forms[0].visit_id.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var module_id = document.forms[0].module_id.value;

		var dialogHeight    = '40' ;  
		var dialogWidth = '70' ; 
		var dialogTop = '100' ;  
		var center    = '1'  ;  
		var arguments =   ''; 
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; 
		var getUrl  =   "../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&module_id="+module_id+"&called_frm=OTH_MOD";

		retVal = window.showModalDialog(getUrl,arguments,features);

		if(retVal != null && retVal!="")
		{
			var retArray = retVal.split("|");

			var bill_doc_type_code = retArray[0];
			var bill_doc_num = retArray[1];
			var bill_slmt_reqd_YN = retArray[2];

			if(bill_slmt_reqd_YN =="Y")
			{
				callSlmtFun(bill_doc_type_code,bill_doc_num);
			}
			else
			{
				window.returnValue="SUCCESS";
				parent.window.close();
			}
		}
		else
		{
			window.returnValue="SUCCESS";
			parent.window.close();
		}
	}

	function callSlmtFun(bill_doc_type_code,bill_doc_num)
	{
		var store_code = document.forms[0].store_code.value;
		var module_id = document.forms[0].module_id.value;
		var bill_group_code = document.forms[0].bill_group_code.value;

		if(bill_doc_type_code != "" && bill_doc_num != "")
		{
			var retVal = new Array();		
			var center='1';
			var dialogTop = "100";
			var dialogHeight = "40" ;
			var dialogWidth = "70" ;
			var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
			var arguments = "" ;
			var column_sizes = escape("");               
			var column_descriptions ="";		

			var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+bill_doc_type_code+"&"+"billdocnum="+bill_doc_num+"&"+"storecode="+store_code+"&"+"blnggrp="+bill_group_code+"&"+"module_id="+module_id;	
			retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features);
		}
		window.returnValue="SUCCESS";
		parent.window.close();
	}
*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	if(str_call_disc_function_YN.equals("Y") && (str_billed_YN.equals("N") || str_bill_doc_num.equals("")))
	{
		System.err.println("Inside Discount variables forming logic");
		params="patient_id="+str_patient_id+"&episode_type="+str_episode_type+"&episode_id="+str_episode_id+"&visit_id="+str_visit_id+"&encounter_id="+str_encounter_id+"&module_id="+str_module_id+"&doc_no="+str_doc_no+"&store_code="+str_store_code+"&slmt_reqd_yn="+str_slmt_reqd_yn+"&called_frm=OTH_MOD&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&locn_code="+str_clinic_code+"&visit_type_code="+str_visit_type_code+"&function_id="+str_function_id+"&bl_items_sl_no="+bl_items_sl_no;
//		System.err.println("Inside Discount variables forming logic-later");
%>
<!--
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onLoad='callAdhocDiscFun()'>
-->
<head>
<% 



if("Y".equals(UHIDAMRISiteSpec) && ("Y").equals(calledFrom_UHID)){

	%>
	<title><fmt:message key="eBL.UHID_RENEW_CHARGE_DTLS.label" bundle="${bl_labels}"/></title>
	<%
	
}

else{
%>
	<title><fmt:message key="eBL.DISC_SLMT_FOR_ENC_CHARGE_DTLS.label" bundle="${bl_labels}"/></title>
	<% } %>
</head>
  <iframe name='main_frame' id='main_frame' SRC="../../eBL/jsp/BLAdhocDiscFrame.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:95vh;width:99vw'></iframe> 		
   	
<%
	}
	else
	{
		params="billdoctypecode="+str_bill_doc_type_code+"&"+"billdocnum="+str_bill_doc_num+"&"+"storecode="+str_store_code+"&"+"blnggrp="+str_bill_group_code+"&"+"module_id="+str_module_id+"&billAlreadyPrinted="+billAlreadyPrinted;
%>
<head>
<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/></TITLE>
</head>

		
<%
	if(str_module_id.equals("PH") || (str_module_id.equals("ST")))
		{
				params=params+"&ordering_facility_id="+str_ordering_facility_id; //V210211
%>
		<iFRAME name='main_frame' id='main_frame' SRC="../../eBL/jsp/BLStoreBillSlmtMain.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iFRAME>		
<%
		}
		else{
%>
		<iFRAME name='main_frame' id='main_frame' SRC="../../eBL/jsp/BLBillSlmtMain.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iFRAME>		
	<%
		}
%>
	
	
<!--
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onLoad="callSlmtFun('<%=str_bill_doc_type_code%>','<%=str_bill_doc_num%>')">
-->
<%
	}
%>
<form name='updPatFinDtls' id='updPatFinDtls' method='post' action=''>		

<input type='hidden' name='module_id' id='module_id' value='<%=str_module_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=str_patient_id%>'>
<input type='hidden' name='episode_id' id='episode_id' value='<%=str_episode_id%>'>
<input type='hidden' name='visit_id' id='visit_id' value='<%=str_visit_id%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=str_encounter_id%>'>
<input type='hidden' name='bill_group_code' id='bill_group_code' value='<%=str_bill_group_code%>'>
<input type='hidden' name='clinic_code' id='clinic_code' value='<%=str_clinic_code%>'>
<input type='hidden' name='visit_type_code' id='visit_type_code' value='<%=str_visit_type_code%>'>
<input type='hidden' name='physician_id' id='physician_id' value='<%=str_physician_id%>'>
<input type='hidden' name='episode_type' id='episode_type' value='<%=str_episode_type%>'>

<input type='hidden' name='doc_no' id='doc_no' value='<%=str_doc_no%>'>
<input type='hidden' name='store_code' id='store_code' value='<%=str_store_code%>'>
<input type='hidden' name='slmt_reqd_yn' id='slmt_reqd_yn' value='<%=str_slmt_reqd_yn%>'>
<input type='hidden' name='bill_doc_type' id='bill_doc_type' value='<%=str_bill_doc_type_code%>'>
<input type='hidden' name='bill_doc_num' id='bill_doc_num' value='<%=str_bill_doc_num%>'>

<input type='hidden' name='call_disc_function_yn' id='call_disc_function_yn' value='<%=str_call_disc_function_YN%>'>
<input type='hidden' name='query_string' id='query_string' value='<%=request.getQueryString()%>'>
<input type='hidden' name='ordering_facility_id' id='ordering_facility_id' value='<%=str_ordering_facility_id%>'>
	 
</form>
</body>

<%
	}
	catch(Exception e)
	{
		System.err.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}
%>
</html>



