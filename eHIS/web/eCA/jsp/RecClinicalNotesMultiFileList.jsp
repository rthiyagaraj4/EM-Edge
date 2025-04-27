<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/01/2018	IN065843		Sharanraj		15/01/2018		Ramesh G		ML-MMOH-CRF-0999
13/12/2022	37958			Ramesh Goli		13/12/2022		Ramesh G		ML-MMOH-CRF-1977
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eCommon.Common.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> <!-- Added for IN065843 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eCA.Preview.label" bundle="${ca_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js' ></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body>
		<%
		boolean custSpecificFlg =false;//IN065843
		String siteSpecFlag="N"; //IN065843
		int i=0; //39647
			String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
			String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
			String sqlQry = "SELECT FILE_NAME, EVENT_TITLE, FILE_SEQ_NO FROM  CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? /*AND CONTR_SYS_EVENT_CODE = ?*/ ORDER BY FILE_SEQ_NO"; //37958  Commented contr_sys_event_code
			List<String> uploadDocLst = new ArrayList<String>();
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try
			{		
				con = ConnectionManager.getConnection();
				// IN065843 Starts
				try
				{
					custSpecificFlg = CommonBean.isSiteSpecific(con, "CA","VIEW_REMARKS_SINGLE_FILE");
					if(custSpecificFlg)
						siteSpecFlag ="Y";
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				// IN065843 ends
				pst = con.prepareStatement(sqlQry);
				pst.setString(1, accession_num);
				//pst.setString(2, note_type);  //37958
				rs = pst.executeQuery();
				int docCnt = 1;
				String docName = "";
				while(rs.next())
				{
					docName = rs.getString("FILE_NAME")== null?"temp_"+docCnt:rs.getString("FILE_NAME");
					docName = docName + "`~"+(rs.getString("EVENT_TITLE")==null?"NOREMARKS":rs.getString("EVENT_TITLE"));
					docName = docName + "`~"+(rs.getString("FILE_SEQ_NO")==null?"NOREMARKS":rs.getString("FILE_SEQ_NO"));
					uploadDocLst.add(docName);
					docCnt++;
				}

				if(rs != null)
				{
					rs.close();
				}

				if(pst != null)
				{
					pst.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con != null)
				{
					try
					{
						con.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
	// IN065843 Starts
	
	   if(siteSpecFlag=="N")
	   {	
		    if(uploadDocLst.size() == 1)
			{			
				response.sendRedirect("../../eCA/jsp/RecClinicalNotesFileUploadShowDocMain.jsp?accession_num="+accession_num+"&note_type="+note_type);
			}
	  }	
	// IN065843 Ends
			%>
				<form>
					<table class='grid' width='100%'>
						<tr>
							<td class='columnheadercenter'><fmt:message key="eCA.FileReference.label" bundle="${ca_labels}"/></td>
							<td class='columnheadercenter' colspan='2'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						</tr>
						<tr>
							<%
								if(uploadDocLst != null)
								{
									String []fileNm = null;
									String fileNameTemp=""; //39647
									
									for(String fileName: uploadDocLst)
									{
										fileNm = fileName.split("`~");
										if(i==0)
											fileNameTemp=fileNm[2];
										
										if(i==0){
										%>
										<TR id='TRI<%=i%>' class='gridDataSelect'>
										<%
										}else{
										%>
										<TR id='TRI<%=i%>' class=''>
										<%
										}
										%>
										<td class=''><%=fileNm[0]%></td>
										<td class='' wrap><%=fileNm[1].equals("NOREMARKS")?"&nbsp;":fileNm[1]%></td>
										<td class='' ><a href='#' class='gridLink' onclick="showDBDoc('<%=accession_num%>', '<%=note_type%>', '<%=fileNm[2]%>');trColourChange(<%=i%>)"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
										
									</tr>
								<%
									i++;
									}
									//39647 Start.
									%>
									<script>									
									var frameSize1=50;
									if(50+(<%=i%>*15)>250){										
										frameSize1=250;
									}else{ 									
									frameSize1=50+(<%=i%>*15);
									};
									
									parent.document.getElementsByTagName( 'frameset' )[ 0 ].rows=frameSize1+",*";
									showDBDoc('<%=accession_num%>', '<%=note_type%>', '<%=fileNameTemp%>');
									</script>
									<%
									//39647 End.
									
								}
							%>
						</tr>
						<input type="hidden" name="totalRecords" id="totalRecords" value="<%=i%>"/>
					</table>
				</form>
			<%
		%>
	</body>
</html>

