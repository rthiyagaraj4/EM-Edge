package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public final class __adverseeventtype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AdverseEventType.jsp", 1743587860793L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t\t\n\t\t\t\n\t\t\t var i=2;\n\t\t\t var len=document.forms[0].adv_evnt_type.options.length;\n\t\t\t var lBox=document.forms[0].adv_evnt_type; \n\t\t\t lBox.remove(lBox.options[0]);\n\t\t\t var opt=document.createElement(\'OPTION\');\n\t\t\t opt.value=\'\';\n\t\t\t opt.text= \'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\t\t lBox.add(opt);\n\n\t\t\t while(i<= len){\n\t\t\t\t lBox.remove(lBox.options[i]);\n\t\t\t\t i+=1;\n\t\t\t}   \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="|";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\tdocument.forms[0].adv_evnt_type.add(element);\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\n\t\t\t\n\t\t\t var i=2;\n\t\t\t var len=document.forms[0].adv_event_type.options.length;\n\t\t\t var lBox=document.forms[0].adv_event_type; \n\t\t\t lBox.remove(lBox.options[0]);\n\t\t\t var opt=document.createElement(\'OPTION\');\n\t\t\t opt.value=\'\';\n\t\t\t opt.text= \'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\t\t lBox.add(opt);\n\n\t\t\t while(i<= len){\n\t\t\t\t lBox.remove(lBox.options[i]);\n\t\t\t\t i+=1;\n\t\t\t}   \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\tdocument.forms[0].adv_event_type.add(element);\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t\t\n\t\t\t var i=2;\n\t\t\t var len=document.forms[0].allergen.options.length;\n\t\t\t var lBox=document.forms[0].allergen; \n\t\t\t lBox.remove(lBox.options[0]);\n\t\t\t var opt=document.createElement(\'OPTION\');\n\t\t\t opt.value=\'\';\n\t\t\t opt.text= \'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\t\t lBox.add(opt);\n\n\t\t\t while(i<= len){\n\t\t\t\t lBox.remove(lBox.options[i]);\n\t\t\t\t i+=1;\n\t\t\t}   \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\tdocument.forms[0].allergen.add(element);\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="parent.frames[5].document.forms[0].duplicate.value=\"Y\";";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="parent.frames[5].document.forms[0].duplicate.value=\"N\";";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\tparent.frames[3].document.forms[0].flag_val.value=\'Y\';\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\tparent.frames[3].document.forms[0].flag_val.value=\'N\';\n\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t/* //modified for ICN 6935 \n\t\tparent.frames[3].document.forms[0].onset_date.value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\tparent.frames[3].document.forms[0].onset_date.disabled=true;\n\t\t\tparent.frames[3].document.forms[0]..cal2.disabled=true;*/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/*parent.frames[3].document.forms[0].onset_date.disabled=false;\n\t\t\tparent.frames[3].document.forms[0].cal2.disabled=false;*/\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\tparent.frames[1].document.forms[0].flag1.value=\'Y\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\tparent.frames[1].document.forms[0].flag1.value=\'N\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\n\t\tif(parent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\') != null\t){\n\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\').style=\'display\';\n\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\').style.visibility=\'visible\';\n\t\t}\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\tif(parent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\') != null\t){\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\').style=\'display\';\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\').style.visibility=\'visible\';\n\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\tif(parent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\') != null){\n\t\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\').style.display=\'none\';\n\t\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\').style.visibility=\'hidden\';\n\t\t}\n\t\t\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\') != null){\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\').style.display=\'none\';\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\').style.visibility=\'hidden\';\n\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\tparent.frames[3].document.forms[0].reaction_value.value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\t\tparent.frames[3].document.forms[0].reaction_value.disabled=true;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\n\t\t\tparent.frames[4].document.forms[0].final_total.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\t\t\t\n\t\t\tparent.frames[4].document.forms[0].reaction_value.value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\tparent.frames[4].document.forms[0].react_code_final.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\tparent.frames[4].document.forms[0].reac_desc1_val.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t parent.frames[4].document.forms[0].reaction_value.disabled=true;\n\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t //parent.frames[4].document.forms[0].other_reaction.disabled=false;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="//parent.frames[4].document.forms[0].other_reaction.disabled=true;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="parent.frames[4].document.forms[0].react_code_final.value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\tdocument.forms[0].active_diag_cnt.value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\tdocument.forms[0].status_flag.value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'; \n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'!=0 &&\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' == \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'){  \n\t\t\t\tvar pmb=getLabel(\"eMR.ThisisPMB.label\",\"MR\");\t\t\t\t\t\t\n\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'visible\';\t\t\n\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=pmb;\n\t\t}else{  \n\t\t\tvar notpmb=getLabel(\"eMR.ThisisnotPMB.label\",\"MR\");\t\t\t\t\t\t\n\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'visible\';\t\t\t\t\t\t\n\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=notpmb;\n\t\t}\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\n\t\t\tparent.RecDiagnosisAddModify.document.forms[0].srl_no_control.value=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =";\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );
  
	public String specialCharacter(String single)
	{
		if(single == null) single = "";
		return single.replaceAll("'","");
	}	


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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
request.setCharacterEncoding("UTF-8");
Connection con = null;
ResultSet rs=null;

