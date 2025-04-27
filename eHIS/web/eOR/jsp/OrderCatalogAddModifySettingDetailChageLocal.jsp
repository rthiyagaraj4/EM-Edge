<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false" %> 

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
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 


<body   OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='detailUpperForm' id='detailUpperForm' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%!
	/***DEFAULTS***********/
	String qty_uom_default							="";
	String qty_value_default						="1"; 
	String freq_code_default						="";
	String max_durn_type_default					=""; 
	String max_durn_value_default					=""; 
	String chk_for_max_durn_action_default			="";
	String ord_auth_level_default					=""; 
	String prompt_msg_default						=""; 
	String setting_applicability_default			="X";
	String durn_type_default						=""; 
	//String durn_desc_default						=""; 
	String durn_value_default						=""; 
	/**/

	/***UPDATABLE***********/
	String qty_uom_updatable						="N";
	String qty_value_updatable						="N"; 
	String freq_code_updatable						="N";
	String durn_value_updatable						="N"; 
	String max_durn_type_updatable					="N"; 
	String max_durn_value_updatable					="N"; 
	String chk_for_max_durn_action_updatable		="N" ;
	String ord_auth_level_updatable					="N"; 
	String setting_applicability_updatable			="Y"; 
	/**/
	
	
	public void defaultIntialisation()	{
	 qty_uom_default						="";
	 qty_value_default						="1"; 
	 freq_code_default						="";
	 max_durn_type_default					=""; 
	 max_durn_value_default					=""; 
	 chk_for_max_durn_action_default		="";
	 ord_auth_level_default					=""; 
	 prompt_msg_default						=""; 
	 setting_applicability_default			="X";
	 durn_type_default						=""; 
	// durn_desc_default						=""; 
	 durn_value_default						="";
	}

	public void updatableIntialisation(){
	
	 qty_uom_updatable					="N";
	 qty_value_updatable				="N"; 
	 freq_code_updatable				="N";
	 max_durn_type_updatable			="N"; 
	 durn_value_updatable               ="N"; 
	 max_durn_value_updatable			="N"; 
	 chk_for_max_durn_action_updatable	="N" ;
	 ord_auth_level_updatable			="N";
	 setting_applicability_updatable	="Y";
	}

	String decode(String code){
	  if(code.equalsIgnoreCase("H")) return "Hours";
	  if(code.equalsIgnoreCase("D")) return "Days";
	  if(code.equalsIgnoreCase("W")) return "Weeks";
	  if(code.equalsIgnoreCase("M")) return "Months";
	  return "";
	}

%>

<%
	
try{
	
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode		    = request.getParameter( "mode" ) ;
	//String function_id  = request.getParameter( "function_id" ) ;
	String bean_id      = "Or_OrderCatalog" ;
	String bean_name    = "eOR.OrderCatalogBean";
	//String disabled		= "" ;

	String uom_style    = "display:none" ;

	//String max_durn_value					="";
	String eff_status						="E";
	//String ord_auth_level					="";
	
	/**DEFAULT VALUES IN UPDATE MODE/OTHER MODULE CALLED*************/
	 Hashtable defVal						=new Hashtable();
	/**/
	
	defaultIntialisation();//Always intailise when the page is loaded to get default value
	updatableIntialisation();//Always intailise when the page is loaded to get default value

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);

	String order_catalog_code				=bean.checkForNull(request.getParameter("order_catalog_code" ));	
	/*String long_desc						=bean.checkForNull(request.getParameter("long_desc"));	
	String short_desc						=bean.checkForNull(request.getParameter("short_desc"));*/	
	String order_category					=bean.checkForNull(request.getParameter("order_category"));	
	String module_id						=bean.checkForNull(request.getParameter("module_id"));	
	//String security_level					="";


	//int size								=  0;	
	
	String classValue = "QRYODD";//to Chabge class of the alternate rows


	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;

	bean.setMode( mode ) ;

	/*******MODIFY MODE form All Modules********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	
	//headerStore
	HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();	

	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();

		order_catalog_code =
		(String)orderCatalogHeaderStr.get("order_catalog_code"); 
		 String sqlParam[]  = {order_catalog_code.trim()};
		
		defVal = bean.settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);
	}
	/***/

	/**CALLED FROM DIFFERENT MODULE IN INSERT MODE***/
	if(!module_id.equalsIgnoreCase("OR") && 	!mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
	
		if(module_id.trim().equalsIgnoreCase("PH")){

		 uom_style = ""; //uom is made visible
		 String sql_setting = request.getParameter("sql_setting");
		 String sqlParam[]  = {};
		 defVal = bean.settingsDefault(sql_setting,"sql_setting",sqlParam);
		 //int sizeDef = defVal.size();

		/* if(sizeDef == 0){//Allow Updation
		 	;
		 }else{//UPdation chk at all particular records
		 }*/
		
		}
	}
	/***/

	 //Display logic of UOM
	 if(order_category.trim().equalsIgnoreCase("PH") || 	module_id.trim().equalsIgnoreCase("PH"))
	 uom_style = "";
	 
	 /***GET THE STORE FOR THIS TAB***/

	ArrayList  settingsRecStr		 =  bean.getSettingsRecStr();
	
	/**CHARACTERISTICS VALUE*************/
	ArrayList  characteristicsRecStr =  bean.getCharacteristicsRecStr();
	String qty_reqd_yn				 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn","N");

	String freq_applicable_yn		 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn","N");


	String qty_uom		 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

	String soft_stop_yn				 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"soft_stop_yn","N");
	
	/**/

	/**TO LOAD FREQUENCY VALUE************/
	bean.setSettingsFreqStr(order_category.trim(),order_catalog_code.trim());
	HashMap   settingsFreqStr		 =  bean.getSettingsFreqStr();
	Integer	noOfRecTemp				 = (Integer)settingsFreqStr.get("noRec");
	int noOfRecordsFreq				 = noOfRecTemp.intValue() ;
	/**/

