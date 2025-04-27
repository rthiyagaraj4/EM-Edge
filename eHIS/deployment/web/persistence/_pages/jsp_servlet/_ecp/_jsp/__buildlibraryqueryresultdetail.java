package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __buildlibraryqueryresultdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/BuildLibraryQueryResultDetail.jsp", 1737614525713L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n</head>\n<Title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</Title>\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<Form>\n<SCRIPT language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t<BR>\n\t <table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>\n\t\t<th width=\"25%\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td align=\"left\" class=\'ATCLIB\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td align=\"left\" class=\'ATCLIB\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr><td align=\"left\" class=\'ATCTERMSET\' colspan=\"3\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td></TR>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<tr><td align=\"left\" class=\'ATCTERMCODE\'colspan=\"3\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td></tr>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<TR>\n\t\t\t<TD colspan=\"3\" align=\"left\"  class=\'ATCGOAL\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</TD>\n\t\t</TR>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<TR><TD colspan=\"3\" align=\"left\"  class=\'ATCHEAD\' style=\"border: none;\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[I] ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TD></TR>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<TR><TD colspan=\"3\" align=\"left\"  class=\'ATCHEAD\'style=\"border: none;\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[O] ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD></TR>\n\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<TR><TD colspan=\"3\" align=\"left\"  class=\'ATCHEAD\'style=\"border: none;\" >&nbsp;</TD></TR>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</table>\n\t<BR>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmtgoal=null;
	PreparedStatement pstmtIntvn=null;
	PreparedStatement pstmtOutcome=null;
	PreparedStatement pstmt = null;//common-icn-0180
	ResultSet termcoders=null;
	ResultSet goalrs=null;
	ResultSet Intvnrs=null;
	ResultSet Outcomers=null;

	String libraryid=request.getParameter("library_id")==null?"":request.getParameter("library_id");
	String versionno=request.getParameter("versionno")==null?"1":request.getParameter("versionno");
	int version_no=Integer.parseInt(versionno);
	String desc=request.getParameter("short_desc")==null?"":request.getParameter("short_desc");

	String termcodeQuery="";
	String termCode="";
	String termSet="";
	String termdesc="";
	String prevtermSet="";

//	String goalQuery="SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC  FROM CP_LIBRARY_GOAL A, CP_OUTCOME B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE ORDER BY GOAL_DESC";
	String goalQuery="SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC FROM CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE AND B.LANGUAGE_ID = ? ORDER BY GOAL_DESC";
	String goalCode="";

//	String InterventionSql	=	"SELECT B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,A.GROUP_ID FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B WHERE	A.LIBRARY_ID =? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE =? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE ORDER BY INTERVENTION_DESC";
	String InterventionSql	=	"SELECT B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,A.GROUP_ID FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_lang_vw B WHERE	A.LIBRARY_ID =? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE =? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND B.LANGUAGE_ID = ? ORDER BY INTERVENTION_DESC";
