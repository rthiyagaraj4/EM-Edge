<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 	<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 
 <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCA/js/CAMainMenuLookup.js' language='javascript'></script>
 <script src='../../eCA/js/SwitchLanguage.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<body  OnMouseDown='CodeArrest()' class='CA_COMMON' onKeyDown="lockKey()"> 
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	int counter = 0;
	StringBuffer strBuffCAMainChart = null;
	StringBuffer detl_sql = new StringBuffer();
	String option_id = "",header_option_id="",option_desc="";
	String executable_name = "",option_type="";
	String respid="",relationcode="",facilityid="";
	PreparedStatement pstmt = null,pstmtMenu=null;
	Connection con = null;
	ResultSet rs = null,rsMenu=null;
	String queryString = request.getQueryString()== null?"":request.getQueryString() ;
	String patient_id = request.getParameter("patient_id");
	String episode_id = request.getParameter("episode_id");
	
	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
   // String pract_type =(String) session.getValue("practitioner_type");
	respid = (String) session.getValue("responsibility_id");
	if(respid == null) respid="";
	//relationcode = (String)session.getValue("relationship_id");
	relationcode = request.getParameter("relationship_id");
	if(relationcode == null) relationcode = "";
	String icon_file_name = "";
	//String patientclass = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	//String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
%>

<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
<script>
	var objLookupMenu;
	objLookupMenu = new dTree('objLookupMenu');
	objLookupMenu.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+getLabel("Common.menu.label","Common")+'</font>');
	objLookupMenu.config.useStatusText=true;

