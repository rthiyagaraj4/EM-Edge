<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language='javaScript' src="../../eCommon/js/CommonCalendar.js"></Script>  
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>  
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>  
  <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
  <script language='javascript' src="../js/MedRecRequestCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<script>
function clearResult()
{	
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[3].document.location.href="../../eCommon/html/blank.html";
}
function clearPatinent(obj){
	
	
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[3].document.location.href="../../eCommon/html/blank.html";
	
}

async function callSearchScreen(){
		var patientid= await PatientSearch('','','','','','','Y','','','OTHER');;
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid;
		 document.forms[0].PatientId.focus();		 
	}
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}
/*function Callencon()
{
	if (document.forms[0].PatientId.value!="")
				document.forms[0].encounter_id.disabled=false;
		 else
				document.forms[0].encounter_id.disabled=true;

}
*/
async function searchCode(obj,target)
{
		var retVal = 	new String();
		var dialogHeight= "10vh" ;
		var dialogWidth	= "43" ;
		var dialogTop	= "95vw" ;

		var features	="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		retVal =await window.showModalDialog("../jsp/EncounterDisplayFrame.jsp?patient_id="+document.forms[0].PatientId.value+"&enc_type="+document.forms[0].p_enc_type.value,arguments,features);
		if(retVal !=null)
			target.value = retVal;
			target.focus();
}

function searchResult()
{
	
	var from				= document.forms[0].p_fm_encoun_date.value ;
	var to					= document.forms[0].p_to_encoun_date.value ;
	var patientid		    = document.forms[0].PatientId.value;
	var facility			= document.forms[0].facility.value;
	var encounType			= document.forms[0].p_enc_type.value;
	var encounterID			= document.forms[0].p_encounter_id.value;
	var order_by			= document.forms[0].p_order_by.value;
	var p_all_facility_id	= document.forms[0].p_all_facility_id.value;//added for Bru-HIMS-CRF-380 Start
	

	var	nextRecord			= '';
	var	previousRecord		= '';
	var	validFile			= "true";
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[3].document.location.href="../../eCommon/html/blank.html";
	
	if(patientid == "")
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.patientId.label","Common"));		
		alert(error);	
		
		
	}
	else
	{
	
		var	fields				= new Array(document.forms[0].PatientId);
		var	names				= new Array(getLabel("Common.patientId.label","Common"));

		if( (checkFields(fields, names, parent.messageFrame)) && doDateCheck(document.forms[0].p_fm_encoun_date, document.forms[0].p_to_encoun_date,parent.messageFrame))
		{	
			//	parent.frames[1].document.forms[0].search[1].disabled=true;
			
			parent.frames[3].document.location.href='../../eMR/jsp/vwEncounterDetailResult.jsp?from='+from+'&to='+to+'&patientid='+patientid+'&flag=next'+'&nextRecord='+nextRecord+'&previousRecord='+previousRecord+'&encounType='+encounType+'&facility='+facility+'&order_by='+order_by+'&encounterID='+encounterID+'&p_all_facility_id='+p_all_facility_id;		
		}
		else
		{
			
			 parent.frames[2].document.location.href='../../eCommon/html/blank.html';
			parent.frames[3].document.location.href='../../eCommon/html/blank.html';
			 parent.frames[4].document.location.href= "../../eCommon/jsp/error.jsp?err_num=";
		}																						
	}								
}

function doDcsdDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) > Date.parse(fromdt)) return true;
    }
return true;
}
function DscdPeriodChk(Dt)
{		
	if  (Dt.value!="" &&  doDcsdDateCheck( document.forms[0].SystemDate,Dt) )	
	{
		//alert("Deceased period cannot be greater than current date");
		error=getMessage("MRDATE1_GT_DATE2","MR");
		error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));		
		error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
		alert(error);
		Dt.value='';
		Dt.focus();
	}
	return;
}
//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].p_to_encoun_date.focus();
			document.forms[0].p_to_encoun_date.select();
		}
	}
}
function PatValidations(obj)
{
	
	if(document.forms[0].PatientId.value!='')
	{
	    var fields = new Array (document.forms[0].PatientId); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].PatientId.value;
		var error_jsp="";
		var messageFrame="";
			
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='call_function' id='call_function' value='VIEW_ENCOUNTER_DTLS' /></form></BODY></HTML>";
		//call_function added by Dharma on 20th Feb 2018 against for ML-MMOH-SCF-0919 [IN:066388]
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
}

</script>
<%
request.setCharacterEncoding("UTF-8");
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rs=null;

/*Declaration for Bru-HIMS-CRF-380 Start*/