%>

<table align='center' cellpadding=3 cellspacing=0 border=1 width='100%'>

  <tr>
	<td class='COLUMNHEADER'  nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  nowrap><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  nowrap><fmt:message key="eOR.QtyDose.label" bundle="${or_labels}"/></td>
	<td class='COLUMNHEADER'  nowrap style=<%=uom_style%>><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eOR.DurnValueType.label" bundle="${or_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eOR.MaxValueDurnType.label" bundle="${or_labels}"/></td>
    <td class='COLUMNHEADER' nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
	<td clas s='COLUMNHEADER' nowrap style = "bottom-margin:0;display:none"><fmt:message key="Common.AuthorizationLevel.label" bundle="${common_labels}"/></td>
    <td class='COLUMNHEADER' nowrap><fmt:message key="eOR.Msg.label" bundle="${or_labels}"/></td>
  </tr>

<!-- ALL PATIENT CLASS -->
<tr>
   <td nowrap class='label' width='20%' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
   <INPUT TYPE="hidden" name="patient_class0" id="patient_class0" value="*A">
    

	<!--Applicability SuperSeding all the rules -->
	
	<%
		
	
	setting_applicability_default = "A";//for all patient Class(*A) by deafult
	
	if(settingsRecStr.isEmpty()){//Page is Visited for First Time
			if(defVal.containsKey("*A")){//Some default val is there ...modify mode/called from  other module
				HashMap currRec					=(HashMap)defVal.get("*A");
				setting_applicability_default   =(String)currRec.get("setting_applicability");
				qty_uom_default					=(String)currRec.get("qty_uom");
				qty_value_default				=eHISFormatter.chkReturn((String)currRec.get("qty_value"),"0","",(String)currRec.get("qty_value")); 
				freq_code_default				=(String)currRec.get("freq_code");
				max_durn_type_default			=(String)currRec.get("max_durn_type"); 
				max_durn_value_default			=eHISFormatter.chkReturn((String)currRec.get("max_durn_value"),"0","",(String)currRec.get("max_durn_value")); 
				chk_for_max_durn_action_default	=(String)currRec.get("chk_for_max_durn_action");
				ord_auth_level_default			=eHISFormatter.chkReturn((String)currRec.get("ord_auth_level"),"0","",(String)currRec.get("ord_auth_level")); 
				durn_type_default				=(String)currRec.get("durn_type"); 
				prompt_msg_default				=(String)currRec.get("prompt_msg"); 
				//durn_desc_default				=(String)currRec.get("durn_desc"); 
				durn_value_default				=eHISFormatter.chkReturn((String)currRec.get("durn_value"),"0","",(String)currRec.get("durn_value")); 
			}
		}
	
	
		String setting_applicability0 = bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default);


		
		/***VALIDATION BASED ON THE CHARACTERISTICS VALUE***************/
		if(qty_reqd_yn.trim().equalsIgnoreCase("Y")){
		qty_uom_updatable	= "Y";
		qty_value_updatable = "Y";
		}   

		if(module_id.trim().equalsIgnoreCase("PH")){
		qty_uom_default = qty_uom ;
		}
	    /****/
		
	
		/**CHK FOR ACTION TAG****/
		String 	chk_for_max_durn_actionO	= bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default);

		if(chk_for_max_durn_actionO.equalsIgnoreCase("A"))
		ord_auth_level_updatable			 = "Y";
		/***/
	

		/**ONLY IN MODIFY MODE IF EFF_STAUS IS DISABLED ***/
		if(eff_status.trim().equalsIgnoreCase("D") &&  mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		 updatableIntialisation();
		 setting_applicability_updatable			="N";
		}
	

		/*** CHK setting Appl*******/
		if(setting_applicability0.trim().equalsIgnoreCase("A")){
		freq_code_updatable = "Y" ;
		}

		
		/**** FREQ CODE  CHK *********/
		String freq_code0	 = bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default);

		if(!freq_code0.trim().equals("") && freq_code_updatable.equalsIgnoreCase("Y")){
		durn_value_updatable	 = "Y";
		max_durn_value_updatable = "Y";
		}
		
		
		
		
		
		
		/***Check for Max Durn Value *********/
		String 	max_durn_val0 = bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_value",
		max_durn_value_default) ;


		/**MAX DURN VLAUE IS NOT NULL AND UPDATABLE ****/
		if(!max_durn_val0.trim().equals("") && 	max_durn_value_updatable.trim().equalsIgnoreCase("Y"))
		chk_for_max_durn_action_updatable = "Y";


	
		//Applicability---//SuperRiding All the Roles
		if(setting_applicability0.trim().equalsIgnoreCase("X")){//this condn over rides all the prevoius rule
	 	updatableIntialisation();
		}

   	
	%>




	   <td  class="fields"><SELECT name="setting_applicability0" id="setting_applicability0"  <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%> onchange='parent.parent.parent.chkApplSetting(this,"0");'>
	    <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
	    <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"X")%>><fmt:message key="eOR.NonApplicable.label" bundle="${or_labels}"/></option>
		</SELECT>
		</td>


	   <td  class='<%=classValue%>' nowrap><input type=text name='qty_value0' id='qty_value0' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);" <%=eHISFormatter.chkReturn("y",qty_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"qty_value",
		"1")%>" ></td>

	   <td class='<%=classValue%>' nowrap style=<%=uom_style%>>
	   <input type=text name='qty_uom0' id='qty_uom0' size='3' maxlength='3' 
	   <%=eHISFormatter.chkReturn("y",qty_uom_updatable,"","disabled")%>
	   value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"qty_uom",
	   qty_uom_default)%>" >
   	   </td>
   
	
	<!-- FREQ CODE -->
	<%
		StringBuffer optionsFreq = new StringBuffer() ;		
		if(noOfRecordsFreq != 0){
		for(int i=1 ; i <= noOfRecordsFreq; i++){
        optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
		}
	}
	%>
		<td class='<%=classValue%>' nowrap><SELECT <%=eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")%> NAME="freq_code0" onchange='parent.parent.parent.getDurnType(this,"0")'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<%=optionsFreq.toString()%></SELECT></td>


    <!-- Durn Val/Durn Desc -->
 	<td nowrap>
		<input type="text" name="durn_value0" id="durn_value0" size='3' maxlength='3'	class="number"	  <%=eHISFormatter.chkReturn("y",durn_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default)%>">/<input type="text"   disabled name="durn_desc0" id="durn_desc0"	 size='3'  value="<%=decode(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default))%>"></td>
		<input type="hidden" name="durn_type0" id="durn_type0" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default)%>">
	

	<%
		bean.setSettingsDurnStr();
		HashMap durn_type_str =	 bean.getSettingsDurnStr();
		Integer	noOfRecDurnTemp = (Integer)durn_type_str.get("noRec");
		int noOfRecDurn   = noOfRecDurnTemp.intValue() ;
		StringBuffer optionsDurn = new StringBuffer() ;		
		if(noOfRecDurn != 0){
		for(int i=1 ; i <= noOfRecDurn; i++){
        optionsDurn.append("<option value=\""+(String)durn_type_str.get("DURN_TYPE"+i) +  "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_type",max_durn_type_default),(String)durn_type_str.get("DURN_TYPE"+i))+">"+(String)durn_type_str.get("DURN_DESC"+i)+"</option>");
		}
	}

	

	%>
	
    <td  class='<%=classValue%>' ><input type=text name='max_durn_value0' id='max_durn_value0' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkEnteredMaxVal(this,'0');" <%=eHISFormatter.chkReturn("y",max_durn_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_value",
	max_durn_value_default)%>" ><SELECT <%=eHISFormatter.chkReturn("y",max_durn_type_updatable,"","disabled")%> NAME="max_durn_type0" onchange=''><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%=optionsDurn.toString()%>
	</SELECT></td>



    <td  class='<%=classValue%>'  nowrap>
	<SELECT name="chk_for_max_durn_action0" id="chk_for_max_durn_action0"  <%=eHISFormatter.chkReturn("y",chk_for_max_durn_action_updatable,"","disabled")%>  onchange='parent.parent.parent.chkAction(this,"0")'>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<option value="W" <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"W")%>><fmt:message key="eOR.WarnOnAppt.label" bundle="${or_labels}"/></option>
	<option value="R" <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"R")%>><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
	<option value="A" <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"A")%>><fmt:message key="eOR.RequestforAuthorize.label" bundle="${or_labels}"/></option>
	</SELECT>
	</td>
	
	<!-- Code to Chk athu level Updation -->
	
    <td  class='<%=classValue%>' nowrap style = "bottom-margin:0;display:none"><input type=text name='ord_auth_level0' id='ord_auth_level0' size='1' maxlength='1' 
	<%=eHISFormatter.chkReturn("y",ord_auth_level_updatable,"","disabled")%>  
	onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkSecurityLevel(this)" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"ord_auth_level",
	ord_auth_level_default)%>" ></td>

    <td  class='<%=classValue%>' nowrap><A name='msg0' HREF='javascript:parent.parent.parent.showMsgDialog("0")'><fmt:message key="eOR.Msg.label" bundle="${or_labels}"/></A></td>
	
	<INPUT TYPE="hidden" name="prompt_msg0" id="prompt_msg0" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"prompt_msg",
	prompt_msg_default)%>" nowrap>
  </tr>


