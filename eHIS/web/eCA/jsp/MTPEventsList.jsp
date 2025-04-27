<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/common.js"			language="javascript"></script>
<script src='../js/MTP.js'                          language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
		Connection	con			=	null;
		PreparedStatement pstmt	=	null;
		ResultSet rs			=	null;

		String strPatientId		=	"";
		String strEncId			=	"";
		String strEvent			=	"";
		String strEvDtTime		=	"";
		String strDetails		=	"";
		String strEncDetails	=	"";
		String strPatientName	=	"";
		String strPracInfo		=	"";
		String strEncInfn		=	"";
		String strAccNum		=	"";
		String strRstType		=	"";
		String strObjname		=	"";
		String strSrcPatId		=	"";
		String strSrcEncId		=	"";
		String strHistRecType	=	"";
		String strContSysId		=	"";
		String strContEvCode	=	"";
		String strFacilityId	=	"";
		String strQuery			=	"";
		String strExeMode		=	"";

		StringBuffer strPatFullInfn		= new StringBuffer();
		StringBuffer strBuffPatientInfo = new StringBuffer();

		strFacilityId			=	(String) session.getValue("facility_id");

		int nIdx	=	0;

		strPatientId			=	checkForNull(request.getParameter("patient_id"));
		strEncId				=	checkForNull(request.getParameter("enc_id"));
		strObjname				=	checkForNull(request.getParameter("objname"));
		strSrcPatId				=	checkForNull(request.getParameter("srcpatid"));
		strSrcEncId				=	checkForNull(request.getParameter("srcencid"));
		strExeMode				=	checkForNull(request.getParameter("mode"));

		try
		{
			con			=	ConnectionManager.getConnection(request);

			if(strExeMode.equals("1") )
			{
				strQuery	=	"select get_patient.get_line_detail(?,?,?) Pline FROM dual";

				pstmt		=	con.prepareStatement(strQuery);
			
				pstmt.setString(1,strFacilityId);
				pstmt.setString(2,strEncId);
				pstmt.setString(3,locale);

				rs			=	pstmt.executeQuery();
			
				if(rs != null && rs.next())
				{
					strEncDetails		= checkForNull(rs.getString(1));
					
					if(!strEncDetails.equals(""))
					{
						StringTokenizer token=new StringTokenizer(strEncDetails,"|");

						while(token.hasMoreTokens())
						{
							strPatientName	= token.nextToken();
							strBuffPatientInfo.append(token.nextToken());
						
							if(!strEncId.equals(""))
							{
								strPracInfo	= token.nextToken();
								strEncInfn	= token.nextToken();
								strEncInfn	= strEncInfn.substring(strEncInfn.indexOf(':')+1);
							}
						}

						strPatFullInfn.append(strPatientName);
						strPatFullInfn.append(", Encounter: ");
						strPatFullInfn.append(strEncInfn);
						strPatFullInfn.append(", Location: ");
						strPatFullInfn.append(strPracInfo.substring((strPracInfo.indexOf('/')+1)));
						strPatFullInfn.append(", Practitioner: ");
						strPatFullInfn.append(strPracInfo.substring(0,(strPracInfo.indexOf('/'))));
						
						if(strObjname.equals("enc_id_search") )
						{
							out.println("<script>parent.frames[1].document.getElementById('srcpatinfo').innerText = \""+strPatFullInfn.toString()+"\";</script>");
							out.println("<script>parent.frames[1].document.getElementById('search').disabled = false;</script>");
						}
						else
							out.println("<script>parent.frames[1].document.getElementById('tgtpatinfo').innerText = \""+strPatFullInfn.toString()+"\";</script>");
					}
				}
			}
		}
		catch (Exception e22)
		{
			
			e22.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con!=null)con.close();
		}
		
		if(strExeMode.equals("2"))
		{
			strQuery	="SELECT B.SHORT_DESC EVENT_DESC,A.ACCESSION_NUM,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DT,CASE WHEN HIST_DATA_TYPE IN('NUM') THEN RESULT_NUM || ' ' || NVL(RESULT_NUM_UOM,'') WHEN HIST_DATA_TYPE IN ('STR') THEN RESULT_STR WHEN HIST_DATA_TYPE IN('TXT','HTM') THEN 'View Results' END RSTDATA,A.HIST_DATA_TYPE,a.HIST_REC_TYPE,a.CONTR_SYS_ID,a.CONTR_SYS_EVENT_CODE FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B WHERE A.HIST_REC_TYPE = B.HIST_REC_TYPE AND A.EVENT_CODE = B.EVENT_CODE AND A.PATIENT_ID = ? AND A.ENCOUNTER_ID = ? ORDER BY A.EVENT_DATE DESC";

			%>
			<form name="mtpeventlist_form" id="mtpeventlist_form" action = "../../eCA/jsp/MTPValidate.jsp" method ="post" target = "messageFrame">
			<table cellpadding='0' cellspacing='0' border='1' width='100%'>
			<tr id='trcoll'>
				<th align='left' colspan='4'><fmt:message key="eCA.SourceEncounterClinicalEvents.label" bundle="${ca_labels}"/></th>	
			</tr>
			<tr>
				<th align='center' width='36%'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></th>
				<th align='center' width='14%'><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>					
				<th align='center' width='42.5%'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
				<th align='center'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
			</tr>
			</table>
		<%
			try
			{
				con			=	ConnectionManager.getConnection(request);
				pstmt		=	con.prepareStatement(strQuery);

				pstmt.setString(1,strSrcPatId);
				pstmt.setString(2,strSrcEncId);

				//out.println("*********************strSrcPatId "+strSrcPatId+"********* strSrcEncId "+strSrcEncId);
				rs	=	pstmt.executeQuery();
				//out.println("Size = > "+rs.getRow());
				if(rs!=null)
				{  
					String classValue	=	"";

					//out.println("*********************Bottom most block****************");
					%>
					<!-- <div style='width:1024px;height:415px;overflow:auto'> -->
					<table cellpadding='0' cellspacing='0' border='1' width='100%'>
					<%
					while (rs.next())
					{
						strEvent		= checkForNull(rs.getString(1));
						strAccNum		= checkForNull(rs.getString(2));
						strEvDtTime		= checkForNull(rs.getString(3));
						strDetails		= checkForNull(rs.getString(4));
						strRstType		= checkForNull(rs.getString(5));
						strHistRecType	= checkForNull(rs.getString(6));
						strContSysId	= checkForNull(rs.getString(7));
						strContEvCode	= checkForNull(rs.getString(8));

						if ( nIdx % 2 == 0 ) 
							classValue = "QRYEVEN" ;
						else 
							classValue = "QRYODD" ;
						%>
							<tr>
								<td class = '<%=classValue%>' WIDTH='25%'><%=strEvent%></td>
								<td class = '<%=classValue%>' WIDTH='10%'><%=strEvDtTime%>
								<input type ='hidden' name ='acc_num<%=nIdx%>' value = '<%=strAccNum%>'> 
								<input type ='hidden' name ='hist_type<%=nIdx%>' value = '<%=strHistRecType%>'> 
								<input type ='hidden' name ='cont_sysid<%=nIdx%>' value = '<%=strContSysId%>'> 
								<input type ='hidden' name ='cont_evcode<%=nIdx%>' value = '<%=strContEvCode%>'>		
								
								</td>
								<%
									if(strRstType.equals("TXT") || strRstType.equals("HTM") )
									{
										%>						
										<td class = '<%=classValue%>'	WIDTH='30%'><a href ="javascript:callResults('<%=nIdx%>')"><%=strDetails%></a></td>
										<%
									}
									else
									{
										%>
										<td class = '<%=classValue%>'	WIDTH='30%'><%=strDetails%></td>
										<%
									}
									%>
										
								<td class = '<%=classValue%>'	WIDTH='4%' align ='center'><input type ="checkbox" name ="selopt<%=nIdx%>" ></td>
							</tr>
						<%
						nIdx++;
					}
					%>
					<!-- </div> -->
					</table>
					<%

				}
				//out.println("nIdx = > "+nIdx);
				if(nIdx == 0)
				{
				%>
				   	<script>
					var msg = getMessage("NO_RECORD_FOUND","common");
					//var msg = "APP-000052 No Records Found....";
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
					</script>
				<%
				}
			}
			catch (Exception e23)
			{
				
				e23.printStackTrace();
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
		}
%>
<input type ='hidden' name ='totalrecs' value='<%=nIdx%>'>
<input type ='hidden' name ='cntselrecs' >
<input type ='hidden' name ='selopt'>
<input type ='hidden' name ='srcpatid' value = '<%=strSrcPatId%>'>
<input type ='hidden' name ='srcencid' value = '<%=strSrcEncId%>'>
<input type ='hidden' name ='tgtpatid' value = '<%=strPatientId%>'>
<input type ='hidden' name ='tgtencid' value = '<%=strEncId%>'>
</form>
</body>
</html>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

