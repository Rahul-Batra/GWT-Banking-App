package com.rahul.BMS.shared;
public class JSNIutility {
	
public  static native void regex(String s) /*-{
$wnd.regex(s);
}-*/;

public static native void validate(String l)/*-{
$wnd.validate(l);
}-*/;

public static native void alertmsg() /*-{
$wnd.alertmsg();
}-*/;




}
