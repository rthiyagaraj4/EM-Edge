package jsp_servlet._emo._jsp;

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

public final class __mopopulatearea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOPopulateArea.jsp", 1742812691351L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\n<script>\n\t\nvar opt= parent.frames[3].document.createElement(\'Option\');\n\n\nopt.text=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"; \nopt.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\nobj.add(opt) ;\nif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\")\n{\n\t\nif((\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"==\"P\")||(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"==\"R\")||(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"==\"E\")||(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"==\"R\")||(parent.frames[3].document.getElementById(\'mode\').value==\'viewdata\'))\n\t\t{\n\tparent.frames[3].document.MO_regn_form.area_type.options[\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'].selected=true;\n\tparent.frames[3].document.MO_regn_form.area_type.disabled=false;\n//\tif(parent.frames[1].frames[3].document.MO_regn_form.mode.value!=\"viewdata\")\n\tparent.frames[3].document.MO_regn_form.bed_no.disabled=true;\n\tparent.frames[3].document.MO_regn_form.bed_button.disabled=true;\t\n\t\n\t\t}else{\n\tparent.frames[3].document.MO_regn_form.area_type.options[\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'].selected=true;\n\tparent.frames[3].document.MO_regn_form.area_type.disabled=false;\n//\tif(parent.frames[1].frames[3].document.MO_regn_form.mode.value!=\"viewdata\")\n\tparent.frames[3].document.MO_regn_form.bed_no.disabled=false;\n\tparent.frames[3].document.MO_regn_form.bed_button.disabled=false;\t\n\t\t\n\t\t\n\t\t\n\t\t}\n\n\n}\n</script>\t\t\t\t\t\t\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<script>\nvar opt= parent.frames[1].frames[2].document.createElement(\'Option\');\n\nopt.text=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\nobj.add(opt) ;\n\n\nif(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\")\n{\nif(parent.frames[1].frames[3].document.MO_regn_form!=null)\n\t{\n\t\n\tparent.frames[1].frames[3].document.MO_regn_form.area_type.options[\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'].selected=true;\n\t//parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=true;\n//\tif(parent.frames[1].frames[3].document.MO_regn_form.mode.value!=\"viewdata\")\n\t\n\t\n\tif((\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"==\"R\")||(parent.frames[1].frames[3].document.getElementById(\'mode\').value==\'viewdata\') )\n\t\t{\n\t\t\tif(parent.frames[1].frames[3].document.MO_regn_form.area_type)\n\t\t\t{\n\t\t\t\tif(parent.frames[1].frames[3].document.MO_regn_form.postmortem_reqd_yn.value!=\'Y\')\n\t\t\t\t{parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=true;}\n\t\t\t\telse{parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=false;}\n\t\t\t\t\n\n\t\t\t\tif( parent.frames[1].frames[3].document.MO_regn_form.area_type.value!=\"\" && parent.frames[1].frames[3].document.MO_regn_form.bed_no.value==\"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[3].document.MO_regn_form.bed_no.disabled=false;\n\t\t\t\t\tparent.frames[1].frames[3].document.MO_regn_form.bed_button.disabled=false;\n\t\t\t\t}\t\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[3].document.MO_regn_form.bed_no.disabled=true;\n\t\t\t\t\tparent.frames[1].frames[3].document.MO_regn_form.bed_button.disabled=true;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\n\tparent.frames[1].frames[3].document.MO_regn_form.bed_no.disabled=false;\n\tparent.frames[1].frames[3].document.MO_regn_form.bed_button.disabled=false;\n\tparent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=false;\n\t\t}\n\t}\nelse\n\t{\nparent.frames[1].frames[0].frames[3].document.forms[0].area_type.options[\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'].selected=true\n\t}\n\n}\nparent.frames[1].frames[2].document.createElement(\'Option\');\n</script>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);


Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;

String locale=(String)session.getAttribute("LOCALE"); 
String	 facilityId 	= (String) session.getValue( "facility_id" ) ;
String sql         = "";
String postmortem_reqd_yn = "N";
String area_code         ="";
String area_type="";
String CLAIMANT_TYPE="";
request.setCharacterEncoding("UTF-8");
String popareaforbprt=request.getParameter("popareaforbprt")==null?"":request.getParameter("popareaforbprt");
String area_code1           = request.getParameter("area_code")==null?"":request.getParameter("area_code");

