<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNNonStdRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%!
public String roundTwoDigits(String a)
{
	try
	{
		
		String bb = "";
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}
			else
			{   
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3)
				{
					bb=a.substring(0,a.indexOf(".")+4);
				}
				else
				{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e)
	{
			return a;
			
	}
}

%>

<%
   
	String mode1=request.getParameter("mode");
	if(mode1 == null || mode1.equals("undefined")){mode1="";}
	String order_id								= request.getParameter("order_id");
	if(order_id == null){order_id="";}
	String patient_id							= request.getParameter("patient_id");
	String encounter_id						    = request.getParameter("encounter_id");
	String location_type						= request.getParameter("location_type");
	String location_code						= request.getParameter("location_code");
	String pract_id								= request.getParameter("pract_id");
	String act_patient_class					= request.getParameter("act_patient_class");
	String patient_class                        = request.getParameter("patient_class");
	String height								= request.getParameter("height");
	String weight								= request.getParameter("weight");
	String start_date							= request.getParameter("start_date");
	String priority	 							= request.getParameter("priority");
	String disch_medn_yn                        =request.getParameter("take_home_medication");
	String iv_prep_yn			                = "8";
	//String facility                             =(String)session.getValue("facility_id");
	String npc_n_val	= ""; 
	String carbo_ener	= "";
	String lipid_ener	= "";
	String prot_ener	= "";
	//String drug_class   =null;
	//String drug_code    =null;
	//String order_type   =null;
	String volm         =request.getParameter("volm");
	//String order_id     =null;
