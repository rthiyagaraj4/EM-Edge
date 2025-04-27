<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
27/03/2017	  IN063686		Raja S			27/03/2017		Ramesh G		PMG2017-GHL-CRF-0001
-----------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false" %>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>



<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/OrderSet.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--Added for IN063686-->
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>



<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='detailUpperForm' id='detailUpperForm' >
<%!
	/***DEFAULTS***********/
	String setting_applicability_default			="X";
	String age_group_code_default					="";//IN063686
	/**/

	/***UPDATABLE***********/
	String setting_applicability_updatable			="Y";
	String age_group_code_updatable					="Y";//IN063686
	/**/


	public void defaultIntialisation()	{
	 setting_applicability_default			="X";
	}

	public void updatableIntialisation(){
	  setting_applicability_updatable	="Y";
	}

%>

<%

try{

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode		  = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	//String disabled = "" ;
	String eff_status						="E";
	String order_set_code				= "";

	/**DEFAULT VALUES IN UPDATE MODE/OTHER MODULE CALLED*************/
	 Hashtable defVal						=new Hashtable();
	/**/

	defaultIntialisation();//Always intailise when the page is loaded
	updatableIntialisation();//Always intailise when the page is loaded

	CareSetBean bean = (CareSetBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);

	//int size								=  0;

	String classValue = "gridData";//to Chabge class of the alternate rows


	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;
	bean.setMode( mode ) ;

	/*******MODIFY MODE********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {


	//headerStore
	HashMap careSetHeaderStr =	bean.getCareSetHeaderStr();



	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)careSetHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();

		order_set_code =
		(String)careSetHeaderStr.get("order_set_code");
		 String sqlParam[]  = {order_set_code.trim()};

		defVal = bean.settingsDefault("SQL_OR_ORDERSET_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);
	}
	/***/
	/***GET THE STORE FOR THIS TAB***/
	ArrayList  settingsRecStr		 =  bean.getSettingsRecStr();
	/**/
	/*******<!--Added for IN063686-->*******/ 
	bean.setSettingsAgeGroupStr();
	HashMap   settingsAgeGroupStr	 =  bean.getSettingsAgeGroupStr();
	Integer	noOfRecTempAgeGroup		 = (Integer)settingsAgeGroupStr.get("noRec");
	int noOfRecordsAgeGroup			 = noOfRecTempAgeGroup.intValue() ;
	/*<!--Added for IN063686-->*/
%>

<table class='grid' width='95%'>

  <tr>
	<th class=columnheader align="left"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<th class=columnheader align="left"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
	<th class="columnheader" align="left"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td><!--Added for IN063686 -->
  </tr>


<tr>
   <td  class='gridData' width='20%' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
   <INPUT TYPE="hidden" name="patient_class0" id="patient_class0" value="*A">
<%
	setting_applicability_default = "A";//for all patient Class(*A) by deafult

	if(settingsRecStr.isEmpty()){//Page is Visited for First Time
			if(defVal.containsKey("*A")){//Some default val is there ...modify mode/called from  other module
				HashMap currRec					=(HashMap)defVal.get("*A");
				setting_applicability_default   =(String)currRec.get("setting_applicability");
				age_group_code_default =(String)currRec.get("age_group_code");//Added for IN063686
			}
	}

	   String setting_applicability_chk = bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default);
	%>

		<%if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
		 updatableIntialisation();
		 setting_applicability_updatable		= "N";
		}
		%>
	   <!--<td class='gridData' width='20%'><SELECT name="setting_applicability0" id="setting_applicability0"  <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%> onchange=''> Commented for IN063686-->
	   <td class='gridData' width='20%'><SELECT name="setting_applicability0" id="setting_applicability0"  <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%> onchange='chkApplSetting(this,"0");'> <!--Modified for IN063686-->
	    <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
	    <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"X")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
	<!-- AGE GROUP CODE -->
	<!-- IN063686 Starts--->
	   <%
		if((!"A".equals(setting_applicability_chk))||("D".equals(eff_status)))
			age_group_code_updatable="N";
		else
		age_group_code_updatable="Y";

		StringBuffer optionsAgeGroup = new StringBuffer() ;
		if(noOfRecordsAgeGroup != 0)
		{
    		for(int i=1 ; i <= noOfRecordsAgeGroup; i++)
			{
    			optionsAgeGroup.append("<option value=\""+(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"age_group_code",age_group_code_default),(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i))+">"+(String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+i)+"</option>");
    	    }
        }%>
        <td  class='gridData' nowrap>
			<SELECT <%=eHISFormatter.chkReturn("y",age_group_code_updatable,"","disabled")%> NAME="age_group_code0" id="age_group_code0">
				<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%=optionsAgeGroup.toString()%>
			</SELECT>
		</td>
	<!-- IN063686 Ends--->
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
		String patient_class="";
		String patient_class_short_desc="";
		HashMap currRec	=null;
		for(int i=fm_disp ; i <= to_disp; i++){
			patient_class  = (String)pat_class.get("PATIENT_CLASS"+i);
			patient_class_short_desc  = (String)pat_class.get("SHORT_DESC"+i);
			classValue			=( (i%2)==0 )? "gridData" : "gridData";
			%>
			<tr>
				<td width='50%'  class='<%=classValue%>'><%=patient_class_short_desc%></td>
				<INPUT TYPE="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=patient_class%>">

				<%
				/**ReInitaise for every Loop (Default&Updatables)******/
				defaultIntialisation();
				updatableIntialisation();
				age_group_code_default=""; // Added for IN063686 

				if(settingsRecStr.isEmpty()){//Page is Visited for First Time
					if(defVal.containsKey(patient_class.trim())){//Some default val is there ...modify mode/called from  other module
						currRec					=(HashMap)defVal.get(patient_class.trim());
						setting_applicability_default   =(String)currRec.get("setting_applicability");
						age_group_code_default =(String)currRec.get("age_group_code");//Added for IN063686
					}
				}
				setting_applicability_chk = bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_default);
				if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
					updatableIntialisation();
					setting_applicability_updatable		= "N";
				}
				%>
			   <!--<td class='<%=classValue%>'><SELECT name="setting_applicability<%=i%>" id="setting_applicability<%=i%>" onchange='' <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%>>  //Commented for IN063686 -->
			   <td class='<%=classValue%>'><SELECT name="setting_applicability<%=i%>" id="setting_applicability<%=i%>" onchange='chkApplSetting(this,"<%=i%>");' <%=eHISFormatter.chkReturn("y",setting_applicability_updatable,"","disabled")%>> <!--Modified for IN063686 -->
			   <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_chk),"X") %>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			   <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_chk),"A")%>><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
			   </SELECT>
			   </td>
		   
				<!--IN063686 changes starts-->
				<%
				StringBuffer optionsAgeGroupVar = new StringBuffer() ;
				if(noOfRecordsAgeGroup != 0){
					for(int j=1 ; j <= noOfRecordsAgeGroup; j++){
						optionsAgeGroupVar.append("<option value=\""+(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"age_group_code",age_group_code_default),(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+j))+">"+(String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+j)+"</option>");
					}
				}
				if((!"A".equals(setting_applicability_chk))||("D".equals(eff_status)))
					age_group_code_updatable="N";
				else
					age_group_code_updatable="Y";
				%>


				<td class='<%=classValue%>' nowrap><SELECT name="age_group_code<%=i%>" id="age_group_code<%=i%>" <%=eHISFormatter.chkReturn("y",age_group_code_updatable,"","disabled")%> ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%=optionsAgeGroupVar.toString()%></SELECT></td>
				<!--IN063686 changes Ends-->
			</tr>
		<%	
		}
	}%>
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tabType" id="tabType" value="Se">

</form>

<%
putObjectInBean(bean_id,bean,request);	
}catch(Exception e){
	e.printStackTrace();
}%>
</body>
</html>

