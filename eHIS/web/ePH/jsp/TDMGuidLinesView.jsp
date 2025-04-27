<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
 <!-- Added UTF-8 for the incident num:24639 on 25/Oct/2010===By Sandhya -->
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
//Added Character encoding for getting data into thai regarding inicdent:24639 on 25/Oct/2010==By Sandhya
request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale			= (String)session.getAttribute("LOCALE");

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../ePH/js/TDMGuidLinesView.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<title><fmt:message key="ePH.TDMGuidelines.label" bundle="${ph_labels}"/> </title>
</HEAD>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="TDMGuideLinesForm" id="TDMGuideLinesForm">
<%
	
	String bean_id				 = "TDMGuidLinesView";
 	String bean_name			 = "ePH.TDMGuidLinesView";
	TDMGuidLinesView bean	 =	(TDMGuidLinesView)getBeanObject( bean_id,bean_name, request ) ;	
    String drug_code			 =  request.getParameter("drug_code");
	String pat_id				 = request.getParameter("patient_id");
    String drug_desc			 = bean.getDrugDesc(drug_code.trim(),locale);
    String identity				 = request.getParameter( "identity" );
	String Tdmtype			 = request.getParameter("type");
	String durtype				 = "";
	String classvalue			 = "";
	String style					 = "";
	String styleord				 = "";
	String styletdmord		 = "";
	int rowCount				 = 0;
	String tdmord_id           = "";
	ArrayList getPatDet       = new ArrayList();
    ArrayList getTdmDet      = new ArrayList();
	ArrayList getSamplingData = bean.getSamplingData(drug_code,pat_id,locale);
	
    if(getSamplingData.size()!=0) {
		durtype           = (String)getSamplingData.get(0);
	}else{
	%>
		<script language="Javascript">
					chkTdmAttributes();
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 <%
	}
		
	if(identity.equals("callWindow"))
	{
		
		String ord_id = request.getParameter("order_id");
		  if((ord_id.equals("")) && (Tdmtype.equals("R"))){
			   style="visibility:hidden";
			     
		   }else{
			   style="visibility:visible";
			   
		}

    }	

%>

<table align="center"  border="0" width="100%" cellspacing="0"   cellpadding="0">
<tr width="100%"> 
        <td colspan=4 align="left" class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
		&nbsp;&nbsp&nbsp;&nbsp;&nbsp;<b><%=drug_desc%></b>
		</tr>
		<tr >
        <td colspan=4>&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<td colspan=4 class="label"><fmt:message key="ePH.SteadyState.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<b><%=durtype%></b>
</tr> 
</table>
<br>
<table  border="1" cellpadding="0" cellspacing="0" width="100%" style="overflow: scroll" align="center">
<th colspan=5 align="center" width="100%"><fmt:message key="ePH.SamplingGuideLines.label" bundle="${ph_labels}"/>
</th>
<TR>
		<TD width ="10%"  CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;' ALIGN="left"  HEIGHT="20"><fmt:message key="ePH.SamplingTypes.label" bundle="${ph_labels}"/></TD>
		<TD width ="10%"  CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'ALIGN="left"  HEIGHT="20"><fmt:message key="ePH.SamplingTime.label" bundle="${ph_labels}"/></TD>
		<TD width ="15%" CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;' ALIGN="left"  HEIGHT="20"><fmt:message key="ePH.LaboratoryOrders.label" bundle="${ph_labels}"/>
		<TD width ="30%" CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;' ALIGN="left"   HEIGHT="20"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
