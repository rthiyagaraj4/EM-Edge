<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?				100				?           	created
20/07/2012		IN033881		Dinesh T		Addendum data is not appearing in the multifacility scenario
03/06/2013		IN040265		Ramesh G		Issue 1: At print preview the addendum details displayed as "Addendum Created by"  instead of "Addendum Recorded by"
												Issue 2: Addendum details  displayed twice.
03/06/2013		IN040266		Ramesh G		Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.
												Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.
												Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.
												
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
08/01/2015	IN052791		Ramesh G		08/01/2015		Akbar S			Normally user types and enters keyboard after every sentence in long text field. 
																			On previewing the clinical notes, there is no space between sentences .
05/05/2015	IN053298		Ramesh G	05/05/2015		Akbar S			When we attach an image to the clinical note part of the image is not displayed.
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064
06/09/2019	IN071335	   	Ramesh G										Common-ICN-0012
21/10/2019	IN071569		Ramesh G									ML-MMOH-SCF-1389
05/05/2020	IN071865	SIVABAGYAM M		05/05/2020		RAMESH G		ML-MMOH-CRF-1484 
22/06/2020	IN073100		SIVABAGYAM M		22/06/2020		RAMESH G		ML-MMOH-SCF-1541
18/11/2020	7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
21/08/2023  48833           Srinivasa N T        22/08/2023    Ramesh Goli    
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.io.*,javax.xml.transform.*,java.awt.image.BufferedImage,javax.imageio.ImageIO,sun.misc.BASE64Decoder" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	//StringBuffer traceBeanOBJ = new StringBuffer();

	//traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSectionView.jsp at 10  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("encounter_id")+"**patient_id**"+request.getParameter("patient_id")+"**");

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	
	/*IN066793 starts*/
	boolean sitespecific=false;
	Connection	 conn=null;
	try
	{
		 conn	= ConnectionManager.getConnection(request);
		sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
	}
	catch(Exception e)
	{
		out.println("Exception@111 - in getting header_appl_yn : "+e);
		
	}
	finally
	{
		if(conn!=null)	ConnectionManager.returnConnection(conn,request);
	}
	
	
	/*IN066793 ends*/
%>

<html>
<title>RecClinicalNotesSectionView</title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
if(sitespecific)
{	
%>	
<style>
	ADDRESS	{ 
		
		FONT-FAMILY: Segoe UI ;
		FONT-SIZE: 10pt ; 
		FONT-STYLE: NORMAL; 
		COLOR: BLACK; 
	}
</style>
<%
}
else
{	
%>
<style>
	ADDRESS	{ 
		/* IN043895 Start.*/
		/*FONT-FAMILY: Verdana ;*/
		/* IN049424 Start.*/
			/*FONT-FAMILY: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS" ;*/
			FONT-FAMILY: Verdana ;
		/* IN049424 End.*/
		/* IN043895 End.*/
		FONT-SIZE: 10pt ; 
		FONT-STYLE: NORMAL; 
		COLOR: BLACK; 
	}
</style>
<%
}
%>
</head>

 <body onLoad="sectionRefReset()" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<!-- <body onLoad="sectionRefReset()" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<form name = "RecClinicalNotesSectionViewForm">
