package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.StringTokenizer;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mtpvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MTPValidate.jsp", 1732512356286L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block4 ="\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n<script src=\"../../eCommon/js/ValidateControl.js\"\tlanguage=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\"\t\t\tlanguage=\"javascript\"></script>\n<script src=\'../js/MTP.js\'                          language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n<form name =\"validateForm\" method = \"post\" action = \"../../eCA/jsp/MTPEventsList.jsp\" target = \"mtp_events\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<input type =\"hidden\" name =\"srcpatid\" value =\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\t<input type =\"hidden\" name =\"srcencid\" value =\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<input type =\"hidden\" name =\"patient_id\" value =\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t<input type =\"hidden\" name =\"enc_id\" value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type =\"hidden\" name =\"mode\" value =\"2\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar msg = getMessage(\"RECORD_INSERTED\",\"CA\");\n\n\t\t\t\t\tif (msg!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t\t\t\tdocument.forms[0].submit();\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar msg = getMessage(\"FAILED_OPERATION\",\"CA\");\n\n\t\t\t\t\tif (msg!=\"\")\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

	String strSrcPatId		=	"",				strSrcEncId			=	"";
	String strTgtPatId		=	"",				strTgtEncId			=	"";
	String strCheckVal		=	"",				strQuery			=	"";
	String strPRQry			=	"",				strEpisodeId		=	"";
	String strPatClass		=	"",				strAccNumber		=	"";
	String strHistRecType	=	"",				strContSysId		=	"";
	String strContSysEvCode	=	"",				strTotalRecs		=	"";
	String strVisitId		=	"";
	String mtpInsertQuery = "";

	Connection	con			=	null;
	PreparedStatement pstmt	=	null;
	PreparedStatement mtpPstmt = null;
	ResultSet rs			=	null;

	java.util.Properties p	=	(java.util.Properties) session.getValue( "jdbc" );
	String addedById		=	p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
	String addedAtWSNo		=	(String) session.getValue( "facility_id" ) ;

	strSrcPatId				=	checkForNull(request.getParameter("srcpatid"));
	strSrcEncId				=	checkForNull(request.getParameter("srcencid"));
	strTgtPatId				=	checkForNull(request.getParameter("tgtpatid"));
	strTgtEncId				=	checkForNull(request.getParameter("tgtencid"));
	strCheckVal				=	checkForNull(request.getParameter("selopt"));


	strTotalRecs			=	checkForNull(request.getParameter("cntselrecs"));

	int nUpdStatus			=	0;

	boolean bUpdStatus		=	true;

	if(strTotalRecs.equals("") )
		strTotalRecs	=	"0";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strSrcPatId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strSrcEncId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strTgtPatId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strTgtEncId));
            _bw.write(_wl_block10Bytes, _wl_block10);

	try
	{
		con			=	ConnectionManager.getConnection(request);

		strPRQry	=	"SELECT PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM FROM PR_ENCOUNTER WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? ";

		strQuery	=	"UPDATE CR_ENCOUNTER_DETAIL SET PATIENT_ID = ?,ENCOUNTER_ID = ?,EPISODE_ID = ?,PATIENT_CLASS = ?,PROTECTION_IND ='Z',VISIT_ID = ?,MODIFIED_DATE = SYSDATE,MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID = ?  WHERE ACCESSION_NUM = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND CONTR_SYS_EVENT_CODE = ? AND PATIENT_ID = ? AND ENCOUNTER_ID = ? ";

		if( !strCheckVal.equals("") )
		{
			strCheckVal		=	strCheckVal.substring(0,strCheckVal.length()-1);
			
			try
			{
				pstmt	=	con.prepareStatement(strPRQry);
				
				pstmt.setString(1,strTgtPatId);
				pstmt.setString(2,strTgtEncId);

				rs	=	 pstmt.executeQuery();

				if(rs != null && rs.next() )
				{
					strPatClass		= checkForNull(rs.getString(1));
					strEpisodeId	= checkForNull(rs.getString(2));
					strVisitId		= checkForNull(rs.getString(3));
				}
			}
			catch (Exception e23)
			{
				
				e23.printStackTrace();
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			
			
			StringTokenizer stMain		=	 new StringTokenizer(strCheckVal,",");
			pstmt		=	con.prepareStatement(strQuery);

			while(stMain.hasMoreTokens())
			{
				String strSub		=	 stMain.nextToken();
				StringTokenizer stSub	=	new StringTokenizer(strSub,":");
				strAccNumber	=	stSub.nextToken();
				strHistRecType	=	stSub.nextToken();
				strContSysId	=	stSub.nextToken();
				strContSysEvCode=	stSub.nextToken();

				try
				{
					pstmt.clearParameters();

					pstmt.setString(1,strTgtPatId);
					pstmt.setString(2,strTgtEncId);
					pstmt.setString(3,strEpisodeId);
					pstmt.setString(4,strPatClass);
					pstmt.setString(5,strVisitId);
					pstmt.setString(6,addedById);
					pstmt.setString(7,addedAtWSNo);
					pstmt.setString(8,strAccNumber);
					pstmt.setString(9,strHistRecType);
					pstmt.setString(10,strContSysId);
					pstmt.setString(11,strContSysEvCode);
					pstmt.setString(12,strSrcPatId);
					pstmt.setString(13,strSrcEncId);
	
					try
					{
						nUpdStatus	= pstmt.executeUpdate();

					}
					catch (Exception e31)
					{						
						e31.printStackTrace();
						bUpdStatus = false;
					}

					if(nUpdStatus < 0)
					{
						bUpdStatus = false;
						break;
					}
				}
				catch (Exception e26)
				{					
					e26.printStackTrace();
				}
			}

			/*
			The below block was Added by
			Name   : DINESH T 
			Date   : 2010-06-03
			Purpose: Audit details for the patient confidentiality
			*/
			//Starts here
			mtpInsertQuery = "insert into CA_MTP_AUDIT_LOG values(?,?,?,?,?,SYSDATE)";
			mtpPstmt = con.prepareStatement(mtpInsertQuery);

			mtpPstmt.setString(1,strSrcPatId);
			mtpPstmt.setString(2,strTgtPatId);
			mtpPstmt.setString(3,strSrcEncId);
			mtpPstmt.setString(4,strTgtEncId);
			mtpPstmt.setString(5,addedById);

			mtpPstmt.executeUpdate();
			//Ends here

			if(bUpdStatus)
			{
				con.commit();
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			else
			{
				con.rollback();
				
            _bw.write(_wl_block12Bytes, _wl_block12);

			}	
		}
	}
	catch (Exception e22)
	{
		
		e22.printStackTrace();
		con.rollback();
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