/*
	if(mode1.equals("amend"))
	{
		location_type=request.getParameter("amend_loc_type");
		location_code=request.getParameter("amend_loc_code");
		priority=request.getParameter("amend_priority");
		patient_class=request.getParameter("amend_pat_class");
		disch_medn_yn=request.getParameter("amend_take_home_medication");
	}*/

	String bean_id	= "@TPNNonStandardRegimenBean"+patient_id+encounter_id;
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);
	
	bean.setLanguageId(locale);
	
	String bean_id1	= "@TPNStandardRegimenBean"+patient_id+encounter_id;
	String bean_name1	 = "ePH.TPNStandardRegimenBean";
	
	TPNStandardRegimenBean bean1 = (TPNStandardRegimenBean)getBeanObject(bean_id1,bean_name1,request);
	//ArrayList freqlist=bean1.getFrequencies();
	bean1.clear();	

	ArrayList MNEnergies = bean.getMNEnergies();
	
	ArrayList regmnDtls						    =   bean.getRegimenDetails();
	String regimen_code                         =   (String)regmnDtls.get(0);
	
	if(MNEnergies.size()>0){
		carbo_ener = (String)MNEnergies.get(1);
		lipid_ener = (String)MNEnergies.get(3);
		prot_ener  = (String)MNEnergies.get(5);
	}

	String bean_id2				= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name2			= "ePH.TPNRegimenBean";
	TPNRegimenBean bean2	= (TPNRegimenBean)getBeanObject(bean_id2,bean_name2,request);

	//String ph_bean_name		= "ePH.PrescriptionBean_1";
	//String ph_bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
	//PrescriptionBean_1 phbean = (PrescriptionBean_1)mh.getBeanObject(ph_bean_id, request, ph_bean_name);
	//bean.setPresRemarks(phbean.getPresRemarks());

	String cho						=bean2.getCabohydrateOrderQuantity();
	String protein					=bean2.getProteinOrderQuantity();
	String lipid					=bean2.getLipidOrderQuantity();
	String MNunit					=bean1.getUnit();
	String Stremgth_unit			=bean.getenergyunit();
	//out.println("===Stremgth_unit==="+Stremgth_unit+"===== MNunit===="+ MNunit);
	
	if	 (cho==null || (!regimen_code.equals("NON_STANDARD")))
	{
		//.out.println("entered");
		cho="";
	}
	if	 (protein==null || (!regimen_code.equals("NON_STANDARD")))
	{
		protein="";
	}
	if	 (lipid==null || (!regimen_code.equals("NON_STANDARD")))
	{
		lipid="";
	}
	if	 (MNunit==null || (!regimen_code.equals("NON_STANDARD")))
	{
		MNunit="";
	}


	//get values for all groups and populate
	ArrayList MNResults=bean.getTPNGenerics("MN",patient_id,regimen_code);
	ArrayList ELResults=bean.getTPNGenerics("EL",patient_id,regimen_code);
	ArrayList TRResults=bean.getTPNGenerics("TR",patient_id,regimen_code);
	ArrayList VTResults=bean.getTPNGenerics("VT",patient_id,regimen_code);
	ArrayList OTResults=bean.getTPNGenerics("OT",patient_id,regimen_code);
	String MNdesc=bean.getDesc("MN");
	String ELdesc=bean.getDesc("EL");
	String TRdesc=bean.getDesc("TR");
	String VTdesc=bean.getDesc("VT");
	String OTdesc=bean.getDesc("OT");
	//for preferred fluid/item header


    ArrayList tpnparam_vals =(ArrayList)bean.getTpnParams();
	String item_fluid_appl_yn=(String)tpnparam_vals.get(5);
	String header ="";
	String header2="";
	String header3="";
	String header4="";
	String disp_locn_code="";
	String disp_locn ="";
	if(item_fluid_appl_yn.equals("Y"))
	{
	header="<TH align='left' colspan=2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Preferred Fluid/Drug    </th>";
	header2="<TH align='center' colspan=2>Energy    </th>";
	header3="<TH align='center' colspan=2>Volume    </th>";
	}
	else
	{
	header2="<TH align='center' colspan=2>Energy    </th>";
    header4="<TH align='center' colspan=4></th>";
	header3="<TH align='center' colspan=4></th>";
	}

	 //disp_locn_code=CommonBean.checkForNull((String)bean.getDispLocn(location_type,location_code,patient_class,disch_medn_yn,priority));
	
	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocationForTPN(location_type,location_code,disch_medn_yn,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for  MMS-QH-CRF-0048 [IN:037704]
   	/*if(ord_disp_location != null & ord_disp_location.size()>0){ 
		disp_locn_code	= (String)ord_disp_location.get(0); 
		if(disp_locn_code == null) disp_locn_code ="";
	}*/
	  disp_locn_code	= (String)ord_disp_location.get(0);
	 /*if(!disp_locn_code.equals("")){
	 disp_locn = CommonBean.checkForNull(disp_locn_code.substring(0,disp_locn_code.indexOf("|")));
	 }*/
	
	int runningCounter=1;
	String code			="";
	String desc			="";
	String unit			="";
	String max			="";
	String min			="";
	String std			="";
	String dflt			="";
	String default_std	="";
	String def_relvalue ="";
	String AbOrWt		="";
	String cho_energy	="";
	String pro_energy	="";
	String li_energy	="";
	String tot_energy	="";
	String tot_chi_li	="";
	String NPC			="";
	String amend_color	="";

// added for usage_ind,remarks,ceil values

    String ceil         ="";
	String usage_ind    ="";
	String remarks      ="";
	String temponmouseover="";

	float wt=Float.parseFloat(weight);
	//int wt=Integer.parseInt(weight);

	float stdno		=1;
	float def_stdno =1;
	float calc		=0;
	int i			=0;
	
if (mode1.equals("")){
	//out.println("<script> alert('in this');</script>");
	order_id="X";
	%>
<BODY>
	<FORM name="TpnNonStandardRegimen" id="TpnNonStandardRegimen"> 
	<input type="hidden" id="bean_id" name="bean_id" id="bean_id" value=<%=bean_id%> >
    <input type="hidden" id="bean_name" name="bean_name" id="bean_name" value=<%=bean_name%> >
    <input type="hidden" id="mode" name="mode" id="mode" value="">
<div id="MN" name="MN">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4 align="left">&nbsp;&nbsp;&nbsp;&nbsp;<%= MNdesc%></th><TH colspan=2 align="center"><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 ><fmt:message key="ePH.Strength/kg.label" bundle="${ph_labels}"/></th> <%=header2%>
	<%=header%><%=header3%><%=header4%>
	
</Tr>
<%
if(MNResults.size() != 0){
for ( i=0;i<MNResults.size();i+=11)
{
	code		=(String)MNResults.get(i);
	desc		=(String)MNResults.get(i+1);
	unit		=(String)MNResults.get(i+2);
	String tot_unit=unit;
	String unit1     ="";
	if(!unit.equals(""))
	{
		unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
		unit		= unit.substring(0,(unit.indexOf("!"))) ;
	}
	AbOrWt      =(String)MNResults.get(i+3); 
	max		    =(String)MNResults.get(i+4);
	min		    =(String)MNResults.get(i+5);
	std		    =(String)MNResults.get(i+6);
	dflt		=(String)MNResults.get(i+7);

	ceil	    =(String)MNResults.get(i+8);
	usage_ind   =(String)MNResults.get(i+9);
	remarks		=(String)MNResults.get(i+10);
	
	String ovrrde_reason      ="";

	// for preferred fluid/item listbox---line level
     
     HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	 String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
    
    ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
    
	String	relvalue="";
	String strength="";
	String N2="";
	

	if (code.equals("CHO"))	{
		//cho= "";
		// if assessment has been done, we display that value and the mn unit
		if (!cho.equals(""))
		{
			relvalue=cho;	
		}
		else //assessment has not been done and so we rever to the standard value and unit if the default is "Y" otherwise the value will be null
		{
			if (dflt.equals("Y"))
			{
				if(AbOrWt.equals("A"))
					relvalue=std;
				else
					relvalue=(Float.parseFloat(std) * wt) + "";
				MNunit=unit;
			}
			else
			{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		def_relvalue     =relvalue;
		cho_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(carbo_ener)+"";
		//tot_energy=tot_energy+cho_energy+"";
	}
	//Repeat the same logic as of above for protiens and lipids
	if (code.equals("PROTEIN"))
	{
		if (!protein.equals(""))
		{
			relvalue=protein;	
			
		}
		else
		{   
			if (dflt.equals("Y"))
			{
				if(AbOrWt.equals("A"))
					relvalue=std;
				else
					relvalue=(Float.parseFloat(std) * wt) + "";

				MNunit=unit;
			}
			else
			{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		def_relvalue     =relvalue;
		N2				 =Float.parseFloat(relvalue)*(16.0/100.0)+"";
		pro_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(prot_ener)+"";
		
	}
	if (code.equals("LIPID"))
	{ 
		if (!lipid.equals(""))
		{
			relvalue=lipid;	
		}
		else
		{
			if (dflt.equals("Y"))
			{   
				
				if(AbOrWt.equals("A"))
				{
					relvalue=std;
					
				}
				else
				{
					relvalue=(Float.parseFloat(std) * wt) + "";
					
				}

				MNunit=unit;
				
			}
			else
			{
				relvalue="";	
				MNunit=unit;
				
			}
			
		}
		def_relvalue =relvalue;
		
		li_energy	 =Float.parseFloat(relvalue)*Float.parseFloat(lipid_ener)+"";
		
	}
	if (!relvalue.equals("")){
		if(code.equals("CHO")){
			strength		 = cho_energy;
		}else if(code.equals("PROTEIN")){
			strength		 = pro_energy;
		}else if(code.equals("LIPID")){
			strength		 = li_energy;
		}
	}

	if( !li_energy.equals("") && !cho_energy.equals("")&& !pro_energy.equals(""))
	{
     tot_energy
	=((Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+(Float.parseFloat(pro_energy)))+"";

     tot_chi_li=(Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+"";
	 //stdno			 =Math.round(new Float(relvalue).floatValue());
	 if(!N2.equals(""))
	 NPC=(Math.round((Float.parseFloat(tot_chi_li))/(Float.parseFloat(N2))))+"";

	}
	
	
	if (!relvalue.equals(""))
	{
		stdno			 =Math.round(new Float(relvalue).floatValue());
		calc			 =(float)stdno/wt;
	}

	String MNdisabled="",MNwarning="",MNcolor="";
    
	//String overrid_ind="visibility:hidden";
		//"<label align='left'  style='cursor:pointer;color:blue' name='overrid'		id='remarks' onClick=''> &nbsp;Remarks</label>";


      String img_ret_mand = "";
	if(usage_ind.equals("") || usage_ind.equals("B") )
		 img_ret_mand = "visibility:hidden";
	else if(usage_ind.equals("O"))
	     img_ret_mand = "visibility:visible";

	String remarks_ind="";
	    if(remarks.equals(""))
	{
		 remarks_ind="";
	}
	else {  
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";
	}
    
	  
	if(!remarks.equals(""))
		{
			
			temponmouseover="onMouseOver='displayToolTip(\""+remarks+"\")' onMouseOut =hideToolTip()";
			// tempString = tempString + tempOnMouseOver;
		}
	  	
	 
	if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	{

%>	<tr>
	<Td   class="label" align="right" width="12%" nowrap <%=MNcolor%> title="<%=MNwarning%>"><%=desc%>
				<input type="hidden" name=<%="GROUPCODE_"+runningCounter%>  id=<%="GROUPCODE_"+runningCounter%>  value="MN">
				<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
				<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
				<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
				<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
				<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
				<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=ovrrde_reason%>">
				<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
				<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">

				
	</Td>
	<!-- checkMaxLimit(this,6) -->
	
	<Td   class="label" align="left" width="8%">&nbsp;<input type=text title="<%=MNwarning%>" <%=MNdisabled%> onkeypress="return allowValidNumber(this,event,4,2);" onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateValue(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)" name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=6 size=6  value="<%=roundTwoDigits(relvalue)%>">&nbsp;</Td>
   	<Td   class="label" align="left" width="5%" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> ><%=unit1%>&nbsp;</td>
	<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid' style="visibility:visible"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
    <Td   class="label" align="right" width="7%" name=<%="default_value_"+runningCounter%> id=<%="default_value_"+runningCounter%> ><%=roundTwoDigits(def_relvalue)%></Td>
    <Td   class="label" align="left" width="5%" name=<%="default_unit_"+runningCounter%> id=<%="default_unit_"+runningCounter%> >&nbsp;&nbsp;<%=unit1%></Td>

	<Td   class="label" align="right" width="10%">&nbsp;&nbsp;<input type=text size=6 maxlength=6 id='<%="QCALC_"+runningCounter%>' name='<%="QCALC_"+runningCounter%>' value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
	<%
		/*if (!relvalue.equals(""))
		{
			out.println(roundTwoDigits(calc+""));
		}
		else
		{
			out.println("---");
		}*/
	%>

	</Td>
	<Td   class="label" align="left" width="5%">&nbsp;<%=unit1%></Td>
	<Td   class="label" width="9%" align="right"  id=<%="STRENGTH_"+runningCounter%> name=<%="STRENGTH_"+runningCounter%>><%=roundTwoDigits(strength)%></td>
	 <Td   class="label"  width="5%" align="left" >&nbsp;<b><%=Stremgth_unit%></b><%=remarks_ind%></Td>
	 <% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width='6%'>&nbsp;&nbsp;&nbsp;&nbsp;<select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')"><option value=" ">-------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>------------------</option>
	 <% 
						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						%>
							<option value="<%=fluid_code%>"><%=fluid_desc%></option>						
						<%}	%>
	  
	 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=6 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
</tr>
   
<%
		runningCounter++;	
	}
}%>
<tr><td class="label" colspan="18">&nbsp;&nbsp;</td></tr>
<tr><td class="white1" colspan="18">&nbsp;&nbsp;</td></tr>
<tr><td class="label" colspan="18">&nbsp;&nbsp;</td></tr>	
  <tr>
   <Td   class="label" colspan="2"align="right" ><b><fmt:message key="ePH.NPCNRatio.label" bundle="${ph_labels}"/></b></td>
	<Td   class="label">&nbsp;&nbsp;&nbsp;<label class="label" id="npc_label" name="npc_label" align="left">&nbsp;&nbsp;<%=NPC%></label>:1</label></Td>
	<Td   class="label" colspan="5"align="right" >&nbsp;&nbsp;<b><fmt:message key="ePH.TotalEnergy.label" bundle="${ph_labels}"/></b></td>
	<Td   class="label" align="RIGHT" colspan="1" id=<%="TOT_STRENGTH_"+runningCounter%> name=<%="TOT_ENERGY_"+runningCounter%>><label class="label" id="tot_label" name="tot_label"> <%=tot_energy%><label></td>
	<% npc_n_val="NPC:N  Ratio "+NPC+" :1      Total Energy: "+tot_energy+" "+Stremgth_unit; %> 
	<Td   class="label" align="left" colspan=10>&nbsp;<b><%=Stremgth_unit%></b></Td>
 
  </tr>  
	  <tr><td class="label" colspan="18">&nbsp;&nbsp;</td></tr>
	  
<%}
%>


</table>
</div>
<div id="EL" name="EL">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4 align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=ELdesc%></th><th colspan=2><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 ><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th><th colspan=4>&nbsp;</th>
	

</Tr>
<%
for ( i=0;i<ELResults.size();i+=11)
{
	
	code			=(String)ELResults.get(i);
	desc			=(String)ELResults.get(i+1);
	unit			=(String)ELResults.get(i+2);
	String tot_unit=unit;
	String unit1    ="";
	String Ab_wt_lit="";
	if(!unit.equals("")){
	unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
	unit		= unit.substring(0,(unit.indexOf("!"))) ;}
	
	AbOrWt			=(String)ELResults.get(i+3); 
	
	if(AbOrWt.equals("P"))
     Ab_wt_lit    ="/L";
	else
     Ab_wt_lit    ="/Kg";

	max				=(String)ELResults.get(i+4);
	min				=(String)ELResults.get(i+5);
	std				=(String)ELResults.get(i+6);
	dflt			=(String)ELResults.get(i+7);
	
	ceil	    =(String)ELResults.get(i+8);
	usage_ind   =(String)ELResults.get(i+9);
	remarks		=(String)ELResults.get(i+10);
    
	String ovrrde_reason      ="";

	 HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	 String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

	 item_fluid ="N" ;   // hardcoded irrespective of DB value to remove listbox(preferred/fluid drug) for                              electrolytes

	 ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
   
	if ( std != null && !std.equals("") )
	{
		if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
		else if(AbOrWt.equals("P"))
		{
			stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			std = stdno+"";
		}
		else{
					stdno=(Float.parseFloat(std) * wt);
					std = stdno+"";
		}

//		stdno		=Integer.parseInt(std);
	}
	default_std     =std;
	//calc			=(float)stdno/wt;
	if(AbOrWt.equals("P"))
		calc        = (((float)stdno*1000)/Float.parseFloat(volm));

	else
		calc        =  (float)stdno/wt;

	String ELdisabled="",ELwarning="",ELcolor="";

		if (unit==null || unit.equals("") )
		{
			ELdisabled	 =" readonly style='background-color:#E2E2E2' ";
			ELwarning		 ="Constituent Limits not present for  "+desc+" !!! ";
			ELcolor			 = "style=\"color:'red'\"";
		}

     String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {

	if (i%2==0)
	{
		
		//if its even we have to start a row
		out.println("<TR>");
		out.println("<Td  class='label' width='12%' title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap>"+desc);
	}
	else
	{
		out.println("<TR>");
	out.println("<Td  class='label' title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap>"+desc);
	}
%>	
	<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="EL">
	<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
	<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
	<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
	<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
	<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
	<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=ovrrde_reason%>">
	<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
	<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
	
	</Td>
	<Td   class="label" align="left" width="8%">&nbsp;
	<input type=text   <%=ELdisabled%>  title="<%=ELwarning%>" onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)" name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?roundTwoDigits(std):""%>">&nbsp;</Td>
	<Td   class="label"  width="5%"align="left" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> ><%=unit1%>&nbsp;</td>
	<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>">
	</IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="visibility:hidden"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')"> &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
    <Td   class="label"  width="9%"align="right" name=<%="default_value_"+runningCounter%> id=<%="default_value_"+runningCounter%> ><%=roundTwoDigits(default_std)%>&nbsp;</Td>
    <Td   class="label"  width="8%"align="left" name=<%="default_unit_"+runningCounter%> id=<%="default_unit_"+runningCounter%> >&nbsp;<%=unit1%></Td>
		
	<Td   class="label"  width="10%"align="right"><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
		<%
			/*	if (!std.equals(""))
				out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		%>
		
	</Td>
		<%
		
/*			if ((i%2==0)&&(i+2==ELResults.size()-4))
			{
					out.println("	<Td  colspan=6  class=\"label\" align=\"right\">&nbsp;"+unit+"here</Td>");
			}
			else
			{*/

					out.println("	<Td  colspan=1  class=\"label\"  width=\"8%\" align=\"left\">&nbsp;&nbsp;"+unit1+Ab_wt_lit+remarks_ind+"</Td>");
                   
					if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
%>
                  <td colspan=2 align='left' width='10%'>&nbsp;&nbsp;&nbsp;<select   name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%>><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
				 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						%>
							<option value="<%=fluid_code%>"><%=fluid_desc%></option>						
						<%}	%>
				 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
			<% }%>
		<td colspan=2>&nbsp;</td>
 
	<%		if (i%2!=0)
			{
					//if its an odd number, we have to close the row
					out.println("</TR>");
			}

			runningCounter++;
	  }
	}

	%>
</table>
</div>

<%
/*
if (5==5)
{
	return;
}*/
%>

<div id="TR" name="TR">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<% 
	if (TRResults.size() > 0 ){ %>
<TR>
	<TH colspan=4 align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=TRdesc%></th><TH colspan=2 align='left'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
	<%=header%><%=header3%>

</Tr>
<%
	}
for ( i=0;i<TRResults.size();i+=11)
{
		code			=(String)TRResults.get(i);
		desc			=(String)TRResults.get(i+1);
		unit			=(String)TRResults.get(i+2);
		String tot_unit=unit;
		String unit1    ="";
		String Ab_wt_lit="";
	if(!unit.equals("")){
	    unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
		unit		= unit.substring(0,(unit.indexOf("!"))) ;}
		AbOrWt		=(String)TRResults.get(i+3); 
		if(AbOrWt.equals("P"))
			Ab_wt_lit    ="/L";
		else
			Ab_wt_lit    ="/Kg";
		max			=(String)TRResults.get(i+4);
		min			=(String)TRResults.get(i+5);
		std			=(String)TRResults.get(i+6);
		dflt			=(String)TRResults.get(i+7);
		
		ceil	    =(String)TRResults.get(i+8);
	    usage_ind   =(String)TRResults.get(i+9);
	    remarks		=(String)TRResults.get(i+10);

		String ovrrde_reason      ="";

		HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	    String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

		ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
		

		if (!std.equals(""))
		{
			if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
			else if(AbOrWt.equals("P"))
		     {
			stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			std = stdno+"";
		     }
			else{
					stdno=(Float.parseFloat(std) * wt);
					std = stdno+"";
			}

        }
//			stdno	 =Integer.parseInt(std);
            default_std=std;
		
		String TRdisabled="";
		String TRwarning="";
		String TRcolor="";
		if (unit==null || unit.equals("") )
		{
			TRdisabled	 =" readonly style='background-color:#E2E2E2' '";
			TRwarning		 ="Constituent Limits not present for  "+desc+" !!!";
			TRcolor			 = "style=\"color:'red'\"";
		}
		if(AbOrWt.equals("P"))
		     calc        = (float)stdno*1000/Float.parseFloat(volm);
	    else
		     calc			=(float)stdno/wt;

		String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";
		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {
%>	
	<Td   class="label" align="right" width="12%" nowrap <%=TRcolor%> title="<%=TRwarning%>"><%=desc%>
		<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="TR">
		<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
		<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
		<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
		<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
		<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
		<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=ovrrde_reason%>">
		<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
		<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
	</Td>
	<Td   class="label" align="right" width="8%">&nbsp;<input type=text title="<%=TRwarning%>" <%=TRdisabled%>  onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>);"  name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?roundTwoDigits(std):""%>">&nbsp;</Td>
	<Td class="label" align="left" width="5%" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;&nbsp;<%=unit1%>&nbsp;</td>
	<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="visibility:hidden"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
    <Td class="label" align="right" width="4%" name=<%="Default_value_"+runningCounter%> id=<%="Default_value_"+runningCounter%> >&nbsp;&nbsp;<%=roundTwoDigits(default_std)%></Td>
    <Td class="label" align="left" width="6%" name=<%="Default_unit_"+runningCounter%> id=<%="Default_unit_"+runningCounter%> >&nbsp;&nbsp;<%=unit1%></Td>


	<Td   class="label" align="right" width="8%"><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
	<%
		/*	if (!std.equals(""))
					
					out.println(roundTwoDigits(calc+""));
			else
					out.println("---");
		*/
	%>
	
	</Td>
	<Td   class="label" align="left">&nbsp;<%=unit1%>&nbsp;<%=Ab_wt_lit%>&nbsp;<%=remarks_ind%></Td>
	<% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width="8%">&nbsp;&nbsp;&nbsp;<select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')"><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						%>
							<option value="<%=fluid_code%>"><%=fluid_desc%></option>						
						<%}	%>
						</select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=2 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
</tr>
		<%
			runningCounter++;	
	   }
	}

	%>
	</table>
	</div>


<div id="VT" name="VT">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=5 ALIGN='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=VTdesc%></th><th colspan=2 align='center'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 align='left' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
	<%=header%><%=header3%>

</Tr>
<%
		for ( i=0;i<VTResults.size();i+=11)
		{
			code			=(String)VTResults.get(i);
			desc			=(String)VTResults.get(i+1);
			unit			=(String)VTResults.get(i+2);
			String tot_unit=unit;
			String unit1    ="";
			String Ab_wt_lit ="";
	     if(!unit.equals("")){
	         unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
			unit		= unit.substring(0,(unit.indexOf("!"))) ;}
			AbOrWt			=(String)VTResults.get(i+3);
            if(AbOrWt.equals("P"))
			  Ab_wt_lit    ="/L";
		    else
			  Ab_wt_lit    ="/Kg";
			max				=(String)VTResults.get(i+4);
			min				=(String)VTResults.get(i+5);
			std				=(String)VTResults.get(i+6);
			dflt			=(String)VTResults.get(i+7);
			
		   ceil	    =(String)VTResults.get(i+8);
	       usage_ind   =(String)VTResults.get(i+9);
	       remarks		=(String)VTResults.get(i+10);

		   String ovrrde_reason      ="";

		   HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	       String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

		   ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
		   

			if (!std.equals(""))
			{
				if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
				else if(AbOrWt.equals("P"))
		          {
			       // stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
					stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			        std = stdno+"";
		           }
				else{
					stdno=(Float.parseFloat(std) * wt);
					std = stdno+"";
				}
                
	//			stdno		=Integer.parseInt(std);
			}
			default_std       =std;
			String VTdisabled ="";
			String VTwarning  ="";
			String VTcolor    ="";
			if (unit==null || unit.equals("") )
			{
				VTdisabled	 =" readonly style='background-color:#E2E2E2' '";
				VTwarning		 ="Constituent Limits not present for  "+desc+" !!!";
				VTcolor			 = "style=\"color:'red'\"";
			}
			if(AbOrWt.equals("P"))
		        //calc        = (float)stdno/1000;
			    calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	        else
			    calc	=(float)stdno/wt;
            
		String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {
		%>	
		<Td   class="label" align="right" width="12%" nowrap <%=VTcolor%> title="<%=VTwarning%>"><%=desc%>
			<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value='VT'>
			<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
			<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
			<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
			<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
			<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
			<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=ovrrde_reason%>">
			<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
			<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
		</Td>
		<Td   class="label" align="left" width="5%">&nbsp;<input type=text <%=VTdisabled%> title="<%=VTwarning%>" onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)"  name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?roundTwoDigits(std):""%>">&nbsp;</Td>
		<Td   class="label" align="left" width="5%" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;<%=unit1%>&nbsp;<td>
		<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="visibility:hidden"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > <fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
        <Td class="label" align="right" width="6%" name=<%="Default_value_"+runningCounter%> id=<%="Default_value_"+runningCounter%> ><%=roundTwoDigits(default_std)%></Td>
        <Td class="label" align="left" width="6%" name=<%="Default_unit_"+runningCounter%> id=<%="Default_unit_"+runningCounter%> >&nbsp;&nbsp;<%=unit1%></Td>        
		<Td   class="label" align="right" width="10%">&nbsp;&nbsp;<input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
		<%
			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		%>
		
		</Td>
		<Td   class="label" align="left">&nbsp;<%=unit1%>&nbsp;<%=Ab_wt_lit%>&nbsp;<%=remarks_ind%></Td>
		 
		<% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width="15%">&nbsp;&nbsp;&nbsp;<select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')"><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						%>
							<option value="<%=fluid_code%>"><%=fluid_desc%></option>						
						<%}	%></select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=2 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
	</tr>
		<%
			runningCounter++;	
	   }
	}
	%>
	</table>
	</div>



