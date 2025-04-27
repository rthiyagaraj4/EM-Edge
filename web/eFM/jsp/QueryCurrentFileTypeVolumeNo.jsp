<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager,java.util.*, java.util.StringTokenizer" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src='../../eFM/js/QueryFMCurrentFileStatus.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String facility_id				= (String) session.getValue("facility_id");
	
	Connection connection			=	null;
	PreparedStatement preStatement	=	null;
	PreparedStatement pstmt	=	null;
	PreparedStatement pstmt1	=	null;
	ResultSet	resultSet			=	null;
	ResultSet	rset			=	null;
   ResultSet	rset1			=	null;
	String patient_id				=	"";
	String file_type_appl_yn		=	"N";
	StringBuffer sqlString				=	new StringBuffer();
     String file_no					=	"";
	String file_type				=	"";
	String volume_no				=	"";
	String dflt_incomplete_fs_locn_code		=	"";
	String class_value				=	"QRYEVEN";
	String file_type_desc="";
	String fileno="";
	String volumeno="";
	String flag="false";
	String volume_status="";
	String faci_id="";
	int countt=0;
	//String volume_status="";
	int count						=	1;
	int cnt							=	0;
	Hashtable		htRecord	=	null;
	try
	{
		 htRecord			=	new Hashtable();
		patient_id			=	checkForNull(request.getParameter("patient_id"));
		file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"), "N");
		file_no				=	checkForNull(request.getParameter("file_no"));

		file_type			=	checkForNull(request.getParameter("file_type"));
		volume_no			=	checkForNull(request.getParameter("volume_no"));
		dflt_incomplete_fs_locn_code =	checkForNull(request.getParameter("dflt_incomplete_fs_locn_code"));

		String incomp_chk = checkForNull(request.getParameter("incomp_chk"));
		String lost_chk = checkForNull(request.getParameter("lost_chk"));
		String inact_chk = checkForNull(request.getParameter("inact_chk"));
		connection			=	ConnectionManager.getConnection(request);
		String dflt_valnot = "";


		if(! dflt_incomplete_fs_locn_code.equals(""))
		{
		dflt_valnot = "and curr_fs_locn_code != '"+dflt_incomplete_fs_locn_code+"'";
		}
		//sqlString.append(" SELECT distinct a.file_no, a.file_type_code, b.short_desc file_type_desc, a.volume_no, a.volume_status FROM FM_CURR_LOCN a, mr_file_type b WHERE a.patient_id = ? and a.facility_id = b.facility_id(+) and a.file_type_code = b.file_type_code(+)  and volume_status='A'  ");
		
		//sqlString.append(" SELECT  a.file_no  , a.file_type_code  , MR_GET_DESC.MR_FILE_TYPE(a.facility_id, a.file_type_code, '"+localeName+"', 2) file_type_desc  , a.volume_no  , a.volume_status  FROM  FM_CURR_LOCN a WHERE a.patient_id = ?   AND volume_status='A'  ");

		sqlString.append(" SELECT  a.file_no  , a.file_type_code  , MR_GET_DESC.MR_FILE_TYPE(a.facility_id, a.file_type_code, '"+localeName+"', 2) file_type_desc  ,MAX(a.volume_no) volume_no, a.volume_status,facility_id  FROM  FM_CURR_LOCN a WHERE a.patient_id = ?  AND volume_status NOT IN('I') ");

		if(lost_chk.equals("N"))
		{
			sqlString.append(" AND volume_status='A' ");
		}

		if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString.append(dflt_valnot +" and curr_file_status not in ('A','L')  ");
		else if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString.append(dflt_valnot +" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString.append(dflt_valnot +" and curr_file_status not in ('A')");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y"))
			sqlString.append(dflt_valnot);
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString.append(" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString.append(" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString.append(" and curr_file_status not in ('A') ");


sqlString.append("  GROUP BY a.facility_id,a.file_no,a.file_type_code,a.volume_status order by volume_no desc ");




		
		preStatement	=	connection.prepareStatement(sqlString.toString());

		preStatement.setString(1, patient_id);
		resultSet		=	preStatement.executeQuery();

	//	sqlString1.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = ? and volume_status IN('I','L') and file_no=?");
		
		/*if(file_type_appl_yn.equals("Y")) {
			sqlString1.append("and file_type_code = ? ");
		}commented by sathish for IN018405 on Friday, January 22, 2010*/ 
/*
		if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A')");
			else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot);
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A') ");

			pstmt	=	connection.prepareStatement(sqlString1.toString()); */

		String file_typecode	= "";
		String code				= "";		
		%>
		<body onMouseDown = "CodeArrest();" onKeyDown = 'lockKey();'> 
		<form name='QueryFileTypeVolume' id='QueryFileTypeVolume' action='' method='POST'>

		<% if(resultSet != null) 
		{
			%>
			<table width="50%" cellpadding="0" cellspacing="0" border="1" align="CENTER" id='tb1'>
				<tr>			
				<% if(file_type_appl_yn.equals("N")) { %>
					<th width="30%" class='columnheader' style="background:#224771" id="th2"><fmt:message key="Common.fileno.label" bundle="${common_labels}"/> </th>
			<% } else if(file_type_appl_yn.equals("Y")) { %>
					<th width="10%" class='columnheader' style="background:#224771" id="th2"><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></th>
			<% } %>
					<th width="10%" class='columnheader' style="background:#224771" id="th1" nowrap><fmt:message key="eFM.ActiveVolumeNo.label" bundle="${fm_labels}"/></th>
					<th width="10%" class='columnheader' style="background:#224771" id="th3" nowrap><fmt:message key="eFM.InactiveVolumeNo.label" bundle="${fm_labels}"/></th>
				</tr>
			<%
			while(resultSet.next())
			{
			
				
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
			
			
			      file_type_desc=  checkForNull(resultSet.getString("file_type_desc"), "&nbsp;");
			      fileno         =checkForNull(resultSet.getString("file_no"), "&nbsp;");
			      volumeno  = checkForNull(resultSet.getString("volume_no"));
			      file_typecode = checkForNull(resultSet.getString("file_type_code")); 	
			      faci_id     = checkForNull(resultSet.getString("facility_id")); //Added by S.Sathish for IN021074 on Friday, April 30, 2010
				  
				if(file_typecode==null) file_typecode="";
				if (file_type_appl_yn.equals("Y"))
				{
				  String file_typecodecomp	=	(String)	htRecord.get(file_typecode);				  

				 if(file_typecodecomp==null || file_typecodecomp.equals("null") ) 
					{
					file_typecodecomp="";
						}
								
				file_typecode=faci_id+"/"+file_typecode;  //Added by S.Sathish for IN021074 on Friday, April 30, 2010
				
				 if(!file_typecodecomp.equals("") && file_typecodecomp.equals(file_typecode) )
					{
                  					
					file_type_desc="&nbsp";
                   volumeno="&nbsp";
					fileno="";
					flag="true";
						}				 
				 
				 htRecord.put(file_typecode	,file_typecode);
					
				}
			  
			 if(file_type_appl_yn.equals("N"))
				{
				String filenocomp	=	(String)	htRecord.get(fileno);
				 if(filenocomp==null || filenocomp.equals("null"))  filenocomp="";
				  
				  if(!filenocomp.equals("") && filenocomp.equals(fileno))
					{
				   volumeno="&nbsp";
					fileno="&nbsp";
					 flag="true";
						}
			 htRecord.put(fileno,fileno); 
				}							
				
				if(flag.equals("false"))
				{			 
           	 
			  countt++;
			 %>
			<tr>			
			<% if (file_type_appl_yn.equals("N")) { %>
				<td class="<%=class_value%>"><%=fileno%></td>
			<% } else if (file_type_appl_yn.equals("Y")) { %>
					<td class="<%=class_value%>"><%=file_type_desc%></td>	
			<% } %>
           <!--Below line modified for this CRF HSA-CRF-0306-->
			<td class="<%=class_value%>" align="CENTER" style="cursor:pointer;color:blue" onClick="if(document.getElementById('inactive_vols<%=count%>').options[0]!=null){document.forms[0].inactive_vols<%=count%>.options[0].selected=true}; javascript:searchResult('<%=volumeno%>', '<%=fileno%>', '<%=patient_id%>');changeRowColor(this,2); changeBackgroundFM();" name='<%=count%>' id='<%=count%>'><%=volumeno%></font></td>
			<td class="<%=class_value%>" align='center' width='7%'><select name='inactive_vols<%=count%>' id='inactive_vols<%=count%>' onchange="javascript:searchResult(this.value, '<%=fileno%>', '<%=patient_id%>');changeRowColor1(2); changeBackgroundFM();"><option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
				<%
				  
			pstmt1	=	connection.prepareStatement("select volume_status  from fm_curr_locn where patient_id=? and file_no=? and facility_id=? and volume_no=(select max(volume_no) from fm_curr_locn where patient_id=? and file_no=? and facility_id=? )");
           pstmt1.setString(1, patient_id);
           pstmt1.setString(2, fileno);
		    pstmt1.setString(3, facility_id);	
		    pstmt1.setString(4, patient_id);	
		   pstmt1.setString(5, fileno);	
		   pstmt1.setString(6,facility_id);
			rset1		=	pstmt1.executeQuery();
              
				
				while(rset1.next())
                {
				volume_status    = rset1.getString("volume_status");                     
                
				  } 
            		StringBuffer sqlString1			=	new StringBuffer();		
			sqlString1.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = ? and volume_status IN('I','L') and file_no=?");
		
		if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A')");
			else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot);
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A') ");
		
		
				
		if((incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("Y")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y")) )
		{
          
			if(volume_status.equals("L"))
			{
			
			
			sqlString1.append("  AND volume_no <> (SELECT  nvl(max(volume_no),0)    FROM fm_curr_locn   WHERE patient_id = ?  AND volume_status IN('L')   AND file_no =?  AND curr_file_status NOT IN('A'))");
			}else{
	     sqlString1.append("  AND volume_status NOT IN('A')" );
		}
		}
			sqlString1.append(" order by volume_no ");
			pstmt	=	connection.prepareStatement(sqlString1.toString());			
			
			
			pstmt.setString(1, patient_id);
				/*if (file_type_appl_yn.equals("Y") && !file_typecode.equals("")) {
					pstmt.setString(3, file_typecode);
				} commented by sathish for IN018405 on Friday, January 22, 2010*/

					pstmt.setString(2,fileno );

	if(volume_status.equals("L"))
					{
		if((incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("Y")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y")) )
		{
          pstmt.setString(3, patient_id);
          pstmt.setString(4,fileno);
		  }
					}	
						rset		=	pstmt.executeQuery();
            			
				while(rset.next())
                {
					code    = rset.getString("volume_no");                     
                    out.println("<option value='"+code+"'>"+code);
                } if(rset != null) rset.close();
               				
                %></select>
			</td> 
		</tr>
		<%				
				}
			if(flag.equals("false"))
				{
			count++;
				}
			flag="false";
			cnt++;
			}
		}
		
		
		if(cnt == 0)
		{
			%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				parent.volumeFrame.document.location.href="../../eCommon/html/blank.html";
				parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html";
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
			</script>
			<%
		}
		%>
		<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
		<input type="Hidden" name="file_type" id="file_type" value="<%=file_type%>">
		<input type="Hidden" name="volume_no" id="volume_no" value="<%=volume_no%>">
		<input type="Hidden" name="countt" id="countt" value="<%=countt%>">
		</table>		
		</form>
		<script>parent.searchResultFrame.location.href='../../eCommon/html/blank.html';</script>
	<%
	//}

	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(resultSet!=null)	resultSet.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(preStatement!=null) preStatement.close();

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
	return(((inputString == null) || (inputString.equals("")) ) ? defaultValue : inputString);
}

%>

