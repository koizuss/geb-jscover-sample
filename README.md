# geb-jscover-sample

Geb Specで実行されるJavaScriptのカバレッジをJSCoverで取得してみる

- クライアントJavaScriptのテストにGebSpecを使った場合のカバレッジがとりたい
- 一旦ブラウザはChromeのみ

## setup & execute

1. setup chromedriver
  <pre>
  ./gradlew setup
  </pre>

2. start jscover
  <pre>
  java -jar tools/jscover/JSCover-0.3.0/target/dist/JSCover-all.jar -ws --proxy --port=9999 --report-dir=build/reports/jscover
  </pre>

3. testing
  <pre>
  ./gradlew clean test
  </pre>

4. show coverage
  1. カバレッジを表示する為に *--allow-file-access-from-files* オプションが必要
    - Mac OS:
        <pre>
        /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --allow-file-access-from-files
        </pre>

  2. *open ./report/jscoverage.html*

## TODO

- gebでテストした全てのカバレッジをまとめて出力
- jscoverのセットアップをgradleで実行
- jscoverの起動/停止をgradleで実行
