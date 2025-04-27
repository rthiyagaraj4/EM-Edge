package jsp_servlet._eam._jsp;

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

public final class __discretemeasurepaneladdmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscreteMeasurePanelAddModify.jsp", 1709113987086L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/DiscreteMeasurePanel.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\t\tfunction populateSections()\n\t\t{\n\t\t\t\tvar indexSelected = document.forms[0].discr_msr_battery_id.selectedIndex ;\n\t\t\t\tvar discr_msr_battery_value = document.forms[0].discr_msr_battery_id.value ;\n\t\t\t\tvar service_code  = serviceCodeList[indexSelected];\n\t\t\t\tvar result_type = resultType[indexSelected];\n\n\t\t\t\tif(indexSelected == 0){\n\t\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[1].location.href=\"DiscreteMeasurePanelQueryCriteriaResult.jsp?discr_msr_battery_id=\"+discr_msr_battery_value;\n\t\t\t\t}\n\t\n\t\t\t\tvar htmlVal = \"<html><head></head><body onKeyDown = \'lockKey()\'>\"\n\t\t\t\thtmlVal += \"<form name=\'frm_temp\' id=\'frm_temp\' method=\'post\' action=\'../../eAM/jsp/DiscreteMeasurePanelPopulate.jsp\' target=\'messageFrame\'>\"\n\t\t\t\thtmlVal += \"<input type=hidden name=service_code value=\" +service_code + \">\"\n\t\t\t\thtmlVal += \"<input type=hidden name=\'result_type\' id=\'result_type\' value=\" +result_type + \">\"\n\t\t\t\thtmlVal += \"</form></body></html>\"\n\t\t\t\t\n\t\t\t\tparent.messageFrame.document.write(htmlVal);\n\t\t\t\tparent.messageFrame.document.frm_temp.submit();\n\t\t\t\t\n\n\t\t\t//\tparent.dummy.document.write(htmlVal);\n\t\t\t//\tparent.dummy.document.frm_temp.submit();\n\t\t\t}\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t var serviceCodeList = new Array();\n\t\t\t\t\t\tvar resultType = new Array();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\tserviceCodeList[\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'] = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\t\t\tresultType[\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t </script>\n\t\t\t\t\t <!--<input type=hidden name=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n</script>\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onload=\'\'>\n<form name=\"DiscreteMeasurePanel_form\" id=\"DiscreteMeasurePanel_form\" action=\"../../servlet/eAM.DiscreteMeasurePanelServlet\" method=\"post\" target=\"messageFrame\">\n\n\n<table border=0 cellspacing=0 cellpadding=0 width=\'90%\' align=center>\n<BR>\n<tr>\n\t<td width=\'40%\'>&nbsp;</td>\n\t<td width=\'60%\'>&nbsp;</td>\n</tr>\n\n<tr>\n\t\t<td class=label align=right>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<td align=left>&nbsp;<select name=\'discr_msr_battery_id\' id=\'discr_msr_battery_id\' onchange=\'populateSections()\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t<option value=\"\">&nbsp;---- ---- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="--- ---&nbsp;</option>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\t   \n\t\t</select>\n\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n\n<tr>\n\t<td width=\'40%\'>&nbsp;</td>\n\t<td width=\'60%\'>&nbsp;</td>\n</tr>\n\n\n<tr>\n\t<td class=label align=right>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</td>\n\t<td align=left>&nbsp;<input type=\"text\" name=\"order_srl_no\" id=\"order_srl_no\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"   size=3 maxlength=3  onkeyPress=\'return allowValidNumber(this,event,6,0)\'  onBlur=\"makeValidString(this); CheckPositiveNumberLocal(this)\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<input type=hidden name=\'old_order_srl_no\' id=\'old_order_srl_no\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</tr>\n\n<tr>\n\t<td width=\'40%\'>&nbsp;</td>\n\t<td width=\'60%\'>&nbsp;</td>\n</tr>\n\n<tr>\n\t\t<td class=label align=right>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<td align=left>&nbsp;<select name=\'discr_msr_id\' id=\'discr_msr_id\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t<option value=\"\">&nbsp;--- --- ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="---- ----&nbsp;</option>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</select>\n\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n\n<tr>\n\t<td width=\'40%\'>&nbsp;</td>\n\t<td width=\'60%\'>&nbsp;</td>\n</tr>\n\n<tr>\n\t<td class=label align=right>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;&nbsp;</td><td align=left class=label>\n\t<input type=\"checkbox\" name=\"mandatory_yn\" id=\"mandatory_yn\" value=\"Y\"  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="></td>\n</tr>\n\n\n<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n</tr>\n\n</table>\n<input type=hidden name=\"mode\" id=\"mode\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=hidden name=\"discr_msr_battery_id_update\" id=\"discr_msr_battery_id_update\"  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=hidden name=\"discr_msr_id_update\" id=\"discr_msr_id_update\"  value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n </form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String sql="";
String mode="";
String status="";
StringBuffer sb=  new  StringBuffer();        

