package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCA.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCA.Common.*;
import java.util.zip.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __physicannotesdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PhysicanNotesDetails.jsp", 1742464522698L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\" src=\'../js/PhysicianNote.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<style>\n\tADDRESS\t{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n</style>\n</head>\n<body class=\'CONTENT\' >\n<!-- onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" -->\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n<form name=\'result_form\' id=\'result_form\'>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' id=\'tb1\'>\n<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<td class=\'white\' align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n</tr>\n</table>\n</form>\n</body>\n<!-- Added for ML-MMOH-CRF-2149 start -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<!-- Added for ML-MMOH-CRF-2149 end -->\n<script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n    function preventTextSelection() {\n        if (document.body.addEventListener) {\n            document.body.addEventListener(\'selectstart\', function(e) {\n                e.preventDefault();\n            });\n        } else if (document.body.attachEvent) {\n            document.body.attachEvent(\'onselectstart\', function(e) {\n                e.returnValue = false;\n            });\n        }\n    }\n\n    ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n        preventTextSelection();\n    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             	100           	 ?					?				?           created
02/04/2014	IN048271	Ramesh G	02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
24/06/2018	IN065341	Prakash C	25/06/2018		Ramesh G		ML-MMOH-CRF-0115
05/10/2018	IN068396	Raja S		05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
04/01/2019	IN069365	Raja S		04/01/2019		Ramesh G		ML-BRU-SCF-1908
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
14/08/2024	65094			Kishore Kumar	 16/08/2024    Ramesh Goli      ML-MMOH-CRF-2149
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
String accession_num=request.getParameter("accession_num");
String sql			="";
Connection con		=null;
ResultSet rs		=null;
PreparedStatement stmt		=null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
//StringBuffer notes_content = new StringBuffer();
String	notes_content		=	"";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;
//IN065341 starts
String bean_id = "ca_CentralizedBean" ;
String bean_name = "eCA.CentralizedBean";
CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(localeName);
bean.clear() ;
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
//IN065341 ends

try
	{
		con					=ConnectionManager.getConnection(request);
		if(clob_data.equals("_CDR")){
			bean.executeCDR(con,patient_id,encounter_id,RepDb,"CA_ENCNTR_NOTE");
		} 
		rs					=null;
		stmt				=null;
		//sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc FROM ca_encntr_note a where  a.accession_num=? ";
		//6484 Start.
		//sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE##REPDB##(a.note_type,?,'1') note_type_desc FROM ca_encntr_note##CLOB## a where  a.accession_num=? ";
		sql="SELECT a.note_content,a.compress_note_content_yn,a.compress_note_content, CA_GET_DESC.CA_NOTE_TYPE##REPDB##(a.note_type,?,'1') note_type_desc FROM ca_encntr_note##CLOB## a where  a.accession_num=? ";
		//6484 End.
		sql=sql.replaceAll("##REPDB##",RepDb);
		sql=sql.replaceAll("##CLOB##",clob_data);
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,accession_num);
		rs=stmt.executeQuery();

		
		if(rs.next())
		{
			//6484 Start.
			if("Y".equals(rs.getString("compress_note_content_yn")==null?"":(String)rs.getString("compress_note_content_yn"))){
				
				java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_note_content");
				if(note_blob!=null && note_blob.length()>0){
					InputStream ins1 = note_blob.getBinaryStream();
					ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
					int i;
					while((i = ins1.read()) != -1) 
						bytearrayoutputstream.write(i);
					
					byte[] compressed	=bytearrayoutputstream.toByteArray();
					if(compressed.length > 0){
						if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
							GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
							BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

							String line;
							while ((line = bufferedReader.readLine()) != null) {
								notes_content += line;
							}
						}					
					}
				}				
			}else{
			//6484 End.
				clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");
				if(clob_notes_content != null)
				{
					try
					{
						content_reader	= clob_notes_content.getCharacterStream();
						bf_content_reader = new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						notes_content = new String(arr_notes_content);
						bf_content_reader.close();
					}catch(Exception e){
						//out.println("Exception@2-readCLOB : "+e);//common-icn-0181
					e.printStackTrace();//COMMON-ICN-0181
					}
					if(!notes_content.equals(""))
					{
						notes_content = notes_content.replaceAll("<HTML><BODY><PRE>","<PRE>");				
						notes_content = notes_content.replaceAll("</PRE></BODY></HTML>","</PRE>");			
						notes_content = notes_content.replaceAll("line-height: 100%"," ");			//IN068396
						int nIndex	= notes_content.indexOf("<BODY>");
						int nIndex1 = notes_content.lastIndexOf("</BODY>");

						if(nIndex != -1 && nIndex1 != -1)
							notes_content = notes_content.substring(nIndex+6,nIndex1);
						notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
					}
				}
			} //6484
		}		
		if(rs!=null)			rs.close();
		if(stmt!=null)			stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception"+e.toString());
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}



	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String facilityId = (String)session.getValue("facility_id");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
notes_content = notes_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML-MMOH-SCF-2966 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);

    String copyRestrict = bean.getCopyRestrict(facilityId);
    String copyRestrictPreview = bean.getCopyRestrictPreview(facilityId);
    String restrictPreviewNotes = bean.getRestrictPreviewNotes();

            _bw.write(_wl_block13Bytes, _wl_block13);

    if ("Y".equals(copyRestrict) && ("PHYSICIAN_NOTES1".equals(restrictPreviewNotes)||"PHYSICIAN_NOTES".equals(restrictPreviewNotes))){
    
            _bw.write(_wl_block14Bytes, _wl_block14);

    }
    
    if ("Y".equals(copyRestrictPreview) && "CLINICAL_NOTES".equals(restrictPreviewNotes)) {
    
            _bw.write(_wl_block14Bytes, _wl_block14);

    }
    
            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Notescontent.label", java.lang.String .class,"key"));
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
