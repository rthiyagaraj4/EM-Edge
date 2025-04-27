<!DOCTYPE html>
<!--
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1	   		 V211118            23078	      PMG2021-COMN-CRF-0076.1      Mohana Priya
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*,eBL.PkgAdhocDiscountBean" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 



<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgAdhocDiscount.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


$(document).ready(function(){
	var totalRec = $('#totalRec').val();
	for(i=0;i<totalRec;i++){
		if($('#disableForEmpty'+i).val() == 'Y'){
			$('#adhocDiscount_'+i).prop('readonly',true);
			$('#reason_desc'+i).prop('readonly',true);
			$('#reasonbut'+i).prop('disabled',true);	
			$('#del_rec'+i).prop('disabled',true);
			
			$('#adhocDiscount_'+i).unbind('blur');
			$('#reason_desc'+i).unbind('blur');
			
			$('#adhocDiscount_'+i).off('blur');
			$('#reason_desc'+i).off('blur');
			
			$('#adhocDiscount_'+i).attr('onblur','');
			$('#reason_desc'+i).attr('onblur','');
		}
	}
	
});


function auth_check()
{
		
	var auth_discount = "";
	if(document.forms[0].auth_discount.value=="")
	{				
		auth_discount = parent.frames[0].document.forms[0].auth_discount.value;
		document.forms[0].auth_discount.value = parent.frames[0].document.forms[0].auth_discount.value;		
		//auth_discount = 'Y'';
		document.forms[0].auth_discount.value = parent.frames[0].document.forms[0].auth_discount.value;	
	}
	else
	{			
		auth_discount = document.forms[0].auth_discount.value;
	}
}

function del_check()
{
	var tot_rec = document.forms[0].totalRec.value;
	for(var i=0;i<tot_rec;i++)
	{
		var del_rec_YN = eval('document.forms[0].del_rec_YN'+i).value;
		if(del_rec_YN == 'Y')
		{
			eval('document.forms[0].del_rec'+i).checked = true;
		}
		else
		{
			eval('document.forms[0].del_rec'+i).checked = false;
		}
	}
}

function validateInd1(obj,index)
{	

	if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
	{
		alert(getMessage("BL7495","BL"));
		return;
	}
	else{
		validateInd(obj,index)
	}
}
function chkAmtPer1(obj,index,noofdecimal)
{	
	var obj1=eval("document.forms[0].pkg_amt");
	
	//alert("auth_discount:"+document.forms[0].auth_discount.value);
	if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
	{
		alert(getMessage("BL7495","BL"));
			obj.value="";
	} else if((parseInt(eval("document.forms[0].adhocDiscount_"+index).value) == 0 
			|| eval("document.forms[0].adhocDiscount_"+index).value == "")
			&& eval("document.forms[0].reason_code"+index).value != ""){
		var msg = getMessage("BL6322","BL");
		alert(msg+"/"+"0.00");
		eval("document.forms[0].adhocDiscount_"+index).value = "";
		eval("document.forms[0].reason_code"+index).value = "";
		eval("document.forms[0].reason_desc"+index).value = "";
	}
	else if(eval("document.forms[0].adhocDiscount_"+index).value == "" && 
		eval("document.forms[0].reason_code"+index).value == ""){
		eval("document.forms[0].adhocDiscount_"+index).value = "";
	}
	else{
		chkAmtPer(obj,index,noofdecimal)
		putDecimal(obj1,13,noofdecimal);
		
		
		
	}
	
	
		
		var  temp=obj.value;
		var temp1=obj1.value;
		
	if(parseFloat(temp) > parseFloat(temp1))
		{
		
		alert('Discount Amount (' + obj.value + ') cannot be Greater than Package Amount ('+obj1.value+')');
		obj.value="";
		eval('document.forms[0].reason_desc'+index).value="";
		return false;
		}
	//Ends...

	
	
	
}