<div id="OT" name="OT">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4 align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=OTdesc%></th><TH colspan=2><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 ><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
	<%=header%><%=header3%>

</Tr>

	<% 
		for ( i=0;i<OTResults.size();i+=11)
		{
				code		=(String)OTResults.get(i);
				desc		=(String)OTResults.get(i+1);
				unit		=(String)OTResults.get(i+2);
				String tot_unit=unit;
				String unit1    ="";
				String Ab_wt_lit="";
	           if(!unit.equals("")){
	            unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
				unit		= unit.substring(0,(unit.indexOf("!"))) ;}
				AbOrWt		=(String)OTResults.get(i+3);

				if(AbOrWt.equals("P"))
			       Ab_wt_lit    ="/L";
		        else
			       Ab_wt_lit    ="/Kg";

				max			=(String)OTResults.get(i+4);
				min			=(String)OTResults.get(i+5);
				std			=(String)OTResults.get(i+6);
				dflt		=(String)OTResults.get(i+7);
				
				ceil	    =(String)OTResults.get(i+8);
	            usage_ind   =(String)OTResults.get(i+9);
	            remarks		=(String)OTResults.get(i+10);

				String ovrrde_reason      ="";

				HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	            String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

				ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
				

				if (!std.equals(""))
				{
					if(AbOrWt.equals("A"))
						stdno=Float.parseFloat(std);
					else if(AbOrWt.equals("P"))
		           {
			          //stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
					  stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			          std = stdno+"";
		           }
					else
					{
						stdno=(Float.parseFloat(std) * wt);
						std = stdno+"";	
					}
			//		stdno=Integer.parseInt(std);
				}
				default_std=std;

				if(AbOrWt.equals("P"))
		           //calc        = (float)stdno/1000;
				   calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	            else
				   calc		=(float)stdno/wt;

				String OTdisabled="";
				String warning="";
				String color="";
				if (unit==null || unit.equals("") )
				{
					OTdisabled	 =" readonly style='background-color:#E2E2E2' '";
					warning		 ="Constituent Limits not present for  "+desc+" !!!";
					color			 = "red";
				}
		String img_ret_mand = "";
	      if(usage_ind.equals("") || usage_ind.equals("B") )
		     img_ret_mand = "visibility:hidden";
	     else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

		 String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		  if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	       {
          	%>	
		<Td   class="label" align="right" width="12%" nowrap style="color='<%=color%>'" title="<%=warning%>"><%=desc%>
			<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="OT">
			<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
			<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
			<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
			<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
			<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
			<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=ovrrde_reason%>">
			<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
			<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">

		</Td>
		<Td   class="label" align="left" title="<%=warning%>" width="8%" >&nbsp;<input type=text  <%=OTdisabled%> onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)" name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?roundTwoDigits(std):""%>">&nbsp;</Td>
		<Td   class="label" align="left" width="5%" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;<%=unit1%>&nbsp;</td>
		<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid'		style="visibility:hidden" id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
        <Td class="label" align="right" width="6%" name=<%="Default_value_"+runningCounter%> id=<%="Default_value_"+runningCounter%> >&nbsp;&nbsp;<%=roundTwoDigits(default_std)%></Td>
        <Td class="label" align="left" width="6%" name=<%="Default_unit_"+runningCounter%> id=<%="Default_unit_"+runningCounter%> >&nbsp;&nbsp;<%=unit1%></Td>  
		<Td   class="label" align="right"><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
		<%
			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		%>
		
		</Td>
		<Td   class="label">
			<!-- <label class="label" id="npc_label1" name="npc_label1" align="left"><%=NPC%></label> -->
			<label id="s1">&nbsp;<%=unit1%>&nbsp;<%=Ab_wt_lit%>&nbsp;<%=remarks_ind%></label></Td>
			<% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width="12%">&nbsp;&nbsp;&nbsp;<select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')"><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						%>
							<option value="<%=fluid_code%>"><%=fluid_desc%></option>						
						<%}	%>
	 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=2 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
	</tr>
		<%
			runningCounter++;	
		   }
	}
	%>
	</table>
	</div>
