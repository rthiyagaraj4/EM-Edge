
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.net.*;
import java.util.*;

public class LineGraphApplet extends Applet
    implements MouseMotionListener, MouseListener
{
	boolean started;
    int pixs[];
    int index;
    int i;
    int j;
    String sTemp;
    String sTemp2;
    StringTokenizer st;
    private Vector parameters;
    int WIDTH;
    int HEIGHT;
    Color SBGCOLOR;
    Color linecolor[];
    Color Titlecolor[];
    Color baroutline;
    Color axiscolor;
    Color floorcolor;
    Color gridColor;
    Color Ycolor;
    Color labelcolor;
    Color Textcolor[];
    Font TestFont;
    Font Yfont;
    Font labelfont;
    Font Titlefont[];
    Font Textfont[];
    int Titlexy[][];
    int ImageXY[][];
    int TextXY[][];
    int labelOrientation;
    int PointStyle[][];
    int labelsoffset[];
    boolean outline;
    boolean valuenull[][];
    boolean PointFill[];
    double value[][];
    double chartScale;
    double chartStartY;
    String message;
    String labels[];
    String Text[];
    String legendlabels[];
    String legendtitle;
    Image Images[];
    boolean BoolArray[];
    int IntArray[];
    String StringArray[];
    int PosArray[][];
    Font FontArray[];
    Color ColorArray[];
    Color ttcolor[];
    int ttint[][];
    double ttval[][];
    String ttlabel[];
    Font ttfont[];
    boolean displayValue[][];
    String PointURL[][][];
    int PointArea[][][];
    public Image buffer;
    Graphics pad;

    public static boolean verifybool(String s, String s1)
    {
        boolean flag = false;
        if(s == null || s.length() < 1)
            s = s1;
        s = s.toLowerCase().substring(0, 1);
        if(s.equals("t"))
            flag = true;
        return flag;
    }

    public void mouseDragged(MouseEvent mouseevent)
    {
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
    }

    public void mousePressed(MouseEvent mouseevent)
    {
        int k = mouseevent.getX();
        int l = mouseevent.getY();
        if(started)
        {
            for(int i1 = 0; i1 < IntArray[0]; i1++)
            {
                for(int j1 = 0; j1 < IntArray[3]; j1++)
                    if(!valuenull[i1][j1] && k > PointArea[i1][j1][0] && k < PointArea[i1][j1][1] && l > PointArea[i1][j1][3] && l < PointArea[i1][j1][2] && (PointURL[i1][j1][0] != null && !PointURL[i1][j1][0].equals("")))
                        if(PointURL[i1][j1][1].equals("javascript"))
                            try
                            {
                                JSObject.getWindow(this).eval(PointURL[i1][j1][0]);
                            }
                            catch(Throwable _ex)
                            {
                                try
                                {
                                    URL url = new URL(getDocumentBase(), "javascript:" + PointURL[i1][j1][0]);
                                    getAppletContext().showDocument(url);
                                }
                                catch(MalformedURLException malformedurlexception)
                                {
                                    malformedurlexception.printStackTrace();
                                }
                            }
                        else
                            try
                            {
                                URL url1 = new URL(getDocumentBase(), PointURL[i1][j1][0]);
                                getAppletContext().showDocument(url1, PointURL[i1][j1][1]);
                            }
                            catch(MalformedURLException malformedurlexception1)
                            {
                                malformedurlexception1.printStackTrace();
                            }

            }

        }
        paint(getGraphics());
    }

    public final void paint(Graphics g)
    {
        if(!started)
            startUp(g);
        buffer = createImage(WIDTH, HEIGHT);
        pad = buffer.getGraphics();
        linechart.linechart(buffer, value, valuenull, displayValue, labels, labelsoffset, ImageXY, Images, chartStartY, chartScale, linecolor, PointStyle, PointFill, BoolArray, IntArray, StringArray, PosArray, FontArray, ColorArray, legendlabels, ttcolor, ttint, ttval, ttlabel, ttfont);
        g.drawImage(buffer, 0, 0, this);
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
        int k = mouseevent.getX();
        int l = mouseevent.getY();
        if(started)
        {
            for(int i1 = 0; i1 < IntArray[0]; i1++)
            {
                for(int j1 = 0; j1 < IntArray[3]; j1++)
                    if(!valuenull[i1][j1])
                        if(k > PointArea[i1][j1][0] && k < PointArea[i1][j1][1] && l > PointArea[i1][j1][3] && l < PointArea[i1][j1][2])
                            displayValue[i1][j1] = true;
                        else
                            displayValue[i1][j1] = false;

            }

        }
        paint(getGraphics());
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    }

    public void startUp(Graphics g)
    {
        String s = verifystr(getParameter("LOADINGMESSAGE"), "Loading Please Wait...");
        FontMetrics fontmetrics = getFontMetrics(g.getFont());
        g.setColor(verifyclr(getParameter("STEXTCOLOR"), "0,0,0", ","));
        g.drawString(s, (size().width - fontmetrics.stringWidth(s)) / 2, (size().height + fontmetrics.getHeight()) / 2);
        WIDTH = getSize().width;
        HEIGHT = getSize().height;
        BoolArray = new boolean[6];
        IntArray = new int[12];
        StringArray = new String[14];
        PosArray = new int[14][2];
        FontArray = new Font[16];
        ColorArray = new Color[23];
        ttcolor = new Color[20];
        ttint = new int[20][3];
        ttval = new double[20][2];
        ttlabel = new String[20];
        ttfont = new Font[20];
        for(i = 0; i < 14; i++)
            StringArray[i] = "";

        for(i = 0; i < 16; i++)
            FontArray[i] = new Font("Courier", 0, 10);

        for(i = 0; i < 23; i++)
            ColorArray[i] = new Color(0, 0, 0);

        for(i = 0; i < 12; i++)
            IntArray[i] = 0;

        for(i = 0; i < 20; i++)
        {
            ttcolor[i] = new Color(0, 0, 0);
            ttint[i][0] = 0;
            ttint[i][1] = 0;
            ttint[i][2] = 0;
            ttval[i][0] = 0.0D;
            ttval[i][1] = 0.0D;
            ttlabel[i] = " ";
            ttfont[i] = new Font("Arial", 0, 10);
        }

        sTemp = getParameter("chartproperties");
        if(sTemp != "" && sTemp != null)
            get_chartpropsfromfile(sTemp);
        else
            get_chartprops();
        sTemp = getParameter("chartdata");
        if(sTemp != "" && sTemp != null)
            get_chartdatafromfile(sTemp);
        else
            get_chartdata();
        displayValue = new boolean[IntArray[0]][IntArray[3]];
        PointArea = new int[IntArray[0]][IntArray[3]][4];
        CalcArea(IntArray[0], IntArray[3], IntArray[2], IntArray[4], IntArray[6], IntArray[5], chartScale, chartStartY);
        started = true;
    }

    private void get_chartprops()
    {
        BoolArray[0] = verifybool(getParameter("3D"), "false");
        BoolArray[1] = verifybool(getParameter("grid"), "false");
        BoolArray[2] = verifybool(getParameter("axis"), "false");
        BoolArray[3] = verifybool(getParameter("ylabels"), "false");
        BoolArray[4] = verifybool(getParameter("outline"), "false");
        BoolArray[5] = verifybool(getParameter("legend"), "false");
        IntArray[0] = verifyint(getParameter("nPoints"));
        IntArray[1] = verifyint(getParameter("nRows"));
        IntArray[2] = verifyint(getParameter("vSpace"));
        IntArray[3] = verifyint(getParameter("nSeries"));
        IntArray[4] = verifyint(getParameter("hSpace"));
        IntArray[5] = verifyint(getParameter("gridxpos"));
        IntArray[6] = verifyint(getParameter("gridypos"));
        IntArray[7] = verifyint(getParameter("depth3D"));
        IntArray[8] = verifyint(getParameter("ndecplaces"));
        IntArray[9] = verifyint(getParameter("labelOrientation"));
        IntArray[10] = verifyint(getParameter("labelsY"));
        IntArray[11] = verifyint(getParameter("gridstyle"));
        chartScale = verifydbl(getParameter("chartScale"));
        chartStartY = verifydbl(getParameter("chartStartY"));
        for(i = 13; i < 15; i++)
            FontArray[i] = verifyfnt(getParameter("font" + (i + 1)), "Courier,N,12", ",");

        for(i = 13; i < 19; i++)
            ColorArray[i] = verifyclr(getParameter("color" + (i + 1)), "255,255,255", ",");

        ColorArray[19] = SBGCOLOR;
        ColorArray[20] = verifyclr(getParameter("LegendBackground"), "255,255,255", ",");
        ColorArray[21] = verifyclr(getParameter("LegendBorder"), "255,255,255", ",");
        ColorArray[22] = verifyclr(getParameter("LegendtextColor"), "0,0,0", ",");
        labels = new String[IntArray[0]];
        labelsoffset = new int[IntArray[0]];
        for(i = 0; i < IntArray[0]; i++)
        {
            labels[i] = "";
            labelsoffset[i] = 0;
            sTemp = getParameter("label" + (i + 1));
            if((sTemp != "") & (sTemp != null))
            {
                st = new StringTokenizer(sTemp, "|");
                if(st.hasMoreTokens())
                    labels[i] = verifystr(st.nextToken(), "");
                else
                    labels[i] = "";
                if(st.hasMoreTokens())
                    labelsoffset[i] = verifyint(st.nextToken());
                else
                    labelsoffset[i] = 0;
            }
        }

        for(i = 0; i < 13; i++)
        {
            if(i < 10)
                sTemp = getParameter("text" + (i + 1));
            if(i == 10)
                sTemp = getParameter("title");
            if(i == 11)
                sTemp = getParameter("xtitle");
            if(i == 12)
                sTemp = getParameter("ytitle");
            if((sTemp != "") & (sTemp != null))
            {
                st = new StringTokenizer(sTemp, "|");
                if(st.hasMoreTokens())
                    StringArray[i] = st.nextToken();
                else
                    StringArray[i] = "";
                if(st.hasMoreTokens())
                {
                    sTemp2 = st.nextToken();
                    PosArray[i][0] = verifypos(sTemp2, 0, ",");
                    PosArray[i][1] = verifypos(sTemp2, 1, ",");
                }
                if(st.hasMoreTokens())
                    FontArray[i] = verifyfnt(st.nextToken(), "Courier,N,10", ",");
                if(st.hasMoreTokens())
                    ColorArray[i] = verifyclr(st.nextToken(), "0,0,0", ",");
            }
        }

        StringArray[13] = getParameter("legendtitle");
        PosArray[13][0] = verifypos(getParameter("legendposition"), 0, ",");
        PosArray[13][1] = verifypos(getParameter("legendposition"), 1, ",");
        FontArray[15] = verifyfnt(getParameter("legendfont"), "Courier,N,10", ",");
        Images = new Image[10];
        ImageXY = new int[10][2];
        for(i = 0; i < 10; i++)
        {
            sTemp = getParameter("image" + (i + 1));
            if((sTemp != "") & (sTemp != null))
            {
                st = new StringTokenizer(sTemp, ",");
                if(st.hasMoreTokens())
                    Images[i] = downloadImage(st.nextToken());
                if(st.hasMoreTokens())
                    ImageXY[i][0] = Integer.parseInt(st.nextToken());
                else
                    ImageXY[i][0] = 0;
                if(st.hasMoreTokens())
                    ImageXY[i][1] = Integer.parseInt(st.nextToken());
                else
                    ImageXY[i][1] = 0;
            }
        }

        for(i = 0; i < 10; i++)
        {
            sTemp = getParameter("trend" + (i + 1));
            if((sTemp != "") & (sTemp != null))
            {
                st = new StringTokenizer(sTemp, "|");
                if(st.hasMoreTokens())
                    ttcolor[i] = verifyclr(st.nextToken(), "0,0,0", ",");
                if(st.hasMoreTokens())
                    ttint[i][1] = verifyint(st.nextToken());
                if(st.hasMoreTokens())
                    ttint[i][2] = verifyint(st.nextToken());
                if(st.hasMoreTokens())
                    ttval[i][0] = verifydbl(st.nextToken());
                if(st.hasMoreTokens())
                    ttval[i][1] = verifydbl(st.nextToken());
                if(st.hasMoreTokens())
                    ttlabel[i] = st.nextToken();
                if(st.hasMoreTokens())
                    ttfont[i] = verifyfnt(st.nextToken(), "Arial,N,10", ",");
            }
        }

        for(i = 10; i < 20; i++)
        {
            sTemp = getParameter("target" + (i - 9));
            if((sTemp != "") & (sTemp != null))
            {
                st = new StringTokenizer(sTemp, "|");
                if(st.hasMoreTokens())
                    ttcolor[i] = verifyclr(st.nextToken(), "0,0,0", ",");
                if(st.hasMoreTokens())
                    ttint[i][0] = verifyint(st.nextToken());
                if(st.hasMoreTokens())
                    ttint[i][1] = verifyint(st.nextToken());
                if(st.hasMoreTokens())
                    ttint[i][2] = verifyint(st.nextToken());
                if(st.hasMoreTokens())
                    ttval[i][0] = verifydbl(st.nextToken());
                if(st.hasMoreTokens())
                    ttlabel[i] = st.nextToken();
                if(st.hasMoreTokens())
                    ttfont[i] = verifyfnt(st.nextToken(), "Arial,N,10", ",");
            }
        }

        PointStyle = new int[IntArray[3]][2];
        PointFill = new boolean[IntArray[3]];
        linecolor = new Color[IntArray[3]];
        legendlabels = new String[IntArray[3]];
        Color color = new Color(125, 125, 125);
        for(j = 0; j < IntArray[3]; j++)
        {
            sTemp = getParameter("series" + (j + 1));
            if(sTemp != null)
            {
                st = new StringTokenizer(sTemp, "|");
                if(st.hasMoreTokens())
                    color = verifyclr(st.nextToken(), "125,125,125", ",");
                if(st.hasMoreTokens())
                    PointStyle[j][0] = Integer.parseInt(st.nextToken());
                else
                    PointStyle[j][0] = 0;
                if(st.hasMoreTokens())
                    PointStyle[j][1] = Integer.parseInt(st.nextToken());
                else
                    PointStyle[j][1] = 0;
                if(st.hasMoreTokens())
                    PointFill[j] = verifybool(st.nextToken(), "false");
                else
                    PointFill[j] = false;
                if(st.hasMoreTokens())
                    legendlabels[j] = verifystr(st.nextToken(), "");
                linecolor[j] = color;
            } else
            {
                PointStyle[j][0] = 0;
                PointStyle[j][1] = 0;
                PointFill[j] = false;
                linecolor[j] = new Color(0, 0, 0);
                legendlabels[j] = "";
            }
        }

    }

    public LineGraphApplet()
    {
        started = false;
        index = 0;
    }

    public static String verifystr(String s, String s1)
    {
        String s2 = " ";
        if(s == null || s.equals(""))
            s2 = s1;
        else
            s2 = s;
        return s2;
    }

    private void get_chartdata()
    {
        value = new double[IntArray[0]][IntArray[3]];
        valuenull = new boolean[IntArray[0]][IntArray[3]];
        PointURL = new String[IntArray[0]][IntArray[3]][2];
        for(j = 0; j < IntArray[3]; j++)
            for(i = 0; i < IntArray[0]; i++)
            {
                value[i][j] = 0.0D;
                valuenull[i][j] = true;
                PointURL[i][j][0] = " ";
                PointURL[i][j][1] = "_self";
            }


        for(j = 0; j < IntArray[3]; j++)
            for(i = 0; i < IntArray[0]; i++)
            {
                sTemp = getParameter("data" + (i + 1) + "series" + (j + 1));
                if((sTemp != "") & (sTemp != null))
                {
                    st = new StringTokenizer(sTemp, ",");
                    if(st.hasMoreTokens())
                    {
                        value[i][j] = Double.valueOf(st.nextToken()).floatValue();
                        valuenull[i][j] = false;
                    }
                    if(st.hasMoreTokens())
                        PointURL[i][j][0] = st.nextToken();
                    if(st.hasMoreTokens())
                        PointURL[i][j][1] = st.nextToken();
                }
            }


    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }

    public void CalcArea(int k, int l, int i1, int j1, int k1, int l1, double d, double d1)
    {
        double d2 = (new Double(i1)).doubleValue();
        for(int k2 = 0; k2 < k; k2++)
        {
            for(int l2 = 0; l2 < l; l2++)
            {
                PointArea[k2][l2][0] = -1;
                PointArea[k2][l2][1] = -1;
                PointArea[k2][l2][2] = -1;
                PointArea[k2][l2][3] = -1;
                if(!valuenull[k2][l2])
                {
                    int j2 = k1 - (int)Math.round((d2 * (value[k2][l2] - d1)) / d);
                    int i2 = l1 + k2 * j1 + j1 / 2;
                    PointArea[k2][l2][0] = i2 - PointStyle[l2][1] / 2;
                    PointArea[k2][l2][1] = (i2 + PointStyle[l2][1]) - PointStyle[l2][1] / 2;
                    PointArea[k2][l2][2] = (j2 + PointStyle[l2][1]) - PointStyle[l2][1] / 2;
                    PointArea[k2][l2][3] = j2 - PointStyle[l2][1] / 2;
                    displayValue[k2][l2] = false;
                }
            }

        }

    }

    public static Color verifyclr(String s, String s1, String s2)
    {
        int k = 0;
        int l = 0;
        int i1 = 0;
        if(s == null || s.equals(""))
            s = s1;
        String s3;
        try
        {
            s3 = s.trim();
        }
        catch(Exception _ex)
        {
            s3 = "0|0|0";
        }
        String s4 = verifystr(s3, s1);
        StringTokenizer stringtokenizer = new StringTokenizer(s4, s2);
        Color color;
        try
        {
            if(stringtokenizer.hasMoreTokens())
                k = Math.abs(Integer.parseInt(stringtokenizer.nextToken()));
            if(stringtokenizer.hasMoreTokens())
                l = Math.abs(Integer.parseInt(stringtokenizer.nextToken()));
            if(stringtokenizer.hasMoreTokens())
                i1 = Math.abs(Integer.parseInt(stringtokenizer.nextToken()));
            color = new Color(k, l, i1);
        }
        catch(Exception _ex)
        {
            color = new Color(0, 0, 0);
        }
        return color;
    }

    public Image downloadImage(String s)
    {
        MediaTracker mediatracker = new MediaTracker(this);
        Image image = getImage(getCodeBase(), s);
        mediatracker.addImage(image, 0);
        try
        {
            showStatus("Loading Image...");
            mediatracker.waitForID(0);
            showStatus("");
        }
        catch(InterruptedException _ex)
        {
            return createImage(size().width, size().height);
        }
        int k = image.getWidth(this);
        int l = image.getHeight(this);
        pixs = new int[k * l];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, k, l, pixs, 0, k);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex)
        {
            System.err.println("interrupted waiting for pixels!");
            showStatus("Image loading error");
            return createImage(size().width, size().height);
        }
        if((pixelgrabber.status() & 0x80) != 0)
        {
            System.err.println("image fetch aborted or errored");
            showStatus("Image loading error");
            return createImage(size().width, size().height);
        } else
        {
            Image image1 = createImage(new MemoryImageSource(k, l, pixs, 0, k));
            index = 0;
            return image1;
        }
    }

    public void init()
    {
        //new Evaluation(this, "2D / 3D Line Graph, version 3.2 - by Jpowered.", "http://www.jpowered.com/line_graph/index.htm");
        addMouseMotionListener(this);
        addMouseListener(this);
        sTemp = getParameter("STARTUPCOLOR");
        SBGCOLOR = verifyclr(sTemp, "255,255,255", ",");
        setBackground(SBGCOLOR);
    }

    public static int verifyint(String s)
    {
        String s1 = "0";
        try
        {
            s1 = s.trim();
        }
        catch(Exception _ex)
        {
            s1 = "0";
        }
        int k;
        try
        {
            k = Integer.parseInt(s1);
        }
        catch(Exception _ex)
        {
            k = 0;
        }
        return k;
    }

    public static Font verifyfnt(String s, String s1, String s2)
    {
        String s3 = "Courier";
        String s4 = "N";
        int k = 12;
        String s5;
        try
        {
            s5 = s.trim();
        }
        catch(Exception _ex)
        {
            s5 = "Courier|N|10";
        }
        String s6 = verifystr(s5, s1);
        StringTokenizer stringtokenizer = new StringTokenizer(s6, s2);
        Font font;
        try
        {
            if(stringtokenizer.hasMoreTokens())
                s3 = stringtokenizer.nextToken();
            if(stringtokenizer.hasMoreTokens())
                s4 = stringtokenizer.nextToken().toUpperCase();
            if(stringtokenizer.hasMoreTokens())
                k = Integer.parseInt(stringtokenizer.nextToken());
            if(s4.equals("B"))
                font = new Font(s3, 1, k);
            else
            if(s4.equals("I"))
                font = new Font(s3, 2, k);
            else
            if(s4.equals("BI") || s4.equals("IB"))
                font = new Font(s3, 3, k);
            else
                font = new Font(s3, 0, k);
        }
        catch(Exception _ex)
        {
            font = new Font("Courier", 0, 12);
        }
        return font;
    }

    public static double verifydbl(String s)
    {
        String s1 = "0.0";
        try
        {
            s1 = s.trim();
        }
        catch(Exception _ex)
        {
            s1 = "0.0";
        }
        double d;
        try
        {
            d = Double.valueOf(s1).floatValue();
        }
        catch(Exception _ex)
        {
            d = 0.0D;
        }
        return d;
    }

    public static int verifypos(String s, int k, String s1)
    {
        int l = 0;
        String s2;
        try
        {
            s2 = s.trim();
        }
        catch(Exception _ex)
        {
            s2 = "0,0";
        }
        StringTokenizer stringtokenizer = new StringTokenizer(s2, s1);
        try
        {
            if(stringtokenizer.hasMoreTokens())
                l = Math.abs(Integer.parseInt(stringtokenizer.nextToken()));
            if(k > 0 && stringtokenizer.hasMoreTokens())
                l = Math.abs(Integer.parseInt(stringtokenizer.nextToken()));
        }
        catch(Exception _ex)
        {
            l = 0;
        }
        return l;
    }

    private void get_chartpropsfromfile(String s)
    {
        URL url = null;
        try
        {
            url = new URL(getCodeBase(), s);
        }
        catch(MalformedURLException _ex)
        {
            System.out.println("Bad URL for File Location : " + s);
        }
        //Object obj = null;
       // Object obj1 = null;
        parameters = new Vector();
        try
        {
            URLConnection urlconnection = url.openConnection();
            urlconnection.connect();
            DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(urlconnection.getInputStream()));
            while((sTemp = datainputstream.readLine()) != null) 
                parameters.addElement(sTemp);
            for(Enumeration enumeration = parameters.elements(); enumeration.hasMoreElements();)
            {
                sTemp = (String)enumeration.nextElement();
                if(!sTemp.startsWith("<!-"))
                {
                    String s1 = " ";
                    String s3 = " ";
                    if(sTemp.length() > 20)
                    {
                        s1 = sTemp.substring(0, 19).trim();
                        s3 = sTemp.substring(20).trim();
                    }
                    if(s1.equals("3D"))
                        BoolArray[0] = verifybool(s3, "false");
                    if(s1.equals("grid"))
                        BoolArray[1] = verifybool(s3, "false");
                    if(s1.equals("axis"))
                        BoolArray[2] = verifybool(s3, "false");
                    if(s1.equals("ylabels"))
                        BoolArray[3] = verifybool(s3, "false");
                    if(s1.equals("outline"))
                        BoolArray[4] = verifybool(s3, "false");
                    if(s1.equals("legend"))
                        BoolArray[5] = verifybool(s3, "false");
                    if(s1.equals("nPoints"))
                        IntArray[0] = verifyint(s3);
                    if(s1.equals("nRows"))
                        IntArray[1] = verifyint(s3);
                    if(s1.equals("vSpace"))
                        IntArray[2] = verifyint(s3);
                    if(s1.equals("nSeries"))
                        IntArray[3] = verifyint(s3);
                    if(s1.equals("hSpace"))
                        IntArray[4] = verifyint(s3);
                    if(s1.equals("gridxpos"))
                        IntArray[5] = verifyint(s3);
                    if(s1.equals("gridypos"))
                        IntArray[6] = verifyint(s3);
                    if(s1.equals("depth3D"))
                        IntArray[7] = verifyint(s3);
                    if(s1.equals("ndecplaces"))
                        IntArray[8] = verifyint(s3);
                    if(s1.equals("labelOrientation"))
                        IntArray[9] = verifyint(s3);
                    if(s1.equals("labelsY"))
                        IntArray[10] = verifyint(s3);
                    if(s1.equals("gridstyle"))
                        IntArray[11] = verifyint(s3);
                    if(s1.equals("chartScale"))
                        chartScale = verifydbl(s3);
                    if(s1.equals("chartStartY"))
                        chartStartY = verifydbl(s3);
                    if(s1.equals("font14"))
                        FontArray[13] = verifyfnt(s3, "Courier,N,12", ",");
                    if(s1.equals("font15"))
                        FontArray[14] = verifyfnt(s3, "Courier,N,12", ",");
                    if(s1.equals("color14"))
                        ColorArray[13] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("color15"))
                        ColorArray[14] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("color16"))
                        ColorArray[15] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("color17"))
                        ColorArray[16] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("color18"))
                        ColorArray[17] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("color19"))
                        ColorArray[18] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("LegendBackground"))
                        ColorArray[20] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("LegendBorder"))
                        ColorArray[21] = verifyclr(s3, "255,255,255", ",");
                    if(s1.equals("LegendtextColor"))
                        ColorArray[22] = verifyclr(s3, "0,0,0", ",");
                    ColorArray[19] = SBGCOLOR;
                    for(i = 0; i < 10; i++)
                        if(s1.equals("text" + (i + 1)) && s3 != "" && s3 != null)
                        {
                            st = new StringTokenizer(s3, "|");
                            if(st.hasMoreTokens())
                                StringArray[i] = st.nextToken();
                            else
                                StringArray[i] = "";
                            if(st.hasMoreTokens())
                            {
                                sTemp2 = st.nextToken();
                                PosArray[i][0] = verifypos(sTemp2, 0, ",");
                                PosArray[i][1] = verifypos(sTemp2, 1, ",");
                            }
                            if(st.hasMoreTokens())
                                FontArray[i] = verifyfnt(st.nextToken(), "Courier,N,10", ",");
                            if(st.hasMoreTokens())
                                ColorArray[i] = verifyclr(st.nextToken(), "0,0,0", ",");
                        }

                    if(s1.equals("title") && s3 != "" && s3 != null)
                    {
                        st = new StringTokenizer(s3, "|");
                        if(st.hasMoreTokens())
                            StringArray[10] = st.nextToken();
                        else
                            StringArray[10] = "";
                        if(st.hasMoreTokens())
                        {
                            sTemp2 = st.nextToken();
                            PosArray[10][0] = verifypos(sTemp2, 0, ",");
                            PosArray[10][1] = verifypos(sTemp2, 1, ",");
                        }
                        if(st.hasMoreTokens())
                            FontArray[10] = verifyfnt(st.nextToken(), "Courier,N,10", ",");
                        if(st.hasMoreTokens())
                            ColorArray[10] = verifyclr(st.nextToken(), "0,0,0", ",");
                    }
                    if(s1.equals("xtitle") && s3 != "" && s3 != null)
                    {
                        st = new StringTokenizer(s3, "|");
                        if(st.hasMoreTokens())
                            StringArray[11] = st.nextToken();
                        else
                            StringArray[11] = "";
                        if(st.hasMoreTokens())
                        {
                            sTemp2 = st.nextToken();
                            PosArray[11][0] = verifypos(sTemp2, 0, ",");
                            PosArray[11][1] = verifypos(sTemp2, 1, ",");
                        }
                        if(st.hasMoreTokens())
                            FontArray[11] = verifyfnt(st.nextToken(), "Courier,N,10", ",");
                        if(st.hasMoreTokens())
                            ColorArray[11] = verifyclr(st.nextToken(), "0,0,0", ",");
                    }
                    if(s1.equals("ytitle") && s3 != "" && s3 != null)
                    {
                        st = new StringTokenizer(s3, "|");
                        if(st.hasMoreTokens())
                            StringArray[12] = st.nextToken();
                        else
                            StringArray[12] = "";
                        if(st.hasMoreTokens())
                        {
                            sTemp2 = st.nextToken();
                            PosArray[12][0] = verifypos(sTemp2, 0, ",");
                            PosArray[12][1] = verifypos(sTemp2, 1, ",");
                        }
                        if(st.hasMoreTokens())
                            FontArray[12] = verifyfnt(st.nextToken(), "Courier,N,10", ",");
                        if(st.hasMoreTokens())
                            ColorArray[12] = verifyclr(st.nextToken(), "0,0,0", ",");
                    }
                    if(s1.equals("legendtitle"))
                        StringArray[13] = s3;
                    if(s1.equals("legendposition"))
                    {
                        PosArray[13][0] = verifypos(s3, 0, ",");
                        PosArray[13][1] = verifypos(s3, 1, ",");
                    }
                    if(s1.equals("legendfont"))
                        FontArray[15] = verifyfnt(s3, "Courier,N,10", ",");
                    Images = new Image[10];
                    ImageXY = new int[10][2];
                    for(i = 0; i < 10; i++)
                        if(s1.equals("image" + (i + 1)) && s3 != "" && s3 != null)
                        {
                            st = new StringTokenizer(s3, ",");
                            if(st.hasMoreTokens())
                                Images[i] = downloadImage(st.nextToken());
                            if(st.hasMoreTokens())
                                ImageXY[i][0] = Integer.parseInt(st.nextToken());
                            else
                                ImageXY[i][0] = 0;
                            if(st.hasMoreTokens())
                                ImageXY[i][1] = Integer.parseInt(st.nextToken());
                            else
                                ImageXY[i][1] = 0;
                        }

                    for(i = 0; i < 10; i++)
                        if(s1.equals("trend" + (i + 1)) && s3 != "" && s3 != null)
                        {
                            st = new StringTokenizer(s3, "|");
                            if(st.hasMoreTokens())
                                ttcolor[i] = verifyclr(st.nextToken(), "0,0,0", ",");
                            if(st.hasMoreTokens())
                                ttint[i][1] = verifyint(st.nextToken());
                            if(st.hasMoreTokens())
                                ttint[i][2] = verifyint(st.nextToken());
                            if(st.hasMoreTokens())
                                ttval[i][0] = verifydbl(st.nextToken());
                            if(st.hasMoreTokens())
                                ttval[i][1] = verifydbl(st.nextToken());
                            if(st.hasMoreTokens())
                                ttlabel[i] = st.nextToken();
                            if(st.hasMoreTokens())
                                ttfont[i] = verifyfnt(st.nextToken(), "Arial,N,10", ",");
                        }

                    for(i = 10; i < 20; i++)
                        if(s1.equals("target" + (i - 9)) && s3 != "" && s3 != null)
                        {
                            st = new StringTokenizer(s3, "|");
                            if(st.hasMoreTokens())
                                ttcolor[i] = verifyclr(st.nextToken(), "0,0,0", ",");
                            if(st.hasMoreTokens())
                                ttint[i][0] = verifyint(st.nextToken());
                            if(st.hasMoreTokens())
                                ttint[i][1] = verifyint(st.nextToken());
                            if(st.hasMoreTokens())
                                ttint[i][2] = verifyint(st.nextToken());
                            if(st.hasMoreTokens())
                                ttval[i][0] = verifydbl(st.nextToken());
                            if(st.hasMoreTokens())
                                ttlabel[i] = st.nextToken();
                            if(st.hasMoreTokens())
                                ttfont[i] = verifyfnt(st.nextToken(), "Arial,N,10", ",");
                        }

                }
            }

            labels = new String[IntArray[0]];
            labelsoffset = new int[IntArray[0]];
            PointStyle = new int[IntArray[3]][2];
            PointFill = new boolean[IntArray[3]];
            linecolor = new Color[IntArray[3]];
            legendlabels = new String[IntArray[3]];
            for(i = 0; i < IntArray[3]; i++)
            {
                PointStyle[i][0] = 0;
                PointStyle[i][1] = 0;
                PointFill[i] = false;
                linecolor[i] = new Color(0, 0, 0);
                legendlabels[i] = "";
            }

            for(i = 0; i < IntArray[0]; i++)
            {
                labels[i] = "";
                labelsoffset[i] = 0;
            }

            for(Enumeration enumeration1 = parameters.elements(); enumeration1.hasMoreElements();)
            {
                sTemp = (String)enumeration1.nextElement();
                if(!sTemp.startsWith("<!-"))
                {
                    String s2 = " ";
                    String s4 = " ";
                    if(sTemp.length() > 20)
                    {
                        s2 = sTemp.substring(0, 19).trim();
                        s4 = sTemp.substring(20).trim();
                    }
                    for(i = 0; i < IntArray[0]; i++)
                        if(s2.equals("label" + (i + 1)) && s4 != "" && s4 != null)
                        {
                            st = new StringTokenizer(s4, "|");
                            if(st.hasMoreTokens())
                                labels[i] = verifystr(st.nextToken(), "");
                            if(st.hasMoreTokens())
                                labelsoffset[i] = verifyint(st.nextToken());
                        }

                    for(i = 0; i < IntArray[0]; i++)
                        if(s2.equals("series" + (i + 1)) && s4 != "" && s4 != null)
                        {
                            st = new StringTokenizer(s4, "|");
                            Color color = new Color(125, 125, 125);
                            legendlabels[i] = "";
                            if(st.hasMoreTokens())
                                color = verifyclr(st.nextToken(), "125,125,125", ",");
                            if(st.hasMoreTokens())
                                PointStyle[i][0] = Integer.parseInt(st.nextToken());
                            else
                                PointStyle[i][0] = 0;
                            if(st.hasMoreTokens())
                                PointStyle[i][1] = Integer.parseInt(st.nextToken());
                            else
                                PointStyle[i][1] = 0;
                            if(st.hasMoreTokens())
                                PointFill[i] = verifybool(st.nextToken(), "false");
                            else
                                PointFill[i] = false;
                            if(st.hasMoreTokens())
                                legendlabels[i] = verifystr(st.nextToken(), "");
                            linecolor[i] = color;
                        }

                }
            }

        }
        catch(IOException ioexception)
        {
            System.out.println("IO Error:" + ioexception.getMessage());
        }
    }

    private void get_chartdatafromfile(String s)
    {
        URL url = null;
        try
        {
            url = new URL(getCodeBase(), s);
        }
        catch(MalformedURLException _ex)
        {
            System.out.println("Bad URL for File Location : " + s);
        }
        //Object obj = null;
        //Object obj1 = null;
        parameters = new Vector();
        value = new double[IntArray[0]][IntArray[3]];
        valuenull = new boolean[IntArray[0]][IntArray[3]];
        PointURL = new String[IntArray[0]][IntArray[3]][2];
        for(j = 0; j < IntArray[3]; j++)
            for(i = 0; i < IntArray[0]; i++)
            {
                value[i][j] = 0.0D;
                valuenull[i][j] = true;
                PointURL[i][j][0] = " ";
                PointURL[i][j][1] = "_self";
            }


        try
        {
            URLConnection urlconnection = url.openConnection();
            urlconnection.connect();
            DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(urlconnection.getInputStream()));
            while((sTemp = datainputstream.readLine()) != null) 
                parameters.addElement(sTemp);
            for(Enumeration enumeration = parameters.elements(); enumeration.hasMoreElements();)
            {
                sTemp = (String)enumeration.nextElement();
                if(!sTemp.startsWith("<!-"))
                {
                    String s1 = " ";
                    String s2 = " ";
                    if(sTemp.length() > 20)
                    {
                        s1 = sTemp.substring(0, 19).trim();
                        s2 = sTemp.substring(20).trim();
                    }
                    for(j = 0; j < IntArray[3]; j++)
                        for(i = 0; i < IntArray[0]; i++)
                            if(s1.equals("data" + (i + 1) + "series" + (j + 1)) && s2 != "" && s2 != null)
                            {
                                st = new StringTokenizer(s2, ",");
                                if(st.hasMoreTokens())
                                {
                                    value[i][j] = Double.valueOf(st.nextToken()).floatValue();
                                    valuenull[i][j] = false;
                                }
                                if(st.hasMoreTokens())
                                    PointURL[i][j][0] = st.nextToken();
                                if(st.hasMoreTokens())
                                    PointURL[i][j][1] = st.nextToken();
                            }


                }
            }

        }
        catch(IOException ioexception)
        {
            System.out.println("IO Error:" + ioexception.getMessage());
        }
    }

    
}