<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<script language="javascript">
document.write ('<title>欢迎光临 :: '+('%folder%'=='/' ? '哈尔滨海铭科技' : '%folder-name%')+'</title>');
</script>
<link rel="stylesheet" type="text/css" href="/template/css/style.css" />
<script type="text/javascript" src="/template/java/highslide.js"></script>
<script type="text/javascript" src="/template/java/ufo.js"></script>
<script type="text/javascript" src="/template/java/hfsterayon.js"></script>
<script type="text/javascript">var infoFolder="%folder%"; var infoHost="%host%";</script>

<script type="text/javascript"> <!-- this is used by the Flash Media Player to call a flash file externally..-->
function sendEvent(typ,prm) {thisMovie("mediaplayer").sendEvent(typ,prm);
};
function loadFile(fil) {
	thisMovie("mediaplayer").loadFile(fil);
};
function thisMovie(movieName) {
    if(navigator.appName.indexOf("Microsoft") != -1) {
		return window[movieName];
	} else {
		return document[movieName];
	}
};
function getUpdate(typ,pr1,pr2) {
	var id = document.getElementById(typ);
	id.innerHTML = typ+ ": "+Math.round(pr1);
	pr2 == undefined ? null: id.innerHTML += ", "+Math.round(pr2);
};
</script>

<script language="JavaScript" type="text/javascript"> <!-- this is used by the Image Previewer -->
	// remove the registerOverlay call to disable the controlbar
	hs.registerOverlay(
    	{
    		thumbnailId: null,
    		overlayId: 'controlbar',
    		position: 'bottom left',
    		hideOnMouseOut: true,
    		opacity: 0.75
		}
	);
	
    hs.graphicsDir = '/template/images/';
    hs.outlineType = 'highslide';
    window.onload = function() {
        hs.preloadImages(5);
    }

</script>


</head>
<body>
<img src="/template/images/cellpic3.gif" style="visibility: hidden;" width="0" height="0" alt="" /> <!-- Used to pre-load this image -->
<div id="highslide-container"></div>
<a name="top"></a> 

<table width="80%" cellspacing="0" cellpadding="10" border="0" align="center"> 
<tr> 
<td class="bodyline">
<table width="100%" background="/template/images/top2.jpg" bgcolor="#7A9ADE" cellspacing="0" cellpadding="0" border="0" align="center" height="78" nowrap="nowrap">
	<tr> 
		<td width="95" align="left" height="78"><img src="/template/images/top.jpg" alt="top" /></td>
		<td width="100%" align="center" height="78"><span class=MessageHeader><FONT face=楷体_GB2312 color=0A04FB><FONT size=5>Http://%host%/</span></td>
		<td width="95" align="right" height="78"><img src="/template/images/top1.jpg" alt="top1" /></td>
	</tr>
</table>
<br />

<table class="forumline" width="100%" cellspacing="1" cellpadding="4" border="0">
	<tr> 
		<td class="catLeft" colspan="5" height="28">
			<span class="cattitle">
				<FONT face=楷体_GB2312 color=#ff0000><FONT size=6> 上传文件过程中不要关闭网页!!! 祝哈尔滨海铭科技的同事们每天开心快乐!
				<span id="messageTitle"></span>
			</span>
		</td>
	</tr>
	<tr> 
		<td height="23" class="nav1" align="center">
			<span class="nav_top"> 
				<a href="/">首页</a> &#8226; 
				<a href="">刷新</a> &#8226;
				<a href="">当前用户: [%user%]</a> 
				%login-link%
			</span>
		</td>
	</tr>
	<tr> 
		<td class="row4">
			<table width="100%" cellspacing="0" cellpadding="1" border="0">
				<tr> 
					<td>&nbsp;</td>
				</tr>
				<tr> 	
					<td width="50">&nbsp;</td>
					<td valign="top" width="100%">
<!-- MESSAGE STARTS HERE -->

<div class=MessageTextSmall>
        <script type="text/javascript">document.write("<FONT face=宋体 color=#ff0000><FONT size=4>当前路径:</div><div    class=MessageHeader>");
	document.write("%folder%"=="/" ? "<i>服务器首页</i>" : "%folder%");</script>
</div>
<br />
	<div class=MessageText>
		%folder-comment%
		&nbsp;
	</div>

<!-- MESSAGE ENDS HERE -->
					</td>
