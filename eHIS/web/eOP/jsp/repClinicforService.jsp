<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
    Statement stmt =null;
    ResultSet rs =null;

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBCLNSR" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
try{

%>
<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<script>
async function searchCode(obj,target)
    {
            var retVal =    new String();
            var sql="";           
            var facilityid ="<%=p_facility_id%>";
            var tit="";  
			var locale = "<%=localeName%>";

			target.value=trimString(target.value);
			
			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);	
			var dataNameArray  = new Array() ;
		     var dataValueArray = new Array() ;
		     var dataTypeArray  = new Array() ;
			            
            if(obj.name=="fm_clinic" ||obj.name=="to_clinic")
            {
                tit=getLabel("Common.Location.label","Common");                
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' AND facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
            
			    argumentArray[1]=new Array("facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
			}	

			if(obj.name=="fm_service" || obj.name=="to_service")
            {
                /*tit=getLabel("Common.service.label","Common");

				//SQL

                //argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service where '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where language_id='"+locale+"' and '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;*/
                 tit=getLabel("Common.service.label","Common");

				argumentArray[0]="SELECT distinct service_code code, am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) description FROM   am_facility_service WHERE operating_facility_id = '"+facilityid+"' AND   eff_status =  'E' AND   UPPER(service_code) LIKE UPPER(NVL(?,service_code)) AND   UPPER(am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)) LIKE UPPER(NVL(?,am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)))";	
				
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC; 


			}
			var retVal=await CommonLookup(tit,argumentArray);

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

</script>
<BODY onMouseDown="CodeArrest();" onLoad="Focusing('p_from_clinic_code')" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repClinicforService" id="repClinicforService" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<table width='80%' align='center' valign='top'>
				<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</table>
            <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
                <tr>
                    <td width='33%'>&nbsp;</td>
					<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
				<tr>
                    <td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_from_clinic_code' id='p_from_clinic_code' size="4" maxlength="4" align="center" onBlur='if(this.value!="")searchCode(fm_clinic,this)'><input type='button' name='fm_clinic' id='fm_clinic' value='?' class='button' onclick='searchCode(this, p_from_clinic_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_clinic_code' id='p_to_clinic_code' size="4" maxlength="4" align="center" onBlur='if(this.value!="")searchCode(fm_clinic,this)'><input type='button' name='to_clinic' id='to_clinic' value='?' class='button' onclick='searchCode(this, p_to_clinic_code)'></td>
                </tr>                
               <tr>
                    <td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_from_service_code' id='p_from_service_code' size="4" maxlength="4" align="center" onBlur='if(this.value!="")searchCode(fm_service,this)'><input type='button' name='fm_service' id='fm_service' value='?' class='button' onclick='searchCode(this, p_from_service_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_service_code' id='p_to_service_code' size="4" maxlength="4" align="center" onBlur='if(this.value!="")searchCode(to_service,this)'><input type='button' name='to_service' id='to_service' value='?' class='button' onclick='searchCode(this, p_to_service_code)'></td>
                </tr> 		
             </table>
       
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
</form>
<% }catch(Exception e) {

//out.println(e.toString());
e.printStackTrace();

}
finally{
if(stmt != null) stmt.close();
if(rs != null) rs.close();
}

%>
</BODY>
</HTML>

