package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __relationshiplevelresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RelationshipLevelResults.jsp", 1709118718792L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\t\t\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\t\t\n\t\t<script language=\'javascript\' src=\'../../eMP/js/RelationshipLevel.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\t\t\t\t\n\t\t\t\tfunction clearBean()\n\t\t\t\t{\n\t\t\t\t\teval(\"document.relnshiplvl_result_form\"+";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =");\t\t\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"RECORD_EXISTS\",\"SM\"));\t\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<form name=\'relnshiplvl_result_form\' id=\'relnshiplvl_result_form\' method=\'post\' action=\'../../servlet/eMP.RelationshipLevelServlet\' target=\"messageFrame\">\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr>\n\n<th width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n<th width=\'40%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<th width=\'40%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<th width=\'5%\'>&nbsp;</th>\n</tr>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n<input type = \'hidden\' name = \'rec_cnt\' value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type = \'hidden\' name = \'checked_flag\' value = \'\'>\n<input type = \'hidden\' name = \'linked_relationship_code\' value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type = \'hidden\' name = \'linked_relationship_desc\' value = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type = \'hidden\' name = \'relationship_code\' value = \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type = \'hidden\' name = \'relationship_level\' value = \'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\n</table>\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n</html>\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            webbeans.eCommon.RecordSet associateDiagBean= null;synchronized(session){
                associateDiagBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("associateDiagBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(associateDiagBean==null){
                    associateDiagBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("associateDiagBean",associateDiagBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{   
    con	= ConnectionManager.getConnection();
	String relationship_code = "";
	String relationship_level_code = "";
	String relationship_level_desc = "";
	String linked_relnship_level_code = "";
	String relationship_level = "";
	String linked_relnship_level_desc = "";
	String reln_lvl_code = "";
	String reln_lvl_desc = "";
	String linked_reln_lvl_code = "";
	String linked_reln_lvl_desc = "";
	String mode = "";
	String classValue = "";	
	String linked_relationship_desc="";    
    String srno=""; 
    String linked_relationship_code="";     
    String insert_flag="";         
    
	linked_relationship_desc=(request.getParameter("linked_relationship_desc")==null)? "":request.getParameter("linked_relationship_desc");
	
	linked_relationship_code=(request.getParameter("linked_relationship_code")==null)? "":request.getParameter("linked_relationship_code");

  	relationship_code=(request.getParameter("relationship_code")==null)?"":request.getParameter("relationship_code");
	relationship_level_code=(request.getParameter("relationship_level_code")==null)?"":request.getParameter("relationship_level_code");
	relationship_level_desc=(request.getParameter("relationship_level_desc")==null)?"":request.getParameter("relationship_level_desc");
	relationship_level=(request.getParameter("relationship_level")==null)?"":request.getParameter("relationship_level");
	linked_relnship_level_code=(request.getParameter("linked_relnship_level_code")==null)?"": request.getParameter("linked_relnship_level_code");

	linked_relnship_level_desc=(request.getParameter("linked_relnship_level_desc")==null)?"": request.getParameter("linked_relnship_level_desc");	

	mode=(request.getParameter("mode")==null)?"": request.getParameter("mode");
	
	srno=(request.getParameter("srno")==null)?"": request.getParameter("srno");		

	if(mode.equals("update"))
	{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(associateDiagBean.clearAll()));
            _bw.write(_wl_block10Bytes, _wl_block10);

	} 	

	if(!(relationship_level_code.equals("") && relationship_level_desc.equals("") && linked_relnship_level_code.equals("") ) )	
	{
		if(mode.equals("add"))
		{
			if(associateDiagBean.containsObject(relationship_level_code)==false)
			{
				associateDiagBean.putObject("I");
				associateDiagBean.putObject(relationship_level_code);
				associateDiagBean.putObject(relationship_level_desc);	

				if(relationship_level.equals("2"))
				{
					associateDiagBean.putObject(linked_relnship_level_code);
					associateDiagBean.putObject(linked_relnship_level_desc);					
				}
				
			}
			else
			{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			} 
		}
		else if(mode.equals("modify"))
		{
				int g = Integer.parseInt(srno);

				associateDiagBean.setObject(g,"M");				
				associateDiagBean.setObject(g+1,relationship_level_code);
				associateDiagBean.setObject(g+2,relationship_level_desc);

				if(relationship_level.equals("2"))
				{
					associateDiagBean.setObject(g+3,linked_relnship_level_code);					
					associateDiagBean.setObject(g+4,linked_relnship_level_desc);			
				}				
		}		
	}	

	if(mode.equals("update"))
	{
		String sqlupdate = "";
		
		if(relationship_level.equals("1"))
		{
			sqlupdate = "select relationship_level_code, relationship_level_desc from MP_RELATIONSHIP_LEVEL where relationship_code='"+relationship_code+"'";
		}
		else if(relationship_level.equals("2"))
		{
			sqlupdate = "select relationship_level_code, relationship_level_desc, relationship_level_code2, relationship_level2_desc from MP_RELATIONSHIP_LEVEL_VW where relationship_code='"+relationship_code+"' and ASSOCIATED_RELATIONSHIP_CODE = '"+linked_relationship_code+"'";
		}

		pstmt=con.prepareStatement(sqlupdate);		
		rs=pstmt.executeQuery();

		while( rs!=null && rs.next())
		{
				reln_lvl_code=(rs.getString("relationship_level_code")==null)?"":rs.getString("relationship_level_code");
				reln_lvl_desc=(rs.getString("relationship_level_desc")==null)?"":rs.getString("relationship_level_desc");

				associateDiagBean.putObject("U");
				associateDiagBean.putObject(reln_lvl_code);
				associateDiagBean.putObject(reln_lvl_desc);

				if(relationship_level.equals("2"))
				{
					linked_reln_lvl_code=(rs.getString("relationship_level_code2")==null)?"":rs.getString("relationship_level_code2");
					linked_reln_lvl_desc=(rs.getString("relationship_level2_desc")==null)?"":rs.getString("relationship_level2_desc");

					associateDiagBean.putObject(linked_reln_lvl_code);					
					associateDiagBean.putObject(linked_reln_lvl_desc);

				}				
		}

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	int rec_cnt=associateDiagBean.getSize();	

	if(rec_cnt>0)
	{
	

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(relationship_level.equals("2"))
{
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            ArrayList a= new ArrayList();
			a= associateDiagBean.getRecordSetHandle();
						           
			//int j=0;
			//int k=1;
			int z=0;			
			
			for(int i=0;i<rec_cnt;i++)
			{
				if ( i % 2 == 0 )
					 classValue = "QRYEVEN" ;
				else
					 classValue = "QRYODD" ;
				
				z=i;

				insert_flag=a.get(i).toString();
				reln_lvl_code=a.get(++i).toString();
				reln_lvl_desc=a.get(++i).toString();
				if(relationship_level.equals("2"))
				{
					linked_reln_lvl_code=a.get(++i).toString();
					linked_reln_lvl_desc=a.get(++i).toString();								
				}				

				out.println("<tr><td class='" + classValue + "' align='center' width ='10%' nowrap><A HREF='../../eMP/jsp/RelationshipLevelAddModify.jsp?relationship_level_code="+reln_lvl_code+"&relationship_level_desc="+reln_lvl_desc+"&linked_relnship_level_desc="+linked_reln_lvl_desc+"&relationship_code="+relationship_code+"&linked_relnship_level_code="+linked_reln_lvl_code+"&linked_relationship_desc="+linked_relationship_desc+"&linked_relationship_code="+linked_relationship_code+"&srno="+z+"&mode=modify' target=relnshp_lvl_add_mod>"+reln_lvl_code+"</a></td>");
				out.println("<td class='" + classValue + "' align='center' width ='40%' nowrap>"+reln_lvl_desc+"</td>");
				if(relationship_level.equals("2"))
				{
					out.println("<td class='" + classValue + "' align='center' width ='40%' nowrap>"+linked_reln_lvl_desc+"</td>");
				}	

				if(insert_flag.equals("M")||insert_flag.equals("I"))
				{
					out.println("<td class='" + classValue + "' align='center' width ='5%' nowrap><input type='checkbox' value='Y' name='insert_chk"+z+"' id='insert_chk"+z+"' checked onclick='chkValue(this,"+z+");'></td></tr>");
				}
				else
				{
					out.println("<td class='" + classValue + "' align='center' width ='5%' nowrap>&nbsp;</td></tr>");
				}
				
				//z++;
				
			}	

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rec_cnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(linked_relationship_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(linked_relationship_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(relationship_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(relationship_level));
            _bw.write(_wl_block22Bytes, _wl_block22);

	}

}
catch(Exception e)
{
	 
	 e.printStackTrace();
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LinkedRelnshpLevel.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
