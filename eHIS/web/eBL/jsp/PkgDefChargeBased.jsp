<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.PkgDefBean, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	//sarathkumar added code to make as siteSpecific saraa
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 
	System.out.println("siteSpecf" + ss);

%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 <script language="javascript" src='../js/PkgDef.js'></script> 
 <!-- <script language="javascript" src='../js/PkgDefTemp.js'></script> --> 

<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
/*function alignHeading_PkgCharge()
	{ 	
			if(parent.ChargeBasedDtlHdr.document.getElementById("tableheader")!=null)
			{		
					parent.ChargeBasedDtlHdr.document.getElementById("tableheader").width =	eval(parent.frames[1].document.getElementById("pkgCbased").offsetWidth);
						for (j=0; j < parent.frames[1].document.getElementById("pkgCbased").rows(1).cells.length; j++) 
						{			
							var  wid=eval(parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(j).offsetWidth);						
							if(parent.ChargeBasedDtlHdr.document.getElementById("tableheader").rows(0).cells(j) != null)
							{
						
								parent.ChargeBasedDtlHdr.document.getElementById("tableheader").rows(0).cells(j).width=wid;
								parent.ChargeBasedDtlHdr.document.getElementById("tableheader").rows(0).cells(0).width='300';							
								parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(0).width='300';
								parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(3).width='75';
								parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(6).width='66';
								parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(7).width='66';
								parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(8).width='80';
								parent.frames[1].document.getElementById("pkgCbased").rows(1).cells(9).width='66';
						
							}
						}
				}
			
		}*/
</script>

</head>