try {
	
	String validate=request.getParameter("validate") == null ? "" :request.getParameter("validate") ;
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	con = ConnectionManager.getConnection(request);
	//Below line added for this CRF GDOH-CRF-0082
	boolean diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
	
	Statement stmt = con.createStatement();
if(validate.equals("")||validate.equals("null")){
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String adv_evnt_val				=(String) hash.get("ADV_EVENT_TYPE_IND");
	if(adv_evnt_val ==null) adv_evnt_val="";

	String steps					=(String) hash.get("steps");
	if(steps ==null) steps="";

	String adv_evnt_code		=(String) hash.get("adv_evnt_code");
	if(adv_evnt_code==null)adv_evnt_code="";	
String locale = (String)session.getAttribute("LOCALE");
	if(steps.equals("1")){
	
		
		String sql="";
		String ADV_EVENT_TYPE_CODE="";
		String ADV_EVENT_TYPE_DESC="";

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.language_id='"+locale+"' and a.eff_status='E'  ORDER BY LONG_DESC ASC";
		
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql) ;
			
            _bw.write(_wl_block1Bytes, _wl_block1);

			if (rs != null){
						
				while(rs.next()){

					ADV_EVENT_TYPE_DESC=rs.getString("long_desc");
					ADV_EVENT_TYPE_CODE=rs.getString("ADV_EVENT_TYPE_CODE");
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ADV_EVENT_TYPE_CODE));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(ADV_EVENT_TYPE_DESC));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(ADV_EVENT_TYPE_DESC));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}
		

	}else if(steps.equals("2")){
	
		
		String sql="";
		String ADV_EVENT_TYPE_CODE="";
		String ADV_EVENT_TYPE_DESC="";

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.language_id='"+locale+"' and a.eff_status='E'";
		
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql) ;
			
            _bw.write(_wl_block6Bytes, _wl_block6);

			if (rs != null){
						
				while(rs.next()){

					ADV_EVENT_TYPE_DESC=rs.getString("long_desc");
					ADV_EVENT_TYPE_CODE=rs.getString("ADV_EVENT_TYPE_CODE");
						
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ADV_EVENT_TYPE_CODE));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(ADV_EVENT_TYPE_DESC));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(ADV_EVENT_TYPE_DESC));
            _bw.write(_wl_block7Bytes, _wl_block7);

				}
			}
		

	}else if(steps.equals("3")){
	
		
		String sql="";
		String causitive_code="";
		String causitive_desc="";

		
			sql=" select b.ALLERGEN_CODE ,b.LONG_DESC longdesc  from MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b ,MR_ADV_EVENT_TYPE c where a.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and b.language_id='"+locale+"'  and c.ADV_EVENT_TYPE_CODE='"+adv_evnt_code+"' AND a.ADV_EVENT_TYPE_IND = b.ADV_EVENT_TYPE_IND and b.ADV_EVENT_TYPE_CODE = c.ADV_EVENT_TYPE_CODE";
		
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql) ;
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			if (rs != null){
						
				while(rs.next()){

					causitive_desc=rs.getString("longdesc");
					causitive_code=rs.getString("ALLERGEN_CODE");
						
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(causitive_code));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(causitive_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(causitive_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
			}
		

	}else if(steps.equals("4")){

	String PatientId		=(String) hash.get("PatientId");
	if(PatientId==null)PatientId="";
	String reaction_date		=(String) hash.get("reaction_date");
	if(reaction_date==null)reaction_date="";	
	String allergen		=(String) hash.get("allergen");
	if(allergen==null)allergen="";

	String reaction_code	=(String) hash.get("reaction_code");
	if(reaction_code==null) reaction_code="";

	String reaction_date_old="";
	HashSet tabdata;	
	tabdata = new HashSet();
	int cnt=0;

	
	String sql_chk1="select count(*) FROM PR_ADVERSE_EVENT_REACTION where ALLERGEN_CODE = '"+allergen+"'   AND patient_id = '"+PatientId+"' and ADV_REAC_CODE = '"+reaction_code+"' order by reaction_date ";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql_chk1) ;
		if(rs !=null && rs.next())
		{
			cnt=rs.getInt(1);
		}

 if(cnt >0)
 {
	if (rs!=null) rs.close();
	
	String sql_chk="select TO_CHAR (reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date FROM PR_ADVERSE_EVENT_REACTION where ALLERGEN_CODE = '"+allergen+"'   AND patient_id = '"+PatientId+"' and ADV_REAC_CODE = '"+reaction_code+"' order by reaction_date ";	
		rs = stmt.executeQuery(sql_chk) ;
		if(rs !=null )
		{
			while(rs.next())
			{
				reaction_date_old=rs.getString("reaction_date");
				if(reaction_date_old==null ) reaction_date_old="";
				
				tabdata.add(reaction_date_old);
				if(tabdata.contains(reaction_date))
				{	//parent.frames[4].document.forms[0].duplicate.value="Y";
				
            _bw.write(_wl_block10Bytes, _wl_block10);

						
				}else
				{//parent.frames[4].document.forms[0].duplicate.value="N";
				
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				
			}

		}

 }else
{		//parent.frames[4].document.forms[0].duplicate.value="N";
		
            _bw.write(_wl_block11Bytes, _wl_block11);


 }
 if ( tabdata != null ) tabdata.clear();

	}else if(steps.equals("5")){

		String causative_code =(String) hash.get("causative_code");
		String PatientId =(String) hash.get("PatientId");
		String adv_type =(String) hash.get("adv_type");
		String adv_ind =(String) hash.get("adv_ind");
		String on_set_date="";
		int count=0;
		if (rs!=null) rs.close();
		String sql_prev_chk=" select count(*) from PR_ALLERGY_SENSITIVITY WHERE patient_id = '"+PatientId+"' AND ALLERGEN_CODE ='"+causative_code+"' AND ADV_EVENT_TYPE_IND='"+adv_ind+"'  AND ADV_EVENT_TYPE='"+adv_type+"' and status='A'";
		rs=stmt.executeQuery(sql_prev_chk);
		if(rs !=null && rs.next())
		{
			count=rs.getInt(1);
		}
			if(count >0 && !causative_code.equals("Oth")){//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
            _bw.write(_wl_block12Bytes, _wl_block12);
} else {
            _bw.write(_wl_block13Bytes, _wl_block13);
}
		if (rs!=null) rs.close();
		String sql_prev_onset_date="Select to_char(ONSET_DATE,'dd/mm/yyyy hh24:mi:ss') ONSET_DATE from PR_ALLERGY_SENSITIVITY where  patient_id='"+PatientId+"' and ALLERGEN_CODE='"+causative_code+"' and status='A'";
		rs=stmt.executeQuery(sql_prev_onset_date);

		if(rs !=null && rs.next())
		{
			on_set_date=rs.getString("ONSET_DATE");
			if(on_set_date==null) on_set_date="";
		}
		if(!on_set_date.equals("")){
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);
}else
		{
            _bw.write(_wl_block16Bytes, _wl_block16);
}

	}else if(steps.equals("6")){

		
		String PatientId =(String) hash.get("PatientId");
		String adv_event_type_code=(String) hash.get("adv_event_type_code");
		String	adv_event_type_ind_code=(String) hash.get("adv_event_type_ind_code");
		String	causative_code=(String) hash.get("causative_code");
		String reaction_date1=(String) hash.get("reaction_date1");
		String cnt1 =(String) hash.get("cnt") ;
		String status =(String) hash.get("status") ;
		String error_status =(String) hash.get("error_status") ;
		String det=(String) hash.get("det");
		String onset_date=(String) hash.get("onset_date");
		

if(status.equals("Active"))
	status="A";
else if(status.equals("Resolved"))
	status = "R";
else if(status.equals("In Error"))
	status = "E";

		if(reaction_date1!=null && !reaction_date1.equals(""))
			reaction_date1	=	reaction_date1.substring(0,10);

			if (rs!=null) rs.close();
			int cnt2=0;
			int cnt=0;
			String sql_cnt="";
		// sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and a.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') ";

		//sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' ";
		// modified on 23-07-2008 for SCR 4880
		sql_cnt = "SELECT Count (*) FROM pr_adverse_event_reaction a,pr_adverse_event b,pr_allergy_sensitivity c WHERE a.patient_id = b.patient_id AND a.adv_event_type_ind = b.adv_event_type_ind AND a.adv_event_type = b.adv_event_type AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = b.adv_event_srl_no AND a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no AND a.patient_id = c.patient_id AND a.allergen_code = c.allergen_code AND a.adv_event_type = c.adv_event_type AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_srl_no = c.adv_event_srl_no AND c.status = '"+status+"' /*and a.status = '"+error_status+"'*/ AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"' AND a.allergen_code = '"+causative_code+"' and c.onset_date = TO_DATE('"+onset_date+"','dd/mm/yyyy hh24:mi:ss') ";
					
						rs=stmt.executeQuery(sql_cnt);
						if(rs !=null && rs.next())
						{
							cnt=rs.getInt(1);
						}
						if(cnt >0)
						{
            _bw.write(_wl_block17Bytes, _wl_block17);
}else
						{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
			if(rs !=null) rs.close();	
			cnt2=Integer.parseInt(cnt1);
			//cnt2=cnt2+1;

			int cnt3=0;
			cnt3=cnt+cnt2;

			//cnt3=cnt3-1;
			int cnt_head=cnt2+1;


			if(det.equals("add"))
		{
		for(int j=cnt2;j<cnt_head;j++)
		{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
}

			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{

					
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
			}
		}else
		{
			for(int j=cnt2;j<cnt_head;j++)
		{
	
		
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{
				
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
			}
		}
		}else if(steps.equals("7")){

				String PatientId =(String) hash.get("PatientId");
				String	adv_event_dtl_srl_no=(String) hash.get("adv_event_dtl_srl_no");
				String	causative_code=(String) hash.get("causative_code");
				String reaction_date1=(String) hash.get("reaction_date1");
				String react_code_val="";
				String reac_desc="";
				StringBuffer reac_desc_final= new StringBuffer("");
				String react_code_prev="";
				int	i=0;
				
				String reac_val="select a.ADV_REAC_CODE ,c.long_desc reac_desc FROM pr_adverse_event_reaction a, pr_adverse_event b, AM_REACTION_lang_vw c where  a.PATIENT_ID='"+PatientId+"' and a.ALLERGEN_CODE='"+causative_code+"'  and b.reaction_date = TO_DATE('"+reaction_date1+"','dd/mm/yyyy hh24:mi') and a.ALLERGEN_CODE=b.ALLERGEN_CODE and c.language_id='"+locale+"' and b.ADV_EVENT_DTL_SRL_NO ='"+adv_event_dtl_srl_no+"'  and a.ADV_EVENT_DTL_SRL_NO=b.ADV_EVENT_DTL_SRL_NO and a.ADV_REAC_CODE=c.REACTION_CODE ";

				
				

			
			rs=stmt.executeQuery(reac_val);
			//out.println(reac_val);
			if(rs !=null)
			{
				while(rs.next())
				{
					react_code_val=rs.getString("ADV_REAC_CODE");
					reac_desc=rs.getString("reac_desc");

					if(!react_code_val.equals(react_code_prev))
					{
						
						reac_desc_final.append(reac_desc+";");
						
					}
					react_code_prev=rs.getString("ADV_REAC_CODE");
						i++;
				}
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(reac_desc_final.toString()));
            _bw.write(_wl_block35Bytes, _wl_block35);

			}
	}else if(steps.equals("8")){
		//PreparedStatement pstmt=null;
		String retVal=(String)hash.get("retVal");		
		String allergen=(String)hash.get("allergen");
		String reac_code_val_prev=(String)hash.get("reac_code_val_prev");
		if(reac_code_val_prev.equals("undefined"))reac_code_val_prev="";   	 
     
	/* MR_SPR_6282 _1 11/6/2008*/	
		String final_total=(String)hash.get("final_total");
		if(final_total == null) final_total = "";
		/*String f_code = "";
		String f_date = "";
		String f_severity = "";
		String f_Site = "";
		 StringTokenizer st_final_total = new StringTokenizer(final_total,"^");
				while(st_final_total.hasMoreTokens()){
					f_code = st_final_total.nextToken();
					f_date = st_final_total.nextToken();
					//if(st_final_total.nextToken().equals("") ) st_final_total.nextToken() = "S";
					f_severity = st_final_total.nextToken();
					if(f_severity.equals("~"))
						f_severity = "";
					f_Site = st_final_total.nextToken();
					if(f_Site.equals("~"))
						f_Site = "";*/
			//}
			//parent.frames[4].document.forms[0].final_total.value
		
            _bw.write(_wl_block36Bytes, _wl_block36);

/* MR_SPR_6282 _1 11/6/2008*/	


		String reac_code_val_prev_one="";
		//String reac_code_val_final="";
		String adv_reac_code="";
		String adv_reac_code1="";
		StringBuffer reac_desc_final= new StringBuffer("");
		String reaction_desc_final= "";
		StringBuffer reac_code_final= new StringBuffer("");
		StringBuffer oth_desc_final= new StringBuffer("");
		String reac_desc="";
		String oth_reaction="";
		String oth_reaction2="";
		boolean chkvalue=false;
		//String reac_code_val_recent="";
		 HashSet tabdata1;	
		 HashSet tabdata2;
		 HashSet tabdata3;		
		//HashMap hashmap = new HashMap();
		tabdata1=new HashSet();
		tabdata2=new HashSet();
		tabdata3=new HashSet();
		
		
		StringTokenizer token=new StringTokenizer(retVal,"`");
		while(token.hasMoreTokens())
		{
			oth_reaction=token.nextToken();
			oth_reaction2=token.nextToken();
			//reac_desc_final.append(oth_reaction2 + ";");
			oth_desc_final.append(oth_reaction2 + ";");
			reac_code_final.append(oth_reaction2 +"`");

			StringTokenizer token1=new StringTokenizer(oth_reaction,"@");
			while(token1.hasMoreTokens())
			{
				adv_reac_code1=token1.nextToken();						    
				tabdata1.add(adv_reac_code1);    //selected actions from the lookup
			}
		}
		if(!reac_code_val_prev.equals("") && reac_code_val_prev!=null){
		StringTokenizer token1=new StringTokenizer(reac_code_val_prev,"`");
		while(token1.hasMoreTokens())
		{
			reac_code_val_prev_one=token1.nextToken();            			
			tabdata3.add(reac_code_val_prev_one);		//previous value from the table
		}
		}	
		//Changed "reac_caused" from string to StringBuffer by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
		StringBuffer reac_caused = new StringBuffer();
		reac_caused.setLength(0);
		reac_caused.append("select REACTION_CODE,LONG_DESC from ( select a.REACTION_CODE REACTION_CODE,a.LONG_DESC LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE ");
		if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
			reac_caused.append(" and b.ALLERGEN_CODE='"+allergen+"' ");
		reac_caused.append(" and a.language_id='"+locale+"' and a.eff_status = 'E' UNION Select REACTION_CODE,LONG_DESC from AM_REACTION_lang_vw where REACTION_CODE like 'UNKN%' and language_id='"+locale+"' and eff_status = 'E') ");
		rs=stmt.executeQuery(reac_caused.toString());
		if(rs !=null)
		{
			while(rs.next())
			{
				reac_desc=specialCharacter(rs.getString("LONG_DESC"));
				adv_reac_code=rs.getString("REACTION_CODE");
				tabdata2.add(adv_reac_code);
                 if(!tabdata3.contains(adv_reac_code) && tabdata1.contains(adv_reac_code)){					    
					tabdata3.add(adv_reac_code);
					reac_desc_final.append(adv_reac_code + ";");
					reac_desc_final.append(reac_desc + ";");
					reac_code_final.append(adv_reac_code +"`");
					//reaction_desc_final.append(final_total+"!"+reac_desc+"!");				
				}							
             
			}
			String no_reaction=reac_desc_final.toString();
			if(no_reaction.equals("")) no_reaction="$";
			String final_string=no_reaction+"`"+oth_desc_final.toString();
			String oth_rec=oth_desc_final.toString();
			if(oth_rec.equals("") && no_reaction.equals("$") )
			{
				final_string="";
			}
			//reaction_desc_final = final_total+"!"+final_string;
			
			
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(reaction_desc_final));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(final_string));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(reac_code_final.toString()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(reac_desc_final.toString()));
            _bw.write(_wl_block41Bytes, _wl_block41);
 if(tabdata2.contains("UNKN") && !reac_code_final.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);

			 }else{
			
            _bw.write(_wl_block43Bytes, _wl_block43);

			 }
		StringBuffer reac_code_val_last = new StringBuffer("");
		
		Iterator iter=tabdata3.iterator();
		while(iter.hasNext())
		{
			String c1=(String)iter.next();			
			reac_code_val_last.append(c1+"`");
		}

		
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reac_code_val_last.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);



		}

		
		if ( tabdata1 != null )  tabdata1.clear();
		if ( tabdata2 != null )  tabdata2.clear();
		if ( tabdata3 != null )  tabdata3.clear();
}else if(steps.equals("9")) {
	
		//String PatientId = (String)hash.get("PatientId");
		/*String status=(String)hash.get("status_1");
		String since=(String)hash.get("since_date");
		String certainity=(String)hash.get("certainity");
		String diagnosis=(String)hash.get("diagnosis_code");
		String route_of_expo=(String)hash.get("route_of_expo");
		String source_of_info=(String)hash.get("source_of_info");
		String allergy_test_res=(String)hash.get("allergy_test_res");
		String treat_advice=(String)hash.get("treat_advice");
		String remarks=(String)hash.get("remarks");*/

		String details=java.net.URLDecoder.decode((String)hash.get("details"));

	session.putValue("DETAILS_CODE",details);
	
	
	}else if(steps.equals("10")){
	String final_total=(String)hash.get("final_total");

	session.putValue("final_total",final_total);
	}
	/*
		Caluculate the diagnosis count
	*/
	else if(steps.equals("11")){
		String active_diag_cnt="";
		String patient_id=(String)hash.get("patient_id");

		//String sql_active_diag="SELECT count(*) FROM pr_problem WHERE patient_id='"+patient_id+"' AND problem_status='A'";
		String sql_active_diag="SELECT count(*) FROM pr_diagnosis WHERE patient_id='"+patient_id+"' AND curr_status='A'";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sql_active_diag) ;	
			if(rs !=null && rs.next())
			{
				active_diag_cnt=rs.getString(1);
				
			}

			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(active_diag_cnt));
            _bw.write(_wl_block47Bytes, _wl_block47);


			if(rs!=null)rs.close();

	}
	/*	
	End for logic for the Dignosis count
	*/
	//Added by Senthil
	else if(steps.equals("Injury")){
		
		String patient_id=(String)hash.get("patient_id");
		String facility_id=(String)hash.get("facility_id");
		String encounterID=(String)hash.get("encounterID");
		String injury_date=(String)hash.get("injury_date");
		String trmt_strt_date=(String)hash.get("trmt_strt_date");
		/*facility_id,patient_id,encounterID,injury_date,trmt_strt_date*/
		String statusFlag="";		
			String sqlQuery="select MR_PAT_INJURY_DATE_CHK(to_date('"+injury_date+"','dd/mm/yyyy'),to_date('"+trmt_strt_date+"','dd/mm/yyyy'),'"+patient_id+"','"+encounterID+"','"+facility_id+"') flag_status from dual"; 
					
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sqlQuery) ;	
			if(rs !=null && rs.next())
			{
			 statusFlag=rs.getString("flag_status")==null?"":rs.getString("flag_status");
			}
			
			
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(statusFlag));
            _bw.write(_wl_block49Bytes, _wl_block49);

			if(rs!=null)rs.close();
	}	
	//End Senthil	
	//Below line added for this CRF GDOH-CRF-0082
	else if(steps.equals("PMBCheck") && diagnosisPmb){		
		
		String code_set=request.getParameter("code_set")==null?"":request.getParameter("code_set");
		String diagprob_code=request.getParameter("diagprob_code")==null?"":request.getParameter("diagprob_code");
		String pmbsupportdiag=request.getParameter("pmbsupportdiag")==null?"":request.getParameter("pmbsupportdiag");
		String totsupportdiagCount=request.getParameter("totsupportdiagCount")==null?"":request.getParameter("totsupportdiagCount");
		if(totsupportdiagCount ==null || totsupportdiagCount.equals("null") || totsupportdiagCount.equals("")) totsupportdiagCount="0";	
		int totdigCount=Integer.parseInt(totsupportdiagCount);	
        int supportDigPmbCount=eMR.MRQueryPMBCode.getSupportDignosisWithPMB(con,diagprob_code,pmbsupportdiag);
		
		
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totdigCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totdigCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(supportDigPmbCount));
            _bw.write(_wl_block53Bytes, _wl_block53);

			if(rs!=null)rs.close();
	}	
	//End GDOH-CRF-0082
	//Added for this CRF Bru-HIMS-CRF-024.2
	else if(steps.equals("SerialNo")){
		
		String code_set=(String)hash.get("code_set");
		String diagprob_code=(String)hash.get("diagprob_code");
		String Patient_Id=(String)hash.get("Patient_Id");
		String SerialNoQuery="select nvl(max(OCCUR_SRL_NO),0)+1 srl_no from pr_diagnosis where patient_id ='"+Patient_Id+"' and term_set_id='"+code_set+"' and term_code='"+diagprob_code+"'"; 
 		String srlnocontrol="";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getString("srl_no")==null?"":rs.getString("srl_no");
			}
			
			
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(srlnocontrol));
            _bw.write(_wl_block55Bytes, _wl_block55);

			if(rs!=null)rs.close();
	}	
	//End Bru-CRF-HIMS-CRF-024.2
	
	//Added for this CRF ML-MMOH-CRF-0615
	else if(steps.equals("CheckEncounterId"))
	{
		
		String patient_id=(String)hash.get("patient_id");
		String encounter_id=(String)hash.get("p_encounter_id");
		StringBuffer msg = new StringBuffer();
		if(!encounter_id.equals("") )
		{
			StringBuffer SerialNoQuery = new StringBuffer();
		
		 SerialNoQuery.append("select count(*) cnt from pr_encounter where encounter_id = '"+encounter_id+"' "); 
		 
		
		 
		 
		
 		     int srlnocontrol=1;
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getInt("cnt");
			}
			
			
			if(srlnocontrol != 0)
			msg.append(srlnocontrol+"$$");
			else
			msg.append("0"+"$$");
		}
		if(!patient_id.equals("") && !encounter_id.equals(""))
			{
		
				StringBuffer SerialNoQuery = new StringBuffer();

				SerialNoQuery.append("select count(*) cnt from pr_encounter where encounter_id = '"+encounter_id+"' "); 

				if(!patient_id.equals(""))
				SerialNoQuery.append (" and patient_id ='"+patient_id+"' ");

				

				int srlnocontrol=1;
				if(rs!=null)rs.close();
				rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
				if(rs !=null && rs.next())
				{
				srlnocontrol=rs.getInt("cnt");
				}
				

				if(srlnocontrol != 0)
				msg.append(srlnocontrol+"$$");
				else
				msg.append("0"+"$$");
			}	
			out.println(msg.toString());
			
            _bw.write(_wl_block56Bytes, _wl_block56);

			if(rs!=null)rs.close();
	}	
	
	
	else if(steps.equals("CheckPatientId")){
		
		String patient_id=(String)hash.get("patient_id");
		String encounter_id=(String)hash.get("p_encounter_id");
		StringBuffer msg = new StringBuffer();
	
		if(!patient_id.equals("") )
		{
			StringBuffer SerialNoQuery = new StringBuffer();
		
		 SerialNoQuery.append("select count(*) cnt from pr_encounter where patient_id = '"+patient_id+"' "); 
		 
		
		 
		 
		
 		     int srlnocontrol=1;
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getInt("cnt");
			}
			
			
			if(srlnocontrol != 0)
			msg.append(srlnocontrol+"$$");
			else
			msg.append("0"+"$$");
		}
		if(!patient_id.equals("") && !encounter_id.equals(""))
		{
		StringBuffer SerialNoQuery = new StringBuffer();
		
		 SerialNoQuery.append("select count(*) cnt from pr_encounter where patient_id = '"+patient_id+"' "); 
		 
		 if(!encounter_id.equals(""))
			 SerialNoQuery.append (" and encounter_id ='"+encounter_id+"' ");
		 
		 
		
 		     int srlnocontrol=1;
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getInt("cnt");
			}
			
			
			if(srlnocontrol != 0)
			msg.append(srlnocontrol+"$$");
			else
			msg.append("0"+"$$");
		}	
		
			out.println(msg.toString());
			
			
            _bw.write(_wl_block56Bytes, _wl_block56);

			if(rs!=null)rs.close();
	}
	
	else if(steps.equals("12"))
	{
		String link_Complaint = (String)hash.get("details");
		session.putValue("linkComplaint",link_Complaint);
	}
	else if(steps.equals("13"))
	{
		session.removeAttribute("linkComplaint");
	}
	else if(steps.equals("CLEAR_ALL_SESSION_VALUES")){

		session.removeAttribute("DETAILS_CODE");
		session.removeAttribute("final_total");
	}	
	if (hash !=null) hash.clear();
}
	/*Tuesday, December 29, 2009 code added to check free_text_applicable_yn for selected termset in MR Reports-> Patient List With Related Diagnosis */
	else if(validate.equals("FREE_TEXT_YN"))
	{
		String free_text_applicable_yn	= "";
		String termSetID = request.getParameter("termSetID");
		String sqlFreeText="select free_text_applicable_yn from mr_term_set where term_set_id = '"+termSetID+"' and diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sqlFreeText) ;	
			if(rs !=null && rs.next())
			{
				free_text_applicable_yn=rs.getString(1);
				
			}
			if(rs!=null)rs.close();
			out.write(free_text_applicable_yn);
	}
	if (stmt !=null) stmt.close();
	//if (hash !=null) hash.clear();
	}catch( Exception e ){
	out.println(e.toString());
	e.printStackTrace();

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block57Bytes, _wl_block57);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
