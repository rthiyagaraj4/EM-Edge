<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

28/11/2019       IN059899        PRATHYUSHA                          JD-CRF-0200
-------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page contentType="text/html;charset=UTF-8"    import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
	<title><fmt:message key="ePH.MedicationAdministrationRights.label" bundle="${ph_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String user_id="";
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="JavaScript" src="../../ePH/js/MedicationAdministrationRights.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown="lockKey()">

	<form method=post  name="MedicationAdministrationRightsListForm" id="MedicationAdministrationRightsListForm" action="">
	<%
	Properties		jdbc_props			=	null;
	String mode							=	"";
	String bean_id						=	"";
	String bean_name					=	"";
	String facility_id					= (String) session.getValue("facility_id");
	
	boolean searched					=	false;
	int     i							=	0;
	int		recCount					=	0;
	/* Mandatory checks start */
	try{
	mode								=	request.getParameter( "mode" ) ;
	bean_id								=	"MedicationAdministrationRightsBean" ;
	bean_name							=	"ePH.MedicationAdministrationRightsBean";
	if ( mode == null || mode.equals("") ) 
		return ;
	/* Mandatory checks end */

	
	/* Initialize Function specific start */
	MedicationAdministrationRightsBean bean			=	(MedicationAdministrationRightsBean)getBeanObject( bean_id, bean_name,request) ;  
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	user_id								=	CommonAdapter.checkForNull( request.getParameter("user_id") );
	jdbc_props							=	(Properties) session.getAttribute("jdbc");
	searched							=	(request.getParameter("searched") == null) ?false:true;

	putObjectInBean(bean_id,bean,request);
	String  adminYn="Y";
	String   selfAdminYn="Y";
	String   holdYn="Y";
	String  cndNotAdminYn="Y";
	String discontinueYn="Y";
	String cancelAdminYn="N";
	
	String  adminYnChecked="checked";
	String   selfAdminYnChecked="checked";
	String   holdYnChecked="checked";
	String  cndNotAdminYnChecked="checked";
	String discontinueYnChecked="checked";
	String cancelAdminYnChecked="";
	
	HashMap sqlMap						=	new HashMap();
	sqlMap.put("sqlData",  PhRepository.getPhKeyValue("PH_MED_CANCEL_RIGHTS_SELECT"));
	
	HashMap funcMap						=	new HashMap();

	//The fields are going to be display
	ArrayList displayFields				=	new ArrayList();

	
	displayFields.add("admin_yn");
	displayFields.add("self_admin_yn");
	displayFields.add("hold_yn");
	displayFields.add("cnd_not_admin_yn");
	displayFields.add("discontinue_yn");
	displayFields.add("cancel_admin_yn");
	
	ArrayList chkFields					=	new ArrayList();
	chkFields.add(user_id);
	chkFields.add(facility_id);

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	ArrayList records			=		new ArrayList();
	if(result.size()>2){
	records						=		(ArrayList) result.get(2);
	  adminYn=(String)records.get(0)==null ? "N" :(String)records.get(0);
	  selfAdminYn=(String)records.get(1)==null ? "N" :(String)records.get(1);
	  holdYn=(String)records.get(2)==null ? "N" :(String)records.get(2);
	  cndNotAdminYn=(String)records.get(3)==null ? "N" :(String)records.get(3);
	 discontinueYn=(String)records.get(4)==null ? "N" :(String)records.get(4);
	 cancelAdminYn=(String)records.get(5)==null ? "N" :(String)records.get(5);
	   if(adminYn.equals("Y")){
		   adminYnChecked="checked";  
	   }
	   if(selfAdminYn.equals("Y")){
		   selfAdminYnChecked="checked";  
	   }
	   if(holdYn.equals("Y")){
		   holdYnChecked="checked";
	   }
	   if(cndNotAdminYn.equals("Y")){
		   cndNotAdminYnChecked="checked";
	   }
	   if(discontinueYn.equals("Y")){
	    	 discontinueYnChecked="checked";
	    }
	    
	   if(cancelAdminYn.equals("Y")){
			 cancelAdminYnChecked="checked";
		 }
		 
	}
		
	
	System.out.println("prathyusha result"+result);
		%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center">
			<th colspan="6" ><fmt:message key="ePH.MedicationAdminstrationRightsType.label" bundle="${ph_labels}"/></th>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr>
			</tr>
			<tr></tr>
				<tr >
							<td class="label" width='20%'><fmt:message key="ePH.admin.label" bundle="${ph_labels}"/></td>
							<td class="label" width='20%'><input type="checkbox" <%=adminYnChecked%> name="admin" value="<%=adminYn%>" onClick="assignValue(this)" disabled  />
							</td>
							<td class="label" width='20%'><fmt:message key="ePH.selfadmin.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3"><input type="checkbox" <%=selfAdminYnChecked%> name="self_admin" value="<%=selfAdminYn%>"  disabled  />
							</td>
							<td class="label" width='20%'><fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3"><input type="checkbox" <%=holdYnChecked%>  name="hold" value="<%=holdYn%>"  disabled  />
							</td>
						</tr>
						
						<tr >
							<td class="label" width='20%'><fmt:message key="ePH.CancelAdmin.label" bundle="${ph_labels}"/></td>
							<td class="label" width='20%'> <input type="checkbox" name="cancel_admin" id="cancel_admin" <%=cancelAdminYnChecked%> value="<%=cancelAdminYn%>" onClick="assignValue(this)" />
							</td>
							<td class="label" width='20%'><fmt:message key="ePH.CouldNotAdmin.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3"><input type="checkbox"  <%=cndNotAdminYnChecked%> name="could_not_admin" value="<%=cndNotAdminYn%>" disabled   />
							</td>
							<td class="label" width='20%'><fmt:message key="ePH.Discontinue.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3"><input type="checkbox"  <%=discontinueYnChecked%> name="discontinue" value="<%=discontinueYn%>" disabled  />
							</td>
						</tr>
				
		   
				
				
</table>
					<input type="hidden"  value="<%=user_id%>" name="user_id" />
					<input type="hidden" name="mode" id="mode"			value="<%=eCommon.Common.CommonRepository.getCommonKeyValue(mode)%>" />
					<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>" />
					<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>" />
<%		}
	catch(Exception e){
		e.printStackTrace();
	}
	
//	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/MedicationAdministrationRightsDetail.jsp", searched) );
  %>
</form>
</body>
</html>


 

