<!DOCTYPE html>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>
<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%
	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));	

	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  Inside EM_Patient_Photo.jsp  - - - ");
	
	String l_facility_id = (String) session.getValue("facility_id");
	
	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  l_facility_id  - - - "+l_facility_id);

	String appPath = request.getRequestURL().toString();
	String contextPath = request.getContextPath();

	appPath = appPath.substring(0, appPath.indexOf(contextPath)	+ contextPath.length());

	String patientid = "", moduleid = "", patientname = "", facility_id = "", user_id = "", ws_no = "", locale = "";

	String patientIDLbl = "", patientNameLbl = "";

	String extPersonName = "", extPersonLocalLangName = "";

	patientid = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");

	moduleid = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");

	patientname = request.getParameter("patient_name") == null ? "" : request.getParameter("patient_name");

	facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

	user_id = request.getParameter("user_id") == null ? "" : request.getParameter("user_id");

	ws_no = request.getParameter("ws_no") == null ? "" : request.getParameter("ws_no");

	locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");

	if (moduleid.equals("MP"))
	{
		patientIDLbl = "Patient ID: ";
		patientNameLbl = "Patient Name: ";
	}
	
	if (moduleid.equals("BD"))
	{
		patientIDLbl = "Donor ID: ";
		patientNameLbl = "Donor Name: ";
	}
	//Added by bhuvana on 23/05/2019.
	if (moduleid.equals("PP"))
	{
		patientIDLbl = "Patient ID: ";
		patientNameLbl = "Patient Name: ";
	}

	if (moduleid.equals("MP"))
	{
		moduleid = "PP";
	}
	
	System.out.println(" - - -  facility_id  - - - "+facility_id);

	if (l_facility_id==null)
		l_facility_id = facility_id;
	

	if(isDebugYN.equals("Y"))
		System.out.println(" ::: appPath ::: " + appPath + " ::: patientid ::: " + patientid + " ::: patientname ::: " + patientname + "::: moduleid ::: " + moduleid+ "::: l_facility_id ::: " + l_facility_id+ "::: locale ::: " + locale );
	
	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	String l_event_query = "", l_donor_query = "";
	
	int l_photo_width = 320, l_photo_height = 240;
	double l_resize_factor = 0;

	HashMap hash_Map1 =	new HashMap();
	int count = 0;

	try
	{ 
		dbConn = ConnectionManager.getConnection(request);
		
		l_event_query = "Select PAT_PHOTO_WIDTH, PAT_PHOTO_HEIGHT, RESIZE_FACTOR from SM_PATIENT_DOC_PARAM  "
				+"	where FACILITY_ID = ?";

		if(isDebugYN.equals("Y"))
			System.out.println("l_event_query...."+l_event_query);
		
		pstmt = dbConn.prepareStatement(l_event_query);
		pstmt.setString(1, l_facility_id);
			
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			count++;
			l_photo_width = rs.getInt("PAT_PHOTO_WIDTH"); 
			l_photo_height =  rs.getInt("PAT_PHOTO_HEIGHT");	
			l_resize_factor = rs.getDouble("RESIZE_FACTOR");
		}
		
		if(isDebugYN.equals("Y"))
			System.out.println("l_photo_width...."+l_photo_width+" l_photo_height...."+l_photo_height);	
		
		if (moduleid.equals("PP"))
		{
		
			Properties p = (java.util.Properties) session.getValue("jdbc");

			//if(isDebugYN.equals("Y"))
				//System.out.println(" ::: p ::: " + p);

			locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");

			if(isDebugYN.equals("Y"))
				System.out.println(" ::: locale ::: " + locale+" ::: locale.length ::: " + locale.length());
		
		
			//Code Added by bhuvana on 11/06/2019.
			if (!(locale.length()>0))
				locale = "en";
			//Code Ended by bhuvana on 11/06/2019.

			hash_Map1 = eMP.ChangePatientDetails.getPatientData(patientid, dbConn, p);
		}

		if (moduleid.equals("BD"))
		{
			l_donor_query = "Select PERSON_NAME, PERSON_NAME_LOC_LANG from MP_EXT_PERSON  "
				+"	where PERSON_ID = ?";

			if(isDebugYN.equals("Y"))
				System.out.println("l_donor_query...."+l_donor_query);
			
			pstmt = dbConn.prepareStatement(l_donor_query);
			pstmt.setString(1, patientid);
				
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				extPersonName = rs.getString("PERSON_NAME"); 
				extPersonLocalLangName =  rs.getString("PERSON_NAME_LOC_LANG");	
			}

		}
		
		/*if (locale.equals("en"))
			patientname = (String)hash_Map1.get("patient_name");
		else{
			patientname =checkForNull((String)hash_Map1.get("patient_name_loc_lang"),(String)hash_Map1.get("patient_name"));
		}*/

		patientname = patientname;	

		if (moduleid.equals("PP"))
		{
			if (locale.equals("en")){
				patientname = (String)hash_Map1.get("patient_name");
			}
			else
			{
				patientname = checkForNull((String)hash_Map1.get("patient_name_loc_lang"),(String)hash_Map1.get("patient_name"));
			}
		}
		else
		{
			if (locale.equals("en")){
				patientname = extPersonName;
			}
			else
			{
				patientname = checkForNull(extPersonLocalLangName,extPersonName);
			}
		}

		/*

		if (locale.equals("en")){
			
			if (moduleid.equals("PP"))
			{
			patientname = (String)hash_Map1.get("patient_name");
			}
		} else{
			patientname = checkForNull((String)hash_Map1.get("patient_name_loc_lang"),(String)hash_Map1.get("patient_name"));
		}

		*/


		if(isDebugYN.equals("Y"))
			System.out.println(" ::: appPath ::: " + appPath + " ::: patientid ::: " + patientid + " ::: patientname ::: " + patientname + "::: moduleid ::: " + moduleid );

		
	}
	catch(Exception exp) {
		System.out.println(" Error in fetching Patient Photo Width & Height ::: "+exp.getMessage());
		exp.printStackTrace();
		l_photo_width = 320;
		l_photo_height = 240;
		l_resize_factor = 0;
	}	
	finally
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();	
			}
		}
		catch(Exception e) {
			System.out.println(" Error in closing DB Resources ::: "+e.getMessage());	
		}
	  	ConnectionManager.returnConnection(dbConn);	  
	}
	

	//session.getServletContext().getRealPath("/");
