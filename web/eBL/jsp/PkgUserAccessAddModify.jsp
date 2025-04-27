<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.*,eBL.Common.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eBL/js/PkgUserAccess.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='FocusFirstElement()' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"   >
<form name='PkgUserAccessAddModify' id='PkgUserAccessAddModify' action='../../servlet/eBL.PkgUserAccessServlet'  method='post' target='messageFrame' >
<%
	request.setCharacterEncoding("UTF-8");

	String bean_id = "PkgUserAccessBean";
	String bean_name = "eBL.PkgUserAccessBean";

	String user_id		=	"";
	String user_name	=	"";
	String user_grp_id	=	"";
	String user_grp_name	=	"";	
	String package_creation	=	"";	
	String package_approval	=	"";	
	String package_transfer	=	"";	
	String package_discount	=	"";	
	String package_refund	=	"";	
	String package_cancel	=	"";	
	String package_adhoc_refund	=	"";	
	String qry_string		=	"";
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id		= (String)session.getAttribute("facility_id");

	PkgUserAccessBean bean = (PkgUserAccessBean)getBeanObject( bean_id,  bean_name, request );
	
	String mode	   =(String)bean.checkForNull(request.getParameter( "mode" ),"insert");
	if ( !mode.equals("modify" ) ) {
		mode="insert";
	}
	bean.clear() ;
	String function_id	= (String)bean.checkForNull(request.getParameter("function_id"),"");
	bean.setFunctionId(function_id);
	bean.setFacilityId(facility_id);
	bean.setMode( mode );
	bean.setLanguageId(locale);

	if(mode.equals("modify")) {
		qry_string = request.getQueryString();
		
	try{
			user_id		=	request.getParameter( "user_id" ) ;
			user_grp_id	=	request.getParameter( "user_grp_id" ) ;

			user_id = user_id.trim();
			user_grp_id = user_grp_id.trim();
			
			bean.setUserId(user_id);
			bean.setUserGrpId( user_grp_id);

			//String[] recValues = new String[9];
			String[] recValues = (String[])bean.loadDataForUpdate() ;

			user_name	=	recValues[0];
			user_grp_name	=	recValues[1];
			package_creation	=	recValues[2];
			package_approval	=recValues[3];
			package_transfer	=	recValues[4];
			package_discount	=	recValues[5];
			package_refund	=	recValues[6];
			package_cancel	=	recValues[7];
			package_adhoc_refund	=	recValues[8];
		}catch(Exception e){
			System.out.println("Exception in PkgUserAccessAddModify.jsp="+e);
			e.printStackTrace();
		}		
		bean.setUserName(user_name);
		bean.setUserGrpName(user_grp_name);		
	}
%>

<table  cellpadding=3 cellspacing=0 border=0  width="100%" align='center'>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
		<td class='fields'><% if ( mode.equals("modify" ) )
		{%>
			<input type='text' name='user_id' id='user_id'  size='10' maxlength="30"  value='<%=user_id%>' readonly>
		<%}else{%>
			<input type='text' name='user_id' id='user_id' value='' size='10' maxlength="30"  onBlur="UserIdLookUp(user_name,this)">
			<INPUT type='hidden' name='user_id_temp' id='user_id_temp' value=''>
			<input type='button' name='user_id_button' id='user_id_button' class='button' value='?' onclick="UserLookUp(user_name,user_id)"><img src='../../eCommon/images/mandatory.gif'>
		<%}%>
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
		<td class='fields'><% if ( mode.equals("modify") )
		{%>
			<input type=text name='user_name' id='user_name' size='40' maxlength="60" value='<%=user_name%>' readonly>
		<%}else{%>
			<input type='text' name = 'user_name' size='40' maxlength="60"  onBlur="UserNameLookUp(this,user_id)" value=""><INPUT type='hidden' name='user_name_temp' id='user_name_temp' value=''><input type='button' name='user_name_button' id='user_name_button' class='button' value='?' onclick="UserLookUp(user_name,user_id)"><img src='../../eCommon/images/mandatory.gif'>
		<%}%>
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.userGroupId.label" bundle="${bl_labels}"/></td>
		<td class='fields'><% if ( mode.equals("modify") )
		{%>
			<input type='text' name='user_grp_id' id='user_grp_id' size='10' maxlength="10" value='<%=user_grp_id%>' readonly>
		<%}else{%>
			<input type='text' name='user_grp_id' id='user_grp_id' value='' size='10' maxlength="10"  onBlur="UserGrpIdLookUp(user_grp_name,this)"><INPUT type='hidden' name='user_grp_id_temp' id='user_grp_id_temp' value=''><input type='button' name='user_grp_id_button' id='user_grp_id_button' class='button' value='?' onclick="UserGrpLookUp(user_grp_name,user_grp_id)"><img src='../../eCommon/images/mandatory.gif'>
		<%}%>
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.userGroupName.label" bundle="${bl_labels}"/></td>
		<td class='fields'><% if ( mode.equals("modify") )
		{%>
			<input type=text name='user_grp_name' id='user_grp_name' size='40' maxlength="100" value='<%=user_grp_name%>' readonly>
		<%}else{%>
			<input type='text' name = 'user_grp_name' size='40' maxlength="100"  onBlur="UserGrpNameLookUp(this,user_grp_id)" value=""><INPUT type='hidden' name='user_grp_name_temp' id='user_grp_name_temp' value=''><input type='button' name='user_grp_name_button' id='user_grp_name_button' class='button' value='?' onclick="UserGrpLookUp(user_grp_name,user_grp_id)"><img src='../../eCommon/images/mandatory.gif'>
		<%}%>
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.PackageCreation.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_creation' id='package_creation' value='<%=package_creation%>' <%=package_creation.equals("Y")?"checked":""%> onClick='chkUserAccess(this);'>	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.packageApproval.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_approval' id='package_approval' value='<%=package_approval%>' <%=package_approval.equals("Y")?"checked":""%> onClick='chkUserAccess(this);'>	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.PackageTransfer.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_transfer' id='package_transfer' value='<%=package_transfer%>' <%=package_transfer.equals("Y")?"checked":""%> onClick='chkUserAccess(this);'>	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_discount' id='package_discount' value='<%=package_discount%>' <%=package_discount.equals("Y")?"checked":""%> onClick='chkUserAccess(this);'>	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.PackageRefund.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_refund' id='package_refund' value='<%=package_refund%>' <%=package_refund.equals("Y")?"checked":""%> onClick='chkUserAccess(this);'>	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
			<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.PackageCancel.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_cancel' id='package_cancel' value='<%=package_cancel%>' <%=package_cancel.equals("Y")?"checked":""%> onClick='chkUserAccess(this);'>	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
	<tr>
	<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.PackageAdhocRefund.label" bundle="${bl_labels}"/></td>
		<td class='fields'><input type='checkbox' name='package_adhoc_refund' id='package_adhoc_refund' value='<%=package_adhoc_refund%>' <%=package_adhoc_refund.equals("Y")?"checked":""%> onClick='chkUserAccess(this);' style="background-color: white;">	
		</td>
			<td class="label" colspan='2'></td>
	</tr>
</table>
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request); 
%>

