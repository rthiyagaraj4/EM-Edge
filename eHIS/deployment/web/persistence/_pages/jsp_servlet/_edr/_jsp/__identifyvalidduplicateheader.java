package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __identifyvalidduplicateheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/IdentifyValidDuplicateHeader.jsp", 1709116651995L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped By       :  P.Sudhakaran\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/IdentifyValidDuplicates.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\n\t<!-- <script language=\"javascript\" src=\"../../eDR/js/DRrowcolor.js\" ></script> -->\n\t<Script Language=\"JavaScript\" src=\"../../eDR/js/DRrowcolor.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<form name=\'group_header_form\' id=\'group_header_form\'>\n\t <table border=\'0\' width=\'100%\' cellspacing=\'0\'  id=\'tb1\' > \n\t\t <tr>\n\t\t\t<td class=\'label\' width=\'5%\'></td>\n\t\t\t<td class=\'label\' width=\'75%\'></td>\n\t\t\t<td class=\'label\' width=\'20%\'></td>\n\t\t</tr> \n\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<!-- <table border=\'0\' width=\'100%\' cellspacing=\'0\'  id=\'tb1\' >\n\t\t\t\t <tr>\n\t\t\t\t\t<td class=\'label\' width=\'5%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'75%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'20%\'></td>\n\t\t\t\t</tr> -->\n\t\t\t\t<tr id=\'_";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t\t<td class=\'label\' valign=\'top\'><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\")\'>+</a></td>\n\t\t\t\t\t<td colspan=\'2\' class=\'data\'><a name=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\'changeRowColor(this,3)\' href=\'javascript:callDupGroupDetails(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\' id=\'_a";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t\t</a><br><font size=\'1\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\n\t\t\t\t\t<td align=\'right\' valign=top class=\'label\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</table>\n\t\t\n\t\t<input type=\'hidden\' name=\'p_patcount\' id=\'p_patcount\' value=\'0\'>\n\t    <input type=\'hidden\' name=\'modal\' id=\'modal\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String locale = (String)session.getAttribute("LOCALE");

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt			= con.createStatement();

		String str				= "";
		String p_patient_id		= "";
		String p_patient_line	= ""; 
		int p_dup_group_id	= 0;		
		int p_pat_count		= 0; 		

		int tot_rec = 0;

		String modal		= request.getParameter("modal");		
		String from 		= request.getParameter("from");
		String to			= request.getParameter("to");

		String grp_no = "";

		grp_no =  request.getParameter("grp_no")==null?"":request.getParameter("grp_no");

		if(!(grp_no.equals("")))
			tot_rec = Integer.parseInt(grp_no);

		int x			= 0;
		int time_count	= 0;
		int start 		= 0;
		int end 		= 0;
		int i			= 1;

		if(from == null) start = 1 ;
		else start = Integer.parseInt(from);

		if(to == null) end = 10;
		else end = Integer.parseInt(to);
		
		if(start > tot_rec)
		{
			start = start-10;
		    end = end-10;
			if(start <= 0) start = 1;				
			if(end <= 0) end = 1;				
		}
		
		
            _bw.write(_wl_block8Bytes, _wl_block8);
 	

		str=" SELECT b.dup_group_id, patient_id, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line, pat_count, mp_patient_added_date FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N' AND group_status = 'U' AND sug_valid_pat_flag='Y' "; 	    
		
		rs  = stmt.executeQuery(str);
	
		if(rs != null)
		{
			if(start != 1)
			for(int j=1; j<start; i++,j++)
			{	
				rs.next();						  
			}
			while( rs.next() && i<=end)
			{
				x = x + 1;
				time_count++;

				p_patient_id    = rs.getString("patient_id");
				p_pat_count     = rs.getInt("pat_count");
				p_patient_line	= rs.getString("patient_line") ;
				p_dup_group_id  = rs.getInt("dup_group_id");
                
				
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(x));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);

				i++;
			}
		} if(rs != null) rs.close();

		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(start));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(end));
            _bw.write(_wl_block23Bytes, _wl_block23);


		if(rs != null)	rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
