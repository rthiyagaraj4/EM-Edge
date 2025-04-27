package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkhistnotetree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkHistNoteTree.jsp", 1738316270864L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!--\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n?             100         ?           created\n14/08/2012\tIN034385\tDinesh T\tTo eradicate the script error in the history page\n26/12/2013\tIN045993\tRamesh G\tBru-HIMS-CRF-391-42552/10\n-----------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<!--      <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAMainMenu.css\"></link>\n -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n <!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n    <script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n    <script src=\'../../eCA/js/dTree.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n<body class=\'CA_COMMON\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'> \n<script language=javascript>\n    var obj;\n    obj = new dTree(\'obj\');\n    obj.add(0,-1,\'<font size=1 style=font-weight:bold style=color:#333>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font>\');\n    obj.config.useStatusText=true;\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\ndocument.write(obj);\nobj.openAll();\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con    = null;
	PreparedStatement stmt    = null;
	ResultSet rs            = null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String clinian_id=(String)session.getValue("ca_practitioner_id");
	String facility_id=(String)session.getValue("facility_id");
	String  patient_id			= "";
    String  encounter_id		= "";

	patient_id			=	(request.getParameter("patient_id")==null)		?	""	:	request.getParameter("patient_id");
    encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
    
	String	from_date_time		=	"";
	String  to_date_time		=	"";
	String  note_group			= "";
	String  note_type			= "";
	String  section				= "";
    String  current_encounter	= "";
    String  order_by1			= ""; //possible values are "D"-by Document Date "N" By Note Type
    String  order_by2			= "";
    String  author				= "";
		
	from_date_time		=	(request.getParameter("from_date_time")==null)		?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)		?	""	:	request.getParameter("to_date_time");
    note_group			=	(request.getParameter("note_group")==null)			?	""	:	request.getParameter("note_group");
	note_type			=	(request.getParameter("note_type")==null)			?	""	:	request.getParameter("note_type");
	section				=	(request.getParameter("section")==null)				?	""	:	request.getParameter("section");
	current_encounter	=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	order_by1			=	(request.getParameter("order_by1")==null)			?	""	:	request.getParameter("order_by1");
	order_by2			=	(request.getParameter("order_by2")==null)			?	""	:	request.getParameter("order_by2");
	author				=	(request.getParameter("author")==null)				?	""	:	request.getParameter("author");
	
	from_date_time		=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	//Other Variables
	String groupId1Col		="";
	String groupDesc1Col	="";
	String groupId2Col		="";
	String groupDesc2Col	="";
	
	String groupId1			="";
	String groupDesc1		="";
	String groupId2			="";
	String groupDesc2		="";
	String groupId3			="";
	String groupDesc3		="";
	String groupId4			="";
	String groupDesc4		="";
	String transFacilityId	="";
	String accessionNum		="";

	String prevGroupId1		="";
	String prevGroupId2		="";
	String prevGroupId3		="";

	
	StringBuffer query= new StringBuffer();

	if (order_by1.equals("D"))
	{	
		groupId1Col		=" TO_CHAR(A.EVENT_DATE_TIME,'YYYYMMDD') ";
		groupDesc1Col	=" TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY') ";
		groupId2Col		=" A.ACCESSION_NUM ";
		groupDesc2Col	=" TO_CHAR(A.EVENT_DATE_TIME,'HH24:MI')||' - '||C.NOTE_TYPE_DESC  ";
	}
	else
	{
		groupId1Col		=" A.NOTE_TYPE ";
		groupDesc1Col	=" C.NOTE_TYPE_DESC  ";
		groupId2Col		=" A.ACCESSION_NUM  ";
		groupDesc2Col	=" TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') ";

	}
	query.append(" SELECT A.EVENT_DATE_TIME, "+groupId1Col+" GROUP_ID1, "+groupDesc1Col+" GROUP_DESC1, "+groupId2Col+"	GROUP_ID2,"+groupDesc2Col+" GROUP_DESC2 ");
	query.append("	, B.SEC_HDG_CODE	GROUP_ID3 	, CA_GET_DESC.CA_SECTION_HDG(B.SEC_HDG_CODE,?,'1') GROUP_DESC3	, B.SUBSEC_HDG_CODE	GROUP_ID4	, CA_GET_DESC.CA_SECTION_HDG(B.SUBSEC_HDG_CODE,?,'1') 	GROUP_DESC4 	, A.FACILITY_ID 	, A.ACCESSION_NUM FROM 	  CA_ENCNTR_NOTE A 	, CA_ENCNTR_NOTE_SECTION B 	, CA_NOTE_TYPE_LANG_VW C  WHERE 	C.LANGUAGE_ID = ? AND A.PATIENT_ID=?   AND EVENT_DATE_TIME BETWEEN TO_DATE(NVL(?,'1/1/1900 00:00'),'DD/MM/YYYY HH24:MI') AND  TO_DATE(NVL(?,'1/1/4000 00:00'),'DD/MM/YYYY HH24:MI') AND  C.NOTE_TYPE=A.NOTE_TYPE    AND   B.FACILITY_ID  =A.FACILITY_ID    AND  B.ACCESSION_NUM=A.ACCESSION_NUM          and ( a.EVENT_STATUS  in ('4','5') or (a.EVENT_STATUS='3' and  c.PUBLISH_LEVEL='3')) ");

	//IN045993 Start.
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
	String resp_id			= (String)session.getValue("responsibility_id") == null ? "" : (String) session.getValue("responsibility_id");
	query.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");
	//IN045993 End.
		
	if (!note_group.equals(""))
		query.append(" and c.NOTE_GROUP_ID=? ");
	if (!note_type.equals(""))
		query.append(" and c.NOTE_TYPE=? ");
	if (!section.equals(""))
		query.append(" and b.sec_hdg_code=? "); 
	if (!current_encounter.equals("N"))
		query.append(" and a.facility_id=? and a.encounter_id=? ");
	if (author.equals("S"))
		query.append(" and a.PERFORMED_BY_ID=? ");

	if  (order_by2.equals("AS"))
	{	
			if (order_by1.equals("D"))
			{
				query.append(" ORDER BY  2, 1,4, B.NOTE_SEC_SEQ_NUM");			
			}
			else
			{
				query.append(" ORDER BY  3,2, 1,4, B.NOTE_SEC_SEQ_NUM");			
			}
			
	}
	else
	{
			
			if (order_by1.equals("D"))
			{
				query.append(" ORDER BY 2 desc ,1 desc ,4, B.NOTE_SEC_SEQ_NUM");
			}
			else
			{
				query.append(" ORDER BY 3 DESC, 2 DESC ,4 desc,1 desc, B.NOTE_SEC_SEQ_NUM");
			}

	}
