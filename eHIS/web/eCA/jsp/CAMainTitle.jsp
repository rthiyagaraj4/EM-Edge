
<%
/*
--------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
?            	100            		?           								created
10/14/2011	 	IN27088			Dinesh T										Changed for displaying the quick link onload
																				of that particular function
05/12/2011	  	IN29822			MenakaV	 										For quick link & filter when Ist time 
																				resposibility is assigned its taking all links. After logging it shows only 2 responsibilty.
07/09/2012	  	IN32540			Nijitha S										IE 9 is creating an issue in the CA 	
																				module 										 
28/01/2013		IN036367		Dinesh T										Global level filter is changed to filter 
																				the data							 
06/08/2013		IN036733		Nijitha											Bru-HIMS-CRF-328 
15/10/2013		IN044083		Ramesh G										Genogram - Click on index patient - 
																				The Clinical Event History window opens - Click on 'Close Chart' icon	
26/08/2015		IN0052635		Vijayakumar K	26/08/2015		Ramesh Goli		PMG2014-CRF-0020 [IN:052635]
28/08/2015		IN057229		Vijayakumar K	28/08/2015		Ramesh Goli		Regression-EM-Alpha-Unable to access 
01/08/2015		IN057272		Vijayakumar K	01/08/2015						Practitioner Desktop/Patient Chart->
																				Click on Home Page icon->Expect first 4 icons the other icons disappear in Practitioner Desktop
09/10/2015		IN057446		Vijayakumar K									PMG2014-CRF-0020.1 [IN:057446]
29/12/2015	ICON_COUNT_ISSUE	Vijayakumar K	29/12/2015		Ramesh Goli		Icon count improper
30/12/2015		IN058755		Vijayakumar K	30/12/2015		Ramesh Goli			Regression-CRF-CA-PMG2014-CRF-0020.1/01- 
																					System does not respond when "Home" Button is pressed in CA-Desk Top. [IN:058755] 
21/12/2015      IN058149    Mukesh M											When opening patient chart from manage patient queue function, clock icon (clinical history) and 
																				clinical calculator is missing.
18/03/2016	 	IN059659		Karthi												Webpage cannot be found error appears when clicking list of option from history menu.		
20/01/2017		IN061898		Raja S			23/01/2017		Ramesh G		ML-MMOH-CRF-0550
15/03/2017		IN051294		Krishna Gowtham J									MO-CRF-20087
27/07/2017		IN061891		Raja S			27/07/2017		Ramesh G		ML-MMOH-CRF-0543
28/11/2017		IN065889		Raja S			28/11/2017		Ramesh G		CA-ML-MMOH-CRF-0824/03-Record External Clinical Note
12/02/2018		IN066055		Raja S			12/02/2018		Ramesh 			ML-MMOH-CRF-0891.2
07/02/2019		IN069654	   sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
03/02/2022		IN27710	       Suji Keerthi G 	03/02/2022		Ramesh G			GHL-CRF-0658
09/02/2022		IN28627	       Suji Keerthi G 	09/02/2022		Ramesh G			CA-GHL-CRF-0658/01-Quick Link
11/02/2022		IN28689	       Suji Keerthi G 	11/02/2022		Ramesh G			CA-GHL-CRF-0658/02-Quick Link Parameter in External URL
02/06/2022		31884			Ramesh Goli			02/06/2022	Ramesh G 	MMS=DM-CRF-0208
21/05/2023		44162			Ramesh Goli			21/02/2023	Ramesh G	ML-BRU-SCF-2224
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,,java.net.*,java.security.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<script>var pat_info = new Array();
var ph_info = new Array(); //IN066055
var screensize = screen.width; //IN057272
</script> 
<script>
/*IN32540 IE 9 fix starts  */
function SelectedPatient1(patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind)
{
	
	
	return new pat(patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind); 

	
	   
}

var pat = function (patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind){
	  this.patient_id				=	patient_id
	   this.episode_id				=   episode_id
	   this.visit_id				=   visit_id
	   this.episode_type			=   episode_type
	   this.location_code			=   location_code
	   this.location_type			=   location_type
	   this.option_id				=   option_id
	   this.pat_oth_dtls			=	pat_oth_dtls
	   this.window_obj				=   window_obj
	   this.relationship_id			=	relationship_id
	   this.patient_security_level	=	patient_security_level
	   this.patient_protection_ind	=	patient_protection_ind
	   this.winname					=	patient_id+episode_id+visit_id;
	   if (window_obj){
			window_obj.focus();   
	   }
}
/*32540 IE 9 fix Ends  */
</script>
<script>
  /*function putSometexttoClipBoard(
  {
	  var text = parent.window.clipboardData.getData("Text");
	  
	 // var text = navigator.clipboardData.getData("Text");
 
	  if(text == "" || text == null)
	  {
		if(document.getElementById("clipTxtBtn")!=null)
		{
			var clipBoardVal=document.getElementById("clipTxtBtn").createTextRange();
			clipBoardVal.select();
			clipBoardVal.execCommand("copy","","");
			clipBoardVal.execCommand("Unselect","","");
		}
	  }
  }*/
  function putSometexttoClipBoard() {
    // Check if Clipboard API is supported
    if (navigator.clipboard) {
        // Trigger clipboard access in response to a user action, such as a button click
        document.getElementById("clipTxtBtn").addEventListener('click', function() {
            navigator.clipboard.readText().then(function(text) {
                if (!text) {
                    let clipTxtBtn = document.getElementById("clipTxtBtn");
                    if (clipTxtBtn) {
                        // Create a temporary textarea to copy text
                        let clipBoardVal = document.createElement('textarea');
                        clipBoardVal.value = clipTxtBtn.value;  // Assuming it's the text you want to copy
                        document.body.appendChild(clipBoardVal);
                        clipBoardVal.select();
                        document.execCommand("copy");
                        document.body.removeChild(clipBoardVal);
                        console.log("Text copied to clipboard");
                    }
                } else {
                    console.log("Text already present in clipboard: " + text);
                }
            }).catch(function(err) {
                console.error('Failed to read from clipboard: ', err);
            });
        });
    } else {
        console.error('Clipboard API is not supported in this browser.');
    }
}


</script>
 <head>	
<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<STYLE TYPE="text/css">
	A.imageClass1 
	{
		width:30px;
		height:28px;
		margin-left:0;
		margin-right:0;
		margin-top:0;
		margin-bottom:0;
		padding-left:3px;
		padding-right:3px;
		padding-top:2px;
		padding-bottom:1px;
		border-top:0px;
	}
	A.imageClass2 
	{
		background-color:#FFFFFF;
		width:30px;
		height:28px;
		margin-left:0;
		margin-right:0;
		margin-top:0;
		margin-bottom:0;
		padding-left:2px;
		padding-right:2px;
		padding-top:2px;
		padding-bottom:1px;
		border-left:1px solid;
		border-right:1px solid;
		BORDER-COLOR: #75768B;
	}
	img
	{
		border:0;
	}

	TR.iconBarRow
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBG.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowBlue
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGBlue.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowLime
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGLime.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowOrange
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGOrange.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowViolet
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGViolet.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	IMG.imageClass
	{
		vertical-align: middle;
	}

