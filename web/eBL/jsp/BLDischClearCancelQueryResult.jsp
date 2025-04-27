<!DOCTYPE html>
<%
/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1		V230313         42420    	 PMG2022-COMN-CRF-0009-US002	Namrata Charate
----------------------------------------------------------------------------------------------
*/
%>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/BLDischClearCancel.js"></script>
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


		try{
			
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
			String episodeType = "", admissionDt = "", docNumber = "", docType = "", patOutsAmt = "" , authById = "" , curAcctSeqNo = "", curWardCode="", curBedClassCode = "", curRoomNum = "", curBedNum = "", curPhysicianId = "", reasonCode = "", userId = "", 
			authRemarks = "", billDocTypeCode = "", billDocNum = "", docType_docNum = "";
			
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
			
		try{
			if(start == 1){
				
			sql = "select count(*) as total from BL_ENC_DISCHARGE_CLEARANCE where "+
					"operating_facility_id= ? "+
					"and nvl(CANCELLED_YN,'N')='N' "+
					"AND PATIENT_ID=NVL( ? ,PATIENT_ID) "+
					"AND EPISODE_ID=NVL( ? ,EPISODE_ID) "+
					"AND WARD_CODE=NVL( ? ,WARD_CODE) "+
					"and (( ? ='Y' and DISC_BILL_DOC_NUMBER is not null) "+
					"or ( ? ='N' and DISC_BILL_DOC_NUMBER is null) or ? ='B' ) "+
					"AND trunc(doc_date) BETWEEN NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
					" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
					" ,'DD-MON-YYYY HH24:MI:SS'))  "+ 
					"and (operating_facility_id,episode_type,episode_id)  in "+
					"(select operating_facility_id,episode_type,episode_id from bl_episode_fin_dtls "+
				    "where operating_facility_id= ?  and nvl(discharged_yn,'N')='Y' "+
					"or nvl(discharged_yn,'N')='N' ) order by doc_date desc";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,facilityId);
				pstmt.setString(2,patient_Id);
				pstmt.setString(3,episode_Id);
				pstmt.setString(4,nursing_Unit_Code);
				pstmt.setString(5,option_val);
				pstmt.setString(6,option_val);
				pstmt.setString(7,option_val);
				pstmt.setString(8,disc_Advice_Dt_From);
				pstmt.setString(9,disc_Advice_Dt_To);
				pstmt.setString(10,facilityId);
				
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
		
		try{
			 sql = "select a.PATIENT_ID PATIENT_ID, a.EPISODE_ID EPISODE_ID, a.EPISODE_TYPE EPISODE_TYPE, "+
					"to_char(a.ADMISSION_DATE,'dd-MM-yyyy HH24:mi:ss') ADMISSION_DATE, "+
					"to_char(a.doc_date,'dd-MM-yyyy HH24:mi:ss') doc_date_time, "+
			 		"a.doc_type_code doc_type_code,  a.doc_num doc_number, "+
		            " a.CASH_BILL_OUTST_AMT CASH_BILL_OUTST_AMT, a.AUTH_BY_ID AUTH_BY_ID, "+
			 		" nvl(DISC_BILL_DOC_TYPE_CODE, '') DISC_BILL_DOC_TYPE_CODE, "+
		            " nvl(DISC_BILL_DOC_NUMBER,'') DISC_BILL_DOC_NUMBER,  "+
					" ( select decode( ? ,'en',short_name,SHORT_NAME_LOC_LANG) "+
					" FROM MP_PATIENT_MAST "+
					" WHERE PATIENT_ID=NVL( ? ,a.PATIENT_ID) "+
					" ) PATIENT_NAME "+
					"from BL_ENC_DISCHARGE_CLEARANCE a where "+
					"operating_facility_id= ? "+
					"and nvl(CANCELLED_YN,'N')='N' "+
					"AND PATIENT_ID=NVL( ? ,PATIENT_ID) "+
					"AND EPISODE_ID=NVL( ? ,EPISODE_ID) "+
					"AND WARD_CODE=NVL( ? ,WARD_CODE) "+
					"and (( ? ='Y' and DISC_BILL_DOC_NUMBER is not null) "+
					"or ( ? ='N' and DISC_BILL_DOC_NUMBER is null) or ? ='B' ) "+
					"AND trunc(a.doc_date) BETWEEN NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
					" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
					" ,'DD-MON-YYYY HH24:MI:SS'))   "+ 
					"and (operating_facility_id,episode_type,episode_id)  in "+
					"(select operating_facility_id,episode_type,episode_id from bl_episode_fin_dtls "+
				    "where operating_facility_id= ?  and nvl(discharged_yn,'N')='Y' "+
					"or nvl(discharged_yn,'N')='N' ) order by a.doc_date desc";
				
			pstmt = con.prepareStatement(sql);
			System.err.println("Query is: "+sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_Id);
			pstmt.setString(3,facilityId);
			pstmt.setString(4,patient_Id);
			pstmt.setString(5,episode_Id);
			pstmt.setString(6,nursing_Unit_Code);
			pstmt.setString(7,option_val);
			pstmt.setString(8,option_val);
			pstmt.setString(9,option_val);
			pstmt.setString(10,disc_Advice_Dt_From);
			pstmt.setString(11,disc_Advice_Dt_To);
			pstmt.setString(12,facilityId);
			
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

if ( !( (start+15) > maxRecord ) )   //V230313
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
	<td class='columnheadercenter' nowrap><fmt:message key="eBL.DischClearDate.label" bundle="${bl_labels}"/></td>
	<td class='columnheadercenter' nowrap colspan="2"><fmt:message key="eBL.DischClear.label" bundle="${bl_labels}"/>/<fmt:message key="Common.Num.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="eBL.PatOutsAmt.label" bundle="${bl_labels}"/></td>
	<td class='columnheadercenter' nowrap><fmt:message key="eBL.AuthBy.label" bundle="${bl_labels}"/></td>
	<td class='columnheadercenter' nowrap></td>
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
		episodeType = checkForNull(rst.getString("EPISODE_TYPE"));
		admissionDt = checkForNull(rst.getString("ADMISSION_DATE"));
		discAdviceAtTo = checkForNull(rst.getString("doc_date_time"));
		docType = checkForNull(rst.getString("doc_type_code"));
		docNumber = checkForNull(rst.getString("doc_number"));
		patOutsAmt = checkForNull(rst.getString("CASH_BILL_OUTST_AMT"));
		authById = checkForNull(rst.getString("AUTH_BY_ID"));
		billDocTypeCode = rst.getString("DISC_BILL_DOC_TYPE_CODE");
		billDocNum = rst.getString("DISC_BILL_DOC_NUMBER");
		
		if(!docType.equals(""))
			docType_docNum = docType+"/"+docNumber;	
%>
<tr>
	<td class="gridData" nowrap><input type="radio" id="bl_disc_clear_count_<%=i%>" name="bl_disc_clear_count" onclick="checkAuthorization('<%=patientId%>','<%=episodeId%>','<%=episodeType%>','<%=i%>')" value=""></td>
	<td class="gridData" nowrap><%=patientId%></td>
	<td class="gridData" nowrap><%=patientName%></td>
	<td class="gridData" nowrap><%=episodeId%></td>
	<td class="gridData" nowrap><%=episodeType%></td>
	<td class="gridData" nowrap><%=admissionDt%></td>
	<td class="gridData" nowrap><%=discAdviceAtTo%></td>
	<td class="gridData" nowrap colspan="2"><%=docType_docNum%></td>
	<td class="gridData" nowrap><%=patOutsAmt%></td>
	<td class="gridData" nowrap><%=authById%></td>
	
	<td><img src="../../eCommon/images/print2.gif" style="width:30px;height:15px;" onClick ='cancelClearanceReprint("<%=docType%>","<%=docNumber%>","<%=episodeId%>","<%=episodeType%>","<%=billDocTypeCode%>","<%=billDocNum%>");'></td>
	
	
	<input type="hidden" name="patientId_<%=i%>" id="patientId_<%=i%>" value="<%=patientId%>"/>
	<input type="hidden" name="episodeType_<%=i%>" id="episodeType_<%=i%>" value="<%=episodeType%>"/>
	<input type="hidden" name="episodeId_<%=i%>"  id="episodeId_<%=i%>" value="<%=episodeId%>"/>
	<input type="hidden" name="docType_<%=i%>" id="docType_<%=i%>" value="<%=docType%>"/>
	<input type="hidden" name="docNumber_<%=i%>" id="docNumber_<%=i%>" value="<%=docNumber%>"/>
	
			
<%		
	i++;
	}
%>	
</tr>
</table>
	
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
	<input type="hidden" name="from_next" id="from_next" id="from" value="<%=start+15%>"/> <!-- V230313 -->
	<input type="hidden" name="to_next" id="to_next" id="to" value="<%=end+15%>"/> <!-- V230313 -->
	<input type="hidden" name="from_prev" id="from_prev" id="from" value="<%=start-15%>"/>  <!-- V230313 -->
	<input type="hidden" name="to_prev" id="to_prev" id="to" value="<%=end-15%>"/>  <!-- V230313 -->
	<input type="hidden" name="total_rec" id="total_rec" id="total_rec" value="<%=maxRecord%>"/>
		
<%
		}catch(Exception e){
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

