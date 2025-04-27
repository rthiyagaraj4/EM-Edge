<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.*,eBL.Common.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<title><fmt:message key="eBL.PkgAssociateFrame.jsp.label" bundle="${bl_labels}"/></title>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>		
<script language="javascript" src='../../eBL/js/PkgAssociate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>


<script>
$(document).ready(function()
{		

var siteSpec=$('#siteSpec').val();
var total_records = $('#total_records').val();

if(siteSpec=='true')
	{
	/* alert('total_records '+$('#total_records').val()); */
	$('[id^=from_date]').attr('disabled','disabled');
			$('[id^=fromDateimg_]').attr('disabled', 'disabled');
	for(i=0;i<=total_records;i++)
	{
	if($('#associated'+i).is(":checked")==true)
		{
		$('#from_date'+i).removeAttr('disabled','disabled');
		$('#fromDateimg_'+i).removeAttr('disabled','disabled');	
		}
	}
	}
 });


</script>



<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
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

<% 

try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		int noofdecimal=2;

		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;	
		String patientId = request.getParameter("patientId") == null ? "" :request.getParameter("patientId") ;
		String encounter_date = request.getParameter("encounter_date") == null ? "" :request.getParameter("encounter_date") ;
		String encounter_date_time = request.getParameter("encounter_date_time") == null ? "" :request.getParameter("encounter_date_time") ;
		String encounter_date_aft_trunc = request.getParameter("encounter_date_aft_trunc") == null ? "" :request.getParameter("encounter_date_aft_trunc") ;
		String calling_module_id = request.getParameter("calling_module_id") == null ? "" :request.getParameter("calling_module_id") ;
		String firstVisitDateTime=request.getParameter("firstVisitDateTime")==null ?"":request.getParameter("firstVisitDateTime");
		//System.out.println("firstVisitDateTime "+firstVisitDateTime);
		
		if(calling_module_id.equals(""))
			calling_module_id="BL";
	
		String sysDate="";

		String bean_id		= "PkgAssociateBean" ;
		String bean_name	= "eBL.PkgAssociateBean";
		PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;
		Boolean siteSpec=false;
		Connection con=null;
		try
		{
			con = ConnectionManager.getConnection();	
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_PKG_DATE_FIELDS_DUR_SUBS");
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}

%>
	

	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();" >
	<form name='PkgAssociateDtl' id='PkgAssociateDtl' action="" method="post" target="messageFrame" >	
	<table class='grid' width='100%' id="PkgSubsAssociate_tbl">
	<tr >
		<td  class='COLUMNHEADER' ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.PKG_DESC.label" bundle="${bl_labels}"/></td>
	
	<%
	if(siteSpec)
	{
	%>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.FromDate.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ToDate.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></td>

	<%
	}else{
	%>	
		<td  class='COLUMNHEADER' ><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></td>
	<%}	 %>
	</tr>