//if order_by1


int    currIndex=0;
//int    count=1;


StringBuffer buf = new StringBuffer();
try
{
	con    = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(query.toString());
	stmt.setString(++currIndex,locale);
	stmt.setString(++currIndex,locale);
	stmt.setString(++currIndex,locale);
	stmt.setString(++currIndex,patient_id);
	stmt.setString(++currIndex,from_date_time);
	stmt.setString(++currIndex,to_date_time);
	if (!note_group.equals(""))
		stmt.setString(++currIndex,note_group);
	if (!note_type.equals(""))
		stmt.setString(++currIndex,note_type);
	if (!section.equals(""))
		stmt.setString(++currIndex,section);
	if (!current_encounter.equals("N"))
	{
		stmt.setString(++currIndex,facility_id);
		stmt.setString(++currIndex,encounter_id);
	}
	if (author.equals("S"))
		stmt.setString(++currIndex,clinian_id);
	
	rs = stmt.executeQuery();
    while(rs.next())
    {
        groupId1		=rs.getString("GROUP_ID1");
		groupDesc1		=rs.getString("GROUP_DESC1").replaceAll("\'","");//IN034385

		if (order_by1.equals("D"))
			groupDesc1 = com.ehis.util.DateUtils.convertDate(groupDesc1,"DMY","en",locale);

		groupId2		=rs.getString("GROUP_ID2");
		groupDesc2		=rs.getString("GROUP_DESC2").replaceAll("\'","");//IN034385
		groupId3		=rs.getString("GROUP_ID3");
		groupDesc3		=rs.getString("GROUP_DESC3").replaceAll("\'","");//IN034385
		groupId4		=rs.getString("GROUP_ID4");
		groupDesc4		=rs.getString("GROUP_DESC4").replaceAll("\'","");//IN034385
		transFacilityId	=rs.getString("FACILITY_ID");
		accessionNum	=rs.getString("ACCESSION_NUM");
		
	  // buf = new StringBuffer();
	   buf.setLength(0);
	   buf.append("?facility_id=" + transFacilityId);
	   buf.append("&accession_num=" + accessionNum);
	   buf.append("&patient_id=" + patient_id);
	   buf.append("&encounter_id=" + encounter_id);
	  
	   if(!groupId1.equals(prevGroupId1))
        {
            out.println("obj.add('G1"+groupId1+"',0,'"+groupDesc1+"');");
 			out.println("obj.add('G2"+groupId2+"','G1"+groupId1+"','"+groupDesc2+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc2+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
 			if (!groupId3.equals(groupId4))
			{
				
				buf.append("&section_hdg_code=" + groupId3);
	  	  		out.println("obj.add('G3"+groupId3+groupId2+"','G2"+groupId2+"','"+groupDesc3+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
			}
			prevGroupId1=groupId1;
			prevGroupId2=groupId2;
			prevGroupId3=groupId3;
			//count++;
        }		
		
		if(!groupId2.equals(prevGroupId2))
        {
			
      		out.println("obj.add('G2"+groupId2+"','G1"+groupId1+"','"+groupDesc2+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc2+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
 			if (!groupId3.equals(groupId4))
			{	
				
				buf.append("&section_hdg_code=" + groupId3);
				out.println("obj.add('G3"+groupId3+groupId2+"','G2"+groupId2+"','"+groupDesc3+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
			
			}
 			prevGroupId2=groupId2;
			prevGroupId3=groupId3;
        }
		if(!groupId3.equals(prevGroupId3))
        {
			if (!groupId3.equals(groupId4))
			{
					buf.append("&section_hdg_code=" + groupId3);
			  		out.println("obj.add('G3"+groupId3+"','G2"+groupId2+"','"+groupDesc3+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
			}
 			prevGroupId3=groupId3;
        }
		
		if (!groupId3.equals(groupId4))
		{
			buf.append("&section_hdg_code=" + groupId3);
			buf.append("&subsection_hdg_code=" + groupId4);

			out.println("obj.add('G4"+groupId4+"','G3"+groupId3+groupId2+"','"+groupDesc4+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
		}
		else
		{	buf.append("&section_hdg_code=" + groupId3);

			out.println("obj.add('G4"+groupId4+"','G2"+groupId2+"','"+groupDesc4+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
		}
		
       	

			   /*out.println("    ");
			   out.println("    ");
			   out.println("    ");*/
	}//end of while 
	
	if(rs != null) rs.close();
    if(stmt != null) stmt.close();
}
catch(SQLException sqle)
{
   // out.println("Exception:" + sqle);//COMMON-ICN-0181
	sqle.printStackTrace();
}

finally
{
    
    if(con != null) ConnectionManager.returnConnection(con,request);
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

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllNotes.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
