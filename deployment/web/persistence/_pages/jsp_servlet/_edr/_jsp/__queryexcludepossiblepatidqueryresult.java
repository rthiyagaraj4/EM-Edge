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

public final class __queryexcludepossiblepatidqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/QueryExcludePossiblePatIdQueryResult.jsp", 1730788638870L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!--  <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t <script language=\'javascript\' src=\'../../eDR/js/QueryExcludePossibleDuplicates.js\'></script>\n\t <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey();\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onLoad=\'button_disable(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"1\",\"8\")\'>\n\t<form name=\'result_form\' id=\'result_form\' >\n\t<table border=0 width=\'90%\' cellspacing=0 align=\'center\'>\n\t<br>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<tr>\n\t\t   <td colspan=\'3\' class=\'WHITE\'></td>\n\t\t   <td class=\'WHITE\'></td>\n\t   </tr>\n\t   <tr>\n\t\t   <td colspan=\'3\' class=\'WHITE\'></td>\n\t\t   <td class=\'WHITE\'><input type=button class=button name=\'previous\' id=\'previous\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \' onClick=\"call_previous(\'1\',\'8\');\" disabled><input type=button  class=button name=\'next\' id=\'next\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  onClick=\"call_next(\'1\',\'8\');\" disabled></td>\n   \t  </tr>\n\t</table>\n\t<table border=1 width=\'90%\' cellpadding=0 cellspacing=0 align=\'center\' ID=\'tb1\'>\n\t<br>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=label width=\'\'></td>\n\t\t\t\t\t<td class=label width=\'\'></td>\n\t\t\t\t\t<td class=label width=\'\'></td>\n\t\t\t\t\t<td class=label width=\'\'></td>\n\t\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'max_record\' id=\'max_record\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'> \n\t\t\t<th colspan=6 align=left>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t<tr>\t\t\n\t\t\t\t<td width=\'1%\' class=\'label\'><b>&nbsp;</b></td>\n\t\t\t\t<td width=\'\' class=\'Label\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></td>\n\t\t\t\t<td width=\'1%\' class=\'label\'><b>&nbsp;</b></td>\n\t\t\t\t<td width=\'\' class=\'Label\'><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'> \n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'delete\'>\n\t<input type=\'hidden\' name=\'fin_patient_id\' id=\'fin_patient_id\' value=\'\'> \n\t</table>\n\t</form>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<!-- <script>\nparent.frames[1].document.getElementById(\"Execute\").disabled=false;\n</script> -->\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	Connection          con      = null;
	java.sql.Statement	stmt     = null;
	ResultSet	        rs		 = null;

	String classValue		     = "";
   // String str				     = "";
    String max_record_sql	     = "";
    String search_sql		     = "";
	String p_patient_id1	     = "";
    String p_patient_id2	     = "";
    String p_patient_name1       = "";
    String p_patient_name2	     = "";

	int max_record			     = 0;
	int start				     = 0;
	int end					     = 0;
	int i					     = 1;
	int count				     = 0;
	int row_chkbox			     = 0;

	demography d;