</STYLE>
      <script src='../js/CAMenu.js' language='javascript'></script>
      <script src='../../eCommon/js/common.js' language='javascript'></script>
	  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	  <script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	  <script src='../../eCA/js/CAMainMenuLookup.js' language='javascript'></script>
	  <script src='../../eCA/js/CACalculator.js' language='javascript'></script>
	  <script src='../../eCA/js/SwitchLanguage.js' language='javascript'></script>
	  <script src='../../eCA/js/SwitchBetPatChart.js' language='javascript'></script><!--IN32540 IE 9 Fix -->
        <jsp:useBean id="keyGen" scope="page" class="eCA._ca_license_rights">
		</jsp:useBean>

        <%
			
			try
			{
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

			String locale					=	(String) p.getProperty("LOCALE");
			String  suspendInactivePatientYN ="N"; //31884
			String client_ip_address = p.getProperty("client_ip_address");//IN061891
			String addFavPatientIcon = "N";//IN061891
			String queryStringForChart		=	request.getQueryString() == null ? "" : request.getQueryString();		String executable_name = "";	
			String strSql					=	"";
			String patient_name				=	"";	
			StringBuffer strBuffPatientInfo = new StringBuffer();
			String productName = "";
			String versionNum = "";
			String respid= (String) session.getValue("responsibility_id");
			 if(respid == null) respid="";
			String lookup_window_name = request.getParameter("lookup_window_name")==null?"":request.getParameter("lookup_window_name");
			
			String function_display_name = request.getParameter("function_display_name")==null?"":request.getParameter("function_display_name");
			String window_name = request.getParameter("window_name")==null?"":request.getParameter("window_name");
			String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
			String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
			String strRelnYn		= request.getParameter("RelnYn")==null?"Y":request.getParameter("RelnYn");
			String Genotitle		= request.getParameter("Genotitle")==null?"N":(String)request.getParameter("Genotitle");
			if (from_service_yn.equals("") )
				from_service_yn="N";
			String accession_type = request.getParameter("accession_type")==null?"":request.getParameter("accession_type");
			//IN059659 - Start
			if("RL".equalsIgnoreCase(accession_type) || "RD".equalsIgnoreCase(accession_type)) {
				from_service_yn = "Y";
			} else {
				from_service_yn = "N";
			}
			//IN059659 - End
			String limit_function_id = request.getParameter("limit_function_id")==null?"":request.getParameter("limit_function_id");
			String chartTitle = request.getParameter("chartTitle")== null?"":request.getParameter("chartTitle");
            String name=(String)session.getValue("practitioner_name");
			String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
			String pract_type =(String) session.getValue("practitioner_type");
			String menu_Active = "N";

			String dektop_params="";
			String layout_value="";
			String desktod_id="";
			String dfltFunctionId="";			
			String cur_lang_id="";	
			String opt_lang_id="";	
			String nric_code = "";
			String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");//IN061891
			String login_user = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user");//IN061891
			String archivalYN = request.getParameter("archivalYN") == null ? "N" : request.getParameter("archivalYN"); //52176
			int langListSize=0;
			String age="",sex="",visit_type="",visittype_desc=""; //IN28627 //IN28689
			Connection con=null;

			/* Added By : Arvind
				  Date : 1/25/2010
				  CRF  : PMG20089-CRF-429
				  Discription : Below code added for "default select Filter criteria ". 
			 */
			PreparedStatement stmt=null; 
			ResultSet rst=null;
			Map<String,String> langList =null;
			try{
				langList = new HashMap<String,String>();		
				cur_lang_id = locale;
				String sqlStr="select LANGUAGE_ID,SHORT_NAME from SM_LANGUAGE WHERE EFF_STATUS='E' and LANGUAGE_ID != ?" ;
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement(sqlStr);
				stmt.setString(1,locale);
				rst = stmt.executeQuery();
				//int k=0;
				while(rst.next())
				{ 
					langList.put(rst.getString("LANGUAGE_ID"),rst.getString("SHORT_NAME"));
				/* if(k==0)
					cur_lang_id=rst.getString("LANGUAGE_ID"); */								
					opt_lang_id=rst.getString("LANGUAGE_ID");
					//k++;					
				}				
				 langListSize=langList.size();	
				if(rst != null) rst.close();
				if(stmt != null) stmt.close();

			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			/*
				End Here 
			*/

			try{				
				//desktod_id ="DFLT_CADT";
				//layout_value="H";
				//dfltFunctionId="REV_PROV_APPT";
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement("SELECT CA_GET_DESKTOP_DTL_FUN(?,?,?) DEKTOP_PARAMS FROM DUAL");
				stmt.setString(1,pract_type);
				stmt.setString(2,practitioner_id);	
				stmt.setString(3,respid );
				rst=stmt.executeQuery();
				while(rst.next())
				{ 
					 dektop_params= rst.getString("DEKTOP_PARAMS");
				}
						if (dektop_params==null ) dektop_params="";
		
				StringTokenizer token=new StringTokenizer(dektop_params,"|");
				if(token.hasMoreTokens())
				{
						desktod_id = token.nextToken();
						layout_value = token.nextToken();
						dfltFunctionId = token.nextToken();
				}
				
				if(rst != null) rst.close();
				if(stmt != null) stmt.close();
				}	
				catch(Exception ex)
				{	
					ex.printStackTrace();
				}	

				finally 
				{
					
					if(con != null) ConnectionManager.returnConnection(con,request);
				}
				
			//31884 Start.
			
			/* 32902  try{
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement("SELECT SUSP_INACT_PAT_YN FROM CA_PARAM WHERE MODULE_ID='CA'");
				rst=stmt.executeQuery();
				while(rst.next())
				{ 
					 suspendInactivePatientYN= rst.getString("SUSP_INACT_PAT_YN");
				}
				if (suspendInactivePatientYN==null ) suspendInactivePatientYN="N";
		
				
				if(rst != null) rst.close();
				if(stmt != null) stmt.close();
			}catch(Exception ex){	
				ex.printStackTrace();
			}finally{
					
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			end 32902  */
			
			//31884 End 
            if(name == null) name="";
            String child_window = request.getParameter("child_window") ;			
            if(child_window == null) child_window="";

			if(!child_window.equals("Y") )
			{
				if(strRelnYn.equals("Y") )
				{
					HashMap tempPatMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					ArrayList tempPatList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());
					tempPatMap = new HashMap();
					tempPatList = new ArrayList();
					session.setAttribute("sessionMainMap"+session.getId(), new HashMap());
					session.setAttribute("sessionList"+session.getId(), new ArrayList());
				}
			 }

             String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
             String queryString = request.getQueryString()== null?"":request.getQueryString() ;
             String defmode = mode;
			 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			 String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
 			 String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
			
			 String wname = patient_id+episode_id+visit_id; 

			 String nursing_unit = request.getParameter("location_code")==null?"":request.getParameter("location_code");

			 String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
			 String facility_id      = (String)session.getValue( "facility_id" ) ;
			 PreparedStatement pstmt=null,pstmtMenu=null;
			 ResultSet rs = null,rsMenu=null;			
			 String menu_id="MED_DFLT",patientclass="",speciality_code="";
			 StringBuffer detl_sql = new StringBuffer();
			 String relationcode="";

			 //relationcode = (String)session.getValue("relationship_id");
			 relationcode = request.getParameter("relationship_id");
			 if(relationcode == null) relationcode = "";
			 
			 String facilityName = "";

			 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
			 {
				styleMap = "Blue";
			 }
			 else if(sStyle.equals("IeStyleLime.css"))
			 {
				styleMap = "Lime";
			 }
			 else if(sStyle.equals("IeStyleOrange.css"))
			 {
				styleMap = "Orange";
			 }
			 else if(sStyle.equals("IeStyleVoilet.css"))
			 {
				styleMap = "Violet";
			 }
			 else
			 {
				styleMap = "";
			 }
			
			if(window_name.equals("") || window_name ==null)
			{
				window_name = patient_id+episode_id+visit_id;
			}
			
			try
			{
				con = ConnectionManager.getConnection(request);
					
				//String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");//IN061891
				//String login_user = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user");/IN061891

				pstmt = con.prepareStatement("select product_id,VERSION_NO from sm_installation");
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					productName = rs.getString("product_id");
					versionNum = rs.getString("VERSION_NO");
				}

				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();

				if(pstmt != null)pstmt.close();
				
				pstmt = con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id= ? ");

				pstmt.setString(1, locale);
				pstmt.setString(2, facility_id);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					facilityName = rs.getString("FACILITY_NAME");
				}
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				
				if(!patient_id.equals(""))
				{
					strSql="select DECODE (?,'en', c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,sex,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age  FROM mp_patient c where c.patient_id=?"; //IN28627
					pstmt = con.prepareStatement(strSql);
					pstmt.setString(1, locale);
					pstmt.setString(2, patient_id);
					rs = pstmt.executeQuery();

					while(rs.next())
					{
						patient_name = rs.getString(1);
						sex = rs.getString(2); //IN28627
						//IN28689-Starts
						if(sex.equals("M"))
							sex="Male";
						else if(sex.equals("F"))
							sex="Female";
						else if(sex.equals("U"))
							sex="Unknown";
						//IN28689-Ends
						age = rs.getString(3); //IN28627
					}
					if(rs != null)rs.close();
					if(pstmt != null)pstmt.close();
					//IN061891 starts
					try{
						String perListSQL = "Select CA_PERS_PAT_LIST_FLAG(?,?,?,?) PERSONALISE_ICON_FLG from dual";
						pstmt = con.prepareStatement(perListSQL);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, patient_id);
						pstmt.setString(3, practitioner_id);
						pstmt.setString(4, episode_id);
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							addFavPatientIcon = rs.getString(1);
						}
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();
					
					}catch(Exception pl)
					{
						pl.printStackTrace();
					}
					//IN061891 ENds
				}

			
				%>
      <input type="hidden" id="facility_id"  name="facility_id" id="facility_id" value='<%=facility_id%>'><!-- 32902  --> 
      <input type="hidden" id="practitioner_id"  name="practitioner_id" id="practitioner_id" value='<%=practitioner_id%>'><!-- 32902  --> 
	<script>
		var patient_selected = false;
		var encounter_selected = false;
		var win_count = 0;
		var modal_win = new Array();
		var  firstwindow = top.window ;
		var opener_win;
		if('<%=child_window%>'=="Y" && "<%=from_service_yn%>" == "N")
		{
			////Bru-HIMS-CRF-016 for Genogram Start.[for Genogram]
			//firstwindow = top.opener.top
			if(top.opener!=null){
				firstwindow = top.opener.top
			}else{
				firstwindow = top
			}
			////Bru-HIMS-CRF-016 for Genogram End.[for Genogram]
			if(firstwindow.content != null)
				firstwindow = firstwindow.content
			if(firstwindow.CommonToolbar != null)
				firstwindow = firstwindow.CommonToolbar.firstwindow
			   top.opener = firstwindow
		}

		function displayFunctionName(name,id)
		{
			dispname.innerHTML = "<b>"+name+"&nbsp;&nbsp;&nbsp;"+"</b>";
			if(name=="Practitioner Home Page")
			{
				myTask.style.display='inline';
			}
			else
			{
				myTask.style.display='none';
			}
			
		//	if(name == "User Home - By Location" || name == "By Location")
		//Below code added by Channaveer B on  08/07/2010.
		//	if(id == "BY_LOCATION" || id=='FLOW_SHEET' || id=='MEDICAL_CERTIFICATE' || id=='PREVIOUS_NOTES'||id=='CLINICAL_NOTES'||id=='DISCHARGE_SUMMARY'||id=='REFERRAL_LETTER')	  //IN27088 //Commented for IN061898
			//if(id == "BY_LOCATION" || id=='FLOW_SHEET' || id=='MEDICAL_CERTIFICATE' || id=='PREVIOUS_NOTES'||id=='CLINICAL_NOTES'||id=='DISCHARGE_SUMMARY'||id=='REFERRAL_LETTER'||id=='CA_TASK_LIST')	  //Added task list for IN061898
			if(id == "BY_LOCATION" || id=='FLOW_SHEET' || id=='MEDICAL_CERTIFICATE' || id=='PREVIOUS_NOTES'||id=='CLINICAL_NOTES'||id=='DISCHARGE_SUMMARY'||id=='REFERRAL_LETTER'||id=='CA_TASK_LIST'||id=='FLOW_SHEET_NEW')	  //Added IN069654
			{
				var optlength = parent.CommonToolbar.filter.options.length;
				for (var i=0; i<optlength; i++)
				{
					parent.CommonToolbar.filter.options.remove("filter");
				}
				
             	filter_by.style='display';
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id="+id, false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);				
				//parent.CommonToolbar.filter.options.remove("filter");	 //IN27088
			}
			/*else
			{
				filter_by.style.display='none';
			}*/
			//ends here.
			//IN065889 starts
			if(name== "Record External Clinical Notes" || name == "Record Charts")
				filter_by.style.display='none';
			//IN065889 ends
		}

		function recordView(obj)
		{
			var qs = '<%=queryString%>'
			if(obj.id == 'R')
			{
				obj.id='V';
				obj.value = 'Chart Recording';
				if(qs.indexOf('mode=R')>=0)
					qs= qs.replace('mode=R','mode=V');
				top.content.Options1.location.href = 'CAMainOptions1.jsp?'+qs;	
			}
			else if('<%=defmode%>' == 'R')
			{
				obj.id='R';
				obj.value = 'Chart History';
				if(qs.indexOf('mode=V')>=0)
					qs= qs.replace('mode=V','mode=R');
				top.content.Options1.location.href = 'CAMainOptions1.jsp?'+qs;
			}
		}


		async function PatientSearch()
		{	
			var episodeid = '';
			var patientid=await PatientSearchWithDefaultGender_new('','');
	         	var facility_id=document.getElementById("facility_id").value;//32902
	         	var practitioner_id=document.getElementById("practitioner_id").value;//32902
			if(patientid !=null && patientid!='')
			{  //32902 start
				var xmlStr ="<root><SEARCH ";
				 xmlStr += " p_action=\"IS_PAT_RESTRICTED\"";
				 xmlStr += " facility_id=\""+ facility_id + "\" ";
				 xmlStr += " patientid=\""+ patientid + "\" ";
				 xmlStr += " practitioner_id=\""+ practitioner_id + "\" ";
				 xmlStr +=" /></root>";
				 var temp_jsp="../../eCA/jsp/CAGetAcccessRightPatientDtl.jsp";
				 var xmlDoc = "" ;
				 var xmlHttp = new XMLHttpRequest() ;
				 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				 xmlHttp.open("POST",temp_jsp,false);
				 xmlHttp.send(xmlDoc);
				 var responseText = xmlHttp.responseText;
				 var response = trimString(xmlHttp.responseText);
		         if(response == "Y"){
				 alert(getMessage("AC_RSTR_PAT_LMT_AUT","CA")); 
				 return;
				 } 
		         //32902  end
		         document.PatSearchFrm.patient_id.value=patientid;
			     document.PatSearchFrm.submit();
			}
		}

	    async function PatientSearchWithDefaultGender_new(defaultgender, enablegenderyn) 
		{
			window_styl='O';
			close_yn='Y';
			jsp_name='';
			win_top= '61';
			win_height= '37';
			win_width= '50';
			act_yn= 'N';
			register_button_yn = 'N';
			func_act='VIEW';
			srr='Y';

			window_styl = window_styl.toUpperCase();
			close_yn = close_yn.toUpperCase();
			act_yn = act_yn.toUpperCase();
			//if(confirm_yn)
			{
				var url     = "../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&default_gender="+defaultgender+"&enable_gender_yn="+enablegenderyn+"&suspend_inactive_patient_yn=<%=suspendInactivePatientYN%>";
				var dialogTop   = "10px";
				var dialogHeight    = "600px" ;
				var dialogWidth = "900px" ;
				var arguments   = "" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
				var returnval = await window.showModalDialog( url, arguments, features ) ;
				return returnval;
			}
		}
		
           
		

		function MM_preloadImages()
		{ 
			var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
			var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
			if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
		}

		function MM_swapImgRestore()
		{ 
			var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
		}

		function MM_findObj(n, d)
		{
			var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
			d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
			if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
			 for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
			if(!x && d.getElementById) x=d.getElementById(n); return x;
		}

		function MM_swapImage()
		{
			var i,j=0,x,a=MM_swapImage.arguments;
			document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
			if ((x=MM_findObj(a[i]))!=null)
			{
			  document.MM_sr[j++]=x; 
			  if(!x.oSrc) x.oSrc=x.src; 
			  x.src=a[i+2];
			}
		}
		
		function closeFunction(childyn,wname,flag)
		{			
			top.content.messageFrame.document.write("<html><body><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../../eCA/jsp/OpenChartWrapperIntermediate.jsp'><input type='hidden' name='patientID' id='patientID' value='<%=patient_id%>'><input type='hidden' name='episodeID' id='episodeID' value='<%=episode_id%>'><input type='hidden' name='child_window' id='child_window' value='<%=child_window%>'><input type='hidden' name='FromPatChart' id='FromPatChart' value=''><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='Close'><input type='hidden' name='windName' id='windName' value='"+wname+"'></form></body></html>");
			top.content.messageFrame.openChartWrapperIntermediateForm.submit();
		}

		function ShowPats(FromPatChart)
		{	
			
			<%-- top.content.messageFrame.document.write("<html><body><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../../eCA/jsp/OpenChartWrapperIntermediate.jsp?queryStringForChart=<%=queryStringForChart%>'><input type='hidden' name='patientID' id='patientID' value='<%=patient_id%>'><input type='hidden' name='episodeID' id='episodeID' value='<%=episode_id%>'><input type='hidden' name='FromPatChart' id='FromPatChart' value='"+FromPatChart+"'><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='Switch'><input type='hidden' name='RelnYn' id='RelnYn' value='<%=strRelnYn%>'></form></body></html>");
			top.content.messageFrame.openChartWrapperIntermediateForm.submit(); --%> /* IN32540 IE 9 Fix  */
			//IN32540
		 	showPatientInfo('<%=patient_id%>','<%=episode_id%>','<%=child_window%>','<%=visit_id%>','<%=queryStringForChart%>');  
		}
