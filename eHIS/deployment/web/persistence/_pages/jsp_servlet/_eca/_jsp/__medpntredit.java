package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __medpntredit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MedPntredit.jsp", 1709115937949L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n21/7/2012\t  IN034119\t\t Nijitha\t The modified images are not appearing in the modify mode\n05/05/2015\tIN053298\t\tRamesh G\tWhen we attach an image to the clinical note part of the image is not displayed.\n24/11/2020\t8188\t\t\tRamesh G\tSKR-SCF-1496\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCA/js/prototype.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart3.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n</head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<body class=\"message\" onload = \"loadSecImage(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<FORM name=\"editor\" id=\"editor\" METHOD=\"POST\" ACTION=\"../servlet/SessJpgReader\">\n<INPUT TYPE=\"hidden\" name=\"image\" id=\"image\" value=\"\">\n\n<table border=\"0\" width=\"100%\">\n<tr>\n\t<td >\n\t\t<table border=\"0\" width=\"100%\">\n\t\t<tr>\n\t\t\t<td width=\"4%\"><object code=\"Standard.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"48\" height=\"20\" align=\"top\" codebase = \"http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0\" > </object>\n\t\t\t</td>\n\t\t\t<td width=\"66%\"><object code=\"Formatting.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"295\" height=\"20\" align=\"top\" codebase = \"http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0\"> </object>\n\t\t\t</td>\n\t\t\t<td width = \"30%\" align = \"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =":\n\t\t\t\t<select onchange=\"changeImage(this,\'\')\" name=\"avlImg\" id=\"avlImg\">\n\t\t\t\t\t<option value = \"\">&nbsp;&nbsp;&nbsp;&nbsp;------";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="-----&nbsp;&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n<tr>\n\t<td >\n\t\t<table border=\"0\" width=\"100%\">\n\t\t<tr>\n\t\t\t<td width=\"35%\" align=\"centre\">\n\t\t\t\t<!-- Tool Panel -->\t\n\t\t\t\t<object code=\"ToolBox.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"275\" height=\"20\" codebase = \"http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0\"> </object>\n\t\t\t</td>\n\t\t\t<td width=\"65%\" align=\"left\">\n\t\t\t\t<!-- Pen Panel -->\n\t\t\t\t<object code=\"Pens.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"160\" height=\"20\" codebase = \"http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0\"> </object>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n<tr>\n\t<td>\n\t\t<table border=\"2\" cellpadding=\"1\" width = \"100%\">\n\t    <tr>\n\t\t\t<td valign=\"top\">\n\t\t\t\t<!-- Color Pallet -->\n\t\t\t\t<object code=\"Pallet.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"75\" height=\"200\" codebase = \"http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0\"> </object>\n\t\t\t</td>\n\t\t\t<td bgcolor=\"#000000\"><object name=\"drawing\" code=\"Drawing.class\" codebase=\"../MediPainter/\"\n\t\t\t\t\t\t\t\t\tarchive=\"medipainterapplet.jar\" width=\"845\" height=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" align=\"baseline\" codebase = \"http://java.sun.com/update/1.4.2/jinstall-1_4-windows-i586.cab#Version=1,4,2,0\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t<param name=\"loadImage\" height =\"350\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t<param name =\"Image\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<param name=\"canDraw\" value=\"1\">\t\n\t\t\t\t\t\t</object>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n</table>\n<input type =\"hidden\" name =\"default_yn\"  value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n</FORM>\n</body>\n<SCRIPT LANGUAGE=\"JavaScript\">\n//if(document.editor.avlImg.value !=\"\" || document.editor.avlImg.value!=\'\')//IN034119\nif(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" == \'N\')//IN034119\nchangeImage(document.editor.avlImg,\'defaultval\');\n//Show Image button\nvar button1 = parent.parent.EditorTitleFrame.document.RecClinicalNotesEditorTitleForm.button1;\n//Show Both button\nvar button2 = parent.parent.EditorTitleFrame.document.RecClinicalNotesEditorTitleForm.button2;\n\nif(button1 != null && button2 != null)\n{\n\tbutton1.disabled = false;\n\tbutton2.disabled = false;\n}\nelse\n\talert(getMessage(\"IMG_TOOL_LD_FATAL_ERROR\",\"CA\"));\n\t\n</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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

	
	//IN053298 Start.
	public static byte[] a_db(File file,String image_ref) throws Exception
	{
		Connection con = null;
		PreparedStatement ptsmt = null;
		ResultSet rs = null;
		InputStream ins=null;
		ByteArrayOutputStream bytearrayoutputstream =null;
		String qryImgContent="";
		java.sql.Blob img_blob = null;
		byte[] by = null;
		try{			
			bytearrayoutputstream = new ByteArrayOutputStream();
			con = ConnectionManager.getConnection();
			qryImgContent = "select OBJTYPE, IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF = ? ";
			ptsmt = con.prepareStatement(qryImgContent);
			ptsmt.setString(1,image_ref);
			rs = ptsmt.executeQuery();
			while(rs !=null  && rs.next())
			{		
				if(rs.getString("OBJTYPE")!=null){
					img_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
					if(img_blob!=null){
						long len = img_blob.length();					
						if(len > 0){
							ins = img_blob.getBinaryStream();				
							int i;
							while((i = ins.read()) != -1) 
								bytearrayoutputstream.write(i);
							if (ins != null) ins.close();
								
							boolean fcre=false;
							fcre = file.createNewFile();
							if(fcre)
							{
								FileOutputStream fileoutput = new FileOutputStream(file);
								fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
								if (fileoutput != null)  fileoutput.close();			
							}
						}else{
							System.out.println("---------------------->len 0");
						}
					}else{
						System.out.println("-------------------------->img_blob null");
					}
				}
			}
			if(bytearrayoutputstream.size()>0){
				by=new byte[bytearrayoutputstream.size()];
				by=bytearrayoutputstream.toByteArray();
			}else{
				by=new byte[0];
			}

		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			if(con!=null) con.close();
			if(rs!=null)
				rs.close();
			if(ptsmt!=null)
				ptsmt.close();
		}

		return by;
	
	}
	//IN053298 End.


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
Connection			con				=	null;
PreparedStatement	stmt			=	null;
ResultSet			rs				=	null;

