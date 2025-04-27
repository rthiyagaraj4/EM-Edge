/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util.graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class linechart {

	public static String DoubleToStr(double d, int k) {
		k = Math.max(0, k);
		if (k == 0 && d < 1000D && d > -1000D)
			return Math.round(d) + "";
		long l = (long) Math.pow(10D, k);
		long l1 = Math.round(d * (double) l);
		long l2 = Math.abs(l1) % l + l;
		String s = "";
		if (k > 0)
			s = "." + (l2 + "").substring(1);
		l1 /= l;
		if (l1 == 0L) {
			if (d < 0.0D)
				s = "-0" + s;
			else
				s = "0" + s;
			return s;
		}
		if (l1 > 0L)
			for (; l1 >= 1L; l1 /= 1000L) {
				long l3 = l1 % 1000L + 1000L;
				if (l3 >= 1000L && l1 >= 1000L)
					s = " " + (l3 + "").substring(1) + s;
				else
					s = l1 % 1000L + s;
			}

		else if (l1 < 0L)
			for (; l1 <= -1L; l1 /= 1000L) {
				long l4 = l1 % 1000L - 1000L;
				if (l4 <= -1000L && l1 <= -1000L)
					s = " " + (l4 + "").substring(2) + s;
				else
					s = l1 % 1000L + s;
			}

		return s;
	}

	public static String FormatStr(String s, int k, int l) {
		String s1 = "";
		int i1 = s.length();
		if (k < 0)
			k = i1;
		switch (l) {
		case 1: // '\001'
			if (i1 > k) {
				s1 = s.substring((i1 - k) / 2, k);
				break;
			}
			int j2 = (k - i1) / 2;
			for (int j1 = 0; j1 < j2; j1++)
				s1 = s1 + " ";

			s1 = s1 + s;
			for (int k1 = 0; k1 < k - i1 - j2; k1++)
				s1 = s1 + " ";

			break;

		case 2: // '\002'
			if (i1 > k) {
				s1 = s.substring(i1 - k, k);
				break;
			}
			for (int l1 = i1; l1 < k; l1++)
				s1 = s1 + " ";

			s1 = s1 + s;
			break;

		default:
			if (i1 > k) {
				s1 = s.substring(0, k);
				break;
			}
			s1 = s;
			for (int i2 = i1; i2 < k; i2++)
				s1 = s1 + " ";

			break;
		}
		return s1;
	}

	public static void drawgridline(Image image, int k, int l, int i1, int j1,
			Color color, int k1) {
		pad = image.getGraphics();
		pad.setColor(color);
		switch (k1) {
		case 1: // '\001'
			pad.drawLine(k, l, i1, j1);
			break;

		case 2: // '\002'
			if (k == i1) {
				for (int l1 = 0; l1 < Math.abs(l - j1) / 2; l1++)
					pad.drawLine(k, l + l1 * 2, k, l + l1 * 2);

				pad.drawLine(k, j1, k, j1);
				break;
			}
			for (int i2 = 0; i2 < Math.abs(k - i1) / 2; i2++)
				pad.drawLine(k + i2 * 2, l, k + i2 * 2, l);

			pad.drawLine(i1, l, i1, l);
			break;

		case 3: // '\003'
			if (k == i1) {
				for (int j2 = 0; j2 < Math.abs(l - j1) / 3; j2++)
					pad.drawLine(k, l + j2 * 3, k, l + j2 * 3 + 1);

				pad.drawLine(k, j1, k, j1);
				break;
			}
			for (int k2 = 0; k2 < Math.abs(k - i1) / 3; k2++)
				pad.drawLine(k + k2 * 3, l, k + k2 * 3 + 1, l);

			pad.drawLine(i1, l, i1, l);
			break;

		case 4: // '\004'
			if (k == i1) {
				for (int l2 = 0; l2 < Math.abs(l - j1) / 5; l2++)
					pad.drawLine(k, l + l2 * 5, k, l + l2 * 5 + 3);

				pad.drawLine(k, j1, k, j1);
				break;
			}
			for (int i3 = 0; i3 < Math.abs(k - i1) / 5; i3++)
				pad.drawLine(k + i3 * 5, l, k + i3 * 5 + 3, l);

			pad.drawLine(i1, l, i1, l);
			break;

		default:
			pad.drawLine(k, l, i1, j1);
			break;
		}
	}

	public static void Draw3Dgrid(Image image, Color color, int k, int l,
			int i1, int j1, int k1, int l1, int i2, int j2) {
		pad = image.getGraphics();
		pad.setColor(color);
		int i3 = (7 * j2) / 10;
		int j3 = k * k1;
		int k3 = l * l1;
		k1++;
		l1++;
		for (int k2 = 0; k2 < l1; k2++)
			drawgridline(image, i1 + i3 + k2 * l, j1 - i3 - j3, i1 + i3 + k2
					* l, j1 - i3, color, i2);

		for (int l2 = 0; l2 < k1; l2++) {
			drawgridline(image, i1 + i3, j1 - i3 - l2 * k, i1 + i3 + k3, j1
					- i3 - l2 * k, color, i2);
			drawgridline(image, i1, j1 - l2 * k, i1 + i3, j1 - i3 - l2 * k,
					color, 1);
		}

	}

	public static void Drawline(Image image, int k, int l, int i1, int j1,
			Color color) {
		pad = image.getGraphics();
		pad.setColor(color);
		pad.drawLine(k, l, i1, j1);
	}

	public static void Draw2Dgrid(Image image, Color color, int k, int l,
			int i1, int j1, int k1, int l1, int i2) {
		pad = image.getGraphics();
		pad.setColor(color);
		int l2 = k * k1;
		int i3 = l * l1;
		k1++;
		l1++;
		for (int j2 = 0; j2 < l1; j2++)
			drawgridline(image, i1 + j2 * l, j1 - l2, i1 + j2 * l, j1, color,
					i2);

		for (int k2 = 0; k2 < k1; k2++)
			drawgridline(image, i1, j1 - k2 * k, i1 + i3, j1 - k2 * k, color,
					i2);

	}

	public linechart() {
	}

	public static void Draw3Daxis(Image image, Color color, int k, int l,
			int i1, int j1, int k1, int l1, Color color1) {
		pad = image.getGraphics();
		int i2 = (7 * l1) / 10;
		xpoints1 = new int[4];
		ypoints1 = new int[4];
		xpoints1[0] = k;
		ypoints1[0] = l;
		xpoints1[1] = k + i1;
		ypoints1[1] = l;
		xpoints1[2] = k + i1 + i2;
		ypoints1[2] = l - i2;
		xpoints1[3] = k + i2;
		ypoints1[3] = l - i2;
		pad.setColor(color1);
		pad.fillPolygon(xpoints1, ypoints1, 4);
		pad.setColor(color);
		pad.drawLine(k, l, k + i1, l);
		pad.drawLine(k, l, k, l - j1);
		pad.drawLine(k, l, k, l + k1);
		pad.drawLine(k + i2, l - i2, k + i1 + i2, l - i2);
		pad.drawLine(k + i2, l - i2, k + i2, l - j1 - i2);
		pad.drawLine(k + i2, l - i2, k + i2, (l + k1) - i2);
		pad.drawLine(k, l, k + i2, l - i2);
		pad.drawLine(k, l - j1, k + i2, l - i2 - j1);
		pad.drawLine(k, l + k1, k + i2, (l - i2) + k1);
		pad.drawLine(k + i1, l, k + i2 + i1, l - i2);
	}

	public static void DrawPoint(Image image, int k, int l, Color color,
			int ai[], boolean flag) {
		pad = image.getGraphics();
		pad.setColor(color);
		switch (ai[0]) {
		case 1: // '\001'
			pad.drawLine(k - ai[1] / 2, l, k + ai[1] / 2, l);
			pad.drawLine(k, l - ai[1] / 2, k, l + ai[1] / 2);
			break;

		case 2: // '\002'
			pad.drawLine(k - ai[1] / 2, l - ai[1] / 2, k + ai[1] / 2, l + ai[1]
					/ 2);
			pad.drawLine(k - ai[1] / 2, l + ai[1] / 2, k + ai[1] / 2, l - ai[1]
					/ 2);
			break;

		case 3: // '\003'
			if (flag)
				pad.fillRect(k - ai[1] / 2, l - ai[1] / 2, ai[1], ai[1]);
			else
				pad.drawRect(k - ai[1] / 2, l - ai[1] / 2, ai[1], ai[1]);
			break;

		case 4: // '\004'
			int ai1[] = new int[3];
			int ai4[] = new int[3];
			ai1[0] = k;
			ai4[0] = l - ai[1] / 2;
			ai1[1] = k - ai[1] / 2;
			ai4[1] = l + ai[1] / 2;
			ai1[2] = k + ai[1] / 2;
			ai4[2] = l + ai[1] / 2;
			if (flag)
				pad.fillPolygon(ai1, ai4, 3);
			else
				pad.drawPolygon(ai1, ai4, 3);
			break;

		case 5: // '\005'
			int ai2[] = new int[4];
			int ai5[] = new int[4];
			ai2[0] = k;
			ai5[0] = l - ai[1] / 2;
			ai2[1] = k - ai[1] / 2;
			ai5[1] = l;
			ai2[2] = k;
			ai5[2] = l + ai[1] / 2;
			ai2[3] = k + ai[1] / 2;
			ai5[3] = l;
			if (flag)
				pad.fillPolygon(ai2, ai5, 4);
			else
				pad.drawPolygon(ai2, ai5, 4);
			break;

		case 6: // '\006'
			if (flag)
				pad.fillOval(k - ai[1] / 2, l - ai[1] / 2, ai[1], ai[1]);
			else
				pad.drawOval(k - ai[1] / 2, l - ai[1] / 2, ai[1], ai[1]);
			break;

		case 7: // '\007'
			int ai3[] = new int[6];
			int ai6[] = new int[6];
			ai3[0] = k - ai[1] / 4;
			ai6[0] = l - ai[1] / 2;
			ai3[1] = k - ai[1] / 2;
			ai6[1] = l;
			ai3[2] = k - ai[1] / 4;
			ai6[2] = l + ai[1] / 2;
			ai3[3] = k + ai[1] / 4;
			ai6[3] = l + ai[1] / 2;
			ai3[4] = k + ai[1] / 2;
			ai6[4] = l;
			ai3[5] = k + ai[1] / 4;
			ai6[5] = l - ai[1] / 2;
			if (flag)
				pad.fillPolygon(ai3, ai6, 6);
			else
				pad.drawPolygon(ai3, ai6, 6);
			break;

		default:
			pad.drawLine(k, l, k, l);
			break;
		}
	}

	public static void linechart(Image image, double ad[][], boolean aflag[][],
			boolean aflag1[][], String as[], int ai[], int ai1[][],
			Image aimage[], double d, double d1, Color acolor[], int ai2[][],
			boolean aflag2[], boolean aflag3[], int ai3[], String as1[],
			int ai4[][], Font afont[], Color acolor1[], String as2[],
			Color acolor2[], int ai5[][], double ad1[][], String as3[],
			Font afont1[]) {
		System.out.println("acolor = " + acolor);
		int k = ai3[4];
		pad = image.getGraphics();
		for (i = 0; i < 5; i++)
			if (aimage[i] != null)
				pad.drawImage(aimage[i], ai1[i][0], ai1[i][1], Iobs);

		if (aflag3[1])
			if (aflag3[0])
				Draw3Dgrid(image, acolor1[13], ai3[2], k, ai3[5], ai3[6],
						ai3[1], ai3[0], ai3[11], ai3[7]);
			else
				Draw2Dgrid(image, acolor1[13], ai3[2], k, ai3[5], ai3[6],
						ai3[1], ai3[0], ai3[11]);
		if (aflag3[2]) {
			dTemp = (new Double(ai3[2])).doubleValue();
			if (d < 0.0D)
				yTemp = ai3[6] + (int) Math.round((dTemp * d) / d1);
			else
				yTemp = ai3[6];
			if (aflag3[0])
				Draw3Daxis(image, acolor1[14], ai3[5], yTemp, k * ai3[0],
						(ai3[2] * ai3[1] - ai3[6]) + yTemp, ai3[6] - yTemp,
						ai3[7], acolor1[15]);
			else
				DrawAxis(image, acolor1[14], ai3[5], yTemp, k * ai3[0], (ai3[2]
						* ai3[1] - ai3[6])
						+ yTemp, ai3[6] - yTemp);
		}
		if (as1[10] != "")
			DrawLabel(image, as1[10], afont[10], acolor1[10], ai4[10][0],
					ai4[10][1], 0);
		if (as1[11] != "")
			DrawLabel(image, as1[11], afont[11], acolor1[11], ai4[11][0],
					ai4[11][1], 0);
		if (as1[12] != "")
			DrawLabel(image, as1[12], afont[12], acolor1[12], ai4[12][0],
					ai4[12][1], 1);
		for (i = 0; i < ai3[0]; i++)
			if (as[i] != "")
				DrawLabel(image, as[i], afont[14], acolor1[17], ai3[5] + 5 + i
						* k, ai3[10] + ai[i], ai3[9]);

		if (aflag3[3])
			for (i = 0; i < ai3[1] + 1; i++) {
				dTemp = (new Double(i)).doubleValue();
				dTemp = d + dTemp * d1;
				sTemp = DoubleToStr(dTemp, ai3[8]);
				sTemp = FormatStr(sTemp, -1, 2);
				DrawLabel(image, sTemp, afont[13], acolor1[17], ai3[5] - 5,
						ai3[6] - i * ai3[2], 4);
			}

		if (aflag3[5]) {
			int l = ai4[13][0];
			int i1 = ai4[13][1];
			pad.setFont(afont[15]);
			FontMetrics fontmetrics = pad.getFontMetrics();
			int j1 = 0;
			int k1 = 0;
			int l1 = 0;
			if (as1[13] != null)
				l1 = fontmetrics.stringWidth(as1[13]);
			for (i = 0; i < ai3[3]; i++)
				if (as2[i] != null && fontmetrics.stringWidth(as2[i]) > l1)
					l1 = fontmetrics.stringWidth(as2[i]);

			j1 = l1 + 45;
			int i2 = 15;
			if (fontmetrics.getHeight() > i2)
				i2 = fontmetrics.getHeight();
			k1 = 20 + (i2 + 10) * ai3[3];
			if (as1[13] != null)
				k1 = k1 + fontmetrics.getHeight() + 10;
			pad.setColor(acolor1[20]);
			pad.fillRect(l, i1, j1, k1);
			pad.setColor(acolor1[21]);
			pad.drawRect(l, i1, j1, k1);
			i1 += 10;
			if (as1[13] != null) {
				i1 += fontmetrics.getHeight();
				pad.setColor(acolor1[22]);
				pad.drawString(as1[13], (l + j1 / 2)
						- fontmetrics.stringWidth(as1[13]) / 2, i1);
				i1 += 10;
			}
			for (i = 0; i < ai3[3]; i++) {
				i1 += i2;
				if (as2[i] != null) {
					pad.setColor(acolor1[22]);
					pad.drawString(as2[i], l + 35, i1);
				}
				pad.setColor(acolor[i]);
				pad.fillRect(l + 10, i1 - 15, 15, 15);
				pad.setColor(acolor1[21]);
				pad.drawRect(l + 10, i1 - 15, 15, 15);
				i1 += 10;
			}

		}
		dTemp = (new Double(ai3[2])).doubleValue();
		for (i = 1; i < ai3[0]; i++)
			for (j = 0; j < ai3[3]; j++)
				if (!aflag[i][j] && !aflag[i - 1][j]) {
					yTemp = ai3[6]
							- (int) Math.round((dTemp * (ad[i - 1][j] - d))
									/ d1);
					yTemp2 = ai3[6]
							- (int) Math.round((dTemp * (ad[i][j] - d)) / d1);
					xTemp = ai3[5] + (i - 1) * k + k / 2;
					xTemp2 = ai3[5] + i * k + k / 2;
					if (aflag3[0])
						Draw3Dline(image, xTemp, yTemp, xTemp2, yTemp2, ai3[7],
								acolor[j], aflag3[4]);
					else
						Drawline(image, xTemp, yTemp, xTemp2, yTemp2, acolor[j]);
				}

		for (i = 0; i < ai3[0]; i++)
			for (j = 0; j < ai3[3]; j++)
				if (!aflag[i][j]) {
					yTemp = ai3[6]
							- (int) Math.round((dTemp * (ad[i][j] - d)) / d1);
					xTemp = ai3[5] + i * k + k / 2;
					DrawPoint(image, xTemp, yTemp, acolor[j], ai2[j], aflag2[j]);
				}

		for (i = 0; i < 10; i++)
			if (ai5[i][1] > 0) {
				yTemp = ai3[6]
						- (int) Math.round((dTemp * (ad1[i][0] - d)) / d1);
				yTemp2 = ai3[6]
						- (int) Math.round((dTemp * (ad1[i][1] - d)) / d1);
				xTemp = ai3[5] + (ai5[i][1] - 1) * k + k / 2;
				xTemp2 = ai3[5] + (ai5[i][2] - 1) * k + k / 2;
				pad.setColor(acolor2[i]);
				pad.drawLine(xTemp, yTemp, xTemp2, yTemp2);
				DrawLabel(image, as3[i], afont1[i], acolor2[i], xTemp2,
						yTemp2 - 5, 0);
			}

		for (i = 10; i < 20; i++)
			if (ai5[i][1] > 0) {
				yTemp = ai3[6]
						- (int) Math.round((dTemp * (ad1[i][0] - d)) / d1);
				xTemp = ai3[5] + (ai5[i][1] - 1) * k + k / 2;
				xTemp2 = ai3[5] + (ai5[i][2] - 1) * k + k / 2;
				drawgridline(image, xTemp, yTemp, xTemp2, yTemp, acolor2[i],
						ai5[i][0]);
				DrawLabel(image, as3[i], afont1[i], acolor2[i], xTemp,
						yTemp - 5, 0);
			}

		for (i = 5; i < 10; i++)
			if (aimage[i] != null)
				pad.drawImage(aimage[i], ai1[i][0], ai1[i][1], Iobs);

		for (i = 0; i < 10; i++)
			if (as1[i] != "")
				DrawLabel(image, as1[i], afont[i], acolor1[i], ai4[i][0],
						ai4[i][1], 0);

		for (i = 0; i < ai3[0]; i++)
			for (j = 0; j < ai3[3]; j++)
				if (!aflag[i][j]) {
					yTemp = ai3[6]
							- (int) Math.round((dTemp * (ad[i][j] - d)) / d1);
					xTemp = ai3[5] + i * k + k / 2;
					if (aflag1[i][j]) {
						sTemp = DoubleToStr(ad[i][j], ai3[8]);
						sTemp = FormatStr(sTemp, -1, 2);
						DrawTextBox(image, sTemp, afont[13], acolor1[17],
								acolor1[19], xTemp + 5, yTemp - 5);
						DrawLabel(image, sTemp, afont[13], acolor1[17],
								xTemp + 5, yTemp - 5, 0);
					}
				}

	}

	public static void DrawAxis(Image image, Color color, int k, int l, int i1,
			int j1, int k1) {
		pad = image.getGraphics();
		pad.setColor(color);
		pad.drawLine(k, l, k + i1, l);
		pad.drawLine(k, l, k, l - j1);
		pad.drawLine(k, l, k, l + k1);
	}

	public static void Draw3Dline(Image image, int k, int l, int i1, int j1,
			int k1, Color color, boolean flag) {
		pad = image.getGraphics();
		int l1 = (7 * k1) / 10;
		xpoints1 = new int[4];
		ypoints1 = new int[4];
		xpoints1[0] = k;
		ypoints1[0] = l;
		xpoints1[1] = k + l1;
		ypoints1[1] = l - l1;
		xpoints1[2] = i1 + l1;
		ypoints1[2] = j1 - l1;
		xpoints1[3] = i1;
		ypoints1[3] = j1;
		if (l < j1)
			pad.setColor(color.darker());
		else
			pad.setColor(color.brighter());
		pad.fillPolygon(xpoints1, ypoints1, 4);
		if (flag) {
			pad.setColor(color);
			pad.drawPolygon(xpoints1, ypoints1, 4);
		}
	}

	public static void DrawTextBox(Image image, String s, Font font,
			Color color, Color color1, int k, int l) {
		pad = image.getGraphics();
		pad.setFont(font);
		FontMetrics fontmetrics = pad.getFontMetrics();
		pad.setColor(color1);
		pad.fillRect(k - 4, l - fontmetrics.getHeight(), fontmetrics
				.stringWidth(s) + 8, fontmetrics.getHeight() + 4);
		pad.setColor(color);
		pad.drawRect(k - 4, l - fontmetrics.getHeight(), fontmetrics
				.stringWidth(s) + 8, fontmetrics.getHeight() + 4);
	}

	public static void DrawLabel(Image image, String s, Font font, Color color,
			int k, int l, int i1) {
		pad = image.getGraphics();
		pad.setColor(color);
		pad.setFont(font);
		FontMetrics fontmetrics = pad.getFontMetrics();
		int i2 = s.length();
		// boolean flag = false;
		switch (i1) {
		case 1: // '\001'
			int j2 = fontmetrics.getHeight();
			for (int j1 = 0; j1 < i2; j1++) {
				String s1 = s.substring(j1, j1 + 1);
				pad.drawString(s1, k, l - j2 * (i2 - j1));
			}

			break;

		case 2: // '\002'
			int k2 = (7 * fontmetrics.getHeight()) / 10;
			for (int k1 = 0; k1 < i2; k1++) {
				String s2 = s.substring(k1, k1 + 1);
				pad.drawString(s2, k + k1 * k2, l - k1 * k2);
			}

			break;

		case 3: // '\003'
			int l2 = fontmetrics.getHeight();
			for (int l1 = 0; l1 < i2; l1++) {
				String s3 = s.substring(l1, l1 + 1);
				pad.drawString(s3, k, l - l1 * l2);
			}

			break;

		case 4: // '\004'
			pad.drawString(s, k - fontmetrics.stringWidth(s), l);
			break;

		case 5: // '\005'
			pad.drawString(s, k, l + fontmetrics.getHeight());
			break;

		default:
			pad.drawString(s, k, l);
			break;
		}
	}

	private static Graphics pad;

	private static int i;

	private static int j;

	private static int xTemp;

	private static int yTemp;

	private static int xTemp2;

	private static int yTemp2;

	private static double dTemp;

	private static String sTemp;

	private static ImageObserver Iobs;

	private static int xpoints1[];

	private static int ypoints1[];
	// private static int xpoints2[];
	// private static int ypoints2[];
}
