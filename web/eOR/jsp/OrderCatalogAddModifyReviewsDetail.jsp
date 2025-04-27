<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------
12/07/2014	  IN048467		Karthi L										To have an indicator to skip the authorization process if the priority for that order is urgent.											
12/9/2014	IN051070		Karthi L										Skip Authorization based on priority" enabled even if Authorization Required is not checked				
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 


<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--  -->
<body STYLE="overflow-y:scroll" onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<form name='detailUpperForm' id='detailUpperForm' >
<%
	
try{
	
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode			= request.getParameter( "mode" ) ;
	//String function_id	= request.getParameter( "function_id" ) ;
	String bean_id		= "Or_OrderCatalog" ;
	String bean_name	= "eOR.OrderCatalogBean";
	//String disabled		= "" ;

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);

	String order_catalog_code				=   bean.checkForNull(request.getParameter("order_catalog_code" ));	
	//String long_desc						=	bean.checkForNull(request.getParameter("long_desc"));	
	//String short_desc						=	bean.checkForNull(request.getParameter("short_desc"));	
	String order_category					=	bean.checkForNull(request.getParameter("order_category"));	
	String module_id						= 	bean.checkForNull(request.getParameter("module_id"));	
	/*String order_type_code					=   "";
	String security_level					=	"";
	


	int size								=  0;	*/

	
	//String ord_auth_level					=  "";
	//String ord_cosign_level					=  "";
	//String ord_spl_appr_level				=  "";

	
	

	/*****DEFAULT VALUES****/
	String eff_status					    = "E" ; //For modify mode Only if enabled is disabled value is 'N'
	String setting_applicability_default	=  "";
	
	String ord_auth_level_default			=  "";
	String ord_cosign_level_default			=  "";
	String ord_spl_appr_level_default		=  "";
	String skip_auth_level_default			=  ""; //IN048467

	String ord_auth_reqd_yn_default			=  "N";
	String ord_cosign_reqd_yn_default		=  "N";
	String ord_spl_appr_reqd_yn_default		=  "N";
	String skip_auth_default				=  "NA"; //IN048467

	Hashtable defVal						= new Hashtable();
	Hashtable defVal_auth_level				= new Hashtable();


	/**UPDATABLE**********/
	String ord_auth_level_updatable			=  "Y";
	String ord_cosign_level_updatable		=  "Y";
	String ord_spl_appr_level_updatable		=  "Y";


	//DEFAULT FOR ALL PAT CLASS
	String setting_applicability_updatable	= "Y" ;
	String ord_auth_reqd_yn_updatable		= "Y" ;
	String ord_cosign_reqd_yn_updatable		= "Y" ;
	String ord_spl_appr_reqd_yn_updatable	= "Y" ;
	String skip_auth_updatable				= "Y" ; //IN048467

	//DATABASE REC
	String setting_applicabilityvar_updatable	= "Y" ;
    String ord_auth_reqd_ynvar_updatable		= "Y";
    String ord_cosign_reqd_ynvar_updatable		= "Y";
    String ord_spl_appr_reqd_ynvar_updatable	= "Y";
	
	String skip_authvar_updatable = "Y"; //IN048467
	String ord_auth_default = ""; //IN048467
	/****/

	/*******MODIFY MODE********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	//headerStore
	HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();	

	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();

		 order_catalog_code = (String)orderCatalogHeaderStr.get("order_catalog_code"); 
		 String sqlParam[]  = {order_catalog_code.trim()};
		
		 defVal = bean.reviewsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_PTCL","update",sqlParam);

		 if(defVal !=null && defVal.containsKey("*A"))
		{//Some default val is there ...modify mode/called from  other module
			HashMap retRec						= (HashMap)defVal.get("*A"); //Will be always present
			ord_auth_level_default				= (String)retRec.get("ord_auth_level");
	 		ord_cosign_level_default			= (String)retRec.get("ord_cosign_level");
			ord_spl_appr_level_default			= (String)retRec.get("ord_spl_appr_level");
			skip_auth_level_default				= (String)retRec.get("skip_auth"); //IN048467

			if(module_id.trim().equalsIgnoreCase("PH"))
			{

		 
				String sql_auth_level_mod = bean.checkForNull(request.getParameter("sql_auth_level"));
				sql_auth_level_mod = "SELECT A.ORDER_AUTH_LEVEL ord_auth_level,A.ORDER_COSIGN_LEVEL ord_cosign_level,A.SPL_APPR_LEVEL ord_spl_appr_level,A.DISP_AUTH_REQD_YN result_auth_reqd_yn,A.REPEAT_SINGLE_CONT_ORDER_YN FROM PH_DRUG_SCHEDULE_LANG_VW A WHERE SCHEDULE_ID='"+sql_auth_level_mod+"' AND EFF_STATUS='E' AND A.LANGUAGE_ID = '"+localeName+"' ";
				String sqlParam_mod[]  = {};
				int sizeDef_mod=0;
				//System.out.println("@@@@ sql_auth_level_mod="+sql_auth_level_mod);
			    //Only for auth level chks
				if (!sql_auth_level_mod.equals("") && !sql_auth_level_mod.equals("null"))
				{
					defVal_auth_level = bean.reviewsDefault(sql_auth_level_mod,"auth_level",sqlParam_mod);	 			
					 sizeDef_mod = defVal_auth_level.size();
					 
					if(sizeDef_mod == 0)
					{//Allow Updation
						ord_auth_level_updatable			=  "Y";
						ord_cosign_level_updatable			=  "Y";
						ord_spl_appr_level_updatable		=  "Y";
					 }
					 else
					{//Don't Allow

						// HashMap retRec_mod						= (HashMap)defVal_auth_level.get("*A");
							ord_auth_level_default				= (String)retRec.get("ord_auth_level");
							 ord_cosign_level_default			= (String)retRec.get("ord_cosign_level");
							 ord_spl_appr_level_default			= (String)retRec.get("ord_spl_appr_level");
							 ord_spl_appr_level_default			= (String)retRec.get("ord_spl_appr_level");
							 skip_auth_level_default			= (String)retRec.get("skip_auth"); //IN048467
							 ord_auth_level_updatable			=  "N";
							 ord_cosign_level_updatable			=  "N";
							 ord_spl_appr_level_updatable		=  "N";
					}
				}
			} //END OF ph MODULE VALIDATION
		}
		else
		{
			 setting_applicability_updatable = "N" ;
		}
		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			if((defVal.size())!=0)
			{
				setting_applicability_updatable="N";
				setting_applicability_default="X";
			}
		}
	}
	/***/

	/**CALLED FROM DIFFERENT MODULE IN INSERT MODE***/
	if(!module_id.equalsIgnoreCase("OR") && !mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
	
	if(module_id.trim().equalsIgnoreCase("PH")){
		 String sql_auth_level = bean.checkForNull(request.getParameter("sql_auth_level"));
		 sql_auth_level = "SELECT A.ORDER_AUTH_LEVEL ord_auth_level,A.ORDER_COSIGN_LEVEL ord_cosign_level,A.SPL_APPR_LEVEL ord_spl_appr_level,A.DISP_AUTH_REQD_YN result_auth_reqd_yn,A.REPEAT_SINGLE_CONT_ORDER_YN FROM PH_DRUG_SCHEDULE_LANG_VW A WHERE SCHEDULE_ID='"+sql_auth_level+"' AND EFF_STATUS='E' AND A.LANGUAGE_ID = '"+localeName+"' ";
		 String sqlParam[]  = {};
		 //Only for auth level chks
		 //System.out.println(" @@ sql_auth_level="+sql_auth_level);
		 if(!sql_auth_level.equals("") && !sql_auth_level.equals("null")){
		 defVal_auth_level = bean.reviewsDefault(sql_auth_level,"auth_level",sqlParam);
		 int sizeDef = defVal_auth_level.size();
		 
		 if(sizeDef == 0){//Allow Updation
		 	 ord_auth_level_updatable			=  "Y";
			 ord_cosign_level_updatable			=  "Y";
			 ord_spl_appr_level_updatable		=  "Y";
		 }else{//Don't Allow

			 HashMap retRec						= (HashMap)defVal_auth_level.get("*A");
			 ord_auth_level_default				= (String)retRec.get("ord_auth_level");
		 	 ord_cosign_level_default			= (String)retRec.get("ord_cosign_level");
			 ord_spl_appr_level_default			= (String)retRec.get("ord_spl_appr_level");
					skip_auth_level_default			= (String)retRec.get("skip_auth"); //IN048467
			 ord_auth_level_updatable			=  "N";
			 ord_cosign_level_updatable			=  "N";
			 ord_spl_appr_level_updatable		=  "N";
		 }
		 }

		 //For patient class

		 String sql_setting = request.getParameter("sql_setting");
		 if(sql_setting== null || sql_setting.equals(""))
				 sql_setting = "SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE,A.ACTION CHK_FOR_MAX_DURN_ACTION,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRG_CTG_RLE_BY_PTCL_LANG_VW A WHERE A.DRUG_CATG_CODE='"+order_catalog_code.trim()+"' AND A.LANGUAGE_ID = '"+localeName+"' ";
		 String sqlParam1[] = {};
		 defVal = bean.settingsDefault(sql_setting,"sql_setting",sqlParam1);
		 //int sizeDef1 = defVal.size();

		
		
		}  //End of PH Validation
	}
	/***/


bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
return ;

bean.setMode( mode ) ;

ArrayList  reviewsRecStr =  bean.getReviewsRecStr();

%>


	<%if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
	 setting_applicability_updatable	=  "N";
	 ord_auth_level_updatable			=  "N";
	 ord_cosign_level_updatable			=  "N";
	 ord_spl_appr_level_updatable		=  "N";
	}%>


<!-- Auth --cosign --Special Level table -->
<table align='center' cellpadding=3 cellspacing=0 border=0 width='100%' style = "bottom-margin:0;display:none">
	<tr>
		
		<!--Authorization Level  -->
		<td  class="label" width="20%"><fmt:message key="Common.AuthorizationLevel.label" bundle="${common_labels}"/></td>
		<td align="left" width="10%"><input type=text name='ord_auth_level' id='ord_auth_level' size='1' maxlength='1' <%=eHISFormatter.chkReturn("Y",ord_auth_level_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(reviewsRecStr,0,"ord_auth_level",
	    ord_auth_level_default )%>"
		></td>
		
		<!-- Co-Sign Level  -->
		<%if(module_id.trim().equalsIgnoreCase("PH") || module_id.trim().equalsIgnoreCase("OR")){%>
		<td  class="label" width="20%"><fmt:message key="eOR.CoSignLevel.label" bundle="${or_labels}"/></td>
		<td width="10%"><input type=text name='ord_cosign_level' id='ord_cosign_level' size='1' maxlength='1'
		<%=eHISFormatter.chkReturn("Y",ord_cosign_level_updatable,"","disabled")%>	value="<%=bean.getdefaultArrListValue(reviewsRecStr,0,"ord_cosign_level",ord_cosign_level_default)%>" ></td>
		<%}else{%>
		<td  class="label" width="60%">&nbsp;</td>
		<%}%>
		
		<!-- Special Approval Level -->
		<%if(module_id.trim().equalsIgnoreCase("PH") ){%>
		<td  class="label" width="20%"><fmt:message key="eOR.SpecialApprovalLevel.label" bundle="${or_labels}"/></td>
		<td  width="10%"><input type=text name='ord_spl_appr_level' id='ord_spl_appr_level' size='1' maxlength='1' onBlur=""
		<%=eHISFormatter.chkReturn("Y",ord_spl_appr_level_updatable,"","disabled")%>	value="<%=bean.getdefaultArrListValue(reviewsRecStr,0,"ord_spl_appr_level",ord_spl_appr_level_default)%>"
		></td>
		<%}else{%>
		<td  class="label" width="60%"></td>
		<%}%>

	</tr>
</table>



<table class='grid' width='100%'>

  <tr>
	<td class="COLUMNHEADER"  width='35vw' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"  width='20vw' ><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" width='15vw' ><fmt:message key="eOR.AuthorizationRequired.label" bundle="${or_labels}"/></td>
	<td  class="COLUMNHEADER" width="10vw"><fmt:message key="eOR.skipauthorization.label" bundle="${or_labels}"/></td> <!-- IN048467 -->
  
	<%if(module_id.trim().equalsIgnoreCase("PH")|| module_id.trim().equalsIgnoreCase("OR")){%>	
	<td class="COLUMNHEADER"  width='15vw' ><fmt:message key="eOR.CosignRequired.label" bundle="${or_labels}"/></td>
	<%}%>
	
	<%if(module_id.trim().equalsIgnoreCase("PH") || module_id.trim().equalsIgnoreCase("OR")){%>	  
	<td class="COLUMNHEADER"  width='15vw' ><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></td>
	  <%}%>
  </tr>

<%//patient_class_short_desc%>
   <tr>
	<%	
		//String ord_spl_appr_reqd_yn	= "";
		
		if(module_id.trim().equalsIgnoreCase("PH"))
			ord_spl_appr_reqd_yn_updatable = "Y";

		String classValue = "gridData";

	if(order_category.equalsIgnoreCase("OH"))
	{
		setting_applicability_default = "X";//for all patient Class(*A) by default
		setting_applicability_updatable = "N";//for all patient Class(*A) by deafult
	}
	else
	{
		setting_applicability_default = "A";//for all patient Class(*A) by default
	}

	if(reviewsRecStr.isEmpty()){//Page is Visited for First Time

		if(defVal !=null && defVal.containsKey("*A")){//Some default val is there ...modify mode/called from  other module
			HashMap currRec		=(HashMap)defVal.get("*A");
			setting_applicability_default   =(String)currRec.get("setting_applicability");
			ord_auth_reqd_yn_default		=(String)currRec.get("ord_auth_reqd_yn");
			ord_cosign_reqd_yn_default		=(String)currRec.get("ord_cosign_reqd_yn"); 
			ord_spl_appr_reqd_yn_default	=(String)currRec.get("ord_spl_appr_reqd_yn");
			skip_auth_default				=(String)currRec.get("skip_auth"); //IN048467
			}
	}
	

%>
 
   	
   
   <!-- Pateint Class-->
   <td class='gridData'><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
   <INPUT TYPE="hidden" name="patient_class0" id="patient_class0" value="*A">
   
   
   <%
	   //CALLED FROM OTHER MODULE & VALUE IS ***NOT PASSED*** FOR PAT CLASS  THEN ONLY SETTING APPLICABILTY IS DEFAULTED TO NOT APPLICABLE IF 		defVal SIZE IS ZERO
		if(defVal !=null && !defVal.containsKey("*A") && module_id.equalsIgnoreCase("PH")&& !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase("")) ){
			if(reviewsRecStr.isEmpty() && defVal.size() != 0){//Page is Visited for First Time
				setting_applicability_default = "X" ;
			}
		}
		if(module_id.trim().equalsIgnoreCase("PH"))
		{
				if(((defVal.size())!=0))
				{
					if(!defVal.containsKey("*A"))
					{
						setting_applicability_updatable="N";
					}
					else
					{
						setting_applicability_updatable="Y";
					}
				}
				else if(defVal.size()==0)
				{
					setting_applicability_updatable="Y";
				}
				else if(!defVal.containsKey("*A"))
				{
					setting_applicability_updatable="Y";
				}

		}
		%>   
   <!-- Applicable -->
   <td class="gridData"><SELECT name="setting_applicability0" id="setting_applicability0" <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%>    onchange='parent.parent.parent.chkApplicability(this,"0")'>
	<option value='A'   <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"setting_applicability",setting_applicability_default),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
   <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"setting_applicability",setting_applicability_default),"X")%> ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> -->
   </SELECT>
   </td>
 
	<!-- Code for Chk Updatable -->
	<%
	
	
	
		String setting_applicability0 = 
		bean.getdefaultArrListValue(reviewsRecStr,0,"setting_applicability",setting_applicability_default);


		if(setting_applicability0.equalsIgnoreCase("X") || 
			eff_status.trim().equalsIgnoreCase("D")){
			ord_auth_reqd_yn_updatable	      = "N" ;
			ord_cosign_reqd_yn_updatable	  = "N" ;
			ord_spl_appr_reqd_yn_updatable    = "N" ;
			skip_auth_updatable				  = "N";	//IN048467
		}
		//IN048467	- Start
		ord_auth_default =  bean.getdefaultArrListValue(reviewsRecStr,0,"ord_auth_reqd_yn",ord_auth_reqd_yn_default); 
		if(!setting_applicability0.equalsIgnoreCase("X") &&  !eff_status.trim().equalsIgnoreCase("D")){ 
			if(ord_auth_default.equals("Y")){
				skip_auth_updatable = "Y";
			}
			else {
				skip_auth_updatable = "N";
			} 
		}	
		// IN048467 - End
