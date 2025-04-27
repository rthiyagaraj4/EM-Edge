<!DOCTYPE html>


<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.StringTokenizer,java.sql.CallableStatement,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Implants.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=ConnectionManager.getConnection(request);;
PreparedStatement stmt=null;
//CallableStatement cstmt= null ;
Statement stmnt=null;
ResultSet rset=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//out.println(mode);
String prosthesis_code = request.getParameter("prosthesis_code")==null?"":request.getParameter( "prosthesis_code" );
String chk_checked="checked";
String chk_checked1="";
String chk_checked2="";
String chk_value="E";
String chk_value1="Y";
String chk_value2="Y";
String disable_flag="";
String prosthesis_code_disable="";
String long_desc="";
String short_desc="";

String speciality_code =""; //request.getParameter("speciality_code")==null?"":request.getParameter( "speciality_code" );
String speciality_desc="";
String prosthesis_cat_code="";
String prosthesis_type="";
String prosthesis_cat_desc="";
String prosthesis_type_desc="";
String consignment_item_yn="";
String deposit_reqd_yn="";
String mm_item_code =""; //request.getParameter("mm_item_code")==null?"":request.getParameter( "item_code" );
String mm_item_desc="";
String status = "";
String sql = "";
String st_interface_flag = "";
String facility_id=(String) session.getAttribute("facility_id");
//String p_operational_modules="";
String l_mm_module_installed_yn="";
String ph_module_yn = request.getParameter("ph_module_yn");
try{
if(mode.equals("modify"))
{
	
		if(ph_module_yn.equals("Y")){
			/*sql="Select a.prosthesis_code, a.long_desc, a.short_desc, a.mm_item_code,e.short_desc, nvl(a.consignment_item_yn,'N') consignment_item_yn, a.speciality_code,d.short_desc, nvl(a.deposit_reqd_yn,'N') deposit_reqd_yn, a.prosthesis_cat_code,b.prosthesis_cat_desc,a.prosthesis_type,c.prosthesis_type_desc, nvl(a.status,'E') status from OT_PROSTHESIS a,OT_PROSTHESIS_CATEGORY b, OT_PROSTHESIS_TYPE c, am_speciality_lang_vw d, mm_item_lang_vw e where d.LANGUAGE_ID='"+locale+"' AND e.language_id=d.language_id AND  prosthesis_code=? and a.prosthesis_cat_code=b.prosthesis_cat_code(+) and a.prosthesis_type=c.prosthesis_type(+) and a.speciality_code=d.speciality_code(+) and a.mm_item_code=e.item_code(+)" ; */
			sql="Select a.prosthesis_code, a.long_desc, a.short_desc, a.mm_item_code,e.short_desc,nvl(a.consignment_item_yn,'N') consignment_item_yn, a.speciality_code,d.short_desc, nvl(a.deposit_reqd_yn,'N') deposit_reqd_yn, a.prosthesis_cat_code,b.prosthesis_cat_desc,a.prosthesis_type,c.prosthesis_type_desc, nvl(a.status,'E') status from OT_PROSTHESIS_lang_vw a,OT_PROSTHESIS_CATEGORY_lang_vw b, OT_PROSTHESIS_TYPE_lang_vw c, am_speciality_lang_vw d, mm_item_lang_vw e where a.LANGUAGE_ID	  = ? AND a.prosthesis_code = ? AND a.language_id 		  = b.language_id(+) AND a.prosthesis_cat_code = b.prosthesis_cat_code(+) and a.language_id 		  = c.language_id(+) AND a.prosthesis_type	  = c.prosthesis_type(+) AND a.language_id  = d.language_id(+) AND a.speciality_code = d.speciality_code(+) and a.language_id  = e.language_id(+) AND a.mm_item_code  = e.item_code(+) ";
		}else{
			sql="Select a.prosthesis_code, a.long_desc, a.short_desc, a.mm_item_code, null short_desc, nvl(a.consignment_item_yn,'N') consignment_item_yn, a.speciality_code, GET_DESC(?,'AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) short_desc, nvl(a.deposit_reqd_yn,'N') deposit_reqd_yn, a.prosthesis_cat_code,  GET_DESC(?,'OT_PROSTHESIS_CATEGORY_LANG_VW','PROSTHESIS_CAT_DESC','PROSTHESIS_CAT_CODE',A.PROSTHESIS_CAT_CODE) prosthesis_cat_desc, a.prosthesis_type, GET_DESC(?,'OT_PROSTHESIS_TYPE_LANG_VW','PROSTHESIS_TYPE_DESC','PROSTHESIS_TYPE',A.PROSTHESIS_TYPE) prosthesis_type_desc, nvl(a.status,'E') status from OT_PROSTHESIS_LANG_VW a,OT_PROSTHESIS_CATEGORY b, OT_PROSTHESIS_TYPE c, am_speciality d where a.LANGUAGE_ID= ? AND prosthesis_code=? and a.prosthesis_cat_code=b.prosthesis_cat_code(+) and a.prosthesis_type=c.prosthesis_type(+) and a.speciality_code=d.speciality_code(+) " ; 
		}
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		if(ph_module_yn.equals("Y")){
			stmt.setString(2,prosthesis_code);
		}else{
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,prosthesis_code);
		}
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			prosthesis_code=rs.getString(1);
			long_desc=rs.getString(2);
			short_desc=rs.getString(3);
			mm_item_code=rs.getString(4);
			mm_item_desc=rs.getString(5);
		    consignment_item_yn=rs.getString(6);
			speciality_code=rs.getString(7);
			speciality_desc=rs.getString(8);
            deposit_reqd_yn=rs.getString(9);
			prosthesis_cat_code=rs.getString(10);
			prosthesis_cat_desc=rs.getString(11);
			prosthesis_type=rs.getString(12);
            prosthesis_type_desc=rs.getString(13);
			status=rs.getString(14);
			
		}
		if(speciality_code==null || speciality_code.equals("null"))
			 speciality_code="";
		if(speciality_desc==null || speciality_desc.equals("null"))
			 //Commented by Sharon Crasta on 6/11/2009 for IN011339
			 //speciality_desc="&nbsp;";
			 speciality_desc="";
		if(prosthesis_cat_desc==null || prosthesis_cat_desc.equals("null")) 
			
		    prosthesis_cat_desc="";
		if( prosthesis_type_desc==null || prosthesis_type_desc.equals("null")) 
            
			prosthesis_type_desc="";
		if(mm_item_code==null || mm_item_code.equals("null"))
			
			mm_item_code="";
			if(mm_item_desc==null || mm_item_desc.equals("null"))
			//Commented by Sharon Crasta on 6/11/2009 for IN011339
			//mm_item_desc="&nbsp;";
			mm_item_desc="";
		if(status==null || status.equals("null"))
			status="";
		if(consignment_item_yn.equals("Y"))
	     {

			chk_checked1="checked";
			chk_value1="Y";
			
		 }
		 else
	       {
			 //consignment_item_yn="N";
			  chk_checked1="";
			 chk_value1="N";
		   }
		if(deposit_reqd_yn.equals("Y"))
	    {
              chk_checked2="checked";
			 chk_value2="Y";
			 
		}
		else
	       {
			//deposit_reqd_yn="N";
			 chk_checked2="";
			chk_value2="N";
		   }
		if(status.equals("E"))
		{
			chk_checked="checked";
			chk_value="E";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	prosthesis_code_disable="disabled";	
}
}catch(Exception e){
		e.printStackTrace();
		//out.println("ImplantsAddModify.jsp : "+e);
	}finally{
		try{
			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();
			//ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<form name="implant_form" id="implant_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.ImplantsServlet" method="post" target="messageFrame"> 
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>


<tr>
	<td class=label>
		<fmt:message key="eOT.Prosthesis.Label" bundle="${ot_labels}"/>
		<fmt:message key="Common.Implant.label" bundle="${common_labels}"/>
		<fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="prosthesis_code" id="prosthesis_code" value="<%=prosthesis_code%>" size=4 maxlength=4  <%=prosthesis_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label >
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<textarea  name="long_desc" rows=2 cols=40  onBlur="checkMaxLimit1(this,100);makeValidString(this)" <%=disable_flag%>><%=long_desc%></textarea><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"   size='50' maxlength='50' <%=disable_flag%>><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<% 

   if (mode.equals("insert"))
   {
%>
<tr>
	<td class=label>
		<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="prosthesis_cat_desc" id="prosthesis_cat_desc" value=""  size='20' maxlength='20' onBlur="if(this.value!='')callProsthesis_cat_Code(); else prosthesis_cat_code.value='' "><input type="hidden" name="prosthesis_cat_code" id="prosthesis_cat_code" value=""><input type="button" class="button" name="generic_searchForCatCode" id="generic_searchForCatCode" value="?" onclick="callProsthesis_cat_Code();"></td>
	
	
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.type.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="prosthesis_type_desc" id="prosthesis_type_desc" value=""  size='20' maxlength='20' onBlur="if(this.value!='')callProsthesis_type_Code(); else prosthesis_type_code.value=''" ><input type="hidden" name="prosthesis_type_code" id="prosthesis_type_code" value=""><input type="button" class="button" name="generic_searchForType" id="generic_searchForType" value="?" onclick="callProsthesis_type_Code();">
	
	
</tr>
	<%}else if(mode.equals("modify"))
	{%>
<tr>
	<td class=label>
		<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="prosthesis_cat_desc" id="prosthesis_cat_desc" value="<%=prosthesis_cat_desc%>"   size='20' maxlength='20' <%=disable_flag%>
		onBlur="if(this.value!='')callProsthesis_cat_Code();callClear(this);"><input type="hidden" name="prosthesis_cat_code" id="prosthesis_cat_code" value="<%=prosthesis_cat_code%>"><input type="button" class="button" name="generic_searchForCatCode" id="generic_searchForCatCode" value="?" <%=disable_flag%> onclick="callProsthesis_cat_Code();">
		
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.type.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="prosthesis_type_desc" id="prosthesis_type_desc" value="<%=prosthesis_type_desc%>"   size='20' maxlength='20' <%=disable_flag%>
		onBlur="if(this.value!='')callProsthesis_type_Code(); else prosthesis_type_code.value=''"><input type="hidden" name="prosthesis_type_code" id="prosthesis_type_code" value="<%=prosthesis_type%>"><input type="button" class="button" name="generic_searchForType" id="generic_searchForType" value="?"  <%=disable_flag%> onclick="callProsthesis_type_Code();">
	</td>	
</tr>
<% }

   if (mode.equals("insert"))
   {
%>
<tr>
	<td class=label>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text"  name="speciality_desc" id="speciality_desc" size='20' value="" onBlur="if(this.value!='')callSpeciality_Code(); else speciality_code.value='' "><input type="hidden" name="speciality_code" id="speciality_code" value=""><input type="button" class="button" name="generic_search" id="generic_search" value="?"  onclick="callSpeciality_Code();">
	</td>
	
</tr>
<% 
} else if (mode.equals("modify"))

{
%>

	<tr>
	<td class=label>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text"  name="speciality_desc" id="speciality_desc" size='20' value="<%=speciality_desc%>" <%=disable_flag%>
		onBlur="if(this.value!='')callSpeciality_Code(); else speciality_code.value='' "><input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>"><input type="button" class="button" name="generic_search" id="generic_search" value="?" <%=disable_flag%> onclick="callSpeciality_Code();">
	</td>
</tr>
<%}%>
<tr>
	<td class=label>
		<fmt:message key="eOT.ConsignmentItem.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="consignment_item_yn" id="consignment_item_yn" onClick='consignmentYN();' <%=disable_flag%> value='<%=chk_value1%>' <%=chk_checked1%> >
	</td>
	
</tr>
<tr>
	<td class=label>
		<fmt:message key="eOT.DepositRequired.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="deposit_reqd_yn" id="deposit_reqd_yn" onClick='depositYN();' <%=disable_flag%> value='<%=chk_value2%>' <%=chk_checked2%> >
	</td>
</tr>
<%
	try{
       // con=ConnectionManager.getConnection(request);
	   String sql_inventry_chk="SELECT ST_INTERFACE_FLAG FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ? ";
		stmt = con.prepareStatement(sql_inventry_chk);
		stmt.setString(1,facility_id);
		 rset=stmt.executeQuery();
			if(rset !=null && rset.next())
			{
				st_interface_flag=rset.getString(1);
			}
	}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Err Msg from CommonValidation.jsp :"+e);
		}
		finally{
			if(rset!=null) rset.close();
			if(stmt!=null)stmt.close();
			if(con!=null) con.close();
		}
if (mode.equals("insert")){
%>
		<tr>
			<td class=label>
				<fmt:message key="eOT.CrossRefMMItem.Label" bundle="${ot_labels}"/>
			</td>

			
				<% if (st_interface_flag.equals("Y") )	{%>
					<td class="fields">

					<input type='hidden' name='mm_item_code' id='mm_item_code'>
					<input type='text' class='fields' name='mm_item_desc' id='mm_item_desc' size='20'  value=''	onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value=''">
					<input type='button' class='button' value='?' name='generic_search' id='generic_search' onClick='callMM_Item_Code();' >


			<!-- 		<input type="text"  name="mm_item_desc" id="mm_item_desc" size='20' maxlength='20' value="" 
					onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value='' "><input type="hidden" name="mm_item_code" id="mm_item_code" value=""><input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callMM_Item_Code();"> -->
					<!-- <img src='../../eCommon/images/mandatory.gif'> -->
					</td>

			<%} else {%>
				<td class="fields">

					<input type='hidden' name='mm_item_code' id='mm_item_code' value="<%=mm_item_code%>">
					<input type='text' class='fields' name='mm_item_desc' id='mm_item_desc' size='20'  value='<%=mm_item_desc%>'disabled	onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value=''">
					<input type='button' class='button' value='?'disabled name='generic_search' id='generic_search' onClick='callMM_Item_Code();' >


				<!-- <input type="text"  name="mm_item_desc" id="mm_item_desc" size='15' value="<%=mm_item_desc%>" disabled onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value='' ">
				<input type="hidden" name="mm_item_code" id="mm_item_code" value="<%=mm_item_code%>">
				<input type="button" class="button" name="generic_search" id="generic_search" value="?" disabled onclick="callMM_Item_Code();"> -->
				<!-- <img src='../../eCommon/images/mandatory.gif'> -->
			</td>
			</tr>
			<%}
		} else if(mode.equals("modify")){%>
		<tr>
			<td class=label>
				<fmt:message key="eOT.CrossRefMMItem.Label" bundle="${ot_labels}"/>
			</td>
				<% if (st_interface_flag.equals("Y")){%>
			<td class="fields">

					<input type='hidden' name='mm_item_code' id='mm_item_code' value="<%=mm_item_code%>">
					<input type='text' class='fields' name='mm_item_desc' id='mm_item_desc' size='20'  value='<%=mm_item_desc%>'	onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value=''">
					<input type='button' class='button' value='?' name='generic_search' id='generic_search' onClick='callMM_Item_Code();' >

			<!-- 	<input type="text"  name="mm_item_desc" id="mm_item_desc" size='15' value="<%=mm_item_desc%>" <%=disable_flag%> onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value='' "><input type="hidden" name="mm_item_code" id="mm_item_code" value="<%=mm_item_code%>"><input type="button" class="button" name="generic_search" id="generic_search" value="?" <%=disable_flag%> onclick="callMM_Item_Code();"> -->
				<!-- <img src='../../eCommon/images/mandatory.gif'> -->
			</td>
		<%} else {%>
			<td class="fields">
					<input type='hidden' name='mm_item_code' id='mm_item_code' value="<%=mm_item_code%>">
					<input type='text' class='fields' name='mm_item_desc' id='mm_item_desc' size='20'  value='<%=mm_item_desc%>'disabled	onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value=''">
					<input type='button' class='button' value='?'disabled name='generic_search' id='generic_search' onClick='callMM_Item_Code();' >

			<!-- 	<input type="text"  name="mm_item_desc" id="mm_item_desc" size='15' value="<%=mm_item_desc%>" disabled onBlur="if(this.value!='')callMM_Item_Code(); else mm_item_code.value='' ">
				<input type="hidden" name="mm_item_code" id="mm_item_code" value="<%=mm_item_code%>">
				<input type="button" class="button" name="generic_search" id="generic_search" value="?" disabled onclick="callMM_Item_Code();"> -->
				<!-- <img src='../../eCommon/images/mandatory.gif'> -->
			</td>
<%} 
}%>

<tr>
	<td class=label>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td> 
</tr> -->
</table>
	<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
	<input type="hidden" name='prosthesis_code1' id='prosthesis_code1' value="<%=prosthesis_code%>">
	<input type="hidden" name='long_desc1' id='long_desc1' value="<%=long_desc%>">
	<input type="hidden" name='short_desc1' id='short_desc1' value="<%=short_desc%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='l_mm_module_installed_yn' id='l_mm_module_installed_yn' value="<%=l_mm_module_installed_yn%>">
</form>
</body>
</html>





