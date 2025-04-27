<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" contentType=" text/html;charset=UTF-8"%>
<html>
	<head>	
	
	<% String locale = (String)session.getAttribute("LOCALE"); %>
	<% request.setCharacterEncoding("UTF-8");%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<%
		//System.out.println ("eBT ManageLISImageSpecimen  2 ");
		Connection con = null;
		PreparedStatement pstmtImgView = null;
		PreparedStatement pstmtImgViewOthers = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ResultSet resImgView = null;

		String test = "";
		String testCode = "";
		String sampleId = "";
		String anatomy = "";
		String anatomyCode = "";
		String tissueDesc = "";
		String anatomyInd = "";
		String section_ind = "";
		int count = 0;
		int recCount = 0;
		String classValue = "QRYEVEN";

	
		String accessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
		String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String p_resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
		String colSpan = "1";
		String applServerURL = "";

			//System.out.println ("eBT ManageLISImageSpecimen 3  "+accessionNum);

		if(facilityId.equals(""))
			facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

		//String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE WHERE section_code = ?";
		String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE_LANG_VW WHERE section_code = ? AND LANGUAGE_ID = ?";

		//String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ?   AND NVL(?, '!!') = 'AT'  AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND NVL(?, '!!') = 'SA' AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND A.tissue_desc_code = D.tissue_desc_code(+) ORDER BY 3, 4 ";

		String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ?   AND NVL(?, '!!') = 'AT'  AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND NVL(?, '!!') = 'SA' AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) ORDER BY 3, 4";

		String sqlO = "select a.specimen_no, a.test_code, b.short_desc test_desc from rl_request_detail a, rl_test_code_lang_vw b where a.specimen_no = ? and a.operating_facility_id = ? and a.test_code = b.test_code and b.language_id = ? ";

		try
		{
				//System.out.println("eBT ManageLISImageSpecimen 4"); 
			if(!p_resp_id.equals("RL_MANAGER"))
				con = ConnectionManager.getConnection(request);
			else if(p_resp_id.equals("RL_MANAGER"))
						con = ConnectionManager.getConnection();
		//System.out.println("eBT ManageLISImageSpecimen 5");

			pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
			//System.out.println("eBT ManageLISImageSpecimen 6");

			res = pstmt.executeQuery();
		
			while(res.next())
			{
				applServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String specNum = "";
			String eventCode = "";
			String contrSysEventCode = "";
			String secCode = "";

		//System.out.println( " Accession Num " + accessionNum);
			if(accessionNum.equals(""))
			{
				specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");
				secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
			}
			else
			{
				String sqlAccessionNum = "select event_code, CONTR_SYS_EVENT_CODE, SUBSTR (?, (INSTR (?, '#') + 1), ( (INSTR (?, '@') - 1) - INSTR (?, '#'))) spec_num from cr_encounter_detail where ACCESSION_NUM = ? ";
				String sqlTestCode = "select test_code from rl_test_code where ORDER_CATALOG_CODE = ? ";

				pstmt = con.prepareStatement(sqlAccessionNum);
				pstmt.setString(1,accessionNum);
				pstmt.setString(2,accessionNum);
				pstmt.setString(3,accessionNum);
				pstmt.setString(4,accessionNum);
				pstmt.setString(5,accessionNum);
				res = pstmt.executeQuery();

				while(res.next())
				{
					eventCode = res.getString("event_code") == null ? "" : res.getString("event_code");
					contrSysEventCode = res.getString("CONTR_SYS_EVENT_CODE") == null ? "" : res.getString("CONTR_SYS_EVENT_CODE");
					specNum = res.getString("spec_num") == null ? "" : res.getString("spec_num");
				}

				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
//System.out.println("eBT ManageLISImageSpecimen 7");
				pstmt = con.prepareStatement(sqlTestCode);
				pstmt.setString(1,eventCode);
				res = pstmt.executeQuery();

				while(res.next())
				{
					test = res.getString("test_code") == null ? "" : res.getString("test_code");
				}

				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
//System.out.println("eBT ManageLISImageSpecimen 8");
				if(!accessionNum.equals(""))
				{	
					pstmt = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
					pstmt.setString(1,contrSysEventCode);
					res = pstmt.executeQuery();

					while(res.next())
					{
						secCode = res.getString("section_code") == null ? "" : res.getString("section_code");
					}

					if(res != null) res.close();
					if(pstmt != null) pstmt.close();
				}
			}
//System.out.println("eBT ManageLISImageSpecimen 9");
			if(p_resp_id.equals("RL_MANAGER"))
			{
			%>
				<link rel='StyleSheet' href='<%=applServerURL%>eCommon/html/IeStyle.css' type='text/css' />
			<%
			}
			else
			{
			%>
				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
			<%
			}
			pstmt = con.prepareStatement(sqlSecInd);
			pstmt.setString(1,secCode);
			pstmt.setString(2,locale);
			res = pstmt.executeQuery();
			while(res.next())
			{
				anatomyInd = res.getString("anatomy_ind") == null ? "" : res.getString("anatomy_ind");
				section_ind = res.getString("section_ind") == null ? "" : res.getString("section_ind");
			}


			if(res != null) res.close();
			if(pstmt != null) pstmt.close();

//System.out.println("eBT ManageLISImageSpecimen 10");
			%>

			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script src="../../eBT/js/ManageLISSpecimenImage.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		</head>
		<body>
			<form name='uploadLinkForm' id='uploadLinkForm'>
			<table border='1' width='100%' cellpadding='1' cellspacing='0' align='center'>
				<tr>
					<td class='CAGROUP' colspan='6'><fmt:message key="eBT.SpecimenNo.label" bundle="${common_labels}"/> <%=specNum%></td>
				</tr>				
				<%
				if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
				{					
				%>
					<tr>
					<th align='left'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></th>					
					<th align='left'><fmt:message key="eBT.SampleID.label" bundle="${bt_labels}"/></th>
					<th align='left'><fmt:message key="eBT.Anatomy.label" bundle="${bt_labels}"/></th>					
					<th align='left' colspan='3'><fmt:message key="eBT.TissueDescription.label" bundle="${bt_labels}"/></th>
					</tr>
				<%
				}
				else 
				{
					anatomyInd = "";//Sanjay
					sampleId = "";//Sanjay
				%>
				<tr>
					<th align='left'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></th>
					<th align='left'><fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/></th>
					<th align='left'><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
					</tr>
				<%
				}
				%>
				<tr>
			<%			
			
			

			pstmtImgView = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID = ? and ANATOMY_SITE_CODE = ?");

			pstmtImgViewOthers = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID is null and ANATOMY_SITE_CODE is null");
//System.out.println("eBT ManageLISImageSpecimen 11");			
			if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
			{
				pstmt = con.prepareStatement(sql);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);//Sanjay
				pstmt.setString(1,specNum);
				pstmt.setString(2,anatomyInd);
				pstmt.setString(3,locale);
				pstmt.setString(4,specNum);
				pstmt.setString(5,anatomyInd);
				pstmt.setString(6,locale);
			}
			else {
				pstmt = con.prepareStatement(sqlO);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);//Sanjay
				pstmt.setInt(1,Integer.parseInt(specNum));
				pstmt.setString(2,facilityId);
				pstmt.setString(3,locale);				
			}

			res = pstmt.executeQuery();
