/*
var Brewer = Brewer || {};

Brewer.MaskMoney = (function() {
	
	function MaskMoney() {
		this.decimal = $('.js-formatoDecimal');
		this.plain = $('.js-formatoInteiro'');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.plain.maskMoney({ precision: 0, thousands: '.' });
	}
	
	return MaskMoney;
	
})();

$(function() {
	var maskMoney = new Brewer.MaskMoney();
	maskMoney.enable();
});
*/

$(function(){
	$('.js-formatoDecimal').maskMoney({
	    								thousands: '.', //Define o separador de milhar como ponto
									    decimal: ',' //Define o separador de decimal como vírgula
									 })
									 
	$('.js-formatoInteiro').maskMoney({  precision: 0
										,thousands: '.'
									 })
})
