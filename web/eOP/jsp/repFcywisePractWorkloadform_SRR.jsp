<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_facility_id		= (String) session.getValue( "facility_id" );
String p_user_name		= (String) session.getValue( "login_user" );
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	var locale = "<%=localeName%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	return;
	var argumentArray=new Array(8);
          tit=getLabel("Common.speciality.label","Common");
		argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
          var retVal=CommonLookup(tit,argumentArray);

	    if(retVal==null || retVal=="")
		  target.value="";
	 else
		target.value=retVal[0];
}

 function searchCode1(obj,target)
    {
            var sql="";
            var sqlSecond="";
			//var facilityid = "<%=p_facility_id%>";
			var facilityid = document.forms[0].p_for_facility_id.value;
            var tit="";
			/*var practitionerName="";
			var practitionerValue="";
			var practitionerTypeValue="";*/
			var locale = "<%=localeName%>";

			target.value=trimString(target.value);
			
			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);
			 if(obj.name=="tolocn" || obj.name=="fromlocn")
            {

			 tit=getLabel("Common.Location.label","Common");

				//SQL

                //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' AND facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
				argumentArray[1]=new Array("facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
			}
			else
			{
				if(obj.name=="pract_id1" && document.forms[0].fm_pract_type)
					practitionerTypeValue=document.forms[0].fm_pract_type.value;
				else if(document.forms[0].to_pract_type)
						practitionerTypeValue=document.forms[0].to_pract_type.value;

				getPractitioner(obj,target,'','',practitionerTypeValue,'','','','','',"Q2");
				return;  			
			}
			var retVal=CommonLookup(tit,argumentArray);

			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];

	}

	function PractLookupRetVal(retVal,objName)
	{

		var arr;

		if (retVal != null)
		{
			arr=retVal.split("~");
		
			if(objName=="p_fm_practitoner")
				document.forms[0].p_fm_practitoner.value=arr[0];
			else
				document.forms[0].p_to_practitoner.value=arr[0];
						
		}
		else
		{
		
			if(objName=="p_fm_practitoner")
				document.forms[0].p_fm_practitoner.value="";
			else
				document.forms[0].p_to_practitoner.value="";
						
		}
	
	}
	function setDate(Object)    { 

var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
               alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
				Object.value="";
                Object.focus();
            
        }
    }
	}




/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
	}*/
</script>

<%
    String p_module_id      = "OP" ;
    String p_report_id      = "OPBFPWLS" ;
  //  String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    //String p_user_name      = (String) session.getValue( "login_user" ) ;
	String locale=(String)session.getAttribute("LOCALE");

    Connection con =null;
    ResultSet rset =null;
    Statement stmt=null;
    String ID="";
    String dat="";
    String en="";
	 String sql = "" ;
	StringBuffer StrVal =new StringBuffer();

    try{
		con = ConnectionManager.getConnection(request);
        stmt = con.createStatement();
		sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_LANG_VW Where language_id='"+localeName+"' AND EFF_STATUS = 'E' order by 2" ;
    rset = stmt.executeQuery(sql);

	StrVal.setLength(0);
    
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
	 

%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="repFcywisePractWorkloadform" id="repFcywisePractWorkloadform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
<table width='80%' align='center' valign='top' border='0'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table width='80%' cellPadding="2" cellSpacing="0" align='center' border='0'>
<tr>
<td class="label" width='33%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields' width='33%' colspan='2'>
<select name='p_for_facility_id' id='p_for_facility_id' >
<%
    stmt=con.createStatement();
	
	//rset=stmt.executeQuery("select facility_id,facility_name from  SM_FACILITY_FOR_USER_VW where appl_user_id='"+p_user_name+"' order by facility_name ");
    
	rset=stmt.executeQuery("select facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+locale+"',1)facility_name from  SM_FACILITY_FOR_USER where appl_user_id='"+p_user_name+"' order by facility_name ");
    
	if(rset!=null)
    {
       while(rset.next())
       {
            dat=rset.getString("FACILITY_NAME");
            ID=rset.getString("FACILITY_ID");
            
            out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
       }%>
      </select>
<%  }
    
%>
</td>
</tr>
<tr>
    <td >&nbsp;</td>
    <td class="querydata"  style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
    <!-- <td class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td> -->
	<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
    <td class='fields'><input type=text  id='mdsfrom' name='p_fm_dt' id='p_fm_dt' size="10" maxlength="10"  onBlur="if(validDateObj(this,'DMY',localeName)){setDate(this)};"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>        
    <td class='fields'><input type=text  id='mdsto' name='p_to_dt' id='p_to_dt' size="10" maxlength="10" onBlur="if(validDateObj(this,'DMY',localeName)){setDate(this)};"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>	

<tr>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(this,p_fm_specialty_code)'><input type='button' name='fromspec' id='fromspec' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(this,p_to_specialty_code)'><input type='button' name='tospec' id='tospec' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr>


<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'>	    <input type="text" name="p_fm_locn" id="p_fm_locn" size="4" maxlength="4" onBlur='searchCode1(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode1(this, p_fm_locn)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_locn" id="p_to_locn" size="4" maxlength="4" onBlur='searchCode1(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode1(this, p_to_locn)'>
	</td>	
</tr>

<tr>
                    <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
					<select name="fm_pract_type" id="fm_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>					
                    <td class='fields'>
					<select name="to_pract_type" id="to_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>					
                </tr>
<tr>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
	<input type="text" name="p_fm_practitoner" id="p_fm_practitoner" size="15" maxlength="15" onBlur='searchCode1(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode1(this,p_fm_practitoner)'>
	</td>	
	<td class='fields'>
	<input type="text" name="p_to_practitoner" id="p_to_practitoner" size="15" maxlength="15" onBlur='searchCode1(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode1(this,p_to_practitoner)'>
	</td>	
</tr>
		
	</table>


  <br>
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
        <input type="hidden" name="p_fr_date" id="p_fr_date"           value="">
        <input type="hidden" name="p_to_date" id="p_to_date"           value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

    </form>

<% }
catch(Exception e) {out.println(e.toString());}
finally{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
if( con !=null ) ConnectionManager.returnConnection(con,request);
}

%>

</center>
</body>
</html>

