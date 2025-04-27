<!DOCTYPE html>
 <!--This file is saved on 25/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<title>Compatible Fluids</title>
<head>
	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugMaster.js"></script>
	<script language="JavaScript" src="../js/DrugMasterDetail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >
<%
    Connection con			= null;//added for ml-mmoh-crf-1223
	try{
	String bean_id				=	"DrugMasterBean" ;
	String bean_name			=	"ePH.DrugMasterBean";
	
	String fluid		=	(String)request.getParameter("fluid");
	String drug_code	=	(String)request.getParameter("drug_code");
	DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	//Connection con			= null;//added for ml-mmoh-crf-1223
	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-1223
	boolean default_comp_fluid_falg = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DEFAULT_COMP_FLUID_INF_OVER");// Added for ML-MMOH-CRF-1223
		 ArrayList dflt_fluids = new ArrayList();
		 dflt_fluids = bean.loadFluids();
	     String drug_code_dflt=" ";
	     String drug_desc_dflt=" ";
		 String status="";
		 String dflt ="";
		 String db_action ="";
		 String disabled="disabled";
		 String chk="";
		 String chk1="";
		 String df_fl="N";
		 String stat="D";
		 String db_ac="I";
		 String comp_fld_code = "";
		 String	deflt_infuse_over_value_hrs			=	"";//Added for ML-MMOH-CRF-1223
		 String	deflt_infuse_over_value_mins		=  "";//Added for ML-MMOH-CRF-1223
		 String deflt_infuse_over_value             =   "";//Added for ML-MMOH-CRF-1223

		 Boolean data=false;
		 ArrayList iv_char=new ArrayList();
		 ArrayList Comp_Fluids=new ArrayList();
		 ArrayList Comp_Fluids1=new ArrayList();
		 Comp_Fluids=bean.getCompFluids();
		 if(Comp_Fluids.size()!=0){
			 data=true;
			Comp_Fluids=bean.getCompFluids();
		 }
		 else
			Comp_Fluids=bean.getComps(drug_code);
		 iv_char=bean.getIVChar();

		 if (fluid == null)
			dflt=((String)iv_char.get(6)).trim();//trim added for ML-MMOH-CRF-1223
		 else
			dflt =fluid.trim();//trim added for ML-MMOH-CRF-1223
 %>
<form name="compFluidsForm" id="compFluidsForm">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" scrolling="auto">
	<th></th>
	<th align="center"><fmt:message key="Common.FluidName.label" bundle="${common_labels}"/></th>
	<th align="center"><fmt:message key="ePH.DefaultFluid.label" bundle="${ph_labels}"/></th>
<%
	    if(default_comp_fluid_falg){
%>
	<th align="center"><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.TimeHH:MM.label" bundle="${ph_labels}"/></th><!-- Added for ML-MM<OH-CRF-1223 -->
<%
        }
%>
	<th align="center"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
	<% int count=0;
		{
			for(int i=0,j=0;i<dflt_fluids.size();i+=2,j+=5){ //changed  j value from 4 to 5 for ML-MMOH-CRF-1223
			    disabled="disabled";
				chk="";
				chk1="";
				df_fl="N";
				stat="D";
				db_ac="I";
				comp_fld_code = "";
				count++;
				drug_code_dflt = (String)dflt_fluids.get(i);
				drug_desc_dflt=(String)dflt_fluids.get(i+1);
//				comp_fld_code  = (String)Comp_Fluids.get(j);
//				if(drug_code_dflt.equals(comp_fld_code)){
				int indexFld = 0;
				indexFld = Comp_Fluids.indexOf(dflt_fluids.get(i));
				if(indexFld != -1){
					stat=(String)Comp_Fluids.get(indexFld+2);
					db_ac=(String)Comp_Fluids.get(indexFld+3);
				}
				
				//Adding start for ML-MMOH-CRF-1223
					deflt_infuse_over_value =(String)Comp_Fluids.get(j+4);
				//Adding end for ML-MMOH-CRF-1223
				if(stat.equals("E"))
					chk1="checked";
				if(dflt==""||dflt.equals(""))
					disabled="";
				else{
				if(dflt.equals(drug_code_dflt)||(fluid.equals(drug_code_dflt))){
					 df_fl="Y";
					 disabled="";
					 chk="checked";
				 }
				 else{
					disabled="disabled";
					 chk="";
				 }
				 }
			%>
							<tr>
							<td width="0%"><input type="hidden" name="dflt_fld<%=count%>" id="dflt_fld<%=count%>" value="<%=drug_code_dflt%>"></td>
							 <td width="80%" class="label">
							  <%=drug_desc_dflt%>
                             </td>
							 <td>
							  <input type="checkbox" name="e_status<%=count%>" id="e_status<%=count%>" <%=disabled%> <%=chk%> onclick="dffluid('<%=dflt_fluids.size()/2%>','<%=count%>')">
							 </td>
                     <!-- Addign start for ML-MMOH-CRF-1223 -->
<%  
	                         if(default_comp_fluid_falg){
%>
								<td width="20%" class="label" ><input type="text" size="3" name="deflt_infuse_over_value_hrs<%=count%>" id="deflt_infuse_over_value_hrs<%=count%>" value="<%=deflt_infuse_over_value_hrs%>" onBlur="CheckForSpecCharsonBlur(this); validateDefaultInfuseOver(document.compFluidsForm,eval('document.compFluidsForm.deflt_infuse_over_value_mins<%=count%>'),this,'<%=count%>');" maxlength="6">&nbsp;: <input type="text" size="3" name="deflt_infuse_over_value_mins<%=count%>" id="deflt_infuse_over_value_mins<%=count%>" value="<%=deflt_infuse_over_value_mins%>"   onBlur="CheckForSpecCharsonBlur(this); validateDefaultInfuseOver(document.compFluidsForm,this,eval('document.compFluidsForm.deflt_infuse_over_value_hrs<%=count%>'),'<%=count%>');"maxlength="6">
								&nbsp;

								<input type="hidden" name="deflt_infuse_over_value<%=count%>" id="deflt_infuse_over_value<%=count%>" value="<%=deflt_infuse_over_value%>">

								<script> 
								                                                
								getHrsMinStrInfuseOver(document.compFluidsForm,eval('document.compFluidsForm.deflt_infuse_over_value<%=count%>').value,'<%=count%>');
								validateDefaultInfuseOver(document.compFluidsForm,eval('document.compFluidsForm.deflt_infuse_over_value_mins<%=count%>'),eval('document.compFluidsForm.deflt_infuse_over_value_hrs<%=count%>'),'<%=count%>');
								</script>
<%
                               }else{
%>
                          <input type="hidden" name="deflt_infuse_over_value<%=count%>" id="deflt_infuse_over_value<%=count%>" value="">
<%
								}
%>
					<!-- Addign end for ML-MMOH-CRF-1223 -->
							</td>
							 <td>
							  <input type="checkbox" name="e_stats<%=count%>" id="e_stats<%=count%>" <%=chk1%> value="<%=stat%>" onclick="assignValue2(this)" >
							  <input type="hidden" name="db_act<%=count%>" id="db_act<%=count%>" value="<%=db_ac%>">
							  <input type="hidden" name="df_fld<%=count%>" id="df_fld<%=count%>" value="<%=df_fl%>">
							 </td>
							</tr>
						<%	}
		}
	%>
	</table>
	<table cellpadding="0" cellspacing="0" width="100%" align="center">
	<tr>
		<td width="90%">&nbsp;</td>
		<td><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="clsewindw('<%=dflt_fluids.size()/2%>','<%=bean_id%>','<%=bean_name%>')"></td>
	</tr>
 </table>
 <input type="hidden" name="dflt_fluid" id="dflt_fluid" value="<%=dflt%>">
 <input type="hidden" name="eff_stat" id="eff_stat" value="">
 <input type="hidden" name="db_action_comp" id="db_action_comp" value="<%=db_action%>">

<%
}catch(Exception e){
		e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-1223 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-1223 end
%>
</form>
</body>
</html>