//IN061891 starts
		function addPersonalise(FromPatChart)
		{
			document.getElementById('ppatlist').style.display="none";
			document.PersonalisePatient.submit();
		}
//IN061891 Ends
	</script>
	
	<title>eHIS ver10.2 - [<%=name%> - <%=facilityName%>]</title>

</head>
<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown="lockKey()" OnMouseDown='CodeArrest()' 
<%
		if(! lookupFileName.equals(""))
		{
%>
			onunload='hideLookupButtonOnX()'
<%
		}
		else if(menu_Active.equals("N"))
		{
%>
			onunload ='closeAllLookups()' onfocus='alignLookupButtons()'
<%
		}
%>
		onload="MM_preloadImages('','../../eCA/images/MI_SwitchT1.gif','../../eCA/images/MI_CloseT1.gif');
<%
		if(patient_id.equals(""))
		{
%>
			putSometexttoClipBoard()
<%
		}
%>	
		">

<!-- <form name='CAMainTitleForm' id='CAMainTitleForm' >-->
<%

	String spacesForImage = "";
	String altText = "Close Chart";
	StringBuffer option_id = new StringBuffer();
	String v_query_string = "";
	String splty_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String reln_id	  = request.getParameter("relationship_id");
	if(reln_id == null) reln_id = "";
	StringBuffer sql = new StringBuffer();
	int Existance_Count = 0;
	
