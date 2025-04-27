<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           	Developer Name
----------------------------------------------------------------------------------------------
1            V210104             11948          NMC-JD-SCF-0127-TF      Mohana Priya K
2            V210624             17147     		PMG2021-COMN-CRF-0077		MuthkumarN
 -->

<%@ page language="java" contentType="text/html;charset=UTF-8"%>	
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar"  %>
    
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
<script language='javascript' src='../../eBL/js/BLReprintReport.js'></script>
<script type="text/javascript">

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var selectedBills = '';
	$(document).ready(function(event){
		$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
				e.preventDefault();
		    }
		});
	})
</script>
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
		.QRYEVEN
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
</style>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='selectedBillForm' id='selectedBillForm' target='messageFrame' method="POST" action="../../servlet/eBL.BLCancelRecordServlet">
	<input type='hidden' name='lastRowIndex' id='lastRowIndex' value='1'>
	<input type='hidden' name='mode' id='mode' value='multiple'>
	<div id="tableContainer">
		<table border='' id='tblSelectedReport' style="display: none;" cellpadding='3' cellspacing='0'  id='tbl' width='100%' >	
		<thead>
		<tr style="position: sticky;top: 0;">			
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
			<%
			//MOHE-SCF-0016
			HttpSession httpSession = request.getSession(false);				
			String p_facility_id = (String)httpSession.getValue("facility_id");
			//MOHE-SCF-0016
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			String site_id="";
			//String demo_version="";//Commented against V210624
			//Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
			Connection con2 = null;		
			boolean site3TierAlmoFeature = false;
			String site3TierAlmoFeatureYN = "";
			try {
					con2	=	ConnectionManager.getConnection(request);
					site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con2, "BL","3TIERALMOFEATURE");
					if (site3TierAlmoFeature) {
						site3TierAlmoFeatureYN = "Y";
					}else {
						site3TierAlmoFeatureYN = "N";
					}
				} catch(Exception ex) {
					System.err.println("Error in BLReprintSelected.jsp for getting site3TierAlmoFeature Connection: "+ex);
					ex.printStackTrace();
				}finally{
						if(con2!=null) {
							ConnectionManager.returnConnection(con2, request);
						}
					}
			//Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1				
			
			try{
				con	=	ConnectionManager.getConnection(request);	
				String site_id_sql = "select customer_id from sm_site_param ";

				Statement stmt = con.createStatement();
				ResultSet rs2 = stmt.executeQuery(site_id_sql);	

				if(rs2.next())
				{
				   site_id  =  rs2.getString(1);	
				}

				if(rs2!=null)   rs2.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception eX)
			{	
				//out.println("Error= "+eX);		
				eX.printStackTrace();
			}

		/* Commented against V210624
			try{ 
			//con1	=	ConnectionManager.getConnection(request);	
			//String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";

			String demo_identifier_sql = "select nvl(demo_version,'N') from bl_parameters where operating_facility_id = '"+p_facility_id+"'";//MOHE-SCF-0016

			Statement stmt2 = con.createStatement();
			ResultSet rs3 = stmt2.executeQuery(demo_identifier_sql);	

			if(rs3.next())
			{
				demo_version  =  rs3.getString(1);	
			}

			if(rs3!=null)   rs3.close();
			if(stmt2!=null) stmt2.close();
			con.close();
			}
			catch(Exception eX)
			{	
				out.println("Error 1= "+eX);
				eX.printStackTrace();
			}
			finally{
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
			}*/

		//Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		//if((site_id.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y")) && (demo_version.equals("Y"))){	
		if((site_id.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y"))) {//removed demo_version against V210624
		%>				
			<td class='COLUMNHEADER' id='removeAll' width='10%' style='cursor:pointer' onclick="RemoveAllTooltip(this);" onmouseover="hideToolTip();"><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/>		
			<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow'> 
			</td>
		<%}	else{ %>					
			<td class='COLUMNHEADER' width='7%'> <fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>	
		<%} %>	
			<td class='COLUMNHEADER' width='13%' ><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>	
			<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>		
			<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.BillPaidAmt.label" bundle="${bl_labels}"/></td>	 <!--added against MOHE-CRF-0039--> 
			<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.BillOutStdAmt.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039--> 
		<%
			//if((site_id.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y")) && (demo_version.equals("Y"))){
			if((site_id.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y"))) {
			//removed demo_version against V210624
		%>
			<td class='COLUMNHEADER' width='9%'><fmt:message key="eBL.Bill_slmt_amt.label" bundle="${bl_labels}"/></td>	<!--added against mohe-crf-0038.4-->
			<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.Print_Bill.label" bundle="${bl_labels}"/> </td> <!--added against mohe-crf-0038.4-->	
		<%} %>		
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<!-- 	Karthik Commented to Remove Billing class code -->
			<%-- 	<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.Bill_CLASS_CODE.label" bundle="${common_labels}"/> </td>			 --%>
			<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'style="white-space: nowrap"><fmt:message key="eBL.PAYER_CODE.label" bundle="${bl_labels}"/> </td>	
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%''><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
			
		<% //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
			//if(site_id.equals("ALMO") && (demo_version.equals("Y"))){
			//if((site_id.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y")) && (demo_version.equals("Y"))){ //V210104
			if((site_id.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y"))) {
			//removed demo_version against V210624
		%>			
			<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.Exempted_Amount.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039--> 	
			<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.DrugPenalty.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039--> 	
			 
		<%} %>
		</tr>
		</thead>
		<tbody id='selectedReportBody'>
		
		</tbody>
		</table>		
		<input type='hidden' name='indexTrack' id='indexTrack' value='0'/>
		<input type='hidden' name='tempPatientId'  id='tempPatientId1' value='0'/>
		<input type='hidden' name='tempPayerCode' id='tempPayerCode1' value='0'/>
		<input type='hidden' name='chkValue' id='chkValue1' value='0'/>
		<input type='hidden' name='chkColumn' id='chkColumn1' value='0'/>
		<input type='hidden' name='site_id' id='site_id' value=''/>	
		<!-- <input type='hidden' name='demo_version' id='demo_version' id='demo_version' value=''/> //removed demo_version against V210624 -->
		<input type='hidden' name='site_id' id='site_id' value='<%=site_id %>'>
		<input type='hidden' name='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'>
	</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
				<!-- </td> -->
			</tr>
		</table>
		</div>
	</body>
	</TBODY>	
	</div>
</body>
</html>

