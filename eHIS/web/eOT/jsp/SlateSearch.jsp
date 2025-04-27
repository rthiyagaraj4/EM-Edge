<!DOCTYPE html>
<%@page  import ="eOT.*, eOT.Common.*,java.util.ArrayList,eOT.Common.OTRepository,eCommon.Common.*,eCommon.Common.CommonBean,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.CallableStatement,java.sql.Types,eCommon.XSSRequestWrapper,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); 
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<%

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/Slate.js"></script>
	<script language="JavaScript" src="../../eOT/js/Barcode.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type='text/javascript' src='../../eCommon/js/dchk.js'></script> 
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	 <script src='../../eXH/js/ExternalApplication.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		  }
	</style>
</head>
<%
	//PMG -CRF-003
	ArrayList arr_list_user_roles=new ArrayList();
	String loginUser="";
	String role="";
	String pract_type="";
	String user_role_name_temp = "";
	String user_role_select = "";
	String user_role_temp   = "";
	//PMG -CRF-003
	String more_Less_Criteria_Flag="";
	String facility_id	= (String) session.getValue("facility_id");
	String mode			= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params		= request.getQueryString() ;
	String refresh_flag	= request.getParameter("refresh_flag");
	String calledFrom = ""; //IN052054
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String theatre_date	= "";
	String theatre_date_from	= "";
	String theatre_view	= "ALL";
	String speciality	= "";
	String theatre_type	= "ALL";
	String surgeon		= "";
	String surgeon_name = "";
	String deflt="";
	//String user_role_name ="";
	String user_role	= "";
	String by_time_seq	= "T";
	String view_by		= "A";
	String theatre		= "";
	String theatre_from = "";
	String theatre_to	= "";
	String setup_Role_YN="";//PMG -CRF-003
	String roleType="";//003
	String theatre_period_from = "";
	String bean_id		= "SlateBean";
	String bean_name	= "eOT.SlateBean";
	SlateBean   bean  = (SlateBean)mh.getBeanObject(bean_id, request, bean_name);
	String sql_ot_slate_select5=(String) OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT5");
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;//PMG -CRF-003
	PreparedStatement pstmt1 = null ;
	ResultSet rs1 = null ;
	PreparedStatement pstmt2 = null ;
	ResultSet rs2 = null ;
	PreparedStatement pstmt3 = null ;
	ResultSet rs3 = null ;//PMG -CRF-003
	PreparedStatement pstmt4 = null ;
	ResultSet rs4 = null ;
	PreparedStatement pstmt5 = null ;
	ResultSet rs5 = null ;
	//MO-IN:052629
	String PatIDLen="";
	PreparedStatement pstmt6 = null ;
	ResultSet rs6 = null ;
	//MO-IN:052629
	String external_link="";
	if(refresh_flag!=null && !refresh_flag.equals("null") && !refresh_flag.equals(""))
	{
		more_Less_Criteria_Flag	=	request.getParameter("more_Less_Criteria_Flag");
		theatre_date	=	request.getParameter("theatre_date");
		theatre_date_from	=	request.getParameter("theatre_date_from");
		theatre_view	=	CommonBean.checkForNull(request.getParameter("theatre_view"),"ALL");
		speciality		=	request.getParameter("speciality");
		theatre_type	=	request.getParameter("theatre_type");
		surgeon			=	request.getParameter("surgeon");
		surgeon_name	=	request.getParameter("surgeon_name");
		user_role		=	request.getParameter("user_role");
		by_time_seq		=	request.getParameter("by_time_seq");
		view_by			=	request.getParameter("view_by");
	}

	//IN052054 start
	calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom"); 
	//IN052054 end
	//CRF-AAKH-62.1
	String functionId = request.getParameter("function_id") == null ? "" : request.getParameter("function_id"); 
	//CRF-AAKH-62.1
	if(more_Less_Criteria_Flag==null || theatre_date.equals("null") || theatre_date.equals(""))
		more_Less_Criteria_Flag = "Y";
	if(theatre_date==null)
		theatre_date = bean.getSysDateTime();
	else if(theatre_date.equals("null") || theatre_date.equals(""))
		theatre_date = bean.getSysDateTime();
		theatre_date = com.ehis.util.DateUtils.convertDate(theatre_date,"DMY","en",locale);
		ArrayList menu_list_arr = (ArrayList)bean.getBarcodeMenuList();
		CallableStatement cstmt = null;
		String bl_installed="";
		String err_text = "";
		String bl_interface="";
		String sm_site_param_val=""; //Added on 2/14/2011 by AnithaJ for satya sai
		boolean bill_flag = false;
	try
	{
		connection	= ConnectionManager.getConnection(request);
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=connection.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();
   }finally{
		try{
			//if(rst!=null)rst.close();
			if(cstmt!=null)cstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	try{
		String sql_status =" SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') TO_DATE, TO_CHAR((SYSDATE- NVL(INCLUDE_CASES_FOR_PAST_DAYS,0)),'DD/MM/YYYY') FROM_DATE ,EXTERNAL_LINK_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		connection			= ConnectionManager.getConnection(request);
		pstmt				= connection.prepareStatement(sql_status) ;
		rs				= pstmt.executeQuery();
		while(rs!=null && rs.next()){
			theatre_period_from=com.ehis.util.DateUtils.convertDate(rs.getString("FROM_DATE"),"DMY","en",locale);
			 /*This method added by venkatesh.s against RUT-CRF-0083.4[IN041509] on 27-aug-2013*/
			external_link =rs.getString("EXTERNAL_LINK_YN")==null ? "" : rs.getString("EXTERNAL_LINK_YN");
			/*end RUT-CRF-0083.4[IN041509] */
		}
	}catch(Exception e){
		e.printStackTrace();
   }finally{
		try{
			//if(rst!=null)rst.close();
			if(cstmt!=null)cstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
if(theatre_date_from==null)
	theatre_date_from = theatre_period_from;
else if(theatre_date_from.equals("null") || theatre_date_from.equals(""))
	theatre_date_from = theatre_period_from;
try
	{
			//AAKH-CRF-0064 [IN:052057] start
			HashMap SurgeonName=new HashMap();
			SurgeonName=(HashMap)bean.getSurgeonName(p_user_name,facility_id,locale);
			if(!SurgeonName.isEmpty()){

			surgeon_name=(String)SurgeonName.get("surgeon_name");
			surgeon=(String)SurgeonName.get("surgeon");
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		//AAKH-CRF-0064 [IN:052057] End
%>
<body onKeyDown = 'lockKey()' onload="clickSearch();">
<form name="SlateSearchForm" id="SlateSearchForm" >
<table cellpadding=3  cellspacing="0" width='100%' align='center' border="0">
<tr>
	<td class='label' width='25%'><fmt:message key="eOT.TheatrePeriod.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
	<input type="text" name="theatre_date_from" id="theatre_date_from" size="10" maxlength=10 value="<%=theatre_date_from%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);' >
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('theatre_date_from');"><img src='../../eCommon/images/mandatory.gif'></img>
		<input type="text" name="theatre_date" id="theatre_date" size="10" maxlength=10 onkeypress="return checkForSpecCharsforID(event);" value="<%=theatre_date%>" onblur='isValidDate(this);' >
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('theatre_date');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
	<td class='label' width='25%'><fmt:message key="eOT.UserRole.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
		<select name="user_role" id="user_role" onChange="">
		<%
			try
			{
				connection	= ConnectionManager.getConnection();
				//MO-IN:052629
				pstmt6=connection.prepareCall("SELECT PATIENT_ID_LENGTH from MP_PARAM");
				rs6=pstmt6.executeQuery();

			if(rs6!=null && rs6.next()==true)
			{
				 PatIDLen   = (rs6.getString("PATIENT_ID_LENGTH")==null)?"0":rs6.getString("PATIENT_ID_LENGTH");	 
			}
			if(rs6!=null)		rs6.close();
			if(pstmt6 !=null) pstmt6.close();
			//MO-IN:052629
			int size=0;
			String responsibility_id=(String) session.getValue( "responsibility_id" ) ;
			String setupYN="select appl_user_id from OT_ROLES_FOR_USERS where appl_user_id ='"+p_user_name+"'";
			String role_type_slate="select ROLE_ID , ROLE_DESC from OT_ROLES where ROLE_ID in (select ROLE_ID from OT_ROLES_FOR_USERS where APPL_USER_ID= ? and IS_DEFAULT='Y')";
			String defaultYN="SELECT DEF_USER_ROLE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
			//String user_mapping="SELECT pract_type FROM sm_appl_user_vw WHERE appl_user_id = ?";//46044
			String user_mapping="SELECT  a.role_type role_type FROM ot_roles_lang_vw a WHERE role_type IN (SELECT role_type FROM ot_pract_types_for_role_type WHERE pract_type IN (SELECT pract_type FROM sm_appl_user_vw WHERE appl_user_id = ? ))AND language_id ='"+locale+"'";//IN050336
			String  roleTypeYN="SELECT a.role_type role_type FROM ot_roles_lang_vw a WHERE role_type IN (SELECT role_type FROM ot_pract_types_for_role_type WHERE pract_type IN (SELECT pract_type FROM sm_appl_user_vw WHERE appl_user_id = ?))AND language_id ='"+locale+"'";//003//051463
			
			pstmt5= connection.prepareStatement(roleTypeYN);
			pstmt5.setString(1,p_user_name); 
			rs5= pstmt5.executeQuery();
			while(rs5!=null && rs5.next())
			  roleType="";//051463
			pstmt1= connection.prepareStatement(user_mapping);
			pstmt1.setString(1,p_user_name); 
			rs1= pstmt1.executeQuery();
			while(rs1!=null && rs1.next())
			   loginUser=rs1.getString("role_type");//46044
			pstmt4= connection.prepareStatement(setupYN);
			//pstmt4.setString(1,p_user_name); 
			rs4= pstmt4.executeQuery();
			while(rs4!=null && rs4.next())
				   setup_Role_YN = rs4.getString("appl_user_id");
			pstmt3= connection.prepareStatement(defaultYN);
			pstmt3.setString(1,facility_id); 
			rs3= pstmt3.executeQuery();
			while(rs3!=null && rs3.next())
				deflt = rs3.getString("DEF_USER_ROLE");
			pstmt2= connection.prepareStatement(role_type_slate);
			pstmt2.setString(1,p_user_name); 
			rs2= pstmt2.executeQuery();
			while(rs2!=null && rs2.next())
			{
				size++;
				if(size>2)
					role="";
				else
					role = rs2.getString(1);
			}
			if((loginUser != null && loginUser.trim().length() > 0) && (deflt != null && deflt.equals("Y")) && (roleType != null && !roleType.equals("Y")))//003
			{
				if(setup_Role_YN != null && setup_Role_YN.trim().length() > 0)
				{
					user_role = role;
					arr_list_user_roles=bean.getDefaultUserRoles(p_user_name);
%>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
<%
				}
				else
				{
					arr_list_user_roles = bean.getApplicableUserRoles(p_user_name);
%>
					<option value="" selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
<%
				}
			}
			else
			{
				//System.err.println("==========loginUser===elseeee=======");
				arr_list_user_roles = bean.getUserRoles();
				//System.err.println("arr_list_user_roles.size()====================="+arr_list_user_roles.size());
%>
				<option value="" selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>

<%	
			}
			for (int i=0;i<arr_list_user_roles.size();i=i+2)
			{
				user_role_temp      = (String)arr_list_user_roles.get(i);
				user_role_name_temp = (String)arr_list_user_roles.get(i+1);
				if(user_role.equals(user_role_temp))
					user_role_select = "selected";
				else 
					user_role_select = "";
%>
				<option value="<%=user_role_temp%>" <%=user_role_select%>> <%=user_role_name_temp%>	</option>
<% 
			}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt2!=null)pstmt2.close();
				if(rs2!=null)rs2.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
			}
			catch(Exception e){}
		}
%>
		</select><img src="../../eCommon/images/mandatory.gif" id="mand_id_" ></img>
	</td>
</tr>
<tr>
		<%
			if(theatre_view.equals("ALL")){
		%>
				<td class='label' width='25%'><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td> 
				<td class='fields' width='25%'><select name="theatre" id="theatre">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
				try{
					String theatre_temp   = "";
					String theatre_select = "";	
					String theatre_desc = "";	
					String sql_theatre =" SELECT OPER_ROOM_CODE, SHORT_DESC FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND OPERATING_FACILITY_ID='"+facility_id+"' AND NVL(STATUS,'E') = 'E' ORDER BY 2";
					connection			= ConnectionManager.getConnection(request);
					pstmt				= connection.prepareStatement(sql_theatre) ;
					rs					= pstmt.executeQuery();
					while(rs!=null && rs.next()){
						theatre_temp=rs.getString(1);
						theatre_desc=rs.getString(2);
						if(theatre.equals(theatre_temp)){
								theatre_select = "selected";
							}else {
								theatre_select = "";
							}
			%>
						<option value="<%=theatre_temp%>" <%=theatre_select%>> 
							<%=theatre_desc%>	
						</option>
			<%

					}
					
				}catch(Exception e){
					e.printStackTrace();

			   }finally{
					try{
						//if(rst!=null)rst.close();
						if(cstmt!=null)cstmt.close();
						if(connection!=null) ConnectionManager.returnConnection(connection,request);
					}catch(Exception e){}

						}
		%>
					</select>
					<input type='hidden' name='theatre_from' id='theatre_from' value="">
					<input type='hidden' name='theatre_to' id='theatre_to' value="" >
				</td>
		<%
		}else if(theatre_view.equals("S")){
		%>
			<td class='label' width='25%'><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td> 
			<td class='fields' width='25%'><select name="theatre" id="theatre">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
						if(theatre_type!=null && !theatre_type.equals("null") && !theatre_type.equals("")){
							String theatre_temp   = "";
							String theatre_select = "";
							ArrayList arr_list_theatres = bean.getTheatres(theatre_type);
							if(arr_list_theatres!=null){
								for (int i=0;i<arr_list_theatres.size();i=i+2){
									theatre_temp   = (String)arr_list_theatres.get(i);
									if(theatre.equals(theatre_temp)){
										theatre_select = "selected";
									}else {
										theatre_select = "";
									}
					%>
								<option value="<%=theatre_temp%>" <%=theatre_select%>> 
									<%=arr_list_theatres.get(i+1)%>	
								</option>
					<%
								}
							}
						}
					%>
				</select>
				<input type='hidden' name='theatre_from' id='theatre_from' value="">
				<input type='hidden' name='theatre_to' id='theatre_to' value="" >
			</td>
	<%
		}else if(theatre_view.equals("M")){
	%>			
		<td class='label' width='25%'><fmt:message key="eOT.Theatrefrom.Label" bundle="${ot_labels}"/></td>
		<td class='fields' width='25%'><select name="theatre_from" id="theatre_from">
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<%
					if(theatre_type!=null && !theatre_type.equals("null") && !theatre_type.equals("")){
						String theatre_from_temp   = "";
						String theatre_from_select = "";
						ArrayList arr_list_from_theatres = bean.getTheatres(theatre_type);
						if(arr_list_from_theatres!=null){
							for (int i=0;i<arr_list_from_theatres.size();i=i+2){
								theatre_from_temp   = (String)arr_list_from_theatres.get(i);
								if(theatre_from.equals(theatre_from_temp)){
									theatre_from_select = "selected";
								}else {
									theatre_from_select = "";
								}
				%>
							<option value="<%=theatre_from_temp%>" <%=theatre_from_select%>> 
								<%=arr_list_from_theatres.get(i+1)%>	
							</option>
				<%
							}
						}
					}
				%>
			</select>
			 <label id="to_label" >To</label>
				<select name="theatre_to" id="theatre_to">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<%
					if(theatre_type!=null && !theatre_type.equals("null") && !theatre_type.equals("")){
						String theatre_to_temp   = "";
						String theatre_to_select = "";
						ArrayList arr_list_to_theatres = bean.getTheatres(theatre_type);
						if(arr_list_to_theatres!=null){
							for (int i=0;i<arr_list_to_theatres.size();i=i+2){
								theatre_to_temp   = (String)arr_list_to_theatres.get(i);
								if(theatre_to.equals(theatre_to_temp)){
									theatre_to_select = "selected";
								}else {
									theatre_to_select = "";
								}
				%>
							<option value="<%=theatre_to_temp%>" <%=theatre_to_select%>> 
								<%=arr_list_to_theatres.get(i+1)%>	
							</option>
				<%
							}
						}
					}
				%>
			</select><img src="../../eCommon/images/mandatory.gif" id="mand_id_" ></img>
			<input type='hidden' name='theatre' id='theatre' value="">
		</td>
	<%
		}
	%>	
	<td class='label' width='25%' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type="text"name='surgeon_name' maxlength='30' size='15' value= "<%=surgeon_name%>" onBlur="if(this.value!='')return searchSurgeonslate(document.SlateSearchForm.surgeon_name); else surgeon.value='' " >
	<input type="hidden" name="surgeon" id="surgeon" value="<%=surgeon%>"><input type='button' class='button' value='?' name='generic_search' id='generic_search' onClick="return searchSurgeonslate(document.SlateSearchForm.surgeon_name);" ></td>
		<!-- <td align="right" class='fields' colspan="1">Surgeon</td>
		<td align="left" class='fields'>
			<input type="text"  name="surgeon_name" id="surgeon_name" size='15' value="<%=surgeon_name%>" onblur="searchSurgeons(document.SlateSearchForm.surgeon_name);">
			<input type="hidden" name="surgeon" id="surgeon" value="<%=surgeon%>">
			<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="searchSurgeons(document.SlateSearchForm.surgeon_name);">
		</td> -->
		<input type=hidden name="theatre_view" id="theatre_view" value="S" >

	</tr>
	<!-- MO-CRF-20082 start-->
	<tr>
		<td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="fields" width="25%" > 
			<!-- IN:052629 -->
				<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)" onBlur="if(this.value!='')callPatientSearch();else clearPatientName();" value= "" >
				<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
		</td>
		</td>
			<td class='label' width="25%" >
				<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>     
			</td>
			<td class='fields' width="25%" >
				<input type='text' name='patient_name' id='patient_name' maxlength='100' size='30' value= "" readOnly><!--IN:053032-->
		</td>		
	</tr>
	<!-- MO-CRF-20082 end -->
	<tr>
	<td class='label' width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<select name="status" id="status" multiple>
	<%
				if(calledFrom != null && calledFrom.equals("CA"))
				{
	%>
					<option value="" >
	<%
				}
				else
				{
	%>
					<option value="" selected>
	<%
				}
	%>
			<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<%
		try
		{
			String sql_status ="SELECT STATUS_DESC, STATUS_CODE FROM OT_STATUS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";
			connection			= ConnectionManager.getConnection(request);
			pstmt				= connection.prepareStatement(sql_status) ;
			rs			= pstmt.executeQuery();
			//IN052054 start
			String statusKey = "";
			String statusVal = "";
			while(rs!=null && rs.next())
			{
				statusKey = rs.getString(2);
				statusVal = rs.getString(1);
				//AAKH-CRF-0062.1
				if((calledFrom != null && calledFrom.equals("CA")) && !(functionId.equals("OT_CASE_CALLED")) && (statusKey != null && !(statusKey.equals("70") || statusKey.equals("99"))))
				{								
			%>
				<option value="<%=statusKey%>" selected> <%=statusVal%> </option>
			<%
				}
				//Added against AAKH-CRF-0062.1
				else if((calledFrom != null && calledFrom.equals("CA")) && (functionId.equals("OT_CASE_CALLED")) && (statusKey != null && (statusKey.equals("30"))))
				{
				%>
					<option value="<%=statusKey%>" selected> <%=statusVal%> </option>
				<%
					}
					else
					{
			%>
					<option value="<%=statusKey%>"> <%=statusVal%> </option>
			<%
				}
				}
				//IN052054 end
				}
				catch ( Exception e ) 
				{
					e.printStackTrace();
				}
				finally 
				{
					try
					{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(connection!=null) ConnectionManager.returnConnection(connection,request);
					}
					catch(Exception es)
					{
						es.printStackTrace();
					}
			}
			%>		
	</td>
	<td class='label' width='25%'><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><select name="view_by" id="view_by">
		<%
			if(view_by.equals("S"))
			{
		%>
				<option value="S" selected><fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/></option>
				<option value="U"><fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/></option>
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
			}
			else if(view_by.equals("U"))
			{
		%>
				<option value="S"><fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/></option>
				<option value="U" selected><fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/></option>
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
			}
			else
			{
		%>
				<option value="S"><fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/></option>
				<option value="U" ><fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/></option>
				<option value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
			}
		%>
		</select>
	</td>
	</tr>	
<%
	try{
			String sql_param ="select nvl(CUSTOMER_ID,'SRR') param_val from sm_site_param";
			connection		= ConnectionManager.getConnection(request);
			pstmt			= connection.prepareStatement(sql_param) ;
			rs				= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				sm_site_param_val=rs.getString("param_val");
			}
		}catch ( Exception e ) {
            e.printStackTrace();
		}finally {
            try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
               }catch(Exception es){es.printStackTrace();}
        }//end		
		if(sm_site_param_val.equals("SS"))
		{
%>
	<tr> 
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><select name="speciality" id="speciality">
	<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<%
			String speciality_code_temp   = "";
			String speciality_code_select = "";
			ArrayList arr_list_speciality_codes = bean.getSpecialities();
			if(arr_list_speciality_codes!=null){
				for (int i=0;i<arr_list_speciality_codes.size();i=i+2){
					speciality_code_temp   = (String)arr_list_speciality_codes.get(i);
					if(speciality.equals(speciality_code_temp)){
						speciality_code_select = "selected";
					}else {
						speciality_code_select = "";
					}
		%>
				<option value="<%=speciality_code_temp%>" <%=speciality_code_select%>> 
					<%=arr_list_speciality_codes.get(i+1)%>	
				</option>
		<%
				}
			}
		%>
		</select>
	</td>

		<td class='label' colspan='2' width='50%'>&nbsp;</td>
	</tr>
	<%}%>
	</table>
	<%
if(more_Less_Criteria_Flag.equals("Y"))
{
	%>
	<table border='0' cellpadding='3' cellspacing=0 width='100%'  id='moreCriteria' name='moreCriteria' id='moreCriteria' style='visible:hidden;display:none'  bordercolor='white'> 
<%
 }
 else
 {
%>
	<table border='0' cellpadding='3' cellspacing=0 width='100%'  id='moreCriteria' name='moreCriteria' id='moreCriteria' style='visible:inline;'  bordercolor='white'> 
<%
 }
%>
	<tr>
	<td class='label' width='25%'>
		<fmt:message key="eOT.ElectiveEmergency.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<select name="elec_emer" id="elec_emer">
			<option value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="EL"><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
			<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		</select>
	</td>
<%
if(sm_site_param_val.equals("SS"))
{
%>
		<td class='label' colspan='2' width='50%'>&nbsp;</td>
<%
}
else
{
%>

	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><select name="speciality" id="speciality">
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
				String speciality_code_temp   = "";
				String speciality_code_select = "";
				ArrayList arr_list_speciality_codes = bean.getSpecialities();
				if(arr_list_speciality_codes!=null){
					for (int i=0;i<arr_list_speciality_codes.size();i=i+2){
						speciality_code_temp   = (String)arr_list_speciality_codes.get(i);
						if(speciality.equals(speciality_code_temp)){
							speciality_code_select = "selected";
						}else {
							speciality_code_select = "";
						}
			%>
					<option value="<%=speciality_code_temp%>" <%=speciality_code_select%>> 
						<%=arr_list_speciality_codes.get(i+1)%>	
					</option>
			<%
					}
				}
			%>
		</select>
	</td>

<%}%>
	</tr>

<tr>
<td class='label' width='25%' ><fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'><select name="theatre_type" id="theatre_type">
		<option value="ALL"><fmt:message key="eOT.AllTheatres.Label" bundle="${ot_labels}"/></option>
			<%
				String theatre_type_temp   = "";
				String theatre_type_select = "";
				ArrayList arr_list_theatre_types = bean.getTheatreTypes();
				if(arr_list_theatre_types!=null){
					for (int i=0;i<arr_list_theatre_types.size();i=i+2){
						theatre_type_temp   = (String)arr_list_theatre_types.get(i);
						if(theatre_type.equals(theatre_type_temp)){
							theatre_type_select = "selected";
						}else {
							theatre_type_select = "";
						}
			%>
					<option value="<%=theatre_type_temp%>" <%=theatre_type_select%>> 
						<%=arr_list_theatre_types.get(i+1)%>	
					</option>					
			<%
					}
				}
			%>
		</select>
	</td>
	<td class='label' width='25%'><fmt:message key="eOT.ScanPatient.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
	<select name="scan_vals" id="scan_vals" onChange="callBarcodeMenuFunctions();">
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
			for(int i=0;i<menu_list_arr.size();i+=3){
			%>
				<option value="<%=menu_list_arr.get(i)%>"> 
					<%=menu_list_arr.get(i+1)%>	
				</option>
			<%}%>
		</select>
	</td> 
</tr>
<tr>

<input type='hidden' name='by_time_seq' id='by_time_seq' value="T" >
</tr>
 </table>
<table  border='0' cellpadding='0' cellspacing=0   width='100%' id='more1Criteria' > 
<tr>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width='25%'>
	</td>
	<td width='25%' class="fields">
	<img id="img_src" src='../../eOT/images/ShowMore.gif' onclick='moreCriteria()'>
	<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onclick="searchSlate()">
	<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  onclick="resetPage();">
	<%
		//IN052054 end
		if(external_link.equals("Y"))
		{
	%>
     <span class='image' title='External Link'><img  id='PAT_DMS11' src='../../eCommon/images/ExternalDocument.PNG' onclick='external_doc("pat")'></span>
	<%
		}
	%>
	</td>	
	</tr>
</table>
	<input type='hidden' name='params' id='params' value='<%=params%>' >
	<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >	
	<input type='hidden' name='sql_ot_slate_select5' id='sql_ot_slate_select5' value="<%=sql_ot_slate_select5%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id_list" id="function_id_list" value="">		
	<input type="hidden" name="function_name_list" id="function_name_list" value="">		
	<input type="hidden" name="url_desc_list" id="url_desc_list" value="">
	<input type="hidden" name="cnt_temp" id="cnt_temp" value="">
	<input type="hidden" name="color_ind_old" id="color_ind_old" value="">
	<input type="hidden" name="operation_status" id="operation_status" value="">
	<input type="hidden" name="operation_flag" id="operation_flag" value="">
	<input type="hidden" name="oper_temp_flag" id="oper_temp_flag" value="">
	<input type="hidden" name="oper_temp_cnt" id="oper_temp_cnt" value="">
	<input type="hidden" name="oper_temp_cnt_1" id="oper_temp_cnt_1" value="">
	<input type="hidden" name="bill_flag" id="bill_flag" value="<%=bill_flag%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='calledFrom' id='calledFrom' id="calledFrom" value="<%=calledFrom%>"> <%-- IN052054 --%>
	<input type='hidden' name='user_role_temp' id='user_role_temp' value="<%=user_role_temp%>">
	<input type="hidden" name="more_Less_Criteria_Flag" id="more_Less_Criteria_Flag" value="<%=more_Less_Criteria_Flag%>">
	<!-- added by Sathish for Amazon Changes-->
	<%if(!imgUrl.equals("")){ %>
		 <img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<!-- end -->
</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute;width:20%;visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding="3"  cellspacing=0 border='0'  width='100%' height='100%' align='left'>
			<tr>
				<td width='100%' id='menu_table' valign="top"></td>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

