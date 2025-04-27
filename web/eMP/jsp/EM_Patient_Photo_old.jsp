<!DOCTYPE html>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>
<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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

	String patientid = "", moduleid = "", patientname = "";

	patientid = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");

	moduleid = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");

	patientname = request.getParameter("patient_name") == null ? "" : request.getParameter("patient_name");
	
	if(isDebugYN.equals("Y"))
		System.out.println(" ::: appPath ::: " + appPath + " ::: patientid ::: " + patientid + " ::: patientname ::: " + patientname + "::: moduleid ::: " + moduleid );
	
	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	String l_event_query = "";
	
	int l_photo_width = 320, l_photo_height = 240;
	double l_resize_factor = 0;

	try
	{ 
		dbConn = ConnectionManager.getConnection(request);
		
		l_event_query = "Select PAT_PHOTO_WIDTH, PAT_PHOTO_HEIGHT, RESIZE_FACTOR from SM_PATIENT_DOC_PARAM  "
				+"	where FACILITY_ID = ? ";

		if(isDebugYN.equals("Y"))
			System.out.println("l_event_query...."+l_event_query);
		
		pstmt = dbConn.prepareStatement(l_event_query);
		pstmt.setString(1, l_facility_id);
			
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			l_photo_width = rs.getInt("PAT_PHOTO_WIDTH"); 
			l_photo_height =  rs.getInt("PAT_PHOTO_HEIGHT");	
			l_resize_factor = rs.getDouble("RESIZE_FACTOR");
		}
		
		if(isDebugYN.equals("Y"))
			System.out.println("l_photo_width...."+l_photo_width+" l_photo_height...."+l_photo_height);		
		
	}
	catch(Exception exp) {
		System.out.println(" Error in fetching Patient Photo Width & Height ::: "+exp.getMessage());	
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
</head>
<body onUnLoad='window.returnValue="close"'>
	<br>
		<table align="center" border="4" cellpadding="1" cellspacing="1" style="width: 700px;">
			<tr>
				<td>
					<applet code="PatientPhotoApplet.class"
						codebase="../CamImage/" archive="PatientPhotoImage.jar" width="700"
						height="325">
						<PARAM name="servletPath" value="<%=appPath%>" />
						<PARAM name="patient_id" value="<%=patientid%>" />
						<PARAM name="module_id" value="<%=moduleid%>" />
						<PARAM name="patient_name" value="<%=patientname%>" />
						<PARAM name="image_width" value="<%=l_photo_width%>" />
						<PARAM name="image_height" value="<%=l_photo_height%>" />
						<PARAM name="resize_factor" value="<%=l_resize_factor%>" />
						<param name="separate_jvm" value="true" />
						Sorry, Your browser does not support Java applet!
					</applet>
				</td>
			</tr>
		</table>		
</body>
</html>
