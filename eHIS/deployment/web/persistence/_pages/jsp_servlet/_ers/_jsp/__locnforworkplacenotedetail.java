package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import java.util.*;
import com.ehis.util.*;

public final class __locnforworkplacenotedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/LocnForWorkplaceNoteDetail.jsp", 1709121635606L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<!-- <script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script> -->\n<script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<!-- <script src=\"../js/RSMessages.js\" language=\"JavaScript\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n<script>\n       \n\tfunction submitPrevNext(from, to){\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t    document.forms[0].submit();\n\t}\n\n\tfunction selectAll(Obj,start,end){\n\t\t\n\t\tif(Obj.checked){\n\t\t\tfor(var i=start;i<=end;i++){\n\t\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\t\teval(\"document.forms[0].chk\"+i).checked=true;\n\t\t\t}\n\t\t\t/*var facility_id = document.forms[0].facility_id.value;\n\t\t\tvar workplace_code = document.forms[0].workplace_code.value;\n\t\t\tvar location_type= document.forms[0].locn_code.value;\n\n\t\t\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'LocnForWorkplaceDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'notCleared\'><input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'\"+facility_id+\"\'><input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'\"+workplace_code+\"\'><input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'\"+location_type+\"\'> </form></BODY></HTML>\";\n\t\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.frames[2].document.form1.submit();  */\n\t\t}\n\t\telse{\n\t\t\t\n\t\t\tfor(var i=start;i<=end;i++){\n\t\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\t\teval(\"document.forms[0].chk\"+i).checked=false;\n\t\t\t}\n\t\t\t/*var HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'LocnForWorkplaceDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'clearAll\'></form></BODY></HTML>\";\n\t\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.frames[2].document.form1.submit();\t */\n\t\t}\n\t}\n\n\tfunction chkForSelectAll(start,end){\n\t\t\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\'){\n\t\t\tdocument.forms[0].chkAll.checked=true;\n\t\t\tselectAll(document.forms[0].chkAll,start,end)\n\t\t}\n\t}\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);\n\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' class=\'CONTENT\' >\n\t\t\t<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eRS/jsp/LocnForWorkplaceNoteDetail.jsp\' method=\'post\' >\n\n\t\t\t<table  width=\'90%\' border=0 align=\'center\'>\n\t\t\t<tr>\n\t\t\t<td align=\'right\' class=\'NONURGENT\'>\n\t\t\t<input type=hidden name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t<input type=hidden name=\'locn_code\' id=\'locn_code\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\n\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t\t<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\n\n\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a>\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<th width=\'60%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =")\'></th>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" name=\'chk";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'> </td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</table>\n</form>\n</body>\n<script>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\tdocument.facility_form_result.chkAll.checked=true;\n\t\t\tdocument.facility_form_result.chkAll.value=\"Y\";\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\tdocument.facility_form_result.chkAll.checked=false;\n\t\t\tdocument.facility_form_result.chkAll.value=\"N\";\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.RecordSet LocationWorkplace= null;synchronized(session){
                LocationWorkplace=(webbeans.eCommon.RecordSet)pageContext.getAttribute("LocationWorkplace",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(LocationWorkplace==null){
                    LocationWorkplace=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("LocationWorkplace",LocationWorkplace,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;

        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if(from == null)
			start = 0 ;
		else 
			start = Integer.parseInt( from );

        if(to == null)
			end = 12;
		else
			end = Integer.parseInt( to );
       
		req_start = (request.getParameter("start")==null)?"0": request.getParameter("start");
		req_end =(request.getParameter("end")==null)?"0":request.getParameter("end");

		PreparedStatement pstmt3 = null;
		ResultSet rstlRs3 = null;

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null ;
		boolean chkAll=true;
		try
		{
			con = ConnectionManager.getConnection(request);
			String workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
			String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
			String location_type=request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
			String flagSelect = request.getParameter("fromSearch")==null?"":request.getParameter("fromSearch");

	        if(!flagSelect.equals("") ){
				LocationWorkplace.clearAll();
				 String sqlinsVals= "select locn_code from rs_locn_for_workplace where workplace_code=? and facility_id=? and locn_type=?";
				 pstmt3=con.prepareStatement(sqlinsVals);
				 pstmt3.setString(1,workplace_code);
				 pstmt3.setString(2,facility_id);
				 pstmt3.setString(3,location_type);
				 rstlRs3 = pstmt3.executeQuery();
				// out.println("workplace_code------|" +workplace_code+ "|--------location_type--------|" +location_type);
				if(rstlRs3 !=null){
					
					while(rstlRs3.next()){
						
						LocationWorkplace.putObject(rstlRs3.getString(1));
					 }
				}
	        }

             if(from != null && to != null){
				 int j=0;
				 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
					 if(request.getParameter("chk"+(i)) != null){
						 checkedOnes = request.getParameter("chk"+(i));
						 if(!(LocationWorkplace.containsObject(checkedOnes)))
							 LocationWorkplace.putObject(checkedOnes);
						 j++;
					 }
				}
                out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
            }
			i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			
			//String sql="select locn_code,locn_desc, 'I' db_action  from rs_locn_vw  where facility_id = ? and locn_type =? and (facility_id,locn_code,locn_type) not in(select facility_id,locn_code,locn_type from rs_locn_for_workplace where facility_id =? and workplace_code = ? ) union all select a.locn_code, b.locn_desc, 'U' db_action   from rs_locn_for_workplace a, rs_locn_vw b  where a.facility_id = ?  and a.workplace_code = ?  and a.locn_type = ?   and b.facility_id = a.facility_id   and b.locn_type = a.locn_type  and b.locn_code = a.locn_code  order by 2";
			String sql="SELECT locn_code,locn_desc, 'I' db_action  FROM rs_locn_vw  WHERE facility_id = ? AND locn_type =? AND (facility_id,locn_code,locn_type) NOT IN(SELECT facility_id,locn_code,locn_type FROM rs_locn_for_workplace WHERE facility_id =? AND workplace_code = ? ) AND LANGUAGE_ID = ? UNION ALL SELECT a.locn_code, b.locn_desc, 'U' db_action   FROM rs_locn_for_workplace a, rs_locn_vw b  WHERE a.facility_id = ?  AND a.workplace_code = ?  AND a.locn_type = ?   AND b.facility_id = a.facility_id   AND b.locn_type = a.locn_type  AND b.locn_code = a.locn_code AND B.LANGUAGE_ID = ? ORDER BY 2";
			
			try{
				pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,location_type);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,workplace_code);
				pstmt.setString(5,locale);
				pstmt.setString(6,facility_id);
				pstmt.setString(7,workplace_code);
				pstmt.setString(8,location_type);
				
				pstmt.setString(9,locale);

				rs=pstmt.executeQuery();
				//out.println("workplace_code------|" +workplace_code+ "|--------location_type--------|" +location_type);
				//out.println("workplace_code------|" +workplace_code+ "|--------location_type--------|" +location_type);
				
				rs.last();
				maxRecord = rs.getRow();
				rs.beforeFirst();
				//out.println("maxRecord---->" +maxRecord);
				if(maxRecord == 0)                   //modified for getting no records msg dt:8/7/08 
		{
			
            _bw.write(_wl_block9Bytes, _wl_block9);

		}


				
				
			}
			catch(Exception e){
				e.printStackTrace() ;
				throw e ;
			}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(start));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(end));
            _bw.write(_wl_block19Bytes, _wl_block19);

			if ( !(start<=1)) {

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
			if ( !((start+12) >= maxRecord )){

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

			}

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block28Bytes, _wl_block28);
	 
		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
		while(rs.next() && i<=end){ 
			String locn_code=rs.getString("locn_code");
						
			String locn_desc=rs.getString("locn_desc");
			//out.println("locn_code-----235|" +locn_code+ "|------------locn_desc------236|" +locn_desc);
			if(LocationWorkplace.containsObject(locn_code)){
				chkAttribute = "CHECKED";
			}
			else{
				chkAttribute="";
				chkAll=false;
			}
			int recordIndex = LocationWorkplace.indexOfObject(locn_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    
				LocationWorkplace.removeObject(recordIndex);

			if( i%2 == 0)  
				classValue="QRYEVEN";
			else
				classValue="QRYODD";

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block35Bytes, _wl_block35);

			i++;
		}		
	 }
	 catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if(rs != null)
			rs.close();
		if(rstlRs3 != null)
			rstlRs3.close();
		if(pstmt != null)
			pstmt.close();
		if(pstmt3 != null)
			pstmt3.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("LocationWorkplace", LocationWorkplace);
	}

            _bw.write(_wl_block36Bytes, _wl_block36);

		if(chkAll){

            _bw.write(_wl_block37Bytes, _wl_block37);

		}else{

            _bw.write(_wl_block38Bytes, _wl_block38);

		}

            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