<!-- <script>showDiv('MN','document');</script> -->
<%} else if(mode1.equals("amend")){ 
	
		HashMap OrderDetails=new HashMap();
		OrderDetails=bean.getOrderDetails2(order_id); 
		//ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("ORREASON_FLUID");
		//String ovrrde_reason="";
		
		%>
<BODY>
	<FORM name="TpnNonStandardRegimen" id="TpnNonStandardRegimen"> 
	   <input type="hidden" id="bean_id" name="bean_id" id="bean_id" value=<%=bean_id%> >
       <input type="hidden" id="bean_name" name="bean_name" id="bean_name" value=<%=bean_name%> > 
	   <input type="hidden" id="mode" name="mode" id="mode" value=<%=mode1%> >
										 <!--  Macro Nutrient -->
<div id="MN" name="MN">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4><%= MNdesc%></th><th colspan=1 align='left'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 ><fmt:message key="ePH.Strength/kg.label" bundle="${ph_labels}"/></th> <%=header2%>
	<%=header%><%=header3%><%=header4%>
	

</Tr>
<%
if(MNResults.size() != 0){
for ( i=0;i<MNResults.size();i+=11)
{
	code		=(String)MNResults.get(i);
	desc		=(String)MNResults.get(i+1);
	unit		=(String)MNResults.get(i+2);
	String tot_unit=unit;
	String unit1     ="";
	if(!unit.equals("")){
	unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
	unit		= unit.substring(0,(unit.indexOf("!"))) ;}
	AbOrWt      =(String)MNResults.get(i+3); 
	max		    =(String)MNResults.get(i+4);
	min		    =(String)MNResults.get(i+5);
	std		    =(String)MNResults.get(i+6);
	dflt		=(String)MNResults.get(i+7);

	ceil	    =(String)MNResults.get(i+8);
	usage_ind   =(String)MNResults.get(i+9);
	remarks		=(String)MNResults.get(i+10);
	
	//String ovrrde_reason      ="";

	 HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	 String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
      ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
	  
  	default_std =std;
	if(OrderDetails.containsKey(code))
	{
		
	  //String def_std=((Float.parseFloat((String)OrderDetails.get(code)))/ wt) + "";
	 String def_std=((Float.parseFloat((String)OrderDetails.get(code)))) + "";
	  std=def_std;	
	  
	  amend_color="red";
		  
	}else{       
	   amend_color="black";       
	   std="0";
	   	
	}
	ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
	
	int index=fld_ovrrd_values.indexOf(code);
	String amend_remarks="";
      if(index!= -1)
	    amend_remarks=(String)fld_ovrrd_values.get(index+2);
	String amend_remarks_visible="";
	if(amend_remarks==null)
		amend_remarks="";

	if(amend_remarks.equals(""))
		amend_remarks_visible="visibility:hidden";
	else
		amend_remarks_visible="visibility:visible";
	

	String	relvalue="";
	String strength="";
	String N2="";
	
	if (code.equals("CHO")){
		// if assessment has been done, we display that value and the mn unit
		if (!cho.equals("")){
			relvalue=(String)OrderDetails.get(code);
			def_relvalue=(String)OrderDetails.get(code);
		}
		else{ //assessment has not been done and so we rever to the standard value and unit if the default is "Y" otherwise the value will be null
			if (dflt.equals("Y")){
				if(AbOrWt.equals("A")){
					relvalue=std;
				    def_relvalue=std;
				}
				else{
//					relvalue		=Math.round((Float.parseFloat(std) * wt)) + "";
//					relvalue		=Math.round((Float.parseFloat(std) / wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(default_std) * wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(std) / wt)) + "";
					relvalue=std;
				    def_relvalue=std;
				}
				MNunit			=unit;
			}
			else{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		cho_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(carbo_ener)+"";
		//tot_energy=tot_energy+cho_energy+"";

	}
	//Repeat the same logic as of above for protiens and lipids

	if (code.equals("PROTEIN")){
		if (!protein.equals("")){
			relvalue=(String)OrderDetails.get(code);
			def_relvalue=(String)OrderDetails.get(code); 
		}
		else{
			if (dflt.equals("Y")){
				if(AbOrWt.equals("A")){
					relvalue=std;
				    def_relvalue=std;  
				}
				else{
//					relvalue		=Math.round((Float.parseFloat(std) * wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(default_std) * wt)) + "";
//					relvalue		=Math.round((Float.parseFloat(std) / wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(std) / wt)) + "";

					relvalue=std;
				    def_relvalue=std;
				}

				MNunit=unit;
			}
			else
			{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		N2=Float.parseFloat(relvalue)*(16.0/100.0)+"";
		//out.println("N2"+N2);
        pro_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(prot_ener)+"";
	
	}
	if (code.equals("LIPID")){		
		if (!lipid.equals("")){			
			relvalue=(String)OrderDetails.get(code);	
			def_relvalue=(String)OrderDetails.get(code);
		}
		else{
			if (dflt.equals("Y")){  
				if(AbOrWt.equals("A")){
					relvalue=std;
				    def_relvalue=std;  
					
                }
				else{
//					relvalue	=Math.round((Float.parseFloat(std) * wt)) + "";
//				    def_relvalue= Math.round((Float.parseFloat(default_std) * wt)) + "";
//					relvalue	=Math.round((Float.parseFloat(std) / wt)) + "";
//				    def_relvalue= Math.round((Float.parseFloat(std) / wt)) + "";

					relvalue=std;
				    def_relvalue=std;
				}
				MNunit=unit;
			}
			else{
				relvalue="";	
				MNunit=unit;
			}
		}

		li_energy	 =Float.parseFloat(relvalue)*Float.parseFloat(lipid_ener)+"";
	}
	if (!relvalue.equals("")){
		if(code.equals("CHO")){
			strength		 = cho_energy;
		}
		else if(code.equals("PROTEIN")){
			strength		 = pro_energy;
		}
		else if(code.equals("LIPID")){
			strength		 = li_energy;
		}
	}

/*	if (!relvalue.equals("") && code.equals("LIPID"))
	{
		strength		 =Float.parseFloat(relvalue)*9.0+"";
		
	}
	else{
		strength		 =Float.parseFloat(relvalue)*4.0+"";
		}*/
	if( !li_energy.equals("") && !cho_energy.equals("")&& !pro_energy.equals(""))
	{
     tot_energy
	=((Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+(Float.parseFloat(pro_energy)))+"";

     tot_chi_li=(Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+"";
	 //stdno			 =Math.round(new Float(relvalue).floatValue());
	 if(!N2.equals(""))
	 NPC=(Math.round((Float.parseFloat(tot_chi_li))/(Float.parseFloat(N2))))+"";

	}
	if (!relvalue.equals("")){
		stdno			 =Math.round(new Float(relvalue).floatValue());
		calc			 =(float)stdno/wt;
	}

	String MNdisabled="",MNwarning="",MNcolor="";
	npc_n_val="NPC:N  Ratio "+NPC+" :1     Total Energy: "+tot_energy+" "+Stremgth_unit; 
    
	String img_ret_mand = "";
	if(usage_ind.equals("") || usage_ind.equals("B") )
		img_ret_mand = "visibility:hidden";
	else if(usage_ind.equals("O"))
	     img_ret_mand = "visibility:visible";
	  
    String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";		

	if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	{

%>	<tr>
	<Td   CLASS="label" align="right" width="12%" nowrap <%=MNcolor%> title="<%=MNwarning%>"><font color='<%=amend_color%>'><%=desc%>
				<input type="hidden" name=<%="GROUPCODE_"+runningCounter%>  id=<%="GROUPCODE_"+runningCounter%>  value="MN">
				<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
				<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
				<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
				<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
				<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
			    <input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=amend_remarks%>">
				<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
				<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
				
	</Td>
	<%
		//out.println("desc- 1547--->" +desc);
		//out.println("runningCounter- 1548--->" +runningCounter);
		%>

	<Td   CLASS="label" align="left" width="8%">&nbsp;<input type=text title="<%=MNwarning%>" <%=MNdisabled%> onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateValue(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)" name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=3 size=5  value="<%=relvalue%>">&nbsp;</Td>

	<Td   CLASS="label" align="left" width="2%" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> ><%=unit1%>&nbsp;</td>
	<td width="21%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"><label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="<%=amend_remarks_visible%>"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></IMG></Td>

    <Td   CLASS="label" align="center" width="8%" name=<%="default_strength_"+runningCounter%> id=<%="default_strength_"+runningCounter%> ><%=def_relvalue%>&nbsp;<%=unit1%></Td>

	<Td   CLASS="label" align="right"  width="10%"><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
	<%
	/*	if (!relvalue.equals(""))
		{
			out.println(roundTwoDigits(calc+""));
		}
		else
		{
			out.println("---");
		}*/
	%>
	
	</Td>
	<%//out.println("strength-----1565---->" +strength);%>
	<Td   CLASS="label" align="left" width="5%">&nbsp;<%=unit1%></Td>
	<Td   CLASS="label" align="right"  width="8%" id=<%="STRENGTH_"+runningCounter%> name=<%="STRENGTH_"+runningCounter%>><%=roundTwoDigits(strength)%></td>
	 <Td  CLASS="label" align="left"  width="10%">&nbsp;<b><%=Stremgth_unit%></b>&nbsp;<%=remarks_ind%></Td>
	 <% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
		%>
	 <td colspan=2 align='left' width="8%"><select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')" disabled ><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
							
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1)==null?"":(String)fld_ovrrd_values.get(index+1);

							   if(default_fluid.equals(fluid_code)){
%>
									 <option value="<%=fluid_code%>" selected><%=fluid_desc%></option>
									 <!-- <input type='hidden' name='def_code' id='def_code' value='<%=fluid_code%>'> -->
<% 
                                	}else{
%>
							         <option value="<%=fluid_code%>"><%=fluid_desc%></option> 						
<%                                  } 
								 }
%>
	 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=6 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%> nowrap>&nbsp;</td>
</tr>
   <script>populateVolume('<%="ITEMFLUID_"+runningCounter%>','<%=runningCounter%>')</script>
<%
		runningCounter++;
	}
	
}%>

<tr><td class="label" colspan="18">&nbsp;&nbsp;</td></tr>
<tr><td class="white1" colspan="18">&nbsp;&nbsp;</td></tr>
<tr><td class="label" colspan="18">&nbsp;&nbsp;</td></tr>	
  <tr>
   <Td   class="label" colspan="2"align="right" ><b><fmt:message key="ePH.NPCNRatio.label" bundle="${ph_labels}"/></b></td>
	<Td   class="label" width="2%"><label class="label" id="npc_label" name="npc_label" align="left">&nbsp;&nbsp;<%=NPC%></label>:1</label></Td>
	<Td   class="label" colspan="4"align="right" >&nbsp;&nbsp;<b><fmt:message key="ePH.TotalEnergy.label" bundle="${ph_labels}"/></b></td>
	<Td   class="label" align="RIGHT" colspan="1" id=<%="TOT_STRENGTH_"+runningCounter%> name=<%="TOT_ENERGY_"+runningCounter%>><label class="label" id="tot_label" name="tot_label"> <%=tot_energy%><label></td>
	<Td   class="label" align="left" colspan="10">&nbsp;<b><%=Stremgth_unit%></b></Td>
 
  </tr>  
	  <tr><td class="label" colspan="18">&nbsp;&nbsp;</td></tr>
	  
<%}
%>

                                    <!-- ElctroLytes -->
</table>
</div>
<div id="EL" name="EL">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4><%=ELdesc%></th><th colspan=2 align='right'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 align="center"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
<!--	<td class='white'>&nbsp;</td>
	<TH colspan=3><%=ELdesc%><th colspan=2 >Strength/kg</th>-->
</Tr>
<%
for ( i=0;i<ELResults.size();i+=11)
{
	code			=(String)ELResults.get(i);
	desc			=(String)ELResults.get(i+1);
	unit			=(String)ELResults.get(i+2);
	String tot_unit=unit;
	String unit1    ="";
	String Ab_wt_lit="";
	if(!unit.equals("")){
	unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
	unit		= unit.substring(0,(unit.indexOf("!"))) ;}
	AbOrWt			=(String)ELResults.get(i+3); 
	if(AbOrWt.equals("P"))
     Ab_wt_lit    ="/L";
	else
     Ab_wt_lit    ="/Kg";
	max				=(String)ELResults.get(i+4);
	min				=(String)ELResults.get(i+5);
	std				=(String)ELResults.get(i+6);
	dflt			=(String)ELResults.get(i+7);

	ceil	    =(String)ELResults.get(i+8);
	usage_ind   =(String)ELResults.get(i+9);
	remarks		=(String)ELResults.get(i+10);
	

    //String ovrrde_reason      ="";
	
	if (!std.equals("") && std != null)
	{

		if(AbOrWt.equals("A"))
			stdno=Float.parseFloat(std);
		else if(AbOrWt.equals("P"))
		{
			
			//stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
			stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			std = stdno+"";
		}
		else{
				stdno=(Float.parseFloat(std) * wt);
				std = stdno+"";
		   }

//		stdno		=Integer.parseInt(std);
	}
    default_std=std;
	if(OrderDetails.containsKey(code)){
		//std=(String)OrderDetails.get(code);
		//stdno=(Float.parseFloat(std));
	    amend_color="red";
		  
	}else{       
	   amend_color="black";
	   stdno=0;
	   std="0";	   	
	}
        
      ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
		
	  int index=fld_ovrrd_values.indexOf(code);
	  String amend_remarks="";
      if(index!= -1)
	  amend_remarks=(String)fld_ovrrd_values.get(index+2);
	  String amend_remarks_visible="";
	if(amend_remarks==null)
		amend_remarks="";

	if(amend_remarks.equals(""))
		amend_remarks_visible="visibility:hidden";
	else
		amend_remarks_visible="visibility:visible";


	//calc			=(float)stdno/wt;
	if(AbOrWt.equals("P"))
		//calc        = (float)stdno/1000;
	    calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	else
		calc        =  (float)stdno/wt;

	String ELdisabled="",ELwarning="",ELcolor="";

		if (unit==null || unit.equals("") )
		{
			ELdisabled	 =" readonly style='background-color:#E2E2E2' ";
			ELwarning		 ="Constituent Limits not present for  "+desc+" !!! ";
			ELcolor			 = "style=\"color:'red'\"";
		}
       
	   String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {
	if (i%2==0)
	{
		//if its even we have to start a row
		out.println("<TR>");
		out.println("<Td  class='label' width='12%'  title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap> <font color='"+amend_color+"'>"+desc);
	}
	else
	{
		out.println("<TR>");
	out.println("<Td  class='label' title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap><font color='"+amend_color+"'>"+desc);
	}

%>	
	<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="EL">
	<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
	<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
	<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
	<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
	<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
	<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=amend_remarks%>">
	<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
	<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
	</Td>
	<Td   class="label" align="left" width="8%">&nbsp;
	<input type=text   <%=ELdisabled%>  title="<%=ELwarning%>" onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)" name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?roundTwoDigits(std):""%>">&nbsp;</Td>   
	<Td   class="label" align="left" width="5%"  name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;<%=unit1%>&nbsp;</td>
	<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="<%=amend_remarks_visible%>"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
    <Td   class="label" align="right" width="15%"  name=<%="default_sterngth_"+runningCounter%> id=<%="default_sterngth_"+runningCounter%> >&nbsp;<%=roundTwoDigits(default_std)%></Td>
   <Td   class="label" align="left" width="5%"  name=<%="default_unit_"+runningCounter%> id=<%="default_unit_"+runningCounter%> >&nbsp;<%=unit1%></Td>
    
	<Td   class="label" align="right" ><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
		<%
			/*	if (!std.equals(""))
				out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		%>
	</Td>
		<%
		
/*			if ((i%2==0)&&(i+2==ELResults.size()-4))
			{
					out.println("	<Td  colspan=6  class=\"label\" align=\"right\">&nbsp;"+unit+"here</Td>");
			}
			else
			{*/

					out.println("	<Td  colspan=1  class=\"label\" align=\"left\">&nbsp;"+unit1+Ab_wt_lit+remarks_ind+"</Td>");
			//}

			if (i%2!=0)
			{
					//if its an odd number, we have to close the row
					out.println("</TR>");
			}
			runningCounter++;
	   }
	}

	%>
</table>
</div>

<%
/*
if (5==5)
{
	return;
}*/
%>
                                        <!--  , Elements -->
<div id="TR" name="TR">
	
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<% 
	if (TRResults.size() > 0 ){ %>
<TR>
	<TH colspan=4><%=TRdesc%></th><TH colspan=2 align='right'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
	<%=header%><%=header3%>

</Tr>
<%
	}
for ( i=0;i<TRResults.size();i+=11)
{
		code			=(String)TRResults.get(i);
		desc			=(String)TRResults.get(i+1);
		unit			=(String)TRResults.get(i+2);
		String tot_unit=unit;
	    String unit1    ="";
	    String Ab_wt_lit="";
		if(!unit.equals("")){
		unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
		unit		= unit.substring(0,(unit.indexOf("!"))) ;}
		AbOrWt			=(String)TRResults.get(i+3); 
		if(AbOrWt.equals("P"))
		 Ab_wt_lit    ="/L";
		else
		 Ab_wt_lit    ="/Kg";
		max				=(String)TRResults.get(i+4);
		min				=(String)TRResults.get(i+5);
		std				=(String)TRResults.get(i+6);
		dflt			=(String)TRResults.get(i+7);
   
		ceil	    =(String)TRResults.get(i+8);
	    usage_ind   =(String)TRResults.get(i+9);
	    remarks		=(String)TRResults.get(i+10);
		
		HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	    String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
        ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
		 

		//String ovrrde_reason      ="";
		
	   default_std=std;
		if(OrderDetails.containsKey(code)){
			std=(String)OrderDetails.get(code);
		   amend_color="red";	
		  
	    }else{       
	      amend_color="black";	      
	      std="";	   	
	   }
	   ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
	   int index=fld_ovrrd_values.indexOf(code);
	   String amend_remarks="";
        if(index!= -1)
	        amend_remarks=(String)fld_ovrrd_values.get(index+2);
	   String amend_remarks_visible="";
		if(amend_remarks==null)
			amend_remarks="";

		if(amend_remarks.equals(""))
			amend_remarks_visible="visibility:hidden";
		else
			amend_remarks_visible="visibility:visible";

		if (!std.equals(""))
		{
			if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
		   else if(AbOrWt.equals("P"))
		       {
			       //stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
				   stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			       std = stdno+"";
		       }
			else{
//					stdno       =(Float.parseFloat(std) * wt);
//					def_stdno   =(Float.parseFloat(default_std) * wt);

					stdno		=  Math.round((Float.parseFloat(std) / wt));
				    def_stdno	=  Math.round((Float.parseFloat(default_std) / wt));

					std         = stdno+"";
					

			}
             default_std = def_stdno+""; 
//			stdno	 =Integer.parseInt(std);
		}
		String TRdisabled="";
		String TRwarning="";
		String TRcolor="";
		if (unit==null || unit.equals("") )
		{
			TRdisabled	 =" readonly style='background-color:#E2E2E2' '";
			TRwarning		 ="Constituent Limits not present for  "+desc+" !!!";
			TRcolor			 = "style=\"color:'red'\"";
		}
		
		//calc			=(float)stdno/wt;

		if(AbOrWt.equals("P"))
		   //calc        = (float)stdno/1000;
		   calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	    else
		   calc        =  (float)stdno/wt;

		String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {
%>	
	<Td   class="label" align="right" width="12%" nowrap <%=TRcolor%> title="<%=TRwarning%>"><font color='<%=amend_color%>'><%=desc%>
		<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="TR">
		<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
		<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
		<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
		<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
		<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
		<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=amend_remarks%>">
        <input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
		<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
		
	</Td>
	<Td   class="label" align="right" width="8%">&nbsp;<input type=text title="<%=TRwarning%>" <%=TRdisabled%> onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)"  name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?std:""%>">&nbsp;</Td>
	<Td   class="label" align="left" width="5%" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;<%=unit1%>&nbsp;</td>
	<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG><label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="<%=amend_remarks_visible%>"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
   <Td   class="label" align="right" width="5%" name=<%="default_value_"+runningCounter%> id=<%="default_value_"+runningCounter%> >&nbsp;<%=default_std%></Td>
   <Td   class="label" align="left" width="6%" name=<%="default_unit_"+runningCounter%> id=<%="default_unit_"+runningCounter%> >&nbsp;<%=unit1%></Td>

	<Td   class="label" align="right"  width="8%" ><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
	<%
/*			if (!std.equals(""))
					
					out.println(roundTwoDigits(calc+""));
			else
					out.println("---");
*/
	%>
	</Td>
	<Td   class="label" width="6%" align="left">&nbsp;<%=unit1%>&nbsp;<%=Ab_wt_lit%>&nbsp;<%=remarks_ind%></Td>
	<% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width="11%"><select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')" disabled ><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
		                    
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1);
							   if(default_fluid.equals(fluid_code)){
%>
									 <option value="<%=fluid_code%>" selected><%=fluid_desc%></option>
<% 
                                	}else{
%>
							         <option value="<%=fluid_code%>"><%=fluid_desc%></option> 						
<%                                  } 
								 }
%>
	 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=2 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
</tr>
<script>populateVolume('<%="ITEMFLUID_"+runningCounter%>','<%=runningCounter%>')</script>
		<%
			runningCounter++;
	   }
	}

	%>
	</table>
	</div>

                                               <!--  Vitamins -->
<div id="VT" name="VT">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4><%=VTdesc%></th><th colspan=2 align='center'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 align='left' >&nbsp;&nbsp;<fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
	<%=header%><%=header3%>

</Tr>
<%
		for ( i=0;i<VTResults.size();i+=11)
		{
			code			=(String)VTResults.get(i);
			desc			=(String)VTResults.get(i+1);
			unit			=(String)VTResults.get(i+2);
			String tot_unit=unit;
			String unit1    ="";
			String Ab_wt_lit="";
			if(!unit.equals("")){
			unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
			unit		= unit.substring(0,(unit.indexOf("!"))) ;}
			AbOrWt			=(String)VTResults.get(i+3);
			if(AbOrWt.equals("P"))
			 Ab_wt_lit    ="/L";
			else
			 Ab_wt_lit    ="/Kg";
			max				=(String)VTResults.get(i+4);
			min				=(String)VTResults.get(i+5);
			std				=(String)VTResults.get(i+6);
			dflt			=(String)VTResults.get(i+7);
			ceil	    =(String)VTResults.get(i+8);
	        usage_ind   =(String)VTResults.get(i+9);
	        remarks		=(String)VTResults.get(i+10);
			
			HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	        String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
            ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);

			//String ovrrde_reason      ="";

			default_std     =std;
			if(OrderDetails.containsKey(code)){
				std=(String)OrderDetails.get(code);
			    amend_color="red";		  
	       }else{       
	           amend_color="black";	      
	           std="";	   	
	         }

			ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
			int index=fld_ovrrd_values.indexOf(code);
			  String amend_remarks="";
               if(index!= -1)
        		  amend_remarks=(String)fld_ovrrd_values.get(index+2);
			String amend_remarks_visible="";
				if(amend_remarks==null)
					amend_remarks="";

				if(amend_remarks.equals(""))
					amend_remarks_visible="visibility:hidden";
				else
					amend_remarks_visible="visibility:visible";

			if (!std.equals(""))
			{
				if(AbOrWt.equals("A"))
					stdno		=Float.parseFloat(std);
				else if(AbOrWt.equals("P"))
		          {
			        //  stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
					stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			          std = stdno+"";
		          }
				else{
					//stdno		=(Float.parseFloat(std) * wt);
					stdno		=(Float.parseFloat(std));
					def_stdno   =(Float.parseFloat(default_std) * wt);
					std			= stdno+"";
					default_std = def_stdno+"";
					 
				}

	//			stdno		=Integer.parseInt(std);
			}
			String VTdisabled="";
			String VTwarning="";
			String VTcolor="";
			if (unit==null || unit.equals("") )
			{
				VTdisabled	 =" readonly style='background-color:#E2E2E2' '";
				VTwarning		 ="Constituent Limits not present for  "+desc+" !!!";
				VTcolor			 = "style=\"color:'red'\"";
			}
			
			//calc	=(float)stdno/wt;
            
			if(AbOrWt.equals("P"))
		       //calc        = (float)stdno/1000;
			   calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	        else
		       calc        =  (float)stdno/wt;

			String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	   else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	    {
		%>	
		<Td   class="label" align="right" width="12%" nowrap <%=VTcolor%> title="<%=VTwarning%>"><font color=<%=amend_color%>><%=desc%>
			<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="VT">
			<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
			<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
			<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
			<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
			<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
			<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=amend_remarks%>">
			<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
			<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">
		</Td>
		<Td   class="label" align="left" width="8%">&nbsp;<input type=text <%=VTdisabled%> title="<%=VTwarning%>" onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)"  name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?std:""%>">&nbsp;</Td>
		<Td   class="label" width="5%"align="left" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;<%=unit1%></td>
		<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG>
		<label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="<%=amend_remarks_visible%>"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
        <Td   class="label" width="8%"align="right" name=<%="default_value_"+runningCounter%> id=<%="default_value_"+runningCounter%> >&nbsp;<%=default_std%></Td> 
		<Td   class="label" width="8%"align="left" name=<%="default_unit_"+runningCounter%> id=<%="default_unit_"+runningCounter%> >&nbsp;<%=unit1%></Td>
		<Td   class="label" width="9%"align="right" ><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
		<%
			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		%></Td>
		<Td   class="label"width="10%" align="left">&nbsp;<%=unit1%>&nbsp;<%=Ab_wt_lit%>&nbsp;<%=remarks_ind%></Td>
		<% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width="11%"><select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')" disabled ><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%
						for (int k=0;k<fluidvalues.size();k=k+2){
		                    
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1);
							   if(default_fluid.equals(fluid_code)){
%>
									 <option value="<%=fluid_code%>" selected><%=fluid_desc%></option>
<% 
                                	}else{
%>
							         <option value="<%=fluid_code%>"><%=fluid_desc%></option> 						
<%                                  } 
								 }
	%>
	 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=2 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
	</tr>
	<script>populateVolume('<%="ITEMFLUID_"+runningCounter%>','<%=runningCounter%>')</script>
		<%
			runningCounter++;
		}
	}
	%>
	</table>
	</div>

										 <!-- Othere Components -->

