<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           										created

28/08/2015		IN057229	Vijayakumar K	28/08/2015		Ramesh Goli			Regression-EM-Alpha-Unable to access 
																				CA functions in Desktop as well as in patient Chart.
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet CustomizeIcons = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeIcons","webbeans.eCommon.RecordSet",session);
	//eCA.CAMainOptionBean CAMainMenu = (eCA.CAMainOptionBean)getObjectFromBean("CAMainMenu","eCA.CAMainOptionBean",session);
%>


<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
    
</head>
<style>

TD.CUSTMSGHEADER {
	FONT-FAMILY: verdana;
	FONT-SIZE: 8PT ;
	COLOR: #4C4C4C;
	PADDING-LEFT:5PX;
	PADDING-RIGHT:5PX;
}
TABLE.CUSTDISPMSG
{
	HEIGHT:28px;
	BACKGROUND-COLOR:#D5E3E6;
}

TABLE.CUSTOUTERTAB
{
	BORDER-LEFT:1PX;
	BORDER-RIGHT:1PX;
	BORDER-TOP:1PX;
	BORDER-BOTTOM:1PX;
	BORDER-COLOR:#666666;
	BORDER-STYLE:SOLID;
	MARGIN:0;
	BORDER-COLLAPSE: COLLAPSE;
}

