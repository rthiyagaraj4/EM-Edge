package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.HashMap;
import com.ehis.eslp.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __criteriaforassessmentcategorydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/CriteriaForAssessmentCategoryDetail.jsp", 1726058855703L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<!--<script language=\"JavaScript\" src=\"../../eCP/js/common.js\"></script>-->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../js/CriteriaForAssessmentCategory.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n<script>\n  function selectAll(Obj,start,end){\n\t var assess_note_id = document.forms[0].assess_note_id.value;\n\t var assess_catg_code = document.forms[0].assess_catg_code.value;\n\tif(Obj.checked){\n\n\t\tfor(var i=start;i<=end;i++){\n\t\t\tif(eval(\"document.forms[0].select\"+i))\n\t\t\teval(\"document.forms[0].select\"+i).checked=true;\n\t\t\t}\n\t\t\n\t\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'CriteriaForAssessmentCategoryDynamicValues.jsp?\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'notCleared\'></form></BODY></HTML>\";\n\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.frames[2].document.form1.submit();\n\t}\n\telse{\n\t\tfor(var i=start;i<=end;i++){\n\t\t\tif(eval(\"document.forms[0].select\"+i))\n\t\t\teval(\"document.forms[0].select\"+i).checked=false;\n\t\t\t}\n\t\n\t\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'CriteriaForAssessmentCategoryDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'clearAll\'></form></BODY></HTML>\";\n\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.frames[2].document.form1.submit();\n\t}\n}\n\n function chkForSelectAll(start,end){\n\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\'){\n\t\tdocument.forms[0].selectall.checked=true;\n\t\tselectAll(document.forms[0].selectall,start,end)\n\t}\n}\n\nfunction submitPrevNext(from, to){\n\tdocument.forms[0].from.value = from;\n\tdocument.forms[0].to.value = to; \n\tdocument.forms[0].submit();\n}\nfunction assaignValue( obj){\n\tif(obj.checked == true)\n\t\tobj.value =\'Y\';\n\telse \n\t\tobj.value=\'N\';\n}\n</script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' class=\'CONTENT\' >\n<form name=\'detail_form\' id=\'detail_form\' action=\'../../eCP/jsp/CriteriaForAssessmentCategoryDetail.jsp\' method=\'post\' >\n\n<table  width=\'95%\' border=0 align=\'center\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n\n<input type=hidden name=\'recordArray\' id=\'recordArray\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\n<input type=hidden name=\'assess_note_id\' id=\'assess_note_id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=hidden name=\'assess_catg_code\' id=\'assess_catg_code\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</td>\n</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t\n\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" <br><input type=\'checkbox\' name=\'selectall\' id=\'selectall\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\'></th>\n\n\t\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<input type=hidden name=\'sec_hdg_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'sec_hdg_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=hidden name=\'child_sec_hdg_code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'child_sec_hdg_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t<input type=hidden name=\'comp_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'comp_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t<input type=hidden name=\'srl_no";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'srl_no";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t<input type=hidden name=\'comp_type";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'comp_type";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t<input type=hidden name=\'action";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'action";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" name=\'select";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'  value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onclick=\"assaignValue(this)\"> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</table>\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            webbeans.eCommon.RecordSet CriteriaForAssessmentCategory= null;synchronized(session){
                CriteriaForAssessmentCategory=(webbeans.eCommon.RecordSet)pageContext.getAttribute("CriteriaForAssessmentCategory",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(CriteriaForAssessmentCategory==null){
                    CriteriaForAssessmentCategory=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("CriteriaForAssessmentCategory",CriteriaForAssessmentCategory,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block9Bytes, _wl_block9);

		ArrayList recordArray=new ArrayList();	
		ArrayList resultArray=new ArrayList();

		String chk_sec_hdg_code="";
		String chk_child_sec_hdg_code="";
		String chk_comp_id="";
		String chk_srl_no="";
		String chk_comp_type="";
		String select_yn="Y";
		String chk_select="";
		String chk_action="";
		String chk_comp="";

  	    String from = request.getParameter("from");
        String to = request.getParameter("to");

        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

		if (from == null)
			start = 0 ;
		else
			start = Integer.parseInt(from);
		if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
		String req_start=(request.getParameter("start")==null)?"1":request.getParameter("start");
		String req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");

		String assess_note_id=request.getParameter("assess_note_id")==null?"":request.getParameter("assess_note_id");
		String assess_catg_code=request.getParameter("assess_catg_code")==null?"":request.getParameter("assess_catg_code");
  		String sec_hdg_desc="";
		String child_sec_hdg_desc="";
		String long_desc="";

		Connection con = null;
		PreparedStatement pstmt_initial = null;
		ResultSet rs_initial = null;

		PreparedStatement pstmt=null;
		ResultSet rs=null ;

		try{
			
		con = ConnectionManager.getConnection(request);			
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null){
			
		CriteriaForAssessmentCategory.clearAll();
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/

		String sql_initial="select  a.sec_hdg_code, a.sec_hdg_desc, a.child_sec_hdg_code, a.child_sec_hdg_desc, b.comp_id, b.srl_no, d.long_desc, d.result_type comp_type,'I' db_action from  ca_note_section_view a, ca_section_template b, am_discr_msr d where a.note_type = ? and (b.sec_hdg_code = a.sec_hdg_code or b.sec_hdg_code = a.child_sec_hdg_code) and d.discr_msr_id = b.comp_id and (b.comp_id,b.srl_no) not in (select comp_id,comp_srl_no from cp_assess_crit where assess_note_id = ? and assess_catg_code=?) and d.result_type in ('L','C','N','I') union all select a.sec_hdg_code, d.sec_hdg_desc, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,a.child_sec_hdg_code) child_sec_hdg_code, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,g.sec_hdg_desc) child_sec_hdg_desc, a.comp_id, a.comp_srl_no srl_no, f.long_desc, f.result_type comp_type, 'U' db_action from cp_assess_crit a, ca_section_hdg d, cp_assess_catg e, am_discr_msr f, ca_section_hdg g where a.assess_note_id =? and a.assess_catg_code=? and d.sec_hdg_code = a.sec_hdg_code and g.sec_hdg_code = a.child_sec_hdg_code and e.assess_catg_code = a.assess_catg_code and f.discr_msr_id = a.comp_id order by 2,4,7"; 

			pstmt_initial=con.prepareStatement(sql_initial);
			pstmt_initial.setString(1,assess_note_id);
			pstmt_initial.setString(2,assess_note_id);
			pstmt_initial.setString(3,assess_catg_code);
			pstmt_initial.setString(4,assess_note_id);
			pstmt_initial.setString(5,assess_catg_code);
			rs_initial = pstmt_initial.executeQuery();
				

			if(rs_initial !=null)
			{
				while(rs_initial.next())
				{
				recordArray=new ArrayList();
				recordArray.add(rs_initial.getString("sec_hdg_code"));
				recordArray.add(rs_initial.getString("child_sec_hdg_code")==null?"":rs_initial.getString("child_sec_hdg_code"));
				recordArray.add(rs_initial.getString("comp_id"));
				recordArray.add(rs_initial.getString("srl_no"));
				recordArray.add(rs_initial.getString("comp_type"));
				recordArray.add(rs_initial.getString("db_action"));

				if(rs_initial.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs_initial.getString("db_action").equals("I"))
					   select_yn="N";
						
		 		recordArray.add(select_yn);		 		
				CriteriaForAssessmentCategory.putObject(recordArray);
    			 }
			  }	
	        }

			if(from != null && to != null){
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<(Integer.parseInt(req_end)); i++){
				 
				 chk_sec_hdg_code = request.getParameter("sec_hdg_code"+(i))==null?"":request.getParameter("sec_hdg_code"+(i));
				 chk_child_sec_hdg_code=request.getParameter("child_sec_hdg_code"+(i))==null?"":request.getParameter("child_sec_hdg_code"+(i));
				 chk_comp_id=request.getParameter("comp_id"+(i))==null?"":request.getParameter("comp_id"+(i));
				 chk_srl_no=request.getParameter("srl_no"+(i))==null?"":request.getParameter("srl_no"+(i));
				 chk_comp_type=request.getParameter("comp_type"+(i))==null?"":request.getParameter("comp_type"+(i));
	
				 chk_action = request.getParameter("action"+(i))==null?"":request.getParameter("action"+(i));
				 chk_select = request.getParameter("select"+(i))==null?"":request.getParameter("select"+(i));
				 if((request.getParameter("select"+(i)))!=null)
					 chk_select="Y";
				 else
					 chk_select="N";
					    resultArray=new ArrayList();
						resultArray.add(chk_sec_hdg_code);
						resultArray.add(chk_child_sec_hdg_code);
						resultArray.add(chk_comp_id);
						resultArray.add(chk_srl_no);
						resultArray.add(chk_comp_type);
						resultArray.add(chk_action);
						resultArray.add(chk_select);
						CriteriaForAssessmentCategory.setObject(i,resultArray);   					    					
				  }
				  
	             out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
    String classValue="";
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/
	String sql="select  a.sec_hdg_code, a.sec_hdg_desc, a.child_sec_hdg_code, a.child_sec_hdg_desc, b.comp_id, b.srl_no, d.long_desc, d.result_type comp_type,'I' db_action from  ca_note_section_view a, ca_section_template b,am_discr_msr d where a.note_type = ? and (b.sec_hdg_code = a.sec_hdg_code or b.sec_hdg_code = a.child_sec_hdg_code) and d.discr_msr_id = b.comp_id and (b.comp_id,b.srl_no) not in (select comp_id,comp_srl_no from cp_assess_crit where assess_note_id = ? and assess_catg_code=?) and d.result_type in ('L','C','N','I') union all select a.sec_hdg_code, d.sec_hdg_desc, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,a.child_sec_hdg_code) child_sec_hdg_code, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,g.sec_hdg_desc) child_sec_hdg_desc, a.comp_id, a.comp_srl_no srl_no, f.long_desc, f.result_type comp_type, 'U' db_action from cp_assess_crit a, ca_section_hdg d, cp_assess_catg e, am_discr_msr f, ca_section_hdg g where a.assess_note_id =? and a.assess_catg_code=? and d.sec_hdg_code = a.sec_hdg_code and g.sec_hdg_code = a.child_sec_hdg_code and e.assess_catg_code = a.assess_catg_code and f.discr_msr_id = a.comp_id order by 2,4,7";

   try{
    pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  	pstmt.setString(1,assess_note_id);
	pstmt.setString(2,assess_note_id);
	pstmt.setString(3,assess_catg_code);
	pstmt.setString(4,assess_note_id);
	pstmt.setString(5,assess_catg_code);
	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		 // out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		 }


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(recordArray));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(assess_note_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(assess_catg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(start));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(end));
            _bw.write(_wl_block19Bytes, _wl_block19);

    if ( !(start <= 1)) {

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

    }
    if ( !((start+10) >= maxRecord )){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

    }

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block27Bytes, _wl_block27);
	 

		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}

			String temp="";
			while((rs.next()) && (i<=end)){ 

			 recordArray=new ArrayList();
			 chk_comp="";
   				
			recordArray.add(rs.getString("sec_hdg_code"));
			recordArray.add(rs.getString("child_sec_hdg_code"));
			recordArray.add(rs.getString("comp_id"));
			recordArray.add(rs.getString("srl_no"));
			recordArray.add(rs.getString("comp_type"));
			recordArray.add(rs.getString("db_action"));

			if(rs.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs.getString("db_action").equals("I"))
					   select_yn="N";
						
		 	recordArray.add(select_yn);
            
			sec_hdg_desc=rs.getString("sec_hdg_desc");
			child_sec_hdg_desc=rs.getString("child_sec_hdg_desc");
			long_desc=rs.getString("long_desc");
			 for(int k=0;k<CriteriaForAssessmentCategory.getSize();k++)
			 {
				resultArray=(ArrayList)CriteriaForAssessmentCategory.getObject(k);
						 								
				if(((String)recordArray.get(2)).equals((String)resultArray.get(2)))
					 {
					  	 if(resultArray.get(6).equals("Y"))
							 chk_comp="checked";
						 else
							 chk_comp="";
					break;
					 }
				 else
				 {
					 chk_comp="";
				 }
			 } 
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";

				if(sec_hdg_desc.equals(temp))
					temp="&nbsp;";
				else
					temp=sec_hdg_desc;

				if(child_sec_hdg_desc==null)
				child_sec_hdg_desc="&nbsp;";

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordArray.get(0)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordArray.get(1)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordArray.get(2)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordArray.get(3)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordArray.get(4)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordArray.get(5)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(chk_comp));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(recordArray.get(6)));
            _bw.write(_wl_block48Bytes, _wl_block48);

					temp=sec_hdg_desc;
			i++;
			}		
		 }
			  catch(Exception e)
			  {
				  out.print(e);
			  }
			  finally
			  {
				  if(rs != null){ rs.close(); }
				  if(rs_initial != null){ rs_initial.close(); }
				  if(pstmt != null){ pstmt.close(); }
				  if(pstmt_initial != null){ pstmt_initial.close(); }
					    
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("CriteriaForAssessmentCategory", CriteriaForAssessmentCategory);
			  }

            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Section.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.SubSection.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.criteria.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
