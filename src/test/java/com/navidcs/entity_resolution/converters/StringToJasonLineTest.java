/**
 * 
 */
package com.navidcs.entity_resolution.converters;
import com.navidcs.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.*;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author navid
 *
 */
public class StringToJasonLineTest {



	/**
	 * Test method for {@link com.navidcs.entity_resolution.converters.StringToJasonLine#StringToJasonLine(java.lang.String, com.fasterxml.jackson.databind.ObjectMapper)}.
	 */
	
	@Test
	public final void testStringToJasonLine() {
		StringToJasonLine stringToJasonLine = new StringToJasonLine("{\"product_name\":\"Samsung_TL240\",\"manufacturer\":\"Samsung\",\"model\":\"TL240\",\"announced-date\":\"2010-01-05T19:00:00.000-05:00\"}", new ObjectMapper());
		
		assertEquals("{\"product_name\":\"Samsung_TL240\",\"manufacturer\":\"Samsung\",\"model\":\"TL240\",\"announced-date\":\"2010-01-05T19:00:00.000-05:00\"}", stringToJasonLine.getLine());
		
	}

	/**
	 * Test method for {@link com.navidcs.entity_resolution.converters.StringToJasonLine#getJsonNode()}.
	 */
	
	@Test
	public final void testGetJsonNode() {
		
		StringToJasonLine stringToJasonLine = new StringToJasonLine("{\"title\":\"Canon PowerShot A1200 (Black)\""
				+ ",\"manufacturer\":\"Canon Canada\",\"currency\":\"CAD\",\"price\":\"129.99\"}", new ObjectMapper());
		stringToJasonLine.run();
		assertEquals("Canon Canada", stringToJasonLine.getJsonNode().get("manufacturer").asText());
	
	}

}
