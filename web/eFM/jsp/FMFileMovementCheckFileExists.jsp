<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form name="checkvals" id="checkvals">
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt = null;
	ResultSet rs			= null;



	try
	{
		String sql			= "";
		String pat_id		= "";
		String file_no		= "";
		String fs_locn		= "";		
		//String currStatDesc = "";	
		//String currIdDesc	= "";	
		//String sysdate		= "";	
		String volumeno		= "";	
		String VolumeSQL	= "";	
		String ProceedValue	= "Yes";	

		int index = 0;
		
		String facility_id = (String) session.getValue("facility_id");

		String FileNo		= request.getParameter("FileNo");
		String PPatientID	= request.getParameter("patient_id");
	//	String Facility		= request.getParameter("Facility");
		String func			= request.getParameter("func");
		String Rename    = request.getParameter("Rename");
	  String logged_fcy = request.getParameter("logged_fcy");
		String req_facility = request.getParameter("req_facility");
		String file_type_code="";
		
		if(logged_fcy == null || logged_fcy.equals("null")) logged_fcy = "";
		if(req_facility== null || req_facility.equals("null")) req_facility = "";
		if(Rename == null || Rename.equals("null")) Rename = "";
      if(logged_fcy.equals("E"))
		{
         facility_id=req_facility;
		}
		
		
		if(func == null || func.equals("null")) func = "N";
		if(PPatientID == null || PPatientID.equals("null")) PPatientID = "";

		stmt = con.createStatement();

		//sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || A.CURR_FACILITY_NAME ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN_VW A where FILE_NO='"+FileNo+"' and  A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null ";

		//decode not handled bcoz it is not used.

		sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  CURR_FILE_STATUS FILE_STATUS_DESC,file_type_code, FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, A.CURR_FS_LOCN_CODE,'"+localeName+"','2') CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  A.CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || SM_GET_DESC.SM_FACILITY_PARAM(a.curr_FACILITY_ID,'"+localeName+"','1') ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN A where A.FILE_NO='"+FileNo+"' and  A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null ";
			
		rs = stmt.executeQuery(sql);
		if(rs != null)
		{
			while (rs.next())
			{
				pat_id			= (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
				file_no			= (rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
				fs_locn			= (rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
				file_type_code	= (rs.getString("file_type_code")==null)?"":rs.getString("file_type_code");
				
				//currStatDesc	= (rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC");  
				//currIdDesc		= (rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
				//sysdate  =(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");
			
				index =  index  + 1;
			}

			if(fs_locn == null || fs_locn.equals("null")) fs_locn = "";
		} if(rs!=null) rs.close();
		
		if(file_no.equals(""))
		{
			if (func.equals("tracer"))
			{

				%>
				<script>
					var errors = getMessage("PATIENT_FILE_NOT_EXIST","FM");
					var Rename="<%=Rename%>";
					var file_type_code="<%=file_type_code%>";
					if(Rename=="RE")
				{
                    parent.frames[3].document.forms[0].fileno.focus();
					parent.frames[2].document.forms[0].validFile.value ='false';
				}else{

					parent.frames[2].document.forms[0].fileno.focus();
					parent.frames[2].document.forms[0].validFile.value ='false';
				  if(parent.frames[1].document.forms[0].file_type_code)
					parent.frames[1].document.forms[0].file_type_code.value=file_type_code;
				}
				//parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;		
				</script>
				<%
			}
			else
			{
				%>
				<script>
					var errors = getMessage("PATIENT_FILE_NOT_EXIST","FM");
					var Rename="<%=Rename%>";
					var file_type_code="<%=file_type_code%>";
					if(Rename=="RE")
				{
				   parent.frames[3].document.forms[0].fileno.focus();
					parent.frames[1].document.forms[0].validFile.value ='false';
				}else{
					parent.frames[1].document.forms[0].fileno.focus();
					parent.frames[1].document.forms[0].validFile.value ='false';
				    if(parent.frames[1].document.forms[0].file_type_code)
					parent.frames[1].document.forms[0].file_type_code.value=file_type_code;
				}
				//parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;	
				</script>
				<%
			}
		}
		else
		{
			if(func.equals("tracer"))
			{
				%>
				<script>
				 var file_type_code="<%=file_type_code%>";
				
				if('<%=fs_locn%>' == "")
					{
					var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');
				   var Rename="<%=Rename%>";
					if(Rename=="RE")
				{
				        parent.frames[3].document.forms[0].fileno.focus();
						parent.frames[2].document.forms[0].validFile.value ='false';
				}else{
						parent.frames[2].document.forms[0].fileno.focus();
						parent.frames[2].document.forms[0].validFile.value ='false';
				   if(parent.frames[1].document.forms[0].file_type_code)
					parent.frames[1].document.forms[0].file_type_code.value=file_type_code;
				}  
					}
					else
					{
				 var Rename="<%=Rename%>";
				if(Rename=="RE")
				{
				parent.frames[3].document.forms[0].patientid.value = '<%=pat_id%>';			parent.frames[2].document.forms[0].validFile.value ='true';	
				}else{
				parent.frames[2].document.forms[0].patientid.value = '<%=pat_id%>';			parent.frames[2].document.forms[0].validFile.value ='true';	
			  if(parent.frames[1].document.forms[0].file_type_code)
					parent.frames[1].document.forms[0].file_type_code.value=file_type_code;
				}
								}
				</script>
				<%
			}
			else
			{
				%>	
				<script>
				var Rename="<%=Rename%>";
				 var file_type_code="<%=file_type_code%>";
				if('<%=fs_locn%>' == "")
					{
						var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');
						 var Rename="<%=Rename%>";
				if(Rename=="RE")
				{  
				       parent.frames[2].document.forms[0].fileno.focus();
						parent.frames[1].document.forms[0].validFile.value ='false';
				}else{	
						parent.frames[1].document.forms[0].fileno.focus();
						parent.frames[1].document.forms[0].validFile.value ='false';
				  if(parent.frames[1].document.forms[0].file_type_code)
					parent.frames[1].document.forms[0].file_type_code.value=file_type_code;
				}
					}
					else
					{
					if(Rename=="RE")
				     {
					 parent.frames[3].document.forms[0].patientid.value = '<%=pat_id%>';	parent.frames[1].document.forms[0].validFile.value ='true';	
					 }else{
						parent.frames[1].document.forms[0].patientid.value = '<%=pat_id%>';				
						parent.frames[1].document.forms[0].validFile.value ='true';	
					    if(parent.frames[1].document.forms[0].file_type_code)
					parent.frames[1].document.forms[0].file_type_code.value=file_type_code;
					 }
					}
				</script>
				<%
			}
		}
		VolumeSQL = "SELECT DISTINCT volume_no FROM fm_curr_locn WHERE facility_id ='"+facility_id+"' and patient_id='"+PPatientID+"' and file_no='"+FileNo+"' ORDER BY volume_no desc ";
		rs = stmt.executeQuery(VolumeSQL);

		if((!file_no.equals("")) && (ProceedValue.equals("Yes")) && (!func.equals("tracer")))
		{
		%>
			<script>
				var Rename="<%=Rename%>";
		      if(Rename=="RE")
				     {
					  var sel      = parent.frames[3].document.forms[0].volumeno;
					 }else{
		        var sel      = parent.frames[1].document.forms[0].volumeno;
					 }
				var seletLen = 0;
				if(sel != undefined) 
				{
					seletLen = Math.abs(sel.length);
				}
				
				for(i=0; i<seletLen; i++) sel.remove(0);
			
				if(Rename=="RE")
				     {
					 var Opt    = parent.frames[3].document.createElement("OPTION");
					 }else{
				var Opt    = parent.frames[1].document.createElement("OPTION");
					 }
				Opt.value  = ""; 
				Opt.text   = "---"+getLabel('Common.defaultSelect.label','common')+"---";
				var temp = parent.frames[3].document.forms[0].volumeno;
				if(Rename=="RE")
				{ 
					if(temp != undefined) 
					{
						parent.frames[3].document.forms[0].volumeno.add(Opt);
					}
				}else{
					if(temp != undefined)
					{
						parent.frames[1].document.forms[0].volumeno.add(Opt);
					}
				}
			</script>
			<%
			while(rs != null && rs.next())
			{
				volumeno = rs.getString("volume_no");
				if(volumeno == null || volumeno.equals("null")) volumeno = "";
				%>
				<script>
					var Rename="<%=Rename%>";
				if(Rename=="RE"){
			var Opt    = parent.frames[3].document.createElement("OPTION");
				}else{
				var Opt    = parent.frames[1].document.createElement("OPTION");
				}
					Opt.value  = "<%=volumeno%>"; 
					Opt.text   = "<%=volumeno%>";
					if(Rename=="RE"){
					parent.frames[3].document.forms[0].volumeno.add(Opt);
					}else{
					parent.frames[1].document.forms[0].volumeno.add(Opt);
					}
				</script>
				<%
			}
		}
		else
		{
%>
		<script>
			
          var Rename="<%=Rename%>";
           
		   if(Rename=="RE"){
		    var sel      = parent.frames[3].document.forms[0].volumeno;
		   }else{
		   var sel      = parent.frames[2].document.forms[0].volumeno;
		   }
		   	var seletLen = 0;
			if(sel != undefined) 
			{
					seletLen = Math.abs(sel.length);
			}
			for(i=0; i<seletLen; i++)
				sel.remove(0);
		</script>
		<script>
				var Rename="<%=Rename%>";
           
		   if(Rename=="RE"){
		   var Opt    = parent.frames[3].document.createElement("OPTION");
		   }else{
		var Opt    = parent.frames[2].document.createElement("OPTION");
		   }
				Opt.value  = ""; 
				Opt.text   = "---"+getLabel('Common.defaultSelect.label','common')+"---";
				if(Rename=="RE" )
				{
					var temp1 = parent.frames[3].document.forms[0].volumeno;
					if(temp1 != undefined) 
					{
						parent.frames[3].document.forms[0].volumeno.add(Opt);
					}
				}
				else
				{
					var temp2 = parent.frames[2].document.forms[0].volumeno;
					if(temp2 != undefined) 
					{
						parent.frames[2].document.forms[0].volumeno.add(Opt);
					}
				}
		</script>
		<%
		while(rs != null && rs.next())
		{
			volumeno = rs.getString("volume_no");
			if(volumeno == null || volumeno.equals("null")) volumeno = "";
			%>
				<script>
					var Rename="<%=Rename%>";
           
		   if(Rename=="RE"){
		   var Opt    = parent.frames[3].document.createElement("OPTION");
		   }else{
			   var Opt    = parent.frames[2].document.createElement("OPTION");
		   }
					Opt.value  = "<%=volumeno%>"; 
					Opt.text   = "<%=volumeno%>";
					 if(Rename=="RE")
					 {
						 var v1 = parent.frames[3].document.forms[0].volumeno;
						 if(v1 != undefined)
						{
							 parent.frames[3].document.forms[0].volumeno.add(Opt);
						}
					 }
					 else
					 {
						 var v2 = parent.frames[2].document.forms[0].volumeno;
						 if(v2 != undefined)
						 {
							 parent.frames[2].document.forms[0].volumeno.add(Opt);
						 }
					 }
				</script>
			<%
		}
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("In Exception :"+e.toString()); 
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
	</form>
</body>
</html>