%style%
				</tr>
			</table>
		</td>
	</tr>
	<tr> 
	  	<td class="v2" colspan="5" height="15">&nbsp;</td><script type="text/javascript">mp3PlayerActive == "1" ? document.getElementById('messageTitle').innerHTML = "and Mp3 Player" : flashMediaPlayer == "1" ? document.getElementById('messageTitle').innerHTML = "and Flash Media Player" : "";</script>
	</tr>
</table>
<br clear="all" /><br />
<!-- The files list -->
%files%
<br /><br />
<!-- IF you have upload rights, show the Upload List -->
%upload-link%
<!-- IF you are logged in, show the Server Stats -->
%loggedin%
	<table width="100%" cellpadding="3" cellspacing="1" border="0" class="forumline" align="center">
		<tr>
      <td align="right" class="copyright" height="28">
        Powered by <a href="http://192.168.1.88" target="_blank">Http File Server %version% build %build%</a> &copy; 2002, 2006 Rejetto
        <br />
        Terayon Theme v2B.02 <a href="http://192.168.1.88/" target="_blank">(phpBB theme)</a> created by <a href="http://192.168.1.88/" target="_blank">lithosphere</a>, Converted by <a href="http://192.168.1.88" target="_blank">Giant Eagle v1.2.1</a>, 汉化 by <a href="http://192.168.1.88" target="_blank">Garphy</a>&nbsp;
      </td>
    </tr>
	</table>
</td>
</tr>
</table>
</body>
</html>

[style]


[login-link]
 &#8226; <a href="~login">登陆</a> 

[loggedin]
<table class="forumline" width="100%" cellspacing="1" cellpadding="4" border="0">
	<tr> 
		<td class="catLeft" colspan="4" height="28"><span class="cattitle">FileServer :: Server Stats and Status</span></td>
	</tr>
  <tr> 
<th colspan="4" class="thTop" nowrap="nowrap">&nbsp;Powered by: <a href="http://192.168.1.88" target="_blank" class="ServerStats">Http File Server %version%</a></span>&nbsp;</th>
  </tr>
	<tr> 
		<td class="row4">
			<table width="100%" cellspacing="0" cellpadding="1" border="0">
				<tr> 
					<td>&nbsp;</td>
				</tr>
				<tr> 	
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td valign="top" align="center">
<!-- SERVER STATS BEGIN HERE -->

<div class=MessageText>
	服务器连接数: <span class="Response">[%connections%]</span> &#8226; 当前用户: <span class="Response">[%user%]</span>
	<br /><br />
	总上传速度: <span class="Response">[%speed-in% Kbp/s]</span> &#8226; 总下载速度: <span class="Response">[%speed-out% Kbp/s]</span>
	<br /><br />
	总上传数据量: <span class="Response">[%total-in%]</span> &#8226; 总下载数据量: <span class="Response">[%total-out%]</span>
	<br /><br />
	当前服务器时间: <span class="Response">[%timestamp%]</span> &#8226; 服务器在线时长: <span class="Response">[%uptime%]</span>
	<br /><br />
	载入页面耗时: <span class="response">[%build-time% Seconds]</span>
	<br />
	&nbsp;
</div>

<!-- SERVER STATS ENDS HERE -->
				</tr>
			</table>
		</td>
	</tr>
	<tr> 
	  	<td class="v2" colspan="4" height="15">&nbsp;</td>
	</tr>
</table>
<br /><br />

[upload-link]
<form name=frm action="%encoded-folder%" target="_parent" method=post enctype="multipart/form-data" onSubmit="frm.upbtn.disabled=true; return true;">
  <table width="100%" cellpadding="2" cellspacing="1" border="0" class="forumline">
  <tr> 
	<td class="catLeft" colspan="5" height="28"><span class="cattitle"><a href="%folder%" class="cattitle">文件服务器 :: 上传文件</a></span></td>
  </tr>
  <tr> 
	<th class="thTop" nowrap="nowrap" colspan="2">&nbsp;文件列表 1&nbsp;</th>
	<th class="thTop" nowrap="nowrap" colspan="2">&nbsp;文件列表 2&nbsp;</th>
  </tr>
  <!-- BEGIN forumrow -->
