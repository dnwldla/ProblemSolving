# [Silver III] 한국이 그리울 땐 서버에 접속하지 - 9996 

[문제 링크](https://www.acmicpc.net/problem/9996) 

### 성능 요약

메모리: 14372 KB, 시간: 104 ms

### 분류

정규 표현식, 문자열

### 제출 일자

2024년 12월 3일 15:34:01

### 문제 설명

<p>선영이는 이번 학기에 오스트레일리아로 교환 학생을 가게 되었다. </p>

<p>호주에 도착하고 처음 며칠은 한국 생각을 잊으면서 즐겁게 지냈다. 몇 주가 지나니 한국이 그리워지기 시작했다. </p>

<p>선영이는 한국에 두고온 서버에 접속해서 디렉토리 안에 들어있는 파일 이름을 보면서 그리움을 잊기로 했다. 매일 밤, 파일 이름을 보면서 파일 하나하나에 얽힌 사연을 기억하면서 한국을 생각하고 있었다.</p>

<p>어느 날이었다. 한국에 있는 서버가 망가졌고, 그 결과 특정 패턴과 일치하는 파일 이름을 적절히 출력하지 못하는 버그가 생겼다.</p>

<p>패턴은 알파벳 소문자 여러 개와 별표(*) 하나로 이루어진 문자열이다.</p>

<p>파일 이름이 패턴에 일치하려면, 패턴에 있는 별표를 알파벳 소문자로 이루어진 임의의 문자열로 변환해 파일 이름과 같게 만들 수 있어야 한다. 별표는 빈 문자열로 바꿀 수도 있다. 예를 들어, "abcd", "ad", "anestonestod"는 모두 패턴 "a*d"와 일치한다. 하지만, "bcd"는 일치하지 않는다.</p>

<p>패턴과 파일 이름이 모두 주어졌을 때, 각각의 파일 이름이 패턴과 일치하는지 아닌지를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 파일의 개수 N이 주어진다. (1 ≤ N ≤ 100)</p>

<p>둘째 줄에는 패턴이 주어진다. 패턴은 알파벳 소문자와 별표(아스키값 42) 한 개로 이루어져 있다. 문자열의 길이는 100을 넘지 않으며, 별표는 문자열의 시작과 끝에 있지 않다.</p>

<p>다음 N개 줄에는 파일 이름이 주어진다. 파일 이름은 알파벳 소문자로만 이루어져 있고, 길이는 100을 넘지 않는다.</p>

### 출력 

 <p>총 N개의 줄에 걸쳐서, 입력으로 주어진 i번째 파일 이름이 패턴과 일치하면 "DA", 일치하지 않으면 "NE"를 출력한다.</p>

<p>참고로, "DA"는 크로아티어어로 "YES"를, "NE"는 "NO"를 의미한다.</p>

---

### 소감

***1) 문법***
  * 앞 패턴과 * 뒤 패턴을 추출해서 문자에 패턴들이 있는지 확인하는 문제이다. 따라서 문자의 인덱스를 설정하고 substring.equals를 사용하였다. But,, startsWith, endsWith
     내장함수가 존재하였다. 이거 쓰자!
    <리팩토링 전>
     ``` java
     
     int endPatternStartIdx=word.length()-endPatternSize;
        if(word.substring(0,idx).equals(startPattern)&& word.substring(endPatternStartIdx,word.length()).equals(endPattern)){
                System.out.println("DA");
            }
     ```

    <리팩토링 후>
    ``` java
    if(word.startsWith(startPattern)&& word.endsWith(endPattern)){
                System.out.println("DA");
            }
    ```
    
    

***2) StringIndexOutOfBounds***   
   범위초과 오류가 발생하였다. 암호 패턴 길이가 파일 길이보다 크면 발생하는 문제이다.

   기존 로직에서
   ```java
    if(word.substring(0,idx).equals(startPattern)&& word.substring(endPatternStartIdx,word.length()).equals(endPattern))
   ```
   endPatternStartIdx가 word 길이보다 크면 이런 오류가 발생한다.

   반례찾기는 어렵기 때문에 계속 부딪히며 데이터들을 쌓아야겠다. 

