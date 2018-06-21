/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package businessLayer

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import domainLayer.RomanNumerical
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired

import groovy.json.*;
import spock.lang.Specification
import spock.lang.Unroll


/**
 * @author eaamrvd
 *
 */

class ConverterControllerTest extends Specification {

	Converter theConverter;
	ConverterController theConverterController;
	RomanNumerical theRomanNumerical;

	@Test
	@Unroll
	def'when #numericOne and #numericTwo are passed as Strings #expected is returned as a String'() {

		given:
		theRomanNumerical = new RomanNumerical();
		theConverter=new Converter(numericals:theRomanNumerical);
		theConverterController = new ConverterController(converter:theConverter);

		when: 'when two roman numericals are passed as Strings'
		def result = theConverterController.performConversion(numericOne, numericTwo);

		then: ' sum of both numericals is returned in roman numerical form as a String'
		assertEquals(expected, result)

		where:
		numericOne	| numericTwo || expected
		"D"			| "D"		 || "M"
		"CD"		| "D"		 || "CM"
		"CCL"		| "CCL"		 || "D"
		"CC"		| "CC"		 || "CD"
		"L"			| "L"		 || "C"
		"L"			| "XL"		 || "XC"
		"XXV"		| "XXV"		 || "L"
		"XX"		| "XX"		 || "XL"
		"V"			| "V"		 || "X"
		"V"			| "IV"		 || "IX"
		"IV"		| "I"		 || "V"
		"II"		| "II"		 || "IV"
		"I"			| "I"		 || "II"
	}
}
