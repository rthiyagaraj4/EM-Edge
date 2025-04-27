<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>

<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<!-- import the calendar script -->
	<SCRIPT language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<FORM name="formTDMAtrributesResult" id="formTDMAtrributesResult">
<%
		String	bean_id			=	"TDMAttributes" ;
		String	bean_name		=	"ePH.TDMAttributesBean";

				/* Variable Declarations start */
		String code									=	"";
		String desc									=	"";
		//String flag											=	"";
		String peakSamplingTime				        =	"";
		String peakSamplingTimeType		            =	"";
		String troughSamplingTime			        =	"";
		String troughSamplingTimeType	            =	"";
		String extendSamplingTime			        =	"";
		String extendSamplingTimeType	            =	"";
		String peakSelect1							=	"";
		String peakSelect2							=	"";
		String peakSelect3							=	"";
		String troughSelect1						=	"";
		String troughSelect2						=	"";
		String troughSelect3						=	"";
		String extendSelect1						=	"";
		String extendSelect2						=	"";
		String extendSelect3						=	"";
		String called_from					        =	"Result";
		String peakClassValue					    =	"";
		String troughClassValue					    =	"";
		String extendClassValue					    =	"";
		String randomClassValue				        =	"";
		String peakremark                           =   "";
		String troughremark                         =   "";
		String extendremark                         =   "";
		String randomremark                         =   "";

		int peakFlag								=	0;
		int troughFlag								=	0;
		int extendFlag								=	0;
		int randomFlag								=	0;
		int applyFlag								=	0;
		int peakLen									=	0;
		int troughLen								=	0;
		int extendLen								=	0;
		int randomLen								=	0;

		
		ArrayList selectedPeakOrder			=	new ArrayList();
		ArrayList selectedTroughOrder		=	new ArrayList();
		ArrayList selectedExtendOrder		=	new ArrayList();
		ArrayList selectedRandomOrder	    =	new ArrayList();
		HashMap SampleDetails				=	new HashMap();
		HashMap	peakDetails					=	new HashMap();
		HashMap	troughDetails				=	new HashMap();
		HashMap	extendDetails				=	new HashMap();
		HashMap record						=	new HashMap();
		HashMap	randomDetails					=	new HashMap();
					/* Variable Declartions end*/

		TDMAttributesBean bean				=  (TDMAttributesBean)getBeanObject( bean_id,bean_name, request);

		String peak					=	bean.getPeakRemarks();
		String Trough				=	bean.getTroughRemarks();
		String Extend				=	bean.getExtendRemarks();
		String random				=	bean.getRandomRemarks();
	 
					//Loads the List of Order Catalog corresponding to the sampletype
		selectedPeakOrder					=	bean.getSelectedOrderList("P",called_from);
		selectedTroughOrder					=	bean.getSelectedOrderList("T",called_from);
		selectedRandomOrder					=	bean.getSelectedOrderList("R",called_from);
		selectedExtendOrder					=	bean.getSelectedOrderList("E",called_from);

		
				//Loads the SamplingTime Details
		SampleDetails=bean.getSamplingDetails();



		if(SampleDetails.containsKey("P")){
			peakDetails=(HashMap)SampleDetails.get("P");
			peakSamplingTime=(String)peakDetails.get("samplingTime");
			peakremark=(String)peakDetails.get("tdmattrremarks");
			if(peakremark!=null && !peakremark.equals(""))
				bean.setPeakRemarks(peakremark);

			if(peakremark==null)
				peakremark="";
			if(peakSamplingTime==null)
				peakSamplingTime="";
			peakSamplingTimeType=(String)peakDetails.get("samplingTimeType");
			if(peakSamplingTimeType.equals("D"))
					peakSelect1="selected";
			else if(peakSamplingTimeType.equals("H"))
					peakSelect2="selected";
			else if(peakSamplingTimeType.equals("M"))
					peakSelect3="selected";
		}
		if(SampleDetails.containsKey("T")){

			troughDetails=(HashMap)SampleDetails.get("T");
			troughSamplingTime=(String)troughDetails.get("samplingTime");
			troughremark=(String)troughDetails.get("tdmattrremarks");
			if(troughremark!=null && !troughremark.equals(""))
				bean.setTroughRemarks(troughremark);

			if(troughSamplingTime==null)
				troughSamplingTime="";
			troughSamplingTimeType=(String)troughDetails.get("samplingTimeType");
			if(troughSamplingTimeType.equals("D"))
					troughSelect1="selected";
			else if(troughSamplingTimeType.equals("H"))
					troughSelect2="selected";
			else if(troughSamplingTimeType.equals("M"))
					troughSelect3="selected";
 		}
		if(SampleDetails.containsKey("E")){

			extendDetails=(HashMap)SampleDetails.get("E");
			extendSamplingTime=(String)extendDetails.get("samplingTime");
			extendremark=(String)extendDetails.get("tdmattrremarks");
			if(extendremark!=null && !extendremark.equals(""))
				bean.setExtendRemarks(extendremark);

			if(extendSamplingTime==null)
				extendSamplingTime="";
			extendSamplingTimeType=(String)extendDetails.get("samplingTimeType");
			if(extendSamplingTimeType.equals("D"))
					extendSelect1="selected";
			else if(extendSamplingTimeType.equals("H"))
					extendSelect2="selected";
			else if(extendSamplingTimeType.equals("M"))
					extendSelect3="selected";
		}

		 if(SampleDetails.containsKey("R")){

			randomDetails=(HashMap)SampleDetails.get("R");
			randomremark=(String)randomDetails.get("tdmattrremarks");
			if(randomremark!=null)
				bean.setRandomRemarks(randomremark);
			if(randomremark==null)
				randomremark="";
		}

		if(selectedPeakOrder != null){
			peakLen			=	selectedPeakOrder.size();
			if(peakLen!=0 && !peakSamplingTime.equals(""))
				peakFlag	=	1;
		}

		if(selectedTroughOrder != null ){
			troughLen		=	selectedTroughOrder.size();
			if(troughLen!=0 && !troughSamplingTime.equals(""))
				troughFlag	=	1;
		}
		if(selectedExtendOrder != null ){
			extendLen		=	selectedExtendOrder.size();
			if(extendLen!=0 && !extendSamplingTime.equals(""))
				extendFlag	=	1;
		}

		if(selectedRandomOrder != null){
			randomLen		=	selectedRandomOrder.size();
			if(randomLen !=0)
					randomFlag	=	 1;
		}

			//Atleast one of the sampletypes should be checked..
		if(peakFlag==1 || troughFlag==1 || extendFlag==1 || randomFlag==1)
			applyFlag=1;
		

