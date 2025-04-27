<!DOCTYPE html>
<%
/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1	     V230313         42420    	 PMG2022-COMN-CRF-0009-US002	Namrata Charate
----------------------------------------------------------------------------------------------
*/
%>

<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/BLDischClear.js"></script>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%			
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		
		try
		{
			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			
			java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_user = (String) p.getProperty("login_user");
			
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			String patient_Id = checkForNull(request.getParameter("patient_id"));
			String episode_Id = checkForNull(request.getParameter("episode_id"));
			String nursing_Unit_Code = checkForNull(request.getParameter("nursing_unit"));
			String disc_Advice_Dt_From =checkForNull(request.getParameter("disc_advice_dt_from"));
			String disc_Advice_Dt_To = checkForNull(request.getParameter("disc_advise_dt_to"));
			String option_val = checkForNull(request.getParameter("option_val"));
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			String total_rec = request.getParameter( "total_rec" ) ;
			String sql = "";
			String patientName = "", patientId = "", episodeId= "", nursingUnitCode = "", discAdviceDtFrom="", discAdviceAtTo ="";
			String episodeType = "", admissionDt = "", docNumber = "", docType = "", patOutsAmt = "" , encounterId = "" , curAcctSeqNo = "", curWardCode="", curBedClassCode = "", curRoomNum = "", curBedNum = "", curPhysicianId = "", reasonCode = "", userId = "", 
			authRemarks = "", discClearanceDocTypeCode = "", docType_docNum = "";
			
			String row_count = "";
			String is_record_selected = "N";
			String valid_user_rec_found_YN = "N";
			
			int maxRecord = 0;
			int start = 0 ;
			int end = 0 ;
			int i = 1;
			int cnt = 0;
			
			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
				end = 15 ;  //V230313
			else
				end = Integer.parseInt( to ) ;
			
			if ( total_rec == null )
				maxRecord = 0 ;
			else
				maxRecord = Integer.parseInt( total_rec ) ;
			
			con=ConnectionManager.getConnection(request);
			
			try
			{
				if(start == 1){
					sql = "Select count(*) as total from ip_episode a, bl_episode_fin_dtls b, "+
								" ip_discharge_advice c  "+
								" where a.facility_id= b.operating_facility_id "+
								" AND A.PATIENT_ID=B.PATIENT_ID "+
								" AND b.PATIENT_ID=c.PATIENT_ID "+
								" and b.operating_facility_id= c.facility_id "+
								" and a.episode_type = b.episode_type "+
								" and a.episode_id =b.episode_id "+
								" and b.episode_id =c.encounter_id "+
								" and c.DIS_ADV_STATUS='0' "+
								" and a.facility_id= ? "+
								" AND B.PATIENT_ID=NVL( ? ,B.PATIENT_ID) "+
								" AND B.EPISODE_ID=NVL( ? ,B.EPISODE_ID) "+
								" AND A.CUR_WARD_CODE=NVL( ? ,A.CUR_WARD_CODE) "+
								" and c.DIS_ADV_DATE_TIME is not null "+
								" and (( ? ='Y' and b.DISCH_BILL_DOC_NUMBER is not null) or ( ? ='N'   and b.DISCH_BILL_DOC_NUMBER is null) or ? ='B' )  "+
								" and not exists  "+
								" (select 'X' from BL_ENC_DISCHARGE_CLEARANCE e  "+
								" where e.episode_type = b.episode_type and e.patient_id = b.patient_id and e.episode_id = b.episode_id "+
								" and operating_facility_id= ? and nvl(cancelled_yn,'N')='N') "+
								" AND trunc(c.DIS_ADV_DATE_TIME) BETWEEN NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
								" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
								" ,'DD-MON-YYYY HH24:MI:SS'))  "+
								" order by a.ADMISSION_DATE_TIME desc ";
				
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1,facilityId);
					pstmt.setString(2,patient_Id);
					pstmt.setString(3,episode_Id);
					pstmt.setString(4,nursing_Unit_Code);
					pstmt.setString(5,option_val);
					pstmt.setString(6,option_val);
					pstmt.setString(7,option_val);
					pstmt.setString(8,facilityId);
					System.err.println("disc_Advice_Dt_From: "+disc_Advice_Dt_From);
					pstmt.setString(9,disc_Advice_Dt_From);
					System.err.println("disc_Advice_Dt_To: "+disc_Advice_Dt_To);
					pstmt.setString(10,disc_Advice_Dt_To);
					System.err.println("Here we are");
					System.err.println("Query is: "+sql);	
					rst = pstmt.executeQuery();
				
					rst.next();
					cnt = rst.getInt("total");
					
					if(cnt == 0){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
					} 
					maxRecord = cnt;
					System.err.println("Total records count is: "+cnt);
				}	
		}catch(Exception e){
			System.err.println("Query Result Exception= "+e.toString());
		}
		
		System.err.println("maxRecord value is: "+maxRecord);
		
		try
		{
			sql = "Select b.episode_type EPISODE_TYPE,b.patient_id PATIENT_ID,b.episode_id EPISODE_ID, "+
					" to_char(a.ADMISSION_DATE_TIME,'dd-MM-yyyy HH24:mi:ss') Admission_dt_dec, "+ 
					" to_char(c.DIS_ADV_DATE_TIME,'dd-MM-yyyy HH24:mi:ss') Discharge_dt_dec, "+
							" b.DISCHARGE_BILL_GEN_IND, b.DISCH_BILL_DOC_TYPE_CODE Doc_Type, "+
							" b.DISCH_BILL_DOC_NUMBER Doc_Number ,A.CUR_WARD_CODE CUR_WARD_CODE, "+
							" A.CUR_ROOM_NUM CUR_ROOM_NUM, A.CUR_BED_NUM CUR_BED_NUM, A.CUR_PHYSICIAN_ID CUR_PHYSICIAN_ID, "+
							" A.CUR_BED_CLASS_CODE CUR_BED_CLASS_CODE, "+
							" B.CUR_ACCT_SEQ_NO CUR_ACCT_SEQ_NO, "+
							" A.ENCOUNTER_ID ENCOUNTER_ID,B.DISCHARGE_BILL_DATE_TIME, (select sum(nvl(BILL_TOT_OUTST_AMT,0)) "+
							" from bl_bill_hdr"+
							" where operating_facility_id= ? "+
							" and patient_id=NVL( ? ,B.PATIENT_ID) "+
							" and episode_id=NVL( ? ,B.EPISODE_ID) "+
							" and episode_type=b.episode_type "+
							" AND BILL_NATURE_CODE='C' AND nvl(BILL_STATUS,'!') "+
							" not in ('C','D')) PAT_OUTST_AMT, "+
							" ( "+
							" select decode( ? ,'en',short_name,SHORT_NAME_LOC_LANG) "+
							" FROM MP_PATIENT_MAST "+
							" WHERE PATIENT_ID=NVL( ? ,B.PATIENT_ID) "+
							" ) PATIENT_NAME "+
							" from ip_episode a, bl_episode_fin_dtls b,ip_discharge_advice c  "+
							" where a.facility_id= b.operating_facility_id "+
							" AND A.PATIENT_ID=B.PATIENT_ID "+
							" AND b.PATIENT_ID=c.PATIENT_ID "+
							" and b.operating_facility_id= c.facility_id "+
							" and a.episode_type = b.episode_type "+
							" and a.episode_id =b.episode_id "+
							" and b.episode_id =c.encounter_id "+
							" and c.DIS_ADV_STATUS='0' "+
							" and a.facility_id= ? "+
							" AND B.PATIENT_ID=NVL( ? ,B.PATIENT_ID) "+
							" AND B.EPISODE_ID=NVL( ? ,B.EPISODE_ID) "+
							" AND A.CUR_WARD_CODE=NVL( ? ,A.CUR_WARD_CODE) "+
							" and c.DIS_ADV_DATE_TIME is not null "+
							" and (( ? ='Y' and b.DISCH_BILL_DOC_NUMBER is not null) or ( ? ='N'   and b.DISCH_BILL_DOC_NUMBER is null) or ? ='B' )  "+
							" and not exists  "+
							" (select 'X' from BL_ENC_DISCHARGE_CLEARANCE e  "+
							" where e.episode_type = b.episode_type and e.patient_id = b.patient_id and e.episode_id = b.episode_id "+
							" and operating_facility_id= ? and nvl(cancelled_yn,'N')='N') "+
							" AND trunc(c.DIS_ADV_DATE_TIME) BETWEEN NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
							" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
							" ,'DD-MON-YYYY HH24:MI:SS'))  "+
							" order by a.ADMISSION_DATE_TIME desc ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,facilityId);
			pstmt.setString(2,patient_Id);
			pstmt.setString(3,episode_Id);
			pstmt.setString(4,locale);
			pstmt.setString(5,patient_Id);
			pstmt.setString(6,facilityId);
			pstmt.setString(7,patient_Id);
			pstmt.setString(8,episode_Id);
			pstmt.setString(9,nursing_Unit_Code);
			pstmt.setString(10,option_val);
			pstmt.setString(11,option_val);
			pstmt.setString(12,option_val);
			pstmt.setString(13,facilityId);
			pstmt.setString(14,disc_Advice_Dt_From);
			pstmt.setString(15,disc_Advice_Dt_To);

			rst = pstmt.executeQuery();
					
		}catch(Exception e){
			System.err.println("Query Result Exception= "+e.toString());
		}			
