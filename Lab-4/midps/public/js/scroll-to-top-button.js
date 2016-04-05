
$(document).ready(function(){
	
	//Check to see if the window is top if not then display button
	$(window).scroll(function(){
		if ($(this).scrollTop() > 100) {
			$('.scroll-to-top').fadeIn();
		} else {
			$('.scroll-to-top').removeClass('scroll-to-top-active');
			$('.scroll-to-top').fadeOut();
		}
	});
	
	//Click event to scroll to top
	$('.scroll-to-top').click(function(){
		$(this).addClass('scroll-to-top-active');
		$('html, body').animate({scrollTop : 0},800);
		return false;
	});
	
});