<%

	java.sql.Connection			con		=	null;
	java.sql.PreparedStatement	pstmt		=	null;
	java.sql.PreparedStatement	stmt		=	null;
	java.sql.ResultSet			rs			=	null;
	java.sql.ResultSet			rs1			=	null;//IN071865
	java.sql.ResultSet			rs2			=	null;//Exception-PMG2020-COMN-CRF-0085
	java.sql.ResultSet			rset		=	null;
	java.sql.PreparedStatement	pstmt1		=	null;//IN071865
	java.sql.PreparedStatement	pstmt2		=	null;//Exception-PMG2020-COMN-CRF-0085
	StringBuffer imageFunctionNames = new StringBuffer() ;
	
	String		query_section_details		=	"";
	String		prev_sec_hdg_code			=	"";
	String 		prev_note_type_desc="";//IN073100
	String		sec_hdg_code					="";
	String		sec_hdg_desc					="";
	String		sec_content_type				="";
	String		child_sec_hdg_desc			="";
	String		child_sec_hdg_code			="";
	String		child_sec_content_type		="";
	String		preserve_format_yn			="";
	String		sys_date_time					="";
	String		image_linked_yn				="";
	String		note_type							="";
	String		section_content				="";
	String		section_image_content		="";
	String 		section_image_height		= "400";	//IN053298
	String		sub_sec_hdg_type 			="";
	String		editor_title			 	="";
	String		strAddendumText				=""; 
	String		clinician_name				="";											
	String		facility_id					=""; 
	String		accession_num				="";
	String		patient_id					= "",			encounter_id			=	"";
	// IN071335 Changes Start.
	//String		url					= HttpUtils.getRequestURL(request).toString();
	String 		url					= application.getRealPath("/eCA")+"/";
	// IN071335 Changes End.
	String		url1				= "";
	String		url2				= "";
	String output_yn =  "";
	String sec_hdg_code_out =  "";
	String child_sec_hdg_code_out =  "";
	
	
	String appl_task_id =  "";
	String multi_sec_hdg_code =  "";
	String multi_child_sec_hdg_code =  "";
	String sql =  "";
	String strVal =  "";
	StringTokenizer Tokens = null ;
	String histRectype ="", contrSysId ="", accessionNum="", Contrsyseventcode="";
	StringBuffer displaydata = new StringBuffer();
	StringBuffer section_content_buff = new StringBuffer();
	//String remVal ="";
	String sort_by ="";
	String result_disp ="";
	String hist_rec_type_desc ="";
	String event_date_time ="";
	String hist_rec_type_desc_prev ="";
	String sec_hdg_code_al ="";
	String selection_type ="";
	String noteCopiedYN = "N";//IN068105
	String note_type_desc="";//IN071865
	String display_note_description="";//7605