%>
  
   
  
 <!-- Authorization Required -->  
  <td  class='<%=classValue%>' ><INPUT TYPE="checkbox" name="ord_auth_reqd_yn0" id="ord_auth_reqd_yn0" value='Y' <%=eHISFormatter.chkReturn("y",ord_auth_reqd_yn_updatable,"","disabled")%>  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(reviewsRecStr,0,"ord_auth_reqd_yn",ord_auth_reqd_yn_default))%> onclick = 'parent.parent.parent.enableSkipAuth("0")'></td>

	<!-- IN048467 Start -->
	<td class='<%=classValue%>'>
		<SELECT name="skip_auth0" id="skip_auth0" <%=eHISFormatter.chkReturn("y",skip_auth_updatable,"","disabled")%>  >
			<option value='NA' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"NA")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			<option value='R' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"R")%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
			<option value='S' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"S")%>><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
			<option value='U' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"U")%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			<option value='RU' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"RU")%>><fmt:message key="eOR.routineurgent.label" bundle="${or_labels}"/></option>
			<option value='RS' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"RS")%>><fmt:message key="eOR.routinestat.label" bundle="${or_labels}"/></option>
			<option value='US' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"US")%>><fmt:message key="eOR.urgentstat.label" bundle="${or_labels}"/></option>
			<option value='*A' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,0,"skip_auth",skip_auth_default),"*A")%>><fmt:message key="eOR.routineurgentstat.label" bundle="${or_labels}"/></option>
		</SELECT>
	</td>
	<!-- IN048467 End -->
   <!-- Cosign Reqd -->
   <%if(module_id.trim().equalsIgnoreCase("PH") || module_id.trim().equalsIgnoreCase("OR")){%>	
   <td  class='<%=classValue%>' ><INPUT TYPE="checkbox"	 name="ord_cosign_reqd_yn0" id="ord_cosign_reqd_yn0" value='Y' <%=eHISFormatter.chkReturn("y",ord_cosign_reqd_yn_updatable,"","disabled")%>   <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(reviewsRecStr,0,"ord_cosign_reqd_yn",ord_cosign_reqd_yn_default))%> ></td>
   <%}%>

   
   <!-- special APPROVAL -->
   <%if(module_id.trim().equalsIgnoreCase("PH")|| module_id.trim().equalsIgnoreCase("OR")){%>
   <td  class='<%=classValue%>' ><INPUT TYPE="checkbox" name="ord_spl_appr_reqd_yn0" id="ord_spl_appr_reqd_yn0" value='Y' <%=eHISFormatter.chkReturn("y",ord_spl_appr_reqd_yn_updatable,"","disabled")%> <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(reviewsRecStr,0,"ord_spl_appr_reqd_yn",ord_spl_appr_reqd_yn_default))%>>
   </td>
	<%}%>
  </tr>


