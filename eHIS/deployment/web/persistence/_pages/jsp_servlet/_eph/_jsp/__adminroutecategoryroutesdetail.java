package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __adminroutecategoryroutesdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/AdminRouteCategoryRoutesDetail.jsp", 1709120593922L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- TerminologyCodeForCaseTypeDetail.jsp -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script> \n<script language=\"JavaScript\" src=\"../../ePH/js/AdminRouteCategoryRoutes.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n<body  onLoad=\"FocusFirstElement();\" onKeyDown = \"lockKey();\"  OnMouseDown=\"\"> <!--/**\n * @Name - Sandhya A \n * @Date - 18/12/2009\n * @Inc# - IN016185\n * @Desc - added lockKey() in <body> onKeyDown() event.\n */-->\n<form name=\'form_AdminRoutedetail\' id=\'form_AdminRoutedetail\' action=\"../../ePH/jsp/AdminRouteCategoryRoutesDetail.jsp\" method=\'post\' >\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<script>\n\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?\';\n\t\t</script>\n\t\t<table width=\'100%\'>\n\t\t<tr>\n\t\t<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t</tr>\n\t\t<table>\n\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'100%\' >\n\t\t\t<th width=\'13%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\t\t\t\n\t\t\t<th width=\'7%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<BR><INPUT type=\"checkbox\" name=\"chkAll\" id=\"chkAll\"  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onclick=\"selectAll(this);\"></th>\n\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' align=\"left\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\t\t\t\t\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'><input type=\'checkbox\' name=\'chk";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'chk";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onclick=\"setchkAll(this);\"> </td>\n\t\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t<input type=\'hidden\' name=\'route_code\' id=\'route_code\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'maxRecords\' id=\'maxRecords\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t<input type=\'hidden\' name=\"admin_route_categ_code\" id=\"admin_route_categ_code\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\t\n\t<input type=\'hidden\' name=\"alphalink\" id=\"alphalink\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t<input type=\'hidden\' name=\"search_criteria\" id=\"search_criteria\" value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=\'hidden\' name=\"short_desc\" id=\"short_desc\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'> \n\n\t</table>\n\t<script>\n\t\tcheckselectAll();\n\t</script> \n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t<script>\n\t\t\tvar message=getMessage(\"NO_RECORD_FOUND\",\"Common\");\n\t\t\tparent.f_query_detail.location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+message;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\n\t</form>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet AdminRouteCategoryRoutes= null;synchronized(session){
                AdminRouteCategoryRoutes=(webbeans.eCommon.RecordSet)pageContext.getAttribute("AdminRouteCategoryRoutes",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AdminRouteCategoryRoutes==null){
                    AdminRouteCategoryRoutes=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("AdminRouteCategoryRoutes",AdminRouteCategoryRoutes,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");

//Added by Himanshu for MMS-ME-SCF-0097 Starts 
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff"); 
//Added by Himanshu for MMS-ME-SCF-0097 ends

	String locale=(String)session.getAttribute("LOCALE");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
  	
	Connection con=null;
	String classValue="";	
	String checked="";	
	String admin_route_categ_code="";	
	String sql_associated="";
	String route_code="" , short_desc="";	
	String search_criteria="" ,search_text="";// selected="";
	Statement stmt_Associated=null;	
	String sql_nature="";
	String sql_case_type="";
	String from = request.getParameter("from");
	String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;

	String chkAttribute="" ,disabled="";
	String dbaction="";
	String  req_start   =   "", req_end     =   "" ;
	String alphalink ="";
	String code="";

	
	ResultSet rset_Associated=null ;

	try{
		con = ConnectionManager.getConnection(request);		
		admin_route_categ_code=request.getParameter("admin_route_categ_code")==null ? "":request.getParameter("admin_route_categ_code");		
		short_desc=request.getParameter("short_desc")== null?"":request.getParameter("short_desc");
		search_criteria=request.getParameter("search_criteria")== null?"":request.getParameter("search_criteria");
		 if(search_criteria.equals("S"))
			search_text = short_desc +"%";
		 else if(search_criteria.equals("E"))
			search_text ="%"+short_desc;
		 else if(search_criteria.equals("C"))
			search_text = "%"+short_desc+"%";
		 else
			search_text = "%";	
			
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 7; }   else {  end = Integer.parseInt( to ) ; }
        
               
        req_start       =   request.getParameter("start")==null ?"0" : request.getParameter("start");
        req_end         =   request.getParameter("end")==null ? "0" : request.getParameter("end");
		
		alphalink = request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		if(alphalink.equals("*"))
		{
			alphalink="_";
		}


            _bw.write(_wl_block9Bytes, _wl_block9);
	
		ArrayList TabList		=	null;
		ArrayList sessionList	=  (ArrayList)AdminRouteCategoryRoutes.getRecordSetHandle();
		//out.println(sessionList);
		if(sessionList.size()>0)
		{
			//TabList=(ArrayList)AdminRouteCategoryRoutes.getObject(0);
		}
		if(alphalink.equals("Associated"))
		{			
			 sql_associated="SELECT a.route_code, b.route_desc short_desc,'U' db_action FROM ph_admin_route_catg_dtl a, ph_route b WHERE a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code ORDER BY 2";			
		}
		else
		{			
			 sql_associated="select route_code, route_desc short_desc, 'I' db_action from ph_route where (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"') and upper(route_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z' and upper(route_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and route_code not in (select route_code from ph_admin_route_catg_dtl where admin_route_catg_code = '"+admin_route_categ_code+"') UNION ALL select a.route_code, b.route_desc short_desc, 'U' db_action from ph_admin_route_catg_dtl a, ph_route b where a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"') and upper(route_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z' and upper(route_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"' || '"+search_text+"'))) ORDER BY 2 "; 			
		}


		//System.out.println("==fggfg=="+"srch_crt+="+search_criteria+"=+++="+search_text+"=+++"+sql_associated);
		stmt_Associated=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset_Associated=stmt_Associated.executeQuery(sql_associated);
		rset_Associated.last();
		maxRecord = rset_Associated.getRow();
		rset_Associated.beforeFirst();
		if(maxRecord > 0){	

            _bw.write(_wl_block10Bytes, _wl_block10);

	    if ( !(start <= 1)) {
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start-7)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end-7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	    }
	    if ( !((start+7) > maxRecord )){
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((start+7)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	    }
	
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rset_Associated.next() ;
			}
		 }
		//out.println("start "+start+ " i->"+i+" - "+end);
		while(rset_Associated.next() && i< end){

			route_code = rset_Associated.getString("route_code");
			short_desc=rset_Associated.getString("short_desc");			
			dbaction=rset_Associated.getString("db_action");			
			
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			disabled="";
				
			if(dbaction.equals("U")){
				if(alphalink.equals("Associated")){
						disabled="";						
				}
				else
					disabled="Disabled";
			}
			int index=-1;
			for(int j=0; j<AdminRouteCategoryRoutes.getSize();j++){
				ArrayList temp_list = (ArrayList)AdminRouteCategoryRoutes.getObject(j);
				 code=(String)temp_list.get(0);
				if(code.equals(route_code)){
					index=j;
					break;
				}
			}
			if(index!=-1){
				chkAttribute="checked";
				TabList = (ArrayList)AdminRouteCategoryRoutes.getObject(index);				
			}
			else{
				TabList=null;
				chkAttribute="";				
			}
			

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block34Bytes, _wl_block34);

		i++;
	chkAttribute="";
/*	if(TabList.size()>0)
		flag=1;*/
	
		}
			

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(start));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(end));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(admin_route_categ_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
	
	}
	else{
            _bw.write(_wl_block46Bytes, _wl_block46);
}
	}catch(Exception e){

		System.err.println(e.toString());
		e.printStackTrace();
	}
	finally { 
		if(rset_Associated!=null) rset_Associated.close();	
		if(stmt_Associated!=null) stmt_Associated.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AdminRouteCategoryRoutes", AdminRouteCategoryRoutes);
	}	
	
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RouteCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
