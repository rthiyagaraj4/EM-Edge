package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __workplacerequirementqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/WorkplaceRequirementQueryResult.jsp", 1709121672667L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script> -->\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../js/WorkplaceRequirement.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tfunction Modify(wrkplace_code,wrkplace_desc,loc_type,frm_dt,to_dt,reqd_id,reqd_desc,fac_id)\n\t{\n\t\tvar mode = \"2\";\n\t\tparent.parent.frames[1].location.href=\"../../eRS/jsp/WorkPlaceRequirementModifyFrameset.jsp?mode=\"+mode+\"&wrkplace_code=\"+wrkplace_code+\"&wrkplace_desc=\"+wrkplace_desc+\"&loc_type=\"+loc_type+\"&frm_dt=\"+frm_dt+\"&to_dt=\"+to_dt+\"&reqd_id=\"+reqd_id+\"&reqd_desc=\"+reqd_desc+\"&facility_id=\"+fac_id;\n\t}\n\t</script>\n</head>\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'QueryForm\' id=\'QueryForm\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n <table cellpadding=0 cellspacing=0 width=\"98%\" align=\"center\">\n<tr>\n\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td>\n</tr>\n</table>\n<table cellpadding=0 cellspacing=0 border=1 width=\'98%\'>\n<tr>\n\n\t<th width=\'3%\'>&nbsp;</th>\n\t<th width=\"20%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t<th width=\"50%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t<th width=\"27%\" colspan=\'2\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n</tr>\n<tr>\n\t<th width=\'3%\'>&nbsp;</th>\t\n\t<th colspan=\'2\'>&nbsp;</th>\n\t<th width=\"\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t<th width=\"\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\n\t\t<tr> \n\t\t\t<td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" align=center><A id=\'consent\' href=\'javascript:displayReqdDetls(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\'>+</A>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onmouseover=\"changeCursor(this);\" onClick=\"Modify(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\"> \t<font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</table>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);</script>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String classvalue = "";
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

        try{
		String facility_id		=(String)session.getAttribute( "facility_id" );
		String wrk_place_code	= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
		String locn_type 		= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
		String wrk_desc			= request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
		String requirement = request.getParameter("requirement")==null?"":request.getParameter("requirement");
		String sql_select="";
		boolean searched	= request.getParameter( "searched" ) == null? false : true  ;
		//Common parameters.
		HashMap sqlMap = new HashMap();
		
		if(requirement.equals("F"))
			//sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id and (trunc(a.requirement_date_fm)>trunc(sysdate)  or a.requirement_type = 'C')";
			sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace_lang_vw b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id and (trunc(a.requirement_date_fm)>trunc(sysdate)  or a.requirement_type = 'C') and b.language_id = ?";
		else
			//sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id";
			sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace_lang_vw b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id and b.language_id = ?";
			
		sqlMap.put( "sqlData",sql_select);
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("wrk_code");
		displayFields.add("workplace_desc");
		displayFields.add("frm_dt");
		displayFields.add("to_dt");
		displayFields.add("fac_id");
		displayFields.add("reqd_id");
		displayFields.add("reqd_type");
		displayFields.add("flag");
		displayFields.add("locn_type"); 
		displayFields.add("reqd_desc"); 	

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add( wrk_place_code+"%" );
		chkFields.add( locn_type+"%" );
		chkFields.add( wrk_desc+"%" );
		chkFields.add(facility_id);
		chkFields.add( locn_type);	
		chkFields.add( locale);	
	

		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		
		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=new ArrayList();
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
		
		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

		Con=ConnectionManager.getConnection(request);
		
			pstmt=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
			rslRst=pstmt.executeQuery();
			rslRst.next();
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
			ConnectionManager.returnConnection(Con,request);
			
 
            _bw.write(_wl_block8Bytes, _wl_block8);

	// For display the previous/next link
	
     out.println(result.get(1));
	 

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			String link_columns = "1";
			
			records=(ArrayList) result.get( recCount );
			
			
			String wrkplace_code = (String)records.get(0)==null?"":(String)records.get(0);
			
			String wrkplace_desc = (String)records.get(1)==null?"":(String)records.get(1);
			//String wrkplace_desc = "";
						
			String frm_dt		 = (String)records.get(2)==null?"":(String)records.get(2);
			//String frm_dt		 = "";
						
			String to_dt		 = (String)records.get(3)==null?"":(String)records.get(3);			
			//String to_dt		 = "";			
			

			String fac_id		 = (String)records.get(4)==null?"":(String)records.get(4);
			//String fac_id		 = "";
			String reqd_id		 = (String)records.get(5)==null?"":(String)records.get(5);
			//String reqd_id		 = "";
			String flag			 = (String)records.get(7)==null?"":(String)records.get(7);
			//String flag			 = "";
			String loc_type		 = (String)records.get(8)==null?"":(String)records.get(8);
			//String loc_type		 = "";
			String reqd_desc	 = (String)records.get(9)==null?"":(String)records.get(9);
			//String reqd_desc	 = "";
			

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wrkplace_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(reqd_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

		for(int colCount=0; colCount<4; colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 && (flag.equalsIgnoreCase("L")))	{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(wrkplace_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(wrkplace_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(frm_dt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(to_dt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reqd_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reqd_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
			else{
				String str = (String)records.get(colCount);
				if(str!=null)
				{
					if(colCount==2||colCount==3)
						str=com.ehis.util.DateUtils.convertDate(str,"DMY","en",locale);	
				}
				if(str == null) str ="&nbsp;"; else str = str.trim();

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}
			}//end of for loop

            _bw.write(_wl_block27Bytes, _wl_block27);

		}//L00p for all records

            _bw.write(_wl_block28Bytes, _wl_block28);

		out.flush();
	}
	else{

            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	out.println(CommonBean.setForm(request ,"../../eRS/jsp/WorkPlaceRequirementQueryResult.jsp", searched));
}catch(Exception e ){
	out.println(e);
}

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkplaceCode.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkplaceDescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.RequirementPeriod.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
