<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
                    
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="javascript" src="../../eOT/js/SurgeonPref.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script Language="JavaScript">
	function dislock(){
		var formObj=document.forms[0];
		formObj.speciality_desc.disabled=true;
		formObj.category_desc.disabled=true;
		formObj.subCategory_desc.disabled=true;
		formObj.operation_desc.disabled=true;
	}
	function chkSpecificOperation(obj){
	var formObj=document.forms[0];
	if(obj.value=="AOPR"){
		formObj.generic_search_for_Speciality.disabled=true;
		formObj.generic_search_for_Category.disabled=true;
        formObj.subCategory_desc.value='';
		formObj.subCategory_code.value='';
		formObj.generic_search_for_subCategory.disabled=true;
        formObj.operation_desc.value='';
		formObj.operation_code.value='';
		formObj.generic_search_for_Operation.disabled=true;
		formObj.speciality_desc.disabled=true;
		formObj.category_desc.disabled=true;
		formObj.subCategory_desc.disabled=true;
		formObj.operation_desc.disabled=true;

	}else if(obj.value=="SSPL"){
		formObj.generic_search_for_Speciality.disabled=false;
		formObj.generic_search_for_Category.disabled=true;
        formObj.subCategory_desc.value='';
		formObj.subCategory_code.value='';
		formObj.generic_search_for_subCategory.disabled=true;
        formObj.operation_desc.value='';
		formObj.operation_code.value='';
		formObj.generic_search_for_Operation.disabled=true;
		formObj.speciality_desc.disabled=false;
		formObj.category_desc.disabled=true;
		formObj.subCategory_desc.disabled=true;
		formObj.operation_desc.disabled=true;
    }else if(obj.value=="SCAT"){
		formObj.generic_search_for_Speciality.disabled=false;
		formObj.generic_search_for_Category.disabled=false;
        formObj.subCategory_desc.value='';
		formObj.subCategory_code.value='';
		formObj.generic_search_for_subCategory.disabled=true;
        formObj.operation_desc.value='';
		formObj.operation_code.value='';
		formObj.generic_search_for_Operation.disabled=true;
		formObj.speciality_desc.disabled=false;
		formObj.category_desc.disabled=false;
		formObj.subCategory_desc.disabled=true;
		formObj.operation_desc.disabled=true;
	}else if (obj.value=="SSUB"){
		formObj.generic_search_for_Speciality.disabled=false;
		formObj.generic_search_for_Category.disabled=false;
        formObj.subCategory_desc.disabled=false;
		formObj.subCategory_code.disabled=false;
		formObj.generic_search_for_subCategory.disabled=false;
        formObj.operation_desc.value='';
		formObj.operation_code.value='';
		formObj.generic_search_for_Operation.disabled=true;
		formObj.speciality_desc.disabled=false;
		formObj.category_desc.disabled=false;
		formObj.subCategory_desc.disabled=false;
		formObj.operation_desc.disabled=true;
	}else if(obj.value=="SOPR"){
		formObj.generic_search_for_Speciality.disabled=true;
		formObj.generic_search_for_Category.disabled=true;
        formObj.subCategory_desc.value='';
		formObj.subCategory_code.value='';
		formObj.generic_search_for_subCategory.disabled=true;
        formObj.operation_desc.disabled=false;
		formObj.operation_code.disabled=false;
		formObj.generic_search_for_Operation.disabled=false;
		formObj.speciality_desc.disabled=true;
		formObj.category_desc.disabled=true;
		formObj.subCategory_desc.disabled=true;
		formObj.operation_desc.disabled=false;        
	}
		formObj.speciality_desc.value='';
        formObj.speciality_code.value='';
        formObj.category_desc.value='';
		formObj.category_code.value='';

}

