/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// ** I18N

// Calendar EN language
// Author: Mihai Bazon, <mihai_bazon@yahoo.com>
// Translation: Yourim Yi <yyi@yourim.net>
// Encoding: EUC-KR
// lang : ko
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

// full day names

Calendar._DN = new Array
("์?ผ์์?ผ",
 "์์์?ผ",
 "ํ์์?ผ",
 "์์์?ผ",
 "๋ชฉ์์?ผ",
 "๊ธ์์?ผ",
 "ํ ์์?ผ",
 "์?ผ์์?ผ");

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
("์?ผ",
 "์",
 "ํ",
 "์",
 "๋ชฉ",
 "๊ธ",
 "ํ ",
 "์?ผ");

// full month names
Calendar._MN = new Array
("1์",
 "2์",
 "3์",
 "4์",
 "5์",
 "6์",
 "7์",
 "8์",
 "9์",
 "10์",
 "11์",
 "12์");

// short month names
Calendar._SMN = new Array
("1",
 "2",
 "3",
 "4",
 "5",
 "6",
 "7",
 "8",
 "9",
 "10",
 "11",
 "12");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "calendar ์? ๋ํด์";

Calendar._TT["ABOUT"] =
"DHTML Date/Time Selector\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"\n"+
"์ต์  ๋ฒ์ ์? ๋ฐ์ผ์๋ ค๋ฉด http://www.dynarch.com/projects/calendar/ ์? ๋ฐฉ๋ฌธํ์ธ์\n" +
"\n"+
"GNU LGPL ๋?ผ์?ด์ผ์ค๋ก ๋ฐฐํ?ฌ๋?ฉ๋๋ค. \n"+
"๋?ผ์?ด์ผ์ค์? ๋ํ ์?์ธํ ๋ด์ฉ์? http://gnu.org/licenses/lgpl.html ์? ์?ฝ์ผ์ธ์." +
"\n\n" +
"๋ ์ง ์ ํ?:\n" +
"- ์ฐ๋?๋ฅผ ์ ํ?ํ๋ ค๋ฉด \xab, \xbb ๋ฒํผ์? ์ฌ์ฉํฉ๋๋ค\n" +
"- ๋ฌ์? ์ ํ?ํ๋ ค๋ฉด " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " ๋ฒํผ์? ๋๋ฅด์ธ์\n" +
"- ๊ณ์? ๋๋ฅด๊ณ  ์์ผ๋ฉด ์ ๊ฐ๋ค์? ๋น ๋ฅด๊ฒ ์ ํ?ํ์ค ์ ์์ต๋๋ค.";
Calendar._TT["ABOUT_TIME"] = "\n\n" +
"์๊ฐ ์ ํ?:\n" +
"- ๋ง์ฐ์ค๋ก ๋๋ฅด๋ฉด ์๊ฐ์?ด ์ฆ?๊ฐํฉ๋๋ค\n" +
"- Shift ํค์ ํจ๊ป ๋๋ฅด๋ฉด ๊ฐ?์ํฉ๋๋ค\n" +
"- ๋๋ฅธ ์?ํ์?์ ๋ง์ฐ์ค๋ฅผ ์์ง?์?ด๋ฉด ์ข ๋? ๋น ๋ฅด๊ฒ ๊ฐ์?ด ๋ณํฉ๋๋ค.\n";

Calendar._TT["PREV_YEAR"] = "์ง๋ ํด (๊ธธ๊ฒ ๋๋ฅด๋ฉด ๋ชฉ๋ก?)";
Calendar._TT["PREV_MONTH"] = "์ง๋ ๋ฌ (๊ธธ๊ฒ ๋๋ฅด๋ฉด ๋ชฉ๋ก?)";
Calendar._TT["GO_TODAY"] = "์ค๋ ๋ ์ง๋ก";
Calendar._TT["NEXT_MONTH"] = "๋ค์? ๋ฌ (๊ธธ๊ฒ ๋๋ฅด๋ฉด ๋ชฉ๋ก?)";
Calendar._TT["NEXT_YEAR"] = "๋ค์? ํด (๊ธธ๊ฒ ๋๋ฅด๋ฉด ๋ชฉ๋ก?)";
Calendar._TT["SEL_DATE"] = "๋ ์ง๋ฅผ ์ ํ?ํ์ธ์";
Calendar._TT["DRAG_TO_MOVE"] = "๋ง์ฐ์ค ๋๋๊ทธ๋ก ์?ด๋? ํ์ธ์";
Calendar._TT["PART_TODAY"] = " (์ค๋)";
Calendar._TT["MON_FIRST"] = "์์์?ผ์? ํ ์ฃผ์? ์์ ์์?ผ๋ก";
Calendar._TT["SUN_FIRST"] = "์?ผ์์?ผ์? ํ ์ฃผ์? ์์ ์์?ผ๋ก";
Calendar._TT["CLOSE"] = "๋ซ๊ธฐ";
Calendar._TT["TODAY"] = "์ค๋";
Calendar._TT["TIME_PART"] = "(Shift-)ํ?ด๋ฆญ ๋?๋ ๋๋๊ทธ ํ์ธ์";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%Y-%m-%d";
Calendar._TT["TT_DATE_FORMAT"] = "%b/%e [%a]";

Calendar._TT["WK"] = "์ฃผ";