%>
<html>
<head>
<title>Capture Patient Photo</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
</head>
<body onUnLoad='window.returnValue="close"'>
	<br>
		<table align="center" border="4" cellpadding="1" cellspacing="1" style="width: 700px;">
			<tr>
				<td width='50%' class="label"> <%=patientIDLbl%> <%=patientid%> </td>
				<td width='50%' class="label"> <%=patientNameLbl%>  <input type='text' name='long_desc' id='long_desc' value="<%=patientname%>" size="45" readonly > </td>				
			</tr>
			<tr>
				<td colspan='2'>
					<applet code="PatientPhotoApplet.class"
						codebase="../CamImage/" archive="PatientPhotoApplet.jar" width="700"
						height="325">
						<PARAM name="servletPath" value="<%=appPath%>" />
						<PARAM name="patient_id" value="<%=patientid%>" />
						<PARAM name="module_id" value="<%=moduleid%>" />
						<PARAM name="patient_name" value="<%=java.net.URLEncoder.encode(patientname,"UTF-8") %>" /> 
						<PARAM name="image_width" value="<%=l_photo_width%>" />
						<PARAM name="image_height" value="<%=l_photo_height%>" />
						<PARAM name="resize_factor" value="<%=l_resize_factor%>" />
						<param name="separate_jvm" value="true" />
						<PARAM name="facility_id" value="<%=l_facility_id%>" />
						<PARAM name="user_id" value="<%=user_id%>" />
						<PARAM name="ws_no" value="<%=ws_no%>" />
						<PARAM name="locale" value="<%=locale%>" />
						Sorry, Your browser does not support Java applet!
					</applet>
				</td>
			</tr>
		</table>		
</body>
</html>
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

