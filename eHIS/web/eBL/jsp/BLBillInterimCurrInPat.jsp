<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt1				= null;
	PreparedStatement pstmt = null ;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	String locale="";
	String p_facility_id="";

	String classval="";
	int total_records=0;
	String p_nursing_unit_code="";
	String p_payer_code="";
	String p_patient_id="";
	String p_payer_type="";
	String p_pay_amt_exce="";
	String strPatientId=""; String strPatientName=""; String strPatientNameLocLang="";
	String strEpisodeType=""; String strOpenEpisodeId=""; String strAdmDateTime="";
	String strCurrRoomNum=""; String strCurrBedNum=""; String strCustCode="";
	String strUnBldAmt=""; String strOutstdAmt="";String strTotAmt="";String str_no_of_deci="",strPolicyTypeCode="",strCustDesc="",strPolicyDesc="";
	String int_bill_gen_freq="";
	String sys_date="";
	int  no_of_decimals=0;
	boolean searched = (request.getParameter("searched") == null) ?false:true;	

	try
	{	
		HttpSession httpSession = request.getSession(false);
//		Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);		
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_nursing_unit_code=request.getParameter("nursing_unit_code");
		if(p_nursing_unit_code==null || p_nursing_unit_code.equals("")) p_nursing_unit_code="";
		p_payer_code=request.getParameter("payer_code");
		if(p_payer_code==null || p_payer_code.equals("")) p_payer_code="";
		p_patient_id=request.getParameter("patient_id");
		if(p_patient_id==null || p_patient_id.equals("")) p_patient_id="";
		p_payer_type=request.getParameter("payer_type");
		if(p_payer_type==null || p_payer_type.equals("")) p_payer_type="";
		p_pay_amt_exce=request.getParameter("pay_amt_exce");
		if(p_pay_amt_exce==null || p_pay_amt_exce.equals("")) p_pay_amt_exce="";
		str_no_of_deci=request.getParameter("no_of_deci");
		if(str_no_of_deci==null || str_no_of_deci.equals("")) str_no_of_deci="";
		no_of_decimals=Integer.parseInt(str_no_of_deci);		
		int_bill_gen_freq=request.getParameter("int_bill_gen_freq");
		if(int_bill_gen_freq==null) int_bill_gen_freq="";
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}

%>
	<HTML>
		<HEAD>
<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
		</HEAD> 