<tr>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload1" size="45" type="file" /></td>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload5" size="45" type="file" /></td>
	</tr>
	<tr>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload2" size="45" type="file" /></td>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload6" size="45" type="file" /></td>
	</tr>
	<tr>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload3" size="45" type="file" /></td>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload7" size="45" type="file" /></td>
	</tr>
	<tr>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload4" size="45" type="file" /></td>
	<td class="row7" width="30"><img src="/~img_file" /></td>
	<td class="row7" width="50%"> <input name="fileupload8" size="45" type="file" /></td>
	</tr>
  <!-- END forumrow -->
  <tr> 
  	<td class="v2" colspan="4" height="15" width="100%" align="center"><input name=upbtn type=submit value="开始上传文件"></td>
  </tr>
</table> 
</form>
<br /><br />

[up]
<span class="cattitle"> :: <script type="text/javascript">pathTreeArray = path.split('/'); for (i=1; i<pathTreeArray.length; i++) {pathTreeArray[i] = '/'+pathTreeArray[i]; pathTree = pathTree+pathTreeArray[i]; document.write('<a href="'+pathTree+'" class="cattitle">'+pathTreeArray[i]+'</a>')}; </script></span>

[test]
<!-- Backup of Up -->
<span class="cattitle"> :: <img src="/~img14" height="15"/><a href="%parent-folder%"> 上传目录</a></span>

[test]
<!-- ICON CONFIGURATION STARS HERE -->


[nofiles]
  <!-- BEGIN catrow -->
  <table width="100%" cellpadding="2" cellspacing="1" border="0" class="forumline">
  <tr> 
	<td class="catLeft" colspan="5" height="28"><span class="cattitle">FileServer :: 
<script type="text/javascript">
browseAbleFolderTree("%folder%");
</script>
</span></td>
  </tr>
  <tr>
	<th colspan="2" class="thCornerL" height="20" nowrap="nowrap"><img src="/template/images/spacer.gif" width="64" height="0" /><span class="thTop"><a href="%encoded-folder%?sort=n" class="ServerStats">&nbsp;文件名&nbsp;</a></span></th>
	<th width="215" class="thTop" nowrap="nowrap"><a href="%encoded-folder%?sort=s" class="ServerStats">&nbsp;文件信息&nbsp;</a></th>
	<th width="150" class="thCornerR" nowrap="nowrap"><a href="%encoded-folder%?sort=d" class="ServerStats">&nbsp;附加功能&nbsp;</a></th>
  </tr>
  <!-- BEGIN forumrow -->
<tr>
	<td class="row1" align="center" valign="middle" height="50"><a href="" class="messageimagelink"><img src="/template/icons/nofile.gif" width="64" height="64" border="0"/></a></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">哇塞!!当前目录内没有文件哦..</a><br />
	</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> -&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> -<br /><b>修改日期:</b> -</span></td>
	<td class="row1" align="center" valign="middle" height="50">&nbsp;</td>

</tr>
  <!-- END forumrow -->
  <tr> 
  	<td class="v2" colspan="5" height="15"><span class="cattitle" align="right">&nbsp;<div id=folderstats align="right">%number-folders% 目录,  %number-files% 文件 - 总大小: %total-size%</div></span></td>
  </tr>
</table> 

[files]
  <!-- BEGIN catrow -->
  <table width="100%" cellpadding="2" cellspacing="1" border="0" class="forumline">
  <tr> 
	<td class="catLeft" colspan="5" height="28"><span class="cattitle">文件服务器 :: 
<script type="text/javascript">
browseAbleFolderTree("%folder%");
</script>
</span>
<span class=tools style="float:right">
<a href="~folder.tar?recursive">-&gt;当前目录打包下载</a>
</span>
</td>
  </tr>
  <tr>
	<th colspan="2" class="thCornerL" height="20" nowrap="nowrap"><img src="/template/images/spacer.gif" width="64" height="0" /><span class="thTop"><a href="%encoded-folder%?sort=n" class="ServerStats">&nbsp;文件名&nbsp;</a></span></th>
	<th width="215" class="thTop" nowrap="nowrap"><a href="%encoded-folder%?sort=s" class="ServerStats">&nbsp;文件信息&nbsp;</a></th>
	<th width="150" class="thCornerR" nowrap="nowrap"><a href="%encoded-folder%?sort=d" class="ServerStats">&nbsp;附加功能&nbsp;</a></th>
  </tr>
  <!-- BEGIN forumrow -->
  %list%
  <!-- END forumrow -->
  <tr> 
  	<td class="v2" colspan="5" height="15">
	<span class=tools style="float:left">
