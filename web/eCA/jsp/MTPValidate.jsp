<%@ page import ="java.sql.*,java.util.StringTokenizer,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/common.js"			language="javascript"></script>
<script src='../js/MTP.js'                          language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name ="validateForm" method = "post" action = "../../eCA/jsp/MTPEventsList.jsp" target = "mtp_events">
<%
	String strSrcPatId		=	"",				strSrcEncId			=	"";
	String strTgtPatId		=	"",				strTgtEncId			=	"";
	String strCheckVal		=	"",				strQuery			=	"";
	String strPRQry			=	"",				strEpisodeId		=	"";
	String strPatClass		=	"",				strAccNumber		=	"";
	String strHistRecType	=	"",				strContSysId		=	"";
	String strContSysEvCode	=	"",				strTotalRecs		=	"";
	String strVisitId		=	"";
	String mtpInsertQuery = "";

	Connection	con			=	null;
	PreparedStatement pstmt	=	null;
	PreparedStatement mtpPstmt = null;
	ResultSet rs			=	null;

	java.util.Properties p	=	(java.util.Properties) session.getValue( "jdbc" );
	String addedById		=	p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
	String addedAtWSNo		=	(String) session.getValue( "facility_id" ) ;

	strSrcPatId				=	checkForNull(request.getParameter("srcpatid"));
	strSrcEncId				=	checkForNull(request.getParameter("srcencid"));
	strTgtPatId				=	checkForNull(request.getParameter("tgtpatid"));
	strTgtEncId				=	checkForNull(request.getParameter("tgtencid"));
	strCheckVal				=	checkForNull(request.getParameter("selopt"));


	strTotalRecs			=	checkForNull(request.getParameter("cntselrecs"));

	int nUpdStatus			=	0;

	boolean bUpdStatus		=	true;

	if(strTotalRecs.equals("") )
		strTotalRecs	=	"0";
%>
	<input type ="hidden" name ="srcpatid" value ='<%=strSrcPatId%>'>
	<input type ="hidden" name ="srcencid" value ='<%=strSrcEncId%>'>
	<input type ="hidden" name ="patient_id" value ='<%=strTgtPatId%>'>
	<input type ="hidden" name ="enc_id" value = '<%=strTgtEncId%>'>
	<input type ="hidden" name ="mode" value ="2">
<%
	try
	{
		con			=	ConnectionManager.getConnection(request);

		strPRQry	=	"SELECT PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM FROM PR_ENCOUNTER WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? ";

		strQuery	=	"UPDATE CR_ENCOUNTER_DETAIL SET PATIENT_ID = ?,ENCOUNTER_ID = ?,EPISODE_ID = ?,PATIENT_CLASS = ?,PROTECTION_IND ='Z',VISIT_ID = ?,MODIFIED_DATE = SYSDATE,MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID = ?  WHERE ACCESSION_NUM = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND CONTR_SYS_EVENT_CODE = ? AND PATIENT_ID = ? AND ENCOUNTER_ID = ? ";

		if( !strCheckVal.equals("") )
		{
			strCheckVal		=	strCheckVal.substring(0,strCheckVal.length()-1);
			
			try
			{
				pstmt	=	con.prepareStatement(strPRQry);
				
				pstmt.setString(1,strTgtPatId);
				pstmt.setString(2,strTgtEncId);

				rs	=	 pstmt.executeQuery();

				if(rs != null && rs.next() )
				{
					strPatClass		= checkForNull(rs.getString(1));
					strEpisodeId	= checkForNull(rs.getString(2));
					strVisitId		= checkForNull(rs.getString(3));
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
			}
			
			
			StringTokenizer stMain		=	 new StringTokenizer(strCheckVal,",");
			pstmt		=	con.prepareStatement(strQuery);

			while(stMain.hasMoreTokens())
			{
				String strSub		=	 stMain.nextToken();
				StringTokenizer stSub	=	new StringTokenizer(strSub,":");
				strAccNumber	=	stSub.nextToken();
				strHistRecType	=	stSub.nextToken();
				strContSysId	=	stSub.nextToken();
				strContSysEvCode=	stSub.nextToken();

				try
				{
					pstmt.clearParameters();

					pstmt.setString(1,strTgtPatId);
					pstmt.setString(2,strTgtEncId);
					pstmt.setString(3,strEpisodeId);
					pstmt.setString(4,strPatClass);
					pstmt.setString(5,strVisitId);
					pstmt.setString(6,addedById);
					pstmt.setString(7,addedAtWSNo);
					pstmt.setString(8,strAccNumber);
					pstmt.setString(9,strHistRecType);
					pstmt.setString(10,strContSysId);
					pstmt.setString(11,strContSysEvCode);
					pstmt.setString(12,strSrcPatId);
					pstmt.setString(13,strSrcEncId);
	
					try
					{
						nUpdStatus	= pstmt.executeUpdate();

					}
					catch (Exception e31)
					{						
						e31.printStackTrace();
						bUpdStatus = false;
					}

					if(nUpdStatus < 0)
					{
						bUpdStatus = false;
						break;
					}
				}
				catch (Exception e26)
				{					
					e26.printStackTrace();
				}
			}

			/*
			The below block was Added by
			Name   : DINESH T 
			Date   : 2010-06-03
			Purpose: Audit details for the patient confidentiality
			*/
			//Starts here
			mtpInsertQuery = "insert into CA_MTP_AUDIT_LOG values(?,?,?,?,?,SYSDATE)";
			mtpPstmt = con.prepareStatement(mtpInsertQuery);

			mtpPstmt.setString(1,strSrcPatId);
			mtpPstmt.setString(2,strTgtPatId);
			mtpPstmt.setString(3,strSrcEncId);
			mtpPstmt.setString(4,strTgtEncId);
			mtpPstmt.setString(5,addedById);

			mtpPstmt.executeUpdate();
			//Ends here

			if(bUpdStatus)
			{
				con.commit();
				%>
					<script>
					var msg = getMessage("RECORD_INSERTED","CA");

					if (msg!="")
					{
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
						document.forms[0].submit();
					}
					
					</script>
				<%
			}
			else
			{
				con.rollback();
				%>
					<script>
					var msg = getMessage("FAILED_OPERATION","CA");

					if (msg!="")
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";

					</script>
				<%
			}	
		}
	}
	catch (Exception e22)
	{
		
		e22.printStackTrace();
		con.rollback();
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

