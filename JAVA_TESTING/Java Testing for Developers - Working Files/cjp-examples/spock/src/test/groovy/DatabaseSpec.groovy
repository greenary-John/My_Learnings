import groovy.sql.Sql
import spock.lang.*

class DatabaseSpec extends Specification {
	@Shared def db = 
		[url:'jdbc:postgresql:javatest', user:'javatest', password:'xecret', driver:"org.postgresql.Driver"]
	@Shared def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

	def "DatabaseTest"() {
		setup:
			def found = false
			sql.eachRow("select name from javatest order by lower(name)") { r->
				// println r.name
				if (r.name == 'spock') {
					found = true;
				}
			}
		expect:
			found
	}
}