String area_desc           = null;
String startendstat=request.getParameter("startendstat")==null?"":request.getParameter("startendstat");
postmortem_reqd_yn=request.getParameter("postmortem_reqd_yn")==null||request.getParameter("postmortem_reqd_yn").equals("")?"N":request.getParameter("postmortem_reqd_yn");
CLAIMANT_TYPE = request.getParameter("CLAIMANT_TYPE")==null?"":request.getParameter("CLAIMANT_TYPE");

try
{
	if(area_code1.equals(""))
	{
	
	if (postmortem_reqd_yn.equalsIgnoreCase("Y")){
    sql="select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and eff_status='E' and Area_Type not in ('R') order by long_desc";

   }
   else if (postmortem_reqd_yn.equalsIgnoreCase("N"))
   {
 	sql	=	"select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and  facility_id = '"+facilityId+"' and eff_status='E' and Area_Type not in ('P') order by long_desc";
    }
	
	}
	else
	{
	 if ((postmortem_reqd_yn.equalsIgnoreCase("Y"))&& (CLAIMANT_TYPE .equalsIgnoreCase("F")))
	{
	 sql	=	"select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E' order by long_desc";
	}
	
	else if (postmortem_reqd_yn.equalsIgnoreCase("Y"))
    {
     sql	=	"select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E' and Area_Type not in ('R') order by long_desc";
    }
	else{
	sql	="select area_type,area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E' and Area_Type not in ('P') order by long_desc";
	
	}
	
	
	}
	
  if ((startendstat.equalsIgnoreCase("E")))
  {
   sql	=	"select area_type ,area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E'  order by long_desc";
  }
	
	
  /*  if(postmortem_reqd_yn.equals("Y"))
       sql = "select area_code, short_desc from mo_area where eff_status='E' and area_type not in ('R') order by 2";
    else
       sql = "select area_code, short_desc from mo_area where eff_status='E' and area_type not in ('P') order by 2";*/
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);
	
	if(popareaforbprt.equals("popareaforbprt"))
	{
	
	out.println("<script>if(parent.frames[3].document.MO_regn_form!=null)");
    out.println("var obj =parent.frames[3].document.MO_regn_form.area_type;else");
	out.println("var obj =parent.frames[3].document.forms[0].area_type");
	out.println("var length  = obj.length;");
	out.println("for(i=0;i<length;i++) {obj.remove(0);}");

	out.println("var element1 = document.createElement('OPTION')");
	out.println("element1.text = '----'+getLabel('Common.defaultSelect.label','Common')+'----'");
	out.println("element1.value= ''");
	out.println("obj.add(element1)");
	out.println("</script>");
	}else
	{
	out.println("<script>if(parent.frames[1].frames[3].document.MO_regn_form!=null)");
    out.println("var obj =parent.frames[1].frames[3].document.MO_regn_form.area_type;else");
	out.println("var obj =parent.frames[1].frames[0].frames[3].document.forms[0].area_type");
	out.println("var length  = obj.length;");
	out.println("for(i=0;i<length;i++) {obj.remove(0);}");

	out.println("var element1 = document.createElement('OPTION')");
	out.println("element1.text = '----'+getLabel('Common.defaultSelect.label','Common')+'----'");
	out.println("element1.value= ''");
	out.println("obj.add(element1)");
	out.println("</script>");
	}
int i=1;
	while(rs.next())
					{

					 area_type          =rs.getString("area_type")==null?"":rs.getString("area_type");
					 area_code			=	rs.getString("area_code");
					 area_desc	        =	rs.getString("long_desc");
					if(area_code==null || area_code.equals("null"))
						area_code="";
                    if(area_desc==null || area_desc.equals("null"))
						area_desc="";
if(popareaforbprt.equals("popareaforbprt"))
{

	
	
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(area_code1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(startendstat));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(startendstat));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
 i++;}else{	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(area_code1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(startendstat));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(startendstat));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
   i++;} }

				if(!popareaforbprt.equals("popareaforbprt"))
					{
				out.println("<script>parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'</script>");
					}


    if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
 }
 catch(Exception ee)
 {
	out.println("Exception in MOPopulateArea"+ee.getMessage());
	ee.printStackTrace();
 }
finally
{
   ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