String discr_msr_battery_id="";
String discr_msr_id="";
String discr_msr_battery_desc="";
String discr_msr_desc="";
String order_srl_no="";
String service_code="";
String result_type = "";
String mandatory_yn="";
String itemDescription = "" ;
String itemCOde		= "" ;
String enabled_checked="";
String discreteMeasureOption ="" ;

mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
String   discr_msr_battery_id1 =(request.getParameter("discr_msr_battery_id1")==null)?"":request.getParameter("discr_msr_battery_id1");
String   discr_msr_id1 =(request.getParameter("discr_msr_id1")==null)?"":request.getParameter("discr_msr_id1");

try
  {	
	  con			=ConnectionManager.getConnection(request);
	  stmt	    	=con.createStatement();
	if(mode.trim().equalsIgnoreCase("insert"))
	  {						
		sql="Select discr_msr_id, short_desc, service_code,result_type from am_discr_msr Where eff_status = 'E' and result_type in ('V','Z','G') Order by short_desc";

				rs= stmt.executeQuery(sql);

				int   count = 0;
            _bw.write(_wl_block7Bytes, _wl_block7);
while(rs.next())
				  {
					 count++;
					 service_code	 =(rs.getString("service_code")==null)?"":rs.getString("service_code");
					 result_type	 =(rs.getString("result_type")==null)?"":rs.getString("result_type");
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(count));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(count));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(count));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

					 itemCOde  =(rs.getString("discr_msr_id")==null)?"":rs.getString("discr_msr_id");
					 itemDescription=(rs.getString("short_desc")==null)?"":rs.getString("short_desc");
					 sb.append("<option value='"+itemCOde+"'>"+itemDescription+"</option>");
					 
				  }
				  if(rs!=null) 	rs.close();
                  if(stmt!=null) 	stmt.close();
	   	  }			  
    	
		if(mode.trim().equalsIgnoreCase("update")) 
		 {
				sql = "select * from am_discr_msr_battery_vw where DISCR_MSR_BATTERY_ID='" +
					   discr_msr_battery_id1 + "' and discr_msr_id='"  + discr_msr_id1+ "'" ;
				
				rs			= stmt.executeQuery(sql);

			if(rs.next())
			 {
				discr_msr_battery_id = (rs.getString("DISCR_MSR_BATTERY_ID")==null)?"":rs.getString("DISCR_MSR_BATTERY_ID");
				discr_msr_battery_desc =
				(rs.getString("DISCR_MSR_BATTERY_DESC")==null)?"":rs.getString("DISCR_MSR_BATTERY_DESC");
				
				sb.append("<option value='"+discr_msr_battery_id+"'  selected     disabled>"+discr_msr_battery_desc+"</option>");	
				
				discr_msr_id	= 
				(rs.getString("DISCR_MSR_ID")==null)?"":rs.getString("DISCR_MSR_ID");
				discr_msr_desc=(rs.getString("DISCR_MSR_DESC")==null)?"":rs.getString("DISCR_MSR_DESC");
				
				discreteMeasureOption	 =  "<option value='"+discr_msr_id+"' selected   disabled>"+discr_msr_desc+" </option>";

				order_srl_no=(rs.getString("ORDER_SRL_NO")==null)?"":rs.getString("ORDER_SRL_NO");
				mandatory_yn=(rs.getString("MANDATORY_YN")==null)?"":rs.getString("MANDATORY_YN");
				if(mandatory_yn.trim().equalsIgnoreCase("Y"))
				enabled_checked = "checked"  ;
				else
				enabled_checked = "";

			 }
		 }
  }		
 catch(Exception e)
	{
			out.println(e);
	}
finally
	{
		try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	} 

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sb.toString()));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
if( order_srl_no != null){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_srl_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(status));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(discreteMeasureOption));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(enabled_checked));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(discr_msr_battery_id1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PanelID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderSrlNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiscreteMeasure.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mandatory.label", java.lang.String .class,"key"));
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
