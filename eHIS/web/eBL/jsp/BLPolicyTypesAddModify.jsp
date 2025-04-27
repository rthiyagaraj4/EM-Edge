<!DOCTYPE html>
<!--
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V200929            72977         NMC-JD-CRF-0059       Mohana Priya K
2            v201022            74288         NMC-JD-CRF-0059       Mohana Priya K
3            v201022            74289         NMC-JD-CRF-0059       Mohana Priya K
4	   V210927&V211005 	       23887	      NMC-JD-SCF-0233-TF    Mohana Priya K
5		 V211020	25504		COMMON-ICN-0073-TF											Mohana Priya K
 -->

<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="java.sql.PreparedStatement, java.sql.ResultSet, java.sql.Connection, java.net.URLEncoder, webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eBL/js/BLPolicyTypes.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>

<script language='javascript'>
function enableApply()
{
	parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
}

//V210927 , V211005 Starts
//Function to disable all special characters in master codes.
function CheckForSpecChars_loc(event,obj){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_/-.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length==0)
	{

		if(('_'.indexOf(key)!=-1)||('/'.indexOf(key)!=-1) ||('-'.indexOf(key)!=-1) ||('.'.indexOf(key)!=-1))   //_/-.
			return false;
	}

    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForSpecChar(event,obj){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_/-.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length!=0)
	{
		var firstChar = obj.value.charAt(0);
		if(('_'==firstChar)||('/'==firstChar) ||('-'==firstChar) ||('.'==firstChar)) {  //_/-.
			alert(getMessage("BL8509", 'BL'));
			obj.value = "";
			obj.focus();
			return false;
		}
		for(var i=0;i<obj.value.length;i++){
			var curChar = obj.value.charAt(i);
			var chck=strCheck.indexOf(curChar) ;
	
			if(chck==-1){
				alert(getMessage("BL8510", 'BL'));
				obj.value = "";
				obj.focus();
				return false;
			}
		}
	}
	return true ;

}

//V210927 , V211005 Ends   
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  OnLoad="enableApply();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String mode=request.getParameter("mode");
	String policy_type_code=checkForNull(request.getParameter("policy_type_code"));
	String facility=(String) session.getValue("facility_id");
	String chk_checked="checked";
	String chk_checked1="checked";
	String chk_value="E";
	String chk_value1="N";
	String disable_flag="";
	String short_desc_disable="";
	String strLongDesc="";
	String status="";
	String sql="";
	String strShortDescValue="";
	String strShortDesc="";
	String gosipolicy="";
	String facility_id="";
	String facility_id1="";
	String fac_name="";//V201027
	String GOSI_YN="";
	String sysDateTime="";
	Boolean siteSpec=false;
	String sitespecval="N";
	try{
	con=ConnectionManager.getConnection(request);

	try{
		//con=ConnectionManager.getConnection(request);
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_TYPES");
		if(siteSpec){
			sitespecval="Y";
		}else{
			sitespecval="N";
		}
	}catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception in sitespec is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			//ConnectionManager.returnConnection(con); //V211020
		}catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception is "+e);
		}
	}

	if(mode.equals("insert")){
		try{
			//con=ConnectionManager.getConnection(request);
			facility_id1=(String) session.getValue( "facility_id" );
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception is "+e);
		}	
	}

	if(mode.equals("modify"))
	{
		try{
		//	con=ConnectionManager.getConnection(request); //V211020
			if("Y".equals(sitespecval)){
			sql = "SELECT OPERATING_FACILITY_ID facility,LONG_DESC,SHORT_DESC,NVL(GOSI_YN,'N') GOSI_YN,NVL(status,'E') status1 FROM BL_INS_POLICY_TYPES where POLICY_TYPE_CODE =?  and OPERATING_FACILITY_ID=? ";//v201022/74288
			}else{
			sql = "SELECT OPERATING_FACILITY_ID facility,LONG_DESC,SHORT_DESC,NVL(status,'E') status1 FROM BL_INS_POLICY_TYPES where POLICY_TYPE_CODE =?  and OPERATING_FACILITY_ID=? ";//v201022/74288
			}
			stmt=con.prepareStatement(sql);
			stmt.setString(1,policy_type_code);
			stmt.setString(2,facility);
		
			rs=stmt.executeQuery();
					
			if(rs!=null && rs.next())
			{   
				strLongDesc=rs.getString("LONG_DESC");
				strShortDesc=rs.getString("SHORT_DESC");
				if("Y".equals(sitespecval)){
					gosipolicy=rs.getString("GOSI_YN");
				}
				status=rs.getString("status1");
				facility_id1=rs.getString("facility");
			}
			if(status.equals("E"))
			{
				chk_checked="checked READONLY";
				disable_flag="";
				chk_value="E";   //201103
			}
			else
			{
				chk_checked="";
				disable_flag="readonly onfocus='this.blur()'";
				chk_value="D";
			}
			if("Y".equals(sitespecval)){
				if(gosipolicy.equals("Y"))
				{
					chk_checked1="checked";
					chk_value1="Y";   //201103
					disable_flag="";
				}
				else
				{
					chk_checked1="";
					disable_flag="readonly onfocus='this.blur()'";
					chk_value1="N";
				}
			}			
		short_desc_disable="disabled";
		}catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception is "+e);
		}
		finally{
			try{
				if(stmt!=null) stmt.close();
				if(rs!=null)rs.close();
			//	ConnectionManager.returnConnection(con);//V211020
			}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		}
	}