<!-----------RECORDS FROM DATABASE--------------------->

<%


HashMap pat_class =	bean.getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
Integer	noOfRecordsTemp = (Integer)pat_class.get("noRec");
int noOfRecords   = noOfRecordsTemp.intValue() ;
int fm_disp		  = 1 ;	
int to_disp		  = noOfRecords ;
%>


<INPUT TYPE="hidden" name="noOfRecords" id="noOfRecords" value="<%=noOfRecords%>">

<%if(noOfRecords != 0){
	for(int i=fm_disp ; i <= to_disp; i++){
		String patient_class  = (String)pat_class.get("PATIENT_CLASS"+i);	
		String patient_class_short_desc  = (String)pat_class.get("SHORT_DESC"+i);	
		classValue			=( (i%2)==0 )? "QRYODD" : "QRYEVEN";
%>



<tr>
   <td  nowrap class='<%=classValue%>'><%=patient_class_short_desc%></td>
   <INPUT TYPE="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=patient_class%>">
    


   <%
	/**ReInitaise for every Loop (Default&Updatables) Very IMP******/
	defaultIntialisation();
	updatableIntialisation();
	
	if(settingsRecStr.isEmpty()){//Page is Visited for First Time
		if(defVal.containsKey(patient_class.trim())){//Some default val is there ...modify mode/called from  other module
				HashMap currRec					=(HashMap)defVal.get(patient_class.trim());
				setting_applicability_default   =(String)currRec.get("setting_applicability");
			if(setting_applicability_default.trim().equalsIgnoreCase("A")){	
				qty_uom_default					=(String)currRec.get("qty_uom");
				qty_value_default				=eHISFormatter.chkReturn((String)currRec.get("qty_value"),"0","",(String)currRec.get("qty_value")); 
				freq_code_default				=(String)currRec.get("freq_code");
				max_durn_type_default			=(String)currRec.get("max_durn_type"); 
				max_durn_value_default			=eHISFormatter.chkReturn((String)currRec.get("max_durn_value"),"0","",(String)currRec.get("max_durn_value")); 
				chk_for_max_durn_action_default	=(String)currRec.get("chk_for_max_durn_action");
				ord_auth_level_default			=(String)currRec.get("ord_auth_level"); 
				prompt_msg_default				=(String)currRec.get("prompt_msg"); 
				setting_applicability_default	=(String)currRec.get("setting_applicability");  
				durn_type_default				=(String)currRec.get("durn_type"); 
				//durn_desc_default				=(String)currRec.get("durn_desc"); 
				durn_value_default				=eHISFormatter.chkReturn((String)currRec.get("durn_value"),"0","",(String)currRec.get("durn_value")); 
			}
		 }
	 }
	


	 String setting_applicabilityVar = bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_default);

	 if(qty_reqd_yn.trim().equalsIgnoreCase("Y")){//awalys set with default value
		qty_uom_updatable = "Y";
		qty_value_updatable = "Y";
		}   


	/***VALIDATION BASED ON THE CHARACTERISTICS VALUE***************/
	String 	chk_for_max_durn_actionVar = bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",
    chk_for_max_durn_action_default)		;
	
	
	if(chk_for_max_durn_actionVar.equalsIgnoreCase("A"))
		ord_auth_level_updatable = "Y";

	qty_uom_default                     = qty_uom ;
	
	if(freq_applicable_yn.trim().equalsIgnoreCase("Y")){//Default freq chk form other tab condn
		if(module_id.trim().equalsIgnoreCase("PH"))
			chk_for_max_durn_action_updatable	= "N" ;	 //For Pharmacy
	}
	/****/
	%>
	
	<%//CALLED FROM OTHER MODULE & VALUE IS **NOt PASSED*** FOR PAT CLASS  & MODE IS NOT MODIFY THEN ONLY SETTING APPLICABILTY IS DISABLED
	if(!defVal.containsKey(patient_class.trim()) && !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase(""))){
		setting_applicability_updatable		= "N" ;
		setting_applicabilityVar			= "X" ;
	}
	
	
	
	/******ONLY IN MOD MODE IF EFF_STAUS IS DISABLED*******/
	if(eff_status.trim().equalsIgnoreCase("D")){
	 updatableIntialisation();
	 setting_applicability_updatable		="N";
	}


	/*** CHK setting Appl*******/
	if(setting_applicability0.trim().equalsIgnoreCase("A")){
	freq_code_updatable = "Y" ;
	}	




	/***FREQ CHK *********/
	String freq_codeVar		= bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default);
	
	
	if(!freq_codeVar.trim().equals("") && freq_code_updatable.equalsIgnoreCase("Y")){
	durn_value_updatable	 = "Y";
	max_durn_value_updatable = "Y";
	}
	
	
	/***MAX DURN CHK *********/
    String 	max_durn_valVar = bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_value",
	max_durn_value_default) ;


	if(!max_durn_valVar.equalsIgnoreCase("") && max_durn_value_updatable.equalsIgnoreCase("Y"))
		chk_for_max_durn_action_updatable = "Y";


		
	if(setting_applicabilityVar.trim().equalsIgnoreCase("X")){//this condn overrides all the prevoius rule
	 updatableIntialisation();
	}	  
  