try {
	// IN071335 Changes Start.
	//url		=		url.substring(0,url.indexOf("jsp/"));
	// IN071335 Changes End.
	/*IN066793 starts*/
	if(sitespecific)
		url1	=		url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
	else
		url1	=		url + "html/RecClinicalNotesTemplateDispayView.xsl";
	/*IN066793 ends*/
	url2		=		url+"html/RecClinicalNotesOutputFormDisplay.xsl";
	/*IN066793 starts*/
	if(sitespecific)
		url		=		url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
	else
		url		=		url+"html/RecClinicalNotesTemplateSentenceView.xsl";
	/*IN066793 ends*/

	editor_title = "Notes View";

	accession_num	=	request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	facility_id		=	(String)session.getValue("facility_id");
	clinician_name	=	(String)session.getValue("practitioner_name");
	note_type		=	request.getParameter("note_type")==null?"":request.getParameter("note_type");
	noteCopiedYN	=	request.getParameter("noteCopiedYN")==null?"":request.getParameter("noteCopiedYN");//IN068105

	patient_id		=	checkForNull( request.getParameter("patient_id"));
	encounter_id	=	checkForNull( request.getParameter("encounter_id"));
	appl_task_id	=	checkForNull( request.getParameter("appl_task_id"));
	multi_sec_hdg_code	=	checkForNull( request.getParameter("multi_sec_hdg_code"));
	multi_child_sec_hdg_code	=	checkForNull( request.getParameter("multi_child_sec_hdg_code"));
	selection_type	= request.getParameter("selection_type")==null?"S":request.getParameter("selection_type");
	if( selection_type.equals(""))
	{
		selection_type="S";
	}
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

	try
	{
		con = ConnectionManager.getConnection(request);
		// moved to separate starts
		//IN071865 starts
		
					String head_foot_qry ="select a.NOTE_TYPE_DESC,a.NOTE_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
					
					pstmt1	= con.prepareStatement(head_foot_qry);
					pstmt1.setString(1,note_type);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){	
						note_type_desc   = rs1.getString("NOTE_TYPE_DESC")==null?"":rs1.getString("NOTE_TYPE_DESC");
					}//IN071865 ends
					//Exception-PMG2020-COMN-CRF-0085  7605 starts
					
					String disp_noteDesc ="select DISP_NOTE_DESC from ca_note_param";
					
					pstmt2	= con.prepareStatement(disp_noteDesc);
					rs2 = pstmt2.executeQuery();
					while(rs2.next()){	
						display_note_description   = rs2.getString("DISP_NOTE_DESC")==null?"":rs2.getString("DISP_NOTE_DESC");
					}//Exception-PMG2020-COMN-CRF-0085  7605 ends

		if(appl_task_id.equals("PAT_MEDICAL_REPORT")&&selection_type.equals("M"))
		{
			

		ArrayList list = manageEmailBean.returnSortList();
		int listSize = list.size();

		HashMap multiList = manageEmailBean.returnHashMap();

		ArrayList listLocal = new ArrayList();
		for(int k=0;k<listSize;++k)
			{
				listLocal.add((String)multiList.get((String)list.get(k)));
			}
		
		//Collections.sort(list);
		if(!listLocal.isEmpty())
			{
				Collections.sort(listLocal);

			}
		
				

		sql = " SELECT B.HIST_DATA,A.HIST_DATA_TYPE FROM CR_ENCOUNTER_DETAIL A, CR_ENCOUNTER_DETAIL_TXT B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";

		for(int i=0; i<listSize; i++)
		{
			//strVal = (String)list.get(i);
			strVal = (String)listLocal.get(i);
			Tokens = new StringTokenizer(strVal,"~");

		   while(Tokens.hasMoreTokens())
		   {
			 sort_by = (String) Tokens.nextToken();
			if(sort_by.equals("D"))
			{
				event_date_time=(String) Tokens.nextToken();
			}
			histRectype = (String) Tokens.nextToken();
			contrSysId = (String) Tokens.nextToken();
			accessionNum = (String) Tokens.nextToken();
			Contrsyseventcode = (String) Tokens.nextToken();
			result_disp = (String) Tokens.nextToken();
			hist_rec_type_desc = (String) Tokens.nextToken();
			if(sort_by.equals("C"))
			{
				event_date_time=(String) Tokens.nextToken();
			}
			sec_hdg_code_al = (String) Tokens.nextToken();
			}

			if(multi_sec_hdg_code.equals(sec_hdg_code_al)){
				
			if( !(hist_rec_type_desc_prev.equals(hist_rec_type_desc)))
			{
				
				//section_content_buff.append("<table border=0 cellspacing=0 width='100%' cellpadding='3' align='center' style='font-family:Verdana'><tr><td style='background-color:#ADADAD;' colspan=3><font style='FONT-SIZE:13pt;font-weight:bold;'><u> "+hist_rec_type_desc+" </u></font></td></tr>");
				section_content_buff.append("<table border='0' cellspacing='0' width='100%' cellpadding='3' align='center' style='font-family:Verdana'><tr><td style='background-color:#ADADAD;' colspan='3'><font style='FONT-SIZE:13pt;font-weight:bold;'><u> "+hist_rec_type_desc+" </u></font></td></tr>");

			}

			if(result_disp.equals("&amp;nbsp;"))
				result_disp="";
			section_content_buff.append("<tr> <td colspan=3>");
			section_content_buff.append(result_disp);
			section_content_buff.append("</td></tr></table>");


			//section_content.append("<table border=0 cellspacing=0 width='100%' cellpadding='3' align='center' style='font-family:Verdana'><tr><td style='background-color:#ADADAD;' colspan=3><font style='FONT-SIZE:13pt;font-weight:bold;'><u> "+hist_rec_type_desc+" </u></font></td></tr>");	
			
			//section_content.append("<tr> <td colspan=3>");
		   //section_content.append(result_disp);
			//section_content.append("</td></tr></table>");
							


			stmt = con.prepareStatement(sql);
			stmt.setString(1, histRectype);
			stmt.setString(2, contrSysId);
			stmt.setString(3, accessionNum);
			stmt.setString(4, Contrsyseventcode);

			rset = stmt.executeQuery();

			if(rset.next())
			{
				Clob note=rset.getClob("HIST_DATA");
				//hist_data_type = rset.getString("HIST_DATA_TYPE");

				displaydata = new StringBuffer();
				if(note!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) displaydata.append(line+"\n");
				}
			}
			
			section_content_buff.append(displaydata);
			hist_rec_type_desc_prev = hist_rec_type_desc ;
			displaydata.delete(0,displaydata.length());
							
			/*}
			else
				{
					section_content="";
				} */
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
			}// sec_hdg_code compa
			}// end of if  listsize
			//manageEmailBean.clearBean();
			
			section_content = section_content_buff.toString();
			section_content	= section_content.replace("<P>","<ADDRESS>");   //IN040265,IN040266
			section_content	= section_content.replace("</P>","</ADDRESS>"); //IN040265,IN040266
			section_content_buff.delete(0,section_content_buff.length());
				
			if(!section_content.equals("")&&!multi_sec_hdg_code.equals(""))
			{	
				sectionBean.setSectionContent(multi_sec_hdg_code,multi_child_sec_hdg_code,section_content);
			}

		} 

		
		
		//end of appl_task_id






			//moved sep ends....


