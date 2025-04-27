<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>


<head>
	
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
<!--   <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
  <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
  <script language="javascript" src="../../eMP/js/PatEncBanner.js"></script>
   <!--Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->
  <script language='javascript' src='../../eMR/js/AllergenLookup.js'></script>

  <script>
 function enable_Allergy(obj,allergen_code){
	 document.forms[0].reaction_code.value=" ";
	 document.forms[0].reaction.value="";
	 document.forms[0].allergen_code.value=document.forms[0].allergen.value;
	 document.forms[0].reaction_code.value=document.forms[0].reaction.value;
	

  }
  
  function serach_Allergy(){
	   	//parent.frames[1].document.forms[0].all.header_part.style.display="visible";
	  	var eventType=document.getElementById("eventType").value;
	  	var allergen=document.getElementById("allergen").value;
	  	var status=document.getElementById("status").value;
	  	var reaction=document.getElementById("reaction").value;
	  	var PatientId=document.getElementById("PatientId").value;

	  	var allergen_code=document.getElementById("allergen_code").value;
	  	var reaction_code=document.getElementById("reaction_code").value;
	   
	  	/* if(eventType == "" )
			{
			
	   	}*/
	  	//search(eventType,allergen,status,reaction)
	  	var sPhInstalled_YN=document.getElementById("sPhInstalled_YN").value; // Modified against TTM-SCF-0107 - Passing phInstalled Parameter
	  	var url="../../eMR/jsp/RecordPatientAdverseEvent4.jsp?modeResult=result&reac_code_val="+reaction_code+"&eventType_val="+eventType+"&allergen_val="+allergen_code+"&status_val="+status+"&PatientId="+PatientId+"&allergen_desc="+allergen+"&reaction_desc="+reaction+"&norecord=noreords&sPhInstalled_YN="+sPhInstalled_YN;
		parent.resultpage1.location.href=url;
  }

  /*Modified by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
  function   search_result_blr(obj,target){
	  if(obj.value!=""){
			var facility_id = document.getElementById("facility_id").value;
			var isExtGenericAppl = document.getElementById("isExtGenericAppl").value;
			var eventType = document.getElementById("eventType").value;
			var sPhInstalled_YN = document.getElementById("sPhInstalled_YN").value;
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH facility_id=\""+facility_id+"\" action='getDrugCnt'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var drug_cnt = trimString(responseText);

			if(eventType =='DA' && drug_cnt > 0 && sPhInstalled_YN == "Y" && isExtGenericAppl == "true")
			{
				callAllergenSearch(obj,target);
			}else
			{
				search_result(obj,target);
			}
	  }
  }

  /*Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
  function invokeAllergenLookup(obj,target)
  {
	var facility_id = document.getElementById("facility_id").value;
	var isExtGenericAppl = document.getElementById("isExtGenericAppl").value;
	var eventType = document.getElementById("eventType").value;
	var sPhInstalled_YN = document.getElementById("sPhInstalled_YN").value;
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH facility_id=\""+facility_id+"\" action='getDrugCnt'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var drug_cnt = trimString(responseText);

	if(eventType =='DA' && drug_cnt > 0 && sPhInstalled_YN == "Y" && isExtGenericAppl == "true")
	{
		callAllergenSearch(obj,target);
	}else
	{
		search_result(obj,target);
	}
  }

  async function callAllergenSearch(obj,target){
 		var eventType = document.getElementById("eventType").value
		var retVal = new String();
		var locale = document.getElementById("locale").value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target = "";
		var sql = "";

		 if((document.getElementById("eventType").value!=null)&&(document.getElementById("eventType").value!=''))
		 {
				
			var sql = "SELECT a.generic_id code, a.generic_name description, b.thirdparty_type thirdparty_type FROM ph_generic_name_lang_vw a, ph_generic_ext_prod_ref b WHERE a.generic_id = b.generic_id AND UPPER (a.generic_id) LIKE UPPER (?) AND UPPER (LTRIM (a.generic_name, '*')) LIKE UPPER (?) AND UPPER (b.thirdparty_type) LIKE UPPER (?) AND a.eff_status = 'E' AND b.eff_status = 'E' AND b.product_id = 'CIMS' AND a.language_id = '"+locale+"'";
				
			argumentArray[0] = sql ;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = document.getElementById("allergen").value;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ;
			
			var arr=new Array();

			retVal = await AllergenLookup(getLabel("eMR.ExtGenLinkLookup.label","MR"), argumentArray);

			if (retVal != null && retVal != '' && retVal != "null")
			{
				var retVal=unescape(retVal);
				arr=retVal.split(",");
				document.getElementById("allergen").value=arr[1];
				document.getElementById("allergen_code").value=arr[0];
				document.getElementById("reaction").disabled=false;
				document.getElementById("reaction_dec").disabled=false;
			}else
			{
				document.getElementById("allergen").value="";
				document.getElementById("allergen_code").value="";
				document.getElementById("reaction").disabled=true;
				document.getElementById("reaction_dec").disabled=true;
			}
				document.getElementById("reaction").value="";
				document.getElementById("reaction_code").value="";
		}
  }
  /*End GHL-CRF-0614.1*/

 async  function search_result(obj,target){
 
			var eventType=document.getElementById("eventType").value
		
			var retVal = 	new String();
			var locale= document.getElementById("locale").value;

		 var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var sql="";

		 if((obj.name=="drug_search"||obj.name=="allergen")&&(document.getElementById("eventType").value!=null)&&(document.getElementById("eventType").value!=''))
			{
				
				if(eventType =='DA' )
				{
				 
				// sql="select code, description from (SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW UNION select ALLERGEN_CODE code, LONG_DESC || '**' description  from  MR_ALLERGEN_LANG_VW  where  LANGUAGE_ID='"+locale+"' and ADV_EVENT_TYPE_CODE='"+eventType+"') where upper(code) like upper(?) and upper(ltrim(description,'*')) like upper(?) ";
				// sql="select code, description from (SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW UNION select ALLERGEN_CODE code, LONG_DESC || '**' description  from  MR_ALLERGEN_LANG_VW  where  LANGUAGE_ID='"+locale+"') where upper(code) like upper(?) and upper(ltrim(description,'*')) like upper(?) "; 
					//sql = "select GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW LANGUAGE_ID='"+locale+"' and upper(GENERIC_ID) like upper(?) and upper(GENERIC_NAME) like upper(?)";
					
				//Above SQL is changed to remove ** for against TTM-SCF-0107 - Start
				var sPhInstalled_YN=document.getElementById("sPhInstalled_YN").value;
				var sql ="";
				if(sPhInstalled_YN == "Y")
					sql="SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW WHERE upper(generic_id) like upper(?) AND upper(ltrim(generic_name,'*')) like upper(?) AND EFF_STATUS='E' AND language_id = '"+locale+"'";
				else
					sql = "select ALLERGEN_CODE code, LONG_DESC description  from  MR_ALLERGEN_LANG_VW  where upper(ALLERGEN_CODE) like upper(?) AND upper(ltrim(LONG_DESC,'*')) like upper(?) AND LANGUAGE_ID='"+locale+"'  AND EFF_STATUS='E' ";
				//Modified against TTM-SCF-0107 - end	
				}else
				{
				//sql  = "select ALLERGEN_CODE code ,LONG_DESC description  from  MR_ALLERGEN_lang_vw where language_id='"+locale+"' and ADV_EVENT_TYPE_CODE = '"+eventType+"' AND upper(ALLERGEN_CODE) like upper(?) and upper(LONG_DESC) like upper(?)";
				//sql  = "select ALLERGEN_CODE code ,LONG_DESC description  from  MR_ALLERGEN_lang_vw where language_id='"+locale+"'  AND upper(ALLERGEN_CODE) like upper(?) and upper(LONG_DESC) like upper(?)";

				sql  = "select b.ALLERGEN_CODE code ,b.LONG_DESC description  from  MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b, MR_ADV_EVENT_TYPE c where  c.ADV_EVENT_TYPE_CODE='"+eventType+"' and b.language_id='"+locale+"' and b.ADV_EVENT_TYPE_IND=a.ADV_EVENT_TYPE_IND  and c.ADV_EVENT_TYPE_CODE = b.ADV_EVENT_TYPE_CODE and upper(b.ALLERGEN_CODE) like upper(?) and upper(b.LONG_DESC) like upper(?)   Order by b.LONG_DESC ";
				}
				

			argumentArray[0] = sql ;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = document.getElementById("allergen").value;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ;
			//alert(argumentArray[4]);
			//alert(argumentArray[5]);
			var arr=new Array();
			if(eventType =='DA' ){  
			 retVal = await CommonLookup( getLabel("Common.GenericNameLookup.label","Common"), argumentArray );
			}
			else{
			retVal = await CommonLookup( getLabel("eMR.Allergen.label","MR"), argumentArray );
			}
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			document.getElementById("allergen").value=arr[1];
			document.getElementById("allergen_code").value=arr[0];
			document.getElementById("reaction").disabled=false;
			document.getElementById("reaction_dec").disabled=false;
			
		}else
		{
			document.getElementById("allergen").value="";
			document.getElementById("allergen_code").value="";
			document.getElementById("reaction").disabled=true;
			document.getElementById("reaction_dec").disabled=true;
		}
			document.getElementById("reaction").value="";
			document.getElementById("reaction_code").value="";
		
			}

	
	if((obj.name=="reaction_dec"||obj.name=="reaction")&&(document.getElementById("allergen_code").value!=null)&&(document.getElementById("allergen_code").value!='')&&(document.getElementById("allergen").value!=null)&&(document.getElementById("allergen").value!=''))
			{
				
			var allergen=document.getElementById("allergen_code").value;
			sql="select distinct (a.REACTION_CODE) code,a.LONG_DESC description from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b  where a.REACTION_CODE=b.ADV_REAC_CODE and b.ALLERGEN_CODE='"+allergen+"' and a.language_id='"+locale+"' and a.eff_status='E' and upper(a.REACTION_CODE) like upper(?) and upper(a.LONG_DESC) like upper(?) ";
			argumentArray[0] = sql ;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = document.getElementById("reaction").value;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ; 
			var arr=new Array();
			retVal = await CommonLookup(getLabel("eMR.ReactionSearch.label","mr"), argumentArray );
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");

			document.getElementById("reaction").value=arr[1];
			document.getElementById("reaction_code").value=arr[0];
			
		}else
		{
			document.getElementById("reaction").value="";
			document.getElementById("reaction_code").value="";
		}
		
			}


  }
