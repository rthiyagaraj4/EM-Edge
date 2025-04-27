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
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale = (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script language="javascript" src="../../ePH/js/MedicationAdminstrationRights.js"></script>


</head>
<body onMouseDown="CodeArrest()" >
<%
	String user_id        = request.getParameter("user_id");
	String appl_user_name = request.getParameter("appl_user_name");
	String right_type     = request.getParameter("right_type");
	String facility_id					= (String) session.getValue("facility_id");
	
	
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
	String bean_id="";
	String bean_name="";
	bean_id								=	"MedicationAdministrationRightsBean" ;
	bean_name							=	"ePH.MedicationAdministrationRightsBean";
    String sqlQuery="";
	MedicationAdministrationRightsBean bean			=	(MedicationAdministrationRightsBean)getBeanObject( bean_id, bean_name,request) ; 

	try{

		

		user_id        	= CommonBean.checkForNull(user_id        )+"%";
		appl_user_name 	= CommonBean.checkForNull(appl_user_name )+"%";
		if(right_type.equals("Y")){
			right_type=CommonBean.checkForNull(right_type);
		}
		if(right_type.equals("Y")){
			sqlQuery=PhRepository.getPhKeyValue("PH_MED_CANCEL_RIGHTS_QUERY1");
		}
		else{
			sqlQuery=PhRepository.getPhKeyValue("PH_MED_CANCEL_RIGHTS_QUERY2");
		}
		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", sqlQuery);
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

			displayFields.add("user_id");
			displayFields.add("appl_user_name");
			
			displayFields.add("admin_yn");
			displayFields.add("self_admin_yn");
			displayFields.add("hold_yn");
			displayFields.add("cnd_not_admin_yn");
			displayFields.add("discontinue_yn"); 
			displayFields.add("cancel_admin_yn");


		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(user_id);
		chkFields.add(appl_user_name);
		chkFields.add(locale);
		chkFields.add(facility_id);
		if(right_type.equals("Y")){
			chkFields.add(right_type);
			
		}
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0  align="center" width="100%">
			<tr>
				<td class="white" nowrap>&nbsp;
				<%
					out.println(result.get(1));
				%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0"  width="100%">
			<tr>
				<th align="center" width="10%" rowspan="2"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
				<th align="center" width="30%" rowspan="2"><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
				<th nowrap  width="60%" colspan=6><fmt:message key="ePH.MedicationAdminstrationRightsType.label" bundle="${ph_labels}"/><br>
			</tr>
			<tr>
				<th width="10%"><fmt:message key="ePH.admin.label" bundle="${ph_labels}"/></th>
				<th width="10%"><fmt:message key="ePH.selfadmin.label" bundle="${ph_labels}"/></th>
				<th width="10%"><fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></th>
				<th width="10%"><fmt:message key="ePH.CouldNotAdmin.label" bundle="${ph_labels}"/></th>
				<th width="10%"><fmt:message key="ePH.Discontinue.label" bundle="${ph_labels}"/></th>
				<th width="10%"><fmt:message key="ePH.CancelAdmin.label" bundle="${ph_labels}"/></th>
			</tr>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="parent.Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );

				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
						

						

		<%
					}else{
		%>
						<td  nowrap onclick="disableClick(event);"
						<%
						
							if(colCount >= 2) {
								out.println(" align=\'center\' >");
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get( colCount ));
							}
						
						%>

						</td>
		<%
						}
					}
		%>
			</tr>
		<%
			}
		%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/MedicationAdministrationRightsQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>
 

