package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __newprocedureaddmodifymulti extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureAddModifyMulti.jsp", 1709119746000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- Modified 9/16/2005 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../js/NewProcedure.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  onload=\'\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<form name=\'multi_procedure\' id=\'multi_procedure\' method=\'post\' target=\'messageFrame\' action=\'\'>\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" align=center id=\'term_associated\'>\n<tr>\n\t<td class=columnheader width=\'80%\'>Procedure</td>\n\t<td class=columnheader width=\'20%\'>Select</td>\n</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n<tr>\n\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' align=\'\'><font size=\"1\"><a href=\"javascript:showTermDetails(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a></font></td>\n\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' align=\'center\'>  \n\t<input type=\"checkbox\" name=\"multi_proc_chk";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"multi_proc_chk";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" checked>\n\t</td>\n</tr>\n\t\t<input type=\"hidden\" name=\"termset_id";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"termset_id";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\t\t\n\t\t<input type=\"hidden\" name=\"term_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"term_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\"hidden\" name=\"code_level";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"code_level";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"termdetails";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"termdetails";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"\">\n\t\t\n\t\t\t<!--<script>alert(document.forms[0].all.term_codeS";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =".value)</script> -->\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<tr>\n\t\t\t<td class=\'CAHIGHER\' align=\'\' colspan=\'2\'><font size=\"1\"><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b></font></td>\n\t\t\t<!-- <td class=\'CAHIGHER\' align=\'\'>\n\t\t\t</td> -->\n\t\t</tr>\t\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<tr>\n\t\t\t<td class=\'CAHIGHER\' align=\'\' colspan=\'2\'><font size=\"1\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t\t\t<!-- <td class=\'CAHIGHER\' align=\'\'></td> -->\n\t\t</tr>\t\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</a></font></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' align=\'center\'>  \n\t\t\t<input type=\"checkbox\" name=\"multi_proc_chk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" checked>\n\t\t\t</td>\n\t\t</tr>\n\t\t\t<input type=\"hidden\" name=\"termset_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type=\"hidden\" name=\"termgrp_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"termgrp_id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t<input type=\"hidden\" name=\"termdetails";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"\">\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n</table>\n\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\"term_set_id\" id=\"term_set_id\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"temp_term_code\" id=\"temp_term_code\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\"hidden\" name=\"term_code_associated\" id=\"term_code_associated\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"radioval\" id=\"radioval\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"currentdate\" id=\"currentdate\" value =\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet TerminologyLookup= null;synchronized(session){
                TerminologyLookup=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyLookup",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyLookup==null){
                    TerminologyLookup=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyLookup",TerminologyLookup,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

		
	String mode	   = request.getParameter( "mode" ) ;
	//String proc_code = request.getParameter("note_type")==null?"":request.getParameter("note_type") ;
	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set") ;
	String term_code_associated = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated") ;
	//String level1 = request.getParameter("level")==null?"":request.getParameter("level") ;
	String radioval = request.getParameter("radioval")==null?"G":request.getParameter("radioval") ;

		
	String classvalue="";//String checked = "";
	//int db_count=0;
	String temp_term_code="";
	//String tag = "",tag1="";
	//out.println("=request.getQueryString()=="+request.getQueryString()+"=====");	
	//String temp_db_chk = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy H:mm" ) ;
	String	currentdate			= dateFormat.format(new java.util.Date()) ;
	//String	onset_date			= currentdate;
	//out.println("=term_code_associated============"+term_code_associated+"====");
	StringTokenizer stoken=new StringTokenizer(term_code_associated,"`");
	int cnt=stoken.countTokens();
//out.println("=cnt============"+cnt+"====");
	StringBuffer sql1= new StringBuffer();
	Connection con      = null;
	PreparedStatement pstmt	= null;
	ResultSet rset		= null;