String sec_hdg_code				= request.getParameter("sec_hdg_code") ;
String image_view_counter		= request.getParameter("image_view_counter") ;
String curr_sec_hdg_code		= request.getParameter("curr_sec_hdg_code") ==null?"":request.getParameter("curr_sec_hdg_code");
String curr_child_sec_hdg_code	= request.getParameter("curr_child_sec_hdg_code")==null?"": request.getParameter("curr_child_sec_hdg_code");
String patient_id				= request.getParameter("patient_id") ==null?"":request.getParameter("patient_id");
String encounter_id				= request.getParameter("encounter_id") ==null?"":request.getParameter("encounter_id");

String image_url				=	"";
String image_ref				=	"";
String image_ref_desc			=	"";
String default_yn				=	"";
String default_image_url		=	""; 
String section_image_content	= "";
String strKey					=	"";

strKey = patient_id + "~"+encounter_id;
strKey = strKey.trim();
sectionBean.getPatientSection(strKey);

if(curr_child_sec_hdg_code.equals(""))
	curr_child_sec_hdg_code = curr_sec_hdg_code;

section_image_content =(String) sectionBean.getSectionImageContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
String contentAvailable = "N";//IN034119

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String default_avl = "N";
	String imageHeight = "400";  //IN053298
	String tempImageHeight = "400";	 //IN053298

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
					
					
					try
					{
						String default_yn_sel	=	"";
						//String sql = " select A.image_url, A.image_ref_desc,B.DEFAULT_YN from ca_note_image_list a,ca_section_image_link b where a.image_ref=b.image_ref and b.sec_hdg_code=?";
						String sql = "select A.image_ref,A.image_url, A.image_ref_desc,B.DEFAULT_YN from CA_NOTE_IMAGE_LIST_LANG_VW a,ca_section_image_link b where a.image_ref=b.image_ref  and language_id = ? and b.sec_hdg_code=?";
						con				=	ConnectionManager.getConnection(request);
						
						stmt = con.prepareStatement(sql);
						stmt.setString(1,locale);

						if(sec_hdg_code.equals(curr_child_sec_hdg_code))
							stmt.setString(2,sec_hdg_code);
						else
							stmt.setString(2,curr_child_sec_hdg_code);

						rs = stmt.executeQuery();
						
						while(rs.next())
						{
							String patImageHeight = "400";  //IN053298
							image_url = rs.getString("image_url");
							image_ref_desc = rs.getString("image_ref_desc");
							default_yn	=	rs.getString("default_yn");
							image_ref	=	rs.getString("image_ref");

							if(default_yn.equals("Y"))
							{
								
								default_yn_sel = "selected";
								default_avl ="Y";
								default_image_url = image_url;
								
							}
							else
								default_yn_sel	=	"";
							
							out.println("<option id='"+image_ref+"' value='" + image_url + "' " + default_yn_sel + " >" + image_ref_desc + "</option>");
							//IN053298 Start.
							//8188 Start.
							//File file = new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + image_url);
							File file = new File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + image_url);
							//8188 End.
							if(file.exists()){								
								BufferedImage bimg = ImageIO.read(file);
								patImageHeight     = String.valueOf(bimg.getHeight());
							}else{
								byte[] byteArray=a_db(file,image_ref);
								if(byteArray.length>0){	
									BufferedImage bimg = ImageIO.read(file);
									patImageHeight     = String.valueOf(bimg.getHeight());
								}else{
									//8188 Start.
									//BufferedImage bimg = ImageIO.read( new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/blank.gif" ));
									BufferedImage bimg = ImageIO.read( new File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/blank.gif" ));
									//8188 End.
									patImageHeight     = String.valueOf(bimg.getHeight());
								}
							}
			
							if(file !=null)
								file=null;
							
							if((Integer.parseInt(patImageHeight))>(Integer.parseInt(tempImageHeight)))
								tempImageHeight = patImageHeight;
							//IN053298 End.
						}
					
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						//out.println("Exception@MedPntrEdit: "+e.toString());//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}
					finally
					{
						if(con!=null)	ConnectionManager.returnConnection(con,request);
					}
					//IN053298 Start.
					if(section_image_content.equals("") ){
						if(image_view_counter.equals("")){						
							if(!default_image_url.equals("")){
								try{
								//8188 Start.
								//BufferedImage bimg = ImageIO.read(new File(request.getSession().getServletContext().getRealPath("/")+"eCA/MediPainter/images/"+default_image_url));	
								BufferedImage bimg = ImageIO.read(new File(request.getSession().getServletContext().getRealPath("/")+"/eCA/MediPainter/images/"+default_image_url));															
								//8188 End.
								imageHeight         = String.valueOf(bimg.getHeight());
								}catch(Exception ex)
								{
									//out.println("Exception@MedPntrEdit1: "+ex.toString());//COMMON-ICN-0181
                                                                           ex.printStackTrace();//COMMON-ICN-0181
								}
							}
						}
					}else{
						imageHeight = (String)sectionBean.getSectionImageHeight(curr_sec_hdg_code,curr_child_sec_hdg_code);						
					}
					
					
					if((Integer.parseInt(tempImageHeight))>(Integer.parseInt(imageHeight)))
								imageHeight = tempImageHeight;
					//IN053298 End.
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(imageHeight));
            _bw.write(_wl_block13Bytes, _wl_block13);

									if(section_image_content.equals("") )
									{ 
										
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((image_view_counter.equals("")?(default_image_url.equals("")?"":"../MediPainter/images/"+default_image_url):"")));
            _bw.write(_wl_block15Bytes, _wl_block15);

									}
									else
									{
										contentAvailable = "Y";//IN034119
										
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(section_image_content));
            _bw.write(_wl_block17Bytes, _wl_block17);

									}

						
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(default_avl));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(contentAvailable));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AvailableImages.label", java.lang.String .class,"key"));
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
}
