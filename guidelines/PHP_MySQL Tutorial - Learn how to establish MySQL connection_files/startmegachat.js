var chatUrl = 'https://siteground.chat-assistance.com/request';
var windowParams = 'toolbar=no, scrollbars=yes, status=no, resizable=yes, location=no, menubar=no, directories=no, width=768, height=720';

function Live()
{
	this.chatwin = false;
//	this.refurl = escape(document.referrer);
	this.page = escape(document.location.href);

	this.verification = function( oid ) 
	{
		var url = chatUrl + '?verify=1&oid=' + oid + '&page=' + this.page;
		this.chatwin = window.open( url, 'guest_0', windowParams);
	}

	this.launch = function() 
	{
		var url = chatUrl + '?page=' + this.page;

		if ( typeof( locale_id ) !== 'undefined' )
			url += '&locale_id=' + locale_id;
		if ( typeof( chatpromo ) !== 'undefined' )
			url += '&promo=' + chatpromo;
		if ( typeof( cur_code ) !== 'undefined' )
			url += '&cur_code=' + cur_code;
		if ( typeof( local_phone ) !== 'undefined' )
			url += '&local_phone=' + local_phone;

		this.chatwin = window.open( url, 'guest_0', windowParams);
		if (this.chatwin.opener == null)
			this.chatwin.opener = self;
	}
}

var Live = new Live();