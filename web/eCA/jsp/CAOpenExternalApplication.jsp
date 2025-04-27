<% 
/*
-----------------------------------------------------------------------
Date       	  Edit History  Name        	Description
-----------------------------------------------------------------------
?             100         	?           	created
03/06/2013    IN001679    Chowminya G     PACS LIVE issue
04/10/2013    IN000000	  Chowminya 	  PACS Live - AAKH		
09/12/2013	  IN044687	  Chowminya       File upload issue - MODOMAN 	
20/05/2014	  IN000001	  Chowminya		  Sunil - to handle performance issue
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------	
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS		
19/11/2018  IN068797		Prakash C		19/11/2018		Ramesh G		MMS-DM-SCF-0568
04/03/2019	IN068038		Raja S			04/03/2019		Ramesh G		ML-MMOH-CRF-1205
22/12/2019	IN072022		Ramesh G										JD-INT-CRF-0001.1
08/10/2020	IN074137		Ramesh G		08/10/2020		Ramesh G		AAKH-SCF-0454.
29/10/2020	IN074119		SIVABAGYAM M	29/10/2020	RAMESH G	NMC-JD-CRF-0077
15/12/2020	7902		Sivabagyam M		15/12/2020		Ramesh G	MMS-DM-CRF-0180.1
08/11/2021	18243		Ramesh G			09/11/2021		Ramesh G	ML-BRU-CRF-0629.2
08/07/2022	21733		Ramesh G 			08/07/2022		Ramesh G	ML-BRU-CRF-0628.5
21/02/2023	41786		Ramesh G			21/02/2023		Ramesh G    MMS-DM-SCF-0865
------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,java.text.*,java.net.*,java.security.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<script>
	function invokeFun(fileName)
	{
		//alert('fileName from JS---'+fileName);
		if(fileName != "")
		{
			callOnImgClick(fileName);
		}
	}
</script>

<SCRIPT LANGUAGE=VBScript> 
	Dim wordObj

	Sub callOnImgClick(fileName)
		'MsgBox(fileName)
		call openWordDoc(fileName)
	End Sub

	Sub openWordDoc(filePathName)
		'MsgBox(filePathName)
		Set wordObj = CreateObject("Word.Application")
		'MsgBox(wordObj)
		wordObj.Visible = true
		wordObj.Documents.Open filePathName
		'wordObj.setfocus()
		'wordObj.focus()
	End Sub

</SCRIPT>
<title></title>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCA/js/RecClinicalNotesFileUpload.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown="lockKey()">
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//PreparedStatement pst = null;  //Checkstyle 4.0 Beta 6
	//ResultSet rs1 = null;			//Checkstyle 4.0 Beta 6
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = (String)session.getValue("facility_id");
	
	String Histrectype		 = "";
	String Contrsysid		 = "";
	String Accessionnum		 = "";
	String Contrsyseventcode = "";
	String extimageapplid	 = "";
	String base_url			 = "";
	String login_user 		 = "";  //18243
	String default_user_id	 = "";
	String object_id		 = "";
	String appl_password	 = "";
	String ext_image_appl_name= "";
	String patient_id		 = "";
	String completed_date	 = "";
	String completed_time	 = "";
	String event_desc		 = "";
	String event_group		 = "";
	String event_code		 = "";
	String ext_image_obj_id	 = "";
	String param_def_str     = "";
	String encounter_id     = "";
	String tempStr ="";
	String or_acc_num ="";//IN001679
	String fac_query="",performing_facility_id="";//IN074119
	String study_id="";//7902
//IN068797 starts	
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	if(clob_data.equals("_CDR")){
		facility_id		 = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	}
//IN068797 ends
	java.util.Date completedDateTime= new java.util.Date(); //IN072022
	Histrectype		 = request.getParameter("Histrectype")==null?"":request.getParameter("Histrectype");
	Contrsysid		 = request.getParameter("Contrsysid")==null?"":request.getParameter("Contrsysid");
	Accessionnum	 = request.getParameter("Accessionnum")==null?"":request.getParameter("Accessionnum");
	Contrsyseventcode= request.getParameter("Contrsyseventcode")==null?"":request.getParameter("Contrsyseventcode");
	extimageapplid	 = request.getParameter("extimageapplid")==null?"":request.getParameter("extimageapplid");
	patient_id		 = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	completed_date	 = request.getParameter("completed_date")==null?"":request.getParameter("completed_date");
	completed_time	 = request.getParameter("completed_time")==null?"":request.getParameter("completed_time");
	event_desc		 = request.getParameter("event_desc")==null?"":request.getParameter("event_desc");
	encounter_id		 = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");//IN001679
	StringBuffer completed_datetime		 = new StringBuffer();
	completed_datetime.append(completed_date);
	completed_datetime.append(" ");
	completed_datetime.append(completed_time);
	SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");   //IN072022
	SimpleDateFormat formatter2=new SimpleDateFormat("HH:mm:ss:SS"); //IN072022
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	//IN072022
	login_user=(String)session.getValue("login_user");  //18243
	String Encry_login_user=""; //21733
	System.err.println("CAOpenExternalApplication.jsp==============>135");
	try
	{
		con = ConnectionManager.getConnection();
		Boolean isExtAppDataFormat = CommonBean.isSiteSpecific(con, "CA", "EXT_APP_WIHT_DATE_FORMAT"); //IN072022
		Boolean isExtAppModelWindow = CommonBean.isSiteSpecific(con, "CA", "EXT_APP_OPENWIHT_MODELWINDOW"); //IN074137
		Boolean isExtAppNewWindow = CommonBean.isSiteSpecific(con, "CA", "EXT_APP_OPENWIHT_NEWWINDOW"); //37894
		//21733 Start.
		System.err.println("CAOpenExternalApplication.jsp==============>141");
		Boolean isExtAppUserIdEncrypted =  CommonBean.isSiteSpecific(con, "OR", "EXTAPP_LOGIN_USER_ID_ENCRY");
System.err.println("CAOpenExternalApplication.jsp========isExtAppUserIdEncrypted======>"+isExtAppUserIdEncrypted);	
isExtAppUserIdEncrypted=true;	
		if(isExtAppUserIdEncrypted){
			try{
			System.err.println("CAOpenExternalApplication.jsp==============>147");			
			String data_user="app_id=bruhims&app_secret=3e17cad3f0a771d7c7af34098443d533&data.user_info.id="+login_user.toLowerCase();
			System.err.println("CAOpenExternalApplication.jsp==============>149=====>"+data_user);
			java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			System.err.println("CAOpenExternalApplication.jsp==============>1515=================>"+digest);
			digest.reset();
			System.err.println("CAOpenExternalApplication.jsp==============>1516=================>"+data_user.getBytes("UTF-8"));
            byte[] hash = digest.digest(data_user.getBytes("UTF-8"));
			System.err.println("CAOpenExternalApplication.jsp==============>153======hash.length=============>"+hash.length);
			System.err.println("CAOpenExternalApplication.jsp==============>1531===================>"+new String(hash));			
			
			// Convert byte array into signum representation
            java.math.BigInteger no = new java.math.BigInteger(1, hash);
  
            // Convert message digest into hex value
            Encry_login_user = no.toString(16);
            while (Encry_login_user.length() < 32) {
                Encry_login_user = "0" + Encry_login_user;
            }
			System.err.println("CAOpenExternalApplication.jsp==============>155======1=========>"+Encry_login_user);
			
			//Encry_login_user=javax.xml.bind.DatatypeConverter.printHexBinary(hash);
			//System.err.println("CAOpenExternalApplication.jsp==============>155======2=========>"+Encry_login_user);
			
			}catch(NoSuchAlgorithmException e){
				System.err.println("CAOpenExternalApplication.jsp==161=======Error========>"+e.toString());
			}catch(Exception e1){
				e1.printStackTrace();
				System.err.println("CAOpenExternalApplication.jsp==163=======Error========>"+e1.toString());
			}
			
		}
		//21733 End.
		if (extimageapplid.equals("DOCUL"))
		{
			//String  sql123 = "select b.EXT_IMAGE_OBJ_ID object_id from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";commented for IN068797
			String  sql123 = "select b.EXT_IMAGE_OBJ_ID object_id from CR_ENCOUNTER_DETAIL##REPDB## b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";//IN068797
		
			sql123 = sql123.replaceAll("##REPDB##",RepDb);//IN068797
			pstmt = con.prepareStatement(sql123);
			pstmt.setString(1,Histrectype);
			pstmt.setString(2,Contrsysid);
			pstmt.setString(3,Accessionnum);
			pstmt.setString(4,Contrsyseventcode);
			System.out.println("CAOpenExternalApplication.jsp-------168----------Histrectype------->"+Histrectype);
			System.out.println("CAOpenExternalApplication.jsp-------169----------Contrsysid------->"+Contrsysid);
			System.out.println("CAOpenExternalApplication.jsp-------170----------Accessionnum------->"+Accessionnum);
			System.out.println("CAOpenExternalApplication.jsp-------171----------Contrsyseventcode------->"+Contrsyseventcode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				
				object_id= rs.getString("object_id")==null?"":rs.getString("object_id");
			
			}
			System.out.println("CAOpenExternalApplication.jsp-------181----------object_id------->"+object_id);
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();
			//IN044687 - Start Added else if condition
			if (object_id.equals("")) 
				object_id =Accessionnum;
			else if(!object_id.equals("") && Accessionnum.contains("!") && !object_id.contains("$") )
			{
				//sql123 = "select LINKED_NOTE_ACCESSION_NUM from or_result_detail where order_id = (select ORDER_ID from or_order_line where EXT_APPL_ACCESSION_NUM = ?)";commented for IN068797
				sql123 = "select LINKED_NOTE_ACCESSION_NUM from or_result_detail##REPDB## where order_id = (select ORDER_ID from or_order_line##REPDB## where EXT_APPL_ACCESSION_NUM = ?)";//IN068797
			
				sql123 = sql123.replaceAll("##REPDB##",RepDb);//IN068797
					pstmt = con.prepareStatement(sql123);
					pstmt.setString(1,object_id);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						object_id = rs.getString("LINKED_NOTE_ACCESSION_NUM")==null?"":rs.getString("LINKED_NOTE_ACCESSION_NUM");
					}
					System.out.println("CAOpenExternalApplication.jsp-------200----------object_id------->"+object_id);
					if(rs != null ) rs.close();
					if(pstmt != null ) pstmt.close();
			}
			//IN044687 - End
			out.println("<script>openDocWindow('"+object_id+"','"+Contrsyseventcode+"')</script>");
		}
		else
		{		
				//String sql = "select BASE_URL ,DEFAULT_USER_ID,app_password.DECRYPT(DEFAULT_USER_PASSWORD) DEFAULT_USER_PASSWORD,EXT_IMAGE_APPL_NAME,PARAM_DEF_STR from CA_EXT_IMAGE_APPL_LANG_VW where EXT_IMAGE_APPL_ID = ? AND LANGUAGE_ID = ?";commented for IN068797
				String sql = "select BASE_URL ,DEFAULT_USER_ID,app_password.DECRYPT(DEFAULT_USER_PASSWORD) DEFAULT_USER_PASSWORD,EXT_IMAGE_APPL_NAME,PARAM_DEF_STR from CA_EXT_IMAGE_APPL_LANG_VW##REPDB## where EXT_IMAGE_APPL_ID = ? AND LANGUAGE_ID = ?";//IN068797
				sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
			
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1,extimageapplid);
				pstmt.setString(2,locale);
				
				System.out.println("CAOpenExternalApplication.jsp-------218----------extimageapplid------->"+extimageapplid);
				System.out.println("CAOpenExternalApplication.jsp-------219----------locale------->"+locale);
				
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					base_url = rs.getString("base_url")==null?"":rs.getString("base_url");
					appl_password= rs.getString("DEFAULT_USER_PASSWORD")==null?"":rs.getString("DEFAULT_USER_PASSWORD");
					default_user_id=rs.getString("DEFAULT_USER_ID")==null?"":rs.getString("DEFAULT_USER_ID");
					ext_image_appl_name=rs.getString("EXT_IMAGE_APPL_NAME")==null?"":rs.getString("EXT_IMAGE_APPL_NAME");
					param_def_str=rs.getString("PARAM_DEF_STR")==null?"":rs.getString("PARAM_DEF_STR");
				}
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
				System.out.println("CAOpenExternalApplication.jsp-------233----------base_url------->"+base_url);
				System.out.println("CAOpenExternalApplication.jsp-------234----------appl_password------->"+appl_password);
				System.out.println("CAOpenExternalApplication.jsp-------235----------default_user_id------->"+default_user_id);
				System.out.println("CAOpenExternalApplication.jsp-------236----------ext_image_appl_name------->"+ext_image_appl_name);
				System.out.println("CAOpenExternalApplication.jsp-------237----------param_def_str------->"+param_def_str);
				
			if(Contrsysid.equals("OR") && !patient_id.equals("") && !completed_date.equals("") && !completed_time.equals("") && !event_desc.equals(""))
			{
				object_id		= Accessionnum;
				System.out.println("CAOpenExternalApplication.jsp-------241----------object_id------->"+object_id);
			}
			else
			{
			
				//IN001679 - Start
				if(Contrsysid.equals("OR") && !Accessionnum.contains("!"))
				{
					rs = null; //IN000000
					//sql = "select (ORDER_TYPE_CODE||'!'||ORDER_ID||'!'||report_srl_no||'!'||srl_no||'!'||line_srl_no) ACCESSION_NUM from or_result_detail where order_id = (select ORDER_ID from or_order_line where EXT_APPL_ACCESSION_NUM = ?) ";commented for IN068797			
					sql = "select (ORDER_TYPE_CODE||'!'||ORDER_ID||'!'||report_srl_no||'!'||srl_no||'!'||line_srl_no) ACCESSION_NUM from or_result_detail##REPDB## where order_id = (select ORDER_ID from or_order_line##REPDB## where EXT_APPL_ACCESSION_NUM = ?) ";//IN068797
					
					sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,Accessionnum);
					System.out.println("CAOpenExternalApplication.jsp-------257----------Accessionnum------->"+Accessionnum);
					rs = pstmt.executeQuery();
					if ( rs != null ) //IN000000 if Condition added
					{
						while(rs.next())
						{
							or_acc_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
						}
						if(rs != null ) rs.close();
						if(pstmt != null ) pstmt.close();
					}
					System.out.println("CAOpenExternalApplication.jsp-------268----------or_acc_num------->"+or_acc_num);
				}
				
				//IN000000 - Start
				if("".equals(or_acc_num) && !Accessionnum.contains("!"))
				{
					//sql = "select b.ACCESSION_NUM ACCESSION_NUM from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.EXT_IMAGE_OBJ_ID=? and b.CONTR_SYS_EVENT_CODE=? "; //Added to handle performance issue IN000001
					//sql = "select b.ACCESSION_NUM ACCESSION_NUM from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.EXT_IMAGE_OBJ_ID=? and b.CONTR_SYS_EVENT_CODE=? &&PATIENTID## "; //IN050936//commented for IN068797
					sql = "select b.ACCESSION_NUM ACCESSION_NUM from CR_ENCOUNTER_DETAIL##REPDB## b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.EXT_IMAGE_OBJ_ID=? and b.CONTR_SYS_EVENT_CODE=? &&PATIENTID## "; //IN068797
					//IN050936 - Start
					if(!patient_id.equals(""))
					{
						sql = sql.replace("&&PATIENTID##" , " AND b.patient_id = ? ");
					}
					else
					{
						sql = sql.replace("&&PATIENTID##" , " ");
					}	
					//IN050936 - End
					
					sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
					
					System.out.println("CAOpenExternalApplication.jsp-------290----------sql------->"+sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,Histrectype);
					pstmt.setString(2,Contrsysid);
					pstmt.setString(3,Accessionnum);
					pstmt.setString(4,Contrsyseventcode);
					System.out.println("CAOpenExternalApplication.jsp-------296----------Histrectype------->"+Histrectype);
					System.out.println("CAOpenExternalApplication.jsp-------297----------Contrsysid------->"+Contrsysid);
					System.out.println("CAOpenExternalApplication.jsp-------298----------Accessionnum------->"+Accessionnum);
					System.out.println("CAOpenExternalApplication.jsp-------299----------Contrsyseventcode------->"+Contrsyseventcode);
					//Added to handle performance issue IN000001 included IN050936
					if(!patient_id.equals(""))
					{
						pstmt.setString(5,patient_id);
						System.out.println("CAOpenExternalApplication.jsp-------304----------patient_id------->"+patient_id);
					}
					//Added to handle performance issue IN000001 IN050936
					rs = pstmt.executeQuery();
					if ( rs != null ) 
					{
						while(rs.next())
						{
							or_acc_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
						}
						if(rs != null ) rs.close();
						if(pstmt != null ) pstmt.close();
						System.out.println("CAOpenExternalApplication.jsp-------316----------or_acc_num------->"+or_acc_num);
					}
				} //IN000000 - End
				//IN001679 - end
				//sql = "select b.EXT_IMAGE_OBJ_ID object_id, TO_CHAR(B.EVENT_DATE,'DD/MM/YYYY') COMPLETED_DATE, TO_CHAR(B.EVENT_DATE,'HH24:MI:SS') COMPLETED_TIME,  B.PATIENT_ID,(SELECT SHORT_DESC FROM CR_CLN_EVT_MST_LANG_VW WHERE HIST_REC_TYPE=B.HIST_REC_TYPE AND EVENT_CODE=B.EVENT_CODE AND EVENT_CODE_TYPE=B.EVENT_CODE_TYPE and language_id = ? ) EVENT_DESC, B.EVENT_GROUP, B.EVENT_CODE,b.ENCOUNTER_ID from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";//commented for IN068797
				sql = "select b.EXT_IMAGE_OBJ_ID object_id, TO_CHAR(B.EVENT_DATE,'DD/MM/YYYY') COMPLETED_DATE, TO_CHAR(B.EVENT_DATE,'HH24:MI:SS') COMPLETED_TIME,  B.PATIENT_ID,(SELECT SHORT_DESC FROM CR_CLN_EVT_MST_LANG_VW##REPDB## WHERE HIST_REC_TYPE=B.HIST_REC_TYPE AND EVENT_CODE=B.EVENT_CODE AND EVENT_CODE_TYPE=B.EVENT_CODE_TYPE and language_id = ? ) EVENT_DESC, B.EVENT_GROUP, B.EVENT_CODE,b.ENCOUNTER_ID from CR_ENCOUNTER_DETAIL##REPDB## b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";//IN068797
			
				sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,Histrectype);
				pstmt.setString(3,Contrsysid);
				System.out.println("CAOpenExternalApplication.jsp-------328----------locale------->"+locale);
				System.out.println("CAOpenExternalApplication.jsp-------329----------Histrectype------->"+Histrectype);
				System.out.println("CAOpenExternalApplication.jsp-------330----------Contrsysid------->"+Contrsysid);
				if(!"".equals(or_acc_num)) //IN001679 condition added
				{
					pstmt.setString(4,or_acc_num);
					System.out.println("CAOpenExternalApplication.jsp-------334----------or_acc_num------->"+or_acc_num);
				}else
				{
					pstmt.setString(4,Accessionnum);
					System.out.println("CAOpenExternalApplication.jsp-------338----------Accessionnum------->"+Accessionnum);
				}	
				pstmt.setString(5,Contrsyseventcode);
				System.out.println("CAOpenExternalApplication.jsp-------330----------Contrsyseventcode------->"+Contrsyseventcode);
			//	pstmt.setString(6,extimageapplid);
			//	pstmt.setString(7,locale);

			System.err.println("CAOpenExternalApplication.jsp==============>346");
				rs = pstmt.executeQuery();
				System.err.println("CAOpenExternalApplication.jsp==============>348");
				while(rs.next())
				{
					//base_url = rs.getString("base_url")==null?"":rs.getString("base_url");
					object_id= rs.getString("object_id")==null?"":rs.getString("object_id");
					//appl_password= rs.getString("DEFAULT_USER_PASSWORD")==null?"":rs.getString("DEFAULT_USER_PASSWORD");//Changed Commentted 
					//default_user_id=rs.getString("DEFAULT_USER_ID")==null?"":rs.getString("DEFAULT_USER_ID");
					//ext_image_appl_name=rs.getString("EXT_IMAGE_APPL_NAME")==null?"":rs.getString("EXT_IMAGE_APPL_NAME");
					completed_date = rs.getString("COMPLETED_DATE")==null?"":rs.getString("COMPLETED_DATE");
					completed_time = rs.getString("COMPLETED_TIME")==null?"":(rs.getString("COMPLETED_TIME")).trim();
					patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
					event_desc = rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
					event_group = rs.getString("EVENT_GROUP")==null?"":rs.getString("EVENT_GROUP");
					event_code = rs.getString("EVENT_CODE")==null?"":rs.getString("EVENT_CODE");
					ext_image_obj_id = rs.getString("object_id")==null?"":rs.getString("object_id");
					//param_def_str = rs.getString("PARAM_DEF_STR")==null?"":rs.getString("PARAM_DEF_STR");
					encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					//IN001679 - Start Added as completed date time was empty
					completed_datetime.append(completed_date);
					completed_datetime.append(" ");
					completed_datetime.append(completed_time);
					//IN001679 - end
				}
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
			}
			System.err.println("CAOpenExternalApplication.jsp==============>347");
		        tempStr = param_def_str;
		//IN074119
			if (!param_def_str.equals("") && param_def_str.indexOf("~PERFORMING_FACILITY_ID`")>= 0){
		         fac_query = "select performing_facility_id  from OR_ORDER where order_id = (select ORDER_ID FROM or_order_line where EXT_APPL_ACCESSION_NUM = ?)";//IN068797
				pstmt = con.prepareStatement(fac_query);
				pstmt.setString(1,object_id);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					performing_facility_id=rs.getString("PERFORMING_FACILITY_ID")==null ?"":rs.getString("PERFORMING_FACILITY_ID");
				}
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
			}//IN074119
			//7902 starts
			System.err.println("CAOpenExternalApplication.jsp==============>391");
			if (!param_def_str.equals("") && param_def_str.indexOf("~STUDY_ID`")>= 0){
				//41786  Start.
				//fac_query = "select STUDY_ID  from OR_ORDER_LINE##REPDB## where to_char(EXT_APPL_ACCESSION_NUM) = ?";//IN068797
				fac_query = "select STUDY_ID  from OR_ORDER_LINE##REPDB## where EXT_APPL_ACCESSION_NUM = ?";//IN068797
				//41786 End.
				fac_query = fac_query.replaceAll("##REPDB##",RepDb);
				pstmt = con.prepareStatement(fac_query);
				pstmt.setString(1,object_id);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					study_id=rs.getString("STUDY_ID")==null ?"":rs.getString("STUDY_ID");
				}
				if(study_id.equals("null"))
					study_id="";
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
			}//7902 ends
			System.err.println("CAOpenExternalApplication.jsp==============>408");
				if(!param_def_str.equals("")){					
					if (param_def_str.indexOf("~PATIENT_ID`") >= 0){
							param_def_str = param_def_str.replaceAll("~PATIENT_ID`",patient_id);
					}
					// 18243 Start.
					if (param_def_str.indexOf("~LOGIN_USRID`")>= 0){
						if("CPACS".equals(extimageapplid) && isExtAppUserIdEncrypted ){ //21733
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",Encry_login_user);
						}else{
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",login_user);	
						}
					}
					// 18243 End.
					if (param_def_str.indexOf("~ENCOUNTER_ID`")>= 0){
							param_def_str = param_def_str.replaceAll("~ENCOUNTER_ID`",encounter_id);
					}if (param_def_str.indexOf("~ACCESSION_NUM`")>= 0){
							Accessionnum = Accessionnum.replace("$","\\$");
							param_def_str = param_def_str.replaceAll("~ACCESSION_NUM`",Accessionnum);
					}if (param_def_str.indexOf("~FACILITY_ID`")>= 0){
							param_def_str = param_def_str.replaceAll("~FACILITY_ID`",facility_id);
					}if (param_def_str.indexOf("~PERFORMING_FACILITY_ID`")>= 0){
						param_def_str = param_def_str.replaceAll("~PERFORMING_FACILITY_ID`",performing_facility_id);
					}if (param_def_str.indexOf("~EXT_APP_USRPWD`")>= 0){
							param_def_str = param_def_str.replaceAll("~EXT_APP_USRPWD`",appl_password);
					}if (param_def_str.indexOf("~EXT_APP_USRID`")>= 0){
							param_def_str = param_def_str.replaceAll("~EXT_APP_USRID`",default_user_id);
					}if (param_def_str.indexOf("~COMPLETED_DATE`")>= 0){
						//IN072022 Start.
						if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat ){
							completedDateTime = df.parse(completed_datetime.toString().trim());
							param_def_str = param_def_str.replaceAll("~COMPLETED_DATE`",formatter1.format(completedDateTime));
						}else
						//IN072022 End.
							param_def_str = param_def_str.replaceAll("~COMPLETED_DATE`",completed_date);
					}if (param_def_str.indexOf("~COMPLETED_DATETIME`")>= 0){						
							param_def_str = param_def_str.replaceAll("~COMPLETED_DATETIME`",(completed_datetime.toString()).trim());
					}if (param_def_str.indexOf("~COMPLETED_TIME`")>= 0){
						//IN072022 Start.
						if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat){
							completedDateTime = df.parse(completed_datetime.toString().trim());
							param_def_str = param_def_str.replaceAll("~COMPLETED_TIME`",URLEncoder.encode(formatter2.format(completedDateTime),"UTF-8"));
						}else
						//IN072022 end.
							param_def_str = param_def_str.replaceAll("~COMPLETED_TIME`",completed_time);
					}if (param_def_str.indexOf("~OBJECT_REF`")>= 0){
							param_def_str = param_def_str.replaceAll("~OBJECT_REF`",object_id);
					}if (param_def_str.indexOf("~STUDY_ID`")>= 0){//7902
						param_def_str = param_def_str.replaceAll("~STUDY_ID`",study_id.trim());//7902
					} 
					// 18243 Start.
					if (param_def_str.indexOf("~LOGIN_USRID`")>= 0){
						if("CPACS".equals(extimageapplid) && isExtAppUserIdEncrypted ){  //21733
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",Encry_login_user);
						}else{
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",login_user);
						}
					}
					// 18243 End.
		//}
		}
		
	    if(base_url.equals(""))
		{
			
			out.println("<script>alert(getMessage('URL_CHECK','CA')+'  "+ext_image_appl_name+"')</script>");
			
		}
		else
		{
			if (base_url.indexOf("~PATIENT_ID`") >= 0){
					base_url = base_url.replaceAll("~PATIENT_ID`",patient_id);
			}
			if (base_url.indexOf("~ENCOUNTER_ID`")>= 0){
					base_url = base_url.replaceAll("~ENCOUNTER_ID`",encounter_id);
			}
			if (base_url.indexOf("~ACCESSION_NUM`")>= 0){
					Accessionnum = Accessionnum.replace("$","\\$");
					base_url = base_url.replaceAll("~ACCESSION_NUM`",Accessionnum);
			}
			if (base_url.indexOf("~FACILITY_ID`")>= 0){
					base_url = base_url.replaceAll("~FACILITY_ID`",facility_id);
			}
			if (base_url.indexOf("~EXT_APP_USRPWD`")>= 0){
					base_url = base_url.replaceAll("~EXT_APP_USRPWD`",appl_password);
			}
			if (base_url.indexOf("~EXT_APP_USRID`")>= 0){
					base_url = base_url.replaceAll("~EXT_APP_USRID`",default_user_id);					
			}
			// 18243 Start.
			if (base_url.indexOf("~LOGIN_USRID`")>= 0){
				if("CPACS".equals(extimageapplid) && isExtAppUserIdEncrypted ){ //21733
					base_url = base_url.replaceAll("~LOGIN_USRID`",Encry_login_user);	
				}else{
					base_url = base_url.replaceAll("~LOGIN_USRID`",login_user);	
				}
			}
			// 18243 End.
			if (base_url.indexOf("~COMPLETED_DATE`")>= 0){
				//IN072022 Start.
				if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat){
					completedDateTime = df.parse(completed_datetime.toString().trim());
					base_url = base_url.replaceAll("~COMPLETED_DATE`",formatter1.format(completedDateTime));
				}else
				//IN072022 End.
					base_url = base_url.replaceAll("~COMPLETED_DATE`",completed_date);
			}if (base_url.indexOf("~COMPLETED_DATETIME`")>= 0){
					base_url = base_url.replaceAll("~COMPLETED_DATETIME`",(completed_datetime.toString()).trim());
			}if (base_url.indexOf("~COMPLETED_TIME`")>= 0){
				//IN072022 Start.
				if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat){					
					completedDateTime = df.parse(completed_datetime.toString().trim());
					base_url = base_url.replaceAll("~COMPLETED_TIME`",URLEncoder.encode(formatter2.format(completedDateTime),"UTF-8"));
				}else
				//IN072022 End.
					base_url = base_url.replaceAll("~COMPLETED_TIME`",completed_time);
			}if (base_url.indexOf("~OBJECT_REF`")>= 0){
					base_url = base_url.replaceAll("~OBJECT_REF`",object_id);
			}
			
			if(extimageapplid.equals("MSWLR"))
			{
				if (base_url.indexOf("?")>0)
					base_url=base_url +"&";
				else
					base_url=base_url+"?";
				//base_url=base_url+object_id;
				base_url = base_url+param_def_str;
			}
			else if(extimageapplid.equals("MSYS"))
			{
				//base_url=base_url+"?,,I,"+object_id+",,,1,,0";
				base_url = base_url+"?,,I,"+param_def_str+",,,1,,0";
			}
			else
			{
				if (base_url.indexOf("?")>0)
					base_url=base_url +"&";
				else
					base_url=base_url+"?";
			}
			
			System.out.println("CAOpenExternalApplication.jsp------------------------>"+extimageapplid);
			if(extimageapplid.equals("GEECG"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>484");
					base_url = base_url+param_def_str;
					//base_url.replaceAll("\\n","");
					//base_url = base_url.trim();
			%>
			<script>
				
				        var ImageUrl = '<%=base_url%>';
						var retVal;
						var window_name = '<%=extimageapplid%>';     //"<%=extimageapplid%>";
						retVal = window.open(ImageUrl,window_name,' height= 725, width= 1010,left = 0, top=0, status=yes,toolbar=yes');
								
			</script>
			<%
			}else if(extimageapplid.equals("MSYS"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>500");
               base_url = base_url+param_def_str;
			%>
			<script>
				var ImageUrl = '<%=base_url%>';		
						var retVal;
						var window_name = '<%=extimageapplid%>';    
						retVal = window.open(ImageUrl,window_name,' height= 725, width= 1024,left = 0, top=0, status=yes,toolbar=yes,fullscreen=no,location=no,resize=yes');
								
			</script>
			<%
			}else if(extimageapplid.equals("GEPAC"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>513");
				out.println("<script>");
				
					//String ImageUrl = "../../eCA/jsp/CAShowImage.jsp?object_id="+object_id;			
					
					String ImageUrl = base_url+param_def_str;
						
						try
						{								
							// file = new File(config.getServletContext().getRealPath("/")+"eCA/images/" + object_id); checkstyle
						//boolean exists = file.exists();	//Checkstyle 4.0 Beta 6
							
							if (ImageUrl.equals(""))
							{
								out.println("alert('IMG001 - Result image does not exist in the application library area')");
							}else{
							
								String window_name = extimageapplid;    
								////IN074137 Start. 
								if(!isExtAppModelWindow){
									if(!isExtAppNewWindow){
										//out.println("window.open('"+ImageUrl+"','"+window_name+"','height=screenHeight,width=screenWidth,resizable=yes, status=yes, toolbar=yes,fullscreen=yes,location=no')");//Commented for IN068038
										%>			
											var ImageUrl ='<%=ImageUrl%>'; 																		
											var screenHeight=screen.height;
											var screenWidth=screen.width;
											var features ="location=0,height="+screenHeight+",width="+screenWidth+",top=0,left=0,resizable=yes";
											var retVal;
											var window_name = '<%=extimageapplid%>'; 
											window.open(ImageUrl,window_name,features);												
					
										<%									
									}else{
										%>			
											var ImageUrl ='<%=ImageUrl%>'; 									
											var oShell = new ActiveXObject("WScript.Shell");
											oShell.Run('iexplore.exe ' +ImageUrl , 1);
					
										<%
									}
								}else
								//IN074137 end.
								out.println("retVal = window.showModalDialog('"+ImageUrl+"','','dialogHeight:100; dialogWidth:100;resizable=yes;scroll=yes; status=no;')");//Modified for IN068038
							}
						}
						catch (IOException io)
						{
							io.printStackTrace();
						}	
					
					
						
						
								
			out.println("</script>");
			%>
			<%
			}
			else if(extimageapplid.equals("MSWLR"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>554");
                base_url = base_url+param_def_str;
			%>
			<script>
				invokeFun('<%=base_url%>');	
			</script>	
			<%
			}
			else if(extimageapplid.equals("RLWP"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>564");
				facility_id = "";
				String specimen_no = "";
				String template_name = "";
				int cnt = 0;
				StringTokenizer str = new StringTokenizer(ext_image_obj_id,"@");
				facility_id = str.nextToken();
				specimen_no = str.nextToken();

				//String sql1 = "select TEMPLATE_NAME from RL_OLE_RESULT_TEXT where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ?";//commented for IN068797
				String sql1 = "select TEMPLATE_NAME from RL_OLE_RESULT_TEXT##REPDB## where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ?";//IN068797

				sql1 = sql1.replaceAll("##REPDB##",RepDb);//IN068797
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,specimen_no);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,event_group);
				pstmt.setString(5,event_code);

				rs = pstmt.executeQuery();

				while(rs.next())
				{
					cnt = cnt + 1;
					template_name = rs.getString(1) == null ? "" : rs.getString(1);
				}
				if(cnt == 1)
				{
			%>
					<script>
						var HTMLVal="<html><body onKeyDown='lockKey()'><form name='OpenDocForm' id='OpenDocForm' method='get' action='../../eCA/jsp/ViewLabWordResultData.jsp'>"+
						"<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>"+
						"<input type='hidden' name='event_code' id='event_code' value='<%=event_code%>'>"+
						"<input type='hidden' name='event_group' id='event_group' value='<%=event_group%>'>"+
						"<input type='hidden' name='event_desc' id='event_desc' value='<%=event_desc%>'>"+
						"<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>"+
						"<input type='hidden' name='specimen_no' id='specimen_no' value='<%=specimen_no%>'>"+
						"<input type='hidden' name='template_name' id='template_name' value='<%=template_name%>'>"+
						"</form></body></html>";
						document.body.insertAdjacentHTML('afterbegin', HTMLVal);
						document.OpenDocForm.submit();
					</script>
			<%
				}
				else if(cnt > 1)
				{
			%>
			<script>
					var retVal;
					var window_name = '<%=extimageapplid%>';  
					retVal = window.open('../../eCA/jsp/ViewLabWordResultMain.jsp?patient_id=<%=patient_id%>&event_code=<%=event_code%>&event_group=<%=event_group%>&event_desc=<%=event_desc%>&facility_id=<%=facility_id%>&specimen_no=<%=specimen_no%>',window_name,' height= 200, width= 350,left = 350, top=150, location=no,menubar=yes,status=yes,toolbar=yes,resizable=no');
			</script>
			<%
				}
			}
			else if(extimageapplid.equals("AGFAM"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>620");
               base_url =base_url+param_def_str;
			%>
			<script>
				var ImageUrl = '<%=base_url%>';
			//'<%=base_url%>patientid=<%=patient_id%>&accession=<%=object_id%>&user=<%=default_user_id%>&password=<%=appl_password%>';
						


						var retVal;
						var window_name = '<%=extimageapplid%>';     //"<%=extimageapplid%>";
						retVal = window.open(ImageUrl,window_name,' height= 725, width= 1024,left = 0, top=0, status=yes,toolbar=yes,fullscreen=no,location=no,resize=yes');
								
			</script>
			<%
			}
			else if(extimageapplid.equals("RDPAC"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>640");
				base_url =base_url+param_def_str;
				%>
			<script>
				var ImageUrl ='<%=base_url%>';  
				var screenHeight=screen.height;
				var screenWidth=screen.width;
				var features ="location=0,height="+screenHeight+",width="+screenWidth+",top=0,left=0,resizable=yes";
		
				var retVal;
				var window_name = '<%=extimageapplid%>';     //"<%=extimageapplid%>";
				//retVal = window.open(ImageUrl,window_name,' height= 725, width= 1020,left = 0, top=0, status=yes,toolbar=yes,resize=yes');
				window.open(ImageUrl,window_name,features);
								
			</script>
				<%
			}
			else 
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>654");
				base_url =base_url+param_def_str;
				%>
			<script>
				var ImageUrl ='<%=base_url%>';  //"<%=base_url%>un=<%=default_user_id%>&pw=<%=appl_password%>&ris_exam_id=<%=object_id%>";
						var retVal;
						var window_name = '<%=extimageapplid%>';     //"<%=extimageapplid%>";
						var screenHeight=screen.height;
						var screenWidth=screen.width;
						var features ="location=0,height="+screenHeight+",width="+screenWidth+",top=0,left=0,status=yes,toolbar=yes,resize=yes";
						//retVal = window.open(ImageUrl,window_name,' height= 725, width= 1020,left = 0, top=0, status=yes,toolbar=yes,resize=yes');
						retVal = window.open(ImageUrl,window_name,features);
								
			</script>
				<%
			}
		
	}
	}
	%>

</body>
</html>
<%
}

catch(Exception e)
{
	//out.println("Exception @ CAOpenExternalApplication.jsp "+e.toString());//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

	if (con != null)ConnectionManager.returnConnection(con,request);
}



 
%>