<a href="~folder.tar?recursive">-&gt;当前目录打包下载</a>
</span>
<span class="cattitle" align="right">&nbsp;<div id=folderstats align="right">%number-folders% 目录,  %number-files% 文件 - 总大小: %total-size%</div></span></td>
  </tr>
</table> 


[file]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/file.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.aiff=file.avi=file.bat=file.doc=file.exe=file.css=file.flv=file.gzip=file.ini=file.m3u=file.mov=file.ogg=file.pdf=file.ppt=file.rar=file.sit=file.sitx=file.swf=file.tar=file.tgz=file.txt=file.wav=file.xls=file.zip]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/%item-ext%.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.bmp]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/bmp.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%" class="highslide" onClick="return hs.expand(this)"><img src="/template/icons/quicklink/magnify.jpg" alt="" border="0" height="16" width="24" /></a>
	<img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.gif]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/gif.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%" class="highslide" onClick="return hs.expand(this)"><img src="/template/icons/quicklink/magnify.jpg" alt="" border="0" height="16" width="24" /></a>
	<img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.htm=file.html]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/html.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.jpg]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/jpg.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%" class="highslide" onClick="return hs.expand(this)"><img src="/template/icons/quicklink/magnify.jpg" alt="" border="0" height="16" width="24" /></a>
	<img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>
</tr>

[file.mp3]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/mp3.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><div id="%item-name%" class="gensmall"><a href="mms://%host%%encoded-folder%%item-url%"><img src="/template/icons/quicklink/wmp.gif" alt="打开本机播放器播放" border=0 height=24 width=24/></a><img src="/template/images/spacer.gif" width=16 height=0/><a style="cursor:pointer;" onClick="loadMp3(this.parentNode.id);"><img src="/template/icons/quicklink/flash.gif" alt="使用内嵌Flash播放器播放" border=0 height=24 width=24/></a><img src="/template/images/spacer.gif" width=16 height=0/><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border=0 height=24 width=24/></a><br /></div>
	</td>
</tr>

[file.mpeg=file.mpg]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/mpeg.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.png]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/png.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%" class="highslide" onClick="return hs.expand(this)"><img src="/template/icons/quicklink/magnify.jpg" alt="" border="0" height="16" width="24" /></a>
	<img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[file.rmvb=file.rm]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/rmvb.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%">
	<a href="rtsp://%host%%encoded-folder%%item-url%"><img src="/template/icons/quicklink/wmp.gif" alt="打开本机播放器播放" border="0" height="24" width="24" /></a><img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a><br /><div id="mp3%item-name%"></div></span></td>
</tr>

[file.wma]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/wma.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall">
	<a href="mms://%host%%encoded-folder%%item-url%"><img src="/template/icons/quicklink/wmp.gif" alt="打开本机播放器播放" border="0" height="24" width="24" /></a><img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a><br /><div id="mp3%item-name%"></div></span></td>
</tr>

[file.wmv]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/wmv.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span><script language="javascript">var top='%item-dl-count%';	if (top > 24) { document.write ("<span class=bluetext>下载次数: %item-dl-count%</span>") }</script></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>文件大小:</b> %item-size%&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%">
	<a href="mms://%host%%encoded-folder%%item-url%"><img src="/template/icons/quicklink/wmp.gif" alt="打开本机播放器播放" border="0" height="24" width="24" /></a><img src="/template/images/spacer.gif" width="16" height="0" /><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a><br /><div id="mp3%item-name%"></div></span></td>
</tr>

[folder]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/folder.gif" width="64" height="64" border="0"/></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>&lt;&lt;目录&gt;&gt;</b>&nbsp;&nbsp;&nbsp;&nbsp;<b>点击率:</b> %item-dl-count%<br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[link]
<tr> 
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-url%" class="messageimagelink"><img src="/template/icons/html.gif" width="64" height="64" border="0"/></a></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-url%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed">%comment%
	</span><span class="genmed">%new%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><b>&lt;&lt;超链接&gt;&gt;</b><br /><b>修改日期:</b> %item-modified%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall"><a href="%item-url%"><img src="/template/icons/quicklink/download.gif" alt="下载该文件" border="0" height="24" width="24" /></a></span></td>

</tr>