%>
<TABLE border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
	<TR>
	<%
			if(peakFlag==0){
	%>
		<TD align="left" class="label" style="width:50%">
			<label id="orderLink1">-</label><B>&nbsp;<fmt:message key="ePH.Peak.label" bundle="${ph_labels}"/></B>
		</TD>
	<%
			}else{
	%>
		<TD align="left" class="label" style="width:50%">
			<label id="orderLink1" style="cursor:pointer" onClick="identityOperation(orderLink1,'P')">-</label><B>&nbsp;<fmt:message key="ePH.Peak.label" bundle="${ph_labels}"/></B>
		</TD>
	<%
			}
	%>
		<TD align="center" style="width:25%">&nbsp;&nbsp;
			<INPUT type="text" class="number" name="peakSampleTime" id="peakSampleTime" maxlength="2" size="1" value="<%=peakSamplingTime%>" onblur="CheckNum(this);store('P');">
			<SELECT name="peakSampleTimeType" id="peakSampleTimeType" onchange="store('P');">
						<OPTION <%=peakSelect1%> value="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
						<OPTION <%=peakSelect2%> value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
						<OPTION <%=peakSelect3%> value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
		</TD>
	<%
			if(peakFlag==0){
	%>
		<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
			<input type="checkBox"  name="peakChk" id="peakChk" onclick="provideLink(this)">
			<label id="plc_order1">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
			<label>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
	<%
			
			}
			else{
	%>
		<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
			<input type="checkBox"  checked name="peakChk" id="peakChk" onclick="provideLink(this)" >
			<label id="plc_order1" style="cursor:pointer;color:blue" onclick="showOrderWindow('P')">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
			<label>&nbsp;&nbsp;&nbsp;<a href="javascript:callremarks('P','<%=peak%>')" name="Premarks"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></label>
	<%
			
			}
	%>

		</TD>
	</TR>
		<!-- for loop , if the bean contains value for Peak-->
	<%
			if(peakLen >0)	{
				for (int i=0;i<peakLen;i++)	{
					record			=	(HashMap)selectedPeakOrder.get(i);
					code			=	(String)record.get("code");
					desc			=	(String)record.get("desc");
					//flag				=	(String)record.get("flag");
					if(i%2==0)
						peakClassValue	=	"QRYEVEN";
					else
						peakClassValue	=	"QRYODD";
					
	%>
	<TR   id="P_<%=i%>" >
		<TD class="<%=peakClassValue%>"  align="left" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=desc%>
		</TD>
			<INPUT type="hidden" name="Pcode_<%=i%>" id="Pcode_<%=i%>" value="<%=code%>">
			<INPUT type="hidden" name="Pdesc_<%=i%>" id="Pdesc_<%=i%>" value="<%=desc%>">
				<TD align="left" width="25%" class="<%=peakClassValue%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" checked name="PC_<%=i%>" id="PC_<%=i%>" onclick="selectLabOrder11(this,<%=i%>,0,'P')">
			</TD>
	</TR>
	<%
				}
			}
	%>
	<!--end-->
	<TR >
	<%	
			if(troughFlag==0){
%>
				<TD align="left" class="label">
					<label id="orderLink2">-</label><B>&nbsp;<fmt:message key="ePH.Trough.label" bundle="${ph_labels}"/></B>
				</TD>
<%
			}
			else{
%>
				<TD align="left" class="label">
					<label id="orderLink2" style="cursor:pointer" onClick="identityOperation(orderLink2,'T')" >-</label><B>&nbsp;<fmt:message key="ePH.Trough.label" bundle="${ph_labels}"/></B>
				</TD>
<%
			}
