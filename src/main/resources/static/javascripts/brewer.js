$(function(){
	$('.js-formatoDecimal').maskMoney({
	    								thousands: '.', //Define o separador de milhar como ponto
									    decimal: ',' //Define o separador de decimal como vírgula
									 })
									 
	$('.js-formatoInteiro').maskMoney({  precision: 0
										,thousands: '.'
									 })
})