[test]
<!-- ICON CONFIGURATION ENDS HERE -->

[comment]
<div class=comment>%item-comment%</div>

[folder-comment]
<div id=foldercomment>%item-comment%</div>

[error-page]
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<title>FileServer :: Error!</title>
<link rel="stylesheet" type="text/css" href="/template/css/style.css" />
<script type="text/javascript" src="/template/java/hfsterayon.js"></script>
<script type="text/javascript">var infoFolder="%folder%"; var infoHost="%host%";</script>
</head>
<body>
<a name="top"></a> 

<table width="80%" cellspacing="0" cellpadding="10" border="0" align="center"> 
<tr> 
<td class="bodyline">
<table width="100%" background="/template/images/top2.jpg" bgcolor="#7A9ADE" cellspacing="0" cellpadding="0" border="0" align="center">
	<tr> 
		<td width="95" align="left"><img src="/template/images/top.jpg" alt="top"></td>
		<td width="100%" align="center"><span class=MessageHeader>Http://%host%/</span></td>
		<td width="95" align="right"><img src="/template/images/top1.jpg" alt="top1"></td>
	</tr>
</table>
<br />

<table class="forumline" width="100%" cellspacing="1" cellpadding="4" border="0">
	<tr> 
		<td class="catLeft" colspan="5" height="28"><span class="cattitle">FileServer :: ERROR</span></td>
	</tr>
	<tr> 
		<td height="23" class="nav1" align="center">
			<span class="nav_top"> 
				<a href="/">首页</a> &#8226; 
				<a href="">刷新</a> &#8226;
				<a href="">当前用户: [%user%]</a> 
				%login-link%
				&#8226; <a href="/template/about.html">About</a> 
			</span>
		</td>
	</tr>
	<tr> 
		<td class="row4">
			<table width="100%" cellspacing="0" cellpadding="1" border="0">
				<tr> 
					<td>&nbsp;</td>
				</tr>
				<tr> 	
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>
<!-- ERROR CONTENT STARTS HERE -->

%content%

<!-- ERROR CONTENT ENDS HERE -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr> 
	  	<td class="v2" colspan="5" height="15">&nbsp;</td>
	</tr>
</table>
<br clear="all" />
<br />
	<table width="100%" cellpadding="3" cellspacing="1" border="0" class="forumline" align="center">
		<tr>
      <td align="right" class="copyright" height="28">
        Powered by <a href="http://192.168.1.88" target="_blank">Http File Server %version% build %build%</a> &copy; 2002, 2006 Rejetto
        <br />
        Terayon Theme v2B.02 <a href="http://192.168.1.88" target="_blank">(phpBB theme)</a> created by <a href="http://192.168.1.88" target="_blank">lithosphere</a>, Converted by <a href="http://192.168.1.88" target="_blank">Giant Eagle v1.2.1</a>, 汉化 by <a href="http://192.168.1.88" target="_blank">Garphy</a>&nbsp;
      </td>
    </tr>
	</table>
</td>
</tr>
</table>
</body>
</html>

[not found]
<div class=MessageHeader>
	4.04 找不到页面!!
</div>
	<br />
<div class=MessageText>
	您所请求的页面暂时无法访问.
	<br /><br />
	请核查链接.
	<br /><br /><br />
	<img src="/~img14" height="15"/><a href="../" class="MessageText"> 返回主页..</a>
	<br />
	&nbsp;
</div>

[overload]
<div class=MessageHeader>
	过载
</div>
	<br />
<div class=MessageText>
	当前服务器负载过大.
	<br /><br />
	请稍后访问.
	<br /><br /><br />
	<img src="/~img14" height="15"/><a href="../" class="MessageText"> 返回主页..</a>
	<br />
	&nbsp;
</div>

[max contemp downloads]
<div class=MessageHeader>
	达到下载限制
</div>
	<br />
<div class=MessageText>
	服务器限制了 <b>并发</b> 下载连接数.
	<br />
	该限制目前已经达到.
	<br /><br />
	请稍后重试.
	<br /><br /><br />
	<img src="/~img14" height="15"/><a href="../" class="MessageText"> 返回主页..</a>
	<br />
	&nbsp;
</div>

[unauthorized]
<div class="MessageHeader">
	未授权
</div>
	<br />