%>
			<TD align="center" >&nbsp;&nbsp;
				<INPUT type="text" class="number" name="troughSampleTime" id="troughSampleTime" maxlength="2" size="1" value="<%=troughSamplingTime%>" onblur="CheckNum(this);store('T');">
				<SELECT name="troughSampleTimeType" id="troughSampleTimeType" onchange="store('T');">
						<OPTION <%=troughSelect1%> value="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
						<OPTION <%=troughSelect2%> value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
						<OPTION <%=troughSelect3%> value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></OPTION>
				</SELECT>
			</TD>
<%
		if(troughFlag==0){
%>
			<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
				<INPUT type="checkBox"  name="troughChk" id="troughChk" onclick="provideLink(this)">
				<label id="plc_order2">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
				<label>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
<%
			}
			else{
%>
			<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
				<INPUT type="checkBox"  checked name="troughChk" id="troughChk"  onclick="provideLink(this)">
				<label id="plc_order2" style="cursor:pointer;color:blue" onclick="showOrderWindow('T')">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
				<label>&nbsp;&nbsp;&nbsp;<a href="javascript:callremarks('T','','<%=Trough%>')" name="Premarks"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></label>

<%
			}
%>
			</TR>
	<!-- for loop , if the bean contains value for Trough-->
<%
		if(troughLen >0){
			for (int i=0;i<troughLen;i++){
				record			=	(HashMap)selectedTroughOrder.get(i);
				code			=	(String)record.get("code");
				desc			=	(String)record.get("desc");
				//flag				=	(String)record.get("flag");
				if(i%2==0)
					troughClassValue	=	"QRYEVEN";
				else
					troughClassValue	=	"QRYODD";
%>
				<TR id="T_<%=i%>">
					<TD class="<%=troughClassValue%>" align="left" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=desc%></TD>
						<INPUT type="hidden" name="Tcode_<%=i%>" id="Tcode_<%=i%>" value="<%=code%>">
						<INPUT type="hidden" name="Tdesc_<%=i%>" id="Tdesc_<%=i%>" value="<%=desc%>">
					<TD align="left" width="25%" class="<%=troughClassValue%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<INPUT type="checkbox" checked name="TC_<%=i%>" id="TC_<%=i%>" onclick="selectLabOrder11(this,<%=i%>,0,'T')">
					</TD>
				</TR>
<%
				}

			}
