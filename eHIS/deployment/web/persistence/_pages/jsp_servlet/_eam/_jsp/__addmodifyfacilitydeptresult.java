package jsp_servlet._eam._jsp;

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
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyfacilitydeptresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addmodifyFacilityDeptResult.jsp", 1714481916470L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script language=javascript>\n\tfunction submitPrevNext(from, to)\n\t{\n\t\tdocument.forms[0].totalvalues.value=parent.frames[0].temp;\n\n\t\tdocument.forms[0].from.value = from;\n\t    document.forms[0].to.value = to;\n\t    document.forms[0].submit();\n\t}\n </script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onLoad=\"FocusFirstElement()\" >\n\t<form name=\'Facility_dept_result\' id=\'Facility_dept_result\' action=\'../../eAM/jsp/addmodifyFacilityDeptResult.jsp\' method=\'post\' >\n   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\"white\">\n\t\t\t<table border=\'0\' align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t   <td id=\'prev\'> <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\'  text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t    <td  id=\'next\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnheader\' width=\'80%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'columnheader\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n\t<input type=hidden name=\'totalvalues\' id=\'totalvalues\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t<input type=\'hidden\' name=\'search_txt\' id=\'search_txt\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	int initCount = 1;
	Statement pstmt=null;
	Statement stmt = null;
	
	ResultSet rset=null ;
	ResultSet rstlRs2=null;

	String totalvalues= request.getParameter("totalvalues");
	if(totalvalues == null) totalvalues="";

	String facility=request.getParameter("facility");
	if(facility == null) facility="";
	try
	{
	con = ConnectionManager.getConnection(request);
	    String  chkboxAttribute="";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;

		String search_by=request.getParameter("search_by");
		String search_txt=request.getParameter("search_txt");
		if(search_by == null) search_by="";
		if(search_txt == null) search_txt="";

		String search_by1="";
		String search_by2="";


		if(search_by.equals("01"))
		{
		   search_by1="DEPT_CODE";
		   search_by2="DEPT_CODE";
		}
		else if(search_by.equals("02"))
		{
			search_by1="DEPT_LONG_DESC";
			search_by2="LONG_DESC";
		}

	
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }


String eff_status="";String dept_code="";String prefix_facl_id_for_int_yn="";
//String deptSql="Select dept_code,long_Desc, Eff_Status, upd_ind,upper (long_Desc), prefix_facl_id_for_int_yn  from (Select dept_code, dept_long_Desc long_desc, Eff_Status, 'Y' upd_ind, prefix_facl_id_for_int_yn   from AM_Facility_dept_Vw where eff_status='E' and  Operating_Facility_Id = '"+facility+"' Union  Select dept_Code, long_Desc,'D' Eff_Status,'N' upd_ind, prefix_facl_id_for_int_yn from  AM_dept a, sm_acc_entity_param b, sm_acc_entity_param_facl c where  a.acc_entity_id = b.acc_entity_id and b.acc_entity_id = c.acc_entity_id and c.facility_id = '"+facility+"' and eff_status='E' and dept_Code not in (Select dept_Code from Am_Facility_dept_VW where eff_status='E' and  Operating_Facility_Id = '"+facility+"') )  order by  upper (long_Desc)  ";

