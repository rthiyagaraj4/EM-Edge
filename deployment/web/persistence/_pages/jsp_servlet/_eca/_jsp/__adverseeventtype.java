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
import java.net.*;
import webbeans.eCommon.*;

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
        if (sci.isResourceStale("/eca/jsp/AdverseEventType.jsp", 1731574036591L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block10 ="parent.frames[4].document.forms[0].duplicate.value=\"Y\";";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="parent.frames[4].document.forms[0].duplicate.value=\"N\";";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\tdocument.forms[0].flag1.value=\'Y\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\tdocument.forms[0].flag1.value=\'N\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\teval(\"document.forms[0].third\"+";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =").style=\'display\';\n\t\teval(\"document.forms[0].third\"+";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =").style.visibility=\'visible\';\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\n\t\t\t\tif(eval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =") != null\t){\n\t\t\t\teval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =").style.display=\'Inline\';\n\t\t\t\teval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =").style.visibility=\'visible\';\n\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =").style.display=\'none\';\n\t\teval(\"document.forms[0].third\"+";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =").style.visibility=\'hidden\';\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\n\t\t\t\tif(eval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =").style.display=\'none\';\n\t\t\t\teval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =").style.visibility=\'hidden\';\n\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\tparent.frames[1].document.forms[0].flag1.value=\'Y\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\tparent.frames[1].document.forms[0].flag1.value=\'N\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\').style=\'display\';\n\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\').style.visibility=\'visible\';\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\tif(parent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\') != null\t){\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\').style=\'display\';\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\').style.visibility=\'visible\';\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\').style.display=\'none\';\n\t\tparent.frames[1].document.getElementById(\'third";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\').style.visibility=\'hidden\';\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\n\t\t\t\tif(parent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\') != null\t){\t\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\').style.display=\'none\';\n\t\t\t\tparent.frames[1].document.getElementById(\'second";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\').style.visibility=\'hidden\';\n\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =").style=\'display\';\n\t\t\t\teval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =") != null\t){\n\t\t\t\t\t\n\t\t\t\teval(\"document.forms[0].second\"+";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\t\t\tparent.frames[3].document.forms[0].reaction_value.value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\';\n\t\t\tparent.frames[3].document.forms[0].react_code_final.value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\n\t\t\tparent.frames[3].document.forms[0].reac_desc1_val.value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t //parent.frames[3].document.forms[0].reaction_value.disabled=true;\n\t\t\t ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t// parent.frames[3].document.forms[0].other_reaction.disabled=false;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="//parent.frames[3].document.forms[0].other_reaction.disabled=true;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="parent.frames[3].document.forms[0].react_code_final.value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
 
Connection con = null;
ResultSet rs=null;

try {
	con = ConnectionManager.getConnection(request);
	Statement stmt = con.createStatement();

	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String facilityId	=(String) session.getValue("facility_id");

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

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.ADDED_FACILITY_ID='"+facilityId+"' and a.language_id='"+locale+"' and a.eff_status='E'";
		
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

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.ADDED_FACILITY_ID='"+facilityId+"'and a.language_id='"+locale+"' and a.eff_status='E'";
		
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
				{	
				
            _bw.write(_wl_block10Bytes, _wl_block10);

						
				}else
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				
			}

		}

 }else
{
		
            _bw.write(_wl_block11Bytes, _wl_block11);


 }
 if ( tabdata != null ) tabdata.clear();

	}else if(steps.equals("5")){

				String PatientId =(String) hash.get("PatientId");
		String adv_event_type_code=(String) hash.get("adv_event_type_code");
		String	adv_event_type_ind_code=(String) hash.get("adv_event_type_ind_code");
		String	causative_code=(String) hash.get("causative_code");
		//String reaction_date1=(String) hash.get("reaction_date1");
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


			if (rs!=null) rs.close();
			int cnt2=0;
			int cnt=0;
			String sql_cnt="";
	//	 sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and a.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') ";
		 sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  AND c.status = '"+status+"' /*and a.status = '"+error_status+"'*/ AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and c.onset_date = TO_DATE('"+onset_date+"','dd/mm/yyyy hh24:mi:ss') ";
		
					rs=stmt.executeQuery(sql_cnt);
						if(rs !=null && rs.next())
						{
							cnt=rs.getInt(1);
						}
						if(cnt >0)
						{
            _bw.write(_wl_block12Bytes, _wl_block12);
}else
						{
            _bw.write(_wl_block13Bytes, _wl_block13);
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
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block16Bytes, _wl_block16);
}

			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}
		}else
		{
			for(int j=cnt2;j<cnt_head;j++)
		{
            _bw.write(_wl_block14Bytes, _wl_block14);
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
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
			}
		}

	}else if(steps.equals("6")){

		
		String PatientId =(String) hash.get("PatientId");
		String adv_event_type_code=(String) hash.get("adv_event_type_code");
		String	adv_event_type_ind_code=(String) hash.get("adv_event_type_ind_code");
		String	causative_code=(String) hash.get("causative_code");
		//String reaction_date1=(String) hash.get("reaction_date1");
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


		

			if (rs!=null) rs.close();
			int cnt2=0;
			int cnt=0;
			String sql_cnt="";
	//	 sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and a.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') ";
		 sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no  AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  AND c.status = '"+status+"' /*and a.status = '"+error_status+"'*/ AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and c.onset_date = TO_DATE('"+onset_date+"','dd/mm/yyyy hh24:mi:ss') ";
						
						rs=stmt.executeQuery(sql_cnt);
						if(rs !=null && rs.next())
						{
							cnt=rs.getInt(1);
						}
						if(cnt >0)
						{
            _bw.write(_wl_block26Bytes, _wl_block26);
}else
						{
            _bw.write(_wl_block27Bytes, _wl_block27);
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
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block30Bytes, _wl_block30);
}

			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
			}
		}else
		{
			for(int j=cnt2;j<cnt_head;j++)
		{
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
			}
		}
		}else if(steps.equals("7")){

		String PatientId =(String) hash.get("PatientId");
		String adv_event_type_code=(String) hash.get("adv_event_type_code");
		String	adv_event_type_ind_code=(String) hash.get("adv_event_type_ind_code");
		String	causative_code=(String) hash.get("causative_code");
		//String reaction_date1=(String) hash.get("reaction_date1");
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
	

			if (rs!=null) rs.close();
			int cnt2=0;
			int cnt=0;
			String sql_cnt="";
	//	 sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.status='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and a.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') ";
		 sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO and a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no  AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  AND c.status = '"+status+"' /*and a.status = '"+error_status+"'*/ AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and c.onset_date = TO_DATE('"+onset_date+"','dd/mm/yyyy hh24:mi:ss') ";




						rs=stmt.executeQuery(sql_cnt);
						if(rs !=null && rs.next())
						{
							cnt=rs.getInt(1);
						}
						if(cnt >0)
						{
            _bw.write(_wl_block12Bytes, _wl_block12);
}else
						{
            _bw.write(_wl_block13Bytes, _wl_block13);
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
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block16Bytes, _wl_block16);
}

			if(cnt > 0)
			{

				for(int i=cnt2;i<cnt3;i++)
				{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}
		}else
		{
			for(int j=cnt2;j<cnt_head;j++)
		{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
			if(cnt > 0)
			{

				for(int i=cnt2;i<cnt3;i++)
				{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
			}
		}
	}else if(steps.equals("8")){
		//PreparedStatement pstmt=null;
		String retVal=(String)hash.get("retVal");
		String allergen=(String)hash.get("allergen");
		String reac_code_val_prev=(String)hash.get("reac_code_val_prev");
		String reac_code_val_prev_one="";
		//String reac_code_val_final="";
		String adv_reac_code="";
		String adv_reac_code1="";
		StringBuffer reac_desc_final= new StringBuffer("");
		StringBuffer reac_code_final= new StringBuffer("");
		StringBuffer oth_desc_final= new StringBuffer("");
		String reac_desc="";
		String oth_reaction="";
		String oth_reaction2="";
		//String reac_code_val_recent="";
		 HashSet tabdata1;	
		 HashSet tabdata2;
		 HashSet tabdata3;
		 
		//HashMap hashmap = new HashMap();
		tabdata1=new HashSet();
		tabdata2=new HashSet();
		tabdata3=new HashSet();
		StringTokenizer token=new StringTokenizer(retVal,"*");
		while(token.hasMoreTokens())
		{
			oth_reaction=token.nextToken();
			oth_reaction2=token.nextToken();
			//reac_desc_final.append(oth_reaction2 + ";");
			oth_desc_final.append(oth_reaction2 + ";");
			reac_code_final.append(oth_reaction2 +"*");


			StringTokenizer token1=new StringTokenizer(oth_reaction,"@");
			while(token1.hasMoreTokens())
		{
			adv_reac_code1=token1.nextToken();
			tabdata1.add(adv_reac_code1);
		}
		}
		StringTokenizer token1=new StringTokenizer(reac_code_val_prev,"*");
		while(token1.hasMoreTokens())
		{
			reac_code_val_prev_one=token1.nextToken();
			tabdata3.add(reac_code_val_prev_one);
		}

		String reac_caused="select REACTION_CODE,LONG_DESC from ( select a.REACTION_CODE REACTION_CODE,a.LONG_DESC LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE and b.ALLERGEN_CODE='"+allergen+"' and a.language_id='"+locale+"' UNION Select REACTION_CODE,LONG_DESC from AM_REACTION_lang_vw where REACTION_CODE like 'UNKN%' and language_id='"+locale+"')";

		rs=stmt.executeQuery(reac_caused);
		if(rs !=null)
		{
			while(rs.next())
			{
				reac_desc=rs.getString("LONG_DESC");
				adv_reac_code=rs.getString("REACTION_CODE");
				tabdata2.add(adv_reac_code);
				if(tabdata1.contains(adv_reac_code))
				{
					tabdata3.add(adv_reac_code);
					reac_desc_final.append(reac_desc + ";");
					reac_code_final.append(adv_reac_code +"*");
				}

			}
			String no_reaction=reac_desc_final.toString();
			if(no_reaction.equals("")) no_reaction="$";
			String final_string=no_reaction+"*"+oth_desc_final.toString();
			String oth_rec=oth_desc_final.toString();
			if(oth_rec.equals("") && no_reaction.equals("$") )
			{
				final_string="";
			}

			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(final_string));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(reac_code_final.toString()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(reac_desc_final.toString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
 if(tabdata2.contains("UNKN") && !reac_code_final.equals("")){
            _bw.write(_wl_block49Bytes, _wl_block49);

			 }else{
			
            _bw.write(_wl_block50Bytes, _wl_block50);

			 }
		StringBuffer reac_code_val_last = new StringBuffer("");
		
		Iterator iter=tabdata3.iterator();
		while(iter.hasNext())
		{
			String c1=(String)iter.next();
			reac_code_val_last.append(c1+"*");
		}
		
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(reac_code_val_last.toString()));
            _bw.write(_wl_block52Bytes, _wl_block52);



		}
		if ( tabdata1 != null )  tabdata1.clear();
		if ( tabdata2 != null )  tabdata2.clear();
		if ( tabdata3 != null )  tabdata3.clear();
}
	if (stmt !=null) stmt.close();
	if (hash !=null) hash.clear();
	}catch( Exception e ){
	e.printStackTrace() ;

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block53Bytes, _wl_block53);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