<div class="MessageText">
	请登陆后再访问此页面.
	<br /><br /><br />
	<img src="/~img14" height="15"/><a href="../" class="MessageText"> 返回主页..</a>
	<br />
	 &nbsp;
</div>

[deny]
<div class="MessageHeader">
	禁止
</div>
	<br />
<div class="MessageText">
	您无权访问页面及文件.
	<br /><br /><br />
	<img src="/~img14" height="15"/><a href="../" class="MessageText"> 返回主页..</a>
	<br />
	&nbsp;
</div>

[ban]
<div class="MessageHeader">
	黑名单
</div>
<br />
<div class="MessageText">
	你的IP或帐户别列入黑名单,访问被禁止.
	<br /><br />
</div>
<div class="quote">
	%reason%
</div>
<br />
&nbsp;

[upload]
<!-- This is not used anymore -->

[upload-file]
<!-- This is not used anymore -->

[upload-results]
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<script language="javascript">
document.write ('<title>FileServer :: '+('%folder%'=='/' ? '~Home~' : '%folder-name%')+'</title>');
</script>
<link rel="stylesheet" type="text/css" href="/template/css/style.css" />
<script type="text/javascript" src="/template/java/hfsterayon.js"></script>
<script type="text/javascript">var infoFolder="%folder%"; var infoHost="%host%";</script>
</head>
<body>
<a name="top"></a> 
<table width="80%" cellspacing="0" cellpadding="10" border="0" align="center"> 
<tr> 
<td class="bodyline">
<table width="100%" background="/template/images/top2.jpg" bgcolor="#7A9ADE" cellspacing="0" cellpadding="0" border="0" align="center">
	<tr> 
		<td width="95" align="left"><img src="/template/images/top.jpg" alt="top"></td>
		<td width="100%" align="center"><span class=MessageHeader>Http://%host%/</span></td>
		<td width="95" align="right"><img src="/template/images/top1.jpg" alt="top1"></td>
	</tr>
</table>
<br />

<table class="forumline" width="100%" cellspacing="1" cellpadding="4" border="0">
	<tr> 
		<td class="catLeft" colspan="5" height="28"><span class="cattitle">文件服务器 ::上传状态</span></td>
	</tr>
	<tr> 
		<td height="23" class="nav1" align="center">
			<span class="nav_top"> 
				<a href="/">首页</a> &#8226; 
				<a href="">刷新</a> &#8226; 
				<a href="">当前用户: [%user%]</a> 
				%login-link% 
			</span>
		</td>
	</tr>
	<tr> 
		<td class="row4">
		    <table width="100%" cellspacing="0" cellpadding="1" border="0">
			<tr> 
				<td>&nbsp;</td>
			</tr>
			<tr> 	
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><span class="MessageHeader">已上传文件:</span>
				<br /><br />
				<span class="MessageText">已成功上传文件如下:</span><br /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		    </table>
		</td>
	</tr>
	<tr> 
	  	<td class="v2" colspan="5" height="15">&nbsp;</td>
	</tr>
</table>
<br />
	<table width="100%" cellpadding="2" cellspacing="1" border="0" class="forumline">
		<tr> 
			<td class="catLeft" colspan="5" height="28">
				<span class="cattitle">文件服务器 :: 
<script type="text/javascript">
browseAbleFolderTree("%folder%");
</script>
			</td>
		</tr>
  		<tr> 
			<th colspan="2" class="thCornerL" height="20" nowrap="nowrap">&nbsp;</th>
			<th width="65" class="thTop" nowrap="nowrap">&nbsp;文件大小&nbsp;</th>
			<th width="85" class="thTop" nowrap="nowrap">平均速度</th>
			<th class="thCornerR" nowrap="nowrap">&nbsp;成功 / 失败&nbsp;</th>
		</tr>
			<!-- BEGIN forumrow -->
			%uploaded-files%
			<!-- END forumrow -->
		<tr> 
  			<td class="v2" colspan="5" height="15">&nbsp;</td>
		</tr>
	</table> 
<br />
	<table width="100%" cellpadding="3" cellspacing="1" border="0" class="forumline" align="center">
		<tr>
      <td align="right" class="copyright" height="28">
        Powered by <a href="http://192.168.1.88" target="_blank">Http File Server %version% build %build%</a> &copy; 2002, 2006 Rejetto
        <br />
        Terayon Theme v2B.02 <a href="http://192.168.1.88/" target="_blank">(phpBB theme)</a> created by <a href="http://192.168.1.88/" target="_blank">lithosphere</a>, Converted by <a href="http://192.168.1.88" target="_blank">Giant Eagle v1.2.1</a>, 汉化 by <a href="http://bbs.78820.com" target="_blank">Garphy</a>&nbsp;
      </td>
    </tr>
	</table>
