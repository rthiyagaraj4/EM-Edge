package jsp_servlet._eca._jsp;

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
import webbeans.eCommon.RecordSet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __multirecsubsectiondtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MultiRecSubSectionDtl.jsp", 1709115945840L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!-- <modifeid by Arvind @06-12-2008> -->\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../js/MultiRecSubSection.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  class=\'CONTENT \'OnMouseDown=\'CodeArrest();\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<form name=\'MultiRecSubSectionDtlForm\' id=\'MultiRecSubSectionDtlForm\' method=\"post\">\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\t\n\t\t<tr>\n\t\t\t<td class=\'white\' width=\'95%\'></td> \n\t\t\t<td  align=\'right\' width=\'5%\' nowrap><a class=\'gridLink\' style=\'visibility:hidden\' id=\'prevRecs\' href=\"javascript:prevNextRecs(\'prev\')\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>&nbsp;&nbsp;<a class=\'gridLink\' id=\'nextRecs\' href=\"javascript:prevNextRecs(\'next\')\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a></td>\n\t\t</tr>\n\t</table>\n\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' id=\'dataTitleTable\' width=\'100%\' align=\'center\' >\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'75%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\'width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t</tr>\n\t</table>\n\t<table class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\'  width=\'100%\' align=\'center\' >\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<script>\n\t\tparent.parent.rowIDArraySubSecMain[";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="] = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t</script>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<tr  id=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t <td  width=\'0\'   style  =\"display:none\"  >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td><!-- TD TO DISPLAY SUB SECTION CODE -->\n\t\t\t\t<td class=\'gridData\'   width=\'75%\' align=\'left\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>    <!-- TD TO DISPLAY SUBSECTION DESCRIPTION -->\n\t\t\t\t<td class=\'gridData\'   width=\'25%\' align=\'center\'>\n\t\t\t\t\t<input type=\'checkbox\' name=\'select_yn";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'select_yn";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'   value=\'Y\' onClick=\"stringConCatenate(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =")\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n\t\t\t   </td> <!-- CHECKBOX TO DISPLAY WHICH ALL ENTRIES HAVE NON -ZERO SEQUENCE NUMBER -->\n\t\t</tr>\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<input type =\"hidden\" name =\"sequence\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><!-- HAS THE LENGTH OF NUMBER OF TD CREATED  -->\n\t\t<input type =\"hidden\" name =\"from\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type =\"hidden\" name =\"to\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type =\"hidden\" name =\"sectionCode\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type =\"hidden\" name =\"searchText\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type =\"hidden\" name =\"rwIdIndex\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type =\"hidden\" name =\"count\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type =\"hidden\" name =\"hiddenFieldRemoveRow\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</table>\t\n\t</form>\n\t<script>\n\t\t//alert(parent.parent.rowIDArraySubSecMain);\n\t\tif(";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" == 0)\n\t\t\tdocument.getElementById(\"prevRecs\").style.visibility = \'hidden\';\n\t\telse\n\t\t\tdocument.getElementById(\"prevRecs\").style.visibility = \'visible\';\n\t\t\n\t\tif(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" < 7)\n\t\t\tdocument.getElementById(\"nextRecs\").style.visibility = \'hidden\';\n\t\telse\n\t\t\tdocument.getElementById(\"nextRecs\").style.visibility = \'visible\';\n\t</script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

