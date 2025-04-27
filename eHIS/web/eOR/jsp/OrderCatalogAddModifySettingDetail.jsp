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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../js/OrderCatalog.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<!-- Before onLoad of the page this funtion was called 'ptClsSettingDisableInPH();' now it is removed by Archana Dhal on 6/2/2010 related to the IN021612. -->
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" onLoad="">
<!--   -->
<form name='detailUpperForm' id='detailUpperForm' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%!
	/***DEFAULTS***********/
	String qty_uom_default							="";
	String qty_value_default						="1";
	String freq_code_default						="";
	String age_group_code_default					="";
	String max_durn_type_default					="";
	String max_durn_value_default					="";
	String chk_for_max_durn_action_default			="";
	String ord_auth_level_default					="";
	String prompt_msg_default						="";
	String setting_applicability_default			="X";
	String durn_type_default						="";
	String durn_desc_default						="";
	String durn_value_default						="";
	/**/

	/***UPDATABLE***********/
	String qty_uom_updatable						="N";
	String qty_value_updatable						="N";
	String freq_code_updatable						="Y";
	String age_group_code_updatable					="Y";
	String durn_value_updatable						="N";
	String max_durn_type_updatable					="N";
	String max_durn_value_updatable					="N";
	String chk_for_max_durn_action_updatable		="N" ;
	String ord_auth_level_updatable					="N";
	String setting_applicability_updatable			="Y";
	/**/


	public void defaultIntialisation()	
	{
		qty_uom_default						="";
		qty_value_default						="1";
		freq_code_default						="";
		age_group_code_default					="";
		max_durn_type_default					="";
		max_durn_value_default					="";
		chk_for_max_durn_action_default		="";
		ord_auth_level_default					="";
		prompt_msg_default						="";
		setting_applicability_default			="X";
		durn_type_default						="";
		durn_desc_default						="";
		durn_value_default						="";
	}

	public void updatableIntialisation()
	{

		qty_uom_updatable					="N";
		qty_value_updatable				="N";
		freq_code_updatable				="Y";
		age_group_code_updatable			="Y";
		max_durn_type_updatable			="N";
		durn_value_updatable               ="N";
		max_durn_value_updatable			="N";
		chk_for_max_durn_action_updatable	="N" ;
		ord_auth_level_updatable			="N";
		setting_applicability_updatable	="Y";
	}

	String decode(String code)
	{
	  if(code.equalsIgnoreCase("H")) return "Hour(s)";
	  if(code.equalsIgnoreCase("D")) return "Day(s)";
	  if(code.equalsIgnoreCase("W")) return "Week(s)";
	  //Modified by Ambiga.M on 2/8/2010 for 18924
	  //if(code.equalsIgnoreCase("M") || code.equalsIgnoreCase("L")) return "Months";
	  if(code.equalsIgnoreCase("L")) return "Month(s)";
  	  if(code.equalsIgnoreCase("M")) return "Minute(s)";
	  return "";
	}

%>

<%