%>



<table width="100%" cellspacing='0' cellpadding='0' border='0'>
    <tr class='iconBarRow<%=styleMap%>'>
	<%
		System.out.println("---------archivalYN---------->"+archivalYN);
		System.out.println("---------limit_function_id---------->"+limit_function_id);
		//52176 Start.
		if(archivalYN.equals("Y")){
			%>			
			<td width='96%'>&nbsp;</td>
			<td width='1%'>&nbsp;</td>
			<td align='center' width='3%'>&nbsp;</td>
			<%
		}else if(!limit_function_id.equals("") && archivalYN.equals("S")){			
			%>
			
			<td width='96%'>
			&nbsp;
			</td>
			<td width='1%'>
			<img class='imageClass' id='seperator' src='../../eCA/images/MI_htStrip<%=styleMap%>.gif' alt=''></img></td>
			<td align='center' width='3%'>
				<a href="#" name='History' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' >
					<img onclick="loadOrUnloadLookup(this)" name='HideAndShowLookup' accesskey='L' title='History' src='../../eCA/images/mc_history.gif'></img>
				</a>
			</td>
			<%
		//52176 End.				
		}else if(lookupFileName.equals("") && limit_function_id.equals(""))
		{
	%>
			<td width='5%'>
				<input type='button' name='clipTxtBtn' id='clipTxtBtn' style='display:none' value='Clip Text'>
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr class='iconBarRow<%=styleMap%>'>
				<%
					if(menu_Active.equals("N") && lookupFileName.equals(""))
					{
				%>
						<td><a href="#" name='Menu' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img align='center' src='../../eCA/images/MI_Show.gif' name='ShowMenu' style='<%=limit_function_id.equals("")?"display":"display:none"%>' onclick="loadOrUnloadMenus(this)" accesskey='M' alt='<fmt:message key="eCA.ShowMenu.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.ShowMenu.label" bundle="${ca_labels}"/>'></img>
						<img align='center' src='../../eCA/images/MI_Hide.gif' name='HideMenu' style='display:none'  onclick="loadOrUnloadMenus(this)" accesskey='M' alt='<fmt:message key="eCA.HideMenu.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.HideMenu.label" bundle="${ca_labels}"/>'> </img></a></td>
						
				<%
					}
					if(lookupFileName.equals("") && from_service_yn.equals("N"))
					{
												
				%>		
							<td id="home" class='iconBarRow<%=styleMap%>'><a href="#" name='Home' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img onclick="loadHomePage('<%=patient_id%>','<%=dfltFunctionId%>' ,loadOrUnloadMenus(document.ShowMenu))" id='searchPatHome' src='../../eCA/images/MI_Home.gif' align='center' alt= '<fmt:message key="eCA.HOMEPAGE.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.HOMEPAGE.label" bundle="${ca_labels}"/>'></img></a></td>
				<%				
					}	
					if(patient_id.equals(""))
					{
				%>
						<td class='iconBarRow<%=styleMap%>'><a href="#" name='Patient' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img align='center' onclick="PatientSearch()"  src='../../eCA/images/MI_SearchPatient.gif' alt='Patient Search'  title='<fmt:message key="eCA.PatientwithoutEncounter.label" bundle="${ca_labels}"/>' ></img></a></td>
				<%
					}
					if(from_service_yn.equals("N") && lookupFileName.equals("")&& limit_function_id.equals(""))
					{
				%>
						<td class='iconBarRow<%=styleMap%>'><a href="#" name='ClinicalCalc' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img align='center' src='../../eCA/images/MI_ClinicalCalc.gif' onclick="callCalculator()" alt='<fmt:message key="eCA.ClinicalCalculator.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.ClinicalCalculator.label" bundle="${ca_labels}"/>'></img></a></td>
				<%
					}
				%>
					<td ><img align='center' name='divider' id='divider' src='../../eCA/images/MI_htStrip<%=styleMap%>.gif' alt='' ></img></td>	
					<td id='refreshIcons'>
					</td>
					<!-- IN0052635 starts-->
					<!--<td><a href="#" name='RightStripImg' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('RightStrip1','','../../eCA/images/MI_RightStrip1<% //=styleMap%>.gif',1)"><img src="../../eCA/images/MI_RightStrip2<% //=styleMap%>.gif" alt='<fmt:message key="eCA.CustomizeIcons.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.CustomizeIcons.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='customizeIcons()' style='<% //=limit_function_id.equals("")?"display":"display:none"%>' /></a></td>-->
					<td><a href="#" name='RightStripImg' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('RightStrip1','','../../eCA/images/MI_RightStrip1<%=styleMap%>.gif',1)"><img src="../../eCA/images/MI_RightStrip2<%=styleMap%>.gif" alt='<fmt:message key="eCA.CustomizeIcons.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.CustomizeIcons.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='customizeIcons()' style='<%=limit_function_id.equals("")?"display":"display:none"%>' /></a><input type='hidden' name='totMenuDisplay' id='totMenuDisplay' value=''></td>
					<!-- IN0052635 ends-->
					</tr></table>
					</td>
					<td class='' align='right' width='40%'><table border="0" cellspacing="0" cellpadding="0"><tr class='iconBarRow<%=styleMap%>'>
					<%
					if(lookupFileName.equals("") && limit_function_id.equals(""))
						{
					%>

						<td class='iconBarRow<%=styleMap%>' align='right' id='quick' >
						<select name='quick_links' id='quick_links'  onchange='loadFunction(this)' style='FONT-SIZE:8pt'>
						<option value = ''>-----<fmt:message key="eCA.QuickLinks.label" bundle="${ca_labels}"/>-----</option>
					<%
						if (!episode_id.equals(""))
						{
							try
							{
								String strSqln1 = "SELECT SPECIALTY_CODE, PATIENT_CLASS,VISIT_ADM_TYPE,CASE WHEN patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_admission_type(visit_adm_type,'en',2) WHEN patient_class IN ('OP', 'EM') THEN op_get_desc.op_visit_type (facility_id,visit_adm_type,'en',2) END VISIT_TYPE_DESC FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=? "; //IN28627 //IN28689 
								pstmt = con.prepareStatement(strSqln1);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,episode_id);
								rs = pstmt.executeQuery();
							
								if(rs.next())
								{
									patientclass = rs.getString("PATIENT_CLASS");
									if(patientclass == null) patientclass = "";
									speciality_code = rs.getString("SPECIALTY_CODE");
									if(speciality_code == null) speciality_code = "";
									visit_type = rs.getString("VISIT_ADM_TYPE"); //IN28627
									if(visit_type == null) visit_type = ""; //IN28627
									visittype_desc = rs.getString("VISIT_TYPE_DESC"); //IN28689
									if(visittype_desc == null) visittype_desc = ""; //IN28689
								}

								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();	
							}
							catch(Exception ew)
							{ 
								ew.printStackTrace();
							}
						}
						//String strSql2 = "SELECT CA_GET_MENU_ID(?,?,?,?) MENU_ID FROM DUAL ";		//IN036733 - commented
						String strSql2 = "SELECT CA_GET_MENU_ID(?,?,?,?,?) MENU_ID FROM DUAL ";		//IN036733
						
						pstmtMenu = con.prepareStatement(strSql2);
						pstmtMenu.setString(1,speciality_code);
						pstmtMenu.setString(2,patientclass);
						pstmtMenu.setString(3,practitioner_id);
						pstmtMenu.setString(4,pract_type);
						pstmtMenu.setString(5,facility_id);	//IN036733
						try
						{
							rsMenu = pstmtMenu.executeQuery();
						
							if(rsMenu.next())
							{
								menu_id = rsMenu.getString("MENU_ID");
							}

							if(rsMenu!=null) rsMenu.close();
							if(pstmtMenu!=null) pstmtMenu.close();	
							if(patientclass == null) patientclass = "";
						}
						catch(Exception ew)
						{ 
							out.println(ew.getMessage());
						}

						if(menu_id == null)		menu_id="MED_DFLT";	

						if(!patient_id.equals(""))
						{
							String sql_nric = "SELECT NATIONAL_ID_NO FROM MP_PATIENT where PATIENT_ID = ?";
							pstmt = con.prepareStatement(sql_nric);
							pstmt.setString(1,patient_id);
							rs = pstmt.executeQuery();
							if(rs.next())
							{
								nric_code = rs.getString("NATIONAL_ID_NO") == null ? "" : rs.getString("NATIONAL_ID_NO");
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						}

						/*Added By Jyothi to fix IN018529 on 27/01/2010 at 2:00 PM*/
						sql.append("SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b,        sm_quick_link_list_lang_vw c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'Q' AND c.eff_status = 'E' AND c.language_id = ? AND c.global_yn = 'Y' AND DECODE (c.QUICK_LINK_TYPE,'EX','Y',NVL((SELECT 'Y' FROM CA_OPTION WHERE OPTION_ID = C.OPTION_ID ");
						
						if(patient_id.equals(""))
							sql.append(" AND DESKTOP_YN = 'Y' ");
						else
							sql.append(" AND DESKTOP_YN = 'N' ");
						sql.append("),'N')) = 'Y'"); 

						pstmt = con.prepareStatement(sql.toString());
	
						pstmt.setString(1,login_user);
						pstmt.setString(2,resp_id);
						pstmt.setString(3,locale);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							Existance_Count = rs.getInt("EXISTANCE_COUNT");
						}
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

						/*END*/

						if(detl_sql.length() > 0)
							detl_sql.delete(0,detl_sql.length());

						//detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING from sm_quick_link_list_lang_vw A, CA_OPTION B,");//IN29822
						//detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING from sm_quick_link_list_lang_vw A, CA_OPTION B,sm_quick_link_resp d,");//IN29822
						detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF from sm_quick_link_list_lang_vw A, CA_OPTION B,sm_quick_link_resp d,");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						//detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND B.OPTION_ID(+)=A.OPTION_ID AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND B.EXECUTABLE_NAME IS NOT NULL ");//IN29822
						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND B.OPTION_ID(+)=A.OPTION_ID AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND B.EXECUTABLE_NAME IS NOT NULL AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'Q'");//IN29822
						if(patient_id.equals(""))
							detl_sql.append(" and B.DESKTOP_YN(+) = 'Y' ");
						else
						{
							detl_sql.append(" and B.DESKTOP_YN(+) = 'N' ");
							if(mode.equals("V"))
								detl_sql.append(" and b.HIST_OR_RECORD = 'H' ");
							if(patient_class.equals(""))
								patient_class = "XT";
							detl_sql.append(" and b.APPL_"+patient_class+"_YN = 'Y' ");
						}
						detl_sql.append(" and exists (select 1 from ca_appl_task ia where OPTION_ID(+) = a.OPTION_ID and  GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) = 'A' and (ia.BASE_MODULE_ID = 'CA' or exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
						
						if(!patient_id.equals(""))
							detl_sql.append(" and ( MODULE_GROUP_ID!='SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");

						//detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING   from sm_quick_link_list_lang_vw A,");//IN29822
						//detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING from sm_quick_link_list_lang_vw A,sm_quick_link_resp d, ");//IN29822
						detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF  from sm_quick_link_list_lang_vw A,sm_quick_link_resp d, ");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						//detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' order by 2");//IN29822
						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? order by 2");//IN29822
						
						pstmt = con.prepareStatement(detl_sql.toString());
						int val = 0;
						if(Existance_Count>0)
							pstmt.setString(++val,login_user);
						else
							pstmt.setString(++val,resp_id);
						pstmt.setString(++val,resp_id);//IN29822
						pstmt.setString(++val,resp_id);
						pstmt.setString(++val,reln_id);
						pstmt.setString(++val,facility_id);
						pstmt.setString(++val,episode_id);
						pstmt.setString(++val,patient_id);
						
						if(!patient_id.equals(""))
						{
							pstmt.setString(++val,splty_code);
						}
						if(Existance_Count>0)
							pstmt.setString(++val,login_user);
						else
							pstmt.setString(++val,resp_id);
						pstmt.setString(++val,resp_id);//IN29822
						
						rs = pstmt.executeQuery();
						//44162 Start.
						String Encry_login_user=""; 
						//System.out.println("CAMainTitle.jsp==============>968");
						Boolean isExtAppUserIdEncrypted =  CommonBean.isSiteSpecific(con, "OR", "EXTAPP_LOGIN_USER_ID_ENCRY");
					//	System.out.println("CAMainTitle.jsp========isExtAppUserIdEncrypted======>"+isExtAppUserIdEncrypted);	
						if(isExtAppUserIdEncrypted){
							try{
							//	System.out.println("CAMainTitle.jsp==============>973");			
								String data_user="app_id=bruhims&app_secret=3e17cad3f0a771d7c7af34098443d533&data.user_info.id="+login_user.toLowerCase();
							//	System.out.println("CAMainTitle.jsp==============>975=====>"+data_user);
								java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
							//	System.out.println("CAMainTitle.jsp==============>977=================>"+digest);
								digest.reset();
							//	System.out.println("CAMainTitle.jsp==============979=================>"+data_user.getBytes("UTF-8"));
								byte[] hash = digest.digest(data_user.getBytes("UTF-8"));
							//	System.out.println("CAMainTitle.jsp==============>981======hash.length=============>"+hash.length);
							//	System.out.println("CAMainTitle.jsp==============>982===================>"+new String(hash));			
								
								// Convert byte array into signum representation
								java.math.BigInteger no = new java.math.BigInteger(1, hash);
					  
								// Convert message digest into hex value
								Encry_login_user = no.toString(16);
								while (Encry_login_user.length() < 32) {
									Encry_login_user = "0" + Encry_login_user;
								}
							//	System.out.println("CAMainTitle.jsp==============>992======1=========>"+Encry_login_user);
								
								//Encry_login_user=javax.xml.bind.DatatypeConverter.printHexBinary(hash);
								//System.out.println("CAMainTitle.jsp==============>995======2=========>"+Encry_login_user);
							
							}catch(NoSuchAlgorithmException e){
								System.out.println("CAMainTitle.jsp==998=======Error========>"+e.toString());
							}catch(Exception e1){
								e1.printStackTrace();
								System.out.println("CAMainTitle.jsp==1001=======Error========>"+e1.toString());
							}
							
						}
						//44162 End.

						while(rs.next())
						{
							//option_id = rs.getString("OPTION_ID") + "|" + rs.getString("QUICK_LINK_TYPE") + "|"+ rs.getString("LONG_DESC") + "|" + rs.getString("EXECUTABLE_NAME");	
							executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
							if(!executable_name.equals("")){
								if (executable_name.indexOf("~PATIENT_ID`") >= 0){
										executable_name = executable_name.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (executable_name.indexOf("~ENCOUNTER_ID`")>=0){
										executable_name = executable_name.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (executable_name.indexOf("~FACILITY_ID`")>= 0){
										executable_name = executable_name.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (executable_name.indexOf("~NRIC`")>= 0){
										executable_name = executable_name.replaceAll("~NRIC`",nric_code);
								}
								 //IN27710 - Start
                                if (executable_name.indexOf("~LOGIN_USRID`")>= 0){									
									executable_name = executable_name.replaceAll("~LOGIN_USRID`",login_user); //IN28627									
								}
								//44162 Start.	
								if (executable_name.indexOf("~ENC_LOGIN_USRID`")>= 0){																	
									if(isExtAppUserIdEncrypted ){ 
										executable_name = executable_name.replaceAll("~ENC_LOGIN_USRID`",Encry_login_user);
									}else{
										executable_name = executable_name.replaceAll("~ENC_LOGIN_USRID`",login_user);	
									}									
								}
								//44162 End.
								if (executable_name.indexOf("~PATIENT_NAME`")>= 0){
										executable_name = executable_name.replaceAll("~PATIENT_NAME`",patient_name);
								}
								if (executable_name.indexOf("~AGE`")>= 0){
										executable_name = executable_name.replaceAll("~AGE`",age);
								}
								if (executable_name.indexOf("~GENDER`")>= 0){
										executable_name = executable_name.replaceAll("~GENDER`",sex); //IN28627
								}
								if (executable_name.indexOf("~VISIT_TYPE_DESC`")>= 0){
										executable_name = executable_name.replaceAll("~VISIT_TYPE_DESC`",visittype_desc); //IN28689
								}
								  //IN27710 - End
							}
							v_query_string = rs.getString("QUERY_STRING")==null?"":rs.getString("QUERY_STRING");
							if(!v_query_string.equals("")){
								
								if (v_query_string.indexOf("~PATIENT_ID`") >= 0){
										v_query_string = v_query_string.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (v_query_string.indexOf("~ENCOUNTER_ID`")>=0){
										v_query_string = v_query_string.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (v_query_string.indexOf("~FACILITY_ID`")>= 0){
										v_query_string = v_query_string.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (v_query_string.indexOf("~NRIC`")>= 0){
										v_query_string = v_query_string.replaceAll("~NRIC`",nric_code);
								}
                               //IN27710 - Start
								if (v_query_string.indexOf("~LOGIN_USRID`")>= 0){	
									v_query_string = v_query_string.replaceAll("~LOGIN_USRID`",login_user); //IN28627
								}
								//44162 Start.	
								if (v_query_string.indexOf("~ENC_LOGIN_USRID`")>= 0){	
									if(isExtAppUserIdEncrypted ){ 
										v_query_string = v_query_string.replaceAll("~ENC_LOGIN_USRID`",Encry_login_user);
									}else{
										v_query_string = v_query_string.replaceAll("~ENC_LOGIN_USRID`",login_user);	
									}
								}
								//44162 End.
								if (v_query_string.indexOf("~PATIENT_NAME`")>= 0){
										v_query_string = v_query_string.replaceAll("~PATIENT_NAME`",patient_name);
								}
								if (v_query_string.indexOf("~AGE`")>= 0){
										v_query_string = v_query_string.replaceAll("~AGE`",age);
								}
								if (v_query_string.indexOf("~GENDER`")>= 0){
										v_query_string = v_query_string.replaceAll("~GENDER`",sex); //IN28627
								}
								if (v_query_string.indexOf("~VISIT_TYPE_DESC`")>= 0){
										v_query_string = v_query_string.replaceAll("~VISIT_TYPE_DESC`",visittype_desc); //IN28689
								}
								//IN27710 - End
							} 	
							option_id.delete(0,option_id.length());
							option_id.append(rs.getString("OPTION_ID"));
							option_id.append("|");
							option_id.append(rs.getString("QUICK_LINK_TYPE"));
							option_id.append("|");
							option_id.append(rs.getString("LONG_DESC"));
							option_id.append("|");
							option_id.append(executable_name);
							option_id.append("|");//IN036367
							option_id.append(rs.getString("QUICK_LINK_REF"));//IN036367
							if(!v_query_string.equals("")){ 
								option_id.append("?");							
								option_id.append(v_query_string);
							}
							
				%>
								<option value="<%=option_id.toString()%>"><%=rs.getString("quick_link_description")%></option>
				
				<%
						}//end of rs.next()
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();
				%>
						</select></td>
						<td><a href="#" name='RightStripQL' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('RightStrip1','','../../eCA/images/MI_RightStrip1<%=styleMap%>.gif',1)"><img src="../../eCA/images/MI_RightStrip2<%=styleMap%>.gif" alt='<fmt:message key="eCA.CustomiseLinks.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.CustomiseLinks.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='UpdateResp()' style='<%=limit_function_id.equals("")?"display":"display:none"%>' /></a>&nbsp;&nbsp;</td>
				<%
						}
				%>
					<%
							if(!patient_id.equals(""))
							{
					%>
					<td>
					<%
						if(menu_Active.equals("N") && lookupFileName.equals("") && limit_function_id.equals(""))
						{ 
							if(patient_id.equals("")) 
								spacesForImage = ""; 
							else  
								spacesForImage = "&nbsp;&nbsp;";
					%>
							<table border="0" cellspacing="0" cellpadding="0">
							<tr class='iconBarRow<%=styleMap%>'>
							<td>
							<img class='imageClass' id='seperator' src='../../eCA/images/MI_htStrip<%=styleMap%>.gif' alt=''
					<%
							if(patient_id.equals("") || !from_service_yn.equals("N"))
							{
					%>
								style='display:none'
					<%
							}
					%> 
							></img><td>
							<td align='center'>
							<a href="#" name='History' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'  
					<%
							if(patient_id.equals("") || !from_service_yn.equals("N"))
							{
					%>
								style='display:none'
					<%
							}
					%> 
							><img onclick="loadOrUnloadLookup(this)" name='HideAndShowLookup' accesskey='L' title='History' src='../../eCA/images/mc_history.gif'></img></a></td>
							<!--IN061891 Starts -->
					<%     if("Y".equals(addFavPatientIcon)){%>
							<td align='center' id="ppatlist" style="" >
							<a href="#" name='Add Patient to Pat List' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'
							><img onclick="addPersonalise(this)" name='HideAndShowLookup' accesskey='L' title='Add Patient to Personalized List' src='../../eCA/images/FavPatient.png'></img></a></td>

					<%		}%>
							<!--IN061891 Ends-->
							<!-- Added By : Arvind
								Date : 1/25/2010
								CRF  : PMG20089-CRF-429
								Discription : Below code added for "default select Filter criteria ". 
						 -->
					<%
							if(langListSize >= 1)
							{
					%>
							<td><img onclick="switchLanguage(this, '<%=langListSize%>','<%=cur_lang_id%>','<%=opt_lang_id%>')"  name='SwitchLanguage' accesskey='L' title='Switch Language' src='../../eCA/images/SwitchLanguageicon.JPG'
					<%
							if(patient_id.equals("") || !from_service_yn.equals("N"))
							{
					%>
								style='display:none'
					<%
							}
					%> 
							
							></img></a></td>
							<input type="hidden" name="cur_lang_id" id="cur_lang_id" value="<%=cur_lang_id%>">
							<input type="hidden" name="opt_lang_id" id="opt_lang_id" value="<%=opt_lang_id%>">
							<!-- End Here -->
					<%
							}
						}
						if(menu_Active.equals("N") && !patient_id.equals(""))
						{
					%>
						 <td><a href="#" name="link0" style="display:none" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' class = 'imageClass1'><img align='center' onclick='callWindow(0)' src='../../eCA/images/mc_history_1.gif' name='btn0'></img></a></td>
						 <td><a href="#" name="link1" style="display:none" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' class = 'imageClass1'><img align='center' onclick='callWindow(1)' src='../../eCA/images/mc_history_2.gif' name='btn1'></img></td> 
					<%
						}
					%>
								</tr>
						</table>
					</td>
					<%
						}
					%>
					</tr>
					</table>
				</td>
			<%
				}
			%>
      	
		<td align='right' width='3%'><table border="0" cellspacing="0" cellpadding="0" align='right'>
		<tr class='iconBarRow<%=styleMap%>'>
		<td>
		<%
		// IN044083 Start.
		//IN058149 start 
		if("N".equals(Genotitle) && from_service_yn.equals("N")){
		//IN058149 end
		%>
		<img class='imageClass' id='seperator' src='../../eCA/images/MI_htStrip<%=styleMap%>.gif' alt=''></img>
		<%
		}else{
		%>
		&nbsp;
		<%
		}
		// IN044083 End.
		%>
		<td>
	<%
			if((eCA._ca_license_rights.getKey()).equals("CACLDC")  || (eCA._ca_license_rights.getKey()).equals("CABASIC"))
			{	
				if(lookupFileName.equals("") && from_service_yn.equals("N")&& limit_function_id.equals(""))
				{
					//out.println("lookupFileName :"+lookupFileName);
					//out.println("from_service_yn :"+from_service_yn);
					//out.println("limit_function_id :"+limit_function_id);

	%>
					<td><img class = 'imageClass' align='center' onclick="ShowPats()" src='../../eCA/images/MI_SwitchT1.gif' alt='Switch' title='Switch' id='switch' name='switch' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('switch','','../../eCA/images/MI_SwitchT2.gif',1)" style="margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;"></img></td>
	<%			}
			}
			if(!lookupFileName.equals(""))
			{ // IN044083 Start.
			  //IN058149  start
			  if("N".equals(Genotitle) && from_service_yn.equals("N")){
			  //IN058149 end
				
	%>
				<td><img class = 'imageClass' align='center' src='../../eCA/images/MI_SwitchT1.gif' onclick='getParentWindow()' alt='Patient Chart' title='Patient Chart' id='pc' name='pc' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('pc','','../../eCA/images/MI_SwitchT2.gif',1)" style="margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;"></img></td>
	<%	
				}else{
	%>
				<td>&nbsp;</td>
	<%			
				}
				// IN044083 End.
			}
			if(!child_window.equals("Y"))
			{
				
				altText = "Close";
			}
			if(lookupFileName.equals("")){
				
				%>
	
				<td><img class = 'imageClass' align='center' src='../../eCA/images/MI_CloseT1.gif' onclick="closeFunction('<%=child_window%>','<%=wname%>','Y')" alt='<%=altText%>' title='<%=altText%>' id='close' name='close' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('close','','../../eCA/images/MI_CloseT2.gif',1)" style="margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;"></img></td>
	<%
			}
	
			else if(!lookupFileName.equals(""))
			{
				// IN044083 Start.
				//IN058149 start
				if("N".equals(Genotitle) && from_service_yn.equals("N")){
				//IN058149 end
	%>
				<td><img class = 'imageClass' align='center' src='../../eCA/images/MI_CloseT1.gif' onclick='hideLookupButton()' alt='<%=altText%>' title='<%=altText%>' id='cc' name='cc' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('cc','','../../eCA/images/MI_CloseT2.gif',1)" style="margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;"></img></td>
	<%		
				}else{
	%>
				<td>&nbsp;</td>
	<%			
				}
				// IN044083 End.
			}
	%>
		</tr></table>
		</td>

    </tr>
</table>
<table width="100%" cellspacing='0' cellpadding='0' border='0'>
	<tr>
		<td class='iconBarRow<%=styleMap%>' id='dispname'><%=function_display_name%></td>
		<td class='iconBarRow<%=styleMap%>' id='filter_by' style='display:none' align='right'><img src="../../eCA/images/filter.gif" name='filterImg' alt='Filter' title='Filter' /> : <select name='filter' id='filter' onchange='loadFilterFunction(this)'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select><a href="#"><img src="../../eCA/images/customize.gif" alt='<fmt:message key="eCA.CustomiseFilter.label" bundle="${ca_labels}"/>' title='<fmt:message key="eCA.CustomiseFilter.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='UpdateFilter()' /></a>&nbsp;&nbsp;
		<input type='hidden' name='function_id' id='function_id' value=''><input type='hidden' name='executable_path' id='executable_path' value=''></td>
		<td class ='LABELRIGHT' id='myTask' style='display:none'><fmt:message key="eCA.MyTaskList.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="eCA.Detailsason.label" bundle="${ca_labels}"/>&nbsp;<%=com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale)%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href='javascript:refresh();'><u><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></u></A></td>
	</tr>
</table>

<%	
	if(rs!=null) rs.close();
	if (pstmt != null) pstmt.close();
	} 
	catch (Exception e) 
	{
		out.println("CAMainTitle: "+e);
	}
	 finally 
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

%>
<form name='appt' id='appt'>
    <input type='hidden' name='reviseparams' id='reviseparams'>
    <input type='hidden' name='reviseref' id='reviseref'>
</form>
<form name='refForm' id='refForm'>
	<input type="hidden" name = "ref_patient_id" value="<%=patient_id%>">
	<input type="hidden" name = "nursing_unit" value="<%=nursing_unit%>">

	<input type="hidden" name = "ref_episode_id" value="<%=request.getParameter("episode_id")==null?"":request.getParameter("episode_id")%>">
	<input type="hidden" name = "queryString" value="<%=request.getQueryString()%>">
	<input type="hidden" name = "bed_patient_id" value="">
</form>

<form name='pat_info' id='pat_info'>
    <input type='hidden' name='patientId' id='patientId'>
    <input type='hidden' name='visitId' id='visitId'>
    <input type='hidden' name='episodeId' id='episodeId'>
    <input type='hidden' name='locationCode' id='locationCode'>
    <input type='hidden' name='locationType' id='locationType'>
    <input type='hidden' name='pat_info' id='pat_info'>
	<input type='hidden' name='window_name' id='window_name' value='<%=window_name%>'>
	<input type='hidden' name='lookup_window_name' id='lookup_window_name' value='<%=lookup_window_name%>'>
</form>
<form name='PatSearchFrm' id='PatSearchFrm' action='OpenChartWrapper.jsp' method = 'post' target=messageFrame>
    <input type='hidden' name='patient_id' id='patient_id'>
    <input type='hidden' name='episode_visit_id' id='episode_visit_id'>
    <input type='hidden' name='episode_id' id='episode_id'>
    <input type='hidden' name='from_function' id='from_function' value='M'>
</form>
<!-- IN061891 Starts -->
<form name='PersonalisePatient' id='PersonalisePatient' action='../../servlet/eCA.PersonalisePatListServlet' method = 'post' target=messageFrame >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='login_id' id='login_id' value='<%=login_user%>'>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type='hidden' name='resp_id' id='resp_id' value='<%=resp_id%>'>
	<input type='hidden' name='pract_id' id='pract_id' value="<%=practitioner_id%>">
	<input type='hidden' name='system_id' id='system_id' value="<%=client_ip_address%>"><!--IN061891-->
	<input type='hidden' name='mode' id='mode' value='insert'>
</form>
<!-- IN061891 ends-->
<form name='homePageParam' id='homePageParam' >
    <input type='hidden' name='layout_value' id='layout_value' value='<%=layout_value%>'>
    <input type='hidden' name='desktod_id' id='desktod_id' value='<%=desktod_id%>'>
    <input type='hidden' name='dfltFunctionId' id='dfltFunctionId' value='<%=dfltFunctionId%>'>
	<!-- Added By Arvind For ICN-22310   -->
	 <input type='hidden' name='menuId' id='menuId' value='<%=menu_id%>'>  
</form>
<input type='hidden' name='toolbarQueryString' id='toolbarQueryString' value='<%=queryString%>'><!--IN057446-->
<!--<input type='hidden' name='menuId' id='menuId' value='<% //=menu_id%>'>  <!--ICON_COUNT_ISSUE--> <!-- IN058755 commented for the script error -->
</body>
<script>

async function customizeIcons()
{	
	var dialogHeight= "92vh" ;
	var dialogWidth	= "26vw" ;
	var dialogTop	= "0vh";
	var dialogLeft	= "0vw";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";
	
	var totMenuDisplay	=	parent.CommonToolbar.totMenuDisplay.value; //IN0052635
	
	//IN0052635 starts
	//var ret = window.showModalDialog("../../eCA/jsp/CAMainCustomizeToolbar.jsp?<%=request.getQueryString()%>&menuId=<%=menu_id%>&patientclass=<%=patientclass%>",arguments,features);
	var ret = await window.showModalDialog("../../eCA/jsp/CAMainCustomizeToolbar.jsp?<%=request.getQueryString()%>&menuId=<%=menu_id%>&patientclass=<%=patientclass%>&totMenuDisplay="+totMenuDisplay,arguments,features);
	//IN0052635 ends
	
	if(ret != '' && ret != undefined)
	{
		//alert(getMessage("RECORD_INSERTED","CA"));
		displayIcons(ret);
	}
}
function displayIcons(tableVal)
{
	tableVal = tableVal.replace(/~/g,'"');

	refreshIcons.innerHTML = tableVal;

}
async function UpdateResp()
{	
	/*
	var dialogHeight= "31" ;
	var dialogWidth	= "35" ;
	var dialogTop	= "150";
	var dialogLeft	= "200";
	*/

	var dialogHeight= "65vh" ;
	var dialogWidth	= "35vw" ;
	var dialogTop	= "0vh";
	var dialogLeft	= "0vw";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

	var ret = window.showModalDialog("../../eCA/jsp/QuickLinksForRespCustomize.jsp?<%=request.getQueryString()%>&link_type=Q&patientclass=<%=patientclass%>",arguments,features);
	
	if(ret != '' && ret != undefined)
	{

		if(parent.CommonToolbar.quick_links != null)
		{
			var optlength = parent.CommonToolbar.quick_links.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.quick_links.options.remove("quick_links");
			}
			var HTMLVal="<html><body><form name='QuickLinksUpdateDescForm' id='QuickLinksUpdateDescForm' method='post' action='../../eCA/jsp/QuickLinksForRespUpdateDesc.jsp?<%=request.getQueryString()%>'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.QuickLinksUpdateDescForm.submit();
		}
	}
}
async function UpdateFilter()
{
	var function_id = parent.CommonToolbar.function_id.value;
	/*
	var dialogHeight= "31" ;
	var dialogWidth	= "35" ;
	var dialogTop	= "150";
	var dialogLeft	= "200";
	*/

	var dialogHeight= "65vh" ;
	var dialogWidth	= "35vw" ;
	var dialogTop	= "0vh";
	var dialogLeft	= "0vw";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

	var ret = await window.showModalDialog("../../eCA/jsp/QuickLinksForRespCustomize.jsp?function_id="+function_id+"&<%=request.getQueryString()%>&link_type=F",arguments,features);
	
	if(ret != '' && ret != undefined)
	{
		if(parent.CommonToolbar.filter != null)
		{
			var optlength = parent.CommonToolbar.filter.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.filter.options.remove("filter");
			}
				
			parent.messageFrame.document.addEventListener('DOMContentLoaded', function() {
				var HTMLVal="<html><body><form name='QuickLinksUpdateDescForm' id='QuickLinksUpdateDescForm' method='post' action='../eCA/jsp/QuickLinksForRespUpdateFilter.jsp'>"+
				"<input type='hidden' name='function_id' id='function_id' value='"+function_id+"'>"+
				"</form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				parent.messageFrame.document.QuickLinksUpdateDescForm.submit();
			});
		}
	}
}
</script>

<%
	if(menu_Active.equals("N") && lookupFileName.equals(""))
	{
%>
	<script>
	//var screensize = screen.width; //IN057229 //IN057272 commented and created globally
	
<%	if (!patient_id.equals(""))
	{					%>
	
		//IN057229 starts //parent.menuFrame.location.href='../../eCA/jsp/CAMainMenu.jsp?locale=<%=locale%>&<%=queryString%>&limit_function_id=<%=limit_function_id%>&menuId=<%=menu_id%>';
		parent.menuFrame.location.href='../../eCA/jsp/CAMainMenu.jsp?locale=<%=locale%>&<%=queryString%>&limit_function_id=<%=limit_function_id%>&menuId=<%=menu_id%>&screensize='+screensize;
		//IN057229 ends
<%	}	else{
		%>
		//parent.workArea.cols = '200px,0%,*,0%';
		
		loadOrUnloadMenus(document.ShowMenu);
		//IN057229 starts
		//parent.menuFrame.location.href='../../eCA/jsp/CAMainMenuHome.jsp?locale=<%=locale%>&<%=queryString%>&limit_function_id=<%=limit_function_id%>&layoutValue=<%=layout_value%>&dfltFunctionId=<%=dfltFunctionId%>&deskTopID=<%=desktod_id%>&menuId=<%=menu_id%>';
		parent.menuFrame.location.href='../../eCA/jsp/CAMainMenuHome.jsp?locale=<%=locale%>&<%=queryString%>&limit_function_id=<%=limit_function_id%>&layoutValue=<%=layout_value%>&dfltFunctionId=<%=dfltFunctionId%>&deskTopID=<%=desktod_id%>&menuId=<%=menu_id%>&screensize='+screensize;
		//IN057229 ends
<%	}	
	//if(desktod_id.equals("")){
		if(!patient_id.equals(""))
		{
%>
	        
			parent.lookupMenuFrame.location.href='../../eCA/jsp/CAMainLookupMenu.jsp?<%=queryString%>&limit_function_id=<%=limit_function_id%>&menuId=<%=menu_id%>';
<%
			if(patient_class.equals("EM"))
			{
%>
				//document.getElementById("HideAndShow").value = 'Show Menu';
			
<%
			}
		}
%>
	</script>
<%
	}
%>

<%
	if(! lookupFileName.equals(""))
	{
%>
	<script>
		
		function loadWorkArea()
		{	
			top.content.workAreaFrame.location.href='<%=lookupFileName%>?<%=queryString%>';
			//alert(top.content.workAreaFrame.location.href);
		}
		setTimeout("loadWorkArea()",750);
		getChartWindow("<%=window_name%>"); //to get the chart window object
		makeLookupButtonsVisible("<%=lookup_window_name%>"); // to make the lookup buttons visible
		parent.CommonToolbar.displayFunctionName("<%=function_display_name%>");
		if(parent.CommonToolbar.filter_by != null)
		{
			if('<%=function_display_name%>' == 'Clinical Event History')
			{
				parent.CommonToolbar.filter_by.style='display';
				var optlength = parent.CommonToolbar.filter.options.length;
               // alert("here"+optlength);
				for (var i=0; i<optlength; i++)
				{
					parent.CommonToolbar.filter.options.remove("filter");
				}

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=FLOW_SHEET", false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);

				/*var HTMLVal="<html><body><form name='CAMainFunctionFilterForm' id='CAMainFunctionFilterForm' method='post' action='../../eCA/jsp/CAMainFunctionFilterCriteria.jsp'>"+
				"<input type='hidden' name='function_id' id='function_id' value='FLOW_SHEET'>"+
				"</form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				parent.messageFrame.document.CAMainFunctionFilterForm.submit(); */
			}
			//IN069654 starts
			else if('<%=function_display_name%>' == 'New Clinical Event History')
			{
				
				parent.CommonToolbar.filter_by.style='display';
				var optlength = parent.CommonToolbar.filter.options.length;
				for (var i=0; i<optlength; i++)
				{
					parent.CommonToolbar.filter.options.remove("filter");
				}

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=FLOW_SHEET_NEW", false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);

			}
			//IN069654  ends
			//IN051294 start
			else if('<%=function_display_name%>' == 'View Clinical Notes')
			{
				parent.CommonToolbar.filter_by.style='display';
				
				var optlength = parent.CommonToolbar.filter.options.length;
              
				for (var i=0; i<optlength; i++)
				{
					parent.CommonToolbar.filter.options.remove("filter");
				}

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=PHYSICIAN_NOTES", false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);
			}
			//IN051294 ends
			else
				parent.CommonToolbar.filter_by.style.display = 'none';
		}

		top.window.document.title = "<%=(function_display_name+"-"+(patient_name+strBuffPatientInfo))%>"

	</script>
<%
	}
	else
	{
		if(limit_function_id.equals(""))
		{
			if(!patient_id.equals(""))
			{
%>
		<script>
			top.window.document.title = "<%=productName%> ver<%=versionNum%> - [ <%=name%> - <%=facilityName%> ]"
		</script>
<%
			}
		}
		else if(!limit_function_id.equals(""))
		{
%>
			<script>
				top.window.document.title = "<%=chartTitle%> for the patient <%=patient_name%>"
			</script>
<%
		}
	}
			
%>
<script>
	if(parent.mainFrameSet != null && '<%=patient_id%>' != '')
		parent.mainFrameSet.rows = '8%,95%,5%,0%';		
</script>
<%
	}
			catch(Exception eeee)
			{
				eeee.printStackTrace();
			}
	%>

