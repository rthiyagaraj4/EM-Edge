<!DOCTYPE html>
<!--
----------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Description
----------------------------------------------------------------------------------------------------------------------------
?            	100            		?           		created
23/12/2013		IN045932		Nijitha S           ML-BRU-SCF-1211 
20/09/2019		IN071408		SIVABAGYAM M		RAMESH G    20/09/2019				Regression-OR/RL-Existing Orders and Attached Images
----------------------------------------------------------------------------------------------------------------------------
 
-->
<%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</HEAD>
<%
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

int i=1;
String			patient_id				=	"";
String			encounter_id				=	"";
String			facility_id				=	"";
String			accession_num			=	"";
String			section_hdg_code		=	"";
String			subsection_hdg_code		=	"";
StringBuffer	buf						=	new StringBuffer();
//the following variable will be used to get the raw section content from the database. if it is not a template, the it would not be converted, otherwise it would be.



//the following variable will be used to convert the XML content coming from the database to HTML through the XMLToHTML convertor if the contenttype is a template.
String			notes_section_content	=	"";
String			section_img_content		=	"";
StringBuffer			qry						=	new StringBuffer();
String			sec_content_type			=	"";
String			subsec_content_type			=	"";
String			preserve_format_yn			=	"";
String			image_linked_yn			=	"";
StringBuffer image_qry = new StringBuffer();
Clob			clb=null;
Clob			iclb=null;
java.sql.ResultSet		rs = null;
java.sql.Connection		con = null;
java.sql.PreparedStatement pstmt = null;
java.sql.PreparedStatement ipstmt = null;
java.sql.ResultSet		irs = null;
%>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
	//facility_id	= (String) session.getValue("facility_id");//IN045932
	facility_id = (request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));//IN045932
	accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));
	section_hdg_code = (request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code"));
	subsection_hdg_code = (request.getParameter("subsection_hdg_code")==null?"":request.getParameter("subsection_hdg_code"));
	patient_id = (request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	encounter_id = (request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"));

	
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

	if (!section_hdg_code.equals(""))
	{
		//qry.append("select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.subsec_hdg_code , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content, NVL(c.PRESERVE_FORMAT_YN, b.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where  facility_id = ? and accession_num = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and a.sec_hdg_code = ?  ");
		qry.append("select 	a.sec_hdg_code , c.content_type sec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.sec_hdg_code,?,'1') sec_hdg_desc , a.subsec_hdg_code , c.content_type subsec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.subsec_hdg_code,?,'1')  subsec_hdg_desc, a.notes_section_content,c.PRESERVE_FORMAT_YN PRESERVE_FORMAT_YN,c.image_linked_yn 	from 	ca_encntr_note_section a ,ca_section_hdg_lang_vw c 	where  	facility_id = ? and 	accession_num = ? and 	c.language_id = ? and 	c.sec_hdg_code=a.SUBSEC_HDG_CODE and 	a.sec_hdg_code = ?  ");

		if (!subsection_hdg_code.equals(""))
			qry.append("and subsec_hdg_code= ? ");

	}
	else
	{
		qry = new StringBuffer();
		qry.append("select  NOTE_CONTENT  from ca_encntr_note where facility_id = ? and accession_num = ?  ");
	}
	
	
	try
	{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry.toString());
		if (!section_hdg_code.equals(""))
		{
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, facility_id);
			pstmt.setString(4, accession_num);
			pstmt.setString(5, locale);
			pstmt.setString(6, section_hdg_code);

			if (!subsection_hdg_code.equals(""))
				pstmt.setString(7, subsection_hdg_code);
		}
		else 
		{
			pstmt.setString(1, facility_id);
			pstmt.setString(2, accession_num);	
		}
		
		rs = pstmt.executeQuery();
	  
		if (!section_hdg_code.equals(""))
	    {
			buf.append("<HTML><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>   <script src='../../eCommon/js/showModalDialog.js' type='text/javascript'></script></HTML>");

       // <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        //<script src="../../eCommon/js/showModalDialog.js"></script>
      

      

        
      // <BODY onKeyDown='lockKey()'>;
	 
			while(rs.next())
			{
			  notes_section_content = "";
		 
			buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			sec_content_type = rs.getString("sec_content_type");
			image_linked_yn = rs.getString("image_linked_yn")==null?"N":rs.getString("image_linked_yn");
						
			if(!sec_content_type.equals("S"))
			{			
				buf.append("<table width='100%'><tr><td class='NOTEHEADER'>");	
				buf.append(rs.getString("sec_hdg_desc"));
				buf.append("</td></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				clb = rs.getClob("notes_section_content");
				
				if(clb.length()>0)
				{
					//java.io.BufferedInputStream r = clb.getAsciiStream();
					BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
					String line="";
				
					while(line!=null)
					{
						notes_section_content+=line;
						line = d.readLine();					
					}
				}

				if(image_linked_yn.equals("Y"))
				{
					image_qry.append("select img_content from ca_encntr_note_section_obj where operating_facility_id = ? and accession_num =? and sec_hdg_code = ? ");
					if(!subsection_hdg_code.equals(""))
					{
						image_qry.append(" and subsec_hdg_code = ? ");
					}
					
					ipstmt	= con.prepareStatement(image_qry.toString());
					ipstmt.setString(1, facility_id);
					ipstmt.setString(2, accession_num);
					ipstmt.setString(3, section_hdg_code);
					if(!subsection_hdg_code.equals(""))
					{
						ipstmt.setString(4, subsection_hdg_code);
					}

					irs = ipstmt.executeQuery();

					while(irs.next())
					{
						iclb = irs.getClob("img_content");

						if(iclb.length()>0)
						{
							
							BufferedReader im  = new BufferedReader(iclb.getCharacterStream() );
							String iline="";
						
							while(iline!=null)
							{
								section_img_content+=iline;
								iline = im.readLine();					
							}
						}

					}


					if(irs!=null)  irs.close();
					if(ipstmt!=null) ipstmt.close();

		

				}
				if(sec_content_type.equals("T"))
				{	
				//IN071408 STARTS			
					/* 
					StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
					url = new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));
					*/						
					String url					= application.getRealPath("/eCA")+"/";
					
				
					preserve_format_yn= rs.getString("preserve_format_yn");
					buf.append("<table width='100%'><tr><td>");	

					if (preserve_format_yn.equals("Y"))
						url		=url+"html/RecClinicalNotesTemplateDispayView.xsl";
					else
						url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";

					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url);
					//IN071408 ENDS
					buf.append(notes_section_content);
					
					buf.append("</table>");	
					//eCA/html/RecClinicalNotesTemplateDispayView.xsl":"eCA/html/RecClinicalNotesTemplateSentenceView.xsl
				}
				else
				{
					buf.append(notes_section_content);
					
					if(!section_img_content.equals(""))
					{

						buf.append("<tr><td colspan='3'><applet name='"+section_hdg_code + subsection_hdg_code+"' code='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='845' height='400' align='baseline'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'><param name='image' value='"+section_img_content+"'></applet> ");
						section_img_content="";
						//buf.append("<tr><td colspan='3'><OBJECT name='"+section_hdg_code + subsection_hdg_code+"' code='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='660' height='360' align='baseline'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'><param name='image' value='"+section_img_content+"'></OBJECT> ");
						//buf.append("<tr><td colspan='3'><OBJECT codetype='application/java'  name='"+section_hdg_code + subsection_hdg_code+"' classid='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='660' height='360' align='baseline' data ='"+section_img_content+"'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'></OBJECT> ");
						//<OBJECT data="http://www.somecompany.com/People/Ian/vacation/family.png" type="image/png">A photo of my family at the lake.</OBJECT> 
					}
				}
			
			}
			else
			{
				subsec_content_type = rs.getString("subsec_content_type");
				if(i==1)
			
					buf.append("<table width='100%'><tr><td class='NOTEHEADER' >" + rs.getString("sec_hdg_desc") + "</td></tr></table>");
				i++;
				buf.append("<table width='100%'><td class='NOTESUBHEADER'>" + rs.getString("subsec_hdg_desc") + "</td></table>");
				clb = rs.getClob("notes_section_content");
				if(clb.length()>0)
				{
					//java.io.BufferedInputStream r = clb.getAsciiStream();
					BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
					String line="";
					while(line!=null)
					{
						notes_section_content+=line;
						line = d.readLine();					
					}
				}
				if(subsec_content_type.equals("T"))
				{
					//IN071408 STARTS
					/*
					StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
					url= new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));
					*/
					//url.append("html/RecClinicalNotesTemplateDispayView.xsl");
					String url					= application.getRealPath("/eCA")+"/";
					preserve_format_yn= rs.getString("preserve_format_yn");

					if (preserve_format_yn.equals("Y"))
						url		=url+"html/RecClinicalNotesTemplateDispayView.xsl";
					else
						url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";

					
					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url);
					//IN071408 ENDS
					buf.append("<table width='100%'><tr><td>");	
					buf.append(notes_section_content);
					buf.append("</table>");	
				}
				else
					buf.append(notes_section_content);
			}
		}
		if(rs!=null)  rs.close();
		if(pstmt!=null) pstmt.close();
		 buf.append("</BODY></HTML>");
		
	  }
		else
		{
			if (rs.next())
			{
				clb = rs.getClob("NOTE_CONTENT");
				if(clb.length()>0)
				{
					//java.io.BufferedInputStream r = clb.getAsciiStream();
					BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
					String line="";
					while(line!=null)
					{
						notes_section_content+=line;
						line = d.readLine();					
					}
					buf.append(notes_section_content);
				}
			}
			if(rs!=null)  rs.close();
			if(pstmt!=null) pstmt.close();

		}

	}
	catch(SQLException sqle)
	{
		buf.append("SQL Exception 1 = " + sqle);
		sqle.printStackTrace();
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception se)
	{
		buf.append("Exception = " + se);
		se.printStackTrace();
	}
	finally
	{
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con);
	}
	//buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>");
	buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/ " + sStyle + "'>");
%>
<form>
<%=buf%>
<div id="data" style='display:none;' border='0' width='0'>
<%=buf%>
</div>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='accession_num' id='accession_num' value='<%=accession_num%>'>
<input type='hidden' name='section_hdg_code' id='section_hdg_code' value='<%=section_hdg_code%>'>
<input type='hidden' name='subsection_hdg_code' id='subsection_hdg_code' value='<%=subsection_hdg_code%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
</form>
</BODY>
</HTML>
<script>
if(parent.RecClinicalNotesLinkHistNoteAddButtonsFrame != null)
	parent.RecClinicalNotesLinkHistNoteAddButtonsFrame.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;			
</script>

