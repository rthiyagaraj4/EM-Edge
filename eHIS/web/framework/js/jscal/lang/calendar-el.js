
// ** I18N
Calendar._DN = new Array
("ÎšÏ…Ï�Î¹Î±ÎºÎ®",
 "Î”ÎµÏ…Ï„Î­Ï�Î±",
 "Î¤Ï�Î¯Ï„Î·",
 "Î¤ÎµÏ„Î¬Ï�Ï„Î·",
 "Î Î­Î¼Ï€Ï„Î·",
 "Î Î±Ï�Î±ÏƒÎºÎµÏ…Î®",
 "Î£Î¬Î²Î²Î±Ï„Î¿",
 "ÎšÏ…Ï�Î¹Î±ÎºÎ®");

Calendar._SDN = new Array
("ÎšÏ…",
 "Î”Îµ",
 "TÏ�",
 "Î¤Îµ",
 "Î Îµ",
 "Î Î±",
 "Î£Î±",
 "ÎšÏ…");

Calendar._MN = new Array
("Î™Î±Î½Î¿Ï…Î¬Ï�Î¹Î¿Ï‚",
 "Î¦ÎµÎ²Ï�Î¿Ï…Î¬Ï�Î¹Î¿Ï‚",
 "ÎœÎ¬Ï�Ï„Î¹Î¿Ï‚",
 "Î‘Ï€Ï�Î¯Î»Î¹Î¿Ï‚",
 "ÎœÎ¬ÏŠÎ¿Ï‚",
 "Î™Î¿Ï�Î½Î¹Î¿Ï‚",
 "Î™Î¿Ï�Î»Î¹Î¿Ï‚",
 "Î‘Ï�Î³Î¿Ï…ÏƒÏ„Î¿Ï‚",
 "Î£ÎµÏ€Ï„Î­Î¼Î²Ï�Î¹Î¿Ï‚",
 "ÎŸÎºÏ„ÏŽÎ²Ï�Î¹Î¿Ï‚",
 "Î�Î¿Î­Î¼Î²Ï�Î¹Î¿Ï‚",
 "Î”ÎµÎºÎ­Î¼Î²Ï�Î¹Î¿Ï‚");

Calendar._SMN = new Array
("Î™Î±Î½",
 "Î¦ÎµÎ²",
 "ÎœÎ±Ï�",
 "Î‘Ï€Ï�",
 "ÎœÎ±Î¹",
 "Î™Î¿Ï…Î½",
 "Î™Î¿Ï…Î»",
 "Î‘Ï…Î³",
 "Î£ÎµÏ€",
 "ÎŸÎºÏ„",
 "Î�Î¿Îµ",
 "Î”ÎµÎº");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "Î“Î¹Î± Ï„Î¿ Î·Î¼ÎµÏ�Î¿Î»ÏŒÎ³Î¹Î¿";