//System.out.println("eBT ManageLISImageSpecimen 12");
			while(res.next())
			{
				if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
				{
					test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
					testCode = res.getString("test_code") == null ? "" : res.getString("test_code");
					anatomy = res.getString("anatomy_desc") == null ? "" : res.getString("anatomy_desc");
					anatomyCode = res.getString("anatomy_site_code") == null ? "" : res.getString("anatomy_site_code");
					//out.println("Sample ID:"+res.getString("sample_id"));
					sampleId = res.getString("sample_id") == null ? "" : res.getString("sample_id");
					tissueDesc = res.getString("tissue_desc") == null ? "&nbsp;" : res.getString("tissue_desc");

					if(count % 2 == 0) classValue = "QRYEVEN";
					else classValue = "QRYODD";	
					
					if(p_resp_id.equals("RL_MANAGER"))
					{
						colSpan = "2";
					}
					else
					{
						colSpan = "1";				
					}
					
					out.println("<td class='"+classValue+"'>"+test+"</td>");
					out.println("<td class='"+classValue+"'>"+sampleId+"</td>");
					out.println("<td class='"+classValue+"'>"+anatomy+"</td>");
					out.println("<td class='"+classValue+"' colspan='"+colSpan+"'>"+tissueDesc+"</td>");
					
				} else
				{
					if(count % 2 == 0) classValue = "QRYEVEN";
					else classValue = "QRYODD";	
					
					if(p_resp_id.equals("RL_MANAGER"))
					{
						colSpan = "2";
					}
					else
					{
						colSpan = "1";				
					}

					test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
					testCode = res.getString("test_code") == null ? "" : res.getString("test_code");					
					out.println("<td class='"+classValue+"'>"+test+"</td>");				
				}
				if(!p_resp_id.equals("RL_MANAGER") && accessionNum.equals(""))
				{
					out.println("<td class='"+classValue+"'><a href=\"javascript:showUploadPage('"+specNum+"','"+testCode+"','"+sampleId+"','"+anatomyCode+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UploadFile.label","common_labels")+"</a></td>");
				}
//System.out.println("eBT ManageLISImageSpecimen 13");
				if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
				{
					pstmtImgView.setString(1,facilityId);
					pstmtImgView.setString(2,specNum);
					pstmtImgView.setString(3,testCode);
					pstmtImgView.setString(4,sampleId);
					pstmtImgView.setString(5,anatomyCode);
					resImgView = pstmtImgView.executeQuery();
				}
				else
				{
					pstmtImgViewOthers.setString(1,facilityId);
					pstmtImgViewOthers.setString(2,specNum);
					pstmtImgViewOthers.setString(3,testCode);
					resImgView = pstmtImgViewOthers.executeQuery();
				}				
				while(resImgView.next())
				{
					recCount = resImgView.getInt(1);
				}

				if(resImgView != null) resImgView.close();				
//System.out.println("eBT ManageLISImageSpecimen 14");				
				if(recCount > 0)
				{
					out.println("<td class='"+classValue+"'><a href=\"javascript:viewUploadedImg('"+specNum+"','"+testCode+"','"+sampleId+"','"+anatomyCode+"','"+recCount+"','"+facilityId+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a></td>");
				}
				else
				{
					out.println("<td class='"+classValue+"'>&nbsp;</td>");
				}
				out.println("</tr>");
				count++;
			}
//System.out.println("eBT ManageLISImageSpecimen 15");
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
			if(pstmtImgView != null) pstmtImgView.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
			//System.out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
			</table>
			<input type='hidden' name='p_resp_id' id='p_resp_id' value='<%=p_resp_id%>'>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		</form>
	</body>
</html>

