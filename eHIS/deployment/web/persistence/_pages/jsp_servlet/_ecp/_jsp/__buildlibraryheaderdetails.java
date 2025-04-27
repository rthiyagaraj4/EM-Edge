package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eOR.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.util.Date;
import com.ehis.eslp.*;
import java.net.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __buildlibraryheaderdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/BuildLibraryHeaderDetails.jsp", 1737611751821L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t    <SCRIPT language=\"JavaScript\" src=\"../../eCP/js/BuildLibrary.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY onKeyDown = \'lockKey()\'  OnMouseDown=\"CodeArrest()\">\n\t<FORM name=\"formHeaderDetails\" id=\"formHeaderDetails\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'left\'  width=\'102%\' >\n\t\t\t<TR>\n\t\t\t\t<TD class=\"label\"  width=\"20%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</TD>\n\t\t\t\t<TD align=\"left\"  class=\"label\"><B>&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</B></TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t\t<TD class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TD>\n\t\t\t\t<TD align=\"left\" class=\"label\"><B>&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t\t<TD class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t\t<TD colspan=\"2\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t\t<TD align=\"Left\" colspan=\"5\"><B>\n\t\t\t\t\t\t<label onClick=\"showTermCodeLookup(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"  style=\'cursor:pointer;color:Blue\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</label></B>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t<input type=\"hidden\" name=\"libraryid\" id=\"libraryid\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"versionno\" id=\"versionno\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</FORM>\n\t<SCRIPT>loadDetail(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')</SCRIPT>\n\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet BuildLibraryTermCode= null;synchronized(session){
                BuildLibraryTermCode=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BuildLibraryTermCode",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BuildLibraryTermCode==null){
                    BuildLibraryTermCode=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BuildLibraryTermCode",BuildLibraryTermCode,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet BuildLibrary= null;synchronized(session){
                BuildLibrary=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BuildLibrary",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BuildLibrary==null){
                    BuildLibrary=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BuildLibrary",BuildLibrary,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 18/10/2005.
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

System.err.println("inside detail");
	BuildLibraryTermCode.clearAll();
	HashMap TermCodeData		=     new HashMap();
    BuildLibrary.clearAll();
	ArrayList TermCode			=     new ArrayList();
	
	String library_id				=	request.getParameter("library_id");
	String version_no				=	request.getParameter("versionon");
	int versionno					=	Integer.parseInt(version_no);

	String termSet					=	"";
	String termCode					=	"";
	String goalCode					=	"";
	String value					=	"";
	String Desc						=	"";
	String diagnosis				=	"";
	String procedure				=	"";
	String tableName				=	"";
	String goalSql					=	"";
	String InterventionSql			=	"";
	String OutcomeSql				=	"";
	String goalMaxgrp				=	"";

	ArrayList Goal					=	null;
	HashMap InterventionOutcome		=	null;
	ArrayList Intervention			=	null;
	ArrayList Outcome				=	null;
	ArrayList TermCodeList			=	null;
	
	Connection connection			=	null;
	Statement stmt					=	null;
	PreparedStatement pstmt			=	null;
	ResultSet rs					=	null;
	String Descsql					=	"";
	String sqlData					=	"SELECT SHORT_DESC,DECODE(STATUS,'D','DRAFT')STATUS FROM CP_LIBRARY_lang_vw WHERE language_id='"+locale+"' and LIBRARY_ID='"+library_id+"'AND VERSION_NO='"+version_no+"'";
	
	
	try{

		connection		=	ConnectionManager.getConnection(request);
		stmt			=	connection.createStatement();
		//Descsql	=	"SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC,B.DIAGNOSIS_YN,B.PROCEDURE_YN FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID='"+library_id+"' AND A.VERSION_NO='"+versionno+"' AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";
		Descsql	=	"SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC,B.DIAGNOSIS_YN,B.PROCEDURE_YN FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID=? AND A.VERSION_NO=? AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";
		pstmt = connection.prepareStatement( Descsql);
		pstmt.setString(1,library_id);
		pstmt.setInt(2,versionno);
		rs=pstmt.executeQuery();
		//rs=stmt.executeQuery(Descsql);
		
		if(rs!=null){
			while(rs.next()){
				termSet		=	(String)rs.getString("TERM_SET_ID");
				termCode	=	(String)rs.getString("TERM_CODE");
				Desc		=	(String)rs.getString("TERMCODE_DESC");
				diagnosis	=	(String)rs.getString("DIAGNOSIS_YN");
				procedure	=	(String)rs.getString("PROCEDURE_YN");
				if(!TermCodeData.containsKey(termSet)){
					TermCodeList=new ArrayList();
					TermCodeList.add(termCode);
					TermCodeList.add(Desc);
					TermCodeList.add("Y");
					TermCodeList.add("U");
					TermCodeData.put(termSet,TermCodeList);
				}else{
					TermCodeList=(ArrayList)TermCodeData.get(termSet);
					TermCodeList.add(termCode);
					TermCodeList.add(Desc);
					TermCodeList.add("Y");
					TermCodeList.add("U");
				}

				
				 if(diagnosis.equals("Y"))
					tableName="MR_D_"+termSet+"_VW";
				 else if(procedure.equals("Y"))
					tableName="MR_P_"+termSet+"_VW";

				TermCode.add(termSet);
				TermCode.add(termCode);
				Goal=new ArrayList();
				TermCode.add(Goal);
				TermCode.add("Y");
				TermCode.add("U");
				TermCode.add(Desc);
				TermCode.add(tableName);

			}
		}
		
		pstmt.close();
		rs.close();

		//goalSql		=	"SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT,A.PRACT_TYPE, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?  AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT ORDER BY GOAL_DESC";
		goalSql		=	"SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT,A.PRACT_TYPE, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?  AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY GOAL_DESC";

		pstmt = connection.prepareStatement( goalSql);
		
		for(int i=0;i<TermCode.size();i=i+7)
		{
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			//goalSql		=	"SELECT A.GOAL_CODE,B.LONG_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT,A.PRACT_TYPE, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = '"+library_id+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT ORDER BY GOAL_DESC";
			

			pstmt.setString(1,library_id);
			pstmt.setInt(2,versionno);
			pstmt.setString(3,termSet);
			pstmt.setString(4,termCode);
			pstmt.setString(5,locale);
			rs=pstmt.executeQuery();
			//rs			=	stmt.executeQuery(goalSql);
			if(rs!=null){
				while(rs.next()){
					InterventionOutcome	=	new HashMap();
					Intervention		=	new ArrayList();
					Outcome				=	new ArrayList();
					InterventionOutcome.put("I",Intervention);
					InterventionOutcome.put("O",Outcome);
					Goal.add(rs.getString("GOAL_CODE"));
					Goal.add(rs.getString("GOAL_TARGET_DURN"));
					Goal.add(rs.getString("GOAL_TARGET_DURN_UNIT"));
					Goal.add(InterventionOutcome);
					Goal.add("Y");
					Goal.add("U");
					Goal.add(value);
					Goal.add(rs.getString("GOAL_DESC"));		
					Goal.add(rs.getString("PRACT_TYPE"));
				}
			}
    		rs.close();
		}
		pstmt.close();



		//InterventionSql		=	"SELECT B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B, CA_INTERVENTION_TYPE C WHERE	A.LIBRARY_ID = ? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE = ? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE ORDER BY INTERVENTION_DESC";
		InterventionSql		=	"SELECT B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE, B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_LANG_VW B, CA_INTERVENTION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE = ? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY INTERVENTION_DESC";

    	pstmt = connection.prepareStatement( InterventionSql);

		for(int i=0;i<TermCode.size();i=i+7){
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalCode			=	(String)Goal.get(j);
					InterventionOutcome =	(HashMap)Goal.get(j+3);
					Intervention		=	(ArrayList)InterventionOutcome.get("I");
					//InterventionSql		=	"SELECT B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B, CA_INTERVENTION_TYPE C WHERE	A.LIBRARY_ID = '"+library_id+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  A.GOAL_CODE = '"+goalCode+"' AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE ORDER BY INTERVENTION_DESC";
	
					pstmt.setString(1,library_id);
					pstmt.setInt(2,versionno);
					pstmt.setString(3,termSet);
					pstmt.setString(4,termCode);
					pstmt.setString(5,goalCode);
					pstmt.setString(6,locale);

					rs=pstmt.executeQuery();
					//rs					=	stmt.executeQuery(InterventionSql);
					if(rs!=null){
						while(rs.next()){
							Intervention.add(rs.getString("INTERVENTION_CODE"));
							Intervention.add(rs.getString("GROUP_ID"));
							Intervention.add(rs.getString("ALT_INTERVENTION_CODE"));
							Intervention.add(rs.getString("REL_START_PERIOD"));
							Intervention.add(rs.getString("REL_START_PERIOD_UNIT"));
							Intervention.add(rs.getString("FREQ_CODE"));
							Intervention.add(rs.getString("FREQ_DURN"));
							Intervention.add(rs.getString("FREQ_DURN_UNIT"));
							Intervention.add(rs.getString("DEPENDENCY_LEVEL"));
							Intervention.add(rs.getString("STAGE_CODE"));
							Intervention.add("Y");
							Intervention.add("U");
							Intervention.add(rs.getString("INTERVENTION_DESC"));						
							
						}
					}
    				rs.close();
				}

			}

		}
		pstmt.close();



		//OutcomeSql			=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
		OutcomeSql			=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE AND B.LANGUAGE_ID = ? ORDER BY OUTCOME_DESC";

		pstmt = connection.prepareStatement( OutcomeSql);

		for(int i=0;i<TermCode.size();i=i+7){
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalCode			=	(String)Goal.get(j);
					InterventionOutcome =	(HashMap)Goal.get(j+3);
					Outcome				=	(ArrayList)InterventionOutcome.get("O");
					//OutcomeSql			=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = '"+library_id+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
					//rs					=	stmt.executeQuery(OutcomeSql);
				
					pstmt.setString(1,library_id);
					pstmt.setInt(2,versionno);
					pstmt.setString(3,termSet);
					pstmt.setString(4,termCode);
					pstmt.setString(5,goalCode);
					pstmt.setString(6,locale);
					rs=pstmt.executeQuery();
					if(rs!=null){
						while(rs.next()){
							Outcome.add(rs.getString("OUTCOME_CODE"));
							Outcome.add(rs.getString("GROUP_ID"));
							Outcome.add(rs.getString("APPL_NATURE"));
							Outcome.add(rs.getString("OUTCOME_TARGET_DURN"));
							Outcome.add(rs.getString("OUTCOME_TARGET_DURN_UNIT"));
							Outcome.add("Y");
							Outcome.add("U");
							Outcome.add(rs.getString("OUTCOME_DESC"));						
						}
					}
			 		rs.close();
				}
			}

		}
		pstmt.close();


		goalMaxgrp	=	"SELECT MAX(GROUP_ID) MAX_COUNT FROM CP_LIBRARY_INTERVENTION WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=?";

		pstmt = connection.prepareStatement( goalMaxgrp);

		for(int i=0;i<TermCode.size();i=i+7){
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalCode	=	(String)Goal.get(j);
					//goalMaxgrp	=	"SELECT MAX(GROUP_ID) MAX_COUNT FROM CP_LIBRARY_INTERVENTION WHERE LIBRARY_ID='"+library_id+"' AND VERSION_NO='"+versionno+"' AND TERM_SET_ID='"+termSet+"' AND TERM_CODE='"+termCode+"' AND GOAL_CODE='"+goalCode+"'";
					//rs			=	stmt.executeQuery(goalMaxgrp);
				
					pstmt.setString(1,library_id);
					pstmt.setInt(2,versionno);
					pstmt.setString(3,termSet);
					pstmt.setString(4,termCode);
					pstmt.setString(5,goalCode);
					rs=pstmt.executeQuery();
					if(rs.next()){
						Goal.set(j+6,rs.getString("MAX_COUNT"));
					}
				   rs.close();
				}
			}
			
		}
		pstmt.close();

		BuildLibrary.putObject(TermCode);
		BuildLibraryTermCode.putObject(TermCodeData);
		rs	=	null;
		rs	=	stmt.executeQuery(sqlData);
		
		if(rs!=null){
			rs.next();	


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString("status")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(library_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(library_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block19Bytes, _wl_block19);
		}
	}catch(Exception e){
		System.err.println("BuildLibraryHeaderDetails "+ e.toString());
		e.printStackTrace();
	}finally{
		try
		{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(pstmt!=null)
			pstmt.close();
		ConnectionManager.returnConnection(connection,request);
		}
		catch(Exception exp)
		{
		//	out.println(exp.toString());//COMMON-ICN-0181
		        exp.printStackTrace();//COMMON-ICN-0181
		}

	}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(library_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryDescription.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.VersionNo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.AssociateTermCode.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