%>
	<TR >
	<!--end-->
	<TR >
	<%	
			if(extendFlag==0){
	%>
		<TD align="left" class="label">
			<label id="orderLink3">-</label><B>&nbsp;<fmt:message key="ePH.ExtendedDose.label" bundle="${ph_labels}"/></B>
		</TD>
	<%
			}
		else{
	%>
		<TD align="left" class="label">
			<label id="orderLink3" style="cursor:pointer" onClick="identityOperation(orderLink3,'E')" >-</label><B>&nbsp;<fmt:message key="ePH.ExtendedDose.label" bundle="${ph_labels}"/></B>
		</TD>
	<%
			}
	%>
		<TD align="center" >&nbsp;&nbsp;
			<INPUT type="text" class="number" name="extendSampleTime" id="extendSampleTime" maxlength="2" size="1" value="<%=extendSamplingTime%>" onblur="CheckNum(this);store('E');">
			<SELECT name="extendSampleTimeType" id="extendSampleTimeType" onchange="store('E');">
					<OPTION <%=extendSelect1%> value="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
					<OPTION <%=extendSelect2%> value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
					<OPTION <%=extendSelect3%> value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
		</TD>
	<%
		if(extendFlag==0){
	%>
		<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
			<INPUT type="checkBox"  name="extendChk" id="extendChk" onclick="provideLink(this)">
			<label id="plc_order3">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
			<label>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
	<%
			}else{
	%>
		<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
			<INPUT type="checkBox"  checked name="extendChk" id="extendChk"  onclick="provideLink(this)">
			<label id="plc_order3" style="cursor:pointer;color:blue" onclick="showOrderWindow('E')">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
			<label>&nbsp;&nbsp;&nbsp;<a href="javascript:callremarks('E','','','<%=Extend%>')" name="Premarks"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></label>

	<%
			}
	%>
	</TR>
	<!-- for loop , if the bean contains value for Extended Dose-->
	<%
		if(extendLen >0){
			for (int i=0;i<extendLen;i++){
				record			=	(HashMap)selectedExtendOrder.get(i);
				code			=	(String)record.get("code");
				desc			=	(String)record.get("desc");
				//flag				=	(String)record.get("flag");
				if(i%2==0)
					  extendClassValue	=	"QRYEVEN";
				else
					  extendClassValue	=	"QRYODD";
	%>
	<TR id="E_<%=i%>" >
		<TD class="<%=extendClassValue%>" align="left" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=desc%></TD>
			<INPUT type="hidden" name="Ecode_<%=i%>" id="Ecode_<%=i%>" value="<%=code%>">
			<INPUT type="hidden" name="Edesc_<%=i%>" id="Edesc_<%=i%>" value="<%=desc%>">
		<TD align="left" width="25%" class="<%=extendClassValue%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT type="checkbox" checked name="EC_<%=i%>" id="EC_<%=i%>" onclick="selectLabOrder11(this,<%=i%>,0,'E')">
		</TD>
	</TR>
	<%
				}

			}
	%>
	<TR >
	<!--end-->

	<%
			if(randomFlag==0){
	%>
		<TD align ="left"class="label">
			<label id="orderLink4">-</label><B>&nbsp;<fmt:message key="ePH.Random.label" bundle="${ph_labels}"/></B>
		</TD>
	<%
			}else{
	%>
		<TD align ="left"class="label">
			<label id="orderLink4" style="cursor:pointer" onClick="identityOperation(orderLink4,'R')">-</label><B>&nbsp;<fmt:message key="ePH.Random.label" bundle="${ph_labels}"/></B>
		</TD>
	<%
			}
	%>
		<TD>&nbsp;&nbsp;</TD>
	<%
			if(randomFlag==0){
	%>
		<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
			<INPUT type="checkBox"  name="randomChk" id="randomChk" onclick="provideLink(this)">
			<label id="plc_order4">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
			<label>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
	<%
			}else{
	%>
		<TD align="center"  class="label" style="width:25%"> &nbsp;&nbsp;
			<INPUT type="checkBox"  checked name="randomChk" id="randomChk" onclick="provideLink(this)">
			<label id="plc_order4" style="cursor:pointer;color:blue" onclick="showOrderWindow('R')">&nbsp;<fmt:message key="Common.Associate.label" bundle="${common_labels}"/></label>
			<label>&nbsp;&nbsp;&nbsp;<a href="javascript:callremarks('R','','','','<%=random%>')" name="Premarks"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></label> 

	<!-- for loop , if the bean contains value for Random-->

	<%
			}
		if(randomLen >0)
		{
			for (int i=0;i<randomLen;i++)
			{
					record			=	(HashMap)selectedRandomOrder.get(i);
					code			=	(String)record.get("code");
					desc			=	(String)record.get("desc");
					//flag				=	(String)record.get("flag");
					if(i%2==0)
					  randomClassValue	=	"QRYEVEN";
				else
					  randomClassValue	=	"QRYODD";
					
	%>
	<TR id="R_<%=i%>" >
			<TD class="<%=randomClassValue%>" align="left" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=desc%>
			</TD>
				<INPUT type="hidden" name="Rcode_<%=i%>" id="Rcode_<%=i%>" value="<%=code%>">
				<INPUT type="hidden" name="Rdesc_<%=i%>" id="Rdesc_<%=i%>" value="<%=desc%>">
			<TD align="left" width="25%" class="<%=randomClassValue%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT type="checkbox" checked name="RC_<%=i%>" id="RC_<%=i%>" onclick="selectLabOrder11(this,<%=i%>,0,'R')">
			</TD>
	</TR>
	<%
			}

		}
	%>
