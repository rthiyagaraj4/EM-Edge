package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.zip.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotessearchdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesSearchDetails.jsp", 1742465715958L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" <!-- IN066793 -->\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<title>RecClinicalNotesSearchDetails</title>\n\t<!-- IN066793 starts -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<style>\n\t\t\t\tADDRESS\t{ FONT-FAMILY: Segoe UI ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t\tPRE\n\t\t{\n\t\t\tfont-size:10pt;\t\t\t\n\t\t\tfont-family: \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";\n\t\t\t//BACKGROUND-COLOR: #E2E3F0;\n\t\t\tBACKGROUND-COLOR: #FFFFFF;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\t\t\n\t\t}\t\n\t\t/* IN054024 End. */\n\t</style>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<style>\n\t\t/* IN043895 Start.  */\n\t\t/*ADDRESS\t{ FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }*/\n\t\t\t/*IN049424 Start.*/\n\t\t\t\t/*ADDRESS\t{ \n\t\t\t\t\tFONT-FAMILY: \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\" ;\n\t\t\t\t\tFONT-SIZE: 10pt ; \n\t\t\t\t\tFONT-STYLE: NORMAL; \n\t\t\t\t\tCOLOR: BLACK; \n\t\t\t\t}*/\n\t\t\t\tADDRESS\t{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t\t\t/*IN049424 End.*/\t\t\n\t\t/* IN054024 Start. */\n\t\tPRE\n\t\t{\n\t\t\tfont-size:10pt;\t\t\t\n\t\t\tfont-family: \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";\n\t\t\t//BACKGROUND-COLOR: #E2E3F0;\n\t\t\tBACKGROUND-COLOR: #FFFFFF;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\t\t\n\t\t}\t\n\t\t/* IN054024 End. */\n\t</style>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<form name=\'RecClinicalNotesSearchDetailsForm\' id=\'RecClinicalNotesSearchDetailsForm\'>\n<div id=\"note_content\">\n<table class=\'grid\' width=\'100%\' align=\'center\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t <tr>\n\t\t\t\t\t<td class=\'gridData\'> ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t </table>\n\t </div>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?					?				?           created
29/06/2012	IN030468		Dinesh T			?				?			BRUHIMS CRF.
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
02/04/2014	IN048271		Ramesh G		02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
16/03/2015  IN054024		Ramesh G										There is an issue for 1 patient where the Report Header Contents as well as the Note Header 
																			Contents do not display on preview print as well as in the Print out.
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064																			
05/10/2018	IN068396		Raja S			05/10/2018		Ramesh G		ML-MMOH-CRF-1237
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
29/08/2023  48833           Srinivasa N T        21/08/2023      SRINIVASA N T 
--------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);
 
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String note_status		=	(request.getParameter("note_status")==null)	? "" : request.getParameter("note_status");
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	if(sitespecific)
	{	
	
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else
	{	
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection			con			=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs					=	null;

	String	query_notes_detail	=	"";
	String	facility_id					=	"";
	String	accession_num			=	"";
	String	notes_content			=	"";

	//oracle.sql.CLOB			clob_notes_content	= null;
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	try	
	{
		

		facility_id		=	(request.getParameter("facility_id")==null)		? "" : request.getParameter("facility_id");

		accession_num	=	(request.getParameter("accession_num")==null)	? "" : request.getParameter("accession_num");

		con				=	ConnectionManager.getConnection(request);
		//6484 Start.
		//query_notes_detail = "select a.note_content, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc from ca_encntr_note a where a.accession_num = ?";//IN030468
		query_notes_detail = "select a.note_content,a.compress_note_content,a.compress_note_content_yn, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc from ca_encntr_note a where a.accession_num = ?";		
		//6484 End.
		pstmt			=	con.prepareStatement(query_notes_detail);

		pstmt.setString(1, locale);
		pstmt.setString(2, accession_num);//IN030468

		rs				=	pstmt.executeQuery();

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
				if(clob_notes_content!=null)
				{
					try
					{
						content_reader	= clob_notes_content.getCharacterStream();
						bf_content_reader = new java.io.BufferedReader(content_reader);

						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

						notes_content = new String(arr_notes_content);						
						bf_content_reader.close();
					}
					catch(Exception e)
					{
						//out.println("Exception@2-readCLOB : "+e);//common-icn-0181
					e.printStackTrace();//COMMON-ICN-0181
					}				
				}
							
			}
			//6484 Start.
			if(!"".equals(notes_content)){
				notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
				notes_content=notes_content.replaceAll("line-height: 100%"," ");//IN068396
				notes_content=notes_content.replaceAll("line-height: 120%"," ");//IN068396
				notes_content = notes_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
			}
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block11Bytes, _wl_block11);
	
			//6484 end.
		} // end of if(rs.next())
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
