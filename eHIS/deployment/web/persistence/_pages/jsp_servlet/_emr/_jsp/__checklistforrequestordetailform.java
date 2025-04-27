package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __checklistforrequestordetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ChecklistForRequestorDetailForm.jsp", 1732618741942L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eMR/js/ChecklistForRequestor.js\" language=\"JavaScript\"></Script>\n    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n\t\n\t<script>\n\n\n\t\t\n\n\tfunction submitPrevNext(from, to)\n\t{\n\t\t\t\n\t\t\teffected_records1(from,to);\n\t\t\t\n\t}\n\tvar flag=1;\t\n\t\t\n\t\n\t\n\n\n\t\n\t</script>\n\t</head>\n\t<body  onKeyDown = \'lockKey();\'  OnMouseDown=\"CodeArrest()\">\n\t<form name=\'checklist_requestor_form\' id=\'checklist_requestor_form\' action=\'../../eMR/jsp/ChecklistForRequestorDetailForm.jsp\' method=\'post\' >\n\t\t<p>\t\n\t\t<center><table  align=\'center\' id=\'titletb\' width=\"70%\" >\n\t\t\n\t\t<tr align =\'right\' >\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td  id=\'prev\' width=\"67%\" align =\'right\' ><a  href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<td  id=\'next\' style=\'visibility:hidden\' width=\"3%\" align =\'right\'  ><a  href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a></td>\n\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\n\t\t</tr>\n\t\t</table></center>\n\t\t<br>\n\t\t<br>\n\n\t<center><table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' id=\'titletb1\' width=\"70%\">\n\t<th width=\'55%\'  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </th>\n\n\t<th width=\'5%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ><input type=\'checkbox\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" id=\'respID";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' name=\'respID";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onClick=\'change_count(this)\' ><input type=\'hidden\'  name=\'db_respID";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'db_respID";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' ></td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</table></center>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\n\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'userID\' id=\'userID\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t\t\t<input type=\'hidden\' name=\'searchchklist\' id=\'searchchklist\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t\t<input type=\'hidden\' name=\'scode\' id=\'scode\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t\t\t<input type=\'hidden\' name=\'searchcriteria\' id=\'searchcriteria\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'insert_vals\' id=\'insert_vals\' value=\"\" >\n\t\t\t<input type=\'hidden\' name=\'delete_vals\' id=\'delete_vals\' value=\"\" >\n\t\t\t<input type=\'hidden\' name=\'chk_list_count\' id=\'chk_list_count\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"  > \n\t\t\t<input type=\'hidden\' name=\'chk_list_count_dummy\' id=\'chk_list_count_dummy\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  >\n\t\t\t\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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


	String redOnly = "";
	String diffinDate = "0";
	String disableFld = "";
	String upd_ind1 = "";
	 int cnt=0;
	Connection con=null;
	Statement stmt3=null;
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rset1=null;

	String classValue="";
	try{
		 request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String userID="";
		
		String searchchklist="";
		String searchcriteria="";
		String whereclause="";
	
		
		String count=request.getParameter("count");
		if(count==null) count="2";
		
		int chk_count = 0;
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		userID=request.getParameter("userID"); 
		
		String tableheader = "";
		searchchklist=request.getParameter("searchchklist")==null?"":request.getParameter("searchchklist");
		String scode = searchchklist.toUpperCase();
		
			searchcriteria=request.getParameter("searchcriteria");
			
			if(searchcriteria.equals("S"))
			whereclause = "upper(LONG_DESC) like upper('"+scode+"%') ";
			if(searchcriteria.equals("E"))
			whereclause = "upper(LONG_DESC) like upper('%"+scode+"') ";
			if(searchcriteria.equals("C"))
			whereclause = "upper(LONG_DESC) like upper('%"+scode+"%') ";
			tableheader = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckListName.label","mr_labels");
		
		int chk_list_count=0,chk_list_count_dum=0;
		 chk_list_count =  eMR.MRCommonBean.getChecklistCount(con,userID);	
		 chk_list_count_dum = chk_list_count;
		
		String chk_list_count11=request.getParameter("chk_list_count")==null?"0":request.getParameter("chk_list_count");
		int chk_list_count12 = Integer.parseInt(chk_list_count11);
		
		if (chk_list_count12 != 0) chk_list_count = chk_list_count12;
			
		
		
	
		int start = 0 ;
		int end = 0 ;
		int i=1;
			if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
			if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
			String chkAttribute="";
			
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
			
	
		   
            _bw.write(_wl_block6Bytes, _wl_block6);

			i = 1 ;
		stmt=con.createStatement();
		if(rset1!=null) rset1.close();
		if(stmt!=null) stmt.close();
	
            _bw.write(_wl_block7Bytes, _wl_block7);

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

			if ( !(start <= 1)) {
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
	//		if ( !((start+10) > maxRecord )){
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		//	}
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableheader));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		String resp_id="";
		
		 
		
		
		String sqlUser ="select * from ((select A.CHK_LIST_CODE code,a.LONG_DESC description,'Y' check_indicator from chk_list_medical_report a, mr_chklist_for_requestor b where B.CHK_LIST_CODE = A.chk_list_code and b.REQUESTOR_ID ='"+userID+"' and "+whereclause+"  ) UNION (select A.CHK_LIST_CODE code,a.LONG_DESC description,'N' check_indicator from chk_list_medical_report a where a.CHK_LIST_CODE not in (select A.CHK_LIST_CODE from chk_list_medical_report a, mr_chklist_for_requestor b where B.CHK_LIST_CODE = A.chk_list_code and b.REQUESTOR_ID = '"+userID+"'  ) and "+whereclause+" )) order by 1 ";
		
		
		stmt = con.createStatement();
		rset=stmt.executeQuery(sqlUser);
		if(rset!=null)
		{
			if ( start != 0 )
			{
			 for( int j=1; j<start; i++,j++ ){
			  rset.next() ;
			  }
			}

			
			 while(i<=end && rset.next())
			 {
				resp_id = rset.getString("code");
				
			


			String upd_ind = rset.getString("check_indicator");
			if(upd_ind.equals("Y"))
			 {
				chkAttribute = "CHECKED";
				upd_ind1="true";
				
			 }
			 else
			 {
				chkAttribute = "";
				upd_ind1="false";
			 }
			
					
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rset.getString("description")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(upd_ind1));
            _bw.write(_wl_block28Bytes, _wl_block28);

				i++;
				cnt++;
			}
			

            _bw.write(_wl_block29Bytes, _wl_block29);
	
			if (cnt==0)
			{
				out.println("<script>document.getElementById(\"titletb\").style.visibility='hidden';document.getElementById(\"titletb1\").style.visibility='hidden';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				
			}
			boolean flag = false;
			if ( cnt < 10 || (!rset.next()) ) {
			
            _bw.write(_wl_block30Bytes, _wl_block30);
 flag = true;
					} else {
            _bw.write(_wl_block31Bytes, _wl_block31);
}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	 

			 
			

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(start));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(end));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(start));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(end));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(userID));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(searchchklist));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(scode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(searchcriteria));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chk_list_count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chk_list_count_dum));
            _bw.write(_wl_block43Bytes, _wl_block43);
	}catch(Exception e){
			// System.out.println(e);
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) stmt.close();
			if(stmt3!=null) stmt3.close();
			ConnectionManager.returnConnection(con,request);
		}	
	
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