%>
<form name="BLDischClearQueryResult" id="BLDischClearQueryResult">
<P>
<table align='right'>
<tr>
<td>		
<%

if ( !(start <= 1) ){  
	out.println("<a href='#' onclick='prevbtn();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	
}

if ( !( (start+15) > maxRecord ) )  //V230313
	out.println("<a href='#' onclick='nextbtn();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	
	
if(maxRecord > 0){
%>	
</td>
</tr>
</table>
<br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class='columnheadercenter' nowrap></td>
	<td class='columnheadercenter' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="eBL.DISCR_ADV_DATE.label" bundle="${bl_labels}"/></td>
	<td class='columnheadercenter' nowrap colspan="2"><fmt:message key="eBL.DischargeBillDocType.label" bundle="${bl_labels}"/>/<fmt:message key="Common.Num.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="eBL.PAT_OS_AMT.label" bundle="${bl_labels}"/></td>		
<%
}	
		for( int j=1; j<start; i++,j++ )
			rst.next();
		
		while ( rst.next() && i<=end  )
		{	
			docType_docNum = "";  //V230313
			patientId = checkForNull(rst.getString("PATIENT_ID"));	
			patientName = checkForNull(rst.getString("PATIENT_NAME"));
			episodeId = checkForNull(rst.getString("EPISODE_ID"));
			episodeType = checkForNull(rst.getString("Episode_Type"));
			admissionDt = checkForNull(rst.getString("Admission_dt_dec"));
			discAdviceAtTo = checkForNull(rst.getString("Discharge_dt_dec"));
			docType = checkForNull(rst.getString("Doc_Type"));
			docNumber = checkForNull(rst.getString("Doc_Number"));
			patOutsAmt = checkForNull(rst.getString("PAT_OUTST_AMT"));
			encounterId = checkForNull(rst.getString("ENCOUNTER_ID"));
			curAcctSeqNo = checkForNull(rst.getString("CUR_ACCT_SEQ_NO"));
			curWardCode = checkForNull(rst.getString("CUR_WARD_CODE"));
			curBedClassCode = checkForNull(rst.getString("CUR_BED_CLASS_CODE"));
			curRoomNum = checkForNull(rst.getString("CUR_ROOM_NUM"));
			curBedNum = checkForNull(rst.getString("CUR_BED_NUM"));
			curPhysicianId = checkForNull(rst.getString("CUR_PHYSICIAN_ID"));  
			if(!docType.equals(""))
				docType_docNum = docType+"/"+docNumber;
%>
	<tr>
			<td class="gridData" nowrap><input type="radio" id="bl_disc_clear_count_<%=i%>" name="bl_disc_clear_count" onclick="checkAuthorization('<%=patientId%>','<%=docNumber%>','<%=patOutsAmt%>','<%=i%>')" value=""></td>
			<td class="gridData" nowrap><%=patientId%></td>
			<td class="gridData" nowrap><%=patientName%></td>
			<td class="gridData" nowrap><%=episodeId%></td>
			<td class="gridData" nowrap><%=episodeType%></td>
			<td class="gridData" nowrap><%=admissionDt%></td>
			<td class="gridData" nowrap><%=discAdviceAtTo%></td>
			<td class="gridData" nowrap colspan="2"><%=docType_docNum%></td>
			<td class="gridData" nowrap><%=patOutsAmt%></td>
				
			<input type="hidden" name="patientId_<%=i%>" id="patientId_<%=i%>" value="<%=patientId%>"/>
			<input type="hidden" name="episodeType_<%=i%>" id="episodeType_<%=i%>" value="<%=episodeType%>"/>
			<input type="hidden" name="episodeId_<%=i%>"  id="episodeId_<%=i%>" value="<%=episodeId%>"/>
			<input type="hidden" name="encounterId_<%=i%>" id="encounterId_<%=i%>" value="<%=encounterId%>"/>
			<input type="hidden" name="acctSeqNo_<%=i%>" id="acctSeqNo_<%=i%>" value="<%=curAcctSeqNo%>"/>
			<input type="hidden" name="admissionDt_<%=i%>"  id="admissionDt_<%=i%>" value="<%=admissionDt%>"/>
			<input type="hidden" name="curWardCode_<%=i%>" id="curWardCode_<%=i%>" value="<%=curWardCode%>"/>
			<input type="hidden" name="curBedClassCode_<%=i%>" id="curBedClassCode_<%=i%>" value="<%=curBedClassCode%>"/>
			<input type="hidden" name="curRoomNum_<%=i%>" id="curRoomNum_<%=i%>" value="<%=curRoomNum%>"/>
			<input type="hidden" name="curBedNum_<%=i%>" id="curBedNum_<%=i%>" value="<%=curBedNum%>"/>
			<input type="hidden" name="curPhysicianId_<%=i%>" id="curPhysicianId_<%=i%>" value="<%=curPhysicianId%>"/>
			<input type="hidden" name="docType_<%=i%>" id="docType_<%=i%>" value="<%=docType%>"/>
			<input type="hidden" name="docNumber_<%=i%>" id="docNumber_<%=i%>" value="<%=docNumber%>"/>
			<input type="hidden" name="discAdviceAtTo_<%=i%>" id="discAdviceAtTo_<%=i%>" value="<%=discAdviceAtTo%>"/>
			<input type="hidden" name="patOutsAmt_<%=i%>" id="patOutsAmt_<%=i%>" value="<%=patOutsAmt%>"/>
	
	</tr>	
<%		
			i++;
		}
%>	

	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>"/>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type="hidden" name="row_count" id="row_count" id="row_count" value="<%=row_count%>"/>
	<input type="hidden" name="reasonCode" id="reasonCode" id="reasonCode" value="<%=reasonCode%>"/>
	<input type="hidden" name="userId" id="userId" id="userId" value="<%=userId%>"/>
	<input type="hidden" name="authRemarks" id="authRemarks" id="authRemarks" value="<%=authRemarks%>"/>
	 <input type='hidden' name='valid_user_rec_found_YN' id='valid_user_rec_found_YN' id='valid_user_rec_found_YN' value="<%=valid_user_rec_found_YN%>"/>
	<input type="hidden" name="is_record_selected" id="is_record_selected" id='is_record_selected' value="<%=is_record_selected%>"/>
	
	<input type="hidden" name="patientId" id="patientId" id="patientId" value="<%=patient_Id%>"/>
	<input type="hidden" name="nursingUnitCode" id="nursingUnitCode" id="nursingUnitCode" value="<%=nursing_Unit_Code%>"/>
	<input type="hidden" name="episodeId" id="episodeId" id="episodeId" value="<%=episode_Id%>"/>
	<input type="hidden" name="discAdviceDtFrom" id="discAdviceDtFrom" id="discAdviceDtFrom" value="<%=disc_Advice_Dt_From%>"/>
	<input type="hidden" name="discAdviceAtTo" id="discAdviceAtTo" id="discAdviceAtTo" value="<%=disc_Advice_Dt_To%>"/>
	<input type="hidden" name="option_val" id="option_val" id="option_val" value="<%=option_val%>"/>
	<input type="hidden" name="from_next" id="from_next" id="from" value="<%=start+15%>"/>  <!-- V230313 -->
	<input type="hidden" name="to_next" id="to_next" id="to" value="<%=end+15%>"/>  <!-- V230313 -->
	<input type="hidden" name="from_prev" id="from_prev" id="from" value="<%=start-15%>"/>  <!-- V230313 -->
	<input type="hidden" name="to_prev" id="to_prev" id="to" value="<%=end-15%>"/>  <!-- V230313 -->
	<input type="hidden" name="total_rec" id="total_rec" id="total_rec" value="<%=maxRecord%>"/>
</table>		
<%
	}catch(Exception e){
		out.println("Exception in BLDischClearGenerateResult.jsp: "+e);
		System.err.println("Exception in BLDischClearGenerateResult.jsp: "+e);
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	}
%>
</form>
</BODY>
</HTML>