try
{

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode		    = request.getParameter( "mode" ) ;
	/*Enumeration enum = request.getParameterNames();
	if(enum.hasMoreElements()) {

	}*/

//	String function_id  = request.getParameter( "function_id" ) ;
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
	String order_catalog_code				= bean.checkForNull(request.getParameter("order_catalog_code" ));


	/*String long_desc						=bean.checkForNull(request.getParameter("long_desc"));

	String short_desc						=bean.checkForNull(request.getParameter("short_desc"));*/

	String order_category					= bean.checkForNull(request.getParameter("order_category"));

	String module_id						= bean.checkForNull(request.getParameter("module_id"));
	//String security_level					="";
    String qty_uom_val 						= "";

	//int size								=  0;

	String classValue = "gridData";//to Chabge class of the alternate rows


	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;

	bean.setMode( mode ) ;

	/*******MODIFY MODE********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
	{

	//headerStore
		HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();

	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();

		order_catalog_code =
		(String)orderCatalogHeaderStr.get("order_catalog_code");
		 String sqlParam[]  = {order_catalog_code.trim()};
		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			 String sql_setting = bean.checkForNull(request.getParameter("sql_setting"));
			 if(sql_setting == null || sql_setting.equals(""))
				 //sql_setting = "SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE,A.ACTION CHK_FOR_MAX_DURN_ACTION,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRG_CTG_RLE_BY_PTCL_LANG_VW A WHERE A.DRUG_CATG_CODE=? AND A.LANGUAGE_ID = ? ";
			 sql_setting = "SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE,A.ACTION CHK_FOR_MAX_DURN_ACTION,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRG_CTG_RLE_BY_PTCL_LANG_VW A WHERE A.DRUG_CATG_CODE = (SELECT PRES_CATG_CODE FROM PH_DRUG WHERE DRUG_CODE = ?) AND A.LANGUAGE_ID = ?";

			 String sqlParam1[]  = {order_catalog_code.trim(),localeName};

			 if(!sql_setting.equals("") && !sql_setting.equals("null"))
			 {
				 Hashtable defVal1 = bean.settingsDefault(sql_setting,"sql_setting",sqlParam1);
				 out.println("<input type='hidden' name='defVal1' id='defVal1' value='"+defVal1.size()+"'>");

				 defVal = bean.settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);

				 for (Enumeration en = defVal.keys() ; en.hasMoreElements() ;) 
				 {
					String key = (String)en.nextElement();
					if (defVal1.containsKey(key)) 
					{
						defVal1.remove(key);
						defVal1.put(key,defVal.get(key));
					} 
					else
					{
					//if(defVal1.equals(""))
					//{
						 //Below code is commented by Archana Dhal on 6/2/2010 related to the IN021612.			 
						 //defVal1.put(key,defVal.get(key));
					//}
			 		}
				 }
				 //ML-MMOH-SCF-2542-Start.
				 /*if(defVal1.size()!=0)
				 {
					defVal = defVal1;
				 }
				 else
				 {
					  for (Enumeration en = defVal.keys() ; en.hasMoreElements() ;) 
					 {
						String key = (String)en.nextElement();
						if (!key.equals("*A")) 
						{
							defVal.remove(key);
						} 
					 }
				 }*/ 
				 //ML-MMOH-SCF-2542-End.


				//int sizeDef = defVal.size();

				/*if(sizeDef == 0){//Allow Updation
					ord_auth_level_updatable			=  "Y";	
				}else{//UPdation chk at all particular records
				   ord_auth_level_updatable			=  "N";
				}*/
			}
		} 
		else 
		{
			defVal = bean.settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);
		}		
	}
	/***/

	/**CALLED FROM DIFFERENT MODULE IN INSERT MODE***/
	if(!module_id.equalsIgnoreCase("OR") && !mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ))
	{

		if(module_id.trim().equalsIgnoreCase("PH"))
		{

			 String sql_setting = bean.checkForNull(request.getParameter("sql_setting"));
			 String sqlParam[]  = {};


			
			if(!sql_setting.equals("") && !sql_setting.equals("null"))
			 defVal = bean.settingsDefault(sql_setting,"sql_setting",sqlParam);
			 out.println("<input type='hidden' name='defVal1' id='defVal1' value='"+defVal.size()+"'>");
			// int sizeDef = defVal.size();

			/* if(sizeDef == 0){//Allow Updation
				;
			 }else{//UPdation chk at all particular records
			 }*/

		}
	}
	/***/


	 /***GET THE STORE FOR THIS TAB***/
	ArrayList  settingsRecStr		 =  bean.getSettingsRecStr();


	/**CHARACTERISTICS VALUE*************/
	ArrayList  characteristicsRecStr =  bean.getCharacteristicsRecStr();
	String qty_reqd_yn				 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn","N");

	String freq_applicable_yn		 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn","N");


	//String qty_uom		 =	bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

	String qty_uom		 = bean.checkForNull(request.getParameter( "uom_code"));
	if(qty_uom.equals(""))
		qty_uom		 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

	String soft_stop_yn				 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"soft_stop_yn","N");

	/**/

	/**FREQUENCY APPLICABLE VALUE*******/
	ArrayList frequencyRecStr	= bean.getFrequencyRecStr();
	String frequencyFrom		= bean.getFrequencyFrom();
	/**/

	//Display logic of UOM
	 if(order_category.trim().equalsIgnoreCase("PH") || module_id.trim().equalsIgnoreCase("PH") || (!qty_uom.equals("")))
	 uom_style = "";


	/**TO LOAD FREQUENCY VALUE************/
	//String oc=((String)orderCatalogHeaderStr.get("order_catalog_code")).trim();


	bean.setSettingsFreqStr(order_category.trim(),order_catalog_code.trim());
	HashMap   settingsFreqStr		 =  bean.getSettingsFreqStr();

	Integer	noOfRecTemp				 = (Integer)settingsFreqStr.get("noRec");
	int noOfRecordsFreq				 = noOfRecTemp.intValue() ;
	/**/

	/**TO LOAD FREQUENCY VALUE************/
	bean.setSettingsAgeGroupStr();
	HashMap   settingsAgeGroupStr	 =  bean.getSettingsAgeGroupStr();
	Integer	noOfRecTempAgeGroup		 = (Integer)settingsAgeGroupStr.get("noRec");
	int noOfRecordsAgeGroup			 = noOfRecTempAgeGroup.intValue() ;
	/**/

