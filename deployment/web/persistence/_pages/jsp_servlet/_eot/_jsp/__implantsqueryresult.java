package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __implantsqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ImplantsQueryResult.jsp", 1721194520000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n\n<table class=\'grid\'  border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n<th class=\"columnheadercenter\" nowrap> <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</th>\n<th class=\"columnheadercenter\" nowrap> <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</th>\n<!-- <td class=\"columnheadercenter\" nowrap> <!-- changed by yadav \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</td> -->\n<th class=\"columnheadercenter\" nowrap> <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n<td class=\"columnheadercenter\" nowrap> <!-- changed by yadav \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</td> -->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<!-- <td class=\"columnheadercenter\" nowrap <!-- changed by yadav \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</td> -->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<!-- <td class=\"columnheadercenter\"> <!-- changed by yadav \n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</td>  -->\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n</td></tr>\n</table>\n</center>\n\n<br><center>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</center>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String ph_module_yn=request.getParameter("ph_module_yn");
	String params=request.getQueryString();
	String whereClause = checkForNull(request.getParameter("whereclause"));
	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" ) );
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?14:Integer.parseInt(to);
	String sql = " ";
	try{

    String prosthesis_code = checkForNull(request.getParameter( "prosthesis_code" ));
	String long_desc =checkForNull(request.getParameter( "long_desc" ));
	String short_desc = checkForNull(request.getParameter( "short_desc" ));
	String speciality_code = checkForNull(request.getParameter( "speciality_code" ));
	String prosthesis_cat_code = checkForNull(request.getParameter( "prosthesis_cat_code"));
	String prosthesis_type = checkForNull(request.getParameter( "prosthesis_type"));
	String consignment_item_yn = checkForNull(request.getParameter( "consignment_item_yn"));
	String deposit_reqd_yn = checkForNull(request.getParameter( "deposit_reqd_yn"));
	String mm_item_code = checkForNull(request.getParameter( "mm_item_code"));
    String enabled = checkForNull(request.getParameter( "status"));
    String speciality_desc="";
	String item_desc="";
	//out.println("<script>alert('"+content_type+" "+result_linked_rec_type+" "+enabled+" "+sec_hdg_desc+" "+sec_hdr_meta_desc+" "+"')</script>");
	if ( (whereClause == null || whereClause.equals("")) ){
	int cnt=0;
		if ( !(prosthesis_code == null || prosthesis_code.equals("")) ){
	        sql = sql + " and upper(a.prosthesis_code ) like upper('"+prosthesis_code +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" and upper(a.long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}

        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.short_desc) like upper('"+short_desc+"%')";
			else{
				sql=sql+" and upper(a.short_desc) like upper('"+short_desc+"%')";
				cnt=1;
			}

        }
	
	if ( !(speciality_code == null || speciality_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.speciality_code like '"+speciality_code+"%'";
			else{
				sql=sql+" and a.speciality_code like '"+speciality_code +"%'";
				cnt =1;
			}
        }

	if ( !(prosthesis_cat_code == null || prosthesis_cat_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.prosthesis_cat_code= '"+prosthesis_cat_code+"'";
			else{
				sql=sql+" and a.prosthesis_cat_code='"+prosthesis_cat_code +"'";
				cnt =1;
			}
        }

	if ( !(prosthesis_type == null || prosthesis_type.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.prosthesis_type='"+prosthesis_type+"'";
			else{
				sql=sql+" and a.prosthesis_type='"+prosthesis_type +"'";
				cnt =1;
			}
        }
  
  if ( !(consignment_item_yn == null || consignment_item_yn.equals("")) ){
			if(consignment_item_yn.equals("N"))
			if(cnt>0)
			   sql = sql+" and a.consignment_item_yn='N' ";
			else{
				sql=sql+ " and a.consignment_item_yn='N' ";
				cnt=1;

				/* sql = sql+" and nvl(a.consignment_item_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.consignment_item_yn,'N')='N' ";
				cnt=1;*/
			}
         }

	if ( consignment_item_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.consignment_item_yn='Y'";
			else
				sql=sql+ "and a.consignment_item_yn='Y'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

	if ( !(deposit_reqd_yn == null || deposit_reqd_yn.equals("")) ){
			if(deposit_reqd_yn.equals("Y"))
				if(cnt>0)
			   sql = sql+" and a.deposit_reqd_yn='Y' ";
			else{
				sql=sql+ " and a.deposit_reqd_yn='Y' ";
				cnt=1;
			}
         }

	if ( deposit_reqd_yn.equals("N") ){

            if(cnt>0)
			   sql = sql+" and nvl(a.deposit_reqd_yn,'N')='N'";
			else
				sql=sql+ "and nvl(a.deposit_reqd_yn,'N')='N'";
         }

         if ( deposit_reqd_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

	if ( !(mm_item_code == null || mm_item_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.mm_item_code like '"+mm_item_code+"%'";
			else{
				sql=sql+" and a.mm_item_code like '"+mm_item_code +"%'";
				cnt =1;
			}
        }

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.status,'E')='E' ";
			else{
				sql=sql+ " and nvl(a.status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and a.status='D'";
			else
				sql=sql+ "and a.status='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }

    } //end of where clause IF
    else
            sql = whereClause;


/*
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;
*/
int i=1;

Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;
try{
		
		/*String strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS a,OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+)"+sql;
		// String strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality b, mm_item e where d.LANGUAGE_ID='"+locale+"' AND a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;*/
		String strsql="";
		//out.println("Ph_module-->"+ph_module_yn);
		//out.println(sql);
		if(ph_module_yn.equals("Y")){
			//This query is modified by bala based on the inputs given by Vishwa on 19/01/2006
			
			/*strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c, OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality_lang_vw b, mm_item_lang_vw e where d.LANGUAGE_ID='"+locale+"' AND e.language_id=d.language_id AND b.language_id=d.language_id AND a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' AND c.LANGUAGE_ID='"+locale+"' "+sql;*/
			strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,		a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required,			nvl(a.status,'E') status,a.mm_item_code,e.short_desc from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c,OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality_lang_vw b, mm_item_lang_vw e where a.LANGUAGE_ID	 ='"+locale+"' AND a.language_id  = b.language_id(+) AND a.speciality_code = b.speciality_code(+) and a.language_id  = c.language_id(+) AND a.prosthesis_cat_code = c.prosthesis_cat_code(+) and a.language_id  = d.language_id(+) AND a.prosthesis_type = d.prosthesis_type(+) AND a.language_id  = e.language_id(+) AND a.mm_item_code = e.item_code(+) "+sql; 
		}else{
			strsql="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) short_desc, a.prosthesis_cat_code, GET_DESC('"+locale+"','OT_PROSTHESIS_CATEGORY_LANG_VW','PROSTHESIS_CAT_DESC','PROSTHESIS_CAT_CODE',A.PROSTHESIS_CAT_CODE) prosthesis_cat_desc, a.prosthesis_type, GET_DESC('"+locale+"','OT_PROSTHESIS_TYPE_LANG_VW','PROSTHESIS_TYPE_DESC','PROSTHESIS_TYPE',A.PROSTHESIS_TYPE) prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,null short_desc from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY c,OT_PROSTHESIS_TYPE d, am_speciality b where  a.speciality_code=b.speciality_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;
		}

		//String strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESIS a,OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+)"+sql;


        // String strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESISLANG_VW a, OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;

		//String strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,e.short_desc  from OT_PROSTHESISLANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c, OT_PROSTHESIS_TYPE d, am_speciality b, mm_item e where a.speciality_code=b.speciality_code(+) and a.mm_item_code = e.item_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' AND c.LANGUAGE_ID='"+locale+"' "+sql;
		String strsql1="";
		if(ph_module_yn.equals("Y")){
			strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,		a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required,			nvl(a.status,'E') status,a.mm_item_code,e.short_desc from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c,OT_PROSTHESIS_TYPE_LANG_VW d, am_speciality_lang_vw b, mm_item_lang_vw e where a.LANGUAGE_ID	 ='"+locale+"' AND a.language_id  = b.language_id(+) AND a.speciality_code = b.speciality_code(+) and a.language_id  = c.language_id(+) AND a.prosthesis_cat_code = c.prosthesis_cat_code(+) and a.language_id  = d.language_id(+) AND a.prosthesis_type = d.prosthesis_type(+) AND a.language_id  = e.language_id(+) AND a.mm_item_code = e.item_code(+) "+sql;
		}else{
			//strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code,b.short_desc,a.prosthesis_cat_code,c.prosthesis_cat_desc,a.prosthesis_type,d.prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,null short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY_LANG_VW c, OT_PROSTHESIS_TYPE d, am_speciality_lang_vw b where a.speciality_code=b.speciality_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"'  AND c.LANGUAGE_ID='"+locale+"' "+sql;
			strsql1="select a.prosthesis_code,a.long_desc,a.short_desc,a.speciality_code, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) short_desc, a.prosthesis_cat_code, GET_DESC('"+locale+"','OT_PROSTHESIS_CATEGORY_LANG_VW','PROSTHESIS_CAT_DESC','PROSTHESIS_CAT_CODE',A.PROSTHESIS_CAT_CODE) prosthesis_cat_desc, a.prosthesis_type, GET_DESC('"+locale+"','OT_PROSTHESIS_TYPE_LANG_VW','PROSTHESIS_TYPE_DESC','PROSTHESIS_TYPE',A.PROSTHESIS_TYPE) prosthesis_type_desc, nvl(a.consignment_item_yn,'N') consignment, nvl(a.deposit_reqd_yn,'N') deposit_required, nvl(a.status,'E') status, a.mm_item_code,null short_desc  from OT_PROSTHESIS_LANG_VW a, OT_PROSTHESIS_CATEGORY c, OT_PROSTHESIS_TYPE d, am_speciality b where a.speciality_code=b.speciality_code(+) and a.prosthesis_cat_code=c.prosthesis_cat_code(+) and a.prosthesis_type=d.prosthesis_type(+) AND a.LANGUAGE_ID='"+locale+"' "+sql;
		}

		//out.println(strsql);
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e1){
		e1.printStackTrace();
		//out.println("Exception caught "+e1); //e1.printStackTrace(); 
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ImplantsQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ImplantsQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	if(ph_module_yn.equals("Y")){

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	}

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ; // changed by yadav
                else
            classValue = "gridData" ; // changed by yadav
    out.println("<tr><td class='" + classValue + "'>");
    prosthesis_code = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	speciality_code=rset.getString(4);
	speciality_desc=rset.getString(5);
	prosthesis_cat_code=rset.getString(7);
	prosthesis_type=rset.getString(9);
	consignment_item_yn=rset.getString(10);
	deposit_reqd_yn=rset.getString(11);
    enabled=rset.getString(12);
	mm_item_code=rset.getString(13);
	item_desc=rset.getString(14);
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/ImplantsAddModify.jsp?mode="+mode+"&ph_module_yn="+ph_module_yn+"&prosthesis_code="+ prosthesis_code+"'&mm_item_code='"+mm_item_code+" target='f_query_add_mod' >");
    out.println(prosthesis_code+"</a></td>");
  if(speciality_desc==null)
  speciality_desc="&nbsp;";
    if(prosthesis_cat_code==null)
  prosthesis_cat_code="&nbsp;";
	  if(prosthesis_type==null)
  prosthesis_type="&nbsp;";
	 if(item_desc==null)
  item_desc="&nbsp;";

   out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
   out.println("<td class='" + classValue+"'nowrap>"+short_desc+"</td>");
//   out.println("<td class='" + classValue+"'nowrap>"+speciality_desc+"</td>");
   out.println("<td class='" + classValue+"'nowrap>"+prosthesis_cat_code+"</td>");
   out.println("<td class='" + classValue+"'nowrap>"+prosthesis_type+"</td>");
/*    out.println("<td class='" + classValue + "' align='center' nowrap>");
   if ( rset.getString("consignment").equals("N") || rset.getString("consignment").equals("") )
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>"); 
   else
	   out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	   out.println("</td>");
   
	out.println("<td class='" + classValue + "' align='center' nowrap>");
   if ( rset.getString("deposit_required").equals("N") || rset.getString("deposit_required").equals(""))
	   out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
       
   else
	
      out.println("<img src='../../eCommon/images/enabled.gif'></img>");
      out.println("</td>");
	if(ph_module_yn.equals("Y")){
      out.println("<td class='" + classValue+"' nowrap>"+item_desc+"</td>");
	}
      out.println("<td class='" + classValue + "' align='center' nowrap>");
      if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
      else
     	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	    out.println("</td>");*/
	i++;
} 
            _bw.write(_wl_block19Bytes, _wl_block19);

if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
	
catch(Exception e)
{
	e.printStackTrace();//out.println("here "+e);
}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisCode.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsignmentItem.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DepositRequired.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CrossRefMMItem.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