//		query_section_details = " select sec_hdg_code, sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, nvl(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code , child_sec_hdg_desc, nvl(child_sec_content_type,sec_content_type) child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, image_linked_yn, PRESERVE_FORMAT_YN from ca_note_section_view where note_type = ? order by note_sec_seq_num, child_seq_num ";

		query_section_details = "select sec_hdg_code,case when ? = 'en' then replace(sec_hdg_desc,'''','') else replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc,sec_content_type,sec_result_linked_rec_type,NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN '' ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') end end child_sec_hdg_desc ,nvl(child_sec_content_type,sec_content_type ) child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, IMAGE_LINKED_YN,preserve_format_yn from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num";

		pstmt		=	con.prepareStatement(query_section_details);

		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,note_type);

		rs			=	pstmt.executeQuery();

		webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

		String strKey	=	"";

		strKey = patient_id + "~"+ encounter_id;
		strKey = strKey.trim();

		sectionBean.getPatientSection(strKey);

		

		while(rs.next())
		{
				section_content				= "";
				section_image_content		= "";
				section_image_height		= "400";	//IN053298
				sec_hdg_code				=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc				=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type			=	checkForNull( rs.getString("sec_content_type") );
				child_sec_hdg_desc			=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_hdg_code			=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_content_type		=	checkForNull( rs.getString("child_sec_content_type") );
				preserve_format_yn			=	checkForNull( rs.getString("PRESERVE_FORMAT_YN") );  
				sys_date_time				=	rs.getString("sys_date_time");
				sub_sec_hdg_type			= (String)sectionBean.getSectionLevel(sec_hdg_code,child_sec_hdg_code);
				image_linked_yn				= (String)sectionBean.getImageLinked(sec_hdg_code,child_sec_hdg_code);
				
					

				try
				{  
					output_yn = sectionBean.getOutputExistYN(sec_hdg_code,child_sec_hdg_code);

					sec_hdg_code_out = sec_hdg_code+"_out";
					child_sec_hdg_code_out = child_sec_hdg_code+"_out";

					if("Y".equals(output_yn))//IN071264
					{

					section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code_out,child_sec_hdg_code_out), "&nbsp;" );						
					}
					else
					{					
							//section_content = (String)sectionBean.getSectionContent("BLNK","BLNK");
							
							section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code.trim(),child_sec_hdg_code.trim()), "&nbsp;" );							

					//		traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSectionView.jsp at 455  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("encounter_id")+"**patient_id**"+request.getParameter("patient_id")+"** sec_hdg_code  **"+sec_hdg_code.trim()+"** hild_sec_hdg_code   **"+child_sec_hdg_code.trim()+"**  section_content  **"+section_content+"**");
							
						//}//end of appl_task_id . */
					}//end of output_yn

					if(child_sec_content_type.equals("T"))
					{
						if(!(section_content.equals("&nbsp;")))
						{
/*
								sbResult.delete(0,sbResult.length());
								sbResult.append(section_content);
								eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,child_sec_hdg_code,locale,sbResult);
								sbResult = tempLangParse.getLangReplacedXML();
								section_content = sbResult.toString();
								tempLangParse = null;
*/
						
						if("Y".equals(output_yn))//IN071264
						{
							section_content=converter.buildHTMLFromXML(section_content,url2);
							section_content = section_content.replaceAll("&lt;","<"); //SS-SCF-0773
							section_content = section_content.replaceAll("&gt;",">");//SS-SCF-0773
							section_content = section_content.replaceAll("&amp;","&");//SS-SCF-0773
						}
						else
						{
							section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
							// Start.
							section_content = section_content.replaceAll("&lt;","<");
							section_content = section_content.replaceAll("&gt;",">");
							section_content = section_content.replaceAll("&amp;","&");
							//IN052791 Start.
								//section_content = section_content.replaceAll("<br>","");
								//section_content = section_content.replaceAll("<BR>","");
							//IN052791 End.
							// End.
				//			traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSectionView.jsp at 478  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("encounter_id")+"**patient_id**"+request.getParameter("patient_id")+"** section_content  **"+section_content+"**");
						}
						}
					}
					else
					{
						if(null!=image_linked_yn && !image_linked_yn.equals("")  && image_linked_yn.equals("Y")){//IN071264
							section_image_content = checkForNull((String) sectionBean.getSectionImageContent(sec_hdg_code,child_sec_hdg_code),"");
							//IN053298 Start.
							section_image_height  = checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"");  
							if("".equals(section_image_height) && !"".equals(section_image_content)){ 
								BASE64Decoder decoder = new BASE64Decoder();
								byte[]  imageByte = decoder.decodeBuffer(section_image_content);
								ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
								BufferedImage bimg = ImageIO.read(bis);
								section_image_height         = String.valueOf(bimg.getHeight());
								sectionBean.setSectionImageHeight(sec_hdg_code,child_sec_hdg_code,section_image_height);
							}
							//IN053298 End.
						}
					}

					if( (!(section_content.equals("&nbsp;")) && !(section_content.equals(""))  ) ||
						(!(section_image_content.equals("&nbsp;")) && !(section_image_content.equals(""))  )
					)
					{
						if(prev_sec_hdg_code.equals("") || !prev_sec_hdg_code.equals(sec_hdg_code))
						{
							%>
								<!--<table border=0 cellspacing=0 width="100%" cellpadding='3' align='center' style="font-family:Verdana">
								<tr><td style="background-color:#ADADAD;" colspan=3>-->
								<table border='0' cellspacing='0' width="100%" cellpadding='3' align='center' style="font-family:Verdana">
								<%
								//7605
								if(display_note_description.equals("Y")){
								if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){ //IN073100%>
								<tr><td style="background-color:#ADADAD;" colspan='3'>
								<font style="FONT-SIZE:14pt;font-weight:bold;"><u><%=note_type_desc%></u></font></td></tr><!--IN071865-->
								 <%prev_note_type_desc=note_type_desc;//IN073100
								 }//7605
								 }%>
								<tr><td style="background-color:#ADADAD;" colspan='3'>
								<font style="FONT-SIZE:14pt;font-weight:bold;"><u><%=sec_hdg_desc%></u></font></td></tr>
								
							<%
								prev_sec_hdg_code = sec_hdg_code;
						}
						if(sub_sec_hdg_type.equals("S"))
						{
						%>
							<tr>
								<!-- <td style="background-color:#ADADAD;" colspan=3> -->
								<td style="background-color:#ADADAD;" colspan='3'>
									<font style="FONT-SIZE 13pt;font-weight:bold;"><u><i><%=child_sec_hdg_desc%></i></u></font>
								</td>
							</tr>
						<%
						}
					}
					
					if ( !(section_content.equals("&nbsp;")) && !(section_content.equals("")))
					{
						section_content = section_content.replaceAll("<([^>]*)></\\1>", "");  //IN043895							
						
			//			traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSectionView.jsp at 519  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("encounter_id")+"**patient_id**"+request.getParameter("patient_id")+"** section_content  **"+section_content+"**");
					
						section_content = section_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
						%>
							<tr>
							
							<td colspan="3"><%=section_content%></td></tr>
						<%
					}

					if(null!=image_linked_yn && image_linked_yn.equals("Y") && (!section_image_content.equals("")))//IN071264
					{
				%>		<tr><td colspan="3">
						<applet name="<%=sec_hdg_code + child_sec_hdg_code%>" code="Drawing.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="845" height="<%=section_image_height%>" align="baseline" >
							<param name="canDraw" value="0">	
							<param name="jpeg_quality" value="50">
							<param name="image" value="<%=section_image_content%>"> 
						</applet> 
<!--
							<script>
											var hiddenVarName = "";
											hiddenVarName = "img_<%=sec_hdg_code%>_<%=child_sec_hdg_code%>";

											if(hiddenVarName != "")
											{
												var hiddenVar = eval("parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+ hiddenVarName );
												<%
												imageFunctionNames.append("showImage"+sec_hdg_code+ child_sec_hdg_code+"();\n");
												%>
											}

											function showImage<%=sec_hdg_code + child_sec_hdg_code%>( ) 
											{
												var hiddenVarName1 = "img_<%=sec_hdg_code%>_<%=child_sec_hdg_code%>";
											
												//if(hiddenVarName1 != "")
												//	var hiddenVar1 = eval("parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+hiddenVarName1 );
											
												while (parent.RecClinicalNotesSecDetailsFrame.document.applets["<%=sec_hdg_code + child_sec_hdg_code%>"].GetImageType() == null ) ;	
													parent.RecClinicalNotesSecDetailsFrame.document.applets["<%= sec_hdg_code + child_sec_hdg_code%>"].SetImage(eval("parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm." +hiddenVarName1+ ".value"));
											}
										</script> 
										-->
				<%
					}
					else
					{
						if(!(section_content.equals("&nbsp;")))
						{
							%>
									</td></><tr><td font style="COLOR:NAVY">&nbsp;</td></tr>
							<%
						}
					}
	
					strAddendumText = checkForNull(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code),"");

					if(!strAddendumText.equals("") )
					{
						strAddendumText = replaceSpecialChars(strAddendumText);
						//out.println("<tr><td><table border=0 cellspacing=0 cellpadding ='3' align='center' width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' colspan='8' style=\"font-family:Verdana;font-size:9pt;\" ><I>Addendum Created By : "+clinician_name+",<fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+sys_date_time+"</I></td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >" + strAddendumText+"</td></tr></table></td></tr>");
						out.println("<tr><td><table border='0' cellspacing='0' cellpadding ='3' align='center' width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' colspan='8' style=\"font-family:Verdana;font-size:9pt;\" ><I>Addendum Created By : "+clinician_name+",<fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+sys_date_time+"</I></td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >" + strAddendumText+"</td></tr></table></td></tr>");
					}
			}
			catch(Exception e)
			{			
				e.printStackTrace();
			}
		}
		
		converter=null;		