%>
<table class='grid' width='100%'>

  <tr>
	<td class="COLUMNHEADER"  nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="eOR.ChangeQtydose.label" bundle="${or_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap style=<%=uom_style%>><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap><fmt:message key="eOR.DurnValueType.label" bundle="${or_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap><fmt:message key="eOR.MaxValueDurnType.label" bundle="${or_labels}"/></td>
    <td class="COLUMNHEADER"  nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"  nowrap style = "bottom-margin:0;display:none"><fmt:message key="Common.AuthorizationLevel.label" bundle="${common_labels}"/></td>
    <td class="COLUMNHEADER"  nowrap><fmt:message key="eOR.Msg.label" bundle="${or_labels}"/></td>
  </tr>


<tr>
   <td nowrap class='gridData' width='15%' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
   <INPUT TYPE="hidden" name="patient_class0" id="patient_class0" value="*A">


	<!--Applicability SuperSeding all the rules -->

	<%
		setting_applicability_default = "A";//for all patient Class(*A) by deafult


		if(settingsRecStr.isEmpty())
		{//Page is Visited for First Time
			if(defVal.containsKey("*A"))
			{//Some default val is there ...modify mode/called from  other module

				HashMap currRec					=(HashMap)defVal.get("*A");
				setting_applicability_default   =(String)currRec.get("setting_applicability");
				qty_uom_default					=(String)currRec.get("qty_uom");
				qty_value_default				=eHISFormatter.chkReturn((String)currRec.get("qty_value"),"0","",(String)currRec.get("qty_value"));
				freq_code_default				=(String)currRec.get("freq_code");
				age_group_code_default			=(String)currRec.get("age_group_code");
				max_durn_type_default			=(String)currRec.get("max_durn_type");
				max_durn_value_default		 	=eHISFormatter.chkReturn((String)currRec.get("max_durn_value"),"0","",(String)currRec.get("max_durn_value"));
				chk_for_max_durn_action_default	=(String)currRec.get("chk_for_max_durn_action");
				ord_auth_level_default			=eHISFormatter.chkReturn((String)currRec.get("ord_auth_level"),"0","",(String)currRec.get("ord_auth_level"));
				durn_type_default				=(String)currRec.get("durn_type");
				prompt_msg_default				=(String)currRec.get("prompt_msg");
				durn_desc_default				=(String)currRec.get("durn_desc");
				durn_value_default				=eHISFormatter.chkReturn((String)currRec.get("durn_value"),"0","",(String)currRec.get("durn_value"));
			}
		}


		String setting_applicability_chk = bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default);



		/***VALIDATION BASED ON THE CHARACTERISTICS VALUE***************/
		if(qty_reqd_yn.trim().equalsIgnoreCase("Y"))
		{
			if(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH")) 
			{
				qty_uom_updatable	= "Y";
			} 
			else 
			{
				qty_uom_updatable	= "N";
			}
			qty_value_updatable = "Y";
		}


		if(module_id.trim().equalsIgnoreCase("PH") || (!qty_uom.equals("")))
		{
			qty_uom_default = qty_uom ;
		}

		 /****/

		/**CHK FOR ACTION TAG****/
		String 	chk_for_max_durn_actionO	= bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default);

		if(chk_for_max_durn_actionO.equalsIgnoreCase("A"))
		ord_auth_level_updatable			 = "Y";
		/***/

		//CALLED FROM OTHER MODULE & VALUE IS ***NOT PASSED*** FOR PAT CLASS  THEN ONLY SETTING APPLICABILTY IS DEFAULTED TO NOT APPLICABLE IF 		defVal SIZE IS ZERO
		if(!defVal.containsKey("*A") && module_id.equalsIgnoreCase("PH")&& !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase("")) )
		{
			if(settingsRecStr.isEmpty() && defVal.size() != 0)
			{//Page is Visited for First Time
				setting_applicability_default = "X" ;
				setting_applicability_chk = "X" ;
			}
		}
		%>


		<%if(eff_status.trim().equalsIgnoreCase("D"))
		{//only in modify mode if eff_staus is disabled
			updatableIntialisation();
			setting_applicability_updatable			="N";
		}

		if(setting_applicability_updatable.trim().equalsIgnoreCase("N"))
		{
			freq_code_updatable					="N";
			age_group_code_updatable               ="N";
		}		

		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			if((defVal.size())!=0&&!defVal.containsKey("*A"))
			{
				setting_applicability_updatable="N";
			}
		}
		%>


	  <%--  <td class="gridData"><SELECT name="setting_applicability0" id="setting_applicability0"  <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%> onchange='parent.parent.parent.chkApplSetting(this,"0","<%=order_category.trim()%>");'> --%><!--ML-MMOH-SCF-2542  -->
	   <td class="gridData"><SELECT name="setting_applicability0" id="setting_applicability0"  <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","")%> onchange='parent.parent.parent.chkApplSetting(this,"0","<%=order_category.trim()%>");'><!--ML-MMOH-SCF-2542  -->
	    <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
	    <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"X")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>



		<%
		String 	max_durn_val_chk = bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_value",
		max_durn_value_default) ;


		if(!max_durn_val_chk.trim().equals("") && !setting_applicability_updatable.trim().equalsIgnoreCase("N") )
		chk_for_max_durn_action_updatable = "Y";



		//Applicability---//SuperRiding All the Roles
		if(setting_applicability_chk.trim().equalsIgnoreCase("X"))
		{//this condn over rides all the prevoius rule
			qty_value_updatable					= "N" ;
			qty_uom_updatable			        = "N" ;
			freq_code_updatable			        = "N" ;
			age_group_code_updatable	        = "N" ;
			max_durn_type_updatable		        = "N" ;
			max_durn_value_updatable            = "N" ;
			chk_for_max_durn_action_updatable   = "N" ;
			ord_auth_level_updatable			= "N" ;
		}


	%>

    <!-- AGE GROUP CODE -->

	   <%
       StringBuffer optionsAgeGroup = new StringBuffer() ;

		if(noOfRecordsAgeGroup != 0)
		{
    		for(int i=1 ; i <= noOfRecordsAgeGroup; i++)
			{

    			optionsAgeGroup.append("<option value=\""+(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"age_group_code",age_group_code_default),(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i))+">"+(String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+i)+"</option>");
    	    }
        }%>
        <td  class='<%=classValue%>' nowrap><SELECT <%=eHISFormatter.chkReturn("y",age_group_code_updatable,"","disabled")%> NAME="age_group_code0"><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
        <%=optionsAgeGroup.toString()%></SELECT></td>

   <td  class='<%=classValue%>' nowrap><input type=text name='qty_value0' id='qty_value0' size='12' maxlength='12'  class="NUMBER" onKeyPress='return(checkValid(this,event,6,5))' onBlur="quantityCheck(this);" <%=eHISFormatter.chkReturn("y",qty_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"qty_value",
	qty_value_default)%>" ></td> <%--onKeyPress="return(ChkNumberInput(this,event,5))" onBlur="OrCheckPositiveNumber(this);"--%>

   <td  class='<%=classValue%>' nowrap style=<%=uom_style%>>
   <%
  	if (order_category.equalsIgnoreCase("PH") || module_id.equalsIgnoreCase("PH"))
  		qty_uom_val = bean.getdefaultArrListValue(settingsRecStr,0,"qty_uom",qty_uom_default);
  	else
  		qty_uom_val = qty_uom_default;
	%>
   <input type=text name='qty_uom0' id='qty_uom0' size='3' maxlength='3'
   <%=eHISFormatter.chkReturn("y",qty_uom_updatable,"","disabled")%>
   value="<%=qty_uom_val%>" >
   	</td>


	<!-- FREQ CODE -->
	<%
		StringBuffer optionsFreq = new StringBuffer() ;

		/*if(noOfRecordsFreq != 0){
			for(int i=1 ; i <= noOfRecordsFreq; i++){
				if (frequencyFrom.equals("F")) {
					if ((bean.getdefaultArrListValue(frequencyRecStr,i-1,"applicable_yn","N")).equals("Y")) {
		        		optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
		        	}
		        } else {
		        	optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
		        }
			}
		}*/

		if(noOfRecordsFreq != 0)
		{


			if (frequencyFrom.equals("F")) 
			{
				for(int i=1 ; i <= noOfRecordsFreq; i++)
				{
					boolean optionFlag = false;
					String code = "";
					String desc = "";
					int applicableCount = frequencyRecStr.size();	

					if (applicableCount > 0) 
					{
						for (int j = 0; j < applicableCount; j++) 
						{
							HashMap tempHash = (HashMap)frequencyRecStr.get(j);

							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+i))) 
							{
								if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) 
								{
									
									optionFlag 	= true;
									code		= (String)tempHash.get("frequency_code");
									desc		= (String)tempHash.get("frequency_desc");
									break;
								} 
								else 
								{
									optionFlag = false;
								}
							}  
							else 
							{
								optionFlag = false;
							}
						}
					}
					if (optionFlag == true) 
					{
						optionsFreq.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),code)+">"+desc+"</option>");
					}
				}
            } 
			else 
			{
				if (mode.equals("1"))
				{

					for(int i=1 ; i <= noOfRecordsFreq; i++)
					{
						optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
					}
				}
				else
				{


					for(int i=1 ; i <= noOfRecordsFreq; i++)
					{
						boolean optionFlag = false;
						String code = "";
						String desc = "";
						int applicableCount = frequencyRecStr.size();

						if (applicableCount > 0) 
						{
							for (int j = 0; j < applicableCount; j++) 
							{
								HashMap tempHash = (HashMap)frequencyRecStr.get(j);

								if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+i))) 
								{
									if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) 
									{
										
										optionFlag 	= true;
										code		= (String)tempHash.get("frequency_code");
										desc		= (String)tempHash.get("frequency_desc");
										break;
									} 
									else 
									{
										optionFlag = false;
									}
								}  
								else 
								{
									optionFlag = false;
								}
							}
						}
						if (optionFlag == true) 
						{
							optionsFreq.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),code)+">"+desc+"</option>");
						}
					}

				}
			}
        }
	%>
	<%--<Script>alert('<%=((bean.getFrequencyFrom()).equals("F"))%>')</Script>--%>
   <td  class='<%=classValue%>' nowrap><SELECT <%=eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")%> NAME="freq_code0" onchange='parent.parent.parent.getDurnType(this,"0")'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%=optionsFreq.toString()%></SELECT></td>


	<!-- Code to Build Durn Legend -->
	<%
	String freq_codeTemp	 = bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default);
	//String durn_ValueAllTemp =
	bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default) ;
	//String durn_typeAllTemp  =
	bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default) ;
	//String durn_descAllTemp  =
	bean.getdefaultArrListValue(settingsRecStr,0,"durn_desc",durn_desc_default) ;
	String durn_legend       = "&nbsp;" ;

	if(!freq_codeTemp.trim().equals("") && freq_code_updatable.trim().equalsIgnoreCase("Y")){
	durn_value_updatable	 = "Y";
	max_durn_value_updatable = "Y";
	}
	if(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default).equals(""))
	{
		durn_value_updatable="N";
		max_durn_value_updatable = "N";
	}
	%>


    <!-- Durn Val/Durn Desc -->
 	<td  class="gridData" nowrap>
	<input type="text" name="durn_value0" id="durn_value0" size='3' maxlength='3'	class="number"	 onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkMaxDurn('0',this)" <%=eHISFormatter.chkReturn("y",durn_value_updatable,"","disabled")%>	
		<%if(optionsFreq.length()==0){%>
		value=""
		<%}else{%>			value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default)%>"
		<%}%>