function clear_serach_Allergy()
{
	document.getElementById("eventType").value="";
	document.getElementById("allergen").value="";
	document.getElementById("status").value="A";
	document.getElementById("reaction").value="";
	//10/14/2008
	document.getElementById("allergen_code").value=document.getElementById("allergen").value;
	document.getElementById("reaction_code").value=document.getElementById("reaction").value;
	//10/14/2008
	//parent.frames[1].location.href = '../../eCommon/html/blank.html';
	//parent.frames[1].location.reload();
	if(parent.window[1].document.chk_val.max_record.value != '0')
	{
		var url="../../eMR/jsp/RecordPatientAdverseEvent4.jsp?load=load";
		parent.frames[1].location.href=url;
		clearAll()
	}

}
function clearAll(){
document.getElementById("allergen").disabled=true;
document.getElementById("reaction").disabled=true;
document.getElementById("drug_search").disabled=true;
document.getElementById("reaction_dec").disabled=true;
serach_Allergy();

}
function populate_AR(obj){
	var adv_evnt_code1=obj.value;

	if(adv_evnt_code1 !=""){
		
		document.getElementById("allergen").value="";
		
		document.getElementById("reaction").value="";
		document.getElementById("allergen").disabled=false;
		document.getElementById("reaction").disabled=true;
		document.getElementById("drug_search").disabled=false;
		document.getElementById("reaction_dec").disabled=true;
		document.getElementById("status").value="A";
		document.getElementById("allergen_code").value=document.getElementById("allergen").value;
		document.getElementById("reaction_code").value=document.getElementById("reaction").value;

	}
	else{
		
		document.getElementById("allergen").value="";
		document.getElementById("reaction").value="";
		document.getElementById("allergen").disabled=true;
		document.getElementById("reaction").disabled=true;
		document.getElementById("drug_search").disabled=true;
		document.getElementById("reaction_dec").disabled=true;
		document.getElementById("status").value="A";
		
	}
	

}
function clear_reaction(obj){
	
	if(obj.value=="")
		document.getElementById("reaction_code").value="";
}
function clear_allergy(obj){
	if(obj.value==""){
		document.getElementById("reaction").value="";
		document.getElementById("reaction").disabled=true;
		document.getElementById("reaction_dec").disabled=true;
		document.getElementById("reaction_code").value="";
		document.getElementById("allergen_code").value="";

	}
}

  </script>
  

