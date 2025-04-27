package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __catalogforspecialtyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/CatalogForSpecialtyResult.jsp", 1713165801239L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAM/js/CatalogForSpeciality.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<form name=\'stat_grp_nation_detail_result_form\' id=\'stat_grp_nation_detail_result_form\' action=\"../../eAM/jsp/CatalogForSpecialtyResult.jsp\" method=\'post\' >\n\t    <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\n\t<TR id=\'alpha\'>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<TD colspan=\'2\' >\n\t<a href=\"javascript:callMember(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t&nbsp;&nbsp;</td><td>\n\t\t\t<a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t\t</TR>\n\t</table>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t  <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t   \t\t<tr>\n\t\t\t\t<td class=\'columnheader\'  width=\'70%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\'columnheader\'  width=\'30%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><input type=\'hidden\' name=code";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' align=\'center\'><input type=\'checkbox\'  name=\'inc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'inc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onclick = \"remchk(this);\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' align=\'center\'><input type=\'checkbox\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" name=\'inc";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'onclick = \"remchk(this);\">\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t <input type =\'hidden\' name =\'visit_type_id\'  id =\'visit_type_id\' value =\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'> \n\t\t <input type =\'hidden\' name =\'order_cat_id\' id =\'order_cat_id\' value =\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'> \n\t\t <input type =\'hidden\' name =\'old_param\' value =\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'> \n\t\t <input type =\'hidden\' name =\'alphabet\' id =\'alphabet\' value =\' \'>\n\t\t<input type =\'hidden\' name =\'dtl_flag\' id =\'dtl_flag\' value =\' \'>\n\t\t<input type =\'hidden\' name =\'totprvrec\' id =\'totprvrec\' value =\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type =\'hidden\' name =\'maxrecord\' id =\'maxrecord\' value =\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=\'hidden\' name=\'remmem\' id=\'remmem\' value=\'R\' >\n\t\t<input type=\'hidden\' name=\'recval\' id=\'recval\' value=\'1\'>\n\t\t</table>\n\n\t\t</form>\n\t\t<form name=\'stat_grp_nation_detail_result_form1\' id=\'stat_grp_nation_detail_result_form1\'  method=\'post\' target=\'parent.parent.frames[2]\'>\n\t\t<input type=\'hidden\' name=\'maxrecord\' id=\'maxrecord\' value=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >\n\t\t<input type=\'hidden\' name=\'insert_to_db\' id=\'insert_to_db\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\' >\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\n\t<body onKeyDown = \'lockKey()\'>\n   <form name=\'stat_grp_nation_detail_result_form2\' id=\'stat_grp_nation_detail_result_form2\'> \n   <input type =\'hidden\' name =\'visit_type_id\' value =\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t<input type =\'hidden\' name =\'order_cat_id\' value =\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t    <input type =\'hidden\' name =\'alphabet\' value =\' \'>\n\t    <input type =\'hidden\' name =\'dtl_flag\' value =\' \'>\n\t<input type=\'hidden\' name=\'recval\' id=\'recval\' value=\'0\'>\n\t\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<script>callMember(\"A\");</script>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</form>\n     <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t<TR id=\'alpha\'>\n\t\t\t<TD colspan=\'2\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\'javascript:callMember(\"A\")\'>A</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'B\')\">B</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'C\')\">C</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'D\')\">D</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'E\')\">E</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'F\')\">F</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'G\')\">G</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'H\')\">H</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'I\')\">I</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'J\')\">J</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'K\')\">K</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'L\')\">L</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'M\')\">M</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'N\')\">N</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'O\')\">O</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'P\')\">P</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'Q\')\">Q</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'R\')\">R</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'S\')\">S</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'T\')\">T</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'U\')\">U</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'V\')\">V</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'W\')\">W</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'X\')\">X</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Y\')\">Y</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Z\')\">Z</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a>&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t</TR>\n<tr id=\'alpha1\'><td colspan=\'2\'>&nbsp;</td></tr></table>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n\t<body onKeyDown = \'lockKey()\'>\n\t<form name=\'stat_grp_nation_detail_result_form\' id=\'stat_grp_nation_detail_result_form\'>\n\t\t<table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t\t\t<tr>\n\t\t\t\t<th >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" </th>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String checkedOnes="";
	String ord_cat="";
	String first_time=request.getParameter("first_time");
	if(first_time==null)first_time="";

	HashMap statNationalRecSet= null;
	HashMap al= null;
	HashMap ArrLis= null;
	
	statNationalRecSet=(HashMap)session.getValue("StatNationalId");
	ArrLis=(HashMap)session.getValue("arrlis");
	al=(HashMap)session.getValue("al");
	if(first_time.equals("1")||statNationalRecSet==null)
	{

	statNationalRecSet=new HashMap();
	al=new HashMap();
	ArrLis = new HashMap();
	}

	String dtl_flag=request.getParameter("dtl_flag");
	
	Connection con = null;
	ResultSet rset=null ;
	Statement stmt=null;
	ResultSet rset1=null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	try{
		con = ConnectionManager.getConnection(request);


	if( dtl_flag.equals("insert"))
	{
try{
	stmt = con.createStatement();
	String param=request.getParameter("alphabet");
	String old_param=request.getParameter("old_param");
	if( param == null) param="";
	if( old_param == null) old_param="";
	 
	int maxrecord=0;
	int maxrecord1=0;
	
	int totprvrec=0;
	String classValue="";
	
	String totprvrec1=request.getParameter("totprvrec");
	String orcat ="";
		
	if(totprvrec1 == null)	totprvrec=0;
	else totprvrec = Integer.parseInt(totprvrec1) ;
	
	Collection ec= null;
	Iterator ie= null;
	
	


	try{
		for(int kk=0 ; kk<totprvrec ; kk++)
		{
			 ec = statNationalRecSet.values();
			 ie = ec.iterator();
			while(ie.hasNext())
			{
			String ext = (String)ie.next();
			boolean sb1 = ext.startsWith(old_param);
			
			if(sb1)
				{
					statNationalRecSet.remove(ext);
				}

			}
		}
	}catch(Exception e1){
		e1.printStackTrace();
		}
	
	String visit_type_id=request.getParameter("visit_type_id");
	String order_cat_id=request.getParameter("order_cat_id");
	String frmqry=request.getParameter("frmqry");
	
	if( visit_type_id == null) visit_type_id="";
	if( frmqry == null) frmqry="";
	if(!(frmqry.equals("")))
	{
	
	//rset = stmt.executeQuery("select ORDER_CATEGORY from OR_ORDER_CATALOG where ORDER_CATALOG_CODE ='"+frmqry+"'");
	
	String strStmt ="select ORDER_CATEGORY from OR_ORDER_CATALOG where ORDER_CATALOG_CODE =?";
	pstmt   = con.prepareStatement(strStmt);
	pstmt.setString	(	1,	frmqry		);
	rset		 = pstmt.executeQuery();
	
	if(rset != null)
	while(rset.next())
	{
		orcat = rset.getString("ORDER_CATEGORY");
	}

	order_cat_id = orcat;

	if(rset != null )rset.close();
	
	}

	if( order_cat_id == null) order_cat_id="";

	
	String sql="";
	if( ! param.equals(""))
	{
		
		if( param.equals("Others")){
			
		sql=" SELECT a.order_catalog_code, b.long_desc  FROM  am_catalog_for_speciality a, or_order_catalog b WHERE a.SPECIALITY_CODE = ?   AND b.order_category = ?   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'Z' UNION SELECT order_catalog_code, long_desc   FROM or_order_catalog  WHERE order_category = ?   AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'Z' AND order_catalog_code NOT IN (SELECT e.order_catalog_code  FROM am_catalog_for_speciality e, or_order_catalog f WHERE  e.SPECIALITY_CODE = ? AND e.order_catalog_code = f.order_catalog_code AND f.order_category = ?   and upper(substr(f.long_desc,1,1)) not between 'A' and 'Z') order by long_desc  ";	
		
		pstmt   = con.prepareStatement(sql);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);
		pstmt.setString	(	3,	order_cat_id		);
		pstmt.setString	(	4,	visit_type_id		);
		pstmt.setString	(	5,	order_cat_id		);

		
		}else{

		sql = "SELECT a.order_catalog_code, b.long_desc   FROM am_catalog_for_speciality a, or_order_catalog b  WHERE a.SPECIALITY_CODE = ?   AND b.order_category = ?  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '?%' UNION SELECT order_catalog_code, long_desc FROM or_order_catalog WHERE order_category = ? AND eff_status = 'E' and UPPER(LONG_DESC) LIKE '?%' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM am_catalog_for_speciality e, or_order_catalog f WHERE e.SPECIALITY_CODE =  ? AND e.order_catalog_code = f.order_catalog_code AND f.order_category = ? AND UPPER (f.long_desc) LIKE '?%') order by long_desc";
		
			pstmt   = con.prepareStatement(sql);
			pstmt.setString	(	1,	visit_type_id		);
			pstmt.setString	(	2,	order_cat_id		);
			pstmt.setString	(	3,	param		);
			pstmt.setString	(	4,	order_cat_id		);
			pstmt.setString	(	5,	param		);
			pstmt.setString	(	6,	visit_type_id		);
			pstmt.setString	(	7,	order_cat_id		);
			pstmt.setString	(	8,	param		);
		}

	}
	else 
	{

		sql ="SELECT   a.order_catalog_code, b.long_desc  FROM am_catalog_for_speciality a, or_order_catalog b WHERE a.SPECIALITY_CODE = ? AND b.order_category = ? AND a.order_catalog_code = b.order_catalog_code ";
		pstmt   = con.prepareStatement(sql);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);
	}

	//rset=stmt.executeQuery(sql);
	rset		 = pstmt.executeQuery();
	
	String count="";
	
	if( ! param.equals(""))
	{
	
		if( param.equals("Others")){
		count="select count(*) as total from am_catalog_for_speciality a, or_order_catalog b WHERE  a.SPECIALITY_CODE = ?   AND b.order_category = ?   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'Z' UNION SELECT  count(*)  from  or_order_catalog  WHERE order_category = ? AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'Z' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM am_catalog_for_speciality e, or_order_catalog f WHERE  e.SPECIALITY_CODE = ? AND e.order_catalog_code = f.order_catalog_code AND f.order_category = ?   and upper(substr(f.long_desc,1,1)) not between 'A' and 'Z')";
		
		pstmt   = con.prepareStatement(count);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);
		pstmt.setString	(	3,	order_cat_id		);
		pstmt.setString	(	4,	visit_type_id		);
		pstmt.setString	(	5,	order_cat_id		);
		
		} else {
			count = "select count(*) as total from am_catalog_for_speciality a, or_order_catalog b  WHERE a.SPECIALITY_CODE = ?   AND b.order_category = ?  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '?%' UNION SELECT count(*) FROM or_order_catalog  WHERE order_category = ?  AND eff_status = 'E' AND UPPER(LONG_DESC) LIKE '?%' and order_catalog_code NOT IN (SELECT e.order_catalog_code FROM am_catalog_for_speciality e, or_order_catalog f WHERE  e.SPECIALITY_CODE = ? AND e.order_catalog_code = f.order_catalog_code    AND f.order_category = ? AND UPPER (f.long_desc) LIKE '?%')";
			
			pstmt   = con.prepareStatement(count);
			pstmt.setString	(	1,	visit_type_id		);
			pstmt.setString	(	2,	order_cat_id		);
			pstmt.setString	(	3,	param		);
			pstmt.setString	(	4,	order_cat_id		);
			pstmt.setString	(	5,	param		);
			pstmt.setString	(	6,	visit_type_id		);
			pstmt.setString	(	7,	order_cat_id		);
			pstmt.setString	(	8,	param		);
		
		}

	}
	else
	{
		
		count="SELECT count(*) as total FROM am_catalog_for_speciality a, or_order_catalog b WHERE a.SPECIALITY_CODE = ? AND b.order_category = ? AND a.order_catalog_code = b.order_catalog_code";
		
		pstmt   = con.prepareStatement(count);
		pstmt.setString	(	1,	visit_type_id		);
		pstmt.setString	(	2,	order_cat_id		);

	}

	//pstmt=con.prepareStatement(count);
	rset1=pstmt.executeQuery();
	if(rset1 !=null)
	{
		while(rset1.next())
		{
		maxrecord1 = rset1.getInt("total");
		maxrecord = maxrecord+maxrecord1;
		
		}
	}

	if(rset1 != null )rset1.close();
	if(pstmt !=null ) pstmt.close();

	int i=0;
	
	if(maxrecord==0){

	if(!first_time.equals("1"))
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}
 if(param.equals("")){
	
	try{
	
	String sqlVal="select b.long_desc from am_catalog_for_speciality a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.SPECIALITY_CODE='"+visit_type_id+"' "; 
	pstmt=con.prepareStatement(sqlVal);
	rset1 = pstmt.executeQuery();           
		
            if(rset1 !=null)
            {
                 while(rset1.next())
                 {
				    statNationalRecSet.put(""+rset1.getString(1)+"",rset1.getString(1));    
				 }
                
            }

		if(rset1 != null )rset1.close();
		if(pstmt != null )pstmt.close();

     }catch(SQLException e){
		 e.toString();
		 e.printStackTrace();
	
	}
 }
	 al = new HashMap();
		
	if( maxrecord > 0 )
	{
		pstmt = con.prepareStatement("select distinct upper(substr(short_desc,1,1))selaplha  from or_order_catalog where short_desc between 'A%' AND 'Z%' ");
		String selalpha = "";
		ArrayList hr = new ArrayList();
		rset1= pstmt.executeQuery();
		while (rset1.next())
		{
			selalpha = rset1.getString("selaplha");
			hr.add(selalpha);
		}

        if(rset1 != null )rset1.close();
		if(pstmt != null ) pstmt.close();


            _bw.write(_wl_block7Bytes, _wl_block7);

		Iterator e7 = hr.iterator();

	hr.clear();
	         
	while(e7.hasNext())
		{
		 String jj = (String)e7.next();
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		String remmem=request.getParameter("remmem");
		if( remmem == null) remmem="";	
		
		try{
		if(!remmem.equals("R"))
		 {
			 StringTokenizer strtoken=new StringTokenizer(remmem,"|");
			while(strtoken.hasMoreTokens())
			{
				String rno=strtoken.nextToken();					
				statNationalRecSet.remove(rno);	
				ArrLis.put(""+rno+"",rno);
			}
		 }
			for(int kk=0 ; kk<totprvrec ; kk++)
				for(int in=0;in<totprvrec;in++){
				checkedOnes = request.getParameter("inc"+(in));
				if(checkedOnes==null) checkedOnes = "";
			
				if(!checkedOnes.equals(""))
                  {
				    al.put(""+checkedOnes+"",checkedOnes);
				    if(!(statNationalRecSet.containsKey(checkedOnes)))
					 {
						 statNationalRecSet.put(""+checkedOnes+"",checkedOnes);
                     }
				 }
		 	}

		}catch(Exception e){
			e.printStackTrace();
			}
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 
			
			String chkAttribute="";
		    if(rset!=null)
				{
					while(rset.next())
					{
						ord_cat=rset.getString("long_desc");
						if(statNationalRecSet.containsValue(ord_cat))
						{
							chkAttribute = "CHECKED";						
								
						}
						else
								chkAttribute="UNCHECKED";
             
				if ( (i+1) % 2 == 0 )
						classValue = "QRYEVEN" ;
				else
						classValue = "QRYODD" ;
						
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rset.getString("long_desc")));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if( first_time.equals("1") ) { 
					
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block25Bytes, _wl_block25);
 } else {
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block30Bytes, _wl_block30);
		
					i++;

					}
				}

		if(rset != null )rset.close();
		if(stmt != null )stmt.close();
			
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(visit_type_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(order_cat_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(param));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block37Bytes, _wl_block37);

}
else
{ 

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(visit_type_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(order_cat_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
	if(first_time.equals("1"))
	{
	
            _bw.write(_wl_block41Bytes, _wl_block41);
 
		first_time="2";
	}
	
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
	
}

} catch(Exception e){
	//out.println("here: ");
	//out.println(e);
	e.printStackTrace();
} 
finally{
	session.setAttribute("StatNationalId", statNationalRecSet);
	session.setAttribute("arrlis", ArrLis);
	session.setAttribute("al", al);

	statNationalRecSet.clear();
    al.clear();
	ArrLis.clear();
	}
} else
{
	try{
	stmt=con.createStatement();
	int maxrecord=0;
	String classValue="";	
	String visit_type_id=request.getParameter("visit_type_id");
	String order_cat_id=request.getParameter("order_cat_id");
	if( visit_type_id == null) visit_type_id="";
	if( order_cat_id == null) order_cat_id="";
	
	//String sql="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";
		
	//rset=stmt.executeQuery(sql);
	
	String sql="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE=?";
	
	pstmt1   = con.prepareStatement(sql);
	pstmt1.setString	(	1,	visit_type_id		);
	rset		 = pstmt1.executeQuery();

	
	//String count="select count(*) as total  from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";

	String count="select count(*) as total  from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE=?";
	
	pstmt=con.prepareStatement(count);
	pstmt.setString	(	1,	visit_type_id		);
	rset1=pstmt.executeQuery();
	if(rset1!=null)
	{
		while(rset1.next())
		{
		maxrecord = rset1.getInt("total");
		}
	}

	if(rset1 != null )rset1.close();
    if(pstmt != null) pstmt.close();	
 
	int i=0;

            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
 
			 	if(rset!=null)
				{
					while(rset.next() && i<=maxrecord)
					{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							
				
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rset.getString("long_desc")));
            _bw.write(_wl_block48Bytes, _wl_block48);
		
					i++;
					}
				}
   if(rset !=null )rset.close();
   if(stmt != null )stmt.close();
   if(pstmt1 != null )pstmt1.close();

}
catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
	}
}

	}catch(Exception e){
		e.printStackTrace();
		}
finally
{
	try{
        if(rset != null) rset.close();
		if(rset1 != null) rset1.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();

	}catch(Exception e){}
	if(con != null) ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
