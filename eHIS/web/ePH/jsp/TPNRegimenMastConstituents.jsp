<!DOCTYPE html>

 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<% /*
Date       		Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				 ?				 ?				    ?			    ?								   ?
29/01/2019		    IN068728		 Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %>
<%@page import="java.sql.Connection,webbeans.eCommon.ConnectionManager"%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eCommon.Common.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimenMast.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%!
public String roundTwoDigits(String a)
{
	try
	{
		String bb			= "";
		String last			= "";
		double final_value	= 0f;
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3){
					last = a.substring(a.indexOf(".")+3,a.indexOf(".")+4);	
					bb=a.substring(0,a.indexOf(".")+3);

					if(Integer.parseInt(last) >=5){
						final_value = Double.parseDouble(bb)+0.01;
						bb = final_value+"";
					}
				}else{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e){
			return a;
			
	}
}

%>

<BODY TOPMARGIN="0" onKeyDown="lockKey()" onMouseDown="CodeArrest()">

<%
	/* Mandatory checks start */
	String bean_id		= "TPNRegimenMastBean";
	String bean_name	= "ePH.TPNRegimenMastBean";
	/* Mandatory checks end */

	/* Initialize Function specific start */
	TPNRegimenMastBean bean	= (TPNRegimenMastBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList display_list	= bean.displayConsGroup();
	/* Initialize Function specific end */

	String single_emul	= request.getParameter("single_emul");
	String group_code	= "";
	String group_name	= "";
	String unit			= "";
	String unit_desc	= "";
	String code			= "";
	String desc			= "";
	String code_1		= "";
	String desc_1		= "";
	String code_2		= "";
	String desc_2		= "";
	String unit_1		= "";
	String unit_2		= "";
	String unit_desc1		= "";
	String unit_desc2		= "";
	String label_unit	= "";
	ArrayList legends	= null;
	String totval="";
	String label_double_emul = "";
	String temp_code = "";
	String recalval = "";
	float recalval1 = 0.0f;
	String test="";

	String lctSelect = "";
	String mctSelect = "";
	String lctmctSelect = "";
	String lipid_emulsion_type = "";
	String total_energy	 =  "";
	String npc_ratio	= "0";
	String temp_label_double_emul = "";//added for ml-mmoh-scf-1303

%>

<FORM name="TPNRegimenMastConsForm" id="TPNRegimenMastConsForm">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">

<%
     boolean micro_nut_enterable_yn  = false; // Added for ML-MMOH-CRF-1266 [IN:068728] - Start     
     Connection connection = null;
     try {
    	 connection = ConnectionManager.getConnection(request);	     
	     micro_nut_enterable_yn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","MACRO_ENTERABLE_YN");
     }
     catch(Exception e) {
	    out.print("Exception @ Result JSP :"+e.toString());
	    e.printStackTrace();
     }
     finally{		
	  if(connection != null)
	   ConnectionManager.returnConnection(connection,request);
     } // Added for ML-MMOH-CRF-1266 [IN:068728]  - End

	HashMap engval = bean.getEnergyValues();
	lipid_emulsion_type = bean.getLipidEmulsion();
		if(lipid_emulsion_type == null) lipid_emulsion_type = "";
	
	if(lipid_emulsion_type.equals("L")){
		lctSelect = "SELECTED";
		mctSelect = "";
		lctmctSelect = "";
	}else if(lipid_emulsion_type.equals("M")){
		mctSelect = "SELECTED";
		lctmctSelect = "";
		lctSelect = "";
	}else if(lipid_emulsion_type.equals("B")){
		lctmctSelect = "SELECTED";
		mctSelect = "";
		lctSelect = "";
	}
	
	for(int i=0; i<display_list.size(); i+=2) {
		group_code	= (String)display_list.get(i);
		group_name	= (String)display_list.get(i+1);

		legends		= bean.getLegends(group_code);

		if(legends.size() >=1 ) {
			
%>

	<TR>
		<TH COLSPAN="4"><%=group_name%></TH>
	</TR>

<%
		}

		if(group_code.equals("FL") || group_code.equals("MN")) {

		
			for(int j=0; j<legends.size(); j+=4){
				code = (String)legends.get(j);
				test = test + "~" +  code;
				
			}
			
			for(int j=0; j<legends.size(); j+=4) {
				recalval1 = 0f;
				code = (String)legends.get(j);
				desc = (String)legends.get(j+1);
				unit = (String)legends.get(j+2);
				unit_desc = (String)legends.get(j+3);
				
				if (i==0){
					totval = code;
					if( bean.getValue(code) != null && bean.getValue(code) != "")
					{
					recalval = bean.getValue(code);
					}
					label_double_emul = unit_desc;
					temp_label_double_emul=unit;//added for ml-mmoh-scf-1303
				}
				
%>

	<TR>

<%

				if(group_code.equals("MN") && single_emul.equals("N")) {
	               if(!bean.getValue(code).equals("")){
						label_unit = unit;
				   }
					else
						label_unit = "";
					temp_code = temp_code + code;
					
%>
<!-- this is for non single emulsion -->
		<TD CLASS="LABEL"><%=desc%></TD>
          <%-- <TD CLASS="LABEL"><LABEL ID="<%=code%>_label" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=bean.getValue(code)%></LABEL>&nbsp;<LABEL ID="<%=code%>_unit_label" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=label_unit%></LABEL> // commented for ML-MMOH-CRF-1266 [IN:068728] --%>
		<%if(micro_nut_enterable_yn){// Added for ML-MMOH-CRF-1266 [IN:068728] - Start %>
	   <TD CLASS="LABEL">&nbsp;<INPUT TYPE="text" ID="<%=code%>_label" SIZE="4" MAXLENGTH="6" CLASS="number" VALUE="<%=bean.getValue(code)%>" onblur =" return fluid_max(this,'<%=code%>','<%=test%>','<%=totval%>','<%=test%>');">&nbsp;<LABEL ID="<%=code%>_unit_label" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=label_unit%></LABEL>
	   <%}else{ %>
		<TD CLASS="LABEL"><LABEL ID="<%=code%>_label" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=bean.getValue(code)%></LABEL>&nbsp;<LABEL ID="<%=code%>_unit_label" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=label_unit%></LABEL>
	   <%} // Added for ML-MMOH-CRF-1266 [IN:068728] - End %>
			<INPUT TYPE="hidden" name="<%=code%>" id="<%=code%>" VALUE="<%=bean.getValue(code)%>"><INPUT TYPE="hidden" name="<%=code%>_unit" id="<%=code%>_unit" VALUE="<%=unit%>"><INPUT TYPE="hidden" name="<%=code%>_rel_value" id="<%=code%>_rel_value" VALUE="<%=engval.get(code)%>"></TD>

		<TD CLASS="LABEL" nowrap>
<%if(code.equals("LIPID")) {%>
		
<%}%>
			
		<INPUT TYPE="text" SIZE="4" MAXLENGTH="6" CLASS="number" name="<%=code%>_perc" id="<%=code%>_perc" VALUE="<%=bean.getPerc(code)%>"  onKeyPress="return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,2)); " onblur =" return percent_max(this,'<%=code%>','<%=test%>','<%=totval%>','<%=test%>');">&nbsp;%&nbsp;</TD>
		<TD CLASS="LABEL">
			<INPUT TYPE="text" SIZE="4" MAXLENGTH="6" CLASS="number" name="<%=code%>_vol" id="<%=code%>_vol" onKeyPress="return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,2)); " onBlur="defaultPerc('<%=code%>','<%=test%>','<%=totval%>');totalEnergy('<%=test%>');defaultFluidBalance('<%=code%>','<%=test%>');npcRatio('<%=test%>');"   VALUE="<%=bean.getVolume(code)%>" onBlur="Calc_Percentage(this, '<%=i%>','<%=totval%>','<%=test%>');">&nbsp;<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=label_double_emul%>
			<input type="hidden" value="<%=temp_label_double_emul%>" name="<%=code%>_actuom" /><!-- added for ML-MMOH-SCF-1303 -->
			</LABEL>
			
			</TD>
<%
				

				}
				else {
%>
        
		<TD CLASS="LABEL"><%=desc%></TD>
		<TD COLSPAN="2">&nbsp;&nbsp;
<%
	if(group_code.equals("FL")){%>
		<INPUT TYPE="text" MAXLENGTH="6" name="<%=code%>" id="<%=code%>" SIZE="4" CLASS="number" VALUE="<%=bean.getValue(code)%>" onBlur="enableLipidEmulsion(this); final_check(this,'<%=single_emul%>');" onKeyPress="return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,2));">	<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=unit_desc%></LABEL>
		<INPUT TYPE="hidden" name="<%=code%>_<%=group_code%>" id="<%=code%>_<%=group_code%>" VALUE="<%=group_code%>">
		<INPUT TYPE="hidden" name="<%=code%>_unit" id="<%=code%>_unit" VALUE="<%=unit%>"></td>
			<TD>&nbsp;&nbsp;
<%
	}
	else {%>
		
		<INPUT TYPE="text" MAXLENGTH="6" name="<%=code%>" id="<%=code%>" SIZE="4" CLASS="number" VALUE="<%=bean.getValue(code)%>" onBlur="enableLipidEmulsion(this); Calc_Percentage(this, '<%=i%>','<%=totval%>', '<%=test%>');totalEnergy('<%=test%>',2);npcRatio('<%=test%>',2);" onKeyPress="return allowValidNumber(this,event,6,2);  return(ChkNumberInput(this,event,2));">&nbsp;<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=unit_desc%></LABEL>
		<INPUT TYPE="hidden" name="<%=code%>_<%=group_code%>" id="<%=code%>_<%=group_code%>" VALUE="<%=group_code%>">
		<INPUT TYPE="hidden" name="<%=code%>_unit" id="<%=code%>_unit" VALUE="<%=unit%>"><INPUT TYPE="hidden" name="<%=code%>_rel_value" id="<%=code%>_rel_value" VALUE="<%=engval.get(code)%>"></td>
			<TD>&nbsp;&nbsp;
<%			if (recalval != "" && bean.getValue(code) != null && bean.getValue(code) != ""){
				recalval1 = (Float.parseFloat(bean.getValue(code)) * 100)/Float.parseFloat(recalval);
			}

%>
		<INPUT TYPE="text" MAXLENGTH="6" name="des_<%=code%>" id="des_<%=code%>" value="<%=roundTwoDigits(recalval1+"")%>"SIZE="4" CLASS="number" onBlur=" Calc_Value(this, '<%=code%>','<%=totval%>','<%=test%>');totalEnergy('<%=test%>',2);npcRatio('<%=test%>',2)" onKeyPress="return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,0));">
<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana">%W/V</LABEL>	

 </TD>
<%
		}
	}
%>

	</TR>

<%
			}

	if(group_code.equals("MN") ){
		
	total_energy = bean.getTtlEnrgy();
	     if(total_energy == null) total_energy = "";

	npc_ratio = bean.getNpcRatio();
	     if(npc_ratio == null) npc_ratio = "";

%>
	<TR>
		<TD CLASS="LABEL"><B><fmt:message key="ePH.TotalEnergy.label" bundle="${ph_labels}"/></B></TD>
		<TD  CLASS="LABEL">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<LABEL ID="total_energy" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=total_energy%></LABEL>&nbsp;
		<LABEL ID="total_energy_uom" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=bean.getEnergyUnit()%></LABEL><INPUT TYPE="hidden" name="ttl_energy" id="ttl_energy" VALUE="<%=total_energy%>"><INPUT TYPE="hidden" name="ttl_energy_uom" id="ttl_energy_uom" VALUE="<%=bean.getEnergyUnit()%>">
		<TD CLASS="LABEL" nowrap> 
			&nbsp;&nbsp;
			 <fmt:message key="ePH.Lipid-EmulsionType.label" bundle="${ph_labels}"/>			 
		&nbsp;&nbsp;</TD>
		<TD CLASS="LABEL">
				 <select name="lipid_emulsion_type" id="lipid_emulsion_type" disabled>	
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value="L" <%=lctSelect%>><fmt:message key="ePH.LCT.label" bundle="${ph_labels}"/></option>
			<option value="M" <%=mctSelect%>><fmt:message key="ePH.MCT.label" bundle="${ph_labels}"/></option>
			<option value="B" <%=lctmctSelect%>><fmt:message key="ePH.MixtureofMCTandLCT.label" bundle="${ph_labels}"/></option>
			</select> 
		 </TD>
	</TR>	
	
<TR height="2" colspan="4"><TD CLASS="LABEL"><LABEL ID="npc_nam" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><fmt:message key="ePH.NPC:NRatio.label" bundle="${ph_labels}"/></LABEL></TD>
	<TD CLASS="LABEL">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<LABEL ID="npc_ratio" STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=npc_ratio%>   :   1</LABEL><INPUT TYPE="hidden" name="npc_ratio_val" id="npc_ratio_val" VALUE="<%=npc_ratio%>"></TD><TD></TD><TD></TD></TR>		
	<TR height="3" ><TD CLASS="LABEL"></TD><TD></TD><TD></TD><TD></TD></TR>
<%
		}
	}
		else {
			for(int j=0; j<legends.size(); j+=8) {
%>

	<TR>

<%
				if(j+5 <= legends.size()) {
					code_1 = (String)legends.get(j);
					desc_1 = (String)legends.get(j+1);
					unit_1 = (String)legends.get(j+2);
					unit_desc1 = (String)legends.get(j+3);
					code_2 = (String)legends.get(j+4);
					desc_2 = (String)legends.get(j+5);
					unit_2 = (String)legends.get(j+6);
					unit_desc2 = (String)legends.get(j+7);
					
%>

		<TD CLASS="LABEL"><%=desc_1%></TD>
		<TD>&nbsp;&nbsp;
		
		<INPUT TYPE="text" name="<%=code_1%>" id="<%=code_1%>" SIZE="4" MAXLENGTH="5" CLASS="number" VALUE="<%=bean.getValue(code_1)%>" onBlur="validNumber(this)" onKeyPress="return(ChkNumberInput(this,event,2));">&nbsp;<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=unit_desc1%></LABEL><INPUT TYPE="hidden" name="<%=code_1%>_unit" id="<%=code_1%>_unit" VALUE="<%=unit_1%>"></TD>

		<TD CLASS="LABEL" ><%=desc_2%></TD>
		<TD>&nbsp;&nbsp;
		
		<INPUT TYPE="text" name="<%=code_2%>" id="<%=code_2%>" SIZE="4" MAXLENGTH="5" CLASS="number" VALUE="<%=bean.getValue(code_2)%>" onBlur="validNumber(this)" onKeyPress="return(ChkNumberInput(this,event,2));">&nbsp;<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=unit_desc2%></LABEL><INPUT TYPE="hidden" name="<%=code_2%>_unit" id="<%=code_2%>_unit" VALUE="<%=unit_2%>"></TD>

<%
				}
				else {
					code_1	= (String)legends.get(j);
					desc_1	= (String)legends.get(j+1);
					unit	= (String)legends.get(j+2);
					unit_desc = (String)legends.get(j+3);
%>

		<TD CLASS="LABEL"><%=desc_1%></TD>
		<td colspan="3">&nbsp;&nbsp;
		
		<INPUT TYPE="text" name="<%=code_1%>" id="<%=code_1%>" SIZE="4" MAXLENGTH="5" VALUE="<%=bean.getValue(code_1)%>" CLASS="number" onBlur="validNumber(this)" onKeyPress="return(ChkNumberInput(this,event,2));">&nbsp;<LABEL STYLE="font-size:9;font-weight:bold;color:navy;font-family:verdana"><%=unit_desc%></LABEL><INPUT TYPE="hidden" name="<%=code_1%>_unit" id="<%=code_1%>_unit" VALUE="<%=unit%>"></td>
<%
				}
%>

	</TR>

<%
			}
		}
	}
%>

	</TABLE>

	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<input type="hidden" name="all_fields" id="all_fields" value="<%=test%>">
	<input type="hidden" name="micro_nut_enterable_yn" id="micro_nut_enterable_yn" value="<%=micro_nut_enterable_yn%>"> <!-- Added for ML-MMOH-CRF-1266 [IN:068728] -->
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