TD.CUSTPREVNEXT
{
	/*BACKGROUND-COLOR:#E2E2E2;*/
	HEIGHT:0PX;
	WIDTH:0PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#333333;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:RIGHT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:TEXT-TOP;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}

TD.CUSTMSGDESC
{
	HEIGHT:30PX;
	WIDTH:247PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#333333;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:LEFT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}

TD.CUSTCHECKBOX
{
	WIDTH:10PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#333333;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:LEFT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}

TD.CUSTIMGICON
{
	WIDTH:32PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#333333;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:LEFT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}

TD.CUSTPREVMSGDESC
{
	BACKGROUND-COLOR:#E2E2E2;
	HEIGHT:30PX;
	WIDTH:247PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#888888;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:LEFT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}

TD.CUSTPREVIMGICON
{
	BACKGROUND-COLOR:#E2E2E2;
	WIDTH:32PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#888888;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:LEFT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}

TD.CUSTPREVCHECKBOX
{
	BACKGROUND-COLOR:#E2E2E2;
	WIDTH:10PX;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#333333;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:LEFT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;	
}

TD.CUSTPREVMSG
{
	BACKGROUND-COLOR:#E2E2E2;
	WIDTH:91px;
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8PT;
	COLOR:#8A0000;
	FONT-WEIGHT:NORMAL;
	TEXT-ALIGN:RIGHT;
	PADDING-LEFT:0PX;
	PADDING-RIGHT:0PX;
	VERTICAL-ALIGN:MIDDLE;
	BORDER-BOTTOM:1PX;
	BORDER-TOP:0PX;
	BORDER-LEFT:0PX;
	BORDER-RIGHT:0PX;
	BORDER-STYLE:SOLID;
	BORDER-COLOR:#EEEEEE;
}



</style>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name='CAMainCustomizeToolbarDtl' id='CAMainCustomizeToolbarDtl' action="CAMainCustomizeToolbarDtl.jsp?<%=request.getQueryString()%>"  method='post'>
<%
	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";

	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
	String patientclass = request.getParameter("patientclass") == null ? "" : request.getParameter("patientclass");

	String practitioner_id	= (String) session.getValue("ca_practitioner_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
	String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");

	String resp_id				= (String)session.getValue("responsibility_id");
	//String reln_id				= (String)session.getValue("relationship_id");
	String reln_id				= request.getParameter("relationship_id");
	String facilityId			= (String)session.getValue("facility_id");
	//String ClassValue = "";
	if(resp_id == null) resp_id = "";
	if(reln_id == null) reln_id = "";

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	//String facility_id = (String)session.getValue("facility_id");
	//String occurance = request.getParameter("occurance");

	if(from != null && to != null ) {
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
			if(request.getParameter("chk"+(i-1)) != null) {
				checkedOnes = request.getParameter("chk"+(i-1));
				if(!(CustomizeIcons.containsObject(checkedOnes))){
					CustomizeIcons.putObject(checkedOnes);
				}

				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	putObjectInBean("CustomizeIcons", CustomizeIcons,session);
	i = 1;

	try
	{
		con = ConnectionManager.getConnection(request);
		//String classValue = "";
		String option_id	= "";
		String short_desc	= "";
		String icon_file_name= "";
		String executable_name= "";
		int ilCkeckedYN = 0;
		int recordCount = 0;
		String checkStatus  = "";	
		String checkProp = "";
		String desktop_yn = "";
		String pat_appl_yn = "";
		String hist_or_record = "";
		String allow_yn = "";
		StringBuffer sql = new StringBuffer();
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	    String locale = (String) p.getProperty("LOCALE");
		sql.append("select a.OPTION_ID, LONG_DESC, ICON_FILE_NAME, EXECUTABLE_NAME, DESKTOP_YN ");

		if(!patient_id.equals(""))
		{
			if(patientclass.equals(""))
				patientclass = "XT";

			sql.append(", APPL_"+patientclass+"_YN Pat_APPL_YN , a.HIST_OR_RECORD HIST_OR_RECORD");
		}
		else
		{
			sql.append(", 'N' Pat_APPL_YN , '' HIST_OR_RECORD ");
		}
		
		sql.append(" , NVL((SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and 'A' = Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) and  (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
		if(!patient_id.equals(""))
		{
			sql.append(" and ( MODULE_GROUP_ID! = 'SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");
		}
		sql.append(" )) and rownum=1),'N') Allow_yn from ca_option_lang_vw a, CA_MENU_DETAIL b where ");

		if(!patient_id.equals(""))
		{
			sql.append(" DESKTOP_YN = 'N' ");
		}
		else
		{
			sql.append(" DESKTOP_YN = 'Y' ");
		}

		//sql.append(" and a.language_id='"+locale+"' and b.MENU_ID = '"+menu_id+"' and b.option_id = a.option_id and exists (SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and   (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ))) and ICON_FILE_NAME is not null order by a.ORDER_SEQ_NO");//common-icn-0180
		sql.append(" and a.language_id= ? and b.MENU_ID = ? and b.option_id = a.option_id and exists (SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and   (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ))) and ICON_FILE_NAME is not null order by a.ORDER_SEQ_NO");//common-icn-0180

		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		
		int indval =1;

		pstmt.setString(indval++,resp_id);
		pstmt.setString(indval++,reln_id);
		pstmt.setString(indval++,facilityId);
		pstmt.setString(indval++,episode_id);
		pstmt.setString(indval++,patient_id);
		if(!patient_id.equals(""))
			pstmt.setString(indval++,speciality_code);
		//pstmt.setString(indval++,resp_id);
		//pstmt.setString(indval++,reln_id);
		//pstmt.setString(indval++,facilityId);
		//pstmt.setString(indval++,episode_id);
		//pstmt.setString(indval++,patient_id);
        pstmt.setString(indval++,locale);//common-icn-0180
        pstmt.setString(indval++,menu_id);//common-icn-0180

		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
%>	

	 
     <table class='CUSTDISPMSG' width='100%' align='center' id=tableId  cellpadding='0' cellspacing='0' border='0'>
	     <tr>
	        <td class='CUSTMSGHEADER' id='checkcount' width='5%'/>
			<!-- IN057229 starts -->
			<!--<td id='checkcount1' class='CUSTMSGHEADER'><fmt:message key="eCA.IconsSelected.label" bundle="${ca_labels}"/>&nbsp;&nbsp;(Maximum 18)</td> -->
			<td id='checkcount1' class='CUSTMSGHEADER'><fmt:message key="eCA.IconsSelected.label" bundle="${ca_labels}"/></td>
			<!-- IN057229 ends -->
	     </tr>
	  </table>
	  <table width='100%' class='CUSTOUTERTAB' id=tableId>
	  <tr>
	  <td width='100%'>
		 <table border='0'  cellpadding='0' cellspacing='0' width='100%'>
		<%
			if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;
             }
			 ilCkeckedYN+=start;
             --ilCkeckedYN ;
			}
			recordCount			=	CustomizeIcons.getSize();

			//classValue  = "";
			while(rs.next()&& i<=end)
			{
				option_id = rs.getString("OPTION_ID")==null?"":rs.getString("OPTION_ID");
				short_desc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
				icon_file_name = rs.getString("ICON_FILE_NAME")==null?"":rs.getString("ICON_FILE_NAME");
				executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
				desktop_yn = rs.getString("DESKTOP_YN")==null?"":rs.getString("DESKTOP_YN");
				pat_appl_yn = rs.getString("Pat_APPL_YN")==null?"":rs.getString("Pat_APPL_YN");
				hist_or_record = rs.getString("HIST_OR_RECORD")==null?"":rs.getString("HIST_OR_RECORD");
				allow_yn = rs.getString("Allow_yn")==null?"":rs.getString("Allow_yn");
				//if(CAMainMenu.chkContainsValue(option_id)){

				try
				{
					if(CustomizeIcons.containsObject(option_id))
					{

						checkStatus = "Y";
					}
					else
					{
						checkStatus = "N";
					}

					int recordIndex = CustomizeIcons.indexOfObject(option_id);
					if(recordIndex!=-1){
						if(checkStatus.equals("Y")){
							CustomizeIcons.removeObject(recordIndex);
						}
					}
				} catch(Exception e) {
              //  out.println("Exception in CAMainCustomizeToolbarDtl.jsp: "+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
				}
				if(checkStatus.trim().equals("Y")) {
					checkProp = " CHECKED "; 
				} else {
					checkProp = "";
				}

		%>
				<tr >

				<!-- <td  class='CUSTCHECKBOXDESC'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
				<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
				</td>
				<td class='CUSTMSGDESC'><%=short_desc%></td> -->
				<%
				if(!patient_id.equals(""))
				{
					if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
					{
						if(!option_id.equals("CLINICAL_NOTES") && !option_id.equals("CLINICAL_NOTES_NEW") && !option_id.equals("PATCHIEFCOMPLAINT") && !option_id.equals("REL_PAT_TREAT_PAT") && !option_id.equals("CA_TASK_LIST") && !option_id.equals("CA_TASK_LIST_DT"))
						{
							if(mode.equals("V"))
							{
								if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y")){%>
								<td  class='CUSTCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
								<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
								</td>
								<td class='CUSTMSGDESC' colspan='2'><%=short_desc%></td>
								<%}else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
							}
							else
							{
								if(pat_appl_yn.equals("Y") && allow_yn.equals("Y")){%>
								<td  class='CUSTCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
								<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
								</td>
								<td class='CUSTMSGDESC' colspan='2'><%=short_desc%></td>
								<%}else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
							}
						}
						else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
					}
					else
					{
						if(mode.equals("V"))
						{
							if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y")){%>
								<td  class='CUSTCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
								<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
								</td>
								<td class='CUSTMSGDESC' colspan='2'><%=short_desc%></td>
								<%}
							else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
						}
						else
						{
							if(pat_appl_yn.equals("Y") && allow_yn.equals("Y")){%>
								<td  class='CUSTCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
								<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
								</td>
								<td class='CUSTMSGDESC' colspan='2'><%=short_desc%></td>
								<%}
							else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
						}
					}
				}
				else
				{
					if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
					{
						if(!option_id.equals("CA_TASK_LIST") && !option_id.equals("REL_PAT_TREAT") && !option_id.equals("CA_TASK_LIST_DT"))
						{
							if(desktop_yn.equals("Y") && allow_yn.equals("Y")){%>
								<td  class='CUSTCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
								<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
								</td>
								<td class='CUSTMSGDESC' colspan='2'><%=short_desc%></td>
								<%}
							else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
						}
						else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
					}
					else
					{
						if(desktop_yn.equals("Y") && allow_yn.equals("Y")){%>
								<td  class='CUSTCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
								<td class='CUSTIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
								</td>
								<td class='CUSTMSGDESC' colspan='2'><%=short_desc%></td>
								<%}
						else{%>
									<td  class='CUSTPREVCHECKBOX'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=option_id%>' <%=checkProp%> onclick='getCount(this)'></td>
									<td class='CUSTPREVIMGICON'><img src='../../eCA/images/<%=icon_file_name%>' alt='' class='IMAGE'></img>
									</td>
									<td class='CUSTPREVMSGDESC'><%=short_desc%></td>
									<td class='CUSTPREVMSG' align='center'>[<fmt:message key="eCA.NoPrivilege.label" bundle="${ca_labels}"/>]</img></td>
									<%}
					}
				}
		%>
				</tr>

		<%
				ilCkeckedYN = ilCkeckedYN + 1;		
				i=i+1;
				//}
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance value='next'>");
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		%>

		
		</table>
		
		<input type=hidden name=from value='<%=start%>'>
		<input type=hidden name=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
		<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type=hidden name='menuId' id='menuId' value='<%=menu_id%>'>
		<input type=hidden name='patientclass' id='patientclass' value='<%=patientclass%>'>
		<input type=hidden name='mode' id='mode' value='<%=mode%>'>
	<script>
				//document.getElementById('checkcount').innerText = '<%=recordCount%>';
				document.getElementById('checkcount').innerText = '<%=recordCount%>';
	</script>
	</td>
	</tr>
	<tr>
	<td>
	<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
			<td class='CUSTPREVNEXT' width='100%'>
	
	<%
		if ( !(start <= 1)) 
		{%>
			<a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><img id='imgPrv' src='../../eCommon/images/prev.jpg' style='visibility:visible'></img></a>
				<input type=hidden name='whichPage' id='whichPage' value='prev'>
		<%}else
			{%>
				<img id='imgPrv' src='../../eCommon/images/prev.jpg' style='visibility:hidden'></img>
			<%}
	
		if ( !((start+10) > maxRecord ))
		{%>
			<a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><img id='imgNext' src='../../eCommon/images/next.jpg' style='visibility:visible'></img></a>
				<input type=hidden name='whichPage' id='whichPage' value='next'>
		<%}
			else
			{%>
				<img id='imgNext' src='../../eCommon/images/next.jpg' style='visibility:hidden'></img>
			<%}
	%>
			</td>
		</tr>
	 </table>	




</td>
		</tr>
	 </table>
	 <%
		}
		catch(Exception e){
			//out.println("Exception in CAMainCustomizeToolbarDtl.jsp"+e.toString());//COMMON-ICN-0181
                           e.printStackTrace();//COMMON-ICN-0181
		}finally{
		    if(con != null)ConnectionManager.returnConnection(con,request);
		}
	 %>
</form>
</body>
<script>
	function submitPrevNext(from, to)
	{
		document.CAMainCustomizeToolbarDtl.from.value = from;
        document.CAMainCustomizeToolbarDtl.to.value = to; 
        document.CAMainCustomizeToolbarDtl.target = "detailFrame"
        document.CAMainCustomizeToolbarDtl.submit();
	}
	function getCount(obj)
	{
		var count;
		if(document.getElementById('checkcount').innerText == 'undefined' || document.getElementById('checkcount').innerText == '')
			count = 0;
		else
			count = document.getElementById('checkcount').innerText;
			count = parseInt(count,10);
		if(obj.checked == true)
		{
			count = count+1;
		}
		else
		{
			count = count-1;
		}
		//IN057229 starts
		/*if(count >= 19)
		{*/
			//var msg = getMessage("MAXIMUM_ICONS_ALLOWED","CA");
			//msg = msg + " 19";
			//parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		/*	document.getElementById('checkcount').style.color='#8A0000';
			document.getElementById('checkcount1').style.color='#8A0000';
			obj.checked = false;
			return false;

		}
		else{*/
		//IN057229 ends
			document.getElementById('checkcount').innerText = count;
			document.getElementById('checkcount').style.color='#4C4C4C';
			document.getElementById('checkcount1').style.color='#4C4C4C';
		//}IN057229
			
	}
	/*function updateIcons()
	{
		document.CAMainCustomizeToolbarDtl.action = "../../servlet/eCA.CAMainCustomizeToolbarServlet?<%=request.getQueryString()%>"
        document.CAMainCustomizeToolbarDtl.submit();
	}*/
</script>
</html>

