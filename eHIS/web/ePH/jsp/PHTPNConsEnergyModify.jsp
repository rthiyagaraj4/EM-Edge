<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>

<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.Connection,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %><!-- ADDED FOR ML-MMOH-CRF-1266-->

<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
31/01/2019      ML-MMOH-CRF-1266(IN068728)  PRATHYUSHA      TPN Regimen - Carbohydrate, Lipid, Protein to be Enterable
---------------------------------------------------------------------------------------------------------------
*/ %>

<HTML>
<HEAD>
   <!--  <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
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
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<!--     <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
 -->    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TPNConsEnergy.js"></SCRIPT>
	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <SCRIPT>
//    function lockKey() {
//        if(event.keyCode == 93)
//            alert("Welcome to eHIS");
//    } dt:18/9/09---For online help
    </SCRIPT>
</HEAD>

<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">

<form name="FrmTPNConsEnergy" id="FrmTPNConsEnergy">
<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;

	String gCode = request.getParameter( "gcode" )==null?"":request.getParameter( "gcode" ) ;//MODIFIED FOR ML-MMOH-CRF-1266
    String bean_id = "TPNConsEnergyBean" ;
    String bean_name = "ePH.TPNConsEnergyBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	String readOnly = "";
	String disp_mand="style='display:none'";
	//addede for ml-mmoh-crf-1266 start
	
	String gName="";
	String qvalue="1";
	String qunit="GM";
	String erelval="";
	String eunit="Kcal";
	ArrayList result=new ArrayList();
 	ArrayList result_1=new ArrayList();
 	ArrayList	const_generic_code_list	=new ArrayList();
 	HashMap EnergyDetails=new HashMap(); 
	 boolean micro_nut_enterable_yn  = false; // Added for ML-MMOH-CRF-1266     
     Connection connection = null;
     try {
    	 connection = ConnectionManager.getConnection(request);	     
	     micro_nut_enterable_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","MACRO_ENTERABLE_YN");
     }
     catch(Exception e) {
	    out.print("Exception @ Result JSP :"+e.toString());
	    e.printStackTrace();
     }
     finally{		
	  if(connection != null)
	   ConnectionManager.returnConnection(connection,request);
     } 
	 
	//addede for ml-mmoh-crf-1266 end
//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_TPN_ENERGY_FOR_CONST";
	String pkey_value			="";
	TPNConsEnergyBean bean = (TPNConsEnergyBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	
 	
	if ( mode == null || mode.equals("") )
        return ;
	//addede for ml-mmoh-crf-1266 start
	
    	if (micro_nut_enterable_yn){
    		System.out.println("mode"+mode+""+CommonRepository.getCommonKeyValue("MODE_INSERT"));
    		HashMap sqlMap = new HashMap();
    	 	sqlMap.put( "sqlData", "SELECT CONST_GROUP_CODE, CONST_GROUP_NAME FROM PH_TPN_CONST_GRP_LANG_VW PH_TPN_CONSTITUENT_GROUP WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY DISP_SRL_NO");

    	 	HashMap funcMap = new HashMap();
    	 	
    	 

    	 	ArrayList displayFields = new ArrayList();
    	 	

    	 	displayFields.add( "CONST_GROUP_CODE" );
    	 	displayFields.add( "CONST_GROUP_NAME" );


    	 	ArrayList chkFields = new ArrayList();
    	 	chkFields.add(locale);
    	 	
    	 	// Adding function related array list into the HashMap
    	 	funcMap.put( "displayFields", displayFields );
    	 	funcMap.put( "chkFields", chkFields );

    	 	//Calling the Result from Common Adaptor as a arraylist.
    	 	 result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
    	 	
    	 	  	const_generic_code_list	=bean.getGenricCode(locale);
    	 	  	System.out.println("const_generic_code_list"+const_generic_code_list);
    	
    }//ADDED FOR ML-MMOH-CRF-1266 END
	else{
    	if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
    		  return ;
	}
      

    
    	//IF CONDTION ADDED FOR ML-MMOH-CRF-1266 START
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{	 EnergyDetails=bean.getConsEnergyDetails(gCode,locale);
	//modified for ml-mmoh-crf-1266 start
	gName=(String)EnergyDetails.get("GNAME");}
	else{
		gName="";
	}
	 
	//modified for ml-mmoh-crf-1266 end
	/*-------------------------code added for showing audit log---------------------------*/
	//code for adding pk_values
	ArrayList Pk_values    =new ArrayList();
	if (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){//IF CONDTION ADDED FOR ML-MMOH-CRF-1266
			Pk_values.add( gCode.trim());      

	String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
	if(display_audit_log_button_yn.equals("Y")){
		audit_log_visible= "visibility:visible";
		pkey_value       = (String)log_bean.getpk_value();
	}
	else{
		audit_log_visible= "visibility:hidden";
		pkey_value="";
		log_bean.clear();
	}
	}
	/*--------------------------------------ends here---------------------------------------*/
if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){//IF CONDTION ADDED FOR ML-MMOH-CRF-1266
	if (  EnergyDetails.containsKey("QVALUE") )
	{
		qvalue=(String)EnergyDetails.get("QVALUE");
		qunit=(String)EnergyDetails.get("QUNIT");
		erelval=(String)EnergyDetails.get("ENERGYRELVAL");
		eunit=(String)EnergyDetails.get("ENERGYUNIT");
	}
	else
	{
		out.println("Error Occured"+gName);
	}
}
	if(micro_nut_enterable_yn){//ADDED FOR ML-MMOH-CRF-1266
		readOnly="";
		disp_mand="style='display:inline'";
	}
	else{	
		if(gCode.equals("CHO")){
		readOnly="";
		disp_mand="style='display:inline'";
	}
	else if(gCode.equals("LIPID")){
		readOnly="";
		disp_mand="style='display:inline'";
	}
	else if(gCode.equals("PROTEIN")){
		readOnly="";
		disp_mand="style='display:inline'";
	}
	else 
		readOnly="readonly";
	}
	
	%>
