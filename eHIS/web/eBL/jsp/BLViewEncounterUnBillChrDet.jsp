<!DOCTYPE html>
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V210517			 17598			Common-ICN-0034				Mohana Priya K
----------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.*,webbeans.op.CurrencyFormat,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rscurr=null;	
	//HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	CurrencyFormat cf = new CurrencyFormat();
	String classval="";		int noofdecimal = 2;
	String strEpisodeType="";String strPatientId="";String strVisitId="";String strEpisodeId="";String strEncounterId="";
	String strServiceDate="";String strTrxDate="";String strUpdDiscAmt="";String strBlngServiceCode="";String strServiceQty="";
	String strUpdGrossChrAmt="";String strUpdNetChrAmt="";String strTrxDoc="";String strTrxStatus="";	
	String strFacilityId="";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	try{
			con	=	ConnectionManager.getConnection(request);
			strEpisodeType = request.getParameter("episode_type");
			if(strEpisodeType==null) strEpisodeType="";
			strPatientId = request.getParameter("patient_id");
			if(strPatientId==null) strPatientId="";	
			strVisitId = request.getParameter("visit_id");
			if(strVisitId==null || strVisitId.equals("")) strVisitId="";	
			strEpisodeId = request.getParameter("episode_id");
			if(strEpisodeId==null || strEpisodeId.equals("")) strEpisodeId="";
			strEncounterId=request.getParameter("encounter_id");
			if(strEncounterId==null || strEncounterId.equals("")) strEncounterId="";
			strFacilityId=request.getParameter("facility_id");
			if(strFacilityId==null || strFacilityId.equals("")) strFacilityId="";
		try{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}	
				if(rscurr != null) rscurr.close(); //V210517
				if (pstmt != null) pstmt.close();	//V210517
				//rscurr.close();
				//pstmt.close();					
				}
				catch(Exception e)
				{
					System.out.println("3="+e.toString());
					e.printStackTrace();
				}			
%>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
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
</head>
<body onLoad='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<form name='view_enctr_bill_det' id='view_enctr_bill_det' method='post' >
<%
	try{
			String sqlUnBillChrDet="SELECT to_char(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS') SERV_DATE, to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS') TRANS_DATE, BLNG_SERV_CODE, SERV_QTY, UPD_GROSS_CHARGE_AMT, UPD_DISC_AMT, UPD_NET_CHARGE_AMT, TRX_DOC_REF||'/'||TRX_DOC_REF_LINE_NUM||','||TRX_DOC_REF_SEQ_NUM TRX_DOC,TRX_STATUS FROM BL_PATIENT_CHARGES_FOLIO WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"' AND PATIENT_ID= '"+strPatientId+"' AND EPISODE_TYPE = '"+strEpisodeType+"'  and ('"+strEpisodeType+"' = 'R' OR ('"+strEpisodeType+"' <> 'R' and EPISODE_ID   = '"+strEpisodeId+"')  OR      ('"+strEpisodeType+"' in ('O','E') and EPISODE_ID   = '"+strEpisodeId+"' and VISIT_ID   = '"+strVisitId+"')) order by SERVICE_DATE desc";
			
			//AND EPISODE_TYPE = '"+strEpisodeType+"'  AND NVL(EPISODE_ID,'"+strEpisodeId+"')   =DECODE(EPISODE_TYPE,'R', NVL(EPISODE_ID,'"+strEpisodeId+"'),EPISODE_ID)AND NVL(VISIT_ID,'"+strVisitId+"') = DECODE(EPISODE_TYPE,'O',VISIT_ID, 'E',VISIT_ID,NVL(VISIT_ID,'"+strVisitId+"'))";
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlUnBillChrDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("SERV_DATE");
			displayFields.add("TRANS_DATE");
			displayFields.add("BLNG_SERV_CODE");
			displayFields.add("SERV_QTY");
			displayFields.add("UPD_GROSS_CHARGE_AMT");
			displayFields.add("UPD_DISC_AMT");
			displayFields.add("UPD_NET_CHARGE_AMT");
			displayFields.add("TRX_DOC");
			displayFields.add("TRX_STATUS");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
%>
	<div>
	<table  cellpadding=3 cellspacing=0 width="100%" align="center">
	<tr>
	<td class=label></td>		
	<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));		
	%>
	</td></tr>
	</table></div>
	<div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 310px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='enctr_bill_det' width='100%'>		
	<thead><tr>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='22%'><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>	
		</tr>
	</thead>
