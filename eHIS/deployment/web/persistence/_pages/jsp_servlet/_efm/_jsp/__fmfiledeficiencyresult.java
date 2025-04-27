package jsp_servlet._efm._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __fmfiledeficiencyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileDeficiencyResult.jsp", 1709116841919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n<html>\n<HEAD>\n<TITLE></TITLE>\n<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eFM/js/FMFileDeficiencyReport.js\" language=\"javascript\"></script>\n<script src=\"../../eFM/js/checkSystemDate.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\n</HEAD>\n\n<BODY onMouseDown=\"CodeArrest();\"  onKeyDown = \'lockKey();\'>\n<br>\n<br>\n<form name=\"Type\" id=\"Type\" action=\"../../eFM/jsp/FMFileDeficiencyResult.jsp\"  method=\'post\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table >\n\t\t<tr>\n\t\t\n\t<table border=\'0\' width=\'60%\' align=\'center\'>\n\t\t<tr>\n\t\t   \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\n\t\t<td align=\'right\' width=\'92%\' id=\'prev\'><a href=\'javascript:call_previous(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" )\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></td>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\n\t\t<td  id=\'next\' align=\'right\' style=\'visibility:hidden\'><a href=\'javascript:call_next(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</tr>\n\t\t</table>\n\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\n\t\t\n\t\t\n\t<table border=\'1\' width=\'60%\' cellspacing=\'0\' align=\'center\'>\n    \t\t\n\t\t<tr>\n\t\t<th  nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t<th  nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\n\t\t<th  width=\'20%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" <input type=\'checkbox\' name=\'sel_all\' id=\'sel_all\' onClick=\'sel_all_chk()\'></th>\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<tr><td class=\'CAGROUPHEADING\' colspan=12>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\n\t\t\t<!--<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' nowrap>+</td> -->\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' nowrap><input type=\'checkbox\'  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" name=\'select_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onClick=\'select_chk(this)\'></td>\n\t\t\t\t<input type=hidden name=\'deficiency_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'deficiency_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t<input type=hidden name=\'chkAttribute";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'chkAttribute";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t</tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</table>\n\t\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\n\t\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\"hidden\" name=\"no_of_rec\" id=\"no_of_rec\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"final_vals\" id=\"final_vals\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sel_rec\" id=\"sel_rec\" value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"p_search_by\" id=\"p_search_by\" value=\"\">\t\n\t\t<input type=\"hidden\" name=\"sel_from\" id=\"sel_from\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sel_end\" id=\"sel_end\" value=\"\">\t\t\t\t\n\t\t\t\t\t\t\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultVal)
	{
		return (inputString==null)	?	defaultVal	:	inputString;
	}


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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	//String p_module_id		= "FM" ;
	//String p_report_id		= "FMBDFTYP" ;
	//String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	//String p_user_name		= (String) session.getValue( "login_user" ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet cancelReserveBedDetail= null;synchronized(session){
                cancelReserveBedDetail=(webbeans.eCommon.RecordSet)pageContext.getAttribute("cancelReserveBedDetail",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(cancelReserveBedDetail==null){
                    cancelReserveBedDetail=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("cancelReserveBedDetail",cancelReserveBedDetail,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection con			= null ;
	Statement stmt			= null ;
	ResultSet rs				= null ;
		String	req_start			= ""; 
		String  req_end			= "";
		String  checkedOnes		= "";
		String	from					= request.getParameter("from") ;
		String	to						= request.getParameter("to") ;
	   String selectvalue="";
	   String deficiency_code="";	
	String   long_desc="";	
	  String p_from_code=request.getParameter("from_code")==null?"":request.getParameter("from_code");
		String p_search_by=request.getParameter("serch_type")==null?"":request.getParameter("serch_type");
		//out.println("p_from_code---->"+p_from_code);
	//	out.println("p_search_by---->"+p_search_by);
		int		start					= 0;
		int		end					= 0;
		int		i						= 1;
		int		initCount				= 1;
		int		records_to_show	=9;
    
        if (from == null)
			{ start = 1 ; }  
		else
			{  start = Integer.parseInt( from ) ; }
     
		if (to == null)
			{ end =9 ; }
		else 
			{  end = Integer.parseInt( to ) ; }

        req_start       =   checkForNull(request.getParameter("start"),"0");
        req_end         =   checkForNull(request.getParameter("end"),"0");
		
		String classValue	= "" ;
		String next			= "";
		String prev			= "";

		try
		{
			con		= ConnectionManager.getConnection(request);
			String flagSelect = checkForNull(request.getParameter("fromSelect"));
			        
			if(!flagSelect.equals(""))
				cancelReserveBedDetail.clearAll();
		
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<= (Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("select_"+(i)) != null)
					{
						checkedOnes = request.getParameter("select_"+(i));
						
						if(!(cancelReserveBedDetail.containsObject(checkedOnes)))
							cancelReserveBedDetail.putObject(checkedOnes);

						j++;
					}
				}
		          
        }
        		i = 1 ;

				StringBuffer sql_count = new StringBuffer();

		stmt = con.createStatement();
	  	sql_count.append("select DEFICIENCY_CODE, LONG_DESC from fm_deficiency_lang_vw where EFF_STATUS='E' and language_id='"+localeName+"'");
		if(!p_from_code.equals("")){ 
			 if(p_search_by.equals("DC"))
				 {
					  sql_count.append(" and UPPER(DEFICIENCY_CODE) like UPPER('"+p_from_code+"%')");
		   	     }
			else if(p_search_by.equals("DD"))
						{
						 sql_count.append(" and  LOWER(LONG_DESC) like LOWER('"+p_from_code+"%')");
						}
			else 
					{
					  sql_count.append(" and (UPPER(DEFICIENCY_CODE) like UPPER('"+p_from_code+"%') OR LOWER(LONG_DESC) like LOWER('"+p_from_code+"%')) ");	
					}
		}
		
		

		rs = stmt.executeQuery(sql_count.toString());

		//out.println(sql_count.toString());
		if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			}
			initCount+=start;
			--initCount;
		}

		int z=0;
		int maxRecord = 0;

		while((z < records_to_show) && rs.next())
		{
		
		if(maxRecord==0){
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		if ( !(start <= 1))
		{
		
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start-9)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end-9)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+9)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+9)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		//}
		
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}

			String chkAttribute="";
					
					z++;
					if ( i % 2 == 0 )
						classValue = "QRYEVENSMALL" ;
					else
						classValue = "QRYODDSMALL" ;

					 long_desc=rs.getString("LONG_DESC");
					if(long_desc == null) long_desc="&nbsp;";
					
					deficiency_code = rs.getString("DEFICIENCY_CODE");
					if(deficiency_code== null) deficiency_code="&nbsp;";
								  
             selectvalue	= deficiency_code;
			if(cancelReserveBedDetail.containsObject(selectvalue)) 
				chkAttribute = "CHECKED";
			else
				chkAttribute="";

			int recordIndex = cancelReserveBedDetail.indexOfObject(selectvalue);

			if(recordIndex!=-1)
				if(chkAttribute.equals("CHECKED"))   
					cancelReserveBedDetail.removeObject(recordIndex); 
				
			
			 if(!next.equals(prev)) 
			{
				 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(next));
            _bw.write(_wl_block22Bytes, _wl_block22);
 }
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(deficiency_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(selectvalue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(deficiency_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block35Bytes, _wl_block35);

				prev = next;
				i++;
				maxRecord++;
			}//endwhile
		  //}

			
			if(maxRecord<8 || (!rs.next()))
			{
            _bw.write(_wl_block36Bytes, _wl_block36);
}
			else
			{
            _bw.write(_wl_block37Bytes, _wl_block37);
}

			if(maxRecord==0)
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			if(maxRecord!=0){
            _bw.write(_wl_block38Bytes, _wl_block38);
}

		}catch(Exception e){

			out.println(e);
		}	
		finally 
		{
			    try
				{
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 	rs.close();
				}
				catch(Exception e)
				{
				}
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("cancelReserveBedDetail", cancelReserveBedDetail);
				
		}
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(start));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(end));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(start));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(end));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DeficiencyCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DeficiencyType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