<span style="position:absolute;top:80px;left:130px">
<TABLE align="center" cellspacing="0" cellpadding="0" >
<tr>
<td class="label" >&nbsp;</td>
<td align='right'>
<INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">
</td>
</tr>
<!-- ADDED FOR ML-MMOH-CRF-1266 -->
 <%if ( micro_nut_enterable_yn ){ %>
<tr>
<td  class="label">
<fmt:message key="ePH.ConstituentGroup.label" bundle="${ph_labels}"/>
</td>
<td  class="label">
<select align="left" name="cons_group" id="cons_group" colspan="2" DISABLED>&nbsp;&nbsp;&nbsp;&nbsp;
<%	if( (result.size()>=3) && ( !(((String) result.get(0)).equals("0")))){		
     for(int i=2;i<result.size();i++){
    	 
	    result_1=(ArrayList)result.get(i);
	    if(result_1.get(0).equals("MN")){
%>	
	  
	   <option value="<%=result_1.get(0)%>" ><%=result_1.get(1)%></option>  
				 
<%  } } 
   }
%>
</select>
</td>
</tr>

<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<%} %>
<!-- ADDED FOR ML-MMOH-CRF-1266 END -->
<tr>
<td  class="label" width="35%">
<fmt:message key="ePH.ConstituentCode.label" bundle="${ph_labels}"/>

		
</td>
  <%if ( micro_nut_enterable_yn && mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){ %>
<td align=left class="label" >

	<select name="gCode" id="gCode" onchange="selectName(this)" >
		<option value="" >----Select----</option> 
		
		<%for(int i=0;i<const_generic_code_list.size();i+=2){%>
		<option value="<%=const_generic_code_list.get(i)%>" ><%=const_generic_code_list.get(i)%></option>  
		<% }  %>
	</select>
	
</td>
<%}else{ %>
<td align=left >&nbsp;&nbsp;<input type="text" name="gCode" id="gCode" maxLength=2 size=5 readonly disabled value="<%=gCode%>" >
</td>
<%} %>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td  class="label">
	
<fmt:message key="Common.ConstituentName.label" bundle="${common_labels}"/>
</td>
<td align=left >&nbsp;&nbsp;<input type="text" name="gName" id="gName" maxLength=30 size=35  value="<%=gName%>" tabIndex=1><img src="../../eCommon/images/mandatory.gif">
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td  class="label">

<fmt:message key="ePH.QuantityValue.label" bundle="${ph_labels}"/>
</td>
<td align=left>&nbsp;&nbsp;<input type="text" name="qvalue" id="qvalue" maxLength=3 size=5 readonly  disabled value="<%=qvalue%>">
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td  class="label">
	
<fmt:message key="ePH.QuantityUnit.label" bundle="${ph_labels}"/>
</td>
<td align=left>&nbsp;&nbsp;<input type="text" name="qunit" id="qunit" maxLength=3 size=5 readonly disabled value="<%=qunit%>">
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td  class="label">

<fmt:message key="ePH.EnergyValue.label" bundle="${ph_labels}"/>
</td>
<td align=left  >&nbsp;&nbsp;<input type="text" name="erelval" id="erelval" maxLength=4 size=5 <%=readOnly%> value="<%=erelval%>" onKeyPress='return allowValidNumber(this,event,3,2);' onblur='validateEnergy(this);'>&nbsp;<img src="../../eCommon/images/mandatory.gif" <%=disp_mand%>>
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td  class="label">
<fmt:message key="ePH.EnergyUnit.label" bundle="${ph_labels}"/></td>
<td align=left >&nbsp;&nbsp;<input type="text" name="eunit" id="eunit" maxLength=3 size=5 readonly disabled value="<%=eunit%>">

</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
</TABLE>
</span>
<%if ( micro_nut_enterable_yn && mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){ %>
<%for(int i=0;i<const_generic_code_list.size();i+=2){%>
		<input type="hidden" id="<%=const_generic_code_list.get(i)%>"  value="<%=const_generic_code_list.get(i+1)%>"> 
		<% }  }%>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
<script>document.getElementById("gName").focus();</script>
</html>

