<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language='javascript' src="../js/StaffForWorkplace.js"></script>
<script language='javascript' src= '../../eCommon/js/FieldFormatMethods.js'> </script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' >
</script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function makemtstaffname(){
			document.forms[0].staff_id.value='';
			document.forms[0].staff_code.value ='';
		}

		function showWorkPlaces(){
			var fields = new Array (document.forms[0].staff_id );
			var names = new Array (getLabel("eRS.StaffName.label","RS"));	
			if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) {	
		
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				parent.frameList.location.href = '../../eRS/jsp/StaffForWorkplaceShowWorkplace.jsp?locn_type='+document.forms[0].locn_type.value+'&staff='+document.forms[0].staff_code.value+'&role_type='+document.forms[0].role_type.value;
			}
		}
		function clear_Staff(){
			document.forms[0].staff_id.value='';		
		}

		function viewstaff(target, name){	
			var url='../../eRS/jsp/SearchStaff.jsp?mode=call';
			var dialogHeight =window.screen.height ;
			var dialogWidth = window.screen.width ;
			var dialogTop	= 0;
			var dialogLeft = 0 ;
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var arguments = "";
			var retVals = window.showModalDialog(url,arguments,features);
			if(retVals !=null){
				target.value=retVals[1];
				
				document.forms[0].staff_code.value=retVals[0];
				if(retVals[2]=='P'){
					document.forms[0].role_type.value='P';
					name.innerText="  "+"Practitioner";
				}
				else{	
					document.forms[0].role_type.value='O';
					name.innerText="  "+"Other Staff";
				}		
			}
		}
	</script>
	 </head>
	 <body onload='clear_Staff();' onMouseDown="" onKeyDown="lockKey()">
<%
	  Connection con 	      = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs		      = null;
	  
	  String	facilityId 	  = (String) session.getValue( "facility_id" ) ;
	  try{
		 con = ConnectionManager.getConnection(request);
		 String mode	   = request.getParameter("mode") ;
		 if(mode==null) mode="";

%>
		<form name="staff_frm" id="staff_frm">
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr><td colspan="4">&nbsp</td></tr>
			<tr>
				<td align="right" class="label" width="15%"><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="36%">
				&nbsp;&nbsp;<input type=text name="staff_id" id="staff_id" size=20 maxlength=15 value='' readonly><input type=button class=button value='?' name='staffid_lookup' id='staffid_lookup' onclick='viewstaff(staff_id, staff_name);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<td  id='staff_name' align="left" class="label" width="15%"></td><td colspan="1" align="right"></tr>
				<tr><td colspan="4">&nbsp</td></tr>
				<tr>
				<td align="right" class="label" width="15%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="36%">&nbsp;&nbsp;
				<select name="locn_type" id="locn_type" >
				<option value="" selected> &nbsp&nbsp--- <fmt:message key= "Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
<%
				String togetlocn ="";
				togetlocn = "select locn_type,short_desc from am_care_locn_type order by short_desc";
				pstmt =con.prepareStatement(togetlocn);
				rs = pstmt.executeQuery();
				while(rs!=null  && rs.next()){
					out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
				 }
				 if(pstmt!=null)
					 pstmt.close();
				 if(rs != null)
					 rs.close();
%>
				</select>
				</td>
			<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="eRS.Show Workplace.label" bundle="${rs_labels}"/>'onclick='showWorkPlaces()'></td></tr>
			</tr>
		</table>	
		 <input type=hidden name ="facilityId" value='<%=facilityId%>'>
		 <input type=hidden name ="workplace_code" value=''>
		 <input type=hidden name ="role_type" value=''>
		 <input type=hidden name ="staff_code" value=''>
    	 <input type='hidden' name='mode' id='mode'  value='1'>
		</form>
<%
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			if(pstmt!=null)
				pstmt.close();
			if(rs != null)
				rs.close();
			ConnectionManager.returnConnection(con,request);
		}
%>
</body>
</html>

