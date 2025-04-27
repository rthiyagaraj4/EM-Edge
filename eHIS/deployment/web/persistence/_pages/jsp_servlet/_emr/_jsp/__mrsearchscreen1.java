package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __mrsearchscreen1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MRSearchScreen1.jsp", 1722174772538L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\tvar prev=0\n\t\tfunction  change_row_color(obj){\n\t\t\tdocument.getElementById[\'t\'].rows(prev).cells[0].style.backgroundColor=obj.bgColor\n\t\t\tobj.cells(0).style.backgroundColor=\"#d3d3d3\"\n\t\t\tprev\t=obj.rowIndex\n\t\t}\n\t\tfunction loadOtherFrame(code,term_set_id,defn_levels,step,desc,select_yn,oldstep){\n\t\t\twhile(desc.indexOf(\";\")!=-1)\n\t\t\tdesc=desc.replace(\";\" ,\' \');\n\t\t\tparent.parent.frames[1].document.forms[0].elements[0].value=desc+\", \"+code;\n\t\t\tparent.parent.frames[1].document.forms[0].elements[2].value=code;\n\t\t\tparent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;\n\t\t\tif(defn_levels==oldstep){\n\t\t\t}else{\n\t\t\t\tparent.frames[1].location.href=\'MRSearchScreen2.jsp?term_set_id=\'+term_set_id+\'&defn_levels=\'+defn_levels+\'&term_code=\'+code+\'&step=\'+step+\'&p_auth_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Search_Code=\'+code+\'&Sex=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Dob=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_code_indicator=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t}\n\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\' \n\t\t\tif(select_yn==\'Y\'){\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[1].disabled=false;\n\t\t\t}else{\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[1].disabled=true;\n\t\t\t}\n\t\t}\n\t\tfunction loadOtherFrameICD10(code){\n\t\t\tparent.frames[1].location.href=\'MRSearchScreen2.jsp?term_set_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_auth_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\' \n\t\t\tparent.parent.frames[1].document.forms[0].elements(1).disabled=true\n\t\t}\n\t\t</script>\n\t</head>\n\t<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<table cellspacing = 1 cellpadding = 2 width = \'100%\' id = \'t\'  border = 0 name = \'t\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<tr  onclick=\'change_row_color(this)\'>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:loadOtherFrame(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" ><font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<a><br>\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</table>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = checkForNull((String)session.getAttribute("LOCALE")); 

		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con=null; 
		PreparedStatement pstmt 	= null;
		Statement stmt 	= null;
		ResultSet rs		 	= null;
		StringBuffer sql= new StringBuffer();
		StringBuffer sql_count= new StringBuffer();
		StringBuffer nb = new StringBuffer();
		String auth=(request.getParameter("p_auth_yn")==null)?"":request.getParameter("p_auth_yn");
		String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
		String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		String p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");
		String step =(request.getParameter("step")==null)?"":request.getParameter("step");
		String defn_levels =(request.getParameter("defn_levels")==null)?"":request.getParameter("defn_levels");	
		String term_code =(request.getParameter("term_code")==null)?"":request.getParameter("term_code");
		String term_set_id="";
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		String exceds_chapdef_limit ="N";
		if(title.equals("ICD10 Code List")){
			term_set_id =(request.getParameter("p_diag_scheme_desc")==null)?"":request.getParameter("p_diag_scheme_desc");
		}else{
			term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
		}
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_code_indicator));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_code_indicator));
            _bw.write(_wl_block15Bytes, _wl_block15);

					try{
						con = ConnectionManager.getConnection(request);
						/*
							The following query was modified for IN023648.
							Modified On:10/5/2010
						*/
//						sql.append("select term_code, long_desc, select_yn from mr_term_code where term_set_id =? and code_level=? and term_code !='*OTH' and diagnosis_yn = 'Y'");
						sql.append("select term_code, long_desc, select_yn from mr_d_"+term_set_id+"_lang_vw where term_set_id =? and code_level=? and term_code !='*OTH' and diagnosis_yn = 'Y' and language_id='"+locale+"'");
						//	sql.append("select term_code, long_desc, select_yn from mr_term_code where term_set_id = '"+p_diag_scheme_desc+"' and code_level='"+step+"'");
						if(!term_code.equals("")){
							sql.append(" and part_term_code =?");
						}
						sql.append(" order by long_desc ");
						//stmt=con.prepareStatement(sql_count.toString());
						pstmt = con.prepareStatement(sql.toString());
						pstmt.setString(1,term_set_id);
						pstmt.setString(2,step);
						if(!term_code.equals("")){
							pstmt.setString(3,term_code);
						}
						rs		 =	pstmt.executeQuery();
						int maxRecords=0;
						if(rs!=null){
							String s="";
							while(rs.next()){	
								s=rs.getString("long_desc");
								if(s!=null){
									s=s.replace(' ', ';');
								}
								//Handle url special character
								String vr_Statement =s;
								char[] newstr = vr_Statement.toCharArray();
								for(int i=0; i<newstr.length;i++){
									if (Character.isLetter(newstr[i])||(Character.isDigit(newstr[i]))){
										nb.append(newstr[i]);
									}
								}
								String sv = nb.toString();
								nb.setLength(0);
								
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString("term_code")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(defn_levels));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Integer.parseInt(step)+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sv));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("select_yn")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Integer.parseInt(step)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("long_desc")));
            _bw.write(_wl_block19Bytes, _wl_block19);

								maxRecords++;
								if(maxRecords>=2000){
									exceds_chapdef_limit ="Y";
									break;
								}
							}
							//if (s.equals("") && !term_set_id.equals("ICD10"))
							if (maxRecords==0){
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
							//out.println("<script>parent.parent.frames[1].document.forms[0].elements(1).disabled=false;</script>");
							}
						}
						if(exceds_chapdef_limit.equals("Y")){
						out.println("<script>alert(getMessage('CHP_DEF_ERR','MR'))</script>");
						out.println("<script>document.getElementById('t').style.display='none'</script>");
						}
						if(rs!=null)	rs.close();
						if(stmt!=null)	stmt.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						if(con!=null)ConnectionManager.returnConnection(con, request);
					}
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
