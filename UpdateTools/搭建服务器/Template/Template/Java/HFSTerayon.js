// ------------------------------------------------------
// JavaScript for the HFS Terayon Template
//
// Created by Giant Eagle
// With the help of Flynsarmy and That_Stevens_Guy
// ------------------------------------------------------
//mp3 load script
var currMp3=null;
var mp3PlayerActive="0";
var flashMediaPlayer="0";
function loadMp3 (mp3) {
if (mp3PlayerActive != "1") {
	if(currMp3) 
		unloadMp3(escape(currMp3));
	currMp3=unescape(mp3);
	document.getElementById(currMp3).innerHTML = "<div id=\"mp3\"><object type=\"application/x-shockwave-flash\" width=\"140\" height=\"20\" data=\"/template/flash/mp3player2.swf?song="+currMp3+"&autoplay=1\" bgcolor=\"#FFFFFF\"><param name=\"movie\" value=\"/template/flash/mp3player2.swf?song="+currMp3+"&autoplay=1\"/><param name=\"bgcolor\" value=\"#FFFFFF\"/></object><br><a style=\"cursor:pointer;\" onclick=unloadMp3(\'"+escape(currMp3)+"\')><img src=\"/template/icons/quicklink/flashEND.gif\" border=\"0\" height=\"24\" width=\"24\"/></a></div>";
} else	{ 
	currMp3=unescape(mp3);
	document.getElementById(currMp3).innerHTML = "<div id=\"mp3\">You can't use 2 different Flash players at the same time!<br /><a style=\"cursor:pointer;\" onclick=unloadMp3(\'"+escape(currMp3)+"\')><img src=\"/template/icons/quicklink/flashEND.gif\" border=\"0\" height=\"24\" width=\"24\"/></a></div>";
	}
}
//mp3 unload script
function unloadMp3 (mp3) {
	currMp3=null;
	document.getElementById(unescape(mp3)).innerHTML = "<div id=\""+unescape(mp3)+"\"><a href=\"mms://"+infoHost+infoFolder+unescape(mp3)+"\"><img src=\"/template/icons/quicklink/wmp.gif\" alt=\"\" border=0 height=24 width=24/></a><img src=\"/template/images/spacer.gif\" width=16 height=0/><a style=\"cursor:pointer;\" onclick=loadMp3(\'"+mp3+"\');><img src=\"/template/icons/quicklink/flash.gif\" border=\"0\" height=\"24\" width=\"24\"/></a><img src=\"/template/images/spacer.gif\" width=16 height=0/><a href=\""+unescape(mp3)+"\"><img src=\"/template/icons/quicklink/download.gif\" alt=\"\" border=0 height=24 width=24/></a></div>";
}
//Browse-able folder tree script
function browseAbleFolderTree(folder) {
var infoFolder=folder;
var path=folder.split("/");
var pathTree="/";
var pathTreeResult="/<a href='/' >Home</a>";
for(pta=1;pta<path.length;pta++)
	{
	pathTree=pathTree+path[pta]+"/";
	pathTreeResult=pathTreeResult +'/<a href="'+pathTree+'" class=\"swapDir\">'+path[pta]+'</a>';
	}
document.write(pathTreeResult);
}