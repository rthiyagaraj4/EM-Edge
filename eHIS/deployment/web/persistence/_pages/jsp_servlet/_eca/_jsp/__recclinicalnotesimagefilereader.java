package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.net.*;
import java.sql.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import java.io.*;
import org.apache.commons.codec.binary.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesimagefilereader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesImageFileReader.jsp", 1741152730094L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<html>\n<body onLoad=\"clearImg();Paint()\" class = \"MESSAGE\" OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<form name = \"imageValueFrm\"  id = \"imageValueFrm\">\n\n<textarea name = \"imageValue\"  id = \"imageValue\"  style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</textarea>\n<textarea name = \"blankimageValue\" style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</textarea>\n</form>\n<script>\n\tfunction clearImg()\n\t{\n\t\tif(document.imageValueFrm.imageValue.value != \'null\')\n\t\t{\n\t\t\t//IN038493 Start.\n\n\t\t\t//parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\tif(null!=parent.workAreaFrame.RecClinicalNotesFrame && null!=parent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame)\n\t\t\t{\n\t\t\t\tparent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\t\n\t\t\t\t//parent.workAreaFrame.RecClinicalNotesFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\t\tif(null!=parent.workAreaFrame.RecClinicalNotesSecDetailsFrame)\n\t\t\t\t\tparent.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\t\telse if(null!=parent.workAreaFrame.document.applets[\"drawing\"])\n\t\t\t\t\tparent.workAreaFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\t\t//IN038493 End.\n\t\t\t}\n\t\t}\n\t\t\n\t}\n\tfunction Paint() \n\t{\n\t\tif(document.imageValueFrm.imageValue.value != \'null\')\n\t\t{\n\t\t\t//IN038493 Strat\t\n\n\t\t\tif(null!=parent.workAreaFrame.RecClinicalNotesFrame){\n\t\t\t\tparent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.imageValue.value);\n\t\t\t\n\t\t\t}else{\n\t\t\t\tif(null!=parent.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame)\n\t\t\t\t\tparent.workAreaFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.imageValue.value);\t\t\t\t\n\t\t\t\telse\n\t\t\t\t\tparent.workAreaFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.imageValue.value);\t\t\t\t\n\t\t\t}\n\t\t\t//IN038493 End.\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\t//IN038493 Strat\t\n\n\t\t\tif(null!=parent.workAreaFrame.RecClinicalNotesFrame){\n\t\t\t\tparent.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\t\n\t\t\t}else{\n\t\t\t\tif(null!=parent.workAreaFrame.RecClinicalNotesMediPainterFrame)\n\t\t\t\t\tparent.workAreaFrame.RecClinicalNotesMediPainterFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\t\telse\n\t\t\t\t\tparent.workAreaFrame.document.applets[\"drawing\"].SetImage(document.imageValueFrm.blankimageValue.value);\n\t\t\t}\n\t\t\t//IN038493 End.\n\t\t}\n\t}\n</script>\n</body></html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

	public static byte[] a(FileInputStream inputstream)	throws IOException
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		int i;
		while((i = inputstream.read()) != -1) 
			bytearrayoutputstream.write(i);
		inputstream.close();
		return bytearrayoutputstream.toByteArray();
	}

	public static byte[] a(InputStream inputstream)	throws IOException
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		int i;
		while((i = inputstream.read()) != -1) 
			bytearrayoutputstream.write(i);
		inputstream.close();
		return bytearrayoutputstream.toByteArray();
	}
	/***a_db() is called when the file does not exit in the image folder. Here we get the blob data from the database and display. We also create a copy in the image folder****/
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
			/****** read from database and display *******start****/
		
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
					long len = img_blob.length();
					ins = img_blob.getBinaryStream();				
					int i;
					while((i = ins.read()) != -1) 
						bytearrayoutputstream.write(i);
					if (ins != null) ins.close();
							
				
				/****** read from database and display*******end****/
				/****** create a copy in the image folder*******start****/
				boolean fcre=false;
				fcre = file.createNewFile();
				if(fcre)
				{
					FileOutputStream fileoutput = new FileOutputStream(file);
					fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
					if (fileoutput != null)  fileoutput.close();			
				}
			}
			}
			if(bytearrayoutputstream.size()>0){
				by=new byte[bytearrayoutputstream.size()];
				by=bytearrayoutputstream.toByteArray();
			}else{
				by=new byte[0];
			}


			/****** create a copy in the image folder*******end****/
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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?       		created
15/03/2013		IN038493	NijithaS			CRF-CA- CHL-CRF-0011/04- Social History Widget->While Modifying a image Linked Section we get script error		 
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
06/04/2017	IN063939		Raja S				06/04/2016		Ramesh G		ML-MMOH-SCF-0700
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 //, com.medicom.tool.Base64
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String image = request.getParameter("image");
		String image_ref = request.getParameter("image_ref");
		String patimage = null ;
		String patBlankImage = null ;
//		URLConnection urlconnection = null;
		try
		{

			/*			URL url1 = new 	URL("file:///"+config.getServletContext().getRealPath("/")+"eCA\\MediPainter\\images\\blank.gif");
			patBlankImage = Base64.encode(a(url1.openConnection().getInputStream()));
			*/
			//FileInputStream fisBlkImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/blank.gif" );//commented for IN063939
			FileInputStream fisBlkImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/blank.gif" );//Modified for IN063939
			System.out.println("fisBlkImgFile"+fisBlkImgFile);

			//patBlankImage = Base64.encode(a(fisBlkImgFile));
			patBlankImage = new String((new Base64()).encode(a(fisBlkImgFile)));
		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
		}
		try
		{
			//URL url = new URL("file:///"+config.getServletContext().getRealPath("/")+"eCA\\MediPainter\\images\\" + image);	

//			urlconnection = url.openConnection();
			
//			File flImageFile = new File(config.getServletContext().getRealPath("/")+"eCA\\MediPainter\\images\\" + image);

			//File file = new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + image);//commented for IN063939
			File file = new File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + image);//Modified for IN063939
			
			//**FileInputStream fisImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + image);
			if(file.exists()){
				FileInputStream fisImgFile = new FileInputStream(file);
				//patimage = Base64.encode(a(fisImgFile));
				patimage = new String((new Base64()).encode(a(fisImgFile)));
			}else{
				byte[] byteArray=a_db(file,image_ref);
				if(byteArray.length>0){
					//patimage = Base64.encode(byteArray);
					patimage = new String((new Base64()).encode(byteArray));
				}else{
					out.println("<script>alert(getMessage('IMAGE_NOT_FOUND_INLIB','CA'));</script>");
					//FileInputStream fisImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/blank.gif" );//Commented for IN063939
					FileInputStream fisImgFile = new FileInputStream(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/blank.gif" );//Modified for IN063939
					//patimage = Base64.encode(a(fisImgFile));
					patimage = new String((new Base64()).encode(a(fisImgFile)));
				}
			}
			
//			patimage = Base64.encode(a(urlconnection.getInputStream()));
			if(file !=null)
				file=null;
		}
		catch(FileNotFoundException e)
		{
			out.println("CA-9901 The selected image is not available in Application Library. Please Contact Application Admin.");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			out.println("CA-9902 A fatal error has occured while loading the image into the editor. <BR>Please contact the Administrator..");
			e.printStackTrace();
		}		

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patimage));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patBlankImage));
            _bw.write(_wl_block9Bytes, _wl_block9);
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
