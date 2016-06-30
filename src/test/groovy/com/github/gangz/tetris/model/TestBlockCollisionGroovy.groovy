package com.github.gangz.tetris.model
import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestBlockCollisionGroovy {
	@Test
	void indexOutOfBoundsAccess() {
		def numbers = [1,2,3,4]
		shouldFail {
			numbers.get(4)
		}
	}
}
