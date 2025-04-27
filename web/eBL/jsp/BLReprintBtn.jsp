
<!--
Sr No       Version         TFS/Incident        SCF/CRF   				Developer Name
---------------------------------------------------------------------------------------------
1           V210622           17147     	 	PMG2021-COMN-CRF-0077		MuthkumarN
2			V220208			  28689				NMC-JD-CRF-0091				Manivel N
---------------------------------------------------------------------------------------------
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityId = (String) session.getAttribute("facility_id");
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
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();" onload="showData();">
	<form name='reprintBtn' id='reprintBtn' scrolling='no'>
		<div id='btnDiv' style="display: none;">
			<table width='100%' align="center">
			<tr>			
				
				<td width='15%'> </td>
				<td width='25%' align='right' >
						
		<%
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			ResultSet rs=null;
			String site_id="";
			//String demo_version="";//Commented against V210622
			boolean siteSpecBillItemDateWise = false;
			String siteSpecBillItemDateWiseYN = "";
			//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
			Connection con1 = null;
			boolean site3TierAlmoFeature = false;
			String site3TierAlmoFeatureYN = "";
			try {
					con1	=	ConnectionManager.getConnection(request);
					site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL","3TIERALMOFEATURE");
					if (site3TierAlmoFeature) {
						site3TierAlmoFeatureYN = "Y";
					}else {
						site3TierAlmoFeatureYN = "N";
					}
				} catch(Exception ex) {
					System.err.println("Error in BLReprintBtn.jsp for getting site3TierAlmoFeature Connection: "+ex);
					ex.printStackTrace();
				}finally{
						if(con1!=null) {
							ConnectionManager.returnConnection(con1, request);
						}
					}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1	
			try
			{
				con	=	ConnectionManager.getConnection(request);	
				String site_id_sql = "select customer_id from sm_site_param ";

				Statement stmt = con.createStatement();
				rs = stmt.executeQuery(site_id_sql);	

				if(rs.next())
				{
					site_id  =  rs.getString(1);	
				}
				if(rs!=null)   rs.close();
				if(stmt!=null) stmt.close();
			
			}
			catch(Exception eX)
			{	
				//out.println("Error= "+eX);
				eX.printStackTrace();			
			}
			//Added by Subha-V20180803/ML-MMOH-CRF-1173/Starts
			try {
				siteSpecBillItemDateWise = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BILL_MAIN_ITEM_DATE_WISE");
				System.out.println("siteSpecBillItemDateWise: "+siteSpecBillItemDateWise);
				if(siteSpecBillItemDateWise) {
					siteSpecBillItemDateWiseYN = "Y";
				}else {
					siteSpecBillItemDateWiseYN = "N";
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			//Added by Subha-V20180803/ML-MMOH-CRF-1173/Ends
			
				// Added for NMC-JD-CRF-0091
			String enableDigitalSignatureYN = "N";
			try 
			{
				boolean siteEnableDigitalSignatureYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","TO_ENABLE_DIGITAL_SIGNATURE");
				if (siteEnableDigitalSignatureYN) {
					enableDigitalSignatureYN = "Y";
				}else {
					enableDigitalSignatureYN = "N";
				}
			} catch(Exception ex) {
				System.err.println("Error in siteEnableDigitalSignatureYN Connection: "+ex);
				ex.printStackTrace();
			} finally{
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
			}
			
			/* Commented against V210622
			try
			{ 
				//con1	=	ConnectionManager.getConnection(request);	
				String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";
				
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(demo_identifier_sql);	

				if(rs2.next())
				{
					demo_version  =  rs2.getString(1);	
					System.out.println("demo_identifier" +demo_version);
				}
				if(rs2!=null)   rs2.close();
				if(stmt2!=null) stmt2.close();
				con.close();
		}
		catch(Exception eX){	
			out.println("Error 1= "+eX);			
		eX.printStackTrace();			
		}finally{
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
			}*/
			
			%>
	
	<script>
	$(document).ready(function(){
		
	if($('#report_type').val()=='R')
	{
		$('#payer_type').val('B');
	$('#payer_type').attr('disabled','disabled');
	}	else	{
		$('#payer_type').removeAttr('disabled');
	}
	
		
$('#report_type').click(function(){

	//alert($('#report_type').val());
	if($('#report_type').val()=='R')
		{
		$('#payer_type').val('B');
		$('#payer_type').attr('disabled','disabled');
	//$('#payer_type').val('B');
		}
	else
		{
		$('#payer_type').removeAttr('disabled');
		}
});
});	 

</script>
					<input name="chk_print_stamp_YN" id="chk_print_stamp_YN" type="checkbox" id="chk_print_stamp_YN" value="N" onclick="selPrintStamp(); ">
					 <span id="lbl_print_stamp_YN">Print Stamp</span>
					
					

					<select name='payer_type' id='payer_type' >

							<option value='C'><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option> <!--added against MOHE-CRF-0039--> 
							<option value='I'><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option> <!--added against MOHE-CRF-0039--> 
							<option value='B'><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option> <!--added against MOHE-CRF-0039--> 
							</option>

					</select> 
					<select name='report_type' id='report_type' >

							<option value='R'><fmt:message key="eBL.RePrint_Bill.label" bundle="${bl_labels}"/></option> <!--added against MOHE-CRF-0039--> 
							<option value='I'><fmt:message key="eBL.Reprint_Bill_Item_Wise.label" bundle="${bl_labels}"/></option> <!--added against MOHE-CRF-0039--> 
							<option value='D'><fmt:message key="eBL.Reprint_Bill_Date_Wise.label" bundle="${bl_labels}"/></option> <!--added against MOHE-CRF-0039--> 
							</option>
					</select> 
				
					
						<input class='button' type="button" name='btnSettlement' id='btnSettlement' value='Settlement' onclick='insertConsolidatedBill();' >
						<input class='button' type="button" name='btnCancel' id='btnCancel'  value='Cancel All' onclick='cancelAll();'>
						<input class='button' type="button" name='btnReprint' id='btnReprint' value='Reprint All' onclick='insertSyProgParamBulk();'>	
						<input class='button' type="button" name='btnReprint1' id='btnReprint1'  value='Print All' onclick='insertSyProgParamBulk();'>
							 
								          
		          </td>
				</tr>
			</table>
		
			<input type='hidden' name='facilityId' id='facilityId'  value='<%=facilityId %>'>
			<input type='hidden' name='site_id' id='site_id'  value='<%=site_id %>'>
			<!-- Commented against V210622
			<input type='hidden' name='demo_version' id='demo_version' id='demo_version' value=''>-->
			<input type='hidden' name='bilparam' id='bilparam'  value=''>
			<input type='hidden' name='siteSpecBillItemDateWiseYN'  id='siteSpecBillItemDateWiseYN' value='<%=siteSpecBillItemDateWiseYN %>'>
			<input type='hidden' name='site3TierAlmoFeatureYN'  id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN%>'>
			<input type='hidden' name='hid_chk_print_stamp_YN'  id='hid_chk_print_stamp_YN' value='N' />
			<input type='hidden' name='siteEnableDigitalSignatureYN'  id='siteEnableDigitalSignatureYN' value='<%=enableDigitalSignatureYN %>' />
			
		</div>
<script type="text/javascript">
function showData(){
	var site_id= document.getElementById('site_id').value;
	//var demo_version= document.getElementById('demo_version').value;//Commented against V210622
	var site3TierAlmoFeatureYN= document.getElementById('site3TierAlmoFeatureYN').value;
	var siteEnableDigitalSignatureYN = document.getElementById("siteEnableDigitalSignatureYN").value;
	
	//if( (site_id=='ALMO' || site3TierAlmoFeatureYN == 'Y') && (demo_version == 'Y')){//Commented against V210622
	if( (site_id=='ALMO' || site3TierAlmoFeatureYN == 'Y')){//removed demo_version against V210622
			 document.getElementById("btnSettlement").style.visibility = "visible";
			 document.getElementById("btnCancel").style.visibility = "visible";
			 document.getElementById("btnReprint").style.visibility = "visible";
			 document.getElementById("btnReprint1").style.visibility = "hidden";
		}
	else{
			document.getElementById("btnSettlement").style.visibility = "hidden";
			document.getElementById("btnCancel").style.visibility = "hidden";
			document.getElementById("btnReprint").style.visibility = "hidden";
			document.getElementById("btnReprint1").style.visibility = "visible";
	}
	
	if(siteEnableDigitalSignatureYN == 'Y'){
		 document.getElementById("chk_print_stamp_YN").style.visibility = "visible";
		 document.getElementById("lbl_print_stamp_YN").style.visibility = "visible";
	}
	else{
		document.getElementById("chk_print_stamp_YN").style.visibility = "hidden";
		document.getElementById("lbl_print_stamp_YN").style.visibility = "hidden";
	}
}
</script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



</form>
</body>
</html>

