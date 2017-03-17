import spock.lang.*;

class SpockWithWhereSpec extends Specification {
	def "Test of Squares"() {
		expect:
			value * value == square

		where:
			value | square
				1 |      1
				2 |      4
				3 |      9
	}
}
