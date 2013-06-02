# geb-jscover-sample

Geb SpecのカバレッジをJSCoverで取得してみる

- 一旦ブラウザはChromeのみ

## feature

- JSCover(proxy mode)を使ってカバレッジ取得（gebはまだ使ってない...）

## setup & execute

1. setup chromedriver
  <pre>
  ./gradlew setup
  </pre>

2. start jscover
  <pre>
  java -jar tools/jscover/JSCover-0.3.0/target/dist/JSCover-all.jar -ws --proxy --port=9999 --report-dir=report --document-root=../src/main/webapp/
  </pre>

3. start target web server
  <pre>
  ./gradlew jR
  </pre>
  - start *http://127.0.0.1:8080/geb-jscover-sample* on jetty server

4. setting proxy

    setting http proxy on your browser: *http://localhost:9999*

5. open target page

    *open http://127.0.0.1:8080/geb-jscover-sample/index.html*

    - *--allow-file-access-from-files* オプションが必要
        - Mac OS:
        <pre>
            /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --allow-file-access-from-files
        </pre>

6. testing
    1. input *some message* on input box
    2. click *change button*

7. out report

    execute JavaScript on target page
    <pre>
    jscoverage_report('.')
    </pre>

8. show coverage

    *open ./report/jscoverage.html*

## TODO

- gebで実行するブラウザ(chrome)に以下を設定して起動
    - jscover porxy
    - --allow-file-access-from-files
- geb上でjscover report出力
- gebでテストした全てのカバレッジをまとめて出力
- jscoverのセットアップをgradleで実行
- jscoverの起動/停止をgradleで実行