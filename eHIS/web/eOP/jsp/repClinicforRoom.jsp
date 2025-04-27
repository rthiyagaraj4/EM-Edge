<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
    Statement stmt =null;
    ResultSet rs =null;

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBCLNRM" ;
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<script>
async function searchCode(obj,target)
    {
            var retVal =    new String();
            var dialogHeight= "28" ;
            var dialogWidth = "43" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var facilityid ="<%=p_facility_id%>";
            var tit="";            
            
            if(obj.name=="clinic")
            {
                tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
                sql="select clinic_code, long_desc from op_clinic where facility_id =`"+facilityid+"`";
                search_code="clinic_code";
                search_desc= "long_desc";
                
            }
			  if(obj.name=="room")
            {
                tit=encodeURIComponent(getLabel("Common.room.label","Common"));
                sql="select room_num,short_desc from am_facility_room where operating_facility_id =`"+facilityid+"`";
                search_code="room_num";
                search_desc= "short_desc";
                
            }

            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

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
<form name="repClinicforRoom" id="repClinicforRoom" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<table width='80%' align='center' valign='top'>
				<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</table>
            <table width='80%' cellPadding="0" cellSpacing="0"  align='center' border='1'>
                <tr>
                    <td width='33%'>&nbsp;</td>
					<td class="label" width='33%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width='33%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
                <tr>
                    <td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_from_clinic_code' id='p_from_clinic_code' size="4" maxlength="4" align="center"><input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode(this, p_from_clinic_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_clinic_code' id='p_to_clinic_code' size="4" maxlength="4" align="center"><input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode(this, p_to_clinic_code)'></td>
                </tr>                
               <tr>
                    <td class="label"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_from_room_no' id='p_from_room_no' size="4" maxlength="4" align="center"><input type='button' name='room' id='room' value='?' class='button' onclick='searchCode(this, p_from_room_no)'></td>
                    <td class='fields'> <input type=text  name='p_to_room_no' id='p_to_room_no' size="4" maxlength="4" align="center"><input type='button' name='room' id='room' value='?' class='button' onclick='searchCode(this, p_to_room_no)'></td>
                </tr>                
               </table>   
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
</form>
<% }catch(Exception e) {out.println(e.toString());}
finally{
if(stmt != null) stmt.close();
if(rs != null) rs.close();
}

%>
</BODY>
</HTML>

