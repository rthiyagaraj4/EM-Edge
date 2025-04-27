<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/FMReturnToMRD.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
PreparedStatement volStatement	=	null;
ResultSet	resultSet			=	null;
ResultSet	volResultSet		=	null;

String facilityID				=	"";
//String patientID				=	"";
String fs_location1				=	"";
String operation				=	"";
//String file_type_appl_yn		=	"N";
String sqlString				=	"";
//String fileType				=	"";
//String fileNo					=	"";

try
{
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
      Properties p				= (Properties) session.getValue("jdbc");
	String addedById			= p.getProperty("login_user");
	 //below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
     String userSecurity =checkForNull(request.getParameter("userSecurity"));
    //end issue KAUH-SCF-0016 [IN032341] 
		
//	patientID			=	checkForNull(request.getParameter("patientID"));
	fs_location1			=	checkForNull(request.getParameter("fs_location1"));
	operation			=	checkForNull(request.getParameter("operation"));
	//file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	//fileNo				=	checkForNull(request.getParameter("fileNo"));
	//fileType			=	checkForNull(request.getParameter("fileType"));
	connection			=	ConnectionManager.getConnection(request);	
	
	
	if (operation.equals("LOCATION"))
	{
			
//sqlString="SELECT a.fs_locn_code,fm_get_desc.fm_storage_locn(a.facility_id,a.fs_locn_code, 'en', 2) short_desc FROM fm_storage_locn a WHERE a.eff_status = 'E' AND EXISTS (SELECT 'x' FROM fm_user_access_rights  WHERE facility_id = a.facility_id  and appl_user_id = '"+addedById+"' and (fs_locn_code = a.fs_locn_code or fs_locn_code = '*ALL')) AND locn_identity = '"+fs_location1+"' AND a.facility_id ='"+facilityID+"'  ORDER BY 2 " ;



	/*	sqlString = "SELECT"
				  +"  fs_Locn_Code"
				  +"  ,fm_get_desc.fm_storage_locn (facility_id, fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
				  +"FROM"
				  +"  FM_STORAGE_LOCN "
				  +"WHERE eff_Status = 'E' "
				  +"  AND Facility_Id = ? "
				  +"  AND Locn_Identity = ?"
				//  +"  AND LANGUAGE_ID=?"
				  +"ORDER BY"
				  +"  2"; */

			
//below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
          
		  if(userSecurity.equals("Y"))
            {
        sqlString="SELECT a.fs_locn_code,fm_get_desc.fm_storage_locn(a.facility_id,a.fs_locn_code, 'en', 2) short_desc FROM fm_storage_locn a WHERE a.eff_status = 'E' AND EXISTS (SELECT 'x' FROM fm_user_access_rights  WHERE facility_id = a.facility_id  and appl_user_id = '"+addedById+"' and (fs_locn_code = a.fs_locn_code or fs_locn_code = '*ALL')) AND locn_identity = '"+fs_location1+"' AND a.facility_id ='"+facilityID+"'  ORDER BY 2 " ;
           }
		else
		{
		sqlString="SELECT a.fs_locn_code,fm_get_desc.fm_storage_locn(a.facility_id,a.fs_locn_code, 'en', 2) short_desc FROM fm_storage_locn a WHERE a.eff_status = 'E'  AND locn_identity = '"+fs_location1+"' AND a.facility_id ='"+facilityID+"'  ORDER BY 2 " ;
		}
		
//end issue KAUH-SCF-0016 [IN032341] 	  
				  
		
		if (preStatement != null)  preStatement = null;
		if (resultSet != null)  resultSet = null;
		
		
		preStatement	=	connection.prepareStatement(sqlString);
	//	preStatement.setString(1, facilityID);
	//	preStatement.setString(2, fs_location1);
	//	preStatement.setString(3, localeName);

		resultSet = preStatement.executeQuery();
		if (resultSet != null)
		{
		%>
			<script>
				var selectBox   = parent.criteria_frame.document.FMReturnToMRDCriteriaForm.fs_req_location;
				var seletLen	=	Math.abs(selectBox.length);
				for (i=0; i<seletLen; i++)
					selectBox.remove(0);
				var selectOption	=  parent.criteria_frame.document.createElement("OPTION");		
				selectOption.value	=	"";
				selectOption.text	=	"--------"+getLabel("Common.defaultSelect.label","common")+"--------";
				selectBox.add(selectOption);
		<%
			while (resultSet.next())
			{
		%>
				selectOption		=  parent.criteria_frame.document.createElement("OPTION");		
				selectOption.value	=	"<%=checkForNull(resultSet.getString("fs_locn_code"))%>";
				selectOption.text	=	"<%=checkForNull(resultSet.getString("short_desc"))%>";
				selectBox.add(selectOption);
		<%
			}
		}
		%>
			if ("<%=fs_location1%>" == "C")
			{    
			    
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("Common.clinic.label","common");
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			}
			else if ("<%=fs_location1%>" == "N")
			{
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("Common.nursingUnit.label","common"); 	parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			}
			else if ("<%=fs_location1%>" == "T")
			{
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("Common.practitioner.label","common"); 	parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			}
            else if ("<%=fs_location1%>" == "Y")
			{
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("Common.DaycareUnit.label","common"); 	parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			}
			else if ("<%=fs_location1%>" == "E")
			{
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("Common.ProcedureUnit.label","common"); 	parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			}
            else if ("<%=fs_location1%>" == "D")
			{
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("Common.department.label","common"); 	parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			} 
			else 
			{  
				parent.criteria_frame.document.getElementById("returning").innerText = getLabel("eFM.Returning.label","FM");
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = "";
				parent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = "";
			}
			</script>
		<%
	}
%>
</head>
<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
</script>
<%
if(preStatement!=null) preStatement.close();
if(volStatement!=null) volStatement.close();
if(resultSet!=null)	resultSet.close();
if(volResultSet!=null)	volResultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}
%>
</html>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

%>