%>
	
<form name="policy_form" id="policy_form"  onload='FocusFirstElement();'  method='post' action='../../servlet/eBL.BLPolicyTypeServlet' target='messageFrame'> 
<br><br><br><br><br><br>
<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
		<tr>
			<td class="LABEL" ><fmt:message key="eBL.Facility.label" bundle="${bl_labels}"/></td>
			<td class="fields" >
			<select name='facility' id='facility' id='facility'  maxlength='40' style="width:230px;"  <%=short_desc_disable %> >
				<%try{
					//con=ConnectionManager.getConnection(request);//V211020
					facility_id = "select facility_id, facility_name from Sm_Facility_Param where status = 'E' and facility_id=?";   //V201027
					
				String selected="selected";
				stmt = con.prepareStatement(facility_id);
				stmt.setString(1,facility_id1);
				
				rs = stmt.executeQuery();	
			if(rs != null){
			while(rs.next()){	
				if(facility_id1.equals(rs.getString(1)))
				{								
		%>	
				<option selected value="<%=rs.getString(1)%>"><%=rs.getString(2) %></option>	
		<%	}				
				}//while 
			}//Result Set IF Condition 
			}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
			finally{
				try{
					if(stmt!=null) stmt.close();
					if(rs!=null)rs.close();
					//ConnectionManager.returnConnection(con);//V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					//out.println("Exception is "+e);
				}				
			}	 %>
				</Select> <img src='../../eCommon/images/mandatory.gif'> 
		</td>	
	</tr>							
	 <tr>
		<td class="LABEL"><fmt:message key="eBL.POLICY_TYPE_CODE.label" bundle="${bl_labels}"/></td>
		<td class='fields'>
		<input type="text" name="policy_type_code" id="policy_type_code" id="policy_type_code" 	size="40"  maxlength="20"  onKeyPress='return CheckForSpecChars_loc(event,this);' value ="<%=policy_type_code%>"  <%=short_desc_disable %>  onBlur="ChangeUpperCase( this );return CheckForSpecChar(event,this);"  >	
		<img src='../../eCommon/images/mandatory.gif'>  <!-- Modified against V210927 -->
		</td>				
		<td class="LABEL" colspan='3'></td>				
	 </tr>

	<tr>
		<td class="LABEL" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="long_desc" id="long_desc" id="long_desc" 	size="40"	 maxlength="100"  value ="<%=strLongDesc%>" >		
		<img src='../../eCommon/images/mandatory.gif'>
		</td>				
		<td class="LABEL" colspan='3'></td>				
	 </tr>

	 <tr>
		<td class="LABEL" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="short_desc" id="short_desc" id="short_desc" 	size="40"	 maxlength="40"  value ="<%=strShortDesc%>" >		
		<img src='../../eCommon/images/mandatory.gif'>
		</td>				
		<td class="LABEL" colspan='3'></td>				
	 </tr>
		<%
			if("Y".equals(sitespecval)){ 
		%>
			<tr>
			<td class='LABEL' >
				<fmt:message key="eBL.GosiPolicy.label" bundle="${bl_labels}"/>
			</td>
			<td class='fields'>
		<%
			if(!(mode.equals("modify")))	  chk_checked1 = "";
		%>
			<input type="checkbox" name="gosipolicy" id="gosipolicy" onClick='setGosiValue();' value='<%=chk_value1%>'  <%=chk_checked1%>>
				</td>
			</tr> 
		<%
			}else{
		%>
			<input type='hidden' name='gosipolicy' id='gosipolicy' value="N">
		<%
			}
		%>
	<tr>
		<td class='LABEL'>
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
		<%
		if(!(mode.equals("modify")))	  chk_checked = "checked   readonly";
		%>
			<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
		</td>
	</tr>
</table>
	<%}catch(Exception ex)
		{
			ex.printStackTrace();
			//out.println("Exception blpolicytypesaddmod::: "+ex);
		}	
		finally{
		try{
			ConnectionManager.returnConnection(con);//V211020
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception is "+e);
		}				
		}%>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='long_desc1' id='long_desc1' value="<%=strLongDesc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value="<%=facility_id1%>">
<input type='hidden' name='sitespecval' id='sitespecval' value="<%=sitespecval%>">
<input type="hidden" name="policy_type_code1" id="policy_type_code1" id="policy_type_code1" value ="<%=policy_type_code%>">
</form>
</body>
</html>