try
{
	con = ConnectionManager.getConnection(request);
	
	//sql1.append("SELECT TERM_SET_ID,TERM_GROUP_ID,TERM_GROUP_DESC FROM MR_TERM_GROUP_HDR WHERE  EFF_STATUS = 'E' AND TERM_SET_ID LIKE NVL(?,TERM_SET_ID) AND TERM_GROUP_APPLICABLITY ='P' ORDER BY 1,2");
	
	sql1.append("SELECT a.term_set_id TERM_SET_ID,a. term_group_id term_group_id,a. term_group_desc, b.term_code term_code,d.short_desc term_code_description, d.code_level code_level,DECODE (d.code_level,'1', level_1_desc,'2', level_2_desc,'3', level_3_desc,'4', level_4_desc,'5', level_5_desc,'6', level_6_desc,'7', level_7_desc,  '8', level_8_desc,'9', level_9_desc,'10', level_10_desc) code_level_desc, c.term_set_desc term_set_desc,c.term_set_id term_set_id FROM mr_term_group_hdr a, mr_term_group_dtl b, mr_term_set c, mr_term_code d WHERE a.eff_status = 'E' AND a.term_set_id LIKE NVL (?, a.term_set_id) AND a.term_group_applicablity = 'P' AND b.term_set_id = c.term_set_id AND c.term_set_id = d.term_set_id AND b.term_code = d.term_code AND b.term_group_id = a.term_group_id AND b.term_set_id = a.term_set_id ORDER BY 1,2,3");
	

            _bw.write(_wl_block11Bytes, _wl_block11);
 //String term_assc_temp = "";
String term_code="",level="",level_code_desc="",term_code_desc=""; 

if(radioval.equals("C"))
cnt =1;
//out.println("===="+radioval+"===");
if(cnt > 0){
//for(int i=0;i<cnt;i++)
//	{
	//out.println("<script>alert('=tag=="+tag+"==tag1=="+tag1+"==db_count="+db_count+"==i="+i+"==')</script>"
	//	out.println("<script>alert('checked ="+checked+" &&  i="+i+"')</script>");
		/*if(stoken.hasMoreTokens()){
				term_assc_temp=stoken.nextToken();
				StringTokenizer token= new StringTokenizer(term_assc_temp,"~");
				term_code=token.nextToken();
				level=token.nextToken();
				level_code_desc=token.nextToken();
				term_code_desc=token.nextToken();
				temp_term_code +=term_code+"~";
				if(level.equals(""))
					level = "0";
		}*/
	ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
	cnt = TerminologyLookup.getSize();
	HashMap Termcode= new HashMap();
	//TerminologyLookup.clearAll();
	//out.println("--Termcode-size-"+Terminology.size()+"====");
	if(Terminology.size()>0)
	{
		//Termcode=(HashMap)Terminology.get(0);
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		//while(Terminology.size() >1){
		//	TerminologyLookup.removeObject(1);
		//}
		//out.println("--Termcode-s-"+TerminologyLookup.getSize()+"====");
	}
		int i=0;
		Set itr_set			=	Termcode.keySet();
		//out.println("--Termcode--"+Termcode.size()+"====");
		Iterator recordItr	=	itr_set.iterator();
		while(recordItr.hasNext()){
			String grpid1="";
			grpid1=(String)recordItr.next();
			//out.println("--value--"+((grpid1))+"====");
			
			if((Termcode.get(grpid1)) != null && (Termcode.get(grpid1)).equals("Y") && (grpid1.indexOf("|")) != -1 ){
			
				StringTokenizer token= new StringTokenizer(grpid1,"|");
				term_code=token.nextToken();
				term_code_desc=token.nextToken();
			
				//out.println("--term_code--"+term_code+"===-term_code_desc--"+term_code_desc+"====");
				level="";
				level_code_desc="";
				
			
	if ( i % 2 == 0 )
		classvalue = "QRYEVEN" ;
	else
		classvalue = "QRYODD" ;
	
	
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
//=tmp_setid
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(level));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
 i++;
			}
			
		}
//}
}else{
	int i=0;
	cnt = TerminologyLookup.getSize();
	ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
	HashMap Termcode= new HashMap();
	String tmp_grpdesc = "",tmp_grpid="",tmp_setid="",chk_val="";
	//TerminologyLookup.clearAll();
	if(Terminology.size()>0)
	{
		//Termcode=(HashMap)Terminology.get(0);
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		while(Terminology.size() >1){
			TerminologyLookup.removeObject(1);
		}
		out.println("--Termgrpcode-s-"+TerminologyLookup.getSize()+"====");
	}
	//if(sql1.length() > 0) sql1.delete(0,sql1.length());
	//sql1.append(" ");
    try
	{
		pstmt =con.prepareStatement(sql1.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,"");
		rset=pstmt.executeQuery();
		String tmp_head ="",tmp_grpdesc1="",tmp_setdesc="",tmp_desc="";
		while(rset!=null && rset.next())
		{
			tmp_setid = rset.getString(1);
			tmp_grpid = rset.getString(2);
			tmp_grpdesc = rset.getString(3);
			tmp_desc	=rset.getString(5);
			tmp_setdesc =rset.getString(8);
			if(Termcode.containsKey(tmp_setid+tmp_grpid)){
				chk_val = (String)Termcode.get(tmp_setid+tmp_grpid);
				//out.println("==in=="+(String)Termcode.get(tmp_setid+tmp_grpid));
				if(chk_val != null && chk_val.equals("Y")){
					
					if ( i % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
					if(!tmp_head.equals(tmp_setid)){
						tmp_head = tmp_setid;   
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tmp_setdesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
}if(!tmp_grpdesc1.equals(tmp_grpdesc)){
						tmp_grpdesc1 = tmp_grpdesc;   
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tmp_grpdesc));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tmp_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tmp_setid));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tmp_grpid));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
 
			i++;
				}
			}			

			

			
		}
		
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		
		
	}catch(Exception e){
		System.out.println("Exception "+e.toString());
		e.printStackTrace();
	}
	
}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(temp_term_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(term_code_associated));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(radioval));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block48Bytes, _wl_block48);


} 
catch(Exception e)
{
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block49Bytes, _wl_block49);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