String deptSql ="Select dept_code,long_Desc, Eff_Status, upd_ind,upper (long_Desc), prefix_facl_id_for_int_yn  from (Select dept_code, dept_long_Desc long_desc, Eff_Status, 'Y' upd_ind, prefix_facl_id_for_int_yn   from AM_Facility_dept_Vw where eff_status='E' and  Operating_Facility_Id = '"+facility+"'";
if(!search_by.equals("") && !search_txt.equals(""))
          deptSql = deptSql +" and upper("+search_by1+")  like upper('"+search_txt+"%')"; 

 deptSql = deptSql + " Union  Select dept_Code, long_Desc,'D' Eff_Status,'N' upd_ind, prefix_facl_id_for_int_yn from  AM_dept a, sm_acc_entity_param b, sm_acc_entity_param_facl c where  a.acc_entity_id = b.acc_entity_id and b.acc_entity_id = c.acc_entity_id and c.facility_id = '"+facility+"' and eff_status='E'";
 if(!search_by.equals("") && !search_txt.equals(""))
          deptSql = deptSql +" and upper(a."+search_by2+")  like upper('"+search_txt+"%')";

 deptSql = deptSql +" and dept_Code not in (Select dept_Code from Am_Facility_dept_VW where eff_status='E' and  Operating_Facility_Id = '"+facility+"'";
 if(!search_by.equals("") && !search_txt.equals(""))
          deptSql = deptSql +" and upper("+search_by1+")  like upper('"+search_txt+"%')";

  deptSql = deptSql + ") )  order by  upper (long_Desc)  ";

	try
	{
		 pstmt= con.createStatement();
		 rset = pstmt.executeQuery(deptSql);
		 }
	catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}

		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ )
		 {
		  rset.next() ;
		 }
		  initCount+=start;
		  --initCount;
		}

		while( i<=end && rset.next()   )
		{
			if(maxRecord==0)
			{


            _bw.write(_wl_block9Bytes, _wl_block9);

	    if ( !(start <= 1)) {
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	    }
	//    if ( !((start+12) > maxRecord )){
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	 //   }
	
            _bw.write(_wl_block17Bytes, _wl_block17);



            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
		String classValue="";String flag="";
			dept_code = rset.getString("dept_code");
				if(dept_code == null) dept_code="";

			eff_status= rset.getString("eff_status");
				if(eff_status ==null) eff_status="";
				 prefix_facl_id_for_int_yn = rset.getString("prefix_facl_id_for_int_yn");
			if (prefix_facl_id_for_int_yn==null) prefix_facl_id_for_int_yn="N";

			if(eff_status.equals("E"))
				chkboxAttribute ="CHECKED";
			else
				chkboxAttribute="";

			if( i%2 == 0)  classValue="QRYEVEN";
			else
			classValue="QRYODD";
			flag=rset.getString(4).trim();
		
				
				out.println("<tr>");
				out.println("<td class='"+classValue+"'>"+rset.getString(2)+"</td>");
				out.println("<td class='"+classValue+"' align='center'><input type='hidden' name='flag"+i+"' id='flag"+i+"' value='"+dept_code+"$"+rset.getString(3).trim()+"$"+flag+"' ><input type='checkbox'  onClick='parent.frames[0].changeValue(flag"+i+",this,totalvalues)'  "+chkboxAttribute+" name='enabled"+i+"' id='enabled"+i+"' value='"+dept_code+"'></td>");
				out.println("</tr>");
				i++;
				maxRecord++;
		}//end of while

	if(maxRecord == 0)
{
            _bw.write(_wl_block21Bytes, _wl_block21);
}

if ( maxRecord < 12 || (!rset.next()) ) {

            _bw.write(_wl_block22Bytes, _wl_block22);
 
		} else {
            _bw.write(_wl_block23Bytes, _wl_block23);
}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(end));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(totalvalues));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block32Bytes, _wl_block32);


  	  		StringTokenizer steff=new StringTokenizer(totalvalues,"~");
	  		int temp1=steff.countTokens();
	  		for(int u3=0;u3<temp1;u3++)
	  		{
	  		String st4=steff.nextToken();
	  		StringTokenizer st5=new StringTokenizer(st4,"$");
			st5.nextToken();
	  		String status=st5.nextToken();
			st5.nextToken();
	   		String name=st5.nextToken();
	  		if(status.equals("E"))
	  		out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=true;</script>");
	  		else
	  		out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=false;</script>");
		}
  	  }
  catch(Exception e)
  {
	  //out.print(e);
	  e.printStackTrace();
	}
  finally
  {
	try
	{	if(rstlRs2!=null) rstlRs2.close();
		if(rset!=null) rset.close();
		if(stmt!=null) rstlRs2.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(con,request);
  }
  
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.acctdept.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