<% 
	try
	{
		System.out.println("this is from chargebased.jsp");
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
		String packageCode		=	"" ;
		String mode				= "";
		String srvLmt			= "N";
		String srvLmtChk        = "";
		String dtlsDisp	        = "NONE";
		String refndDisp		= "NONE";
		String factorAppl		="N";
		String roundTo	  = "";
		String roundInd  = "";
	//	String uSelect = "";
		//String dSelect = "";

		String charge_type		="";//MuthuN against 28192 
		String 		refund			="N";
		String		autoRefund		= "N";
		String 		refundAmt			="";
		//String flagVal = ""; 
		//String status = "", toDateStatus = "", fromDateImgStatus = "";
		String cbService = "";
		String cbServiceDesc = "";;
		String amountLimitInd = "";
		String disableFAppl = "";
	
		String amountLimit = "";
		String unld = "N";
		
		 String listSizeRateBased="";
		
		int  totRec=1;
		packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
		mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";

		String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
		String fromDateTemp = "";
		String		splitReqd = "Y";	//Split reqd
		String      includeHomeMedication = "N";  //sarathkumar InclHmeMedi
		String      enableDisParam = "N";  //sarathkumar InclHmeMedi
		//String custCode			 = request.getParameter("custCode")==null ? "" :request.getParameter("custCode") ;
	
		//String copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
		HashMap includedItems	    =	new HashMap();
		HashMap includedItems_FD    =	new HashMap();

		ArrayList charge_type_list	    =	new ArrayList();//MuthuN against 28192
		ArrayList services          =	new ArrayList();
		ArrayList serviceGroup	    =	new ArrayList();
		ArrayList serviceDescGroup  =	new ArrayList();
		ArrayList amtLmtIndGroup	=	new ArrayList();
		ArrayList amtLmtGroup		=	new ArrayList();
		//rayList unlimitedGroup	=	new ArrayList();
		ArrayList srvLmtsGroup	    =	new ArrayList();
		ArrayList factorApplGroup	=	new ArrayList();
		ArrayList roundToGroup      =	new ArrayList();
		ArrayList roundIndGroup     =	new ArrayList();
		ArrayList	refund_list    =	new ArrayList();
		ArrayList	refundAmt_list    =	new ArrayList();	
		ArrayList	auto_refund_list    =	new ArrayList();	
		ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
		ArrayList   includeHomeMedication_list= new ArrayList();//sarathkumar InclHmeMedi
		ArrayList   enableDisParam_list= new ArrayList();//sarathkumar InclHmeMedi
		ArrayList fromDateList = new ArrayList();
		ArrayList fromDateFoundList = new ArrayList();
		

		String bean_id		= "bl_PkgDefBean" ;
		String bean_name	= "eBL.PkgDefBean";
		PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		String beanChargeBasedId		= "bl_PkgDefChargeBasedBean" ;
		//Added By Vijay For MMS SCf 0357
		PkgDefBean rteBsdBean= (PkgDefBean)getBeanObject( beanChargeBasedId, bean_name, request ) ;
		
		int noofdecimal = Integer.parseInt(bean.getNoOfDecimal());
		//String modeChk			=request.getParameter("modeChk") == null ? "" :request.getParameter("modeChk") ;
		String deletedStatusCB = bean.getDeletedStatusCB();
		String deletedStatusCBLt = bean.getDeletedStatusCBLt() ;

		includedItems	= bean.getIncludedItems_CB();
		if(includedItems.containsKey(packageCode))
		includedItems_FD = (HashMap)includedItems.get(packageCode);
		
		/*if(mode.equals("insert") && !(includedItems.containsKey(packageCode)) && !copyFrm_pkgCode.equals(""))
		{
			bean.setDBValues("CHARGE_BASED",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);
			includedItems	= bean.getIncludedItems_CB();
		}	*/
		if(mode.equals("modify") && deletedStatusCB.equals("N") && !(includedItems.containsKey(packageCode))) {	
			bean.setDBValues("CHARGE_BASED",packageCode,locale,facilityId,"","",fromDate);//set database values to bean.
			includedItems	= bean.getIncludedItems_CB();
			 rteBsdBean.setDBValues("RATE_BASED",packageCode,locale,facilityId,cbService,"",fromDate);
			 listSizeRateBased=Integer.toString(rteBsdBean.getIncludedItems_RB().size());
			
			bean.setModifyChargeBased("Y");
		}
											
		if(mode.equals("modify") && deletedStatusCB.equals("N") &&	deletedStatusCBLt.equals("N") && includedItems.size()>0 && includedItems.containsKey(packageCode) )
			{	
				includedItems_FD = (HashMap)includedItems.get(packageCode);
				 rteBsdBean.setDBValues("RATE_BASED",packageCode,locale,facilityId,cbService,"",fromDate);
				 listSizeRateBased=Integer.toString(rteBsdBean.getIncludedItems_RB().size());
					
				if(includedItems_FD.size()>0 && includedItems_FD.containsKey(fromDate) )
				{
				services =(ArrayList)includedItems_FD.get(fromDate);
				
				if(services.size()>0)
				{
					serviceGroup		= (ArrayList)services.get(1);
					charge_type_list	= (ArrayList)services.get(0);//new

					for(int i=0; i<serviceGroup.size(); i++)
					{
						cbService 		= (String)serviceGroup.get(i);
						System.out.println("cbService ==> "+cbService);
						bean.setDBValues("CHARGE_BASED_ITEM",packageCode,locale,facilityId,cbService,"",fromDate);//set database values to bean.
					}
				}  
			}
		}
		fromDateTemp = fromDate;

		if(includedItems.size()>0 && includedItems.containsKey(packageCode) )
		{
			includedItems_FD = (HashMap)includedItems.get(packageCode);

			int i = 0;
			int j = 0;
			if(!includedItems_FD.containsKey(fromDate))
			{
				StringTokenizer st = new StringTokenizer(fromDateVals,"|");

				while(st.hasMoreElements())
				{	
					String strTempDate = st.nextToken();
					fromDateList.add(i,strTempDate);

					if(includedItems_FD.containsKey(strTempDate))
					{
						fromDateFoundList.add(strTempDate);
					}
					else
					{
						fromDateFoundList.add("");
					}
					if(fromDate.equals(strTempDate))
					{
						j=i;
					}
					i++;
				}
				
				int k=j;
				for(int l=0;l<j;l++)
				{
					k=k-1;
					if(!fromDateFoundList.get(k).equals(""))
					{
						fromDateTemp = (String)fromDateFoundList.get(k);
						break;
					}					
				}
			}
	
			if(includedItems_FD.size()>0 && includedItems_FD.containsKey(fromDateTemp) )
			{

			services =(ArrayList)includedItems_FD.get(fromDateTemp);
			if(services.size()>0)
			{
				charge_type_list	= (ArrayList)services.get(0);//MuthuN against 28192
				serviceGroup		= (ArrayList)services.get(1);
			    serviceDescGroup	= (ArrayList)services.get(2);
				amtLmtIndGroup		= (ArrayList)services.get(3);
				amtLmtGroup			= (ArrayList)services.get(4);
				//limitedGroup		= (ArrayList)services.get(4);
				srvLmtsGroup		= (ArrayList)services.get(5);
				factorApplGroup		= (ArrayList)services.get(6);
				roundToGroup		= (ArrayList)services.get(7);
				roundIndGroup		= (ArrayList)services.get(8);
				refund_list			= (ArrayList)services.get(9);
				refundAmt_list		= (ArrayList)services.get(10);
				auto_refund_list	= (ArrayList)services.get(11);
				split_reqd_list 	= (ArrayList)services.get(12);//Split Reqd
				includeHomeMedication_list=(ArrayList)services.get(13);//sarathkumar InclHmeMedi
				enableDisParam_list=(ArrayList)services.get(14);//sarathkumar InclHmeMedi
				/*serviceGroup		= (ArrayList)services.get(0);
			    serviceDescGroup	= (ArrayList)services.get(1);
				amtLmtIndGroup		= (ArrayList)services.get(2);
				amtLmtGroup			= (ArrayList)services.get(3);
				//limitedGroup		= (ArrayList)services.get(4);
				srvLmtsGroup		= (ArrayList)services.get(4);
				factorApplGroup		= (ArrayList)services.get(5);
				roundToGroup		= (ArrayList)services.get(6);
				roundIndGroup		= (ArrayList)services.get(7);
				refund_list			= (ArrayList)services.get(8);
				refundAmt_list		= (ArrayList)services.get(9);
				auto_refund_list	= (ArrayList)services.get(10);*/
				if(serviceGroup.size()>1)
					totRec =  serviceGroup.size();
			}
			}		
			}		
				
%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" onLoad='includeHomeMedicationEnable();'>
	<form name='frmPkgDefChargeBased' id='frmPkgDefChargeBased'>	
	<table class='grid' width='100%' id="pkgCbased" cellpadding=3 cellspacing=0 border=1 height="">
	<tr>
	   <td class='COLUMNHEADER'   nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>	
		<td  class='COLUMNHEADER'   nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/> / <fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
		<%if(ss){ %>
		 <!-- 	//sarathkumar InclHmeMedi  -->
		<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.includeHomeMedication.label" bundle="${bl_labels}"/></td>
		<%}else{ %>
		<td  class='COLUMNHEADER' WIDTH='' nowrap>
		
		<%} %>
		
		<td class='COLUMNHEADER' ><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap >Factor appl for serv_lmt</td>
		<td class='COLUMNHEADER' nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td> <!-- Added By Rajesh V -->
		<td class='COLUMNHEADER' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
	</tr>
  	<%
	String umlimitedStatus = "";
	for(int i=0; i<totRec; i++)
	{	
		if(serviceGroup.size()>0)
		{
			charge_type		= (String)charge_type_list.get(i);//MuthuN against 28192
			cbService 		= (String)serviceGroup.get(i);
			cbServiceDesc 	= (String)serviceDescGroup.get(i);
			amountLimitInd 	= (String)amtLmtIndGroup.get(i);
			amountLimit		= (String)amtLmtGroup.get(i);
			//ld 			= (String)unlimitedGroup.get(i);
			srvLmt          = (String)srvLmtsGroup.get(i);
			factorAppl		= (String)factorApplGroup.get(i);
			roundTo			= (String)roundToGroup.get(i);
			roundInd		= (String)roundIndGroup.get(i);
			refund			= (String) refund_list.get(i);
			refundAmt		= (String)refundAmt_list.get(i);
			autoRefund		= (String)auto_refund_list.get(i);
			splitReqd 		=(String) split_reqd_list.get(i);//Split reqd
			includeHomeMedication =(String) includeHomeMedication_list.get(i); //sara 
			enableDisParam =(String) enableDisParam_list.get(i); //sara 
		}
		if(unld.equals("Y"))
			umlimitedStatus = " checked ";
		else
			umlimitedStatus = "";
		if(srvLmt.equals("Y"))
		{
			srvLmtChk = " checked ";
			dtlsDisp = "inline ";
		}
		else
		{
			srvLmtChk = " ";
			dtlsDisp = "none ";
		}
		if(refund.equals("Y"))
			refndDisp  = "inline ";
		else
			refndDisp  = "none ";
		if(refund==null || refund.equals("") || refund.equals("null"))
			refund="N";
		if(amountLimitInd==null || amountLimitInd.equals("A"))
			disableFAppl = "";
		else
			disableFAppl="disabled";
			%>
			<tr>
<td class='fields' nowrap WIDTH='4%'> 
<select name='charge_type<%=i%>' id='charge_type<%=i%>' id='charge_type<%=i%>' onChange='onSrvLimitServiceTypeChange1(this,"<%=i%>")' <%=modifyStatus%>>
	<option value='S' <%=charge_type.equals("S")?"selected":""%> ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>	
	<option value='M' <%=charge_type.equals("M")?"selected":""%>><fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
</select>
</td>
<td  class='fields' nowrap><input type='text' name='cbCode_<%=i%>' id='cbCode_<%=i%>' <%=modifyStatus%> id='cbCode_<%=i%>' size='10' maxlength="10"  value="<%=cbService%>"   onBlur='callLookup(this,this,document.forms[0].cbDesc_<%=i%>,"CHARGE_BASED","<%=i%>"); IncludeHomeMedicationCheck(cbCode_<%=i%>,charge_type<%=i%>,"<%=i%>");'><input type='hidden' name='cbCodePrev_<%=i%>' id='cbCodePrev_<%=i%>' value="<%=cbService%>"/><input type='text'	 	 <%=modifyStatus%> name='cbDesc_<%=i%>' id='cbDesc_<%=i%>'size='30' maxlength="100"  value="<%=cbServiceDesc%>"   onBlur='callLookup(this,document.forms[0].cbCode_<%=i%>,this,"CHARGE_BASED","<%=i%>");IncludeHomeMedicationCheck(cbCode_<%=i%>,charge_type<%=i%>,'<%=i%>');'><input type='hidden' name='cbDescPrev_<%=i%>' id='cbDescPrev_<%=i%>' value="<%=cbServiceDesc%>"/><input type='button' class='button' name='serviceLookUp_<%=i%>' id='serviceLookUp_<%=i%>' value='?'	  <%=modifyStatus%> onClick="callServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,'CHARGE_BASED',charge_type<%=i%>,'<%=i%>'); IncludeHomeMedicationCheck(cbCode_<%=i%>,charge_type<%=i%>,'<%=i%>');" tabindex='0'></td>
<td  align="left" nowrap>
<select name='amt_limit_ind<%=i%>' id='amt_limit_ind<%=i%>'	<%=modifyStatus%> onChange='validateInd(this,"<%=i%>","perAmt_limit","factor_appl");changeSplitReqd(this,"amt_limit","<%=i%>");'>
<option value='A' <%=(amountLimitInd.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P'  <%=(amountLimitInd.equals("P")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
<option value='U'  <%=(amountLimitInd.equals("U")?"selected":"") %> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
</select>
</td>

<td><input type='text' name='perAmt_limit<%=i%>' id='perAmt_limit<%=i%>'	 <%=modifyStatus%> <%=((amountLimitInd.equals("U"))?"disabled":"") %> size='5' maxlength='13'  onBlur='validForAmtPerUnltd(document.frmPkgDefChargeBased.amt_limit_ind<%=i%>,this,"<%=i%>","CHARGE_BASED","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value="<%=amountLimit%>"/></td>


<%if(charge_type.equalsIgnoreCase("S")){ System.out.println("inside S");%>
<td  class='fields'>
<input type='checkbox' name='srvLmt_<%=i%>' id='srvLmt_<%=i%>' value="<%=srvLmt%>"  <%=srvLmtChk%>  <%=modifyStatus%> onclick="showLmtDetails(this,'<%=i%>')"/>
<a  style ="display:<%=dtlsDisp%>"	 id='srvLmtDtls_<%=i%>' href='javascript:loadChargeBasedServiceLimit(document.forms[0].cbCode_<%=i%>.value,"<%=i%>")'><fmt:message key='eBL.Dtls.label' bundle='${bl_labels}'/> </a>
</td>
<%
} else{ System.out.println("inside else S");
%>
<td  class='fields'>
<input type='checkbox' name='srvLmt_<%=i%>' id='srvLmt_<%=i%>' value="<%=srvLmt%>"  <%=srvLmtChk%>  <%=modifyStatus%> onclick="showLmtDetails(this,'<%=i%>')" disabled />
<a  style ="display:<%=dtlsDisp%>"	 id='srvLmtDtls_<%=i%>' href='javascript:loadChargeBasedServiceLimit(document.forms[0].cbCode_<%=i%>.value,"<%=i%>")'><fmt:message key='eBL.Dtls.label' bundle='${bl_labels}'/> </a>
	</td>
<%
}%>

<td  class='fields' ><input type='text' name='roundTo_<%=i%>' id='roundTo_<%=i%>' size='3'   <%=modifyStatus%> value="<%=roundTo%>"  onkeypress=" return (allowValidNumber1(this,event));"  /></td>

<td   >
<select name='roundInd_<%=i%>' id='roundInd_<%=i%>'    onChange=""  <%=modifyStatus%>>
<option value='U' <%=roundInd.equals("U")?"selected":""%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=roundInd.equals("D")?"selected":""%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>


<%if(ss){ %>
<!-- saraa -->
<td class='fields' WIDTH='' nowrap ><input type='checkbox'  <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%>  <%="Y".equals(enableDisParam)?"":"disabled"%> onclick="checkInclHomeMedi(this);"> </td>
<input type='hidden'  <%=modifyStatus%> name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='<%=enableDisParam %>'> </td> 
<% } else{%>
	<td><input type='hidden'   name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y'  >
	<input type='hidden'   name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='Y'> </td>
<%} %>



<td align="left" nowrap><input type='checkbox'    name='refund_<%=i%>' id='refund_<%=i%>'	<%=modifyStatus%> <%=refund.equals("Y")?"checked":""%> onClick='chkRefundCB(this,"<%=i%>")' value="<%=refund%>"/><input type='text'  <%=modifyStatus%> name='refundAmt_<%=i%>' id='refundAmt_<%=i%>' style ="display:<%=refndDisp%>" value='<%=refundAmt%>' onBlur='return validPercentageForRefund(this,"autoRefund_<%=i%>")' onkeypress='return ChkNumberInput(this,event,"<%=noofdecimal%>")' size='2' maxlength='4'  ></td>

<td align="left" nowrap><input type='checkbox'    name='autoRefund_<%=i%>' id='autoRefund_<%=i%>'	  <%=modifyStatus%> <%=autoRefund.equals("Y")?"checked":""%> onClick='chkautoRefund(this,"refundAmt_<%=i%>")' value="<%=autoRefund%>"/></td>

<td align="left" nowrap><input type='checkbox'  name='factor_appl<%=i%>' id='factor_appl<%=i%>' 	<%=modifyStatus%> <%=factorAppl.equals("Y")?"checked":""%> onClick='factorAppl(this,"<%=i%>")' value="<%=factorAppl%>"  <%=disableFAppl%>/></td>
<td class='fields' nowrap ><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="U".equals(amountLimitInd)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);"></td>
<td  class='fields'  width="10%">
<input type='checkbox' name='delCode_<%=i%>' id='delCode_<%=i%>' value=''  <%=modifyStatus%> onclick="chkDeleteService(this,'<%=i%>')"/></td>
				</tr>
		<%} %>
 </table>

 		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
		<input type="hidden" name="from" id="from" value="<%=from%>">
		<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
		<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
		<input type='hidden' name='listSizeRateBased' id='listSizeRateBased' value='<%=listSizeRateBased%>'/>
		<input type="hidden" id="totalRecords" name="totalRecords" id="totalRecords" value="<%=totRec%>"> <!-- saraa -->
		<input type='hidden' name='siteSpecf' id='siteSpecf'  id='siteSpecf' value='<%=siteSpecf%>'> <!-- saraa -->


<script>//parent.updateCurrentForm("CHARGE_BASED","parent.frames[3].frames[0].document.frmPkgDefChargeBased","parent.frames[3].frames[2].document.frmPkgDefChargeBasedExcln","parent.PkgDefHeader.document.frmPkgDefHeader",<%=totRec%>); COMMENTED LINE AND ADDED NEW LINE BY RAM
parent.updateCurrentForm("CHARGE_BASED","parent.frames[3].frames[1].document.frmPkgDefChargeBased","parent.frames[3].frames[3].document.frmPkgDefChargeBasedExcln","parent.PkgDefHeader.document.frmPkgDefHeader",<%=totRec%>);
</script>
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from PkgDefChargeBased :"+e);
	e.printStackTrace();
}
%>

