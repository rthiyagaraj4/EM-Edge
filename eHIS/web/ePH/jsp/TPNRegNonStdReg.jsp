<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/TPNNonStdRegimen.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	
	 <!-- <SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/TPNRegimen.js"></SCRIPT> --> 
</HEAD>
<%
    String mode = request.getParameter("mode");
	String facility_id  = (String) session.getValue("facility_id");
	String uom=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.KCAL.label","ph_labels");
	String order_id								= request.getParameter("order_id");
	if(order_id == null){order_id="";}
	String weight								= request.getParameter("weight");
	String height								= request.getParameter("height");
	String reg_code                             =request.getParameter("code");
	String patient_id							= request.getParameter("patient_id");
	String encounter_id						    = request.getParameter("encounter_id");
	String start_date							= request.getParameter("start_date");

	String priority							    = request.getParameter("priority");
	String location_code						= request.getParameter("location_code");
	String location_type					    = request.getParameter("location_type");
	String pract_id							    = request.getParameter("pract_id");
	String act_patient_class					= request.getParameter("act_patient_class");
	String problem_ind							= request.getParameter("problem_ind");
	//String order_type_flag						= request.getParameter("order_type_flag");
	//String iv_prep_yn							= request.getParameter("iv_prep_yn");
	float wt                                    =Float.parseFloat(weight);
	
	String params								= request.getQueryString();
	String chk_addmixture		="";
	String alert_practitioner_yn="";
	//String time_flag            ="";
	String regCode			="";
	String routeCode		="";
	String totvolume		="";
	String unitofvolume		="";
	//String infusedurn		="";
	String infusevalue		=""; 
	String ordertypecode	="";
	String consentreqd		="";
	String authreqd			="";
	String cosignreqd		="";
	String splappreqd		="";
	//String freqcode			="";
	String durnvalue	 	="";
	String action_type 		="";
	String action_msg 		="";
	String max_durn 		="";
	String end_date 		="";
	String infuse           ="";
	String fluidValuesStd   ="";
	String code="";
	String desc="";
	String order_start_date =""; // Added for  [IN:031523]
	String shortname = "";      // added for [IN:031523] 

    String bean_id	= "@TPNNonStandardRegimenBean"+patient_id+encounter_id;
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);

	String bean_id1	= "@TPNStandardRegimenBean"+patient_id+encounter_id;
	String bean_name1	 = "ePH.TPNStandardRegimenBean";
	

	TPNStandardRegimenBean bean1 = (TPNStandardRegimenBean)getBeanObject(bean_id1,bean_name1,request);
	//ArrayList freqlist=bean1.getFrequencies();
	bean1.clear();	 
	bean1.setLanguageId(locale);

	String bean_id2				= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name2			= "ePH.TPNRegimenBean";
	TPNRegimenBean bean2	= (TPNRegimenBean)getBeanObject(bean_id2,bean_name2,request) ;
	bean2.setLanguageId(locale);

	bean.clear();
	bean.setLanguageId(locale);

	ArrayList regimenDetails			=bean.getRegimenDetails();

	if(regimenDetails.size()!=0 && regimenDetails!=null){		
	 regCode			=(String)regimenDetails.get(0);
	 routeCode		=(String)regimenDetails.get(1);
	 totvolume		=(String)regimenDetails.get(2);
	 if(totvolume == null){totvolume="";}
	 if(!weight.equals("") && !fluidValuesStd.equals("")){
		totvolume=new Float(Math.ceil(Float.parseFloat(weight)*Float.parseFloat(fluidValuesStd))).intValue()+"";
	    } 
	 unitofvolume		=(String)regimenDetails.get(4);
	 //infusedurn		=(String)regimenDetails.get(6);
	 infusevalue		=(String)regimenDetails.get(7);
	 ordertypecode	=(String)regimenDetails.get(8);
	 consentreqd		=(String)regimenDetails.get(9);
	 authreqd			=(String)regimenDetails.get(10);
	 cosignreqd		=(String)regimenDetails.get(11);
	 splappreqd		=(String)regimenDetails.get(12);
	 //freqcode			=(String)regimenDetails.get(13);
	 durnvalue	 	=(String)regimenDetails.get(14);
	 action_type 		=(String)regimenDetails.get(15);
	 action_msg 		=(String)regimenDetails.get(16);
	 max_durn 		=(String)regimenDetails.get(17);
	 end_date 		=(String)regimenDetails.get(18);
	}
 	//String shortname							=	bean.getRegimenName(start_date,reg_code);
	//ArrayList regmnDtls						    =   bean.getRegimenDetails();
    String regimen_code                         ="";
	String ord_regmn_ind                        ="";
	String max_weight                           ="";
	String min_weight                           ="";
	String disabled                             ="";
	String checked                              ="";
	totvolume                            =""; 
	unitofvolume                         ="";
	fluidValuesStd                              =  null;
	ArrayList fluidReq			                = new ArrayList();
	
	//ArrayList consResults						=	bean.getTPNGroups(patient_id,regimen_code);
	ArrayList uom_data                          =   bean.getUOMData();
	//ML-MMOH-CRF-1290 start
	boolean tpn_tab_reg = false;
	Connection	con=null;
	try{
		con	= ConnectionManager.getConnection(request);
		tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		con.close();
	}
	//ML-MMOH-CRF-1290 end
	if(uom_data.size()==0)
	{
		//out.println("<script>alert(getMessage('PH_UOM_TPN_CONST_NOT_SETUP'));</script>");
		out.println("<script>alert(getMessage('PH_UOM_TPN_CONST_NOT_SETUP','PH'));</script>");
	}
	else 
	{
    ord_regmn_ind                               =(String)uom_data.get(6);
	max_weight                                  =(String)uom_data.get(2);
	min_weight                                  =(String)uom_data.get(3);
	String pediatric_regimen_yn                 ="";
	
	float max_weight_uom=0.0f;
	float min_weight_uom=0.0f;
	if(max_weight!=null)
		max_weight_uom=Float.parseFloat(max_weight);
	if(min_weight!=null)
		min_weight_uom=Float.parseFloat(min_weight);
	if(ord_regmn_ind.equals("W") || ord_regmn_ind.equals("B") )
	{
		if((wt <= max_weight_uom) )
		{
			disabled="disabled";
			checked="checked";
			pediatric_regimen_yn="Y";
		}
		else if((wt > max_weight_uom) && (wt <= min_weight_uom))
		{
			disabled="";
			checked="checked";
			pediatric_regimen_yn="Y";
	    }
		else if(wt > min_weight_uom)
		{
          disabled="disabled";
	      checked="";
		  pediatric_regimen_yn="N";
		 
		}
	}
	if(!locale.equals("en")){ // added for [IN:031523] Start
	     order_start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
 	     shortname							=	bean.getRegimenName(order_start_date,reg_code,patient_id);
	}else{
         shortname							=	bean.getRegimenName(start_date,reg_code,patient_id);
	}  // added for [IN:031523] End
	 ArrayList regmnDtls						    =   bean.getRegimenDetails();
	 if(regmnDtls.size()==0)
		 out.println("<script>alert(getMessage('PH_TPN_CONST_LIMIT_NOT_SETUP','PH'));</script>");
		// out.println("<script>alert('PH_TPN_CONST_LIMIT_NOT_SETUP');</script>");
	else
	{
		if(reg_code==null)
			regimen_code   =   (String)regmnDtls.get(0);
		else
			regimen_code = reg_code;

		fluidReq = bean.getFluidRequired(patient_id);
	  
		if(fluidReq != null) { fluidValuesStd = (String)fluidReq.get(3);}
     
		totvolume		=(String)regmnDtls.get(2);
		unitofvolume		=(String)regmnDtls.get(4);
		if(totvolume == null) { totvolume=""; }
		if(!weight.equals("") && !fluidValuesStd.equals(""))
		{
			totvolume=new Float(Math.ceil(Float.parseFloat(weight)*Float.parseFloat(fluidValuesStd))).intValue()+"";
	    }
		ArrayList consResults  =	bean.getTPNGroups(patient_id,regimen_code);

	// String params1=params;
     
	 
		if (shortname==null || shortname.equals("")){
			out.println("<script>error()</script>");
		}
		
		String visible_flag="";
	
		if(mode.equals("amend")){
			HashMap OrderDetails=bean.getOrderDetails1(order_id);
			
			shortname = (String)OrderDetails.get("CATALOG_DESC");
			
			visible_flag="visibility:hidden";
			totvolume=request.getParameter("volm");
			if(totvolume==null || totvolume.equals(""))
				totvolume = bean.getVolume(order_id);
		}
		params=params+"&volm="+totvolume;
     
		String ph_bean_name	= "ePH.PrescriptionBean_1";
		String ph_bean_id	= "@PrescriptionBean_1"+patient_id+encounter_id;

		PrescriptionBean_1 phbean = (PrescriptionBean_1)getBeanObject(ph_bean_id, ph_bean_name,request);
		bean.setPresRemarks(phbean.getPresRemarks());
		String cho		=bean2.getCabohydrateOrderQuantity();
		String protein	=bean2.getProteinOrderQuantity();
		String lipid	=bean2.getLipidOrderQuantity();
		ArrayList MNResults=bean.getTPNGenerics("MN",patient_id,regimen_code);
		ArrayList MNEnergies = bean.getMNEnergies();

		String carbo_ener = "";
		String lipid_ener = "";
		String prot_ener  = "";
		if(MNEnergies.size()>0){
			 carbo_ener = (String)MNEnergies.get(1);
			 lipid_ener = (String)MNEnergies.get(3);
			 prot_ener  = (String)MNEnergies.get(5);
		}
		//String MNdesc=bean.getDesc("MN");
		code="";
		String std="";
		String dflt="";
		String AbOrWt="";
		String cho_energy="";
		String pro_energy="";
		String li_energy="";
		String tot_energy="";
		String tot_chi_li="";
		String NPC="";
		//int wt=Integer.parseInt(weight);
		int i=0;
		HashMap OrderDetails=new HashMap();
		OrderDetails=bean.getOrderDetails2(order_id);
		if(MNResults.size() != 0)
		{
			for(i=0;i<MNResults.size();i+=11)
			{
				code		=(String)MNResults.get(i);
				AbOrWt      =(String)MNResults.get(i+3); 
				std		    =(String)MNResults.get(i+6);
				dflt		=(String)MNResults.get(i+7);
				if(OrderDetails.containsKey(code))
				{
//					String def_std=((Float.parseFloat((String)OrderDetails.get(code)))/ wt) + "";
					String def_std=((Float.parseFloat((String)OrderDetails.get(code)))) + "";
					std=def_std;
				}
				String relvalue="";
				String N2="";
				if (code.equals("CHO"))
				{
					if (!cho.equals(""))
						relvalue=cho;	
					else 
					{
						if (dflt.equals("Y"))
						{
							if(AbOrWt.equals("A"))
								relvalue=std;
							else
								//relvalue=Math.round((Float.parseFloat(std) * wt)) + "";
								relvalue=Math.round((Float.parseFloat(std) / wt)) + "";
						}
						else
							relvalue="";
					}
					cho_energy = Float.parseFloat(relvalue)*Float.parseFloat(carbo_ener)+"";
				}
				
				if (code.equals("PROTEIN"))
				{
					if (!protein.equals("")){
						relvalue=protein;	
					}
					else
					{
						if (dflt.equals("Y"))
						{
							if(AbOrWt.equals("A"))
								relvalue=std;
							else
								//relvalue=Math.round((Float.parseFloat(std) * wt)) + "";
								relvalue=Math.round((Float.parseFloat(std) / wt)) + "";
						}
						else
							relvalue="";	
					}
		
					N2=Float.parseFloat(relvalue)*(16.0/100.0)+"";
					pro_energy	 =Float.parseFloat(relvalue)*Float.parseFloat(prot_ener)+"";
				}
				if (code.equals("LIPID"))
				{
					if (!lipid.equals(""))
						relvalue=lipid;	
					else
					{
						if (dflt.equals("Y"))
							if(AbOrWt.equals("A"))
								relvalue=std;
							else
//								relvalue=Math.round((Float.parseFloat(std) * wt)) + "";
								relvalue=Math.round((Float.parseFloat(std) / wt)) + "";
						else
							relvalue="";	
					}
					li_energy = Float.parseFloat(relvalue)*Float.parseFloat(lipid_ener)+"";
				}
			
				if( !li_energy.equals("") && !cho_energy.equals("")&& !pro_energy.equals(""))
				{
					tot_energy	=((Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+(Float.parseFloat(pro_energy)))+"";
					tot_chi_li=(Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+"";
					if(!N2.equals(""))
					NPC=(Math.round((Float.parseFloat(tot_chi_li))/(Float.parseFloat(N2))))+"";
				}
			}
		}

		String lab_value="     NPC:N Ratio    "+NPC+" :1  &nbsp;  Total Energy:"+tot_energy+" "+CommonBean.checkForNull(bean.getUomDisplay(facility_id,uom.toUpperCase())) ;
		String code1="";
		String desc1="";
		String lnk="";
		HashMap record1;
	 
		if(mode.equals("undefined"))
		{
			record1=new HashMap(); 
			record1=bean2.ChkAdMixture();
			chk_addmixture=(String)record1.get("IV_ADMIXTURE_APPL_YN");
			//alert_practitioner_yn=(String)record1.get("ALERT_PRACTITIONER_YN");
			//if(chk_addmixture.equals("Y"))
			//{		  
			   //time_flag=(String)record1.get("time_flag");
			//}
		}
	
%>
<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
	<FORM name="TpnNonStandardRegimen" id="TpnNonStandardRegimen">
	<table width="100%">
	<tr nowrap>
	
<%          if(!mode.equals("amend")) {
				if(ord_regmn_ind.equals("W") || ord_regmn_ind.equals("B") ) { %>
	 <Td   class="label" align="left" ><fmt:message key="ePH.PediatricRegimen.label" bundle="${ph_labels}"/>
		&nbsp;&nbsp;<INPUT TYPE="checkbox"  name="paed_regmn" id="paed_regmn" id="paed_regmn"  onClick="" <%=checked%> <%=disabled%>> </TD>
<%				}
			}
%>
		<td class="label" height="23px" width="30%" nowrap>
		<fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/>&nbsp;<input type="text" name="stdregimen" id="stdregimen" maxlength=30  size=30 value="<%=shortname%>" readonly> <INPUT TYPE="button" CLASS="button" id="nonstdbtn" VALUE="?"
			onfocus=""
			onClick="searchNonStandardRegimen(stdregimen)" STYLE="<%=visible_flag%>">&nbsp;<img src="../../eCommon/images/mandatory.gif" STYLE="<%=visible_flag%>">
	 </td>
	    <td class="label" nowrap><label id="npc_la" name="npc_la" STYLE="font-weight:bold;" align="center"><%=lab_value %></label>
		</td>
		<Td   class="label" align="left" nowrap><fmt:message key="Common.volume.label" bundle="${common_labels}"/>
			   <input type=text onKeyPress="return(ChkNumberInput(this,event,0));"   onchange="CheckNum(this);CheckPositiveNumber(this);reload('<%=mode%>')"  class="number" name="volume" maxlength=5 size=5 value="<%=totvolume%>" >&nbsp;<label id='volumeunit' name='volumeunit'><B><%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,unitofvolume))%></B><img src="../../eCommon/images/mandatory.gif"></TD>
		</tr>
		</table>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" id="tabs" name="tabs" id="tabs">
	<tr>
		<%
		for (int t=0;t<consResults.size();t+=3)
		{		
			code1=(String)consResults.get(t);
			desc1=(String)consResults.get(t+1);
			lnk = (String)consResults.get(t+2);
			if (lnk == "Y"){
		%>
				<Td class="hyperlink1" id='<%=code1%>'   name='<%=code1%>'  onClick="showDiv('<%=code1%>','parent.DetailFrame.document');colorTabs(this)"><%=desc1%> </td>

		<%	}else
			{
		%>		
				<Td id='<%=code1%>'   name='<%=code1%>' ><%=desc1%> </td>
		
		<%	}
		}
		%>
		<Td  class="hyperlink1" id="name1" name="name1" onClick="colorTabs(this);adminDetails('parent.DetailFrame.document','<%=params%>');"><fmt:message key="ePH.AdminDetails.label" bundle="${ph_labels}"/></td>
		</TR>
		
</TABLE>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="SQL_PH_TPN_NON_STD_REGIMEN_SELECT1AA" id="SQL_PH_TPN_NON_STD_REGIMEN_SELECT1AA" value="SELECT   TPN_REGIMEN_CODE CODE,   DFLT_TPN_ROUTE,   TOTAL_VOLUME,LONG_NAME DESCRIPTION,   b.QTY_UOM PRES_BASE_UNIT,   ITEM_CODE,   INFUSE_OVERDURN_TYPE,   INFUSE_OVER_VALUE,   B.ORDER_TYPE_CODE,   CONSENT_REQD_YN,   ORD_AUTH_REQD_YN,   ORD_COSIGN_REQD_YN,   ORD_SPL_APPR_REQD_YN,   FREQ_CODE,   DURN_VALUE,   DURN_TYPE,   CHK_FOR_MAX_DURN_ACTION,   PROMPT_MSG,   MAX_DURN_VALUE FROM     PH_TPN_REGIMEN A,  OR_ORDER_CATALOG B,   OR_ORDER_CATALOG_BY_PTCL C WHERE    STANDARD_REGIMEN_YN='N' AND   A.TPN_REGIMEN_CODE=B.ORDER_CATALOG_CODE AND   B.ORDER_CATALOG_CODE=C.ORDER_CATALOG_CODE   AND A.PEAD_TPN_REGIMEN_YN LIKE (NVL(?,A.PEAD_TPN_REGIMEN_YN)) and  exists (select 'Y' from PH_TPN_CONSTITUENT_LIMIT where TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE and age_group_code in (select age_group_code from am_age_group where nvl(gender,(select sex from mp_patient where patient_id LIKE UPPER(?)))=(select sex from mp_patient where patient_id LIKE UPPER(?))  and trunc(sysdate)-(select trunc(date_of_birth) from mp_patient where patient_id LIKE UPPER(?)) between  decode(age_unit,'Y',365,'M',30,1)*min_age and decode(age_unit,'Y',365,'M',30,1)*max_age and eff_status='E' )) AND TPN_REGIMEN_CODE LIKE (?) AND LONG_NAME LIKE (?) ">
	
	
	<input type="hidden" name="start_date" id="start_date" value="<%=start_date%>">

<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="patient_height" id="patient_height" value="<%=height%>"> 
<input type="hidden" name="patient_weight" id="patient_weight" value="<%=weight%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="stdregimen_hidden" id="stdregimen_hidden" value="">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id2%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name2%>">
<input type="hidden" name="QueryString" id="QueryString" value="<%=request.getQueryString()%>">

<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>"> 
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
<input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=act_patient_class%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="problem_ind" id="problem_ind" value="<%=problem_ind%>">
<input type="hidden" name="regimen_code" id="regimen_code" value="<%=regimen_code%>">
<input type="hidden" name="params" id="params" value="<%=params%>">
<input type="hidden" name="ped_regmn" id="ped_regmn" value="<%=pediatric_regimen_yn%>">
<input type="hidden" name="volumeunit1" id="volumeunit1" value="<%=unitofvolume%>">


<input type="hidden" name="infroute1" id="infroute1" value="">
<input type="hidden" name="infusevalue1" id="infusevalue1" value="">
<input type="hidden" name="durnvalue1" id="durnvalue1" value="">
<input type="hidden" name="startdate1" id="startdate1" value="">
<input type="hidden" name="end_date1" id="end_date1" value="">
<INPUT TYPE="hidden" name="tpn_tab_reg" id="tpn_tab_reg" value="<%=tpn_tab_reg%>"><!-- added for ml-mmoh-crf-1290 -->
	
</FORM>
	
	<% 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(bean_id1,bean1,request);
		putObjectInBean(bean_id2,bean2,request);
		putObjectInBean(ph_bean_id,phbean,request);
	%>
<script>
   // callresult('<%=regimen_code%>');
	//alert('<%=params%>');
	parent.DetailFrame.location.href ="../../ePH/jsp/TPNRegNonStdRegDetails.jsp?<%=params%>"; 
  	parent.ButtonFrame.document.TpnButtons.Cancel.disabled=true;
	parent.ButtonFrame.document.TpnButtons.Release.disabled=true;
		
</script>
<%	}
	}
%>

