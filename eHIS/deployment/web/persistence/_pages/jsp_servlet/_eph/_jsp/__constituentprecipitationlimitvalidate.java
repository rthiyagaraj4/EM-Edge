package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __constituentprecipitationlimitvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ConstituentPrecipitationLimitValidate.jsp", 1732509187884L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	String flag_From_To = request.getParameter( "flag_From_To" ) ;


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ConstituentPrecipitationLimitBean bean = (ConstituentPrecipitationLimitBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if (validate.equals("POPULATE_MOLE")){

				String Gen_Name_Limit = request.getParameter("Gen_Name_Limit");
				String cnt = request.getParameter("cnt");
			
		
				if(flag_From_To.equals("F") )
				{
				//out.println("eval('document.FormConstituentPresLimitAddmodify.Mol_Name_From'); ");
				out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"'); ");
				//out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_"+cnt+".value=''; ");
				}
				if(flag_From_To.equals("T") )
				{
				//out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To'); ");
				out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"'); ");
				//out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_"+cnt+".value=''; ");
				}
					
				ArrayList mol_names = bean.getConstituentMoleculeName(Gen_Name_Limit);
				

	
				if(mol_names.size()>0)
				{
				for(int i=0; i< mol_names.size(); i=i+2) {
					if(flag_From_To.equals("F"))
					{

					//out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"'); ");
					out.println("addListItem(\"FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"\", \"" + mol_names.get(i) + "\",\"" + mol_names.get(i+1) + "\");");
				
					}
					else
					{
					//out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"'); ");
					out.println("addListItem(\"FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"\", \"" + mol_names.get(i) + "\",\"" + mol_names.get(i+1) + "\");");
				
					}
				}
				}else
				{
				if(flag_From_To.equals("F"))
					{
					out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"'); ");
					}else
					{
					out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"'); ");
					}
				}
			}
			if (validate.equals("CONST_GENRIC_UOM")){


				String cnt = request.getParameter("cnt");
				String Gen_To_UOM = (request.getParameter("Gen_To_UOM"));
				String Gen_To_UOM_code = request.getParameter("Gen_To_UOM_code");
				String Gen_UOM_conv_litre = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PerLitre.label","ph_labels");
				String Gen_UOM_conv_decilitre = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Perdecilitre.label","ph_labels");
		
				
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_"+cnt+".value = '"+Gen_To_UOM_code+"';");
			

				if(Gen_To_UOM.equals("MMOL"))
				{
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_litre+"';");
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_litre+"';");
				}else
				{
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_decilitre+"';");
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_decilitre+"';");
				}
		
			}


			if (validate.equals("CONST_GENRIC_RANGE")){


				String num = request.getParameter("num");
				String Con_ConCen_Min = (String)request.getParameter("Con_ConCen_Min")==null?"":(String) request.getParameter("Con_ConCen_Min");
				String Con_ConCen_Max = (String)request.getParameter("Con_ConCen_Max")==null?"":(String) request.getParameter("Con_ConCen_Max");
				String Gen_Name_Limit_From = (String)request.getParameter("Gen_Name_Limit_From")==null?"":(String) request.getParameter("Gen_Name_Limit_From");
				String Gen_Name_Limit_To = (String)request.getParameter("Gen_Name_Limit_To")==null?"":(String) request.getParameter("Gen_Name_Limit_To");
				String chkFlag = request.getParameter("chkFlag");
				String uom = request.getParameter("uom");
		
				if(!(Con_ConCen_Min.equals("")) && !(Con_ConCen_Max.equals("")))
				{
				
					float Con_Con_Min =Float.parseFloat(Con_ConCen_Min) ;
					float Con_Con_Max = Float.parseFloat(Con_ConCen_Max) ;
		
				    boolean validRange= bean.getRangeOverlapValidate((ArrayList)bean.getConstituentRange(Gen_Name_Limit_From,Gen_Name_Limit_To,chkFlag),Con_Con_Min,Con_Con_Max,uom);

				
				
					 if(validRange)
						{
							out.println("callInfo("+num+",\""+chkFlag+"\");") ;
							
						}
				
			
				}
		
			}
		






putObjectInBean(bean_id,bean,request);

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
