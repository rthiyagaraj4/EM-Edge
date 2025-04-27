<!DOCTYPE html>
<%
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
10/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCA.*" %>
<%
	try{    
		request.setCharacterEncoding("UTF-8");

		String facilityId = (String) session.getValue( "facility_id" );
		String loginUser  = (String) session.getValue( "login_user" );
		String locale = (String)session.getAttribute("LOCALE");		
		
		String operId = "";
		EncSummGroup summGrpDetails = new EncSummGroup();
		
		List<LoginUserBean> oLoginUserList = null;
		LoginUserBean sLoginUserBean = null;		
		int nListSize = 0;	 
		
		oLoginUserList = new ArrayList<LoginUserBean>();
		sLoginUserBean = new LoginUserBean();
		
		sLoginUserBean.setRequest(request);		
		sLoginUserBean.setsFacilityID(facilityId);
		sLoginUserBean.setsLoginUserId(loginUser);
		
		oLoginUserList = summGrpDetails.getLoginOperID(sLoginUserBean);		
		
		nListSize = oLoginUserList.size();
		if (nListSize>0){
			for (int i=0;i<nListSize;i++){
				sLoginUserBean = oLoginUserList.get(i);
				operId = sLoginUserBean.getsOperStnID();
			}
		}		
		
		StringBuffer sql =new StringBuffer();
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		String cdate = dateFormat.format(new java.util.Date());
        
		String cdate_display=DateUtils.convertDate(cdate,"DMY","en",locale);
		String loctype="";
		String loctypedesc="";
		
		int patient_id_length = 12;		
		
		// Gets the Specialty Master List
		List<SpecialityMasterBean> oSpecialtyMasterList = null;
		SpecialityMasterBean sSpecialtyMasterBean = null;
		String sSpecialtyMaster = "";
		int nSpecialtyListSize = 0;	 
		
		oSpecialtyMasterList = new ArrayList<SpecialityMasterBean>();
		sSpecialtyMasterBean = new SpecialityMasterBean();
		
		sSpecialtyMasterBean.setRequest(request);
		sSpecialtyMasterBean.setsLocale(locale);
		sSpecialtyMasterBean.setsFacilityId(facilityId);
		sSpecialtyMasterBean.setsLoginId(loginUser);
		sSpecialtyMasterBean.setsOperStnId(operId);
		oSpecialtyMasterList = summGrpDetails.getSpecialtyMaster(sSpecialtyMasterBean);		
		
		nSpecialtyListSize = oSpecialtyMasterList.size();
		if (nSpecialtyListSize>0){
			for (int i=0;i<nSpecialtyListSize;i++){
				sSpecialtyMasterBean = oSpecialtyMasterList.get(i);
				sSpecialtyMaster = sSpecialtyMaster + "<Option value="+sSpecialtyMasterBean.getsSpecialtyCode()+">" +sSpecialtyMasterBean.getsSpecialtyShortDesc()+ "</option>";
			}
		}
		
		// Gets the Location Type List
		List<LocationTypeMasterBean> oLocationTypeList = null;
		LocationTypeMasterBean sLocationTypeBean = null;
		String sLocationType = "";
		nListSize = 0;		

		oLocationTypeList = new ArrayList<LocationTypeMasterBean>();
		sLocationTypeBean = new LocationTypeMasterBean();
		
		sLocationTypeBean.setRequest(request);
		sLocationTypeBean.setsLocale(locale);
		oLocationTypeList = summGrpDetails.getLocationTypeMaster(sLocationTypeBean);		
		
		nListSize = oLocationTypeList.size();
		if (nListSize>0){
			for (int i=0;i<nListSize;i++){
				sLocationTypeBean = oLocationTypeList.get(i);
				sLocationType = sLocationType + "<Option value="+sLocationTypeBean.getsLocationType()+">" +sLocationTypeBean.getsLocationShortDesc()+ "</option>";
			}
		}
%>

<html>
	<head>
	   
	   
	   	<%
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link href="../../eCommon/html/<%=sStyle%>" rel='stylesheet' ></link>		 		
		<link href="../../eCA/Kendo/styles/kendo.common.min.css" rel='stylesheet' />
		<link href="../../eCA/Kendo/styles/kendo.blueopal.min.css" rel='stylesheet' />
		<!-- <link href="../../eCA/Kendo/styles/kendo.default.min.css" rel='stylesheet' />-->
		
		<script src="../../eCommon/js/FieldFormatMethods.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
		<script src="../../eCA/js/EncSummBulkPrint.js"></script>
	   	<script src="../../eOP/js/OPPractitionerComponent.js"></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../../eCA/Kendo/js/kendo.all.min.js"  type="text/javascript"></script>	
		<script src="../../eCA/js/ES_Kendo.js"  type="text/javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<body onLoad="document.forms[0].Qspeciality.focus(); " onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
	<form name="BulkPrintHeaderForm" id="BulkPrintHeaderForm">   
		<table cellpadding='5' cellspacing='0' width='98%' border='1' RULES=NONE FRAME=BOX>
			<tr>
				<td  class='label'  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td  class='Fields'>
					<select name='Qspeciality' id='Qspeciality' onChange="clearList()">
						<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>					
						<%=sSpecialtyMaster%>
					</select>
				</td>					
				<td   class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
				<td  class='Fields' nowrap>
					<select name="Qloctype" id="Qloctype" onChange="clearList()">
						<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>	
						<%=sLocationType%>								
					</select>
				</td>
				<td class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='Fields' >
					<INPUT TYPE="text" name="Qloc1" id="Qloc1"  onBlur="onBlurgetLoc('<%=loginUser%>','<%=operId%>','<%=facilityId%>',document.forms[0].Qloctype.value,document.forms[0].Qloc1)">
					<input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=loginUser%>','<%=operId%>','<%=facilityId%>',document.forms[0].Qloctype.value,document.forms[0].Qloc1)" >
					<input type="hidden" name="Qloc" id="Qloc">				
				</td>
			</tr>			
			<tr>	
			   	<td   class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				<td  class='Fields' >
					<input type="text" name="pract_name" id="pract_name" maxlength="30" size="25" onBlur="callGetPractitioner(document.forms[0].pract_butt,pract_name)">
					<input type="button" name="pract_butt" id="pract_butt" value="?" class="button" onClick="callGetPractitioner(this,pract_name)" >
					<input type="hidden" name="Qpr" id="Qpr" value="">
				</td>
				<td   class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td  class='Fields' colspan=3 >
					<input type='text' name='Qdate' id='Qdate'  id='appt_from_dt'   SIZE='10' maxlength='10' value='<%=cdate_display%>' onBlur="validDateObj(this,'DMY',localeName);">
					<img id='imgdate'  src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].Qdate.select();return showCalendar('Qdate','','','');" tabindex='-1' ></img>
				</td>
	        </tr>
			<tr>
				<td   class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td  class='Fields'><input type="text" name="Qpatientid" id="Qpatientid" size="<%=patient_id_length%>" maxlength="<%=patient_id_length%>" onBlur="ChangeUpperCase(this);">
				</td>
			   	<td   class='label' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td  class='Fields'>
					<input type="text" name="Qencid" id="Qencid" size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumberEntry(this);">
				</td>	
				<td  class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td  class='Fields'>
					<select name='Qgender' id='Qgender' onChange="">
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select>
				</td>				
			</tr>
		
			<tr>
				<td align='right' colspan=2></td>
				<td align='right' colspan=2></td>
				<td align='center' colspan=2>
					<input type='button' class='button' name='search' id='search' id='search'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' 
												onclick="SearchPatientEncounters();"> &nbsp;&nbsp;
					<input type='button' class='button' name='clear' id='clear' id='clear'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' 
												onclick="ClearValues();">&nbsp;&nbsp;				
					<input type='button' class='button' name='print' id='print' id='print'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' 
												onclick="createProgressBar();">
				</td>
			</tr>	
	   	</table>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityId%>'>
		<input type='hidden' name='loginuser' id='loginuser' value='<%=loginUser%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>	    		
		<div class="demo-section" id="demo">
	        <div id="progressBar"></div>        
	    </div>	
	</form>
	<script>		
	 	$("#print").click(function () {
	        if (!$(this).hasClass("k-state-disabled")) {
	            $(this).addClass("k-state-disabled");
	            PrintSummary();            
	        }
	    });
	 	
	 	function createProgressBar() {
	 		var pb = $("#progressBar").data("kendoProgressBar");

	 		if (pb != null ){				
				$("#progressBar").data("kendoProgressBar").destroy();
				$("#demo").empty().append("<div id='progressBar'></div>");				
			}
			$("#progressBar").kendoProgressBar({
	            min: 0,
	            max: parent.patientArray.length,
	            type: "percent",
	            change: onChange,
	            complete: onComplete,
	            enable: false

	        });
			
		}	

	    function onChange(e) {
	        
	    }

	    function onComplete(e) {
	    	alert("Printing Completed");
	        $("#print").removeClass("k-state-disabled");        
	    }
	    
	</script>
	<style scoped>
        #progressBar {
        	margin-top: 10px;
            width: 440px;
            margin-bottom: 10px;
        }  
        .demo-section {
            width: 100%;
            text-align: center;
        }
              
    </style> 
	</body>
	
</html>
<%    
   }catch(Exception e) {
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}    
   %>

