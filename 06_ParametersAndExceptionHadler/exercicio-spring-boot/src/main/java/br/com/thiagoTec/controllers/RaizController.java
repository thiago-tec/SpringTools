package br.com.thiagoTec.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagoTec.exceptions.UnsupportedMathOperationException;
import br.com.thiagoTec.rules.RuleConversion;
import br.com.thiagoTec.rules.RuleIsNumeric;

@RestController
public class RaizController {

	@RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET) // especificando que esse metodo é do tipo
																				// get
	public Double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception {

		if (!RuleIsNumeric.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		Double raiz = RuleConversion.convertToDouble(numberOne);

		return Math.sqrt(raiz);
	}

}
