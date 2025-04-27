<!DOCTYPE html>
<%-- saved on 02/05/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>  

<HTML>
<HEAD>
   <!--  <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
   <%
request.setCharacterEncoding("UTF-8");
 //Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
   request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
   response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
   response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
   //ends
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TPNConsGeneric.js"></SCRIPT
 	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<body onMouseDown="" onKeyDown="lockKey()">

<form name="FrmTPNConsGeneric" id="FrmTPNConsGeneric">
<%
     String mode      = request.getParameter( "mode" ) ;
     String bean_id   = "TPNConsGenericBean" ;
     String bean_name = "ePH.TPNConsGenericBean";
     
     String classvalue			= "";
     
     if ( mode == null || mode.equals("") )
          return ;
     if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
          return ;
     
     TPNConsGenericBean bean = (TPNConsGenericBean)getBeanObject( bean_id,bean_name,request) ;
      
     bean.setLanguageId(locale);
 	
 	HashMap sqlMap = new HashMap();
 	sqlMap.put( "sqlData", "SELECT CONST_GROUP_CODE, CONST_GROUP_NAME, DISP_SRL_NO FROM PH_TPN_CONST_GRP_LANG_VW PH_TPN_CONSTITUENT_GROUP WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY DISP_SRL_NO");

 	HashMap funcMap = new HashMap();
 	
 	String srlNo = bean.getSrlNo("", "");

 	ArrayList displayFields = new ArrayList();
 	ArrayList result=new ArrayList();
 	ArrayList result_1=new ArrayList();

 	displayFields.add( "CONST_GROUP_CODE" );
 	displayFields.add( "CONST_GROUP_NAME" );


 	ArrayList chkFields = new ArrayList();
 	chkFields.add(locale);
 	
 	// Adding function related array list into the HashMap
 	funcMap.put( "displayFields", displayFields );
 	funcMap.put( "chkFields", chkFields );

 	//Calling the Result from Common Adaptor as a arraylist.
 	 result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

%>
<span style="position:absolute;top:100;left:80">
<TABLE align="center" cellspacing="0" cellpadding="0" border="0">
<tr>
<td align=right class="label">
	<fmt:message key="ePH.ConstituentGenericCode.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="gCode" id="gCode" maxLength=8 size=8 value="" onblur="startWithAlphabets(this);" onkeypress=" return allowAlphaNumeric(event);" > <img src="../../eCommon/images/mandatory.gif"> <!-- startWithAlphabets(this) and allowAlphaNumeric(event) Added for ML-MMOH-CRF-1266 [IN:068728] -->
</td>

</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td align=right class="label" width="45%">
	<fmt:message key="ePH.ConstituentGenericName.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="gName" id="gName" maxLength=30 size=35  value="">
	<img src="../../eCommon/images/mandatory.gif">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td align=right class="label">
	<fmt:message key="ePH.DisplaySerialNo.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="srlno" id="srlno" maxLength=3 size=5 value="<%=srlNo%>" readonly >
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td align=right class="label">
<fmt:message key="ePH.ConstituentGroup.label" bundle="${ph_labels}"/>
</td>
<td align=right class="label">
<select align="left" name="cons_group" id="cons_group" colspan="2" onchange="getSrlNo();disableUomLevel(document.FrmTPNConsGeneric);">&nbsp;&nbsp;&nbsp;&nbsp;
<%	if( (result.size()>=3) && ( !(((String) result.get(0)).equals("0")))){		
     for(int i=2;i<result.size();i++){
	    result_1=(ArrayList)result.get(i);
%>	
	   <option value="<%=result_1.get(0)%>" ><%=result_1.get(1)%></option>  
				 
<%   } 
   }
%>
</select>
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td align=right class="label">
<fmt:message key="Common.Ordering.label" bundle="${common_labels}"/> <fmt:message key="Common.Unit.label" bundle="${common_labels}"/>
</td>
<td align=left class="label" colspan="2">
 <select name="dflt_ord_unit_ind" id="dflt_ord_unit_ind" >
	<option value="A" ><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/>         </option>
	<option value="W" ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>           </option>
 </select>
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td align=right class="label">
                       <fmt:message key="ePH.UOMLevel.label" bundle="${ph_labels}"/>
</td>
<td align=letf class="label">
 <select name="uom_level" id="uom_level" onChange="disableUomLevel(document.FrmTPNConsGeneric);getSrlNo();">  
				<option value="I" ><fmt:message key="Common.Individual.label" bundle="${common_labels}"/></option>
				<option value="G" ><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>  
</select>		
</td>
</tr>

<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td align='right' class="label" >
       <fmt:message key="ePH.SelectionofPreferredItemFluidApplicable.label" bundle="${ph_labels}"/>
    </td>
	<td align='left' colspan='2' ><input type="checkbox" name="itmfld_req_yn" id="itmfld_req_yn"  value="N" disabled></td>
	</tr>
	<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td align='right' class="label" >
       <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
    </td>
	<td align='left' colspan='2' ><input type="checkbox" name="enabled_yn" id="enabled_yn"  value="E" onclick='clickEnable(this)' checked></td>
	</tr>
	<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
</TABLE>
</span>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>

<script>document.getElementById("gCode").focus();disableUomLevel(document.FrmTPNConsGeneric);</script>
</html>