//Ramesh Start.
	}catch(TransformerConfigurationException etc){
		System.err.println("RecClinicalNotesSectionView.jsp---->TransformerConfigurationException in XMLtoHTML");
	}catch(TransformerException etx){
		System.err.println("RecClinicalNotesSectionView.jsp----->TransformerException in XMLtoHTML");
	}catch(FileNotFoundException efn){
		System.err.println("RecClinicalNotesSectionView.jsp---->FileNotFoundException in XMLtoHTML");		
	}
//Ramesh End.
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{

	}
	try
	{
		//String sqlAddendum = "select ADDENDUM_TEXT, b.PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_note_addendum a, AM_PRACTITIONER b where a.FACILITY_ID =? and ACCESSION_NUM=? and a.PRACTITIONER_ID = b.PRACTITIONER_ID ";
		//String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from 	ca_encntr_note_addendum a where a.FACILITY_ID =? and ACCESSION_NUM=?";//IN033881
		//IN071569 Start.
		//String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from 	ca_encntr_note_addendum a where ACCESSION_NUM=?";
		String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss'),ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE from 	ca_encntr_note_addendum a where ACCESSION_NUM=?";
		//IN071569 End.
		pstmt = con.prepareStatement(sqlAddendum);//IN033881

		pstmt.setString(1,locale);//IN033881
		//pstmt.setString(2,facility_id);//IN033881
		pstmt.setString(2,accession_num);//IN033881
		rs=pstmt.executeQuery();

		String addendumText		= "";
		String practName		= "";
		String addedDate		= "";

		while(rs.next())
		{
			//IN071569 Start.
			//addendumText	= rs.getString(1)==null?"":rs.getString(1);
			if("CLOB".equals((String)rs.getString(6)))
				addendumText	= rs.getString(5)==null?"":rs.getString(5);
			else
				addendumText	= rs.getString(1)==null?"":rs.getString(1);
			//IN071569 end.
			practName		= rs.getString(2)==null?"":rs.getString(2);
			addedDate		= rs.getString(4)==null?"":rs.getString(4);

			//out.println("<tr><td><table border=0 cellspacing=0 cellpadding ='3' align='center' width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%'><tr><td colspan ='8' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By:  "+practName+", <fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+addedDate+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+addendumText+"</td></tr></table>	</td></tr>");
			out.println("<tr><td><table border='0' cellspacing='0' cellpadding ='3' align='center' width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%'><tr><td colspan ='8' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By:  "+practName+", <fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+addedDate+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+addendumText+"</td></tr></table>	</td></tr>");
		}
	}
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();//IN071865
		if(pstmt1!=null) pstmt1.close();//IN071865
		if(rs2!=null) rs2.close();//Exception-PMG2020-COMN-CRF-0085
		if(pstmt2!=null) pstmt2.close();//Exception-PMG2020-COMN-CRF-0085
	//	if(con!=null)	ConnectionManager.returnConnection(con,request);

	}