/* 		Section Contains all the Variables Used in the  Program */
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;

	String startString = request.getParameter("start") == null ? "0" : request.getParameter("start");
	String endString = request.getParameter("end") == null ? "7" : request.getParameter("end");
	String hiddenFieldRemoveRow = request.getParameter("hiddenFieldRemoveRow") == null ? "" : request.getParameter("hiddenFieldRemoveRow");
	int count = 0;
	int tempCount=0;
	int index = 0;
	int rwIdIndex = 0;
	int dupRwIdIndex = 0;
	int start = Integer.parseInt(startString);
	int end = Integer.parseInt(endString);
	StringBuffer result_query = new StringBuffer();
	String tempRowIds = request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");

	if(tempRowIds.indexOf("^") != -1)
	{
		for(int y=0;y<tempRowIds.length();y++)
			tempRowIds = tempRowIds.replace('^','+');
	}

	if(!tempRowIds.equals(""))
		tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);

	String sec_hdg_code="", sec_hdg_desc ="", valid ="",seq_num	="", section_code="";
	String  classValue="", tblrow_id="", select_yn_prop="";
	String  sec_hdr_meta_desc="";
	String search_text ="";
	String error_msg = "";
	String row_id = "";
	String loadFirst = "No";
	try
	{
			con = ConnectionManager.getConnection(request);
			loadFirst = request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			section_code = request.getParameter("section_code");

			search_text = 	 request.getParameter("searchtext");
			if(section_code == null || section_code.equals("null"))section_code="";
			if((search_text==null ) || search_text.equals(""))
			{
				search_text = "";
			}
			 result_query.append("select rowID row_id,sec_hdg_code,'N' valid, to_number(null ) child_seq_num, sec_hdg_desc, sec_hdr_meta_desc  from  ca_section_hdg where ");
			 if(!loadFirst.equals("Yes"))
			 {
				 result_query.append("rowId in("+tempRowIds);
				 result_query.append(" ) and ");
			 }
			 result_query.append("CONTENT_TYPE != 'S' and NVL(SELECTION_TYPE,'S') != 'M' and sec_hdg_code not in (select CHILD_SEC_HDG_CODE from ca_subsection_link where header_sec_hdg_code = ?) and upper(sec_hdg_desc) like upper(?) 	union  select  b.rowId row_id,a.CHILD_SEC_HDG_CODE   sec_hdg_code,'Y' valid , a.CHILD_SEQ_NUM  , b.sec_hdg_desc, sec_hdr_meta_desc from ca_subsection_link a, ca_section_hdg b where  ");
			 if(!loadFirst.equals("Yes"))
			 {
				 result_query.append("b.rowId in("+tempRowIds);
				 result_query.append(" ) and ");				 
			 }
			 result_query.append("b.sec_hdg_code = a.child_sec_hdg_code and  a.HEADER_SEC_HDG_CODE =?  and upper(sec_hdg_desc) like upper(?) order by sec_hdg_desc");
			pstmt = con.prepareStatement(result_query.toString());// Query to Fetch Values for already Entered Sequence Numbers AND OTHERS NULL ENTRIES FROM THE DATABASE


			pstmt.setString(1,section_code);
			pstmt.setString(2,search_text+"%");
			pstmt.setString(3,section_code);
			pstmt.setString(4,search_text+"%");
			rs=pstmt.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

			
			while(rs.next())
			{
				count++;
			}

			if(count == 0)
			{
					/*
						IF NO RECORDS ARE FOUND .MESSAGE IS ALERTED FROM MESSAGE.JS
					*/
					error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
					out.println("<script>parent.DetailsFrameMiddle.document.forms[0].searchtext.value=''</script>");
					out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
			}
			else
			{
				rs=pstmt.executeQuery();
			}

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

			if(rs != null)
			{
				while(rs.next())
				{
					
					index++;
					classValue = ((index%2)==0 )? "QRYEVEN" : "QRYODD";
					row_id			=	rs.getString("row_id");
					sec_hdg_code			=	rs.getString("sec_hdg_code");
					sec_hdg_desc			=	rs.getString("sec_hdg_desc");
					valid					=	rs.getString("valid");
					seq_num					=	rs.getString("child_seq_num");
					sec_hdr_meta_desc		=   rs.getString("sec_hdr_meta_desc");
					if(sec_hdg_code == null || sec_hdg_code.equals("null"))sec_hdg_code="";
					if(sec_hdg_desc == null || sec_hdg_desc.equals("null"))sec_hdg_desc="";
					if(valid == null || valid.equals("null"))valid="";
					if(seq_num == null || seq_num.equals("null"))seq_num="";
					if(sec_hdr_meta_desc == null || sec_hdr_meta_desc.equals("null"))sec_hdr_meta_desc="";
					if(!sec_hdr_meta_desc.equals(""))
						sec_hdg_desc = sec_hdg_desc +"&nbsp;-&nbsp;"+ sec_hdr_meta_desc;
					if(valid.equalsIgnoreCase("Y") && !(hiddenFieldRemoveRow.equals(sec_hdg_code)))
					{
						select_yn_prop="checked";
					}
					else
					{
						select_yn_prop="";
					}
					tblrow_id ="tblrow_id"+index;
					if(loadFirst.equals("Yes"))
					{
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rwIdIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(row_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
			if(rwIdIndex < 7)
			{
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(((sec_hdg_code.equals(""))?"&nbsp;":sec_hdg_code)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(((sec_hdg_desc.equals(""))?"":sec_hdg_desc)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(select_yn_prop));
            _bw.write(_wl_block25Bytes, _wl_block25);
		dupRwIdIndex++;
			}
			rwIdIndex++;
			}
			if(loadFirst.equals("Yes"))
			{
				tempCount = rwIdIndex;
			}
			else
			{
				tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
			}
		}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(start));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(end));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(section_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dupRwIdIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tempCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(hiddenFieldRemoveRow));
            _bw.write(_wl_block34Bytes, _wl_block34);
	
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	//	out.println("EXCEPTION IN MAIN BLOCK :"+e.toString());
		e.printStackTrace();
}
finally
{
		
		if(con !=null) ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rwIdIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SubSectionDescription.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
