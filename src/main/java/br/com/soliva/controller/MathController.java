package br.com.soliva.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.soliva.exception.UnsuportedMathOperationException;
import br.com.soliva.math.SimpleMath;
import br.com.soliva.request.converters.NumberConverter;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value! ");
		}
		return math.sum(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value! ");
		}
		return math.subtraction(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value! ");
		}
		return math.multiplication(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo) );
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value! ");
		}
		return math.division(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo) );
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value! ");
		}
		return math.mean(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo) / 2);
	}
	
	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot( @PathVariable("number") String number) throws Exception {
		if( !NumberConverter.isNumeric(number) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value! ");
		}
		
		return math.squareRoot(NumberConverter.convertDouble(number));
	}
}