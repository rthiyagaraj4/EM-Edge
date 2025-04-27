package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __cagetcomponentprompt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAGetComponentPrompt.jsp", 1709115531903L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"javascript\" src=\"../js/SectionTemplate.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\tvar msg=getMessage(\"INVALID_COMP_ID\",\"CA\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\ttop.content.master_pages.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t\t\t\t\t\t </script>\n\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t  parent.frames[3].document.forms[0].component.select();\t\n\t\t\t\t\t\t\t  parent.frames[3].document.forms[0].component.focus();\t\n\t\t\t\t\t\t      </script>\n\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\ttop.content.master_pages.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\t\t\t\tparent.frames[3].document.forms[0].component_prompt.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t    <script>\n\t\t\t\t\t\tparent.frames[3].document.forms[0].column_span.value=\'3\';\n\t\t\t\t\t\tparent.frames[3].document.forms[0].column_span.readOnly=true;\n\t\t\t\t\t\tparent.frames[3].document.forms[0].column_position.value=\'1\';\n\t\t\t\t\t\tparent.frames[3].document.forms[0].column_position.readOnly=true;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\tparent.frames[3].document.forms[0].hist_rec_type.disabled = true;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\tparent.frames[3].document.forms[0].hist_rec_type.disabled = false;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.CASectionTemplateDetailFrame.document.forms[0].formulaDefinitionBtn.style.display=\'inline\';\n\t\t\t\t\t\t\tcallOnFormulaDefinition();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.CASectionTemplateDetailFrame.document.getElementById(\"histDefYNTR\").style.display = \"inline\";\n\t\t\t\t\t\t\t\tparent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.style.display = \"inline\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t//parent.CASectionTemplateDetailFrame.document.getElementById(\"selectionCriteriaTR\").style.display = \"inline\";\n\t\t\t\t\t\t\t\tparent.CASectionTemplateDetailFrame.document.getElementById(\"presentationCriteriaTR\").style.display = \"inline\";\n\t\t\t\t\t\t\t\tparent.CASectionTemplateDetailFrame.document.getElementById(\"numericPrefixTR\").style.display = \"none\";\n\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\tparent.frames[3].document.forms[0].column_span.readOnly=false;\n\t\t\t\t\t\tparent.frames[3].document.forms[0].column_position.readOnly=false;\n\t\t\t\t\t\tparent.frames[3].document.forms[0].hist_rec_type.disabled = true;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].component_type.value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg01=\t\"APP-CA0156 Suspended code cannot be used\";\n\t\t\t\t\t\t\ttop.content.master_pages.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg01;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script>\n\t\t\ttop.content.master_pages.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
	Connection con = null;
	
	
    
	String count="";
	String sql		=" ",sql1="",comp_prompt="",comp_type="";
	String  comp_id=request.getParameter("comp_id");
	String  template_type=request.getParameter("template_type");
	if(template_type==null) template_type="";

	if (comp_id==null)comp_id="";
	if(!comp_id.equals("") && ((template_type.equals("")) || (template_type.equals("B"))))
	{
	 con = ConnectionManager.getConnection(request);
	
	
			try
			{									
						
						PreparedStatement pstmt = null;
						ResultSet	rs = null;
						sql=" select count(*) from am_discr_msr where DISCR_MSR_ID=? and EFF_STATUS='E'";
						pstmt	=	con.prepareStatement(sql);
						pstmt.setString(1,comp_id);
						rs = pstmt.executeQuery();
						if(rs!=null)
						{
							while(rs.next())
							{
								count=rs.getString(1);
							}
						}

						if (rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(Integer.parseInt(count)==0)
						{
						 
            _bw.write(_wl_block6Bytes, _wl_block6);

						}
						else
						{
						  sql1="select SHORT_DESC comp_prompt,RESULT_TYPE comp_type from AM_DISCR_MSR where DISCR_MSR_ID=? and EFF_STATUS='E'";
						pstmt=	con.prepareStatement(sql1);
						pstmt.setString(1,comp_id);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							comp_prompt=rs.getString(1);
							comp_type=rs.getString(2);
						
							
						
						
						
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(comp_prompt));
            _bw.write(_wl_block8Bytes, _wl_block8);

						  if(comp_type.equals("T") || comp_type.equals("P"))
							{
						
            _bw.write(_wl_block9Bytes, _wl_block9);

						if(comp_type.equals("P"))
						{
						
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
						  else if(comp_type.equals("F"))
							{
						
            _bw.write(_wl_block13Bytes, _wl_block13);

							}
							else if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("H"))
							{
						
            _bw.write(_wl_block14Bytes, _wl_block14);

							}
							else if(comp_type.equals("L"))
							{
						
            _bw.write(_wl_block15Bytes, _wl_block15);

							}
						  else
							{
						
            _bw.write(_wl_block16Bytes, _wl_block16);

							}
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp_type));
            _bw.write(_wl_block18Bytes, _wl_block18);

						}
						else//if the status id not E
						{
							
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
  				 }
			
				if (rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch ( Exception e ){
				//out.println("Exception in CAGetComponentPrompt.jsp"+e.toString());//COMMON-ICN-0181
                                  e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
            	
				
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			
		}
	else{
		
            _bw.write(_wl_block20Bytes, _wl_block20);

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
}