<!--end-->
</TABLE>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="mode" id="mode" value="">
	<input type="hidden" name="applyFlag" id="applyFlag" value="<%=applyFlag%>">
	<input type="hidden" name="peakRowCount" id="peakRowCount" value="<%=peakLen%>">
	<input type="hidden" name="troughRowCount" id="troughRowCount" value="<%=troughLen%>">
	<input type="hidden" name="extendRowCount" id="extendRowCount" value="<%=extendLen%>">
	<input type="hidden" name="randomRowCount" id="randomRowCount" value="<%=randomLen%>">

	<input type="hidden" name="drugCode" id="drugCode"  value="">
	<input type="hidden" name="ageGrp" id="ageGrp" value="">
	<input type="hidden" name="minAge" id="minAge" value="">
	<input type="hidden" name="maxAge" id="maxAge" value="">
	<input type="hidden" name="gender" id="gender" value="">
	<input type="hidden" name="ageUnit" id="ageUnit" value="">
	<input type="hidden" name="steadyState" id="steadyState" value="">
	<input type="hidden" name="steadyStateType" id="steadyStateType" value="">
	<input type="hidden" name="peakFlag" id="peakFlag" value="">
	<input type="hidden" name="troughFlag" id="troughFlag" value="">
	<input type="hidden" name="extendFlag" id="extendFlag" value="">
	<input type="hidden" name="randomFlag" id="randomFlag" value="">
							  	
	<input type="hidden" name="peak" id="peak" value="<%=peak%>">
	<input type="hidden" name="Trough" id="Trough" value="<%=Trough%>">
	<input type="hidden" name="Extend" id="Extend" value="<%=Extend%>">
	<input type="hidden" name="random" id="random" value="<%=random%>">


</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