<script>
		function selected(i)
		{			
			/*if(document.forms[0].select_all.checked)
			{
				document.forms[0].select_all.checked=false;
			}*/
			var selected_row=eval("document.forms[0].selected_row"+i);		
			 if(selected_row.checked==false)
			 {	
				selected_row.checked=false;
				document.resultForm.checked_row.value="";				
			 }
			 else
			   {					
				var total_records=document.forms[0].total_records.value;					
				 for(var j=0;j<total_records;j++)
				  { 
					var temp=eval("document.resultForm.selected_row"+j);					
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

		function no_record_check()
		{
			var total_records=document.forms[0].total_records.value;
			if(total_records==0)
			{
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
//				history.go(-1);
				document.location.href="../../eCommon/html/blank.html";
			}
			parent.frames[0].document.forms[0].total_records.value=total_records;
		}

</script>
   <body onLoad="no_record_check();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
	 <form name='resultForm' id='resultForm' method='post' action=''  scrolling=no target='dummy_frame'>	
	<!-- <table border='0' cellpadding='3' cellspacing='0' align = 'center'  width='100%'>	
	<tr> <td class="label" width="100%"><b><fmt:message key="eBL.CURR_IPS.label"  bundle="${bl_labels}"/></b></td> </tr>	
	</table>-->
<%
	try
	{
//		String query_refresh="Select a.PATIENT_ID,	PATIENT_NAME,	PATIENT_NAME_LOC_LANG,	b.EPISODE_TYPE,	OPEN_EPISODE_ID,to_char(a.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') ADM_DATE, CUR_ROOM_NUM,	CUR_BED_NUM,	a.CUST_CODE, a.POLICY_TYPE_CODE,	NVL(UNBLD_AMT,0) UNBILLED_AMT,	NVL(OUTST_AMT,0) OUTSTD_AMT,	NVL(UNBLD_AMT,0)+NVL(OUTST_AMT,0) TOT_AMT FROM BL_UNBLD_OUTST_VW a,bl_episode_fin_dtls b,bl_encounter_payer_priority c WHERE a.facility_id = b.operating_facility_id and a.open_episode_id=b.episode_id and b.operating_facility_id=c.operating_facility_id and b.episode_id=c.episode_id and b.cur_acct_seq_no=c.acct_seq_no and (a.cust_code is null or ((a.cust_code is not null and a.cust_code=c.cust_code) and (a.policy_type_code is not null and a.policy_type_code=c.policy_type_code) or a.policy_type_code is null) ) and (sysdate - nvl(c.inh_bill_gen_date,sysdate)) >=nvl('"+int_bill_gen_freq+"',0) and FACILITY_ID = '"+p_facility_id+"' AND CUR_WARD_CODE =  NVL('"+p_nursing_unit_code+"',CUR_WARD_CODE) AND a.PATIENT_ID = NVL('"+p_patient_id+"', a.PATIENT_ID) AND (('"+p_payer_type+"' = 'P' AND a.CUST_CODE IS NULL) OR ('"+p_payer_type+"' = 'I' AND a.cust_code is not null AND a.CUST_CODE = NVL('"+p_payer_code+"',a.CUST_CODE)) 	OR ('"+p_payer_type+"' = 'B')) and	NVL(UNBLD_AMT,0)+NVL(OUTST_AMT,0) > '"+p_pay_amt_exce+"'  and not exists (SELECT 'x' FROM   IP_DISCHARGE_ADVICE_his_vw b 		WHERE  a.FACILITY_ID = b.FACILITY_ID AND a.OPEN_EPISODE_ID=b.EPISODE_ID	AND    NVL(DIS_ADV_STATUS,' ') != '9' 		AND ROWNUM = 1) ";
// Query Changes by Manivel on 9th Oct'2007 as it needs some enhancement and tuning
		String query_refresh="Select a.PATIENT_ID, PATIENT_NAME, PATIENT_NAME_LOC_LANG,	b.EPISODE_TYPE,	OPEN_EPISODE_ID,to_char(a.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') ADM_DATE, CUR_ROOM_NUM, CUR_BED_NUM,	a.CUST_CODE, a.POLICY_TYPE_CODE, NVL(UNBLD_AMT,0) UNBILLED_AMT,	NVL(OUTST_AMT,0) OUTSTD_AMT, NVL(UNBLD_AMT,0)+NVL(OUTST_AMT,0) TOT_AMT FROM BL_UNBLD_OUTST_VW a,bl_episode_fin_dtls b WHERE ( SELECT sysdate - nvl(inh_bill_gen_date,sysdate)  FROM bl_encounter_payer_priority  WHERE OPERATING_FACILITY_Id=A.FACILITY_Id   AND EPISODE_TYPE=A.EPISODE_TYPE AND PATIENT_ID =A.PATIENT_ID AND EPISODE_ID = A.OPEN_EPISODE_ID AND ACCT_SEQ_NO = B.CUR_ACCT_SEQ_NO AND BLNG_GRP_ID=A.BLNG_GRP_ID AND ( cust_code is null or (cust_code is not null and CUST_CODE = A.CUST_CODE)) AND (POLICY_TYPE_CODE is null or (POLICY_TYPE_CODE is not null and POLICY_TYPE_CODE=A.POLICY_TYPE_CODE ))) >=nvl('"+int_bill_gen_freq+"',0) and a.facility_id = b.operating_facility_id and a.open_episode_id=b.episode_id and FACILITY_ID = '"+p_facility_id+"' AND CUR_WARD_CODE =  NVL('"+p_nursing_unit_code+"',CUR_WARD_CODE) AND a.PATIENT_ID = NVL('"+p_patient_id+"', a.PATIENT_ID) AND (('"+p_payer_type+"' = 'P' AND a.CUST_CODE IS NULL) OR ('"+p_payer_type+"' = 'I' AND a.cust_code is not null AND a.CUST_CODE = NVL('"+p_payer_code+"',a.CUST_CODE)) OR ('"+p_payer_type+"' = 'B')) and	NVL(UNBLD_AMT,0)+NVL(OUTST_AMT,0) >'"+p_pay_amt_exce+"' and not exists (SELECT 'x' FROM IP_DISCHARGE_ADVICE_his_vw b WHERE  a.FACILITY_ID = b.FACILITY_ID AND a.OPEN_EPISODE_ID=b.EPISODE_ID AND NVL(DIS_ADV_STATUS,' ') != '9' AND ROWNUM = 1) AND NVL(UNBLD_AMT,0) > 0";
		
		HashMap sqlMap = new HashMap();

		sqlMap.put("sqlData",query_refresh);
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();
		displayFields.add("PATIENT_ID");
		displayFields.add("PATIENT_NAME");
		displayFields.add("PATIENT_NAME_LOC_LANG");
		displayFields.add("EPISODE_TYPE");
		displayFields.add("OPEN_EPISODE_ID");
		displayFields.add("ADM_DATE");
		displayFields.add("CUR_ROOM_NUM");
		displayFields.add("CUR_BED_NUM");
		displayFields.add("CUST_CODE");
		displayFields.add("POLICY_TYPE_CODE");
		displayFields.add("UNBILLED_AMT");
		displayFields.add("OUTSTD_AMT");
		displayFields.add("TOT_AMT");

/*			ArrayList chkFields = new ArrayList();
		chkFields.add(doc_type_code);
		chkFields.add(doc_no);
		chkFields.add(store_code);
		chkFields.add(from_doc_date);
		chkFields.add(to_doc_date);
		chkFields.add(user_name);
		chkFields.add(language_id);
		System.err.println("chkFields----------->" +chkFields);
		
*/			// Adding function related array list into the HashMap
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		//out.println("resutl==>"+result.size());
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
		{
%>
	<!--<table cellpadding=0 cellspacing=0 width="100%" ><tr>
		<%out.println(result.get(1));System.out.println("resutl==>"+result.get(1));
		%></td>	</tr>
		</table>-->
			<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='bill_interim_det' width='100%'>			
				<tr>
					<td class="COLUMNHEADER" colspan="14"><fmt:message key="eBL.CURR_IPS.label"  bundle="${bl_labels}"/></td>
				</tr>
				<tr>
<%			
					out.println(result.get(1));
%>
					</td>
					<td colspan="14">&nbsp;</td>
				</tr>
				<tr>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.ADJUST_DEPOSIT.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.PREPAY_ADJUST_YN.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>	
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>	
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.total.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="5%"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>	
					<td class='COLUMNHEADER' width="5%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>	
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				</tr>
<%				
					int i=0;	
					ArrayList records=new ArrayList();
					for(int j=2; j<result.size(); j++)
					{			
						if(i % 2 == 0 )
						{
							classval	=	"QRYEVEN";
						}
						else
						{
							classval	=	"QRYODD";
						}
						records=(ArrayList) result.get(j);

						strPatientId=(String)records.get(0);
						if ( strPatientId== null || strPatientId.equalsIgnoreCase("null")){
							strPatientId="";}
						
						strPatientName=(String)records.get(1);
						if ( strPatientName== null || strPatientName.equalsIgnoreCase("null")){
							strPatientName="";}
						
						strPatientNameLocLang=(String)records.get(2);
						if ( strPatientNameLocLang== null || strPatientNameLocLang.equalsIgnoreCase("null")){
							strPatientNameLocLang="";}
						
						strEpisodeType=(String)records.get(3);
						if ( strEpisodeType== null || strEpisodeType.equalsIgnoreCase("null")){
							strEpisodeType="";}
						
						strOpenEpisodeId=(String)records.get(4);
						if ( strOpenEpisodeId== null || strOpenEpisodeId.equalsIgnoreCase("null")){
							strOpenEpisodeId="";}
						
						strAdmDateTime=(String)records.get(5);
						if ( strAdmDateTime== null || strAdmDateTime.equalsIgnoreCase("null")){
							strAdmDateTime="";}
						
						strCurrRoomNum=(String)records.get(6);
						if ( strCurrRoomNum== null || strCurrRoomNum.equalsIgnoreCase("null")){
							strCurrRoomNum="";}
						
						strCurrBedNum=(String)records.get(7);
						if ( strCurrBedNum== null || strCurrBedNum.equalsIgnoreCase("null")){
							strCurrBedNum="";}
						
						strCustCode=(String)records.get(8);
						if ( strCustCode== null || strCustCode.equalsIgnoreCase("null")){
							strCustCode="";}
						
						strPolicyTypeCode=(String)records.get(9);
						if ( strPolicyTypeCode== null || strPolicyTypeCode.equalsIgnoreCase("null")){
							strPolicyTypeCode="";}
						
						strUnBldAmt=(String)records.get(10);
						if ( strUnBldAmt== null || strUnBldAmt.equalsIgnoreCase("null")){
						strUnBldAmt="";}
						
						strOutstdAmt=(String)records.get(11);
						if ( strOutstdAmt== null || strOutstdAmt.equalsIgnoreCase("null")){
							strOutstdAmt="";}
						
						strTotAmt=(String)records.get(12);
						if ( strTotAmt== null || strTotAmt.equalsIgnoreCase("null")){
							strTotAmt="";}
						
						strCustDesc ="";
						String sqlcc="select SHORT_NAME from ar_customer_lang_vw where CUST_CODE='"+strCustCode+"' and language_id='"+locale+"'";
						pstmt=con.prepareStatement(sqlcc);
						
						rs2=pstmt.executeQuery();
						while(rs2.next())
						{
							strCustDesc =rs2.getString(1);
							if ( strCustDesc == null || strCustDesc.equalsIgnoreCase("null")) 
							 strCustDesc = "";	
						}
						rs2.close();
						pstmt.close();
						
						strPolicyDesc="";
						String sqlpc="select SHORT_DESC from  bl_ins_policy_types_lang_vw where POLICY_TYPE_CODE='"+strPolicyTypeCode+"' and language_id='"+locale+"'";
						pstmt=con.prepareStatement(sqlpc);
						
						rs3=pstmt.executeQuery();
						while(rs3.next())
						{
							strPolicyDesc =rs3.getString(1);
							if ( strPolicyDesc == null || strPolicyDesc.equalsIgnoreCase("null")) 
							strPolicyDesc = "";	
						}
						rs3.close();
						pstmt.close();
						
						CurrencyFormat cf1 = new CurrencyFormat();
						
						strUnBldAmt = cf1.formatCurrency(strUnBldAmt,no_of_decimals);
						strOutstdAmt = cf1.formatCurrency(strOutstdAmt,no_of_decimals);
						strTotAmt = cf1.formatCurrency(strTotAmt,no_of_decimals);

						if(strEpisodeType.equals("I"))
						{
							strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
						}
						else if(strEpisodeType.equals("O"))
						{
							strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
						}
						else if(strEpisodeType.equals("E"))
						{
							strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
						}
						else if(strEpisodeType.equals("D"))
						{
							strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
						}
						else if(strEpisodeType.equals("R"))
						{
							strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
						}
%>
				<tr id=row<%=i%>>
					<td class=<%=classval%> width='9%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>	 
					<td class=<%=classval%> width="5%"><INPUT TYPE="TEXT" name='patient_id<%=i%>' id='patient_id<%=i%>' SIZE="10" MAXLENGTH="20" 	VALUE='<%=strPatientId%>'   readonly> </td>		
					<td class=<%=classval%> width="5%" ><input type='text' name='patient_name<%=i%>' id='patient_name<%=i%>' size='10' maxlength='20' value='<%=strPatientName%>' readonly></td>
					<td class=<%=classval%> width="5%" ><input type='text' name='cust_desc<%=i%>' id='cust_desc<%=i%>' size='10' maxlength='20' value='<%=strCustDesc%>' readonly></td>
					<input type='hidden' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=strCustCode%>'>
					<td class=<%=classval%> width="5%" ><input type='text' name='policy_type<%=i%>' id='policy_type<%=i%>' size='10' maxlength='20' value='<%=strPolicyDesc%>' readonly></td>
					<td width="5%" class=<%=classval%> ><input type='checkbox' name='adjust_dep<%=i%>' id='adjust_dep<%=i%>' value=''></td>		
					<td width="5%" class=<%=classval%> ><input type='checkbox' name='prepay_adj_yn<%=i%>' id='prepay_adj_yn<%=i%>' value=''></td>		
					<td width="5%" class=<%=classval%>><input type='text' readonly name='unbill_amt<%=i%>' id='unbill_amt<%=i%>' maxlength='30' size='10'   value='<%=strUnBldAmt%>' readonly style='text-align:right'></td>
					<td class=<%=classval%> width="5%"><input type='text' readonly name='outstand_amt<%=i%>' id='outstand_amt<%=i%>' maxlength='60' size='10' value='<%=strOutstdAmt%>' readonly style='text-align:right'></td>  
					<td class=<%=classval%> width="5%"><input type='text' readonly name='total_amt<%=i%>' id='total_amt<%=i%>' maxlength='60' size='10' value='<%=strTotAmt%>' style='text-align:right'></td>  
					<td class=<%=classval%> width="5%" class="fields"><input type='text' name='episode_type<%=i%>' id='episode_type<%=i%>' size='10' maxlength='30' value='<%=strEpisodeType%>' readonly> </td>
					<input type='hidden' name='episode_id<%=i%>' id='episode_id<%=i%>' value='<%=strOpenEpisodeId%>'>
					<td class=<%=classval%> width="5%" class="fields"><input type='text' name='adm_date<%=i%>' id='adm_date<%=i%>' size='10' maxlength='30' value='<%=com.ehis.util.DateUtils.convertDate(strAdmDateTime,"DMYHMS","en",locale)%>' readonly> </td>
					<td class=<%=classval%> width="5%" ><input type='text' name='room_no<%=i%>' id='room_no<%=i%>' size='8' maxlength='20' readonly value='<%=strCurrRoomNum%>'>
					<td width="5%" class=<%=classval%>><input type='text' name='bed_no<%=i%>' id='bed_no<%=i%>' size='8' maxlength='10' readonly value='<%=strCurrBedNum%>'></td>			
				</tr>
 <%
						i++;
						total_records++; 
 					}//while
			//}//if
%>		 
		</table>
<%
			out.flush();
			try
			{
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				stmt1 = con.createStatement();
				rs4 = stmt1.executeQuery(query_date) ;
				if( rs4 != null ) 
				{
					while( rs4.next() )
					{  
						sys_date = rs4.getString(1);
					}
				}
				if(rs4 !=null) rs4.close();
				stmt1.close();

				if(!locale.equals("en"))
				{
					sys_date = com.ehis.util.DateUtils.convertDate(sys_date,"DMYHMS","en",locale) ;
				}
			}
			catch(Exception e)
			{
				out.println("Exception @ sysdate"+e);
			}
		}
		else
		{
%>
			<script></script>
<%
		}
	//out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLBillInterimCurrInPat.jsp",searched));
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}
	finally
	{
		if (rs1 != null)   rs1.close();
		if (pstmt != null) pstmt.close();
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
	<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
	<input type='hidden' name='checked_row' id='checked_row' value='' >
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>' >

	<script>parent.frames[2].location.href='../../eCommon/html/blank.html';</script>	
	<script>parent.frames[0].document.forms[0].search_but.value=getLabel("Common.Ason.label","common_labels")+" "+document.forms[0].sys_date.value;</script>	
</form>
<%
	out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLBillInterimCurrInPat.jsp",searched));
%>
</body>
</HTML>

