package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __notesdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/NotesDetail.jsp", 1709118028755L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!DOCTYPE html>\n<html>\n<head>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n\n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n<link rel=\"stylesheet\" href=\"../css/iPadViewClinicalEventHistory.css\" />\n\n<script>\nfunction noteclose()\n{\n\t//document.getElementById(\"notesContentFrame2\").src = \"../jsp/widgetResultDetail.jsp\";\n\twindow.parent.closenotes();\n}\n</script>\n\n</head>\n<body>\n\n<form name=\"flowsheet_text\" id=\"flowsheet_text\" align=\'center\'>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' border=\'0\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"100%\">\n\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t\t\t            <tr >  \n\t\t\t\t\t            <td style = \"width : 80%\">&nbsp;&nbsp;</td>\n\t\t\t\t\t            <td style = \"width : 20%\" align = \"right\" valign = \"center\" >\n\t\t\t\t\t         \t\t <input type =\"button\" name=\'Close_btn\' id=\'Close_btn\' value=\'Close\' class=\"btnType1\"  data-role = \"none\" onclick = \"noteclose()\" />\n\t\t\t\t\t            </td>\n\t\t\t\t            </tr>\n\t\t\t\t         </table>   \n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"100%\">\t\n\t\t\t\t\t\t<table border=\'2\' cellpadding=\'0\' cellspacing=\'4\' width=\'100%\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t\t\t<BR>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"100%\">\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"100%\">\t\n\t\t\t\t\t\t<table border=\'2\' cellpadding=\'0\' cellspacing=\'4\' width=\'100%\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\n\t\t\t\t<BR>\n\t\t\t\t\t\t\n\t\t\t</table>\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String HistRecType = request.getParameter("Histrectype");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String ContrSysId = request.getParameter("Contrsysid");
	String AccessionNum = request.getParameter("Accessionnum");
	String ContrSysEventCode = request.getParameter("Contrsyseventcode");
	String patient_id = request.getParameter("patient_id");//INO30714
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "";
	StringBuffer displaydata = new StringBuffer();
	String hist_data_type="";
	String temp = "";
	String temp1 = "";
    String value = "";
    String strToken = ""; 
	String practitioner_name = "";
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	//INO30714 Starts
	String facilityId = (String)session.getValue("facility_id");
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 =	null;
	ResultSet rs2 =	null;
	ResultSet res =	null;
	String performed_by_id	=	"" ;
	String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String enc_id	=	request.getParameter("enc_id");
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	String attending_practitioner	=	"" ;
	String admitting_practitioner	=	"" ;
	String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	String gender	=	"" ;
	String patient_name	=	"" ;
	String speciality_name	=	"" ;
	String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String  url1					=	"";
	String  url						=	"";
	String footer_code = null;
	String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	url   = HttpUtils.getRequestURL(request).toString();
	url = url.substring(0,(url.indexOf("eHIS/")+5));
	url1 = url + "eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	url =url+"eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String	login_user_id		=	(String)session.getValue("login_user");
	String  sect_template_query		=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	HashMap<String,String> paramMap = null;
	//INO30714 ends
	
	try
	{
		    con = ConnectionManager.getConnection(request);
			//INO30714 Starts
		try
		{
			if(	episode_type.equals("O") )
			{
				
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
			}
			else
			{ 
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
			}
			
			pstmt1	=	con.prepareStatement(query_privilege_type);
			
			pstmt1.setString	(	1,	locale	);
			pstmt1.setString	(	2,	locale	);
			pstmt1.setString	(	3,	locale	);
			pstmt1.setString	(	4,	locale	);
			pstmt1.setString	(	5,	performed_by_id	);
			pstmt1.setString	(	6,	locale	);
			pstmt1.setString	(	7,	locale	);			
			pstmt1.setString	(	8,	locale	);			
			pstmt1.setString	(	9,	locale	);			
			pstmt1.setString	(	10,	locale	);			
			pstmt1.setString	(	11,	facilityId	);
			pstmt1.setString	(	12,	enc_id);

			res		=	pstmt1.executeQuery();
			
			if(res.next())
			{
				patient_class	=	res.getString("patient_class") == null ? "" : res.getString("patient_class");
				facility_name			=	res.getString("facility_name") == null ? "" : res.getString("facility_name");
				visit_adm_date			=	res.getString("visit_adm_date")==null?"":res.getString("visit_adm_date");
				med_service			=	res.getString("service_name")==null?"":res.getString("service_name");
				discharge_date		=	res.getString("DISCHARGE_DATE_TIME")==null?"":res.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	res.getString("attending_practitioner")==null?"":res.getString("attending_practitioner");
				admitting_practitioner	=	res.getString("admitting_practitioner")==null?"":res.getString("admitting_practitioner");
				bed_number	=	res.getString("bed_number")==null?"":res.getString("bed_number");	  //--[IN:029839]--
				performing_phy_name	=	res.getString("performed_by_name")==null?"":res.getString("performed_by_name");
				age				=	res.getString("AGE")==null?"":res.getString("AGE");
				gender					=	res.getString("gender")==null?"":res.getString("gender");
				//locationDesc			=	res.getString("location");
				location_code			=	res.getString("location_code")==null?"":res.getString("location_code");
				patient_name			=	res.getString("patient_name")==null?"":res.getString("patient_name");
				speciality_name			=	res.getString("specialty_name")==null?"":res.getString("specialty_name");
				printDateTime			=	res.getString("print_date_time")==null?"":res.getString("print_date_time");
				site_name			=	res.getString("site_name")==null?"":res.getString("site_name");
				//performed_by_desc			=	res.getString("performed_by_desc");


			
			}

				if(gender.equals("M"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				if(discharge_date==null)
				{
					discharge_date="";
				}
				if(patient_class.equals("OP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(res!=null)	res.close();
			if(pstmt1!=null)	pstmt1.close();
		}
										
								try
								{
									String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
									pstmt2	= con.prepareStatement(head_foot_qry);
									pstmt2.setString(1,ContrSysEventCode);
									rs2 = pstmt2.executeQuery();
									
									while(rs2.next())
									{
										//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
										footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
										report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
									}

			
								}
								catch(Exception ee)
								{
									out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
									ee.printStackTrace();
								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
								}
								
								try
								{
									sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
									pstmt2	= con.prepareStatement(sect_template_query);
									pstmt2.setString(1,report_header_code);
									rs2 = pstmt2.executeQuery();


									if(rs2.next())
									{
										clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
										
										if(clob_notes_content!=null)
										{
											try
											{
												//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
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
												out.println("Exception@1-readCLOB : "+e);
												e.printStackTrace();
											}


										}
									}
								}

								catch(Exception eee)
								{
									out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
									eee.printStackTrace();

								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									
								}
							if(!AccessionNum.equals(""))
							{
								try
								{
									String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

									pstmt2	= con.prepareStatement(athorise_by_qry);
									pstmt2.setString(1,locale);
									pstmt2.setString(2,locale);
									pstmt2.setString(3,locale);
									pstmt2.setString(4,locale);
									pstmt2.setString(5,AccessionNum);
									pstmt2.setString(6,patient_id);
									rs2 = pstmt2.executeQuery();
									while(rs2.next())
									{
										//authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
										//last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
										//doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
										//authorized_by		=	rs2.getString("AUTHORIZED_BY_ID") ;
										//last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID");
										//doc_ref_id		=	 rs2.getString("DOC_REF_ID") ;
										authorized_by		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
										last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
										doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996
										 
									}
								}
								catch (Exception roro )

								{
									out.println("Exception in NotesDetail.jsp getting section content : "+roro.toString());
									roro.printStackTrace();

								}
								finally 
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									
								}
							}
							encounter_id1 = enc_id ;
							if(enc_id.equals("0"))
							{
								encounter_id1 ="";
							}
				
							if(!visit_adm_date.equals(""))
							{
								visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
							}
				
							if(!discharge_date.equals(""))
							{
								discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
							}



							//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
							htParameter.put("V$ATT_PRACT", attending_practitioner);
							htParameter.put("V$ADM_PRACT", admitting_practitioner);
							htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
							htParameter.put("V$PT_SPLTY", speciality_name);
							//--[IN029296]  - Start
							if(patient_name.trim().equals(""))
								htParameter.put("V$PT_NAME", default_pat_name);
							else
								htParameter.put("V$PT_NAME", patient_name);
							//--[IN029296]  - End
							htParameter.put("V$PT_ID", patient_id);
							htParameter.put("V$SEX", Sex);
							htParameter.put("V$AGE", age);
							htParameter.put("V$ENC_ID", encounter_id1);
							htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
							htParameter.put("V$DIS_DT", discharge_date); //discharge_date
							htParameter.put("V$MED_SERV", med_service);
							htParameter.put("V$DOC_REF_H", doc_ref_id);
							htParameter.put("V$PT_LOCN", location_code); //patient_loc
							htParameter.put("V$PT_CLASS", patient_class);//patient_class
				
							//sectionContentUpdatedXML = new StringBuffer();
							StringBuffer section_content_new = new StringBuffer(section_content);
				
							if (! locale.equals("en") )
							{
								if(!section_content_new.toString().equals(""))
								{
									paramMap = new HashMap<String,String>();
									paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
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
								section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
								//section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
								
							}
						//Report Header Ends
						
						// changes notes footer starts
						section_content= "";

						try
						{
			
							//String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
							pstmt2	= con.prepareStatement(sect_template_query);
							pstmt2.setString(1,footer_code);
							rs2 = pstmt2.executeQuery();


							if(rs2.next())
							{
				
								clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
								if(clob_notes_content!=null)
								{
									try
									{
										//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
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
										out.println("Exception@1-readCLOB : "+e);
										e.printStackTrace();
									}


								}
							}
						}

						catch(Exception eee)
						{
							out.println("Exception in NotesDetail.jsp getting section content : "+eee.toString());
							eee.printStackTrace();

						}
						finally
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();
						}

						if(!printDateTime.equals(""))
						{
							printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
						}

						htParameter=new Hashtable();
						htParameter.put("V$CUR_USR", login_user_id);
						htParameter.put("V$AT_PRACT", authorized_by);
						htParameter.put("V$LT_MODI_USR", last_amended_by);
						htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
						htParameter.put("V$DOC_REF_F", doc_ref_id);
						htParameter.put("V$LT_PT_P_C_D", pract_sign);

						section_content_new = new StringBuffer(section_content);
						sectionContentUpdatedXML = new StringBuffer();
				
						if (! locale.equals("en") )
						{
							if(!section_content_new.toString().equals(""))
							{
								paramMap = new HashMap<String,String>();
								paramMap.put("CURR_SEC_HDG_CODE",footer_code);
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
						//Footer Ends
					//INO30714 Ends
			//Below query is added by Archana Dhal on 11/24/2010 related to IN025200.
			String sql1 = " select am_get_desc.am_practitioner(practitioner_id,?,2) practitioner_name from cr_encounter_detail where accession_num=?";
			stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1,locale);
			stmt1.setString(2,AccessionNum);
			rs1 = stmt1.executeQuery();
			while(rs1.next())
			 {	
				practitioner_name=rs1.getString("practitioner_name");		   
			  }
			sql = " SELECT B.HIST_DATA,A.HIST_DATA_TYPE FROM CR_ENCOUNTER_DETAIL A, CR_ENCOUNTER_DETAIL_TXT B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";
//			out.println(sql);

			stmt = con.prepareStatement(sql);

			stmt.setString(1, HistRecType);
			stmt.setString(2, ContrSysId);
			stmt.setString(3, AccessionNum);
			stmt.setString(4, ContrSysEventCode);

			rs = stmt.executeQuery();

			if(rs.next())
			{
				Clob note=rs.getClob("HIST_DATA");
				hist_data_type = rs.getString("HIST_DATA_TYPE");
				displaydata = new StringBuffer();
				if(note!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;
					/*if (!HistRecType.equals("CLNT")){
					while((line=r.readLine()) != null) displaydata+=line+"<br>";
					displaydata+="<br>";
					} 
					else
					{*/
					/*while((line=r.readLine()) != null) 
					{
						System.out.println("line---->"+line);
						displaydata.append(line+"\n");
					}*/
					//}
					//displaydata.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>");//INO30714
					while((line=r.readLine()) != null)
					{
						//Below condition is added by Archana Dhal on 10/7/2010 related to IN024213.
						if(line.indexOf("Onset Date Time")!=-1)
						{					
                         temp = line.substring(18,line.length());
                         temp	= com.ehis.util.DateUtils.convertDate(temp,"DMY","en",locale);
						 displaydata.append(line.substring(0,18));
						 displaydata.append(temp);
						 displaydata.append("\n");
						}
						else if(line.indexOf("Reviewed by")!=-1)
						{
						  temp1   = line.substring(14,27);
						  temp1 = practitioner_name;
						  displaydata.append(line.substring(0,14));
						  displaydata.append(temp1);
					     if(line.indexOf("On")!=-1)
						 {
						  value = line.substring(31,line.length());
						  value	= com.ehis.util.DateUtils.convertDate(value,"DMYHM","en",locale);
						  displaydata.append(line.substring(27,31));
						  displaydata.append(value);
						  displaydata.append("\n");
						 }		
						}
						else
						 {
							displaydata.append(line);
							displaydata.append("\n");
						}								
					 }
					 // displaydata.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>");//INO30714
						
					}
				}
			//if(HistRecType.equals("CLNT") || hist_data_type.equals("HTM"))
			if( hist_data_type.equals("HTM"))
			{
			
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(section_content_rpt ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(section_content_ftr));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
			}
			else
				out.println("<br/>&nbsp;&nbsp;&nbsp;&nbsp;<textarea align='ABSMIDDLE' style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows=35 cols=100 readOnly>"+displaydata.toString()+"</textarea>");


		if(rs !=null) rs.close();
		if(stmt != null ) stmt.close();
		if(rs1 != null ) rs1.close();
		if(stmt1 != null ) stmt1.close();

	}catch(Exception e)
	{		out.println(e);		}

	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
