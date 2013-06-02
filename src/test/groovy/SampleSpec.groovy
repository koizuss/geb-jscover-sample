import geb.spock.GebSpec
import org.openqa.selenium.JavascriptExecutor

class SampleSpec extends GebSpec {

    def setup() {
        go 'http://127.0.0.1/geb-jscover-sample/index.html'
    }

    def "初期表示"() {
        expect:
            $('div#target', text: '')
    }

    def "テキスト変更"() {
        when:
            js.change(message)

        then:
            $('div#target', text: message)

        where:
            message << [
                'test',
                'hoge',
                'hello'
            ]
    }
}