>/<input type="text"   disabled name="durn_desc0" id="durn_desc0"	 size='3' 
	<%if(optionsFreq.length()==0){%>
		value=""
		<%}else{%>			value="<%=decode(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default))%>"
		<%}%>
			
		></td>
	<input type="hidden" name="durn_type0" id="durn_type0"		
		<%if(optionsFreq.length()==0){%>
		value=""
		<%}else{%>			value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default)%>"
		<%}%>>

<!-- 	<td align="center" class='<%=classValue%>' width='20%' nowrap id="durn_type_td0">&nbsp;<%=durn_legend%></td>
	<input type="hidden" name="durn_type0" id="durn_type0" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default)%>">
	<input type="hidden" name="durn_value0" id="durn_value0" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default)%>">
	<input type="hidden" name="durn_desc0" id="durn_desc0" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"durn_desc",durn_desc_default)%>"> -->

   <!-- Code for Maximum Duration Type Options-->
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

    <td  class='<%=classValue%>' ><input type=text name='max_durn_value0' id='max_durn_value0' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkEnteredMaxVal(this,'0');" <%=eHISFormatter.chkReturn("y",max_durn_value_updatable,"","disabled")%>
		<%if(optionsFreq.length()==0){%>
		value=""
		<%}else{%>value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_value",max_durn_value_default)%>"
		<%}%> ><SELECT <%=eHISFormatter.chkReturn("y",max_durn_type_updatable,"","disabled")%> NAME="max_durn_type0" onchange=''><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<%if(optionsFreq.length()!=0){%>		
		<%=optionsDurn.toString()%><%}%>
	</SELECT></td>



    <td  class='<%=classValue%>'  nowrap>
	<SELECT name="chk_for_max_durn_action0" id="chk_for_max_durn_action0"  <%=eHISFormatter.chkReturn("y",chk_for_max_durn_action_updatable,"","disabled")%>  onchange='parent.parent.parent.chkAction(this,"0")'>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>	
	<option value="W" 
	<%if(optionsFreq.length()!=0){%>		<%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"W")%> <%}%>>Warn</option>
	<option value="R"
	<%if(optionsFreq.length()!=0){%><%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"R")%> <%}%>><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
	<option value="A"
	<%if(optionsFreq.length()!=0){%>	<%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"A")%> <%}%>><fmt:message key="eOR.RequestforAuthorize.label" bundle="${or_labels}"/></option>

	</SELECT>
	</td>

	<!-- Code to Chk athu level Updation -->

    <td  class='<%=classValue%>' nowrap style = "bottom-margin:0;display:none"><input type=text name='ord_auth_level0' id='ord_auth_level0' size='1' maxlength='1'
	<%=eHISFormatter.chkReturn("y",ord_auth_level_updatable,"","disabled")%>
	onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkSecurityLevel(this)" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"ord_auth_level",
	ord_auth_level_default)%>" ></td>
	<%if(!((String)bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default)).equals("")){%>
    <td align="center" name="msg_td0" id="msg_td0" class='<%=classValue%>' nowrap><A name='msg0' HREF='javascript:parent.parent.parent.showMsgDialog("0")'><fmt:message key="eOR.Msg.label" bundle="${or_labels}"/></A></td>
	<%}else{%>
	<td align="center" name="msg_td0" id="msg_td0" class='<%=classValue%>' ></td>
	<%}%>
	<INPUT TYPE="hidden" name="prompt_msg0" id="prompt_msg0" value="<%=bean.getdefaultArrListValue(settingsRecStr,0,"prompt_msg",prompt_msg_default).trim()%>" nowrap>
  </tr>

	<%
	HashMap pat_class =	bean.getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
	Integer	noOfRecordsTemp = (Integer)pat_class.get("noRec");
	int noOfRecords   = noOfRecordsTemp.intValue() ;
	int fm_disp		  = 1 ;
	int to_disp		  = noOfRecords ;
	