//	String OutcomeSql		=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID =?   AND  A.TERM_CODE = ?  AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
	String OutcomeSql		=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID =?   AND  A.TERM_CODE = ?  AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE AND B.LANGUAGE_ID = ? ORDER BY OUTCOME_DESC";

	String groupid="";
	String tempString="";

	String intvndesc="";
	String outcomedesc="";
	HashMap Group=null;
	ArrayList GroupDetail=null;

	//int index=1;
	int k=0;

	/*if(!index1.equals(""))
		index=Integer.parseInt(index1);*/
	try{

		conn = ConnectionManager.getConnection(request);
		//stmt = conn.createStatement();//common-icn-0180
		pstmtgoal = conn.prepareStatement(goalQuery);
		pstmtIntvn=conn.prepareStatement(InterventionSql);
		pstmtOutcome=conn.prepareStatement(OutcomeSql);	
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

		//termcodeQuery="SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID='"+libraryid+"' AND A.VERSION_NO='"+versionno+"' AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";//common-icn-0180
        termcodeQuery="SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID=? AND A.VERSION_NO=? AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";//common-icn-0180
        pstmt=conn.prepareStatement(termcodeQuery);//common-icn-0180
        pstmt.setString(1, libraryid);//common-icn-0180
        pstmt.setString(2, versionno);//common-icn-0180
        termcoders = pstmt.executeQuery();//common-icn-0180
       // termcoders = stmt.executeQuery(termcodeQuery);//common-icn-0180
		if(termcoders!=null)
		{
			while(termcoders.next()){
				termCode=termcoders.getString("TERM_CODE");
				termSet=termcoders.getString("TERM_SET_ID");
				termdesc=termcoders.getString("TERMCODE_DESC");
				if(!prevtermSet.equals(termSet)){
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(termdesc));
            _bw.write(_wl_block18Bytes, _wl_block18);

				pstmtgoal.setString(1,libraryid);
				pstmtgoal.setInt(2,version_no);
				pstmtgoal.setString(3,termSet);
				pstmtgoal.setString(4,termCode);
				pstmtgoal.setString(5,locale);
				goalrs=pstmtgoal.executeQuery();
				if(goalrs!=null){
					while(goalrs.next()){
						goalCode=goalrs.getString("GOAL_CODE");
						Group=new HashMap();
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(goalrs.getString("GOAL_DESC")));
            _bw.write(_wl_block20Bytes, _wl_block20);
			
						pstmtIntvn.setString(1,libraryid);
						pstmtIntvn.setInt(2,version_no);
						pstmtIntvn.setString(3,termSet);
						pstmtIntvn.setString(4,termCode);
						pstmtIntvn.setString(5,goalCode);
						pstmtIntvn.setString(6,locale);
						Intvnrs=pstmtIntvn.executeQuery();
						if(Intvnrs!=null){
							while(Intvnrs.next()){
								groupid=Intvnrs.getString("GROUP_ID");
								if(Group.containsKey(groupid)){
									GroupDetail=(ArrayList)Group.get(groupid);
									GroupDetail.add(Intvnrs.getString("INTERVENTION_CODE"));
									GroupDetail.add(Intvnrs.getString("INTERVENTION_DESC"));
									GroupDetail.add("");
									GroupDetail.add("");

								}else{
									GroupDetail=new ArrayList();
									GroupDetail.add(Intvnrs.getString("INTERVENTION_CODE"));
									GroupDetail.add(Intvnrs.getString("INTERVENTION_DESC"));
									GroupDetail.add("");
									GroupDetail.add("");
									Group.put(groupid,GroupDetail);
								}
							}
						}
						Intvnrs.close();
						groupid="";
						pstmtOutcome.setString(1,libraryid);
						pstmtOutcome.setInt(2,version_no);
						pstmtOutcome.setString(3,termSet);
						pstmtOutcome.setString(4,termCode);
						pstmtOutcome.setString(5,goalCode);
						pstmtOutcome.setString(6,locale);
						Outcomers=pstmtOutcome.executeQuery();
						if(Outcomers!=null){
							while(Outcomers.next()){
								groupid=Outcomers.getString("GROUP_ID");
								if(Group.containsKey(groupid)){
									k=0;
									GroupDetail=(ArrayList)Group.get(groupid);
									for(int i=0;i<GroupDetail.size();i=i+4){
										tempString=(String)GroupDetail.get(i+2);
										if(!tempString.equals(""))
											k=k+4;
										else
											break;
									}
									if(k<GroupDetail.size()){
										GroupDetail.set(k+2,Outcomers.getString("OUTCOME_CODE"));
										GroupDetail.set(k+3,Outcomers.getString("OUTCOME_DESC"));
									}else{
										GroupDetail.add("");
										GroupDetail.add("");
										GroupDetail.add(Outcomers.getString("OUTCOME_CODE"));
										GroupDetail.add(Outcomers.getString("OUTCOME_DESC"));
									}
								}
							}
						}
						Outcomers.close();
						//System.err.println("Group in goal  "+Group);
						Set itr_set			=	Group.keySet();
						Iterator recordItr	=	itr_set.iterator();
						while(recordItr.hasNext()){
							groupid="";
							groupid=(String)recordItr.next();
							GroupDetail=(ArrayList)Group.get(groupid);
							for(int i=0;i<GroupDetail.size();i=i+4){
								intvndesc=(String)GroupDetail.get(i+1);
								outcomedesc=(String)GroupDetail.get(i+3);
								if(!intvndesc.equals("")){
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(intvndesc));
            _bw.write(_wl_block22Bytes, _wl_block22);

								}
								if(!outcomedesc.equals("")){
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(outcomedesc));
            _bw.write(_wl_block24Bytes, _wl_block24);

								}

							}
		
            _bw.write(_wl_block25Bytes, _wl_block25);

						}
		
					}
				}
			prevtermSet=termSet;
            goalrs.close();
		}
	}



            _bw.write(_wl_block26Bytes, _wl_block26);
	
	}catch(Exception e){
		//out.println(e.getMessage());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally 
	{
		if(termcoders!=null)
			termcoders.close();
		if(goalrs!=null)
			goalrs.close();
		if(Intvnrs!=null)
			Intvnrs.close();
		if(Outcomers!=null)
			Outcomers.close();
		if(pstmtgoal!=null)
			pstmtgoal.close();
		if(pstmtIntvn!=null)
			pstmtIntvn.close();
		if(pstmtOutcome!=null)
			pstmtOutcome.close();
		if(pstmt!=null)//common-icn-0180
			pstmt.close();//common-icn-0180
		if (stmt != null) 
			stmt.close();
		if(conn != null)
		ConnectionManager.returnConnection(conn,request);
	}

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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.VersionNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
