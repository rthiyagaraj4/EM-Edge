// Decompiled by DJ v3.0.0.63 Copyright 2002 Atanas Neshkov  Date: 8/6/2005 9:39:48 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Chart.java
//This File is saved on 18/10/2005.

import java.awt.*;
import java.awt.event.*;
import java.awt.image.FilteredImageSource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.Vector;

public class Chart extends Panel
    implements MouseMotionListener, MouseListener
{

    public Chart()
    {
        iNan = -0.00012540000000000001D;
        rq_vector = new Vector(10, 5);
        color1 = 0;
        decimal_format = new DecimalFormat("#0");
        bg_color = 0;
        line_color = 0xc0c0c0;
        min_val = 1.7976931348623157E+308D;
        bkImage_width = -1;
        bkImage_height = -1;
        chart_unit = 1.0D;
        _$3246 = 1.0D;
        col_count = 1;
        origine_x = 40;
        origine_y = 40;
        rq_iteretor = -1;
        col_position = -1;
        value_legend = null;
        mouse_X = -1;
        mouse_Y = -1;
        bullet_title_yn = true;
        cBg_align = 'M';
        min_max_yn = false;
        sMaxColor = 0xff2020;
        bMM = 0;
        unit = 1.0D;
        unit_legend = "";
        data_set = 0;
        chart_style = 0;
        value_style = 0;
        Legend = null;
        Legend_family = null;
        style_flag = false;
        _$3357 = -1;
        iVal = -1;
        def_font = null;
        title_font = null;
        legend_font = null;
        rotate_yn = true;
        draw_count = 0;
        chart_image1 = null;
        chart_graph1 = null;
        chart_image2 = null;
        chart_graph2 = null;
        addMouseMotionListener(this);
        addMouseListener(this);
        def_font = new Font("Dialog", 0, 10);
        title_font = new Font("Dialog", 1, 14);
        legend_font = new Font("Dialog", 1, 12);
    }

    public void setNan(double d)
    {
        iNan = d;
    }

    public void setOrigine(int i, int j)
    {
        origine_x = i;
        origine_y = j;
    }

    public void setOrigine(String s)
    {
        int i = 40;
        int j = 40;
        if(s != null)
        {
            int k = s.indexOf(",");
            if(k > 0)
            {
                i = Integer.parseInt(s.substring(0, k).trim());
                j = Integer.parseInt(s.substring(k + 1).trim());
            }
        }
        setOrigine(i, j);
    }

    public void setUnit(String s)
    {
        if(s == null || s.length() < 2)
        {
            unit = 1.0D;
            unit_legend = "";
        } else
        {
            int i = s.indexOf(':');
            if(i > -1)
                try
                {
                    unit = Double.valueOf(s.substring(0, i)).doubleValue();
                    unit_legend = s.substring(i + 1);
                }
                catch(Exception exception) { }
        }
    }

    public void setLg(int i)
    {
        legends = i;
    }

    public void setLnColor(int i)
    {
        line_color = i;
    }

    public void setBkColor(int i)
    {
        bg_color = i;
    }

    public void setRotate(boolean flag)
    {
        rotate_yn = flag;
    }

    public void setBulletTitle(boolean flag)
    {
        bullet_title_yn = flag;
    }

    public void setBkImage(Image image)
    {
        back_image = image;
    }

    public void setFont(String s, int i, int j)
    {
        def_font = new Font(s, i, j);
    }

    public void setFontT(String s, int i, int j)
    {
        title_font = new Font(s, i, j);
    }

    public void setFontL(String s, int i, int j)
    {
        legend_font = new Font(s, i, j);
    }

    public void setFont(String s, char c)
    {
        //Object obj = null;
        if(s != null)
        {
            int i = s.indexOf(",");
            int j = -1;
            int k = 0;
            if(i > 0)
            {
                String s1 = s.substring(0, i).trim();
                int l = i + 1;
                i = s.indexOf(",", l);
                if(i > 0)
                {
                    k = Integer.parseInt(s.substring(l, i).trim());
                    j = Integer.parseInt(s.substring(i + 1).trim());
                }
                if(j > -1)
                    switch(c)
                    {
                    case 76: // 'L'
                        legend_font = new Font(s1, k, j);
                        break;

                    case 84: // 'T'
                        title_font = new Font(s1, k, j);
                        break;

                    default:
                        def_font = new Font(s1, k, j);
                        break;
                    }
            }
        }
    }

    public Image getImage()
    {
        return chart_image;
    }

    public void clearData()
    {
        col_count = 1;
        legends = 1;
        max_val = 0.0D;
        item_value = 0.0D;
        _$3213 = 0.0D;
        _$3208 = 0.0D;
        data_set = 0;
        _$3357 = 0;
        iVal = -1;
        legend_y = 0;
        legend_rect = 0;
        unit = 1.0D;
        unit_legend = "";
        decimal_format = new DecimalFormat("#0");
        Title = new String("");
        rq_vector.removeAllElements();
        Legend = null;
        Legend_family = null;
        clearBuffer();
    }

    public void clearData2()
    {
        max_val = 0.0D;
        item_value = 0.0D;
        _$3213 = 0.0D;
        _$3208 = 0.0D;
        data_set = 0;
        iVal = -1;
        clearBuffer();
        rq_vector.removeAllElements();
    }

    public void clearBuffer()
    {
        draw_count = 0;
        chart_image1 = null;
        chart_graph1 = null;
    }

    public void setTitle(String s)
    {
        if(s != null)
        {
            Title = new String(s);
            legend_y = 20;
        }
    }

    public void setLegend(String s, String s1)
    {
        if(s != null)
            Legend = new String(s);
        else
            Legend = null;
        if(s1 != null)
            Legend_family = new String(s1);
        else
            Legend_family = null;
        if(draw_count > 1)
            draw_count = 1;
    }

    public void setMinMax(double d, double yaxis_unit)
    {
        if(yaxis_unit != iNan)
            max_val = yaxis_unit / unit;
        if(d != iNan)
            min_val = d / unit;
        min_max_yn = true;
    }

    public void setCol(int i)
    {
        if(col_count > 0)
            col_count = i;
        else
            col_count = 1;
        color_array = new Color[col_count];
        legend_array = new String[col_count];
    }

    public int getCol()
    {
        return col_count;
    }

    public boolean addCol(int i, int j, String s)
    {
        if(i >= col_count)
            return false;
        color_array[i] = new Color(j);
        legend_array[i] = new String(s);
        i = getFontMetrics(legend_font).stringWidth(s);
        if(i > legend_rect)
            legend_rect = i;
        return true;
    }

    public void setDec(int i)
    {
        String s = "0";
        if(i > 0)
            s = String.valueOf(String.valueOf(s)).concat(".");
        for(int j = 1; j < i; j++)
            s = String.valueOf(String.valueOf(s)).concat("#");

        setDec(s);
    }

    public void setDec(String s)
    {
        decimal_format = new DecimalFormat(s);
    }

    public void setPress(int i, int j)
    {
        chart_style = i;
        value_style = j;
        style_flag = j > 9;
        if(style_flag)
            value_style -= 10;
        max_val = -1.7976931348623157E+308D;
        item_value = 0.0D;
        min_val = 1.7976931348623157E+308D;
        min_max_yn = false;
        for(Enumeration enumeration = rq_vector.elements(); enumeration.hasMoreElements(); calc_MinMax((record_quardinates)enumeration.nextElement()));
        if(item_value == max_val)
            max_val = item_value + (double)1;
        if(min_val == 1.7976931348623157E+308D)
            min_val = 0.0D;
        if(item_value > (double)0)
            min_val = item_value * 0.80000000000000004D;
        if(max_val < (double)0)
            min_val = max_val * 0.80000000000000004D;
        if(item_value < (double)0 && max_val > (double)0)
            min_val = 0.0D;
    }

    public void setVal(int i)
    {
        if(i < 2)
            iVal = data_set;
        else
            iVal = i;
    }

    private void calc_MinMax(record_quardinates rq1)
    {
        double d = 1.7976931348623157E+308D;
        double yaxis_unit = -1.7976931348623157E+308D;
        double xaxis_unit = 1.7976931348623157E+308D;

        if(chart_style == 7) //if type=7 Points chart
        {
            double d3 = 1.7976931348623157E+308D;
            double d4 = -1.7976931348623157E+308D;
            int j = col_count / 3;
            for(int k = 0; k < j; k++)
            {
                if(rq1.iD[k] == iNan)
                    continue;
                if(rq1.iD[k * 3] > d4)
                    d4 = rq1.iD[k * 3];
                if(rq1.iD[k * 3] < d3)
                    d3 = rq1.iD[k * 3];
                if(rq1.iD[k * 3 + 1] > yaxis_unit)
                    yaxis_unit = rq1.iD[k * 3 + 1];
                if(rq1.iD[k * 3 + 1] < d)
                    d = rq1.iD[k * 3 + 1];
                if(rq1.iD[k * 3 + 1] > (double)0 && (rq1.iD[k * 3 + 1] < xaxis_unit || xaxis_unit == (double)0))
                    xaxis_unit = rq1.iD[k * 3 + 1];
            }

            if(yaxis_unit > max_val)
                max_val = yaxis_unit * 1.1000000000000001D;
            if(d < item_value)
                item_value = d;
            if(d4 > _$3213)
                _$3213 = d4 * 1.1000000000000001D;
            if(d3 < _$3208)
                _$3208 = d3;
        } else
        {
            if(chart_style == 3 || chart_style == 6)
                yaxis_unit = d = 0.0D;
            for(int i = 0; i < col_count; i++)
            {
                if(rq1.iD[i] == iNan)
                    continue;
                if(chart_style == 3 || chart_style == 6)
                {
                    if(rq1.iD[i] > (double)0)
                        yaxis_unit += rq1.iD[i];
                    else
                        d += rq1.iD[i];
                } else
                {
                    if(rq1.iD[i] > yaxis_unit)
                        yaxis_unit = rq1.iD[i];
                    if(rq1.iD[i] < d)
                        d = rq1.iD[i];
                }
                if(rq1.iD[i] > (double)0 && (rq1.iD[i] < xaxis_unit || xaxis_unit == (double)0))
                    xaxis_unit = rq1.iD[i];
            }

            if(yaxis_unit > max_val)
                max_val = yaxis_unit * 1.1000000000000001D;
            if(d < item_value)
                item_value = d;
        }
        if(min_val == 1.7976931348623157E+308D || min_val > xaxis_unit)
            min_val = xaxis_unit;
    }

    public void addRow(double ad[], String s)
    {
        record_quardinates rq1 = new record_quardinates(col_count);
        rq1.sIt = new String(s);
        for(int i = 0; i < col_count; i++)
            rq1.iD[i] = ad[i] / unit;

        rq_vector.addElement(rq1);
        data_set++;
        calc_MinMax(rq1);
    }

    public void setCel(int i, int j, double d)
    {
        if(i < col_count && j < data_set)
            ((record_quardinates)rq_vector.elementAt(j)).iD[i] = d / unit;
        if(d > max_val)
            max_val = d / unit;
        if(d < item_value)
            item_value = d / unit;
    }

    public void paint(Graphics g)
    {
        font_metrics = getFontMetrics(def_font);
        if(chart_graph == null)
        {
            w_width = getSize().width;
            w_height = getSize().height;
            try
            {
                chart_image = createImage(w_width, w_height);
                chart_graph = chart_image.getGraphics();
            }
            catch(Exception exception)
            {
                chart_graph = null;
            }
            draw_count = 0;
        }
        update(g);
    }

    public synchronized void update(Graphics g)
    {
        if(chart_graph != null)
        {
            display(chart_graph);
            g.drawImage(chart_image, 0, 0, this);
        } else
        {
            display(g);
        }
    }

    private void display(Graphics g)
    {
        if(iVal < 2)
            iVal = data_set;
        int chart_area_width;
        if(col_count > 1 && value_style < 2)
            chart_area_width = w_width - (legend_rect + 40);
        else
            chart_area_width = w_width;
        g.setColor(new Color(bg_color));
        g.fillRect(0, 0, w_width, w_height);
        chart_x = 0;
        itVal_Ypos = 0;
        if(draw_count > 0)
            g.drawImage(chart_image1, 0, 0, this);
        if(!min_max_yn)
        {
            min_max_yn = true;
            if(item_value > (double)0 && min_val < max_val - min_val || max_val < (double)0 && min_val > item_value - min_val || item_value >= (double)0 && max_val < (double)5 || max_val < (double)0 && item_value > (double)-5)
            {
                min_val = 0.0D;
                if(item_value >= (double)0)
                    item_value = 0.0D;
                else
                    max_val = 0.0D;
            } else
            {
                int i = (int)(max_val - min_val);
                if(i > 100)
                {
                    i = (int)(min_val / (double)100);
                    min_val = i * 100;
                } else
                if(i > 10)
                {
                    i = (int)(min_val / (double)10);
                    min_val = i * 10;
                } else
                if(i > 2)
                {
                    int j = (int)(min_val - (double)1);
                    min_val = j;
                } else
                if(max_val - min_val > 0.10000000000000001D)
                {
                    int k = (int)(min_val * (double)10);
                    min_val = k / 10;
                }
            }
        }
        if(iVal == 0)
        {
            iVal = 1;
            max_val = 10D;
        }
        chart_unit = (double)(((w_height - 10 - legend_y) + (40 - origine_y)) * 8 * 10) / ((-min_val + max_val) - item_value);
        chart_x = origine_x;
        itVal_Ypos = (w_height - origine_y) + (int)((item_value * chart_unit) / (double)100);
        itVal_Xpos = (chart_area_width - chart_x) / (2 * iVal);
        if(legends < 0)
            legends = iVal / -legends;
        if(itVal_Xpos < 1)
            itVal_Xpos = 1;
        if(itVal_Xpos < 2 && chart_style != 1 && chart_style < 5)
            itVal_Xpos = 2;
        g.setFont(title_font);
        g.setColor(Color.black);
        int l = (w_width - getFontMetrics(g.getFont()).stringWidth(Title)) / 2;
        g.drawString(Title, l, 15);
		//to display the color indication legends
        if(col_count >= 1 && chart_style != 4 && value_style < 2)
        {
            int i1 = 0;
			g.setFont(legend_font);
            do
            {
                if(i1 >= col_count)
                    break;
			    g.setColor(color_array[i1]);
                g.fill3DRect(15 + chart_area_width, 30 + 25 * i1, 15, 15, true);
                g.setColor(Color.black);
                g.drawString(legend_array[i1], 35 + chart_area_width, 42 + 25 * i1);
                i1++;
                if(chart_style == 7 && i1 >= col_count / 3)
                    i1 *= 4;
          } while(true);
        }
        if(chart_style == 2)
            pi_chart(g, chart_area_width);
        else
			if(chart_style == 4)
				text_table(g);
			else
				all_charts(g, chart_area_width);
        if(mouse_X > -1 && mouse_Y > -1 && value_legend != null)
            drawChart(g, value_legend, mouse_X, mouse_Y);
        g.setFont(legend_font);
        FontMetrics fontmetrics = getFontMetrics(legend_font);
        if(chart_style != 2 && chart_style != 4)
        {
            g.setColor(Color.black);
            if(Legend != null)
            {
                int j1 = w_width - fontmetrics.stringWidth(Legend);
                g.drawString(Legend, j1 / 2, w_height - 2);
            }
            if(Legend_family != null && draw_count < 2)
            {
                int k1 = w_height - fontmetrics.stringWidth(Legend_family);
                create_chart(Legend_family, 0.0D, 0, k1 / 2, legend_font, true);
            }
            if(draw_count < 2)
            {
                draw_count++;
                repaint();
            }
        }
    }

    private void drawChart(Graphics g, String s, int i, int j)
    {
        if(s == null)
            return;
        int k = 10 + font_metrics.stringWidth(String.valueOf(String.valueOf(s)).concat("--"));
        int l = 3 + font_metrics.getHeight();
        int i1 = 0;
        if(bullet_title_yn)
            i1 = l;
        String s1 = ((record_quardinates)rq_vector.elementAt(rq_iteretor)).sIt;
        if(font_metrics.stringWidth(s1) + 3 > k)
            k = font_metrics.stringWidth(s1) + 3;

		//to display the tool tip with a vertile line
        if(chart_style == 1 || chart_style == 5 || chart_style == 6 || chart_style == 8)
        {
            int j1 = 6 + font_metrics.stringWidth(String.valueOf(String.valueOf(addUnitLegend(max_val))).concat("--"));
            if(font_metrics.stringWidth(s1) + 3 > j1)
                j1 = font_metrics.stringWidth(s1) + 3;
            g.setColor(new Color(0xff2020));
            g.drawLine(col_position, 20, col_position, w_height - 30);
            g.setColor(Color.white);
            g.fillRect(i - j1 - 8, j - 20, j1 + 8, l * col_count + i1 + 6);
            if(i1 > 0)
            {
                g.setColor(new Color(0xe0e0e0));
                g.fillRect(i - j1 - 5, j - 18, j1 + 3, l - 4);
            }
            g.setColor(Color.black);
            g.drawRect(i - j1 - 8, j - 20, j1 + 8, l * col_count + i1 + 6);
            k = (i - j1) + 3;
            if(i1 > 0)
            {
                l = (j - 20) + font_metrics.getHeight();
                g.drawString(s1, k - 2, l - 2);
            }
            for(int k1 = 0; k1 < col_count; k1++)
            {
                if(i1 > 0)
                    l = (j - 23) + (3 + font_metrics.getHeight()) * (k1 + 2);
                else
                    l = (j - 23) + (3 + font_metrics.getHeight()) * (k1 + 1);
                if(((record_quardinates)rq_vector.elementAt(rq_iteretor)).iD[k1] != iNan && chart_style == 8)
                {
                    g.setColor(color_array[k1]);
                    g.fillRect(k - 7, l - 5, 5, 5);
                    g.setColor(Color.black);
                    if(((record_quardinates)rq_vector.elementAt(rq_iteretor)).iD[k1] == iNan)
                        s = " nan";
                    else
                        s = addUnitLegend(((record_quardinates)rq_vector.elementAt(rq_iteretor)).iD[k1]);
                    g.drawString(s, k + (j1 - 6 - font_metrics.stringWidth(String.valueOf(String.valueOf(s)).concat("--"))), l);
                } else
                {
                    g.setColor(color_array[k1]);
                    g.fillRect(k - 7, l - 5, 5, 5);
                    g.setColor(Color.black);
                    if(((record_quardinates)rq_vector.elementAt(rq_iteretor)).iD[k1] == iNan)
                        s = " nan";
                    else
                        s = addUnitLegend(((record_quardinates)rq_vector.elementAt(rq_iteretor)).iD[k1]);
                    g.drawString(s, k + (j1 - 6 - font_metrics.stringWidth(String.valueOf(String.valueOf(s)).concat("--"))), l);
                }
            }

        } else
        {
            g.setColor(Color.white);
            g.fillRect(i - k - 8, j - 20, k + 8, l * 2);
            g.setColor(new Color(0xe0e0e0));
            g.fillRect(i - k - 5, j - 18, k + 3, l - 4);
            g.setColor(color_array[col_position]);
            g.fillRect(i - k - 4, (j - 20) + 7 + l, 5, 5);
            g.setColor(Color.black);
            g.drawRect(i - k - 8, j - 20, k + 8, l * 2);
            k = (i - k) + 3;
            l = (j - 23) + l;
            g.drawString(s1, k - 2, l - 2);
            k += 3;
            l += font_metrics.getHeight();
            g.drawString(s, k, l + 2);
        }
    }

    private void fill_arc(Graphics g, int i, Object obj)
    {
        record_quardinates rq1 = (record_quardinates)obj;
        double d = 0.0D;
        int j = w_height / _$3320;
        int k = i / j;
        int l = i % j;
        for(int j1 = 0; j1 < col_count; j1++)
            if(rq1.iD[j1] != iNan)
                d += rq1.iD[j1];

        g.setColor(Color.black);
        g.setFont(legend_font);
        g.drawString(rq1.sIt, 10 + k * _$3320, 12 + l * _$3320);
        g.setColor(Color.lightGray);
        g.setFont(def_font);
        //boolean flag = false;
        //boolean flag1 = false;
        int i2 = 0;
        i = font_metrics.getHeight();
        g.setColor(color_array[col_count - 1]);
        g.fillOval((_$3320 * (1 + k * 6)) / 6, (_$3320 * (1 + l * 6)) / 6, (_$3320 * 2) / 3, (_$3320 * 2) / 3);
        for(int j2 = 0; j2 < col_count; j2++)
        {
            int i1 = (int)((rq1.iD[j2] * (double)360) / d + 0.5D);
            g.setColor(color_array[j2]);
            g.fillArc((_$3320 * (1 + k * 6)) / 6, (_$3320 * (1 + l * 6)) / 6, (_$3320 * 2) / 3, (_$3320 * 2) / 3, i2, i1);
            int k1 = (int)(((double)_$3320 * Math.cos(((double)(i2 + i1 / 2) * 3.1415926535897931D) / (double)180)) / (double)3);
            int l1 = (int)(((double)_$3320 * Math.sin(((double)(i2 + i1 / 2) * 3.1415926535897931D) / (double)180)) / (double)3);
            double yaxis_unit = (rq1.iD[j2] * (double)100) / d;
            if((value_style & 1) != 1 && yaxis_unit > (double)1)
            {
                int k2 = font_metrics.stringWidth(String.valueOf(String.valueOf((new StringBuffer("")).append(addUnitLegend(yaxis_unit)).append("%")))) + 5;
                if(k1 < 0)
                    k1 -= k2 - 5;
                if(l1 < 0)
                    l1 -= i;
                g.setColor(Color.white);
                int l2 = _$3320 * k + _$3320 / 2 + k1;
                int i3 = (_$3320 * l + _$3320 / 2) - l1;
                if(style_flag)
                    if(l2 > (_$3320 * (1 + k * 6)) / 6)
                        l2 -= k2;
                    else
                        l2 += k2;
                g.fillRect(l2 - 1, (i3 - i) + 3, k2 - 5, i - 2);
                g.setColor(Color.black);
                g.drawString(String.valueOf(String.valueOf((new StringBuffer("")).append(addUnitLegend(yaxis_unit)).append("%"))), l2, i3);
            }
            i2 += i1;
        }

    }

    private void point_chart(Graphics g, int i, Object obj)
    {
        record_quardinates rq1 = (record_quardinates)obj;
       // boolean flag = false;
      //  boolean flag1 = false;
       // boolean flag2 = true;
        int i1 = col_count / 3;
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(rq1.iD[j1] == iNan)
                continue;
            int l = (int)rq1.iD[j1 * 3 + 2] * 5;
            int j = (chart_x + (int)((rq1.iD[j1 * 3] * _$3246) / (double)100)) - l / 2;
            int k = itVal_Ypos - (int)((rq1.iD[j1 * 3 + 1] * chart_unit) / (double)100) - l / 2;
            g.setColor(color_array[j1]);
			g.fillOval(j-3, k-3, 6, 6);
            g.setColor(Color.black);
			if((value_style & 1) != 1)
            {
                int k1 = font_metrics.stringWidth(rq1.sIt);
                g.drawString(rq1.sIt, j + (l - k1) / 2, k + l + 10);
            }
            if(i % _$1557 == 0 && legends > 0)
            {
                g.drawLine(j + l / 2, itVal_Ypos - 2, j + l / 2, itVal_Ypos + 2);
                g.drawString(addUnitLegend(rq1.iD[j1 * 3]), (j - 5) + l / 2, itVal_Ypos + 25);
            }
        }

    }

    private void other_charts(Graphics g, int i, Object obj)
    {

		record_quardinates rq1 = (record_quardinates)obj;
       // boolean flag = false;
        //boolean flag1 = false;
        int l = 0;
       // boolean flag2 = false;
       // boolean flag3 = false;
       // boolean flag4 = false;
        int ai[] = new int[4];
        int ai1[] = new int[4];
        int l1 = font_metrics.getHeight();
        //boolean flag5 = false;
        int j2 = itVal_Ypos;
        int k2 = itVal_Ypos;
        int l2 = itVal_Ypos;
       // boolean flag6 = false;
        boolean flag7 = false;
        int j3 = (itVal_Xpos * 2) / (col_count + 1);

        for(int k3 = 1; k3 <= col_count; k3++)
        {
            int j = chart_x + (i - _$3357) * 2 * itVal_Xpos;
            if(chart_style == 0)
                j += k3 * j3 - j3;
            int k;
            int j1;
            int i3;
            if(rq1.iD[col_count - k3] > (double)0)
            {
                k = (int)((double)k2 - ((rq1.iD[col_count - k3] - min_val) * chart_unit) / (double)100);
                j1 = k2;
                i3 = k;
                if(chart_style == 3 || chart_style == 6)
                    k2 = k;
            } else
            {
                k = j2;
                j1 = k + (int)((-rq1.iD[col_count - k3] * chart_unit) / (double)100);
                i3 = j1;
                if(chart_style == 3 || chart_style == 6)
                    j2 = j1;
            }
            if(i - _$3357 > 0)
            {
                l = (int)((double)l2 - ((((record_quardinates)rq_vector.elementAt(i - 1)).iD[col_count - k3] - min_val) * chart_unit) / (double)100);
                flag7 = ((record_quardinates)rq_vector.elementAt(i - 1)).iD[col_count - k3] == iNan;
            }
            if(rq1.iD[col_count - k3] == iNan)
                continue;
            if((value_style & 1) != 1)
            {
                String s = (new String(addUnitLegend(rq1.iD[col_count - k3]))).trim();
                int i2 = font_metrics.stringWidth(s);
                int k1;
                if(chart_style == 1 || chart_style == 8)
                    k1 = chart_x + (i - _$3357) * 2 * itVal_Xpos;
                else
                    k1 = chart_x + (i - _$3357) * 2 * itVal_Xpos + itVal_Xpos;
                g.setColor(Color.white);
                g.fill3DRect(k1, i3, i2 + 4, l1 - 2, true);
                g.setColor(Color.black);
                g.drawString(s, k1 + 2, (i3 + l1) - 3);
                g.setColor(color_array[col_count - k3]);
                g.draw3DRect(k1, i3, i2 + 4, l1 - 2, true);
            }
            g.setColor(color_array[col_count - k3]);
            if(chart_style == 0 || chart_style == 3)
            {
                if(chart_style == 0)
                    g.fill3DRect(j, k, j3, j1 - k, true);
                else
                    g.fill3DRect(j, k, itVal_Xpos, j1 - k, true);
                continue;
            }
            if(chart_style == 1 || chart_style == 8)
            {
                if(i - _$3357 < 0)
                    continue;
                if(chart_style == 1)
                {
                    if(i - _$3357 <= 0)
                        continue;
                    int i1 = (int)((double)itVal_Ypos - ((((record_quardinates)rq_vector.elementAt(i - 1)).iD[col_count - k3] - min_val) * chart_unit) / (double)100);
                    if(flag7)
                        continue;
                    k = (int)((double)itVal_Ypos - ((rq1.iD[col_count - k3] - min_val) * chart_unit) / (double)100);
                    g.drawLine(j, k, j - itVal_Xpos * 2, i1);
					g.fillArc(j - 3, k - 3, 7, 7,0,360);
                    if(itVal_Xpos > 4)
                    {
                        g.drawLine(j + 1, k, (1 + j) - itVal_Xpos * 2, i1);
                    }
                    if((1 + i) % _$1557 != 0)
                        continue;
                    g.setColor(new Color(line_color));
                    if(j1 == k)
                        g.drawLine(j, k, j, itVal_Ypos);
                    else
                        g.drawLine(j, k, j, j1);
                    continue;
                }
                k = (int)((double)itVal_Ypos - ((rq1.iD[col_count - k3] - min_val) * chart_unit) / (double)100);
                if(itVal_Xpos > 20)
                {
                    g.fillRect((j - 4) + k3, (k - 4) + k3, 6, 6);
                } else
                {
                    g.drawLine(j - 1, k, 1 + j, k);
                    g.drawLine(j - 1, k - 1, 1 + j, k - 1);
                }
                continue;
            }
            if(chart_style <= 4 || i - _$3357 <= 0)
                continue;
            ai[0] = ai[1] = j;
            ai[2] = ai[3] = j - itVal_Xpos * 2;
            ai1[0] = j1;
            ai1[1] = k;
            if(l > itVal_Ypos)
            {
                ai1[2] = l2;
                ai1[3] = l;
            } else
            {
                ai1[2] = l;
                ai1[3] = l2;
            }
            if(chart_style == 6)
                l2 = l;
            g.fillPolygon(ai, ai1, 4);
        }

        if(i % _$1557 == 0 && legends > 0)
        {
            g.setColor(Color.black);
            g.drawLine(chart_x + (i - _$3357) * 2 * itVal_Xpos, itVal_Ypos - 2, chart_x + (i - _$3357) * 2 * itVal_Xpos, itVal_Ypos + 2);
            if(rotate_yn)
            {
                if(draw_count < 1)
                    create_chart(rq1.sIt, 0.0D, (chart_x - 4) + (i - _$3357) * 2 * itVal_Xpos, ((itVal_Ypos + l1) - 11) + 2, def_font, false);
            } else
            {
                g.drawString(rq1.sIt, (chart_x - 5) + (i - _$3357) * 2 * itVal_Xpos, itVal_Ypos + l1 * (1 + (i - _$3357) % 2));
            }
        }
    }

    private void pi_chart(Graphics g, int chart_width)
    {
        int j = 0;
        _$3320 = (int)Math.sqrt((w_height * chart_width) / data_set);
        j = w_height / _$3320;
        int i1 = chart_width / _$3320;
        if(i1 == 0)
            i1 = 1;
        for(int k = j * i1; k < data_set; k = j * i1)
            if(w_height >= chart_width && (w_height * i1) / chart_width < j || chart_width > w_height && (chart_width * j) / w_height < i1)
            {
                j++;
                _$3320 = w_height / j;
            } else
            {
                i1++;
                _$3320 = chart_width / i1;
            }

        g.setColor(Color.black);
        g.setFont(def_font);
        int l = 0;
        for(Enumeration enumeration = rq_vector.elements(); enumeration.hasMoreElements(); fill_arc(g, l++, enumeration.nextElement()));
    }

    private void all_charts(Graphics g, int chart_width)
    {
        double d = 0.0D;
        double xaxis_unit = 1.0D;
        chart_x = origine_x;
        itVal_Ypos = (w_height - origine_y) + (int)((item_value * chart_unit) / (double)100);
        if(chart_style == 7)
        {
            _$3246 = (double)((w_width - 30) * 8 * 10) / (_$3213 - _$3208);
            chart_x = 30 - (int)((_$3208 * _$3246) / (double)100);
        }
        if(iVal + _$3357 >= data_set)
            _$3361 = 0;
        else
            _$3361 = 1;
        if(itVal_Xpos < 4)
        {
            if(iVal > 200)
                _$1557 = 25;
            else
                _$1557 = 10;
        } else
        {
            _$1557 = 1;
        }
        if(legends > 1)
            _$1557 = legends;
        double yaxis_unit;
        if(max_val > (double)0)
            yaxis_unit = (max_val - min_val) / (double)10;
        else
            yaxis_unit = (item_value - min_val) / (double)10;
        for(yaxis_unit = Math.abs(yaxis_unit); xaxis_unit < yaxis_unit; xaxis_unit *= 10);
        double d3 = max_val - min_val;
        if(max_val <= (double)0)
            d3 = item_value - min_val;
        else
			if(item_value < (double)0)
				d3 = max_val - item_value;
        for(; Math.abs(d3 / xaxis_unit) < (double)4; xaxis_unit /= 2);
        int j = 0;
        yaxis_unit = itVal_Ypos;
        for(d = 0.0D; yaxis_unit < (double)(w_height - 50); d -= xaxis_unit)
            yaxis_unit += (xaxis_unit * chart_unit) / (double)100;

        g.setFont(def_font);
		//to draw lines parallel to X axis...
        while(yaxis_unit > (double)15) 
        {
            if(d + min_val >= item_value)
            {
                String s = addUnitLegend(d + min_val);
                int k = chart_x - 5 - font_metrics.stringWidth(s);
                g.setColor(Color.black);
                g.drawString(s, k, (int)(yaxis_unit + (double)2));
                g.setColor(new Color(line_color));
                g.drawLine(origine_x - 10, (int)yaxis_unit, chart_width, (int)yaxis_unit);
            }
            yaxis_unit -= (xaxis_unit * chart_unit) / (double)100;
            d += xaxis_unit;
        }
		//to draw the X & Y axis lines 
        g.setColor(Color.black);
        g.drawLine(chart_x, 15, chart_x, w_height - 30);
        g.drawLine(chart_x - 5, itVal_Ypos, chart_width, itVal_Ypos);
        j = 0;
        for(Enumeration enumeration = rq_vector.elements(); enumeration.hasMoreElements(); j++)
        {
          if(chart_style == 7)
            {
                point_chart(g, j, enumeration.nextElement());
                continue;
            }
            if(j >= _$3357 && j < _$3357 + iVal)
                other_charts(g, j, enumeration.nextElement());
            else
                enumeration.nextElement();
        }

        if(_$3361 + _$3357 > 0)
            g.setColor(Color.lightGray);
        if(_$3361 == 1)
        {
            g.fill3DRect(chart_width - 14, w_height - 12, 14, 12, true);
            int ai[] = {
                chart_width - 9, chart_width - 9, chart_width - 3
            };
            int ai2[] = {
                w_height - 9, w_height - 3, w_height - 6
            };
            g.setColor(Color.black);
            g.fillPolygon(ai, ai2, 3);
            g.setColor(Color.lightGray);
        }
        if(_$3357 > 0)
        {
            g.fill3DRect(40, w_height - 12, 14, 12, true);
            int ai1[] = {
                50, 50, 44
            };
            int ai3[] = {
                w_height - 9, w_height - 3, w_height - 6
            };
            g.setColor(Color.black);
            g.fillPolygon(ai1, ai3, 3);
            if(_$3361 == 1)
                _$3361 = 2;
            else
                _$3361 = 3;
        }
        if(bMM > 0)
        {
            g.setColor(new Color(sMaxColor));
            int l = (int)((double)itVal_Ypos - ((max_val - min_val) * chart_unit) / (double)100);
            if(bMM == 1 || bMM == 3)
            {
                String s1 = addUnitLegend(max_val);
                int i1 = font_metrics.stringWidth(s1) + 2;
                g.drawLine(chart_x - 5, l, chart_width - i1, l);
                g.drawString(s1, (chart_width - i1) + 2, l + 5);
            }
            l = (int)((double)itVal_Ypos - ((item_value - min_val) * chart_unit) / (double)100);
            if(bMM > 1)
            {
                String s2 = addUnitLegend(item_value);
                int j1 = font_metrics.stringWidth(s2) + 2;
                g.drawLine(chart_x - 5, l, chart_width - j1, l);
                g.drawString(s2, (chart_width - j1) + 2, l + 5);
            }
        }
    }

    private void text_table(Graphics g)
    {
        int ai[] = new int[col_count + 1];
        int j1 = 0;
        g.setFont(new Font("Helvetica", 1, 12));
        FontMetrics fontmetrics = getFontMetrics(g.getFont());
        j1 = fontmetrics.getHeight() + 4;
        if(((data_set - _$3357) + 1) * j1 > w_height - 5)
            _$3361 = 1;
        else
            _$3361 = 0;
        ai[0] = 10;
        for(int i = 0; i < data_set; i++)
        {
            int l = (fontmetrics.stringWidth(((record_quardinates)rq_vector.elementAt(i)).sIt) * 14) / 10;
            if(l > ai[0])
                ai[0] = l;
        }

        int k1 = ai[0];
        for(int j = 0; j < col_count; j++)
        {
            ai[j + 1] = (fontmetrics.stringWidth(legend_array[j]) * 16) / 10;
            g.setColor(Color.lightGray);
            g.fillRect(10 + k1, legend_y + 5, ai[j + 1], j1);
            g.setColor(color_array[j]);
            g.draw3DRect(10 + k1, 5 + legend_y, ai[j + 1], j1, true);
            g.draw3DRect(11 + k1, 6 + legend_y, ai[j + 1] - 2, j1 - 2, true);
            g.setColor(Color.black);
            g.drawString(legend_array[j], 10 + k1 + ai[j + 1] / 5, 2 + j1 + legend_y);
            k1 += ai[j + 1];
        }

        _$3320 = k1 + 10 + 2;
        g.setColor(Color.white);
        g.fillRect(10 + ai[0], legend_y + 5 + j1, k1 - ai[0], j1 * (data_set - _$3357));
        int k = 0;
label0:
        for(Enumeration enumeration = rq_vector.elements(); enumeration.hasMoreElements(); k++)
        {
            record_quardinates rq1 = (record_quardinates)enumeration.nextElement();
            if(k < _$3357)
                continue;
            g.setColor(Color.lightGray);
            g.fill3DRect(10, legend_y + 5 + j1 * ((k + 1) - _$3357), ai[0], j1, true);
            g.draw3DRect(11, legend_y + 6 + j1 * ((k + 1) - _$3357), ai[0] - 2, j1 - 2, true);
            g.setColor(Color.black);
            g.drawString(rq1.sIt, 10 + ai[0] / 5, legend_y + 2 + j1 * ((k + 2) - _$3357));
            int l1 = ai[0];
            int i1 = 0;
            do
            {
                if(i1 >= col_count)
                    continue label0;
                int i2 = fontmetrics.stringWidth(addUnitLegend(rq1.iD[i1]));
                g.setColor(Color.black);
                g.draw3DRect(10 + l1, legend_y + 5 + j1 * ((k + 1) - _$3357), ai[i1 + 1], j1, true);
                if(rq1.iD[i1] != iNan)
                    g.drawString(addUnitLegend(rq1.iD[i1]), (l1 + ai[i1 + 1]) - i2, legend_y + 2 + j1 * ((k + 2) - _$3357));
                l1 += ai[i1 + 1];
                i1++;
            } while(true);
        }

        if(_$3361 + _$3357 > 0)
            g.setColor(new Color(0xc0c0c0));
        if(_$3361 == 1)
        {
            g.fill3DRect(_$3320, w_height - 12, 14, 12, true);
            g.setColor(Color.black);
            int ai1[] = {
                _$3320 + 4, _$3320 + 10, _$3320 + 7
            };
            int ai3[] = {
                w_height - 9, w_height - 9, w_height - 4
            };
            g.fillPolygon(ai1, ai3, 3);
            g.setColor(new Color(0xc0c0c0));
        }
        if(_$3357 > 0)
        {
            g.fill3DRect(_$3320, legend_y + 20, 14, 12, true);
            int ai2[] = {
                _$3320 + 7, _$3320 + 3, _$3320 + 10
            };
            int ai4[] = {
                legend_y + 20 + 4, legend_y + 20 + 9, legend_y + 20 + 9
            };
            g.setColor(Color.black);
            g.fillPolygon(ai2, ai4, 3);
            if(_$3361 == 1)
                _$3361 = 2;
            else
                _$3361 = 3;
        }
    }

    private String displaitVal_Xpos(int i, int j, int k, record_quardinates rq1)
    {
        //boolean flag = false;
        //boolean flag1 = false;
        int j1 = itVal_Ypos;
        int k1 = itVal_Ypos;
        int l1 = (itVal_Xpos * 2) / (col_count + 1);
        int i2 = chart_x + (k - _$3357) * 2 * itVal_Xpos;
        String s = null;
        if(i > i2 + itVal_Xpos + itVal_Xpos || i < i2)
            return null;
        if(chart_style == 0 || chart_style == 3)
        {
            for(int j2 = 1; j2 <= col_count; j2++)
            {
                int l;
                int i1;
                if(rq1.iD[col_count - j2] > (double)0)
                {
                    l = (int)((double)k1 - ((rq1.iD[col_count - j2] - min_val) * chart_unit) / (double)100);
                    i1 = k1;
                    if(chart_style == 3)
                        k1 = l;
                } else
                {
                    l = j1;
                    i1 = l + (int)((-rq1.iD[col_count - j2] * chart_unit) / (double)100);
                    if(chart_style == 3)
                        j1 = i1;
                }
                if(chart_style == 0)
                {
                    if(i > i2 && i < i2 + l1 && j > l && j < i1)
                    {
                        s = new String(addUnitLegend(rq1.iD[col_count - j2]));
                        col_position = col_count - j2;
                    }
                } else
                if(i > i2 && i < i2 + itVal_Xpos + itVal_Xpos && j > l && j < i1)
                {
                    s = new String(addUnitLegend(rq1.iD[col_count - j2]));
                    col_position = col_count - j2;
                }
                if(chart_style == 0)
                    i2 += l1;
            }

        } else
        if(i >= i2 && i < i2 + itVal_Xpos)
        {
            s = "".concat(String.valueOf(String.valueOf(i2)));
            col_position = i2;
        }
        return s;
    }

    public void mouseDragged(MouseEvent mouseevent)
    {
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if((chart_style == 0 || chart_style == 1 || chart_style == 3 || chart_style == 5 || chart_style == 8 || chart_style == 6) && style_flag)
        {
            int k = 0;
            String s = null;
            for(Enumeration enumeration = rq_vector.elements(); enumeration.hasMoreElements(); k++)
            {
                if(k >= _$3357 && k < _$3357 + iVal)
                {
                    s = displaitVal_Xpos(i, j, k, (record_quardinates)enumeration.nextElement());
                    if(s == null)
                        continue;
                    rq_iteretor = k;
                    break;
                }
                enumeration.nextElement();
            }

            boolean flag = false;
            flag = s != null && value_legend == null;
            if(!flag)
                flag = s == null && value_legend != null;
            if(!flag && s != null)
                flag = !s.equals(value_legend);
            if(flag)
            {
                value_legend = s;
                mouse_X = i;
                mouse_Y = j;
                repaint();
            }
        }
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if(chart_style == 4)
        {
            if(_$3361 > 0 && i > _$3320 && i < _$3320 + 15)
            {
                if(_$3361 > 1)
                {
                    if(j > 20 + legend_y)
                        if(j < legend_y + 33)
                            _$3357--;
                        else
                        if(2 * j < w_height)
                            _$3357 -= 5;
                    if(_$3357 < 0)
                        _$3357 = 0;
                }
                if(_$3361 < 3)
                    if(j > w_height - 13)
                        _$3357++;
                    else
                    if(2 * j >= w_height)
                        _$3357 += 5;
                repaint();
            }
        } else
        if(chart_style != 2)
        {
            int k;
            if(col_count > 1 && value_style < 2)
                k = w_width - (legend_rect + 40);
            else
                k = w_width;
            if(_$3361 > 0 && j > w_height - 13)
            {
                int l = _$3357;
                if(_$3357 > 0)
                {
                    if(i > 40 && i < (k - 40) / 2)
                        if(i < 55)
                            _$3357--;
                        else
                        if(i < (k - 40) / 2)
                            _$3357 -= iVal / 2;
                    if(_$3357 < 0)
                        _$3357 = 0;
                }
                if(_$3361 < 3 && i < k)
                    if(i > k - 14)
                        _$3357++;
                    else
                    if(i > (k - 40) / 2)
                        _$3357 += iVal / 2;
                if(_$3357 != l)
                    clearBuffer();
                repaint();
            }
        }
    }

    public void mousePressed(MouseEvent mouseevent)
    {
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
        repaint();
    }

    public void mouseExited(MouseEvent mouseevent)
    {
        value_legend = null;
        repaint();
    }

    private void create_chart(String s, double d, int i, int j, Font font, boolean flag)
    {
        FontMetrics fontmetrics = getFontMetrics(font);
        if(chart_image1 == null)
        {
            try
            {
                chart_image1 = createImage(w_width, w_height);
                chart_graph1 = chart_image1.getGraphics();
            }
            catch(Exception exception)
            {
                return;
            }
            chart_graph1.setColor(new Color(bg_color));
            chart_graph1.fillRect(0, 0, w_width, w_height);
            if(back_image != null)
            {
                //boolean flag1 = false;
                int l = 0;
                if(bkImage_width == -1 || bkImage_height == -1)
                {
                    bkImage_width = back_image.getWidth(this);
                    bkImage_height = back_image.getHeight(this);
                }
                if(bkImage_width != -1 && bkImage_height != -1)
                    if(cBg_align == 'M')
                        for(; l < w_height; l += bkImage_height)
                        {
                            for(int k = 0; k < w_width; k += bkImage_width)
                                chart_graph1.drawImage(back_image, k, l, this);

                        }

                    else
                    if(cBg_align == 'C')
                        chart_graph1.drawImage(back_image, (w_width - bkImage_width) / 2, (w_height - bkImage_height) / 2, this);
                    else
                    if(cBg_align == 'R')
                        chart_graph1.drawImage(back_image, w_width - bkImage_width, 0, this);
                    else
                        chart_graph1.drawImage(back_image, 5, 0, this);
            }
        }
        try
        {
            chart_image2 = createImage(fontmetrics.stringWidth(s), fontmetrics.getHeight());
            chart_graph2 = chart_image2.getGraphics();
        }
        catch(Exception exception1)
        {
            chart_image2 = null;
            return;
        }
        chart_graph2.setFont(font);
        chart_graph2.setColor(new Color(bg_color));
        chart_graph2.fillRect(0, 0, w_height, 150);
        chart_graph2.setColor(new Color(color1));
        chart_graph2.drawString(s, 1, fontmetrics.getHeight());
        Image image = createImage(new FilteredImageSource(chart_image2.getSource(), new RotateFilter()));
        if(flag)
        {
            chart_graph1.setColor(new Color(bg_color));
            chart_graph1.fillRect(0, 0, fontmetrics.getHeight(), w_height);
        }
        chart_graph1.drawImage(image, i, j, this);
    }

    private String addUnitLegend(double d)
    {
        String s = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(decimal_format.format(d))))).append(" ").append(unit_legend)));
        return s.trim();
    }

    double iNan;
    private Vector rq_vector;
    private DecimalFormat decimal_format;
    private boolean bullet_title_yn;
    private boolean min_max_yn;
    private boolean style_flag;
    private boolean rotate_yn;
    private int color1;
    private int bg_color;
    private int line_color;
    private int w_width;
    private int chart_x;
    private int legend_y;
    private int legend_rect;
    private int legends;
    private int w_height;
    private int itVal_Ypos;
    private int itVal_Xpos;
    private int bkImage_width;
    private int bkImage_height;
    private int col_count;
    private int origine_x;
    private int origine_y;
    private int rq_iteretor;
    private int col_position;
    private int mouse_X;
    private int mouse_Y;
   // private int _$3318;
    private int _$3320;
    private int _$1557;
    private int data_set;
    private int chart_style;
    private int value_style;
    private int _$3357;
    private int _$3361;
    private int draw_count;
    private double item_value;
    private double max_val;
    private double _$3208;
    private double _$3213;
    private double min_val;
    private double chart_unit;
    private double _$3246;
    private double unit;
    private String value_legend;
    private String unit_legend;
    private String legend_array[];
    private String Title;
    private String Legend;
    private String Legend_family;
    private Font def_font;
    private Font title_font;
    private Font legend_font;
    private FontMetrics font_metrics;
    private Color color_array[];
    private Graphics chart_graph;
    private Graphics chart_graph1;
    private Graphics chart_graph2;
    private Image back_image;
    private Image chart_image;
    private Image chart_image1;
    private Image chart_image2;
    public int iVal;
    public char cBg_align;
    public int sMaxColor;
    public int bMM;
}