<%			
	int i=0;	
	/*try{
		String sqlChrDet="SELECT to_char(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'), to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'), BLNG_SERV_CODE, SERV_QTY, UPD_GROSS_CHARGE_AMT, UPD_DISC_AMT, UPD_NET_CHARGE_AMT, TRX_DOC_REF||'/'||TRX_DOC_REF_LINE_NUM||','||TRX_DOC_REF_SEQ_NUM TRX_DOC,TRX_STATUS FROM BL_PATIENT_CHARGES_FOLIO WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"' AND PATIENT_ID= '"+strPatientId+"' AND EPISODE_TYPE = '"+strEpisodeType+"'  AND NVL(EPISODE_ID,'"+strEpisodeId+"')   =DECODE(EPISODE_TYPE,'R', NVL(EPISODE_ID,'"+strEpisodeId+"'),EPISODE_ID)AND NVL(VISIT_ID,'"+strVisitId+"') = DECODE(EPISODE_TYPE,'O',VISIT_ID, 'E',VISIT_ID,NVL(VISIT_ID,'"+strVisitId+"'))";
		System.out.println("sqlChrDet: "+sqlChrDet);
		pstmt = con.prepareStatement(sqlChrDet);
		rs = pstmt.executeQuery();	
		while(rs.next())
		{				
			strServiceDate = rs.getString(1);
			if(strServiceDate==null) strServiceDate="";
			strTrxDate = rs.getString(2);	
			if(strTrxDate==null) strTrxDate="";
			strBlngServiceCode = rs.getString(3);
			if(strBlngServiceCode==null) strBlngServiceCode="";
			strServiceQty = rs.getString(4);	
			if(strServiceQty==null) strServiceQty="";
			strServiceQty = cf.formatCurrency(strServiceQty, noofdecimal);
			strUpdGrossChrAmt = rs.getString(5);
			if(strUpdGrossChrAmt==null) strUpdGrossChrAmt="";
			strUpdGrossChrAmt = cf.formatCurrency(strUpdGrossChrAmt, noofdecimal);
			strUpdDiscAmt = rs.getString(6);	
			if(strUpdDiscAmt==null) strUpdDiscAmt="";
			strUpdDiscAmt = cf.formatCurrency(strUpdDiscAmt, noofdecimal);
			strUpdNetChrAmt = rs.getString(7);
			if(strUpdNetChrAmt==null) strUpdNetChrAmt="";
			strUpdNetChrAmt = cf.formatCurrency(strUpdNetChrAmt, noofdecimal);
			strTrxDoc = rs.getString(8);	
			if(strTrxDoc==null) strTrxDoc="";
			strTrxStatus = rs.getString(9);	
			if(strTrxStatus==null) strTrxStatus="";
		*/					
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

			strServiceDate = (String)records.get(0);						
			if ( strServiceDate== null || strServiceDate.equalsIgnoreCase("null")){
				strServiceDate="";}
			
			strTrxDate=(String)records.get(1);
			if ( strTrxDate== null || strTrxDate.equalsIgnoreCase("null")){
				strTrxDate="";}

				strBlngServiceCode=(String)records.get(2);						
			if ( strBlngServiceCode== null || strBlngServiceCode.equalsIgnoreCase("null")){
				strBlngServiceCode="";}
			
			strServiceQty=(String)records.get(3);
			if ( strServiceQty== null || strServiceQty.equalsIgnoreCase("null")){
				strServiceQty="";}
				strServiceQty = cf.formatCurrency(strServiceQty, noofdecimal);

				strUpdGrossChrAmt=(String)records.get(4);						
			if ( strUpdGrossChrAmt== null || strUpdGrossChrAmt.equalsIgnoreCase("null")){
				strUpdGrossChrAmt="";}
				strUpdGrossChrAmt = cf.formatCurrency(strUpdGrossChrAmt, noofdecimal);
			
			strUpdDiscAmt=(String)records.get(5);
			if ( strUpdDiscAmt== null || strUpdDiscAmt.equalsIgnoreCase("null")){
				strUpdDiscAmt="";}
				strUpdDiscAmt = cf.formatCurrency(strUpdDiscAmt, noofdecimal);

				strUpdNetChrAmt=(String)records.get(6);						
			if ( strUpdNetChrAmt== null || strUpdNetChrAmt.equalsIgnoreCase("null")){
				strUpdNetChrAmt="";}
				strUpdNetChrAmt = cf.formatCurrency(strUpdNetChrAmt, noofdecimal);
			
			strTrxDoc=(String)records.get(7);
			if ( strTrxDoc== null || strTrxDoc.equalsIgnoreCase("null")){
				strTrxDoc="";}

				strTrxStatus=(String)records.get(8);
			if ( strTrxStatus== null || strTrxStatus.equalsIgnoreCase("null")){
				strTrxStatus="";}

			strServiceDate = com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale);
			strTrxDate = com.ehis.util.DateUtils.convertDate(strTrxDate,"DMYHMS","en",locale);
%>		<tbody>	
<tr id=row<%=i%>>			
	<td class=<%=classval%> width='15%'><%=strServiceDate%></td>	 
	<td class=<%=classval%> width='15%'><%=strTrxDate%></td>	 
	<td class=<%=classval%> width="8%" ><%=strBlngServiceCode%></td>
	<td class=<%=classval%> width='8%' style='text-align:right'><%=strServiceQty%></td>	 
	<td class=<%=classval%> width="8%" style='text-align:right'><%=strUpdGrossChrAmt%></td>
	<td class=<%=classval%> width="8%" style='text-align:right'><%=strUpdDiscAmt%></td>		
	<td class=<%=classval%> width="8%" style='text-align:right'><%=strUpdNetChrAmt%></td>	
	<td class=<%=classval%> width="22%"><%=strTrxDoc%></td>  			
</tr>
<%
	i++;		
	}//while
%>
	</tbody>	
	</table>
	</div>	
<%
	out.flush();
		}
	else {
%>
	<div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 250px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='enctr_bill_det' width='100%'>			
	<thead><tr>			
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='22%'><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>	
	</tr></thead>
	<tbody>
<%
	java.util.Locale loc = new java.util.Locale("en");
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
	String noRecord = bl_labels.getString("BL9813");
%>
	<tr>
		<td colspan='10'><div align='center'><%=noRecord%> </div></td>
	</tr>
	</tbody>
	</table></div>
	<script></script>
<%
	}
	}catch(Exception ee)
	{
		System.out.println("Exception in qry" +ee);
		ee.printStackTrace();
	}		 
	}catch(Exception eee)
	{
		System.out.println("Exception main"+ eee);
		eee.printStackTrace();
	}
	finally 
	{				
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
			}
	}
%>
</form>
<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLViewEncounterUnBillChrDet.jsp",searched));%>
</body>
</html>

