<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>





<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt = null;
	ResultSet rs			= null;
	ResultSet rs1			= null;
	try
	{
		String sql				= "";
		String found			= "N";
		String file_no			= "";
		String file_type_desc	= "";
		String file_type_code	= "";
		String sqlString		= "";
		String VOLUME_NO		= "";
		String  file_type_desc1="";
		String Rename="";
		int record_count = 0;

		//String pat_id			= "";
		//String fs_locn		= "";
		//String currLocn		= "";	
		//String currStat		= "";
		//String currIden		= "";	
		//String sysdate		= "";	

		String facility_id		= (String) session.getValue("facility_id");	
		String logged_fcy = request.getParameter("logged_fcy");
		String req_facility = request.getParameter("req_facility");
		String queryCriteria	= request.getParameter("Patient");
		String file_type_yn		= request.getParameter("file_type_yn");	
		String func				= request.getParameter("func");
         Rename    = request.getParameter("Rename");
		if(func == null || func.equals("null")) func = "N";
		if(logged_fcy == null || logged_fcy.equals("null")) logged_fcy = "";
		if(req_facility== null || req_facility.equals("null")) req_facility = "";
		if(Rename == null || Rename.equals("null")) Rename = "";
		if(logged_fcy.equals("E"))
		{
         facility_id=req_facility;
		}
		stmt = con.createStatement();
		sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id ='"+facility_id+"' AND patient_id = '"+queryCriteria+"' and doc_folder_id is null ";
		rs = stmt.executeQuery(sqlString);
		if ((rs != null) && (rs.next()))
				record_count = rs.getInt("record_count");
		if (rs!=null) rs.close();
		
		//sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE,I.SHORT_DESC FILE_TYPE_DESC, A.CURR_FS_LOCN_CODE, A.CURR_FILE_STATUS, get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE, NVL(A.MR_LOCN_YN,'N') CURR_MR_LOCN_YN, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || A.CURR_FACILITY_NAME ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN_VW A ,MR_FILE_TYPE I where PATIENT_ID='"+queryCriteria+"' and  A.FACILITY_ID='"+facility_id+"' AND A.FACILITY_ID = I.FACILITY_ID (+) AND A.FILE_TYPE_CODE = I.FILE_TYPE_CODE (+) AND A.CURR_FS_LOCN_CODE is not null";		
	
		//sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE, MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') FILE_TYPE_DESC, A.CURR_FS_LOCN_CODE, A.CURR_FILE_STATUS, get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE, NVL(A.MR_LOCN_YN,'N') CURR_MR_LOCN_YN, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || SM_GET_DESC.SM_FACILITY_PARAM(a.curr_FACILITY_ID,'"+localeName+"','1') ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN A where a.PATIENT_ID='"+queryCriteria+"' and  A.FACILITY_ID='"+facility_id+"' AND A.CURR_FS_LOCN_CODE is not null";
		
		sql = "Select distinct FILE_NO, PATIENT_ID, FILE_TYPE_CODE, MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') FILE_TYPE_DESC from FM_CURR_LOCN  where PATIENT_ID='"+queryCriteria+"' and  FACILITY_ID='"+facility_id+"' ";	

		if(file_type_yn.equals("Y"))
				sql=sql+"AND FILE_TYPE_CODE is not null";
		else if(file_type_yn.equals("N"))
			   sql=sql+"AND FILE_NO is not null";

	            

		
	
		
		rs = stmt.executeQuery(sql);		
		

	  	String str  = "";
		String str1 = "";
		String vol1 = "";
		
		//if(rs != null)
		//{
			if(record_count > 1){
				if(file_type_yn.equals("N"))
				{
			str = str +  "<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</option>";
				}
				else
				{
			str1 = str1 + "<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</option>";	
				}
		}
		
			while (rs.next())
			{
				found = "Y"; 
				
				file_type_code	= (rs.getString("FILE_TYPE_CODE")==null)?"":rs.getString("FILE_TYPE_CODE");
				

				file_no			= (rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
				
				file_type_desc	= (rs.getString("FILE_TYPE_DESC")==null)?"":rs.getString("FILE_TYPE_DESC");
				
				if(file_type_yn.equals("N"))
				{
				
				str = str + "<option value='"+file_no+"'>"+file_no+"</option>";
				}
				else
				{
				if(!file_type_desc1.equals(file_type_desc))
					{
				str1 =str1 + "<option value='"+file_no+"'>"+file_type_desc+"</option>";
					}
				file_type_desc1=file_type_desc;
				}

			/*pat_id=(rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");*/
			/*sysdate=(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");*/
			/*fs_locn=(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");*/
			/*currLocn=(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");*/	/*currStat=(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");*/
	/*currIden=(rs.getString("CURR_FS_LOCN_IDENTITY")==null)?"":rs.getString("CURR_FS_LOCN_IDENTITY");*/

			}
		//}
		if(record_count== 1)
		{
		sqlString = "SELECT distinct volume_no FROM fm_curr_locn WHERE facility_id ='"+facility_id+"' AND patient_id = '"+queryCriteria+"' and doc_folder_id is null ORDER BY volume_no desc ";
		rs1 = stmt.executeQuery(sqlString);
		if(rs1 != null)
		{			
			vol1 =vol1 +  "<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";		
		
			while (rs1.next())
			{
				VOLUME_NO			= (rs1.getString("volume_no")==null)?"":rs1.getString("volume_no");

				vol1 =vol1 + "<option value='"+VOLUME_NO+"'>"+VOLUME_NO+"</option>";
						
			}
		}
		}
if(record_count> 1)
		{
		vol1 = "<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";
		}
		
		if(found.equals("N"))
		{
			if(func.equals("tracer"))
			{
	%>			<script>
					
	              var errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');	
					var Rename="<%=Rename%>";
					if(Rename=="RE")
				{
			    	parent.frames[3].document.forms[0].patientid.focus();
					parent.frames[2].document.forms[0].validFile.value ='false';
					parent.frames[3].document.getElementById('fileid').innerHTML="<input type='text' name='fileno' id='fileno' tabIndex='2' size='20' maxlength='20' value='' onBlur='ChangeUpperCase(this);CheckFileExists(this.value);' >";
				}else{
					parent.frames[2].document.forms[0].patientid.focus();
					parent.frames[2].document.forms[0].validFile.value ='false';
					parent.frames[2].document.getElementById('fileid').innerHTML="<input type='text' name='fileno' id='fileno' tabIndex='2' size='20' maxlength='20' value='' onBlur='ChangeUpperCase(this);CheckFileExists(this.value);' >";
				}
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				</script>
			<%
			}
			else
			{
				%>
				<script>
					var errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');	
					var Rename="<%=Rename%>";
					if(Rename=="RE")
				{
				    parent.frames[3].document.forms[0].patientid.focus();
					parent.frames[2].document.forms[0].validFile.value ='false';					
					parent.frames[3].document.getElementById('fileid').innerHTML="<input type='text' name='fileno' id='fileno' tabIndex='2' size='20' maxlength='20' value='' onBlur='ChangeUpperCase(this);CheckFileExists(this.value);' >"
				parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				}else{
					parent.frames[1].document.forms[0].patientid.focus();
					parent.frames[1].document.forms[0].validFile.value ='false';					
					if(parent.frames[1].document.getElementById('fileid'))
					parent.frames[1].document.getElementById('fileid').innerHTML="<input type='text' name='fileno' id='fileno' tabIndex='2' size='20' maxlength='20' value='' onBlur='ChangeUpperCase(this);CheckFileExists(this.value);' >";
			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				}	
			   	</script>
				<%
			}
		}
		else
		{
			if (func.equals("tracer"))
			{
				if(file_type_yn.equals("N"))
				{
%>	
				<script>
					 var Rename="<%=Rename%>";
					if(Rename=="RE")
				{
							  
				  parent.frames[3].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str%></select>";
					if(parent.frames[3].document.forms[0].validFile)
					parent.frames[3].document.forms[0].validFile.value ='true';	
				   if(parent.frames[3].document.getElementById('volid'))
				   parent.frames[3].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
				}else{
              if(Rename=="IP" || Rename=="OP")
					{
                  parent.frames[2].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str%></select>";
					parent.frames[2].document.forms[0].validFile.value ='true';	
					  parent.frames[2].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
					}else{
			   parent.frames[2].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str%></select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
					parent.frames[2].document.forms[0].validFile.value ='true';							
					}	
					}	
				</script>
<%	}else
		{%>	
				<script>
             		var Rename="<%=Rename%>";
					if(Rename=="RE")
				{
				parent.frames[3].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str1%></select>";
					parent.frames[2].document.forms[0].validFile.value ='true';
					parent.frames[2].document.forms[0].file_type_code.value ='<%=file_type_code%>';
					parent.frames[3].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
				
				}else{
					 if(Rename=="IP" || Rename=="OP")
					{
					
					parent.frames[2].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str1%></select>";
					parent.frames[2].document.forms[0].validFile.value ='true';
					parent.frames[2].document.forms[0].file_type_code.value ='<%=file_type_code%>';
					parent.frames[2].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
					}else{

                  parent.frames[2].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str1%></select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
					parent.frames[2].document.forms[0].validFile.value ='true';
					parent.frames[2].document.forms[0].file_type_code.value ='<%=file_type_code%>';
					parent.frames[2].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
					}
				
				}
				</script>
<%	}
			}
			else
			{
				
				if(file_type_yn.equals("N"))
				{
					%>
					<script>
					var Rename="<%=Rename%>";
					if(Rename=="RE")
				{
				parent.frames[3].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str%></select>";
						parent.frames[2].document.forms[0].validFile.value ='true';	
				
				}else{
                     if(Rename=="IP" || Rename=="OP")
					    {
						if(parent.frames[1].document.getElementById('fileid'))
						parent.frames[1].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str%></select>";
						parent.frames[1].document.forms[0].validFile.value ='true';							}else{
						if(parent.frames[1].document.getElementById('fileid'))
						parent.frames[1].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onChange='CheckFileExists(this.value);'><%=str%></select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						if(parent.frames[1].document.getElementById('volid'))
						parent.frames[1].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
						parent.frames[1].document.forms[0].validFile.value ='true';

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
					if(Rename=="RE")
				{
				parent.frames[3].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onBlur='CheckFileExists(this.value);'><%=str1%></select>";
						parent.frames[2].document.forms[0].validFile.value ='true';
						parent.frames[2].document.forms[0].file_type_code.value ='<%=file_type_code%>';
						parent.frames[2].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
				}else{
					 if(Rename=="IP" || Rename=="OP")
					    {
					
					if(parent.frames[1].document.getElementById('fileid'))
					parent.frames[1].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onBlur='CheckFileExists(this.value);'><%=str1%></select>";
						if(parent.frames[1].document.forms[0].validFile)
						parent.frames[1].document.forms[0].validFile.value ='true';
						if(parent.frames[1].document.forms[0].file_type_code)
						parent.frames[1].document.forms[0].file_type_code.value ='<%=file_type_code%>';
						if(parent.frames[1].document.getElementById('volid'))
						parent.frames[1].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";
						}else{
                   if(parent.frames[1].document.getElementById('fileid'))
					parent.frames[1].document.getElementById('fileid').innerHTML="<select name=fileno id=fileno onBlur='CheckFileExists(this.value);'><%=str1%></select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						if(parent.frames[1].document.forms[0].validFile)
						parent.frames[1].document.forms[0].validFile.value ='true';
						if(parent.frames[1].document.forms[0].file_type_code)
						parent.frames[1].document.forms[0].file_type_code.value ='<%=file_type_code%>';
						if(parent.frames[1].document.getElementById('volid'))
						parent.frames[1].document.getElementById('volid').innerHTML="<select name=volumeno id=volumeno ><%=vol1%></select>";

						}
				
				
				}	
					</script>
					<%
				}
			}
		}
		if (rs!=null) rs.close();
		if (rs1!=null) rs1.close();
		if (stmt!=null) stmt.close();
		
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

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

