package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __mrsearchscreen4 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MRSearchScreen4.jsp", 1722333326293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t\t<script>\n\t\t\tvar prev=0\n\t\t\tfunction  change_row_color(obj)\n\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"t\").rows[prev].cells[0].style.backgroundColor=obj.bgColor\n\t\t\t\t\t//obj.cells(0).style.backgroundColor=\"#B2B6D7\"\n\t\t\t\t\tobj.cells[0].style.backgroundColor=\"#d3d3d3\"\n\t\t\t\t\tprev\t=obj.rowIndex\n\t\t\t}\n\t\t\t//function closewin(code,desc)\n\t\t\tfunction closewin(code,term_set_id,defn_levels,step,desc,old_term_code,select_yn)\n\t\t\t{\n\t\t\t\t//parent.parent.frames[1].document.forms[0].elements(1).disabled=false;\n\t\t\t\twhile(desc.indexOf(\";\")!=-1){\n\t\t\t\t\tdesc=desc.replace(\";\" ,\' \');\n\t\t\t\t}\n\t\t\t\twhile(desc.indexOf(\"|\")!=-1){\n\t\t\t\t\tdesc=desc.replace(\"|\" ,\"\'\");\n\t\t\t\t}\n\t\t\t\twhile(desc.indexOf(\"$\")!=-1){\n\t\t\t\t\tdesc=desc.replace(\'$\' ,\'\"\');\n\t\t\t\t}\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[0].value=desc+\", \"+code;\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[2].value=code;\t\n\t\t\t\tparent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;\n\n\t\t\t\tif(select_yn==\'Y\')\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].elements[1].disabled=false;\n\t\t\t\telse\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].elements[1].disabled=true;\n\t\t\t\t\n\t\t\t\tif(parseInt(defn_levels)>parseInt(step))\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].location.href=\'MRSearchScreen1.jsp?term_set_id=\'+term_set_id+\'&defn_levels=\'+defn_levels+\'&term_code=\'+old_term_code+\'&step=\'+step+\'&p_auth_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Sex=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Dob=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_code_indicator=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\n\t\t\t\t\tvar step_int_val = parseInt(step);\n\t\t\t\t\tstep_int_val = step_int_val + 1;\n\t\t\t\t\tparent.frames[1].location.href=\'MRSearchScreen2.jsp?term_set_id=\'+term_set_id+\'&defn_levels=\'+defn_levels+\'&term_code=\'+code+\'&step=\'+step_int_val+\'&p_auth_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Search_Code=\'+code+\'&Sex=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\n\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/html/blank.html\";\n\n\t\t\t\t\tparent.frames[3].location.href=\"../../eCommon/html/blank.html\";\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction closewinICD10(code,desc,term_set_id)\n\t\t\t{\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[1].disabled=false;\n\t\t\t\twhile(desc.indexOf(\";\")!=-1)\n\t\t\t\t\tdesc=desc.replace(\";\" ,\' \');\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[0].value=desc+\", \"+code;\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements[2].value=code;\n\t\t\t\tparent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;\n\n\t\t\t\t\n\t\t\t\n\t\t\t}\n\t\t</script>\n\t</head>\n\t\n\t<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<table cellspacing=1 cellpadding=2 width=\'100%\' id=\'t\'  border=0 name=\'t\' id=\'t\'>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<tr  onclick=\'change_row_color(this)\'>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<a href=\'javascript:closewin(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\' ><font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<a><br>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</table>\n\t</body>\n</html>\n";
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

request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = checkForNull((String)session.getAttribute("LOCALE")); 


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);


			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs	= null;
			//String fac_id   = (String) session.getValue( "facility_id" ) ;
			String scheme=request.getParameter("Scheme")==null?"":request.getParameter("Scheme");
			String code=request.getParameter("Search_Code")==null?"":request.getParameter("Search_Code");
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			String auth=request.getParameter("p_auth_yn");			
			String step =(request.getParameter("step")==null)?"":request.getParameter("step");
			String defn_levels =(request.getParameter("defn_levels")==null)?"":request.getParameter("defn_levels");	
			String term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");	
			String term_code =(request.getParameter("term_code")==null)?"":request.getParameter("term_code");	

		//String auth=request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");			
			//String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");			

			//out.println(" called_from"+called_from);
			String sql="";
			//String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			//String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_code_indicator));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_code_indicator));
            _bw.write(_wl_block15Bytes, _wl_block15);

			try
			{
				con = ConnectionManager.getConnection(request);
/*
				sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  '" +code+"%' and diag_code_scheme = '"+scheme+"' and nvl(sensitive_yn,'N') =decode('"+auth+"','N','N',nvl(sensitive_yn,'N'))  order by diag_code ";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/				

				/*if(term_set_id.equals("ICD10"))
				{
					sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  ? and diag_code_scheme = ?  ";
					if(p_code_indicator.equals(""))
						sql=sql+" and ( code_indicator in ('C','D') OR code_indicator IS NULL ) ";
					else
						sql=sql+" and code_indicator = '"+p_code_indicator+"'"; 

					sql=sql+" order by diag_code ";
				}
				else
				{*/
					//sql="select  term_code,long_desc , select_yn from mr_term_code where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and term_code like '"+term_code+"%'  order by long_desc";
						/*
							The following query was modified for IN023648.
							Modified On:10/5/2010
						*/
//					sql="select  term_code,long_desc , select_yn from mr_term_code where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and part_term_code = '"+term_code+"' and diagnosis_yn = 'Y'  order by long_desc";
					sql="select  term_code,long_desc , select_yn from mr_d_"+term_set_id+"_lang_vw where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and part_term_code = '"+term_code+"' and diagnosis_yn = 'Y' and language_id='"+locale+"'  order by long_desc";
				//}
				stmt=con.prepareStatement(sql);
				//out.println("<script>alert(\""+sql+"\");</script>");

				/*if(term_set_id.equals("ICD10"))
				{
					stmt.setString(1,code+"%");
					stmt.setString(2,scheme);
				}*/
				
				rs=stmt.executeQuery();
				String s="";
				if(rs!=null){
					while(rs.next()){
						s=rs.getString("long_desc");
						if(s!=null){
							s=s.replace(' ', ';');
							s=s.replaceAll("'", "|");
							s=s.replace('"', '$');
						}
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString("term_code")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(defn_levels));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Integer.parseInt(step)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("select_yn")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Integer.parseInt(step)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("long_desc")));
            _bw.write(_wl_block19Bytes, _wl_block19);
	}

					if (s.equals(""))
					{
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
					//out.println("<script>parent.parent.frames[1].document.forms[0].elements(1).disabled=false;</script>");
				    }
				}
			
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
			}
			catch(Exception e){e.printStackTrace();}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
