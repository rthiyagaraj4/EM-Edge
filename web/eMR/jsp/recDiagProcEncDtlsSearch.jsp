<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %> 
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>  
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function clearResult()
{	
	parent.frames[2].document.location.href="../../eCommon/html/blank.html"
}

function callSearchScreen(){
		var patientid=PatientSearch('','','','','','','Y','','','OTHER');;
		if(patientid !=null)
		document.forms[0].p_patient_id.value = patientid;
		 document.forms[0].p_patient_id.focus();
		 if (document.forms[0].p_patient_id.value!="")
				document.forms[0].p_encounter_id.disabled=false;
		 else
				document.forms[0].p_encounter_id.disabled=true;
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
	if (document.forms[0].p_patient_id.value!="")
				document.forms[0].encounter_id.disabled=false;
		 else
				document.forms[0].encounter_id.disabled=true;

}
*/
async function searchCode(obj,target)
{
		var retVal = 	new String();
		var dialogHeight= "10vh" ;
		var dialogWidth	= "43vw" ;
		var dialogTop	= "95" ;

		var features	="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../jsp/EncounterDisplayFrame.jsp?patient_id="+document.forms[0].p_patient_id.value+"&enc_type="+document.forms[0].p_enc_type.value,arguments,features);
		if(retVal !=null)
			target.value = retVal;
			target.focus();
}

function searchResult()
{
	var from				= document.forms[0].p_fm_encoun_date.value ;
	var to					= document.forms[0].p_to_encoun_date.value ;
	var patientid		    = document.forms[0].p_patient_id.value;
	var facility			= document.forms[0].facility.value;
	var functionid			=document.getElementById("function_id").value;
	var encounType		= document.forms[0].p_enc_type.value;
	var encounterID			= document.forms[0].p_encounter_id.value;
	var order_by			= document.forms[0].p_order_by.value;

	var	nextRecord			= 0;
	var	previousRecord		= 0;
	var	validFile			= "true";

	
	var	fields				= new Array(document.forms[0].p_patient_id);
	var	names				= new Array(getLabel("Common.patientId.label","Common"));

	if((checkFields(fields, names, parent.messageFrame)) && doDateCheck(document.forms[0].p_fm_encoun_date,document.forms[0].p_to_encoun_date,parent.messageFrame))
	{	
		
		
		//	parent.frames[1].document.forms[0].search[1].disabled=true;

			parent.frames[2].document.location.href='../../eMR/jsp/recDiagProcEncDtlsResult.jsp?fromdate=' + from + '&todate=' + to +'&patientid=' +  patientid +'&flag=next' +
			'&nextRecord=' + nextRecord+'&previousRecord=' + previousRecord +
			'&encounType=' + encounType +'&facility=' + facility + '&order_by=' + order_by +
			'&encounterID=' + encounterID + '&function_id='+functionid  ; 
		
		
	}
	else
	{
		 parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	}																																
}
</script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rs=null;

try
{
	conn = ConnectionManager.getConnection(request);
	stmt1 = conn.createStatement();
	String pat_length="";
	rs=stmt1.executeQuery("select patient_id_length from mp_param");
	if (rs!=null&&rs.next())
	pat_length = rs.getString(1);

	if(rs != null)rs.close();
	if(stmt1 != null)stmt1.close();
	String p_function_id=request.getParameter("function_id");
%>

<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'encounter_detail_form' method='post' target='messageFrame' action='../../eMR/jsp/vwEncounterDetailResult.jsp'>	
      <div>
        <table cellpadding='0' cellspacing='0' width='95%' align='center' > 
		 <tr><td colspan='4' class='BLANKROW1'>&nbsp;</td></tr>
	
<tr>
					<td align='right' width='15%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
					<td   >
						<input type=text  name='p_patient_id' id='p_patient_id'  onBlur="ChangeUpperCase(this);" align="center" size=<%=pat_length%> maxlength=<%=pat_length%>><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'><!-- &nbsp;<img src="../../eCommon/images/mandatory.gif"></img> -->
					</td>
					<td colspan='2'></td>
          </tr>
		<tr><td colspan='4' class='BLANKROW1'>&nbsp;</td></tr>
          <tr>
             <td align='right' width='15%' class='label'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
             <td width='30%'>
               <input 'text' id='birthfrom' name='p_fm_encoun_date' id='p_fm_encoun_date' value='' size='10' maxlength='10' title='From proc Date' Onblur='CheckDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/>&nbsp;&nbsp;--&nbsp;&nbsp;<input 'text' id='birthto' name='p_to_encoun_date' id='p_to_encoun_date' value='' size='10' maxlength='10' title='To proc Date' Onblur='CheckDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/>
              </td>

             <td align='right' width='10%' class='label'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td>
              <select name='p_enc_type' id='p_enc_type'>
			<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option> 
<%
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select patient_class,short_desc from am_patient_class order by short_desc");
			if(rset != null)
			{
			   while(rset.next())
			   {
					String desc	= rset.getString("SHORT_DESC");
					String ID	= rset.getString("patient_class");
					out.println("<option value='"+ID+"'>"+desc+"</option>");
			   }
			}
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
%>
			</select>			
             </td>
			   </tr>
		  <tr><td colspan='4' class='BLANKROW1'>&nbsp;</td></tr>
		     <tr>
			  <td align='right' width='15%' class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  nowrap >	<input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"> &nbsp;
					</td>
					<td align='right' width='10%' class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;</td>
					<td > <select name='p_order_by' id='p_order_by'><option value='11'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/> <option value='3'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></select>
					</td>					  
          </tr>
		  <tr><td colspan='4' class='BLANKROW1'>&nbsp;</td></tr>
		 <tr> <td colspan='3'></td><td class='button'><input type='button' class='button' name='search' id='search'  align='right' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchResult();'>&nbsp;&nbsp;<input type='button' class='button' name='clear' id='clear'  align='right' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearResult();'></td>
          <tr>
            <td width='15%' align='left'>&nbsp;</td>
            <td width='14%' align='left'>&nbsp;</td>
            <td width='15%' align='left'>&nbsp;</td>
            <td width='15%' align='left'>&nbsp;</td>
          </tr>
        </table>
		 <input type='hidden' name='facility' id='facility' value='<%=p_facility_id%>'>
		 <input type='hidden' name='function_id' id='function_id' value='<%=p_function_id%>'>
     </div>
  </form>
</body>
</html>
<%
}catch(Exception e)
{	
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>