<div id="OT" name="OT">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<TR>
	<TH colspan=4><%=OTdesc%></th><th colspan=2 align='right'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></th><th colspan=2 align='left'>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th><%=header%><%=header3%>

</Tr>

	<% 	
		for ( i=0;i<OTResults.size();i+=11)
		{
				code		=(String)OTResults.get(i);
				desc		=(String)OTResults.get(i+1);
				unit		=(String)OTResults.get(i+2);
				String tot_unit=unit;
				String unit1    ="";
				String Ab_wt_lit="";
				if(!unit.equals("")){
				unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
				unit		= unit.substring(0,(unit.indexOf("!"))) ;}
				AbOrWt		=(String)OTResults.get(i+3);
				if(AbOrWt.equals("P"))
				 Ab_wt_lit    ="/L";
				else
				 Ab_wt_lit    ="/Kg";
				max			=(String)OTResults.get(i+4);
				min			=(String)OTResults.get(i+5);
				std			=(String)OTResults.get(i+6);
				dflt		=(String)OTResults.get(i+7);
                
				ceil	    =(String)OTResults.get(i+8);
	            usage_ind   =(String)OTResults.get(i+9);
	            remarks		=(String)OTResults.get(i+10);
				                
				HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	            String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
                ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
				

				//String ovrrde_reason      ="";
				
				default_std =std;
				if(OrderDetails.containsKey(code)){
					std=(String)OrderDetails.get(code);
				    amend_color="red";		  
	           }else{       
	                amend_color="black";	      
	                std="";	   	
	           }

			  ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
			  int index=fld_ovrrd_values.indexOf(code);
			  String amend_remarks="";
                if(index!= -1)
			      amend_remarks=(String)fld_ovrrd_values.get(index+2);
			  String amend_remarks_visible="";
					if(amend_remarks==null)
						amend_remarks="";

					if(amend_remarks.equals(""))
						amend_remarks_visible="visibility:hidden";
					else
						amend_remarks_visible="visibility:visible";

				if (!std.equals(""))
				{
					if(AbOrWt.equals("A")){
						stdno		=Float.parseFloat(std);
						def_stdno   =Float.parseFloat(default_std);

					}
					else if(AbOrWt.equals("P"))
		             {
			              // stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
						  stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			               std = stdno+"";
		              }
			   else{
						//stdno		=(Float.parseFloat(std) * wt);
						stdno		=(Float.parseFloat(std));
						def_stdno	=(Float.parseFloat(default_std) * wt);

					}
					std			= stdno+"";
					default_std = default_std+"";

			//		stdno=Integer.parseInt(std);
				}
				
				//calc		=(float)stdno/wt;

				if(AbOrWt.equals("P"))
		              // calc        = (float)stdno/1000;
				       calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	            else
		               calc        =  (float)stdno/wt;

				String OTdisabled="";
				String warning="";
				String color="";
				if (unit==null || unit.equals("") )
				{
					OTdisabled	 =" readonly style='background-color:#E2E2E2' '";
					warning		 ="Constituent Limits not present for  "+desc+" !!!";
					color			 = "red";
				}
				String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	    {

			%>	
		<Td   class="label" align="right" width="12%" nowrap style="color='<%=color%>'" title="<%=warning%>"><font color='<%=amend_color%>'><%=desc%>
			<input type="hidden" name=<%="GROUPCODE_"+runningCounter%> id=<%="GROUPCODE_"+runningCounter%>  value="OT">
			<input type="hidden" name=<%="CODE_"+runningCounter%> id=<%="CODE_"+runningCounter%>  value="<%=code%>">
			<input type="hidden" name=<%="QMIN_"+runningCounter%> id=<%="QMIN_"+runningCounter%>  value="<%=min%>">
			<input type="hidden" name=<%="QMAX_"+runningCounter%> id=<%="QMAX_"+runningCounter%>  value="<%=max%>">
			<input type="hidden" name=<%="DESC_"+runningCounter%> id=<%="DESC_"+runningCounter%>  value="<%=desc%>">
			<input type="hidden" name=<%="CEIL_"+runningCounter%> id=<%="CEIL_"+runningCounter%>  value="<%=ceil%>">
			<input type="hidden" name=<%="OVERRIDE_"+runningCounter%> id=<%="OVERRIDE_"+runningCounter%>  value="<%=amend_remarks%>">
			<input type="hidden" name=<%="QUNIT_"+runningCounter%> id=<%="QUNIT_"+runningCounter%>  value="<%=tot_unit%>">
			<input type="hidden" name=<%="ABORWT_"+runningCounter%> id=<%="ABORWT_"+runningCounter%>  value="<%=AbOrWt%>">

		</Td>
		<Td   class="label" align="right" title="<%=warning%>" width="8%" >&nbsp;<input type=text  <%=OTdisabled%> onBlur="CheckPositiveNumber(this);checkMand(this,'<%=desc%>','<%=runningCounter%>');CheckRange(this,<%=runningCounter%>,'<%=AbOrWt%>',<%=wt%>)" name=<%="QVALUE_"+runningCounter%> id=<%="QVALUE_"+runningCounter%> maxlength=5 size=5  value="<%=dflt.equals("Y")?std:""%>">&nbsp;</Td>
		<Td   class="label" width="5%"align="left" name=<%="UNIT_"+runningCounter%> id=<%="UNIT_"+runningCounter%> >&nbsp;<%=unit1%></td>
		<td width="18%" align='left'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate<%=runningCounter%>"></IMG>
		<label align='left'  style='cursor:pointer;color:blue' name='overrid'	style="<%=amend_remarks_visible%>"	id='overrid<%=runningCounter%>' onClick="showreason('<%=runningCounter%>')" nowrap > &nbsp;<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></label></Td>
        <Td   class="label" width="4%"align="right" name=<%="default_value_"+runningCounter%> id=<%="default_value_"+runningCounter%> >&nbsp;<%=default_std%></Td>
		<Td   class="label" width="6%"align="left" name=<%="default_unit_"+runningCounter%> id=<%="default_unit_"+runningCounter%> >&nbsp;<%=unit1%></Td>

		<Td   class="label" align="right" width="8%" ><input type=text size=6 maxlength=6 id=<%="QCALC_"+runningCounter%> name=<%="QCALC_"+runningCounter%> value="<%=roundTwoDigits(calc+"")%>" onkeypress='return allowValidNumber(this,event,4,4);' onchange="CheckPositiveNumber(this);if (this.value==0){this.value=''};checkMand(this,'<%=desc%>','<%=runningCounter%>');calculateFrmStrngth(document.TpnNonStandardRegimen,<%=runningCounter%>,this.value);">
		<%
			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		%></Td>
		<Td   class="label"><label class="label"width="8%" id="npc_label1" name="npc_label1" align="left">&nbsp;<%=NPC%></label><label width="8%" id="s1">&nbsp;<%=unit1%>&nbsp;<%=Ab_wt_lit%>&nbsp;<%=remarks_ind%></label></Td>
		<% if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){%>
	 <td colspan=2 align='left' width="8%"><select name=<%="ITEMFLUID_"+runningCounter%> id=<%="ITEMFLUID_"+runningCounter%> onchange="populateVolume(this,'<%=runningCounter%>')" disabled ><option value=" ">----------------------------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>--------------------------</option>
	 <%for (int k=0;k<fluidvalues.size();k=k+2){
		                   
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1);
							   if(default_fluid.equals(fluid_code)){
%>
									 <option value="<%=fluid_code%>" selected><%=fluid_desc%></option>
<% 
                                	}else{
%>
							         <option value="<%=fluid_code%>"><%=fluid_desc%></option> 						
<%                                  }
								 }
%>
	 </select></td>
	 <% }else {%>
	 <td colspan=2>&nbsp;</td>
	 <%}%>
	 <td class=label colspan=2 align='center' name=<%="VOLUME_"+runningCounter%> id=<%="VOLUME_"+runningCounter%>>&nbsp;</td>
	</tr>
	<script>populateVolume('<%="ITEMFLUID_"+runningCounter%>','<%=runningCounter%>')</script>
		<%
			runningCounter++;
		}
	}
	%>
	</table>