PreparedStatement pstmt = null ;
ResultSet rset1 		= null ;
/*Declaration for Bru-HIMS-CRF-380 End*/

try
{
	conn = ConnectionManager.getConnection(request);
	
	stmt1 = conn.createStatement();
	String pat_length="";

	rs=stmt1.executeQuery("select patient_id_length from mp_param");
	if (rs!=null && rs.next())
		pat_length = checkForNull(rs.getString(1));

	if(rs!=null)	rs.close();
	if(stmt1!=null)	stmt1.close();

	if(pat_length == null || pat_length.equals("null")) pat_length = "10";

	%>
	<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	   <form name = 'encounter_detail_form' method='post' target='messageFrame' action='../../eMR/jsp/vwEncounterDetailResult.jsp'>	
			<table cellpadding='2' cellspacing='0' width='95%' align='center' > 
			 <tr><td colspan='4' class='BLANKROW1'></td></tr>
				<tr>
					<td width='10%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<td class="fields" width='18%'>
					<input type=text  name='PatientId' id='PatientId'  onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(this);clearPatinent(this);" onKeypress='return CheckForSpecChars(event);' align="center" size="" maxlength=<%=pat_length%>><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'><img src="../../eCommon/images/mandatory.gif"></img></td>	
					<!--onKeypress= 'makeValidString(this)'; Condition removed Against Incident 34858-->			
					
					<!--Modified for Bru-HIMS-CRF-380 Start -->  
					<td width='10%' class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
					<td width='15%' class="fields"><select name='p_all_facility_id' id='p_all_facility_id' >
						<option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
						 <%
							try
							{
								String sql_facility="select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+localeName+"' order by 2";
								//System.err.println("fac qury=>"+sql_facility);
								
								pstmt=conn.prepareStatement(sql_facility);
								rset1=pstmt.executeQuery();
								if(rset1!=null)
								{
									while(rset1.next())
									  {
										String id=rset1.getString(1);
										String name = rset1.getString(2);
										if(id.equals(p_facility_id))
										  {
										%>
											<option value=<%=id%> selected><%=name%></option>
									  <%
										  }
										  else
										  {%>
											<option value=<%=id%> ><%=name%> </option> 
										<%	}
											}
								}
									if(rset1 != null)rset1.close();
									if(pstmt != null)pstmt.close();
								}catch(Exception e)
								{
									/* out.println(e);
									out.println("Exception @tryCatch : "+e.getMessage()); */
									e.printStackTrace();
								}
							%>	
						</select>
					</td>
					<!--Modified for Bru-HIMS-CRF-380 End -->
				</tr>
				<tr>
					<td   class='label'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
					<td class="fields"><input 'text' id='birthfrom' name='p_fm_encoun_date' id='p_fm_encoun_date' value='' size='10' maxlength='10' title='From proc Date' onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(this,p_to_encoun_date);" onkeypress="return Valid_DT(event)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"></img> - <input 'text' id='birthto' name='p_to_encoun_date' id='p_to_encoun_date' value='' size='10' maxlength='10' title='To proc Date' onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(p_fm_encoun_date,this);" onkeypress="return Valid_DT(event)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"></img></td>
					<td  class='label'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td class="fields"><select name='p_enc_type' id='p_enc_type' >
					<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option> 
					<%
					stmt = conn.createStatement();
					rset = stmt.executeQuery("select patient_class,short_desc from am_patient_class order by short_desc");
					if(rset != null)
					{
						while(rset.next())
						{
							String desc	= checkForNull(rset.getString("SHORT_DESC"));
							String ID	= checkForNull(rset.getString("patient_class"));
							if(desc == null || desc.equals("null")) desc = "";
							if(ID == null || ID.equals("null")) ID = "";
							out.println("<option value='"+ID+"'>"+desc+"</option>");
						}
					}
					%>
					</select>			
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td  class='fields'>	<input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"></td>
					<td  class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td><select name='p_order_by' id='p_order_by' >
					<option value='PATIENT_CLASS'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/> 
					<option value='ENCOUNTER_DATE desc'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/>
					</select>
					</td><!-- The order by fields arehard coded according to the positions of the fields in vwEncounterDetailResult.jsp file and hasto be changed if changes are done in the resukt file -->
				</tr>
				<tr> 
					<td colspan='3' class='label'>&nbsp;</td>
					<td class='button'><input type='button' class='button' name='search' id='search'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchResult();'><input type='button' class='button' name='clear' id='clear'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearResult();'></td>
				</tr>
			</table>
		 <input type='hidden' name='facility' id='facility' value='<%=p_facility_id%>'>
	  </form>
	</body>
	</html>
<%
}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(stmt!=null)	stmt.close();
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
}
%>

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