</TR>
<%	 
		String sample_type		= "";
		String sample_time		= "";
		String lab_ord				= "";
		String remarks				= "";
		String old_sample_type = "";
		
	     if(getSamplingData.size()!=0) {
		 for(int i=0; i<getSamplingData.size(); i=i+6){          
	         
			if ( rowCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
		  				         
                 sample_type	=  (String)getSamplingData.get(i+1);	 
			     sample_time	=  (String)getSamplingData.get(i+2);
				 lab_ord			=  (String)getSamplingData.get(i+3);
				 remarks			=  (String)getSamplingData.get(i+4);
				 
                 
%>
<tr>
<%
if (!sample_type.equals(old_sample_type)) {
%>
<td class="<%=classvalue%>"><%=sample_type%></td>
<td class="<%=classvalue%>"><%=sample_time%></td>
<td class="<%=classvalue%>"><%=lab_ord%></td>
<td class="<%=classvalue%>"><%=remarks%></td>
<%
}
else {
%>
<td class="<%=classvalue%>"><%=""%></td>
<td class="<%=classvalue%>"><%=""%></td>
<td class="<%=classvalue%>"><%=lab_ord%></td>
<td class="<%=classvalue%>"><%=""%></td>
<%
}%>
</tr>
<% 	rowCount++;
	old_sample_type = sample_type; 
		 }
	}	
	 
%>
</table><br>

<%	   
	   	if(identity.equals("callOrdWindow")){
		String ord_id = request.getParameter("order_id");
		if(Tdmtype.equals("R"))
		   {
			styleord = "display:none";	
		  } else {
            styleord = "display:inline";
		  } 

ArrayList Tdmord_Ids = new ArrayList();
ArrayList  rorder_ids = new ArrayList();

if((ord_id.equals("")) && (Tdmtype.equals("R")))
{
		rorder_ids            = bean.getOrderIds(drug_code.trim(),pat_id.trim());
		
if(rorder_ids.size()!=0) 	 
{
	for(int k=0; k<rorder_ids.size(); k++) 
		{
		Tdmord_Ids.add((String)rorder_ids.get(k));
		}
}
}
else if(ord_id!="")
	{
	Tdmord_Ids = bean.getTdmOrdId(ord_id);	
	
	getPatDet=bean.getPatOrderDet(pat_id,ord_id,drug_code);
	
	}
%>

<table border="1"  cellpadding="0" cellspacing="0"  id="ord_det"  width="100%" align="center"  style="<%=style%>    <%=styleord%>">
       <th  colspan=6 align="center" width="50%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
<TR>
		<TD CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'><fmt:message key="ePH.Drug/dose.label" bundle="${ph_labels}"/></TD>
		<TD CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></TD>
		<TD CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'><fmt:message key="Common.Route.label" bundle="${common_labels}"/></TD>
		<TD CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'><fmt:message key="ePH.freq.label" bundle="${ph_labels}"/><fmt:message key="Common.duration.label" bundle="${common_labels}"/></TD>
		<TD CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TD> 
		<TD CLASS='MENUHIGHERLEVELCOLOR'><label style='color:white;'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></TD>
</TR>
<%	 	
		String drug_dose	 = "";
		String	 drug_form	 = "";
		String freqdur		 = "";
		String start_date	 = "";
		String end_date	 = "";
        String route		     = "";

	      if(getPatDet.size()!=0) {		 
	      for(int i=0; i<getPatDet.size(); i=i+8){           
			if ( rowCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
		  				         
                 drug_dose		 = (String)getPatDet.get(i+1);	 
			     drug_form	     = (String)getPatDet.get(i+2);
				 freqdur			 = (String)getPatDet.get(i+3);
				 start_date		 = (String)getPatDet.get(i+4);
                 end_date   	 = (String)getPatDet.get(i+5);
				 route             = (String)getPatDet.get(i+7);
				%>
<tr>
<td width="15%" class="<%=classvalue%>"><font style='color:blue;font-size:12;cursor:pointer' onclick="callMenuFunctionsFromTDM('View','Pharmacy','<%=ord_id%>','','<%=pat_id%>');"><%=drug_dose%></font></td>
<td width="5%" class="<%=classvalue%>"><%=drug_form%></td>
<td width="5%" class="<%=classvalue%>"><%=route%></td>
<td class="<%=classvalue%>"><%=freqdur%></td>
<td class="<%=classvalue%>"><%=start_date%></td>
<td class="<%=classvalue%>"><%=end_date%></td>
</tr>
<%	rowCount++;
			 }
		}

%>
</table><br>
<%
		
if(Tdmord_Ids.size()!=0) 
		{
		   styletdmord = "display:inline";
		} else {
           styletdmord = "display:none";	
		}
		
		    

if(Tdmord_Ids.size()!=0) 	 {

 for(int j=0; j<Tdmord_Ids.size(); j=j+1) {

	    tdmord_id =  (String)Tdmord_Ids.get(j);


%>
<table  align="center" id="tdm_det"  width="100%"  cellspacing="0" cellpadding="0" style="<%=style%>  <%=styletdmord%>">
 <% if(!tdmord_id.equals("")){
       
%>
        <tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
<% } %>
<th  colspan=8 align="center" width="100%"><fmt:message key="Common.TDMDetails.label" bundle="${common_labels}"/></th>
<%
        String reason="";
		String smoke_yn="";
		String alcohol_yn="";
		String pregnant_yn="";
		String clin_cmnt="";
		String status="";
		String ord_at="";
		String ord_prct="";
		String result_hyper="";
           
			    if(!tdmord_id.equals(""))
			     {
	         	 getTdmDet=bean.getTdmOrderDet(tdmord_id); 
				if(getTdmDet.size()!=0){
				 ord_at				= (String)getTdmDet.get(0);
                 ord_prct			= (String)getTdmDet.get(1);
                 reason			    = (String)getTdmDet.get(2);	 
			     smoke_yn			= (String)getTdmDet.get(3);
				 alcohol_yn			= (String)getTdmDet.get(4);
				 pregnant_yn		= (String)getTdmDet.get(5);
                 clin_cmnt		    = (String)getTdmDet.get(6);
                 status				= (String)getTdmDet.get(7);
				 result_hyper	    = (String)getTdmDet.get(8);
				 }
				 }
%>
<tr width="100%" >
        <td colspan=5  class="label"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/><fmt:message key="Common.At.label" bundle="${common_labels}"/>  &nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<b><%=ord_at%>
		</b></td>
        <td colspan=3  class="label"><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp<b><%=ord_prct%></b></td>
		</tr>  
		<tr >
        <td colspan=8>&nbsp;&nbsp</td> <fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/>
</tr>
<tr >
        <td colspan=8  class="label"><fmt:message key="ePH.ReasonForrequest.label" bundle="${ph_labels}"/>&nbsp;&nbsp<b><%=reason%></b></td>
		</tr>
		<tr>
		<td   colspan=3 class="label"><fmt:message key="Common.Smoking.label" bundle="${common_labels}"/> 
		<%if(smoke_yn.equals("Y")) { %>&nbsp;&nbsp;&nbsp<img src="../../eCommon/images/enabled.gif"></td>
		<%} else { 
	    %>
    	&nbsp;&nbsp;&nbsp<img src="../../eCommon/images/disabled.gif"></td>
        <% }
        %>
		<td   colspan=2 class="label"><fmt:message key="ePH.TakesAlcohol.label" bundle="${ph_labels}"/>
        <% if(alcohol_yn.equals("Y")) {
        %>
		 &nbsp;&nbsp;<img src="../../eCommon/images/enabled.gif"></td>
		<%
		 } else {
		%>&nbsp;&nbsp;<img src="../../eCommon/images/disabled.gif"></td>
        <%
		 }
		%>
	    <td colspan=3 class="label"><fmt:message key="Common.Pregnant.label" bundle="${common_labels}"/>
        <% if(pregnant_yn.equals("Y"))
		 {
        %> &nbsp;&nbsp;<img src="../../eCommon/images/enabled.gif"></td>
		 <%
		 } else {
		%>&nbsp;&nbsp;<img src="../../eCommon/images/disabled.gif"></td>
         <%
		 }
		%> 
</tr>
        <tr >
        <td colspan=8>&nbsp;&nbsp</td>
        </tr>
<tr width="100%">
		<td align="left"  colspan=8 class="label" nowrap><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<b><%=clin_cmnt%></b></td>
</tr>
		<tr ><td colspan=8>&nbsp;&nbsp</td></tr>
		<tr>
        <%if ((result_hyper.equals("Y"))) {
        %>
		<td  colspan=8 class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;<font style='color:blue;font-size:12;cursor:pointer' onclick="resultViewOrderFromTDM('Result','Pharmacy','<%=tdmord_id%>','','DO','<%=pat_id%>','PH');" ><%=status%></font></td>
		<%
		  } else {
		%>
		<td  colspan=8 class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=status%></td>
        <%
		  } 
	    %>
        <td colspan=0></td>
		</tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		<tr> </tr>
		
</table>
<table border="1" align="center" id="tdm_dett"  width="100%"  cellspacing="0" cellpadding="0" style="<%=styletdmord%>">

<tr>  <td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
        <td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></td>
        <td CLASS='MENUHIGHERLEVELCOLOR' align="center" colspan=3 class="label">Sampling</td>
		<td CLASS='MENUHIGHERLEVELCOLOR' align="center" colspan=4 class="label"><fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/></td>
</tr>
<tr>  <td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="13%"></td>
        <td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="5%"></td>
        <td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="6%"><fmt:message key="ePH.Types.label" bundle="${ph_labels}"/></td>
		<td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="9%"></td>
		<td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="6%"><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
		<td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="21%"><fmt:message key="Common.Orders.label" bundle="${common_labels}"/></td>
		<td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="13%"><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/><fmt:message key="ePH.Scheduled.label" bundle="${ph_labels}"/><fmt:message key="Common.At.label" bundle="${common_labels}"/> </td>
		<td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="13%"><fmt:message key="Common.SpecimenCollection.label" bundle="${common_labels}"/> <fmt:message key="Common.At.label" bundle="${common_labels}"/></td>
		<td CLASS='MENUHIGHERLEVELCOLOR' colspan=1 class="label" width="15%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>
		<%
        String  time					  = "";
		String  dosage				  = "";
		String  type					  = "";
		String  smple_when		  = "";
		String  smple_time		  = "";
		String  labords				  = "";
		String  specimen			  = "";
		String  labord_id			  = "";
		String  labord_stat		  = "";
		String  hyper				  = "";
		String  dose_dtls			  = "";
		String  spcmn_shld_at     =  "";
  		ArrayList showLabDosage = new ArrayList();
			
		if(!tdmord_id.equals(""))
	    {
	    showLabDosage=bean.showDosLabDet(ord_id,pat_id,tdmord_id);
		if(showLabDosage.size()!=0) { 
	         for(int i=0; i<showLabDosage.size(); i=i+13)
                    { 
                  time	    =  (String)showLabDosage.get(i+0);	 
		            } }
	
		  bean.setDetails(ord_id,pat_id,drug_code,time);        
	      if(showLabDosage.size()!=0) { 
	      for(int i=0; i<showLabDosage.size(); i=i+13){                 
		     if ( rowCount % 2 == 0 )
				classvalue = "QRYODD" ;
			 else
				classvalue = "QRYEVEN" ;
		  				         
                 time					=  (String)showLabDosage.get(i+0);	 
			     dosage				=  (String)showLabDosage.get(i+1);
				 type					=  (String)showLabDosage.get(i+2);
				 smple_when		=  (String)showLabDosage.get(i+3);
				 smple_time			=  (String)showLabDosage.get(i+4);
				 labords				=  (String)showLabDosage.get(i+6);
				 specimen		    =  (String)showLabDosage.get(i+7);
				 labord_id			=  (String)showLabDosage.get(i+8);
                 labord_stat		=  (String)showLabDosage.get(i+9);
				 hyper				=  (String)showLabDosage.get(i+10);
				 dose_dtls			=  (String)showLabDosage.get(i+11);
				 spcmn_shld_at	=  (String)showLabDosage.get(i+12);
				  
              %>
<tr >  
       <%if (!dose_dtls.equals("")) {
        %>
		<td width="14%" class="<%=classvalue%>"><font style='color:blue;font-size:12;cursor:pointer' onclick="showAdminWindow('<%=time%>');"><%=time%></font></td>
		<%
		  } else {
		%>
		<td width="14%" class="<%=classvalue%>"><%=time%></td>
         <%
		  } 
		 %> 
        
        <td class="<%=classvalue%>" ><%=dosage%></td>
		<td class="<%=classvalue%>"><%=type%></td>
		<td class="<%=classvalue%>"><%=smple_when%></td>
		<td class="<%=classvalue%>" ><%=smple_time%></td>
        <td  class="<%=classvalue%>"><font style='color:blue;font-size:12;cursor:pointer' onclick="callMenuFunctionsFromTDM('View','Laboratory','<%=labord_id%>','','<%=pat_id%>');"><%=labords%></font></td>
        <td  class="<%=classvalue%>" ><%=spcmn_shld_at%></td>
		<td   class="<%=classvalue%>" ><%=specimen%></td>

        <%if ((hyper.equals("Y"))) {
        %>
		<td  class="<%=classvalue%>"><font style='color:blue;font-size:12;cursor:pointer' onclick="resultViewOrderFromTDM('Result','Laboratory','<%=labord_id%>','','DO','<%=pat_id%>','LB');" ><%=labord_stat%></font></td>
		<%
		  } else {
		%>
		<td class="<%=classvalue%>"><%=labord_stat%></td>
         <%
		  } 
		 %>
</tr> 

<%
	rowCount++;
			 }
		  }
		  %>

		  <%
	     }
	  }
    }
 %>
</table>

<%
}
%>
<% if(!tdmord_id.equals("")){ %>
<table align="center" id="tdm_border"  colspan = 8  width="100%"  cellspacing="0" cellpadding="0">
        <tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
		<tr><td CLASS='GREEN' class="label" colspan = 8></td></tr>
</table>
<% } %>
</form>
</body>
</html>