%>

  <td class='<%=classValue%>'><SELECT name="setting_applicability<%=i%>" id="setting_applicability<%=i%>" onchange='parent.parent.parent.chkApplSetting(this,"<%=i%>")' <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%>>
   <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicabilityVar),"X") %>><fmt:message key="eOR.NonApplicable.label" bundle="${or_labels}"/></option>
   <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicabilityVar),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
   </SELECT>
   </td>

 
 
  <td align="center" class='<%=classValue%>' nowrap><input type=text name='qty_value<%=i%>' id='qty_value<%=i%>' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);" <%=eHISFormatter.chkReturn("y",qty_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"qty_value",
  qty_value_default)%>" ></td>

  <td align="center" class='<%=classValue%>' nowrap style=<%=uom_style%> >
  <input type=text name='qty_uom<%=i%>' id='qty_uom<%=i%>' size='3' maxlength='3' nowrap
  <%=eHISFormatter.chkReturn("y",qty_uom_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"qty_uom",
	qty_uom_default)%>" >
 </td>


<!-- This Code to get Frequency combo take care the selected values by client in prevoius visit to  the page-->	
	
	<%
		
		StringBuffer optionsFreqVar = new StringBuffer() ;		
		if(noOfRecordsFreq != 0){
		for(int j=1 ; j <= noOfRecordsFreq; j++){
        optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\" "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
		}
	}
	%>
	
	<td  class='<%=classValue%>' nowrap><SELECT name="freq_code<%=i%>" id="freq_code<%=i%>" <%=eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")%> onchange='parent.parent.parent.getDurnType(this,"<%=i%>")'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%=optionsFreqVar.toString()%></SELECT></td>

	

	<!-- Durn Val/Durn Desc -->
 	<td nowrap>
	<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" 	<%=eHISFormatter.chkReturn("y",durn_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"durn_value",durn_value_default)%>">/<input type="text"   disabled name="durn_desc<%=i%>" id="durn_desc<%=i%>"	 size='3'  value="<%=decode(bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default))%>"></td>
	<input type="hidden" name="durn_type<%=i%>" id="durn_type<%=i%>" value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default)%>">

	
	<!-- Code for Maximum Duration Type Options-->

	<%
		bean.setSettingsDurnStr();
		HashMap durn_type_str_var =	 bean.getSettingsDurnStr();
		Integer	noOfRecDurnTempVar = (Integer)durn_type_str_var.get("noRec");
		int noOfRecDurnvar   = noOfRecDurnTempVar.intValue() ;
		StringBuffer optionsDurnVar = new StringBuffer() ;		
		if(noOfRecDurnvar != 0){
		for(int k=1 ; k <= noOfRecDurnvar; k++){
        optionsDurnVar.append("<option value=\""+(String)durn_type_str_var.get("DURN_TYPE"+k) +   "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_type",max_durn_type_default),(String)durn_type_str_var.get("DURN_TYPE"+k))+">"+(String)durn_type_str_var.get("DURN_DESC"+k)+"</option>");
		}
	}

	

	%>
	
    <td  class='<%=classValue%>'>
	<input type=text name='max_durn_value<%=i%>' id='max_durn_value<%=i%>' size='3' maxlength='3' class="NUMBER" 
   onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkEnteredMaxVal(this,'<%=i%>');"
	<%=eHISFormatter.chkReturn("y",max_durn_value_updatable,"","disabled")%>  value='<%=bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_value",max_durn_value_default)%>' >&nbsp;<SELECT name="max_durn_type<%=i%>" id="max_durn_type<%=i%>" <%=eHISFormatter.chkReturn("y",max_durn_type_updatable,"","disabled")%> onchange=''><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---</option> <%=optionsDurnVar.toString()%></SELECT></td>

    <td align="center" class='<%=classValue%>' nowrap>
	<SELECT name="chk_for_max_durn_action<%=i%>" id="chk_for_max_durn_action<%=i%>"  <%=eHISFormatter.chkReturn("y",chk_for_max_durn_action_updatable,"","disabled")%>  onchange='parent.parent.parent.chkAction(this,"<%=i%>")'>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<option value="W" <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"W")%>><fmt:message key="eOR.WarnOnAppt.label" bundle="${or_labels}"/></option>
	<option value="R" <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"R")%>><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
	<option value="A" <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"A")%>><fmt:message key="eOR.RequestforAuthorize.label" bundle="${or_labels}"/></option>
	</SELECT></td>


	<td  class='<%=classValue%>' style = "bottom-margin:0;display:none"><input type=text name='ord_auth_level<%=i%>' id='ord_auth_level<%=i%>' size='1' maxlength='1'
	onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkSecurityLevel(this)"
	<%=eHISFormatter.chkReturn("y",ord_auth_level_updatable,"","disabled")%>  value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"ord_auth_level",
    ord_auth_level_default)%>" ></td>

    <td  class='<%=classValue%>' ><A name='msg<%=i%>' HREF='javascript:parent.parent.parent.showMsgDialog("<%=i%>")'><fmt:message key="eOR.Msg.label" bundle="${or_labels}"/></A></td>

	<INPUT TYPE="hidden" name="prompt_msg<%=i%>" id="prompt_msg<%=i%>" value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"prompt_msg",
    prompt_msg_default)%>">
	</tr>
<%}
  
}%>


</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="module_id" id="module_id" value="<%=module_id.trim()%>">
<input type="hidden" name="tabType" id="tabType" value="Se">

<!-- Characteristis Tab Value -->
<input type="hidden" name="qty_reqd_yn" id="qty_reqd_yn"          value="<%=qty_reqd_yn%>">
<input type="hidden" name="freq_applicable_yn" id="freq_applicable_yn"  value="<%=freq_applicable_yn%>">
<input type="hidden" name="soft_stop_yn" id="soft_stop_yn"		 value="<%=soft_stop_yn%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<!-- -->

</form>

<%putObjectInBean(bean_id,bean,request);}catch(Exception e){
System.out.println(e);
}%>
</body>
</html>	

