<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.*,webbeans.op.CurrencyFormat,com.ehis.util.*,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rscurr=null;
	ResultSet rs=null; ResultSet rs1=null;	
//	HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	int noofdecimal=2;
	CurrencyFormat cf = new CurrencyFormat();
	String strQryString=""; String strPatientId="";
	String tab_chk="";String strBillDocTypeCode=""; String strBillDocNum="";String strFacilityId="";
	String strDocDate=""; String strNoReminders="";String strTotAdjAmt="";	String strTotExemptAmt="";String strTotwritOffAmt="";
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
	String payDtlsTitle=(String) common_labels.getString("Common.PaymentDetails.label");
	String adjDtlsTitle=(String) bl_labels.getString("eBL.ADJUSTMENT_DETAILS.label");
	String exemptDtlsTitle=(String) bl_labels.getString("eBL.EXEMPTION_DETAILS.label");
	String remDtlsTitle=(String) bl_labels.getString("eBL.REMAINDER_DETAILS.label");
	String writDtlsTitle=(String) bl_labels.getString("eBL.WRITE_OFF_DETAILS.label");
	try
	{
			con	=	ConnectionManager.getConnection(request);
			strBillDocTypeCode=request.getParameter("doc_type");
			if(strBillDocTypeCode==null || strBillDocTypeCode.equals("")) strBillDocTypeCode="";
//			System.out.println("strBillDocTypeCode" +strBillDocTypeCode);
			strBillDocNum=request.getParameter("doc_num");

			if(strBillDocNum==null || strBillDocNum.equals("")) strBillDocNum="";
			strDocDate=request.getParameter("doc_date");
			if(strDocDate==null || strDocDate.equals("")) strDocDate="";
			strFacilityId=request.getParameter("facility_id");
			if(strFacilityId==null || strFacilityId.equals("")) strFacilityId="";

			strPatientId = request.getParameter("patient_id");
			if(strPatientId==null) strPatientId="";	
//			System.out.println("strPatientId  pay tab:"+strPatientId);

			tab_chk=request.getParameter("tab_chk");
			if(tab_chk==null) tab_chk="";
//			System.out.println("tab_chk:"+tab_chk);
			strQryString = request.getQueryString();
			if(strQryString==null || strQryString.equals("")) strQryString="";
//			System.out.println("strQryString pay tab:"+strQryString);
			try
					{		
						pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
						rscurr = pstmt.executeQuery();	
						while(rscurr.next())
						{
							noofdecimal  =  rscurr.getInt(1);		
						}	
						rscurr.close();
						pstmt.close();
					}
					catch(Exception e)
					{
						System.out.println("3="+e.toString());
					}


%>
<html>
<head>
<script>
	function tab_click(objName,errorMsg)
	{
		selectTab(objName);
		var doc_type = document.forms[0].doc_type.value;
		var doc_num = document.forms[0].doc_num.value;
		var doc_date = document.forms[0].doc_date.value;
		var facility_id	= document.forms[0].facility_id.value;
		var patient_id 	= document.forms[0].patient_id.value;
		window.parent.frames[1].document.location.href ="../../eBL/jsp/BLViewEncounterPaymentDet.jsp?tab_chk="+objName+"&doc_type="+doc_type+"&doc_num="+doc_num+"&doc_date="+doc_date+"&facility_id="+facility_id+"&patient_id="+patient_id;
	}
</script>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> 
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	try{
		
			String sqladj="Select count(1) v_no_of_reminders	from bl_bills_for_reminder where DOC_TYPE_CODE='"+strBillDocTypeCode+"'  AND doc_num = '"+strBillDocNum+"' ";             
//			System.out.println("sqladj: "+sqladj);
				pstmt = con.prepareStatement(sqladj);
				rs = pstmt.executeQuery();	
				while(rs.next())
								{
									strNoReminders  =  rs.getString(1);	
									if(strNoReminders==null) strNoReminders="0";
									strNoReminders = cf.formatCurrency(strNoReminders, noofdecimal);
//									System.out.println("strNoReminders :"+strNoReminders);
								}
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();	

							
			String sqladj1="SELECT BILL_TOT_ADJUST_AMT,BILL_TOT_EXEMPT_AMT,BILL_TOT_WRITE_OFF_AMT FROM BL_BILL_DCP_DTL_VW   WHERE OPERATING_FACILITY_ID ='"+strFacilityId+"' AND  DOC_TYPE_CODE='"+strBillDocTypeCode+"' AND DOC_NUM = '"+strBillDocNum+"' ";
//			System.out.println("sqladj1: "+sqladj1);
				pstmt = con.prepareStatement(sqladj1);
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
								{
									strTotAdjAmt  =  rs1.getString(1);
									if(strTotAdjAmt==null) strTotAdjAmt="0";
									strTotAdjAmt = cf.formatCurrency(strTotAdjAmt, noofdecimal);

									strTotExemptAmt  =  rs1.getString(2);
									if(strTotExemptAmt==null) strTotExemptAmt="0";
									strTotExemptAmt = cf.formatCurrency(strTotExemptAmt, noofdecimal);

									strTotwritOffAmt  =  rs1.getString(3);	
									if(strTotwritOffAmt==null) strTotwritOffAmt="0";
									strTotwritOffAmt = cf.formatCurrency(strTotwritOffAmt, noofdecimal);
//									System.out.println("strTotAdjAmt :"+strTotAdjAmt);
//									System.out.println("strTotExemptAmt :"+strTotExemptAmt);
//									System.out.println("strTotwritOffAmt :"+strTotwritOffAmt);
								}
					if (rs1 != null)   rs1.close();
					if (pstmt != null) pstmt.close();	

			
		}catch(Exception e)
		{
			System.out.println("Error1= "+e);
		}
		
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form >
<ul id="tablist" class="tablist">
	<script>prevTabObj='pymtdet_tab'</script>
	<li class="tablistitem" title="<%=payDtlsTitle%>">
		<a onclick="javascript:tab_click('pymtdet_tab','')" id="pymtdet_tab" class="tabClicked"  >
			<span class="tabSpanclicked" id="pymtdet_tabspan"><fmt:message key="Common.PaymentDetails.label" bundle="${common_labels}"/></span>
		</a>
	</li>
<%
	
	if(Float.parseFloat(strTotAdjAmt)!=0)
	{		
%>
		<li class="tablistitem" title="<%=adjDtlsTitle%>">
			<a onclick="javascript:tab_click('adjdet_tab','')" id="adjdet_tab" class="tabA"  >
				<span class="tabAspan" id="adjdet_tabspan"><fmt:message key="eBL.ADJUSTMENT_DETAILS.label" bundle="${bl_labels}"/></span>
			</a>
		</li>
<%
	}
		
	if(Float.parseFloat(strTotExemptAmt)!=0)
	{
%>	
		<li class="tablistitem" title="<%=exemptDtlsTitle%>">
			<a onclick="javascript:tab_click('exmtdet_tab','')" id="exmtdet_tab" class="tabA"  >
				<span class="tabAspan" id="exmtdet_tabspan"><fmt:message key="eBL.EXEMPTION_DETAILS.label" bundle="${bl_labels}"/></span>
			</a>
		</li>
<%
	}

		if(Float.parseFloat(strNoReminders)!=0)
		{
%>	
			<li class="tablistitem" title="<%=remDtlsTitle%>">
				<a onclick="javascript:tab_click('remdet_tab','')" id="remdet_tab" class="tabA"  >
					<span class="tabAspan" id="remdet_tabspan"><fmt:message key="eBL.REMAINDER_DETAILS.label" bundle="${bl_labels}"/></span>
				</a>
			</li>
<%
		}
	
			if(Float.parseFloat(strTotwritOffAmt)!=0)

			{
%>
				<li class="tablistitem" title="<%=writDtlsTitle%>">
					<a onclick="javascript:tab_click('writoffdet_tab','')" id="writoffdet_tab" class="tabA"  >
						<span class="tabAspan" id="writoffdet_tabspan"><fmt:message key="eBL.WRITE_OFF_DETAILS.label" bundle="${bl_labels}"/></span>
					</a>
			</li>
</ul>
<%
			}
		}catch(Exception ee){
		System.out.println("Error= "+ee);
		}
		finally 
			{				
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							 }
			}
%>

<input type='hidden' name='facility_id' id='facility_id' value='<%=strFacilityId%>' >
<input type='hidden' name='doc_type' id='doc_type' value='<%=strBillDocTypeCode%>' >
<input type='hidden' name='doc_num' id='doc_num' value='<%=strBillDocNum%>' >
<input type='hidden' name='doc_date' id='doc_date' value='<%=strDocDate%>' >
<input type='hidden' name='patient_id' id='patient_id' value='<%=strPatientId%>' >

</form>
</body>
</html>

