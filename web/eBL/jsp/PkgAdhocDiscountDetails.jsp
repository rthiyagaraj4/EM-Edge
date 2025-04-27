<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*,eBL.PkgAdhocDiscountBean" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 <!-- Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------------
	  1            V210602            19427        	MMS-ME-SCF-0027-TF	           Mohana Priya K
  -->


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

//Added by Rajesh V for MMS-DM-SCF-0461
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
//Added by Rajesh V for MMS-DM-SCF-0461

function auth_check()
{
	var auth_discount = "";
	if(document.forms[0].auth_discount.value=="")
	{				
		auth_discount = parent.frames[0].document.forms[0].auth_discount.value;
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
//if(document.forms[0].auth_discount.value=="") //Commented By Muthukumar and added below condition against 31094(Issue -5) on 17/5/12
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
	
	//Added By Vijay For MMS-ICN-00025
	var obj1=eval("document.forms[0].pkg_amt");
	var sitespec_mms=document.forms[0].sitespec_mms.value;//V210602 
	//alert(sitespec_mms);
//if(document.forms[0].auth_discount.value=="") //Commented By Muthukumar and added below condition against 31094(Issue -5) on 17/5/12
//V210602 starts
	if(sitespec_mms=="true" || sitespec_mms==true){
		if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
		{
			alert(getMessage("BL7495","BL"));
				obj.value="";
		}
		else if((eval("document.forms[0].adhocDiscount_"+index).value == "")
				&& eval("document.forms[0].reason_code"+index).value != ""){
			
			var msg = getMessage("BL6322","BL");
			alert(msg);
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
		
	}else if(sitespec_mms!="true" || sitespec_mms!=true){
		if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
		{
			alert(getMessage("BL7495","BL"));
				obj.value="";
		}
		if((parseInt(eval("document.forms[0].adhocDiscount_"+index).value) == 0 
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
	}//V210602 Ends
	//Added below 2 else-if blocks by Rajesh V for ICN-008
/*	if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
	{
		alert(getMessage("BL7495","BL"));
			obj.value="";
	}
	else if((parseInt(eval("document.forms[0].adhocDiscount_"+index).value) == 0 
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
	*/
		//Added By Vijay For MMS-ICN-00025
		
		var  temp=obj.value;
		var temp1=obj1.value;
		
	if(parseFloat(temp) > parseFloat(temp1))
		{
		
		alert('Discount Amount cannot be Greater than Package Amount'+obj.value+"/ "+obj1.value);
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
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="auth_check();del_check()" >
<%
		String bean_id			= "bl_PkgAdhocDiscountBean" ;
		String bean_name		= "eBL.PkgAdhocDiscountBean";
		PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
		String locale				= (String)session.getAttribute("LOCALE");
		String facilityId			= (String) session.getValue( "facility_id" ) ;
		Connection con		= ConnectionManager.getConnection();	//V210602
		String patientId			= request.getParameter("patientId");
		patientId					= patientId==null ?"":patientId;
		String packageCode			= request.getParameter("packageCode");
		packageCode					= packageCode==null ?"":packageCode;
		String packageSeqNo			= request.getParameter("packageSeqNo");
		packageSeqNo				= packageSeqNo==null ?"":packageSeqNo;
		String packagelongDesc		= request.getParameter("packagelongDesc");
		packagelongDesc				= packagelongDesc==null ?"":packagelongDesc;
		boolean sitespec_mms= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_BILL_DISCOUNT_ALLOWED");	//V210602
		System.err.println("sitespec_mms-"+sitespec_mms);
		//ADded By Vijay For MMS-ICN-00025
		String packageAmount=request.getParameter("packageAmount");
		if(packageAmount==null) packageAmount="";
		//Added V171219-Gayathri/65499/Starts
		
		String episode_type=request.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		String episode_id=request.getParameter("episode_id");
		if(episode_id==null) episode_id="";
		String visit_id=request.getParameter("visit_id");
		if(visit_id==null) visit_id="";
		
		//Added V171219-Gayathri/65499/Ends
		
		int totalRec = 0;
		String type					= "";
		String noofdecimal			= bean.getNoOfDecimal();
		ArrayList enconterDtls		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();
		//Added by Rajesh V for MMS-DM-SCF-0461
		String disbaleRow = "N";
		boolean disableExclAdhocDisc = false;
		disableExclAdhocDisc = bean.getSiteSpecDisableRow("DISABLE_EXCL_ADHOC_DISCOUNT");
		System.err.println("disableExclAdhocDisc"+disableExclAdhocDisc);
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
		System.err.println("totalRec:"+totalRec);
		
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
			//Added by Rajesh V for MMS-DM-SCF-0461
			if(i==0){					
			%>
			<script>					displayAdhocDiscountPatientHdr('<%=patientId%>','<%=packageCode%>','<%=packageSeqNo%>','<%=packagelongDesc%>');
				</script>
					 
				<tr>				
				<td class='columnheader'><fmt:message key="eBL.CUST_GROUP_CODE.label" bundle="${bl_labels}"/></td>	  
				<td class='columnheader'><fmt:message key="eBL.CUST_GROUP_DESC.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.CUST_NAME.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.DISCOUNT_AS_PER_SETUP.label" bundle="${bl_labels}"/></td>
				<td class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.ADHOC_DISC_AMT.label" bundle="${bl_labels}"/></td>				
				<td class='columnheader'><fmt:message key="eBL.ADHOC_DISC_REASON.label" bundle="${bl_labels}"/></td>				
				<td class='columnheader'><fmt:message key="Common.delete.label" bundle="${common_labels}"/></td>				
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
			<td nowrap><input type='text' name='adhocDiscount_<%=i%>' id='adhocDiscount_<%=i%>' id='adhocDiscount_<%=i%>'	value='<%=checkForNull((String)dtls.get(6))%>' size='13'  maxlength='13' onBlur="chkAmtPer1(this,'<%=i%>','<%=noofdecimal%>');"  onKeyPress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")' />
			<input type='hidden' name='disableForEmpty<%=i%>' id='disableForEmpty<%=i%>' id='disableForEmpty<%=i%>' value='<%=disbaleRow %>'>
			</td>

			<td nowrap><input type='text' name='reason_desc<%=i%>' id='reason_desc<%=i%>' id='reason_desc<%=i%>'	value='<%=checkForNull((String)dtls.get(10))%>' size='13'  maxlength='13' onBlur="searchReason('B','<%=i%>')" /><input type='button' class='button' name="reasonbut<%=i%>" id="reasonbut<%=i%>" id="reasonbut<%=i%>" value='?' onClick="searchReason('C','<%=i%>')" tabindex='2'>
			<%if(!"Y".equals(disbaleRow)){ %>
			<img src='../../eCommon/images/mandatory.gif'></img>
			<%} %>
			<input type="hidden" name='reason_code<%=i%>' id='reason_code<%=i%>' value='<%=checkForNull((String)dtls.get(9))%>' ></td>

			<td nowrap><INPUT TYPE="checkbox" name="del_rec<%=i%>" id="del_rec<%=i%>" id='del_rec<%=i%>'  onClick="del_rec_veri(this,document.forms[0].del_rec_YN<%=i%>,<%=i%>);"></td>
				  
			<input type='hidden' name='cust_group_code<%=i%>' id='cust_group_code<%=i%>' value='<%=checkForNull((String)dtls.get(0))%>' />			
			<input type='hidden' name='cust_group_desc<%=i%>' id='cust_group_desc<%=i%>' value='<%=checkForNull((String)dtls.get(1))%>' />				
			<input type='hidden' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=checkForNull((String)dtls.get(2))%>' />				
			<input type='hidden' name='cust_desc<%=i%>' id='cust_desc<%=i%>' value='<%=checkForNull((String)dtls.get(3))%>' />				
			<input type='hidden' name='discountAsPerSetup_<%=i%>' id='discountAsPerSetup_<%=i%>' value='<%=checkForNull((String)dtls.get(4))%>' />
			<input type='hidden' name='to_update<%=i%>' id='to_update<%=i%>' value='<%=checkForNull((String)dtls.get(7))%>' />
			<input type='hidden' name='del_rec_YN<%=i%>' id='del_rec_YN<%=i%>' value='<%=checkForNull((String)dtls.get(11))%>' />
<%	}
	%>
 </table>
	<%if(totalRec==0)
	{%>
	 <script>
		parent.PkgAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";
		alert(getMessage("BL8669",'BL')); </script>
	 <%}
}
catch(Exception e)
{
	System.out.println("Exception from Package AdhocDiscount Details  :"+e);
	e.printStackTrace();
}
%>
<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>' />
<input type='hidden' name='packageCode' id='packageCode' value='<%=packageCode%>' />
<input type='hidden' name='packageSeqNo' id='packageSeqNo' value='<%=packageSeqNo%>' />
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>' />
<input type='hidden' name='totalRec' id='totalRec' id='totalRec' value='<%=totalRec%>' />
<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
<input type='hidden' name='auth_discount' id='auth_discount' value='' />
<!-- Added By Vijay For MMS-ICN-00025 -->
<input type='hidden' name='pkg_amt' id='pkg_amt' id='pkg_amt' value='<%=packageAmount %>'/>
<!-- Added V171219-Gayathri/65499/Starts -->
<input type='hidden' name='sitespec_mms' id='sitespec_mms' id='sitespec_mms' value='<%=sitespec_mms %>'/> <!-- V210602 -->
<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>' />
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>' />
<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>' />

<!-- Added V171219-Gayathri/65499/Ends -->

</form>
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