</head>
<%
	//String sel="";
	String Encounter_Id=request.getParameter("Encounter_Id");
	String sPhInstalled_YN = request.getParameter("sPhInstalled_YN"); //against TTM-SCF-0107
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String CA=request.getParameter("CA")==null?"":request.getParameter("CA");
	String allergy_conf_reqd_yn=request.getParameter("allergy_conf_reqd_yn")==null?"N":request.getParameter("allergy_conf_reqd_yn");
	Connection con = ConnectionManager.getConnection(request);
	 ResultSet rs = null;
	Statement stmt = null;
	String PatientId=" ";

	Boolean isExtGenericAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_THIRDPARTY_TYPE_APPL");//Added by Ashwini on 13-May-2020 for GHL-CRF-0614.1

	try{
		 PatientId=request.getParameter("PatientId");
		if(PatientId ==null) PatientId="";
		//out.println("<script>alert(\""+PatientId+"\");</script>");
		stmt=con.createStatement();
%>

  <body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 


	<%
	if(!CA.equals("Y")){
		  %>
		 <table border="0" cellpadding="0" cellspacing="0" align='center' width="100%" >
		 <jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Facility_Id" value="<%=facility_id%>"/>
		<jsp:param name="EncounterId" value="<%=Encounter_Id%>"/>
		</jsp:include> </table><%}
	%><form name = 'record_patientAdverse' >
	<input type='hidden' name = 'sPhInstalled_YN' id= 'sPhInstalled_YN' value='<%=sPhInstalled_YN%>'> <!-- against TTM-SCF-0107 -->
	<%/* Added for the CRF - RUT-CRF-0064 -- Begin*/
	if(allergy_conf_reqd_yn.equals("Y")){ %>
		<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%" >
		<th align='left' color='#000066'  nowrap><b><font color = 'black'><fmt:message key="eMR.AllergyConfirmation.label" bundle="${mr_labels}"/></font></b></th> </table>
		 <br>
		 <table border="0">
		 <tr>
		 <td  class='label' width='250px'><fmt:message key="eMR.PatientDrugAllergy.label" bundle="${mr_labels}"/>
		 </td>
		 <td  class='label' width="3px">
	  <fmt:message key="Common.yes.label" bundle="${common_labels}"/>
	  </td>
	  <td width="3px"><input type="radio" id="Allergy_Yes" name="AllergyYes" id="AllergyYes" onclick="checkAllergyYes(this);"/></td>
	  
	  <!-- <td>&nbsp;</td> -->
	  <td  class='label' width="3px"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
	  </td>
	  <td width="50px"><input type="radio" id="Allergy_No" name="AllergyNo" id="AllergyNo" checked onclick="checkAllergyNo(this);"/><img src='../../eCommon/images/mandatory.gif' align='center' id='adv_code' ></img></td>
	  
		 </tr></table>
		  <input type="hidden" name="AllergyConfirmYN" id="AllergyConfirmYN" value="N"/>
		  
		 <%}/*Added for the CRF - RUT-CRF-0064 -- End*/
	if(!CA.equals("Y")){
		  %>
		<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%" >
		<th align='left' color='#000066'  nowrap><b><font color = 'black'><fmt:message key="eMR.AdverseEvents.label" bundle="${mr_labels}"/></font></b></th> </table>
		 <br>
		 <% }
	  %>
	  

	<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
	<th align='left'  nowrap><fmt:message key="eMR.AdeverseEventsAllgSens.label" bundle="${mr_labels}"/></th>
	</table>


	<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
	<th align='left' nowrap><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
	</table>


	<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
		<tr>
			<td class='label' width='10%' ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/>
			</td>

			<td class='fields'  width='10%' >
			<select name='eventType' id='eventType' onchange='populate_AR(this)'>
			<option value=''  align=center>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%
			
						String sql1="Select long_desc ,ADV_EVENT_TYPE_CODE  from MR_ADV_EVENT_TYPE_LANG_VW where language_id='"+locale+"' and EFF_STATUS='E'";
						rs=stmt.executeQuery(sql1);
						if(rs !=null)
							{
								while(rs.next())
								{
									String adv_event_code=rs.getString("ADV_EVENT_TYPE_CODE");
									String adv_event_code_desc=rs.getString("long_desc");
									out.println("<option value='"+adv_event_code+"'>"+adv_event_code_desc);
								}
							}
							%>
							</select>
							<%
	}
	catch(Exception e)
		{
			//out.println("exp :" +e);
			e.printStackTrace();
		}
		finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }

			%>
			<input type='hidden' name='event_type' id='event_type' value=''>
	</td>
			
			<td   class='label' width='10%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/>
			</td>
			<!-- onBlur='enable_Allergy(this,allergen_code)' -->
			
			<td class='fields' width='15%'>
			<input type='text' name='allergen' id='allergen' size='15' maxlength='30' disabled onBlur='search_result_blr(this,allergen);clear_allergy(this)' ><input type='button' class='BUTTON' name='drug_search' id='drug_search' value='?' class='button'  onClick='invokeAllergenLookup(this,allergen)' disabled><input type='hidden' name='allergen_code' id='allergen_code' value=''></td>

			

			

			<td class='label' width='10%'>
			<fmt:message key="Common.status.label" bundle="${common_labels}"/> </td>

			<td class='fields' width="5%">
			<SELECT name="status" id="status" value=' '>
			
			<option value='A' selected><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
			<option value='E'><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
			<option value='R'><fmt:message key="Common.Resolved.label" bundle="${common_labels}"/></option>
			<option value='L'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			</SELECT><input type='hidden' name='status_code' id='status_code' value=''>
			</td>

			<td class='label' width='10%'>
			<fmt:message key="Common.Reaction.label" bundle="${common_labels}"/>
			

			 <td class='fields' width='15%'>
			<input type='text' name='reaction' id='reaction' disabled onBlur='search_result_blr(this,reaction);clear_reaction(this)'  size='15' maxlength='40'><input type='button' class='BUTTON' name='reaction_dec' id='reaction_dec' value='?' class='button' onClick='search_result(this,reaction)'  disabled><input type='hidden' name='reaction_code' id='reaction_code' value=''></td>
			
		</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='5%' align='right' 	id='allbuttons'>


 <td class='white' width='88%'> <input type='button' name='close' id='close' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='serach_Allergy()'>
	  </td>
	  <td class='white' width='2%'>&nbsp;</td>
	  <td class='white' width='10%'>
	  <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='clear_serach_Allergy()'></td>
</tr>
</table>

<input type="hidden" name="locale" id="locale" value ='<%=locale%>'>
<input type="hidden" name="PatientId" id="PatientId" value ='<%=PatientId%>'>
<!--Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->
<input type="hidden" name="facility_id" id="facility_id" value ='<%=facility_id%>'>
<input type="hidden" name="isExtGenericAppl" id="isExtGenericAppl" value ='<%=isExtGenericAppl%>'>

</form>
</body>
</html>


<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

