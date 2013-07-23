grails.servlet.version = "2.5"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
	inherits("global")
	log "warn"
	checksums true
	def gebVersion = '0.9.0'
	def seleniumVersion = '2.21.0'
	def spockVersion = '0.7'
	repositories {
		inherits true
		grailsPlugins()
		grailsHome()
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}
	dependencies {
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") { exclude "xml-apis" }
		test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
		test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion")

		test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
		test "org.gebish:geb-spock:$gebVersion"
	}
	plugins {
		
		test 	":remote-control:1.4", {export = false}
		test 	":spock:$spockVersion",{ export= false}
		test	":geb:$gebVersion",{ export= false}
		
		build(":tomcat:$grailsVersion",":release:2.2.0",":rest-client-builder:1.0.3") { export = false }
		compile ":hibernate:$grailsVersion"
	}
}

grails.release.scm.enabled = false
