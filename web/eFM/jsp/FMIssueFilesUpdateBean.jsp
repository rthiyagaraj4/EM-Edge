<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.io.*, java.text.*,webbeans.eCommon.*,webbeans.eFM.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>
<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<% 
	 request.setCharacterEncoding("UTF-8");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<body class='message' onKeyDown = 'lockKey()'>
	<form name="updateBean" id="updateBean">
<%
	try
	{
		String login_facility_id	= (String) session.getValue("facility_id");

		String ManualReq			= request.getParameter("ManualReq"); 
		if(ManualReq == null || ManualReq.equals("null")) ManualReq = "N";
        
		if(ManualReq.equals("N"))
		{
			String count_val = request.getParameter("count");

			if(count_val==null) count_val		= "0";
			if(count_val.equals("")) count_val	= "0";

			int count = Integer.parseInt(count_val);
			

			//String ReqOn			= request.getParameter("Req_on"); 
		//	String Reqno			= ""; 
			//String Reqfacid			= request.getParameter("Req_fac_id");
				//String Reqfacname		= request.getParameter("Req_fac_name");	

	//commented by Shanthi on 17-02-2012 for the incident 27189
	
//			String Reqlocnidentity	= request.getParameter("Req_locn_identity");
			String Reqlocnismrlocn	= request.getParameter("Req_locn_mrlocn_yn");	
			
			
			String Narrationcode	= request.getParameter("Narration_code");
			//String Requesting_From  = request.getParameter("Reqfslocnid");	
				String NoOfDays			= request.getParameter("No_Of_Days"); 
			String Issueuserid		= request.getParameter("Issue_user_id");

			if(Narrationcode == null || Narrationcode.equals("null")) Narrationcode = "";
			//if(Requesting_From == null || Requesting_From.equals("null")) Requesting_From = "";
			if(NoOfDays == null) NoOfDays		= "0"; 
			if(NoOfDays.equals("")) NoOfDays	= "0";

			boolean file_exist = false;
			boolean file_found = false;

			String From = "";
				for(int ind = 1;ind <=count;ind++)
			{

				String chk			= request.getParameter("select"+ind);
				String fileno		= request.getParameter("fileno"+ind);
				String file_type	= request.getParameter("file_type"+ind);
				String volume_no	= request.getParameter("volume_no"+ind);
				String file_typedesc	= request.getParameter("file_typedesc"+ind);

				String Reqno	= request.getParameter("Req_no"+ind);
				String Reqlocncode		= request.getParameter("Req_locn_code"+ind);
				String Reqby			= request.getParameter("Req_by"+ind);
				String Reqbyname		= request.getParameter("Req_by_name"+ind);
				String Reqfacid		= request.getParameter("Req_fac_id"+ind);
				String Reqfacname		= request.getParameter("Req_fac_name"+ind);
				String rem_recnum		= request.getParameter("rem_recnum_"+ind);
    			if((file_type == null) || (file_type.equals("null"))) file_type = "";
				if((volume_no == null) || (volume_no.equals("null"))) volume_no = "";
				if((file_typedesc == null) || (file_typedesc.equals("null"))) file_typedesc = "";
			
				String patient	= request.getParameter("patient"+ind);
				String pline	= request.getParameter("pline"+ind);		

			/*	InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream( pline.getBytes()), "UTF-8" );

				pline = (new BufferedReader(reader)).readLine() ;
	            reader.close();*/

		//		String filestatus	= request.getParameter("filestatus"+ind); 
				String currstrlocn	= request.getParameter("currlocn"+ind);
				String currstrdesc	= request.getParameter("currlocndesc"+ind);
				String currlocniden = request.getParameter("currlocniden"+ind);
				String currmrlocnyn = request.getParameter("currmrlocnyn"+ind);
				String currfacility = request.getParameter("currfacility"+ind);
				String remarks		= request.getParameter("txtComm"+ind);
					remarks=rem_recnum;
				String req_remarks	= request.getParameter("ReqComm"+ind);
				String mlc_check	= request.getParameter("mlc_check"+ind);
				String Requested_on	= request.getParameter("Requested_on"+ind);
				String Requesting_From	= request.getParameter("Reqfslocnid"+ind);

				//Added by Shanthi on 17-2-2012 for the incident 27189
				String Reqlocnidentity	= request.getParameter("Req_locn_identity"+ind);


				if(chk == null) chk = "N";
				if(chk == null || chk.equals("null"))
					chk = "N";				
               if(chk.equals("Y"))
				{
					file_exist = FMIssueFilesCart.FileNoExist(Reqno,fileno,volume_no);
					
				}
				
				
				if(chk.equals("Y"))
				{
					file_exist = FMIssueFilesCart.FileNoExist(Reqno,fileno,volume_no);
					file_found = FMIssueFilesCart.CurrFacilityFileNoExist(currfacility,fileno, volume_no);
				}


				if((!file_exist) && (!file_found) && (chk.equals("Y")))
				{
					if(login_facility_id.equals(Reqfacid)) From = "S";
					else From = "D";
					
					webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();

					try
					{					
						fissuebean.setIndex_Value(String.valueOf(ind));
						fissuebean.setRequest_From(From);
						fissuebean.setFile_No(fileno);
						fissuebean.setFile_Type(file_type);
						fissuebean.setVolume_No(volume_no);
						fissuebean.setPatient_Id(patient);
						fissuebean.setPatient_Line(pline);
						fissuebean.setRec_Locn_Code(Reqlocncode);
						fissuebean.setRec_Locn_Identity(Reqlocnidentity);
						fissuebean.setRec_Name(Reqby);
						fissuebean.setRec_Name_Desc(Reqbyname);
						fissuebean.setNarration_Code(Narrationcode);
						fissuebean.setRemarks(remarks);
						fissuebean.setReq_Facility_Id(Reqfacid);
						fissuebean.setReq_Facility_Name(Reqfacname);
						fissuebean.setReq_No(Reqno);
						fissuebean.setIss_Locn_Code(currstrlocn);   
						fissuebean.setIss_Locn_Desc(currstrdesc);
						fissuebean.setIss_Locn_Identity(currlocniden);
						fissuebean.setIss_MR_Location(currmrlocnyn); 	
						fissuebean.setRec_MR_Location(Reqlocnismrlocn);
						fissuebean.setRet_Date_Time(NoOfDays);				
						fissuebean.setRequest_Date_Time(Requested_on);
						fissuebean.setCurr_Facility_Id(currfacility);
						fissuebean.setSrc_Facility_Id(login_facility_id);
						fissuebean.setSrc_User_Id(Issueuserid);
						fissuebean.setReq_Remarks(req_remarks);
						fissuebean.setMLC_Check(mlc_check);
						fissuebean.setFile_Typedesc(file_typedesc);
						fissuebean.setRequesting_From(Requesting_From);

						FMIssueFilesCart.addIssuestoCart(fissuebean);

					}catch(Exception e1){out.println("Exception at inner level : " + e1.toString());}
				}
				%>
				<script>
					parent.frames[1].document.forms[0].issue_select.value = "Y";
				</script>
				<%
			}
		}
		else if(ManualReq.equals("Y"))
		{
			String ReqOn			= request.getParameter("Req_on"); 
			String Reqfacid			= request.getParameter("Req_fac_id");
			String Reqfacname		= request.getParameter("Req_fac_name");	
			String Reqlocncode		= request.getParameter("Req_locn_code");
			String Reqby			= request.getParameter("Req_by");
			String Reqbyname		= request.getParameter("Req_by_name");
			String Narrationcode	= request.getParameter("Narration_code");
			 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			String Borrowing_Reason = request.getParameter("Borrowing_Reason");
			/* end ML-MMOH-CRF-0393-IN057159  */
			String Currfacilityid	= request.getParameter("Curr_facility_id");
			String currstrlocn		= request.getParameter("Curr_locn_code");
			String currstrdesc		= request.getParameter("Curr_locn_desc");
			String currlocniden		= request.getParameter("Curr_locn_iden");
			String currmrlocnyn		= request.getParameter("Curr_locn_mr_locn");
			String Reqlocnidentity	= request.getParameter("Req_locn_iden");
			String Reqlocnismrlocn	= request.getParameter("Req_locn_mr_locn");
			String NoOfDays			= request.getParameter("No_Of_Days");
			String Issueuserid		= request.getParameter("Issue_user_id");
			String req_mode			= request.getParameter("Req_req_mode");
			String returning_code	= request.getParameter("returning_code");
			String third_party_name = request.getParameter("third_party_name");
			if(returning_code == null) returning_code   = "";
			if(third_party_name==null) third_party_name = "";
			if(Narrationcode == null || Narrationcode.equals("null")) Narrationcode = "";
			if(req_mode == null || req_mode.equals("null")) req_mode = "";
	
			boolean file_exist = false;
	
			String From = "";

			String fileno					= request.getParameter("fileno");
						
			String file_type				= request.getParameter("patient_file_type");
			String patient_file_type_desc	= request.getParameter("patient_file_type_desc");
			String volume_no				= request.getParameter("volume_no");

			if((file_type==null) || (file_type.equals("null"))) file_type = "";
			if((patient_file_type_desc==null) || (patient_file_type_desc.equals("null")))  					patient_file_type_desc = "";
			else patient_file_type_desc =patient_file_type_desc + " / ";
			if ((volume_no==null) || (volume_no.equals("null"))) volume_no = "";

			String patient	= request.getParameter("patientid");
			String pline	= request.getParameter("Pat_line");

			InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( pline.getBytes()), "windows-1256" );

            pline = (new BufferedReader(reader)).readLine() ;
            reader.close();

		//	String filestatus	= request.getParameter("filestat"); 
			String remarks		= request.getParameter("remarks");

			
			   
		%>
		<script>
			/*For Manul Request form is in 3rd frame. For Normal request Form is in 4th frame*/
				var frameRef = '';
				if ('<%=ManualReq%>'=='Y')
					frameRef = parent.frames[2];
				else
					frameRef = parent.frames[3];
		</script>
		<%
			file_exist = FMIssueFilesCart.CurrFacilityFileNoExist(Currfacilityid,fileno, volume_no);

			if(!file_exist)
			{
				if(login_facility_id.equals(Reqfacid)) From = "MS";
				else From = "MD";
				webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
				fissuebean.setRequest_From(From);
				fissuebean.setFile_No(fileno);
				fissuebean.setFile_Type(file_type);
				fissuebean.setVolume_No(volume_no);
				fissuebean.setThird_Party_Name(third_party_name);
				fissuebean.setRequesting_From(returning_code);
				fissuebean.setPatient_Id(patient);
				fissuebean.setPatient_Line(pline);
				fissuebean.setRec_Locn_Code(Reqlocncode);
				fissuebean.setRec_Locn_Identity(Reqlocnidentity);
				fissuebean.setRec_Name(Reqby);
				fissuebean.setRec_Name_Desc(Reqbyname);
				fissuebean.setNarration_Code(Narrationcode);
				fissuebean.setReq_Facility_Id(Reqfacid);
				fissuebean.setReq_Facility_Name(Reqfacname);
				fissuebean.setIss_Locn_Code(currstrlocn);   
				fissuebean.setIss_Locn_Desc(currstrdesc);
				fissuebean.setIss_Locn_Identity(currlocniden);
				fissuebean.setIss_MR_Location(currmrlocnyn); 	
				fissuebean.setRec_MR_Location(Reqlocnismrlocn);
				fissuebean.setRemarks(remarks);
				fissuebean.setRet_Date_Time(NoOfDays);
				fissuebean.setRequest_Date_Time(ReqOn);
				fissuebean.setCurr_Facility_Id(Currfacilityid);
				fissuebean.setSrc_Facility_Id(login_facility_id);
				fissuebean.setSrc_User_Id(Issueuserid);
				fissuebean.setFile_Typedesc(patient_file_type_desc);

				fissuebean.setREQ_MODE_1(req_mode);
				/*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
				fissuebean.setBorrowing_Reason(Borrowing_Reason); 
					/* end ML-MMOH-CRF-0393-IN057159  */
				FMIssueFilesCart.addIssuestoCart(fissuebean);
				%>
				<script>
					parent.frames[1].document.forms[0].issue_select.value	= "Y";
					if (frameRef.document.forms[0].fileno != null)
						frameRef.document.forms[0].fileno.value = "";
					if (frameRef.document.forms[0].volume_no != null)
						frameRef.document.forms[0].volume_no.value	= "";

					if (frameRef.document.forms[0].file_type != null)
						frameRef.document.forms[0].file_type.value = "";
					 frameRef.document.forms[0].patientid.value		= "";
					 frameRef.document.forms[0].patientid.onblur();
					frameRef.document.forms[0].currfilelocn.value	= "";
					frameRef.document.forms[0].filestat.value		= "";
					frameRef.document.forms[0].remarks.value		= "";
				</script>
				<%
			}
			else
			{
				//out.println("APP-FM0047 File is Selected for Issue");
				%>
				<script>
					alert(getMessage("FILE_SEL_FOR_ISSUE","FM"));
					frameRef.document.forms[0].patientid.value		= "";
					frameRef.document.forms[0].patientid.onblur();
					frameRef.document.forms[0].currfilelocn.value	= "";
					frameRef.document.forms[0].filestat.value		= "";
					frameRef.document.forms[0].remarks.value		= "";
				</script>
				<%
			}
		}
		session.putValue("FMIssueFilesCartBean",FMIssueFilesCart); // Changes Modified against Incident Number 28306 By Saanthaakumar Dated on 18-06-2012
	}catch(Exception e){out.println("Exception at final level : " + e.toString());}
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
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

