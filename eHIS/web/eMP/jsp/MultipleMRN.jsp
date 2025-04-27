<!DOCTYPE html>
<!-- Latest Modified Date Time : 9/23/2005 11:25 AM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.ResultSetMetaData,, webbeans.eCommon.ConnectionManager" %>
<%	
	boolean link = false; 
	String queryString = (String)session.getValue("queryString");
	queryString = (queryString == null) ? "" : queryString;	
	if((queryString.indexOf("MP") != -1) &&(queryString.indexOf("ONLINE_REPORT") != -1))link = true;
	request.setCharacterEncoding("UTF-8");
	String patient = request.getParameter("Patient_Id");
	
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;
	
	String Pat_Details	= "";
	String headerDisp	= "";
	
	con = ConnectionManager.getConnection(request); 

	try
	{
		pstmt	= con.prepareStatement("select get_patient_line('"+patient+"','"+localeName+"') from dual");
		rs		= pstmt.executeQuery();
		rs.next();
			Pat_Details = rs.getString(1);

		if(Pat_Details == null || Pat_Details.equals("null")) Pat_Details = "";

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) { out.println(e.toString());}

	String single_or_multi_files_ind	= "";
	String separate_file_no_yn			= "";
	//Array Size was changed by Maheshwaran K for the Inc No :33654 as 27/06/2012
	String tabHeaders[] = new String [6];
	String fieldFetch[] = new String [6];

	int p		= 0;
	int posMRN	= 0;

	try
	{
		pstmt = con.prepareStatement("select SINGLE_OR_MULTI_FILES_IND, SEPARATE_FILE_NO_YN  from mp_param ");
		rs = pstmt.executeQuery();

		while (rs.next())
		{
			single_or_multi_files_ind	= rs.getString(1);
		    separate_file_no_yn			= rs.getString(2);
		}
	
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();
	   //Added by Maheshwaran K for the Inc No :33654 as 27/06/2012
		//Start
		tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));
		fieldFetch[p] = new String("Facility_Id");
		p++;
		//End
		pstmt = con.prepareStatement(" SELECT field_name, field_desc FROM mp_pat_search_result WHERE field_select = 'Y' ORDER BY field_order ");
		rs = pstmt.executeQuery();
		while (rs.next())
		{
		//Commented by Maheshwaran K for the Inc No :33654 as on 27/06/2012
		//Start
			/*if(rs.getString("field_name").equalsIgnoreCase("Facility_Id"))
			{
				tabHeaders[p] = rs.getString("field_desc");
				fieldFetch[p] = "Facility_Name";
				p++;
			}*/
		//End
			if(single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
			{
				if (rs.getString("field_name").equalsIgnoreCase("Patient_Id"))
				{
					tabHeaders[p] = "M.R. No";
					fieldFetch[p] = rs.getString("field_name");
					p++;
					posMRN = p;
				}
			}
			else
			{
				if (rs.getString("field_name").equalsIgnoreCase("File_No"))
				{
					tabHeaders[p] = rs.getString("field_desc");
					fieldFetch[p] = rs.getString("field_name");
					p++;
					posMRN = p;
				}
			}
			if (rs.getString("field_name").equalsIgnoreCase("Old_File_No"))
			{
				tabHeaders[p] = rs.getString("field_desc");
				fieldFetch[p] = rs.getString("field_name");
				p++;
			}	
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) { out.println(e.toString());}
	//Added by Maheshwaran K for the Inc No :33654 as 27/06/2012
	//Start
	tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.filetype.label","common_labels"));
	fieldFetch[p] = new String("file_type_desc");
	p++;
	//End
	tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSection.label","common_labels"));
	fieldFetch[p] = new String("Section_Name");
	p++;
	tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CreatedOn.label","common_labels"));
	fieldFetch[p] = new String("to_char(file_created_date,'dd/mm/yyyy')");
	

	String fields  = "";
	boolean exist_flag = true;

	for(int j=0;j<fieldFetch.length;j++)
	{
		if(fieldFetch[j] != null)
		{
			fields = fields + fieldFetch[j]+" , ";
		}
	}
	fields = fields.substring(0,fields.length()-2);
	
	try
	{
		pstmt = con.prepareStatement("SELECT "+fields+" FROM mr_pat_file_index_vw WHERE patient_id = '"+patient+"'");
		rs = pstmt.executeQuery();
		ResultSetMetaData rsmd	= rs.getMetaData();

		int colCount	= rsmd.getColumnCount();
		String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		%>
		<html>
		<head>
			<title><fmt:message key="Common.PatientFileNo.label" bundle="${common_labels}"/></title>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



			<script>
				function returnValues(mrn)
				{
					window.returnValue = '<%=patient%>'+':'+mrn;	
					window.close();				
				}
				function setValues()
				{
					if(window.returnValue);
					else window.returnValue = ''; 
				}
			</script>
		</head>
		<!-- <body onLoad="GifBlink('<%=Pat_Details%>','document.forms[0]'); startBlink();" onUnload="setValues();" onKeyDown = 'lockKey()'> -->
		<body onLoad="startBlink();" onUnload="setValues();" onKeyDown = 'lockKey()'>
			<form>
				<br>
				<CENTER>
				<table border="0" cellpadding="0" cellspacing="0" width="97%">
					<tr>	
						<td class='PATIENTLINECOLOROTHLANG' width='90%' id='patdetails' style='position:relative;'>&nbsp;</td>
						<TD style='background-color:red' align='center' id='nam' nowrap></TD>
						<!-- <td class='PATIENTLINECOLOROTHLANG' width='30%' align='right'><img name='nam' src='../../eCommon/images/Status.gif'><img name='nam1' src='../../eCommon/images/Status.gif'></td> -->
			
					</tr>
				</table>
				</CENTER>
				<br>
				<CENTER>
				<table border='1' cellpadding=0 cellspacing=0 width="97%">
					<%
					for(int k = 0;k<tabHeaders.length;k++)
					{
						headerDisp = tabHeaders[k];
						if(headerDisp == null) 
						{
							headerDisp="";
							exist_flag = false;
						}
						if(!(headerDisp.equals("")))			
						{
							%><th align=left><%=headerDisp%></th><%
						}
					}
					
					int i = 1;
					String classValue	= "";
					String prtVal		= ""; 
		
					while(rs.next())
					{
						if (i%2 == 0) classValue="QRYEVEN" ;
						else classValue="QRYODD" ;

						%><tr><%
						for(int j = 1;j<=colCount;j++)
						{
							prtVal	= ""; 
							prtVal	= (rs.getString(j) == null) ? "&nbsp;" : rs.getString(j);

							if(link &&(j == posMRN))
							{
								%>
								<td class='<%= classValue %>'>
								<a onClick="returnValues('<%=prtVal%>');" class='showlink'><%=prtVal%></a>
								</td>
								<%
							}
							else
							{
								if(!((exist_flag == false)  && (j == colCount)))
								{
									%><td class='<%= classValue %>'><%=prtVal%></td><%
								}
								else if((exist_flag == false)  && (j == colCount))
								{
									%><td class='<%=classValue%>'><%=prtVal%></td><%
								}
							}
						}
						i++;
						%>
					</tr>
					<%
				}
				
				if (rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			catch(Exception e) { out.println(e.toString());}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			%>
		</table>	
		</CENTER>
	</form>
	</body>
	<script>
	GifBlink("<%=Pat_Details%>","document.forms[0]"); 
	</script>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