<%

		ArrayList  subscribedOpenPkgs=bean.subscribedOpenPkgs(facilityId,locale,patientId,encounter_date_aft_trunc);
		ArrayList  associatedPkgs=bean.getAssociatedPkgs();
		if(subscribedOpenPkgs.size() >0){
			String pkg_seq_no="";		
			String pkg_code="";		
			String pkg_desc="";		
			String associated="";		
			String pkgEffFromDate="";
			String pkgEffToDate="";
			String recordedValues="";	
			StringTokenizer pkgSt=null;
			String pkgCode="";
			String pkgDesc="";
			String pkgSeqNo="";
			String pkgFromDate="";
			String pkgAmt=""; //Added By Vijay For MMS-ICN-00025
			/*System.out.println("associatedPkgs "+associatedPkgs);
			System.out.println("size "+associatedPkgs.size());
			System.out.println("subscribedOpenPkgs.size() "+subscribedOpenPkgs.size());*/
			
			for(int i=0; i<subscribedOpenPkgs.size(); i++)
			{	
				String[] record = (String[])subscribedOpenPkgs.get(i);
				pkg_seq_no	=record[0];
				pkg_code	=record[1];
				pkg_desc	=record[2];
				pkgEffFromDate=record[3];
				pkgEffToDate=record[4];
				pkgAmt		=record[5];
			
				System.out.println("pkgamt "+pkgAmt);
				//System.out.println("pkgfrom date "+pkgEffFromDate);
				//System.out.println("pkgto date "+pkgEffToDate);
				
				associated="N";
				
		if(associatedPkgs.size()==0)
		{%>
			
			
			<tr>
				
			<td class='label'><a href='#' name='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=i%>');" ><%=pkg_seq_no%></a><input type="hidden" name="pkg_seq_no<%=i%>" id="pkg_seq_no<%=i%>" value="<%=pkg_seq_no%>"></td>
			<td class='label'><%=pkg_code%><input type="hidden" name="pkg_code<%=i%>" id="pkg_code<%=i%>" id="pkg_code<%=i%>" value="<%=pkg_code%>"></td>
			<td class='label'><%=pkg_desc%><input type="hidden" name="pkg_desc<%=i%>" id="pkg_desc<%=i%>" value="<%=pkg_desc%>"></td>
			<%
			if(siteSpec)
			{ %>
			<td class='fields'><input type="text" name="from_date<%=i %>" id="from_date<%=i %>" id="from_date<%=i %>" value="<%=pkgEffFromDate %>" onBlur="dateCheck('<%=i%>')"><img id = 'fromDateimg_<%=i%>' name="fromDateimg_<%=i%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date<%=i%>','dd/mm/yyyy hh:mm:ss');" STYLE="display:inline;"></td>
			<input type='hidden' name="fromdatehdn<%=i %>" id="fromdatehdn<%=i %>" id="fromdatehdn<%=i %>" value="<%=pkgEffFromDate %>">
			<input type='hidden' name="eff_from_date_hdn<%=i %>" id="eff_from_date_hdn<%=i %>" id="eff_from_date_hdn<%=i %>" value="<%=pkgEffFromDate %>">
			<td class='fields'><span class=="text" name="to_date<%=i %>" id="to_date<%=i %>"><%=pkgEffToDate %></span></td>		
			<input type='hidden' name="toDateHdn<%=i %>" id="toDateHdn<%=i %>" id="toDateHdn<%=i %>" value="<%=pkgEffToDate %>">
			<td  class='fields' ><input type="checkbox" name="associated<%=i%>" id="associated<%=i%>"  id="associated<%=i%>"   <%=associated.equals("Y")?"checked":""%>  value="<%=associated%>" onClick="chkAssociate(this,'<%=i%>'); toDateDisp(this,'<%=i%>')";></td>				
			<%} 
			else
			{%>	
			<td  class='fields' ><input type="checkbox" name="associated<%=i%>" id="associated<%=i%>" id="associated<%=i%>"  <%=associated.equals("Y")?"checked":""%>  value="<%=associated%>" onClick="chkAssociate(this,'<%=i%>');"></td>
			<%
			}
			%>	
			
			</tr>
			
			
			
		<% }
		else
		{
			
			
				for(int j=0;j<associatedPkgs.size();j++)
				{
					recordedValues=(String)associatedPkgs.get(j);
					/* System.out.println("vals "+vals);
					System.out.println("pkgSeqNo list"+pkgSeqNo);
					System.out.println("pkg_seq_no query"+pkg_seq_no);
					 */
					 pkgSt=new StringTokenizer(recordedValues,"~~");
					if(pkgSt.hasMoreTokens())
					{
						pkgCode=(String)pkgSt.nextToken();
					}
					else
					{
						pkgCode="";
					}
					if(pkgSt.hasMoreTokens())
					{
						pkgDesc=(String)pkgSt.nextToken();
					}
					else
					{
						pkgDesc="";
					}
					if(pkgSt.hasMoreTokens())
					{
						pkgSeqNo=(String)pkgSt.nextToken();
						/* System.out.println("pkgSeqNo "+pkgSeqNo);
						System.out.println("pkg_seq_no "+pkg_seq_no); */
						if(pkgSeqNo.equals(pkg_seq_no))
						{
							associated="Y";
						}
					}
					else
					{
					
						pkgSeqNo="";
					}
					if(pkgSt.hasMoreTokens())
					{
						pkgFromDate=(String)pkgSt.nextToken();
						//System.out.println("pkgFromDate "+pkgFromDate);
					}
					else
					{
						pkgFromDate="";
					}
			 		
				
					if(pkg_seq_no.equals(pkgSeqNo) &&associated.equals("Y"))
					{				
				%>
		<tr >
			<td class='label'><a href='#' name='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=i%>');" ><%=pkg_seq_no%></a><input type="hidden" name="pkg_seq_no<%=i%>" id="pkg_seq_no<%=i%>" value="<%=pkg_seq_no%>"></td>
			<td class='label'><%=pkg_code%><input type="hidden" name="pkg_code<%=i%>" id="pkg_code<%=i%>" id="pkg_code<%=i%>" value="<%=pkg_code%>"></td>
			<td class='label'><%=pkg_desc%><input type="hidden" name="pkg_desc<%=i%>" id="pkg_desc<%=i%>" value="<%=pkg_desc%>"></td>
			<%
			if(siteSpec)
			{ %>
			<td class='fields'><input type="text" name="from_date<%=i %>" id="from_date<%=i %>" id="from_date<%=i %>" value="<%=pkgFromDate %>" onBlur="dateCheck('<%=i%>')"><img id = 'fromDateimg_<%=i%>' name="fromDateimg_<%=i%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date<%=i%>','dd/mm/yyyy hh:mm:ss');" STYLE="display:inline;"></td>
			<input type='hidden' name="fromdatehdn<%=i %>" id="fromdatehdn<%=i %>" id="fromdatehdn<%=i %>" value="<%=pkgEffFromDate %>">
			<input type='hidden' name="eff_from_date_hdn<%=i %>" id="eff_from_date_hdn<%=i %>" id="eff_from_date_hdn<%=i %>" value="<%=pkgEffFromDate %>">
			<td class='fields'><span class=="text" name="to_date<%=i %>" id="to_date<%=i %>"><%=pkgEffToDate %></span></td>		
			<input type='hidden' name="toDateHdn<%=i %>" id="toDateHdn<%=i %>" id="toDateHdn<%=i %>" value="<%=pkgEffToDate %>">
			<td  class='fields' ><input type="checkbox" name="associated<%=i%>" id="associated<%=i%>"  id="associated<%=i%>"   <%=associated.equals("Y")?"checked":""%>  value="<%=associated%>" onClick="chkAssociate(this,'<%=i%>'); toDateDisp(this,'<%=i%>')";></td>				
			<%} 
			else
			{%>	
			<td  class='fields' ><input type="checkbox" name="associated<%=i%>" id="associated<%=i%>" id="associated<%=i%>"  <%=associated.equals("Y")?"checked":""%>  value="<%=associated%>" onClick="chkAssociate(this,'<%=i%>');"></td>
			<%
			}
			%>	
			
			</tr>
				
 <%} 
					
		}
			if(associated.equals("N")){ %>
				
				<tr>
				
			<td class='label'><a href='#' name='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=i%>');" ><%=pkg_seq_no%></a><input type="hidden" name="pkg_seq_no<%=i%>" id="pkg_seq_no<%=i%>" value="<%=pkg_seq_no%>"></td>
			<td class='label'><%=pkg_code%><input type="hidden" name="pkg_code<%=i%>" id="pkg_code<%=i%>" id="pkg_code<%=i%>" value="<%=pkg_code%>"></td>
			<td class='label'><%=pkg_desc%><input type="hidden" name="pkg_desc<%=i%>" id="pkg_desc<%=i%>" value="<%=pkg_desc%>"></td>
			<%
			if(siteSpec)
			{ %>
			<td class='fields'><input type="text" name="from_date<%=i %>" id="from_date<%=i %>" id="from_date<%=i %>" value="<%=pkgEffFromDate %>" onBlur="dateCheck('<%=i%>')"><img id = 'fromDateimg_<%=i%>' name="fromDateimg_<%=i%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date<%=i%>','dd/mm/yyyy hh:mm:ss');" STYLE="display:inline;"></td>
			<input type='hidden' name="fromdatehdn<%=i %>" id="fromdatehdn<%=i %>" id="fromdatehdn<%=i %>" value="<%=pkgEffFromDate %>">
			<input type='hidden' name="eff_from_date_hdn<%=i %>" id="eff_from_date_hdn<%=i %>" id="eff_from_date_hdn<%=i %>" value="<%=pkgEffFromDate %>">
			<td class='fields'><span class=="text" name="to_date<%=i %>" id="to_date<%=i %>"><%=pkgEffToDate %></span></td>		
			<input type='hidden' name="toDateHdn<%=i %>" id="toDateHdn<%=i %>" id="toDateHdn<%=i %>" value="<%=pkgEffToDate %>">
			<td  class='fields' ><input type="checkbox" name="associated<%=i%>" id="associated<%=i%>"  id="associated<%=i%>"   <%=associated.equals("Y")?"checked":""%>  value="<%=associated%>" onClick="chkAssociate(this,'<%=i%>'); toDateDisp(this,'<%=i%>')";></td>				
			<%} 
			else
			{%>	
			<td  class='fields' ><input type="checkbox" name="associated<%=i%>" id="associated<%=i%>" id="associated<%=i%>"  <%=associated.equals("Y")?"checked":""%>  value="<%=associated%>" onClick="chkAssociate(this,'<%=i%>');"></td>
			<%
			}
			%>
			
			</tr>
				
				
				
			<% }	//System.out.println("associated ouitside for "+associated);
				
				
				
			}%>
	<input type="hidden" name="pkgAmt<%=i%>" id="pkgAmt<%=i%>" value="<%=pkgAmt%>">
		
		<% 
			}
			} %>
		</table>		
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='total_records' id='total_records'  value="<%=subscribedOpenPkgs.size()%>" >
		<input type='hidden' name='patientId' id='patientId' value="<%=patientId%>" >
		<input type='hidden' name='sysDate' id='sysDate' value="<%=sysDate%>" >
		<input type='hidden' name='function_id'  id='function_id' value="<%=function_id%>" >
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='calling_module_id' id='calling_module_id' value="<%=calling_module_id%>" >
		<input type='hidden' name='encounter_date' id='encounter_date' value="<%=encounter_date%>" >
		<input type='hidden' name='encounter_date_time'  id='encounter_date_time' value="<%=encounter_date_time%>" >
		<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value="<%=encounter_date_aft_trunc%>" >
		<!-- 		Karthik added code for MMS-RY-SCF-0065 -->
		<input type='hidden' name='allPayerGroupCode' id='allPayerGroupCode' value="<%=request.getParameter("allPayerGroupCode")%>">
		<input type='hidden' name='allPayerCode' id='allPayerCode' value="<%=request.getParameter("allPayerCode")%>">
		<input type='hidden' name='firstVisitDateTime'  id='firstVisitDateTime' value='<%=firstVisitDateTime %>'>
		<input type='hidden' name='strMessageId' id='strMessageId' ' value=''>
		<input type='hidden' name='strErrorText' id='strErrorText' value=''>
		<input type='hidden' name='siteSpec' id='siteSpec'  value='<%=siteSpec %>'>
		
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from Package subscription  :"+e);
	e.printStackTrace();
}

%>