Calendar._TT["ABOUT"] =
"Î•Ï€Î¹Î»Î¿Î³Î­Î±Ï‚ Î·Î¼ÎµÏ�Î¿Î¼Î·Î½Î¯Î±Ï‚/ÏŽÏ�Î±Ï‚ ÏƒÎµ DHTML\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"Î“Î¹Î± Ï„ÎµÎ»ÎµÏ…Ï„Î±Î¯Î± Î­ÎºÎ´Î¿ÏƒÎ·: http://www.dynarch.com/projects/calendar/\n" +
"Distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"Î•Ï€Î¹Î»Î¿Î³Î® Î·Î¼ÎµÏ�Î¿Î¼Î·Î½Î¯Î±Ï‚:\n" +
"- Î§Ï�Î·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹ÎµÎ¯ÏƒÏ„Îµ Ï„Î± ÎºÎ¿Ï…Î¼Ï€Î¹Î¬ \xab, \xbb Î³Î¹Î± ÎµÏ€Î¹Î»Î¿Î³Î® Î­Ï„Î¿Ï…Ï‚\n" +
"- Î§Ï�Î·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹ÎµÎ¯ÏƒÏ„Îµ Ï„Î± ÎºÎ¿Ï…Î¼Ï€Î¹Î¬ " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " Î³Î¹Î± ÎµÏ€Î¹Î»Î¿Î³Î® Î¼Î®Î½Î±\n" +
"- ÎšÏ�Î±Ï„Î®ÏƒÏ„Îµ ÎºÎ¿Ï…Î¼Ï€Î¯ Ï€Î¿Î½Ï„Î¹ÎºÎ¿Ï� Ï€Î±Ï„Î·Î¼Î­Î½Î¿ ÏƒÏ„Î± Ï€Î±Ï�Î±Ï€Î¬Î½Ï‰ ÎºÎ¿Ï…Î¼Ï€Î¹Î¬ Î³Î¹Î± Ï€Î¹Î¿ Î³Ï�Î®Î³Î¿Ï�Î· ÎµÏ€Î¹Î»Î¿Î³Î®.";
Calendar._TT["ABOUT_TIME"] = "\n\n" +
"Î•Ï€Î¹Î»Î¿Î³Î® ÏŽÏ�Î±Ï‚:\n" +
"- ÎšÎ¬Î½Ï„Îµ ÎºÎ»Î¹Îº ÏƒÎµ Î­Î½Î± Î±Ï€ÏŒ Ï„Î± Î¼Î­Ï�Î· Ï„Î·Ï‚ ÏŽÏ�Î±Ï‚ Î³Î¹Î± Î±Ï�Î¾Î·ÏƒÎ·\n" +
"- Î® Shift-ÎºÎ»Î¹Îº Î³Î¹Î± Î¼ÎµÎ¯Ï‰ÏƒÎ·\n" +
"- Î® ÎºÎ»Î¹Îº ÎºÎ±Î¹ Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Î³Î¹Î± Ï€Î¹Î¿ Î³Ï�Î®Î³Î¿Ï�Î· ÎµÏ€Î¹Î»Î¿Î³Î®.";
Calendar._TT["TOGGLE"] = "ÎœÏ€Î¬Ï�Î± Ï€Ï�ÏŽÏ„Î·Ï‚ Î·Î¼Î­Ï�Î±Ï‚ Ï„Î·Ï‚ ÎµÎ²Î´Î¿Î¼Î¬Î´Î±Ï‚";
Calendar._TT["PREV_YEAR"] = "Î Ï�Î¿Î·Î³. Î­Ï„Î¿Ï‚ (ÎºÏ�Î±Ï„Î®ÏƒÏ„Îµ Î³Î¹Î± Ï„Î¿ Î¼ÎµÎ½Î¿Ï�)";
Calendar._TT["PREV_MONTH"] = "Î Ï�Î¿Î·Î³. Î¼Î®Î½Î±Ï‚ (ÎºÏ�Î±Ï„Î®ÏƒÏ„Îµ Î³Î¹Î± Ï„Î¿ Î¼ÎµÎ½Î¿Ï�)";
Calendar._TT["GO_TODAY"] = "Î£Î®Î¼ÎµÏ�Î±";
Calendar._TT["NEXT_MONTH"] = "Î•Ï€ÏŒÎ¼ÎµÎ½Î¿Ï‚ Î¼Î®Î½Î±Ï‚ (ÎºÏ�Î±Ï„Î®ÏƒÏ„Îµ Î³Î¹Î± Ï„Î¿ Î¼ÎµÎ½Î¿Ï�)";
Calendar._TT["NEXT_YEAR"] = "Î•Ï€ÏŒÎ¼ÎµÎ½Î¿ Î­Ï„Î¿Ï‚ (ÎºÏ�Î±Ï„Î®ÏƒÏ„Îµ Î³Î¹Î± Ï„Î¿ Î¼ÎµÎ½Î¿Ï�)";
Calendar._TT["SEL_DATE"] = "Î•Ï€Î¹Î»Î­Î¾Ï„Îµ Î·Î¼ÎµÏ�Î¿Î¼Î·Î½Î¯Î±";
Calendar._TT["DRAG_TO_MOVE"] = "Î£Ï�Ï�Ï„Îµ Î³Î¹Î± Î½Î± Î¼ÎµÏ„Î±ÎºÎ¹Î½Î®ÏƒÎµÏ„Îµ";
Calendar._TT["PART_TODAY"] = " (ÏƒÎ®Î¼ÎµÏ�Î±)";
Calendar._TT["MON_FIRST"] = "Î•Î¼Ï†Î¬Î½Î¹ÏƒÎ· Î”ÎµÏ…Ï„Î­Ï�Î±Ï‚ Ï€Ï�ÏŽÏ„Î±";
Calendar._TT["SUN_FIRST"] = "Î•Î¼Ï†Î¬Î½Î¹ÏƒÎ· ÎšÏ…Ï�Î¹Î±ÎºÎ®Ï‚ Ï€Ï�ÏŽÏ„Î±";
Calendar._TT["CLOSE"] = "ÎšÎ»ÎµÎ¯ÏƒÎ¹Î¼Î¿";
Calendar._TT["TODAY"] = "Î£Î®Î¼ÎµÏ�Î±";
Calendar._TT["TIME_PART"] = "(Shift-)ÎºÎ»Î¹Îº Î® Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Î³Î¹Î± Î±Î»Î»Î±Î³Î®";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "dd-mm-y";
Calendar._TT["TT_DATE_FORMAT"] = "D, d M";

Calendar._TT["WK"] = "ÎµÎ²Î´";

