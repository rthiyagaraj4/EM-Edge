<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<% request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' Src="../js/staffforworkplace.js" ></script>
<script language='javascript' Src= '../../eCommon/js/fieldformatmethods.js'> </script>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script language='javascript' Src='../../eCommon/js/CommonLookup.js' ></script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		function makemtstaffname()
		{
			document.forms[0].staff_id.value='';
			document.forms[0].staff_code.value ='';
		}

		function clearw_place()
		{
			document.forms[0].workplace_desc.value='';
		}

		function showShiftList()
		{	
			//alert(document.forms[0].name);
			var fields = new Array (document.forms[0].workplace_code );
			var names = new Array (getLabel("eRS.WorkPlace.label","RS")); 
				if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) {	
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				parent.frameList.location.href = '../../eRS/jsp/StaffForWorkplaceShowStaff.jsp?workplace_code='+document.forms[0].workplace_code.value+'&locn_type='+document.forms[0].locn_type.value+'&staff='+document.forms[0].staff_code.value;
			}
		}

		function clear_Staff(){
			document.forms[0].staff_id.value='';
			document.forms[0].elements(0).focus();		
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

		function searchCode(call_mode, obj,target)
		{
			
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no"; 
			var arguments	= "" ;
			var sql="";
			var sql1="";
			var search_code="";
			var search_desc="";
			var retVal =    new String();
			var argumentArray=new Array(8);

			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";				
			var locn_type="";				
			var facilityId = "";
			facilityId = document.forms[0].facilityId.value;
			var locale = document.forms[0].locale.value;
			locn_type = document.forms[0].locn_type.value;
			var wrk_place = document.forms[0].workplace_desc.value;
			if((call_mode == 'T')&&(wrk_place=="")){
				return false;
			}
			

			if(document.forms[0].workplace_code.value !=''){
				document.forms[0].workplace_code.value='';
				document.forms[0].workplace_desc.value='';
			}
			//sql1="select workplace_code code,workplace_desc description from rs_workplace where facility_id = '"+facilityId+"' and ('"+locn_type+"' is null or locn_type='"+locn_type+"') and eff_status='E' and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?))";

			sql1="select workplace_code code,workplace_desc description from rs_workplace_lang_vw where facility_id = '"+facilityId+"' and ('"+locn_type+"' is null or locn_type='"+locn_type+"') and eff_status='E' and language_id = '"+locale+"' and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?)) ";
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			
			if(obj.name=="workplace_lookup"){
				tit="Staff Workplace"
				sql=sql1;
			}
			else
			{
				tit="Staff Workplace"
				sql=sql1;
			}

			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;

			retVal = await CommonLookup( tit, argumentArray );
	  
			if(retVal != null && retVal != "" ){
				var ret1=unescape(retVal);
				var arr=ret1.split(",");
				if(target.name == 'workplace_desc'){
					document.forms[0].workplace_desc.value= arr[1];
					document.forms[0].workplace_code.value= arr[0];
				}
			}
			else{	
				document.forms[0].workplace_desc.value= "";
			}
		}
	</script>
	 </head>
	
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
 <body onload="clear_Staff();" onMouseDown="" onKeyDown="lockKey()">
		<form name="workplace_frm" id="workplace_frm">
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr><td colspan="4">&nbsp</td></tr>
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="36%">&nbsp;&nbsp;&nbsp;<select name="locn_type" id="locn_type" onchange="clearw_place();">
				<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
					String togetlocn ="";
					togetlocn = "select locn_type,short_desc from am_care_locn_type order by short_desc";
					pstmt =con.prepareStatement(togetlocn);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next()){
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
					 if(pstmt != null)
						 pstmt.close();
					 if(rs!=null)
						 rs.close();
%>
				</select>
				<td align="right" class="label" width="30%"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="36%">&nbsp;&nbsp;&nbsp;<input type=text name="workplace_desc" id="workplace_desc" size=35 maxlength=30 onblur='searchCode("T", this, workplace_desc);' onchange='makemtstaffname();'><input type=button class=button value='?' name='workplace_lookup' id='workplace_lookup' onClick="searchCode('B',this,workplace_desc);">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp</td>
			</tr>
			<tr>
				
				<td align="right" class="label" width="15%"><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="36%">&nbsp;&nbsp;&nbsp;<input type=text name="staff_id" id="staff_id" size=20 maxlength=15 value='' onchange='makemtstaffname();' readonly><input type=button class=button value='?' name='staffid_lookup' id='staffid_lookup' onclick='viewstaff(staff_id, staff_name);'>
				<td  id='staff_name' align="left" class="label" width="15%"></td>
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="eRS.ShowStaff.label" bundle="${rs_labels}"/>'onclick='showShiftList()'></td></tr>
		</table>	
					<input type='hidden' name='mode' id='mode'  value='1'>
				 <input type=hidden name ="facilityId" value='<%=facilityId%>'>
				 <input type=hidden name ="locale" value='<%=locale%>'>
				 <input type=hidden name ="workplace_code" value=''>
				 <input type=hidden name ="role_type" value=''>
				 <input type=hidden name ="staff_code" value=''>
		</form>
<%
		}
		catch(Exception e){
			e.printStackTrace() ;
			throw e ;
		}
		finally{
			 if(pstmt != null)
				 pstmt.close();
			 if(rs!=null)
				 rs.close();
		  ConnectionManager.returnConnection(con,request);
	  }
%>
</body>
</html>