function assignApplicability(){
  var formObj = document.forms[0];
  formObj.appl_desc.value=document.getElementById('appl_desc').getAttribute('db_value');
  }
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='assignApplicability();dislock();parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String read_only="";
	String mode=checkForNull(request.getParameter("update_mode_yn"));
	String applicability=request.getParameter("applicability")==null?"":request.getParameter("applicability");//getting from query result via frame for create 
	String all_operations=request.getParameter("all_operations");//getting from frame for create
	String strsql="";
	String all_operations_disabled_flag="";
	if(all_operations.equals("AOPR"))
		all_operations_disabled_flag="disabled";
	else 
		all_operations_disabled_flag="";
	String sql="";
	String surgeon_code=checkForNull(request.getParameter("surgeon_code"));
	String surgeon_desc=checkForNull(request.getParameter("surgeon_desc"));
	String speciality_code=checkForNull(request.getParameter("speciality_code"));
	String speciality_desc=checkForNull(request.getParameter("speciality_desc"));
	String oper_cat_code=checkForNull(request.getParameter("oper_cat_code"));
	String oper_cat_desc="";
	String oper_sub_cat_code=checkForNull(request.getParameter("oper_sub_cat_code"));
	String oper_sub_cat_desc="";
	String oper_code=checkForNull(request.getParameter("oper_code"));
	String oper_desc="";
	String facilityid=(String)session.getValue("facility_id");
	//String sql1="SELECT APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE FROM OT_OPER_SURGICAL_ACCESSORIES";
	String sql1="SELECT APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE FROM OT_OPER_DR_PREFERENCE";
	StringBuffer dtlString=new StringBuffer();
	if(applicability.equals("SSPL"))
		 sql=" AND A.SPECIALITY_CODE='"+speciality_code+"'";
	else if(applicability.equals("SCAT"))
		 sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"'";
	else if(applicability.equals("SSUB"))
		 sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"' AND A.OPER_SUB_CAT_CODE='"+oper_sub_cat_code+"'";
	else if(applicability.equals("SOPR"))
		 sql=" AND A.OPER_CODE='"+oper_code+"'";
	if(mode.equals("modify")){
		 read_only=" readOnly ";
		try{
		    //strsql="SELECT A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.SHORT_DESC FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY_LANG_VW B, OT_OPER_CATEGORY C, OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+) AND A.OPER_CODE=E.OPER_CODE(+) AND A.APPLICABILITY='"+applicability+"'"+sql;
			//Commented against MMS-QH-CRF-0199
			/*strsql="SELECT A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.SHORT_DESC S_DESC FROM OT_OPER_DR_PREFERENCE A, AM_SPECIALITY_LANG_VW B, OT_OPER_CATEGORY C, OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+) AND A.OPER_CODE=E.OPER_CODE(+) AND A.APPLICABILITY='"+applicability+"'"+sql;*/
			
			//Modified against MMS-QH-CRF-0199
			strsql="SELECT A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.LONG_DESC S_DESC FROM OT_OPER_DR_PREFERENCE A, AM_SPECIALITY_LANG_VW B, OT_OPER_CATEGORY C, OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+) AND A.OPER_CODE=E.OPER_CODE(+) AND A.APPLICABILITY='"+applicability+"'"+sql;
			con=ConnectionManager.getConnection(request);
			stmt=con.prepareStatement(strsql);
			//stmt.setString(1,applicability);
			System.err.println("strsql=========== " +strsql);
			rs=stmt.executeQuery();			
			if(rs!=null && rs.next()){
					speciality_code=checkForNull(rs.getString(2));
					speciality_desc=checkForNull(rs.getString(3));
					oper_cat_code=checkForNull(rs.getString(4));
					oper_cat_desc=checkForNull(rs.getString(5));
					oper_sub_cat_code=checkForNull(rs.getString(6));
					oper_sub_cat_desc=checkForNull(rs.getString(7));
					oper_code=checkForNull(rs.getString(8));
					oper_desc=checkForNull(rs.getString(9));				
			}
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception is "+e);
		}finally{
			try{
				if(stmt!=null) stmt.close();
				if(rs!=null)rs.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e)	{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		}
	}else if(mode.equals("insert")){
		try{
			con=ConnectionManager.getConnection(request);
			stmt=con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				dtlString=dtlString.append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append("#");
			}
		}catch(Exception e)	{
			e.printStackTrace();
			//out.println("Exception is "+e);
		}
		finally{
			try{
				if(stmt!=null) stmt.close();
				if(rs!=null)rs.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		}
}
%>          

<form name="Surgeonprefmain" id="Surgeonprefmain"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	    <td class=label width='25%'>
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	    </td>
		<td class="fields">
		<input type="text" name="surgeon_desc" id="surgeon_desc" value="<%=surgeon_desc%>" size=30 maxlength=30 <%=read_only%> onBlur="if(this.value!='')callCodeSearch('SU','Surgeon Search',surgeon_code,surgeon_desc);">
		<input type="hidden" name="surgeon_code" id="surgeon_code" value="<%=surgeon_code%>" >
		<input type="button" class="button" name="generic_search_for_Surgeon" id="generic_search_for_Surgeon" value="?"  onclick="callCodeSearch('SU','Surgeon Search',surgeon_code,surgeon_desc);" >
	    </td>
</tr>
<tr>
	<td class='label'>
	    <fmt:message key="Common.Applicability.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class="fields">
			<select name="appl_desc" id="appl_desc" db_value="<%=applicability%>" onchange='chkSpecificOperation(this);'>
				<!-- <option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option> -->
				<option value='AOPR'>
					<fmt:message key="Common.AllOperations.label" bundle="${common_labels}"/>
				</option>
				<option value='SSPL'>
					<fmt:message key="Common.SpecificSpecialty.label" bundle="${common_labels}"/>
				</option>
				<option value='SCAT'>
					<fmt:message key="eOT.SpecificOperationCategoryWithinSpeciality.Label" bundle="${ot_labels}"/>
				</option>
				<option value='SSUB'>
					<fmt:message key="eOT.SpecificOperationSubCategoryWithinSpeciality.Label" bundle="${ot_labels}"/>
				</option>
				<option value='SOPR'>
					<fmt:message key="Common.SpecificOperation.label" bundle="${common_labels}"/>
				</option>
			</select><img src='../../eCommon/images/mandatory.gif'>
		</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="speciality_desc" id="speciality_desc" value="<%=speciality_desc%>" size=30 maxlength=30 <%=read_only%> 
		onBlur="if(this.value!='')callCodeSearch('S','Speciality Search',speciality_code,speciality_desc);">
		<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>" >
		<input type="button" class="button" name="generic_search_for_Speciality" id="generic_search_for_Speciality" value="?" <%=all_operations_disabled_flag%> onclick="callCodeSearch('S','Speciality Search',speciality_code,speciality_desc);" >
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="category_desc" id="category_desc" value="<%=oper_cat_desc%>" size=30 maxlength=30  <%=read_only%> onBlur="if(this.value!='')callCodeSearch('C','Category Search',category_code,category_desc);">
		<input type="hidden" name="category_code" id="category_code" value="<%=oper_cat_code%>" >
		<input type="button" class="button" name="generic_search_for_Category" id="generic_search_for_Category" value="?"  onclick="callCodeSearch('C','Category Search',category_code,category_desc);" <%=all_operations_disabled_flag%>  >
	</td>
	
</tr>
<tr>
	<td class=label >
		<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="subCategory_desc" id="subCategory_desc" value="<%=oper_sub_cat_desc%>" size=30 maxlength=30 <%=read_only%> onBlur="if(this.value!='')callCodeSearch('SC','Sub Category Search',subCategory_code,subCategory_desc);">
		<input type="hidden" name="subCategory_code" id="subCategory_code" value="<%=oper_sub_cat_code%>">
		<input type="button" class="button" name="generic_search_for_subCategory" id="generic_search_for_subCategory" value="?"  onclick="callCodeSearch('SC','Sub Category Search',subCategory_code,subCategory_desc);" <%=all_operations_disabled_flag%>>
	</td>
	
</tr>
<tr>
	<td class=label >
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	<!--Commented against MMS-QH-CRF-0199 Userstory 4-->
	<!--	<input type="text" name="operation_desc" id="operation_desc" value="<%=oper_desc%>" size=30 maxlength=30 <%=read_only%> onBlur="if(this.value!='')callCodeSearch('O','Operation Search',operation_code,operation_desc);">-->
	<!--Added against MMS-QH-CRF-0199 Userstory 4-->
	<input type="text" name="operation_desc" id="operation_desc" value="<%=oper_desc%>" size=60 maxlength=60 <%=read_only%> onBlur="if(this.value!='')callCodeSearch('O','Operation Search',operation_code,operation_desc);">
		<input type="hidden" name="operation_code" id="operation_code" value="<%=oper_code%>" >
		<input type="button" class="button" name="generic_search_for_Operation" id="generic_search_for_Operation" value="?" onclick="callCodeSearch('O','Operation Search',operation_code,operation_desc);" <%=all_operations_disabled_flag%>  >
	</td>
	
</tr>



<!--<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>-->
<input type="hidden" name='mode' id='mode' value="<%=mode%>">
<input type="hidden" name='dtlString' id='dtlString' value='<%=dtlString%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'%>
</table>



</form>
</body>
</html>


