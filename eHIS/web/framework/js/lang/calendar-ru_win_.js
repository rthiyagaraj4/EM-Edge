/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// ** I18N

// Calendar RU language
// Translation: Sly Golovanov, http://golovanov.net, <sly@golovanov.net>
// Encoding: any
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

// full day names
Calendar._DN = new Array
("�����������",
 "�����������",
 "�������",
 "�����",
 "�������",
 "�������",
 "�������",
 "�����������");

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary.  We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
//   Calendar._SDN_len = N; // short day name length
//   Calendar._SMN_len = N; // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
Calendar._SDN = new Array
("���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���");

// full month names
Calendar._MN = new Array
("������",
 "�������",
 "����",
 "������",
 "���",
 "����",
 "����",
 "������",
 "��������",
 "�������",
 "������",
 "�������");

// short month names
Calendar._SMN = new Array
("���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���",
 "���");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "� ���������...";

Calendar._TT["ABOUT"] =
"DHTML Date/Time Selector\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"For latest version visit: http://www.dynarch.com/projects/calendar/\n" +
"Distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"��� ������� ����:\n" +
"- ��� ������ ������ \xab, \xbb ����� ������� ���\n" +
"- ��� ������ ������ " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " ����� ������� �����\n" +
"- ��������� ��� ������ ��������, ����� ��������� ���� �������� ������.";
Calendar._TT["ABOUT_TIME"] = "\n\n" +
"��� ������� �����:\n" +
"- ��� ����� �� ����� ��� ������� ��� �������������\n" +
"- ��� ����� � ������� �������� Shift ��� �����������\n" +
"- ���� ������ � ������� ������ �����/������, ��� ����� �������� �������.";

Calendar._TT["PREV_YEAR"] = "�� ��� ����� (���������� ��� ����)";
Calendar._TT["PREV_MONTH"] = "�� ����� ����� (���������� ��� ����)";
Calendar._TT["GO_TODAY"] = "�������";
Calendar._TT["NEXT_MONTH"] = "�� ����� ������ (���������� ��� ����)";
Calendar._TT["NEXT_YEAR"] = "�� ��� ������ (���������� ��� ����)";
Calendar._TT["SEL_DATE"] = "�������� ����";
Calendar._TT["DRAG_TO_MOVE"] = "�������������� ������";
Calendar._TT["PART_TODAY"] = " (�������)";

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
Calendar._TT["DAY_FIRST"] = "������ ���� ������ ����� %s";

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
Calendar._TT["WEEKEND"] = "0,6";

Calendar._TT["CLOSE"] = "�������";
Calendar._TT["TODAY"] = "�������";
Calendar._TT["TIME_PART"] = "(Shift-)���� ��� ������ � �������";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%Y-%m-%d";
Calendar._TT["TT_DATE_FORMAT"] = "%e %b, %a";

Calendar._TT["WK"] = "���";
Calendar._TT["TIME"] = "�����:";