try
{

		String noteAddendem = sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");

		if(noteAddendem!=null && !noteAddendem.equals(""))
		{
			//out.println("<tr><td><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%'><tr><td colspan='8' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By: "+clinician_name+", <fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">" + replaceSpecialChars(noteAddendem)+"</td></tr></table></td></tr>");
			out.println("<tr><td><table border='0' cellspacing='0' width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%'><tr><td colspan='8' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By: "+clinician_name+", <fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">" + replaceSpecialChars(noteAddendem)+"</td></tr></table></td></tr>");
		}
		
		out.println("<script>");
		//out.println("parent.frameSetIdHeader.rows='6.5%,86.5%,7%'");
		out.println("setTimeout(\"parent.frameSetIdMessage.rows='*%,0%'\",1000)");
		//out.println("parent.RecClinicalNotesToolbarFrame.document.getElementById('process_msg').style.display = 'none'");
		//out.println("parent.RecClinicalNotesSectionFrame.document.getElementById('tbl_section').style.display = 'inline'");
	//	out.println("parent.RecClinicalNotesSectionFrame.document.getElementById('notes_view').disabled = false");
		out.println("</script>");  		

}
catch(Exception ex)
{	
	ex.printStackTrace();
}
}catch(Exception ex){
	ex.printStackTrace();
}finally
{		
		if(con!=null)	ConnectionManager.returnConnection(con,request);
}
%>
</table>
<!--IN068105 starts-->
<%if("Y".equals(noteCopiedYN)){%>
<table border=0 cellspacing=0 width='100%'>
	<tr>
		<td align='right' >
			<span style="background-color: black;color : white">*COPIED NOTE</span>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
</table>
<%}%>
<!--IN068105 ends-->
</center>
</form>
</body>
<script>
changeEditorTitle("<%=editor_title%>");
function PaintImages() 
{
//		<%=imageFunctionNames%>
}
</script>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
	}
%>

<%!
	private String replaceSpecialChars(String input)
	{
		if(input.indexOf("\n")!=-1)
		input = input.replaceAll("\n","<br>");	
		return input;
	}
%>