try
 {
	con                          = ConnectionManager.getConnection(request);
	stmt					     = con.createStatement();

	String from				     = request.getParameter("from");
	String to				     = request.getParameter("to");
	String criteria			     = request.getParameter("criteria");
	String patient_id		     = request.getParameter("patient_id");

	if(from == null || p_patient_id1.equals(null)) from = "";
    
	if(to == null || to.equals(null)) to = "";
	if(criteria == null || criteria.equals("null")) criteria = "";
	if(patient_id == null || patient_id.equals("null")) patient_id ="";

	d=new demography();

	
	if ( from == null || from.equals(""))
	    start = 1 ;
	else
	   start = Integer.parseInt(from) ;
	if ( to == null || to.equals(""))
	   end = 8 ;
	else
	   end = Integer.parseInt( to ) ;
 if(patient_id.equals(""))
	 {
	max_record_sql="select count(*) from dr_not_dup_patients where (patient_id1= nvl(null,patient_id1) or patient_id2 = nvl(null,patient_id2) )";
	 }
	else
		{
		  max_record_sql = "SELECT count(*) FROM dr_not_dup_patients WHERE (patient_id1 = NVL ('"+patient_id+"', patient_id1) OR patient_id2 = NVL ('"+patient_id+"', patient_id2) )";
		}
	rs=stmt.executeQuery(max_record_sql);
	if(rs!=null)
	{
			while(rs.next())
			{
			max_record=rs.getInt(1);
			}
	} if(rs!=null) rs.close();
    
	if (max_record==0) 
	 {
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("parent.pat_search.document.location.href ='../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp';");
		out.println("parent.dup_display.document.location.href ='../../eCommon/html/blank.html';</script>");
	 }
	    
	else
	{
		/*search_sql="select patient_id1,patient_id2 from dr_not_dup_patients where (patient_id1= nvl('"+patient_id+"',patient_id1) or patient_id2 = nvl('"+patient_id+"',patient_id2) )";*/

		search_sql="SELECT (CASE WHEN INSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), '#') > 0 THEN SUBSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), 1, INSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), '#') - 1)  ELSE SUBSTR (Get_Patient_line (patient_id1,'"+localeName+"'), 1, INSTR (Get_Patient_line (patient_id1,'"+localeName+"'), '#') - 1 ) END ) patient_id1, (CASE WHEN INSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), '#') > 0 THEN SUBSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), 1, INSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), '#') - 1 ) ELSE SUBSTR (Get_Patient_line (patient_id2,'"+localeName+"'), 1, INSTR (Get_Patient_line (patient_id2,'"+localeName+"'), '#') - 1 ) END) patient_id2 FROM dr_not_dup_patients WHERE (   patient_id1 = NVL ('"+patient_id+"', patient_id1) OR patient_id2 = NVL ('"+patient_id+"', patient_id2) )";
		
		rs=stmt.executeQuery(search_sql);
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(max_record));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_record));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			if(start != 1)
			{
				for(int j=1; j<start; i++,j++)
				{
					if(rs != null)
					{
						rs.next() ;
					}
				}
			}

			
				  count=0;
				  if(rs!=null)
					  {
					  while ( rs.next() && i<=end )
						{
							p_patient_id1	= rs.getString("patient_id1");
							p_patient_id2	= rs.getString("patient_id2");
							if(p_patient_id1 == null || p_patient_id1.equals("")) p_patient_id1 = "";
							if(p_patient_id2 == null || p_patient_id2.equals("")) p_patient_id2 = "";

							/*p_patient_name1	= d.name_age_sex(session ,p_patient_id1,con);
							p_patient_name2	= d.name_age_sex(session ,p_patient_id2,con);				  
							int flag        = p_patient_name1.lastIndexOf(',');
							p_patient_name1 = p_patient_name1.substring(0,flag);
							flag            = p_patient_name2.lastIndexOf(',');
							p_patient_name2 = p_patient_name2.substring(0,flag);*/

							int flag		= p_patient_id1.lastIndexOf(',');
							p_patient_name1 = p_patient_id1.substring(0,flag);
							int length1		= p_patient_id1.length();
							String patid1	= p_patient_id1.substring((flag+2),(length1-1));

							flag			= p_patient_id2.lastIndexOf(',');
							p_patient_name2 = p_patient_id2.substring(0,flag);
							int length2		= p_patient_id2.length();
							String patid2	= p_patient_id2.substring((flag+2),(length2-1));

						count++;
						if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
						else
						classValue = "QRYODD" ;
						out.println("<tr><td class='" + classValue + "'><a href=javascript:viewPatientDetails('"+patid1+"')>");
						out.println("&nbsp;+</a></td><td class='" + classValue + "'><font size=2 >");
						out.println(patid1+"&nbsp;"+p_patient_name1);
						out.println("</td>");
						out.println("<td class='" + classValue + "'><a href=javascript:viewPatientDetails('"+patid2+"')>");
						out.println("&nbsp;+</a></td><td class='" + classValue + "'><font size=2 >");
						out.println(patid2+"&nbsp;"+p_patient_name2);
						out.println("</td>");
						out.println("</tr>");
						out.println("<input type=hidden name='view_pat1_id"+i+"' id='view_pat1_id"+i+"' value='"+patid1+"'>");
						out.println("<input type=hidden name='view_pat2_id"+i+"' id='view_pat2_id"+i+"' value='"+patid2+"'>");
						i++;
						row_chkbox++;
						}
					 }if(rs!=null) rs.close();
		
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);

	 if (stmt!=null) stmt.close();
	 if (rs!=null) rs.close();
  }
	
   catch(Exception e)
   {
	   out.println("Exception in the File QueryExcludePossiblePatIdQueryResult"+e.toString());
	   e.printStackTrace();
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.ExcludedPossibleDuplicates.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.PatientID1.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.PatientID2.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
