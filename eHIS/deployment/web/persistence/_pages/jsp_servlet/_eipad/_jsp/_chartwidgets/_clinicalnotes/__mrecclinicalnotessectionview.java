package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import javax.xml.transform.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __mrecclinicalnotessectionview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionView.jsp", 1709118015818L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<script>\n\nvar clinicalNotesPreviewScroll;\nfunction assignClinicalNotesPreviewScroll() {\n\tclinicalNotesPreviewScroll = new IScroll(\'#NotePreviewBodyWrapper\', {  \n\t\tscrollX: true, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tuseTransition: false,\n\t\tbindToWrapper: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n\tclinicalNotesPreviewScroll.refresh();\n}\n\n$(document).ready(function(){\n\tassignClinicalNotesPreviewScroll();\n\t\n});\n\n</script>\n\n<div style=\"width: 100%; height: 100%;position:absolute\" class=\"table\">\n<!-- Header row STARTS -->\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<!-- Header row ENDS -->\n\t\n\t<!-- Body(notes preview) row STARTS -->\n\t\n\t<div style=\"height:100%;width:100%\" class=\"row\">\n\t\t<div class=\"cell\" style=\"width:100%;height:100%;\">\n\t\t\t<div style=\"position: relative;width:100%;height:100%;overflow:hidden\" id=\"NotePreviewBodyWrapper\">\n\t\t\t\t<div style=\"position: absolute;width:100%;height:auto;overflow:auto\" id=\"NotePreviewBodyScroller\">\n\t\t\t\t\t\t\n\t\t\t\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t<table border=0 cellspacing=0 width=\"100%\" cellpadding=\'3\' align=\'center\' style=\"font-family:Verdana\">\n\t\t\t\t\t\t\t\t<tr><td style=\"background-color:#ADADAD;\" colspan=3>\n\t\t\t\t\t\t\t\t<font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</u></font></td></tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td style=\"background-color:#ADADAD;\" colspan=3>\n\t\t\t\t\t\t\t\t\t<font style=\"FONT-SIZE 13pt;font-weight:bold;\"><u><i>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</i></u></font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TD colspan=\"3\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t<tr><td colspan=\"3\">\n\t\t\t\t\t\t<applet name=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" code=\"Drawing.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"845\" height=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" align=\"baseline\" >\n\t\t\t\t\t\t\t<param name=\"canDraw\" value=\"0\">\t\n\t\t\t\t\t\t\t<param name=\"jpeg_quality\" value=\"50\">\n\t\t\t\t\t\t\t<param name=\"image\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"> \n\t\t\t\t\t\t</applet> \n<!--\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tvar hiddenVarName = \"\";\n\t\t\t\t\t\t\t\t\t\t\thiddenVarName = \"img_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\n\t\t\t\t\t\t\t\t\t\t\tif(hiddenVarName != \"\")\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tvar hiddenVar = eval(\"parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.\"+ hiddenVarName );\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\t\t\tfunction showImage";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="( ) \n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tvar hiddenVarName1 = \"img_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t//if(hiddenVarName1 != \"\")\n\t\t\t\t\t\t\t\t\t\t\t\t//\tvar hiddenVar1 = eval(\"parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.\"+hiddenVarName1 );\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\twhile (parent.RecClinicalNotesSecDetailsFrame.document.applets[\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"].GetImageType() == null ) ;\t\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.document.applets[\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"].SetImage(eval(\"parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.\" +hiddenVarName1+ \".value\"));\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t</script> \n\t\t\t\t\t\t\t\t\t\t-->\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t</TD></TR><tr><td font style=\"COLOR:NAVY\">&nbsp;</td></tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</table>\n</center>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n<input type=\"hidden\" name=\"event_date_time\" id=\"event_date_time\" id=\"event_date_time\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t\t</div>\n\t\t\t</div>\t\n\t\t</div>\n\t</div>\n</div>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	private String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
	}


	private String replaceSpecialChars(String input)
	{
		if(input.indexOf("\n")!=-1)
		input = input.replaceAll("\n","<br>");	
		return input;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String selection_type = request.getParameter("selection_type")==null?"":request.getParameter("selection_type");
	
/* 	String note_type_desc = request.getParameter("note_type_desc")==null?"":request.getParameter("note_type_desc"); */
	
	/* String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
	String event_status = request.getParameter("event_status")==null?"":request.getParameter("event_status");
	
	String practitioner_name = request.getParameter("practName")==null?"":request.getParameter("practName");
 */
	java.sql.Connection			con		=	null;
	java.sql.PreparedStatement	pstmt		=	null;
	java.sql.PreparedStatement	stmt		=	null;
	java.sql.ResultSet			rs			=	null;
	java.sql.ResultSet			rset		=	null;

	StringBuffer imageFunctionNames = new StringBuffer() ;
	
	String		query_section_details		=	"";
	String		prev_sec_hdg_code			=	"";
	String		sec_hdg_code					="";
	String		sec_hdg_desc					="";
	String		sec_content_type				="";
	String		child_sec_hdg_desc			="";
	String		child_sec_hdg_code			="";
	String		child_sec_content_type		="";
	String		preserve_format_yn			="";
	String		sys_date_time					="";
	String		image_linked_yn				="";
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

	//String		url					= HttpUtils.getRequestURL(request).toString();
	String		url1				= "";
	String		url2				= "";
	String output_yn =  ""; 
	String sec_hdg_code_out =  "";
	String child_sec_hdg_code_out =  "";
	
	
	String appl_task_id =  "CLINICAL_NOTES"; // Setting default
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

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

try {
	
	String requrl = request.getRequestURL().toString();
	String requri = request.getRequestURI();
	String url = requrl.substring( 0, requrl.indexOf(requri) ) + request.getContextPath();

	url1	=		url + "/eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	url2		=		url+"/eCA/html/RecClinicalNotesOutputFormDisplay.xsl";
	url		=		url+"/eCA/html/RecClinicalNotesTemplateSentenceView.xsl";

	editor_title = "Notes View";

	accession_num	=	request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	facility_id		=	(String)session.getValue("facility_id");
	clinician_name	=	(String)session.getValue("practitioner_name");
	PatContext patContext= (PatContext)session.getAttribute("PatientContext");

	patient_id		=	patContext.getPatientId();
	encounter_id	=	patContext.getEncounterId();
	//appl_task_id	=	checkForNull( request.getParameter("appl_task_id"));
	//multi_sec_hdg_code	=	checkForNull( request.getParameter("multi_sec_hdg_code"));
	//multi_child_sec_hdg_code	=	checkForNull( request.getParameter("multi_child_sec_hdg_code"));
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
				
				section_content_buff.append("<table border=0 cellspacing=0 width='100%' cellpadding='3' align='center' style='font-family:Verdana'><tr><td style='background-color:#ADADAD;' colspan=3><font style='FONT-SIZE:13pt;font-weight:bold;'><u> "+hist_rec_type_desc+" </u></font></td></tr>");

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

					if(output_yn.equals("Y"))
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
						
						if(output_yn.equals("Y"))
						{
							section_content=converter.buildHTMLFromXML(section_content,url2);							
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
						if( !image_linked_yn.equals("")  && image_linked_yn.equals("Y")){
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
							
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);

								prev_sec_hdg_code = sec_hdg_code;
						}
						if(sub_sec_hdg_type.equals("S"))
						{
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

						}
					}
					
					if ( !(section_content.equals("&nbsp;")) && !(section_content.equals("")))
					{
						section_content = section_content.replaceAll("<([^>]*)></\\1>", "");  //IN043895
						
			//			traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSectionView.jsp at 519  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("encounter_id")+"**patient_id**"+request.getParameter("patient_id")+"** section_content  **"+section_content+"**");
					
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block11Bytes, _wl_block11);

					}

					if(image_linked_yn.equals("Y") && (!section_image_content.equals("")))
					{
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sec_hdg_code + child_sec_hdg_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(section_image_height));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(section_image_content));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block17Bytes, _wl_block17);

												imageFunctionNames.append("showImage"+sec_hdg_code+ child_sec_hdg_code+"();\n");
												
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sec_hdg_code + child_sec_hdg_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sec_hdg_code + child_sec_hdg_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( sec_hdg_code + child_sec_hdg_code));
            _bw.write(_wl_block22Bytes, _wl_block22);

					}
					else
					{
						if(!(section_content.equals("&nbsp;")))
						{
							
            _bw.write(_wl_block23Bytes, _wl_block23);

						}
					}
	
					strAddendumText = checkForNull(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code),"");

					if(!strAddendumText.equals("") )
					{
						strAddendumText = replaceSpecialChars(strAddendumText);
						out.println("<tr><td><table border=0 cellspacing=0 cellpadding ='3' align='center' width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' colspan='8' style=\"font-family:Verdana;font-size:9pt;\" ><I>Addendum Created By : "+clinician_name+",<fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+sys_date_time+"</I></td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >" + strAddendumText+"</td></tr></table></td></tr>");
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
		String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from 	ca_encntr_note_addendum a where ACCESSION_NUM=? and SEC_HDG_CODE='*AmmendNotes*' and SUBSEC_HDG_CODE='*AmmendNotes*' and addendum_status='S' order by ADDENDUM_DATE";
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
			addendumText	= rs.getString(1)==null?"":rs.getString(1);
			practName		= rs.getString(2)==null?"":rs.getString(2);
			addedDate		= rs.getString(4)==null?"":rs.getString(4);

			out.println("<tr><td><table border=0 cellspacing=0 cellpadding ='3' align='center' width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%'><tr><td colspan ='8' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By:  "+practName+", <fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+addedDate+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+addendumText+"</td></tr></table>	</td></tr>");
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
	//	if(con!=null)	ConnectionManager.returnConnection(con,request);

	}

try
{

		String noteAddendem = sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");

		if(noteAddendem!=null && !noteAddendem.equals(""))
		{
			out.println("<tr><td><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%'><tr><td colspan='8' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By: "+clinician_name+", <fmt:message key='Common.datetime.label' bundle='${common_labels}'/> : "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">" + replaceSpecialChars(noteAddendem)+"</td></tr></table></td></tr>");
		}
		
			

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

            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block1Bytes, _wl_block1);

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
	String today = dateFormat.format(new java.util.Date());

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(today));
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block27Bytes, _wl_block27);
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
