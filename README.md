# geb-jscover-sample

Geb Specで実行されるJavaScriptのカバレッジをJSCoverで取得してみる

- クライアントJavaScriptのテストにGebSpecを使った場合のカバレッジがとりたい
- 一旦ブラウザはChromeのみ

## usage

1. testing
  <pre>
  ./gradlew clean test
  </pre>
  - download & setup chromedriver when first

2. show coverage
  1. カバレッジを表示する為に *--allow-file-access-from-files* オプションが必要
    - Mac OS:
        <pre>
        /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --allow-file-access-from-files
        </pre>

  2. *open ./build/reports/jscoverage/jscoverage.html*

## TODO

- 複数テストの結果が集約出来るか確認
- setup jscover on gradle
