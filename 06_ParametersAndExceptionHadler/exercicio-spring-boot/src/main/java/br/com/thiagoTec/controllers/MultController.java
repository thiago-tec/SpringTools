package br.com.thiagoTec.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagoTec.exceptions.UnsupportedMathOperationException;
import br.com.thiagoTec.rules.RuleConversion;
import br.com.thiagoTec.rules.RuleIsNumeric;

@RestController
public class MultController {

	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET) // especificando que esse
																							// metodo é do tipo get
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!RuleIsNumeric.isNumeric(numberOne) || !RuleIsNumeric.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return RuleConversion.convertToDouble(numberOne) * RuleConversion.convertToDouble(numberTwo);
	}

}