function del_rec_veri(obj,obj1,index)
{
//if(document.forms[0].auth_discount.value=="") //Commented By Muthukumar and added below condition against 31094(Issue -5) on 17/5/12
	if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
	{
		alert(getMessage("BL7495","BL"));
		obj.checked=false;
		eval('document.forms[0].del_rec_YN'+index).value = "N";
		return false;
	}
	else
	{
		if(obj.checked)
		{
			eval('document.forms[0].del_rec_YN'+index).value = "Y";
		}
		else
		{
			eval('document.forms[0].del_rec_YN'+index).value = "N";
		}
	}
}
</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="del_check();auth_check();" >
<%
	Connection con =null;
	try{
		String bean_id			= "bl_PkgAdhocDiscountBean" ;
		String bean_name		= "eBL.PkgAdhocDiscountBean";
		PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
		String locale				= (String)session.getAttribute("LOCALE");
		String facilityId			= (String) session.getValue( "facility_id" ) ;
		
		String function_id= request.getParameter("function_id");
		String patientId			= request.getParameter("patientId");
		patientId					= patientId==null ?"":patientId;
		String packageCode			= request.getParameter("packageCode");
		packageCode					= packageCode==null ?"":packageCode;
		String packageSeqNo			= request.getParameter("packageSeqNo");
		packageSeqNo				= packageSeqNo==null ?"":packageSeqNo;
		String packagelongDesc		= request.getParameter("packagelongDesc");
		packagelongDesc				= packagelongDesc==null ?"":packagelongDesc;
		function_id				= function_id==null ?"":function_id;
		
		String packageAmount=request.getParameter("packageAmount");
		if(packageAmount==null) packageAmount="";

		
		String episode_type=request.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		String episode_id=request.getParameter("episode_id");
		if(episode_id==null) episode_id="";
		String visit_id=request.getParameter("visit_id");
		if(visit_id==null) visit_id="";
		con		= ConnectionManager.getConnection();
		boolean sitespec_mms= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_BILL_DISCOUNT_ALLOWED");	//V210602
		System.err.println("sitespec_mms maintrt-"+sitespec_mms);
		
		String adhocDiscPrivYN		= request.getParameter("adhocDiscPrivYN");
		adhocDiscPrivYN				= adhocDiscPrivYN == null ? "N" : adhocDiscPrivYN;
		System.err.println("adhocDiscPrivYN: "+adhocDiscPrivYN);		
		
		String isAdhocDiscountMod		= request.getParameter("isAdhocDiscountMod");
		isAdhocDiscountMod				= isAdhocDiscountMod == null ? "N" : isAdhocDiscountMod;
		System.err.println("isAdhocDiscountMod: "+isAdhocDiscountMod);
		
		String delimAdhocDiscStr		= request.getParameter("delimAdhocDiscStr");
		delimAdhocDiscStr				= delimAdhocDiscStr == null ? "N" : delimAdhocDiscStr;
		System.err.println("delimAdhocDiscStr: "+delimAdhocDiscStr);	

		String[] arrOfStr = delimAdhocDiscStr.split("::");	
		System.err.println("arrOfStr0: "+arrOfStr[0]);	
		
		
		int totalRec = 0;
		String type					= "";
		String noofdecimal			= bean.getNoOfDecimal();
		ArrayList enconterDtls		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();
		String disbaleRow = "N";
		boolean disableExclAdhocDisc = false;
		disableExclAdhocDisc = bean.getSiteSpecDisableRow("DISABLE_EXCL_ADHOC_DISCOUNT");
		if(!(adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo)))	
		{	
			bean.setDBValues(facilityId, patientId, packageSeqNo, packageCode, locale);
			adhocDiscountDtls	= bean.getAdhocDiscountDtls();			
		}
		if(adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
		{
			enconterDtls = (ArrayList)adhocDiscountDtls.get(packageSeqNo);
			totalRec = 	enconterDtls.size();
		}
		
		%>

	<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
	<table class="grid"  width='100%' id="pkgDtlsForPatient">
	
	<%
	try
	{
		for(int i=0;i<totalRec;i++)
		{
			dtls = (ArrayList)enconterDtls.get(i);
			type =  checkForNull((String)dtls.get(5),"A");
			//Added by Rajesh V for MMS-DM-SCF-0461
			String custGrpCodeChk = (String) dtls.get(0);
			String custCodeChk = (String) dtls.get(2);
			if(disableExclAdhocDisc){
				try{
					if(custGrpCodeChk == null || "".equals(custGrpCodeChk)){
						disbaleRow = "N";
					}
					else{
						disbaleRow = bean.disableRowYN(facilityId, patientId, packageSeqNo, packageCode, custGrpCodeChk, custCodeChk);
					}
					System.err.println("disbaleRow"+disbaleRow);
				}
				catch(Exception e){
					disbaleRow = "N";
				}
			}
			else{
				disbaleRow = "N";
			}
			
			System.err.println("(String)dtls.get(6):"+(String)dtls.get(6));
			
			String lclAdhocDiscType = "", lclAdhocDisc = "", lclReasonDesc = "", lclReasonCode = "", lclDelRecYN = "N", lclToUpdate = "";
			
			
			if("Y".equals(isAdhocDiscountMod)){
				
				String modAdhocDisc = arrOfStr[i];
				System.err.println("modAdhocDisc:"+modAdhocDisc);
				String[] modAdhocDiscDtls = modAdhocDisc.split("~~");
				System.err.println("modAdhocDiscDtls:"+modAdhocDiscDtls);
				
				lclAdhocDiscType = modAdhocDiscDtls[5];
				lclAdhocDisc = modAdhocDiscDtls[6];
				lclReasonDesc = modAdhocDiscDtls[7];
				lclReasonCode = modAdhocDiscDtls[8];
				if("Y".equals(modAdhocDiscDtls[9]))
					lclDelRecYN = "Y";
				else
					lclDelRecYN = "N";
				lclToUpdate = modAdhocDiscDtls[10];
				type = lclAdhocDiscType;
				System.err.println("lclAdhocDiscType:"+lclAdhocDiscType+" lclAdhocDisc:"+lclAdhocDisc+" lclReasonDesc:"+lclReasonDesc+" lclReasonCode:"+lclReasonCode+" lclDelRecYN:"+lclDelRecYN);
			}
			
			if(i==0){					
			%>
			<script>					displayAdhocDiscountPatientHdr('<%=patientId%>','<%=packageCode%>','<%=packageSeqNo%>','<%=packagelongDesc%>');
				</script>
					 
				<tr>				
				<td class='columnheader' width = '5%'><fmt:message key="eBL.CUST_GROUP_CODE.label" bundle="${bl_labels}"/></td>	  
				<td class='columnheader' width = '20%'><fmt:message key="eBL.CUST_GROUP_DESC.label" bundle="${bl_labels}"/></td>
				<td class='columnheader' width = '5%'><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width = '20%'><fmt:message key="eBL.CUST_NAME.label" bundle="${bl_labels}"/></td>
				<td class='columnheader' width = '10%'><fmt:message key="eBL.DISCOUNT_AS_PER_SETUP.label" bundle="${bl_labels}"/></td>
				<td class='columnheader' width = '10%' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
				<td class='columnheader' width = '10%'><fmt:message key="eBL.ADHOC_DISC_AMT.label" bundle="${bl_labels}"/></td>				
				<td class='columnheader' width = '10%'><fmt:message key="eBL.ADHOC_DISC_REASON.label" bundle="${bl_labels}"/></td>				
				<td class='columnheader' width = '10%'><fmt:message key="Common.delete.label" bundle="${common_labels}"/></td>				
				</tr>
		<%}%>
			<tr>
			<td  nowrap><%=checkForNull((String)dtls.get(0))%></td>
			<td nowrap><%=checkForNull((String)dtls.get(1))%></td>
			<td  nowrap><%=checkForNull((String)dtls.get(2))%></td>
			<td  nowrap><%=checkForNull((String)dtls.get(3))%></td>
			<td nowrap><%=checkForNull((String)dtls.get(4))%></td>
			<td  nowrap>
			
			<select name='type_<%=i%>' id='type_<%=i%>' onChange='validateInd1(this,"<%=i%>")'>
			<option value='A' <%=(type.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
			<option value='R'  <%=(type.equals("R")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			<td nowrap><input type='text' name='adhocDiscount_<%=i%>' id='adhocDiscount_<%=i%>' id='adhocDiscount_<%=i%>'	value='<%="Y".equals(isAdhocDiscountMod) ? lclAdhocDisc : checkForNull((String)dtls.get(6))%>' size='13'  maxlength='13' onBlur="chkAmtPer1(this,'<%=i%>','<%=noofdecimal%>');"  onKeyPress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")' align='right' />
			<input type='hidden' name='disableForEmpty<%=i%>' id='disableForEmpty<%=i%>' id='disableForEmpty<%=i%>' value='<%=disbaleRow %>'>
			</td>

			<td nowrap><input type='text' name='reason_desc<%=i%>' id='reason_desc<%=i%>' id='reason_desc<%=i%>'	value='<%="Y".equals(isAdhocDiscountMod) ? lclReasonDesc : checkForNull((String)dtls.get(10))%>' size='13'  maxlength='13' onBlur="searchReason('B','<%=i%>')" /><input type='button' class='button' name="reasonbut<%=i%>" id="reasonbut<%=i%>" id="reasonbut<%=i%>" value='?' onClick="searchReason('C','<%=i%>')" tabindex='2'>
			<%if(!"Y".equals(disbaleRow)){ %>
			<img src='../../eCommon/images/mandatory.gif'></img>
			<%} %>
			<input type="hidden" name='reason_code<%=i%>' id='reason_code<%=i%>' value='<%="Y".equals(isAdhocDiscountMod) ? lclReasonCode : checkForNull((String)dtls.get(9))%>' ></td>

			<td nowrap><INPUT TYPE="checkbox" name="del_rec<%=i%>" id="del_rec<%=i%>" id='del_rec<%=i%>'  onClick="del_rec_veri(this,document.forms[0].del_rec_YN<%=i%>,<%=i%>);"</td>
				  
			<input type='hidden' name='cust_group_code<%=i%>' id='cust_group_code<%=i%>' value='<%=checkForNull((String)dtls.get(0))%>' />			
			<input type='hidden' name='cust_group_desc<%=i%>' id='cust_group_desc<%=i%>' value='<%=checkForNull((String)dtls.get(1))%>' />				
			<input type='hidden' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=checkForNull((String)dtls.get(2))%>' />				
			<input type='hidden' name='cust_desc<%=i%>' id='cust_desc<%=i%>' value='<%=checkForNull((String)dtls.get(3))%>' />				
			<input type='hidden' name='discountAsPerSetup_<%=i%>' id='discountAsPerSetup_<%=i%>' value='<%=checkForNull((String)dtls.get(4))%>' />
			<input type='hidden' name='to_update<%=i%>' id='to_update<%=i%>' value='<%="Y".equals(isAdhocDiscountMod) ? lclToUpdate : checkForNull((String)dtls.get(7))%>' />
			<input type='hidden' name='del_rec_YN<%=i%>' id='del_rec_YN<%=i%>' value='<%="Y".equals(isAdhocDiscountMod) ? lclDelRecYN : checkForNull((String)dtls.get(11))%>' />
<%	}
	%>
	<tr>
 		<td width = '5%'></td>	  
				<td width = '20%'></td>
				<td width = '5%'></td>
				<td  width = '20%'></td>
				<td  width = '10%'></td>
				<td  width = '10%'></td>
								
									
		
		<td class='label' width='10%' colspan='3' >
			
			<!--<input type='button' class='button' onclick='adhocDiscountAuthFromMPP()' name="auth_btn" id="auth_btn"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorization.label","common_labels")%>"> -->
			<input type="button" name="apply_button" id="apply_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>" class="button"  onClick="saveAdhocDiscInMPP();" align='right'>
			<input type="button" name="close_button" id="close_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class="button"  onClick="closeAdhocDiscount();" align='right'>
		</td>
	</tr>	
 </table>
	<%if(totalRec==0)
	{%>
	 <script>
		//parent.PkgAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";
		//alert(getMessage("BL8669",'BL')); 
		</script>
	 <%}
}
catch(Exception e)
{
	System.out.println("Exception from main trt Package AdhocDiscount Details  :"+e);
	e.printStackTrace();
}


%>
<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>' />
<input type='hidden' name='packageCode' id='packageCode' value='<%=packageCode%>' />
<input type='hidden' name='packageSeqNo' id='packageSeqNo' value='<%=packageSeqNo%>' />
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>' />
<input type='hidden' name='totalRec' id='totalRec' id='totalRec' value='<%=totalRec%>' />
<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
<input type='hidden' name='auth_discount' id='auth_discount' value='<%=adhocDiscPrivYN%>' />
<input type='hidden' name='pkg_amt' id='pkg_amt' id='pkg_amt' value='<%=packageAmount %>'/>
<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>' />
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>' />
<input type='hidden' name='sitespec_mms' id='sitespec_mms' id='sitespec_mms' value='<%=sitespec_mms %>'/>
<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>' />
<input type='hidden' name='delimAdhocDiscStr' id='delimAdhocDiscStr' value='<%=delimAdhocDiscStr%>' />
<input type='hidden' name='totAdhocDiscAmt' id='totAdhocDiscAmt' value='' />
<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' />

</form>
<%
}catch(Exception ex)
{
	System.out.println("Exception from maintrtAdhocDiscount Details  :"+ex);
	ex.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con);
}
%>
</body>
</html>

<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>