%>



<!-----------RECORDS FROM DATABASE--------------------->





<INPUT TYPE="hidden" name="noOfRecords" id="noOfRecords" value="<%=noOfRecords%>">

<%
	if(noOfRecords != 0){
	for(int i=fm_disp ; i <= to_disp; i++){
		String patient_class  = (String)pat_class.get("PATIENT_CLASS"+i);
		String patient_class_short_desc  = (String)pat_class.get("SHORT_DESC"+i);
		classValue			=( (i%2)==0 )? "gridData" : "gridData";
%>



<tr>
   <td  nowrap class='<%=classValue%>'><%=patient_class_short_desc%></td>
   <INPUT TYPE="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=patient_class%>">



   <%
	/**ReInitaise for every Loop (Default&Updatables) Very IMP******/
	defaultIntialisation();
	updatableIntialisation();

	if(settingsRecStr.isEmpty())
	{//Page is Visited for First Time
	
		if(defVal.containsKey(patient_class.trim()))
		{//Some default val is there ...modify mode/called from  other module

			HashMap currRec					=(HashMap)defVal.get(patient_class.trim());
			setting_applicability_default   =(String)currRec.get("setting_applicability");
			if(setting_applicability_default.trim().equalsIgnoreCase("A"))
			{
				qty_uom_default					=(String)currRec.get("qty_uom");
				qty_value_default				=eHISFormatter.chkReturn((String)currRec.get("qty_value"),"0","",(String)currRec.get("qty_value"));
				freq_code_default				=(String)currRec.get("freq_code");
				age_group_code_default			=(String)currRec.get("age_group_code");
				max_durn_type_default			=(String)currRec.get("max_durn_type");
				max_durn_value_default			=eHISFormatter.chkReturn((String)currRec.get("max_durn_value"),"0","",(String)currRec.get("max_durn_value"));
				chk_for_max_durn_action_default	=(String)currRec.get("chk_for_max_durn_action");
				ord_auth_level_default			=(String)currRec.get("ord_auth_level");
				prompt_msg_default				=(String)currRec.get("prompt_msg");
				setting_applicability_default	=(String)currRec.get("setting_applicability");
				durn_type_default				=(String)currRec.get("durn_type");
				durn_desc_default				=(String)currRec.get("durn_desc");
				durn_value_default				=eHISFormatter.chkReturn((String)currRec.get("durn_value"),"0","",(String)currRec.get("durn_value"));
			}
		 }
	 }

     setting_applicability_chk = bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_default);


	 //CALLED FROM OTHER MODULE & VALUE IS PASSED FOR PAT CLASS THEN ONLY SETTING APPLICABILTY IS DISABLED
	if(!defVal.containsKey(patient_class.trim()) && 	  !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase("")) )
	{
		setting_applicability_updatable		= "N" ;
		setting_applicability_chk = "X" ;//Only to make other feild's disabled
	}


	if(qty_reqd_yn.trim().equalsIgnoreCase("Y"))
	{//awalys set with default value
		if(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH")) 
		{
			qty_uom_updatable	= "Y";
		} 
		else 
		{
			qty_uom_updatable	= "N";
		}
		qty_value_updatable = "Y";
	}


	/***VALIDATION BASED ON THE CHARACTERISTICS VALUE***************/
	String 	chk_for_max_durn_actionVar = bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",
    chk_for_max_durn_action_default)		;
	String ord_auth_level_updatableVar = "N";

	if(chk_for_max_durn_actionVar.equalsIgnoreCase("A"))
		ord_auth_level_updatableVar = "Y";

	qty_uom_default                     = qty_uom ;

	if(freq_applicable_yn.trim().equalsIgnoreCase("Y"))
	{//Default freq chk form other tab condn
		if(module_id.trim().equalsIgnoreCase("PH"))
			chk_for_max_durn_action_updatable	= "N" ;	 //For Pharmacy
	}
	else
	{
	}
	/****/
	
	if(eff_status.trim().equalsIgnoreCase("D"))
	{//only in mod mode if eff_staus is disabled
		 updatableIntialisation();
		 setting_applicability_updatable		="N";
	}

	if(setting_applicability_updatable.trim().equalsIgnoreCase("N"))
	{
		 freq_code_updatable					="N";
		 age_group_code_updatable				="N";
	}

	%>
	<%--<Script>alert('<%=defVal.containsKey(patient_class.trim())%>,<%=patient_class%>,<%=eff_status%>,<%=setting_applicability_updatable%>')</Script>--%>
	<%-- <td class='<%=classValue%>'><SELECT name="setting_applicability<%=i%>" id="setting_applicability<%=i%>" onchange='parent.parent.parent.chkApplSetting(this,"<%=i%>","<%=order_category.trim()%>")' <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%>>--%><!--ML-MMOH-SCF-2542  -->
	<td class='<%=classValue%>'><SELECT name="setting_applicability<%=i%>" id="setting_applicability<%=i%>" onchange='parent.parent.parent.chkApplSetting(this,"<%=i%>","<%=order_category.trim()%>")' <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","")%>><!--ML-MMOH-SCF-2542  -->
   <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_chk),"X") %>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
   <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_chk),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
   </SELECT>
   </td>



  <%

	max_durn_val_chk = bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_value",
		max_durn_value_default) ;


	if(!max_durn_val_chk.equalsIgnoreCase(""))
		chk_for_max_durn_action_updatable = "Y";



	if(setting_applicability_chk.trim().equalsIgnoreCase("X")){//this condn overrides all the prevoius rule
		qty_value_updatable					= "N" ;
		qty_uom_updatable					= "N" ;
		freq_code_updatable					= "N" ;
		age_group_code_updatable			= "N" ;
		max_durn_type_updatable				= "N" ;
		max_durn_value_updatable			= "N" ;
		chk_for_max_durn_actionVar			= "N" ;
		chk_for_max_durn_action_updatable	= "N" ;
		ord_auth_level_updatableVar			= "N" ;
		}


  %>

  <!-- This Code to get Age Group combo take care the selected values by client in prevoius visit to  the page-->

	<%

		StringBuffer optionsAgeGroupVar = new StringBuffer() ;
		if(noOfRecordsAgeGroup != 0){
		for(int j=1 ; j <= noOfRecordsAgeGroup; j++){
			optionsAgeGroupVar.append("<option value=\""+(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"age_group_code",age_group_code_default),(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+j))+">"+(String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+j)+"</option>");
	    }
	}

	%>


	<td class='<%=classValue%>' nowrap><SELECT name="age_group_code<%=i%>" id="age_group_code<%=i%>" <%=eHISFormatter.chkReturn("y",age_group_code_updatable,"","disabled")%> ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%=optionsAgeGroupVar.toString()%></SELECT></td>

  <td  class='<%=classValue%>' nowrap><input type=text name='qty_value<%=i%>' id='qty_value<%=i%>' size='12' maxlength='12'  class="NUMBER" onKeyPress='return(checkValid(this,event,6,5))' onBlur="quantityCheck(this);" <%=eHISFormatter.chkReturn("y",qty_value_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"qty_value",
  qty_value_default)%>" ></td> <%--onBlur="OrCheckPositiveNumber(this);"--%>

  <td align="center" class='<%=classValue%>' nowrap style=<%=uom_style%> >
  <%
  	if (order_category.equalsIgnoreCase("PH") || module_id.equalsIgnoreCase("PH")){
	  if(qty_uom.equals(""))
  	      qty_uom_val = bean.getdefaultArrListValue(settingsRecStr,i,"qty_uom",qty_uom_default);
	  else
		  qty_uom_val = qty_uom;

  }else
  		qty_uom_val = qty_uom_default;
	%>
  <input type=text name='qty_uom<%=i%>' id='qty_uom<%=i%>' size='3' maxlength='3' nowrap
  <%=eHISFormatter.chkReturn("y",qty_uom_updatable,"","disabled")%> value="<%=qty_uom_val%>" >
  
 </td>


