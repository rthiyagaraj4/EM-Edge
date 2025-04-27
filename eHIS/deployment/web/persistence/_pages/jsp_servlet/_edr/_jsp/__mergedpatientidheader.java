package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;

public final class __mergedpatientidheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergedPatientIDHeader.jsp", 1730779196105L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergedPatientIds.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\n\t<!-- <script language=\"javascript\" src=\"../../eDR/js/DRrowcolor.js\" ></script> -->\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/rowcolor.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\'group_header_form\' id=\'group_header_form\'>\n\n\t<table border=0 width=\'100%\' cellspacing=0  id=\'tb1\'>\n\t\t<tr>\n\t\t\t <td class=label width=\'5%\'></td>\n\t\t\t <td class=label width=\'75%\'></td>\n\t\t\t <td class=label width=\'20%\'></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script> \n\t\t\t//var ErrorText = \'DR0009 - Patient Record does not exist\';\n\t\t\tvar ErrorText = getMessage(\"NO_RECORD\",\"DR\");\n\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script> \n\t\t\tvar ErrorText = \'\';\n\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<tr id=\'_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t\t\t<td class=\'label\' valign=top><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\'>+</a></td>\n\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\'label\'><a name=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onClick=\'changeRowColor(this,3)\' href=\'javascript:callDupGroupDetails(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\' id=\'_a";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t\t\t\t\t\t\t\t\t</a><br>\n\t\t\t\t\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td align=\'right\' valign=top class=\'label\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n</table>\n\t\t<input type=hidden name=\"p_patcount\" id=\"p_patcount\" value=0>\n</form>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//String locale = (String)session.getAttribute("LOCALE");

	Connection          con   = null;
	java.sql.Statement	stmt  = null;
	ResultSet	        rs	  = null;
	
	String              str   = "";
	String	   p_patient_id	  = "";
	String   p_patient_line	  = "";
	String              sql	  = "";
	
	int         p_pat_count	  = 0;
	int      p_dup_group_id	  = 0; 
	int       p_pat_rec_cnt	  = 0;

 try
   {
	String whereClause       = request.getParameter("whereclause");
	String from              = request.getParameter( "from" ) ;
	String to	             = request.getParameter( "to" ) ;
	String p_to_replace_date = request.getParameter( "p_to_replace_date" ) ;
	String p_fm_replace_date = request.getParameter( "p_fm_replace_date" ) ;
	if (p_to_replace_date==null || p_to_replace_date.equals("null") || p_to_replace_date.equals("")) 
				p_to_replace_date="31/12/5000";
	if (p_fm_replace_date==null || p_fm_replace_date.equals("null") || p_fm_replace_date.equals("")) 
				p_fm_replace_date="01/01/1700";
	
	con                      =  ConnectionManager.getConnection(request);
	stmt			         =  con.createStatement();

	if(whereClause == null || whereClause.equals("null")) whereClause = "";
	if(whereClause.equals(""))
	{
			sql	= "";
			p_patient_id	= request.getParameter("patient_id");

			if (p_patient_id==null || p_patient_id.equals("null")) 
				p_patient_id="";
			sql	= "  where patient_id = nvl(('"+p_patient_id+"'),patient_id) and nvl(initiating_function_id,0) <> 'MP_CHANGE_PAT_ID' and trunc(added_date) between  to_date('"+p_fm_replace_date+"','dd/mm/yyyy') and to_date('"+p_to_replace_date+"','dd/mm/rrrr') ";
			
			
	}
	else
	{
		sql = whereClause;
	}

	int x					= 0;
	int time_count			= 0;

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null || from.equals("null"))
	{
		start = 1 ;
	}
	else
	{
		start = Integer.parseInt( from ) ;
	}

	if ( to == null || to.equals("null"))
	{
	  	end = 10 ;
	}
	else
	{
		end = Integer.parseInt( to ) ;
	}
		
		

            _bw.write(_wl_block8Bytes, _wl_block8);



	if (p_patient_id.length() > 0)
	{
		str = "select count(*) total from dr_merged_patient_vw10 " + sql;

		rs = stmt.executeQuery(str);
        if(rs !=null)
		{
		    if (rs.next())
			p_pat_rec_cnt = rs.getInt("total");
		}  
		 if(rs !=null) rs.close();
		 if (p_pat_rec_cnt == 0)
		  {
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
	}
	else
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	}

	str   = "select merge_trn_id,patient_id,(CASE WHEN INSTR (Get_dup_Patient_line (patient_id,'"+localeName+"'), '#') > 0  THEN SUBSTR (Get_dup_Patient_line (patient_id,'"+localeName+"'), 1,   INSTR (Get_dup_Patient_line (patient_id,'"+localeName+"'), '#') - 1)  ELSE SUBSTR   (Get_Patient_line (patient_id,'"+localeName+"'), 1,   INSTR (Get_Patient_line (patient_id,'"+localeName+"'), '#') - 1 ) END) patient_line,pat_count,added_by_id,added_date from dr_merged_patient_vw10 " ;
	str  += sql;	
   
	rs	  =stmt.executeQuery(str);
			if (rs != null)
					{
						if ( start != 1 )
						  for( int j=1; j<start; i++,j++ )
						    {	
							  rs.next() ;						  
						    }
							while ( rs.next() && i<=end )
							{
							x= x + 1;
							time_count++;
							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							
							p_patient_line	= (rs.getString("patient_line") == null)?"":rs.getString("patient_line");

							p_dup_group_id  = rs.getInt("merge_trn_id");
							

						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(x));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block20Bytes, _wl_block20);

								i++;
						}
					}if(rs !=null) rs.close();
				
            _bw.write(_wl_block21Bytes, _wl_block21);


	    if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}
	catch(Exception e)
	{
	out.println("Exception in The File MergedPatientIDHeader"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