</div>   
<%}%>
<input type="hidden" id="totalrows" name="totalrows" id="totalrows" value=<%=runningCounter-1%> >

<input type="hidden" name="patient_id" id="patient_id"	value="<%=patient_id%>" >
<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounter_id%>">
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>">
<input type="hidden" name="pract_id" id="pract_id"		value="<%=pract_id%>" > 
<input type="hidden" name="patient_class" id="patient_class" value="<%=act_patient_class.trim()%>">
<input type="hidden" name="height" id="height"		value="<%=height%>">
<input type="hidden" name="weight" id="weight"		value="<%=weight%>"> 
<input type="hidden" name="order_date" id="order_date"	value="<%=start_date%>">
<input type="hidden" name="priority" id="priority"		value="<%=priority%>">
<input type="hidden" name="freqNature" id="freqNature"			>
<input type="hidden" name="NPC" id="NPC"			value="">
<input type="hidden" name="total" id="total"			value=""> 
<input type="hidden" name="NPC_N_val" id="NPC_N_val"		value="<%=npc_n_val%>">
<input type="hidden" name="carbo_ener" id="carbo_ener"	value="<%=carbo_ener%>">
<input type="hidden" name="lipid_ener" id="lipid_ener"	value="<%=lipid_ener%>">
<input type="hidden" name="prot_ener" id="prot_ener"		value="<%=prot_ener%>">

</FORM>
<label id="tool_tip" style="visibility:hidden"></label>
		<DIV  name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:50%; visibility:visible;" bgcolor="yellow" align="left">
		<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="right" bgcolor="yellow">
		<tr><td width="100%" id="t"></td></tr></div>
<% 
	putObjectInBean(bean_id,bean,request); 
	putObjectInBean(bean_id1,bean1,request); 
	putObjectInBean(bean_id2,bean2,request); 
	
%>
<script>
	showDiv('MN','document');  
	//colorTabs("parent.DetailFrame.document");
	parent.HeaderFrame.TpnNonStandardRegimen.name1.click(); 
</script> 
</html>

