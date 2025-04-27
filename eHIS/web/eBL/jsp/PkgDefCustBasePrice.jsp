<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
<script language="javascript" src='../js/PkgDefCust.js'></script> 
<script language="javascript" src='../../eBL/js/BLDefPkgReport.js'></script> <!-- Report CRF by MuthuN -->
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
<script>
function alignHeading_CustBasePrice()
{		
	if(parent.cust_base_price_dtl_hdr.document.getElementById("tableheader")!=null)
		{
				
			parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").width =	eval(parent.frames[1].document.getElementById("cust_base_price_tbl").offsetWidth);

  		for (j=0;j < parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells.length; j++) 
				{
			
		var wid=eval(parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(j).offsetWidth);
					if(parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(j) != null)
						{	
						
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(j).width=wid;
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(0).width='195';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(1).width='90';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(2).width='95';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(3).width='80';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(4).width='115';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(5).width='80';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(6).width='120';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(7).width='80';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(8).width='120';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(9).width='120';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(10).width='80';
						parent.cust_base_price_dtl_hdr.document.getElementById("tableheader").rows(1).cells(11).width='30';
	
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(0).width='190';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(1).width='90';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(2).width='84';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(3).width='77';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(4).width='113';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(5).width='78';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(6).width='115';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(7).width='80';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(8).width='115';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(9).width='115';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(10).width='80';
						parent.frames[1].document.getElementById("cust_base_price_tbl").rows(0).cells(11).width='30';
						}
					}
			}		
	}


</script>
<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
</head>

<% 
	try
	{
		
		String locale			 = (String)session.getAttribute("LOCALE");

		String packageCode		 =	"" ;
		String mode				 = "";
		String bean_id		     = "bl_PkgDefCustBean" ;
		String bean_name	     = "eBL.PkgDefCustBean";
		PkgDefCustBean bean		     = (PkgDefCustBean)getBeanObject( bean_id, bean_name, request ) ;
		String statusFac		 = " disabled";
		String blgClsCode        = "";
		String blgClsDesc        = "";
		String indicator         = "R";
		String factorAppl        = "";
		String roundTo			 = "";
		String roundInd			 = "";
		String price1			 = "";		
		String pSelect			 = "";
		String fSelect			 = "";	
		String deposit			= "";
		String partialDeposit	= "";
		String minDepAmtind		= "";
		String minDepAmt		= "";
		String factorforServiceRate = "";//Added by muthu for Factor for service rate issue for KDAH on 26-6-12
		packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		mode					 = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
		String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String cust_grp_code			 = request.getParameter("cust_grp_code")==null ? "" :request.getParameter("cust_grp_code") ;
		String cust_grp_desc			 = request.getParameter("cust_grp_desc")==null ? "" :request.getParameter("cust_grp_desc") ;
		String cust_code			 = request.getParameter("cust_code")==null ? "" :request.getParameter("cust_code") ;
		String cust_desc			 = request.getParameter("cust_desc")==null ? "" :request.getParameter("cust_desc") ;
		String parent_index			 = request.getParameter("parent_index")==null ? "" :request.getParameter("parent_index") ;
		int noofdecimal			 = 0;
		int  totRec				 = 1;
		String custRateBasedRcdSize=""; //Added By Vijay For MMS-SCF-0357
		String custChgBasedRcdSize="";
		
		bean.setModifyCustBasePrice("Y");	
		HashMap cust_base_price		= new HashMap();		
		ArrayList cust_price_list	     =	new ArrayList();

		CurrencyFormat cf        = new CurrencyFormat();
		cust_base_price	=  (HashMap)bean.getCustBasePrice();
		noofdecimal  =  Integer.parseInt(bean.getNoOfDecimal());		
			
		custRateBasedRcdSize=Integer.toString(bean.getCustRateSrv().size()); //Added By Vijay For MMS-SCF-0357
		custChgBasedRcdSize=Integer.toString(bean.getCustChargeSrv().size());
		if(cust_base_price!=null && cust_base_price.size()>0 && cust_base_price.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim())){
		cust_price_list=(ArrayList)cust_base_price.get(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim());
		}
		if(cust_price_list!=null && cust_price_list.size()>0 ){
				totRec=cust_price_list.size();		
		}
		//if(cust_base_price!=null && cust_base_price.size()>0 && cust_base_price.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()))
	