</td>
</tr>
</table>
</body>
</html>

[upload-success]
<tr>
	<td class="row1" align="center" valign="middle" height="50"><a href="%item-name%" class="messageimagelink"><img src="/template/icons/file.gif" width="64" height="64" border="0"/></a></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="%item-name%" class="forumlink">%item-name%</a><br />
	</span><span class="genmed"></span><div class="redtext"><i>新增文件!!</i></div></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall">%item-size%</span></td>
	<td class="row1" align="center" valign="middle" height="50"><span class="gensmall">%speed% KB/s</span></td>
	<td class="row1" align="center" valign="middle" height="50" nowrap="nowrap"><span class="UploadSuccesfull">成功</span></td>
</tr>

[upload-failed]
<tr>
	<td class="row1" align="center" valign="middle" height="50"><a href="" class="messageimagelink"><img src="/template/icons/nofile.gif" width="64" height="64" border="0"/></a></td>
	<td class="row6h" width="100%" height="50"><span class="forumlink"> <a href="" class="forumlink">%item-name%</a><br />
	</span><span class="genmed"></span></td>
	<td class="row1" align="center" valign="middle" height="50" colspan="2"><span class="gensmall">%reason%</span></td>
	<td class="row1" align="center" valign="middle" height="50" nowrap="nowrap"><span class="UploadFailed">失败</span></td>
</tr>

[upload+progress]
<!-- Not used anymore -->

[test]
<!-- backup of [upload+progress] -->
<html>
<head>
<frameset cols=200,*>
 <frame name=progress src="/~progress" scrolling=auto marginwidth=0>
 <frame src="%encoded-folder%~upload-no-progress" scrolling=auto>
</frameset><noframes></noframes>
</head>
<body>
</body>
</html>

[progress]
<!-- Not used anymore -->

[test]
<!-- backup of [progress] -->
<html>
<head>
<meta http-equiv="Refresh" content="7;URL=/~progress">
<title>HFS - Progress status</title>
<style>
%style%
.filename { font-weight:bold; font-size:8pt; }
.bytes { font-size:7pt; }
.perc { font-size:14px; vertical-align:middle; }
.out_bar { width:100px; font-size:15px; background:black; border:black 1px solid; margin-right:5px; float:left; }
.in_bar { height:16px; background:white; color:white;  }
#body { margin-left:0; margin-right:0; }
body { padding:2px; }
#graph { border:white outset 2px; }
</style>
</head>
<body>
<div class=big>状态条</div>
自动刷新间隔: 7 秒
<br /><br /><img src="/~img_graph190x40" id="graph" />
<div id=body>
%progress-files%
</div>
<div id=footer>在线时长: %uptime%</div>
</body>
</html>

[progress-nofiles]
<!-- Not used anymore -->

[test]
<!-- backup of [progress-nofiles] -->
<div class=big>当前无文件流量.</div>

[progress-upload-file]
<!-- Not used anymore -->

[test]
<!-- backup of [progress-upload-file] -->
<span class=flag>&nbsp;上传&nbsp;</span>
<span class=filename>%filename%</span>
<div class=bytes>
%done-bytes% / %total-bytes% bytes
<br />速度: %speed-kb% KB/s
</div>
<div style="margin-top:5px; margin-bottom:20px;">
  <div class=out_bar><div class=in_bar style="width:%perc%px"></div></div> <span class=perc>%perc%%</span>
</div>

[progress-download-file]
<!-- Not used anymore -->

[test]
<!-- backup of [progress-download-file] -->
<span class=flag>&nbsp;下载&nbsp;</span>
<span class=filename>%filename%</span>
<div class=bytes>
%done-bytes% / %total-bytes% bytes
<br />速度: %speed-kb% KB/s
</div>
<div style="margin-top:5px; margin-bottom:20px;">
  <div class=out_bar><div class=in_bar style="width:%perc%px"></div></div> <span class=perc>%perc%%</span>
</div>

[newfile]
<div class="redtext"><i>新增文件!!</i></div>