<%

	//String strSql="SELECT CA_GET_MENU_ID(?,?,?,?) MENU_ID FROM DUAL ";
	if(detl_sql.length() > 0) detl_sql.delete(0,detl_sql.length());

	detl_sql.append(" SELECT  DISTINCT  B.OPTION_ID||B.OPTION_OCCURANCE OPTION_ID  , NVL(NVL(C.USER_DEF_SHORT_DESC,C.SHORT_DESC),(SELECT SHORT_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) OPTION_DESC  , NVL(NVL(C.USER_DEF_LONG_DESC,C.LONG_DESC) ,(SELECT LONG_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) FUNCTION_NAME  ,'H' MENU_POSITION  , NVL(C.OPTION_TYPE,'M') OPTION_TYPE  , C.EXECUTABLE_NAME  , DECODE(?, a.HEADER_OPTION_ID,'0', a.HEADER_OPTION_ID||B.HEADER_OPTION_OCCURANCE) HEADER_OPTION_ID  , a.ORDER_SEQ_NO  , nvl(C.OPEN_IN_MODAL_WINDOW_YN,'N') OPEN_IN_MODAL_WINDOW_YN   , C.HIST_OR_RECORD ,C.ICON_FILE_NAME    FROM  ( SELECT LEVEL LVL,OPTION_ID,ORDER_SEQ_NO,HEADER_OPTION_ID ,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE   FROM CA_MENU_DETAIL   WHERE MENU_ID=? AND DESKTOP_CHART = 'P'  START WITH HEADER_OPTION_ID=? and HEADER_OPTION_OCCURANCE=1  AND DESKTOP_CHART = 'P' CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID AND  OPTION_OCCURANCE=HEADER_OPTION_OCCURANCE) A  ,(SELECT  DISTINCT OPTION_ID,HEADER_OPTION_ID,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE FROM CA_MENU_DETAIL  WHERE MENU_ID=?  AND DESKTOP_CHART = 'P' START WITH  MENU_ID=? AND DESKTOP_CHART = 'P' AND OPTION_ID IN (SELECT B.OPTION_ID FROM CA_APPL_TASK a, ca_option b WHERE a.option_id=b.option_id and 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?)  and (a.BASE_MODULE_ID='CA' or  exists( select 1 from sm_module where install_yn='Y' and MODULE_ID =a.BASE_MODULE_ID )) and B.HIST_OR_RECORD='H'  )  AND DESKTOP_CHART = 'P'   CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID and HEADER_OPTION_OCCURANCE=OPTION_OCCURANCE ) B   , CA_OPTION_LANG_VW C   WHERE A.OPTION_ID=B.OPTION_ID AND A.HEADER_OPTION_ID=B.HEADER_OPTION_ID AND A.HEADER_OPTION_OCCURANCE=B.HEADER_OPTION_OCCURANCE AND A.OPTION_OCCURANCE=B.OPTION_OCCURANCE AND C.OPTION_ID(+)=B.OPTION_ID   AND C.LANGUAGE_ID = ? ORDER BY A.ORDER_SEQ_NO "); 

     
	try
	{
		con = ConnectionManager.getConnection(request);
	
	
	   /*if (!episode_id.equals(""))
		{
			try
			{
				String strSqln1="SELECT SPECIALTY_CODE, PATIENT_CLASS FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=? ";
				pstmtMenu = con.prepareStatement(strSqln1);
				pstmtMenu.setString(1,facilityid);
				pstmtMenu.setString(2,episode_id);
				rsMenu = pstmtMenu.executeQuery();
			
				if(rs.next())
				{
					patientclass = rsMenu.getString("PATIENT_CLASS");
					if(patientclass == null) patientclass = "";
					speciality_code = rsMenu.getString("SPECIALTY_CODE");
					if(speciality_code == null) speciality_code = "";
				}

				if(rsMenu!=null) rsMenu.close();
				if(pstmtMenu!=null) pstmtMenu.close();	
			}
			catch(Exception ew)
			{ 
				ew.printStackTrace() ;
			}
	    }
		pstmtMenu = con.prepareStatement(strSql);
		pstmtMenu.setString(1,speciality_code);
		pstmtMenu.setString(2,patientclass);
		pstmtMenu.setString(3,practitioner_id);
		pstmtMenu.setString(4,pract_type);



		

		rsMenu = pstmtMenu.executeQuery();

		while(rsMenu.next()){
			menu_id = rsMenu.getString("MENU_ID");
		}

		if(menu_id == null) menu_id="MED_DFLT";*/

		pstmt = con.prepareStatement(detl_sql.toString());
		pstmt.setString(1,menu_id);
		pstmt.setString(2,menu_id);
		pstmt.setString(3,menu_id);
		pstmt.setString(4,menu_id);
		pstmt.setString(5,menu_id);
		pstmt.setString(6,respid);
		pstmt.setString(7,relationcode);
		pstmt.setString(8,facilityid);
		pstmt.setString(9,episode_id);
		pstmt.setString(10,patient_id);
		pstmt.setString(11,locale);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			option_id = rs.getString("OPTION_ID");
			header_option_id = rs.getString("HEADER_OPTION_ID");
			option_desc = rs.getString("OPTION_DESC");
			executable_name = rs.getString("EXECUTABLE_NAME");
			if(executable_name == null) executable_name = "";
			icon_file_name = rs.getString("ICON_FILE_NAME") == null ? "" : rs.getString("ICON_FILE_NAME");

			option_type = rs.getString("OPTION_TYPE");	
			counter++;
			if(executable_name != ""){
				strBuffCAMainChart = new StringBuffer();
				strBuffCAMainChart.append("../../eCA/jsp/CAMainChart.jsp?");
				if(executable_name.indexOf("?") != -1){
					strBuffCAMainChart.append("lookupFileName=");	strBuffCAMainChart.append(executable_name.substring(0,executable_name.indexOf("?")));
					strBuffCAMainChart.append("&");	strBuffCAMainChart.append(executable_name.substring(executable_name.indexOf("?")+1,executable_name.length()));
					strBuffCAMainChart.append("&option_id=");
					strBuffCAMainChart.append(option_id);
					strBuffCAMainChart.append("&");
					strBuffCAMainChart.append(queryString);
					strBuffCAMainChart.append("&");
					strBuffCAMainChart.append("Patient_ID=");
					strBuffCAMainChart.append(patient_id);
					//executable_name+="&option_id="+option_id+"&"+queryString;
				}
				else
				{
					strBuffCAMainChart.append("lookupFileName=");	
					strBuffCAMainChart.append(executable_name);	
					strBuffCAMainChart.append("&option_id=");
					strBuffCAMainChart.append(option_id);
					strBuffCAMainChart.append("&");
					strBuffCAMainChart.append(queryString);
					//executable_name+="?"+"option_id="+option_id+"&"+queryString;		
				}
			}
			
			
		%>

			<%if(option_type.equals("M")){
				%>				
				objLookupMenu.add('<%=option_id%>','<%=header_option_id%>','<font style="font-weight:bold"><%=option_desc%></font>','','<%=option_desc%>','','');

			<%}
			else
			{
				//nodePoistions +="$"+counter;
				//out.println("unique= "+(patient_id+episode_id+episode_type+counter));
				
			%>				
				objLookupMenu.add('<%=option_id%>','<%=header_option_id%>','<%=option_desc%>','<%=strBuffCAMainChart.toString()%>','<%=option_desc%>','<%=(patient_id+counter)%>','<%=icon_file_name%>');
			<%}%>

		<%
		}
		if(rs!= null) rs.close();
		if(rsMenu!= null) rsMenu.close();
		if(pstmt!=null) pstmt.close();
		if(pstmtMenu!=null) pstmtMenu.close();
	}
	
	catch(Exception e)
	{
		e.printStackTrace() ;
		//out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
	}

	finally
	{
		if(con!= null) ConnectionManager.returnConnection(con,request);
        	
	}
	%>
		document.write(objLookupMenu);
		objLookupMenu.openAll();
		<%if(counter == 0){%>
			if(parent.CommonToolbar.HideAndShowLookup != null){
				parent.CommonToolbar.HideAndShowLookup.style.visibility = "hidden";
			}
		<%}%>
	</script>
</FORM>
</body>
</html>