%>		
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();">
	<form name='cust_base_price_dtl' id='cust_base_price_dtl'>
	<table class = 'grid' width='100%' id="cust_base_price_tbl"  cellpadding='3' cellspacing='0' border="1" height="">
	
	<!--<table class='grid' width='100%' id="cust_base_price_tbl">
		<tr><td class='COLUMNHEADER'  colspan='10'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp; : &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;</td>
	</tr>
		<tr >
		<td  class='COLUMNHEADER' ><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="Common.Price.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.PARTIAL_DEPOSIT.label" bundle="${bl_labels}"/> </td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.MIN_DEPOSIT_AMOUNT.label" bundle="${bl_labels}"/></td>

		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
		</tr>
	-->
<%
String[] 	record;
	if(cust_price_list!=null && cust_price_list.size()>0){
		for(int i=0;i<cust_price_list.size();i++){
			record=new String[12];				
			record=(String[])cust_price_list.get(i);
			blgClsCode		= record[0];
			blgClsDesc		= record[1];
			indicator		=record[2];	  
			price1		=record[3];	

			if(!price1.equals(""))
				price1=cf.formatCurrency(price1, noofdecimal);
			roundTo	=	record[4];
			roundInd		=record[5];			
			factorAppl		=record[6];
			deposit =record[7];
			partialDeposit  =record[8];
			minDepAmtind =record[9];
			minDepAmt =record[10];
			factorforServiceRate = record[11];//Added by muthu for Factor for service rate issue for KDAH on 26-6-12
				if(indicator.equals("F"))
				{
					statusFac = " " ;
					pSelect	  = "";
					fSelect	  = " selected ";

				}
				else
				{
				   statusFac = " disabled" ;
   					pSelect	  = " selected ";
					fSelect	  = " ";

				}
			%>
			<tr >
			<%--  //sarath added MMS-QF-SCF-0545 added id's id='blgClsCode_<%=i%>' id='price_<%=i%>' --%>
			<td  class='fields' ><input type='text' name='blgClsCode_<%=i%>' id='blgClsCode_<%=i%>' id='blgClsCode_<%=i%>' size='3' maxlength="2"	  <%=modifyStatus%> onBlur="callCustBlgCls(document.forms[0].blgClsDesc_<%=i%>,this,'<%=i%>','code')" value="<%=blgClsCode%>" ><input type='text' name='blgClsDesc_<%=i%>' id='blgClsDesc_<%=i%>' size='15' maxlength="30"  value="<%=blgClsDesc%>"  <%=modifyStatus%> onBlur="callCustBlgCls(this,document.forms[0].blgClsCode_<%=i%>,'<%=i%>','desc')"  ><input type='button' class='button' name='blgCls_<%=i%>' id='blgCls_<%=i%>' value='?' onClick="callCustBlgCls(document.forms[0].blgClsDesc_<%=i%>,document.forms[0].blgClsCode_<%=i%>,'<%=i%>')" tabindex='0' <%=modifyStatus%> ><img src='../../eCommon/images/mandatory.gif'></td>

			<td  class='fields' ><select name='indicator_<%=i%>' id='indicator_<%=i%>'  <%=modifyStatus%>  onChange="custIndiValidation(this,'<%=i%>')">
			<option value='R' <%=pSelect%>><fmt:message key="Common.Price.label" bundle="${common_labels}"/></option>
			<option value='F' <%=fSelect%>><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels}"/></option>
			</select>
			</td>
				
			<td  class='fields' ><input type='text' name='price_<%=i%>' id='price_<%=i%>' id='price_<%=i%>' size='13' maxlength="13"  value="<%=price1%>"  <%=modifyStatus%> onkeypress=" return allowValidNumber(this,event,'10','<%=noofdecimal%>');" 
			onBlur='validateCustBaePrice(this,"<%=noofdecimal%>","BL8526","<%=i%>")'
			/></td>

			<td  class='fields' ><input type='text' name='roundTo_<%=i%>' id='roundTo_<%=i%>'	<%=indicator.equals("R")?"disabled":""%> <%=modifyStatus%>  size='2' maxlength="2"  value="<%=roundTo%>"  onkeypress=" return (allowValidNumber(this,event));"  /></td>			
			
			<td  class='fields' >		
			<select name='roundInd_<%=i%>' id='roundInd_<%=i%>'   <%=indicator.equals("R")?"disabled":""%>  onChange="" <%=modifyStatus%>>
			<option value='U' <%=roundInd.equals("U")?"selected":""%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
			<option value='D' <%=roundInd.equals("D")?"selected":""%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
			</select>
			</td>
			<td  class='fields' >
			<input type='checkbox' name='deposit_<%=i%>' id='deposit_<%=i%>'	<%=modifyStatus%> <%=(deposit.equals("Y")?" checked ":"")%> value="<%=deposit%>"   <%=modifyStatus%> onClick ="checkCustDeposit(this,'<%=i%>')" />
			</td>

			<td  class='fields' >
			<input type='checkbox' name='partialDeposit_<%=i%>' id='partialDeposit_<%=i%>'   <%=modifyStatus%> <%=(partialDeposit.equals("Y")?" checked ":"")%> value="<%=partialDeposit%>" <%=deposit.equals("Y")?"":" disabled "%>  onClick ="checkCustPartialDeposit(this,'<%=i%>')" />
		</td>

		<td  class='fields' >
		<select name='minDepAmtind_<%=i%>' id='minDepAmtind_<%=i%>'	<%=modifyStatus%> <%=partialDeposit.equals("Y")?"":" disabled "%> onChange='validateInd(this,"<%=i%>","minDepAmt_")'>
		<option value='' <%=(minDepAmtind.equals("")?"selected":"")%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<option value='A' <%=(minDepAmtind.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
		<option value='R'  <%=(minDepAmtind.equals("R")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
		</select>
		</td>
		<td  class='fields' >
		<input type='text' name='minDepAmt_<%=i%>' id='minDepAmt_<%=i%>' value="<%=minDepAmt%>"	<%=modifyStatus%> size='13' maxlength="13" <%=minDepAmtind.equals("")?" disabled ":""%> onKeyPress="return allowValidNumber(this,event,'10','<%=noofdecimal%>');" onBlur='custValidForAmtPerUnltd(document.forms[0].minDepAmtind_<%=i%>,this,"<%=i%>","CUST_PRICE","<%=noofdecimal%>")'  />
		</td>
			<td  class='fields'  >
			<input type='checkbox' name='factorAppl_<%=i%>' id='factorAppl_<%=i%>' value=''   onclick=""  <%=statusFac%>  <%=modifyStatus%>/>			
			</td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
			<td  class='fields' WIDTH='' nowrap>
			<input type='text' name='factorforServiceRate<%=i%>' id='factorforServiceRate<%=i%>' <%=modifyStatus%> maxlength='20' size='10' value="<%=factorforServiceRate%>">
			</td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
			<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
			<td><input type='button' class='button' name='callReportPkg<%=i%>' id='callReportPkg<%=i%>' value='R' onClick="callReportCustBase(this,'<%=i%>')" tabindex='0' <%=modifyStatus%> ></td><!--Added by muthu for Report issue for KDAH on 21-6-12 -->

			</tr>
		<%} 
		}else{%>
		<tr >
			<td  class='fields' ><input type='text' name='blgClsCode_0' id='blgClsCode_0' size='3' maxlength="2"	  <%=modifyStatus%> onBlur="callCustBlgCls(document.forms[0].blgClsDesc_0,this,'0','code')" value=""  ><input type='text' name='blgClsDesc_0' id='blgClsDesc_0' size='15' maxlength="30"  value=""	<%=modifyStatus%> onBlur="callCustBlgCls(this,document.forms[0].blgClsCode_0,'0','desc')"  ><input type='button' class='button' name='blgCls_0' id='blgCls_0' value='?' onClick="callCustBlgCls(document.forms[0].blgClsDesc_0,document.forms[0].blgClsCode_0,'0')" tabindex='0' <%=modifyStatus%> ><img src='../../eCommon/images/mandatory.gif'></td>

			<td  class='fields' >	
			<select name='indicator_0' id='indicator_0'  <%=modifyStatus%>  onChange="custIndiValidation(this,'0')" >			
			<option value='R' ><fmt:message key="Common.Price.label" bundle="${common_labels}"/></option>
			<option value='F' ><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels}"/></option>
			</select>
			</td>
				
			<td  class='fields' ><input type='text' name='price_0' id='price_0' size='13'  <%=modifyStatus%> maxlength="13"  value=""  onkeypress=" return allowValidNumber(this,event,'10','<%=noofdecimal%>');" onBlur='validateCustBaePrice(this,"<%=noofdecimal%>","BL8526","0")'  /></td>

			<td  class='fields' ><input type='text' name='roundTo_0' id='roundTo_0' size='2' <%=modifyStatus%>  disabled maxlength="2"  value=""  onkeypress=" return (allowValidNumber(this,event));"  /></td>
			
			<td  class='fields' >			
			<select name='roundInd_0' id='roundInd_0'   disabled  onChange="" <%=modifyStatus%>> 
			<option value='U' ><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
			<option value='D' ><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>			</select>
			</td>
			<td  class='fields' >
			<input type='checkbox' name='deposit_0' id='deposit_0' <%=(deposit.equals("Y")?" checked ":"")%> value="<%=deposit%>"  <%=modifyStatus%> <%=modifyStatus%> onClick ="checkCustDeposit(this,'0')" />
			</td>

			<td  class='fields' >
			<input type='checkbox' name='partialDeposit_0' id='partialDeposit_0'	 <%=modifyStatus%> <%=(partialDeposit.equals("Y")?" checked ":"")%> value="<%=partialDeposit%>" <%=deposit.equals("Y")?"":" disabled "%>  onClick ="checkCustPartialDeposit(this,'0')" />
		</td>

			<td  class='fields' >
			<select name='minDepAmtind_0' id='minDepAmtind_0'	<%=modifyStatus%>	<%=modifyStatus%> <%=partialDeposit.equals("Y")?"":" disabled "%> onChange='validateInd(this,"0","minDepAmt_")'>
			<option value='' <%=(minDepAmtind.equals("")?"selected":"")%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value='A' <%=(minDepAmtind.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
			<option value='R'  <%=(minDepAmtind.equals("R")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
			</select>
		</td>
			<td  class='fields' <%=modifyStatus%>>
			<input type='text' name='minDepAmt_0' id='minDepAmt_0' value="<%=minDepAmt%>" size='13' maxlength="13" <%=partialDeposit.equals("Y")?"":" disabled "%> onKeyPress="return allowValidNumber(this,event,'10','<%=noofdecimal%>');" onBlur='custValidForAmtPerUnltd(document.forms[0].minDepAmtind_0,this,"0","CUST_PRICE","<%=noofdecimal%>")'  />
		</td>
			<td  class='fields'  >
			<input type='checkbox' name='factorAppl_0' id='factorAppl_0' value=''   onclick="" <%=modifyStatus%>  />			
			</td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
			<td  class='fields' WIDTH='' nowrap>
			<input type='text' name='factorforServiceRate0' id='factorforServiceRate0' <%=modifyStatus%> maxlength='20' size='10' value="<%=factorforServiceRate%>">
			</td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
			<td><input type='button' class='button' name='callReport_0' id='callReport_0' value='R' onClick="" tabindex='0' <%=modifyStatus%> >
			</td><!--Added by muthu for Report issue for KDAH on 21-6-12 -->
			</tr>
		<%}%>
		</table>		
	
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" />
		<input type='hidden' name='totalRecords' id='totalRecords' value="<%=totRec%>" />
		<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" />
		<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
		<input type='hidden' name='cust_grp_code' id='cust_grp_code' value="<%=cust_grp_code%>" />
		<input type='hidden' name='cust_code' id='cust_code' value="<%=cust_code%>" />
		<input type='hidden' name='blgClsCode' id='blgClsCode' value="<%=blgClsCode%>" /><!--Added by muthu For Report  -->
		<input type='hidden' name='custRateBasedRcdSize' id='custRateBasedRcdSize' value='<%=custRateBasedRcdSize %>'/> <!--  Added by Vijay for MMS-SCF-DM-0357 -->
		<input type='hidden' name='custChgBasedRcdSize' id='custChgBasedRcdSize' value='<%=custChgBasedRcdSize %>'/>

		<script>	parent.updateCurrentForm("CUST_PRICE","parent.frames[4].frames[1].document.forms[0]","","parent.PkgDefCustHeader.document.frmPkgDefCustHeader",<%=totRec%>);

setTimeout('alignHeading_CustBasePrice()',100);
</script>

<script>alignHeading_CustBasePrice();</script>
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package Base Price :"+e);
	e.printStackTrace();
}
%>
<%!

%>