<!-- This Code to get Frequency combo take care the selected values by client in prevoius visit to  the page-->

	<%

		StringBuffer optionsFreqVar = new StringBuffer() ;
		/*if(noOfRecordsFreq != 0){
			for(int j=1 ; j <= noOfRecordsFreq; j++){
				if (frequencyFrom.equals("F")) {
					if ((bean.getdefaultArrListValue(frequencyRecStr,j-1,"applicable_yn","N")).equals("Y")) {
		        		optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
		        	}
		        } else {
		        	optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
		        }
	        //optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\" "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
			}
		}*/
		if(noOfRecordsFreq != 0){
			if (frequencyFrom.equals("F")) {
				for(int indx=1 ; indx <= noOfRecordsFreq; indx++){
					boolean optionFlag = false;
					String code = "";
					String desc = "";
					int applicableCount = frequencyRecStr.size();

					if (applicableCount > 0) {
						for (int j = 0; j < applicableCount; j++) {
							HashMap tempHash = (HashMap)frequencyRecStr.get(j);


							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+indx))) {
								if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) {
									
									optionFlag 	= true;
									code		= (String)tempHash.get("frequency_code");
									desc		= (String)tempHash.get("frequency_desc");
									break;
								} else {
									optionFlag = false;
								}
							}  else {
								optionFlag = false;
							}
						}
					}
					if (optionFlag == true) {
						optionsFreqVar.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),code)+">"+desc+"</option>");
					}

				}
            } else {
            	/*for(int indx=1 ; indx <= noOfRecordsFreq; indx++){
            		optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+indx) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+indx))+">"+(String)settingsFreqStr.get("FREQ_DESC"+indx)+"</option>");
					*/
				if (mode.equals("1")){

            	for(int indx=1 ; indx <= noOfRecordsFreq; indx++){

            		optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+indx) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+indx))+">"+(String)settingsFreqStr.get("FREQ_DESC"+indx)+"</option>");

					
            	}

				}else{


					for(int indx=1 ; indx <= noOfRecordsFreq; indx++){
					boolean optionFlag = false;
					String code = "";
					String desc = "";
					int applicableCount = frequencyRecStr.size();
					
					if (applicableCount > 0) {
						for (int j = 0; j < applicableCount; j++) {
							HashMap tempHash = (HashMap)frequencyRecStr.get(j);

							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+indx))) {
								if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) {
									
									optionFlag 	= true;
									code		= (String)tempHash.get("frequency_code");
									desc		= (String)tempHash.get("frequency_desc");
									break;
								} else {
									optionFlag = false;
								}
							}  else {
								optionFlag = false;
							}
						}
					}
					if (optionFlag == true) {
						optionsFreqVar.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),code)+">"+desc+"</option>");
					}
				}

            }
		
            
            }
        }


	%>


	<td  class='<%=classValue%>' nowrap><SELECT name="freq_code<%=i%>" id="freq_code<%=i%>" <%=eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")%> onchange='parent.parent.parent.getDurnType(this,"<%=i%>")'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%=optionsFreqVar.toString()%></SELECT></td>

	<!-- Code to Build Durn Legend depending upon values Entered -->
	<%
	String freq_codeTempVar		= bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default);
	//String durn_ValueAllTempVar =
	bean.getdefaultArrListValue(settingsRecStr,i,"durn_value",durn_value_default) ;
	//String durn_typeAllTempVar  =
	bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default) ;
	//String durn_descAllTempVar  =
	bean.getdefaultArrListValue(settingsRecStr,i,"durn_desc",durn_desc_default) ;


	//String durn_legend_var       = "&nbsp;" ;

	if(!freq_codeTempVar.trim().equals("") && freq_code_updatable.trim().equals("Y")){
	durn_value_updatable	 = "Y";
	max_durn_value_updatable = "Y";
	}
	if(bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default).equals(""))
	{
		durn_value_updatable="N";
		max_durn_value_updatable = "N";
	}

	%>

	<!-- Durn Val/Durn Desc -->
 	<td nowrap class='<%=classValue%>'>
	<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" 	onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkMaxDurn('<%=i%>',this)" <%=eHISFormatter.chkReturn("y",durn_value_updatable,"","disabled")%>
		<%if(optionsFreqVar.length()==0){%>
		value=""
		<%}else{%>			value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"durn_value",durn_value_default)%>"
		<%}%>
	>/<input type="text"   disabled name="durn_desc<%=i%>" id="durn_desc<%=i%>"	 size='3' 	
		<%if(optionsFreqVar.length()==0){%>
		value=""
		<%}else{%>			value="<%=decode(bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default))%>"<%}%>> </td>
	<input type="hidden" name="durn_type<%=i%>" id="durn_type<%=i%>"
		<%if(optionsFreqVar.length()==0){%>
		value=""
		<%}else{%>			value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default)%>"<%}%>>


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

		if(module_id.trim().equalsIgnoreCase("PH"))
			chk_for_max_durn_action_updatable	= "N" ;	 //For Pharmacy

	%>

    <td  class='<%=classValue%>'>
	<input type=text name='max_durn_value<%=i%>' id='max_durn_value<%=i%>' size='3' maxlength='3' class="NUMBER"
   onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkEnteredMaxVal(this,'<%=i%>');"
	<%=eHISFormatter.chkReturn("y",max_durn_value_updatable,"","disabled")%>  
		<%if(optionsFreqVar.length()==0){%>
		value=""
		<%}else{%>value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_value",max_durn_value_default)%>"
		<%}%>
		><SELECT name="max_durn_type<%=i%>" id="max_durn_type<%=i%>" <%=eHISFormatter.chkReturn("y",max_durn_type_updatable,"","disabled")%> onchange=''><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%if(optionsFreqVar.length()!=0){%> <%=optionsDurnVar.toString()%><%}%></SELECT></td>

    <td align="center" class='<%=classValue%>' nowrap>
	<SELECT name="chk_for_max_durn_action<%=i%>" id="chk_for_max_durn_action<%=i%>"  <%=eHISFormatter.chkReturn("y",chk_for_max_durn_action_updatable,"","disabled")%>  onchange='parent.parent.parent.chkAction(this,"<%=i%>")'>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<option value="W" <%if(optionsFreqVar.length()!=0){%> <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"W")%><%}%>>Warn</option>
	<option value="R" <%if(optionsFreqVar.length()!=0){%> <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"R")%> <%}%>>Reject</option>
	<option value="A" <%if(optionsFreqVar.length()!=0){%> <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"A")%><%}%>>Request for Authorize</option>
	</SELECT></td>


	<td  class='<%=classValue%>' style="bottom-margin:0;display:none"><input type=text name='ord_auth_level<%=i%>' id='ord_auth_level<%=i%>' size='1' maxlength='1'
	onBlur="OrCheckPositiveNumber(this);parent.parent.parent.chkSecurityLevel(this)"
	<%=eHISFormatter.chkReturn("y",ord_auth_level_updatableVar,"","disabled")%>  value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"ord_auth_level",
    ord_auth_level_default)%>" ></td>
	<%if(!((String)bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default)).equals("")){%>
	<td  name="msg_td<%=i%>" id="msg_td<%=i%>" class='<%=classValue%>' >&nbsp;&nbsp;<A name='msg<%=i%>' HREF='javascript:parent.parent.parent.showMsgDialog("<%=i%>")'><fmt:message key="eOR.Msg.label" bundle="${or_labels}"/></A></td> 
	<%}else{%>
	<td  name="msg_td<%=i%>" id="msg_td<%=i%>" class='<%=classValue%>' >&nbsp;&nbsp;&nbsp;</td>
	<%}%>
	<INPUT TYPE="hidden" name="prompt_msg<%=i%>" id="prompt_msg<%=i%>" value="<%=bean.getdefaultArrListValue(settingsRecStr,i,"prompt_msg",prompt_msg_default)%>">
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

<%
	putObjectInBean(bean_id,bean,request);	
}
catch(Exception e)
{
	e.printStackTrace();
}%>
</body>
</html>

