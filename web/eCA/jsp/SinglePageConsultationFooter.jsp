<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036- new file created.
20/09/2019		IN071408		SIVABAGYAM M		RAMESH G    20/09/2019				Regression-OR/RL-Existing Orders and Attached Images
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.lang.*,java.text.*,webbeans.eCommon.* "%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' >
<form>
<%
	String practitioner_name = request.getParameter("practitioner_name") == null ? "" : request.getParameter("practitioner_name");
	String print_date_time = request.getParameter("print_date_time") == null ? "" : request.getParameter("print_date_time");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	Hashtable htParameter=new Hashtable();
	String	section_content			=	"";
	String  sect_template_query		=	"";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	PreparedStatement pstmt2 = null;
	ResultSet rs2 =	null;
	String	section_content_ftr		=	"";
	Connection con  = null;
	int paramIndex = 0;
	HashMap<String,String> paramMap = null;
	String  url1					=	"";
	String  url						=	"";
	//url   = HttpUtils.getRequestURL(request).toString();//IN071408
	//url = url.substring(0,url.indexOf("jsp/"));//IN071408
	url=application.getRealPath("/eCA/")+"/";//IN071408
	url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";//IN071408
	con =  ConnectionManager.getConnection(request);

		try
			{	
				sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);
				pstmt2.setString(1,"V$RF");
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					System.out.println("SinglePageConsultationHeader.jsp:114");
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
							bf_content_reader	= new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
							section_content = new String(arr_notes_content);
							bf_content_reader.close();
							if(section_content == null)
								section_content = "";
						}
						catch(Exception e)
						{
							//out.println("Exception@1-readCLOB :SinglePageConsultationFooter.jsp: "+e);//COMMON-ICN-0181
							e.printStackTrace();
						}
					}
				}

			//6/5/2014 Moved the code from outside of the try catch to inside try catch

			htParameter.put("V$CUR_USR", practitioner_name);
			htParameter.put("V$PRN_DTTIME", print_date_time);

			StringBuffer section_content_new = new StringBuffer(section_content);
			
			if (! locale.equals("en") )
			{
				if(!section_content_new.toString().equals(""))
				{
					paramMap = new HashMap<String,String>();
					paramMap.put("CURR_SEC_HDG_CODE","V$RF");
					paramMap.put("LOCALE",locale);						
					paramMap.put("RANGE_PASER_YN","N");
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
					section_content_new = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}
			
			if(!section_content_new.toString().equals(""))
			{	
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}
			
			if(!(sectionContentUpdatedXML.toString().equals("")))
			{								
				section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
				
			}
	
			}
			
			catch(Exception eee)
			{
				//out.println("Exceptionin SinglePageConsultationFooter.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
				eee.printStackTrace();
			
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			
	

%>	
	<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td><%=section_content_ftr%></td></tr></table><BR>
		
</form>
</body>
</html>