<!-----------------------DATABASE RECORD-------------------------------- -->

<%
HashMap pat_class =	bean.getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
Integer	noOfRecordsTemp = (Integer)pat_class.get("noRec");
int noOfRecords   = noOfRecordsTemp.intValue() ;
int fm_disp		  = 1 ;	
int to_disp		  = noOfRecords ;
%>

<!-- no of Records shown -->
<INPUT TYPE="hidden" name="noOfRecords" id="noOfRecords" value="<%=noOfRecords%>">

<%if(noOfRecords != 0){
	for(int i=fm_disp ; i <= to_disp; i++){
		String patient_class  = (String)pat_class.get("PATIENT_CLASS"+i);	
		String patient_class_short_desc  = (String)pat_class.get("SHORT_DESC"+i);	
		classValue			=( (i%2)==0 )? "gridData" : "gridData";
	
		//ReIntialise
		setting_applicability_default	=  "X";
		ord_auth_reqd_yn_default		=  "N";
		ord_cosign_reqd_yn_default		=  "N";
		ord_spl_appr_reqd_yn_default	=  "N";
		skip_auth_default				=  "NA"; //IN048467

		ord_auth_reqd_ynvar_updatable		= "Y";
		ord_cosign_reqd_ynvar_updatable		= "Y";
		ord_spl_appr_reqd_ynvar_updatable	= "Y";
		skip_authvar_updatable				= "Y"; //IN048467

	
	
	if(reviewsRecStr.isEmpty()){//Page is Visited for First Time
		if(defVal !=null && defVal.containsKey(patient_class.trim())){//Some default val is there ...modify mode/called from  other module
			HashMap currRec					=(HashMap)defVal.get(patient_class.trim());
			setting_applicability_default   =(String)currRec.get("setting_applicability");
			if(setting_applicability_default.trim().equalsIgnoreCase("A")){	
				ord_auth_reqd_yn_default		=(String)currRec.get("ord_auth_reqd_yn");
				ord_cosign_reqd_yn_default		=(String)currRec.get("ord_cosign_reqd_yn"); 
				ord_spl_appr_reqd_yn_default	=(String)currRec.get("ord_spl_appr_reqd_yn");				
				skip_auth_default				=(String)currRec.get("skip_auth"); //IN048467
				//out.println("ord_auth_reqd_yn_default="+ord_auth_reqd_yn_default);
			}
		}

	}


	//CALLED FROM OTHER MODULE & VALUE IS ***NOT PASSED*** FOR  PAT CLASS THEN ONLY SETTING APPLICABILTY IS DISABLED
	if(defVal !=null && !defVal.containsKey(patient_class.trim()) && !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase(""))||(order_category.equalsIgnoreCase("OH")) )
	{
	   setting_applicabilityvar_updatable = "N" ;
	}
	else
	{
		 setting_applicabilityvar_updatable = "Y" ;
	}

	if(eff_status.trim().equalsIgnoreCase("D"))
		setting_applicabilityvar_updatable = "N" ;
	%>


<tr>
   <!-- Patient Class -->
   <td  class='<%=classValue%>'><%=patient_class_short_desc%></td>
   <INPUT TYPE="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=patient_class%>">
    
   <!--Applicable  -->
   <td class='<%=classValue%>'><SELECT name="setting_applicability<%=i%>" id="setting_applicability<%=i%>" 
  <%=eHISFormatter.chkReturn("y",setting_applicabilityvar_updatable,"","disabled")%> 
   onchange='parent.parent.parent.chkApplicability(this,"<%=i%>")'>
   <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"setting_applicability",setting_applicability_default),"X")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
   <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"setting_applicability",setting_applicability_default),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
   </SELECT>
  </td>
 
 
   <!-- Check App While Loading -->
   <%
	  String  setting_applicabilityVar = bean.getdefaultArrListValue(reviewsRecStr,i,"setting_applicability",setting_applicability_default);

	  if(setting_applicabilityVar.equalsIgnoreCase("X") || 	eff_status.trim().equalsIgnoreCase("D") ){
			 ord_auth_reqd_ynvar_updatable     ="N";
 			 ord_cosign_reqd_ynvar_updatable   ="N";
 			 ord_spl_appr_reqd_ynvar_updatable ="N";
 			 skip_authvar_updatable			   ="N"; //IN048467	
	  }
	//IN048467	- Start
	 ord_auth_default =  bean.getdefaultArrListValue(reviewsRecStr,i,"ord_auth_reqd_yn",ord_auth_reqd_yn_default);
	if(!setting_applicability0.equalsIgnoreCase("X") &&  !eff_status.trim().equalsIgnoreCase("D")){ 
		if(ord_auth_default.equals("Y")){
		  skip_authvar_updatable = "Y";
		}
		else {
		  skip_authvar_updatable = "N";
		}
	 } 
	// IN051070 - Start
	else {
		if(ord_auth_default.equals("Y")){
			  skip_authvar_updatable = "Y";
			}
			else {
			  skip_authvar_updatable = "N";
		}
	}	
	// IN051070 - End
	//IN048467	- End
   %>
   
   <!-- Authorization Required -->
   <td  class='<%=classValue%>' ><INPUT TYPE="checkbox" name="ord_auth_reqd_yn<%=i%>" id="ord_auth_reqd_yn<%=i%>" value='Y' 
   <%=eHISFormatter.chkReturn("y",ord_auth_reqd_ynvar_updatable,"","disabled")%> <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(reviewsRecStr,i,"ord_auth_reqd_yn",ord_auth_reqd_yn_default))%> onclick = 'parent.parent.parent.enableSkipAuth("<%=i%>")'>
   </td>
   <!-- IN048467 START -->
	<td class='<%=classValue%>'>
	<SELECT name="skip_auth<%=i%>" id="skip_auth<%=i%>" <%=eHISFormatter.chkReturn("y",skip_authvar_updatable,"","disabled")%>  >
		
			<option value='NA' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"NA")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			<option value='R' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"R")%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
			<option value='S' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"S")%>><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
			<option value='U' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"U")%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			<option value='RU' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"RU")%>><fmt:message key="eOR.routineurgent.label" bundle="${or_labels}"/></option>
			<option value='RS' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"RS")%>><fmt:message key="eOR.routinestat.label" bundle="${or_labels}"/></option>
			<option value='US' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"US")%>><fmt:message key="eOR.urgentstat.label" bundle="${or_labels}"/></option>
			<option value='*A' <%=eHISFormatter.select(bean.getdefaultArrListValue(reviewsRecStr,i,"skip_auth",skip_auth_default),"*A")%>><fmt:message key="eOR.routineurgentstat.label" bundle="${or_labels}"/></option>
		
		</SELECT>
	</td>
	<!-- IN048467 - END -->	
  <!-- Cosign Reqd -->
   <%if(module_id.trim().equalsIgnoreCase("PH") || 												module_id.trim().equalsIgnoreCase("OR")){%>	   
   <td  class='<%=classValue%>' ><INPUT TYPE="checkbox"	 name="ord_cosign_reqd_yn<%=i%>" id="ord_cosign_reqd_yn<%=i%>" value='Y' 	
   <%=eHISFormatter.chkReturn("y",ord_cosign_reqd_ynvar_updatable,"","disabled")%>
	  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(reviewsRecStr,i,"ord_cosign_reqd_yn",ord_cosign_reqd_yn_default))%> > </td>
   <%}%>

  	<!-- special Approval -->
	<%if(module_id.trim().equalsIgnoreCase("PH")|| module_id.trim().equalsIgnoreCase("OR") ){%>	   
	<td  class='<%=classValue%>' ><INPUT TYPE="checkbox" name="ord_spl_appr_reqd_yn<%=i%>" id="ord_spl_appr_reqd_yn<%=i%>" value='Y' 
	<%=eHISFormatter.chkReturn("y",ord_spl_appr_reqd_ynvar_updatable,"","disabled")%> 
	<%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(reviewsRecStr,i,"ord_spl_appr_reqd_yn",ord_spl_appr_reqd_yn_default))%>>
	</td>
	<%}%>

</tr>
<%}//Loop for all the DBRecords for Patient Class
  
}//Loop if noOfRecords > 0%>


</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="module_id" id="module_id" value="<%=module_id.trim()%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tabType" id="tabType" value="R">

</form>

<%
putObjectInBean(bean_id,bean,request);	
}catch(Exception e){
//	out.println(e.getMessage());//COMMON-ICN-0181
System.out.println("here" + e);
e.printStackTrace();
}%>
</body>
</html>	

